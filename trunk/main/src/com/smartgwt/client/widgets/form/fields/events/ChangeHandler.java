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
import com.google.gwt.event.shared.EventHandler;

public interface ChangeHandler extends EventHandler {
    /**
     * Called when a FormItem's value is about to change as the result of user interaction.  This method fires after the user
     * performed an action that would change the value of this field, but before the element itself is changed.   <P> Returning
     * false cancels the change.  Note that if what you want to do is <b>transform</b> the user's input, for example,
     * automatically change separator characters to a standard separator character, you should implement {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer transformInput} rather than using a combination of
     * change() and setValue() to accomplish the same thing.  Returning false from <code>change</code> is intended for
     * rejecting input entirely, such as typing invalid characters. <p> Note that if you ask the form for the current value in
     * this handler, you will get the old value because the change has not yet been committed.  The new value is available as a
     * parameter to this method.
     *
     * @param event the event
     */
    void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event);
}
