package com.smartgwt.client.util;

import com.smartgwt.client.types.ValueEnum;

/**
 * Utils for manipulate with a Enum.
 */
public class EnumUtil {

    /**
     * Get a enum item by value.
     * 
     * @param enums
     *            - enum items
     * @param value
     *            - enum value
     * @return enum item
     * 
     * @see com.smartgwt.client.types.ValueEnum
     */
    public static <TYPE extends ValueEnum> TYPE getEnum(TYPE[] enums, String value) {
        if (value == null) {
            return null;
        }

        for (TYPE anEnum : enums) {
            if (anEnum.getValue().equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    /**
     * Get a enum items by values.
     * <p>
     * The java 1.6 does not support a code "
     * {@code (TYPE[]) new Object[values.length];". Also, the GWT does not support a reflection api (
     * {@link java.lang.reflect.Array#newInstance}). So you need to pass an
     * array argument to store the result.
     * 
     * @param enums
     *            - enum items
     * @param values
     *            - enum values
     * @param result
     *            - array to store the result
     * @return enum items
     */
    public static <TYPE extends ValueEnum> TYPE[] getEnums(TYPE[] enums, String[] values, TYPE[] result) {
        if (values == null) {
            return result;
        }

        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            result[i] = null;
            for (TYPE anEnum : enums) {
                if (anEnum.getValue().equals(value)) {
                    result[i] = anEnum;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Get a enum items by values.
     * <p>
     * This method is not compatible with the java 1.6.
     * 
     * @param enums
     *            - enum items
     * @param values
     *            - enum values
     * @return enum items

     * @deprecated use {{@link #getEnums(ValueEnum[], String[], ValueEnum[])}
     *             method
     * @see EnumUtil#getEnums(ValueEnum[], String[], ValueEnum[])             
     */
    public static <TYPE extends ValueEnum> ValueEnum[] getEnums(TYPE[] enums, String[] values) {
        if (values == null) {
            return null;
        }

        ValueEnum result[] = new ValueEnum[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            result[i] = null;
            for (TYPE anEnum : enums) {
                if (anEnum.getValue().equals(value)) {
                    result[i] = (ValueEnum) anEnum;
                    break;
                }
            }
        }
        return result;
    }
}
