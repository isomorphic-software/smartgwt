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
 * A String to be used as a format specifier for a date, datetime, time or numeric field, via the {@link
 * com.smartgwt.client.data.DataSourceField#getFormat format} and {@link
 * com.smartgwt.client.data.DataSourceField#getExportFormat exportFormat}  properties.   <p> For fields with a numeric
 * type, the format string is similar to java.text.NumberFormat (see <a
 * href='http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html'
 * onclick="window.open('http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html');return
 * false;">DecimalFormat JavaDoc</a>), and for date, time, and datetime types, the format string is similar to
 * java.text.SimpleDateFormat (see  <a href='http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html'
 * onclick="window.open('http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html');return
 * false;">SimpleDateFormat JavaDoc</a>). <p> Note that all the client-side formatting described in this section is is done
 * by the  {@link com.smartgwt.client.util.NumberUtil#format NumberUtil.format()} and   {@link
 * com.smartgwt.client.util.DateUtil.format()} methods.  These are static utility methods that your own code can call if
 * you need to  programmatically format a date or number using a <code>FormatString</code> <p> There are 3 possible
 * contexts where a <code>FormatString</code> may be interpreted, and each has slightly different limitations:
 * <h4>in-browser rendering &amp; client-driven exports</h4> Almost complete support for Java's
 * SimpleDateFormat/DecimalFormat, as described below, with some small extensions for formatting with awareness of a {@link
 * com.smartgwt.client.widgets.FiscalCalendar}. <p> This category includes cases where code running in the browser does the
 * rendering and the rendered result is passed to the server, such as  {@link
 * com.smartgwt.client.widgets.grid.ListGrid#exportClientData client-driven export} and {@link
 * com.smartgwt.client.rpc.RPCManager#exportContent PDF export of the printed view}. <h4>Excel export</h4>  Almost the same
 * as in-browser rendering, with minor limitations due to missing features in Excel.  Exact differences are described under
 * {@link com.smartgwt.client.data.DataSourceField#getExportFormat exportFormat}. <h4>non-Excel server export</h4> For
 * example, CSV, XML or JSON {@link com.smartgwt.client.types.ExportFormat export formats} provided via {@link
 * com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.  Full support for SimpleDateFormat/DecimalFormat
 * as provided by whichever Java version you have installed on the server.  However note that depending on the context of
 * the export, the default behavior may be to ignore format strings, since formatting intended for end users wouldn't be
 * desirable if data exchange is the goal.  See the {@link com.smartgwt.client.docs.ExportFormatting Export Formatting
 * overview} for details. <P> <h3>Date Format</h3> <table width="700" style="font-size:11px;border:1px solid black;">
 * <tr><td style="color:white;background-color:black;"><b>Format token</b></td>     <td
 * style="color:white;background-color:black;"><b>Description</b></td>     <td
 * style="color:white;background-color:black;width:150px;"><b>Sample value</b></td></tr> <tr><td>yy     </td><td>Year as a
 * two-digit number                            </td><td>"99"   or "07"</td></tr> <tr><td>yyyy   </td><td>Year as a
 * four-digit number                           </td><td>"1999" or "2007"</td></tr> <tr><td>YY     </td><td>Week year as a
 * two-digit number (week year is the year associated with the entire week deemed to contain a given date, and it may
 * differ from calendar year.  For example, the week year of December 31 2012 is 2013)</td><td>"99"   or "07"</td></tr>
 * <tr><td>YYYY   </td><td>Week year as a four-digit number                      </td><td>"1999" or "2007"</td></tr>
 * <tr><td>LL     </td><td>Fiscal year as a two-digit number ({@link
 * com.smartgwt.client.widgets.FiscalCalendar})</td><td>"99"   or "07"</td></tr> <tr><td>LLLL   </td><td>Fiscal year as a
 * four-digit number                    </td><td>"1999" or "2007"</td></tr> <tr><td>M      </td><td>Month in year          
 * </td><td>"1"  to "12"</td></tr> <tr><td>MM     </td><td>Month in year with leading zero if required          
 * </td><td>"01" to "12"</td></tr> <tr><td>MMM    </td><td>Short month name ({@link
 * com.smartgwt.client.util.DateUtil#setShortMonthNames()})        </td><td>"Jan" to "Dec"</td></tr> <tr><td>MMMM  
 * </td><td>Full month name ({@link com.smartgwt.client.util.DateUtil#setMonthNames()})              </td><td>"January" to
 * "December"</td></tr> <tr><td>w      </td><td>Week in year                                          </td><td>"1"  to
 * "52"</td></tr> <tr><td>ww     </td><td>Week in year with leading zero if required            </td><td>"01" to
 * "52"</td></tr> <tr><td>C      </td><td>Week in fiscal year ({@link com.smartgwt.client.widgets.FiscalCalendar})         
 * </td><td>"7"  or "29"</td></tr> <tr><td>CC     </td><td>Week in fiscal year with leading zero if required    
 * </td><td>"07" or "29"</td></tr> <tr><td>d      </td><td>Day of the month                                     
 * </td><td>"1"  to "31"</td></tr> <tr><td>dd     </td><td>Day of the month with leading zero if required       
 * </td><td>"01" to "31"</td></tr> <tr><td>ddd    </td><td>Short day name ({@link
 * com.smartgwt.client.util.Date#shortDayNames shortDayNames})            </td><td>"Mon" to "Sun"</td></tr> <tr><td>dddd  
 * </td><td>Full day name. ({@link com.smartgwt.client.util.Date#dayNames dayNames})                 </td><td>"Monday" to
 * "Sunday"</td></tr> <tr><td>E      </td><td>Short day name ("EE" and "EEE" are equivalent; all are exactly the same as
 * "ddd" - "E" is supported purely to conform with SimpleDateFormat)</td><td>"Mon" to "Sun"</td></tr> <tr><td>EEEE  
 * </td><td>Full day name (exactly the same as "dddd")            </td><td>"Monday" to "Sunday"</td></tr> <tr><td>D     
 * </td><td>Day in year                                           </td><td>"1"  to "366"</td></tr> <tr><td>DD    
 * </td><td>Day in year with leading zero if required             </td><td>"01" to "366"</td></tr> <tr><td>c     
 * </td><td>Day in fiscal year ({@link com.smartgwt.client.widgets.FiscalCalendar})            </td><td>"5"  or
 * "204"</td></tr> <tr><td>cc     </td><td>Day in fiscal year with leading zero if required      </td><td>"05" or
 * "204"</td></tr> <tr><td>u      </td><td>Day number in week (1 is Monday)                      </td><td>"1" to
 * "7"</td></tr> <tr><td>H      </td><td>Hour in day, 0-23 (24-hour clock)                     </td><td>"0"  to
 * "23"</td></tr> <tr><td>HH     </td><td>Hour in day with leading zero if required (24-hour)   </td><td>"00" to
 * "23"</td></tr> <tr><td>h      </td><td>Hour in day, 1-12 (12-hour clock)                     </td><td>"1"  to
 * "12"</td></tr> <tr><td>hh     </td><td>Hour in day with leading zero if required (12-hour)   </td><td>"01" to
 * "12"</td></tr> <tr><td>m      </td><td>Minute in hour                                        </td><td>"0"  to
 * "59"</td></tr> <tr><td>mm     </td><td>Minute in hour with leading zero if required          </td><td>"00" to
 * "59"</td></tr> <tr><td>s      </td><td>Second in minute                                      </td><td>"0"  to
 * "59"</td></tr> <tr><td>ss     </td><td>Second in minute with leading zero if required        </td><td>"00" to
 * "59"</td></tr> <tr><td>a      </td><td>The AM/PM designator (String)        </td><td>" am" or " pm"</td></tr> </table>
 * <p> <h3>Examples - various formatted versions of the datetime "2006-08-03 11:26:18"</h3> <table> <tr><td
 * width="150">"M/d/yy"</td><td width="300">8/3/06</td></tr> <tr><td>"MMMM yyyy"</td><td>August 2006</td></tr>
 * <tr><td>"HH:mm"</td><td>11:26</td></tr> <tr><td>"d MMM yyyy, H:ma"</td><td>3 Aug 2006, 11:26 am</td></tr>
 * <tr><td>"dd/mm/yyyy"</td><td>03/08/2006</td></tr> <tr><td>"CC/LLLL"</td><td>53/2006 (assuming the fiscal year ends in
 * the first week of August)</td></tr> </table> <p> <h3><code>SimpleDateFormat</code> specifiers that we do <b>not</b>
 * support:</h3> <ul> <li>Era designator, BC/AD (G)</li> <li>Day of week in month (F)</li> <li>Hour in day, 24-hour, with
 * 1-based instead of normal 0-based numbering (hours are 1-24) (k)</li> <li>Hour in day, 12-hour, with 0-based instead of
 * normal 1-based numbering (hours are 0-11) (K)</li> <li>Milliseconds (S)</li> <li>Timezone (z, Z, X)</li> </ul>
 * <p>&nbsp;<p> <h3>Number Format</h3> <table width="700" style="font-size:11px;border:1px solid black;"> <tr><td
 * style="color:white;background-color:black;"><b>Format char</b></td>     <td
 * style="color:white;background-color:black;"><b>Description</b></td> <tr><td>0          </td><td>Digit, zero is
 * displayed</td></tr> <tr><td>#          </td><td>Digit, zero is not displayed</td></tr> <tr><td>-          </td><td>Minus
 * sign</td></tr> <tr><td>.          </td><td>Decimal separator</td></tr> <tr><td>%          </td><td>Multiply by 100 and
 * show as percentage</td></tr> <tr><td>&#x2030; (\u2030) </td><td>Multiply by 1000 and show as per mille.  See
 * below.</td></tr> <tr><td>,          </td><td>Indicates digit grouping should be used - eg 1,000,000.  See
 * below.</td></tr> <tr><td>;          </td><td>Separates positive and negative subpatterns.  See below.</td></tr>
 * <tr><td>&#x00a4; (\\u00A4) </td><td>As a prefix or suffix, indicates the local currency symbol should be used.  Note
 * that you must use special notation to include this character in an XML file (such as a .ds.xml file).  See
 * below.</td></tr> <tr><td>'          </td><td>Used to quote special characters in a prefix or suffix, for example, "'#'#"
 * formats 123 to "#123". To create a single quote itself, use two in a row: "# o''clock".</td></tr> </table> <p> All other
 * characters in the format string are taken literally and output unchanged. <p> <h3>Examples</h3> <table
 * style="font-size:11px;border:1px solid black;"> <tr><td width="150"
 * style="color:white;background-color:black;"><b>Format string</b></td>     <td width="150"
 * style="color:white;background-color:black;"><b>Zero value</b></td>     <td width="150"
 * style="color:white;background-color:black;"><b>Positive value: 12345.678</b></td>     <td width="150"
 * style="color:white;background-color:black;"><b>Negative value: -2345.123</b></td>
 * <tr><td>"0.00"</td><td>0.00</td><td>12345.68</td><td>-2345.12</td></tr>
 * <tr><td>",##0.00"</td><td>0.00</td><td>12,345.68</td><td>-2,345.12</td></tr>
 * <tr><td>"0.###"</td><td>0</td><td>12345.678</td><td>-2345.123</td></tr>
 * <tr><td>"&#x00a4;,0.00"</td><td>$0.00</td><td>$12,345.68</td><td>-$2345.12</td></tr>
 * <tr><td>"0.0#%"</td><td>0.0%</td><td>1234567.8%</td><td>-234512.3%</td></tr>
 * <tr><td>"0.0#&#x2030;"</td><td>0.0&#x2030;</td><td>12345678.0&#x2030;</td><td>-2345123.0&#x2030;</td></tr>
 * <tr><td>"0.0#'%'"</td><td>0.0%</td><td>12345.68%</td><td>-2345.12%</td></tr>
 * <tr><td>"0.00;(0.00)"</td><td>0.0%</td><td>12345.68</td><td>(2345.12)</td></tr> </table><br> Note, the above examples
 * include cases where there are multiple '#' characters in the integer part of the number format (ie, to the left of the
 * decimal separator, or the entire format  if there is no separator).  We support this pattern simply because
 * <code>DecimalFormat</code> does: the extra '#' characters are not significant.  In other words, the format "##0.00" 
 * produces exactly the same formatting as "0.00", and "##,###,###.##" produces exactly the  same formatting as ",#.##". 
 * However, multiple '0' characters in the integer part of the  format <em>are</em> significant, as are both '#' and '0'
 * characters in the decimal part  of the format (ie, to the right of any decimal separator). <p> The ";" character marks
 * the boundary between two subpatterns - the first to be used for  formatting positive numbers (and 0), the second for
 * negative numbers.  Specifying a separate pattern for negative numbers is optional: if no negative subpattern is
 * specified, negative numbers are formatted like positive numbers, but with a leading "-" sign. <p> The "&#x00a4;" symbol
 * (\u00A4) is documented in the Java DecimalFormat class as a placeholder for the currency symbol appropriate to the
 * current locale.  For client-driven exports, we replace it with   whatever GWT's built-in NumberFormat's class uses. 
 * Likewise, the decimal symbol and grouping symbol will match what GWT's NumberFormat returns.  Note that "\u00A4" is the
 * correct way to specify this character in Javascript code.  If you need to specify the character in an XML file - the
 * common requirement is in a .ds.xml DataSource descriptor file - you must use the code "&amp;#x00A4;" instead. <p> The
 * "&permil;" per mille symbol is specified as "\u2030" in Javascript code; in XML or HTML  you can use either the
 * equivalent notation "&amp;#x2030;" or the special HTML code  "&amp;permil;". <p> <h3><code>DecimalFormat</code> features
 * that we do <b>not</b> support:</h3> <ul> <li>Scientific notation</li> <li>Doubled currency symbol means "use
 * international currency symbol"</li> <li>We do not support arbitrary digit grouping, by providing patterns of the '#' and
 * ',' characters, like <code>DecimalFormat</code> does.  Grouping in Smart GWT FormatStrings is enabled with a single ","
 * character somewhere before or within the number-formatting part of the string - extra "," characters within the
 * number-formatting part of the string  are tolerated, but they have no effect.  Grouping in Smart GWT always causes
 * digits to  be gathered in groups of three</li> </ul>
 */
public interface FormatString  {
}
