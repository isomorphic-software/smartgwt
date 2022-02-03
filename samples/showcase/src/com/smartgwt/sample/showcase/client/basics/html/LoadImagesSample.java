package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LoadImagesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the buttons to load different images.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            LoadImagesSample panel = new LoadImagesSample();
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

        Canvas canvas = new Canvas();

        final Img myImage = new Img("star_grey.png", 48, 48);
        myImage.setAppImgDir("pieces/48/");
        myImage.setLeft(120);
        myImage.setTop(20);
        canvas.addChild(myImage);

        IButton showBlueButton = new IButton("Show");
        showBlueButton.setLeft(10);
        showBlueButton.setTop(100);
        showBlueButton.setWidth(80);
        showBlueButton.setIconOrientation("right");
        showBlueButton.setIcon("pieces/16/star_blue.png");
        showBlueButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myImage.setSrc("star_blue.png");
            }
        });
        canvas.addChild(showBlueButton);

        IButton showYellowButton = new IButton("Show");
        showYellowButton.setLeft(100);
        showYellowButton.setTop(100);
        showYellowButton.setWidth(80);
        showYellowButton.setIconOrientation("right");
        showYellowButton.setIcon("pieces/16/star_yellow.png");
        showYellowButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myImage.setSrc("star_yellow.png");
            }
        });
        canvas.addChild(showYellowButton);

        IButton showGreenButton = new IButton("Show");
        showGreenButton.setLeft(190);
        showGreenButton.setTop(100);
        showGreenButton.setWidth(80);
        showGreenButton.setIconOrientation("right");
        showGreenButton.setIcon("pieces/16/star_green.png");
        showGreenButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myImage.setSrc("star_green.png");
            }
        });
        canvas.addChild(showGreenButton);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}