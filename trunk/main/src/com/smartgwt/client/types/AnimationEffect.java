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


public enum AnimationEffect implements ValueEnum {
    /**
     * content slides out of view as the window shrinks
     */
    SLIDE("slide"),

    /**
     * default: content is clipped as the window shrinks
     */
    WIPE("wipe"),

    /**
     * widget fades out of view, from current opacity to transparent
     */
    FADE("fade"),

    /**
     * widget moves offscreen to the left of its drawn position
     */
    FLY("fly");

    private String value;

    AnimationEffect(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
