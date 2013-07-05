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
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.bean.types.JsoWrapperValueType;
import java.util.Map;

public abstract class CanvasBaseValueType<ValueType extends Canvas> extends JsoWrapperValueType<ValueType> {
    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof String) {
            return Convertability.SUPPORTED;
        }

        return super.convertabilityFrom(value);
    }

    @Override
    public String getScClassName () {
        // Ideally, it would be nice if subclasses could return their
        // particular scClassName. However, it's not easy to figure out the
        // scClassName programmatically until we instantiante the SmartGWT
        // class, since it's returned from an instance method.
        return "Canvas";
    }

    private native JavaScriptObject getJSCanvas (String id) /*-{
        return $wnd.isc.Canvas.getById(id);
    }-*/;

    @Override
    public ValueType convertFrom (Object value) {
        if (value instanceof String) {
            // We could just call Canvas.getById(value), but we'd have to
            // cast the result to the ValueType, and that wouldn't work for
            // Canvas subclasses. So instead, we get the JavaScriptObject
            // for the ID, and then recursively convert that, since we do
            // know how to convert JavaScriptObjects.
            return super.convertFrom(getJSCanvas((String) value));
        } else {            
            return super.convertFrom(value);
        }
    }
}
