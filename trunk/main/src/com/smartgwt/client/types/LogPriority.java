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
 * Priority levels for log messages
 */
public enum LogPriority implements ValueEnum {
    /**
     * unrecoverable error
     */
    FATAL("fatal"),
    /**
     * error, may be recoverable
     */
    ERROR("error"),
    /**
     * apparent problem, misused API, partial result
     */
    WARN("warn"),
    /**
     * significant events in normal operation
     */
    INFO("info"),
    /**
     * diagnostics for developers
     */
    DEBUG("debug");

    private String value;

    LogPriority(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
