package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateZoomSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click the buttons to zoom or shrink the image.";

	public static class Factory implements PanelFactory {
		private String id;

		public ShowcasePanel create() {
			AnimateZoomSample panel = new AnimateZoomSample();
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

		final Img image = new Img("other/magnifier.png", 48,48);
		image.setTop(125);
		image.setLeft(100); 
		image.setAnimateTime(500); // milliseconds

		IButton zoomButton = new IButton();
		zoomButton.setTitle("Zoom");
		zoomButton.setLeft(40);
		zoomButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				image.animateRect(0, 50, 248, 248);

			}
		});

		IButton shrinkButton = new IButton();
		shrinkButton.setTitle("Shrink");
		shrinkButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				image.animateRect(100, 125, 48, 48);
			}
		});

		HLayout hLayout = new HLayout();
		hLayout.setMembersMargin(10);
		hLayout.addMember(zoomButton);
		hLayout.addMember(shrinkButton);
		layout.addMember(hLayout);

		layout.addChild(image);
		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}