/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.layout;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Section descriptor used by a SectionStack to describe a section of items which are shown or hidden together, and their
 * associated header.
 */
public class SectionStackSection extends RefDataClass {

    public static SectionStackSection getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SectionStackSection) obj;
        } else {
            return new SectionStackSection(jsObj);
        }
    }

    public SectionStackSection(){
        setID(com.smartgwt.client.util.SC.generateID("SectionStackSection"));
    }

    public SectionStackSection(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SectionStackSection(String title) {
        setTitle(title);
        setID(com.smartgwt.client.util.SC.generateID("SectionStackSection"));
    }

    // ********************* Properties / Attributes ***********************

    /**
     * This attribute controls whether or not the expand/collapse UI control is shown on the header of this section.  Any
     * section can still be expanded/collapsed programmatically, regardless of this setting.
     *
     * @param canCollapse canCollapse Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }

    /**
     * When explicitly set to false, disallows drop before this member in the Layout.
     *
     * @param canDropBefore canDropBefore Default value is null
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public void setCanDropBefore(Boolean canDropBefore) {
        setAttribute("canDropBefore", canDropBefore);
    }

    /**
     * If set to false, then this sectionHeader will not be able to be dragged to perform a drag reorder, if {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCanReorderSections canReorderSections} is true. You can also disable
     * dropping other sections before this one by setting  {@link com.smartgwt.client.widgets.Canvas#getCanDropBefore
     * canDropBefore} to false.
     *
     * @param canReorder canReorder Default value is null
     */
    public void setCanReorder(Boolean canReorder) {
        setAttribute("canReorder", canReorder);
    }

    /**
     * Optional ID for the section. If {@link com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} is true, this property will be applied to the generated SectionStackHeader widget as a standard
     * widget ID, meaning it should be unique within a page. <P> <b>Backcompat Note</b>: Section stack sections may be uniquely
     * identified within a stack via the {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName name} attribute
     * (introduced in Jan 2010). Prior to this, the section ID attribute was used in this way (and would not be applied to the
     * section header  as a widget ID). For backwards compatibility this is still supported: If  <code>section.name</code> is
     * unspecified for a section but <code>section.ID</code> is set, the ID will be used as a default name attribute for the
     * section. For backwards compatibility we also disable the standard behavior of having the <code>section.ID</code> being
     * applied to the generated section header (thereby avoiding the page-level uniqueness requirement) by defaulting  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs useGlobalSectionIDs} to false.
     *
     * @param ID ID Default value is null
     */
    public void setID(String ID) {
        setAttribute("ID", ID);
    }

    /**
     * Optional ID for the section. If {@link com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} is true, this property will be applied to the generated SectionStackHeader widget as a standard
     * widget ID, meaning it should be unique within a page. <P> <b>Backcompat Note</b>: Section stack sections may be uniquely
     * identified within a stack via the {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName name} attribute
     * (introduced in Jan 2010). Prior to this, the section ID attribute was used in this way (and would not be applied to the
     * section header  as a widget ID). For backwards compatibility this is still supported: If  <code>section.name</code> is
     * unspecified for a section but <code>section.ID</code> is set, the ID will be used as a default name attribute for the
     * section. For backwards compatibility we also disable the standard behavior of having the <code>section.ID</code> being
     * applied to the generated section header (thereby avoiding the page-level uniqueness requirement) by defaulting  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs useGlobalSectionIDs} to false.
     *
     *
     * @return String
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }

    /**
     * Identifier for the section.  This can be used later in calls to {@link com.smartgwt.client.widgets.layout.SectionStack}
     * APIs such as {@link com.smartgwt.client.widgets.layout.SectionStack#expandSection SectionStack.expandSection} and {@link
     * com.smartgwt.client.widgets.layout.SectionStack#collapseSection SectionStack.collapseSection}. Note that if no name is
     * specified for the section, one will be auto-generated when the section is created. This property should be a string
     * which may be used as a valid JavaScript identifier (should start with a letter and not contain space or special
     * characters such as "*").
     *
     * @param name name Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Identifier for the section.  This can be used later in calls to {@link com.smartgwt.client.widgets.layout.SectionStack}
     * APIs such as {@link com.smartgwt.client.widgets.layout.SectionStack#expandSection SectionStack.expandSection} and {@link
     * com.smartgwt.client.widgets.layout.SectionStack#collapseSection SectionStack.collapseSection}. Note that if no name is
     * specified for the section, one will be auto-generated when the section is created. This property should be a string
     * which may be used as a valid JavaScript identifier (should start with a letter and not contain space or special
     * characters such as "*").
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * If set to false, then the items in this section will not be resized by sectionHeader repositioning.  You may also set
     * this flag directly on any of the items in any section to cause that item to not be resizeable.
     *
     * @param resizeable resizeable Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_resize" target="examples">Resize Sections Example</a>
     */
    public void setResizeable(Boolean resizeable) {
        setAttribute("resizeable", resizeable);
    }

    /**
     * If true, a header will be shown for this section.  If false, no header will be shown.
     *
     * @param showHeader showHeader Default value is true
     */
    public void setShowHeader(Boolean showHeader) {
        setAttribute("showHeader", showHeader);
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    /**
     * Title to show for the section
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        if(stack == null || !stack.isDrawn()) {
            setAttribute("title", title);
        } else {
            stack.setSectionTitle(getName(), title);
        }
    }

    /**
     * Title to show for the section
     *
     * @return String
     */
    public String getTitle()  {
        if(stack == null || !stack.isDrawn()) {
            return getAttributeAsString("title");
        } else {
            return stack.getSection(getName()).getAttribute("title");
        }
    }

    /**
     * Sections default to the collapsed state unless {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getShowHeader showHeader} is set to <code>false</code> in which
     * case they default to the expanded state.  This attribute allows you to explicitly control the expand/collapse state of
     * the section by overriding the above default behavior.
     *
     * @param expanded expanded Default value is false
     */
    public void setExpanded(Boolean expanded) {
        if(stack == null || !stack.isDrawn()) {
            setAttribute("expanded", expanded);
        } else {
            if(expanded) {
                stack.expandSection(getName());
            } else {
                stack.collapseSection(getName());
            }
        }
    }

    /**
     * Sections default to the visible state.  This attribute allows you to explicitly control the visible/hidden state of the
     * section by overriding the above default behavior.
     *
     * @param hidden hidden Default value is false
     */
    public void setHidden(Boolean hidden) {
        if(stack == null || !stack.isDrawn()) {
            setAttribute("hidden", hidden);
        } else {
            if(hidden) {
                stack.hideSection(getName());
            } else {
                stack.showSection(getName());
            }
        }
    }

    /**
     * List of Canvases that constitute the section. These Canvases will be shown and hidden together.
     *
     * @param items list of Canvases that constitute the section
     */
    public void setItems(Canvas... items) {
        for (Canvas item : items) {
            addItem(item);
        }
    }

    /**
     * Return the items in this SectionStackSection
     *
     * @return the items in this SectionStackSection
     */
    public native Canvas[] getItems() /*-{
		var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if(!jsObj.items) {
            jsObj.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        return @com.smartgwt.client.widgets.Canvas::convertToCanvasArray(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.items);
    }-*/;

    public void addItem(Canvas item) {
        addItemJS(item.getOrCreateJsObj());
    }

    private native void addItemJS(JavaScriptObject componentJS) /*-{
		var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if(!jsObj.items) {
            jsObj.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        jsObj.items.push(componentJS);
    }-*/;

    public void setControls(Canvas... controls) {
        setAttribute("controls", controls);
    }
   
    /**
     * Once a SectionStackSection has been applied to a SectionStack, this method may be used to return  a pointer to the 
     * SectionStack in which this section header is embedded.
     *
     * @return the SectionStack in which this section is embedded
     */
    protected SectionStack stack;
    public SectionStack getSectionStack() {
    	return stack;
    }
    
    /**
     * Once a SectionStackSection has been applied to a SectionStack, this method may be used to return  a pointer to the 
     * SectionHeader for this section
     * @return the SectionHeader for the section
     */
    public native SectionHeader getSectionHeader () /*-{
    	var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
    	if (jsObj == null) return null;
    	
    	var sectionHeader = jsObj.getSectionHeader != null ? jsObj.getSectionHeader() : null;
	    if (sectionHeader == null) return null;
	    
	    return @com.smartgwt.client.widgets.layout.SectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(sectionHeader);
    }-*/;

}




