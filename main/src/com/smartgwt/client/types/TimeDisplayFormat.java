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
 * String designating a standard time format for displaying the times associated with  dates strings.
 */
public enum TimeDisplayFormat implements ValueEnum {
    /**
     * String will display with seconds and am/pm indicator:<code>[H]H:MM:SS am|pm</code>. <br> Example: <code>3:25:15
     * pm</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toTime".
     */
    TOTIME("toTime"),
    /**
     * String will display with seconds in 24 hour time: <code>[H]H:MM:SS</code>. <br> Example: <code>15:25:15</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "to24HourTime".
     */
    TO24HOURTIME("to24HourTime"),
    /**
     * String will display with seconds, with a 2 digit hour and am/pm indicator:  <code>HH:MM:SS am|pm</code> <br> Example:
     * <code>03:25:15 pm</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toPaddedTime".
     */
    TOPADDEDTIME("toPaddedTime"),
    /**
     * String will display with seconds, with a 2 digit hour in 24 hour format:  <code>HH:MM:SS</code> <br> Examples:
     * <code>15:25:15</code>, <code>03:16:45</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toPadded24HourTime".
     */
    TOPADDED24HOURTIME("toPadded24HourTime"),
    /**
     * String will have no seconds and be in 12 hour format:<code>[H]H:MM am|pm</code><br> Example: <code>3:25 pm</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toShortTime".
     */
    TOSHORTTIME("toShortTime"),
    /**
     * String will have no seconds and be in 24 hour format: <code>[H]H:MM</code><br> Example:<code>15:25</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toShort24HourTime".
     */
    TOSHORT24HOURTIME("toShort24HourTime"),
    /**
     * String will have no seconds and will display a 2 digit hour, in 12 hour clock format: <code>HH:MM am|pm</code><br>
     * Example: <code>03:25 pm</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toShortPaddedTime".
     */
    TOSHORTPADDEDTIME("toShortPaddedTime"),
    /**
     * String will have no seconds and will display with a 2 digit hour in 24 hour clock format: <code>HH:MM</code><br>
     * Examples: <code>15:25</code>, <code>03:16</code>
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "toShortPadded24HourTime".
     */
    TOSHORTPADDED24HOURTIME("toShortPadded24HourTime");
    private String value;

    TimeDisplayFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
