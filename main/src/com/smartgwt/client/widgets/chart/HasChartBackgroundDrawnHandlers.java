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
 
package com.smartgwt.client.widgets.chart;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasChartBackgroundDrawnHandlers extends HasHandlers {
    /**
     * Called when most elements of the chart <i>other than data</i> data have been drawn, including gradations and legend. <P>
     * This notification will be fired each time the chart is redrawn (due to resize, data change, etc).  If you want to draw
     * additional information on the chart using {@link com.smartgwt.client.widgets.drawing.DrawPane} (FacetChart's superclass)
     * and various {@link com.smartgwt.client.widgets.drawing.DrawItem}s, you should do in response to this notification.  Due
     * to auto-sizing, APIs that are typically used to position custom DrawItems (such as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartLeft FacetChart.getChartLeft}) may return bad values if called at
     * other times. <P> Additional DrawItems added in this method will appear underneath data elements such as bars or columns.
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} for placing
     * DrawItems on top of data elements.
     *
     * @param handler the chartBackgroundDrawn handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addChartBackgroundDrawnHandler(ChartBackgroundDrawnHandler handler);
}
