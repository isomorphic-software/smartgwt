package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class CellStylesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Mouse over the rows and click-drag to select rows, to see the effects of different base styles on these two grids.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CellStylesSample panel = new CellStylesSample();
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

        CountryListGrid countryList1 = new CountryListGrid();
        countryList1.setBaseStyle("myBoxedGridCell");
        canvas.addChild(countryList1);

        CountryListGrid countryList2 = new CountryListGrid();
        countryList2.setTop(220);
        countryList2.setBaseStyle("myOtherGridCell");
        canvas.addChild(countryList2);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

    class CountryListGrid extends ListGrid {
        CountryListGrid() {
            setWidth(500);
            setHeight(184);
            setShowAllRecords(true);
            setCanDragSelect(true);

            ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
            countryCodeField.setAlign(Alignment.CENTER);
            countryCodeField.setType(ListGridFieldType.IMAGE);
            countryCodeField.setImageURLPrefix("flags/16/");
            countryCodeField.setImageURLSuffix(".png");

            ListGridField nameField = new ListGridField("countryName", "Country");
            ListGridField capitalField = new ListGridField("capital", "Capital");
            ListGridField continentField = new ListGridField("continent", "Continent");
            setFields(countryCodeField, nameField, capitalField, continentField);

            setData(CountrySampleData.getRecords());
        }
    }

}