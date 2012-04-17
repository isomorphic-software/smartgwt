package com.smartgwt.sample.showcase.client.tree;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class TreeEditingSample extends ShowcasePanel {
    
	private static final String DESCRIPTION = "" +
            "<p>First choose an employee via the menu to see that employee's direct reports in the ListGrid.</p>" +
            "<p>Click on employees in the tree to edit them, and drag and drop employees to rearrange them. " +
            "<p>Changing an employee's salary in the grid will be automatically reflected in the tree.</p>" +
            "<p>Dragging an employee to another manager in the tree will make that employee appear or disappear " +
            "in the grid if the grid is showing the original or new manager's employees.</p>" +
            "<p>Changes made in the tree or ListGrid are automatically saved to the server and reflected in the other components.</p>";

	public static class Factory implements PanelFactory {
		private String id;

		public Canvas create() {
			TreeEditingSample panel = new TreeEditingSample();
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
		TreeGridField fieldName = new TreeGridField("Name", 150);
		TreeGridField fieldJob = new TreeGridField("Job", 150);
		TreeGridField fieldSalary = new TreeGridField("Salary");

		TreeGrid employeeTree = new TreeGrid();
        employeeTree.setID("employeeTree");
		employeeTree.setWidth(500);
		employeeTree.setHeight(250);
		employeeTree.setDataSource(EmployeeXmlDS.getInstance());
		employeeTree.setNodeIcon("icons/16/person.png");
		employeeTree.setFolderIcon("icons/16/person.png");
		employeeTree.setAutoFetchData(true);
		employeeTree.setLoadDataOnDemand(false);
		employeeTree.setCanEdit(true);
		employeeTree.setCanReorderRecords(true);
		employeeTree.setCanAcceptDroppedRecords(true);
		employeeTree.setShowDropIcons(false);
		employeeTree.setShowOpenIcons(false);
		employeeTree.setClosedIconSuffix("");
		employeeTree.setFields(fieldName, fieldJob, fieldSalary);
		
		final ListGrid employeeGrid = new ListGrid();
        employeeGrid.setID("employeeGrid");
		employeeGrid.setWidth(500);
		employeeGrid.setHeight(250);
        employeeGrid.setEmptyMessage("Select an Employee from the PickTree Item above.");
		employeeGrid.setDataSource(EmployeeXmlDS.getInstance());
		employeeGrid.setCanEdit(true);
		employeeGrid.setFields(new TreeGridField("Name", 150), new TreeGridField("Job", 150), new TreeGridField("Salary"));

		IPickTreeItem searchPickTree = new IPickTreeItem();
		searchPickTree.setCanSelectParentItems(true);
		searchPickTree.setShowTitle(false);
		searchPickTree.setDataSource(EmployeeXmlDS.getInstance());
		searchPickTree.setDisplayField("Name");
		searchPickTree.setValueField("EmployeeId");
		searchPickTree.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				Criteria c = new Criteria();
				c.addCriteria("ReportsTo", (Integer)event.getValue());
				employeeGrid.fetchData(c);
			}
		});

		SearchForm searchForm = new SearchForm();
        searchForm.setID("employeeSearchForm");
		searchForm.setWidth(200);
		searchForm.setHeight(30);
		searchForm.setFields(searchPickTree);
				
        VLayout mainView = new VLayout(10);
        mainView.setHeight100();
        mainView.setWidth100();

		mainView.addMember(searchForm);
		mainView.addMember(employeeGrid);
        mainView.addMember(employeeTree);
	
		return mainView;
	}

	public String getIntro() {
		return DESCRIPTION;
	}
}