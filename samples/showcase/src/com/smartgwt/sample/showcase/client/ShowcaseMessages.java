package com.smartgwt.sample.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.safehtml.shared.SafeHtml;

public interface ShowcaseMessages extends Messages {

    public static final ShowcaseMessages INSTANCE = GWT.create(ShowcaseMessages.class);

    @DefaultMessage("Smart GWT Showcase")
    public SafeHtml navigationPaneTitle();
    @DefaultMessage("Samples")
    public SafeHtml shortNavigationPaneTitle();

    @DefaultMessage("Search samples")
    public SafeHtml searchSamplesTitle();
    @DefaultMessage("Search samples...")
    public String searchSamplesHint();

    @DefaultMessage("Version: {0}<br>Built {1}")
    public SafeHtml versionLabelContents(String version, String buildDate);

    @DefaultMessage("Skin")
    public SafeHtml skinItemTitle();
    @DefaultMessage("Enterprise")
    public String enterpriseSkinName();
    @DefaultMessage("Enterprise Blue")
    public String enterpriseBlueSkinName();
    @DefaultMessage("Graphite")
    public String graphiteSkinName();

    @DefaultMessage("Print")
    public SafeHtml printButtonTitle();

    @DefaultMessage("View Source")
    public SafeHtml viewSourceButtonTitle();
    @DefaultMessage("Source")
    public SafeHtml sourceTabTitle();

    @DefaultMessage("Home&nbsp;&nbsp;")
    public SafeHtml homeTabTitle();



    @DefaultMessage("Smart GWT Showcase")
    public SafeHtml homeNodeName();



    @DefaultMessage("Search")
    public SafeHtml searchTitle();

    @DefaultMessage("# of Samples")
    public SafeHtml numSamplesTitle();

    @DefaultMessage("Ascending")
    public SafeHtml ascendingTitle();

    @DefaultMessage("Disabled Mode")
    public SafeHtml disabledModeTitle();

    @DefaultMessage("Featured Samples")
    public SafeHtml featuredCategoryName();
    @DefaultMessage("New Samples")
    public SafeHtml newSamplesCategoryName();
    @DefaultMessage("ComboBox &amp; Family")
    public SafeHtml comboBoxCategoryName();
    @DefaultMessage("Grids")
    public SafeHtml gridsCategoryName();
    @DefaultMessage("Tree")
    public SafeHtml treeCategoryName();
    @DefaultMessage("Calendar")
    public SafeHtml calendarCategoryName();
    @DefaultMessage("Data View / Tiling")
    public SafeHtml tilesCategoryName();
    @DefaultMessage("Forms")
    public SafeHtml formsCategoryName();
    @DefaultMessage("Layouts")
    public SafeHtml layoutCategoryName();
    @DefaultMessage("Windows")
    public SafeHtml windowsCategoryName();
    @DefaultMessage("Tabs")
    public SafeHtml tabsCategoryName();
    @DefaultMessage("Accordion / Sections")
    public SafeHtml sectionsCategoryName();
    @DefaultMessage("Portal Layout")
    public SafeHtml portalLayoutCategoryName();
    @DefaultMessage("Buttons")
    public SafeHtml buttonsCategoryName();
    @DefaultMessage("Menus")
    public SafeHtml menusCategoryName();
    @DefaultMessage("ToolStrip")
    public SafeHtml toolStripCategoryName();
    @DefaultMessage("Other Controls")
    public SafeHtml otherControlsCategoryName();
    @DefaultMessage("Data Integration")
    public SafeHtml dataIntegrationCategoryName();
    @DefaultMessage("Drag &amp; Drop")
    public SafeHtml dragDropCategoryName();
    @DefaultMessage("Basics")
    public SafeHtml basicsCategoryName();
    @DefaultMessage("Drawing")
    public SafeHtml drawingCategoryName();
    @DefaultMessage("Effects &amp; Animation")
    public SafeHtml effectsCategoryName();
    @DefaultMessage("<span style=\"color:red;font-weight:700;\">BETA</span>")
    public SafeHtml betaSamplesName();

    @DefaultMessage("Categories")
    public SafeHtml categoriesTitle();
}
