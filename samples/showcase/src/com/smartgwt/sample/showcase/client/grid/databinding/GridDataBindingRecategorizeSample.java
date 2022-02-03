package com.smartgwt.sample.showcase.client.grid.databinding;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridDataBindingRecategorizeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The two lists are showing items in different categories. "+
        "Drag items from one list to another to automatically recategorize the items without writing any code. "+
        "Make changes, then reload the page. The changes persist.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDataBindingRecategorizeSample panel = new GridDataBindingRecategorizeSample();
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
        final ItemsListGrid list1 = new ItemsListGrid();
        list1.setCanDragRecordsOut(true);
        list1.setCanAcceptDroppedRecords(true);
        list1.setCanReorderRecords(true);
        
        final ItemsListGrid list2 = new ItemsListGrid();
        list2.setCanDragRecordsOut(true);
        list2.setCanAcceptDroppedRecords(true);
        list2.setCanReorderRecords(true);
    	
        Img rightImg = new Img();
        rightImg.setSrc("icons/32/arrow_right.png");
        rightImg.setWidth(32);
        rightImg.setHeight(32);
        rightImg.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                list2.transferSelectedData(list1);
            }
        });
    	
        Img leftImg = new Img();
        leftImg.setSrc("icons/32/arrow_left.png");
        leftImg.setWidth(32);
        leftImg.setHeight(32);
        leftImg.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                list1.transferSelectedData(list2);
            }
        });
    	
        VStack vStack = new VStack();
        vStack.setWidth(32);
        vStack.setHeight(74);
        vStack.setLayoutAlign(Alignment.CENTER);
        vStack.setMembersMargin(10);
        vStack.addMember(rightImg);
        vStack.addMember(leftImg);
    	
        HLayout hLayout = new HLayout();
        hLayout.setHeight(224);
        hLayout.setWidth(800);
        hLayout.addMember(list1);
        hLayout.addMember(vStack);
        hLayout.addMember(list2);

        Criteria criteria1 = new Criteria();
        criteria1.addCriteria("category", "Dictionaries");
        Criteria criteria2 = new Criteria();
        criteria2.addCriteria("category", "Accessories");

        list1.fetchData(criteria1);
        list2.fetchData(criteria2);

        return hLayout;
    }

    private static class ItemsListGrid extends ListGrid {
    	
    	public ItemsListGrid() {
    	    setAlternateRecordStyles(true);
    		setLeaveScrollbarGap(false);
    		setDataSource(ItemSupplyXmlDS.getInstance());
    		setDragDataAction(DragDataAction.MOVE);
            setAutoFetchData(false);
    		ListGridField itemName = new ListGridField("itemName");
    		ListGridField sku = new ListGridField("SKU");
    		ListGridField category = new ListGridField("category");
    		setDefaultFields(itemName, sku, category);
    	}
    }

    public String getIntro() {
        return DESCRIPTION;
    }


}