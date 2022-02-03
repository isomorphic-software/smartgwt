package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.core.Rectangle;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class SplitPaneAutoNavigateSample extends ShowcasePanel {
    private static final String DESCRIPTION = "\"Auto-navigation\" means that SplitPane will analyze the "+
    "controls placed in each pane and the DataSources they are bound to, and automatically navigate between panes."+
    "<p>"+
    "In this example, because there is a 1-to-Many relationship from the tree in the navigation pane to the grid "+
    "in the list pane, the SplitPane automatically populates the grid with records related to the tree node that "+
    "was clicked, and transitions to the list pane."+
    "<p>"+
    "Similarly, because the DetailViewer in the detail pane has the same DataSource as the grid in the list pane, "+
    "clicking on ListGrid records populates the DetailViewer with the selected record, and transitions to the detail pane."+
    "<p>"+
    "Auto-navigation means that the SplitPane just does the \"obvious thing\" with the components and DataSources it "+
    "is provided with. It can be extremely useful for administrative or power user interfaces where the end user is "+
    "allowed to look at any DataSource in the system, so a general-purpose UI is needed, capable of working with any "+
    "set of DataSources.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            SplitPaneAutoNavigateSample panel = new SplitPaneAutoNavigateSample();
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
        VLayout layout = new VLayout(15);

        layout.addMember(new Label("This is a full-screen example - click the \"Show Example\" button to show fullscreen."));

        final IButton button = new IButton("Show Example");
        button.setWidth(140);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Rectangle rect = button.getPageRect();
                final Canvas animateOutline = new Canvas();
                animateOutline.setBorder("2px solid black");
                animateOutline.setTop(rect.getTop());
                animateOutline.setLeft(rect.getLeft());
                animateOutline.setWidth(rect.getLeft());
                animateOutline.setHeight(rect.getHeight());

                animateOutline.show();
                animateOutline.animateRect(0, 0, Page.getWidth(), Page.getHeight(), new AnimationCallback() {
                    public void execute(boolean earlyFinish) {
                        animateOutline.hide();
                        final FullScreenApplication appWindow = new FullScreenApplication();
                        appWindow.addCloseClickHandler(new CloseClickHandler() {
                            public void onCloseClick(CloseClickEvent event) {
                                animateOutline.setRect(0, 0, Page.getWidth(), Page.getHeight());
                                animateOutline.show();
                                appWindow.destroy();
                                Rectangle targetRect = button.getPageRect();
                                animateOutline.animateRect(targetRect.getLeft(), targetRect.getTop(), targetRect.getWidth(),
                                        targetRect.getHeight(), new AnimationCallback() {
                                            public void execute(boolean earlyFinish) {
                                                animateOutline.hide();
                                            }
                                        }, 500);

                            }
                        });
                        appWindow.show();
                    }
                }, 500
                );
            }
        });

        layout.addMember(button);

        return layout;   
    }  

    class FullScreenApplication extends Window {

        FullScreenApplication() {
            setTitle("SplitPane");
            setWidth100();
            setHeight100();
            setShowMinimizeButton(false);
            setShowCloseButton(true);
            setCanDragReposition(false);
            setCanDragResize(false);
            setShowShadow(false);
            addItem(new SplitPaneAutoNavigatePanel());
        }
    }

    @Override
    public SourceEntity[] getSourceUrls() {
        return new SourceEntity[] {
                new SourceEntity("SplitPaneAutoNavigateSample.java", "source/layout/SplitPaneAutoNavigateSample.java.html")
        };
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
