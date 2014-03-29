package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class DynamicHTMLSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to display different chunks of HTML.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DynamicHTMLSample panel = new DynamicHTMLSample();
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
        layout.setAutoHeight();
        layout.setMembersMargin(10);

        final String ajax = "<hr><span class='exampleDropTitle'>Ajax&nbsp;&nbsp;</span> " +
                "<b>A</b>synchronous <b>J</b>avaScript <b>A</b>nd <b>X</b>ML (AJAX) " +
                "is a Web development technique for creating interactive <b>web applications</b>.<hr>";

        final String ria = "<hr><span class='exampleDropTitle'>RIA&nbsp;&nbsp;</span> " +
                "<b>R</b>ich <b>I</b>nternet <b>A</b>pplications (or RIA) are " +
                "<b>web applications</b> that have the features and functionality of " +
                "traditional <b>desktop applications</b>.<hr>";

        final String webapp = "<hr><span class='exampleDropTitle'>Web App&nbsp;&nbsp;</span> " +
                "In software engineering, a <b>web application</b> is an application that is " +
                "<b>accessed with a web browser</b> over a network such as the Internet or an intranet.<hr>";


        final HTMLFlow htmlFlow = new HTMLFlow();
        htmlFlow.setTop(40);
        htmlFlow.setWidth(280);
        htmlFlow.setStyleName("exampleTextBlock");
        htmlFlow.setContents(ajax);

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(5);

        IButton ajaxButton = new IButton("Ajax");
        ajaxButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlFlow.setContents(ajax);
            }
        });
        hLayout.addMember(ajaxButton);

        IButton riaButton = new IButton("RIA");
        riaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlFlow.setContents(ria);
            }
        });
        hLayout.addMember(riaButton);

        IButton webAppButton = new IButton("Web App");
        webAppButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlFlow.setContents(webapp);
            }
        });
        hLayout.addMember(webAppButton);

        layout.addMember(hLayout);
        layout.addMember(htmlFlow);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}