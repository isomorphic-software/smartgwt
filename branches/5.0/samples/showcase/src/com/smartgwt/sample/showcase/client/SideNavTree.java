/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * smartclient.com/license.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client;

import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;
import com.smartgwt.sample.showcase.client.data.FolderTreeNode;
import com.smartgwt.sample.showcase.client.data.ShowcaseData;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class SideNavTree extends TreeGrid {

    static final String ID_SUFFIX = "";

    static final Float releaseVersion = 
        Float.parseFloat(ShowcaseData.getCurrentReleaseVersion());

    private ExplorerTreeNode[] showcaseData;
    private Tree tree = new Tree();

    public SideNavTree() {
        setWidth100();
        setHeight100();
        setSelectionType(SelectionStyle.SINGLE);
        setCustomIconProperty("icon");
        setAnimateFolders(Browser.getIsDesktop());
        setAttribute("animateRowsMaxTime", 200, true);
        setNodeIcon("silk/application_view_list.png");
        setShowSortArrow(SortArrow.CORNER);
        setShowAllRecords(true);
        setLoadDataOnDemand(false);
        setCanSort(false);
        setShowHeader(false);

        TreeGridField field = new TreeGridField();
        field.setCanFilter(true);
        field.setName("nodeTitle");
        field.setTitle("<b>Samples</b>");
        setFields(field);

        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("nodeTitle");
        tree.setOpenProperty("isOpen");
        tree.setIdField("nodeID");
        tree.setParentIdField("parentNodeID");
        tree.setRootValue("root" + ID_SUFFIX);

        tree.setData(ShowcaseData.getData(ID_SUFFIX));

        setData(tree);
    }

    private ExplorerTreeNode[] getAllNodes() {
        return ExplorerTreeNode.arrayOfExplorerTreeNode(tree.getAllNodes());
    }
    private List<ExplorerTreeNode> getDescendants(TreeNode root) {
        return ExplorerTreeNode.listOfExplorerTreeNode(tree.getDescendants(root));
    }

    // propagate up current version tags from each sample to its parent folders;
    // this is done bottom up to ensure propagation up multiple levels
    private ExplorerTreeNode prepareMobileSamples() {
        ExplorerTreeNode mobileFolder = (ExplorerTreeNode)tree.findById("mobile");
        if (mobileFolder != null) {
            List<ExplorerTreeNode> mobileSamples = getDescendants(mobileFolder);
            Collections.reverse(mobileSamples);
            for (final ExplorerTreeNode explorerTreeNode : mobileSamples) {
                String version = explorerTreeNode.getVersion();
                if (Float.parseFloat(version) ==  releaseVersion) {
                    ((ExplorerTreeNode)tree.getParent(explorerTreeNode)).setVersion(version);
                }
            }
        }
        return mobileFolder;
    }

    public ExplorerTreeNode[] getShowcaseData() {

        if (showcaseData != null) return showcaseData;

        ExplorerTreeNode  newSamplesFolder = (ExplorerTreeNode)tree.findById("new_category");
        List<ExplorerTreeNode> newSamples  = getDescendants(newSamplesFolder);

        ExplorerTreeNode mobileSamplesFolder = prepareMobileSamples();
        Map<String,ExplorerTreeNode> mobileSamples = new HashMap<String,ExplorerTreeNode>();

        // copy new samples or mark beta samples, depending upon the current release
        for (final ExplorerTreeNode explorerTreeNode : getAllNodes()) {
            if (explorerTreeNode.getVersion() == null) {
                continue;
            } else if (Float.parseFloat(explorerTreeNode.getVersion()) >  releaseVersion) {
                explorerTreeNode.setName(explorerTreeNode.getName() + 
                    "<sup style='color: red;font-size:10px;font-weight: 700;'> BETA</sup>");
            } else if (Float.parseFloat(explorerTreeNode.getVersion()) == releaseVersion) {
                boolean exist = false;
                for (final ExplorerTreeNode explorerTreeNode1 : newSamples) {
                    // compare node names to check identify here
                    if (explorerTreeNode1.equals(explorerTreeNode)) exist = true;
                }
                if (exist) continue;

                TreeNode parent = tree.getParent(explorerTreeNode);
                ExplorerTreeNode newSampleParent = parent instanceof ExplorerTreeNode ?
                    mobileSamples.get(((ExplorerTreeNode)parent).getNodeID() + "-new") : null;

                ExplorerTreeNode copiedNode = explorerTreeNode instanceof FolderTreeNode ?
                                           new   FolderTreeNode(explorerTreeNode, ID_SUFFIX) :
                                           new ExplorerTreeNode(explorerTreeNode, ID_SUFFIX);
                // track folders marked with current version tag; these must be copied
                // with their hierarchy intact underneath the "new samples" folder
                if (tree.isFolder(explorerTreeNode)) {
                    mobileSamples.put(copiedNode.getNodeID(), copiedNode);
                }
                tree.add(copiedNode, newSampleParent != null ? newSampleParent : newSamplesFolder);
                newSamples.add(copiedNode);
            }
        }

        // remove any new mobile sample nodes without children
        for (String mobileFolderId : mobileSamples.keySet()) {
            ExplorerTreeNode explorerTreeNode = mobileSamples.get(mobileFolderId);
            if (!tree.hasChildren(explorerTreeNode)) {
                mobileSamples.remove(mobileFolderId);
                tree.remove(explorerTreeNode);
            }
        }
        // move new mobile sample root node to bottom of new samples
        if (mobileSamplesFolder != null) {
            String originalMobileFolderId = mobileSamplesFolder.getNodeID() + "-new";
            TreeNode newMobileSamplesFolder = tree.findById(originalMobileFolderId);
            if (newMobileSamplesFolder != null) {
                tree.move(newMobileSamplesFolder, newSamplesFolder);
            }
        }

        return showcaseData = getAllNodes();
    }
}
