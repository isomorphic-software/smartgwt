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
 
/**
 * A string of known format used to specify a datetime offset.  For example, a  RelativeDateString that represents "one
 * year from today" is written as <code>"+1y"</code>. <P> RelativeDateStrings are comprised of the following parts: <ul>
 * <li>direction: the direction in which the quantity applies - one of + or - </li> <li>quantity: the number of units of
 * time to apply - a number </li> <li>timeUnit: an abbreviated timeUnit to use - one of ms/MS (millisecond), s/S (second), 
 * mn/MN (minute), h/H (hour), d/D (day), w/W (week), m/M (month), q/Q (quarter, 3-months),       y/Y (year), dc/DC
 * (decade) or c/C (century). <br>      The timeUnit is case sensitive. A lowercase timeUnit implies an exact offset, so
 * <code>+1d</code>      refers to the current date / time increased by exactly 24 hours. If the timeUnit is      
 * uppercase, it refers to the start or end boundary of the period of time in question, so      <code>+1D</code> would
 * refer to the end of the day (23:39:59:999) tomorrow, and      <code>-1D</code> would refer to the start of the day
 * (00:00:00:000) yesterday.</li> <li>[qualifier]: an optional timeUnit encapsulated in square-brackets and used to offset 
 * the calculation - eg. if +1d is "plus one day", +1d[W] is "plus one day from the       end of the current week".  You
 * may also specify another complete RelativeDateString as the      [qualifier], which offers more control - eg, +1d[+1W]
 * indicates "plus one day from       the end of NEXT week".</li> </ul> <P> This format is very flexible. Here are a few
 * example relative date strings:<br> <code>+0D</code>: End of today. There are often multiple ways to represent the same
 * time  using this system - for example this could also be written as <code>-1ms[+1D]</code><br> <code>-0D</code>:
 * Beginning of today.<br> <code>+1W</code>: End of next week.<br> <code>+1w[-0W]</code>: Beginning of next week.<br>
 * <code>+1w[-0D]</code>: Beginning of the current day of next week.
 */
public interface RelativeDateString  {
}
        
