package com.smartgwt.sample.showcase.client.toolstrip;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class ToolStripSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the icons at left to see \"radio\"-style selection. Click the drop-down to see font options.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ToolStripSample panel = new ToolStripSample();
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
        toolStrip.setWidth(500);

        //push all buttons to the right
        toolStrip.addFill();

        ToolStripButton iconButton = new ToolStripButton();
        iconButton.setIcon("silk/printer.png");
        iconButton.setTitle("Print");
        toolStrip.addButton(iconButton);

        toolStrip.addResizer();

        ToolStripButton boldButton = new ToolStripButton();
        boldButton.setIcon("[SKIN]/RichTextEditor/text_bold.png");
        boldButton.setActionType(SelectionType.CHECKBOX);
        toolStrip.addButton(boldButton);
        
        ToolStripButton italicsButton = new ToolStripButton();
        italicsButton.setIcon("[SKIN]/RichTextEditor/text_italic.png");
        italicsButton.setActionType(SelectionType.CHECKBOX);
        toolStrip.addButton(italicsButton);
        
        ToolStripButton underlineButton = new ToolStripButton();
        underlineButton.setIcon("[SKIN]/RichTextEditor/text_underline.png");
        underlineButton.setActionType(SelectionType.CHECKBOX);
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

        toolStrip.addSeparator();

        SelectItem fontItem = new SelectItem();
        fontItem.setShowTitle(false);
        fontItem.setWidth(120);

        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("courier", "<span style='font-family:courier'>Courier</span>");
        valueMap.put("verdana", "<span style='font-family:verdana'>Verdana</span>");
        valueMap.put("times", "<span style='font-family:times'>Times</span>");
        fontItem.setValueMap(valueMap);
        fontItem.setDefaultValue("verdana");

        toolStrip.addFormItem(fontItem);

        toolStrip.addResizer();

        SelectItem zoomItems = new SelectItem();
        zoomItems.setName("selectName");
        zoomItems.setShowTitle(false);
        zoomItems.setWidth(100);
        zoomItems.setValueMap("50%", "75%", "100%", "200%", "Fit");
        zoomItems.setDefaultValue("100%");

        toolStrip.addFormItem(zoomItems);
        
        return toolStrip;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}