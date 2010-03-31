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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

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
 * A container that manages a list of sections of widgets, each with a header.  Sometimes called an "Accordion". <P>
 * SectionStack can be configured so that only one section is visible at a time (similar to MS Outlook's left-hand Nav), or
 * to allow multiple sections to be visible and share the available space.
 */
public class SectionStack extends VLayout  implements com.smartgwt.client.widgets.layout.events.HasSectionHeaderClickHandlers {

    public static SectionStack getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (SectionStack) obj;
        } else {
            return new SectionStack(jsObj);
        }
    }

    public SectionStack(){
        scClassName = "SectionStack";
    }

    public SectionStack(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If true, sections are animated during expand/collapse and addition/removal of SectionItems is likewise animated.
     *
     * @param animateSections animateSections Default value is null
     */
    public void setAnimateSections(Boolean animateSections) {
        setAttribute("animateSections", animateSections, true);
    }

    /**
     * If true, sections are animated during expand/collapse and addition/removal of SectionItems is likewise animated.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateSections()  {
        return getAttributeAsBoolean("animateSections");
    }

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder 'section.canReorder:false'} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canReorderSections canReorderSections Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanReorderSections(Boolean canReorderSections)  throws IllegalStateException {
        setAttribute("canReorderSections", canReorderSections, false);
    }

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder 'section.canReorder:false'} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     *
     *
     * @return Boolean
     */
    public Boolean getCanReorderSections()  {
        return getAttributeAsBoolean("canReorderSections");
    }

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit 'autofitting'} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable 'section.resizeable:false'} will not be resizeable.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canResizeSections canResizeSections Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanResizeSections(Boolean canResizeSections)  throws IllegalStateException {
        setAttribute("canResizeSections", canResizeSections, false);
    }

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit 'autofitting'} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable 'section.resizeable:false'} will not be resizeable.
     *
     *
     * @return Boolean
     */
    public Boolean getCanResizeSections()  {
        return getAttributeAsBoolean("canResizeSections");
    }

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToHeaders canTabToHeaders Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanTabToHeaders(Boolean canTabToHeaders)  throws IllegalStateException {
        setAttribute("canTabToHeaders", canTabToHeaders, false);
    }

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.
     *
     *
     * @return Boolean
     */
    public Boolean getCanTabToHeaders()  {
        return getAttributeAsBoolean("canTabToHeaders");
    }

    /**
     * Height of headers for sections.
     *
     * @param headerHeight headerHeight Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderHeight(int headerHeight)  throws IllegalStateException {
        setAttribute("headerHeight", headerHeight, false);
    }

    /**
     * Height of headers for sections.
     *
     *
     * @return int
     */
    public int getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the end of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the right side of the section stack.
     *
     * @param itemEndIndent itemEndIndent Default value is undefined
     */
    public void setItemEndIndent(int itemEndIndent) {
        setAttribute("itemEndIndent", itemEndIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the end of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the right side of the section stack.
     *
     *
     * @return int
     */
    public int getItemEndIndent()  {
        return getAttributeAsInt("itemEndIndent");
    }

    /**
     * Size, in pixels, of indentation of all member items. Items will be offset and reduced in width by this amount.
     * Overridden by {@link com.smartgwt.client.widgets.layout.SectionStack#getItemStartIndent itemStartIndent} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getItemEndIndent itemEndIndent}. Setting itemIndent is equivalent to
     * setting itemStartIndent to the same amount and itemEndIndent to 0.
     *
     * @param itemIndent itemIndent Default value is 0
     */
    public void setItemIndent(int itemIndent) {
        setAttribute("itemIndent", itemIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items. Items will be offset and reduced in width by this amount.
     * Overridden by {@link com.smartgwt.client.widgets.layout.SectionStack#getItemStartIndent itemStartIndent} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getItemEndIndent itemEndIndent}. Setting itemIndent is equivalent to
     * setting itemStartIndent to the same amount and itemEndIndent to 0.
     *
     *
     * @return int
     */
    public int getItemIndent()  {
        return getAttributeAsInt("itemIndent");
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the start of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the left side of the section stack.
     * Overrides {@link com.smartgwt.client.widgets.layout.SectionStack#getItemIndent itemIndent}.
     *
     * @param itemStartIndent itemStartIndent Default value is undefined
     */
    public void setItemStartIndent(int itemStartIndent) {
        setAttribute("itemStartIndent", itemStartIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the start of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the left side of the section stack.
     * Overrides {@link com.smartgwt.client.widgets.layout.SectionStack#getItemIndent itemIndent}.
     *
     *
     * @return int
     */
    public int getItemStartIndent()  {
        return getAttributeAsInt("itemStartIndent");
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
     *
     * @param overflow overflow Default value is "hidden"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow.getValue(), false);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
     *
     *
     * @return Overflow
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
     * If an expanded or shown section expands past the current viewport and this property is true, then the viewport will
     * auto-scroll to fit as much of the section content into the viewport without scrolling the top of the section out of the
     * viewport.
     *
     * @param scrollSectionIntoView scrollSectionIntoView Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setScrollSectionIntoView(Boolean scrollSectionIntoView)  throws IllegalStateException {
        setAttribute("scrollSectionIntoView", scrollSectionIntoView, false);
    }

    /**
     * If an expanded or shown section expands past the current viewport and this property is true, then the viewport will
     * auto-scroll to fit as much of the section content into the viewport without scrolling the top of the section out of the
     * viewport.
     *
     *
     * @return Boolean
     */
    public Boolean getScrollSectionIntoView()  {
        return getAttributeAsBoolean("scrollSectionIntoView");
    }

    /**
     * Name of the Canvas subclass to use as a header that labels the section and allows showing and hiding.  The default class
     * can be skinned, or trivial subclasses created to allow different appearances for headers in different SectionStacks. <P>
     * Very advanced developers can use the following information to create custom header classes. <P> The SectionStack will
     * instantiate this class, giving the following properties on init: <ul> <li><code>layout</code>: the SectionStack
     * <li><code>expanded</code>: true or false <li><code>hidden</code>: true or false <li><code>title</code>: section title
     * </ul> From then on, when the sectionHeader is clicked on, it should call {@link
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick}. <br> Whenever the section is hidden or shown,
     * sectionHeader.setExpanded(true|false) will be called if implemented.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sectionHeaderClass sectionHeaderClass Default value is "SectionHeader"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSectionHeaderClass(String sectionHeaderClass)  throws IllegalStateException {
        setAttribute("sectionHeaderClass", sectionHeaderClass, false);
    }

    /**
     * Name of the Canvas subclass to use as a header that labels the section and allows showing and hiding.  The default class
     * can be skinned, or trivial subclasses created to allow different appearances for headers in different SectionStacks. <P>
     * Very advanced developers can use the following information to create custom header classes. <P> The SectionStack will
     * instantiate this class, giving the following properties on init: <ul> <li><code>layout</code>: the SectionStack
     * <li><code>expanded</code>: true or false <li><code>hidden</code>: true or false <li><code>title</code>: section title
     * </ul> From then on, when the sectionHeader is clicked on, it should call {@link
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick}. <br> Whenever the section is hidden or shown,
     * sectionHeader.setExpanded(true|false) will be called if implemented.
     *
     *
     * @return String
     */
    public String getSectionHeaderClass()  {
        return getAttributeAsString("sectionHeaderClass");
    }

    /**
     * Whether to show the Expand/Collapse controls in the headers of sections.  If false, hides the expand/collapse controls
     * and, instead, treats a click anywhere on the header as if  it were a click on the expand control.
     *
     * @param showExpandControls showExpandControls Default value is true
     */
    public void setShowExpandControls(Boolean showExpandControls) {
        setAttribute("showExpandControls", showExpandControls, true);
    }

    /**
     * Whether to show the Expand/Collapse controls in the headers of sections.  If false, hides the expand/collapse controls
     * and, instead, treats a click anywhere on the header as if  it were a click on the expand control.
     *
     *
     * @return Boolean
     */
    public Boolean getShowExpandControls()  {
        return getAttributeAsBoolean("showExpandControls");
    }

    /**
     * Should any specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getID ID} be applied to the generated
     * SectionHeader widget for the section as a widget ID? If set to false, SectionStackSection.ID will behave as a synonym
     * for SectionStackSection.name.
     *
     * @param useGlobalSectionIDs useGlobalSectionIDs Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseGlobalSectionIDs(Boolean useGlobalSectionIDs)  throws IllegalStateException {
        setAttribute("useGlobalSectionIDs", useGlobalSectionIDs, false);
    }

    /**
     * Should any specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getID ID} be applied to the generated
     * SectionHeader widget for the section as a widget ID? If set to false, SectionStackSection.ID will behave as a synonym
     * for SectionStackSection.name.
     *
     *
     * @return Boolean
     */
    public Boolean getUseGlobalSectionIDs()  {
        return getAttributeAsBoolean("useGlobalSectionIDs");
    }

    /**
     * Whether multiple sections can be visible at once
     *
     * @param visibilityMode visibilityMode Default value is "mutex"
     */
    public void setVisibilityMode(VisibilityMode visibilityMode) {
        setAttribute("visibilityMode", visibilityMode.getValue(), true);
    }

    /**
     * Whether multiple sections can be visible at once
     *
     *
     * @return VisibilityMode
     */
    public VisibilityMode getVisibilityMode()  {
        return EnumUtil.getEnum(VisibilityMode.values(), getAttribute("visibilityMode"));
    }

    // ********************* Methods ***********************
            
    /**
     * Returns the position of the specified section in the SectionStack.  The numbering is zero-based.
     * @param sectionName name of a section for which you want to obtain the position.
     *
     * @return Position of the section in the SectionStack or -1 if the specified                      section is not a member of this
     * SectionStack.
     */
    public native int getSectionNumber(String sectionName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSectionNumber(sectionName);
    }-*/;
            
    /**
     * Method intended to be called by the sectionHeader when it is clicked on.
     * @param sectionHeader the sectionHeader clicked on
     */
    public native void sectionHeaderClick(Canvas sectionHeader) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.sectionHeaderClick(sectionHeader.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    // ********************* Static Methods ***********************



	  public void setSections(SectionStackSection... sections) {
        for (SectionStackSection section : sections) {
            addSection(section);
        }
    }

    /**
     * Add a section to the SectionStack.
     *
     * @param section the section to add
     */
    public void addSection(SectionStackSection section) {
        JavaScriptObject componentJS = section.getJsObj();

        if (isCreated()) {
            addSectionPostCreate(componentJS);

        } else {
            addSectionPreCreate(componentJS);
        }
        section.stack = this;
    }

    /**
     * Add a section to the SectionStack.
     *
     * @param section  the section to add
     * @param position index for the new section
     */
    public void addSection(SectionStackSection section, int position) {
        JavaScriptObject componentJS = section.getJsObj();

        if (isCreated()) {
            addSectionPostCreate(componentJS, position);

        } else {
            addSectionPreCreate(componentJS, position);
        }
        section.stack = this;
    }

    private native void addSectionPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.sections) {
            config.sections = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.sections.push(componentJS);
    }-*/;

    private native void addSectionPostCreate(JavaScriptObject componentJS) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addSection(componentJS);
        
    }-*/;

    private native void addSectionPreCreate(JavaScriptObject componentJS, int position) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.sections) {
            config.sections = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.sections = config.sections.splice(position,0, componentJS);;
    }-*/;

    private native void addSectionPostCreate(JavaScriptObject componentJS, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (position < 0 || container.sections == null) position = 0;
        else if (position > container.sections.length) position = container.sections.length;
        container.addSection(componentJS, position);
        
    }-*/;
    
    /**
     * Remove a section from the SectionStack. The removed sections' header and items (if any) are automatically
     * destroyed.
     *
     * @param index the section index
     */
    public native void removeSection(int index) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.removeSection(index);
    }-*/;

    /**
     * Remove a section from the SectionStack. The removed sections' header and items (if any) are automatically
     * destroyed.
     *
     * @param sectionID the section ID
     */
    public native void removeSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.removeSection(sectionID);
    }-*/;

    /**
     * Expands a section. This action shows all the items assigned to the section. If the section is currently hidden,
     * it is shown first and then expanded. Calling this method is equivalent to the user clicking on the SectionHeader
     * of a collapsed section.
     *
     * @param index the section index
     */
    public native void expandSection(int index) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.expandSection(index);
    }-*/;

    /**
     * Expands a section. This action shows all the items assigned to the section. If the section is currently hidden,
     * it is shown first and then expanded. Calling this method is equivalent to the user clicking on the SectionHeader
     * of a collapsed section.
     *
     * @param sectionID the section ID
     */
    public native void expandSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.expandSection(sectionID);
    }-*/;

    /**
     * Collapse a section. This action hides all the items assigned to the section. Calling this method is equivalent to
     * the user clicking on the SectionHeader of an expanded section.
     *
     * @param index the section index
     */
    public native void collapseSection(int index) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.collapseSection(index);
    }-*/;

    /**
     * Collapse a section. This action hides all the items assigned to the section. Calling this method is equivalent to
     * the user clicking on the SectionHeader of an expanded section.
     *
     * @param sectionID the section ID
     */
    public native void collapseSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.collapseSection(sectionID);
    }-*/;

    /**
     * Hides a section. This includes the section header and its items. The space vacated by this action is reassigned
     * to the nearest visible section item above this section. If there are no visible section items above this section,
     * the space is reassigned to the nearest visible section item below this section.
     *
     * @param index the section index
     */
    public native void hideSection(int index) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.hideSection(index);
    }-*/;

    /**
     * Hides a section. This includes the section header and its items. The space vacated by this action is reassigned
     * to the nearest visible section item above this section. If there are no visible section items above this section,
     * the space is reassigned to the nearest visible section item below this section.
     *
     * @param sectionID the section ID
     */
    public native void hideSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.hideSection(sectionID);
    }-*/;


    /**
     * Shows a section. This includes the section header and its items. If the section is collapsed, only the header is
     * shown. If the section is expanded, the section header and all items are shown.
     *
     * @param index the section index
     */
    public native void showSection(int index) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.showSection(index);
    }-*/;

    /**
     * Shows a section. This includes the section header and its items. If the section is collapsed, only the header is
     * shown. If the section is expanded, the section header and all items are shown.
     *
     * @param sectionID the section ID
     */
    public native void showSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.showSection(sectionID);
    }-*/;

    /**
     * Moves the specified section to a new position in the SectionStack order.
     *
     * @param index    the section index
     * @param position new position index for the section
     */
    public native void moveSection(int index, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.moveSection(index, position);
    }-*/;

    /**
     * Moves the specified section to a new position in the SectionStack order.
     *
     * @param sectionID the section ID
     * @param position  new position index for the section
     */
    public native void moveSection(String sectionID, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.moveSection(sectionID, position);
    }-*/;

    /**
     * Returns true if the specified section is expanded, false if it is collapsed.
     *
     * @param index position of the section in the SectionStack
     * @return true if the section is expanded, false if it is not.
     */
    public native boolean sectionIsExpanded(int index) /*-{
	    var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    return self.sectionIsExpanded(index);
    }-*/;

    /**
     * Returns true if the specified section is expanded, false if it is collapsed.
     *
     * @param sectionID the section ID
     * @return true if the section is expanded, false if it is not.
     */
    public native boolean sectionIsExpanded(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.sectionIsExpanded(sectionID);
    }-*/;

    /**
     * Returns true if the specified section is visible, false if it is not. A section is visible if it shows a header
     * and the header is visible or if it has items and the first item is visible. .
     *
     * @param index position of the section in the SectionStack
     * @return ttrue if the section is visible, false if it is not
     */
    public native boolean sectionIsVisible(int index) /*-{
	    var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    return self.sectionIsVisible(index);
    }-*/;

    /**
     * Returns true if the specified section is visible, false if it is not. A section is visible if it shows a header
     * and the header is visible or if it has items and the first item is visible.
     *
     * @param sectionID the section ID
     * @return true if the section is visible, false if it is not
     */
    public native boolean sectionIsVisible(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.sectionIsVisible(sectionID);
    }-*/;

    /**
     * Changes the title of a Section Header.
     *
     * @param sectionID ID of the section whose title you want to change
     * @param newTitle new title for the Section Header
     */
    public native void setSectionTitle(String sectionID, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.setSectionTitle(sectionID, newTitle);
    }-*/;

    /**
     * Changes the title of a Section Header.
     *
     * @param index index of the section whose title you want to change
     * @param newTitle new title for the Section Header
     */
    public native void setSectionTitle(int index, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.setSectionTitle(index, newTitle);
    }-*/;

    /**
     * Return the SectionStackSection for a section.
     *
     * @param sectionID ID of the section for which you want the header
     *
     * @return the section indicated
     */
    public native SectionStackSection getSection(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionConfig(sectionID);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return the SectionStackSection for a section.
     * @param index index of the section for which you want the header
     *
     * @return the section header indicated
     */
    public native SectionStackSection getSection(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionConfig(index);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    public native SectionStackSection[] getSections() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sections;
        if(ret == null || ret === undefined) return null;
        var sectionsArr = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        for (var i = 0; i < ret.length; i++) {
            var jsSectionHeader = ret[i];
            sectionsArr[i] = jsSectionHeader.getSectionConfig ? jsSectionHeader.getSectionConfig() : jsSectionHeader;
        }
        return  this.@com.smartgwt.client.widgets.layout.SectionStack::convertToSectionArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sectionsArr);

    }-*/;

    private SectionStackSection[] convertToSectionArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new SectionStackSection[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        SectionStackSection[] objects = new SectionStackSection[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            SectionStackSection obj = SectionStackSection.getOrCreateRef(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Add a onSectionHeaderClick handler.
     * <p>
     * Notification method fired when the user clicks on a section header.&#010 Returning false will cancel the default behavior (expanding / collapsing the section)&#010
     *
     * @param handler the onSectionHeaderClick handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSectionHeaderClickHandler(com.smartgwt.client.widgets.layout.events.SectionHeaderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent.getType()) == 0) setupSectionHeaderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent.getType());
    }
    private native void setupSectionHeaderClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onSectionHeaderClick:$entry(function(){
                    var param = {"section" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                })
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onSectionHeaderClick = $entry(function(){
                var param = {"section" : arguments[0]};
                var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            });
        }
    }-*/;
    /**
     * Set arbitrary properties for a particular section in this SectionStack. Properties will be applied to the sectionHeader
     * for the section. <P> Note that where APIs exist to explicitly manipulate section properties these should be used in
     * preference to this method. For example, to add or remove items in a section use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#addItem} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#removeItem}. To change the title of a section, use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#setSectionTitle}. <P> Also note that to modify properties of items
     * within a section, call the appropriate setter methods directly on the item you want to modify.
     * @param section ID or index of the section to modify
     * @param properties properties to apply to the section.
     */
     public native void setSectionProperties(String section, SectionStackSection properties)
     /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var props = properties.@com.smartgwt.client.widgets.layout.SectionStackSection::getJsObj()();
         self.setSectionProperties(section, props);
     }-*/;
    /**
     * Set arbitrary properties for a particular section in this SectionStack. Properties will be applied to the sectionHeader
     * for the section. <P> Note that where APIs exist to explicitly manipulate section properties these should be used in
     * preference to this method. For example, to add or remove items in a section use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#addItem} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#removeItem}. To change the title of a section, use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#setSectionTitle}. <P> Also note that to modify properties of items
     * within a section, call the appropriate setter methods directly on the item you want to modify.
     * @param section ID or index of the section to modify
     * @param properties properties to apply to the section.
     */
     public native void setSectionProperties(int section, SectionStackSection properties)
     /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var props = properties.@com.smartgwt.client.widgets.layout.SectionStackSection::getJsObj()();
         self.setSectionProperties(section, props);
     }-*/;

}




