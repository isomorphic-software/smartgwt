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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasLegendClickHandlers extends HasHandlers {
    /**
     * Fires when the user clicks on the legend area of the chart. <p> If the user specifically clicks on a color swatch or
     * it's label, the {@link com.smartgwt.client.widgets.cube.FacetValue} clicked on will be provided. <p> If the chart is a
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart}, the {@link
     * com.smartgwt.client.widgets.cube.FacetValue} for the clicked-on metric will also be provided.
     *
     * @param handler the legendClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addLegendClickHandler(LegendClickHandler handler);
}

