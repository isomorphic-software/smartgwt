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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * extends HLayout Navigation control implemented as a horizontal layout showing back and forward controls  and a title.
 */
public class NavigationBar extends HLayout {

    public static NavigationBar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (NavigationBar) obj;
        } else {
            return new NavigationBar(jsObj);
        }
    }

    public NavigationBar(){
        scClassName = "NavigationBar";
    }

    public NavigationBar(JavaScriptObject jsObj){
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
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonIcon leftButtonIcon}
     *
     * @param leftButtonIcon new icon for left button. Default value is null
     */
    public void setLeftButtonIcon(String leftButtonIcon) {
        setAttribute("leftButtonIcon", leftButtonIcon, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     *
     *
     * @return String
     */
    public String getLeftButtonIcon()  {
        return getAttributeAsString("leftButtonIcon");
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle}
     *
     * @param leftButtonTitle new title for left button. Default value is "&nbsp;"
     */
    public void setLeftButtonTitle(String leftButtonTitle) {
        setAttribute("leftButtonTitle", leftButtonTitle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     *
     *
     * @return String
     */
    public String getLeftButtonTitle()  {
        return getAttributeAsString("leftButtonTitle");
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonIcon rightButtonIcon}
     *
     * @param rightButtonIcon new icon for right button. Default value is null
     */
    public void setRightButtonIcon(String rightButtonIcon) {
        setAttribute("rightButtonIcon", rightButtonIcon, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}
     *
     *
     * @return String
     */
    public String getRightButtonIcon()  {
        return getAttributeAsString("rightButtonIcon");
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle}
     *
     * @param rightButtonTitle new title for right button. Default value is "&nbsp;"
     */
    public void setRightButtonTitle(String rightButtonTitle) {
        setAttribute("rightButtonTitle", rightButtonTitle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getTitle Title} for the {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}
     *
     *
     * @return String
     */
    public String getRightButtonTitle()  {
        return getAttributeAsString("rightButtonTitle");
    }

    /**
     * The title to display centered in this NavigationBar
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the title for this navigationBar.
     *
     * @param title New title. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The title to display centered in this NavigationBar
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************
            
    /**
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton}
     * @param visible if true, the button will be shown, otherwise hidden.
     */
    public native void setShowLeftButton(boolean visible) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowLeftButton(visible);
    }-*/;
            
    /**
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton}
     * @param visible if true, the button will be shown, otherwise hidden.
     */
    public native void setShowRightButton(boolean visible) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setShowRightButton(visible);
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
     * @param navigationBarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(NavigationBar navigationBarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},navigationBarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.NavigationBar.addProperties(properties);
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




