package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;
import com.smartgwt.sample.showcase.client.data.PartRecord;

public class DragMenuGridSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Open the parts menu and drag parts from the menu onto the grid. Menus support all the drag and drop behaviors supported by grids.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragMenuGridSample panel = new DragMenuGridSample();
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
        ListGridField partSrcField = new ListGridField("partSrc", 20);
        partSrcField.setType(ListGridFieldType.IMAGE);
        partSrcField.setImgDir("pieces/16/");

        ListGridField partNameField = new ListGridField("partName");
        partNameField.setWidth(70);
        menu.setFields(partSrcField, partNameField);

        menu.setData(PartData.getRecords());
        menu.setSelectionType(SelectionStyle.SINGLE);
        menu.setCanDragRecordsOut(true);
        menu.setDragDataAction(DragDataAction.MOVE);

        IMenuButton menuButton = new IMenuButton();
        menuButton.setTitle("Parts");
        menuButton.setMenu(menu);


        ListGrid partsGrid = new ListGrid();
        partsGrid.setWidth(300);
        partsGrid.setCanAcceptDroppedRecords(true);
        partsGrid.setCanReorderFields(true);

        ListGridField partSrcField2 = new ListGridField("partSrc", 80);
        partSrcField2.setType(ListGridFieldType.IMAGE);
        partSrcField2.setImgDir("pieces/16/");

        ListGridField partNameField2 = new ListGridField("partName");
        partNameField2.setWidth(140);
        ListGridField partNumField2 = new ListGridField("partNum", 80);

        partsGrid.setFields(partSrcField2, partNameField2, partNumField2);

        partsGrid.setData(new Record[] {
                new PartRecord("Blue", "cube_blue.png", 1),
                new PartRecord("Yellow", "cube_yellow.png", 2),
        });

        HStack layout = new HStack(70);
        layout.setHeight(160);
        layout.setMembers(menuButton, partsGrid);
        return layout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}