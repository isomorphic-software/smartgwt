package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.OperatorId;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Iterator;
import com.smartgwt.client.util.JSOHelper;

public class Criterion extends Criteria {
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

    public Criterion(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public Criterion(OperatorId operator, Criterion[] criterias) {
        buildCriterionFromList(operator, criterias);
    }
    
    public Criterion(OperatorId operator) {
        setAttribute("operator", operator.getValue());
    }
    
    public Criterion() {
    }
    
    public Criterion(String fieldName, OperatorId operator) {
        setAttribute("fieldName", fieldName);
        setAttribute("operator", operator.getValue());
    }
    
    public Criterion(String fieldName, OperatorId operator, Integer value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }
    
    public Criterion(String fieldName, OperatorId operator, String value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    public Criterion(String fieldName, OperatorId operator, Float value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    public Criterion(String fieldName, OperatorId operator, Date value) {
        this(fieldName, operator);
        setAttribute("value", value);
    }

    public Criterion(String fieldName, OperatorId operator, Boolean value) {
        this(fieldName, operator);
        setAttribute("value", value);
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
     * <p>Otherwise, the present criteria is replaced with an "and" 
     * criteria, with two sub-criteria: the present criteria, and the passed criteria.
     *
     * @param otherCriteria the passed criteria object
     */
    public void addCriteria(Criterion c) {
        if (this.getAttributeAsString("operator").equals(OperatorId.AND.getValue())) {
            appendToCriterionList(c);
        } else {
            Criterion thisCopy = new Criterion(this);
            JSOHelper.deleteAttributeIfExists(jsObj, "fieldName");
            JSOHelper.deleteAttributeIfExists(jsObj, "value");
            Criterion[] criteriaList = { thisCopy, c };
            buildCriterionFromList(OperatorId.AND, criteriaList);
        }
    }
    
    /**
     * @see #addCriteria(Criterion)
     */
    public void addCriteria(String field, String value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Integer value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Float value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Date value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Boolean value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, String[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Integer[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Float[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Date[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    public void addCriteria(String field, Boolean[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    
    /**
     * @see #addCriteria(Criterion)
     */
    public void addCriteria(String field, OperatorId op, String value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Integer value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Float value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Date value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Boolean value) {
        addCriteria(new Criterion(field, op, value));
    } 
    public void addCriteria(String field, OperatorId op, String[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Integer[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Float[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Date[] value) {
        addCriteria(new Criterion(field, op, value));
    }
    public void addCriteria(String field, OperatorId op, Boolean[] value) {
        addCriteria(new Criterion(field, op, value));
    }

    public void buildCriterionFromList(OperatorId operator, Criterion[] criterias) {
        setAttribute("operator", operator.getValue());
        setAttribute("criteria", JSOHelper.createJavaScriptArray());
        for (int i = 0; i < criterias.length; i++) appendToCriterionList(criterias[i]);
    }
    
    public void appendToCriterionList(Criterion c) {
        c.unmarkAdvancedCriteria();
        
        JavaScriptObject listJS = getAttributeAsJavaScriptObject("criteria");
        if (!JSOHelper.isArray(listJS)) {
            SC.logWarn("appendToCriterionList called when no criterion list exists");
            return;
        }
        
        JSOHelper.setArrayValue(listJS, JSOHelper.getArrayLength(listJS), c.getJsObj());
    }
    
    public void markAdvancedCriteria() {
        setAttribute("_constructor", "Criterion");
    }
    
    public void unmarkAdvancedCriteria() {
        JSOHelper.deleteAttributeIfExists(jsObj, "_constructor");
    }
}
