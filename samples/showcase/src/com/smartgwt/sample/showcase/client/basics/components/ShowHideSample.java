package com.smartgwt.sample.showcase.client.basics.components;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ShowHideSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to show or hide the message.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            ShowHideSample panel = new ShowHideSample();
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

        VLayout layout = new VLayout();
        layout.setMembersMargin(10);

        final Label textbox = new Label();
        textbox.setID("textbox");
        textbox.setAlign(Alignment.CENTER);
        textbox.setShowEdges(true);
        textbox.setPadding(5);
        textbox.setLeft(50);
        textbox.setTop(50);
        textbox.setParentElement(layout);
        textbox.setWidth(200);
        textbox.setContents("The future has a way of arriving unannounced.");
        textbox.setVisibility(Visibility.HIDDEN);

        IButton showButton = new IButton();
        showButton.setTitle("Show");
        showButton.setLeft(40);
        showButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                textbox.show();
            }
        });

        IButton hideButton = new IButton();
        hideButton.setTitle("Hide");
        hideButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                textbox.hide();
            }
        });

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.addMember(showButton);
        hLayout.addMember(hideButton);
        layout.addMember(hLayout);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}