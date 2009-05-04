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

public enum PromptStyle implements ValueEnum {
    /**
     * Displays a centered modal prompt with text specified by {@link com.smartgwt.client.rpc.RPCRequest#setPrompt(String) prompt}
     */
    DIALOG("dialog"),
    /**
     * Changes the current cursor to the style specified by  {@link com.smartgwt.client.rpc.RPCRequest#setPromptCursor(String) promptCursor}
     */
    CURSOR("cursor");
    private String value;

    PromptStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

