package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateSequenceSample extends ShowcasePanel {

	private static final String DESCRIPTION = "Click the buttons for a 2-stage expand or collapse effect.";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			AnimateSequenceSample panel = new AnimateSequenceSample();
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

		final HTMLFlow flow = new HTMLFlow();			
		flow.setID("messageBox");
		flow.setContents("<span class='exampleDropTitle'>Ajax&nbsp;&nbsp;</span> <b>A</b>synchronous <b>J</b>avaScript <b>A</b>nd <b>X</b>ML (AJAX) is a Web development technique for creating interactive <b>web applications</b>. The intent is to make web pages feel more responsive by exchanging small amounts of data with the server behind the scenes, so that the entire Web page does not have to be reloaded each time the user makes a change. This is meant to increase the Web page's <b>interactivity</b>, <b>speed</b>, and <b>usability</b>. (Source: <a href='http://www.wikipedia.org' title='Wikipedia' target='_blank'>Wikipedia</a>)");
		flow.setStyleName("exampleTextBlock");
		flow.setOverflow(Overflow.HIDDEN);
		flow.setShowEdges(true);
		flow.setPadding(5);
		flow.setWidth(75);
		flow.setHeight(45);
		flow.setTop(50);
		flow.setAnimateTime(800); //in milliseconds

		final IButton expandButton = new IButton();
		expandButton.setTitle("Expand");
		expandButton.setLeft(40);
		
		final IButton collapseButton = new IButton();
		collapseButton.setTitle("Collapse");
		collapseButton.setDisabled(true);
		
		expandButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				expandButton.setDisabled(true);
				flow.animateResize(310,45, new AnimationCallback() {
					public void execute(boolean earlyFinish) {
						flow.animateResize(310,195);						
					}
					
				});
				
				collapseButton.setDisabled(false);
			}
		});

		collapseButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				collapseButton.setDisabled(true);
				flow.animateResize(310,45, new AnimationCallback() {
					public void execute(boolean earlyFinish) {
						flow.animateResize(75,45);						
					}					
				});				
				expandButton.setDisabled(false);
			}
		});

		HLayout hLayout = new HLayout();
		hLayout.setMembersMargin(10);
		hLayout.addMember(expandButton);
		hLayout.addMember(collapseButton);
		layout.addMember(hLayout);
		layout.addChild(flow);

		return layout;
	}

	public String getIntro() {
		return DESCRIPTION;
	}

}