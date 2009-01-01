/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */






//> @class  Time
// Class with helper methods for converting dates to and from formatted time strings.
//  @treeLocation Client Reference/System
// @visibility external
//<
isc.ClassFactory.defineClass("Time");


isc.Time.addClassProperties({

    //> @classAttr  Time.UTCHoursOffset (number : 0 : IRA)
    // Time data is stored in Date type objects. 
    // In order to have times display consistently across browsers all times assumed to be stored
    // as UTC times.
    // This property allows you to specify an timezone offset between the stored time 
    // and the displayed time - for example if you have legacy server data with date-time data 
    // in PST modify this property to be the number of hours offset from UTC.
    // <P>
    // Alternatively this property can be used to display local times for values stored on
    // the server in UTC time. Here's some sample code that would achieve this based on the 
    // browser's locale settings:
    // <pre>
    //    isc.Time.addClassProperties({
    //        UTCHoursOffset:new Date().getTimezoneOffset()/60
    //    });
    // </pre> 
    // @visibility external
    //<
    UTCHoursOffset:0,

    //>	@classAttr	isc.Time._timeExpressions (Array : [..] : IRA)
	// List of regular expressions to parse a time string
	//		@group	parsing
	//<
	_timeExpressions : [				
			/^\s*(\d?\d)\s*[: ]\s*(\d?\d)\s*[: ]\s*(\d?\d)?\s*([AaPp][Mm]?)?\s*$/,
			/^\s*(\d?\d)\s*[: ]\s*(\d?\d)(\s*)([AaPp][Mm]?)?\s*$/,
			/^\s*(\d\d)(\d\d)(\d\d)?\s*([AaPp][Mm]?)?\s*$/,
			/^\s*(\d)(\d\d)(\d\d)?\s*([AaPp][Mm]?)?\s*$/,
			/^\s*(\d\d?)(\s)?(\s*)([AaPp][Mm]?)?\s*$/
		],

    //> @type   timeFormatter
    // String designating a standard time formatter for displaying the times associated with 
    // dates strings.
    // @value   toTime
    //  String will display with seconds and am/pm indicator:<code>[H]H:MM:SS am|pm</code>. <br>
    //  Example: <code>3:25:15 pm</code>
    // @value  to24HourTime
    //  String will display with seconds in 24 hour time: <code>[H]H:MM:SS</code>. <br>
    //  Example: <code>15:25:15</code>
    // @value  toPaddedTime
    //  String will display with seconds, with a 2 digit hour and am/pm indicator: 
    //  <code>HH:MM:SS am|pm</code> <br>
    //  Example: <code>03:25:15 pm</code>
    // @value  toPadded24HourTime
    //  String will display with seconds, with a 2 digit hour in 24 hour format: 
    //  <code>HH:MM:SS</code> <br>
    //  Examples: <code>15:25:15</code>, <code>03:16:45</code>
    // @value toShortTime
    //  String will have no seconds and be in 12 hour format:<code>[H]H:MM am|pm</code><br>
    //  Example: <code>3:25 pm</code>
    // @value toShort24HourTime
    //  String will have no seconds and be in 24 hour format: <code>[H]H:MM</code><br>
    //  Example:<code>15:25</code>
    // @value toShortPaddedTime
    //  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
    //  <code>HH:MM am|pm</code><br>
    //  Exmaple: <code>03:25 pm</code>
    // @value toShortPadded24HourTime
    //  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
    // <code>HH:MM</code><br>
    // Examples: <code>15:25</code>, <code>03:16</code>
    //
    // @visibility external
    //<

    // To simplify parsing / formatting, map valid formatter names to the details of the format
    formatterMap:{
        toTime:{showSeconds:true, padded:false, show24:false},
        to24HourTime:{showSeconds:true, padded:false, show24:true},

        toPaddedTime:{showSeconds:true, padded:true, show24:false},
        toPadded24HourTime:{showSeconds:true, padded:true, show24:true},
        
        toShortTime:{showSeconds:false, padded:false, show24:false},
        toShort24HourTime:{showSeconds:false, padded:false, show24:true},
        toShortPaddedTime:{showSeconds:false, padded:true, show24:false},

        toShortPadded24HourTime:{showSeconds:false, padded:true, show24:true}
    },
    
    
    
    //> @classAttr Time.displayFormat  (timeFormatter|function : "toTime" : RWA)
    // Standard formatter to be used when converting a date to a time-string via +link{Time.toTime()}
    // @setter Time.setNormalDisplayFormat()
    // @visibility external
    //<
    displayFormat:"toTime",

    //> @classAttr Time.shortDisplayFormat  (timeFormatter|function : "toShortTime" : RWA)
    // Standard formatter to be used when converting a date to a time-string via +link{Time.toShortTime()}
    // @setter Time.setShortDisplayFormat()
    // @visibility external
    //<
    shortDisplayFormat:"toShortTime",
    
    //> @classAttr Time.AMIndicator (string : " am" : RWA)
    // String appended to times to indicate am (when not using 24 hour format).
    // @visibility external
    // @group i18nMessages
    //<
    AMIndicator:" am",
    //> @classAttr Time.PMIndicator (string : " pm" : RWA)
    // String appended to times to indicate am (when not using 24 hour format).
    // @visibility external
    // @group i18nMessages
    //<
    PMIndicator:" pm"
});

