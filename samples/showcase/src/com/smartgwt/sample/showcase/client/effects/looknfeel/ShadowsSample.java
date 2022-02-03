package com.smartgwt.sample.showcase.client.effects.looknfeel;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ShadowsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Drag the slider to change the shadow depth for the text box.";

    private static final String EXAMPLE_TEXT = "When in the Course of human events, it becomes necessary for one people to " +
            "dissolve the political bands which have connected them with another, and to assume among the powers of the earth, " +
            "the separate and equal station to which the Laws of Nature and of Nature's God entitle them, a decent respect to " +
            "the opinions of mankind requires that they should declare the causes which impel them to the separation.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ShadowsSample panel = new ShadowsSample();
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


        final Label label = new Label(EXAMPLE_TEXT);
        label.setWidth(240);
        label.setPadding(10);
        label.setLeft(200);
        label.setTop(20);
        label.setBackgroundColor("white");
        label.setBorder("1px solid #c0c0c0");
        label.setCanDragReposition(true);
        label.setShowShadow(true);
        label.setShadowSoftness(10);
        label.setShadowOffset(5);
        label.setKeepInParentRect(true);

        final Slider softness = new Slider("Softness");
        softness.setMinValue(1.0);
        softness.setMaxValue(10.0);
        softness.setNumValues(11);
        softness.setShowRange(false);
        softness.setLabelWidth(40);
        softness.setValue(10.0);
        softness.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                softness.addValueChangedHandler(new ValueChangedHandler() {
                    public void onValueChanged(ValueChangedEvent event) {
                        label.setShadowSoftness((int)event.getValue());
                        label.updateShadow();
                    }
                });
            }
        });


        final Slider offset = new Slider("Offset");
        offset.setMinValue(0.0);
        offset.setMaxValue(20.0);
        offset.setNumValues(21);
        offset.setShowRange(false);
        offset.setLabelWidth(40);
        offset.setLeft(80);
        offset.setValue(5.0);
        
        offset.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                offset.addValueChangedHandler(new ValueChangedHandler() {
                    public void onValueChanged(ValueChangedEvent event) {
                        label.setShadowOffset((int)event.getValue());
                        label.updateShadow();
                    }
                });
            }
        });


        canvas.addChild(softness);
        canvas.addChild(offset);
        canvas.addChild(label);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }


}