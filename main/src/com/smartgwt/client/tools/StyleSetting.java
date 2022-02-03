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
 * An ordinary JavaScript object with properties that configure a setting for use in a {@link
 * com.smartgwt.client.tools.CSSEditor CSS-editor}.
 */
@BeanFactory.FrameworkClass
public class StyleSetting extends DataClass {

    public static StyleSetting getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new StyleSetting(jsObj);
    }
        


    public StyleSetting(){
        
    }

    public StyleSetting(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Can this setting be edited asymmetrically?  For example, a border-setting can be applied to all sides at once, or
     * asymmetrically to each side, as four separate border-settings.
     *
     * @param allowAsymmetry New allowAsymmetry value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setAllowAsymmetry(Boolean allowAsymmetry) {
        return (StyleSetting)setAttribute("allowAsymmetry", allowAsymmetry);
    }

    /**
     * Can this setting be edited asymmetrically?  For example, a border-setting can be applied to all sides at once, or
     * asymmetrically to each side, as four separate border-settings.
     *
     * @return Current allowAsymmetry value. Default value is null
     */
    public Boolean getAllowAsymmetry()  {
        return getAttributeAsBoolean("allowAsymmetry", true);
    }
    

    /**
     * The type of editor to use for this setting.
     *
     * @param defaultEditorType New defaultEditorType value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setDefaultEditorType(FormItemType defaultEditorType) {
        return (StyleSetting)setAttribute("defaultEditorType", defaultEditorType == null ? null : defaultEditorType.getValue());
    }

    /**
     * The type of editor to use for this setting.
     *
     * @return Current defaultEditorType value. Default value is null
     */
    public FormItemType getDefaultEditorType()  {
        return EnumUtil.getEnum(FormItemType.values(), getAttribute("defaultEditorType"));
    }
    

    /**
     * FormItem properties to apply to editors for this setting.
     *
     * @param editorProperties New editorProperties value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setEditorProperties(FormItem editorProperties) {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(StyleSetting.class, "setEditorProperties", "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);
        return (StyleSetting)setAttribute("editorProperties", editorProperties == null ? null : editorProperties.getEditorTypeConfig());
    }

    /**
     * FormItem properties to apply to editors for this setting.
     *
     * @return Current editorProperties value. Default value is null
     */
    public FormItem getEditorProperties()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("editorProperties"));
    }
    

    /**
     * Name of the {@link com.smartgwt.client.tools.StyleGroup group} this setting will appear in for editing.
     *
     * @param groupName New groupName value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setGroupName(String groupName) {
        return (StyleSetting)setAttribute("groupName", groupName);
    }

    /**
     * Name of the {@link com.smartgwt.client.tools.StyleGroup group} this setting will appear in for editing.
     *
     * @return Current groupName value. Default value is null
     */
    public String getGroupName()  {
        return getAttributeAsString("groupName");
    }
    

    /**
     * Unique name that identifies this setting.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setName(String name) {
        return (StyleSetting)setAttribute("name", name);
    }

    /**
     * Unique name that identifies this setting.
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * The CSS attribute name used when generating CSS from this item.  Rarely used to override the default behavior of using
     * the {@link com.smartgwt.client.tools.StyleSetting#getName name}.
     *
     * @param settingName New settingName value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setSettingName(String settingName) {
        return (StyleSetting)setAttribute("settingName", settingName);
    }

    /**
     * The CSS attribute name used when generating CSS from this item.  Rarely used to override the default behavior of using
     * the {@link com.smartgwt.client.tools.StyleSetting#getName name}.
     *
     * @return Current settingName value. Default value is null
     */
    public String getSettingName()  {
        return getAttributeAsString("settingName");
    }
    

    /**
     * If this setting allows {@link com.smartgwt.client.tools.StyleSetting#getAllowAsymmetry asymmetric editing}, should it be
     * edited in that mode by default?
     *
     * @param showAsymmetry New showAsymmetry value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setShowAsymmetry(Boolean showAsymmetry) {
        return (StyleSetting)setAttribute("showAsymmetry", showAsymmetry);
    }

    /**
     * If this setting allows {@link com.smartgwt.client.tools.StyleSetting#getAllowAsymmetry asymmetric editing}, should it be
     * edited in that mode by default?
     *
     * @return Current showAsymmetry value. Default value is null
     */
    public Boolean getShowAsymmetry()  {
        return getAttributeAsBoolean("showAsymmetry", true);
    }
    

    /**
     * Title for this setting when applied to a FormItem.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.tools.StyleSetting StyleSetting} instance, for chaining setter calls
     */
    public StyleSetting setTitle(String title) {
        return (StyleSetting)setAttribute("title", title);
    }

    /**
     * Title for this setting when applied to a FormItem.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
