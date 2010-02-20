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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A Tree is a data model representing a set of objects linked into a hierarchy. <P> A Tree has no visual presentation, it
 * is displayed by a {@link com.smartgwt.client.widgets.tree.TreeGrid} or {@link
 * com.smartgwt.client.widgets.grid.ColumnTree} when supplied as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData
 * data} or {@link com.smartgwt.client.widgets.grid.ColumnTree#getData data}. <P> A Tree can be constructed out of a List
 * of objects interlinked by IDs or via explicitly specified Arrays of child objects.  See {@link
 * com.smartgwt.client.widgets.tree.Tree#getModelType modelType} for an explanation of how to pass data to a Tree. <P>
 * Typical usage is to call {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} to cause automatic creation of a 
 * {@link com.smartgwt.client..ResultTree}, which is a type of Tree that automatically handles loading data on  demand. 
 * For information on DataBinding Trees, see {@link com.smartgwt.client.docs.TreeDataBinding}.
 */
public class Tree extends BaseClass  implements com.smartgwt.client.widgets.tree.HasDataChangedHandlers {

    public static Tree getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Tree) obj;
        } else {
            return new Tree(jsObj);
        }
    }

    public Tree(){
        scClassName = "Tree";
    }

    public Tree(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        return $wnd.isc.Tree.create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If true, the root node is automatically opened when the tree is created or {@link
     * com.smartgwt.client.widgets.tree.Tree#setRoot} is called.
     *
     * @param autoOpenRoot autoOpenRoot Default value is true
     */
    public void setAutoOpenRoot(Boolean autoOpenRoot) {
        setAttribute("autoOpenRoot", autoOpenRoot, true);
    }

    /**
     * If true, the root node is automatically opened when the tree is created or {@link
     * com.smartgwt.client.widgets.tree.Tree#setRoot} is called.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoOpenRoot()  {
        return getAttributeAsBoolean("autoOpenRoot");
    }

    /**
     * For trees with the modelType "children", this property specifies the name of the property that contains the list of
     * children for a node.
     *
     * @param childrenProperty childrenProperty Default value is "children"
     */
    public void setChildrenProperty(String childrenProperty) {
        setAttribute("childrenProperty", childrenProperty, true);
    }

    /**
     * For trees with the modelType "children", this property specifies the name of the property that contains the list of
     * children for a node.
     *
     *
     * @return String
     */
    public String getChildrenProperty()  {
        return getAttributeAsString("childrenProperty");
    }

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will be considered folders by
     * default.  Other nodes will be considered folders or leaves by default according to this setting.
     *
     * @param defaultIsFolder defaultIsFolder Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDefaultIsFolder(Boolean defaultIsFolder)  throws IllegalStateException {
        setAttribute("defaultIsFolder", defaultIsFolder, false);
    }

    /**
     * Controls whether nodes are assumed to be folders or leaves by default. <P> Nodes that have children or have the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} set to true will be considered folders by
     * default.  Other nodes will be considered folders or leaves by default according to this setting.
     *
     *
     * @return Boolean
     */
    public Boolean getDefaultIsFolder()  {
        return getAttributeAsBoolean("defaultIsFolder");
    }

    /**
     * Title assigned to nodes without a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} value or
     * a {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} value.
     *
     * @param defaultNodeTitle defaultNodeTitle Default value is "Untitled"
     */
    public void setDefaultNodeTitle(String defaultNodeTitle) {
        setAttribute("defaultNodeTitle", defaultNodeTitle, true);
    }

    /**
     * Title assigned to nodes without a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} value or
     * a {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} value.
     *
     *
     * @return String
     */
    public String getDefaultNodeTitle()  {
        return getAttributeAsString("defaultNodeTitle");
    }

    /**
     * If this tree has {@link com.smartgwt.client.widgets.tree.Tree#getModelType 'modelType:"parent"'}, should nodes in the
     * data array for the tree be dropped if they have an explicitly specified value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't match any other nodes in the tree.
     * If set to false these nodes will be added as children of the root node.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param discardParentlessNodes discardParentlessNodes Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDiscardParentlessNodes(Boolean discardParentlessNodes)  throws IllegalStateException {
        setAttribute("discardParentlessNodes", discardParentlessNodes, false);
    }

    /**
     * If this tree has {@link com.smartgwt.client.widgets.tree.Tree#getModelType 'modelType:"parent"'}, should nodes in the
     * data array for the tree be dropped if they have an explicitly specified value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} which doesn't match any other nodes in the tree.
     * If set to false these nodes will be added as children of the root node.
     *
     *
     * @return Boolean
     */
    public Boolean getDiscardParentlessNodes()  {
        return getAttributeAsBoolean("discardParentlessNodes");
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds an id for the node which is
     * unique across the entire Tree.  Required for all nodes for trees with modelType "parent". Default value is "id".  See
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getId id} for usage.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param idField idField Default value is "id"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setIdField(String idField)  throws IllegalStateException {
        setAttribute("idField", idField, false);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds an id for the node which is
     * unique across the entire Tree.  Required for all nodes for trees with modelType "parent". Default value is "id".  See
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getId id} for usage.
     *
     *
     * @return String
     */
    public String getIdField()  {
        return getAttributeAsString("idField");
    }

    /**
     * Name of property that defines whether a node is a folder.  By default this is set to {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder isFolder}.
     *
     * @param isFolderProperty isFolderProperty Default value is "isFolder"
     */
    public void setIsFolderProperty(String isFolderProperty) {
        setAttribute("isFolderProperty", isFolderProperty, true);
    }

    /**
     * Name of property that defines whether a node is a folder.  By default this is set to {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder isFolder}.
     *
     *
     * @return String
     */
    public String getIsFolderProperty()  {
        return getAttributeAsString("isFolderProperty");
    }
             
    /**
     * Selects the model used to construct the tree representation.  See {@link com.smartgwt.client.types.TreeModelType} for
     * the available options and their implications. <P> If the "parent" modelType is used, you can provide the initial
     * parent-linked data set to the tree via the {@link com.smartgwt.client.widgets.tree.Tree#getData data} attribute.  If the
     * "children" modelType is used, you can provide the initial tree structure to the Tree via the {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} attribute.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param modelType modelType Default value is "children"
     */
    public void setModelType(TreeModelType modelType) {
        setAttribute("modelType", modelType.getValue(), true);
    }

    /**
     * Selects the model used to construct the tree representation.  See {@link com.smartgwt.client.types.TreeModelType} for
     * the available options and their implications. <P> If the "parent" modelType is used, you can provide the initial
     * parent-linked data set to the tree via the {@link com.smartgwt.client.widgets.tree.Tree#getData data} attribute.  If the
     * "children" modelType is used, you can provide the initial tree structure to the Tree via the {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root} attribute.
     *
     *
     * @return TreeModelType
     */
    public TreeModelType getModelType()  {
        return EnumUtil.getEnum(TreeModelType.values(), getAttribute("modelType"));
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds a name for the node that is
     * unique among it's immediate siblings, thus allowing a unique path to be used to identify the node, similar to a file
     * system.  Default value is "name".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} for usage.
     *
     * @param nameProperty nameProperty Default value is "name"
     */
    public void setNameProperty(String nameProperty) {
        setAttribute("nameProperty", nameProperty, true);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds a name for the node that is
     * unique among it's immediate siblings, thus allowing a unique path to be used to identify the node, similar to a file
     * system.  Default value is "name".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} for usage.
     *
     *
     * @return String
     */
    public String getNameProperty()  {
        return getAttributeAsString("nameProperty");
    }

    /**
     * The property consulted by the default implementation of {@link com.smartgwt.client.widgets.tree.Tree#isOpen} to
     * determine if the node is open or not.  By default, this property is auto-generated for you, but you can set it to a
     * custom value if you want to declaratively specify this state, but be careful - if you display this Tree in multiple
     * TreeGrids at the same time, the open state will not be tracked independently - see {@link
     * com.smartgwt.client.docs.SharingNodes} for more info on this.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param openProperty openProperty Default value is null
     */
    public void setOpenProperty(String openProperty) {
        setAttribute("openProperty", openProperty, true);
    }

    /**
     * The property consulted by the default implementation of {@link com.smartgwt.client.widgets.tree.Tree#isOpen} to
     * determine if the node is open or not.  By default, this property is auto-generated for you, but you can set it to a
     * custom value if you want to declaratively specify this state, but be careful - if you display this Tree in multiple
     * TreeGrids at the same time, the open state will not be tracked independently - see {@link
     * com.smartgwt.client.docs.SharingNodes} for more info on this.
     *
     *
     * @return String
     */
    public String getOpenProperty()  {
        return getAttributeAsString("openProperty");
    }

    /**
     * For trees with modelType "parent", this property specifies the name of the property that contains the unique parent ID
     * of a node.  Default value is "parentId".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getParentId parentId} for
     * usage.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param parentIdField parentIdField Default value is "parentId"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setParentIdField(String parentIdField)  throws IllegalStateException {
        setAttribute("parentIdField", parentIdField, false);
    }

    /**
     * For trees with modelType "parent", this property specifies the name of the property that contains the unique parent ID
     * of a node.  Default value is "parentId".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getParentId parentId} for
     * usage.
     *
     *
     * @return String
     */
    public String getParentIdField()  {
        return getAttributeAsString("parentIdField");
    }

    /**
     * Specifies the delimiter between node names.  The pathDelim is used to construct a unique&#010 path to each node. A path
     * can be obtained for any node by calling&#010 {@link com.smartgwt.client.widgets.tree.Tree#getPath} and can be used to
     * find any node in the tree by calling&#010 {@link com.smartgwt.client.widgets.tree.Tree#find}.  Note that you can also
     * hand-construct a path - in other words&#010 you are not required to call {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath} in order to later use&#010 {@link
     * com.smartgwt.client.widgets.tree.Tree#find} to retrieve it.&#010 <br><br>&#010 The pathDelim can be any character or
     * sequence of characters, but must be a unique string&#010 with respect to the text that can appear in the {@link
     * com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} that's used&#010 for naming the nodes.  So for
     * example, if you have the following tree:&#010 <pre>&#010 one&#010   two&#010     three/four&#010 </pre>&#010 Then you
     * will be unable to find the <code>three/four</code> node using&#010 {@link com.smartgwt.client.widgets.tree.Tree#find} if
     * your tree is using the default pathDelim of /.&#010 In such a case, you can use a different pathDelim for the tree.  For
     * example if you used |&#010 for the path delim, then you can find the <code>three/four</code> node in the tree above
     * by&#010 calling <code>tree.find("one|two|three/four")</code>.&#010 <br><br>&#010 The pathDelim is used only by {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath} and {@link com.smartgwt.client.widgets.tree.Tree#find} and&#010 does not
     * affect any aspect of the tree structure or other forms of tree navigation (such as&#010 via {@link
     * com.smartgwt.client.widgets.tree.Tree#getChildren}).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pathDelim pathDelim Default value is "/"
     */
    public void setPathDelim(String pathDelim) {
        setAttribute("pathDelim", pathDelim, true);
    }

    /**
     * Specifies the delimiter between node names.  The pathDelim is used to construct a unique&#010 path to each node. A path
     * can be obtained for any node by calling&#010 {@link com.smartgwt.client.widgets.tree.Tree#getPath} and can be used to
     * find any node in the tree by calling&#010 {@link com.smartgwt.client.widgets.tree.Tree#find}.  Note that you can also
     * hand-construct a path - in other words&#010 you are not required to call {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath} in order to later use&#010 {@link
     * com.smartgwt.client.widgets.tree.Tree#find} to retrieve it.&#010 <br><br>&#010 The pathDelim can be any character or
     * sequence of characters, but must be a unique string&#010 with respect to the text that can appear in the {@link
     * com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty} that's used&#010 for naming the nodes.  So for
     * example, if you have the following tree:&#010 <pre>&#010 one&#010   two&#010     three/four&#010 </pre>&#010 Then you
     * will be unable to find the <code>three/four</code> node using&#010 {@link com.smartgwt.client.widgets.tree.Tree#find} if
     * your tree is using the default pathDelim of /.&#010 In such a case, you can use a different pathDelim for the tree.  For
     * example if you used |&#010 for the path delim, then you can find the <code>three/four</code> node in the tree above
     * by&#010 calling <code>tree.find("one|two|three/four")</code>.&#010 <br><br>&#010 The pathDelim is used only by {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath} and {@link com.smartgwt.client.widgets.tree.Tree#find} and&#010 does not
     * affect any aspect of the tree structure or other forms of tree navigation (such as&#010 via {@link
     * com.smartgwt.client.widgets.tree.Tree#getChildren}).
     *
     *
     * @return String
     */
    public String getPathDelim()  {
        return getAttributeAsString("pathDelim");
    }

    /**
     * If new nodes are added to a tree with modelType:"parent" which have the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField 'id field value'} as existing nodes, the existing nodes are removed
     * when the new nodes are added. <P> If reportCollisions is true, the Tree will log a warning in the developer console
     * about this. <P> Note that if an id collision occurs between a new node and its ancestor, the ancestor will be removed
     * and the new node will not be added to the tree.
     *
     * @param reportCollisions reportCollisions Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setReportCollisions(Boolean reportCollisions)  throws IllegalStateException {
        setAttribute("reportCollisions", reportCollisions, false);
    }

    /**
     * If new nodes are added to a tree with modelType:"parent" which have the same {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField 'id field value'} as existing nodes, the existing nodes are removed
     * when the new nodes are added. <P> If reportCollisions is true, the Tree will log a warning in the developer console
     * about this. <P> Note that if an id collision occurs between a new node and its ancestor, the ancestor will be removed
     * and the new node will not be added to the tree.
     *
     *
     * @return Boolean
     */
    public Boolean getReportCollisions()  {
        return getAttributeAsBoolean("reportCollisions");
    }
            
    /**
     * If you're using the "parent" modelType, you can provide the root node configuration via this&#010 property.  If you
     * don't provide it, one will be auto-created for you with an empty name.&#010 Read on for a description of what omitting
     * the name property on the root node means for path&#010 derivation.&#010 <p>&#010 If you're using the "children"
     * modelType, you can provide the initial tree data via this&#010 property.  So, for example, to construct the following
     * tree:&#010 <pre>&#010 foo&#010   bar&#010 zoo&#010 </pre>&#010 You would initialize the tree as follows: &#010
     * <pre>&#010 Tree.create({&#010     root: { name:"root", children: [&#010         { name:"foo", children: [&#010          
     * { name: "bar" }&#010         ]},&#010         { name: "zoo" }&#010     ]}&#010 });&#010 </pre>&#010 Note that if you
     * provide a <code>name</code> property for the root node, then the path to&#010 any node underneath it will start with
     * that name.  So in the example above, the path to the&#010 <code>bar</code> node would be <code>root/foo/bar</code>
     * (assuming you're using the default&#010 {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim}.  If you
     * omit the name attribute on the root node, then it's name&#010 is automatically set to the {@link
     * com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim} value.  So in the example above, if&#010 you omitted
     * <code>name:"root"</code>, then the path to the <code>bar</code> node would be&#010 <code>/foo/bar</code>.&#010
     * <br><br>&#010 Note: if you initialize a Tree with no <code>root</code> value, a root node will be&#010 auto-created for
     * you.  You can then call {@link com.smartgwt.client.widgets.tree.Tree#add} to construct the tree.
     * Set the root node of the tree.
     *
     * @param root new root node. Default value is null
     */
    public void setRoot(TreeNode root) {
        setAttribute("root", root.getJsObj(), true);
    }

    /**
     * If you're using the "parent" modelType, you can provide the root node configuration via this&#010 property.  If you
     * don't provide it, one will be auto-created for you with an empty name.&#010 Read on for a description of what omitting
     * the name property on the root node means for path&#010 derivation.&#010 <p>&#010 If you're using the "children"
     * modelType, you can provide the initial tree data via this&#010 property.  So, for example, to construct the following
     * tree:&#010 <pre>&#010 foo&#010   bar&#010 zoo&#010 </pre>&#010 You would initialize the tree as follows: &#010
     * <pre>&#010 Tree.create({&#010     root: { name:"root", children: [&#010         { name:"foo", children: [&#010          
     * { name: "bar" }&#010         ]},&#010         { name: "zoo" }&#010     ]}&#010 });&#010 </pre>&#010 Note that if you
     * provide a <code>name</code> property for the root node, then the path to&#010 any node underneath it will start with
     * that name.  So in the example above, the path to the&#010 <code>bar</code> node would be <code>root/foo/bar</code>
     * (assuming you're using the default&#010 {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim}.  If you
     * omit the name attribute on the root node, then it's name&#010 is automatically set to the {@link
     * com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim} value.  So in the example above, if&#010 you omitted
     * <code>name:"root"</code>, then the path to the <code>bar</code> node would be&#010 <code>/foo/bar</code>.&#010
     * <br><br>&#010 Note: if you initialize a Tree with no <code>root</code> value, a root node will be&#010 auto-created for
     * you.  You can then call {@link com.smartgwt.client.widgets.tree.Tree#add} to construct the tree.
     *
     *
     * @return Returns the root node of the tree.
     */
    public TreeNode getRoot()  {
        return TreeNode.getOrCreateRef(getAttributeAsJavaScriptObject("root"));
    }

    /**
     * Controls whether a call to {@link com.smartgwt.client.widgets.tree.Tree#getOpenList} includes the root node.  Since view
     * components such as {@link com.smartgwt.client.widgets.tree.TreeGrid} use <code>getOpenList()</code> to display the
     * currently visible tree, <code>showRoot</code> controls whether the root node is shown to the user. <P> All Trees must
     * have a single, logical root, however, most applications want to show multiple nodes at the top level. 
     * <code>showRoot:false</code>, the default setting, prevents the logical root from being shown, so that the displayed tree
     * begins with the children of root. <P> You can set <code>showRoot:true</code> to show the single, logical root node as
     * the only top-level node.  This property is only meaningful for Trees where you supplied a value for {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root}, otherwise, you will see an automatically generated root node that
     * is meaningless to the user.
     *
     * @param showRoot showRoot Default value is false
     */
    public void setShowRoot(Boolean showRoot) {
        setAttribute("showRoot", showRoot, true);
    }

    /**
     * Controls whether a call to {@link com.smartgwt.client.widgets.tree.Tree#getOpenList} includes the root node.  Since view
     * components such as {@link com.smartgwt.client.widgets.tree.TreeGrid} use <code>getOpenList()</code> to display the
     * currently visible tree, <code>showRoot</code> controls whether the root node is shown to the user. <P> All Trees must
     * have a single, logical root, however, most applications want to show multiple nodes at the top level. 
     * <code>showRoot:false</code>, the default setting, prevents the logical root from being shown, so that the displayed tree
     * begins with the children of root. <P> You can set <code>showRoot:true</code> to show the single, logical root node as
     * the only top-level node.  This property is only meaningful for Trees where you supplied a value for {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root}, otherwise, you will see an automatically generated root node that
     * is meaningless to the user.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRoot()  {
        return getAttributeAsBoolean("showRoot");
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds the title of the node as it
     * should be shown to the user.  Default value is "title".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle
     * title} for usage.
     *
     * @param titleProperty titleProperty Default value is "title"
     */
    public void setTitleProperty(String titleProperty) {
        setAttribute("titleProperty", titleProperty, true);
    }

    /**
     * Name of the property on a {@link com.smartgwt.client.widgets.tree.TreeNode} that holds the title of the node as it
     * should be shown to the user.  Default value is "title".  See {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle
     * title} for usage.
     *
     *
     * @return String
     */
    public String getTitleProperty()  {
        return getAttributeAsString("titleProperty");
    }

    // ********************* Methods ***********************
            
    /**
     * Close all nodes under a particular node
     */
    public native void closeAll() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeAll();
    }-*/;

    /**
     * Close all nodes under a particular node
     * @param node node from which to close folders (if not specified, the root                              node is used)
     */
    public native void closeAll(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeAll(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Closes a folder
     * @param node folder to close
     */
    public native void closeFolder(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.closeFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    /**
     * Add a dataChanged handler.
     * <p>
     * Called when the structure of this tree is changed in any way.  Intended to be observed. <br><br> Note that on a big
     * change (many items being added or deleted) this may be called multiple times
     *
     * @param handler the dataChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataChangedHandler(com.smartgwt.client.widgets.tree.DataChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.DataChangedEvent.getType()) == 0) setupDataChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.DataChangedEvent.getType());
    }

    private native void setupDataChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({dataChanged:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.tree.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.dataChanged = $entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.tree.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                });
            }
   }-*/;
            
    /**
     * Returns the number of items in the current open list.
     *
     * @return number of items in open list
     */
    public native int getLength() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getLength();
    }-*/;
            
    /**
     * &#010 Return the number of levels deep this node is in the tree.  For example, for this tree:&#010 <pre>&#010 root&#010 
     *  foo&#010     bar&#010 </pre>&#010 Calling <code>tree.getLevel(bar)</code> will return <code>2</code>. &#010&#010
     * @param node node in question
     *
     * @return number of parents the node has
     */
    public native int getLevel(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getLevel(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Get the 'name' of a node.  This is node[{@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}].  If
     * that value has not been set on the node, a unique value (within this parent) will be auto-generated and returned.
     * @param node node in question
     *
     * @return name of the node
     */
    public native String getName(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getName(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Given a node, return the path to it's parent.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getPath} except the node itself is not reported as part of the path.
     * @param node node in question
     *
     * @return path to the node's parent
     */
    public native String getParentPath(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getParentPath(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * &#010 Returns the path of a node - a path has the following format:&#010 <code>([name][pathDelim]?)*</code>&#010
     * <br><br>&#010 For example, in this tree:&#010 <pre>&#010 root&#010   foo&#010     bar&#010 </pre>&#010 Assuming that
     * {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim} is the default <code>/</code>, the
     * <code>bar</code>&#010 node would have the path <code>root/foo/bar</code> and the path for the <code>foo</code>&#010 node
     * would be <code>root/foo</code>.&#010 <br><br>&#010 Once you have a path to a node, you can call find(path) to retrieve a
     * reference to the node&#010 later.&#010&#010
     * @param node node in question
     *
     * @return path to the node
     */
    public native String getPath(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getPath(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Return the title of a node -- the name as it should be presented to the user.  This method works as follows: <ul> <li>
     * If a {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty} is set on the node, the value of that
     * property is returned. <li> Otherwise, if the {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}
     * is set on the node, that value is returned, minus any trailing {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim
     * pathDelim}. <li> Finally, if none of the above yielded a title, the value of {@link
     * com.smartgwt.client.widgets.tree.Tree#getDefaultNodeTitle defaultNodeTitle} is returned. </ul> You can override this
     * method to return the title of your choice for a given node. <br><br> To override the title for an auto-constructed tree
     * (for example, in a databound TreeGrid), override {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeTitle} instead.
     * @param node node for which the title is being requested
     *
     * @return title to display
     */
    public native String getTitle(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Returns true if this node has any children.
     * @param node node in question
     *
     * @return true if the node has children
     */
    public native Boolean hasChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.hasChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Return true if this this node has any children that are folders.
     * @param node node in question
     *
     * @return true if the node has children that are folders
     */
    public native Boolean hasFolders(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.hasFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Return whether this node has any children that are leaves.
     * @param node node in question
     *
     * @return true if the node has children that are leaves
     */
    public native Boolean hasLeaves(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.hasLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Is one node a descendant of the other?
     * @param child child node
     * @param parent parent node
     *
     * @return true == parent is an ancestor of child
     */
    public native Boolean isDescendantOf(TreeNode child, TreeNode parent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isDescendantOf(child.@com.smartgwt.client.core.DataClass::getJsObj()(), parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Determines whether a particular node is a folder.  The logic works as follows:<br><br> <ul> <li> If the {@link
     * com.smartgwt.client.widgets.tree.TreeNode} has a value for the {@link
     * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty isFolderProperty} ({@link
     * com.smartgwt.client.widgets.tree.TreeNode#getIsFolder isFolder} by default) that value is returned. <li> Next, the
     * existence of the {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty} (by default {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getChildren children}) is checked on the {@link
     * com.smartgwt.client.widgets.tree.TreeNode}.  If the node has the children property defined (regardless of whether it
     * actually has any children), then isFolder() returns true for that node. </ul> <P> You can override this method to
     * provide your own interpretation of what constitutes a folder.
     * @param node node in question
     *
     * @return true if the node is a folder
     */
    public native Boolean isFolder(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isFolder(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns true if the passed in node is a leaf.
     * @param node node in question
     *
     * @return true if the node is a leaf
     */
    public native Boolean isLeaf(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isLeaf(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Whether a particular node is open or closed (works for leaves and folders).
     * @param node node in question
     *
     * @return true if the node is open
     */
    public native Boolean isOpen(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isOpen(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Return true if the passed node is the root node.
     * @param node node to test
     *
     * @return true if the node is the root node
     */
    public native Boolean isRoot(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isRoot(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Moves the specified node to a new parent.
     * @param node node to move
     * @param newParent new parent to move the node to
     */
    public native void move(TreeNode node, TreeNode newParent) /*-{
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
    public native void move(TreeNode node, TreeNode newParent, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.move(node.@com.smartgwt.client.core.DataClass::getJsObj()(), newParent.@com.smartgwt.client.core.DataClass::getJsObj()(), position);
    }-*/;
            
    /**
     * Open all nodes under a particular node.
     */
    public native void openAll() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll();
    }-*/;

    /**
     * Open all nodes under a particular node.
     * @param node node from which to open folders (if not specified, the root                              node is used)
     */
    public native void openAll(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.openAll(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Reload the children of a node
     * @param node node in question
     */
    public native void reloadChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.reloadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Removes a node, along with all its children.
     * @param node node to remove
     *
     * @return true if the tree was changed as a result of this call
     */
    public native Boolean remove(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.remove(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Unload the children of a node
     * @param node node in question
     */
    public native void unloadChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.unloadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************


    /**
     * Optional initial data for the tree. How this data is interpreted depends on this tree's {@link
     * com.smartgwt.client.widgets.tree.Tree#getModelType modelType}. <P> If <code>modelType</code> is
     * <code>"parent"</code>, the list that you provide will be passed  to {@link com.smartgwt.client.widgets.tree.Tree#linkNodes},
     * integrating the nodes into the tree. <p> In this case the root node must be supplied separately via {@link
     * com.smartgwt.client.widgets.tree.Tree#getRoot root}, or you may instead provide the <code>id</code> of the root
     * node via {@link com.smartgwt.client.widgets.tree.Tree#getRootValue rootValue}.  So for example, to create this
     * tree: <pre> foo   bar zoo </pre> with modelType:"parent", you can do this: <pre> Tree.create({   root: {id:
     * "root"},   data: [     {name: "foo", id: "foo", parentId: "root"},     {name: "bar", id: "bar", parentId:
     * "foo"},
     * {name: "zoo", id: "zoo", parentId: "root"} }); </pre> Or this: <pre> Tree.create({   rootValue: "root",
     * data: [     {name: "foo", id: "foo", parentId: "root"},     {name: "bar", id: "bar", parentId: "foo"},     {name:
     * "zoo", id: "zoo", parentId: "root"} }); </pre> Specifying the root node explicitly allows you to give it a name,
     * changing the way path derivation works (see {@link com.smartgwt.client.widgets.tree.Tree#getRoot root} for more
     * on naming the root node). <P> For <code>modelType:"children"</code> trees, the data passed in will be assumed to
     * be an  array of children the tree's root node.
     *
     * @param data data Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setData(TreeNode[] nodes) {
        setAttribute("data", nodes, false);
    }

  public ListGridRecord[] getData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        ListGridRecord[] data = convertToTreeNodeRecordArray(dataJS);
        return data;
    }

    private static ListGridRecord[] convertToTreeNodeRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridRecord[] objects = new ListGridRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            ListGridRecord obj = (ListGridRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new TreeNode(componentJS);
            objects[i] = obj;
        }
        return objects;
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
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
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
     * for "color" and "shape"; <code>tree.find({color: "green", shape: "circle"}) would  return the first node in
     * the tree where both properties matched. <br><br> When searching by path, trailing path delimiters are
     * ignored.  So for example <code>tree.find("foo/zoo/bar")</code> is equivalent to
     * <code>tree.find("foo/zoo/bar/")</code>
     *
     * @param fieldNameOrPath Either the path to the node to be found, or the name of
     *                              a field which should match the value passed as a second
     *                        parameter
     * @return the node matching the supplied criteria or null if not found
     */
    public native TreeNode find(String fieldNameOrPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeJS =  self.find(fieldNameOrPath);
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
     * for "color" and "shape"; <code>tree.find({color: "green", shape: "circle"}) would  return the first node in
     * the tree where both properties matched. <br><br> When searching by path, trailing path delimiters are
     * ignored.  So for example <code>tree.find("foo/zoo/bar")</code> is equivalent to
     * <code>tree.find("foo/zoo/bar/")</code>
     *
     * @param fieldNameOrPath Either the path to the node to be found, or the name of
     *                              a field which should match the value passed as a second
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
     * Returns all children of a node.  If the node is a leaf, this method returns null. <br><br> For load on demand
     * trees (those that only have a partial representation client-side), this method will return only nodes that
     * have already been loaded from the server.  Furthermore, for databound trees the return value will be a {@link
     * com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @param node The node whose children you want to fetch.
     * @return List of children for the node (empty List if node is a leaf                      or has no children)
     */
    public native TreeNode[] getChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns all the first-level folders of a node. <br><br> For load on demand trees (those that only have a
     * partial representation client-side), this method will return only nodes that have already been loaded from
     * the server.  Furthermore, for databound trees the return value will be a {@link
     * com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @param node node in question
     * @return List of immediate children that are folders
     */
    public native TreeNode[] getFolders(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Return all the first-level leaves of a node. <br><br> For load on demand trees (those that only have a
     * partial representation client-side), this method will return only nodes that have already been loaded from
     * the server.  Furthermore, for databound trees the return value will be a {@link
     * com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @param node node in question
     * @return List of immediate children that are leaves.
     */
    public native TreeNode[] getLeaves(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node.  Note: this method can be very slow, especially on large trees
     * because it assembles a list of all descendants recursively. Generally, {@link
     * com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link com.smartgwt.client.widgets.tree.Tree#getChildren}
     * will be much faster. <br><br> For load on demand trees (those that only have a partial representation
     * client-side), this method will return only nodes that have already been loaded from the server.  Furthermore,
     * for databound trees the return value will be a {@link com.smartgwt.client.data.ResultSet}, so it's 
     * to access the return value using the ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a
     * native Javascript Array.
     *
     * @return List of descendants of the node.
     */
    public native TreeNode[] getDescendants() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendants();
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node.  Note: this method can be very slow, especially on large trees
     * because it assembles a list of all descendants recursively. Generally, {@link
     * com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link com.smartgwt.client.widgets.tree.Tree#getChildren}
     * will be much faster. <br><br> For load on demand trees (those that only have a partial representation
     * client-side), this method will return only nodes that have already been loaded from the server.  Furthermore,
     * for databound trees the return value will be a {@link com.smartgwt.client.data.ResultSet}, so it's 
     * to access the return value using the ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a
     * native Javascript Array.
     *
     * @param node node in question (the root node is asumed if none specified)
     * @return List of descendants of the node.
     */
    public native TreeNode[] getDescendants(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendants(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Ruturns the list of all descendants of a node that are folders.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except leaf nodes are not part of the returned list.
     * Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants}, this method can be very slow for large
     * trees. Generally, {@link com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link
     * com.smartgwt.client.widgets.tree.Tree#getFolders}  be much faster. <br><br> For load on demand trees (those
     * that only have a partial representation client-side), this method will return only nodes that have already
     * been loaded from the server.  Furthermore, for databound trees the return value will be a {@link
     * com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @return List of descendants of the node that are folders.
     */
    public native TreeNode[] getDescendantFolders() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantFolders();
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Ruturns the list of all descendants of a node that are folders.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except leaf nodes are not part of the returned list.
     * Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants}, this method can be very slow for large
     * trees. Generally, {@link com.smartgwt.client.widgets.tree.Tree#find} in combination with {@link
     * com.smartgwt.client.widgets.tree.Tree#getFolders}  be much faster. <br><br> For load on demand trees (those
     * that only have a partial representation client-side), this method will return only nodes that have already
     * been loaded from the server.  Furthermore, for databound trees the return value will be a {@link
     * com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @param node node in question (the root node is assumed if none specified)
     * @return List of descendants of the node that are folders.
     */
    public native TreeNode[] getDescendantFolders(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantFolders(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node that are leaves.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except folders are not part of the returned list.
     * Folders are still recursed into, just not returned.  Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants},
     * this method can be very slow for large trees.  Generally, {@link com.smartgwt.client.widgets.tree.Tree#find}
     * in combination with {@link com.smartgwt.client.widgets.tree.Tree#getLeaves} be much faster. <br><br> For load
     * on demand trees (those that only have a partial representation client-side), this method will return only
     * nodes that have already been loaded from the server.  Furthermore, for databound trees the return value will
     * be a {@link com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @return List of descendants of the node that are leaves.
     */
    public native TreeNode[] getDescendantLeaves() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantLeaves();
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Returns the list of all descendants of a node that are leaves.  This works just like {@link
     * com.smartgwt.client.widgets.tree.Tree#getDescendants}, except folders are not part of the returned list.
     * Folders are still recursed into, just not returned.  Like {@link com.smartgwt.client.widgets.tree.Tree#getDescendants},
     * this method can be very slow for large trees.  Generally, {@link com.smartgwt.client.widgets.tree.Tree#find}
     * in combination with {@link com.smartgwt.client.widgets.tree.Tree#getLeaves} be much faster. <br><br> For load
     * on demand trees (those that only have a partial representation client-side), this method will return only
     * nodes that have already been loaded from the server.  Furthermore, for databound trees the return value will
     * be a {@link com.smartgwt.client.data.ResultSet}, so it's 
     * ${isc.DocUtils.linkForRef('interface:List')} interface instead of as a native Javascript Array.
     *
     * @param node node in question (the root node is assumed if none specified)
     * @return List of descendants of the node that are leaves.
     */
    public native TreeNode[] getDescendantLeaves(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getDescendantLeaves(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
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
        if(ret == null || ret === undefined || ret === false) return null;
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
        if(ret == null || ret === undefined || ret === false) return null;
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
        if(ret == null || ret === undefined || ret === false) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    public native TreeNode add(TreeNode node, String parentPath, int position) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.add(node.@com.smartgwt.client.core.DataClass::getJsObj()(), parentPath, position);
        if(ret == null || ret === undefined || ret === false) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, TreeNode parent) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        var nodesJS = self.addList(nodeListJS, parent.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
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
     * @return List of added nodes.
     */
    public native TreeNode[] addList(TreeNode[] nodeList, String parentPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodeListJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodeList);
        var nodesJS = self.addList(nodeListJS, parentPath);
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
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
        if(retVal == null || retVal === undefined) {
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
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    private static TreeNode[] convertToTreeNodeArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new TreeNode[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        TreeNode[] objects = new TreeNode[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            TreeNode obj = TreeNode.getOrCreateRef(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

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
     * Load the children of a given node.&#010&#010    This implementation does nothing other than mark the node as loaded&#010
     *
     * @param node node in question
     */
    public native void loadChildren(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.loadChildren(node.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

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
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

    /**
     * Get all the nodes that exist in the tree under a particular node, as a flat list, in depth-first traversal order.
     * @param node optional node to start from.  Default is root.
     *
     * @return all the nodes that exist in the tree
     */
    public native TreeNode getAllNodes(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var nodesJS = self.getAllNodes(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return @com.smartgwt.client.widgets.tree.Tree::convertToTreeNodeArray(Lcom/google/gwt/core/client/JavaScriptObject;)(nodesJS);
    }-*/;

}



