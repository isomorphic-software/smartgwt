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
 
package com.smartgwt.client.data;


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

/**
 * An object representing a criterion to apply to a record.   <P> A criterion is part of the definition of an {@link
 * com.smartgwt.client.data.AdvancedCriteria} object, which is used to filter records according to search criteria.  <P> A
 * criterion consists of an {@link com.smartgwt.client.data.Criterion#getOperator operator} and typically a {@link
 * com.smartgwt.client.data.DataSourceField#getName fieldName} from a {@link com.smartgwt.client.data.Record} and a {@link
 * com.smartgwt.client.data.Criterion#getValue value} to compare to.  However some operators either don't require a value
 * (eg, isNull) or act on other criteria rather than directly on a {@link com.smartgwt.client.data.Record}'s fields (eg,
 * the "and" and "or" logical operators). <P> A shortcut form is also allowed where only <code>fieldName</code> and
 * <code>value</code> values are provided. In this case the <code>operator</code> is assumed to be "equals".
 */
@BeanFactory.FrameworkClass
public class Criterion extends Criteria {

    public static Criterion getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Criterion(jsObj);
    }


    public Criterion(){
        
    }

    public Criterion(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * For a criterion with an operator that acts on other criteria (eg "and", "or"), a list of sub-criteria that are grouped
     * together by the operator.
     *
     * @param criteria  Default value is null
     */
    public void setCriteria(Criterion... criteria) {
        setAttribute("criteria", criteria);
    }

    /**
     * For a criterion with an operator that acts on other criteria (eg "and", "or"), a list of sub-criteria that are grouped
     * together by the operator.
     *
     * @return Criterion...
     */
    public Criterion[] getCriteria()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCriterion(getAttributeAsJavaScriptObject("criteria"));
    }

    /**
     * Name of the field in each {@link com.smartgwt.client.data.Record} that this criterion applies to.  Not applicable for a
     * criterion with {@link com.smartgwt.client.data.Criterion#getCriteria sub-criteria}. Can be specified as a dataPath to 
     * allow matching nested objects. Use '/' as delimiters for dataPath. See  {@link com.smartgwt.client.docs.DataPath
     * dataPath} for more information.
     *
     * @param fieldName  Default value is null
     */
    public void setFieldName(String fieldName) {
        setAttribute("fieldName", fieldName);
    }

    /**
     * Name of the field in each {@link com.smartgwt.client.data.Record} that this criterion applies to.  Not applicable for a
     * criterion with {@link com.smartgwt.client.data.Criterion#getCriteria sub-criteria}. Can be specified as a dataPath to 
     * allow matching nested objects. Use '/' as delimiters for dataPath. See  {@link com.smartgwt.client.docs.DataPath
     * dataPath} for more information.
     *
     * @return String
     */
    public String getFieldName()  {
        return getAttributeAsString("fieldName");
    }

    /**
     * Operator this criterion applies.
     *
     * @param operator  Default value is null
     */
    public void setOperator(OperatorId operator) {
        setAttribute("operator", operator == null ? null : operator.getValue());
    }

    /**
     * Operator this criterion applies.
     *
     * @return OperatorId
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


	
	public static final boolean instanceOf(Object object) {
		return object instanceof Criterion;
	}
	
    public Criterion(Criterion c) {
        Object o;
        o = c.getAttributeAsObject("operator");
        if (o != null) setAttribute("operator", o);
        o = c.getAttributeAsObject("fieldName");
        if (o != null) setAttribute("fieldName", o);
        o = c.getAttributeAsObject("criteria");
        if (o != null) setAttribute("criteria", o);
        o = c.getAttributeAsObject("value");
        if (o != null) setAttribute("value", o);
    }

    public Criterion(OperatorId operator, Criterion[] criterias) {
        buildCriterionFromList(operator, criterias);
    }
    
    public Criterion(OperatorId operator) {
        setAttribute("operator", operator.getValue());
    }
    
    public Criterion(String fieldName, OperatorId operator) {
        setAttribute("fieldName", fieldName);
        setAttribute("operator", operator.getValue());
    }
    
    /**
     * Constructor for Criterion with fieldName, operator and value.
     * 
     * @param fieldName the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, Integer value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }
    
    /**
     * Constructor for Criterion with fieldName, operator, start and end values. This constructor is only valid when
     * the operator is {@link OperatorId#BETWEEN} or {@link OperatorId#BETWEEN_INCLUSIVE}
     *
     * @param fieldName the field name
     * @param operator the operator
     * @param start the start value
     * @param end the end value
     */
    public Criterion(String fieldName, OperatorId operator, Integer start, Integer end) {
        this(fieldName, operator);
        assert operator == OperatorId.BETWEEN || operator == OperatorId.BETWEEN_INCLUSIVE : "The operator type must be OperatorId.BETWEEN or OperatorId.BETWEEN_INCLUSIVE";
        setAttribute("start", start);
        setAttribute("end", end);
    }

    /**
     * Constructor for Criterion with fieldName, operator and value.
     * 
     * @param fieldName the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, String value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Constructor for Criterion with fieldName, operator, start and end values. This constructor is only valid when
     * the operator is {@link OperatorId#BETWEEN} or {@link OperatorId#BETWEEN_INCLUSIVE}
     *
     * @param fieldName the field name
     * @param operator the operator
     * @param start the start value
     * @param end the end value
     */
    public Criterion(String fieldName, OperatorId operator, String start, String end) {
        this(fieldName, operator);
        assert operator == OperatorId.BETWEEN || operator == OperatorId.BETWEEN_INCLUSIVE : "The operator type must be OperatorId.BETWEEN or OperatorId.BETWEEN_INCLUSIVE";
        setAttribute("start", start);
        setAttribute("end", end);
    }

    /**
     * Constructor for Criterion with fieldName, operator and value.
     * 
     * @param fieldName the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, Float value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Constructor for Criterion with fieldName, operator, start and end values. This constructor is only valid when
     * the operator is {@link OperatorId#BETWEEN} or {@link OperatorId#BETWEEN_INCLUSIVE}
     *
     * @param fieldName the field name
     * @param operator the operator
     * @param start the start value
     * @param end the end value
     */
    public Criterion(String fieldName, OperatorId operator, Float start, Float end) {
        this(fieldName, operator);
        assert operator == OperatorId.BETWEEN || operator == OperatorId.BETWEEN_INCLUSIVE : "The operator type must be OperatorId.BETWEEN or OperatorId.BETWEEN_INCLUSIVE";
        setAttribute("start", start);
        setAttribute("end", end);
    }

    /**
     * Constructor for Criterion with fieldName, operator and value.
     * 
     * @param fieldName the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, Date value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Constructor for Criterion with fieldName, operator, start and end values. This constructor is only valid when
     * the operator is {@link OperatorId#BETWEEN} or {@link OperatorId#BETWEEN_INCLUSIVE}
     *
     * @param fieldName the field name
     * @param operator the operator
     * @param start the start value
     * @param end the end value
     */
    public Criterion(String fieldName, OperatorId operator, Date start, Date end) {
        this(fieldName, operator);
        assert operator == OperatorId.BETWEEN || operator == OperatorId.BETWEEN_INCLUSIVE : "The operator type must be OperatorId.BETWEEN or OperatorId.BETWEEN_INCLUSIVE";
        setAttribute("start", start);
        setAttribute("end", end);
    }

    /**
     * Constructor for Criterion with fieldName, operator and value.
     * 
     * @param fieldName the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, Boolean value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Constructor for Criterion with fieldName, operator and value.
     * Note that JavaScript does not natively have an equivalent format to 
     * Java long (fixed point 64 bit). As such the value passed in will be
     * converted to a double value for storage.
     * @param fieldName  the field name
     * @param operator the operator
     * @param value the value
     */
    public Criterion(String fieldName, OperatorId operator, Long value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Constructor for Criterion with fieldName, operator, start and end values. This constructor is only valid when
     * the operator is {@link OperatorId#BETWEEN} or {@link OperatorId#BETWEEN_INCLUSIVE}
     *
     * @param fieldName the field name
     * @param operator the operator
     * @param start the start value
     * @param end the end value
     */
    public Criterion(String fieldName, OperatorId operator, Long start, Long end) {
        this(fieldName, operator);
        assert operator == OperatorId.BETWEEN || operator == OperatorId.BETWEEN_INCLUSIVE : "The operator type must be OperatorId.BETWEEN or OperatorId.BETWEEN_INCLUSIVE";
        setAttribute("start", start);
        setAttribute("end", end);
    }

    public Criterion(String fieldName, OperatorId operator, Integer[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }
    
    public Criterion(String fieldName, OperatorId operator, String[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    public Criterion(String fieldName, OperatorId operator, Float[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }
    
    public Criterion(String fieldName, OperatorId operator, Long[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }


    public Criterion(String fieldName, OperatorId operator, Date[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    public Criterion(String fieldName, OperatorId operator, Boolean[] value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    /**
     * Adds a new criteria.
     * <p>If the present criteria operation is "and", 
     * the new criteria is appended to the criteria list.
     * <p>Otherwise, the existing criteria is replaced with an "and" criteria, 
     * with two sub-criteria: the existing criteria, and the passed criteria.
     * <p>Note that if the existing criteria was empty 
     * (as would happen if new AdvancedCriteria() were called with no arguments), 
     * an "and" operator will still be introduced, but the passed criteria will be 
     * the only sub-criteria.
     * <p>To add an additional Criterion when using the "or" operator, use 
     * {@link #appendToCriterionList}.
     *
     * @param c the passed criteria object
     */
    public void addCriteria(Criterion c) {
        String opString = this.getAttributeAsString("operator");
        if (opString != null && opString.equals(OperatorId.AND.getValue())) {
            appendToCriterionList(c);
        } else {
	         if (this.getAttributeAsObject("value") != null || this.getCriteria().length != 0) {
                Criterion thisCopy = new Criterion(this);
                JSOHelper.deleteAttributeIfExists(jsObj, "fieldName");
                JSOHelper.deleteAttributeIfExists(jsObj, "value");
                Criterion[] criteriaList = { thisCopy, c };
                buildCriterionFromList(OperatorId.AND, criteriaList);                        
            } else {
                buildCriterionFromList(OperatorId.AND, new Criterion[] {c});
            }
        }
    }
    
    /**
     * This method calls {@link #addCriteria(String, OperatorId, String)}, passing "EQUALS" as the OperatorId.
     * @see #addCriteria(Criterion)
     */
    public void addCriteria(String field, String value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Integer value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Float value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Date value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Boolean value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, String[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Integer[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Float[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Date[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * This method is similar to {@link #addCriteria(String, String)}.
     */
    public void addCriteria(String field, Boolean[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    
    /**
     * Creates a Criterion and calls {@link #addCriteria(Criterion)}.
     */
    public void addCriteria(String field, OperatorId op, String value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Integer value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Float value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Date value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Boolean value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */ 
    public void addCriteria(String field, OperatorId op, String[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Integer[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Float[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Date[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    /**
     * This method is similar to {@link #addCriteria(String, OperatorId, String)}.
     */
    public void addCriteria(String field, OperatorId op, Boolean[] value) {
        addCriteria(new Criterion(field, op, value));
    }

    public void buildCriterionFromList(OperatorId operator, Criterion[] criterias) {
        setAttribute("operator", operator.getValue());
        setAttribute("criteria", JSOHelper.createJavaScriptArray());
        for (int i = 0; i < criterias.length; i++) appendToCriterionList(criterias[i]);
    }
    
    /**
     * For a Criterion that uses {@link OperatorId.AND} or {@link OperatorId.OR}, add an
     * additional Criterion to the list of subcriteria to be evaluated.
     */
    public void appendToCriterionList(Criterion c) {
        if (c == null) return;
        c.unmarkAdvancedCriteria();
        
        JavaScriptObject listJS = getAttributeAsJavaScriptObject("criteria");
        if (!JSOHelper.isArray(listJS)) {
            String opString = this.getAttributeAsString("operator");
            if ((opString == null) || 
            	 (!opString.equalsIgnoreCase((OperatorId.AND).getValue()) && 
            	  !opString.equalsIgnoreCase((OperatorId.OR).getValue()))) 
            {
                throw new IllegalArgumentException("appendToCriterionList() may only be used with \"and\" or \"or\" operator");
            }
            setAttribute("criteria", JSOHelper.createJavaScriptArray());
            listJS = getAttributeAsJavaScriptObject("criteria");
        }
    
        JSOHelper.setArrayValue(listJS, JSOHelper.getArrayLength(listJS), c.getJsObj());
    }
    
    public void markAdvancedCriteria() {
        setAttribute("_constructor", "AdvancedCriteria");
    }
    
    public void unmarkAdvancedCriteria() {
        JSOHelper.deleteAttributeIfExists(jsObj, "_constructor");
    }

    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public String getValueAsString() {
        return JSOHelper.getAttribute(getJsObj(), "value");
    }
    /**
     * Synonym of {@link #getValueAsInteger()}.
     */
    public final Integer getValueAsInt() {
        return getValueAsInteger();
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public Integer getValueAsInteger() {
        return JSOHelper.getAttributeAsInt(getJsObj(), "value");
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public Float getValueAsFloat() {
        return JSOHelper.getAttributeAsFloat(getJsObj(), "value");
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public Date getValueAsDate() {
        return JSOHelper.getAttributeAsDate(getJsObj(), "value");
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public Boolean getValueAsBoolean() {
        return JSOHelper.getAttributeAsBoolean(getJsObj(), "value");
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public String[] getValueAsStringArray() {
        return JSOHelper.getAttributeAsStringArray(getJsObj(), "value");
    }
    /**
     * Retrieves the specified value for this criterion. Only applies to criterion where operator and value have
     * been specified - will not apply to criterion containing {@link #getCriteria(),sub criteria}.
     * @return
     */
    public int[] getValueAsIntArray() {
        return JSOHelper.getAttributeAsIntArray(getJsObj(), "value");
    }
    

}




