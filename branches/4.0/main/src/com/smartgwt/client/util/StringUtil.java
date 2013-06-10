/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

public class StringUtil {
    
    private static native boolean usePrototypeMethods() /*-{
        // For some reason in Safari if you do
        // new $wnd.String(<string>), the various prototype methods we hang onto the string prototype are not
        // available. Workaround by explicitly applying these methods to the string passed in.
        // The same is true in FF 4.0
        return returnVal = $wnd.isc.Browser.isSafari || 
                ($wnd.isc.Browser.isFirefox && $wnd.isc.Browser.geckoVersion >=20100101);
        
    }-*/;

    /**
     * Convert all tag symbols ( &lt;  and &gt; ) into displayable HTML
     * by changing them to   &amp;lt;  and  &amp;gt;   respectively.
     *
     * @param str    the string to convert
     * @param prefix text to tack onto the beginning of result (eg: "&lt;PRE&gt;")
     * @param suffix text to tack onto the end of result (eg: "&lt;/PRE&gt;")
     * @return prefix + converted text + suffix as a single string
     */
    public static native String convertTags(String str, String prefix, String suffix)/*-{
        if (str == null) return null;
        if (@com.smartgwt.client.util.StringUtil::usePrototypeMethods()()) {
            return $wnd.String.prototype.convertTags.apply(str, [prefix,suffix]);
        } else {
            return new $wnd.String(str).convertTags(prefix, suffix);
        }
    }-*/;
   
    /**
     * Convert plain text into into displayable HTML.
     * <p/>
     * This prevents HTML-special characters like &lt; and &gt; from being interpreted as tags, and
     * preserves line breaks and extra spacing.
     * <pre>
     * 			converts		   to
     * 			--------  		   ---------------------------
     * 			  &				   &amp;
     * 			  <				   &lt;
     * 			  >				   &gt;
     * 			  \r,\n,\r\n1space <BR>&nbsp;
     * 			  \r,\n,\r\n	   <BR>
     * 			  \t			   &nbsp;&nbsp;&nbsp;&nbsp;
     * 			  2 spaces		   1space&nbsp;
     *           </pre>
     *
     * @param str the string to convert
     * @return the plain text into into displayable HTM
     */
    public static native String asHTML(String str)/*-{
        if (str != null && @com.smartgwt.client.util.StringUtil::usePrototypeMethods()()) {
            return $wnd.String.prototype.asHTML.apply(str, []);
        }   
        return str == null ? null : new $wnd.String(str).asHTML();
    }-*/;

    /**
     * Convert plain text into into displayable HTML.
     * <p/>
     * This prevents HTML-special characters like &lt; and &gt; from being interpreted as tags, and
     * preserves line breaks and extra spacing.
     * <pre>
     * 			converts		   to
     * 			--------  		   ---------------------------
     * 			  &				   &amp;
     * 			  <				   &lt;
     * 			  >				   &gt;
     * 			  \r,\n,\r\n1space <BR>&nbsp;
     * 			  \r,\n,\r\n	   <BR>
     * 			  \t			   &nbsp;&nbsp;&nbsp;&nbsp;
     * 			  2 spaces		   1space&nbsp;
     *           </pre>
     *
     * @param str        the string to convert
     * @param noAutoWrap
     * @return the plain text into into displayable HTM
     */
    public static native String asHTML(String str, boolean noAutoWrap)/*-{
        if (str != null && @com.smartgwt.client.util.StringUtil::usePrototypeMethods()()) {
            return $wnd.String.prototype.asHTML.apply(str, [noAutoWrap]);
        }
        return str == null ? null : new $wnd.String(str).asHTML(noAutoWrap);
    }-*/;

    /**
     * Reverses {@link #asHTML(String)}.
     *
     * @param str the input str
     * @return unescaped HTML
     */
    public static native String unescapeHTML(String str)/*-{
        if (str != null && @com.smartgwt.client.util.StringUtil::usePrototypeMethods()()) {
            return $wnd.String.prototype.unescapeHTML.apply(str, []);
        }
        return str == null ? null : new $wnd.String(str).unescapeHTML();
    }-*/;

    /**
     * Escapes special characters in XML values - so called 'unparsed data'
     * <pre>
     * " -> &quot;
     * ' -> &apos;
     * & -> &amp;
     * < -> &lt;
     * > -> &gt;
     * \r -> &x000D;
     * </pre>
     *
     * @param str the String to escape
     * @return xml safe String
     */
    public static native String makeXMLSafe(String str)/*-{
        return str == null ? null : $wnd.isc.makeXMLSafe(str);
    }-*/;

    /**
     * Abbreviates a String using ellipses. StringUtils.abbreviate("abcdefg", 6) = "abc..."
     *
     * @param str      the String to abbreviate
     * @param maxWidth maximum length of result String, must be at least 4
     * @return the abbreviated String
     * @throws IllegalArgumentException when the width is too small
     */
    public static String abbreviate(String str, int maxWidth) {
        if (str == null) {
            return null;
        }
        if (str.length() < maxWidth) {
            return str;
        }
        if (maxWidth < 4) {
            throw new IllegalArgumentException("Minimum required width is 4");
        }

        return str.substring(0, maxWidth - 3) + "...";
    }

    /**
     * Tests whether the given string is a valid JavaScript identifier.
     *
     * @param string the string to test.
     * @return <code>true</code> if <code>string</code> is a valid JavaScript identifier; <code>false</code> otherwise.
     */
    public static native boolean isValidID(String string) /*-{
        return string == null ? false : $wnd.String.isValidID(string);
    }-*/;
}

