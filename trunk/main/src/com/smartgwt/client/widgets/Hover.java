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



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The Hover class handles showing a simple Smart GWT canvas containing arbitrary HTML, or triggering some other action in
 * response to a user holding the mouse-pointer (or hovering) over a specific widget.
 */
public class Hover {

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
            
    /**
     * Hide hover hover Canvas shown via {@link com.smartgwt.client.widgets.Hover#show Hover.show}
     */
    public static native void hide() /*-{
        $wnd.isc.Hover.hide();
    }-*/;
            
    /**
     * Displays a standard Hover canvas containing the specified HTML content.<br> This method may also be called to modify the
     * content of the hover if it is already showing. Call {@link com.smartgwt.client.widgets.Hover#hide Hover.hide} to hide
     * the canvas again.<br> A common use case for calling this method is to asynchronously fetch detail data from the server
     * about some component, and display it in the Hover canvas when the data is returned. Note that in this case you will
     * typically need to verify that the user is still hovering  over the component in question before calling Hover.show() -
     * if the user has moved the mouse  off the component, the information will not apply to whatever is now under the mouse. 
     * Suggested approaches for handling this are to either use a {@link com.smartgwt.client.widgets.Canvas#addMouseOutHandler
     * Canvas.mouseOut} handler to track when the user moves off the component, or checking {@link
     * com.smartgwt.client.util.EventHandler#getTarget EventHandler.getTarget} as part of the asynchronous callback <p> The
     * default Hover canvas position will be based on the mouse pointer position, adjusted by {@link
     * com.smartgwt.client.widgets.Hover#leftOffset leftOffset} and {@link com.smartgwt.client.widgets.Hover#topOffset
     * topOffset}. If this position would render the Hover canvas partially clipped, it will be automatically modified to
     * ensure the Hover  is entirely visible.
     * @param contents contents for the hover
     * @param properties object containing attributes for managing the hover canvas'   appearance. Valid properties include:<ul>  <li>left, top,
     * width, height  <li>baseStyle  <li>opacity  <li>wrap  <li>moveWithMouse [overrides {@link
     * com.smartgwt.client.widgets.Hover#moveWithMouse moveWithMouse}] </ul>
     */
    public static native void show(String contents, Label properties) /*-{
        $wnd.isc.Hover.show(contents, properties.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
        
    // ***********************************************************        

}



