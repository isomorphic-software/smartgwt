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

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.OrderItem;
import com.smartgwt.sample.showcase.client.data.OrderItemLocalDS;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GridMultiLineSummariesSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>ListGrids support displaying summaries of the current data set in various ways:</p>" +
                    "<p>Fields from individual records can be summarized into a single field value. In this example the \"Total\" " +
                    "field displays a summary value calculated by multiplying the \"Quantity\" and \"Price\" fields.</p>" +
                    "<p>Summaries can also be displayed for multiple records. This example shows a summary row at the end of each " +
                    "group in the grid as well as an overall summary row with information about every record in the grid. Note that in " +
                    "addition to standard summary functions such as \"sum\" to generate a total, or \"count\" to generate a count of records, " +
                    "completely custom functions may be used. This is demonstrated in the \"Category\" field where a custom function determines " +
                    "how many categories exist in this dataset.</p>" +
                    "<p>By calling ListGrid.addSummaryFunction multiple times you can apply more than one summary function to a field. This allows " +
                    "the developer to set up multi-line summaries - each specified summary function result will show up in a separate summary row</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridMultiLineSummariesSample panel = new GridMultiLineSummariesSample();
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

        final DateTimeFormat dtf = DateTimeFormat.getFormat("MMM d, yyyy");


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
        shipDateField.setWidth(160);
        shipDateField.setShowGroupSummary(true);
        shipDateField.setShowGridSummary(false);
        shipDateField.setSummaryFunction(new SummaryFunction() {
            public Object getSummaryValue(Record[] records, ListGridField field) {
                Date firstOrder = null;
                for (int i = 0; i < records.length; i++) {
                    Record record = records[i];
                    Date shipDate = record.getAttributeAsDate("shipDate");
                    if (firstOrder == null || shipDate.before(firstOrder)) {
                        firstOrder = shipDate;
                    }
                }
                return "First Order " + dtf.format(firstOrder);
            }
        });
        shipDateField.addSummaryFunction(new SummaryFunction() {
            public Object getSummaryValue(Record[] records, ListGridField field) {
                Date lastOrder = null;
                for (int i = 0; i < records.length; i++) {
                    Record record = records[i];
                    Date shipDate = record.getAttributeAsDate("shipDate");
                    if(lastOrder == null || shipDate.after(lastOrder)) {
                        lastOrder = shipDate;
                    }
                }
                return "Last Order " + dtf.format(lastOrder);
            }
        });


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

        listGrid.setFields(orderIdField, itemDescriptionField, categoryField, shipDateField, quantityField, unitPriceField, totalField);

        return listGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
