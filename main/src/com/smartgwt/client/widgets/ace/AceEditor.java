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
 
package com.smartgwt.client.widgets.ace;


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
 * Internal use only.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("AceEditor")
public class AceEditor extends Canvas implements com.smartgwt.client.widgets.ace.events.HasAceEditorChangedHandlers {

    public static AceEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new AceEditor(jsObj);
        } else {
            assert refInstance instanceof AceEditor;
            return (AceEditor)refInstance;
        }
    }
        


    /**
     * Internal use only.
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(AceEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.AceEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Internal use only.
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(AceEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.AceEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public AceEditor(){
        scClassName = "AceEditor";
    }

    public AceEditor(JavaScriptObject jsObj){
        scClassName = "AceEditor";
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
     * Internal use only.
     */
    public AceEditor setAutoComplete(Boolean autoComplete) {
        return (AceEditor)setAttribute("autoComplete", autoComplete, true);
    }

    /**
     * Internal use only.
     */
    public Boolean getAutoComplete()  {
        return getAttributeAsBoolean("autoComplete");
    }
    

    /**
     * Internal use only.
     */
    public AceEditor setLiveAutoComplete(Boolean liveAutoComplete) {
        return (AceEditor)setAttribute("liveAutoComplete", liveAutoComplete, true);
    }

    /**
     * Internal use only.
     */
    public Boolean getLiveAutoComplete()  {
        return getAttributeAsBoolean("liveAutoComplete");
    }
    

    /**
     * Internal use only.
     */
    public AceEditor setMode(String mode) {
        return (AceEditor)setAttribute("mode", mode, true);
    }

    /**
     * Internal use only.
     */
    public String getMode()  {
        return getAttributeAsString("mode");
    }
    

    /**
     * Internal use only.
     */
    public AceEditor setReadOnly(Boolean readOnly) {
        return (AceEditor)setAttribute("readOnly", readOnly, true);
    }

    /**
     * Internal use only.
     */
    public Boolean getReadOnly()  {
        return getAttributeAsBoolean("readOnly");
    }
    

    /**
     * Internal use only.
     */
    public AceEditor setValue(String value) {
        return (AceEditor)setAttribute("value", value, true);
    }

    /**
     * Internal use only.
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }
    

    // ********************* Methods ***********************
	/**
     * Internal use only.
     */
    public native void addCompleter(AceCompleter completer) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addCompleter", "AceCompleter");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCompleter(completer == null ? null : completer.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Internal use only.
     */
    public native AcePosition addSelectionMarker(AceRange orientedRange) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addSelectionMarker", "AceRange");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addSelectionMarker(orientedRange == null ? null : orientedRange.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AcePosition::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Internal use only.
     */
    public HandlerRegistration addAceEditorChangedHandler(com.smartgwt.client.widgets.ace.events.AceEditorChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.ace.events.AceEditorChangedEvent.getType()) == 0) setupAceEditorChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.ace.events.AceEditorChangedEvent.getType());
    }

    private native void setupAceEditorChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var changed = $entry(function(){
            var param = {"_this": this, "start" : arguments[0], "end" : arguments[1], "action" : arguments[2], "lines" : arguments[3]};
            var event = @com.smartgwt.client.widgets.ace.events.AceEditorChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.ace.AceEditor::handleTearDownAceEditorChangedEvent()();
            if (hasDefaultHandler) this.Super("changed", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("changed"));
            obj.addProperties({changed:  changed              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("changed"));
            obj.changed =  changed             ;
        }
    }-*/;

    private void handleTearDownAceEditorChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.ace.events.AceEditorChangedEvent.getType()) == 0) tearDownAceEditorChangedEvent();
    }

    private native void tearDownAceEditorChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("changed")) delete obj.changed;
    }-*/;

	/**
     * Internal use only.
     */
    public native void clearSelection() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearSelection", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearSelection();
    }-*/;

	/**
     * Internal use only.
     */
    public native AcePosition getCursorPosition() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCursorPosition", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCursorPosition();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AcePosition::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native AcePosition getCursorPositionScreen() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCursorPositionScreen", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCursorPositionScreen();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AcePosition::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native Integer getFirstVisibleRow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFirstVisibleRow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFirstVisibleRow();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native Integer getLastVisibleRow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLastVisibleRow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLastVisibleRow();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native AceRenderer getRenderer() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRenderer", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRenderer();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AceRenderer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native AceRange getSelectionRange() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectionRange", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectionRange();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AceRange::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native AceEditSession getSession() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSession", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSession();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.ace.AceEditSession::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native void insert(String text) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "insert", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.insert(text);
    }-*/;

	/**
     * Internal use only.
     */
    public native Boolean isRowVisible(Integer row) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isRowVisible", "Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isRowVisible(row == null ? null : row.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Internal use only.
     */
    public native void redo() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "redo", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.redo();
    }-*/;

	/**
     * Internal use only.
     */
    public native void removeSelectionMarker(AceRange selectionRange) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeSelectionMarker", "AceRange");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSelectionMarker(selectionRange == null ? null : selectionRange.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Internal use only.
     */
    public native void setCompleters(AceCompleter... completers) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCompleters", "AceCompleter...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCompleters(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(completers));
    }-*/;

	/**
     * Internal use only.
     */
    public native void setSession(AceEditSession session) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSession", "AceEditSession");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSession(session == null ? null : session.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Internal use only.
     */
    public native void undo() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "undo", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.undo();
    }-*/;

	/**
     * Internal use only.
     */
    public native void updateSelectionMarkers() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateSelectionMarkers", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateSelectionMarkers();
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Internal use only.
     */
    public static native void setDefaultProperties(AceEditor aceEditorProperties) /*-{
        if (aceEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(AceEditor.@java.lang.Object::getClass()(), "setDefaultProperties", aceEditorProperties.@java.lang.Object::getClass()());
        }
        aceEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = aceEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.AceEditor.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Internal use only.
     */
    public void setAutoChildProperties(String autoChildName, BaseClass properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties", 
                               JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Internal use only.
     */
    public native JavaScriptObject getAceObj() /*-{
	    if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
	        @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getAceObj", "");
	    }
	    var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    var ret = self.getAceObj();
	    return ret;
	}-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(AceEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoComplete = getAttributeAsString("autoComplete");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AceEditor.autoComplete:" + t.getMessage() + "\n";
        }
        try {
            s.liveAutoComplete = getAttributeAsString("liveAutoComplete");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AceEditor.liveAutoComplete:" + t.getMessage() + "\n";
        }
        try {
            s.mode = getAttributeAsString("mode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AceEditor.mode:" + t.getMessage() + "\n";
        }
        try {
            s.readOnly = getAttributeAsString("readOnly");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AceEditor.readOnly:" + t.getMessage() + "\n";
        }
        try {
            s.value = getAttributeAsString("value");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AceEditor.value:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        AceEditorLogicalStructure s = new AceEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
