package com.smartgwt.sample.showcase.client.grid;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TopOperatorAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.FilterBuilder;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;
import com.smartgwt.sample.showcase.client.data.EmployeeData;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

public class GridDependentSelectsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p><b>Double Click</b> on any row to start editing. Select a value in the \"Division\" column to change the " +
            "set of options available in the \"Department\" column.</p>";            

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
            public String[] getEditorValueMap(Map values, ListGridField field, ListGrid grid) {
                String division = (String) values.get("division");
                return departments.get(division);
            }
        });
        departmentField.setEditorType(departmentSelectItem);

        localDataGrid.setFields(employeeField, divisionField, departmentField);

        return localDataGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}