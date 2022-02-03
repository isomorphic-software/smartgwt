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
 * Navigation control implemented as a horizontal layout showing back and forward controls  and a title.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("NavigationBar")
public class NavigationBar extends HLayout implements com.smartgwt.client.widgets.layout.events.HasDownClickHandlers, com.smartgwt.client.widgets.layout.events.HasNavigationClickHandlers, com.smartgwt.client.widgets.layout.events.HasUpClickHandlers {

    public static NavigationBar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new NavigationBar(jsObj);
        } else {
            assert refInstance instanceof NavigationBar;
            return (NavigationBar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavigationBar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.NavigationBar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavigationBar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.NavigationBar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public NavigationBar(){
        scClassName = "NavigationBar";
    }

    public NavigationBar(JavaScriptObject jsObj){
        scClassName = "NavigationBar";
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
     * If set, the left button title will never be omitted in an attempt to fit the full title. See the documentation of {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} for details.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getAlwaysShowLeftButtonTitle alwaysShowLeftButtonTitle}.
     *
     * @param alwaysShowLeftButtonTitle new value for <code>alwaysShowLeftButtonTitle</code>. Default value is false
     */
    public void setAlwaysShowLeftButtonTitle(boolean alwaysShowLeftButtonTitle) {
        setAttribute("alwaysShowLeftButtonTitle", alwaysShowLeftButtonTitle, true);
    }

    /**
     * If set, the left button title will never be omitted in an attempt to fit the full title. See the documentation of {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} for details.
     *
     * @return Current alwaysShowLeftButtonTitle value. Default value is false
     */
    public boolean getAlwaysShowLeftButtonTitle()  {
        Boolean result = getAttributeAsBoolean("alwaysShowLeftButtonTitle");
        return result == null ? false : result;
    }
    

    /**
     * Whether to animate a change of the view state via {@link com.smartgwt.client.widgets.layout.NavigationBar#setViewState
     * setViewState()}. <p> Enabling animation of state changes does have a performance impact because more components need to
     * be created by the <code>NavigationBar</code> to implement the animated transitions. It is therefore recommended to leave
     * <code>animateStateChanges</code> at its default value of <code>false</code> unless {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#setViewState setViewState()} might be called on this
     * <code>NavigationBar</code> instance and animation is desired. <p> Note also that when animation is enabled, certain
     * AutoChild defaults and properties may be used to create other AutoChildren that are internal to the animation
     * implementation. This generally does not cause an issue unless certain non-UI event handlers are added to the defaults
     * and/or properties (e.g. {@link com.smartgwt.client.widgets.Canvas#addVisibilityChangedHandler
     * Canvas.visibilityChanged()}, {@link com.smartgwt.client.widgets.Canvas#addResizedHandler Canvas.resized()}). For those
     * types of handlers, a check should be added to make sure that the handler is running for the expected component.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateStateChanges New animateStateChanges value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAnimateStateChanges(boolean animateStateChanges)  throws IllegalStateException {
        setAttribute("animateStateChanges", animateStateChanges, false);
    }

    /**
     * Whether to animate a change of the view state via {@link com.smartgwt.client.widgets.layout.NavigationBar#setViewState
     * setViewState()}. <p> Enabling animation of state changes does have a performance impact because more components need to
     * be created by the <code>NavigationBar</code> to implement the animated transitions. It is therefore recommended to leave
     * <code>animateStateChanges</code> at its default value of <code>false</code> unless {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#setViewState setViewState()} might be called on this
     * <code>NavigationBar</code> instance and animation is desired. <p> Note also that when animation is enabled, certain
     * AutoChild defaults and properties may be used to create other AutoChildren that are internal to the animation
     * implementation. This generally does not cause an issue unless certain non-UI event handlers are added to the defaults
     * and/or properties (e.g. {@link com.smartgwt.client.widgets.Canvas#addVisibilityChangedHandler
     * Canvas.visibilityChanged()}, {@link com.smartgwt.client.widgets.Canvas#addResizedHandler Canvas.resized()}). For those
     * types of handlers, a check should be added to make sure that the handler is running for the expected component.
     *
     * @return Current animateStateChanges value. Default value is false
     */
    public boolean getAnimateStateChanges()  {
        Boolean result = getAttributeAsBoolean("animateStateChanges");
        return result == null ? false : result;
    }
    

    /**
     * An arbitrary component that will be placed where the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl miniNavControl} AutoChild would normally be placed
     * (see {@link com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavAlign miniNavAlign}).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter to update the {@link com.smartgwt.client.widgets.layout.NavigationBar#getCustomNavControl customNavControl} at runtime.
     *
     * @param customNavControl New customNavControl value. Default value is null
     */
    public void setCustomNavControl(Canvas customNavControl) {
        setAttribute("customNavControl", customNavControl == null ? null : customNavControl.getOrCreateJsObj(), true);
    }

    /**
     * An arbitrary component that will be placed where the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl miniNavControl} AutoChild would normally be placed
     * (see {@link com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavAlign miniNavAlign}).
     *
     * @return Current customNavControl value. Default value is null
     */
    public Canvas getCustomNavControl()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("customNavControl"));
    }
    

    /**
     * The button displayed to the left of the title in this NavigationBar. By default this will be a {@link
     * com.smartgwt.client.widgets.NavigationButton} with {@link com.smartgwt.client.widgets.NavigationButton#getDirection
     * direction} set to  {@link com.smartgwt.client.types.NavigationDirection#BACK}. <p> The following {@link
     * com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle} for {@link
     * com.smartgwt.client.widgets.Button#getTitle Button.title}</li> <li>{@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonIcon leftButtonIcon} for {@link
     * com.smartgwt.client.widgets.Button#getIcon Button.icon}</li> </ul>
     * <p>
     * This component is an AutoChild named "leftButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current leftButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.layout.NavigationBar#getShowLeftButton
     */
    public NavigationButton getLeftButton() throws IllegalStateException {
        errorIfNotCreated("leftButton");
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("leftButton"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonIcon leftButtonIcon}.
     *
     * @param leftButtonIcon new icon for left button. Default value is "[SKIN]back_arrow.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setLeftButtonIcon(String leftButtonIcon) {
        setAttribute("leftButtonIcon", leftButtonIcon, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}.
     *
     * @return Current leftButtonIcon value. Default value is "[SKIN]back_arrow.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getLeftButtonIcon()  {
        return getAttributeAsString("leftButtonIcon");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle}.
     *
     * @param leftButtonTitle new title HTML for the left button. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setLeftButtonTitle(String leftButtonTitle) {
        setAttribute("leftButtonTitle", leftButtonTitle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}.
     *
     * @return Current leftButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLeftButtonTitle()  {
        return getAttributeAsString("leftButtonTitle");
    }
    

    /**
     * Maximum amount in pixels that the title will be placed off center in an effort to avoid clipping it - see {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title}.
     *
     * @param maxCenterOffset New maxCenterOffset value. Default value is 40
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMaxCenterOffset(int maxCenterOffset)  throws IllegalStateException {
        setAttribute("maxCenterOffset", maxCenterOffset, false);
    }

    /**
     * Maximum amount in pixels that the title will be placed off center in an effort to avoid clipping it - see {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title}.
     *
     * @return Current maxCenterOffset value. Default value is 40
     */
    public int getMaxCenterOffset()  {
        return getAttributeAsInt("maxCenterOffset");
    }
    

    /**
     * Placement of {@link com.smartgwt.client.widgets.MiniNavControl}, if present: <ul>   <li> "right" alignment places the
     * miniNav on the far right   <li> "center" alignment places the miniNav in the center, or to the right of the title       
     * if the title is present   <li> "left" alignment will place the miniNav on the left, or to the right of the        {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton} if its present. </ul>
     *
     * @param miniNavAlign New miniNavAlign value. Default value is "right"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMiniNavAlign(Alignment miniNavAlign)  throws IllegalStateException {
        setAttribute("miniNavAlign", miniNavAlign == null ? null : miniNavAlign.getValue(), false);
    }

    /**
     * Placement of {@link com.smartgwt.client.widgets.MiniNavControl}, if present: <ul>   <li> "right" alignment places the
     * miniNav on the far right   <li> "center" alignment places the miniNav in the center, or to the right of the title       
     * if the title is present   <li> "left" alignment will place the miniNav on the left, or to the right of the        {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton} if its present. </ul>
     *
     * @return Current miniNavAlign value. Default value is "right"
     */
    public Alignment getMiniNavAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("miniNavAlign"));
    }
    

    /**
     * AutoChild of type {@link com.smartgwt.client.widgets.MiniNavControl}.  Not shown by default (see {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getShowMiniNavControl showMiniNavControl}).  Also, if a {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getCustomNavControl customNavControl} is provided, then the
     * <code>customNavControl</code> is used instead of an automatically created <code>miniNavControl</code>.
     * <p>
     * This component is an AutoChild named "miniNavControl".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current miniNavControl value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public MiniNavControl getMiniNavControl() throws IllegalStateException {
        errorIfNotCreated("miniNavControl");
        return (MiniNavControl)MiniNavControl.getByJSObject(getAttributeAsJavaScriptObject("miniNavControl"));
    }
    

    /**
     * The button displayed to the right of the title in this NavigationBar. By default this will be a {@link
     * com.smartgwt.client.widgets.NavigationButton} with {@link com.smartgwt.client.widgets.NavigationButton#getDirection
     * direction} set to <code>"forward"</code>. <p> The following {@link com.smartgwt.client.docs.AutoChildUsage passthroughs}
     * apply: <ul> <li>{@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle} for {@link
     * com.smartgwt.client.widgets.Button#getTitle Button.title}</li> <li>{@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonIcon rightButtonIcon} for {@link
     * com.smartgwt.client.widgets.Button#getIcon Button.icon}</li> </ul>
     * <p>
     * This component is an AutoChild named "rightButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current rightButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.layout.NavigationBar#getShowRightButton
     */
    public NavigationButton getRightButton() throws IllegalStateException {
        errorIfNotCreated("rightButton");
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("rightButton"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonIcon rightButtonIcon}.
     *
     * @param rightButtonIcon new icon for the right button. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setRightButtonIcon(String rightButtonIcon) {
        setAttribute("rightButtonIcon", rightButtonIcon, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}.
     *
     * @return Current rightButtonIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getRightButtonIcon()  {
        return getAttributeAsString("rightButtonIcon");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle}.
     *
     * @param rightButtonTitle new title HTML for the right button. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setRightButtonTitle(String rightButtonTitle) {
        setAttribute("rightButtonTitle", rightButtonTitle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}.
     *
     * @return Current rightButtonTitle value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getRightButtonTitle()  {
        return getAttributeAsString("rightButtonTitle");
    }
    

    /**
     * Short title to display for the left button title if there is not enough room to show the title for the navigation bar. 
     * Setting to null or an empty string ("") will avoid a shortened title ever being used.  See {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} for a full description.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getShortLeftButtonTitle shortLeftButtonTitle}.
     *
     * @param shortLeftButtonTitle new short title HTML. Default value is "Back"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setShortLeftButtonTitle(String shortLeftButtonTitle) {
        setAttribute("shortLeftButtonTitle", shortLeftButtonTitle, true);
    }

    /**
     * Short title to display for the left button title if there is not enough room to show the title for the navigation bar. 
     * Setting to null or an empty string ("") will avoid a shortened title ever being used.  See {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} for a full description.
     *
     * @return Current shortLeftButtonTitle value. Default value is "Back"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getShortLeftButtonTitle()  {
        return getAttributeAsString("shortLeftButtonTitle");
    }
    

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     * is not shown.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}. The <code>leftButton</code> must be a {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls control} of this <code>NavigationBar</code> or else it will still be hidden.
     *
     * @param showLeftButton if <code>false</code>, then the <code>leftButton</code> will be hidden. If unset or <code>true</code> then the
     * <code>leftButton</code> will be shown as long as it is a member of the <code>controls</code> array. Default value is null
     */
    public void setShowLeftButton(Boolean showLeftButton) {
        setAttribute("showLeftButton", showLeftButton, true);
    }

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     * is not shown.
     *
     * @return Current showLeftButton value. Default value is null
     */
    public Boolean getShowLeftButton()  {
        return getAttributeAsBoolean("showLeftButton");
    }
    

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl
     * miniNavControl} is not shown.
     *
     * @param showMiniNavControl New showMiniNavControl value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowMiniNavControl(boolean showMiniNavControl)  throws IllegalStateException {
        setAttribute("showMiniNavControl", showMiniNavControl, false);
    }

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl
     * miniNavControl} is not shown.
     *
     * @return Current showMiniNavControl value. Default value is false
     */
    public boolean getShowMiniNavControl()  {
        Boolean result = getAttributeAsBoolean("showMiniNavControl");
        return result == null ? false : result;
    }
    

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton
     * rightButton} is not shown.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}. The <code>rightButton</code> must be a {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls control} of this <code>NavigationBar</code> or else it will still be hidden.
     *
     * @param showRightButton if <code>false</code>, then the <code>rightButton</code> will be hidden. If unset or <code>true</code> then the
     * <code>rightButton</code> will be shown as long as it is a member of the <code>controls</code> array. Default value is null
     */
    public void setShowRightButton(Boolean showRightButton) {
        setAttribute("showRightButton", showRightButton, true);
    }

    /**
     * If set to <code>false</code>, then the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton
     * rightButton} is not shown.
     *
     * @return Current showRightButton value. Default value is null
     */
    public Boolean getShowRightButton()  {
        return getAttributeAsBoolean("showRightButton");
    }
    

    /**
     * The title to display in the center of this navigation bar. <p> If there is not enough room for the title with the
     * current titles of the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton left} and {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton right} buttons, space will be used as follows: <ul> <li>
     * if the title can be fully visible without clipping if it is placed slightly off-center, it will be placed off-center, up
     * to a maximum of {@link com.smartgwt.client.widgets.layout.NavigationBar#getMaxCenterOffset maxCenterOffset} pixels <li>
     * if that's not enough space, if a {@link com.smartgwt.client.widgets.layout.NavigationBar#getShortLeftButtonTitle
     * shortLeftButtonTitle} is provided, it will be used in lieu of the normal left button title <li> if that's still not
     * enough space, the title of the left button will be hidden, leaving only the icon.  This will be skipped if either {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getAlwaysShowLeftButtonTitle alwaysShowLeftButtonTitle} has been set or
     * the button has no icon, which would leave the space blank. <li> if that's still not enough space, the title text will be
     * clipped, showing an ellipsis (where browser support allows this) </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the {@link com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} for this <code>NavigationBar</code>.
     *
     * @param title new title HTML. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The title to display in the center of this navigation bar. <p> If there is not enough room for the title with the
     * current titles of the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton left} and {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton right} buttons, space will be used as follows: <ul> <li>
     * if the title can be fully visible without clipping if it is placed slightly off-center, it will be placed off-center, up
     * to a maximum of {@link com.smartgwt.client.widgets.layout.NavigationBar#getMaxCenterOffset maxCenterOffset} pixels <li>
     * if that's not enough space, if a {@link com.smartgwt.client.widgets.layout.NavigationBar#getShortLeftButtonTitle
     * shortLeftButtonTitle} is provided, it will be used in lieu of the normal left button title <li> if that's still not
     * enough space, the title of the left button will be hidden, leaving only the icon.  This will be skipped if either {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getAlwaysShowLeftButtonTitle alwaysShowLeftButtonTitle} has been set or
     * the button has no icon, which would leave the space blank. <li> if that's still not enough space, the title text will be
     * clipped, showing an ellipsis (where browser support allows this) </ul>
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * The AutoChild label used to display the {@link com.smartgwt.client.widgets.layout.NavigationBar#getTitle title} in this
     * NavigationBar.
     * <p>
     * This component is an AutoChild named "titleLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current titleLabel value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getTitleLabel() throws IllegalStateException {
        errorIfNotCreated("titleLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("titleLabel"));
    }
    

    // ********************* Methods ***********************
    /**
     * Add a downClick handler.
     * <p>
     * Notification method fired when the down button on the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl miniNavControl} is clicked.
     *
     * @param handler the downClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDownClickHandler(com.smartgwt.client.widgets.layout.events.DownClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) setupDownClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.DownClickEvent.getType());
    }

    private native void setupDownClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var downClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.DownClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.NavigationBar::handleTearDownDownClickEvent()();
            if (hasDefaultHandler) this.Super("downClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("downClick"));
            obj.addProperties({downClick:  downClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("downClick"));
            obj.downClick =  downClick             ;
        }
    }-*/;

    private void handleTearDownDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) tearDownDownClickEvent();
    }

    private native void tearDownDownClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("downClick")) delete obj.downClick;
    }-*/;

    /**
     * Add a navigationClick handler.
     * <p>
     * Notification method fired when the user clicks the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton
     * NavigationBar.leftButton} or {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton
     * NavigationBar.rightButton}
     *
     * @param handler the navigationClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNavigationClickHandler(com.smartgwt.client.widgets.layout.events.NavigationClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType()) == 0) setupNavigationClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType());
    }

    private native void setupNavigationClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var navigationClick = $entry(function(){
            var param = {"_this": this, "direction" : arguments[0]};
            var event = @com.smartgwt.client.widgets.layout.events.NavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.NavigationBar::handleTearDownNavigationClickEvent()();
            if (hasDefaultHandler) this.Super("navigationClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("navigationClick"));
            obj.addProperties({navigationClick:  navigationClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("navigationClick"));
            obj.navigationClick =  navigationClick             ;
        }
    }-*/;

    private void handleTearDownNavigationClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType()) == 0) tearDownNavigationClickEvent();
    }

    private native void tearDownNavigationClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("navigationClick")) delete obj.navigationClick;
    }-*/;

	/**
     * Sets multiple state attributes of this <code>NavigationBar</code> at once. If this <code>NavigationBar</code> was
     * created with {@link com.smartgwt.client.widgets.layout.NavigationBar#getAnimateStateChanges animateStateChanges} set to
     * <code>true</code>, then the change-over to the new state attributes will be animated if the direction is either  {@link
     * com.smartgwt.client.types.NavigationDirection#FORWARD} or  {@link com.smartgwt.client.types.NavigationDirection#BACK}.
     * @param viewState the new view state.
     */
    public native void setViewState(NavigationBarViewState viewState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setViewState", "NavigationBarViewState");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setViewState(viewState.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Sets multiple state attributes of this <code>NavigationBar</code> at once. If this <code>NavigationBar</code> was
     * created with {@link com.smartgwt.client.widgets.layout.NavigationBar#getAnimateStateChanges animateStateChanges} set to
     * <code>true</code>, then the change-over to the new state attributes will be animated if the direction is either  {@link
     * com.smartgwt.client.types.NavigationDirection#FORWARD} or  {@link com.smartgwt.client.types.NavigationDirection#BACK}.
     * @param viewState the new view state.
     * @param direction an optional direction for animation. If not specified or set to  {@link
     * com.smartgwt.client.types.NavigationDirection#NONE} then the state change will not be animated. The direction should be 
     * <code>NavigationDirection.FORWARD</code> for operations that reveal new content and  NavigationDirection.BACK for
     * operations that reveal previously-displayed content.
     */
    public native void setViewState(NavigationBarViewState viewState, NavigationDirection direction) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setViewState", "NavigationBarViewState,NavigationDirection");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setViewState(viewState.@com.smartgwt.client.core.DataClass::getJsObj()(), direction == null ? null : direction.@com.smartgwt.client.types.NavigationDirection::getValue()());
    }-*/;
	
    /**
     * Add a upClick handler.
     * <p>
     * Notification method fired when the up button on the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getMiniNavControl miniNavControl} is clicked.
     *
     * @param handler the upClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addUpClickHandler(com.smartgwt.client.widgets.layout.events.UpClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) setupUpClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.UpClickEvent.getType());
    }

    private native void setupUpClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var upClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.UpClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.NavigationBar::handleTearDownUpClickEvent()();
            if (hasDefaultHandler) this.Super("upClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("upClick"));
            obj.addProperties({upClick:  upClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("upClick"));
            obj.upClick =  upClick             ;
        }
    }-*/;

    private void handleTearDownUpClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) tearDownUpClickEvent();
    }

    private native void tearDownUpClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("upClick")) delete obj.upClick;
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
     * @param navigationBarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(NavigationBar navigationBarProperties) /*-{
        if (navigationBarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(NavigationBar.@java.lang.Object::getClass()(), "setDefaultProperties", navigationBarProperties.@java.lang.Object::getClass()());
        }
        navigationBarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = navigationBarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.NavigationBar.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(NavigationBarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alwaysShowLeftButtonTitle = getAttributeAsString("alwaysShowLeftButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.alwaysShowLeftButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.animateStateChanges = getAttributeAsString("animateStateChanges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.animateStateChanges:" + t.getMessage() + "\n";
        }
        try {
            s.customNavControl = getCustomNavControl();
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.customNavControl:" + t.getMessage() + "\n";
        }
        try {
            s.leftButtonIcon = getAttributeAsString("leftButtonIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.leftButtonIcon:" + t.getMessage() + "\n";
        }
        try {
            s.leftButtonTitle = getAttributeAsString("leftButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.leftButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.maxCenterOffset = getAttributeAsString("maxCenterOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.maxCenterOffset:" + t.getMessage() + "\n";
        }
        try {
            s.miniNavAlign = getAttributeAsString("miniNavAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.miniNavAlign:" + t.getMessage() + "\n";
        }
        try {
            s.rightButtonIcon = getAttributeAsString("rightButtonIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.rightButtonIcon:" + t.getMessage() + "\n";
        }
        try {
            s.rightButtonTitle = getAttributeAsString("rightButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.rightButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.shortLeftButtonTitle = getAttributeAsString("shortLeftButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.shortLeftButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showLeftButton = getAttributeAsString("showLeftButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.showLeftButton:" + t.getMessage() + "\n";
        }
        try {
            s.showMiniNavControl = getAttributeAsString("showMiniNavControl");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.showMiniNavControl:" + t.getMessage() + "\n";
        }
        try {
            s.showRightButton = getAttributeAsString("showRightButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.showRightButton:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavigationBar.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        NavigationBarLogicalStructure s = new NavigationBarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
