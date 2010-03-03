package com.smartgwt.client.util;

import com.smartgwt.client.types.ValueEnum;

public class EnumUtil {

    public static <T extends ValueEnum> T getEnum(T[] enums, String value) {
        if(value == null) return null;
        for (T anEnum : enums) {
            if (anEnum.getValue().equals(value)) {
                return anEnum;
            }
        }
        return null;
    }
}
