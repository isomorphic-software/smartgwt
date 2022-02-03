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
import com.smartgwt.client.data.Record;
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
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
import com.smartgwt.logicalstructure.widgets.ace.*;
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
 * to allow multiple sections to be visible and share the available space.  For further details, see {@link
 * com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode}.
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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SectionStack.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SectionStack.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SectionStack.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SectionStack.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * @param animateSections New animateSections value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_sections" target="examples">Section Reveal Example</a>
     */
    public SectionStack setAnimateSections(Boolean animateSections) {
        return (SectionStack)setAttribute("animateSections", animateSections, true);
    }

    /**
     * If true, sections are animated during expand/collapse and addition/removal of SectionItems is likewise animated.
     *
     * @return Current animateSections value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_sections" target="examples">Section Reveal Example</a>
     */
    public Boolean getAnimateSections()  {
        return getAttributeAsBoolean("animateSections");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode} {@link
     * com.smartgwt.client.types.VisibilityMode#MUTEX}, whether to allow the last remaining expanded section to be collapsed. 
     * If false, collapsing the last open section will open the next one (wrapping around at the end).
     *
     * @param canCollapseAll New canCollapseAll value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     */
    public SectionStack setCanCollapseAll(Boolean canCollapseAll) {
        return (SectionStack)setAttribute("canCollapseAll", canCollapseAll, true);
    }

    /**
     * In {@link com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode} {@link
     * com.smartgwt.client.types.VisibilityMode#MUTEX}, whether to allow the last remaining expanded section to be collapsed. 
     * If false, collapsing the last open section will open the next one (wrapping around at the end).
     *
     * @return Current canCollapseAll value. Default value is true
     */
    public Boolean getCanCollapseAll()  {
        Boolean result = getAttributeAsBoolean("canCollapseAll");
        return result == null ? true : result;
    }
    

    /**
     * SectionStacks provide the same default implementation of drag and drop interactions as {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents Layouts}, except that members are added as items into the
     * section over which they're dropped. <P> If you want to completely suppress the builtin drag and drop logic, but still
     * receive drag and drop events for your own custom implementation, set {@link
     * com.smartgwt.client.widgets.Canvas#getCanAcceptDrop Canvas.canAcceptDrop} to <code>true</code> and
     * <code>canDropComponents</code> to <code>false</code> on your SectionStack.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDropComponents New canDropComponents value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public SectionStack setCanDropComponents(Boolean canDropComponents)  throws IllegalStateException {
        return (SectionStack)setAttribute("canDropComponents", canDropComponents, false);
    }

    /**
     * SectionStacks provide the same default implementation of drag and drop interactions as {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents Layouts}, except that members are added as items into the
     * section over which they're dropped. <P> If you want to completely suppress the builtin drag and drop logic, but still
     * receive drag and drop events for your own custom implementation, set {@link
     * com.smartgwt.client.widgets.Canvas#getCanAcceptDrop Canvas.canAcceptDrop} to <code>true</code> and
     * <code>canDropComponents</code> to <code>false</code> on your SectionStack.
     *
     * @return Current canDropComponents value. Default value is true
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanDropComponents()  {
        Boolean result = getAttributeAsBoolean("canDropComponents");
        return result == null ? true : result;
    }
    

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder section.canReorder:false} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canReorderSections New canReorderSections value. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setCanReorderSections(Boolean canReorderSections)  throws IllegalStateException {
        return (SectionStack)setAttribute("canReorderSections", canReorderSections, false);
    }

    /**
     * Whether sections can be drag reordered by the user dragging the section header. <P> Note that, with
     * <code>canReorderSections:true</code>, sections with  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanReorder section.canReorder:false} will not be able to be
     * drag-reordered (though their index may still be changed by dropping other sections above or below them in the section
     * stack).
     *
     * @return Current canReorderSections value. Default value is false
     */
    public Boolean getCanReorderSections()  {
        Boolean result = getAttributeAsBoolean("canReorderSections");
        return result == null ? false : result;
    }
    

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit autofitting} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable section.resizeable:false} will not be resizeable.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canResizeSections New canResizeSections value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setCanResizeSections(Boolean canResizeSections)  throws IllegalStateException {
        return (SectionStack)setAttribute("canResizeSections", canResizeSections, false);
    }

    /**
     * Whether sections can be drag resized by the user dragging the section header. <P> Note that, with
     * <code>canResizeSections:true</code>, not all sections can be resized: sections that contain only {@link
     * com.smartgwt.client.widgets.Button#getAutoFit autofitting} components or that are marked with {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getResizeable section.resizeable:false} will not be resizeable.
     *
     * @return Current canResizeSections value. Default value is true
     */
    public Boolean getCanResizeSections()  {
        Boolean result = getAttributeAsBoolean("canResizeSections");
        return result == null ? true : result;
    }
    

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.  May be
     * overridden at the Section level via {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanTabToHeader
     * SectionStackSection.canTabToHeader} <P> If unset, section headers will be focusable if  {@link
     * com.smartgwt.client.util.SC#setScreenReaderMode SC.setScreenReaderMode()}  has been called. See {@link
     * com.smartgwt.client.docs.Accessibility}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToHeaders New canTabToHeaders value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setCanTabToHeaders(Boolean canTabToHeaders)  throws IllegalStateException {
        return (SectionStack)setAttribute("canTabToHeaders", canTabToHeaders, false);
    }

    /**
     * If true, the headers for the sections (if shown) will be included in the page's tab order for accessibility.  May be
     * overridden at the Section level via {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanTabToHeader
     * SectionStackSection.canTabToHeader} <P> If unset, section headers will be focusable if  {@link
     * com.smartgwt.client.util.SC#setScreenReaderMode SC.setScreenReaderMode()}  has been called. See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @return Current canTabToHeaders value. Default value is null
     */
    public Boolean getCanTabToHeaders()  {
        return getAttributeAsBoolean("canTabToHeaders");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "SectionStackEditProxy"
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public SectionStack setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (SectionStack)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "SectionStackEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Height of headers for sections.
     *
     * @param headerHeight New headerHeight value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setHeaderHeight(int headerHeight)  throws IllegalStateException {
        return (SectionStack)setAttribute("headerHeight", headerHeight, false);
    }

    /**
     * Height of headers for sections.
     *
     * @return Current headerHeight value. Default value is 20
     */
    public int getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }
    

    /**
     * Size, in pixels, of indentation of all member items relative to the end of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the right side of the section stack.
     *
     * @param itemEndIndent New itemEndIndent value. Default value is undefined
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public SectionStack setItemEndIndent(int itemEndIndent) {
        return (SectionStack)setAttribute("itemEndIndent", itemEndIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the end of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the right side of the section stack.
     *
     * @return Current itemEndIndent value. Default value is undefined
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
     * @param itemIndent New itemIndent value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public SectionStack setItemIndent(int itemIndent) {
        return (SectionStack)setAttribute("itemIndent", itemIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items. Items will be offset and reduced in width by this amount.
     * Overridden by {@link com.smartgwt.client.widgets.layout.SectionStack#getItemStartIndent itemStartIndent} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getItemEndIndent itemEndIndent}. Setting itemIndent is equivalent to
     * setting itemStartIndent to the same amount and itemEndIndent to 0.
     *
     * @return Current itemIndent value. Default value is 0
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
     * @param itemStartIndent New itemStartIndent value. Default value is undefined
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public SectionStack setItemStartIndent(int itemStartIndent) {
        return (SectionStack)setAttribute("itemStartIndent", itemStartIndent, true);
    }

    /**
     * Size, in pixels, of indentation of all member items relative to the start of the alignment axis. For instance, for
     * left-aligned members,  itemStartIndent specifies indentation for every item from the left side of the section stack.
     * Overrides {@link com.smartgwt.client.widgets.layout.SectionStack#getItemIndent itemIndent}.
     *
     * @return Current itemStartIndent value. Default value is undefined
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public int getItemStartIndent()  {
        return getAttributeAsInt("itemStartIndent");
    }
    

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()}, how should sections within this
     * stack be identified?  By default if a section has a specified {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getName Section.name} this will always be used.  For sections
     * with no name, the following options are available: <ul> <li><code>"title"</code> use the title as an identifier</li>
     * <li><code>"index"</code> use the index of the section in the sections array as an identifier</li> </ul>  If unset, and
     * the section has no specified name, default behavior is to identify by title (if available), otherwise by index.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateSectionsBy New locateSectionsBy value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     */
    public SectionStack setLocateSectionsBy(LocatorStrategy locateSectionsBy) {
        return (SectionStack)setAttribute("locateSectionsBy", locateSectionsBy == null ? null : locateSectionsBy.getValue(), true);
    }

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()}, how should sections within this
     * stack be identified?  By default if a section has a specified {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getName Section.name} this will always be used.  For sections
     * with no name, the following options are available: <ul> <li><code>"title"</code> use the title as an identifier</li>
     * <li><code>"index"</code> use the index of the section in the sections array as an identifier</li> </ul>  If unset, and
     * the section has no specified name, default behavior is to identify by title (if available), otherwise by index.
     *
     * @return Current locateSectionsBy value. Default value is null
     */
    public LocatorStrategy getLocateSectionsBy()  {
        return EnumUtil.getEnum(LocatorStrategy.values(), getAttribute("locateSectionsBy"));
    }
    

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding Sections within this section Stack.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateSectionsType New locateSectionsType value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     */
    public SectionStack setLocateSectionsType(LocatorTypeStrategy locateSectionsType) {
        return (SectionStack)setAttribute("locateSectionsType", locateSectionsType == null ? null : locateSectionsType.getValue(), true);
    }

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding Sections within this section Stack.
     *
     * @return Current locateSectionsType value. Default value is null
     */
    public LocatorTypeStrategy getLocateSectionsType()  {
        return EnumUtil.getEnum(LocatorTypeStrategy.values(), getAttribute("locateSectionsType"));
    }
    

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
     *
     * @param overflow New overflow value. Default value is "hidden"
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     */
    public SectionStack setOverflow(Overflow overflow) {
        return (SectionStack)setAttribute("overflow", overflow == null ? null : overflow.getValue(), true);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if sections are resized to exceed the specified size, whereas an overflow:visible Layout will grow to
     * accommodate the resized sections.
     *
     * @return Current overflow value. Default value is "hidden"
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }
    

    /**
     * If an expanded or shown section expands past the current viewport and this property is true, then the viewport will
     * auto-scroll to fit as much of the section content into the viewport without scrolling the top of the section out of the
     * viewport.
     *
     * @param scrollSectionIntoView New scrollSectionIntoView value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setScrollSectionIntoView(Boolean scrollSectionIntoView)  throws IllegalStateException {
        return (SectionStack)setAttribute("scrollSectionIntoView", scrollSectionIntoView, false);
    }

    /**
     * If an expanded or shown section expands past the current viewport and this property is true, then the viewport will
     * auto-scroll to fit as much of the section content into the viewport without scrolling the top of the section out of the
     * viewport.
     *
     * @return Current scrollSectionIntoView value. Default value is true
     */
    public Boolean getScrollSectionIntoView()  {
        Boolean result = getAttributeAsBoolean("scrollSectionIntoView");
        return result == null ? true : result;
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
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick sectionHeaderClick()} to replicate the built-in
     * expand/collapse handling for clicking a section header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sectionHeaderClass New sectionHeaderClass value. Default value is "SectionHeader"
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setSectionHeaderClass(String sectionHeaderClass)  throws IllegalStateException {
        return (SectionStack)setAttribute("sectionHeaderClass", sectionHeaderClass, false);
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
     * com.smartgwt.client.widgets.layout.SectionStack#sectionHeaderClick sectionHeaderClick()} to replicate the built-in
     * expand/collapse handling for clicking a section header.
     *
     * @return Current sectionHeaderClass value. Default value is "SectionHeader"
     */
    public String getSectionHeaderClass()  {
        return getAttributeAsString("sectionHeaderClass");
    }
    
    

    /**
     * Whether to show the Expand/Collapse controls in the headers of sections.  If false, hides the expand/collapse controls
     * and, instead, treats a click anywhere on the header as if  it were a click on the expand control.
     *
     * @param showExpandControls New showExpandControls value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     */
    public SectionStack setShowExpandControls(Boolean showExpandControls) {
        return (SectionStack)setAttribute("showExpandControls", showExpandControls, true);
    }

    /**
     * Whether to show the Expand/Collapse controls in the headers of sections.  If false, hides the expand/collapse controls
     * and, instead, treats a click anywhere on the header as if  it were a click on the expand control.
     *
     * @return Current showExpandControls value. Default value is true
     */
    public Boolean getShowExpandControls()  {
        Boolean result = getAttributeAsBoolean("showExpandControls");
        return result == null ? true : result;
    }
    

    /**
     * Default CSS style for the SectionStack as a whole.
     *
     * @param styleName New styleName value. Default value is "sectionStack"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setStyleName(String styleName)  throws IllegalStateException {
        setAttribute("styleName", styleName, false);
    }

    /**
     * Default CSS style for the SectionStack as a whole.
     *
     * @return Current styleName value. Default value is "sectionStack"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Should any specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getID SectionStackSection.ID} be
     * applied to the generated SectionHeader widget for the section as a widget ID? If set to false, SectionStackSection.ID
     * will behave as a synonym for SectionStackSection.name.
     *
     * @param useGlobalSectionIDs New useGlobalSectionIDs value. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionStack setUseGlobalSectionIDs(Boolean useGlobalSectionIDs)  throws IllegalStateException {
        return (SectionStack)setAttribute("useGlobalSectionIDs", useGlobalSectionIDs, false);
    }

    /**
     * Should any specified {@link com.smartgwt.client.widgets.layout.SectionStackSection#getID SectionStackSection.ID} be
     * applied to the generated SectionHeader widget for the section as a widget ID? If set to false, SectionStackSection.ID
     * will behave as a synonym for SectionStackSection.name.
     *
     * @return Current useGlobalSectionIDs value. Default value is false
     */
    public Boolean getUseGlobalSectionIDs()  {
        Boolean result = getAttributeAsBoolean("useGlobalSectionIDs");
        return result == null ? false : result;
    }
    

    /**
     * Whether multiple sections can be expanded.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.SectionStack#getVisibilityMode visibilityMode}.
     *
     * @param visibilityMode new <code>visibilityMode</code> setting. If this is {@link com.smartgwt.client.types.VisibilityMode#MUTEX} then all but
     * the first expanded section is collapsed. Default value is "mutex"
     * @return {@link com.smartgwt.client.widgets.layout.SectionStack SectionStack} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.SectionStack#setCanCollapseAll
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public SectionStack setVisibilityMode(VisibilityMode visibilityMode) {
        return (SectionStack)setAttribute("visibilityMode", visibilityMode == null ? null : visibilityMode.getValue(), true);
    }

    /**
     * Whether multiple sections can be expanded.
     *
     * @return Current visibilityMode value. Default value is "mutex"
     * @see com.smartgwt.client.widgets.layout.SectionStack#getCanCollapseAll
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public VisibilityMode getVisibilityMode()  {
        return EnumUtil.getEnum(VisibilityMode.values(), getAttribute("visibilityMode"));
    }
    

    // ********************* Methods ***********************
	/**
     * Add a canvas as an item to a section.
     * @param section ID or index of the section to add item to
     * @param item Item to insert into the section
     * @param index Index into section to insert item
     */
    public native void addItem(String section, Canvas item, int index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addItem", "String,Canvas,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addItem(section, item == null ? null : item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
    }-*/;

	/**
     * Collapse a section or sections.  This action hides all the items assigned to the section.  Calling this method is
     * equivalent to the user clicking on the SectionHeader of an expanded section.
     * @param sections Section(s) to collapse.  For this parameter, you can pass the position                       of the section in the
     * SectionStack, the name of the section, or a                      List of section positions / names
     * @see com.smartgwt.client.widgets.layout.SectionStack#hideSection
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public native void collapseSection(int sections) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "collapseSection", "int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "collapseSection", "int,CollapseSectionCallback");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "expandSection", "int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "expandSection", "int,ExpandSectionCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.expandSection(sections, 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ExpandSectionCallback::execute()(
				);
			}));
    }-*/;
	
	/**
     * Returns a list of all {@link com.smartgwt.client.widgets.layout.SectionStackSection#getName section names} in the order
     * in which  they appear in the SectionStack.
     *
     * @return list of all section names in the order in which they appear in the SectionStack.
     */
    public native List getSectionNames() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectionNames", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionNames();
        return ret;
    }-*/;

	/**
     * Returns the position of the specified section in the SectionStack.  The numbering is zero-based.
     * @param sectionName name of a section for which you want to obtain the position.
     *
     * @return Position of the section in the SectionStack or -1 if the specified                      section is not a member of this
     * SectionStack.
     */
    public native int getSectionNumber(String sectionName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectionNumber", "String");
        }
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
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void hideSection(int sections) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideSection", "int");
        }
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
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void hideSection(int sections, HideSectionCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideSection", "int,HideSectionCallback");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveSection", "int,int");
        }
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onSectionHeaderClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SectionStack::handleTearDownSectionHeaderClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onSectionHeaderClick"));
            obj.addProperties({onSectionHeaderClick: 
                function () {
                    var param = {"_this": this, "section" : arguments[0]};
                    var ret = onSectionHeaderClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onSectionHeaderClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onSectionHeaderClick"));
            obj.onSectionHeaderClick = 
                function () {
                    var param = {"_this": this, "section" : arguments[0]};
                    var ret = onSectionHeaderClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onSectionHeaderClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownSectionHeaderClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent.getType()) == 0) tearDownSectionHeaderClickEvent();
    }

    private native void tearDownSectionHeaderClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onSectionHeaderClick")) delete obj.onSectionHeaderClick;
    }-*/;

	/**
     * Remove an item from a section.
     * @param section ID or index of the section to remove item from
     * @param item Item to remove
     */
    public native void removeItem(String section, Canvas item) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeItem", "String,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeItem(section, item == null ? null : item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Remove a section or set of sections from the SectionStack.  The removed sections' header and controls (if any) are
     * automatically destroyed.  A section's {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems items} will
     * also be destroyed if {@link com.smartgwt.client.widgets.layout.SectionStackSection#getDestroyOnRemove destroyOnRemove}
     * is set on the section.
     * @param sections Section(s) to remove.                  For this parameter, you can pass the position of the section in the              
     * SectionStack, the <code>name</code> of the section, or a List of                   section <code>name</code>s or
     * indices.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_add_remove" target="examples">Add and Remove Example</a>
     */
    public native void removeSection(int sections) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeSection", "int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sectionForItem", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionForItem(item == null ? null : item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Method intended to be called by the sectionHeader when it is clicked on.
     * @param sectionHeader the sectionHeader clicked on
     */
    public native void sectionHeaderClick(Canvas sectionHeader) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sectionHeaderClick", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.sectionHeaderClick(sectionHeader == null ? null : sectionHeader.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Returns true if the specified section is expanded, false if it is collapsed.
     * @param section Section for which you want to obtain information.                      For this parameter, you can pass the position of
     * the section in the                      SectionStack, or the name of the section.
     *
     * @return true if the section is expanded, false if it is not.
     */
    public native boolean sectionIsExpanded(int section) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sectionIsExpanded", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionIsExpanded(section);
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sectionIsVisible", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sectionIsVisible(section);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Sets a new list of canvii as items into the specified section by removing the existing items, then adding the new ones. 
     * Initial items for a section should be specified using the property {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getItems SectionStackSection.items}.
     * @param section ID or index of the section to set items on
     * @param items new items to add
     */
    public native void setItems(String section, Canvas... items) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setItems", "String,Canvas...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setItems(section, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(items));
    }-*/;

	/**
     * Set arbitrary properties for a particular section in this SectionStack. Properties will be applied to the sectionHeader
     * for the section. <P> Note that where APIs exist to explicitly manipulate section properties these should be used in
     * preference to this method. For example, to add or remove items in a section use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#addItem addItem()} or {@link
     * com.smartgwt.client.widgets.layout.SectionStack#removeItem removeItem()}. To change the title of a section, use {@link
     * com.smartgwt.client.widgets.layout.SectionStack#setSectionTitle setSectionTitle()}. <P> Also note that to modify
     * properties of items within a section, call the appropriate setter methods directly on the item you want to modify.
     * @param section ID or index of the section to modify
     * @param properties properties to apply to the section.
     */
    public native void setSectionProperties(String section, SectionStackSection properties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSectionProperties", "String,SectionStackSection");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSectionProperties(section,
			$wnd.isc.addProperties({},properties.@com.smartgwt.client.core.DataClass::getJsObj()()));
    }-*/;

	/**
     * Changes the title of a SectionHeader.
     * @param section ID or index of the section whose title you want to change
     * @param newTitle new title for the SectionHeader
     */
    public native void setSectionTitle(String section, String newTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSectionTitle", "String,String");
        }
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
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void showSection(int sections) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showSection", "int");
        }
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
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_show_hide" target="examples">Show and Hide Example</a>
     */
    public native void showSection(int sections, ShowSectionCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showSection", "int,ShowSectionCallback");
        }
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SectionStack sectionStackProperties) /*-{
        if (sectionStackProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SectionStack.@java.lang.Object::getClass()(), "setDefaultProperties", sectionStackProperties.@java.lang.Object::getClass()());
        }
        sectionStackProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = sectionStackProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.SectionStack.addProperties(properties);
    }-*/;

    // ***********************************************************



    public void setSectionHeaderClass(Class<? extends Canvas> sectionHeaderClass) throws IllegalStateException {
        setSectionHeaderClass(sectionHeaderClass.getName());
    }

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
     * @return the section indicated
     */
    public native SectionStackSection getSection(String sectionID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionConfig(sectionID);
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return the SectionStackSection for a section.
     *
     * @param index index of the section for which you want the header
     * @return the section header indicated
     */
    public native SectionStackSection getSection(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionConfig(index);
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return all the SectionStackSections in this SectionStack.
     *
     * @return an array of the section headers
     */
    public native SectionStackSection[] getSections() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.sections;
        if(ret == null) return null;
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
         self.setSectionProperties(section, $wnd.isc.addProperties({}, props));
     }-*/;
     
	/**
     * Reveals the child Canvas passed in by expanding the section containing that child if it is currently collapsed.  If no section
     * in this sectionStack contains the passed-in Canvas, this method has  no effect<p>
     * <b>NOTE: This is an override point.</b>
     * @param childID the global ID of the child Canvas to reveal
     */
     public native void revealChild(String childID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__revealChild(childID);
    }-*/;
    
	/**
     * Reveals the child Canvas passed in by expanding the section containing that child if it is currently collapsed.  If no section
     * in this sectionStack contains the passed-in Canvas, this method has  no effect<p>
     * <b>NOTE: This is an override point.</b>
     * @param child the child Canvas to reveal
     */
    public native void revealChild(Canvas child) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var childJS = child == null ? null : child.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        self.__revealChild(childJS);
    }-*/;

    // warn/throw exception through BaseWidget API for prohibited post-creation section setters
    void warnOfPostCreateModification(SectionStackSection section, String attribute) {
        error("Cannot change the " + attribute + " property for SectionStackSection " + 
              section.getName() + " now that it's been added to SectionStack " + getID() +
              " and its SectionHeader built");
    }


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
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
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionStack.editProxyConstructor:" + t.getMessage() + "\n";
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

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SectionStackLogicalStructure s = new SectionStackLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
