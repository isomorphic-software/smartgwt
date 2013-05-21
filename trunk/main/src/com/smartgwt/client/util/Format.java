package com.smartgwt.client.util;

/**
 * 
 * @deprecated see {@link com.smartgwt.client.docs.LocalizedNumberFormatting Localized Number Formatting}
 * for details.
 */
public class Format {

    public static native String toUSString(double value) /*-{
        return $wnd.isc.Format.toUSString(value);
    }-*/;

    public static native String toUSString(double value, int decimalPrecision) /*-{
        return $wnd.isc.Format.toUSString(value, decimalPrecision);
    }-*/;

    public static native String toUSDollarString(double value) /*-{
        return $wnd.isc.Format.toUSDollarString(value);
    }-*/;

    public static native String toUSDollarString(double value, int decimalPrecision) /*-{
        return $wnd.isc.Format.toUSDollarString(value, decimalPrecision);
    }-*/;

}
