package com.smartgwt.sample.showcase.client.toolstrip;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class RibbonBarSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>A RibbonBar is a customized ToolStrip which displays controls in separately titled RibbonGroups.</p>" +
            "<p>The RibbonBar controls the overall presence, placement and text-alignment of each group's title and these can be overridden for individual groups. " +
            "Groups can have multiple rows of controls (group.numRows) and additional columns of rows are automatically added when that number is exceeded. Controls can also span multiple rows (control.rowSpan).</p>" +
            "<p>The example below demonstrates a RibbonBar using it's default RibbonGroup and IconButton/IconMenuButton classes to show various groups with different layouts. You can see groups with horizontal and " +
            "vertical buttons, some of each showing their menuIcons. The 'File' and 'Undo' buttons also have their showMenuIconOver attribute set to true, which causes mouseOver styling on the menuIcon.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RibbonBarSample panel = new RibbonBarSample();
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
        RibbonBar ribbonBar = new RibbonBar();
        ribbonBar.setLeft(0);
        ribbonBar.setTop(75);
        ribbonBar.setWidth100();

        ribbonBar.setMembersMargin(2);
        ribbonBar.setLayoutMargin(2);

        Menu menu = new Menu();
        
        menu.addItem(new MenuItem("Document", "icons/16/document_plain_new.png", "Ctrl+D"));
        menu.addItem(new MenuItem("Picture", "icons/16/folder_out.png", "Ctrl+P"));
        menu.addItem(new MenuItem("Email", "icons/16/disk_blue.png", "Ctrl+E"));

        RibbonGroup fileGroup = new RibbonGroup();
        fileGroup.setTitle("File");
        fileGroup.setTitleAlign(Alignment.LEFT);
        fileGroup.setNumRows(3);
        fileGroup.setRowHeight(26);
        fileGroup.addControl(getIconMenuButton("New", "piece_blue", menu, true));
        fileGroup.addControl(getIconButton("Open", "star_yellow", true));
        fileGroup.addControl(getIconButton("Save", "pawn_red", true));
        fileGroup.addControl(getIconMenuButton("Save As", "cube_green", menu, true));

        RibbonGroup editGroup = new RibbonGroup();
        editGroup.setTitle("Edit");
        editGroup.setNumRows(3);
        editGroup.setRowHeight(26);
        editGroup.addControl(getIconButton("Edit", "piece_blue", false));
        editGroup.addControl(getIconButton("Copy", "pawn_green", false));
        editGroup.addControl(getIconButton("Paste", "cube_yellow", false));
        editGroup.addControl(getIconMenuButton("Undo", null, menu, false));
        editGroup.addControl(getIconMenuButton("Redo", null, menu, false));


        RibbonGroup insertGroup = new RibbonGroup();
        insertGroup.setTitle("Insert");
        insertGroup.setNumRows(3);
        insertGroup.setRowHeight(26);
        insertGroup.addControl(getIconMenuButton("Picture", null, menu, true));
        insertGroup.addControl(getIconButton("Link", "pawn_white", false));
        insertGroup.addControl(getIconButton("Document", "star_yellow", false));
        insertGroup.addControl(getIconButton("Video", "piece_red", false));

        ribbonBar.addMember(fileGroup);
        ribbonBar.addMember(editGroup);
        ribbonBar.addMember(insertGroup);

        return ribbonBar;

    }

    private IconButton getIconButton(String title, String iconName, boolean vertical) {
        IconButton button = new IconButton(title);
        button.setTitle(title);
        if (iconName == null) iconName = "cube_blue";
        button.setIcon("pieces/16/" + iconName + ".png");
        button.setLargeIcon("pieces/48/" + iconName + ".png");
        if (vertical == true) button.setOrientation("vertical");
        return button;
    }

    private IconMenuButton getIconMenuButton(String title, String iconName, Menu menu, boolean vertical) {
        IconMenuButton button = new IconMenuButton();
        button.setTitle(title);
        if (iconName == null) iconName = "cube_blue";
        button.setIcon("pieces/16/" + iconName + ".png");
        button.setLargeIcon("pieces/48/" + iconName + ".png");
        if (vertical == true) button.setOrientation("vertical");
        if (menu != null) button.setMenu(menu);

        button.setShowMenuIcon(true);
        return button;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
