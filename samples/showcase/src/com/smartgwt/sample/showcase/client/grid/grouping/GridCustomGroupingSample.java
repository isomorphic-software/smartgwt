package com.smartgwt.sample.showcase.client.grid.grouping;

import java.util.Date;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.GroupNode;
import com.smartgwt.client.widgets.grid.GroupTitleRenderer;
import com.smartgwt.client.widgets.grid.GroupValueFunction;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridCustomGroupingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "You can specify custom grouping behavior for a field. Group by the Nationhood and Population fields to see examples of custom grouping.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridCustomGroupingSample panel = new GridCustomGroupingSample();
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

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setCanEdit(true);

        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setDataSource(dataSource);
        countryGrid.setGroupStartOpen(GroupStartOpen.ALL);
        countryGrid.setGroupByField("population");
        countryGrid.setAutoFetchData(true);

        ListGridField nameField = new ListGridField("countryName");
        ListGridField continentField = new ListGridField("continent");

        ListGridField independenceField = new ListGridField("independence");
        independenceField.setGroupValueFunction(new GroupValueFunction() {
            public Object getGroupValue(Object value, ListGridRecord record, ListGridField field, String fieldName, ListGrid grid) {
                Date independence = (Date) value;
                if(independence == null) {
                    return "Ancient";
                } else if (independence.getYear() < 10) { //if year < 1910
                    return "Pre-Industrial";
                } else {
                    return "Post-Industrial";
                }
            }
        });

        final int groupSmall = 1;
        final int groupMed = 2;
        final int groupLarge = 3;

        ListGridField populationField = new ListGridField("population");
        populationField.setType(ListGridFieldType.INTEGER);

        populationField.setGroupValueFunction(new GroupValueFunction() {
            public Object getGroupValue(Object value, ListGridRecord record, ListGridField field, String fieldName, ListGrid grid) {
                Integer population = (Integer) value;
                if(population == null || population < 100000000) {
                    return groupSmall;
                } else if  (population < 1000000000) {
                    return groupMed;
                } else {
                    return groupLarge;
                }
            }
        });

        populationField.setGroupTitleRenderer(new GroupTitleRenderer() {
            public String getGroupTitle(Object groupValue, GroupNode groupNode, ListGridField field, String fieldName, ListGrid grid) {
                final int groupType = (Integer) groupValue;
                String baseTitle ="";

                switch (groupType) {
                    case groupSmall:
                        baseTitle = "Population less than 100 million";
                        break;
                    case groupMed:
                        baseTitle = "Population between 100 million-1 billion";
                        break;
                    case groupLarge:
                        baseTitle = "Population over 1 billion";
                        break;
                }
                baseTitle += " (" + groupNode.getGroupMembers().length + " members)";
                return baseTitle;
            }
        });

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);

        countryGrid.setFields(nameField, continentField, independenceField, populationField, countryCodeField);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}