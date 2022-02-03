package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class ImgSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The Img component displays images in the standard web formats (png, gif, jpg) and other image formats " +
            "supported by the web browser.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ImgSample panel = new ImgSample();
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

        String image = "crystal/128/apps/jabber_protocol.png";
        
        Img starImg1 = new Img(image, 100, 100);
        starImg1.setImageWidth(64);
        starImg1.setImageHeight(64);
        starImg1.setImageType(ImageStyle.NORMAL);
        starImg1.setBorder("1px solid gray");
        canvas.addChild(starImg1);

        Img starImg2 = new Img(image, 100, 100);
        starImg2.setImageWidth(64);
        starImg2.setImageHeight(64);
        starImg2.setImageType(ImageStyle.CENTER);
        starImg2.setBorder("1px solid gray");
        starImg2.setLeft(120);
        canvas.addChild(starImg2);

        Img starImg3 = new Img(image, 100, 100);
        starImg3.setImageType(ImageStyle.STRETCH);
        starImg3.setBorder("1px solid gray");
        starImg3.setLeft(240);
        canvas.addChild(starImg3);

        String newsImage = "crystal/128/mimetypes/news.png";
        Img starImg4 = new Img(newsImage, 100, 100);
        starImg4.setImageType(ImageStyle.STRETCH);
        starImg4.setBorder("1px solid gray");
        starImg4.setTop(120);
        canvas.addChild(starImg4);

        Img starImg5 = new Img(newsImage, 220, 220);
        starImg5.setImageType(ImageStyle.NORMAL);
        starImg5.setBorder("1px solid gray");
        starImg5.setImageHeight(536);
        starImg5.setImageWidth(446);
        starImg5.setTop(120);
        starImg5.setLeft(120);
        starImg5.setOverflow(Overflow.AUTO);
        canvas.addChild(starImg5);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}