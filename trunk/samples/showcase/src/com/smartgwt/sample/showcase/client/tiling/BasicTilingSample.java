package com.smartgwt.sample.showcase.client.tiling;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CarData;

public class BasicTilingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Smart GWT can display data in a \"tiled\" view. Mouse over widgets to see rollovers, click to select (shift- and ctrl-click for multi-select).";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            BasicTilingSample panel = new BasicTilingSample();
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
        tileGrid.setTileWidth(194);
        tileGrid.setTileHeight(165);
        tileGrid.setHeight(400);
        tileGrid.setWidth100();
        tileGrid.setShowAllRecords(true);
        tileGrid.setData(CarData.getRecords());

        DetailViewerField pictureField = new DetailViewerField("picture");
        pictureField.setType("image");
        pictureField.setImageURLPrefix("cars/");
        pictureField.setImageWidth(186);
        pictureField.setImageHeight(120);

        DetailViewerField nameField = new DetailViewerField("name");
        DetailViewerField priceField = new DetailViewerField("price");

        tileGrid.setFields(pictureField, nameField, priceField);

        return tileGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}