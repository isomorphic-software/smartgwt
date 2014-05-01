package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.types.PanelPlacement;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MobileWindowsDialogsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Window &amp; Dialog components have a special mode for mobile devices.  Press "+
                    "the \"Show\" button below and a Window will fill the screen with a simplified appearance that "+
                    "omits any rounding or shadows (skin-specific).  These features are automatically enabled for handset "+
                    "/ phone-sized devices, but can be enabled for any size device, and is enabled for every kind of "+
                    "device in this sample. "+
                    "<p>"+
                    "Dismiss the Window and press the \"Ask for Value\" button - <b>if you are on a mobile phone</b>, "+
                    "the built-in Dialog that asks end users for values behaves the same way.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MobileWindowsDialogsSample panel = new MobileWindowsDialogsSample();
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
        final Canvas helpCanvas = new Canvas();
	    helpCanvas.setDefaultWidth(300);
	    helpCanvas.setPadding(10);
	    helpCanvas.setContents("<b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
              "is corrupting data, and the error severely impacts the user's operations." +
              "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
              "is not available in production, and the user's operations are restricted." +
              "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
              "system occurs, but it does not seriously affect the user's operations.");
        Button showButton = new Button();
        showButton.setTitle("Show");
        showButton.setWidth(100);
        showButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window window = new Window();
                window.setPlacement(PanelPlacement.FILLSCREEN);
                window.setTitle("Window");
                window.setCanDragReposition(true);
                window.setCanDragResize(true);
                window.addItem(helpCanvas);
                window.show();
            }
	
        });
        Button askForValueButton = new Button();
        askForValueButton.setTitle("Ask for Value");
        askForValueButton.setWidth(100);
        askForValueButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.askforValue("", null);
            }
		
        });
	
        HLayout hl = new HLayout();
        hl.setWidth(300);
        hl.setLayoutMargin(5);
        hl.setMembersMargin(10);
	    
        hl.setMembers(showButton, askForValueButton);

        return hl;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
