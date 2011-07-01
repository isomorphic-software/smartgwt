package com.smartgwt.client.types;

/**
 * Flags to set automatic removal of events from the page event registry.
 */

public enum FireStyle implements ValueEnum {
    /**
     * Call the registered handler any time the event occurs
     */
    NULL("null"),
    /**
     * Call the registered handler the first time the event                               occurs, then unregister the
     * handler as though&#010                               ${isc.DocUtils.linkForRef('classMethod:Page.clearEvent')}
     * had been called
     */
    FIRE_ONCE("fire_once");
    private String value;

    FireStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

