package com.smartgwt.sample.showcase.client.buttons;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ButtonRadioToggleSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the buttons for Bold, Italic, and Underline and note that they stick in" +
           " a down state. Click on the buttons for left, center and right justify and note" +
           " that they are mutually exclusive.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ButtonRadioToggleSample panel = new ButtonRadioToggleSample();
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
        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setWidth(200);
        toolStrip.setHeight(24);

        ImgButton boldButton = new ImgButton();
        boldButton.setSize(24);
        boldButton.setShowRollOver(false);
        boldButton.setSrc("icons/24/text_bold.png");
        boldButton.setActionType(SelectionType.CHECKBOX);
        toolStrip.addMember(boldButton);
        
        ImgButton italicsButton = new ImgButton();
        italicsButton.setSize(24);
        italicsButton.setShowRollOver(false);
        italicsButton.setSrc("icons/24/text_italics.png");
        italicsButton.setActionType(SelectionType.CHECKBOX);
        toolStrip.addMember(italicsButton);
        
        ImgButton underlineButton = new ImgButton();
        underlineButton.setSize(24);
        underlineButton.setShowRollOver(false);
        underlineButton.setSrc("icons/24/text_underlined.png");
        underlineButton.setActionType(SelectionType.CHECKBOX);
        toolStrip.addMember(underlineButton);
        
        ImgButton alignLeftButton = new ImgButton();
        alignLeftButton.setSize(24);
        alignLeftButton.setShowRollOver(false);
        alignLeftButton.setSrc("icons/24/text_align_left.png");
        alignLeftButton.setActionType(SelectionType.RADIO);
        alignLeftButton.setRadioGroup("textAlign");
        toolStrip.addMember(alignLeftButton);
        
        ImgButton alignRightButton = new ImgButton();
        alignRightButton.setSize(24);
        alignRightButton.setShowRollOver(false);
        alignRightButton.setSrc("icons/24/text_align_right.png");
        alignRightButton.setActionType(SelectionType.RADIO);
        alignRightButton.setRadioGroup("textAlign");
        toolStrip.addMember(alignRightButton);
        
        ImgButton alignCenterButton = new ImgButton();
        alignCenterButton.setSize(24);
        alignCenterButton.setShowRollOver(false);
        alignCenterButton.setSrc("icons/24/text_align_center.png");
        alignCenterButton.setActionType(SelectionType.RADIO);
        alignCenterButton.setRadioGroup("textAlign");
        toolStrip.addMember(alignCenterButton);
        
        VLayout layout = new VLayout();
        layout.setAutoHeight();
        layout.addMember(toolStrip);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}