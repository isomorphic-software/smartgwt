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

 

// This file creates a mini-calendar that is used to pick a date, for example, you might have a
// button next to a form date field that brings this file up.




//>	@class	DateChooser
//
// Simple interactive calendar interface used to pick a date.
// Used by the +link{class:dateItem} class.
//
// @treeLocation Client Reference/Forms
// @visibility external
//<

// create a special canvas to show the days in a month
isc.ClassFactory.defineClass("DateChooser", "ButtonTable");

isc.DateChooser.addProperties({
    // an arbitrarily chosen, reasonable-looking size.  To improve on this, we need to switch
    // to a GridRenderer-based implementation, where we can get predictable-size square cells
	defaultWidth:150,	
	defaultHeight:171,		

    // Header
    // ---------------------------------------------------------------------------------------

	showHeader:true,

    //> @attr DateChooser.headerHeight (integer : 20 : IR)
    // Height of the header area (containing the next/previous month & year buttons) in pixels
    // @visibility external
    //<
	headerHeight:20,

    
	showYearButtons:true,
	showYearChooser:true,
	showMonthButtons:true,
	showMonthChooser:true,

    //> @attr DateChooser.skinImgDir (string : "images/common/" : IRWA)
    // Overridden directory where images for this widget (such as the month and year button icons)
    // may be found.
    // @visibility external
    //<
	skinImgDir:"images/common/",

    //> @attr DateChooser.prevYearIcon (URL : "[SKIN]doubleArrow_left.gif" : IR)
    // Icon for the previous year button
    // @see attr:DateChooser.showDoubleYearIcon
    // @visibility external
    //<
    prevYearIcon:"[SKIN]doubleArrow_left.gif",
    
    //> @attr DateChooser.prevYearIconWidth (integer : 14 : IR)
    // Width of the icon for the previous year button
    // @visibility external
    //<
    prevYearIconWidth:14,
    //> @attr DateChooser.prevYearIconHeight (integer : 7 : IR)
    // Height of the icon for the previous year button
    // @visibility external
    //<
    prevYearIconHeight:7,
    
    //> @attr DateChooser.prevMonthIcon (URL : "[SKIN]arrow_left.gif" : IR)
    // Icon for the previous month button
    // @visibility external
    //<
    prevMonthIcon:"[SKIN]arrow_left.gif",
    
    //> @attr DateChooser.prevMonthIconWidth (integer : 7 : IR)
    // Width of the icon for the previous month button
    // @visibility external
    //<
    prevMonthIconWidth:7,
    
    //> @attr DateChooser.prevMonthIconHeight (integer : 7 : IR)
    // Height of the icon for the previous month button
    // @visibility external
    //<
    prevMonthIconHeight:7,
    
    //> @attr DateChooser.nextYearIcon (URL : "[SKIN]doubleArrow_right.gif" : IR)
    // Icon for the next year button
    // @see attr:DateChooser.showDoubleYearIcon
    // @visibility external
    //<
    nextYearIcon:"[SKIN]doubleArrow_right.gif",

    //> @attr DateChooser.nextYearIconWidth (integer : 14 : IR)
    // Width of the icon for the next year button
    // @visibility external
    //<
    nextYearIconWidth:14,    
    
    //> @attr DateChooser.nextYearIconHeight (integer : 7 : IRW)
    // Height of the icon for the next year button
    // @visibility external
    //<
    nextYearIconHeight:7,
    
    //> @attr DateChooser.nextMonthIcon (URL : "[SKIN]arrow_right.gif" : IRW)
    // Icon for the next month button
    // @visibility external
    //< 
    nextMonthIcon:"[SKIN]arrow_right.gif",
    
    //> @attr DateChooser.nextMonthIconWidth (integer : 7 : IRW)
    // Width of the icon for the next month button
    // @visibility external
    //<
    nextMonthIconWidth:7,
    
    //> @attr DateChooser.nextMonthIconHeight (integer : 7 : IRW)
    // Height of the icon for the next month button
    // @visibility external
    //<
    nextMonthIconHeight:7,
    
    //> @attr DateChooser.showDoubleYearIcon (boolean : true : IRW)
    // If this property is set to true the previous and next year buttons will render out the 
    // previous and next month button icons twice rather than using the
    // +link{dateChooser.prevYearIcon} and +link{dateChooser.nextYearIcon}.
    // <P>
    // Set to <code>true</code> by default as not all skins contain media for the year icons.
    // @visibility external
    //<
    // This is really for back-compat (pre 6.1).
    // We intend to set this to true and provide year icon media in all skins we provide from this
    // point forward, but we don't want to break existing customized skins
    showDoubleYearIcon:true,

    // Pop-up Year & Month Pickers
    // ---------------------------------------------------------------------------------------
    
    //> @attr DateChooser.yearMenuStyle (CSSStyleName : "dateChooserYearMenu" : IR)
    // Style for the pop-up year menu.
    // @visibility external
    //<
    yearMenuStyle:"dateChooserYearMenu",

    
	startYear:1990,
	endYear:2010,

    //> @attr DateChooser.monthMenuStyle (CSSStyleName : "dateChooserMonthMenu" : IR)
    // Style for the pop-up year menu.
    // @visibility external
    //<
    monthMenuStyle:"dateChooserMonthMenu",
    
    // Today / Cancel Buttons
    // ---------------------------------------------------------------------------------------
    
    //> @attr DateChooser.showTodayButton (boolean : true : IRW)
    // Determines whether the "Today" button will be displayed, allowing the user to select 
    // the current date.
    // @visibility external
    //<
	showTodayButton:true,

    //> @attr DateChooser.showCancelButton (boolean : false : IRW)
    // Determines whether the "Cancel" button will be displayed.
    // @visibility external
    //<    
	showCancelButton:false,
    
    //> @attr DateChooser.todayButtonTitle  (string:"Today":IRW)
    // Title for "Today" button.
    // @group i18nMessages
    // @visibility external
    //<
    todayButtonTitle:"Today",
    
    //> @attr DateChooser.cancelButtonTitle  (string:"Cancel":IRW)
    // Title for the cancellation button.
    // @group i18nMessages
    // @visibility external
    //<
    cancelButtonTitle:"Cancel",
 
    //> @attr DateChooser.todayButtonHeight  (integer:null:IRW)
    // If set specifies a fixed height for the Today and Cancel buttons.
    // @visibility external
    //<
    //todayButtonHeight:null,
    
    // Weekends   
    // ---------------------------------------------------------------------------------------

    //> @attr DateChooser.disableWeekends (boolean : false : IR)
    // Whether it should be valid to pick a weekend day.  If set to true, weekend days appear
    // in disabled style and cannot be picked. 
    // <P>
    // Which days are considered weekends is controlled by +link{Date.weekendDays}.
    //
    // @visibility external
    //<
    disableWeekends: false,
    
    //> @attr dateChooser.showWeekends (boolean : true : IR)
    // Whether weekend days should be shown.  Which days are considered weekends is controlled
    // by +link{Date.weekendDays}.
    //
    // @visibility external
    //<
    showWeekends: true,
    
    //> @attr DateChooser.firstDayOfWeek  (integer : 0 : IR)
    // Day of the week to show in the first column.  0=Sunday, 1=Monday, ..., 6=Saturday.
    // @group appearance
    // @visibility external
    //<
    
    firstDayOfWeek:0,

    // Initial value   
    // ---------------------------------------------------------------------------------------

	year:new Date().getFullYear(),		// full year number
	month:new Date().getMonth(),		// 0-11
	chosenDate:new Date(),	// JS date object -- defaults to today

    // Day Buttons styling
    // ---------------------------------------------------------------------------------------

    //> @attr DateChooser.baseButtonStyle (string:"dateChooserButton":IRW)
    // Base css style applied to this picker's buttons. Will have "Over", "Selected" and "Down"
    // suffix appended as the user interacts with buttons.
    // @visibility external
    //< 
	baseButtonStyle:"dateChooserButton",

    //> @attr DateChooser.baseWeekdayStyle (string:null:IRW)
    // Base css style applied to weekdays. Will have "Over", "Selected" and "Down"
    // suffix appended as the user interacts with buttons.  Defaults to +link{baseButtonStyle}.
    // @visibility external
    //<    

    //> @attr DateChooser.baseWeekendStyle (string:null:IRW)
    // Base css style applied to weekends. Will have "Over", "Selected" and "Down"
    // suffix appended as the user interacts with buttons.  Defaults to +link{baseWeekdayStyle}.
    // @visibility external
    //<    

    //> @attr DateChooser.alternateWeekStyles (boolean:null:IRW)
    // Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style
    // for alternate rows will have +link{alternateStyleSuffix} appended to it.
    // @visibility external
    //<    

    //> @attr DateChooser.alternateStyleSuffix (string:"Dark":IRW)
    // The text appended to the style name when using +link{alternateWeekStyles}.
    // @visibility external
    //<    
    alternateStyleSuffix:"Dark",
    
    //> @attr DateChooser.headerStyle (string:"dateChooserButtonDisabled":IRW)
    // CSS style applied to the day-of-week headers. By default this applies to all days of the 
    // week. To apply a separate style to weekend headers, set +link{DateChooser.weekendHeaderStyle}
    // 
    // @visibility external
    //<    
	headerStyle:"dateChooserButtonDisabled",
    
    //> @attr DateChooser.weekendHeaderStyle (string:null:IRW)
    // Optional CSS style applied to the day-of-week headers for weekend days. If unset 
    // +link{DateChooser.headerStyle} will be applied to both weekdays and weekend days.
    // @visibility external
    //<    
	//weekendHeaderStyle:null,
    
    //> @attr DateChooser.baseNavButtonStyle (CSSClassName : null : IRW)
    // CSS style to apply to navigation buttons and date display at the top of the
    // component. If null, the CSS style specified in +link{baseButtonStyle} is used.
    // @visibility external
    //< 

    //> @attr DateChooser.baseBottomButtonStyle (CSSClassName : null : IRW)
    // CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and
    // "Cancel").  If null, the CSS style specified in +link{baseButtonStyle} is used.
    // @visibility external
    //< 


    
    useBackMask:true,
    
    canFocus:true    
});

