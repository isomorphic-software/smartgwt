package com.smartgwt.sample.showcase.client.grid;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FilterCriteriaFunction;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.EditorValueMapFunction;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeData;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GridDependentSelectsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>In the first example, <b>Double Click</b> on any row to start editing. Select a value in the \"Division\" column to change the " +
            "set of options available in the \"Department\" column.</p>" +
            "<p>In the second example, click the <b>Order New Item</b> button to add an editable row to the grid. Select a Category in the second column to change the set of " +
            "options available in the \"Item\" column.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDependentSelectsSample panel = new GridDependentSelectsSample();
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
        VLayout layout = new VLayout(15);
        Label localDataLabel = new Label("Local Data");
        localDataLabel.setWidth("90%");
        localDataLabel.setHeight(25);
        localDataLabel.setBaseStyle("exampleSeparator");
        layout.addMember(localDataLabel);


        final ListGrid localDataGrid = new ListGrid();
        localDataGrid.setWidth(500);
        localDataGrid.setHeight(200);
        localDataGrid.setCanEdit(true);
        localDataGrid.setData(EmployeeData.getRecords());

        ListGridField employeeField = new ListGridField("employee", "Name");
        employeeField.setCanEdit(false);

        ListGridField divisionField = new ListGridField("division", "Division");
        SelectItem divisionSelectItem = new SelectItem();
        divisionSelectItem.setValueMap("Marketing", "Sales", "Services");
        divisionSelectItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                //calling 'setValueMap()' will force the 'getEditorValueMap' method to be re-evaluated for the department field
                localDataGrid.setValueMap("department", new LinkedHashMap());
            }
        });
        divisionField.setEditorType(divisionSelectItem);

        ListGridField departmentField = new ListGridField("department", "Department");

        final Map<String, String[]> departments = new HashMap<String, String[]>();
        departments.put("Marketing", new String[]{"Advertising", "Community Relations"});
        departments.put("Sales", new String[]{"Channed Sales", "Direct Sales"});
        departments.put("Manufacturing", new String[]{"Design", "Development", "QA"});
        departments.put("Services", new String[]{"Support", "Consulting"});

        SelectItem departmentSelectItem = new SelectItem();
        departmentSelectItem.setAddUnknownValues(false);
        departmentField.setEditorValueMapFunction(new EditorValueMapFunction() {
            public Map getEditorValueMap(Map values, ListGridField field, ListGrid grid) {
                String division = (String) values.get("division");
                String[] divisions = departments.get(division);

                //convert divisions into ValueMap. In this case we simply create a Map with same key -> value since
                //stored value is the same as user displayable value
                Map<String, String> valueMap = new HashMap<String, String>();
                for (int i = 0; i < divisions.length; i++) {
                    String val = divisions[i];
                    valueMap.put(val, val);
                }
                return valueMap;
            }
        });
        departmentField.setEditorType(departmentSelectItem);

        localDataGrid.setFields(employeeField, divisionField, departmentField);

        layout.addMember(localDataGrid);

        //remote dependent selects sample
        Label remoteDataLabel = new Label("Remote Data");
        remoteDataLabel.setWidth("90%");
        remoteDataLabel.setHeight(25);
        remoteDataLabel.setBaseStyle("exampleSeparator");
        layout.addMember(remoteDataLabel);

        final ListGrid remoteDataGrid = new ListGrid();
        remoteDataGrid.setWidth(500);
        remoteDataGrid.setHeight(200);
        remoteDataGrid.setCanEdit(true);

        ListGridField quantityField = new ListGridField("quantity", "Qty");
        quantityField.setType(ListGridFieldType.INTEGER);
        quantityField.setWidth(30);

        ListGridField categoryField = new ListGridField("categoryName", "Category");

        DataSource supplyCategoryDS = SupplyCategoryXmlDS.getInstance();
        DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();

        SelectItem categorySelectItem = new SelectItem();
        categorySelectItem.setOptionDataSource(supplyCategoryDS);

        categoryField.setEditorType(categorySelectItem);

        categoryField.addChangedHandler(new com.smartgwt.client.widgets.grid.events.ChangedHandler() {
            public void onChanged(com.smartgwt.client.widgets.grid.events.ChangedEvent event) {
                remoteDataGrid.clearEditValue(event.getRowNum(), "itemName");
            }
        });

        ListGridField itemField = new ListGridField("itemName", "Item");
        SelectItem itemEditor = new SelectItem();
        itemEditor.setPickListFilterCriteriaFunction(new FilterCriteriaFunction() {
            public Criteria getCriteria() {
                String category = (String) remoteDataGrid.getEditedCell(remoteDataGrid.getEditRow(), "categoryName");
                return new Criteria("category", category);
            }
        });


        itemEditor.setOptionDataSource(supplyItemDS);
        itemField.setEditorType(itemEditor);

        remoteDataGrid.setFields(quantityField, categoryField, itemField);

        layout.addMember(remoteDataGrid);

        IButton newOrderButton = new IButton("Order New Item");
        newOrderButton.setWidth(110);
        newOrderButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Map defaultValues = new HashMap();
                defaultValues.put("quantity", 1);
                remoteDataGrid.startEditingNew(defaultValues);
            }
        });

        layout.addMember(newOrderButton);
        
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}