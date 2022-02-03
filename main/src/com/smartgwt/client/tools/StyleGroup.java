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
 
package com.smartgwt.client.tools;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * An ordinary JavaScript object with properties that define an editable group of  {@link
 * com.smartgwt.client.tools.StyleSetting settings} for use in {@link com.smartgwt.client.tools.CSSEditor}s.
 */
@BeanFactory.FrameworkClass
public class StyleGroup extends DataClass {

    public static StyleGroup getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new StyleGroup(jsObj);
    }
        


    public StyleGroup(){
        
    }

    public StyleGroup(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Does this group allow items to be edited asymmetrically?  For example, should settings like <code>padding</code> allow
     * each side to be specified separately?
     *
     * @param allowAsymmetry New allowAsymmetry value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     */
    public StyleGroup setAllowAsymmetry(Boolean allowAsymmetry) {
        return (StyleGroup)setAttribute("allowAsymmetry", allowAsymmetry);
    }

    /**
     * Does this group allow items to be edited asymmetrically?  For example, should settings like <code>padding</code> allow
     * each side to be specified separately?
     *
     * @return Current allowAsymmetry value. Default value is null
     */
    public Boolean getAllowAsymmetry()  {
        return getAttributeAsBoolean("allowAsymmetry", true);
    }
    

    /**
     * Can this group's section be collapsed?
     *
     * @param canCollapse New canCollapse value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     */
    public StyleGroup setCanCollapse(Boolean canCollapse) {
        return (StyleGroup)setAttribute("canCollapse", canCollapse);
    }

    /**
     * Can this group's section be collapsed?
     *
     * @return Current canCollapse value. Default value is null
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse", true);
    }
    

    /**
     * Should this group's section be expanded?
     *
     * @param expanded New expanded value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     */
    public StyleGroup setExpanded(Boolean expanded) {
        return (StyleGroup)setAttribute("expanded", expanded);
    }

    /**
     * Should this group's section be expanded?
     *
     * @return Current expanded value. Default value is null
     */
    public Boolean getExpanded()  {
        return getAttributeAsBoolean("expanded", true);
    }
    

    /**
     * Unique name that identifies this group.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     */
    public StyleGroup setName(String name) {
        return (StyleGroup)setAttribute("name", name);
    }

    /**
     * Unique name that identifies this group.
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * The array of {@link com.smartgwt.client.tools.StyleSetting settings} to make available for editing in this  group.
     *
     * @param settings New settings value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     */
    public StyleGroup setSettings(StyleSetting... settings) {
        return (StyleGroup)setAttribute("settings", settings);
    }

    /**
     * The array of {@link com.smartgwt.client.tools.StyleSetting settings} to make available for editing in this  group.
     *
     * @return Current settings value. Default value is null
     */
    public StyleSetting[] getSettings()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfStyleSetting(getAttributeAsJavaScriptObject("settings"));
    }
    

    /**
     * Title to display in the header for this group.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleGroup StyleGroup} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTML HTML 
     */
    public StyleGroup setTitle(String title) {
        return (StyleGroup)setAttribute("title", title);
    }

    /**
     * Title to display in the header for this group.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTML HTML 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
