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

        // Additional fields to display - use "setDisplayField" to simply re-display data from
        // other fields in each record.
        ListGridField itemName2 = new ListGridField("itemName2", 100);
        itemName2.setTitle("Item Name 2");
        itemName2.setDisplayField("itemName");
        
        ListGridField sku2 = new ListGridField("sku2", 100);
        sku2.setTitle("SKU 2");
        sku2.setDisplayField("SKU");
        
        ListGridField description2 = new ListGridField("description2", 150);
        description2.setTitle("Description 2");
        description2.setDisplayField("description");
        
        ListGridField category2 = new ListGridField("category2", 100);
        category2.setTitle("Category 2");
        category2.setDisplayField("category");
        
        ListGridField units2 = new ListGridField ("units2", 100);
        units2.setTitle("Units 2");
        units2.setDisplayField("units");
        
        ListGridField unitCost2 = new ListGridField("unitCost2", 100);
        unitCost2.setTitle("Unit Cost 2");
        unitCost2.setDisplayField("unitCost");
        
        ListGridField itemName3 = new ListGridField("itemName3", 100);
        itemName3.setTitle("Item Name 3");
        itemName3.setDisplayField("itemName");
        
        ListGridField sku3 = new ListGridField("sku3", 100);
        sku3.setTitle("SKU 3");
        sku3.setDisplayField("SKU");
        
        ListGridField description3 = new ListGridField("description3", 150);
        description3.setTitle("Description 3");
        description3.setDisplayField("description");
        
        ListGridField category3 = new ListGridField("category3", 100);
        category3.setTitle("Category 3");
        category3.setDisplayField("category");
        
        ListGridField units3 = new ListGridField ("units3", 100);
        units3.setTitle("Units 3");
        units3.setDisplayField("units");
        
        ListGridField unitCost3 = new ListGridField("unitCost3", 100);
        unitCost3.setTitle("Unit Cost 3");
        unitCost3.setDisplayField("unitCost");
        
        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setAutoFetchData(true);
        listGrid.setDataSource(dataSource);

        listGrid.setFields(rowNum, itemName, sku, description, category, units, unitCost,
                            itemName2, sku2, description2, category2, units2, unitCost2,
                            itemName3, sku3, description3, category3, units3, unitCost3);

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}