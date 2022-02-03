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
 
package com.smartgwt.client.widgets.form;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * The ValuesManager manages data from multiple member forms. <P> If a single logical form needs to be separated into
 * multiple DynamicForm instances for Layout purposes (for example, spanning one logical form across multiple Tabs), a
 * ValuesManager can be used to make the forms act as one logical form, supporting all value-related APIs otherwise called
 * on DynamicForm directly. <P> A ValuesManager has no visual representation - it is strictly a logical entity, and the
 * member forms provide the user interface.  You can initialize a ValuesManager with a set of member forms (by setting
 * {@link com.smartgwt.client.widgets.form.ValuesManager#getMembers members} at init) or add and remove member forms
 * dynamically. <P> Calling {@link com.smartgwt.client.widgets.form.ValuesManager#setValues setValues()} on a ValuesManager
 * will automatically route new field values to whichever member form is showing an editor for that field.  Likewise,
 * calling {@link com.smartgwt.client.widgets.form.ValuesManager#validate validate()} will validate all member forms, and
 * {@link com.smartgwt.client.widgets.form.ValuesManager#saveData saveData()} will initiate a save operation which
 * aggregates values from all member forms. <P> Like a DynamicForm, a ValuesManager can be databound by setting {@link
 * com.smartgwt.client.widgets.form.ValuesManager#getDataSource dataSource}.  In this case all member forms must also be
 * bound to the same DataSource. <P> In general, when working with a ValuesManager and its member forms, call APIs on the
 * ValuesManager whenever you are dealing with values that span multiple forms, and only call APIs on member forms that are
 * specific to that form or its fields. <P> Note that, just as a DynamicForm can track values that are not shown in any
 * FormItem, a ValuesManager may track values for which there is no FormItem in any member form.  However, when using a
 * ValuesManager these extra values are only allowed on the ValuesManager itself. Member forms will not track values for
 * which they do not have FormItems.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ValuesManager")
public class ValuesManager extends BaseClass implements com.smartgwt.client.form.events.HasAsyncValidationReplyHandlers, com.smartgwt.client.widgets.form.events.HasHiddenValidationErrorsHandlers, com.smartgwt.client.form.events.HasMemberSynchronizedHandlers {

    public static ValuesManager getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ValuesManager) obj;
        } else {
            return new ValuesManager(jsObj);
        }
    }
    /** 
     * This method returns a Map of config properties suitable for use as the "defaults" 
     * attribute of a {@link com.smartgwt.client.tools.PaletteNode}.  Use it when you need to
     * work with PaletteNodes indirectly, such when setting up 
     * {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be used in a 
     * {@link com.smartgwt.client.tools.TilePalette}.  See 
     * {@link com.smartgwt.client.docs.DevTools the dev tools overview} for examples of how to
     * assemble and acquire a suitable defaults object when you are creating a PaletteNode 
     * indirectly
     */
    public Map getPaletteDefaults() {
        if (isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "getPaletteDefaults", (String)null);
        }
        return JSOHelper.convertToMap(JSOHelper.cleanProperties(getConfig(), true));
    }
        


    public ValuesManager(){
        scClassName = "ValuesManager";
    }

    public ValuesManager(JavaScriptObject jsObj){
        scClassName = "ValuesManager";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing add operations.
     *
     * @param addOperation New addOperation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public ValuesManager setAddOperation(String addOperation) {
        return (ValuesManager)setAttribute("addOperation", addOperation, true);
    }

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing add operations.
     *
     * @return Current addOperation value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public String getAddOperation()  {
        return getAttributeAsString("addOperation");
    }
    

    /**
     * If explicitly set to false, prevents the ValuesManager from automatically propagating data value changes to its members.
     * You can manually synchronize member data values  at any time with a call to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembers synchronizeMembers()}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoSynchronize New autoSynchronize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     */
    public ValuesManager setAutoSynchronize(Boolean autoSynchronize) {
        return (ValuesManager)setAttribute("autoSynchronize", autoSynchronize, true);
    }

    /**
     * If explicitly set to false, prevents the ValuesManager from automatically propagating data value changes to its members.
     * You can manually synchronize member data values  at any time with a call to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembers synchronizeMembers()}.
     *
     * @return Current autoSynchronize value. Default value is null
     */
    public Boolean getAutoSynchronize()  {
        return getAttributeAsBoolean("autoSynchronize");
    }
    
    

    /**
     * When editing values in this ValuesManager in one or more DataBoundComponents, should we perform a deep clone of values
     * that are not associated with a field (ie, attributes on the record that do not map to a component field either directly
     * by name, or by {@link com.smartgwt.client.widgets.form.fields.FormItem#getDataPath FormItem.dataPath}.  If this value is
     * not explicitly set, it defaults to the value of  {@link
     * com.smartgwt.client.data.DataSource#getDeepCloneNonFieldValuesOnEdit DataSource.deepCloneNonFieldValuesOnEdit} if there
     * is a dataSource, or to the value  of the static {@link com.smartgwt.client.data.DataSource#deepCloneNonFieldValuesOnEdit
     * deepCloneNonFieldValuesOnEdit} if there is no dataSource. <p> Like the other <code>deepCloneOnEdit</code> settings, this
     * flag only has an effect if you are  editing a values object that contains nested objects or arrays.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param deepCloneNonFieldValuesOnEdit New deepCloneNonFieldValuesOnEdit value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDataPath
     * @see com.smartgwt.client.data.DataSourceField#setDeepCloneOnEdit
     * @see com.smartgwt.client.data.DataSource#setDeepCloneOnEdit
     */
    public ValuesManager setDeepCloneNonFieldValuesOnEdit(Boolean deepCloneNonFieldValuesOnEdit) {
        return (ValuesManager)setAttribute("deepCloneNonFieldValuesOnEdit", deepCloneNonFieldValuesOnEdit, true);
    }

    /**
     * When editing values in this ValuesManager in one or more DataBoundComponents, should we perform a deep clone of values
     * that are not associated with a field (ie, attributes on the record that do not map to a component field either directly
     * by name, or by {@link com.smartgwt.client.widgets.form.fields.FormItem#getDataPath FormItem.dataPath}.  If this value is
     * not explicitly set, it defaults to the value of  {@link
     * com.smartgwt.client.data.DataSource#getDeepCloneNonFieldValuesOnEdit DataSource.deepCloneNonFieldValuesOnEdit} if there
     * is a dataSource, or to the value  of the static {@link com.smartgwt.client.data.DataSource#deepCloneNonFieldValuesOnEdit
     * deepCloneNonFieldValuesOnEdit} if there is no dataSource. <p> Like the other <code>deepCloneOnEdit</code> settings, this
     * flag only has an effect if you are  editing a values object that contains nested objects or arrays.
     *
     * @return Current deepCloneNonFieldValuesOnEdit value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDataPath
     * @see com.smartgwt.client.data.DataSourceField#getDeepCloneOnEdit
     * @see com.smartgwt.client.data.DataSource#getDeepCloneOnEdit
     */
    public Boolean getDeepCloneNonFieldValuesOnEdit()  {
        return getAttributeAsBoolean("deepCloneNonFieldValuesOnEdit");
    }
    

    /**
     * Before we start editing the values of this ValuesManager in one or more DataBoundComponents,  should we perform a deep
     * clone of the underlying values.  See  {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit
     * DataSource.deepCloneOnEdit} for details of what this means. <p> If this value is not explicitly set, it defaults to the
     * value of {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit}. This value can be
     * overridden per-field with {@link com.smartgwt.client.data.DataSourceField#getDeepCloneOnEdit
     * DataSourceField.deepCloneOnEdit}. <p> Like the other <code>deepCloneOnEdit</code> settings, this flag only has an effect
     * if you are  editing a values object that contains nested objects or arrays, using  {@link
     * com.smartgwt.client.widgets.Canvas#getDataPath dataPath}s.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param deepCloneOnEdit New deepCloneOnEdit value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDataPath
     * @see com.smartgwt.client.data.DataSourceField#setDeepCloneOnEdit
     * @see com.smartgwt.client.data.DataSource#setDeepCloneOnEdit
     */
    public ValuesManager setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        return (ValuesManager)setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    /**
     * Before we start editing the values of this ValuesManager in one or more DataBoundComponents,  should we perform a deep
     * clone of the underlying values.  See  {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit
     * DataSource.deepCloneOnEdit} for details of what this means. <p> If this value is not explicitly set, it defaults to the
     * value of {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit}. This value can be
     * overridden per-field with {@link com.smartgwt.client.data.DataSourceField#getDeepCloneOnEdit
     * DataSourceField.deepCloneOnEdit}. <p> Like the other <code>deepCloneOnEdit</code> settings, this flag only has an effect
     * if you are  editing a values object that contains nested objects or arrays, using  {@link
     * com.smartgwt.client.widgets.Canvas#getDataPath dataPath}s.
     *
     * @return Current deepCloneOnEdit value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDataPath
     * @see com.smartgwt.client.data.DataSourceField#getDeepCloneOnEdit
     * @see com.smartgwt.client.data.DataSource#getDeepCloneOnEdit
     */
    public Boolean getDeepCloneOnEdit()  {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }
    

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disableValidation New disableValidation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public ValuesManager setDisableValidation(Boolean disableValidation) {
        return (ValuesManager)setAttribute("disableValidation", disableValidation, true);
    }

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     * @return Current disableValidation value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.widgets.form.DynamicForm#submit
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getDisableValidation()  {
        return getAttributeAsBoolean("disableValidation");
    }
    

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing fetch operations.
     *
     * @param fetchOperation New fetchOperation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public ValuesManager setFetchOperation(String fetchOperation) {
        return (ValuesManager)setAttribute("fetchOperation", fetchOperation, true);
    }

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing fetch operations.
     *
     * @return Current fetchOperation value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public String getFetchOperation()  {
        return getAttributeAsString("fetchOperation");
    }
    
    

    /**
     * What operator should be used to combine sub-criteria from member forms when {@link
     * com.smartgwt.client.widgets.form.ValuesManager#getValuesAsCriteria getValuesAsCriteria()} is called?
     *
     * @param operator New operator value. Default value is "and"
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public ValuesManager setOperator(OperatorId operator)  throws IllegalStateException {
        return (ValuesManager)setAttribute("operator", operator == null ? null : operator.getValue(), false);
    }

    /**
     * What operator should be used to combine sub-criteria from member forms when {@link
     * com.smartgwt.client.widgets.form.ValuesManager#getValuesAsCriteria getValuesAsCriteria()} is called?
     *
     * @return Current operator value. Default value is "and"
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }
    

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing remove operations.
     *
     * @param removeOperation New removeOperation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public ValuesManager setRemoveOperation(String removeOperation) {
        return (ValuesManager)setAttribute("removeOperation", removeOperation, true);
    }

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing remove operations.
     *
     * @return Current removeOperation value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public String getRemoveOperation()  {
        return getAttributeAsString("removeOperation");
    }
    

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. This property is automatically
     * set on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord()}, or may be set directly via 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType()}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the default {@link com.smartgwt.client.types.DSOperationType} when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. Note that this property can also be set by calling {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} or  {@link com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord()}
     *
     * @param saveOperationType Operation type to use as a default. Valid values are  <code>"add"</code> or <code>"update"</code>. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     */
    public ValuesManager setSaveOperationType(DSOperationType saveOperationType) {
        return (ValuesManager)setAttribute("saveOperationType", saveOperationType == null ? null : saveOperationType.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. This property is automatically
     * set on a call to {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord()}, or may be set directly via 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType()}. <P> If
     * <code>saveOperationType</code> is unset, the form will heuristically determine whether an "add" or "update" operation is
     * intended based on whether the primaryKey field is present and editable.
     *
     * @return Returns the {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called. Valid options are
     * <code>"add"</code> or <code>"update"</code>. <P> If a {@link com.smartgwt.client.data.DSRequest} configuration object is
     * passed in containing an explicit operationType this will be returned. Otherwise {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType DynamicForm.saveOperationType} will be returned. This
     * attribute is automatically set via calls to data binding methods such as {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord DynamicForm.editNewRecord()}, or it may be set explicitly.
     * <P> If no explicit saveOperationType is specified for this form, the system will  look at the current values for the
     * form. If the form has no value for the {@link com.smartgwt.client.data.DataSource#getPrimaryKeyField primaryKey field},
     * or that field is editable and has been modified we assume an add operation, otherwise an update. If the form is a member
     * of a {@link com.smartgwt.client.widgets.form.ValuesManager}, the primary key field value will be derived from the
     * valuesManager's values object. Default value is null
     */
    public DSOperationType getSaveOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("saveOperationType"));
    }
    

    /**
     * When calling {@link com.smartgwt.client.widgets.form.ValuesManager#saveData saveData()} on a form or valuesManager, by
     * default if the server returns an error code, any callback passed into saveData() will not be fired. If the error code
     * returned by the server indicates a validation error, it will be displayed to the user by updating the form items to show
     * the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard RPCManager error
     * handling logic would be invoked. <P> Developers who want to handle errors themselves can override this default by
     * specifying {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError dsRequest.willHandleError} on the DSRequest. In
     * this case the callback passed in  will be fired even if the server returns an error status code. <P> If
     * <code>suppressValidationErrorCallback</code> is set to true, if a save attempt returns a <i>validation</i> error code,
     * the user-specified callback will not be fired <i>even if <code>willHandleError:true</code> was specified on the
     * dsRequest</i>  - though for other error codes, the callback would be fired if willHandleError is  specified on the
     * request. Note that this is the historical behavior for  SmartGWT builds 4.0 and earlier
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressValidationErrorCallback New suppressValidationErrorCallback value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     */
    public ValuesManager setSuppressValidationErrorCallback(Boolean suppressValidationErrorCallback) {
        return (ValuesManager)setAttribute("suppressValidationErrorCallback", suppressValidationErrorCallback, true);
    }

    /**
     * When calling {@link com.smartgwt.client.widgets.form.ValuesManager#saveData saveData()} on a form or valuesManager, by
     * default if the server returns an error code, any callback passed into saveData() will not be fired. If the error code
     * returned by the server indicates a validation error, it will be displayed to the user by updating the form items to show
     * the error messages, and firing any specified hiddenValidationErrors handler, otherwise the standard RPCManager error
     * handling logic would be invoked. <P> Developers who want to handle errors themselves can override this default by
     * specifying {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError dsRequest.willHandleError} on the DSRequest. In
     * this case the callback passed in  will be fired even if the server returns an error status code. <P> If
     * <code>suppressValidationErrorCallback</code> is set to true, if a save attempt returns a <i>validation</i> error code,
     * the user-specified callback will not be fired <i>even if <code>willHandleError:true</code> was specified on the
     * dsRequest</i>  - though for other error codes, the callback would be fired if willHandleError is  specified on the
     * request. Note that this is the historical behavior for  SmartGWT builds 4.0 and earlier
     *
     * @return Current suppressValidationErrorCallback value. Default value is false
     */
    public Boolean getSuppressValidationErrorCallback()  {
        Boolean result = getAttributeAsBoolean("suppressValidationErrorCallback");
        return result == null ? false : result;
    }
    

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing update operations.
     *
     * @param updateOperation New updateOperation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.ValuesManager ValuesManager} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public ValuesManager setUpdateOperation(String updateOperation) {
        return (ValuesManager)setAttribute("updateOperation", updateOperation, true);
    }

    /**
     * {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} to use when performing update operations.
     *
     * @return Current updateOperation value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public String getUpdateOperation()  {
        return getAttributeAsString("updateOperation");
    }
    

    // ********************* Methods ***********************
	/**
     * Add a new member to this valuesManager.  Any {@link com.smartgwt.client.widgets.Canvas} can be a member of a
     * valuesManager, even components like {@link com.smartgwt.client.widgets.layout.Layout} or {@link
     * com.smartgwt.client.widgets.tab.TabSet} that do not actually have any values to manage.  When "valueless" components
     * like these bind to a ValuesManager, it is in order to provide their own child components with a shared valuesManager so
     * that complex data can be displayed and edited - see  {@link com.smartgwt.client.docs.DataPath} for more details. <p> For
     * components like {@link com.smartgwt.client.widgets.form.DynamicForm} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, which do have  a set of values to manage, the component's values will
     * subsequently be available through this valuesManager. <p> Note on pre-existent values when the member component is a
     * {@link com.smartgwt.client.widgets.form.DynamicForm}:<br> If the valuesManager has a value specified for some field, for
     * which the member form has an item, this value will be applied to the member form.  This is true whether the item has a
     * value or not.<br> However if the member form has a value for some field, and the ValuesManager does not have a specified
     * value for the same field, we allow the valuesManager to pick up the  value from the member form. <p> <b>Caution:</b> If
     * a DynamicForm without a {@link com.smartgwt.client.data.DataSource} is passed to this method, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#setDataSource DataBoundComponent.setDataSource()} will be called on that
     * form, recreating the items from copies of the item configuration stored at the time the form was created. This means
     * that any properties or handlers added to the items after form creation will be lost.  When in doubt, set the DataSource
     * in the form as soon as possible.
     * @param member component (or ID of component) to add to                                           this valuesManager as a member.
     * @see com.smartgwt.client.widgets.form.ValuesManager#addMembers
     */
    public native void addMember(DynamicForm member) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addMember", "DynamicForm");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * 
     *  This method exists for clean integration with existing server frameworks that have a 'cancel'
     *  feature which typically clears session state associated with the form.  When this method is
     *  called, an RPC is sent to the server with a parameter named
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName DynamicForm.cancelParamName} with the value
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue DynamicForm.cancelParamValue}.<p>
     * 
     *  Note that no other form data is sent.  By default the current top-level page is replaced with the
     *  reply.  If you wish to ignore the server reply instead, call this method like this:
     *  <pre>
     *  dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     *  </pre>
     * 
     * @see com.smartgwt.client.widgets.form.DynamicForm#cancelEditing
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     * @deprecated Since Apache Struts will be removed from Smartclient 13.0
     */
    public native void cancel() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancel", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.cancel();
    }-*/;

	/**
     * 
     *  This method exists for clean integration with existing server frameworks that have a 'cancel'
     *  feature which typically clears session state associated with the form.  When this method is
     *  called, an RPC is sent to the server with a parameter named
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName DynamicForm.cancelParamName} with the value
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue DynamicForm.cancelParamValue}.<p>
     * 
     *  Note that no other form data is sent.  By default the current top-level page is replaced with the
     *  reply.  If you wish to ignore the server reply instead, call this method like this:
     *  <pre>
     *  dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     *  </pre>
     * 
     * @param requestProperties additional properties to set on the RPCRequest                                          that will be issued
     * @see com.smartgwt.client.widgets.form.DynamicForm#cancelEditing
     * @see com.smartgwt.client.docs.Submitting Submitting overview and related methods
     * @deprecated Since Apache Struts will be removed from Smartclient 13.0
     */
    public native void cancel(DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancel", "DSRequest");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.cancel(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Performs silent validation of the value manager values, like {@link
     * com.smartgwt.client.widgets.form.ValuesManager#valuesAreValid valuesAreValid()}.  In contrast to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#valuesAreValid valuesAreValid()}, this method allows checking for
     * server-side errors, and finding out what the errors are.   <P> The callback must be passed unless server-side validation
     * is being skipped, and If passed, it always fires, errors or not, firing synchronously if server validation is skipped.
     * @param callback callback to invoke after validation is complete
     *
     * @return null if server-side validation is required, or no errors are present; otherwise, a Map of field names to the associated
     * errors, for those fields that failed validation.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native Map checkForValidationErrors(ValidationStatusCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "checkForValidationErrors", "ValidationStatusCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.checkForValidationErrors(
			$entry( function(errorMap) { 
				if(callback!=null) callback.@com.smartgwt.client.data.ValidationStatusCallback::execute(Ljava/util/Map;)(
					@com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorMap)
				);
			}));
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Performs silent validation of the value manager values, like {@link
     * com.smartgwt.client.widgets.form.ValuesManager#valuesAreValid valuesAreValid()}.  In contrast to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#valuesAreValid valuesAreValid()}, this method allows checking for
     * server-side errors, and finding out what the errors are.   <P> The callback must be passed unless server-side validation
     * is being skipped, and If passed, it always fires, errors or not, firing synchronously if server validation is skipped.
     * @param callback callback to invoke after validation is complete
     * @param skipServerValidation whether to skip doing server-side validation
     *
     * @return null if server-side validation is required, or no errors are present; otherwise, a Map of field names to the associated
     * errors, for those fields that failed validation.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native Map checkForValidationErrors(ValidationStatusCallback callback, boolean skipServerValidation) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "checkForValidationErrors", "ValidationStatusCallback,boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.checkForValidationErrors(
			$entry( function(errorMap) { 
				if(callback!=null) callback.@com.smartgwt.client.data.ValidationStatusCallback::execute(Ljava/util/Map;)(
					@com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorMap)
				);
			}), skipServerValidation);
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Clears all errors from member forms.
     * @param showErrors If true, clear any visible error messages.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearErrors(boolean showErrors) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearErrors", "boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.clearErrors(showErrors);
    }-*/;

	/**
     * Clear all validation errors associated with some field in this form
     * @param fieldName field for which errors should be cleared
     * @param show if true, and the field is present in one of our member forms,                        redraw it to clear any currently
     * visible validation errors
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void clearFieldErrors(String fieldName, boolean show) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearFieldErrors", "String,boolean");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.clearFieldErrors(fieldName, show);
    }-*/;

	/**
     * Clear the value for some field.
     * @param fieldName Which field to set the value for
     */
    public native void clearValue(String fieldName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearValue", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.clearValue(fieldName);
    }-*/;

	/**
     * Clear out all the values managed by this values manager.
     */
    public native void clearValues() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "clearValues", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.clearValues();
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * DynamicForm.setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code>
     * rather than an <code>update</code> operation.
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.editNewRecord();
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * DynamicForm.setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code>
     * rather than an <code>update</code> operation.
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding     values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord(Map initialValues) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "Map");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.editNewRecord(initialValues == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(initialValues));
    }-*/;

	/**
     * Prepare to edit a new record by clearing the current set of values (or replacing them  with initialValues if specified).
     * <br> This method will also call {@link com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType
     * DynamicForm.setSaveOperationType()} to ensure subsequent calls to <code>saveData()</code> will use an <code>add</code>
     * rather than an <code>update</code> operation.
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding     values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editNewRecord(Record initialValues) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editNewRecord", "Record");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.editNewRecord(initialValues.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Edit an existing record.  Updates this editors values to match the values of the record  passed in, via {@link
     * com.smartgwt.client.widgets.form.ValuesManager#setValues setValues()}. <P> This method will also call {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType DynamicForm.setSaveOperationType()} to ensure 
     * subsequent calls to <code>saveData()</code> will use an <code>update</code> rather than an <code>add</code> operation.
     * @param record the record to be edited as a map of field names to their corresponding values
     * @see com.smartgwt.client.widgets.form.DynamicForm#saveData
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void editRecord(Record record) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "editRecord", "Record");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.editRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Retrieve data that matches the provided criteria, and edit the first record returned
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchData() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchData", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * @see ValuesManager#fetchData
     */
    public void fetchData(Criteria criteria){
        fetchData(criteria, null, null);
    }

    /**
     * @see ValuesManager#fetchData
     */
    public void fetchData(Criteria criteria, DSCallback callback){
        fetchData(criteria, callback, null);
    }

	/**
     * Retrieve data that matches the provided criteria, and edit the first record returned
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchData", "Criteria,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Retrieve data that matches the provided criteria, and edit the first record returned.<br> Differs from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData()} in that a case insensitive substring
     * match will be performed against the criteria to retrieve the data.
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void filterData() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "filterData", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    /**
     * @see ValuesManager#filterData
     */
    public void filterData(Criteria criteria){
        filterData(criteria, null, null);
    }

    /**
     * @see ValuesManager#filterData
     */
    public void filterData(Criteria criteria, DSCallback callback){
        filterData(criteria, callback, null);
    }

	/**
     * Retrieve data that matches the provided criteria, and edit the first record returned.<br> Differs from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData DynamicForm.fetchData()} in that a case insensitive substring
     * match will be performed against the criteria to retrieve the data.
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "filterData", "Criteria,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Returns all values within this DynamicForm that have changed since  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues()} last ran. Note that {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues()} runs on dynamicForm
     * initialization, and with every call to {@link com.smartgwt.client.widgets.form.DynamicForm#setValues
     * DynamicForm.setValues()} so this will typically contain all values the user has explicitly edited since then.
     *
     * @return changed values in the form
     * @see com.smartgwt.client.widgets.form.ValuesManager#getOldValues
     */
    public native Map getChangedValues() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChangedValues", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getChangedValues();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the set of errors for this valuesManager. Errors will be returned as an object of the format <br>
     * <code>{field1:errors, field2:errors}</code><br> Where each errors object is either a single error message or an array of
     * error message strings.
     *
     * @return Object containing mapping from field names to error strings. Returns null                  if there are no errors for
     * this valuesManager.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Map getErrors() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getErrors", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getErrors();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Given a fieldName or dataPath, this method will find the member responsible for interacting with that field's value. If
     * no form is found, returns null.
     * @param fieldName fieldName or dataPath to check
     *
     * @return member responsible for displaying this field (may be null).
     */
    public native Canvas getMemberForField(String fieldName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMemberForField", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getMemberForField(fieldName);
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the set of values last stored by {@link com.smartgwt.client.widgets.form.DynamicForm#rememberValues
     * DynamicForm.rememberValues()}. Note that <code>rememberValues()</code> is called automatically by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}, and on form initialization, so this
     * typically contains all values as they were before the user edited them.
     *
     * @return old values in the form
     * @see com.smartgwt.client.widgets.form.ValuesManager#getChangedValues
     */
    public native Map getOldValues() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getOldValues", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getOldValues();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the current set of values for the values manager instance.  This includes the values from any form managed by
     * this manager, as well as any values explicitly applied via {@link
     * com.smartgwt.client.widgets.form.ValuesManager#setValues setValues()}. <P> Note that modifying the returned object is
     * not a supported way of adding or modifying values.  Instead use {@link
     * com.smartgwt.client.widgets.form.ValuesManager#setValue setValue()} or {@link
     * com.smartgwt.client.widgets.form.ValuesManager#setValues setValues()}.
     *
     * @return a map of the values for this manager
     * @see com.smartgwt.client.widgets.form.DynamicForm#getValues
     */
    public native Map getValues() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getValues", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getValues();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an AdvancedCriteria object based on the current set of values within memberForms. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#getValuesAsCriteria getValuesAsCriteria()}, except the returned criteria
     * object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator}
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getValuesAsAdvancedCriteria", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an AdvancedCriteria object based on the current set of values within memberForms. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.ValuesManager#getValuesAsCriteria getValuesAsCriteria()}, except the returned criteria
     * object is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator}
     * @param textMatchStyle If specified the text match style will be used to   generate the appropriate <code>operator</code> for per field
     * criteria.
     *
     * @return a {@link com.smartgwt.client.data.AdvancedCriteria} based on the form's current values
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria(TextMatchStyle textMatchStyle) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getValuesAsAdvancedCriteria", "TextMatchStyle");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria(textMatchStyle == null ? null : textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
    /**
     * Add a asyncValidationReply handler.
     * <p>
     * Notification fired when an asynchronous validation completes.
     *
     * @param handler the asyncValidationReply handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addAsyncValidationReplyHandler(com.smartgwt.client.form.events.AsyncValidationReplyHandler handler) {
        if(getHandlerCount(com.smartgwt.client.form.events.AsyncValidationReplyEvent.getType()) == 0) setupAsyncValidationReplyEvent();
        return doAddHandler(handler, com.smartgwt.client.form.events.AsyncValidationReplyEvent.getType());
    }

    private native void setupAsyncValidationReplyEvent() /*-{
        var obj;
        var selfJ = this;
        var handleAsyncValidationReply = $entry(function(){
            var param = {"_this": this, "success" : arguments[0], "errors" : arguments[1]};
                var event = @com.smartgwt.client.form.events.AsyncValidationReplyEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.widgets.form.ValuesManager::handleTearDownAsyncValidationReplyEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({handleAsyncValidationReply:  handleAsyncValidationReply              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.handleAsyncValidationReply =  handleAsyncValidationReply             ;
        }
    }-*/;

    private void handleTearDownAsyncValidationReplyEvent() {
        if (getHandlerCount(com.smartgwt.client.form.events.AsyncValidationReplyEvent.getType()) == 0) tearDownAsyncValidationReplyEvent();
    }

    private native void tearDownAsyncValidationReplyEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("handleAsyncValidationReply")) delete obj.handleAsyncValidationReply;
    }-*/;

    /**
     * Add a hiddenValidationErrors handler.
     * <p>
     * Method to display validation error messages for a valuesManager when there is not currently visible form item displaying
     * the errors. This will be called when validation fails for<br> - a field in a hidden or undrawn member form<br> - a
     * hidden field in a visible member form<br> - for databound ValuesManagers, a datasource field with specified validators,
     * but not   associated item in any member.<br> Implement this to provide custom validation error handling for these
     * fields.<br> By default hidden validation errors will be logged as warnings in the developerConsole. Call {@link
     * com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler#onHiddenValidationErrors} from this method to
     * suppress that behavior.
     *
     * @param handler the hiddenValidationErrors handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHiddenValidationErrorsHandler(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType()) == 0) setupHiddenValidationErrorsEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType());
    }

    private native void setupHiddenValidationErrorsEvent() /*-{
        var obj;
        var selfJ = this;
        var handleHiddenValidationErrors = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.widgets.form.ValuesManager::handleTearDownHiddenValidationErrorsEvent()();
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({handleHiddenValidationErrors: 
                function () {
                    var param = {"_this": this, "errors" : arguments[0]};
                    return handleHiddenValidationErrors(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.handleHiddenValidationErrors = 
                function () {
                    var param = {"_this": this, "errors" : arguments[0]};
                    return handleHiddenValidationErrors(param) == true;
                }
            ;
        }
    }-*/;

    private void handleTearDownHiddenValidationErrorsEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent.getType()) == 0) tearDownHiddenValidationErrorsEvent();
    }

    private native void tearDownHiddenValidationErrorsEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("handleHiddenValidationErrors")) delete obj.handleHiddenValidationErrors;
    }-*/;

	/**
     * Are there any errors associated with any fields in this valuesManager?
     *
     * @return returns true if there are any outstanding validation errors, false                   otherwise.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasErrors() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasErrors", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hasErrors();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Are there any errors associated with a field in this valuesManager?
     * @param fieldName field to check for errors
     *
     * @return returns true if there are any outstanding validation errors, false                   otherwise.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native Boolean hasFieldErrors(String fieldName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasFieldErrors", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hasFieldErrors(fieldName);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if {@link com.smartgwt.client.widgets.form.ValuesManager#getSaveOperationType saveOperationType} is
     * currently "add".  See {@link com.smartgwt.client.widgets.form.ValuesManager#getSaveOperationType saveOperationType}.
     *
     * @return whether this form will use an "add" operation when saving
     */
    public native Boolean isNewRecord() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isNewRecord", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isNewRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Is this <code>ValuesManager</code> waiting for an asynchronous validation to complete? This method will return true
     * after {@link com.smartgwt.client.widgets.form.ValuesManager#validate validate()} is called on a component with
     * server-side validators for some field(s), until the server responds. <P> Note that the notification method {@link
     * com.smartgwt.client.widgets.form.ValuesManager#addAsyncValidationReplyHandler ValuesManager.asyncValidationReply()} will
     * be fired when validation completes.
     *
     * @return true if this widget has pending asynchronous validations in process
     */
    public native Boolean isPendingAsyncValidation() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isPendingAsyncValidation", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isPendingAsyncValidation();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Handler fired whenever a change to a FormItem fires itemChanged() on one of the  member forms.  Fires after that event.
     * @param item the FormItem where the change event occurred
     * @param newValue new value for the FormItem
     */
    public native void itemChanged(FormItem item, Object newValue) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "itemChanged", "FormItem,Object");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.itemChanged(item.@com.smartgwt.client.core.DataClass::getJsObj()(), newValue);
    }-*/;

    /**
     * Add a memberSynchronized handler.
     * <p>
     * Fires after a member component's values have been synchronized from the ValuesManager's values, upon completion of the
     * {@link com.smartgwt.client.widgets.form.ValuesManager#synchronizeMember ValuesManager.synchronizeMember()} call.
     *
     * @param handler the memberSynchronized handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMemberSynchronizedHandler(com.smartgwt.client.form.events.MemberSynchronizedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.form.events.MemberSynchronizedEvent.getType()) == 0) setupMemberSynchronizedEvent();
        return doAddHandler(handler, com.smartgwt.client.form.events.MemberSynchronizedEvent.getType());
    }

    private native void setupMemberSynchronizedEvent() /*-{
        var obj;
        var selfJ = this;
        var memberSynchronized = $entry(function(){
            var param = {"_this": this, "member" : arguments[0]};
                var event = @com.smartgwt.client.form.events.MemberSynchronizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.widgets.form.ValuesManager::handleTearDownMemberSynchronizedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({memberSynchronized:  memberSynchronized              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.memberSynchronized =  memberSynchronized             ;
        }
    }-*/;

    private void handleTearDownMemberSynchronizedEvent() {
        if (getHandlerCount(com.smartgwt.client.form.events.MemberSynchronizedEvent.getType()) == 0) tearDownMemberSynchronizedEvent();
    }

    private native void tearDownMemberSynchronizedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("memberSynchronized")) delete obj.memberSynchronized;
    }-*/;

	/**
     * Remove a member form from this valuesManager, so its values are no longer managed  by this instance.  This does not
     * clear the values associated with the form from the valuesManager - they  will still be available via
     * <code>valuesManager.getValues()</code>, but will not be  updated as the form is manipulated.
     * @param member form (or ID of form) to remove from this valuesManager
     * @see com.smartgwt.client.widgets.form.ValuesManager#removeMembers
     */
    public native void removeMember(DynamicForm member) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeMember", "DynamicForm");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Remove multiple member forms from this valuesManager.
     * @param members array of forms to remove
     * @see com.smartgwt.client.widgets.form.ValuesManager#removeMember
     */
    public native void removeMembers(DynamicForm... members) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeMembers", "DynamicForm...");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeMembers(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(members));
    }-*/;

	/**
     * Same as {@link com.smartgwt.client.widgets.form.DynamicForm#reset DynamicForm.reset()}.
     */
    public native void resetValues() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resetValues", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resetValues();
    }-*/;

	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues the form's values} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType DSRequest.operationType} will be either "update" or "add", depending
     * on the current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType DynamicForm.saveOperationType}.
     * <P> On either a client-side or server-side validation failure, validation errors will be displayed in the form.  Visible
     * items within a DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or
     * DataSource fields with no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()} or
     * {@link com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler
     * ValuesManager.hiddenValidationErrors()}. <P> In the case of a validation error, the callback will <b>not</b> be called
     * by default since the form has already handled the failed save by displaying the validation errors to the user.  If you
     * need to do something additional in this case, you can set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError
     * RPCRequest.willHandleError} via the <code>requestProperties</code> parameter to force your callback to be invoked. 
     * However, first consider: <ul> <li> if you are trying to customize display of validation errors, there are several {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in modes} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors()} may be a better place to put
     * customizations. <li> for unrecoverable general errors (eg server is down), {@link
     * com.smartgwt.client.rpc.HandleErrorCallback#handleError central error handling} in invoked, so consider placing
     * customizations there unless an unrecoverable error should be handled specially by this specific form. </ul>
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveData", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.saveData();
    }-*/;

    /**
     * @see ValuesManager#saveData
     */
    public void saveData(DSCallback callback){
        saveData(callback, null);
    }

	/**
     * Validate and then save the form's current values to the {@link com.smartgwt.client.data.DataSource} this form is bound
     * to. <p> If client-side validators are defined, they are executed first, and if any errors are found the save is aborted
     * and the form will show the errors. <p> If client-side validation passes, a {@link com.smartgwt.client.data.DSRequest}
     * will be sent, exactly as though {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()} or {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()} had been called with  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues the form's values} as data.  The {@link
     * com.smartgwt.client.data.DSRequest#getOperationType DSRequest.operationType} will be either "update" or "add", depending
     * on the current {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType DynamicForm.saveOperationType}.
     * <P> On either a client-side or server-side validation failure, validation errors will be displayed in the form.  Visible
     * items within a DynamicForm will be redrawn to display errors. Validation failure occurring on hidden items, or
     * DataSource fields with no  associated form items may be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addHiddenValidationErrorsHandler DynamicForm.hiddenValidationErrors()} or
     * {@link com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler
     * ValuesManager.hiddenValidationErrors()}. <P> In the case of a validation error, the callback will <b>not</b> be called
     * by default since the form has already handled the failed save by displaying the validation errors to the user.  If you
     * need to do something additional in this case, you can set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError
     * RPCRequest.willHandleError} via the <code>requestProperties</code> parameter to force your callback to be invoked. 
     * However, first consider: <ul> <li> if you are trying to customize display of validation errors, there are several {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons built-in modes} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors DynamicForm.showErrors()} may be a better place to put
     * customizations. <li> for unrecoverable general errors (eg server is down), {@link
     * com.smartgwt.client.rpc.HandleErrorCallback#handleError central error handling} in invoked, so consider placing
     * customizations there unless an unrecoverable error should be handled specially by this specific form. </ul>
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_grid_form_category" target="examples">Add Example</a>
     */
    public native void saveData(DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveData", "DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.saveData(
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Replaces the current values of the ValuesManager and all member components with the  values passed in. <P> Values should
     * be provided as an Object containing the new values as properties, where each propertyName is the name of a {@link
     * com.smartgwt.client.docs.Items form item} in one of the member forms, and each property value is the value to apply to
     * that form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}. <P> Values
     * with no corresponding form item may also be passed, will be tracked by the valuesManager and returned by subsequent
     * calls to {@link com.smartgwt.client.widgets.form.ValuesManager#getValues getValues()}. <P> Any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} for which a value is not provided will revert to its {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue}.  To cause all FormItems to revert to
     * default values, pass null. <P> This method also calls {@link
     * com.smartgwt.client.widgets.form.ValuesManager#rememberValues rememberValues()} so that a subsequent later call to
     * {@link com.smartgwt.client.widgets.form.ValuesManager#resetValues resetValues()} will revert to the passed values.
     * @param values new set of values for this values manager.
     */
    public native void setValues(Map values) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setValues", "Map");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setValues(values == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(values));
    }-*/;

	/**
     * Method to explicitly show the latest set of validation errors present on some field  within this ValuesManager.<br> If
     * the field in question is present as a visible item in a member form, the form item will be redrawn to display the error
     * message(s). Otherwise {@link com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler
     * ValuesManager.hiddenValidationErrors()} will be fired to allow  custom handling of hidden errors.
     * @see com.smartgwt.client.docs.Errors Errors overview and related methods
     */
    public native void showFieldErrors() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showFieldErrors", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showFieldErrors();
    }-*/;

	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} in a
     * member form is clicked, or if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set for
     * some member form, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If {@link
     * com.smartgwt.client.widgets.form.ValuesManager#submitValues valuesManager.submitValues()} exists, it will be called, and
     * no further action will be taken. <P> Otherwise, {@link com.smartgwt.client.widgets.form.ValuesManager#saveData
     * saveData()} will be called to handle saving via Smart GWT databinding.   <P> The parameters to <code>submit()</code>
     * apply only if <code>submit()</code> will be calling {@link com.smartgwt.client.widgets.form.ValuesManager#saveData
     * saveData()}.  If you override <code>submit()</code>, you can safely ignore the parameters as Smart GWT framework code
     * does not pass them.
     * @see com.smartgwt.client.widgets.form.ValuesManager#submitValues
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "submit", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.submit();
    }-*/;

    /**
     * @see ValuesManager#submit
     */
    public void submit(DSCallback callback){
        submit(callback, null);
    }

	/**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem} in a
     * member form is clicked, or if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is set for
     * some member form, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If {@link
     * com.smartgwt.client.widgets.form.ValuesManager#submitValues valuesManager.submitValues()} exists, it will be called, and
     * no further action will be taken. <P> Otherwise, {@link com.smartgwt.client.widgets.form.ValuesManager#saveData
     * saveData()} will be called to handle saving via Smart GWT databinding.   <P> The parameters to <code>submit()</code>
     * apply only if <code>submit()</code> will be calling {@link com.smartgwt.client.widgets.form.ValuesManager#saveData
     * saveData()}.  If you override <code>submit()</code>, you can safely ignore the parameters as Smart GWT framework code
     * does not pass them.
     * @param callback callback to invoke on completion.
     * @param requestProperties additional properties to set on the DSRequest                                          that will be issued
     * @see com.smartgwt.client.widgets.form.ValuesManager#submitValues
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void submit(DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "submit", "DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.submit(
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Update the parameter ValuesManager member to reflect the current values held by the ValuesManager. Note, it is not
     * normally necessary to manually synchronize members
     * @param member Member component to synchronize
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembers
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembersOnDataPath
     */
    public native void synchronizeMember(Canvas member) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "synchronizeMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.synchronizeMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Update all of this ValuesManager's members to reflect the current values held by the ValuesManager.  It is not normally
     * necessary to manually synchronize members, but you will need to do so if you switch off {@link
     * com.smartgwt.client.widgets.form.ValuesManager#getAutoSynchronize automatic synchronization}.
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMember
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembersOnDataPath
     */
    public native void synchronizeMembers() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "synchronizeMembers", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.synchronizeMembers();
    }-*/;

	/**
     * Update just those of this ValuesManager's members that have the parameter  {@link
     * com.smartgwt.client.widgets.Canvas#getDataPath dataPath}, to reflect the current values held by the ValuesManager. Note,
     * it is not normally necessary to manually synchronize members
     * @param dataPath dataPath to synchronize
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMember
     * @see com.smartgwt.client.widgets.form.ValuesManager#synchronizeMembers
     */
    public native void synchronizeMembersOnDataPath(String dataPath) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "synchronizeMembersOnDataPath", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.synchronizeMembersOnDataPath(dataPath);
    }-*/;

	/**
     * Validate the current set of values for this values manager against validators defined in the member forms. For databound
     * valuesManagers, also perform validation against any validators defined on datasource fields. <P> Note that if validation
     * errors occur for a value that is not shown in any member forms, those errors will cause a warning and {@link
     * com.smartgwt.client.widgets.form.ValuesManager#addHiddenValidationErrorsHandler ValuesManager.hiddenValidationErrors()}
     * will be called.  This can occur if:<br> - A datasource field has no corresponding item in any member form<br> - The item
     * in question is hidden<br> - The member form containing the item is hidden. <P> If this form has any fields which require
     * server-side validation (see  {@link com.smartgwt.client.docs.serverds.Validator#serverCondition
     * Validator.serverCondition}) this will also be initialized. Such validation will occur asynchronously.  Developers can
     * use {@link com.smartgwt.client.widgets.form.ValuesManager#isPendingAsyncValidation isPendingAsyncValidation()} and
     * {@link com.smartgwt.client.widgets.form.ValuesManager#addAsyncValidationReplyHandler
     * ValuesManager.asyncValidationReply()} to detect and respond to asynchronous validation. <P> Note that for silent
     * validation, {@link com.smartgwt.client.widgets.form.ValuesManager#valuesAreValid valuesAreValid()} (client-side) and 
     * {@link com.smartgwt.client.widgets.form.ValuesManager#checkForValidationErrors checkForValidationErrors()} (client and
     * server-side) can be used instead.
     *
     * @return true if all validation passed
     * @see com.smartgwt.client.widgets.form.DynamicForm#validate
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_splitting" target="examples">Splitting Example</a>
     */
    public native Boolean validate() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validate", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.validate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Method to determine whether the current set of values for this values manager would pass validation by the validators
     * defined in the member forms.  This method operates client-side, without contacting the server, running validators on the
     * forms' values and returning a value indicating whether validation was successful. <P> Note that, like {@link
     * com.smartgwt.client.widgets.form.ValuesManager#validate validate()}, this method will perform value validation even
     * if:<ul> <li>A datasource field has no corresponding item in any member form</li> <li>The item in question is hidden</li>
     * <li>The member form containing the item is hidden</li></ul> <P> Unlike {@link
     * com.smartgwt.client.widgets.form.ValuesManager#validate validate()} this method will not store the errors on the forms
     * or display them to the user.
     *
     * @return Boolean value indicating validation success, or if  <code>returnErrors</code> was specified,  a map of field names to
     * the associated errors, for those fields that failed validation, or null if validation succeeded.
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public native boolean valuesAreValid() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "valuesAreValid", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.valuesAreValid();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Compares the current set of values with the values stored by the call to the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#rememberValues DynamicForm.rememberValues()} method. 
     * <code>rememberValues()</code> runs when the form is initialized and on every call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}. Returns true if the values have
     * changed, and false otherwise.
     *
     * @return true if current values do not match remembered values
     * @see com.smartgwt.client.widgets.form.ValuesManager#getChangedValues
     * @see com.smartgwt.client.widgets.form.ValuesManager#getOldValues
     */
    public native Boolean valuesHaveChanged() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "valuesHaveChanged", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.valuesHaveChanged();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Retrieve a ValuesManager by it's global {@link com.smartgwt.client.widgets.Canvas#getID ID}.
     * @param ID global ID of the ValuesManager
     *
     * @return the ValuesManager, or null if not found
     */
    public static native ValuesManager getById(String ID) /*-{
        var ret = $wnd.isc.ValuesManager.getById(ID);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.ValuesManager::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


    // ***********************************************************



	protected void onInit() {
    	super.onInit();
    	onInit_ValuesManager();
    }
    
    protected native void onInit_ValuesManager() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self._showErrors = self.showErrors;
        self.showErrors = $entry(function() {
            var jObj = this.__ref;
            jObj.@com.smartgwt.client.widgets.form.ValuesManager::showErrors()();
        });
    }-*/;

    /**
     * If this form has any outstanding validation errors, show them now.<br>&#010 This method is called when the set of errors are
     * changed by {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors} or&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#validate}.
     * <br>&#010 Default implementation will redraw the form to display error messages and call&#010
     * {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors} to&#010 display errors with no visible field.
     * <p/>
     * <br>
     * <p/>
     * <p><b>Note: This is an override point</b>.&#010 This method may be overridden to perform custom display of validation errors.
     */
    public void showErrors() {
    	JavaScriptObject jsObj = this.getJsObj();
    	showErrorsJS(jsObj);
    }
    private native void showErrorsJS(JavaScriptObject jsObj) /*-{
    	if (jsObj == null) return;
    	if (jsObj._showErrors != null) jsObj._showErrors();
    	// if onInit never ran (binding occurred after creation in JS space, perhaps),
    	// just call standard showErrors
    	else if (jsObj.showErrors != null) jsObj.showErrors();
    }-*/;

    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 DataSource
     * requests<P>
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, double value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, Date value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;
    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, Map value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, Record value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.data.Record::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, DataClass value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, Record[] value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value     New value.
     */
    public native void setValue(String fieldName, DataClass[] value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Return the value as String
     *
     * @param fieldName the field name
     * @return the value
     */
    public native String getValueAsString(String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null ? null : val.toString();
    }-*/;

    /**
     * Return the value of the field.
     *
     * @param fieldName the field name
     * @return the value
     */
    public native Object getValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null ? null : $wnd.SmartGWT.convertToJavaType(val);
    }-*/;

    /**
     * Edit the record selected in the specified selection component (typically a {@link
     * com.smartgwt.client.widgets.grid.ListGrid}). <P> Updates the values of this editor to match the selected record's
     * values. <P> If this form has a dataSource, then saving via {@link com.smartgwt.client.widgets.form.ValuesManager#saveData}
     * will use the  "update" operation type.
     *
     * @param selectionComponent the ListGrid or ID of a {@link com.smartgwt.client.widgets.grid.ListGrid} whose
     *                           currently selected     record(s) is/are to be edited
     */
    public native void editSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(selectionComponentJS);
    }-*/;

    /**
     * Returns an array of members in this ValuesManager.  Note that this is a convenience method: it returns an array of DynamicForm, 
     * and so can only be validly used if all the ValuesManager's members are DynamicForms (a ValuesManager's members are traditionally 
     * DynamicForms, but they can be any kind of Canvas).  See {@link com.smartgwt.client.widgets.form.ValuesManager#getMemberCanvases}
     *
     * @return the members
     */
    public DynamicForm[] getMembers() {
    	java.util.HashSet<DynamicForm> dynamicForms = new java.util.HashSet<DynamicForm>();
    	for(Canvas canvas : getMemberCanvases()) {
    		if(canvas instanceof DynamicForm) {
    			dynamicForms.add((DynamicForm) canvas);
    		}
    	}
        return dynamicForms.toArray(new DynamicForm[]{});
    }

    /**
     * Returns the members of this ValuesManager as an array of Canvas objects.  See also 
     * {@link com.smartgwt.client.widgets.form.ValuesManager#getMembers}
     *
     * @return the members
     */
    public Canvas[] getMemberCanvases() {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("members"));
    }

     /**
     * Remove a member form from this valuesManager, so its values are no longer managed by this instance. This does not
     * clear the values associated with the form from the valuesManager - they will still be available via
     * valuesManager.getValues(), but will not be updated as the form is manipulated.
     *
     * @param formID ID of the form to remove from this valuesManager
     */
    public native void removeMember(String formID) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeMember(formID);
    }-*/;
    public native void removeMember(Canvas member) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Add a new member to this valuesManager.  Any {@link com.smartgwt.client.widgets.Canvas} can be a member of a
     * valuesManager, even components like {@link com.smartgwt.client.widgets.layout.Layout} or {@link
     * com.smartgwt.client.widgets.tab.TabSet} that do not actually have any values to manage.  When "valueless" components
     * like these bind to a ValuesManager, it is in order to provide their own child components with a shared valuesManager so
     * that complex data can be displayed and edited - see  {@link com.smartgwt.client.docs.DataPath} for more details. <p> For
     * components like {@link com.smartgwt.client.widgets.form.DynamicForm} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, which do have  a set of values to manage, the component's values will
     * subsequently be available through this valuesManager. <p> Note on pre-existent values when the member component is a
     * {@link com.smartgwt.client.widgets.form.DynamicForm}:<br> If the valuesManager has a value specified for some field, for
     * which the member form has an item, this value will be applied to the member form.  This is true whether the item has a
     * value or not.<br> However if the member form has a value for some field, and the ValuesManager does not have a specified
     * value for the same field, we allow the valuesManager to pick up the  value from the member form.
     * @param member component (or ID of component) to add to                                           this valuesManager as a member.
     * @see com.smartgwt.client.widgets.form.ValuesManager#addMembers
     */
    public native void addMember(String member) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addMember(member);
    }-*/;

    public native void addMember(Canvas member) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
    
    /**
     * Make a snapshot of the current set of values, so we can reset to them later. Creates a new object, then adds all
     * non-method properties of values to the new object. Use resetValues() to revert to these values. Note that this
     * method is automatically called when the values for this form are set programmatically via a call to
     * DynamicForm.setValues().
     *
     * @return copy of current form values
     */
    public native JavaScriptObject rememberValues() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.rememberValues();
    }-*/;


    /**
     * Setter for validation errors on this form. Errors passed in should be a Map in the format
     * {fieldName1:errors, fieldName2:errors}
     * <p/>
     * Where the errors value may be either a string (single error message) or an array of strings (if multiple errors should be applied to the field in question).
     *
     * @param errors     list of errors as a map with the field names as keys
     * @param showErrors If true redraw form to display errors now. Otherwise errors can be displayed by calling
     *                   {@link ValuesManager#showErrors} <b>Note</b>: When the errors are shown, handleHiddenValidationErrors() will be fired for errors
     *                   on hidden fields, or with no associated formItem.
     */
    public native void setErrors(Map errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(errors);
        return self.setErrors(errorsJS, showErrors);
    }-*/;

    /**
     * Set field validation error for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     *
     * @param fieldName  field to apply the new errors to
     * @param error      error to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String error, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.setFieldErrors(fieldName, error, showErrors);
    }-*/;

    /**
     * Set field validation errors for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     *
     * @param fieldName  field to apply the new errors to
     * @param errors     errors to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String[] errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(errors);
        return self.setFieldErrors(fieldName, errorsJS, showErrors);
    }-*/;

    /**
     * Returns any validation errors for some field in this valuesManager. If no errors are present, will return null.
     *
     * @param fieldName the field name
     * @return error messages for the field.
     */
    public native String[] getFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var value = self.getFieldErrors(fieldName);
        if(value == null) return null;
        if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Retrieve a {@link com.smartgwt.client.widgets.form.fields.FormItem} from this ValuesManager. <P> Takes a field {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName 'name'} or {@link com.smartgwt.client.docs.DataType DataType},
     * and searches through the members of this valuesManager for an editor for that field. If found the appropriate formItem 
     * will be returned. Note that if a dataPath is passed in, it should be the full data path for the item, including any
     * canvas level {@link com.smartgwt.client.widgets.Canvas#getDataPath 'dataPath'} specified on the member form containing
     * this form item. <br>Note: Unlike the <code>DynamicForm</code> class, this method will not return an  item by index
     * @param itemID item fieldName or dataPath identifier
     *
     * @return form item for editing/displaying the appropriate field, or null if   no formItem can be found for the field.
     */
    public native FormItem getItem(String itemID) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var fieldJS = self.getItem(itemID);
        if (fieldJS == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemFactory::getFormItem(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS);
    }-*/;
    /**
     * Add a submitValues handler.
     * <p>
     * Triggered when a {@link #submit()} is called on this valuesManager (or any form included in this valuesManager).
     *
     * @param handler the submitValues handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSubmitValuesHandler(com.smartgwt.client.widgets.form.events.SubmitValuesHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType()) == 0) setupSubmitValuesEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType());
    }

    private native void setupSubmitValuesEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({submitValues:$entry(function(){
                        var param = {"values" : arguments[0], "form" : null};
                        var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.submitValues = $entry(function(){
                   var param = {"values" : arguments[0], "form" : null};
                   var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    
    /**
     * Retrieves the combined {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria(),criteria values}
     * for all member forms.
     * <P>
     * As with the DynamicForm getValuesAsCriteria, this method may return
     * AdvancedCriteria or simple Criteria depending on whether
     * the {@link com.smartgwt.client.widgets.form.ValuesManager#setOperator,operator}
     * is set to <code>"or"</code> rather than <code>"and"</code>, and whether any member
     * forms return AdvancedCriteria.
     * <P>
     * Note that developers can also use {@link com.smartgwt.client.data.DataSource#combineCriteria}
     * to combine
     * sub-criteria from various sources, including member forms of a ValuesManager, into
     * a combined criteria object.
     *
     * @return the criteria
     */
    public native Criteria getValuesAsCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getValuesAsCriteria();
        if (critJS == null) critJS = @com.smartgwt.client.util.JSOHelper::createObject()();
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;
    
    /**
     * Returns the current set of values for the values manager instance.
     *
     * @return a Record object containing the values for this manager
     */
    public Record getValuesAsRecord() {
        Map values = getValues();
        //if the map contains the actual reference to the underlying record then return it, else
        //build a record from the map values
        Object ref = values.get("__ref");
        if(ref != null && ref instanceof Record) {
            return (Record) ref;
        } else {
            return new Record(JSOHelper.convertMapToJavascriptObject(values));
        }
    }

}
