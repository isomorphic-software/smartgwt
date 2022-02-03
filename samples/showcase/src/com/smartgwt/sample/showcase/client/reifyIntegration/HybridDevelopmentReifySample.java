package com.smartgwt.sample.showcase.client.reifyIntegration;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.callbacks.LoadProjectCallback;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.rpc.LoadProjectSettings;
import com.smartgwt.client.rpc.Project;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.tools.Reify;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.types.TitleRotationMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawSector;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.NavItem;
import com.smartgwt.client.widgets.layout.NavPanel;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.events.ItemClickEvent;
import com.smartgwt.client.widgets.menu.events.ItemClickHandler;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS; 
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class HybridDevelopmentReifySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on items in the grid on the left to load screens in "+
    "the space on the right. Some of these screens "+
    "are hand-coded, some are sample Reify projects, and some of the hand-coded screens use Reify projects for "+
    "just parts of their UI."+
    "<p>"+
    "\"Screen Reuse\" is hand-coded screen, with the same source code as the same-named "+
    "sample in this folder. <br>"+
    "\"Shape Gallery\" is a hand-coded screen, with the same source code as the Drawing > Shape Gallery sample."+
    "<p>"+
    "The rest of the entries just load the same-named Reify sample projects."+
    "<p>"+
    "<i>Hybrid development</i> lets you mix together Reify-created screens and hand-coded screens at any "+
    "granularity, even nesting hand-coded and Reify-created screens.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            HybridDevelopmentReifySample panel = new HybridDevelopmentReifySample();
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
        NavItem[] navItems = new NavItem[6];
    	navItems[0] = new NavItem();
    	navItems[0].setTitle("Test Loader");
    	navItems[0].setPane(loadReifyProject("Test Loader"));
    	
    	navItems[1] = new NavItem();
    	navItems[1].setTitle("Simple Form");
    	navItems[1].setPane(loadReifyProject("Simple Form"));
    	
    	navItems[2] = new NavItem();
    	navItems[2].setTitle("Simple Grid");
    	navItems[2].setPane(loadReifyProject("Simple Grid"));
    	
    	navItems[3] = new NavItem();
    	navItems[3].setTitle("Supply Catalog");
    	navItems[3].setPane(loadReifyProject("Supply Catalog"));
    	
    	navItems[4] = new NavItem();
    	navItems[4].setTitle("Shape Gallery");
    	navItems[4].setPane(getShapeGalleryCode());
    	
    	navItems[5] = new NavItem();
    	navItems[5].setTitle("Screen Reuse");
    	navItems[5].setPane(getScreenReuseCode());
    	
    	NavPanel navPanel = new NavPanel();
    	navPanel.setWidth100();
    	navPanel.setHeight100();
    	navPanel.setNavItems(navItems);
    	
    	return navPanel;
    }

    private LoadProjectSettings getProjectSettings() {
		LoadProjectSettings settings = new LoadProjectSettings();
        settings.setUserName("reifySample");
        settings.setPassword("tryReify");
        settings.setServerURL("https://create.reify.com");
        return settings;
	}
	
	/* Reify Projects */
	private Canvas loadReifyProject(String projectName) {
		final Canvas container = new Canvas();
		container.setWidth100();
		container.setHeight100();
        
        Reify.loadProject(projectName, new LoadProjectCallback() {
            @Override
            public void execute(Project project, Project[] projects, RPCResponse rpcResponse) {
                Canvas screen = project.createScreen((project.getScreenNames()[0]));
				container.addChild(screen);
            }
        }, getProjectSettings());
        
        return container;
	}

	/* Shape Gallery sample*/
	private DrawPane mainPane;  
	  
    private void applyCommonProps(DrawItem item) {  
        item.setDrawPane(mainPane);  
        item.setCanDrag(true);  
        item.setTitleRotationMode(TitleRotationMode.NEVER_ROTATE);  
    }
    
	private Layout getShapeGalleryCode() {
		mainPane = new DrawPane();  
        mainPane.setWidth(720);  
        mainPane.setHeight(475);  
        mainPane.setShowEdges(true);  
        mainPane.addDrawHandler(new DrawHandler() {  
            @Override  
            public void onDraw(DrawEvent event) {  
                final DrawTriangle drawTriangle = new DrawTriangle();  
                drawTriangle.setPoints(new Point(100, 50), new Point(150, 150), new Point(50, 150));  
                drawTriangle.setTitle("Triangle");  
                applyCommonProps(drawTriangle);  
                drawTriangle.draw();  
  
                final DrawCurve drawCurve = new DrawCurve();  
                drawCurve.setStartPoint(new Point(200, 50));  
                drawCurve.setEndPoint(new Point(300, 150));  
                drawCurve.setControlPoint1(new Point(250, 0));  
                drawCurve.setControlPoint2(new Point(250, 200));  
                drawCurve.setLineCap(LineCap.ROUND);  
                drawCurve.setTitle("Curve");  
                applyCommonProps(drawCurve);  
                drawCurve.draw();  
  
                final DrawLinePath drawLinePath = new DrawLinePath();  
                drawLinePath.setStartPoint(new Point(350, 50));  
                drawLinePath.setEndPoint(new Point(450, 150));  
                drawLinePath.setTitle("LinePath");  
                applyCommonProps(drawLinePath);  
                drawLinePath.draw();  
  
                final DrawPath drawPath = new DrawPath();  
                drawPath.setPoints(  
                        new Point(500, 50),  
                        new Point(525, 50),  
                        new Point(550, 75),  
                        new Point(575, 75),  
                        new Point(600, 75),  
                        new Point(600, 125),  
                        new Point(575, 125),  
                        new Point(550, 125),  
                        new Point(525, 150),  
                        new Point(500, 150)  
                );  
                drawPath.setTitle("Path");  
                applyCommonProps(drawPath);  
                drawPath.draw();  
  
                final DrawOval drawOval = new DrawOval();  
                drawOval.setLeft(50);  
                drawOval.setTop(300);  
                drawOval.setWidth(100);  
                drawOval.setHeight(100);  
                drawOval.setTitle("Oval");  
                applyCommonProps(drawOval);  
                drawOval.draw();  
  
                final DrawRect drawRect = new DrawRect();  
                drawRect.setLeft(200);  
                drawRect.setTop(300);  
                drawRect.setWidth(150);  
                drawRect.setHeight(100);  
                drawRect.setTitle("Rectangle");  
                applyCommonProps(drawRect);  
                drawRect.draw();  
  
                final DrawLine drawLine = new DrawLine();  
                drawLine.setStartPoint(new Point(400, 300));  
                drawLine.setEndPoint(new Point(500, 400));  
                drawLine.setTitle("Line");  
                applyCommonProps(drawLine);  
                drawLine.draw();  
  
                final DrawSector drawSector = new DrawSector();  
                drawSector.setDrawPane(mainPane);  
                drawSector.setCenterPoint(new Point(550, 300));  
                drawSector.setStartAngle(0.0);  
                drawSector.setEndAngle(90.0);  
                drawSector.setRadius(100);  
                drawSector.setTitle("Sector");  
                applyCommonProps(drawSector);  
                drawSector.draw();  
            }  
        });  
  
        final Layout layout = new HStack();  
        layout.setWidth100();  
        layout.setMembers(mainPane);
        
        return layout;
	}
	
	/* Screen Reuse sample */
    private ListGrid supplyGrid;
    private TabSet tabSet;
	private VLayout getScreenReuseCode() {
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
		        Reify.loadProject("Simple Form", new LoadProjectCallback() {
		            @Override
		            public void execute(Project project, Project[] projects, RPCResponse rpcResponse) {
		                Canvas screen = project.createScreen((project.getScreenNames()[0]));
		                DynamicForm saveForm = (DynamicForm)screen.getByLocalId("simpleForm");
		                Record record = supplyGrid.getSelectedRecord();
		                saveForm.editRecord(record);
		                
		                Tab tab = new Tab();
		                tab.setName(record.getAttribute("itemID"));
		                tab.setTitle(record.getAttribute("itemName"));
		                tab.setCanClose(true);
		                
		                tabSet.addTab(tab);
		                tab.setPane(screen);
                        tabSet.selectTab(tab);
		            }
		        }, getProjectSettings());

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

        return mainLayout;
	}
	    
    public String getIntro() {
        return DESCRIPTION;
    }

}
