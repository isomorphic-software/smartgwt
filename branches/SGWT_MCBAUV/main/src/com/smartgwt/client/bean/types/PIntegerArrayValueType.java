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

public class PIntegerArrayValueType extends ArrayValueType<int[]> {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(int[].class) == null) {
            BeanValueType.registerBeanValueType(new PIntegerArrayValueType());
        }
    }

    private int[] emptyArray = new int[0];

    @Override
    protected Class getValueType () {
        return int[].class;
    }

    @Override
    protected int[] convertFrom (Object[] array) {
        int[] result = new int[array.length];
        BeanValueType<Integer> componentType = (BeanValueType<Integer>) getBeanValueType(int.class);
        for (int x = 0; x < array.length; x++) {
            result[x] = componentType.convertFrom(array[x]).intValue();
        }
        return result;
    }

    @Override
    protected int[] convertFrom (boolean[] array) {
        int[] result = new int[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = array[x] ? 1 : 0;
        }
        return result;
    }

    @Override
    protected int[] convertFrom (double[] array) {
        int[] result = new int[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (int) array[x];
        }
        return result;
    }

    @Override
    protected int[] convertFrom (float[] array) {
        int[] result = new int[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (int) array[x];
        }
        return result;
    }
    
    @Override
    protected int[] convertFrom (int[] array) {
        // This one's easy ...
        return array;
    }
    
    @Override
    protected int[] convertFrom (long[] array) {
        int[] result = new int[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (int) array[x];
        }
        return result;
    }
}
