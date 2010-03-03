package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonIconsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Click and hold on the \"Save\" button to see the icon change as the button goes" +
           " down. Note that the binoculars icon does not change when the button goes down.</p>" +
           " <p>Click \"Disable Save\" to see the icon change to reflect disabled state. Button" +
           " icons can be left or right oriented, and can optionally react to any state" +
           " of the button.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ButtonIconsSample panel = new ButtonIconsSample();
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

        final IButton findButton = new IButton("Print");
        findButton.setWidth(120);
        findButton.setIcon("silk/printer.png");

        final IButton saveButton = new IButton("Save");
        saveButton.setShowRollOver(true);
        saveButton.setIcon("icons/16/icon_add_files.png");
        saveButton.setIconOrientation("right");
        saveButton.setShowDownIcon(true);

        final IButton button = new IButton("Disable Save");
        button.setWidth(120);
        button.setLeft(60);
        button.setTop(45);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (saveButton.isDisabled()) {
                    saveButton.enable();
                    button.setTitle("Disable Save");
                } else {
                    saveButton.disable();
                    button.setTitle("Enable Save");
                }
            }
        });

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(20);
        hLayout.addMember(findButton);
        hLayout.addMember(saveButton);

        VLayout layout = new VLayout();
        layout.setAutoHeight();
        layout.setMembersMargin(30);
        layout.addMember(hLayout);
        layout.addMember(button);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}


