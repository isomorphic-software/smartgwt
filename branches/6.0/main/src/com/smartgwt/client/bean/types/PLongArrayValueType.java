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
import com.smartgwt.client.bean.types.ArrayValueType;
import com.smartgwt.client.bean.BeanValueType;

public class PLongArrayValueType extends ArrayValueType<long[]> {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(long[].class) == null) {
            BeanValueType.registerBeanValueType(new PLongArrayValueType());
        }
    }

    private long[] emptyArray = new long[0];

    @Override
    protected Class getValueType () {
        return long[].class;
    }
 
    @Override
    protected long[] convertFrom (Object[] array) {
        long[] result = new long[array.length];
        BeanValueType<Long> componentType = (BeanValueType<Long>) getBeanValueType(long.class);
        for (int x = 0; x < array.length; x++) {
            result[x] = componentType.convertFrom(array[x]).longValue();
        }
        return result;
    }

    @Override
    protected long[] convertFrom (boolean[] array) {
        long[] result = new long[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = array[x] ? 1 : 0;
        }
        return result;
    }

    @Override
    protected long[] convertFrom (double[] array) {
        long[] result = new long[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (long) array[x];
        }
        return result;
    }

    @Override
    protected long[] convertFrom (float[] array) {
        long[] result = new long[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (long) array[x];
        }
        return result;
    }
    
    @Override
    protected long[] convertFrom (int[] array) {
        long[] result = new long[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (long) array[x];
        }
        return result;
    }
    
    @Override
    protected long[] convertFrom (long[] array) {
        // This one's easy ...
        return array;
    }
}
