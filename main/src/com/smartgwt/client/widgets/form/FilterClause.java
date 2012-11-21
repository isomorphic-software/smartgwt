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
 
package com.smartgwt.client.widgets.form;



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
 * An HStack-based widget that allows a user to input a single criterion based on one field and one operator. <P> Note that
 * FilterClauses must be used in conjunction with a {@link com.smartgwt.client.widgets.form.FilterBuilder}. By default the
 * FilterBuilder will auto-generate its clauses based on specified criteria, but for advanced usage a FilterClause may be
 * instantiated directly and passed to a filterBuilder via  {@link com.smartgwt.client.widgets.form.FilterBuilder#addClause
 * FilterBuilder.addClause}.
 */
public class FilterClause extends HStack {

    public native static FilterClause getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("FilterClause",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.form.FilterClause::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


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
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Initial criterion for this FilterClause. <P> When initialized with a criterion, the clause will be automatically set up
     * for editing the supplied criterion. <P> Note that an empty or partial criterion is allowed, for example, it may specify
     * {@link com.smartgwt.client.data.Criterion#getFieldName fieldName} only and will generate an expression with the operator
     * not chosen.
     *
     * @param criterion criterion Default value is null
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
     *
     * @return Return the criterion specified by this FilterClause.
     */
    public Criteria getCriterion()  {
        return new Criteria(getAttributeAsJavaScriptObject("criterion"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     * @param fieldPickerTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Field Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFieldPickerTitle(String fieldPickerTitle)  throws IllegalStateException {
        setAttribute("fieldPickerTitle", fieldPickerTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.FilterBuilder#getFieldPicker field-picker} select-item.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFieldPickerTitle()  {
        return getAttributeAsString("fieldPickerTitle");
    }

    /**
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     * @param showFieldTitles showFieldTitles Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldTitles(Boolean showFieldTitles)  throws IllegalStateException {
        setAttribute("showFieldTitles", showFieldTitles, false);
    }

    /**
     * If true (the default), show field titles in the drop-down box used to select a field for querying. If false, show actual
     * field names instead.
     *
     *
     * @return Boolean
     */
    public Boolean getShowFieldTitles()  {
        return getAttributeAsBoolean("showFieldTitles");
    }

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
     * @param showRemoveButton showRemoveButton Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRemoveButton(Boolean showRemoveButton)  throws IllegalStateException {
        setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If set, show a button for this clause allowing it to be removed.
     *
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
     * @param validateOnChange validateOnChange Default value is true
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
     *
     * @return Boolean
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
     * The title for the value-item.
     *
     * @param valueItemTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueItemTitle(String valueItemTitle)  throws IllegalStateException {
        setAttribute("valueItemTitle", valueItemTitle, false);
    }

    /**
     * The title for the value-item.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getValueItemTitle()  {
        return getAttributeAsString("valueItemTitle");
    }

    // ********************* Methods ***********************

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
        var retVal =self.validate();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
     * @param filterClauseProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FilterClause filterClauseProperties) /*-{
    	var properties = $wnd.isc.addProperties({},filterClauseProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
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
            s.fieldPickerTitle = getAttributeAsString("fieldPickerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FilterClause.fieldPickerTitle:" + t.getMessage() + "\n";
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

