package com.smartgwt.sample.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ShowContextMenuEvent;
import com.smartgwt.client.widgets.events.ShowContextMenuHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemIfFunction;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.LeafClickEvent;
import com.smartgwt.client.widgets.tree.events.LeafClickHandler;
import com.smartgwt.sample.showcase.client.data.CommandTreeNode;
import com.smartgwt.sample.showcase.client.data.ExplorerTreeNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Showcase implements EntryPoint, HistoryListener {

    private TabSet mainTabSet;
    private SideNavTree sideNav;



    public void onModuleLoad() {

        final String initToken = History.getToken();

        //setup overall layout
        //viewport
        VLayout main = new VLayout() {
            protected void onInit() {
                super.onInit();
                if (initToken.length() != 0) {
                    onHistoryChanged(initToken);
                }
            }
        };

        main.setWidth100();
        main.setHeight100();
        main.setLayoutMargin(5);
        main.setStyleName("tabSetContainer");

        HLayout hLayout = new HLayout();
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

        //default is 22. required to increase to that select tab contol dispalys well
        mainTabSet.setTabBarThickness(23);
        mainTabSet.setWidth100();
        mainTabSet.setHeight100();
        mainTabSet.setCloseTabIcon("[SKIN]/Window/close.png");

        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setWidth(5);

        SelectItem selectItem = new SelectItem();
        selectItem.setWidth(130);
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("Enterprise", "Enterprise");
        valueMap.put("SilverWave", "Silver Wave");
        valueMap.put("BlackOps", "Black Ops");
        valueMap.put("TreeFrog", "Tree Frog");

        selectItem.setValueMap(valueMap);

        String currentSkin = Cookies.getCookie("skin");
        if (currentSkin == null) {
            currentSkin = "Enterprise";
        }
        selectItem.setDefaultValue(currentSkin);
        selectItem.setShowTitle(false);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie("skin", (String) event.getValue());
                com.google.gwt.user.client.Window.Location.reload();
            }
        });

        DynamicForm form = new DynamicForm();
        form.setPadding(0);
        form.setMargin(0);
        form.setCellPadding(1);
        form.setNumCols(1);
        form.setFields(selectItem);

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

        mainTabSet.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, layoutSpacer, form, imgButton);

        final Menu contextMenu = createContextMenu();
        mainTabSet.addShowContextMenuHandler(new ShowContextMenuHandler() {
            public void onShowContextMenu(ShowContextMenuEvent event) {
                int selectedTab = mainTabSet.getSelectedTabNumber();
                if (selectedTab != 0) {
                    contextMenu.showContextMenu();
                }
                event.cancel();
            }
        });

        Tab tab = new Tab();
        tab.setTitle("SmartGWT Showcase&nbsp;&nbsp;");
        tab.setIcon("pieces/16/cube_green.png");

        ShowcaseGrid tocGrid = new ShowcaseGrid();
        tocGrid.setHeight100();
        tocGrid.setWidth100();

        tocGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
            public void onRecordDoubleClick(RecordDoubleClickEvent event) {
                TreeNode node = (TreeNode) event.getRecord();
                showSample(node);
            }
        });

        Window window = new Window();
        window.setTitle("SmartGWT Showcase");
        window.setHeaderControls(HeaderControls.HEADER_LABEL, HeaderControls.MINIMIZE_BUTTON,
                                    HeaderControls.MAXIMIZE_BUTTON, HeaderControls.CLOSE_BUTTON);
        window.setWidth(500);
        window.setHeight(375);
        window.addItem(tocGrid);
        window.setKeepInParentRect(true);
        window.setTop(30);
        window.setLeft(30);
        window.setCanDragResize(true);


        HLayout mainPanel = new HLayout();
        mainPanel.setHeight100();
        mainPanel.setWidth100();

        if(SC.hasFirebug()) {
            Label label = new Label();
            label.setContents("<p>Firebug can make the Showcase run slow.</p><p>For the best performance, we suggest disabling Firebug for this site.</p>");
            label.setWidth100();
            label.setHeight("auto");
            label.setMargin(20);
            Window fbWindow = new Window();
            fbWindow.setShowHeader(false);
            fbWindow.addItem(label);
            fbWindow.setWidth(220);
            fbWindow.setHeight(130);

            LayoutSpacer spacer = new LayoutSpacer();
            spacer.setWidth100();
            mainPanel.addMember(spacer);
            mainPanel.addMember(fbWindow);
        }
        mainPanel.addChild(window);

        tab.setPane(mainPanel);

        mainTabSet.addTab(tab);

        Canvas canvas = new Canvas();
        canvas.setBackgroundImage("[SKIN]/shared/background.gif");
        canvas.setWidth100();
        canvas.setHeight100();
        canvas.addChild(mainTabSet);

        hLayout.addMember(canvas);
        main.addMember(hLayout);
        main.draw();

        // Add history listener
        History.addHistoryListener(this);

        RootPanel.get("loadingMsg").getElement().setInnerHTML("");
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
                    String sampleName = explorerTreeNode.getName();


                    String icon = explorerTreeNode.getIcon();
                    if (icon == null) {
                        icon = "silk/plugin.png";
                    }
                    String imgHTML = Canvas.imgHTML(icon);
                    tab.setTitle("<span>" + imgHTML + "&nbsp;" + sampleName + "</span>");
                    tab.setPane(panel);
                    tab.setCanClose(true);
                    mainTabSet.addTab(tab);
                    mainTabSet.selectTab(tab);
                    if(!SC.isIE()) {
                        if (mainTabSet.getNumTabs() == 10) {
                            mainTabSet.removeTabs(new int[]{1});
                        }
                    }
                    History.newItem(explorerTreeNode.getNodeID(), false);
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
                    sideNav.selectRecord(explorerTreeNode);
                    Tree tree = sideNav.getData();
                    TreeNode categoryNode = tree.getParent(explorerTreeNode);
                    //TODO isRoot not working?
                    //while (categoryNode != null && !tree.isRoot(categoryNode)) {
                    while (categoryNode != null && !"/".equals(tree.getName(categoryNode))) {
                        tree.openFolder(categoryNode);
                        categoryNode = tree.getParent(categoryNode);
                    }
                }
            }
        }
    }
}
