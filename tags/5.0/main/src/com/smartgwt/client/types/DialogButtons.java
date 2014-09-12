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
 * Default buttons that you can use in your Dialogs.
 *  <p>
 *  
 *  Each <code>DialogButtons</code> enum value has a same-named static Button on the Dialog
 *  class, and these buttons can be passed to {@link com.smartgwt.client.widgets.Dialog#getButtons Dialog.setButtons()}:
 *  <pre>
 *    Dialog.setButtons(Dialog.OK, Dialog.CANCEL);
 *  </pre>
 *  
 *  
 *  <p>
 *  All buttons added via <code>setButtons</code> will fire the
 *  {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler buttonClick event} (whether they are built-in or custom
 *  buttons).  Built-in buttons automatically close a Dialog, with the exception of the
 *  "Apply" button.
 */
public enum DialogButtons implements ValueEnum {
    /**
     * Dismisses dialog. Title derived from {@link com.smartgwt.client.widgets.Dialog#OK_BUTTON_TITLE OK_BUTTON_TITLE}.
     */
    OK("ok"),
    /**
     * Does not dismiss dialog. Handle via {@link com.smartgwt.client.widgets.Dialog#addButtonClickHandler Dialog.buttonClick} 
     * Title derived from {@link com.smartgwt.client.widgets.Dialog#APPLY_BUTTON_TITLE APPLY_BUTTON_TITLE}.
     */
    APPLY("apply"),
    /**
     * Dismisses dialog. Title derived from {@link com.smartgwt.client.widgets.Dialog#YES_BUTTON_TITLE YES_BUTTON_TITLE}.
     */
    YES("yes"),
    /**
     * Dismisses dialog. Title derived from {@link com.smartgwt.client.widgets.Dialog#NO_BUTTON_TITLE NO_BUTTON_TITLE}.
     */
    NO("no"),
    /**
     * Dismisses dialog. Title derived from {@link com.smartgwt.client.widgets.Dialog#CANCEL_BUTTON_TITLE CANCEL_BUTTON_TITLE}.
     */
    CANCEL("cancel"),
    /**
     * Dismisses dialog. Title derived from {@link com.smartgwt.client.widgets.Dialog#DONE_BUTTON_TITLE DONE_BUTTON_TITLE}.
     */
    DONE("done");
    private String value;

    DialogButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
