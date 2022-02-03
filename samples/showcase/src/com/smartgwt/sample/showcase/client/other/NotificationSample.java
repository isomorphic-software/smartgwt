package com.smartgwt.sample.showcase.client.other;

import java.util.Map;
import java.util.HashMap;


import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.DynamicForm;

import com.smartgwt.client.types.EdgeName;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.types.MultiMessageMode;
import com.smartgwt.client.types.NotifyTransition;
import com.smartgwt.client.types.ListGridFieldType;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class NotificationSample extends ShowcasePanel implements NotifyActionCallback {
    private static final String DESCRIPTION = 
        "The Notify subsystem allows you to inform end users of important events without " +
        "interrupting their work with a modal dialog that the user must click to dismiss. To " +
        "show a notification, type some text in the message box, select where on the screen " +
        "you want it to appear and how its appearance and disappearance should be animated, " +
        "and click 'send'. The message will animate into view at the desired location, and " +
        "then automatically animate away after a few seconds.<P>" +
        
        "By ticking the checkboxes, you can configure the notification to show a close " +
        "button so you can close it early, or show a link that launches a window. In your " +
        "application, one or more such links can be shown in the notification to take any " +
        "action you need.<P>" +

        "Three notification priorities are available for you corresponding to the predefined " +
        "categories: 'message', 'warn', and 'error', and you can use the 'Priority' picker " +
        "to switch between them in this sample.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            NotificationSample panel = new NotificationSample();
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

    // configureDefaultSettings() can customize NotifySettings for all NotifyTypes up front
    private void configureDefaults() {
        NotifySettings changedDefaults = new NotifySettings();
        changedDefaults.setMultiMessageMode(MultiMessageMode.REPLACE);
        changedDefaults.setAutoFitMaxWidth(250);
        changedDefaults.setSlideSpeed(250);

        Notify.configureDefaultSettings(changedDefaults);
    }

    public Canvas getViewPanel() {

        HeaderItem titleItem = new HeaderItem("header", "Configure Notification");

        final TextItem textItem = new TextItem("text", "Message");
        textItem.setDefaultValue("Download complete");
        textItem.setHint("Type your Message");
        textItem.setWrapHintText(false);

        Map locations = new HashMap();
        locations.put(EdgeName.L, "left edge");
        locations.put(EdgeName.R, "right edge");
        locations.put(EdgeName.T, "top edge");
        locations.put(EdgeName.B, "bottom edge");
        locations.put(EdgeName.TL, "top-left corner");
        locations.put(EdgeName.TR, "top-right corner");
        locations.put(EdgeName.BL, "bottom-left corner");
        locations.put(EdgeName.BR, "bottom-right corner");
        locations.put(EdgeName.C, "center");

        final ComboBoxItem locationPicker = new ComboBoxItem("location", "Screen Location");
        locationPicker.setDefaultValue("T");
        locationPicker.setValueMap(locations);

        final ComboBoxItem showMethodPicker = new ComboBoxItem("showAnimation", 
                                                               "Show Animation");
        showMethodPicker.setValueMap("slide", "fade", "instant");
        showMethodPicker.setDefaultValue("slide");
        showMethodPicker.setWrapTitle(false);

        final ComboBoxItem hideMethodPicker = new ComboBoxItem("hideAnimation", 
                                                               "Hide Animation");
        hideMethodPicker.setValueMap("slide", "fade", "instant");
        hideMethodPicker.setDefaultValue("fade");
        hideMethodPicker.setWrapTitle(false);

        final ListGridField messagePriorityField = new ListGridField("messagePriority");
        messagePriorityField.setType(ListGridFieldType.INTEGER);

        final ComboBoxItem priorityPicker = new ComboBoxItem("messagePriority", "Priority");
        priorityPicker.setValueMap(new HashMap() {{
            put(Notify.MESSAGE, "message");
            put(Notify.WARN,    "warn");
            put(Notify.ERROR,   "error");
        }});
        priorityPicker.setPickListProperties(new ListGrid() {{
            setSortDirection(SortDirection.DESCENDING);
            setSortField("messagePriority");
            setFields(messagePriorityField);
        }});
        priorityPicker.setDefaultValue(Notify.MESSAGE);
        priorityPicker.setWrapTitle(false);

        final CheckboxItem dismiss = new CheckboxItem("dismiss", 
                                                      "Add button to immediately dismiss");
        final CheckboxItem window = new CheckboxItem("window", "Add link to launch a window");

        DynamicForm configForm = new DynamicForm();
        configForm.setItems(titleItem, textItem, locationPicker, showMethodPicker, 
                            hideMethodPicker, priorityPicker, dismiss, window);

        final NotifyActionCallback launch = this;

        Button sendButton = new Button("Send");
        sendButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                String contents = (String)textItem.getValue();
                if (contents == null || contents.isEmpty()) {
                    contents = "You left the message text empty!";
                }
                
                NotifySettings settings = new NotifySettings();
                settings.setCanDismiss((Boolean)dismiss.getValue());
                settings.setPosition((EdgeName)locationPicker.getValue());
                settings.setAppearMethod   (getNotifyTransition(showMethodPicker));
                settings.setDisappearMethod(getNotifyTransition(hideMethodPicker));
                settings.setMessagePriority((Integer)priorityPicker.getValue());

                NotifyAction[] actions = null;
                if (Boolean.TRUE.equals(window.getValue())) {
                    NotifyAction action = new NotifyAction();
                    action.setTitle("Launch...");
                    action.setActionCallback(launch);
                    actions = new NotifyAction[] {action};
                }

                Notify.addMessage(contents, actions, null, settings);
            }
        });

        configureDefaults();
        
        VLayout layout = new VLayout();
        layout.addMembers(configForm, sendButton);

        return layout;
    }

    private NotifyTransition getNotifyTransition(ComboBoxItem item) {
        String value = (String)item.getValue();
        return NotifyTransition.valueOf(value.toUpperCase());
    }

    
    Window window;

    @Override
    public void execute() {
        // if window already exists, just show it; no-ops if already being shown
        if (window == null) {
            window = new Window();

            window.setIsModal(true);
            window.setAutoSize(true);
            window.setAutoCenter(true);
            window.setShowModalMask(true);
            window.setCanDragReposition(false);
            window.setTitle("Notification Action");
            window.setShowMinimizeButton(false);

            Layout body = new Layout();
            body.setDefaultLayoutAlign(Alignment.CENTER);
            body.setLayoutLeftMargin(5);
            body.setLayoutRightMargin(5);
            body.setLayoutBottomMargin(10);
            window.setAutoChildProperties("body", body);

            Label label = new Label("In your application, this window might contain a wizard.");
            label.setWidth("100%");
            label.setHeight(40);
            label.setAlign(Alignment.CENTER);
            label.setWrap(false);
            window.addItem(label);

            Img image = new Img("other/wizard.png", 200, 250);
            window.addItem(image);
        }
        window.show();
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    protected boolean shouldWrapViewPanel() {
        return true;
    }
}