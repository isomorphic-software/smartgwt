package com.smartgwt.sample.showcase.client.grid;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.PromptStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class LiveGridFetchSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Rows are fetched automatically as the user drags the scrollbar. Drag the scrollbar quickly to the bottom to " +
                    "fetch a range near the end (a prompt will appear during server fetch).</p><p>Scroll slowly back up to fill in the middle.</p>" +
                    "<p>Another key unique feature of Smart GWT is lazy rendering of <b>columns</b>. Most browsers cannot handle displaying a large number of column and have serious performance issues." +
                    "Smart GWT however does not render all columns outside the visible area by default and only renders them as you scroll horizontally. You can however disable this feature if desired.</p>" +
                    "<p>You can control how far ahead of the currently visible area rows should be rendered. This is expressed as a ratio from viewport size to rendered area size. The default is 1.3.</p>" +
                    "<p>Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs initial render time and render time when scrolling by large amounts.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            LiveGridFetchSample panel = new LiveGridFetchSample();
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

        RPCManager.setPromptStyle(PromptStyle.CURSOR);
        DataSource dataSource = ItemSupplyXmlDS.getInstance();

        ListGridField rowNum = new ListGridField("itemNum", "Item No.");
        rowNum.setWidth(65);
        rowNum.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return rowNum +"";
            }
        });

        ListGridField itemName = new ListGridField("itemName", 100);
        ListGridField sku = new ListGridField("SKU", 100);
        ListGridField description = new ListGridField("description", 150);
        ListGridField category = new ListGridField("category", 100);
        ListGridField units = new ListGridField("units", 100);

        ListGridField unitCost = new ListGridField("unitCost", 100);
        unitCost.setType(ListGridFieldType.FLOAT);

        ListGridField inStock = new ListGridField("inStock", 100);
        inStock.setType(ListGridFieldType.BOOLEAN);

        ListGridField nextShipment = new ListGridField("nextShipment", 100);
        nextShipment.setType(ListGridFieldType.DATE);



        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setAutoFetchData(true);
        listGrid.setDataSource(dataSource);

        listGrid.setFields(rowNum, itemName, sku, description, category, units, unitCost,
                            itemName, sku, description, category, units, unitCost,
                            itemName, sku, description, category, units, unitCost);

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}