/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
 * Form encodying types - these translate to Form ENCTYPE parameters.
 */

public enum Encoding implements ValueEnum {
    /**
     * normal form encoding ("application/x-www-form-urlencoded")
     */
    NORMAL("normal"),
    /**
     * form encoding for forms with INPUT file elements, that is, forms                              that upload files
     * ("multipart/form-data")
     */
    MULTIPART("multipart");
    private String value;

    Encoding(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

