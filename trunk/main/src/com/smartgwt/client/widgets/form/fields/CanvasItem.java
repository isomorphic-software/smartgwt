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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Form item which renders a Canvas inline in a DynamicForm instance.
 */
public class CanvasItem extends FormItem {

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
        setType("CanvasItem");
    }

    public CanvasItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CanvasItem(String name) {
        setName(name);
        setType("CanvasItem");
    }

    public CanvasItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("CanvasItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String.  If none is passed, one will be  auto-created using the overrideable defaults: {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties} and {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasConstructor canvasConstructor}
     *
     * @param canvas canvas Default value is null
     */
    public void setCanvas(Canvas canvas) {
        setAttribute("canvas", canvas.getOrCreateJsObj());
    }

    /**
     * The canvas that will be displayed inside this item.  You can pass an instance you've  already created, or its global ID
     * as a String.  If none is passed, one will be  auto-created using the overrideable defaults: {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasProperties canvasProperties} and {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvasConstructor canvasConstructor}
     *
     *
     * @return Canvas
     */
    public Canvas getCanvas()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("canvas"));
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
     * DynamicForm.getValuesAsAdvancedCriteria} on the inner form.&#010 &#010
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

    // ********************* Static Methods ***********************

}



