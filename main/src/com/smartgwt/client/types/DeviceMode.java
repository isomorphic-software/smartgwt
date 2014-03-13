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
 * Possible layout modes for UI components that are sensitive to the device type being used (a.k.a. "responsive design"). 
 * See for example {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode}.
 */
public enum DeviceMode implements ValueEnum {
    /**
     * mode intended for handset-size devices (phones). Generally only one UI panel will be shown at a time.
     */
    HANDSET("handset"),
    /**
     * mode intended for tablet-size devices. Generally, up to two panels are shown side by side in "landscape" {@link
     * com.smartgwt.client.types.PageOrientation}, and only one panel is shown in "portrait" orientation.
     */
    TABLET("tablet"),
    /**
     * mode intended for desktop browsers. Three or more panels may be shown simultaneously.
     */
    DESKTOP("desktop");
    private String value;

    DeviceMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
