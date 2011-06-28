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
 
package com.smartgwt.client.widgets.layout;



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
 * A subclass of Canvas that automatically arranges other Canvases according to a layout policy. <br><br> A Layout manages
 * a set of "member" Canvases initialized via the "members" property.  Layouts can have both "members", which are managed
 * by the Layout, and normal Canvas children, which are unmanaged. <br><br> Rather than using the Layout class directly,
 * use the HLayout, VLayout, HStack and VStack classes, which are subclasses of Layout preconfigured for horizontal or
 * vertical stacking, with the "fill" (VLayout) or "none" (VStack) {@link com.smartgwt.client.types.LayoutPolicy policies}
 * already set. <br><br> Layouts and Stacks may be nested to create arbitrarily complex layouts. <br><br> To show a resizer
 * bar after (to the right or bottom of) a layout member, set showResizeBar to true on that member component (not on the
 * HLayout or VLayout).  Resizer bars override membersMargin spacing. <br><br>  Like other Canvas subclasses, Layout and
 * Stack components may have % width and height values. To create a dynamically-resizing layout that occupies the entire
 * page (or entire parent component), set width and height to "100%".
 * @see com.smartgwt.client.types.LayoutPolicy
 * @see com.smartgwt.client.widgets.layout.VLayout
 * @see com.smartgwt.client.widgets.layout.HLayout
 * @see com.smartgwt.client.widgets.layout.VStack
 * @see com.smartgwt.client.widgets.layout.HStack
 * @see com.smartgwt.client.widgets.layout.LayoutSpacer
 */
public class Layout extends Canvas {

