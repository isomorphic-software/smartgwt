package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonStatesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Move the mouse over the buttons, and click and hold to see buttons in different states. " +
            "Click \"Disable All\" to put all buttons in the disabled state. Edit the CSS style definitions " +
            "to change the appearance of various states.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ButtonStatesSample panel = new ButtonStatesSample();
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

        final IButton stretchButton = new IButton("Stretch Button");
        stretchButton.setWidth(150);
        stretchButton.setShowRollOver(true);
        stretchButton.setShowDisabled(true);
        stretchButton.setShowDown(true);
        stretchButton.setTitleStyle("stretchTitle");
        stretchButton.setIcon("[SKINIMG]/headerIcons/arrow_right.png");

        final Button cssButton = new Button("CSS Button");
        cssButton.setShowRollOver(true);
        cssButton.setShowDisabled(true);
        cssButton.setShowDown(true);
        cssButton.setIcon("icons/16/icon_add_files.png");

        final ImgButton imgButton = new ImgButton();
        imgButton.setWidth(18);
        imgButton.setHeight(18);
        imgButton.setShowRollOver(true);
        imgButton.setShowDown(false);
        imgButton.setSrc("[SKIN]/headerIcons/minimize.png");

        final IButton button = new IButton("Disable All");
        button.setWidth(120);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (cssButton.isDisabled()) {
                    cssButton.enable();
                    stretchButton.enable();
                    imgButton.enable();
                    button.setTitle("Disable All");
                } else {
                    cssButton.disable();
                    stretchButton.disable();
                    imgButton.disable();
                    button.setTitle("Enable All");
                }

            }
        });

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(20);
        hLayout.addMember(stretchButton);
        hLayout.addMember(cssButton);
        hLayout.addMember(imgButton);

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


