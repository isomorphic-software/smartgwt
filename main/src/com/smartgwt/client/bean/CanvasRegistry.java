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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registry class that maps a class type to a PropertyHelper for the associated class that provides reflection like
 * capabilities for GWT.
 */
public class CanvasRegistry {
    private static Map<String, PropertyHelper> registryMap = new HashMap<String, PropertyHelper>();

    /**
     * Registers a class type with its associated {@link PropertyHelper}.
     *
     * @param clazz the class
     * @param propertyHelper the property helper
     */
    public static void register(Class clazz, PropertyHelper propertyHelper) {
        registryMap.put(clazz.getName(), propertyHelper);
    }

    /**
     * Return the property helper associated with a class.
     *
     * @param clazz the class
     * @return the property helper
     */
    public static PropertyHelper getPropertyHelper(Class clazz) {
        return registryMap.get(clazz.getName());
    }

    /**
     * Return the property helper associated with a class.
     *
     * @param fullyQualifiedClassName the class name
     * @return the property helper
     */
    public static PropertyHelper getPropertyHelper(String fullyQualifiedClassName) {
        return registryMap.get(fullyQualifiedClassName);
    }

    /**
     * Return a set of classes that have been registered.
     *
     * @return the set of registered class names
     */
    public static Set<String> getRegisteredClasses() {
        return registryMap.keySet();
    }
}

