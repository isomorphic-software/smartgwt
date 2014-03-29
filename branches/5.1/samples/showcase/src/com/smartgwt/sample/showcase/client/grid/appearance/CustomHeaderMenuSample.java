package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class CustomHeaderMenuSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This example illustrates how you can customize header context menus.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CustomHeaderMenuSample panel = new CustomHeaderMenuSample();
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

        final ListGrid countryGrid = new ListGrid() {
            @Override
            protected MenuItem[] getHeaderContextMenuItems(final Integer fieldNum) {
                final MenuItem[] items = super.getHeaderContextMenuItems(fieldNum);
                MenuItem customItem = new MenuItem("Hello + " + fieldNum);
                customItem.addClickHandler(new ClickHandler() {
                    public void onClick(MenuItemClickEvent event) {
                        SC.say("Hello Column : " + fieldNum);
                    }
                });
                MenuItem[] newItems = new MenuItem[items.length + 1];
                for (int i = 0; i < items.length; i++) {
                    MenuItem item = items[i];
                    newItems[i] = item;
                }
                newItems[items.length] = customItem;
                return newItems;
            }
        };

        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setTop(100);
        countryGrid.setShowAllRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
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