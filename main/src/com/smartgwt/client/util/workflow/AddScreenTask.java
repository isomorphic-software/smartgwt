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
 
package com.smartgwt.client.util.workflow;


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
 * Adds a new screen instance to a Layout, as a new Tab in a TabSet or as a new Section in a SectionStack. When the target
 * is a TabSet or SectionStack, a static {@link com.smartgwt.client.util.workflow.AddScreenTask#getTitle title} or dynamic
 * {@link com.smartgwt.client.util.workflow.AddScreenTask#getTitleFormula titleFormula} can be assigned for the new Tab or
 * Section. <p> The new screen's {@link com.smartgwt.client.widgets.Canvas#getDataContext dataContext} can be configured
 * with {@link com.smartgwt.client.util.workflow.AddScreenTask#getDataContextBinding dataContextBinding} evaluated in the
 * scope of this task.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("AddScreenTask")
public class AddScreenTask extends ComponentTask {

    public static AddScreenTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (AddScreenTask) obj;
        } else {
            return new AddScreenTask(jsObj);
        }
    }
        


    public AddScreenTask(){
        scClassName = "AddScreenTask";
    }

    public AddScreenTask(JavaScriptObject jsObj){
        scClassName = "AddScreenTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Can the created SectionStackSection or TabSet be closed by the user?
     *
     * @param canClose New canClose value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.AddScreenTask AddScreenTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public AddScreenTask setCanClose(Boolean canClose)  throws IllegalStateException {
        return (AddScreenTask)setAttribute("canClose", canClose, false);
    }

    /**
     * Can the created SectionStackSection or TabSet be closed by the user?
     *
     * @return Current canClose value. Default value is null
     */
    public Boolean getCanClose()  {
        return getAttributeAsBoolean("canClose");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.DataContextBinding} to be applied to the created screen via {@link
     * com.smartgwt.client.widgets.Canvas#setDataContext Canvas.setDataContext()}.
     *
     * @param dataContextBinding New dataContextBinding value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.AddScreenTask AddScreenTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public AddScreenTask setDataContextBinding(DataContextBinding dataContextBinding)  throws IllegalStateException {
        return (AddScreenTask)setAttribute("dataContextBinding", dataContextBinding == null ? null : dataContextBinding.getJsObj(), false);
    }

    /**
     * A {@link com.smartgwt.client.widgets.DataContextBinding} to be applied to the created screen via {@link
     * com.smartgwt.client.widgets.Canvas#setDataContext Canvas.setDataContext()}.
     *
     * @return Current dataContextBinding value. Default value is null
     */
    public DataContextBinding getDataContextBinding()  {
        return new DataContextBinding(getAttributeAsJavaScriptObject("dataContextBinding"));
    }
    

    /**
     * Name of screen to be added.
     *
     * @param screenName New screenName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.AddScreenTask AddScreenTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public AddScreenTask setScreenName(String screenName)  throws IllegalStateException {
        return (AddScreenTask)setAttribute("screenName", screenName, false);
    }

    /**
     * Name of screen to be added.
     *
     * @return Current screenName value. Default value is null
     */
    public String getScreenName()  {
        return getAttributeAsString("screenName");
    }
    

    /**
     * Title of new SectionStackSection or TabSet when {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId
     * componentId} targets a SectionStack or TabSet. To use a dynamic title see {@link
     * com.smartgwt.client.util.workflow.AddScreenTask#getTitleFormula titleFormula}.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.AddScreenTask AddScreenTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public AddScreenTask setTitle(String title)  throws IllegalStateException {
        return (AddScreenTask)setAttribute("title", title, false);
    }

    /**
     * Title of new SectionStackSection or TabSet when {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId
     * componentId} targets a SectionStack or TabSet. To use a dynamic title see {@link
     * com.smartgwt.client.util.workflow.AddScreenTask#getTitleFormula titleFormula}.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Formula to be used to calculate the title contents. Use {@link com.smartgwt.client.util.workflow.AddScreenTask#getTitle
     * title} property to assign a static title instead. <p>  Available fields for use in the formula are the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @param titleFormula New titleFormula value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.AddScreenTask AddScreenTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public AddScreenTask setTitleFormula(UserSummary titleFormula)  throws IllegalStateException {
        return (AddScreenTask)setAttribute("titleFormula", titleFormula == null ? null : titleFormula.getJsObj(), false);
    }

    /**
     * Formula to be used to calculate the title contents. Use {@link com.smartgwt.client.util.workflow.AddScreenTask#getTitle
     * title} property to assign a static title instead. <p>  Available fields for use in the formula are the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @return Current titleFormula value. Default value is null
     */
    public UserSummary getTitleFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("titleFormula"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
