package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.DragMoveEvent;
import com.smartgwt.client.widgets.events.DragMoveHandler;
import com.smartgwt.client.widgets.events.DragStartEvent;
import com.smartgwt.client.widgets.events.DragStartHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DragPanSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag to pan the image inside its frame.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragPanSample panel = new DragPanSample();
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
        canvas.addChild(new DragPanSampleImg());
        return canvas;
    }

    public static class DragPanSampleImg extends Img {
        private int startScrollLeft;
        private int startScrollTop;
        public DragPanSampleImg() {
            super("other/cpu.jpg", 200, 200);
            
            setLeft(50);
            setTop(50);
            setOverflow(Overflow.HIDDEN);
            setShowEdges(true);
            setPadding(20);
            setImageType(ImageStyle.NORMAL);
            setCanDrag(true);
            setCursor(Cursor.ALL_SCROLL);
            setDragAppearance(DragAppearance.NONE); 
            addDragStartHandler(new DragStartHandler() {
                public void onDragStart(DragStartEvent event) {
                    startScrollLeft = getScrollLeft();
                    startScrollTop = getScrollTop();
                }
            });          
            addDragMoveHandler(new DragMoveHandler() {
                public void onDragMove(DragMoveEvent event) {
                    int left = startScrollLeft - EventHandler.getX() + EventHandler.getMouseDownX();
                    int top = startScrollTop - EventHandler.getY() + EventHandler.getMouseDownY();
                    scrollTo(left,top);
                }
            });
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}