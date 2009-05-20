package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class LabelSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The Label component adds alignment, text wrapping, and icon support for small chunks of standard HTML.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            LabelSample panel = new LabelSample();
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
        Label label = new Label();
        label.setHeight(30);
        label.setPadding(10);
        label.setAlign(Alignment.CENTER);
        label.setValign(VerticalAlignment.CENTER);
        label.setWrap(false);
        label.setIcon("icons/16/approved.png");
        label.setShowEdges(true);
        label.setContents("<i>Approved</i> for release");
        return label;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}