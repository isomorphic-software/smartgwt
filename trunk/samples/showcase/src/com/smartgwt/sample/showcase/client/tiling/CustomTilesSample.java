package com.smartgwt.sample.showcase.client.tiling;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CarData;

public class CustomTilesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "The tiles in a TileGrid can be customized. " +
    		"This example demonstrates adding a \"Remove\" button to each tile which, when " +
    		"clicked, removes the selected tile.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            CustomTilesSample panel = new CustomTilesSample();
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
        TileGrid tileGrid = new TileGrid() {
            
            @Override
            public Canvas getTile(Record record) {
                Canvas canvas = super.getTile(record);
                if (canvas.getChildren().length == 0) {
                    canvas.addChild(this.getRemoveButton(record));                        
                }
                return canvas;
            }
            
            @Override
            public Canvas getTile(int recordNum) {
                return this.getTile(this.getRecordList().get(recordNum));
            }

            private Canvas getRemoveButton(final Record record) {
                final TileGrid grid = this;
                ImgButton removeButton = new ImgButton();
                removeButton.setSrc("[SKINIMG]/Tab/left/close.png");
                removeButton.setShowHover(true);
                removeButton.setPrompt("Remove tile");
                removeButton.setWidth(15);
                removeButton.setHeight(15);
                removeButton.setShowFocused(false);
                removeButton.setShowRollOver(false);
                removeButton.setSnapTo("TR");
                removeButton.setShowDown(false);
                removeButton.setMargin(2);
                removeButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        grid.removeData(record);
                    }
                });
                return removeButton;
            }
        };
        
        tileGrid.setTileWidth(250);  
        tileGrid.setTileHeight(150);
        tileGrid.setHeight100();  
        tileGrid.setWidth100();
        tileGrid.setData(CarData.getRecords());
        tileGrid.setAnimateTileChange(true);
        
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