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
 * A set of properties that can be used to create an image.
 */
@BeanFactory.FrameworkClass
public class ImgProperties extends DataClass {

    public static ImgProperties getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new ImgProperties(jsObj);
    }
        


    public ImgProperties(){
        
    }

    public ImgProperties(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public ImgProperties(String src, int width, int height) {
        setSrc(src);
		setWidth(width);
		setHeight(height);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Specifies the additional event-related attributes to write in the tag.
     *
     * @param eventStuff New eventStuff value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.ImgProperties#setExtraStuff
     */
    public ImgProperties setEventStuff(String eventStuff) {
        return (ImgProperties)setAttribute("eventStuff", eventStuff);
    }

    /**
     * Specifies the additional event-related attributes to write in the tag.
     *
     * @return Current eventStuff value. Default value is null
     * @see com.smartgwt.client.widgets.ImgProperties#getExtraStuff
     */
    public String getEventStuff()  {
        return getAttributeAsString("eventStuff");
    }
    

    /**
     * Specifies the additional attributes to write in the tag.  Event-related attributes should be added to {@link
     * com.smartgwt.client.widgets.ImgProperties#getEventStuff eventStuff} instead to guarantee proper behavior when using SVG
     * images.
     *
     * @param extraStuff New extraStuff value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     */
    public ImgProperties setExtraStuff(String extraStuff) {
        return (ImgProperties)setAttribute("extraStuff", extraStuff);
    }

    /**
     * Specifies the additional attributes to write in the tag.  Event-related attributes should be added to {@link
     * com.smartgwt.client.widgets.ImgProperties#getEventStuff eventStuff} instead to guarantee proper behavior when using SVG
     * images.
     *
     * @return Current extraStuff value. Default value is null
     */
    public String getExtraStuff()  {
        return getAttributeAsString("extraStuff");
    }
    

    /**
     * Specifies the height of the image.
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     */
    public ImgProperties setHeight(Integer height) {
        return (ImgProperties)setAttribute("height", height);
    }

    /**
     * Specifies the height of the image.
     *
     * @return Current height value. Default value is null
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * Specifies the image-specific image directory to override the default.
     *
     * @param imgDir New imgDir value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public ImgProperties setImgDir(String imgDir) {
        return (ImgProperties)setAttribute("imgDir", imgDir);
    }

    /**
     * Specifies the image-specific image directory to override the default.
     *
     * @return Current imgDir value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getImgDir()  {
        return getAttributeAsString("imgDir");
    }
    

    /**
     * Specifies the name of the image. This is an identifier unique to the canvas, and subsequent calls to <code>{@link
     * com.smartgwt.client.widgets.Canvas#getImage Canvas.getImage()}</code> and <code>{@link
     * com.smartgwt.client.widgets.Canvas#setImage Canvas.setImage()}</code> with this name will act on the image object
     * created using this ImgProperties object.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     */
    public ImgProperties setName(String name) {
        return (ImgProperties)setAttribute("name", name);
    }

    /**
     * Specifies the name of the image. This is an identifier unique to the canvas, and subsequent calls to <code>{@link
     * com.smartgwt.client.widgets.Canvas#getImage Canvas.getImage()}</code> and <code>{@link
     * com.smartgwt.client.widgets.Canvas#setImage Canvas.setImage()}</code> with this name will act on the image object
     * created using this ImgProperties object.
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Specifies the URL of the image local to the skin or application directory.
     *
     * @param src New src value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public ImgProperties setSrc(String src) {
        return (ImgProperties)setAttribute("src", src);
    }

    /**
     * Specifies the URL of the image local to the skin or application directory.
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Specifies the width of the image.
     *
     * @param width New width value. Default value is null
     * @return {@link com.smartgwt.client.widgets.ImgProperties ImgProperties} instance, for chaining setter calls
     */
    public ImgProperties setWidth(Integer width) {
        return (ImgProperties)setAttribute("width", width);
    }

    /**
     * Specifies the width of the image.
     *
     * @return Current width value. Default value is null
     */
    public Integer getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
