package com.smartgwt.sample.showcase.client.other;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SliderSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Move either Slider to update the other. You can change the value by clicking and dragging the thumb, " +
            "clicking on the track, or using the keyboard (once you've focused on one of the sliders).";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SliderSample panel = new SliderSample();
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

        final Slider vSlider = new Slider("Rating");
        vSlider.setMinValue(1);
        vSlider.setMaxValue(5);
        vSlider.setNumValues(5);
        vSlider.setHeight(300);
        canvas.addChild(vSlider);

        final Slider hSlider = new Slider("Rating");
        hSlider.setVertical(false);
        hSlider.setMinValue(1);
        hSlider.setMaxValue(5);
        hSlider.setNumValues(5);
        hSlider.setTop(200);
        hSlider.setLeft(100);
        canvas.addChild(hSlider);

        hSlider.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                vSlider.addValueChangedHandler(new ValueChangedHandler() {
                    public void onValueChanged(ValueChangedEvent event) {
                        int value = event.getValue();
                        if (hSlider.getValue() != value) {
                            hSlider.setValue(value);
                        }
                    }
                });
            }
        });

        hSlider.addDrawHandler(new DrawHandler() {
            public void onDraw(DrawEvent event) {
                hSlider.addValueChangedHandler(new ValueChangedHandler() {
                    public void onValueChanged(ValueChangedEvent event) {
                        int value = event.getValue();
                        if (vSlider.getValue() != value) {
                            vSlider.setValue(value);
                        }
                    }
                });
            }
        });


        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}