package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AddRemoveSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on \"Add Tab\" and \"Remove Tab\" to add and remove tabs. When you add too many tabs to " +
            "display at once, a tab scrolling interface will appear.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AddRemoveSample panel = new AddRemoveSample();
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
        tabSet.setWidth(400);
        tabSet.setHeight(200);

        Tab tTab1 = new Tab("Blue", "pieces/16/pawn_blue.png");
        Img tImg1 = new Img("pieces/48/pawn_blue.png", 48, 48);
        tTab1.setPane(tImg1);

        Tab tTab2 = new Tab("Green", "pieces/16/pawn_green.png");
        Img tImg2 = new Img("pieces/48/pawn_green.png", 48, 48);
        tTab2.setPane(tImg2);

        tabSet.addTab(tTab1);
        tabSet.addTab(tTab2);

        HLayout buttons = new HLayout();
        buttons.setMembersMargin(15);

        IButton addButton = new IButton("Add Tab");
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                //alternate between yellow pawn and green cube
                if (tabSet.getTabs().length % 2 == 0) {
                    Tab tab = new Tab("Yellow", "pieces/16/pawn_yellow.png");
                    Img img = new Img("pieces/48/pawn_yellow.png", 48, 48);
                    tab.setPane(img);
                    tabSet.addTab(tab);
                } else {
                    Tab tab = new Tab("Green", "pieces/16/cube_green.png");
                    Img img = new Img("pieces/48/cube_green.png", 48, 48);
                    tab.setPane(img);
                    tabSet.addTab(tab);
                }
                if (tabSet.getTabs().length == 0) {
                    tabSet.selectTab(0);
                }
            }
        });

        IButton removeButton = new IButton("Remove Tab");
        removeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                final Tab[] tabs = tabSet.getTabs();
                if (tabs.length > 0) {
                    tabSet.removeTab(tabs[tabs.length - 1]);
                }
            }
        });

        buttons.addMember(addButton);
        buttons.addMember(removeButton);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);
        vLayout.addMember(tabSet);
        vLayout.addMember(buttons);
        vLayout.setAutoHeight();

        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}