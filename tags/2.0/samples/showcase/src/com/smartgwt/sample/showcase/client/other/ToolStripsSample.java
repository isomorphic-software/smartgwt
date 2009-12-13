package com.smartgwt.sample.showcase.client.other;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class ToolStripsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click the icons at left to see \"radio\"-style selection. Click the drop-down to see font options.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ToolStripsSample panel = new ToolStripsSample();
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
        toolStrip.setWidth(450);
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

        ToolStripSeparator stripSeparator = new ToolStripSeparator();
        stripSeparator.setHeight(8);

        toolStrip.addMember(stripSeparator);
        
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

        toolStrip.addMember(stripSeparator);

        DynamicForm fontForm = new DynamicForm();
        fontForm.setShowResizeBar(true);
        fontForm.setWidth("*");
        fontForm.setMinWidth(50);
        fontForm.setNumCols(1);

        SelectItem fontItem = new SelectItem();
        fontItem.setShowTitle(false);
        fontItem.setWidth("*");

        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("courier", "<span style='font-family:courier'>Courier</span>");
        valueMap.put("verdana", "<span style='font-family:verdana'>Verdana</span>");
        valueMap.put("times", "<span style='font-family:times'>Times</span>");
        fontItem.setValueMap(valueMap);
        fontForm.setItems(fontItem);
        fontItem.setDefaultValue("courier");
        toolStrip.addMember(fontForm);

        //toolStrip.addMember(new ToolStripResizer());
        
        DynamicForm zoomForm = new DynamicForm();
        zoomForm.setWidth("*");
        zoomForm.setMinWidth(50);
        zoomForm.setNumCols(1);

        SelectItem zoomItems = new SelectItem();
        zoomItems.setName("selectName");
        zoomItems.setShowTitle(false);
        zoomItems.setWidth("*");
        zoomItems.setValueMap("50%", "75%", "100%", "200%", "Fit");
        zoomItems.setDefaultValue("100%");
        zoomForm.setItems(zoomItems);

        toolStrip.addMember(zoomForm);
        
        return toolStrip;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}