    public static Layout getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Layout) obj;
        } else {
            return new Layout(jsObj);
        }
    }

    public Layout(){
        scClassName = "Layout";
    }

    public Layout(JavaScriptObject jsObj){
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
     * If true when members are added / removed, they should be animated as they are shown or hidden in position
     *
     * @param animateMembers animateMembers Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_layout" target="examples">Layout Add & Remove Example</a>
     */
    public void setAnimateMembers(Boolean animateMembers) {
        setAttribute("animateMembers", animateMembers, true);
    }

    /**
     * If true when members are added / removed, they should be animated as they are shown or hidden in position
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_layout" target="examples">Layout Add & Remove Example</a>
     */
    public Boolean getAnimateMembers()  {
        return getAttributeAsBoolean("animateMembers");
    }

    /**
     * If specified this is the duration of show/hide animations when members are being shown or hidden due to being added /
     * removed from this layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateMemberTime animateMemberTime Default value is null
     */
    public void setAnimateMemberTime(Integer animateMemberTime) {
        setAttribute("animateMemberTime", animateMemberTime, true);
    }

    /**
     * If specified this is the duration of show/hide animations when members are being shown or hidden due to being added /
     * removed from this layout.
     *
     *
     * @return Integer
     */
    public Integer getAnimateMemberTime()  {
        return getAttributeAsInt("animateMemberTime");
    }

    /**
     * Layouts provide a default implementation of a drag and drop interaction.  If you set
     *  {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop}:true and <code>canDropComponents:true</code>
     * on a Layout, when a droppable Canvas ({@link com.smartgwt.client.widgets.Canvas#getCanDrop canDrop:true} is dragged over
     *  the layout will show a dropLine (a simple insertion line) at the drop location.  
     *  <P>
     *  When the drop occurs, the dragTarget (obtained using
     * {@link com.smartgwt.client.util.EventHandler#getDragTarget EventHandler.getDragTarget}) is added as a member of this
     * layout at the location
     * shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition
     * Layout.getDropPosition}).  This default
     *  behavior allows either members or external components that have
     * {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition canDragReposition} (or {@link
     * com.smartgwt.client.widgets.Canvas#getCanDrag canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop
     * canDrop} set
     *  to <code>true</code> to be added to or reordered within the Layout.
     *  <P>
     * You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness
     * dropLineThickness} and
     *  you can customize the style using css styling in the skin file (look for .layoutDropLine in
     *  skin_styles.css for your skin).  
     *  <P>  
     *  If you want to dynamically create a component to be added to the Layout in response to a
     *  drop event you can do so as follows: 
     *  <pre>
     *  isc.VLayout.create({
     *    ...various layout properties...
     *    canDropComponents: true,
     *    drop : function () {
     *      // create the new component 
     *      var newMember = isc.Canvas.create(); 
     *      // add to the layout at the current drop position 
     *      // (the dropLine will be showing here)
     *      this.addMember(newMember, this.getDropPosition());  
     *      // hide the dropLine that was automatically shown 
     *      // by builtin Smart GWT methods
     *      this.hideDropLine();
     *    }
     *  });
     *  </pre>
     *  If you want to completely suppress the builtin drag and drop logic, but still receive drag
     * and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop
     * canAcceptDrop} to
     *  <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDropComponents canDropComponents Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setCanDropComponents(Boolean canDropComponents)  throws IllegalStateException {
        setAttribute("canDropComponents", canDropComponents, false);
    }

    /**
     * Layouts provide a default implementation of a drag and drop interaction.  If you set
     *  {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop}:true and <code>canDropComponents:true</code>
     * on a Layout, when a droppable Canvas ({@link com.smartgwt.client.widgets.Canvas#getCanDrop canDrop:true} is dragged over
     *  the layout will show a dropLine (a simple insertion line) at the drop location.  
     *  <P>
     *  When the drop occurs, the dragTarget (obtained using
     * {@link com.smartgwt.client.util.EventHandler#getDragTarget EventHandler.getDragTarget}) is added as a member of this
     * layout at the location
     * shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition
     * Layout.getDropPosition}).  This default
     *  behavior allows either members or external components that have
     * {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition canDragReposition} (or {@link
     * com.smartgwt.client.widgets.Canvas#getCanDrag canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop
     * canDrop} set
     *  to <code>true</code> to be added to or reordered within the Layout.
     *  <P>
     * You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness
     * dropLineThickness} and
     *  you can customize the style using css styling in the skin file (look for .layoutDropLine in
     *  skin_styles.css for your skin).  
     *  <P>  
     *  If you want to dynamically create a component to be added to the Layout in response to a
     *  drop event you can do so as follows: 
     *  <pre>
     *  isc.VLayout.create({
     *    ...various layout properties...
     *    canDropComponents: true,
     *    drop : function () {
     *      // create the new component 
     *      var newMember = isc.Canvas.create(); 
     *      // add to the layout at the current drop position 
     *      // (the dropLine will be showing here)
     *      this.addMember(newMember, this.getDropPosition());  
     *      // hide the dropLine that was automatically shown 
     *      // by builtin Smart GWT methods
     *      this.hideDropLine();
     *    }
     *  });
     *  </pre>
     *  If you want to completely suppress the builtin drag and drop logic, but still receive drag
     * and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop
     * canAcceptDrop} to
     *  <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanDropComponents()  {
        return getAttributeAsBoolean("canDropComponents");
    }

    /**
     * Policy for whether resize bars are shown on members by default. Note that this setting changes the effect of {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} for members of this layout.
     *
     * @param defaultResizeBars defaultResizeBars Default value is "marked"
     * @see com.smartgwt.client.widgets.Canvas#setShowResizeBar
     */
    public void setDefaultResizeBars(LayoutResizeBarPolicy defaultResizeBars) {
        setAttribute("defaultResizeBars", defaultResizeBars.getValue(), true);
    }

    /**
     * Policy for whether resize bars are shown on members by default. Note that this setting changes the effect of {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} for members of this layout.
     *
     *
     * @return LayoutResizeBarPolicy
     * @see com.smartgwt.client.widgets.Canvas#getShowResizeBar
     */
    public LayoutResizeBarPolicy getDefaultResizeBars()  {
        return EnumUtil.getEnum(LayoutResizeBarPolicy.values(), getAttribute("defaultResizeBars"));
    }

    /**
     * Thickness, in pixels of the dropLine shown during drag and drop when {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the
     * discussion in {@link com.smartgwt.client.widgets.layout.Layout} for more info.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dropLineThickness dropLineThickness Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     */
    public void setDropLineThickness(int dropLineThickness)  throws IllegalStateException {
        setAttribute("dropLineThickness", dropLineThickness, false);
    }

    /**
     * Thickness, in pixels of the dropLine shown during drag and drop when {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the
     * discussion in {@link com.smartgwt.client.widgets.layout.Layout} for more info.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     */
    public int getDropLineThickness()  {
        return getAttributeAsInt("dropLineThickness");
    }

    /**
     * Whether the layout policy is continuously enforced as new members are added or removed and as members are resized. <p>
     * This setting implies that any member that resizes larger, or any added member, will take space from other members in
     * order to allow the overall layout to stay the same size.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enforcePolicy enforcePolicy Default value is true
     */
    public void setEnforcePolicy(Boolean enforcePolicy) {
        setAttribute("enforcePolicy", enforcePolicy, true);
    }

    /**
     * Whether the layout policy is continuously enforced as new members are added or removed and as members are resized. <p>
     * This setting implies that any member that resizes larger, or any added member, will take space from other members in
     * order to allow the overall layout to stay the same size.
     *
     *
     * @return Boolean
     */
    public Boolean getEnforcePolicy()  {
        return getAttributeAsBoolean("enforcePolicy");
    }

    /**
     * Sizing policy applied to members on horizontal axis
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hPolicy hPolicy Default value is "fill"
     */
    public void setHPolicy(LayoutPolicy hPolicy) {
        setAttribute("hPolicy", hPolicy.getValue(), true);
    }

    /**
     * Sizing policy applied to members on horizontal axis
     *
     *
     * @return LayoutPolicy
     */
    public LayoutPolicy getHPolicy()  {
        return EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("hPolicy"));
    }

    /**
     * Space outside of all members, on the bottom side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutBottomMargin layoutBottomMargin Default value is null
     */
    public void setLayoutBottomMargin(Integer layoutBottomMargin) {
        setAttribute("layoutBottomMargin", layoutBottomMargin, true);
    }

    /**
     * Space outside of all members, on the bottom side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     */
    public Integer getLayoutBottomMargin()  {
        return getAttributeAsInt("layoutBottomMargin");
    }

    /**
     * Space outside of all members, on the left-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutLeftMargin layoutLeftMargin Default value is null
     */
    public void setLayoutLeftMargin(Integer layoutLeftMargin) {
        setAttribute("layoutLeftMargin", layoutLeftMargin, true);
    }

    /**
     * Space outside of all members, on the left-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     */
    public Integer getLayoutLeftMargin()  {
        return getAttributeAsInt("layoutLeftMargin");
    }

    /**
     * Space outside of all members. This attribute, along with {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin}  and related properties does not have a
     * true setter method.<br> It may be assigned directly at runtime. After setting the property,  {@link
     * com.smartgwt.client.widgets.layout.Layout#setLayoutMargin Layout.setLayoutMargin} may be called with no arguments to
     * reflow the layout.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to force a reflow of the layout after directly assigning a value to any of the layout*Margin properties. Takes no arguments.
     *
     * @param layoutMargin layoutMargin Default value is null
     * @see com.smartgwt.client.widgets.layout.Layout#setLayoutLeftMargin
     * @see com.smartgwt.client.widgets.layout.Layout#setLayoutRightMargin
     * @see com.smartgwt.client.widgets.layout.Layout#setLayoutBottomMargin
     * @see com.smartgwt.client.widgets.layout.Layout#setLayoutTopMargin
     * @see com.smartgwt.client.widgets.layout.Layout#setPaddingAsLayoutMargin
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public void setLayoutMargin(Integer layoutMargin) {
        setAttribute("layoutMargin", layoutMargin, true);
    }

    /**
     * Space outside of all members. This attribute, along with {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin}  and related properties does not have a
     * true setter method.<br> It may be assigned directly at runtime. After setting the property,  {@link
     * com.smartgwt.client.widgets.layout.Layout#setLayoutMargin Layout.setLayoutMargin} may be called with no arguments to
     * reflow the layout.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin
     * @see com.smartgwt.client.widgets.layout.Layout#getLayoutRightMargin
     * @see com.smartgwt.client.widgets.layout.Layout#getLayoutBottomMargin
     * @see com.smartgwt.client.widgets.layout.Layout#getLayoutTopMargin
     * @see com.smartgwt.client.widgets.layout.Layout#getPaddingAsLayoutMargin
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public Integer getLayoutMargin()  {
        return getAttributeAsInt("layoutMargin");
    }

    /**
     * Space outside of all members, on the right-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutRightMargin layoutRightMargin Default value is null
     */
    public void setLayoutRightMargin(Integer layoutRightMargin) {
        setAttribute("layoutRightMargin", layoutRightMargin, true);
    }

    /**
     * Space outside of all members, on the right-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     */
    public Integer getLayoutRightMargin()  {
        return getAttributeAsInt("layoutRightMargin");
    }

    /**
     * Space outside of all members, on the top side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutTopMargin layoutTopMargin Default value is null
     */
    public void setLayoutTopMargin(Integer layoutTopMargin) {
        setAttribute("layoutTopMargin", layoutTopMargin, true);
    }

    /**
     * Space outside of all members, on the top side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     */
    public Integer getLayoutTopMargin()  {
        return getAttributeAsInt("layoutTopMargin");
    }

    /**
     * Whether to leave a gap for a vertical scrollbar even when one is not actually present. <P> This setting avoids the
     * layout resizing all members when the vertical scrollbar is introduced or removed, which can avoid unnecessary screen
     * shifting and improve performance.
     *
     * @param leaveScrollbarGap leaveScrollbarGap Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLeaveScrollbarGap(Boolean leaveScrollbarGap)  throws IllegalStateException {
        setAttribute("leaveScrollbarGap", leaveScrollbarGap, false);
    }

    /**
     * Whether to leave a gap for a vertical scrollbar even when one is not actually present. <P> This setting avoids the
     * layout resizing all members when the vertical scrollbar is introduced or removed, which can avoid unnecessary screen
     * shifting and improve performance.
     *
     *
     * @return Boolean
     */
    public Boolean getLeaveScrollbarGap()  {
        return getAttributeAsBoolean("leaveScrollbarGap");
    }

    /**
     * Strategy to use when locating members from within this Layout's members array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateMembersBy locateMembersBy Default value is null
     */
    public void setLocateMembersBy(LocatorStrategy locateMembersBy) {
        setAttribute("locateMembersBy", locateMembersBy.getValue(), true);
    }

    /**
     * Strategy to use when locating members from within this Layout's members array.
     *
     *
     * @return LocatorStrategy
     */
    public LocatorStrategy getLocateMembersBy()  {
        return EnumUtil.getEnum(LocatorStrategy.values(), getAttribute("locateMembersBy"));
    }

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding members within this layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateMembersType locateMembersType Default value is null
     */
    public void setLocateMembersType(LocatorTypeStrategy locateMembersType) {
        setAttribute("locateMembersType", locateMembersType.getValue(), true);
    }

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding members within this layout.
     *
     *
     * @return LocatorTypeStrategy
     */
    public LocatorTypeStrategy getLocateMembersType()  {
        return EnumUtil.getEnum(LocatorTypeStrategy.values(), getAttribute("locateMembersType"));
    }

    /**
     * If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on a member as a percentage of
     * available space excluding the {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.  If false,
     * percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
     *
     * @param managePercentBreadth managePercentBreadth Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setManagePercentBreadth(Boolean managePercentBreadth)  throws IllegalStateException {
        setAttribute("managePercentBreadth", managePercentBreadth, false);
    }

    /**
     * If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on a member as a percentage of
     * available space excluding the {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.  If false,
     * percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
     *
     *
     * @return Boolean
     */
    public Boolean getManagePercentBreadth()  {
        return getAttributeAsBoolean("managePercentBreadth");
    }

    /**
     * Number of pixels by which each member should overlap the preceding member, used for creating an "stack of cards"
     * appearance for the members of a Layout. <P> <code>memberOverlap</code> can be used in conjunction with {@link
     * com.smartgwt.client.widgets.layout.Layout#getStackZIndex stackZIndex} to create a particular visual stacking order. <P>
     * Note that overlap of individual members can be accomplished with a negative setting for {@link
     * com.smartgwt.client.widgets.Canvas#getExtraSpace extraSpace}.
     *
     * @param memberOverlap memberOverlap Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public void setMemberOverlap(int memberOverlap)  throws IllegalStateException {
        setAttribute("memberOverlap", memberOverlap, false);
    }

    /**
     * Number of pixels by which each member should overlap the preceding member, used for creating an "stack of cards"
     * appearance for the members of a Layout. <P> <code>memberOverlap</code> can be used in conjunction with {@link
     * com.smartgwt.client.widgets.layout.Layout#getStackZIndex stackZIndex} to create a particular visual stacking order. <P>
     * Note that overlap of individual members can be accomplished with a negative setting for {@link
     * com.smartgwt.client.widgets.Canvas#getExtraSpace extraSpace}.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public int getMemberOverlap()  {
        return getAttributeAsInt("memberOverlap");
    }

    /**
     * Space between each member of the layout. <P> Requires a manual call to <code>reflow()</code> if changed on the fly.
     *
     * @param membersMargin membersMargin Default value is 0
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public void setMembersMargin(int membersMargin) {
        setAttribute("membersMargin", membersMargin, true);
    }

    /**
     * Space between each member of the layout. <P> Requires a manual call to <code>reflow()</code> if changed on the fly.
     *
     *
     * @return int
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public int getMembersMargin()  {
        return getAttributeAsInt("membersMargin");
    }

    /**
     * Minimum size, in pixels, below which members should never be shrunk, even if this requires the Layout to overflow.
     *
     * @param minMemberSize minMemberSize Default value is 1
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinMemberSize(int minMemberSize)  throws IllegalStateException {
        setAttribute("minMemberSize", minMemberSize, false);
    }

    /**
     * Minimum size, in pixels, below which members should never be shrunk, even if this requires the Layout to overflow.
     *
     *
     * @return int
     */
    public int getMinMemberSize()  {
        return getAttributeAsInt("minMemberSize");
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if members exceed its specified size, whereas an overflow:visible Layout will grow to accommodate members.
     *
     * @param overflow overflow Default value is "visible"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow.getValue(), false);
    }

    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an overflow:auto Layout
     * will scroll if members exceed its specified size, whereas an overflow:visible Layout will grow to accommodate members.
     *
     *
     * @return Overflow
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding this.padding} or in the
     * CSS style applied to this layout), should it show up as space outside the members, similar to layoutMargin? <P> If this
     * setting is false, padding will not affect member positioning (as CSS padding normally does not affect absolutely
     * positioned children).  Leaving this setting true allows a designer to more effectively control layout purely from CSS.
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes
     * precedence over this value.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param paddingAsLayoutMargin paddingAsLayoutMargin Default value is true
     */
    public void setPaddingAsLayoutMargin(Boolean paddingAsLayoutMargin) {
        setAttribute("paddingAsLayoutMargin", paddingAsLayoutMargin, true);
    }

    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding this.padding} or in the
     * CSS style applied to this layout), should it show up as space outside the members, similar to layoutMargin? <P> If this
     * setting is false, padding will not affect member positioning (as CSS padding normally does not affect absolutely
     * positioned children).  Leaving this setting true allows a designer to more effectively control layout purely from CSS.
     * <P> Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes
     * precedence over this value.
     *
     *
     * @return Boolean
     */
    public Boolean getPaddingAsLayoutMargin()  {
        return getAttributeAsBoolean("paddingAsLayoutMargin");
    }

    /**
     * Class to use for creating resizeBars. <P> A resize bar will be created for any Layout member that specifies {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar <code>showResizeBar:true</code>}. Resize bars will be instances of
     * the class specified by this property, and will  automatically be sized to the member's breadth and to the thickness
     * given by {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize resizeBarSize}.<br> Classes that are valid by
     * default are {@link com.smartgwt.client.widgets.Splitbar} and {@link com.smartgwt.client.widgets.ImgSplitbar}. <P> To
     * customize the appearance or behavior of resizeBars within some layout a custom  resize bar class can be created by
     * subclassing {@link com.smartgwt.client.widgets.Splitbar} or {@link com.smartgwt.client.widgets.ImgSplitbar} and setting
     * this property on your layout to use your new class. <P> Resize bars will automatically be sized to the member's breadth
     * and to the thickness given by <code>layout.resizeBarSize</code>.  The built-in Splitbar class supports drag resizing of
     * its target member, and clicking on the bar to hide the target member.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarClass resizeBarClass Default value is "Splitbar"
     * @see com.smartgwt.client.widgets.Splitbar
     * @see com.smartgwt.client.widgets.ImgSplitbar
     * @see com.smartgwt.client.widgets.layout.Layout#setResizeBarSize
     */
    public void setResizeBarClass(String resizeBarClass) {
        setAttribute("resizeBarClass", resizeBarClass, true);
    }

    /**
     * Class to use for creating resizeBars. <P> A resize bar will be created for any Layout member that specifies {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar <code>showResizeBar:true</code>}. Resize bars will be instances of
     * the class specified by this property, and will  automatically be sized to the member's breadth and to the thickness
     * given by {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize resizeBarSize}.<br> Classes that are valid by
     * default are {@link com.smartgwt.client.widgets.Splitbar} and {@link com.smartgwt.client.widgets.ImgSplitbar}. <P> To
     * customize the appearance or behavior of resizeBars within some layout a custom  resize bar class can be created by
     * subclassing {@link com.smartgwt.client.widgets.Splitbar} or {@link com.smartgwt.client.widgets.ImgSplitbar} and setting
     * this property on your layout to use your new class. <P> Resize bars will automatically be sized to the member's breadth
     * and to the thickness given by <code>layout.resizeBarSize</code>.  The built-in Splitbar class supports drag resizing of
     * its target member, and clicking on the bar to hide the target member.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Splitbar
     * @see com.smartgwt.client.widgets.ImgSplitbar
     * @see com.smartgwt.client.widgets.layout.Layout#getResizeBarSize
     */
    public String getResizeBarClass()  {
        return getAttributeAsString("resizeBarClass");
    }

    /**
     * Thickness of the resizeBars in pixels
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarSize resizeBarSize Default value is 7
     */
    public void setResizeBarSize(int resizeBarSize) {
        setAttribute("resizeBarSize", resizeBarSize, true);
    }

    /**
     * Thickness of the resizeBars in pixels
     *
     *
     * @return int
     */
    public int getResizeBarSize()  {
        return getAttributeAsInt("resizeBarSize");
    }

    /**
     * Reverse the order of stacking for this Layout, so that the last member is shown first. <P> Requires a manual call to
     * <code>reflow()</code> if changed on the fly. <P> In RTL mode, for horizontal Layouts the value of this flag will be
     * flipped during initialization.
     *
     * @param reverseOrder reverseOrder Default value is false
     */
    public void setReverseOrder(Boolean reverseOrder) {
        setAttribute("reverseOrder", reverseOrder, true);
    }

    /**
     * Reverse the order of stacking for this Layout, so that the last member is shown first. <P> Requires a manual call to
     * <code>reflow()</code> if changed on the fly. <P> In RTL mode, for horizontal Layouts the value of this flag will be
     * flipped during initialization.
     *
     *
     * @return Boolean
     */
    public Boolean getReverseOrder()  {
        return getAttributeAsBoolean("reverseOrder");
    }

    /**
     * If set to true, when a member is dragged out of layout, a visible placeholder canvas  will be displayed in place of the
     * dragged widget for the duration of the drag and drop interaction.
     *
     * @param showDragPlaceHolder showDragPlaceHolder Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     */
    public void setShowDragPlaceHolder(Boolean showDragPlaceHolder) {
        setAttribute("showDragPlaceHolder", showDragPlaceHolder, true);
    }

    /**
     * If set to true, when a member is dragged out of layout, a visible placeholder canvas  will be displayed in place of the
     * dragged widget for the duration of the drag and drop interaction.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_drag_move" target="examples">Drag move Example</a>
     */
    public Boolean getShowDragPlaceHolder()  {
        return getAttributeAsBoolean("showDragPlaceHolder");
    }

    /**
     * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls
     * the z-stacking order of members. <P> If "lastOnTop", members stack from the first member at bottom to the last member at
     * top. If "firstOnTop", members stack from the last member at bottom to the first member at top.
     *
     * @param stackZIndex stackZIndex Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStackZIndex(String stackZIndex)  throws IllegalStateException {
        setAttribute("stackZIndex", stackZIndex, false);
    }

    /**
     * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls
     * the z-stacking order of members. <P> If "lastOnTop", members stack from the first member at bottom to the last member at
     * top. If "firstOnTop", members stack from the last member at bottom to the first member at top.
     *
     *
     * @return String
     */
    public String getStackZIndex()  {
        return getAttributeAsString("stackZIndex");
    }

    /**
     * Should this layout appear with members stacked vertically or horizontally. Defaults to  <code>false</code> if
     * unspecified.
     *
     * @param vertical vertical Default value is null
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Should this layout appear with members stacked vertically or horizontally. Defaults to  <code>false</code> if
     * unspecified.
     *
     *
     * @return Boolean
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Sizing policy applied to members on vertical axis
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param vPolicy vPolicy Default value is "fill"
     */
    public void setVPolicy(LayoutPolicy vPolicy) {
        setAttribute("vPolicy", vPolicy.getValue(), true);
    }

    /**
     * Sizing policy applied to members on vertical axis
     *
     *
     * @return LayoutPolicy
     */
    public LayoutPolicy getVPolicy()  {
        return EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("vPolicy"));
    }

    // ********************* Methods ***********************
            
    /**
     * Get the position a new member would be dropped.  This drop position switches in the middle of each member, and both
     * edges (before beginning, after end) are legal drop positions <p> Use this method to obtain the drop position for e.g. a
     * custom drop handler.
     *
     * @return the position a new member would be dropped
     */
    public native int getDropPosition() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDropPosition();
    }-*/;
            
    /**
     * Return the breadth for a member of this layout which either didn't specify a breadth or specified a percent breadth with
     * {@link com.smartgwt.client.widgets.layout.Layout#getManagePercentBreadth managePercentBreadth}:true. <P> Called only for
     * Layouts which have a {@link com.smartgwt.client.types.LayoutPolicy layout policy} for the breadth axis of "fill", since
     * Layouts with a breadth policy of "none" leave all member breadths alone.
     * @param member Component to be sized
     * @param defaultBreadth Value of the currently calculated member breadth. This      may be returned verbatim or manipulated in this method.
     */
    public native void getMemberDefaultBreadth(Canvas member, int defaultBreadth) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getMemberDefaultBreadth(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultBreadth);
    }-*/;
            
    /**
     * Override point for changing the offset on the breadth axis for members, that is, the offset relative to the left edge
     * for a vertical layout, or the offset relative to the top edge for a horizontal layout. <P> The method is passed the
     * default offset that would be used for the member if getMemberOffset() were not implemented.  This default offset already
     * takes into account {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}, as well as the {@link
     * com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign alignment on the breadth axis}, which is also passed to
     * getMemberOffset(). <P> This method is an override point only; it does not exist by default and cannot be called.
     * @param member Component to be positioned
     * @param defaultOffset Value of the currently calculated member offset.  If this      value is returned unchanged the layout will have its
     * default behavior
     * @param alignment alignment of the enclosing layout, on the breadth axis
     */
    public native void getMemberOffset(Canvas member, int defaultOffset, String alignment) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getMemberOffset(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultOffset, alignment);
    }-*/;
            
    /**
     * Returns true if the layout includes the specified canvas.
     * @param canvas the canvas to check for
     *
     * @return true if the layout includes the specified canvas
     */
    public native Boolean hasMember(Canvas canvas) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasMember(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Calling this method hides the dropLine shown during a drag and drop interaction with a Layout that has {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} set to true.  This method is only
     * useful for custom implementations of {@link com.smartgwt.client.widgets.layout.Layout#drop Layout.drop} as the default
     * implementation calls this method automatically.
     */
    public native void hideDropLine() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideDropLine();
    }-*/;
            
    /**
     * Fires once at initialization if the layout has any initial members, and then fires whenever members are added, removed
     * or reordered.
     */
    public native void membersChanged() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.membersChanged();
    }-*/;
            
    /**
     * Layout members according to current settings. <P> Members will reflow automatically when the layout is resized, members
     * resize, the list of members changes or members change visibility.  It is only necessary to manually call
     * <code>reflow()</code> after changing settings on the layout, for example, <code>layout.reverseOrder</code>.
     */
    public native void reflow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflow();
    }-*/;

    /**
     * Layout members according to current settings. <P> Members will reflow automatically when the layout is resized, members
     * resize, the list of members changes or members change visibility.  It is only necessary to manually call
     * <code>reflow()</code> after changing settings on the layout, for example, <code>layout.reverseOrder</code>.
     * @param reason reason reflow() had to be called (appear in logs if enabled)
     */
    public native void reflow(String reason) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflow(reason);
    }-*/;
            
    /**
     * Layout members according to current settings, immediately. <br> Generally, when changes occur that require a layout to
     * reflow (such as members being shown or hidden), the Layout will reflow only after a delay, so that multiple changes
     * cause only one reflow.  To remove this delay for cases where it is not helpful, reflowNow() can be called.
     */
    public native void reflowNow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflowNow();
    }-*/;
            
    /**
     * Removes the specified member from the layout. If it has a resize bar, the bar will be destroyed.
     * @param member the canvas to be removed from the layout
     */
    public native void removeMember(Canvas member) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeMember(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
            
    /**
     * Shift a member of the layout to a new position
     * @param memberNum current position of the member to move to a new position
     * @param newPosition new position to move the member to
     */
    public native void reorderMember(int memberNum, int newPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderMember(memberNum, newPosition);
    }-*/;
            
    /**
     * Move a range of members to a new position
     * @param start beginning of range of members to move
     * @param end end of range of members to move, non-inclusive
     * @param newPosition new position to move the members to
     */
    public native void reorderMembers(int start, int end, int newPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderMembers(start, end, newPosition);
    }-*/;
            
    /**
     * Hide all other members and make the single parameter member visible.
     * @param member member to show
     */
    public native void setVisibleMember(Canvas member) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setVisibleMember(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

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
     * @param layoutProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Layout layoutProperties) /*-{
    	var properties = $wnd.isc.addProperties({},layoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Layout.addProperties(properties);
    }-*/;
        
    // ***********************************************************        



	protected void onInit() {
		super.onInit();
		onInit_Layout();
	}
    protected native void onInit_Layout() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__getDropComponent = self.getDropComponent;
        self.getDropComponent = $entry(function(dragTarget, dropPosition) {
            var jObj = this.__ref;
            var dragTargetJ = @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dragTarget);
            var dragTarget2J = jObj.@com.smartgwt.client.widgets.layout.Layout::getDropComponent(Lcom/smartgwt/client/widgets/Canvas;I)(dragTargetJ, dropPosition);
            return dragTarget2J == null ? null : dragTarget2J.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });
    }-*/;

    /*
     * When {@link com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is true, this method will
     * be called when a component is dropped onto the layout to determine what component to add as a new layout member. <P> By
     * default, the actual component being dragged (isc.EventHandler.getDragTarget()) will be added to the layout.  For a
     * different behavior, such as wrapping dropped components in Windows, or creating components on the fly from dropped data,
     * override this method.   <P> You can also return null to cancel the drop.
     *
     * <b>Note : </b> This is an override point
     * @param dragTarget current drag target
     * @param dropPosition index of the drop in the list of current members
     *
     * @return Returning null will cancel the drop entirely. By default the dragTarget is returned
     */
    protected native Canvas getDropComponent(Canvas dragTarget, int dropPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret =  self.__getDropComponent(dragTarget == null ? null : dragTarget.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()(), dropPosition);
        return ret == null || ret == undefined ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * An array of canvases that will be contained within this layout. You can set the following properties on these
     * canvases (in addition to the standard component properties): <ul>  <li>layoutAlign--specifies the member's
     * alignment along the breadth axis; valid  values are "top", "center" and "bottom" for a horizontal layout and
     * "left", "center"  and "right" for a vertical layout (see {@link com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign
     * defaultLayoutAlign} for default  implementation.)  <li>showResizeBar--set to true to show a resize bar (default
     * is false) </ul> Height and width settings found on members are interpreted by the Layout according to the {@link
     * com.smartgwt.client.widgets.layout.Layout#getVPolicy vPolicy}.
     *
     * @param members members Default value is null
     */
    public void setMembers(Canvas... members) {
        if(!isCreated()) {
            setAttribute("members", members, true);
        }
        else {
            Canvas[] membersToRemove = getMembers();
            for(Canvas member : membersToRemove) {
                removeMember(member);
            }
            for(Canvas member : members) {
                addMember(member);
            }
        }
    }

    /**
     * Add a canvas to the layout, optionally at a specific position.
     *
     * @param widget the canvas object to be added to the layout
     */
    public void addMember(Widget widget) {
        if (widget instanceof Canvas) {
            addMember((Canvas) widget);
        } else {
            addMember(new WidgetCanvas(widget));
        }
    }

    /**
     * Add a canvas to the layout, optionally at a specific position.
     *
     * @param component the canvas object to be added to the layout
     */
    public void addMember(Canvas component) {
        JavaScriptObject componentJS = component.getOrCreateJsObj();

        if (isCreated()) {
            addMemberPostCreate(componentJS);

        } else {
            addMemberPreCreate(componentJS);
        }
    }

    public void addMember(Widget widget, int position) {
        if (widget instanceof Canvas) {
            addMember((Canvas) widget, position);
        } else {
            addMember(new WidgetCanvas(widget), position);
        }
    }


    /**
     * Add a canvas to the layout, optionally at a specific position.
     *
     * @param component the canvas object to be added to the layout
     * @param position  the position in the layout to place newMember (starts with 0);
     *                  if omitted, it will be added at the last position
     */
    public void addMember(Canvas component, int position) {
        JavaScriptObject componentJS = component.getOrCreateJsObj();

        if (isCreated()) {
            addMemberPostCreate(componentJS, position);

        } else {
            addMemberPreCreate(componentJS, position);
        }
    }

    protected native void addMemberPreCreate(Object componentJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.members) {
            config.members = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.members.push(componentJS);
    }-*/;

    protected native void addMemberPostCreate(Object componentJS) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addMember(componentJS);
    }-*/;

    protected native void addMemberPreCreate(Object componentJS, int position) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.members) {
            config.members = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.members.addAt(componentJS, position);
    }-*/;

    protected native void addMemberPostCreate(Object componentJS, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addMember(componentJS, position);
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.layout.Layout#getShowDragPlaceHolder showDragPlaceHolder} is true, this
     * properties object can be used to customize the appearance of the placeholder displayed when the user drags a
     * widget out of this layout.
     *
     * @param placeHolderProperties placeHolderProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPlaceHolderProperties(Canvas placeHolderProperties) throws IllegalStateException {
        placeHolderProperties.setConfigOnly(true);
        setAttribute("placeHolderProperties", placeHolderProperties, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.layout.Layout#getShowDragPlaceHolder showDragPlaceHolder} is true, this
     * defaults object determines the default appearance of the placeholder displayed when the user drags a widget out
     * of this layout.<br> Default value for this property sets the placeholder {@link
     * com.smartgwt.client.widgets.Canvas#getStyleName styleName} to <code>"layoutPlaceHolder"</code><br> To modify this
     * object, use {@link com.smartgwt.client..Class#changeDefaults}
     *
     * @param placeHolderDefaults placeHolderDefaults Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPlaceHolderDefaults(Canvas placeHolderDefaults) throws IllegalStateException {
        placeHolderDefaults.setConfigOnly(true);
        setAttribute("placeHolderDefaults", placeHolderDefaults, false);
    }

    /**
     * Specifies the default alignment for layout members on the breadth axis. Can be overridden on a per-member basis
     * by setting {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign layoutAlign}.<br> If unset, default member
     * layout alignment will be "top" for a horizontal layout, and left for a vertical layout.
     *
     * @param alignment defaultLayoutAlign Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultLayoutAlign(Alignment alignment) throws IllegalStateException {
        setAttribute("defaultLayoutAlign", alignment.getValue(), false);
    }

    /**
     * Specifies the default alignment for layout members on the breadth axis. Can be overridden on a per-member basis
     * by setting {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign layoutAlign}.<br> If unset, default member
     * layout alignment will be "top" for a horizontal layout, and left for a vertical layout.
     *
     * @param alignment defaultLayoutAlign Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultLayoutAlign(VerticalAlignment alignment) throws IllegalStateException {
        setAttribute("defaultLayoutAlign", alignment.getValue(), false);
    }

    public void setDropLineProperties(Canvas dropLineProperties) throws IllegalStateException {
        dropLineProperties.setConfigOnly(true);
        setAttribute("dropLineProperties", dropLineProperties, false);
    }

    /**
     * Alignment of all members in this Layout on the length axis.  Defaults to "top" for vertical Layouts, and "left"
     * for horizontal Layouts.
     *
     * @param alignment alignment Default value is null
     */
    public void setAlign(Alignment alignment) {
        setAttribute("align", alignment.getValue(), true);
    }

    /**
     * Alignment of all members in this Layout on the length axis.  Defaults to "top" for vertical Layouts, and "left"
     * for horizontal Layouts.
     *
     * @param alignment alignment Default value is null
     */
    public void setAlign(VerticalAlignment alignment) {
        setAttribute("align", alignment.getValue(), true);
    }


    /**
     * Removes the specified members from the layout. If any of the removed members have resize  bars, the bars will be
     * destroyed.
     *
     * @param members array of members to be removed, or reference to single
     *                member.
     */
    public native void removeMembers(Canvas[] members) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var membersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(members);
        self.removeMembers(membersJS);
    }-*/;


    /**
     * Return the members in the Layout.
     *
     * @return the members
     */
    public Canvas[] getMembers() {
        return Canvas.convertToCanvasArray(getAttributeAsJavaScriptObject("members"));
    }
    
    /**
     * Show the specified member, firing the specified callback when the hide is complete. <P> Members can always be
     * directly shown via <code>member.show()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animateMembers} is enabled, animation will only occur if showMember() is called to show the member.
     *
     * @param member Member to show
     */
    public native void showMember(Canvas member) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        self.showMember(memberJS);
    }-*/;

    /**
     * Show the specified member, firing the specified callback when the hide is complete. <P> Members can always be
     * directly shown via <code>member.show()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animateMembers} is enabled, animation will only occur if showMember() is called to show the member.
     *
     * @param member   Member to show
     * @param callback action to fire when the member has been shown
     */
    public native void showMember(Canvas member, Function callback) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        self.showMember(memberJS, $entry(function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        }));
    }-*/;



    /**
     * Hide the specified member, firing the specified callback when the hide is complete. <P> Members can always be
     * directly hidden via <code>member.hide()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animateMembers} is enabled, animation will only occur if hideMember() is called to hide the member.
     *
     * @param member Member to hide
     */
    public native void hideMember(Canvas member) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        self.hideMember(memberJS);
    }-*/;

    /**
     * Hide the specified member, firing the specified callback when the hide is complete. <P> Members can always be
     * directly hidden via <code>member.hide()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animateMembers} is enabled, animation will only occur if hideMember() is called to hide the member.
     *
     * @param member   Member to hide
     * @param callback callback to fire when the member is hidden.
     */

    public native void hideMember(Canvas member, Function callback) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        self.hideMember(memberJS, $entry(function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        }));
    }-*/;

    /**
     * Given a numerical index or a member ID, return a pointer to the appropriate member. <p> If passed a member
     * Canvas, just returns it.
     *
     * @param index index for the member
     * @return member widget
     */
    public native Canvas getMember(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMember(index);
        return ret == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Given a numerical index or a member ID, return a pointer to the appropriate member. <p> If passed a member
     * Canvas, just returns it.
     *
     * @param memberID identifier for the required member
     * @return member widget
     */
    public native Canvas getMember(String memberID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMember(memberID);
        return ret == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Given a member Canvas or member ID, return the index of that member within this layout's members array <p> If
     * passed a number, just returns it.
     *
     * @param member the member
     * @return index of the member canvas (or -1 if not found)
     */
    public native int getMemberNumber(Canvas member) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var memberJS = member.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        return self.getMemberNumber(memberJS);
    }-*/;

    /**
     * Given a member Canvas or member ID, return the index of that member within this layout's members array <p> If
     * passed a number, just returns it.
     *
     * @param memberID identifier for the required member
     * @return index of the member canvas (or -1 if not found)
     */
    public native int getMemberNumber(String memberID) /*-{
        var self  = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMemberNumber(memberID);
    }-*/;

}




