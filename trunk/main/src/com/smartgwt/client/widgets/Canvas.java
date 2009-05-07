/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Canvas is the base abstraction for cross-browser DHTML drawing.&#010  All DHTML widgets inherit from the Canvas class.

    */






























public class Canvas extends BaseWidget  implements com.smartgwt.client.widgets.events.HasDropHandlers, com.smartgwt.client.widgets.events.HasResizedHandlers, com.smartgwt.client.widgets.events.HasClickHandlers, com.smartgwt.client.widgets.events.HasDoubleClickHandlers, com.smartgwt.client.widgets.events.HasDragMoveHandlers, com.smartgwt.client.widgets.events.HasDragRepositionMoveHandlers, com.smartgwt.client.widgets.events.HasDragRepositionStartHandlers, com.smartgwt.client.widgets.events.HasDragRepositionStopHandlers, com.smartgwt.client.widgets.events.HasDragResizeMoveHandlers, com.smartgwt.client.widgets.events.HasDragResizeStartHandlers, com.smartgwt.client.widgets.events.HasDragResizeStopHandlers, com.smartgwt.client.widgets.events.HasDragStartHandlers, com.smartgwt.client.widgets.events.HasDragStopHandlers, com.smartgwt.client.widgets.events.HasDropMoveHandlers, com.smartgwt.client.widgets.events.HasDropOutHandlers, com.smartgwt.client.widgets.events.HasDropOverHandlers, com.smartgwt.client.widgets.events.HasMouseDownHandlers, com.smartgwt.client.widgets.events.HasMouseMoveHandlers, com.smartgwt.client.widgets.events.HasMouseOutHandlers, com.smartgwt.client.widgets.events.HasMouseOverHandlers, com.smartgwt.client.widgets.events.HasMouseStillDownHandlers, com.smartgwt.client.widgets.events.HasMouseUpHandlers, com.smartgwt.client.widgets.events.HasMouseWheelHandlers, com.smartgwt.client.widgets.events.HasKeyPressHandlers, com.smartgwt.client.widgets.events.HasKeyDownHandlers, com.smartgwt.client.widgets.events.HasRightMouseDownHandlers, com.smartgwt.client.widgets.events.HasHoverHandlers, com.smartgwt.client.widgets.events.HasHoverHiddenHandlers, com.smartgwt.client.widgets.events.HasScrolledHandlers, com.smartgwt.client.widgets.events.HasFocusChangedHandlers, com.smartgwt.client.widgets.events.HasShowContextMenuHandlers {

