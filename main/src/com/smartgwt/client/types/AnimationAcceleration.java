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
 * Acceleration effect for animations. Can either be a ratio function or a string. Ratio functions take a value between 0
 * and 1 which represents how much of the  animation's duration has elapsed, and return another value between 0 and 1
 * indicating how close the animation is to completion. For a completely linear animation, the  function would return the
 * value it was passed. This allows you to bias animations to [for example] speed up toward the end of the animation.<br>
 * The following strings are also supported for common ratio bias effects:
 */
public enum AnimationAcceleration implements ValueEnum {
    /**
     * - animation will speed up as time elapses
     */
    SMOOTH_START("smoothStart"),
    /**
     * - animation will slow down as time elapses
     */
    SMOOTH_END("smoothEnd"),
    /**
     * - animation will speed up in the middle
     */
    SMOOTH_START_END("smoothStartEnd"),
    /**
     * - no bias
     */
    NONE("none");

    private String value;

    AnimationAcceleration(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
