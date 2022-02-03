/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LayoutSnapToSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>Snap-to positioning can be used to place components along a specific edge or corners "+
        "of a container, or centered in the container. The snapTo allows for components to be attached "+
        "to the edge of the container and snapOffsetLeft and snapOffsetTop allows for components to be "+
        "placed at a specific pixel or percentage offset relative to a snap position."+
        "<p>"+
        "Drag resize the containers below to see a variety of snap-to positioning behaviors.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            LayoutSnapToSample panel = new LayoutSnapToSample();
            id = panel.getID();
            return panel;
        }
        public String getID() { return id; }
        public String getDescription() { return DESCRIPTION; }
    }

    public static class TestLabel extends Label {

    	public TestLabel() {
    		setWidth(80);
    		setHeight(80);
    		setAlign(Alignment.CENTER);
    		setBorder("1px solid black");
    		setStyleName("exampleBlackText");
    	}
    }

    public Canvas getViewPanel() {
		Canvas snapContainer = new Canvas();
		snapContainer.setHeight(300);
		snapContainer.setWidth(400);
		snapContainer.setMinHeight(280);
		snapContainer.setMinWidth(280);
		snapContainer.setBorder("1px solid #7e7e7e");
		snapContainer.setOverflow(Overflow.HIDDEN);
		snapContainer.setCanDragResize(true);
		
		Label label1 = new TestLabel();
		label1.setContents("Top Left");
		label1.setBackgroundColor("#FFAAAA");
		label1.setSnapTo("TL");
		
		Label label2 = new TestLabel();
		label2.setContents("Top Right");
		label2.setBackgroundColor("#BEC9FE");
		label2.setSnapTo("TR");
		
		Label label3 = new TestLabel();
		label3.setContents("Bottom Left");
		label3.setBackgroundColor("#D8D5D6");
		label3.setSnapTo("BL");
		
		Label label4 = new TestLabel();
		label4.setContents("Bottom Right");
		label4.setBackgroundColor("#F8BFFB");
		label4.setSnapTo("BR");
		
		Label label5 = new TestLabel();
		label5.setContents("Left");
		label5.setBackgroundColor("#CCFFCC");
		label5.setSnapTo("L");
		
		Label label6 = new TestLabel();
		label6.setContents("Right");
		label6.setBackgroundColor("#AB5654");
		label6.setSnapTo("R");
		
		Label label7 = new TestLabel();
		label7.setContents("Bottom");
		label7.setBackgroundColor("#DCEFEF");
		label7.setSnapTo("B");
		
		Label label8 = new TestLabel();
		label8.setContents("Top");
		label8.setBackgroundColor("#FFCC99");
		label8.setSnapTo("T");
		
		Label label9 = new TestLabel();
		label9.setContents("Center");
		label9.setBackgroundColor("#FFFF99");
		label9.setSnapTo("C");
		
		snapContainer.addChild(label1);
		snapContainer.addChild(label2);
		snapContainer.addChild(label3);
		snapContainer.addChild(label4);
		snapContainer.addChild(label5);
		snapContainer.addChild(label6);
		snapContainer.addChild(label7);
		snapContainer.addChild(label8);
		snapContainer.addChild(label9);
		
		Canvas offsetContainer = new Canvas();
		offsetContainer.setHeight(300);
		offsetContainer.setWidth(400);
		offsetContainer.setMinHeight(280);
		offsetContainer.setMinWidth(280);
		offsetContainer.setBorder("1px solid #7e7e7e");
		offsetContainer.setOverflow(Overflow.HIDDEN);
		offsetContainer.setShowHover(true);
		offsetContainer.setPrompt("Snap offsets specified");
		offsetContainer.setCanDragResize(true);
		
		Label label1a = new TestLabel();
		label1a.setContents("Top Left");
		label1a.setBackgroundColor("#FFAAAA");
		label1a.setSnapTo("TL");
		label1a.setSnapOffsetTop(10);
		label1a.setSnapOffsetLeft(10);
		
		Label label2a = new TestLabel();
		label2a.setContents("Top Right");
		label2a.setBackgroundColor("#BEC9FE");
		label2a.setSnapTo("TR");
		label2a.setSnapOffsetTop(10);
		label2a.setSnapOffsetLeft(-10);
		
		Label label3a = new TestLabel();
		label3a.setContents("Bottom Left");
		label3a.setBackgroundColor("#D8D5D6");
		label3a.setSnapTo("BL");
		label3a.setSnapOffsetTop(-10);
		label3a.setSnapOffsetLeft(10);
		
		Label label4a = new TestLabel();
		label4a.setContents("Left");
		label4a.setBackgroundColor("#CCFFCC");
		label4a.setSnapTo("L");
		label4a.setSnapOffsetLeft(10);
		
		Label label5a = new TestLabel();
		label5a.setContents("Right");
		label5a.setBackgroundColor("#AB5654");
		label5a.setSnapTo("R");
		label5a.setSnapOffsetLeft(-10);
		
		Label label6a = new TestLabel();
		label6a.setContents("Bottom");
		label6a.setBackgroundColor("#DCEFEF");
		label6a.setSnapTo("B");
		label6a.setSnapOffsetTop(-10);
		
		Label label7a = new TestLabel();
		label7a.setContents("Top");
		label7a.setShowHover(true);
		label7a.setPrompt("SnapOffsetTop using percentage");
		label7a.setBackgroundColor("#FFCC99");
		label7a.setSnapTo("T");
		label7a.setSnapOffsetTop(10);
		
		Label label8a = new TestLabel();
		label8a.setContents("Bottom Right");
		label8a.setBackgroundColor("#F8BFFB");
		label8a.setSnapTo("BR");
		label8a.setSnapOffsetTop(-10);
		label8a.setSnapOffsetLeft(-10);
		
		offsetContainer.addChild(label1a);
		offsetContainer.addChild(label2a);
		offsetContainer.addChild(label3a);
		offsetContainer.addChild(label4a);
		offsetContainer.addChild(label5a);
		offsetContainer.addChild(label6a);
		offsetContainer.addChild(label7a);
		offsetContainer.addChild(label8a);
		
		LayoutSpacer spacer = new LayoutSpacer();
		spacer.setWidth(100);
		
		HLayout controlLayout = new HLayout();
		controlLayout.setMembersMargin(20);
		controlLayout.setHeight(800);
		controlLayout.setWidth(1000);
		controlLayout.addMember(snapContainer);
		controlLayout.addMember(spacer);
		controlLayout.addMember(offsetContainer);
		
		return controlLayout;
    }

    public String getIntro() { return DESCRIPTION; }
    protected boolean isTopIntro() { return true; }
}