package com.smartgwt.sample.showcase.client.other;

import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DialogsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Click \"Confirm\" and \"Ask\" to show two of the pre-built, skinnable Smart GWT Dialogs for common interactions.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DialogsSample panel = new DialogsSample();
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

        final Label labelAnswer = new Label("Your answer here...");
        labelAnswer.setTop(50);
        labelAnswer.setWidth(300);


        IButton buttonConfirm = new IButton("Confirm");
        buttonConfirm.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.confirm("Proceed with Operation get AJAX?", new BooleanCallback() {
                    public void execute(Boolean value) {
                        if (value != null && value) {
                            labelAnswer.setContents("OK");
                        } else {
                            labelAnswer.setContents("Cancel");
                        }
                    }
                });
            }
        });

        IButton buttonAsk = new IButton("Ask");
        buttonAsk.setLeft(150);
        buttonAsk.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.ask("Are you going to stop writing great code?", new BooleanCallback() {
                    public void execute(Boolean value) {
                        if (value != null && value) {
                            labelAnswer.setContents("Yes");
                        } else {
                            labelAnswer.setContents("No");
                        }
                    }
                });
            }
        });

        Canvas main = new Canvas();
        main.addChild(labelAnswer);
        main.addChild(buttonConfirm);
        main.addChild(buttonAsk);

        return main;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}