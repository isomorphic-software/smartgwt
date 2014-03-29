package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateLayoutSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Click on the buttons to hide and show the green star.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AnimateLayoutSample panel = new AnimateLayoutSample();
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

        final HStack starsLayout = new HStack();
        starsLayout.setTop(50);
        starsLayout.setMembersMargin(10);
        starsLayout.setLayoutMargin(10);
        starsLayout.setShowEdges(true);
        starsLayout.setAnimateMembers(true);

        final Img blueImg = createImage("star_blue.png");
        final Img greenImg = createImage("star_green.png");
        final Img yellowImg = createImage("star_yellow.png");

        starsLayout.addMember(blueImg);
        starsLayout.addMember(greenImg);
        starsLayout.addMember(yellowImg);

        IButton showButton = new IButton();
        showButton.setTitle("Show");
        showButton.setIconOrientation("right");
        showButton.setIcon("pieces/16/star_green.png");
        showButton.setLeft(40);

        IButton hideButton = new IButton();
        hideButton.setTitle("Hide");
        hideButton.setIcon("pieces/16/star_green.png");
        hideButton.setIconOrientation("right");
        hideButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                starsLayout.hideMember(greenImg);
            }
        });

        showButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                starsLayout.showMember(greenImg);
            }
        });

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.addMember(hideButton);
        hLayout.addMember(showButton);
        layout.addMember(hLayout);
        layout.addChild(starsLayout);


        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    private Img createImage(String src) {
        Img img = new Img(src);
        img.setAppImgDir("pieces/48/");
        img.setWidth(48);
        img.setHeight(48);
        img.setLayoutAlign(Alignment.CENTER);
        return img;
    }
}