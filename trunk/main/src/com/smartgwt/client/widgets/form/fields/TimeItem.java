/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * FormItem for editing times in a text field.   <P> {@link com.smartgwt.client.widgets.form.fields.TimeItem#getDisplayFormat displayFormat} allows you to set the display format for this field.  See also {@link com.smartgwt.client..Time#setNormalDisplayFormat} for system-wide settings. <P> TimeItem automatically accepts both 12 and 24 hour time as well as partial times and a variety of possible time value separators.  Examples: <pre>  11:34:45 AM => 11:34:45  1:3:5 AM => 01:30:50  1:3p  => 13:30:00  11 34 am => 11:34:00  11-34  => 11:34:00  113445  => 11:34:45  13445  => 01:34:45  1134  => 11:34:00  134   => 01:34:00 </pre> <P> Values entered by the user are stored as JavaScript <code>Date</code> objects in GMT/UTC time regardless of the local time zone.  Note if you log, alert() or otherwise convert a Date into a String, the default behavior is to show it in local time.  To see the correct time value, use the JavaScript built-in APIs dateValue.getUTCHours/Minutes/Seconds() or the {@link com.smartgwt.client..Time#toShortTime}.

    */
public class TimeItem extends TextItem {

    public static TimeItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TimeItem) obj;
        } else {
            return new TimeItem(jsObj);
        }
    }


    public TimeItem(){
        setType("TimeItem");
    }

    public TimeItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public TimeItem(String name) {
        setName(name);
        setType("TimeItem");
    }

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************


    /**
     * What format should this item's time string be presented in?
     *
     * @param timeFormatter displayFormat Default value is "toShort24HourTime"
     */
    public void setDisplayFormat(TimeFormatter timeFormatter) {
        setAttribute("displayFormat", timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in?
     *
     * @return DateDisplayFormat
     */
    public TimeFormatter getDisplayFormat() {
        return (TimeFormatter) EnumUtil.getEnum(TimeFormatter.values(), getAttribute("displayFormat"));
    }

}







