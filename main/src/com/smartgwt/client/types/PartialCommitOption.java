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
 * Action to take if a user attempts to save the dataset produced by a {@link com.smartgwt.client.widgets.BatchUploader}
 * whilst it still contains errors.
 */
public enum PartialCommitOption implements ValueEnum {
    /**
     * Silently allow the partial commit to proceed (note that this will result in the user losing those records that contain
     * errors)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "allow".
     */
    ALLOW("allow"),
    /**
     * Pop up a message window showing the {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommitError
     * BatchUploader.partialCommitError} and prevent the partial commit
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "prevent".
     */
    PREVENT("prevent"),
    /**
     * Pop up a confirmation window with the {@link com.smartgwt.client.widgets.BatchUploader#getPartialCommitPrompt
     * BatchUploader.partialCommitPrompt} and allow the user to choose whether or not to proceed
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "prompt".
     */
    PROMPT("prompt"),
    /**
     * Commit any records that are error-free and remove them from the grid. If any records had errors, leave them in the grid
     * and leave the grid visible. If no records had errors, run normal cleanup as we would  for "allow". This option allows
     * the user to fix errors iteratively, rather than having to fix everything upfront before committing
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "retain".
     */
    RETAIN("retain");
    private String value;

    PartialCommitOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
