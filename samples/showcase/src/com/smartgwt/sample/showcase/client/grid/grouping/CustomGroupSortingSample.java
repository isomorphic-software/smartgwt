package com.smartgwt.sample.showcase.client.grid.grouping;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.GroupNode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.ListGridSummaryField;
import com.smartgwt.client.widgets.grid.GroupSortNormalizer;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.OrderItemLocalDS;

public class CustomGroupSortingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "By default, the implicit sorting of group " +
        "nodes with <b><code>setSortByGroupFirst(true)</code></b> uses their group value, " +
        "but by setting a <b><code>GroupSortNormalizer</code></b>, you can sort them in " +
        "any way you choose.  In this sample, we have the normalizer return the number of " +
        "data records (leaf nodes) beneath a group node, so that we sort those nodes with " +
        "the least number of data records beneath them first." +
        "<P>" +
        "Click the \"Sort Ascending\" button to reverse the order of the implicit sort.  " +
        "Observe that you can apply an explicit sort on top of the implicit one by clicking " +
        "on one of the header buttons.  If you apply an explicit sort by \"Category\" or " +
        "\"Ship Date\", note that it sorts by group value as expected, and overrides the " +
        "implicit sort.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            CustomGroupSortingSample panel = new CustomGroupSortingSample();
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

        ListGridField itemDescriptionField = new ListGridField("itemDescription", 120);

        ListGridField categoryField = new ListGridField("category", 80);
        ListGridField shipDateField = new ListGridField("shipDate", 100);
        ListGridField quantityField = new ListGridField("quantity");
        ListGridField unitPriceField = new ListGridField("unitPrice");

        ListGridSummaryField totalField = new ListGridSummaryField("total", "Total", 80);
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

        listGrid.setSortByGroupFirst(true);
        listGrid.setGroupSortDirection(SortDirection.ASCENDING);

        listGrid.setGroupSortNormalizer(new GroupSortNormalizer() {
            @Override
            public Object normalize(ListGridRecord record, String fieldName, ListGrid grid) {
                if (record instanceof GroupNode) {
                    GroupNode node = (GroupNode)record;
                    if (fieldName.equals(node.getGroupName())) {
                        return countGroupLeaves(listGrid, node);
                    }
                }
                return null;
            }
        });
        
        listGrid.setFields(orderIdField, itemDescriptionField, categoryField, shipDateField, 
                           quantityField, unitPriceField, totalField);

        final IButton button = new IButton();
        button.setTop(525);
        button.setWidth(150);
        button.setTitle("Sort Descending");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SortDirection newDirection;
                if (listGrid.getGroupSortDirection() == SortDirection.ASCENDING) {
                    newDirection = SortDirection.DESCENDING;
                    button.setTitle("Sort Descending");
                } else {
                    newDirection = SortDirection.ASCENDING;
                    button.setTitle("Sort Ascending");
                }
                listGrid.setGroupSortDirection(newDirection);
                listGrid.setSort();
            }
        });

        final Canvas canvas = new Canvas();
        canvas.addChild(listGrid);
        canvas.addChild(button);
        return canvas;
    }

    int countGroupLeaves(ListGrid grid, GroupNode node) {
        int count = 0;
        ListGridRecord[] children = grid.getGroupMembers(node, false);
        for (int i = 0; i < children.length; i++) {
            if (children[i] instanceof GroupNode) {
                count += countGroupLeaves(grid, (GroupNode)children[i]);
            } else {
                count++;
            }
        }
        return count;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
