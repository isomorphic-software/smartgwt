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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * An interface that provides the ability to create components from a {@link com.smartgwt.client.tools.PaletteNode}.
 */
@BeanFactory.FrameworkClass
public interface Palette {


    // ********************* Properties / Attributes ***********************

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.Palette Palette} instance, for chaining setter calls
     */
    public Palette setDefaultEditContext(EditContext defaultEditContext) ;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditContext getDefaultEditContext()  ;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.Palette Palette} instance, for chaining setter calls
     */
    public Palette setDefaultEditContext(EditTree defaultEditContext) ;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditTree getDefaultEditContextAsEditTree()  ;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @param defaultEditContext the default EditContext used by this Palette. Default value is null
     * @return {@link com.smartgwt.client.tools.Palette Palette} instance, for chaining setter calls
     */
    public Palette setDefaultEditContext(EditPane defaultEditContext) ;

    /**
     * Default EditContext that this palette should use.  Palettes generally create components via drag and drop, but may also
     * support creation via double-click or other UI idioms when a defaultEditContext is set.
     *
     * @return Current defaultEditContext value. Default value is null
     */
    public EditPane getDefaultEditContextAsEditPane()  ;
    

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @param generateNames New generateNames value. Default value is true
     * @return {@link com.smartgwt.client.tools.Palette Palette} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public Palette setGenerateNames(boolean generateNames)  throws IllegalStateException ;

    /**
     * Whether created components should have their "ID" or "name" property automatically set to a unique value based on the
     * component's type, eg, "ListGrid0".
     *
     * @return Current generateNames value. Default value is true
     * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
     */
    public boolean getGenerateNames()  ;
    

    // ********************* Methods ***********************
	/**
     * Given a {@link com.smartgwt.client.tools.PaletteNode}, make an {@link com.smartgwt.client.tools.EditNode} from it by
     * creating a  {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject} from the {@link
     * com.smartgwt.client.tools.PaletteNode#getDefaults PaletteNode.defaults} and copying presentation properties (eg {@link
     * com.smartgwt.client.tools.PaletteNode#getTitle title} to the editNode. <P> If <code>editNodeProperties</code> is
     * specified as an object on on the paletteNode, each property in this object will also be copied across to the editNode.
     * @param paletteNode paletteNode to create from
     *
     * @return created EditNode
     */
    public EditNode makeEditNode(PaletteNode paletteNode);


}
