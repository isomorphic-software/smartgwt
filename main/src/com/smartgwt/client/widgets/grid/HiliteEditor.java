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
 
package com.smartgwt.client.widgets.grid;


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
 * A widget for defining and editing a set of {@link com.smartgwt.client.widgets.grid.HiliteRule hilite rules} for use by 
 * {@link com.smartgwt.client.widgets.DataBoundComponent dataBoundComponents}.  Presents a list of available fields  and
 * allows editing of simple hilites directly and more complex hilites via   {@link
 * com.smartgwt.client.widgets.grid.AdvancedHiliteEditor}s.  <P> <i><b>Important Note:</b> this class should not be used
 * directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("HiliteEditor")
public class HiliteEditor extends VLayout {

    public static HiliteEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new HiliteEditor(jsObj);
        } else {
            assert refInstance instanceof HiliteEditor;
            return (HiliteEditor)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HiliteEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.HiliteEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HiliteEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.HiliteEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public HiliteEditor(){
        scClassName = "HiliteEditor";
    }

    public HiliteEditor(JavaScriptObject jsObj){
        scClassName = "HiliteEditor";
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
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getAddAdvancedRuleButton add advanced rule}
     * button.
     *
     * @param addAdvancedRuleButtonTitle New addAdvancedRuleButtonTitle value. Default value is "Add Advanced Rule"
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public HiliteEditor setAddAdvancedRuleButtonTitle(String addAdvancedRuleButtonTitle)  throws IllegalStateException {
        return (HiliteEditor)setAttribute("addAdvancedRuleButtonTitle", addAdvancedRuleButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getAddAdvancedRuleButton add advanced rule}
     * button.
     *
     * @return Current addAdvancedRuleButtonTitle value. Default value is "Add Advanced Rule"
     */
    public String getAddAdvancedRuleButtonTitle()  {
        return getAttributeAsString("addAdvancedRuleButtonTitle");
    }
    

    /**
     * The title for the 'Available Fields' column in the  {@link com.smartgwt.client.widgets.grid.HiliteEditor#getFieldList
     * fieldList}.
     *
     * @param availableFieldsColumnTitle New availableFieldsColumnTitle value. Default value is "Available Fields"
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public HiliteEditor setAvailableFieldsColumnTitle(String availableFieldsColumnTitle)  throws IllegalStateException {
        return (HiliteEditor)setAttribute("availableFieldsColumnTitle", availableFieldsColumnTitle, false);
    }

    /**
     * The title for the 'Available Fields' column in the  {@link com.smartgwt.client.widgets.grid.HiliteEditor#getFieldList
     * fieldList}.
     *
     * @return Current availableFieldsColumnTitle value. Default value is "Available Fields"
     */
    public String getAvailableFieldsColumnTitle()  {
        return getAttributeAsString("availableFieldsColumnTitle");
    }
    

    /**
     * The callback to fire when {@link com.smartgwt.client.widgets.grid.HiliteEditor#saveHilites saveHilites()} is called.
     *
     * @param callback New callback value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Callback Callback 
     */
    public HiliteEditor setCallback(String callback)  throws IllegalStateException {
        return (HiliteEditor)setAttribute("callback", callback, false);
    }

    /**
     * The callback to fire when {@link com.smartgwt.client.widgets.grid.HiliteEditor#saveHilites saveHilites()} is called.
     *
     * @return Current callback value. Default value is null
     * @see com.smartgwt.client.docs.Callback Callback 
     */
    public String getCallback()  {
        return getAttributeAsString("callback");
    }
    
    

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCancelButton cancel button}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public HiliteEditor setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (HiliteEditor)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCancelButton cancel button}.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    
    

    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.data.Hilite hilites}. <P>
     * <code>hiliteIcons</code> should be specified as an Array of {@link com.smartgwt.client.docs.SCImgURL}. When present,
     * {@link com.smartgwt.client.widgets.grid.HiliteRule}s will offer the user a drop down for picking one of these icons. <P>
     * If the user picks an icon, the created hiliting rule will have {@link com.smartgwt.client.data.Hilite#getIcon
     * Hilite.icon} set to  the chosen icon.  {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition
     * ListGridField.hiliteIconPosition} controls where the icon will  appear for that field -- the default is that it appears
     * in front of the normal cell content.
     *
     * @param hiliteIcons New hiliteIcons value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public HiliteEditor setHiliteIcons(String... hiliteIcons) {
        return (HiliteEditor)setAttribute("hiliteIcons", hiliteIcons, true);
    }

    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.data.Hilite hilites}. <P>
     * <code>hiliteIcons</code> should be specified as an Array of {@link com.smartgwt.client.docs.SCImgURL}. When present,
     * {@link com.smartgwt.client.widgets.grid.HiliteRule}s will offer the user a drop down for picking one of these icons. <P>
     * If the user picks an icon, the created hiliting rule will have {@link com.smartgwt.client.data.Hilite#getIcon
     * Hilite.icon} set to  the chosen icon.  {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition
     * ListGridField.hiliteIconPosition} controls where the icon will  appear for that field -- the default is that it appears
     * in front of the normal cell content.
     *
     * @return Current hiliteIcons value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String[] getHiliteIcons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("hiliteIcons"));
    }
    
    
    

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getSaveButton saveButton}.
     *
     * @param saveButtonTitle New saveButtonTitle value. Default value is "Save"
     * @return {@link com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public HiliteEditor setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        return (HiliteEditor)setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getSaveButton saveButton}.
     *
     * @return Current saveButtonTitle value. Default value is "Save"
     */
    public String getSaveButtonTitle()  {
        return getAttributeAsString("saveButtonTitle");
    }
    

    // ********************* Methods ***********************
	/**
     * Clear all Hilites from the editor.
     */
    public native void clearHilites() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearHilites", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearHilites();
    }-*/;

	/**
     * Removes the passed {@link com.smartgwt.client.widgets.grid.HiliteRule HiliteRule} from this editor.
     * @param hiliteRule the hiliteRule to remove
     */
    public native void removeRule(HiliteRule hiliteRule) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeRule", "HiliteRule");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeRule(hiliteRule == null ? null : hiliteRule.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Save the set of Hilites and fire the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCallback callback}.
     * @param callback the function to call when saving is complete.
     * See {@link com.smartgwt.client.docs.Callback Callback}
     * @see com.smartgwt.client.docs.Callback Callback
     */
    public native void saveHilites(String callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveHilites", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveHilites(callback);
    }-*/;

	/**
     * Initialize this editor with a set of Hilites.
     * @param hilites the array of hilite objects to apply
     */
    public native void setHilites(Hilite... hilites) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setHilites", "Hilite...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHilites(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites));
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
     * @param hiliteEditorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(HiliteEditor hiliteEditorProperties) /*-{
        if (hiliteEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(HiliteEditor.@java.lang.Object::getClass()(), "setDefaultProperties", hiliteEditorProperties.@java.lang.Object::getClass()());
        }
        hiliteEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = hiliteEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.HiliteEditor.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(HiliteEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addAdvancedRuleButtonTitle = getAttributeAsString("addAdvancedRuleButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.addAdvancedRuleButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.availableFieldsColumnTitle = getAttributeAsString("availableFieldsColumnTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.availableFieldsColumnTitle:" + t.getMessage() + "\n";
        }
        try {
            s.callback = getAttributeAsString("callback");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.callback:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIcons = getAttributeAsStringArray("hiliteIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.hiliteIconsArray:" + t.getMessage() + "\n";
        }
        try {
            s.saveButtonTitle = getAttributeAsString("saveButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.saveButtonTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        HiliteEditorLogicalStructure s = new HiliteEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
