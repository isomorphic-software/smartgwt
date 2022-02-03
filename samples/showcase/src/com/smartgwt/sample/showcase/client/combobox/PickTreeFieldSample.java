package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class PickTreeFieldSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Click on \"Department\" or \"Category\" below to show hierarchical menus.</p>" +
            "<p>The \"Category\" menu loads options dynamically from the SupplyCategory DataSource. Notice how the Tree data is fetched on demand when first accessed.</p>";

    private static final TreeNode departmentRoot =
            new DepertmentTreeNode("root",
                    new DepertmentTreeNode("Marketing",
                            new DepertmentTreeNode("Advertising"),
                            new DepertmentTreeNode("Community Relations")),
                    new DepertmentTreeNode("Sales",
                            new DepertmentTreeNode("Channel Sales"),
                            new DepertmentTreeNode("Direct Sales")),
                    new DepertmentTreeNode("Manufacturing",
                            new DepertmentTreeNode("Design"),
                            new DepertmentTreeNode("Development"),
                            new DepertmentTreeNode("QA")),
                    new DepertmentTreeNode("Services",
                            new DepertmentTreeNode("Support"),
                            new DepertmentTreeNode("Consulting")));


    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            PickTreeFieldSample panel = new PickTreeFieldSample();
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

        final DynamicForm form = new DynamicForm();
        form.setWidth(300);

        Tree tree = new Tree();
        tree.setRoot(departmentRoot);

        IPickTreeItem departmentItem = new IPickTreeItem();
        departmentItem.setTitle("Department");
        departmentItem.setValueField("name");
        departmentItem.setValueTree(tree);

        SupplyCategoryXmlDS dataSource = SupplyCategoryXmlDS.getInstance();

        IPickTreeItem categoryItem = new IPickTreeItem();
        categoryItem.setTitle("Category");

        categoryItem.setDataSource(dataSource);
        categoryItem.setEmptyMenuMessage("No Sub Categories");
        categoryItem.setCanSelectParentItems(true);        
        //categoryItem.setLoadDataOnDemand(false);
        //dataSource.fetchData();
        
        form.setItems(departmentItem, categoryItem);
        
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    public static class DepertmentTreeNode extends TreeNode {

        public DepertmentTreeNode(String name) {
            setName(name);
        }

        public DepertmentTreeNode(String name, DepertmentTreeNode... children) {
            setName(name);
            setChildren(children);
        }
    }
}