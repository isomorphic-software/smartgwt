package com.smartgwt.client.types;


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
 
/**
 */
public enum TreeModelType implements ValueEnum {
    /**
     * In this model, each node has an ID unique across the whole tree and a parent ID that points to its parent. The name of
     * the unique ID property can be specified via {@link com.smartgwt.client.widgets.tree.Tree#getIdField idField} and the
     * name of the parent ID property can be specified via {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField
     * parentIdField}. The initial set of nodes can be passed in as a list to {@link
     * com.smartgwt.client.widgets.tree.Tree#getData data} and also added as a list later via {@link
     * com.smartgwt.client.widgets.tree.Tree#linkNodes Tree.linkNodes}. Whether or not a given node is a folder is determined
     * by the value of the property specified by {@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}. <br><br> The "parent" modelType is best for integrating with relational storage (because nodes can
     * map easily to rows in a table) and collections of Beans and is the model used for DataBound trees.
     */
    PARENT("parent"),
    /**
     * In this model, nodes specify their children as a list of nodes. The property that holds the children nodes is determined
     * by {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty}. Nodes are not required to have an
     * ID that is unique across the whole tree (in fact, no ID is required at all). Node names (specified by the {@link
     * com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}, unique within their siblings, are optional but not
     * required. Whether or not a given node is a folder is determined by the presence of the children list ({@link
     * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty}).
     */
    CHILDREN("children");
    private String value;

    TreeModelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
