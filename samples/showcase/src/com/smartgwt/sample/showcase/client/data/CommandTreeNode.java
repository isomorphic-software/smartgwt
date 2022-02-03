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

package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.sample.showcase.client.Command;

public class CommandTreeNode extends ExplorerTreeNode {

    public CommandTreeNode(String name, String nodeID, String parentNodeID, String icon, Command command, boolean enabled, String idSuffix) {
        super(name, nodeID, parentNodeID, icon, null, enabled, idSuffix);
        setCommand(command);
    }

    public void setCommand(Command command) {
        setAttribute("command", command);
    }

    public Command getCommand() {
        return (Command) getAttributeAsObject("command");
    }
}
