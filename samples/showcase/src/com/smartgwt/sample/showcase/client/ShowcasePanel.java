package com.smartgwt.sample.showcase.client;

import java.util.Arrays;
import java.util.List;

import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public abstract class ShowcasePanel extends VLayout {

    protected Canvas viewPanel;

    private Window introWindow;
    private String betaMessage = "";

    public ShowcasePanel() {
        setWidth100();
        setHeight100();

        viewPanel = getViewPanel();
        if (Browser.getIsDesktop()) {
            final boolean topIntro = isTopIntro();
            final Layout layout = topIntro ? new VLayout() : new HLayout();

            layout.setWidth100();
            layout.setMargin(10);
            layout.setMembersMargin(10);

            final HLayout wrapper = new HLayout();
            wrapper.setWidth100();
            wrapper.addMember(viewPanel);

            layout.addMember(wrapper);
            addMember(layout);
        } else {
            addMember(viewPanel);
        }
    }

    protected boolean shouldWrapViewPanel() {
        List<Class<?>> optimalPanelClasses = Arrays.<Class<?>>asList(
            Canvas.class, HLayout.class, HStack.class, VLayout.class, VStack.class 
        );
        return optimalPanelClasses.indexOf(viewPanel.getClass()) < 0;
    }

    protected boolean isTopIntro() {
        return false;
    }

    public SourceEntity[] getSourceUrls() {
        return null;
    }

    public final String getSourceGenUrl() {
        String className = getClass().getName();
        String htmlPath = className.replace("com.smartgwt.sample.showcase.client.", "").replace(".", "/") + ".java.html";
        return "sourcegen/" + htmlPath;
    }

    public String getHtmlUrl() {
        return null;
    }

    public String getXmlDataUrl() {
        return null;
    }

    public String getJsonDataUrl() {
        return null;
    }

    public String getCssUrl() {
        return null;
    }

    public String getIntro() {
        return null;
    }

    public abstract Canvas getViewPanel();

    protected void showSource(SourceEntity[] sourceUrls, int width, int height, boolean useDesktopMode) {
        final Window win = new Window();
        win.setShouldPrint(false);
        win.setTitle("Source");
        win.setHeaderIcon("pieces/16/cube_green.png", 16, 16);
        win.setKeepInParentRect(true);
        if (!useDesktopMode) {
            win.setMaximized(true);
            win.setShowMaximizeButton(false);
            win.setShowMinimizeButton(false);
        }

        int userWidth = com.google.gwt.user.client.Window.getClientWidth() - 20;
        win.setWidth(userWidth < width ? userWidth : width);

        int userHeight = com.google.gwt.user.client.Window.getClientHeight() - 96;
        win.setHeight(userHeight < height ? userHeight : height);

        int windowTop = 10;
        int windowLeft = getWidth() - win.getWidth() - 10;
        win.setLeft(windowLeft);
        win.setTop(windowTop);
        win.setCanDragReposition(true);
        win.setCanDragResize(true);

        final TabSet tabs = new TabSet();
        tabs.setTabBarPosition(Side.TOP);
        tabs.setWidth100();
        tabs.setHeight100();
        for (int i = 0; i < sourceUrls.length; i++) {
            SourceEntity sourceUrl = sourceUrls[i];
            tabs.addTab(buildSourceTab(sourceUrl));
        }

        int lastPeriodIndex = getClass().getName().lastIndexOf('.');
        String simpleClassName = getClass().getName().substring(lastPeriodIndex + 1);
        String[] dataURLs = DataURLRecords.getDataURLs(simpleClassName);
        if (dataURLs != null) {
            for (String dataURL : dataURLs) {
                String url = "sourcegen/" + dataURL + ".html";
                int lastSlashIndex = dataURL.lastIndexOf('/');
                String tabTitle = lastSlashIndex >= 0 ? dataURL.substring(lastSlashIndex + 1) : dataURL;
                tabs.addTab(buildSourceTab(tabTitle, "silk/page_white_cup.png", url));
            }
        }

        if (getCssUrl() != null) {
            tabs.addTab(buildSourceTab("CSS", "silk/css.png", getCssUrl()));
        }

        if (getJsonDataUrl() != null) {
            tabs.addTab(buildSourceTab("JSON", "silk/database_table.png", getJsonDataUrl()));
        }

        if (getXmlDataUrl() != null) {
            tabs.addTab(buildSourceTab("XML", "silk/database_table.png", getXmlDataUrl()));
        }

        win.addItem(tabs);
        if (useDesktopMode) addChild(win);
        win.show();
    }

    protected void setBetaMessage(String message) {
        this.betaMessage = message;
    }

    protected void showOverview(boolean useDesktopMode) {
        final boolean topIntro = isTopIntro();
        final String intro = getIntro();
        if (intro == null || intro.isEmpty()) return;

        if (introWindow == null) {
            introWindow = new Window();
            introWindow.setShouldPrint(false);
            introWindow.setTitle("Overview");
            introWindow.setHeaderIcon("pieces/16/cube_green.png", 16, 16);
            introWindow.setKeepInParentRect(true);
            if (!useDesktopMode) {
                introWindow.setMaximized(true);
                introWindow.setShowMaximizeButton(false);
                introWindow.setShowMinimizeButton(false);
            }

            String introContents = "<p class='intro-para'>" + intro + this.betaMessage + "</p>";
            Canvas contents = new Canvas();
            contents.setCanSelectText(true);
            contents.setPadding(10);
            contents.setContents(introContents);
            if (topIntro) {
                contents.setWidth100();
            } else {
                contents.setDefaultWidth(200);
            }

            if (useDesktopMode) {
                introWindow.setAutoHeight();
            }
            introWindow.setCanDragReposition(false);
            introWindow.setCanDragResize(false);
            introWindow.addItem(contents);
        }

        if (useDesktopMode) {
            final Layout layout = ((Layout)getMember(0));
            if (topIntro) {
                introWindow.setAutoSize(false);
                introWindow.setOverflow(Overflow.VISIBLE);
                introWindow.setAutoChildProperties("body", new Canvas() {{setOverflow(Overflow.VISIBLE);}});
                layout.addMember(introWindow, 0);
            } else {
                introWindow.setAutoSize(true);   
                layout.addMember(introWindow);
            }
        } else {
            introWindow.show();
        }
    }

    public Tab buildSourceTab(SourceEntity sourceEntity) {
        return buildSourceTab(sourceEntity.getTitle(), "silk/script_go.png", sourceEntity.getUrl());
    }

    public Tab buildSourceTab(String title, String icon, String url) {
        final HTMLPane tabPane = new HTMLPane();
        tabPane.setWidth100();
        tabPane.setHeight100();
        tabPane.setContentsURL(url);
        tabPane.setContentsType(ContentsType.PAGE);
        tabPane.setOverflow(Overflow.AUTO);
        tabPane.setBackgroundColor("white");

        final Tab tab = new Tab(title, icon);
        tab.setPane(tabPane);
        return tab;
    }
}
