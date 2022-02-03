package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class AutofitColumnWidthsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "ListGrid fields can be set to auto-fit to their titles, "+
        "to data values, or to the larger of both."+
        "<p>"+
        "In this example the first two columns are set to auto-fit. The first field auto-fits to its "+
        "long title (\"Flag Thumbnail\"). The second field auto-fits to the data values, so there is "+
        "extra space after the title."+
        "<p>"+
        "Note that the user can also perform one time auto-fit of columns at runtime by double-clicking "+
        "on any header or using the context-menu option.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AutofitColumnWidthsSample panel = new AutofitColumnWidthsSample();
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

        final ListGrid countryGrid = new ListGrid();

        countryGrid.setWidth100();
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setLeaveHeaderMenuButtonSpace(false);

        //size field to fit either the field title or the data values in the field
        countryGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        countryGrid.setCanSort(false);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag Thumbnail");
        countryCodeField.setCellAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setAutoFitWidth(true);

        ListGridField nameField = new ListGridField("countryName", "Country");
        nameField.setAutoFitWidth(true);
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setData(CountrySampleData.getRecords());

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}