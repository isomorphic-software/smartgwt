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

package com.smartgwt.client.widgets.form.fields;

import java.util.Date;

/**
 * A class specifying a range of dates. Values are start and end. If either value is omitted, the range is assumed to be open-ended in that direction -
 * so if dateRange.start is omitted, the range will include any date earlier than the value specified in dateRange.end.
 */
public class DateRange {
    private Date start;
    private Date end;

    public DateRange() {
    }

    /**
     * Constructor.
     *
     * @param start the start date
     * @param end the end date
     */
    public DateRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    /**
     *
     * @return the start date
     */
    public Date getStart() {
        return start;
    }

    /**
     *
     * @param start the start date
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     *
     * @return the end date
     */
    public Date getEnd() {
        return end;
    }

    /**
     *
     * @param end the end date
     */
    public void setEnd(Date end) {
        this.end = end;
    }
}
