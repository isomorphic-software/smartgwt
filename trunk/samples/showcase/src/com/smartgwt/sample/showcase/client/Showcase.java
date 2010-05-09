package com.smartgwt.sample.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
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

public class Showcase implements EntryPoint, HistoryListener {

    private TabSet mainTabSet;
    private SideNavTree sideNav;
    private Menu contextMenu;

    public void onModuleLoad() {

        final String initToken = History.getToken();

        //setup overall layout / viewport
        VLayout main = new VLayout() {
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
                com.google.gwt.user.client.Window.open("http://code.google.com/p/smartgwt/", "sgwt", null);
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

        main.addMember(topBar);

        main.setWidth100();
        main.setHeight100();
        main.setStyleName("tabSetContainer");

        HLayout hLayout = new HLayout();
        hLayout.setLayoutMargin(5);
        hLayout.setWidth100();
        hLayout.setHeight100();

        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(185);
        sideNavLayout.setShowResizeBar(true);

        sideNav = new SideNavTree();
        sideNav.addLeafClickHandler(new LeafClickHandler() {
            public void onLeafClick(LeafClickEvent event) {
                TreeNode node = event.getLeaf();
                showSample(node);
            }
        });

        sideNavLayout.addMember(sideNav);
        hLayout.addMember(sideNavLayout);

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


        selectItem.setValueMap(valueMap);

        String currentSkin = Cookies.getCookie("skin_name");
        if (currentSkin == null) {
            currentSkin = "Graphite";
        }
        selectItem.setDefaultValue(currentSkin);
        selectItem.setShowTitle(false);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie("skin_name", (String) event.getValue());
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
        tab.setIcon("pieces/16/cube_green.png");
        tab.setWidth(80);

        HLayout mainPanel = new HLayout();
        mainPanel.setHeight100();
        mainPanel.setWidth100();

        TileView tileView = new TileView(mainPanel);
        mainPanel.addMember(tileView);

        tab.setPane(mainPanel);

        mainTabSet.addTab(tab);

        Canvas canvas = new Canvas();
        canvas.setBackgroundImage("[SKIN]/shared/background.gif");
        canvas.setWidth100();
        canvas.setHeight100();
        canvas.addChild(mainTabSet);

        hLayout.addMember(canvas);
        main.addMember(hLayout);

        if (SC.hasFirebug()) {
            Label label = new Label();
            label.setWidth100();
            label.setHeight(50);
            label.setValign(VerticalAlignment.CENTER);
            label.setAlign(Alignment.CENTER);
            label.setContents("Firebug can make the Showcase run slow.For the best performance, we suggest disabling Firebug for this site.");

            Window fbWindow = new Window();
            fbWindow.setTitle("Firebug Detected");
            fbWindow.setWidth100();
            fbWindow.setHeight(80);
            fbWindow.addItem(label);
            fbWindow.setRedrawOnResize(true);
            main.addMember(fbWindow);
        }

        main.draw();

        // Add history listener
        History.addHistoryListener(this);

        RootPanel.getBodyElement().removeChild(RootPanel.get("loadingWrapper").getElement());
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

    private void showSample(TreeNode node) {
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
                    Canvas panel = factory.create();
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
                History.newItem(explorerTreeNode.getNodeID(), false);
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
