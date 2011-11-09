package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowHeaderControlsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Header controls can be reordered and custom controls added.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            WindowHeaderControlsSample panel = new WindowHeaderControlsSample();
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

    class StatusCanvas extends Canvas {
        public void setNewStatus(String system) {
            setContents(system + ": <span style='color:green;font-weight:bold'>Normal</span><br>");
        }
    }

    public Canvas getViewPanel() {
        Canvas canvas = new Canvas();

        final StatusCanvas statusReportCanvas = new StatusCanvas();
        statusReportCanvas.setPadding(5);
        statusReportCanvas.setWidth100();
        statusReportCanvas.setHeight100();

        DynamicForm systemSelector = new DynamicForm();
        systemSelector.setWidth(75);
        systemSelector.setNumCols(1);
        systemSelector.setLayoutAlign(Alignment.CENTER);

        SelectItem selectFont = new SelectItem();
        selectFont.setHeight(19);
        selectFont.setName("selectFont");
        selectFont.setWidth(120);
        selectFont.setShowTitle(false);
        selectFont.setValueMap("Development", "Staging", "Production");
        selectFont.setDefaultValue("Development");
        selectFont.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                statusReportCanvas.setNewStatus((String)event.getValue());
            }
        });
        systemSelector.setItems(selectFont);

        final Window window = new Window();
        window.setTitle("Status");
        window.setWidth(300);
        window.setHeight(200);
        window.setCanDragReposition(true);
        window.setCanDragResize(true);
        window.setHeaderControls(HeaderControls.CLOSE_BUTTON, HeaderControls.MINIMIZE_BUTTON, HeaderControls.HEADER_LABEL,  systemSelector);

        window.addItem(statusReportCanvas);
        statusReportCanvas.setNewStatus("Development");

        canvas.addChild(window);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}