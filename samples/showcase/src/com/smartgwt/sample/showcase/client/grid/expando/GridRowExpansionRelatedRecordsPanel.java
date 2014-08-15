package com.smartgwt.sample.showcase.client.grid.expando;

import com.smartgwt.client.data.DataSource;
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

public class GridRowExpansionRelatedRecordsPanel extends ListGrid {

    public GridRowExpansionRelatedRecordsPanel() {

        DataSource dataSource = SupplyCategoryXmlDS.getInstance();

        setWidth100();
        setHeight(500);
        setDrawAheadRatio(4);
        setCanExpandRecords(true);

        setAutoFetchData(true);
        setDataSource(dataSource);

    }

    public DataSource getRelatedDataSource(ListGridRecord record) {
        return ItemSupplyXmlDS.getInstance();
    }

    @Override
    protected Canvas getExpansionComponent(final ListGridRecord record) {

        final ListGrid grid = this;

        VLayout layout = new VLayout(5);
        layout.setPadding(5);
        final ListGrid countryGrid = new ListGrid();
        countryGrid.setHeight(224);
        countryGrid.setCellHeight(22);
        countryGrid.setDataSource(getRelatedDataSource(record));
        countryGrid.fetchRelatedData(record, SupplyCategoryXmlDS.getInstance());

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
}
