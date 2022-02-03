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
 * The Tour class allows you to build tours and tutorials for end users, highlighting specific  components on the page and
 * prompting for specific user-interactions. <P> Tours are a specific type of {@link
 * com.smartgwt.client.util.workflow.Process Workflow Process} and  consist of a series of {@link
 * com.smartgwt.client.util.tour.TourStep TourSteps}. Typically each step refers to an element  on the page, which is
 * either being highlighted for the user, or, for a tutorial, is an element  that the user is being prompted to interact
 * with (see TourStep.clickTarget, for example). <P>  Most steps have a TourWindow, which shows explanatory or
 * instructional text. For tutorial steps  that request a user action, the target can be highlighted and a large arrow is
 * shown pointing at  the target. <P> The placement of the TourWindow and arrow is automatic, and intelligently takes into
 * account the  type of interaction requested. For example, if a tutorial requires a user to change a value in a 
 * SelectItem, the TourWindow and arrow will avoid appearing underneath the select, where they could  be occluded by the
 * drop-down picklist.  Similarly, for a drag and drop interaction, the TourWindow  avoids overlapping both the drag source
 * and the drop area. <P> Because of all this automatic behavior, a tutorial step typically consists of just: <P> 1.
 * explanatory text (tourStep.title and tourStep.description)<br> 2. the target<br> 3. the expected interaction (eg click
 * the target, or type something in, or drag something to  another widget)<br> 4. validation of input (what was typed or
 * chosen), if applicable <P> Developers may use {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest locators} to
 * specify specific components  or elements as action targets. Using locators means that tours and tutorials will typically
 * still  work even if your application changes (for example, new controls are added). Note that we recommend  making use
 * of the {@link com.smartgwt.client.util.AutoTest#installLocatorShortcut locator shortcut} to rapidly generate  locators.
 * <P> A tour is typically written as a <code>.proc.xml</code> document stored in the folder configured  via the
 * <code>project.processes</code> setting in {@link com.smartgwt.client.docs.Server_properties server.properties}
 * (webroot/processes by default). They may be loaded via the {@link com.smartgwt.client.util.tour.Tour#loadTour
 * loadTour()} method. <P> <b>The Tour feature is available with Power or better licenses only</b>  See  <a
 * href="http://smartclient.com/product">smartclient.com/product</a> for details.<br> It requires the standard DataBinding
 * and {@link com.smartgwt.client.docs.LoadingOptionalModules optional} <code>Tour</code> module.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Tour")
public class Tour extends Process {

    public static Tour getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Tour) obj;
        } else {
            return new Tour(jsObj);
        }
    }
        


    public Tour(){
        if("LGPL".equals(SC.getLicenseType()) || "Pro".equals(SC.getLicenseType())) {
                
						throw new java.lang.IllegalStateException("Tour is a part the Tour Module which comes with Power Edition or better. Please see smartclient.com/product for details on licensing.");
						
					} else if(SC.hasTour()==false || SC.hasWorkflow()==false || SC.hasDrawing()==false) {
					
						throw new java.lang.IllegalStateException("The standard DataBinding / Drawing and optional Tour modules are required to use the Tour class.  See the LoadingOptionalModules overview in the \"docs\" package of JavaDoc for instructions.");
			        }
        		scClassName = "Tour";
    }

    public Tour(JavaScriptObject jsObj){
        scClassName = "Tour";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getAllowDropOnDescendants
     * TourStep.allowDropOnDescendants} within this tour.
     *
     * @param allowDropOnDescendants New allowDropOnDescendants value. Default value is false
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     */
    public Tour setAllowDropOnDescendants(boolean allowDropOnDescendants) {
        return (Tour)setAttribute("allowDropOnDescendants", allowDropOnDescendants, true);
    }

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getAllowDropOnDescendants
     * TourStep.allowDropOnDescendants} within this tour.
     *
     * @return Current allowDropOnDescendants value. Default value is false
     */
    public boolean getAllowDropOnDescendants()  {
        Boolean result = getAttributeAsBoolean("allowDropOnDescendants");
        return result == null ? false : result;
    }
    

    /**
     * Should tour be auto-reset once it finishes in any manner so it can restarted?
     *
     * @param autoReset New autoReset value. Default value is true
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setAutoReset(Boolean autoReset)  throws IllegalStateException {
        return (Tour)setAttribute("autoReset", autoReset, false);
    }

    /**
     * Should tour be auto-reset once it finishes in any manner so it can restarted?
     *
     * @return Current autoReset value. Default value is true
     */
    public Boolean getAutoReset()  {
        Boolean result = getAttributeAsBoolean("autoReset");
        return result == null ? true : result;
    }
    

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s representing steps that should be performed if the user
     * cancels the tour. These steps are typically {@link com.smartgwt.client.util.tour.TourStep}s. <P> Alternately, or in
     * addition to these cancelation steps, the {@link com.smartgwt.client.util.workflow.Process#addFinishedHandler finished}
     * method will be called once there are no more steps to process in the tour.
     *
     * @param cancelSteps New cancelSteps value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setCancelSteps(ProcessElement... cancelSteps)  throws IllegalStateException {
        return (Tour)setAttribute("cancelSteps", cancelSteps, false);
    }

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s representing steps that should be performed if the user
     * cancels the tour. These steps are typically {@link com.smartgwt.client.util.tour.TourStep}s. <P> Alternately, or in
     * addition to these cancelation steps, the {@link com.smartgwt.client.util.workflow.Process#addFinishedHandler finished}
     * method will be called once there are no more steps to process in the tour.
     *
     * @return Current cancelSteps value. Default value is null
     */
    public ProcessElement[] getCancelSteps()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfProcessElement(getAttributeAsJavaScriptObject("cancelSteps"));
    }
    

    /**
     * Set the CSS border of the outline for drop targets as a CSS string including border-width, border-style, and/or color
     * (eg "1px dashed blue"). See {@link com.smartgwt.client.util.tour.Tour#getOutlineBorder outlineBorder} for properties
     * applied to non-drop targets. <P> This property applies the same border to all four sides of the outlined component(s).
     *
     * @param dropOutlineBorder New dropOutlineBorder value. Default value is "1px solid #44ff44"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @see com.smartgwt.client.util.tour.Tour#setOutlineBorder
     */
    public Tour setDropOutlineBorder(String dropOutlineBorder) {
        return (Tour)setAttribute("dropOutlineBorder", dropOutlineBorder, true);
    }

    /**
     * Set the CSS border of the outline for drop targets as a CSS string including border-width, border-style, and/or color
     * (eg "1px dashed blue"). See {@link com.smartgwt.client.util.tour.Tour#getOutlineBorder outlineBorder} for properties
     * applied to non-drop targets. <P> This property applies the same border to all four sides of the outlined component(s).
     *
     * @return Current dropOutlineBorder value. Default value is "1px solid #44ff44"
     * @see com.smartgwt.client.util.tour.Tour#getOutlineBorder
     */
    public String getDropOutlineBorder()  {
        return getAttributeAsString("dropOutlineBorder");
    }
    

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for the
     * first step in the tour. <P> Default titles for the middle and last steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle stepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getLastStepActionButtonTitle lastStepActionButtonTitle} respectively.
     *
     * @param firstStepActionButtonTitle New firstStepActionButtonTitle value. Default value is "Let's go!"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setFirstStepActionButtonTitle(String firstStepActionButtonTitle)  throws IllegalStateException {
        return (Tour)setAttribute("firstStepActionButtonTitle", firstStepActionButtonTitle, false);
    }

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for the
     * first step in the tour. <P> Default titles for the middle and last steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle stepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getLastStepActionButtonTitle lastStepActionButtonTitle} respectively.
     *
     * @return Current firstStepActionButtonTitle value. Default value is "Let's go!"
     */
    public String getFirstStepActionButtonTitle()  {
        return getAttributeAsString("firstStepActionButtonTitle");
    }
    

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getCancelButtonTitle TourStep.cancelButtonTitle} for the
     * first step in the tour. <P> Default title for the middle steps is configured by {@link
     * com.smartgwt.client.util.tour.Tour#getStepCancelButtonTitle stepCancelButtonTitle}. No cancel button is shown for the
     * last step.
     *
     * @param firstStepCancelButtonTitle New firstStepCancelButtonTitle value. Default value is "Skip this tour"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setFirstStepCancelButtonTitle(String firstStepCancelButtonTitle)  throws IllegalStateException {
        return (Tour)setAttribute("firstStepCancelButtonTitle", firstStepCancelButtonTitle, false);
    }

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getCancelButtonTitle TourStep.cancelButtonTitle} for the
     * first step in the tour. <P> Default title for the middle steps is configured by {@link
     * com.smartgwt.client.util.tour.Tour#getStepCancelButtonTitle stepCancelButtonTitle}. No cancel button is shown for the
     * last step.
     *
     * @return Current firstStepCancelButtonTitle value. Default value is "Skip this tour"
     */
    public String getFirstStepCancelButtonTitle()  {
        return getAttributeAsString("firstStepCancelButtonTitle");
    }
    

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for the
     * last step in the tour. <P> Default titles for the first and middle steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepActionButtonTitle firstStepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle stepActionButtonTitle} respectively.
     *
     * @param lastStepActionButtonTitle New lastStepActionButtonTitle value. Default value is "Done"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setLastStepActionButtonTitle(String lastStepActionButtonTitle)  throws IllegalStateException {
        return (Tour)setAttribute("lastStepActionButtonTitle", lastStepActionButtonTitle, false);
    }

    /**
     * Default value of {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for the
     * last step in the tour. <P> Default titles for the first and middle steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepActionButtonTitle firstStepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle stepActionButtonTitle} respectively.
     *
     * @return Current lastStepActionButtonTitle value. Default value is "Done"
     */
    public String getLastStepActionButtonTitle()  {
        return getAttributeAsString("lastStepActionButtonTitle");
    }
    

    /**
     * The tour mode allows step configuration to be simplified by using the context to apply appropriate defaults.
     *
     * @param mode New mode value. Default value is "tour"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     */
    public Tour setMode(TourMode mode) {
        return (Tour)setAttribute("mode", mode == null ? null : mode.getValue(), true);
    }

    /**
     * The tour mode allows step configuration to be simplified by using the context to apply appropriate defaults.
     *
     * @return Current mode value. Default value is "tour"
     */
    public TourMode getMode()  {
        return EnumUtil.getEnum(TourMode.values(), getAttribute("mode"));
    }
    

    /**
     * Defaults settings for {@link com.smartgwt.client.docs.NotifyType notifyType} message displayed by {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage notifyValidationMessage}.
     *
     * @param notifyMessageSettings New notifyMessageSettings value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setNotifyMessageSettings(NotifySettings notifyMessageSettings)  throws IllegalStateException {
        return (Tour)setAttribute("notifyMessageSettings", notifyMessageSettings == null ? null : notifyMessageSettings.getJsObj(), false);
    }

    /**
     * Defaults settings for {@link com.smartgwt.client.docs.NotifyType notifyType} message displayed by {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage notifyValidationMessage}.
     *
     * @return Current notifyMessageSettings value. Default value is null
     */
    public NotifySettings getNotifyMessageSettings()  {
        return new NotifySettings(getAttributeAsJavaScriptObject("notifyMessageSettings"));
    }
    

    /**
     * Category of message to use in +{notifyValidationMessage,notifyValidationMessage} by default. <P> If this category has
     * not been configured in {@link com.smartgwt.client.widgets.notify.Notify} it will be automatically configured using
     * +{notifyMessageSettings,notifyMessageSettings}.
     *
     * @param notifyType New notifyType value. Default value is "tourExpectedValue"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public Tour setNotifyType(String notifyType)  throws IllegalStateException {
        return (Tour)setAttribute("notifyType", notifyType, false);
    }

    /**
     * Category of message to use in +{notifyValidationMessage,notifyValidationMessage} by default. <P> If this category has
     * not been configured in {@link com.smartgwt.client.widgets.notify.Notify} it will be automatically configured using
     * +{notifyMessageSettings,notifyMessageSettings}.
     *
     * @return Current notifyType value. Default value is "tourExpectedValue"
     * @see com.smartgwt.client.docs.NotifyType NotifyType 
     */
    public String getNotifyType()  {
        return getAttributeAsString("notifyType");
    }
    

    /**
     * Set the CSS border of the outline of non-drop targets as a CSS string including border-width, border-style, and/or color
     * (eg "1px dashed blue"). See {@link com.smartgwt.client.util.tour.Tour#getDropOutlineBorder dropOutlineBorder} for
     * properties applied to drop targets. <P> This property applies the same border to all four sides of the outlined
     * component(s).
     *
     * @param outlineBorder New outlineBorder value. Default value is "1px solid red"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @see com.smartgwt.client.util.tour.Tour#setDropOutlineBorder
     */
    public Tour setOutlineBorder(String outlineBorder) {
        return (Tour)setAttribute("outlineBorder", outlineBorder, true);
    }

    /**
     * Set the CSS border of the outline of non-drop targets as a CSS string including border-width, border-style, and/or color
     * (eg "1px dashed blue"). See {@link com.smartgwt.client.util.tour.Tour#getDropOutlineBorder dropOutlineBorder} for
     * properties applied to drop targets. <P> This property applies the same border to all four sides of the outlined
     * component(s).
     *
     * @return Current outlineBorder value. Default value is "1px solid red"
     * @see com.smartgwt.client.util.tour.Tour#getDropOutlineBorder
     */
    public String getOutlineBorder()  {
        return getAttributeAsString("outlineBorder");
    }
    

    /**
     * Should {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage
     * TourStep.inputValidationNotifyMessage} be shown as detailed in {@link com.smartgwt.client.types.TourInputValidationMode}
     * for the entire tour? Set to <code>false</code> to suppress reporting messages to the user. {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage notifyValidationMessage} will not be called. <P> This setting
     * can be overridden for individual {@link com.smartgwt.client.util.tour.TourStep tourSteps}.
     *
     * @param showInputValidationMessage New showInputValidationMessage value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setShowInputValidationMessage(Boolean showInputValidationMessage)  throws IllegalStateException {
        return (Tour)setAttribute("showInputValidationMessage", showInputValidationMessage, false);
    }

    /**
     * Should {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage
     * TourStep.inputValidationNotifyMessage} be shown as detailed in {@link com.smartgwt.client.types.TourInputValidationMode}
     * for the entire tour? Set to <code>false</code> to suppress reporting messages to the user. {@link
     * com.smartgwt.client.util.tour.Tour#notifyValidationMessage notifyValidationMessage} will not be called. <P> This setting
     * can be overridden for individual {@link com.smartgwt.client.util.tour.TourStep tourSteps}.
     *
     * @return Current showInputValidationMessage value. Default value is null
     */
    public Boolean getShowInputValidationMessage()  {
        return getAttributeAsBoolean("showInputValidationMessage");
    }
    

    /**
     * Should a progress bar be shown in each step to indicate progress through the tour?
     *
     * @param showProgress New showProgress value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setShowProgress(Boolean showProgress)  throws IllegalStateException {
        return (Tour)setAttribute("showProgress", showProgress, false);
    }

    /**
     * Should a progress bar be shown in each step to indicate progress through the tour?
     *
     * @return Current showProgress value. Default value is null
     */
    public Boolean getShowProgress()  {
        return getAttributeAsBoolean("showProgress");
    }
    

    /**
     * Show progress percent next to progress bar when {@link com.smartgwt.client.util.tour.Tour#getShowProgress showProgress}
     * is enabled?
     *
     * @param showProgressPercent New showProgressPercent value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setShowProgressPercent(Boolean showProgressPercent)  throws IllegalStateException {
        return (Tour)setAttribute("showProgressPercent", showProgressPercent, false);
    }

    /**
     * Show progress percent next to progress bar when {@link com.smartgwt.client.util.tour.Tour#getShowProgress showProgress}
     * is enabled?
     *
     * @return Current showProgressPercent value. Default value is null
     */
    public Boolean getShowProgressPercent()  {
        return getAttributeAsBoolean("showProgressPercent");
    }
    

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for
     * steps other than the first and last ones. <P> Default titles for the first and last steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepActionButtonTitle firstStepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getLastStepActionButtonTitle lastStepActionButtonTitle} respectively.
     *
     * @param stepActionButtonTitle New stepActionButtonTitle value. Default value is "Next"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.Tour#setStepCancelButtonTitle
     */
    public Tour setStepActionButtonTitle(String stepActionButtonTitle)  throws IllegalStateException {
        return (Tour)setAttribute("stepActionButtonTitle", stepActionButtonTitle, false);
    }

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getActionButtonTitle TourStep.actionButtonTitle} for
     * steps other than the first and last ones. <P> Default titles for the first and last steps are configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepActionButtonTitle firstStepActionButtonTitle} and {@link
     * com.smartgwt.client.util.tour.Tour#getLastStepActionButtonTitle lastStepActionButtonTitle} respectively.
     *
     * @return Current stepActionButtonTitle value. Default value is "Next"
     * @see com.smartgwt.client.util.tour.Tour#getStepCancelButtonTitle
     */
    public String getStepActionButtonTitle()  {
        return getAttributeAsString("stepActionButtonTitle");
    }
    

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getCancelButtonTitle TourStep.cancelButtonTitle} for all
     * steps where the cancel button is shown. <P> Default title for the first step is configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepCancelButtonTitle firstStepCancelButtonTitle}.
     *
     * @param stepCancelButtonTitle New stepCancelButtonTitle value. Default value is "Skip this tour"
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.util.tour.Tour#setStepActionButtonTitle
     */
    public Tour setStepCancelButtonTitle(String stepCancelButtonTitle)  throws IllegalStateException {
        return (Tour)setAttribute("stepCancelButtonTitle", stepCancelButtonTitle, false);
    }

    /**
     * Default value for {@link com.smartgwt.client.util.tour.TourStep#getCancelButtonTitle TourStep.cancelButtonTitle} for all
     * steps where the cancel button is shown. <P> Default title for the first step is configured by {@link
     * com.smartgwt.client.util.tour.Tour#getFirstStepCancelButtonTitle firstStepCancelButtonTitle}.
     *
     * @return Current stepCancelButtonTitle value. Default value is "Skip this tour"
     * @see com.smartgwt.client.util.tour.Tour#getStepActionButtonTitle
     */
    public String getStepCancelButtonTitle()  {
        return getAttributeAsString("stepCancelButtonTitle");
    }
    

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s representing steps in this tour. These steps are typically
     * {@link com.smartgwt.client.util.tour.TourStep}s.
     *
     * @param steps New steps value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tour setSteps(ProcessElement... steps)  throws IllegalStateException {
        return (Tour)setAttribute("steps", steps, false);
    }

    /**
     * The {@link com.smartgwt.client.util.workflow.ProcessElement}s representing steps in this tour. These steps are typically
     * {@link com.smartgwt.client.util.tour.TourStep}s.
     *
     * @return Current steps value. Default value is null
     */
    public ProcessElement[] getSteps()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfProcessElement(getAttributeAsJavaScriptObject("steps"));
    }
    

    /**
     * Defaults for each {@link com.smartgwt.client.util.tour.TourStep#getTargetView TourStep.targetView} autoChild in the
     * tour. These defaults are applied before {@link com.smartgwt.client.util.tour.TourStep#getWindowDefaults
     * TourStep.windowDefaults} if any.
     *
     * @param windowDefaults New windowDefaults value. Default value is {...}
     * @return {@link com.smartgwt.client.util.tour.Tour Tour} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public Tour setWindowDefaults(Canvas windowDefaults)  throws IllegalStateException {
        if (windowDefaults != null) {
            if (windowDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Tour.class, "setWindowDefaults", "Canvas");
            }                                                                       
            windowDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = windowDefaults == null ? null : windowDefaults.getConfig();
        return (Tour)setAttribute("windowDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Defaults for each {@link com.smartgwt.client.util.tour.TourStep#getTargetView TourStep.targetView} autoChild in the
     * tour. These defaults are applied before {@link com.smartgwt.client.util.tour.TourStep#getWindowDefaults
     * TourStep.windowDefaults} if any.
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
	/**
     * Notify user of expected value entry validation message. Default implementation uses the  {@link
     * com.smartgwt.client.widgets.notify.Notify Notify system} to show the message in it's default position. See {@link
     * com.smartgwt.client.docs.NotifyType notifyType} for notification configuration details. <P>
     * @param message message provided by {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage
     * TourStep.inputValidationNotifyMessage}
     */
    public native void notifyValidationMessage(String message) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "notifyValidationMessage", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.notifyValidationMessage(message);
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Get a Tour instance by it's ID.
     * @param tourId tour ID to retrieve.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return the tour, or null if not defined
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public static native Tour getTour(String tourId) /*-{
        var ret = $wnd.isc.Tour.getTour(tourId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.tour.Tour::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;



    // ***********************************************************


    
	/**
     * Loads an XML tour definition stored in XML from the server. <p> Tour files are stored as .proc.xml files in {@link
     * com.smartgwt.client.docs.ComponentXML Component XML} format, in the directory indicated by the
     * <code>project.processes</code> setting in {@link com.smartgwt.client.docs.Server_properties server.properties}
     * (<code><i>webroot</i>/processes</code> by default).  To load a tour saved in a file <i>tourId</i>.proc.xml, pass just
     * <i>tourId</i> to this method.
     * @param tourId tour ID or IDs to load.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param callback called when the tour is loaded with argument                            "process", the first tour.  Other tours can be
     * looked                            up via {@link com.smartgwt.client.util.tour.Tour#getTour getTour()}.
     */
    public static native void loadTour(String tourId, ProcessCallback callback) /*-{
	    $wnd.isc.Tour.loadTour(tourId, 
			$entry( function(process) { 
			    // create an instance of Tour rather than Process in Java
			    var tourJ = $wnd.isc.isA.Tour(process) 
			    			? @com.smartgwt.client.util.tour.Tour::new(Lcom/google/gwt/core/client/JavaScriptObject;)(process) 
			    			: @com.smartgwt.client.util.workflow.Process::new(Lcom/google/gwt/core/client/JavaScriptObject;)(process);
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ProcessCallback::execute(Lcom/smartgwt/client/util/workflow/Process;)(
				    tourJ
				);
			}));
	}-*/;

    

}
