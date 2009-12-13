package com.smartgwt.sample.showcase.client.tree.appearance;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.events.DataArrivedEvent;
import com.smartgwt.client.widgets.tree.events.DataArrivedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class TreeConnectorsSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Trees can show skinnable connector lines.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            TreeConnectorsSample panel = new TreeConnectorsSample();
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
        final TreeGrid employeeTree = new TreeGrid();
        employeeTree.setLoadDataOnDemand(false);        
        employeeTree.setWidth(500);
        employeeTree.setHeight(400);
        employeeTree.setDataSource(EmployeeXmlDS.getInstance());
        employeeTree.setAutoFetchData(true);
        employeeTree.setShowConnectors(true);       
        employeeTree.setNodeIcon("icons/16/person.png");
        employeeTree.setFolderIcon("icons/16/person.png");
        employeeTree.setShowOpenIcons(false);
        employeeTree.setShowDropIcons(false);
        employeeTree.setClosedIconSuffix("");     
        employeeTree.setBaseStyle("noBorderCell");
        employeeTree.setFields(new TreeGridField("Name"));

        employeeTree.addDataArrivedHandler(new DataArrivedHandler() {
            public void onDataArrived(DataArrivedEvent event) {
                employeeTree.getData().openAll();
            }
        });
        
        return employeeTree;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}