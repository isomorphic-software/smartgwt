package com.smartgwt.sample.showcase.client.portalLayout.sizing;

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
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PortletResizeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Portlets can be drag-resized by " +
                            "their edges (just like resizing Windows). " +
                            "<p>Try changing the height of Portlet 4.  Notice " +
                            "how all the Portlets in that row change height " +
                            "together. See how each column will scroll if the " +
                            "height of Portlets is resized to exceed the " +
                            "available space. " +
                            "<p>Try changing the width of Portlet 1. Notice how " +
                            "the width of the entire column changes. Now try " +
                            "changing the width of Portlet 2. See how it takes " +
                            "width from Portlet 3 rather than changing the " +
                            "column's width.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            PortletResizeSample panel = new PortletResizeSample();
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
        portalLayout.setCanResizePortlets(true);
		
        Portlet portlet1 = new Portlet();
        portlet1.setTitle("Portlet 1");
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("Portlet 2");
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("Portlet 3");
        Portlet portlet4 = new Portlet();
        portlet4.setTitle("Portlet 4");
        Portlet portlet5 = new Portlet();
        portlet5.setTitle("Portlet 5");
        Portlet portlet6 = new Portlet();
        portlet6.setTitle("Portlet 6");
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1, 0);
        portalLayout.addPortlet(portlet3, 0, 1, 1);
        portalLayout.addPortlet(portlet4, 1, 0, 0);
        portalLayout.addPortlet(portlet5, 1, 0, 1);
        portalLayout.addPortlet(portlet6, 1, 1);
	
        return portalLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
