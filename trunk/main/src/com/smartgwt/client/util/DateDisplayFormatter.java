package com.smartgwt.client.util;

import java.util.Date;

/**
 * DateDisplayFormatter interface.
 *
 * @see com.smartgwt.client.util.DateUtil#setNormalDateDisplayFormatter(DateDisplayFormatter)
 * @see com.smartgwt.client.util.DateUtil#setShortDateDisplayFormatter(DateDisplayFormatter)
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
