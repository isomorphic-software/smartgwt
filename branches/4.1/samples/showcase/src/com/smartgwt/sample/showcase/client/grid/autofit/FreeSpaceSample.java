package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class FreeSpaceSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>By default, grids used in a Layout will fill available space, allowing users to show and hide " +
            "other components on the screen in order to view and interact with more data at once in the grid.</p>" +
            "<p>Imagine that the blue outline represents all the space that is available for this interface. Click on the \"Details\" header to hide " +
            "the tabs and reveal more rows.</p><p>Click on the resizebar next to the Navigation tree to hide it, allowing more space for columns.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FreeSpaceSample panel = new FreeSpaceSample();
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

        DataSource dataSource = ItemSupplyXmlDS.getInstance();

        final ListGrid listGrid = new ListGrid();
        listGrid.setUseAllDataSourceFields(true);
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);

        TabSet tabSet = new TabSet();
        Tab viewTab = new Tab("View");

        Canvas viewLabel = new Canvas();
        viewLabel.setContents("[Record Details can be dispalyed here]");
        viewTab.setPane(viewLabel);

        Tab editTab = new Tab("Edit");

        Canvas editLabel = new Canvas();
        editLabel.setContents("[Form for edits can be dispalyed here]");
        editTab.setPane(editLabel);

        tabSet.setTabs(viewTab, editTab);

        TreeGrid treeGrid = new TreeGrid();
        treeGrid.setWidth("30%");
        treeGrid.setShowConnectors(true);
        treeGrid.setShowResizeBar(true);

        Tree data = new Tree();
        data.setModelType(TreeModelType.CHILDREN);
        data.setRoot(new TreeNode("root",
                new TreeNode("File"),
                new TreeNode("Edit"),
                new TreeNode("Search"),
                new TreeNode("Project"),
                new TreeNode("Tools"),
                new TreeNode("Window"),
                new TreeNode("Favourites")));

        treeGrid.setData(data);
        
        TreeGridField field = new TreeGridField("Navigation");
        field.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return record.getAttribute("name");
            }
        });
        treeGrid.setFields(field);

        HLayout navLayout = new HLayout();
        navLayout.setMembers(treeGrid, listGrid);

        SectionStack sectionStack = new SectionStack();        
        sectionStack.setWidth(600);
        sectionStack.setHeight(400);
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setAnimateSections(true);
        sectionStack.setOverflow(Overflow.HIDDEN);

        SectionStackSection summarySection = new SectionStackSection();
        summarySection.setTitle("Summary");
        summarySection.setExpanded(true);
        summarySection.setItems(navLayout);

        SectionStackSection detailsSection = new SectionStackSection();
        detailsSection.setTitle("Details");
        detailsSection.setExpanded(true);
        detailsSection.setItems(tabSet);

        sectionStack.setSections(summarySection, detailsSection);


        return sectionStack;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}