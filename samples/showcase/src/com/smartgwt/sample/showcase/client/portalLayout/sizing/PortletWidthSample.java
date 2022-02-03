package com.smartgwt.sample.showcase.client.portalLayout.sizing;

import java.util.LinkedHashMap;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PortletWidthSample extends ShowcasePanel {
    private static final String DESCRIPTION = "PortalLayouts distribute available column width amongst Portlets equally, or by the "+
        "sizes that are specified (like an ordinary Layout).<P>"+
        "By default, the PortalLayout will add width to the last (or only) Portlet in a row in order to always fill the row. This "+
        "can be changed by turning preventRowUnderflow off. ";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            PortletWidthSample panel = new PortletWidthSample();
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
        portalLayout.setNumColumns(1);
	
        Portlet portlet1 = new Portlet();
        portlet1.setTitle("width: 150");
        portlet1.setWidth(150);
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("width: 200");
        portlet2.setWidth(200);
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("padding", "10");
        portlet2.setBodyDefaults(map);
        Label label = new Label();
        label.setValign(VerticalAlignment.TOP);
        label.setContents("Notice how the PortalLayout will stretch the last Portlet to fill the available space, if <code>preventRowUnderflow</code> is set.");
        portlet2.addItem(label);
		
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("width: \"30%\"");
        portlet3.setWidth("30%");
        Portlet portlet4 = new Portlet();
        portlet4.setTitle("width: \"70%\"");
        portlet4.setWidth("70%");
		
        portalLayout.addPortlet(portlet1, 0, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 0, 1);
        portalLayout.addPortlet(portlet3, 0, 1, 0);
        portalLayout.addPortlet(portlet4, 0, 1, 1);
		
        DynamicForm form = new DynamicForm();
        CheckboxItem checkbox = new CheckboxItem();
        checkbox.setTitle("Prevent Row Underflow");
        checkbox.setDefaultValue(true);
        checkbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setPreventRowUnderflow((Boolean)event.getValue());
            }
        });
        form.setFields(checkbox);
		
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
