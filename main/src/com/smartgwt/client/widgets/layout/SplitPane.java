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
 * extends VLayout A device- and orientation-sensitive layout that implements the common pattern of rendering  two panes
 * side-by-side on desktop devices and tablets (eg iPad) in landscape orientation,  while switching to showing a single
 * pane for handset-sized devices or tablets in portrait orientation. <P> The SplitPane's main components are the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}. Both components will be displayed side by side
 * as columns when viewed on a desktop device or a tablet in landscape mode.<br> Only one pane will be shown at a time when
 * viewed on a handset sized device (such as iPhone), or a tablet in portrait orientation. By default the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is  shown, and the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getShowNavigationPane showNavigationPane} / {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getShowDetailPane showDetailPane} methods may be called to switch between
 * views. <P>
 */
public class SplitPane extends VLayout {

    public static SplitPane getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (SplitPane) obj;
        } else {
            return new SplitPane(jsObj);
        }
    }

    public SplitPane(){
        scClassName = "SplitPane";
    }

    public SplitPane(JavaScriptObject jsObj){
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
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet).
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or portrait mode on tablet).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailNavigationControl detailNavigationControl Default value is null
     */
    public void setDetailNavigationControl(Canvas detailNavigationControl) {
        setAttribute("detailNavigationControl", detailNavigationControl == null ? null : detailNavigationControl.getOrCreateJsObj(), true);
    }

    /**
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet).
     *
     *
     * @return Canvas
     */
    public Canvas getDetailNavigationControl()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("detailNavigationControl"));
    }

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     * Set a new detailPane at runtime
     *
     * @param detailPane new detail pane for this widget. Default value is null
     */
    public void setDetailPane(Canvas detailPane) {
        setAttribute("detailPane", detailPane == null ? null : detailPane.getOrCreateJsObj(), true);
    }

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     *
     *
     * @return Canvas
     */
    public Canvas getDetailPane()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("detailPane"));
    }

    /**
     * Tool buttons to display in the detail {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip
     * detailToolStrip}.
     * Update the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} at runtime
     *
     * @param detailToolButtons new controls for the toolstrip. Default value is null
     */
    public void setDetailToolButtons(Canvas... detailToolButtons) {
        setAttribute("detailToolButtons", detailToolButtons, true);
    }

    /**
     * Tool buttons to display in the detail {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip
     * detailToolStrip}.
     *
     *
     * @return Canvas
     */
    public Canvas[] getDetailToolButtons()  {
        return Canvas.convertToCanvasArray(getAttributeAsJavaScriptObject("detailToolButtons"));
    }

    /**
     * An optional list pane displayed in the left-hand of the panes or in a popup according to the pane layout.
     * Set a new listPane at runtime
     *
     * @param listPane new list pane for this widget. Default value is null
     */
    public void setListPane(Canvas listPane) {
        setAttribute("listPane", listPane == null ? null : listPane.getOrCreateJsObj(), true);
    }

    /**
     * An optional list pane displayed in the left-hand of the panes or in a popup according to the pane layout.
     *
     *
     * @return Canvas
     */
    public Canvas getListPane()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("listPane"));
    }

    /**
     * The AutoChild {@link com.smartgwt.client.widgets.layout.NavigationBar navigationBar} managed by this widget.
     *
     * @param navigationBar navigationBar Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNavigationBar(NavigationBar navigationBar)  throws IllegalStateException {
        setAttribute("navigationBar", navigationBar == null ? null : navigationBar.getOrCreateJsObj(), false);
    }

    /**
     * The AutoChild {@link com.smartgwt.client.widgets.layout.NavigationBar navigationBar} managed by this widget.
     *
     *
     * @return NavigationBar
     */
    public NavigationBar getNavigationBar()  {
        return NavigationBar.getOrCreateRef(getAttributeAsJavaScriptObject("navigationBar"));
    }

    /**
     * The left-hand of the two panes managed by this widget, used for navigation.
     * Update the navigation pane at runtime
     *
     * @param navigationPane new navigation pane. Default value is null
     */
    public void setNavigationPane(Canvas navigationPane) {
        setAttribute("navigationPane", navigationPane == null ? null : navigationPane.getOrCreateJsObj(), true);
    }

    /**
     * The left-hand of the two panes managed by this widget, used for navigation.
     *
     *
     * @return Canvas
     */
    public Canvas getNavigationPane()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("navigationPane"));
    }

    // ********************* Methods ***********************
            
    /**
     * Sets the title for the Detail Pane.
     * @param title new title for the detail pane
     */
    public native void setDetailTitle(String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDetailTitle(title);
    }-*/;
            
    /**
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonIcon LeftButtonIcon}.
     * @param newIcon new icon for Left button
     */
    public native void setLeftButtonIcon(String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setLeftButtonIcon(newIcon);
    }-*/;
            
    /**
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle}.  Note that this
     * is normally automatically set to the navigationPaneTitle or listPaneTitle as appropriate.
     * @param newTitle new title for left button
     */
    public native void setLeftButtonTitle(String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setLeftButtonTitle(newTitle);
    }-*/;
            
    /**
     * Sets the title for the List Pane.
     * @param title new title for the list pane
     */
    public native void setListTitle(String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setListTitle(title);
    }-*/;
            
    /**
     * Sets the title for the Navigation Pane.
     * @param title new title for the navigation pane
     */
    public native void setNavigationTitle(String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setNavigationTitle(title);
    }-*/;
            
    /**
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonIcon rightButtonIcon}.
     * @param newIcon new icon for right button
     */
    public native void setRightButtonIcon(String newIcon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRightButtonIcon(newIcon);
    }-*/;
            
    /**
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle}
     * @param newTitle new title for right button
     */
    public native void setRightButtonTitle(String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRightButtonTitle(newTitle);
    }-*/;
            
    /**
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}.  Note that the
     * default behavior is to automatically create and show a "back button" as the left button that allows transitioning back
     * to the navigationPane (tablet and handset mode) or the listPane (handset mode).
     * @param visible if true, the button will be shown, otherwise hidden.
     */
    public native void setShowLeftButton(boolean visible) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowLeftButton(visible);
    }-*/;
            
    /**
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}.
     * @param visible if true, the button will be shown, otherwise hidden.
     */
    public native void setShowRightButton(boolean visible) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowRightButton(visible);
    }-*/;
            
    /**
     * Causes a transition to the Detail Pane
     */
    public native void showDetailPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showDetailPane();
    }-*/;
            
    /**
     * Causes a transition to the List Pane
     */
    public native void showListPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showListPane();
    }-*/;
            
    /**
     * Causes a transition to the Navigation Pane
     */
    public native void showNavigationPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNavigationPane();
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
     * @param splitPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SplitPane splitPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},splitPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.SplitPane.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


	
	/**
	 * Handler to fire when the user navigates by clicking the back or forward (left / right) buttons.
	 * @param handler
	 */
	public native void setNavigationClickHandler(NavigationClickHandler handler) /*-{
		var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.navigationClick = $debox($entry(function(direction) {
        	
        	var eventJ = @com.smartgwt.client.widgets.layout.events.NavigationClickEvent::new(Ljava/lang/String;)(direction);
	        handler.@com.smartgwt.client.widgets.layout.events.NavigationClickHandler::onNavigationClick(Lcom/smartgwt/client/widgets/layout/events/NavigationClickEvent;)(eventJ);
        }));
        
	}-*/;


}



