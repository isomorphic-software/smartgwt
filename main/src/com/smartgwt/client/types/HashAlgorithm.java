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
 * Algorithms to use when hashing field values (see {@link com.smartgwt.client.docs.serverds.DataSourceField#storeWithHash
 * DataSourceField.storeWithHash})
 */
public enum HashAlgorithm implements ValueEnum {
    /**
     * Message Digest algorithm 5
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "MD5".
     */
    MD5("MD5"),
    /**
     * Secure Hashing Algorithm (SHA-1)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "SHA".
     */
    SHA("SHA");
    private String value;

    HashAlgorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
