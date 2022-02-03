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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasFilterEditorSubmitHandlers extends HasHandlers {
    /**
     * Optional notification fired when the user performs a filter using the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor Filter Editor}.  Useful for applying additional
     * criteria not 
     *  available in the filterEditor.  Note that it is often easiest to do this with the 
     *  {@link com.smartgwt.client.widgets.form.SearchForm} attribute, which requires no code.
     *  <P>
     *  May fire as criteria values are being edited if 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterByCell filterByCell} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress filterOnKeypress} is true, otherwise will fire when the
     *  user clicks the filter button or presses the Enter key while focus is in the Filter Editor.
     *  <p>
     *  Use event.cancel()
     *  
     *  to cancel the default behavior - you <b>must</b> cancel the default behavior if your
     * code is going to call {@link com.smartgwt.client.widgets.grid.ListGrid#filterData filterData()}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCriteria setCriteria()} or any other API that
     *  affects the criteria applied to the grid.
     *  <P>
     *  The <code>criteria</code> parameter contains the current criteria applied to the
     *  grid including edits the user has just made using the Filter Editor and those applied
     *  with the {@link com.smartgwt.client.widgets.grid.ListGrid#showFilterWindow advanced filtering dialog}. A call to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterEditorCriteria getFilterEditorCriteria()} does not include the
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterWindowCriteria advanced filtering criteria}.
     *  <P>
     *  If you wish to access the <code>criteria</code> applied to the grid without picking
     * up any edits to the Filter Editor, use {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria getCriteria()}
     * instead.
     *  <P>
     *  Developers may wish to perform a filter using the Filter Editor values from code
     *  running outside the standard filterEditorSubmit flow.  For example, if you wanted a
     *  confirmation dialog to be shown before filtering was performed, you would cancel the
     *  default behavior as described above, but then need to replicate the default behavior
     *  once the user confirms that they want to proceed.  To replicate the default behavior, 
     *  just call:
     *  <pre>
     *   grid.filterData(grid.getFilterEditorCriteria());
     *  </pre>
     * or, to ensure the specified {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle
     * autoFetchTextMatchStyle} is picked up
     *  
     *  
     *  <pre>
     *   DSRequest request = new DSRequest();
     *   request.setTextMatchStyle(grid.getAutoFetchTextMatchStyle());
     *   grid.filterData(grid.getFilterEditorCriteria(), null,
     *        request);
     *  </pre>
     *  
     * 
     * 
     *
     * @param handler the filterEditorSubmit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addFilterEditorSubmitHandler(FilterEditorSubmitHandler handler);
}
