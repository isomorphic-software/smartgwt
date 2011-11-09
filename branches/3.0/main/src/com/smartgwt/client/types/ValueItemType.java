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

package com.smartgwt.client.types;

/**
 */

public enum ValueItemType implements ValueEnum {
    
    /**
     * This is the single form item that will populate the generated criteria.value for this clause. 
     * This applies for operators with Operator.valueType of "fieldType" or "custom".
     */
    VALUE("value"),
    
    /**
     *  This is the single form item that will populated the generated criteria.value for Operator.valueType 
     *  of "fieldName".
     */
    NAME("name"),
    
    /**
     * Indicates this item will generate the lower-bound value (or "start") when generating criteria with
     * Operator.valueType "valueRange".
     */
    START("start"),
    
    /**
     * Indicates this item will generate the higher-bound value (or "end") when generating criteria with
     * Operator.valueType "valueRange".
     */
    END("end");
    
    private String value;

    ValueItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

