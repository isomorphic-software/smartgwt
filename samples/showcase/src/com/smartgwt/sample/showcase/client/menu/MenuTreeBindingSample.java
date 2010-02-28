package com.smartgwt.sample.showcase.client.menu;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ItemClickEvent;
import com.smartgwt.client.widgets.menu.events.ItemClickHandler;
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

		Canvas main = new Canvas();

		Menu mDepartment = new Menu();
		mDepartment.setCanSelectParentItems(true);
		mDepartment.setData(getLocalItemsAsArray());
		mDepartment.setWidth(130);

		mDepartment.addItemClickHandler(new ItemClickHandler() {
			public void onItemClick(ItemClickEvent event) {
				SC.say("You picked the \"" + event.getItem().getTitle()
						+ "\" department.");
			}
		});

		IMenuButton bDepartment = new IMenuButton("Go to department", mDepartment);
		bDepartment.setWidth(130);

		main.addChild(bDepartment);

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
		bCategory.setTop(30);
		bCategory.setWidth(140);

		main.addChild(bCategory);

		return main;
	}

	private MenuItem[] getLocalItemsAsArray() {

		MenuItem[] m = new MenuItem[4];

		m[0] = new MenuItem("Marketing");
		Menu menuMarketing = new Menu();
		menuMarketing.setData(new MenuItem("Advertising"), new MenuItem("Community Relations"));
		m[0].setSubmenu(menuMarketing);

		m[1] = new MenuItem("Sales");
		Menu menuSales = new Menu();
		menuSales.setData(new MenuItem("Direct Sales"),new MenuItem("Channel Sales"));
		m[1].setSubmenu(menuSales);

		m[2] = new MenuItem("Manufacturing");
		Menu menuManufacturing = new Menu();
		menuManufacturing.setData(new MenuItem("Design"), new MenuItem("Development"), new MenuItem("QA"));
		m[2].setSubmenu(menuManufacturing);

		m[3] = new MenuItem("Services");
		Menu menuServices = new Menu();
		menuServices.setData(new MenuItem("Support"), new MenuItem("Consulting"));
		m[3].setSubmenu(menuServices);

		return m;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
}