package com.smartgwt.client.types;


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
 
/**
 * Determines how Java enums are translated to and from Javascript by the Smart GWT server.
 */
public enum EnumTranslateStrategy implements ValueEnum {
    /**
     * Translates to/from a String matching the constant name. This is the default if not set.
     */
    STRING("string"),
    /**
     * Translates to/from an integer matching the ordinal number of the constant within  the enumeration
     */
    ORDINAL("ordinal"),
    /**
     * Translates to/from a Javascript object containing one property for each property defined  within the enum. The constant
     * itself and the ordinal number are included in the JS object. By default they are called "_constant" and "_ordinal", but
     * this can be overridden with  the {@link com.smartgwt.client.data.DataSource#getEnumOrdinalProperty enumOrdinalProperty}
     * and {@link com.smartgwt.client.data.DataSource#getEnumConstantProperty enumConstantProperty} properties
     */
    BEAN("bean");
    private String value;

    EnumTranslateStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
