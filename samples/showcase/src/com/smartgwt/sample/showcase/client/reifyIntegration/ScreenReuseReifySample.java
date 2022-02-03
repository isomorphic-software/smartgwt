package com.smartgwt.sample.showcase.client.reifyIntegration;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.callbacks.LoadProjectCallback;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.rpc.CreateScreenSettings;
import com.smartgwt.client.rpc.LoadProjectSettings;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.tools.Reify;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS; 
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ScreenReuseReifySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Reify screens are encapsulated and reusable: you can "+
        "create more than one instance of the same screen, even concurrently."+
        "<p>"+
        "Select a supplyItem in the grid on the left and press the \"Edit\" button. Each time you do this, "+
        "another copy of the \"Simple Form\" sample screen is created and populated with data from the grid."+
        "<p>"+
        "You can think of Reify screens as essentially similar to SmartClient components - you can create "+
        "multiple instances of the same screen, and even add different custom event handlers to each instance."+
        "<p>"+
        "Since screens are also encapsulated you don't need to worry about naive designers doing something "+
        "that breaks the whole application."+
        "<p>"+
        "This extremely powerful feature makes it possible to use Reify to design screens in even the most "+
        "dynamic applications";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ScreenReuseReifySample panel = new ScreenReuseReifySample();
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

    private ListGrid supplyGrid;
	private TabSet tabSet;
	private Project project;
    
    public Canvas getViewPanel() {
        final DataSource supplyCategoryDS = SupplyCategoryXmlDS.getInstance("supplyCategory");  
        final DataSource supplyItemDS = ItemSupplyXmlDS.getInstance("supplyItem", "supplyCategory"); 
        DataSource.get("supplyItem");
        DataSource.get("supplyCategory");

        final VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMembersMargin(5);
		vLayout.setDefaultLayoutAlign(Alignment.RIGHT);
		
		tabSet = new TabSet();
		tabSet.setWidth(900);
		tabSet.setHeight(450);
		
		supplyGrid = new ListGrid();
		supplyGrid.setDisabled(true);
		supplyGrid.setAutoFetchData(true);
		supplyGrid.setShowFilterEditor(true);
		supplyGrid.setDataSource(supplyItemDS);
		supplyGrid.addDataArrivedHandler(new DataArrivedHandler() {
			@Override
			public void onDataArrived(DataArrivedEvent event) {
				supplyGrid.selectRecord(0);
			}
		});
		
		IButton button = new IButton();
		button.setTitle("Edit");
		button.setWidth(100);
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CreateScreenSettings settings = new CreateScreenSettings();
				settings.setSuppressAutoDraw(true);

				Canvas screen = project.createScreen((project.getScreenNames()[0]), settings);
				DynamicForm saveForm = (DynamicForm)screen.getByLocalId("simpleForm");
				Record record = supplyGrid.getSelectedRecord();
				saveForm.editRecord(record);
				
				Tab tab = new Tab();
				tab.setName(record.getAttribute("itemID"));
				tab.setTitle(record.getAttribute("itemName"));
				tab.setCanClose(true);
				tab.setPane(screen);
				
				tabSet.addTab(tab);				
				tabSet.selectTab(tab);
			}
		});
		
		vLayout.addMember(supplyGrid);
		vLayout.addMember(button);
		
		Tab supplyTab = new Tab();
		supplyTab.setCanClose(false);
		supplyTab.setTitle("Supply Items");
		supplyTab.setPane(vLayout);

		tabSet.addTab(supplyTab);
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.addMember(tabSet);

		LoadProjectSettings settings = new LoadProjectSettings();  
        settings.setUserName("reifySample");  
        settings.setPassword("tryReify");  
        settings.setServerURL("https://create.reify.com");  
                  
        Reify.loadProject("Simple Form", new LoadProjectCallback() {  
            @Override  
            public void execute(Project loadedProject, Project[] projects, RPCResponse rpcResponse) {
                project = loadedProject;
                supplyGrid.enable();
            }  
		}, settings); 
		
        return mainLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override  
    protected boolean isTopIntro() {  
        return true;  
    }

}
