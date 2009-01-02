package com.smartgwt.client.util;

import com.smartgwt.client.types.ValueEnum;

public class EnumUtil {

    public static ValueEnum getEnum(ValueEnum[] enums, String value) {
        for (ValueEnum anEnum : enums) {
            if (anEnum.getValue().equals(value)) {
                return anEnum;
            }
        }
        return null;
    }
}
