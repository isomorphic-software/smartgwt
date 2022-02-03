package com.smartgwt.sample.showcase.client.tiling;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.AnimalTile;
import com.smartgwt.sample.showcase.client.data.AnimalXmlDS;

public class CustomTilesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "TileGrids allow a completely custom component to be used as the tile." +
            "In this sample, each tile is a DynamicForm (with no editable fields).";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
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
    
    public interface AnimalTileMetaFactory extends BeanFactory.MetaFactory {
        BeanFactory<AnimalTile> getAnimalTileFactory();
    }

    public Canvas getViewPanel() {
        GWT.create(AnimalTileMetaFactory.class);
        
        TileGrid tileGrid = new TileGrid();
        tileGrid.setTileWidth(250);  
        tileGrid.setTileHeight(150);
        tileGrid.setHeight100();  
        tileGrid.setWidth100();
        tileGrid.setDataSource(AnimalXmlDS.getInstance());
        tileGrid.setAutoFetchData(true);
        tileGrid.setTileConstructor(AnimalTile.class.getName());
        return tileGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
