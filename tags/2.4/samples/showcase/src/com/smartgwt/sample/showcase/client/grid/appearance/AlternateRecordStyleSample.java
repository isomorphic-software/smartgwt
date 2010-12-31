package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class AlternateRecordStyleSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This sample illustrates alternate record styles to create ledger effect for easier reading. To disable alternate " +
            "record styles ListGrid.setAlternateRecordStyles(false) can be called.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AlternateRecordStyleSample panel = new AlternateRecordStyleSample();
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

        VLayout layout = new VLayout(10);

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setAlternateRecordStyles(true);

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
        countryGrid.setData(CountryData.getRecords());
        layout.addMember(countryGrid);

        DynamicForm form = new DynamicForm();
        form.setWidth(300);

        CheckboxItem checkboxItem = new CheckboxItem("cbItem", "Alternate Record Styles");
        checkboxItem.setWidth(150);
        checkboxItem.setValue(true);
        checkboxItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                boolean checked = (Boolean) event.getValue();
                countryGrid.setAlternateRecordStyles(checked);
            }
        });
        form.setItems(checkboxItem);
        layout.addMember(form);

        return layout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}