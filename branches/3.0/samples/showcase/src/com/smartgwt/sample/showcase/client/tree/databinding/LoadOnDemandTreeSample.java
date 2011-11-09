package com.smartgwt.sample.showcase.client.tree.databinding;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class LoadOnDemandTreeSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Begin opening folders and note the prompt which briefly appears during server fetches.</p>" +
        "<p>DataBound Trees support load on demand. When a folder is opened for the first time, the tree asks the server for the children " +
        "of the node just opened.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            LoadOnDemandTreeSample panel = new LoadOnDemandTreeSample();
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
        TreeGrid employeeTreeGrid = new TreeGrid();
        employeeTreeGrid.setWidth(500);
        employeeTreeGrid.setHeight(400);
        employeeTreeGrid.setNodeIcon("icons/16/person.png");
        employeeTreeGrid.setFolderIcon("icons/16/person.png");
        employeeTreeGrid.setShowOpenIcons(false);
        employeeTreeGrid.setShowDropIcons(false);
        employeeTreeGrid.setClosedIconSuffix("");
        employeeTreeGrid.setAutoFetchData(true);
        employeeTreeGrid.setDataSource(EmployeeXmlDS.getInstance());
        
        return employeeTreeGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}