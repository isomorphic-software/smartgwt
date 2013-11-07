package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DragCreateSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag the large cubes into the boxes to create new small cubes. " +
        "The blue, yellow, and green boxes accept cubes with the same color only. The gray box accepts any color. " + 
        "Right-click on the small cubes to remove them from the boxes.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragCreateSample panel = new DragCreateSample();
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
        HStack cubes = new HStack();
        cubes.setLayoutMargin(20);
        cubes.setMembersMargin(40);
        cubes.setLayoutAlign(Alignment.CENTER);
        cubes.addMember(new DragPiece("cube_blue.png", "b"));
        cubes.addMember(new DragPiece("cube_yellow.png", "y"));
        cubes.addMember(new DragPiece("cube_green.png", "g"));

        HStack edges = new HStack();
        edges.setMembersMargin(20);
        edges.addMember(new PieceBin("edges/blue/6.png", "b"));
        edges.addMember(new PieceBin("edges/yellow/6.png", "y"));
        edges.addMember(new PieceBin("edges/green/6.png", "g"));
        edges.addMember(new PieceBin("edges/gray/6.png", "b", "y", "g"));

        VStack main = new VStack();
        main.addMember(cubes);
        main.addMember(edges);
        return main;
    }

    public static class DragPiece extends Img {
        public DragPiece(String src, String dragType) {
            setSrc(src);
            setWidth(48);
            setHeight(48);
            setCursor(Cursor.MOVE);
            setAppImgDir("pieces/48/");
            setCanDrag(true);
            setCanDrop(true);
            setDragType(dragType);
            setDragAppearance(DragAppearance.TRACKER);
        }

        @Override
        protected boolean setDragTracker() {
            EventHandler.setDragTracker(Canvas.imgHTML("pieces/24/" + getSrc(), 24, 24), 24, 24, 15, 15);
            return false;
        }
    }

    public static class DroppedPiece extends Img {
        public DroppedPiece(String src, int left, int top) {
            setSrc(src);
            setLeft(left);
            setTop(top);
            setWidth(24);
            setHeight(24);
            setAppImgDir("pieces/24/");
            setCanDragReposition(true);
            setKeepInParentRect(true);
            setDragAppearance(DragAppearance.TARGET);
            addShowContextMenuHandler(new ShowContextMenuHandler() {
                public void onShowContextMenu(ShowContextMenuEvent event) {
                    destroy();
                    event.cancel();
                }
            });
        }
    }

    public static class PieceBin extends Canvas {
        public PieceBin(String edgeImage, String... dropTypes) {
            setWidth(100);
            setHeight(100);
            setShowEdges(true);
            setEdgeSize(6);
            setEdgeImage(edgeImage);
            setOverflow(Overflow.HIDDEN);
            setCanAcceptDrop(true);
            setDropTypes(dropTypes);         
            addShowContextMenuHandler(new ShowContextMenuHandler() {
                public void onShowContextMenu(ShowContextMenuEvent event) {
                    event.cancel();
                }
            });
            addDropOverHandler(new DropOverHandler() {
                public void onDropOver(DropOverEvent event) {
                    if (willAcceptDrop()) {
                        setBackgroundColor("#ffff80");
                    }
                }
            });
            addDropOutHandler(new DropOutHandler() {
                public void onDropOut(DropOutEvent event) {
                    setBackgroundColor("#ffffff");
                }
            });
            addDropHandler(new DropHandler() {
                public void onDrop(DropEvent event) {
                    addChild(new DroppedPiece(
                            ((Img) EventHandler.getDragTarget()).getSrc(),
                            getOffsetX() - 15 - getEdgeSize(),
                            getOffsetY() - 15 - getEdgeSize()
                    ));
                }
            });
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}