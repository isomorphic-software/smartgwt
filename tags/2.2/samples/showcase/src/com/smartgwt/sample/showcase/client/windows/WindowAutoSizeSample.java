package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowAutoSizeSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Windows can autoSize to content or can dictate the content's size.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowAutoSizeSample panel = new WindowAutoSizeSample();
            id = panel.getID();
            return panel;
        }

        public String getDescription() {
            return DESCRIPTION;
        }

        public String getID() {
            return id;
        }
    }

    public static Window createWin(String title, boolean autoSizing, int width, int height, int offsetLeft) {
        Label label = new Label(
                "<b>Severity 1</b> - Critical problem<br/>System is unavailable in production or is corrupting data, and the error severely impacts the user's operations.<br/><br/>"
                        + "<b>Severity 2</b> - Major problem<br/>An important function of the system is not available in production, and the user's operations are restricted.<br/><br/>"
                        + "<b>Severity 3</b> - Minor problem<br/>Inability to use a function of the system occurs, but it does not seriously affect the user's operations.");
        label.setWidth100();
        label.setHeight100();
        label.setPadding(5);
        label.setValign(VerticalAlignment.TOP);

        Window window = new Window();
        window.setAutoSize(autoSizing);
        window.setTitle(title);
        window.setWidth(width);
        window.setHeight(height);
        window.setLeft(offsetLeft);
        window.setCanDragReposition(true);
        window.setCanDragResize(true);
        window.addItem(label);

        return window;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    public Canvas getViewPanel() {
        Canvas canvasMain = new Canvas();
        canvasMain.addChild(createWin("Auto-sizing window", true, 300, 190, 0));
        canvasMain.addChild(createWin("Normal window", false, 220, 250, 320));
        return canvasMain;
    }
}