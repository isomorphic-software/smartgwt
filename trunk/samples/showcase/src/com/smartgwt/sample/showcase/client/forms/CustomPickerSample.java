package com.smartgwt.sample.showcase.client.forms;

import com.smartgwt.client.core.Rectangle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.IconClickEvent;
import com.smartgwt.client.widgets.form.fields.events.IconClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.HashMap;
import java.util.Map;

public class CustomPickerSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>The CustomPicker example demonstrates various custom picker icons that (YesNoMaybeItem) implemented as a \"picker\" that the user can pop up from a picker icon next to a form or grid value.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CustomPickerSample panel = new CustomPickerSample();
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
        form.setAutoFocus(true);
        form.setWidth(200);

        YesNoMaybeItem decision = new YesNoMaybeItem();
        decision.setTitle("Decision");
        form.setFields(decision);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    public static class YesNoMaybeItem extends TextItem {

        private static Dialog dialog;
        private static YesNoMaybeItem currentEditor;

        private static void makeDialog() {
            dialog = new Dialog();
            dialog.setAutoCenter(true);
            dialog.setIsModal(true);
            dialog.setShowHeader(false);
            dialog.setShowEdges(false);
            dialog.setEdgeSize(10);
            dialog.setWidth(500);
            dialog.setHeight(400);

            dialog.setShowToolbar(false);
            dialog.setWidth(130);
            dialog.setHeight(110);


            Map bodyDefaults = new HashMap();
            bodyDefaults.put("layoutLeftMargin", 5);
            bodyDefaults.put("membersMargin", 10);
            dialog.setBodyDefaults(bodyDefaults);

            final IButton yes = new IButton("YES");
            yes.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
                public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
                    YesNoMaybeItem.seCurrentValue(yes.getTitle());
                }
            });

            final IButton no = new IButton("NO");
            no.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
                public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
                    YesNoMaybeItem.seCurrentValue(no.getTitle());
                }
            });

            final IButton maybe = new IButton("MAYBE");
            maybe.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
                public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
                    YesNoMaybeItem.seCurrentValue(maybe.getTitle());
                }
            });

            dialog.addItem(yes);
            dialog.addItem(no);
            dialog.addItem(maybe);
        }
        
        // set the specified value and dismiss the picker dialog
        private static void seCurrentValue(String value) {
            currentEditor.setValue(value);
            dialog.hide();
        }

        // show the picker dialog at the specified position
        private static void showDialog(int left, int top) {
            dialog.show();
            dialog.moveTo(left, top);            
        }


        public YesNoMaybeItem() {
            //use default trigger icon here. User can customize.
            //[SKIN]/DynamicForm/default_formItem_icon.gif
            FormItemIcon formItemIcon = new FormItemIcon();
            setIcons(formItemIcon);

            addIconClickHandler(new IconClickHandler() {
                public void onIconClick(IconClickEvent event) {

                    // get global coordinates of the clicked picker icon
                    Rectangle iconRect = getIconPageRect(event.getIcon());

                    // lazily create the YesNoMaybe picker dialog the first time a yesNoMaybe editor is clicked
                    if (YesNoMaybeItem.dialog == null) {
                        YesNoMaybeItem.makeDialog();
                    }
                    // remember what editor is active, so we can set its value from the picker dialog
                    YesNoMaybeItem.currentEditor = YesNoMaybeItem.this;

                    // show the picker dialog
                    YesNoMaybeItem.showDialog(iconRect.getLeft(), iconRect.getTop());
                }
            });
        }
    }
}