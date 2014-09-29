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

import com.smartgwt.client.bean.BeanValueType;
import com.smartgwt.client.bean.BeanValueType.Convertability;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

// This is the superclass for ObjectArrayValueType and InterfaceArrayValueType.
// Note that it is genericized on the ComponentType, rather than the ValueType
// (which is an array type). This works better, because we can express the
// array type in terms of the ComponetType (i.e. ComponentType[]), but not
// vice-versa (we'd be stuck if all we had was the array type).
public abstract class NonPrimitiveArrayValueType<ComponentType> 
                extends ArrayValueType<ComponentType[]> {
                 
    // Sublasses must return an emptyArray of the correct type
    public abstract ComponentType[] emptyArray ();
    
    // Since we know we're not a primitive array, we can genericize this ...
    // this doesn't really accomplish anything other than letting callers feel
    // type-safe.
    @Override
    @SuppressWarnings("unchecked")
    protected BeanValueType<ComponentType> getComponentValueType () {
        // The cast should be safe, since it's generated code.
        return (BeanValueType<ComponentType>) super.getComponentValueType();
    }

    @Override
    protected ComponentType[] convertFrom (Object[] array) {
        // We'll ultimately rely on List.toArray(emptyArray) to generate the correct
        // array type at run-time. So, we collect the conversions in a List.
        List<ComponentType> convertedList = new ArrayList<ComponentType>(array.length);
        BeanValueType<ComponentType> componentValueType = getComponentValueType();

        for (Object element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }

        return convertedList.toArray(emptyArray());
    }

    // We have to deal with primitive arrays somewhat tediously, as the only
    // way to access them is through types expressed at compile-time.
    @Override
    protected ComponentType[] convertFrom (boolean[] array) {
        List<ComponentType> convertedList = new LinkedList<ComponentType>();
        BeanValueType<ComponentType> componentValueType = getComponentValueType();
        for (boolean element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }
        return convertedList.toArray(emptyArray());
    }
        
    @Override
    protected ComponentType[] convertFrom (double[] array) {
        List<ComponentType> convertedList = new LinkedList<ComponentType>();
        BeanValueType<ComponentType> componentValueType = getComponentValueType();
        for (double element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }
        return convertedList.toArray(emptyArray());
    }
    
    @Override
    protected ComponentType[] convertFrom (float[] array) {
        List<ComponentType> convertedList = new LinkedList<ComponentType>();
        BeanValueType<ComponentType> componentValueType = getComponentValueType();
        for (float element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }
        return convertedList.toArray(emptyArray());
    }
    
    @Override
    protected ComponentType[] convertFrom (int[] array) {
        List<ComponentType> convertedList = new LinkedList<ComponentType>();
        BeanValueType<ComponentType> componentValueType = getComponentValueType();
        for (int element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }
        return convertedList.toArray(emptyArray());
    }
    
    @Override
    protected ComponentType[] convertFrom (long[] array) {
        List<ComponentType> convertedList = new LinkedList<ComponentType>();
        BeanValueType<ComponentType> componentValueType = getComponentValueType();
        for (long element : array) {
            convertedList.add(componentValueType.convertFrom(element));
        }
        return convertedList.toArray(emptyArray());
    }
}
