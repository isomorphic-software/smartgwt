package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ViewLoader;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsViewLoadingSample extends ShowcasePanel {
	private static final String DESCRIPTION = "Click on \"Tab2\" to load a grid view on the fly. Declarative view loading " +
            "allows extremely large applications to be split into separately loadable chunks, and creates an easy integration " +
            "path for applications with server-driven application flow.";

	public static class Factory implements PanelFactory {
		private String id;

		public ShowcasePanel create() {
			TabsViewLoadingSample panel = new TabsViewLoadingSample();
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

		final TabSet topTabSet = new TabSet();
		topTabSet.setTabBarPosition(Side.TOP);
		topTabSet.setTabBarAlign(Side.LEFT);
		topTabSet.setTop(40);
		topTabSet.setWidth(400);
		topTabSet.setHeight(250);

		final Tab tab1 = new Tab("Tab1");
		Canvas tab1Content = new Canvas();
		tab1Content.setContents("Contents of Tab1");
		tab1.setPane(tab1Content);
		topTabSet.addTab(tab1);

		final Tab tab2 = new Tab("Tab2");
		ViewLoader tab2loader = new ViewLoader();
		tab2loader.setLoadingMessage("Loading Grid..");
		tab2loader.setViewURL("data/dataIntegration/json/loadedView.js");
		tab2.setPane(tab2loader);
		topTabSet.addTab(tab2);

		VLayout vLayout = new VLayout();
		vLayout.setMembersMargin(15);
		vLayout.addMember(topTabSet);
		vLayout.setHeight("auto");

		return vLayout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
}