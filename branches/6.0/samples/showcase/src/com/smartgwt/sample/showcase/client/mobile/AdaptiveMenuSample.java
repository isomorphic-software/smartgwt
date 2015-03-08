package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.menu.AdaptiveMenu;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AdaptiveMenuSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "The AdaptiveMenu component can either display menu items inline, or in a drop-down, or mix " +
        "the two modes according to available space. " +
        "<p>" +
        "In the example below, an AdaptiveMenu is shown inline in a tool strip.  Use the resize bar " +
        "at the right end of the tool strip to reduce the available size, and note how menu options " +
        "are hidden, but become available via a drop-down control." +
        "<p>" +
        "This gives users with larger screens instant access to menu options, while still allowing " +
        "the same functionality to work on smaller screens.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AdaptiveMenuSample panel = new AdaptiveMenuSample();
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

    private MenuItem createMenuItem(final String title) {
        MenuItem item = new MenuItem(title);
        item.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            @Override
            public void onClick(MenuItemClickEvent event) {
                SC.say(title);
            }
        });
        return item;
    }

    public Canvas getViewPanel() {

        final Label variableName = new Label();
        variableName.setContents("<b>Candidate: Lucy Lu</b>");
        variableName.setWidth(1);
        variableName.setWrap(false);

        Menu menu = new Menu();
        menu.setItems(new MenuItem[] {
            createMenuItem("Contact"),
            createMenuItem("Hire Now"),
            createMenuItem("View Résumé")
        });
        
        AdaptiveMenu adaptiveMenu = new AdaptiveMenu(menu);
        adaptiveMenu.setDefaultLayoutAlign(Alignment.CENTER);

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setWidth(375);
        toolStrip.setMembersMargin(5);
        toolStrip.setLayoutLeftMargin(10);
        toolStrip.setShowResizeBar(true);
        toolStrip.setMembers(variableName, new ToolStripSeparator(), adaptiveMenu);

        HLayout outerLayout = new HLayout();
        outerLayout.setHeight(30);
        outerLayout.setWidth100();
        outerLayout.setHPolicy(LayoutPolicy.NONE);
        outerLayout.setMembers(toolStrip);

        Canvas canvas = new Canvas();
        canvas.addChild(outerLayout);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
