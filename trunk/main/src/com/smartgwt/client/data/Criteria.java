package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.util.JSOHelper;

import java.util.Date;

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

    public void addCriteria(String field, String value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Integer value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Boolean value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Date value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Float value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, String[] value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Integer[] value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Boolean[] value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Date[] value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    public void addCriteria(String field, Float[] value) {
        JSOHelper.setAttribute(jsObj, field, value);
    }

    /**
     * Adds the criteria from the passed criteria object.
     *
     * @param otherCriteria the passed criteria object
     */
    public void addCriteria(Criteria otherCriteria) {
        JSOHelper.addProperties(jsObj, otherCriteria.getJsObj());
    }
}
