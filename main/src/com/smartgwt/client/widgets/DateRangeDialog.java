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
 * Simple modal dialog for collecting a date range from the end user.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DateRangeDialog")
public class DateRangeDialog extends Window {

    public static DateRangeDialog getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DateRangeDialog(jsObj);
        } else {
            assert refInstance instanceof DateRangeDialog;
            return (DateRangeDialog)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateRangeDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DateRangeDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateRangeDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DateRangeDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DateRangeDialog(){
        scClassName = "DateRangeDialog";
    }

    public DateRangeDialog(JavaScriptObject jsObj){
        scClassName = "DateRangeDialog";
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
     * Button used for cancelling the dialog.  Note that, since this is an {@link com.smartgwt.client.types.AutoChild}, it can
     * be configured using cancelButtonDefaults and cancelButtonProperties.
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
     * The title for the "Cancel" button on this dialog.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title for the "Cancel" button on this dialog.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Button used for clearing the dialog's values.  Note that, since this is an {@link com.smartgwt.client.types.AutoChild},
     * it can be configured using clearButtonDefaults and clearButtonProperties.
     * <p>
     * This component is an AutoChild named "clearButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current clearButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getClearButton() throws IllegalStateException {
        errorIfNotCreated("clearButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("clearButton"));
    }
    

    /**
     * The title for the "Clear" button on this dialog.
     *
     * @param clearButtonTitle New clearButtonTitle value. Default value is "Clear"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClearButtonTitle(String clearButtonTitle)  throws IllegalStateException {
        setAttribute("clearButtonTitle", clearButtonTitle, false);
    }

    /**
     * The title for the "Clear" button on this dialog.
     *
     * @return Current clearButtonTitle value. Default value is "Clear"
     */
    public String getClearButtonTitle()  {
        return getAttributeAsString("clearButtonTitle");
    }
    

    /**
     * The title to display in the header-bar of this Dialog.
     *
     * @param headerTitle New headerTitle value. Default value is "Select Date Range"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderTitle(String headerTitle)  throws IllegalStateException {
        setAttribute("headerTitle", headerTitle, false);
    }

    /**
     * The title to display in the header-bar of this Dialog.
     *
     * @return Current headerTitle value. Default value is "Select Date Range"
     */
    public String getHeaderTitle()  {
        return getAttributeAsString("headerTitle");
    }
    

    /**
     * Button used for accepting the values entered into the dialog.  Note that, since this is an  {@link
     * com.smartgwt.client.types.AutoChild}, it can be configured using okButtonDefaults and okButtonProperties.
     * <p>
     * This component is an AutoChild named "okButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current okButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getOkButton() throws IllegalStateException {
        errorIfNotCreated("okButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("okButton"));
    }
    

    /**
     * The title for the "OK" button on this dialog.
     *
     * @param okButtonTitle New okButtonTitle value. Default value is "OK"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOkButtonTitle(String okButtonTitle)  throws IllegalStateException {
        setAttribute("okButtonTitle", okButtonTitle, false);
    }

    /**
     * The title for the "OK" button on this dialog.
     *
     * @return Current okButtonTitle value. Default value is "OK"
     */
    public String getOkButtonTitle()  {
        return getAttributeAsString("okButtonTitle");
    }
    

    /**
     * 
     * <p>
     * This component is an AutoChild named "rangeItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current rangeItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DateRangeItem getRangeItem() throws IllegalStateException {
        errorIfNotCreated("rangeItem");
        return DateRangeItem.getOrCreateRef(getAttributeAsJavaScriptObject("rangeItem"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Helper method to launch a DateRangeDialog to have a date range input by the user.
     * @param allowRelativeDates whether to allow relative date entry via                                    {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s, default true
     * @param rangeItemProperties properties for the DateRangeItem
     * @param windowProperties properties for the Window
     * @param callback method to fire once user has input values, with a single                                     parameter "criterion" of
     * type {@link com.smartgwt.client.data.Criterion}
     */
    public static native void askForRange(boolean allowRelativeDates, DateRangeItem rangeItemProperties, DateRangeDialog windowProperties, DateRangeCallback callback) /*-{
        $wnd.isc.DateRangeDialog.askForRange(allowRelativeDates, rangeItemProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), windowProperties == null ? null : windowProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), 
			$entry( function(criterion) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.DateRangeCallback::execute(Lcom/smartgwt/client/data/Criterion;)(
					@com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(criterion)
				);
			}));
    }-*/;


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
     * @param dateRangeDialogProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DateRangeDialog dateRangeDialogProperties) /*-{
        if (dateRangeDialogProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DateRangeDialog.@java.lang.Object::getClass()(), "setDefaultProperties", dateRangeDialogProperties.@java.lang.Object::getClass()());
        }
        dateRangeDialogProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = dateRangeDialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DateRangeDialog.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Helper method to launch a DateRangeDialog to have a date range input by the user.
     * @param allowRelativeDates whether to allow relative date entry via 
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem}s, default true
     * @param rangeItemProperties properties for the DateRangeItem
     * @param windowProperties properties for the Window
     * @param callback method to fire once user has input values, with a single parameter
     * "criterion" of type {@link com.smartgwt.client.data.Criterion}.
     * See {@link com.smartgwt.client.docs.Callback Callback}
     * @deprecated use 
     * {@link #askForRange(boolean,DateRangeItem,DateRangeDialog,DateRangeCallback)} instead.
     */
    @Deprecated
    public static native void askForRange(boolean allowRelativeDates, DateRangeItem rangeItemProperties, DateRangeDialog windowProperties, String callback) /*-{
        $wnd.isc.DateRangeDialog.askForRange(allowRelativeDates, rangeItemProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), 
                                             windowProperties == null ? null : windowProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), callback);
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DateRangeDialogLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateRangeDialog.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.clearButtonTitle = getAttributeAsString("clearButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateRangeDialog.clearButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.headerTitle = getAttributeAsString("headerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateRangeDialog.headerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.okButtonTitle = getAttributeAsString("okButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateRangeDialog.okButtonTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DateRangeDialogLogicalStructure s = new DateRangeDialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
