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
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
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
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Static singleton class containing APIs for interacting with Numbers.
 */
@BeanFactory.FrameworkClass
public class NumberUtil {


    // ********************* Properties / Attributes ***********************

    /** 
     * The currency symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @param currencySymbol new currencySymbol.  Default value is "$".
     */
    public static native void setCurrencySymbol(String currencySymbol) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.NumberUtil, "currencySymbol", currencySymbol);
    }-*/;

    /** 
     * The currency symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @return current value of currencySymbol
     */
    public static native String getCurrencySymbol() /*-{
        return $wnd.isc.NumberUtil.currencySymbol;
    }-*/;

    /** 
     * The decimal symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @param decimalSymbol new decimalSymbol.  Default value is ".".
     */
    public static native void setDecimalSymbol(String decimalSymbol) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.NumberUtil, "decimalSymbol", decimalSymbol);
    }-*/;

    /** 
     * The decimal symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @return current value of decimalSymbol
     */
    public static native String getDecimalSymbol() /*-{
        return $wnd.isc.NumberUtil.decimalSymbol;
    }-*/;

    /** 
     * The grouping-format for numbers <P> Note: the correct format is normally auto-derived from GWT's locale system, so the
     * only valid reason to set it is desiring to use a language from one locale in combination with formatting rules from
     * another locale, in a single application and for a single end user.
     *
     * @param groupingFormat new groupingFormat.  Default value is 1.
     */
    public static native void setGroupingFormat(int groupingFormat) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;I)($wnd.isc.NumberUtil, "groupingFormat", groupingFormat);
    }-*/;

    /** 
     * The grouping-format for numbers <P> Note: the correct format is normally auto-derived from GWT's locale system, so the
     * only valid reason to set it is desiring to use a language from one locale in combination with formatting rules from
     * another locale, in a single application and for a single end user.
     *
     * @return current value of groupingFormat
     */
    public static native int getGroupingFormat() /*-{
        var result = $wnd.isc.NumberUtil.groupingFormat;
        if (result == null) result = 0;
        return @com.google.gwt.core.client.GWT::isScript()() ? result : result.valueOf(); 
    }-*/;

    /** 
     * The grouping symbol, or thousands separator, to use when formatting numbers <P> Note: the correct symbol is normally
     * auto-derived from GWT's locale system, so the only valid reason to set it is desiring to use a language from one locale
     * in combination with formatting rules from another locale, in a single application and for a single end user.
     *
     * @param groupingSymbol new groupingSymbol.  Default value is ",".
     */
    public static native void setGroupingSymbol(String groupingSymbol) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.NumberUtil, "groupingSymbol", groupingSymbol);
    }-*/;

    /** 
     * The grouping symbol, or thousands separator, to use when formatting numbers <P> Note: the correct symbol is normally
     * auto-derived from GWT's locale system, so the only valid reason to set it is desiring to use a language from one locale
     * in combination with formatting rules from another locale, in a single application and for a single end user.
     *
     * @return current value of groupingSymbol
     */
    public static native String getGroupingSymbol() /*-{
        return $wnd.isc.NumberUtil.groupingSymbol;
    }-*/;

    /** 
     * The format to use when formatting nagative numbers.  Supported values are: 1 = before,  2 = after, 3 = beforeSpace, 4 =
     * afterSpace, 5 = parens <P> Note: the correct format is normally auto-derived from GWT's locale system, so the only valid
     * reason to set it is desiring to use a language from one locale in combination with formatting rules from another locale,
     * in a single application and for a single end user.
     *
     * @param negativeFormat new negativeFormat.  Default value is 1.
     */
    public static native void setNegativeFormat(int negativeFormat) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;I)($wnd.isc.NumberUtil, "negativeFormat", negativeFormat);
    }-*/;

    /** 
     * The format to use when formatting nagative numbers.  Supported values are: 1 = before,  2 = after, 3 = beforeSpace, 4 =
     * afterSpace, 5 = parens <P> Note: the correct format is normally auto-derived from GWT's locale system, so the only valid
     * reason to set it is desiring to use a language from one locale in combination with formatting rules from another locale,
     * in a single application and for a single end user.
     *
     * @return current value of negativeFormat
     */
    public static native int getNegativeFormat() /*-{
        var result = $wnd.isc.NumberUtil.negativeFormat;
        if (result == null) result = 0;
        return @com.google.gwt.core.client.GWT::isScript()() ? result : result.valueOf(); 
    }-*/;

    /** 
     * The negative symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @param negativeSymbol new negativeSymbol.  Default value is "-".
     */
    public static native void setNegativeSymbol(String negativeSymbol) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.NumberUtil, "negativeSymbol", negativeSymbol);
    }-*/;

    /** 
     * The negative symbol to use when formatting numbers <P> Note: the correct symbol is normally auto-derived from GWT's
     * locale system, so the only valid reason to set it is desiring to use a language from one locale in combination with
     * formatting rules from another locale, in a single application and for a single end user.
     *
     * @return current value of negativeSymbol
     */
    public static native String getNegativeSymbol() /*-{
        return $wnd.isc.NumberUtil.negativeSymbol;
    }-*/;

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Returns a clamped number between a min and max.
     *  <p>
     *  
     *  
     *  <pre>
     *  int clamped = NumberUtil.clamp(10, 0, 5); // Returns 5 because 10 is greater than 5
     *  int clamped = NumberUtil.clamp(-3, 0, 5); // Returns 0 because -3 is less than 0
     *  int clamped = NumberUtil.clamp(4, 0, 5); // Returns 4 because 4 is between 0 and 5
     *  </pre>
     *  
     * 
     * @param number the number to clamp
     * @param min the number to return if the number is lower than min
     * @param max the number to return if the number is higher than max
     *
     * @return the clamped number
     */
    public static native int clamp(int number, int min, int max) /*-{
        var ret = $wnd.isc.NumberUtil.clamp(number, min, max);
        return ret;
    }-*/;



	/**
     * Returns true if the number parameter falls between the 'first' and 'second' parameters.
     * @param number Number object to be evaluated
     *
     * @return True if the given <code>number</code> falls inside the given range, false otherwise @example n = 3; bool =
     * n.isBetween(3, 3, 6, true); // true
     */
    public static native Boolean isBetween(int number) /*-{
        var ret = $wnd.isc.NumberUtil.isBetween(number);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * @see NumberUtil#isBetween
     */
    public static Boolean isBetween(int number, int first){
        return isBetween(number, first, (Integer) null, (Integer) null);
    }

    /**
     * @see NumberUtil#isBetween
     */
    public static Boolean isBetween(int number, int first, int second){
        return isBetween(number, first, second, (Integer) null);
    }

	/**
     * Returns true if the number parameter falls between the 'first' and 'second' parameters.
     * @param number Number object to be evaluated
     * @param first Number at the lower boundary
     * @param second Number at the upper boundary
     * @param inclusive Whether or not the numbers at either end of the boundary should be included in the comparison
     *
     * @return True if the given <code>number</code> falls inside the given range, false otherwise @example n = 3; bool =
     * n.isBetween(3, 3, 6, true); // true
     */
    public static native Boolean isBetween(int number, int first, int second, int inclusive) /*-{
        var ret = $wnd.isc.NumberUtil.isBetween(number, first, second, inclusive);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	









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
