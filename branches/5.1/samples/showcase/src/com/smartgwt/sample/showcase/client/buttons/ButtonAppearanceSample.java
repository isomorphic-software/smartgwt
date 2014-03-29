
package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonAppearanceSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Buttons come in three basic types: CSS buttons, single-image buttons, and" +
           " multiple-image stretch buttons. All share a basic set of capabilities.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ButtonAppearanceSample panel = new ButtonAppearanceSample();
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

        final IButton stretchButton = new IButton("Stretch Button");
        stretchButton.setWidth(150);
        stretchButton.setShowRollOver(true);
        stretchButton.setShowDisabled(true);
        stretchButton.setShowDown(true);
        stretchButton.setTitleStyle("stretchTitle");
        stretchButton.setIcon("silk/printer.png");

        final Button cssButton = new Button("CSS Button");
        cssButton.setShowRollOver(true);
        cssButton.setShowDisabled(true);
        cssButton.setShowDown(true);
        cssButton.setIcon("silk/printer.png");

        final ImgButton imgButton = new ImgButton();
        imgButton.setWidth(18);
        imgButton.setHeight(18);
        imgButton.setShowRollOver(true);
        imgButton.setShowDown(true);
        imgButton.setSrc("[SKIN]/ImgButton/button.png");

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(20);
        hLayout.addMember(stretchButton);
        hLayout.addMember(cssButton);
        hLayout.addMember(imgButton);

        VLayout layout = new VLayout();
        layout.setAutoHeight();
        layout.setMembersMargin(30);
        layout.addMember(hLayout);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}


