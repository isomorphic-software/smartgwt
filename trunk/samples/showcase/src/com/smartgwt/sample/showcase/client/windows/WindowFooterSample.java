package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowFooterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Windows support a footer with a visible resizer and updateable status bar.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowFooterSample panel = new WindowFooterSample();
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

        final Window window = new Window();
        window.setTitle("Window with footer");
        window.setWidth(200);
        window.setHeight(200);
        window.setCanDragResize(true);
        window.setShowFooter(true);

        Label label = new Label();
        label.setContents("Click Me");
        label.setAlign(Alignment.CENTER);
        label.setPadding(5);
        label.setHeight100();
        label.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                window.setStatus("Click at: " + event.getX() + ", " + event.getY());
            }
        });
        window.addItem(label);
        canvas.addChild(window);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}