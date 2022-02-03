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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * A Tree is a data model representing a set of objects linked into a hierarchy. <P> A Tree has no visual presentation, it
 * is displayed by a {@link com.smartgwt.client.widgets.tree.TreeGrid} or {@link
 * com.smartgwt.client.widgets.grid.ColumnTree} when supplied as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData
 * TreeGrid.data} or {@link com.smartgwt.client.widgets.grid.ColumnTree#getData ColumnTree.data}. <P> A Tree can be
 * constructed out of a List of objects interlinked by IDs or via explicitly specified Arrays of child objects.  See {@link
 * com.smartgwt.client.widgets.tree.Tree#getModelType modelType} for an explanation of how to pass data to a Tree. <P>
 * Typical usage is to call {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData TreeGrid.fetchData()} to cause
 * automatic creation of a  {@link com.smartgwt.client.widgets.tree.ResultTree}, which is a type of Tree that automatically
 * handles loading data on  demand.  For information on DataBinding Trees, see {@link
 * com.smartgwt.client.docs.TreeDataBinding}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Tree")
public class Tree extends RecordList implements com.smartgwt.client.widgets.tree.HasDataChangedHandlers {

    public static Tree getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Tree) obj;
        } else {
            return new Tree(jsObj);
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
        onBind();
    }
        


    public Tree(){
        scClassName = "Tree";
    }

    public Tree(JavaScriptObject jsObj){
        scClassName = "Tree";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * For a {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, indicates whether client-side
     * filtering is allowed on the fields of the {@link com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource
     * linkDataSource}.  When this  property is true, filtering operations involving link fields work as expected (ie, as if
     * those  fields were present on the main {@link com.smartgwt.client.widgets.tree.ResultTree#getDataSource dataSource});
     * when this value is not true, criterions involving link fields are simply ignored. <p> Note, setting this property true
     * causes filtering operations to perform an additional record duplication per node in the dataset to be filtered.  This
     * adds some overhead, so you should consider likely data volumes before enabling it (though in fact, client-side filtering
     * of  trees is relatively expensive anyway, so acceptable use cases probably already involve quite low data volumes) <p>
     * This property has no effect for regular, non-multiLink trees.
     *
     * @param allowFilterOnLinkFields New allowFilterOnLinkFields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setAllowFilterOnLinkFields(Boolean allowFilterOnLinkFields)  throws IllegalStateException {
        return (Tree)setAttribute("allowFilterOnLinkFields", allowFilterOnLinkFields, false);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, indicates whether client-side
     * filtering is allowed on the fields of the {@link com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource
     * linkDataSource}.  When this  property is true, filtering operations involving link fields work as expected (ie, as if
     * those  fields were present on the main {@link com.smartgwt.client.widgets.tree.ResultTree#getDataSource dataSource});
     * when this value is not true, criterions involving link fields are simply ignored. <p> Note, setting this property true
     * causes filtering operations to perform an additional record duplication per node in the dataset to be filtered.  This
     * adds some overhead, so you should consider likely data volumes before enabling it (though in fact, client-side filtering
     * of  trees is relatively expensive anyway, so acceptable use cases probably already involve quite low data volumes) <p>
     * This property has no effect for regular, non-multiLink trees.
     *
     * @return Current allowFilterOnLinkFields value. Default value is null
     */
    public Boolean getAllowFilterOnLinkFields()  {
        return getAttributeAsBoolean("allowFilterOnLinkFields");
    }
    

    /**
     * If true, the root node is automatically opened when the tree is created or {@link
     * com.smartgwt.client.widgets.tree.Tree#setRoot setRoot()} is called.
     *
     * @param autoOpenRoot New autoOpenRoot value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     */
    public Tree setAutoOpenRoot(Boolean autoOpenRoot) {
        return (Tree)setAttribute("autoOpenRoot", autoOpenRoot, true);
    }

    /**
     * If true, the root node is automatically opened when the tree is created or {@link
     * com.smartgwt.client.widgets.tree.Tree#setRoot setRoot()} is called.
     *
     * @return Current autoOpenRoot value. Default value is true
     */
    public Boolean getAutoOpenRoot()  {
        Boolean result = getAttributeAsBoolean("autoOpenRoot");
        return result == null ? true : result;
    }
    

    /**
     * For trees with the modelType "children", this property specifies the name of the property that contains the list of
     * children for a node.
     *
     * @param childrenProperty New childrenProperty value. Default value is "children"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.Tree#setModelType
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_children_arrays" target="examples">Children Arrays Example</a>
     */
    public Tree setChildrenProperty(String childrenProperty) {
        return (Tree)setAttribute("childrenProperty", childrenProperty, true);
    }

    /**
     * For trees with the modelType "children", this property specifies the name of the property that contains the list of
     * children for a node.
     *
     * @return Current childrenProperty value. Default value is "children"
     * @see com.smartgwt.client.widgets.tree.Tree#getModelType
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_children_arrays" target="examples">Children Arrays Example</a>
     */
    public String getChildrenProperty()  {
        return getAttributeAsString("childrenProperty");
    }
    
    

    /**
     * Specifies what {@link com.smartgwt.client.data.DataSource} this tree is associated with. <P> A {@link
     * com.smartgwt.client.data.DataSource} is required when filtering a tree, even if it isn't a {@link
     * com.smartgwt.client.widgets.tree.ResultTree}, though it may be passed to {@link
     * com.smartgwt.client.widgets.tree.Tree#getFilteredTree getFilteredTree()} rather than set on the tree itself.  If a
     * {@link com.smartgwt.client.data.DataSource} is specified it will also affect sorting, where relevant, such as if the
     * tree is set as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data}.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setDataSource(DataSource dataSource)  throws IllegalStateException {
        return (Tree)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * Specifies what {@link com.smartgwt.client.data.DataSource} this tree is associated with. <P> A {@link
     * com.smartgwt.client.data.DataSource} is required when filtering a tree, even if it isn't a {@link
     * com.smartgwt.client.widgets.tree.ResultTree}, though it may be passed to {@link
     * com.smartgwt.client.widgets.tree.Tree#getFilteredTree getFilteredTree()} rather than set on the tree itself.  If a
     * {@link com.smartgwt.client.data.DataSource} is specified it will also affect sorting, where relevant, such as if the
     * tree is set as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data}.
     *
     * @return Current dataSource value. Default value is null
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * Specifies what {@link com.smartgwt.client.data.DataSource} this tree is associated with. <P> A {@link
     * com.smartgwt.client.data.DataSource} is required when filtering a tree, even if it isn't a {@link
     * com.smartgwt.client.widgets.tree.ResultTree}, though it may be passed to {@link
     * com.smartgwt.client.widgets.tree.Tree#getFilteredTree getFilteredTree()} rather than set on the tree itself.  If a
     * {@link com.smartgwt.client.data.DataSource} is specified it will also affect sorting, where relevant, such as if the
     * tree is set as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data}.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setDataSource(String dataSource)  throws IllegalStateException {
        return (Tree)setAttribute("dataSource", dataSource, false);
    }

    /**
     * Specifies what {@link com.smartgwt.client.data.DataSource} this tree is associated with. <P> A {@link
     * com.smartgwt.client.data.DataSource} is required when filtering a tree, even if it isn't a {@link
     * com.smartgwt.client.widgets.tree.ResultTree}, though it may be passed to {@link
     * com.smartgwt.client.widgets.tree.Tree#getFilteredTree getFilteredTree()} rather than set on the tree itself.  If a
     * {@link com.smartgwt.client.data.DataSource} is specified it will also affect sorting, where relevant, such as if the
     * tree is set as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data}.
     *
     * @return Current dataSource value. Default value is null
     */
    public String getDataSourceAsString()  {
        return getAttributeAsString("dataSource");
    }
    

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will be considered folders by
     * default.  Other nodes will be considered folders or leaves by default according to this setting. <p> See also {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getDefaultIsFolder ResultTree.defaultIsFolder} for more details on how
     * <code>defaultIsFolder</code> interacts with  {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     * loading data on demand}.
     *
     * @param defaultIsFolder New defaultIsFolder value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setDefaultIsFolder(Boolean defaultIsFolder)  throws IllegalStateException {
        return (Tree)setAttribute("defaultIsFolder", defaultIsFolder, false);
    }

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will be considered folders by
     * default.  Other nodes will be considered folders or leaves by default according to this setting. <p> See also {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getDefaultIsFolder ResultTree.defaultIsFolder} for more details on how
     * <code>defaultIsFolder</code> interacts with  {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand
     * loading data on demand}.
     *
     * @return Current defaultIsFolder value. Default value is null
     */
    public Boolean getDefaultIsFolder()  {
        return getAttributeAsBoolean("defaultIsFolder");
    }
    

    /**
     * Title assigned to nodes without a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} value or
     * a {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} value.
     *
     * @param defaultNodeTitle New defaultNodeTitle value. Default value is "Untitled"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     */
    public Tree setDefaultNodeTitle(String defaultNodeTitle) {
        return (Tree)setAttribute("defaultNodeTitle", defaultNodeTitle, true);
    }

    /**
     * Title assigned to nodes without a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} value or
     * a {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} value.
     *
     * @return Current defaultNodeTitle value. Default value is "Untitled"
     */
    public String getDefaultNodeTitle()  {
        return getAttributeAsString("defaultNodeTitle");
    }
    

    /**
     * If this tree has {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType:"parent"}, should nodes in the data
     * array for the tree be dropped if they have an explicitly specified value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't match any other nodes in the tree.
     * If set to false these nodes will be added as children of the root node.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param discardParentlessNodes New discardParentlessNodes value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setDiscardParentlessNodes(Boolean discardParentlessNodes)  throws IllegalStateException {
        return (Tree)setAttribute("discardParentlessNodes", discardParentlessNodes, false);
    }

    /**
     * If this tree has {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType:"parent"}, should nodes in the data
     * array for the tree be dropped if they have an explicitly specified value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't match any other nodes in the tree.
     * If set to false these nodes will be added as children of the root node.
     *
     * @return Current discardParentlessNodes value. Default value is false
     */
    public Boolean getDiscardParentlessNodes()  {
        Boolean result = getAttributeAsBoolean("discardParentlessNodes");
        return result == null ? false : result;
    }
    

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds an id for the node which is
     * unique across the entire Tree.  Required for all nodes for trees with modelType "parent". Default value is "id".  See
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getId TreeNode.id} for usage.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param idField New idField value. Default value is "id"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.TreeNode#setId
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Tree setIdField(String idField)  throws IllegalStateException {
        return (Tree)setAttribute("idField", idField, false);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds an id for the node which is
     * unique across the entire Tree.  Required for all nodes for trees with modelType "parent". Default value is "id".  See
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getId TreeNode.id} for usage.
     *
     * @return Current idField value. Default value is "id"
     * @see com.smartgwt.client.widgets.tree.TreeNode#getId
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public String getIdField()  {
        return getAttributeAsString("idField");
    }
    

    /**
     * Name of property that defines whether a node is a folder.  By default this is set to {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder TreeNode.isFolder}.
     *
     * @param isFolderProperty New isFolderProperty value. Default value is "isFolder"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.TreeNode#setIsFolder
     */
    public Tree setIsFolderProperty(String isFolderProperty) {
        return (Tree)setAttribute("isFolderProperty", isFolderProperty, true);
    }

    /**
     * Name of property that defines whether a node is a folder.  By default this is set to {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder TreeNode.isFolder}.
     *
     * @return Current isFolderProperty value. Default value is "isFolder"
     * @see com.smartgwt.client.widgets.tree.TreeNode#getIsFolder
     */
    public String getIsFolderProperty()  {
        return getAttributeAsString("isFolderProperty");
    }
    
    

    /**
     * The name of the "position" field in this {@link com.smartgwt.client.widgets.tree.Tree#getLinkData multi-link tree}'s
     * link data. Ignored if this tree is not a multi-link tree
     *
     * @param linkPositionField New linkPositionField value. Default value is "position"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setLinkPositionField(String linkPositionField)  throws IllegalStateException {
        return (Tree)setAttribute("linkPositionField", linkPositionField, false);
    }

    /**
     * The name of the "position" field in this {@link com.smartgwt.client.widgets.tree.Tree#getLinkData multi-link tree}'s
     * link data. Ignored if this tree is not a multi-link tree
     *
     * @return Current linkPositionField value. Default value is "position"
     */
    public String getLinkPositionField()  {
        return getAttributeAsString("linkPositionField");
    }
    

    /**
     * Selects the model used to construct the tree representation.  See {@link com.smartgwt.client.types.TreeModelType} for
     * the available options and their implications. <P> If the "parent" modelType is used, you can provide the initial
     * parent-linked data set to the tree via the {@link com.smartgwt.client.widgets.tree.Tree#getData data} attribute.  If the
     * "children" modelType is used, you can provide the initial tree structure to the Tree via the {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} attribute.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param modelType New modelType value. Default value is "children"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.Tree#setData
     * @see com.smartgwt.client.widgets.tree.Tree#setRoot
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Tree setModelType(TreeModelType modelType) {
        return (Tree)setAttribute("modelType", modelType == null ? null : modelType.getValue(), true);
    }

    /**
     * Selects the model used to construct the tree representation.  See {@link com.smartgwt.client.types.TreeModelType} for
     * the available options and their implications. <P> If the "parent" modelType is used, you can provide the initial
     * parent-linked data set to the tree via the {@link com.smartgwt.client.widgets.tree.Tree#getData data} attribute.  If the
     * "children" modelType is used, you can provide the initial tree structure to the Tree via the {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} attribute.
     *
     * @return Current modelType value. Default value is "children"
     * @see com.smartgwt.client.widgets.tree.Tree#getData
     * @see com.smartgwt.client.widgets.tree.Tree#getRoot
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public TreeModelType getModelType()  {
        return EnumUtil.getEnum(TreeModelType.values(), getAttribute("modelType"));
    }
    
    

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds a name for the node that is
     * unique among its immediate siblings, thus allowing a unique path to be used to identify the node, similar to a file
     * system.  Default value is "name".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getName TreeNode.name} for
     * usage.
     *
     * @param nameProperty New nameProperty value. Default value is "name"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.TreeNode#setName
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Tree setNameProperty(String nameProperty) {
        return (Tree)setAttribute("nameProperty", nameProperty, true);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds a name for the node that is
     * unique among its immediate siblings, thus allowing a unique path to be used to identify the node, similar to a file
     * system.  Default value is "name".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getName TreeNode.name} for
     * usage.
     *
     * @return Current nameProperty value. Default value is "name"
     * @see com.smartgwt.client.widgets.tree.TreeNode#getName
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public String getNameProperty()  {
        return getAttributeAsString("nameProperty");
    }
    

    /**
     * The property consulted by the default implementation of {@link com.smartgwt.client.widgets.tree.Tree#isOpen isOpen()} to
     * determine if the node is open or not.  By default, this property is auto-generated for you, but you can set it to a
     * custom value if you want to declaratively specify this state, but be careful - if you display this Tree in multiple
     * TreeGrids at the same time, the open state will not be tracked independently - see {@link
     * com.smartgwt.client.docs.SharingNodes} for more info on this. <p> For {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, we do not track open state on the nodes 
     * themselves, because this would mean that multiple instances of a node in the tree would open and close in lockstep. 
     * Instead, open state is tracked in an internal index structure, and the <code>openProperty</code> is not used at all.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param openProperty New openProperty value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand" target="examples">Initial Data & Load on Demand Example</a>
     */
    public Tree setOpenProperty(String openProperty) {
        return (Tree)setAttribute("openProperty", openProperty, true);
    }

    /**
     * The property consulted by the default implementation of {@link com.smartgwt.client.widgets.tree.Tree#isOpen isOpen()} to
     * determine if the node is open or not.  By default, this property is auto-generated for you, but you can set it to a
     * custom value if you want to declaratively specify this state, but be careful - if you display this Tree in multiple
     * TreeGrids at the same time, the open state will not be tracked independently - see {@link
     * com.smartgwt.client.docs.SharingNodes} for more info on this. <p> For {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, we do not track open state on the nodes 
     * themselves, because this would mean that multiple instances of a node in the tree would open and close in lockstep. 
     * Instead, open state is tracked in an internal index structure, and the <code>openProperty</code> is not used at all.
     *
     * @return Current openProperty value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand" target="examples">Initial Data & Load on Demand Example</a>
     */
    public String getOpenProperty()  {
        return getAttributeAsString("openProperty");
    }
    

    /**
     * For trees with modelType "parent", this property specifies the name of the property that contains the unique parent ID
     * of a node.  Default value is "parentId".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getParentId
     * TreeNode.parentId} for usage.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentIdField New parentIdField value. Default value is "parentId"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.tree.TreeNode#setParentId
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public Tree setParentIdField(String parentIdField)  throws IllegalStateException {
        return (Tree)setAttribute("parentIdField", parentIdField, false);
    }

    /**
     * For trees with modelType "parent", this property specifies the name of the property that contains the unique parent ID
     * of a node.  Default value is "parentId".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getParentId
     * TreeNode.parentId} for usage.
     *
     * @return Current parentIdField value. Default value is "parentId"
     * @see com.smartgwt.client.widgets.tree.TreeNode#getParentId
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_appearance_node_titles" target="examples">Node Titles Example</a>
     */
    public String getParentIdField()  {
        return getAttributeAsString("parentIdField");
    }
    

    /**
     * Specifies the delimiter between node names.  The pathDelim is used to construct a unique
     *  path to each node. A path can be obtained for any node by calling
     *  {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} and can be used to find any node in the tree by calling
     * {@link com.smartgwt.client.widgets.tree.Tree#find find()}.  Note that you can also hand-construct a path - in other
     * words
     *  you are not required to call {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} in order to later use
     *  {@link com.smartgwt.client.widgets.tree.Tree#find find()} to retrieve it.
     *  <br><br>
     *  The pathDelim can be any character or sequence of characters, but must be a unique string
     * with respect to the text that can appear in the {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty
     * nameProperty} that's used
     *  for naming the nodes.  So for example, if you have the following tree:
     *  <pre>
     *  one
     *    two
     *      three/four
     *  </pre>
     *  Then you will be unable to find the <code>three/four</code> node using
     *  {@link com.smartgwt.client.widgets.tree.Tree#find find()} if your tree is using the default pathDelim of /.
     *  In such a case, you can use a different pathDelim for the tree.  For example if you used |
     *  for the path delim, then you can find the <code>three/four</code> node in the tree above by
     *  calling <code>tree.find("one|two|three/four")</code>.
     *  <br><br>
     * The pathDelim is used only by {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} and {@link
     * com.smartgwt.client.widgets.tree.Tree#find find()} and
     *  does not affect any aspect of the tree structure or other forms of tree navigation (such as
     *  via {@link com.smartgwt.client.widgets.tree.Tree#getChildren getChildren()}).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pathDelim New pathDelim value. Default value is "/"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.Tree#setNameProperty
     * @see com.smartgwt.client.widgets.tree.Tree#find
     */
    public Tree setPathDelim(String pathDelim) {
        return (Tree)setAttribute("pathDelim", pathDelim, true);
    }

    /**
     * Specifies the delimiter between node names.  The pathDelim is used to construct a unique
     *  path to each node. A path can be obtained for any node by calling
     *  {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} and can be used to find any node in the tree by calling
     * {@link com.smartgwt.client.widgets.tree.Tree#find find()}.  Note that you can also hand-construct a path - in other
     * words
     *  you are not required to call {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} in order to later use
     *  {@link com.smartgwt.client.widgets.tree.Tree#find find()} to retrieve it.
     *  <br><br>
     *  The pathDelim can be any character or sequence of characters, but must be a unique string
     * with respect to the text that can appear in the {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty
     * nameProperty} that's used
     *  for naming the nodes.  So for example, if you have the following tree:
     *  <pre>
     *  one
     *    two
     *      three/four
     *  </pre>
     *  Then you will be unable to find the <code>three/four</code> node using
     *  {@link com.smartgwt.client.widgets.tree.Tree#find find()} if your tree is using the default pathDelim of /.
     *  In such a case, you can use a different pathDelim for the tree.  For example if you used |
     *  for the path delim, then you can find the <code>three/four</code> node in the tree above by
     *  calling <code>tree.find("one|two|three/four")</code>.
     *  <br><br>
     * The pathDelim is used only by {@link com.smartgwt.client.widgets.tree.Tree#getPath getPath()} and {@link
     * com.smartgwt.client.widgets.tree.Tree#find find()} and
     *  does not affect any aspect of the tree structure or other forms of tree navigation (such as
     *  via {@link com.smartgwt.client.widgets.tree.Tree#getChildren getChildren()}).
     *
     * @return Current pathDelim value. Default value is "/"
     * @see com.smartgwt.client.widgets.tree.Tree#getNameProperty
     * @see com.smartgwt.client.widgets.tree.Tree#find
     */
    public String getPathDelim()  {
        return getAttributeAsString("pathDelim");
    }
    

    /**
     * If new nodes are added to a tree with modelType:"parent" which have the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField id field value} as existing nodes, the existing nodes are removed when
     * the new nodes are added. <P> If reportCollisions is true, the Tree will log a warning in the developer console about
     * this. <P> Note that if an id collision occurs between a new node and its ancestor, the ancestor will be removed and the
     * new node will not be added to the tree.
     *
     * @param reportCollisions New reportCollisions value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public Tree setReportCollisions(Boolean reportCollisions)  throws IllegalStateException {
        return (Tree)setAttribute("reportCollisions", reportCollisions, false);
    }

    /**
     * If new nodes are added to a tree with modelType:"parent" which have the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField id field value} as existing nodes, the existing nodes are removed when
     * the new nodes are added. <P> If reportCollisions is true, the Tree will log a warning in the developer console about
     * this. <P> Note that if an id collision occurs between a new node and its ancestor, the ancestor will be removed and the
     * new node will not be added to the tree.
     *
     * @return Current reportCollisions value. Default value is true
     */
    public Boolean getReportCollisions()  {
        Boolean result = getAttributeAsBoolean("reportCollisions");
        return result == null ? true : result;
    }
    

    /**
     * If you're using the "parent" modelType, you can provide the root node configuration via this
     *  property.  If you don't provide it, one will be auto-created for you with an empty name.
     *  Read on for a description of what omitting the name property on the root node means for path
     *  derivation.
     *  <p>
     *  If you're using the "children" modelType, you can provide the initial tree data via this
     *  property.  So, for example, to construct the following tree:
     *  <pre>
     *  foo
     *    bar
     *  zoo
     *  </pre>
     *  You would initialize the tree as follows: 
     *  
     *  
     *  <pre>
     *  Tree tree = new Tree();
     *  tree.setRoot(
     *      new TreeNode("root",
     *          new TreeNode("foo",
     *              new TreeNode("bar")),
     *          new TreeNode("zoo")
     *      )
     *  );
     *  </pre>
     *  
     *  <br><br>
     *  Note: if you initialize a Tree with no <code>root</code> value, a root node will be
     *  auto-created for you.  You can then call {@link com.smartgwt.client.widgets.tree.Tree#add add()} to construct the tree.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the root node of the tree.  Called automatically on this Tree during initialization and on the Tree returned from a call to {@link com.smartgwt.client.widgets.tree.Tree#duplicate duplicate()}.
     *
     * @param root new root node. Default value is null
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.Tree#setModelType
     * @see com.smartgwt.client.widgets.tree.Tree#setRoot
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_children_arrays" target="examples">Children Arrays Example</a>
     */
    public Tree setRoot(TreeNode root) {
        return (Tree)setAttribute("root", root == null ? null : root.getJsObj(), true);
    }

    /**
     * If you're using the "parent" modelType, you can provide the root node configuration via this
     *  property.  If you don't provide it, one will be auto-created for you with an empty name.
     *  Read on for a description of what omitting the name property on the root node means for path
     *  derivation.
     *  <p>
     *  If you're using the "children" modelType, you can provide the initial tree data via this
     *  property.  So, for example, to construct the following tree:
     *  <pre>
     *  foo
     *    bar
     *  zoo
     *  </pre>
     *  You would initialize the tree as follows: 
     *  
     *  
     *  <pre>
     *  Tree tree = new Tree();
     *  tree.setRoot(
     *      new TreeNode("root",
     *          new TreeNode("foo",
     *              new TreeNode("bar")),
     *          new TreeNode("zoo")
     *      )
     *  );
     *  </pre>
     *  
     *  <br><br>
     *  Note: if you initialize a Tree with no <code>root</code> value, a root node will be
     *  auto-created for you.  You can then call {@link com.smartgwt.client.widgets.tree.Tree#add add()} to construct the tree.
     *
     * @return Returns the root node of the tree. Default value is null
     * @see com.smartgwt.client.widgets.tree.Tree#getModelType
     * @see com.smartgwt.client.widgets.tree.Tree#setRoot
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_children_arrays" target="examples">Children Arrays Example</a>
     */
    public TreeNode getRoot()  {
        return TreeNode.getOrCreateRef(getAttributeAsJavaScriptObject("root"));
    }
    
    

    /**
     * Should folders be sorted separately from leaves or should nodes be ordered according to their sort field value
     * regardless of whether the node is a leaf or folder?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tree.Tree#getSeparateFolders separateFolders}.
     *
     * @param separateFolders new <code>separateFolders</code> value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.Tree#setSortFoldersBeforeLeaves
     */
    public Tree setSeparateFolders(Boolean separateFolders) {
        return (Tree)setAttribute("separateFolders", separateFolders, true);
    }

    /**
     * Should folders be sorted separately from leaves or should nodes be ordered according to their sort field value
     * regardless of whether the node is a leaf or folder?
     *
     * @return Current separateFolders value. Default value is false
     * @see com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves
     */
    public Boolean getSeparateFolders()  {
        Boolean result = getAttributeAsBoolean("separateFolders");
        return result == null ? false : result;
    }
    

    /**
     * Controls whether the implicit root node is returned as part of the visible tree, specifically, whether it is returned in
     * {@link com.smartgwt.client.widgets.tree.Tree#getOpenList getOpenList()}, which is the API view components typically use
     * to get the list of visible nodes. <p> Default is to have the root node be implicit and not included in the open list,
     * which means that the visible tree begins with the children of root.  This allows multiple nodes to appear at the top
     * level of the tree. <P> You can set <code>showRoot:true</code> to show the single, logical root node as the only
     * top-level node.  This property is only meaningful for Trees where you supplied a value for {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root}, otherwise, you will see an automatically generated root node that
     * is meaningless to the user.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tree.Tree#getShowRoot showRoot}.
     *
     * @param showRoot new <code>showRoot</code> value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     */
    public Tree setShowRoot(Boolean showRoot) {
        return (Tree)setAttribute("showRoot", showRoot, true);
    }

    /**
     * Controls whether the implicit root node is returned as part of the visible tree, specifically, whether it is returned in
     * {@link com.smartgwt.client.widgets.tree.Tree#getOpenList getOpenList()}, which is the API view components typically use
     * to get the list of visible nodes. <p> Default is to have the root node be implicit and not included in the open list,
     * which means that the visible tree begins with the children of root.  This allows multiple nodes to appear at the top
     * level of the tree. <P> You can set <code>showRoot:true</code> to show the single, logical root node as the only
     * top-level node.  This property is only meaningful for Trees where you supplied a value for {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root}, otherwise, you will see an automatically generated root node that
     * is meaningless to the user.
     *
     * @return Current showRoot value. Default value is false
     */
    public Boolean getShowRoot()  {
        Boolean result = getAttributeAsBoolean("showRoot");
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tree.Tree#getSeparateFolders separateFolders} is true, should folders be displayed
     * above or below leaves? When set to <code>true</code> folders will appear above leaves when the
     * <code>sortDirection</code> applied to the tree is {@link com.smartgwt.client.types.SortDirection "ascending"}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.tree.Tree#getSortFoldersBeforeLeaves sortFoldersBeforeLeaves}.
     *
     * @param sortFoldersBeforeLeaves new <code>sortFoldersBeforeLeaves</code> value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     */
    public Tree setSortFoldersBeforeLeaves(Boolean sortFoldersBeforeLeaves) {
        return (Tree)setAttribute("sortFoldersBeforeLeaves", sortFoldersBeforeLeaves, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.Tree#getSeparateFolders separateFolders} is true, should folders be displayed
     * above or below leaves? When set to <code>true</code> folders will appear above leaves when the
     * <code>sortDirection</code> applied to the tree is {@link com.smartgwt.client.types.SortDirection "ascending"}
     *
     * @return Current sortFoldersBeforeLeaves value. Default value is true
     */
    public Boolean getSortFoldersBeforeLeaves()  {
        Boolean result = getAttributeAsBoolean("sortFoldersBeforeLeaves");
        return result == null ? true : result;
    }
    

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds the title of the node as it
     * should be shown to the user.  Default value is "title".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle
     * TreeNode.title} for usage.
     *
     * @param titleProperty New titleProperty value. Default value is "title"
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter calls
     */
    public Tree setTitleProperty(String titleProperty) {
        return (Tree)setAttribute("titleProperty", titleProperty, true);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds the title of the node as it
     * should be shown to the user.  Default value is "title".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle
     * TreeNode.title} for usage.
     *
     * @return Current titleProperty value. Default value is "title"
     */
    public String getTitleProperty()  {
        return getAttributeAsString("titleProperty");
    }
    

    // ********************* Methods ***********************
	/**
     * For a databound tree, do the children of this folder form a ResultSet with a full cache. <P> Note that this method only
     * applies to {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode ResultTree.fetchMode} "paged".
     * @param node folder in question
     *
     * @return folder's children are a ResultSet with a full cache
     * @see com.smartgwt.client.widgets.tree.Tree#getChildrenResultSet
     */
    public native Boolean allChildrenLoaded(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "allChildrenLoaded", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.allChildrenLoaded(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Close all nodes under a particular node
     */
    public native void closeAll() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeAll", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeAll();
    }-*/;

	/**
     * Close all nodes under a particular node
     * @param node node from which to close folders (if not specified,                                            the root node is used). 
     * If this is a                                            {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree
     * multi-link tree}, you must                                            provide a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} for any node other                                           than the root
     * node
     */
    public native void closeAll(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeAll", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeAll(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Close all nodes under a particular node
     * @param node node from which to close folders (if not specified,                                            the root node is used). 
     * If this is a                                            {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree
     * multi-link tree}, you must                                            provide a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} for any node other                                           than the root
     * node
     */
    public native void closeAll(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeAll", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeAll(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Closes a folder.  Note, for {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a 
     * <code>NodeLocator</code> is the only unambiguous way to specify the node.
     * @param node the node to open, or its                                                                  ID, or a NodeLocator object
     */
    public native void closeFolder(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFolder", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Closes a folder.  Note, for {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a 
     * <code>NodeLocator</code> is the only unambiguous way to specify the node.
     * @param node the node to open, or its                                                                  ID, or a NodeLocator object
     */
    public native void closeFolder(String node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFolder", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeFolder(node);
    }-*/;

	/**
     * Closes a folder.  Note, for {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a 
     * <code>NodeLocator</code> is the only unambiguous way to specify the node.
     * @param node the node to open, or its                                                                  ID, or a NodeLocator object
     */
    public native void closeFolder(Integer node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFolder", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeFolder(node == null ? null : node.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Closes a folder.  Note, for {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a 
     * <code>NodeLocator</code> is the only unambiguous way to specify the node.
     * @param node the node to open, or its                                                                  ID, or a NodeLocator object
     */
    public native void closeFolder(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFolder", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeFolder(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Returns a {@link com.smartgwt.client.widgets.tree.NodeLocator} object suitable for passing to methods, such as {@link
     * com.smartgwt.client.widgets.tree.Tree#getParent getParent()}, which require a <code>NodeLocator</code> when the tree is 
     * {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-linked}.  Note, <code>NodeLocator</code>s are
     * specific to multiLink trees; they are never required for regular trees.
     * @param node the child node
     * @param parent the parent node
     * @param position the child node's position within the parent
     * @param path the full path to the child node
     */
    public native void createNodeLocator(TreeNode node, TreeNode parent, Integer position, String path) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createNodeLocator", "TreeNode,TreeNode,Integer,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.createNodeLocator(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()(), position == null ? null : position.@java.lang.Integer::intValue()(), path);
    }-*/;

	/**
     * Returns a {@link com.smartgwt.client.widgets.tree.NodeLocator} object suitable for passing to methods, such as {@link
     * com.smartgwt.client.widgets.tree.Tree#getParent getParent()}, which require a <code>NodeLocator</code> when the tree is 
     * {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-linked}.  Note, <code>NodeLocator</code>s are
     * specific to multiLink trees; they are never required for regular trees.
     * @param node the child node
     * @param parent the parent node
     * @param position the child node's position within the parent
     * @param path the full path to the child node
     * @param openListIndex the index of the node occurence in the tree's current openList.                                This is the same as the
     * record index of the node in an                                 associated {@link
     * com.smartgwt.client.widgets.tree.TreeGrid}
     */
    public native void createNodeLocator(TreeNode node, TreeNode parent, Integer position, String path, Integer openListIndex) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createNodeLocator", "TreeNode,TreeNode,Integer,String,Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.createNodeLocator(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()(), position == null ? null : position.@java.lang.Integer::intValue()(), path, openListIndex == null ? null : openListIndex.@java.lang.Integer::intValue()());
    }-*/;
	
    /**
     * Add a dataChanged handler.
     * <p>
     * Called when the structure of this tree is changed in any way. <br><br> Note that on a big change (many items being added
     * or deleted) this may be called multiple times
     *
     * @param handler the dataChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataChangedHandler(com.smartgwt.client.widgets.tree.DataChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.DataChangedEvent.getType()) == 0) setupDataChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.DataChangedEvent.getType());
    }

    private native void setupDataChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var dataChanged = $entry(function(){
            var param = {"_this": this};
                var event = @com.smartgwt.client.widgets.tree.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.widgets.tree.Tree::handleTearDownDataChangedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({dataChanged:  dataChanged              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.dataChanged =  dataChanged             ;
        }
    }-*/;

    private void handleTearDownDataChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tree.DataChangedEvent.getType()) == 0) tearDownDataChangedEvent();
    }

    private native void tearDownDataChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataChanged")) delete obj.dataChanged;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.data.List#findIndex List.findIndex()}, but operates only on the list of currently opened
     * nodes.  To search all loaded nodes open or closed, use {@link com.smartgwt.client.widgets.tree.Tree#findNodeIndex
     * findNodeIndex()}.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findIndex(String propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findIndex", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findIndex(propertyName);
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.data.List#findIndex List.findIndex()}, but operates only on the list of currently opened
     * nodes.  To search all loaded nodes open or closed, use {@link com.smartgwt.client.widgets.tree.Tree#findNodeIndex
     * findNodeIndex()}.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findIndex(Map propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findIndex", "Map");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findIndex(propertyName == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(propertyName));
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.data.List#findIndex List.findIndex()}, but operates only on the list of currently opened
     * nodes.  To search all loaded nodes open or closed, use {@link com.smartgwt.client.widgets.tree.Tree#findNodeIndex
     * findNodeIndex()}.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findIndex(AdvancedCriteria propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findIndex", "AdvancedCriteria");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findIndex(propertyName.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.data.List#findIndex List.findIndex()}, but operates only on the list of currently opened
     * nodes.  To search all loaded nodes open or closed, use {@link com.smartgwt.client.widgets.tree.Tree#findNodeIndex
     * findNodeIndex()}.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findIndex(String propertyName, Object value) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findIndex", "String,Object");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findIndex(propertyName, value);
        return ret;
    }-*/;
	
	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but inspects a range from
     * <code>startIndex</code> to <code>endIndex</code>.  Note that as in {@link
     * com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, only open nodes are included.  To include both open and
     * closed nodes, use {@link com.smartgwt.client.widgets.tree.Tree#findNextNodeIndex findNextNodeIndex()}.
     * @param startIndex first index to consider.
     * @param propertyName property to match;  or, if an object is passed, set of properties and values to match.
     *
     * @return index of the first matching value or -1 if not found.
     */
    public native int findNextIndex(int startIndex, String propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNextIndex", "int,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNextIndex(startIndex, propertyName);
        return ret;
    }-*/;

    /**
     * @see Tree#findNextIndex
     */
    public int findNextIndex(int startIndex, String propertyName, Object value){
        return findNextIndex(startIndex, propertyName, value, (Integer) null);
    }

	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but inspects a range from
     * <code>startIndex</code> to <code>endIndex</code>.  Note that as in {@link
     * com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, only open nodes are included.  To include both open and
     * closed nodes, use {@link com.smartgwt.client.widgets.tree.Tree#findNextNodeIndex findNextNodeIndex()}.
     * @param startIndex first index to consider.
     * @param propertyName property to match;  or, if an object is passed, set of properties and values to match.
     * @param value value to compare against (if <code>propertyName</code> is a string)
     * @param endIndex last index to consider (inclusive).
     *
     * @return index of the first matching value or -1 if not found.
     */
    public native int findNextIndex(int startIndex, String propertyName, Object value, int endIndex) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNextIndex", "int,String,Object,int");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNextIndex(startIndex, propertyName, value, endIndex);
        return ret;
    }-*/;
	
	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findNextIndex findNextIndex()}, but includes both open and closed
     * nodes.
     * @param startIndex first index to consider.
     * @param propertyName property to match;  or, if an object is passed, set of properties and values to match.
     *
     * @return index of the first matching value or -1 if not found.
     */
    public native int findNextNodeIndex(int startIndex, String propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNextNodeIndex", "int,String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNextNodeIndex(startIndex, propertyName);
        return ret;
    }-*/;

    /**
     * @see Tree#findNextNodeIndex
     */
    public int findNextNodeIndex(int startIndex, String propertyName, Object value){
        return findNextNodeIndex(startIndex, propertyName, value, (Integer) null);
    }

	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findNextIndex findNextIndex()}, but includes both open and closed
     * nodes.
     * @param startIndex first index to consider.
     * @param propertyName property to match;  or, if an object is passed, set of properties and values to match.
     * @param value value to compare against (if <code>propertyName</code> is a string)
     * @param endIndex last index to consider (inclusive).
     *
     * @return index of the first matching value or -1 if not found.
     */
    public native int findNextNodeIndex(int startIndex, String propertyName, Object value, int endIndex) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNextNodeIndex", "int,String,Object,int");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNextNodeIndex(startIndex, propertyName, value, endIndex);
        return ret;
    }-*/;
	
	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but searches all tree nodes regardless of
     * their open/closed state.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findNodeIndex(String propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNodeIndex", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNodeIndex(propertyName);
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but searches all tree nodes regardless of
     * their open/closed state.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findNodeIndex(Map propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNodeIndex", "Map");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNodeIndex(propertyName == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(propertyName));
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but searches all tree nodes regardless of
     * their open/closed state.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findNodeIndex(AdvancedCriteria propertyName) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNodeIndex", "AdvancedCriteria");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNodeIndex(propertyName.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Like {@link com.smartgwt.client.widgets.tree.Tree#findIndex findIndex()}, but searches all tree nodes regardless of
     * their open/closed state.
     * @param propertyName property to match, or if an Object is passed, set of                                        properties and values to
     * match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Object or -1 if not found
     */
    public native int findNodeIndex(String propertyName, Object value) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "findNodeIndex", "String,Object");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findNodeIndex(propertyName, value);
        return ret;
    }-*/;
	
	/**
     * Returns a ResultSet that provides access to any partially-loaded children of a node.  If the node is a leaf, this method
     * returns null.
     * @param node The node whose children you want to fetch.
     *
     * @return List of children for the node, including an empty ResultSet if the node has no children.  For a leaf, returns null.
     * @see com.smartgwt.client.widgets.tree.Tree#getChildren
     * @see com.smartgwt.client.widgets.tree.Tree#allChildrenLoaded
     */
    public native ResultSet getChildrenResultSet(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChildrenResultSet", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getChildrenResultSet(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.ResultSet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a list of link{type:NodeLocator)s identifying all descendants of a node (identified by the parameter
     * <code>NodeLocator</code>).  This method is the equivalent of {@link com.smartgwt.client.widgets.tree.Tree#getDescendants
     * getDescendants()}, but for  {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link trees}.  The list of
     * descendant nodes returned from both methods is identical - a node's descendants are the same regardless of where or how 
     * many times that node appears in the tree - but the <code>NodeLocator</code>s returned by this method provide additional
     * context that allows you to determine particular occurences of descendant nodes.  This is necessary for some use cases -
     * for example, when trying to  determine if a particular node occurence is open, or selected.
     *
     * @return List of descendants of the node.
     */
    public native List getDescendantNodeLocators() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDescendantNodeLocators", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getDescendantNodeLocators();
        return ret;
    }-*/;

	/**
     * Returns a list of link{type:NodeLocator)s identifying all descendants of a node (identified by the parameter
     * <code>NodeLocator</code>).  This method is the equivalent of {@link com.smartgwt.client.widgets.tree.Tree#getDescendants
     * getDescendants()}, but for  {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link trees}.  The list of
     * descendant nodes returned from both methods is identical - a node's descendants are the same regardless of where or how 
     * many times that node appears in the tree - but the <code>NodeLocator</code>s returned by this method provide additional
     * context that allows you to determine particular occurences of descendant nodes.  This is necessary for some use cases -
     * for example, when trying to  determine if a particular node occurence is open, or selected.
     * @param node node in question (the root node is assumed if none is specified)
     *
     * @return List of descendants of the node.
     */
    public native List getDescendantNodeLocators(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDescendantNodeLocators", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getDescendantNodeLocators(node == null ? null : node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	
	/**
     * Returns the number of items in the current open list.
     *
     * @return number of items in open list
     * @see com.smartgwt.client.widgets.tree.Tree#getOpenList
     */
    public native int getLength() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLength", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLength();
        return ret;
    }-*/;

	/**
     * 
     *  Return the number of levels deep this node is in the tree.  For example, for this tree:
     *  <pre>
     *  root
     *    foo
     *      bar
     *  </pre>
     *  Calling <code>tree.getLevel(bar)</code> will return <code>2</code>. 
     *  <P>
     * Note {@link com.smartgwt.client.widgets.tree.Tree#getShowRoot showRoot} defaults to false so that multiple nodes can be
     * shown at top level.  In
     *  this case, the top-level nodes still have root as a parent, so have level 1, even though
     *  they have no visible parents.
     *  <p>
     * For {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link trees}, passing a <code>TreeNode</code> to
     * this 
     *  method will return the level of one of that node's occurences; it is not predictable which
     *  occurence will be used.  For multi-link trees, therefore, you should pass a 
     *  {@link com.smartgwt.client.widgets.tree.NodeLocator} with a path that unambiguously identifies the node occurence you 
     *  are interested in
     * 
     * 
     * @param node node in question, or a suitable                                               <code>NodeLocator</code>
     *
     * @return number of parents the node has
     */
    public native int getLevel(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLevel", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLevel(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * 
     *  Return the number of levels deep this node is in the tree.  For example, for this tree:
     *  <pre>
     *  root
     *    foo
     *      bar
     *  </pre>
     *  Calling <code>tree.getLevel(bar)</code> will return <code>2</code>. 
     *  <P>
     * Note {@link com.smartgwt.client.widgets.tree.Tree#getShowRoot showRoot} defaults to false so that multiple nodes can be
     * shown at top level.  In
     *  this case, the top-level nodes still have root as a parent, so have level 1, even though
     *  they have no visible parents.
     *  <p>
     * For {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link trees}, passing a <code>TreeNode</code> to
     * this 
     *  method will return the level of one of that node's occurences; it is not predictable which
     *  occurence will be used.  For multi-link trees, therefore, you should pass a 
     *  {@link com.smartgwt.client.widgets.tree.NodeLocator} with a path that unambiguously identifies the node occurence you 
     *  are interested in
     * 
     * 
     * @param node node in question, or a suitable                                               <code>NodeLocator</code>
     *
     * @return number of parents the node has
     */
    public native int getLevel(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLevel", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLevel(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * What is the loadState of a given folder?
     * @param node folder in question
     *
     * @return state of the node
     */
    public native LoadState getLoadState(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLoadState", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getLoadState(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        var enumValues = @com.smartgwt.client.types.LoadState::values()();
        return @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(enumValues, ret);
    }-*/;

	/**
     * For {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multiLink trees}, returns the array of this node's
     * direct parents (the actual node objects, not the IDs).  For non-multiLink trees, returns an array  containing the single
     * parent of this node.  See also {@link com.smartgwt.client.widgets.tree.Tree#getParentsAndPositions
     * getParentsAndPositions()}.
     * @param node node in question
     *
     * @return the parents of this node
     */
    public native TreeNode[] getMultiLinkParents(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMultiLinkParents", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getMultiLinkParents(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Get the 'name' of a node.  This is node[{@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}].  If
     * that value has not been set on the node, the node's 'ID' value will be tried (this is  node[{@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField idField}]).  If that value is not present on the node, a unique value 
     * (within this parent) will be auto-generated and returned.
     * @param node node in question, or a suitable {@link com.smartgwt.client.widgets.tree.NodeLocator}
     *
     * @return name of the node
     */
    public native String getName(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getName", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getName(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Get the 'name' of a node.  This is node[{@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}].  If
     * that value has not been set on the node, the node's 'ID' value will be tried (this is  node[{@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField idField}]).  If that value is not present on the node, a unique value 
     * (within this parent) will be auto-generated and returned.
     * @param node node in question, or a suitable {@link com.smartgwt.client.widgets.tree.NodeLocator}
     *
     * @return name of the node
     */
    public native String getName(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getName", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getName(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * For a {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, this method returns the {@link
     * com.smartgwt.client.widgets.tree.NodeLocator nodeLocator} associated with the particular occurence of the node at the
     * specified index within the current {@link com.smartgwt.client.widgets.tree.Tree#getOpenList open list} of nodes in the
     * tree.  Not applicable to non-multilink trees (always returns null)
     * @param recordIndex position of a node occurence within the open list of the tree
     *
     * @return NodeLocator unambiguously identifying the specific node occurence
     */
    public native NodeLocator getNodeLocator(Integer recordIndex) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNodeLocator", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getNodeLocator(recordIndex == null ? null : recordIndex.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.NodeLocator::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Given a node, return the path to its parent.  This works just like {@link com.smartgwt.client.widgets.tree.Tree#getPath
     * getPath()} except the node itself is not reported as part of the path.
     * @param node node in question
     *
     * @return path to the node's parent
     * @see com.smartgwt.client.widgets.tree.Tree#getPath
     */
    public native String getParentPath(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getParentPath", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getParentPath(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * 
     * For {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multiLink trees}, returns the array of this node's
     * direct
     *  parents and the node's position within each parent.  Each entry is a record like this:
     *  <pre>
     *  [
     *      {parent: [reference-to-parent-node], position: [this-node's-position-within-the-parent]},
     *      {parent: [reference-to-parent-node], position: [this-node's-position-within-the-parent]}
     *  ]
     *  </pre>
     *  For non-multiLink trees, returns null (calling this method makes no sense for non-multiLink
     *  trees).
     * 
     * 
     * @param node node in question
     *
     * @return the parents and positions of this node
     */
    public native Record[] getParentsAndPositions(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getParentsAndPositions", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getParentsAndPositions(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * 
     *  Returns the path of a node - a path has the following format:
     *  <code>([name][pathDelim]?)*</code>
     *  <br><br>
     *  For example, in this tree:
     *  <pre>
     *  root
     *    foo
     *      bar
     *  </pre>
     * Assuming that {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim} is the default <code>/</code>, the
     * <code>bar</code>
     *  node would have the path <code>root/foo/bar</code> and the path for the <code>foo</code>
     *  node would be <code>root/foo</code>.
     *  <br><br>
     *  Once you have a path to a node, you can call find(path) to retrieve a reference to the node
     *  later.
     *  <p>
     * <b>Note: </b>Nodes in {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link trees} do not have a
     * single path, 
     *  because a given node can occur in multiple places in the tree.  Therefore, if you pass a
     *  <code>TreeNode</code> instance to this method, it returns the path to one occurence of the 
     *  node; which particular occurence it chooses is not predictable, and there may be other paths
     *  to other occurences of the same node in the tree.  The only way to obtain an unambiguous 
     * path for a particular occurence of a node is to call {@link
     * com.smartgwt.client.widgets.tree.Tree#getPathForOpenListIndex getPathForOpenListIndex()}, 
     *  passing in the position of the node occurence in the tree's openList (which will be the same 
     * as the record number of the node's visual occurence in a {@link com.smartgwt.client.widgets.tree.TreeGrid treeGrid}); if
     *  the node occurence is not yet in the tree's openList - either because its parent has not yet
     *  been opened, or because the tree is in the process of being built - the tree is not able to 
     *  provide a path to the node occurence.  In this case, you would have to obtain the path 
     * in application code, by reference to the original {@link com.smartgwt.client.widgets.tree.Tree#getData data} and {@link
     * com.smartgwt.client.widgets.tree.Tree#getLinkData linkData} 
     * 
     * 
     * @param node node in question
     *
     * @return path to the node
     * @see com.smartgwt.client.widgets.tree.Tree#getParentPath
     */
    public native String getPath(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPath", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPath(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * This method returns the path to the node at the specified index within the current open list of nodes in this tree. Note
     * that for a node that appears in more than one place in a {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree
     * multi-link tree}, the returned path will be the visible path to the node in the specified index. <P> See {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath getPath()} for more information on paths for TreeNodes.
     * @param recordIndex position of a node within the open list of the tree
     *
     * @return path to the node
     */
    public native String getPathForOpenListIndex(Integer recordIndex) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPathForOpenListIndex", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPathForOpenListIndex(recordIndex == null ? null : recordIndex.@java.lang.Integer::intValue()());
        return ret;
    }-*/;

	/**
     * Return the title of a node -- the name as it should be presented to the user.  This method works as follows: <ul> <li>
     * If a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} is set on the node, the value of that
     * property is returned. <li> Otherwise, if the {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}
     * is set on the node, that value is returned, minus any trailing {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim
     * pathDelim}. <li> Finally, if none of the above yielded a title, the value of {@link
     * com.smartgwt.client.widgets.tree.Tree#getDefaultNodeTitle defaultNodeTitle} is returned. </ul> You can override this
     * method to return the title of your choice for a given node. <br><br> To override the title for an auto-constructed tree
     * (for example, in a databound TreeGrid), override {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeTitle
     * TreeGrid.getNodeTitle()} instead.
     * @param node node for which the title is being requested
     *
     * @return title to display
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getNodeTitle
     */
    public native String getTitle(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getTitle", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns true if this node has any children.
     * @param node node in question
     *
     * @return true if the node has children
     */
    public native Boolean hasChildren(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasChildren", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hasChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return true if this this node has any children that are folders.
     * @param node node in question
     *
     * @return true if the node has children that are folders
     */
    public native Boolean hasFolders(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasFolders", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hasFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return whether this node has any children that are leaves.
     * @param node node in question
     *
     * @return true if the node has children that are leaves
     */
    public native Boolean hasLeaves(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasLeaves", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.hasLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Is one node a descendant of the other?
     * @param child child node
     * @param parent parent node
     *
     * @return true == parent is an ancestor of child
     */
    public native Boolean isDescendantOf(TreeNode child, TreeNode parent) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isDescendantOf", "TreeNode,TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isDescendantOf(child.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Determines whether a particular node is a folder.  The logic works as follows:<br><br> <ul> <li> If the {@link
     * com.smartgwt.client.widgets.tree.TreeNode} has a value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} ({@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder TreeNode.isFolder} by default) that value is returned. <li> Next,
     * the existence of the {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty} (by default
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getChildren TreeNode.children}) is checked on the {@link
     * com.smartgwt.client.widgets.tree.TreeNode}.  If the node has the children property defined (regardless of whether it
     * actually has any children), then isFolder() returns true for that node. </ul>
     * @param node node in question
     *
     * @return true if the node is a folder
     */
    public native Boolean isFolder(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isFolder", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if the passed in node is a leaf.
     * @param node node in question
     *
     * @return true if the node is a leaf
     * @see com.smartgwt.client.widgets.tree.Tree#isFolder
     */
    public native Boolean isLeaf(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isLeaf", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isLeaf(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * For a databound tree, has this folder either already loaded its children or is it in the process of loading them.
     * @param node folder in question
     *
     * @return folder is loaded or is currently loading
     */
    public native Boolean isLoaded(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isLoaded", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isLoaded(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if this is a <i>multi-link</i> tree - ie, one that can contain the same node in more than one place. 
     * Otherwise, returns false.  <p> See {@link com.smartgwt.client.widgets.tree.Tree#getLinkData linkData} and {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource ResultTree.linkDataSource} for further details of 
     * multiLink trees.
     */
    public native void isMultiLinkTree() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isMultiLinkTree", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.isMultiLinkTree();
    }-*/;

	/**
     * Whether a particular node is open or closed (works for leaves and folders).  Note, for {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a <code>NodeLocator</code> is the only
     * unambiguous way to specify the node.
     * @param node the node in question, or the                                                               the node's ID, or a
     * NodeLocator                                                              object
     *
     * @return true if the node is open
     */
    public native Boolean isOpen(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOpen", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isOpen(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Whether a particular node is open or closed (works for leaves and folders).  Note, for {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a <code>NodeLocator</code> is the only
     * unambiguous way to specify the node.
     * @param node the node in question, or the                                                               the node's ID, or a
     * NodeLocator                                                              object
     *
     * @return true if the node is open
     */
    public native Boolean isOpen(String node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOpen", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isOpen(node);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Whether a particular node is open or closed (works for leaves and folders).  Note, for {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a <code>NodeLocator</code> is the only
     * unambiguous way to specify the node.
     * @param node the node in question, or the                                                               the node's ID, or a
     * NodeLocator                                                              object
     *
     * @return true if the node is open
     */
    public native Boolean isOpen(Integer node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOpen", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isOpen(node == null ? null : node.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Whether a particular node is open or closed (works for leaves and folders).  Note, for {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s, passing a <code>NodeLocator</code> is the only
     * unambiguous way to specify the node.
     * @param node the node in question, or the                                                               the node's ID, or a
     * NodeLocator                                                              object
     *
     * @return true if the node is open
     */
    public native Boolean isOpen(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isOpen", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isOpen(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if "parent" is the parent of "node".  This is straightforward and definitive  for ordinary trees, because
     * nodes can only have one parent.  In {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multiLink trees},
     * however, nodes can have multiple parents, so this method returning true only means that "parent" is <i>a</i> parent of
     * "node" - there may or may not be others.
     * @param node the node in question
     * @param parent the node to query to see if is a parent of the other node
     *
     * @return true if "parent" is a parent of "node"; otherwise false
     */
    public native Boolean isParent(TreeNode node, TreeNode parent) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isParent", "TreeNode,TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isParent(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return true if the passed node is the root node.
     * @param node node to test
     *
     * @return true if the node is the root node
     */
    public native Boolean isRoot(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isRoot", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isRoot(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * For {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}s only, called when links are added to
     * or removed form the tree.  <br><br> Note that on a big change (many items being added or deleted) this may be called
     * multiple times
     */
    public native void linkDataChanged() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "linkDataChanged", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.linkDataChanged();
    }-*/;

	/**
     * Load the children of a given node. <P> For a databound tree this will trigger a fetch against the Tree's DataSource.
     * @param node node in question
     */
    public native void loadChildren(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "loadChildren", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.loadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Load the children of a given node. <P> For a databound tree this will trigger a fetch against the Tree's DataSource.
     * @param node node in question
     * @param callback Optional callback (stringMethod) to fire when loading                       completes. Has a single param
     * <code>node</code> - the node whose                       children have been loaded, and is fired in the scope of the
     * Tree.
     */
    public native void loadChildren(TreeNode node, DSCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "loadChildren", "TreeNode,DSCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.loadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}));
    }-*/;
	
	/**
     * Moves the specified node to a new parent.
     * @param node node to move
     * @param newParent new parent to move the node to
     */
    public native void move(TreeNode node, TreeNode newParent) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "move", "TreeNode,TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.move(node.@com.smartgwt.client.core.DataClass::getJsObj()(), newParent.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Moves the specified node to a new parent.
     * @param node node to move
     * @param newParent new parent to move the node to
     * @param position Position of the new node in the children list. If not                                 specified, the node will be added
     * at the end of the list.
     */
    public native void move(TreeNode node, TreeNode newParent, Integer position) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "move", "TreeNode,TreeNode,Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.move(node.@com.smartgwt.client.core.DataClass::getJsObj()(), newParent.@com.smartgwt.client.core.DataClass::getJsObj()(), position == null ? null : position.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Open all nodes under a particular node.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_parentlinking" target="examples">Parent Linking Example</a>
     */
    public native void openAll() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openAll", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll();
    }-*/;

	/**
     * Open all nodes under a particular node.
     * @param node node from which to open folders,                                                               or the node's ID, or a   
     * NodeLocator object (if not                                                               specified, the root node is
     * used)
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_parentlinking" target="examples">Parent Linking Example</a>
     */
    public native void openAll(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openAll", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Open all nodes under a particular node.
     * @param node node from which to open folders,                                                               or the node's ID, or a   
     * NodeLocator object (if not                                                               specified, the root node is
     * used)
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_parentlinking" target="examples">Parent Linking Example</a>
     */
    public native void openAll(String node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openAll", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll(node);
    }-*/;

	/**
     * Open all nodes under a particular node.
     * @param node node from which to open folders,                                                               or the node's ID, or a   
     * NodeLocator object (if not                                                               specified, the root node is
     * used)
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_parentlinking" target="examples">Parent Linking Example</a>
     */
    public native void openAll(Integer node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openAll", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll(node == null ? null : node.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Open all nodes under a particular node.
     * @param node node from which to open folders,                                                               or the node's ID, or a   
     * NodeLocator object (if not                                                               specified, the root node is
     * used)
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_parentlinking" target="examples">Parent Linking Example</a>
     */
    public native void openAll(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "openAll", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;

	/**
     * Reload the children of a folder.
     * @param node node in question
     * @see com.smartgwt.client.widgets.tree.Tree#removeChildren
     */
    public native void reloadChildren(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reloadChildren", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reloadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Removes a node, along with all its children.  See {@link com.smartgwt.client.widgets.tree.ResultTree "Modifying
     * ResultTrees"} when working with a <code>ResultTree</code> for limitations.  Note, if this is a  {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, you must pass in a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} rather than a node or id.
     * @param node node to remove, or the node's ID,                                                              or a NodeLocator
     *
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean remove(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "remove", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.remove(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Removes a node, along with all its children.  See {@link com.smartgwt.client.widgets.tree.ResultTree "Modifying
     * ResultTrees"} when working with a <code>ResultTree</code> for limitations.  Note, if this is a  {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, you must pass in a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} rather than a node or id.
     * @param node node to remove, or the node's ID,                                                              or a NodeLocator
     *
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean remove(String node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "remove", "String");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.remove(node);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Removes a node, along with all its children.  See {@link com.smartgwt.client.widgets.tree.ResultTree "Modifying
     * ResultTrees"} when working with a <code>ResultTree</code> for limitations.  Note, if this is a  {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, you must pass in a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} rather than a node or id.
     * @param node node to remove, or the node's ID,                                                              or a NodeLocator
     *
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean remove(Integer node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "remove", "Integer");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.remove(node == null ? null : node.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Removes a node, along with all its children.  See {@link com.smartgwt.client.widgets.tree.ResultTree "Modifying
     * ResultTrees"} when working with a <code>ResultTree</code> for limitations.  Note, if this is a  {@link
     * com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, you must pass in a {@link
     * com.smartgwt.client.widgets.tree.NodeLocator} rather than a node or id.
     * @param node node to remove, or the node's ID,                                                              or a NodeLocator
     *
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean remove(NodeLocator node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "remove", "NodeLocator");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.remove(node == null ? null : node.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Removes all children of the node and sets it to a loaded state.  For non-{@link
     * com.smartgwt.client.widgets.tree.ResultTree}s, or non-{@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode
     * paged} <code>ResultTree</code>s, {@link com.smartgwt.client.widgets.tree.Tree#add add()} or {@link
     * com.smartgwt.client.widgets.tree.Tree#addList addList()} can then be used to provide new children.  For {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode paged} <code>ResultTrees</code>, {@link
     * com.smartgwt.client.data.DataSource#updateCaches DataSource.updateCaches()} must be used to insert nodes into the cache
     * as local data, since such <code>ResultTree</code>s are considered read-only, and {@link
     * com.smartgwt.client.widgets.tree.Tree#add add()} and {@link com.smartgwt.client.widgets.tree.Tree#addList addList()} are
     * not perrmitted.
     * @param node folder in question
     * @see com.smartgwt.client.widgets.tree.Tree#getLoadState
     * @see com.smartgwt.client.widgets.tree.Tree#reloadChildren
     */
    public native void removeChildren(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeChildren", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Replaces the existing children of a parent node, leaving the node in the loaded state. Only a flat list of children
     * nodes is supported, as in {@link com.smartgwt.client.widgets.tree.Tree#addList addList()}.
     * @param parent parent of children
     * @param newChildren children to be set
     * @see com.smartgwt.client.widgets.tree.Tree#removeChildren
     * @see com.smartgwt.client.data.DataSource#updateCaches
     */
    public native void setChildren(TreeNode parent, List newChildren) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setChildren", "TreeNode,List");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setChildren(parent.@com.smartgwt.client.core.DataClass::getJsObj()(), newChildren);
    }-*/;

	/**
     * Unload the children of a folder, returning the folder to the "unloaded" state.
     * @param node folder in question
     * @deprecated It's recommended that you instead use {@link com.smartgwt.client.widgets.tree.Tree#reloadChildren reloadChildren()} to
     * reload the children of a folder, or {@link com.smartgwt.client.widgets.tree.Tree#removeChildren removeChildren()} if you
     * need to clear the cached children of a folder to add specific local data.
     */
    public native void unloadChildren(TreeNode node) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "unloadChildren", "TreeNode");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.unloadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * given a hierarchy of objects with children under mixed names, heuristically discover the property that holds children
     * and copy it to a single, uniform childrenProperty.  Label each discovered child with a configurable "typeProperty" set
     * to the value of the property that held the children.
     * @param nodes list of nodes to link into the tree.
     * @param settings configures how the tree will be explored
     * @param parentChildrenField 
     */
    public static native void discoverTree(TreeNode[] nodes, DiscoverTreeSettings settings, String parentChildrenField) /*-{
        $wnd.isc.Tree.discoverTree(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), settings.@com.smartgwt.client.core.DataClass::getJsObj()(), parentChildrenField);
    }-*/;


	/**
     * heuristically find a property that appears to contain child objects. Searches through a node and find a property that is
     * either Array or Object valued.
     * @param node the node to check
     * @param mode determines how to chose the property that appears to contain child objects
     *
     * @return the name of the property that holds the children
     */
    public static native String findChildrenProperty(TreeNode node, ChildrenPropertyMode mode) /*-{
        var ret = $wnd.isc.Tree.findChildrenProperty(node.@com.smartgwt.client.core.DataClass::getJsObj()(), mode.@com.smartgwt.client.types.ChildrenPropertyMode::getValue()());
        return ret;
    }-*/;


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
     * @param treeProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Tree treeProperties) /*-{
        if (treeProperties.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Tree.@java.lang.Object::getClass()(), "setDefaultProperties", treeProperties.@java.lang.Object::getClass()());
        }
        treeProperties.@com.smartgwt.client.core.BaseClass::setConfigOnly(Z)(true);
    	var properties = treeProperties.@com.smartgwt.client.core.BaseClass::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Tree.addProperties(properties);
    }-*/;

    // ***********************************************************


   /**
     * Optional initial data for the tree. How this data is interpreted depends on this tree's {@link
     * com.smartgwt.client.widgets.tree.Tree#getModelType modelType}. <P> If <code>modelType</code> is
     * <code>"parent"</code>, the list that you provide will be passed  to {@link com.smartgwt.client.widgets.tree.Tree#linkNodes},
     * integrating the nodes into the tree. <p> In this case the root node must be supplied separately via {@link
     * com.smartgwt.client.widgets.tree.Tree#setRoot root}.
     * So for example, to create this tree:
     * <pre>foo
     *    bar
     *        zoo </pre> with modelType:"parent", you can do this:
     * <pre>
    	TreeNode root = new TreeNode("root");

    	Tree tree = new Tree();
    	tree.setRoot(root);
    	tree.setModelType(TreeModelType.PARENT);

	TreeNode data[] = new TreeNode[3];
	data[0] = new TreeNode("foo");
	data[0].setID("foo");
	data[0].setParentID("root");
	data[1] = new TreeNode("bar");
	data[1].setID("bar");
	data[1].setParentID("foo");
	data[2] = new TreeNode("zoo");
	data[2].setID("zoo");
	data[2].setParentID("bar");
	tree.setData(data);
     * </pre>
     * Specifying the root node explicitly allows you to give it a name,
     * changing the way path derivation works (see {@link com.smartgwt.client.widgets.tree.Tree#getRoot root} for more
     * on naming the root node). <P>
     * For <code>modelType:"children"</code> trees, the data passed in will be assumed to
     * be an  array of children of the tree's root node.
     *
     * @param nodes data
     * @return {@link com.smartgwt.client.widgets.tree.Tree Tree} instance, for chaining setter
     * calls
     */
    public Tree setData(TreeNode[] nodes) {
        return (Tree)setAttribute("data", nodes, false);
    }

    public ListGridRecord[] getData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        ListGridRecord[] data   = com.smartgwt.client.util.ConvertTo.arrayOfListGridRecord(dataJS);
        return data;
    }

    /**
     * For a {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree multi-link tree}, this property specifies the parent-child 
     * relationships between the nodes.  The nodes themselves are provided in {@link com.smartgwt.client.widgets.tree.Tree#getData the regular tree data}.
	 * Note that multi-link trees must specify a {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType} of "parent".
	 * <p>
	 * For a regular, non-multiLink tree, <code>linkData</code> is ignored.
	 * <p>
	 * Minimally, the link data should include a node id, parent id and optionally the position of 
	 * the child within that parent (only required if {@link com.smartgwt.client.widgets.tree.Tree#getAllowDuplicateChildren allowDuplicateChildren} is set). To
	 * describe this multi-link tree:<pre>
	 *   foo
	 *     bar
	 *       baz
	 *     zoo
	 *       bar
	 *         baz
	 * </pre>
	 * you would provide node information in the tree's <code>data</code> like this:<pre>
     *
     *  TreeNode data[] = new TreeNode[4];
     *  data[0] = new TreeNode("foo");
     *  data[0].setID("foo");
     *  data[1] = new TreeNode("bar");
     *  data[1].setID("bar");
     *  data[2] = new TreeNode("baz");
     *  data[2].setID("baz");
     *  data[3] = new TreeNode("zoo");
     *  data[3].setID("zoo");
     *  tree.setData(data);
	 * </pre>
	 * and link information in <code>linkData</code> like this:<pre>
     *
     *  Record linkData[] = new Record[4];
     *  linkData[0] = new Record();
     *  linkData[0].setAttribute("id", "bar");
     *  linkData[0].setAttribute("parentId", "foo");
     *  linkData[1] = new Record();
     *  linkData[1].setAttribute("id", "baz");
     *  linkData[1].setAttribute("parentId", "bar");
     *  linkData[2] = new Record();
     *  linkData[2].setAttribute("id", "zoo");
     *  linkData[2].setAttribute("parentId", "foo");
     *  linkData[3] = new Record();
     *  linkData[3].setAttribute("id", "bar");
     *  linkData[3].setAttribute("parentId", "zoo");
     *  tree.setLinkData(linkData);
	 * </pre>
	 * For information on databinding multi-link trees, and further discussion on multi-link trees
	 * generally, see {@link com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource ResultTree.linkDataSource}
	 *
     * @param linkData The link data
     */
    public void setLinkData(Record[] linkData) {
        setAttribute("linkData", linkData, false);
    }

    public Record[] getLinkData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("linkData");
        Record[] data = com.smartgwt.client.util.ConvertTo.arrayOfRecord(dataJS);
        return data;
    }

    /**
     * Set to true to indicate that this is a <i>multi-link</i> tree - ie, one that can contain the same node in more than one place.
     *
	 * See {@link com.smartgwt.client.widgets.tree.Tree#setLinkData Tree.linkData} and
     *{@link com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource ResultTree.linkDataSource} for more information on multi-link trees
     * @param multiLinkTree True indicates that this will be a multi-link tree
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMultiLinkTree(Boolean multiLinkTree) {
        setAttribute("multiLinkTree", multiLinkTree, false);
    }

    /**
     * If you are using the "parent" modelType and did not specify a root node via {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} with an id ({@link com.smartgwt.client.widgets.tree.Tree#getIdField
     * idField}), then you can provide the root node's id via this property. See the example in {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} for more info.
     *
     * @param rootValue rootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRootValue(String rootValue) {
        setAttribute("rootValue", rootValue, false);
    }

    /**
     * If you are using the "parent" modelType and did not specify a root node via {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} with an id ({@link com.smartgwt.client.widgets.tree.Tree#getIdField
     * idField}), then you can provide the root node's id via this property. See the example in {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} for more info.
     *
     * @param rootValue rootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRootValue(int rootValue) {
        setAttribute("rootValue", rootValue, false);
    }

    public String getRootValue() {
        return getAttribute("rootValue");
    }

    /**
     * Returns the parent of this node.
     *
     * @param node node in question
     * @return parent of this node
     */
    public native TreeNode getParent(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var parent = self.getParent(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(parent == null || parent === undefined) return null;
        var parentJ = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
        return parentJ;
    }-*/;

    /**
     * Filters this tree by the provided criteria, returning a new Tree containing just the nodes that match the criteria. <P>
     * If <code>filterMode</code> is "keepParents", parents are retained if any of their children match the criteria even if
     * those parents do not match the criteria.
     * @param criteria criteria to filter by
     *
     * @return filtered tree
     */
    public native Tree getFilteredTree(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var criteriaJ = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var ret = self.getFilteredTree(criteriaJ);
        if(ret == null) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.tree.Tree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Filters this tree by the provided criteria, returning a new Tree containing just the nodes that match the criteria. <P>
     * If <code>filterMode</code> is "keepParents", parents are retained if any of their children match the criteria even if
     * those parents do not match the criteria.
     * @param criteria criteria to filter by
     * @param filterMode mode to use for filtering, defaults to "strict"
     * @param dataSource dataSource to use for filtering, if this Tree does not                                  already have one
     *
     * @return filtered tree
     */
    public native Tree getFilteredTree(Criteria criteria, TreeFilterMode filterMode, DataSource dataSource) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var criteriaJ = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var filterModeJ = filterMode == null ? "strict" : filterMode.@com.smartgwt.client.types.TreeFilterMode::getValue()();
        var ret = self.getFilteredTree(criteriaJ, filterModeJ, dataSource.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.tree.Tree::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * This method is provided as a mechanism to link new nodes into the tree of modelType "parent".  This method
     * takes a list of nodes that must contain at a minimum a unique ID (keyed by {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField idField}) and a parent ID (keyed by {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}).  Based on this information, the list
     * of nodes is integrated into the tree structure.
     *
     * @param nodes list of nodes to link into the tree.
     */
    public native void linkNodes(TreeNode[] nodes) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes);
        self.linkNodes(nodesJS);
    }-*/;

    /**
     * Given a node, return an array of the node's parents with the immediate parent first.  The node itself is not
     * included in the result.  For example, for the following tree: <pre> root   foo     bar </pre> Calling
     * <code>tree.getParents(bar)</code> would return: <code>[foo, root]</code>.  Note that the returned array will
     * contain references to the nodes, not the names.
     *
     * @param node node in question
     * @return array of node's parents
     */
    public native TreeNode[] getParents(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getParents(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Find the node with the specified ID.  Specifically, it returns the node whose idField matches the id passed
     * to this method. If the tree is using the "parent" modelType, this lookup will be constant-time.  For all
     * other modelTypes, the tree will be searched recursively.
     *
     * @param id ID of the node to return.
     * @return node with appropriate ID, or null if not found.
     */
    public native TreeNode findById(String id) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeJS = self.findById(id);
        return nodeJS == null ? null : @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeJS);
    }-*/;

    /**
     * Find a node within this tree using a string path or by attribute value(s).  This method can be called with 1
     * or 2 arguments. If a single String argument is supplied, the value of the argument is treated as the path to
     * the node.  if a  single argument of type Object is provided, it is treated as a set of field name/value
     * pairs to search for (see {@link com.smartgwt.client..List#find}). <br> If 2 arguments are supplied, this
     * method will treat the first argument as a fieldName, and return the first node encountered where
     * <code>node[fieldName]</code>matches the second  argument.  So for example, given this tree: <pre> foo   zoo
     *   bar   moo     bar </pre> Assuming your {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim}
     * is the default <code>/</code> and <code>foo</code> is the name of the root node, then
     * <code>tree.find("foo/moo/bar")</code> would return the <code>bar</code> node under the <code>moo</code> node.
     * <br><br> <code>tree.find("name", "bar")</code> would return the first <code>bar</code> node because it is the
     * first one in the list whose <code>name</code> (default value of {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty
     * nameProperty}) property matches the value <code>bar</code>.  The two argument usage is generally more
     * interesting when your tree nodes have some custom unique property that you wish to search on.  For example if
     * your tree nodes had a unique field called "UID", their serialized form would look something like this: <pre>
     * { name: "foo", children: [...], UID:"someUniqueId"} </pre>  You could then call <code>tree.find("UID",
     * "someUniqueId")</code> to find that node.  Note that the value doesn't have to be a string - it can be any
     * valid JS value, but since this data generally comes from the server, the typical types are string, number,
     * and boolean. <br><br> The usage where you pass a single object is interesting when your tree nodes have a
     * number of custom properties that you want to search for in combination.  Say your tree nodes had  properties
     * for "color" and "shape"; <code>tree.find({color: "green", shape: "circle"})</code> would  return the first node in
     * the tree where both properties matched. <br><br> When searching by path, trailing path delimiters are
     * ignored.  So for example <code>tree.find("foo/zoo/bar")</code> is equivalent to
     * <code>tree.find("foo/zoo/bar/")</code>
     *
     * @param fieldNameOrPath Either the path to the node to be found, or the name of
     *                        a field which should match the value passed as a second
     *                        parameter
     * @return the node matching the supplied criteria or null if not found
     */
    public native TreeNode find(String fieldNameOrPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeJS =  self.find(fieldNameOrPath);
        return nodeJS == null ? null : @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeJS);
    }-*/;

    /**
     * Find a node within this tree using a string path or by attribute value(s).
     * @see #find(String)
     *
     * @param fieldNameOrPath Either the path to the node to be found, or the name of
     *                        a field which should match the value passed as a second
     *                        parameter
     * @param value           If specified, this is the desired value for the
     *                        appropriate field
     * @return the node matching the supplied criteria or null if not found
     */
    public native TreeNode find(String fieldNameOrPath, Object value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeJS = self.find(fieldNameOrPath, value);
        return nodeJS == null ? null : @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(nodeJS);
    }-*/;

    /**
     * Find a node within this tree using a string path or by attribute value(s).
     * @see #find(String)
     *
     * @param fieldNameOrPath Either the path to the node to be found, or the name of
     *                        a field which should match the value passed as a second
     *                        parameter
     * @param value           If specified, this is the desired value for the
     *                        appropriate field
     * @return the node matching the supplied criteria or null if not found
     */
    public TreeNode find(String propertyName, Date value) {
        return find(propertyName, (Object) JSOHelper.convertToJavaScriptDate(value));
    }

    /**
     * Returns all children of a node.  If the node is a leaf, this method returns null. <br><br> For load on demand
     * trees (those that only have a partial representation client-side) or for databound tree where the underlying
     * set of children is incomplete, this method will return only those nodes that have already been loaded from
     * the server.
     *
     * @param node The node whose children you want to fetch.
     * @return List of children for the node (empty List if node is a leaf or has no children)
     */
    public native TreeNode[] getChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if ($wnd.isc.isA.ResultSet(nodesJS)) {
            nodesJS = nodesJS.getAllVisibleRows();
        }
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns all the first-level folders of a node. <br><br> For load on demand trees (those that only have a
     * partial representation client-side), this method will return only nodes that have already been loaded from
     * the server.
     *
     * @param node node in question
     * @return List of immediate children that are folders
     */
    public native TreeNode[] getFolders(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Return all the first-level leaves of a node. <br><br> For load on demand trees (those that only have a
     * partial representation client-side), this method will return only nodes that have already been loaded from
     * the server.
     *
     * @param node node in question
     * @return List of immediate children that are leaves.
     */
    public native TreeNode[] getLeaves(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node.  Note: this method can be very slow, especially on large trees
     * because it assembles a list of all descendants recursively. Generally, {@link
     * com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link com.smartgwt.client.widgets.tree.Tree#getChildren}
     * will be much faster. <br><br> For load on demand trees (those that only have a partial representation
     * client-side), this method will return only nodes that have already been loaded from the server.
     *
     * @return List of descendants of the node.
     */
    public native TreeNode[] getDescendants() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendants();
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node.  Note: this method can be very slow, especially on large trees
     * because it assembles a list of all descendants recursively. Generally, {@link
     * com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link com.smartgwt.client.widgets.tree.Tree#getChildren}
     * will be much faster. <br><br> For load on demand trees (those that only have a partial representation
     * client-side), this method will return only nodes that have already been loaded from the server.
     *
     * @param node node in question (the root node is asumed if none specified)
     * @return List of descendants of the node.
     */
    public native TreeNode[] getDescendants(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(),
            nodesJS = self.getDescendants(node == null ? null : node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Ruturns the list of all descendants of a node that are folders.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except leaf nodes are not part of the returned list.
     * Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants}, this method can be very slow for large
     * trees. Generally, {@link com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link
     * com.smartgwt.client.widgets.tree.Tree#getFolders}  be much faster. <br><br> For load on demand trees (those
     * that only have a partial representation client-side), this method will return only nodes that have already
     * been loaded from the server.
     *
     * @return List of descendants of the node that are folders.
     */
    public native TreeNode[] getDescendantFolders() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantFolders();
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Ruturns the list of all descendants of a node that are folders.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except leaf nodes are not part of the returned list.
     * Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants}, this method can be very slow for large
     * trees. Generally, {@link com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link
     * com.smartgwt.client.widgets.tree.Tree#getFolders}  be much faster. <br><br> For load on demand trees (those
     * that only have a partial representation client-side), this method will return only nodes that have already
     * been loaded from the server.
     *
     * @param node node in question (the root node is assumed if none specified)
     * @return List of descendants of the node that are folders.
     */
    public native TreeNode[] getDescendantFolders(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node that are leaves.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except folders are not part of the returned list.
     * Folders are still recursed into, just not returned.  Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants},
     * this method can be very slow for large trees.  Generally, {@link com.smartgwt.client.widgets.tree.Tree#find}
     * in combination with {@link com.smartgwt.client.widgets.tree.Tree#getLeaves} be much faster. <br><br> For load
     * on demand trees (those that only have a partial representation client-side), this method will return only
     * nodes that have already been loaded from the server.
     *
     * @return List of descendants of the node that are leaves.
     */
    public native TreeNode[] getDescendantLeaves() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantLeaves();
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node that are leaves.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except folders are not part of the returned list.
     * Folders are still recursed into, just not returned.  Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants},
     * this method can be very slow for large trees.  Generally, {@link com.smartgwt.client.widgets.tree.Tree#find}
     * in combination with {@link com.smartgwt.client.widgets.tree.Tree#getLeaves} be much faster. <br><br> For load
     * on demand trees (those that only have a partial representation client-side), this method will return only
     * nodes that have already been loaded from the server.
     *
     * @param node node in question (the root node is assumed if none specified)
     * @return List of descendants of the node that are leaves.
     */
    public native TreeNode[] getDescendantLeaves(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;


    /**
     * Add a single node under the specified parent
     *
     * @param node   node to add
     * @param parent Parent of the node being added.  You can pass                                          in
     *               either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                                     the node (as a String), in which case a
     *                     {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *               the node.
     * @return The added node.
     */
    public native TreeNode add(TreeNode node, TreeNode parent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.add(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null || ret === false) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Add a single node under the specified parent
     *
     * @param node   node to add
     * @param parentPath Parent of the node being added.  You can pass in either the {@link com.smartgwt.client.widgets.tree.TreeNode}
     *               itself, or a path to the node (as a String), in which case a
     *               {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find the node.
     * @return The added node.
     */
    public native TreeNode add(TreeNode node, String parentPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.add(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parentPath);
        if(ret == null || ret === false) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Add a single node under the specified parent
     *
     * @param node     node to add
     * @param parent   Parent of the node being added.  You can pass                                          in
     *                 either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                                         the node (as a String), in which case a
     *                           {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *                 the node.
     * @param position Position of the new node in the children list. If not
     *                 specified, the node will be added at the end of the list.
     * @return The added node.
     */
    public native TreeNode add(TreeNode node, TreeNode parent, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.add(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()(), position);
        if(ret == null || ret === false) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    public native TreeNode add(TreeNode node, String parentPath, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.add(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parentPath, position);
        if(ret == null || ret === false) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Add a list of nodes to some parent.
     *
     * @param nodeList The list of nodes to add
     * @param parent   Parent of the node being added.  You can pass                                          in
     *                 either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                 the node (as a String), in which case a
     *                 {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *                 the node.
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, TreeNode parent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        var nodesJS = self.addList(nodeListJS, parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Add a list of nodes to some parent.
     *
     * @param nodeList The list of nodes to add
     * @param parentPath Parent of the node being added.  You can pass                                          in
     *                 either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                 the node (as a String), in which case a
     *                 {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *                 the node.
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, String parentPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        var nodesJS = self.addList(nodeListJS, parentPath);
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Add a list of nodes to some parent.
     *
     * @param nodeList The list of nodes to add
     * @param parent   Parent of the node being added.  You can pass                                          in
     *                 either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                                         the node (as a String), in which case a
     *                           {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *                 the node.
     * @param position Position of the new node in the children list. If not
     *                 specified, the node will be added at the end of the list.
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, TreeNode parent, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        return self.addList(nodeListJS, parent.@com.smartgwt.client.core.DataClass::getJsObj()(), position);
    }-*/;

    /**
     * Add a list of nodes to some parent.
     *
     * @param nodeList The list of nodes to add
     * @param parentPath   Parent of the node being added.  You can pass                                          in
     *                 either the {@link com.smartgwt.client.widgets.tree.TreeNode} itself, or a path to
     *                                         the node (as a String), in which case a
     *                           {@link com.smartgwt.client.widgets.tree.Tree#find} is performed to find
     *                 the node.
     * @param position Position of the new node in the children list. If not
     *                 specified, the node will be added at the end of the list.
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, String parentPath, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        return self.addList(nodeListJS, parentPath, position);
    }-*/;

    /**
     * Remove a list of nodes (not necessarily from the same parent), and all children of those nodes.
     *
     * @param nodeList list of nodes to remove
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean removeList(TreeNode[] nodeList) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        var retVal =self.removeList(nodeListJS);
        if(retVal == null) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Open a set of folders, specified by path or as pointers to nodes.
     *
     * @param nodeList List of nodes or node paths.
     */
    public native void openFolders(TreeNode[] nodeList) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        self.openFolders(nodeListJS);
    }-*/;

    /**
     * Close a set of folders, specified by path or as pointers to nodes.
     *
     * @param nodeList List of nodes or node paths.
     */
    public native void closeFolders(TreeNode[] nodeList) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        self.closeFolders(nodeListJS);
    }-*/;

    /**
     * Return a flattened list of nodes that are open under some parent, including the parent itself.  If the passed
     * in node is a leaf, this method returns null
     *
     * @param node node in question
     * @return flattened list of open nodes
     */
    public native TreeNode[] getOpenList(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getOpenList(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * A TreeNode and ListGridRecord represent similar datastructures and it is possible
     * that certain TreeGrid operations return a ListGridRecord since TreeGrid extends ListGrid.
     * So in order to call several of the methods in this Tree class, you need to coerce
     * a ListGridRecord to a TreeNode. This can be done by calling this method.
     *
     * @param record  the record
     * @return the TreeNode representation of the record
     */
    public static TreeNode nodeForRecord(ListGridRecord record) {
        if(record instanceof TreeNode) {
            return (TreeNode) record;
        } else {
            return new TreeNode(record.getJsObj());
        }
    }

     /**
     * &#010 Open a particular node&#010&#010
     *
     * @param node node to open
     */
    public native void openFolder(TreeNode node) /*-{
       var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
       self.openFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
   }-*/;

    /**
     * Get all the nodes that exist in the tree under a particular node, as a flat list, in depth-first traversal order.
     *
     * @return all the nodes that exist in the tree
     */
    public native TreeNode[] getAllNodes() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getAllNodes();
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Get all the nodes that exist in the tree under a particular node, as a flat list, in depth-first traversal order.
     * @param node optional node to start from.  Default is root.
     *
     * @return all the nodes that exist in the tree
     */
    public native TreeNode[] getAllNodes(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getAllNodes(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.util.ConvertTo::arrayOfTreeNode(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

}
