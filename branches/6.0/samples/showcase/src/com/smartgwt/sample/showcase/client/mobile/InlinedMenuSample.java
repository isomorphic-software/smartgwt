package com.smartgwt.sample.showcase.client.mobile;

import java.util.Arrays;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
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
        
        "In the example below, a menu is shown inline in a tool strip.  Use the resize bar " +
        "at the right end of the tool strip to reduce the available size, and note how the " +
        "menu turns into a drop-down control that provides access to the same menu options." +

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

        int narrowWidth = 20;
        int wideWidth;

        Menu menu;
        MenuButton menuButton;
        Canvas[] inlinedItems;

        private ToolStripButton createMenuItem(final String title) {
            ToolStripButton item = new ToolStripButton(title);
            item.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    SC.say(title);
                }
            });
            item.setWrap(false);
            item.setWidth(1);
            return item;
        }

        private void initialize() {
            menuButton = new MenuButton(null, menu);
            menuButton.setWidth(1);
            menuButton.setOverflow(Overflow.VISIBLE);

            MenuItem[] items = menu.getItems();
            inlinedItems  = new Canvas[items.length];

            for (int i = 0; i < items.length; i++) {
                Canvas item = createMenuItem(items[i].getTitle());
                inlinedItems[i] = item;
            }
            setMembers(this.inlinedItems);
        }

        public InlinedMenu(Menu menu) {
            setCanAdaptWidth(true);
            setOverflow(Overflow.HIDDEN);
            setDefaultLayoutAlign(Alignment.CENTER);
            setAdaptWidthByCustomizer(new AdaptWidthByCustomizer() {
                @Override
                public int adaptWidthBy(int deltaX, int unadaptedWidth) {
                    // establish the "wide" width needed for showing all menu items
                    if (wideWidth == 0) {
                        for (int i = 0; i < inlinedItems.length; i++) {
                            inlinedItems[i].draw();
                            wideWidth += inlinedItems[i].getVisibleWidth();
                        };
                    }
                    // if we're offered enough pixels to expand to our "wide" width, accept them
                    if (unadaptedWidth < wideWidth && deltaX >= wideWidth - unadaptedWidth) {
                        setMembers(inlinedItems);
                        return wideWidth - unadaptedWidth;
                    }
                    // drop to our "narrow" width if we're wider than our "narrow" width, and:
                    // - we're at some unexpected width less than our "wide" width, or
                    // - an overflow is present
                    if (unadaptedWidth > narrowWidth && (unadaptedWidth < wideWidth || 
                                                         deltaX < 0))
                    {
                        setMembers(menuButton);
                        return narrowWidth - unadaptedWidth;
                    }
                    // no change
                    return 0;
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
        menu.setData(new MenuItem[] {
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
