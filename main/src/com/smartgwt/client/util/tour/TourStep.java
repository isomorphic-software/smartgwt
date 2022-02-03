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
 
package com.smartgwt.client.util.tour;


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
 * User task configuration for a step within a {@link com.smartgwt.client.util.tour.Tour}. As each step is executed, it
 * will show  a {@link com.smartgwt.client.widgets.tour.TourWindow} to the user (the automatically generated {@link
 * com.smartgwt.client.util.tour.TourStep#getTargetView targetView}). <P> At a minimum tourSteps will typically have a
 * {@link com.smartgwt.client.util.tour.TourStep#getTitle title} and/or  {@link
 * com.smartgwt.client.util.workflow.ProcessElement#getDescription description}. Without a {@link
 * com.smartgwt.client.util.tour.TourStep#getTarget target} the window will be shown in the center of the screen. <P> To
 * relate the step to a component provide a {@link com.smartgwt.client.util.tour.TourStep#getTarget target} value. An
 * {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType} value determines what action, if any, is
 * expected with the <code>target</code>. Some <code>actionTypes</code> like "none" and "any" just highlight the target for
 * review and the user must click the next button to complete the step. Others like "click" or "change" expect the user to
 * interact with the target component in a certain way. Many of these will advance to the next step when the required
 * action is completed. See {@link com.smartgwt.client.types.TourActionType action types} for  details. <P> In most cases
 * the <code>actionType</code> can be left unset because a default is applied based on the other step properties and the
 * {@link com.smartgwt.client.util.tour.Tour#getMode Tour.mode}. However, actions like <code>doubleClick</code>,
 * <code>rightClick</code> and <code>mouseOver</code> must be provided. <P> To explicitly suppress automatic completion of
 * a step on user interaction, devlopers may set {@link com.smartgwt.client.util.tour.TourStep#getAutoComplete
 * autoComplete} to false.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TourStep")
public class TourStep extends UserTask {

    public static TourStep getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TourStep) obj;
        } else {
            return new TourStep(jsObj);
        }
    }
        


    public TourStep(){
        scClassName = "TourStep";
    }

    public TourStep(JavaScriptObject jsObj){
        scClassName = "TourStep";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView}. Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle Tour.stepActionButtonTitle}.
     *
     * @param actionButtonTitle New actionButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TourStep setActionButtonTitle(String actionButtonTitle)  throws IllegalStateException {
        return (TourStep)setAttribute("actionButtonTitle", actionButtonTitle, false);
    }

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView}. Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle Tour.stepActionButtonTitle}.
     *
     * @return Current actionButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getActionButtonTitle()  {
        return getAttributeAsString("actionButtonTitle");
    }
    

    /**
     * Indicates the type of action that is expected with the {@link com.smartgwt.client.util.tour.TourStep#getTarget target
     * component}. <P> If not specified a default type is determined by the {@link com.smartgwt.client.util.tour.Tour#getMode
     * Tour.mode} setting, the target and other tourStep properties. <P> <b>Details:</b> <P> when <code>tourMode</code> is
     * "tour"     <ul>       <li>then actionType = "none"     </ul> <P> when <code>tourMode</code> is "tutorial"     <ul>      
     * <li>and <code>expectedValue</code> or <code>afterInputTarget</code> are set         <ul>           <li>then actionType =
     * "change"         </ul>       </li>       <li>and <code>dropTarget</code> is set         <ul>           <li>then
     * actionType = "drag"         </ul>       </li>       <li>otherwise         <ul>           <li>actionType = "click"       
     *  </ul>       </li>     </ul>
     *
     * @param actionType New actionType value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setActionType(TourActionType actionType)  throws IllegalStateException {
        return (TourStep)setAttribute("actionType", actionType == null ? null : actionType.getValue(), false);
    }

    /**
     * Indicates the type of action that is expected with the {@link com.smartgwt.client.util.tour.TourStep#getTarget target
     * component}. <P> If not specified a default type is determined by the {@link com.smartgwt.client.util.tour.Tour#getMode
     * Tour.mode} setting, the target and other tourStep properties. <P> <b>Details:</b> <P> when <code>tourMode</code> is
     * "tour"     <ul>       <li>then actionType = "none"     </ul> <P> when <code>tourMode</code> is "tutorial"     <ul>      
     * <li>and <code>expectedValue</code> or <code>afterInputTarget</code> are set         <ul>           <li>then actionType =
     * "change"         </ul>       </li>       <li>and <code>dropTarget</code> is set         <ul>           <li>then
     * actionType = "drag"         </ul>       </li>       <li>otherwise         <ul>           <li>actionType = "click"       
     *  </ul>       </li>     </ul>
     *
     * @return Current actionType value. Default value is null
     */
    public TourActionType getActionType()  {
        return EnumUtil.getEnum(TourActionType.values(), getAttribute("actionType"));
    }
    

    /**
     * Target component which must clicked to process {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue
     * expectedValue} entered into {@link com.smartgwt.client.util.tour.TourStep#getTarget target} with {@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType} of "change". <P> This is commonly used for a dialog
     * where the must select a value and then click a submit button. <P> Target may be specified as a {@link
     * com.smartgwt.client.docs.GlobalId} for a Component or FormItem, or as a {@link com.smartgwt.client.docs.AutoTestLocator}
     * for an element.
     *
     * @param afterInputTarget New afterInputTarget value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setAfterInputTarget(String afterInputTarget)  throws IllegalStateException {
        return (TourStep)setAttribute("afterInputTarget", afterInputTarget, false);
    }

    /**
     * Target component which must clicked to process {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue
     * expectedValue} entered into {@link com.smartgwt.client.util.tour.TourStep#getTarget target} with {@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType} of "change". <P> This is commonly used for a dialog
     * where the must select a value and then click a submit button. <P> Target may be specified as a {@link
     * com.smartgwt.client.docs.GlobalId} for a Component or FormItem, or as a {@link com.smartgwt.client.docs.AutoTestLocator}
     * for an element.
     *
     * @return Current afterInputTarget value. Default value is null
     */
    public String getAfterInputTarget()  {
        return getAttributeAsString("afterInputTarget");
    }
    

    /**
     * For {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType:"drag"} tourSteps with a {@link
     * com.smartgwt.client.util.tour.TourStep#getDropTarget dropTarget}, should we allow the drop to complete and the tour to
     * proceed if the user drops on a descendant of the drop target. <P> For example - if a user has been prompted to drag a
     * component into a Layout, but  the layout already contains a nested child layout, should the user be able to  drop into
     * that child layout and continue the tour? <P> If unset this will be derived from {@link
     * com.smartgwt.client.util.tour.Tour#getAllowDropOnDescendants Tour.allowDropOnDescendants}
     *
     * @param allowDropOnDescendants New allowDropOnDescendants value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setAllowDropOnDescendants(Boolean allowDropOnDescendants)  throws IllegalStateException {
        return (TourStep)setAttribute("allowDropOnDescendants", allowDropOnDescendants, false);
    }

    /**
     * For {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType:"drag"} tourSteps with a {@link
     * com.smartgwt.client.util.tour.TourStep#getDropTarget dropTarget}, should we allow the drop to complete and the tour to
     * proceed if the user drops on a descendant of the drop target. <P> For example - if a user has been prompted to drag a
     * component into a Layout, but  the layout already contains a nested child layout, should the user be able to  drop into
     * that child layout and continue the tour? <P> If unset this will be derived from {@link
     * com.smartgwt.client.util.tour.Tour#getAllowDropOnDescendants Tour.allowDropOnDescendants}
     *
     * @return Current allowDropOnDescendants value. Default value is null
     */
    public Boolean getAllowDropOnDescendants()  {
        return getAttributeAsBoolean("allowDropOnDescendants");
    }
    

    /**
     * If this step has a target that prompts a user for a specific action, should  the step be automatically completed and
     * have the tour move forward to the  next step when the user takes this action? <P> Has no effect except on {@link
     * com.smartgwt.client.types.TourActionType action types} that can auto-complete. <P> If autoComplete is <code>false</code>
     * the action button is shown but is disabled until the expected action is completed at which time the button is enabled so
     * the user can continue.
     *
     * @param autoComplete New autoComplete value. Default value is true
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setAutoComplete(boolean autoComplete)  throws IllegalStateException {
        return (TourStep)setAttribute("autoComplete", autoComplete, false);
    }

    /**
     * If this step has a target that prompts a user for a specific action, should  the step be automatically completed and
     * have the tour move forward to the  next step when the user takes this action? <P> Has no effect except on {@link
     * com.smartgwt.client.types.TourActionType action types} that can auto-complete. <P> If autoComplete is <code>false</code>
     * the action button is shown but is disabled until the expected action is completed at which time the button is enabled so
     * the user can continue.
     *
     * @return Current autoComplete value. Default value is true
     */
    public boolean getAutoComplete()  {
        Boolean result = getAttributeAsBoolean("autoComplete");
        return result == null ? true : result;
    }
    

    /**
     * When set on a step with an {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType} of "change", the
     * entered or selected value will be automatically bound to the specified value in the {@link
     * com.smartgwt.client.util.workflow.Process#getState tour state}.
     *
     * @param bindEnteredText New bindEnteredText value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setBindEnteredText(String bindEnteredText)  throws IllegalStateException {
        return (TourStep)setAttribute("bindEnteredText", bindEnteredText, false);
    }

    /**
     * When set on a step with an {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType} of "change", the
     * entered or selected value will be automatically bound to the specified value in the {@link
     * com.smartgwt.client.util.workflow.Process#getState tour state}.
     *
     * @return Current bindEnteredText value. Default value is null
     */
    public String getBindEnteredText()  {
        return getAttributeAsString("bindEnteredText");
    }
    

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView}. Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getStepCancelButtonTitle Tour.stepCancelButtonTitle}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TourStep setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (TourStep)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView}. Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getStepCancelButtonTitle Tour.stepCancelButtonTitle}.
     *
     * @return Current cancelButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Target component on which a {@link com.smartgwt.client.util.tour.TourStep#getTarget target} must be dropped to complete
     * step. If {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType} is not specified and this property is
     * provided, <code>actionType</code> defaults to "drag". <P> Target may be specified as a {@link
     * com.smartgwt.client.docs.GlobalId} for a Component or FormItem, or as a {@link com.smartgwt.client.docs.AutoTestLocator}
     * for an element.
     *
     * @param dropTarget New dropTarget value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setDropTarget(String dropTarget)  throws IllegalStateException {
        return (TourStep)setAttribute("dropTarget", dropTarget, false);
    }

    /**
     * Target component on which a {@link com.smartgwt.client.util.tour.TourStep#getTarget target} must be dropped to complete
     * step. If {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType} is not specified and this property is
     * provided, <code>actionType</code> defaults to "drag". <P> Target may be specified as a {@link
     * com.smartgwt.client.docs.GlobalId} for a Component or FormItem, or as a {@link com.smartgwt.client.docs.AutoTestLocator}
     * for an element.
     *
     * @return Current dropTarget value. Default value is null
     */
    public String getDropTarget()  {
        return getAttributeAsString("dropTarget");
    }
    

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @param expectedValue New expectedValue value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setInputValidation
     */
    public TourStep setExpectedValue(String expectedValue)  throws IllegalStateException {
        return (TourStep)setAttribute("expectedValue", expectedValue, false);
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @return Current expectedValue value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getInputValidation
     */
    public String getExpectedValue()  {
        return getAttributeAsString("expectedValue");
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @param expectedValue New expectedValue value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setInputValidation
     */
    public TourStep setExpectedValue(Boolean expectedValue)  throws IllegalStateException {
        return (TourStep)setAttribute("expectedValue", expectedValue, false);
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @return Current expectedValue value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getInputValidation
     */
    public Boolean getExpectedValueAsBoolean()  {
        return getAttributeAsBoolean("expectedValue");
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @param expectedValue New expectedValue value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setInputValidation
     */
    public TourStep setExpectedValue(Integer expectedValue)  throws IllegalStateException {
        return (TourStep)setAttribute("expectedValue", expectedValue, false);
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @return Current expectedValue value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getInputValidation
     */
    public Integer getExpectedValueAsInt()  {
        return getAttributeAsInt("expectedValue");
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @param expectedValue New expectedValue value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setInputValidation
     */
    public TourStep setExpectedValue(Date expectedValue)  throws IllegalStateException {
        return (TourStep)setAttribute("expectedValue", expectedValue, false);
    }

    /**
     * The expected value for {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". The value must
     * be matched exactly ignoring case for string values. A string value can also be matched case-sensitive by setting {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValueCaseSensitive expectedValueCaseSensitive} to <code>true</code>.
     * <P> A regular expression can be used to match the entered value by providing the expected value as a string with leading
     * and trailing slashes (ex. "/get.&#42;/").
     *
     * @return Current expectedValue value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getInputValidation
     */
    public Date getExpectedValueAsDate()  {
        return getAttributeAsDate("expectedValue");
    }
    

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} be matched as case-sensitive?
     *
     * @param expectedValueCaseSensitive New expectedValueCaseSensitive value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setExpectedValueCaseSensitive(Boolean expectedValueCaseSensitive)  throws IllegalStateException {
        return (TourStep)setAttribute("expectedValueCaseSensitive", expectedValueCaseSensitive, false);
    }

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} be matched as case-sensitive?
     *
     * @return Current expectedValueCaseSensitive value. Default value is null
     */
    public Boolean getExpectedValueCaseSensitive()  {
        return getAttributeAsBoolean("expectedValueCaseSensitive");
    }
    

    /**
     * How should the {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} be validated and notified
     * to the user? <P> Defaults to "onExit" if {@link com.smartgwt.client.util.tour.TourStep#getAfterInputTarget
     * afterInputTarget} is specified. Otherwise the default is "notify".
     *
     * @param inputValidation New inputValidation value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setInputValidation(TourInputValidationMode inputValidation)  throws IllegalStateException {
        return (TourStep)setAttribute("inputValidation", inputValidation == null ? null : inputValidation.getValue(), false);
    }

    /**
     * How should the {@link com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} be validated and notified
     * to the user? <P> Defaults to "onExit" if {@link com.smartgwt.client.util.tour.TourStep#getAfterInputTarget
     * afterInputTarget} is specified. Otherwise the default is "notify".
     *
     * @return Current inputValidation value. Default value is null
     */
    public TourInputValidationMode getInputValidation()  {
        return EnumUtil.getEnum(TourInputValidationMode.values(), getAttribute("inputValidation"));
    }
    

    /**
     * The time between keypresses that is used during {@link com.smartgwt.client.util.tour.TourStep#getInputValidation
     * inputValidation} before showing the expected text notification. Does not apply to <code>inputValidation="onExit"</code>.
     *
     * @param inputValidationNotifyDelay New inputValidationNotifyDelay value. Default value is 500
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setInputValidationNotifyDelay(Integer inputValidationNotifyDelay)  throws IllegalStateException {
        return (TourStep)setAttribute("inputValidationNotifyDelay", inputValidationNotifyDelay, false);
    }

    /**
     * The time between keypresses that is used during {@link com.smartgwt.client.util.tour.TourStep#getInputValidation
     * inputValidation} before showing the expected text notification. Does not apply to <code>inputValidation="onExit"</code>.
     *
     * @return Current inputValidationNotifyDelay value. Default value is 500
     */
    public Integer getInputValidationNotifyDelay()  {
        return getAttributeAsInt("inputValidationNotifyDelay");
    }
    

    /**
     * Message to be displayed by {@link com.smartgwt.client.util.tour.Tour#notifyValidationMessage
     * Tour.notifyValidationMessage()}. <P> This is a dynamic string - text within <code>&#36;{...}</code> are dynamic
     * variables and will be evaluated as JS code when the message is displayed. <P> Only two dynamic variables, value and
     * expectedValue, are available and represent the currently entered and expected values.
     *
     * @param inputValidationNotifyMessage New inputValidationNotifyMessage value. Default value is "Please enter '${expectedValue}'"
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setInputValidationNotifyMessage(String inputValidationNotifyMessage)  throws IllegalStateException {
        return (TourStep)setAttribute("inputValidationNotifyMessage", inputValidationNotifyMessage, false);
    }

    /**
     * Message to be displayed by {@link com.smartgwt.client.util.tour.Tour#notifyValidationMessage
     * Tour.notifyValidationMessage()}. <P> This is a dynamic string - text within <code>&#36;{...}</code> are dynamic
     * variables and will be evaluated as JS code when the message is displayed. <P> Only two dynamic variables, value and
     * expectedValue, are available and represent the currently entered and expected values.
     *
     * @return Current inputValidationNotifyMessage value. Default value is "Please enter '${expectedValue}'"
     */
    public String getInputValidationNotifyMessage()  {
        return getAttributeAsString("inputValidationNotifyMessage");
    }
    

    /**
     * Text to show in body of window.
     *
     * @param instructions New instructions value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourStep setInstructions(String instructions)  throws IllegalStateException {
        return (TourStep)setAttribute("instructions", instructions, false);
    }

    /**
     * Text to show in body of window.
     *
     * @return Current instructions value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getInstructions()  {
        return getAttributeAsString("instructions");
    }
    

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.Canvas#getPointerSettings pointerSettings}.
     *
     * @param pointerSnapTo New pointerSnapTo value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public TourStep setPointerSnapTo(String pointerSnapTo)  throws IllegalStateException {
        return (TourStep)setAttribute("pointerSnapTo", pointerSnapTo, false);
    }

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.Canvas#getPointerSettings pointerSettings}.
     *
     * @return Current pointerSnapTo value. Default value is null
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public String getPointerSnapTo()  {
        return getAttributeAsString("pointerSnapTo");
    }
    

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton action button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code> when {@link com.smartgwt.client.types.AutoComplete autoComplete}
     * is <code>not false</code> and any of the following are true: <ul>   <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType} is "click"</li>   <li>actionType is "mouseDown"</li>  
     * <li>actionType is "doubleClick"</li>   <li>actionType is "rightClick"</li>   <li>actionType is "menuItemOpen"</li>  
     * <li>actionType is "menuItemSelect"</li>   <li>actionType is "change" and an {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} is provided</li>   <li>a {@link
     * com.smartgwt.client.util.tour.TourStep#getDropTarget dropTarget} is provided</li> </ul> <P> If no value is provided and
     * autoComplete is <code>false</code> but auto completion would normally occur (i.e. actionType "click", "change" with
     * expectedValue, etc.) then the action button is shown but is disabled until the expected action is completed at which
     * time the button is enabled so the user can continue.
     *
     * @param showActionButton New showActionButton value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setShowActionButton(Boolean showActionButton)  throws IllegalStateException {
        return (TourStep)setAttribute("showActionButton", showActionButton, false);
    }

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton action button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code> when {@link com.smartgwt.client.types.AutoComplete autoComplete}
     * is <code>not false</code> and any of the following are true: <ul>   <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType} is "click"</li>   <li>actionType is "mouseDown"</li>  
     * <li>actionType is "doubleClick"</li>   <li>actionType is "rightClick"</li>   <li>actionType is "menuItemOpen"</li>  
     * <li>actionType is "menuItemSelect"</li>   <li>actionType is "change" and an {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} is provided</li>   <li>a {@link
     * com.smartgwt.client.util.tour.TourStep#getDropTarget dropTarget} is provided</li> </ul> <P> If no value is provided and
     * autoComplete is <code>false</code> but auto completion would normally occur (i.e. actionType "click", "change" with
     * expectedValue, etc.) then the action button is shown but is disabled until the expected action is completed at which
     * time the button is enabled so the user can continue.
     *
     * @return Current showActionButton value. Default value is null
     */
    public Boolean getShowActionButton()  {
        return getAttributeAsBoolean("showActionButton");
    }
    

    /**
     * For a step with an {@link com.smartgwt.client.util.tour.TourStep#getActionType action} a large arrow shows to indicate
     * the target or direction of required action. Setting <code>showArrow</code> to <code>false</code> suppresses the display
     * of the arrow. Note that the tour window is shown as if the arrow were there. <P> {@link
     * com.smartgwt.client.util.tour.TourStep#getShowPointer ShowPointer} takes precedence over <code>showArrow:true</code>.
     *
     * @param showArrow New showArrow value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setShowPointer
     * @see com.smartgwt.client.util.tour.TourStep#setShowOutline
     */
    public TourStep setShowArrow(Boolean showArrow)  throws IllegalStateException {
        return (TourStep)setAttribute("showArrow", showArrow, false);
    }

    /**
     * For a step with an {@link com.smartgwt.client.util.tour.TourStep#getActionType action} a large arrow shows to indicate
     * the target or direction of required action. Setting <code>showArrow</code> to <code>false</code> suppresses the display
     * of the arrow. Note that the tour window is shown as if the arrow were there. <P> {@link
     * com.smartgwt.client.util.tour.TourStep#getShowPointer ShowPointer} takes precedence over <code>showArrow:true</code>.
     *
     * @return Current showArrow value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getShowPointer
     * @see com.smartgwt.client.util.tour.TourStep#getShowOutline
     */
    public Boolean getShowArrow()  {
        return getAttributeAsBoolean("showArrow");
    }
    

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton cancel button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code> unless this step is the last step in the tour.
     *
     * @param showCancelButton New showCancelButton value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setShowCancelButton(Boolean showCancelButton)  throws IllegalStateException {
        return (TourStep)setAttribute("showCancelButton", showCancelButton, false);
    }

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton cancel button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code> unless this step is the last step in the tour.
     *
     * @return Current showCancelButton value. Default value is null
     */
    public Boolean getShowCancelButton()  {
        return getAttributeAsBoolean("showCancelButton");
    }
    

    /**
     * Should {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage inputValidationNotifyMessage} be
     * shown as detailed in {@link com.smartgwt.client.types.TourInputValidationMode}? Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getShowInputValidationMessage Tour.showInputValidationMessage} if not set. <P> If set
     * to <code>false</code> reporting messages to the user are suppressed and therefore {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage Tour.notifyValidationMessage()} will not be called.
     *
     * @param showInputValidationMessage New showInputValidationMessage value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setShowInputValidationMessage(Boolean showInputValidationMessage)  throws IllegalStateException {
        return (TourStep)setAttribute("showInputValidationMessage", showInputValidationMessage, false);
    }

    /**
     * Should {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage inputValidationNotifyMessage} be
     * shown as detailed in {@link com.smartgwt.client.types.TourInputValidationMode}? Defaults from {@link
     * com.smartgwt.client.util.tour.Tour#getShowInputValidationMessage Tour.showInputValidationMessage} if not set. <P> If set
     * to <code>false</code> reporting messages to the user are suppressed and therefore {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage Tour.notifyValidationMessage()} will not be called.
     *
     * @return Current showInputValidationMessage value. Default value is null
     */
    public Boolean getShowInputValidationMessage()  {
        return getAttributeAsBoolean("showInputValidationMessage");
    }
    

    /**
     * Should the target(s) be outlined? Defaults to <code>true</code> in {@link com.smartgwt.client.util.tour.Tour#getMode
     * Tour.mode}:"tutorial".
     *
     * @param showOutline New showOutline value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setShowPointer
     * @see com.smartgwt.client.util.tour.TourStep#setShowArrow
     */
    public TourStep setShowOutline(Boolean showOutline)  throws IllegalStateException {
        return (TourStep)setAttribute("showOutline", showOutline, false);
    }

    /**
     * Should the target(s) be outlined? Defaults to <code>true</code> in {@link com.smartgwt.client.util.tour.Tour#getMode
     * Tour.mode}:"tutorial".
     *
     * @return Current showOutline value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getShowPointer
     * @see com.smartgwt.client.util.tour.TourStep#getShowArrow
     */
    public Boolean getShowOutline()  {
        return getAttributeAsBoolean("showOutline");
    }
    

    /**
     * Should a {@link com.smartgwt.client.widgets.Canvas#getShowPointer canvas pointer} be shown pointing to the  target?
     * Defaults to <code>true</code> in {@link com.smartgwt.client.util.tour.Tour#getMode Tour.mode}:"tour".
     *
     * @param showPointer New showPointer value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.TourStep#setShowOutline
     * @see com.smartgwt.client.util.tour.TourStep#setShowArrow
     */
    public TourStep setShowPointer(Boolean showPointer)  throws IllegalStateException {
        return (TourStep)setAttribute("showPointer", showPointer, false);
    }

    /**
     * Should a {@link com.smartgwt.client.widgets.Canvas#getShowPointer canvas pointer} be shown pointing to the  target?
     * Defaults to <code>true</code> in {@link com.smartgwt.client.util.tour.Tour#getMode Tour.mode}:"tour".
     *
     * @return Current showPointer value. Default value is null
     * @see com.smartgwt.client.util.tour.TourStep#getShowOutline
     * @see com.smartgwt.client.util.tour.TourStep#getShowArrow
     */
    public Boolean getShowPointer()  {
        return getAttributeAsBoolean("showPointer");
    }
    

    /**
     * Component that is the target of this step. The interaction for this step is indicated in {@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType}. For actions that need multiple targets, this target is
     * the primary one. <P> Target may be specified as a {@link com.smartgwt.client.docs.GlobalId} for a Component or FormItem,
     * or as a {@link com.smartgwt.client.docs.AutoTestLocator} for an element.
     *
     * @param target New target value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setTarget(String target)  throws IllegalStateException {
        return (TourStep)setAttribute("target", target, false);
    }

    /**
     * Component that is the target of this step. The interaction for this step is indicated in {@link
     * com.smartgwt.client.util.tour.TourStep#getActionType actionType}. For actions that need multiple targets, this target is
     * the primary one. <P> Target may be specified as a {@link com.smartgwt.client.docs.GlobalId} for a Component or FormItem,
     * or as a {@link com.smartgwt.client.docs.AutoTestLocator} for an element.
     *
     * @return Current target value. Default value is null
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
    

    /**
     * Automatically generated view (typically a TourWindow) to show for tour step. <P> The following {@link
     * com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getPointerSnapTo pointerSnapTo} for the {@link
     * com.smartgwt.client.widgets.Canvas#getPointerSettings Canvas.pointerSettings}</li> <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getShowCancelButton showCancelButton} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton TourWindow.showCancelButton}</li> <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getCancelButtonTitle cancelButtonTitle} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getCancelButtonTitle TourWindow.cancelButtonTitle}</li> <li>{@link
     * com.smartgwt.client.util.tour.TourStep#getActionButtonTitle actionButtonTitle} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getActionButtonTitle TourWindow.actionButtonTitle}</li> </ul>
     * <p>
     * This component is an AutoChild named "targetView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current targetView value. Default value is null
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public TourWindow getTargetView() throws IllegalStateException {
        errorIfNotCreated("targetView");
        return (TourWindow)TourWindow.getByJSObject(getAttributeAsJavaScriptObject("targetView"));
    }
    

    /**
     * The name of the widget class (as a string) to use for the target view.
     *
     * @param targetViewConstructor New targetViewConstructor value. Default value is "TourWindow"
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourStep setTargetViewConstructor(String targetViewConstructor)  throws IllegalStateException {
        return (TourStep)setAttribute("targetViewConstructor", targetViewConstructor, false);
    }

    /**
     * The name of the widget class (as a string) to use for the target view.
     *
     * @return Current targetViewConstructor value. Default value is "TourWindow"
     */
    public String getTargetViewConstructor()  {
        return getAttributeAsString("targetViewConstructor");
    }
    

    /**
     * Defaults for the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} autoChild.
     *
     * @param targetViewDefaults New targetViewDefaults value. Default value is {...}
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public TourStep setTargetViewDefaults(Canvas targetViewDefaults)  throws IllegalStateException {
        if (targetViewDefaults != null) {
            if (targetViewDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TourStep.class, "setTargetViewDefaults", "Canvas");
            }                                                                       
            targetViewDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = targetViewDefaults == null ? null : targetViewDefaults.getConfig();
        return (TourStep)setAttribute("targetViewDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Defaults for the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} autoChild.
     *
     * @return Current targetViewDefaults value. Default value is {...}
     */
    public Canvas getTargetViewDefaults()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("targetViewDefaults"));
        return properties;
    }
    

    /**
     * Title for the Window.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourStep setTitle(String title)  throws IllegalStateException {
        return (TourStep)setAttribute("title", title, false);
    }

    /**
     * Title for the Window.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Defaults for the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} autoChild. These defaults are
     * applied after {@link com.smartgwt.client.util.tour.Tour#getWindowDefaults Tour.windowDefaults} if any.
     *
     * @param windowDefaults New windowDefaults value. Default value is {...}
     * @return {@link com.smartgwt.client.util.tour.TourStep TourStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public TourStep setWindowDefaults(Canvas windowDefaults)  throws IllegalStateException {
        if (windowDefaults != null) {
            if (windowDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TourStep.class, "setWindowDefaults", "Canvas");
            }                                                                       
            windowDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = windowDefaults == null ? null : windowDefaults.getConfig();
        return (TourStep)setAttribute("windowDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Defaults for the {@link com.smartgwt.client.util.tour.TourStep#getTargetView targetView} autoChild. These defaults are
     * applied after {@link com.smartgwt.client.util.tour.Tour#getWindowDefaults Tour.windowDefaults} if any.
     *
     * @return Current windowDefaults value. Default value is {...}
     */
    public Canvas getWindowDefaults()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("windowDefaults"));
        return properties;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
