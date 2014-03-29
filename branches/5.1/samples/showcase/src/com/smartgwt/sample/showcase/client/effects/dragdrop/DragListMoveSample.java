package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;


public class DragListMoveSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to copy items from the first list to the second list. You can drag over the top or bottom " +
            "edge of a scrolling list to scroll in that direction before dropping.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragListMoveSample panel = new DragListMoveSample();
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
        HStack hStack = new HStack(10);
        hStack.setHeight(160);

        final PartsListGrid myList1 = new PartsListGrid();
        myList1.setCanDragRecordsOut(true);
        myList1.setCanAcceptDroppedRecords(true);
        myList1.setCanReorderFields(true);
        myList1.setDragDataAction(DragDataAction.MOVE);
        myList1.setData(PartData.getRecords());
        hStack.addMember(myList1);

        final PartsListGrid myList2 = new PartsListGrid();
        myList2.setCanDragRecordsOut(true);
        myList2.setCanAcceptDroppedRecords(true);
        myList2.setCanReorderRecords(true);

        VStack vStack = new VStack(10);
        vStack.setWidth(32);
        vStack.setHeight(74);
        vStack.setLayoutAlign(Alignment.CENTER);

        TransferImgButton rightImg = new TransferImgButton(TransferImgButton.RIGHT);
        rightImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myList2.transferSelectedData(myList1);
            }
        });
        vStack.addMember(rightImg);

        TransferImgButton leftImg = new TransferImgButton(TransferImgButton.LEFT);
        leftImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myList1.transferSelectedData(myList2);
            }
        });
        vStack.addMember(leftImg);

        hStack.addMember(vStack);
        hStack.addMember(myList2);

        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}