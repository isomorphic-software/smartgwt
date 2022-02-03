package com.smartgwt.sample.showcase.client.grid.cellWidgets;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.EmbeddedPosition;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.RecordComponentPoolingMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class ReplacingRowsSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Record components can completely replace the normal content of ListGrid rows."+  
            "This is an <i><b>extremely</b></i> powerful feature that allows you to use a grid "+ 
            "to contain any kind of repeating widget, for any size of data."+
            "<p>"+
            "Here, each row is rendered by a DynamicForm, in order to achieve a data layout "+ 
            "that doesn't fit into columns. The ListGrid's usual header is hidden."+
            "<p>"+
            "Because the DynamicForms are being pooled, this approach scales to very large data sets."+
            "<p>"+
            "To demonstrate that the generated components can be dynamic according to the data,"+ 
            "and yet still be pooled:"+
            "<ul>"+
                "<li> the Reorder icon is only enabled if the item is inStock"+
                "<li> the Bulk Order icon is only visible if the item comes in units of \"Roll\", \"Ream\" or \"Tube\""+
            "</ul>"+
            "The form also allows editing, and uses the grid to track unsaved values"+ 
            "(try editing a cost, scrolling that row off screen, then back on - the value is preserved)."+
            "<p>"+
            "Also try removing records, and note that there is an animated removal. </p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ReplacingRowsSample panel = new ReplacingRowsSample();
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
                
        final DataSource supplyItem = ItemSupplyXmlDS.getInstance();
                
        final ListGrid itemList = new ListGrid() {
            @Override    
            protected Canvas createRecordComponent(ListGridRecord record, Integer colNum) {
                final ListGrid grid = this; 
                final ListGridRecord rec = record;
                final DynamicForm form = new DynamicForm();
                form.setDataSource(supplyItem);
                form.setShowPending(true);
                form.setCanEdit(false);
                form.setNumCols(4);
                form.setColWidths(100, "*", 100, "*");
                form.setWidth("100%");
                form.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        grid.selectSingleRecord(rec);
                    }
                });
                
                TextItem itemName = new TextItem();
                itemName.setName("itemName");
                itemName.setTitle("Item Name");
                 
                FloatItem unitCost = new FloatItem();
                unitCost.setName("unitCost");
                unitCost.setTitle("Unit Cost");
                unitCost.setCanEdit(true);
                unitCost.addChangedHandler(new ChangedHandler() {
                    @Override
                    public void onChanged(ChangedEvent event) {
                        ListGridRecord selectedRecord = grid.getSelectedRecord();
                        if (selectedRecord != null) {
                            Map<String, Float> values = new HashMap<String, Float>();
                            values.put("unitCost", Float.parseFloat(event.getValue().toString()));
                            grid.setEditValues(grid.getRowNum(selectedRecord), values);
                        }
                    }
                });
                FormItemIcon saveIcon = new FormItemIcon();
                saveIcon.setPrompt("Save");
                saveIcon.setSrc("[SKIN]/actions/save.png");
                saveIcon.addFormItemClickHandler(new FormItemClickHandler() {
                    @Override
                    public void onFormItemClick(FormItemIconClickEvent event) {
                        if (grid.getSelectedRecord() != null) form.saveData();
                    }
                });
                 
                FormItemIcon reorderIcon = new FormItemIcon();
                reorderIcon.setPrompt("Reorder");
                reorderIcon.setWidth(18);
                reorderIcon.setHeight(22);
                AdvancedCriteria reorderIconCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                        new Criterion("inStock", OperatorId.EQUALS, true)
                    }); 
                reorderIcon.setEnableWhen(reorderIconCriteria);
                reorderIcon.setSrc("[SKIN]/pickers/refresh_picker.png");
                                 
                FormItemIcon removeIcon = new FormItemIcon();
                removeIcon.setPrompt("Remove");
                removeIcon.setSrc("[SKIN]/pickers/clear_picker.png");
                removeIcon.setWidth(18);
                removeIcon.setHeight(22);
                removeIcon.addFormItemClickHandler(new FormItemClickHandler() {
                    @Override
                    public void onFormItemClick(FormItemIconClickEvent event) {
                        if (grid.getSelectedRecord() != null) grid.removeData(grid.getSelectedRecord());
                    }
                });
                 
                FormItemIcon bulkOrderIcon = new FormItemIcon();
                bulkOrderIcon.setPrompt("Bulk Order");
                bulkOrderIcon.setWidth(22);
                bulkOrderIcon.setHeight(22);
                AdvancedCriteria bulkOrderIconCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                        new Criterion("units", OperatorId.IN_SET, new String[] {"Roll", "Ream", "Tube"})
                    }); 
                bulkOrderIcon.setVisibleWhen(bulkOrderIconCriteria);
                bulkOrderIcon.setSrc("[SKIN]/actions/plus.png");
                 
                unitCost.setIcons(saveIcon, reorderIcon, removeIcon, bulkOrderIcon);
                 
                TextItem desc = new TextItem();
                desc.setName("description");
                desc.setTitle("Description");
                desc.setWidth("*");
                desc.setColSpan("*");
                desc.setHeight(60);
                 
                form.setFields(itemName, unitCost, desc);
                form.setValues(rec.toMap());
                
                return form;
            }
            
            @Override
            public Canvas updateRecordComponent(ListGridRecord record, Integer colNum, Canvas component, boolean recordChanged) {
                final ListGrid grid = this; 
                DynamicForm form = (DynamicForm)component;
                form.setValues(record.toMap());				
                Map editValues = grid.getEditValues(record);
                if (editValues.get("unitCost") != null) {
                    form.setValue("unitCost", Float.parseFloat(editValues.get("unitCost").toString()));
                }
                form.markForRedraw();
                
                return form;
            }
        };
        itemList.setWidth(800);
        itemList.setHeight(420);
        itemList.setShowHeader(false); 
        itemList.setAlternateRecordStyles(true);
        itemList.setRecordComponentPosition(EmbeddedPosition.WITHIN);
        itemList.setRecordComponentPoolingMode(RecordComponentPoolingMode.RECYCLE);
        itemList.setShowRecordComponents(true);
        itemList.setAutoSaveEdits(false);
        itemList.setDataSource(supplyItem);
        itemList.setAutoFetchData(true);
        itemList.setRecordComponentHeight(100);
        ListGridField itemNameField = new ListGridField();
        itemNameField.setName("itemName");
        itemNameField.setCellFormatter(new CellFormatter() {
            @Override
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                return "";
            }
        });
        itemList.setFields(itemNameField);
        
        final SearchForm searchForm = new SearchForm();
        searchForm.setWidth(400);
        searchForm.setNumCols(4);
        
        TextItem search = new TextItem();
        search.setTitle("Item Name");
        search.setName("search");
        search.setShowHintInField(true);
        search.setHint("Search");
        search.setWrapTitle(false);
        search.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getKeyName().equals("Enter")) {
                    AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                            new Criterion("itemName", OperatorId.ICONTAINS, (String)event.getFiringItem().getValue())
                        }); 
                    itemList.filterData(criteria);
                }
            }
        });
        ButtonItem searchButton = new ButtonItem();
        searchButton.setTitle("Search");
        searchButton.setStartRow(false);
        searchButton.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            @Override
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                        new Criterion("itemName", OperatorId.ICONTAINS, (String)searchForm.getField("search").getValue())
                    }); 
                itemList.filterData(criteria);
            }
        });
        searchForm.setFields(search, searchButton);
        
        vLayout.addMember(searchForm);
        vLayout.addMember(itemList);
        vLayout.draw();

        return vLayout;
    }

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
