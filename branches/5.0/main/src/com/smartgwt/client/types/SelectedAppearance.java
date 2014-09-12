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
 * Appearance when selected in editMode.
 */
public enum SelectedAppearance implements ValueEnum {
    /**
     * editMask on top of the component is updated with {@link com.smartgwt.client.tools.EditProxy#getSelectedTintColor
     * selectedTintColor} and {@link com.smartgwt.client.tools.EditProxy#getSelectedTintOpacity selectedTintOpacity}
     */
    TINTMASK("tintMask"),
    /**
     * editMask on top of the component is updated with {@link com.smartgwt.client.tools.EditProxy#getSelectedBorder
     * selectedBorder}
     */
    OUTLINEMASK("outlineMask"),
    /**
     * MultiAutoChild is created on top of the component. This constructs a border around the component using 4 separate
     * <code>outlineEdge</code> components so that interactivity is not blocked.
     */
    OUTLINEEDGES("outlineEdges"),
    /**
     * no change in appearance. Override {@link com.smartgwt.client.tools.EditProxy#showSelectedAppearance
     * EditProxy.showSelectedAppearance} to create a custom appearance.
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
