package com.smartgwt.sample.showcase.client.grid.grouping;

import java.util.Date;
import java.util.LinkedHashMap;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.GroupValueFunction;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridGroupingModesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This sample shows that a single ListGrid field may be grouped in more than one way, by setting its groupingModes property, a valueMap. By default the grid is shown grouped by the \"Hemisphere\" mode of the Continent field--you can also group by the Continent Name. Similarly, there are two ways to group by the Nationhood field. You must define the getGroupValue() method of a field to apply logic appropriate to the field's groupingMode.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridGroupingModesSample panel = new GridGroupingModesSample();
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

        CountryXmlDS countryDS = CountryXmlDS.getInstance();
    	final ListGrid countryGrid = new ListGrid();  
        countryGrid.setWidth(550);  
        countryGrid.setHeight(425);  
        countryGrid.setAlternateRecordStyles(true);
        countryGrid.setDataSource(countryDS);
        countryGrid.setGroupStartOpen(GroupStartOpen.ALL);
        countryGrid.setGroupByField("continent");
        countryGrid.setAutoFetchData(true);
        
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);  
        countryCodeField.setAlign(Alignment.CENTER);  
        countryCodeField.setType(ListGridFieldType.IMAGE);  
        countryCodeField.setImageURLPrefix("flags/16/");  
        countryCodeField.setImageURLSuffix(".png");  
  
        ListGridField nameField = new ListGridField("countryName"); 
        ListGridField continentField = new ListGridField("continent");
        continentField.setDefaultGroupingMode("hemisphere");
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("continent", "Continent Name");
        map.put("hemisphere", "Hemisphere");
        continentField.setGroupingModes(map);
        continentField.setGroupValueFunction(new GroupValueFunction() {
            public Object getGroupValue(Object value, ListGridRecord record, ListGridField field, String fieldName, ListGrid grid) {
            	String continent = (String)value; 
            	if (field.getGroupingMode().equals("continent")) return value;
                else {
                    if ((continent.equals("North America")) || (continent.equals("South America"))) {
                        return "Western Hemisphere";
                    } else {
                        return "Eastern Hemisphere";
                    }
                }
            }
        });
        ListGridField independenceField = new ListGridField("independence");
        independenceField.setWidth(130);
        LinkedHashMap<String, String> mapIndependence = new LinkedHashMap<String, String>();
        mapIndependence.put("epoch", "Epoch");
        mapIndependence.put("season", "Season");
        final LinkedHashMap<String, String> mapSeasons = new LinkedHashMap<String, String>();
        mapSeasons.put("0", "Winter");
        mapSeasons.put("1", "Spring");
        mapSeasons.put("2", "Summer");
        mapSeasons.put("3", "Fall");
        independenceField.setGroupingModes(mapIndependence);
        independenceField.setDefaultGroupingMode("epoch");
        independenceField.setGroupValueFunction(new GroupValueFunction() {
            public Object getGroupValue(Object value, ListGridRecord record, ListGridField field, String fieldName, ListGrid grid) {
            	Date date = (Date)value; 
            	DateTimeFormat dateFormatYear = DateTimeFormat.getFormat("yyyy");
            	DateTimeFormat dateFormatMonth = DateTimeFormat.getFormat("MM");
            	DateTimeFormat dateFormatDay = DateTimeFormat.getFormat("dd");
            	if (field.getGroupingMode().equals("season")) {
                    if (date == null) return "Unknown";
                    int month = Integer.parseInt(dateFormatMonth.format(date))-1;
                    int day = Integer.parseInt(dateFormatDay.format(date));
                    int shift = month % 3 == 2 && day >= 21 ? 1 : 0;
                    double season = Math.floor(((month + shift) % 12)/3);
                    return mapSeasons.get(String.valueOf(season));
                } else {
                    if (date == null) return "Ancient";
                	int year = Integer.parseInt(dateFormatYear.format(date));
                    if (year < 1910) return "Pre-Industrial";
                    else return "Post-Industrial";
                }
            }
        });
        
        ListGridField populationField = new ListGridField("population");  

        countryGrid.setFields(nameField, continentField, independenceField, populationField, countryCodeField);

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}