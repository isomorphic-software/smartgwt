
package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonAutoFitSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Buttons can automatically size to accomodate the title and icon, and resize" +
           " automatically when the title is changed, notifying components around them that they" +
           " have changed size.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ButtonAutoFitSample panel = new ButtonAutoFitSample();
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

        final IButton findButton = new IButton("Find Related");
        findButton.setAutoFit(true);
        findButton.setIcon("silk/printer.png");

        final IButton searchButton = new IButton("Search within results");
        searchButton.setAutoFit(true);
        searchButton.setIcon("silk/printer.png");
        
        HStack stack = new HStack();
        stack.setMembersMargin(20);
        stack.setHeight(24);
        stack.setBorder("1px solid gray");
        stack.addMember(findButton);
        stack.addMember(searchButton);
        canvas.addChild(stack);

        final IButton button = new IButton("Change Title");
        button.setLeft(60);
        button.setTop(45);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                String saveTitle = findButton.getTitle();
                findButton.setTitle(searchButton.getTitle());
                searchButton.setTitle(saveTitle);
            }
        });
        canvas.addChild(button);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}


