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
/* sgwtgen */
 
/**
 * The strategy to use when generating field names - for example, for new formula or summary  fields created using the
 * built-in editors.
 */
public enum FieldNamingStrategy implements ValueEnum {
    /**
     * generate names in the format fieldTypeX, where field type might be "formulaField" and X is an index specific to the
     * field-type and component instance
     */
    SIMPLE("simple"),
    /**
     * generates a UUID for all generated field names
     */
    UUID("uuid");
    private String value;

    FieldNamingStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
