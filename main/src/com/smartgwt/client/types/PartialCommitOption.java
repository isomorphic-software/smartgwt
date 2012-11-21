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
 * Action to take if a user attempts to save the dataset produced by a {@link com.smartgwt.client.widgets.BatchUploader}
 * whilst it still contains errors.
 */
public enum PartialCommitOption implements ValueEnum {
    /**
     * Silently allow the partial commit to proceed (note that this will result in the user losing those records that contain
     * errors)
     */
    ALLOW("allow"),
    /**
     * Pop up a message window and prevent the partial commit
     */
    PREVENT("prevent"),
    /**
     * Pop up a confirmation window and allow the user to choose whether or not to proceed
     */
    PROMPT("prompt");
    private String value;

    PartialCommitOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
