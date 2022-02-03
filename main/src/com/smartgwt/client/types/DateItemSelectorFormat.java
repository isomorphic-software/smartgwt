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
 * Order of pickers and which pickers are present when using a DateItem with {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField DateItem.useTextField} false.
 */
public enum DateItemSelectorFormat implements ValueEnum {
    /**
     * Output fields in day, month, year order.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "DMY".
     */
    DAY_MONTH_YEAR("DMY"),
    /**
     * Output fields in month, day, year order.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "MDY".
     */
    MONTH_DAY_YEAR("MDY"),
    /**
     * Output fields in year, month, day order.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "YMD".
     */
    YEAR_MONTH_DAY("YMD"),
    /**
     * Output only day, month fields.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "DM".
     */
    DAY_MONTH("DM"),
    /**
     * Output only month, day fields.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "MD".
     */
    MONTH_DAY("MD"),
    /**
     * Output only year, month fields.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "YM".
     */
    YEAR_MONTH("YM"),
    /**
     * Output only month, year fields.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "MY".
     */
    MONTH_YEAR("MY");
    private String value;

    DateItemSelectorFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
