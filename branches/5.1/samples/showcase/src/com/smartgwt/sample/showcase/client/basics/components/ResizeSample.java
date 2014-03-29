package com.smartgwt.sample.showcase.client.basics.components;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ResizeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to expand or collapse the text box.";


    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            ResizeSample panel = new ResizeSample();
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

        final HTMLFlow htmlFlow = new HTMLFlow();
        htmlFlow.setHeight(45);
        htmlFlow.setWidth(75);
        htmlFlow.setTop(50);
        htmlFlow.setOverflow(Overflow.HIDDEN);
        htmlFlow.setStyleName("exampleTextBlock");
        htmlFlow.setShowEdges(true);

        String contents = "<span class='exampleDropTitle'>Ajax&nbsp;&nbsp;</span> <b>A</b>synchronous <b>J</b>avaScript " +
                "<b>A</b>nd <b>X</b>ML (AJAX) is a Web development technique for creating interactive <b>web applications</b>. " +
                "The intent is to make web pages feel more responsive by exchanging small amounts of data with the server behind" +
                " the scenes, so that the entire Web page does not have to be reloaded each time the user makes a change. " +
                "This is meant to increase the Web page's <b>interactivity</b>, <b>speed</b>, and <b>usability</b>. " +
                "(Source: <a href='http://www.wikipedia.org' title='Wikipedia' target='_blank'>Wikipedia</a>)";
        htmlFlow.setContents(contents);

        IButton expandButton = new IButton("Expand");
        expandButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlFlow.resizeBy(235, 150);
            }
        });

        IButton collapseButton = new IButton("Collapse");
        collapseButton.setLeft(120);
        collapseButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlFlow.resizeTo(75, 45);
            }
        });

        canvas.addChild(expandButton);
        canvas.addChild(collapseButton);
        canvas.addChild(htmlFlow);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}