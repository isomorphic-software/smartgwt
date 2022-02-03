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
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Subclass of the {@link com.smartgwt.client.widgets.Splitbar} class that uses the <code>grip</code> functionality to show
 * a stateful open / close indicator.
 * @see com.smartgwt.client.widgets.Splitbar
 * @see com.smartgwt.client.widgets.layout.Layout
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Snapbar")
public class Snapbar extends Splitbar {

    public static Snapbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Snapbar(jsObj);
        } else {
            assert refInstance instanceof Snapbar;
            return (Snapbar)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Snapbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Snapbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Snapbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Snapbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Snapbar(){
        scClassName = "Snapbar";
    }

    public Snapbar(JavaScriptObject jsObj){
        scClassName = "Snapbar";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Overridden from {@link com.smartgwt.client.widgets.Splitbar#getGripImgSuffix Splitbar.gripImgSuffix} to simplify
     * providing custom grip media for this widget.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix New gripImgSuffix value. Default value is "snap"
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Snapbar setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        return (Snapbar)setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * Overridden from {@link com.smartgwt.client.widgets.Splitbar#getGripImgSuffix Splitbar.gripImgSuffix} to simplify
     * providing custom grip media for this widget.
     *
     * @return Current gripImgSuffix value. Default value is "snap"
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip Splitbar.showGrip} is true, this property determines whether
     * the grip image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget Splitbar.target}  is hidden. Note that if {@link
     * com.smartgwt.client.widgets.Splitbar#getInvertClosedGripIfTargetAfter Splitbar.invertClosedGripIfTargetAfter} is true,
     * we may show the "closed" state when the target is visible, rather than when it is hidden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showClosedGrip New showClosedGrip value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Snapbar setShowClosedGrip(Boolean showClosedGrip)  throws IllegalStateException {
        return (Snapbar)setAttribute("showClosedGrip", showClosedGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip Splitbar.showGrip} is true, this property determines whether
     * the grip image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget Splitbar.target}  is hidden. Note that if {@link
     * com.smartgwt.client.widgets.Splitbar#getInvertClosedGripIfTargetAfter Splitbar.invertClosedGripIfTargetAfter} is true,
     * we may show the "closed" state when the target is visible, rather than when it is hidden.
     *
     * @return Current showClosedGrip value. Default value is true
     */
    public Boolean getShowClosedGrip()  {
        Boolean result = getAttributeAsBoolean("showClosedGrip");
        return result == null ? true : result;
    }
    

    /**
     * Snapbars show mouse-down styling.
     *
     * @param showDown New showDown value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     */
    public Snapbar setShowDown(Boolean showDown) {
        return (Snapbar)setAttribute("showDown", showDown, true);
    }

    /**
     * Snapbars show mouse-down styling.
     *
     * @return Current showDown value. Default value is true
     */
    public Boolean getShowDown()  {
        Boolean result = getAttributeAsBoolean("showDown");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     *
     * @param showDownGrip New showDownGrip value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     */
    public Snapbar setShowDownGrip(Boolean showDownGrip) {
        return (Snapbar)setAttribute("showDownGrip", showDownGrip, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     *
     * @return Current showDownGrip value. Default value is true
     */
    public Boolean getShowDownGrip()  {
        Boolean result = getAttributeAsBoolean("showDownGrip");
        return result == null ? true : result;
    }
    

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     * @param showGrip New showGrip value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     */
    public Snapbar setShowGrip(Boolean showGrip) {
        return (Snapbar)setAttribute("showGrip", showGrip, true);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     * @return Current showGrip value. Default value is true
     */
    public Boolean getShowGrip()  {
        Boolean result = getAttributeAsBoolean("showGrip");
        return result == null ? true : result;
    }
    

    /**
     * Snapbars show rollover styling.
     *
     * @param showRollOver New showRollOver value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     */
    public Snapbar setShowRollOver(Boolean showRollOver) {
        return (Snapbar)setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Snapbars show rollover styling.
     *
     * @return Current showRollOver value. Default value is true
     */
    public Boolean getShowRollOver()  {
        Boolean result = getAttributeAsBoolean("showRollOver");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip New showRollOverGrip value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Snapbar Snapbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Snapbar setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        return (Snapbar)setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     *
     * @return Current showRollOverGrip value. Default value is true
     */
    public Boolean getShowRollOverGrip()  {
        Boolean result = getAttributeAsBoolean("showRollOverGrip");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param snapbarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Snapbar snapbarProperties) /*-{
        if (snapbarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Snapbar.@java.lang.Object::getClass()(), "setDefaultProperties", snapbarProperties.@java.lang.Object::getClass()());
        }
        snapbarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = snapbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Snapbar.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SnapbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.gripImgSuffix = getAttributeAsString("gripImgSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.gripImgSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.showClosedGrip = getAttributeAsString("showClosedGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showClosedGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showDown = getAttributeAsString("showDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showDown:" + t.getMessage() + "\n";
        }
        try {
            s.showDownGrip = getAttributeAsString("showDownGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showDownGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showGrip = getAttributeAsString("showGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverGrip = getAttributeAsString("showRollOverGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Snapbar.showRollOverGrip:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SnapbarLogicalStructure s = new SnapbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
