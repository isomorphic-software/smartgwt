package com.smartgwt.client.types;


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
 
/**
 * Valid display formats for dates.  These strings are the names of formatters which can be passed to
 * <code>DateUtil.setNormalDisplayFormat()</code> or  <code>DateUtil.setShortDisplayFormat()</code> and will be
 * subsequently used as default long or short formatters for date objects by Smart GWT components.<br> Default set of valid
 * display formats is as follows:<br><br>
 */
public enum DateDisplayFormat implements ValueEnum {
    /**
     * Default native browser 'toString()' implementation. May vary by browser.<br> <i>Example</i>: <code>Fri Nov 04 2005
     * 11:03:00 GMT-0800 (Pacific Standard Time)</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toString".
     */
    TOSTRING("toString"),
    /**
     * Default native browser 'toLocaleString()' implementation. May vary by browser. <i>Example</i>: <code>Friday, November
     * 04, 2005 11:03:00 AM</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toLocaleString".
     */
    TOLOCALESTRING("toLocaleString"),
    /**
     * Short date in format MM/DD/YYYY.<br> <i>Example</i>: <code>11/4/2005</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toUSShortDate".
     */
    TOUSSHORTDATE("toUSShortDate"),
    /**
     * Short date with time in format MM/DD/YYYY HH:MM<br> <i>Example</i>: <code>11/4/2005 11:03</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toUSShortDatetime".
     */
    TOUSSHORTDATETIME("toUSShortDatetime"),
    /**
     * Short date in format DD/MM/YYYY.<br> <i>Example</i>: <code>4/11/2005</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toEuropeanShortDate".
     */
    TOEUROPEANSHORTDATE("toEuropeanShortDate"),
    /**
     * Short date with time in format DD/MM/YYYY HH:MM<br> <i>Example</i>: <code>4/11/2005 11:03</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toEuropeanShortDatetime".
     */
    TOEUROPEANSHORTDATETIME("toEuropeanShortDatetime"),
    /**
     * Short date in format YYYY/MM/DD.<br> <i>Example</i>: <code>2005/11/4</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toJapanShortDate".
     */
    TOJAPANSHORTDATE("toJapanShortDate"),
    /**
     * Short date with time in format YYYY/MM/DD HH:MM<br> <i>Example</i>: <code>2005/11/4 11:03</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toJapanShortDatetime".
     */
    TOJAPANSHORTDATETIME("toJapanShortDatetime"),
    /**
     * Date in the format YYYY-MM-DD HH:MM:SS<br> <i>Example</i>: <code>2005-11-04 11:09:15</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toSerializeableDate".
     */
    TOSERIALIZEABLEDATE("toSerializeableDate"),
    /**
     * Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z <i>Example</i>: <code>20051104T111001Z</code> <br> <br> Note: In
     * addition to these standard formats, custom formatting can be set by passing a function directly to {@link
     * com.smartgwt.client.util.DateUtil#setNormalDisplayFormat DateUtil.setNormalDisplayFormat()} et al. This function will
     * then be executed whenever the appropriate formatter method is called [eg {@link
     * com.smartgwt.client.util.Date#toNormalDate Date.toNormalDate()}], in the scope of the date instance in question. <p>
     * Custom formatting can also be applied by passing a {@link com.smartgwt.client.docs.FormatString} instead of a 
     * <code>DateDisplayFormat</code> string to {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat
     * DateUtil.setNormalDisplayFormat()} et al. See the <code>FormatString</code> docs for details.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toDateStamp".
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
