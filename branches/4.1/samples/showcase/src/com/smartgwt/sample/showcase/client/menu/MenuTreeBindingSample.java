package com.smartgwt.sample.showcase.client.menu;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ItemClickEvent;
import com.smartgwt.client.widgets.menu.events.ItemClickHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class MenuTreeBindingSample extends ShowcasePanel {	
	private static final String DESCRIPTION = "Click on \"Department\" or \"Category\" below to show hierarchical menus." +
            " The \"Category\" menu loads options dynamically from the SupplyCategory DataSource.";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			MenuTreeBindingSample panel = new MenuTreeBindingSample();
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

		VStack vLayout = new VStack(10);

		Menu mDepartment = new Menu();
		mDepartment.setCanSelectParentItems(true);
		mDepartment.setData(getLocalItemsAsTree());
		mDepartment.setWidth(130);

		mDepartment.addItemClickHandler(new ItemClickHandler() {
			public void onItemClick(ItemClickEvent event) {
				SC.say("You picked the \"" + event.getTreeNode().getName()
						+ "\" department.");
			}
		});

		IMenuButton bDepartment = new IMenuButton("Go to department", mDepartment);
		bDepartment.setWidth(140);

		vLayout.addMember(bDepartment);

		Menu mCategory = new Menu();
		mCategory.setCanSelectParentItems(true);
		mCategory.setDataSource(SupplyCategoryXmlDS.getInstance());
		mCategory.setWidth(130);

		mCategory.addItemClickHandler(new ItemClickHandler() {
			public void onItemClick(ItemClickEvent event) {
				MenuItem item = event.getItem();
				SC.say("You picked the \""
						+ item.getAttributeAsString("categoryName")
						+ "\" category.");
			}
		});

		IMenuButton bCategory = new IMenuButton("Go to category", mCategory);
		bCategory.setWidth(140);

		vLayout.addMember(bCategory);

		HStack layout = new HStack();
		layout.setWidth100();
		layout.setMembers(vLayout);
		return layout;
	}

	private Tree getLocalItemsAsTree() {
		Tree retVal = new Tree();
		
		TreeNode[] treeNodes = new TreeNode[4];
		
		treeNodes[0] = new TreeNode("Marketing");
		Tree menuMarketing = new Tree();
		menuMarketing.setData(new TreeNode[]{new TreeNode("Advertising"), new TreeNode("Community Relations")});
		treeNodes[0].setChildren(menuMarketing.getAllNodes());
		
		treeNodes[1] = new TreeNode("Sales");
		Tree menuSales = new Tree();
		menuSales.setData(new TreeNode[]{new TreeNode("Direct Sales"), new TreeNode("Channel Sales")});
		treeNodes[1].setChildren(menuSales.getAllNodes());
		
		treeNodes[2] = new TreeNode("Manufacturing");
		Tree menuManufacturing = new Tree();
		menuManufacturing.setData(new TreeNode[]{new TreeNode("Design"), new TreeNode("Development"), new TreeNode("QA")});
		treeNodes[2].setChildren(menuManufacturing.getAllNodes());

		treeNodes[3] = new TreeNode("Services");
		Tree menuServices = new Tree();
		menuServices.setData(new TreeNode[]{new TreeNode("Support"), new TreeNode("Consulting")});
		treeNodes[3].setChildren(menuServices.getAllNodes());
		
		retVal.setData(treeNodes);
		
		return retVal;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
}