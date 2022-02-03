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
 
package com.smartgwt.client.widgets.form.fields;


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

/**
 * FormItem for adding a Button to a form.
 */
@BeanFactory.FrameworkClass
public class ButtonItem extends CanvasItem implements com.smartgwt.client.widgets.form.fields.events.HasClickHandlers {

    public static ButtonItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ButtonItem) {
            existingObj.setJsObj(jsObj);
            return (ButtonItem)existingObj;
        } else

        {
            return new ButtonItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ButtonItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ButtonItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ButtonItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ButtonItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.ButtonItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public ButtonItem(){
        setAttribute("editorType", "ButtonItem");
    }

    public ButtonItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public ButtonItem(String name) {
        setName(name);
                setAttribute("editorType", "ButtonItem");
    }


    public ButtonItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "ButtonItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should the button auto fit to its title. Maps to {@link com.smartgwt.client.widgets.Button#getAutoFit Button.autoFit}
     * attribute. Note that if an explicit width or height is specified for this item, it will be respected, disabling autoFit
     * behavior
     *
     * @param autoFit New autoFit value. Default value is true
     */
    public void setAutoFit(Boolean autoFit) {
        setAttribute("autoFit", autoFit);
    }

    /**
     * Should the button auto fit to its title. Maps to {@link com.smartgwt.client.widgets.Button#getAutoFit Button.autoFit}
     * attribute. Note that if an explicit width or height is specified for this item, it will be respected, disabling autoFit
     * behavior
     *
     * @return Current autoFit value. Default value is true
     */
    public Boolean getAutoFit()  {
        Boolean result = getAttributeAsBoolean("autoFit", true);
        return result == null ? true : result;
    }
    

    /**
     * Optional <code>baseStyle</code> will be applied to the button.
     *
     * @param baseStyle New baseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle);
    }

    /**
     * Optional <code>baseStyle</code> will be applied to the button.
     *
     * @return Current baseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * This item is an autoChild generated {@link com.smartgwt.client.widgets.Canvas} displayed by the ButtonItem and is an
     * instance of {@link com.smartgwt.client.widgets.Button} by defaut, cuztomizeable  via the {@link
     * com.smartgwt.client.widgets.form.fields.ButtonItem#getButtonConstructor buttonConstructor} attribute.
     * <p>
     * This component is an AutoChild named "button".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current button value. Default value is null
     */
    public Canvas getButton()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("button"));
    }
    
    
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "ButtonItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor) {
        setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "ButtonItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Criteria to be evaluated to determine whether this item should be enabled.  This property is incompatible with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen readOnlyWhen} and any setting you provide for the
     * latter will be ignored if this property is set. <P> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * ButtonItem using enableWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     * {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue} can be set to
     * <code>false</code> to prevent the field from storing its value into the form's values.
     *
     * @param enableWhen New enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public void setEnableWhen(AdvancedCriteria enableWhen) {
        if (enableWhen instanceof Criterion) {
            enableWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("enableWhen", enableWhen == null ? null : enableWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this item should be enabled.  This property is incompatible with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen readOnlyWhen} and any setting you provide for the
     * latter will be ignored if this property is set. <P> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * ButtonItem using enableWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     * {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue} can be set to
     * <code>false</code> to prevent the field from storing its value into the form's values.
     *
     * @return Current enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getEnableWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("enableWhen"));
    }
    

    /**
     * These items are in a row by themselves by default
     *
     * @param endRow New endRow value. Default value is true
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * These items are in a row by themselves by default
     *
     * @return Current endRow value. Default value is true
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getEndRow()  {
        Boolean result = getAttributeAsBoolean("endRow", true);
        return result == null ? true : result;
    }
    
    

    /**
     * Optional icon image to display on the button for this item.  See {@link com.smartgwt.client.widgets.Button#getIcon
     * Button.icon}.
     *
     * @param icon New icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * Optional icon image to display on the button for this item.  See {@link com.smartgwt.client.widgets.Button#getIcon
     * Button.icon}.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only}, how should this item be
     * displayed to the user? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay DynamicForm.readOnlyDisplay} default.
     *
     * @param readOnlyDisplay New readOnlyDisplay value. Default value is "disabled"
     * @see com.smartgwt.client.widgets.form.DynamicForm#setReadOnlyDisplay
     */
    public void setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay) {
        setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue());
    }

    /**
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only}, how should this item be
     * displayed to the user? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay DynamicForm.readOnlyDisplay} default.
     *
     * @return Current readOnlyDisplay value. Default value is "disabled"
     * @see com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    

    /**
     * This property governs whether {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver}
     * is true on the automatically created {@link com.smartgwt.client.widgets.Button} for this item.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets showFocusedAsOver.
     *
     * @param showFocusedAsOver New showFocusedAsOver value. Default value is null
     */
    public void setShowFocusedAsOver(Boolean showFocusedAsOver) {
        setAttribute("showFocusedAsOver", showFocusedAsOver);
    }

    /**
     * This property governs whether {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver}
     * is true on the automatically created {@link com.smartgwt.client.widgets.Button} for this item.
     *
     * @return Current showFocusedAsOver value. Default value is null
     */
    public Boolean getShowFocusedAsOver()  {
        return getAttributeAsBoolean("showFocusedAsOver", true);
    }
    

    /**
     * Buttons do not show a title by default.
     *
     * @param showTitle New showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Buttons do not show a title by default.
     *
     * @return Current showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? false : result;
    }
    

    /**
     * These items are in a row by themselves by default
     *
     * @param startRow New startRow value. Default value is true
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * These items are in a row by themselves by default
     *
     * @return Current startRow value. Default value is true
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getStartRow()  {
        Boolean result = getAttributeAsBoolean("startRow", true);
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a click handler.
     * <p>
     * Called when a ButtonItem is clicked on.
     *
     * @param handler the click handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.form.fields.events.ClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType()) == 0) setupClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType());
    }

    private native void setupClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var click = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.ButtonItem::handleTearDownClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.click = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return click(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType()) == 0) tearDownClickEvent();
    }

    private native void tearDownClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "click" in obj) delete obj.click;
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
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
     * @param buttonItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ButtonItem buttonItemProperties) /*-{
        if (buttonItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ButtonItem.@java.lang.Object::getClass()(), "setDefaultProperties", buttonItemProperties.@java.lang.Object::getClass()());
        }
        buttonItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = buttonItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.ButtonItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    public Canvas getCanvas() {
        return Button.getOrCreateRef(getAttributeAsJavaScriptObject("canvas"));
    }

    /**
     * Custom Properties to apply to the button item.
     *
     * @param buttonProperties properties to apply to the button item.
     */
    public void setButtonProperties(Button buttonProperties) {
        if (buttonProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setButtonProperties", "Button");
        }                                                                       
        buttonProperties.setConfigOnly(true);
        setAttribute("buttonProperties", JSOHelper.cleanProperties(buttonProperties.getConfig(), true));
    }

}
