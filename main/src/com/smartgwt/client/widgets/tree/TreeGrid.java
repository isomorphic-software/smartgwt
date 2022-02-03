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
 
package com.smartgwt.client.widgets.tree;


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
 * The Smart GWT system supports hierarchical data (also referred to as tree data due to its "branching" organization)
 * with: <ul>   <li> the {@link com.smartgwt.client.widgets.tree.Tree} class, which manipulates hierarchical data sets  
 * <li> the TreeGrid widget class, which extends the ListGrid class to visually        present tree data in an
 * expandable/collapsible format. </ul> For information on DataBinding Trees, see {@link
 * com.smartgwt.client.docs.TreeDataBinding}. <p> A TreeGrid works just like a {@link
 * com.smartgwt.client.widgets.grid.ListGrid}, except one column (specified by {@link
 * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField TreeGridField.treeField}) shows a hierarchical {@link
 * com.smartgwt.client.widgets.tree.Tree}.  A TreeGrid is not limited to displaying just the {@link
 * com.smartgwt.client.widgets.tree.Tree} column - you can define additional columns (via {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}) which will render just like the columns of a {@link
 * com.smartgwt.client.widgets.grid.ListGrid}, and support all of the functionality of ListGrid columns, such as {@link
 * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter formatters}. <p> Except where explicitly overridden,
 * {@link com.smartgwt.client.widgets.grid.ListGrid} methods, callbacks, and properties apply to TreeGrids as well.  The
 * {@link com.smartgwt.client.widgets.grid.ListGrid} defines some methods as taking/returning {@link
 * com.smartgwt.client.widgets.grid.ListGridField} and {@link com.smartgwt.client.widgets.grid.ListGridRecord}.  When using
 * those methods in a TreeGrid, those types will be {@link com.smartgwt.client.widgets.tree.TreeGridField} and {@link
 * com.smartgwt.client.widgets.tree.TreeNode}, respectively.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TreeGrid")
public class TreeGrid extends ListGrid implements com.smartgwt.client.widgets.tree.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.tree.events.HasDataChangedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClickHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClosedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasFolderOpenedHandlers, com.smartgwt.client.widgets.tree.events.HasLeafClickHandlers, com.smartgwt.client.widgets.tree.events.HasLeafContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasFolderDropHandlers {

