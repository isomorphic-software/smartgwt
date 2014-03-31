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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CenterAlignSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>To center components within layouts, set layout.align to center along the length "+
        "axis (vertical axis for a VLayout, horizontal axis for an HLayout).</p>"+
        "<p>To center along the breadth axis (horizontal axis for an VLayout, vertical axis "+
        "for an HLayout), set member.layoutAlign on each member that should be centered, or "+
        "set layout.defaultLayoutAlign to center all members.</p>"+
        "<p>Combine both settings to center along both axes.</p>"+
        "<p>You can also use LayoutSpacers to center components. This is particularly useful "+
        "if you have a layout where you want to center something in the remaining space "+
        "after other components have taken the space they require.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            CenterAlignSample panel = new CenterAlignSample();
            id = panel.getID();
            return panel;
        }
        public String getID() { return id; }
        public String getDescription() { return DESCRIPTION; }
    }

    private class LayoutAlignCenterExample extends VLayout {
        Canvas example;
        public LayoutAlignCenterExample(Canvas example, final String title) {
            this.setTitle(title);
            this.example = example;
            this.setLayoutMargin(2);
            this.setMembersMargin(2);
            
            this.addMember(new Label() {{
                this.setWidth100();
                this.setAutoFit(true);
                this.setPadding(6);
                this.setContents(title);
            }});
            this.addMember(example);
        }
    }
    
    public Canvas getViewPanel() {
        // There are 3 HLayout examples and 3 VLayout examples
        //
        // 1. HLayout with layout.align = 'center'
        // 2. HLayout with member.layoutAlign = 'center' (or layout.defaultLayoutAlign = 'center')
        // 3. HLayout with LayoutSpacers
        // 4. VLayout with layout.align = 'center'
        // 5. VLayout with member.layoutAlign = 'center' (or layout.defaultLayoutAlign = 'center')
        // 6. VLayout with LayoutSpacers
        
        
        // 1. HLayout with layout.align = 'center'
        //
        // This centers the members along the horizontal axis of the HLayout.
        // Note that the members have a specified width that is less than the
        // width of the HLayout -- otherwise, you would not see the centering
        // visually!
        final HLayout hLayoutAlignCenter = new HLayout();
        // Specifying the width creates space within which to center the members.
        hLayoutAlignCenter.setWidth100();
        hLayoutAlignCenter.setHeight100();
        hLayoutAlignCenter.setLayoutMargin(6);
        hLayoutAlignCenter.setMembersMargin(6);
        hLayoutAlignCenter.setBorder("1px dashed blue");
        hLayoutAlignCenter.setAlign(Alignment.CENTER); // As promised!
        
        hLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("red");
        }});
        hLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("green");
        }});
        hLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("blue");
        }});
        
        // 2. HLayout with member.layoutAlign = 'center' (or layout.defaultLayoutAlign = 'center')
        //
        // This centers every member along the vertical axis of the HLayout.
        // If you don't want to center *every* member vertically, you can
        // instead specify the layoutAlign property on individual members.
        // Note that the height of the members is fixed -- if they filled
        // the layout, you wouldn't see the centering.
        
        final HLayout hLayoutDefaultLayoutAlign = new HLayout();
        // Specifying the width creates space within which to center the members.
        hLayoutDefaultLayoutAlign.setWidth100();
        hLayoutDefaultLayoutAlign.setHeight100();
        hLayoutDefaultLayoutAlign.setLayoutMargin(6);
        hLayoutDefaultLayoutAlign.setMembersMargin(6);
        hLayoutDefaultLayoutAlign.setBorder("1px dashed blue");
        hLayoutDefaultLayoutAlign.setDefaultLayoutAlign(Alignment.CENTER); // As promised!
        
        hLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("red");
        }});
        hLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("green");
        }});
        hLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("blue");
        }});
        
        // 3. HLayout with LayoutSpacers
        //
        // This example uses LayoutSpacers as members to center one member in the space
        // remaining after the first member is drawn. Note that it is the positioning
        // of the two LayoutSpacer members that creates the centering ... no alignment
        // property is used.
        final HLayout hLayoutLayoutSpacers = new HLayout();
        // Specifying the width creates space for the LayoutSpacers to distribute.
        hLayoutLayoutSpacers.setWidth100();
        hLayoutLayoutSpacers.setHeight100();
        hLayoutLayoutSpacers.setLayoutMargin(6);
        hLayoutLayoutSpacers.setMembersMargin(6);
        hLayoutLayoutSpacers.setBorder("1px dashed blue");
        // Note no alignment property! It's all done with LayoutSpacers
        hLayoutLayoutSpacers.addMember(new Canvas() {{
            setHeight(40);
            setWidth("33%");
            setPadding(10);
            setContents("<b>No alignment</b>");
            setBackgroundColor("red");
        }});
        hLayoutLayoutSpacers.addMember(new LayoutSpacer()); // Note the use of the LayoutSpacer
        hLayoutLayoutSpacers.addMember(new Canvas() {{
            setHeight(40);
            setWidth("33%");
            setPadding(10);
            setContents("<b>Centered in remaning space</b>");
            setBackgroundColor("green");
        }});
        hLayoutLayoutSpacers.addMember(new LayoutSpacer()); // Note the use of the LayoutSpacer
        
        // 4. VLayout with layout.align = 'center'
        //
        // This centers the members along the vertical axis of the VLayout.
        // Note that the members have a specified height that is less than the
        // height of the VLayout -- otherwise, you would not see the centering
        // visually!
        final VLayout vLayoutAlignCenter = new VLayout();
        // Specifying the height creates space within which to center the members.
        vLayoutAlignCenter.setWidth100();
        vLayoutAlignCenter.setHeight100();
        vLayoutAlignCenter.setLayoutMargin(6);
        vLayoutAlignCenter.setMembersMargin(6);
        vLayoutAlignCenter.setBorder("1px dashed blue");
        vLayoutAlignCenter.setAlign(Alignment.CENTER);
        
        vLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("red");
        }});
        vLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("green");
        }});
        vLayoutAlignCenter.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("blue");
        }});
        
        // 5. VLayout with member.layoutAlign = 'center' (or layout.defaultLayoutAlign = 'center')
        //
        // This centers every member along the horizontal axis of the VLayout.
        // If you don't want to center *every* member horizontally, you can
        // instead specify the layoutAlign property on individual members.
        // Note that the width of the members is fixed -- if they filled
        // the layout, you wouldn't see the centering.
        final VLayout vLayoutDefaultLayoutAlign = new VLayout();
        // Specifying the width creates space within which to center the members.
        vLayoutDefaultLayoutAlign.setWidth100();
        vLayoutDefaultLayoutAlign.setHeight100();
        vLayoutDefaultLayoutAlign.setLayoutMargin(6);
        vLayoutDefaultLayoutAlign.setMembersMargin(6);
        vLayoutDefaultLayoutAlign.setBorder("1px dashed blue");
        vLayoutDefaultLayoutAlign.setDefaultLayoutAlign(Alignment.CENTER); // As promised!
        
        vLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("red");
        }});
        vLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("green");
        }});
        vLayoutDefaultLayoutAlign.addMember(new Canvas() {{
            setHeight(40);
            setWidth(40);
            setBackgroundColor("blue");
        }});
        
        // 6. VLayout with LayoutSpacers
        //
        // This example uses LayoutSpacers as members to center one member in the space
        // remaining after the first member is drawn. Note that it is the positioning
        // of the two LayoutSpacer members that creates the centering ... no alignment
        // property is used.
        final VLayout vLayoutLayoutSpacers = new VLayout();
        // Specifying the width creates space for the LayoutSpacers to distribute.
        vLayoutLayoutSpacers.setWidth100();
        vLayoutLayoutSpacers.setHeight100();
        vLayoutLayoutSpacers.setLayoutMargin(6);
        vLayoutLayoutSpacers.setMembersMargin(6);
        vLayoutLayoutSpacers.setBorder("1px dashed blue");
        // Note no alignment property! It's all done with LayoutSpacers
        vLayoutLayoutSpacers.addMember(new Canvas() {{
            setWidth100();
            setHeight("33%");
            setPadding(10);
            setContents("<b>No alignment</b>");
            setBackgroundColor("red");
        }});
        vLayoutLayoutSpacers.addMember(new LayoutSpacer()); // Note the use of the LayoutSpacer
        vLayoutLayoutSpacers.addMember(new Canvas() {{
            setWidth100();
            setHeight("33%");
            setPadding(10);
            setBackgroundColor("green");
            setContents("<b>Centered in remaning space</b>");
        }});
        vLayoutLayoutSpacers.addMember(new LayoutSpacer()); // Note the use of the LayoutSpacer
        
        // The rest of the code is merely to organize the examples visually.
        HLayout mainLayout = new HLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        
        mainLayout.addMember(new VLayout() {{
            setWidth("40%");
                             
            addMember(new LayoutAlignCenterExample(hLayoutAlignCenter, 
                "HLayout with layout.align = 'center'"));
            
            addMember(new LayoutAlignCenterExample(hLayoutDefaultLayoutAlign,
                "HLayout with member.layoutAlign = 'center' "+
                "(or layout.defaultLayoutAlign = 'center')"));
            
            addMember(new LayoutAlignCenterExample(hLayoutLayoutSpacers, 
                "HLayout with LayoutSpacers"));
        }});
        
        mainLayout.addMember(new LayoutAlignCenterExample(vLayoutAlignCenter,
            "VLayout with layout.align = 'center'"));
        
        mainLayout.addMember(new LayoutAlignCenterExample(vLayoutDefaultLayoutAlign,
            "VLayout with member.layoutAlign = 'center' (or layout.defaultLayoutAlign = 'center')"));
        
        mainLayout.addMember(new LayoutAlignCenterExample(vLayoutLayoutSpacers,
            "VLayout with LayoutSpacers"));
        
        return mainLayout;
    }

    public String getIntro() { return DESCRIPTION; }
    protected boolean isTopIntro() { return true; }
}