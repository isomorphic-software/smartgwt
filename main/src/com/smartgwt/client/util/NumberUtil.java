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
 
package com.smartgwt.client.util;


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
 * Static singleton class containing APIs for interacting with Numbers.
 */
@BeanFactory.FrameworkClass
public class NumberUtil {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

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
 


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(int number, String format) /*-{
        return $wnd.isc.NumberUtil.format(number, format);
    }-*/;
	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(float number, String format) /*-{
        return $wnd.isc.NumberUtil.format(number, format);
    }-*/;
	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(double number, String format) /*-{
        return $wnd.isc.NumberUtil.format(number, format);
    }-*/;
	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(Integer number, String format) /*-{
        var ret = $wnd.isc.NumberUtil.format(number == null ? null : number.@java.lang.Integer::intValue()(), format);
        return ret;
    }-*/;
	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(Float number, String format) /*-{
        var ret = $wnd.isc.NumberUtil.format(number == null ? null : number.@java.lang.Float::floatValue()(), format);
        return ret;
    }-*/;
	/**
     * Return the parameter number formatted according to the parameter {@link com.smartgwt.client.docs.FormatString}. This
     * method is used to implement the {@link com.smartgwt.client.data.DataSourceField#getFormat format} functionality, but it
     * can also be used to format arbitrary numbers programmatically.
     * @param number The number to format
     * @param format The format to apply. See {@link com.smartgwt.client.docs.FormatString FormatString}
     *
     * @return formatted number string
     */
    public static native String format(Double number, String format) /*-{
        var ret = $wnd.isc.NumberUtil.format(number == null ? null : number.@java.lang.Double::doubleValue()(), format);
        return ret;
    }-*/;


    // ***********************************************************


}


