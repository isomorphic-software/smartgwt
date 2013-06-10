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
import com.smartgwt.client.bean.types.OtherValueType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.JSOHelper;
import java.util.Map;

// This class deals with ValueTypes which wrap an underlying JavaScriptObject
// which can be used to construct the ValueType. Essentially, that means
// BaseWidget, BaseClass, DataClass, JsObject, RefDataClass and their
// descendants.
//
// The generator tries to keep some track of which JavaScriptObjects can be
// used to construct the ValueType -- for instance, BaseWidgets can only be
// constructed from SmartClient Canvas objects. But we can't get at the
// scClassName (easily) until we actually construct the object, so we aren't
// super-precise -- we could let through some illegal states.
//
// Note that if the ValueType literally takes a JavaScriptObject as a
// parameter, then we would use JsoValueType instead.
public abstract class JsoWrapperValueType<ValueType> extends BeanValueType<ValueType> {
    @Override
    public Convertability convertabilityFrom (Object value) {
        // If it is a JavaScriptObject, then check whether we can wrap it
        if (value instanceof JavaScriptObject) {
            if (canWrapJavaScriptObject((JavaScriptObject) value)) {
                return Convertability.SUPPORTED;
            }
        }

        // If it is a Map, then it may have arrived as a POJO and been turned
        // into a Map. In that case, we could wrap it if we aren't looking for
        // a SmartClient instance. In principle, I suppose we can turn anything
        // into a JavaScriptObject and then wrap it ... will need to look at
        // the methods that take JavaScriptObjects and see what they tend to
        // really be expecting.
        if (value instanceof Map) {
            if (getScClassName() == null) return Convertability.SUPPORTED;
        }

        if (value == null) return Convertability.SUPPORTED;
        if (value.getClass() == getValueType()) return Convertability.EXACT;
        if (isAssignableFrom(value)) return Convertability.PREFERRED;
        
        return super.convertabilityFrom(value);
    }

    // Tests the scClassName to see whether the object can be wrapped by the
    // constructor.
    protected boolean canWrapJavaScriptObject (JavaScriptObject value) {
        String scClassName = getScClassName();
        if (scClassName == null) {
            // If null, we take it that the JavaScriptObject need not be any
            // particular class, or that it needs to be tested in another way
            return true;
        } else {
            return isA(value, scClassName);
        }
    }

    // If the ValueType should only wrap a certain SmartClient class (or
    // subclases thereof), then the generated subclass should implement
    // getScClassName.  Returning null indicates that the SmartClient class
    // doesn't matter.
    protected String getScClassName () {
        return null;
    }

    // Generated subclasses must implement in order to return a new instance
    // constructed from the JavaScriptObject value
    protected abstract ValueType newInstance (JavaScriptObject value);

    @Override
    @SuppressWarnings("unchecked")
    public ValueType convertFrom (Object value) {
        if (isAssignableFrom(value)) {
            // The cast should be safe, since isAssignableFrom is the check
            return (ValueType) value;
        } else if (value instanceof JavaScriptObject) {
            if (canWrapJavaScriptObject((JavaScriptObject) value)) {
                Object existingRef = JSOHelper.getAttributeAsObject((JavaScriptObject) value, SC.REF);
                if (existingRef != null) {
                    // If there is an existing __ref, we check whether it is assignable to
                    // our ValueType ... if so, we just return it ... otherwise, we fall
                    // through to creating a new ValueType instance.
                    if (isAssignableFrom(existingRef)) return (ValueType) existingRef;
                }

                return newInstance((JavaScriptObject) value);
            } else {
                throw new IllegalArgumentException("Could not wrap JavaScriptObject");
            }
        } else if (value instanceof Map && getScClassName() == null) {
            // In theory, we can turn anything into a JavaScriptObject and then
            // wrap it. But the value type is probably expecting a particular
            // kind of JavaScriptObject ... we'll probably need to work on this
            // some more.
            return convertFrom(convertToJavaScriptObject(value));
        } else {
            return super.convertFrom(value);
        }
        // We could consider a conversion routine for strings ... for instance,
        // checking whether a string is the ID of an existing SmartClient instance,
        // and then wrapping that    
    }
}
