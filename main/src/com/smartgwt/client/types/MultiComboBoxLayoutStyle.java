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
 * Specifies the layout of the combo box and buttons in a MultiComboBoxItem.
 */
public enum MultiComboBoxLayoutStyle implements ValueEnum {
    /**
     * Use a flow layout
     */
    FLOW("flow"),
    /**
     * Use a horizontal layout with the combo box on the right
     */
    HORIZONTAL("horizontal"),
    /**
     * Use a horizontal layout with the combo box on the left
     */
    HORIZONTALREVERSE("horizontalReverse"),
    /**
     * Use a vertical layout
     */
    VERTICAL("vertical"),
    /**
     * Use a vertical layout with the combo box at the bottom
     */
    VERTICALREVERSE("verticalReverse");
    private String value;

    MultiComboBoxLayoutStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
