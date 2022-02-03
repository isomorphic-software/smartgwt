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
 
package com.smartgwt.client.widgets.rte;


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
 * Dialog shown for editing properties of HTML lists in a {@link com.smartgwt.client.widgets.RichTextEditor}.  Contains a
 * {@link com.smartgwt.client.widgets.rte.ListPropertiesPane}. <p> Cannot be directly used; shown in documentation only for
 * skinning purposes.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ListPropertiesDialog")
public class ListPropertiesDialog extends Window implements com.smartgwt.client.widgets.rte.events.HasApplyClickHandlers, com.smartgwt.client.widgets.rte.events.HasCancelClickHandlers {

    public static ListPropertiesDialog getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ListPropertiesDialog(jsObj);
        } else {
            assert refInstance instanceof ListPropertiesDialog;
            return (ListPropertiesDialog)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ListPropertiesDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ListPropertiesDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ListPropertiesDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ListPropertiesDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ListPropertiesDialog(){
        scClassName = "ListPropertiesDialog";
    }

    public ListPropertiesDialog(JavaScriptObject jsObj){
        scClassName = "ListPropertiesDialog";
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
     * The Apply button. When clicked, the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#addApplyClickHandler
     * applyClick} event is fired. <p> {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getApplyButtonTitle
     * applyButtonTitle} is a {@link com.smartgwt.client.docs.AutoChildUsage passthrough} for the button's {@link
     * com.smartgwt.client.widgets.Button#getTitle title}.
     * <p>
     * This component is an AutoChild named "applyButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current applyButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getApplyButton() throws IllegalStateException {
        errorIfNotCreated("applyButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("applyButton"));
    }
    

    /**
     * The title of the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getApplyButton Apply button}.
     *
     * @param applyButtonTitle New applyButtonTitle value. Default value is "Apply"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setApplyButtonTitle(String applyButtonTitle)  throws IllegalStateException {
        setAttribute("applyButtonTitle", applyButtonTitle, false);
    }

    /**
     * The title of the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getApplyButton Apply button}.
     *
     * @return Current applyButtonTitle value. Default value is "Apply"
     */
    public String getApplyButtonTitle()  {
        return getAttributeAsString("applyButtonTitle");
    }
    

    /**
     * The Cancel button. When clicked, the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#addCancelClickHandler
     * cancelClick} event is fired. <p> {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getCancelButtonTitle
     * cancelButtonTitle} is a {@link com.smartgwt.client.docs.AutoChildUsage passthrough} for the button's {@link
     * com.smartgwt.client.widgets.Button#getTitle title}.
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
     * The title of the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getCancelButton Cancel button}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title of the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getCancelButton Cancel button}.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.rte.ListPropertiesPane} contained by this ListPropertiesDialog.
     * <p>
     * This component is an AutoChild named "listPropertiesPane".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current listPropertiesPane value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListPropertiesPane getListPropertiesPane() throws IllegalStateException {
        errorIfNotCreated("listPropertiesPane");
        return (ListPropertiesPane)ListPropertiesPane.getByJSObject(getAttributeAsJavaScriptObject("listPropertiesPane"));
    }
    

    /**
     * The title of this ListPropertiesDialog.
     *
     * @param title New title value. Default value is "List Properties"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * The title of this ListPropertiesDialog.
     *
     * @return Current title value. Default value is "List Properties"
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a applyClick handler.
     * <p>
     * Notification method fired when the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getApplyButton Apply
     * button} is clicked.
     *
     * @param handler the applyClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addApplyClickHandler(com.smartgwt.client.widgets.rte.events.ApplyClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.rte.events.ApplyClickEvent.getType()) == 0) setupApplyClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.rte.events.ApplyClickEvent.getType());
    }

    private native void setupApplyClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var applyClick = $entry(function(){
            var param = {"_this": this, "listProperties" : arguments[0]};
            var event = @com.smartgwt.client.widgets.rte.events.ApplyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.rte.ListPropertiesDialog::handleTearDownApplyClickEvent()();
            if (hasDefaultHandler) this.Super("applyClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("applyClick"));
            obj.addProperties({applyClick:  applyClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("applyClick"));
            obj.applyClick =  applyClick             ;
        }
    }-*/;

    private void handleTearDownApplyClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.rte.events.ApplyClickEvent.getType()) == 0) tearDownApplyClickEvent();
    }

    private native void tearDownApplyClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("applyClick")) delete obj.applyClick;
    }-*/;

    /**
     * Add a cancelClick handler.
     * <p>
     * Notification method fired when the {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog#getCancelButton Cancel
     * button} is clicked.
     *
     * @param handler the cancelClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCancelClickHandler(com.smartgwt.client.widgets.rte.events.CancelClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.rte.events.CancelClickEvent.getType()) == 0) setupCancelClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.rte.events.CancelClickEvent.getType());
    }

    private native void setupCancelClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var cancelClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.rte.events.CancelClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.rte.ListPropertiesDialog::handleTearDownCancelClickEvent()();
            if (hasDefaultHandler) this.Super("cancelClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("cancelClick"));
            obj.addProperties({cancelClick:  cancelClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("cancelClick"));
            obj.cancelClick =  cancelClick             ;
        }
    }-*/;

    private void handleTearDownCancelClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.rte.events.CancelClickEvent.getType()) == 0) tearDownCancelClickEvent();
    }

    private native void tearDownCancelClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("cancelClick")) delete obj.cancelClick;
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
     * @param listPropertiesDialogProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ListPropertiesDialog listPropertiesDialogProperties) /*-{
        if (listPropertiesDialogProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ListPropertiesDialog.@java.lang.Object::getClass()(), "setDefaultProperties", listPropertiesDialogProperties.@java.lang.Object::getClass()());
        }
        listPropertiesDialogProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = listPropertiesDialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ListPropertiesDialog.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ListPropertiesDialogLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.applyButtonTitle = getAttributeAsString("applyButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ListPropertiesDialog.applyButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ListPropertiesDialog.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ListPropertiesDialog.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ListPropertiesDialogLogicalStructure s = new ListPropertiesDialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
