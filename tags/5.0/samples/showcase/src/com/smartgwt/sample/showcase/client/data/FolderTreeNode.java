/*
 * Isomorphic SmartGWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */

package com.smartgwt.sample.showcase.client.data;

public class FolderTreeNode extends ExplorerTreeNode {

    private String description;

    public FolderTreeNode(String name, String nodeID, String parentNodeID, String icon, 
                          boolean enabled, String idSuffix) 
    {
        super(name, nodeID, parentNodeID, icon, null, enabled, idSuffix);
    }
    
    public FolderTreeNode(String name, String nodeID, String parentNodeID, String icon, 
                          boolean enabled, String idSuffix, String version) {
        super(name, nodeID, parentNodeID, icon, null, enabled, true, idSuffix, version);
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FolderTreeNode(ExplorerTreeNode originalNode, String idSuffix) {
        super(originalNode, idSuffix);
        setDescription(((FolderTreeNode)originalNode).getDescription());
    }

}
