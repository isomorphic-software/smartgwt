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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * Resize bar for use in {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass Layouts}, based on the {@link
 * com.smartgwt.client.widgets.StretchImg} class.  As with the {@link com.smartgwt.client.widgets.ImgSplitbar} class, 
 * widgets of this class can be displayed as a resize-bar for widgets  in Layouts where showResizeBar is set to true.
 * Provides a different appearance from the <code>ImgSplitbar</code> class. <p> To specify the resizeBar class for some
 * layout, use the {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass Layout.resizeBarClass} property. <P>
 * On mobile devices, you may find that you need to increase the breadth of the bar to make interacting with it easier
 * (e.g. dragging or tapping).  For {@link com.smartgwt.client.widgets.layout.Layout} resize bars, this can be done by
 * setting {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize Layout.resizeBarSize}.
 * @see com.smartgwt.client.widgets.layout.Layout
 * @see com.smartgwt.client.widgets.ImgSplitbar
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Splitbar")
public class Splitbar extends StretchImg {

    public static Splitbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Splitbar(jsObj);
        } else {
            assert refInstance instanceof Splitbar;
            return (Splitbar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Splitbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Splitbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Splitbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Splitbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Splitbar(){
        scClassName = "Splitbar";
    }

    public Splitbar(JavaScriptObject jsObj){
        scClassName = "Splitbar";
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
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at its normal size). <p> Note that on touch devices, to enable collapsing/uncollapsing the <code>target</code> in
     * response to a tap, {@link com.smartgwt.client.widgets.Splitbar#getCanCollapseOnTap canCollapseOnTap} must be set to
     * <code>true</code>.
     *
     * @param canCollapse New canCollapse value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     */
    public Splitbar setCanCollapse(boolean canCollapse) {
        return (Splitbar)setAttribute("canCollapse", canCollapse, true);
    }

    /**
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at its normal size). <p> Note that on touch devices, to enable collapsing/uncollapsing the <code>target</code> in
     * response to a tap, {@link com.smartgwt.client.widgets.Splitbar#getCanCollapseOnTap canCollapseOnTap} must be set to
     * <code>true</code>.
     *
     * @return Current canCollapse value. Default value is true
     */
    public boolean getCanCollapse()  {
        Boolean result = getAttributeAsBoolean("canCollapse");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getCanCollapse canCollapse} is <code>true</code>, should a tap result in
     * collapsing/uncollapsing the {@link com.smartgwt.client.widgets.Splitbar#getTarget target}?
     *
     * @param canCollapseOnTap New canCollapseOnTap value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     */
    public Splitbar setCanCollapseOnTap(boolean canCollapseOnTap) {
        return (Splitbar)setAttribute("canCollapseOnTap", canCollapseOnTap, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getCanCollapse canCollapse} is <code>true</code>, should a tap result in
     * collapsing/uncollapsing the {@link com.smartgwt.client.widgets.Splitbar#getTarget target}?
     *
     * @return Current canCollapseOnTap value. Default value is true
     */
    public boolean getCanCollapseOnTap()  {
        Boolean result = getAttributeAsBoolean("canCollapseOnTap");
        return result == null ? true : result;
    }
    

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}
     *
     * @param canDrag New canDrag value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     */
    public Splitbar setCanDrag(Boolean canDrag) {
        return (Splitbar)setAttribute("canDrag", canDrag, true);
    }

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}
     *
     * @return Current canDrag value. Default value is true
     */
    public Boolean getCanDrag()  {
        Boolean result = getAttributeAsBoolean("canDrag");
        return result == null ? true : result;
    }
    
    

    /**
     * Splitbars' cursors are set at init time based on whether they are to be used for vertical or horizontal resize.  To
     * customize the cursor for this class, modify  {@link com.smartgwt.client.widgets.Splitbar#getVResizeCursor vResizeCursor}
     * or {@link com.smartgwt.client.widgets.Splitbar#getHResizeCursor hResizeCursor} rather than this property.
     *
     * @param cursor New cursor value. Default value is "hand"
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     */
    public Splitbar setCursor(Cursor cursor) {
        return (Splitbar)setAttribute("cursor", cursor == null ? null : cursor.getValue(), true);
    }

    /**
     * Splitbars' cursors are set at init time based on whether they are to be used for vertical or horizontal resize.  To
     * customize the cursor for this class, modify  {@link com.smartgwt.client.widgets.Splitbar#getVResizeCursor vResizeCursor}
     * or {@link com.smartgwt.client.widgets.Splitbar#getHResizeCursor hResizeCursor} rather than this property.
     *
     * @return Current cursor value. Default value is "hand"
     */
    public Cursor getCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }
    

    /**
     * Grip breadth in pixels (the short icon axis, parallel to the Layout direction). <P> If unset, grip will assume the
     * natural breadth of image.
     *
     * @param gripBreadth New gripBreadth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setGripBreadth(Integer gripBreadth)  throws IllegalStateException {
        return (Splitbar)setAttribute("gripBreadth", gripBreadth, false);
    }

    /**
     * Grip breadth in pixels (the short icon axis, parallel to the Layout direction). <P> If unset, grip will assume the
     * natural breadth of image.
     *
     * @return Current gripBreadth value. Default value is null
     */
    public Integer getGripBreadth()  {
        return getAttributeAsInt("gripBreadth");
    }
    

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix New gripImgSuffix value. Default value is "grip"
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        return (Splitbar)setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true.
     *
     * @return Current gripImgSuffix value. Default value is "grip"
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }
    

    /**
     * Grip length in pixels (the long icon axis, perpendicular to the Layout direction). <P> If unset, grip will assume the
     * natural length of image.
     *
     * @param gripLength New gripLength value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setGripLength(Integer gripLength)  throws IllegalStateException {
        return (Splitbar)setAttribute("gripLength", gripLength, false);
    }

    /**
     * Grip length in pixels (the long icon axis, perpendicular to the Layout direction). <P> If unset, grip will assume the
     * natural length of image.
     *
     * @return Current gripLength value. Default value is null
     */
    public Integer getGripLength()  {
        return getAttributeAsInt("gripLength");
    }
    

    /**
     * Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
     *
     * @param hResizeCursor New hResizeCursor value. Default value is "col-resize"
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setHResizeCursor(Cursor hResizeCursor)  throws IllegalStateException {
        return (Splitbar)setAttribute("hResizeCursor", hResizeCursor == null ? null : hResizeCursor.getValue(), false);
    }

    /**
     * Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
     *
     * @return Current hResizeCursor value. Default value is "col-resize"
     */
    public Cursor getHResizeCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("hResizeCursor"));
    }
    

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is false and 
     * {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} is unset.
     *
     * @param hSrc New hSrc value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.StretchImg#setSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Splitbar setHSrc(String hSrc)  throws IllegalStateException {
        return (Splitbar)setAttribute("hSrc", hSrc, false);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is false and 
     * {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} is unset.
     *
     * @return Current hSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowClosedGrip showClosedGrip} is true, and {@link
     * com.smartgwt.client.widgets.Splitbar#getTargetAfter targetAfter} is true should we show the "closed" state for the grip
     * when the target is visible (rather than when it is hidden). <P> This property is useful for the case where the grip
     * media is a simple directional arrow. The same image can be used for expanded state on one side of the bar or collapsed
     * state on the other.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param invertClosedGripIfTargetAfter New invertClosedGripIfTargetAfter value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     */
    public Splitbar setInvertClosedGripIfTargetAfter(boolean invertClosedGripIfTargetAfter) {
        return (Splitbar)setAttribute("invertClosedGripIfTargetAfter", invertClosedGripIfTargetAfter, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowClosedGrip showClosedGrip} is true, and {@link
     * com.smartgwt.client.widgets.Splitbar#getTargetAfter targetAfter} is true should we show the "closed" state for the grip
     * when the target is visible (rather than when it is hidden). <P> This property is useful for the case where the grip
     * media is a simple directional arrow. The same image can be used for expanded state on one side of the bar or collapsed
     * state on the other.
     *
     * @return Current invertClosedGripIfTargetAfter value. Default value is true
     */
    public boolean getInvertClosedGripIfTargetAfter()  {
        Boolean result = getAttributeAsBoolean("invertClosedGripIfTargetAfter");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden. Note that if {@link
     * com.smartgwt.client.widgets.Splitbar#getInvertClosedGripIfTargetAfter invertClosedGripIfTargetAfter} is true, we may
     * show the "closed" state when the target is visible, rather than when it is hidden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showClosedGrip New showClosedGrip value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setShowClosedGrip(Boolean showClosedGrip)  throws IllegalStateException {
        return (Splitbar)setAttribute("showClosedGrip", showClosedGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden. Note that if {@link
     * com.smartgwt.client.widgets.Splitbar#getInvertClosedGripIfTargetAfter invertClosedGripIfTargetAfter} is true, we may
     * show the "closed" state when the target is visible, rather than when it is hidden.
     *
     * @return Current showClosedGrip value. Default value is null
     */
    public Boolean getShowClosedGrip()  {
        return getAttributeAsBoolean("showClosedGrip");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDownGrip New showDownGrip value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setShowDownGrip(Boolean showDownGrip)  throws IllegalStateException {
        return (Splitbar)setAttribute("showDownGrip", showDownGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     *
     * @return Current showDownGrip value. Default value is null
     */
    public Boolean getShowDownGrip()  {
        return getAttributeAsBoolean("showDownGrip");
    }
    

    /**
     * Should we show a "grip" image floating above the center of this widget?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showGrip New showGrip value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setShowGrip(Boolean showGrip)  throws IllegalStateException {
        return (Splitbar)setAttribute("showGrip", showGrip, false);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     * @return Current showGrip value. Default value is null
     */
    public Boolean getShowGrip()  {
        return getAttributeAsBoolean("showGrip");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip New showRollOverGrip value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        return (Splitbar)setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip StretchImg.showGrip} is true, this property determines
     * whether to show the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     *
     * @return Current showRollOverGrip value. Default value is null
     */
    public Boolean getShowRollOverGrip()  {
        return getAttributeAsBoolean("showRollOverGrip");
    }
    
    

    /**
     * The base URL for the image.  <P> The {@link com.smartgwt.client.types.State} for the component will be combined with
     * this URL using the same approach as described in {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. Then the image
     * segment {@link com.smartgwt.client.widgets.StretchItem#getName name} as specified by each {@link
     * com.smartgwt.client.widgets.StretchItem} is added. <P> For example, for a stretchImg in "Over" state with a
     * <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *
     * @param src New src value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.StretchImg#setHSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Splitbar setSrc(String src)  throws IllegalStateException {
        return (Splitbar)setAttribute("src", src, false);
    }

    /**
     * The base URL for the image.  <P> The {@link com.smartgwt.client.types.State} for the component will be combined with
     * this URL using the same approach as described in {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. Then the image
     * segment {@link com.smartgwt.client.widgets.StretchItem#getName name} as specified by each {@link
     * com.smartgwt.client.widgets.StretchItem} is added. <P> For example, for a stretchImg in "Over" state with a
     * <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getHSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * When a <code>Splitbar</code> is created by a layout, the <code>target</code> property of the Splitbar will be a pointer
     * to the member for which it is acting as a resizeBar. The Splitbar will be positioned next to its target, and will resize
     * it on drag completion. <P> See {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass
     * Layout.resizeBarClass},  {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar Canvas.showResizeBar} and  {@link
     * com.smartgwt.client.widgets.Canvas#getResizeBarTarget Canvas.resizeBarTarget} for details on configuring the resize bars
     * shown in Layouts.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current target value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getTarget() throws IllegalStateException {
        errorIfNotCreated("target");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("target"));
    }
    

    /**
     * Is the {@link com.smartgwt.client.widgets.Splitbar#getTarget target} being shown before or after the bar? This property
     * is automatically populated for <code>splitbar</code>s created by a layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param targetAfter New targetAfter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Splitbar#setInvertClosedGripIfTargetAfter
     */
    public Splitbar setTargetAfter(Boolean targetAfter) {
        return (Splitbar)setAttribute("targetAfter", targetAfter, true);
    }

    /**
     * Is the {@link com.smartgwt.client.widgets.Splitbar#getTarget target} being shown before or after the bar? This property
     * is automatically populated for <code>splitbar</code>s created by a layout.
     *
     * @return Current targetAfter value. Default value is null
     * @see com.smartgwt.client.widgets.Splitbar#getInvertClosedGripIfTargetAfter
     */
    public Boolean getTargetAfter()  {
        return getAttributeAsBoolean("targetAfter");
    }
    

    /**
     * Is this split bar vertically orientated?<br> When a <code>Splitbar</code> is created by a layout to be the resizeBar for
     * some member of the layout, the <code>vertical</code> property will be set to <code>true</code> if the layout is
     * horizontal, meaning this resizeBar will be taller than it is wide,  and will allow horizontal resizing of the member.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current vertical value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getVertical() throws IllegalStateException {
        errorIfNotCreated("vertical");
        return getAttributeAsBoolean("vertical");
    }
    

    /**
     * Cursor to display if this Splitbar is to be used for vertical resize of widgets.
     *
     * @param vResizeCursor New vResizeCursor value. Default value is "row-resize"
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Splitbar setVResizeCursor(Cursor vResizeCursor)  throws IllegalStateException {
        return (Splitbar)setAttribute("vResizeCursor", vResizeCursor == null ? null : vResizeCursor.getValue(), false);
    }

    /**
     * Cursor to display if this Splitbar is to be used for vertical resize of widgets.
     *
     * @return Current vResizeCursor value. Default value is "row-resize"
     */
    public Cursor getVResizeCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("vResizeCursor"));
    }
    

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is true and 
     * {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} is unset.
     *
     * @param vSrc New vSrc value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Splitbar Splitbar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.StretchImg#setSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Splitbar setVSrc(String vSrc)  throws IllegalStateException {
        return (Splitbar)setAttribute("vSrc", vSrc, false);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical StretchImg.vertical} is true and 
     * {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} is unset.
     *
     * @return Current vSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
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
     * @param splitbarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Splitbar splitbarProperties) /*-{
        if (splitbarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Splitbar.@java.lang.Object::getClass()(), "setDefaultProperties", splitbarProperties.@java.lang.Object::getClass()());
        }
        splitbarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = splitbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Splitbar.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SplitbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canCollapse = getAttributeAsString("canCollapse");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.canCollapse:" + t.getMessage() + "\n";
        }
        try {
            s.canCollapseOnTap = getAttributeAsString("canCollapseOnTap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.canCollapseOnTap:" + t.getMessage() + "\n";
        }
        try {
            s.canDrag = getAttributeAsString("canDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.canDrag:" + t.getMessage() + "\n";
        }
        try {
            s.cursor = getAttributeAsString("cursor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.cursor:" + t.getMessage() + "\n";
        }
        try {
            s.gripBreadth = getAttributeAsString("gripBreadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.gripBreadth:" + t.getMessage() + "\n";
        }
        try {
            s.gripImgSuffix = getAttributeAsString("gripImgSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.gripImgSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.gripLength = getAttributeAsString("gripLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.gripLength:" + t.getMessage() + "\n";
        }
        try {
            s.hResizeCursor = getAttributeAsString("hResizeCursor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.hResizeCursor:" + t.getMessage() + "\n";
        }
        try {
            s.hSrc = getAttributeAsString("hSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.hSrc:" + t.getMessage() + "\n";
        }
        try {
            s.invertClosedGripIfTargetAfter = getAttributeAsString("invertClosedGripIfTargetAfter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.invertClosedGripIfTargetAfter:" + t.getMessage() + "\n";
        }
        try {
            s.showClosedGrip = getAttributeAsString("showClosedGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.showClosedGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showDownGrip = getAttributeAsString("showDownGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.showDownGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showGrip = getAttributeAsString("showGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.showGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverGrip = getAttributeAsString("showRollOverGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.showRollOverGrip:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.src:" + t.getMessage() + "\n";
        }
        try {
            s.target = getTarget();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.target:" + t.getMessage() + "\n";
        }
        try {
            s.targetAfter = getAttributeAsString("targetAfter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.targetAfter:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vResizeCursor = getAttributeAsString("vResizeCursor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.vResizeCursor:" + t.getMessage() + "\n";
        }
        try {
            s.vSrc = getAttributeAsString("vSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Splitbar.vSrc:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SplitbarLogicalStructure s = new SplitbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
