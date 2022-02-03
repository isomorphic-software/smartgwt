package com.smartgwt.sample.showcase.client.basics.components;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class StackSample extends ShowcasePanel {
    private static final String DESCRIPTION = "HStack and VStack containers manage the stacked positions of multiple member components.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            StackSample panel = new StackSample();
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

        VStack vStack = new VStack();
        vStack.setShowEdges(true);
        vStack.setWidth(150);
        vStack.setMembersMargin(5);
        vStack.setLayoutMargin(10);
        vStack.addMember(new BlueBox(null, 40, "height 40"));
        vStack.addMember(new BlueBox(null, 80, "height 80"));
        vStack.addMember(new BlueBox(null, 160, "height 160"));
        canvas.addChild(vStack);

        HStack hStack = new HStack();
        hStack.setLeft(170);
        hStack.setShowEdges(true);
        hStack.setHeight(150);
        hStack.setMembersMargin(5);
        hStack.setLayoutMargin(10);
        hStack.addMember(new BlueBox(60, null, "width 60"));
        hStack.addMember(new BlueBox(80, null, "width 80"));
        hStack.addMember(new BlueBox(160, null, "width 160"));
        canvas.addChild(hStack);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    class BlueBox extends Label {

        public BlueBox(String contents) {
            setAlign(Alignment.CENTER);
            setBorder("1px solid #808080");
            setBackgroundColor("#C3D9FF");
            setContents(contents);
        }

        public BlueBox(Integer width, Integer height, String contents) {
            this(contents);
            if (width != null) setWidth(width);
            if (height != null) setHeight(height);
        }
    }

}

