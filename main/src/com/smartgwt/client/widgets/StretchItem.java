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
 
package com.smartgwt.client.widgets;


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
 * An object representing one of the image segments displayed by a {@link com.smartgwt.client.widgets.StretchImg}. Each
 * item of a StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getItems items} array is a StretchItem.
 */
@BeanFactory.FrameworkClass
public class StretchItem extends DataClass {

    public static StretchItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new StretchItem(jsObj);
    }
        


    public StretchItem(){
        
    }

    public StretchItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public StretchItem(String name, int width, int height) {
        setName(name);
		setWidth(width);
		setHeight(height);
                
    }


    public StretchItem(String name, int width, String height) {
        setName(name);
		setWidth(width);
		setHeight(height);
                
    }


    public StretchItem(String name, String width, int height) {
        setName(name);
		setWidth(width);
		setHeight(height);
                
    }


    public StretchItem(String name, String width, String height) {
        setName(name);
		setWidth(width);
		setHeight(height);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The height of the image. This can either be a number (for the number of pixels tall), the string "*" (remaining space,
     * divided amongst all items that specify height:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * height is only used if the StretchImg stacks its images vertically ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is true).
     *
     * @param height New height value. Default value is null
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * The height of the image. This can either be a number (for the number of pixels tall), the string "*" (remaining space,
     * divided amongst all items that specify height:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * height is only used if the StretchImg stacks its images vertically ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is true).
     *
     * @param height New height value. Default value is null
     */
    public void setHeight(String height) {
        setAttribute("height", height);
    }
    

    /**
     * A string that is appended as a suffix to the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getSrc src} URL
     * in order to fetch the media file for this StretchItem, if a separate {@link
     * com.smartgwt.client.widgets.StretchItem#getSrc src} is not provided. Note that the special name "blank", possibly
     * suffixed by one or more digits which are used to differentiate blank items, means no image will be shown for this
     * StretchItem. <p> For example, for a StretchImg in "Over" state with a {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} of "button.png" and a name of "stretch", the resulting URL
     * would be "button_Over_stretch.png".
     *
     * @param name New name value. Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * A string that is appended as a suffix to the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getSrc src} URL
     * in order to fetch the media file for this StretchItem, if a separate {@link
     * com.smartgwt.client.widgets.StretchItem#getSrc src} is not provided. Note that the special name "blank", possibly
     * suffixed by one or more digits which are used to differentiate blank items, means no image will be shown for this
     * StretchItem. <p> For example, for a StretchImg in "Over" state with a {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} of "button.png" and a name of "stretch", the resulting URL
     * would be "button_Over_stretch.png".
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * The URL of the media file for this StretchItem.
     *
     * @param src New src value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSrc(String src) {
        setAttribute("src", src);
    }

    /**
     * The URL of the media file for this StretchItem.
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * The width of the image. This can either be a number (for the number of pixels wide), the string "*" (remaining space,
     * divided amongst all items that specify width:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * width is only used if the StretchImg stacks its images horizontally ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is false).
     *
     * @param width New width value. Default value is null
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * The width of the image. This can either be a number (for the number of pixels wide), the string "*" (remaining space,
     * divided amongst all items that specify width:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * width is only used if the StretchImg stacks its images horizontally ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is false).
     *
     * @param width New width value. Default value is null
     */
    public void setWidth(String width) {
        setAttribute("width", width);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * The width of the image. This can either be a number (for the number of pixels wide), the string "*" (remaining space,
     * divided amongst all items that specify width:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * width is only used if the StretchImg stacks its images horizontally ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false).
     * 
     * @return Integer or String
     */
    public Object getWidth() {
        return getAttributeAsObject("width");
    }

    /**
     * The height of the image. This can either be a number (for the number of pixels tall), the string "*" (remaining space,
     * divided amongst all items that specify height:"*"), or the name of a property on the StretchImg component, such as
     * "capSize" for the StretchImg's {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize}. <p> <b>NOTE:</b> The
     * height is only used if the StretchImg stacks its images vertically ({@link
     * com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true).
     * 
     * @return Integer or String
     */
    public Object getHeight() {
        return getAttributeAsObject("height");
    }

}
