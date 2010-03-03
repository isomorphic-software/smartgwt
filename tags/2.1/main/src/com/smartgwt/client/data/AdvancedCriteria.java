package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.util.JSOHelper;

public class AdvancedCriteria extends Criteria {
    public AdvancedCriteria(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    public AdvancedCriteria(OperatorId operator, AdvancedCriteria[] criterias) {
        setAttribute("_constructor", "AdvancedCriteria");

        JavaScriptObject criteriaJS = JSOHelper.createJavaScriptArray();

        for (int i = 0; i < criterias.length; i++) {
            Criteria criteria = criterias[i];
            JSOHelper.setArrayValue(criteriaJS, i, criteria.getJsObj());
        }
        setAttribute("operator", operator.getValue());
        setAttribute("criteria", criteriaJS);
    }

    public AdvancedCriteria(String fieldName, OperatorId operator) {
        this(fieldName, operator, null);
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String value) {
        setAttribute("_constructor", "AdvancedCriteria");
        setAttribute("fieldName", fieldName);
        setAttribute("operator", operator.getValue());
        if(value != null) setAttribute("value", value);
    }
}
