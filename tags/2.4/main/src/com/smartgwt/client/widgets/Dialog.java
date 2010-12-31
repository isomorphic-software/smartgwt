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
 
package com.smartgwt.client.widgets;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Dialogs are a specialized version of {@link com.smartgwt.client.widgets.Window} used for small windows such as alerts,
 * prompts, and confirmations.  They can be modal or modeless (via the {@link com.smartgwt.client.widgets.Window#getIsModal
 * isModal} property) and will contain various children by default ("titlebar", "resizer", etc). <P> NOTE: If you are
 * building a custom component that will add components to the Window via {@link com.smartgwt.client.widgets.Window#addItem
 * addItem()}, in most cases it makes sense
 */
public class Dialog extends Window {

    public static Dialog getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Dialog) obj;
        } else {
            return new Dialog(jsObj);
        }
    }

    public Dialog(){
        scClassName = "Dialog";
    }

    public Dialog(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog.
     *
     * @param showToolbar showToolbar Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowToolbar(Boolean showToolbar) {
        setAttribute("showToolbar", showToolbar, true);
    }

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowToolbar()  {
        return getAttributeAsBoolean("showToolbar");
    }

    /**
     * Style of the Dialog background
     *
     * @param styleName styleName Default value is "dialogBackground"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Style of the Dialog background
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    // ********************* Methods ***********************
            
    /**
     * Handle a click on the 'apply' button of this Dialog.   Default implementation is to call <code>saveData()</code>, but
     * NOT close the Dialog.
     */
    public native void applyClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.applyClick();
    }-*/;
            
    /**
     * Handle a click on the 'cancel' button of this Dialog. Default implementation is to return null and hide the Dialog.
     * Override to do something else.
     */
    public native void cancelClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelClick();
    }-*/;
            
    /**
     * Handles a click on the close button of this window. The default implementation hides the window and returns false to
     * cancel bubbling.  Override this method if you want other actions to be taken.
     */
    public native void closeClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeClick();
    }-*/;
            
    /**
     * Handle a click on the 'no' button of this Dialog. Default implementation is to return <code>false</code>. Override to do
     * something else.
     */
    public native void noClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.noClick();
    }-*/;
            
    /**
     * Handle a click on the 'ok' button of this Dialog. Default implementation is to call <code>saveData()</code>, hide the
     * Dialog, then return <code>true</code>.   Override to do something else.
     */
    public native void okClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.okClick();
    }-*/;
            
    /**
     * Method to save this Dialog's data. Called from <code>okClick()</code>,  <code>applyClick()</code>. No default
     * implementation - override to perform some action if required.
     */
    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;
            
    /**
     * Handle a click on the 'yes' button of this Dialog. Default implementation is to return <code>true</code>. Override to do
     * something else
     */
    public native void yesClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.yesClick();
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param dialogProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Dialog dialogProperties) /*-{
        $wnd.isc.Dialog.addProperties(dialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar showToolbar}, if shown.
     * <P> The set of buttons to use is typically set by calling one of the shortcuts.
     *
     * @param toolbarButtons the toolbar buttons
     * @throws IllegalStateException this property cannot be changed after the component has been rendered
     */
    public void setToolbarButtons(Canvas... toolbarButtons) {
        setAttribute("toolbarButtons", toolbarButtons, false);
    }

    /**
    * Style to apply to the message text shown in the center of the dialog
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param messageStyle messageStyle Default value is "normal"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setMessageStyle(String messageStyle)  throws IllegalStateException {
        setAttribute("messageStyle", messageStyle, false);
    }

}





