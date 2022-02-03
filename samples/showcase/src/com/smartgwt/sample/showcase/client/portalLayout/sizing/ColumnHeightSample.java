package com.smartgwt.sample.showcase.client.portalLayout.sizing;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ColumnHeightSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The Portlets on the left have a height which requires the PortalLayout to scroll. "+
        "By default, each column scrolls individually. If the large Portlets are dragged to the right column, then it will scroll. "+
        "PortalLayouts respect the height that has been set for Portlets and scroll columns if necessary. <P>"+
        "If it is preferred to have the whole PortalLayout scroll together, try setting the columnOverflow to \"visible\". Other "+
        "combinations of overflow and columnOverflow are also possible. ";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ColumnHeightSample panel = new ColumnHeightSample();
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
        final PortalLayout portalLayout = new PortalLayout();
        portalLayout.setWidth100();
        portalLayout.setHeight(350);
		
        Portlet portlet1 = new Portlet();
        portlet1.setTitle("Large Portlet");
        portlet1.setHeight(200);
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("Large Portlet");
        portlet2.setHeight(200);
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("Small Portlet");
        portlet3.setHeight(100);
        Portlet portlet4 = new Portlet();
        portlet4.setTitle("Small Portlet");
        portlet4.setHeight(100);
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1);
        portalLayout.addPortlet(portlet3, 1, 0);
        portalLayout.addPortlet(portlet4, 1, 1);
		
        DynamicForm form = new DynamicForm();
        SelectItem columnOverflowSelect = new SelectItem();
        columnOverflowSelect.setTitle("columnOverflow");
        columnOverflowSelect.setValueMap("AUTO", "VISIBLE", "HIDDEN");
        columnOverflowSelect.setDefaultValue("AUTO");
        columnOverflowSelect.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setColumnOverflow(Overflow.valueOf((String)event.getValue()));
            }
        });
        SelectItem overflowSelect = new SelectItem();
        overflowSelect.setTitle("overflow");
        overflowSelect.setValueMap("AUTO", "VISIBLE", "HIDDEN");
        overflowSelect.setDefaultValue("AUTO");
        overflowSelect.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setOverflow(Overflow.valueOf((String)event.getValue()));
            }
        });
        form.setFields(columnOverflowSelect, overflowSelect);
	
        VLayout vLayout = new VLayout();
        vLayout.setWidth100();
        vLayout.setHeight100();
        vLayout.setMembersMargin(10);
        vLayout.addMembers(form, portalLayout);
		
        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}