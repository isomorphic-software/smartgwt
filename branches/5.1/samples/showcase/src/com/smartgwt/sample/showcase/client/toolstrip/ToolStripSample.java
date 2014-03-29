package com.smartgwt.sample.showcase.client.toolstrip;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;
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
        toolStrip.setWidth(600);

        //push all buttons to the right
        toolStrip.addFill();

        ToolStripMenuButton menuButton = getToolStripMenuButton();
        toolStrip.addMenuButton(menuButton);

        toolStrip.addSeparator();

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

    private ToolStripMenuButton getToolStripMenuButton() {
        Menu menu = new Menu();
        menu.setShowShadow(true);
        menu.setShadowDepth(3);

        MenuItem newItem = new MenuItem("New", "icons/16/document_plain_new.png", "Ctrl+N");
        MenuItem openItem = new MenuItem("Open", "icons/16/folder_out.png", "Ctrl+O");
        MenuItem saveItem = new MenuItem("Save", "icons/16/disk_blue.png", "Ctrl+S");
        MenuItem saveAsItem = new MenuItem("Save As", "icons/16/save_as.png");

        MenuItem recentDocItem = new MenuItem("Recent Documents", "icons/16/folder_document.png");

        Menu recentDocSubMenu = new Menu();
        MenuItem dataSM = new MenuItem("data.xml");
        dataSM.setChecked(true);
        MenuItem componentSM = new MenuItem("Component Guide.doc");
        MenuItem ajaxSM = new MenuItem("AJAX.doc");
        recentDocSubMenu.setItems(dataSM, componentSM, ajaxSM);

        recentDocItem.setSubmenu(recentDocSubMenu);

        MenuItem exportItem = new MenuItem("Export as...", "icons/16/export1.png");
        Menu exportSM = new Menu();
        exportSM.setItems(
                new MenuItem("XML"),
                new MenuItem("CSV"),
                new MenuItem("Plain text"));
        exportItem.setSubmenu(exportSM);

        MenuItem printItem = new MenuItem("Print", "icons/16/printer3.png", "Ctrl+P");
        printItem.setEnabled(false);

        MenuItemSeparator separator = new MenuItemSeparator();

        final MenuItem activateMenu = new MenuItem("Activate");
        activateMenu.setDynamicTitleFunction(new MenuItemStringFunction() {

            public String execute(final Canvas aTarget, final Menu aMenu, final MenuItem aItem) {
                if (Math.random() > 0.5) {
                    return "De-Activate Blacklist";
                } else {
                    return "Activate Blacklist";
                }
            }
        });

        menu.setItems(activateMenu, newItem, openItem, separator, saveItem, saveAsItem,
                separator, recentDocItem, separator, exportItem, separator, printItem);

        ToolStripMenuButton menuButton = new ToolStripMenuButton("File", menu);
        menuButton.setWidth(100);
        return menuButton;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}