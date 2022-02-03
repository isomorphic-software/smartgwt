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
 * Chooses one or another next process element based on confirmation of a message shown to user. <P> If the user clicks OK,
 * the {@link com.smartgwt.client.util.tour.TourConfirmStep#getNextElement nextElement} is chosen, otherwise the choice is
 * {@link com.smartgwt.client.util.tour.TourConfirmStep#getFailureElement failureElement}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TourConfirmStep")
public class TourConfirmStep extends UserTask {

    public static TourConfirmStep getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TourConfirmStep) obj;
        } else {
            return new TourConfirmStep(jsObj);
        }
    }
        


    public TourConfirmStep(){
        scClassName = "TourConfirmStep";
    }

    public TourConfirmStep(JavaScriptObject jsObj){
        scClassName = "TourConfirmStep";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView}.
     *
     * @param actionButtonTitle New actionButtonTitle value. Default value is "OK"
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TourConfirmStep setActionButtonTitle(String actionButtonTitle)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("actionButtonTitle", actionButtonTitle, false);
    }

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView}.
     *
     * @return Current actionButtonTitle value. Default value is "OK"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getActionButtonTitle()  {
        return getAttributeAsString("actionButtonTitle");
    }
    

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TourConfirmStep setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * Applied directly to {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView}.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * ID of the next element to process if the user clicks the <code>cancelButton</code>. If not set, the process will exit.
     *
     * @param failureElement New failureElement value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourConfirmStep setFailureElement(String failureElement)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("failureElement", failureElement, false);
    }

    /**
     * ID of the next element to process if the user clicks the <code>cancelButton</code>. If not set, the process will exit.
     *
     * @return Current failureElement value. Default value is null
     */
    public String getFailureElement()  {
        return getAttributeAsString("failureElement");
    }
    

    /**
     * Text to show in body of window.
     *
     * @param instructions New instructions value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourConfirmStep setInstructions(String instructions)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("instructions", instructions, false);
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
     * Next {@link com.smartgwt.client.util.workflow.ProcessElement element} to execute if the user clicks the
     * <code>actionButton</code>. <p> <code>nextElement</code> does not need to be specified if this gateway is part of a
     * {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. This is
     * normal for a tour.
     *
     * @param nextElement New nextElement value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourConfirmStep setNextElement(String nextElement)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("nextElement", nextElement, false);
    }

    /**
     * Next {@link com.smartgwt.client.util.workflow.ProcessElement element} to execute if the user clicks the
     * <code>actionButton</code>. <p> <code>nextElement</code> does not need to be specified if this gateway is part of a
     * {@link com.smartgwt.client.util.workflow.Process#getSequences sequence} and has a next element in the sequence. This is
     * normal for a tour.
     *
     * @return Current nextElement value. Default value is null
     */
    public String getNextElement()  {
        return getAttributeAsString("nextElement");
    }
    

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton action button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code>.
     *
     * @param showActionButton New showActionButton value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourConfirmStep setShowActionButton(Boolean showActionButton)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("showActionButton", showActionButton, false);
    }

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowActionButton action button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code>.
     *
     * @return Current showActionButton value. Default value is null
     */
    public Boolean getShowActionButton()  {
        return getAttributeAsBoolean("showActionButton");
    }
    

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton cancel button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code>.
     *
     * @param showCancelButton New showCancelButton value. Default value is null
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourConfirmStep setShowCancelButton(Boolean showCancelButton)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("showCancelButton", showCancelButton, false);
    }

    /**
     * Should the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton cancel button} be shown for this step? <P> If no value
     * is provided it will be defaulted to <code>true</code>.
     *
     * @return Current showCancelButton value. Default value is null
     */
    public Boolean getShowCancelButton()  {
        return getAttributeAsBoolean("showCancelButton");
    }
    

    /**
     * Automatically generated view (typically a window) to show for tour step. <P> The following {@link
     * com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.util.tour.TourConfirmStep#getShowCancelButton showCancelButton} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getShowCancelButton TourWindow.showCancelButton}</li> <li>{@link
     * com.smartgwt.client.util.tour.TourConfirmStep#getCancelButtonTitle cancelButtonTitle} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getCancelButtonTitle TourWindow.cancelButtonTitle}</li> <li>{@link
     * com.smartgwt.client.util.tour.TourConfirmStep#getActionButtonTitle actionButtonTitle} for the {@link
     * com.smartgwt.client.widgets.tour.TourWindow#getActionButtonTitle TourWindow.actionButtonTitle}</li> </ul>
     * <p>
     * This component is an AutoChild named "targetView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current targetView value. Default value is null
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public Canvas getTargetView() throws IllegalStateException {
        errorIfNotCreated("targetView");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("targetView"));
    }
    

    /**
     * The name of the widget class (as a string) to use for the target view.
     *
     * @param targetViewConstructor New targetViewConstructor value. Default value is "TourWindow"
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TourConfirmStep setTargetViewConstructor(String targetViewConstructor)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("targetViewConstructor", targetViewConstructor, false);
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
     * Defaults for the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} autoChild.
     *
     * @param targetViewDefaults New targetViewDefaults value. Default value is {...}
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public TourConfirmStep setTargetViewDefaults(Canvas targetViewDefaults)  throws IllegalStateException {
        if (targetViewDefaults != null) {
            if (targetViewDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TourConfirmStep.class, "setTargetViewDefaults", "Canvas");
            }                                                                       
            targetViewDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = targetViewDefaults == null ? null : targetViewDefaults.getConfig();
        return (TourConfirmStep)setAttribute("targetViewDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Defaults for the {@link com.smartgwt.client.util.tour.TourConfirmStep#getTargetView targetView} autoChild.
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
     * @return {@link com.smartgwt.client.util.tour.TourConfirmStep TourConfirmStep} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TourConfirmStep setTitle(String title)  throws IllegalStateException {
        return (TourConfirmStep)setAttribute("title", title, false);
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
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
