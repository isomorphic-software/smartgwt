package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateWipeSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click the buttons to show or hide the Label with a \"wipe\" effect.";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			AnimateWipeSample panel = new AnimateWipeSample();
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

		final Label label = new Label("Vision is the<br/> art of seeing the invisible");
		label.setParentElement(layout);
		label.setShowEdges(true);
		label.setStyleName("exampleTitle");
		label.setPadding(10);
		label.setWidth(150);
		label.setTop(50);
		label.setLeft(35); 
		label.setBackgroundColor("#ffffd0");
		label.setVisibility(Visibility.HIDDEN);
		label.setValign(VerticalAlignment.CENTER);
		label.setAlign(Alignment.CENTER);
		label.setAnimateTime(1200); // milliseconds

		IButton showButton = new IButton();
		showButton.setTitle("Show");
		showButton.setLeft(40);
		showButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.animateShow(AnimationEffect.WIPE);

			}
		});

		IButton hideButton = new IButton();
		hideButton.setTitle("Hide");
		hideButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.animateHide(AnimationEffect.WIPE);
			}
		});

		HLayout hLayout = new HLayout();
		hLayout.setMembersMargin(10);
		hLayout.addMember(showButton);
		hLayout.addMember(hideButton);
		layout.addMember(hLayout);

		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}