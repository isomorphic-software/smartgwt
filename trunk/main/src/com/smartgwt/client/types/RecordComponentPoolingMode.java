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
 
package com.smartgwt.client.types;

/**
 * The method of component-pooling to employ for
 * ${isc.DocUtils.linkForRef('showRecordComponents','recordComponents')}. <P>
 */

public enum RecordComponentPoolingMode implements ValueEnum {

    /**
     * components are cleared when not in the viewport, but stay with a record         until the
     * record is dropped from cache.  Best for guaranteed small datasets.
     */
    DATA("data"),

    /**
     * components are destroyed when the record is not being rendered.  Best         for large
     * datasets where embedded components differ greatly per record.
     */
    VIEWPORT("viewport"),

    /**
     * components are pooled and will be passed to getEmbeddedComponent() with        recordChanged
     * set to true.  Best for large datasets where embedded components        are uniform across
     * different records and can be efficiently reconfigured to work        with a new record
     */
    RECYCLE("recycle");
    private String value;

    RecordComponentPoolingMode(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}

