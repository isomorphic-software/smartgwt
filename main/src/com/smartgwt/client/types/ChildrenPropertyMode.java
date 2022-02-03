package com.smartgwt.client.types;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * when heuristically finding a property that appears to contain child objects, the ChildrenPropertyMode determines how to
 * chose the property appears to contain child objects
 */
public enum ChildrenPropertyMode implements ValueEnum {
    /**
     * assume the first object or array value we find is the children property
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "any".
     */
    ANY("any"),
    /**
     * assume the first array we find is the children property, no matter the contents
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "array".
     */
    ARRAY("array"),
    /**
     * assume the first object or array of objects we find is the children property (don't allow arrays that don't have
     * objects)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "object".
     */
    OBJECT("object"),
    /**
     * accept only an array of objects as the children property
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "objectArray".
     */
    OBJECTARRAY("objectArray");
    private String value;

    ChildrenPropertyMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
