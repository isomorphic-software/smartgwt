package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class HTMLPaneSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The HTMLPane component displays a chunk or page of standard HTML in a sizeable, scrollable pane.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            HTMLPaneSample panel = new HTMLPaneSample();
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

        HTMLPane htmlPane = new HTMLPane();
        htmlPane.setWidth(230);
        htmlPane.setHeight(150);
        htmlPane.setShowEdges(true);
        htmlPane.setStyleName("exampleTextBlock");
        String contents = "<span class='exampleDropTitle'>Ajax&nbsp;&nbsp;</span> <b>A</b>synchronous " +
                "<b>J</b>avaScript <b>A</b>nd <b>X</b>ML (AJAX) is a Web development technique for creating interactive " +
                "<b>web applications</b>. The intent is to make web pages feel more responsive by exchanging small amounts " +
                "of data with the server behind the scenes, so that the entire Web page does not have to be reloaded each time " +
                "the user makes a change. This is meant to increase the Web page's <b>interactivity</b>, <b>speed</b>, and " +
                "<b>usability</b>. (Source: <a href='http://www.wikipedia.org' title='Wikipedia' target='_blank'>Wikipedia</a>)";
        htmlPane.setContents(contents);
        return htmlPane;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}