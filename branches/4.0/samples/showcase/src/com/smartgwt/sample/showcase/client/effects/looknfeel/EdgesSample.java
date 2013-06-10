package com.smartgwt.sample.showcase.client.effects.looknfeel;

import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class EdgesSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Drag the text boxes. These boxes show customized frame and glow effects using edge images.";

	private static final String EXAMPLE_TEXT = "When in the Course of human events, it becomes necessary for one people to dissolve the " +
            "political bands which have connected them with another, and to assume among the powers of the earth, the separate and equal " +
            "station to which the Laws of Nature and of Nature's God entitle them, a decent respect to the opinions of mankind requires that " +
            "they should declare the causes which impel them to the separation.";
	
	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			EdgesSample panel = new EdgesSample();
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

		
		final Label label1 = createLabel();
		final Label label2 = createLabel();
		final Label label3 = createLabel();
		
		label1.setShowEdges(true);
		label1.setEdgeImage("edges/custom/sharpframe_10.png");
		label1.setEdgeSize(10);
		
		label2.setLeft(100);
		label2.setTop(80);
		label2.setEdgeImage("edges/custom/frame_10.png");
		label2.setEdgeSize(10);

		label3.setLeft(200);
		label3.setTop(160);
		label3.setEdgeImage("edges/custom/glow_15.png");
		label3.setEdgeSize(15);
		
		canvas.addChild(label1);
		canvas.addChild(label2);
		canvas.addChild(label3);
		
		return canvas;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
	
	private Label createLabel() {
		Label label = new Label(EXAMPLE_TEXT);
		label.setWidth(250);
		label.setPadding(8);
		label.setBackgroundColor("white");
		label.setCanDragReposition(true);
		label.setDragAppearance(DragAppearance.TARGET);
		label.setShowEdges(true);
		label.setKeepInParentRect(true);		    
		return label;
	}
	
}