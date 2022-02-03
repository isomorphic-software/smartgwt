package com.smartgwt.sample.showcase.client.grid.grouping;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GroupedEditingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Inline editing works normally with grouped data. Try editing the field that records are grouped by and notice that the record moves to its new group automatically.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GroupedEditingSample panel = new GroupedEditingSample();
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

        CountryXmlDS dataSource = CountryXmlDS.getInstance();

        ListGrid countryGrid = new ListGrid();
        countryGrid.setCanEdit(true);

        countryGrid.setWidth(522);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setGroupStartOpen(GroupStartOpen.ALL);
        countryGrid.setGroupByField("continent");
        countryGrid.setDataSource(dataSource);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);

        ListGridField nameField = new ListGridField("countryName");

        ListGridField governmentField = new ListGridField("government");
        ListGridField continentField = new ListGridField("continent");
        countryGrid.setFields(countryCodeField, nameField, governmentField, continentField);

        countryGrid.setAutoFetchData(true);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}