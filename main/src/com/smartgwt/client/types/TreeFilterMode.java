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
 
package com.smartgwt.client.types;

/**
 * Mode for applying criteria to a tree.
 */
public enum TreeFilterMode implements ValueEnum {
    /**
     * only nodes that actually match criteria are shown. If a parent does not match the criteria, it will not be shown, even
     * if it has children that do match the criteria
     */
    STRICT("strict"),
    /**
     * parent nodes are kept if they have children which match the criteria, or, in a tree with  loadDataOnDemand:true, if they
     * have not loaded children yet.
     */
    KEEP_PARENTS("keepParents");

    private String value;

    TreeFilterMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
