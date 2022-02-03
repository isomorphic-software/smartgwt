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
 * Policy for how {@link com.smartgwt.client.util.tour.TourStep#getInputValidation inputValidation} is performed for 
 * {@link com.smartgwt.client.util.tour.TourStep#getActionType actionType}:"change". When users enter incorrect values,
 * they are informed via the {@link com.smartgwt.client.widgets.notify.Notify} system, and the specific message displayed
 * is controlled by {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyMessage
 * inputValidationNotifyMessage}. <P> The notification can be disabled for the step by setting {@link
 * com.smartgwt.client.util.tour.TourStep#getShowInputValidationMessage TourStep.showInputValidationMessage} to
 * <code>false</code>.
 */
public enum TourInputValidationMode implements ValueEnum {
    /**
     * When there is a brief pause in typing, notify the user that they have typed something wrong. The pause delay is
     * controlled by {@link com.smartgwt.client.util.tour.TourStep#getInputValidationNotifyDelay inputValidationNotifyDelay}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notify".
     */
    NOTIFY("notify"),
    /**
     * Prevent the user from typing any characters that don't match the {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue}, and tell them immediately when they have typed
     * something wrong.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "strict".
     */
    STRICT("strict"),
    /**
     * text entry is only validated on field exit or click on {@link com.smartgwt.client.util.tour.TourStep#getAfterInputTarget
     * afterInputTarget}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "onExit".
     */
    ONEXIT("onExit");
    private String value;

    TourInputValidationMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
