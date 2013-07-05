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
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.util.EnumUtil;
import com.smartgwt.client.util.JSOHelper;

/**
 * Class defining the details of a single sort operation
 */
public class SortSpecifier extends DataClass {

    public SortSpecifier(String fieldName, SortDirection sortDirection) {
        setField(fieldName);
        setDirection(sortDirection);
    }

    public SortSpecifier(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The direction in which this specifier should sort.
     *
     * @param sortDirection the sortDirection
     */
    public void setDirection(SortDirection sortDirection) {
        JSOHelper.setAttribute(jsObj, "direction", sortDirection.getValue());
    }

    /**
     * The direction in which this specifier should sort.
     *
     * @return the sortDirection
     */
    public SortDirection getSortDirection() {
        return EnumUtil.getEnum(SortDirection.values(), getAttribute("direction"));

    }

    /**
     * The fieldName to which this sortSpecifier applies
     *
     * @param field the field name
     */
    public void setField(String field) {
        JSOHelper.setAttribute(jsObj, "property", field);
    }

    /**
     * The field name to which this sortSpecifier applies
     *
     * @return the field name
     */
    public String getField() {
        return JSOHelper.getAttribute(jsObj, "property");

    }

    public static SortSpecifier[] convertToArray(String sortByString) {
        if (sortByString == null) {
            return new SortSpecifier[]{};
        }
        String[] sortFields = sortByString.split(",");
        SortSpecifier[] sortSpecifiers = new SortSpecifier[sortFields.length];
        for (int i = 0; i < sortFields.length; i++) {
            String sortField = sortFields[i];
            SortDirection sortDirection = SortDirection.ASCENDING;
            if(sortField.startsWith("-")) {
                sortDirection = SortDirection.DESCENDING;
                sortField = sortField.substring(1, sortField.length());
            }
            sortSpecifiers[i] = new SortSpecifier(sortField, sortDirection);
        }
        return sortSpecifiers;
    }

    public static SortSpecifier[] convertToArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new SortSpecifier[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            SortSpecifier[] objects = new SortSpecifier[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                SortSpecifier obj = new SortSpecifier(componentJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            SortSpecifier[] ret = new SortSpecifier[1];
            ret[0] = new SortSpecifier(nativeArray);
            return ret;
        }
    }
}
