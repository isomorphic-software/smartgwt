package com.smartgwt.sample.showcase.client.menu;

import com.smartgwt.client.types.ColorPickerMode;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.ColorPicker;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ColorChangedEvent;
import com.smartgwt.client.widgets.form.events.ColorChangedHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class MenuEmbeddedComponentsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Smart GWT allows placing arbitrary controls within a Menu." +
            "<p>" +
            "Click the \"Menu\" button below to open a sample menu.  Note how the common typical " +
            "Cut/Copy/Paste menu items have been collapsed into a more compact row of buttons, and the " +
            "\"Add Bookmark\" item gives you the ability to override the default title for a new " +
            "bookmark without leaving the menu." +
            "</p>" +
            "<p>" +
            "Smart GWT makes this very straightforward with the concept of an \"embedded component\", " +
            "allowed for any MenuItem." +
            "</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MenuEmbeddedComponentsSample panel = new MenuEmbeddedComponentsSample();
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
        final Menu menu = new Menu();
        menu.setWidth(505);
        menu.setHeight(440);

        final HStack editButtons = new HStack(3);
        editButtons.setDefaultLayoutAlign(VerticalAlignment.CENTER);
        editButtons.setSnapTo("TR");
        editButtons.setHeight("100%");
        editButtons.setMembers(createEditButton("Cut"), createEditButton("Copy"), createEditButton("Paste"));

        final MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setShowRollOver(false);
        editMenuItem.setEmbeddedComponentFields("key");
        editMenuItem.setEmbeddedComponent(editButtons);

        final Canvas colorBox = new Canvas("colorBox");
        colorBox.setWidth(22);
        colorBox.setHeight(22);

        final TextItem bookmarkInput = new TextItem("bookmarkTitle");
        bookmarkInput.setWidth(200);
        bookmarkInput.setShowTitle(false);
        bookmarkInput.setDefaultValue("Smart GWT Showcase");

        final DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setID("bookmarkForm");
        dynamicForm.setWidth(200);
        dynamicForm.setHeight("*");
        dynamicForm.setSnapTo("TR");
        dynamicForm.setFields(bookmarkInput);

        final IButton addBookmarkButton = new IButton("Add");
        addBookmarkButton.setWidth(50);
        addBookmarkButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Menu.hideAllMenus();
            }
        });

        final HStack bookmarkEmbedded = new HStack(3);
        bookmarkEmbedded.setDefaultLayoutAlign(VerticalAlignment.CENTER);
        bookmarkEmbedded.setSnapTo("TR");
        bookmarkEmbedded.setHeight100();
        bookmarkEmbedded.setMembers(colorBox, dynamicForm, addBookmarkButton);

        final MenuItem bookmarkMenuItem = new MenuItem("Add bookmark");
        bookmarkMenuItem.setShowRollOver(false);
        bookmarkMenuItem.setEmbeddedComponentFields("key");
        bookmarkMenuItem.setEmbeddedComponent(bookmarkEmbedded);

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setSnapTo("TR");
        colorPicker.setStyleName("");
        colorPicker.setBodyStyle("");
        colorPicker.setBorder("0");
        colorPicker.setShowShadow(false);
        colorPicker.setShowEdges(false);
        colorPicker.setAutoHide(false);
        colorPicker.setShowHeader(false);
        colorPicker.setShowFooter(false);
        colorPicker.setCanDragReposition(false);
        colorPicker.setDefaultPickMode(ColorPickerMode.COMPLEX);
        colorPicker.setShowCancelButton(false);
        colorPicker.setShowModeToggleButton(false);
        colorPicker.setShowOkButton(false);

        colorPicker.addColorChangedHandler(new ColorChangedHandler() {
            @Override
            public void onColorChanged(ColorChangedEvent event) {
                colorBox.setBackgroundColor(colorPicker.getHtmlColor());
            }
        });

        final MenuItem colorPickerMenuItem = new MenuItem();
        colorPickerMenuItem.setShowRollOver(false);
        colorPickerMenuItem.setEmbeddedComponent(colorPicker);
        colorPickerMenuItem.setEmbeddedComponentFields("key");

        menu.setData(
                new MenuItem("New tab", null, "Ctrl+T"),
                new MenuItem("New window", null, "Ctrl+N"),
                new MenuItemSeparator(),
                editMenuItem,
                new MenuItemSeparator(),
                bookmarkMenuItem,
                new MenuItemSeparator(),
                colorPickerMenuItem
        );

        final IMenuButton menuButton = new IMenuButton("Menu", menu);
        menuButton.setWidth(100);

        final HStack layout = new HStack();
        layout.setWidth100();
        layout.setMembers(menuButton);
        return layout;
    }

    private IButton createEditButton(final String title) {
        final IButton button = new IButton(title);
        button.setWidth(63);

        return button;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}