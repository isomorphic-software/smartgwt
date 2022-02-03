package com.smartgwt.sample.showcase.client.basics.html;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class SVGImgSample extends ShowcasePanel {
    private static final String DESCRIPTION = "SVG may be specified as the source file for an Img or ImgButton. "+
        "At the top are three Img widgets defined by SVG using common external CSS. By changing the Color Scheme "+
        "from \"Green\" to \"Red\" using the picker, you can change the src attribute of each Img to new SVG that "+
        "picks up a different style from the CSS.<P>" +
        "At the bottom, note how the ImgButton switches to a separate, animated SVG image during mouseOver, and "+
        "that it responds to clicks just like any other button.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SVGImgSample panel = new SVGImgSample();
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
        final String svgPath = "svg/";
        Canvas canvas = new Canvas(); 
		
        Img circle = new Img();
        circle.setID("circle");
        circle.setLeft(20);
        circle.setTop(75);
        circle.setWidth(100);
        circle.setHeight(100);
        circle.setOverflow(Overflow.HIDDEN);
        circle.setImageType(ImageStyle.NORMAL);
        circle.setSrc(svgPath + "circle.svg");
        canvas.addChild(circle);
		
        Img square = new Img();
        square.setID("square");
        square.setLeft(145);
        square.setTop(75);
        square.setWidth(100);
        square.setHeight(100);
        square.setOverflow(Overflow.HIDDEN);
        square.setImageType(ImageStyle.NORMAL);
        square.setSrc(svgPath + "square.svg");
        canvas.addChild(square);
		
        Img bouncyText = new Img();
        bouncyText.setID("bouncyText");
        bouncyText.setLeft(270);
        bouncyText.setTop(80);
        bouncyText.setWidth(150);
        bouncyText.setHeight(90);
        bouncyText.setOverflow(Overflow.HIDDEN);
        bouncyText.setImageType(ImageStyle.NORMAL);
        bouncyText.setBorder("1px solid gray");
        bouncyText.setSrc(svgPath + "bouncyText.svg");
        canvas.addChild(bouncyText);
		
        final List<Img> listImages = new ArrayList<Img>();
        listImages.add(circle);
        listImages.add(square);
        listImages.add(bouncyText);
		
        DynamicForm form = new DynamicForm();
        form.setLeft(22);
        form.setTop(15);
        form.setWidth(400);
		
        SelectItem selectItem = new SelectItem();
        selectItem.setWrapTitle(false);
        selectItem.setTitle("Select Image Color Scheme");
        selectItem.setWidth(155);
        selectItem.setAlign(Alignment.RIGHT);
        selectItem.setDefaultValue(0);
        Map mapValues = new HashMap();
        mapValues.put(0, "Green");
        mapValues.put(1, "Red");
        selectItem.setValueMap(mapValues);
        selectItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                for (int i = 0; i < listImages.size(); i++) {
                    String src = svgPath + listImages.get(i).getID();
                    if (Integer.parseInt((String)event.getValue()) > 0) src += "-" + "red";
                    listImages.get(i).setSrc(src + ".svg");
                }
            }
        });
        form.setFields(selectItem);
        canvas.addChild(form);
		
        ImgButton imgButton = new ImgButton();
        imgButton.setHeight(200);
        imgButton.setLeft(75);
        imgButton.setTop(225);
        imgButton.setWidth(300);
        imgButton.setCanFocus(false);
        imgButton.setSrc(svgPath + "ellipse.svg");
        imgButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.ask("Are you sure you want to click on this button?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        
                    }
                });
            }
        });
        canvas.addChild(imgButton);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}