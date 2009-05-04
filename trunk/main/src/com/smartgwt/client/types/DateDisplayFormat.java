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

package com.smartgwt.client.types;

/**
 * Valid display formats for dates.  These strings are the names of formatters which can be &#010 passed to
 * <code>Date.setNormalDisplayFormat()</code> or <code>Date.setShortDisplayFormat()</code>&#010 and will be subsequently
 * used as default long or short formatters for date objects by&#010 SmartClient components.<br>&#010 Default set of
 * valid display formats is as follows:<br><br>
 */

public enum DateDisplayFormat implements ValueEnum {
    /**
     * Default native browser 'toString()' implementation. May vary by browser.<br>&#010 <i>Example</i>: <code>Fri Nov
     * 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)</code>
     */
    TOSTRING("toString"),
    /**
     * Default native browser 'toLocaleString()' implementation. May vary by browser.&#010 <i>Example</i>: <code>Friday,
     * November 04, 2005 11:03:00 AM</code>
     */
    TOLOCALESTRING("toLocaleString"),
    /**
     * Short date in format MM/DD/YYYY.<br> <i>Example</i>: <code>11/4/2005</code>
     */
    TOUSSHORTDATE("toUSShortDate"),
    /**
     * Short date with time in format MM/DD/YYYY HH:MM<br> <i>Example</i>: <code>11/4/2005 11:03</code>
     */
    TOUSSHORTDATETIME("toUSShortDateTime"),
    /**
     * Short date in format DD/MM/YYYY.<br> <i>Example</i>: <code>4/11/2005</code>
     */
    TOEUROPEANSHORTDATE("toEuropeanShortDate"),
    /**
     * Short date with time in format DD/MM/YYYY HH:MM<br> <i>Example</i>: <code>4/11/2005 11:03</code>
     */
    TOEUROPEANSHORTDATETIME("toEuropeanShortDateTime"),
    /**
     * Short date in format YYYY/MM/DD.<br> <i>Example</i>: <code>2005/11/4</code>
     */
    TOJAPANSHORTDATE("toJapanShortDate"),
    /**
     * Short date with time in format YYYY/MM/DD HH:MM<br> <i>Example</i>: <code>2005/11/4 11:03</code>
     */
    TOJAPANSHORTDATETIME("toJapanShortDateTime"),
    /**
     * Date in the format YYYY-MM-DD HH:MM:SS<br> <i>Example</i>: <code>2005-11-04 11:09:15</code>
     */
    TOSERIALIZEABLEDATE("toSerializeableDate"),
    /**
     * Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z <i>Example</i>: <code>20051104T111001Z</code>&#010 <br>&#010
     * <br>&#010 Note: In addition to these standard formats, custom formatting can be set by passing&#010 a function
     * directly to {@link com.smartgwt.client.util.DateUtil#setNormalDateDisplayFormat(DateDisplayFormat)} et al. This &#010 function will
     * then be executed whenever the appropriate formatter method is called [eg &#010
     * Date.toNormalDate, in the scope of the date instance in question.
     */
    TODATESTAMP("toDateStamp");
    private String value;

    DateDisplayFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

