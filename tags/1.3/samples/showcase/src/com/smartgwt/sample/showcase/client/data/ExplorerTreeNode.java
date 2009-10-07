package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;

public class ExplorerTreeNode extends TreeNode {

    public ExplorerTreeNode(String name, String nodeID, String parentNodeID, String icon, PanelFactory factory, boolean enabled, String idSuffix) {
        if (enabled) {
            setName(name);
        } else {
            setName("<span style='color:808080'>" + name + "</span>");
        }
        setNodeID(nodeID.replace("-", "_") + idSuffix);
        setParentNodeID(parentNodeID.replace("-", "_") + idSuffix);
        setIcon(icon);
        setFactory(factory);
        //temp hack
        if(nodeID.equals("featured-category")) {
            setIsOpen(true);
        }
    }

    public void setFactory(PanelFactory factory) {
        setAttribute("factory", factory);
    }

    public PanelFactory getFactory() {
        return (PanelFactory) getAttributeAsObject("factory");
    }

    public void setNodeID(String value) {
        setAttribute("nodeID", value);
    }

    public String getNodeID() {
        return getAttribute("nodeID");
    }

    public void setParentNodeID(String value) {
        setAttribute("parentNodeID", value);
    }

    public void setName(String name) {
        setAttribute("name", name);
    }

    public String getName() {
        return getAttributeAsString("name");
    }

    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    public String getIcon() {
        return getAttributeAsString("icon");
    }

    public void setIsOpen(boolean isOpen) {
        setAttribute("isOpen", isOpen);
    }

    public void setIconSrc(String iconSrc) {
        setAttribute("iconSrc", iconSrc);
    }

    public String getIconSrc() {
        return getAttributeAsString("iconSrc");
    }

}
