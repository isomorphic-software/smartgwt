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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Shows a set of Tabs.  TabBars are automatically created by TabSets and shouldn't be used directly.  The TabBar is
 * documented for skinning purposes.
 */
public class TabBar extends Toolbar {

    public native static TabBar getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("TabBar",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.tab.TabBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public TabBar(){
        scClassName = "TabBar";
    }

    public TabBar(JavaScriptObject jsObj){
        scClassName = "TabBar";
        setJavaScriptObject(jsObj);
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
     * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize} for the {@link com.smartgwt.client.docs.BaseLine}
     * stretchImg.
     *
     * @param baseLineCapSize baseLineCapSize Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public void setBaseLineCapSize(int baseLineCapSize)  throws IllegalStateException {
        setAttribute("baseLineCapSize", baseLineCapSize, false);
    }

    /**
     * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize capSize} for the {@link com.smartgwt.client.docs.BaseLine}
     * stretchImg.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public int getBaseLineCapSize()  {
        return getAttributeAsInt("baseLineCapSize");
    }

    /**
     * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for the {@link com.smartgwt.client.docs.BaseLine}
     * StretchImg.
     *
     * @param baseLineSrc . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]baseline.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public void setBaseLineSrc(String baseLineSrc)  throws IllegalStateException {
        setAttribute("baseLineSrc", baseLineSrc, false);
    }

    /**
     * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for the {@link com.smartgwt.client.docs.BaseLine}
     * StretchImg.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public String getBaseLineSrc()  {
        return getAttributeAsString("baseLineSrc");
    }

    /**
     * Thickness of the baseLine, in pixels.  This should be set to match the media specified by {@link
     * com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of
     * overlap with the TabSet's paneContainer when using decorative edges - see {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneContainer paneContainer} for details.
     *
     * @param baseLineThickness baseLineThickness Default value is 1
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public void setBaseLineThickness(int baseLineThickness)  throws IllegalStateException {
        setAttribute("baseLineThickness", baseLineThickness, false);
    }

    /**
     * Thickness of the baseLine, in pixels.  This should be set to match the media specified by {@link
     * com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of
     * overlap with the TabSet's paneContainer when using decorative edges - see {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneContainer paneContainer} for details.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public int getBaseLineThickness()  {
        return getAttributeAsInt("baseLineThickness");
    }

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
     */
    public int getBreadth()  {
        return getAttributeAsInt("breadth");
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
     */
    public int getDefaultTabSize()  {
        return getAttributeAsInt("defaultTabSize");
    }

    /**
     * Tab to show as the "more" tab when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab showMoreTab} is enabled
     * and the number of tabs to show exceeds {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount}.
     *
     * @param moreTab moreTab Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMoreTab(Tab moreTab)  throws IllegalStateException {
        setAttribute("moreTab", moreTab.getJsObj(), false);
    }

    /**
     * Tab to show as the "more" tab when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab showMoreTab} is enabled
     * and the number of tabs to show exceeds {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount}.
     *
     *
     * @return Tab
     */
    public Tab getMoreTab()  {
        return Tab.getOrCreateRef(getAttributeAsJavaScriptObject("moreTab"));
    }

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab
     * showMoreTab} is enabled.
     *
     * @param moreTabCount moreTabCount Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMoreTabCount(int moreTabCount)  throws IllegalStateException {
        setAttribute("moreTabCount", moreTabCount, false);
    }

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab
     * showMoreTab} is enabled.
     *
     *
     * @return int
     */
    public int getMoreTabCount()  {
        return getAttributeAsInt("moreTabCount");
    }

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     * @param showMoreTab showMoreTab Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowMoreTab(Boolean showMoreTab)  throws IllegalStateException {
        setAttribute("showMoreTab", showMoreTab, false);
    }

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     *
     * @return Boolean
     */
    public Boolean getShowMoreTab()  {
        return getAttributeAsBoolean("showMoreTab");
    }

    // ********************* Methods ***********************

    /**
     * Select a tab
     * @param tabNum index of tab to select
     */
    public native void selectTab(int tabNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabNum);
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
     * @param tabBarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TabBar tabBarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},tabBarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.TabBar.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

    public LogicalStructureObject setLogicalStructure(TabBarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseLineCapSize = getAttributeAsString("baseLineCapSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineCapSize:" + t.getMessage() + "\n";
        }
        try {
            s.baseLineSrc = getAttributeAsString("baseLineSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineSrc:" + t.getMessage() + "\n";
        }
        try {
            s.baseLineThickness = getAttributeAsString("baseLineThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineThickness:" + t.getMessage() + "\n";
        }
        try {
            s.breadth = getAttributeAsString("breadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.breadth:" + t.getMessage() + "\n";
        }
        try {
            s.defaultTabSize = getAttributeAsString("defaultTabSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.defaultTabSize:" + t.getMessage() + "\n";
        }
        try {
            s.moreTab = getMoreTab();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.moreTab:" + t.getMessage() + "\n";
        }
        try {
            s.moreTabCount = getAttributeAsString("moreTabCount");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.moreTabCount:" + t.getMessage() + "\n";
        }
        try {
            s.showMoreTab = getAttributeAsString("showMoreTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.showMoreTab:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        TabBarLogicalStructure s = new TabBarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

