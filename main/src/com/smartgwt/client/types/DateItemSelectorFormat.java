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
 
/**
 * Order of pickers and which pickers are present when using a DateItem with {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} false.
 */
public enum DateItemSelectorFormat implements ValueEnum {
    /**
     * Output fields in day, month, year order.
     */
    DAY_MONTH_YEAR("DMY"),
    /**
     * Output fields in month, day, year order.
     */
    MONTH_DAY_YEAR("MDY"),
    /**
     * Output fields in year, month, day order.
     */
    YEAR_MONTH_DAY("YMD"),
    /**
     * Output only day, month fields.
     */
    DAY_MONTH("DM"),
    /**
     * Output only month, day fields.
     */
    MONTH_DAY("MD"),
    /**
     * Output only year, month fields.
     */
    YEAR_MONTH("YM"),
    /**
     * Output only month, year fields.
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
