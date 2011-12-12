package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DragEffectsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag to move the labels.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragEffectsSample panel = new DragEffectsSample();
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
        
        DragLabel dragTranslucent = new DragLabel("Translucent", 50);
        dragTranslucent.setDragAppearance(DragAppearance.TARGET);
        dragTranslucent.setDragOpacity(60);
        canvas.addChild(dragTranslucent);
        
        DragLabel dragShadow = new DragLabel("Shadow", 200);
        dragShadow.setDragAppearance(DragAppearance.TARGET);
        dragShadow.setShowDragShadow(true);
        //TODO: dragShadow.setDragShadowDepth(8);
        canvas.addChild(dragShadow);
        
        DragLabel dragOutline = new DragLabel("Outline", 350);
        dragOutline.setLeft(350);      
        dragOutline.setDragAppearance(DragAppearance.OUTLINE);
        canvas.addChild(dragOutline);

        return canvas;
    }

    public static class DragLabel extends Label {
        public DragLabel(String contents, int left) {
            setTop(50);
            setLeft(left);
            setContents(contents);
            setAlign(Alignment.CENTER);
            setPadding(4);
            setShowEdges(true);
            setBackgroundColor("#EEEEEE");
            setKeepInParentRect(true);
            setCanDragReposition(true);    
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}