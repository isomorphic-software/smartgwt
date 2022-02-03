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
 
package com.smartgwt.client.widgets.tree;


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
 * Defines a set of properties that specify how the tree will be explored by {@link
 * com.smartgwt.client.widgets.tree.Tree#discoverTree Tree.discoverTree()}
 */
@BeanFactory.FrameworkClass
public class DiscoverTreeSettings extends DataClass {

    public static DiscoverTreeSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DiscoverTreeSettings(jsObj);
    }
        


    public DiscoverTreeSettings(){
        
    }

    public DiscoverTreeSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * When heuristically finding a property that appears to contain child objects, the childrenMode determines how to chose
     * the property that appears to contain child objects
     *
     * @param childrenMode New childrenMode value. Default value is ChildrenPropertyMode.ANY
     */
    public void setChildrenMode(ChildrenPropertyMode childrenMode) {
        setAttribute("childrenMode", childrenMode == null ? null : childrenMode.getValue());
    }

    /**
     * When heuristically finding a property that appears to contain child objects, the childrenMode determines how to chose
     * the property that appears to contain child objects
     *
     * @return Current childrenMode value. Default value is ChildrenPropertyMode.ANY
     */
    public ChildrenPropertyMode getChildrenMode()  {
        return EnumUtil.getEnum(ChildrenPropertyMode.values(), getAttribute("childrenMode"));
    }
    

    /**
     * For string leaf nodes (if allowed), the name of the property to store the string under in the auto-created object
     *
     * @param nameProperty New nameProperty value. Default value is null
     */
    public void setNameProperty(String nameProperty) {
        setAttribute("nameProperty", nameProperty);
    }

    /**
     * For string leaf nodes (if allowed), the name of the property to store the string under in the auto-created object
     *
     * @return Current nameProperty value. Default value is null
     */
    public String getNameProperty()  {
        return getAttributeAsString("nameProperty");
    }
    

    /**
     * What to rename the array of children once discovered. If not set, it will default to the value of {@link
     * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty Tree.childrenProperty} inside discoverTree()
     *
     * @param newChildrenProperty New newChildrenProperty value. Default value is null (see below)
     */
    public void setNewChildrenProperty(String newChildrenProperty) {
        setAttribute("newChildrenProperty", newChildrenProperty);
    }

    /**
     * What to rename the array of children once discovered. If not set, it will default to the value of {@link
     * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty Tree.childrenProperty} inside discoverTree()
     *
     * @return Current newChildrenProperty value. Default value is null (see below)
     */
    public String getNewChildrenProperty()  {
        return getAttributeAsString("newChildrenProperty");
    }
    

    /**
     * Determines how to scan for the {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty Tree.childrenProperty}
     *
     * @param scanMode New scanMode value. Default value is ScanMode.BRANCH
     */
    public void setScanMode(ScanMode scanMode) {
        setAttribute("scanMode", scanMode == null ? null : scanMode.getValue());
    }

    /**
     * Determines how to scan for the {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty Tree.childrenProperty}
     *
     * @return Current scanMode value. Default value is ScanMode.BRANCH
     */
    public ScanMode getScanMode()  {
        return EnumUtil.getEnum(ScanMode.values(), getAttribute("scanMode"));
    }
    

    /**
     * What to do if there is more than one possible {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty
     * Tree.childrenProperty} when using scanMode "branch" or "level"
     *
     * @param tieMode New tieMode value. Default value is TieMode.NODE
     */
    public void setTieMode(TieMode tieMode) {
        setAttribute("tieMode", tieMode == null ? null : tieMode.getValue());
    }

    /**
     * What to do if there is more than one possible {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty
     * Tree.childrenProperty} when using scanMode "branch" or "level"
     *
     * @return Current tieMode value. Default value is TieMode.NODE
     */
    public TieMode getTieMode()  {
        return EnumUtil.getEnum(TieMode.values(), getAttribute("tieMode"));
    }
    

    /**
     * Each discovered child is labeled with a configurable "typeProperty" set to the value of the property that held the
     * children
     *
     * @param typeProperty New typeProperty value. Default value is null
     */
    public void setTypeProperty(String typeProperty) {
        setAttribute("typeProperty", typeProperty);
    }

    /**
     * Each discovered child is labeled with a configurable "typeProperty" set to the value of the property that held the
     * children
     *
     * @return Current typeProperty value. Default value is null
     */
    public String getTypeProperty()  {
        return getAttributeAsString("typeProperty");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
