/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickHandler;


/**
 * Convenience class for icons that are placed in as header controls in a {@link com.smartgwt.client.widgets.Window} Header, or {@link com.smartgwt.client.widgets.layout.SectionStackSection}.
 *
 * @see com.smartgwt.client.widgets.Window#setHeaderControls(Object...)
 * @see com.smartgwt.client.widgets.layout.SectionStackSection#setControls(Canvas...)
 */
public class HeaderControl extends Img {

    public static HeaderIcon ARROW_DOWN = new HeaderIcon("[SKIN]/headerIcons/arrow_down.png");
    public static HeaderIcon ARROW_LEFT = new HeaderIcon("[SKIN]/headerIcons/arrow_left.png");
    public static HeaderIcon ARROW_RIGHT = new HeaderIcon("[SKIN]/headerIcons/arrow_right.png");
    public static HeaderIcon ARROW_UP = new HeaderIcon("[SKIN]/headerIcons/arrow_up.png");
    public static HeaderIcon CALCULATOR = new HeaderIcon("[SKIN]/headerIcons/calculator.png");
    public static HeaderIcon CART = new HeaderIcon("[SKIN]/headerIcons/cart.png");
    public static HeaderIcon CASCADE = new HeaderIcon("[SKIN]/headerIcons/cascade.png");
    public static HeaderIcon CLIPBOARD = new HeaderIcon("[SKIN]/headerIcons/clipboard.png");
    public static HeaderIcon CLOCK = new HeaderIcon("[SKIN]/headerIcons/clock.png");
    public static HeaderIcon CLOSE = new HeaderIcon("[SKIN]/headerIcons/close.png");
    public static HeaderIcon COMMENT = new HeaderIcon("[SKIN]/headerIcons/comment.png");
    public static HeaderIcon DOCUMENT = new HeaderIcon("[SKIN]/headerIcons/document.png");
    public static HeaderIcon DOUBLE_ARROW_DOWN = new HeaderIcon("[SKIN]/headerIcons/double_arrow_down.png");
    public static HeaderIcon DOUBLE_ARROW_LEFT = new HeaderIcon("[SKIN]/headerIcons/double_arrow_left.png");
    public static HeaderIcon DOUBLE_ARROW_RIGHT = new HeaderIcon("[SKIN]/headerIcons/double_arrow_right.png");
    public static HeaderIcon DOUBLE_ARROW_UP = new HeaderIcon("[SKIN]/headerIcons/double_arrow_up.png");
    public static HeaderIcon FAVOURITE = new HeaderIcon("[SKIN]/headerIcons/favourite.png");
    public static HeaderIcon FIND = new HeaderIcon("[SKIN]/headerIcons/find.png");
    public static HeaderIcon HELP = new HeaderIcon("[SKIN]/headerIcons/help.png");
    public static HeaderIcon HOME = new HeaderIcon("[SKIN]/headerIcons/home.png");
    public static HeaderIcon MAIL = new HeaderIcon("[SKIN]/headerIcons/mail.png");
    public static HeaderIcon MAXIMIZE = new HeaderIcon("[SKIN]/headerIcons/maximize.png");
    public static HeaderIcon MINIMIZE = new HeaderIcon("[SKIN]/headerIcons/minimize.png");
    public static HeaderIcon MINUS = new HeaderIcon("[SKIN]/headerIcons/minus.png");
    public static HeaderIcon PERSON = new HeaderIcon("[SKIN]/headerIcons/person.png");
    public static HeaderIcon PIN_DOWN = new HeaderIcon("[SKIN]/headerIcons/pin_down.png");
    public static HeaderIcon PIN_LEFT = new HeaderIcon("[SKIN]/headerIcons/pin_left.png");
    public static HeaderIcon PLUS = new HeaderIcon("[SKIN]/headerIcons/plus.png");
    public static HeaderIcon PRINT = new HeaderIcon("[SKIN]/headerIcons/print.png");
    public static HeaderIcon REFRESH = new HeaderIcon("[SKIN]/headerIcons/refresh.png");
    public static HeaderIcon REFRESH_THIN = new HeaderIcon("[SKIN]/headerIcons/refresh_thin.png");
    public static HeaderIcon SAVE = new HeaderIcon("[SKIN]/headerIcons/save.png");
    public static HeaderIcon SETTINGS = new HeaderIcon("[SKIN]/headerIcons/settings.png");
    public static HeaderIcon TRANSFER = new HeaderIcon("[SKIN]/headerIcons/transfer.png");
    public static HeaderIcon TRASH = new HeaderIcon("[SKIN]/headerIcons/trash.png");
    public static HeaderIcon ZOOM = new HeaderIcon("[SKIN]/headerIcons/zoom.png");

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param icon the icon
     */
    public HeaderControl(HeaderIcon icon) {
        setSrc(icon.url);
        setWidth(15);
        setHeight(15);
        setLayoutAlign(Alignment.CENTER);
        setShowRollOver(true);
    }

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param icon the icon
     * @param clickHandler the header control click handler
     */
    public HeaderControl(HeaderIcon icon, ClickHandler clickHandler) {
        this(icon);
        addClickHandler(clickHandler);
    }

    public static class HeaderIcon {
        private String url;

        public HeaderIcon(String url) {
            this.url = url;
        }
    }
}
