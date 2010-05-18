package com.smartgwt.sample.showcase.client.portal;

import com.google.gwt.user.client.Random;
import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SimplePortalSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Animations built into Smart GWT layouts can be used to create a drag and drop portal experience. " +
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

        // create portlets...
        for (int i = 1; i <= 2; i++) {
            Portlet portlet = new Portlet();
            portlet.setTitle("Portlet");

            Label label = new Label();
            label.setAlign(Alignment.CENTER);
            label.setLayoutAlign(VerticalAlignment.CENTER);
            label.setContents("Portlet contents");
            label.setBackgroundColor(colors[Random.nextInt(colors.length - 1)]);
            portlet.addItem(label);
            portalLayout.addPortlet(portlet);
        }

        VLayout vLayout = new VLayout(15);
        vLayout.setMargin(10);

        final DynamicForm form = new DynamicForm();
        form.setAutoWidth();
        form.setNumCols(5);

        final StaticTextItem numColItem = new StaticTextItem();
        numColItem.setTitle("Columns");
        numColItem.setValue(portalLayout.getMembers().length);

        ButtonItem addColumn = new ButtonItem("addColumn", "Add Column");
        addColumn.setIcon("silk/application_side_expand.png");
        addColumn.setAutoFit(true);
        addColumn.setStartRow(false);
        addColumn.setEndRow(false);


        addColumn.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                portalLayout.addMember(new PortalColumn());
                numColItem.setValue(portalLayout.getMembers().length);

            }
        });

        ButtonItem removeColumn = new ButtonItem("removeColumn", "Remove Column");
        removeColumn.setIcon("silk/application_side_contract.png");
        removeColumn.setAutoFit(true);
        removeColumn.setStartRow(false);
        removeColumn.setEndRow(false);


        removeColumn.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {

                Canvas[] canvases = portalLayout.getMembers();
                int numMembers = canvases.length;
                if (numMembers > 0) {
                    Canvas lastMember = canvases[numMembers - 1];
                    portalLayout.removeMember(lastMember);
                    numColItem.setValue(numMembers - 1);
                }

            }
        });

        final ButtonItem addPortlet = new ButtonItem("addPortlet", "Add Portlet");
        addPortlet.setIcon("silk/application_view_tile.png");
        addPortlet.setAutoFit(true);

        addPortlet.setStartRow(false);
        addPortlet.setEndRow(false);
        addPortlet.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {

                final Portlet newPortlet = new Portlet();
                newPortlet.setTitle("Portlet ");

                Label label = new Label();
                label.setAlign(Alignment.CENTER);
                label.setLayoutAlign(VerticalAlignment.CENTER);
                label.setContents("Portlet contents");
                label.setBackgroundColor(colors[Random.nextInt(colors.length - 1)]);
                newPortlet.addItem(label);

                newPortlet.setVisible(false);
                PortalColumn column = portalLayout.addPortlet(newPortlet);

                // also insert a blank spacer element, which will trigger the built-in
                //  animateMembers layout animation
                final LayoutSpacer placeHolder = new LayoutSpacer();
                placeHolder.setRect(newPortlet.getRect());
                column.addMember(placeHolder, 0); // add to top

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
                        newPortlet.getVisibleWidth(), newPortlet.getViewportHeight(),
                        new AnimationCallback() {
                            public void execute(boolean earlyFinish) {
                                // callback at end of animation - destroy placeholder and outline; show the new portlet
                                placeHolder.destroy();
                                outline.destroy();
                                newPortlet.show();
                            }
                        }, 750);
            }
        });


        form.setItems(numColItem, addPortlet, addColumn, removeColumn);

        vLayout.addMember(form);
        vLayout.addMember(portalLayout);

        return vLayout;
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
            setHeaderControls(HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL, new HeaderControl(HeaderControl.SETTINGS), new HeaderControl(HeaderControl.HELP), HeaderControls.CLOSE_BUTTON);

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
            setAnimateMemberTime(300);

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
        return null;
    }
}