package com.smartgwt.sample.showcase.client.autotest.effects.dragdrop;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.DragStartEvent;
import com.smartgwt.client.widgets.events.DragStartHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TestablePortletAcrossWindowsSample extends ShowcasePanel {

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            final TestablePortletAcrossWindowsSample panel = new TestablePortletAcrossWindowsSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return null;
        }
    }

    private static final Map<String, String> SRC_MAP = new HashMap<String, String>();
    static {
        SRC_MAP.put("Blue", "pawn_blue.png");
        SRC_MAP.put("Green", "pawn_green.png");
        SRC_MAP.put("Yellow", "pawn_yellow.png");
    }

    private static final class Part extends Img {
        public Part(String src) {
            setWidth(48);
            setHeight(48);
            setPadding(12);
            setLayoutAlign(Alignment.CENTER);
            setAppImgDir("pieces/48/");
            setSrc(src);
        }
    }

    private static final class CustomPortalLayout extends PortalLayout {
        public CustomPortalLayout() {
            setWidth100();
            setHeight("50%");
            setNumColumns(3);
            final Canvas columnProperties = new Canvas();
            columnProperties.setDropTypes("partPortlet");
            setAutoChildProperties("column", columnProperties);
        }

        @Override
        public Canvas getDropPortlet(Canvas dragTarget, Integer colNum, Integer rowNum, Integer dropPosition) {
            if (dragTarget instanceof Portlet) return dragTarget;

            final String portletName = (String)EventHandler.getNativeDragData();
            if (portletName != null) {
                return createPortlet(portletName);
            }
            return null;
        }
    }

    private static Portlet createPortlet(final String portletName) {
        final String src = SRC_MAP.get(portletName);
        if (src == null) return null;
        final Portlet portlet = new Portlet();
        portlet.setTitle(portletName);
        portlet.setCanDrag(true);
        portlet.setDragType("partPortlet");
        portlet.setUseNativeDrag(true);
        portlet.addItem(new Part(src));
        portlet.addDragStartHandler(new DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                EventHandler.setNativeDragData(portletName, portletName);
                EventHandler.setDragTrackerImage("pieces/48/" + src, 28, 38);
            }
        });
        return portlet;
    }

    @Override
    public Canvas getViewPanel() {
        final PortalLayout portalLayout = new CustomPortalLayout();
        portalLayout.setID("portalLayout");
        portalLayout.addPortlet(createPortlet("Blue"), 0, 0);
        portalLayout.addPortlet(createPortlet("Green"), 1, 0);
        portalLayout.addPortlet(createPortlet("Yellow"), 2, 0);

        final PortalLayout portalLayout2 = new CustomPortalLayout();
        portalLayout2.setID("portalLayout2");

        final Layout mainLayout = new VStack(15);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setMembers(portalLayout, portalLayout2);
        return mainLayout;
    }
}
