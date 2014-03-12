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

import com.smartgwt.client.tools.PaletteNode;

public interface PaletteNodeCallback {

    /** 
     * Callback fired with the {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} obtained asynchronously.
     *
     * @param paletteNodes an array of PaletteNodes
     */
	public void execute(PaletteNode... paletteNodes);
} 
