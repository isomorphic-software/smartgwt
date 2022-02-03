package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateWindowMinimizeSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click on the minimize button (round button in header with flat line).";

	public static class Factory implements PanelFactory {
		private String id;

		public ShowcasePanel create() {
			AnimateWindowMinimizeSample panel = new AnimateWindowMinimizeSample();
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

		Canvas canvasMain = new Canvas();

		Window window = new Window();

		window.setTitle("Minimizing a window");
		window.setWidth(300);
		window.setHeight(85);

		window.setCanDragReposition(true);
		window.setCanDragResize(true);
		window.setAnimateMinimize(true);

		Label label = new Label(
				"Staging: <span style=\"color: green; font-weight: bold;\">Normal</span><br/>"
						+ "Production: <span style=\"color: green; font-weight: bold;\">Normal</span><br/>"
						+ "Development: <span style=\"color: green; font-weight: bold;\">Normal</span>");

		label.setHeight100();
		label.setPadding(5);
		label.setValign(VerticalAlignment.TOP);

		window.addItem(label);
		canvasMain.addChild(window);

		return canvasMain;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}