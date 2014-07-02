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
/* sgwtgen */
 
package com.smartgwt.client.widgets.layout;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A container that manages a list of sections of widgets, each with a header.  Sometimes called an "Accordion". <P>
 * SectionStack can be configured so that only one section is visible at a time (similar to MS Outlook's left-hand Nav), or
 * to allow multiple sections to be visible and share the available space.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SectionStack")
public class SectionStack extends VLayout implements com.smartgwt.client.widgets.layout.events.HasSectionHeaderClickHandlers {

    public static SectionStack getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new SectionStack(jsObj);
        } else {
            assert refInstance instanceof SectionStack;
            return (SectionStack)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.SectionStack.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.SectionStack.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public SectionStack(){
        scClassName = "SectionStack";
    }

    public SectionStack(JavaScriptObject jsObj){
        scClassName = "SectionStack";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If true, sections are animated during expand/collapse and addition/removal of SectionItems is likewise animated.
     *
     * @param animateSections  Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_sections" target="examples">Section Reveal Example</a>
     */
    public void setAnimateSections(Boolean animateSections) {
        setAttribute("animateSections", animateSections, true);
    }

    /**
     * If true, sections are animated during expand/collapse and addition/removal of SectionItems is likewise animated.
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_sections" target="examples">Section Reveal Example</a>
     */
    public Boolean getAnimateSections()  {
        return getAttributeAsBoolean("animateSections");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode} "mutex", whether to allow
     * the last remaining expanded section to be collapsed.  If false, collapsing the last open section will open the next one
     * (wrapping around at the end).
     *
     * @param canCollapseAll  Default value is true
     */
    public void setCanCollapseAll(Boolean canCollapseAll) {
        setAttribute("canCollapseAll", canCollapseAll, true);
    }

    /**
     * In {@link com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode} "mutex", whether to allow
     * the last remaining expanded section to be collapsed.  If false, collapsing the last open section will open the next one
     * (wrapping around at the end).
     *
     * @return Boolean
     */
    public Boolean getCanCollapseAll()  {
        return getAttributeAsBoolean("canCollapseAll");
    }
    

    /**
     * SectionStacks provide the same default implementation of drag and drop interactions as {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents Layouts}, except that members are added as items into the
     * section over which they're dropped. <P> If you want to completely suppress the builtin drag and drop logic, but still
     * receive drag and drop events for your own custom implementation, set {@link
     * com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop} to <code>true</code> and
     * <code>canDropComponents</code> to <code>false</code> on your SectionStack.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDropComponents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setCanDropComponents(Boolean canDropComponents)  throws IllegalStateException {
        setAttribute("canDropComponents", canDropComponents, false);
    }

    /**
     * SectionStacks provide the same default implementation of drag and drop interactions as {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents Layouts}, except that members are added as items into the
     * section over which they're dropped. <P> If you want to completely suppress the builtin drag and drop logic, but still
     * receive drag and drop events for your own custom implementation, set {@link
     * com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop} to <code>true</code> and
     * <code>canDropComponents</code> to <code>false</code> on your SectionStack.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanDropComponents()  {
        return getAttributeAsBoolean("canDropComponents");
    }
    

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder section.canReorder:false} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canReorderSections  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanReorderSections(Boolean canReorderSections)  throws IllegalStateException {
        setAttribute("canReorderSections", canReorderSections, false);
    }

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder section.canReorder:false} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     *
     * @return Boolean
     */
    public Boolean getCanReorderSections()  {
        return getAttributeAsBoolean("canReorderSections");
    }
    

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit autofitting} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable section.resizeable:false} will not be resizeable.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canResizeSections  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanResizeSections(Boolean canResizeSections)  throws IllegalStateException {
        setAttribute("canResizeSections", canResizeSections, false);
    }

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit autofitting} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable section.resizeable:false} will not be resizeable.
     *
     * @return Boolean
     */
    public Boolean getCanResizeSections()  {
        return getAttributeAsBoolean("canResizeSections");
    }
    

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.  May be
     * overridden at the Section level via {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanTabToHeader
     * canTabToHeader} <P> If unset, section headers will be focusable if {@link
     * com.smartgwt.client.util.isc#setScreenReaderMode isc.setScreenReaderMode} has been called. See {@link
     * com.smartgwt.client.docs.Accessibility}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToHeaders  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanTabToHeaders(Boolean canTabToHeaders)  throws IllegalStateException {
        setAttribute("canTabToHeaders", canTabToHeaders, false);
    }

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.  May be
     * overridden at the Section level via {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanTabToHeader
     * canTabToHeader} <P> If unset, section headers will be focusable if {@link
     * com.smartgwt.client.util.isc#setScreenReaderMode isc.setScreenReaderMode} has been called. See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @return Boolean
     */
    public Boolean getCanTabToHeaders()  {
        return getAttributeAsBoolean("canTabToHeaders");
    }
    

    /**
     * Height of headers for sections.
     *
     * @param headerHeight  Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderHeight(int headerHeight)  throws IllegalStateException {
        setAttribute("headerHeight", headerHeight, false);
    }

    /**
     * Height of headers for sections.
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
     * @param itemEndIndent  Default value is undefined
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public void setItemEndIndent(int itemEndIndent) {
        setAttribute("itemEndIndent", itemEndIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the end of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the right side of the section stack.
     *
     * @return int
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
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
     * @param itemIndent  Default value is 0
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
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
     * @return int
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public int getItemIndent()  {
        return getAttributeAsInt("itemIndent");
    }
    

    /**
     * Size, in pixels, of indentation of all member items relative to the start of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the left side of the section stack.
     * Overrides {@link com.smartgwt.client.widgets.layout.SectionStack#getItemIndent itemIndent}.
     *
     * @param itemStartIndent  Default value is undefined
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public void setItemStartIndent(int itemStartIndent) {
        setAttribute("itemStartIndent", itemStartIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the start of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the left side of the section stack.
     * Overrides {@link com.smartgwt.client.widgets.layout.SectionStack#getItemIndent itemIndent}.
     *
     * @return int
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public int getItemStartIndent()  {
        return getAttributeAsInt("itemStartIndent");
    }
    

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement} is used to parse locator strings generated
     * by link{isc.AutoTest.getLocator()}, how should sections within this stack be identified?  By default if a section has a
     * specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName Section.name} this will always be used. 
     * For sections with no name, the following options are available: <ul> <li><code>"title"</code> use the title as an
     * identifier</li> <li><code>"index"</code> use the index of the section in the sections array as an identifier</li> </ul> 
     * If unset, and the section has no specified name, default behavior is to identify by title (if available), otherwise by
     * index.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateSectionsBy  Default value is null
     */
    public void setLocateSectionsBy(LocatorStrategy locateSectionsBy) {
        setAttribute("locateSectionsBy", locateSectionsBy == null ? null : locateSectionsBy.getValue(), true);
    }

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement} is used to parse locator strings generated
     * by link{isc.AutoTest.getLocator()}, how should sections within this stack be identified?  By default if a section has a
     * specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName Section.name} this will always be used. 
     * For sections with no name, the following options are available: <ul> <li><code>"title"</code> use the title as an
     * identifier</li> <li><code>"index"</code> use the index of the section in the sections array as an identifier</li> </ul> 
     * If unset, and the section has no specified name, default behavior is to identify by title (if available), otherwise by
     * index.
     *
     * @return LocatorStrategy
     */
    public LocatorStrategy getLocateSectionsBy()  {
        return EnumUtil.getEnum(LocatorStrategy.values(), getAttribute("locateSectionsBy"));
    }
    

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding Sections within this section Stack.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateSectionsType  Default value is null
     */
    public void setLocateSectionsType(LocatorTypeStrategy locateSectionsType) {
        setAttribute("locateSectionsType", locateSectionsType == null ? null : locateSectionsType.getValue(), true);
    }

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding Sections within this section Stack.
     *
     * @return LocatorTypeStrategy
     */
    public LocatorTypeStrategy getLocateSectionsType()  {
        return EnumUtil.getEnum(LocatorTypeStrategy.values(), getAttribute("locateSectionsType"));
    }
    

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
     *
     * @param overflow  Default value is "hidden"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow == null ? null : overflow.getValue(), false);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
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
     * @param scrollSectionIntoView  Default value is true
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
     * @return Boolean
     */
    public Boolean getScrollSectionIntoView()  {
        return getAttributeAsBoolean("scrollSectionIntoView");
    }
    

    /**
     * Widget to use for section headers.   <p> Must be a subclass of either {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} or {@link com.smartgwt.client.widgets.layout.SectionHeader}.  The
     * default class used depends on the skin; {@link com.smartgwt.client.widgets.layout.SectionHeader} is the simpler and
     * lighter-weight class and uses CSS styling rather than image-based styling, and is recommended for most use cases. <p> 
     * If you create a custom section header class in Java, enable {@link com.smartgwt.client.docs.Reflection} to allow it to
     * be used. <p> Alternatively, you can use the &#83;martClient class system to create a simple &#83;martClient subclass of
     * either SectionHeader or ImgSectionHeader for use with this API - see the {@link com.smartgwt.client.docs.Skinning
     * Skinning Guide} for details.   <p> If you override event handlers on your custom SectionHeader or radically change it's
     * structure such that the default event handling no longer works, you can call  {@link
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick SectionStack.sectionHeaderClick} to replicate the
     * built-in expand/collapse handling for clicking a section header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sectionHeaderClass  Default value is "SectionHeader"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSectionHeaderClass(String sectionHeaderClass)  throws IllegalStateException {
        setAttribute("sectionHeaderClass", sectionHeaderClass, false);
    }

    /**
     * Widget to use for section headers.   <p> Must be a subclass of either {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} or {@link com.smartgwt.client.widgets.layout.SectionHeader}.  The
     * default class used depends on the skin; {@link com.smartgwt.client.widgets.layout.SectionHeader} is the simpler and
     * lighter-weight class and uses CSS styling rather than image-based styling, and is recommended for most use cases. <p> 
     * If you create a custom section header class in Java, enable {@link com.smartgwt.client.docs.Reflection} to allow it to
     * be used. <p> Alternatively, you can use the &#83;martClient class system to create a simple &#83;martClient subclass of
     * either SectionHeader or ImgSectionHeader for use with this API - see the {@link com.smartgwt.client.docs.Skinning
     * Skinning Guide} for details.   <p> If you override event handlers on your custom SectionHeader or radically change it's
     * structure such that the default event handling no longer works, you can call  {@link
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick SectionStack.sectionHeaderClick} to replicate the
     * built-in expand/collapse handling for clicking a section header.
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
     * @param showExpandControls  Default value is true
     */
    public void setShowExpandControls(Boolean showExpandControls) {
        setAttribute("showExpandControls", showExpandControls, true);
    }

    /**
     * Whether to show the Expand/Collapse controls in the headers of sections.  If false, hides the expand/collapse controls
     * and, instead, treats a click anywhere on the header as if  it were a click on the expand control.
     *
     * @return Boolean
     */
    public Boolean getShowExpandControls()  {
        return getAttributeAsBoolean("showExpandControls");
    }
    

    /**
     * Default CSS style for the SectionStack as a whole.
     *
     * @param styleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "sectionStack"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStyleName(String styleName)  throws IllegalStateException {
        setAttribute("styleName", styleName, false);
    }

    /**
     * Default CSS style for the SectionStack as a whole.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Should any specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getID ID} be applied to the generated
     * SectionHeader widget for the section as a widget ID? If set to false, SectionStackSection.ID will behave as a synonym
     * for SectionStackSection.name.
     *
     * @param useGlobalSectionIDs  Default value is false
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
     * @return Boolean
     */
    public Boolean getUseGlobalSectionIDs()  {
        return getAttributeAsBoolean("useGlobalSectionIDs");
    }
    

    /**
     * Whether multiple sections can be visible at once
     *
     * @param visibilityMode  Default value is "mutex"
     * @see com.smartgwt.client.types.VisibilityMode
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public void setVisibilityMode(VisibilityMode visibilityMode) {
        setAttribute("visibilityMode", visibilityMode == null ? null : visibilityMode.getValue(), true);
    }

    /**
     * Whether multiple sections can be visible at once
     *
     * @return VisibilityMode
     * @see com.smartgwt.client.types.VisibilityMode
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public VisibilityMode getVisibilityMode()  {
        return EnumUtil.getEnum(VisibilityMode.values(), getAttribute("visibilityMode"));
    }
    

    // ********************* Methods ***********************
	/**
     * Collapse a section or sections.  This action hides all the items assigned to the section.  Calling this method is
     * equivalent to the user clicking on the SectionHeader of an expanded section.
     * @param sections Section(s) to collapse.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section positions / names
     * @see com.smartgwt.client.widgets.layout.SectionStack#hideSection
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public native void collapseSection(int sections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.collapseSection(sections);
    }-*/;

	/**
     * Collapse a section or sections.  This action hides all the items assigned to the section.  Calling this method is
     * equivalent to the user clicking on the SectionHeader of an expanded section.
     * @param sections Section(s) to collapse.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section positions / names
     * @param callback callback to fire when the section has been collapsed
     * @see com.smartgwt.client.widgets.layout.SectionStack#hideSection
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public native void collapseSection(int sections, CollapseSectionCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.collapseSection(sections, 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.CollapseSectionCallback::execute()(
				);
			}));
    }-*/;
	
	/**
     * Expands a section or sections.  This action shows all the items assigned to the section. If the section is currently
     * hidden, it is shown first and then expanded.  Calling this method is equivalent to the user clicking on the
     * SectionHeader of a collapsed section.
     * @param sections Section(s) to expand.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names/positions.
     * @see com.smartgwt.client.widgets.layout.SectionStack#showSection
     * @see com.smartgwt.client.widgets.layout.SectionStack#getScrollSectionIntoView
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public native void expandSection(int sections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.expandSection(sections);
    }-*/;

	/**
     * Expands a section or sections.  This action shows all the items assigned to the section. If the section is currently
     * hidden, it is shown first and then expanded.  Calling this method is equivalent to the user clicking on the
     * SectionHeader of a collapsed section.
     * @param sections Section(s) to expand.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names/positions.
     * @param callback callback to fire when the section has been expanded.
     * @see com.smartgwt.client.widgets.layout.SectionStack#showSection
     * @see com.smartgwt.client.widgets.layout.SectionStack#getScrollSectionIntoView
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public native void expandSection(int sections, ExpandSectionCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.expandSection(sections, 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ExpandSectionCallback::execute()(
				);
			}));
    }-*/;
	

	/**
     * Returns the position of the specified section in the SectionStack.  The numbering is zero-based.
     * @param sectionName name of a section for which you want to obtain the position.
     *
     * @return Position of the section in the SectionStack or -1 if the specified                      section is not a member of this
     * SectionStack.
     */
    public native int getSectionNumber(String sectionName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionNumber(sectionName);
        return ret;
    }-*/;


	/**
     * Hides a section or sections.  This includes the section header and its items.  The space vacated by this action is
     * reassigned to the nearest visible section item above this section.  If there are no visible section items above this
     * section, the space is reassigned to the nearest visible section item below this section.
     * @param sections Section(s) to hide.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names / positions.
     * @see com.smartgwt.client.widgets.layout.SectionStack#collapseSection
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void hideSection(int sections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideSection(sections);
    }-*/;

	/**
     * Hides a section or sections.  This includes the section header and its items.  The space vacated by this action is
     * reassigned to the nearest visible section item above this section.  If there are no visible section items above this
     * section, the space is reassigned to the nearest visible section item below this section.
     * @param sections Section(s) to hide.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names / positions.
     * @param callback to fire when the section has been hidden
     * @see com.smartgwt.client.widgets.layout.SectionStack#collapseSection
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void hideSection(int sections, HideSectionCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideSection(sections, 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.HideSectionCallback::execute()(
				);
			}));
    }-*/;
	
	/**
     * Moves the specified section(s) to a new position in the SectionStack order.  If you pass in multiple sections, then each
     * section will be moved to <code>newPosition</code> in the order specified by the <code>sections</code> argument.
     * @param sections Section(s) to move.                  For this parameter, you can pass the position of the section in the                
     *  SectionStack, the name of the section, or a List of section names/positions.
     * @param position new position index for the section(s).
     */
    public native void moveSection(int sections, int position) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveSection(sections, position);
    }-*/;

    /**
     * Add a SectionHeaderClick handler.
     * <p>
     * Notification method fired when the user clicks on a section header. Returning false will cancel the default behavior
     * (expanding / collapsing the section)
     *
     * @param handler the SectionHeaderClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSectionHeaderClickHandler(com.smartgwt.client.widgets.layout.events.SectionHeaderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent.getType()) == 0) setupSectionHeaderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent.getType());
    }

    private native void setupSectionHeaderClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var onSectionHeaderClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onSectionHeaderClick: 
                function () {
                    var param = {"section" : arguments[0]};
                    return onSectionHeaderClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onSectionHeaderClick = 
                function () {
                    var param = {"section" : arguments[0]};
                    return onSectionHeaderClick(param) == true;
                }
            ;
        }
   }-*/;
	/**
     * Remove a section or set of sections from the SectionStack.  The removed sections' header and items (if any) are
     * automatically destroyed.
     * @param sections Section(s) to remove.                  For this parameter, you can pass the position of the section in the              
     * SectionStack, the <code>name</code> of the section, or a List of                   section <code>name</code>s or
     * indices.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_add_remove" target="examples">Add and Remove Example</a>
     */
    public native void removeSection(int sections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSection(sections);
    }-*/;


	/**
     * Search for a section that contains passed item.
     * @param item item to show
     *
     * @return section that contains passed item.
     * @see com.smartgwt.client.widgets.layout.SectionStack#expandSection
     */
    public native SectionStackSection sectionForItem(Canvas item) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionForItem(item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;



	/**
     * Method intended to be called by the sectionHeader when it is clicked on.
     * @param sectionHeader the sectionHeader clicked on
     */
    public native void sectionHeaderClick(Canvas sectionHeader) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.sectionHeaderClick(sectionHeader.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;


	/**
     * Returns true if the specified section is expanded, false if it is collapsed.
     * @param section Section for which you want to obtain information.                      For this parameter, you can pass the position of
     * the section in the                      SectionStack, or the name of the section.
     *
     * @return true if the section is expanded, false if it is not.
     */
    public native boolean sectionIsExpanded(int section) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionIsExpanded(section);
        return ret;
    }-*/;

	/**
     * Returns true if the specified section is visible, false if it is not.  A section is visible if it shows a header and the
     * header is visible or if it has items and the first item is visible.
     * @param section Section for which you want to obtain visibility information.                      For this parameter, you can pass the
     * position of the section in the                      SectionStack, or the name of the section.
     *
     * @return true if the section is visible, false if it is not.
     */
    public native boolean sectionIsVisible(int section) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionIsVisible(section);
        return ret;
    }-*/;

	/**
     * Set arbitrary properties for a particular section in this SectionStack. Properties will be applied to the sectionHeader
     * for the section. <P> Note that where APIs exist to explicitly manipulate section properties these should be used in
     * preference to this method. For example, to add or remove items in a section use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#addItem SectionStack.addItem} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#removeItem SectionStack.removeItem}. To change the title of a section,
     * use {@link com.smartgwt.client.widgets.layout.SectionStack#setSectionTitle SectionStack.setSectionTitle}. <P> Also note
     * that to modify properties of items within a section, call the appropriate setter methods directly on the item you want
     * to modify.
     * @param section ID or index of the section to modify
     * @param properties properties to apply to the section.
     */
    public native void setSectionProperties(String section, SectionStackSection properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSectionProperties(section, properties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Changes the title of a SectionHeader.
     * @param section ID or index of the section whose title you want to change
     * @param newTitle new title for the SectionHeader
     */
    public native void setSectionTitle(String section, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSectionTitle(section, newTitle);
    }-*/;

	/**
     * Shows a section or sections.  This includes the section header and its items.  If the section is collapsed, only the
     * header is shown.  If the section is expanded, the section header and all items are shown.
     * @param sections Section(s) to show.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names / positions.
     * @see com.smartgwt.client.widgets.layout.SectionStack#expandSection
     * @see com.smartgwt.client.widgets.layout.SectionStack#getScrollSectionIntoView
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void showSection(int sections) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showSection(sections);
    }-*/;

	/**
     * Shows a section or sections.  This includes the section header and its items.  If the section is collapsed, only the
     * header is shown.  If the section is expanded, the section header and all items are shown.
     * @param sections Section(s) to show.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section names / positions.
     * @param callback callback to fire when the sections have been shown.
     * @see com.smartgwt.client.widgets.layout.SectionStack#expandSection
     * @see com.smartgwt.client.widgets.layout.SectionStack#getScrollSectionIntoView
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void showSection(int sections, ShowSectionCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showSection(sections, 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ShowSectionCallback::execute()(
				);
			}));
    }-*/;
	

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param sectionStackProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SectionStack sectionStackProperties) /*-{
    	var properties = $wnd.isc.addProperties({},sectionStackProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.SectionStack.addProperties(properties);
    }-*/;

    // ***********************************************************



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
     * @see removeSection(int)
     * @param sectionID the section ID
     */
    public native void removeSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.removeSection(sectionID);
    }-*/;

    /**
     * @see expandSection(int)
     * @param sectionID the section ID
     */
    public native void expandSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.expandSection(sectionID);
    }-*/;

    /**
     * @see collapseSection(int)
     * @param sectionID the section ID
     */
    public native void collapseSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.collapseSection(sectionID);
    }-*/;

    /**
     * @see hideSection(int)
     * @param sectionID the section ID
     */
    public native void hideSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.hideSection(sectionID);
    }-*/;

    /**
     * @see showSection(int)
     * @param sectionID the section ID
     */
    public native void showSection(String sectionID) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.showSection(sectionID);
    }-*/;

    /**
     * @see moveSection(int, int)
     * @param sectionID the section ID
     * @param position  new position index for the section
     */
    public native void moveSection(String sectionID, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.moveSection(sectionID, position);
    }-*/;

    /**
     * @see sectionIsExpanded(int)
     * @param sectionID the section ID
     * @return true if the section is expanded, false if it is not.
     */
    public native boolean sectionIsExpanded(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.sectionIsExpanded(sectionID);
    }-*/;

    /**
     * @see sectionIsVisible(int)
     * @param sectionID the section ID
     * @return true if the section is visible, false if it is not
     */
    public native boolean sectionIsVisible(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
   	    return self.sectionIsVisible(sectionID);
    }-*/;

    /**
     * {@link #setSectionTitle(String, String)}
     * 
     * @param index index of the section whose title you want to change
     * @param newTitle new title for the Section Header
     * @see #setSectionTitle(String, String)
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
        return @com.smartgwt.client.util.ConvertTo::arrayOfSectionStackSection(Lcom/google/gwt/core/client/JavaScriptObject;)(sectionsArr);

    }-*/;

    /**
     * @see setSectionProperties(String,SectionStackSection)
     * @param section ID or index of the section to modify
     * @param properties properties to apply to the section.
     */
     public native void setSectionProperties(int index, SectionStackSection properties) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var props = properties.@com.smartgwt.client.widgets.layout.SectionStackSection::getJsObj()();
         self.setSectionProperties(section, props);
     }-*/;

    public LogicalStructureObject setLogicalStructure(SectionStackLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.animateSections = getAttributeAsString("animateSections");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.animateSections:" + t.getMessage() + "\n";
        }
        try {
            s.canCollapseAll = getAttributeAsString("canCollapseAll");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.canCollapseAll:" + t.getMessage() + "\n";
        }
        try {
            s.canDropComponents = getAttributeAsString("canDropComponents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.canDropComponents:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderSections = getAttributeAsString("canReorderSections");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.canReorderSections:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeSections = getAttributeAsString("canResizeSections");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.canResizeSections:" + t.getMessage() + "\n";
        }
        try {
            s.canTabToHeaders = getAttributeAsString("canTabToHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.canTabToHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.headerHeight = getAttributeAsString("headerHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.headerHeight:" + t.getMessage() + "\n";
        }
        try {
            s.itemEndIndent = getAttributeAsString("itemEndIndent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.itemEndIndent:" + t.getMessage() + "\n";
        }
        try {
            s.itemIndent = getAttributeAsString("itemIndent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.itemIndent:" + t.getMessage() + "\n";
        }
        try {
            s.itemStartIndent = getAttributeAsString("itemStartIndent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.itemStartIndent:" + t.getMessage() + "\n";
        }
        try {
            s.locateSectionsBy = getAttributeAsString("locateSectionsBy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.locateSectionsBy:" + t.getMessage() + "\n";
        }
        try {
            s.locateSectionsType = getAttributeAsString("locateSectionsType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.locateSectionsType:" + t.getMessage() + "\n";
        }
        try {
            s.overflow = getAttributeAsString("overflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.overflow:" + t.getMessage() + "\n";
        }
        try {
            s.scrollSectionIntoView = getAttributeAsString("scrollSectionIntoView");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.scrollSectionIntoView:" + t.getMessage() + "\n";
        }
        try {
            s.sectionHeaderClass = getAttributeAsString("sectionHeaderClass");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.sectionHeaderClass:" + t.getMessage() + "\n";
        }
        try {
            s.showExpandControls = getAttributeAsString("showExpandControls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.showExpandControls:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.useGlobalSectionIDs = getAttributeAsString("useGlobalSectionIDs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.useGlobalSectionIDs:" + t.getMessage() + "\n";
        }
        try {
            s.visibilityMode = getAttributeAsString("visibilityMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.visibilityMode:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        SectionStackLogicalStructure s = new SectionStackLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

