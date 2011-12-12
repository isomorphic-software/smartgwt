package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowMinimizeSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Click on the minimize button (round button in header with flat line).";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowMinimizeSample panel = new WindowMinimizeSample();
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
        Label label = new Label("Staging: <span style=\"color: green; font-weight: bold;\">Normal</span><br/>"
                + "Production: <span style=\"color: green; font-weight: bold;\">Normal</span><br/>"
                + "Development: <span style=\"color: green; font-weight: bold;\">Normal</span>");
        label.setHeight100();
        label.setPadding(5);
        label.setValign(VerticalAlignment.TOP);
        
        Window window = new Window();
        window.setTitle("Minimizing a window");
        window.setWidth(300);
        window.setHeight(85);
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