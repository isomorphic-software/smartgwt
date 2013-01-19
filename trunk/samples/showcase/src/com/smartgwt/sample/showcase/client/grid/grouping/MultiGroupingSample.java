package com.smartgwt.sample.showcase.client.grid.grouping;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.OrderItem;
import com.smartgwt.sample.showcase.client.data.OrderItemLocalDS;

import java.util.HashSet;
import java.util.Set;

public class MultiGroupingSample extends ShowcasePanel {

    private static final String DESCRIPTION =
        "<p>Grids support multiple levels of grouping, including a built-in dialog that " +
        "allows users to configure grouping.  This is enabled by a single setting: " + 
        "<code>canMultiGroup</code>." + 
        "<p>" + 
        "The grid below is grouped by Category, then by Ship Date.  Push the \"Configure Grouping\" " + 
        "button to launch a dialog for configuring multi-level grouping.  This can also be accessed " +
        "from the drop-down menu on any column header, via the \"Configure Grouping...\" menu item.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MultiGroupingSample panel = new MultiGroupingSample();
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
        DataSource dataSource = OrderItemLocalDS.getInstance();

        ListGridField orderIdField = new ListGridField("orderID");
        orderIdField.setIncludeInRecordSummary(false);

        ListGridField itemDescriptionField = new ListGridField("itemDescription");

        ListGridField categoryField = new ListGridField("category");
        ListGridField shipDateField = new ListGridField("shipDate");
        ListGridField quantityField = new ListGridField("quantity");
        ListGridField unitPriceField = new ListGridField("unitPrice");

        ListGridSummaryField totalField = new ListGridSummaryField("total", "Total");
        totalField.setAlign(Alignment.RIGHT);        
        totalField.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
        totalField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");
                    return "$" + nf.format(((Number) value).doubleValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        final ListGrid listGrid = new ListGrid();

        listGrid.setWidth(600);
        listGrid.setHeight(500);
        listGrid.setAutoFetchData(true);

        listGrid.setShowAllRecords(true);
        listGrid.setDataSource(dataSource);
        listGrid.setCanEdit(true);

        listGrid.setGroupByField("category", "shipDate");
        listGrid.setGroupStartOpen(GroupStartOpen.ALL);
        listGrid.setCanMultiGroup(true);

        listGrid.setSortField("shipDate");
        listGrid.setSortDirection(SortDirection.ASCENDING);

        listGrid.setFields(orderIdField, itemDescriptionField, categoryField, shipDateField, 
                           quantityField, unitPriceField, totalField);

        final IButton button = new IButton();
        button.setTop(525);
        button.setTitle("Configure Grouping");
        button.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    listGrid.configureGrouping();
                }
            });

        final Canvas canvas = new Canvas();
        canvas.addChild(listGrid);
        canvas.addChild(button);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}