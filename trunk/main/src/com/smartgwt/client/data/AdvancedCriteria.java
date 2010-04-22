package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.OperatorId;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Iterator;
import com.smartgwt.client.util.JSOHelper;

public class AdvancedCriteria extends Criteria {
    public AdvancedCriteria(AdvancedCriteria c) {
        declareAdvancedCriteria();
        JavaScriptObject o;
        o = c.getAttributeAsJavaScriptObject("operator");
        if (o != null) setAttribute("operator", o);
        o = c.getAttributeAsJavaScriptObject("fieldName");
        if (o != null) setAttribute("fieldName", o);
        o = c.getAttributeAsJavaScriptObject("criteria");
        if (o != null) setAttribute("criteria", o);
        o = c.getAttributeAsJavaScriptObject("value");
        if (o != null) setAttribute("value", o);
    }

    public AdvancedCriteria(JavaScriptObject jsObj) {
        super(jsObj);
        declareAdvancedCriteria();
    }

    public AdvancedCriteria(OperatorId operator, AdvancedCriteria[] criterias) {
        declareAdvancedCriteria();
        buildAdvancedCriteriaFromList(operator, criterias);
    }
    
    public AdvancedCriteria(OperatorId operator) {
        declareAdvancedCriteria();
        setAttribute("operator", operator.getValue());
    }
    
    private AdvancedCriteria() {
        setIsAdvancedCriteria(true);
    }
    
    public AdvancedCriteria(OperatorId operator, Criteria[] criterias) {
        this();
        buildAdvancedCriteria(operator, criterias);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator) {
        declareAdvancedCriteria();
        setAttribute("fieldName", fieldName);
        setAttribute("operator", operator.getValue());
    }
    
    public <T> AdvancedCriteria(String fieldName, OperatorId operator, T value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
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
    public void addCriteria(AdvancedCriteria c) {
        if (this.getAttributeAsString("operator") == OperatorId.AND.getValue()) {
            appendToCriterionList(c);
        } else {
            AdvancedCriteria thisCopy = new AdvancedCriteria(this);
            
            JavaScriptObject o;
            o = getAttributeAsJavaScriptObject("fieldName");
            if (o != null) JSOHelper.deleteAttribute(jsObj, "fieldName");
            o = getAttributeAsJavaScriptObject("value");
            if (o != null) JSOHelper.deleteAttribute(jsObj, "value");
            
            AdvancedCriteria[] criteriaList = { thisCopy, c };
            buildAdvancedCriteriaFromList(OperatorId.AND, criteriaList);
        }
    }
    
    /**
     * @see #addCriteria(AdvancedCriteria)
     */
    public <T> void addCriteria(String field, T value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }
    /**
     * @see #addCriteria(AdvancedCriteria)
     */
    public <T> void addCriteria(String field, OperatorId op, T value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    private void declareAdvancedCriteria() {
        setAttribute("_constructor", "AdvancedCriteria");
    }
    
    private void buildAdvancedCriteriaFromList(OperatorId operator, AdvancedCriteria[] criterias) {
        setAttribute("operator", operator.getValue());
        setAttribute("criteria", JSOHelper.createJavaScriptArray());
        for (int i = 0; i < criterias.length; i++) appendToCriterionList(criterias[i]);
    }
    
    public void appendToCriterionList(AdvancedCriteria c) {
        // This is a Criterion list - AdvancedCriteria has _constructor set; Criterion doesn't
        JavaScriptObject o;
        o = getAttributeAsJavaScriptObject("_constructor");
        if (o != null) JSOHelper.deleteAttribute(jsObj, "_constructor");
        
        JavaScriptObject listJS = getAttributeAsJavaScriptObject("criteria");
        if (!JSOHelper.isArray(listJS)) 
            SC.logWarn("appendToCriterionList called when no criterion list exists");
        
        JSOHelper.setArrayValue(listJS, JSOHelper.getArrayLength(listJS), c.getJsObj());
    }
}
