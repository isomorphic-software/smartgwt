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

public class CanvasUtil {
	private static final CanvasFactory CANVAS_FACTORY = (CanvasFactory) GWT.create(CanvasFactory.class);

	public static Object newInstance(String className) {
		return CANVAS_FACTORY.newInstance(className);
	}

	public static void setProperties(String className, Object bean, Map<String, String> properties) {
		PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
		if (propertyHelper != null) {
			for (Map.Entry<String, String> entry : properties.entrySet()) {
				String property = entry.getKey();
				String value = entry.getValue();
				propertyHelper.setProperty(bean, property, value);
			}
		}
	}

	public static void setProperty(String className, Object bean, String property, String value) {
		PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
		if (propertyHelper != null) {
			propertyHelper.setProperty(bean, property, value);
		}
	}

	public static void setProperties(String className, Object bean, String json) {
		JavaScriptObject properties = JSOHelper.eval(json);
		setProperties(className, bean, properties);
	}

	public static void setProperties(String className, Object bean, JavaScriptObject properties) {
		PropertyHelper propertyHelper = CanvasRegistry.getPropertyHelper(className);
		if (propertyHelper != null) {
			Map map = JSOHelper.convertToMap(properties);
			setProperties(className, bean, map);
		}
	}
}
