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

// This is the BeanValueType for handling arrays of interfaces. We handle them
// separately because isAssignableFrom needs to be generated when dealing with
// arrays of interfaces.
public abstract class InterfaceArrayValueType<ComponentType> 
                extends NonPrimitiveArrayValueType<ComponentType> {

// It seems we don't need any extra methods here. However, it does simplify
// the generation a little bit, so we'll leave it for the moment.
}
