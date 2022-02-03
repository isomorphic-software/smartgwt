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
 
package com.smartgwt.client.widgets.rte;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * Configuration of an HTML list in a {@link com.smartgwt.client.widgets.RichTextEditor}.
 */
@BeanFactory.FrameworkClass
public class ListProperties extends DataClass {

    public static ListProperties getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new ListProperties(jsObj);
    }
        


    public ListProperties(){
        
    }

    public ListProperties(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * When the list item marker {@link com.smartgwt.client.widgets.rte.ListProperties#getStyle style} is "custom-image", the
     * image to use for the markers.
     *
     * @param image New image value. Default value is "[SKIN]/RichTextEditor/bullet_blue.png"
     * @return {@link com.smartgwt.client.widgets.rte.ListProperties ListProperties} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ListProperties setImage(String image) {
        return (ListProperties)setAttribute("image", image);
    }

    /**
     * When the list item marker {@link com.smartgwt.client.widgets.rte.ListProperties#getStyle style} is "custom-image", the
     * image to use for the markers.
     *
     * @return Current image value. Default value is "[SKIN]/RichTextEditor/bullet_blue.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getImage()  {
        return getAttributeAsString("image");
    }
    

    /**
     * For ordered lists, the number to start the first item with. Must be non-negative.
     *
     * @param startNumber New startNumber value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.rte.ListProperties ListProperties} instance, for chaining setter calls
     */
    public ListProperties setStartNumber(int startNumber) {
        return (ListProperties)setAttribute("startNumber", startNumber);
    }

    /**
     * For ordered lists, the number to start the first item with. Must be non-negative.
     *
     * @return Current startNumber value. Default value is 1
     */
    public int getStartNumber()  {
        return getAttributeAsInt("startNumber");
    }
    

    /**
     * The style of list item marker. If "custom-image", the {@link com.smartgwt.client.widgets.rte.ListProperties#getImage
     * image} should be specified.
     *
     * @param style New style value. Default value is null
     * @return {@link com.smartgwt.client.widgets.rte.ListProperties ListProperties} instance, for chaining setter calls
     */
    public ListProperties setStyle(ListStyleType style) {
        return (ListProperties)setAttribute("style", style == null ? null : style.getValue());
    }

    /**
     * The style of list item marker. If "custom-image", the {@link com.smartgwt.client.widgets.rte.ListProperties#getImage
     * image} should be specified.
     *
     * @return Current style value. Default value is null
     */
    public ListStyleType getStyle()  {
        return EnumUtil.getEnum(ListStyleType.values(), getAttribute("style"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
