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
 * Options for how values in the import dataset (for example, the CSV file) are transformed during import if the field is a
 * {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} mapped to a  {@link
 * com.smartgwt.client.data.DataSourceField#getDisplayField displayField}
 */
public enum FieldImportStrategy implements ValueEnum {
    /**
     * The import process expects values in the import dataset to be the real underlying key values, and performs no
     * transformation
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "key".
     */
    KEY("key"),
    /**
     * The import process expects values in the import dataset to be display values, and it will transform them to the
     * corresponding underlying keys if found
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "display".
     */
    DISPLAY("display"),
    /**
     * Same as "display", but results in {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#importStrategyFailedErrorMessage validation error} if corresponding
     * underlying keys were not found
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "displayRequired".
     */
    DISPLAYREQUIRED("displayRequired"),
    /**
     * The import process will attempt to discover the best setting to use, based on the values in the first record, and use
     * that setting for every remaining record in the import dataset
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "auto".
     */
    AUTO("auto");
    private String value;

    FieldImportStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
