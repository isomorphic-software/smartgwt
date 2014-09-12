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

package com.smartgwt.client.bean;

import com.smartgwt.client.bean.BeanProperty;
import com.smartgwt.client.bean.BeanMethod;
import com.smartgwt.client.bean.BeanValueType.Convertability;

// This is a subclass of BeanProperty which can be used in cases where there
// are multiple getters or multiple setters.  This is the only case where we
// actually have to choose amongst getters or setters.
public class BeanPropertyMultiple<BeanClass> extends BeanProperty<BeanClass> {

    private BeanMethod<BeanClass, ?>[] getters;
    private BeanMethod<BeanClass, ?>[] setters;

    @SuppressWarnings("unchecked")
    public BeanPropertyMultiple (String name, BeanMethod[] getters, BeanMethod setters[]) {
        super(name);
    
        // We'll check for empty arrays and make them null -- that way, we only need
        // to check for null. We also cast to the generic type, since we can't create
        // generically-typed arrays. (The array creation is generated, so the types
        // will be correct).
        if (getters != null) {
            this.getters = getters.length > 0 ? (BeanMethod<BeanClass, ?>[]) getters : null;
        }
        if (setters != null) {
            this.setters = setters.length > 0 ? (BeanMethod<BeanClass, ?>[]) setters : null;
        }
    }

    @Override
    protected BeanMethod<BeanClass, ?> setterForValue (Object value) {
        final BeanMethod<BeanClass, ?>[] methods = setters;
        if (methods == null) return null;
        if (methods.length == 1) return methods[0];

        BeanMethod<BeanClass, ?> result = null;
        Convertability convertability = Convertability.UNSUPPORTED;

        for (BeanMethod<BeanClass, ?> method : methods) {
            Convertability myConvertability = method.convertabilityFrom(value);
            if ((result == null) || (myConvertability.ordinal() > convertability.ordinal())) {
                result = method;
                convertability = myConvertability;
            }
        }

        return result;
    }

    @Override
    protected BeanMethod<BeanClass, ?> defaultGetter () {
        // The generator will arrange things so that the default getter is the first one
        if (getters == null) {
            return null;
        } else {
            return getters[0];
        }
    }

    // What we're checking for here is whether some methods might be better at
    // returning strings than others. For instance, we would prefer
    // getWidthAsString over getWidth, even though we can convert getWidth to a
    // string.
    @Override
    protected BeanMethod<BeanClass, ?> getterForString () {
        final BeanMethod<BeanClass, ?>[] methods = getters;
        if (methods == null) return null;
        if (methods.length == 1) return methods[0];

        BeanMethod<BeanClass, ?> result = null;
        Convertability convertability = Convertability.UNSUPPORTED;

        for (BeanMethod<BeanClass, ?> method : methods) {
            Convertability myConvertability = method.convertabilityToString();
            if (result == null || myConvertability.ordinal() > convertability.ordinal()) {
                result = method;
                convertability = myConvertability;
            }
        }

        return result;
    }
}
