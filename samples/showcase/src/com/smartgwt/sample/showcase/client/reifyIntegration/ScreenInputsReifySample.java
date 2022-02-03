package com.smartgwt.sample.showcase.client.reifyIntegration;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.callbacks.LoadProjectCallback;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.rpc.CreateScreenSettings;
import com.smartgwt.client.rpc.LoadProjectSettings;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.tools.Reify;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.DataContext;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.data.CM_CustomerXmlDS;
import com.smartgwt.sample.showcase.client.data.CM_OrderXmlDS;
import com.smartgwt.sample.showcase.client.data.CM_OrderDetailXmlDS;
import com.smartgwt.sample.showcase.client.data.CM_ProductXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ScreenInputsReifySample extends ShowcasePanel {
	private static final String DESCRIPTION = "Screen Inputs give Reify screens a way to "+
	"receive context from the surrounding application where they are integrated."+
	"<p>"+
	"Below, the grid of orders is hand-coded. Each time you click on an order, a new tab is "+
	"created for editing that order. The tab is create in code, but the contents of each tab "+
	"is a Reify sample project called \"Screen Inputs\"."+
	"<p>"+
	"The currently selected order is passed to the Reify screen via <code>dataContext</code>.  "+
	"Auto-population of components within the screen results in the selected Order being edited "+
	"in a form, and related OrderDetails being shown in a grid, which are fetched dynamically "+
	"from the OrderDetail DataSource, already present in the page.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ScreenInputsReifySample panel = new ScreenInputsReifySample();
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

        DataSource cmCustomerDS = CM_CustomerXmlDS.getInstance();
        cmCustomerDS.fetchData(null);
        DataSource cmOrderDetailDS = CM_OrderDetailXmlDS.getInstance();
        cmOrderDetailDS.fetchData(null);
        DataSource cmProductDS = CM_ProductXmlDS.getInstance();
        cmProductDS.fetchData(null);
        DataSource cmOrderDS = CM_OrderXmlDS.getInstance();
    	
        final TabSet tabSet = new TabSet();  
        tabSet.setWidth(900);  
        tabSet.setHeight(450);  
           
        final ListGrid orderGrid = new ListGrid();  
        orderGrid.setAutoFetchData(true);  
        orderGrid.setDisabled(true);
        orderGrid.setDataSource(cmOrderDS); 
        orderGrid.setSelectionType(SelectionStyle.SINGLE);
         
        ListGridField customerNumber = new ListGridField("customerNumber");
        customerNumber.setWidth("*");
        ListGridField orderNumber = new ListGridField("orderNumber");
        orderNumber.setType(ListGridFieldType.INTEGER);
        orderNumber.setWidth(150);
        ListGridField orderDate = new ListGridField("orderDate");
        orderDate.setType(ListGridFieldType.DATE);
        orderDate.setWidth(150);
        ListGridField status = new ListGridField("status");
        status.setWidth(100);
         
        orderGrid.setFields(customerNumber, orderNumber, orderDate, status);
        orderGrid.addRecordClickHandler(new RecordClickHandler() {

			@Override
			public void onRecordClick(RecordClickEvent event) {
                final ListGridRecord record = event.getRecord();
                CreateScreenSettings settings = new CreateScreenSettings();
                DataContext dataContext = new DataContext();  
                dataContext.setDataSourceRecord("CM_Order", record); 
                settings.setDataContext(dataContext);
                settings.setSuppressAutoDraw(true);
				Canvas screen = project.createScreen((project.getScreenNames()[0]), settings);
                          
                Tab tab = new Tab();  
                tab.setName(record.getAttribute("orderNumber"));  
                tab.setTitle("Order: "+record.getAttribute("orderNumber")+" by "+record.getAttribute("customerName"));  
                tab.setCanClose(true);  
                tab.setPane(screen);  

                tabSet.addTab(tab);  
                tabSet.selectTab(tab);  
			}
        	 
        });
           
        Tab ordersTab = new Tab();  
        ordersTab.setCanClose(false);  
        ordersTab.setTitle("Orders");  
        ordersTab.setPane(orderGrid);  
   
		tabSet.addTab(ordersTab);  
           
        VLayout mainLayout = new VLayout();  
        mainLayout.setWidth100();  
        mainLayout.setHeight100();  
        mainLayout.addMember(tabSet);  
   
        LoadProjectSettings settings = new LoadProjectSettings();  
        settings.setUserName("reifySample");  
        settings.setPassword("tryReify");  
        settings.setServerURL("https://create.reify.com");  
                  
        Reify.loadProject("Screen Inputs", new LoadProjectCallback() {  
            @Override  
            public void execute(Project loadedProject, Project[] projects, RPCResponse rpcResponse) {
                project = loadedProject;
                orderGrid.enable();
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
