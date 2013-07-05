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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Dialogs are a specialized version of {@link com.smartgwt.client.widgets.Window} used for small windows that contain just
 * a text
 *  message or a text mesage with some standard buttons.
 *  <P>
 *  Many typical modal dialogs such as alerts and confirmations are built into the system with convenience
 *  APIs - see  say,  warn and  askForValue.
 *  <P>
 *  Dialogs can be modal or non-modal according to {@link com.smartgwt.client.widgets.Window#getIsModal isModal}.
 *  <P>
 *  NOTE: If you are building a dialog that will involve more than just buttons and a message, consider
 * starting from the {@link com.smartgwt.client.widgets.Window} class instead, where arbitrary components can be added to
 * the body
 *  area via {@link com.smartgwt.client.widgets.Window#addItem Window.addItem}.
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
public class Dialog extends Window  implements com.smartgwt.client.widgets.events.HasButtonClickHandlers {

    public native static Dialog getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Dialog",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
        $wnd.isc["Dialog"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["Dialog"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************


    /**
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     * @param autoFocus autoFocus Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAutoFocus(Boolean autoFocus)  throws IllegalStateException {
        setAttribute("autoFocus", autoFocus, false);
    }

    /**
     * If a toolbar is showing, automatically place keyboard focus in the first button.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAutoFocus()  {
        return getAttributeAsBoolean("autoFocus");
    }



    /**
     * 
     *
     * @param defaultWidth defaultWidth Default value is 360
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDefaultWidth(int defaultWidth)  throws IllegalStateException {
        setAttribute("defaultWidth", defaultWidth, false);
    }

    /**
     * 
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }


    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     * @param icon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIcon(String icon)  throws IllegalStateException {
        setAttribute("icon", icon, false);
    }

    /**
     * Icon to show in this dialog - see {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }


    /**
     * Size of the icon to show in this dialog.
     *
     * @param iconSize iconSize Default value is 32
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size of the icon to show in this dialog.
     *
     * @return int
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
     * com.smartgwt.client.widgets.Window#addItem Window.addItem}. <P> The message string may contain "${loadingImage}", if so,
     * the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     * @param message . See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     * com.smartgwt.client.widgets.Window#addItem Window.addItem}. <P> The message string may contain "${loadingImage}", if so,
     * the standard loading spinner will appear at that location in the text (see {@link
     * com.smartgwt.client.widgets.Canvas#loadingImageSrc loadingImageSrc}). <P> The message will be styled with the {@link
     * com.smartgwt.client.widgets.Dialog#getMessageStyle messageStyle}.
     *
     * @return . See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public String getMessage()  {
        return getAttributeAsString("message");
    }


    /**
     * AutoChild that shows {@link com.smartgwt.client.widgets.Dialog#getIcon icon}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Img
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Img getMessageIcon() throws IllegalStateException {
        errorIfNotCreated("messageIcon");
        return Img.getOrCreateRef(getAttributeAsJavaScriptObject("messageIcon"));
    }


    /**
     * AutoChild that shows {@link com.smartgwt.client.widgets.Dialog#getMessage message}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Label
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getMessageLabel() throws IllegalStateException {
        errorIfNotCreated("messageLabel");
        return Label.getOrCreateRef(getAttributeAsJavaScriptObject("messageLabel"));
    }


    /**
     * AutoChild that combines {@link com.smartgwt.client.widgets.Dialog#getMessage message} and {@link
     * com.smartgwt.client.widgets.Dialog#getIcon icon}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Layout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getMessageStack() throws IllegalStateException {
        errorIfNotCreated("messageStack");
        return Layout.getOrCreateRef(getAttributeAsJavaScriptObject("messageStack"));
    }



    /**
     * Whether to show a toolbar of buttons at the bottom of the Dialog. Default of null will cause the value to be resolved
     * automatically to true or false when the Dialog is first drawn according as {@link
     * com.smartgwt.client.widgets.Dialog#getToolbarButtons toolbarButtons} contains buttons or not.
     *
     * @param showToolbar showToolbar Default value is null
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowToolbar()  {
        return getAttributeAsBoolean("showToolbar");
    }


    /**
     * Style of the Dialog background
     *
     * @param styleName . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "dialogBackground"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Style of the Dialog background
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }


    /**
     * AutoChild of type Toolbar used to create the {@link com.smartgwt.client.widgets.Dialog#getToolbarButons toolbarButons}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Toolbar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Toolbar getToolbar() throws IllegalStateException {
        errorIfNotCreated("toolbar");
        return Toolbar.getOrCreateRef(getAttributeAsJavaScriptObject("toolbar"));
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
        var obj = null;
        var selfJ = this;
        var buttonClick = $entry(function(){
            var param = {"button" : arguments[0], "index" : arguments[1]};

                var event = @com.smartgwt.client.widgets.events.ButtonClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({buttonClick:  buttonClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.buttonClick =  buttonClick             ;
        }
   }-*/;
	/**
     * Handle a click on the 'cancel' button of this Dialog. Default implementation is to return null and hide the Dialog.
     * Override to do something else.
     * @see com.smartgwt.client.types.DialogButtons
     */
    public native void cancelClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelClick();
    }-*/;
	/**
     * Method to save this Dialog's data. Called from <code>okClick()</code>, <code>applyClick()</code>. No default
     * implementation - override to perform some action if required.
     * @see com.smartgwt.client.widgets.Dialog#okClick
     * @see com.smartgwt.client.widgets.Dialog#applyClick
     */
    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param dialogProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Dialog dialogProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Dialog.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * OK  Button object to fire dialog's "okClick()" method on click.
     */
    public static Button OK = new Button("OK");
    /**
     * APPLY Button object to fire dialog's "applyClick()" method on click.
     */
    public static Button APPLY = new Button("Apply");
    /**
     * YES Button object to fire dialog's "yesClick()" method on click
     */
    public static Button YES = new Button("Yes");
    /**
     * NO  Button object to fire dialog's "noClick()" method on click.
     */
    public static Button NO = new Button("No");
    /**
     * CANCEL  Button object to fire dialog's "cancelClick()" method on click.
     */
    public static Button CANCEL = new Button("Cancel");
    /**
     * DONE  Button object to fire dialog's "doneClick()" method on click.
     */
    public static Button DONE = new Button("Done");

    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar showToolbar}, if shown.
     * <P> The set of buttons to use is typically set by calling one of the shortcuts.
     *
     * @param toolbarButtons the toolbar buttons
     * @throws IllegalStateException this property cannot be changed after the component has been rendered
     */
    public void setToolbarButtons(Canvas... toolbarButtons) {
        setAttribute("toolbarButtons", replaceButtonsWithDefault(toolbarButtons), false);
    }

    /**
     * Array of Buttons to show in the {@link com.smartgwt.client.widgets.Dialog#getShowToolbar toolbar}, if shown.&#010
     * <P>&#010 The set of buttons to use is typically set by calling one of the shortcuts such as&#010 {@link
     * com.smartgwt.client.util.isc#say isc.say} or {@link com.smartgwt.client.util.isc#confirm isc.confirm}.  A custom set of
     * buttons can be passed to&#010 these shortcuts methods via the "properties" argument, or to a directly created
     * Dialog.&#010 <P>&#010 In both cases, a mixture of {@link com.smartgwt.client.types.DialogButtons built-in buttons},
     * custom buttons,&#010 and other components (such as a {@link com.smartgwt.client.widgets.layout.LayoutSpacer}) can be
     * passed.  Built-in buttons&#010 can be referred to as <code>isc.Dialog.OK</code>, for example:&#010 <pre>&#010
     * isc.Dialog.create({&#010    buttons:[&#010       isc.Dialog.OK, &#010       isc.Dialog.CANCEL, &#010
     * isc.LayoutSpacer.create({width:50}), &#010       { title:"Not now", click:"doSomething()" }&#010    ]&#010 })&#010
     * </pre>&#010 Built-in buttons will call standard methods on the Dialog itself, such as&#010 {@link
     * com.smartgwt.client.widgets.Dialog#cancelClick Dialog.cancelClick}, as explained in the &#010 {@link
     * com.smartgwt.client.types.DialogButtons list of built-in buttons}.
     *
     * @param buttons buttons Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setButtons(Button... buttons)  throws IllegalStateException {
        setAttribute("buttons", replaceButtonsWithDefault(buttons), false);
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

    private JavaScriptObject[] replaceButtonsWithDefault(Canvas... buttons) {
        JavaScriptObject[] result = new JavaScriptObject[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == Dialog.OK) {
                result[i] = getButton("OK");
            } else if (buttons[i] == Dialog.APPLY) {
                result[i] = getButton("APPLY");
            } else if (buttons[i] == Dialog.CANCEL) {
                result[i] = getButton("CANCEL");
            } else if (buttons[i] == Dialog.DONE) {
                result[i] = getButton("DONE");
            } else if (buttons[i] == Dialog.NO) {
                result[i] = getButton("NO");
            } else if (buttons[i] == Dialog.YES) {
                result[i] = getButton("YES");
            } else {
                result[i] = buttons[i].getOrCreateJsObj();
            }
        }
        return result;
    }
    
    private native JavaScriptObject getButton(String name) /*-{
        return $wnd.isc.Dialog[name];
    }-*/;

    public LogicalStructureObject setLogicalStructure(DialogLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoFocus = getAttributeAsString("autoFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.autoFocus:" + t.getMessage() + "\n";
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
            s.showToolbar = getAttributeAsString("showToolbar");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.showToolbar:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Dialog.styleName:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        DialogLogicalStructure s = new DialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

