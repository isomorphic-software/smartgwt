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
 * Trees that dynamically load nodes keep track of whether each node has loaded its children.
 */
public enum LoadState implements ValueEnum {
    /**
     * children have not been loaded and are not loading
     */
    UNLOADED(null),
    /**
     * currently in the process of loading
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "loading".
     */
    LOADING("loading"),
    /**
     * folders only are already loaded
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "foldersLoaded".
     */
    FOLDERS_LOADED("foldersLoaded"),
    /**
     * already fully loaded
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "loaded".
     */
    LOADED("loaded"),
    /**
     * children form a ResultSet having only a partial cache (applies only to the "paged" {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode})
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "loadedPartialChildren".
     */
    LOADED_PARTIAL_CHILDREN("loadedPartialChildren");
    private String value;

    LoadState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
