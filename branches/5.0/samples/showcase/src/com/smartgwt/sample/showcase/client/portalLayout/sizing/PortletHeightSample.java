package com.smartgwt.sample.showcase.client.portalLayout.sizing;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgProperties;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class PortletHeightSample extends ShowcasePanel {
    private static final String DESCRIPTION = "PortalLayouts distribute available column height amongst Portlets equally, or by "+
        "the sizes that are specified (like an ordinary Layout).<P>"+
        "By default, the PortalLayout will add space to the last Portlet in a column, if needed to fill that column. This can be "+
        "changed by turning preventColumnUnderflow off.  ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            PortletHeightSample panel = new PortletHeightSample();
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
        portlet1.setTitle("height: 100");
        portlet1.setHeight(100);
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("height: 100");
        portlet2.setHeight(100);
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("padding", "10");
        portlet2.setBodyDefaults(map);
        Label label = new Label();
        label.setValign(VerticalAlignment.TOP);
        label.setContents("Notice how the PortalLayout will stretch the last Portlet to fill the vertical space, if <code>preventColumnUnderflow</code> is set.");
        portlet2.addItem(label);
		
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("height: \"30%\"");
        portlet3.setHeight("30%");
        Portlet portlet4 = new Portlet();
        portlet4.setTitle("height: \"70%\"");
        portlet4.setHeight("70%");
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1);
        portalLayout.addPortlet(portlet3, 1, 0);
        portalLayout.addPortlet(portlet4, 1, 1);
	
        DynamicForm form = new DynamicForm();
        CheckboxItem checkbox = new CheckboxItem();
        checkbox.setTitle("Prevent Column Underflow");
        checkbox.setDefaultValue(true);
        checkbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setPreventColumnUnderflow((Boolean)event.getValue());
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
