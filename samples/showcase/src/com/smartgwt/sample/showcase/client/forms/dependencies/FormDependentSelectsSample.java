package com.smartgwt.sample.showcase.client.forms.dependencies;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormDependentSelectsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Select a \"Division\" to cause the \"Department\" select to be populated with departments from that division.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormDependentSelectsSample panel = new FormDependentSelectsSample();
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

        final DynamicForm form = new DynamicForm();
        form.setWidth(500);
        form.setNumCols(4);

        final Map<String, String[]> departments = new HashMap<String, String[]>();
        departments.put("Marketing", new String[]{"Advertising", "Community Relations"});
        departments.put("Sales", new String[]{"Channel Sales", "Direct Sales"});
        departments.put("Manufacturing", new String[]{"Design", "Development", "QA"});
        departments.put("Services", new String[]{"Support", "Consulting"});

        SelectItem divisionItem = new SelectItem();
        divisionItem.setName("division");
        divisionItem.setTitle("Division");
        divisionItem.setValueMap("Marketing", "Sales", "Manufacturing", "Services");
        divisionItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                String selectedItem = (String) event.getValue();
                form.getField("department").setValueMap(departments.get(selectedItem));
            }
        });

        SelectItem departmentItem = new SelectItem();
        departmentItem.setName("department");
        departmentItem.setTitle("Department");
        departmentItem.setAddUnknownValues(false);

        form.setItems(divisionItem, departmentItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}