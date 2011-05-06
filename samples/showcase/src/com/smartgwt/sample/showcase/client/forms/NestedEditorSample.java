package com.smartgwt.sample.showcase.client.forms;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.JSONEncoder;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.StringUtil;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.events.FormItemInitHandler;
import com.smartgwt.client.widgets.form.fields.events.ShowValueEvent;
import com.smartgwt.client.widgets.form.fields.events.ShowValueHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class NestedEditorSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>This example shows a reusable CanvasItem that edits nested data structures.</p>" +
        "<p>Here, a record representing an Order contains multiple OrderItem records &mdash; " +
        "in the Record for an Order the \"items\" field value is set to an Array of Records " +
        "representing OrderItems.</p>" +
        "<p>The CanvasItem embeds an editable ListGrid to provide an editing interaction " +
        "for the OrderItems right in the midst of the form. It can be used with any " +
        "DataSource that has nested records.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public Canvas create() {
            NestedEditorSample panel = new NestedEditorSample();
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
    
    protected boolean isTopIntro() {
        return true;
    }
    
    public class GridEditorItem extends CanvasItem {
        GridEditorItem (String name) {
            super(name);
            
            setWidth("*");
            setHeight("*");
            setColSpan("*");
            setEndRow(true);
            setStartRow(true);
            
            // this is going to be an editable data item
            setShouldSaveValue(true);
            
            setInitHandler(new FormItemInitHandler() {
                @Override
                public void onInit(FormItem item) {
                    ListGrid grid = new ListGrid();

                    // dataSource and fields to use, provided to a listGridItem as
                    // listGridItem.gridDataSource and optional gridFields
                    grid.setDataSource(getGridDataSource());
                    if (gridFields != null) grid.setFields(getGridFields());
                    if (gridSortField != null) grid.setSortField(getGridSortField());
                    grid.setSortDirection(SortDirection.ASCENDING);
                    
                    // The form item's data is set to a list of records
                    RecordList value = (RecordList) item.getValue();
                    if (value != null) grid.setData(value);
                    
                    grid.setCanEdit(true);
                    grid.setSaveLocally(true);
                    
                    grid.addCellSavedHandler(new CellSavedHandler() {
                        @Override
                        public void onCellSaved(CellSavedEvent event) {
                            ListGrid grid = (ListGrid) event.getSource();
                            GridEditorItem item = (GridEditorItem) grid.getCanvasItem();
                            RecordList data = grid.getDataAsRecordList();
                            item.storeValue(data);
                            
                            if (item.getGridSortField() == null) return;
                            grid.sort(item.getGridSortField(), SortDirection.ASCENDING);
                        }
                    });
                    
                    setCanvas(grid);
                    
                    addShowValueHandler(new ShowValueHandler() {
                        @Override
                        public void onShowValue(ShowValueEvent event) {
                            ListGrid grid = (ListGrid)((CanvasItem)event.getSource()).getCanvas();
                            RecordList records = event.getDataValueAsRecordList();
                            if (records != null && grid != null) grid.setData(records);
                        }
                    });
                }
            });
        }
        
        private DataSource gridDataSource;
        public DataSource getGridDataSource() {
            return this.gridDataSource;
        }
        
        public void setGridDataSource(DataSource gridDataSource) {
            this.gridDataSource = gridDataSource;
        }
        
        private ListGridField[] gridFields;
        public ListGridField[] getGridFields() {
            return gridFields;
        }
        
        public void setGridFields(ListGridField... gridFields) {
            this.gridFields = gridFields;
        }
        
        private String gridSortField;
        public String getGridSortField() {
            return gridSortField;
        }
        
        public void setGridSortField(String gridSortField) {
            this.gridSortField = gridSortField;
        }
    };
    
    public Canvas getViewPanel() {
        // Define a couple of simple nested dataSources. Make these client-only for simplicity
        DataSource orderItemDS = getOrderItemDS();
        DataSource orderDS = getOrderDS();
        
        DynamicForm exampleForm = new DynamicForm();
        exampleForm.setID("exampleForm");
        exampleForm.setWidth(350);
        exampleForm.setHeight(350);
        exampleForm.setDataSource(orderDS);
        
        StaticTextItem orderID = new StaticTextItem("orderID");
        DateItem orderDate = new DateItem("orderDate");
        
        GridEditorItem items = new GridEditorItem("items");
        items.setShowTitle(false);
        items.setGridDataSource(orderItemDS);
        
        ListGridField itemDescription = new ListGridField("itemDescription");
        ListGridField unitPrice = new ListGridField("unitPrice");
        
        items.setGridFields(itemDescription, unitPrice);
        
        items.setGridSortField("itemDescription");
        
        ButtonItem saveBtn = new ButtonItem("Save");
        saveBtn.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            @Override
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                event.getForm().saveData(new DSCallback() {
                    @Override
                    public void execute(DSResponse response, Object rawData, DSRequest request) {
                        Record rec = response.getData()[0];
                        JavaScriptObject rawItems = rec.getAttributeAsJavaScriptObject("items");
                        String html = StringUtil.asHTML(new JSONEncoder().encode(rawItems));
                        SC.say("Record saved with items:" + html);
                    }
                });
            }
        });
        
        exampleForm.setItems(orderID, orderDate, items, saveBtn);
        
        Criteria orderCriteria = new Criteria();
        orderCriteria.addCriteria("orderID", 1);
        orderDS.fetchData(orderCriteria, new DSCallback() {
            @Override
            public void execute(DSResponse response, Object rawData, DSRequest request) {
                DynamicForm exampleForm = (DynamicForm) Canvas.getById("exampleForm");
                exampleForm.editRecord(response.getData()[0]);
            }
        });
        
        return exampleForm;
    }
    
    private DataSource orderItemDS;
    private DataSource getOrderItemDS () {
        if (orderItemDS != null) return orderItemDS;
        orderItemDS = new DataSource();
        orderItemDS.setClientOnly(true);
        DataSourceField pkField = new DataSourceField("pk", FieldType.SEQUENCE);
        pkField.setPrimaryKey(true);
        
        DataSourceField orderID = new DataSourceField("orderID", FieldType.INTEGER);
        orderID.setCanEdit(false);
        
        DataSourceField itemDescription = new DataSourceField("itemDescription", FieldType.TEXT);
        DataSourceField unitPrice = new DataSourceField("unitPrice", FieldType.FLOAT);
        
        orderItemDS.setFields(pkField, orderID, itemDescription, unitPrice);
        
        // No need to populate with test data - this is a schema only - the data is 
        // nested directly in each order record.
        
        return orderItemDS;
    }
    
    private RecordList orderItemData;
    private RecordList getOrderItemData(int orderID) {
        if (orderItemData == null) {
            orderItemData  = new RecordList();
            
            orderItemData.addList(new ListGridRecord[] {
                new ListGridRecord () {{
                    setAttribute("pk", 0);
                    setAttribute("orderID", 0);
                    setAttribute("itemDescription", "Yellow Widget");
                    setAttribute("unitPrice", 23.01);
                }},
                new ListGridRecord () {{
                    setAttribute("pk", 1);
                    setAttribute("orderID", 0);
                    setAttribute("itemDescription", "Green Widget");
                    setAttribute("unitPrice", 28.99);
                }},
                new ListGridRecord () {{
                    setAttribute("pk", 2);
                    setAttribute("orderID", 1);
                    setAttribute("itemDescription", "Red Widget");
                    setAttribute("unitPrice", 100);
                }},
                new ListGridRecord () {{
                    setAttribute("pk", 3);
                    setAttribute("orderID", 1);
                    setAttribute("itemDescription", "Orange Widget");
                    setAttribute("unitPrice", 48.22);
                }},
                new ListGridRecord () {{
                    setAttribute("pk", 4);
                    setAttribute("orderID", 2);
                    setAttribute("itemDescription", "Yellow Widget");
                    setAttribute("unitPrice", 23.01);
                }}
            });
        }
        return new RecordList(orderItemData.findAll("orderID", orderID));
    }
    
    private DataSource orderDS;
    private DataSource getOrderDS () {
        if (orderDS != null) return orderDS;
        orderDS = new DataSource();
        orderDS.setClientOnly(true);
        
        DataSourceField orderID = new DataSourceField("orderID", FieldType.SEQUENCE);
        orderID.setPrimaryKey(true);
        
        DataSourceField customerName = new DataSourceField("customerName", FieldType.TEXT);
        
        DataSourceField orderDate = new DataSourceField("orderDate", FieldType.DATE);
        
        DataSourceField items = new DataSourceField();
        items.setName("items");
        items.setTypeAsDataSource(getOrderItemDS());
        items.setMultiple(true);
        
        orderDS.setFields(orderID, customerName, orderDate, items);
        
        orderDS.setTestData(getOrderData());
        
        return orderDS;
        
    }
    
    private ListGridRecord[] getOrderData () {
        ListGridRecord[] orderData = new ListGridRecord[] {
            new ListGridRecord() {{
                setAttribute("orderID", 0);
                setAttribute("customerName", "Richard Jones");
                setAttribute("orderDate", DateUtil.parseInput("11/01/2011"));
                setAttribute("items", getOrderItemData(0));
            }},
            new ListGridRecord() {{
                setAttribute("orderID", 1);
                setAttribute("customerName", "Sarah Holden");
                setAttribute("orderDate", DateUtil.parseInput("02/04/2011"));
                setAttribute("items", getOrderItemData(1));
            }},
            new ListGridRecord() {{
                setAttribute("orderID", 2);
                setAttribute("customerName", "James Edwards");
                setAttribute("orderDate", DateUtil.parseInput("04/29/2011"));
                setAttribute("items", getOrderItemData(2));
            }}
        };
        return orderData;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }
}