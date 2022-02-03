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
 
package com.smartgwt.client.tools;


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
 * A {@link com.smartgwt.client.widgets.layout.Layout}-based component for editing groups of  {@link
 * com.smartgwt.client.tools.StyleSetting styling settings}.  Changes are reflected in a preview canvas  and can be
 * retrieved as a block of  {@link com.smartgwt.client.tools.CSSEditor#getCSSProperties properties} or as a string of 
 * {@link com.smartgwt.client.tools.CSSEditor#getCSSText CSS text}. <p> <b>Note:</b> this feature requires <a
 * href='https://www.smartclient.com/product/' target='_blank'>Smart GWT Enterprise</a>.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("CSSEditor")
public class CSSEditor extends VLayout implements com.smartgwt.client.widgets.tools.events.HasEditCompleteHandlers, com.smartgwt.client.widgets.tools.events.HasValuesChangedHandlers {

    public static CSSEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new CSSEditor(jsObj);
        } else {
            assert refInstance instanceof CSSEditor;
            return (CSSEditor)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CSSEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.CSSEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CSSEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.CSSEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public CSSEditor(){
        scClassName = "CSSEditor";
    }

    public CSSEditor(JavaScriptObject jsObj){
        scClassName = "CSSEditor";
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
     * The set of {@link com.smartgwt.client.tools.StyleGroup}s to show for editing.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the list of {@link com.smartgwt.client.tools.StyleGroup style-groups} to display for editing.  The  parameter can be an array of valid StyleGroups (or objects with at least a "name"  property), or a list of the names of predefined groups.
     *
     * @param groups array of StyleGroup objects or names. Default value is null
     * @return {@link com.smartgwt.client.tools.CSSEditor CSSEditor} instance, for chaining setter calls
     */
    public CSSEditor setGroups(StyleGroup... groups) {
        return (CSSEditor)setAttribute("groups", groups, true);
    }

    /**
     * The set of {@link com.smartgwt.client.tools.StyleGroup}s to show for editing.
     *
     * @return Current groups value. Default value is null
     */
    public StyleGroup[] getGroups()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfStyleGroup(getAttributeAsJavaScriptObject("groups"));
    }
    

    /**
     * The set of values to apply to editors.
     *
     * @param values New values value. Default value is null
     * @return {@link com.smartgwt.client.tools.CSSEditor CSSEditor} instance, for chaining setter calls
     */
    public CSSEditor setValues(Map values) {
        return (CSSEditor)setAttribute("values", values, true);
    }

    /**
     * The set of values to apply to editors.
     *
     * @return Current values value. Default value is null
     */
    public Map getValues()  {
        return getAttributeAsMap("values");
    }
    

    // ********************* Methods ***********************
	/**
     * Clear the current {@link com.smartgwt.client.tools.StyleGroup style-groups} from the editor.
     */
    public native void clearGroups() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearGroups", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearGroups();
    }-*/;

	/**
     * Notification fired when the cancelButton is clicked.
     */
    public native void editCancelled() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editCancelled", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editCancelled();
    }-*/;

    /**
     * Add a editComplete handler.
     * <p>
     * Notification fired when the okButton is clicked.
     *
     * @param handler the editComplete handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditCompleteHandler(com.smartgwt.client.widgets.tools.events.EditCompleteHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tools.events.EditCompleteEvent.getType()) == 0) setupEditCompleteEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tools.events.EditCompleteEvent.getType());
    }

    private native void setupEditCompleteEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var editComplete = $entry(function(){
            var param = {"_this": this, "settings" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tools.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.tools.CSSEditor::handleTearDownEditCompleteEvent()();
            if (hasDefaultHandler) this.Super("editComplete", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("editComplete"));
            obj.addProperties({editComplete:  editComplete              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("editComplete"));
            obj.editComplete =  editComplete             ;
        }
    }-*/;

    private void handleTearDownEditCompleteEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tools.events.EditCompleteEvent.getType()) == 0) tearDownEditCompleteEvent();
    }

    private native void tearDownEditCompleteEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("editComplete")) delete obj.editComplete;
    }-*/;

	/**
     * Returns the values being edited as a block of CSS properties.
     *
     * @return an ordinary object representing the current values from the editor
     */
    public native Map getCSSProperties() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCSSProperties", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCSSProperties();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the values being edited as a single string of {@link com.smartgwt.client.docs.CSSText}.
     *
     * @return string of CSS.
     * See {@link com.smartgwt.client.docs.CSSText CSSText}
     */
    public native String getCSSText() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCSSText", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCSSText();
        return ret;
    }-*/;

    /**
     * Add a valuesChanged handler.
     * <p>
     * Notification fired when values in the editor are changed.  The latest values are passed in the <code>values</code>
     * parameter.  You can use  {@link com.smartgwt.client.tools.CSSEditor#getCSSText getCSSText()} to retrieve the values as a
     * single piece of {@link com.smartgwt.client.docs.CSSText CSS-text}.
     *
     * @param handler the valuesChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValuesChangedHandler(com.smartgwt.client.widgets.tools.events.ValuesChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tools.events.ValuesChangedEvent.getType()) == 0) setupValuesChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tools.events.ValuesChangedEvent.getType());
    }

    private native void setupValuesChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var valuesChanged = $entry(function(){
            var param = {"_this": this, "values" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tools.events.ValuesChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.tools.CSSEditor::handleTearDownValuesChangedEvent()();
            if (hasDefaultHandler) this.Super("valuesChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("valuesChanged"));
            obj.addProperties({valuesChanged:  valuesChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("valuesChanged"));
            obj.valuesChanged =  valuesChanged             ;
        }
    }-*/;

    private void handleTearDownValuesChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tools.events.ValuesChangedEvent.getType()) == 0) tearDownValuesChangedEvent();
    }

    private native void tearDownValuesChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("valuesChanged")) delete obj.valuesChanged;
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
     * @param cSSEditorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(CSSEditor cSSEditorProperties) /*-{
        if (cSSEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(CSSEditor.@java.lang.Object::getClass()(), "setDefaultProperties", cSSEditorProperties.@java.lang.Object::getClass()());
        }
        cSSEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = cSSEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.CSSEditor.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(CSSEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.groups = getGroups();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CSSEditor.groupsArray:" + t.getMessage() + "\n";
        }
        try {
            s.values = getAttributeAsString("values");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CSSEditor.values:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        CSSEditorLogicalStructure s = new CSSEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
