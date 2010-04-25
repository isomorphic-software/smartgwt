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

/**
 * Simple button subclass of StretchImgButton with appearance appropriate for a ToolStrip button.
 * Can be used to create an icon-only button, and icon with text, or a text only button by setting the
 * icon and title attibutes as required.
 *
 * @see ToolStrip#addButton(ToolStripButton)
 */
public class ToolStripButton extends StretchImgButton {

    public static ToolStripButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ToolStripButton) obj;
        } else {
            return new ToolStripButton(jsObj);
        }
    }

    public ToolStripButton(){
        scClassName = "ToolStripButton";
    }

    public ToolStripButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ToolStripButton.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
}
