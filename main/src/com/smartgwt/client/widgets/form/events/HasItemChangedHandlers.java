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
 
package com.smartgwt.client.widgets.form.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasItemChangedHandlers extends HasHandlers {
    /**
     * Handler fired when there is a changed() event fired on a FormItem within this form.&#010 <P>&#010 Fires after the change() handler on the FormItem itself, and only if the item did not&#010 cancel the change event and chooses to allow it to propagate to the form as a whole. &#010&#010
     */
    HandlerRegistration addItemChangedHandler(ItemChangedHandler handler);
}