isc.Time.addClassMethods({

    //> @classMethod Time.toTime()
    // Given a date object, return the time associated with the date as a string.
    // If no formatter is passed, use the standard formatter set up via +link{Time.setNormalDisplayFormat()}
    // @param date (Date) Date to convert to a time string.
    // @param [formatter] (timeFormatter|function) Optional custom formatter to use. Will accept
    //  a function (which will be passed a pointer to the date to perform the conversion), or
    //  a string designating a standard formatter
    // @visibility external
    //<
    toTime : function (date, formatter) {
        return this.format(date, formatter, false);
    },
    
    //> @classMethod Time.toShortTime()
    // Given a date object, return the time associated with the date as a short string.
    // If no formatter is passed, use the standard formatter set up via +link{Time.setShortDisplayFormat()}
    // @param date (Date) Date to convert to a time string.
    // @param [formatter] (timeFormatter|function) Optional custom formatter to use. Will accept
    //  a function (which will be passed a pointer to the Date to format), or
    //  a string designating a standard formatter
    // @visibility external
    //<    
    toShortTime : function (date, formatter) {
        return this.format(date, formatter, true);
    },

    // Given a date return a formatted time string
    _$timeTemplate:[null, ":", null, ":"],
    _$shortTimeTemplate:[null, ":"],
    format : function (date, formatter, shortFormat) {
        // If we're passed a random object (most likely null or a string), just return it
        if (!isc.isA.Date(date)) return date;

        var originalFormatter = formatter;

        // Sanity check - don't allow unexpected things passed in as a formatter to give us
        // odd results
        if (!formatter && !isc.isA.String(formatter) && !isc.isA.Function(formatter)) {
            formatter = shortFormat ? this.shortDisplayFormat : this.displayFormat;
        }

        // Support passing in a completely arbitrary formatter function
        if (isc.isA.Function(formatter)) return formatter(date);
        
        if (isc.isA.String(formatter)) formatter = this.formatterMap[formatter];
        
        if (!isc.isAn.Object(formatter)) {
            this.logWarn("Invalid time formatter:" + originalFormatter + " - using 'toTime'");
            formatter = this.formatterMap.toTime;
        }

        var showSeconds = formatter.showSeconds,
            padded = formatter.padded,
            show24 = formatter.show24;
            
        var hour = date.getUTCHours();

        // knock off the offset to get the actual UTC hours
        hour -= isc.Time.UTCHoursOffset;
        
        var minutes = date.getUTCMinutes(),
            seconds = showSeconds ? date.getUTCSeconds() : null,
            pm = show24 ? null : (hour >=12);
        
        // Hour will be in 24 hour format by default
        // don't show negative hours!
        if (hour < 0) hour += 24;
        if (!show24) {
            if (hour > 12) hour = hour - 12;
            if (hour == 0) hour = 12;
        }
        if (padded) hour = hour.stringify(2);
        
        var template = showSeconds ? this._$timeTemplate : this._$shortTimeTemplate;
        template[0] = hour;
        template[2] = minutes.stringify();
        if (showSeconds) template[4] = seconds.stringify();
        if (!show24) template[5] = (pm ? this.PMIndicator : this.AMIndicator);
        else template[5] = null;

        return template.join(isc.emptyString);
    },
    
    //> @classMethod Time.parseInput()
    // Converts a time-string such as <code>1:00pm</code> to a date object with the appropriate
    // time set. Accepts most formats of time string.
    // (Time is in UTC time, adjusted by +link{Time.UTCHoursOffset} if appropriate).
    // @param string (string) time string to convert to a date
    // @visibility external
    //<    
    // EXTREMELY forgiving of formatting, can accept the following:
	//		11:34:45 AM	=> 11:34:45
	//		1:3:5 AM	=> 01:30:50
	//		1:3p		=> 13:30:00
	//		11 34 am	=> 11:34:00
	//		11-34		=> 11:34:00
	//		113445		=> 11:34:45
	//		13445		=> 01:34:45
	//		1134		=> 11:34:00
	//		134			=> 01:34:00
	//		11			=> 11:00:00
	//		1p			=> 13:00:00
	//		9			=> 09:00:00
    // Note: technically being passed "1:00" is ambiguous - could be AM or PM.
    // We always interpret as 24 hour clock (so <12 = AM) unless am/pm is actually passed in.
    // @param [validTime] (boolean) If passed, and the string passed in doesn't convert to
    // a valid time, return null rather than a date with time set to 00:00:00
    parseInput : function (string, validTime) {
        
        var hours = 0,
            minutes = 0,
            seconds = 0,
            // We don't currently extract milliseconds from a time-string. Instead we zero them
            // out for consistency across times created by this method.
            milliseconds = 0;
            
        // if we're passed a date we'll return a new date with the same time (h/m/s/ms, not the same
        // date).
        if (isc.isA.Date(string)) {
            hours = string.getUTCHours();
            // Knock off UTCHours offset here since we'll read it
            hours -= isc.Time.UTCHoursOffset;
            
            minutes = string.getUTCMinutes();
            seconds = string.getUTCSeconds();
            
            milliseconds = string.getMilliseconds();
        } else if (string) {
            
    		// iterate through the time expressions, trying to find a match
    		for (var i = 0; i < isc.Time._timeExpressions.length; i++) {
    			var match = isc.Time._timeExpressions[i].exec(string);
    			if (match) break;
    		}
    
            if (match) {
        		// get the hours, minutes and seconds from the match
        		// NOTE: this results in 24:00 going to 23:00 rather than 23:59...
        		var hours = Math.min(parseInt(match[1]|0, 10),23),
        			minutes = Math.min(parseInt(match[2]|0, 10),59),
        			seconds = Math.min(parseInt(match[3]|0, 10),59),
        			ampm = match[4];
        		;
                if (ampm) {
                    if (!this._pmStrings) this._pmStrings = {p:true, P:true, pm:true, PM:true, Pm:true};
                    if (this._pmStrings[ampm]) {
                        if (hours < 12) hours += 12;
                        } else if (hours == 12) hours = 0;
                }
            } else if (validTime) return null;
        } else if (validTime) return null;
        
        var date = new Date();
        hours += isc.Time.UTCHoursOffset;
        
        // Catch the case where the UTC hours offset pushes the time past midnight or below zero
        // (Don't worry about the date - we're only interested in the time!)
        while (hours >= 24) hours -= 24;
        while (hours < 0) hours += 24;
                
        date.setUTCHours(hours);
        date.setUTCMinutes(minutes);
        date.setUTCSeconds(seconds);
        date.setMilliseconds(seconds);
        
        return date;
    },
    
     
    //> @classMethod Time.createDate()
    // Creates a date object with the time set to the hours, minutes and seconds passed in.
    // (Time is in UTC time, adjusted by +link{Time.UTCHoursOffset} if appropriate).
    // @param [hours] (number) Hours for the date (defaults to zero)
    // @param [minutes] (number) Minutes for the date (defaults to zero)
    // @param [seconds] (number) Seconds for the date (defaults to zero)
    // @visibility external
    //<    
    // Support millseconds granularity too, though probably never used
    createDate : function (hours, minutes, seconds, milliseconds) {
        var date = new Date();
        
        if (hours == null) hours = 0;
        else hours += isc.Time.UTCHoursOffset;

        // Catch the case where the UTC hours offset pushes the time past midnight or below zero
        while (hours >= 24) hours -= 24;      
        while (hours < 0) hours += 24;
        date.setUTCHours(hours);
        
        if (minutes == null) minutes = 0;
        date.setUTCMinutes(minutes);

        if (seconds == null) seconds = 0;
        date.setUTCSeconds(seconds);

        if (milliseconds == null) milliseconds = 0;
        date.setMilliseconds(milliseconds);
        return date;
    },
    
    //> @classMethod Time.setShortDisplayFormat()
    // Sets the default format for strings returned by +link{Time.toShortTime()}.
    // @param formatter (timeFormatter|function) Optional custom formatter to use. Will accept
    //  a function (which will be passed a pointer to the date to perform the conversion), or
    //  a string designating a standard formatter
    // @visibility external
    //<    
    setShortDisplayFormat : function (format) {
        this.shortDisplayFormat = format;
    },
    
    //> @classMethod Time.setNormalDisplayFormat()
    // Sets the default format for strings returned by +link{Time.toTime()}.
    // @param formatter (timeFormatter|function) Optional custom formatter to use. Will accept
    //  a function (which will be passed a pointer to the date to perform the conversion), or
    //  a string designating a standard formatter
    // @visibility external
    //<    
    setNormalDisplayFormat : function (format) {
        this.displayFormat = format;
    },
    
    //> @classMethod Time.compareTimes()
    // Compares the times of 2 dates, or strings. If a string is passed as one of the 
    // parameters it should be in a format that converts to a valid time such as <code>"1:30pm"</code>, 
    // <code>"13:30"</code>, or <code>"1:30:45pm"</code>
    // @param time1 (Date|string) First time to compare
    // @param time2 (Date|string) Second time to compare
    // @return (boolean) True if the times match, false if not
    // @visibility external
    //<    
    compareTimes : function (time1, time2) {
        // If this method becomes time-critical we could speed this up by avoiding the
        // date conversion and having parseInput return just an array of H,M,S
        if (isc.isA.String(time1)) time1 = isc.Time.parseInput(time1);
        if (isc.isA.String(time2)) time2 = isc.Time.parseInput(time2);
        
        if (time1 == null && time2 == null) return true;
        
        // If we get non-dates at this point just return false - we don't want to be
        // comparing other types
        if (!isc.isA.Date(time1) || !isc.isA.Date(time2)) return false;
        
        return ((time1.getUTCHours() == time2.getUTCHours()) && 
                (time1.getUTCMinutes() == time2.getUTCMinutes()) && 
                (time1.getUTCSeconds() == time2.getUTCSeconds()));
    }
    
});

