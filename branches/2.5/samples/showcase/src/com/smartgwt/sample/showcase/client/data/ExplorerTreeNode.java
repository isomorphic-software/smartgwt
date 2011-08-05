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
        setThumbnail("thumbnails/" + nodeID.replace("-", "_") + ".gif");
        setParentNodeID(parentNodeID.replace("-", "_") + idSuffix);
        setIcon(icon);

        setFactory(factory);
        
        if(nodeID.equals("featured-category") || nodeID.equals("new-category")) {
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
        setAttribute("nodeTitle", name);
    }

    public String getName() {
        return getAttributeAsString("nodeTitle");
    }

    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    public String getIcon() {
        return getAttributeAsString("icon");
    }

    public void setThumbnail(String thumbnail) {
        setAttribute("thumbnail", thumbnail);
    }

    public String getThumbnail() {
        return getAttributeAsString("thumbnail");
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExplorerTreeNode that = (ExplorerTreeNode) o;

        if (!getName().equals(that.getName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
