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
 * Property to govern when the 'over' styling is applied to a formItemIcon.
 */
public enum IconOverTrigger implements ValueEnum {
    /**
     * Show rollover styling and media when the user is over the icon only
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "icon".
     */
    ICON("icon"),
    /**
     * Show rollover styling and media when the user is over the icon or over the textBox (or control-table, if present) for
     * this icon. Only has an effect when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver
     * FormItem.showOver} is true.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "textBox".
     */
    TEXTBOX("textBox");
    private String value;

    IconOverTrigger(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
