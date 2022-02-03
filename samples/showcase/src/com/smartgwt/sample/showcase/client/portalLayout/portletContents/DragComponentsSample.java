package com.smartgwt.sample.showcase.client.portalLayout.portletContents;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgProperties;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;

public class DragComponentsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Components can be dragged into PortalLayouts, creating Portlets on the fly. Try selecting some "+
        "records in the ListGrid and drag them into the Portal Layout. A new Portlet will be created on the fly containing the records that were "+
        "dragged. Try dragging the chess pieces to the layout -- they will be moved into a Portlet created on the fly.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragComponentsSample panel = new DragComponentsSample();
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
        PartsListGrid myList = new PartsListGrid();
        myList.setCanDragRecordsOut(true);
        myList.setCanReorderRecords(true);
        myList.setDragDataAction(DragDataAction.COPY);
        myList.setData(PartData.getRecords());
        myList.setHeight(150);
		
        PortalLayout portalLayout = new PortalLayout() {
            public Canvas getDropPortlet(Canvas dragTarget, Integer colNum, Integer rowNum, Integer dropPosition) {
                // You can use getDropPortlet to customize what happens when a component is dropped
                if (dragTarget instanceof PartsListGrid) {
                    Portlet portlet = new Portlet();
                    portlet.setTitle("Dragged Records");
                    PartsListGrid partListGrid = new PartsListGrid();
                    partListGrid.setData(((PartsListGrid)dragTarget).getDragData());
                    portlet.addItem(partListGrid);
                    return portlet;
                } else {
                    // By default, the whole component is wrapped in a Portlet
                    return super.getDropPortlet(dragTarget, colNum, rowNum, dropPosition);
                }
            }
        };
        portalLayout.setHeight100();

        VStack vStack = new VStack();
        vStack.setMembersMargin(10);
        vStack.setLayoutMargin(10);
        vStack.setShowEdges(true);
        DragPiece dragPieceBlue = new DragPiece();
        dragPieceBlue.setSrc("pawn_blue.png");
        DragPiece dragPieceGreen = new DragPiece();
        dragPieceGreen.setSrc("pawn_green.png");
        DragPiece dragPieceYellow = new DragPiece();
        dragPieceYellow.setSrc("pawn_yellow.png");
        vStack.addMembers(dragPieceBlue, dragPieceGreen, dragPieceYellow);
		
        VLayout vLayout = new VLayout();
        vLayout.setWidth(200);
        vLayout.setHeight100();
        vLayout.setMembersMargin(20);
        vLayout.setMembers(myList, vStack);
		
        HLayout hLayout = new HLayout();
        hLayout.setWidth100();
        hLayout.setHeight100();
        hLayout.setMargin(20);
        hLayout.setMembers(portalLayout, vLayout);
		
        return hLayout;
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
	
    class PartsListGrid extends ListGrid {
        public PartsListGrid() {
            setCellHeight(24);
            setImageSize(16);
            setShowEdges(true);
            setBorder("0px");
            setBodyStyleName("normal");
            setAlternateRecordStyles(true);
            setShowHeader(false);
            setLeaveScrollbarGap(false);
			
            ImgProperties imgProperties = new ImgProperties();
            imgProperties.setSrc("pieces/24/cubes_all.png");
            imgProperties.setWidth(24);
            imgProperties.setHeight(24);
			
            setTrackerImage(imgProperties);
			
            ListGridField partSrcField = new ListGridField("partSrc");
            partSrcField.setType(ListGridFieldType.IMAGE);
            partSrcField.setWidth(24);
            partSrcField.setImageURLPrefix("pieces/16/");
            ListGridField partNameField = new ListGridField("partName");
            ListGridField partNumField = new ListGridField("partNum");
            partNumField.setWidth(20);
			
            setFields(partSrcField, partNameField, partNumField);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}