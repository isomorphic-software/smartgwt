package com.smartgwt.sample.showcase.client.grid.sortfilter;

import java.util.HashSet;
import java.util.Set;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.ResultSet;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class LoadedValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sometimes, in the Filter Editor, you want to show a dropdown "+
    "with <i>only</i> the values that are currently present in the dataset."+
    "<p>"+
    "This is easy to ask for, but tricky to implement when datasets are large and data paging is being used, "+
    "since the ideal implementation should:"+
    "<ul>"+
    "<li> use the data already loaded in the grid <i>if all rows matching the current criteria</i> have been loaded</li>"+
    "<li> otherwise, go to the server to discover all distinct values, but with <i>criteria matching the grid's criteria</i></li>"+
    "<li> properly update the list of values in the filter if criteria are changed or new records are added</li>"+
    "</ul>"+
    "The code for this sample shows the amazing power &amp; flexibility of the SmartGWT data binding architecture:"+
    "<ul>"+
    "<li> the <i>facade DataSource</i> pattern is used to create a DataSource that <i>either</i> works with data already loaded, "+
    "<i>or</i> uses the original DataSource to retrieve all distinct values</li>"+
    "<li> the <i>Server Summaries</i> feature is used so that we can request all distinct values within the matching records, "+
    "without needing to write any new server code for this sample</li>"+
    "<li> utility methods like <code>compareCriteria()</code> make it simple to detect when the list of distinct values "+
    "has gone stale and needs to be recalculated or re-fetched</li>"+
    "</ul>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            LoadedValuesSample panel = new LoadedValuesSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {

        final DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();
       
        final ListGrid listGrid = new ListGrid();

        // Create a new custom DataSource to populate the category filter item based on either
        // the fully loaded data set within the ListGrid, or the result of a fetch against the
        // supplyItem dataSource if that isn't available
        DataSource categoryDS = new DataSource() {
           
            public AdvancedCriteria currentCriteria;
            public Record[] currentData;
           
            // transformRequest - invoked for all operations against this dataSource
            @Override
            protected Object transformRequest(final DSRequest dsRequest) {
               
                Record[] records = null;
                final AdvancedCriteria listGridCriteria = listGrid.getFilterEditorCriteriaAsAdvancedCriteria();

                // If we've already got a local set of records that match the criteria for the associated ListGrid
                // use them.
                if (currentData != null && compareCriteria(listGridCriteria, currentCriteria) == 0) {
                    records = currentData;
                // Otherwise, if the list grid has a full set of cached rows for the current criteria, extract
                // the criteria values from those records
                } else {
                    ResultSet resultSet = listGrid.getResultSet();
                    if (resultSet != null && resultSet.allMatchingRowsCached()) {
                        records = getCategoryRecords(listGrid.getRecords());
                        this.updateCurrentData(listGridCriteria, records);
                    }
                }
                if (records != null) {
                   DSResponse dsResponse = new DSResponse();
                   dsResponse.setStatus(0);
                   dsResponse.setData(records);
                   
                   processResponse(dsRequest.getRequestId(), dsResponse);

                // Lastly, if we didn't already have records locally, issue a fetch to retrieve records from the server
                } else {
                    DSRequest request = new DSRequest(DSOperationType.FETCH);
                    request.setGroupBy("category");
                    supplyItemDS.fetchData(
                        listGridCriteria,
                        new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest request) {
                            	// because in the LGPL Showcase, this is a clientOnly DataSource, this request is still being handled 
                            	// client-side. However in a real app, this DataSource would contact the server.                            	
                            	updateCurrentData(listGridCriteria, dsResponse.getDataAsRecordList().toArray());
                                processResponse(dsRequest.getRequestId(), dsResponse);
                            }
                        }, request
                    );
                }
                return dsRequest.getData();
            }
           
            // Helper to store out the current criteria and matching records
            public void updateCurrentData (AdvancedCriteria criteria, Record[] data) {
                currentCriteria = criteria;
                currentData = data;
            }
           
        };
        // This is a clientCustom type dataSource
        categoryDS.setDataProtocol(DSProtocol.CLIENTCUSTOM);
        categoryDS.setClientOnly(true);
       
        // We only store one field for this dataSource
        DataSourceTextField categoryField = new DataSourceTextField("category", "category");  
        categoryDS.setFields(categoryField);
       
        // Application code to set up the ListGrid
       
        listGrid.setWidth(800);
        listGrid.setHeight(450);
        listGrid.setShowFilterEditor(true);
        listGrid.setShowAllColumns(true);
        listGrid.setAutoFetchData(true);
        listGrid.setDataSource(supplyItemDS);
       
        // Force a fetch on the category filter's pickList when we get new data in the listGrid.
        // If the criteria have changed this may lead to a new fetch against the server
        listGrid.addDataArrivedHandler(new DataArrivedHandler() {
           
            @Override
            public void onDataArrived(DataArrivedEvent event) {
                // Force a re-fetch on the selectItem pickList
                SelectItem item = (SelectItem)listGrid.getFilterEditor().getEditFormItem("category");
                item.fetchData();                
            }
        });
       
        SelectItem selectCategories = new SelectItem();
        selectCategories.setName("category");
        selectCategories.setOptionDataSource(categoryDS);
        selectCategories.setValueField("category");
        selectCategories.setAutoFetchData(false);
       
        ListGridField selectCategoriesField = new ListGridField();
        selectCategoriesField.setName("category");
        selectCategoriesField.setFilterEditorProperties(selectCategories);
        ListGridField itemNameField = new ListGridField("itemName");
        ListGridField SKUField = new ListGridField("SKU");
       
        listGrid.setFields(selectCategoriesField, itemNameField, SKUField);
       
        return listGrid;
    }

    private Record[] getCategoryRecords(Record[] records) {
    	Set<String> categorySet = new HashSet<>();
        for (Record record : records) {
            categorySet.add(record.getAttribute("category"));
        }
        Record[] groupedRecords = new Record[categorySet.size()];
        int i = 0;
        for (String value : categorySet) {
        	ListGridRecord rec = new ListGridRecord();
            rec.setAttribute("category", value);
            groupedRecords[i++] = rec;
        }  
        return groupedRecords;
	}

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}