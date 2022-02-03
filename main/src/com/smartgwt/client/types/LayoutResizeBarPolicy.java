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
 * Policy for whether resize bars are shown on members by default.
 */
public enum LayoutResizeBarPolicy implements ValueEnum {
    /**
     * resize bars are only shown on members marked {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar
     * showResizeBar:true}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "marked".
     */
    MARKED("marked"),
    /**
     * resize bars are shown on all resizable members that are not explicitly marked showResizeBar:false, except the last
     * member. Appropriate for a {@link com.smartgwt.client.types.LayoutPolicy} of "fill" (VLayout, HLayout) since the overall
     * space will always be filled.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "middle".
     */
    MIDDLE("middle"),
    /**
     * resize bars are shown on all resizable members that are not explicitly marked showResizeBar:false, including the last
     * member. Can be appropriate for a {@link com.smartgwt.client.types.LayoutPolicy} of "none" (VStack, HStack) since the
     * overall size of the layout is dictated by it's member's sizes.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "all".
     */
    ALL("all"),
    /**
     * resize bars are not shown even if members are marked with {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar
     * showResizeBar:true}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    LayoutResizeBarPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
