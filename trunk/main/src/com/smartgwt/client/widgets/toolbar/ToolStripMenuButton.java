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

package com.smartgwt.client.widgets.toolbar;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.StretchImgButton;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.Menu;

/**
 * Simple Menu Button subclass of {@link com.smartgwt.client.widgets.menu.IMenuButton} with an appearance appropriate for a ToolStrip menu button.
 * Can be used to create an icon-only menu button, and icon with text, or a text only button by setting the
 * icon and title attributes as required.
 *
 * @see com.smartgwt.client.widgets.toolbar.ToolStrip#addMenuButton(ToolStripMenuButton)
 */
public class ToolStripMenuButton extends IMenuButton {

    public static ToolStripMenuButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ToolStripMenuButton) obj;
        } else {
            return new ToolStripMenuButton(jsObj);
        }
    }

    public ToolStripMenuButton(){
        scClassName = "ToolStripMenuButton";
    }
    
    public ToolStripMenuButton(String title) {
        setTitle(title);
        scClassName = "ToolStripMenuButton";
    }

    public ToolStripMenuButton(String title, Menu menu) {
        setTitle(title);
		setMenu(menu);
        scClassName = "ToolStripMenuButton";
    }

    public ToolStripMenuButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ToolStripMenuButton.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
}
