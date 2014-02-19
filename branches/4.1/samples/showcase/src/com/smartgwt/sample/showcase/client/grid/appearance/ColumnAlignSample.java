package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class ColumnAlignSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the \"Left\", \"Center\", or \"Right\" radio buttons to set the alignment of the \"Flag\" column.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ColumnAlignSample panel = new ColumnAlignSample();
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
        final ListGrid countryGrid = new ListGrid();
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

        DynamicForm form = new DynamicForm();
        RadioGroupItem radioGroupItem = new RadioGroupItem();
        radioGroupItem.setShowTitle(false);
        radioGroupItem.setValueMap("Left", "Center", "Right");
        radioGroupItem.setDefaultValue("Center");
        radioGroupItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                String newValue = (String) event.getValue();
                ListGridField field = countryGrid.getField("countryCode");
                field.setAlign(Alignment.valueOf(newValue.toUpperCase()));
                countryGrid.markForRedraw();
            }
        });
        form.setItems(radioGroupItem);
        canvas.addChild(form);
        canvas.addChild(countryGrid);

        return canvas;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

}