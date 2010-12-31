/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
 * Default buttons that you can use in your Dialogs.&#010 <P>&#010 On click these call canonical methods that you can
 * override in your Dialog.&#010 <P>&#010 Refer to these buttons via the syntax <code>{@link
 * com.smartgwt.client.widgets.Dialog#OK}</code> when passing them into&#010 {@link
 * com.smartgwt.client.widgets.Dialog#getToolbarButtons toolbarButtons} or into the <code>properties</code> argument of
 * helper&#010 methods such as {@link com.smartgwt.client.util.SC#say}.
 */
public enum DialogButtons implements ValueEnum {
    /**
     * Button object to fire dialog's "okClick()" method on click. Title derived from {@link
     * com.smartgwt.client.widgets.Dialog#OK_BUTTON_TITLE}.
     */
    OK("ok"),
    /**
     * Button object to fire dialog's "applyClick()" method on click. Title derived from {@link
     * com.smartgwt.client.widgets.Dialog#APPLY_BUTTON_TITLE}.
     */
    APPLY("apply"),
    /**
     * Button object to fire dialog's "yesClick()" method on click. Title derived from {@link
     * com.smartgwt.client.widgets.Dialog#YES_BUTTON_TITLE}.
     */
    YES("yes"),
    /**
     * Button object to fire dialog's "noClick()" method on click. Title derived from {@link
     * com.smartgwt.client.widgets.Dialog#NO_BUTTON_TITLE}.
     */
    NO("no"),
    /**
     * Button object to fire dialog's "cancelClick()" method on click. Title derived from {@link
     * com.smartgwt.client.widgets.Dialog#CANCEL_BUTTON_TITLE}.
     */
    CANCEL("cancel");
    private String value;

    DialogButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

