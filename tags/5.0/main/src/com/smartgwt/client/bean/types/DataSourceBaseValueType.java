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

package com.smartgwt.client.bean.types;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.bean.BeanValueType.Convertability;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.bean.types.JsoWrapperValueType;
import java.util.Map;

// This value type is for DataSources and subclasses, which can be converted
// from Strings (where the String is expected to be the ID of the DataSource).
public abstract class DataSourceBaseValueType<ValueType extends DataSource> extends JsoWrapperValueType<ValueType> {
    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof String) {
            return Convertability.SUPPORTED;
        }

        return super.convertabilityFrom(value);
    }

    @Override
    public String getScClassName () {
        // JavaScriptObjects must descend from DataSource to be wrapped
        return "DataSource";
    }

    private native JavaScriptObject getJSDataSource (String id) /*-{
        return $wnd.isc.DataSource.get(id);
    }-*/;

    @Override
    public ValueType convertFrom (Object value) {
        if (value instanceof String) {
            // We could just call DataSource.get(value), and that would work
            // fine for methods that literally take a DataSource. However, if
            // there ever was a method that took a subclass of DataSource
            // (which there won't be in SmartGWT itself, but could conceivably
            // be in client code), then we wouldn't return the right subclass.
            // So, we get the JavaScript datasource, and then recursively
            // convert that ... since we do know how to produce the correct
            // subclass given a JavaScriptObject.
            return super.convertFrom(getJSDataSource((String) value));
        } else {            
            return super.convertFrom(value);
        }
    }
}
