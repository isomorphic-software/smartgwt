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
 * The Scrollbar widget implements cross-platform, image-based scrollbars that control the scrolling of content in other
 * widgets.  Scrollbar widgets are created and displayed automatically for widgets that require them, based on settings for
 * {@link com.smartgwt.client.widgets.Canvas#getOverflow Canvas.overflow}. <P> The scrollbar's appearance is based on a
 * {@link com.smartgwt.client.widgets.StretchImg} for the "track", which consists of two fixed size buttons and a
 * stretchable center segment, and the ScrollThumb, the draggable portion of the scrollbar, also a StretchImg, with an
 * optional {@link com.smartgwt.client.widgets.StretchImg#getShowGrip grip}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Scrollbar")
public class Scrollbar extends StretchImg {

    public static Scrollbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Scrollbar(jsObj);
        } else {
            assert refInstance instanceof Scrollbar;
            return (Scrollbar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Scrollbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Scrollbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Scrollbar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Scrollbar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Scrollbar(){
        scClassName = "Scrollbar";
    }

    public Scrollbar(JavaScriptObject jsObj){
        scClassName = "Scrollbar";
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
     * If true, the thumb's appearance changes when it's clicked on.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowThumbDownState New allowThumbDownState value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowThumbDownState(Boolean allowThumbDownState)  throws IllegalStateException {
        setAttribute("allowThumbDownState", allowThumbDownState, false);
    }

    /**
     * If true, the thumb's appearance changes when it's clicked on.
     *
     * @return Current allowThumbDownState value. Default value is false
     */
    public Boolean getAllowThumbDownState()  {
        Boolean result = getAttributeAsBoolean("allowThumbDownState");
        return result == null ? false : result;
    }
    

    /**
     * If true, the thumb's appearance changes when the user rolls over it.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowThumbOverState New allowThumbOverState value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowThumbOverState(Boolean allowThumbOverState)  throws IllegalStateException {
        setAttribute("allowThumbOverState", allowThumbOverState, false);
    }

    /**
     * If true, the thumb's appearance changes when the user rolls over it.
     *
     * @return Current allowThumbOverState value. Default value is false
     */
    public Boolean getAllowThumbOverState()  {
        Boolean result = getAttributeAsBoolean("allowThumbOverState");
        return result == null ? false : result;
    }
    

    /**
     * If true, this scrollbar will automatically enable when the scrollTarget is scrollable (i.e., when the contents of the
     * scrollTarget exceed its clip size in the direction relevant to this scrollbar), and automatically disable when the
     * scrollTarget is not scrollable. Set this property to false for full manual control over a scrollbar's enabled state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoEnable New autoEnable value. Default value is true
     */
    public void setAutoEnable(Boolean autoEnable) {
        setAttribute("autoEnable", autoEnable, true);
    }

    /**
     * If true, this scrollbar will automatically enable when the scrollTarget is scrollable (i.e., when the contents of the
     * scrollTarget exceed its clip size in the direction relevant to this scrollbar), and automatically disable when the
     * scrollTarget is not scrollable. Set this property to false for full manual control over a scrollbar's enabled state.
     *
     * @return Current autoEnable value. Default value is true
     */
    public Boolean getAutoEnable()  {
        Boolean result = getAttributeAsBoolean("autoEnable");
        return result == null ? true : result;
    }
    

    /**
     * The size of the square buttons (arrows) at the ends of this scrollbar. This overrides  {@link
     * com.smartgwt.client.widgets.Canvas#getScrollbarSize Canvas.scrollbarSize} to set the width of a vertical scrollbar or
     * the height of a horizontal scrollbar.  If not set it will default to {@link
     * com.smartgwt.client.widgets.Canvas#getScrollbarSize Canvas.scrollbarSize}.
     *
     * @param btnSize New btnSize value. Default value is null
     */
    public void setBtnSize(Integer btnSize) {
        setAttribute("btnSize", btnSize, true);
    }

    /**
     * The size of the square buttons (arrows) at the ends of this scrollbar. This overrides  {@link
     * com.smartgwt.client.widgets.Canvas#getScrollbarSize Canvas.scrollbarSize} to set the width of a vertical scrollbar or
     * the height of a horizontal scrollbar.  If not set it will default to {@link
     * com.smartgwt.client.widgets.Canvas#getScrollbarSize Canvas.scrollbarSize}.
     *
     * @return Current btnSize value. Default value is null
     */
    public Integer getBtnSize()  {
        return getAttributeAsInt("btnSize");
    }
    

    /**
     * The StretchItem for the corner between vertical and horizontal scrollbars. The width and height are determined
     * automatically, so {@link com.smartgwt.client.widgets.StretchItem#getWidth StretchItem.width} and {@link
     * com.smartgwt.client.widgets.StretchItem#getHeight StretchItem.height} set on the cornerImg StretchItem are ignored. The
     * default is:  <code>new StretchItem("corner", null, null)</code>
     *
     * @param cornerImg New cornerImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCornerImg(StretchItem cornerImg)  throws IllegalStateException {
        setAttribute("cornerImg", cornerImg == null ? null : cornerImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the corner between vertical and horizontal scrollbars. The width and height are determined
     * automatically, so {@link com.smartgwt.client.widgets.StretchItem#getWidth StretchItem.width} and {@link
     * com.smartgwt.client.widgets.StretchItem#getHeight StretchItem.height} set on the cornerImg StretchItem are ignored. The
     * default is:  <code>new StretchItem("corner", null, null)</code>
     *
     * @return Current cornerImg value. Default value is see below
     */
    public StretchItem getCornerImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("cornerImg"));
    }
    

    /**
     * Allows the size of the corner segment to be set independently of the {@link
     * com.smartgwt.client.widgets.Scrollbar#getBtnSize btnSize}.
     *
     * @param cornerSize New cornerSize value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCornerSize(Integer cornerSize)  throws IllegalStateException {
        setAttribute("cornerSize", cornerSize, false);
    }

    /**
     * Allows the size of the corner segment to be set independently of the {@link
     * com.smartgwt.client.widgets.Scrollbar#getBtnSize btnSize}.
     *
     * @return Current cornerSize value. Default value is null
     */
    public Integer getCornerSize()  {
        return getAttributeAsInt("cornerSize");
    }
    

    /**
     * URL for the corner image, a singular image that appears in the corner when both h and v scrollbars are showing.
     *
     * @param cornerSrc New cornerSrc value. Default value is "[SKIN]corner.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setCornerSrc(String cornerSrc)  throws IllegalStateException {
        setAttribute("cornerSrc", cornerSrc, false);
    }

    /**
     * URL for the corner image, a singular image that appears in the corner when both h and v scrollbars are showing.
     *
     * @return Current cornerSrc value. Default value is "[SKIN]corner.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getCornerSrc()  {
        return getAttributeAsString("cornerSrc");
    }
    

    /**
     * The StretchItem for the end of a scrollbar (the "scroll down" or "scroll right" button image). The default is: 
     * <code>new StretchItem("end", "btnSize", "btnSize")</code>
     *
     * @param endImg New endImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndImg(StretchItem endImg)  throws IllegalStateException {
        setAttribute("endImg", endImg == null ? null : endImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the end of a scrollbar (the "scroll down" or "scroll right" button image). The default is: 
     * <code>new StretchItem("end", "btnSize", "btnSize")</code>
     *
     * @return Current endImg value. Default value is see below
     */
    public StretchItem getEndImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("endImg"));
    }
    

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param endThumbOverlap New endThumbOverlap value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndThumbOverlap(Integer endThumbOverlap)  throws IllegalStateException {
        setAttribute("endThumbOverlap", endThumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     * @return Current endThumbOverlap value. Default value is null
     */
    public Integer getEndThumbOverlap()  {
        return getAttributeAsInt("endThumbOverlap");
    }
    

    /**
     * Base URL for the images used for the horizontal scrollbar track and end buttons.   <P> See {@link
     * com.smartgwt.client.widgets.StretchImg#getItems StretchImg.items} for a general explanation of how this base URL is
     * transformed into various pieces and states. <P> For a normal 3-segment track, the suffixes "_start", "_track" and "_end"
     * are added to this URL.  The "start" and "end" images should appear to be buttons (the user can click on these segments
     * to scroll slowly).  The "track" segment provides a background for the space in which the thumb can be dragged, and can
     * also be clicked on to scroll quickly. <P> For a 5-segment track ({@link
     * com.smartgwt.client.widgets.Scrollbar#getShowTrackEnds showTrackEnds}:true), the suffixes are "_start", "_track_start",
     * "_track", "_track_end" and "_end".
     *
     * @param hSrc New hSrc value. Default value is "[SKIN]hscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setHSrc(String hSrc)  throws IllegalStateException {
        setAttribute("hSrc", hSrc, false);
    }

    /**
     * Base URL for the images used for the horizontal scrollbar track and end buttons.   <P> See {@link
     * com.smartgwt.client.widgets.StretchImg#getItems StretchImg.items} for a general explanation of how this base URL is
     * transformed into various pieces and states. <P> For a normal 3-segment track, the suffixes "_start", "_track" and "_end"
     * are added to this URL.  The "start" and "end" images should appear to be buttons (the user can click on these segments
     * to scroll slowly).  The "track" segment provides a background for the space in which the thumb can be dragged, and can
     * also be clicked on to scroll quickly. <P> For a 5-segment track ({@link
     * com.smartgwt.client.widgets.Scrollbar#getShowTrackEnds showTrackEnds}:true), the suffixes are "_start", "_track_start",
     * "_track", "_track_end" and "_end".
     *
     * @return Current hSrc value. Default value is "[SKIN]hscroll.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }
    

    /**
     * The widget whose contents should be scrolled by this scrollbar. The scrollbar thumb is sized according to the amount of
     * visible vs. scrollable content in this widget.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets or clears the scrollbar's scrollTarget. If no argument is provided, then the          scrollTarget will be set to the scrollbar itself.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param scrollTarget target canvas to be scrolled. Default value is null
     */
    public void setScrollTarget(Canvas scrollTarget) {
        setAttribute("scrollTarget", scrollTarget == null ? null : scrollTarget.getOrCreateJsObj(), true);
    }

    /**
     * The widget whose contents should be scrolled by this scrollbar. The scrollbar thumb is sized according to the amount of
     * visible vs. scrollable content in this widget.
     *
     * @return Current scrollTarget value. Default value is null
     */
    public Canvas getScrollTarget()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("scrollTarget"));
    }
    

    /**
     * If true, displays a corner piece at the bottom end of a vertical scrollbar, or the right end of a horizontal scrollbar.
     * This is typically set only when both horizontal and vertical scrollbars are displayed and about the same corner.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCorner New showCorner value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowCorner(Boolean showCorner)  throws IllegalStateException {
        setAttribute("showCorner", showCorner, false);
    }

    /**
     * If true, displays a corner piece at the bottom end of a vertical scrollbar, or the right end of a horizontal scrollbar.
     * This is typically set only when both horizontal and vertical scrollbars are displayed and about the same corner.
     *
     * @return Current showCorner value. Default value is false
     */
    public Boolean getShowCorner()  {
        Boolean result = getAttributeAsBoolean("showCorner");
        return result == null ? false : result;
    }
    

    /**
     * Should the track buttons that allow page scrolling be shown? <P>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTrackButtons New showTrackButtons value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTrackButtons(Boolean showTrackButtons)  throws IllegalStateException {
        setAttribute("showTrackButtons", showTrackButtons, false);
    }

    /**
     * Should the track buttons that allow page scrolling be shown? <P>
     *
     * @return Current showTrackButtons value. Default value is true
     */
    public Boolean getShowTrackButtons()  {
        Boolean result = getAttributeAsBoolean("showTrackButtons");
        return result == null ? true : result;
    }
    

    /**
     * If true, the scrollbar uses a 5-segment rather than 3-segment image representation, where the 3 interior image segments
     * have the same state (Down, Over, etc), independent of the two outermost image segments.   <P> This allows certain
     * advanced skinning designs where the track-as-such (space in which the thumb may be dragged) has curved endcaps, and is
     * also visually stateful (that is, changes when the mouse goes down, without affecting the appearance of the outermost
     * segments).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTrackEnds New showTrackEnds value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTrackEnds(Boolean showTrackEnds)  throws IllegalStateException {
        setAttribute("showTrackEnds", showTrackEnds, false);
    }

    /**
     * If true, the scrollbar uses a 5-segment rather than 3-segment image representation, where the 3 interior image segments
     * have the same state (Down, Over, etc), independent of the two outermost image segments.   <P> This allows certain
     * advanced skinning designs where the track-as-such (space in which the thumb may be dragged) has curved endcaps, and is
     * also visually stateful (that is, changes when the mouse goes down, without affecting the appearance of the outermost
     * segments).
     *
     * @return Current showTrackEnds value. Default value is false
     */
    public Boolean getShowTrackEnds()  {
        Boolean result = getAttributeAsBoolean("showTrackEnds");
        return result == null ? false : result;
    }
    

    /**
     * Where are the skin images for the Scrollbar.  This is local to the {@link com.smartgwt.client.util.Page#getSkinDir
     * overall skin directory}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/Scrollbar/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Where are the skin images for the Scrollbar.  This is local to the {@link com.smartgwt.client.util.Page#getSkinDir
     * overall skin directory}.
     *
     * @return Current skinImgDir value. Default value is "images/Scrollbar/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * The StretchItem for the start of a scrollbar (the "scroll up" or "scroll left" button image). The default is:  <code>new
     * StretchItem("start", "btnSize", "btnSize")</code>
     *
     * @param startImg New startImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartImg(StretchItem startImg)  throws IllegalStateException {
        setAttribute("startImg", startImg == null ? null : startImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the start of a scrollbar (the "scroll up" or "scroll left" button image). The default is:  <code>new
     * StretchItem("start", "btnSize", "btnSize")</code>
     *
     * @return Current startImg value. Default value is see below
     */
    public StretchItem getStartImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("startImg"));
    }
    

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the start of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param startThumbOverlap New startThumbOverlap value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartThumbOverlap(Integer startThumbOverlap)  throws IllegalStateException {
        setAttribute("startThumbOverlap", startThumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the start of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     * @return Current startThumbOverlap value. Default value is null
     */
    public Integer getStartThumbOverlap()  {
        return getAttributeAsInt("startThumbOverlap");
    }
    

    /**
     * Inset of the thumb relative to the track.  An inset of N pixels means the thumb is 2N pixels smaller in breadth than the
     * track.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbInset New thumbInset value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbInset(Integer thumbInset)  throws IllegalStateException {
        setAttribute("thumbInset", thumbInset, false);
    }

    /**
     * Inset of the thumb relative to the track.  An inset of N pixels means the thumb is 2N pixels smaller in breadth than the
     * track.
     *
     * @return Current thumbInset value. Default value is null
     */
    public Integer getThumbInset()  {
        return getAttributeAsInt("thumbInset");
    }
    

    /**
     * The minimum pixel size of the draggable thumb regardless of how large the scrolling region becomes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbMinSize New thumbMinSize value. Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbMinSize(int thumbMinSize)  throws IllegalStateException {
        setAttribute("thumbMinSize", thumbMinSize, false);
    }

    /**
     * The minimum pixel size of the draggable thumb regardless of how large the scrolling region becomes.
     *
     * @return Current thumbMinSize value. Default value is 12
     */
    public int getThumbMinSize()  {
        return getAttributeAsInt("thumbMinSize");
    }
    

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at each end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbOverlap New thumbOverlap value. Default value is 1
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbOverlap(int thumbOverlap)  throws IllegalStateException {
        setAttribute("thumbOverlap", thumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at each end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     * @return Current thumbOverlap value. Default value is 1
     */
    public int getThumbOverlap()  {
        return getAttributeAsInt("thumbOverlap");
    }
    

    /**
     * The minimum pixel height of the track end segments (if enabled with showTrackEnds).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param trackEndHeight New trackEndHeight value. Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackEndHeight(int trackEndHeight)  throws IllegalStateException {
        setAttribute("trackEndHeight", trackEndHeight, false);
    }

    /**
     * The minimum pixel height of the track end segments (if enabled with showTrackEnds).
     *
     * @return Current trackEndHeight value. Default value is 12
     */
    public int getTrackEndHeight()  {
        return getAttributeAsInt("trackEndHeight");
    }
    

    /**
     * The StretchItem for the end of a scrollbar track. The default is:  <code>new StretchItem("track_end", "trackEndSize",
     * "trackEndSize")</code>
     *
     * @param trackEndImg New trackEndImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackEndImg(StretchItem trackEndImg)  throws IllegalStateException {
        setAttribute("trackEndImg", trackEndImg == null ? null : trackEndImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the end of a scrollbar track. The default is:  <code>new StretchItem("track_end", "trackEndSize",
     * "trackEndSize")</code>
     *
     * @return Current trackEndImg value. Default value is see below
     */
    public StretchItem getTrackEndImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("trackEndImg"));
    }
    

    /**
     * The minimum pixel width of the track end segments (if enabled with showTrackEnds).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param trackEndWidth New trackEndWidth value. Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackEndWidth(int trackEndWidth)  throws IllegalStateException {
        setAttribute("trackEndWidth", trackEndWidth, false);
    }

    /**
     * The minimum pixel width of the track end segments (if enabled with showTrackEnds).
     *
     * @return Current trackEndWidth value. Default value is 12
     */
    public int getTrackEndWidth()  {
        return getAttributeAsInt("trackEndWidth");
    }
    

    /**
     * The StretchItem for the middle part of a scrollbar track, which usually takes up the majority of the width or height of
     * the scrollbar. The default is:  <code>new StretchItem("track", "*", "*")</code>
     *
     * @param trackImg New trackImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackImg(StretchItem trackImg)  throws IllegalStateException {
        setAttribute("trackImg", trackImg == null ? null : trackImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the middle part of a scrollbar track, which usually takes up the majority of the width or height of
     * the scrollbar. The default is:  <code>new StretchItem("track", "*", "*")</code>
     *
     * @return Current trackImg value. Default value is see below
     */
    public StretchItem getTrackImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("trackImg"));
    }
    

    /**
     * The StretchItem for the start of a scrollbar track. The default is:  <code>new StretchItem("track_start",
     * "trackStartSize", "trackStartSize")</code>
     *
     * @param trackStartImg New trackStartImg value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackStartImg(StretchItem trackStartImg)  throws IllegalStateException {
        setAttribute("trackStartImg", trackStartImg == null ? null : trackStartImg.getJsObj(), false);
    }

    /**
     * The StretchItem for the start of a scrollbar track. The default is:  <code>new StretchItem("track_start",
     * "trackStartSize", "trackStartSize")</code>
     *
     * @return Current trackStartImg value. Default value is see below
     */
    public StretchItem getTrackStartImg()  {
        return new StretchItem(getAttributeAsJavaScriptObject("trackStartImg"));
    }
    

    /**
     * Base URL for the images used for the vertical scrollbar track and end buttons.  See {@link
     * com.smartgwt.client.widgets.Scrollbar#getHSrc hSrc} for usage.
     *
     * @param vSrc New vSrc value. Default value is "[SKIN]vscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setVSrc(String vSrc)  throws IllegalStateException {
        setAttribute("vSrc", vSrc, false);
    }

    /**
     * Base URL for the images used for the vertical scrollbar track and end buttons.  See {@link
     * com.smartgwt.client.widgets.Scrollbar#getHSrc hSrc} for usage.
     *
     * @return Current vSrc value. Default value is "[SKIN]vscroll.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
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
     * @param scrollbarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Scrollbar scrollbarProperties) /*-{
        if (scrollbarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Scrollbar.@java.lang.Object::getClass()(), "setDefaultProperties", scrollbarProperties.@java.lang.Object::getClass()());
        }
        scrollbarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = scrollbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Scrollbar.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Preload primary Scrollbar skin images.
     */
    public static native void preloadImages() /*-{
        if($wnd.isc.Canvas.getInstanceProperty('showCustomScrollbars')) {
            var skinImgDir = $wnd.isc.Scrollbar.getInstanceProperty('skinImgDir');
            var vSrc = $wnd.isc.ScrollThumb.getInstanceProperty('vSrc');
            var hSrc = $wnd.isc.ScrollThumb.getInstanceProperty('hSrc');
            @com.smartgwt.client.util.FileLoader::cacheStretchImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(skinImgDir, hSrc, "Down,Over");
            @com.smartgwt.client.util.FileLoader::cacheStretchImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(skinImgDir, vSrc, "Down,Over");
            skinImgDir = $wnd.isc.Scrollbar.getInstanceProperty('skinImgDir');
            vSrc = $wnd.isc.ScrollThumb.getInstanceProperty('vSrc');
            hSrc = $wnd.isc.ScrollThumb.getInstanceProperty('hSrc');
            @com.smartgwt.client.util.FileLoader::cacheStretchImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(skinImgDir, hSrc, "Down,Over");
            @com.smartgwt.client.util.FileLoader::cacheStretchImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(skinImgDir, vSrc, "Down,Over");
        }
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ScrollbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowThumbDownState = getAttributeAsString("allowThumbDownState");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.allowThumbDownState:" + t.getMessage() + "\n";
        }
        try {
            s.allowThumbOverState = getAttributeAsString("allowThumbOverState");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.allowThumbOverState:" + t.getMessage() + "\n";
        }
        try {
            s.autoEnable = getAttributeAsString("autoEnable");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.autoEnable:" + t.getMessage() + "\n";
        }
        try {
            s.btnSize = getAttributeAsString("btnSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.btnSize:" + t.getMessage() + "\n";
        }
        try {
            s.cornerImg = getCornerImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.cornerImg:" + t.getMessage() + "\n";
        }
        try {
            s.cornerSize = getAttributeAsString("cornerSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.cornerSize:" + t.getMessage() + "\n";
        }
        try {
            s.cornerSrc = getAttributeAsString("cornerSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.cornerSrc:" + t.getMessage() + "\n";
        }
        try {
            s.endImg = getEndImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.endImg:" + t.getMessage() + "\n";
        }
        try {
            s.endThumbOverlap = getAttributeAsString("endThumbOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.endThumbOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.hSrc = getAttributeAsString("hSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.hSrc:" + t.getMessage() + "\n";
        }
        try {
            s.scrollTarget = getScrollTarget();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.scrollTarget:" + t.getMessage() + "\n";
        }
        try {
            s.showCorner = getAttributeAsString("showCorner");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.showCorner:" + t.getMessage() + "\n";
        }
        try {
            s.showTrackButtons = getAttributeAsString("showTrackButtons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.showTrackButtons:" + t.getMessage() + "\n";
        }
        try {
            s.showTrackEnds = getAttributeAsString("showTrackEnds");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.showTrackEnds:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.startImg = getStartImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.startImg:" + t.getMessage() + "\n";
        }
        try {
            s.startThumbOverlap = getAttributeAsString("startThumbOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.startThumbOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.thumbInset = getAttributeAsString("thumbInset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.thumbInset:" + t.getMessage() + "\n";
        }
        try {
            s.thumbMinSize = getAttributeAsString("thumbMinSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.thumbMinSize:" + t.getMessage() + "\n";
        }
        try {
            s.thumbOverlap = getAttributeAsString("thumbOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.thumbOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.trackEndHeight = getAttributeAsString("trackEndHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.trackEndHeight:" + t.getMessage() + "\n";
        }
        try {
            s.trackEndImg = getTrackEndImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.trackEndImg:" + t.getMessage() + "\n";
        }
        try {
            s.trackEndWidth = getAttributeAsString("trackEndWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.trackEndWidth:" + t.getMessage() + "\n";
        }
        try {
            s.trackImg = getTrackImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.trackImg:" + t.getMessage() + "\n";
        }
        try {
            s.trackStartImg = getTrackStartImg();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.trackStartImg:" + t.getMessage() + "\n";
        }
        try {
            s.vSrc = getAttributeAsString("vSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Scrollbar.vSrc:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ScrollbarLogicalStructure s = new ScrollbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
