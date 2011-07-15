/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
public class KeyPressEvent extends BrowserEvent<KeyPressHandler>  implements Cancellable {
    private boolean cancel = false;

    /**
     * Handler type.
     */
    private static Type<KeyPressHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasKeyPressHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            KeyPressEvent event = new KeyPressEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<KeyPressHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<KeyPressHandler>();
        }
        return TYPE;
    }


    @Override
    protected void dispatch(KeyPressHandler handler) {
        handler.onKeyPress(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<KeyPressHandler> getAssociatedType() {
        return TYPE;
    }

    public KeyPressEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }


    /**
     * Call this method to suppress native behavior in response to the keyPress, and prevent                    this event from bubbling
     * to this widget's parent, or true or undefined to bubble.
     */
    public void cancel() {
        cancel = true;
    }

    /**
     * @return true if cancelled
     */
    public boolean isCancelled() {
        return cancel;
    }


    /**
     * Return the name of the key for the event passed in. Note that this is only set reliably for keyboard events.
     * <pre>
     * Strings to identify the various keys on the keyboard.
     * <p/>
     * For alpha keys, the single (uppercase) character value is used, such as "Q"
     * For Numeric keys, the number is used as in a single character string, like "1"
     * Function keys are identified as "f1" - "f12"
     * Non alpha-numeric character keys (such as the key for "[" / "{") are identified by their unmodified character value (the value obtained by hitting the key without holding shift down), by default - exceptions are listed below.
     * Additional key names:
     * - Space
     * - Tab
     * - Enter
     * - Escape
     * - Backspace
     * - Insert
     * - Delete
     * - Arrow_Up
     * - Arrow_Down
     * - Arrow_Left
     * - Arrow_Right
     * - Home
     * - End
     * - Page_Up
     * - Page_Down
     * - Shift
     * - Ctrl
     * - Alt
     * [Note: Some keys may not be available for capture on every platform]
     * </pre>
     *
     * @return the key name
     * @see com.smartgwt.client.types.KeyNames
     */
    public String getKeyName() {
        return com.smartgwt.client.util.EventHandler.getKey();
    }    


}
