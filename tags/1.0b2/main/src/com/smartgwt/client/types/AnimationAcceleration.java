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
 * Acceleration effect for animations. Can either be a ratio function or a string.&#010 Ratio functions take a value
 * between 0 and 1 which represents how much of the &#010 animation's duration has elapsed, and return another value
 * between 0 and 1 indicating&#010 how close the animation is to completion. For a completely linear animation, the
 * &#010 function would return the value it was passed. This allows you to bias animations to&#010 [for example] speed
 * up toward the end of the animation.<br>&#010 The following strings are also supported for common ratio bias
 * effects:&#010 <ul>&#010 <li>"smoothStart" - animation will speed up as time elapses&#010 <li>"smoothEnd" - animation
 * will slow down as time elapses&#010 <li>"smoothStartEnd" - animation will speed up in the middle&#010 <li>"none" - no
 * bias</ul>
 */

public enum AnimationAcceleration implements ValueEnum {
    SMOOTH_START("smoothStart"),
    SMOOTH_END("smoothEnd"),
    SMOOTH_START_END("smoothStartEnd"),
    NONE("none");

    private String value;

    AnimationAcceleration(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

