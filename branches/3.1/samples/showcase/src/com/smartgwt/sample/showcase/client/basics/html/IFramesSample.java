package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class IFramesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to display different websites.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            IFramesSample panel = new IFramesSample();
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
        layout.setWidth100();
        layout.setHeight100();

        final HTMLPane htmlPane = new HTMLPane();
        htmlPane.setShowEdges(true);
        htmlPane.setContentsURL("http://www.google.com/");
        htmlPane.setContentsType(ContentsType.PAGE);

        HStack hStack = new HStack();
        hStack.setHeight(50);
        hStack.setLayoutMargin(10);
        hStack.setMembersMargin(10);

        IButton yahooButton = new IButton("Yahoo");
        yahooButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlPane.setContentsURL("http://www.yahoo.com/");
            }
        });
        hStack.addMember(yahooButton);

        IButton googleButton = new IButton("Google");
        googleButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlPane.setContentsURL("http://www.google.com/");
            }
        });
        hStack.addMember(googleButton);

        IButton wikipediaButton = new IButton("Wikipedia");
        wikipediaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlPane.setContentsURL("http://www.wikipedia.org/");
            }
        });
        hStack.addMember(wikipediaButton);

        IButton baiduButton = new IButton("Baidu");
        baiduButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlPane.setContentsURL("http://www.baidu.com/");
            }
        });
        hStack.addMember(baiduButton);

        layout.addMember(hStack);
        layout.addMember(htmlPane);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}