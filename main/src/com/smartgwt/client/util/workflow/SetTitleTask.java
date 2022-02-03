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
 * Sets the title of a tab, section, window, label, button or form control. <P> For a label, button or window the {@link
 * com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} specifies everything necessary to identify
 * the target. <P> For a tab, section or form control more information is needed. The {@link
 * com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} identifies the container (i.e. TabSet,
 * SectionStack or DynamicForm) and the individual component is specified as: <ul> <li>Tab - {@link
 * com.smartgwt.client.util.workflow.SetTitleTask#getTargetTabName targetTabName} references the {@link
 * com.smartgwt.client.widgets.tab.Tab#getName Tab.name}.</li> <li>Section - {@link
 * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionName targetSectionName} for                {@link
 * com.smartgwt.client.widgets.layout.SectionStackSection#getName SectionStackSection.name} or {@link
 * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionTitle targetSectionTitle}                for {@link
 * com.smartgwt.client.widgets.layout.SectionStackSection#getTitle SectionStackSection.title}.</li> <li>FormItem - {@link
 * com.smartgwt.client.util.workflow.SetTitleTask#getTargetFieldName targetFieldName} for {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getName FormItem.name}.</li> </ul>
 * @see com.smartgwt.client.widgets.tab.TabSet#setTabTitle
 * @see com.smartgwt.client.widgets.layout.SectionStack#setSectionTitle
 * @see com.smartgwt.client.widgets.Window#setTitle
 * @see com.smartgwt.client.widgets.Label#setContents
 * @see com.smartgwt.client.widgets.Button#setTitle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getTitle
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SetTitleTask")
public class SetTitleTask extends ComponentTask {

    public static SetTitleTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (SetTitleTask) obj;
        } else {
            return new SetTitleTask(jsObj);
        }
    }
        


    public SetTitleTask(){
        scClassName = "SetTitleTask";
    }

    public SetTitleTask(JavaScriptObject jsObj){
        scClassName = "SetTitleTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field to assign new title.
     *
     * @param targetFieldName New targetFieldName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public SetTitleTask setTargetFieldName(String targetFieldName)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("targetFieldName", targetFieldName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a DynamicForm, this
     * property specifies the name of the target field to assign new title.
     *
     * @return Current targetFieldName value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getTargetFieldName()  {
        return getAttributeAsString("targetFieldName");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the name of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionTitle targetSectionTitle}.
     *
     * @param targetSectionName New targetSectionName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SetTitleTask setTargetSectionName(String targetSectionName)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("targetSectionName", targetSectionName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the name of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionTitle targetSectionTitle}.
     *
     * @return Current targetSectionName value. Default value is null
     */
    public String getTargetSectionName()  {
        return getAttributeAsString("targetSectionName");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the title of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionName targetSectionName}.
     *
     * @param targetSectionTitle New targetSectionTitle value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SetTitleTask setTargetSectionTitle(String targetSectionTitle)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("targetSectionTitle", targetSectionTitle, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a SectionStack, this
     * property specifies the title of the target section. Alternately, the target section can be specified by using {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTargetSectionName targetSectionName}.
     *
     * @return Current targetSectionTitle value. Default value is null
     */
    public String getTargetSectionTitle()  {
        return getAttributeAsString("targetSectionTitle");
    }
    

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a TabSet, this property
     * specifies the name or ID of the target tab to assign new title.
     *
     * @param targetTabName New targetTabName value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public SetTitleTask setTargetTabName(String targetTabName)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("targetTabName", targetTabName, false);
    }

    /**
     * If {@link com.smartgwt.client.util.workflow.ComponentTask#getComponentId componentId} targets a TabSet, this property
     * specifies the name or ID of the target tab to assign new title.
     *
     * @return Current targetTabName value. Default value is null
     * @see com.smartgwt.client.docs.TabName TabName 
     */
    public String getTargetTabName()  {
        return getAttributeAsString("targetTabName");
    }
    

    /**
     * Formula to be used to calculate the component title. Use {@link com.smartgwt.client.util.workflow.SetTitleTask#getTitle
     * title} property to assign a static title instead. <p>  Available fields for use in the formula are the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @param textFormula New textFormula value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SetTitleTask setTextFormula(UserSummary textFormula)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj(), false);
    }

    /**
     * Formula to be used to calculate the component title. Use {@link com.smartgwt.client.util.workflow.SetTitleTask#getTitle
     * title} property to assign a static title instead. <p>  Available fields for use in the formula are the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.
     *
     * @return Current textFormula value. Default value is null
     */
    public UserSummary getTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("textFormula"));
    }
    

    /**
     * Title to assign to component. To assign a dynamic value see {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTextFormula textFormula}.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.util.workflow.SetTitleTask SetTitleTask} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public SetTitleTask setTitle(String title)  throws IllegalStateException {
        return (SetTitleTask)setAttribute("title", title, false);
    }

    /**
     * Title to assign to component. To assign a dynamic value see {@link
     * com.smartgwt.client.util.workflow.SetTitleTask#getTextFormula textFormula}.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
