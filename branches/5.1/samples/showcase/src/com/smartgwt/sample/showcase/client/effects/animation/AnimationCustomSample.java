package com.smartgwt.sample.showcase.client.effects.animation;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimationCustomSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the globe for a custom \"orbit\" animation.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AnimationCustomSample panel = new AnimationCustomSample();
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
        layout.addChild(new OrbitImg());
        return layout;
    }

    public static class OrbitImg extends Img {
        public OrbitImg() {
            super("other/earth.png", 48, 48);
            setTop(0);
            setLeft(100);
            addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    animateOrbit();
                }
            });
        }

        public void animateOrbit() {
            
            //TODO: isc.Animation.registerAnimation(this.animateOrbitStep, 2000, null, this);
            
            new Timer() {
                private double ratio = 0;
                public void run() {
                    animateOrbitStep(ratio);
                    ratio += 0.01;
                    if(ratio >= 1)
                        cancel();
                }
            }.scheduleRepeating(20);
            
        }

        public void animateOrbitStep(double ratio) {
            double angle = (Math.PI * 2) * ratio - (Math.PI / 2);
            moveTo((int) (Math.cos(angle) * 100 + 100), (int) (Math.sin(angle) * 100 + 100));
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}