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
 
/**
 * For DataSources of type "sql", specifies the kind of inheritance to use when a dataSource specifies {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
 */
public enum DSInheritanceMode implements ValueEnum {
    /**
     * Inherit fields by copying them onto the inheriting DataSource's underlying table. When we  import a DataSource with this
     * inheritanceMode, we create actual columns for inherited fields on the table we create. With this inheritanceMode,
     * inherited fields are updatable.
     */
    FULL("full"),
    /**
     * Do not physically inherit fields onto the inheriting DataSource's SQL table. Columns will not be created for inherited
     * fields on import, and all generated SQL operations will exclude inherited fields. However, those fields are still part
     * of the DataSource's schema so you can, for example, write {@link com.smartgwt.client.docs.CustomQuerying custom SQL}
     * that returns values for  the inherited fields, and they will be delivered to the client.
     */
    NONE("none");
    private String value;

    DSInheritanceMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
