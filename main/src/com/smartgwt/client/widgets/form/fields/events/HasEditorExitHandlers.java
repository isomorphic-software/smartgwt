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
 
package com.smartgwt.client.widgets.form.fields.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasEditorExitHandlers extends HasHandlers {
    /**
     * Notification method fired when the user leaves this formItem. Differs from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addBlurHandler FormItem.blur} in that while <code>focus</code> and
     * <code>blur</code> may fire multiple as the user navigates sub elements of an item (such as interacting with a pick
     * list), <code>editorEnter</code> will typically fire once when the user  starts to edit this item as a whole, and
     * <code>editorExit</code> fires once when the  user moves onto a different item or component
     *
     * @param handler the editorExit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addEditorExitHandler(EditorExitHandler handler);
}
