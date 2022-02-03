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
 * A SearchForm is a DynamicForm specialized for a user to enter search criteria. <P> All DynamicForm properties and
 * methods work on SearchForm.  SearchForm extends and specializes DynamicForm for searching; for example, SearchForm sets
 * <code>hiliteRequiredFields</code> false by default because fields are typically not  required in a search.
 * @see com.smartgwt.client.widgets.form.DynamicForm
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SearchForm")
public class SearchForm extends DynamicForm {

    public static SearchForm getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new SearchForm(jsObj);
        } else {
            assert refInstance instanceof SearchForm;
            return (SearchForm)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SearchForm.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SearchForm.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SearchForm.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SearchForm.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public SearchForm(){
        scClassName = "SearchForm";
    }

    public SearchForm(JavaScriptObject jsObj){
        scClassName = "SearchForm";
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
     * This property is overridden in SearchForm to allow editing of dataSource fields marked as <code>canFilter:true</code> by
     * default.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditFieldAttribute New canEditFieldAttribute value. Default value is "canFilter"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditFieldAttribute(String canEditFieldAttribute)  throws IllegalStateException {
        setAttribute("canEditFieldAttribute", canEditFieldAttribute, false);
    }

    /**
     * This property is overridden in SearchForm to allow editing of dataSource fields marked as <code>canFilter:true</code> by
     * default.
     *
     * @return Current canEditFieldAttribute value. Default value is "canFilter"
     */
    public String getCanEditFieldAttribute()  {
        return getAttributeAsString("canEditFieldAttribute");
    }
    

    /**
     * If this attribute is true any {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false} fields
     * specified on the dataSource will not be shown unless explicitly included in this component's {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields array}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFilterFieldsOnly New showFilterFieldsOnly value. Default value is true
     */
    public void setShowFilterFieldsOnly(Boolean showFilterFieldsOnly) {
        setAttribute("showFilterFieldsOnly", showFilterFieldsOnly, true);
    }

    /**
     * If this attribute is true any {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false} fields
     * specified on the dataSource will not be shown unless explicitly included in this component's {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields fields array}
     *
     * @return Current showFilterFieldsOnly value. Default value is true
     */
    public Boolean getShowFilterFieldsOnly()  {
        Boolean result = getAttributeAsBoolean("showFilterFieldsOnly");
        return result == null ? true : result;
    }
    

    /**
     * For editable fields with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField
     * FormItem.displayField} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, if the user selects a new value (typically from PickList based item such as a SelectItem),
     * should the selected displayValue be updated on the record being edited in addition to the value for the actual item.<br>
     * Note that this only applies for fields using  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display field values}. <P> Overriden
     * to be false for <code>searchForm</code>s. It is typically not necessary to have the display value as well as the data
     * value be included in generated criteria when a user selects a new value from a field with a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField}. <P> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStoreDisplayValues DynamicForm.storeDisplayValues} for more information
     * on this property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param storeDisplayValues New storeDisplayValues value. Default value is false
     */
    public void setStoreDisplayValues(Boolean storeDisplayValues) {
        setAttribute("storeDisplayValues", storeDisplayValues, true);
    }

    /**
     * For editable fields with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField
     * FormItem.displayField} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, if the user selects a new value (typically from PickList based item such as a SelectItem),
     * should the selected displayValue be updated on the record being edited in addition to the value for the actual item.<br>
     * Note that this only applies for fields using  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display field values}. <P> Overriden
     * to be false for <code>searchForm</code>s. It is typically not necessary to have the display value as well as the data
     * value be included in generated criteria when a user selects a new value from a field with a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField}. <P> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStoreDisplayValues DynamicForm.storeDisplayValues} for more information
     * on this property.
     *
     * @return Current storeDisplayValues value. Default value is false
     */
    public Boolean getStoreDisplayValues()  {
        Boolean result = getAttributeAsBoolean("storeDisplayValues");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************

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
     * @param searchFormProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SearchForm searchFormProperties) /*-{
        if (searchFormProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SearchForm.@java.lang.Object::getClass()(), "setDefaultProperties", searchFormProperties.@java.lang.Object::getClass()());
        }
        searchFormProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = searchFormProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.SearchForm.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SearchFormLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canEditFieldAttribute = getAttributeAsString("canEditFieldAttribute");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SearchForm.canEditFieldAttribute:" + t.getMessage() + "\n";
        }
        try {
            s.showFilterFieldsOnly = getAttributeAsString("showFilterFieldsOnly");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SearchForm.showFilterFieldsOnly:" + t.getMessage() + "\n";
        }
        try {
            s.storeDisplayValues = getAttributeAsString("storeDisplayValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SearchForm.storeDisplayValues:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SearchFormLogicalStructure s = new SearchFormLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
