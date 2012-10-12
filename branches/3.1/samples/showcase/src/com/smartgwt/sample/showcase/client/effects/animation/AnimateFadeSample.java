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

public class AnimateFadeSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click the buttons to fade the image.";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			AnimateFadeSample panel = new AnimateFadeSample();
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

		final Img image = new Img("other/eyes.jpg", 300,188);
        //need to set useOpacityFilter:true to support setting of opacity on IE 7 and greater
        image.setUseOpacityFilter(true);
		image.setParentElement(layout);
		image.setTop(105);
		image.setLeft(10); 
		image.setAnimateTime(1200); // milliseconds

		IButton fadeOutButton = new IButton();
		fadeOutButton.setTitle("Fade Out");
		fadeOutButton.setLeft(40);
		fadeOutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				image.animateFade(0);

			}
		});

		IButton fadeInButton = new IButton();
		fadeInButton.setTitle("Fade In");
		fadeInButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				image.animateFade(100);
			}
		});

		HLayout hLayout = new HLayout();
		hLayout.setMembersMargin(10);
		hLayout.addMember(fadeInButton);		
		hLayout.addMember(fadeOutButton);		
		layout.addMember(hLayout);

		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}