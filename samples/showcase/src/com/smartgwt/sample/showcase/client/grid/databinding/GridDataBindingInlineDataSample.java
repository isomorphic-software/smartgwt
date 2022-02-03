package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridDataBindingInlineDataSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid uses an inline data array in the" +
                                              " component definition. This technique is" +
                                              " appropriate for very small read-only data sets," +
                                              " typically with static data values.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingInlineDataSample panel = new GridDataBindingInlineDataSample();
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
        countryGrid.setWidth(350);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
        ListGridField nameField = new ListGridField("countryName", "Country", 120);
        ListGridField capitalField = new ListGridField("capital", "Capital");

        countryGrid.setFields(countryCodeField, nameField, capitalField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(createListGridRecords(countryRecords));

        return countryGrid;
    }
    
    private static final String[] countryRecords = new String[] {
            "countryCode;countryName;capital",
            "US;United States;Washington, DC",
            "CH;China;Beijing",
            "JA;Japan;Tokyo",
            "IN;India;New Delhi",
            "GM;Germany;Berlin",
            "UK;United Kingdom;London",
            "FR;France;Paris",
            "IT;Italy;Rome",
            "RS;Russia;Moscow",
            "BR;Brazil;Brasilia",
            "CA;Canada;Ottawa",
            "MX;Mexico;Mexico (Distrito Federal)",
            "SP;Spain;Madrid",
            "KS;South Korea;Seoul",
            "ID;Indonesia;Jakarta"};
    /**
     * Creates an array of <code>ListGridRecord</code> objects from an array of <code>String</code>
     * values. The first string in the array contains the names of the fields in the
     * <code>ListGridRecord</code>s; the remaining strings in the supplied array contain the data.
     * The field names and data values are separated by semicolons.
     * @param records An array of strings containing the field names (in the first string of the
     * array) and the data values to be used in creating the resulting list grid records.
     * @return An array of list grid records representing the data.
     */
    public ListGridRecord[] createListGridRecords(String[] records) {
      ListGridRecord[] result = new ListGridRecord[records.length - 1];
      String[] fieldNames = records[0].split(";");
      for (int recordIndex = 1; recordIndex < records.length; ++recordIndex) {
        String[] fieldValues = records[recordIndex].split(";");
        result[recordIndex - 1] = new ListGridRecord();
        for (int fieldIndex = 0; fieldIndex < fieldValues.length; ++fieldIndex) {
          result[recordIndex - 1].setAttribute(fieldNames[fieldIndex], fieldValues[fieldIndex]);
        }
      }
      return result;
    } // createListGridRecords()

    public String getIntro() {
        return DESCRIPTION;
    }


}