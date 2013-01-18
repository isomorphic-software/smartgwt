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

public class OverflowSample extends ShowcasePanel {
    private static final String DESCRIPTION = "If a Portlet is resized to be wider than its column, the column will stretch to accommodate "+
        "the Portlet. Other columns may shrink to compensate, if their Portlets do not require the whole width. <P>"+
        "Try making Portlet 1 wider. By default, its column stretches to accommodate, and the next column shrinks. (Stretching can be prevented "+
        "by turning off canStretchColumnWidths, and shrinking can be prevented by turning off canShrinkColumnWidths). Then, trying moving Portlet "+
        "1 to the second colum. Note how the columns change width to accommodate. Then, close Portlet 1. Note how the columns return to their "+
        "original widths. <P>"+
        "If the Portlets are too wide for the PortalLayout as a whole, the PortalLayout will scroll horizontally, if canStretchColumnWidths "+
        "is enabled. Otherwise, individual rows of Portlets will scroll. ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            OverflowSample panel = new OverflowSample();
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
        portalLayout.setCanResizePortlets(true);
        portalLayout.setCanResizeColumns(true);
		
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
		
        DynamicForm form = new DynamicForm();
        CheckboxItem canStretchColumnWidthsCheckbox = new CheckboxItem();
        canStretchColumnWidthsCheckbox.setTitle("Can Stretch Column Widths");
        canStretchColumnWidthsCheckbox.setDefaultValue(true);
        canStretchColumnWidthsCheckbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setCanStretchColumnWidths((Boolean)event.getValue());
            }
        });
        CheckboxItem canShrinkColumnWidthsCheckbox = new CheckboxItem();
        canShrinkColumnWidthsCheckbox.setTitle("Can Shrink Column Widths");
        canShrinkColumnWidthsCheckbox.setDefaultValue(true);
        canShrinkColumnWidthsCheckbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                portalLayout.setCanShrinkColumnWidths((Boolean)event.getValue());
            }
        });
        form.setFields(canStretchColumnWidthsCheckbox, canShrinkColumnWidthsCheckbox);
		
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