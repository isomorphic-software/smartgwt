package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class ContextMenuSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Right click (or option-click on Macs) on the image to access a context menu. You can also click on the \"Widget\" button to access the identical menu.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ContextMenuSample panel = new ContextMenuSample();
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
        Canvas canvas = new Canvas();

        final Img widget = new Img("crystal/128/apps/xmms.png", 100, 100);
        widget.setLeft(200);
        widget.setTop(75);
        canvas.addChild(widget);

        Menu sizeMenu = new Menu();
        sizeMenu.setWidth(150);

        MenuItem smallItem = new MenuItem("Small");
        smallItem.setCheckIfCondition(new MenuItemIfFunction() {
            public boolean execute(Canvas target, Menu menu, MenuItem item) {
                return widget.getWidth() == 50;
            }
        });
        smallItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateResize(50, 50);
            }
        });

        MenuItem mediumItem = new MenuItem("Medium");
        mediumItem.setCheckIfCondition(new MenuItemIfFunction() {
            public boolean execute(Canvas target, Menu menu, MenuItem item) {
                return widget.getWidth() == 100;
            }
        });
        mediumItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateResize(100, 100);
            }
        });

        MenuItem largeItem = new MenuItem("Large");
        largeItem.setCheckIfCondition(new MenuItemIfFunction() {
            public boolean execute(Canvas target, Menu menu, MenuItem item) {
                return widget.getWidth() == 200;
            }
        });
        largeItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateResize(200, 200);
            }
        });

        sizeMenu.setItems(smallItem, mediumItem, largeItem);

        Menu moveMenu = new Menu();
        moveMenu.setWidth(150);

        MenuItem upItem = new MenuItem("Up");
        upItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateMove(widget.getOffsetX(), widget.getOffsetY() - 20);
            }
        });

        MenuItem rightItem = new MenuItem("Right");
        rightItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateMove(widget.getOffsetX() + 20, widget.getOffsetY());
            }
        });

        MenuItem downItem = new MenuItem("Down");
        downItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateMove(widget.getOffsetX(), widget.getOffsetY() + 20);
            }
        });

        MenuItem leftItem = new MenuItem("Left");
        leftItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateMove(widget.getOffsetX() - 20, widget.getOffsetY());
            }
        });

        moveMenu.setData(upItem, rightItem, downItem, leftItem);

        Menu mainMenu = new Menu();
        mainMenu.setWidth(150);
        widget.setContextMenu(mainMenu);

        MenuItem visibleItem = new MenuItem();
        visibleItem.setTitle("Visible");
        visibleItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                if (widget.isVisible()) {
                    widget.animateHide(AnimationEffect.FADE);
                } else {
                    widget.animateShow(AnimationEffect.FADE);
                }
            }
        });

        MenuItemSeparator separator = new MenuItemSeparator();

        MenuItem sizeItem = new MenuItem("Size");
        sizeItem.setSubmenu(sizeMenu);

        MenuItem moveItem = new MenuItem("Move");
        moveItem.setSubmenu(moveMenu);

        MenuItem resetItem = new MenuItem("Reset");
        resetItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
            public void onClick(MenuItemClickEvent event) {
                widget.animateRect(200, 75, 100, 100);
                widget.animateShow(AnimationEffect.FADE);
            }
        });
        resetItem.setIcon("crystal/128/apps/xmms.png");
        resetItem.setIconWidth(20);
        resetItem.setIconHeight(20);

        mainMenu.setItems(visibleItem, separator, sizeItem, moveItem, separator, resetItem);

        IMenuButton mainMenuButton = new IMenuButton("Widget", mainMenu);
        mainMenuButton.setWidth(150);

        canvas.addChild(mainMenuButton);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}