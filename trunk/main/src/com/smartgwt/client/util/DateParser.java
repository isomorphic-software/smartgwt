package com.smartgwt.client.util;

import java.util.Date;

/**
 * Custom parser for converting formatted date strings to live Date objects.
 *
 * @see com.smartgwt.client.util.DateUtil#setDateParser(DateParser)
 */
public interface DateParser {

    /**
     * The parse method. This should take a formatted date string and parse it into a live Date object.
     *
     * @param dateString String representation of the date
     * @return the date value
     */
    Date parse(String dateString);
}
