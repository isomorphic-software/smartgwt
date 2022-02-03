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
 
package com.smartgwt.client.widgets.toolbar;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * A widget that groups {@link com.smartgwt.client.widgets.RibbonButton RibbonButtons}s for use in  {@link
 * com.smartgwt.client.widgets.toolbar.RibbonBar RibbonBars}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RibbonGroup")
public class RibbonGroup extends ToolStripGroup {

    public static RibbonGroup getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new RibbonGroup(jsObj);
        } else {
            assert refInstance instanceof RibbonGroup;
            return (RibbonGroup)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RibbonGroup.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RibbonGroup.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RibbonGroup.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RibbonGroup.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public RibbonGroup(){
        scClassName = "RibbonGroup";
    }

    public RibbonGroup(JavaScriptObject jsObj){
        scClassName = "RibbonGroup";
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
     * By default, <code>RibbonGroups</code> are assigned a minimum width that allows the  entire title to be visible.  To
     * prevent this behavior and have group-titles cut off  when they're wider than the buttons they contain, set this
     * attribute to false
     *
     * @param autoSizeToTitle New autoSizeToTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RibbonGroup setAutoSizeToTitle(Boolean autoSizeToTitle)  throws IllegalStateException {
        return (RibbonGroup)setAttribute("autoSizeToTitle", autoSizeToTitle, false);
    }

    /**
     * By default, <code>RibbonGroups</code> are assigned a minimum width that allows the  entire title to be visible.  To
     * prevent this behavior and have group-titles cut off  when they're wider than the buttons they contain, set this
     * attribute to false
     *
     * @return Current autoSizeToTitle value. Default value is true
     */
    public Boolean getAutoSizeToTitle()  {
        Boolean result = getAttributeAsBoolean("autoSizeToTitle");
        return result == null ? true : result;
    }
    

    /**
     * HLayout autoChild that manages multiple {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout VLayouts}
     *  containing controls.
     * <p>
     * This component is an AutoChild named "body".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current body value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getBody() throws IllegalStateException {
        errorIfNotCreated("body");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("body"));
    }
    

    /**
     * Smart GWT class for the body.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyConstructor New bodyConstructor value. Default value is "HLayout"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RibbonGroup setBodyConstructor(String bodyConstructor)  throws IllegalStateException {
        return (RibbonGroup)setAttribute("bodyConstructor", bodyConstructor, false);
    }

    /**
     * Smart GWT class for the body.
     *
     * @return Current bodyConstructor value. Default value is "HLayout"
     */
    public String getBodyConstructor()  {
        return getAttributeAsString("bodyConstructor");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * AutoChild VLayouts created automatically by groups.  Each manages a single column of child controls in the group.  Child
     * controls that support <code>rowSpan</code> may  specify it in order to occupy more than one row in a single column.  See
     *  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows} for related information.
     *
     * @return null
     */
    public VLayout getColumnLayout()  {
        return null;
    }
    

    /**
     * The array of controls to show in this group.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Clears the array of controls and then adds the passed array to this group,  creating new {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout columns} as necessary, according to each control's <code>rowSpan</code> attribute and the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows} attribute.
     *
     * @param controls an array of widgets to add to this group. Default value is null
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setControls(Canvas... controls) {
        return (RibbonGroup)setAttribute("controls", controls, true);
    }

    /**
     * The array of controls to show in this group.
     *
     * @return Current controls value. Default value is null
     */
    public Canvas[] getControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("controls"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "RibbonGroupEditProxy"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public RibbonGroup setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (RibbonGroup)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "RibbonGroupEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * AutoChild {@link com.smartgwt.client.widgets.Label Label} used to display the  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle title text} for this group. <P> Can be customized via the
     * standard {@link com.smartgwt.client.types.AutoChild} pattern, and various  convenience APIs exist for configuring it
     * after initial draw: see  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#setShowTitle setShowTitle},  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#setTitle setTitle},  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#setTitleAlign setTitleAlign}, {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#setTitleHeight setTitleHeight}, {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#setTitleOrientation setTitleOrientation} and {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#setTitleStyle setTitleStyle}.
     * <p>
     * This component is an AutoChild named "label".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current label value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getLabel() throws IllegalStateException {
        errorIfNotCreated("label");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("label"));
    }
    

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} AutoChild.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param labelConstructor New labelConstructor value. Default value is "Label"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RibbonGroup setLabelConstructor(String labelConstructor)  throws IllegalStateException {
        return (RibbonGroup)setAttribute("labelConstructor", labelConstructor, false);
    }

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} AutoChild.
     *
     * @return Current labelConstructor value. Default value is "Label"
     */
    public String getLabelConstructor()  {
        return getAttributeAsString("labelConstructor");
    }
    

    /**
     * HLayout autoChild that houses the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel label}  in which the
     * {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle title text} is displayed. <P> This can be customized via
     * the standard {@link com.smartgwt.client.types.AutoChild} pattern.
     * <p>
     * This component is an AutoChild named "labelLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current labelLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getLabelLayout() throws IllegalStateException {
        errorIfNotCreated("labelLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("labelLayout"));
    }
    
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Properties used by {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#createControl createControl} when creating new
     * controls.
     *
     * @return null
     */
    public RibbonButton getNewControlDefaults()  {
        return null;
    }
    

    /**
     * The number of rows of controls to display in each column.  Each control will take one row in a {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout columnLayout} by default, but those that  support the
     * feature may specify <code>rowSpan</code> to override that. <P> Note that settings like this, which affect the group's
     * layout, are not applied directly if changed at runtime - a call to {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#reflowControls reflowControls}  will force the group to reflow.
     *
     * @param numRows New numRows value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setNumRows(int numRows) {
        return (RibbonGroup)setAttribute("numRows", numRows, true);
    }

    /**
     * The number of rows of controls to display in each column.  Each control will take one row in a {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout columnLayout} by default, but those that  support the
     * feature may specify <code>rowSpan</code> to override that. <P> Note that settings like this, which affect the group's
     * layout, are not applied directly if changed at runtime - a call to {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#reflowControls reflowControls}  will force the group to reflow.
     *
     * @return Current numRows value. Default value is 1
     */
    public int getNumRows()  {
        return getAttributeAsInt("numRows");
    }
    

    /**
     * The height of rows in each column.
     *
     * @param rowHeight New rowHeight value. Default value is 26
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setRowHeight(int rowHeight) {
        return (RibbonGroup)setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * The height of rows in each column.
     *
     * @return Current rowHeight value. Default value is 26
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }
    

    /**
     * CSS class applied to this RibbonGroup.
     *
     * @param styleName New styleName value. Default value is "ribbonGroup"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class applied to this RibbonGroup.
     *
     * @return Current styleName value. Default value is "ribbonGroup"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * The title text to display in this group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle text} to display in this group's {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} after initial draw.
     *
     * @param title The new title for this group. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The title text to display in this group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Controls the horizontal alignment of the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle
     * title-text}, within its  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel label}.  Setting this attribute
     * overrides the default specified by  {@link com.smartgwt.client.widgets.toolbar.RibbonBar#getGroupTitleAlign
     * groupTitleAlign} on the containing  {@link com.smartgwt.client.widgets.toolbar.RibbonBar RibbonBar}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the horizontal alignment of the  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle title-text}, within the  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}, after initial draw.
     *
     * @param titleAlign the new alignment for the text, left or right. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setTitleAlign(Alignment titleAlign) {
        return (RibbonGroup)setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue(), true);
    }

    /**
     * Controls the horizontal alignment of the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitle
     * title-text}, within its  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel label}.  Setting this attribute
     * overrides the default specified by  {@link com.smartgwt.client.widgets.toolbar.RibbonBar#getGroupTitleAlign
     * groupTitleAlign} on the containing  {@link com.smartgwt.client.widgets.toolbar.RibbonBar RibbonBar}.
     *
     * @return Current titleAlign value. Default value is "center"
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }
    

    /**
     * Controls the height of the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} in this group.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the height of this group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} after initial draw.
     *
     * @param titleHeight the new height for the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}. Default value is 18
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setTitleHeight(int titleHeight) {
        return (RibbonGroup)setAttribute("titleHeight", titleHeight, true);
    }

    /**
     * Controls the height of the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} in this group.
     *
     * @return Current titleHeight value. Default value is 18
     */
    public int getTitleHeight()  {
        return getAttributeAsInt("titleHeight");
    }
    

    /**
     * Controls the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitleOrientation vertical orientation} of  this
     * group's {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}.  Setting this attribute overrides
     * the default specified by  {@link com.smartgwt.client.widgets.toolbar.RibbonBar#getGroupTitleOrientation
     * groupTitleOrientation} on the containing  {@link com.smartgwt.client.widgets.toolbar.RibbonBar RibbonBar}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitleOrientation vertical orientation} of this group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} after initial draw.
     *
     * @param titleOrientation the new orientation for the title, either bottom or top. Default value is "top"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     */
    public RibbonGroup setTitleOrientation(VerticalAlignment titleOrientation) {
        return (RibbonGroup)setAttribute("titleOrientation", titleOrientation == null ? null : titleOrientation.getValue(), true);
    }

    /**
     * Controls the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitleOrientation vertical orientation} of  this
     * group's {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}.  Setting this attribute overrides
     * the default specified by  {@link com.smartgwt.client.widgets.toolbar.RibbonBar#getGroupTitleOrientation
     * groupTitleOrientation} on the containing  {@link com.smartgwt.client.widgets.toolbar.RibbonBar RibbonBar}.
     *
     * @return Current titleOrientation value. Default value is "top"
     */
    public VerticalAlignment getTitleOrientation()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("titleOrientation"));
    }
    

    /**
     * AutoChild properties for fine customization of the  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel
     * title label}.
     * <p>
     * This component is an AutoChild named "titleProperties".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current titleProperties value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @deprecated set these properties directly via the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel label autoChild}
     */
    public Label getTitleProperties() throws IllegalStateException {
        errorIfNotCreated("titleProperties");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("titleProperties"));
    }
    

    /**
     * CSS class applied to the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} in this group.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * This method forcibly sets the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getTitleStyle CSS class name}   for this group's {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} after initial draw.
     *
     * @param titleStyle the CSS class to apply to the                                  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label}. Default value is "ribbonGroupTitle"
     * @return {@link com.smartgwt.client.widgets.toolbar.RibbonGroup RibbonGroup} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public RibbonGroup setTitleStyle(String titleStyle) {
        return (RibbonGroup)setAttribute("titleStyle", titleStyle, true);
    }

    /**
     * CSS class applied to the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title label} in this group.
     *
     * @return Current titleStyle value. Default value is "ribbonGroupTitle"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }
    

    // ********************* Methods ***********************
	/**
     * Adds a control to this <code>RibbonGroup</code>, creating a new  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column} as necessary, according to the control's 
     * <code>rowSpan</code> value and the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows}
     * value.
     * @param control a widget to add to this group
     */
    public native void addControl(Canvas control) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addControl", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControl(control == null ? null : control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Adds a control to this <code>RibbonGroup</code>, creating a new  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column} as necessary, according to the control's 
     * <code>rowSpan</code> value and the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows}
     * value.
     * @param control a widget to add to this group
     * @param index optional insertion index for this control
     */
    public native void addControl(Canvas control, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addControl", "Canvas,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControl(control == null ? null : control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Adds an array of controls to this group, creating new  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout columns} as necessary, according to each control's 
     * <code>rowSpan</code> value and the group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows}
     * value.
     * @param controls an array of widgets to add to this group
     */
    public native void addControls(Canvas... controls) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addControls", "Canvas...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addControls(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(controls));
    }-*/;

	/**
     * Creates a new control and adds it to this RibbonGroup.  The control is created using the  autoChild system, according to
     * the specified {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNewControlConstructor constructor} and the
     * passed properties are applied to it.
     * @param properties properties to apply to the new control
     */
    public native void createControl(Canvas properties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createControl", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.createControl(properties == null ? null : properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;

	/**
     * Creates a new control and adds it to this RibbonGroup.  The control is created using the  autoChild system, according to
     * the specified {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getNewControlConstructor constructor} and the
     * passed properties are applied to it.
     * @param properties properties to apply to the new control
     * @param position the index at which to insert the new control
     */
    public native void createControl(Canvas properties, Integer position) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createControl", "Canvas,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.createControl(properties == null ? null : properties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), position == null ? null : position.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Return the {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column widget} that contains the
     * passed  control.
     * @param control the control to find in this group
     *
     * @return the column widget containing the passed control
     */
    public native Layout getControlColumn(Canvas control) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getControlColumn", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getControlColumn(control == null ? null : control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Forces this group to reflow following changes to attributes that affect layout, like  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getNumRows numRows}.
     */
    public native void reflowControls() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reflowControls", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflowControls();
    }-*/;

	/**
     * Removes a control from this <code>RibbonGroup</code>, destroying an existing  {@link
     * com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column} if this is the last widget in that column.
     * @param control a widget to remove from this group
     */
    public native void removeControl(Canvas control) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeControl", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeControl(control == null ? null : control.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * This method forcibly shows or hides this group's  {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getLabel title
     * label} after initial draw.
     * @param showTitle should the title be shown or hidden?
     */
    public native void setShowTitle(boolean showTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setShowTitle", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowTitle(showTitle);
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
     * @param ribbonGroupProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RibbonGroup ribbonGroupProperties) /*-{
        if (ribbonGroupProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RibbonGroup.@java.lang.Object::getClass()(), "setDefaultProperties", ribbonGroupProperties.@java.lang.Object::getClass()());
        }
        ribbonGroupProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = ribbonGroupProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RibbonGroup.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(RibbonGroupLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoSizeToTitle = getAttributeAsString("autoSizeToTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.autoSizeToTitle:" + t.getMessage() + "\n";
        }
        try {
            s.bodyConstructor = getAttributeAsString("bodyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.bodyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.controls = getControls();
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.controlsArray:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.labelConstructor = getAttributeAsString("labelConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.labelConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.newControlConstructor = getAttributeAsString("newControlConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.newControlConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.numRows = getAttributeAsString("numRows");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.numRows:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeight = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.rowHeight:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.title:" + t.getMessage() + "\n";
        }
        try {
            s.titleAlign = getAttributeAsString("titleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.titleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.titleHeight = getAttributeAsString("titleHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.titleHeight:" + t.getMessage() + "\n";
        }
        try {
            s.titleOrientation = getAttributeAsString("titleOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.titleOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.titleStyle = getAttributeAsString("titleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonGroup.titleStyle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        RibbonGroupLogicalStructure s = new RibbonGroupLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
