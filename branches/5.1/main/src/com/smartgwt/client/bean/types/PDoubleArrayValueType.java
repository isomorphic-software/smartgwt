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

public class PDoubleArrayValueType extends ArrayValueType<double[]> {
    public static void registerValueType () { 
        // We check first to see if it's already registered, to avoid
        // constructing the singleton over and over again. This will
        // be called multiple times as various BeanFactories initialize
        // themselves.
        if (BeanValueType.getBeanValueType(double[].class) == null) {
            BeanValueType.registerBeanValueType(new PDoubleArrayValueType());
        }
    }

    private double[] emptyArray = new double[0];

    @Override
    protected Class getValueType () {
        return double[].class;
    }

    @Override
    protected double[] convertFrom (Object[] array) {
        double[] result = new double[array.length];
        BeanValueType<Double> componentType = (BeanValueType<Double>) getComponentValueType();
        for (int x = 0; x < array.length; x++) {
            result[x] = componentType.convertFrom(array[x]);
        }
        return result;
    }

    @Override
    protected double[] convertFrom (boolean[] array) {
        double[] result = new double[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = array[x] ? 1 : 0;
        }
        return result;
    }

    @Override
    protected double[] convertFrom (double[] array) {
        // This one's easy ...
        return array;
    }

    @Override
    protected double[] convertFrom (float[] array) {
        double[] result = new double[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (double) array[x];
        }
        return result;
    }
    
    @Override
    protected double[] convertFrom (int[] array) {
        double[] result = new double[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (double) array[x];
        }
        return result;
    }
    
    @Override
    protected double[] convertFrom (long[] array) {
        double[] result = new double[array.length];
        for (int x = 0; x < array.length; x++) {
            result[x] = (double) array[x];
        }
        return result;
    }
}
