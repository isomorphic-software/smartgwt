package com.smartgwt.client.util;

import java.util.Date;

/**
 * DateInputFormatter.
 *
 * @see com.smartgwt.client.util.DateUtil#setDateInputFormatter(DateInputFormatter)
 */
public interface DateInputFormatter {

    /**
     * The parse method.
     *
     * @param dateString String representation of the date
     * @return the date value
     */
    Date parse(String dateString);
}
