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

/**
 * Class that encapsulates the bean property name and its associated type information.
 */
public class Property {
    private String name;
    private Class type;

    /**
     * Constructor
     *
     * @param name the property name
     * @param type the property type
     */
    public Property(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Return the property name
     *
     * @return the property name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the property name
     *
     * @param name the property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the property class type
     *
     * @return the property type
     */
    public Class getType() {
        return type;
    }

    /**
     * Set the property type.
     *
     * @param type the property type
     */
    public void setType(Class type) {
        this.type = type;
    }
}
