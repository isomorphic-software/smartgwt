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


/**
 * FormItem which renders a Canvas inline in a DynamicForm instance. <P> CanvasItem is {@link
 * com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue}:false by default, meaning that no
 * value from the CanvasItem will be present in {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
 * DynamicForm.getValues()} and no value will be saved when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData
 * DynamicForm.saveData()} is called.  This is appropriate if the Canvas does not participate in editing a value of the
 * form and is embedded in the form for layout or UI purposes only (e.g. {@link
 * com.smartgwt.client.widgets.form.fields.ButtonItem}, {@link com.smartgwt.client.widgets.form.fields.SectionItem}). Note
 * that some built-in CanvasItem types override the shouldSaveValue default to true (e.g. {@link
 * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem}, {@link
 * com.smartgwt.client.widgets.form.fields.RichTextItem}). <P> If you set {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue}:true, a  {@link
 * com.smartgwt.client.widgets.form.fields.CanvasItem#addShowValueHandler showValue} event will be raised to provide a
 * value that your item should display.  Handle this event by calling methods on the Canvas you've created to cause the
 * value to be displayed. <P> The {@link com.smartgwt.client.widgets.form.fields.CanvasItem#addShowValueHandler showValue}
 * event will be triggered in various situations where the form receives data, including a call to {@link
 * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}, {@link
 * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()}, or if {@link
 * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData()} is called and a Record is returned. 
 * Bear in mind that the <code>showValue</code> event can be called when the form and your item have not yet been drawn; in
 * this case, store the value for later display. <P> To provide a value to the form, call {@link
 * com.smartgwt.client.widgets.form.fields.CanvasItem#storeValue storeValue()} whenever the user changes the value in your
 * Canvas.  Generally, if storeValue() is called then {@link
 * com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue} should be overridden to true. 
 * Note that the form <b>will not</b> call getValue() in order to discover your item's value, so there is no purpose in
 * overriding this method; instead, call storeValue() to proactively inform the form about changes to the value.  This
 * approach is necessary in order to enable change events. <P> If you cannot easily detect changes to values in your
 * Canvas, a workaround is to call <code>storeValue</code> right before the form saves.
 */
@BeanFactory.FrameworkClass
public class CanvasItem extends FormItem implements com.smartgwt.client.widgets.form.fields.events.HasCanEditChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasReadOnlyDisplayChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasShowValueHandlers {

