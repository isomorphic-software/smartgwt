package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateMoveSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click the buttons to move the Label into view or out of view.";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			AnimateMoveSample panel = new AnimateMoveSample();
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

        VLayout layout = new VLayout();
		layout.setMembersMargin(10);

		final Label label = new Label("Vision is the art of seeing the invisible");
		label.setParentElement(layout);
		label.setShowEdges(true);
		label.setBackgroundColor("#ffffd0");
		label.setPadding(5);
		label.setWidth(200);
		label.setTop(50);
		label.setLeft(-220); //start off screen
		label.setValign(VerticalAlignment.CENTER);
		label.setAlign(Alignment.CENTER);
		label.setAnimateTime(1200); // milliseconds

		IButton moveInButton = new IButton();
		moveInButton.setTitle("Move In");
		moveInButton.setLeft(40);
		moveInButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.animateMove(10, 50);

			}
		});

		IButton moveOutButton = new IButton();
		moveOutButton.setTitle("Move Out");
		moveOutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.animateMove(-220, 50);
			}
		});

		HLayout hLayout = new HLayout();
		hLayout.setMembersMargin(10);
		hLayout.addMember(moveInButton);
		hLayout.addMember(moveOutButton);
		layout.addMember(hLayout);

		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}