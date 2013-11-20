package com.smartgwt.sample.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.Version;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.AutoTest;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.events.VisibilityChangedEvent;
import com.smartgwt.client.widgets.events.VisibilityChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemIfFunction;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;
import com.smartgwt.sample.showcase.client.data.CommandTreeNode;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;

import java.util.LinkedHashMap;

@SuppressWarnings("deprecation")
public class Showcase implements EntryPoint, HistoryListener {
	
SCConstants scConstants = (SCConstants)GWT.create(SCConstants.class);
private boolean isc_websiteMode = scConstants.websiteMode();

    private TabSet mainTabSet;
    private SideNavTree sideNav;
    private Menu contextMenu;
	private HLayout topPane;
	private HLayout leftSuperPane;
	private Canvas centerPane;
	private VStack rightPane;
	private HStack bottomPane;
	private HLayout bottomPaneLeft;
	private HLayout bottomPaneRight;

    public void onModuleLoad() {
        final String initToken = History.getToken();
        // If the request contains param "websiteMode", override the configured value
        String isc_websiteModeParam = com.google.gwt.user.client.Window.Location.getParameter("isc_websiteMode");
        if(isc_websiteModeParam!=null) {
        	isc_websiteMode = Boolean.parseBoolean(isc_websiteModeParam);
        }

        //setup overall layout / viewport
        VLayout main = new VLayout() {
            {
                setID("isc_Showcase_1_0");
            }

            @Override
            protected void onInit() {
                super.onInit();
                if (initToken.length() != 0) {
                    onHistoryChanged(initToken);
                }
            }
        };

        ToolStrip topBar = new ToolStrip();
        topBar.setHeight(33);
        topBar.setWidth100();

        topBar.addSpacer(6);
        ImgButton sgwtHomeButton = new ImgButton();
        sgwtHomeButton.setSrc("pieces/24/cube_green.png");
        sgwtHomeButton.setWidth(24);
        sgwtHomeButton.setHeight(24);
        sgwtHomeButton.setPrompt("Smart GWT Project Page");
        sgwtHomeButton.setHoverStyle("interactImageHover");
        sgwtHomeButton.setShowRollOver(false);
        sgwtHomeButton.setShowDownIcon(false);
        sgwtHomeButton.setShowDown(false);
        sgwtHomeButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                com.google.gwt.user.client.Window.open("http://code.google.com/p/smartgwt/",
                                                       "sgwt", null);
            }
        });
        topBar.addMember(sgwtHomeButton);
        topBar.addSpacer(6);

        Label title = new Label("Smart GWT Showcase");
        title.setStyleName("sgwtTitle");
        title.setWidth(300);
        topBar.addMember(title);

        topBar.addFill();

        ToolStripButton devConsoleButton = new ToolStripButton();
        devConsoleButton.setTitle("Developer Console");
        devConsoleButton.setIcon("silk/bug.png");
        devConsoleButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.showConsole();
            }
        });

        topBar.addButton(devConsoleButton);

        topBar.addSeparator();

        ImgButton imgButton = new ImgButton();
        imgButton.setWidth(18);
        imgButton.setHeight(18);
        imgButton.setSrc("silk/emoticon.png");
        imgButton.setShowFocused(false);
        imgButton.setShowFocusedIcon(false);
        imgButton.setPrompt("I'm feeling lucky");
        imgButton.setHoverWidth(110);
        imgButton.setHoverStyle("interactImageHover");

        imgButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            public void onClick(ClickEvent event) {
                ExplorerTreeNode[] data = sideNav.getShowcaseData();
                int size = data.length;
                for (int i = 0; i < 15; i++) {
                    int sampleIndex = (int) (size * java.lang.Math.random());
                    ExplorerTreeNode sample = data[sampleIndex];
                    if (sample.getFactory() != null && !(sample instanceof CommandTreeNode)) {
                        showSample(sample);
                        break;
                    }
                }
            }
        });

        topBar.addMember(imgButton);

        topBar.addSpacer(6);

        main.setWidth100();
        main.setHeight100();
        main.setStyleName("tabSetContainer");

        VLayout featureExplorer = new VLayout();
        featureExplorer.setLayoutMargin(5);
        featureExplorer.setWidth100();
        featureExplorer.setHeight100();
        
        topPane = new HLayout();
        topPane.setHeight100();
        topPane.setOverflow(Overflow.HIDDEN);
        
        leftSuperPane = new HLayout();
        leftSuperPane.setResizeBarTarget("next");
        leftSuperPane.setOverflow(Overflow.HIDDEN);
        
        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(215);
        sideNavLayout.setShowResizeBar(true);

        sideNav = new SideNavTree();
        sideNav.setID("isc_SideNavTree_0");
        sideNav.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showSample(node);
            }
        });

        // open example tree completely for automated test framework
        if (ShowcaseConfiguration.getSingleton().isOpenForTesting()) {
            sideNav.getData().openAll();
        }

        sideNavLayout.addMember(sideNav);
        
        ToolStrip toolStripVersion = new ToolStrip();
        toolStripVersion.setWidth100();
        Label version = new Label("Version: "+Version.getVersion()+"<br>Built "+Version.getBuildDate());
        version.setWidth100();
        version.setPadding(5);
        toolStripVersion.addMember(version);
        sideNavLayout.addMember(toolStripVersion);
        
        mainTabSet = new TabSet();

        Layout paneContainerProperties = new Layout();
        paneContainerProperties.setLayoutMargin(0);
        paneContainerProperties.setLayoutTopMargin(1);
        mainTabSet.setPaneContainerProperties(paneContainerProperties);

        mainTabSet.setWidth100();
        mainTabSet.setHeight100();
        mainTabSet.addTabSelectedHandler(new TabSelectedHandler() {
            public void onTabSelected(TabSelectedEvent event) {
                Tab selectedTab = event.getTab();

                Canvas pane = selectedTab.getPane();
                if (pane instanceof ShowcasePanel) {
                    ShowcasePanel panel =(ShowcasePanel)pane;
                    Canvas viewPanel = panel.viewPanel;
                    AutoTest.setTestRoot(panel.shouldWrapViewPanel() ? 
                                         viewPanel.getParentElement() : viewPanel);
                }

                String historyToken = selectedTab.getAttribute("historyToken");
                if (historyToken != null) {
                    History.newItem(historyToken, false);
                } else {
                    History.newItem("main", false);
                }
            }
        });

        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setWidth(5);

        SelectItem selectItem = new SelectItem();
        selectItem.setHeight(21);
        selectItem.setWidth(130);
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("EnterpriseBlue", "Enterprise Blue");
        valueMap.put("Enterprise", "Enterprise Gray");
        valueMap.put("Graphite", "Graphite");
        valueMap.put("Simplicity", "Simplicity");


        selectItem.setValueMap(valueMap);

        final String skinCookieName = "skin_name_2_4";
        String currentSkin = Cookies.getCookie(skinCookieName);
        if (currentSkin == null) {
            currentSkin = "Enterprise";
        }
        selectItem.setDefaultValue(currentSkin);
        selectItem.setShowTitle(false);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie(skinCookieName, (String) event.getValue());
                com.google.gwt.user.client.Window.Location.reload();
            }
        });

        DynamicForm form = new DynamicForm();
        form.setPadding(0);
        form.setMargin(0);
        form.setCellPadding(1);
        form.setNumCols(1);
        form.setFields(selectItem);

        mainTabSet.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, layoutSpacer, form);

        contextMenu = createContextMenu();

        Tab tab = new Tab();
        tab.setTitle("Home&nbsp;&nbsp;");
        tab.setIcon("pieces/16/cube_green.png", 16);
        tab.setWidth(80);

        HLayout mainPanel = new HLayout();
        mainPanel.setHeight100();
        mainPanel.setWidth100();

        TileView tileView = new TileView(mainPanel);
        mainPanel.addMember(tileView);

        tab.setPane(mainPanel);

        mainTabSet.addTab(tab);

        centerPane = new Canvas();
        centerPane.setBackgroundImage("[SKIN]/shared/background.gif");
        centerPane.setWidth100();
        centerPane.setHeight100();
        centerPane.addChild(mainTabSet);

        // Build and add the rightPane, with callToAction buttons
        rightPane = new VStack();
        rightPane.setDefaultLayoutAlign(Alignment.CENTER);
        rightPane.setOverflow(Overflow.HIDDEN);
        rightPane.setWidth(234);
        rightPane.hide();
                
        // Add bottomPane
        bottomPaneLeft = new HLayout();
        bottomPaneLeft.setWidth("50%");
        bottomPaneLeft.setHeight(30);
        bottomPaneLeft.setAlign(Alignment.LEFT);
        bottomPaneLeft.setLayoutLeftMargin(10);
        bottomPaneLeft.setMembersMargin(10);
        
        bottomPaneRight = new HLayout();
        bottomPaneRight.setWidth("50%");
        bottomPaneRight.setHeight(30);
        bottomPaneRight.setAlign(Alignment.RIGHT);
        bottomPaneRight.setLayoutLeftMargin(10);

        bottomPane = new HStack();
        bottomPane.addMember(bottomPaneLeft);
        bottomPane.addMember(bottomPaneRight);
        bottomPane.setOverflow(Overflow.HIDDEN);
        bottomPane.setHeight(30);
        bottomPane.setWidth100();
        bottomPane.setStyleName("explorerBottomPane");
        bottomPane.hide();
        
        // Right Pane buttons
        // SmartGWT Call to action button in right panel
        Layout smartGwtButtonBoxR = new Layout();
        smartGwtButtonBoxR.setStyleName("explorerButtonBoxR");
        smartGwtButtonBoxR.setWidth(200);
        rightPane.addMember(smartGwtButtonBoxR);
        
        Label smartGwtButtonR = new Label("<div style='font-size: 9pt;''>Prefer to write UI in Javascript?</div>" +
					"<img src='images/icon_javascript_t.png'" +
						"style='height: 30pt; float: left; margin-right: 2pt; " +
					"margin-left: 2pt; margin-top: 10pt;'/>" +
					"<a target='_top' style='line-height: 12pt; padding-top: 5pt;' "+
					"href='" + "http://www.smartclient.com/#Welcome" + "' " +
					">" + "Smart Client<br/>Hands-On Demo" + "</a>");
        smartGwtButtonR.setStyleName("darkgrey_Ebutton ERbutton");
        smartGwtButtonR.setWidth(200);
        smartGwtButtonR.setHeight(1);
        smartGwtButtonR.setAlign(Alignment.CENTER);
        smartGwtButtonR.setValign(VerticalAlignment.CENTER);
        smartGwtButtonBoxR.addMember(smartGwtButtonR);
        
        // Contact Us Call to action button in right panel
        Layout contactUsButtonBoxR = new Layout();
        contactUsButtonBoxR.setStyleName("explorerButtonBoxR explorerButtonBoxGradient");
        contactUsButtonBoxR.setWidth(200);
        rightPane.addMember(contactUsButtonBoxR);
        
        Label contactUsButtonR = new Label("<div>Got questions?" +
        		  "<div style='font-size: 8pt;'>We'd love to hear from you!</div>" +
        		  "</div>" +
					"<a target='_top' href='" + "/company/contact.jsp" + "' " +
					">" + "Contact Us" + "</a>");
        contactUsButtonR.setStyleName("darkgrey_Ebutton ERbutton");
        contactUsButtonR.setWidth(200);
        contactUsButtonR.setHeight(1);
        contactUsButtonR.setAlign(Alignment.CENTER);
        contactUsButtonR.setValign(VerticalAlignment.CENTER);
        contactUsButtonBoxR.addMember(contactUsButtonR);

        // Free Trial Call to action button in right panel
        Layout freeTrialButtonBoxR = new Layout();
        freeTrialButtonBoxR.setStyleName("explorerButtonBoxR explorerButtonBoxGradient");
        freeTrialButtonBoxR.setWidth(200);
        rightPane.addMember(freeTrialButtonBoxR);
        
        Label freeTrialButtonR = new Label("<div>Try it out for yourself!</div>" +
        			"<a target='_top' style='line-height: 12pt; padding-top: 5pt;' " +
        			"href='" + "/product/download.jsp" + "' " +
        			">" + "Free Trial<br/><span style='font-size: 8pt;'>60 days</span>" + "</a>");
        freeTrialButtonR.setStyleName("blue_Ebutton ERbutton");
        freeTrialButtonR.setWidth(200);
        freeTrialButtonR.setHeight(1);
        freeTrialButtonR.setAlign(Alignment.CENTER);
        freeTrialButtonR.setValign(VerticalAlignment.CENTER);
        freeTrialButtonBoxR.addMember(freeTrialButtonR);

        // Pricing Call to action button in right panel
        Layout pricingTrialButtonBoxR = new Layout();
        pricingTrialButtonBoxR.setStyleName("explorerButtonBoxR explorerButtonBoxGradient");
        pricingTrialButtonBoxR.setWidth(200);
        rightPane.addMember(pricingTrialButtonBoxR);
        
        Label pricingTrialButtonR = new Label("<div>Want your own?</div>" +
				"<a target='_top' href='" + "/product/" + "' " +
				">" + "Editions & Pricing" + "</a>");
        pricingTrialButtonR.setStyleName("orange_Ebutton ERbutton");
        pricingTrialButtonR.setWidth(200);
        pricingTrialButtonR.setHeight(1);
        pricingTrialButtonR.setAlign(Alignment.CENTER);
        pricingTrialButtonR.setValign(VerticalAlignment.CENTER);
        pricingTrialButtonBoxR.addMember(pricingTrialButtonR);

        // Learn More Call to action button in right panel
        Layout learnMoreButtonBoxR = new Layout();
        learnMoreButtonBoxR.setStyleName("explorerButtonBoxR explorerButtonBoxGradient");
        learnMoreButtonBoxR.setWidth(200);
        rightPane.addMember(learnMoreButtonBoxR);
        
        Label learnMoreButtonR = new Label("<div>Isomorphic has the advantage.</div>" +
				"<a target='_top' href='" + "technology/whysmart.jsp" + "' " +
				">" + "Learn More >" + "</a>");
        learnMoreButtonR.setStyleName("darkgrey_Ebutton ERbutton");
        learnMoreButtonR.setWidth(200);
        learnMoreButtonR.setHeight(1);
        learnMoreButtonR.setAlign(Alignment.CENTER);
        learnMoreButtonR.setValign(VerticalAlignment.CENTER);
        learnMoreButtonBoxR.addMember(learnMoreButtonR);

        // Bottom Pane buttons
        // Free Trial Call to action button in bottom panel
        Label freeTrialButtonB = new Label("<a target='_top' href='/product/download.jsp' " +
    			">Free Trial</a>");
        freeTrialButtonB.setStyleName("blue_Ebutton EBbutton");
        bottomPaneLeft.addMember(freeTrialButtonB);
        
        // Pricing Call to action button in bottom panel
        Label pricingButtonB = new Label("<a target='_top' href='/product/' " +
			">Editions & Pricing</a>");
        pricingButtonB.setStyleName("orange_Ebutton EBbutton");
        bottomPaneLeft.addMember(pricingButtonB);

        // SmartGWT Call to action button in bottom panel
        Label smartGWTButtonPreB = new Label("<span>Prefer to write UI in Java?</span>");
        smartGWTButtonPreB.setStyleName("EBbutton");
        smartGWTButtonPreB.setWidth("180pt");
        bottomPaneRight.addMember(smartGWTButtonPreB);
        Label smartGWTButtonB = new Label("<a target='_top' style='width: 130pt;' " +
			"href='http://www.smartclient.com/smartgwtee/showcase'" +
			" >Smart GWT Live Demo</a>");
        smartGWTButtonB.setStyleName("darkgrey_Ebutton EBbutton");
        bottomPaneRight.addMember(smartGWTButtonB);

        leftSuperPane.addMember(sideNavLayout);
        leftSuperPane.addMember(centerPane);
        topPane.addMember(leftSuperPane);
        topPane.addMember(rightPane);
        featureExplorer.addMember(topPane);
        featureExplorer.addMember(bottomPane);

        main.addMember(topBar);
        main.addMember(featureExplorer);
        
        if (SC.hasFirebug()) {
            Label label = new Label();
            label.setWidth100();
            label.setHeight(50);
            label.setValign(VerticalAlignment.CENTER);
            label.setAlign(Alignment.CENTER);
            label.setContents("Firebug can make the Showcase run slow. For the best performance, we suggest disabling Firebug for this site.");

            Window fbWindow = new Window();
            fbWindow.setTitle("Firebug Detected");
            fbWindow.setWidth100();
            fbWindow.setHeight(80);
            fbWindow.addItem(label);
            fbWindow.setRedrawOnResize(true);
            main.addMember(fbWindow);
        }
        
        main.addDrawHandler(new DrawHandler() {
			@Override
			public void onDraw(DrawEvent event) {
				pageRedrawn();
			}
		});
                
        main.addResizedHandler(new ResizedHandler() {
			@Override
			public void onResized(ResizedEvent event) {
				pageResized();
			}
		});
        
        rightPane.addVisibilityChangedHandler(new VisibilityChangedHandler() {
			@Override
			public void onVisibilityChanged(VisibilityChangedEvent event) {
				rightPaneVisibilityChanged(event.getIsVisible());
			}
		});

        main.draw();
        
        // Add history listener
        History.addHistoryListener(this);

        RootPanel p = RootPanel.get("loadingWrapper");
        if (p != null) RootPanel.getBodyElement().removeChild(p.getElement());        
    }
    
	private void pageRedrawn() {
    	if(isc_websiteMode ==true) {
			leftSuperPane.setShowResizeBar(true);
			// If browser width > 900px, show right, else show bottom
			if(Page.getWidth()>900) {
				rightPane.show();
				bottomPane.hide();
			} else {
				bottomPane.show();
				rightPane.hide();
			}
		}
	}

    private void rightPaneVisibilityChanged(boolean isVisible) {
    	if(isc_websiteMode ==true) {
    		if(Page.getWidth()<=900) {
    			rightPane.hide();
    			bottomPane.show();
    			return;
    		}
    		if(isVisible) {
    			centerPane.setHeight100();
    			bottomPane.hide();
    			rightPane.show();
    		} else {
    			centerPane.setHeight(leftSuperPane.getHeight()-bottomPane.getHeight());
    			bottomPane.show();
    			rightPane.hide();
    		}
    	}
    }
    
    private void pageResized() {
    	if(isc_websiteMode ==true) {
    		if(leftSuperPane!=null && Page.getWidth()<=900) {
    			if(leftSuperPane.getShowResizeBar()) {
    				rightPane.hide();
    				bottomPane.show();
    			} else {
    				rightPane.show();
    				bottomPane.hide();    				
    			}
    		}
    	}
    }
       
    private Menu createContextMenu() {
        Menu menu = new Menu();
        menu.setWidth(140);

        MenuItemIfFunction enableCondition = new MenuItemIfFunction() {
            public boolean execute(Canvas target, Menu menu, MenuItem item) {
                int selectedTab = mainTabSet.getSelectedTabNumber();
                return selectedTab != 0;
            }
        };

        MenuItem closeItem = new MenuItem("<u>C</u>lose");
        closeItem.setEnableIfCondition(enableCondition);
        closeItem.setKeyTitle("Alt+C");
        KeyIdentifier closeKey = new KeyIdentifier();
        closeKey.setAltKey(true);
        closeKey.setKeyName("C");
        closeItem.setKeys(closeKey);
        closeItem.addClickHandler(new ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                int selectedTab = mainTabSet.getSelectedTabNumber();
                mainTabSet.removeTab(selectedTab);
                mainTabSet.selectTab(selectedTab - 1);
            }
        });

        MenuItem closeAllButCurrent = new MenuItem("Close All But Current");
        closeAllButCurrent.setEnableIfCondition(enableCondition);
        closeAllButCurrent.addClickHandler(new ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                int selected = mainTabSet.getSelectedTabNumber();
                Tab[] tabs = mainTabSet.getTabs();
                int[] tabsToRemove = new int[tabs.length - 2];
                int cnt = 0;
                for (int i = 1; i < tabs.length; i++) {
                    if (i != selected) {
                        tabsToRemove[cnt] = i;
                        cnt++;
                    }
                }
                mainTabSet.removeTabs(tabsToRemove);
            }
        });

        MenuItem closeAll = new MenuItem("Close All");
        closeAll.setEnableIfCondition(enableCondition);
        closeAll.addClickHandler(new ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                Tab[] tabs = mainTabSet.getTabs();
                int[] tabsToRemove = new int[tabs.length - 1];

                for (int i = 1; i < tabs.length; i++) {
                    tabsToRemove[i - 1] = i;
                }
                mainTabSet.removeTabs(tabsToRemove);
                mainTabSet.selectTab(0);
            }
        });

        menu.setItems(closeItem, closeAllButCurrent, closeAll);
        return menu;
    }

    protected void showSample(TreeNode node) {
        boolean isExplorerTreeNode = node instanceof ExplorerTreeNode;
        if (node instanceof CommandTreeNode) {
            CommandTreeNode commandTreeNode = (CommandTreeNode) node;
            commandTreeNode.getCommand().execute();
        } else if (isExplorerTreeNode) {
            ExplorerTreeNode explorerTreeNode = (ExplorerTreeNode) node;
            PanelFactory factory = explorerTreeNode.getFactory();
            if (factory != null) {
                String panelID = factory.getID();
                Tab tab = null;
                if (panelID != null) {
                    String tabID = panelID + "_tab";
                    tab = mainTabSet.getTab(tabID);
                }
                if (tab == null) {
                    boolean autotest = ShowcaseConfiguration.getSingleton().isOpenForTesting();
                    Canvas panel = autotest ? SampleResultsManager.create(mainTabSet, factory) : factory.create();
                    tab = new Tab();
                    tab.setID(factory.getID() + "_tab");
                    //store history token on tab so that when an already open is selected, one can retrieve the
                    //history token and update the URL
                    tab.setAttribute("historyToken", explorerTreeNode.getNodeID());
                    tab.setContextMenu(contextMenu);

                    String sampleName = explorerTreeNode.getName();

                    String icon = explorerTreeNode.getIcon();
                    if (icon == null) {
                        icon = "silk/plugin.png";
                    }
                    String imgHTML = Canvas.imgHTML(icon, 16, 16);
                    tab.setTitle("<span>" + imgHTML + "&nbsp;" + sampleName + "</span>");
                    tab.setPane(panel);
                    tab.setCanClose(true);
                    mainTabSet.addTab(tab);
                    mainTabSet.selectTab(tab);
                } else {
                    mainTabSet.selectTab(tab);
                }
            }
        }
    }

    public void onHistoryChanged(String historyToken) {
        if (historyToken == null || historyToken.equals("")) {
            mainTabSet.selectTab(0);
        } else {
            ExplorerTreeNode[] showcaseData = sideNav.getShowcaseData();
            for (ExplorerTreeNode explorerTreeNode : showcaseData) {
                if (explorerTreeNode.getNodeID().equals(historyToken)) {
                    showSample(explorerTreeNode);
                    ListGridRecord selectedRecord = sideNav.getSelectedRecord();
                    if(selectedRecord != null) {
                        sideNav.deselectRecord(selectedRecord);
                    }
                    sideNav.selectRecord(explorerTreeNode);
                    Tree tree = sideNav.getData();
                    TreeNode categoryNode = tree.getParent(explorerTreeNode);
                    while (categoryNode != null && !"/".equals(tree.getName(categoryNode))) {
                        tree.openFolder(categoryNode);
                        categoryNode = tree.getParent(categoryNode);
                    }
                }
            }
        }
    }
}
