package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.menu.AdaptiveMenu;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AdaptiveMenuSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "The AdaptiveMenu component can either display menu items inline, or in a drop-down, or mix " +
        "the two modes according to available space. " +
        "<p>" +
        "In the example below, a menu is shown inline in a tool strip. Use the resize bar at the right "+
        "end of the tool strip to reduce the available size, and note how a drop-down control appears "+
        "that provides access to those items that no longer can be inlined due to the reduced "+
        "available space. At its minimum width, no items are inlined and access to them all is "+
        "provided through the drop-down control."+
        "<p>"+
        "Click the Button that says \"Longer Name\" and try resizing again. Note how the menu switches to "+
        "a drop-down sooner, because more space is taken by the name." +
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

    private HStack createLayoutMenuItemEdit() {
        HStack hStack = new HStack();
        hStack.setHeight100();
        hStack.setWidth(190);
        hStack.setSnapTo("TR");
        hStack.setMembersMargin(3);
        hStack.setLayoutMargin(5);
        hStack.setDefaultLayoutAlign(VerticalAlignment.CENTER);

        final IButton cutButton = new IButton();
        cutButton.setTitle("Cut");
        cutButton.setAutoFit(true);
        cutButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.say(cutButton.getTitle());
            }
        });
        final IButton copyButton = new IButton();
        copyButton.setTitle("Copy");
        copyButton.setAutoFit(true);
        copyButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.say(copyButton.getTitle());
            }
        });
        final IButton pasteButton = new IButton();
        pasteButton.setTitle("Paste");
        pasteButton.setAutoFit(true);
        pasteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.say(pasteButton.getTitle());
            }
        });
        hStack.setMembers(cutButton, copyButton, pasteButton);

        return hStack;
    }
    
    public Canvas getViewPanel() {

        final Label variableName = new Label();
        variableName.setContents("<b>Candidate: Lucy Lu</b>");
        variableName.setWidth(1);
        variableName.setWrap(false);

        MenuItem menuItemEdit = new MenuItem();
        menuItemEdit.setTitle("Edit");
        menuItemEdit.setShowRollOver(false);
        menuItemEdit.setEmbeddedComponent(createLayoutMenuItemEdit());
        menuItemEdit.setEmbeddedComponentFields("key");
        
        Menu menu = new Menu();
        menu.setItems(new MenuItem[] {
            createMenuItem("Contact"),
            createMenuItem("Hire Now"),
            createMenuItem("View Résumé"),
            menuItemEdit
        });
        
        Canvas menuProperties = new Canvas();
        menuProperties.setWidth(350);

        AdaptiveMenu adaptiveMenu = new AdaptiveMenu(menu);
        adaptiveMenu.setHeight(30);
        adaptiveMenu.setAutoChildProperties("menu", menuProperties);
        adaptiveMenu.setDefaultLayoutAlign(Alignment.CENTER);

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setHeight(40);
        toolStrip.setWidth(375);
        toolStrip.setMembersMargin(5);
        toolStrip.setLayoutLeftMargin(10);
        toolStrip.setShowResizeBar(true);
        toolStrip.setMembers(variableName, new ToolStripSeparator(), adaptiveMenu);

        HLayout outerLayout = new HLayout();
        outerLayout.setHeight(40);
        outerLayout.setWidth100();
        outerLayout.setHPolicy(LayoutPolicy.NONE);
        outerLayout.setMembers(toolStrip);

        final IButton toggleName = new IButton();
        toggleName.addClickHandler(new ClickHandler() {
            boolean longName = true;
            @Override
            public void onClick(ClickEvent event) {
                longName = !longName;
                String name = longName ? "Alejandro O'Reilly" : "Lucy Lu"; 
                variableName.setContents("<b>Candidate: " + name + "</b>");
                toggleName.setTitle(longName ? "Shorter Name" : "Longer Name");
            }
        });
        toggleName.setTop(50);
        toggleName.fireEvent(new ClickEvent(null){});
        
        Canvas canvas = new Canvas();
        canvas.addChild(outerLayout);
        canvas.addChild(toggleName);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    @Override
    protected boolean isTopIntro() {
        return true;
    }
}
