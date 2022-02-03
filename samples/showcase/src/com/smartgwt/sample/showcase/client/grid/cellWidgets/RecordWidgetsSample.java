package com.smartgwt.sample.showcase.client.grid.cellWidgets;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RecordComponentPoolingMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class RecordWidgetsSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Grids can embed any desired component below the normal cells. Here, a Label is used under "+
            "each record, to show a long text field."+
            "<p>"+
            "This example uses record component pooling - the same set of Label components is reused as "+ 
            "you scroll, so that it is only necessary to create as many Labels as there are <i>visible</i> rows."+  
            "This approach can easily scale to millions of rows. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RecordWidgetsSample panel = new RecordWidgetsSample();
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
        ListGrid itemList = new ListGrid() {
            @Override    
            protected Canvas createRecordComponent(ListGridRecord record, Integer colNum) {
                final ListGrid grid = this; 
                Label editImg = new Label();
                editImg.setLayoutAlign(Alignment.CENTER);
                editImg.setContents(record.getAttribute("background"));
                editImg.setWrap(true);
                editImg.setHeight(grid.getDrawnRowHeight(grid.getRowNum(record)));
				
                return editImg;
            }
			
            @Override
            public Canvas updateRecordComponent(ListGridRecord record, Integer colNum, Canvas component, boolean recordChanged) {
                final ListGrid grid = this; 
                Label labelComponent = (Label)component;
                if (recordChanged) { 	
                    labelComponent.setContents(record.getAttribute("background"));
                    labelComponent.setHeight(grid.getDrawnRowHeight(grid.getRowNum(record)));	
                }
                return labelComponent;
            }
        };
        itemList.setWidth(750);
        itemList.setHeight(500);
        itemList.setCanResizeFields(true);
        itemList.setShowRecordComponents(true);    
        itemList.setCanRemoveRecords(true);  
        itemList.setRecordComponentPoolingMode(RecordComponentPoolingMode.RECYCLE);
        itemList.setData(CountryData.getRecords());
		
        ListGridField countryCodeField = new ListGridField();
        countryCodeField.setName("countryCode");
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setTitle("Flag");
        countryCodeField.setWidth(40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        
        ListGridField countryNameField = new ListGridField();
        countryNameField.setName("countryName");
        countryNameField.setTitle("Country");
        ListGridField capitalField = new ListGridField();
        capitalField.setName("capital");
        capitalField.setTitle("Capital");
        ListGridField continentField = new ListGridField();
        continentField.setName("continent");
        continentField.setTitle("Continent");
        
        itemList.setFields(countryCodeField,countryNameField,capitalField,continentField);
        
        itemList.draw();

        return itemList;
    }

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }  
    
    public String getIntro() {
        return DESCRIPTION;
    }
}
