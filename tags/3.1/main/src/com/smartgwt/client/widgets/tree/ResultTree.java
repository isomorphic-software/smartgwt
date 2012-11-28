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
 
package com.smartgwt.client.widgets.tree;



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
 * ResultTrees are an implementation of the {@link com.smartgwt.client.widgets.tree.Tree} API, used to handle hierarchical
 * data, whose nodes are DataSource records which are retrieved from a server.
 */
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
     * @param defaultIsFolder defaultIsFolder Default value is null
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
     * @param defaultNewNodesToRoot defaultNewNodesToRoot Default value is false
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
     * @param disableCacheSync disableCacheSync Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDisableCacheSync(Boolean disableCacheSync)  throws IllegalStateException {
        setAttribute("disableCacheSync", disableCacheSync, false);
    }

    /**
     * By default when the data of this ResultTree's dataSource is modified, the ResultTree will be updated to display these
     * changes. Set this flag to true to disable this behavior.
     *
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
     * @param discardParentlessNodes discardParentlessNodes Default value is null
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
     *
     * @return Boolean
     */
    public Boolean getDiscardParentlessNodes()  {
        return getAttributeAsBoolean("discardParentlessNodes");
    }

    /**
     * Mode of fetching records from server. <P> In a ResultTree, "basic" fetchMode implies that if search criteria change, the
     * entire tree will be discarded and re-fetched from the server. {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getOpenState ResultTree.getOpenState} will be preserved. <P>
     * fetchMode:"local" implies that local filtering will be performed. See {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"paged" does not apply to ResultTrees. Instead, {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand} is used for folder-by-folder loading
     * of tree data. If enough nodes exist that paging is desirable within a folder, a better UI can be obtained by showing an
     * adjacent ListGrid (similar to Outlook email) to show a large number of child nodes.
     *
     * @param fetchMode fetchMode Default value is "basic"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFetchMode(FetchMode fetchMode)  throws IllegalStateException {
        setAttribute("fetchMode", fetchMode == null ? null : fetchMode.getValue(), false);
    }

    /**
     * Mode of fetching records from server. <P> In a ResultTree, "basic" fetchMode implies that if search criteria change, the
     * entire tree will be discarded and re-fetched from the server. {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getOpenState ResultTree.getOpenState} will be preserved. <P>
     * fetchMode:"local" implies that local filtering will be performed. See {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} for additional filtering
     * details. <P> fetchMode:"paged" does not apply to ResultTrees. Instead, {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand} is used for folder-by-folder loading
     * of tree data. If enough nodes exist that paging is desirable within a folder, a better UI can be obtained by showing an
     * adjacent ListGrid (similar to Outlook email) to show a large number of child nodes.
     *
     *
     * @return FetchMode
     */
    public FetchMode getFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("fetchMode"));
    }

    /**
     * If set, tree-based filtering is performed such that parent nodes are kept as long as they have children that match the
     * filter criteria, even if the parents themselves do not match the filter criteria. If not set, filtering will exclude
     * parent nodes not matching the criteria and all nodes below it in the tree. <P> When enabled, fetchMode:"local" is
     * automatically enabled so that all filtering behavior shifts to the client-side and full criteria are no longer sent to
     * the server.  Instead, server fetches will always load all nodes, or with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}:true, will always load all nodes under
     * a given parent.  This means that the server does not need to implement special tree filtering logic. <P> Optionally,
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields serverFilterFields} can be set to a list of
     * field names that will be sent to the server whenever they are present in the criteria.
     *
     * @param keepParentsOnFilter keepParentsOnFilter Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setKeepParentsOnFilter(Boolean keepParentsOnFilter)  throws IllegalStateException {
        setAttribute("keepParentsOnFilter", keepParentsOnFilter, false);
    }

    /**
     * If set, tree-based filtering is performed such that parent nodes are kept as long as they have children that match the
     * filter criteria, even if the parents themselves do not match the filter criteria. If not set, filtering will exclude
     * parent nodes not matching the criteria and all nodes below it in the tree. <P> When enabled, fetchMode:"local" is
     * automatically enabled so that all filtering behavior shifts to the client-side and full criteria are no longer sent to
     * the server.  Instead, server fetches will always load all nodes, or with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand loadDataOnDemand}:true, will always load all nodes under
     * a given parent.  This means that the server does not need to implement special tree filtering logic. <P> Optionally,
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getServerFilterFields serverFilterFields} can be set to a list of
     * field names that will be sent to the server whenever they are present in the criteria.
     *
     *
     * @return Boolean
     */
    public Boolean getKeepParentsOnFilter()  {
        return getAttributeAsBoolean("keepParentsOnFilter");
    }

    /**
     * Does this resultTree load data incrementally as folders within the tree are opened, or is it all loaded in a single
     * request?
     *
     * @param loadDataOnDemand loadDataOnDemand Default value is true
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
     * When {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} is enabled, this
     * property lists field names that will be sent to the server if they are present in criteria.
     *
     * @param serverFilterFields . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setServerFilterFields(String... serverFilterFields)  throws IllegalStateException {
        setAttribute("serverFilterFields", serverFilterFields, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} is enabled, this
     * property lists field names that will be sent to the server if they are present in criteria.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String[] getServerFilterFields()  {
        return getAttributeAsStringArray("serverFilterFields");
    }

    /**
     * When a successful Add, Update or Remove type operation fires on this ResultTree's  dataSource, if {@link
     * com.smartgwt.client.data.DSResponse#getData data} is unset, should we integrate the submitted data values (from the
     * request) into our data-set?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updateCacheFromRequest updateCacheFromRequest Default value is true
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
        var ret = self.applyFilter(tree.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), filterMode.@com.smartgwt.client.types.TreeFilterMode::getValue()(), dataSource.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.tree.Tree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
        var ret = self.applyFilter(tree.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), filterMode.@com.smartgwt.client.types.TreeFilterMode::getValue()(), dataSource.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.tree.Tree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
        return self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        return self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     * Returns a snapshot of the current open state of this tree's data as a TreeGridOpenState object. <P> This object can be
     * passed to {@link com.smartgwt.client.widgets.tree.ResultTree#setOpenState ResultTree.setOpenState} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setOpenState TreeGrid.setOpenState} to open the same set of folders within the
     * tree's data (assuming the nodes are still present in the data).
     *
     * @return current open state for the grid.
     * @see com.smartgwt.client.widgets.tree.ResultTree#setOpenState
     */
    public native String getOpenState() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getOpenState();
    }-*/;

    /**
     * Manually invalidate this ResultTree's cache. <P> Generally a ResultTree will observe and incorporate updates to the
     * DataSource that provides it's records, but when this is not possible, <code>invalidateCache()</code> allows manual cache
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
        self.setCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Reset the set of open folders within this tree's data to match the  TreeGridOpenState object passed in. <P> Used to
     * restore previous state retrieved from the tree by a call to  {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getOpenState ResultTree.getOpenState}.
     * @param openState Object describing the desired set of open folders.
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
        var retVal =self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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



