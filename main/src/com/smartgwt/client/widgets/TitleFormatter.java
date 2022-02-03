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
 
package com.smartgwt.client.widgets;

import com.smartgwt.client.widgets.StatefulCanvas;

public interface TitleFormatter {

    /** 
     * Formatter method to dynamically modify the title displayed by this component.
     *
     * @param component the StatefulCanvas for which the title will be displayed
     * @param title title returned by {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle getTitle()}
     * @return formatted title to display
     */
	public String formatTitle(StatefulCanvas component, String title);
} 
