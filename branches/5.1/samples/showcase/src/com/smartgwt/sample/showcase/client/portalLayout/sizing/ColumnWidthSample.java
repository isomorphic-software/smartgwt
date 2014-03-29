package com.smartgwt.sample.showcase.client.portalLayout.sizing;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgProperties;
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

public class ColumnWidthSample extends ShowcasePanel {
    private static final String DESCRIPTION = "By default, PortalLayouts make their columns equal width. Resize bars can be displayed "+
        "to allow the user to change column widths. <P>"+
        "Try dragging the resize bar, and see how the columns change width.<P> "+
        "Try making both columns smaller. By default, the PortalLayout will extend the last column to fill the available width "+
        "(preventing underflow). This behavior can be changed with the preventUnderflow attribute. <P>"+
        "Try making both columns bigger. By default, the PortalLayout will scroll if the columns overflow the available width. ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ColumnWidthSample panel = new ColumnWidthSample();
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
        portalLayout.setCanResizeColumns(true);
		
        Portlet portlet1 = new Portlet();
        portlet1.setTitle("Portlet 1");
        Portlet portlet2 = new Portlet();
        portlet2.setTitle("Portlet 2");
        Portlet portlet3 = new Portlet();
        portlet3.setTitle("Portlet 3");
        Portlet portlet4 = new Portlet();
        portlet4.setTitle("Portlet 4");
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1, 0);
        portalLayout.addPortlet(portlet3, 0, 1, 1);
        portalLayout.addPortlet(portlet4, 1, 0);
	
        DynamicForm form = new DynamicForm();
        CheckboxItem checkbox = new CheckboxItem();
        checkbox.setTitle("Prevent Underflow");
        checkbox.setDefaultValue(true);
        checkbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setPreventUnderflow((Boolean)event.getValue());
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