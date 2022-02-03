package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.DropEvent;
import com.smartgwt.client.widgets.events.DropHandler;
import com.smartgwt.client.widgets.events.DropOutEvent;
import com.smartgwt.client.widgets.events.DropOutHandler;
import com.smartgwt.client.widgets.events.DropOverEvent;
import com.smartgwt.client.widgets.events.DropOverHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class DragTrackerSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop the pieces onto the box.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragTrackerSample panel = new DragTrackerSample();
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

    	DragPiece blue = new DragPiece("pawn_blue.png") {
            @Override
			protected boolean setDragTracker() {
				EventHandler.setDragTracker("Blue Piece");
				return false;
			}
    	};
        blue.setID("bluePiece");
    	blue.setTitle("Blue Piece");
    	blue.setLeft(50);
    	blue.setTop(50);
    	    	
    	DragPiece green = new DragPiece("pawn_green.png"){
            @Override
			protected boolean setDragTracker() {
                String html = Canvas.imgHTML("pieces/24/pawn_green.png", 24, 24);
				EventHandler.setDragTracker(html);
				return false;
			}
    	};
        green.setID("greenPiece");
    	green.setTitle("Green Piece");
    	green.setLeft(150);
    	green.setTop(50);
    	

    	final Label label = new Label("Drop Here");
    	label.setLeft(250);
    	label.setTop(50);
    	label.setShowEdges(true);
    	label.setAlign(Alignment.CENTER);
    	label.setCanAcceptDrop(true);
    	label.addDropOverHandler(new DropOverHandler() {
			public void onDropOver(DropOverEvent event) {
				label.setBackgroundColor("#FFFF88");			
			}
    	});
    	
    	label.addDropOutHandler(new DropOutHandler() {
			public void onDropOut(DropOutEvent event) {
				label.setBackgroundColor("#ffffff");
			}    		
    	});
    	
        label.addDropHandler(new DropHandler() {
			public void onDrop(DropEvent event) {
                Canvas target = EventHandler.getDragTarget();
                SC.say("You dropped the " +  target.getID());				
			}        	
        });
        
        Canvas canvas = new Canvas();
        canvas.addChild(blue);
        canvas.addChild(green);
        canvas.addChild(label);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    
    private class DragPiece extends Img {
    	public DragPiece() {
    		setWidth(48);
    		setHeight(48);
    		setCanDrop(true);
    		setCanDrag(true);
    		setDragAppearance(DragAppearance.TRACKER);
    		setAppImgDir("pieces/48/");
    	}
    	
    	public DragPiece(String src) {
    		this();
    		super.setSrc(src);
    	}
    }

}