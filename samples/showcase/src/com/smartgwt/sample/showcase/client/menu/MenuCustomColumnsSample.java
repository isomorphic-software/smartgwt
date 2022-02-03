package com.smartgwt.sample.showcase.client.menu;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ItemClickEvent;
import com.smartgwt.client.widgets.menu.events.ItemClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MenuCustomColumnsSample extends ShowcasePanel {
    
	private static final String DESCRIPTION = "<p>Open the menu to see a standard column showing item titles, and an additional " +
            "column showing an option to close menu items.</p><p>Clicking in the second column will remove the item from the menu.</p>";

	public static class Factory implements PanelFactory {
		private String id;

		public ShowcasePanel create() {
			MenuCustomColumnsSample panel = new MenuCustomColumnsSample();
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

		final Menu menu = new Menu();
		menu.setShowShadow(true);
		menu.setShadowDepth(10);

		ListGridField closeField = new ListGridField();
		closeField.setName("canDismiss");
		closeField.setShowValueIconOnly(true);
        Map<String, String> valueIcons = new HashMap<String, String>();
        valueIcons.put("true", "icons/16/close.png");
		closeField.setValueIcons(valueIcons);
		closeField.setValueIconSize(16);
		closeField.setWidth(16);

		menu.setFields(Menu.TITLE_FIELD, closeField);

		MenuItem item1 = new MenuItem("Item 1");
		item1.setAttribute("canDismiss", false);

		MenuItem item2 = new MenuItem("Item 2");
		item2.setAttribute("canDismiss", true);

		MenuItem item3 = new MenuItem("Item 3");
		item3.setAttribute("canDismiss", true);

		menu.setData(item1, item2, item3);

		menu.addItemClickHandler(new ItemClickHandler() {
			public void onItemClick(ItemClickEvent event) {
				MenuItem clicked = event.getItem();
				if ((event.getColNum() == 1) && clicked.getAttributeAsBoolean("canDismiss")) {
                    menu.removeItem(clicked);
				} else {
					SC.say("You Selected '" + clicked.getTitle() + "'.");
				}
			}
		});

		MenuButton menuButton = new MenuButton("Show Menu", menu);

		HStack layout = new HStack();
		layout.setWidth100();
		layout.setMembers(menuButton);
		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
}