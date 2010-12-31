package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.TileRecord;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.AnimalXmlDS;

public class DragTilesMoveSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop animals from the ListGrid on the left to the TileGrid on the right. " +
            "Animals can also be dragged from the TileGrid back to the ListGrid. ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragTilesMoveSample panel = new DragTilesMoveSample();
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
        TileGrid tileGrid = new TileGrid();
        tileGrid.setWidth(500);
        tileGrid.setHeight(400);
        tileGrid.setTileWidth(150);
        tileGrid.setTileHeight(150);
        tileGrid.setCanAcceptDrop(true);
        tileGrid.setCanDrag(true);
        tileGrid.setData(new TileRecord[]{});

        DetailViewerField pictureField = new DetailViewerField("picture");
        pictureField.setType("image");
        pictureField.setImageURLPrefix("animals/");
        DetailViewerField commonNameField = new DetailViewerField("commonName");

        tileGrid.setFields(pictureField, commonNameField);

        ListGrid listGrid = new ListGrid();
        listGrid.setWidth(300);
        listGrid.setHeight(400);
        listGrid.setDataSource(AnimalXmlDS.getInstance());
        listGrid.setAutoFetchData(true);
        listGrid.setCanDragRecordsOut(true);
        listGrid.setCanAcceptDroppedRecords(true);
        listGrid.setCanReorderRecords(true);

        ListGridField commonNameField2 = new ListGridField("commonName");
        ListGridField lifeSpanField = new ListGridField("lifeSpan");
        lifeSpanField.setWidth(50);
        ListGridField statusField = new ListGridField("status");
        listGrid.setFields(commonNameField2, lifeSpanField, statusField);

        VLayout vLayout = new VLayout(20);
        vLayout.addMember(new HTMLFlow(DESCRIPTION));

        HLayout hLayout = new HLayout(10);
        hLayout.addMember(listGrid);
        hLayout.addMember(tileGrid);

        vLayout.addMember(hLayout);

        return vLayout;
    }


    public String getIntro() {
        return null;
    }
}