    public static Canvas getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Canvas) obj;
        } else {
            return new Canvas(jsObj);
        }
    }


    public Canvas(){
        setRedrawOnResize(false);
    }

    public Canvas(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Canvas(String id) {
        super(id);
        setRedrawOnResize(false);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Canvas.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Default total duration of animations. Can be overridden by setting animation times for&#010 specific animations, or by passing a <code>duration</code> parameter into the appropriate&#010 animate...() method.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateTime animateTime Default value is 300
    */
    public void setAnimateTime(int animateTime) {
        setAttribute("animateTime", animateTime, true);
    }
    /**
     * Default total duration of animations. Can be overridden by setting animation times for&#010 specific animations, or by passing a <code>duration</code> parameter into the appropriate&#010 animate...() method.
     *
     *
     * @return int
     *
     */
    public int getAnimateTime()  {
        return getAttributeAsInt("animateTime");
    }

    /**
    * Default time for performing an animated move.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateMoveTime animateMoveTime Default value is null
    */
    public void setAnimateMoveTime(Integer animateMoveTime) {
        setAttribute("animateMoveTime", animateMoveTime, true);
    }
    /**
     * Default time for performing an animated move.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateMoveTime()  {
        return getAttributeAsInt("animateMoveTime");
    }

    /**
    * Default time for performing an animated resize.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateResizeTime animateResizeTime Default value is null
    */
    public void setAnimateResizeTime(Integer animateResizeTime) {
        setAttribute("animateResizeTime", animateResizeTime, true);
    }
    /**
     * Default time for performing an animated resize.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateResizeTime()  {
        return getAttributeAsInt("animateResizeTime");
    }

    /**
    * Default time for performing an animated setRect.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateRectTime animateRectTime Default value is null
    */
    public void setAnimateRectTime(Integer animateRectTime) {
        setAttribute("animateRectTime", animateRectTime, true);
    }
    /**
     * Default time for performing an animated setRect.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateRectTime()  {
        return getAttributeAsInt("animateRectTime");
    }

    /**
    * Default time for performing an animated fade.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateFadeTime animateFadeTime Default value is null
    */
    public void setAnimateFadeTime(Integer animateFadeTime) {
        setAttribute("animateFadeTime", animateFadeTime, true);
    }
    /**
     * Default time for performing an animated fade.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateFadeTime()  {
        return getAttributeAsInt("animateFadeTime");
    }

    /**
    * Default time for performing an animated scroll.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateScrollTime animateScrollTime Default value is null
    */
    public void setAnimateScrollTime(Integer animateScrollTime) {
        setAttribute("animateScrollTime", animateScrollTime, true);
    }
    /**
     * Default time for performing an animated scroll.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateScrollTime()  {
        return getAttributeAsInt("animateScrollTime");
    }

    /**
    * Default time for performing an animated show.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateShowTime animateShowTime Default value is null
    */
    public void setAnimateShowTime(Integer animateShowTime) {
        setAttribute("animateShowTime", animateShowTime, true);
    }
    /**
     * Default time for performing an animated show.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateShowTime()  {
        return getAttributeAsInt("animateShowTime");
    }

    /**
    * Default time for performing an animated hide.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateHideTime animateHideTime Default value is null
    */
    public void setAnimateHideTime(Integer animateHideTime) {
        setAttribute("animateHideTime", animateHideTime, true);
    }
    /**
     * Default time for performing an animated hide.  If unset, <code>this.animateTime</code>&#010 will be used by default instead
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateHideTime()  {
        return getAttributeAsInt("animateHideTime");
    }
             
    /**
    * Default acceleration effect for performing an animated move.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateMoveAcceleration animateMoveAcceleration Default value is null
    */
    public void setAnimateMoveAcceleration(AnimationAcceleration animateMoveAcceleration) {
        setAttribute("animateMoveAcceleration", animateMoveAcceleration.getValue(), true);
    }
    /**
     * Default acceleration effect for performing an animated move.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateMoveAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateMoveAcceleration"));
    }
             
    /**
    * Default acceleration function for performing an animated resize.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateResizeAcceleration animateResizeAcceleration Default value is null
    */
    public void setAnimateResizeAcceleration(AnimationAcceleration animateResizeAcceleration) {
        setAttribute("animateResizeAcceleration", animateResizeAcceleration.getValue(), true);
    }
    /**
     * Default acceleration function for performing an animated resize.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateResizeAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateResizeAcceleration"));
    }
             
    /**
    * Default acceleration function for performing an animated move and resize.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateRectAcceleration animateRectAcceleration Default value is null
    */
    public void setAnimateRectAcceleration(AnimationAcceleration animateRectAcceleration) {
        setAttribute("animateRectAcceleration", animateRectAcceleration.getValue(), true);
    }
    /**
     * Default acceleration function for performing an animated move and resize.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateRectAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateRectAcceleration"));
    }
             
    /**
    * Default acceleration function for performing an animated scroll.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateScrollAcceleration animateScrollAcceleration Default value is null
    */
    public void setAnimateScrollAcceleration(AnimationAcceleration animateScrollAcceleration) {
        setAttribute("animateScrollAcceleration", animateScrollAcceleration.getValue(), true);
    }
    /**
     * Default acceleration function for performing an animated scroll.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateScrollAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateScrollAcceleration"));
    }
             
    /**
    * Default acceleration function for performing an animated show.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateShowAcceleration animateShowAcceleration Default value is null
    */
    public void setAnimateShowAcceleration(AnimationAcceleration animateShowAcceleration) {
        setAttribute("animateShowAcceleration", animateShowAcceleration.getValue(), true);
    }
    /**
     * Default acceleration function for performing an animated show.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateShowAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateShowAcceleration"));
    }
             
    /**
    * Default acceleration function for performing an animated hide.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateHideAcceleration animateHideAcceleration Default value is null
    */
    public void setAnimateHideAcceleration(AnimationAcceleration animateHideAcceleration) {
        setAttribute("animateHideAcceleration", animateHideAcceleration.getValue(), true);
    }
    /**
     * Default acceleration function for performing an animated hide.  If unset, &#010 <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateHideAcceleration()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateHideAcceleration"));
    }

    /**
    * When this Canvas is included as a member in a Layout, whether a resizeBar should be shown&#010 after this member in the layout, to allow it to be resized.&#010 <p>&#010 By default the resize bar acts on the Canvas that it is declared on.  If you want the resize&#010 bar to instead act on the next member of the Layout (e.g. to collapse down or to the right),&#010 set {@link com.smartgwt.client.widgets.Canvas#getResizeBarTarget resizeBarTarget} as well.
    * When this Canvas is included as a member in a Layout, dynamically updates whether a &#010 resizeBar should be shown after this member in the layout, to allow it to be resized.&#010
    *
    * @param showResizeBar setting for this.showResizeBar. Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowResizeBar(Boolean showResizeBar)  throws IllegalStateException {
        setAttribute("showResizeBar", showResizeBar, false);
    }
    /**
     * When this Canvas is included as a member in a Layout, whether a resizeBar should be shown&#010 after this member in the layout, to allow it to be resized.&#010 <p>&#010 By default the resize bar acts on the Canvas that it is declared on.  If you want the resize&#010 bar to instead act on the next member of the Layout (e.g. to collapse down or to the right),&#010 set {@link com.smartgwt.client.widgets.Canvas#getResizeBarTarget resizeBarTarget} as well.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowResizeBar()  {
        return getAttributeAsBoolean("showResizeBar");
    }

    /**
    * When this Canvas is included as a member in a Layout, and {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} is set to&#010 <code>true</code> so that a resizeBar is created, <code>resizeBarTarget:"next"</code> can be&#010 set to indicate that the resizeBar should resize the next member of the layout rather than&#010 this one.  For resizeBars that support hiding their target member when clicked on, &#010 <code>resizeBarTarget:"next"</code> also means that the next member will be the one hidden.&#010 <P>&#010 This is typically used to create a 3-way split pane, where left and right-hand sections can&#010 be resized or hidden to allow a center section to expand.&#010 <P>&#010 <b>NOTE:</b> as with any Layout, to ensure all available space is used, one or more members&#010 must maintain a flexible size (eg 75%, or *).  In a two pane Layout with a normal resize&#010 bar, to fill all space after a user resizes, the member on the <b>right</b> should have&#010 flexible size.  With resizeBarTarget:"next", the member on the <b>left</b> should have&#010 flexible size.
    *
    * @param resizeBarTarget resizeBarTarget Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setResizeBarTarget(String resizeBarTarget)  throws IllegalStateException {
        setAttribute("resizeBarTarget", resizeBarTarget, false);
    }
    /**
     * When this Canvas is included as a member in a Layout, and {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} is set to&#010 <code>true</code> so that a resizeBar is created, <code>resizeBarTarget:"next"</code> can be&#010 set to indicate that the resizeBar should resize the next member of the layout rather than&#010 this one.  For resizeBars that support hiding their target member when clicked on, &#010 <code>resizeBarTarget:"next"</code> also means that the next member will be the one hidden.&#010 <P>&#010 This is typically used to create a 3-way split pane, where left and right-hand sections can&#010 be resized or hidden to allow a center section to expand.&#010 <P>&#010 <b>NOTE:</b> as with any Layout, to ensure all available space is used, one or more members&#010 must maintain a flexible size (eg 75%, or *).  In a two pane Layout with a normal resize&#010 bar, to fill all space after a user resizes, the member on the <b>right</b> should have&#010 flexible size.  With resizeBarTarget:"next", the member on the <b>left</b> should have&#010 flexible size.
     *
     *
     * @return String
     *
     */
    public String getResizeBarTarget()  {
        return getAttributeAsString("resizeBarTarget");
    }

    /**
    * When this Canvas is included as a member in a Layout, extra blank space that should be left&#010 after this member in a Layout.
    *
    * @param extraSpace extraSpace Default value is 0
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setExtraSpace(int extraSpace)  throws IllegalStateException {
        setAttribute("extraSpace", extraSpace, false);
    }
    /**
     * When this Canvas is included as a member in a Layout, extra blank space that should be left&#010 after this member in a Layout.
     *
     *
     * @return int
     *
     */
    public int getExtraSpace()  {
        return getAttributeAsInt("extraSpace");
    }
             
    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} is specified, this attribute specifies the position where &#010 the canvas should be inserted relative to the <code>htmlElement</code> in the DOM.
    * Setter for the {@link com.smartgwt.client.widgets.Canvas#getHtmlPosition htmlPosition}.&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param htmlPosition New htmlPosition for this canvas. Default value is "afterBegin"
    */
    public void setHtmlPosition(DrawPosition htmlPosition) {
        setAttribute("htmlPosition", htmlPosition.getValue(), true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} is specified, this attribute specifies the position where &#010 the canvas should be inserted relative to the <code>htmlElement</code> in the DOM.
     *
     *
     * @return DrawPosition
     *
     */
    public DrawPosition getHtmlPosition()  {
        return (DrawPosition) EnumUtil.getEnum(DrawPosition.values(), getAttribute("htmlPosition"));
    }

    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} is specified, should this canvas initially be drawn&#010 at the same dimensions as the htmlElement?<br>&#010 Note: setting this property will not force the canvas to resize if the element&#010 subsequently resizes (for example due to page reflow).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param matchElement matchElement Default value is null
    */
    public void setMatchElement(Boolean matchElement) {
        setAttribute("matchElement", matchElement, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} is specified, should this canvas initially be drawn&#010 at the same dimensions as the htmlElement?<br>&#010 Note: setting this property will not force the canvas to resize if the element&#010 subsequently resizes (for example due to page reflow).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getMatchElement()  {
        return getAttributeAsBoolean("matchElement");
    }
             
    /**
    * Absolute or relative, corresponding to the "absolute" (with respect to parent) or&#010 "relative" (with respect to document flow) values for the CSS position attribute. &#010 <P>&#010 Defaults to "absolute" unless {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} has been set, in which case&#010 "relative" is used.&#010 <P>&#010 For best consistency and flexibility across browsers, all SmartGWT layout managers&#010 use absolute positioning.  Relative positioning should be used only as a short-term&#010 integration scenario while incrementally upgrading existing applications.  &#010 <P>&#010 When relative positioning is used, only the outermost SmartGWT component should have&#010 position:"relative" set, none of it's children should.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param position position Default value is null
    */
    public void setPosition(Positioning position) {
        setAttribute("position", position.getValue(), true);
    }
    /**
     * Absolute or relative, corresponding to the "absolute" (with respect to parent) or&#010 "relative" (with respect to document flow) values for the CSS position attribute. &#010 <P>&#010 Defaults to "absolute" unless {@link com.smartgwt.client.widgets.Canvas#getHtmlElement htmlElement} has been set, in which case&#010 "relative" is used.&#010 <P>&#010 For best consistency and flexibility across browsers, all SmartGWT layout managers&#010 use absolute positioning.  Relative positioning should be used only as a short-term&#010 integration scenario while incrementally upgrading existing applications.  &#010 <P>&#010 When relative positioning is used, only the outermost SmartGWT component should have&#010 position:"relative" set, none of it's children should.
     *
     *
     * @return Positioning
     *
     */
    public Positioning getPosition()  {
        return (Positioning) EnumUtil.getEnum(Positioning.values(), getAttribute("position"));
    }

    /**
    * Number of pixels the left side of the widget is offset to the right from its default&#010 drawing context (either its parent's topleft corner, or the document flow, depending on&#010 the value of the {@link com.smartgwt.client.widgets.Canvas#getPosition position} property).
    * Set the left coordinate of this object, relative to its enclosing context, in pixels.&#010   NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()&#010          instead&#010
    *
    * @param left new left coordinate. Default value is 0
    */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }
    /**
     * Number of pixels the left side of the widget is offset to the right from its default&#010 drawing context (either its parent's topleft corner, or the document flow, depending on&#010 the value of the {@link com.smartgwt.client.widgets.Canvas#getPosition position} property).
     *
     *
     * @return Return the left coordinate of this object, relative to its enclosing context, in pixels.&#010
     *
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
    * Number of pixels the top of the widget is offset down from its default drawing context&#010 (either its parent's top-left corner, or the document flow, depending on the value of&#010 the {@link com.smartgwt.client.widgets.Canvas#getPosition position} property).
    * Set the top coordinate of this object, relative to its enclosing context, in pixels.&#010 <P>&#010 NOTE: if you're setting multiple coordinates, use setRect() or moveTo() instead&#010&#010
    *
    * @param top new top coordinate. Default value is 0
    */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }
    /**
     * Number of pixels the top of the widget is offset down from its default drawing context&#010 (either its parent's top-left corner, or the document flow, depending on the value of&#010 the {@link com.smartgwt.client.widgets.Canvas#getPosition position} property).
     *
     *
     * @return Return the top coordinate of this object, relative to its enclosing context, in pixels.&#010
     *
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
    * For custom components, establishes a default width for the component.&#010 <P>&#010 For a component that should potentially be sized automatically by a Layout, set this&#010 property rather than {@link com.smartgwt.client.widgets.Canvas#getWidth width} directly, because Layouts regard a width setting as&#010 an explicit size that shouldn't be changed.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param defaultWidth defaultWidth Default value is 100
    */
    public void setDefaultWidth(int defaultWidth) {
        setAttribute("defaultWidth", defaultWidth, true);
    }
    /**
     * For custom components, establishes a default width for the component.&#010 <P>&#010 For a component that should potentially be sized automatically by a Layout, set this&#010 property rather than {@link com.smartgwt.client.widgets.Canvas#getWidth width} directly, because Layouts regard a width setting as&#010 an explicit size that shouldn't be changed.
     *
     *
     * @return int
     *
     */
    public int getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }

    /**
    * For custom components, establishes a default height for the component.&#010 <P>&#010 For a component that should potentially be sized automatically by a Layout, set this&#010 property rather than {@link com.smartgwt.client.widgets.Canvas#getHeight height} directly, because Layouts regard a height setting as&#010 an explicit size that shouldn't be changed.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param defaultHeight defaultHeight Default value is 100
    */
    public void setDefaultHeight(int defaultHeight) {
        setAttribute("defaultHeight", defaultHeight, true);
    }
    /**
     * For custom components, establishes a default height for the component.&#010 <P>&#010 For a component that should potentially be sized automatically by a Layout, set this&#010 property rather than {@link com.smartgwt.client.widgets.Canvas#getHeight height} directly, because Layouts regard a height setting as&#010 an explicit size that shouldn't be changed.
     *
     *
     * @return int
     *
     */
    public int getDefaultHeight()  {
        return getAttributeAsInt("defaultHeight");
    }

    /**
    * Minimum width that this Canvas can be resized to.&#010 <P>&#010 Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's&#010 contents.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param minWidth minWidth Default value is 10
    */
    public void setMinWidth(int minWidth) {
        setAttribute("minWidth", minWidth, true);
    }
    /**
     * Minimum width that this Canvas can be resized to.&#010 <P>&#010 Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's&#010 contents.
     *
     *
     * @return int
     *
     */
    public int getMinWidth()  {
        return getAttributeAsInt("minWidth");
    }

    /**
    * Maximum width that this Canvas can be resized to.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param maxWidth maxWidth Default value is 10000
    */
    public void setMaxWidth(int maxWidth) {
        setAttribute("maxWidth", maxWidth, true);
    }
    /**
     * Maximum width that this Canvas can be resized to.
     *
     *
     * @return int
     *
     */
    public int getMaxWidth()  {
        return getAttributeAsInt("maxWidth");
    }

    /**
    * Minimum height that this Canvas can be resized to.&#010 <P>&#010 Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's&#010 contents.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param minHeight minHeight Default value is 10
    */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight, true);
    }
    /**
     * Minimum height that this Canvas can be resized to.&#010 <P>&#010 Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's&#010 contents.
     *
     *
     * @return int
     *
     */
    public int getMinHeight()  {
        return getAttributeAsInt("minHeight");
    }

    /**
    * Maximum height that this Canvas can be resized to.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param maxHeight maxHeight Default value is 10000
    */
    public void setMaxHeight(int maxHeight) {
        setAttribute("maxHeight", maxHeight, true);
    }
    /**
     * Maximum height that this Canvas can be resized to.
     *
     *
     * @return int
     *
     */
    public int getMaxHeight()  {
        return getAttributeAsInt("maxHeight");
    }

    /**
    * If set to true, the widget's parent (if any) will automatically be shown whenever the&#010      widget is shown.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param autoShowParent autoShowParent Default value is false
    */
    public void setAutoShowParent(Boolean autoShowParent) {
        setAttribute("autoShowParent", autoShowParent, true);
    }
    /**
     * If set to true, the widget's parent (if any) will automatically be shown whenever the&#010      widget is shown.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoShowParent()  {
        return getAttributeAsBoolean("autoShowParent");
    }
             
    /**
    * Controls widget visibility when the widget is initialized. See Visibility type for&#010      details.
    * Sets this widget's visibility to "inherit", so that it becomes visible if all it's parents&#010 are visible or it has no parents.&#010 <P>&#010 If the widget has not yet been drawn (and doesn't have a parent or master), this method&#010 calls the draw method as well.&#010&#010
    *
    * @param visibility visibility Default value is Canvas.INHERIT
    */
    public void setVisibility(Visibility visibility) {
        setAttribute("visibility", visibility.getValue(), true);
    }
    /**
     * Controls widget visibility when the widget is initialized. See Visibility type for&#010      details.
     *
     *
     * @return Returns true if the widget is visible, taking all parents into account, so that a widget&#010 which is not hidden might still report itself as not visible if it is within a hidden&#010 parent.&#010 <P>&#010 NOTE: Undrawn widgets will report themselves as visible if they would be visible if drawn.&#010&#010
     *
     */
    public Visibility getVisibility()  {
        return (Visibility) EnumUtil.getEnum(Visibility.values(), getAttribute("visibility"));
    }

    /**
    * Whether native drag selection of contained text is allowed within this Canvas.&#010 <P>&#010 Note that setting this property to <code>false</code> will not avoid text selection&#010 which is initiated outside this Canvas from continuing into this Canvas, even if text&#010 selection began in another Canvas.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canSelectText canSelectText Default value is false
    */
    public void setCanSelectText(Boolean canSelectText) {
        setAttribute("canSelectText", canSelectText, true);
    }
    /**
     * Whether native drag selection of contained text is allowed within this Canvas.&#010 <P>&#010 Note that setting this property to <code>false</code> will not avoid text selection&#010 which is initiated outside this Canvas from continuing into this Canvas, even if text&#010 selection began in another Canvas.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSelectText()  {
        return getAttributeAsBoolean("canSelectText");
    }

    /**
    * The CSS class applied to this widget as a whole.
    * Sets the CSS class for this widget&#010
    *
    * @param styleName new CSS class name (must be defined previously). Default value is "normal"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * The CSS class applied to this widget as a whole.
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * The contents of a canvas or label widget. Any HTML string is acceptable.
    * Changes the contents of a widget to newContents, an HTML string.&#010 <P>&#010 When {@link com.smartgwt.client.widgets.Canvas#getDynamicContents dynamicContents} is set, <code>setContents()</code> can&#010 also be called with no arguments to cause contents to be re-evaluated.&#010&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param contents an HTML string to be set as the contents of this widget. Default value is "&nbsp;"
    */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }
    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     *
     * @return Returns the contents of a Canvas. The contents are an HTML string.&#010
     *
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }

    /**
    * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010 You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw() in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010 Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                  "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evalution contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents - in other words the canvas instance on&#010 which the template is declared.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dynamicContents dynamicContents Default value is false
    */
    public void setDynamicContents(Boolean dynamicContents) {
        setAttribute("dynamicContents", dynamicContents, true);
    }
    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010 You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw() in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010 Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                  "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evalution contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents - in other words the canvas instance on&#010 which the template is declared.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDynamicContents()  {
        return getAttributeAsBoolean("dynamicContents");
    }

    /**
    * Set the CSS Margin, in pixels, for this component.  Margin provides blank space outside&#010 of the border.&#010 <P>&#010 This property sets the same thickness of margin on every side.  Differing per-side&#010 margins can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010 Note that the specified size of the widget will be the size <b>including</b> the margin&#010 thickness on each side.
    * Set the CSS Margin, in pixels, for this component.  Margin provides blank space outside of&#010 the border.&#010 <P>&#010 This property sets the same thickness of margin on every side.  Differing per-side&#010 margins can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010 Note that the specified size of the widget will be the size <b>including</b> the margin&#010 thickness on each side.&#010 &#010
    *
    * @param margin new margin in pixels. Default value is null
    */
    public void setMargin(Integer margin) {
        setAttribute("margin", margin, true);
    }
    /**
     * Set the CSS Margin, in pixels, for this component.  Margin provides blank space outside&#010 of the border.&#010 <P>&#010 This property sets the same thickness of margin on every side.  Differing per-side&#010 margins can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010 Note that the specified size of the widget will be the size <b>including</b> the margin&#010 thickness on each side.
     *
     *
     * @return Integer
     *
     */
    public Integer getMargin()  {
        return getAttributeAsInt("margin");
    }

    /**
    * Set the CSS padding of this component, in pixels.  Padding provides space between the&#010 border and the component's contents.&#010 <P>&#010 This property sets the same thickness of padding on every side.  Differing per-side&#010 padding can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010 Note that CSS padding does not affect the placement of {@link com.smartgwt.client.widgets.Canvas#getChildren children}.  To&#010 provide a blank area around children, either use {@link com.smartgwt.client.widgets.Canvas#getMargin margin} or use&#010 a {@link com.smartgwt.client.widgets.layout.Layout} as the parent instead, and use properties such as&#010 {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} to create blank space.
    * Set the CSS padding of this component, in pixels.  Padding provides space between the border&#010 and the component's contents.&#010 <P>&#010 This property sets the same thickness of padding on every side.  Differing per-side&#010 padding can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010
    *
    * @param padding new padding in pixels. Default value is null
    */
    public void setPadding(Integer padding) {
        setAttribute("padding", padding, true);
    }
    /**
     * Set the CSS padding of this component, in pixels.  Padding provides space between the&#010 border and the component's contents.&#010 <P>&#010 This property sets the same thickness of padding on every side.  Differing per-side&#010 padding can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010 <P>&#010 Note that CSS padding does not affect the placement of {@link com.smartgwt.client.widgets.Canvas#getChildren children}.  To&#010 provide a blank area around children, either use {@link com.smartgwt.client.widgets.Canvas#getMargin margin} or use&#010 a {@link com.smartgwt.client.widgets.layout.Layout} as the parent instead, and use properties such as&#010 {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} to create blank space.
     *
     *
     * @return Integer
     *
     */
    public Integer getPadding()  {
        return getAttributeAsInt("padding");
    }

    /**
    * Set the CSS border of this component, as a CSS string including border-width,&#010 border-style, and/or color (eg "2px solid blue").&#010 <P>&#010 This property applies the same border to all four sides of this component.  Different&#010 per-side borders can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.
    * Set the CSS border of this component, as a CSS string including border-width,&#010 border-style, and/or color (eg "2px solid blue").&#010 <P>&#010 This property applies the same border to all four sides of this component.  Different&#010 per-side borders can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.&#010&#010
    *
    * @param border new border to set to (eg: "2px solid black"). Default value is null
    */
    public void setBorder(String border) {
        setAttribute("border", border, true);
    }
    /**
     * Set the CSS border of this component, as a CSS string including border-width,&#010 border-style, and/or color (eg "2px solid blue").&#010 <P>&#010 This property applies the same border to all four sides of this component.  Different&#010 per-side borders can be set in a CSS style and applied via {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName}.
     *
     *
     * @return String
     *
     */
    public String getBorder()  {
        return getAttributeAsString("border");
    }

    /**
    * URL for a background image for this widget (corresponding to the CSS "background-image"&#010 attribute).
    * Sets the background to an image file given by newImage. This URL should be given as a&#010          string relative to the image directory for the page (./images by default).&#010
    *
    * @param backgroundImage new URL (local to Page image directory) for background image. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBackgroundImage(String backgroundImage)  throws IllegalStateException {
        setAttribute("backgroundImage", backgroundImage, false);
    }
    /**
     * URL for a background image for this widget (corresponding to the CSS "background-image"&#010 attribute).
     *
     *
     * @return String
     *
     */
    public String getBackgroundImage()  {
        return getAttributeAsString("backgroundImage");
    }
             
    /**
    * Specifies how the background image should be tiled if this widget&#010      is larger than the image. It corresponds to the CSS background-repeat attribute.&#010      See BkgndRepeat type for details.
    *
    * @param backgroundRepeat backgroundRepeat Default value is Canvas.REPEAT
    */
    public void setBackgroundRepeat(BkgndRepeat backgroundRepeat) {
        setAttribute("backgroundRepeat", backgroundRepeat.getValue(), true);
    }
    /**
     * Specifies how the background image should be tiled if this widget&#010      is larger than the image. It corresponds to the CSS background-repeat attribute.&#010      See BkgndRepeat type for details.
     *
     *
     * @return BkgndRepeat
     *
     */
    public BkgndRepeat getBackgroundRepeat()  {
        return (BkgndRepeat) EnumUtil.getEnum(BkgndRepeat.values(), getAttribute("backgroundRepeat"));
    }

    /**
    * Specifies how the background image should be positioned on the widget.&#010      It corresponds to the CSS background-position attribute. If unset,&#010      no background-position attribute is specified if a background image is&#010      specified.
    *
    * @param backgroundPosition backgroundPosition Default value is null
    */
    public void setBackgroundPosition(String backgroundPosition) {
        setAttribute("backgroundPosition", backgroundPosition, true);
    }
    /**
     * Specifies how the background image should be positioned on the widget.&#010      It corresponds to the CSS background-position attribute. If unset,&#010      no background-position attribute is specified if a background image is&#010      specified.
     *
     *
     * @return String
     *
     */
    public String getBackgroundPosition()  {
        return getAttributeAsString("backgroundPosition");
    }

    /**
    * Default directory for app-specific images, relative to the Page-wide&#010 {@link com.smartgwt.client.util.Page#getAppImgDir}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param appImgDir appImgDir Default value is ""
    */
    public void setAppImgDir(String appImgDir) {
        setAttribute("appImgDir", appImgDir, true);
    }
    /**
     * Default directory for app-specific images, relative to the Page-wide&#010 {@link com.smartgwt.client.util.Page#getAppImgDir}.
     *
     *
     * @return String
     *
     */
    public String getAppImgDir()  {
        return getAttributeAsString("appImgDir");
    }

    /**
    * Default directory for skin images (those defined by the class), relative to the&#010 Page-wide {@link com.smartgwt.client.util.Page#getSkinDir}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param skinImgDir skinImgDir Default value is "images/"
    */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }
    /**
     * Default directory for skin images (those defined by the class), relative to the&#010 Page-wide {@link com.smartgwt.client.util.Page#getSkinDir}.
     *
     *
     * @return String
     *
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
             
    /**
    * Specifies the cursor image to display when the mouse pointer is&#010      over this widget. It corresponds to the CSS cursor attribute. See Cursor type for&#010      different cursors.
    * Sets the cursor for this widget to cursor. See the cursor property&#010          for possible values.&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param cursor new cursor. Default value is Canvas.DEFAULT
    */
    public void setCursor(Cursor cursor) {
        setAttribute("cursor", cursor.getValue(), true);
    }
    /**
     * Specifies the cursor image to display when the mouse pointer is&#010      over this widget. It corresponds to the CSS cursor attribute. See Cursor type for&#010      different cursors.
     *
     *
     * @return Cursor
     *
     */
    public Cursor getCursor()  {
        return (Cursor) EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }
             
    /**
    * Specifies the cursor image to display when the mouse pointer is&#010      over this widget if this widget is disabled. It corresponds to the CSS cursor &#010      attribute. See Cursor type for different cursors.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param disabledCursor disabledCursor Default value is Canvas.DEFAULT
    */
    public void setDisabledCursor(Cursor disabledCursor) {
        setAttribute("disabledCursor", disabledCursor.getValue(), true);
    }
    /**
     * Specifies the cursor image to display when the mouse pointer is&#010      over this widget if this widget is disabled. It corresponds to the CSS cursor &#010      attribute. See Cursor type for different cursors.
     *
     *
     * @return Cursor
     *
     */
    public Cursor getDisabledCursor()  {
        return (Cursor) EnumUtil.getEnum(Cursor.values(), getAttribute("disabledCursor"));
    }

    /**
    * Renders the widget to be partly transparent. A widget's opacity property may&#010      be set to any number between 0 (transparent) to 100 (opaque).&#010  Null means don't specify opacity directly, 100 is fully opaque.&#010  Note that heavy use of opacity may slow down your browser.&#010  See canvas.setOpacity() for details.
    * Sets the opacity for the widget to the newOpacity value. This newOpacity&#010          value must be within the range of 0 (transparent) to 100 (opaque). <br>&#010          In Internet Explorer, any other filter effects will be wiped out. &#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param opacity new opacity level. Default value is null
    */
    public void setOpacity(Integer opacity) {
        setAttribute("opacity", opacity, true);
    }
    /**
     * Renders the widget to be partly transparent. A widget's opacity property may&#010      be set to any number between 0 (transparent) to 100 (opaque).&#010  Null means don't specify opacity directly, 100 is fully opaque.&#010  Note that heavy use of opacity may slow down your browser.&#010  See canvas.setOpacity() for details.
     *
     *
     * @return Integer
     *
     */
    public Integer getOpacity()  {
        return getAttributeAsInt("opacity");
    }
             
    /**
    * Controls what happens when the drawn size of the content of a Canvas is either&#010   greater or smaller than the specified size of the Canvas.  Similar to the CSS&#010   property overflow, but consistent across browsers.  See Overflow type for&#010   details.
    * Update the {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} of a Canvas after it has been created.&#010
    *
    * @param overflow New overflow value.. Default value is Canvas.VISIBLE
    */
    public void setOverflow(Overflow overflow) {
        setAttribute("overflow", overflow.getValue(), true);
    }
    /**
     * Controls what happens when the drawn size of the content of a Canvas is either&#010   greater or smaller than the specified size of the Canvas.  Similar to the CSS&#010   property overflow, but consistent across browsers.  See Overflow type for&#010   details.
     *
     *
     * @return Overflow
     *
     */
    public Overflow getOverflow()  {
        return (Overflow) EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
    * Whether to use the browser's native scrollbars or SmartGWT-based scrollbars.&#010 <P>&#010 SmartGWT-based scrollbars are skinnable, giving you complete control over look and&#010 feel.  SmartGWT-based scrollbars also enable some interactions not possible with&#010 native scrollbars, such as {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights}&#010 in grids in combination with {@link com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize dataPageSize}.&#010 <P>&#010 Native browser scrollbars are slightly faster simply because there are less SmartGWT&#010 components that need to be created, drawn and updated.  Each visible SmartGWT-based&#010 scrollbar on the screen has roughly the impact of two StretchImgButtons.&#010 <P>&#010 SmartGWT is always aware of the size of the scrollbar, regardless of whether native&#010 or custom scrollbars are used, and regardless of what operating system and/or operating&#010 system "theme" or "skin" is in use.  This means SmartGWT will correctly report the&#010 {@link com.smartgwt.client.widgets.Canvas#getViewportHeight}, that is, the interior area of the&#010 widget excluding space taken by scrollbars, which is key for exactly filling a component&#010 with content without creating unnecessary scrolling.&#010 <P>&#010 The <code>showCustomScrollbars</code> setting is typically overridden in load_skin.js in&#010 order to change the default for all SmartGWT components at once, like so:&#010 <pre>&#010     isc.Canvas.addProperties({ showCustomScrollbars:false });&#010 </pre>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomScrollbars showCustomScrollbars Default value is true
    */
    public void setShowCustomScrollbars(Boolean showCustomScrollbars) {
        setAttribute("showCustomScrollbars", showCustomScrollbars, true);
    }
    /**
     * Whether to use the browser's native scrollbars or SmartGWT-based scrollbars.&#010 <P>&#010 SmartGWT-based scrollbars are skinnable, giving you complete control over look and&#010 feel.  SmartGWT-based scrollbars also enable some interactions not possible with&#010 native scrollbars, such as {@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights}&#010 in grids in combination with {@link com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize dataPageSize}.&#010 <P>&#010 Native browser scrollbars are slightly faster simply because there are less SmartGWT&#010 components that need to be created, drawn and updated.  Each visible SmartGWT-based&#010 scrollbar on the screen has roughly the impact of two StretchImgButtons.&#010 <P>&#010 SmartGWT is always aware of the size of the scrollbar, regardless of whether native&#010 or custom scrollbars are used, and regardless of what operating system and/or operating&#010 system "theme" or "skin" is in use.  This means SmartGWT will correctly report the&#010 {@link com.smartgwt.client.widgets.Canvas#getViewportHeight}, that is, the interior area of the&#010 widget excluding space taken by scrollbars, which is key for exactly filling a component&#010 with content without creating unnecessary scrolling.&#010 <P>&#010 The <code>showCustomScrollbars</code> setting is typically overridden in load_skin.js in&#010 order to change the default for all SmartGWT components at once, like so:&#010 <pre>&#010     isc.Canvas.addProperties({ showCustomScrollbars:false });&#010 </pre>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomScrollbars()  {
        return getAttributeAsBoolean("showCustomScrollbars");
    }

    /**
    * How thick should we make the scrollbars for this canvas.<br>&#010   NOTE: has no effect if showCustomScrollbars is false.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param scrollbarSize scrollbarSize Default value is 16
    */
    public void setScrollbarSize(int scrollbarSize) {
        setAttribute("scrollbarSize", scrollbarSize, true);
    }
    /**
     * How thick should we make the scrollbars for this canvas.<br>&#010   NOTE: has no effect if showCustomScrollbars is false.
     *
     *
     * @return Returns the thickness of this widget's scrollbars.<br>&#010  For canvases showing custom scrollbars this is determined from <code>this.scrollbarSize</code>&#010&#010
     *
     */
    public int getScrollbarSize()  {
        return getAttributeAsInt("scrollbarSize");
    }

    /**
    * If set to true, the widget will be disabled. A widget is only considered enabled &#010      if it is individually enabled and all parents above it in the containment hierarchy &#010      are enabled. This allows you to enable or disable all components of a complex &#010      nested widget by enabling or disabling the top-level parent only.
    * set the disabled state of this object&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param disabled new disabled state of this object - pass <code>true</code> to disable the widget. Default value is false
    */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled, true);
    }
    /**
     * If set to true, the widget will be disabled. A widget is only considered enabled &#010      if it is individually enabled and all parents above it in the containment hierarchy &#010      are enabled. This allows you to enable or disable all components of a complex &#010      nested widget by enabling or disabling the top-level parent only.
     *
     *
     * @return Is this canvas disabled? Note that the disabled state is inherited - this method will return&#010 true if this widget, or any of its ancestors are marked disabled.&#010
     *
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
    }

    /**
    * Should this element be redrawn in response to a resize?&#010 <P>&#010 Should be set to true for components whose {@link com.smartgwt.client.widgets.Canvas#getInnerHTML} will not&#010 automatically reflow to fit the component's new size.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param redrawOnResize redrawOnResize Default value is true
    */
    public void setRedrawOnResize(Boolean redrawOnResize) {
        setAttribute("redrawOnResize", redrawOnResize, true);
    }
    /**
     * Should this element be redrawn in response to a resize?&#010 <P>&#010 Should be set to true for components whose {@link com.smartgwt.client.widgets.Canvas#getInnerHTML} will not&#010 automatically reflow to fit the component's new size.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRedrawOnResize()  {
        return getAttributeAsBoolean("redrawOnResize");
    }

    /**
    * Can this widget be allowed to become the target of keyboard events?&#010 <P>&#010 If canFocus is unset (the default), only scrollable widgets with visible scrollbars are&#010 focusable, to allow for keyboard scrolling.&#010 <P>&#010 A widget normally receives focus by being clicked on or tabbed to.
    * Change whether a widget can accept keyboard focus. &#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canFocus whether the widget should now accept focus. Default value is null
    */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus, true);
    }
    /**
     * Can this widget be allowed to become the target of keyboard events?&#010 <P>&#010 If canFocus is unset (the default), only scrollable widgets with visible scrollbars are&#010 focusable, to allow for keyboard scrolling.&#010 <P>&#010 A widget normally receives focus by being clicked on or tabbed to.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
    }

    /**
    * If specified this governs the tabIndex of the widget in the page's tab order.&#010 Note that by default SmartGWT auto-assigns tab-indices, ensuring focusable widgets&#010 are reachable by tabbing in the order in which they are drawn on the page.&#010 <code>canvas.tabIndex</code> cannot be set to greater than &#010 {@link com.smartgwt.client.widgets.Canvas#TAB_INDEX_FLOOR} - as we reserve the values above this range for&#010 auto-assigned tab-indices.
    * Assign an explicit tabIndex to this widget.&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param tabIndex New tabIndex for this widget. Must be less than                           {@link com.smartgwt.client.widgets.Canvas#TAB_INDEX_FLOOR} to avoid interfering with auto-assigned&#010                          tab indices on the page.. Default value is null
    */
    public void setTabIndex(Integer tabIndex) {
        setAttribute("tabIndex", tabIndex, true);
    }
    /**
     * If specified this governs the tabIndex of the widget in the page's tab order.&#010 Note that by default SmartGWT auto-assigns tab-indices, ensuring focusable widgets&#010 are reachable by tabbing in the order in which they are drawn on the page.&#010 <code>canvas.tabIndex</code> cannot be set to greater than &#010 {@link com.smartgwt.client.widgets.Canvas#TAB_INDEX_FLOOR} - as we reserve the values above this range for&#010 auto-assigned tab-indices.
     *
     *
     * @return Integer
     *
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }

    /**
    * If specified this governs the accessKey for the widget.&#010 This should be set to a character - when a user hits Alt+[accessKey], or in Mozilla&#010 Firefox 2.0 and above, Shift+Alt+[accessKey], focus will be given to the widget in&#010 question.
    * Set the accessKey for this canvas.&#010 <P>&#010 The accessKey can be set to any alphanumeric character (symbols not supported)&#010 Having set an accessKey, the canvas will be given focus when the user hits &#010 Alt+[accessKey], or in Mozilla Firefox 2.0 and above, Shift+Alt+[accessKey].&#010&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param accessKey Character to use as an accessKey for this widget.  Case Insensitive.. Default value is null
    */
    public void setAccessKey(String accessKey) {
        setAttribute("accessKey", accessKey, true);
    }
    /**
     * If specified this governs the accessKey for the widget.&#010 This should be set to a character - when a user hits Alt+[accessKey], or in Mozilla&#010 Firefox 2.0 and above, Shift+Alt+[accessKey], focus will be given to the widget in&#010 question.
     *
     *
     * @return String
     *
     */
    public String getAccessKey()  {
        return getAttributeAsString("accessKey");
    }
            
    /**
    * Context menu to show for this object, an instance of the Menu widget.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param contextMenu contextMenu Default value is null
    */
    public void setContextMenu(Menu contextMenu) {
        setAttribute("contextMenu", contextMenu.getOrCreateJsObj(), true);
    }
    /**
     * Context menu to show for this object, an instance of the Menu widget.
     *
     *
     * @return Menu
     *
     */
    public Menu getContextMenu()  {
            return Menu.getOrCreateRef(getAttributeAsJavaScriptObject("contextMenu"));
    }

    /**
    * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
    *
    * @param prompt prompt Default value is null
    */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt, true);
    }
    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     *
     * @return String
     *
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }

    /**
    * Indicates whether this widget can initiate custom drag-and-drop operations (other than&#010      reposition or resize). Normally canDragReposition or canDragResize would be used&#010      instead of this property.&#010      Note: this property may be manipulated by higher-level dragging semantics.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDrag canDrag Default value is false
    */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag, true);
    }
    /**
     * Indicates whether this widget can initiate custom drag-and-drop operations (other than&#010      reposition or resize). Normally canDragReposition or canDragResize would be used&#010      instead of this property.&#010      Note: this property may be manipulated by higher-level dragging semantics.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
    * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragStartDistance dragStartDistance Default value is 5
    */
    public void setDragStartDistance(int dragStartDistance) {
        setAttribute("dragStartDistance", dragStartDistance, true);
    }
    /**
     * Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *
     *
     * @return int
     *
     */
    public int getDragStartDistance()  {
        return getAttributeAsInt("dragStartDistance");
    }

    /**
    * If this Canvas is canAcceptDrop:true, when the user drags a droppable widget over&#010      an edge of the widget, should we scroll to show the rest of the widget's content?&#010      Returned from canvas.shouldDragScroll().
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDragScroll canDragScroll Default value is true
    */
    public void setCanDragScroll(Boolean canDragScroll) {
        setAttribute("canDragScroll", canDragScroll, true);
    }
    /**
     * If this Canvas is canAcceptDrop:true, when the user drags a droppable widget over&#010      an edge of the widget, should we scroll to show the rest of the widget's content?&#010      Returned from canvas.shouldDragScroll().
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragScroll()  {
        return getAttributeAsBoolean("canDragScroll");
    }

    /**
    * If this widget supports drag-scrolling, This property specifies how many ms the&#010      user must hover over the drag-scroll threshold before scrolling begins.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragScrollDelay dragScrollDelay Default value is 100
    */
    public void setDragScrollDelay(int dragScrollDelay) {
        setAttribute("dragScrollDelay", dragScrollDelay, true);
    }
    /**
     * If this widget supports drag-scrolling, This property specifies how many ms the&#010      user must hover over the drag-scroll threshold before scrolling begins.
     *
     *
     * @return int
     *
     */
    public int getDragScrollDelay()  {
        return getAttributeAsInt("dragScrollDelay");
    }
             
    /**
    * This indicates how the system will test for droppable targets: either by intersection&#010 with the mouse or intersection with the rectangle of the dragMoveTarget.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragIntersectStyle dragIntersectStyle Default value is "mouse"
    */
    public void setDragIntersectStyle(DragIntersectStyle dragIntersectStyle) {
        setAttribute("dragIntersectStyle", dragIntersectStyle.getValue(), true);
    }
    /**
     * This indicates how the system will test for droppable targets: either by intersection&#010 with the mouse or intersection with the rectangle of the dragMoveTarget.
     *
     *
     * @return DragIntersectStyle
     *
     */
    public DragIntersectStyle getDragIntersectStyle()  {
        return (DragIntersectStyle) EnumUtil.getEnum(DragIntersectStyle.values(), getAttribute("dragIntersectStyle"));
    }

    /**
    * Indicates whether this widget can be moved by a user of your application by simply&#010      dragging with the mouse.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDragReposition canDragReposition Default value is false
    */
    public void setCanDragReposition(Boolean canDragReposition) {
        setAttribute("canDragReposition", canDragReposition, true);
    }
    /**
     * Indicates whether this widget can be moved by a user of your application by simply&#010      dragging with the mouse.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragReposition()  {
        return getAttributeAsBoolean("canDragReposition");
    }
             
    /**
    * Cursor to switch to if the mouse is over a widget that is drag repositionable.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragRepositionCursor dragRepositionCursor Default value is Canvas.MOVE
    */
    public void setDragRepositionCursor(Cursor dragRepositionCursor) {
        setAttribute("dragRepositionCursor", dragRepositionCursor.getValue(), true);
    }
    /**
     * Cursor to switch to if the mouse is over a widget that is drag repositionable.
     *
     *
     * @return Cursor
     *
     */
    public Cursor getDragRepositionCursor()  {
        return (Cursor) EnumUtil.getEnum(Cursor.values(), getAttribute("dragRepositionCursor"));
    }

    /**
    * Indicates whether this widget can be resized by dragging on the edges and/or corners of&#010      the widget with the mouse.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDragResize canDragResize Default value is false
    */
    public void setCanDragResize(Boolean canDragResize) {
        setAttribute("canDragResize", canDragResize, true);
    }
    /**
     * Indicates whether this widget can be resized by dragging on the edges and/or corners of&#010      the widget with the mouse.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragResize()  {
        return getAttributeAsBoolean("canDragResize");
    }

    /**
    * Will this Canvas fire hover events when the user hovers over it, or one of its children?
    *
    * @param canHover canHover Default value is null
    */
    public void setCanHover(Boolean canHover) {
        setAttribute("canHover", canHover, true);
    }
    /**
     * Will this Canvas fire hover events when the user hovers over it, or one of its children?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }

    /**
    * If <code>this.canHover</code> is true, how long should the mouse be kept over this&#010 widget before the hover event is fired
    *
    * @param hoverDelay hoverDelay Default value is 300
    */
    public void setHoverDelay(int hoverDelay) {
        setAttribute("hoverDelay", hoverDelay, true);
    }
    /**
     * If <code>this.canHover</code> is true, how long should the mouse be kept over this&#010 widget before the hover event is fired
     *
     *
     * @return int
     *
     */
    public int getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
    }

    /**
    * If <code>this.canHover</code> is true, should we show the global hover canvas by default&#010 when the user hovers over this canvas?
    *
    * @param showHover showHover Default value is true
    */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover, true);
    }
    /**
     * If <code>this.canHover</code> is true, should we show the global hover canvas by default&#010 when the user hovers over this canvas?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true, this property can be used to customize the&#010 width of the hover canvas shown.
    *
    * @param hoverWidth hoverWidth Default value is null
    */
    public void setHoverWidth(Integer hoverWidth) {
        setAttribute("hoverWidth", hoverWidth, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true, this property can be used to customize the&#010 width of the hover canvas shown.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverWidth()  {
        return getAttributeAsInt("hoverWidth");
    }

    /**
    * If <code>this.showHover</code> is true, this property can be used to customize the&#010 height of the hover canvas shown.
    *
    * @param hoverHeight hoverHeight Default value is null
    */
    public void setHoverHeight(Integer hoverHeight) {
        setAttribute("hoverHeight", hoverHeight, true);
    }
    /**
     * If <code>this.showHover</code> is true, this property can be used to customize the&#010 height of the hover canvas shown.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverHeight()  {
        return getAttributeAsInt("hoverHeight");
    }
             
    /**
    * If <code>this.showHover</code> is true, this property can be used to customize the&#010 alignment of content in the hover canvas.
    *
    * @param hoverAlign hoverAlign Default value is null
    */
    public void setHoverAlign(Alignment hoverAlign) {
        setAttribute("hoverAlign", hoverAlign.getValue(), true);
    }
    /**
     * If <code>this.showHover</code> is true, this property can be used to customize the&#010 alignment of content in the hover canvas.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getHoverAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("hoverAlign"));
    }
             
    /**
    * If <code>this.showHover</code> is true, this property can be used to customize the&#010 vertical alignment of content in the hover canvas.
    *
    * @param hoverVAlign hoverVAlign Default value is null
    */
    public void setHoverVAlign(VerticalAlignment hoverVAlign) {
        setAttribute("hoverVAlign", hoverVAlign.getValue(), true);
    }
    /**
     * If <code>this.showHover</code> is true, this property can be used to customize the&#010 vertical alignment of content in the hover canvas.
     *
     *
     * @return VerticalAlignment
     *
     */
    public VerticalAlignment getHoverVAlign()  {
        return (VerticalAlignment) EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("hoverVAlign"));
    }

    /**
    * If <code>this.showHover</code> is true, this property can be used to customize the&#010 whether content in the hover canvas is displayed in a single line, or wraps.
    *
    * @param hoverWrap hoverWrap Default value is null
    */
    public void setHoverWrap(Boolean hoverWrap) {
        setAttribute("hoverWrap", hoverWrap, true);
    }
    /**
     * If <code>this.showHover</code> is true, this property can be used to customize the&#010 whether content in the hover canvas is displayed in a single line, or wraps.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getHoverWrap()  {
        return getAttributeAsBoolean("hoverWrap");
    }

    /**
    * If <code>this.showHover</code> is true, this property can be used to specify the&#010 css style to apply to the hover canvas.
    *
    * @param hoverStyle hoverStyle Default value is null
    */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle, true);
    }
    /**
     * If <code>this.showHover</code> is true, this property can be used to specify the&#010 css style to apply to the hover canvas.
     *
     *
     * @return String
     *
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }

    /**
    * If <code>this.showHover</code> is true, should the hover canvas be shown with opacity&#010 other than 100?
    *
    * @param hoverOpacity hoverOpacity Default value is null
    */
    public void setHoverOpacity(Integer hoverOpacity) {
        setAttribute("hoverOpacity", hoverOpacity, true);
    }
    /**
     * If <code>this.showHover</code> is true, should the hover canvas be shown with opacity&#010 other than 100?
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverOpacity()  {
        return getAttributeAsInt("hoverOpacity");
    }

    /**
    * If <code>this.showHover</code> is true, should this widget's hover canvas be moved with&#010 the mouse while visible?
    *
    * @param hoverMoveWithMouse hoverMoveWithMouse Default value is null
    */
    public void setHoverMoveWithMouse(Boolean hoverMoveWithMouse) {
        setAttribute("hoverMoveWithMouse", hoverMoveWithMouse, true);
    }
    /**
     * If <code>this.showHover</code> is true, should this widget's hover canvas be moved with&#010 the mouse while visible?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getHoverMoveWithMouse()  {
        return getAttributeAsBoolean("hoverMoveWithMouse");
    }
             
    /**
    * Visual appearance to show when the object is being dragged.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragAppearance dragAppearance Default value is EventHandler.OUTLINE
    */
    public void setDragAppearance(DragAppearance dragAppearance) {
        setAttribute("dragAppearance", dragAppearance.getValue(), true);
    }
    /**
     * Visual appearance to show when the object is being dragged.
     *
     *
     * @return DragAppearance
     *
     */
    public DragAppearance getDragAppearance()  {
        return (DragAppearance) EnumUtil.getEnum(DragAppearance.values(), getAttribute("dragAppearance"));
    }

    /**
    * The "type" of thing given as a string that can be dragged from this widget. If&#010      specified, this will be matched up with the dropTypes of droppable widgets as detailed&#010      in the dropTypes property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragType dragType Default value is null
    */
    public void setDragType(String dragType) {
        setAttribute("dragType", dragType, true);
    }
    /**
     * The "type" of thing given as a string that can be dragged from this widget. If&#010      specified, this will be matched up with the dropTypes of droppable widgets as detailed&#010      in the dropTypes property.
     *
     *
     * @return String
     *
     */
    public String getDragType()  {
        return getAttributeAsString("dragType");
    }

    /**
    * When this widget is dragged, if its dragAppearance is <code>"target"</code>, should&#010 we show a shadow behind the canvas during the drag.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showDragShadow showDragShadow Default value is null
    */
    public void setShowDragShadow(Boolean showDragShadow) {
        setAttribute("showDragShadow", showDragShadow, true);
    }
    /**
     * When this widget is dragged, if its dragAppearance is <code>"target"</code>, should&#010 we show a shadow behind the canvas during the drag.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDragShadow()  {
        return getAttributeAsBoolean("showDragShadow");
    }

    /**
    * If this widget has dragAppearance <code>"target"</code>, this value specifies the&#010 opacity to render the target while it is being dragged. A null value implies we do&#010 not modify the opacity.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragOpacity dragOpacity Default value is null
    */
    public void setDragOpacity(Integer dragOpacity) {
        setAttribute("dragOpacity", dragOpacity, true);
    }
    /**
     * If this widget has dragAppearance <code>"target"</code>, this value specifies the&#010 opacity to render the target while it is being dragged. A null value implies we do&#010 not modify the opacity.
     *
     *
     * @return Integer
     *
     */
    public Integer getDragOpacity()  {
        return getAttributeAsInt("dragOpacity");
    }

    /**
    * Indicates that this object can be dropped on top of other widgets. Only valid if &#010      canDrag or canDragReposition is true.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDrop canDrop Default value is false
    */
    public void setCanDrop(Boolean canDrop) {
        setAttribute("canDrop", canDrop, true);
    }
    /**
     * Indicates that this object can be dropped on top of other widgets. Only valid if &#010      canDrag or canDragReposition is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDrop()  {
        return getAttributeAsBoolean("canDrop");
    }

    /**
    * Indicates that this object can receive dropped widgets (i.e. other widgets can be&#010      dropped on top of it).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canAcceptDrop canAcceptDrop Default value is false
    */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop, true);
    }
    /**
     * Indicates that this object can receive dropped widgets (i.e. other widgets can be&#010      dropped on top of it).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    /**
    * When explicitly set to false, disallows drop before this member in the Layout.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDropBefore canDropBefore Default value is null
    */
    public void setCanDropBefore(Boolean canDropBefore) {
        setAttribute("canDropBefore", canDropBefore, true);
    }
    /**
     * When explicitly set to false, disallows drop before this member in the Layout.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDropBefore()  {
        return getAttributeAsBoolean("canDropBefore");
    }

    /**
    * Amount of time (in msec) before mouseStillDown events start to be fired for this object.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param mouseStillDownInitialDelay mouseStillDownInitialDelay Default value is 400
    */
    public void setMouseStillDownInitialDelay(int mouseStillDownInitialDelay) {
        setAttribute("mouseStillDownInitialDelay", mouseStillDownInitialDelay, true);
    }
    /**
     * Amount of time (in msec) before mouseStillDown events start to be fired for this object.
     *
     *
     * @return int
     *
     */
    public int getMouseStillDownInitialDelay()  {
        return getAttributeAsInt("mouseStillDownInitialDelay");
    }

    /**
    * Amount of time (in msec) between 'mouseStillDown' events for this object
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param mouseStillDownDelay mouseStillDownDelay Default value is 100
    */
    public void setMouseStillDownDelay(int mouseStillDownDelay) {
        setAttribute("mouseStillDownDelay", mouseStillDownDelay, true);
    }
    /**
     * Amount of time (in msec) between 'mouseStillDown' events for this object
     *
     *
     * @return int
     *
     */
    public int getMouseStillDownDelay()  {
        return getAttributeAsInt("mouseStillDownDelay");
    }

    /**
    * Amount of time (in msec) between which two clicks are considered a single click
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param doubleClickDelay doubleClickDelay Default value is 250
    */
    public void setDoubleClickDelay(int doubleClickDelay) {
        setAttribute("doubleClickDelay", doubleClickDelay, true);
    }
    /**
     * Amount of time (in msec) between which two clicks are considered a single click
     *
     *
     * @return int
     *
     */
    public int getDoubleClickDelay()  {
        return getAttributeAsInt("doubleClickDelay");
    }

    /**
    * If true, this canvas will recieve all mouse-clicks as single click events rather than&#010 doubleClicks.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param noDoubleClicks noDoubleClicks Default value is null
    */
    public void setNoDoubleClicks(Boolean noDoubleClicks) {
        setAttribute("noDoubleClicks", noDoubleClicks, true);
    }
    /**
     * If true, this canvas will recieve all mouse-clicks as single click events rather than&#010 doubleClicks.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getNoDoubleClicks()  {
        return getAttributeAsBoolean("noDoubleClicks");
    }
             
    /**
    * Governs the model to be used when sizing canvases with percentage width or height, or &#010 positioning widgets with a specified {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo}.&#010 <P>&#010 Only affects widgets with a a specified {@link com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, or &#010 widgets that have {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} set and are peers of some &#010 {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement}.&#010 <P>&#010 Determines whether the coordinates used for sizing (for percentage sized widgets) and&#010 positioning (if <code>snapTo</code> is set) should be relative to the visible size or the&#010 viewport size of the percentSource or masterElement widget.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param percentBox percentBox Default value is "visible"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setPercentBox(PercentBoxModel percentBox)  throws IllegalStateException {
        setAttribute("percentBox", percentBox.getValue(), false);
    }
    /**
     * Governs the model to be used when sizing canvases with percentage width or height, or &#010 positioning widgets with a specified {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo}.&#010 <P>&#010 Only affects widgets with a a specified {@link com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, or &#010 widgets that have {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} set and are peers of some &#010 {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement}.&#010 <P>&#010 Determines whether the coordinates used for sizing (for percentage sized widgets) and&#010 positioning (if <code>snapTo</code> is set) should be relative to the visible size or the&#010 viewport size of the percentSource or masterElement widget.
     *
     *
     * @return PercentBoxModel
     *
     */
    public PercentBoxModel getPercentBox()  {
        return (PercentBoxModel) EnumUtil.getEnum(PercentBoxModel.values(), getAttribute("percentBox"));
    }

    /**
    * Position this widget such that it is aligned with ("snapped to") an edge of its &#010 {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement} (if specified), or its&#010 {@link com.smartgwt.client.widgets.Canvas#getParentElement parentElement}.&#010 <P>&#010 Note that this property also impacts the sizing of this widget. If this widgets size&#010 is specifed as a percent value, and has no explicit&#010 {@link com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, sizing will be calculated based on the size of the &#010 masterElement when snapTo is set.&#010 <P>&#010 Possible values: BR, BL, TR, TL, R, L, B, T, C where B=Bottom, T=Top, L=Left, R=right&#010 and C=center
    * Set the snapTo property of this canvas, and handle repositioning.&#010&#010
    *
    * @param snapTo new snapTo value. Default value is null
    */
    public void setSnapTo(String snapTo) {
        setAttribute("snapTo", snapTo, true);
    }
    /**
     * Position this widget such that it is aligned with ("snapped to") an edge of its &#010 {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement} (if specified), or its&#010 {@link com.smartgwt.client.widgets.Canvas#getParentElement parentElement}.&#010 <P>&#010 Note that this property also impacts the sizing of this widget. If this widgets size&#010 is specifed as a percent value, and has no explicit&#010 {@link com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, sizing will be calculated based on the size of the &#010 masterElement when snapTo is set.&#010 <P>&#010 Possible values: BR, BL, TR, TL, R, L, B, T, C where B=Bottom, T=Top, L=Left, R=right&#010 and C=center
     *
     *
     * @return Return the snapTo value of this object&#010&#010
     *
     */
    public String getSnapTo()  {
        return getAttributeAsString("snapTo");
    }

    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined to this widget, this property can be used to&#010 define which edge of this widget should be snapped to an edge of the master or parent &#010 element.&#010 <P>&#010 If unspecified the, default snapTo behavior is set up to align the "snapTo" edge of this &#010 widget with the snapTo edge of the master or parent.
    * Set the snapEdge property of this canvas, and handle repositioning.&#010&#010
    *
    * @param snapEdge new snapEdge value. Default value is null
    */
    public void setSnapEdge(String snapEdge) {
        setAttribute("snapEdge", snapEdge, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined to this widget, this property can be used to&#010 define which edge of this widget should be snapped to an edge of the master or parent &#010 element.&#010 <P>&#010 If unspecified the, default snapTo behavior is set up to align the "snapTo" edge of this &#010 widget with the snapTo edge of the master or parent.
     *
     *
     * @return Return the snapEdge value of this object&#010&#010
     *
     */
    public String getSnapEdge()  {
        return getAttributeAsString("snapEdge");
    }

    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined for this widget, this property can be used to&#010 specify an offset in px or percentage for the left coordinate of this widget.&#010 <P>&#010 For example if <code>snapTo</code> is specifed as <code>"L"</code> and &#010 <code>snapOffsetLeft</code> is set to 6, this widget will be rendered 6px inside the left&#010 edge of its parent or master element.
    *
    * @param snapOffsetLeft snapOffsetLeft Default value is null
    */
    public void setSnapOffsetLeft(Integer snapOffsetLeft) {
        setAttribute("snapOffsetLeft", snapOffsetLeft, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined for this widget, this property can be used to&#010 specify an offset in px or percentage for the left coordinate of this widget.&#010 <P>&#010 For example if <code>snapTo</code> is specifed as <code>"L"</code> and &#010 <code>snapOffsetLeft</code> is set to 6, this widget will be rendered 6px inside the left&#010 edge of its parent or master element.
     *
     *
     * @return Integer
     *
     */
    public Integer getSnapOffsetLeft()  {
        return getAttributeAsInt("snapOffsetLeft");
    }

    /**
    * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined for this widget, this property can be used to&#010 specify an offset in px or percentage for the top coordinate of this widget.&#010 <P>&#010 For example if <code>snapTo</code> is specifed as <code>"T"</code> and &#010 <code>snapOffsetTop</code> is set to 6, this widget will be rendered 6px below the top&#010 edge of its parent or master element.
    *
    * @param snapOffsetTop snapOffsetTop Default value is null
    */
    public void setSnapOffsetTop(Integer snapOffsetTop) {
        setAttribute("snapOffsetTop", snapOffsetTop, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is defined for this widget, this property can be used to&#010 specify an offset in px or percentage for the top coordinate of this widget.&#010 <P>&#010 For example if <code>snapTo</code> is specifed as <code>"T"</code> and &#010 <code>snapOffsetTop</code> is set to 6, this widget will be rendered 6px below the top&#010 edge of its parent or master element.
     *
     *
     * @return Integer
     *
     */
    public Integer getSnapOffsetTop()  {
        return getAttributeAsInt("snapOffsetTop");
    }

    /**
    * Causes this canvas to snap to its parent's grid when dragging.
    *
    * @param snapToGrid snapToGrid Default value is null
    */
    public void setSnapToGrid(Boolean snapToGrid) {
        setAttribute("snapToGrid", snapToGrid, true);
    }
    /**
     * Causes this canvas to snap to its parent's grid when dragging.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSnapToGrid()  {
        return getAttributeAsBoolean("snapToGrid");
    }

    /**
    * Causes this canvas to snap to its parent's grid when resizing.&#010 Note that this value defaults to the Canvas's &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} value if undefined.
    *
    * @param snapResizeToGrid snapResizeToGrid Default value is null
    */
    public void setSnapResizeToGrid(Boolean snapResizeToGrid) {
        setAttribute("snapResizeToGrid", snapResizeToGrid, true);
    }
    /**
     * Causes this canvas to snap to its parent's grid when resizing.&#010 Note that this value defaults to the Canvas's &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} value if undefined.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSnapResizeToGrid()  {
        return getAttributeAsBoolean("snapResizeToGrid");
    }

    /**
    * If true, causes this canvas's children to snap to its grid when dragging.&#010 This behavior can be overridden on a per-child basis by setting the &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} value on the child.
    *
    * @param childrenSnapToGrid childrenSnapToGrid Default value is null
    */
    public void setChildrenSnapToGrid(Boolean childrenSnapToGrid) {
        setAttribute("childrenSnapToGrid", childrenSnapToGrid, true);
    }
    /**
     * If true, causes this canvas's children to snap to its grid when dragging.&#010 This behavior can be overridden on a per-child basis by setting the &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} value on the child.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getChildrenSnapToGrid()  {
        return getAttributeAsBoolean("childrenSnapToGrid");
    }

    /**
    * If true, causes this canvas's children to snap to its grid when resizing.&#010 This behavior can be overridden on a per-child basis by setting the &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} or &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapResizeToGrid snapResizeToGrid} value on the child.
    *
    * @param childrenSnapResizeToGrid childrenSnapResizeToGrid Default value is null
    */
    public void setChildrenSnapResizeToGrid(Boolean childrenSnapResizeToGrid) {
        setAttribute("childrenSnapResizeToGrid", childrenSnapResizeToGrid, true);
    }
    /**
     * If true, causes this canvas's children to snap to its grid when resizing.&#010 This behavior can be overridden on a per-child basis by setting the &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapToGrid snapToGrid} or &#010 {@link com.smartgwt.client.widgets.Canvas#getSnapResizeToGrid snapResizeToGrid} value on the child.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getChildrenSnapResizeToGrid()  {
        return getAttributeAsBoolean("childrenSnapResizeToGrid");
    }

    /**
    * The horizontal grid size to use, in pixels, when snap-to-grid is enabled.
    *
    * @param snapHGap snapHGap Default value is 20
    */
    public void setSnapHGap(int snapHGap) {
        setAttribute("snapHGap", snapHGap, true);
    }
    /**
     * The horizontal grid size to use, in pixels, when snap-to-grid is enabled.
     *
     *
     * @return int
     *
     */
    public int getSnapHGap()  {
        return getAttributeAsInt("snapHGap");
    }

    /**
    * The vertical grid size to use, in pixels, when snap-to-grid is enabled.
    *
    * @param snapVGap snapVGap Default value is 20
    */
    public void setSnapVGap(int snapVGap) {
        setAttribute("snapVGap", snapVGap, true);
    }
    /**
     * The vertical grid size to use, in pixels, when snap-to-grid is enabled.
     *
     *
     * @return int
     *
     */
    public int getSnapVGap()  {
        return getAttributeAsInt("snapVGap");
    }

    /**
    * The horizontal snap direction.&#010 Set this value to Canvas.BEFORE to snap to the nearest gridpoint to the left;&#010 set it to Canvas.AFTER to snap to the nearest gridpoint to the right; and set&#010 it to Canvas.NEAREST to snap to the nearest gridpoint in either direction.
    *
    * @param snapHDirection snapHDirection Default value is Canvas.AFTER
    */
    public void setSnapHDirection(String snapHDirection) {
        setAttribute("snapHDirection", snapHDirection, true);
    }
    /**
     * The horizontal snap direction.&#010 Set this value to Canvas.BEFORE to snap to the nearest gridpoint to the left;&#010 set it to Canvas.AFTER to snap to the nearest gridpoint to the right; and set&#010 it to Canvas.NEAREST to snap to the nearest gridpoint in either direction.
     *
     *
     * @return String
     *
     */
    public String getSnapHDirection()  {
        return getAttributeAsString("snapHDirection");
    }

    /**
    * The vertical snap direction.&#010 Set this value to Canvas.BEFORE to snap to the nearest gridpoint above;&#010 set it to Canvas.AFTER to snap to the nearest gridpoint below; and set&#010 it to Canvas.NEAREST to snap to the nearest gridpoint in either direction.
    *
    * @param snapVDirection snapVDirection Default value is Canvas.AFTER
    */
    public void setSnapVDirection(String snapVDirection) {
        setAttribute("snapVDirection", snapVDirection, true);
    }
    /**
     * The vertical snap direction.&#010 Set this value to Canvas.BEFORE to snap to the nearest gridpoint above;&#010 set it to Canvas.AFTER to snap to the nearest gridpoint below; and set&#010 it to Canvas.NEAREST to snap to the nearest gridpoint in either direction.
     *
     *
     * @return String
     *
     */
    public String getSnapVDirection()  {
        return getAttributeAsString("snapVDirection");
    }

    /**
    * Describes which axes to apply snap-to-grid to.&#010 Valid values are Canvas.HORIZONTAL, Canvas.VERTICAL and Canvas.BOTH
    *
    * @param snapAxis snapAxis Default value is Canvas.BOTH
    */
    public void setSnapAxis(String snapAxis) {
        setAttribute("snapAxis", snapAxis, true);
    }
    /**
     * Describes which axes to apply snap-to-grid to.&#010 Valid values are Canvas.HORIZONTAL, Canvas.VERTICAL and Canvas.BOTH
     *
     *
     * @return String
     *
     */
    public String getSnapAxis()  {
        return getAttributeAsString("snapAxis");
    }

    /**
    * When this canvas is dropped onto an object supporting snap-to-grid, should it snap&#010 to the grid (true, the default) or just drop wherever the mouse is (false).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param snapOnDrop snapOnDrop Default value is true
    */
    public void setSnapOnDrop(Boolean snapOnDrop) {
        setAttribute("snapOnDrop", snapOnDrop, true);
    }
    /**
     * When this canvas is dropped onto an object supporting snap-to-grid, should it snap&#010 to the grid (true, the default) or just drop wherever the mouse is (false).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSnapOnDrop()  {
        return getAttributeAsBoolean("snapOnDrop");
    }

    /**
     * If this property is set to <code>true</code>, the {@link com.smartgwt.client.widgets.Canvas#destroy} method&#010 has been called on this canvas. This implies the canvas is no longer valid. Its ID has been&#010 removed from global scope, and calling standard canvas APIs on it is likely to result in &#010 errors.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getDestroyed() throws IllegalStateException {
        errorIfNotCreated("destroyed");
        return getAttributeAsBoolean("destroyed");
    }

    /**
     * This property is set to true when the {@link com.smartgwt.client.widgets.Canvas#destroy} method is called on a widget.&#010 If this property is true, but {@link com.smartgwt.client.widgets.Canvas#getDestroyed destroyed} is not, this indicates the canvas is&#010 in the process of being destroyed.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getDestroying() throws IllegalStateException {
        errorIfNotCreated("destroying");
        return getAttributeAsBoolean("destroying");
    }

    /**
    * Whether an {@link com.smartgwt.client.widgets.EdgedCanvas} should be used to show image-based edges around this&#010 component.
    *
    * @param showEdges showEdges Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowEdges(Boolean showEdges)  throws IllegalStateException {
        setAttribute("showEdges", showEdges, false);
    }
    /**
     * Whether an {@link com.smartgwt.client.widgets.EdgedCanvas} should be used to show image-based edges around this&#010 component.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEdges()  {
        return getAttributeAsBoolean("showEdges");
    }

    /**
    * Size in pixels for corners and edges
    *
    * @param edgeSize edgeSize Default value is 10
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeSize(int edgeSize)  throws IllegalStateException {
        setAttribute("edgeSize", edgeSize, false);
    }
    /**
     * Size in pixels for corners and edges
     *
     *
     * @return int
     *
     */
    public int getEdgeSize()  {
        return getAttributeAsInt("edgeSize");
    }

    /**
    * Amount the contained Canvas should be offset.  Defaults to edgeSize; set to less than&#010 edgeSize to allow the contained Canvas to overlap the edge and corner media.
    *
    * @param edgeOffset edgeOffset Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeOffset(Integer edgeOffset)  throws IllegalStateException {
        setAttribute("edgeOffset", edgeOffset, false);
    }
    /**
     * Amount the contained Canvas should be offset.  Defaults to edgeSize; set to less than&#010 edgeSize to allow the contained Canvas to overlap the edge and corner media.
     *
     *
     * @return Integer
     *
     */
    public Integer getEdgeOffset()  {
        return getAttributeAsInt("edgeOffset");
    }

    /**
    * Base name of images for edges.  Extensions for each corner or edge piece will be added&#010 to this image URL, before the extension.  For example, with the default base name of&#010 "edge.gif", the top-left corner image will be "edge_TL.gif".&#010 <P>&#010 The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R",&#010 "_center".
    *
    * @param edgeImage edgeImage Default value is "[SKIN]edge.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeImage(String edgeImage)  throws IllegalStateException {
        setAttribute("edgeImage", edgeImage, false);
    }
    /**
     * Base name of images for edges.  Extensions for each corner or edge piece will be added&#010 to this image URL, before the extension.  For example, with the default base name of&#010 "edge.gif", the top-left corner image will be "edge_TL.gif".&#010 <P>&#010 The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R",&#010 "_center".
     *
     *
     * @return String
     *
     */
    public String getEdgeImage()  {
        return getAttributeAsString("edgeImage");
    }

    /**
    * Background color for the EdgedCanvas created to decorate this component.  This can be used&#010 to provide an underlying "tint" color for translucent edge media
    *
    * @param edgeBackgroundColor edgeBackgroundColor Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeBackgroundColor(String edgeBackgroundColor)  throws IllegalStateException {
        setAttribute("edgeBackgroundColor", edgeBackgroundColor, false);
    }
    /**
     * Background color for the EdgedCanvas created to decorate this component.  This can be used&#010 to provide an underlying "tint" color for translucent edge media
     *
     *
     * @return String
     *
     */
    public String getEdgeBackgroundColor()  {
        return getAttributeAsString("edgeBackgroundColor");
    }

    /**
    * Opacity of the edges.  Defaults to matching this.opacity.&#010 if {@link com.smartgwt.client.widgets.Canvas#setOpacity} is called on a Canvas where edgeOpacity is set,&#010 edgeOpacity will be considered a percentage of the parent's opacity (so 50% opaque parent plus&#010 edgeOpacity 50 means 25% opaque edges)
    * Set the {@link com.smartgwt.client.widgets.Canvas#getEdgeOpacity edgeOpacity} and mark the canvas for redraw&#010
    *
    * @param edgeOpacity new edge-opacity level. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeOpacity(Integer edgeOpacity)  throws IllegalStateException {
        setAttribute("edgeOpacity", edgeOpacity, false);
    }
    /**
     * Opacity of the edges.  Defaults to matching this.opacity.&#010 if {@link com.smartgwt.client.widgets.Canvas#setOpacity} is called on a Canvas where edgeOpacity is set,&#010 edgeOpacity will be considered a percentage of the parent's opacity (so 50% opaque parent plus&#010 edgeOpacity 50 means 25% opaque edges)
     *
     *
     * @return Integer
     *
     */
    public Integer getEdgeOpacity()  {
        return getAttributeAsInt("edgeOpacity");
    }

    /**
    * Whether to show media in the center section, that is, behind the decorated Canvas.
    *
    * @param edgeShowCenter edgeShowCenter Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeShowCenter(Boolean edgeShowCenter)  throws IllegalStateException {
        setAttribute("edgeShowCenter", edgeShowCenter, false);
    }
    /**
     * Whether to show media in the center section, that is, behind the decorated Canvas.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEdgeShowCenter()  {
        return getAttributeAsBoolean("edgeShowCenter");
    }

    /**
    * Background color for the center section only.  Can be used as a surrogate background&#010 color for the decorated Canvas, if the Canvas is set to partially overlap the edges and&#010 hence can't show a background color itself without occluding media.
    *
    * @param edgeCenterBackgroundColor edgeCenterBackgroundColor Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEdgeCenterBackgroundColor(String edgeCenterBackgroundColor)  throws IllegalStateException {
        setAttribute("edgeCenterBackgroundColor", edgeCenterBackgroundColor, false);
    }
    /**
     * Background color for the center section only.  Can be used as a surrogate background&#010 color for the decorated Canvas, if the Canvas is set to partially overlap the edges and&#010 hence can't show a background color itself without occluding media.
     *
     *
     * @return String
     *
     */
    public String getEdgeCenterBackgroundColor()  {
        return getAttributeAsString("edgeCenterBackgroundColor");
    }

    /**
    * Whether to show a drop shadow for this Canvas
    * Method to update {@link com.smartgwt.client.widgets.Canvas#getShowShadow showShadow}.&#010
    *
    * @param showShadow true if the shadow should be visible false if not. Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowShadow(Boolean showShadow)  throws IllegalStateException {
        setAttribute("showShadow", showShadow, false);
    }
    /**
     * Whether to show a drop shadow for this Canvas
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowShadow()  {
        return getAttributeAsBoolean("showShadow");
    }

    /**
    * Depth of the shadow, or the virtual height above the page of the widget throwing the shadow.&#010 <P>&#010 This is a single parameter that can be used to control both <code>shadowSoftness</code> and&#010 <code>shadowOffset</code>.
    *
    * @param shadowDepth shadowDepth Default value is 4
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShadowDepth(int shadowDepth)  throws IllegalStateException {
        setAttribute("shadowDepth", shadowDepth, false);
    }
    /**
     * Depth of the shadow, or the virtual height above the page of the widget throwing the shadow.&#010 <P>&#010 This is a single parameter that can be used to control both <code>shadowSoftness</code> and&#010 <code>shadowOffset</code>.
     *
     *
     * @return int
     *
     */
    public int getShadowDepth()  {
        return getAttributeAsInt("shadowDepth");
    }

    /**
    * Base name of the series of images for the sides, corners, and center of the shadow.&#010 <P>&#010 The actual image names fetched for the dropShadow combine the segment name and the&#010 <code>shadowDepth</code> setting.  For example, given "ds.png" as the base name, a depth of&#010 4, and the top-left segment of the shadow, we'd use "ds4_TL.png".&#010 <P>&#010 The names for segments are the same as those given for controlling resizable edges; see&#010 {@link com.smartgwt.client.widgets.Canvas#getResizeFrom resizeFrom}.  The center segment has the name "center".  The center segment is&#010 the only segment that doesn't include the depth in the URL, so the final image name for the&#010 center given a baseName of "ds.png" would be just "ds_center.png".
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param shadowImage shadowImage Default value is "[SKIN]ds.png"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShadowImage(String shadowImage)  throws IllegalStateException {
        setAttribute("shadowImage", shadowImage, false);
    }
    /**
     * Base name of the series of images for the sides, corners, and center of the shadow.&#010 <P>&#010 The actual image names fetched for the dropShadow combine the segment name and the&#010 <code>shadowDepth</code> setting.  For example, given "ds.png" as the base name, a depth of&#010 4, and the top-left segment of the shadow, we'd use "ds4_TL.png".&#010 <P>&#010 The names for segments are the same as those given for controlling resizable edges; see&#010 {@link com.smartgwt.client.widgets.Canvas#getResizeFrom resizeFrom}.  The center segment has the name "center".  The center segment is&#010 the only segment that doesn't include the depth in the URL, so the final image name for the&#010 center given a baseName of "ds.png" would be just "ds_center.png".
     *
     *
     * @return String
     *
     */
    public String getShadowImage()  {
        return getAttributeAsString("shadowImage");
    }

    // ********************* Methods ***********************











        /**
         * Returns the boolean true, if the widget has been completely drawn, and false otherwise.&#010
         *
         * @return true if drawn, false if not drawn
         */
        public native Boolean isDrawn() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isDrawn();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;






        /**
         * Returns whether a canvas is waiting to be redrawn. Will return true if &#010 {@link com.smartgwt.client.widgets.Canvas#markForRedraw} has been called, but this canvas has not yet been&#010 redrawn.&#010
         *
         * @return true is this canvas needs to be redrawn; false otherwise
         */
        public native Boolean isDirty() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isDirty();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty&#010 components is handled by a looping timer and will after a very short delay (typically less than&#010 100ms). In most cases it is recommended that developers use <code>markForRedraw()</code>&#010 instead of calling {@link com.smartgwt.client.widgets.Canvas#redraw} directly. Since this method queues the redraw, multiple&#010 calls to markForRedraw() within a single thread of excecution will only lead to a single DOM&#010 manipulation which greatly improves application performance.&#010&#010
         */
        public native void markForRedraw() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.markForRedraw();
        }-*/;

        /**
         * Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty&#010 components is handled by a looping timer and will after a very short delay (typically less than&#010 100ms). In most cases it is recommended that developers use <code>markForRedraw()</code>&#010 instead of calling {@link com.smartgwt.client.widgets.Canvas#redraw} directly. Since this method queues the redraw, multiple&#010 calls to markForRedraw() within a single thread of excecution will only lead to a single DOM&#010 manipulation which greatly improves application performance.&#010&#010
         * @param reason reason for performing the redraw
         */
        public native void markForRedraw(String reason) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.markForRedraw(reason);
        }-*/;

        /**
         * Redraws the widget immediately with its current property values.  &#010&#010 Generally, if you want a Canvas to redraw, call markForRedraw() - this will cause the Canvas to&#010 be redrawn when current processing ends, so that a series of modifications made to a Canvas will&#010 cause it to redraw only once.&#010&#010 Only call redraw() directly if you need immediate responsiveness, for example you are redrawing&#010 in response to continuous mouse motion.&#010&#010
         */
        public native void redraw() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.redraw();
        }-*/;

        /**
         * Redraws the widget immediately with its current property values.  &#010&#010 Generally, if you want a Canvas to redraw, call markForRedraw() - this will cause the Canvas to&#010 be redrawn when current processing ends, so that a series of modifications made to a Canvas will&#010 cause it to redraw only once.&#010&#010 Only call redraw() directly if you need immediate responsiveness, for example you are redrawing&#010 in response to continuous mouse motion.&#010&#010
         * @param reason reason for performing the redraw
         */
        public native void redraw(String reason) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.redraw(reason);
        }-*/;

        /**
         * Remove all visual representation of a Canvas.&#010 <P>&#010 This is far more expensive than hide(), because in order to become visible again, the Canvas must&#010 be draw()n again.  Generally, application code has no reason to call clear(); if you want to&#010 temporarily hide a Canvas, use hide() and show(), and if you want to permanently destroy a&#010 Canvas, use destroy().&#010 <P>&#010 Note: a clear() will happen as part of moving a Canvas to a different parent.  See addChild().&#010&#010
         */
        public native void clear() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clear();
        }-*/;


        /**
         * {@link com.smartgwt.client.widgets.Canvas#destroy} this canvas on a timeout. This method should be used instead of&#010 calling <code>canvas.destroy()</code> directly unless there's a reason a the canvas needs to be&#010 destroyed synchronously. By using a timeout, this method ensures the <code>destroy()</code> will&#010 occur after the current thread of execution completes. This allows you to easily mark canvases&#010 for destruction while they're handling events, which must complete before the canvas can be&#010 destroyed.&#010
         */
        public native void markForDestroy() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.markForDestroy();
        }-*/;

        /**
         * Adds newChild as a child of this widget, set up a named object reference (i.e., this[name])&#010 to the new widget if name argument is provided, and draw the child if this widget has been&#010 drawn already.&#010 <P>&#010 If newChild has a parent it will be removed from it. If it has a master, it will be detached&#010 from it if the master is a child of a different parent. If newChild has peers, they'll be&#010 added to this widget as children as well.&#010&#010
         * @param newChild new child canvas to add
         *
         * @return the new child, or null if it couldn't be added
         */
        public native Canvas addChild(Canvas newChild) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.addChild(newChild.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Adds newChild as a child of this widget, set up a named object reference (i.e., this[name])&#010 to the new widget if name argument is provided, and draw the child if this widget has been&#010 drawn already.&#010 <P>&#010 If newChild has a parent it will be removed from it. If it has a master, it will be detached&#010 from it if the master is a child of a different parent. If newChild has peers, they'll be&#010 added to this widget as children as well.&#010&#010
         * @param newChild new child canvas to add
     * @param name name to assign to child (eg: this[name] == child)
     * @param autoDraw if false, child will not automatically be drawn (only                                          for advanced use)
         *
         * @return the new child, or null if it couldn't be added
         */
        public native Canvas addChild(Canvas newChild, String name, boolean autoDraw) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.addChild(newChild.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), name, autoDraw);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;



        /**
         * Adds newPeer as a peer of this widget (also making it a child of this widget's parent, if&#010      any), set up a named object reference (i.e., this[name]) to the new widget if name is&#010      provided, and draw the peer if this widget has been drawn already.<br>&#010      The widget to be added as a peer will be removed from its old master and/or parent, if any,&#010      and it will be added as a child to the parent of this canvas (if any)&#010
         * @param newPeer new peer widget to add
         *
         * @return the new peer, or null if it couldn't be added
         */
        public native Canvas addPeer(Canvas newPeer) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.addPeer(newPeer.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Adds newPeer as a peer of this widget (also making it a child of this widget's parent, if&#010      any), set up a named object reference (i.e., this[name]) to the new widget if name is&#010      provided, and draw the peer if this widget has been drawn already.<br>&#010      The widget to be added as a peer will be removed from its old master and/or parent, if any,&#010      and it will be added as a child to the parent of this canvas (if any)&#010
         * @param newPeer new peer widget to add
     * @param name name to assign to peer (eg: this[peer] == child)
     * @param autoDraw if true, peer will not automatically be drawn (only                                  for advanced use)
     * @param preDraw if true, when draw is called on the master widget, the peer&#010                                  will be drawn before the master
         *
         * @return the new peer, or null if it couldn't be added
         */
        public native Canvas addPeer(Canvas newPeer, String name, boolean autoDraw, boolean preDraw) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.addPeer(newPeer.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), name, autoDraw, preDraw);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;






        /**
         * Returns true if element is a descendant of this widget (i.e., exists below this widget in&#010      the containment hierarchy); and false otherwise.&#010
         * @param canvas the canvas to be tested
         *
         * @return true if specified element is a descendant of this canvas; false otherwise
         */
        public native Boolean contains(Canvas canvas) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.contains(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Returns true if element is a descendant of this widget (i.e., exists below this widget in&#010      the containment hierarchy); and false otherwise.&#010
         * @param canvas the canvas to be tested
     * @param testSelf If passed this method will return true if the the canvas                                parameter is a pointer to this widget.
         *
         * @return true if specified element is a descendant of this canvas; false otherwise
         */
        public native Boolean contains(Canvas canvas, boolean testSelf) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.contains(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), testSelf);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Hides the click mask associated with this canvas.&#010
         */
        public native void hideClickMask() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.hideClickMask();
        }-*/;

        /**
         * Hides the click mask associated with this canvas.&#010
         * @param ID optional ID of specific clickMask to hide. If not passed,                       defaults to hiding the click mask associated with this widget only.
         */
        public native void hideClickMask(String ID) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.hideClickMask(ID);
        }-*/;

        /**
         * Determines whether a clickmask is showing&#010
         */
        public native void clickMaskUp() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clickMaskUp();
        }-*/;

        /**
         * Determines whether a clickmask is showing&#010
         * @param ID optional ID of specific clickMask to check. If not passed,                       checks for the click mask associated with this widget only.
         */
        public native void clickMaskUp(String ID) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clickMaskUp(ID);
        }-*/;










        /**
         * Return the right coordinate of this object as rendered, relative to its enclosing context,&#010 in pixels.&#010&#010
         *
         * @return right coordinate
         */
        public native int getRight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getRight();
        }-*/;

        /**
         * Resizes the widget horizontally to position its right side at the specified coordinate.&#010 <P>&#010 NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()&#010 instead&#010
         * @param right new right coordinate
         */
        public native void setRight(int right) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setRight(right);
        }-*/;

        /**
         * Return the bottom coordinate of this object as rendered, relative to its enclosing context,&#010 in pixels.&#010&#010
         *
         * @return bottom coordinate
         */
        public native int getBottom() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getBottom();
        }-*/;

        /**
         * Resizes the widget vertically to position its bottom edge at the specified coordinate.&#010 <P>&#010 NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()&#010 instead&#010&#010
         * @param bottom new bottom coordinate
         */
        public native void setBottom(int bottom) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setBottom(bottom);
        }-*/;

        /**
         * Returns the scrollable width of the widget's contents, including children, ignoring&#010 clipping.&#010
         *
         * @return the scrollable width of the widget's contents
         */
        public native int getScrollWidth() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollWidth();
        }-*/;

        /**
         * Returns the scrollable height of the widget's contents, including children, ignoring&#010          clipping.&#010
         *
         * @return height of the element that can scroll
         */
        public native int getScrollHeight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollHeight();
        }-*/;

        /**
         * Get the number of pixels this Canvas is scrolled from its left edge.&#010
         *
         * @return scrollLeft
         */
        public native int getScrollLeft() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollLeft();
        }-*/;

        /**
         * Get the number of pixels this Canvas is scrolled from its top edge.&#010
         *
         * @return scrollTop
         */
        public native int getScrollTop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollTop();
        }-*/;

        /**
         * Set the page-relative left coordinate of this widget.&#010 &#010
         * @param left new left coordinate in pixels
         */
        public native void setPageLeft(int left) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setPageLeft(left);
        }-*/;

        /**
         * Set the page-relative top coordinate of this widget.&#010 &#010
         * @param top new top coordinate in pixels
         */
        public native void setPageTop(int top) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setPageTop(top);
        }-*/;

        /**
         * Returns the page-relative left coordinate of the widget on the page, in pixels.&#010
         *
         * @return global left coordinate
         */
        public native int getPageLeft() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getPageLeft();
        }-*/;

        /**
         * Returns the page-relative top coordinate of the widget on the page, in pixels &#010
         *
         * @return GLOBAL top coordinate
         */
        public native int getPageTop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getPageTop();
        }-*/;

        /**
         * Return the page-relative right coordinate of this object, in pixels.&#010  &#010
         *
         * @return GLOBAL right coordinate
         */
        public native int getPageRight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getPageRight();
        }-*/;

        /**
         * Return the page-relative bottom coordinate of this object, in pixels.&#010
         *
         * @return GLOBAL bottom coordinate
         */
        public native int getPageBottom() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getPageBottom();
        }-*/;



        /**
         * Return whether or not this object contains the specified global (x,y) coordinates.&#010 <P>&#010 Will return false if any parentElement does not contain the specified point, (EG:&#010 you're hovering over an element's absolute location, but it is scrolled out of &#010 view in a parent element)&#010&#010
         * @param x GLOBAL x-coordinate
     * @param y GLOBAL y-coordinate
         *
         * @return true if this object contains the specified point; false otherwise
         */
        public native Boolean containsPoint(int x, int y) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.containsPoint(x, y);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Return whether or not this object contains the specified global (x,y) coordinates.&#010 <P>&#010 Will return false if any parentElement does not contain the specified point, (EG:&#010 you're hovering over an element's absolute location, but it is scrolled out of &#010 view in a parent element)&#010&#010
         * @param x GLOBAL x-coordinate
     * @param y GLOBAL y-coordinate
     * @param withinViewport point lies specificly within our viewport                                              (drawn area excluding margins and scrollbars if&#010                                              present)
         *
         * @return true if this object contains the specified point; false otherwise
         */
        public native Boolean containsPoint(int x, int y, boolean withinViewport) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.containsPoint(x, y, withinViewport);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Does this widget contain the specified global (x,y) coordinates, and have no other widgets&#010 also at the specified position, obscuring this one?  This is commonly used for (for example)&#010 drag and drop interactions.&#010&#010
         * @param x GLOBAL x-coordinate
     * @param y GLOBAL y-coordinate
         *
         * @return true if this object contains the specified point; false otherwise
         */
        public native Boolean visibleAtPoint(int x, int y) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.visibleAtPoint(x, y);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Does this widget contain the specified global (x,y) coordinates, and have no other widgets&#010 also at the specified position, obscuring this one?  This is commonly used for (for example)&#010 drag and drop interactions.&#010&#010
         * @param x GLOBAL x-coordinate
     * @param y GLOBAL y-coordinate
     * @param withinViewport point lies within our viewport rather than                                              just our drawn area
     * @param ignoreWidgets If passed ignore widget(s), do not check whether                                           those widgets occludes this one.
         *
         * @return true if this object contains the specified point; false otherwise
         */
        public native Boolean visibleAtPoint(int x, int y, boolean withinViewport, Canvas ignoreWidgets) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.visibleAtPoint(x, y, withinViewport, ignoreWidgets.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Returns true if the rectangles of this widget and the specified widget overlap.&#010
         * @param other other canvas to test for intersection
         *
         * @return true if this canvas intersects other; false otherwise
         */
        public native Boolean intersects(Canvas other) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.intersects(other.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Return true if the last event's mouse coordinates are within the bounds of this component.&#010  NOTE: Z-ordering is not considered for the purposes of this test.  If the coordinate you're&#010  testing is occluded by other component, but the X,Y coordiates are still within the bounds&#010  of that component, this method will return true.&#010&#010
         *
         * @return true if the event occurred within the bounds of this component
         */
        public native Boolean containsEvent() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.containsEvent();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Return the X-coordinate of the last event relative to the left edge of the content of this&#010 Canvas.<br><br>&#010&#010  NOTE: To get a coordinate relative to the <b>viewport</b> of this Canvas, subtract&#010  this.getScrollLeft()&#010&#010
         *
         * @return 
         */
        public native int getOffsetX() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getOffsetX();
        }-*/;

        /**
         * Return the Y-coordinate of the last event, relative to the top edge of the content of this&#010 Canvas.<br><br>&#010&#010  NOTE: To get a coordinate relative to the <b>viewport</b> of this Canvas, subtract&#010  this.getScrollTop()&#010&#010
         *
         * @return 
         */
        public native int getOffsetY() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getOffsetY();
        }-*/;


        /**
         * Returns the width of the viewport onto the scrollable content.&#010&#010
         *
         * @return width of the viewport, in pixels
         */
        public native int getViewportWidth() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getViewportWidth();
        }-*/;

        /**
         * Returns the height of the viewport onto the scrollable content.&#010&#010
         *
         * @return height of the viewport, in pixels
         */
        public native int getViewportHeight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getViewportHeight();
        }-*/;

        /**
         * Returns the amount of space available for (an) absolutely positioned child widget(s) or &#010  HTML content, without introducing clipping, scrolling or overflow.<br>&#010  This is the space within the viewport of the widget (including padding, but excluding &#010  margins, borders or scrollbars) rendered at its specified size.&#010&#010
         *
         * @return inner height of the widget in pixels
         */
        public native int getInnerHeight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getInnerHeight();
        }-*/;

        /**
         * Returns the amount of space available for (an) absolutely positioned child widget(s) or &#010  HTML content, without introducing clipping, scrolling or overflow.<br>&#010  This is the space within the viewport of the widget (including padding, but excluding &#010  margins, borders or scrollbars) rendered at its specified size.&#010&#010
         *
         * @return inner width of the widget in pixels
         */
        public native int getInnerWidth() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getInnerWidth();
        }-*/;

        /**
         * Returns the amount of space available for interior content (or relatively positioned child&#010  widget(s)) without introducing clipping, scrolling or overflow.<br>&#010  This is the space within the viewport of the widget (not including padding, and excluding &#010  margins, borders or scrollbars) rendered at its specified size.&#010&#010
         *
         * @return inner height of the widget in pixels
         */
        public native int getInnerContentHeight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getInnerContentHeight();
        }-*/;

        /**
         * Returns the amount of space available for interior content (or relatively positioned child&#010  widget(s)) without introducing clipping, scrolling or overflow.<br>&#010  This is the space within the viewport of the widget (not including padding, and excluding &#010  margins, borders or scrollbars) rendered at its specified size.&#010&#010
         *
         * @return inner height of the widget in pixels
         */
        public native int getInnerContentWidth() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getInnerContentWidth();
        }-*/;

        /**
         * Return the visible width of the Canvas.&#010&#010
         *
         * @return visible width in pixels
         */
        public native int getVisibleWidth() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVisibleWidth();
        }-*/;

        /**
         * Return the visible height of the Canvas.&#010&#010
         *
         * @return visible height in pixels
         */
        public native int getVisibleHeight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVisibleHeight();
        }-*/;

        /**
         * Moves the widget deltaX pixels to the right and deltaY pixels down. Pass negative&#010          numbers to move up and/or to the left.&#010
         * @param deltaX amount to move horizontally (may be negative)
     * @param deltaY amount to move vertically (may be negative)
         *
         * @return whether the component actually moved
         */
        public native Boolean moveBy(int deltaX, int deltaY) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.moveBy(deltaX, deltaY);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Get an offset to be used when calculating snap positioning. Returns 0 by default.&#010&#010
         *
         * @return The offset to use when snapping
         */
        public native int getVSnapOrigin() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVSnapOrigin();
        }-*/;

        /**
         * Get an offset to be used when calculating snap positioning. Returns 0 by default.&#010&#010
         * @param snapChild the child that is being snapped
         *
         * @return The offset to use when snapping
         */
        public native int getVSnapOrigin(Canvas snapChild) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVSnapOrigin(snapChild.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Get an offset to be used when calculating snap positioning. Returns 0 by default.&#010&#010
         *
         * @return The offset to use when snapping
         */
        public native int getHSnapOrigin() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getHSnapOrigin();
        }-*/;

        /**
         * Get an offset to be used when calculating snap positioning. Returns 0 by default.&#010&#010
         * @param snapChild the child that is being snapped
         *
         * @return The offset to use when snapping
         */
        public native int getHSnapOrigin(Canvas snapChild) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getHSnapOrigin(snapChild.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Show this widget next to another widget.&#010
         * @param otherWidget Canvas to show next to
         */
        public native void showNextTo(Canvas otherWidget) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.showNextTo(otherWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Show this widget next to another widget.&#010
         * @param otherWidget Canvas to show next to
     * @param side which side to show on, defaults to "right"
         */
        public native void showNextTo(Canvas otherWidget, String side) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.showNextTo(otherWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), side);
        }-*/;

        /**
         * Resizes the widget, adding deltaX to its width and deltaY to its height (moves the right&#010          and/or bottom sides of the widget).&#010
         *
         * @return whether the component actually changed size
         */
        public native Boolean resizeBy() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.resizeBy();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Resizes the widget, adding deltaX to its width and deltaY to its height (moves the right&#010          and/or bottom sides of the widget).&#010
         * @param deltaX amount to resize horizontally (may be negative)
     * @param deltaY amount to resize vertically (may be negative)
         *
         * @return whether the component actually changed size
         */
        public native Boolean resizeBy(int deltaX, int deltaY) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.resizeBy(deltaX, deltaY);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Add a resized handler.
         * <p>
         * Observable method called whenever a Canvas changes size. Note that if this canvas is&#010 {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}, and is waiting for a queued redraw (see &#010 {@link com.smartgwt.client.widgets.Canvas#isDirty}), the value for {@link com.smartgwt.client.widgets.Canvas#getVisibleWidth} and&#010 {@link com.smartgwt.client.widgets.Canvas#getVisibleHeight} will be unreliable until <code>redraw()</code> fires.&#010
         *
         * @param handler the resized handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addResizedHandler(com.smartgwt.client.widgets.events.ResizedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.ResizedEvent.getType()) == 0) setupResizedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.ResizedEvent.getType());
        }
        private native void setupResizedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({resized:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.ResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.resized = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.ResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;


        /**
         * &#010 <code>layoutChildren()</code> is where a Canvas should implement a sizing policy for it's&#010 Canvas children.  Since <code>layoutChildren</code> calls parentResized() on its children,&#010 {@link com.smartgwt.client.widgets.Canvas#parentResized} is a good place for a child to implement a layout policy that&#010 can be used within any parent.&#010 <P>&#010 Recommended practice for a Canvas that manages Canvas children is to create those children&#010 without any initial coordinate or size settings and do all sizing when layoutChildren() is&#010 called.&#010 <P>&#010 layoutChildren() is always called at least once before children are drawn, and is called&#010 automatically whenever the viewport size changes (which includes both resizing and&#010 introduction/removal of scrolling).  layoutChildren() can also be manually invoked in any&#010 other component-specific situation which changes the layout.&#010 <P>&#010 NOTE: layoutChildren() may be called before draw() if a widget is resized before draw(), so&#010 be sure to avoid errors such as assuming that any children you automatically create have&#010 already been created.&#010 <P>&#010 NOTE: auto-sizing: layoutChildren() is also called once during the initial draw(), before&#010 children are drawn, with a "reason" of "initial draw".  During this invocation of&#010 layoutChildren() it is legal to directly draw children (call child.draw()), which is&#010 otherwise never allowed.  This allows a Canvas to implement an auto-sizing layout policy by&#010 drawing some children before deciding on the sizes of remaining children, which is far more&#010 efficient than drawing all children and resizing some of them after they are drawn.&#010
         * @param reason reason why layoutChildren() is being called, passed when framework                        code invokes layoutChildren()
         */
        public native void layoutChildren(String reason) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.layoutChildren(reason);
        }-*/;

        /**
         * Resizes the widget to the specified width and height (moves the right and/ or bottom&#010          sides of the widget). The width and height parameters can be expressed as a percentage&#010          of viewport size or as the number of pixels.&#010
         *
         * @return whether the size actually changed
         */
        public native Boolean resizeTo() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.resizeTo();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Resizes the widget to the specified width and height (moves the right and/ or bottom&#010          sides of the widget). The width and height parameters can be expressed as a percentage&#010          of viewport size or as the number of pixels.&#010
         * @param width new width for canvas
     * @param height new height for canvas
         *
         * @return whether the size actually changed
         */
        public native Boolean resizeTo(int width, int height) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.resizeTo(width, height);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Fires when the interior size of the parent changes, including parent resize and&#010 scrollbar introduction or removal.&#010 <p>&#010 This method allows a child to implement a layout policy that can be used within any &#010 parent, such as a Resizer component that always snaps to the parent's&#010 bottom-right corner.  The default implementation of this method applies a child's&#010 percent sizes, if any, or implements layout based on the {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} property&#010
         */
        public native void parentResized() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.parentResized();
        }-*/;


        /**
         * If this widget is showing scrollbars, and a user drags close to the edge of the viewport,&#010 should we scroll the viewport in the appropriate direction?&#010 Returns this.canDragScroll by default.&#010
         */
        public native void shouldDragScroll() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.shouldDragScroll();
        }-*/;


        /**
         * This method tells a component to adjust for size changes made to content by external code.&#010 <P>&#010 This is for very advanced use in which the contents of a Canvas are being directly updated by&#010 Ajax techniques, which is required for integration with some third-party libraries.&#010 Calling this method is required because browsers do not provide consistent events by which&#010 SmartGWT can be notified of external content changes.&#010 <P>&#010 Only contents supplied to a widget via {@link com.smartgwt.client.widgets.Canvas#getContents contents} or via an override of&#010 {@link com.smartgwt.client.widgets.Canvas#getInnerHTML} should be manipulated directly.  Contents automatically&#010 generated by SmartGWT components (such as the basic structure of a Button) should never be&#010 manipulated: these structures are considered internal, differ by platform, and will change&#010 without notice.&#010
         * @param immediate By default the adjustment will occur on a small delay for performance reasons. &#010  Pass in this parameter to force immediate adjustment.
         */
        public native void adjustForContent(boolean immediate) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.adjustForContent(immediate);
        }-*/;



        /**
         * Vertically scrolls the content of the widget to 0&#010&#010
         */
        public native void scrollToTop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollToTop();
        }-*/;

        /**
         * Vertically scrolls the content of the widget to the end of its content&#010&#010
         */
        public native void scrollToBottom() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollToBottom();
        }-*/;

        /**
         * Horizontally scrolls the content of the widget to 0&#010&#010
         */
        public native void scrollToLeft() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollToLeft();
        }-*/;

        /**
         * Horizontally scrolls the content of the widget to the end of its content&#010&#010
         */
        public native void scrollToRight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollToRight();
        }-*/;

        /**
         * Scroll this widget by some pixel increment in either (or both) direction(s).&#010&#010
         * @param dX Number of pixels to scroll horizontally
     * @param dY Number of pixels to scroll vertically
         */
        public native void scrollBy(int dX, int dY) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollBy(dX, dY);
        }-*/;


        /**
         * Scrolls the content of the widget so that the origin (top-left corner) of the content&#010 is left pixels to the left and top pixels above the widget's top-left corner (but still&#010 clipped by the widget's dimensions).&#010 <p>&#010 This is guaranteed to be called whenever this Canvas is scrolled, whether scrolling is&#010 initiated programmatically, by custom scrollbars, or a by a native scrollbar.&#010&#010
         */
        public native void scrollTo() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollTo();
        }-*/;

        /**
         * Scrolls the content of the widget so that the origin (top-left corner) of the content&#010 is left pixels to the left and top pixels above the widget's top-left corner (but still&#010 clipped by the widget's dimensions).&#010 <p>&#010 This is guaranteed to be called whenever this Canvas is scrolled, whether scrolling is&#010 initiated programmatically, by custom scrollbars, or a by a native scrollbar.&#010&#010
         * @param left the left coordinate
     * @param top the top coordiante
         */
        public native void scrollTo(int left, int top) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.scrollTo(left, top);
        }-*/;

        /**
         * Add a scrolled handler.
         * <p>
         * Notification that this component has just scrolled.  Use with&#010 {@link com.smartgwt.client..Class#observe}.&#010 <P>&#010 Fires for both CSS and {@link com.smartgwt.client.widgets.Scrollbar}.&#010&#010
         *
         * @param handler the scrolled handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addScrolledHandler(com.smartgwt.client.widgets.events.ScrolledHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.ScrolledEvent.getType()) == 0) setupScrolledEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.ScrolledEvent.getType());
        }
        private native void setupScrolledEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({scrolled:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.ScrolledEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.scrolled = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.ScrolledEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;


        /**
         * Sets this widget's visibility to "inherit", so that it becomes visible if all it's parents&#010 are visible or it has no parents.&#010 <P>&#010 If the widget has not yet been drawn (and doesn't have a parent or master), this method&#010 calls the draw method as well.&#010&#010
         */
        public native void show() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.show();
        }-*/;

        /**
         * Sets the widget's CSS visibility attribute to "hidden".&#010
         */
        public native void hide() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.hide();
        }-*/;




        /**
         * Enables this widget and any children / peers of this widget.&#010
         */
        public native void enable() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.enable();
        }-*/;

        /**
         * Disables this widget and any children and peers of this widget.&#010
         */
        public native void disable() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.disable();
        }-*/;

        /**
         * Is this canvas disabled? Note that the disabled state is inherited - this method will return&#010 true if this widget, or any of its ancestors are marked disabled.&#010
         *
         * @return true if the widget or any widget above it in the containment hierarchy                      are disabled.
         */
        public native Boolean isDisabled() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isDisabled();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;



        /**
         * If this canvas can accept focus, give it keyboard focus. After this method, the canvas&#010 will appear focussed and will recieve keyboard events.&#010
         */
        public native void focus() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.focus();
        }-*/;

        /**
         * If this canvas has keyboard focus, blur it. After this method, the canvas&#010 will no longer appear focussed and will stop recieving keyboard events.&#010
         */
        public native void blur() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.blur();
        }-*/;

        /**
         * Returns true if the keyboard focus is in this Canvas or any child of this Canvas.&#010
         *
         * @return whether this Canvas contains the keyboard focus
         */
        public native Boolean containsFocus() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.containsFocus();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;



        /**
         * Puts this widget at the top of the stacking order, so it appears in front of all other&#010 widgets in the same parent.&#010
         */
        public native void bringToFront() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.bringToFront();
        }-*/;

        /**
         * Puts this widget at the bottom of the stacking order, so it appears behind all other&#010 widgets in the same parent.&#010
         */
        public native void sendToBack() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.sendToBack();
        }-*/;

        /**
         * Puts this widget just above the specified widget in the stacking order, so it appears in&#010 front of the specified widget if both widgets have the same parent.&#010
         * @param canvas canvas to move above
         */
        public native void moveAbove(Canvas canvas) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.moveAbove(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Puts this widget just below the specified widget in the stacking order, so it appears&#010 behind the specified widget if both widgets have the same parent.&#010
         * @param canvas canvas to move below
         */
        public native void moveBelow(Canvas canvas) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.moveBelow(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;








        /**
         * Handler fired on a delay when the user hovers the mouse over this hover-target.&#010 Default implementation will fire <code>this.hover()</code> (if defined), and handle &#010 showing the hover canvas if <code>this.showHover</code> is true.&#010
         */
        public native void handleHover() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.handleHover();
        }-*/;

        /**
         * If this canvas is currently showing a hover (see {@link com.smartgwt.client.widgets.Canvas#handleHover}), this method&#010 can be called to update the contents of the hover. Has no effect if the hover canvas is not&#010 showing for this widget.&#010
         */
        public native void updateHover() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.updateHover();
        }-*/;

        /**
         * If this canvas is currently showing a hover (see {@link com.smartgwt.client.widgets.Canvas#handleHover}), this method&#010 can be called to update the contents of the hover. Has no effect if the hover canvas is not&#010 showing for this widget.&#010
         * @param hoverHTML Option to specify new HTML for the hover. If not passed, the result   of {@link com.smartgwt.client.widgets.Canvas#getHoverHTML} will be used instead. Note that if the&#010   hover HTML is empty the hover will be hidden.
         */
        public native void updateHover(String hoverHTML) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.updateHover(hoverHTML);
        }-*/;

        /**
         * Add a hoverHidden handler.
         * <p>
         * If {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true for this canvas, this notification method will be&#010 fired whenever the hover shown in response to {@link com.smartgwt.client.widgets.Canvas#handleHover} is &#010 hidden. This method may be observed or overridden.&#010
         *
         * @param handler the hoverHidden handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addHoverHiddenHandler(com.smartgwt.client.widgets.events.HoverHiddenHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.HoverHiddenEvent.getType()) == 0) setupHoverHiddenEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.HoverHiddenEvent.getType());
        }
        private native void setupHoverHiddenEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({hoverHidden:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.HoverHiddenEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.hoverHidden = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.HoverHiddenEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a hover handler.
         * <p>
         * If <code>canHover</code> is true for this widget, the <code>hover</code> string method will&#010 be fired when the user hovers over this canvas. If this method returns false, it will&#010 suppress the default behavior of showing a hover canvas if <code>this.showHover</code> &#010 is true.&#010
         *
         * @param handler the hover handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addHoverHandler(com.smartgwt.client.widgets.events.HoverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.HoverEvent.getType()) == 0) setupHoverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.HoverEvent.getType());
        }
        private native void setupHoverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({hover:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.HoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.hover = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.HoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * If <code>this.showHover</code> is true, when the user holds the mouse over this Canvas for&#010 long enough to trigger a hover event, a hover canvas is shown by default. This method returns&#010 the contents of that hover canvas. Default implementation returns <code>this.prompt</code> -&#010 override for custom hover HTML. Note that returning <code>null</code> or an empty string will&#010 suppress the hover canvas altogether.&#010
         */
        public native void getHoverHTML() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getHoverHTML();
        }-*/;



        /**
         * Add a showContextMenu handler.
         * <p>
         * Executed when the right mouse button is clicked.  The default implementation of&#010 this method auto-creates a {@link com.smartgwt.client.widgets.menu.Menu} from the {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} property on&#010 this component and then calls {@link com.smartgwt.client.widgets.menu.Menu#showContextMenu} on it to show it.&#010 <p>&#010 If you want to show a standard context menu, you can simply define your Menu and set it as the&#010 contextMenu property on your component - you do not need to override this method.&#010 <p>&#010 If you want to do some other processing before showing a menu or do something else entirely, then&#010 you should override this method.  Note that the return value from this method controls whether or&#010 not the native browser context menu is shown.&#010 &#010
         *
         * @param handler the showContextMenu handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addShowContextMenuHandler(com.smartgwt.client.widgets.events.ShowContextMenuHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.ShowContextMenuEvent.getType()) == 0) setupShowContextMenuEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.ShowContextMenuEvent.getType());
        }
        private native void setupShowContextMenuEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({showContextMenu:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.ShowContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.showContextMenu = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.ShowContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * &#010 The default implementation of this method hides the contextMenu currently being shown for this&#010 component (which occurs when the mouse button that toggles the context menu is released).&#010 Override if you want some other behavior. &#010&#010
         */
        public native void hideContextMenu() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.hideContextMenu();
        }-*/;

        /**
         * Add a mouseOver handler.
         * <p>
         * &#010 Executed when mouse enters this widget.  No default implementation.&#010&#010
         *
         * @param handler the mouseOver handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseOverHandler(com.smartgwt.client.widgets.events.MouseOverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseOverEvent.getType()) == 0) setupMouseOverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseOverEvent.getType());
        }
        private native void setupMouseOverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseOver:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseOver = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseDown handler.
         * <p>
         * &#010 Executed when the left mouse down is pressed on this widget.  No default implementation.&#010&#010
         *
         * @param handler the mouseDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseDownHandler(com.smartgwt.client.widgets.events.MouseDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseDownEvent.getType()) == 0) setupMouseDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseDownEvent.getType());
        }
        private native void setupMouseDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseDown:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseDown = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rightMouseDown handler.
         * <p>
         * &#010 Executed when the right mouse down is pressed on this widget.  No default implementation.&#010&#010
         *
         * @param handler the rightMouseDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRightMouseDownHandler(com.smartgwt.client.widgets.events.RightMouseDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.RightMouseDownEvent.getType()) == 0) setupRightMouseDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.RightMouseDownEvent.getType());
        }
        private native void setupRightMouseDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rightMouseDown:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.RightMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rightMouseDown = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.RightMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseStillDown handler.
         * <p>
         * &#010 Executed repeatedly (every {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay} by default) when the system is idle -&#010 i.e. not busy running other scripts - and the left mouse button is held down after having been&#010 pressed in the object. This event is not native to JavaScript, but is provided by the ISC system.&#010 <p>&#010 Note: The event handling system waits {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownInitialDelay mouseStillDownInitialDelay} before&#010 calling mouseStillDown for the first time on the widget.  Subsequently the method is called every&#010 {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay}.  Both attributes are configurable per widget instance.&#010 <p>&#010 This method is called only when the left mouse is held down.&#010&#010
         *
         * @param handler the mouseStillDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseStillDownHandler(com.smartgwt.client.widgets.events.MouseStillDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseStillDownEvent.getType()) == 0) setupMouseStillDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseStillDownEvent.getType());
        }
        private native void setupMouseStillDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseStillDown:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseStillDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseStillDown = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseStillDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseMove handler.
         * <p>
         * &#010 Executed when the mouse moves within this widget.  No default implementation.&#010&#010
         *
         * @param handler the mouseMove handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseMoveHandler(com.smartgwt.client.widgets.events.MouseMoveHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseMoveEvent.getType()) == 0) setupMouseMoveEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseMoveEvent.getType());
        }
        private native void setupMouseMoveEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseMove:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseMove = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseOut handler.
         * <p>
         * &#010 Executed when the mouse leaves this widget.  No default implementation.&#010&#010
         *
         * @param handler the mouseOut handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseOutHandler(com.smartgwt.client.widgets.events.MouseOutHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseOutEvent.getType()) == 0) setupMouseOutEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseOutEvent.getType());
        }
        private native void setupMouseOutEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseOut:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseOut = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseUp handler.
         * <p>
         * &#010 Executed when the left mouse is released on this widget.  No default implementation.&#010&#010
         *
         * @param handler the mouseUp handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseUpHandler(com.smartgwt.client.widgets.events.MouseUpHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseUpEvent.getType()) == 0) setupMouseUpEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseUpEvent.getType());
        }
        private native void setupMouseUpEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseUp:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseUp = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a click handler.
         * <p>
         * &#010 Executed when the left mouse is clicked (pressed and then released) on this widget.  No default&#010 implementation.&#010&#010
         *
         * @param handler the click handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.events.ClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.ClickEvent.getType()) == 0) setupClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.ClickEvent.getType());
        }
        private native void setupClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({click:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.click = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a doubleClick handler.
         * <p>
         * &#010 Executed when the left mouse button is clicked twice in rapid succession (within&#010 {@link com.smartgwt.client.widgets.Canvas#getDoubleClickDelay doubleClickDelay} by default) in this object.&#010&#010
         *
         * @param handler the doubleClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDoubleClickHandler(com.smartgwt.client.widgets.events.DoubleClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DoubleClickEvent.getType()) == 0) setupDoubleClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DoubleClickEvent.getType());
        }
        private native void setupDoubleClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({doubleClick:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.doubleClick = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a mouseWheel handler.
         * <p>
         * &#010 Executed when the mouse wheel is actuated.&#010&#010
         *
         * @param handler the mouseWheel handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addMouseWheelHandler(com.smartgwt.client.widgets.events.MouseWheelHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.MouseWheelEvent.getType()) == 0) setupMouseWheelEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.MouseWheelEvent.getType());
        }
        private native void setupMouseWheelEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({mouseWheel:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.MouseWheelEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.mouseWheel = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MouseWheelEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragRepositionStart handler.
         * <p>
         * &#010 Executed when dragging first starts. No default implementation.  Create this handler to set&#010 things up for the drag reposition.&#010&#010
         *
         * @param handler the dragRepositionStart handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragRepositionStartHandler(com.smartgwt.client.widgets.events.DragRepositionStartHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragRepositionStartEvent.getType()) == 0) setupDragRepositionStartEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragRepositionStartEvent.getType());
        }
        private native void setupDragRepositionStartEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragRepositionStart:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragRepositionStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragRepositionStart = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragRepositionStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragRepositionMove handler.
         * <p>
         * &#010 Executed every time the mouse moves while drag-repositioning. If this method&#010 does not return false, the {@link com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if&#010 {@link com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline" will automatically be moved as appropriate&#010 whenever the mouse moves.&#010&#010
         *
         * @param handler the dragRepositionMove handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragRepositionMoveHandler(com.smartgwt.client.widgets.events.DragRepositionMoveHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragRepositionMoveEvent.getType()) == 0) setupDragRepositionMoveEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragRepositionMoveEvent.getType());
        }
        private native void setupDragRepositionMoveEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragRepositionMove:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragRepositionMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragRepositionMove = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragRepositionMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragRepositionStop handler.
         * <p>
         * &#010 Executed when the mouse button is released at the end of the drag. Your&#010 widget can use this opportunity to fire custom code based upon where the&#010 mouse button was released, etc. &#010 <p>&#010 Returning true from this handler will cause the {@link com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if&#010 {@link com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline") to be left in its current&#010 location. Returning false from this handler will cause it to snap back to its&#010 original location.&#010&#010
         *
         * @param handler the dragRepositionStop handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragRepositionStopHandler(com.smartgwt.client.widgets.events.DragRepositionStopHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragRepositionStopEvent.getType()) == 0) setupDragRepositionStopEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragRepositionStopEvent.getType());
        }
        private native void setupDragRepositionStopEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragRepositionStop:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragRepositionStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragRepositionStop = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragRepositionStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragResizeStart handler.
         * <p>
         * &#010 Executed when resize dragging first starts. No default implementation.  &#010 Create this handler to set things up for the drag resize.&#010&#010
         *
         * @param handler the dragResizeStart handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragResizeStartHandler(com.smartgwt.client.widgets.events.DragResizeStartHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragResizeStartEvent.getType()) == 0) setupDragResizeStartEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragResizeStartEvent.getType());
        }
        private native void setupDragResizeStartEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragResizeStart:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragResizeStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragResizeStart = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragResizeStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragResizeMove handler.
         * <p>
         * &#010 Executed every time the mouse moves while drag-resizing. If this method&#010 does not return false, the {@link com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if&#010 {@link com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline" will automatically be moved as appropriate&#010 whenever the mouse moves.&#010&#010
         *
         * @param handler the dragResizeMove handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragResizeMoveHandler(com.smartgwt.client.widgets.events.DragResizeMoveHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragResizeMoveEvent.getType()) == 0) setupDragResizeMoveEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragResizeMoveEvent.getType());
        }
        private native void setupDragResizeMoveEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragResizeMove:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragResizeMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragResizeMove = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragResizeMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragResizeStop handler.
         * <p>
         * &#010 Executed when the mouse button is released at the end of the drag resize. Your&#010 widget can use this opportunity to fire custom code based upon where the&#010 mouse button was released, etc. &#010 <p>&#010 Returning true from this handler will cause the {@link com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if&#010 {@link com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline") to be left at its current size. Returning&#010 false from this handler will cause it to snap back to its original location size&#010&#010
         *
         * @param handler the dragResizeStop handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragResizeStopHandler(com.smartgwt.client.widgets.events.DragResizeStopHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragResizeStopEvent.getType()) == 0) setupDragResizeStopEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragResizeStopEvent.getType());
        }
        private native void setupDragResizeStopEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragResizeStop:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragResizeStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragResizeStop = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragResizeStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragStart handler.
         * <p>
         * Executed when dragging first starts. Your widget can use this opportunity to set&#010 things up for the drag, such as setting the drag tracker. Returning false from this&#010 event handler will cancel the drag action entirely.&#010 <p>&#010 A drag action is considered to be begin when the mouse has moved&#010 {@link com.smartgwt.client.widgets.Canvas#getDragStartDistance dragStartDistance} with the left mouse down.&#010&#010
         *
         * @param handler the dragStart handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragStartHandler(com.smartgwt.client.widgets.events.DragStartHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragStartEvent.getType()) == 0) setupDragStartEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragStartEvent.getType());
        }
        private native void setupDragStartEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragStart:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragStart = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragMove handler.
         * <p>
         * Executed every time the mouse moves while dragging this canvas.&#010&#010
         *
         * @param handler the dragMove handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragMoveHandler(com.smartgwt.client.widgets.events.DragMoveHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragMoveEvent.getType()) == 0) setupDragMoveEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragMoveEvent.getType());
        }
        private native void setupDragMoveEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragMove:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragMove = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dragStop handler.
         * <p>
         * Executed when the mouse button is released at the end of the drag. Your widget can&#010 use this opportunity to fire code based on the last location of the drag or reset any&#010 visual state that was sent.&#010&#010
         *
         * @param handler the dragStop handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDragStopHandler(com.smartgwt.client.widgets.events.DragStopHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DragStopEvent.getType()) == 0) setupDragStopEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DragStopEvent.getType());
        }
        private native void setupDragStopEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dragStop:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DragStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dragStop = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DragStopEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dropOver handler.
         * <p>
         * &#010 Executed when the compatible dragged object is first moved over this drop target. Your&#010 implementation can use this to show a custom visual indication that the object can be&#010 dropped here.&#010&#010
         *
         * @param handler the dropOver handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDropOverHandler(com.smartgwt.client.widgets.events.DropOverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DropOverEvent.getType()) == 0) setupDropOverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DropOverEvent.getType());
        }
        private native void setupDropOverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dropOver:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DropOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dropOver = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DropOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dropMove handler.
         * <p>
         * &#010 Executed whenever the compatible dragged object is moved over this drop target. You&#010 can use this to show a custom visual indication of where the drop would occur within the&#010 widget.&#010&#010
         *
         * @param handler the dropMove handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDropMoveHandler(com.smartgwt.client.widgets.events.DropMoveHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DropMoveEvent.getType()) == 0) setupDropMoveEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DropMoveEvent.getType());
        }
        private native void setupDropMoveEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dropMove:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DropMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dropMove = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DropMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dropOut handler.
         * <p>
         * &#010 Executed when the dragged object is moved out of the rectangle of this drop target. If you&#010 have set a visual indication in dropOver or dropMove, you should reset it to its normal&#010 state in dropOut.&#010&#010
         *
         * @param handler the dropOut handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDropOutHandler(com.smartgwt.client.widgets.events.DropOutHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.DropOutEvent.getType()) == 0) setupDropOutEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.DropOutEvent.getType());
        }
        private native void setupDropOutEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dropOut:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.DropOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dropOut = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DropOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;


        /**
         * Add a keyDown handler.
         * <p>
         * &#010 Executed when a key is pressed on a focusable widget ({@link com.smartgwt.client.widgets.Canvas#getCanFocus canFocus}: true). &#010 <P>&#010 Use {@link com.smartgwt.client.util.EventHandler#getKey} to find out the {@link com.smartgwt.client..KeyName} of the key that&#010 was pressed, and use {@link com.smartgwt.client.util.EventHandler#shiftKeyDown} and related functions to determine&#010 whether modifier keys were down.&#010&#010
         *
         * @param handler the keyDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addKeyDownHandler(com.smartgwt.client.widgets.events.KeyDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.KeyDownEvent.getType()) == 0) setupKeyDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.KeyDownEvent.getType());
        }
        private native void setupKeyDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({keyDown:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.KeyDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.keyDown = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.KeyDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * &#010 Executed when a key is released on a focusable widget ({@link com.smartgwt.client.widgets.Canvas#getCanFocus canFocus}: true). &#010 <P>&#010 Use {@link com.smartgwt.client.util.EventHandler#getKey} to find out the {@link com.smartgwt.client..KeyName} of the key that&#010 was pressed, and use {@link com.smartgwt.client.util.EventHandler#shiftKeyDown} and related functions to determine&#010 whether modifier keys were down.&#010&#010
         *
         * @return false to prevent this event from bubbling to this widget's parent, true or undefined to bubble.
         */
        public native Boolean keyUp() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.keyUp();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Add a keyPress handler.
         * <p>
         * &#010 Executed when a key is pressed and released on a focusable widget ({@link com.smartgwt.client.widgets.Canvas#getCanFocus canFocus}:&#010 true). &#010 <P>&#010 Use {@link com.smartgwt.client.util.EventHandler#getKey} to find out the {@link com.smartgwt.client..KeyName} of the key that&#010 was pressed, and use {@link com.smartgwt.client.util.EventHandler#shiftKeyDown} and related functions to determine&#010 whether modifier keys were down.&#010&#010
         *
         * @param handler the keyPress handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addKeyPressHandler(com.smartgwt.client.widgets.events.KeyPressHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.KeyPressEvent.getType()) == 0) setupKeyPressEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.KeyPressEvent.getType());
        }
        private native void setupKeyPressEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({keyPress:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.KeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.keyPress = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.KeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * &#010 Returns true if the widget object being dragged can be dropped on this widget, and&#010 false otherwise.  The default implementation of this method simply compares the&#010 {@link com.smartgwt.client.widgets.Canvas#getDragType dragType} of the <code>dragTarget</code> (the component being dragged from)&#010 with the list of {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} on this Canvas.  If the {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes}&#010 list contains the {@link com.smartgwt.client.widgets.Canvas#getDragType dragType} value, then this method returns true.  Otherwise it&#010 returns false.&#010&#010
         *
         * @return true if the widget object being dragged can be dropped on this widget,                      false otherwise
         */
        public native Boolean willAcceptDrop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willAcceptDrop();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * &#010 Override this method to provide a custom snap-to grid.  Note that you do not need to do&#010 this if your grid is regular (ie, grid points are every x pixels); regular grids should be &#010 defined using {@link com.smartgwt.client.widgets.Canvas#getSnapHGap snapHGap} and {@link com.smartgwt.client.widgets.Canvas#getSnapVGap snapVGap}.&#010 You should only override this method if you want to provide support for a grid of &#010 irregularly-placed points&#010&#010
         * @param coordinate x-coordinate of the drag event relative to the inside of this widget
         *
         * @return The horizontal coordinate to snap to
         */
        public native int getHSnapPosition(int coordinate) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getHSnapPosition(coordinate);
        }-*/;

        /**
         * &#010 Override this method to provide a custom snap-to grid.  Note that you do not need to do&#010 this if your grid is regular (ie, grid points are every x pixels); regular grids should be &#010 defined using {@link com.smartgwt.client.widgets.Canvas#getSnapHGap snapHGap} and {@link com.smartgwt.client.widgets.Canvas#getSnapVGap snapVGap}.&#010 You should only override this method if you want to provide support for a grid of &#010 irregularly-placed points&#010&#010
         * @param coordinate x-coordinate of the drag event relative to the inside of this widget
     * @param direction "before" or "after" denoting whether the returned coordinate should   match the left or right edge of the current square. If unset {@link com.smartgwt.client.widgets.Canvas#getSnapHDirection snapHDirection} will&#010   be used by default
         *
         * @return The horizontal coordinate to snap to
         */
        public native int getHSnapPosition(int coordinate, String direction) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getHSnapPosition(coordinate, direction);
        }-*/;

        /**
         * Override this method to provide a custom snap-to grid.  Note that you do not need to do&#010 this if your grid is regular (ie, grid points are every x pixels) - regular grids should be &#010 defined using {@link com.smartgwt.client.widgets.Canvas#getSnapHGap snapHGap} and {@link com.smartgwt.client.widgets.Canvas#getSnapVGap snapVGap}.&#010 You should only override this method if you want to provide support for a grid of &#010 irregularly-placed points&#010&#010
         * @param coordinate y-coordinate of the drag event relative to the inside of this widget
         *
         * @return The vertical coordinate to snap to
         */
        public native int getVSnapPosition(int coordinate) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVSnapPosition(coordinate);
        }-*/;

        /**
         * Override this method to provide a custom snap-to grid.  Note that you do not need to do&#010 this if your grid is regular (ie, grid points are every x pixels) - regular grids should be &#010 defined using {@link com.smartgwt.client.widgets.Canvas#getSnapHGap snapHGap} and {@link com.smartgwt.client.widgets.Canvas#getSnapVGap snapVGap}.&#010 You should only override this method if you want to provide support for a grid of &#010 irregularly-placed points&#010&#010
         * @param coordinate y-coordinate of the drag event relative to the inside of this widget
     * @param direction "before" or "after" denoting whether the returned coordinate should   match the top or bottom edge of the current square. If unset {@link com.smartgwt.client.widgets.Canvas#getSnapHDirection snapHDirection} will&#010   be used by default
         *
         * @return The vertical coordinate to snap to
         */
        public native int getVSnapPosition(int coordinate, String direction) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getVSnapPosition(coordinate, direction);
        }-*/;





        /**
         * Set the URL of an image element by name.&#010 <p>&#010 The image element must have been created from HTML generated by calling&#010 <code>canvas.imgHTML()</code> on this particular Canvas.&#010&#010
         * @param identifier name of the image to change, as originally passed to                              <code>imgHTML</code>
     * @param URL URL for the image
         */
        public native void setImage(String identifier, String URL) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setImage(identifier, URL);
        }-*/;

        /**
         * Set the URL of an image element by name.&#010 <p>&#010 The image element must have been created from HTML generated by calling&#010 <code>canvas.imgHTML()</code> on this particular Canvas.&#010&#010
         * @param identifier name of the image to change, as originally passed to                              <code>imgHTML</code>
     * @param URL URL for the image
     * @param imgDir optional image directory, overrides the default for this Canvas
         */
        public native void setImage(String identifier, String URL, String imgDir) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setImage(identifier, URL, imgDir);
        }-*/;

        /**
         * Generates the HTML for a standard link element&#010&#010
         * @param href URL for the link to point to
         *
         * @return HTML for the link
         */
        public native String linkHTML(String href) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.linkHTML(href);
        }-*/;

        /**
         * Generates the HTML for a standard link element&#010&#010
         * @param href URL for the link to point to
     * @param text Text to for the link (defaults to the href)
     * @param target Target window for the link (defaults to opening in a new, unnamed window)
     * @param ID optional ID for the link element to be written out
     * @param tabIndex optional tabIndex for the link
     * @param accessKey optional accessKey for the link
         *
         * @return HTML for the link
         */
        public native String linkHTML(String href, String text, String target, String ID, int tabIndex, String accessKey) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.linkHTML(href, text, target, ID, tabIndex, accessKey);
        }-*/;



        /**
         * Add a focusChanged handler.
         * <p>
         * Notification function fired when this widget recieves or loses keyboard focus.&#010
         *
         * @param handler the focusChanged handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFocusChangedHandler(com.smartgwt.client.widgets.events.FocusChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.FocusChangedEvent.getType()) == 0) setupFocusChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.FocusChangedEvent.getType());
        }
        private native void setupFocusChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({focusChanged:function(){
                        var param = {"hasFocus" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.events.FocusChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.focusChanged = function(){
                    var param = {"hasFocus" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.FocusChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************


        /**
         * Retrieve a Canvas by it's global {@link com.smartgwt.client.widgets.Canvas#getID ID}.&#010
         * @param ID global ID of the Canvas
         *
         * @return the Canvas, or null if not found
         */
        public static native Canvas getById(String ID) /*-{
            var ret = $wnd.isc.Canvas.getById(ID);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;








    public void setVisible(boolean visible) {
        setVisibility(visible ? Visibility.VISIBLE : Visibility.HIDDEN);   
    }

    /**
     * Size for this component's vertical dimension. <P> Can be a number of pixels, or a percentage like "50%". See
     * documentation for {@link com.smartgwt.client.widgets.Canvas#getWidth width} for details on who percentage values
     * are resolved actual size. <P> Note that if {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} is set
     * to "visible", this size is a minimum, and the component may overflow to show all content and/or children. <P> If
     * trying to establish a default height for a custom component, set {@link com.smartgwt.client.widgets.Canvas#getDefaultHeight
     * defaultHeight} instead. Resizes the widget vertically to the specified height (moves the bottom side of the
     * widget). The height parameter can be expressed as a percentage of viewport size or as the number of pixels. <P>
     * NOTE: if you're setting multiple coordinates, use resizeTo() or setRect() instead
     *
     * @param height new height. Default value is null
     */
    public void setHeight(int height) {
        setAttribute("height", height, true);
    }

    /**
     * Convenience method that sets the height to 100%.
     */
    public void setHeight100() {
        setHeight("100%");
    }

    /**
     * Convenience method that sets the width to 100%.
     */
    public void setWidth100() {
        setWidth("100%");
    }

    public void setHeight(String height) {
        setAttribute("height", height, true);
    }

    public Integer getHeight() {
        return getAttributeAsInt("height");
    }

    public String getHeightAsString() {
        return getAttribute("height");
    }

    /**
     * Synonmy for {@link #setPrompt(String)}
     *
     * @param title the title
     */
    public void setTitle(String title) {
        setPrompt(title);
    }

    /**
     * Synonmy for {@link #getPrompt()}
     *
     * @return the title
     */
    public String getTitle() {
        return getPrompt();
    }

    /**
     * Synonmy for {@link #setPrompt(String)}
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        setPrompt(tooltip);
    }

    /**
     * Synonmy for {@link #getPrompt()}
     *
     * @return  the tooltip
     */
    public String getTooltip() {
        return getPrompt();
    }   

    /**
     * Size for this component's horizontal dimension. <P> Can be a number of pixels, or a percentage like "50%".
     * Percentage sizes are resolved to pixel values as follows: <UL> <LI>If a canvas has a specified {@link
     * com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, sizing will be     a percentage of the size
     * of that widget (see also {@link com.smartgwt.client.widgets.Canvas#getPercentBox percentBox}).</LI>
     * <LI>Otherwise, if a canvas has a {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement}, and
     *   {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is set for the widget, sizing will be a percentage
     * of     the size of that widget (see also {@link com.smartgwt.client.widgets.Canvas#getPercentBox
     * percentBox}).</LI> <LI>Otherwise if this is a child of some other canvas, percentages will be based on the
     * inner size of the {@link com.smartgwt.client.widgets.Canvas#getParentElement parentElement}'s viewport.</LI>
     * <LI>Otherwise, for top level widgets, sizing is calculated as a percentage of page size.</LI> </UL> <P> {@link
     * com.smartgwt.client.widgets.layout.Layout} may specially interpret percentage sizes on their children, and also
     * allow "*" as a size. <P> Note that if {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} is set to
     * "visible", this size is a minimum, and the component may overflow to show all content and/or children. <P> If
     * trying to establish a default width for a custom component, set {@link com.smartgwt.client.widgets.Canvas#getDefaultWidth
     * defaultWidth} instead. Resizes the widget horizontally to the specified width (moves the right side of the
     * widget). The width parameter can be expressed as a percentage of viewport size or as the number of pixels. <P>
     * NOTE: if you're setting multiple coordinates, use resizeTo() or setRect() instead
     *
     * @param width new width. Default value is null
     */
    public void setWidth(int width) {
        setAttribute("width", width, true);
    }

    /**
     * Size for this component's horizontal dimension. <P> Can be a number of pixels, or a percentage like "50%".
     * Percentage sizes are resolved to pixel values as follows: <UL> <LI>If a canvas has a specified {@link
     * com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, sizing will be     a percentage of the size
     * of that widget (see also {@link com.smartgwt.client.widgets.Canvas#getPercentBox percentBox}).</LI>
     * <LI>Otherwise, if a canvas has a {@link com.smartgwt.client.widgets.Canvas#getMasterElement masterElement}, and
     *   {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is set for the widget, sizing will be a percentage
     * of     the size of that widget (see also {@link com.smartgwt.client.widgets.Canvas#getPercentBox
     * percentBox}).</LI> <LI>Otherwise if this is a child of some other canvas, percentages will be based on the
     * inner size of the {@link com.smartgwt.client.widgets.Canvas#getParentElement parentElement}'s viewport.</LI>
     * <LI>Otherwise, for top level widgets, sizing is calculated as a percentage of page size.</LI> </UL> <P> {@link
     * com.smartgwt.client.widgets.layout.Layout} may specially interpret percentage sizes on their children, and also
     * allow "*" as a size. <P> Note that if {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} is set to
     * "visible", this size is a minimum, and the component may overflow to show all content and/or children. <P> If
     * trying to establish a default width for a custom component, set {@link com.smartgwt.client.widgets.Canvas#getDefaultWidth
     * defaultWidth} instead. Resizes the widget horizontally to the specified width (moves the right side of the
     * widget). The width parameter can be expressed as a percentage of viewport size or as the number of pixels. <P>
     * NOTE: if you're setting multiple coordinates, use resizeTo() or setRect() instead
     *
     * @param width new width. Default value is null
     */
    public void setWidth(String width) {
        setAttribute("width", width, true);
    }

    public Integer getWidth() {
        return getAttributeAsInt("width");
    }

    public String getWidthAsString() {
        return getAttribute("width");
    }


    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue(), true);
    }

    public int getAbsoluteLeft() {
        return getPageLeft();
    }

    public int getAbsoluteTop() {
        return getPageTop();
    }

    /**
     * Offset of the shadow.  Defaults to half of <code>shadowDepth</code> if unset. <P> Because of the blurred edges, a
     * shadow is larger than the originating component by 2xsoftness.  An <code>shadowOffset</code> of 0 means that the
     * shadow will extend around the originating component equally in all directions. <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param shadowOffset shadowOffset Default value is null
     */
    public void setShadowOffset(Integer shadowOffset) {
        setAttribute("shadowOffset", shadowOffset, true);
    }

    /**
     * Offset of the shadow.  Defaults to half of <code>shadowDepth</code> if unset. <P> Because of the blurred edges, a
     * shadow is larger than the originating component by 2xsoftness.  An <code>shadowOffset</code> of 0 means that the
     * shadow will extend around the originating component equally in all directions.
     *
     * @return Integer
     */
    public Integer getShadowOffset() {
        return getAttributeAsInt("shadowOffset");
    }

    /**
     * Softness, or degree of blurring, of the shadow. <P> A shadow with <code>softness:x</code> is 2x pixels larger in
     * each direction than the element throwing the shadow, and the media for each edge should be x pixels wide/tall.
     * <P> Defaults to <code>shadowDepth</code> if unset. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param shadowSoftness shadowSoftness Default value is null
     */
    public void setShadowSoftness(Integer shadowSoftness) {
        setAttribute("shadowSoftness", shadowSoftness, true);
    }

    /**
     * Softness, or degree of blurring, of the shadow. <P> A shadow with <code>softness:x</code> is 2x pixels larger in
     * each direction than the element throwing the shadow, and the media for each edge should be x pixels wide/tall.
     * <P> Defaults to <code>shadowDepth</code> if unset.
     *
     * @return Integer
     */
    public Integer getShadowSoftness() {
        return getAttributeAsInt("shadowSoftness");
    }

    /**
     * Set the groupTitle.
     *
     * @param groupTitle the groupTitle
     */
    public void setGroupTitle(String groupTitle) {
        setAttribute("groupTitle", groupTitle, true);
    }

    /**
     * Return the groupTitle.
     *
     * @return the groupTitle
     */
    public String getGroupTitle() {
        return getAttribute("groupTitle");
    }

    /**
     * Set the isGroup.
     *
     * @param isGroup the isGroup
     */
    public void setIsGroup(Boolean isGroup) {
        setAttribute("isGroup", isGroup, true);
    }

    /**
     * Return the isGroup.
     *
     * @return the isGroup
     */
    public Boolean getIsGroup() {
        return getAttributeAsBoolean("isGroup");
    }


    public void setSmoothFade(Boolean smoothFade) throws IllegalStateException {
        setAttribute("smoothFade", smoothFade, false);
    }

    public void setKeepInParentRect(Boolean keepInParentRect) {
        setAttribute("keepInParentRect", keepInParentRect, true);
    }


    public void setKeepInParentRect(Rectangle rectangle) {
        setAttribute("keepInParentRect", rectangle.getAsJSArray(), true);
    }

    public void setPrefix(String prefix) {
        setAttribute("prefix", prefix, true);
    }

    public String getPrefix() {
        return getAttribute("prefix");
    }

    public void setResizeFrom(String... resizeFrom) {
        setAttribute("resizeFrom", resizeFrom, true);
    }

    public void setEdgeMarginSize(int edgeMarginSize) {
        setAttribute("edgeMarginSize", edgeMarginSize, true);
    }

    /**
     * When this Canvas is included as a member in a Layout, layoutAlign controls alignment on the&#010 breadth axis of
     * the layout.  Default is "left" for a VLayout, "top" for an HLayout.
     *
     * @param layoutAlign layoutAlign Default valaue is null
     * @throws IllegalStateException this property cannot be changed after the component has been rendered
     */
    public void setLayoutAlign(Alignment layoutAlign) throws IllegalStateException {
        setAttribute("layoutAlign", layoutAlign.getValue(), false);
    }

    /**
     * When this Canvas is included as a member in a Layout, layoutAlign controls alignment on the&#010 breadth axis of
     * the layout.  Default is "left" for a VLayout, "top" for an HLayout.
     *
     * @param layoutAlign layoutAlign Default valaue is null
     * @throws IllegalStateException this property cannot be changed after the component has been rendered
     */
    public void setLayoutAlign(VerticalAlignment layoutAlign) throws IllegalStateException {
        setAttribute("layoutAlign", layoutAlign.getValue(), false);
    }

    /**
     * The "type" of thing(s) that can be dropped on this widget specified as a string or an array of strings
     * (indicating multiple types). Leave this with the value null to indicate that this widget can accept anything
     * dropped on it from the page. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dropTypes dropTypes Default value is Canvas.ANYTHING
     */
    public void setDropTypes(String... dropTypes) {
        setAttribute("dropTypes", dropTypes, true);
    }

