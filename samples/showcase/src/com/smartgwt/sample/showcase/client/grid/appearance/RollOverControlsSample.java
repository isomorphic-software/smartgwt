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

package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class RollOverControlsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "RollOver the rows in the grid to row-level controls buttons appear embedded in the row. " +
            "This example utilizes the rollOverCanvas subsystem to achieve this effect.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RollOverControlsSample panel = new RollOverControlsSample();
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

    private HLayout rollOverCanvas;
    private ListGridRecord rollOverRecord;

    public Canvas getViewPanel() {

        final ListGrid countryGrid = new ListGrid() {
            @Override
            protected Canvas getRollOverCanvas(Integer rowNum, Integer colNum) {
                rollOverRecord = this.getRecord(rowNum);

                if(rollOverCanvas == null) {
                    rollOverCanvas = new HLayout(3);
                    rollOverCanvas.setSnapTo("TR");
                    rollOverCanvas.setWidth(50);
                    rollOverCanvas.setHeight(22);

                    ImgButton editImg = new ImgButton();
                    editImg.setShowDown(false);
                    editImg.setShowRollOver(false);
                    editImg.setLayoutAlign(Alignment.CENTER);
                    editImg.setSrc("silk/comment_edit.png");
                    editImg.setPrompt("Edit Comments");
                    editImg.setHeight(16);
                    editImg.setWidth(16);
                    editImg.addClickHandler(new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            SC.say("Edit Comment Icon Clicked for country : " + rollOverRecord.getAttribute("countryName"));
                        }
                    });

                    ImgButton chartImg = new ImgButton();
                    chartImg.setShowDown(false);
                    chartImg.setShowRollOver(false);
                    chartImg.setLayoutAlign(Alignment.CENTER);
                    chartImg.setSrc("silk/chart_bar.png");
                    chartImg.setPrompt("View Chart");
                    chartImg.setHeight(16);
                    chartImg.setWidth(16);
                    chartImg.addClickHandler(new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            SC.say("Chart Icon Clicked for country : " + rollOverRecord.getAttribute("countryName"));
                        }
                    });

                    rollOverCanvas.addMember(editImg);
                    rollOverCanvas.addMember(chartImg);
                }
                return rollOverCanvas;

            }
        };
        countryGrid.setShowRollOverCanvas(true);
        // Disable the rollUnderCanvas because we're not using it.
        countryGrid.setShowRollUnderCanvas(false);


        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }


    public String getIntro() {
        return DESCRIPTION;
    }    
}
