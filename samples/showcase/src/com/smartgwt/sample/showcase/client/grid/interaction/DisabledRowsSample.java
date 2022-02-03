package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class DisabledRowsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "All \"Europe\" country records in this grid are disabled. Mouse over or drag the enabled rows, or click on any values in this grid. Notice the dragging behaviour above and below the disabled rows.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DisabledRowsSample panel = new DisabledRowsSample();
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
        DataSource ds = CountryDS.getInstance();

        ListGridRecord[] records = CountrySampleData.getRecords();
        ListGridRecord[] countryRecords = new ListGridRecord[records.length];
        for (int i = 0; i < records.length; i++) {
            countryRecords[i] = (ListGridRecord)ds.copyRecord(records[i]);
            if (countryRecords[i].getAttributeAsString("continent").equals("Europe")) {
                countryRecords[i].setEnabled(false);
            }
        }

        final ListGrid countryGrid = new ListGrid();
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

        countryGrid.setData(countryRecords);

        return countryGrid;
    }
    
    private static class CountryDS extends DataSource {  
  
        private static CountryDS instance = null;  
          
        public static CountryDS getInstance() {  
            if (instance == null) {  
                instance = new CountryDS("countryDS_DRS");  
            }  
            return instance;  
        }  
  
        public CountryDS(String id) {  
            setID(id);  
              
            DataSourceTextField countryCodeDSField = new DataSourceTextField("countryCode");
            DataSourceTextField countryNameDSField = new DataSourceTextField("countryName");
            DataSourceTextField capitalDSField = new DataSourceTextField("capital");
            DataSourceTextField continentDSField = new DataSourceTextField("continent");
            setFields(countryCodeDSField, countryNameDSField, capitalDSField, continentDSField);
              
            setClientOnly(true);  
        }  
    } 

    public String getIntro() {
        return DESCRIPTION;
    }

}