/*
    public void setParentElement(Canvas parentElement) {
        setAttribute("parentElement", parentElement.getOrCreateJsObj(), true);
    }

     */


    /**
     * Moves the widget so that its top-left corner is at the specified coordinates. This method will also accept a
     * single parameter as an object array with left and top given as properties.
     *
     * @param left x-coordinate to move to in LOCAL coordinates
     * @param top  y-coordinate to move to in LOCAL coordinates
     * @return whether the component actually moved
     */
    public native boolean moveTo(int left, int top) /*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.moveTo(left, top);
    }-*/;

    /**
     * Scroll this widget by some percentage of scroll size in either (or both) direction(s).
     *
     * @param dX Percentage to scroll horizontally.
     * @param dY Percentage to scroll vertically.
     */
    public native void scrollByPercent(int dX, int dY) /*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.scrollByPercent(dX, dY);
    }-*/;

    /**
     * Scroll this widget to some position specified as a percentage of scroll size in either (or both) direction(s).
     *
     * @param left left Percentage position to scroll to
     * @param top  top Percentage position to scroll to
     */
    public native void scrollToPercent(int left, int top) /*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return widget.scrollToPercent(left, top);
    }-*/;

    /**
     * Returns true if the widget is visible, taking all parents into account, so that a widget which is not hidden
     * might still report itself as not visible if it is within a hidden parent. <P> NOTE: Undrawn widgets will
     * report themselves as visible if they would be visible if drawn.
     *
     * @return true if the widget is visible, false otherwise
     */
    public native boolean isVisible() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.isVisible();
        }-*/;


    /**
     * Animate a reposition of this canvas from its current position to the specified position
     *
     * @param left new left position (or null for unchanged)
     * @param top  new top position (or null for unchanged)
     */
    public native void animateMove(int left, int top) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateMove(left, top);
    }-*/;

    /**
     * Animate a reposition of this canvas from its current position to the specified position
     *
     * @param left     new left position (or null for unchanged)
     * @param top      new top position (or null for unchanged)
     * @param callback When the move completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     */
    public native void animateMove(int left, int top, AnimationCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateMove(left, top, function(earlyFinish) {
             earlyFinish = earlyFinish === undefined ? false : earlyFinish;
             if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Animate a reposition of this canvas from its current position to the specified position
     *
     * @param left     new left position (or null for unchanged)
     * @param top      new top position (or null for unchanged)
     * @param callback When the move completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     * @param duration Duration in ms of the animated move
     */
    public native void animateMove(int left, int top, AnimationCallback callback, int duration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateMove(left, top, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Animate a reposition of this canvas from its current position to the specified position
     *
     * @param left         new left position (or null for unchanged)
     * @param top          new top position (or null for unchanged)
     * @param callback     When the move completes this callback will be fired. Single
     *                     'earlyFinish' parameter will be passed if the animation was                              cut
     *                     short by a call to finishAnimation
     * @param duration     Duration in ms of the animated move
     * @param acceleration Optional acceleration effect to bias the ratios
     */
    public native void animateMove(int left, int top, AnimationCallback callback, int duration, AnimationAcceleration acceleration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateMove(left, top, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration, acceleration == null ? null : acceleration.@com.smartgwt.client.types.ValueEnum::getValue()());
    }-*/;

    /**
     * Animate a scroll from the current scroll position to the specified position.
     *
     * @param scrollLeft desired final left scroll postion
     * @param scrollTop  desired final top scroll postion
     */
    public native void animateScroll(int scrollLeft, int scrollTop) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateScroll(scrollLeft, scrollTop);
    }-*/;

    /**
     * Animate a scroll from the current scroll position to the specified position.
     *
     * @param scrollLeft desired final left scroll postion
     * @param scrollTop  desired final top scroll postion
     * @param callback   When the scroll completes this callback will be fired. Single
     *                   'earlyFinish' parameter will be passed if the animation was                              cut
     *                   short by a call to finishAnimation
     */
    public native void animateScroll(int scrollLeft, int scrollTop, AnimationCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateScroll(scrollLeft, scrollTop, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Animate a scroll from the current scroll position to the specified position.
     *
     * @param scrollLeft desired final left scroll postion
     * @param scrollTop  desired final top scroll postion
     * @param callback   When the scroll completes this callback will be fired. Single
     *                   'earlyFinish' parameter will be passed if the animation was                              cut
     *                   short by a call to finishAnimation
     * @param duration   Duration in ms of the animated scroll
     */
    public native void animateScroll(int scrollLeft, int scrollTop, AnimationCallback callback, int duration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateScroll(scrollLeft, scrollTop, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Animate a reposition / resize of this canvas from its current size and postion.
     *
     * @param left   new left position (or null for unchanged)
     * @param top    new top position (or null for unchanged)
     * @param width  new width (or null for unchanged)
     * @param height new height (or null for unchanged)
     */
    public native void animateRect(int left, int top, int width, int height) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateRect(left, top, width, height);
    }-*/;

    /**
     * Animate a reposition / resize of this canvas from its current size and postion.
     *
     * @param left     new left position (or null for unchanged)
     * @param top      new top position (or null for unchanged)
     * @param width    new width (or null for unchanged)
     * @param height   new height (or null for unchanged)
     * @param callback When the setRect completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     */
    public native void animateRect(int left, int top, int width, int height, AnimationCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateRect(left, top, width, height, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Animate a reposition / resize of this canvas from its current size and postion.
     *
     * @param left     new left position (or null for unchanged)
     * @param top      new top position (or null for unchanged)
     * @param width    new width (or null for unchanged)
     * @param height   new height (or null for unchanged)
     * @param callback When the setRect completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     * @param duration Duration in ms of the animated setRect
     */
    public native void animateRect(int left, int top, int width, int height, AnimationCallback callback, int duration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateRect(left, top, width, height, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Animate a resize of this canvas from its current size to the specified size
     *
     * @param width  new width (or null for unchanged)
     * @param height new height (or null for unchanged)
     */
    public native void animateResize(int width, int height) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateResize(width, height);
    }-*/;

    /**
     * Animate a resize of this canvas from its current size to the specified size
     *
     * @param width    new width (or null for unchanged)
     * @param height   new height (or null for unchanged)
     * @param callback When the resize completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     */
    public native void animateResize(int width, int height, AnimationCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateResize(width, height, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Animate a resize of this canvas from its current size to the specified size
     *
     * @param width    new width (or null for unchanged)
     * @param height   new height (or null for unchanged)
     * @param callback When the resize completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     * @param duration Duration in ms of the animated resize
     */
    public native void animateResize(int width, int height, AnimationCallback callback, int duration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateResize(width, height, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;


    /**
     * Animate a change in opacity from the widget's current opacity to the specified opacity.
     *
     * @param opacity desired final opacity
     */
    public native void animateFade(int opacity) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateFade(opacity);
    }-*/;

    /**
     * Animate a change in opacity from the widget's current opacity to the specified opacity.
     *
     * @param opacity  desired final opacity
     * @param callback When the fade completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     */
    public native void animateFade(int opacity, AnimationCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateFade(opacity, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Animate a change in opacity from the widget's current opacity to the specified opacity.
     *
     * @param opacity  desired final opacity
     * @param callback When the fade completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation
     * @param duration Duration in ms of the animated fade
     */
    public native void animateFade(int opacity, AnimationCallback callback, int duration) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateFade(opacity, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Hide a canvas by shrinking it vertically to zero height over a period of time. This method will not fire if the
     * widget is already drawn and visible, or has overflow other than <code>"visible"</code> or <code>"hidden"</code>.
     *
     * @param effect How should the content of the  window be hidden during the hide? If ommitted, default behavior can
     *               be configured via  {@link com.smartgwt.client.widgets.Canvas#getAnimateHideEffect
     *               animateHideEffect}
     */
    public native void animateHide(AnimationEffect effect) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateHide(effectVal);
    }-*/;

    /**
     * Hide a canvas by shrinking it vertically to zero height over a period of time. This method will not fire if the
     * widget is already drawn and visible, or has overflow other than <code>"visible"</code> or <code>"hidden"</code>.
     *
     * @param effect   How should the content of the  window be hidden during the hide? If ommitted, default behavior
     *                 can be configured via  {@link com.smartgwt.client.widgets.Canvas#getAnimateHideEffect
     *                 animateHideEffect}
     * @param callback When the hide completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation.
     */
    public native void animateHide(AnimationEffect effect, AnimationCallback callback) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateHide(effectVal, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Hide a canvas by shrinking it vertically to zero height over a period of time. This method will not fire if the
     * widget is already drawn and visible, or has overflow other than <code>"visible"</code> or <code>"hidden"</code>.
     *
     * @param effect   How should the content of the  window be hidden during the hide? If ommitted, default behavior
     *                 can be configured via  {@link com.smartgwt.client.widgets.Canvas#getAnimateHideEffect
     *                 animateHideEffect}
     * @param callback When the hide completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation.
     * @param duration Duration in ms of the animated hide.  If unset, duration will be   picked up from {@link
     *                 com.smartgwt.client.widgets.Canvas#getAnimateHideTime animateHideTime}
     */
    public native void animateHide(AnimationEffect effect, AnimationCallback callback, int duration) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateHide(effectVal, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Show a canvas by growing it vertically to its fully drawn height over a period of time. This method will not fire
     * if the widget is already drawn and visible, or has overflow other than <code>"visible"</code> or
     * <code>"hidden"</code>.
     *
     * @param effect Animation effect to use      when revealing the widget. If ommitted, default behavior can be
     *               configured via      {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect
     *               animateShowEffect}
     */
    public native void animateShow(AnimationEffect effect) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateShow(effectVal);
    }-*/;

    /**
     * Show a canvas by growing it vertically to its fully drawn height over a period of time. This method will not fire
     * if the widget is already drawn and visible, or has overflow other than <code>"visible"</code> or
     * <code>"hidden"</code>.
     *
     * @param effect   Animation effect to use      when revealing the widget. If ommitted, default behavior can be
     *                 configured via      {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect
     *                 animateShowEffect}
     * @param callback When the show completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation.
     */
    public native void animateShow(AnimationEffect effect, AnimationCallback callback) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateShow(effectVal, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        });
    }-*/;

    /**
     * Show a canvas by growing it vertically to its fully drawn height over a period of time. This method will not fire
     * if the widget is already drawn and visible, or has overflow other than <code>"visible"</code> or
     * <code>"hidden"</code>.
     *
     * @param effect   Animation effect to use      when revealing the widget. If ommitted, default behavior can be
     *                 configured via      {@link com.smartgwt.client.widgets.Canvas#getAnimateShowEffect
     *                 animateShowEffect}
     * @param callback When the show completes this callback will be fired. Single
     *                 'earlyFinish' parameter will be passed if the animation was                              cut
     *                 short by a call to finishAnimation.
     * @param duration Duration in ms of the animated show. If unset, duration will be   picked up from {@link
     *                 com.smartgwt.client.widgets.Canvas#getAnimateShowTime animateShowTime}
     */
    public native void animateShow(AnimationEffect effect, AnimationCallback callback, int duration) /*-{
        var effectVal = effect.@com.smartgwt.client.types.AnimationEffect::getValue()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.animateShow(effectVal, function(earlyFinish) {
            earlyFinish = earlyFinish === undefined ? false : earlyFinish;
            if(callback != null) callback.@com.smartgwt.client.widgets.AnimationCallback::execute(Z)(earlyFinish);
        }, duration);
    }-*/;

    /**
     * Update teh canvas shadow.
     */
    public native void updateShadow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateShadow();
    }-*/;

    /**
     * Get the z-Index of this canvas.
     *
     * @return the zIndex
     */
    public native int getZIndex() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getZIndex(true);
    }-*/;

    /**
     * get the next zIndex for the next item to be drawn. see setZIndex() for notes
     *
     * @return the next zIndex
     */
    public native int getNextZIndex() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getNextZIndex();
    }-*/;

    /**
     * Set the z-Index of the canvas.
     *
     * @param newIndex the new  zIndex to set to
     */
    public native void setZIndex(int newIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setZIndex(newIndex);
    }-*/;


    /**
     * The background color for this widget. It corresponds to the CSS background-color attribute. You can set this
     * property to an RGB value (e.g. #22AAFF) or a named color (e.g. red) from a list of browser supported color names.
     * Sets the background color of this widget to newColor.
     *
     * @param backgroundColor new color to set the widget's background to. Default value is null
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor, true);
    }

    public native Rectangle getPageRect() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var rect = self.getPageRect();
        return @com.smartgwt.client.core.Rectangle::new(IIII)(rect[0], rect[1],rect[2],rect[3]);
    }-*/;


    /**
     * Set all four coordinates, relative to the enclosing context, at once. <P> Moves the widget so that its top-left
     * corner is at the specified top-left coordinates, then resizes it to the specified width and height.
     *
     * @param rectangle new coordinates
     */
    public void setRect(Rectangle rectangle) {
        setRect(rectangle.getLeft(), rectangle.getTop(), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * Set all four coordinates, relative to the enclosing context, at once. <P> Moves the widget so that its top-left
     * corner is at the specified top-left coordinates, then resizes it to the specified width and height.
     *
     * @param left   new left coordinate, Array of coordinates                                                  in
     *               parameter order, or Object with left,                                                  top, width,
     *               height properties.  If an Array                                                  or Object is
     *               passed, the remaining                                                  parameters are ignored
     * @param top    new top coordinate
     * @param width  new width
     * @param height new height
     */
    public native void setRect(int left, int top, int width, int height) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRect(left, top, width, height);
    }-*/;

    /**
     * Get all four coordinates, relative to the enclosing context, at one.
     *
     * @return the Rectangle
     */
    public native Rectangle getRect() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var rect = self.getRect();
        return @com.smartgwt.client.core.Rectangle::new(IIII)(rect[0], rect[1],rect[2],rect[3]);
    }-*/;


    /**
     * Return the full URL for an image to be drawn in this canvas. <P> If the passed URL begins with the special
     * prefix "[SKIN]", it will have the widget.skinImgDir and Page.skinImgDir prepended.  Otherwise the image is
     * assumed to be application-specific, and will have the widget.appImgDir and Page.appImgDir automatically
     * prepended. <P> Note that if passed an absolute path (starting with "/" or "http://" for example), no extra
     * image directory information will be prepended to the generated URL.//
     *
     * @param URL URL local to skin or application image directory
     * @return URL to use
     */
    public static native String getImgURL(String URL) /*-{
            return $wnd.isc.Canvas.getImgURL(URL);
        }-*/;

    /**
     * Return the full URL for an image to be drawn in this canvas. <P> If the passed URL begins with the special
     * prefix "[SKIN]", it will have the widget.skinImgDir and Page.skinImgDir prepended.  Otherwise the image is
     * assumed to be application-specific, and will have the widget.appImgDir and Page.appImgDir automatically
     * prepended. <P> Note that if passed an absolute path (starting with "/" or "http://" for example), no extra
     * image directory information will be prepended to the generated URL.//
     *
     * @param URL    URL local to skin or application image directory
     * @param imgDir optional image directory to override the default for this Canvas
     * @return URL to use
     */
    public static native String getImgURL(String URL, String imgDir) /*-{
            return $wnd.isc.Canvas.getImgURL(URL, imgDir);
        }-*/;

    /**
     * Generates the HTML for an image unique to this Canvas. <P> The full URL for the image will be formed
     * according to the rules documented for <code>{@link com.smartgwt.client.widgets.Canvas#getImgURL}</code>. <P>
     * The created image will have an identifier unique to this Canvas, and subsequent calls to <code>{@link
     * com.smartgwt.client.widgets.Canvas#getImage}</code> and <code>{@link com.smartgwt.client.widgets.Canvas#setImage}</code>
     *  with the name passed to this function will act on the image object produced by the HTML returned from this
     * call.
     *
     * @param src URL local to the skin or application directory.<br>  NOTE: instead of passing several parameters,
     *            you can pass an object as the 'src'      parameter with properties for all the various function
     *            parameters with, eg:<br>      canvas.imgHTML( {src:"foo", width:10, height:10} );
     * @return HTML to draw the image.
     */
    public static native String imgHTML(String src) /*-{
            return $wnd.isc.Canvas.imgHTML(src);
        }-*/;

    /**
     * Generates the HTML for an image unique to this Canvas. <P> The full URL for the image will be formed
     * according to the rules documented for <code>{@link com.smartgwt.client.widgets.Canvas#getImgURL}</code>. <P>
     * The created image will have an identifier unique to this Canvas, and subsequent calls to <code>{@link
     * com.smartgwt.client.widgets.Canvas#getImage}</code> and <code>{@link com.smartgwt.client.widgets.Canvas#setImage}</code>
     *  with the name passed to this function will act on the image object produced by the HTML returned from this
     * call.
     *
     * @param src        URL local to the skin or application directory.<br>  NOTE: instead of passing several
     *                   parameters, you can pass an object as the 'src'      parameter with properties for all the
     *                   various function parameters with, eg:<br>      canvas.imgHTML( {src:"foo", width:10,
     *                   height:10} );
     * @param width      width of the image
     * @param height     height of the image
     * @param name       name for the image
     * @param extraStuff additional attributes to write in the tag
     * @param imgDir     image-specific image directory to override the default                                  for
     *                   this Canvas
     * @return HTML to draw the image.
     */
    public static native String imgHTML(String src, int width, int height, String name, String extraStuff, String imgDir) /*-{
            return $wnd.isc.Canvas.imgHTML(src, width, height, name, extraStuff, imgDir);
        }-*/;

    public static native String imgHTML(String src, int width, int height) /*-{
         return $wnd.isc.Canvas.imgHTML(src, width, height);
     }-*/;


    /**
     * Returns the scrollTop required to scroll vertically to the end of this widget's content.
     */
    public native int getScrollBottom() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollBottom();
        }-*/;

    /**
     * Returns the scrollLeft required to scroll horizontally to the end of this widget's content.
     */
    public native int getScrollRight() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getScrollRight();
        }-*/;


    /**
     * Show a PrintWindow containing a printable view of the components passed in components to get the print HTML
     * for.
     *
     * @param component
     */
    public static native void showPrintPreview(Canvas component) /*-{
         var componentJS = component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return $wnd.isc.Canvas.showPrintPreview(componentJS);
     }-*/;


    /**
     * This Canvas's immediate parent, if any. <BR> Can be initialized, but any subsequent manipulation should be via
     * {@link com.smartgwt.client.widgets.Canvas#addChild} and {@link com.smartgwt.client.widgets.Canvas#removeChild}
     * calls on the parent. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentElement parentElement Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setParentElement(Canvas parentElement) throws IllegalStateException {
        setAttribute("parentElement", parentElement.getOrCreateJsObj(), false);
    }

    /**
     * This Canvas's immediate parent, if any. <BR> Can be initialized, but any subsequent manipulation should be via
     * {@link com.smartgwt.client.widgets.Canvas#addChild} and {@link com.smartgwt.client.widgets.Canvas#removeChild}
     * calls on the parent.
     *
     * @return Canvas
     */
    public Canvas getParentElement() {
        JavaScriptObject parentJS = getAttributeAsJavaScriptObject("parentElement");
        Canvas canvas = (Canvas) BaseWidget.getRef(parentJS);
        if (canvas == null) {
            canvas = new Canvas(parentJS);
        }
        return canvas;
    }

    /**
     * Adds newChild as a child of this widget, set up a named object reference (i.e., this[name]) to the new widget if
     * name argument is provided, and draw the child if this widget has been drawn already. <P> If newChild has a parent
     * it will be removed from it. If it has a master, it will be detached from it if the master is a child of a
     * different parent. If newChild has peers, they'll be added to this widget as children as well.
     *
     * @param newChild new child canvas to add
     */
    public void addChild(Widget widget) {
        if (widget instanceof Canvas) {
            addChild((Canvas) widget);
        } else {
            addChild(new WidgetCanvas(widget));
        }
    }

    /**
     * Array of all Canvii that are immediate children of this Canvas. <p><b>Note : </b> This is an advanced
     * setting</p>
     *
     * @param children children Default value is null
     */
    public void setChildren(Canvas... children) {
        setAttribute("children", children, true);
    }

    /**
     * Array of all Canvii that are immediate children of this Canvas. <p><b>Note : </b> This is an advanced
     * setting</p>
     */
    public Canvas[] getChildren() {
        return convertToCanvasArray(getAttributeAsJavaScriptObject("children"));
    }

    protected static Canvas[] convertToCanvasArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Canvas[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        Canvas[] objects = new Canvas[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            Canvas obj = (Canvas) BaseWidget.getRef(componentJS);
            if (obj == null) {
                obj = new Canvas(componentJS);
            }
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Remove a child from its parent if it has one.
     *
     * @param child Child canvas to remove from this parent.
     */
    public native void removeChild(Canvas child) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var childJS= child.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeChild(childJS);
    }-*/;

/**
 * Remove a child from its parent if it has one.
 *
 * @param child Child canvas to remove from this parent.
 * @param name  If the child canvas was assigned a name, it should be passed in here                          to
 *              ensure this[name] is cleared
 */
    public native void removeChild(Canvas child, String name) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var childJS= child.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeChild(childJS, name);
    }-*/;


    public int getOffsetHeight() {
        return getVisibleHeight();
    }

    public int getOffsetWidth() {
        return getVisibleWidth();
    }

    public void setAutoHeight() {
        setHeight(1);
    }

    public void setAutoWidth() {
        setWidth(1);
    }

    /**
     * Add a onDrop handler.
     * <p>
     * Notification method fired when the user drops another canvas onto this one. Returning&#010 <code>false</code> from this method will prevent any default drop behavior from occurring&#010
     *
     * @param handler the onDrop handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropHandler(com.smartgwt.client.widgets.events.DropHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.DropEvent.getType()) == 0) setupDropEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.DropEvent.getType());
    }
    private native void setupDropEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onDrop:function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.DropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onDrop = function(){
                var param = {};
                var event = @com.smartgwt.client.widgets.events.DropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            };
        }
    }-*/;

}



