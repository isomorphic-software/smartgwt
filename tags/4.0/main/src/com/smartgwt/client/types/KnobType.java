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
 
/**
 * Entries for the {@link com.smartgwt.client.widgets.drawing.DrawItem#getKnobs knobs} array. Each specified knobType will
 * enable some UI  allowing the user to manipulate the drawItem directly.
 */
public enum KnobType implements ValueEnum {
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawRect} and {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.</i> Display up to 4 control knobs at the corners specified by {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getResizeKnobPoints resizeKnobPoints}, allowing the user to drag-resize the
     * item.
     */
    RESIZE("resize"),
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawRect}, {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}, {@link com.smartgwt.client.widgets.drawing.DrawLine}, and {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath}.</i> Display a control knob for moving the item around. See also
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobPoint moveKnobPoint} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}
     */
    MOVE("move"),
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawLine} {@link com.smartgwt.client.widgets.drawing.DrawCurve}
     * and {@link com.smartgwt.client.widgets.drawing.DrawLinePath}.</i> Control knob to manipulate {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint}.
     */
    STARTPOINT("startPoint"),
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawLine}, {@link
     * com.smartgwt.client.widgets.drawing.DrawCurve} and {@link com.smartgwt.client.widgets.drawing.DrawLinePath}.</i> Control
     * knob to manipulate {@link com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint}.
     */
    ENDPOINT("endPoint"),
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawCurve} only.</i> Display a draggable control knob along
     * with a drawLine indicating angle between controlPoint1 and startPoint for this drawCurve. Dragging the knob will adjust
     * {@link com.smartgwt.client.widgets.drawing.DrawCurve#getControlPoint1 controlPoint1}
     */
    CONTROLPOINT1("controlPoint1"),
    /**
     * <i>Applies to {@link com.smartgwt.client.widgets.drawing.DrawCurve} only.</i> Display a draggable control knob along
     * with a drawLine indicating angle between controlPoint2 and endPoint for this drawCurve. Dragging the knob will adjust
     * {@link com.smartgwt.client.widgets.drawing.DrawCurve#getControlPoint2 controlPoint2}
     */
    CONTROLPOINT2("controlPoint2");
    private String value;

    KnobType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
