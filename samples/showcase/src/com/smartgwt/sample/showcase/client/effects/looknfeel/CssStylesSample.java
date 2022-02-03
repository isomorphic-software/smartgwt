package com.smartgwt.sample.showcase.client.effects.looknfeel;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CssStylesSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Click the radio buttons to apply different CSS styles to the text. "
            + "Click the CSS tab for CSS class definitions.</p>"
            + "<p>This container auto-sizes to the styled text.</p>";

    private static final String EXAMPLE_TEXT = "When in the Course of human events, it becomes necessary for one people "
            + "to dissolve the political bands which have connected them with another, "
            + "and to assume among the powers of the earth, the separate and equal station "
            + "to which the Laws of Nature and of Nature's God entitle them, a decent respect "
            + "to the opinions of mankind requires that they should declare the causes which impel "
            + "them to the separation.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            CssStylesSample panel = new CssStylesSample();
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
        
        final HTMLFlow textBox = new HTMLFlow(EXAMPLE_TEXT);
        textBox.setLeft(100);
        textBox.setWidth(300);
        textBox.setStyleName("exampleStyleOnline");
        
        LinkedHashMap<String, String> styleMap = new LinkedHashMap<String, String>();
        styleMap.put("exampleStyleOnline", "Online");
        styleMap.put("exampleStyleLegal", "Legal");
        styleMap.put("exampleStyleCode", "Code");
        styleMap.put("exampleStyleInformal", "Informal");
        
        RadioGroupItem style = new RadioGroupItem();
        style.setDefaultValue("exampleStyleOnline");
        style.setShowTitle(false);
        style.setValueMap(styleMap);
        style.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                textBox.setStyleName((String)event.getValue());
                textBox.markForRedraw();
            }
        });
        
        DynamicForm controls = new DynamicForm();
        controls.setFields(style);
        
        Canvas canvas = new Canvas();
        canvas.addChild(textBox);
        canvas.addChild(controls);
        
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}