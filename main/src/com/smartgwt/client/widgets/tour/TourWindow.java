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
 
package com.smartgwt.client.widgets.tour;


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
 * A specific purpose Window class for showing individual steps in a tour.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TourWindow")
public class TourWindow extends Window {

    public static TourWindow getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TourWindow(jsObj);
        } else {
            assert refInstance instanceof TourWindow;
            return (TourWindow)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TourWindow.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TourWindow.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TourWindow.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TourWindow.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TourWindow(){
        scClassName = "TourWindow";
    }

    public TourWindow(JavaScriptObject jsObj){
        scClassName = "TourWindow";
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
     * Button show below contents that will call {@link com.smartgwt.client.widgets.tour.TourWindow#actionClick actionClick()}
     * when clicked.
     * <p>
     * This component is an AutoChild named "actionButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current actionButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getActionButton() throws IllegalStateException {
        errorIfNotCreated("actionButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("actionButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.tour.TourWindow#getActionButton actionButton}, shown if {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton showActionButton} is true.
     *
     * @param actionButtonTitle New actionButtonTitle value. Default value is "Next"
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourWindow setActionButtonTitle(String actionButtonTitle)  throws IllegalStateException {
        return (TourWindow)setAttribute("actionButtonTitle", actionButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.tour.TourWindow#getActionButton actionButton}, shown if {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton showActionButton} is true.
     *
     * @return Current actionButtonTitle value. Default value is "Next"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getActionButtonTitle()  {
        return getAttributeAsString("actionButtonTitle");
    }
    

    /**
     * URL to open in another tab or window when the the {@link com.smartgwt.client.widgets.tour.TourWindow#getActionButton
     * actionButton} is clicked. The normal {@link com.smartgwt.client.widgets.tour.TourWindow#actionClick actionClick()} event
     * is still called.
     *
     * @param actionButtonURL New actionButtonURL value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public TourWindow setActionButtonURL(String actionButtonURL)  throws IllegalStateException {
        return (TourWindow)setAttribute("actionButtonURL", actionButtonURL, false);
    }

    /**
     * URL to open in another tab or window when the the {@link com.smartgwt.client.widgets.tour.TourWindow#getActionButton
     * actionButton} is clicked. The normal {@link com.smartgwt.client.widgets.tour.TourWindow#actionClick actionClick()} event
     * is still called.
     *
     * @return Current actionButtonURL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getActionButtonURL()  {
        return getAttributeAsString("actionButtonURL");
    }
    

    /**
     * Button show below contents that will call {@link com.smartgwt.client.widgets.tour.TourWindow#cancelClick cancelClick()}
     * when clicked.
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.tour.TourWindow#getCancelButton cancelButton}, shown if {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton showCancelButton} is true.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Skip this tour"
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourWindow setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (TourWindow)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.tour.TourWindow#getCancelButton cancelButton}, shown if {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton showCancelButton} is true.
     *
     * @return Current cancelButtonTitle value. Default value is "Skip this tour"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Additional content components to show below {@link com.smartgwt.client.widgets.tour.TourWindow#getContents contents} or
     * {@link com.smartgwt.client.widgets.tour.TourWindow#getTitle title} if there are no other content.
     *
     * @param contentComponents New contentComponents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TourWindow setContentComponents(Canvas... contentComponents)  throws IllegalStateException {
        return (TourWindow)setAttribute("contentComponents", contentComponents, false);
    }

    /**
     * Additional content components to show below {@link com.smartgwt.client.widgets.tour.TourWindow#getContents contents} or
     * {@link com.smartgwt.client.widgets.tour.TourWindow#getTitle title} if there are no other content.
     *
     * @return Current contentComponents value. Default value is null
     */
    public Canvas[] getContentComponents()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("contentComponents"));
    }
    

    /**
     * Text to show in body of window.
     *
     * @param contents New contents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourWindow setContents(String contents)  throws IllegalStateException {
        return (TourWindow)setAttribute("contents", contents, false);
    }

    /**
     * Text to show in body of window.
     *
     * @return Current contents value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }
    

    /**
     * If true, show an action button below the contents which calls  {@link
     * com.smartgwt.client.widgets.tour.TourWindow#actionClick actionClick()} when clicked.
     *
     * @param showActionButton New showActionButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourWindow setShowActionButton(Boolean showActionButton)  throws IllegalStateException {
        return (TourWindow)setAttribute("showActionButton", showActionButton, false);
    }

    /**
     * If true, show an action button below the contents which calls  {@link
     * com.smartgwt.client.widgets.tour.TourWindow#actionClick actionClick()} when clicked.
     *
     * @return Current showActionButton value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowActionButton()  {
        Boolean result = getAttributeAsBoolean("showActionButton");
        return result == null ? true : result;
    }
    

    /**
     * If true, show a cancel button below the contents which calls {@link
     * com.smartgwt.client.widgets.tour.TourWindow#cancelClick cancelClick()} when clicked.
     *
     * @param showCancelButton New showCancelButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourWindow setShowCancelButton(Boolean showCancelButton)  throws IllegalStateException {
        return (TourWindow)setAttribute("showCancelButton", showCancelButton, false);
    }

    /**
     * If true, show a cancel button below the contents which calls {@link
     * com.smartgwt.client.widgets.tour.TourWindow#cancelClick cancelClick()} when clicked.
     *
     * @return Current showCancelButton value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowCancelButton()  {
        return getAttributeAsBoolean("showCancelButton");
    }
    

    /**
     * Should a progress bar be shown to indicate progress through the tour?
     *
     * @param showProgress New showProgress value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TourWindow setShowProgress(Boolean showProgress)  throws IllegalStateException {
        return (TourWindow)setAttribute("showProgress", showProgress, false);
    }

    /**
     * Should a progress bar be shown to indicate progress through the tour?
     *
     * @return Current showProgress value. Default value is null
     */
    public Boolean getShowProgress()  {
        return getAttributeAsBoolean("showProgress");
    }
    

    /**
     * Show progress percent next to progress bar when {@link com.smartgwt.client.widgets.tour.TourWindow#getShowProgress
     * showProgress} is enabled? The percent can also be shown over the progress bar by setting {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowProgressPercentInline showProgressPercentInline}.
     *
     * @param showProgressPercent New showProgressPercent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tour.TourWindow#setShowProgressPercentInline
     */
    public TourWindow setShowProgressPercent(Boolean showProgressPercent)  throws IllegalStateException {
        return (TourWindow)setAttribute("showProgressPercent", showProgressPercent, false);
    }

    /**
     * Show progress percent next to progress bar when {@link com.smartgwt.client.widgets.tour.TourWindow#getShowProgress
     * showProgress} is enabled? The percent can also be shown over the progress bar by setting {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowProgressPercentInline showProgressPercentInline}.
     *
     * @return Current showProgressPercent value. Default value is null
     * @see com.smartgwt.client.widgets.tour.TourWindow#getShowProgressPercentInline
     */
    public Boolean getShowProgressPercent()  {
        return getAttributeAsBoolean("showProgressPercent");
    }
    

    /**
     * Show progress percent over the progress bar instead of next to it when {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowProgress showProgress} is enabled?
     *
     * @param showProgressPercentInline New showProgressPercentInline value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tour.TourWindow TourWindow} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TourWindow setShowProgressPercentInline(Boolean showProgressPercentInline)  throws IllegalStateException {
        return (TourWindow)setAttribute("showProgressPercentInline", showProgressPercentInline, false);
    }

    /**
     * Show progress percent over the progress bar instead of next to it when {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowProgress showProgress} is enabled?
     *
     * @return Current showProgressPercentInline value. Default value is null
     */
    public Boolean getShowProgressPercentInline()  {
        return getAttributeAsBoolean("showProgressPercentInline");
    }
    

    /**
     * Title for this Window, shown if {@link com.smartgwt.client.widgets.Window#getShowTitle showTitle} is true.
     *
     * @param title New title value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * Title for this Window, shown if {@link com.smartgwt.client.widgets.Window#getShowTitle showTitle} is true.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
	/**
     * Handles a click on the action button of this window. No default implementation. <P>  Developers may use
     * <code>addActionClickHandler()</code> to provide custom handling when the user clicks this button.
     *
     * @return Return false to cancel bubbling the click event
     */
    public native Boolean actionClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "actionClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.actionClick();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Handles a click on the cancel button of this window. The default implementation calls {@link
     * com.smartgwt.client.widgets.Window#close close()} and returns false to prevent bubbling of the click event. <P> 
     * Developers may use <code>addCancelClickHandler()</code> to provide custom handling when the user clicks this button.
     * Custom implementations may call <code>close()</code> to trigger the default behavior.
     *
     * @return Return false to cancel bubbling the click event
     */
    public native Boolean cancelClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.cancelClick();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param tourWindowProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TourWindow tourWindowProperties) /*-{
        if (tourWindowProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TourWindow.@java.lang.Object::getClass()(), "setDefaultProperties", tourWindowProperties.@java.lang.Object::getClass()());
        }
        tourWindowProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tourWindowProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TourWindow.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TourWindowLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.actionButtonTitle = getAttributeAsString("actionButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.actionButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.actionButtonURL = getAttributeAsString("actionButtonURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.actionButtonURL:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.contentComponents = getContentComponents();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.contentComponentsArray:" + t.getMessage() + "\n";
        }
        try {
            s.contents = getAttributeAsString("contents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.contents:" + t.getMessage() + "\n";
        }
        try {
            s.showActionButton = getAttributeAsString("showActionButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.showActionButton:" + t.getMessage() + "\n";
        }
        try {
            s.showCancelButton = getAttributeAsString("showCancelButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.showCancelButton:" + t.getMessage() + "\n";
        }
        try {
            s.showProgress = getAttributeAsString("showProgress");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.showProgress:" + t.getMessage() + "\n";
        }
        try {
            s.showProgressPercent = getAttributeAsString("showProgressPercent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.showProgressPercent:" + t.getMessage() + "\n";
        }
        try {
            s.showProgressPercentInline = getAttributeAsString("showProgressPercentInline");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.showProgressPercentInline:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TourWindow.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TourWindowLogicalStructure s = new TourWindowLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
