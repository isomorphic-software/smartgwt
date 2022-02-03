package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;


public class DragListCopySample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Drag and drop to copy items from the first list to the second list. " +
            "You can drag over the top or bottom edge of a scrolling list to scroll in that direction before dropping.</p>" +
            "<p>You can also use the various transfer icons to move / reorder records. The icons shown below are part of the " +
            "standard library and is accessible using the constants in the class TransferImgButton.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragListCopySample panel = new DragListCopySample();
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
        myList1.setEmptyMessage("No Records");
        myList1.setCanDragRecordsOut(true);
        myList1.setCanReorderFields(true);
        myList1.setDragDataAction(DragDataAction.MOVE);
        //RecordList data = new RecordList();
        Record[] data = PartData.getRecords();
        myList1.setData(data);
        hStack.addMember(myList1);

        VStack transferStack = new VStack(3);
        transferStack.setWidth(20);
        transferStack.setAlign(VerticalAlignment.CENTER);

        final PartsListGrid myList2 = new PartsListGrid();
        myList2.setEmptyMessage("No Records");
        myList2.setCanAcceptDroppedRecords(true);
        myList2.setCanReorderRecords(true);

        TransferImgButton right = new TransferImgButton(TransferImgButton.RIGHT);
        right.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myList2.transferSelectedData(myList1);
            }
        });

        TransferImgButton rightAll = new TransferImgButton(TransferImgButton.RIGHT_ALL);
        rightAll.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Record[] records = myList1.getRecords();
                myList1.setData(new Record[]{});
                for (Record record : records) {
                    myList2.addData(record);
                }
            }
        });

        TransferImgButton left = new TransferImgButton(TransferImgButton.LEFT);
        left.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                myList1.transferSelectedData(myList2);
            }
        });

        TransferImgButton leftAll = new TransferImgButton(TransferImgButton.LEFT_ALL);
        leftAll.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Record[] records = myList2.getRecords();
                myList2.setData(new Record[]{});
                for (Record record : records) {
                    myList1.addData(record);
                }
            }
        });
        transferStack.addMember(right);
        transferStack.addMember(left);
        transferStack.addMember(rightAll);
        transferStack.addMember(leftAll);

        hStack.addMember(transferStack);
        hStack.addMember(myList2);

        VStack modifyStack = new VStack(3);
        modifyStack.setWidth(20);
        modifyStack.setAlign(VerticalAlignment.CENTER);

        TransferImgButton up = new TransferImgButton(TransferImgButton.UP);
        up.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord selectedRecord = myList2.getSelectedRecord();
                if(selectedRecord != null) {
                    int idx = myList2.getRecordIndex(selectedRecord);
                    if(idx > 0) {
                        RecordList rs = myList2.getRecordList();
                        rs.removeAt(idx);
                        rs.addAt(selectedRecord, idx - 1);
                    }
                }
            }
        });

        TransferImgButton upFirst = new TransferImgButton(TransferImgButton.UP_FIRST);
        upFirst.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord selectedRecord = myList2.getSelectedRecord();
                if(selectedRecord != null) {
                    int idx = myList2.getRecordIndex(selectedRecord);
                    if(idx > 0) {
                        RecordList rs = myList2.getRecordList();
                        rs.removeAt(idx);
                        rs.addAt(selectedRecord, 0);
                    }
                }
            }
        });

        TransferImgButton down = new TransferImgButton(TransferImgButton.DOWN);
        down.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord selectedRecord = myList2.getSelectedRecord();
                if(selectedRecord != null) {
                    RecordList rs = myList2.getRecordList();
                    int numRecords = rs.getLength();
                    int idx = myList2.getRecordIndex(selectedRecord);
                    if(idx < numRecords - 1) {
                        rs.removeAt(idx);
                        rs.addAt(selectedRecord, idx + 1);
                    }
                }
            }
        });

        TransferImgButton downLast = new TransferImgButton(TransferImgButton.DOWN_LAST);
        downLast.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord selectedRecord = myList2.getSelectedRecord();
                if(selectedRecord != null) {
                    RecordList rs = myList2.getRecordList();
                    int numRecords = rs.getLength();
                    int idx = myList2.getRecordIndex(selectedRecord);
                    if(idx < numRecords - 1) {
                        rs.removeAt(idx);
                        rs.addAt(selectedRecord, rs.getLength());
                    }
                }
            }
        });

        TransferImgButton delete = new TransferImgButton(TransferImgButton.DELETE);
        delete.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord selectedRecord = myList2.getSelectedRecord();
                if(selectedRecord != null) {
                    myList2.removeData(selectedRecord);
                }
            }
        });

        modifyStack.addMember(upFirst);
        modifyStack.addMember(up);
        modifyStack.addMember(down);
        modifyStack.addMember(downLast);
        modifyStack.addMember(delete);

        hStack.addMember(modifyStack);

        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}