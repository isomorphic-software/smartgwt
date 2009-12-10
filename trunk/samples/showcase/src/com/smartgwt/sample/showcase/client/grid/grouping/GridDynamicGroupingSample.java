package com.smartgwt.sample.showcase.client.grid.grouping;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridDynamicGroupingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Right click on any column header to show a menu that allows you to group by that column. Right click and" +
            " pick \"ungroup\" to go back to a flat listing.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDynamicGroupingSample panel = new GridDynamicGroupingSample();
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

        VLayout layout = new VLayout(15);

        CountryXmlDS dataSource = CountryXmlDS.getInstance();

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setCanEdit(true);

        countryGrid.setWidth(522);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCellHeight(22);

        countryGrid.setGroupStartOpen("all");
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

        HLayout buttonLayout = new HLayout(15);

        IButton unGroupButton = new IButton("Ungroup");
        unGroupButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.ungroup();
            }
        });


        IButton groupByButton = new IButton("Group By Continent");
        groupByButton.setWidth(140);
        groupByButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.groupBy("continent");
            }
        });

        buttonLayout.addMember(unGroupButton);
        buttonLayout.addMember(groupByButton);
        
        layout.addMember(countryGrid);
        layout.addMember(buttonLayout);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}