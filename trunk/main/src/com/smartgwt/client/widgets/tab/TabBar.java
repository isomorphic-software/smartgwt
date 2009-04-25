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
 
package com.smartgwt.client.widgets.tab;



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
    * Shows a set of Tabs.  TabBars are automatically created by TabSets and shouldn't be used&#010 directly.  The TabBar is documented for skinning purposes.

    */
public class TabBar extends Toolbar {

    public static TabBar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TabBar) obj;
        } else {
            return new TabBar(jsObj);
        }
    }


    public TabBar(){
        
    }

    public TabBar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.TabBar.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Breadth of the tabBar (including baseline breadth)
    *
    * @param breadth breadth Default value is 21
    */
    public void setBreadth(int breadth) {
        setAttribute("breadth", breadth, true);
    }
    /**
     * Breadth of the tabBar (including baseline breadth)
     *
     *
     * @return int
     *
     */
    public int getBreadth()  {
        return getAttributeAsInt("breadth");
    }

    /**
    * Thickness of the baseLine, in pixels.  This should be set to match the media specified&#010 by {@link com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of overlap with&#010 the TabSet's paneContainer when using decorative edges - see {@link com.smartgwt.client.widgets.tab.TabSet#getPaneContainer paneContainer}&#010 for details.
    *
    * @param baseLineThickness baseLineThickness Default value is 1
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBaseLineThickness(int baseLineThickness)  throws IllegalStateException {
        setAttribute("baseLineThickness", baseLineThickness, false);
    }
    /**
     * Thickness of the baseLine, in pixels.  This should be set to match the media specified&#010 by {@link com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of overlap with&#010 the TabSet's paneContainer when using decorative edges - see {@link com.smartgwt.client.widgets.tab.TabSet#getPaneContainer paneContainer}&#010 for details.
     *
     *
     * @return int
     *
     */
    public int getBaseLineThickness()  {
        return getAttributeAsInt("baseLineThickness");
    }

    /**
    * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for the {@link com.smartgwt.client.docs.BaseLine} StretchImg.
    *
    * @param baseLineSrc baseLineSrc Default value is "[SKIN]baseline.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBaseLineSrc(String baseLineSrc)  throws IllegalStateException {
        setAttribute("baseLineSrc", baseLineSrc, false);
    }
    /**
     * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for the {@link com.smartgwt.client.docs.BaseLine} StretchImg.
     *
     *
     * @return String
     *
     */
    public String getBaseLineSrc()  {
        return getAttributeAsString("baseLineSrc");
    }

    /**
    * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize} for the {@link com.smartgwt.client.docs.BaseLine} stretchImg.
    *
    * @param baseLineCapSize baseLineCapSize Default value is 2
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBaseLineCapSize(int baseLineCapSize)  throws IllegalStateException {
        setAttribute("baseLineCapSize", baseLineCapSize, false);
    }
    /**
     * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize} for the {@link com.smartgwt.client.docs.BaseLine} stretchImg.
     *
     *
     * @return int
     *
     */
    public int getBaseLineCapSize()  {
        return getAttributeAsInt("baseLineCapSize");
    }

    /**
    * Default size (length) in pixels for tabs within this tabBar
    *
    * @param defaultTabSize defaultTabSize Default value is 80
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDefaultTabSize(int defaultTabSize)  throws IllegalStateException {
        setAttribute("defaultTabSize", defaultTabSize, false);
    }
    /**
     * Default size (length) in pixels for tabs within this tabBar
     *
     *
     * @return int
     *
     */
    public int getDefaultTabSize()  {
        return getAttributeAsInt("defaultTabSize");
    }

    // ********************* Methods ***********************

        /**
         * Select a tab&#010
         * @param tabNum index of tab to select
         */
        public native void selectTab(int tabNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.selectTab(tabNum);
        }-*/;

    // ********************* Static Methods ***********************

}