    public static TreeGrid getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TreeGrid(jsObj);
        } else {
            assert refInstance instanceof TreeGrid;
            return (TreeGrid)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreeGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TreeGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TreeGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TreeGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TreeGrid(){
        setAnimateFolderSpeed(3000);setAlternateRecordStyles(false);
				scClassName = "TreeGrid";
    }

    public TreeGrid(JavaScriptObject jsObj){
        scClassName = "TreeGrid";
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
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener showOpener} is true, should we display the opener icon
     * for folders even if they have no children? <P> Note that for trees which {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand}, we may not know if a folder has any
     * descendants if it has never been opened. As such we will show the opener icon next to the folder. Once the user opens
     * the icon and a fetch occurs, if the folder is empty, and this property is false, the opener icon will be hidden. <P> For
     * more information on load on demand trees, and how we determine whether a node is a a folder or a leaf, please refer to
     * the {@link com.smartgwt.client.docs.TreeDataBinding} documentation.
     *
     * @param alwaysShowOpener New alwaysShowOpener value. Default value is false
     */
    public void setAlwaysShowOpener(Boolean alwaysShowOpener) {
        setAttribute("alwaysShowOpener", alwaysShowOpener, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener showOpener} is true, should we display the opener icon
     * for folders even if they have no children? <P> Note that for trees which {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand}, we may not know if a folder has any
     * descendants if it has never been opened. As such we will show the opener icon next to the folder. Once the user opens
     * the icon and a fetch occurs, if the folder is empty, and this property is false, the opener icon will be hidden. <P> For
     * more information on load on demand trees, and how we determine whether a node is a a folder or a leaf, please refer to
     * the {@link com.smartgwt.client.docs.TreeDataBinding} documentation.
     *
     * @return Current alwaysShowOpener value. Default value is false
     */
    public Boolean getAlwaysShowOpener()  {
        Boolean result = getAttributeAsBoolean("alwaysShowOpener");
        return result == null ? false : result;
    }
    

    /**
     * When animating folder opening / closing, this property can be set to apply an animated acceleration effect. This allows
     * the animation speed to be "weighted", for example expanding or collapsing at a faster rate toward the beginning of the
     * animation than at the end.
     *
     * @param animateFolderEffect New animateFolderEffect value. Default value is null
     */
    public void setAnimateFolderEffect(AnimationAcceleration animateFolderEffect) {
        setAttribute("animateFolderEffect", animateFolderEffect == null ? null : animateFolderEffect.getValue(), true);
    }

    /**
     * When animating folder opening / closing, this property can be set to apply an animated acceleration effect. This allows
     * the animation speed to be "weighted", for example expanding or collapsing at a faster rate toward the beginning of the
     * animation than at the end.
     *
     * @return Current animateFolderEffect value. Default value is null
     */
    public AnimationAcceleration getAnimateFolderEffect()  {
        return EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateFolderEffect"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolders animateFolders} is true for this grid, this number
     * can be set to designate the maximum number of rows to animate at a time when opening / closing a folder.
     *
     * @param animateFolderMaxRows New animateFolderMaxRows value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderMaxRows
     */
    public void setAnimateFolderMaxRows(Integer animateFolderMaxRows) {
        setAttribute("animateFolderMaxRows", animateFolderMaxRows, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolders animateFolders} is true for this grid, this number
     * can be set to designate the maximum number of rows to animate at a time when opening / closing a folder.
     *
     * @return If {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolders animateFolders} is true for this treeGrid, this
     * method returns the  the maximum number of rows to animate at a time when opening / closing a folder. This method will
     * return {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderMaxRows animateFolderMaxRows} if set. Otherwise
     * the value will be calculated as 3x the number of rows required to fill a viewport, capped at a maximum value of 75. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderMaxRows
     */
    public Integer getAnimateFolderMaxRows()  {
        return getAttributeAsInt("animateFolderMaxRows");
    }
    

    /**
     * If true, when folders are opened / closed children will be animated into view. <p>  Folder animations are automatically
     * disabled if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData ListGrid.autoFitData} is set to "vertical"
     * or "both", or   if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents records components} are
     * used.
     *
     * @param animateFolders New animateFolders value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_tree" target="examples">Tree Folders Example</a>
     */
    public void setAnimateFolders(Boolean animateFolders) {
        setAttribute("animateFolders", animateFolders, true);
    }

    /**
     * If true, when folders are opened / closed children will be animated into view. <p>  Folder animations are automatically
     * disabled if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData ListGrid.autoFitData} is set to "vertical"
     * or "both", or   if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents records components} are
     * used.
     *
     * @return Current animateFolders value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_tree" target="examples">Tree Folders Example</a>
     */
    public Boolean getAnimateFolders()  {
        Boolean result = getAttributeAsBoolean("animateFolders");
        return result == null ? true : result;
    }
    

    /**
     * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden)
     * per second. Takes precedence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime
     * animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed.
     *
     * @param animateFolderSpeed New animateFolderSpeed value. Default value is 3000
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setAnimateFolderTime
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_tree" target="examples">Tree Folders Example</a>
     */
    public void setAnimateFolderSpeed(int animateFolderSpeed) {
        setAttribute("animateFolderSpeed", animateFolderSpeed, true);
    }

    /**
     * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden)
     * per second. Takes precedence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime
     * animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed.
     *
     * @return Current animateFolderSpeed value. Default value is 3000
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_tree" target="examples">Tree Folders Example</a>
     */
    public int getAnimateFolderSpeed()  {
        return getAttributeAsInt("animateFolderSpeed");
    }
    

    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed
     * animateFolderSpeed} is not set, this property designates the duration of the animation in ms.
     *
     * @param animateFolderTime New animateFolderTime value. Default value is 100
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setAnimateFolderSpeed
     */
    public void setAnimateFolderTime(int animateFolderTime) {
        setAttribute("animateFolderTime", animateFolderTime, true);
    }

    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed
     * animateFolderSpeed} is not set, this property designates the duration of the animation in ms.
     *
     * @return Current animateFolderTime value. Default value is 100
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed
     */
    public int getAnimateFolderTime()  {
        return getAttributeAsInt("animateFolderTime");
    }
    

    /**
     * With {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, TreeGrids fetch data
     * by selecting the child nodes of each parent, which should be exact match, so we default to
     * <code>autoFetchTextMatchStyle:"exact"</code> when autoFetchData is true. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle ListGrid.autoFetchTextMatchStyle} for details.
     *
     * @param autoFetchTextMatchStyle New autoFetchTextMatchStyle value. Default value is "exact"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.ResultTree#setUseSimpleCriteriaLOD
     */
    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle == null ? null : autoFetchTextMatchStyle.getValue(), false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, TreeGrids fetch data
     * by selecting the child nodes of each parent, which should be exact match, so we default to
     * <code>autoFetchTextMatchStyle:"exact"</code> when autoFetchData is true. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle ListGrid.autoFetchTextMatchStyle} for details.
     *
     * @return Current autoFetchTextMatchStyle value. Default value is "exact"
     * @see com.smartgwt.client.widgets.tree.ResultTree#getUseSimpleCriteriaLOD
     */
    public TextMatchStyle getAutoFetchTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("autoFetchTextMatchStyle"));
    }
    

    /**
     * For dataBound treeGrids this specifies the {@link com.smartgwt.client.widgets.tree.ResultTree#getAutoPreserveOpenState
     * ResultTree.autoPreserveOpenState}, governing whether the open state of the tree should be preserved when new data
     * arrives due to cache invalidation.
     *
     * @param autoPreserveOpenState New autoPreserveOpenState value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoPreserveOpenState(PreserveOpenState autoPreserveOpenState)  throws IllegalStateException {
        setAttribute("autoPreserveOpenState", autoPreserveOpenState == null ? null : autoPreserveOpenState.getValue(), false);
    }

    /**
     * For dataBound treeGrids this specifies the {@link com.smartgwt.client.widgets.tree.ResultTree#getAutoPreserveOpenState
     * ResultTree.autoPreserveOpenState}, governing whether the open state of the tree should be preserved when new data
     * arrives due to cache invalidation.
     *
     * @return Current autoPreserveOpenState value. Default value is null
     */
    public PreserveOpenState getAutoPreserveOpenState()  {
        return EnumUtil.getEnum(PreserveOpenState.values(), getAttribute("autoPreserveOpenState"));
    }
    

    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     * @param canAcceptDroppedRecords New canAcceptDroppedRecords value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drag_reparent" target="examples">Drag reparent Example</a>
     */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }

    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     * @return Current canAcceptDroppedRecords value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drag_reparent" target="examples">Drag reparent Example</a>
     */
    public Boolean getCanAcceptDroppedRecords()  {
        Boolean result = getAttributeAsBoolean("canAcceptDroppedRecords");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere. <p> <strong>NOTE:</strong> If
     * <code>canDragRecordsOut</code> is initially enabled or might be dynamically enabled after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a drag operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of records out of the grid.
     *
     * @param canDragRecordsOut New canDragRecordsOut value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public void setCanDragRecordsOut(Boolean canDragRecordsOut) {
        setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere. <p> <strong>NOTE:</strong> If
     * <code>canDragRecordsOut</code> is initially enabled or might be dynamically enabled after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a drag operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of records out of the grid.
     *
     * @return Current canDragRecordsOut value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public Boolean getCanDragRecordsOut()  {
        Boolean result = getAttributeAsBoolean("canDragRecordsOut");
        return result == null ? false : result;
    }
    

    /**
     * Whether drops are allowed on leaf nodes. <P> Dropping is ordinarily not allowed on leaf nodes unless {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is set.   <P> The default action for a
     * drop on a leaf node is to place the node in that leaf's parent folder.  This can be customized by overriding {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#folderDrop folderDrop()}. <P> Note that enabling <code>canDropOnLeaves</code>
     * is usually only appropriate where you intend to add a custom {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop
     * folderDrop()} implementation that <b>does not</b> add a child node under the leaf.  If you want to add a child nodes to
     * a leaf, instead of enabling canDropOnLeaves, use empty folders instead - see {@link
     * com.smartgwt.client.widgets.tree.Tree#isFolder Tree.isFolder()} for how to control whether a node is considered a
     * folder.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDropOnLeaves New canDropOnLeaves value. Default value is false
     */
    public void setCanDropOnLeaves(Boolean canDropOnLeaves) {
        setAttribute("canDropOnLeaves", canDropOnLeaves, true);
    }

    /**
     * Whether drops are allowed on leaf nodes. <P> Dropping is ordinarily not allowed on leaf nodes unless {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is set.   <P> The default action for a
     * drop on a leaf node is to place the node in that leaf's parent folder.  This can be customized by overriding {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#folderDrop folderDrop()}. <P> Note that enabling <code>canDropOnLeaves</code>
     * is usually only appropriate where you intend to add a custom {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop
     * folderDrop()} implementation that <b>does not</b> add a child node under the leaf.  If you want to add a child nodes to
     * a leaf, instead of enabling canDropOnLeaves, use empty folders instead - see {@link
     * com.smartgwt.client.widgets.tree.Tree#isFolder Tree.isFolder()} for how to control whether a node is considered a
     * folder.
     *
     * @return Current canDropOnLeaves value. Default value is false
     */
    public Boolean getCanDropOnLeaves()  {
        Boolean result = getAttributeAsBoolean("canDropOnLeaves");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether records can be reordered by dragging within this <code>ListGrid</code>. <p> <strong>NOTE:</strong> If
     * <code>canReorderRecords</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCanReorderRecords dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a reorder operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag-reordering of records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canReorderRecords New canReorderRecords value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drag_reparent" target="examples">Drag reparent Example</a>
     */
    public void setCanReorderRecords(Boolean canReorderRecords) {
        setAttribute("canReorderRecords", canReorderRecords, true);
    }

    /**
     * Indicates whether records can be reordered by dragging within this <code>ListGrid</code>. <p> <strong>NOTE:</strong> If
     * <code>canReorderRecords</code> is initially enabled or might be {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCanReorderRecords dynamically enabled} after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a reorder operation rather than a scroll. If {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag-reordering of records.
     *
     * @return Current canReorderRecords value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drag_reparent" target="examples">Drag reparent Example</a>
     */
    public Boolean getCanReorderRecords()  {
        Boolean result = getAttributeAsBoolean("canReorderRecords");
        return result == null ? false : result;
    }
    

    /**
     * If set this property allows the user to reparent nodes by dragging them from their current folder to a new folder.<br>
     * <b>Backcompat:</b> For backwards compatibility with versions prior to Smart GWT 1.5, if this property is unset, but
     * <code>this.canAcceptDroppedRecords</code> is true, we allow nodes to be dragged to different folders.
     *
     * @param canReparentNodes New canReparentNodes value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setCanReparentNodes(Boolean canReparentNodes) {
        setAttribute("canReparentNodes", canReparentNodes, true);
    }

    /**
     * If set this property allows the user to reparent nodes by dragging them from their current folder to a new folder.<br>
     * <b>Backcompat:</b> For backwards compatibility with versions prior to Smart GWT 1.5, if this property is unset, but
     * <code>this.canAcceptDroppedRecords</code> is true, we allow nodes to be dragged to different folders.
     *
     * @return Current canReparentNodes value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanAcceptDrop
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanReparentNodes()  {
        return getAttributeAsBoolean("canReparentNodes");
    }
    

    /**
     * This property is not supported on TreeGrid, and only applies to the {@link com.smartgwt.client.widgets.grid.ListGrid}
     * superclass.
     *
     * @param canSelectAll New canSelectAll value. Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public void setCanSelectAll(Boolean canSelectAll) {
        setAttribute("canSelectAll", canSelectAll, true);
    }

    /**
     * This property is not supported on TreeGrid, and only applies to the {@link com.smartgwt.client.widgets.grid.ListGrid}
     * superclass.
     *
     * @return Current canSelectAll value. Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public Boolean getCanSelectAll()  {
        return getAttributeAsBoolean("canSelectAll");
    }
    

    /**
     * Message displayed when user attempts to drop a node into a child of itself.
     *
     * @param cantDragIntoChildMessage New cantDragIntoChildMessage value. Default value is "You can't drag an item into one of it's children."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanReorderRecords
     */
    public void setCantDragIntoChildMessage(String cantDragIntoChildMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoChildMessage", cantDragIntoChildMessage, false);
    }

    /**
     * Message displayed when user attempts to drop a node into a child of itself.
     *
     * @return Current cantDragIntoChildMessage value. Default value is "You can't drag an item into one of it's children."
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
     */
    public String getCantDragIntoChildMessage()  {
        return getAttributeAsString("cantDragIntoChildMessage");
    }
    

    /**
     * Message displayed when user attempts to drop a dragged node onto itself.
     *
     * @param cantDragIntoSelfMessage New cantDragIntoSelfMessage value. Default value is "You can't drag an item into itself."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanReorderRecords
     */
    public void setCantDragIntoSelfMessage(String cantDragIntoSelfMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoSelfMessage", cantDragIntoSelfMessage, false);
    }

    /**
     * Message displayed when user attempts to drop a dragged node onto itself.
     *
     * @return Current cantDragIntoSelfMessage value. Default value is "You can't drag an item into itself."
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
     */
    public String getCantDragIntoSelfMessage()  {
        return getAttributeAsString("cantDragIntoSelfMessage");
    }
    

    /**
     * Should children be selected when parent is selected? And should parent be selected when any child is selected?
     *
     * @param cascadeSelection New cascadeSelection value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCascadeSelection(Boolean cascadeSelection)  throws IllegalStateException {
        setAttribute("cascadeSelection", cascadeSelection, false);
    }

    /**
     * Should children be selected when parent is selected? And should parent be selected when any child is selected?
     *
     * @return Current cascadeSelection value. Default value is false
     */
    public Boolean getCascadeSelection()  {
        Boolean result = getAttributeAsBoolean("cascadeSelection");
        return result == null ? false : result;
    }
    

    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @param closedIconSuffix New closedIconSuffix value. Default value is "closed"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClosedIconSuffix(String closedIconSuffix)  throws IllegalStateException {
        setAttribute("closedIconSuffix", closedIconSuffix, false);
    }

    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @return Current closedIconSuffix value. Default value is "closed"
     */
    public String getClosedIconSuffix()  {
        return getAttributeAsString("closedIconSuffix");
    }
    

    /**
     * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors
     * showConnectors} is true. Connector icons are rendered into the title field of each row and show the dotted hierarchy
     * lines between siblings of the same parent node. For each node, a connector icon may be shown:<ul> <li>As an opener icon
     * for folder nodes, next to the folder icon</li> <li>In place of an opener icon for leaf nodes, next to the leaf icon</li>
     * <li>As a standalone vertical continuation line in the indent to the left of the node, to show     a connection between
     * some ancestor node's siblings (only relevant if     {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li> </ul> Note that
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector
     * lines will be displayed for all indent levels, or just for the innermost level of the tree. <P> The filenames for these
     * icons are assembled from this base filename and the state of the node.  Assuming the connectorImage is set to
     * <code>{baseName}.{extension}</code>, the full set of images to be displayed will be: <P>
     * <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}  is true, this is the URL for the
     * vertical continuation image to be displayed at the  appropriate indent levels for ancestor nodes with subsequent
     * children. <P> For nodes with no children: <ul> <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is
     * no connector line  attached to the parent or previous sibling, and no connector line to the next sibling. For  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors:true} trees, there will always be a 
     * connector leading to the parent or previous sibling if its present in the tree so this  icon can only be displayed for
     * the first row.</li> <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector  line
     * attached to the parent or previous sibling, but there is a connector to the next  sibling. As with <code>_single</code>
     * this will only ever be used for the first row if  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors
     * showFullConnectors} is true</li> <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a
     * connector   line attached to the next sibling of this node (but are showing a connection to the previous  sibling or
     * parent).</li> <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector  line leading
     * to both the previous sibling (or parent) and the next sibling. </ul> For folders with children. Note that if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open folders will never
     * show a connector to subsequent siblings: <ul> <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder
     * node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to
     * any subsequent siblings.</li> <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children 
     * when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next
     * sibling.</li> <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children   if we are not
     * showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous
     * sibling or parent).</li> <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children  
     * where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> <ul>
     * <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with   children when no connector line is
     * shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li>
     * <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children  when the there is no connector
     * line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li>
     * <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children   if we are not showing a
     * connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or
     * parent).</li> <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children   where the we
     * have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> (Note '[_rtl]' means
     * that "_rtl" will be attached if isRTL() is true for this widget). <P> If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is true the URL for selected nodes
     * will append the string <code>"_selected"</code> to the image URLs described above. So for a connectorImage set to
     * <code>{baseName}.{extension}</code>, the URLs for selected records would be
     * <code>{baseName}_ancestor[_rtl]_selected.{extension}</code>,  <code>{baseName}_single[_rtl]_selected.{extension}</code>,
     * etc.
     *
     * @param connectorImage New connectorImage value. Default value is "[SKIN]connector.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setConnectorImage(String connectorImage)  throws IllegalStateException {
        setAttribute("connectorImage", connectorImage, false);
    }

    /**
     * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors
     * showConnectors} is true. Connector icons are rendered into the title field of each row and show the dotted hierarchy
     * lines between siblings of the same parent node. For each node, a connector icon may be shown:<ul> <li>As an opener icon
     * for folder nodes, next to the folder icon</li> <li>In place of an opener icon for leaf nodes, next to the leaf icon</li>
     * <li>As a standalone vertical continuation line in the indent to the left of the node, to show     a connection between
     * some ancestor node's siblings (only relevant if     {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li> </ul> Note that
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector
     * lines will be displayed for all indent levels, or just for the innermost level of the tree. <P> The filenames for these
     * icons are assembled from this base filename and the state of the node.  Assuming the connectorImage is set to
     * <code>{baseName}.{extension}</code>, the full set of images to be displayed will be: <P>
     * <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}  is true, this is the URL for the
     * vertical continuation image to be displayed at the  appropriate indent levels for ancestor nodes with subsequent
     * children. <P> For nodes with no children: <ul> <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is
     * no connector line  attached to the parent or previous sibling, and no connector line to the next sibling. For  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors:true} trees, there will always be a 
     * connector leading to the parent or previous sibling if its present in the tree so this  icon can only be displayed for
     * the first row.</li> <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector  line
     * attached to the parent or previous sibling, but there is a connector to the next  sibling. As with <code>_single</code>
     * this will only ever be used for the first row if  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors
     * showFullConnectors} is true</li> <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a
     * connector   line attached to the next sibling of this node (but are showing a connection to the previous  sibling or
     * parent).</li> <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector  line leading
     * to both the previous sibling (or parent) and the next sibling. </ul> For folders with children. Note that if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open folders will never
     * show a connector to subsequent siblings: <ul> <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder
     * node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to
     * any subsequent siblings.</li> <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children 
     * when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next
     * sibling.</li> <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children   if we are not
     * showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous
     * sibling or parent).</li> <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children  
     * where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> <ul>
     * <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with   children when no connector line is
     * shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li>
     * <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children  when the there is no connector
     * line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li>
     * <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children   if we are not showing a
     * connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or
     * parent).</li> <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children   where the we
     * have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> (Note '[_rtl]' means
     * that "_rtl" will be attached if isRTL() is true for this widget). <P> If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is true the URL for selected nodes
     * will append the string <code>"_selected"</code> to the image URLs described above. So for a connectorImage set to
     * <code>{baseName}.{extension}</code>, the URLs for selected records would be
     * <code>{baseName}_ancestor[_rtl]_selected.{extension}</code>,  <code>{baseName}_single[_rtl]_selected.{extension}</code>,
     * etc.
     *
     * @return Current connectorImage value. Default value is "[SKIN]connector.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getConnectorImage()  {
        return getAttributeAsString("connectorImage");
    }
    

    /**
     * If no fields are specified, create a single field with  {@link
     * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField TreeGridField.treeField} set to <code>true</code> to show
     * the tree. <P> This automatically generated field will display values derived by calling {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeTitle getNodeTitle()}, and have the column title set to the specified
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getTreeFieldTitle treeFieldTitle}. <P> Has no effect if fields are
     * explicitly specified. <P> This is a convenience setting to allow a TreeGrid to be created without specifying a field
     * list.  If fields are specified, refer to the documentation on property {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAutoAssignTreeField autoAssignTreeField} for a way to automatically have
     * one of the fields be use as the tree field if no fields have {@link
     * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField TreeGridField.treeField} set. <P> For databound treeGrids,
     * if there is no explicit fields array specified, developers who wish to pick up all fields from the DataSource definition
     * rather than displaying this single automatically generated tree field may  either set this property to false, or set
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getUseAllDataSourceFields useAllDataSourceFields} to <code>true</code>.
     *
     * @param createDefaultTreeField New createDefaultTreeField value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCreateDefaultTreeField(Boolean createDefaultTreeField)  throws IllegalStateException {
        setAttribute("createDefaultTreeField", createDefaultTreeField, false);
    }

    /**
     * If no fields are specified, create a single field with  {@link
     * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField TreeGridField.treeField} set to <code>true</code> to show
     * the tree. <P> This automatically generated field will display values derived by calling {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeTitle getNodeTitle()}, and have the column title set to the specified
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getTreeFieldTitle treeFieldTitle}. <P> Has no effect if fields are
     * explicitly specified. <P> This is a convenience setting to allow a TreeGrid to be created without specifying a field
     * list.  If fields are specified, refer to the documentation on property {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAutoAssignTreeField autoAssignTreeField} for a way to automatically have
     * one of the fields be use as the tree field if no fields have {@link
     * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField TreeGridField.treeField} set. <P> For databound treeGrids,
     * if there is no explicit fields array specified, developers who wish to pick up all fields from the DataSource definition
     * rather than displaying this single automatically generated tree field may  either set this property to false, or set
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getUseAllDataSourceFields useAllDataSourceFields} to <code>true</code>.
     *
     * @return Current createDefaultTreeField value. Default value is true
     */
    public Boolean getCreateDefaultTreeField()  {
        Boolean result = getAttributeAsBoolean("createDefaultTreeField");
        return result == null ? true : result;
    }
    

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon
     * default node.showDropIcon} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param customIconDropProperty New customIconDropProperty value. Default value is "showDropIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconDrop
     */
    public void setCustomIconDropProperty(String customIconDropProperty) {
        setAttribute("customIconDropProperty", customIconDropProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon
     * default node.showDropIcon} property.
     *
     * @return Current customIconDropProperty value. Default value is "showDropIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop
     */
    public String getCustomIconDropProperty()  {
        return getAttributeAsString("customIconDropProperty");
    }
    

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param customIconOpenProperty New customIconOpenProperty value. Default value is "showOpenIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconOpen
     */
    public void setCustomIconOpenProperty(String customIconOpenProperty) {
        setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     *
     * @return Current customIconOpenProperty value. Default value is "showOpenIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen
     */
    public String getCustomIconOpenProperty()  {
        return getAttributeAsString("customIconOpenProperty");
    }
    

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon default
     * node.icon} property.
     *
     * @param customIconProperty New customIconProperty value. Default value is "icon"
     */
    public void setCustomIconProperty(String customIconProperty) {
        setAttribute("customIconProperty", customIconProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon default
     * node.icon} property.
     *
     * @return Current customIconProperty value. Default value is "icon"
     */
    public String getCustomIconProperty()  {
        return getAttributeAsString("customIconProperty");
    }
    

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowSelectedIcon
     * default node.showSelectedIcon} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param customIconSelectedProperty New customIconSelectedProperty value. Default value is "showSelectedIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconSelected
     */
    public void setCustomIconSelectedProperty(String customIconSelectedProperty) {
        setAttribute("customIconSelectedProperty", customIconSelectedProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowSelectedIcon
     * default node.showSelectedIcon} property.
     *
     * @return Current customIconSelectedProperty value. Default value is "showSelectedIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconSelected
     */
    public String getCustomIconSelectedProperty()  {
        return getAttributeAsString("customIconSelectedProperty");
    }
    
    

    /**
     * Mode of fetching records from server. <P> fetchMode:"local" implies that local filtering will always be performed. See
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"basic" or "paged" implies that if search criteria change, the entire tree will be discarded and
     * re-fetched from the server.  When retrieving the replacement tree data, the default behavior will be to preserve the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenState openState} for any nodes that the server returns which
     * were previously opened by the user.  Note that this implies that if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand} is enabled and the server returns only
     * root-level nodes, open state will be preserved only for root-level nodes, and children of open root-level nodes will be
     * immediately fetched from the server if they are not included in the server's initial response. <P> fetchMode:"paged"
     * enables paging for nodes that have very large numbers of children. Whenever the children of a folder are loaded, the
     * <code>resultTree</code> will set {@link com.smartgwt.client.data.DSRequest#getStartRow DSRequest.startRow} and {@link
     * com.smartgwt.client.data.DSRequest#getEndRow endRow} when requesting children from the DataSource, and will manage
     * loading of further children on demand, similar to how a {@link com.smartgwt.client.data.ResultSet} manages paging for
     * lists.  For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "basic"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.ResultTree#setLoadDataOnDemand
     * @see com.smartgwt.client.widgets.tree.ResultTree#setUseSimpleCriteriaLOD
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree_paging_for_children" target="examples">Paging for Children Example</a>
     */
    public void setDataFetchMode(FetchMode dataFetchMode)  throws IllegalStateException {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), false);
    }

    /**
     * Mode of fetching records from server. <P> fetchMode:"local" implies that local filtering will always be performed. See
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"basic" or "paged" implies that if search criteria change, the entire tree will be discarded and
     * re-fetched from the server.  When retrieving the replacement tree data, the default behavior will be to preserve the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenState openState} for any nodes that the server returns which
     * were previously opened by the user.  Note that this implies that if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand} is enabled and the server returns only
     * root-level nodes, open state will be preserved only for root-level nodes, and children of open root-level nodes will be
     * immediately fetched from the server if they are not included in the server's initial response. <P> fetchMode:"paged"
     * enables paging for nodes that have very large numbers of children. Whenever the children of a folder are loaded, the
     * <code>resultTree</code> will set {@link com.smartgwt.client.data.DSRequest#getStartRow DSRequest.startRow} and {@link
     * com.smartgwt.client.data.DSRequest#getEndRow endRow} when requesting children from the DataSource, and will manage
     * loading of further children on demand, similar to how a {@link com.smartgwt.client.data.ResultSet} manages paging for
     * lists.  For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @return Current dataFetchMode value. Default value is "basic"
     * @see com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand
     * @see com.smartgwt.client.widgets.tree.ResultTree#getUseSimpleCriteriaLOD
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree_paging_for_children" target="examples">Paging for Children Example</a>
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * For a <code>TreeGrid</code> that uses a DataSource, these properties will be passed to the automatically-created
     * ResultTree.  This can be used for various customizations such as modifying the automatically-chosen {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField Tree.parentIdField}.
     *
     * @return Current dataProperties value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Tree getDataProperties()  {
        return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("dataProperties"));
    }
    
    

    /**
     * Specifies the type of nodes displayed in the treeGrid.
     *
     * @param displayNodeType New displayNodeType value. Default value is Tree.FOLDERS_AND_LEAVES
     * @see com.smartgwt.client.types.DisplayNodeType
     */
    public void setDisplayNodeType(DisplayNodeType displayNodeType) {
        setAttribute("displayNodeType", displayNodeType == null ? null : displayNodeType.getValue(), true);
    }

    /**
     * Specifies the type of nodes displayed in the treeGrid.
     *
     * @return Current displayNodeType value. Default value is Tree.FOLDERS_AND_LEAVES
     * @see com.smartgwt.client.types.DisplayNodeType
     */
    public DisplayNodeType getDisplayNodeType()  {
        return EnumUtil.getEnum(DisplayNodeType.values(), getAttribute("displayNodeType"));
    }
    
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers
     * over some folder.
     *
     * @param dropIconSuffix New dropIconSuffix value. Default value is "drop"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDropIconSuffix(String dropIconSuffix)  throws IllegalStateException {
        setAttribute("dropIconSuffix", dropIconSuffix, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers
     * over some folder.
     *
     * @return Current dropIconSuffix value. Default value is "drop"
     */
    public String getDropIconSuffix()  {
        return getAttributeAsString("dropIconSuffix");
    }
    

    /**
     * The amount of gap (in pixels) between the extraIcon (see {@link com.smartgwt.client.widgets.tree.TreeGrid#getExtraIcon
     * getExtraIcon()}) or checkbox icon and the {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon}/ {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} or node text.
     *
     * @param extraIconGap New extraIconGap value. Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setExtraIconGap(int extraIconGap)  throws IllegalStateException {
        setAttribute("extraIconGap", extraIconGap, false);
    }

    /**
     * The amount of gap (in pixels) between the extraIcon (see {@link com.smartgwt.client.widgets.tree.TreeGrid#getExtraIcon
     * getExtraIcon()}) or checkbox icon and the {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon}/ {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} or node text.
     *
     * @return Current extraIconGap value. Default value is 2
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getExtraIconGap()  {
        return getAttributeAsInt("extraIconGap");
    }
    

    /**
     * An array of field objects, specifying the order, layout, dynamic calculation, and sorting behavior of each field in the
     * treeGrid object. In TreeGrids, the fields array specifies columns. Each field in the fields array is TreeGridField
     * object. <p> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataSource dataSource} is also set, this value acts
     * as a set of overrides as explained in {@link com.smartgwt.client.widgets.DataBoundComponent#getFields
     * DataBoundComponent.fields}.
     *
     * @param fields New fields value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGridField
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setFields(TreeGridField... fields) {
        setAttribute("fields", fields, true);
    }
    
    
    
    

    /**
     * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will have {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if
     * appropriate -  see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons},
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
     *
     * @param folderIcon New folderIcon value. Default value is "[SKIN]folder.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public void setFolderIcon(String folderIcon) {
        setAttribute("folderIcon", folderIcon, true);
    }

    /**
     * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will have {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if
     * appropriate -  see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons},
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
     *
     * @return Current folderIcon value. Default value is "[SKIN]folder.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }
    
    

    /**
     * The standard size (same height and width, in pixels) of node icons in this          treeGrid.
     *
     * @param iconSize New iconSize value. Default value is 16
     */
    public void setIconSize(int iconSize) {
        setAttribute("iconSize", iconSize, true);
    }

    /**
     * The standard size (same height and width, in pixels) of node icons in this          treeGrid.
     *
     * @return Current iconSize value. Default value is 16
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * For record components placed "within" the {@link com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField}
     * column, should the component be indented to the position where a title would normally show? <P> For more general
     * placement of embedded components, see {@link com.smartgwt.client.widgets.grid.ListGrid#addEmbeddedComponent
     * addEmbeddedComponent}.
     *
     * @param indentRecordComponents New indentRecordComponents value. Default value is true
     */
    public void setIndentRecordComponents(Boolean indentRecordComponents) {
        setAttribute("indentRecordComponents", indentRecordComponents, true);
    }

    /**
     * For record components placed "within" the {@link com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField}
     * column, should the component be indented to the position where a title would normally show? <P> For more general
     * placement of embedded components, see {@link com.smartgwt.client.widgets.grid.ListGrid#addEmbeddedComponent
     * addEmbeddedComponent}.
     *
     * @return Current indentRecordComponents value. Default value is true
     */
    public Boolean getIndentRecordComponents()  {
        Boolean result = getAttributeAsBoolean("indentRecordComponents");
        return result == null ? true : result;
    }
    

    /**
     * The amount of indentation (in pixels) to add to a node's icon/title for each level down in this tree's hierarchy. <p>
     * This value is ignored when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is
     * <code>true</code> because fixed-size images are used to render the connectors.
     *
     * @param indentSize New indentSize value. Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setIndentSize(int indentSize) {
        setAttribute("indentSize", indentSize, true);
    }

    /**
     * The amount of indentation (in pixels) to add to a node's icon/title for each level down in this tree's hierarchy. <p>
     * This value is ignored when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is
     * <code>true</code> because fixed-size images are used to render the connectors.
     *
     * @return Current indentSize value. Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getIndentSize()  {
        return getAttributeAsInt("indentSize");
    }
    
    

    /**
     * If set, tree-based filtering is performed such that parent nodes are kept as long as they have children that match the
     * filter criteria, even if the parents themselves do not match the filter criteria. If not set, filtering will exclude
     * parent nodes not matching the criteria and all nodes below it in the tree. <P> When <code>keepParentsOnFilter</code> is
     * enabled for paged ResultTrees, server-side filtering is required. <P> When enabled for non-paged trees, {@link
     * com.smartgwt.client.types.FetchMode fetchMode:"local"} is automatically enabled so that all filtering behavior shifts to
     * the client-side and full criteria are no longer sent to the server.  Instead, server fetches will always load all nodes,
     * or with {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, will always load
     * all nodes under a given parent. This means that the server does not need to implement special tree filtering logic. <P>
     * Optionally, {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields ResultTree.serverFilterFields} can
     * be set to a list of field names that will be sent to the server whenever they are present in the criteria.
     *
     * @param keepParentsOnFilter New keepParentsOnFilter value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public void setKeepParentsOnFilter(Boolean keepParentsOnFilter)  throws IllegalStateException {
        setAttribute("keepParentsOnFilter", keepParentsOnFilter, false);
    }

    /**
     * If set, tree-based filtering is performed such that parent nodes are kept as long as they have children that match the
     * filter criteria, even if the parents themselves do not match the filter criteria. If not set, filtering will exclude
     * parent nodes not matching the criteria and all nodes below it in the tree. <P> When <code>keepParentsOnFilter</code> is
     * enabled for paged ResultTrees, server-side filtering is required. <P> When enabled for non-paged trees, {@link
     * com.smartgwt.client.types.FetchMode fetchMode:"local"} is automatically enabled so that all filtering behavior shifts to
     * the client-side and full criteria are no longer sent to the server.  Instead, server fetches will always load all nodes,
     * or with {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, will always load
     * all nodes under a given parent. This means that the server does not need to implement special tree filtering logic. <P>
     * Optionally, {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields ResultTree.serverFilterFields} can
     * be set to a list of field names that will be sent to the server whenever they are present in the criteria.
     *
     * @return Current keepParentsOnFilter value. Default value is null
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public Boolean getKeepParentsOnFilter()  {
        return getAttributeAsBoolean("keepParentsOnFilter");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}:"checkbox"  is set on
     * the treegrid, and a node can't be selected, should a gap be left where the checkbox icon would normally appear, in order
     * to make the node's icon and title line up with the content for other nodes in the same parent? <p> Has no effect if
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDisabledSelectionCheckbox showDisabledSelectionCheckbox} is
     * <code>true</code>
     *
     * @param leaveSelectionCheckboxGap New leaveSelectionCheckboxGap value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordCanSelectProperty
     */
    public void setLeaveSelectionCheckboxGap(Boolean leaveSelectionCheckboxGap)  throws IllegalStateException {
        setAttribute("leaveSelectionCheckboxGap", leaveSelectionCheckboxGap, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}:"checkbox"  is set on
     * the treegrid, and a node can't be selected, should a gap be left where the checkbox icon would normally appear, in order
     * to make the node's icon and title line up with the content for other nodes in the same parent? <p> Has no effect if
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDisabledSelectionCheckbox showDisabledSelectionCheckbox} is
     * <code>true</code>
     *
     * @return Current leaveSelectionCheckboxGap value. Default value is true
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordCanSelectProperty
     */
    public Boolean getLeaveSelectionCheckboxGap()  {
        Boolean result = getAttributeAsBoolean("leaveSelectionCheckboxGap");
        return result == null ? true : result;
    }
    

    /**
     * For databound treeGrid instances, should the entire tree of data be loaded on initial  fetch, or should folders load
     * their children as they are opened. <P> If unset, calling {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData
     * fetchData()} will default it to true, otherwise, if a ResultTree is passed to {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setData setData()}, the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand ResultTree.loadDataOnDemand} setting is respected.  Must
     * be enabled on the underlying {@link com.smartgwt.client.widgets.tree.ResultTree} when using {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDataFetchMode dataFetchMode}: "paged". <P> Note that when using
     * <code>loadDataOnDemand</code>, every node returned by the server is assumed be a folder which may load further children.
     * See {@link com.smartgwt.client.widgets.tree.ResultTree#getDefaultIsFolder ResultTree.defaultIsFolder} for how to control
     * this behavior.
     *
     * @param loadDataOnDemand New loadDataOnDemand value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setDataFetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand" target="examples">Initial Data & Load on Demand Example</a>
     */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand) {
        setAttribute("loadDataOnDemand", loadDataOnDemand, true);
    }

    /**
     * For databound treeGrid instances, should the entire tree of data be loaded on initial  fetch, or should folders load
     * their children as they are opened. <P> If unset, calling {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData
     * fetchData()} will default it to true, otherwise, if a ResultTree is passed to {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setData setData()}, the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand ResultTree.loadDataOnDemand} setting is respected.  Must
     * be enabled on the underlying {@link com.smartgwt.client.widgets.tree.ResultTree} when using {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDataFetchMode dataFetchMode}: "paged". <P> Note that when using
     * <code>loadDataOnDemand</code>, every node returned by the server is assumed be a folder which may load further children.
     * See {@link com.smartgwt.client.widgets.tree.ResultTree#getDefaultIsFolder ResultTree.defaultIsFolder} for how to control
     * this behavior.
     *
     * @return Current loadDataOnDemand value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getDataFetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand" target="examples">Initial Data & Load on Demand Example</a>
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowLoadingIcons showLoadingIcons} is set, this icon will be used
     * when the folder is  {@link com.smartgwt.client.widgets.tree.Tree#getLoadState loading children from the server}.
     *
     * @param loadingIcon New loadingIcon value. Default value is "[SKIN]folder_loading.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setLoadingIcon(String loadingIcon) {
        setAttribute("loadingIcon", loadingIcon, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowLoadingIcons showLoadingIcons} is set, this icon will be used
     * when the folder is  {@link com.smartgwt.client.widgets.tree.Tree#getLoadState loading children from the server}.
     *
     * @return Current loadingIcon value. Default value is "[SKIN]folder_loading.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getLoadingIcon()  {
        return getAttributeAsString("loadingIcon");
    }
    

    /**
     * The filename of the icon displayed use as the default drag tracker when for multiple files and/or folders are being
     * dragged.
     *
     * @param manyItemsImage New manyItemsImage value. Default value is "[SKIN]folder_file.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setManyItemsImage(String manyItemsImage) {
        setAttribute("manyItemsImage", manyItemsImage, true);
    }

    /**
     * The filename of the icon displayed use as the default drag tracker when for multiple files and/or folders are being
     * dragged.
     *
     * @return Current manyItemsImage value. Default value is "[SKIN]folder_file.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public String getManyItemsImage()  {
        return getAttributeAsString("manyItemsImage");
    }
    

    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on the node.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the icon for a particular treenode to a specified URL
     *
     * @param nodeIcon tree node. Default value is "[SKIN]file.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public void setNodeIcon(String nodeIcon) {
        setAttribute("nodeIcon", nodeIcon, true);
    }

    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on the node.
     *
     * @return Current nodeIcon value. Default value is "[SKIN]file.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public String getNodeIcon()  {
        return getAttributeAsString("nodeIcon");
    }
    

    /**
     * For TreeGrids with loadDataOnDemand: true, a message to show the user if an attempt is  made to open a folder, and thus
     * load that node's children, while we are offline and  there is no offline cache of that data.  The message will be
     * presented to the user in  in a pop-up dialog box.
     *
     * @param offlineNodeMessage New offlineNodeMessage value. Default value is "This data not available while offline"
     */
    public void setOfflineNodeMessage(String offlineNodeMessage) {
        setAttribute("offlineNodeMessage", offlineNodeMessage, true);
    }

    /**
     * For TreeGrids with loadDataOnDemand: true, a message to show the user if an attempt is  made to open a folder, and thus
     * load that node's children, while we are offline and  there is no offline cache of that data.  The message will be
     * presented to the user in  in a pop-up dialog box.
     *
     * @return Current offlineNodeMessage value. Default value is "This data not available while offline"
     */
    public String getOfflineNodeMessage()  {
        return getAttributeAsString("offlineNodeMessage");
    }
    

    /**
     * Height in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a
     * [+] or [-] symbol. <P> If not specified, {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconSize
     * openerIconSize} is used instead.
     *
     * @param openerIconHeight New openerIconHeight value. Default value is null
     */
    public void setOpenerIconHeight(Integer openerIconHeight) {
        setAttribute("openerIconHeight", openerIconHeight, true);
    }

    /**
     * Height in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a
     * [+] or [-] symbol. <P> If not specified, {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconSize
     * openerIconSize} is used instead.
     *
     * @return Current openerIconHeight value. Default value is null
     */
    public Integer getOpenerIconHeight()  {
        return getAttributeAsInt("openerIconHeight");
    }
    

    /**
     * Default width and height in pixels of the opener icons, that is, the icons which show the open or closed state of the
     * node, typically a [+] or [-] symbol, if not overridden by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconWidth openerIconWidth}/{@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconHeight openerIconHeight}. <P> If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the
     * connector line, and defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight}. <P>
     * Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize
     * iconSize}.
     *
     * @param openerIconSize New openerIconSize value. Default value is null
     */
    public void setOpenerIconSize(Integer openerIconSize) {
        setAttribute("openerIconSize", openerIconSize, true);
    }

    /**
     * Default width and height in pixels of the opener icons, that is, the icons which show the open or closed state of the
     * node, typically a [+] or [-] symbol, if not overridden by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconWidth openerIconWidth}/{@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconHeight openerIconHeight}. <P> If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the
     * connector line, and defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight}. <P>
     * Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize
     * iconSize}.
     *
     * @return Current openerIconSize value. Default value is null
     */
    public Integer getOpenerIconSize()  {
        return getAttributeAsInt("openerIconSize");
    }
    

    /**
     * Width in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a [+]
     * or [-] symbol. <P> If not specified, {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconSize openerIconSize}
     * is used instead.
     *
     * @param openerIconWidth New openerIconWidth value. Default value is null
     */
    public void setOpenerIconWidth(Integer openerIconWidth) {
        setAttribute("openerIconWidth", openerIconWidth, true);
    }

    /**
     * Width in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a [+]
     * or [-] symbol. <P> If not specified, {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerIconSize openerIconSize}
     * is used instead.
     *
     * @return Current openerIconWidth value. Default value is null
     */
    public Integer getOpenerIconWidth()  {
        return getAttributeAsInt("openerIconWidth");
    }
    

    /**
     * The base filename of the opener icon for the folder node when 'showConnectors' is false for this TreeGrid.<br> The
     * opener icon is displayed beside the folder icon in the Tree column for folder nodes. Clicking on this icon will toggle
     * the open state of the folder.<br> The filenames for these icons are assembled from this base filename and the state of
     * the node, as follows:<br> If the openerImage is set to <code>{baseName}.{extension}</code>, 
     * <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and
     * <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or if this page is in RTL mode,
     * <code>{baseName}_opened_rtl.{extension}</code> and <code>{baseName}_closed_rtl.{extension}</code> will be used. <P> If
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is true the URL for selected
     * nodes will append the string <code>"_selected"</code> to the image URLs described above. So for an openerImage set to
     * <code>{baseName}.{extension}</code>, the URLs for selected records would be
     * <code>{baseName}_opened_selected.{extension}</code>,  <code>{baseName}_closed_selected.{extension}</code>, etc.
     *
     * @param openerImage New openerImage value. Default value is "[SKIN]opener.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setOpenerImage(String openerImage)  throws IllegalStateException {
        setAttribute("openerImage", openerImage, false);
    }

    /**
     * The base filename of the opener icon for the folder node when 'showConnectors' is false for this TreeGrid.<br> The
     * opener icon is displayed beside the folder icon in the Tree column for folder nodes. Clicking on this icon will toggle
     * the open state of the folder.<br> The filenames for these icons are assembled from this base filename and the state of
     * the node, as follows:<br> If the openerImage is set to <code>{baseName}.{extension}</code>, 
     * <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and
     * <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or if this page is in RTL mode,
     * <code>{baseName}_opened_rtl.{extension}</code> and <code>{baseName}_closed_rtl.{extension}</code> will be used. <P> If
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is true the URL for selected
     * nodes will append the string <code>"_selected"</code> to the image URLs described above. So for an openerImage set to
     * <code>{baseName}.{extension}</code>, the URLs for selected records would be
     * <code>{baseName}_opened_selected.{extension}</code>,  <code>{baseName}_closed_selected.{extension}</code>, etc.
     *
     * @return Current openerImage value. Default value is "[SKIN]opener.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getOpenerImage()  {
        return getAttributeAsString("openerImage");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this
     * grid.
     *
     * @param openIconSuffix New openIconSuffix value. Default value is "open"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOpenIconSuffix(String openIconSuffix)  throws IllegalStateException {
        setAttribute("openIconSuffix", openIconSuffix, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this
     * grid.
     *
     * @return Current openIconSuffix value. Default value is "open"
     */
    public String getOpenIconSuffix()  {
        return getAttributeAsString("openIconSuffix");
    }
    

    /**
     * Message displayed when user attempts to drag a node into a parent that already contains a child of the same name.
     *
     * @param parentAlreadyContainsChildMessage New parentAlreadyContainsChildMessage value. Default value is "This item already contains a child item with that name."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCanReorderRecords
     */
    public void setParentAlreadyContainsChildMessage(String parentAlreadyContainsChildMessage)  throws IllegalStateException {
        setAttribute("parentAlreadyContainsChildMessage", parentAlreadyContainsChildMessage, false);
    }

    /**
     * Message displayed when user attempts to drag a node into a parent that already contains a child of the same name.
     *
     * @return Current parentAlreadyContainsChildMessage value. Default value is "This item already contains a child item with that name."
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
     */
    public String getParentAlreadyContainsChildMessage()  {
        return getAttributeAsString("parentAlreadyContainsChildMessage");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} is true for this
     * treeGrid, this property governs whether the user can drop between, or over records within the grid. This controls what
     * {@link com.smartgwt.client.types.RecordDropPosition} is passed to the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#recordDrop recordDrop()} event handler.
     *
     * @param recordDropAppearance New recordDropAppearance value. Default value is ListGrid.BOTH
     */
    public void setRecordDropAppearance(RecordDropAppearance recordDropAppearance) {
        setAttribute("recordDropAppearance", recordDropAppearance == null ? null : recordDropAppearance.getValue(), true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} is true for this
     * treeGrid, this property governs whether the user can drop between, or over records within the grid. This controls what
     * {@link com.smartgwt.client.types.RecordDropPosition} is passed to the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#recordDrop recordDrop()} event handler.
     *
     * @return Current recordDropAppearance value. Default value is ListGrid.BOTH
     */
    public RecordDropAppearance getRecordDropAppearance()  {
        return EnumUtil.getEnum(RecordDropAppearance.values(), getAttribute("recordDropAppearance"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for selected nodes in this
     * grid.
     *
     * @param selectedIconSuffix New selectedIconSuffix value. Default value is "selected"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSelectedIconSuffix(String selectedIconSuffix)  throws IllegalStateException {
        setAttribute("selectedIconSuffix", selectedIconSuffix, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for selected nodes in this
     * grid.
     *
     * @return Current selectedIconSuffix value. Default value is "selected"
     */
    public String getSelectedIconSuffix()  {
        return getAttributeAsString("selectedIconSuffix");
    }
    

    /**
     * If specified, the selection object for this list will use this property to mark records as selected.  In other words, if
     * this attribute were set to <code>"isSelected"</code> any records in the listGrid data where <code>"isSelected"</code> is
     * <code>true</code> will show up as selected in the grid. Similarly if records are selected within the grid after the grid
     * has been created, this property will be set to true on the selected records.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param selectionProperty New selectionProperty value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public void setSelectionProperty(String selectionProperty)  throws IllegalStateException {
        setAttribute("selectionProperty", selectionProperty, false);
    }

    /**
     * If specified, the selection object for this list will use this property to mark records as selected.  In other words, if
     * this attribute were set to <code>"isSelected"</code> any records in the listGrid data where <code>"isSelected"</code> is
     * <code>true</code> will show up as selected in the grid. Similarly if records are selected within the grid after the grid
     * has been created, this property will be set to true on the selected records.
     *
     * @return Current selectionProperty value. Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public String getSelectionProperty()  {
        return getAttributeAsString("selectionProperty");
    }
    

    /**
     * If specified, this attribute will override {@link com.smartgwt.client.widgets.tree.Tree#getSeparateFolders
     * Tree.separateFolders} on the data for this treeGrid. <P> Specifies whether folders and leaves should be segregated in
     * the treeGrid display. Use {@link com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves
     * Tree.sortFoldersBeforeLeaves} to customize whether folders appear before  or after their sibling leaves. <P> If unset,
     * at the treeGrid level, the property can be set directly on {@link com.smartgwt.client.widgets.tree.TreeGrid#getData the
     * tree data object} or for dataBound TreeGrids on the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataProperties
     * dataProperties}.
     *
     * @param separateFolders New separateFolders value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSeparateFolders(Boolean separateFolders)  throws IllegalStateException {
        setAttribute("separateFolders", separateFolders, false);
    }

    /**
     * If specified, this attribute will override {@link com.smartgwt.client.widgets.tree.Tree#getSeparateFolders
     * Tree.separateFolders} on the data for this treeGrid. <P> Specifies whether folders and leaves should be segregated in
     * the treeGrid display. Use {@link com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves
     * Tree.sortFoldersBeforeLeaves} to customize whether folders appear before  or after their sibling leaves. <P> If unset,
     * at the treeGrid level, the property can be set directly on {@link com.smartgwt.client.widgets.tree.TreeGrid#getData the
     * tree data object} or for dataBound TreeGrids on the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataProperties
     * dataProperties}.
     *
     * @return Current separateFolders value. Default value is null
     */
    public Boolean getSeparateFolders()  {
        return getAttributeAsBoolean("separateFolders");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.tree.TreeGrid#getKeepParentsOnFilter keepParentsOnFilter} is enabled for {@link
     * com.smartgwt.client.types.FetchMode fetchMode:"local"} ResultTrees, this property lists field names that will be sent to
     * the server if they are present in the criteria.
     *
     * @param serverFilterFields New serverFilterFields value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setServerFilterFields(String... serverFilterFields)  throws IllegalStateException {
        setAttribute("serverFilterFields", serverFilterFields, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.tree.TreeGrid#getKeepParentsOnFilter keepParentsOnFilter} is enabled for {@link
     * com.smartgwt.client.types.FetchMode fetchMode:"local"} ResultTrees, this property lists field names that will be sent to
     * the server if they are present in the criteria.
     *
     * @return Current serverFilterFields value. Default value is null
     */
    public String[] getServerFilterFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("serverFilterFields"));
    }
    

    /**
     * Should this treeGrid show connector lines illustrating the tree's hierarchy? <P> For the set of images used to show
     * connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}. <P> <b>Note</b>: in
     * order for connector images to be perfectly connected, all styles for cells must have no top or bottom border or padding.
     * If you see small gaps in connector lines, check your CSS files.  See the example below for an example of correct
     * configuration, including example CSS.
     *
     * @param showConnectors New showConnectors value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_connectors" target="examples">Connectors Example</a>
     */
    public void setShowConnectors(Boolean showConnectors) {
        setAttribute("showConnectors", showConnectors, true);
    }

    /**
     * Should this treeGrid show connector lines illustrating the tree's hierarchy? <P> For the set of images used to show
     * connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}. <P> <b>Note</b>: in
     * order for connector images to be perfectly connected, all styles for cells must have no top or bottom border or padding.
     * If you see small gaps in connector lines, check your CSS files.  See the example below for an example of correct
     * configuration, including example CSS.
     *
     * @return Current showConnectors value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_connectors" target="examples">Connectors Example</a>
     */
    public Boolean getShowConnectors()  {
        Boolean result = getAttributeAsBoolean("showConnectors");
        return result == null ? false : result;
    }
    

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}, default {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIcon TreeNode.icon}), show drop state images when the user is drop-hovering
     * over the folder. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be
     * appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_drop.gif"</code>).<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon TreeNode.showDropIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCustomIconDrop New showCustomIconDrop value. Default value is false
     */
    public void setShowCustomIconDrop(Boolean showCustomIconDrop) {
        setAttribute("showCustomIconDrop", showCustomIconDrop, true);
    }

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}, default {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIcon TreeNode.icon}), show drop state images when the user is drop-hovering
     * over the folder. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be
     * appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_drop.gif"</code>).<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon TreeNode.showDropIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty}.
     *
     * @return Current showCustomIconDrop value. Default value is false
     */
    public Boolean getShowCustomIconDrop()  {
        Boolean result = getAttributeAsBoolean("showCustomIconDrop");
        return result == null ? false : result;
    }
    

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show open state images when the
     * folder is opened. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder
     * icons.<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon TreeNode.showOpenIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCustomIconOpen New showCustomIconOpen value. Default value is false
     */
    public void setShowCustomIconOpen(Boolean showCustomIconOpen) {
        setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show open state images when the
     * folder is opened. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder
     * icons.<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon TreeNode.showOpenIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty}.
     *
     * @return Current showCustomIconOpen value. Default value is false
     */
    public Boolean getShowCustomIconOpen()  {
        Boolean result = getAttributeAsBoolean("showCustomIconOpen");
        return result == null ? false : result;
    }
    

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show selected state images when
     * the folder is selected,  if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} is
     * true? <P> If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getSelectedIconSuffix selectedIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_selected.gif"</code>).<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowSelectedIcon TreeNode.showSelectedIcon} and that property can be
     * renamed via {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconSelectedProperty customIconSelectedProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCustomIconSelected New showCustomIconSelected value. Default value is false
     */
    public void setShowCustomIconSelected(Boolean showCustomIconSelected) {
        setAttribute("showCustomIconSelected", showCustomIconSelected, true);
    }

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show selected state images when
     * the folder is selected,  if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedIcons showSelectedIcons} is
     * true? <P> If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getSelectedIconSuffix selectedIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_selected.gif"</code>).<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowSelectedIcon TreeNode.showSelectedIcon} and that property can be
     * renamed via {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconSelectedProperty customIconSelectedProperty}.
     *
     * @return Current showCustomIconSelected value. Default value is false
     */
    public Boolean getShowCustomIconSelected()  {
        Boolean result = getAttributeAsBoolean("showCustomIconSelected");
        return result == null ? false : result;
    }
    

    /**
     * Should tree nodes show a disabled checkbox  {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance
     * selectionAppearance}:"checkbox"  is set on the treegrid, and a node can't be selected?  <P> If set to <code>false</code>
     * the treeGrid will use  {@link com.smartgwt.client.widgets.tree.TreeGrid#getLeaveSelectionCheckboxGap
     * leaveSelectionCheckboxGap} to determine whether to leave a blank space where the checkbox would normally appear.
     *
     * @param showDisabledSelectionCheckbox New showDisabledSelectionCheckbox value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.grid.ListGrid#setRecordCanSelectProperty
     */
    public void setShowDisabledSelectionCheckbox(Boolean showDisabledSelectionCheckbox)  throws IllegalStateException {
        setAttribute("showDisabledSelectionCheckbox", showDisabledSelectionCheckbox, false);
    }

    /**
     * Should tree nodes show a disabled checkbox  {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance
     * selectionAppearance}:"checkbox"  is set on the treegrid, and a node can't be selected?  <P> If set to <code>false</code>
     * the treeGrid will use  {@link com.smartgwt.client.widgets.tree.TreeGrid#getLeaveSelectionCheckboxGap
     * leaveSelectionCheckboxGap} to determine whether to leave a blank space where the checkbox would normally appear.
     *
     * @return Current showDisabledSelectionCheckbox value. Default value is false
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordCanSelectProperty
     */
    public Boolean getShowDisabledSelectionCheckbox()  {
        Boolean result = getAttributeAsBoolean("showDisabledSelectionCheckbox");
        return result == null ? false : result;
    }
    

    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder icon. This
     * is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example
     * <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     * @param showDropIcons New showDropIcons value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public void setShowDropIcons(Boolean showDropIcons) {
        setAttribute("showDropIcons", showDropIcons, true);
    }

    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder icon. This
     * is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example
     * <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     * @return Current showDropIcons value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Boolean getShowDropIcons()  {
        Boolean result = getAttributeAsBoolean("showDropIcons");
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines
     * whether we should show vertical continuation lines for each level of indenting within the tree. Setting to false will
     * show only the hierarchy lines are only shown for the most indented path ("sparse" connectors).
     *
     * @param showFullConnectors New showFullConnectors value. Default value is true
     */
    public void setShowFullConnectors(Boolean showFullConnectors) {
        setAttribute("showFullConnectors", showFullConnectors, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines
     * whether we should show vertical continuation lines for each level of indenting within the tree. Setting to false will
     * show only the hierarchy lines are only shown for the most indented path ("sparse" connectors).
     *
     * @return Current showFullConnectors value. Default value is true
     */
    public Boolean getShowFullConnectors()  {
        Boolean result = getAttributeAsBoolean("showFullConnectors");
        return result == null ? true : result;
    }
    

    /**
     * If set, when a folder is loading it's children from the server ({@link
     * com.smartgwt.client.widgets.tree.Tree#getLoadState Tree.getLoadState()} returns "loading"), it uses a distinct icon
     * image given by {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadingIcon loadingIcon}.  This is typically used to
     * show a small animating "spinner" icon to let the user know data is being fetched.
     *
     * @param showLoadingIcons New showLoadingIcons value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowLoadingIcons(boolean showLoadingIcons)  throws IllegalStateException {
        setAttribute("showLoadingIcons", showLoadingIcons, false);
    }

    /**
     * If set, when a folder is loading it's children from the server ({@link
     * com.smartgwt.client.widgets.tree.Tree#getLoadState Tree.getLoadState()} returns "loading"), it uses a distinct icon
     * image given by {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadingIcon loadingIcon}.  This is typically used to
     * show a small animating "spinner" icon to let the user know data is being fetched.
     *
     * @return Current showLoadingIcons value. Default value is true
     */
    public boolean getShowLoadingIcons()  {
        Boolean result = getAttributeAsBoolean("showLoadingIcons");
        return result == null ? true : result;
    }
    

    /**
     * Should the opener icon be displayed next to folder nodes? This is an icon which visually indicates whether the folder is
     * opened or closed (typically via a [+] or [-] image, or a turn-down arrow) and may be clicked to expand or collapse the
     * folder. <P> For folders with no children, this icon is not shown unless  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAlwaysShowOpener alwaysShowOpener} is <code>true</code>. Note that for
     * trees which {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand}, we may not know
     * if a folder has any descendants if it has never been opened. As such we will show the opener icon next to the folder.
     * Once the user opens the icon and a fetch occurs, if the folder is empty, and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAlwaysShowOpener alwaysShowOpener} is false, the opener icon will be
     * hidden. <P> For more information on load on demand trees, and how we determine whether a node is a a folder or a leaf,
     * please refer to the {@link com.smartgwt.client.docs.TreeDataBinding} documentation. <P> The opener icon URL is derived
     * from the specified {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerImage openerImage} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage} depending on {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors}. If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is specified a separate opener icon
     * will be displayed for selected nodes.
     *
     * @param showOpener New showOpener value. Default value is true
     */
    public void setShowOpener(Boolean showOpener) {
        setAttribute("showOpener", showOpener, true);
    }

    /**
     * Should the opener icon be displayed next to folder nodes? This is an icon which visually indicates whether the folder is
     * opened or closed (typically via a [+] or [-] image, or a turn-down arrow) and may be clicked to expand or collapse the
     * folder. <P> For folders with no children, this icon is not shown unless  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAlwaysShowOpener alwaysShowOpener} is <code>true</code>. Note that for
     * trees which {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand}, we may not know
     * if a folder has any descendants if it has never been opened. As such we will show the opener icon next to the folder.
     * Once the user opens the icon and a fetch occurs, if the folder is empty, and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getAlwaysShowOpener alwaysShowOpener} is false, the opener icon will be
     * hidden. <P> For more information on load on demand trees, and how we determine whether a node is a a folder or a leaf,
     * please refer to the {@link com.smartgwt.client.docs.TreeDataBinding} documentation. <P> The opener icon URL is derived
     * from the specified {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenerImage openerImage} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage} depending on {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors}. If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowSelectedOpener showSelectedOpener} is specified a separate opener icon
     * will be displayed for selected nodes.
     *
     * @return Current showOpener value. Default value is true
     */
    public Boolean getShowOpener()  {
        Boolean result = getAttributeAsBoolean("showOpener");
        return result == null ? true : result;
    }
    

    /**
     * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code>
     * might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to
     * <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was
     * specified. This will be determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus
     * the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
     *
     * @param showOpenIcons New showOpenIcons value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public void setShowOpenIcons(Boolean showOpenIcons) {
        setAttribute("showOpenIcons", showOpenIcons, true);
    }

    /**
     * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code>
     * might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to
     * <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was
     * specified. This will be determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus
     * the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
     *
     * @return Current showOpenIcons value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Boolean getShowOpenIcons()  {
        Boolean result = getAttributeAsBoolean("showOpenIcons");
        return result == null ? true : result;
    }
    

    /**
     * Should partially selected parents be shown with special icon?
     *
     * @param showPartialSelection New showPartialSelection value. Default value is false
     */
    public void setShowPartialSelection(Boolean showPartialSelection) {
        setAttribute("showPartialSelection", showPartialSelection, true);
    }

    /**
     * Should partially selected parents be shown with special icon?
     *
     * @return Current showPartialSelection value. Default value is false
     */
    public Boolean getShowPartialSelection()  {
        Boolean result = getAttributeAsBoolean("showPartialSelection");
        return result == null ? false : result;
    }
    

    /**
     * Specifies whether the root node should be displayed in the treeGrid. <P> This property is only available for "children"
     * modelType trees, hence is not allowed for trees that load data from the server dynamically via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#fetchData fetchData()}.   <P> To get the equivalent of a visible "root" node
     * in a tree that loads data dynamically, add a singular, top-level parent to the data.  However, note that this top-level
     * parent will technically be the only child of root, and the implicit root object will be returned by {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot this.data.getRoot()}.
     *
     * @param showRoot New showRoot value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRoot(Boolean showRoot)  throws IllegalStateException {
        setAttribute("showRoot", showRoot, false);
    }

    /**
     * Specifies whether the root node should be displayed in the treeGrid. <P> This property is only available for "children"
     * modelType trees, hence is not allowed for trees that load data from the server dynamically via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#fetchData fetchData()}.   <P> To get the equivalent of a visible "root" node
     * in a tree that loads data dynamically, add a singular, top-level parent to the data.  However, note that this top-level
     * parent will technically be the only child of root, and the implicit root object will be returned by {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot this.data.getRoot()}.
     *
     * @return Current showRoot value. Default value is false
     */
    public Boolean getShowRoot()  {
        Boolean result = getAttributeAsBoolean("showRoot");
        return result == null ? false : result;
    }
    

    /**
     * If true, show a different icon for selected nodes than unselected nodes. This is achieved by appending the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getSelectedIconSuffix selectedIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for selected records. <P> If appropriate, this suffix
     * will be combined with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} (see  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons}. So a treeGrid with its
     * <code>folderIcon</code> property set to <code>"[SKIN]/folder.gif"</code>, with both <code>showSelectedIcons</code> and
     * <code>showOpenIcons</code> set to true would show an icon with the URL <code>"[SKIN]/folder_open_selected.gif"</code>
     * for a folder that was both selected and opened.
     *
     * @param showSelectedIcons New showSelectedIcons value. Default value is false
     */
    public void setShowSelectedIcons(Boolean showSelectedIcons) {
        setAttribute("showSelectedIcons", showSelectedIcons, true);
    }

    /**
     * If true, show a different icon for selected nodes than unselected nodes. This is achieved by appending the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getSelectedIconSuffix selectedIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for selected records. <P> If appropriate, this suffix
     * will be combined with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} (see  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons}. So a treeGrid with its
     * <code>folderIcon</code> property set to <code>"[SKIN]/folder.gif"</code>, with both <code>showSelectedIcons</code> and
     * <code>showOpenIcons</code> set to true would show an icon with the URL <code>"[SKIN]/folder_open_selected.gif"</code>
     * for a folder that was both selected and opened.
     *
     * @return Current showSelectedIcons value. Default value is false
     */
    public Boolean getShowSelectedIcons()  {
        Boolean result = getAttributeAsBoolean("showSelectedIcons");
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener showOpener} is true, should a different opener icon be
     * displayed for selected nodes? This provides a way for developers to show a "selected" version of the opener icon set
     * which looks optimal with the  {@link com.smartgwt.client.docs.CellStyleSuffixes selected appearance} applied the
     * selected record. <P> The selected icon URL is created by appending the suffix  <code>"_selected"</code> to the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerImage openerImage} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}.
     *
     * @param showSelectedOpener New showSelectedOpener value. Default value is false
     */
    public void setShowSelectedOpener(Boolean showSelectedOpener) {
        setAttribute("showSelectedOpener", showSelectedOpener, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener showOpener} is true, should a different opener icon be
     * displayed for selected nodes? This provides a way for developers to show a "selected" version of the opener icon set
     * which looks optimal with the  {@link com.smartgwt.client.docs.CellStyleSuffixes selected appearance} applied the
     * selected record. <P> The selected icon URL is created by appending the suffix  <code>"_selected"</code> to the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenerImage openerImage} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}.
     *
     * @return Current showSelectedOpener value. Default value is false
     */
    public Boolean getShowSelectedOpener()  {
        Boolean result = getAttributeAsBoolean("showSelectedOpener");
        return result == null ? false : result;
    }
    

    /**
     * If specified, this attribute will override {@link com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves
     * Tree.sortFoldersBeforeLeaves} on the data for this treeGrid. <P> Specifies whether when {@link
     * com.smartgwt.client.widgets.tree.Tree#getSeparateFolders Tree.separateFolders} is true, folders should be displayed
     * before or after their sibling leaves in a sorted tree. If set to true, with sortDirection set to Array.ASCENDING,
     * folders are displayed before their sibling leaves and with sort direction set to Array.DESCENDING they are displayed
     * after. To invert this behavior, set this property to false.
     *
     * @param sortFoldersBeforeLeaves New sortFoldersBeforeLeaves value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setSeparateFolders
     */
    public void setSortFoldersBeforeLeaves(Boolean sortFoldersBeforeLeaves)  throws IllegalStateException {
        setAttribute("sortFoldersBeforeLeaves", sortFoldersBeforeLeaves, false);
    }

    /**
     * If specified, this attribute will override {@link com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves
     * Tree.sortFoldersBeforeLeaves} on the data for this treeGrid. <P> Specifies whether when {@link
     * com.smartgwt.client.widgets.tree.Tree#getSeparateFolders Tree.separateFolders} is true, folders should be displayed
     * before or after their sibling leaves in a sorted tree. If set to true, with sortDirection set to Array.ASCENDING,
     * folders are displayed before their sibling leaves and with sort direction set to Array.DESCENDING they are displayed
     * after. To invert this behavior, set this property to false.
     *
     * @return Current sortFoldersBeforeLeaves value. Default value is null
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getSeparateFolders
     */
    public Boolean getSortFoldersBeforeLeaves()  {
        return getAttributeAsBoolean("sortFoldersBeforeLeaves");
    }
    

    /**
     * Visible title for the tree column (field).
     *
     * @param treeFieldTitle New treeFieldTitle value. Default value is "Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTreeFieldTitle(String treeFieldTitle)  throws IllegalStateException {
        setAttribute("treeFieldTitle", treeFieldTitle, false);
    }

    /**
     * Visible title for the tree column (field).
     *
     * @return Current treeFieldTitle value. Default value is "Name"
     */
    public String getTreeFieldTitle()  {
        return getAttributeAsString("treeFieldTitle");
    }
    
    

    /**
     * If true, the set of fields given by the "default binding" (see  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields DataBoundComponent.fields}) is used, with any fields specified
     * in <code>component.fields</code> acting as overrides that can suppress or modify the display of individual fields,
     * without having to list the entire set of fields that should be shown. <P> If <code>component.fields</code> contains
     * fields that are not found in the DataSource, they will be shown after the most recently referred to DataSource field. 
     * If the new fields appear first, they will be shown first. <P> <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_customized_binding" target="examples">This
     * example</a> shows a mixture of component fields and DataSource fields, and how they interact for validation. <P> This
     * setting may be cleared if a {@link com.smartgwt.client.widgets.FieldPicker} is used to edit the component's field order.
     *
     * @param useAllDataSourceFields New useAllDataSourceFields value. Default value is null
     * @see com.smartgwt.client.widgets.FieldPicker#setDataBoundComponent
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_customized_binding" target="examples">Customized Binding Example</a>
     */
    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * If true, the set of fields given by the "default binding" (see  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields DataBoundComponent.fields}) is used, with any fields specified
     * in <code>component.fields</code> acting as overrides that can suppress or modify the display of individual fields,
     * without having to list the entire set of fields that should be shown. <P> If <code>component.fields</code> contains
     * fields that are not found in the DataSource, they will be shown after the most recently referred to DataSource field. 
     * If the new fields appear first, they will be shown first. <P> <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_customized_binding" target="examples">This
     * example</a> shows a mixture of component fields and DataSource fields, and how they interact for validation. <P> This
     * setting may be cleared if a {@link com.smartgwt.client.widgets.FieldPicker} is used to edit the component's field order.
     *
     * @return Current useAllDataSourceFields value. Default value is null
     * @see com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_customized_binding" target="examples">Customized Binding Example</a>
     */
    public Boolean getUseAllDataSourceFields()  {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }
    

    // ********************* Methods ***********************
	/**
     * Overridden to disallow editing of the {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} field of this
     * grid's data tree. Also disallows editing of the auto-generated tree field, which displays the result of {@link
     * com.smartgwt.client.widgets.tree.Tree#getTitle Tree.getTitle()} on the node.
     *
     * @return Whether to allow editing this cell
     */
    public native Boolean canEditCell() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "canEditCell", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.canEditCell();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Closes a folder.
     * @param node node to close
     * @see com.smartgwt.client.widgets.tree.TreeGrid#openFolder
     * @see com.smartgwt.client.widgets.tree.events.FolderClosedEvent
     */
    public native void closeFolder(TreeNode node) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFolder", "TreeNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a dataArrived handler.
     * <p>
     * Notification method fired whenever this TreeGrid receives new data nodes from the  dataSource. Only applies to databound
     * TreeGrids where {@link com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data} is a  {@link
     * com.smartgwt.client.widgets.tree.ResultTree} - either explicitly created and applied via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setData TreeGrid.setData()} or automatically generated via a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#fetchData fetchData()} call. <P> Note that <code>dataArrived()</code>, unlike
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#addDataChangedHandler TreeGrid.dataChanged()}, only fires in limited
     * circumstances - when data for a {@link com.smartgwt.client.widgets.tree.ResultTree} arrives from the server due to a
     * fetch or cache invalidation, or as a result of filtering.  If you want to catch all data changes, you should instead
     * react to {@link com.smartgwt.client.widgets.tree.TreeGrid#addDataChangedHandler TreeGrid.dataChanged()}.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.tree.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataArrived = $entry(function(){
            var param = {"_this": this, "parentNode" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tree.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownDataArrivedEvent()();
            if (hasDefaultHandler) this.Super("dataArrived", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataArrived"));
            obj.addProperties({dataArrived:  dataArrived              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataArrived"));
            obj.dataArrived =  dataArrived             ;
        }
    }-*/;

    private void handleTearDownDataArrivedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType()) == 0) tearDownDataArrivedEvent();
    }

    private native void tearDownDataArrivedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataArrived")) delete obj.dataArrived;
    }-*/;

    /**
     * Add a dataChanged handler.
     * <p>
     * Notification method fired when the TreeGrid's data changes, for any reason. <P> Examples of why data changed might
     * be:<ul> <li> a call to {@link com.smartgwt.client.widgets.grid.ListGrid#addData addData}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#updateData updateData}, or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#removeData removeData} <li> {@link com.smartgwt.client.data.DataSource}
     * updates from the server for {@link com.smartgwt.client.widgets.tree.ResultTree} data (triggered by record editing, etc.)
     * <li> fetches arriving back from the server for {@link com.smartgwt.client.widgets.tree.ResultTree} data <li>
     * programmatic changes to {@link com.smartgwt.client.widgets.tree.Tree} data if made through APIs such as {@link
     * com.smartgwt.client.widgets.tree.Tree#add Tree.add()}, {@link com.smartgwt.client.widgets.tree.Tree#remove
     * Tree.remove()}, etc. <li> cache invalidation <li> filtering </ul> Calling {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setData TreeGrid.setData()} doesn't call this notification directly, but it
     * may fire if one of the above listed events is triggered (e.g. a server fetch for  {@link
     * com.smartgwt.client.widgets.tree.ResultTree} data). <P> Note that the <code>operationType</code> parameter is optional
     * and will be passed and contain the operation (e.g. "update") if this notification was triggered by a fetch, an {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addData addData}, {@link com.smartgwt.client.widgets.grid.ListGrid#updateData
     * updateData}, or {@link com.smartgwt.client.widgets.grid.ListGrid#removeData removeData}, or a {@link
     * com.smartgwt.client.data.DataSource} update for {@link com.smartgwt.client.widgets.tree.ResultTree} data (the first
     * three reasons listed above) but otherwise will be null.
     *
     * @param handler the dataChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataChangedHandler(com.smartgwt.client.widgets.tree.events.DataChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.DataChangedEvent.getType()) == 0) setupDataChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.DataChangedEvent.getType());
    }

    private native void setupDataChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataChanged = $entry(function(){
            var param = {"_this": this, "operationType" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tree.events.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownDataChangedEvent()();
            if (hasDefaultHandler) this.Super("dataChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataChanged"));
            obj.addProperties({dataChanged:  dataChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataChanged"));
            obj.dataChanged =  dataChanged             ;
        }
    }-*/;

    private void handleTearDownDataChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.DataChangedEvent.getType()) == 0) tearDownDataChangedEvent();
    }

    private native void tearDownDataChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataChanged")) delete obj.dataChanged;
    }-*/;

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  See
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} for details of the
     * general  requirements and restrictions when exporting client data. <p> The following notes apply when exporting client
     * data from TreeGrids:<ul> <li>Export only works correctly if you specify {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}; if you allow it to     generate a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCreateDefaultTreeField default field}, nothing will be exported</li>
     * <li>Only visible nodes are exported; if you close a node, its children are not exported      even if they are loaded and
     * known to the client</li> <li>Tree nodes are exported as a flat list, in the same order they are displayed in the     
     * TreeGrid</li> </ul> <P> If your TreeGrid has custom formatters, formatted values will be exported by default, with HTML
     * normalized to text where possible.  Since some levels of HTML normalizing aren't  possible, this may result in missing
     * or incorrect export values.  In this case, you have  two possible approaches:<ul> <li>Set {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues exportRawValues} on the field.  This will export    
     * the raw underlying value of the field; your formatter will not be called</li> <li>Have your formatter call {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#isExportingClientData isExportingClientData()}     and perform whatever
     * alternative formatting you require if that method returns true</li> </ul>
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

    /**
     * @see TreeGrid#exportClientData
     */
    public void exportClientData(DSRequest requestProperties){
        exportClientData(requestProperties, null);
    }

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  See
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} for details of the
     * general  requirements and restrictions when exporting client data. <p> The following notes apply when exporting client
     * data from TreeGrids:<ul> <li>Export only works correctly if you specify {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}; if you allow it to     generate a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCreateDefaultTreeField default field}, nothing will be exported</li>
     * <li>Only visible nodes are exported; if you close a node, its children are not exported      even if they are loaded and
     * known to the client</li> <li>Tree nodes are exported as a flat list, in the same order they are displayed in the     
     * TreeGrid</li> </ul> <P> If your TreeGrid has custom formatters, formatted values will be exported by default, with HTML
     * normalized to text where possible.  Since some levels of HTML normalizing aren't  possible, this may result in missing
     * or incorrect export values.  In this case, you have  two possible approaches:<ul> <li>Set {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getExportRawValues exportRawValues} on the field.  This will export    
     * the raw underlying value of the field; your formatter will not be called</li> <li>Have your formatter call {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#isExportingClientData isExportingClientData()}     and perform whatever
     * alternative formatting you require if that method returns true</li> </ul>
     * @param requestProperties Request properties for the export.  Note that specifying {@link com.smartgwt.client.data.DSRequest#getExportData
     * exportData} on the request properties  allows the developer to pass in an explicit data set to export.
     * @param callback Optional callback.  If  you specify {@link com.smartgwt.client.data.DSRequest#getExportToClient exportToClient}: false
     * in the request  properties, this callback will fire after export completes.  Otherwise the callback will  fire right
     * before the download request is made to the server.
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(response, rawData, request) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
    }-*/;
	
    /**
     * Add a folderClick handler.
     * <p>
     * This method is called when a folder record is clicked on.
     *
     * @param handler the folderClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderClickHandler(com.smartgwt.client.widgets.tree.events.FolderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType()) == 0) setupFolderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType());
    }

    private native void setupFolderClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var folderClick = $entry(function(){
            var param = {"_this": this, "viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
            var event = @com.smartgwt.client.widgets.tree.events.FolderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownFolderClickEvent()();
            if (hasDefaultHandler) this.Super("folderClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("folderClick"));
            obj.addProperties({folderClick:  folderClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("folderClick"));
            obj.folderClick =  folderClick             ;
        }
    }-*/;

    private void handleTearDownFolderClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType()) == 0) tearDownFolderClickEvent();
    }

    private native void tearDownFolderClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("folderClick")) delete obj.folderClick;
    }-*/;

    /**
     * Add a folderClosed handler.
     * <p>
     * This method is called when a folder is closed either via the user manipulating the expand/collapse control in the UI or
     * via {@link com.smartgwt.client.widgets.tree.TreeGrid#closeFolder TreeGrid.closeFolder()}.  You can return
     * <code>false</code> to cancel the close.
     *
     * @param handler the folderClosed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderClosedHandler(com.smartgwt.client.widgets.tree.events.FolderClosedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType()) == 0) setupFolderClosedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType());
    }

    private native void setupFolderClosedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var folderClosed = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.FolderClosedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownFolderClosedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("folderClosed"));
            obj.addProperties({folderClosed: 
                function () {
                    var param = {"_this": this, "node" : arguments[0]};
                    var ret = folderClosed(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderClosed", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("folderClosed"));
            obj.folderClosed = 
                function () {
                    var param = {"_this": this, "node" : arguments[0]};
                    var ret = folderClosed(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderClosed", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownFolderClosedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType()) == 0) tearDownFolderClosedEvent();
    }

    private native void tearDownFolderClosedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("folderClosed")) delete obj.folderClosed;
    }-*/;

    /**
     * Add a folderContextClick handler.
     * <p>
     * This method is called when a context click occurs on a folder record.
     *
     * @param handler the folderContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderContextClickHandler(com.smartgwt.client.widgets.tree.events.FolderContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType()) == 0) setupFolderContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType());
    }

    private native void setupFolderContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var folderContextClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.FolderContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownFolderContextClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("folderContextClick"));
            obj.addProperties({folderContextClick: 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var ret = folderContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderContextClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("folderContextClick"));
            obj.folderContextClick = 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var ret = folderContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderContextClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownFolderContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType()) == 0) tearDownFolderContextClickEvent();
    }

    private native void tearDownFolderContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("folderContextClick")) delete obj.folderContextClick;
    }-*/;

    /**
     * Add a folderOpened handler.
     * <p>
     * This method is called when a folder is opened either via the user manipulating the expand/collapse control in the UI or
     * via {@link com.smartgwt.client.widgets.tree.TreeGrid#openFolder TreeGrid.openFolder()}.  You can return
     * <code>false</code> to cancel the open.
     *
     * @param handler the folderOpened handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderOpenedHandler(com.smartgwt.client.widgets.tree.events.FolderOpenedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType()) == 0) setupFolderOpenedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType());
    }

    private native void setupFolderOpenedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var folderOpened = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.FolderOpenedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownFolderOpenedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("folderOpened"));
            obj.addProperties({folderOpened: 
                function () {
                    var param = {"_this": this, "node" : arguments[0]};
                    var ret = folderOpened(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderOpened", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("folderOpened"));
            obj.folderOpened = 
                function () {
                    var param = {"_this": this, "node" : arguments[0]};
                    var ret = folderOpened(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("folderOpened", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownFolderOpenedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType()) == 0) tearDownFolderOpenedEvent();
    }

    private native void tearDownFolderOpenedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("folderOpened")) delete obj.folderOpened;
    }-*/;

	/**
     * Returns the row number of the most recent mouse event.
     *
     * @return row number, or -2 if beyond last drawn row
     */
    public native int getEventRow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventRow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventRow();
        return ret;
    }-*/;

	/**
     * Returns the row number of the most recent mouse event.
     * @param y optional y-coordinate to obtain row number, in lieu of the y                        coordinate of the last mouse event
     *
     * @return row number, or -2 if beyond last drawn row
     */
    public native int getEventRow(Integer y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventRow", "Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventRow(y == null ? null : y.@java.lang.Integer::intValue()());
        return ret;
    }-*/;
	
	/**
     * Get the appropriate open/close opener icon for a node. Returns null if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener showOpener} is set to false.
     * @param node tree node in question
     *
     * @return URL for the icon to show the node's open state.
     * See {@link com.smartgwt.client.docs.URL URL}
     */
    public native String getOpenIcon(TreeNode node) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getOpenIcon", "TreeNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getOpenIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns a snapshot of the current open state of this grid's data as a {@link com.smartgwt.client.docs.TreeGridOpenState}
     * object.<br> This object can be passed to {@link com.smartgwt.client.widgets.tree.TreeGrid#setOpenState setOpenState()}
     * to open the same set of folders within the treeGrid's data (assuming the nodes are still present in the data).
     *
     * @return current open state for the grid.
     * See {@link com.smartgwt.client.docs.TreeGridOpenState TreeGridOpenState}
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setOpenState
     */
    public native String getOpenState() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getOpenState", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getOpenState();
        return ret;
    }-*/;

	/**
     * Returns a snapshot of the current selection within this treeGrid as  a {@link
     * com.smartgwt.client.docs.ListGridSelectedState} object.<br> This object can be passed to {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setSelectedPaths setSelectedPaths()} to reset this grid's selection the
     * current state (assuming the same data is present in the grid).<br>
     *
     * @return current state of this grid's selection.
     * See {@link com.smartgwt.client.docs.ListGridSelectedState ListGridSelectedState}
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setSelectedPaths
     */
    public native String getSelectedPaths() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedPaths", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedPaths();
        return ret;
    }-*/;

	/**
     * Returns true if this component is currently  {@link com.smartgwt.client.widgets.tree.TreeGrid#exportClientData exporting
     * client data}.  This method can be called from custom cell formatters if you need to return a different formatted value
     * for an export than for a live TreeGrid
     *
     * @return returns true if this component is currently exporting client data
     * @see com.smartgwt.client.widgets.tree.TreeGrid#exportClientData
     */
    public native boolean isExportingClientData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isExportingClientData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isExportingClientData();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if the last event occurred over {@link com.smartgwt.client.widgets.tree.TreeGrid#getExtraIcon extra icon}
     * for the current node. <P> Returns false if the event did not occur over an extraIcon, or if no extraIcon is showing for
     * the node in question.
     *
     * @return true if the user clicked the extra icon
     */
    public native Boolean isOverExtraIcon() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOverExtraIcon", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isOverExtraIcon();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if the last event occurred over the indented area or over the open / close icon of a folder node in this
     * TreeGrid. Returns false if the event did not occur over a folder node.
     *
     * @return true if the user clicked the open icon
     */
    public native Boolean isOverOpenArea() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOverOpenArea", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isOverOpenArea();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Add a leafClick handler.
     * <p>
     * This method is called when a leaf record is clicked on.
     *
     * @param handler the leafClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addLeafClickHandler(com.smartgwt.client.widgets.tree.events.LeafClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType()) == 0) setupLeafClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType());
    }

    private native void setupLeafClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var leafClick = $entry(function(){
            var param = {"_this": this, "viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
            var event = @com.smartgwt.client.widgets.tree.events.LeafClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownLeafClickEvent()();
            if (hasDefaultHandler) this.Super("leafClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("leafClick"));
            obj.addProperties({leafClick:  leafClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("leafClick"));
            obj.leafClick =  leafClick             ;
        }
    }-*/;

    private void handleTearDownLeafClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType()) == 0) tearDownLeafClickEvent();
    }

    private native void tearDownLeafClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("leafClick")) delete obj.leafClick;
    }-*/;

    /**
     * Add a leafContextClick handler.
     * <p>
     * This method is called when a context click occurs on a leaf record.
     *
     * @param handler the leafContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addLeafContextClickHandler(com.smartgwt.client.widgets.tree.events.LeafContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType()) == 0) setupLeafContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType());
    }

    private native void setupLeafContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var leafContextClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.LeafContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownLeafContextClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("leafContextClick"));
            obj.addProperties({leafContextClick: 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var ret = leafContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("leafContextClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("leafContextClick"));
            obj.leafContextClick = 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var ret = leafContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("leafContextClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownLeafContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType()) == 0) tearDownLeafContextClickEvent();
    }

    private native void tearDownLeafContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("leafContextClick")) delete obj.leafContextClick;
    }-*/;

    /**
     * Add a nodeClick handler.
     * <p>
     * This method is called when a leaf or folder record is clicked on.  Note that if you set up a callback for
     * <code>nodeClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#addLeafClickHandler
     * TreeGrid.leafClick()}, then both will fire (in that order) if a leaf is clicked on.
     *
     * @param handler the nodeClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNodeClickHandler(com.smartgwt.client.widgets.tree.events.NodeClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType()) == 0) setupNodeClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType());
    }

    private native void setupNodeClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var nodeClick = $entry(function(){
            var param = {"_this": this, "viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
            var event = @com.smartgwt.client.widgets.tree.events.NodeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownNodeClickEvent()();
            if (hasDefaultHandler) this.Super("nodeClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("nodeClick"));
            obj.addProperties({nodeClick:  nodeClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("nodeClick"));
            obj.nodeClick =  nodeClick             ;
        }
    }-*/;

    private void handleTearDownNodeClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType()) == 0) tearDownNodeClickEvent();
    }

    private native void tearDownNodeClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("nodeClick")) delete obj.nodeClick;
    }-*/;

    /**
     * Add a nodeContextClick handler.
     * <p>
     * This method is called when a context click occurs on a leaf or folder record.  Note that if you set up a callback for
     * <code>nodeContextClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#addLeafContextClickHandler
     * TreeGrid.leafContextClick()}, then both will fire (in that order) if a leaf is contextclicked - unless
     * <code>nodeContextClick()</code> returns false, in which case no further contextClick callbacks will be called.
     *
     * @param handler the nodeContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNodeContextClickHandler(com.smartgwt.client.widgets.tree.events.NodeContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType()) == 0) setupNodeContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType());
    }

    private native void setupNodeContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var nodeContextClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.NodeContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownNodeContextClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("nodeContextClick"));
            obj.addProperties({nodeContextClick: 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var ret = nodeContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("nodeContextClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("nodeContextClick"));
            obj.nodeContextClick = 
                function () {
                    var param = {"_this": this, "viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var ret = nodeContextClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("nodeContextClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownNodeContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType()) == 0) tearDownNodeContextClickEvent();
    }

    private native void tearDownNodeContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("nodeContextClick")) delete obj.nodeContextClick;
    }-*/;

    /**
     * Add a folderDrop handler.
     * <p>
     * Process a drop of one or more nodes on a TreeGrid folder. <P> This method can be overridden to provide custom drop
     * behaviors and is a more appropriate override point than the lower level {@link com.smartgwt.client.widgets.Canvas#drop
     * Canvas.drop()} handler. <P> If this is a self-drop, nodes are simply reordered. An "update" operation will be submitted
     * to update the {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentId} field of the moved node(s).  <P>
     * For a drop from another widget, {@link com.smartgwt.client.widgets.tree.TreeGrid#transferDragData
     * TreeGrid.transferDragData()} is called which, depending on the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDragDataAction dragDataAction} specified on the source widget, may either
     * remove the source nodes from the original list (<code>dragDataAction:"move"</code>) or just provide a copy to this tree
     * (<code>dragDataAction:"copy"</code>). <P> In either case the new row(s) appear in the <code>folder</code> at the
     * <code>index</code> specified by the arguments of the same name. <P> If this grid is databound, the new nodes will be
     * added to the dataset by calling {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()}.  Further, if
     * the new nodes were dragged from another databound component, and {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDropValues getDropValues} will be called for every item being dropped.
     * <P> As a special case, if the <code>sourceWidget</code> is also databound and a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} relationship is declared from the
     * <code>sourceWidget</code>'s DataSource to this TreeGrid's DataSource, the interaction will be treated as a "drag
     * recategorization" use case such as files being placed in folders, employees being assigned to teams, etc.  "update"
     * DSRequests will be submitted that change the foreignKey field in the dropped records to point to the tree folder that
     * was the target of the drop.  In this case no change will be made to the Tree data as such, only to the dropped records. 
     * <P> For multi-record drops, Queuing is automatically used to combine all DSRequests into a single HTTP Request (see
     * QuickStart Guide, Server Framework chapter).  This allows the server to persist all changes caused by the drop in a
     * single transaction (and this is automatically done when using the built-in server DataSources with Power Edition and
     * above). <P> If these default persistence behaviors are undesirable, Call {@link
     * com.smartgwt.client.widgets.tree.events.FolderDropEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.tree.events.FolderDropHandler#onFolderDrop} to cancel them, then and implement your own
     * behavior, typically by using grid.updateData() or addData() to add new records. <p><b>NOTE:</b> the records you receive
     * in this event are the actual Records from the source component.  Use {@link
     * com.smartgwt.client.data.DataSource#copyRecords DataSource.copyRecords()} to create a copy before modifying the records
     * or using them with updateData() or addData().
     *
     * @param handler the folderDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderDropHandler(com.smartgwt.client.widgets.tree.events.FolderDropHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderDropEvent.getType()) == 0) setupFolderDropEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderDropEvent.getType());
    }

    private native void setupFolderDropEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onFolderDrop = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tree.events.FolderDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tree.TreeGrid::handleTearDownFolderDropEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onFolderDrop"));
            obj.addProperties({onFolderDrop: 
                function () {
                    var param = {"_this": this, "nodes" : arguments[0], "folder" : arguments[1], "index" : arguments[2], "dropPosition" : arguments[3], "sourceWidget" : arguments[4]};
                    var ret = onFolderDrop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onFolderDrop", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onFolderDrop"));
            obj.onFolderDrop = 
                function () {
                    var param = {"_this": this, "nodes" : arguments[0], "folder" : arguments[1], "index" : arguments[2], "dropPosition" : arguments[3], "sourceWidget" : arguments[4]};
                    var ret = onFolderDrop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onFolderDrop", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownFolderDropEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderDropEvent.getType()) == 0) tearDownFolderDropEvent();
    }

    private native void tearDownFolderDropEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onFolderDrop")) delete obj.onFolderDrop;
    }-*/;

	/**
     * Opens a folder. <p> Executed when a folder node receives a 'doubleClick' event.  <p> See the ListGrid Widget Class for
     * inherited recordClick and recordDoubleClick events.
     * @param node node to open
     * @see com.smartgwt.client.widgets.tree.TreeGrid#closeFolder
     * @see com.smartgwt.client.widgets.tree.events.FolderOpenedEvent
     * @see com.smartgwt.client.widgets.grid.ListGrid
     */
    public native void openFolder(TreeNode node) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openFolder", "TreeNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.openFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Handle a doubleClick on a tree node - override of ListGrid stringMethod of same name.  If the node is a folder, this
     * implementation calls {@link com.smartgwt.client.widgets.tree.TreeGrid#toggleFolder toggleFolder()} on it.  If the node
     * is a leaf, calls {@link com.smartgwt.client.widgets.tree.TreeGrid#openLeaf openLeaf()} on it.
     * @see com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent
     */
    public native void recordDoubleClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "recordDoubleClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.recordDoubleClick();
    }-*/;

	/**
     * Reset this set of open folders within this grid's data to match the  {@link com.smartgwt.client.docs.TreeGridOpenState}
     * object passed in.<br> Used to restore previous state retrieved from the grid by a call to  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getOpenState getOpenState()}.
     * @param openState Object describing the desired set of open folders.
     * See {@link com.smartgwt.client.docs.TreeGridOpenState TreeGridOpenState}
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getOpenState
     * @see com.smartgwt.client.docs.TreeGridOpenState TreeGridOpenState
     */
    public native void setOpenState(String openState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setOpenState", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setOpenState(openState);
    }-*/;

	/**
     * Reset this grid's selection to match the {@link com.smartgwt.client.docs.ListGridSelectedState} object passed in.<br>
     * Used to restore previous state retrieved from the grid by a call to  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getSelectedPaths getSelectedPaths()}.
     * @param selectedPaths Object describing the desired selection state of                                              the grid.
     * See {@link com.smartgwt.client.docs.ListGridSelectedState ListGridSelectedState}
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getSelectedPaths
     * @see com.smartgwt.client.docs.ListGridSelectedState ListGridSelectedState
     */
    public native void setSelectedPaths(String selectedPaths) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSelectedPaths", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSelectedPaths(selectedPaths);
    }-*/;

	/**
     * Opens the folder specified by node if it's closed, and closes it if it's open. TreeGrid will redraw if there's a change
     * in the folder's open/closed state.
     * @param node node to toggle
     */
    public native void toggleFolder(TreeNode node) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "toggleFolder", "TreeNode");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.toggleFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Transfer a list of {@link com.smartgwt.client.widgets.tree.TreeNode}s from another component (does not have to be a
     * databound component) into this component.  This method is only applicable to list-type components, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid listGrid}, {@link com.smartgwt.client.widgets.tree.TreeGrid treeGrid} or
     * {@link com.smartgwt.client.widgets.tile.TileGrid tileGrid}. <P> This method implements the automatic drag-copy and
     * drag-move behavior and calling it is equivalent to completing a drag and drop of the <code>nodes</code>. <P> Note that
     * this method is asynchronous - it may need to perform server turnarounds to prevent duplicates in the target component's
     * data.  If you wish to be notified when the transfer process has completed, you can either pass the optional callback to
     * this method or implement the {@link com.smartgwt.client.widgets.DataBoundComponent#dropComplete
     * DataBoundComponent.dropComplete()} method on this component. <P> See also {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#transferSelectedData transferSelectedData()}.
     * @param nodes Nodes to transfer to this component
     * @param folder The target folder (eg, of a drop interaction), for context
     * @param index Insert point within the target folder data for the transferred nodes
     * @param sourceWidget The databound or non-databound component from which the nodes                              are to be transferred.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public native void transferNodes(TreeNode[] nodes, TreeNode folder, Integer index, Canvas sourceWidget) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "transferNodes", "TreeNode[],TreeNode,Integer,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), folder.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Transfer a list of {@link com.smartgwt.client.widgets.tree.TreeNode}s from another component (does not have to be a
     * databound component) into this component.  This method is only applicable to list-type components, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid listGrid}, {@link com.smartgwt.client.widgets.tree.TreeGrid treeGrid} or
     * {@link com.smartgwt.client.widgets.tile.TileGrid tileGrid}. <P> This method implements the automatic drag-copy and
     * drag-move behavior and calling it is equivalent to completing a drag and drop of the <code>nodes</code>. <P> Note that
     * this method is asynchronous - it may need to perform server turnarounds to prevent duplicates in the target component's
     * data.  If you wish to be notified when the transfer process has completed, you can either pass the optional callback to
     * this method or implement the {@link com.smartgwt.client.widgets.DataBoundComponent#dropComplete
     * DataBoundComponent.dropComplete()} method on this component. <P> See also {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#transferSelectedData transferSelectedData()}.
     * @param nodes Nodes to transfer to this component
     * @param folder The target folder (eg, of a drop interaction), for context
     * @param index Insert point within the target folder data for the transferred nodes
     * @param sourceWidget The databound or non-databound component from which the nodes                              are to be transferred.
     * @param callback optional callback to be fired when the transfer process has                       completed.  The callback will be
     * passed a single parameter "records",                       the list of nodes actually transferred to this component (it
     * is called                       "records" because this is logic shared with {@link
     * com.smartgwt.client.widgets.grid.ListGrid}).
     * See {@link com.smartgwt.client.docs.Callback Callback}
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public native void transferNodes(TreeNode[] nodes, TreeNode folder, Integer index, Canvas sourceWidget, String callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "transferNodes", "TreeNode[],TreeNode,Integer,Canvas,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), folder.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), callback);
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
     * @param treeGridProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TreeGrid treeGridProperties) /*-{
        if (treeGridProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TreeGrid.@java.lang.Object::getClass()(), "setDefaultProperties", treeGridProperties.@java.lang.Object::getClass()());
        }
        treeGridProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = treeGridProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TreeGrid.addProperties(properties);
    }-*/;

    // ***********************************************************


    protected void onInit() {
        super.onInit();
        onInit_TreeGrid();
    }

    private native void onInit_TreeGrid() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getNodeTitle = self.getNodeTitle;
        self.getNodeTitle = $debox($entry(function(node, recordNum, field) {
            var jObj = this.__ref;
            var nodeJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            return jObj.@com.smartgwt.client.widgets.tree.TreeGrid::getNodeTitle(Lcom/smartgwt/client/data/Record;ILcom/smartgwt/client/widgets/grid/ListGridField;)(nodeJ, recordNum, fieldJ);
        }));

        self._getIcon = self.getIcon;
        self.getIcon = $debox($entry(function(node, defaultState) {
            defaultState = !!defaultState;
            if ($wnd.isc.isA.Number(node)) node = this.data.get(node);
            var jObj = this.__ref;
            var nodeJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return jObj.@com.smartgwt.client.widgets.tree.TreeGrid::getIcon(Lcom/smartgwt/client/data/Record;Z)(nodeJ, defaultState);
        }));

        self._getExtraIcon = self.getExtraIcon;
        self.getExtraIcon = $debox($entry(function(node) {
            if ($wnd.isc.isA.Number(node)) node = this.data.get(node);
            var jObj = this.__ref;
            var nodeJ = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return jObj.@com.smartgwt.client.widgets.tree.TreeGrid::getExtraIcon(Lcom/smartgwt/client/widgets/tree/TreeNode;)(nodeJ);
        }));
    }-*/;

    /**
     * This inherited {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid API} is not supported by the
     * TreeGrid since adding a new tree node arbitrarily at the end of the tree is usually not useful. Instead, to add a new
     * tree node and begin editing it, use either of these two strategies: <ol> <li> add a new node to the client-side Tree
     * model via {@link com.smartgwt.client.widgets.tree.Tree#add Tree.add}, then use {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getStartEditing startEditing} to begin editing this node.  Note that if using
     * a DataSource, when the node is saved, an "update" operation will be used since adding a node directly to the client-side
     * {@link com.smartgwt.client.widgets.tree.ResultTree} effectively means a new node has been added server side. <li> use
     * {@link com.smartgwt.client.data.DataSource#addData DataSource.addData} to immediately save a new node.  Automatic cache
     * sync by the {@link com.smartgwt.client.widgets.tree.ResultTree} will cause the node to be integrated into the tree.
     * When the callback to addData() fires, locate the new node by matching primary key and call {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getStartEditing startEditing} to begin editing it. </ol>
     */
    public native void startEditingNew() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.startEditingNew();
    }-*/;

    /**
     * &#010 Returns the title to show for a node in the tree column.  If the field specifies the&#010 <code>name</code> attribute, then the current <code>node[field.name]</code> is returned.&#010 Otherwise, the result of calling {@link com.smartgwt.client.widgets.tree.Tree#getTitle} on the node is called.&#010 <br><br>&#010 You can override this method to return a custom title for node titles in the tree column.&#010&#010
     *
     * <b>Note</b> : This is an override point
     *
     * @param node      The node for which the title is being requested.
     * @param recordNum The index of the node.
     * @param field     The field for which the title is being requested.
     * @return the title to display.
     */
    protected native String getNodeTitle(Record node, int recordNum, ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var title = self._getNodeTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, field.@com.smartgwt.client.core.DataClass::getJsObj()());
            return title == null ? "" : title.toString();
    }-*/;

    /**
     * Get the appropriate icon for a node.&#010 <P>&#010 By default icons are derived from {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon}.&#010 Custom icons for individual nodes can be overridden by setting the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}&#010 on a node.&#010 <p>&#010 If you want to suppress icons altogether, provide an override of this method that simply&#010 returns null.&#010 <p> &#010 Note that the full icon URL will be derived by applying {@link com.smartgwt.client.widgets.Canvas#getImgURL} to the&#010 value returned from this method.&#010&#010
     * <p>
     * <b>Note</b>: This is an override point
     *
     * @param node tree node in question
     * @param defaultState defaultState
     *
     * @return URL for icon to show for this node
     */
    protected native String getIcon(Record node, boolean defaultState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()(), defaultState);
    }-*/;

    /**
     * Set the icon for a particular TreeNode to a specified URL
     * @param node the tree node
     * @param icon path to the resource
     */
    public native void setCustomNodeIcon(Record node, String icon) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setNodeIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()(), icon);
    }-*/;


    /**
     * Get an additional icon to show between the open icon and folder/node icon for a particular  node. <P> NOTE: If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is <code>"checkbox"</code>, this
     * method will NOT be called. Extra icons cannot be shown for that appearance.
     * <p>
     * <b>Note</b>: This is an override point
     * @param node tree node in question
     *
     * @return URL for the extra icon (null if none required). See {@link com.smartgwt.client.docs.TreeNode TreeNode}
     */
    public native String getExtraIcon(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getExtraIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;




    /**
     * When the user is dragging a droppable element over this grid, this method returns the folder&#010 which would contain the item if dropped. This is the current drop node if the user is hovering&#010 over a folder, or the node's parent if the user is hovering over a leaf.&#010
     *
     * @return target drop folder
     */
    public native TreeNode getDropFolder() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var node = self.getDropFolder();
        if(node == null || node === undefined) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
    }-*/;

    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested {@link
     * com.smartgwt.client.widgets.tree.TreeNode}s to  display as rows in this TreeGrid.   The <code>data</code> property will
     * typically not be explicitly specified for  databound TreeGrids, where the data is returned from the server via databound
     * component methods such as <code>fetchData()</code>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.tree.Tree} object this TreeGrid will view and manipulate.
     *
     * @param data Tree to show. Default value is null
     */
    public void setData(Tree data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested {@link
     * com.smartgwt.client.widgets.tree.TreeNode}s to  display as rows in this TreeGrid.   The <code>data</code> property will
     * typically not be explicitly specified for  databound TreeGrids, where the data is returned from the server via databound
     * component methods such as <code>fetchData()</code>
     *
     *
     * @return Tree
     */
    public Tree getData()  {
        JavaScriptObject jso = getAttributeAsJavaScriptObject("data");
        if (JSOHelper.isScClassInstance(jso) &&
            "ResultTree".equals(JSOHelper.getClassName(jso)))
        {
            return ResultTree.getOrCreateRef(jso);
        }
        return Tree.getOrCreateRef(jso);
    }

    /**
     * Synonym for {@link #getData()}
     *
     * @return the underlying tree
     */
    public Tree getTree() {
        return getData();
    }

    /**
     * For databound TreeGrids, this attribute can be used to customize the 
     * {@link com.smartgwt.client.tree.ResultTree} object created for this grid when data is
     * fetched.
     * <p><b>Note : </b>This is an advanced setting</p>
     * Class overrides for {@link com.smartgwt.client.widgets.tree.ResultTree} cannot be applied
     * to the grid using this API.  Instead, consider setting the 
     * {@link com.smartgwt.client.data.DataSource#setResultTreeClass resultTreeClass} property
     * in the file defining your {@link com.smartgwt.client.data.DataSource}.  Your class must
     * be {@link com.smartgwt.client.docs.Reflection registered for reflection}.
     *
     * @param resultTreeProperties the data properties
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataProperties(Tree resultTreeProperties) {
        if (resultTreeProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setDataProperties", "Tree");
        }                                                                       
        resultTreeProperties.setConfigOnly(true);

        JavaScriptObject config = resultTreeProperties.getConfig();
        setAttribute("dataProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Return the tree nodes as a flat array of ListGridRecords. Internally this method retrieves all the nodes via
     * {@link Tree#getOpenList(TreeNode)}. You should favor working with the underlying {@link #getTree() Tree} data
     * structure when working with a TreeGrid.
     *
     * @return the tree nodes as ListGridRecord's
     */
    public ListGridRecord[] getRecords() {
        Tree tree = getData();
        if(isCreated()){
            TreeNode root = tree.getRoot();
            if(root == null) {
                return null;
            } else {
                return tree.getOpenList(tree.getRoot());
            }
        } else {
            return tree.getData();
        }
    }

    /**
     * You can specify the initial set of data for a databound TreeGrid using this property. The value of this attribute should
     * be a list of <code>parentId</code>-linked {@link com.smartgwt.client.widgets.tree.TreeNode}s in a format equivalent to
     * that documented on {@link com.smartgwt.client.widgets.tree.Tree#getData Tree.data} or, for TreeGrids with {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDataFetchMode dataFetchMode} set to {@link
     * com.smartgwt.client.types.FetchMode "paged"}, on {@link com.smartgwt.client.widgets.tree.ResultTree#getData
     * ResultTree.data}. <P> If you create a standalone {@link com.smartgwt.client.widgets.tree.Tree} or {@link
     * com.smartgwt.client.widgets.tree.ResultTree} as the TreeGrid's {@link com.smartgwt.client.widgets.tree.TreeGrid#getData
     * data} then you may equivalently specify this initial set of tree nodes in that tree's {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param initialData New initialData value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tree.TreeNode
     * @see com.smartgwt.client.widgets.tree.Tree#setData
     * @see com.smartgwt.client.widgets.tree.ResultTree#setData
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand" target="examples">Initial Data & Load on Demand Example</a>
     */
    public void setInitialData(TreeNode[] initialData) throws IllegalStateException {
        setAttribute("initialData", initialData, false);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client.data.ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client.data.ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client.data.ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client.data.ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client.data.ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client.data.ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client.data.ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client.data.ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client.data.ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client.data.ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client.data.ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client.data.ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client.data.ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client.data.ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client.data.ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client.data.ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required; see                                          {@link
     *                 com.smartgwt.client.widgets.DataBoundComponent#fetchData} for details
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link com.smartgwt.client.widgets.DataBoundComponent#fetchData} for details
     * @param requestProperties for databound components only - optional                            additional
     *                          properties to set on the DSRequest that will be issued
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Return the first selected record in this component.<br><br> This method is appropriate if <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is <code>"single"</code>, or if you only care about the first selected record in a multiple-record selection. To access all selected records, use <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection}</code> instead.
     *
     * @return first selected record, or null if nothing selected
     */
    public native TreeNode getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return the pointer to a particular record by record number. Synonym for {@link com.smartgwt.client.widgets.grid.ListGrid#getCellRecord}.
     * @param recordNum row index of record to return.
     *
     * @return Record object for the row.
     */
    public native TreeNode getRecord(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(recordNum);
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * For databound trees, use this attribute to supply a {@link com.smartgwt.client.data.DataSourceField#getRootValue
     * DataSourceField.rootValue} for this component's generated data object. <P>  This property allows you to have a
     * particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue New treeRootValue value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setTreeRootValue(String treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a {@link com.smartgwt.client.data.DataSourceField#getRootValue
     * DataSourceField.rootValue} for this component's generated data object. <P>  This property allows you to have a
     * particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue New treeRootValue value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setTreeRootValue(Integer treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a {@link com.smartgwt.client.data.DataSourceField#getRootValue
     * DataSourceField.rootValue} for this component's generated data object. <P>  This property allows you to have a
     * particular component navigate a tree starting from any given node as the root.
     *
     * @return Current treeRootValue value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getTreeRootValue() {
        return getAttribute("treeRootValue");
    }

    /**
     * Return the horizontal alignment for cell contents. Default implementation will always left-align the special {@link
     * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField} [or right-align if the page is in RTL mode] -
     * otherwise will return {@link com.smartgwt.client.widgets.grid.ListGridField#getCellAlign cellAlign} if specified,
     * otherwise {@link com.smartgwt.client.widgets.grid.ListGridField#getAlign align}.
     * @param record this cell's record
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     *
     * @return Horizontal alignment of cell contents: 'right', 'center', or 'left'
     */
    public native Alignment getCellAlign(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var ret = self.getCellAlign(recordJS, rowNum, colNum);
        if(ret == null) return null;
        var enumValues = @com.smartgwt.client.types.Alignment::values()();
        return @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(enumValues, ret);
    }-*/;

    @Override
    public native void setCellValueHoverFormatter(CellValueHoverFormatter formatter) /*-{
        var self;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        var newCellValueHoverHTMLFun;
        if (formatter == null) {
            newCellValueHoverHTMLFun = $wnd.isc[this.@com.smartgwt.client.widgets.BaseWidget::scClassName].getInstanceProperty("cellValueHoverHTML");
        } else {
            newCellValueHoverHTMLFun = $entry(function (record, rowNum, colNum, defaultHTML) {
                var nodeJ = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                return formatter.@com.smartgwt.client.widgets.grid.CellValueHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/grid/ListGridRecord;IILjava/lang/String;)(nodeJ, rowNum, colNum, defaultHTML);
            });
        }
        self.cellValueHoverHTML = newCellValueHoverHTMLFun;
    }-*/;

    /**
     * This method overrides {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} and works as follows: <br><br>
     * First, {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} (the superclass definition) is consulted.  If it
     * returns false, then this method returns false immediately.<br> This handles the following cases:<br> - reordering of
     * records within this TreeGrid when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords
     * canReorderRecords} is true<br> - accepting dropped records from another dragTarget when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords}    is true and the
     * dragTarget gives us a valid set of records to drop into place.<br> - disallowing drop over disabled nodes, or nodes with
     * <code>canAcceptDrop:false</code> <br> This method will also return false if the drop occurred over a leaf node whose
     * immediate  parent has <code>canAcceptDrop</code> set to <code>false</code><br> If {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is true, and the user is dragging a node
     * from one folder to another, this method will return true to allow the change of parent folder.<br> <br><br> Otherwise
     * this method returns true.
     * <b>  Note: </b> This is an override point.
     *
     * @return true if this component will accept a drop of the dragData
     */
    public Boolean willAcceptDrop() {
    	return super.willAcceptDrop();
    }

    /**
     * This ListGrid superclass event does not fire on a TreeGrid, use {@link #addFolderDropHandler(com.smartgwt.client.widgets.tree.events.FolderDropHandler)} instead.
     *
     * @param handler the onRecordDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     *
     * @throws UnsupportedOperationException
     */
    public HandlerRegistration addRecordDropHandler(com.smartgwt.client.widgets.grid.events.RecordDropHandler handler) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This event inherited from ListGrid does not fire for a TreeGrid. Use TreeGrid.addFolderDropHandler instead.");
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TreeGridLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alwaysShowOpener = getAttributeAsString("alwaysShowOpener");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.alwaysShowOpener:" + t.getMessage() + "\n";
        }
        try {
            s.animateFolderEffect = getAttributeAsString("animateFolderEffect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.animateFolderEffect:" + t.getMessage() + "\n";
        }
        try {
            s.animateFolderMaxRows = getAttributeAsString("animateFolderMaxRows");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.animateFolderMaxRows:" + t.getMessage() + "\n";
        }
        try {
            s.animateFolders = getAttributeAsString("animateFolders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.animateFolders:" + t.getMessage() + "\n";
        }
        try {
            s.animateFolderSpeed = getAttributeAsString("animateFolderSpeed");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.animateFolderSpeed:" + t.getMessage() + "\n";
        }
        try {
            s.animateFolderTime = getAttributeAsString("animateFolderTime");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.animateFolderTime:" + t.getMessage() + "\n";
        }
        try {
            s.autoFetchTextMatchStyle = getAttributeAsString("autoFetchTextMatchStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.autoFetchTextMatchStyle:" + t.getMessage() + "\n";
        }
        try {
            s.autoPreserveOpenState = getAttributeAsString("autoPreserveOpenState");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.autoPreserveOpenState:" + t.getMessage() + "\n";
        }
        try {
            s.canAcceptDroppedRecords = getAttributeAsString("canAcceptDroppedRecords");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canAcceptDroppedRecords:" + t.getMessage() + "\n";
        }
        try {
            s.canDragRecordsOut = getAttributeAsString("canDragRecordsOut");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canDragRecordsOut:" + t.getMessage() + "\n";
        }
        try {
            s.canDropOnLeaves = getAttributeAsString("canDropOnLeaves");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canDropOnLeaves:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderRecords = getAttributeAsString("canReorderRecords");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canReorderRecords:" + t.getMessage() + "\n";
        }
        try {
            s.canReparentNodes = getAttributeAsString("canReparentNodes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canReparentNodes:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectAll = getAttributeAsString("canSelectAll");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.canSelectAll:" + t.getMessage() + "\n";
        }
        try {
            s.cantDragIntoChildMessage = getAttributeAsString("cantDragIntoChildMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.cantDragIntoChildMessage:" + t.getMessage() + "\n";
        }
        try {
            s.cantDragIntoSelfMessage = getAttributeAsString("cantDragIntoSelfMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.cantDragIntoSelfMessage:" + t.getMessage() + "\n";
        }
        try {
            s.cascadeSelection = getAttributeAsString("cascadeSelection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.cascadeSelection:" + t.getMessage() + "\n";
        }
        try {
            s.closedIconSuffix = getAttributeAsString("closedIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.closedIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.connectorImage = getAttributeAsString("connectorImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.connectorImage:" + t.getMessage() + "\n";
        }
        try {
            s.createDefaultTreeField = getAttributeAsString("createDefaultTreeField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.createDefaultTreeField:" + t.getMessage() + "\n";
        }
        try {
            s.customIconDropProperty = getAttributeAsString("customIconDropProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.customIconDropProperty:" + t.getMessage() + "\n";
        }
        try {
            s.customIconOpenProperty = getAttributeAsString("customIconOpenProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.customIconOpenProperty:" + t.getMessage() + "\n";
        }
        try {
            s.customIconProperty = getAttributeAsString("customIconProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.customIconProperty:" + t.getMessage() + "\n";
        }
        try {
            s.customIconSelectedProperty = getAttributeAsString("customIconSelectedProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.customIconSelectedProperty:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.dataProperties = getDataProperties();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.dataProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsDataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.dataSourceAsDataSource:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsString = getAttributeAsString("dataSource");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.dataSourceAsString:" + t.getMessage() + "\n";
        }
        try {
            s.displayNodeType = getAttributeAsString("displayNodeType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.displayNodeType:" + t.getMessage() + "\n";
        }
        try {
            s.dropIconSuffix = getAttributeAsString("dropIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.dropIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.extraIconGap = getAttributeAsString("extraIconGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.extraIconGap:" + t.getMessage() + "\n";
        }
        try {
            s.folderIcon = getAttributeAsString("folderIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.folderIcon:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.indentRecordComponents = getAttributeAsString("indentRecordComponents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.indentRecordComponents:" + t.getMessage() + "\n";
        }
        try {
            s.indentSize = getAttributeAsString("indentSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.indentSize:" + t.getMessage() + "\n";
        }
        try {
            s.keepParentsOnFilter = getAttributeAsString("keepParentsOnFilter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.keepParentsOnFilter:" + t.getMessage() + "\n";
        }
        try {
            s.leaveSelectionCheckboxGap = getAttributeAsString("leaveSelectionCheckboxGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.leaveSelectionCheckboxGap:" + t.getMessage() + "\n";
        }
        try {
            s.loadDataOnDemand = getAttributeAsString("loadDataOnDemand");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.loadDataOnDemand:" + t.getMessage() + "\n";
        }
        try {
            s.loadingIcon = getAttributeAsString("loadingIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.loadingIcon:" + t.getMessage() + "\n";
        }
        try {
            s.manyItemsImage = getAttributeAsString("manyItemsImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.manyItemsImage:" + t.getMessage() + "\n";
        }
        try {
            s.nodeIcon = getAttributeAsString("nodeIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.nodeIcon:" + t.getMessage() + "\n";
        }
        try {
            s.offlineNodeMessage = getAttributeAsString("offlineNodeMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.offlineNodeMessage:" + t.getMessage() + "\n";
        }
        try {
            s.openerIconHeight = getAttributeAsString("openerIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.openerIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.openerIconSize = getAttributeAsString("openerIconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.openerIconSize:" + t.getMessage() + "\n";
        }
        try {
            s.openerIconWidth = getAttributeAsString("openerIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.openerIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.openerImage = getAttributeAsString("openerImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.openerImage:" + t.getMessage() + "\n";
        }
        try {
            s.openIconSuffix = getAttributeAsString("openIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.openIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.parentAlreadyContainsChildMessage = getAttributeAsString("parentAlreadyContainsChildMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.parentAlreadyContainsChildMessage:" + t.getMessage() + "\n";
        }
        try {
            s.recordDropAppearance = getAttributeAsString("recordDropAppearance");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.recordDropAppearance:" + t.getMessage() + "\n";
        }
        try {
            s.selectedIconSuffix = getAttributeAsString("selectedIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.selectedIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.selectionProperty = getAttributeAsString("selectionProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.selectionProperty:" + t.getMessage() + "\n";
        }
        try {
            s.separateFolders = getAttributeAsString("separateFolders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.separateFolders:" + t.getMessage() + "\n";
        }
        try {
            s.serverFilterFields = getAttributeAsStringArray("serverFilterFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.serverFilterFieldsArray:" + t.getMessage() + "\n";
        }
        try {
            s.showConnectors = getAttributeAsString("showConnectors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showConnectors:" + t.getMessage() + "\n";
        }
        try {
            s.showCustomIconDrop = getAttributeAsString("showCustomIconDrop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showCustomIconDrop:" + t.getMessage() + "\n";
        }
        try {
            s.showCustomIconOpen = getAttributeAsString("showCustomIconOpen");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showCustomIconOpen:" + t.getMessage() + "\n";
        }
        try {
            s.showCustomIconSelected = getAttributeAsString("showCustomIconSelected");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showCustomIconSelected:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabledSelectionCheckbox = getAttributeAsString("showDisabledSelectionCheckbox");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showDisabledSelectionCheckbox:" + t.getMessage() + "\n";
        }
        try {
            s.showDropIcons = getAttributeAsString("showDropIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showDropIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showFullConnectors = getAttributeAsString("showFullConnectors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showFullConnectors:" + t.getMessage() + "\n";
        }
        try {
            s.showLoadingIcons = getAttributeAsString("showLoadingIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showLoadingIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showOpener = getAttributeAsString("showOpener");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showOpener:" + t.getMessage() + "\n";
        }
        try {
            s.showOpenIcons = getAttributeAsString("showOpenIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showOpenIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showPartialSelection = getAttributeAsString("showPartialSelection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showPartialSelection:" + t.getMessage() + "\n";
        }
        try {
            s.showRoot = getAttributeAsString("showRoot");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showRoot:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedIcons = getAttributeAsString("showSelectedIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showSelectedIcons:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedOpener = getAttributeAsString("showSelectedOpener");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.showSelectedOpener:" + t.getMessage() + "\n";
        }
        try {
            s.sortFoldersBeforeLeaves = getAttributeAsString("sortFoldersBeforeLeaves");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.sortFoldersBeforeLeaves:" + t.getMessage() + "\n";
        }
        try {
            s.treeFieldTitle = getAttributeAsString("treeFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.treeFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.treeRootValue = getAttributeAsString("treeRootValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.treeRootValue:" + t.getMessage() + "\n";
        }
        try {
            s.useAllDataSourceFields = getAttributeAsString("useAllDataSourceFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TreeGrid.useAllDataSourceFields:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TreeGridLogicalStructure s = new TreeGridLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
