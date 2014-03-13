package com.smartgwt.client.cordova.types;

import com.smartgwt.client.types.ValueEnum;

public enum ContactFilterProperty implements ValueEnum {

    DISPLAY_NAME("displayName");

    private final String value;

    private ContactFilterProperty(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
