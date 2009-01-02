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

package com.smartgwt.client.types;

/**
 */

public enum TreeModelType implements ValueEnum {
    /**
     * In this model, each node has an ID unique across the whole tree and a parent ID that points to its parent.  The
     * name of the unique ID property is can be specified&#010 via ${isc.DocUtils.linkForRef('attr:Tree.idField')} and
     * the name of the parent ID property can be specified via&#010 ${isc.DocUtils.linkForRef('attr:Tree.parentIdField')}.
     *  The initial set of nodes can be passed in as a list to&#010 ${isc.DocUtils.linkForRef('attr:Tree.data')} and
     * also added as a list later via ${isc.DocUtils.linkForRef('method:Tree.linkNodes')}.&#010 Whether or not a given
     * node is a folder is determined by the value of the property specified&#010 by
     * ${isc.DocUtils.linkForRef('attr:Tree.isFolderProperty')}.&#010 <br><br>&#010 The "parent" modelType is best for
     * integrating with relational storage (because nodes can&#010 map easily to rows in a table) and collections of
     * Beans and is the model used for DataBound&#010 trees.
     */
    PARENT("parent"),
    /**
     * In this model, nodes specify their children as a list of nodes.  The property that holdes the children nodes is
     * determined by ${isc.DocUtils.linkForRef('attr:Tree.childrenProperty')}.&#010 Nodes are not required to have an ID
     * that is unique across the whole tree (in fact, no ID is&#010 required at all). Node names (specified by the
     * ${isc.DocUtils.linkForRef('attr:Tree.nameProperty')}, unique within&#010 their siblings, are optional but not
     * required.  Whether or not a given node is a folder is&#010 determined by the presense of the children list
     * (${isc.DocUtils.linkForRef('attr:Tree.childrenProperty')}).
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

