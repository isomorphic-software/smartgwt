package com.smartgwt.client.util;

import java.util.Date;

/**
 * DateDisplayFormatter interface.
 *
 * SmartGWT includes several built-in DateFormatters for common formats - see below:
 * <table>
 * <tr>
 * <td>{@link DateUtil.TOSTRING}</td>
 * <td>The default native browser <code>toString()</code> implementation.</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOLOCALESTRING}</td>
 * <td>The default native browser <code>toLocaleString()</code> implementation.</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOUSSHORTDATE}</td>
 * <td>Short date in format MM/DD/YYYY</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOUSSHORTDATETIME}</td>
 * <td>Short date with time in format MM/DD/YYYY HH:MM</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOEUROPEANSHORTDATE}</td>
 * <td>Short date in format DD/MM/YYYY</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOEUROPEANSHORTDATETIME}</td>
 * <td>Short date with time in format DD/MM/YYYY HH:MM</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOJAPANSHORTDATE}</td>
 * <td>Short date in format YYYY/MM/DD</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOJAPANSHORTDATETIME}</td>
 * <td>Short date with time in format YYYY/MM/DD HH:MM</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TOSERIALIZEABLEDATE}</td>
 * <td>Date in the format YYYY-MM-DD HH:MM:SS</td>
 * </tr>
 * <tr>
 * <td>{@link DateUtil.TODATESTAMP}</td>
 * <td>Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z <i>Example</i>: <code>20051104T111001Z</code></td>
 * </tr>
 * </table>
 *
 * @see com.smartgwt.client.util.DateUtil#setNormalDateDisplayFormatter(DateDisplayFormatter)
 * @see com.smartgwt.client.util.DateUtil#setShortDateDisplayFormatter(DateDisplayFormatter)
 * @see com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormatter(DateDisplayFormatter)
 */
public interface DateDisplayFormatter {

    /**
     * The format method.
     *
     * @param date the date
     * @return the String representation of the date
     */
    String format(Date date);

}
