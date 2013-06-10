package com.smartgwt.sample.showcase.client.portalLayout;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgProperties;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class PortletAnimationSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the portlet list to the left to create portlets and see them animate into place. Drag " +
        "portlets around to new locations and they animate into place.";

    private ListGrid listGrid;

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            PortletAnimationSample panel = new PortletAnimationSample();
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
        portalLayout.setOverflow(Overflow.VISIBLE);
        portalLayout.setColumnOverflow(Overflow.VISIBLE);
        portalLayout.setPreventColumnUnderflow(false);
        portalLayout.setNumColumns(3);
        portalLayout.setShowColumnMenus(true);
        portalLayout.setColumnBorder("0");
        	
        listGrid = new ListGrid();
        listGrid.setAutoDraw(false);
        listGrid.setWidth(120);
        listGrid.setHeight(20);
        // autosize to fit the list, instead of scrolling
        listGrid.setOverflow(Overflow.VISIBLE);
        listGrid.setBodyOverflow(Overflow.VISIBLE);
        listGrid.setLeaveScrollbarGap(false);
	    
        // hide the column headers
        listGrid.setShowHeader(false);
	    
        // disable normal row selection behaviors
        listGrid.setSelectionType(SelectionStyle.NONE);
		
        ListGridRecord records[] = new ListGridRecord[10];
        records[0] = new ListGridRecord();
        records[0].setAttribute("portletName", "Portlet 1");
        records[1] = new ListGridRecord();
        records[1].setAttribute("portletName", "Portlet 2");
        records[2] = new ListGridRecord();
        records[2].setAttribute("portletName", "Portlet 3");
        records[3] = new ListGridRecord();
        records[3].setAttribute("portletName", "Portlet 4");
        records[4] = new ListGridRecord();
        records[4].setAttribute("portletName", "Portlet 5");
        records[5] = new ListGridRecord();
        records[5].setAttribute("portletName", "Portlet 6");
        records[6] = new ListGridRecord();
        records[6].setAttribute("portletName", "Portlet 7");
        records[7] = new ListGridRecord();
        records[7].setAttribute("portletName", "Portlet 8");
        records[8] = new ListGridRecord();
        records[8].setAttribute("portletName", "Portlet 9");
        records[9] = new ListGridRecord();
        records[9].setAttribute("portletName", "Portlet 10");
        // fake portlet list for self-contained example
        // The real list could be included inline, or loaded on the fly from the server.
        // This data can include whatever attributes you want to use for these portlet,
        // e.g. feed URLs, icons, update frequency...
        listGrid.setData(records);
		
        ListGridField portletNameField = new ListGridField("portletName");
        portletNameField.setCellFormatter(new CellFormatter() {
            @Override
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return Canvas.imgHTML("[SKIN]actions/view.png") + " " + value;
            }
        });
        listGrid.setFields(portletNameField);
		
        // global for convenient single setting of multiple animation times in this example
        // default 750
        listGrid.setAnimateTime(750);
	    
        listGrid.addRecordClickHandler(new RecordClickHandler() {
            @Override
            public void onRecordClick(RecordClickEvent event) {
                final ListGridRecord record = (ListGridRecord)event.getRecord();
                record.setEnabled(false);
                listGrid.refreshRow(event.getRecordNum());
                final Portlet newPortlet = new Portlet();
                newPortlet.setTitle(record.getAttributeAsString("portletName"));
                newPortlet.setShowShadow(false);
                // enable predefined component animation
                newPortlet.setAnimateMinimize(true);
                // Window is draggable with "outline" appearance by default.
                // "target" is the solid appearance.
                newPortlet.setDragAppearance(DragAppearance.OUTLINE);
                // customize the appearance and order of the controls in the window header
                // (could do this in load_skin.js instead)
                newPortlet.setHeaderControls(HeaderControls.HEADER_ICON, HeaderControls.HEADER_LABEL,
                    HeaderControls.MINIMIZE_BUTTON,  HeaderControls.CLOSE_BUTTON);
                // show either a shadow, or translucency, when dragging a portlet
                // (could do both at the same time, but these are not visually compatible effects)
                newPortlet.setDragOpacity(30);
                // these settings enable the portlet to autosize its height only to fit its contents
                // (since width is determined from the containing layout, not the portlet contents)
                newPortlet.setHeight(140);
                newPortlet.setOverflow(Overflow.VISIBLE);
                LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
                map.put("overflow", "VISIBLE");
                newPortlet.setBodyDefaults(map);
                Label label = new Label();
                label.setAutoDraw(false);
                label.setAlign(Alignment.CENTER);
                label.setLayoutAlign(Alignment.CENTER);
                label.setContents(record.getAttributeAsString("portletName")+" contents");
                // simple fake portlet contents - could put anything here
                newPortlet.addItem(label);
                newPortlet.addCloseClickHandler(new CloseClickHandler() {
                    @Override
                    public void onCloseClick(CloseClickEvent event) {
                        closePortlet(newPortlet, record);
                    }
                });
                newPortlet.hide();
				
                int fewestPortlets = 999999;
                int fewestPortletsColumn = 0;
                // find the column with the fewest portlets
                Portlet portletArray[][][] = portalLayout.getPortletArray();
                for (int i=0; i < portletArray.length; i++) {
                    int numPortlets = portletArray[i].length;
                    if (numPortlets < fewestPortlets) {
                        fewestPortlets = numPortlets;
                        fewestPortletsColumn = i;
                    }
                }
                portalLayout.addPortlet(newPortlet, fewestPortletsColumn, 0);
			    
                // create an outline around the clicked row
                final Canvas outline = new Canvas();
                outline.setLeft(listGrid.getPageLeft());
                outline.setTop(listGrid.getRowPageTop(event.getRecordNum()));
                outline.setWidth(listGrid.getVisibleWidth());
                outline.setHeight(listGrid.getDrawnRowHeight(event.getRecordNum()));
                outline.setBorder("2px solid #8289A6");  
                outline.draw();  
                outline.bringToFront();  
                outline.animateRect(newPortlet.getPageLeft(), newPortlet.getPageTop(),
                        portalLayout.getColumnWidth(fewestPortletsColumn), newPortlet.getVisibleHeight(),
                        new AnimationCallback() {  
                            public void execute(boolean earlyFinish) {
                                // callback at end of animation - destroy placeholder and outline; show the new portlet 
                                outline.destroy();
                                newPortlet.show();
                            }
                        }, 750);
            }
        });
        HLayout hLayout = new HLayout();
        hLayout.setWidth("100%");
        hLayout.setHeight("100%");
        hLayout.setLayoutMargin(10);
        hLayout.setMembersMargin(10);
        hLayout.addMembers(listGrid, portalLayout);
		
        return hLayout;
    }

    private void closePortlet(final Portlet portlet, final ListGridRecord portletRecord) {
        final int rowNum = listGrid.getDataAsRecordList().indexOf(portletRecord);
		
        // create an outline around the portlet
        final Canvas outline = new Canvas();
        outline.setAutoDraw(false);
        outline.setBorder("2px solid #8289A6");
        outline.setRect(portlet.getPageRect());
        outline.bringToFront();
        
        // swap the portlet with a blank spacer element
        // (disabling relayout temporarily to prevent animation during the swap)
        Canvas portalColumn = portlet.getParentElement();
        portlet.hide();
        final LayoutSpacer spacer = new LayoutSpacer();
        spacer.setRect(portlet.getRect());
        portalColumn.addChild(spacer);

        // animateHide (shrink) the spacer to collapse this space in the content area
        spacer.setAnimateHideTime(listGrid.getAnimateTime());
        spacer.setAnimateHideTime(10);

        // simultaneously animate the portlet outline down to the row in this portletList
        outline.draw();
        outline.animateRect(listGrid.getPageLeft(), listGrid.getRowPageTop(rowNum),
	       listGrid.getVisibleWidth(), listGrid.getDrawnRowHeight(rowNum),
               new AnimationCallback() {  
                   public void execute(boolean earlyFinish) {
                       // callback at end of animation - destroy outline, portlet, and spacer;
                       // also enable and refresh the row in the portletList so it does not show the special
                       // style (and so it can be clicked again)
                       outline.destroy();
                       spacer.destroy();
                       portlet.destroy();
                       portletRecord.setEnabled(true);
                       listGrid.refreshRow(rowNum);
                   }
               }, 750);
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}