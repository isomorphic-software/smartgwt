package com.smartgwt.sample.showcase.client.toolstrip;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ToolStripVerticalSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This is an example of a Vertical ToolStrip.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ToolStripVerticalSample panel = new ToolStripVerticalSample();
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
        toolStrip.setVertical(true);
        toolStrip.setHeight(160);
        toolStrip.setWidth(30);

        ToolStripButton iconButton = new ToolStripButton();
        iconButton.setIcon("silk/printer.png");
        iconButton.setPrompt("Print");
        toolStrip.addButton(iconButton);

        toolStrip.addResizer();

        ToolStripButton boldButton = new ToolStripButton();
        boldButton.setIcon("[SKIN]/RichTextEditor/text_bold.png");
        boldButton.setActionType(SelectionType.CHECKBOX);
        boldButton.setShowFocused(false);
        toolStrip.addButton(boldButton);

        ToolStripButton italicsButton = new ToolStripButton();
        italicsButton.setIcon("[SKIN]/RichTextEditor/text_italic.png");
        italicsButton.setActionType(SelectionType.CHECKBOX);
        italicsButton.setShowFocused(false);
        toolStrip.addButton(italicsButton);

        ToolStripButton underlineButton = new ToolStripButton();
        underlineButton.setIcon("[SKIN]/RichTextEditor/text_underline.png");
        underlineButton.setActionType(SelectionType.CHECKBOX);
        underlineButton.setShowFocused(false);
        toolStrip.addButton(underlineButton);

        toolStrip.addSeparator();

        ToolStripButton alignLeftButton = new ToolStripButton();
        alignLeftButton.setIcon("[SKIN]/RichTextEditor/text_align_left.png");
        alignLeftButton.setActionType(SelectionType.RADIO);
        alignLeftButton.setRadioGroup("textAlign");
        toolStrip.addButton(alignLeftButton);

        ToolStripButton alignRightButton = new ToolStripButton();
        alignRightButton.setIcon("[SKIN]/RichTextEditor/text_align_right.png");
        alignRightButton.setActionType(SelectionType.RADIO);
        alignRightButton.setRadioGroup("textAlign");
        toolStrip.addButton(alignRightButton);

        ToolStripButton alignCenterButton = new ToolStripButton();
        alignCenterButton.setIcon("[SKIN]/RichTextEditor/text_align_center.png");
        alignCenterButton.setActionType(SelectionType.RADIO);
        alignCenterButton.setRadioGroup("textAlign");
        toolStrip.addButton(alignCenterButton);

        //push all buttons to the top
        toolStrip.addFill();
        return toolStrip;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}