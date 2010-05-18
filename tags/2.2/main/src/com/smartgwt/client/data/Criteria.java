/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.util.JSOHelper;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Criteria for selecting only a matching set of records from a DataSource. Criteria can be applied on the client and
 * server. Unless configured otherwise, criteria will generally be applied client-side by ResultSets via
 * ResultSet.applyFilter(). <br> The criteria format supported by the SmartClient Server built-in SQLDataSource and
 * HibernateDataSource is a JavaScript Object where each property specifies the name and required value for a field.
 * Multiple legal values for a field can be provided as an Array.
 */
public class Criteria extends DataClass {

    public Criteria() {
    }

    public Criteria(String field, String value) {
        this();
        addCriteria(field, value);
    }

    public Criteria(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    private native boolean fieldIsArray(String field) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return $wnd.isc.isA.Array(self[field]);
    }-*/;
    
    private native boolean fieldIsNull(String field) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return (self[field] == null);
    }-*/;
    
    public void addCriteria(String field, String value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            JavaScriptObject array = JSOHelper.getAttributeAsJavaScriptObject(jsObj, field);
            JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value);
        } else {
            String[] newArray = { getAttributeAsString(field), value };
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, Integer value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            JavaScriptObject array = JSOHelper.getAttributeAsJavaScriptObject(jsObj, field);
            JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value.intValue());
        } else {
            Integer[] newArray = { JSOHelper.getAttributeAsInt(jsObj, field), value };
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, Boolean value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            JavaScriptObject array = JSOHelper.getAttributeAsJavaScriptObject(jsObj, field);
            JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value.booleanValue());
        } else {
            Boolean[] newArray = { JSOHelper.getAttributeAsBoolean(jsObj, field), value };
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, Date value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            JavaScriptObject array = JSOHelper.getAttributeAsJavaScriptObject(jsObj, field);
            JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value);
        } else {
            Date[] newArray = { JSOHelper.getAttributeAsDate(jsObj, field), value };
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, Float value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            JavaScriptObject array = JSOHelper.getAttributeAsJavaScriptObject(jsObj, field);
            JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value.floatValue());
        } else {
            Float[] newArray = { JSOHelper.getAttributeAsFloat(jsObj, field), value };
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, String[] value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            ArrayList<String> newArray = new ArrayList<String>();
            newArray.addAll(Arrays.asList(JSOHelper.getAttributeAsStringArray(jsObj, field)));
            newArray.addAll(Arrays.asList(value));
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray.toArray()));
        } else {
            ArrayList<String> newArray = new ArrayList<String>();
            newArray.add(getAttributeAsString(field));
            newArray.addAll(Arrays.asList(value));
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray.toArray()));
        }
    }

    public void addCriteria(String field, Integer[] value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            int[] oldArray = JSOHelper.getAttributeAsIntArray(jsObj, field);
            Integer[] newArray = new Integer[oldArray.length+value.length];
            for (int i=0; i<oldArray.length; i++) newArray[i] = new Integer(oldArray[i]);
            for (int i=0; i<value.length; i++) newArray[i+oldArray.length] = value[i];
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        } else {
            Integer[] newArray = new Integer[value.length+1];
            newArray[0] = new Integer(JSOHelper.getAttributeAsInt(jsObj, field));
            for (int i=0; i<value.length; i++) newArray[i+1] = value[i];
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    public void addCriteria(String field, Double[] value) {
        if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
        else if (fieldIsArray(field)) {
            double[] oldArray = JSOHelper.getAttributeAsDoubleArray(jsObj, field);
            Double[] newArray = new Double[oldArray.length+value.length];
            for (int i=0; i<oldArray.length; i++) newArray[i] = new Double(oldArray[i]);
            for (int i=0; i<value.length; i++) newArray[i+oldArray.length] = value[i];
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        } else {
            Double[] newArray = new Double[value.length+1];
            newArray[0] = new Double(JSOHelper.getAttributeAsDouble(jsObj, field));
            for (int i=0; i<value.length; i++) newArray[i+1] = value[i];
            setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
        }
    }

    /**
     * Adds the criteria from the passed criteria object.
     *
     * @param otherCriteria the passed criteria object
     */
    public void addCriteria(Criteria otherCriteria) {
        Map otherMap = otherCriteria.getValues();
        Set otherKeys = otherMap.keySet();
        for (Iterator i=otherKeys.iterator(); i.hasNext(); ) {
            String field = (String) i.next();
            Object value = otherMap.get(field);

            if (value instanceof Integer) {
                addCriteria(field, (Integer) value);
            } else if (value instanceof Float) {
                addCriteria(field, (Float) value);
            } else if (value instanceof String) {
                addCriteria(field, (String) value);
            } else if (value instanceof Date) {
                addCriteria(field, (Date) value);
            } else if (value instanceof Boolean) {
                addCriteria(field, (Boolean) value);
            } else {
                if (fieldIsNull(field)) JSOHelper.setAttribute(jsObj, field, value);
                else if (fieldIsArray(field)) {
                    JavaScriptObject array = getAttributeAsJavaScriptObject(field);
                    JSOHelper.setArrayValue(array, JSOHelper.arrayLength(array), value);
                } else {
                    Object[] newArray = { getAttributeAsObject(field), value };
                    setAttribute(field, JSOHelper.convertToJavaScriptArray(newArray));
                }
            }
        }
    }

    /**
     * Return the criteria values as a name-value Map.
     *
     * @return the criteria values as a Map
     */
    public Map getValues() {
        return JSOHelper.convertToMap(jsObj);
    }
}
