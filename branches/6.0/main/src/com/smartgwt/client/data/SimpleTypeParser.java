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

package com.smartgwt.client.data;

import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.widgets.DataBoundComponent;

/**
 * Parser for edited values of a {@link com.smartgwt.client.data.SimpleType}.
 *
 * @see com.smartgwt.client.data.SimpleType#setEditParser(SimpleTypeParser)
 */
public interface SimpleTypeParser {
    
    /**
     * The callback for parsing.
     *
     * @param value the edited value
     * @param field  field descriptor from the component calling the parser depending on the calling component, if applicable.
     * @param component component calling this formatter, if applicable
     * @param record the record instance, if applicable
     *
     * @return the data value derived from the edited string value
     */
    Object parseInput(String value, DataClass field, DataBoundComponent component, Record record);
}

