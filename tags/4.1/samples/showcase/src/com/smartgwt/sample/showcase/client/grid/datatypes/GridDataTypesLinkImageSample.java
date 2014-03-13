package com.smartgwt.sample.showcase.client.grid.datatypes;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class GridDataTypesLinkImageSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the book images in the \"Info\" column to" +
                                              " open external links.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataTypesLinkImageSample panel = new GridDataTypesLinkImageSample();
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
        Canvas canvas = new Canvas();

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(220);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField articleField = new ListGridField("article", "Info");
        articleField.setType(ListGridFieldType.LINK);
        articleField.setWidth(50);
        articleField.setAlign(Alignment.CENTER);
        articleField.setLinkText(Canvas.imgHTML("[SKINIMG]actions/help.png", 16, 16, "info", "align=center", null));

        countryGrid.setFields(new ListGridField[] {countryCodeField, nameField, articleField});
        countryGrid.setData(CountrySampleData.getRecords());
        canvas.addChild(countryGrid);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}