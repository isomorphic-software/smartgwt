package com.smartgwt.sample.showcase.client.portal;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SimplePortalSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Animations built into SmartGWT layouts can be used to create a drag and drop portal experience. " +
            "Drag portlets around to new locations and they animate into place. ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
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

    public Canvas getViewPanel() {
        PortalLayout portalLayout = new PortalLayout(3);
        portalLayout.setWidth100();
        portalLayout.setHeight100();

        // create portlets...
        for (int i = 1; i <= 5; i++) {
            Portlet portlet = new Portlet();
            portlet.setTitle("Portlet " + i);

            Label label = new Label();
            label.setAlign(Alignment.CENTER);
            label.setLayoutAlign(VerticalAlignment.CENTER);
            label.setContents("Portlet " + i + " contents");
            portlet.addItem(label);
            portalLayout.addPortlet(portlet);
        }
        return portalLayout;
    }

    /**
     * Portlet class definition
     */
    private class Portlet extends Window {

        public Portlet() {

            setShowShadow(false);

            // enable predefined component animation
            setAnimateMinimize(true);

            // Window is draggable with "outline" appearance by default.
            // "target" is the solid appearance.
            setDragAppearance(DragAppearance.OUTLINE);
            setCanDrop(true);

            // customize the appearance and order of the controls in the window header
            setHeaderControls(HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL, HeaderControls.CLOSE_BUTTON);

            // show either a shadow, or translucency, when dragging a portlet
            // (could do both at the same time, but these are not visually compatible effects)
            // setShowDragShadow(true);
            setDragOpacity(30);

            // these settings enable the portlet to autosize its height only to fit its contents
            // (since width is determined from the containing layout, not the portlet contents)
            setVPolicy(LayoutPolicy.NONE);
            setOverflow(Overflow.VISIBLE);

        }
    }

    /**
     * PortalColumn class definition
     */
    private class PortalColumn extends VStack {

        public PortalColumn() {

            // leave some space between portlets
            setMembersMargin(6);

            // enable predefined component animation
            setAnimateMembers(true);
            setAnimateMemberTime(500);

            // enable drop handling
            setCanAcceptDrop(true);

            // change appearance of drag placeholder and drop indicator
            setDropLineThickness(4);

            Canvas dropLineProperties = new Canvas();
            dropLineProperties.setBackgroundColor("aqua");
            setDropLineProperties(dropLineProperties);

            setShowDragPlaceHolder(true);

            Canvas placeHolderProperties = new Canvas();
            placeHolderProperties.setBorder("2px solid #8289A6");
            setPlaceHolderProperties(placeHolderProperties);
        }
    }

    /**
     * PortalLayout class definition
     */
    private class PortalLayout extends HLayout {
        public PortalLayout(int numColumns) {
            setMembersMargin(6);
            for (int i = 0; i < numColumns; i++) {
                addMember(new PortalColumn());
            }
        }

        public PortalColumn addPortlet(Portlet portlet) {
            // find the column with the fewest portlets
            int fewestPortlets = Integer.MAX_VALUE;
            PortalColumn fewestPortletsColumn = null;
            for (int i = 0; i < getMembers().length; i++) {
                int numPortlets = ((PortalColumn) getMember(i)).getMembers().length;
                if (numPortlets < fewestPortlets) {
                    fewestPortlets = numPortlets;
                    fewestPortletsColumn = (PortalColumn) getMember(i);
                }
            }
            fewestPortletsColumn.addMember(portlet);
            return fewestPortletsColumn;
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}