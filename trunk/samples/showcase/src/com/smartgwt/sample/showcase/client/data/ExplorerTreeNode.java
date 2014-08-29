package com.smartgwt.sample.showcase.client.data;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcaseConfiguration;

public class ExplorerTreeNode extends TreeNode {

    public ExplorerTreeNode(SafeHtml name, String nodeID, String parentNodeID, String icon,
            PanelFactory factory, boolean enabled, String idSuffix)
    {
        this(name.asString(), nodeID, parentNodeID, icon, factory, enabled, true, idSuffix, null);
    }

    public ExplorerTreeNode(String name, String nodeID, String parentNodeID, String icon, 
                            PanelFactory factory, boolean enabled, String idSuffix)
    {
        this(name, nodeID, parentNodeID, icon, factory, enabled, true, idSuffix, null);
    }

    public ExplorerTreeNode(String name, String nodeID, String parentNodeID, String icon, 
                            PanelFactory factory, boolean enabled, String idSuffix, String version)
    {
        this(name, nodeID, parentNodeID, icon, factory, enabled, true, idSuffix, version);
    }

    public ExplorerTreeNode(String name, String nodeID, String parentNodeID, String icon, 
               PanelFactory factory, boolean enabled, boolean testEnabled, String idSuffix, String version)
    {
        if (enabled) {
            setName(name);
        } else {
            setName("<span style='color:808080'>" + name + "</span>");
        }
        setNodeID(nodeID.replace("-", "_") + idSuffix);
        setThumbnail("thumbnails/" + nodeID.replace("-", "_") + ".gif");
        setParentNodeID(parentNodeID.replace("-", "_") + idSuffix);
        setIcon(icon);
        setVersion(version);
        setFactory(factory);

        if (!testEnabled) setTestDisabled();

        if (ShowcaseConfiguration.getSingleton().isOpenForTesting() && null != factory) {
            String className = factory.getClass().getName().replaceFirst("\\$.*$","");
            setSampleClassName(className);
        }
        
        if(nodeID.equals("featured-category") || nodeID.equals("new-category")) {
            setIsOpen(true);
        }
    }

    public ExplorerTreeNode(ExplorerTreeNode originalNode) {
        setName           (originalNode.getName());
        setNodeID         (originalNode.getNodeID());
        setThumbnail      (originalNode.getThumbnail());
        setParentNodeID   (originalNode.getParentNodeID());
        setIcon           (originalNode.getIcon());
        setVersion        (originalNode.getVersion());
        setFactory        (originalNode.getFactory());
        setSampleClassName(originalNode.getSampleClassName());
        setIsOpen         (originalNode.getIsOpen());
        if (originalNode.getTestDisabled()) setTestDisabled();
    }

    public void setSampleClassName(String name) {
        setAttribute("sampleClassName",name);
    }
    public String getSampleClassName() {
        return getAttribute("sampleClassName");
    }
    public void setVersion(String version) {
        setAttribute("version",version);
    }
    public String getVersion() {
        return getAttribute("version");
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
    public String getParentNodeID() {
        return getAttribute("parentNodeID");
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

    public Boolean getIsOpen() {
        return getAttributeAsBoolean("isOpen");
    }

    public void setIconSrc(String iconSrc) {
        setAttribute("iconSrc", iconSrc);
    }

    public String getIconSrc() {
        return getAttributeAsString("iconSrc");
    }

    public void setTestDisabled() {
        setAttribute("testDisabled", true);
    }

    public Boolean getTestDisabled() {
        return getAttributeAsBoolean("testDisabled");
    }

    // Java doesn't allow downcasting of arrays (e.g. from TreeNode[] to ExplorerTreeNode[])
    public static ExplorerTreeNode[] arrayOfExplorerTreeNode(TreeNode[] data) {
        ExplorerTreeNode[] convertedData = new ExplorerTreeNode[data.length];
        for (int i = 0; i < data.length; i++) convertedData[i] = (ExplorerTreeNode) data[i];
        return convertedData;
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
