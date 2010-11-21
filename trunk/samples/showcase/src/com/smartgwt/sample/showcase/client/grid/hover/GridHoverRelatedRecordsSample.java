package com.smartgwt.sample.showcase.client.grid.hover;

import com.smartgwt.client.types.HoverMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class GridHoverRelatedRecordsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>In this grid of Customer Orders, you can hover over a row to see a list of messages " +
            "attached to the order.  This gives you a quick preview of discussion about the order, without the need to leave the list of orders.</p>" +
            "<p>In a complete application, clicking the order would lead to a detail screen showing the full order details and the ability to add to the discussion.</p>";

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
        ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setDataSource(SupplyCategoryXmlDS.getInstance());
        listGrid.setAutoFetchData(true);
        listGrid.setCanHover(true);
        listGrid.setShowHover(true);
        listGrid.setShowHoverComponents(true);
        listGrid.setHoverMode(HoverMode.RELATED);
        listGrid.setHoverWidth(550);
        listGrid.setHoverHeight(350);
        listGrid.setDetailDS(ItemSupplyXmlDS.getInstance());

        return listGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}