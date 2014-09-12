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
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.SectionHeader.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.SectionHeader.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * @param baseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "sectionHeader"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * CSS class for the section header.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @param clipTitle  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClipTitle(Boolean clipTitle)  throws IllegalStateException {
        setAttribute("clipTitle", clipTitle, false);
    }

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @return Boolean
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
     * @param controls  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_custom_controls" target="examples">Custom Controls Example</a>
     */
    public void setControls(Canvas... controls)  throws IllegalStateException {
        setAttribute("controls", controls, false);
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.layout.Layout} containing specified {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getControls controls} if any.  Sets {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembersMargin membersMargin}:5, {@link
     * com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign defaultLayoutAlign}:"center", and RTL-sensitive {@link
     * com.smartgwt.client.widgets.layout.Layout#getAlign align} (right by default).
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Layout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getControlsLayout() throws IllegalStateException {
        errorIfNotCreated("controlsLayout");
        return (Layout)Layout.getByJSObject(getAttributeAsJavaScriptObject("controlsLayout"));
    }
    

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param icon  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is "[SKIN]SectionHeader/opener.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIcon(String icon)  throws IllegalStateException {
        setAttribute("icon", icon, false);
    }

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * By default doubleClicks are disabled for SectionHeaders. All mouse click events will be handled as single clicks. Set
     * this property to <code>false</code> to enable standard double-click handling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param noDoubleClicks  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNoDoubleClicks(Boolean noDoubleClicks)  throws IllegalStateException {
        setAttribute("noDoubleClicks", noDoubleClicks, false);
    }

    /**
     * By default doubleClicks are disabled for SectionHeaders. All mouse click events will be handled as single clicks. Set
     * this property to <code>false</code> to enable standard double-click handling.
     *
     * @return Boolean
     */
    public Boolean getNoDoubleClicks()  {
        Boolean result = getAttributeAsBoolean("noDoubleClicks");
        return result == null ? true : result;
    }
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @param showClippedTitleOnHover  Default value is true
     */
    public void setShowClippedTitleOnHover(Boolean showClippedTitleOnHover) {
        setAttribute("showClippedTitleOnHover", showClippedTitleOnHover, true);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @return Boolean
     */
    public Boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * For a SectionHeader embedded in a SectionStack, this method will return  a pointer to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack} in which this section header is embedded.
     *
     * @return Section Stack containing this section header
     */
    public native SectionStack getSectionStack() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionStack();
        return @com.smartgwt.client.widgets.layout.SectionStack::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Is the title of this section header clipped by {@link com.smartgwt.client.widgets.layout.SectionHeader#getControls
     * section controls} or the edge of the header?
     *
     * @return whether the title is clipped.
     * @see com.smartgwt.client.widgets.layout.SectionHeader#getClipTitle
     */
    public native boolean titleClipped() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped();
        return ret;
    }-*/;

    /**
     * Add a sectionHeaderTitleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this section header and the title is clipped. If {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getShowClippedTitleOnHover showClippedTitleOnHover} is true, the
     * default behavior is to show a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#titleHoverHTML SectionHeader.titleHoverHTML}. Call {@link
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
        var obj = null;
        var selfJ = this;
        var titleHover = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({titleHover: 
                function () {
                    var param = {};
                    return titleHover(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.titleHover = 
                function () {
                    var param = {};
                    return titleHover(param) == true;
                }
            ;
        }
   }-*/;


	/**
     * Returns the HTML that is displayed by the default {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#addSectionHeaderTitleHoverHandler titleHover} handler. Return null or
     * an empty string to cancel the hover. <p>Use <code>setTitleHoverFormatter()</code> to provide a custom implementation.
     * @param defaultHTML the HTML that would have been displayed by default. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     *
     * @return HTML to be displayed in the hover. If an empty string, then the hover is canceled. If null, then the default HTML is
     * used.
     */
    public native String titleHoverHTML(String defaultHTML) /*-{
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
     */
    public static native void setDefaultProperties(SectionHeader sectionHeaderProperties) /*-{
    	var properties = $wnd.isc.addProperties({},sectionHeaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
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
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        SectionHeaderLogicalStructure s = new SectionHeaderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

