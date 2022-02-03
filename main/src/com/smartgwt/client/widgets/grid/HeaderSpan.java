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
 
package com.smartgwt.client.widgets.grid;


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
 * A header span appears as a second level of headers in a ListGrid, spanning one or more ListGrid columns and their
 * associated headers. <P> See {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans ListGrid.headerSpans}. <P>
 * In addition to the properties documented here, all other properties specified on the headerSpan object will be passed to
 * the  create() method of the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanConstructor
 * ListGrid.headerSpanConstructor}.  This allows you to set properties such as {@link
 * com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} or {@link
 * com.smartgwt.client.widgets.StretchImgButton#getSrc StretchImgButton.src} directly in a <code>headerSpan</code>.
 */
@BeanFactory.FrameworkClass
public class HeaderSpan extends DataClass {

    public static HeaderSpan getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new HeaderSpan(jsObj);
    }
        


    public HeaderSpan(){
        
    }

    public HeaderSpan(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public HeaderSpan(String title, String[] fields) {
        setTitle(title);
		setFields(fields);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Horizontal alignment of the title of this headerSpan.
     *
     * @param align New align value. Default value is "center"
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Horizontal alignment of the title of this headerSpan.
     *
     * @return Current align value. Default value is "center"
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * List of fields that this header spans.  Fields should be identified by their value for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName ListGridField.name}. <P> Developers may define multiple levels of
     * header-spans by specifying {@link com.smartgwt.client.widgets.grid.HeaderSpan#getSpans spans} however a span cannot be
     * specified with both <code>fields</code> and <code>spans</code>.
     *
     * @param fields New fields value. Default value is null
     */
    public void setFields(String... fields) {
        setAttribute("fields", fields);
    }

    /**
     * List of fields that this header spans.  Fields should be identified by their value for {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName ListGridField.name}. <P> Developers may define multiple levels of
     * header-spans by specifying {@link com.smartgwt.client.widgets.grid.HeaderSpan#getSpans spans} however a span cannot be
     * specified with both <code>fields</code> and <code>spans</code>.
     *
     * @return Current fields value. Default value is null
     */
    public String[] getFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("fields"));
    }
    

    /**
     * Custom base style to apply to the header button created for this span instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle ListGrid.headerBaseStyle}. <P> Note that depending on the
     * header button constructor, you may have to specify {@link
     * com.smartgwt.client.widgets.grid.HeaderSpan#getHeaderTitleStyle headerTitleStyle} as well.
     *
     * @param headerBaseStyle New headerBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderBaseStyle(String headerBaseStyle) {
        setAttribute("headerBaseStyle", headerBaseStyle);
    }

    /**
     * Custom base style to apply to the header button created for this span instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderBaseStyle ListGrid.headerBaseStyle}. <P> Note that depending on the
     * header button constructor, you may have to specify {@link
     * com.smartgwt.client.widgets.grid.HeaderSpan#getHeaderTitleStyle headerTitleStyle} as well.
     *
     * @return Current headerBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }
    

    /**
     * Optional title for the headerSpan button for this headerSpan. If specified this will be displayed in the headerSpan
     * button instead of {@link com.smartgwt.client.widgets.grid.HeaderSpan#getTitle title}. Set to an empty string to suppress
     * the title in the header button entirely.
     *
     * @param headerTitle New headerTitle value. Default value is null
     */
    public void setHeaderTitle(String headerTitle) {
        setAttribute("headerTitle", headerTitle);
    }

    /**
     * Optional title for the headerSpan button for this headerSpan. If specified this will be displayed in the headerSpan
     * button instead of {@link com.smartgwt.client.widgets.grid.HeaderSpan#getTitle title}. Set to an empty string to suppress
     * the title in the header button entirely.
     *
     * @return Current headerTitle value. Default value is null
     */
    public String getHeaderTitle()  {
        return getAttributeAsString("headerTitle");
    }
    

    /**
     * Custom titleStyle to apply to the header button created for this span instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle ListGrid.headerTitleStyle}. <p> Note that this will
     * typically only have an effect if {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor
     * ListGrid.headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass thereof.
     *
     * @param headerTitleStyle New headerTitleStyle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.HeaderSpan#setHeaderBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderTitleStyle(String headerTitleStyle) {
        setAttribute("headerTitleStyle", headerTitleStyle);
    }

    /**
     * Custom titleStyle to apply to the header button created for this span instead of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle ListGrid.headerTitleStyle}. <p> Note that this will
     * typically only have an effect if {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor
     * ListGrid.headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass thereof.
     *
     * @return Current headerTitleStyle value. Default value is null
     * @see com.smartgwt.client.widgets.grid.HeaderSpan#getHeaderBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }
    

    /**
     * Height of this headerSpan.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanHeight
     * ListGrid.headerSpanHeight}.
     *
     * @param height New height value. Default value is null
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * Height of this headerSpan.  Defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpanHeight
     * ListGrid.headerSpanHeight}.
     *
     * @return Current height value. Default value is null
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * Name for this headerSpan, for use in APIs like {@link com.smartgwt.client.widgets.grid.ListGrid#setHeaderSpanTitle
     * ListGrid.setHeaderSpanTitle()}. <P> Name is optional, but if specified, must be unique for this ListGrid (but not
     * globally unique) as well as a valid JavaScript identifier, as specified by ECMA-262 Section 7.6 (the
     * StringUtil.isValidID()  function can be used to test whether a name is a valid JavaScript identifier).
     *
     * @param name New name value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name for this headerSpan, for use in APIs like {@link com.smartgwt.client.widgets.grid.ListGrid#setHeaderSpanTitle
     * ListGrid.setHeaderSpanTitle()}. <P> Name is optional, but if specified, must be unique for this ListGrid (but not
     * globally unique) as well as a valid JavaScript identifier, as specified by ECMA-262 Section 7.6 (the
     * StringUtil.isValidID()  function can be used to test whether a name is a valid JavaScript identifier).
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * This property allows developer to "nest" header spans, grouping fields together by
     *  multiple layers of granularity.
     *  <P>
     *  For example a group of fields could be nested within two layers of header spans as follows:
     *  
     *  
     *  <pre>
     *       HeaderSpan france = new HeaderSpan("France", new String[] {"Paris", "Lyon"});
     *       HeaderSpan uk = new HeaderSpan("UK", new String[] {"London", "Glasgow"});
     *       HeaderSpan spain = new HeaderSpan("Spain", new String[] {"Barcelona"});
     * 
     *       HeaderSpan europe = new HeaderSpan();
     *       europe.setTitle("Europe");
     *       europe.setSpans(france, uk, spain);
     *  </pre>
     *  
     *  Note that a span definition can not include both <code>spans</code>
     *  and {@link com.smartgwt.client.widgets.grid.HeaderSpan#getFields fields}.
     *
     * @param spans New spans value. Default value is null
     */
    public void setSpans(HeaderSpan... spans) {
        setAttribute("spans", spans);
    }

    /**
     * This property allows developer to "nest" header spans, grouping fields together by
     *  multiple layers of granularity.
     *  <P>
     *  For example a group of fields could be nested within two layers of header spans as follows:
     *  
     *  
     *  <pre>
     *       HeaderSpan france = new HeaderSpan("France", new String[] {"Paris", "Lyon"});
     *       HeaderSpan uk = new HeaderSpan("UK", new String[] {"London", "Glasgow"});
     *       HeaderSpan spain = new HeaderSpan("Spain", new String[] {"Barcelona"});
     * 
     *       HeaderSpan europe = new HeaderSpan();
     *       europe.setTitle("Europe");
     *       europe.setSpans(france, uk, spain);
     *  </pre>
     *  
     *  Note that a span definition can not include both <code>spans</code>
     *  and {@link com.smartgwt.client.widgets.grid.HeaderSpan#getFields fields}.
     *
     * @return Current spans value. Default value is null
     */
    public HeaderSpan[] getSpans()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfHeaderSpan(getAttributeAsJavaScriptObject("spans"));
    }
    

    /**
     * A title for this headerSpan, to display in the headerSpan button for this headerSpan and in other contexts such as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields menu for picking visible fields}. Note: if you want to
     * use HTML tags to affect the display of the header, you should do so via {@link
     * com.smartgwt.client.widgets.grid.HeaderSpan#getHeaderTitle headerTitle} instead so that other places where the title
     * appears in the UI are not affected.  Refer to discussion at {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle ListGridField.title}.
     *
     * @param title New title value. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * A title for this headerSpan, to display in the headerSpan button for this headerSpan and in other contexts such as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields menu for picking visible fields}. Note: if you want to
     * use HTML tags to affect the display of the header, you should do so via {@link
     * com.smartgwt.client.widgets.grid.HeaderSpan#getHeaderTitle headerTitle} instead so that other places where the title
     * appears in the UI are not affected.  Refer to discussion at {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTitle ListGridField.title}.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Vertical alignment of the title of this headerSpan. <P> Defaults to listGrid.headerSpanVAlign if unset.
     *
     * @param valign New valign value. Default value is null
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue());
    }

    /**
     * Vertical alignment of the title of this headerSpan. <P> Defaults to listGrid.headerSpanVAlign if unset.
     *
     * @return Current valign value. Default value is null
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    /**
     * Should the span title wrap if there is not enough space horizontally to accommodate it. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getWrapHeaderSpanTitles ListGrid.wrapHeaderSpanTitles}. 
     * (This is a soft-wrap - if set the title will wrap at word boundaries.)
     *
     * @param wrap New wrap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setWrap
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Should the span title wrap if there is not enough space horizontally to accommodate it. If unset, default behavior is
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getWrapHeaderSpanTitles ListGrid.wrapHeaderSpanTitles}. 
     * (This is a soft-wrap - if set the title will wrap at word boundaries.)
     *
     * @return Current wrap value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getWrap
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Set the properties of the header button used for this span.
     * The buttonProperties parameter should be the same class as the headerButtonConstructor for
     * the ListGrid (most commonly Button, ImgButton or StretchImgButton, and typically set up
     * in the load_skin.js file for the loaded theme).
     *
     * @param buttonProperties the header button properties.
     */
    public void setHeaderButtonProperties(Canvas buttonProperties) {
        if (buttonProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setHeaderButtonProperties",
                                                    "Canvas");
        }
        buttonProperties.setConfigOnly(true);

        JavaScriptObject config = buttonProperties.getConfig();
        JSOHelper.addProperties(getJsObj(), JSOHelper.cleanProperties(config, false));
    }


}
