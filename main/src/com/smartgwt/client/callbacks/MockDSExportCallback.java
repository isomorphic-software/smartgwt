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
 
package com.smartgwt.client.callbacks;


public interface MockDSExportCallback {

    /** 
     * Callback fired upon successful completion of {@link com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or
     * {@link com.smartgwt.client.tools.Reify#showMockDS Reify.showMockDS()}:<ul> <li> Output for all {@link
     * com.smartgwt.client.data.DataSource DataSources} together is reported as the single string parameter
     * <code>allDSData</code>.  When using {@link com.smartgwt.client.util.MockDSExportSettings#getFormat format}: "reifyCSV",
     * output for separate DataSources is separated by a special marker. <li> Output with each {@link
     * com.smartgwt.client.data.DataSource} as a separate string array element is also available as the parameter
     * <code>perDSData</code>, ordered to match the <code>dsNames</code> parameter in {@link
     * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()}.</ul> <P> Note that in the case of {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()}, the callback is fired after the window is closed, not when it's populated.
     *
     * @param allDSData concatenated output for all <code>DataSources</code>
     * @param perDSData same output but delivered as a per-DS array
     */
	public void execute(String allDSData, String[] perDSData);
} 
