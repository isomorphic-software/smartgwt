
package com.smartgwt.sample.showcase.client.tabs;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TabsAlignSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Tabs can be left or right aligned (for horizontal tabs) or top or bottom aligned (for vertical tabs).";

    public static class Factory implements PanelFactory {
        private String id;
        public Canvas create() {
            TabsAlignSample panel = new TabsAlignSample();
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
        topTabSet.setTabBarAlign(Side.RIGHT);
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
        leftTabSet.setTabBarAlign(Side.BOTTOM);
        leftTabSet.setWidth(300);
        leftTabSet.setHeight(300);

        Tab lTab1 = new Tab();
        lTab1.setIcon("pieces/16/pawn_blue.png", 16);
        Img lImg1 = new Img("pieces/48/pawn_blue.png", 48, 48);
        lTab1.setPane(lImg1);

        Tab lTab2 = new Tab();
        lTab2.setIcon("pieces/16/pawn_green.png", 16);
        Img lImg2 = new Img("pieces/48/pawn_green.png", 48, 48);
        lTab2.setPane(lImg2);

        leftTabSet.addTab(lTab1);
        leftTabSet.addTab(lTab2);

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);
        vLayout.addMember(topTabSet);
        vLayout.addMember(leftTabSet);
        vLayout.setHeight("auto");
        
        return vLayout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}