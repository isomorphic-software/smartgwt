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
 
package com.smartgwt.client.data;



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
 * AdvancedCriteria is a format for representing search criteria which may include&#010 operators on field values such as
 * "less than", or may include sub-clauses such as several &#010 criteria applied to fields joined by an "OR"
 * operator.&#010 <P>&#010 Smart GWT DataSources can use AdvancedCriteria to search a list of {@link
 * com.smartgwt.client.data.Record}s, and&#010 the Smart GWT Java Server can translate AdvancedCriteria to either SQL or
 * Hibernate&#010 queries (<b>Note:</b> The server-side AdvancedCriteria handling feature is only available &#010 with the
 * <b>Power</b> and <b>Enterprise</b> Editions of Smart GWT; the Pro Edition is &#010 limited to ordinary criteria handling
 * on the server side).<p>&#010 If the entire dataset is cached locally, Smart GWT can perform AdvancedCriteria filtering
 * &#010 on the client, avoiding a server call.&#010 <P>&#010 &#010 &#010 AdvancedCriteria objects can be created directly
 * in java. For example:&#010 <pre>&#010 AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new
 * Criterion[]{&#010     new Criterion("salary", OperatorId.LESS_THAN, 8000),&#010     new AdvancedCriteria(OperatorId.OR,
 * new Criterion[]{&#010         new Criterion("title", OperatorId.ICONTAINS, "Manager"),&#010         new
 * Criterion("reports", OperatorId.NOT_NULL)&#010     })&#010 });&#010 </pre>&#010 &#010 <P>&#010 In addition to building a
 * raw AdvancedCriteria object as described above, the&#010 {@link com.smartgwt.client.data.DataSource#convertCriteria
 * DataSource.convertCriteria} and {@link com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria}
 * methods&#010 may be used to create and modify criteria based on simple fieldName / value mappings.&#010 <P>&#010 When
 * passed to the Smart GWT Server, AdvancedCriteria are automatically translated&#010 to Java Objects, identically to other
 * JavaScript data, by the rules given under &#010 {@link com.smartgwt.client.rpc.RPCRequest#getData data}.&#010 <P>&#010
 * Other servers may receive AdvancedCriteria in the most convenient format, for example,&#010 a {@link
 * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest} might translate AdvancedCriteria
 * directly into&#010 a SQL-like language, or serialize to XML using {@link
 * com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize}.&#010 <P>&#010 See {@link
 * com.smartgwt.client.docs.CriteriaEditing Criteria Editing} for information about&#010 editing AdvancedCriteria in a
 * DynamicForm.
 */
public class AdvancedCriteria extends Criterion {

    public static AdvancedCriteria getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new AdvancedCriteria(jsObj);
    }

    public AdvancedCriteria(){
        markAdvancedCriteria();
    }

    public AdvancedCriteria(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    public AdvancedCriteria(Criterion c) {
        super(c);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(OperatorId operator, Criterion[] criterias) {
        super(operator, criterias);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(OperatorId operator) {
        super(operator);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator) {
        super(fieldName, operator);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Integer value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    } 
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Float value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Date value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Integer[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Float[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Date[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

}



