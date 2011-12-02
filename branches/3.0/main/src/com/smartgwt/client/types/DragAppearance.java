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
 
package com.smartgwt.client.types;

/**
 * Different types of effects for showing dragging behavior.
 */
public enum DragAppearance implements ValueEnum {
    /**
     * No default drag appearance is indicated. Your custom dragging routines should implement some behavior that indicates
     * that the user is in a dragging situation, and where the mouse is.
     */
    NONE("none"),
    /**
     * A "drag tracker" object is automatically shown and moved around with the mouse. This is generally set to an icon that
     * represents what is being dragged. The default tracker is a 10 pixel black square, but you can customize this icon. This
     * dragAppearance is not recommended for use with drag resizing or drag moving.
     */
    TRACKER("tracker"),
    /**
     * The target object is actually moved, resized, etc. in real time. This is recommended for drag repositioning, but not for
     * drag resizing of complex objects.
     */
    TARGET("target"),
    /**
     * An outline the size of the target object is moved, resized, etc. with the mouse. This is recommended for drag resizing,
     * especially for objects that take a significant amount of time to draw.
     */
    OUTLINE("outline");

    private String value;

    DragAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
