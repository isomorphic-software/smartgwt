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
 * Simple SectionHeader class based on a Label with an icon, skinnable via CSS.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SectionHeader")
public class SectionHeader extends Label implements com.smartgwt.client.widgets.layout.events.HasSectionHeaderTitleHoverHandlers {

    public static SectionHeader getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new SectionHeader(jsObj);
        } else {
            assert refInstance instanceof SectionHeader;
            return (SectionHeader)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SectionHeader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SectionHeader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SectionHeader.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SectionHeader.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public SectionHeader(){
        scClassName = "SectionHeader";
    }

    public SectionHeader(JavaScriptObject jsObj){
        scClassName = "SectionHeader";
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
     * CSS class for the section header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param baseStyle New baseStyle value. Default value is "sectionHeader"
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public SectionHeader setBaseStyle(String baseStyle)  throws IllegalStateException {
        return (SectionHeader)setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * CSS class for the section header.
     *
     * @return Current baseStyle value. Default value is "sectionHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @param clipTitle New clipTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionHeader setClipTitle(Boolean clipTitle)  throws IllegalStateException {
        return (SectionHeader)setAttribute("clipTitle", clipTitle, false);
    }

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @return Current clipTitle value. Default value is true
     */
    public Boolean getClipTitle()  {
        Boolean result = getAttributeAsBoolean("clipTitle");
        return result == null ? true : result;
    }
    

    /**
     * Custom controls to be shown on top of this section header. <P> These controls are shown in the {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getControlsLayout controlsLayout}. <P> Note that this is an init-time
     * property. If you need to dynamically change what  controls are displayed to the user, we would recommend embedding the
     * controls in a Layout or similar container.  This will allow you to show/hide or add/remove members at runtime by
     * manipulating the existing control(s) set up at init time.
     *
     * @param controls New controls value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_custom_controls" target="examples">Custom Controls Example</a>
     */
    public SectionHeader setControls(Canvas... controls)  throws IllegalStateException {
        return (SectionHeader)setAttribute("controls", controls, false);
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.layout.Layout} containing specified {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getControls controls} if any.  Sets {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembersMargin Layout.membersMargin}:5, {@link
     * com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign Layout.defaultLayoutAlign}:"center", and RTL-sensitive
     * {@link com.smartgwt.client.widgets.layout.Layout#getAlign Layout.align} (right by default).
     * <p>
     * This component is an AutoChild named "controlsLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current controlsLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getControlsLayout() throws IllegalStateException {
        errorIfNotCreated("controlsLayout");
        return (Layout)Layout.getByJSObject(getAttributeAsJavaScriptObject("controlsLayout"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "SectionStackSectionEditProxy"
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public SectionHeader setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (SectionHeader)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "SectionStackSectionEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse SectionStackSection.canCollapse} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param icon New icon value. Default value is "[SKIN]SectionHeader/opener.gif"
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public SectionHeader setIcon(String icon)  throws IllegalStateException {
        return (SectionHeader)setAttribute("icon", icon, false);
    }

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse SectionStackSection.canCollapse} is false.
     *
     * @return Current icon value. Default value is "[SKIN]SectionHeader/opener.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * By default doubleClicks are disabled for SectionHeaders. All mouse click events will be handled as single clicks. Set
     * this property to <code>false</code> to enable standard double-click handling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param noDoubleClicks New noDoubleClicks value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public SectionHeader setNoDoubleClicks(Boolean noDoubleClicks)  throws IllegalStateException {
        return (SectionHeader)setAttribute("noDoubleClicks", noDoubleClicks, false);
    }

    /**
     * By default doubleClicks are disabled for SectionHeaders. All mouse click events will be handled as single clicks. Set
     * this property to <code>false</code> to enable standard double-click handling.
     *
     * @return Current noDoubleClicks value. Default value is true
     */
    public Boolean getNoDoubleClicks()  {
        Boolean result = getAttributeAsBoolean("noDoubleClicks");
        return result == null ? true : result;
    }
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @param showClippedTitleOnHover New showClippedTitleOnHover value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionHeader SectionHeader} instance, for chaining setter calls
     */
    public SectionHeader setShowClippedTitleOnHover(Boolean showClippedTitleOnHover) {
        return (SectionHeader)setAttribute("showClippedTitleOnHover", showClippedTitleOnHover, true);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @return Current showClippedTitleOnHover value. Default value is true
     */
    public Boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover");
        return result == null ? true : result;
    }
    

    /**
     * Title to show for the section
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Title to show for the section
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
	/**
     * For a SectionHeader embedded in a SectionStack, this method will return  a pointer to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack} in which this section header is embedded.
     *
     * @return Section Stack containing this section header
     */
    public native SectionStack getSectionStack() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectionStack", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionStack();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Is the title of this section header clipped by {@link com.smartgwt.client.widgets.layout.SectionHeader#getControls
     * section controls} or the edge of the header?
     *
     * @return whether the title is clipped.
     * @see com.smartgwt.client.widgets.layout.SectionHeader#getClipTitle
     */
    public native boolean titleClipped() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "titleClipped", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped();
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a sectionHeaderTitleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this section header and the title is clipped. If {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getShowClippedTitleOnHover SectionHeader.showClippedTitleOnHover} is
     * true, the default behavior is to show a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#titleHoverHTML SectionHeader.titleHoverHTML()}. Call {@link
     * com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverHandler#onSectionHeaderTitleHover} to suppress this
     * default behavior.
     *
     * @param handler the sectionHeaderTitleHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSectionHeaderTitleHoverHandler(com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent.getType()) == 0) setupSectionHeaderTitleHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent.getType());
    }

    private native void setupSectionHeaderTitleHoverEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var titleHover = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SectionHeader::handleTearDownSectionHeaderTitleHoverEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("titleHover"));
            obj.addProperties({titleHover: 
                function () {
                    var param = {"_this": this};
                    var ret = titleHover(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleHover", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("titleHover"));
            obj.titleHover = 
                function () {
                    var param = {"_this": this};
                    var ret = titleHover(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleHover", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownSectionHeaderTitleHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent.getType()) == 0) tearDownSectionHeaderTitleHoverEvent();
    }

    private native void tearDownSectionHeaderTitleHoverEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("titleHover")) delete obj.titleHover;
    }-*/;

	/**
     * Returns the HTML that is displayed by the default {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#addSectionHeaderTitleHoverHandler titleHover} handler. Return null or
     * an empty string to cancel the hover. <p>Use <code>setTitleHoverFormatter()</code> to provide a custom implementation.
     * @param defaultHTML the HTML that would have been displayed by default.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     *
     * @return HTML to be displayed in the hover. If an empty string, then the hover is canceled. If null, then the default HTML is
     * used.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public native String titleHoverHTML(String defaultHTML) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "titleHoverHTML", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleHoverHTML(defaultHTML);
        return ret;
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
     * @param sectionHeaderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SectionHeader sectionHeaderProperties) /*-{
        if (sectionHeaderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SectionHeader.@java.lang.Object::getClass()(), "setDefaultProperties", sectionHeaderProperties.@java.lang.Object::getClass()());
        }
        sectionHeaderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = sectionHeaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.SectionHeader.addProperties(properties);
    }-*/;

    // ***********************************************************


    
    /**
     * 
     * Retrieve the SectionStackSection associated with this header
     * @return the SectionStackSection for the section header
     */
    public native SectionStackSection getSection () /*-{
    	var jsObj = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (jsObj == null) return null;
		var section = jsObj.getSectionConfig != null ? jsObj.getSectionConfig() : null;
	    if (section == null) return null;
        return @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(section);
    }-*/;

    /**
     * Provide a custom implementation of {@link #titleHoverHTML(java.lang.String)}.
     */
    public native void setTitleHoverFormatter(TitleHoverFormatter formatter) /*-{
        var self;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        var newTitleHoverHTMLFun;
        if (formatter == null) {
            newTitleHoverHTMLFun = $wnd.isc[this.@com.smartgwt.client.widgets.BaseWidget::scClassName].getInstanceProperty("titleHoverHTML");
        } else {
            newTitleHoverHTMLFun = $entry(function (defaultHTML) {
                return formatter.@com.smartgwt.client.widgets.TitleHoverFormatter::getHoverHTML(Ljava/lang/String;)(defaultHTML);
            });
        }
        self.titleHoverHTML = newTitleHoverHTMLFun;
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SectionHeaderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.clipTitle = getAttributeAsString("clipTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.clipTitle:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.icon:" + t.getMessage() + "\n";
        }
        try {
            s.noDoubleClicks = getAttributeAsString("noDoubleClicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.noDoubleClicks:" + t.getMessage() + "\n";
        }
        try {
            s.showClippedTitleOnHover = getAttributeAsString("showClippedTitleOnHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.showClippedTitleOnHover:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SectionHeader.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SectionHeaderLogicalStructure s = new SectionHeaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
