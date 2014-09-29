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

package com.smartgwt.sample.showcase.client.grid.hover;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class GridCustomHoverSample extends ShowcasePanel {

    private static final String DESCRIPTION = "This grid displays a limited number of fields from the supplyItem dataSource. " +
            "When you hover over a row, the system goes to the server to retrieve the entire record, creates a DetailViewer to display that " +
            "data and shows it as the hoverComponent. See the code in the overridden getCellHoverComponent() method.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridCustomHoverSample panel = new GridCustomHoverSample();
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

        ListGrid listGrid = new ListGrid() {
            @Override
            protected Canvas getCellHoverComponent(Record record, Integer rowNum, Integer colNum) {
                DetailViewer detailViewer = new DetailViewer();
                detailViewer.setWidth(200);
                detailViewer.setDataSource(ItemSupplyXmlDS.getInstance());
                Criteria criteria = new Criteria();
                criteria.addCriteria("itemID", record.getAttribute("itemID"));
                detailViewer.fetchData(criteria);

                return detailViewer;
            }

        };

        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setDataSource(ItemSupplyXmlDS.getInstance());

        ListGridField itemNameField = new ListGridField("itemName");
        ListGridField skuField = new ListGridField("SKU");
        ListGridField categoryField = new ListGridField("category");
        listGrid.setFields(itemNameField, skuField, categoryField);

        listGrid.setAutoFetchData(true);
        listGrid.setCanHover(true);
        listGrid.setShowHover(true);
        listGrid.setShowHoverComponents(true);

        return listGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}