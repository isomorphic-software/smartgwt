package com.smartgwt.client.docs;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * A RelativeDateShortcut is a special string that represents a shortcut to a date phrase that can  be automatically mapped
 * to a {@link com.smartgwt.client.docs.RelativeDateString} for use in widgets that  leverage relative-dates, such as the
 * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem}. <P> Note that some shortcuts indicate a time period
 * but do not directly indicate whether the value refers to the start or end of the time period in question. This ambiguity
 * can be resolved by specifying an explicit {@link com.smartgwt.client.types.RelativeDateRangePosition} when calling APIs
 * that  convert from RelativeDates to absolute date values. This is the case for <i>$today</i>,  <i>$tomorrow</i>,
 * <i>$yesterday</i>, <i>$weekAgo</i>, <i>$weekFromNow</i>, <i>$monthAgo</i> and <i>$monthFromNow</i>. If a range position
 * is not explicitly passed, these will all default to the start of the day in question. <P> Builtin options include <ul>
 * <li> $now - this moment </li> <li> $today - the current day. By default this resolves to the start of the current day
 * though   an explicit {@link com.smartgwt.client.types.RelativeDateRangePosition} may be used to specify the end of the
 * current day.</li> <li> $startOfToday - the start of today</li> <li> $endOfToday - the end of today (one millisecond
 * before the $startOfTomorrow) </li> <li> $yesterday - the previous day.</li> <li> $startOfYesterday - the start of
 * yesterday</li> <li> $endOfYesterday - the end of yesterday (one millisecond before the $startOfToday) </li> <li>
 * $tomorrow - the following day</li> <li> $startOfTomorrow - the start of tomorrow </li> <li> $endOfTomorrow - the end of
 * tomorrow </li> <li> $weekAgo - the current day of the previous week </li> <li> $weekFromNow - the current day of the
 * next week </li> <li> $startOfWeek - the start of the current week </li> <li> $endOfWeek - the end of the current week
 * </li> <li> $monthAgo - the current day of the previous month </li> <li> $monthFromNow - the current day of the following
 * month </li> <li> $startOfMonth - the start of the current month </li> <li> $endOfMonth - the end of the current month
 * </li> <li> $startOfYear - the start of the current year </li> <li> $endOfYear - the end of the current year </li> </ul> 
 * <P>
 */
public interface RelativeDateShortcut  {
}
