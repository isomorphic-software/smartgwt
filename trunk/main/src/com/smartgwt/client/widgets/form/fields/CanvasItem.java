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
public class CanvasItem extends FormItem  implements com.smartgwt.client.widgets.form.fields.events.HasShowValueHandlers {

    public static CanvasItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CanvasItem) obj;
        } else {
            return new CanvasItem(jsObj);
        }
    }

    public CanvasItem(){
        setAttribute("editorType", "CanvasItem"); setupCanvasConstructor();
    }

    public CanvasItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CanvasItem(String name) {
        setName(name);
        setAttribute("editorType", "CanvasItem"); setupCanvasConstructor();
    }

    public CanvasItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "CanvasItem"); setupCanvasConstructor();
    }

    // ********************* Properties / Attributes ***********************

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
     *
     * @return Canvas
     */
    public Canvas getCanvas()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("canvas"));
    }

    /**
     * Flag to disable the criteria editing overrides described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion CanvasItem.getCriterion} whereby if this item contains a
     * DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is required for
     * cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of nested
     * objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editCriteriaInInnerForm editCriteriaInInnerForm Default value is true
     */
    public void setEditCriteriaInInnerForm(Boolean editCriteriaInInnerForm) {
        setAttribute("editCriteriaInInnerForm", editCriteriaInInnerForm);
    }

    /**
     * Flag to disable the criteria editing overrides described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion CanvasItem.getCriterion} whereby if this item contains a
     * DynamicForm as its canvas, it will be used to edit nested AdvancedCriteria automatically. <P> This flag is required for
     * cases where a canvasItem contains a DynamicForm, but the form is not set up to show inner field values of nested
     * objects, and therefore should not attempt to apply nested advanced criteria directly to the form.
     *
     *
     * @return Boolean
     */
    public Boolean getEditCriteriaInInnerForm()  {
        return getAttributeAsBoolean("editCriteriaInInnerForm");
    }

    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     * @param overflow overflow Default value is null
     */
    public void setOverflow(Overflow overflow) {
        setAttribute("overflow", overflow.getValue());
    }

    /**
     * CanvasItems support specifying overflow for the Canvas directly on the item.
     *
     *
     * @return Overflow
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
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
     *
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    // ********************* Methods ***********************
            
    /**
     * AdvancedCriteria objects may be edited via nested dynamicForms as described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion CanvasItem.getCriterion} <P> This method has been
     * overridden to return true if this item's canvas is a DynamicForm, where the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOperator operator} matches the operator of the criterion passed in and
     * dynamicForm contains items where {@link com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion
     * FormItem.canEditCriterion} returns true for each sub-criterion in the object passed in.
     * @param criterion criteria to test
     *
     * @return returns true if the specified criterion may be edited by this item
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean canEditCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.canEditCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * The standard formItem criteria editing APIs have been overridden in the canvasItem class&#010 to simplify the editing of
     * complex {@link com.smartgwt.client.data.AdvancedCriteria} objects using nested &#010 DynamicForms.&#010 <P>&#010 The
     * following pattern is supported without need for further modification:<br>&#010 A complex Advanced criteria object may
     * have nested sub criteria using the <code>"and"</code>&#010 or <code>"or"</code> operators. For example:&#010 <pre>&#010
     * { _constructor:"AdvancedCriteria",&#010   operator:"and",&#010   criteria:[&#010      {fieldName:"field1",
     * value:"value1", operator:"iContains"},&#010      {operator:"or", criteria:[&#010          {fieldName:"innerField1",
     * value:"value1", operator:"equals"},&#010          {fieldName:"innerField2", value:"value2", operator:"iContains"}&#010  
     * ]&#010      }&#010   ]&#010 }&#010 </pre>&#010 To create a form capable of editing the above criteria without providing
     * custom overrides&#010 to {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriterion FormItem.getCriterion} et
     * al, you would create a form with 2 items.&#010 The 'field1' criterion could be edited by a simple form item such as a
     * TextItem.&#010 The nested criteria ('innerField1' and 'innerField2') could be edited by a canvasItem&#010 whose canvas
     * property was set to a DynamicForm showing items capable of editing the 2&#010 inner criteria, and whose operator was
     * specified as "or".<br>&#010 For example:&#010 <pre>&#010  isc.DynamicForm.create({&#010      items:[&#010         
     * {name:"field1", type:"TextItem"},&#010          {name:"nestedItem", shouldSaveValue:true, type:"CanvasItem",&#010       
     * canvas:isc.DynamicForm.create({&#010                  operator:"or",&#010                  items:[&#010                 
     * {name:"innerField1", type:"TextItem", operator:"equals"},&#010                      {name:"innerField2",
     * type:"TextItem"}&#010                  ]&#010              })&#010          }&#010      ]&#010  });&#010  </pre>&#010
     * This form would be able to edit the above advanced criteria object via&#010 {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria}. Edited values would
     * be retrieved via&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria}.&#010 <P>&#010 Note that the canvas item has <code>shouldSaveValue</code> set to true -
     * this is required&#010 to ensure the nested form is actually passed the values to edit. &#010 <P>&#010 The default
     * implementation of this method checks for this.canvas being specified as a&#010 dynamicForm, and in that case simply
     * returns the result of &#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsAdvancedCriteria
     * DynamicForm.getValuesAsAdvancedCriteria} on the inner form.&#010 <P>&#010 Note that this functionality may be entirely
     * bypassed by&#010 setting {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getEditCriteriaInInnerForm
     * editCriteriaInInnerForm} to false. This flag is useful when defining a&#010 dynamicForm based canvasItem which is not
     * intended for editing nested data -- for example&#010 if a standard atomic field value is being displayed in some custom
     * way using a&#010 DynamicForm embedded in the item.&#010 &#010
     *
     * @return criterion to merge with advanced criteria returned by   {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Criterion getCriterion() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Overridden to return true if {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas} is a
     * dynamicForm. See {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion CanvasItem.getCriterion} for
     * details of editing advanced criteria using nested dynamicForms.
     *
     * @return true if this item's canvas is a DynamicForm
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.hasAdvancedCriteria();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Display a {@link com.smartgwt.client.data.Criterion} object in this item for editing. Overridden from  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCriterion FormItem.setCriterion} in order to support editing nested
     * criteria using  nested dynamicForms as described in {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCriterion CanvasItem.getCriterion}. <P> Implementation checks for
     * this.canvas being specified as a DynamicForm, and applies criterion directly to the embedded form via
     * setValuesAsCriteria()
     * @param criterion criteria to edit
     */
    public native void setCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
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
            obj.showValue = $entry(function(){
                var param = {"displayValue" : arguments[0], "dataValue" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.ShowValueEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    protected native void setupCanvasConstructor() /*-{
	    var self = this.@com.smartgwt.client.widgets.form.fields.CanvasItem::getJsObj()();

        if(self == null) return null;
	    self.createCanvas = $debox($entry(function() {
	        var jObj = this.__ref;
            //in cases where a SGWT FormItem instance is used for a setEditorType(..) call, there will
            //not be a SGWT object ref associated with the JS object. In this case, simply return
            if(jObj == null) return null;
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
    public native void storeValue(Object value) /*-{
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
    public native void storeValue(RecordList value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (value != null) {
            value = value.@com.smartgwt.client.data.RecordList::getJsObj()();
        }
        self.storeValue(value);
    }-*/;

}



