package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.types.NavigationDirection;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.FlowLayout;
import com.smartgwt.client.widgets.layout.NavigationBar;
import com.smartgwt.client.widgets.layout.NavigationBarViewState;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.events.NavigationClickEvent;
import com.smartgwt.client.widgets.layout.events.NavigationClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MobileAnimatedTransitionsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The <code>NavigationBar</code> component has subtle, built-in animations " +
        "to help users keep their sense of place. "+  
        "<p>"+
        "Press \"New\" to do a right transition - notice how the old title slides left and fades while "+
        "the changed buttons fade in place."+  
        "<p>"+
        "Press \"Back\" for a left transition - notice how the title from the left button appears to "+
        "slide over to become the title, as the old title fades out.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	MobileAnimatedTransitionsSample panel = new MobileAnimatedTransitionsSample();
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
		final NavigationBar navBar = new NavigationBar();
        navBar.setWidth(296);
        navBar.setLeftButtonTitle("Folders");
        navBar.setRightButtonTitle("New");
        navBar.setShowRightButton(true);
        navBar.setTitle("Inbox");
        navBar.setAnimateStateChanges(true);
        navBar.addNavigationClickHandler(new NavigationClickHandler() {

			@Override
			public void onNavigationClick(NavigationClickEvent event) {
				if (event.getDirection().equals(NavigationDirection.BACK)) {
                    if (navBar.getLeftButtonTitle().equals("Inbox")) {
                        navBar.setRightButtonTitle("New");
                        NavigationBarViewState viewState = new NavigationBarViewState();
                        viewState.setLeftButtonTitle("Folders");
                        viewState.setTitle("Inbox");
                        navBar.setViewState(viewState, NavigationDirection.BACK);
                    } else if (navBar.getLeftButtonTitle().equals("Folders")) {
                        navBar.setRightButtonTitle("Inbox");
                        NavigationBarViewState viewState = new NavigationBarViewState();
                        viewState.setLeftButtonTitle("Exit");
                        viewState.setTitle("Folders");
                        navBar.setViewState(viewState, NavigationDirection.BACK);
                    } else if (navBar.getLeftButtonTitle().equals("Exit")) {
                        SC.say("Exiting");
                    }
                } else {
                    if (navBar.getTitle().equals("Inbox")) {
                        navBar.setRightButtonTitle("Done");
                        NavigationBarViewState viewState = new NavigationBarViewState();
                        viewState.setLeftButtonTitle(navBar.getTitle());
                        viewState.setTitle("New Message");
                        navBar.setViewState(viewState, NavigationDirection.FORWARD);
                    } else if (navBar.getTitle().equals("Folders")) {
                        navBar.setRightButtonTitle("New");
                        NavigationBarViewState viewState = new NavigationBarViewState();
                        viewState.setLeftButtonTitle("Folders");
                        viewState.setTitle("Inbox");
                        navBar.setViewState(viewState, NavigationDirection.FORWARD);
                    } else if (navBar.getTitle().equals("New Message")) {
                        SC.say("Sending message");
                        navBar.setRightButtonTitle("New");
                        if (navBar.getLeftButtonTitle().equals("Inbox")) {
                        	NavigationBarViewState viewState = new NavigationBarViewState();
                            viewState.setLeftButtonTitle("Folders");
                            viewState.setTitle("Inbox");
                            navBar.setViewState(viewState, NavigationDirection.BACK);
                        } else if (navBar.getLeftButtonTitle().equals("Folders")) {
                        	NavigationBarViewState viewState = new NavigationBarViewState();
                            viewState.setLeftButtonTitle("Exit");
                            viewState.setTitle("Folders");
                            navBar.setViewState(viewState, NavigationDirection.BACK);
                        }
                    }
                }
			}
        });

        return navBar;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
