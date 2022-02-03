package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class SelectContentSample extends ShowcasePanel {
    private static final String DESCRIPTION = "To enable native browser selection of widget content, "+
        "set the \"setCanSelectText()\" method to true. "+
        "Note that this property is enabled by default for the <i>HTMLFlow</i> class which is typically "+
        "used to display blocks of HTML content to users.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SelectContentSample panel = new SelectContentSample();
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
        label.setWidth(400);
        label.setHeight(100);
        label.setAlign(Alignment.CENTER);
        label.setShowEdges(true);
        label.setCanSelectText(true);
        label.setContents("This content can be selected for copy and paste.");
        
        return label;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}