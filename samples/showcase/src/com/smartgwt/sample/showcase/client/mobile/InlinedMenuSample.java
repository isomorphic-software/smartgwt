package com.smartgwt.sample.showcase.client.mobile;

import java.util.Arrays;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.AdaptWidthByCustomizer;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class InlinedMenuSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "Smart GWT's adaptive layout system allows components to react to the amount of " +
        "available space and show a different appearance space for compact spaces.<p>" +
        
        "In the example to the left, a menu is shown inline in a tool strip.  Use the resize " +
        "bar at the right end of the tool strip to reduce the available size, and note how " +
        "a drop-down control appears that provides access to those items that no longer " +
        "can be inlined due to the reduced available space.  At its minimum width, no " +
        "items are inlined and access to all of them is provided via the drop-down control." +

        "<p>Click the Button that says \"Longer Name\" and try resizing again.  Note how the " +
        "menu switches to a drop-down sooner, because more space is taken by the name.<p>" +

        "Smart GWT's adaptive layout system allows components to react intelligently to " +
        "available space, even when the available space depends on dynamic data rather than " +
        "fixed screen sizes.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            InlinedMenuSample panel = new InlinedMenuSample();
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

    public class InlinedMenu extends HLayout {

        Menu menu;
        MenuButton menuButton;
        Integer minimalWidth;

        RecordList inlinedItems = new RecordList();
        int inlinedCount, inlinedMax;

        private ToolStripButton createMenuItem(final String title) {
            ToolStripButton item = new ToolStripButton(title);
            item.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    SC.say(title);
                }
            });
            item.setWidth(1);
            item.setWrap(false);
            item.setVisibility(Visibility.HIDDEN);
            return item;
        }

        private void initialize() {
            // add buttons to represent inlined menu items
            MenuItem[] items = menu.getItems();
            for (int i = 0; i < items.length; i++) {
                addMember(createMenuItem(items[i].getTitle()));
            }
            inlinedMax = getMembers().length;

            // add a menu button to show non-inlined items
            menuButton = new MenuButton(null, menu);
            menuButton.setWidth(1);
            menuButton.setOverflow(Overflow.VISIBLE);
            addMember(menuButton);
        }

        // get width of the next item to be inlined, by drawing it if needed
        private int getNextInlinedItemWidth() {
            Canvas item = getMembers()[inlinedCount];
            if (!item.isDrawn()) item.draw();
                                              
            boolean isLast = inlinedCount == inlinedMax - 1;
            return item.getVisibleWidth() + (isLast ? -minimalWidth : 0);
        }
    
        // add an  inlined item - hide menu button if appropriate
        private void addInlinedItem() {
            inlinedItems.addAt(menu.getDataAsRecordList().removeAt(0), 0);
            if (menu.getTotalRows() == 0) menuButton.hide();
            getMembers()[inlinedCount++].show();
        }

        // remove an inlined item - show menu button if appropriate
        private void removeInlinedItem() {
            if (menu.getTotalRows() == 0) menuButton.show();
            menu.getDataAsRecordList().addAt(inlinedItems.removeAt(0), 0);
            getMembers()[--inlinedCount].hide();
        }

        public InlinedMenu(Menu menu) {
            setCanAdaptWidth(true);
            setOverflow(Overflow.HIDDEN);
            setDefaultLayoutAlign(Alignment.CENTER);
            setAdaptWidthByCustomizer(new AdaptWidthByCustomizer() {
                @Override
                public int adaptWidthBy(int pixelDifference, int unadaptedWidth) {
                    // set the minimal width
                    if (minimalWidth == null) {
                        minimalWidth = menuButton.getVisibleWidth();
                    }

                    // all non-hidden children are drawn; expected width is sum of their widths
                    int expectedWidth = 0;
                    for (Canvas member : getMembers()) {
                        if (member.getVisibility() == Visibility.HIDDEN) continue;
                        expectedWidth += member.getVisibleWidth();
                    }

                    // calculate desired width based on overflow/surplus and unadapted width;
                    // if desired width differs from the expected, add/remove inlined items
                    int desiredWidth = unadaptedWidth + pixelDifference;
                    if (desiredWidth < expectedWidth) {
                        // remove inlined items if we have an overflow
                        while (inlinedCount > 0 && expectedWidth > desiredWidth) 
                            {
                                removeInlinedItem();
                                expectedWidth -= getNextInlinedItemWidth();
                            }
                    } else if (desiredWidth > expectedWidth) {
                        int deltaX;
                        // add inlined items if we have surplus space
                        while (inlinedCount < inlinedMax && 
                               expectedWidth + (deltaX = getNextInlinedItemWidth()) <= desiredWidth)
                            {
                                addInlinedItem();
                                expectedWidth += deltaX;
                            }
                    }
                    return expectedWidth - unadaptedWidth;
                }
            });
            this.menu = menu;
            initialize();
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
        variableName.setWidth(1);
        variableName.setWrap(false);

        Menu menu = new Menu();
        menu.setItems(new MenuItem[] {
            createMenuItem("Contact"),
            createMenuItem("Hire Now"),
            createMenuItem("View Résumé")
        });

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setWidth(375);
        toolStrip.setMembersMargin(5);
        toolStrip.setLayoutLeftMargin(10);
        toolStrip.setShowResizeBar(true);
        toolStrip.setMembers(variableName, new ToolStripSeparator(), new InlinedMenu(menu));

        HLayout outerLayout = new HLayout();
        outerLayout.setHeight(30);
        outerLayout.setWidth100();
        outerLayout.setHPolicy(LayoutPolicy.NONE);
        outerLayout.setMembers(toolStrip);

        final Button toggleName;
        toggleName = new Button();
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

        // viewpanel canvas
        Canvas canvas = new Canvas();
        canvas.addChild(outerLayout);
        canvas.addChild(toggleName);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
