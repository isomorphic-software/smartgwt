package com.smartgwt.sample.showcase.client.gwtintegration;

import com.google.gwt.user.client.ui.Composite;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class CompositeWidgetSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click to select a DataSource, click on records to edit them in the adjacent form, then click the \"Save\" button to save changes. This custom component combines a databound form and grid into a reusable application pattern of side-by-side editing, that can be used with any DataSource.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            CompositeWidgetSample panel = new CompositeWidgetSample();
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
        final DataSource countryDS = CountryXmlDS.getInstance();
        final DataSource supplyItemDS = SupplyCategoryXmlDS.getInstance();
        
        final CompoundEditor cEditor = new CompoundEditor(countryDS);
        

        SelectItem dsSelect = new SelectItem();
        dsSelect.setName("datasource2");
        dsSelect.setShowTitle(false);
        dsSelect.setValueMap("country", "supply");
        dsSelect.addChangedHandler(new ChangedHandler() {

            public void onChanged(ChangedEvent event) {
                String ds = (String)event.getValue();
                if(ds.equalsIgnoreCase("country")) {
                    cEditor.setDatasource(countryDS);
                } else {
                    cEditor.setDatasource(supplyItemDS);
                }                
            }
        });
        DynamicForm form = new DynamicForm();
        form.setValue("datasource2", "Select a DataSource");
        form.setItems(dsSelect);
        
        VLayout layout = new VLayout(15);
        layout.addMember(form);
        layout.addMember(cEditor);
        return layout;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    
    private static class CompoundEditor extends Composite {
        private DataSource datasource;
        private DynamicForm form;
        private ListGrid grid;
        private IButton saveButton;

        public CompoundEditor(DataSource datasource) {
            super();
            this.datasource = datasource;
            this.form = new DynamicForm();
            form.setDataSource(datasource);           
            
            saveButton = new IButton("Save");
            saveButton.setLayoutAlign(Alignment.CENTER);
            saveButton.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    form.saveData();
                }               
            });
            
            VLayout editorLayout = new VLayout(5);
            editorLayout.addMember(form);
            editorLayout.addMember(saveButton);
            
            grid = new ListGrid();
            grid.setWidth(500);
            grid.setHeight(350);
            grid.setDataSource(datasource);
            grid.setShowResizeBar(true);
            grid.setAutoFetchData(true);
            grid.addRecordClickHandler(new RecordClickHandler() {

                public void onRecordClick(RecordClickEvent event) {
                    form.clearErrors(true);
                    form.editRecord(event.getRecord());
                    saveButton.enable();
                }
                
            });
            HLayout hLayout = new HLayout();
            hLayout.setAutoWidth();
            hLayout.addMember(grid);
            hLayout.addMember(editorLayout);
             // All composites must call initWidget() in their constructors.
            initWidget(hLayout);
        }

        public DataSource getDatasource() {
            return datasource;
        }

        public void setDatasource(DataSource datasource) {
            this.datasource = datasource;
            grid.setDataSource(datasource);
            form.setDataSource(datasource);
            saveButton.disable();
            grid.fetchData();
        }               
    }
}