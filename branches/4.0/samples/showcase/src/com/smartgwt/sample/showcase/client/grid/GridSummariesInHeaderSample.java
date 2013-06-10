/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.grid;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.OrderItem;
import com.smartgwt.sample.showcase.client.data.OrderItemLocalDS;

import java.util.HashSet;
import java.util.Set;

public class GridSummariesInHeaderSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>ListGrids support displaying summaries of the current data set in various ways:</p>" +
                    "<p>Fields from individual records can be summarized into a single field value. In this example the \"Total\" " +
                    "field displays a summary value calculated by multiplying the \"Quantity\" and \"Price\" fields.</p>" +
                    "<p>Summaries can also be displayed for multiple records. This example shows a summary row at the end of each " +
                    "group in the grid as well as an overall summary row with information about every record in the grid. Note that in " +
                    "addition to standard summary functions such as \"sum\" to generate a total, or \"count\" to generate a count of records, " +
                    "completely custom functions may be used. This is demonstrated in the \"Category\" field where a custom function determines " +
                    "how many categories exist in this dataset.</p>" +
                    "<p>As illustrated in this sample, by calling listGrid.setShowGroupSummaryInHeader(true) field summary values for each group are displayed directly " +
                    "in the group header node, rather than showing up at the bottom of each expanded group</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridSummariesInHeaderSample panel = new GridSummariesInHeaderSample();
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
        orderIdField.setSummaryFunction(SummaryFunctionType.COUNT);

        ListGridField itemDescriptionField = new ListGridField("itemDescription");

        ListGridField categoryField = new ListGridField("category");
        categoryField.setShowGridSummary(true);
        categoryField.setSummaryFunction(new SummaryFunction() {
            public Object getSummaryValue(Record[] records, ListGridField field) {
                Set<String> uniqueCategories = new HashSet<String>();

                for (int i = 0; i < records.length; i++) {
                    Record record = records[i];
                    uniqueCategories.add(((OrderItem) record).getCategory());
                }
                return uniqueCategories.size() + " Categories";
            }
        });

        ListGridField shipDateField = new ListGridField("shipDate");
        shipDateField.setShowGroupSummary(true);
        shipDateField.setShowGridSummary(false);
        shipDateField.setSummaryFunction(SummaryFunctionType.MAX);

        ListGridField quantityField = new ListGridField("quantity");
        quantityField.setShowGroupSummary(false);
        quantityField.setShowGridSummary(false);

        ListGridField unitPriceField = new ListGridField("unitPrice");
        unitPriceField.setAlign(Alignment.RIGHT);
        unitPriceField.setCellFormatter(new CellFormatter() {
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
        unitPriceField.setShowGroupSummary(false);
        unitPriceField.setShowGridSummary(false);

        ListGridSummaryField totalField = new ListGridSummaryField("total", "Total");
        totalField.setAlign(Alignment.RIGHT);
        totalField.setRecordSummaryFunction(RecordSummaryFunctionType.MULTIPLIER);
        totalField.setSummaryFunction(SummaryFunctionType.SUM);
        totalField.setShowGridSummary(true);
        totalField.setShowGroupSummary(true);
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
        listGrid.setHeight(520);
        listGrid.setAutoFetchData(true);

        listGrid.setShowAllRecords(true);
        listGrid.setDataSource(dataSource);
        listGrid.setCanEdit(true);
        listGrid.setGroupByField("category");
        listGrid.setGroupStartOpen(GroupStartOpen.ALL);
        listGrid.setShowGridSummary(true);
        listGrid.setShowGroupSummary(true);

        listGrid.setShowGroupSummaryInHeader(true);

        listGrid.setFields(orderIdField, itemDescriptionField, categoryField, shipDateField, quantityField, unitPriceField, totalField);

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}