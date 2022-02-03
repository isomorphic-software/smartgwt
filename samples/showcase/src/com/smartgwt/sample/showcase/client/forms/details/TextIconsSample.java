package com.smartgwt.sample.showcase.client.forms.details;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TextIconsSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "As an alternative to displaying an image, inline form item icons can display a " +
            "string of HTML where the icon's image would have appeared. This enables advanced " +
            "customizations such as using text, icon font symbols, Unicode dingbats and emoji, " +
            "and/or SVG in place of an image." +
            "<p>" +
            "In the example below, a text icon is used to embed the Unicode TELEPHONE&nbsp;LOCATION&nbsp;SIGN " +
            "character (U+2706) into a \"Phone Number\" field.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            final TextIconsSample panel = new TextIconsSample();
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

    public String getCssUrl() {
        return "source/forms/details/textIcons.css.html";
    }

    private DynamicForm form;
    private RadioGroupItem havePhoneNumberItem;
    private TextItem phoneNumberItem;
    private String previousPhoneNumber;

    @Override
    public Canvas getViewPanel() {
        havePhoneNumberItem = new RadioGroupItem("havePhoneNumber", "Have Phone Number?");
        havePhoneNumberItem.setVertical(false);
        final LinkedHashMap<String, Object> valueMap = new LinkedHashMap<String, Object>();
        valueMap.put("true", "Yes");
        valueMap.put("false", "No");
        havePhoneNumberItem.setValueMap(valueMap);
        havePhoneNumberItem.setDefaultValue("true");
        havePhoneNumberItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final boolean enabled = "true".equals(event.getValue());
                phoneNumberItem.setDisabled(!enabled);
                if (enabled) {
                    phoneNumberItem.setValue(previousPhoneNumber);
                } else {
                    // Save the current phone number, to be restored if the user selects "Yes" again.
                    previousPhoneNumber = phoneNumberItem.getValueAsString();
                    phoneNumberItem.clearValue();
                }
            }
        });

        phoneNumberItem = new TextItem("phoneNumber", "Phone Number");
        phoneNumberItem.setWidth(200);
        final FormItemIcon telIcon = new FormItemIcon();
        telIcon.setName("tel");
        telIcon.setSrc("blank"); // if inline icons are not supported by the browser, revert to a blank icon
        telIcon.setInline(true);
        telIcon.setText("&#x2706;");
        telIcon.setBaseStyle("telIcon");
        phoneNumberItem.setIcons(telIcon);
        phoneNumberItem.setIconWidth(16);
        phoneNumberItem.setIconHeight(16);
        phoneNumberItem.setKeyPressFilter("[-+(),./#0-9 Xx]");

        form = new DynamicForm();
        form.setItems(havePhoneNumberItem, phoneNumberItem);

        final Layout layout = new VStack();
        layout.setWidth100();
        layout.setMembers(form);
        return layout;
    }
}
