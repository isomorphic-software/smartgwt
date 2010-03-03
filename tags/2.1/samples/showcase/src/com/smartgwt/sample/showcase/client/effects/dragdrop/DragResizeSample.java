package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DragResizeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag on the edges of the labels to resize.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragResizeSample panel = new DragResizeSample();
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
        
        DragLabel resizeAny = new DragLabel();
        resizeAny.setLeft(80);
        resizeAny.setTop(80);
        resizeAny.setContents("Resize from any side");
        resizeAny.setCanDragResize(true);
        resizeAny.setEdgeMarginSize(10);
        canvas.addChild(resizeAny);
        
        DragLabel resizeBR = new DragLabel();
        resizeBR.setLeft(280);
        resizeBR.setTop(80);
        resizeBR.setContents("Resize from bottom or right");
        resizeBR.setCanDragResize(true);
        resizeBR.setResizeFrom("B","R","BR");
        resizeBR.setEdgeMarginSize(10);
        canvas.addChild(resizeBR);
        
        return canvas;
    }

    public static class DragLabel extends Label {
        public DragLabel() {
            setAlign(Alignment.CENTER);
            setPadding(4);
            setShowEdges(true);
            setMinWidth(70);
            setMinHeight(70);
            setMaxWidth(300);
            setMaxHeight(200);
            setKeepInParentRect(true);
            setCanDragReposition(true);
            setDragAppearance(DragAppearance.TARGET);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}