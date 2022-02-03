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
 
package com.smartgwt.client.widgets;


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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
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
 * Compact control for up/down navigation that roughly looks like an up arrowhead next to a down arrowhead.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MiniNavControl")
public class MiniNavControl extends StretchImgButton implements com.smartgwt.client.widgets.layout.events.HasDownClickHandlers, com.smartgwt.client.widgets.layout.events.HasUpClickHandlers {

    public static MiniNavControl getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MiniNavControl(jsObj);
        } else {
            assert refInstance instanceof MiniNavControl;
            return (MiniNavControl)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MiniNavControl.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MiniNavControl.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MiniNavControl.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MiniNavControl.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public MiniNavControl(){
        scClassName = "MiniNavControl";
    }

    public MiniNavControl(JavaScriptObject jsObj){
        scClassName = "MiniNavControl";
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
     * Image used for the down arrowhead.
     *
     * @param downButtonSrc New downButtonSrc value. Default value is "[SKIN]/down.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setDownButtonSrc(String downButtonSrc)  throws IllegalStateException {
        setAttribute("downButtonSrc", downButtonSrc, false);
    }

    /**
     * Image used for the down arrowhead.
     *
     * @return Current downButtonSrc value. Default value is "[SKIN]/down.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getDownButtonSrc()  {
        return getAttributeAsString("downButtonSrc");
    }
    

    /**
     * 
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/NavigationBar"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * 
     *
     * @return Current skinImgDir value. Default value is "images/NavigationBar"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * Image used for the up arrowhead.
     *
     * @param upButtonSrc New upButtonSrc value. Default value is "[SKIN]/up.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setUpButtonSrc(String upButtonSrc)  throws IllegalStateException {
        setAttribute("upButtonSrc", upButtonSrc, false);
    }

    /**
     * Image used for the up arrowhead.
     *
     * @return Current upButtonSrc value. Default value is "[SKIN]/up.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getUpButtonSrc()  {
        return getAttributeAsString("upButtonSrc");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a downClick handler.
     * <p>
     * Notification method fired when the down button is clicked.
     *
     * @param handler the downClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDownClickHandler(com.smartgwt.client.widgets.layout.events.DownClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) setupDownClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.DownClickEvent.getType());
    }

    private native void setupDownClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var downClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.DownClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.MiniNavControl::handleTearDownDownClickEvent()();
            if (hasDefaultHandler) this.Super("downClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("downClick"));
            obj.addProperties({downClick:  downClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("downClick"));
            obj.downClick =  downClick             ;
        }
    }-*/;

    private void handleTearDownDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) tearDownDownClickEvent();
    }

    private native void tearDownDownClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("downClick")) delete obj.downClick;
    }-*/;

    /**
     * Add a upClick handler.
     * <p>
     * Notification method fired when the up button is clicked.
     *
     * @param handler the upClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addUpClickHandler(com.smartgwt.client.widgets.layout.events.UpClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) setupUpClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.UpClickEvent.getType());
    }

    private native void setupUpClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var upClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.UpClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.MiniNavControl::handleTearDownUpClickEvent()();
            if (hasDefaultHandler) this.Super("upClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("upClick"));
            obj.addProperties({upClick:  upClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("upClick"));
            obj.upClick =  upClick             ;
        }
    }-*/;

    private void handleTearDownUpClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) tearDownUpClickEvent();
    }

    private native void tearDownUpClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("upClick")) delete obj.upClick;
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
     * @param miniNavControlProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MiniNavControl miniNavControlProperties) /*-{
        if (miniNavControlProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MiniNavControl.@java.lang.Object::getClass()(), "setDefaultProperties", miniNavControlProperties.@java.lang.Object::getClass()());
        }
        miniNavControlProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = miniNavControlProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MiniNavControl.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(MiniNavControlLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.downButtonSrc = getAttributeAsString("downButtonSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MiniNavControl.downButtonSrc:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MiniNavControl.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.upButtonSrc = getAttributeAsString("upButtonSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MiniNavControl.upButtonSrc:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MiniNavControlLogicalStructure s = new MiniNavControlLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
