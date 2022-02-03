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
 * Affects the appearance and behavior of the builtin SavedSearchEditor.
 */
public enum SearchEditorMode implements ValueEnum {
    /**
     * the editor shows a {@link com.smartgwt.client.widgets.form.FilterBuilder} for editing criteria
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "normal".
     */
    NORMAL("normal"),
    /**
     * the editor shows only a field for naming (or renaming) a search, since the grid has built-in interfaces for editing
     * criteria
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "grid".
     */
    GRID("grid");
    private String value;

    SearchEditorMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
