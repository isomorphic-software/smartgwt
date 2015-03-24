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

public class SplitPaneSample extends ShowcasePanel {
    private static final String DESCRIPTION = "SplitPane displays up to 3 panes in a device- and orientation-sensitive manner, "+
            "automatically providing navigation controls between panes for devices that don't have "+
            "enough room to display panes side-by-side. "+
            "<p>"+
            "Compare this sample running on a desktop browser vs a tablet or handset. A "+
            "handset or tablet in portrait mode shows just one pane at a time and "+
            "provides automatic navigation between the panes.  Two panes are shown "+
            "simultaneously for a tablet device in landscape mode, and all 3 panes are "+
            "shown simultaneously for desktop browsers. "+
            "<p>"+
            "Note that the example viewer you are currently using is also based on "+
            "SplitPane.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            SplitPaneSample panel = new SplitPaneSample();
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
            addItem(new SplitPanePanel());
        }
    }

    @Override
    public SourceEntity[] getSourceUrls() {
        return new SourceEntity[] {
                new SourceEntity("SplitPaneSample.java", "source/layout/SplitPaneSample.java.html")
        };
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
