package com.smartgwt.sample.showcase.client.forms;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PickerIcon;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PickerControlsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>The CustomPicker example demonstrates various standard picker icons that are provided with Smart GWT. " +
            "You can combine as many pickers as you like as illustrated by this sample.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            PickerControlsSample panel = new PickerControlsSample();
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

        final DynamicForm form = new DynamicForm();
        form.setMargin(10);
        form.setAutoFocus(true);
        form.setWidth(400);
        form.setTitleWidth(100);
        form.setColWidths(110, "*");

        PickerIcon clearPicker = new PickerIcon(PickerIcon.CLEAR, new FormItemClickHandler() {
            public void onFormItemClick(FormItemIconClickEvent event) {
                SC.say("Clear Picker clicked");
            }
        });

        PickerIcon searchPicker = new PickerIcon(PickerIcon.SEARCH, new FormItemClickHandler() {
            public void onFormItemClick(FormItemIconClickEvent event) {
                SC.say("Search Picker clicked");
            }
        });

        PickerIcon datePicker = new PickerIcon(PickerIcon.DATE, new FormItemClickHandler() {
            public void onFormItemClick(FormItemIconClickEvent event) {
                SC.say("Date Picker clicked");
            }
        });

        PickerIcon refreshPicker = new PickerIcon(PickerIcon.REFRESH, new FormItemClickHandler() {
            public void onFormItemClick(FormItemIconClickEvent event) {
                SC.say("Refresh Picker clicked");
            }
        });

        TextItem pickerControls = new TextItem("pickerControls", "Picker Controls");
        pickerControls.setIcons(clearPicker, searchPicker, refreshPicker);

        TextItem datePickerControl = new TextItem("datePicker", "Date Picker");
        datePickerControl.setIcons(datePicker);

        TextItem refreshOnlyControl = new TextItem("refreshPicker", "Refresh Picker");
        refreshOnlyControl.setIcons(refreshPicker);

        form.setFields(pickerControls, datePickerControl, refreshOnlyControl);

        return form;
    }
    public String getIntro() {
        return DESCRIPTION;
    }
}
