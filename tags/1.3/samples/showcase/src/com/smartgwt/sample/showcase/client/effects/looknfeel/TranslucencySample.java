package com.smartgwt.sample.showcase.client.effects.looknfeel;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TranslucencySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag the slider to change opacity.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            TranslucencySample panel = new TranslucencySample();
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
        
        final Img eyesImg = new Img("other/eyes.jpg", 360, 188);
        eyesImg.setShowEdges(true);
        
        Slider slider = new Slider("");
        slider.setMinValue(0);
        slider.setMaxValue(100);
        slider.setShowRange(false);
        slider.setShowTitle(false);
        slider.setVertical(false);
        slider.setLeft(80);
        slider.setTop(200);
        slider.setValue(100);
        slider.addValueChangedHandler(new ValueChangedHandler() {
            public void onValueChanged(ValueChangedEvent event) {
                eyesImg.setOpacity(event.getValue());
            }
        });
        
        Canvas canvas = new Canvas();
        canvas.addChild(eyesImg);
        canvas.addChild(slider);
        
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}