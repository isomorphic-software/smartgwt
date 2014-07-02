package com.smartgwt.sample.showcase.client.forms;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PickTreeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on \"Department\" or \"Category\" below to show hierarchical menus. The "+
            "\"Category\" menu loads options dynamically from the \"SupplyCategory\" DataSource.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	PickTreeSample panel = new PickTreeSample();
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

    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {
        
        TreeNode children[] = new TreeNode[4];
        children[0] = new TreeNode();
        children[0].setTitle("Marketing");
        children[0].setChildren(new TreeNode[] {
            new TreeNode("Advertising"),
            new TreeNode("Community Relations")
        });
        children[1] = new TreeNode();
        children[1].setTitle("Sales");
        children[1].setChildren(new TreeNode[] {
            new TreeNode("Channel Sales"),
            new TreeNode("Direct Sales")
		});
        children[2] = new TreeNode();
        children[2].setTitle("Manufacturing");
        children[2].setChildren(new TreeNode[] {
            new TreeNode("Design"),
            new TreeNode("Development"),
            new TreeNode("QA")
		});
        children[3] = new TreeNode();
        children[3].setTitle("Services");
        children[3].setChildren(new TreeNode[] {
            new TreeNode("Support"),
            new TreeNode("Consulting")
		});
        TreeNode rootNode = new TreeNode();
        rootNode.setName("root");
        rootNode.setChildren(children);
		
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.CHILDREN);
        tree.setRoot(rootNode);
		
        final DynamicForm form = new DynamicForm();
		
        PickTreeItem pickDepartment = new PickTreeItem();
        pickDepartment.setTitle("Department");
        pickDepartment.setName("department");
        pickDepartment.setValueField("name");
        pickDepartment.setValueTree(tree);
		
        DataSource ds = SupplyCategoryXmlDS.getInstance();
        PickTreeItem pickCategory = new PickTreeItem();
        pickCategory.setTitle("Category");
        pickCategory.setName("category");
        pickCategory.setDataSource(ds);
        pickCategory.setEmptyMenuMessage("No Sub Categories");
        pickCategory.setCanSelectParentItems(true);
		
		form.setFields(pickDepartment, pickCategory);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
