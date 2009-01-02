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
import com.google.gwt.event.logical.shared.HasHandlers;
   /**
    * A FormItem that displays an HTML link

    */
public class LinkItem extends StaticTextItem {

    public static LinkItem getOrCreateRef(JavaScriptObject jsObj) {
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (LinkItem) obj;
        } else {
            return new LinkItem(jsObj);
        }
    }


    public LinkItem(){
        setType("LinkItem");
    }

    public LinkItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public LinkItem(String name) {
        setName(name);
        setType("LinkItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * By default, clicking a link rendered by this item opens it in a new browser window.  You can alter this behavior by setting this property.  The value of this property will be passed as the value to the <code>target</code> attribute of the anchor tag used to render the link.
    *
    * @param target target Default value is "_blank"
    */
    public void setTarget(String target) {
        setAttribute("target", target);
    }
    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You can alter this behavior by setting this property.  The value of this property will be passed as the value to the <code>target</code> attribute of the anchor tag used to render the link.
     *
     *
     * @return String
     *
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }

    /**
    * Optional title text to display for this item's link. If unspecified the value of the item will be the title text as well as the target of the link.
    * Method to set the linkTitle for this item
    *
    * @param linkTitle new linkTitle for this item. Default value is null
    */
    public void setLinkTitle(String linkTitle) {
        setAttribute("linkTitle", linkTitle);
    }
    /**
     * Optional title text to display for this item's link. If unspecified the value of the item will be the title text as well as the target of the link.
     *
     *
     * @return String
     *
     */
    public String getLinkTitle()  {
        return getAttributeAsString("linkTitle");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************

}



