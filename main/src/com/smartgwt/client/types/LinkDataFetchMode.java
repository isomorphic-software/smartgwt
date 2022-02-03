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
public enum LinkDataFetchMode implements ValueEnum {
    /**
     * In this mode, link data is fetched from the {@link com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource
     * ResultTree.linkDataSource} and nodes are separately fetched from the  {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getDataSource ResultTree.dataSource}. The two fetches are sent together in a
     * {@link com.smartgwt.client.rpc.RPCManager#startQueue queue}, with the link data fetch first and the separate  node fetch
     * second. This makes it possible for your server-side code to use the results of the link data fetch to constrain the node
     * fetch (ie, only fetch node information  for nodes that appear in a link)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "separate".
     */
    SEPARATE("separate"),
    /**
     * In this mode, nodes and link data are fetched together from the main {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getDataSource ResultTree.dataSource}, and any duplicated node IDs are
     * handled by creating multiple links to a single node. In this mode, the {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getLinkDataSource ResultTree.linkDataSource} is only used for update
     * operations. <p> Note that the end result of a "single" fetch is exactly the same as fetching link data  and nodes
     * separately using "separate" mode; "separate" mode is also conceptually clearer since it emphasises the fact that nodes
     * and link data are separate things. We provide "single" mode because, in some cases, it may be more efficient to fetch
     * the two types of data together in a single database fetch, using {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom DataSourceField.includeFrom} or  some other kind of join
     * technique on the server.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "single".
     */
    SINGLE("single");
    private String value;

    LinkDataFetchMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
