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

public interface LegendHoverHandler extends EventHandler {
    /**
     * Fires when the mouse hovers over a color swatch or its label in the legend area of the chart. <p> The {@link
     * com.smartgwt.client.widgets.cube.FacetValue} that the user is hovering over is provided. If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart}, the {@link
     * com.smartgwt.client.widgets.cube.FacetValue} for the hovered-over metric will also be provided.
     *
     * @param event the event
     */
    void onLegendHover(com.smartgwt.client.widgets.chart.LegendHoverEvent event);
}
