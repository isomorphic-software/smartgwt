package com.smartgwt.sample.showcase.client.grid.expando;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class GridRowExpansionEditorSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>This grid displays a limited number of fields from the supplyItem dataSource.</p>" +
                    "<p>You can expand a row by clicking the special expansionField to see a DetailViewer embedded in the expanded portion of the record which displays the rest of the data from the dataSource that isn't already visible in the grid. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridRowExpansionEditorSample panel = new GridRowExpansionEditorSample();
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

        final DataSource dataSource = ItemSupplyXmlDS.getInstance();

        final ListGrid listGrid = new ListGrid() {
            @Override
            protected Canvas getExpansionComponent(final ListGridRecord record) {

                final ListGrid grid = this;
                VLayout layout = new VLayout(5);
                layout.setPadding(5);

                final DynamicForm df = new DynamicForm();
                df.setNumCols(4);
                df.setDataSource(dataSource);
                df.addDrawHandler(new DrawHandler() {
                    public void onDraw(DrawEvent event) {
                        df.editRecord(record);
                    }
                });

                IButton saveButton = new IButton("Save");
                saveButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        df.saveData();
                    }
                });

                IButton cancelButton = new IButton("Done");
                cancelButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        grid.collapseRecord(record);
                    }
                });

                HLayout hLayout = new HLayout(10);
                hLayout.setAlign(Alignment.CENTER);
                hLayout.addMember(saveButton);
                hLayout.addMember(cancelButton);

                layout.addMember(df);
                layout.addMember(hLayout);
                return layout;
            }
        };

        listGrid.setWidth(600);
        listGrid.setHeight(500);
        listGrid.setDrawAheadRatio(4);
        listGrid.setCanExpandRecords(true);
        listGrid.setAutoFetchData(true);
        listGrid.setDataSource(dataSource);

        ListGridField itemNameField = new ListGridField("itemName");
        ListGridField skuField = new ListGridField("SKU");

        listGrid.setFields(itemNameField, skuField);

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
