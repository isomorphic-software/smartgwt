/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2014 and beyond, Isomorphic Software, Inc.
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
 
package com.smartgwt.client.widgets;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;

public abstract class AdaptHeightByCustomizer {
    private Canvas canvas;

    protected void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Returns the Canvas associated with this customizer.
     * @return the canvas
     */
    public Canvas getCanvas() {
        return this.canvas;
    }

    /** 
     * When {@link com.smartgwt.client.widgets.Canvas#setCanAdaptHeight canAdaptHeight} has
     * been set true for a {@link com.smartgwt.client.widgets.Canvas Canvas}, this routine will
     * be called to negotiate a new height when a surplus of space or overflow has occurred in
     * the parent {@link com.smartgwt.client.widgets.layout.Layout Layout}.
     *
     * @param deltaY number of vertical pixels available (positive) or overflowed (negative)
     * @param unadaptedHeight height of member currently assumed by parent layout
     * @return number of pixels that this Canvas is willing to take (positive) or surrender (negative)
     * @see com.smartgwt.client.widgets.Canvas#setCanAdaptHeight
     */
    public abstract int adaptHeightBy(int deltaY, int unadaptedHeight);
} 
