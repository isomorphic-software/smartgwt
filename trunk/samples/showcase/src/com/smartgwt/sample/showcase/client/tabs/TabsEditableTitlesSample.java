/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabTitleEditEvent;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.CloseClickHandler;
import com.smartgwt.client.widgets.tab.events.TabCloseClickEvent;
import com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent;
import com.smartgwt.client.widgets.tab.events.TabTitleChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsEditableTitlesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Optionally, titles can be directly edited in place by your application's end users. " +
            "This TabSet specifies canEditTabTitles - double-click a tab title to edit it. Individual tabs can override the TabSet behavior; " +
            "in this example, the \"Can't change me\" tab has canEditTitle set to false. Your code can cancel the user changes - try editing " +
            "the \"123-Yellow\" tab to a title that doesn't begin with \"123-\" ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TabsEditableTitlesSample panel = new TabsEditableTitlesSample();
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

        final TabSet tabSet = new TabSet();
        tabSet.setTabBarPosition(Side.TOP);
        tabSet.setTabBarAlign(Side.LEFT);
        tabSet.setWidth(500);
        tabSet.setHeight(200);

        tabSet.setCanEditTabTitles(true);
        tabSet.setTitleEditEvent(TabTitleEditEvent.DOUBLECLICK);
        tabSet.setTitleEditorTopOffset(2);


        Tab tab1 = new Tab("Blue", "pieces/16/pawn_blue.png");

        tab1.setCanClose(true);
        Img img1 = new Img("pieces/48/pawn_blue.png", 48, 48);
        tab1.setPane(img1);

        Tab tab2 = new Tab("Green", "pieces/16/pawn_green.png");
        Img img2 = new Img("pieces/48/pawn_green.png", 48, 48);
        tab2.setPane(img2);

        final Tab validatedTab = new Tab("123-Yellow", "pieces/16/pawn_yellow.png");
        final Img validatedTabImg = new Img("pieces/48/pawn_yellow.png", 48, 48);
        validatedTab.setPane(validatedTabImg);

        final Tab uneditableTab = new Tab("Can't Change Me", "pieces/16/pawn_red.png");
        uneditableTab.setCanEditTitle(false);
        Img uneditableTabImg = new Img("pieces/48/pawn_red.png", 48, 48);
        uneditableTab.setPane(uneditableTabImg);

        tabSet.addTab(tab1);
        tabSet.addTab(tab2);
        tabSet.addTab(validatedTab);
        tabSet.addTab(uneditableTab);

        tabSet.addTabTitleChangedHandler(new TabTitleChangedHandler() {
            @Override
            public void onTabTitleChanged(TabTitleChangedEvent event) {
                Tab tab = event.getTab();
                if (tab.equals(validatedTab) && (event.getNewTitle() == null || !event.getNewTitle().substring(0, 4).equals("123-"))) {
                    SC.warn("Tab title must start with the prefix \"123-\"");
                    event.cancel();
                }
            }
        });

        return tabSet;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
