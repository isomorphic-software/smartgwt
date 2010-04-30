package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.OperatorId;
import java.util.Date;

public class AdvancedCriteria extends Criterion {
    public AdvancedCriteria(Criterion c) {
        super(c);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(JavaScriptObject jsObj) {
        super(jsObj);
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
    
    private AdvancedCriteria() {
        super();
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
