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
 * ResultTrees are an implementation of the {@link com.smartgwt.client.widgets.tree.Tree} API, used to handle hierarchical
 * data, whose nodes are DataSource records which are retrieved from a server.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ResultTree")
public class ResultTree extends Tree {

    public static ResultTree getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (ResultTree) obj;
        } else {
            return new ResultTree(jsObj);
        }
    }


    public ResultTree(){
        scClassName = "ResultTree";
    }

    public ResultTree(JavaScriptObject jsObj){
        scClassName = "ResultTree";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Controls what happens to the {@link com.smartgwt.client.widgets.tree.ResultTree#getOpenState "open state"} - the set of 
     * nodes opened or closed by the end user after tree data is loaded - when an entirely new tree of nodes is loaded from the
     * server, as a consequence of calling  {@link com.smartgwt.client.widgets.tree.ResultTree#invalidateCache
     * ResultTree.invalidateCache} or of changing criteria such that the current cache of nodes is dropped.
     *
     * @param autoPreserveOpenState  Default value is "whenUnique"
     */
    public void setAutoPreserveOpenState(PreserveOpenState autoPreserveOpenState) {
        setAttribute("autoPreserveOpenState", autoPreserveOpenState == null ? null : autoPreserveOpenState.getValue(), true);
    }

    /**
     * Controls what happens to the {@link com.smartgwt.client.widgets.tree.ResultTree#getOpenState "open state"} - the set of 
     * nodes opened or closed by the end user after tree data is loaded - when an entirely new tree of nodes is loaded from the
     * server, as a consequence of calling  {@link com.smartgwt.client.widgets.tree.ResultTree#invalidateCache
     * ResultTree.invalidateCache} or of changing criteria such that the current cache of nodes is dropped.
     *
     * @return PreserveOpenState
     */
    public PreserveOpenState getAutoPreserveOpenState()  {
        return EnumUtil.getEnum(PreserveOpenState.values(), getAttribute("autoPreserveOpenState"));
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, this property specifies the default value assumed for the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getCanReturnOpenSubfoldersProperty canReturnOpenSubfoldersProperty} when no
     * value for that property is provided for a node.
     *
     * @param canReturnOpenFolders  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCanReturnOpenFolders(boolean canReturnOpenFolders)  throws IllegalStateException {
        setAttribute("canReturnOpenFolders", canReturnOpenFolders, false);
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, this property specifies the default value assumed for the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getCanReturnOpenSubfoldersProperty canReturnOpenSubfoldersProperty} when no
     * value for that property is provided for a node.
     *
     * @return boolean
     */
    public boolean getCanReturnOpenFolders()  {
        return getAttributeAsBoolean("canReturnOpenFolders");
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, <code>canReturnOpenSubfoldersProperty</code> may be set on any folder to indicate whether child folders
     * might be returned by the server already open. If the property is set to false on a folder then subfolders of that folder
     * are never allowed to be returned already open.  This enables the paging mechanism to be more efficient in the amount of
     * data that it requests from the server. <P> For example, setting the <code>canReturnOpenSubfoldersProperty</code> value
     * to <code>false</code> on a node is appropriate if the server-side code determines that the the node's children consist
     * of entirely leaf nodes.
     *
     * @param canReturnOpenSubfoldersProperty  Default value is "canReturnOpenSubfolders"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.ResultTree#setCanReturnOpenFolders
     */
    public void setCanReturnOpenSubfoldersProperty(String canReturnOpenSubfoldersProperty)  throws IllegalStateException {
        setAttribute("canReturnOpenSubfoldersProperty", canReturnOpenSubfoldersProperty, false);
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, <code>canReturnOpenSubfoldersProperty</code> may be set on any folder to indicate whether child folders
     * might be returned by the server already open. If the property is set to false on a folder then subfolders of that folder
     * are never allowed to be returned already open.  This enables the paging mechanism to be more efficient in the amount of
     * data that it requests from the server. <P> For example, setting the <code>canReturnOpenSubfoldersProperty</code> value
     * to <code>false</code> on a node is appropriate if the server-side code determines that the the node's children consist
     * of entirely leaf nodes.
     *
     * @return String
     * @see com.smartgwt.client.widgets.tree.ResultTree#getCanReturnOpenFolders
     */
    public String getCanReturnOpenSubfoldersProperty()  {
        return getAttributeAsString("canReturnOpenSubfoldersProperty");
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, <code>childCountProperty</code> must be set for any folders that include only a partial list of
     * children. For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @param childCountProperty  Default value is "childCount"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree-multi-level-child-paging" target="examples">Multi-Level Child Paging Example</a>
     */
    public void setChildCountProperty(String childCountProperty)  throws IllegalStateException {
        setAttribute("childCountProperty", childCountProperty, false);
    }

    /**
     * When using {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} and providing multiple levels of the tree in
     * one DSResponse, <code>childCountProperty</code> must be set for any folders that include only a partial list of
     * children. For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree-multi-level-child-paging" target="examples">Multi-Level Child Paging Example</a>
     */
    public String getChildCountProperty()  {
        return getAttributeAsString("childCountProperty");
    }

    /**
     * Optional initial data for the tree.  If the {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode}
     * is <code>"basic"</code> or <code>"local"</code> then the format of this data is exactly the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentId}-linked list of tree nodes as documented on {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} (when the <code>modelType</code> is set to <code>"parent"</code>). 
     * If the <code>fetchMode</code> is <code>"paged"</code> then the format is extended to allow the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getChildCountProperty childCountProperty} to be set on folder nodes. <P>
     * Providing an initial set of nodes in this way does not affect the behavior of the ResultTree in its loading of unloaded
     * folders.  An equivalent result is achieved if the first fetch from the server returns this same data. <P> If
     * <code>fetchMode</code> is <code>"paged"</code> then you may make folder-by-folder choices as to whether to use paging
     * for the childen of each folder.  If you would like to use paging in a folder then you may include a partial list of that
     * folder's children with the data, provided that you set the <code>childCountProperty</code> to the total number of
     * children.  Otherwise you will need to include either all children of the folder or none of the children.  Open folders
     * without any children provided will cause immediate, new fetches for the children, as usual. <P> Because the initial data
     * is treated exactly as though it were returned from the tree's first server fetch, the order of the initial data must
     * match the initial sort order of the TreeGrid displaying the data or, if no such sort is specified, the native storage
     * order on the server.  For example, consider initial data containing <code>n</code> records having the
     * <code>parentId</code> <code>"X"</code>, meaning they are all in the same folder.  These <code>n</code> records are the
     * records at indices <code>0</code> through <code>(n - 1)</code> that are stored on the server under the parent node.  If
     * the <code>childCountProperty</code> set on the parent node indicates that there are <code>m > n</code> total rows under
     * the parent node then the records at indices <code>n</code> to <code>(m - 1)</code> will be fetched from the server as
     * the user scrolls the additional rows into view.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param data  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.Tree#setData
     * @see com.smartgwt.client.widgets.tree.TreeNode
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public void setData(TreeNode... data)  throws IllegalStateException {
        setAttribute("data", data, false);
    }

    /**
     * Optional initial data for the tree.  If the {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode}
     * is <code>"basic"</code> or <code>"local"</code> then the format of this data is exactly the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentId}-linked list of tree nodes as documented on {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} (when the <code>modelType</code> is set to <code>"parent"</code>). 
     * If the <code>fetchMode</code> is <code>"paged"</code> then the format is extended to allow the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getChildCountProperty childCountProperty} to be set on folder nodes. <P>
     * Providing an initial set of nodes in this way does not affect the behavior of the ResultTree in its loading of unloaded
     * folders.  An equivalent result is achieved if the first fetch from the server returns this same data. <P> If
     * <code>fetchMode</code> is <code>"paged"</code> then you may make folder-by-folder choices as to whether to use paging
     * for the childen of each folder.  If you would like to use paging in a folder then you may include a partial list of that
     * folder's children with the data, provided that you set the <code>childCountProperty</code> to the total number of
     * children.  Otherwise you will need to include either all children of the folder or none of the children.  Open folders
     * without any children provided will cause immediate, new fetches for the children, as usual. <P> Because the initial data
     * is treated exactly as though it were returned from the tree's first server fetch, the order of the initial data must
     * match the initial sort order of the TreeGrid displaying the data or, if no such sort is specified, the native storage
     * order on the server.  For example, consider initial data containing <code>n</code> records having the
     * <code>parentId</code> <code>"X"</code>, meaning they are all in the same folder.  These <code>n</code> records are the
     * records at indices <code>0</code> through <code>(n - 1)</code> that are stored on the server under the parent node.  If
     * the <code>childCountProperty</code> set on the parent node indicates that there are <code>m > n</code> total rows under
     * the parent node then the records at indices <code>n</code> to <code>(m - 1)</code> will be fetched from the server as
     * the user scrolls the additional rows into view.
     *
     * @return TreeNode...
     * @see com.smartgwt.client.widgets.tree.Tree#getData
     * @see com.smartgwt.client.widgets.tree.TreeNode
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public TreeNode[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfTreeNode(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will always be considered
     * folders.  Other nodes will be considered folders or leaves by default according to this setting. <P> If
     * <code>defaultIsFolder</code> is unset, the ResultTree will automatically set it to match the value of {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}.  This means that, when using
     * folder-by-folder load on demand (<code>loadDataOnDemand:true</code>), by default a newly loaded node will be considered
     * to be a folder that has not loaded its children yet.   <P> When not using folder-by-folder load on demand, by default a
     * newly loaded node is considered a leaf.  If you set <code>defaultIsFolder:true</code> explicitly, by default a newly
     * loaded node is considered to be a folder with no children. <P>  See {@link
     * com.smartgwt.client.widgets.tree.Tree#isFolder Tree.isFolder} for details on how to explicitly mark nodes as folders or
     * leaves.
     *
     * @param defaultIsFolder  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setLoadDataOnDemand
     */
    public void setDefaultIsFolder(Boolean defaultIsFolder)  throws IllegalStateException {
        setAttribute("defaultIsFolder", defaultIsFolder, false);
    }

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will always be considered
     * folders.  Other nodes will be considered folders or leaves by default according to this setting. <P> If
     * <code>defaultIsFolder</code> is unset, the ResultTree will automatically set it to match the value of {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}.  This means that, when using
     * folder-by-folder load on demand (<code>loadDataOnDemand:true</code>), by default a newly loaded node will be considered
     * to be a folder that has not loaded its children yet.   <P> When not using folder-by-folder load on demand, by default a
     * newly loaded node is considered a leaf.  If you set <code>defaultIsFolder:true</code> explicitly, by default a newly
     * loaded node is considered to be a folder with no children. <P>  See {@link
     * com.smartgwt.client.widgets.tree.Tree#isFolder Tree.isFolder} for details on how to explicitly mark nodes as folders or
     * leaves.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     */
    public Boolean getDefaultIsFolder()  {
        return getAttributeAsBoolean("defaultIsFolder");
    }

    /**
     * This attribute governs how to handle cache-synch when a new node is added to this dataSource  with no explicit parentId.
     * <P> If set to <code>true</code>, when a new node is added to this dataSource via {@link
     * com.smartgwt.client.data.DataSource#addData DataSource.addData}, with no explicit parentId, the node will be added as a 
     * child of the root node of this result tree. Otherwise it will be ignored. <P> Similar logic applies to {@link
     * com.smartgwt.client.data.DataSource#updateData updated nodes} - if this property is true and the parentId of an updated
     * node is cleared, it will be moved to become a child of root, otherwise it will be dropped from the tree.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultNewNodesToRoot  Default value is false
     */
    public void setDefaultNewNodesToRoot(Boolean defaultNewNodesToRoot) {
        setAttribute("defaultNewNodesToRoot", defaultNewNodesToRoot, true);
    }

    /**
     * This attribute governs how to handle cache-synch when a new node is added to this dataSource  with no explicit parentId.
     * <P> If set to <code>true</code>, when a new node is added to this dataSource via {@link
     * com.smartgwt.client.data.DataSource#addData DataSource.addData}, with no explicit parentId, the node will be added as a 
     * child of the root node of this result tree. Otherwise it will be ignored. <P> Similar logic applies to {@link
     * com.smartgwt.client.data.DataSource#updateData updated nodes} - if this property is true and the parentId of an updated
     * node is cleared, it will be moved to become a child of root, otherwise it will be dropped from the tree.
     *
     * @return Boolean
     */
    public Boolean getDefaultNewNodesToRoot()  {
        return getAttributeAsBoolean("defaultNewNodesToRoot");
    }

    /**
     * By default when the data of this ResultTree's dataSource is modified, the ResultTree will be updated to display these
     * changes. Set this flag to true to disable this behavior.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disableCacheSync  Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDisableCacheSync(Boolean disableCacheSync)  throws IllegalStateException {
        setAttribute("disableCacheSync", disableCacheSync, false);
    }

    /**
     * By default when the data of this ResultTree's dataSource is modified, the ResultTree will be updated to display these
     * changes. Set this flag to true to disable this behavior.
     *
     * @return Boolean
     */
    public Boolean getDisableCacheSync()  {
        return getAttributeAsBoolean("disableCacheSync");
    }

    /**
     * When data is loaded from the server, should nodes with an explicit value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't map to a valid parent node be
     * dropped? If set to false, for {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     * loadDataOnDemand}:false trees, parentless nodes will be added as children of the root node - for {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, they will be added as children of
     * the folder currently requesting children. <P> This effectively allows nodes to be loaded into the current (or root)
     * folder without needing an explicit {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField value}
     * that matches the folder's ID or <code>rootValue</code> for the resultTree. <P> Note: For
     * <code>loadDataOnDemand:false</code> trees, if this property is unset at init time, it will default to <code>true</code>
     * if an explicit {@link com.smartgwt.client.widgets.tree.ResultTree#getRootNode rootNode} has been specified. This ensures
     * that if the data tree retrieved from the server includes ancestors of the desired root-node we don't display them.
     * Otherwise this property always defaults to false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param discardParentlessNodes  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDiscardParentlessNodes(Boolean discardParentlessNodes)  throws IllegalStateException {
        setAttribute("discardParentlessNodes", discardParentlessNodes, false);
    }

    /**
     * When data is loaded from the server, should nodes with an explicit value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't map to a valid parent node be
     * dropped? If set to false, for {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     * loadDataOnDemand}:false trees, parentless nodes will be added as children of the root node - for {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand loadDataOnDemand}:true, they will be added as children of
     * the folder currently requesting children. <P> This effectively allows nodes to be loaded into the current (or root)
     * folder without needing an explicit {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField value}
     * that matches the folder's ID or <code>rootValue</code> for the resultTree. <P> Note: For
     * <code>loadDataOnDemand:false</code> trees, if this property is unset at init time, it will default to <code>true</code>
     * if an explicit {@link com.smartgwt.client.widgets.tree.ResultTree#getRootNode rootNode} has been specified. This ensures
     * that if the data tree retrieved from the server includes ancestors of the desired root-node we don't display them.
     * Otherwise this property always defaults to false.
     *
     * @return Boolean
     */
    public Boolean getDiscardParentlessNodes()  {
        return getAttributeAsBoolean("discardParentlessNodes");
    }

    /**
     * Mode of fetching records from server. <P> fetchMode:"local" implies that local filtering will always be performed. See
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"basic" or "paged" implies that if search criteria change, the entire tree will be discarded and
     * re-fetched from the server.  When retrieving the replacement tree data, the default behavior will be to preserve the
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getOpenState openState} for any nodes that the server returns which
     * were previously opened by the user.  Note that this implies that if {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand} is enabled and the server returns only
     * root-level nodes, open state will be preserved only for root-level nodes, and children of open root-level nodes will be
     * immediately fetched from the server if they are not included in the server's initial response. <P> fetchMode:"paged"
     * enables paging for nodes that have very large numbers of children. Whenever the children of a folder are loaded, the
     * <code>resultTree</code> will set {@link com.smartgwt.client.data.DSRequest#getStartRow startRow} and {@link
     * com.smartgwt.client.data.DSRequest#getEndRow endRow} when requesting children from the DataSource, and will manage
     * loading of further children on demand, similar to how a {@link com.smartgwt.client.data.ResultSet} manages paging for
     * lists.  For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @param fetchMode  Default value is "basic"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree-paging-for-children" target="examples">Paging for Children Example</a>
     */
    public void setFetchMode(FetchMode fetchMode)  throws IllegalStateException {
        setAttribute("fetchMode", fetchMode == null ? null : fetchMode.getValue(), false);
    }

    /**
     * Mode of fetching records from server. <P> fetchMode:"local" implies that local filtering will always be performed. See
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"basic" or "paged" implies that if search criteria change, the entire tree will be discarded and
     * re-fetched from the server.  When retrieving the replacement tree data, the default behavior will be to preserve the
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getOpenState openState} for any nodes that the server returns which
     * were previously opened by the user.  Note that this implies that if {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand} is enabled and the server returns only
     * root-level nodes, open state will be preserved only for root-level nodes, and children of open root-level nodes will be
     * immediately fetched from the server if they are not included in the server's initial response. <P> fetchMode:"paged"
     * enables paging for nodes that have very large numbers of children. Whenever the children of a folder are loaded, the
     * <code>resultTree</code> will set {@link com.smartgwt.client.data.DSRequest#getStartRow startRow} and {@link
     * com.smartgwt.client.data.DSRequest#getEndRow endRow} when requesting children from the DataSource, and will manage
     * loading of further children on demand, similar to how a {@link com.smartgwt.client.data.ResultSet} manages paging for
     * lists.  For a deeper discussion see the <b>Paging large sets of children</b> section of the {@link
     * com.smartgwt.client.docs.TreeDataBinding} overview.
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#tree-paging-for-children" target="examples">Paging for Children Example</a>
     */
    public FetchMode getFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("fetchMode"));
    }

    /**
     * If set, tree-based filtering is performed such that parent nodes are kept as long as they have children that match the
     * filter criteria, even if the parents themselves do not match the filter criteria. If not set, filtering will exclude
     * parent nodes not matching the criteria and all nodes below it in the tree. <P> When <code>keepParentsOnFilter</code> is
     * enabled for paged ResultTrees, server-side filtering is required. <P> When enabled for non-paged trees, {@link
     * com.smartgwt.client.types.FetchMode fetchMode:"local"} is automatically enabled so that all filtering behavior shifts to
     * the client-side and full criteria are no longer sent to the server.  Instead, server fetches will always load all nodes,
     * or with {@link com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}:true, will always load
     * all nodes under a given parent. This means that the server does not need to implement special tree filtering logic. <P>
     * Optionally, {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields serverFilterFields} can be set to a
     * list of field names that will be sent to the server whenever they are present in the criteria.
     *
     * @param keepParentsOnFilter  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
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
     * or with {@link com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}:true, will always load
     * all nodes under a given parent. This means that the server does not need to implement special tree filtering logic. <P>
     * Optionally, {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields serverFilterFields} can be set to a
     * list of field names that will be sent to the server whenever they are present in the criteria.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public Boolean getKeepParentsOnFilter()  {
        return getAttributeAsBoolean("keepParentsOnFilter");
    }

    /**
     * Does this resultTree load data incrementally as folders within the tree are opened, or is it all loaded in a single
     * request?
     *
     * @param loadDataOnDemand  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setLoadDataOnDemand
     */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand)  throws IllegalStateException {
        setAttribute("loadDataOnDemand", loadDataOnDemand, false);
    }

    /**
     * Does this resultTree load data incrementally as folders within the tree are opened, or is it all loaded in a single
     * request?
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
     * Sets {@link com.smartgwt.client.data.DataSource#getProgressiveLoading progressive loading mode} for this ResultTree. 
     * The ResultTree will copy this setting onto the {@link com.smartgwt.client.data.DSRequest}s that it issues, overriding
     * the OperationBinding- and DataSource-level settings, in cases where the use of progressive loading does not affect the
     * correctness of the tree's paging algorithm. <p> This setting is applied automatically by {@link
     * com.smartgwt.client.widgets.DataBoundComponent}s that have their own explicit setting for {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getProgressiveLoading progressiveLoading}. <p> <b>Note:</b>  This
     * property only has an effect for {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} ResultTrees.
     *
     * @param progressiveLoading  Default value is null
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.data.DSRequest#setProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading, true);
    }

    /**
     * Sets {@link com.smartgwt.client.data.DataSource#getProgressiveLoading progressive loading mode} for this ResultTree. 
     * The ResultTree will copy this setting onto the {@link com.smartgwt.client.data.DSRequest}s that it issues, overriding
     * the OperationBinding- and DataSource-level settings, in cases where the use of progressive loading does not affect the
     * correctness of the tree's paging algorithm. <p> This setting is applied automatically by {@link
     * com.smartgwt.client.widgets.DataBoundComponent}s that have their own explicit setting for {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getProgressiveLoading progressiveLoading}. <p> <b>Note:</b>  This
     * property only has an effect for {@link com.smartgwt.client.types.FetchMode fetchMode:"paged"} ResultTrees.
     *
     * @return Boolean
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.data.DSRequest#getProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean getProgressiveLoading()  {
        return getAttributeAsBoolean("progressiveLoading");
    }

    /**
     * How many tree nodes to retrieve at once from each large set of children in the tree. <P> Applicable only with
     * <code>fetchMode: "paged"</code>.  When a paged ResultTree is asked for rows that have not yet been loaded, it will fetch
     * adjacent rows that are likely to be required soon, in batches of this size.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resultSize  Default value is 75
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public void setResultSize(Integer resultSize)  throws IllegalStateException {
        setAttribute("resultSize", resultSize, false);
    }

    /**
     * How many tree nodes to retrieve at once from each large set of children in the tree. <P> Applicable only with
     * <code>fetchMode: "paged"</code>.  When a paged ResultTree is asked for rows that have not yet been loaded, it will fetch
     * adjacent rows that are likely to be required soon, in batches of this size.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public Integer getResultSize()  {
        return getAttributeAsInt("resultSize");
    }

    /**
     * When {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} is enabled for
     * {@link com.smartgwt.client.types.FetchMode fetchMode:"local"} ResultTrees, this property lists field names that will be
     * sent to the server if they are present in the criteria.
     *
     * @param serverFilterFields  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setServerFilterFields(String... serverFilterFields)  throws IllegalStateException {
        setAttribute("serverFilterFields", serverFilterFields, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} is enabled for
     * {@link com.smartgwt.client.types.FetchMode fetchMode:"local"} ResultTrees, this property lists field names that will be
     * sent to the server if they are present in the criteria.
     *
     * @return String...
     */
    public String[] getServerFilterFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("serverFilterFields"));
    }

    /**
     * When a successful Add, Update or Remove type operation fires on this ResultTree's  dataSource, if {@link
     * com.smartgwt.client.data.DSResponse#getData data} is unset, should we integrate the submitted data values (from the
     * request) into our data-set?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updateCacheFromRequest  Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUpdateCacheFromRequest(Boolean updateCacheFromRequest)  throws IllegalStateException {
        setAttribute("updateCacheFromRequest", updateCacheFromRequest, false);
    }

    /**
     * When a successful Add, Update or Remove type operation fires on this ResultTree's  dataSource, if {@link
     * com.smartgwt.client.data.DSResponse#getData data} is unset, should we integrate the submitted data values (from the
     * request) into our data-set?
     *
     * @return Boolean
     */
    public Boolean getUpdateCacheFromRequest()  {
        return getAttributeAsBoolean("updateCacheFromRequest");
    }

    // ********************* Methods ***********************

	/**
     * The ResultTree will call applyFilter() when it needs to locally filter the tree using the current filter criteria. <P>
     * Default behavior is to call {@link com.smartgwt.client.widgets.tree.Tree#getFilteredTree Tree.getFilteredTree} to obtain
     * a new, filtered tree. <P> Override this method or {@link com.smartgwt.client.widgets.tree.Tree#getFilteredTree
     * Tree.getFilteredTree} to implement your own client-side filtering behavior. Note that the original tree should not be
     * affected.
     * @param tree the source tree to be filtered
     * @param criteria the filter criteria
     * @param filterMode mode to use for filtering
     * @param dataSource dataSource for filtering if the Tree does not                                       already have one
     *
     * @return the filtered tree (copy)
     */
    public native Tree applyFilter(Tree tree, Criteria criteria, TreeFilterMode filterMode, DataSource dataSource) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.applyFilter(tree.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), filterMode.@com.smartgwt.client.types.TreeFilterMode::getValue()(), dataSource.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * The ResultTree will call applyFilter() when it needs to locally filter the tree using the current filter criteria. <P>
     * Default behavior is to call {@link com.smartgwt.client.widgets.tree.Tree#getFilteredTree Tree.getFilteredTree} to obtain
     * a new, filtered tree. <P> Override this method or {@link com.smartgwt.client.widgets.tree.Tree#getFilteredTree
     * Tree.getFilteredTree} to implement your own client-side filtering behavior. Note that the original tree should not be
     * affected.
     * @param tree the source tree to be filtered
     * @param criteria the filter criteria
     * @param filterMode mode to use for filtering
     * @param dataSource dataSource for filtering if the Tree does not                                       already have one
     * @param requestProperties Request properties block. This allows developers to specify  properties that would impact the filter such as {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}
     *
     * @return the filtered tree (copy)
     */
    public native Tree applyFilter(Tree tree, Criteria criteria, TreeFilterMode filterMode, DataSource dataSource, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.applyFilter(tree.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), filterMode.@com.smartgwt.client.types.TreeFilterMode::getValue()(), dataSource.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Default behavior is to call {@link com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} to
     * determine whether new criteria is equivalent to the old criteria (returns 0) or not. <P> See {@link
     * com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} for a full explanation of the default
     * behavior. The {@link com.smartgwt.client.types.CriteriaPolicy} used is "dropOnChange". <P> Override this method or
     * {@link com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} to implement your own client-side
     * filtering behavior.
     * @param newCriteria new filter criteria
     * @param oldCriteria old filter criteria
     *
     * @return 0 if the criteria are equivalent, -1 if the criteria are different
     * @see com.smartgwt.client.types.CriteriaPolicy
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(newCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(newCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(oldCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(oldCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Default behavior is to call {@link com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} to
     * determine whether new criteria is equivalent to the old criteria (returns 0) or not. <P> See {@link
     * com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} for a full explanation of the default
     * behavior. The {@link com.smartgwt.client.types.CriteriaPolicy} used is "dropOnChange". <P> Override this method or
     * {@link com.smartgwt.client.data.DataSource#compareCriteria DataSource.compareCriteria} to implement your own client-side
     * filtering behavior.
     * @param newCriteria new filter criteria
     * @param oldCriteria old filter criteria
     * @param requestProperties dataSource request properties
     *
     * @return 0 if the criteria are equivalent, -1 if the criteria are different
     * @see com.smartgwt.client.types.CriteriaPolicy
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(newCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(newCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(oldCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(oldCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;


	/**
     * This callback fires whenever the resultTree receives new nodes from the server, after the new nodes have been integrated
     * into the tree.
     * @param parentNode The parentNode for which children were just loaded
     */
    public native void dataArrived(TreeNode parentNode) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.dataArrived(parentNode.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Get the item in the openList at a particular position.
     * @param pos position of the node to get
     *
     * @return node at that position
     */
    public native TreeNode get(int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.get(pos);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a snapshot of the current open state of this tree's data as a {@link com.smartgwt.client.docs.TreeGridOpenState}
     * object. <P> This object can be passed to {@link com.smartgwt.client.widgets.tree.ResultTree#setOpenState
     * ResultTree.setOpenState} or {@link com.smartgwt.client.widgets.tree.TreeGrid#setOpenState TreeGrid.setOpenState} to open
     * the same set of folders within the tree's data (assuming the nodes are still present in the data).
     *
     * @return current open state for the grid.
     * @see com.smartgwt.client.widgets.tree.ResultTree#setOpenState
     */
    public native String getOpenState() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getOpenState();
        return ret;
    }-*/;


	/**
     * Get a range of items from the open list
     * @param start start position
     * @param end end position (NOT inclusive)
     *
     * @return list of nodes in the open list
     */
    public native TreeNode[] getRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getRange(start, end);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Manually invalidate this ResultTree's cache. <P> Generally a ResultTree will observe and incorporate updates to the
     * DataSource that provides its records, but when this is not possible, <code>invalidateCache()</code> allows manual cache
     * invalidation. <P> Components bound to this ResultTree will typically re-request the currently visible portion of the
     * dataset, causing the ResultTree to re-fetch data from the server.
     */
    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;


	/**
     * Set the filter criteria to use when fetching rows. <P> Depending on the result of {@link
     * com.smartgwt.client.widgets.tree.ResultTree#compareCriteria ResultTree.compareCriteria} and setting for {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode}, setting criteria may cause a trip to the server to
     * get a new set of nodes, or may simply cause already-fetched nodes to be re-filtered according to the new criteria. <P>
     * For a basic overview on when server fetches are generally performed, see {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode}. However, this is not the final determination of
     * when server fetches occur. Criteria can be split into local criteria and server criteria by specifying {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields serverFilterFields}. Thus, even when using
     * fetchMode:"local" a new server fetch will occur if the server criteria changes. For details on how the criteria is
     * split, see {@link com.smartgwt.client.data.DataSource#splitCriteria DataSource.splitCriteria}. <P> Note: if criteria is
     * being split to retrieve server criteria portion and the criteria is an {@link
     * com.smartgwt.client.data.AdvancedCriteria}, the criteria must consist of a single "and" operator and one or more simple
     * criteria below it. No other logical operators may be used. In other words, the {@link
     * com.smartgwt.client.data.AdvancedCriteria} provided must be exactly representable by a simple criteria.
     * @param newCriteria the filter criteria
     */
    public native void setCriteria(Criteria newCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(newCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(newCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.setCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Reset the set of open folders within this tree's data to match the  {@link com.smartgwt.client.docs.TreeGridOpenState}
     * object passed in. <P> Used to restore previous state retrieved from the tree by a call to  {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getOpenState ResultTree.getOpenState}.
     * @param openState Object describing the desired set of open folders.. See {@link com.smartgwt.client.docs.TreeGridOpenState TreeGridOpenState}
     * @see com.smartgwt.client.widgets.tree.ResultTree#getOpenState
     */
    public native void setOpenState(String openState) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setOpenState(openState);
    }-*/;


	/**
     * Unload the children of a folder, returning the folder to the "unloaded" state.
     * @param node folder in question
     */
    public native void unloadChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.unloadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Will changing the criteria for this resultTree require fetching new data from the server or can the new criteria be
     * satisfied from data already cached on the client? <p> This method can be used to determine whether {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#fetchData TreeGrid.fetchData} or  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#filterData TreeGrid.filterData} will cause a server side fetch when passed a
     * certain set of  criteria.
     * @param newCriteria new criteria to test.
     *
     * @return true if server fetch would be required to satisfy new criteria.
     */
    public native Boolean willFetchData(Criteria newCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(newCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(newCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        var ret = self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * What {@link com.smartgwt.client.data.DataSource} is this resultTree associated with?
     *
     * @param dataSource dataSource Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public void setDataSource(DataSource dataSource)  throws IllegalStateException {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), false);
    }

    /**
     * What {@link com.smartgwt.client.data.DataSource} is this resultTree associated with?
     *
     *
     * @return DataSource
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * This attribute may be used to specify a root value for the parentIdField of this resultTree. This overrides the default
     * {@link com.smartgwt.client.data.DataSourceField#getRootValue rootValue} for this tree, allowing a component to navigate
     * a tree starting at a specific node. <P> May be overridden via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue treeRootValue} for ResultTrees generated by a TreeGrid
     * component.
     *
     * @param rootNode rootNode Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRootNode(JavaScriptObject rootNode)  throws IllegalStateException {
        setAttribute("rootNode", rootNode, false);
    }

    /**
     * This attribute may be used to specify a root value for the parentIdField of this resultTree. This overrides the default
     * {@link com.smartgwt.client.data.DataSourceField#getRootValue rootValue} for this tree, allowing a component to navigate
     * a tree starting at a specific node. <P> May be overridden via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue treeRootValue} for ResultTrees generated by a TreeGrid
     * component.
     *
     *
     * @return Object
     */
    public JavaScriptObject getRootNode()  {
        return getAttributeAsJavaScriptObject("rootNode");
    }

}


