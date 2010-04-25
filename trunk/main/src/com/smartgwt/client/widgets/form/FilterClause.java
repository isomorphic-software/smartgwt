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
 * An HStack-based widget that allows a user to input a single criterion based on one field and one operator. <P>
 */
public class FilterClause extends HStack {

    public static FilterClause getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (FilterClause) obj;
        } else {
            return new FilterClause(jsObj);
        }
    }

    public FilterClause(){
        scClassName = "FilterClause";
    }

    public FilterClause(JavaScriptObject jsObj){
        super(jsObj);
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
     * The hover prompt text for the remove button.
     *
     * @param removeButtonPrompt removeButtonPrompt Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the remove button.
     *
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

    // ********************* Methods ***********************
            
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

}



