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
 
package com.smartgwt.client.widgets;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Subclass of the {@link com.smartgwt.client.widgets.Splitbar} class that uses the <code>grip</code> functionality to show
 * a stateful open / close indicator.
 */
public class Snapbar extends Splitbar {

    public static Snapbar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Snapbar) obj;
        } else {
            return new Snapbar(jsObj);
        }
    }

    public Snapbar(){
        scClassName = "Snapbar";
    }

    public Snapbar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Overridden from {@link com.smartgwt.client.widgets.Splitbar#getGripImgSuffix gripImgSuffix} to simplify providing custom
     * grip media for this widget.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix gripImgSuffix Default value is "snap"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * Overridden from {@link com.smartgwt.client.widgets.Splitbar#getGripImgSuffix gripImgSuffix} to simplify providing custom
     * grip media for this widget.
     *
     *
     * @return String
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showClosedGrip showClosedGrip Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowClosedGrip(Boolean showClosedGrip)  throws IllegalStateException {
        setAttribute("showClosedGrip", showClosedGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden.
     *
     *
     * @return Boolean
     */
    public Boolean getShowClosedGrip()  {
        return getAttributeAsBoolean("showClosedGrip");
    }

    /**
     * Snapbars show mouse-down styling.
     *
     * @param showDown showDown Default value is true
     */
    public void setShowDown(Boolean showDown) {
        setAttribute("showDown", showDown, true);
    }

    /**
     * Snapbars show mouse-down styling.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDown()  {
        return getAttributeAsBoolean("showDown");
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false.
     *
     * @param showDownGrip showDownGrip Default value is true
     */
    public void setShowDownGrip(Boolean showDownGrip) {
        setAttribute("showDownGrip", showDownGrip, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDownGrip()  {
        return getAttributeAsBoolean("showDownGrip");
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     * @param showGrip showGrip Default value is true
     */
    public void setShowGrip(Boolean showGrip) {
        setAttribute("showGrip", showGrip, true);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     *
     * @return Boolean
     */
    public Boolean getShowGrip()  {
        return getAttributeAsBoolean("showGrip");
    }

    /**
     * Snapbars show rollover styling.
     *
     * @param showRollOver showRollOver Default value is true
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Snapbars show rollover styling.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip showRollOverGrip Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOverGrip()  {
        return getAttributeAsBoolean("showRollOverGrip");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param snapbarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Snapbar snapbarProperties) /*-{
        $wnd.isc.Snapbar.addProperties(snapbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        

}



