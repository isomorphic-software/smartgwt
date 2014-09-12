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
 
package com.smartgwt.client.widgets.chart;

import com.google.gwt.event.shared.EventHandler;

public interface ValueClickHandler extends EventHandler {
    /**
     * Fires when a data value is clicked, and provides information about the data value that was clicked as a {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Specifically, this fires for clicks on pie slices, bars or
     * columns, areas, lines or points (in a Bubble or Scatter plot). <p> If there are multiple data values at the clicked
     * position, you can use {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues
     * FacetChart.getNearestDrawnValues} to discover the full list of values at the current coordinate (pass in {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX getOffsetX/Y()} for the coordinates). <p> If you want to create behaviors
     * for clicking or moving <i>near</i> shapes without requiring a direct hit, implement a standard {@link
     * com.smartgwt.client.widgets.Canvas#addClickHandler Canvas.click} handler on the FacetChart as a whole and use {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue} to discover the
     * nearest data values.
     *
     * @param event the event
     */
    void onValueClick(com.smartgwt.client.widgets.chart.ValueClickEvent event);
}