    public static CanvasItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof CanvasItem) {
            existingObj.setJsObj(jsObj);
            return (CanvasItem)existingObj;
        } else

        {
            return new CanvasItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CanvasItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.CanvasItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CanvasItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.CanvasItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.CanvasItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public CanvasItem(){
        setAttribute("editorType", "CanvasItem");
					setupCanvasConstructor();
    }

    public CanvasItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public CanvasItem(String name) {
        setName(name);
                setAttribute("editorType", "CanvasItem");
					setupCanvasConstructor();
    }


    public CanvasItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "CanvasItem");
					setupCanvasConstructor();
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt FormItem.prompt} is specified for this item, should
     * the prompt be applied to the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} for this item?
     *
     * @param applyPromptToCanvas New applyPromptToCanvas value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setApplyPromptToCanvas(Boolean applyPromptToCanvas) {
        return (CanvasItem)setAttribute("applyPromptToCanvas", applyPromptToCanvas);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt FormItem.prompt} is specified for this item, should
     * the prompt be applied to the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} for this item?
     *
     * @return Current applyPromptToCanvas value. Default value is true
     */
    public Boolean getApplyPromptToCanvas()  {
        Boolean result = getAttributeAsBoolean("applyPromptToCanvas", true);
        return result == null ? true : result;
    }
    

    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} be automatically
     * destroyed when the item  is destroyed? Form items are destroyed automatically when a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setItems DynamicForm.setItems()} removes them from their parent form, or if
     * their parent form is destroyed. This property governs whether, when this occurs,  the item's canvas should also be
     * {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}. <P> This property has no effect for canvases automatically
     * created via the "autoChild" pattern,  using {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties}, {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasDefaults canvasDefaults} etc. CanvasItems which create their
     * canvas in this way will always destroy the canvas when the item is destroyed or on an explicit {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCanvas setCanvas()} call, regardless of this property's value. <P>
     * Setting this property to true is typically appropriate for cases where a custom CanvasItem automatically creates its
     * canvas as part of its initialization flow, and the canvas will not be re-used outside the item.<br> Note that once a
     * canvas has been destroyed it can not be re-used elsewhere within an application.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDestroy New autoDestroy value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setAutoDestroy(Boolean autoDestroy) {
        return (CanvasItem)setAttribute("autoDestroy", autoDestroy);
    }

    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} be automatically
     * destroyed when the item  is destroyed? Form items are destroyed automatically when a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setItems DynamicForm.setItems()} removes them from their parent form, or if
     * their parent form is destroyed. This property governs whether, when this occurs,  the item's canvas should also be
     * {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}. <P> This property has no effect for canvases automatically
     * created via the "autoChild" pattern,  using {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties}, {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasDefaults canvasDefaults} etc. CanvasItems which create their
     * canvas in this way will always destroy the canvas when the item is destroyed or on an explicit {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCanvas setCanvas()} call, regardless of this property's value. <P>
     * Setting this property to true is typically appropriate for cases where a custom CanvasItem automatically creates its
     * canvas as part of its initialization flow, and the canvas will not be re-used outside the item.<br> Note that once a
     * canvas has been destroyed it can not be re-used elsewhere within an application.
     *
     * @return Current autoDestroy value. Default value is false
     */
    public Boolean getAutoDestroy()  {
        Boolean result = getAttributeAsBoolean("autoDestroy", true);
        return result == null ? false : result;
    }
    

    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String.  <P> If a <code>canvas</code> hasn't been specified via {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCanvas setCanvas()}, the canvas for this item will be auto-created
     * as configured by the methods {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildProperties 
     * setAutoChildProperties()} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildConstructor
     * setAutoChildConstructor()}. <P> Note that subclasses of <code>CanvasItem</code> may use a different AutoChild name than
     * just "canvas".  For example, {@link com.smartgwt.client.widgets.form.fields.SliderItem} uses "slider", and in that case,
     * you need to use the specific APIs provided by the subclass. <P> Note that {@link
     * com.smartgwt.client.widgets.Canvas#getCanvasItem Canvas.canvasItem} will be set on the canvas to point back to this
     * item.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter to update the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} at runtime
     *
     * @param canvas New canvas to display. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setCanvas(Canvas canvas) {
        return (CanvasItem)setAttribute("canvas", canvas == null ? null : canvas.getOrCreateJsObj());
    }

    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String.  <P> If a <code>canvas</code> hasn't been specified via {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCanvas setCanvas()}, the canvas for this item will be auto-created
     * as configured by the methods {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildProperties 
     * setAutoChildProperties()} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildConstructor
     * setAutoChildConstructor()}. <P> Note that subclasses of <code>CanvasItem</code> may use a different AutoChild name than
     * just "canvas".  For example, {@link com.smartgwt.client.widgets.form.fields.SliderItem} uses "slider", and in that case,
     * you need to use the specific APIs provided by the subclass. <P> Note that {@link
     * com.smartgwt.client.widgets.Canvas#getCanvasItem Canvas.canvasItem} will be set on the canvas to point back to this
     * item.
     * <p>
     * This component is an AutoChild named "canvas".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current canvas value. Default value is null
     */
    public Canvas getCanvas()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("canvas"));
    }
    
    
    
    

    /**
     * Flag to disable the criteria editing overrides described in  <code>setCriterionGetter()</code> whereby if this item
     * contains a DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is
     * required for cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of
     * nested objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editCriteriaInInnerForm New editCriteriaInInnerForm value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setEditCriteriaInInnerForm(Boolean editCriteriaInInnerForm) {
        return (CanvasItem)setAttribute("editCriteriaInInnerForm", editCriteriaInInnerForm);
    }

    /**
     * Flag to disable the criteria editing overrides described in  <code>setCriterionGetter()</code> whereby if this item
     * contains a DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is
     * required for cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of
     * nested objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     *
     * @return Current editCriteriaInInnerForm value. Default value is true
     */
    public Boolean getEditCriteriaInInnerForm()  {
        Boolean result = getAttributeAsBoolean("editCriteriaInInnerForm", true);
        return result == null ? true : result;
    }
    

    /**
     * Height of the Canvas.  Can be either a number indicating a fixed height in pixels, a percentage indicating a percentage
     * of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> Height may also be explicitly specified on the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. In this any <code>canvasItem.height</code> will be
     * ignored in favor of the value applied  to the canvas directly. In either case, percentage values will be resolved using
     * standard formItem sizing rules as described in {@link com.smartgwt.client.docs.FormLayout}
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setHeight(int height) {
        return (CanvasItem)setAttribute("height", height);
    }

    /**
     * Height of the Canvas.  Can be either a number indicating a fixed height in pixels, a percentage indicating a percentage
     * of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> Height may also be explicitly specified on the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. In this any <code>canvasItem.height</code> will be
     * ignored in favor of the value applied  to the canvas directly. In either case, percentage values will be resolved using
     * standard formItem sizing rules as described in {@link com.smartgwt.client.docs.FormLayout}
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current height value. Default value is null
     */
    public int getHeight()  {
        if (!(getAttributeAsObject("height") instanceof Integer)) { return -1; }
        return getAttributeAsInt("height");
    }

    /**
     * Height of the Canvas.  Can be either a number indicating a fixed height in pixels, a percentage indicating a percentage
     * of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> Height may also be explicitly specified on the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. In this any <code>canvasItem.height</code> will be
     * ignored in favor of the value applied  to the canvas directly. In either case, percentage values will be resolved using
     * standard formItem sizing rules as described in {@link com.smartgwt.client.docs.FormLayout}
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setHeight(String height) {
        return (CanvasItem)setAttribute("height", height);
    }

    /**
     * Height of the Canvas.  Can be either a number indicating a fixed height in pixels, a percentage indicating a percentage
     * of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> Height may also be explicitly specified on the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. In this any <code>canvasItem.height</code> will be
     * ignored in favor of the value applied  to the canvas directly. In either case, percentage values will be resolved using
     * standard formItem sizing rules as described in {@link com.smartgwt.client.docs.FormLayout}
     *
     * @return Current height value. Default value is null
     */
    public String getHeightAsString()  {
        return getAttributeAsString("height");
    }
    

    /**
     * Maximum valid height for this CanvasItem in pixels.  Used in calculating the row heights of the containing {@link
     * com.smartgwt.client.widgets.form.DynamicForm} if the item has a flexible {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getHeight height}.
     *
     * @param maxHeight New maxHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setMaxHeight(Integer maxHeight) {
        return (CanvasItem)setAttribute("maxHeight", maxHeight);
    }

    /**
     * Maximum valid height for this CanvasItem in pixels.  Used in calculating the row heights of the containing {@link
     * com.smartgwt.client.widgets.form.DynamicForm} if the item has a flexible {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getHeight height}.
     *
     * @return Current maxHeight value. Default value is null
     */
    public Integer getMaxHeight()  {
        return getAttributeAsInt("maxHeight");
    }
    

    /**
     * Minimum valid height for this CanvasItem in pixels.  Used in calculating the row heights of the containing {@link
     * com.smartgwt.client.widgets.form.DynamicForm} if the item has a flexible {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getHeight height}.
     *
     * @param minHeight New minHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setMinHeight(Integer minHeight) {
        return (CanvasItem)setAttribute("minHeight", minHeight);
    }

    /**
     * Minimum valid height for this CanvasItem in pixels.  Used in calculating the row heights of the containing {@link
     * com.smartgwt.client.widgets.form.DynamicForm} if the item has a flexible {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getHeight height}.
     *
     * @return Current minHeight value. Default value is null
     */
    public Integer getMinHeight()  {
        return getAttributeAsInt("minHeight");
    }
    

    /**
     * Whether this CanvasItem is intended to hold multiple values.  <P> This attribute can affect the return type of
     * getValue(). If this CanvasItem is storing multiple values, then the return type of getValue() is
     * <code>JavaScriptObject</code> (a JavaScript array object) if multiple is null or false. However, if multiple is true,
     * then the return type is either <code>List</code> or <code>RecordList</code>.
     *
     * @param multiple New multiple value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setMultiple(Boolean multiple) {
        return (CanvasItem)setAttribute("multiple", multiple);
    }

    /**
     * Whether this CanvasItem is intended to hold multiple values.  <P> This attribute can affect the return type of
     * getValue(). If this CanvasItem is storing multiple values, then the return type of getValue() is
     * <code>JavaScriptObject</code> (a JavaScript array object) if multiple is null or false. However, if multiple is true,
     * then the return type is either <code>List</code> or <code>RecordList</code>.
     *
     * @return Current multiple value. Default value is false
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? false : result;
    }
    

    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     * @param overflow New overflow value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setOverflow(Overflow overflow) {
        return (CanvasItem)setAttribute("overflow", overflow == null ? null : overflow.getValue());
    }

    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     * @return Current overflow value. Default value is null
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }
    

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. <P> When item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only} a different hover can be shown with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyHover FormItem.readOnlyHover}. Or, when item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisabled disabled} or read-only with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay:disabled} a different hover can be
     * shown with {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisabledHover FormItem.disabledHover}. <P> Note
     * that when the form is {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled} this prompt will not be shown.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt FormItem.prompt} for this item. Default implementation will also apply the prompt to {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} if {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getApplyPromptToCanvas applyPromptToCanvas} is true.
     *
     * @param prompt new prompt for the item. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public CanvasItem setPrompt(String prompt) {
        return (CanvasItem)setAttribute("prompt", prompt);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. <P> When item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only} a different hover can be shown with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyHover FormItem.readOnlyHover}. Or, when item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisabled disabled} or read-only with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay:disabled} a different hover can be
     * shown with {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisabledHover FormItem.disabledHover}. <P> Note
     * that when the form is {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled} this prompt will not be shown.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues()}? <P> Note that by default,
     * <code>shouldSaveValue</code> is false for CanvasItems, meaning that no value from the CanvasItem will be present in
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues()} and no value for the CanvasItem
     * will be saved when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. See
     * the {@link com.smartgwt.client.widgets.form.fields.CanvasItem} class overview for a discussion of values handling in
     * CanvasItems.
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItem} instance, for chaining setter calls
     */
    public CanvasItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (CanvasItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues()}? <P> Note that by default,
     * <code>shouldSaveValue</code> is false for CanvasItems, meaning that no value from the CanvasItem will be present in
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues()} and no value for the CanvasItem
     * will be saved when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. See
     * the {@link com.smartgwt.client.widgets.form.fields.CanvasItem} class overview for a discussion of values handling in
     * CanvasItems.
     *
     * @return Current shouldSaveValue value. Default value is false
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a canEditChanged handler.
     * <p>
     * Notification method called when the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} setting
     * is modified. Developers may make use of this to toggle between an editable and a read-only appearance of the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. <p> The default behavior is: <ul> <li>If
     * <code>canvas</code> is a {@link com.smartgwt.client.widgets.form.DynamicForm}, the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEdit DynamicForm.canEdit} setting is set to <code>canEdit</code>.
     * <li>{@link com.smartgwt.client.widgets.form.fields.CanvasItem#shouldDisableCanvas CanvasItem.shouldDisableCanvas()} is
     * called to determine if the <code>canvas</code> should be disabled. </ul> <p> Standard <code>CanvasItem</code>-based form
     * items may customize the default behavior. For example, a {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} will hide its {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboForm comboForm} if the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is  {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#READONLY} or {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC} and also disable the buttons when made read-only.
     *
     * @param handler the canEditChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCanEditChangedHandler(com.smartgwt.client.widgets.form.fields.events.CanEditChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent.getType()) == 0) setupCanEditChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent.getType());
    }

    private native void setupCanEditChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var canEditChanged = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.CanvasItem::handleTearDownCanEditChangedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.canEditChanged = 
            function () {
                var param = {"_this": this, "canEdit" : arguments[0]};
                return canEditChanged(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownCanEditChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent.getType()) == 0) tearDownCanEditChangedEvent();
    }

    private native void tearDownCanEditChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "canEditChanged" in obj) delete obj.canEditChanged;
    }-*/;

	/**
     * Overridden to return true if {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} is a
     * dynamicForm. See  <code>setCriterionGetter()</code> for details of editing advanced criteria using nested dynamicForms.
     *
     * @return true if this item's canvas is a DynamicForm
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Does this CanvasItem have keyboard focus. <P> This method will return true if this item's canvas, or any of its
     * descendents, has keyboard focus
     *
     * @return returns true if this item contains focus.
     */
    public native Boolean isFocused() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.isFocused();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Add a readOnlyDisplayChanged handler.
     * <p>
     * Notification method called when the {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay
     * readOnlyDisplay} setting is modified. Developers may make use of this to toggle between an editable and a read-only
     * appearance of the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. <p> The default behavior
     * is: when the <code>canvas</code> is a {@link com.smartgwt.client.widgets.form.DynamicForm}, the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay DynamicForm.readOnlyDisplay} setting is set to
     * <code>appearance</code>. <p> Standard <code>CanvasItem</code>-based form items may customize the default behavior.
     *
     * @param handler the readOnlyDisplayChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addReadOnlyDisplayChangedHandler(com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedEvent.getType()) == 0) setupReadOnlyDisplayChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedEvent.getType());
    }

    private native void setupReadOnlyDisplayChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var readOnlyDisplayChanged = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.CanvasItem::handleTearDownReadOnlyDisplayChangedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.readOnlyDisplayChanged = 
            function () {
                var param = {"_this": this, "appearance" : arguments[0]};
                return readOnlyDisplayChanged(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownReadOnlyDisplayChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedEvent.getType()) == 0) tearDownReadOnlyDisplayChangedEvent();
    }

    private native void tearDownReadOnlyDisplayChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "readOnlyDisplayChanged" in obj) delete obj.readOnlyDisplayChanged;
    }-*/;

    /**
     * Add a showValue handler.
     * <p>
     * This method will be called whenever this FormItem's value is being set via a programmatic call to e.g: {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} and may be overridden by CanvasItems
     * intended to support displaying data values to update the embedded Canvas to reflect the value passed in. Note that the
     * first parameter will be a  formatted value - while the second parameter will contain the underlying data value for the
     * item.
     *
     * @param handler the showValue handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addShowValueHandler(com.smartgwt.client.widgets.form.fields.events.ShowValueHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ShowValueEvent.getType()) == 0) setupShowValueEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ShowValueEvent.getType());
    }

    private native void setupShowValueEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var showValue = $entry(function(){
            var param = {"_this": this, "displayValue" : arguments[0], "dataValue" : arguments[1], "form" : arguments[2], "item" : arguments[3]};
            var event = @com.smartgwt.client.widgets.form.fields.events.ShowValueEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.CanvasItem::handleTearDownShowValueEvent()();
            });
        obj.showValue =  showValue 
        ;
    }-*/;

    private void handleTearDownShowValueEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ShowValueEvent.getType()) == 0) tearDownShowValueEvent();
    }

    private native void tearDownShowValueEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "showValue" in obj) delete obj.showValue;
    }-*/;

	/**
     * This method will place an entry for the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}
     * under this item in the  {@link com.smartgwt.client.widgets.TabIndexManager}. This ensures the user can tab into the
     * canvas (and its descendants) in the expected position within this item's DynamicForm. <P> See also {@link
     * com.smartgwt.client.widgets.Canvas#updateChildTabPositions DynamicForm.updateChildTabPositions()}.
     */
    public native void updateCanvasTabPosition() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateCanvasTabPosition();
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
     * @param canvasItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(CanvasItem canvasItemProperties) /*-{
        if (canvasItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(CanvasItem.@java.lang.Object::getClass()(), "setDefaultProperties", canvasItemProperties.@java.lang.Object::getClass()());
        }
        canvasItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = canvasItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.CanvasItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    
    private static CanvasItem getCanvasItemRef (JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if (obj == null) return null;
        
        if(obj instanceof CanvasItem) {
            return (CanvasItem) obj;
        } else {
            return null;
        }
    }


    protected native void setupCanvasConstructor() /*-{
        var self = this.@com.smartgwt.client.widgets.form.fields.CanvasItem::getJsObj()();
        if(self == null) return null;
        self.createCanvas = $debox($entry(function() {
            
            //in cases where a SGWT FormItem instance is used for a setEditorType(..) call, there will
            //not be a SGWT object ref associated with the JS object. In this case, simply return
            // Note the check for 'getCanavsItemRef' rather than just getRef ensures the Java Object
            // is actually a CanvasItem (rather than a generic "FormItem" instance)
            var jObj = @com.smartgwt.client.widgets.form.fields.CanvasItem::getCanvasItemRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            
            if(jObj == null) return this.canvas;
            var jCanvas = jObj.@com.smartgwt.client.widgets.form.fields.CanvasItem::createCanvas()();
            if (jCanvas != null) return jCanvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
            return this.canvas;
        }));
    }-*/;    
    
    /**
     * This method is called to dynamically create a canvas for this CanvasItem.
     * Overriding this method provides a mechanism to dynamically create the
     * canvas rather than calling {@link #setCanvas()} directly.
     * 
     * @return  the canvas to be rendered inside this CanvasItem
     */
    protected Canvas createCanvas() {
    	JavaScriptObject jsCanvas = getAttributeAsJavaScriptObject("canvas");
    	
    	if (jsCanvas == null) return null;
    	return (Canvas) Canvas.getByJSObject(jsCanvas);
    }

    /**
     * Sets the <code>ShouldDisableCanvasCustomizer</code> that is called to determine whether
     * the {@link CanvasItem#getCanvas() canvas} should be
     * {@link com.smartgwt.client.widgets.Canvas#setDisabled(boolean) disabled} when this
     * <code>CanvasItem</code> is disabled or its
     * {@link CanvasItem#addCanEditChangedHandler(com.smartgwt.client.widgets.form.fields.events.CanEditChangedHandler) editability changes}.
     * <p>
     * Setting a <code>ShouldDisableCanvasCustomizer</code> is the Smart&nbsp;GWT equivalent
     * of overriding the <code>CanvasItem.shouldDisableCanvas()</code> method in SmartClient.
     * @param customizer the <code>ShouldDisableCanvasCustomizer</code> to use.
     */
    public native void setShouldDisableCanvasCustomizer(ShouldDisableCanvasCustomizer customizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (customizer == null) {
            if (self.getClass) {
                self.shouldDisableCanvas = self.getClass().getInstanceProperty("shouldDisableCanvas");
            } else {
                delete self.shouldDisableCanvas;
            }
        } else {
            self.shouldDisableCanvas = $entry(function () {
                return customizer.@com.smartgwt.client.widgets.form.fields.ShouldDisableCanvasCustomizer::shouldDisableCanvas()();
            });
        }
    }-*/;

    /**
     * Store a value for this form item.
     * <P>
     * This method will fire standard {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change} 
     * and {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler FormItem.changed} handlers, and 
     * store the value passed in such that subsequent calls to {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * FormItem.getValue} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValue DynamicForm.getValue} will return the
     * new value for this item. 
     * <P> 
     * For canvasItems that manipulate values and display them in some arbitrary canvas
     * representation developers should call this method when the user interacts with the embedded canvas in a way that
     * modifies the value for the item. 
     * <P> 
     * If you cannot easily detect changes to values in your Canvas, a workaround is to
     * call <code>storeValue</code> right before the form saves.
     * @param value value to save for this item
     */
    public void storeValue(Object value) {
        if (value == null) {
            doStoreValue(null);
        } else if (value instanceof String) {
            // To avoid GWT Issue 4301, check for a `String' instance and handle that specially.
            // http://forums.smartclient.com/showthread.php?t=8159#aStringObject
            doStoreValue((String)value);
        } else if (value instanceof CharSequence || value instanceof Character) {
            doStoreValue(value.toString());
        } else if (value instanceof Number) {
            doStoreValue(JSOHelper.doubleValue((Number) value));
        } else if (value instanceof Boolean) {
            doStoreValue(((Boolean) value).booleanValue());
        } else if (value instanceof Date) {
        	doStoreValue(JSOHelper.convertToJavaScriptDate((Date) value));
        } else if (value instanceof RelativeDate) {
            doStoreValue(((RelativeDate) value).getValue());
        } else if (value instanceof ValueEnum) {
            doStoreValue(((ValueEnum) value).getValue());
        } else if (value.getClass().isArray()) {
            final Object jsArray;
            if (value instanceof Object[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((Object[])value, false);
            } else if (value instanceof int[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((int[])value);
            } else if (value instanceof double[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((double[])value);
            } else if (value instanceof float[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((float[])value);
            } else if (value instanceof boolean[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((boolean[])value);
            } else if (value instanceof char[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((char[])value);
            } else if (value instanceof byte[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((byte[])value);
            } else if (value instanceof short[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((short[])value);
            } else if (value instanceof long[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((long[])value);
            } else {
                assert false : value.getClass() + " should not be an array class.";
                jsArray = value;
            }
            doStoreValue(jsArray);
        } else if (value instanceof List) {
            doStoreValue(JSOHelper.convertToJavaScriptArray(((List<?>)value).toArray(), false));
        } else if (value instanceof Map) {
            doStoreValue(JSOHelper.convertMapToJavascriptObject((Map<?, ?>) value, false));
        } else if (value instanceof Record) {
            storeValue((Record)value);
        } else if (value instanceof RecordList) {
            storeValue((RecordList)value);
        } else {
            doStoreValue(value);
        }
    }

    private native void doStoreValue(Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.storeValue(value);
    }-*/;

    // Note that the primitive signatures below are needed to avoid unintended reboxing of
    // double and boolean types passed from the calling routine above.  Reboxing these values
    // will lead to crashes in (Super) Development Mode as the browser will get Java objects.

    private native void doStoreValue(double value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.storeValue(value);
    }-*/;

    private native void doStoreValue(boolean value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.storeValue(value);
    }-*/;


    /**
     * Store a value for this form item. This method will fire standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler FormItem.changed} handlers, and store out the method
     * passed in such that subsequent calls to {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * FormItem.getValue} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValue DynamicForm.getValue} will return the
     * new value for this item. <P> For canvasItems that manipulate values and display them in some arbitrary canvas
     * representation developers should call this method when the user interacts with the embedded canvas in a way that
     * modifies the value for the item. <P> If you cannot easily detect changes to values in your Canvas, a workaround is to
     * call <code>storeValue</code> right before the form saves.
     * @param value value to save for this item
     */
    // If this method is removed, need to remove the call to storeValue(Record) in storeValue(Object)
    // or else storeValue(Object) will call itself, causing a stack overflow.
    public native void storeValue(Record value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (value != null) {
            value = value.@com.smartgwt.client.core.DataClass::getJsObj()();
        }
        self.storeValue(value);
    }-*/;
    
    
    /**
     * Store a value for this form item. This method will fire standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler FormItem.changed} handlers, and store out the method
     * passed in such that subsequent calls to {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * FormItem.getValue} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValue DynamicForm.getValue} will return the
     * new value for this item. <P> For canvasItems that manipulate values and display them in some arbitrary canvas
     * representation developers should call this method when the user interacts with the embedded canvas in a way that
     * modifies the value for the item. <P> If you cannot easily detect changes to values in your Canvas, a workaround is to
     * call <code>storeValue</code> right before the form saves.
     * @param value value to save for this item
     */
    // If this method is removed, need to remove the call to storeValue(RecordList) in storeValue(Object)
    // or else storeValue(Object) will call itself, causing a stack overflow.
    public native void storeValue(RecordList value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (value != null) {
            value = value.@com.smartgwt.client.data.RecordList::getJsObj()();
        }
        self.storeValue(value);
    }-*/;

    /**
     * AdvancedCriteria objects may be edited via nested dynamicForms as described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCriterionGetter CanvasItem.setCriterionGetter}.
     * <P> The default <code>canEditCriterion()</code> predicate is overridden to return true if this item's canvas is a DynamicForm, where the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOperator operator} matches the operator of the criterion passed in and
     * dynamicForm contains items where the registered {@link com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate
     * FormItemCanEditCriterionPredicate}'s {@link com.smartgwt.client.widgets.form.FormItemCanEditCriterionPredicate#canEditCriterion
     * canEditCriterion} method returns true for each sub-criterion in the object passed in.
     * @param predicate the predicate to determine the form items that can edit the criterion in question
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItem.setCanEditCriterionPredicate
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCanEditCriterionPredicate(FormItemCanEditCriterionPredicate predicate) {
        super.setCanEditCriterionPredicate(predicate);
    }

    /**
     * The standard formItem criteria editing APIs have been overridden in the canvasItem class
     *  to simplify the editing of complex {@link com.smartgwt.client.data.AdvancedCriteria} objects using nested
     *  DynamicForms.
     *  <P>
     *  The following pattern is supported without need for further modification:<br>
     *  A complex Advanced criteria object may have nested sub criteria using the <code>"and"</code>
     *  or <code>"or"</code> operators. For example:
     *  <pre>
     *      AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new Criterion[] {
     *          new Criterion("field1", OperatorId.ICONTAINS, "value1"),
     *          new AdvancedCriteria(OperatorId.OR, new Criterion[] {
     *                  new Criterion("innerField1", OperatorId.EQUALS, "value1"),
     *                  new Criterion("innerField2", OperatorId.ICONTAINS, "value2")
     *          })
     *      });
     *  </pre>
     *  To create a form capable of editing the above criteria without providing a custom
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter FormItemCriterionGetter} et al, you would create a
     * form with 2 items.
     *  The 'field1' criterion could be edited by a simple form item such as a TextItem.
     *  The nested criteria ('innerField1' and 'innerField2') could be edited by a canvasItem
     *  whose canvas property was set to a DynamicForm showing items capable of editing the 2
     *  inner criteria, and whose operator was specified as "or".<br>
     *  For example:
     *  <pre>
     *      DynamicForm form = new DynamicForm();
     *
     *      DynamicForm innerForm = new DynamicForm();
     *      innerForm.setOperator(OperatorId.OR);
     *      TextItem innerField1 = new TextItem();
     *      innerField1.setOperator(OperatorId.EQUALS);
     *      TextItem innerField2 = new TextItem();
     *      innerForm.setFields(innerField1, innerField2);
     *
     *      TextItem field1 = new TextItem();
     *      CanvasItem nestedItem = new CanvasItem();
     *      nestedItem.setShouldSaveValue(true);
     *      nestedItem.setCanvas(innerForm);
     *
     *      form.setFields(field1, nestedItem);
     *   </pre>
     *  This form would be able to edit the above advanced criteria object via
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria}. Edited values
     * would be retrieved via
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}.
     *  <P>
     *  Note that the canvas item has <code>shouldSaveValue</code> set to true - this is required
     *  to ensure the nested form is actually passed the values to edit.
     *  <P>
     *  The default implementation of this method checks for this.canvas being specified as a
     *  dynamicForm, and in that case simply returns the result of
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsAdvancedCriteria DynamicForm.getValuesAsAdvancedCriteria}
     * on the inner form.
     *  <P>
     *  Note that this functionality may be entirely bypassed by
     * setting {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getEditCriteriaInInnerForm editCriteriaInInnerForm} to
     * false. This flag is useful when defining a
     *  dynamicForm based canvasItem which is not intended for editing nested data -- for example
     *  if a standard atomic field value is being displayed in some custom way using a
     *  DynamicForm embedded in the item.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCriterionGetter(FormItemCriterionGetter getter) {
        super.setCriterionGetter(getter);
    }

    /**
     * Provide a <code>setCriterion()</code> implementation to display a {@link com.smartgwt.client.data.Criterion} object in this item for editing.
     * The default implementation is overridden from  {@link com.smartgwt.client.widgets.form.fields.FormItem#setCriterionSetter FormItem.setCriterionSetter}
     * in order to support editing nested criteria using nested dynamicForms as described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#setCriterionGetter CanvasItem.setCriterionGetter}.
     * <P> Implementation checks for this.canvas being specified as a DynamicForm, and applies criterion directly to the
     * embedded form via setValuesAsCriteria().
     * @param setter provides a method to update this field with the edited criterion
     */
    public void setCriterionSetter(FormItemCriterionSetter setter) {
        super.setCriterionSetter(setter);
    }

}
