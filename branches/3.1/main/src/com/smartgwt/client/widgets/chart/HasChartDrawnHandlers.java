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

public interface HasChartDrawnHandlers extends HasHandlers {
    /**
     * Called when all elements of the chart (data lines / shapes, gradations, legend, labels etc) have completed drawing.  
     * <P> See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartBackgroundDrawnHandler
     * FacetChart.chartBackgroundDrawn} for usage information.
     *
     * @param handler the chartDrawn handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addChartDrawnHandler(ChartDrawnHandler handler);
}
