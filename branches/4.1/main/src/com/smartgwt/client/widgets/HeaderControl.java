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

    private static String IMG_TYPE = getImgType();

    private static native String getImgType() /*-{
        var imgType = $wnd.isc.headerImgType;
        return imgType == null || imgType === undefined ? "png" : imgType;
    }-*/;

    public static HeaderIcon ARROW_DOWN = new HeaderIcon("[SKIN]/headerIcons/arrow_down." + IMG_TYPE);
    public static HeaderIcon ARROW_LEFT = new HeaderIcon("[SKIN]/headerIcons/arrow_left." + IMG_TYPE);
    public static HeaderIcon ARROW_RIGHT = new HeaderIcon("[SKIN]/headerIcons/arrow_right." + IMG_TYPE);
    public static HeaderIcon ARROW_UP = new HeaderIcon("[SKIN]/headerIcons/arrow_up." + IMG_TYPE);
    public static HeaderIcon CALCULATOR = new HeaderIcon("[SKIN]/headerIcons/calculator." + IMG_TYPE);
    public static HeaderIcon CART = new HeaderIcon("[SKIN]/headerIcons/cart." + IMG_TYPE);
    public static HeaderIcon CASCADE = new HeaderIcon("[SKIN]/headerIcons/cascade." + IMG_TYPE);
    public static HeaderIcon CLIPBOARD = new HeaderIcon("[SKIN]/headerIcons/clipboard." + IMG_TYPE);
    public static HeaderIcon CLOCK = new HeaderIcon("[SKIN]/headerIcons/clock." + IMG_TYPE);
    public static HeaderIcon CLOSE = new HeaderIcon("[SKIN]/headerIcons/close." + IMG_TYPE);
    public static HeaderIcon COMMENT = new HeaderIcon("[SKIN]/headerIcons/comment." + IMG_TYPE);
    public static HeaderIcon DOCUMENT = new HeaderIcon("[SKIN]/headerIcons/document." + IMG_TYPE);
    public static HeaderIcon DOUBLE_ARROW_DOWN = new HeaderIcon("[SKIN]/headerIcons/double_arrow_down." + IMG_TYPE);
    public static HeaderIcon DOUBLE_ARROW_LEFT = new HeaderIcon("[SKIN]/headerIcons/double_arrow_left." + IMG_TYPE);
    public static HeaderIcon DOUBLE_ARROW_RIGHT = new HeaderIcon("[SKIN]/headerIcons/double_arrow_right." + IMG_TYPE);
    public static HeaderIcon DOUBLE_ARROW_UP = new HeaderIcon("[SKIN]/headerIcons/double_arrow_up." + IMG_TYPE);
    public static HeaderIcon FAVOURITE = new HeaderIcon("[SKIN]/headerIcons/favourite." + IMG_TYPE);
    public static HeaderIcon FIND = new HeaderIcon("[SKIN]/headerIcons/find." + IMG_TYPE);
    public static HeaderIcon HELP = new HeaderIcon("[SKIN]/headerIcons/help." + IMG_TYPE);
    public static HeaderIcon HOME = new HeaderIcon("[SKIN]/headerIcons/home." + IMG_TYPE);
    public static HeaderIcon MAIL = new HeaderIcon("[SKIN]/headerIcons/mail." + IMG_TYPE);
    public static HeaderIcon MAXIMIZE = new HeaderIcon("[SKIN]/headerIcons/maximize." + IMG_TYPE);
    public static HeaderIcon MINIMIZE = new HeaderIcon("[SKIN]/headerIcons/minimize." + IMG_TYPE);
    public static HeaderIcon MINUS = new HeaderIcon("[SKIN]/headerIcons/minus." + IMG_TYPE);
    public static HeaderIcon PERSON = new HeaderIcon("[SKIN]/headerIcons/person." + IMG_TYPE);
    public static HeaderIcon PIN_DOWN = new HeaderIcon("[SKIN]/headerIcons/pin_down." + IMG_TYPE);
    public static HeaderIcon PIN_LEFT = new HeaderIcon("[SKIN]/headerIcons/pin_left." + IMG_TYPE);
    public static HeaderIcon PLUS = new HeaderIcon("[SKIN]/headerIcons/plus." + IMG_TYPE);
    public static HeaderIcon PRINT = new HeaderIcon("[SKIN]/headerIcons/print." + IMG_TYPE);
    public static HeaderIcon REFRESH = new HeaderIcon("[SKIN]/headerIcons/refresh." + IMG_TYPE);
    public static HeaderIcon REFRESH_THIN = new HeaderIcon("[SKIN]/headerIcons/refresh_thin." + IMG_TYPE);
    public static HeaderIcon SAVE = new HeaderIcon("[SKIN]/headerIcons/save." + IMG_TYPE);
    public static HeaderIcon SETTINGS = new HeaderIcon("[SKIN]/headerIcons/settings." + IMG_TYPE);
    public static HeaderIcon TRANSFER = new HeaderIcon("[SKIN]/headerIcons/transfer." + IMG_TYPE);
    public static HeaderIcon TRASH = new HeaderIcon("[SKIN]/headerIcons/trash." + IMG_TYPE);
    public static HeaderIcon ZOOM = new HeaderIcon("[SKIN]/headerIcons/zoom." + IMG_TYPE);

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
