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
 * Visual Builder's ApplicationMode determines the behavior of the visual components in the  application you are building
 */
public enum ApplicationMode implements ValueEnum {
    /**
     * Components behave as they would in the running application; clicking a component in the visual design window will cause
     * the response an  end-user would expect
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "live".
     */
    LIVE("live"),
    /**
     * Components have special design-time behavior layered on top of ordinary run-time behavior; clicking a component in the
     * visual design  window will cause the response an application builder would expect,  if any such special behavior is
     * defined for that component
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "edit".
     */
    EDIT("edit");
    private String value;

    ApplicationMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
