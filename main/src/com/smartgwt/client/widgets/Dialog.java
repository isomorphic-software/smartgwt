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
 * Dialogs are a specialized version of {@link com.smartgwt.client.widgets.Window} used for small windows that contain just
 *  a text message or a text mesage with some standard buttons.
 *  <P>
 *  Many typical modal dialogs such as alerts and confirmations are built into the system with
 * convenience APIs - see {@link com.smartgwt.client.util.isc#say isc.say()}, {@link com.smartgwt.client.util.isc#warn
 * isc.warn()} and
 *  {@link com.smartgwt.client.util.isc#askForValue isc.askForValue()}.
 *  <P>
 *  Dialogs can be modal or non-modal according to {@link com.smartgwt.client.widgets.Window#getIsModal isModal}.
 *  <P>
 *  NOTE: If you are building a dialog that will involve more than just buttons and a message,
 *  consider starting from the {@link com.smartgwt.client.widgets.Window} class instead, where arbitrary components can be
 *  added to the body area via {@link com.smartgwt.client.widgets.Window#addItem Window.addItem()}.
 *  <P>
 *  This is an example of creating a custom dialog:
 *  
 *  
 *  <pre>
 *  final Dialog dialog = new Dialog();
 *  dialog.setMessage("Please choose whether to proceed");
 *  dialog.setIcon("[SKIN]ask.png");
 *  dialog.setButtons(new Button("OK"), new Button("Cancel"));
 *  dialog.addButtonClickHandler(new ButtonClickHandler() {
 *      public void onButtonClick(ButtonClickEvent event) {
 *          dialog.hide();
 *      }
 *  });
 *  dialog.draw();
 *  </pre>
 * 
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Dialog")
public class Dialog extends Window implements com.smartgwt.client.widgets.events.HasButtonClickHandlers {

    public static Dialog getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Dialog(jsObj);
        } else {
            assert refInstance instanceof Dialog;
            return (Dialog)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Dialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Dialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Dialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Dialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Dialog(){
        scClassName = "Dialog";
    }

    public Dialog(JavaScriptObject jsObj){
        scClassName = "Dialog";
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
     * Icon to show in the  {@link com.smartgwt.client.util.SC#ask SC.ask()} dialog.
     *
     * @param askIcon New askIcon value. Default value is "[SKIN]ask.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setAskIcon(String askIcon)  throws IllegalStateException {
        setAttribute("askIcon", askIcon, false);
    }

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#ask SC.ask()} dialog.
     *
     * @return Current askIcon value. Default value is "[SKIN]ask.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getAskIcon()  {
        return getAttributeAsString("askIcon");
    }
    

    /**
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     * @param autoFocus New autoFocus value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAutoFocus(Boolean autoFocus)  throws IllegalStateException {
        setAttribute("autoFocus", autoFocus, false);
    }

    /**
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     * @return Current autoFocus value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAutoFocus()  {
        Boolean result = getAttributeAsBoolean("autoFocus");
        return result == null ? true : result;
    }
    
    

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#confirm SC.confirm()} dialog.
     *
     * @param confirmIcon New confirmIcon value. Default value is "[SKIN]confirm.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setConfirmIcon(String confirmIcon)  throws IllegalStateException {
        setAttribute("confirmIcon", confirmIcon, false);
    }

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#confirm SC.confirm()} dialog.
     *
     * @return Current confirmIcon value. Default value is "[SKIN]confirm.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getConfirmIcon()  {
        return getAttributeAsString("confirmIcon");
    }
    

    /**
     * 
     *
     * @param defaultWidth New defaultWidth value. Default value is 360
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDefaultWidth(int defaultWidth)  throws IllegalStateException {
        setAttribute("defaultWidth", defaultWidth, false);
    }

    /**
     * 
     *
     * @return Current defaultWidth value. Default value is 360
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }
    

    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     * @param icon New icon value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setIcon(String icon)  throws IllegalStateException {
        setAttribute("icon", icon, false);
    }

    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * Size of the icon to show in this dialog.
     *
     * @param iconSize New iconSize value. Default value is 32
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size of the icon to show in this dialog.
     *
     * @return Current iconSize value. Default value is 32
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * Message to show in this dialog. <P> If a message is set the primary purpose of the dialog will be assumed to be to show
     * a message with buttons - auto-sizing to the message text will be enabled, and, if {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon} has also been set, the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageLabel messageLabel} and {@link
     * com.smartgwt.client.widgets.Dialog#getMessageIcon messageIcon} AutoChildren will be created and placed together in the
     * {@link com.smartgwt.client.widgets.Dialog#getMessageStack messageStack} AutoChild, with the toolbar underneath as usual.
     * If any of these behaviors are inconvenient or you want more precise control over a message and some custom widgets,
     * start from the superclass {@link com.smartgwt.client.widgets.Window} instead, and add controls via {@link
     * com.smartgwt.client.widgets.Window#addItem Window.addItem()}. <P> The message string may contain "${loadingImage}", if
     * so, the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     * @param message New message value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setMessage(String message)  throws IllegalStateException {
        setAttribute("message", message, false);
    }

    /**
     * Message to show in this dialog. <P> If a message is set the primary purpose of the dialog will be assumed to be to show
     * a message with buttons - auto-sizing to the message text will be enabled, and, if {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon} has also been set, the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageLabel messageLabel} and {@link
     * com.smartgwt.client.widgets.Dialog#getMessageIcon messageIcon} AutoChildren will be created and placed together in the
     * {@link com.smartgwt.client.widgets.Dialog#getMessageStack messageStack} AutoChild, with the toolbar underneath as usual.
     * If any of these behaviors are inconvenient or you want more precise control over a message and some custom widgets,
     * start from the superclass {@link com.smartgwt.client.widgets.Window} instead, and add controls via {@link
     * com.smartgwt.client.widgets.Window#addItem Window.addItem()}. <P> The message string may contain "${loadingImage}", if
     * so, the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     * @return Current message value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }
    

    /**
     * AutoChild that shows {@link com.smartgwt.client.widgets.Dialog#getIcon icon}.
     * <p>
     * This component is an AutoChild named "messageIcon".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current messageIcon value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Img getMessageIcon() throws IllegalStateException {
        errorIfNotCreated("messageIcon");
        return (Img)Img.getByJSObject(getAttributeAsJavaScriptObject("messageIcon"));
    }
    

    /**
     * AutoChild that shows {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     * <p>
     * This component is an AutoChild named "messageLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current messageLabel value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getMessageLabel() throws IllegalStateException {
        errorIfNotCreated("messageLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("messageLabel"));
    }
    

    /**
     * AutoChild that combines {@link com.smartgwt.client.widgets.Dialog#getMessage message} and {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon}.
     * <p>
     * This component is an AutoChild named "messageStack".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current messageStack value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getMessageStack() throws IllegalStateException {
        errorIfNotCreated("messageStack");
        return (Layout)Layout.getByJSObject(getAttributeAsJavaScriptObject("messageStack"));
    }
    
    

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#say SC.say()} dialog.
     *
     * @param sayIcon New sayIcon value. Default value is "[SKIN]say.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSayIcon(String sayIcon)  throws IllegalStateException {
        setAttribute("sayIcon", sayIcon, false);
    }

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#say SC.say()} dialog.
     *
     * @return Current sayIcon value. Default value is "[SKIN]say.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSayIcon()  {
        return getAttributeAsString("sayIcon");
    }
    

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog. Default of null will cause the value to be resolved
     * automatically to true or false when the Dialog is first drawn according as {@link
     * com.smartgwt.client.widgets.Dialog#getToolbarButtons toolbarButtons} contains buttons or not.
     *
     * @param showToolbar New showToolbar value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowToolbar(Boolean showToolbar)  throws IllegalStateException {
        setAttribute("showToolbar", showToolbar, false);
    }

    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog. Default of null will cause the value to be resolved
     * automatically to true or false when the Dialog is first drawn according as {@link
     * com.smartgwt.client.widgets.Dialog#getToolbarButtons toolbarButtons} contains buttons or not.
     *
     * @return Current showToolbar value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowToolbar()  {
        return getAttributeAsBoolean("showToolbar");
    }
    

    /**
     * Style of the Dialog background
     *
     * @param styleName New styleName value. Default value is "dialogBackground"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Style of the Dialog background
     *
     * @return Current styleName value. Default value is "dialogBackground"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * {@link com.smartgwt.client.types.AutoChild} of type Toolbar used to create the {@link
     * com.smartgwt.client.widgets.Dialog#getToolbarButtons toolbarButtons}.
     * <p>
     * This component is an AutoChild named "toolbar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current toolbar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Toolbar getToolbar() throws IllegalStateException {
        errorIfNotCreated("toolbar");
        return (Toolbar)Toolbar.getByJSObject(getAttributeAsJavaScriptObject("toolbar"));
    }
    
    

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#warn SC.warn()} dialog.
     *
     * @param warnIcon New warnIcon value. Default value is "[SKIN]warn.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setWarnIcon(String warnIcon)  throws IllegalStateException {
        setAttribute("warnIcon", warnIcon, false);
    }

    /**
     * Icon to show in the  {@link com.smartgwt.client.util.SC#warn SC.warn()} dialog.
     *
     * @return Current warnIcon value. Default value is "[SKIN]warn.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getWarnIcon()  {
        return getAttributeAsString("warnIcon");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a buttonClick handler.
     * <p>
     * Fires when any button in this Dialog's toolbar is clicked.  Default implementation does nothing.
     *
     * @param handler the buttonClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addButtonClickHandler(com.smartgwt.client.widgets.events.ButtonClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ButtonClickEvent.getType()) == 0) setupButtonClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ButtonClickEvent.getType());
    }

    private native void setupButtonClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var buttonClick = $entry(function(){
            var param = {"_this": this, "targetCanvas" : arguments[0], "index" : arguments[1]};
            var event = @com.smartgwt.client.widgets.events.ButtonClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.Dialog::handleTearDownButtonClickEvent()();
            if (hasDefaultHandler) this.Super("buttonClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("buttonClick"));
            obj.addProperties({buttonClick:  buttonClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("buttonClick"));
            obj.buttonClick =  buttonClick             ;
        }
    }-*/;

    private void handleTearDownButtonClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.ButtonClickEvent.getType()) == 0) tearDownButtonClickEvent();
    }

    private native void tearDownButtonClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("buttonClick")) delete obj.buttonClick;
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
     * @param dialogProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Dialog dialogProperties) /*-{
        if (dialogProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Dialog.@java.lang.Object::getClass()(), "setDefaultProperties", dialogProperties.@java.lang.Object::getClass()());
        }
        dialogProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = dialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Dialog.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * OK Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button OK = new Button("OK");
    /**
     * APPLY Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button APPLY = new Button("Apply");
    /**
     * YES Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button YES = new Button("Yes");
    /**
     * NO Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button NO = new Button("No");
    /**
     * CANCEL Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button CANCEL = new Button("Cancel");
    /**
     * DONE Button object. To handle click use {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler addButtonClickHandler} method.
     */
    public static Button DONE = new Button("Done");

    /**
     * This is a synonym for {@link com.smartgwt.client.widgets.Dialog#setButtons setButtons()}.
     * <P>
     * Sets the array of Buttons to show in the
     * {@link com.smartgwt.client.widgets.Dialog#getShowToolbar toolbar}, if shown.
     * <P>
     * Note that the buttons passed to this API may either be widgets intended as live buttons,
     * or configuration objects (as in the case of 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setFilterButtonProperties ListGrid.setFilterButtonProperties()}).
     * However, the safeguards present in the latter API can't be imposed here, because there's
     * no way to tell which widgets are live objects, and which are intended for configuration.
     * In effect, all widgets will be treated as live objects.  As a result, you musn't reuse
     * any configuration object passed to this API, which includes passing anything to thsi API
     * that's already been passed to "real" config APIs (like the one mentioned).
     *
     * @param toolbarButtons buttons for the toolbar. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has
     * been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setToolbarButtons(Canvas... toolbarButtons) {
        setAttribute("toolbarButtons", replaceButtonsWithDefault(toolbarButtons), false);
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
    
    /**
     * Array of Buttons to show in the
     * {@link com.smartgwt.client.widgets.Dialog#getShowToolbar toolbar}, if shown.
     * <P>
     * The set of buttons to use is typically set by calling one of the shortcuts such as
     * {@link com.smartgwt.client.util.isc#say isc.say()} or
     * {@link com.smartgwt.client.util.isc#confirm isc.confirm()}.  A custom set of buttons can
     * be passed to these shortcuts methods via the "properties" argument, or to a directly
     * created Dialog.
     * <P>
     * In both cases, a mixture of 
     * {@link #OK built-in buttons}, custom buttons, and
     * other components (such as a {@link com.smartgwt.client.widgets.layout.LayoutSpacer}) can
     * be passed.
     * <P>  
     * Built-in buttons can be referred to via static fields on the Dialog class such as
     * <code>Dialog.OK</code>, for example:
     * <pre>
     * Dialog dialog = new Dialog();
     * Canvas layoutSpacer = new LayoutSpacer();
     * layoutSpacer.setWidth(50);
     * Button notNowButton = new Button("Not now");
     * notNowButton.addClickHandler(new ClickHandler() {
     *     public void onClick(ClickEvent event) {
     *         doSomething();
     *     }
     * });
     * dialog.setButtons(Dialog.OK, Dialog.CANCEL, layoutSpacer, notNowButton);
     * dialog.draw();
     * </pre>
     * All buttons will fire the
     * {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler Dialog.buttonClick()} 
     * handler.
     * <P>
     * Note that the buttons passed to this API may either be widgets intended as live buttons,
     * or configuration objects (as in the case of 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#setFilterButtonProperties ListGrid.setFilterButtonProperties()}).
     * However, the safeguards present in the latter API can't be imposed here, because there's
     * no way to tell which widgets are live objects, and which are intended for configuration.
     * In effect, all widgets will be treated as live objects.  As a result, you musn't reuse
     * any configuration object passed to this API, which includes passing anything to thsi API
     * that's already been passed to "real" config APIs (like the one mentioned).
     * <P>
     * While any live objects that have already been instantiated at the time this call is
     * made will become Buttons in the Dialog, uninstantiated live objects will merely
     * be used as templates to create separate SmartGWT Button objects when the Dialog instance
     * is created.  If you need the live objects you pass in to be the ones actually returned
     * by Dialog-related events, you can force instantiation beforehand by calling {@link 
     * com.smartgwt.client.widgets.BaseWidget#completeCreation button.completeCreation()}.
     *
     * @param buttons buttons Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setButtons(Button... buttons)  throws IllegalStateException {
        setAttribute("buttons", replaceButtonsWithDefault(buttons), false);
    }

    private JavaScriptObject[] replaceButtonsWithDefault(Canvas... buttons) {
        JavaScriptObject[] result = new JavaScriptObject[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            Canvas button = buttons[i];
            if      (button == Dialog.OK)     result[i] = getButton("OK");
            else if (button == Dialog.APPLY)  result[i] = getButton("APPLY");
            else if (button == Dialog.CANCEL) result[i] = getButton("CANCEL");
            else if (button == Dialog.DONE)   result[i] = getButton("DONE");
            else if (button == Dialog.NO)     result[i] = getButton("NO");
            else if (button == Dialog.YES)    result[i] = getButton("YES");
            else if (button.isCreated())      result[i] = button.getJsObj();
            else                              result[i] = button.getConfig();
        }
        return result;
    }
    
    private native JavaScriptObject getButton(String name) /*-{
        return $wnd.isc.Dialog[name];
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DialogLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.askIcon = getAttributeAsString("askIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.askIcon:" + t.getMessage() + "\n";
        }
        try {
            s.autoFocus = getAttributeAsString("autoFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.autoFocus:" + t.getMessage() + "\n";
        }
        try {
            s.confirmIcon = getAttributeAsString("confirmIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.confirmIcon:" + t.getMessage() + "\n";
        }
        try {
            s.defaultWidth = getAttributeAsString("defaultWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.defaultWidth:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.message = getAttributeAsString("message");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.message:" + t.getMessage() + "\n";
        }
        try {
            s.messageStyle = getAttributeAsString("messageStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.messageStyle:" + t.getMessage() + "\n";
        }
        try {
            s.sayIcon = getAttributeAsString("sayIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.sayIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showToolbar = getAttributeAsString("showToolbar");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.showToolbar:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.warnIcon = getAttributeAsString("warnIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.warnIcon:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DialogLogicalStructure s = new DialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
