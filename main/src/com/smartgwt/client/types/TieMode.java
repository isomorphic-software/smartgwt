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
 * what to do if there is more than one possible childrenProperty when using scanMode "branch" or "level" "node": continue,
 * but pick childrenProperty on a per-node basis (will detect             mixed)  "highest": continue, picking the
 * childrenProperty that occurred most as the single            choice "stop": if there's a tie, stop at this level (assume
 * no further children)
 */
public enum TieMode implements ValueEnum {
    /**
     * continue, but pick childrenProperty on a per-node basis (will detect mixed)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "node".
     */
    NODE("node"),
    /**
     * continue, picking the childrenProperty that occurred most as the single choice
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "highest".
     */
    HIGHEST("highest"),
    /**
     * if there's a tie, stop at this level (assume no further children)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "stop".
     */
    STOP("stop");
    private String value;

    TieMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
