package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
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

        public ShowcasePanel create() {
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

    public static class DragPanSampleImg extends Img {

        private static final String IMG_URL = Canvas.getImgURL("[APPIMG]other/cpu.jpg");
        private static boolean loaded = false;

        private int startScrollLeft;
        private int startScrollTop;

        public DragPanSampleImg() {
            setWidth(200);
            setHeight(200);
            if (loaded) setSrc(IMG_URL);
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

            if (!loaded) {
                final Image image = new Image();
                image.addLoadHandler(new LoadHandler() {
                    @Override
                    public void onLoad(LoadEvent event) {
                        loaded = true;
                        setSrc(IMG_URL);
                    }
                });
                image.setVisible(false);
                // Need to attach the Image to the widget tree in order for the load handler
                // to fire.
                RootLayoutPanel.get().add(image);
                image.setUrl(IMG_URL);
            }
        }
    }

    @Override
    public Canvas getViewPanel() {
        return new DragPanSampleImg();
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
