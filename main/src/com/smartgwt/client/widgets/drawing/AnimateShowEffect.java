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
 
package com.smartgwt.client.widgets.drawing;


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
 * Configuration object for effect to apply during an animated show or hide.
 */
@BeanFactory.FrameworkClass
public class AnimateShowEffect extends DataClass {

    public static AnimateShowEffect getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new AnimateShowEffect(jsObj);
    }
        


    public AnimateShowEffect(){
        
    }

    public AnimateShowEffect(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Effect to apply
     *
     * @param effect New effect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect AnimateShowEffect} instance, for chaining setter calls
     */
    public AnimateShowEffect setEffect(AnimationEffect effect) {
        return (AnimateShowEffect)setAttribute("effect", effect == null ? null : effect.getValue());
    }

    /**
     * Effect to apply
     *
     * @return Current effect value. Default value is null
     */
    public AnimationEffect getEffect()  {
        return EnumUtil.getEnum(AnimationEffect.values(), getAttribute("effect"));
    }
    

    /**
     * For hide animations of type <code>"wipe</code> and    <code>"slide"</code> this attribute specifies where the wipe /
     * slide should finish.   Valid options are <code>"T"</code> (vertical animation upwards to the top of the canvas,   the
     * default behavior) and <code>"L"</code> (horizontal animation to the left of the   canvas).
     *
     * @param endAt New endAt value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect AnimateShowEffect} instance, for chaining setter calls
     */
    public AnimateShowEffect setEndAt(String endAt) {
        return (AnimateShowEffect)setAttribute("endAt", endAt);
    }

    /**
     * For hide animations of type <code>"wipe</code> and    <code>"slide"</code> this attribute specifies where the wipe /
     * slide should finish.   Valid options are <code>"T"</code> (vertical animation upwards to the top of the canvas,   the
     * default behavior) and <code>"L"</code> (horizontal animation to the left of the   canvas).
     *
     * @return Current endAt value. Default value is null
     */
    public String getEndAt()  {
        return getAttributeAsString("endAt");
    }
    

    /**
     * Use {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect#getEndAt endAt} instead.
     *
     * @param endsAt New endsAt value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect AnimateShowEffect} instance, for chaining setter calls
     * @deprecated This property was misnamed.
     */
    public AnimateShowEffect setEndsAt(String endsAt) {
        return (AnimateShowEffect)setAttribute("endsAt", endsAt);
    }

    /**
     * Use {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect#getEndAt endAt} instead.
     *
     * @return Current endsAt value. Default value is null
     * @deprecated This property was misnamed.
     */
    public String getEndsAt()  {
        return getAttributeAsString("endsAt");
    }
    

    /**
     * For show animations of type <code>"wipe"</code> and   <code>"slide"</code> this attribute specifies where the wipe /
     * slide should originate.   Valid values are <code>"T"</code> (vertical animation from the top down, the    default
     * behavior), and <code>"L"</code> (horizontal animation from the left side).
     *
     * @param startFrom New startFrom value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect AnimateShowEffect} instance, for chaining setter calls
     */
    public AnimateShowEffect setStartFrom(String startFrom) {
        return (AnimateShowEffect)setAttribute("startFrom", startFrom);
    }

    /**
     * For show animations of type <code>"wipe"</code> and   <code>"slide"</code> this attribute specifies where the wipe /
     * slide should originate.   Valid values are <code>"T"</code> (vertical animation from the top down, the    default
     * behavior), and <code>"L"</code> (horizontal animation from the left side).
     *
     * @return Current startFrom value. Default value is null
     */
    public String getStartFrom()  {
        return getAttributeAsString("startFrom");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
