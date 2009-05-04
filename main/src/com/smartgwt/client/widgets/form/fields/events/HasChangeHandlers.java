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
 
package com.smartgwt.client.widgets.form.fields.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasChangeHandlers extends HasHandlers {
    /**
     * Called when a FormItem's value is about to change as the result of user interaction.  This&#010 method fires after the user performed an action that would change the value of this field,&#010 but before the element itself is changed.  &#010 <P>&#010 Returning false cancels the change.  Note that if what you want to do is&#010 <b>transform</b> the user's input, for example, automatically change separator&#010 characters to a standard separator character, you should implement&#010 {@link com.smartgwt.client.widgets.form.fields.FormItem#transformInput} rather than using a combination of&#010 change() and setValue() to accomplish the same thing.  Returning false from&#010 <code>change</code> is intended for rejecting input entirely, such as typing invalid&#010 characters.&#010 <p>&#010 Note that if you ask the form for the current value in this handler, you will get the old&#010 value because the change has not yet been commited.  The new value is available as a&#010 parameter to this method.&#010&#010
     *
     * @param handler the change handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addChangeHandler(ChangeHandler handler);
}
