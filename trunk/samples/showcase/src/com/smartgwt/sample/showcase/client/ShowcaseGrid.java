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

import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;
import com.smartgwt.sample.showcase.client.data.ShowcaseData;

public class ShowcaseGrid extends TreeGrid {

    public ShowcaseGrid() {
        setWidth100();
        setHeight100();
        setCustomIconProperty("icon");
        setAnimateFolderTime(100);
        setAnimateFolders(true);
        setAnimateFolderSpeed(1000);
        setNodeIcon("silk/application_view_list.png");
        setShowSortArrow(SortArrow.CORNER);
        setShowAllRecords(true);
        setLoadDataOnDemand(false);
        setCellHeight(40);
        setAlternateRecordStyles(true);
        setWrapCells(true);
        setAnimateFolders(false);
        setFixedRecordHeights(false);

        TreeGridField nameField = new TreeGridField();
        nameField.setName("name");
        nameField.setTitle("<b>Example </b>");
        nameField.setWidth(200);
        //nameField.setCanFilter(true);

        TreeGridField descriptionField = new TreeGridField();
        descriptionField.setName("name");
        descriptionField.setCanSort(false);
        descriptionField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (record instanceof ExplorerTreeNode) {
                    ExplorerTreeNode treeNode = (ExplorerTreeNode) record;
                    PanelFactory factory = treeNode.getFactory();
                    if (factory != null) {
                        return factory.getDescription();
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        });
        descriptionField.setTitle("<b>Description</b>");

        setFields(nameField, descriptionField);

        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setNameProperty("name");
        tree.setOpenProperty("isOpen");
        tree.setIdField("nodeID");
        tree.setParentIdField("parentNodeID");

        String idSuffix = "_gridview";
        tree.setRootValue("root" + idSuffix);
        TreeNode[] showcaseData = ShowcaseData.getData(idSuffix);
        tree.setData(showcaseData);

        setData(tree);
    }

    protected void onInit() {
        //getData().openAll();
    }
}