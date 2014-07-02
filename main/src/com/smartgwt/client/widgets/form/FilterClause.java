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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * An HStack-based widget that allows a user to input a single criterion based on one field and one operator. <P> Note that
 * FilterClauses must be used in conjunction with a {@link com.smartgwt.client.widgets.form.FilterBuilder}. By default the
 * FilterBuilder will auto-generate its clauses based on specified criteria, but for advanced usage a FilterClause may be
 * instantiated directly and passed to a filterBuilder via  {@link com.smartgwt.client.widgets.form.FilterBuilder#addClause
 * FilterBuilder.addClause}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FilterClause")
public class FilterClause extends HStack {

    public static FilterClause getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new FilterClause(jsObj);
        } else {
            assert refInstance instanceof FilterClause;
            return (FilterClause)refInstance;
        }
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
        $wnd.isc.FilterClause.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.FilterClause.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public FilterClause(){
        scClassName = "FilterClause";
    }

    public FilterClause(JavaScriptObject jsObj){
        scClassName = "FilterClause";
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
     * AutoChild containing the UI for the filter-properties in this FilterClause.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SearchForm
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SearchForm getClause() throws IllegalStateException {
        errorIfNotCreated("clause");
        return (SearchForm)SearchForm.getByJSObject(getAttributeAsJavaScriptObject("clause"));
    }
    

    /**
     * Initial criterion for this FilterClause. <P> When initialized with a criterion, the clause will be automatically set up
     * for editing the supplied criterion. <P> Note that an empty or partial criterion is allowed, for example, it may specify
     * {@link com.smartgwt.client.data.Criterion#getFieldName fieldName} only and will generate an expression with the operator
     * not chosen.
     *
     * @param criterion  Default value is null
     */
    public void setCriterion(Criteria criterion) {
        setAttribute("criterion", criterion.getJsObj(), true);
    }

    /**
     * Initial criterion for this FilterClause. <P> When initialized with a criterion, the clause will be automatically set up
     * for editing the supplied criterion. <P> Note that an empty or partial criterion is allowed, for example, it may specify
     * {@link com.smartgwt.client.data.Criterion#getFieldName fieldName} only and will generate an expression with the operator
     * not chosen.
     *
     * @return Return the criterion specified by this FilterClause.
     */
    public Criteria getCriterion()  {
        return new Criteria(getAttributeAsJavaScriptObject("criterion"));
    }
    
    

    /**
     * Properties to combine with the FieldPicker autoChild FormItem.
     *
     * @param fieldPickerProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerProperties(FormItem fieldPickerProperties)  throws IllegalStateException {
        setAttribute("fieldPickerProperties", fieldPickerProperties.getJsObj(), false);
    }

    /**
     * Properties to combine with the FieldPicker autoChild FormItem.
     *
     * @return FormItem
     */
    public FormItem getFieldPickerProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("fieldPickerProperties"));
    }
    

    /**
     * The title for the  field-picker select-item.
     *
     * @param fieldPickerTitle  Default value is "Field Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerTitle(String fieldPickerTitle)  throws IllegalStateException {
        setAttribute("fieldPickerTitle", fieldPickerTitle, false);
    }

    /**
     * The title for the  field-picker select-item.
     *
     * @return String
     */
    public String getFieldPickerTitle()  {
        return getAttributeAsString("fieldPickerTitle");
    }
    

    /**
     * AutoChild for the {@link com.smartgwt.client.widgets.form.fields.FormItem} that allows a user to select the operator
     * when creating filter clauses. Each clause will create an operatorPicker automatically. To customize this item, use
     * {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPickerProperties operatorPickerProperties}
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SelectItem getOperatorPicker() throws IllegalStateException {
        errorIfNotCreated("operatorPicker");
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("operatorPicker"));
    }
    

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPicker operatorPicker}
     * autoChild FormItem.
     *
     * @param operatorPickerProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerProperties(FormItem operatorPickerProperties)  throws IllegalStateException {
        setAttribute("operatorPickerProperties", operatorPickerProperties.getJsObj(), false);
    }

    /**
     * Properties to combine with the {@link com.smartgwt.client.widgets.form.FilterClause#getOperatorPicker operatorPicker}
     * autoChild FormItem.
     *
     * @return FormItem
     */
    public FormItem getOperatorPickerProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("operatorPickerProperties"));
    }
    

    /**
     * The title for the operator-picker select-item.
     *
     * @param operatorPickerTitle  Default value is "Operator"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperatorPickerTitle(String operatorPickerTitle)  throws IllegalStateException {
        setAttribute("operatorPickerTitle", operatorPickerTitle, false);
    }

    /**
     * The title for the operator-picker select-item.
     *
     * @return String
     */
    public String getOperatorPickerTitle()  {
        return getAttributeAsString("operatorPickerTitle");
    }
    

    /**
     * The clause removal ImgButton that appears before this clause if {@link
     * com.smartgwt.client.widgets.form.FilterClause#getShowRemoveButton showRemoveButton} is set.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getRemoveButton() throws IllegalStateException {
        errorIfNotCreated("removeButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("removeButton"));
    }
    

    /**
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt  Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
     * @return String
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }
    

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @param showFieldTitles  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @return Boolean
     */
    public Boolean getShowFieldTitles()  {
        return getAttributeAsBoolean("showFieldTitles");
    }
    

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
     * @param showRemoveButton  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRemoveButton(Boolean showRemoveButton)  throws IllegalStateException {
        setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
     * @return Boolean
     */
    public Boolean getShowRemoveButton()  {
        return getAttributeAsBoolean("showRemoveButton");
    }
    

    /**
     * If true (the default), validates the entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterClause</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterClause#validate FilterClause.validate} from your own code.
     *
     * @param validateOnChange  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValidateOnChange(Boolean validateOnChange)  throws IllegalStateException {
        setAttribute("validateOnChange", validateOnChange, false);
    }

    /**
     * If true (the default), validates the entered value when it changes, to make sure it is a  a valid value of its type
     * (valid string, number, and so on).  No other validation is  carried out.  If you switch this property off, it is still
     * possible to validate the  <code>FilterClause</code> by calling {@link
     * com.smartgwt.client.widgets.form.FilterClause#validate FilterClause.validate} from your own code.
     *
     * @return Boolean
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }
    

    /**
     * The title for the value-item.
     *
     * @param valueItemTitle  Default value is "Value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueItemTitle(String valueItemTitle)  throws IllegalStateException {
        setAttribute("valueItemTitle", valueItemTitle, false);
    }

    /**
     * The title for the value-item.
     *
     * @return String
     */
    public String getValueItemTitle()  {
        return getAttributeAsString("valueItemTitle");
    }
    

    // ********************* Methods ***********************

	/**
     * Get the list of {@link com.smartgwt.client.types.OperatorId operatorIds} that are valid for this field.  By default, 
     * calls through to the same method on {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldOperators
     * filterBuilder}, which defaults to all operators returned by {@link com.smartgwt.client.data.DataSource#getFieldOperators
     * DataSource.getFieldOperators}. <P> Called whenever the fieldName is changed.
     * @param fieldName the name of the field for which to return the set of available            operators
     *
     * @return valid operators for this field
     */
    public native OperatorId[] getFieldOperators(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFieldOperators(fieldName);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfOperatorId(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.form.FilterBuilder filterBuilder} containing this clause, or null if this
     * filterClause is not embedded in a filterBuilder.
     */
    public native void getFilterBuilder() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getFilterBuilder();
    }-*/;

	/**
     * Remove this clause by destroy()ing it.
     */
    public native void remove() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.remove();
    }-*/;

	/**
     * Validate this clause.
     *
     * @return true if if the clause is valid, false otherwise
     */
    public native Boolean validate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param filterClauseProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FilterClause filterClauseProperties) /*-{
    	var properties = $wnd.isc.addProperties({},filterClauseProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.FilterClause.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(FilterClauseLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.criterion = getCriterion();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.criterion:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerProperties = getAttributeAsString("fieldPickerProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.fieldPickerProperties:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerTitle = getAttributeAsString("fieldPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.fieldPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.operatorPickerProperties = getAttributeAsString("operatorPickerProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.operatorPickerProperties:" + t.getMessage() + "\n";
        }
        try {
            s.operatorPickerTitle = getAttributeAsString("operatorPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.operatorPickerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.removeButtonPrompt = getAttributeAsString("removeButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.removeButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.showFieldTitles = getAttributeAsString("showFieldTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.showFieldTitles:" + t.getMessage() + "\n";
        }
        try {
            s.showRemoveButton = getAttributeAsString("showRemoveButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.showRemoveButton:" + t.getMessage() + "\n";
        }
        try {
            s.validateOnChange = getAttributeAsString("validateOnChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.validateOnChange:" + t.getMessage() + "\n";
        }
        try {
            s.valueItemTitle = getAttributeAsString("valueItemTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.valueItemTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        FilterClauseLogicalStructure s = new FilterClauseLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

