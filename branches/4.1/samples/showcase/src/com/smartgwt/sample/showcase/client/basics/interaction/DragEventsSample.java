package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class DragEventsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag the pawn over \"Show Drop Reticle\" to see a simple custom drag and drop interaction.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragEventsSample panel = new DragEventsSample();
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
        Canvas canvas = new Canvas();

        final Img img = new Img("pieces/48/pawn_green.png", 48, 48) {
            @Override
            protected boolean setDragTracker() {
                Canvas c = new Canvas();
                String html = Canvas.imgHTML("pieces/24/pawn_green.png", 24, 24, null, null, null);
                EventHandler.setDragTracker(html);
                return false;
            }
        };
        img.setCanDrag(true);
        img.setCanDrop(true);
        img.setDragAppearance(DragAppearance.TRACKER);

        final DropLabel label = new DropLabel();
        label.setLeft(100);
        label.setWidth(300);
        label.setHeight(300);
        label.setBackgroundColor("#C3D9FF");
        label.setAlign(Alignment.CENTER);
        label.setContents("Show Drop Reticle");
        label.setOverflow(Overflow.HIDDEN);
        label.setCanAcceptDrop(true);

        canvas.addChild(img);
        canvas.addChild(label);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    class DropLabel extends Label {

        private Canvas crossHairX;
        private Canvas crossHairY;

        @Override 
        protected void onInit() {
            crossHairX = createCrossHair();
            crossHairY = createCrossHair();
            addChild(crossHairX);
            addChild(crossHairY);

            this.addDropOverHandler(new DropOverHandler() {
                public void onDropOver(DropOverEvent event) {
                    getCrossHairX().show();
                    getCrossHairY().show();
                    updateCrossHairs();
                }
            });

            this.addDropMoveHandler(new DropMoveHandler() {
                public void onDropMove(DropMoveEvent event) {
                    updateCrossHairs();
                }
            });

            this.addDropOutHandler(new DropOutHandler() {
                public void onDropOut(DropOutEvent event) {
                    getCrossHairX().hide();
                    getCrossHairY().hide();
                }
            });

        }

        private Canvas createCrossHair() {
            Canvas canvas = new Canvas();
            canvas.setWidth(this.getWidth() + 2);
            canvas.setHeight(this.getHeight() + 2);
            canvas.setBorder("1px solid #6a6a6a");
            canvas.setVisibility(Visibility.HIDDEN);
            return canvas;
        }

        public Canvas getCrossHairX() {
            return crossHairX;
        }

        public Canvas getCrossHairY() {
            return crossHairY;
        }

        public void updateCrossHairs() {
            int x = getOffsetX();
            int y = getOffsetY();

            // crossHairX is the -X and +Y axis of the crossHair
            crossHairX.setLeft(x - getWidth() - 1);
            crossHairX.setTop(y - getHeight() - 1);

            // crossHairY is +X, -Y
            crossHairY.setLeft(x);
            crossHairY.setTop(y);
        }
    }
}