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

// For handling arrays of objects (but not interfaces or primitives).  Note
// that it is genericized on the ComponentType, rather than the ValueType
// (which is an array type). This works better, because we can express the
// array type in terms of the ComponetType (i.e. ComponentType[]), but not
// vice-versa (we'd be stuck if all we had was the array type).
public class ObjectArrayValueType<ComponentType> 
       extends NonPrimitiveArrayValueType<ComponentType> {

    public static <T> void registerValueType (T[] emptyArray) { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        //
        // Note that we initialize with the empty array (rather than
        // the usual Class literal). We do need the class literal, but
        // we can get that from the empty array.
        Class klass = emptyArray.getClass();
        if (BeanValueType.getBeanValueType(klass) == null) {
            BeanValueType.registerBeanValueType(new ObjectArrayValueType<T>(emptyArray));
        }
    }

    // Our class object ... e.g. java.lang.Integer[].class or int[].class 
    Class<ComponentType[]> valueType;

    // An empty array of our class type. We use this in
    // List.toArray(emptyArray) in order to convert Object[]'s that contain
    // objects of the desired component type to arrays that are more narrowly
    // typed (as our desired type).  Note that we can't type this as Object[],
    // because that wouldn't cover primitive arrays like int[].
    ComponentType[] emptyArray;

    @SuppressWarnings("unchecked")
    protected ObjectArrayValueType (ComponentType[] emptyArray) {
        // The cast will be safe by definition, but the compiler doesn't seem
        // to think so.
        this.valueType = (Class<ComponentType[]>) emptyArray.getClass();
        this.emptyArray = emptyArray;
    }
    
    @Override
    protected Class<ComponentType[]> getValueType () {
        return valueType;
    }

    @Override
    public ComponentType[] emptyArray () {
        return emptyArray;
    }    
}
