package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowDraggingSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Grab the window by its title bar to move it around. Resize it by the right or bottom edge.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowDraggingSample panel = new WindowDraggingSample();
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
        Label label = new Label(
                "<b>Severity 1</b> - Critical problem<br/>System is unavailable in production or is corrupting data, and the error severely impacts the user's operations.<br/><br/>"
                        + "<b>Severity 2</b> - Major problem<br/>An important function of the system is not available in production, and the user's operations are restricted.<br/><br/>"
                        + "<b>Severity 3</b> - Minor problem<br/>Inability to use a function of the system occurs, but it does not seriously affect the user's operations.");
        label.setHeight100();
        label.setPadding(10);
        label.setDefaultWidth(300);
        label.setValign(VerticalAlignment.TOP);

        Window window = new Window();
        window.setTitle("Severity Levels");
        window.setAutoSize(true);
        window.setCanDragReposition(true);
        window.setCanDragResize(true);
        window.addItem(label);
        
        Canvas canvasMain = new Canvas();
        canvasMain.addChild(window);
        return canvasMain;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}