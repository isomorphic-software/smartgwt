package com.smartgwt.sample.showcase.client.basics.components;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LayerSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to move the draggable box above or below the other boxes.";


    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            LayerSample panel = new LayerSample();
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

        Label bottomLabel = new Label("Bottom");
        bottomLabel.setAlign(Alignment.CENTER);
        bottomLabel.setShowEdges(true);
        bottomLabel.setBackgroundColor("lightblue");
        canvas.addChild(bottomLabel);

        final Label middleLabel = new Label("Middle");
        middleLabel.setAlign(Alignment.CENTER);
        middleLabel.setShowEdges(true);
        middleLabel.setBackgroundColor("lightgreen");
        middleLabel.setLeft(60);
        middleLabel.setTop(60);
        canvas.addChild(middleLabel);

        Label topLabel = new Label("Top");
        topLabel.setAlign(Alignment.CENTER);
        topLabel.setShowEdges(true);
        topLabel.setBackgroundColor("pink");
        topLabel.setLeft(120);
        topLabel.setTop(120);
        canvas.addChild(topLabel);

        final Label dragWidget = new Label("Drag Me");
        dragWidget.setAlign(Alignment.CENTER);
        dragWidget.setShowEdges(true);
        dragWidget.setBackgroundColor("lightyellow");
        dragWidget.setLeft(120);
        dragWidget.setTop(0);
        dragWidget.setCanDragReposition(true);
        dragWidget.setDragAppearance(DragAppearance.TARGET);
        canvas.addChild(dragWidget);

        VStack vStack = new VStack();
        vStack.setLeft(250);
        vStack.setMembersMargin(10);

        IButton frontButton = new IButton("Front");
        frontButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dragWidget.bringToFront();
            }
        });
        vStack.addMember(frontButton);

        IButton backButton = new IButton("Back");
        backButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dragWidget.sendToBack();
            }
        });
        vStack.addMember(backButton);

        IButton aboveMiddleButton = new IButton("Above Middle");
        aboveMiddleButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dragWidget.moveAbove(middleLabel);
            }
        });
        vStack.addMember(aboveMiddleButton);

        IButton belowMiddleButton = new IButton("Below Middle");
        belowMiddleButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dragWidget.moveBelow(middleLabel);
            }
        });
        vStack.addMember(belowMiddleButton);

        canvas.addChild(vStack);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}