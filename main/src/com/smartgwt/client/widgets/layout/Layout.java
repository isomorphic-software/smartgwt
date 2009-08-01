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
    * A subclass of Canvas that automatically arranges other Canvases according to a layout policy.&#010 <br><br>&#010 A Layout manages a set of "member" Canvases initialized via the "members" property.  Layouts&#010 can have both "members", which are managed by the Layout, and normal Canvas children, which&#010 are unmanaged.&#010 <br><br>&#010 Rather than using the Layout class directly, use the HLayout, VLayout, HStack and VStack&#010 classes, which are subclasses of Layout preconfigured for horizontal or vertical stacking,&#010 with the "fill" (VLayout) or "none" (VStack) {@link com.smartgwt.client.types.LayoutPolicy} already set.&#010 <br><br>&#010 Layouts and Stacks may be nested to create arbitrarily complex layouts.&#010 <br><br>&#010 To show a resizer bar after (to the right or bottom of) a layout member, set showResizeBar to&#010 true on that member component (not on the HLayout or VLayout).  Resizer bars override&#010 membersMargin spacing.&#010 <br><br> &#010 Like other Canvas subclasses, Layout and Stack components may have % width and height&#010 values. To create a dynamically-resizing layout that occupies the entire page (or entire&#010 parent component), set width and height to "100%".

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
        
    }

    public Layout(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Layout.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************
             
    /**
    * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an&#010 overflow:auto Layout will scroll if members exceed its specified size, whereas an&#010 overflow:visible Layout will grow to accomodate members.
    *
    * @param overflow overflow Default value is "visible"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOverflow(Overflow overflow)  throws IllegalStateException {
        setAttribute("overflow", overflow.getValue(), false);
    }
    /**
     * Normal {@link com.smartgwt.client.types.Overflow} settings can be used on layouts, for example, an&#010 overflow:auto Layout will scroll if members exceed its specified size, whereas an&#010 overflow:visible Layout will grow to accomodate members.
     *
     *
     * @return Overflow
     *
     */
    public Overflow getOverflow()  {
        return (Overflow) EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
    * Should this layout appear with members stacked vertically or horizontally. Defaults to &#010 <code>false</code> if unspecified.
    *
    * @param vertical vertical Default value is null
    */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }
    /**
     * Should this layout appear with members stacked vertically or horizontally. Defaults to &#010 <code>false</code> if unspecified.
     *
     *
     * @return Boolean
     *
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
     *
     */
    public LayoutPolicy getVPolicy()  {
        return (LayoutPolicy) EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("vPolicy"));
    }
             
    /**
    * Sizing policy applied to members on horizonal axis
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param hPolicy hPolicy Default value is "fill"
    */
    public void setHPolicy(LayoutPolicy hPolicy) {
        setAttribute("hPolicy", hPolicy.getValue(), true);
    }
    /**
     * Sizing policy applied to members on horizonal axis
     *
     *
     * @return LayoutPolicy
     *
     */
    public LayoutPolicy getHPolicy()  {
        return (LayoutPolicy) EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("hPolicy"));
    }

    /**
    * Minimum size, in pixels, below which members should never be shrunk, even if this&#010 requires the Layout to overflow.
    *
    * @param minMemberSize minMemberSize Default value is 1
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setMinMemberSize(int minMemberSize)  throws IllegalStateException {
        setAttribute("minMemberSize", minMemberSize, false);
    }
    /**
     * Minimum size, in pixels, below which members should never be shrunk, even if this&#010 requires the Layout to overflow.
     *
     *
     * @return int
     *
     */
    public int getMinMemberSize()  {
        return getAttributeAsInt("minMemberSize");
    }

    /**
    * Whether the layout policy is continuously enforced as new members are added or removed&#010 and as members are resized.&#010 <p>&#010 This setting implies that any member that resizes larger, or any added member, will take&#010 space from other members in order to allow the overall layout to stay the same size.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enforcePolicy enforcePolicy Default value is true
    */
    public void setEnforcePolicy(Boolean enforcePolicy) {
        setAttribute("enforcePolicy", enforcePolicy, true);
    }
    /**
     * Whether the layout policy is continuously enforced as new members are added or removed&#010 and as members are resized.&#010 <p>&#010 This setting implies that any member that resizes larger, or any added member, will take&#010 space from other members in order to allow the overall layout to stay the same size.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnforcePolicy()  {
        return getAttributeAsBoolean("enforcePolicy");
    }

    /**
    * Reverse the order of stacking for this Layout, so that the last member is shown first.&#010 <P>&#010 Requires a manual call to <code>reflow()</code> if changed on the fly.&#010 <P>&#010 In RTL mode, for horizontal Layouts the value of this flag will be flipped during&#010 initialization.
    *
    * @param reverseOrder reverseOrder Default value is false
    */
    public void setReverseOrder(Boolean reverseOrder) {
        setAttribute("reverseOrder", reverseOrder, true);
    }
    /**
     * Reverse the order of stacking for this Layout, so that the last member is shown first.&#010 <P>&#010 Requires a manual call to <code>reflow()</code> if changed on the fly.&#010 <P>&#010 In RTL mode, for horizontal Layouts the value of this flag will be flipped during&#010 initialization.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getReverseOrder()  {
        return getAttributeAsBoolean("reverseOrder");
    }

    /**
    * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding 'this.padding'} or in the&#010 CSS style applied to this layout), should it show up as space outside the members,&#010 similar to layoutMargin?&#010 <P>&#010 If this setting is false, padding will not affect member positioning (as CSS padding&#010 normally does not affect absolutely positioned children).  Leaving this setting true&#010 allows a designer to more effectively control layout purely from CSS.&#010 <P>&#010 Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes precidence over this value.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param paddingAsLayoutMargin paddingAsLayoutMargin Default value is true
    */
    public void setPaddingAsLayoutMargin(Boolean paddingAsLayoutMargin) {
        setAttribute("paddingAsLayoutMargin", paddingAsLayoutMargin, true);
    }
    /**
     * If this widget has padding specified (as {@link com.smartgwt.client.widgets.Canvas#getPadding 'this.padding'} or in the&#010 CSS style applied to this layout), should it show up as space outside the members,&#010 similar to layoutMargin?&#010 <P>&#010 If this setting is false, padding will not affect member positioning (as CSS padding&#010 normally does not affect absolutely positioned children).  Leaving this setting true&#010 allows a designer to more effectively control layout purely from CSS.&#010 <P>&#010 Note that {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin} if specified, takes precidence over this value.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPaddingAsLayoutMargin()  {
        return getAttributeAsBoolean("paddingAsLayoutMargin");
    }

    /**
    * Space outside of all members. This attribute, along with {@link com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} &#010 and related properties does not have a true setter method.<br>&#010 It may be assigned directly at runtime. After setting the property, &#010 {@link com.smartgwt.client.widgets.layout.Layout#setLayoutMargin} may be called with no arguments to reflow the layout.
    * Method to force a reflow of the layout after directly assigning a value to any of the&#010 layout*Margin properties. Takes no arguments.&#010&#010
    *
    * @param layoutMargin layoutMargin Default value is null
    */
    public void setLayoutMargin(Integer layoutMargin) {
        setAttribute("layoutMargin", layoutMargin, true);
    }
    /**
     * Space outside of all members. This attribute, along with {@link com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} &#010 and related properties does not have a true setter method.<br>&#010 It may be assigned directly at runtime. After setting the property, &#010 {@link com.smartgwt.client.widgets.layout.Layout#setLayoutMargin} may be called with no arguments to reflow the layout.
     *
     *
     * @return Integer
     *
     */
    public Integer getLayoutMargin()  {
        return getAttributeAsInt("layoutMargin");
    }

    /**
    * Space outside of all members, on the left-hand side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
    *
    * @param layoutLeftMargin layoutLeftMargin Default value is null
    */
    public void setLayoutLeftMargin(Integer layoutLeftMargin) {
        setAttribute("layoutLeftMargin", layoutLeftMargin, true);
    }
    /**
     * Space outside of all members, on the left-hand side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     *
     */
    public Integer getLayoutLeftMargin()  {
        return getAttributeAsInt("layoutLeftMargin");
    }

    /**
    * Space outside of all members, on the right-hand side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
    *
    * @param layoutRightMargin layoutRightMargin Default value is null
    */
    public void setLayoutRightMargin(Integer layoutRightMargin) {
        setAttribute("layoutRightMargin", layoutRightMargin, true);
    }
    /**
     * Space outside of all members, on the right-hand side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     *
     */
    public Integer getLayoutRightMargin()  {
        return getAttributeAsInt("layoutRightMargin");
    }

    /**
    * Space outside of all members, on the top side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
    *
    * @param layoutTopMargin layoutTopMargin Default value is null
    */
    public void setLayoutTopMargin(Integer layoutTopMargin) {
        setAttribute("layoutTopMargin", layoutTopMargin, true);
    }
    /**
     * Space outside of all members, on the top side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     *
     */
    public Integer getLayoutTopMargin()  {
        return getAttributeAsInt("layoutTopMargin");
    }

    /**
    * Space outside of all members, on the bottom side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
    *
    * @param layoutBottomMargin layoutBottomMargin Default value is null
    */
    public void setLayoutBottomMargin(Integer layoutBottomMargin) {
        setAttribute("layoutBottomMargin", layoutBottomMargin, true);
    }
    /**
     * Space outside of all members, on the bottom side.  Defaults to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.&#010 <P>&#010 Requires a manual call to <code>setLayoutMargin()</code> if changed on the fly.
     *
     *
     * @return Integer
     *
     */
    public Integer getLayoutBottomMargin()  {
        return getAttributeAsInt("layoutBottomMargin");
    }

    /**
    * Space between each member of the layout.&#010 <P>&#010 Requires a manual call to <code>reflow()</code> if changed on the fly.
    *
    * @param membersMargin membersMargin Default value is 0
    */
    public void setMembersMargin(int membersMargin) {
        setAttribute("membersMargin", membersMargin, true);
    }
    /**
     * Space between each member of the layout.&#010 <P>&#010 Requires a manual call to <code>reflow()</code> if changed on the fly.
     *
     *
     * @return int
     *
     */
    public int getMembersMargin()  {
        return getAttributeAsInt("membersMargin");
    }

    /**
    * Whether to leave a gap for a vertical scrollbar even when one is not actually present.&#010 <P>&#010 This setting avoids the layout resizing all members when the vertical scrollbar is&#010 introduced or removed, which can avoid unnecessary screen shifting and improve&#010 performance.
    *
    * @param leaveScrollbarGap leaveScrollbarGap Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLeaveScrollbarGap(Boolean leaveScrollbarGap)  throws IllegalStateException {
        setAttribute("leaveScrollbarGap", leaveScrollbarGap, false);
    }
    /**
     * Whether to leave a gap for a vertical scrollbar even when one is not actually present.&#010 <P>&#010 This setting avoids the layout resizing all members when the vertical scrollbar is&#010 introduced or removed, which can avoid unnecessary screen shifting and improve&#010 performance.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLeaveScrollbarGap()  {
        return getAttributeAsBoolean("leaveScrollbarGap");
    }

    /**
    * Number of pixels by which each member should overlap the preceding member, used for&#010 creating an "stack of cards" appearance for the members of a Layout.&#010 <P>&#010 <code>memberOverlap</code> can be used in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getStackZIndex stackZIndex} to create&#010 a particular visual stacking order.&#010 <P>&#010 Note that overlap of individual members can be accomplished with a negative setting for&#010 {@link com.smartgwt.client.widgets.Canvas#getExtraSpace extraSpace}.
    *
    * @param memberOverlap memberOverlap Default value is 0
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setMemberOverlap(int memberOverlap)  throws IllegalStateException {
        setAttribute("memberOverlap", memberOverlap, false);
    }
    /**
     * Number of pixels by which each member should overlap the preceding member, used for&#010 creating an "stack of cards" appearance for the members of a Layout.&#010 <P>&#010 <code>memberOverlap</code> can be used in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getStackZIndex stackZIndex} to create&#010 a particular visual stacking order.&#010 <P>&#010 Note that overlap of individual members can be accomplished with a negative setting for&#010 {@link com.smartgwt.client.widgets.Canvas#getExtraSpace extraSpace}.
     *
     *
     * @return int
     *
     */
    public int getMemberOverlap()  {
        return getAttributeAsInt("memberOverlap");
    }
             
    /**
    * Policy for whether resize bars are shown on members by default.
    *
    * @param defaultResizeBars defaultResizeBars Default value is "marked"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDefaultResizeBars(LayoutResizeBarPolicy defaultResizeBars)  throws IllegalStateException {
        setAttribute("defaultResizeBars", defaultResizeBars.getValue(), false);
    }
    /**
     * Policy for whether resize bars are shown on members by default.
     *
     *
     * @return LayoutResizeBarPolicy
     *
     */
    public LayoutResizeBarPolicy getDefaultResizeBars()  {
        return (LayoutResizeBarPolicy) EnumUtil.getEnum(LayoutResizeBarPolicy.values(), getAttribute("defaultResizeBars"));
    }

    /**
    * Class to use for creating resizeBars.&#010 <P>&#010 A resize bar will be created for any Layout member that specifies&#010 {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar '<code>showResizeBar:true</code>'}.&#010 Resize bars will be instances of the class specified by this property, and will &#010 automatically be sized to the member's breadth and to the thickness&#010 given by {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize resizeBarSize}.<br>&#010 Classes that are valid by default are {@link com.smartgwt.client.widgets.Splitbar} and {@link com.smartgwt.client.widgets.ImgSplitbar}.&#010 <P>&#010 To customize the appearance or behavior of resizeBars within some layout a custom &#010 resize bar class can be created by subclassing {@link com.smartgwt.client.widgets.Splitbar} or {@link com.smartgwt.client.widgets.ImgSplitbar} and&#010 setting this property on your layout to use your new class.&#010 <P>&#010 Resize bars will automatically be sized to the member's breadth and to the thickness&#010 given by <code>layout.resizeBarSize</code>.  The built-in Splitbar class supports&#010 drag resizing of its target member, and clicking on the bar to hide the target member.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param resizeBarClass resizeBarClass Default value is "Splitbar"
    */
    public void setResizeBarClass(String resizeBarClass) {
        setAttribute("resizeBarClass", resizeBarClass, true);
    }
    /**
     * Class to use for creating resizeBars.&#010 <P>&#010 A resize bar will be created for any Layout member that specifies&#010 {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar '<code>showResizeBar:true</code>'}.&#010 Resize bars will be instances of the class specified by this property, and will &#010 automatically be sized to the member's breadth and to the thickness&#010 given by {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize resizeBarSize}.<br>&#010 Classes that are valid by default are {@link com.smartgwt.client.widgets.Splitbar} and {@link com.smartgwt.client.widgets.ImgSplitbar}.&#010 <P>&#010 To customize the appearance or behavior of resizeBars within some layout a custom &#010 resize bar class can be created by subclassing {@link com.smartgwt.client.widgets.Splitbar} or {@link com.smartgwt.client.widgets.ImgSplitbar} and&#010 setting this property on your layout to use your new class.&#010 <P>&#010 Resize bars will automatically be sized to the member's breadth and to the thickness&#010 given by <code>layout.resizeBarSize</code>.  The built-in Splitbar class supports&#010 drag resizing of its target member, and clicking on the bar to hide the target member.
     *
     *
     * @return String
     *
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
     *
     */
    public int getResizeBarSize()  {
        return getAttributeAsInt("resizeBarSize");
    }

    /**
    * If true when members are added / removed, they should be animated as they are shown&#010 or hidden in position
    *
    * @param animateMembers animateMembers Default value is null
    */
    public void setAnimateMembers(Boolean animateMembers) {
        setAttribute("animateMembers", animateMembers, true);
    }
    /**
     * If true when members are added / removed, they should be animated as they are shown&#010 or hidden in position
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateMembers()  {
        return getAttributeAsBoolean("animateMembers");
    }

    /**
    * If specified this is the duration of show/hide animations when members are being shown&#010 or hidden due to being added / removed from this layout.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param animateMemberTime animateMemberTime Default value is null
    */
    public void setAnimateMemberTime(Integer animateMemberTime) {
        setAttribute("animateMemberTime", animateMemberTime, true);
    }
    /**
     * If specified this is the duration of show/hide animations when members are being shown&#010 or hidden due to being added / removed from this layout.
     *
     *
     * @return Integer
     *
     */
    public Integer getAnimateMemberTime()  {
        return getAttributeAsInt("animateMemberTime");
    }

    /**
    * Layouts provide a default implementation of a drag and drop interaction.  If you set&#010 {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop 'canAcceptDrop'}:true and <code>canDropComponents:true</code>&#010 on a Layout, when a droppable Canvas ({@link com.smartgwt.client.widgets.Canvas#getCanDrop 'canDrop:true'} is dragged over&#010 the layout will show a dropLine (a simple insertion line) at the drop location.  &#010 <P>&#010 When the drop occurs, the dragTarget (obtained using&#010 {@link com.smartgwt.client.util.EventHandler#getDragTarget}) is added as a member of this layout at the location&#010 shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition}).  This default&#010 behavior allows either members or external components that have&#010 {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition canDragReposition} (or {@link com.smartgwt.client.widgets.Canvas#getCanDrag canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop canDrop} set&#010 to <code>true</code> to be added to or reordered within the Layout.&#010 <P>&#010 You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness dropLineThickness} and&#010 you can customize the style using css styling in the skin file (look for .layoutDropLine in&#010 skin_styles.css for your skin).  &#010 <P>  &#010 If you want to dynamically create a component to be added to the Layout in response to a&#010 drop event you can do so as follows: &#010 <pre>&#010 isc.VLayout.create({&#010   ...various layout properties...&#010   canDropComponents: true,&#010   drop : function () {&#010     // create the new component &#010     var newMember = isc.Canvas.create(); &#010     // add to the layout at the current drop position &#010     // (the dropLine will be showing here)&#010     this.addMember(newMember, this.getDropPosition());  &#010     // hide the dropLine that was automatically shown &#010     // by builtin SmartGWT methods&#010     this.hideDropLine();&#010   }&#010 });&#010 </pre>&#010 If you want to completely suppress the builtin drag and drop logic, but still receive drag&#010 and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop} to&#010 <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDropComponents canDropComponents Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanDropComponents(Boolean canDropComponents)  throws IllegalStateException {
        setAttribute("canDropComponents", canDropComponents, false);
    }
    /**
     * Layouts provide a default implementation of a drag and drop interaction.  If you set&#010 {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop 'canAcceptDrop'}:true and <code>canDropComponents:true</code>&#010 on a Layout, when a droppable Canvas ({@link com.smartgwt.client.widgets.Canvas#getCanDrop 'canDrop:true'} is dragged over&#010 the layout will show a dropLine (a simple insertion line) at the drop location.  &#010 <P>&#010 When the drop occurs, the dragTarget (obtained using&#010 {@link com.smartgwt.client.util.EventHandler#getDragTarget}) is added as a member of this layout at the location&#010 shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition}).  This default&#010 behavior allows either members or external components that have&#010 {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition canDragReposition} (or {@link com.smartgwt.client.widgets.Canvas#getCanDrag canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop canDrop} set&#010 to <code>true</code> to be added to or reordered within the Layout.&#010 <P>&#010 You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness dropLineThickness} and&#010 you can customize the style using css styling in the skin file (look for .layoutDropLine in&#010 skin_styles.css for your skin).  &#010 <P>  &#010 If you want to dynamically create a component to be added to the Layout in response to a&#010 drop event you can do so as follows: &#010 <pre>&#010 isc.VLayout.create({&#010   ...various layout properties...&#010   canDropComponents: true,&#010   drop : function () {&#010     // create the new component &#010     var newMember = isc.Canvas.create(); &#010     // add to the layout at the current drop position &#010     // (the dropLine will be showing here)&#010     this.addMember(newMember, this.getDropPosition());  &#010     // hide the dropLine that was automatically shown &#010     // by builtin SmartGWT methods&#010     this.hideDropLine();&#010   }&#010 });&#010 </pre>&#010 If you want to completely suppress the builtin drag and drop logic, but still receive drag&#010 and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop} to&#010 <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDropComponents()  {
        return getAttributeAsBoolean("canDropComponents");
    }

    /**
    * Thickness, in pixels of the dropLine shown during drag and drop when&#010 {@link com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the discussion in&#010 {@link com.smartgwt.client.widgets.layout.Layout} for more info.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dropLineThickness dropLineThickness Default value is 2
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDropLineThickness(int dropLineThickness)  throws IllegalStateException {
        setAttribute("dropLineThickness", dropLineThickness, false);
    }
    /**
     * Thickness, in pixels of the dropLine shown during drag and drop when&#010 {@link com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the discussion in&#010 {@link com.smartgwt.client.widgets.layout.Layout} for more info.
     *
     *
     * @return int
     *
     */
    public int getDropLineThickness()  {
        return getAttributeAsInt("dropLineThickness");
    }

    /**
    * If set to true, when a member is dragged out of layout, a visible placeholder canvas &#010 will be displayed in place of the dragged widget for the duration of the drag and drop&#010 interaction.
    *
    * @param showDragPlaceHolder showDragPlaceHolder Default value is null
    */
    public void setShowDragPlaceHolder(Boolean showDragPlaceHolder) {
        setAttribute("showDragPlaceHolder", showDragPlaceHolder, true);
    }
    /**
     * If set to true, when a member is dragged out of layout, a visible placeholder canvas &#010 will be displayed in place of the dragged widget for the duration of the drag and drop&#010 interaction.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDragPlaceHolder()  {
        return getAttributeAsBoolean("showDragPlaceHolder");
    }

    /**
    * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls the z-stacking order of&#010 members.&#010 <P>&#010 If "lastOnTop", members stack from the first member at bottom to the last member at&#010 top. If "firstOnTop", members stack from the last member at bottom to the first member&#010 at top.
    *
    * @param stackZIndex stackZIndex Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setStackZIndex(String stackZIndex)  throws IllegalStateException {
        setAttribute("stackZIndex", stackZIndex, false);
    }
    /**
     * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls the z-stacking order of&#010 members.&#010 <P>&#010 If "lastOnTop", members stack from the first member at bottom to the last member at&#010 top. If "firstOnTop", members stack from the last member at bottom to the first member&#010 at top.
     *
     *
     * @return String
     *
     */
    public String getStackZIndex()  {
        return getAttributeAsString("stackZIndex");
    }

    /**
    * If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on&#010 a member as a percentage of available space excluding the {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.  If false,&#010 percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
    *
    * @param managePercentBreadth managePercentBreadth Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setManagePercentBreadth(Boolean managePercentBreadth)  throws IllegalStateException {
        setAttribute("managePercentBreadth", managePercentBreadth, false);
    }
    /**
     * If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on&#010 a member as a percentage of available space excluding the {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.  If false,&#010 percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getManagePercentBreadth()  {
        return getAttributeAsBoolean("managePercentBreadth");
    }

    // ********************* Methods ***********************

        /**
         * An optional method that, if it exists, allows the manipulation of the calculated&#010 offset for members of this layout.  Returns the offset for the specified&#010 member.&#010
         * @param member Component to be positioned
     * @param defaultOffset Value of the currently calculated member offset. This      may be returned verbatim or manupulated in this method.
     * @param alignment alignment of the enclosing layout
         */
        public native void getMemberOffset(Canvas member, int defaultOffset, String alignment) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getMemberOffset(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultOffset, alignment);
        }-*/;


        /**
         * Return the breadth for a member of this layout which either didn't specify a breadth or&#010 specified a percent breadth with {@link com.smartgwt.client.widgets.layout.Layout#getManagePercentBreadth managePercentBreadth}:true.&#010 <P>&#010 Called only for Layouts which have a {@link com.smartgwt.client.types.LayoutPolicy} for the breadth&#010 axis of "fill", since Layouts with a breadth policy of "none" leave all member breadths alone.&#010&#010
         * @param member Component to be sized
     * @param defaultBreadth Value of the currently calculated member breadth. This      may be returned verbatim or manipulated in this method.
         */
        public native void getMemberDefaultBreadth(Canvas member, int defaultBreadth) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getMemberDefaultBreadth(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultBreadth);
        }-*/;


        /**
         * Layout members according to current settings.&#010 <P>&#010 Members will reflow automatically when the layout is resized, members resize, the list of&#010 members changes or members change visibility.  It is only necessary to manually call&#010 <code>reflow()</code> after changing settings on the layout, for example,&#010 <code>layout.reverseOrder</code>.&#010&#010
         */
        public native void reflow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reflow();
        }-*/;

        /**
         * Layout members according to current settings.&#010 <P>&#010 Members will reflow automatically when the layout is resized, members resize, the list of&#010 members changes or members change visibility.  It is only necessary to manually call&#010 <code>reflow()</code> after changing settings on the layout, for example,&#010 <code>layout.reverseOrder</code>.&#010&#010
         * @param reason reason reflow() had to be called (appear in logs if enabled)
         */
        public native void reflow(String reason) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reflow(reason);
        }-*/;

        /**
         * Layout members according to current settings, immediately.&#010 <br>&#010 Generally, when changes occur that require a layout to reflow (such as members being shown&#010 or hidden), the Layout will reflow only after a delay, so that multiple changes cause only&#010 one reflow.  To remove this delay for cases where it is not helpful, reflowNow() can be&#010 called.&#010
         */
        public native void reflowNow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reflowNow();
        }-*/;



        /**
         * Returns true if the layout includes the specified canvas.&#010
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
         * &#010 Removes the specified member from the layout. If it has a resize bar, the bar will be&#010 destroyed.&#010&#010
         * @param member the canvas to be removed from the layout
         */
        public native void removeMember(Canvas member) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.removeMember(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;




        /**
         * Hide all other members and make the single parameter member visible.&#010&#010
         * @param member member to show
         */
        public native void setVisibleMember(Canvas member) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setVisibleMember(member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

        /**
         * Shift a member of the layout to a new position&#010      &#010
         * @param memberNum current position of the member to move to a new position
     * @param newPosition new position to move the member to
         */
        public native void reorderMember(int memberNum, int newPosition) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderMember(memberNum, newPosition);
        }-*/;

        /**
         * Move a range of members to a new position&#010      &#010
         * @param start beginning of range of members to move
     * @param end end of range of members to move, non-inclusive
     * @param newPosition new position to move the members to
         */
        public native void reorderMembers(int start, int end, int newPosition) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderMembers(start, end, newPosition);
        }-*/;

        /**
         * Fires once at initialization if the layout has any initial members, and then fires whenever&#010 members are added, removed or reordered.&#010 &#010
         */
        public native void membersChanged() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.membersChanged();
        }-*/;

        /**
         * When {@link com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is true, this method will be called when a component is&#010 dropped onto the layout to determine what component to add as a new layout member.&#010 <P>&#010 By default, the actual component being dragged (isc.EventHandler.getDragTarget()) will be&#010 added to the layout.  For a different behavior, such as wrapping dropped components in&#010 Windows, or creating components on the fly from dropped data, override this method.  &#010 <P>&#010 You can also return false to cancel the drop.&#010&#010
         * @param dragTarget current drag target
     * @param dropPosition index of the drop in the list of current members
         *
         * @return Returning false will cancel the drop entirely
         */
        public native Boolean getDropComponent(Canvas dragTarget, int dropPosition) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.getDropComponent(dragTarget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), dropPosition);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * &#010 Get the position a new member would be dropped.  This drop position switches in the&#010 middle of each member, and both edges (before beginning, after end) are legal drop positions&#010 <p>&#010 Use this method to obtain the drop position for e.g. a custom drop handler.&#010&#010
         *
         * @return the position a new member would be dropped
         */
        public native int getDropPosition() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getDropPosition();
        }-*/;

        /**
         * Calling this method hides the dropLine shown during a drag and drop interaction with a&#010 Layout that has {@link com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} set to true.  This method is only useful for&#010 custom implementations of {@link com.smartgwt.client.widgets.layout.Layout#drop} as the default implementation calls this&#010 method automatically.&#010&#010
         */
        public native void hideDropLine() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.hideDropLine();
        }-*/;

    // ********************* Static Methods ***********************






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
        self.showMember(memberJS, function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        });
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
        self.hideMember(memberJS, function() {
            callback.@com.smartgwt.client.core.Function::execute()();
        });
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




