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
 
package com.smartgwt.client.widgets.grid;



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
 * A header span appears as a second level of headers in a ListGrid, spanning one or more ListGrid columns and their
 * associated headers. <P> See {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}. <P> In
 * addition to the properties documented here, all other properties specified on the headerSpan object will be passed to
 * the  create() method of the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanConstructor
 * headerSpanConstructor}.  This allows you to set properties such as {@link
 * com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} or {@link com.smartgwt.client.widgets.StretchImgButton#getSrc
 * src} directly in a <code>headerSpan</code>.
 */
public class HeaderSpan extends DataClass {

    public static HeaderSpan getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new HeaderSpan(jsObj);
    }

    public HeaderSpan(){
        
    }

    public HeaderSpan(JavaScriptObject jsObj){
        super(jsObj);
    }

    public HeaderSpan(String title, String[] fields) {
        setTitle(title);
		setFields(fields);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Horizontal alignment of the title of this headerSpan.
     *
     * @param align align Default value is "center"
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue());
    }

    /**
     * Horizontal alignment of the title of this headerSpan.
     *
     *
     * @return Alignment
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }

    /**
     * List of fields that this header spans.  Fields should be identified by their value for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName name}.
     *
     * @param fields fields Default value is null
     */
    public void setFields(String... fields) {
        setAttribute("fields", fields);
    }

    /**
     * List of fields that this header spans.  Fields should be identified by their value for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName name}.
     *
     *
     * @return String
     */
    public String[] getFields()  {
        return getAttributeAsStringArray("fields");
    }

    /**
     * Height of this headerSpan.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanHeight
     * headerSpanHeight}.
     *
     * @param height height Default value is null
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * Height of this headerSpan.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanHeight
     * headerSpanHeight}.
     *
     *
     * @return Integer
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Name for this headerSpan, for use in APIs like {@link com.smartgwt.client.widgets.grid.ListGrid#setHeaderSpanTitle
     * ListGrid.setHeaderSpanTitle}. <P> Name is optional, but if specified, must be unique for this ListGrid (but not globally
     * unique).
     *
     * @param name name Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name for this headerSpan, for use in APIs like {@link com.smartgwt.client.widgets.grid.ListGrid#setHeaderSpanTitle
     * ListGrid.setHeaderSpanTitle}. <P> Name is optional, but if specified, must be unique for this ListGrid (but not globally
     * unique).
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * Title for this headerSpan.
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * Title for this headerSpan.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Vertical alignment of the title of this headerSpan. <P> Defaults to listGrid.headerSpanVAlign if unset.
     *
     * @param valign valign Default value is null
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign.getValue());
    }

    /**
     * Vertical alignment of the title of this headerSpan. <P> Defaults to listGrid.headerSpanVAlign if unset.
     *
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



