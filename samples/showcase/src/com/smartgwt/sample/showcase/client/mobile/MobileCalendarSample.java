package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.core.Rectangle;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CalendarData;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class MobileCalendarSample extends ShowcasePanel {

    private static final String DESCRIPTION = "For handset-sized devices, the Calendar control has a simplified navigation paradigm: "+
                    "instead of separate tabs for day and week views, you simply pivot the device to switch view. To "+
                    "access the month view, touch the month name. "+
                    "<p>"+
                    "<b>Note:</b> the described behaviors are only present if accessing this sample from a mobile device.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            MobileCalendarSample panel = new MobileCalendarSample();
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
            setTitle("Calendar");
            setWidth100();
            setHeight100();
            setShowMinimizeButton(false);
            setShowCloseButton(true);
            setCanDragReposition(false);
            setCanDragResize(false);
            setShowShadow(false);
            addItem(new MobileCalendarPanel());
        }
    }

    @Override
    public SourceEntity[] getSourceUrls() {
        return new SourceEntity[] {
                new SourceEntity("MobileCalendarSample.java", "source/mobile/MobileCalendarSample.java.html")
        };
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
