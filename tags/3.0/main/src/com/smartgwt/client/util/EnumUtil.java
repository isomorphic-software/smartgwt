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

    public static <T extends ValueEnum> ValueEnum[] getEnums(T[] enums, String[] values) {
        if(values == null) return null;
        ValueEnum ret[] = new ValueEnum[values.length];
        for (int i=0; i<values.length; i++) {
            String value = values[i];
            ret[i] = null;
            for (T anEnum : enums) {
                if (anEnum.getValue().equals(value)) {
                    ret[i] = (ValueEnum) anEnum;
                }
            }
        }
        return ret;
    }
}
