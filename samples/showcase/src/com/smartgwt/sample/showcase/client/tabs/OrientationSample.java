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

public class OrientationSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Tabs can be horizontally or vertically oriented. To select tabs, click on them, or on " +
            "click the \"Select Blue\" and \"Select Green\" buttons.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            OrientationSample panel = new OrientationSample();
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

        final TabSet topTabSet = new TabSet();
        topTabSet.setTabBarPosition(Side.TOP);
        topTabSet.setWidth(400);
        topTabSet.setHeight(200);

        Tab tTab1 = new Tab("Blue", "pieces/16/pawn_blue.png");
        Img tImg1 = new Img("pieces/48/pawn_blue.png", 48, 48);
        tTab1.setPane(tImg1);

        Tab tTab2 = new Tab("Green", "pieces/16/pawn_green.png");
        Img tImg2 = new Img("pieces/48/pawn_green.png", 48, 48);
        tTab2.setPane(tImg2);

        topTabSet.addTab(tTab1);
        topTabSet.addTab(tTab2);

        final TabSet leftTabSet = new TabSet();
        leftTabSet.setTabBarPosition(Side.LEFT);
        leftTabSet.setWidth(400);
        leftTabSet.setHeight(200);

        Tab lTab1 = new Tab();
        lTab1.setIcon("pieces/16/pawn_blue.png");
        Img lImg1 = new Img("pieces/48/pawn_blue.png", 48, 48);
        lTab1.setPane(lImg1);

        Tab lTab2 = new Tab();
        lTab2.setIcon("pieces/16/pawn_green.png");
        Img lImg2 = new Img("pieces/48/pawn_green.png", 48, 48);
        lTab2.setPane(lImg2);

        leftTabSet.addTab(lTab1);
        leftTabSet.addTab(lTab2);

        HLayout buttons = new HLayout();
        buttons.setMembersMargin(15);

        IButton blueButton = new IButton("Select Blue");
        blueButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                topTabSet.selectTab(0);
                leftTabSet.selectTab(0);
            }
        });

        IButton greeButton = new IButton("Select Green");
        greeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                topTabSet.selectTab(1);
                leftTabSet.selectTab(1);
            }
        });
        
        buttons.addMember(greeButton);
        buttons.addMember(blueButton);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);
        vLayout.addMember(topTabSet);
        vLayout.addMember(buttons);
        vLayout.addMember(leftTabSet);
        vLayout.setHeight("auto");

        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}