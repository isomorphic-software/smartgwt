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
 * The type of date/time editing style to use when editing an event.
 */
public enum DateEditingStyle implements ValueEnum {
    /**
     * allows editing of the logical start and end dates of the event
     */
    DATE("date"),
    /**
     * allows editing of both date and time
     */
    DATETIME("datetime"),
    /**
     * allows editing of the time portion of the event only
     */
    TIME("time");
    private String value;

    DateEditingStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
