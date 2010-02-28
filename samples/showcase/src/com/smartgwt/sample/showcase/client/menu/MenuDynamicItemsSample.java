package com.smartgwt.sample.showcase.client.menu;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MenuDynamicItemsSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Open the \"File\" menu to see the \"New file in..\" item initially disabled." +
            " Select a project and note that the menu item has become enabled, changed title" +
            " and changed icon.<p></p>Pick \"Project Listing\" to show and hide the project list," +
            " and note the item checks and unchecks itself.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MenuDynamicItemsSample panel = new MenuDynamicItemsSample();
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

    class ProjectRecord extends ListGridRecord {
        ProjectRecord(String project) {
            setAttribute("project", project);
        }
    }

    //TODO this sample is incomplete
    public Canvas getViewPanel() {

        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth(130);
        listGrid.setFields(new ListGridField("project", "Project"));
        listGrid.setData(new ProjectRecord[]{
                new ProjectRecord("AJAX Interface"),
                new ProjectRecord("Simplify Backend"), new ProjectRecord("Broaden Reach")});


        Menu menu = new Menu();
        menu.setShowShadow(true);
        menu.setShadowDepth(10);

        final MenuItem newItem = new MenuItem("New file in...", "icons/16/document_plain_new_Disabled.png", "Ctrl+N");
        newItem.setEnableIfCondition(new MenuItemIfFunction() {
            public boolean execute(Canvas target, Menu menu, MenuItem item) {
                return listGrid.getSelectedRecord() != null;
            }
        });
        MenuItem openItem = new MenuItem("Open", "icons/16/folder_out.png", "Ctrl+O");
        MenuItem saveItem = new MenuItem("Save", "icons/16/disk_blue.png", "Ctrl+S");
        MenuItem saveAsItem = new MenuItem("Save As", "icons/16/save_as.png");

        MenuItem projectItem = new MenuItem("Project Listing");
        projectItem.setChecked(true);

        MenuItemSeparator separator = new MenuItemSeparator();

        //menu.setData(newItem, openItem, separator, saveItem, saveAsItem, separator, projectItem);
        menu.addItem(newItem);
        menu.addItem(openItem);
        menu.addItem(separator);
        menu.addItem(saveItem);
        menu.addItem(saveAsItem);
        menu.addItem(separator);
        menu.addItem(projectItem);
                
        IMenuButton menuButton = new IMenuButton("File", menu);

        VLayout hLayout = new VLayout();
        hLayout.addMember(listGrid);
        hLayout.addMember(menuButton);

        return hLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}