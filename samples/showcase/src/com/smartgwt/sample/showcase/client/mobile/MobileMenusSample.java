package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.client.widgets.menu.MenuItemStringFunction;
import com.smartgwt.client.types.PanelPlacement;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MobileMenusSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Menu components have a special mode for mobile devices.  Touch or click the "+
    "\"File\" MenuButton below and the Menu will fill the screen with a simplified appearance that "+
    "omits any rounding or shadows (skin-specific)."+
    "<p>"+
    "Touch the \"Recent Documents\" menu - the submenu appears using a smooth slide transition, "+
    "and the navigation bar offers the ability to get back to the main menu or dismiss the "+
    "entire menu."+
    "<p>"+
    "These features are automatically enabled for handset / phone-sized devices, but can be enabled for "+
    "any size device, and is enabled for every kind of device in this sample.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MobileMenusSample panel = new MobileMenusSample();
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
        Menu menu = new Menu();
        menu.setShowShadow(true);
        menu.setShadowDepth(10);
        menu.setPlacement(PanelPlacement.FILLSCREEN);

        MenuItem newItem = new MenuItem("New", "icons/16/document_plain_new.png", "Ctrl+N");
        MenuItem openItem = new MenuItem("Open", "icons/16/folder_out.png", "Ctrl+O");
        MenuItem saveItem = new MenuItem("Save", "icons/16/disk_blue.png", "Ctrl+S");
        MenuItem saveAsItem = new MenuItem("Save As", "icons/16/save_as.png");

        MenuItem recentDocItem = new MenuItem("Recent Documents", "icons/16/folder_document.png");

        Menu recentDocSubMenu = new Menu();
        MenuItem dataSM = new MenuItem("data.xml");
        dataSM.setChecked(true);
        MenuItem componentSM = new MenuItem("Component Guide.doc");
        MenuItem smartClientSM = new MenuItem("SmartClient.doc");
        smartClientSM.setChecked(true);
        MenuItem ajaxSM = new MenuItem("AJAX.doc");
        recentDocSubMenu.setItems(dataSM, componentSM, smartClientSM, ajaxSM);

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

        IMenuButton menuButton = new IMenuButton("File", menu);
        menuButton.setWidth(100);

        HStack layout = new HStack();
        layout.setWidth100();
        layout.setMembers(menuButton);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
