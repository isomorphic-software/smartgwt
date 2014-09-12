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
 */
public enum DrawShapeCommandType implements ValueEnum {
    /**
     * Draws a straight line from the current point to the last "moveto" point. There are no arguments.
     */
    CLOSE("close"),
    /**
     * Start a new sub-path at a given (x,y) coordinate. The args array for this command type is a two-element array of the X
     * and Y coordinates.
     */
    MOVETO("moveto"),
    /**
     * Draw a line from the current point to the given (x,y) coordinate which becomes the new current point. Multiple (x,y)
     * coordinates may be specified to draw a path, in which case the last point becomes the new current point. The args array
     * for this command type is an array of one or more Points (two-element arrays of the X and Y coordinates).
     */
    LINETO("lineto"),
    /**
     * Draw a segment of a specified circle. A straight line (the "initial line segment") is drawn from the current point to
     * the start of the circular arc. The args array for this command type contains 4 values: <ol start="0"> <li>The center
     * (cx,cy) Point (two-element array) of the circle.</li> <li>radius</li> <li>startAngle - Start angle in degrees</li>
     * <li>endAngle - End angle in degrees</li> </ol> Note that the <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#circletoCommand" target="examples">"circleto" Command example</a>
     * can be very helpful when learning how to write "circleto" commands.
     */
    CIRCLETO("circleto");
    private String value;

    DrawShapeCommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
