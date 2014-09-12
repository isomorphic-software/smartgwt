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
 
package com.smartgwt.client.tools;


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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A Palette with no visible representation that handles programmatic creation of components.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("HiddenPalette")
public class HiddenPalette extends BaseClass implements Palette {

    public static HiddenPalette getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (HiddenPalette) obj;
        } else {
            return new HiddenPalette(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
    }


    public HiddenPalette(){
        scClassName = "HiddenPalette";
    }

    public HiddenPalette(JavaScriptObject jsObj){
        scClassName = "HiddenPalette";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    /**
     * A list of {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} for component creation.
     *
     * @param data  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setData(PaletteNode... data)  throws IllegalStateException {
        setAttribute("data", data, false);
    }

    /**
     * A list of {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} for component creation.
     *
     * @return PaletteNode...
     */
    public PaletteNode[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfPaletteNode(getAttributeAsJavaScriptObject("data"));
    }
    

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     */
    public native void setDefaultEditContext(EditContext defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditContext::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        this.@com.smartgwt.client.core.BaseClass::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return EditContext
     */
    public EditContext getDefaultEditContext()  {
        return EditContext.getOrCreateRef(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     */
    public native void setDefaultEditContext(EditTree defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditTree::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        this.@com.smartgwt.client.core.BaseClass::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return EditTree
     */
    public EditTree getDefaultEditContextAsEditTree()  {
        return (EditTree)EditTree.getByJSObject(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     */
    public native void setDefaultEditContext(EditPane defaultEditContext) /*-{
        var defaultEditContextJS = (
                defaultEditContext == null ?
                null :
                defaultEditContext.@com.smartgwt.client.tools.EditPane::getOrCreateJsObj()());

        // If an EditTree (or similar) component is passed which contains an EditContext
        // rather than being one, grab the actual EditContext.
        if (defaultEditContextJS &&
            !$wnd.isc.isAn.EditContext(defaultEditContextJS) &&
            defaultEditContextJS.getEditContext)
        {
            defaultEditContextJS = defaultEditContextJS.getEditContext();
        }

        this.@com.smartgwt.client.core.BaseClass::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)("defaultEditContext", defaultEditContextJS, true);
    }-*/;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return EditPane
     */
    public EditPane getDefaultEditContextAsEditPane()  {
        return (EditPane)EditPane.getByJSObject(getAttributeAsJavaScriptObject("defaultEditContext"));
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @param generateNames  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public void setGenerateNames(boolean generateNames)  throws IllegalStateException {
        setAttribute("generateNames", generateNames, false);
    }

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @return boolean
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public boolean getGenerateNames()  {
        Boolean result = getAttributeAsBoolean("generateNames");
        return result == null ? true : result;
    }

    // ********************* Methods ***********************


	/**
     * Given a {@link com.smartgwt.client.tools.PaletteNode}, make an {@link com.smartgwt.client.tools.EditNode} from it by
     * creating a  {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject} from the {@link
     * com.smartgwt.client.tools.PaletteNode#getDefaults defaults} and copying presentation properties (eg {@link
     * com.smartgwt.client.tools.PaletteNode#getTitle title} to the editNode. If <code>editNodeProperties</code> is specified
     * as an object on on the paletteNode, each property in this object will also be copied across to the editNode.
     * @param paletteNode paletteNode to create from
     *
     * @return created EditNode
     */
    public native EditNode makeEditNode(PaletteNode paletteNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.makeEditNode(paletteNode.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.tools.EditNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;



    // ********************* Static Methods ***********************

    // ***********************************************************

}


