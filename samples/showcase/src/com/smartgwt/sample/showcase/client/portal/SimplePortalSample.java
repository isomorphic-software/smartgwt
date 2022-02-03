package com.smartgwt.sample.showcase.client.portal;

import com.google.gwt.user.client.Random;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SimplePortalSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Animations built into Smart GWT layouts can be used to create a drag and drop portal experience. " +
            "Drag portlets around to new locations and they animate into place. ";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SimplePortalSample panel = new SimplePortalSample();
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

    //FCKEditor like colors
    private static String[] colors = new String[]{
            "FF6600", "808000", "008000", "008080", "0000FF", "666699",
            "FF0000", "FF9900", "99CC00", "339966", "33CCCC", "3366FF",
            "800080", "969696", "FF00FF", "FFCC00", "FFFF00", "00FF00",
            "00FFFF", "00CCFF", "993366", "C0C0C0", "FF99CC", "FFCC99",
            "FFFF99", "CCFFCC", "CCFFFF", "99CCFF", "CC99FF", "FFFFFF"
    };

    public Canvas getViewPanel() {
        final PortalLayout portalLayout = new PortalLayout(3);
        portalLayout.setWidth100();  
        portalLayout.setHeight100();
        portalLayout.setColumnBorder("0");
        portalLayout.setOverflow(Overflow.VISIBLE);
        portalLayout.setColumnOverflow(Overflow.VISIBLE);
        portalLayout.setPreventColumnUnderflow(false);
        portalLayout.setMembersMargin(6);
        // create portlets...  
        for (int i = 0; i < 2; i++) {  
            Portlet portlet = new Portlet();  
            portlet.setShowShadow(false);
            portlet.setHeight("130");
            portlet.setWidth("*");
            // enable predefined component animation  
            portlet.setAnimateMinimize(true);  
            // customize the appearance and order of the controls in the window header  
            portlet.setHeaderControls(HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS), new HeaderControl(HeaderControl.HELP), HeaderControls.CLOSE_BUTTON);  
            portlet.setOverflow(Overflow.VISIBLE);
            portlet.setTitle("Portlet");
  
            Label label = new Label();  
            label.setAlign(Alignment.CENTER);  
            label.setLayoutAlign(VerticalAlignment.CENTER);  
            label.setContents("Portlet contents");  
            label.setBackgroundColor(colors[Random.nextInt(colors.length - 1)]);  
            portlet.addItem(label);  
            portalLayout.addPortlet(portlet, i, 0);  
        }
  
        VLayout vLayout = new VLayout(15);  
        vLayout.setMargin(10);
  
        final DynamicForm form = new DynamicForm();  
        form.setAutoWidth();  
        
        final ButtonItem addPortlet = new ButtonItem("addPortlet", "Add Portlet");  
        addPortlet.setIcon("silk/application_view_tile.png");  
        addPortlet.setAutoFit(true);  
  
        addPortlet.setStartRow(false);  
        addPortlet.setEndRow(false);  
        addPortlet.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {  
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {  
  
                final Portlet newPortlet = new Portlet();
                newPortlet.setShowShadow(false);  
                newPortlet.setHeight("130");
                newPortlet.setWidth("*");
                // enable predefined component animation  
                newPortlet.setAnimateMinimize(true);  
                // customize the appearance and order of the controls in the window header  
                newPortlet.setHeaderControls(HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS), new HeaderControl(HeaderControl.HELP), HeaderControls.CLOSE_BUTTON);  
                newPortlet.setOverflow(Overflow.VISIBLE); 
                newPortlet.setTitle("Portlet ");  
  
                Label label = new Label();  
                label.setAlign(Alignment.CENTER);  
                label.setLayoutAlign(VerticalAlignment.CENTER);  
                label.setContents("Portlet contents");  
                label.setBackgroundColor(colors[Random.nextInt(colors.length - 1)]);  
                newPortlet.addItem(label);  
                newPortlet.setVisible(false);
                
                int fewestPortlets = Integer.MAX_VALUE;  
                int fewestPortletsColumn = 0;
                Portlet[][][] portletArray = portalLayout.getPortletArray();  
                for (int i = 0; i < portletArray.length; i++) {
                	int numPortlets = portletArray[i].length;
                    if (numPortlets < fewestPortlets) {
                        fewestPortlets = numPortlets;
                        fewestPortletsColumn = i;
                    }  
                }  
                portalLayout.addPortlet(newPortlet, fewestPortletsColumn, 0);
                // create an outline around the clicked button  
                final Canvas outline = new Canvas();  
                outline.setLeft(form.getAbsoluteLeft() + addPortlet.getLeft());  
                outline.setTop(form.getAbsoluteTop());  
                outline.setWidth(addPortlet.getWidth());  
                outline.setHeight(addPortlet.getHeight());  
                outline.setBorder("2px solid #8289A6");  
                outline.draw();  
                outline.bringToFront();  
  
                outline.animateRect(newPortlet.getPageLeft(), newPortlet.getPageTop(),  
                		portalLayout.getColumnWidth(fewestPortletsColumn), newPortlet.getViewportHeight(),  
                        new AnimationCallback() {  
                            public void execute(boolean earlyFinish) {  
                                // callback at end of animation - destroy placeholder and outline; show the new portlet  
                                outline.destroy();  
                                newPortlet.show();  
                            }  
                        }, 750);  
            }  
        });  
  
        form.setItems(addPortlet);
  
        vLayout.addMember(form);  
        vLayout.addMember(portalLayout);   
  
        return vLayout;
    }

    public String getIntro() {
        return null;
    }
}