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

// This is the superclass for array value types. We handle interface arrays and
// object arrays differently, because we need to generate classes for interface
// arrays.  Also, primitive arrays are handled distinctly. Note that we can't
// genericize here based on the component type, because that will be primitive
// for the primitive array types.
public abstract class ArrayValueType<ValueType> 
                extends BeanValueType<ValueType> {
    
    @Override
    protected boolean isAssignableFrom (Object value) {
        // The setter will deal with null values of any type
        if (value == null) return true;

        // For arrays, by default, the static method will take care of it.
        return isAssignableFrom(getValueType(), value.getClass());
    }

    protected Class getComponentType () {
        return getValueType().getComponentType();
    }

    protected BeanValueType getComponentValueType () {
        return getBeanValueType(getValueType().getComponentType());
    }

    // Is the value convertable to our component type?
    protected Convertability convertabilityToComponentType (Object value) {
        return convertabilityFrom(getComponentType(), value);
    }

    // For an array value, how well can its members be converted to our
    // component type? We return the weakest link ... that is, the result
    // for the value that is least converable.
    protected Convertability leastConvertabilityToComponentType (Object[] array) {
        Convertability result = Convertability.EXACT;
        BeanValueType componentValueType = getBeanValueType(getComponentType());

        for (Object value : array) {
            Convertability convertability = componentValueType.convertabilityFrom(value);
            if (convertability.ordinal() < result.ordinal()) {
                result = convertability;
            }
        }

        return result;
    }

    protected Convertability convertabilityFromPrimitiveArray (Object primitiveArray) {
        // For primitive arrays, we only need to test one value, since the
        // values necessarily all have exactly the same type (and can't be
        // null). By calling convertabilityToComponentType, we'll autobox the
        // primitive type.  But we do need to repeat this for each primitive
        // type, sadly.
        if (primitiveArray instanceof boolean[]) {
            boolean[] array = (boolean[]) primitiveArray;
            // If it's an empty array, we can convert to empty array
            if (array.length == 0) {
                return Convertability.SUPPORTED;
            } else {
                return convertabilityToComponentType(array[0]);
            }
        } else if (primitiveArray instanceof float[]) {
            float[] array = (float[]) primitiveArray;
            if (array.length == 0) {
                return Convertability.SUPPORTED;
            } else {
                return convertabilityToComponentType(array[0]);
            }
        } else if (primitiveArray instanceof double[]) {
            double[] array = (double[]) primitiveArray;
            if (array.length == 0) {
                return Convertability.SUPPORTED;
            } else {
                return convertabilityToComponentType(array[0]);
            }
        } else if (primitiveArray instanceof int[]) {
            int[] array = (int[]) primitiveArray;
            if (array.length == 0) {
                return Convertability.SUPPORTED;
            } else {
                return convertabilityToComponentType(array[0]);
            }
        } else if (primitiveArray instanceof long[]) {
            long[] array = (long[]) primitiveArray;
            if (array.length == 0) {
                return Convertability.SUPPORTED;
            } else {
                return convertabilityToComponentType(array[0]);
            }
        } else {
            throw conversionException(primitiveArray);
        }
    }

    @Override
    public Convertability convertabilityFrom (Object value) {
        // If it's null, then we can create an empty array
        if (value == null) return Convertability.SUPPORTED;
        
        // Return EXACT if the value's class is identical to ours
        if (value.getClass() == getValueType()) return Convertability.EXACT;

        // Check if it's a covariant array that can just be assigned
        if (isAssignableFrom(value)) return Convertability.PREFERRED;

        if (value.getClass().isArray()) {
            if (value instanceof Object[]) {
                // If we get here, it's an array, but not covariant. But, the values
                // may still be convertable to the desired array type. For instance,
                // when we're coming from the SmartClient side, all array values
                // will be converted to Object[]. Yet, they may really be convertable 
                // to the array type that we want.
                return leastConvertabilityToComponentType((Object[]) value);
            } else {
                // If we get here, there we must have an array of primitives.
                // In that case, we need to check for each kind individually.
                return convertabilityFromPrimitiveArray(value);
            }
        } else {
            // If the incoming value is not an array, then we can always turn
            // it into a single-valued array, so long as it's assignable to our
            // component type. So, check that.
            Convertability convertability = convertabilityToComponentType(value);
            if (convertability == Convertability.EXACT) {
                // Downgrade EXACT to PREFERRED, since it's not really EXACT
                return Convertability.PREFERRED;
            } else {
                return convertability;
            }
        }
    }

    // Subclasses must implement
    protected abstract ValueType convertFrom (Object[] array);
    
    // By default, we just throw an exception
    protected ValueType convertFrom (boolean[] array) {
        throw conversionException(array);
    }

    protected ValueType convertFrom (double[] array) {
        throw conversionException(array);
    }

    protected ValueType convertFrom (float[] array) {
        throw conversionException(array);
    }

    protected ValueType convertFrom (int[] array) {
        throw conversionException(array);
    }

    protected ValueType convertFrom (long[] array) {
        throw conversionException(array);
    }

    protected ValueType convertFromPrimitiveArray (Object array) {
        if (array instanceof boolean[]) {
            return convertFrom((boolean []) array);
        } else if (array instanceof double[]) { 
            return convertFrom((double []) array);
        } else if (array instanceof float[]) { 
            return convertFrom((float []) array);
        } else if (array instanceof int[]) { 
            return convertFrom((int []) array);
        } else if (array instanceof long[]) { 
            return convertFrom((long []) array);
        } else {
            throw conversionException(array);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ValueType convertFrom (Object value) {
        if (value == null) {
            return nullValue();
        } else if (isAssignableFrom(value)) {
            // The cast should be safe, since isAssignableFrom is the check
            return (ValueType) value;
        } else if (value.getClass().isArray()) {
            if (value instanceof Object[]) {
                return convertFrom((Object[]) value);
            } else {
                return convertFromPrimitiveArray(value);
            }
        } else {
            // If it's not an array, then we can turn it into one. We have
            // to be able to handle Object[] anyway, so we just construct
            // one and recurse. (Note that we can't just return the Object[],
            // because we have to construct an array with the correct type).
            if (convertabilityToComponentType(value) != Convertability.UNSUPPORTED) {
                return convertFrom(new Object[] {value});
            } else {
                throw conversionException(value);
            }
        }
    }
}
