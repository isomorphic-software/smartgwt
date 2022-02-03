package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class DragTypesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to move pieces between the three boxes. The gray box accepts any piece. The blue and green boxes accept pieces of the same color only.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragTypesSample panel = new DragTypesSample();
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

    	DropBox gray = new DropBox("edges/gray/6.png");
    	gray.addMember(new DragPiece("cube_blue.png", "b"));
    	gray.addMember(new DragPiece("cube_green.png", "g"));
    	gray.addMember(new DragPiece("cube_yellow.png", "y"));
    	gray.setDropTypes("b", "g", "y");
    	
    	DropBox blue = new DropBox("edges/blue/6.png");
    	blue.addMember(new DragPiece("cube_blue.png", "b"));
    	blue.addMember(new DragPiece("cube_green.png", "g"));
    	blue.addMember(new DragPiece("cube_yellow.png", "y"));
    	blue.setDropTypes("b");

    	DropBox green = new DropBox("edges/green/6.png");
    	green.addMember(new DragPiece("cube_blue.png", "b"));
    	green.addMember(new DragPiece("cube_green.png", "g"));
    	green.addMember(new DragPiece("cube_yellow.png", "y"));
    	green.setDropTypes("g");
    	
    	HStack hStack = new HStack(20);
        hStack.addMember(gray);
        hStack.addMember(blue);
        hStack.addMember(green);
        
        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    private class DropBox extends VStack {
    	public DropBox() {
    		setShowEdges(true);
    		setMembersMargin(10);
    		setLayoutMargin(10);
    		setCanAcceptDrop(true);
    		setAnimateMembers(true);
    		setDropLineThickness(4);
    		setAutoHeight();
    	}
    	
    	public DropBox(String edgeImage) {
    		this();
    		setEdgeImage(edgeImage);
    	}
    }
    
    private class DragPiece extends Img {
    	public DragPiece() {
    		setWidth(48);
    		setHeight(48);
    		setLayoutAlign(Alignment.CENTER);
    		setCanDragReposition(true);
    		setCanDrop(true);
    		setDragAppearance(DragAppearance.TARGET);
    		setAppImgDir("pieces/48/");
    	}
    	
    	public DragPiece(String src, String dragType) {
    		this();
    		setSrc(src);
    		setDragType(dragType);
    	}
    }

}