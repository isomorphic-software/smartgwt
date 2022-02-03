package com.smartgwt.sample.showcase.client.effects.looknfeel;

import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CornersSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Drag the text boxes. These boxes show customized rounded-corner effects using edge images.";

	private static final String EXAMPLE_TEXT = "When in the Course of human events, it becomes necessary for one people to dissolve the political " +
            "bands which have connected them with another, and to assume among the powers of the earth, the separate and equal station to which the " +
            "Laws of Nature and of Nature's God entitle them, a decent respect to the opinions of mankind requires that they should declare the " +
            "causes which impel them to the separation.";
	
	public static class Factory implements PanelFactory {
		private String id;

		public ShowcasePanel create() {
			CornersSample panel = new CornersSample();
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
		
		label1.setEdgeImage("corners/flat_100.png");
		label1.setEdgeSize(30);
		label1.setEdgeOffset(14);
		
		label2.setLeft(100);
		label2.setTop(80);
		label2.setEdgeImage("corners/ridge_28.png");
		label2.setEdgeSize(28);
		label2.setEdgeOffset(18);

		label3.setLeft(200);
		label3.setTop(160);
		label3.setEdgeImage("corners/glow_35.png");
		label3.setEdgeSize(35);
		label3.setEdgeOffset(25);
		label3.setWidth(270);
		
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
        label.setStyleName("blackText");
		label.setCanDragReposition(true);
		label.setDragAppearance(DragAppearance.TARGET);
		label.setShowEdges(true);
		label.setEdgeShowCenter(true);
		label.setKeepInParentRect(true);		    
		return label;
	}
	
}