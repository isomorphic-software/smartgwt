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
 
package com.smartgwt.client.widgets.layout;


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
 * Arranges a set of "member" Canvases in horizontal or vertical stacks, applying a layout policy to determine member
 * heights and widths. <P> A Layout manages a set of "member" Canvases provided as {@link
 * com.smartgwt.client.widgets.layout.Layout#getMembers members}.  Layouts can have both "members", whose position and size
 * are managed by the Layout, and normal Canvas children, which manage their own position and size. <P> Rather than using
 * the Layout class directly, use the {@link com.smartgwt.client.widgets.layout.HLayout}, {@link
 * com.smartgwt.client.widgets.layout.VLayout}, {@link com.smartgwt.client.widgets.layout.HStack} and {@link
 * com.smartgwt.client.widgets.layout.VStack} classes, which are subclasses of Layout preconfigured for horizontal or
 * vertical stacking, with the "fill" (VLayout) or "none" (VStack) {@link com.smartgwt.client.types.LayoutPolicy policies}
 * already set. <P> Layouts and Stacks may be nested to create arbitrarily complex layouts. <p> Since Layouts can be either
 * horizontally or vertically oriented, throughout the documentation of Layout and it's subclasses, the term "length"
 * refers to the axis of stacking, and the term "breadth" refers to the other axis.  Hence, "length" means height in the
 * context of a VLayout or VStack, but means width in the context of an HLayout or HStack. <P> To show a resizer bar after
 * (to the right or bottom of) a layout member, set {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar
 * showResizeBar} to true on that member component (not on the HLayout or VLayout).  Resizer bars override {@link
 * com.smartgwt.client.widgets.layout.Layout#getMembersMargin membersMargin} spacing. <P> Like other Canvas subclasses,
 * Layout and Stack components may have % width and height values. To create a dynamically-resizing layout that occupies
 * the entire page (or entire parent component), set width and height to "100%".
 * @see com.smartgwt.client.types.LayoutPolicy
 * @see com.smartgwt.client.widgets.layout.VLayout
 * @see com.smartgwt.client.widgets.layout.HLayout
 * @see com.smartgwt.client.widgets.layout.VStack
 * @see com.smartgwt.client.widgets.layout.HStack
 * @see com.smartgwt.client.widgets.layout.LayoutSpacer
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Layout")
public class Layout extends Canvas implements com.smartgwt.client.widgets.layout.events.HasMembersChangedHandlers {

    public static Layout getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Layout(jsObj);
        } else {
            assert refInstance instanceof Layout;
            return (Layout)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Layout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Layout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Layout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Layout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Layout(){
        scClassName = "Layout";
    }

    public Layout(JavaScriptObject jsObj){
        scClassName = "Layout";
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
     * If true when members are added / removed, they should be animated as they are shown or hidden in position
     *
     * @param animateMembers New animateMembers value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_layout" target="examples">Layout Add & Remove Example</a>
     */
    public void setAnimateMembers(Boolean animateMembers) {
        setAttribute("animateMembers", animateMembers, true);
    }

    /**
     * If true when members are added / removed, they should be animated as they are shown or hidden in position
     *
     * @return Current animateMembers value. Default value is null
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
     * @param animateMemberTime New animateMemberTime value. Default value is null
     */
    public void setAnimateMemberTime(Integer animateMemberTime) {
        setAttribute("animateMemberTime", animateMemberTime, true);
    }

    /**
     * If specified this is the duration of show/hide animations when members are being shown or hidden due to being added /
     * removed from this layout.
     *
     * @return Current animateMemberTime value. Default value is null
     */
    public Integer getAnimateMemberTime()  {
        return getAttributeAsInt("animateMemberTime");
    }
    

    /**
     * Layouts provide a default implementation of a drag and drop interaction.  If you set
     *  {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop canAcceptDrop}:true and <code>canDropComponents:true</code>
     * on a Layout, when a droppable Canvas ({@link com.smartgwt.client.widgets.Canvas#getCanDrop canDrop:true} is dragged over
     *  the layout, it will show a dropLine (a simple insertion line) at the drop location.  
     *  <P>
     *  When the drop occurs, the dragTarget (obtained using
     * {@link com.smartgwt.client.util.EventHandler#getDragTarget EventHandler.getDragTarget()}) is added as a member of this
     * layout at the location
     * shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition
     * getDropPosition()}).  This default
     *  behavior allows either members or external components that have
     * {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition Canvas.canDragReposition} (or {@link
     * com.smartgwt.client.widgets.Canvas#getCanDrag Canvas.canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop
     * Canvas.canDrop} set
     *  to <code>true</code> to be added to or reordered within the Layout.
     *  <P>
     * You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness
     * dropLineThickness} and
     *  you can customize the style using css styling in the skin file (look for .layoutDropLine
     *  in skin_styles.css for your skin).  
     *  <P>
     *  If you want to dynamically create a component to be added to the Layout in response to a
     *  drop event you can do so as follows: 
     *  
     *  
     *  <pre>
     *   final VLayout vLayout = new VLayout();
     *   //...various layout properties...
     *   vLayout.setCanDropComponents(true);
     *   vLayout.addDropHandler(new DropHandler() {
     *       &#64;Override
     *       public void onDrop(DropEvent event) {
     *           // create the new component 
     *           Canvas newMember = new Canvas();
     *           // add to the layout at the current drop position  
     *           // (the dropLine will be showing here)
     *           vLayout.addMember(newMember, vLayout.getDropPosition());
     *           // hide the dropLine that was automatically shown 
     *           // by builtin SmartGWT methods
     *           vLayout.hideDropLine();
     *       }
     *   });
     *  </pre>
     *  
     *  If you want to completely suppress the builtin drag and drop logic, but still receive drag
     * and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop
     * Canvas.canAcceptDrop} to
     *  <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDropComponents New canDropComponents value. Default value is true
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
     *  the layout, it will show a dropLine (a simple insertion line) at the drop location.  
     *  <P>
     *  When the drop occurs, the dragTarget (obtained using
     * {@link com.smartgwt.client.util.EventHandler#getDragTarget EventHandler.getDragTarget()}) is added as a member of this
     * layout at the location
     * shown by the dropLine (calculated by {@link com.smartgwt.client.widgets.layout.Layout#getDropPosition
     * getDropPosition()}).  This default
     *  behavior allows either members or external components that have
     * {@link com.smartgwt.client.widgets.Canvas#getCanDragReposition Canvas.canDragReposition} (or {@link
     * com.smartgwt.client.widgets.Canvas#getCanDrag Canvas.canDrag}) and {@link com.smartgwt.client.widgets.Canvas#getCanDrop
     * Canvas.canDrop} set
     *  to <code>true</code> to be added to or reordered within the Layout.
     *  <P>
     * You can control the thickness of the dropLine via {@link com.smartgwt.client.widgets.layout.Layout#getDropLineThickness
     * dropLineThickness} and
     *  you can customize the style using css styling in the skin file (look for .layoutDropLine
     *  in skin_styles.css for your skin).  
     *  <P>
     *  If you want to dynamically create a component to be added to the Layout in response to a
     *  drop event you can do so as follows: 
     *  
     *  
     *  <pre>
     *   final VLayout vLayout = new VLayout();
     *   //...various layout properties...
     *   vLayout.setCanDropComponents(true);
     *   vLayout.addDropHandler(new DropHandler() {
     *       &#64;Override
     *       public void onDrop(DropEvent event) {
     *           // create the new component 
     *           Canvas newMember = new Canvas();
     *           // add to the layout at the current drop position  
     *           // (the dropLine will be showing here)
     *           vLayout.addMember(newMember, vLayout.getDropPosition());
     *           // hide the dropLine that was automatically shown 
     *           // by builtin SmartGWT methods
     *           vLayout.hideDropLine();
     *       }
     *   });
     *  </pre>
     *  
     *  If you want to completely suppress the builtin drag and drop logic, but still receive drag
     * and drop events for your own custom implementation, set {@link com.smartgwt.client.widgets.Canvas#getCanAcceptDrop
     * Canvas.canAcceptDrop} to
     *  <code>true</code> and <code>canDropComponents</code> to <code>false</code> on your Layout.
     *
     * @return Current canDropComponents value. Default value is true
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanDropComponents()  {
        Boolean result = getAttributeAsBoolean("canDropComponents");
        return result == null ? true : result;
    }
    
    

    /**
     * Policy for whether resize bars are shown on members by default. Note that this setting changes the effect of {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar Canvas.showResizeBar} for members of this layout.
     *
     * @param defaultResizeBars New defaultResizeBars value. Default value is "marked"
     * @see com.smartgwt.client.widgets.Canvas#setShowResizeBar
     */
    public void setDefaultResizeBars(LayoutResizeBarPolicy defaultResizeBars) {
        setAttribute("defaultResizeBars", defaultResizeBars == null ? null : defaultResizeBars.getValue(), true);
    }

    /**
     * Policy for whether resize bars are shown on members by default. Note that this setting changes the effect of {@link
     * com.smartgwt.client.widgets.Canvas#getShowResizeBar Canvas.showResizeBar} for members of this layout.
     *
     * @return Current defaultResizeBars value. Default value is "marked"
     * @see com.smartgwt.client.widgets.Canvas#getShowResizeBar
     */
    public LayoutResizeBarPolicy getDefaultResizeBars()  {
        return EnumUtil.getEnum(LayoutResizeBarPolicy.values(), getAttribute("defaultResizeBars"));
    }
    

    /**
     * Line showed to mark the drop position when components are being dragged onto this Layout. A simple Canvas typically
     * styled via CSS.  The default dropLine.styleName is "layoutDropLine".
     * <p>
     * This component is an AutoChild named "dropLine".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dropLine value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public Canvas getDropLine() throws IllegalStateException {
        errorIfNotCreated("dropLine");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("dropLine"));
    }
    

    /**
     * Thickness, in pixels of the dropLine shown during drag and drop when {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the
     * discussion in {@link com.smartgwt.client.widgets.layout.Layout} for more info.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dropLineThickness New dropLineThickness value. Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public void setDropLineThickness(int dropLineThickness)  throws IllegalStateException {
        setAttribute("dropLineThickness", dropLineThickness, false);
    }

    /**
     * Thickness, in pixels of the dropLine shown during drag and drop when {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} is set to <code>true</code>.  See the
     * discussion in {@link com.smartgwt.client.widgets.layout.Layout} for more info.
     *
     * @return Current dropLineThickness value. Default value is 2
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public int getDropLineThickness()  {
        return getAttributeAsInt("dropLineThickness");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "LayoutEditProxy"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "LayoutEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Whether the layout policy is continuously enforced as new members are added or removed and as members are resized. <p>
     * This setting implies that any member that resizes larger, or any added member, will take space from other members in
     * order to allow the overall layout to stay the same size.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enforcePolicy New enforcePolicy value. Default value is true
     */
    public void setEnforcePolicy(Boolean enforcePolicy) {
        setAttribute("enforcePolicy", enforcePolicy, true);
    }

    /**
     * Whether the layout policy is continuously enforced as new members are added or removed and as members are resized. <p>
     * This setting implies that any member that resizes larger, or any added member, will take space from other members in
     * order to allow the overall layout to stay the same size.
     *
     * @return Current enforcePolicy value. Default value is true
     */
    public Boolean getEnforcePolicy()  {
        Boolean result = getAttributeAsBoolean("enforcePolicy");
        return result == null ? true : result;
    }
    

    /**
     * Sizing policy applied to members on horizontal axis
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hPolicy New hPolicy value. Default value is "fill"
     */
    public void setHPolicy(LayoutPolicy hPolicy) {
        setAttribute("hPolicy", hPolicy == null ? null : hPolicy.getValue(), true);
    }

    /**
     * Sizing policy applied to members on horizontal axis
     *
     * @return Current hPolicy value. Default value is "fill"
     */
    public LayoutPolicy getHPolicy()  {
        return EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("hPolicy"));
    }
    

    /**
     * Space outside of all members, on the bottom side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutBottomMargin New layoutBottomMargin value. Default value is null
     */
    public void setLayoutBottomMargin(Integer layoutBottomMargin) {
        setAttribute("layoutBottomMargin", layoutBottomMargin, true);
    }

    /**
     * Space outside of all members, on the bottom side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @return Current layoutBottomMargin value. Default value is null
     */
    public Integer getLayoutBottomMargin()  {
        return getAttributeAsInt("layoutBottomMargin");
    }
    

    /**
     * Equivalent to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutRightMargin layoutRightMargin} for a horizontal
     * layout, or {@link com.smartgwt.client.widgets.layout.Layout#getLayoutBottomMargin layoutBottomMargin}  for a vertical 
     * layout. <p> If both <code>layoutEndMargin</code> and the more specific properties (right/bottom margin)  are both set,
     * the more specific properties win.
     *
     * @param layoutEndMargin New layoutEndMargin value. Default value is null
     */
    public void setLayoutEndMargin(Integer layoutEndMargin) {
        setAttribute("layoutEndMargin", layoutEndMargin, true);
    }

    /**
     * Equivalent to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutRightMargin layoutRightMargin} for a horizontal
     * layout, or {@link com.smartgwt.client.widgets.layout.Layout#getLayoutBottomMargin layoutBottomMargin}  for a vertical 
     * layout. <p> If both <code>layoutEndMargin</code> and the more specific properties (right/bottom margin)  are both set,
     * the more specific properties win.
     *
     * @return Current layoutEndMargin value. Default value is null
     */
    public Integer getLayoutEndMargin()  {
        return getAttributeAsInt("layoutEndMargin");
    }
    

    /**
     * Space outside of all members, on the left-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutLeftMargin New layoutLeftMargin value. Default value is null
     */
    public void setLayoutLeftMargin(Integer layoutLeftMargin) {
        setAttribute("layoutLeftMargin", layoutLeftMargin, true);
    }

    /**
     * Space outside of all members, on the left-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @return Current layoutLeftMargin value. Default value is null
     */
    public Integer getLayoutLeftMargin()  {
        return getAttributeAsInt("layoutLeftMargin");
    }
    

    /**
     * Space outside of all members. This attribute, along with {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} and related properties do not have a
     * true setter method.  If this method is called after the layout instance has been created, it will force a reflow of the
     * layout and pick up changes to all of the layout*Margin properties.
     *
     * @param layoutMargin New layoutMargin value. Default value is null
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
     * com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} and related properties do not have a
     * true setter method.  If this method is called after the layout instance has been created, it will force a reflow of the
     * layout and pick up changes to all of the layout*Margin properties.
     *
     * @return Current layoutMargin value. Default value is null
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
     * @param layoutRightMargin New layoutRightMargin value. Default value is null
     */
    public void setLayoutRightMargin(Integer layoutRightMargin) {
        setAttribute("layoutRightMargin", layoutRightMargin, true);
    }

    /**
     * Space outside of all members, on the right-hand side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @return Current layoutRightMargin value. Default value is null
     */
    public Integer getLayoutRightMargin()  {
        return getAttributeAsInt("layoutRightMargin");
    }
    

    /**
     * Equivalent to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} for a horizontal
     * layout, or {@link com.smartgwt.client.widgets.layout.Layout#getLayoutTopMargin layoutTopMargin}  for a vertical layout.
     * <p> If both <code>layoutStartMargin</code> and the more specific properties (top/left margin)  are both set, the more
     * specific properties win.
     *
     * @param layoutStartMargin New layoutStartMargin value. Default value is null
     */
    public void setLayoutStartMargin(Integer layoutStartMargin) {
        setAttribute("layoutStartMargin", layoutStartMargin, true);
    }

    /**
     * Equivalent to {@link com.smartgwt.client.widgets.layout.Layout#getLayoutLeftMargin layoutLeftMargin} for a horizontal
     * layout, or {@link com.smartgwt.client.widgets.layout.Layout#getLayoutTopMargin layoutTopMargin}  for a vertical layout.
     * <p> If both <code>layoutStartMargin</code> and the more specific properties (top/left margin)  are both set, the more
     * specific properties win.
     *
     * @return Current layoutStartMargin value. Default value is null
     */
    public Integer getLayoutStartMargin()  {
        return getAttributeAsInt("layoutStartMargin");
    }
    

    /**
     * Space outside of all members, on the top side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @param layoutTopMargin New layoutTopMargin value. Default value is null
     */
    public void setLayoutTopMargin(Integer layoutTopMargin) {
        setAttribute("layoutTopMargin", layoutTopMargin, true);
    }

    /**
     * Space outside of all members, on the top side.  Defaults to {@link
     * com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}. <P> Requires a manual call to
     * <code>setLayoutMargin()</code> if changed on the fly.
     *
     * @return Current layoutTopMargin value. Default value is null
     */
    public Integer getLayoutTopMargin()  {
        return getAttributeAsInt("layoutTopMargin");
    }
    

    /**
     * Whether to leave a gap for a vertical scrollbar even when one is not actually present. <P> This setting avoids the
     * layout resizing all members when the vertical scrollbar is introduced or removed, which can avoid unnecessary screen
     * shifting and improve performance.
     *
     * @param leaveScrollbarGap New leaveScrollbarGap value. Default value is false
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
     * @return Current leaveScrollbarGap value. Default value is false
     */
    public Boolean getLeaveScrollbarGap()  {
        Boolean result = getAttributeAsBoolean("leaveScrollbarGap");
        return result == null ? false : result;
    }
    

    /**
     * Part of the {@link com.smartgwt.client.docs.AutomatedTesting} system, strategy to use when generated locators for
     * members from within this Layout's members array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateMembersBy New locateMembersBy value. Default value is null
     */
    public void setLocateMembersBy(LocatorStrategy locateMembersBy) {
        setAttribute("locateMembersBy", locateMembersBy == null ? null : locateMembersBy.getValue(), true);
    }

    /**
     * Part of the {@link com.smartgwt.client.docs.AutomatedTesting} system, strategy to use when generated locators for
     * members from within this Layout's members array.
     *
     * @return Current locateMembersBy value. Default value is null
     */
    public LocatorStrategy getLocateMembersBy()  {
        return EnumUtil.getEnum(LocatorStrategy.values(), getAttribute("locateMembersBy"));
    }
    

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding members within this layout.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateMembersType New locateMembersType value. Default value is null
     */
    public void setLocateMembersType(LocatorTypeStrategy locateMembersType) {
        setAttribute("locateMembersType", locateMembersType == null ? null : locateMembersType.getValue(), true);
    }

    /**
     * {@link com.smartgwt.client.types.LocatorTypeStrategy} to use when finding members within this layout.
     *
     * @return Current locateMembersType value. Default value is null
     */
    public LocatorTypeStrategy getLocateMembersType()  {
        return EnumUtil.getEnum(LocatorTypeStrategy.values(), getAttribute("locateMembersType"));
    }
    

    /**
     * If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on a member as a percentage of
     * available space excluding the {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}.  If false,
     * percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
     *
     * @param managePercentBreadth New managePercentBreadth value. Default value is true
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
     * @return Current managePercentBreadth value. Default value is true
     */
    public Boolean getManagePercentBreadth()  {
        Boolean result = getAttributeAsBoolean("managePercentBreadth");
        return result == null ? true : result;
    }
    

    /**
     * Number of pixels by which each member should overlap the preceding member, used for creating an "stack of cards"
     * appearance for the members of a Layout. <P> <code>memberOverlap</code> can be used in conjunction with {@link
     * com.smartgwt.client.widgets.layout.Layout#getStackZIndex stackZIndex} to create a particular visual stacking order. <P>
     * Note that overlap of individual members can be accomplished with a negative setting for {@link
     * com.smartgwt.client.widgets.Canvas#getExtraSpace Canvas.extraSpace}.
     *
     * @param memberOverlap New memberOverlap value. Default value is 0
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
     * com.smartgwt.client.widgets.Canvas#getExtraSpace Canvas.extraSpace}.
     *
     * @return Current memberOverlap value. Default value is 0
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public int getMemberOverlap()  {
        return getAttributeAsInt("memberOverlap");
    }
    

    /**
     * An array of canvases that will be contained within this layout. You can set the following properties on these canvases
     * (in addition to the standard component properties): <ul>  <li>{@link com.smartgwt.client.widgets.Canvas#getLayoutAlign
     * layoutAlign} -- specifies the member's alignment along the      breadth axis; valid values are "top", "center" and
     * "bottom" for a horizontal layout      and "left", "center" and "right" for a vertical layout (see      {@link
     * com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign defaultLayoutAlign} for default implementation.) 
     * <li>{@link com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} -- set to true to show a resize bar     
     * (default is false) </ul> Height and width settings found on members are interpreted by the Layout according to the
     * {@link com.smartgwt.client.widgets.layout.Layout#getVPolicy layout policy}. <p> Note that it is valid to have null slots
     * in the provided <code>members</code> Array, and the Layout will ignore those slots. This can be useful to keep code
     * compact, for example, when constructing the <code>members</code> Array, you might use an expression that either returns
     * a component or null depending on whether the component should be present. If the expression returns null, the null slot
     * will be ignored by the Layout.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Display a new set of members in this layout. Equivalent to calling removeMembers() then addMembers(). Note that the new members may include members already present, in which case they will be reordered / integrated with any other new members passed into this method.
     *
     * @param members New members value. Default value is null
     */
    public void setMembers(Canvas... members) {
        setAttribute("members", members, true);
    }

    /**
     * An array of canvases that will be contained within this layout. You can set the following properties on these canvases
     * (in addition to the standard component properties): <ul>  <li>{@link com.smartgwt.client.widgets.Canvas#getLayoutAlign
     * layoutAlign} -- specifies the member's alignment along the      breadth axis; valid values are "top", "center" and
     * "bottom" for a horizontal layout      and "left", "center" and "right" for a vertical layout (see      {@link
     * com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign defaultLayoutAlign} for default implementation.) 
     * <li>{@link com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} -- set to true to show a resize bar     
     * (default is false) </ul> Height and width settings found on members are interpreted by the Layout according to the
     * {@link com.smartgwt.client.widgets.layout.Layout#getVPolicy layout policy}. <p> Note that it is valid to have null slots
     * in the provided <code>members</code> Array, and the Layout will ignore those slots. This can be useful to keep code
     * compact, for example, when constructing the <code>members</code> Array, you might use an expression that either returns
     * a component or null depending on whether the component should be present. If the expression returns null, the null slot
     * will be ignored by the Layout.
     *
     * @return Get the Array of members. Default value is null
     */
    public Canvas[] getMembers()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("members"));
    }
    

    /**
     * Space between each member of the layout. <P> Requires a manual call to <code>reflow()</code> if changed on the fly.
     *
     * @param membersMargin New membersMargin value. Default value is 0
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public void setMembersMargin(int membersMargin) {
        setAttribute("membersMargin", membersMargin, true);
    }

    /**
     * Space between each member of the layout. <P> Requires a manual call to <code>reflow()</code> if changed on the fly.
     *
     * @return Current membersMargin value. Default value is 0
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_user_sizing" target="examples">User Sizing Example</a>
     */
    public int getMembersMargin()  {
        return getAttributeAsInt("membersMargin");
    }
    

    /**
     * Set this property to cause the layout to assign the breadths of other members as if the available breadth is actually
     * wide enough to accommodate the <code>minBreadthMember</code> (even though the Layout might <i>not</i> actually be that
     * wide, and may overflow its assigned size along the breadth axis due to the breadth of the <code>minBreadthMember</code>.
     * <P> Without this property set, members of a layout aren't ever expanded in breadth (by the layout) to fit an overflow of
     * the layout along the breadth axis.  Setting this property will make sure all members (other than the one specified) get
     * expanded to fill the full visual breadth of the layout (assuming they are configured to use 100% layout breadth).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minBreadthMember New minBreadthMember value. Default value is null
     * @see com.smartgwt.client.types.LayoutPolicy
     */
    public void setMinBreadthMember(String minBreadthMember) {
        setAttribute("minBreadthMember", minBreadthMember, true);
    }

    /**
     * Set this property to cause the layout to assign the breadths of other members as if the available breadth is actually
     * wide enough to accommodate the <code>minBreadthMember</code> (even though the Layout might <i>not</i> actually be that
     * wide, and may overflow its assigned size along the breadth axis due to the breadth of the <code>minBreadthMember</code>.
     * <P> Without this property set, members of a layout aren't ever expanded in breadth (by the layout) to fit an overflow of
     * the layout along the breadth axis.  Setting this property will make sure all members (other than the one specified) get
     * expanded to fill the full visual breadth of the layout (assuming they are configured to use 100% layout breadth).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minBreadthMember New minBreadthMember value. Default value is null
     * @see com.smartgwt.client.types.LayoutPolicy
     */
    public void setMinBreadthMember(int minBreadthMember) {
        setAttribute("minBreadthMember", minBreadthMember, true);
    }

    /**
     * Set this property to cause the layout to assign the breadths of other members as if the available breadth is actually
     * wide enough to accommodate the <code>minBreadthMember</code> (even though the Layout might <i>not</i> actually be that
     * wide, and may overflow its assigned size along the breadth axis due to the breadth of the <code>minBreadthMember</code>.
     * <P> Without this property set, members of a layout aren't ever expanded in breadth (by the layout) to fit an overflow of
     * the layout along the breadth axis.  Setting this property will make sure all members (other than the one specified) get
     * expanded to fill the full visual breadth of the layout (assuming they are configured to use 100% layout breadth).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minBreadthMember New minBreadthMember value. Default value is null
     * @see com.smartgwt.client.types.LayoutPolicy
     */
    public void setMinBreadthMember(Canvas minBreadthMember) {
        setAttribute("minBreadthMember", minBreadthMember == null ? null : minBreadthMember.getOrCreateJsObj(), true);
    }
    

    /**
     * Minimum size, in pixels, below which flexible-sized members should never be shrunk, even if this requires the Layout to
     * overflow.  Note that this property only applies along the <i>length</i> axis of the Layout, and has no affect on
     * <i>breadth</i>. <p> Does not apply to members given a fixed size in pixels - such members will never be shrunk below
     * their specified size in general.
     *
     * @param minMemberLength New minMemberLength value. Default value is 1
     * @see com.smartgwt.client.widgets.Canvas#setMinWidth
     */
    public void setMinMemberLength(int minMemberLength) {
        setAttribute("minMemberLength", minMemberLength, true);
    }

    /**
     * Minimum size, in pixels, below which flexible-sized members should never be shrunk, even if this requires the Layout to
     * overflow.  Note that this property only applies along the <i>length</i> axis of the Layout, and has no affect on
     * <i>breadth</i>. <p> Does not apply to members given a fixed size in pixels - such members will never be shrunk below
     * their specified size in general.
     *
     * @return Current minMemberLength value. Default value is 1
     * @see com.smartgwt.client.widgets.Canvas#getMinWidth
     */
    public int getMinMemberLength()  {
        return getAttributeAsInt("minMemberLength");
    }
    

    /**
     * See {@link com.smartgwt.client.widgets.layout.Layout#getMinMemberLength minMemberLength}.
     *
     * @param minMemberSize New minMemberSize value. Default value is 1
     * @deprecated use the more intuitively named {@link com.smartgwt.client.widgets.layout.Layout#getMinMemberLength minMemberLength}
     */
    public void setMinMemberSize(int minMemberSize) {
        setAttribute("minMemberSize", minMemberSize, true);
    }

    /**
     * See {@link com.smartgwt.client.widgets.layout.Layout#getMinMemberLength minMemberLength}.
     *
     * @return Current minMemberSize value. Default value is 1
     * @deprecated use the more intuitively named {@link com.smartgwt.client.widgets.layout.Layout#getMinMemberLength minMemberLength}
     */
    public int getMinMemberSize()  {
        return getAttributeAsInt("minMemberSize");
    }
    
    

    /**
     * A Layout may overflow if it has one or more members with a fixed width or height, or that themselves overflow.  For
     * details on member sizing see {@link com.smartgwt.client.types.LayoutPolicy}. <P> Note that for overflow: "auto",
     * "scroll", or "visible", members exceeding the Layout's specified breadth but falling short of its overflow breadth will
     * keep the alignment set via {@link com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign defaultLayoutAlign} or
     * {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign Canvas.layoutAlign}.
     *
     * @param overflow New overflow value. Default value is "visible"
     * @see com.smartgwt.client.widgets.Canvas#setOverflow
     * @see com.smartgwt.client.widgets.layout.Layout#setMinBreadthMember
     */
    public void setOverflow(Overflow overflow) {
        setAttribute("overflow", overflow == null ? null : overflow.getValue(), true);
    }

    /**
     * A Layout may overflow if it has one or more members with a fixed width or height, or that themselves overflow.  For
     * details on member sizing see {@link com.smartgwt.client.types.LayoutPolicy}. <P> Note that for overflow: "auto",
     * "scroll", or "visible", members exceeding the Layout's specified breadth but falling short of its overflow breadth will
     * keep the alignment set via {@link com.smartgwt.client.widgets.layout.Layout#getDefaultLayoutAlign defaultLayoutAlign} or
     * {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign Canvas.layoutAlign}.
     *
     * @return Current overflow value. Default value is "visible"
     * @see com.smartgwt.client.widgets.Canvas#getOverflow
     * @see com.smartgwt.client.widgets.layout.Layout#getMinBreadthMember
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
     * @param paddingAsLayoutMargin New paddingAsLayoutMargin value. Default value is true
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
     * @return Current paddingAsLayoutMargin value. Default value is true
     */
    public Boolean getPaddingAsLayoutMargin()  {
        Boolean result = getAttributeAsBoolean("paddingAsLayoutMargin");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.layout.Layout#getShowDragPlaceHolder this.showDragPlaceHolder} is true, this 
     * defaults object determines the default appearance of the placeholder displayed when the user drags a widget out of this
     * layout.<br> Default value for this property sets the placeholder {@link com.smartgwt.client.widgets.Canvas#getStyleName
     * styleName} to <code>"layoutPlaceHolder"</code><br> To modify this object, use  Class.changeDefaults()
     *
     * @param placeHolderDefaults New placeHolderDefaults value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setPlaceHolderDefaults(Canvas placeHolderDefaults)  throws IllegalStateException {
        if (placeHolderDefaults != null) {
            if (placeHolderDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Layout.class, "setPlaceHolderDefaults", "Canvas");
            }                                                                       
            placeHolderDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = placeHolderDefaults == null ? null : placeHolderDefaults.getConfig();
        setAttribute("placeHolderDefaults", JSOHelper.cleanProperties(config, true), false);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.layout.Layout#getShowDragPlaceHolder this.showDragPlaceHolder} is true, this 
     * properties object can be used to customize the appearance of the placeholder displayed when the user drags a widget out
     * of this layout.
     *
     * @param placeHolderProperties New placeHolderProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see com.smartgwt.client.docs.SGWTProperties
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public void setPlaceHolderProperties(Canvas placeHolderProperties)  throws IllegalStateException {
        if (placeHolderProperties != null) {
            if (placeHolderProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(Layout.class, "setPlaceHolderProperties", "Canvas");
            }                                                                       
            placeHolderProperties.setConfigOnly(true);
        }
        JavaScriptObject config = placeHolderProperties == null ? null : placeHolderProperties.getConfig();
        setAttribute("placeHolderProperties", JSOHelper.cleanProperties(config, true), false);
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * A MultiAutoChild created to resize members of this <code>Layout</code>.
     *  <p>
     *  A resize bar will be created for any member of this <code>Layout</code> that has
     *  {@link com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar} set to <code>true</code>. Resize bars will be
     * instances of the class specified by {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass resizeBarClass}
     * by default, and will
     *  automatically be sized to the member's breadth, and to the thickness specified by
     *  {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarSize resizeBarSize}.
     *  <p>
     *  To customize the appearance or behavior of resizeBars within some layout a custom
     * resize bar class can be created by subclassing {@link com.smartgwt.client.widgets.Splitbar} or {@link
     * com.smartgwt.client.widgets.ImgSplitbar} and
     * setting {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass resizeBarClass} or
     * <code>resizeBarConstructor</code> to this custom class.
     *  
     *  
     * Alternatively, {@link com.smartgwt.client.widgets.Canvas#setAutoChildProperties(java.lang.String,
     * com.smartgwt.client.widgets.Canvas)}
     *  may be called to set resizeBar properties:
     *  <pre>
     *      final Splitbar resizeBarProperties = new Splitbar();
     *      //...
     *      layout.setAutoChildProperties("resizeBar", resizeBarProperties);
     *  </pre>
     *  See {@link com.smartgwt.client.docs.AutoChildUsage} for more information.
     *  <p>
     *  If you create a custom resize bar class in Java, enable {@link com.smartgwt.client.docs.Reflection} to
     *  allow it to be used.
     *  <p>
     *  Alternatively, you can use the &#83;martClient class system to create a simple
     *  &#83;martClient subclass of either <code>Splitbar</code> or <code>ImgSplitbar</code>
     *  for use with this API - see the {@link com.smartgwt.client.docs.Skinning Skinning Guide} for details.
     *  
     *  <p>
     *  The built-in <code>Splitbar</code> class supports drag resizing of its target member,
     *  and clicking on the bar with a mouse to collapse/uncollapse the target member.
     *
     * @return null
     */
    public Splitbar getResizeBar()  {
        return null;
    }
    

    /**
     * Default class to use for creating {@link com.smartgwt.client.widgets.layout.Layout#getResizeBar resizeBars}. This may be
     * overridden by <code>resizeBarConstructor</code>. <p> Classes that are valid by default are {@link
     * com.smartgwt.client.widgets.Splitbar}, {@link com.smartgwt.client.widgets.ImgSplitbar}, and {@link
     * com.smartgwt.client.widgets.Snapbar}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarClass New resizeBarClass value. Default value is "Splitbar"
     * @see com.smartgwt.client.widgets.Splitbar
     * @see com.smartgwt.client.widgets.ImgSplitbar
     */
    public void setResizeBarClass(String resizeBarClass) {
        setAttribute("resizeBarClass", resizeBarClass, true);
    }

    /**
     * Default class to use for creating {@link com.smartgwt.client.widgets.layout.Layout#getResizeBar resizeBars}. This may be
     * overridden by <code>resizeBarConstructor</code>. <p> Classes that are valid by default are {@link
     * com.smartgwt.client.widgets.Splitbar}, {@link com.smartgwt.client.widgets.ImgSplitbar}, and {@link
     * com.smartgwt.client.widgets.Snapbar}.
     *
     * @return Current resizeBarClass value. Default value is "Splitbar"
     * @see com.smartgwt.client.widgets.Splitbar
     * @see com.smartgwt.client.widgets.ImgSplitbar
     */
    public String getResizeBarClass()  {
        return getAttributeAsString("resizeBarClass");
    }
    

    /**
     * Thickness of the resizeBar in pixels.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarSize New resizeBarSize value. Default value is 7
     */
    public void setResizeBarSize(int resizeBarSize) {
        setAttribute("resizeBarSize", resizeBarSize, true);
    }

    /**
     * Thickness of the resizeBar in pixels.
     *
     * @return Current resizeBarSize value. Default value is 7
     */
    public int getResizeBarSize()  {
        return getAttributeAsInt("resizeBarSize");
    }
    

    /**
     * Reverse the order of stacking for this Layout, so that the last member is shown first. <P> Requires a manual call to
     * <code>reflow()</code> if changed on the fly. <P> In RTL mode, for horizontal Layouts the value of this flag will be
     * flipped during initialization.
     *
     * @param reverseOrder New reverseOrder value. Default value is false
     */
    public void setReverseOrder(Boolean reverseOrder) {
        setAttribute("reverseOrder", reverseOrder, true);
    }

    /**
     * Reverse the order of stacking for this Layout, so that the last member is shown first. <P> Requires a manual call to
     * <code>reflow()</code> if changed on the fly. <P> In RTL mode, for horizontal Layouts the value of this flag will be
     * flipped during initialization.
     *
     * @return Current reverseOrder value. Default value is false
     */
    public Boolean getReverseOrder()  {
        Boolean result = getAttributeAsBoolean("reverseOrder");
        return result == null ? false : result;
    }
    

    /**
     * If set to true, when a member is dragged out of layout, a visible placeholder canvas  will be displayed in place of the
     * dragged widget for the duration of the drag and drop interaction.
     *
     * @param showDragPlaceHolder New showDragPlaceHolder value. Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public void setShowDragPlaceHolder(Boolean showDragPlaceHolder) {
        setAttribute("showDragPlaceHolder", showDragPlaceHolder, true);
    }

    /**
     * If set to true, when a member is dragged out of layout, a visible placeholder canvas  will be displayed in place of the
     * dragged widget for the duration of the drag and drop interaction.
     *
     * @return Current showDragPlaceHolder value. Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_move" target="examples">Drag move Example</a>
     */
    public Boolean getShowDragPlaceHolder()  {
        return getAttributeAsBoolean("showDragPlaceHolder");
    }
    

    /**
     * Controls whether to show a drop-indicator during a drag and drop operation.  Set to  false if you either don't want to
     * show drop-lines, or plan to create your own.
     *
     * @param showDropLines New showDropLines value. Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setShowDropLines(Boolean showDropLines) {
        setAttribute("showDropLines", showDropLines, true);
    }

    /**
     * Controls whether to show a drop-indicator during a drag and drop operation.  Set to  false if you either don't want to
     * show drop-lines, or plan to create your own.
     *
     * @return Current showDropLines value. Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getShowDropLines()  {
        return getAttributeAsBoolean("showDropLines");
    }
    

    /**
     * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls
     * the z-stacking order of members. <P> If set to "lastOnTop", members stack from the first member at bottom to the last
     * member at top. If set to "firstOnTop", members stack from the last member at bottom to the first member at top.
     *
     * @param stackZIndex New stackZIndex value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStackZIndex(String stackZIndex)  throws IllegalStateException {
        setAttribute("stackZIndex", stackZIndex, false);
    }

    /**
     * For use in conjunction with {@link com.smartgwt.client.widgets.layout.Layout#getMemberOverlap memberOverlap}, controls
     * the z-stacking order of members. <P> If set to "lastOnTop", members stack from the first member at bottom to the last
     * member at top. If set to "firstOnTop", members stack from the last member at bottom to the first member at top.
     *
     * @return Current stackZIndex value. Default value is null
     */
    public String getStackZIndex()  {
        return getAttributeAsString("stackZIndex");
    }
    

    /**
     * Should this layout appear with members stacked vertically or horizontally. Defaults to  <code>false</code> if
     * unspecified.
     *
     * @param vertical New vertical value. Default value is null
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Should this layout appear with members stacked vertically or horizontally. Defaults to  <code>false</code> if
     * unspecified.
     *
     * @return Current vertical value. Default value is null
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }
    

    /**
     * Sizing policy applied to members on vertical axis
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param vPolicy New vPolicy value. Default value is "fill"
     */
    public void setVPolicy(LayoutPolicy vPolicy) {
        setAttribute("vPolicy", vPolicy == null ? null : vPolicy.getValue(), true);
    }

    /**
     * Sizing policy applied to members on vertical axis
     *
     * @return Current vPolicy value. Default value is "fill"
     */
    public LayoutPolicy getVPolicy()  {
        return EnumUtil.getEnum(LayoutPolicy.values(), getAttribute("vPolicy"));
    }
    

    // ********************* Methods ***********************
	/**
     * Layout overrides {@link com.smartgwt.client.widgets.Canvas#getChildTabPosition Canvas.getChildTabPosition()} to ensure
     * children are ordered in the tab-sequence with members being reachable first (in member order), then any non-member
     * children. <P> As with {@link com.smartgwt.client.widgets.Canvas#getChildTabPosition Canvas.getChildTabPosition()} if
     * {@link com.smartgwt.client.widgets.Canvas#setRelativeTabPosition Canvas.setRelativeTabPosition()} was called explicitly
     * called for some child, it will be respected over member order.
     * @param child The child for which the tab position should be returned
     *
     * @return tab position of the child within this layout.
     */
    public native Integer getChildTabPosition(Canvas child) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChildTabPosition", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChildTabPosition(child == null ? null : child.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Get the position a new member would be dropped.  This drop position switches in the middle of each member, and both
     * edges (before beginning, after end) are legal drop positions <p> Use this method to obtain the drop position for e.g. a
     * custom drop handler.
     *
     * @return the position a new member would be dropped
     */
    public native int getDropPosition() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDropPosition", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDropPosition();
        return ret;
    }-*/;

	/**
     * Given a numerical index or a member {@link com.smartgwt.client.widgets.Canvas#getName name} or member {@link
     * com.smartgwt.client.widgets.Canvas#getID ID}, return a pointer to the appropriate member.  If passed a member Canvas,
     * just returns it. <p> Note that if more than one member has the same <code>name</code>, passing in a <code>name</code>
     * has an undefined result.
     * @param memberID identifier for the required member
     *
     * @return member widget
     * @see com.smartgwt.client.widgets.layout.Layout#getMemberNumber
     */
    public native Canvas getMember(String memberID) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMember", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMember(memberID);
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the breadth for a member of this layout which either didn't specify a breadth or specified a percent breadth with
     * {@link com.smartgwt.client.widgets.layout.Layout#getManagePercentBreadth managePercentBreadth}:true. <P> Called only for
     * Layouts which have a {@link com.smartgwt.client.types.LayoutPolicy layout policy} for the breadth axis of "fill", since
     * Layouts with a breadth policy of "none" leave all member breadths alone.
     * @param member Component to be sized
     * @param defaultBreadth Value of the currently calculated member breadth. This      may be returned verbatim or manipulated in this method.
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public native void getMemberDefaultBreadth(Canvas member, int defaultBreadth) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMemberDefaultBreadth", "Canvas,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getMemberDefaultBreadth(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultBreadth);
    }-*/;

	/**
     * Given a member Canvas or member {@link com.smartgwt.client.widgets.Canvas#getID ID} or {@link
     * com.smartgwt.client.widgets.Canvas#getName name}, return the index of that member within this layout's members array. 
     * If passed a number, just returns it. <p> Note that if more than one member has the same <code>name</code>, passing in a
     * <code>name</code> has an undefined result.
     * @param memberID identifier for the required member
     *
     * @return index of the member canvas (or -1 if not found)
     * @see com.smartgwt.client.widgets.layout.Layout#getMember
     */
    public native int getMemberNumber(String memberID) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMemberNumber", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMemberNumber(memberID);
        return ret;
    }-*/;

	/**
     * Convenience method to return the number of members this Layout has
     *
     * @return the number of members this Layout has
     */
    public native Integer getMembersLength() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMembersLength", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMembersLength();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Returns true if the layout includes the specified canvas.
     * @param canvas the canvas to check for
     *
     * @return true if the layout includes the specified canvas
     */
    public native Boolean hasMember(Canvas canvas) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasMember(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Calling this method hides the dropLine shown during a drag and drop interaction with a Layout that has {@link
     * com.smartgwt.client.widgets.layout.Layout#getCanDropComponents canDropComponents} set to true.  This method is only
     * useful for custom implementations of {@link com.smartgwt.client.widgets.layout.Layout#drop drop()} as the default
     * implementation calls this method automatically.
     */
    public native void hideDropLine() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideDropLine", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideDropLine();
    }-*/;

	/**
     * Hide the specified member, firing the specified callback when the hide is complete. <P> Members can always be directly
     * hidden via <code>member.hide()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animation} is enabled, animation will only occur if hideMember() is called to hide the member.
     * @param member Member to hide
     */
    public native void hideMember(Canvas member) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Hide the specified member, firing the specified callback when the hide is complete. <P> Members can always be directly
     * hidden via <code>member.hide()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animation} is enabled, animation will only occur if hideMember() is called to hide the member.
     * @param member Member to hide
     * @param callback callback to fire when the member is hidden.
     */
    public native void hideMember(Canvas member, Function callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideMember", "Canvas,Function");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	
	/**
     * Returns whether there is a pending reflow of the members of the layout. <P> Modifying the set of members, resizing
     * members or changing layout settings will cause a recalculation of member sizes to be scheduled.  The recalculation is
     * delayed so that it is not performed redundantly if multiple changes are made in a row.   <P> To force immediate
     * recalculation of new member sizes and resizing of members, call {@link
     * com.smartgwt.client.widgets.layout.Layout#reflowNow reflowNow()}.
     *
     * @return whether the layout is currently dirty
     */
    public native boolean layoutIsDirty() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "layoutIsDirty", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.layoutIsDirty();
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a membersChanged handler.
     * <p>
     * Fires once at initialization if the layout has any initial members, and then fires whenever members are added, removed
     * or reordered.
     *
     * @param handler the membersChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMembersChangedHandler(com.smartgwt.client.widgets.layout.events.MembersChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.MembersChangedEvent.getType()) == 0) setupMembersChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.MembersChangedEvent.getType());
    }

    private native void setupMembersChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var membersChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.MembersChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.Layout::handleTearDownMembersChangedEvent()();
            if (hasDefaultHandler) this.Super("membersChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("membersChanged"));
            obj.addProperties({membersChanged:  membersChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("membersChanged"));
            obj.membersChanged =  membersChanged             ;
        }
    }-*/;

    private void handleTearDownMembersChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.MembersChangedEvent.getType()) == 0) tearDownMembersChangedEvent();
    }

    private native void tearDownMembersChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("membersChanged")) delete obj.membersChanged;
    }-*/;

	/**
     * Layout members according to current settings. <P> Members will reflow automatically when the layout is resized, members
     * resize, the list of members changes or members change visibility.  It is only necessary to manually call
     * <code>reflow()</code> after changing settings on the layout, for example, <code>layout.reverseOrder</code>.
     */
    public native void reflow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reflow", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reflow", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflow(reason);
    }-*/;
	
	/**
     * Layout members according to current settings, immediately. <br> Generally, when changes occur that require a layout to
     * reflow (such as members being shown or hidden), the Layout will reflow only after a delay, so that multiple changes
     * cause only one reflow.  To remove this delay for cases where it is not helpful, reflowNow() can be called.
     */
    public native void reflowNow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reflowNow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reflowNow();
    }-*/;

	/**
     * Removes the specified member from the layout.  If it has a resize bar, the bar will be destroyed.
     * @param member the canvas to be removed from the layout
     */
    public native void removeMember(Canvas member) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Removes the specified members from the layout. If any of the removed members have resize  bars, the bars will be
     * destroyed.
     * @param members array of members to be removed, or single member
     */
    public native void removeMembers(Canvas... members) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeMembers", "Canvas...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeMembers(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(members));
    }-*/;

	/**
     * Removes the specified members from the layout. If any of the removed members have resize  bars, the bars will be
     * destroyed.
     * @param members array of members to be removed, or single member
     */
    public native void removeMembers(Canvas members) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeMembers", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeMembers(members == null ? null : members.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Shift a member of the layout to a new position
     * @param memberNum current position of the member to move to a new position
     * @param newPosition new position to move the member to
     */
    public native void reorderMember(int memberNum, int newPosition) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reorderMember", "int,int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reorderMembers", "int,int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderMembers(start, end, newPosition);
    }-*/;

	/**
     * Hide all other members and make the single parameter member visible.
     * @param member member to show
     */
    public native void setVisibleMember(Canvas member) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setVisibleMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setVisibleMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Show the specified member, firing the specified callback when the show is complete. <P> Members can always be directly
     * shown via <code>member.show()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animation} is enabled, animation will only occur if showMember() is called to show the member.
     * @param member Member to show
     */
    public native void showMember(Canvas member) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showMember", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Show the specified member, firing the specified callback when the show is complete. <P> Members can always be directly
     * shown via <code>member.show()</code>, but if {@link com.smartgwt.client.widgets.layout.Layout#getAnimateMembers
     * animation} is enabled, animation will only occur if showMember() is called to show the member.
     * @param member Member to show
     * @param callback action to fire when the member has been shown
     */
    public native void showMember(Canvas member, Function callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showMember", "Canvas,Function");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showMember(member == null ? null : member.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;
	

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
     * @param layoutProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Layout layoutProperties) /*-{
        if (layoutProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Layout.@java.lang.Object::getClass()(), "setDefaultProperties", layoutProperties.@java.lang.Object::getClass()());
        }
        layoutProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = layoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
            var dragTargetJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(dragTarget);
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
        return ret == null || ret == undefined ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


    private native void addMembers(Object[] newMembers, int position) /*-{
        var membersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(newMembers);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addMembers(membersJS, position);
    }-*/;

    /**
     * Add one or more canvases to the layout.  NOTE: depending on the layout policy, adding
     * a new member may cause existing members to resize.
     * @param newMembers canvases to be added
     */
    public void addMembers(Canvas... newMembers) {
        this.addMembers(newMembers, this.getMembers().length);
    }

    /**
     * Add one or more canvases to the layout at specific positions.  NOTE: depending on the
     * layout policy, adding a new member may cause existing members to  resize.
     * @param newMembers array of canvases to be added
     * @param position position to add newMembers
     * position
     */
    public void addMembers(Canvas[] newMembers, int position) {
        Object[] newMemberObjects = new Object[newMembers.length];
        for (int i = 0; i < newMembers.length; i++) {
            newMemberObjects[i] = newMembers[i].getOrCreateJsObj();
        }
        this.addMembers(newMemberObjects, position);
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
        if (dropLineProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setDropLineProperties", "Canvas");
        }                                                                       
        dropLineProperties.setConfigOnly(true);

        JavaScriptObject config = dropLineProperties.getConfig();
        setAttribute("dropLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Alignment of all members in this Layout on the length axis.  Defaults to "top" for vertical Layouts, and "left"
     * for horizontal Layouts.
     * <br>
     * Horizontal layouts should only be changed to Alignment, and vertical layouts to VerticalAlignment, otherwise
     * they will be considered invalid values, and assigning an invalid value here will log a warning to the Developer Console.
     * <br>
     * For alignment on the breadth axis, see {@link com.smartgwt.client.widgets.Layout.setDefaultLayoutAlign defaultLayoutAlign} and 
     * {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign layoutAlign}.
     *
     * @param alignment alignment Default value is null
     */
    public void setAlign(Alignment alignment) {
        setAttribute("align", alignment.getValue(), true);
    }

    /**
     * Alignment of all members in this Layout on the length axis.  Defaults to "top" for vertical Layouts, and "left"
     * for horizontal Layouts.
     * <br>
     * Horizontal layouts should only be changed to Alignment, and vertical layouts to VerticalAlignment, otherwise
     * they will be considered invalid values, and assigning an invalid value here will log a warning to the Developer Console.
     * <br>
     * For alignment on the breadth axis, see {@link com.smartgwt.client.widgets.Layout.setDefaultLayoutAlign defaultLayoutAlign} and 
     * {@link com.smartgwt.client.widgets.Canvas#getLayoutAlign layoutAlign}.
     *
     * @param alignment alignment Default value is null
     */
    public void setAlign(VerticalAlignment alignment) {
        setAttribute("align", alignment.getValue(), true);
    }

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
        return ret == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * Reveals the child or member Canvas passed in by showing it if it is currently hidden.
     * <b>NOTE: This is an override point.</b>
     * @param childID the global ID of the child Canvas to reveal
     */
    public native void revealChild(String childID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__revealChild(childID);
    }-*/;
    
	/**
     * Reveals the child or member Canvas passed in by showing it if it is currently hidden
     * <b>NOTE: This is an override point.</b>
     * @param child the child Canvas to reveal
     */
    public native void revealChild(Canvas child) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var childJS = child == null ? null : child.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        self.__revealChild(childJS);
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(LayoutLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alignAsString = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.alignAsString:" + t.getMessage() + "\n";
        }
        try {
            s.animateMembers = getAttributeAsString("animateMembers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.animateMembers:" + t.getMessage() + "\n";
        }
        try {
            s.animateMemberTime = getAttributeAsString("animateMemberTime");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.animateMemberTime:" + t.getMessage() + "\n";
        }
        try {
            s.canDropComponents = getAttributeAsString("canDropComponents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.canDropComponents:" + t.getMessage() + "\n";
        }
        try {
            s.defaultLayoutAlignAsString = getAttributeAsString("defaultLayoutAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.defaultLayoutAlignAsString:" + t.getMessage() + "\n";
        }
        try {
            s.defaultResizeBars = getAttributeAsString("defaultResizeBars");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.defaultResizeBars:" + t.getMessage() + "\n";
        }
        try {
            s.dropLineThickness = getAttributeAsString("dropLineThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.dropLineThickness:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.enforcePolicy = getAttributeAsString("enforcePolicy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.enforcePolicy:" + t.getMessage() + "\n";
        }
        try {
            s.hPolicy = getAttributeAsString("hPolicy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.hPolicy:" + t.getMessage() + "\n";
        }
        try {
            s.layoutBottomMargin = getAttributeAsString("layoutBottomMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutBottomMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutEndMargin = getAttributeAsString("layoutEndMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutEndMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutLeftMargin = getAttributeAsString("layoutLeftMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutLeftMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutMargin = getAttributeAsString("layoutMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutRightMargin = getAttributeAsString("layoutRightMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutRightMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutStartMargin = getAttributeAsString("layoutStartMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutStartMargin:" + t.getMessage() + "\n";
        }
        try {
            s.layoutTopMargin = getAttributeAsString("layoutTopMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.layoutTopMargin:" + t.getMessage() + "\n";
        }
        try {
            s.leaveScrollbarGap = getAttributeAsString("leaveScrollbarGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.leaveScrollbarGap:" + t.getMessage() + "\n";
        }
        try {
            s.locateMembersBy = getAttributeAsString("locateMembersBy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.locateMembersBy:" + t.getMessage() + "\n";
        }
        try {
            s.locateMembersType = getAttributeAsString("locateMembersType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.locateMembersType:" + t.getMessage() + "\n";
        }
        try {
            s.managePercentBreadth = getAttributeAsString("managePercentBreadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.managePercentBreadth:" + t.getMessage() + "\n";
        }
        try {
            s.memberOverlap = getAttributeAsString("memberOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.memberOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.members = getMembers();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.membersArray:" + t.getMessage() + "\n";
        }
        try {
            s.membersMargin = getAttributeAsString("membersMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.membersMargin:" + t.getMessage() + "\n";
        }
        try {
            s.minMemberLength = getAttributeAsString("minMemberLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.minMemberLength:" + t.getMessage() + "\n";
        }
        try {
            s.minMemberSize = getAttributeAsString("minMemberSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.minMemberSize:" + t.getMessage() + "\n";
        }
        try {
            s.overflow = getAttributeAsString("overflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.overflow:" + t.getMessage() + "\n";
        }
        try {
            s.paddingAsLayoutMargin = getAttributeAsString("paddingAsLayoutMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.paddingAsLayoutMargin:" + t.getMessage() + "\n";
        }
        try {
            s.resizeBarClass = getAttributeAsString("resizeBarClass");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.resizeBarClass:" + t.getMessage() + "\n";
        }
        try {
            s.resizeBarSize = getAttributeAsString("resizeBarSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.resizeBarSize:" + t.getMessage() + "\n";
        }
        try {
            s.reverseOrder = getAttributeAsString("reverseOrder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.reverseOrder:" + t.getMessage() + "\n";
        }
        try {
            s.showDragPlaceHolder = getAttributeAsString("showDragPlaceHolder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.showDragPlaceHolder:" + t.getMessage() + "\n";
        }
        try {
            s.showDropLines = getAttributeAsString("showDropLines");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.showDropLines:" + t.getMessage() + "\n";
        }
        try {
            s.stackZIndex = getAttributeAsString("stackZIndex");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.stackZIndex:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vPolicy = getAttributeAsString("vPolicy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Layout.vPolicy:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        LayoutLogicalStructure s = new LayoutLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
