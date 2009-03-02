package com.smartgwt.client.types;

/**
 * Determines how Java enums are translated to and from Javascript by the SmartClient server.
 */
public enum EnumTranslateStrategy implements ValueEnum {

    /**
     * Translates to/from a String matching the constant name. This is the default if not set.
     */
    STRING("string"),

    /**
     * Translates to/from an integer matching the ordinal number of the constant within the enumeration
     */
    ORDINAL("ordinal"),

    /**
     * Translates to/from a Javascript object containing one property for each property defined within the enum.
     * The constant itself and the ordinal number are included in the JS object. By default they are called "_constant"
     * and "_ordinal", but this can be overridden with the DataSource.enumOrdinalProperty and DataSource.enumConstantProperty properties
     */
    BEAN("bean");

    private String value;

    EnumTranslateStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
