package com.smartgwt.sample.showcase.client.windows;

import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HeaderControl;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.tile.TileLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class WindowHeaderIconsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Smart GWT provides a collection of standard theme specific convenience header icons. These are typically used as Window headers controls or" +
            " in SectionStackSection headers.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            WindowHeaderIconsSample panel = new WindowHeaderIconsSample();
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
        TileLayout tileLayout = new TileLayout();
        tileLayout.setTileWidth(200);
        tileLayout.setTileHeight(150);
        tileLayout.setWidth100();
        tileLayout.setTilesPerLine(3);


        ClickHandler clickHandler = new ClickHandler() {
            public void onClick(ClickEvent event) {
                String src = ((HeaderControl) event.getSource()).getSrc();
                SC.say("Control " + src + " clicked");
            }
        };

        HeaderControl arrowDown = new HeaderControl(HeaderControl.ARROW_DOWN, clickHandler);
        HeaderControl arrowLeft = new HeaderControl(HeaderControl.ARROW_LEFT, clickHandler);
        HeaderControl arrowRight = new HeaderControl(HeaderControl.ARROW_RIGHT, clickHandler);
        HeaderControl arrowUp = new HeaderControl(HeaderControl.ARROW_UP, clickHandler);
        HeaderControl calculator = new HeaderControl(HeaderControl.CALCULATOR, clickHandler);
        HeaderControl cart = new HeaderControl(HeaderControl.CART, clickHandler);
        HeaderControl cascade = new HeaderControl(HeaderControl.CASCADE, clickHandler);
        HeaderControl clipboard = new HeaderControl(HeaderControl.CLIPBOARD, clickHandler);
        HeaderControl clock = new HeaderControl(HeaderControl.CLOCK, clickHandler);
        HeaderControl close = new HeaderControl(HeaderControl.CLOSE, clickHandler);
        HeaderControl comment = new HeaderControl(HeaderControl.COMMENT, clickHandler);
        HeaderControl document = new HeaderControl(HeaderControl.DOCUMENT, clickHandler);
        HeaderControl doubleArrowDown = new HeaderControl(HeaderControl.DOUBLE_ARROW_DOWN, clickHandler);
        HeaderControl doubleArrowLeft = new HeaderControl(HeaderControl.DOUBLE_ARROW_LEFT, clickHandler);
        HeaderControl doubleArrowRight = new HeaderControl(HeaderControl.DOUBLE_ARROW_RIGHT, clickHandler);
        HeaderControl doubleArrowUp = new HeaderControl(HeaderControl.DOUBLE_ARROW_UP, clickHandler);
        HeaderControl favourite = new HeaderControl(HeaderControl.FAVOURITE, clickHandler);
        HeaderControl find = new HeaderControl(HeaderControl.FIND, clickHandler);
        HeaderControl help = new HeaderControl(HeaderControl.HELP, clickHandler);
        HeaderControl home = new HeaderControl(HeaderControl.HOME, clickHandler);
        HeaderControl mail = new HeaderControl(HeaderControl.MAIL, clickHandler);
        HeaderControl maximize = new HeaderControl(HeaderControl.MAXIMIZE, clickHandler);
        HeaderControl minimize = new HeaderControl(HeaderControl.MINIMIZE, clickHandler);
        HeaderControl minus = new HeaderControl(HeaderControl.MINUS, clickHandler);
        HeaderControl person = new HeaderControl(HeaderControl.PERSON, clickHandler);
        HeaderControl pinDown = new HeaderControl(HeaderControl.PIN_DOWN, clickHandler);
        HeaderControl pinLeft = new HeaderControl(HeaderControl.PIN_LEFT, clickHandler);
        HeaderControl plus = new HeaderControl(HeaderControl.PLUS, clickHandler);
        HeaderControl print = new HeaderControl(HeaderControl.PRINT, clickHandler);
        HeaderControl refresh = new HeaderControl(HeaderControl.REFRESH, clickHandler);
        HeaderControl refreshThin = new HeaderControl(HeaderControl.REFRESH_THIN, clickHandler);
        HeaderControl save = new HeaderControl(HeaderControl.SAVE, clickHandler);
        HeaderControl settings = new HeaderControl(HeaderControl.SETTINGS, clickHandler);
        HeaderControl transfer = new HeaderControl(HeaderControl.TRANSFER, clickHandler);
        HeaderControl trash = new HeaderControl(HeaderControl.TRASH, clickHandler);
        HeaderControl zoom = new HeaderControl(HeaderControl.ZOOM, clickHandler);


        Window window1 = new Window();
        window1.setTitle("Title");
        window1.setWidth(200);
        window1.setHeight(150);

        window1.setHeaderControls(HeaderControls.HEADER_LABEL, arrowDown, arrowLeft, arrowRight,
                                  arrowUp, calculator, cart);
        tileLayout.addTile(window1);

        Window window2 = new Window();
        window2.setTitle("Title");
        window2.setWidth(200);
        window2.setHeight(150);

        window2.setHeaderControls(HeaderControls.HEADER_LABEL, cascade, clipboard, clock, close, comment, document);
        tileLayout.addTile(window2);

        Window window3 = new Window();
        window3.setTitle("Title");
        window3.setWidth(200);
        window3.setHeight(150);
        window3.setHeaderControls(HeaderControls.HEADER_LABEL, doubleArrowDown, doubleArrowLeft,
                                  doubleArrowRight, doubleArrowUp, favourite, find);
        tileLayout.addTile(window3);

        Window window4 = new Window();
        window4.setTitle("Title");
        window4.setWidth(300);
        window4.setHeight(200);
        window4.setHeaderControls(HeaderControls.HEADER_LABEL, home, mail, minus, plus, maximize, minimize);
        tileLayout.addTile(window4);

        Window window5 = new Window();
        window5.setTitle("Title");
        window5.setWidth(200);
        window5.setHeight(150);
        window5.setHeaderControls(HeaderControls.HEADER_LABEL, person, pinDown, pinLeft, print, refresh, help);
        tileLayout.addTile(window5);

        Window window6 = new Window();
        window6.setTitle("Title");
        window6.setWidth(200);
        window6.setHeight(150);
        window6.setHeaderControls(HeaderControls.HEADER_LABEL, refreshThin, save, settings, transfer, trash, zoom);
        tileLayout.addTile(window6);

        return tileLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}