package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class HTMLFlowSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The HTMLFlow component displays a chunk of standard HTML in a free-form, flowable region.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            HTMLFlowSample panel = new HTMLFlowSample();
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

        HTMLFlow htmlFlow = new HTMLFlow();
        htmlFlow.setWidth(230);
        htmlFlow.setStyleName("exampleTextBlock");
        String contents = "<hr><span class='exampleDropTitle'>Ajax&nbsp;&nbsp;</span> " +
                "<b>A</b>synchronous <b>J</b>avaScript <b>A</b>nd <b>X</b>ML (AJAX) is a " +
                "Web development technique for creating interactive <b>web applications</b>.<hr>";
        htmlFlow.setContents(contents);
        return htmlFlow;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}