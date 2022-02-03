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
 * Appearance when a component is in {@link com.smartgwt.client.widgets.Canvas#setEditMode edit mode} and is selected.  
 * <p> Modes such as "tintMask" or "outlineMask" create an  {@link com.smartgwt.client.tools.EditProxy#getEditMask "edit
 * mask"} that is layered over the selected component, and  blocks all normal interaction with the component, so that
 * behaviors like {@link com.smartgwt.client.tools.EditProxy#getSupportsInlineEdit EditProxy.supportsInlineEdit} can
 * completely take the place of the component's normal interactivity. <p> "outlineEdges" mode allows normal interaction
 * with the component, which allows the end user to do things like {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields freeze ListGrid fields}, which the {@link
 * com.smartgwt.client.tools.GridEditProxy} can implement as a  {@link
 * com.smartgwt.client.tools.GridEditProxy#getSaveFieldFrozenState persistent change to grid's configuration}.
 */
public enum SelectedAppearance implements ValueEnum {
    /**
     * editMask on top of the component is updated with {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     * EditProxy.selectedTintColor} and {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity
     * EditProxy.selectedTintOpacity}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "tintMask".
     */
    TINTMASK("tintMask"),
    /**
     * editMask on top of the component is updated with {@link com.smartgwt.client.tools.EditProxy#getSelectedBorder
     * EditProxy.selectedBorder}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "outlineMask".
     */
    OUTLINEMASK("outlineMask"),
    /**
     * MultiAutoChild is created on top of the component. This constructs a border around the component using 4 separate
     * <code>outlineEdge</code> components so that interactivity is not blocked.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "outlineEdges".
     */
    OUTLINEEDGES("outlineEdges"),
    /**
     * no change in appearance. Override {@link com.smartgwt.client.tools.EditProxy#showSelectedAppearance
     * EditProxy.showSelectedAppearance()} to create a custom appearance.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    SelectedAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
