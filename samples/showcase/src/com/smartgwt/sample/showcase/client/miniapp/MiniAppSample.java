/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.miniapp;

import com.smartgwt.client.core.Rectangle;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class MiniAppSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Demonstrates a range of Smart GWT GUI components, data binding operations, " +
            "and layout managers in a single-page application.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MiniAppSample panel = new MiniAppSample();
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
        button.setIcon("silk/layout_content.png");
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
            setTitle("Demo Application");
            setHeaderIcon("silk/layout_content.png");
            setWidth100();
            setHeight100();
            setShowMinimizeButton(false);
            setShowCloseButton(true);
            setCanDragReposition(false);
            setCanDragResize(false);
            setShowShadow(false);
            addItem(new ApplicationPanel());
        }
    }

    @Override
    public SourceEntity[] getSourceUrls() {
        return new SourceEntity[] {
                new SourceEntity("Application.java", "source/miniapp/Application.java.html"),
                new SourceEntity("CategoryTreeGrid.java", "source/miniapp/CategoryTreeGrid.java.html"),
                new SourceEntity("HelpPane.java", "source/miniapp/HelpPane.java.html"),
                new SourceEntity("ItemDetailTabPane.java", "source/miniapp/ItemDetailTabPane.java.html"),
                new SourceEntity("ItemListGrid.java", "source/miniapp/ItemListGrid.java.html"),
                new SourceEntity("SearchForm.java", "source/miniapp/SearchForm.java.html"),
                new SourceEntity("ItemSupplyXmlDS.java", "sourcegen/data/ItemSupplyXmlDS.java.html"),
                new SourceEntity("SupplyCategoryXmlDS.java", "sourcegen/data/SupplyCategoryXmlDS.java.html")
        };
    }

    public String getSourceGenUrl() {
        return null;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}