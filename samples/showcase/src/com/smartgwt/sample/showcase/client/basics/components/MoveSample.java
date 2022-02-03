package com.smartgwt.sample.showcase.client.basics.components;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseStillDownEvent;
import com.smartgwt.client.widgets.events.MouseStillDownHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MoveSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and hold the arrow to move the image. Click on the solid circle to return to the starting position.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            MoveSample panel = new MoveSample();
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
        layout.setAutoHeight();

        HLayout hLayout = new HLayout();

        final Img vanImg = new Img("crystal/128/apps/virussafe.png", 96, 96);
        vanImg.setCanDragReposition(true);
        vanImg.setTop(0);
        vanImg.setLeft(50);

        Img resetImg = new Img("icons/48/reset.png", 48, 48);
        resetImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                vanImg.moveTo(50, 0);
            }
        });

        Img moveImg = new Img("icons/48/downright.png", 48, 48);
        moveImg.setShowRollOver(true);
        moveImg.addMouseStillDownHandler(new MouseStillDownHandler() {
            public void onMouseStillDown(MouseStillDownEvent event) {
                vanImg.moveBy(20, 20);
            }
        });

        hLayout.addMember(resetImg);
        hLayout.addMember(moveImg);

        //were positioning the vanImg using absolute poitioning relative to its containing canvas
        Canvas vanCanvas = new Canvas();
        vanCanvas.addChild(vanImg);

        layout.addMember(hLayout);
        layout.addMember(vanCanvas);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}