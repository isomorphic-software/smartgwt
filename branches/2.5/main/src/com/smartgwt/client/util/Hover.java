/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.smartgwt.client.widgets.Canvas;

/**
 * Utility methods related to hover / tooltips / prompts.
 */
public class Hover {

    /**
     * Clear any active hover prompt.
     */
    public static native void clear() /*-{
      return $wnd.isc.Hover.clear();
    }-*/;

    /**
     * Return the canvas corresponding to the active hover.
     *
     * @return the hover canvas/
     */
    public static native Canvas getCanvas() /*-{
      var canvasJS = $wnd.isc.Hover.hoverCanvas;
       return canvasJS == null || canvasJS === undefined ? null : @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(canvasJS);
    }-*/;
}
