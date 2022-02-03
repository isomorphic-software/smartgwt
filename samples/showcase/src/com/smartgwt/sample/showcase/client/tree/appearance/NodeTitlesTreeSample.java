package com.smartgwt.sample.showcase.client.tree.appearance;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.ConvertTo;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

import com.google.gwt.core.client.JavaScriptObject;

public class NodeTitlesTreeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Formatter interfaces allow you to add custom tree titles.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            NodeTitlesTreeSample panel = new NodeTitlesTreeSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {

        DataSource employeeDS = EmployeeXmlDS.getInstance();

        final TreeGrid treeGrid = new TreeGrid();
        treeGrid.setWidth(500);
        treeGrid.setHeight(425);
        treeGrid.setDataSource(employeeDS);
        treeGrid.setNodeIcon("icons/16/person.png");
        treeGrid.setFolderIcon("icons/16/person.png");
        treeGrid.setShowOpenIcons(false);
        treeGrid.setShowDropIcons(false);
        treeGrid.setClosedIconSuffix("");
        treeGrid.setShowSelectedIcons(true);


        TreeGridField field = new TreeGridField();
        field.setName("Name");
        field.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttribute("Job") + ":&nbsp;" + value;
            }
        });

        treeGrid.setFields(field);

        // fetch the top level employee node in the tree and its children
        treeGrid.fetchData(null, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                TreeNode[] nodeData = ConvertTo.arrayOfTreeNode((JavaScriptObject)data);
                treeGrid.getData().openFolder(nodeData[0]);
            }
        });

        return treeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}