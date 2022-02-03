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
 
package com.smartgwt.client.widgets.layout;


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
 * Represents the position of a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
 * com.smartgwt.client.widgets.layout.PortalLayout}, indicating the column, row, and position within the row.
 */
@BeanFactory.FrameworkClass
public class PortalPosition extends DataClass {

    public static PortalPosition getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new PortalPosition(jsObj);
    }
        


    public PortalPosition(){
        
    }

    public PortalPosition(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The column number occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout}.
     *
     * @param colNum New colNum value. Default value is 0
     */
    public void setColNum(int colNum) {
        setAttribute("colNum", colNum);
    }

    /**
     * The column number occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout}.
     *
     * @return Current colNum value. Default value is 0
     */
    public int getColNum()  {
        return getAttributeAsInt("colNum");
    }
    

    /**
     * The position occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout} row (generally 0, unless there is more than one Portlet in the row).
     *
     * @param position New position value. Default value is 0
     */
    public void setPosition(int position) {
        setAttribute("position", position);
    }

    /**
     * The position occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout} row (generally 0, unless there is more than one Portlet in the row).
     *
     * @return Current position value. Default value is 0
     */
    public int getPosition()  {
        return getAttributeAsInt("position");
    }
    

    /**
     * The row number occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout} column.
     *
     * @param rowNum New rowNum value. Default value is 0
     */
    public void setRowNum(int rowNum) {
        setAttribute("rowNum", rowNum);
    }

    /**
     * The row number occupied by a {@link com.smartgwt.client.widgets.layout.Portlet} within a {@link
     * com.smartgwt.client.widgets.layout.PortalLayout} column.
     *
     * @return Current rowNum value. Default value is 0
     */
    public int getRowNum()  {
        return getAttributeAsInt("rowNum");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
