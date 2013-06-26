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
 
package com.smartgwt.client.widgets.form.fields;


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
 * FormItem which renders a Canvas inline in a DynamicForm instance. <P> CanvasItem is {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue}:false by default, meaning that no
 * value from the CanvasItem will be present in  values and no value will be saved when {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called.  This is appropriate if your
 * Canvas does not participate in displaying or editing the values of the form and is embedded in the form for layout
 * purposes only. <P> If you set {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue
 * shouldSaveValue}:true, {@link com.smartgwt.client.widgets.form.fields.CanvasItem#addShowValueHandler
 * CanvasItem.showValue} will be called to provide a value that your item should display.  Implement
 * <code>showValue()</code> and call methods on the Canvas you've created to cause the value to be displayed. <P>
 * <code>showValue()</code> will be called in various situations where the form receives data, including a call to {@link
 * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues}, {@link
 * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord}, or if {@link
 * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData} is called and a Record is returned.  Bear
 * in mind that <code>showValue()</code> can be called when the form and your item have not yet been drawn; in this case,
 * store the value for later display. <P> To provide a value to the form, call {@link
 * com.smartgwt.client.widgets.form.fields.CanvasItem#storeValue CanvasItem.storeValue} whenever the user changes the value
 * in your Canvas.  Note that the form <b>will not</b> call <code>canvasItem.getValue()</code> in order to discover your
 * item's value, so there is no purpose in overriding this method - use <code>storeValue</code> to proactively inform the
 * form about changes instead.  This approach is necessary in order to enable change events. <P> If you cannot easily
 * detect changes to values in your Canvas, a workaround is to call <code>storeValue</code> right before the form saves.
 */
public class CanvasItem extends FormItem  implements com.smartgwt.client.widgets.form.fields.events.HasCanEditChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasShowValueHandlers {

    public static CanvasItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("CanvasItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CanvasItem) obj;
        } else {
            return new CanvasItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
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
        $wnd.isc["CanvasItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["CanvasItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public CanvasItem(){
        setAttribute("editorType", "CanvasItem");
					setupCanvasConstructor();
    }

    public CanvasItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
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
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt prompt} is specified for this item, should the
     * prompt be applied to the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} for this item?
     *
     * @param applyPromptToCanvas applyPromptToCanvas Default value is true
     */
    public void setApplyPromptToCanvas(Boolean applyPromptToCanvas) {
        setAttribute("applyPromptToCanvas", applyPromptToCanvas);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt prompt} is specified for this item, should the
     * prompt be applied to the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} for this item?
     *
     * @return Boolean
     */
    public Boolean getApplyPromptToCanvas()  {
        return getAttributeAsBoolean("applyPromptToCanvas");
    }


    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} be automatically
     * destroyed when the item  is destroyed? Form items are destroyed automatically when a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setItems DynamicForm.setItems} removes them from their parent form, or if
     * their parent form is destroyed. This property governs whether, when this occurs,  the item's canvas should also be
     * {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}. <P> Setting this property to true is typically appropriate
     * for cases where a custom CanvasItem automatically creates its canvas as part of its initialization flow. Note that once
     * a canvas has been destroyed it can not be re-used elsewhere within an application.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoDestroy autoDestroy Default value is false
     */
    public void setAutoDestroy(Boolean autoDestroy) {
        setAttribute("autoDestroy", autoDestroy);
    }

    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} be automatically
     * destroyed when the item  is destroyed? Form items are destroyed automatically when a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setItems DynamicForm.setItems} removes them from their parent form, or if
     * their parent form is destroyed. This property governs whether, when this occurs,  the item's canvas should also be
     * {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}. <P> Setting this property to true is typically appropriate
     * for cases where a custom CanvasItem automatically creates its canvas as part of its initialization flow. Note that once
     * a canvas has been destroyed it can not be re-used elsewhere within an application.
     *
     * @return Boolean
     */
    public Boolean getAutoDestroy()  {
        return getAttributeAsBoolean("autoDestroy");
    }


    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String. You can also implement  {@link com.smartgwt.client.widgets.form.fields.CanvasItem#createCanvas
     * CanvasItem.createCanvas} to dynamically create the canvas when the FormItem is initialized. <P> If <code>canvas</code>
     * and <code>createCanvas()</code> are unspecified, the  canvas for this item will be auto-created using the overrideable
     * defaults: {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties} and {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasConstructor canvasConstructor} <P> Note that {@link
     * com.smartgwt.client.widgets.Canvas#getCanvasItem canvasItem} will be set on the canvas to point back to this item.
     *
     * @param canvas canvas Default value is null
     */
    public void setCanvas(Canvas canvas) {
        setAttribute("canvas", canvas == null ? null : canvas.getOrCreateJsObj());
    }

    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String. You can also implement  {@link com.smartgwt.client.widgets.form.fields.CanvasItem#createCanvas
     * CanvasItem.createCanvas} to dynamically create the canvas when the FormItem is initialized. <P> If <code>canvas</code>
     * and <code>createCanvas()</code> are unspecified, the  canvas for this item will be auto-created using the overrideable
     * defaults: {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties} and {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasConstructor canvasConstructor} <P> Note that {@link
     * com.smartgwt.client.widgets.Canvas#getCanvasItem canvasItem} will be set on the canvas to point back to this item.
     *
     * @return Canvas
     */
    public Canvas getCanvas()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("canvas"));
    }





    /**
     * Flag to disable the criteria editing overrides described in  <code>setCriterionGetter()</code> whereby if this item
     * contains a DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is
     * required for cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of
     * nested objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editCriteriaInInnerForm editCriteriaInInnerForm Default value is true
     */
    public void setEditCriteriaInInnerForm(Boolean editCriteriaInInnerForm) {
        setAttribute("editCriteriaInInnerForm", editCriteriaInInnerForm);
    }

    /**
     * Flag to disable the criteria editing overrides described in  <code>setCriterionGetter()</code> whereby if this item
     * contains a DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is
     * required for cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of
     * nested objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     *
     * @return Boolean
     */
    public Boolean getEditCriteriaInInnerForm()  {
        return getAttributeAsBoolean("editCriteriaInInnerForm");
    }


    /**
     * Whether this CanvasItem is intended to hold multiple values.  <P> This attribute can affect the return type of
     * getValue(). If this CanvasItem is storing multiple values, then the return type of getValue() is
     * <code>JavaScriptObject</code> (a JavaScript array object) if multiple is null or false. However, if multiple is true,
     * then the return type is either <code>List</code> or <code>RecordList</code>.
     *
     * @param multiple multiple Default value is null
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * Whether this CanvasItem is intended to hold multiple values.  <P> This attribute can affect the return type of
     * getValue(). If this CanvasItem is storing multiple values, then the return type of getValue() is
     * <code>JavaScriptObject</code> (a JavaScript array object) if multiple is null or false. However, if multiple is true,
     * then the return type is either <code>List</code> or <code>RecordList</code>.
     *
     * @return Boolean
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }


    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     * @param overflow overflow Default value is null
     */
    public void setOverflow(Overflow overflow) {
        setAttribute("overflow", overflow == null ? null : overflow.getValue());
    }

    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     * @return Overflow
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }


    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt prompt} for this item. Default implementation will also apply the prompt to {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} if {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getApplyPromptToCanvas applyPromptToCanvas} is true.
     *
     * @param prompt new prompt for the item.. See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }


    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <P> See the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem} class overview for a discussion of values-handling in  CanvasItems
     *
     * @param shouldSaveValue shouldSaveValue Default value is false
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <P> See the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem} class overview for a discussion of values-handling in  CanvasItems
     *
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    // ********************* Methods ***********************
    /**
     * Add a canEditChanged handler.
     * <p>
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is modified.
     * Developers may make use of this to toggle between an editable and a read-only appearance for custom FormItems.
     *
     * @param handler the canEditChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCanEditChangedHandler(com.smartgwt.client.widgets.form.fields.events.CanEditChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent.getType()) == 0) setupCanEditChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent.getType());
    }

    private native void setupCanEditChangedEvent() /*-{
        var obj = null;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var canEditChanged = $entry(function(){
            var param = {"canEdit" : arguments[0]};
            var event = @com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        obj.canEditChanged =  canEditChanged 
        ;
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
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay
     * readOnlyDisplay} is modified. Developers may make use of this to alter the read-only appearance of custom FormItems.
     * @param readOnlyDisplay New readOnlyDisplay value
     */
    public native void readOnlyDisplayChanged(ReadOnlyDisplayAppearance readOnlyDisplay) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.readOnlyDisplayChanged(readOnlyDisplay.@com.smartgwt.client.types.ReadOnlyDisplayAppearance::getValue()());
    }-*/;
    /**
     * Add a showValue handler.
     * <p>
     * This method will be called whenever this form item's value is being set via a programmatic call to e.g: {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue} and may be overridden by CanvasItems
     * intended to support displaying data values to update the embedded Canvas to reflect the value passed in.
     *
     * @param handler the showValue handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addShowValueHandler(com.smartgwt.client.widgets.form.fields.events.ShowValueHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ShowValueEvent.getType()) == 0) setupShowValueEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ShowValueEvent.getType());
    }

    private native void setupShowValueEvent() /*-{
        var obj = null;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var showValue = $entry(function(){
            var param = {"displayValue" : arguments[0], "dataValue" : arguments[1], "form" : arguments[2], "item" : arguments[3]};
            var event = @com.smartgwt.client.widgets.form.fields.events.ShowValueEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        obj.showValue =  showValue 
        ;
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
     * @param canvasItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(CanvasItem canvasItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},canvasItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
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
    	return Canvas.getOrCreateRef(jsCanvas);
    }


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
            doStoreValue((Date) value);
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
     *  { _constructor:"AdvancedCriteria",
     *    operator:"and",
     *    criteria:[
     *       {fieldName:"field1", value:"value1", operator:"iContains"},
     *       {operator:"or", criteria:[
     *           {fieldName:"innerField1", value:"value1", operator:"equals"},
     *           {fieldName:"innerField2", value:"value2", operator:"iContains"}
     *        ]
     *       }
     *    ]
     *  }
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
     *   isc.DynamicForm.create({
     *       items:[
     *           {name:"field1", type:"TextItem"},
     *           {name:"nestedItem", shouldSaveValue:true, type:"CanvasItem",
     *               canvas:isc.DynamicForm.create({
     *                   operator:"or",
     *                   items:[
     *                       {name:"innerField1", type:"TextItem", operator:"equals"},
     *                       {name:"innerField2", type:"TextItem"}
     *                   ]
     *               })
     *           }
     *       ]
     *   });
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


