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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.bean.types.JsoWrapperValueType;
import java.util.Map;

public abstract class CanvasBaseValueType<ValueType extends Canvas> extends JsoWrapperValueType<ValueType> {
    @Override
    public Convertability convertabilityFrom (Object value) {
        if (value instanceof String) {
            return Convertability.SUPPORTED;
        } else if (value instanceof Map) {
            // If we get a Map, it's a POJO that was turned into a Map.
            // If we're supplied a POJO and expect a Canvas, then the POJO
            // is almost certainly a config object. If you contruct
            // a BaseWidget with a config object as the JSO, the constructor
            // does the right thing. So, this should work in all cases
            // (unlike in JsoWrapperValueType, where we don't support
            // plain Maps if there is an expected scClassName).
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
    
    @Override
    protected boolean canWrapJavaScriptObject (JavaScriptObject value) {
        if (JSOHelper.isScClassInstance(value)) {
            // If it is a SmartClient instance, then check it against
            // the expected scClass (as super does)
            return super.canWrapJavaScriptObject(value);
        } else {
            // If it's not a SmartClient instance, then assume that it is a
            // config object. We can convert that, since the BaseWidget
            // constructor which takes JSO's does the right thing.
            return true;
        }
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
        } else if (value instanceof Map) {
            // If we get a Map, it's a POJO that was turned into a Map.
            // If we're supplied a POJO and expect a Canvas, then the POJO
            // is almost certainly a config object. If you contruct
            // a BaseWidget with a config object as the JSO, the constructor
            // does the right thing. So, we just convert the Map back
            // to a JavaScriptObject and convert that.
            return convertFrom(convertToJavaScriptObject(value));
        } else {            
            return super.convertFrom(value);
        }
    }
}
