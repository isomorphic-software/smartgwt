package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.OperatorId;
import java.util.Date;
import com.smartgwt.client.util.JSOHelper;

public class AdvancedCriteria extends Criteria {
    public AdvancedCriteria(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    private void setIsAdvancedCriteria(boolean isAdvanced) {
        if (isAdvanced) setAttribute("_constructor", "AdvancedCriteria");
        else JSOHelper.setNullAttribute(jsObj, "_constructor");
    }
    
    private void buildAdvancedCriteria(OperatorId operator, Criteria[] criterias) {
        JavaScriptObject criteriaJS = JSOHelper.createJavaScriptArray();

        for (int i = 0; i < criterias.length; i++) {
            Criteria criteria = criterias[i];
            // This is a Criterion list - AdvancedCriteria has _constructor set;
            // Criterion doesn't
            if (criteria.getAttributeAsObject("_constructor") != null) {
                JSOHelper.deleteAttribute(criteria.getJsObj(), "_constructor");
            }
            JSOHelper.setArrayValue(criteriaJS, i, criteria.getJsObj());
        }
        setAttribute("operator", operator.getValue());
        setAttribute("criteria", criteriaJS);
    }
    
    private AdvancedCriteria() {
        setIsAdvancedCriteria(true);
    }
    
    public AdvancedCriteria(OperatorId operator, Criteria[] criterias) {
        this();
        buildAdvancedCriteria(operator, criterias);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator) {
        this();
        setAttribute("fieldName", fieldName);
        setAttribute("operator", operator.getValue());
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Integer value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Date value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Float value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String[] value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Integer[] value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean[] value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Date[] value) {
        this(fieldName, operator);
        if(value != null) setAttribute("value", value);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Float[] value) {
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
    public void addCriteria(Criteria otherCriteria) {
        if (this.getAttributeAsString("operator") == OperatorId.AND.getValue()) {
            JavaScriptObject criteriaJS = getAttributeAsJavaScriptObject("operator");
            JSOHelper.setArrayValue(criteriaJS, JSOHelper.getArrayLength(criteriaJS), 
                otherCriteria.getJsObj());
        } else {
            AdvancedCriteria thisCopy = new AdvancedCriteria(jsObj);
            JSOHelper.deleteAttribute(jsObj, "fieldName");
            Criteria[] criteriaList = { (Criteria) thisCopy, otherCriteria };
            buildAdvancedCriteria(OperatorId.AND, criteriaList);
        }
    }
    
    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, String value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, String value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Integer value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Integer value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Boolean value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Boolean value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Date value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Date value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Float value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Float value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, String[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, String[] value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Integer[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Integer[] value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Boolean[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Boolean[] value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Date[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Date[] value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, Float[] value) {
        addCriteria(field, OperatorId.EQUALS, value);
    }

    /**
     * @see #addCriteria(Criteria)
     */
    public void addCriteria(String field, OperatorId op, Float[] value) {
        addCriteria(new AdvancedCriteria(field, op, value));
    }
}
