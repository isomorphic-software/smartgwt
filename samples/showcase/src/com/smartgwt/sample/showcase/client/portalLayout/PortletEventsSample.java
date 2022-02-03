package com.smartgwt.sample.showcase.client.portalLayout;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PortletEventsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Explore events fired by the portal and information passed to the event handler.";
    
    private DynamicForm eventsForm;
    
    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            PortletEventsSample panel = new PortletEventsSample();
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
        return false;
    }

    class DragPiece extends Img {
        public DragPiece() {
            setWidth(48);
            setHeight(48);
            setPadding(12);
            setLayoutAlign(Alignment.CENTER);
            setCanDragReposition(true);
            setCanDrop(true);
            setDragAppearance(DragAppearance.TARGET);
            setAppImgDir("pieces/48/");
        }
    }

    public Canvas getViewPanel() {
        PortalLayout portalLayout = new PortalLayout() {
            @Override
            public void portletMaximized(Portlet portlet) {
                if (eventsForm != null) {
                    String message = "portlet maximized: " + portlet.getTitle() + "\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
            }
            
            @Override
            public void portletMinimized(Portlet portlet) {
                if (eventsForm != null) {
                    String message = "portlet minimized: " + portlet.getTitle() + "\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
            }
            
            @Override
            public void portletRestored(Portlet portlet) {
                if (eventsForm != null) {
                    String message = "portlet restored: " + portlet.getTitle() + "\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
            }
            
            @Override
            public void portletsChanged() {
                if (eventsForm != null) {
                    String message = "portlets changed\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
            }
            
            @Override
            public void portletsResized() {
                if (eventsForm != null) {
                    String message = "portlets resized\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
            }
            
            @Override
            public boolean willClosePortlet(Portlet portlet) {
                if (eventsForm != null) {
                    String message = "portlet about to close: " + portlet.getTitle() + "\n";
                    eventsForm.setValue("eventsArea", eventsForm.getValue("eventsArea") + message);
                }
                return true;
            }
        };
        portalLayout.setWidth("70%");
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
		
        portalLayout.addPortlet(portlet1, 0, 0);
        portalLayout.addPortlet(portlet2, 0, 1, 0);
        portalLayout.addPortlet(portlet3, 0, 1, 1);
        portalLayout.addPortlet(portlet4, 1, 0);
		
        VStack itemsStack = new VStack();
        itemsStack.setMembersMargin(10);
        itemsStack.setLayoutMargin(10);
        itemsStack.setShowEdges(true);
        DragPiece dragPieceBlue = new DragPiece();
        dragPieceBlue.setSrc("pawn_blue.png");
        DragPiece dragPieceGreen = new DragPiece();
        dragPieceGreen.setSrc("pawn_green.png");
        DragPiece dragPieceYellow = new DragPiece();
        dragPieceYellow.setSrc("pawn_yellow.png");
        itemsStack.addMembers(dragPieceBlue, dragPieceGreen, dragPieceYellow);
        
        TextAreaItem eventsArea = new TextAreaItem("eventsArea", "Events");
        eventsArea.setWidth("100%");
        eventsArea.setHeight("100%");
        eventsArea.setTitleOrientation(TitleOrientation.TOP);
        eventsArea.setValue("");
        
        eventsForm = new DynamicForm();
        eventsForm.setWidth100();
        eventsForm.setHeight(250);
        eventsForm.setTitleWidth(50);
        eventsForm.setNumCols(1);
        eventsForm.setFields(eventsArea);
        
        VLayout vLayout = new VLayout();
        vLayout.setWidth("*");
        vLayout.setMembers(itemsStack, eventsForm);
        
        HLayout hLayout = new HLayout();
        hLayout.setWidth100();
        hLayout.setHeight100();
        hLayout.setMembers(portalLayout, vLayout);
        
        return hLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}