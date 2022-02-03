package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class SelectCellTextDragSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click and drag to select cell content, ready "+
        "to be copied and pasted into the TextArea. Drag selection of grid content is enabled "+
        "via the \"canDragSelectText\" property of ListGrid.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SelectCellTextDragSample panel = new SelectCellTextDragSample();
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
    
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.setWidth100();
        vLayout.setHeight100();
		
        ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight100();
        listGrid.setAlternateRecordStyles(true);
        listGrid.setSelectionType(SelectionStyle.NONE);
        listGrid.setShowRollOver(false);
        listGrid.setCanDragSelectText(true);
        
        ListGridField countryName = new ListGridField("countryName", "Country");
        countryName.setWidth(120);
        ListGridField background = new ListGridField("background", "Background");
        ListGridField countryCode = new ListGridField("countryCode", "Flag");
        countryCode.setAlign(Alignment.CENTER);
        countryCode.setWidth(50);
        countryCode.setType(ListGridFieldType.IMAGE);
        countryCode.setImageSize(24);
        countryCode.setImageURLPrefix("flags/24/");
        countryCode.setImageURLSuffix(".png");
		
        listGrid.setFields(countryName,background,countryCode);
        listGrid.setWrapCells(true);
        listGrid.setFixedRecordHeights(false);
        listGrid.setData(CountrySampleData.getNewRecords());
		
        DynamicForm form = new DynamicForm();
        form.setWidth100();
        form.setHeight(150);
		
        TextAreaItem textAreaItem = new TextAreaItem("textAreaItem");
        textAreaItem.setTitle("Pasted value");
        textAreaItem.setWidth("100%");
        textAreaItem.setHeight("100%");
		
        form.setFields(textAreaItem);
		
        vLayout.addMember(listGrid);
        vLayout.addMember(form);
		
        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
