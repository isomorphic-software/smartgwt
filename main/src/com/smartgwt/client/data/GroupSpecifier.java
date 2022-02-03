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

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.util.JSOHelper;

/**
 * Class defining the details of a single group operation
 */
public class GroupSpecifier extends DataClass {

    public native static GroupSpecifier getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            instance = @com.smartgwt.client.data.GroupSpecifier::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
        return instance;
    }-*/;


    public GroupSpecifier(String property) {
        setField(property);
    }
    public GroupSpecifier(String property, String grouping) {
        setField(property);
        setGrouping(grouping);
    }

    public GroupSpecifier(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The groupingMode to applied to associated field.
     *
     * @param grouping the groupingMode
     */
    public void setGrouping(String grouping) {
        JSOHelper.setAttribute(jsObj, "grouping", grouping);
    }

    /**
     * The groupingMode applied to the associated field.
     *
     * @return the groupingMode
     */
    public String getGrouping() {
        return JSOHelper.getAttribute(jsObj, "grouping");
    }

    /**
     * The fieldName to which this groupSpecifier applies
     *
     * @param field the field name
     */
    public void setField(String field) {
        JSOHelper.setAttribute(jsObj, "property", field);
    }

    /**
     * The fieldName to which this groupSpecifier applies
     *
     * @return the field name
     */
    public String getField() {
        return JSOHelper.getAttribute(jsObj, "property");

    }

    public static GroupSpecifier[] convertToArray(String groupByString) {
        if (groupByString == null) {
            return new GroupSpecifier[]{};
        }
        String[] groupFields = groupByString.split(",");
        GroupSpecifier[] groupSpecifiers = new GroupSpecifier[groupFields.length];
        for (int i = 0; i < groupFields.length; i++) {
            String groupField = groupFields[i];
            groupSpecifiers[i] = new GroupSpecifier(groupField);
        }
        return groupSpecifiers;
    }

    public static GroupSpecifier[] convertToArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new GroupSpecifier[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            GroupSpecifier[] objects = new GroupSpecifier[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                GroupSpecifier obj = new GroupSpecifier(componentJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            GroupSpecifier[] ret = new GroupSpecifier[1];
            ret[0] = new GroupSpecifier(nativeArray);
            return ret;
        }
    }
}
