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
 
package com.smartgwt.client.tools;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * This static singleton class implements a component that can be used to highlight any other Canvas or FormItem by drawing
 * a line around it and optional label.  The selection outline  moves, resizes and hides with the target object, and does
 * not occlude any part of it.  The outline is not a peer, child or member of the target object; the target object does not
 *  know about the outline. <p> NOTE: This class is for internal use only by EditContext.
 */
@BeanFactory.FrameworkClass
public class SelectionOutline {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
	/**
     * Returns the CSS border of this component.
     */
    public static native void getBorder() /*-{
        $wnd.isc.SelectionOutline.getBorder();
    }-*/;

	/**
     * Returns the background color for the selection label.
     */
    public static native void getLabelBackgroundColor() /*-{
        $wnd.isc.SelectionOutline.getLabelBackgroundColor();
    }-*/;



	/**
     * Set the CSS border of this component as a CSS string including border-width, border-style, and/or color (eg "1px dashed
     * blue"). <P> This property applies the same border to all four sides of this component.
     * @param border css border string
     */
    public static native void setBorder(String border) /*-{
        $wnd.isc.SelectionOutline.setBorder(border);
    }-*/;




	/**
     * Set the background color for the selection label. It corresponds to the CSS background-color attribute. You can set this
     * property to an RGB value (e.g. #22AAFF) or a named color (e.g. red) from a list of browser supported color names.
     * @param color css color
     */
    public static native void setLabelBackgroundColor(String color) /*-{
        $wnd.isc.SelectionOutline.setLabelBackgroundColor(color);
    }-*/;



    // ***********************************************************

}


