/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * DOM related helper methods.
 *
 * @author Sanjiv Jivan
 */
public class DOMUtil {

    public static String getID(Widget widget) {
        return getID(widget.getElement());
    }

    public static String getID(Element element) {
        String id = DOM.getElementProperty(element, "id");
        return id == null || id.equals("") ? null : id;

    }


    public static void setID(Widget widget, String id) {
        setID(widget.getElement(), id);
    }

    public static void setID(Element element, String id) {
        DOM.setElementProperty(element, "id", id);
    }

}
