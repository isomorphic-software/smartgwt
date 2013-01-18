package com.smartgwt.sample.showcase.client.portalLayout.portletContents;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgProperties;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowContentsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "A Porlet is a subclass of Window, so its contents can be defined in any of the ways "+
        "that work for Windows. ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowContentsSample panel = new WindowContentsSample();
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

    @Override
    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {
        PortalLayout portalLayout = new PortalLayout();
        portalLayout.setWidth100();
        portalLayout.setHeight100();
		
        Portlet portlet1 = new Portlet();
        portlet1.setTitle("src: 'http://www.wikipedia.com");
        portlet1.setSrc("http://en.wikipedia.org/wiki/Ajax_(mythology)");
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("src: 'http://www.smartclient.com");
        portlet2.setSrc("http://www.smartclient.com/");
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("items");
		
        ListGrid listGrid = new ListGrid();
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        listGrid.setFields(nameField, capitalField);
        listGrid.setData(CountrySampleData.getRecords());
        portlet3.addItem(listGrid);
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1);
        portalLayout.addPortlet(portlet3, 1, 0);
		
        return portalLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}