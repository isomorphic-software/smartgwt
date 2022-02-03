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
 * A task that involves showing a user interface to the end user allowing the user to view and input data and press a
 * button (or do some other UI gesture) to complete the task. <P> A UserTask takes the following steps: <ul> <li>
 * Optionally show() or otherwise make visible the {@link com.smartgwt.client.util.workflow.UserTask#getTargetView
 * targetView} <li> Provide values to either a {@link com.smartgwt.client.widgets.form.DynamicForm} designated as the
 * {@link com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} or to      a {@link
 * com.smartgwt.client.widgets.form.ValuesManager} designated as the {@link
 * com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM}, via {@link
 * com.smartgwt.client.widgets.form.ValuesManager#setValues setValues()} <li> Waits for notification of completion or
 * cancellation.  The UserTask is notified of      completion if a {@link
 * com.smartgwt.client.widgets.form.fields.SubmitItem} is pressed in either the <code>targetForm</code> or      any form
 * that is a member of the <code>targetVM</code>.  Likewise a CancelItem      triggers cancellation.  Direct calls to
 * {@link com.smartgwt.client.widgets.form.DynamicForm#cancelEditing DynamicForm.cancelEditing()} or      {@link
 * com.smartgwt.client.widgets.form.DynamicForm#completeEditing DynamicForm.completeEditing()} achieve the same result.
 * <li> if cancellation occurs, the process continues to the {@link
 * com.smartgwt.client.util.workflow.UserTask#getCancelElement cancelElement} <li> if completion occurs, values are
 * retrieved from the form or valuesManager and applied      to the process state </ul>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("UserTask")
public class UserTask extends Task {

    public static UserTask getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (UserTask) obj;
        } else {
            return new UserTask(jsObj);
        }
    }
        


    public UserTask(){
        scClassName = "UserTask";
    }

    public UserTask(JavaScriptObject jsObj){
        scClassName = "UserTask";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Next element to proceed to if the task is cancelled because the {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} or {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} had <code>cancelEditing()</code> called on it.
     *
     * @param cancelElement New cancelElement value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCancelElement(String cancelElement)  throws IllegalStateException {
        setAttribute("cancelElement", cancelElement, false);
    }

    /**
     * Next element to proceed to if the task is cancelled because the {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} or {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} had <code>cancelEditing()</code> called on it.
     *
     * @return Current cancelElement value. Default value is null
     */
    public String getCancelElement()  {
        return getAttributeAsString("cancelElement");
    }
    

    /**
     * An inline definition of the form. Could be used to encode form directly in process xml.
     *
     * @param inlineView New inlineView value. Default value is null
     */
    public void setInlineView(Canvas inlineView) {
        setAttribute("inlineView", inlineView == null ? null : inlineView.getOrCreateJsObj(), true);
    }

    /**
     * An inline definition of the form. Could be used to encode form directly in process xml.
     *
     * @return Current inlineView value. Default value is null
     */
    public Canvas getInlineView()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("inlineView"));
    }
    

    /**
     * Previous workflow {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} that is helpful for wizards. This element will be
     * executed if {@link com.smartgwt.client.util.workflow.UserTask#goToPrevious goToPrevious()} method of userTask will be
     * invoked. You can get userTask for attached form by using  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getUserTask userTask} property.
     *
     * @param previousElement New previousElement value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPreviousElement(String previousElement)  throws IllegalStateException {
        setAttribute("previousElement", previousElement, false);
    }

    /**
     * Previous workflow {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} or {@link
     * com.smartgwt.client.util.workflow.Process#getElements element} that is helpful for wizards. This element will be
     * executed if {@link com.smartgwt.client.util.workflow.UserTask#goToPrevious goToPrevious()} method of userTask will be
     * invoked. You can get userTask for attached form by using  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getUserTask userTask} property.
     *
     * @return Current previousElement value. Default value is null
     */
    public String getPreviousElement()  {
        return getAttributeAsString("previousElement");
    }
    

    /**
     * If saveToServer is set then associated form will perform the normal  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit()} actions when called (typically from a {@link
     * com.smartgwt.client.widgets.form.fields.SubmitItem}). By default the form submit action is bypassed.
     *
     * @param saveToServer New saveToServer value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setSaveToServer(Boolean saveToServer)  throws IllegalStateException {
        setAttribute("saveToServer", saveToServer, false);
    }

    /**
     * If saveToServer is set then associated form will perform the normal  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit DynamicForm.submit()} actions when called (typically from a {@link
     * com.smartgwt.client.widgets.form.fields.SubmitItem}). By default the form submit action is bypassed.
     *
     * @return Current saveToServer value. Default value is false
     */
    public Boolean getSaveToServer()  {
        Boolean result = getAttributeAsBoolean("saveToServer");
        return result == null ? false : result;
    }
    

    /**
     * DynamicForm that should be populated with data and that should provide the data for the task outputs. <P> Use {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} to use a {@link
     * com.smartgwt.client.widgets.form.ValuesManager} instead.
     *
     * @param targetForm New targetForm value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTargetForm(DynamicForm targetForm)  throws IllegalStateException {
        setAttribute("targetForm", targetForm == null ? null : targetForm.getOrCreateJsObj(), false);
    }

    /**
     * DynamicForm that should be populated with data and that should provide the data for the task outputs. <P> Use {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} to use a {@link
     * com.smartgwt.client.widgets.form.ValuesManager} instead.
     *
     * @return Current targetForm value. Default value is null
     */
    public DynamicForm getTargetForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("targetForm"));
    }
    
    
    

    /**
     * If wizard is set then associated form will be hidden after user goes to next or prev step of current workflow.
     *
     * @param wizard New wizard value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setWizard(Boolean wizard)  throws IllegalStateException {
        setAttribute("wizard", wizard, false);
    }

    /**
     * If wizard is set then associated form will be hidden after user goes to next or prev step of current workflow.
     *
     * @return Current wizard value. Default value is false
     */
    public Boolean getWizard()  {
        Boolean result = getAttributeAsBoolean("wizard");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Revert any changes made in a form and finish this userTask execution.  {@link
     * com.smartgwt.client.util.workflow.UserTask#getCancelElement cancelElement} will be proceed as the next element of
     * current process.
     */
    public native void cancelEditing() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelEditing", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;

	/**
     * Finish editing and store edited values in {@link com.smartgwt.client.util.workflow.Process#getState process state}.
     */
    public native void completeEditing() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "completeEditing", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.completeEditing();
    }-*/;

	/**
     * Set {@link com.smartgwt.client.util.workflow.UserTask#getPreviousElement previousElement} as next element of workflow.
     * This method could be used to  create wizard-like UI behavior.
     */
    public native void goToPrevious() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "goToPrevious", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.goToPrevious();
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Optional widget that should be shown to allow user input.  If this widget is a DynamicForm, it will also be
     * automatically used as the {@link com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} unless either
     * <code>targetForm</code> or {@link com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} is set. <P>
     * <code>UserTask</code> will automatically handle various scenarios of the <code>targetView</code> being not currently
     * visible or draw()n, according to the following rules: <ul> <li> if the view itself is marked hidden, it will be show()n
     * <li> if the view is inside a hidden parent, the parent will be show()n <li> if the view is the {@link
     * com.smartgwt.client.widgets.tab.Tab#getPane pane} of a tab in a TabSet, the tab will be selected <li> if the view is
     * listed in {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems items} for a which is either     
     * collapsed or hidden section, the section will be shown and expanded <li> if the view is listed in {@link
     * com.smartgwt.client.widgets.Window#getItems items} for a Window, the Window will be shown <li> if any of these
     * conditions apply to any parent of the targetView, the rules will be      applied to that parent as well.  For example,
     * the targetView is in a collapsed section      inside a tab which is not selected, the section will be expanded
     * <b>and</b> the tab      selected </ul>
     *
     * @param targetView targetView Default value is null
     */
    public void setTargetView(Canvas targetView) {
        setAttribute("targetView", targetView == null ? null : targetView.getOrCreateJsObj(), false);
    }

    /**
     * Optional widget that should be shown to allow user input.  If this widget is a DynamicForm, it will also be
     * automatically used as the {@link com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} unless either
     * <code>targetForm</code> or {@link com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} is set. <P>
     * <code>UserTask</code> will automatically handle various scenarios of the <code>targetView</code> being not currently
     * visible or draw()n, according to the following rules: <ul> <li> if the view itself is marked hidden, it will be show()n
     * <li> if the view is inside a hidden parent, the parent will be show()n <li> if the view is the {@link
     * com.smartgwt.client.widgets.tab.Tab#getPane pane} of a tab in a TabSet, the tab will be selected <li> if the view is
     * listed in {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems items} for a which is either     
     * collapsed or hidden section, the section will be shown and expanded <li> if the view is listed in {@link
     * com.smartgwt.client.widgets.Window#getItems items} for a Window, the Window will be shown <li> if any of these
     * conditions apply to any parent of the targetView, the rules will be      applied to that parent as well.  For example,
     * the targetView is in a collapsed section      inside a tab which is not selected, the section will be expanded
     * <b>and</b> the tab      selected </ul>
     *
     *
     * @return Canvas
     */
    public Canvas getTargetView()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("targetView"));
    }

    /**
     * Optional widget that should be shown to allow user input.  If this widget is a DynamicForm, it will also be
     * automatically used as the {@link com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} unless either
     * <code>targetForm</code> or {@link com.smartgwt.client.util.workflow.UserTask#getTargetVM targetVM} is set. <P>
     * <code>UserTask</code> will automatically handle various scenarios of the <code>targetView</code> being not currently
     * visible or draw()n, according to the following rules: <ul> <li> if the view itself is marked hidden, it will be show()n
     * <li> if the view is inside a hidden parent, the parent will be show()n <li> if the view is the {@link
     * com.smartgwt.client.widgets.tab.Tab#getPane pane} of a tab in a TabSet, the tab will be selected <li> if the view is
     * listed in {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems items} for a which is either     
     * collapsed or hidden section, the section will be shown and expanded <li> if the view is listed in {@link
     * com.smartgwt.client.widgets.Window#getItems items} for a Window, the Window will be shown <li> if any of these
     * conditions apply to any parent of the targetView, the rules will be      applied to that parent as well.  For example,
     * the targetView is in a collapsed section      inside a tab which is not selected, the section will be expanded
     * <b>and</b> the tab      selected </ul>
     *
     * @param targetView targetView Default value is null
     */
    public void setTargetView(String targetView) {
        setAttribute("targetView", targetView, false);
    }


    /**
     * Optional ValuesManager which will receive task inputs and provide task outputs.  Use {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} instead of you want to use a DynamicForm.
     *
     * @param targetVM targetVM Default value is null
     */
    public void setTargetVM(ValuesManager targetVM) {
        setAttribute("targetVM", targetVM == null ? null : targetVM.getOrCreateJsObj(), false);
    }

    /**
     * Optional ValuesManager which will receive task inputs and provide task outputs.  Use {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} instead of you want to use a DynamicForm.
     *
     *
     * @return ValuesManager
     */
    public ValuesManager getTargetVM()  {
        return ValuesManager.getOrCreateRef(getAttributeAsJavaScriptObject("targetVM"));
    }

    /**
     * Optional ValuesManager which will receive task inputs and provide task outputs.  Use {@link
     * com.smartgwt.client.util.workflow.UserTask#getTargetForm targetForm} instead of you want to use a DynamicForm.
     *
     * @param targetVM targetVM Default value is null
     */
    public void setTargetVM(String targetVM) {
        setAttribute("targetVM", targetVM, true);
    }



}
