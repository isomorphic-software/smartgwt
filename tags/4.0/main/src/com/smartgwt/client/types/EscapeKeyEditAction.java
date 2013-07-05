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
 * What to do if the user hits escape while editing a cell.
 */
public enum EscapeKeyEditAction implements ValueEnum {
    /**
     * cancels the current edit and discards edit values
     */
    CANCEL("cancel"),
    /**
     * end editing (will save edit values if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}
     * is true).
     */
    DONE("done"),
    /**
     * exit the editor (edit values will be left intact but not saved).
     */
    EXIT("exit");
    private String value;

    EscapeKeyEditAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
