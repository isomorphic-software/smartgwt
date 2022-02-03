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
 
package com.smartgwt.client.data;

import java.util.Map;

public interface ValidationStatusCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} to evaluate when form validation completes. <p> The available parameters
     * are:
     *
     * @param errorMap null if validation succeeded for all fields, or a Map of field names to the associated errors, for those fields that
     * failed validation.
     */
	public void execute(Map errorMap);
} 
