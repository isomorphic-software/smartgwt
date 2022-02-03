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
/* sgwtgen */
 
package com.smartgwt.client.widgets.form.fields.events;

import com.google.gwt.event.shared.EventHandler;

public interface ChangedHandler extends EventHandler {
    /**
     * Called when a FormItem's value has been changed as the result of user interaction.  This method fires after the newly
     * specified value has been stored. <p> Change/Changed notifications vs <i>"...When"</i> rules: the <code>change</code> and
     * <code>changed</code> events only fire when an end user modifies a field value.  If you are trying to dynamically control
     * the visibility or enabled state of other  components in response to these events, consider instead using properties 
     * such as {@link com.smartgwt.client.widgets.Canvas#getVisibleWhen Canvas.visibleWhen}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen item.readOnlyWhen}, {@link
     * com.smartgwt.client.widgets.Canvas#getEnableWhen Canvas.enableWhen} on the target component. (Similar properties are 
     * available on {@link com.smartgwt.client.widgets.form.fields.FormItem}, {@link com.smartgwt.client.widgets.Canvas},
     * {@link com.smartgwt.client.widgets.menu.MenuItem} and other components).
     *
     * @param event the event
     */
    void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event);
}
