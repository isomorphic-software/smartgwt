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
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

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
 * The Scrollbar widget implements cross-platform, image-based scrollbars that control the scrolling of content in other
 * widgets.  Scrollbar widgets are created and displayed automatically for widgets that require them, based on settings for
 * {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}. <P> The scrollbar's appearance is based on a {@link
 * com.smartgwt.client.widgets.StretchImg} for the "track", which consists of two fixed size buttons and a stretchable
 * center segment, and the ScrollThumb, the draggable portion of the scrollbar, also a StretchImg, with an optional {@link
 * com.smartgwt.client.widgets.StretchImg#getShowGrip grip}.
 */
public class Scrollbar extends StretchImg {

    public static Scrollbar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Scrollbar) obj;
        } else {
            return new Scrollbar(jsObj);
        }
    }

    public Scrollbar(){
        scClassName = "Scrollbar";
    }

    public Scrollbar(JavaScriptObject jsObj){
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
     * If true, the thumb's appearance changes when it's clicked on.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowThumbDownState allowThumbDownState Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowThumbDownState(Boolean allowThumbDownState)  throws IllegalStateException {
        setAttribute("allowThumbDownState", allowThumbDownState, false);
    }

    /**
     * If true, the thumb's appearance changes when it's clicked on.
     *
     *
     * @return Boolean
     */
    public Boolean getAllowThumbDownState()  {
        return getAttributeAsBoolean("allowThumbDownState");
    }

    /**
     * If true, the thumb's appearance changes when the user rolls over it.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowThumbOverState allowThumbOverState Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowThumbOverState(Boolean allowThumbOverState)  throws IllegalStateException {
        setAttribute("allowThumbOverState", allowThumbOverState, false);
    }

    /**
     * If true, the thumb's appearance changes when the user rolls over it.
     *
     *
     * @return Boolean
     */
    public Boolean getAllowThumbOverState()  {
        return getAttributeAsBoolean("allowThumbOverState");
    }

    /**
     * If true, this scrollbar will automatically enable when the scrollTarget is scrollable (i.e., when the contents of the
     * scrollTarget exceed its clip size in the direction relevant to this scrollbar), and automatically disable when the
     * scrollTarget is not scrollable. Set this property to false for full manual control over a scrollbar's enabled state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoEnable autoEnable Default value is true
     */
    public void setAutoEnable(Boolean autoEnable) {
        setAttribute("autoEnable", autoEnable, true);
    }

    /**
     * If true, this scrollbar will automatically enable when the scrollTarget is scrollable (i.e., when the contents of the
     * scrollTarget exceed its clip size in the direction relevant to this scrollbar), and automatically disable when the
     * scrollTarget is not scrollable. Set this property to false for full manual control over a scrollbar's enabled state.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoEnable()  {
        return getAttributeAsBoolean("autoEnable");
    }

    /**
     * The size of the square buttons (arrows) at the ends of this scrollbar. This  overrides the width of a vertical scrollbar
     * or the height of a horizontal scrollbar to set the scrollbar's thickness.
     *
     * @param btnSize btnSize Default value is 16
     */
    public void setBtnSize(int btnSize) {
        setAttribute("btnSize", btnSize, true);
    }

    /**
     * The size of the square buttons (arrows) at the ends of this scrollbar. This  overrides the width of a vertical scrollbar
     * or the height of a horizontal scrollbar to set the scrollbar's thickness.
     *
     *
     * @return int
     */
    public int getBtnSize()  {
        return getAttributeAsInt("btnSize");
    }

    /**
     * Allows the size of the corner segment to be set independently of the {@link
     * com.smartgwt.client.widgets.Scrollbar#getBtnSize btnSize}.
     *
     * @param cornerSize cornerSize Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCornerSize(Integer cornerSize)  throws IllegalStateException {
        setAttribute("cornerSize", cornerSize, false);
    }

    /**
     * Allows the size of the corner segment to be set independently of the {@link
     * com.smartgwt.client.widgets.Scrollbar#getBtnSize btnSize}.
     *
     *
     * @return Integer
     */
    public Integer getCornerSize()  {
        return getAttributeAsInt("cornerSize");
    }

    /**
     * URL for the corner image, a singular image that appears in the corner when both h and v scrollbars are showing.
     *
     * @param cornerSrc cornerSrc Default value is "[SKIN]corner.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setCornerSrc(String cornerSrc)  throws IllegalStateException {
        setAttribute("cornerSrc", cornerSrc, false);
    }

    /**
     * URL for the corner image, a singular image that appears in the corner when both h and v scrollbars are showing.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getCornerSrc()  {
        return getAttributeAsString("cornerSrc");
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param endThumbOverlap endThumbOverlap Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndThumbOverlap(Integer endThumbOverlap)  throws IllegalStateException {
        setAttribute("endThumbOverlap", endThumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     *
     * @return Integer
     */
    public Integer getEndThumbOverlap()  {
        return getAttributeAsInt("endThumbOverlap");
    }

    /**
     * Base URL for the images used for the horizontal scrollbar track and end buttons.   <P> See {@link
     * com.smartgwt.client.widgets.StretchImg#getItems items} for a general explanation of how this base URL is transformed
     * into various pieces and states. <P> For a normal 3-segment track, the suffixes "_start", "_track" and "_end" are added
     * to this URL.  The "start" and "end" images should appear to be buttons (the user can click on these segments to scroll
     * slowly).  The "track" segment provides a background for the space in which the thumb can be dragged, and can also be
     * clicked on to scroll quickly. <P> For a 5-segment track ({@link com.smartgwt.client.widgets.Scrollbar#getShowTrackEnds
     * showTrackEnds}:true), the suffixes are "_start", "_track_start", "_track", "_track_end" and "_end".
     *
     * @param hSrc hSrc Default value is "[SKIN]hscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setHSrc(String hSrc)  throws IllegalStateException {
        setAttribute("hSrc", hSrc, false);
    }

    /**
     * Base URL for the images used for the horizontal scrollbar track and end buttons.   <P> See {@link
     * com.smartgwt.client.widgets.StretchImg#getItems items} for a general explanation of how this base URL is transformed
     * into various pieces and states. <P> For a normal 3-segment track, the suffixes "_start", "_track" and "_end" are added
     * to this URL.  The "start" and "end" images should appear to be buttons (the user can click on these segments to scroll
     * slowly).  The "track" segment provides a background for the space in which the thumb can be dragged, and can also be
     * clicked on to scroll quickly. <P> For a 5-segment track ({@link com.smartgwt.client.widgets.Scrollbar#getShowTrackEnds
     * showTrackEnds}:true), the suffixes are "_start", "_track_start", "_track", "_track_end" and "_end".
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }

    /**
     * If true, displays a corner piece at the bottom end of a vertical scrollbar, or the right end of a horizontal scrollbar.
     * This is typically set only when both horizontal and vertical scrollbars are displayed and about the same corner.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCorner showCorner Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowCorner(Boolean showCorner)  throws IllegalStateException {
        setAttribute("showCorner", showCorner, false);
    }

    /**
     * If true, displays a corner piece at the bottom end of a vertical scrollbar, or the right end of a horizontal scrollbar.
     * This is typically set only when both horizontal and vertical scrollbars are displayed and about the same corner.
     *
     *
     * @return Boolean
     */
    public Boolean getShowCorner()  {
        return getAttributeAsBoolean("showCorner");
    }

    /**
     * If true, the scrollbar uses a 5-segment rather than 3-segment image representation, where the 3 interior image segments
     * have the same state (Down, Over, etc), independent of the two outermost image segments.   <P> This allows certain
     * advanced skinning designs where the track-as-such (space in which the thumb may be dragged) has curved endcaps, and is
     * also visually stateful (that is, changes when the mouse goes down, without affecting the appearance of the outermost
     * segments).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTrackEnds showTrackEnds Default value is false
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
     *
     * @return Boolean
     */
    public Boolean getShowTrackEnds()  {
        return getAttributeAsBoolean("showTrackEnds");
    }

    /**
     * Where are the skin images for the Scrollbar.  This is local to the {@link com.smartgwt.client.util.Page#getSkinDir
     * overall skin directory}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param skinImgDir skinImgDir Default value is "images/Scrollbar/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Where are the skin images for the Scrollbar.  This is local to the {@link com.smartgwt.client.util.Page#getSkinDir
     * overall skin directory}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the start of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param startThumbOverlap startThumbOverlap Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartThumbOverlap(Integer startThumbOverlap)  throws IllegalStateException {
        setAttribute("startThumbOverlap", startThumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at the start of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     *
     * @return Integer
     */
    public Integer getStartThumbOverlap()  {
        return getAttributeAsInt("startThumbOverlap");
    }

    /**
     * Inset of the thumb relative to the track.  An inset of N pixels means the thumb is 2N pixels smaller in breadth than the
     * track.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbInset thumbInset Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbInset(Integer thumbInset)  throws IllegalStateException {
        setAttribute("thumbInset", thumbInset, false);
    }

    /**
     * Inset of the thumb relative to the track.  An inset of N pixels means the thumb is 2N pixels smaller in breadth than the
     * track.
     *
     *
     * @return Integer
     */
    public Integer getThumbInset()  {
        return getAttributeAsInt("thumbInset");
    }

    /**
     * The minimum pixel size of the draggable thumb regardless of how large the scrolling region becomes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbMinSize thumbMinSize Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbMinSize(int thumbMinSize)  throws IllegalStateException {
        setAttribute("thumbMinSize", thumbMinSize, false);
    }

    /**
     * The minimum pixel size of the draggable thumb regardless of how large the scrolling region becomes.
     *
     *
     * @return int
     */
    public int getThumbMinSize()  {
        return getAttributeAsInt("thumbMinSize");
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at each end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param thumbOverlap thumbOverlap Default value is 1
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setThumbOverlap(int thumbOverlap)  throws IllegalStateException {
        setAttribute("thumbOverlap", thumbOverlap, false);
    }

    /**
     * Number of pixels the thumb is allowed to overlap the buttons at each end of the track. Default prevents doubling of 1px
     * borders.  Set higher to allow media that shows curved joins between the track button and ScrollThumb.
     *
     *
     * @return int
     */
    public int getThumbOverlap()  {
        return getAttributeAsInt("thumbOverlap");
    }

    /**
     * The minimum pixel height of the track end segments (if enabled with showTrackEnds).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param trackEndHeight trackEndHeight Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackEndHeight(int trackEndHeight)  throws IllegalStateException {
        setAttribute("trackEndHeight", trackEndHeight, false);
    }

    /**
     * The minimum pixel height of the track end segments (if enabled with showTrackEnds).
     *
     *
     * @return int
     */
    public int getTrackEndHeight()  {
        return getAttributeAsInt("trackEndHeight");
    }

    /**
     * The minimum pixel width of the track end segments (if enabled with showTrackEnds).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param trackEndWidth trackEndWidth Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTrackEndWidth(int trackEndWidth)  throws IllegalStateException {
        setAttribute("trackEndWidth", trackEndWidth, false);
    }

    /**
     * The minimum pixel width of the track end segments (if enabled with showTrackEnds).
     *
     *
     * @return int
     */
    public int getTrackEndWidth()  {
        return getAttributeAsInt("trackEndWidth");
    }

    /**
     * Base URL for the images used for the vertical scrollbar track and end buttons.  See {@link
     * com.smartgwt.client.widgets.Scrollbar#getHSrc hSrc} for usage.
     *
     * @param vSrc vSrc Default value is "[SKIN]vscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setVSrc(String vSrc)  throws IllegalStateException {
        setAttribute("vSrc", vSrc, false);
    }

    /**
     * Base URL for the images used for the vertical scrollbar track and end buttons.  See {@link
     * com.smartgwt.client.widgets.Scrollbar#getHSrc hSrc} for usage.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param scrollbarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Scrollbar scrollbarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},scrollbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
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

}




