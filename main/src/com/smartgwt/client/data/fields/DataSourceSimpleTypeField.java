/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data.fields;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.types.FieldType;

/**
 * A DataSourceField that is based on a user created {@link SimpleType}. For example, a user can create
 * a reusable ZipCode SimpleType class with a regular expression based {@link com.smartgwt.client.widgets.form.validator.Validator}
 * and then use this SimpleType in various DataSourceField definitions across their application.
 * <p>
 * This is a powerful feature which allows creation and resuse of domain specific "primitive" data types or types in the enterprises
 * Common Data Model (CDM).
 */
public class DataSourceSimpleTypeField extends DataSourceField {

    public DataSourceSimpleTypeField(String name, SimpleType simpleType) {
        setName(name);
        setType(simpleType);
    }

    public DataSourceSimpleTypeField(String name, SimpleType simpleType, String title) {
        this(name, simpleType);
        setTitle(title);
    }

    public DataSourceSimpleTypeField(String name, SimpleType simpleType, String title, int length) {
        this(name, simpleType, title);
        setLength(length);
    }

    public DataSourceSimpleTypeField(String name, SimpleType simpleType, String title, int length, boolean required) {
        this(name, simpleType, title, length);
        setRequired(required);
    }
}
