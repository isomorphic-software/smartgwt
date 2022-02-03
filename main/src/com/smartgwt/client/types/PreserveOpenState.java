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
/* sgwtgen */
 
/**
 */
public enum PreserveOpenState implements ValueEnum {
    /**
     * Never try to automatically preserve the openState. Nodes will be initially open  or closed based solely on the {@link
     * com.smartgwt.client.widgets.tree.Tree#getOpenProperty Tree.openProperty} optionally set by the server.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "never".
     */
    NEVER("never"),
    /**
     * If either the {@link com.smartgwt.client.widgets.tree.Tree#getIdField Tree.idField} or {@link
     * com.smartgwt.client.widgets.tree.Tree#getNameProperty Tree.nameProperty} has been set on  the Tree, (so that nodes have
     * either unique ids or unique paths),  preserve openState by respecting the {@link
     * com.smartgwt.client.widgets.tree.Tree#getOpenProperty Tree.openProperty} set by the server,  then applying the
     * openState.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "whenUnique".
     */
    WHENUNIQUE("whenUnique"),
    /**
     * Like "whenUnique" but automatically preserves openState even if nodes cannot be uniquely identified. This means that
     * nodes at the same tree positions  (eg 3rd child of 5th node under root) will be placed in the same openState, 
     * regardless of whether that node has anything to do with the node that previously  was at that tree position.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "always".
     */
    ALWAYS("always");
    private String value;

    PreserveOpenState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
