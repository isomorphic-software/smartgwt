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
 * What to do if the user hits Up or Down arrow key while editing a cell.
 */
public enum ArrowKeyEditAction implements ValueEnum {
    /**
     * The grid will take no special action when the user presses up or down arrow keys within an editor
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * The grid will intercept up and down arrow keypresses and navigate to the next or previous edit row by generating an
     * appropriate {@link com.smartgwt.client.types.EditCompletionEvent}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "editNext".
     */
    EDITNEXT("editNext");
    private String value;

    ArrowKeyEditAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
