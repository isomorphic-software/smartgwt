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
 * Entries for the {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs DrawItem.knobs} array. Each specified
 * knobType will enable some UI  allowing the user to manipulate the DrawItem directly. <p> <b>NOTE:</b> Not all knob types
 * are supported by each DrawItem type. Refer to the DrawItem type's {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs} attribute documentation for a list of the supported knob
 * types.
 */
public enum KnobType implements ValueEnum {
    /**
     * Display up to 8 control knobs at the corners specified by {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints DrawItem.resizeKnobPoints}, allowing the user to
     * drag-resize the item. See also {@link com.smartgwt.client.widgets.drawing.DrawItem#getCornerResizeKnob
     * DrawItem.cornerResizeKnob} and {@link com.smartgwt.client.widgets.drawing.DrawItem#getSideResizeKnob
     * DrawItem.sideResizeKnob}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "resize".
     */
    RESIZE("resize"),
    /**
     * Display a control knob for moving the item around. See also {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint DrawItem.moveKnobPoint} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset DrawItem.moveKnobOffset}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "move".
     */
    MOVE("move"),
    /**
     * Control knob to manipulate {@link com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint DrawLine.startPoint}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "startPoint".
     */
    STARTPOINT("startPoint"),
    /**
     * Control knob to manipulate {@link com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint DrawLine.endPoint}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "endPoint".
     */
    ENDPOINT("endPoint"),
    /**
     * Display a draggable control knob along with a DrawLine indicating the angle between controlPoint1 and the startPoint.
     * Dragging the knob will adjust controlPoint1.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "controlPoint1".
     */
    CONTROLPOINT1("controlPoint1"),
    /**
     * Display a draggable control knob along with a DrawLine indicating the angle between controlPoint2 and the endPoint.
     * Dragging the knob will adjust controlPoint2.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "controlPoint2".
     */
    CONTROLPOINT2("controlPoint2"),
    /**
     * Display a rotation knob above the top resize knob, allowing the user to rotate the item. See also {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getRotateKnob DrawItem.rotateKnob}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "rotate".
     */
    ROTATE("rotate");
    private String value;

    KnobType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
