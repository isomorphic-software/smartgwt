package com.smartgwt.sample.showcase.client.grid.hover;

import com.smartgwt.client.types.HoverMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PresetDateRangeXmlDS;
import com.smartgwt.sample.showcase.client.data.OrderMessagesXmlDS;

public class GridHoverRelatedRecordsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>In this grid of Customer Orders, you can hover over a row to see a list of messages " +
            "attached to the order.  This gives you a quick preview of discussions about the order, without the need to leave the list of orders.</p>" +
            "<p>In a complete application, clicking the order would lead to a detail screen showing the full order details and the ability to add to the discussion.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
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
        ListGrid orderList = new ListGrid();
        orderList.setWidth(700);
        orderList.setHeight(240);
        orderList.setAlternateRecordStyles(true);
        orderList.setDataSource(PresetDateRangeXmlDS.getInstance());
        orderList.setAutoFetchData(true);
        orderList.setCanHover(true);
        orderList.setShowHover(true);
        orderList.setShowHoverComponents(true);
        // Define datasource for loading into the hover window
        orderList.setHoverMode(HoverMode.RELATED);
        // Set the hover size and activity
        orderList.setHoverWidth(590);
        orderList.setDetailDS(OrderMessagesXmlDS.getInstance());
        ListGridField customerIDField = new ListGridField("customerID");
        customerIDField.setHidden(true);
        orderList.setFields(customerIDField);
        orderList.setUseAllDataSourceFields(true);
            
        ListGrid listGrid = new ListGrid();
        listGrid.setWrapCells(true);
        listGrid.setFixedRecordHeights(false);
        ListGridField loggedByField = new ListGridField("loggedBy");
        loggedByField.setWidth(100);
        ListGridField loggedDateField = new ListGridField("loggedDate");
        loggedDateField.setWidth(120);
        ListGridField orderMessageField = new ListGridField("orderMessage");
        orderMessageField.setWidth("*");
        listGrid.setFields(loggedByField, loggedDateField, orderMessageField);
        
        orderList.setAutoChildProperties("expansionRelated", listGrid);
        
        return orderList;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}