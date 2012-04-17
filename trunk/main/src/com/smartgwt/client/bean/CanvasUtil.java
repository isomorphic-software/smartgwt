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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.JSOHelper;

import java.util.Map;

/**
 * Utility class for creating new instances of a Canvas by name and also to get and set bean property values.
 */
public class CanvasUtil {
    private static final CanvasFactory CANVAS_FACTORY = (CanvasFactory) GWT.create(CanvasFactory.class);

    /**
     * Return a new instance of the class.
     *
     * @param className the class name
     * @return the class instance, null if the class name is not registered
     */
    public static Object newInstance(String className) {
        return CANVAS_FACTORY.newInstance(className);
    }

    /**
     * Set properties on a bean
     *
     * @param bean       the bean
     * @param properties a map of property name / value pairs
     */
    public static void setProperties(Object bean, Map<String, String> properties) {
        String className = bean.getClass().getName();
        PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
        if (propertyHelper != null) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                String property = entry.getKey();
                String value = entry.getValue();
                propertyHelper.setProperty(bean, property, value);
            }
        }
    }

    /**
     * Set a bean property value.
     *
     * @param bean     the bean
     * @param property the bean property
     * @param value    the property value
     */
    public static void setProperty(Object bean, String property, String value) {
        String className = bean.getClass().getName();
        PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
        if (propertyHelper != null) {
            propertyHelper.setProperty(bean, property, value);
        }
    }

    /**
     * Apply all the json properties to the bean.
     *
     * @param bean the bean
     * @param json the properties as json
     */
    public static void setProperties(Object bean, String json) {
        JavaScriptObject properties = JSOHelper.eval(json);
        setProperties(bean, properties);
    }

    /**
     * Apply all the json properties to the bean.
     *
     * @param bean       the bean
     * @param properties the properties
     */
    public static void setProperties(Object bean, JavaScriptObject properties) {
        String className = bean.getClass().getName();
        PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
        if (propertyHelper != null) {
            Map map = JSOHelper.convertToMap(properties);
            setProperties(bean, map);
        }
    }

    /**
     * Return the property names as a JavaScript array.
     *
     * @param className the class name
     * @return the properties array JSO
     */
    public static JavaScriptObject getProperties(String className) {
        PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
        Property[] properties = propertyHelper.getProperties();
        JavaScriptObject attributes = JSOHelper.createJavaScriptArray();
        for (int i = 0; i < properties.length; i++) {
            Property property = properties[i];
            JSOHelper.setArrayValue(attributes, i, property.getName());
        }
        return attributes;
    }
}
