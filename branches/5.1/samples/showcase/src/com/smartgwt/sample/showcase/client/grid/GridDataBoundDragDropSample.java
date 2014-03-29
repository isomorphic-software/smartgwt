package com.smartgwt.sample.showcase.client.grid;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;
import com.smartgwt.sample.showcase.client.data.TeamMembersXmlDS;

public class GridDataBoundDragDropSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Drag employee records into the Project Team Members list. Smart GWT recognizes that the two dataSources are linked by a " +
            "foreign key relationship, and automatically uses that relationship to populate values in the record that is added when you drop. " +
            "Smart GWT also populates fields based on current criteria and maps explicit titleFields as necessary.</p>" +
            "<p>In this example, note that Smart GWT is automatically populating all three of the fields in the teamMembers dataSource, even though none of " +
            "those fields is present in the employees dataSource we are dragging from. Change the \"Team for Project\" " +
            "select box, then try dragging employees across; note that the Project Code column is being correctly populated for the dropped records.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBoundDragDropSample panel = new GridDataBoundDragDropSample();
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

    @Override
    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {

        String[] projects = new String[] {
                "New Costing System", "Warehousing Improvements", "Evaluate AJAX Frameworks", "Upgrade Postgres", "Online Billing"
        };

        DataSource employeesDS = EmployeeXmlDS.getInstance();

        final ListGrid employeesGrid = new ListGrid();
        employeesGrid.setWidth(300);
        employeesGrid.setHeight(224);
        employeesGrid.setDataSource(employeesDS);
        employeesGrid.setCanDragRecordsOut(true);
        employeesGrid.setDragDataAction(DragDataAction.COPY);
        employeesGrid.setAutoFetchData(false);

        ListGridField employeeIdField = new ListGridField("EmployeeId");
        employeeIdField.setWidth("25%");

        ListGridField nameField = new ListGridField("Name");

        employeesGrid.setFields(employeeIdField, nameField);


        DataSource teamMembersDS = TeamMembersXmlDS.getInstance();

        final ListGrid projectGrid = new ListGrid();
        projectGrid.setWidth(300);
        projectGrid.setHeight(264);
        projectGrid.setDataSource(teamMembersDS);
        projectGrid.setCanAcceptDroppedRecords(true);
        projectGrid.setCanRemoveRecords(true);
        projectGrid.setAutoFetchData(false);
        projectGrid.setPreventDuplicates(true);

        ListGridField employeeIdField2 = new ListGridField("employeeId");
        employeeIdField2.setWidth("20%");

        ListGridField employeeNameField2 = new ListGridField("employeeName");
        employeeNameField2.setWidth("40%");
        ListGridField projectCodeField2 = new ListGridField("projectCode");

        projectGrid.setFields(employeeIdField2, employeeNameField2, projectCodeField2);

        HStack hStack = new HStack(10);
        hStack.setHeight(160);

        VStack vStack = new VStack();
        LayoutSpacer spacer = new LayoutSpacer();
        spacer.setHeight(30);
        vStack.addMember(spacer);
        vStack.addMember(employeesGrid);

        hStack.addMember(vStack);

        TransferImgButton arrowImg = new TransferImgButton(TransferImgButton.RIGHT);
        arrowImg.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                projectGrid.transferSelectedData(employeesGrid);
            }
        });
        hStack.addMember(arrowImg);

        VStack vStack2 = new VStack();

        final DynamicForm projectSelectorForm = new DynamicForm();
        projectSelectorForm.setWidth(300);
        projectSelectorForm.setHeight(30);

        SelectItem selectItem = new SelectItem("projectCode", "Team for Project");
        selectItem.setDefaultValue(projects[0]);
        selectItem.setValueMap(projects);
        selectItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                Criteria criteria = projectSelectorForm.getValuesAsCriteria();
                projectGrid.fetchData(criteria);
            }
        });
        projectSelectorForm.setFields(selectItem);

        vStack2.addMember(projectSelectorForm);
        vStack2.addMember(projectGrid);

        hStack.addMember(vStack2);

        projectGrid.fetchData(projectSelectorForm.getValuesAsCriteria());
        employeesGrid.fetchData();
        
        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}