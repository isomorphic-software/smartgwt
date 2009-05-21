/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.widgets.layout.*;
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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Dialogs are a specialized version of {@link com.smartgwt.client.widgets.Window} used for small windows such as&#010 alerts, prompts, and confirmations.  They can be modal or modeless (via the&#010 {@link com.smartgwt.client.widgets.Window#getIsModal isModal} property) and will contain various children by default&#010 ("titlebar", "resizer", etc).&#010 <P>&#010 NOTE: If you are building a custom component that will add components to the Window via&#010 {@link com.smartgwt.client.widgets.Window#addItem}, in most cases it makes sense

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
        
    }

    public Dialog(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Dialog.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Style of the Dialog background
    *
    * @param styleName styleName Default value is "dialogBackground"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * Style of the Dialog background
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * Whether to show a toolbar of buttons at the bottom of the Dialog.
    *
    * @param showToolbar showToolbar Default value is false
    */
    public void setShowToolbar(Boolean showToolbar) {
        setAttribute("showToolbar", showToolbar, true);
    }
    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowToolbar()  {
        return getAttributeAsBoolean("showToolbar");
    }

    // ********************* Methods ***********************

        /**
         * Method to save this Dialog's data. Called from <code>okClick()</code>, &#010 <code>applyClick()</code>.&#010 No default implementation - override to perform some action if required.&#010      &#010
         */
        public native void saveData() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.saveData();
        }-*/;

        /**
         * Handles a click on the close button of this window. The default implementation&#010 hides the window and returns false to cancel bubbling.  Override this method if you want&#010 other actions to be taken.&#010
         */
        public native void closeClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.closeClick();
        }-*/;

        /**
         * Handle a click on the 'cancel' button of this Dialog.&#010 Default implementation is to return null and hide the Dialog.&#010 Override to do something else.&#010
         */
        public native void cancelClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.cancelClick();
        }-*/;

        /**
         * Handle a click on the 'ok' button of this Dialog.&#010 Default implementation is to call <code>saveData()</code>, hide the Dialog, then return&#010 <code>true</code>.  &#010 Override to do something else.&#010
         */
        public native void okClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.okClick();
        }-*/;

        /**
         * Handle a click on the 'apply' button of this Dialog.  &#010 Default implementation is to call <code>saveData()</code>, but NOT close the Dialog.&#010
         */
        public native void applyClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.applyClick();
        }-*/;

        /**
         * Handle a click on the 'yes' button of this Dialog.&#010 Default implementation is to return <code>true</code>.&#010 Override to do something else&#010
         */
        public native void yesClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.yesClick();
        }-*/;

        /**
         * Handle a click on the 'no' button of this Dialog.&#010 Default implementation is to return <code>false</code>.&#010 Override to do something else.&#010
         */
        public native void noClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.noClick();
        }-*/;


    // ********************* Static Methods ***********************

/*
 * SmartGWT (GWT for SmartGWT)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/*
* SmartGWT (GWT for SmartClient)
* Copyright 2008 and beyond, Isomorphic Software, Inc.
*
* SmartGWT is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License version 3
* as published by the Free Software Foundation.  SmartGWT is also
* available under typical commercial license terms - see
* http://smartclient.com/license
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*/



    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar showToolbar}, if shown.
     * <P> The set of buttons to use is typically set by calling one of the shortcuts.
     *
     * @param toolbarButtons the toolbart buttons
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




