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
 * Constants for the standard states for a StatefulCanvas.
 */
public enum State implements ValueEnum {
    /**
     * state when mouse is not acting on this StatefulCanvas
     */
    STATE_UP(""),
    /**
     * state when mouse is down
     */
    STATE_DOWN("Down"),
    /**
     * state when mouse is over
     */
    STATE_OVER("Over"),
    /**
     * disabled
     */
    STATE_DISABLED("Disabled");
    private String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
