package com.smartgwt.sample.showcase.client.grid.expando;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class GridRowExpansionRelatedRecordsSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>In this grid of Supply Categories, you can expand a row by clicking the special " +
                    "expansionField to see a sub-grid containing the list of Supply Items applicable to the selected Category. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridRowExpansionRelatedRecordsSample panel = new GridRowExpansionRelatedRecordsSample();
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

        DataSource dataSource = SupplyCategoryXmlDS.getInstance();

        ListGrid listGrid = new ListGrid() {
            public DataSource getRelatedDataSource(ListGridRecord record) {
                return ItemSupplyXmlDS.getInstance();
            }

            @Override
            protected Canvas getExpansionComponent(final ListGridRecord record) {

                final ListGrid grid = this;

                VLayout layout = new VLayout(5);
                layout.setPadding(5);

                final ListGrid countryGrid = new ListGrid();
                countryGrid.setWidth(500);
                countryGrid.setHeight(224);
                countryGrid.setCellHeight(22);
                countryGrid.setDataSource(getRelatedDataSource(record));


                countryGrid.setAutoFetchData(true);
                countryGrid.setCanEdit(true);
                countryGrid.setModalEditing(true);
                countryGrid.setEditEvent(ListGridEditEvent.CLICK);
                countryGrid.setListEndEditAction(RowEndEditAction.NEXT);
                countryGrid.setAutoSaveEdits(false);

                layout.addMember(countryGrid);

                HLayout hLayout = new HLayout(10);
                hLayout.setAlign(Alignment.CENTER);

                IButton saveButton = new IButton("Save");
                saveButton.setTop(250);
                saveButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        countryGrid.saveAllEdits();
                    }
                });
                hLayout.addMember(saveButton);

                IButton discardButton = new IButton("Discard");
                discardButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        countryGrid.discardAllEdits();
                    }
                });
                hLayout.addMember(discardButton);

                IButton closeButton = new IButton("Close");
                closeButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        grid.collapseRecord(record);
                    }
                });
                hLayout.addMember(closeButton);
                                               
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

        return listGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
