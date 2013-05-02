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

package com.smartgwt.sample.showcase.client.offline;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.Offline;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class OfflinePreferencesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Smart GWT provides a unified Offline browser storage API that your programs can use for any client-side " +
            "persistence task. In this example, we store the ListGrid's viewState to browser-local storage. Try resizing or reordering some columns in the grid, " +
            "click \"Persist State\", then press F5 to reload, or close and re-open the browser; your changes have been remembered. Try adding a formula field to " +
            "the grid and reload again. Persisting a user's preferences like this is a compelling addition to any application, and in this case we don't even need " +
            "a server.</p>" +
            "<p>Offline support is provided in modern HTML5 browsers, and also in older versions of Internet Explorer (6 and greater); the underlying technologies " +
            "used are very different, but the SmartClient API you use is the same regardless of browser. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            OfflinePreferencesSample panel = new OfflinePreferencesSample();
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

    private static int PK_COUNTER;

    public Canvas getViewPanel() {

        VLayout layout = new VLayout(15);
        layout.setWidth(650);
        layout.setAutoHeight();

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setLeaveScrollbarGap(true);
        countryGrid.setCanFreezeFields(true);
        countryGrid.setCanGroupBy(true);
        countryGrid.setWidth100();
        countryGrid.setHeight(224);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        //allow users to add formula and summary fields
        //accessible in the grid header context menu
        countryGrid.setCanAddFormulaFields(true);
        countryGrid.setCanAddSummaryFields(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanSort(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                String val = null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    val = nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
                return val + "km&sup2";
            }
        });
        countryGrid.setFields(countryCodeField, nameField, capitalField, populationField, areaField);


        ToolStripButton formulaButton = new ToolStripButton("Formula Builder", "crystal/oo/sc_insertformula.png");
        formulaButton.setAutoFit(true);
        formulaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addFormulaField();
            }
        });

        ToolStripButton summaryBuilder = new ToolStripButton("Summary Builder", "crystal/16/apps/tooloptions.png");
        summaryBuilder.setAutoFit(true);
        summaryBuilder.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addSummaryField();
            }
        });


        ToolStripButton savePreference = new ToolStripButton("Persist State", "silk/database_gear.png");
        savePreference.setAutoFit(true);
        savePreference.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                String viewState = countryGrid.getViewState();
                Offline.put("exampleState", viewState);
                SC.say("Preferences persisted.");
            }
        });

        //toolstrip to attach to the country grid
        ToolStrip countryGridToolStrip = new ToolStrip();
        countryGridToolStrip.setWidth100();
        countryGridToolStrip.addFill();
        countryGridToolStrip.addButton(formulaButton);
        countryGridToolStrip.addButton(summaryBuilder);
        countryGridToolStrip.addSeparator();
        countryGridToolStrip.addButton(savePreference);


        VLayout countryGridLayout = new VLayout(0);
        countryGridLayout.setWidth(650);
        countryGridLayout.addMember(countryGridToolStrip);
        countryGridLayout.addMember(countryGrid);
        layout.addMember(countryGridLayout);


        final String previouslySavedState = (String) Offline.get("exampleState");
        if (previouslySavedState != null) {
            countryGrid.addDrawHandler(new DrawHandler() {
                @Override
                public void onDraw(DrawEvent event) {
                    //restore any previously saved view state for this grid
                    countryGrid.setViewState(previouslySavedState);
                }
            });
        }

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
