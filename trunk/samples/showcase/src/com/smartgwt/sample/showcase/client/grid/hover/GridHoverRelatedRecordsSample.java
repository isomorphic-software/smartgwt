package com.smartgwt.sample.showcase.client.grid.hover;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class GridHoverRelatedRecordsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "In this grid of Supply Categories, you can hover over a row to see a hovering grid " +
            "containing the list of Supply Items applicable to the Category under the mouse.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridHoverRelatedRecordsSample panel = new GridHoverRelatedRecordsSample();
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

        ListGrid listGrid = new ListGrid() {{
            setAttribute("showHoverComponents", true, true);
            setAttribute("hoverMode", "related", true);
        }};
        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setDataSource(SupplyCategoryXmlDS.getInstance());
        listGrid.setAutoFetchData(true);
        listGrid.setCanHover(true);
        listGrid.setShowHover(true);
        //listGrid.setShowHoverComponents(true);
        //listGrid.setHoverMode(HoverMode.RELATED);
        listGrid.setHoverWidth(250);
        listGrid.setHoverHeight(350);
        listGrid.setDetailDS(ItemSupplyXmlDS.getInstance());

        return listGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}