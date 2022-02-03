package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.TransferImgButton.TransferImg;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class TouchDragSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "On touch devices such as IPhone or Microsoft Surface, drag handles can be shown on " +
        "the records of a ListGrid so that native scrolling and record dragging are both " +
        "possible.<P>" +
        "Grab rows by the drag handle icon to move them between the two lists - all selected " +
        "rows will be moved.  Or scroll the lists up or down by grabbing some other field.<P>" +
        "You can dynamically show and hide drag handles to save space, if they are " +
        "infrequently used.  Click the button below the grids to toggle drag handle " +
        "visibility, and note how if drag handles are hidden, native touch scrolling is no " +
        "longer possible after a selection is made without triggering a drag.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            TouchDragSample panel = new TouchDragSample();
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

    private boolean hidden = false;
    
    public Canvas getViewPanel() {
        final DragHandlesGrid countryList1 = new DragHandlesGrid();
        countryList1.setWidth(325);
        countryList1.setHeight(224);
        countryList1.setAlternateRecordStyles(true);
        countryList1.setData(CountrySampleData.getRecords());
		
        ListGridField countryCodeField1 = new ListGridField("countryCode", "Flag", 40);  
        countryCodeField1.setAlign(Alignment.CENTER);  
        countryCodeField1.setType(ListGridFieldType.IMAGE);  
        countryCodeField1.setImageURLPrefix("flags/16/");  
        countryCodeField1.setImageURLSuffix(".png");  
  
        ListGridField nameField1 = new ListGridField("countryName", "Country");  
        ListGridField capitalField1 = new ListGridField("capital", "Capital");  
        countryList1.setFields(countryCodeField1, nameField1, capitalField1);  
           
        final DragHandlesGrid countryList2 = new DragHandlesGrid();
        countryList2.setWidth(225);
        countryList2.setHeight(224);
        countryList2.setAlternateRecordStyles(true);
		
        ListGridField countryCodeField2 = new ListGridField("countryCode", "Flag", 40);  
        countryCodeField2.setAlign(Alignment.CENTER);  
        countryCodeField2.setType(ListGridFieldType.IMAGE);  
        countryCodeField2.setImageURLPrefix("flags/16/");  
        countryCodeField2.setImageURLSuffix(".png");  
  
        ListGridField nameField2 = new ListGridField("countryName", "Country"); 
        countryList2.setFields(countryCodeField2, nameField2);
        countryList2.setEmptyMessage("drop rows here");
        
        VStack vStackButtons = new VStack(10);  
        vStackButtons.setWidth(32);  
        vStackButtons.setHeight(74);  
        vStackButtons.setLayoutAlign(Alignment.CENTER);  
  
        TransferImgButton rightImg = new TransferImgButton(new TransferImg("icons/32/arrow_right.png"));  
        rightImg.setHeight(32);
        rightImg.setWidth(32);
        rightImg.addClickHandler(new ClickHandler() {  
            @Override
            public void onClick(ClickEvent event) {
                countryList2.transferSelectedData(countryList1);  
            }  
        });  
        vStackButtons.addMember(rightImg);  
  
        TransferImgButton leftImg = new TransferImgButton(new TransferImg("icons/32/arrow_left.png"));  
        leftImg.setHeight(32);
        leftImg.setWidth(32);
        leftImg.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                countryList1.transferSelectedData(countryList2);  
            }  
        });  
        vStackButtons.addMember(leftImg);
		
        HStack hStack = new HStack();
        hStack.setMembersMargin(10);
        hStack.setHeight(160);
        hStack.addMember(countryList1);
        hStack.addMember(vStackButtons);
        hStack.addMember(countryList2);
		
        final IButton button = new IButton();
        button.setAutoFit(true);
        button.setTitle("Hide Drag Handles");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (hidden)	{
                    countryList1.showDragHandles();
                    countryList2.showDragHandles();
                    button.setTitle("Hide Drag Handles");
                } else {
                    countryList1.hideDragHandles();
                    countryList2.hideDragHandles();
                    button.setTitle("Show Drag Handles");
                }
                hidden = !hidden;
            }
        });
        
        VStack vStack = new VStack();
        vStack.setLayoutLeftMargin(20);
        vStack.setMembersMargin(20);
        vStack.addMember(hStack);
        vStack.addMember(button);
        
        return vStack;
    }

    private class DragHandlesGrid extends ListGrid {
        public DragHandlesGrid() {
            setCanReorderRecords(true);
            setCanDragRecordsOut(true);
            setCanAcceptDroppedRecords(true);
            setShowInitialDragHandles(true);  
            setDragDataAction(DragDataAction.MOVE);
        }
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }

}
