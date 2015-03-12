/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2015 and beyond, Isomorphic Software, Inc.
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

import java.util.Map;
import com.smartgwt.client.widgets.Canvas;

/**
 * Provides a way to override the default behavior of
 * {@link com.smartgwt.client.data.SimpleType#getGroupValue SimpleType.getGroupValue()}.
 */
public abstract class GroupValueFunction {

    private SimpleType simpleType;

    public void setSimpleType(SimpleType simpleType) {
        this.simpleType = simpleType;
    }    

    /**
     * Returns the SimpleType object being customized
     * @return cutomized SimpleType object
     */
    public SimpleType getSimpleType() {
        return this.simpleType;
    }

	/**
     * Calls the default implementation of 
     * {@link com.smartgwt.client.data.SimpleType#getGroupValue SimpleType.getGroupValue()}.
     * @param value the record value to return a group value for
     * @param record the record containing the passed group value
     * @param field the field relating to the value to be processed
     * @param fieldName the name of the field relating to the value to be processed
     * @param component the component, usually a {@link com.smartgwt.client.widgets.grid.ListGrid}, 
     * containing the passed record
     *
     * @return the group value for the passed parameters
     */
    public native String executeDefault(Object value, Record record, Map field, String fieldName, Canvas component) /*-{
        var simpleType = this.@com.smartgwt.client.data.GroupValueFunction::simpleType,
            self = simpleType.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if (!self._getGroupValue) return null;
        var ret = self._getGroupValue(value, record.@com.smartgwt.client.core.DataClass::getJsObj()(), 
            field == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(field), 
            fieldName, component == null ? null : component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Defines new behavior to override 
     * {@link com.smartgwt.client.data.SimpleType#getGroupValue SimpleType.getGroupValue()}.
     * @param value the record value to return a group value for
     * @param record the record containing the passed group value
     * @param field the field relating to the value to be processed
     * @param fieldName the name of the field relating to the value to be processed
     * @param component the component, usually a {@link com.smartgwt.client.widgets.grid.ListGrid}, 
     * containing the passed record
     *
     * @return the group value for the passed parameters
     */
    public abstract String getValue(Object value, Record record, Map field, String fieldName,
                                    Canvas component);
}