//!>Deferred
isc.DateChooser.addMethods({

    // Override show() to show the clickMask if autoClose is true
    // Note: If we're showing this date chooser in a separate window, this is unnecessary, as the
    // user will be unable to click on any part of the window that isn't covered by the date-chooser
    // but will do no harm.
    show : function () {
        var returnVal = this.Super("show", arguments);
        
        if (this.autoClose) {
			this.showClickMask(this.getID()+".close()",true);		
        	this.bringToFront();
        }
    },
        
    // picker interface

    //> @method dateChooser.setData()
    // Set the picker to show the given date.
    // 
    // @param date (Date) new value
    // @visibility external
    //<
    setData : function (data) {
        //if (!this.callingFormItem) return;
        if (!isc.isA.Date(data)) data = new Date();

        this.year = data.getFullYear();
        this.month = data.getMonth();
        this.chosenDate = data;
        this.markForRedraw();
    },

    //> @method dateChooser.getData()
    // Get the current value of the picker.
    // <P>
    // See +link{dataChanged()} for how to respond to the user picking a date.
    //
    // @return (Date) current date
    // @visibility external
    //<
    getData : function () {
        return this.lastSelectedDate || this.chosenDate;
    },    

	getInnerHTML : function () {
		if (!this.showHeader) this.headerHeight = 0;

        this.baseWeekdayStyle = this.baseWeekdayStyle || this.baseButtonStyle;
        this.baseWeekendStyle = this.baseWeekendStyle || this.baseWeekdayStyle;
        var baseHeaderStyle = this.baseNavButtonStyle || this.baseButtonStyle;

		// create a table to show the days in the month
		var d = new Date(this.year, this.month, 1),
			displayDate = new Date(this.year, this.month, 1),
			output = isc.SB.create();

		if (this.showHeader) {
			// output a row with the month/year and arrows
			output.append("<TABLE WIDTH=100%",
                          " HEIGHT=" , (this.headerHeight+1), 
                          " CELLSPACING=", this.cellSpacing, 
                          " CELLPADDING=", this.cellPadding, 
                          " BORDER=" , this.cellBorder , "><TR>");

			if (this.showYearButtons) {
                var prevYearIconHTML;
                if (this.showDoubleYearIcon) {
                    var monthIconHTML = this.imgHTML(this.prevMonthIcon, this.prevMonthIconWidth,
                                                             this.prevMonthIconHeight);
                    prevYearIconHTML = disableNextYear ? "&nbsp;" :
                                       "<NOBR>"+ monthIconHTML + monthIconHTML + "<\/NOBR>";
                } else {
                    prevYearIconHTML = disableNextYear ? "&nbsp;" :
                                            this.imgHTML(this.prevYearIcon, this.prevYearIconWidth,
                                                             this.prevYearIconHeight);
                }
				output.append(this.getCellButtonHTML(prevYearIconHTML, 
                                                     this.getID()+".showPrevYear()", 
                                                     baseHeaderStyle,
                                                     null, null, isc.Canvas.CENTER,
                                                     " WIDTH=15"));
			}
			if (this.showMonthButtons) {
				output.append(
                        this.getCellButtonHTML(this.imgHTML(this.prevMonthIcon,
                                                             this.prevMonthIconWidth,
                                                             this.prevMonthIconHeight),
                                               this.getID()+".showPrevMonth()", 
                                               baseHeaderStyle, null, null,
                                               isc.Canvas.CENTER, 
                                               " WIDTH=15"));
			}
			if (this.showMonthChooser) {
				output.append(
                        this.getCellButtonHTML(displayDate.getShortMonthName(), 
                                               this.getID()+".showMonthMenu()", 
                                               baseHeaderStyle, 
                                               null, null,
                                               isc.Canvas.RIGHT, 
                                               " WIDTH=50%"));
			} else {
				output.append(
                        this.getCellHTML(displayDate.getShortMonthName(), 
                                         baseHeaderStyle + "Disabled"));
			}
			if (this.showYearChooser) {
				output.append(
                        this.getCellButtonHTML(displayDate.getFullYear(), 
                                               this.getID()+".showYearMenu()", 
                                               baseHeaderStyle, null, null,  
                                               isc.Canvas.LEFT, " WIDTH=50%"));
			} else {
				output.append(
                        this.getCellHTML(displayDate.getShortFullName(), 
                                         baseHeaderStyle + "Disabled"));			
			}
			if (this.showMonthButtons) {
                var disableNextMonth =
                    (displayDate.getFullYear() == 9999 && displayDate.getMonth() == 11);
				output.append(
                        this.getCellButtonHTML(disableNextMonth ? "&nbsp;" :
                                                this.imgHTML(this.nextMonthIcon,
                                                             this.nextMonthIconWidth,
                                                             this.nextMonthIconHeight), 
                                               disableNextMonth ? "" :
                                                this.getID()+".showNextMonth()", 
                                               baseHeaderStyle, null,
                                               disableNextMonth ? true : null,
                                               isc.Canvas.CENTER, 
                                               " WIDTH=15"));
			}
			if (this.showYearButtons) {
                var disableNextYear = displayDate.getFullYear() == 9999;
                var nextYearIconHTML;
                if (this.showDoubleYearIcon) {
                    var monthIconHTML = this.imgHTML(this.nextMonthIcon, this.nextMonthIconWidth,
                                                             this.nextMonthIconHeight);
                    nextYearIconHTML = disableNextYear ? "&nbsp;" :
                                       "<NOBR>"+ monthIconHTML + monthIconHTML + "<\/NOBR>";
                } else {
                    nextYearIconHTML = disableNextYear ? "&nbsp;" :
                                            this.imgHTML(this.nextYearIcon,
                                                         this.nextYearIconWidth,
                                                         this.nextYearIconHeight);
                }
				output.append(
                        this.getCellButtonHTML(nextYearIconHTML,
                                               disableNextYear ? "" :
                                                this.getID()+".showNextYear()",
                                               baseHeaderStyle,
                                               null, 
                                               disableNextYear ? true : null,
                                               isc.Canvas.CENTER, " WIDTH=15"));
			}
			output.append("<\/TR><\/TABLE>");
		}

		output.append("<TABLE WIDTH=100% HEIGHT=" , (this.getHeight()-this.headerHeight) , 
                      " CELLSPACING=0 CELLPADDING=2 BORDER=", this.cellBorder,">");

		// write the day-of-week headers (starting with firstDayOfWeek)
		output.append("<TR><TR HEIGHT=15>");
        var dayNames = this.getDayNames();
        var weekEnds = Date.getWeekendDays();
        for (var i = 0; i < dayNames.length; i++) {
            // if we're not showing weekends, don't create weekend cells
            var weekend = weekEnds.contains(i)
            if (weekend && !this.showWeekends) continue;
            var headerStyle = (weekend && this.weekendHeaderStyle) ? this.weekendHeaderStyle 
                                                                    : this.headerStyle;
            
            output.append(
                this.getCellHTML("<B>"+dayNames[(i + this.firstDayOfWeek) %7]+"</B>", 
                                     headerStyle)
            );
        }
        output.append("<\/TR>");
            
		// go back to the first day of the week for the start date
        displayDate.setDate(displayDate.getDate()
            - displayDate.getDay()
            + this.firstDayOfWeek
            // start date may have a lower "day number" (sun=0 thru sat=6) than firstDayOfWeek,
            // in which case we need to adjust back by a week
            - ((displayDate.getDay() < this.firstDayOfWeek) ? 7 : 0)
        );
        
        var earlyFinish;
        var isAlternateRow = false;
		while (true) {        
            if (this.alternateWeekStyles) isAlternateRow = !isAlternateRow;

			output.append("<TR>");
			for (var i = 0; i < 7; i++) {
                // if !showWeekends, make sure not to create them
                if (! (!this.showWeekends && weekEnds.contains(i))) {
                    var baseStyle = (i > 0 && i < 6) ? this.baseWeekdayStyle :
                                                       this.baseWeekendStyle;
                    if (isAlternateRow) baseStyle += this.alternateStyleSuffix;
                    output.append(this.getDayCellButtonHTML((earlyFinish?null:displayDate), 
                                                            baseStyle));
                }
                // In IE6 (resolved in IE7) you can crash the browser by attempting to
                // set a date to a value higher than Dec 31 9999
                // Just disallow this in all browsers
                if (this.year == 9999 && this.month == 11 && displayDate.getDate() == 31) {
                    earlyFinish = true;
                } else {
                    displayDate.setDate(displayDate.getDate()+1);
                }
			}
			output.append("<\/TR>");
                        
			if (displayDate.getMonth() != this.month || earlyFinish) break;
		}
        
        if (this.showTodayButton || this.showCancelButton) {
            
            output.append("<TR");
            if (this.todayButtonHeight != null) output.append(" HEIGHT=", this.todayButtonHeight);
            output.append(">");
            // if we're supposed to show today or cancel buttons, do so
            if (this.showTodayButton) {
                var colSpan = !this.showCancelButton ? (this.showWeekends ? 7 : 5)
                                                      : (!this.showWeekends ? 3 : 4);
                output.append(this.getCellButtonHTML(
                                    this.todayButtonTitle,
                                    this.getID()+".dateClick(" + new Date().getFullYear() + "," + 
                                                                 new Date().getMonth() + "," + 
                                                                 new Date().getDate() + ")",
                                    this.baseBottomButtonStyle || this.baseButtonStyle,null, null,
                                    isc.Canvas.CENTER,
                                    " COLSPAN=" + colSpan
                                )
                            );
            }
    
            // if we're supposed to show today or cancel buttons, do so
            if (this.showCancelButton) {
                var colSpan = !this.showTodayButton ? (this.showWeekends ? 7 : 5)
                                                     : (!this.showWeekends ? 2 : 4);
                output.append(this.getCellButtonHTML(
                                    this.cancelButtonTitle,
                                    this.getID() + ".close()",
                                    this.baseBottomButtonStyle || this.baseButtonStyle,null, null,
                                    isc.Canvas.CENTER,
                                    " COLSPAN=" + colSpan
                                )
                            );
            }
            output.append("<\/TR>");
        }
		// end the table
		output.append("<\/TABLE>");
		return output.toString();
	},

    getDayNames : function () {
        if (isc.DateChooser._dayNames == null) {
            // Don't hard-code day-names -- we need them to be localizeable
            // isc.DateChooser._dayNames = ["Su", "Mo","Tu", "We", "Th", "Fr", "Sa"]
            var dateObj = new Date();
            isc.DateChooser._dayNames = Date.getShortDayNames(2);
        }
        return isc.DateChooser._dayNames;
    },

	getDayCellButtonHTML : function (date, style, state) {
        // null date == Special case for dates beyond 9999
        // This limit is enforced due to dates greater than 9999 causing a browser crash in IE
        // - also our parsing logic assumes a 4 digit date
        if (date == null) 
            return this.getCellButtonHTML("&nbsp;", null, style, false, false, isc.Canvas.CENTER);
        
		var selected = (this.chosenDate && (date.toShortDate() == this.chosenDate.toShortDate())),
            disabled = (date.getMonth() != this.month);

		var action = this.getID() + ".dateClick(" + date.getFullYear() + ","
                     + date.getMonth() + "," + date.getDate() + ");";
        // check for weekends
        if (this.disableWeekends && Date.getWeekendDays().contains(date.getDay())) {
            disabled = true;
            action = "return false;";
        }
		return this.getCellButtonHTML(date.getDate(), action, style, selected, disabled, isc.Canvas.CENTER);
	},

    dateIsSelected : function (date) {
		return null
	},
    
	showPrevMonth : function () {
		if (--this.month == -1) {
			this.month = 11;
			this.year--;
		}
		this.markForRedraw();
	},

	showNextMonth : function () {
		if (++this.month == 12) {
			this.month = 0;
			this.year++;
		}
		this.markForRedraw();
	},

	showMonth : function (monthNum) {
		this.month = monthNum;
		if (this.monthMenu) this.monthMenu.hide();
		this.markForRedraw();
	},

	showMonthMenu : function () {
		if (!this.monthMenu) {
			// create the menu items using the date.getShortMonthName() for internationalization
			var monthItems = [[]],
				date = new Date(2001,0,1);
			for (var i = 0; i < 12; i++) {
				date.setMonth(i);
				monthItems[monthItems.length-1].add(
									{	contents:date.getShortMonthName(),
										action:this.getID()+".showMonth("+i+")"
									}
					);
				if ((i+1)%3 == 0) monthItems.add([]);
			}
			this.monthMenu = isc.ButtonTable.newInstance({
                styleName:this.monthMenuStyle,
				left:this.getPageLeft()+5,
				top:this.getPageTop()+this.headerHeight,
				width:Math.min(this.getWidth(), 120),
				height:Math.min(this.getHeight()-this.headerHeight, 80),
				items:monthItems,
				visibility:isc.Canvas.HIDDEN,
				baseButtonStyle:this.baseButtonStyle
			});
            // (autoDraw is true, so it is drawn, with visibility hidden at this point)
			this.monthMenu.setPageLeft(this.getPageLeft() + ((this.width - this.monthMenu.width)/2));
		} else {
            // L, T, W, H
            var top = this.getPageTop()+this.headerHeight,
				width = Math.min(this.getWidth(), 120),
				height = Math.min(this.getHeight()-this.headerHeight, 80),
                left = this.getPageLeft() + ((this.width - width)/2)

            this.monthMenu.setPageRect(left, top, width, height);
        }
        
        // We show the month menu modally.  This means if the user clicks outside it, we
        // will not allow the click to carry on down, so it will hide the month menu (and then
        // dismiss the monthMenu's click mask), but won't fire the click action on the 
        // DateChooser's click mask and hide the entire date chooser.
        // As with all modal clickMasks, for us to float the month menu above it, we need the
        // month menu to be a top-level element (which is how it's currently implemented)
		this.monthMenu.showModal();
	},

	showPrevYear : function () {
		this.year--;
		this.markForRedraw();
	},

	showNextYear : function () {
		this.year++;
		this.markForRedraw();
	},

	showYear : function (yearNum) {
		this.year = yearNum;
		if (this.yearMenu) this.yearMenu.hide();
		this.markForRedraw();
	},

	showYearMenu : function () {
		if (!this.yearMenu) {
			var yearItems = [[]];
			for (var i = 0; i <= (this.endYear-this.startYear); i++) {
				var year = i+this.startYear;
				yearItems[yearItems.length-1].add({contents:year,
									action:this.getID()+".showYear("+year+")"
								});
				if ((i+1)%3 == 0) yearItems.add([]);
			}
			this.yearMenu = isc.ButtonTable.newInstance({
                styleName:this.yearMenuStyle,
				top:this.getPageTop()+this.headerHeight,
				width:Math.min(this.getWidth(), 120),
				height:Math.min(this.getHeight()-this.headerHeight, 80),
				items:yearItems,
				visibility:isc.Canvas.HIDDEN,
				baseButtonStyle:this.baseButtonStyle
			});
            // (autoDraw is true, so it is drawn, with visibility hidden at this point)
			this.yearMenu.setPageLeft(this.getPageLeft() + ((this.width - this.yearMenu.width)/2));

		} else {
            // L, T, W, H
            var top = this.getPageTop()+this.headerHeight,
				width = Math.min(this.getWidth(), 120),
				height = Math.min(this.getHeight()-this.headerHeight, 80),
                left = this.getPageLeft() + ((this.width - width)/2)

            this.yearMenu.setPageRect(left, top, width, height);
        }
        
		//XXX it'd be nice to hilite the current year somehow...
		this.yearMenu.showModal();
	},

	dateClick : function (year, month, day) {
		var date = this.lastSelectedDate = new Date(year, month, day);

        this.dataChanged();

    	if (window.dateClickCallback) {
			// if it's a string, normalize it to a function
			if (isc.isA.String(window.dateClickCallback)) {
                window.dateClickCallback = new Function("date",window.dateClickCallback);
            }
			// and call it, passing the date
			window.dateClickCallback(date)
		}

        if (this.autoHide) this.hide();
		if (this.autoClose) this.close();
		return date;
	},
    
    // Observable dataChanged function (fired from dateClick)

    //> @method dateChooser.dataChanged()
    // Method to override or observe in order to be notified when a user picks a date value.
    // <P>
    // Has no default behavior (so no need to call Super).
    // <P>
    // Use +link{getData()} to get the current date value.
    // 
    // @visibility external
    //<
    dataChanged : function () {
    },
    
    close : function () {
        this.hideClickMask();
        if (this.yearMenu && this.yearMenu.isVisible()) this.yearMenu.hide();
        if (this.monthMenu && this.monthMenu.isVisible()) this.monthMenu.hide();
        if (this.isDrawn()) this.clear();
    }

});
//!<Deferred




// For efficiency we want to re-use a single date-chooser widget in most cases.
// Add a class method for this
isc.DateChooser.addClassMethods({
    
    // getSharedDateChooser()   Simple method to return a standard date chooser.
    // Used by the DateItem
    getSharedDateChooser : function (properties) {

        if (!this._globalDC) {
        
            this._globalDC = this.create(properties, {
                
                _generated:true,
                // When re-using a DateChooser, we're almost certainly displaying it as a 
                // floating picker rather than an inline element. Apply the common options for 
                // a floating picker
                autoHide:true,
                showCancelButton:true
                
            });
            
            return this._globalDC;
        }
        
        isc.addProperties(this._globalDC, properties);
        return this._globalDC;
    }
    
});
