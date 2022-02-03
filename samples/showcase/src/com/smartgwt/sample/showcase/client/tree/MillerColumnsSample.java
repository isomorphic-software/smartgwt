package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ColumnTree;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class MillerColumnsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "\n" +
            "<p>The <code>ColumnTree</code> provides an alternate navigation paradigm for Tree data," +
            "sometimes called \"Miller Columns\" and seen in Apple&#8482; iTunes&#8482;.</p> " +
            "<p>The <code>ColumnTree</code> provides identical data binding and load on demand facilities to " +
            "normal <code>TreeGrids</code>.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MillerColumnsSample panel = new MillerColumnsSample();
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
        ColumnTree columnTree = new ColumnTree();
        columnTree.setWidth100();
        columnTree.setHeight(205);
        columnTree.setDataSource(EmployeeXmlDS.getInstance());
        columnTree.setAutoFetchData(true);
        columnTree.setNodeIcon("icons/16/person.png");
        columnTree.setFolderIcon("icons/16/person.png");
        columnTree.setShowOpenIcons(false);
        columnTree.setShowDropIcons(false);
        columnTree.setClosedIconSuffix("");

        columnTree.setShowHeaders(true);
        columnTree.setShowNodeCount(true);        
        columnTree.setLoadDataOnDemand(false);
        return columnTree;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}