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




//>	@class	Calendar
// The Calendar component provides several different ways for a user to view and edit a set of
// events. Note that the <b>ISC_Calendar.js</b> module must be loaded to make use of the Calendar
// class.
// <P>
// <b>CalendarEvents</b>
// <P>
// Events are represented as ordinary JavaScript Objects (see +link{CalendarEvent}).  The
// Calendar expects to be able to read and write a basic set of properties on events: name,
// startDate, endDate, description, etc, which can be stored under configurable property names
// (see eg +link{calendar.startDateField}.
// <P>
// Much like a +link{ListGrid} manages it's ListGridRecords, the Calendar can either be passed
// a ordinary Array of CalendarEvents or can fetch data from a DataSource.
// <P>
// If the calendar is bound to a DataSource, event changes by user action or by calling methods
// will be saved to the DataSource.
// <P>
// <b>Navigation</b>
// <P>
// The calendar supports a +link{calendar.weekView,WeekView}, +link{calendar.dayView,DayView}
// and +link{calendar.monthView,MonthView} by default.  The user can navigate using back and
// forward buttons or via an attached +link{calendar.dateChooser,DateChooser}.
// <P>
// <b>Event Manipulation</b>
// <P>
// Events can be created via clicking on the day, week or month views, or via the "Add Event"
// button.  In the day and week views, the user may click and drag to create an event of a
// specific duration.
// <P>
// Creating an event via click or click and drag pops up the
// +link{calendar.eventDialog,EventDialog}, which provides a simple form for quick event
// entry (only one field, the description, is required by default).  
// <P>
// A separate editor called the +link{calendar.eventEditor,EventEditor} provides an interface
// for editing all possible properties of an event, including custom properties.  The
// EventEditor is used whenever a pre-existing event is being edited, and can also be invoked
// by the user wherever the simpler EventDialog appears.
// <P>
// Events can also be programmatically +link{calendar.addEvent,added},
// +link{calendar.removeEvent,removed}, or +link{calendar.updateEvent,updated}.  
//  
// @implements DataBoundComponent
// @treeLocation  Client Reference/Calendar
// @example simpleCalendar
// @visibility calendar
//<
isc.ClassFactory.defineClass("Calendar", "Canvas");

isc.Calendar.addProperties({

defaultWidth: "100%",
defaultHeight: "100%",

year:new Date().getFullYear(),		// full year number
month:new Date().getMonth(),		// 0-11

//> @attr calendar.chosenDate  (Date : 'Today' : IR)
// The date for which events are displayed in the day, week, and month tabs of the calendar
// Default is today.
//
// @group date
// @setter calendar.setChosenDate()
// @visibility calendar
//<
chosenDate:new Date(),	

//> @attr calendar.firstDayOfWeek  (Number : 0 : IRW)
// The numeric day (0-6) which the calendar should consider as the first day of the week
//
// @group date
// @visibility calendar
//<
firstDayOfWeek:0,

//> @attr calendar.baseStyle  (CSSStyleName : "calendar" : IRW)
// The base name for the CSS class applied to the grid cells of the day and week views
// of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
// appended to it according to the state of the cell.
//
// @group appearance
// @visibility calendar
//<
baseStyle: "calendar",

//> @attr calendar.dayHeaderBaseStyle  (CSSStyleName : "calMonthDayHeader" : IRW)
// The base name for the CSS class applied to the day headers of the month view.
// This style will have "Dark", "Over", "Selected", or "Disabled"
// appended to it according to the state of the cell.
//
// @group appearance
// @visibility calendar
//<
dayHeaderBaseStyle: "calMonthDayHeader",

//> @attr calendar.dayBodyBaseStyle  (CSSStyleName : "calMonthDayBody" : IRW)
// The base name for the CSS class applied to the day body of the month view
// of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
// appended to it according to the state of the cell.
//
// @group appearance
// @visibility calendar
//<
dayBodyBaseStyle: "calMonthDayBody",

//> @attr calendar.otherDayHeaderBaseStyle  (CSSStyleName : "calMonthDayHeader" : IRW)
// The base name for the CSS class applied to the day headers of the month view.
// This style will have "Dark", "Over", "Selected", or "Disabled"
// appended to it according to the state of the cell.
//
// @group appearance
// @visibility calendar
//<
otherDayHeaderBaseStyle: "calMonthOtherDayHeader",

//> @attr calendar.otherDayBodyBaseStyle  (CSSStyleName : "calMonthDayBody" : IRW)
// The base name for the CSS class applied to the day body of the month view
// of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
// appended to it according to the state of the cell.
//
// @group appearance
// @visibility calendar
//<
otherDayBodyBaseStyle: "calMonthOtherDayBody",

//> @attr calendar.otherDayBlankStyle (CSSStyleName : "calMonthOtherDayBlank" : IR)
// In the month CSS style applied to both the header and body of days from other months when
// +link{showOtherDays} is false.
//
// @group appearance
// @visibility calendar
//<
otherDayBlankStyle: "calMonthOtherDayBlank",

//> @attr calendar.selectedCellStyle  (CSSStyleName : "calendarCellSelected" : IRW)
// The base name for the CSS class applied to a cell that is selected via a mouse drag.
//
// @group appearance
// @visibility calendar
//<
selectedCellStyle: "calendarCellSelected",

//> @attr calendar.eventWindowStyle  (CSSStyleName : "eventWindow" : IRW)
// The base name for the CSS class applied to event windows within calendars.
// This style will have "Header", "HeaderLabel", and "Body" appended to it, according to 
// which part of the event window is being styled. For example, to style the header, define
// a css class called 'eventWindowHeader'.
//  
// @group appearance
// @visibility calendar
//<
eventWindowStyle: "eventWindow",

calMonthEventLinkStyle: "calMonthEventLink",

// workday properties
//---------------------------------------------------------------------------------------------

//> @attr calendar.workdayBaseStyle (CSSStyleName : "calendarWorkday" : IR)
// If +link{showWorkday} is set, style used for cells that are within the workday, as defined by
// +link{workdayStart} and +link{workdayEnd}.
//
// @group workday, appearance
// @visibility calendar
//<
workdayBaseStyle: "calendarWorkday",

//> @attr calendar.workdayStart (Time : "9:00am" : IR)
// When using +link{showWorkday}:true, <code>workdayStart</code> and <code>workdayEnd</code>
// specify the time of day when the workday starts and ends, specified as a
// String acceptable to +link{Time.parseInput()}.
// <P>
// Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
//
// @group workday, date
// @visibility calendar
//<
workdayStart: "9:00am",

//> @attr calendar.workdayEnd (Time : "5:00pm" : IR)
// @include calendar.workdayStart
//
// @group workday, date
// @visibility calendar
//<
workdayEnd: "5:00pm",

//> @attr calendar.showWorkday (boolean : false : IR)
// If set, causes the calendar to use +link{workdayBaseStyle}
// for cells falling within the workday as defined by +link{workdayStart} and +link{workdayEnd},
// in both the +link{weekView} and +link{dayView}.
//
// @group workday
// @visibility calendar
//<
showWorkday: false,

//> @attr calendar.scrollToWorkday (boolean : false : IR)
// If set, causes the +link{workdayStart,workday hours} to be sized to fill the available space
// in the day view and weeek view, and automatically scrolls these views to the start of the
// workday when the calendar is first displayed and whenever the user switches to a new day or
// week.
//
// @group workday
// @visibility calendar
//<
scrollToWorkday: false,

// ---------------------------------------------------------------------------------------

//> @attr calendar.nameField  (String : "name" : IR)
// The name of the name field in a +link{CalendarEvent}.
// 
// @group calendarEvent
// @visibility calendar
// @see CalendarEvent
//<
nameField: "name",

//> @attr calendar.descriptionField  (String : "description" : IR)
// The name of the description field in a +link{CalendarEvent}.
//
// @group calendarEvent
// @visibility calendar
//<
descriptionField: "description",

//> @attr calendar.startDateField  (String : "startDate" : IR)
// The name of the start date field in a +link{CalendarEvent}.
//
// @group calendarEvent
// @visibility calendar
// @see CalendarEvent
//<
startDateField: "startDate",

//> @attr calendar.endDateField  (String : "endDate" : IR)
// The name of the end date field in a +link{CalendarEvent}.
//
// @group calendarEvent
// @visibility calendar
// @see CalendarEvent
//<
endDateField: "endDate",

//> @attr calendar.eventWindowStyleField (String : "eventWindowStyle" : IR)
// The name of the field used to override +link{calendar.eventWindowStyle} for an individual
// +link{CalendarEvent}.  See +link{calendarEvent.eventWindowStyle}.
//
// @group calendarEvent, appearance
// @visibility calendar
//<
eventWindowStyleField: "eventWindowStyle",

//> @attr calendar.canEditField  (String : "canEdit" : IR)
// Name of the field on each +link{CalendarEvent} that determines editability.
//
// @group calendarEvent
// @visibility calendar
// @see CalendarEvent
//<
canEditField: "canEdit",

//> @attr calendar.weekEventBorderOverlap (Boolean : false : IR)
// Augments the width of week event windows slightly to avoid duplicate adjacent borders
// between events.
//
// @group appearance
// @visibility calendar
//<
weekEventBorderOverlap: false,

// Event Editing
// ---------------------------------------------------------------------------------------

//> @attr calendar.eventSnapGap (Integer : 30 : IR)
// Determines how many minutes an event can be moved or resized by.
//
// @group editing
// @visibility calendar
//<
eventSnapGap: 30,

//> @attr calendar.showQuickEventDialog (Boolean : true : IR)
// Determines whether the quick event dialog is displayed when a time is clicked. If this is
// false, the full event editor is displayed.
//
// @group editing
// @visibility calendar
//<
showQuickEventDialog: true,

//> @attr calendar.eventEditorFields (Array of FormItem : see below : IR)
// The set of fields for the +link{calendar.eventEditor, event editor}.
// <p>
// The default set of fields are: 
// <pre>
//    {name: "startHours", title: "From", type: "select", width: 60},
//    {name: "startMinutes", showTitle: false, type: "select", width: 60},
//    {name: "startAMPM", showTitle: false, type: "select", width: 60},
//    {name: "invalidDate", type: "blurb", colSpan: 4, visible: false}
//    {name: "endHours", title: "To", type: "select", width: 60},
//    {name: "endMinutes", showTitle: false, type: "select", width: 60},
//    {name: "endAMPM", showTitle: false, type: "select", width: 60},
//    {name: "name", title: "Name", type: "text", colSpan: 4},
//    {name: "description", title: "Description", type: "textArea", colSpan: 4, height: 50}
// </pre>
// See the Customized Binding example below for more information on altering default datasource 
// fields within forms.
// 
// @group editing
// @example customCalendar
// @example validationFieldBinding
// @visibility calendar
//<

//> @attr calendar.eventDialogFields (Array of FormItem : see below : IR)
// The set of fields for the +link{calendar.eventDialog, event dialog}. 
// <p>
// The default set of fields are: 
// <pre>
//    {name: "name", title: "Event Name", type: nameType, width: 250 },
//    {name: "save", title: "Save Event", type: "SubmitItem", endRow: false},
//    {name: "details", title: "Edit Details", type: "button", startRow: false}
// </pre>
// See the Customized Binding example below for more information on altering default datasource 
// fields within forms.
//
// @group editing
// @example customCalendar
// @example validationFieldBinding
// @visibility calendar
//<

// Allowed operations
// ---------------------------------------------------------------------------------------

//> @groupDef allowedOperations
// 
// @title allowed operations
// @visibility external
//<

//> @attr calendar.canCreateEvents (Boolean : true : IR)
// If true, users can create new events
//
// @group allowedOperations
// @visibility calendar
//<
canCreateEvents: true,

//> @attr calendar.canEditEvents (Boolean : true : IR)
// If true, users can edit existing events
//
// @group allowedOperations
// @visibility calendar
//<
canEditEvents: true, 

//> @attr calendar.canDeleteEvents (Boolean : true : IR)
// If true, users can delete existing events. Defaults to +link{calendar.canEditEvents}
//
// @group allowedOperations
// @visibility calendar
//<
canDeleteEvents: true,

// Show / Hide parts of the interface
// ---------------------------------------------------------------------------------------

//> @attr calendar.showDateChooser (Boolean : true : IR)
// Determines whether the +link{calendar.dateChooser,dateChooser} is displayed.
//
// @group visibility
// @visibility calendar
//<
showDateChooser: false, 

//> @attr calendar.disableWeekends (boolean : true : IR)
// If set, weekend days appear in disabled style and events cannot be created on weekends.
// Which days are considered weekends is controlled by +link{Date.weekendDays}.
//
// @group visibility 
// @visibility calendar
//<
disableWeekends: true,

//> @attr calendar.showWeekends (boolean : true : IR)
// Suppresses the display of weekend days in the week and month views, and disallows the
// creation of events on weekends.  Which days are considered weekends is controlled by
// +link{Date.weekendDays}.
//
// @group visibility
// @visibility calendar
//<
showWeekends: true,

//> @attr calendar.showDayHeaders (boolean : true : IR)
// If false, the month view does not show day headers
//
// @group visibility
// @visibility calendar
//<
showDayHeaders: true,

//> @attr calendar.showOtherDays (boolean : true : IR)
// If set to true, in the month view, days that fall in an adjacent month are still shown with
// a header and body area, and are interactive.  Otherwise days from other months are rendered
// in the +link{otherDayBlankStyle} and are non-interactive.
//
// @group visibility
// @visibility calendar
//<
showOtherDays: true,

// ---------------------------------------------------------------------------------------

//> @attr calendar.invalidDateMessage (boolean : "From must be before To" : IR)
// The message to display in the +link{eventEditor} when the 'To' date is greater than
// the 'From' date and a save is attempted.
//
// @group i18n
// @visibility calendar
//<
invalidDateMessage: "From must be before To",

// AutoChildren
// ---------------------------------------------------------------------------------------

//> @attr calendar.dayView (AutoChild : null : R)
// Listgrid used to display events that pertain to a given day.
//
// @visibility calendar
//<

//> @attr calendar.weekView (AutoChild : null : R)
// Listgrid used to display events that pertain to a given week.
//
// @visibility calendar
//<

//> @attr calendar.monthView (AutoChild : null : R)
// Listgrid used to display events that pertain to a given month.
//
// @visibility calendar
//<

//> @attr calendar.dateChooser (AutoChild : null : R)
// +link{DateChooser} used to select the date for which events will be displayed.
//
// @visibility calendar
//<

//> @attr calendar.eventDialog (AutoChild : null : R)
// An autochild of type +link{Window} that displays a quick event entry form within a 
// popup window.
//
// @visibility calendar
//<

//> @attr calendar.eventEditorLayout (AutoChild : null : R)
// An autochild of type +link{Window} that displays the full 
// +link{calendar.eventEditor, event editor}
//
// @visibility calendar
//<

//> @attr calendar.eventEditor (AutoChild : null : R)
// An autochild of type +link{DynamicForm} which displays +link{CalendarEvent, event data}. 
// This form is created within the +link{calendar.eventEditorLayout,event editor layout}
//
// @visibility calendar
//<

//> @attr calendar.datePickerButton (AutoChild : null : IR) 
// The datePickerIcon is an ImgButton that appears above the week/day/month views of the
// calendar and offers alternative access to a +link{DateChooser} to pick the current day.
//
// @visibility calendar
//<  

//>	@attr calendar.data		(List of CalendarEvent : null : IRW)
// A List of CalendarEvent objects, specifying the data to be used to populate the
// calendar.  
// <p>
// This property will typically not be explicitly specified for databound Calendars, where
// the data is returned from the server via databound component methods such as
// +link{fetchData()}. In this case the data objects will be set to a 
// +link{class:ResultSet,resultSet} rather than a simple array.
//
// @group	data
// @see CalendarEvent
// @setter Calendar.setData()
// @visibility calendar
//<

// CalendarEvent
// ---------------------------------------------------------------------------------------

//> @object CalendarEvent
// An object which represents an event to occur at a specific time, displayed within the
// calendar.
//
// @group data
// @treeLocation Optional Modules/Calendar
// @visibility calendar
//<

//> @attr calendarEvent.startDate (Date : null : IRW)
// Date object which represents the start date of a +link{CalendarEvent}
// The name of this field within the CalendarEvent can be changed via 
// +link{Calendar.startDateField}
//
// @visibility calendar
//<

//> @attr calendarEvent.endDate (Date : null : IRW)
// Date object which represents the end date of a +link{CalendarEvent}
// The name of this field within the CalendarEvent can be changed via 
// +link{Calendar.endDateField}
//
// @visibility calendar
//<

//> @attr calendarEvent.name (String : null : IRW)
// String which represents name of a +link{CalendarEvent}
// The name of this field within the CalendarEvent can be changed via 
// +link{Calendar.nameField}
//
// @visibility calendar
//<

//> @attr calendarEvent.description (String : null : IRW)
// String which represents the description of a +link{CalendarEvent}
// The name of this field within the CalendarEvent can be changed via 
// +link{Calendar.descriptionField}
//
// @visibility calendar
//<

//> @attr calendarEvent.canEdit (String : null : IRW)
// Optional boolean value controlling the editability of this particular calendarEvent.
//  The name of this field within the CalendarEvent can be changed via 
//  +link{calendar.canEditField}.
//
// @visibility calendar
//<

//> @attr calendarEvent.eventWindowStyle (CSSStyleName : null : IR)
// CSS style series to use for the draggable event window that represents this event.  If
// specified, overrides +link{calendar.eventWindowStyle} for this specific event.
// <P>
// The name of this field within the CalendarEvent can be changed via 
// +link{Calendar.eventWindowStyleField}
//
// @visibility calendar
//<

// Fetching Data
// ---------------------------------------------------------------------------------------

//> @method calendar.fetchData()
// @include dataBoundComponent.fetchData()
// @group dataBoundComponentMethods
// @visibility calendar
// @example databoundFetch
//<

//>	@attr calendar.autoFetchData       (boolean : false : IR)
// @include dataBoundComponent.autoFetchData
// @group databinding
// @visibility calendar
// @example fetchOperation
//<

//> @attr Calendar.initialCriteria   (Criteria : null :IR)
// @include dataBoundComponent.initialCriteria
// @visibility calendar
//<

// ---------------------------------------------------------------------------------------

dayViewConstructor: "DaySchedule",

weekViewConstructor: "DaySchedule",

monthViewConstructor: "MonthSchedule",

mainViewDefaults : {
    _constructor:isc.TabSet,
    defaultWidth: "80%",
    defaultHeight: "100%",
    tabBarAlign: "right",
    selectedTab: 1    
},

dateChooserConstructor: "DateChooser",

eventDialogDefaults : {
    _constructor:isc.Window,
    showHeaderIcon: false,
    showMinimizeButton: false,
    showMaximumButton: false,
    canDragReposition: true,
    // so that extra fields are visible without the end user having to tweek bodyProperties
    overflow: "visible",
    bodyProperties: {overflow: "visible"},
    width: 400,
    height: 100
    
},

eventEditorDefaults : {
    _constructor:isc.DynamicForm,
    padding:4,
    numCols: 4,
    showInlineErrors: false,
    width: 200  
},

eventEditorLayoutDefaults : {
    _constructor:isc.Window,
    showHeaderIcon: false,
    showShadow: false,
    showMinimizeButton: false,
    showMaximumButton: false,
    canDragReposition: false    
},

addEventButtonDefaults : {
    _constructor: isc.ImgButton,
    title: "",
    src:"[SKINIMG]actions/add.png",    
    prompt:"Add an event",
    showRollOver: false, 
    showDown: false,
    showFocused:false,
    width: 16, 
    height: 16
},

datePickerButtonDefaults : {
    _constructor: isc.ImgButton,
    title: "",
    prompt: "Choose a date",
    src:"[SKIN]/controls/date_control.gif",
    width: 16, 
    height: 16,
    showRollOver: false,
    showFocused: false
},

controlsBarDefaults : {
    _constructor:isc.HLayout,
    defaultLayoutAlign:"center",
    height: 25,
    membersMargin: 5
},

previousButtonDefaults : {
    _constructor:isc.ImgButton,
    title: "", 
    prompt: "Previous",
    src:"[SKINIMG]actions/back.png",
    showFocused:false,
    width: 16, 
    height: 16,
    click: "this.creator.previous()",
    showRollOver: false, 
    showDown: false
},

nextButtonDefaults : {
    _constructor:isc.ImgButton,
    title: "", 
    prompt: "Next",
    src:"[SKINIMG]actions/forward.png", 
    showFocused:false,
    width: 16, 
    height: 16,
    click: "this.creator.next()",
    showRollOver: false, 
    showDown: false        
}, 

dateDisplayDefaults : {
    _constructor:isc.Label,
    wrap: false,
    autoFit: true,
    contents: "-"    
},

// initial setup of the calendar
initWidget : function () {
    this._setChosenWeek();
    this.createChildren();
    this._setWeekTitles();
   
   // initialize the data object, setting it to an empty array if it hasn't been defined
	this.setData(this.data ? null : this.getDefaultData());
    
},

getDefaultData : function () { return []; },

//>	@method	calendar.setData()    ([])
// Initialize the data object with the given array. Observes methods of the data object
// so that when the data changes, the calendar will redraw automatically.
// 
// @param	newData		(List of CalendarEvent)	data to show in the list
//
// @group	data
// @visibility calendar
//<
setData : function (newData) {
    
    // if the current data and the newData are the same, bail
	//	(this also handles the case that both are null)
	if (this.data == newData) return;

    
	// if we are currently pointing to data, stop observing it
	if (this.data) {
        this.ignore(this.data, "dataChanged");
        // if the data was autoCreated, destroy it to clean up RS<->DS links
        if (this.data._autoCreated && isc.isA.Function(this.data.destroy))
            this.data.destroy();
    }

	// if newData was passed in, remember it
	if (newData) this.data = newData;

	// if data is not set, bail
	if (!this.data) return;

	// observe the data so we will update automatically when it changes
	this.observe(this.data, "dataChanged", "observer.dataChanged()");
    if (this.hasData()) {
        // invoke dataChanged so calendar refreshes when passed new data
        this.dataChanged();
    }
},

//>	@method	calendar.getData()
// Get the data that is being displayed and observed
//
// @return	(object)	The data that is being displayed and observed
//<
getData : function () {
	return this.data;
},

hasData : function () {
    if (!this.data || 
        (isc.ResultSet && isc.isA.ResultSet(this.data) && !this.data.lengthIsKnown())) 
    {
        return false;
    } else {
        return true;
    }
},


dataChanged : function () {
    // see addEvent, updateEvent, deleteEvent, and comment above about _ignoreDataChanged
    if (this._ignoreDataChanged) {
        this.logDebug('dataChanged, ignoring','calendar');
        this._ignoreDataChanged = false;    
    } else {
        this.logDebug('dataChanged, refreshing', 'calendar');    
        this.refreshSelectedView();
    }
   
},

refreshSelectedView : function () {
    if (this.dayViewSelected()) {
        this.dayView.refreshEvents();
        this.monthView.refreshEvents();
    }
    else if (this.weekViewSelected()) {
        this.weekView.refreshEvents(); 
        this.monthView.refreshEvents();
    } else {
        this.monthView.refreshEvents();
    }
    
},

//> @method calendar.canEditEvent()
// Method called whenever the calendar needs to determine whether a particular event should be
// editable.
// <P>
// By default, checks the +link{canEditField} on the provided +link{CalendarEvent}, and if null,
// returns +link{canEditEvents}.
//
// @param event (CalendarEvent) 
// @return (boolean) whether the user should be allowed to edit the provided CalendarEvent
//<
canEditEvent : function (event) {
    if (!event) return false;
    else if (event[this.canEditField] != null) return event[this.canEditField];
    else return this.canEditEvents;
},

//>	@method	calendar.addEvent()
// Create a new event in this calendar instance.
//
// @param	startDate		(Date)	start date of event
// @param  endDate         (Date)  end date of event
// @param  name            (String) name of event
// @param description      (String) description of event
// @visibility calendar
//<
addEvent : function (startDate, endDate, name, description, ignoreDataChanged) {
    var evt = {};
    evt[this.startDateField] = startDate;
    evt[this.endDateField] = endDate;
    evt[this.nameField] = name;
    evt[this.descriptionField] = description;
    
    // setup a callback closure for when theres a DS
    var self = this;
    var _finish = function (dsResponse, data, dsRequest) {
        var newEvt = (data ? data : evt);
        // check all views to see if the event should be added
        if (self._shouldRefreshDay(startDate, endDate)) {
            self.dayView.addEvent(newEvt);
        }
        if (self._shouldRefreshWeek(startDate, endDate)) {
            self.weekView.addEvent(newEvt);
        }
        if (self._shouldRefreshMonth(startDate, endDate)) {
            self.monthView.refreshEvents();
        }
        
    }
    
    // add event to data
    // see commment above dataChanged about _ignoreDataChanged
    if (ignoreDataChanged) this._ignoreDataChanged = true;
    if (this.dataSource) {
        this.dataSource.addData(evt, _finish);
        return;
    } else {
        this.data.add(evt);
        _finish();
    }
    
},

//>	@method	calendar.removeEvent()
// Remove an event from this calendar.
//
// @param	event		(Object)	The event object to remove from the calendar
//
// @visibility calendar
//<
removeEvent : function (event, ignoreDataChanged) {
    var startDate = event[this.startDateField],
        endDate = event[this.endDateField];
    
     // set up a callback closure for when theres a DS
    var self = this;
    var _finish = function () {
        if (self._shouldRefreshDay(startDate, endDate)) {
            self.dayView.removeEvent(event);
        }
        if (self._shouldRefreshWeek(startDate, endDate)) {
            self.weekView.removeEvent(event);
        }
        if (self._shouldRefreshMonth(startDate, endDate)) {
            self.monthView.refreshEvents();
        }
    }
    // remove the data
    // see commment above dataChanged about _ignoreDataChanged
    if (ignoreDataChanged) this._ignoreDataChanged = true;
    if (this.dataSource) {
        this.dataSource.removeData(event, _finish); 
        return;
    } else {
        this.data.remove(event);
        _finish();
    }
             
},

//>	@method	calendar.updateEvent()
// update an event in this calendar.
//
// @param	event		(Object)	The event object to remove from the calendar
// @param	startDate		(Date)	start date of event
// @param  endDate         (Date)  end date of event
// @param  name            (String) name of event
// @param description      (String) description of event
//     
// @visibility calendar
//<
updateEvent : function (event, startDate, endDate, name, description, ignoreDataChanged) {
     // set up a callback closure for when theres a DS
    var self = this;
    // must call _shouldRefreshDay twice, both with old and new dates. see _shouldRefreshDay.
    var oldStart = event[this.startDateField];
    var oldEnd = event[this.endDateField];
    var _finish = function (dsResponse, data, dsRequest) {
        var newEvt = (data ? data : event);
        if (self._shouldRefreshDay(oldStart, oldEnd) || self._shouldRefreshDay(startDate, endDate)) {
            // call self.refreshEvents instead of self.updateEventWindow(newEvt), 
            // to handle all 3 cases described above _shouldRefreshDay
            self.dayView.refreshEvents();
        }
        if (self._shouldRefreshWeek(startDate, endDate)) {
            self.weekView.updateEventWindow(newEvt);
        }
        if (self._shouldRefreshMonth(startDate, endDate)) {
            //self.monthView.refreshDay(newEvt[self.startDateField]);
            self.monthView.refreshEvents();
        }
        // fire eventChanged if present
        if (this.eventChanged) this.eventChanged(newEvt);
    }
    // see commment above dataChanged about _ignoreDataChanged
    if (ignoreDataChanged) this._ignoreDataChanged = true;
    if (this.dataSource) {
        var changes = {};
        changes[this.startDateField] = startDate;
        changes[this.endDateField] = endDate;
        changes[this.descriptionField] = description;
        changes[this.nameField] = name;
        var updatedRecord = isc.addProperties({}, event, changes);
        this.dataSource.updateData(updatedRecord, _finish);
        return;
    } else {
        event[this.startDateField] = startDate;
        event[this.endDateField] = endDate;
        event[this.descriptionField] = description;
        event[this.nameField] = name;
        _finish();
    }
   
},

// trickiest case. 3 seperate cases to handle:
// 1. event changed within chosen day
// 2. event moved into chosen day
// 3. event moved out of chosen day
// to handle all of these:
// - for adding, just pass start and end date
// - for deleting, just pass start and end date
// - for updating, must call this twice, both with old dates and new dates. see updateEvent.
_shouldRefreshDay : function (startDate, endDate) {
    var dayStart = new Date(this.year, this.month, this.chosenDate.getDate(),0, 0);
    var dayEnd = new Date(this.year, this.month, this.chosenDate.getDate(),23, 59);
    if (this.dayView.body && dayStart.getTime() <= startDate.getTime() 
        && dayEnd.getTime() >= endDate.getTime()) {
        return true;
    } else return false;
    
},

_shouldRefreshWeek : function (startDate, endDate) {
    if (this.weekView.body && this.chosenWeekStart.getTime() <= startDate.getTime()
        && this.chosenWeekEnd.getTime() >= endDate.getTime()) {
        return true;
    } else return false;
},

_shouldRefreshMonth : function (startDate, endDate) {
    // provide a nice broad range to detect a month refresh should be done
    var mStart = new Date(this.year, this.month, -7);
    var mEnd = new Date(this.year, this.month, 37);
    if (mStart.getTime() <= startDate.getTime() && mEnd.getTime() >= endDate.getTime()) {
        return true;
    } else return false;
},

_getNewEventWindow : function (event) {
    var canEdit = this.canEditEvent(event);
    var canDelete = this.canDeleteEvents == null ? canEdit : this.canDeleteEvents;
    var styleName = event[this.eventWindowStyleField] || this.eventWindowStyle;
    return isc.EventWindow.create({
        calendar: this,
        className: styleName,
        baseStyle: styleName,
        canDragReposition: canEdit,
        canDragResize: canEdit,
        showCloseButton: canDelete,
        event: event,
        descriptionText: event[this.descriptionField]
    }); 
},
 
_getEventsInRange : function (start, end) {
        
        var results = [];
        var wends = Date.getWeekendDays();
       
        for (var i = 0; i < this.data.getLength(); i++) { 
            
            var curr = this.data.get(i);
          
            if (!curr[this.startDateField]) return [];
            // add the event if we're showing weekends or the date is not a weekend
            // The event won't get added only when !this.showWeekends and it is a weekend
            if (curr[this.startDateField].getTime() >= start.getTime() 
                && curr[this.endDateField].getTime() <= end.getTime()
                && (this.showWeekends || !wends.contains(curr[this.startDateField].getDay()))) {
                results.add(curr);
            }
        }
        
        return results;
},

_setChosenWeek : function () {
    var startDate = 
        this.chosenWeekStart = new Date(this.year, this.month, this.chosenDate.getDate()
        - this.chosenDate.getDay());
    
    this.chosenWeekEnd = new Date(startDate.getFullYear(), startDate.getMonth(), 
       startDate.getDate() + 6, 23, 59);
  
},

//>	@method	calendar.setChosenDate()
// Set the current date for which the calendar will display events.
//
// @param	newDate		(Date)	the new date to set as the current date
//
// @visibility calendar
//<
setChosenDate : function (newDate) {
    this.year = newDate.getFullYear();
    this.month = newDate.getMonth();
    this._oldDate = this.chosenDate;
    this.chosenDate = newDate;
    this._setChosenWeek();
    // redraw monthview if need be
    if (this._oldDate.getFullYear() != this.year || this._oldDate.getMonth() != this.month) { 
        this.monthView.refreshEvents();
    } 
    // check if the week needs redrawn
    var startDate = new Date(this._oldDate.getFullYear(), this._oldDate.getMonth(), 
        this._oldDate.getDate() - this._oldDate.getDay());
    var endDate = new Date(startDate.getFullYear(), startDate.getMonth(), 
            startDate.getDate() + 6);
    var chosenTime = this.chosenDate.getTime();
    if (chosenTime < startDate.getTime() || chosenTime > endDate.getTime()) {
        this.weekView.refreshEvents();
        this._setWeekTitles();
    }
    // check for day redraw
    if (chosenTime != this._oldDate.getTime()) {
        this.dayView.refreshStyle();
        this.dayView.refreshEvents();
    }    
    
    // reset date label
    this.setDateLabel();
    // call dateChanged
    this.dateChanged();
    
},

_setWeekTitles : function () {
    var nDate = new Date(this.chosenWeekStart.getFullYear(), this.chosenWeekStart.getMonth(),
        this.chosenWeekStart.getDate());
    // set day titles
    var sdNames = Date.getShortDayNames();
    var weekends = Date.getWeekendDays();
    
    for (var i = 1; i < 8; i++) {
        // for hidden columns, getFieldNum will return -1. without this check, a logWarn is
        // produced when weekends are hidden
        if (this.weekView.getFieldNum("day" + i) >= 0) {
            var ntitle = sdNames[nDate.getDay()] + " " + (nDate.getMonth() + 1) + "/" + nDate.getDate();
            this.weekView.setFieldProperties("day" + i, {title: ntitle, align: "right" });
        }
        
        nDate.setDate(nDate.getDate() + 1);
    }
},

//>	@method	calendar.next()
// Move to the next day, week, or month, depending on which tab is selected.
//
// @visibility calendar
//<
next : function () {
   // var tab = this.mainView.selectedTab;
    if (this.dayViewSelected()) {
        var newDate = new Date(this.year, this.month, this.chosenDate.getDate() + 1);
        // if hiding weekends, find next non-weekend day
        if (!this.showWeekends) {
            var wends = Date.getWeekendDays();
            for (var i = 0; i < wends.length; i++) {
                if (wends.contains(newDate.getDay())) newDate.setDate(newDate.getDate() + 1);
            }
        }
    } else if (this.weekViewSelected()) {
        var newDate = new Date(this.year, this.month, this.chosenDate.getDate() + 7);   
    } else {
        var newDate = new Date(this.year, this.month + 1, 1);
    }
    this.dateChooser.setData(newDate);
    this.setChosenDate(newDate);
   
},

//>	@method	calendar.previous()
// Move to the previous day, week, or month, depending on which tab is selected.
//
// @visibility calendar
//<
previous : function () {
    //var tab = this.mainView.selectedTab;
    if (this.dayViewSelected()) {
        var newDate = new Date(this.year, this.month, this.chosenDate.getDate() - 1);
        // if hiding weekends, find next non-weekend day
        if (!this.showWeekends) {
            var wends = Date.getWeekendDays();
            for (var i = 0; i < wends.length; i++) {
                if (wends.contains(newDate.getDay())) newDate.setDate(newDate.getDate() - 1);
            }
        }
    } else if (this.weekViewSelected()) {
        var newDate = new Date(this.year, this.month, this.chosenDate.getDate() - 7);   
    } else {
        var newDate = new Date(this.year, this.month - 1, 1);
    }
    this.dateChooser.setData(newDate);
    this.setChosenDate(newDate);
    
},

dataArrived : function () { 
    return true;   
},

// override draw to add the calendar navigation bar floating above the mainView tabbar
draw : function (a, b, c, d) {
    
    this.invokeSuper(isc.Calendar, "draw", a, b, c, d);
    
    if (this.dataSource) {
        this.observe(this.data, "dataArrived", "observer.dataArrived()");    
    }
    if (this.mainView.isA("TabSet")) {
        this.mainView.addChild(this.controlsBar);
        this.controlsBar.moveAbove(this.mainView.tabBar);
    }
    
   
}, 

/*
getSnapGapPixels : function (snapGap, grid) {
    if (!snapGap) return snapGap;
    // get percentage of snapGap in relation to 30 minutes, the length in minutes of a row, and 
    // multiply by row height to get pixels
    return Math.floor((snapGap / 30) * grid.getRowHeight(null, 0));
},
*/

// create the content of the calendar
createChildren : function () {
    this.dateDisplay = this.createAutoChild("dateDisplay" );
    // viewName used by calendar internals, so don't put into defaults
    var dayView = this.dayView = this.createAutoChild("dayView", 
        { baseStyle: this.baseStyle, viewName: "day"} );
    
    var weekView = this.weekView = this.createAutoChild("weekView", 
        {_isWeek: true, baseStyle: this.baseStyle, viewName: "week" } );
  
    var monthView = this.monthView = this.createAutoChild("monthView", 
        {baseStyle: this.baseStyle, viewName: "month" } );
   
    // main tabbed view
    var mvTabs = [];
    if (this.showDayView != false) mvTabs.add({title: "Day", pane: dayView });
    if (this.showWeekView != false) mvTabs.add({title: "Week", pane: weekView });
    if (this.showMonthView != false) mvTabs.add({title: "Month", pane: monthView });
    // if there is only one view displayed, don't use tabs
    if (mvTabs.length > 1) {
        this.mainView = this.createAutoChild("mainView", {           
            tabs: mvTabs,
            tabSelected : function (tabNum, tabPane, ID, tab) {
                // store selected view name for later use, in day/week/monthViewSelected functions
                this.creator._selectedViewName = tabPane.viewName;
                this.creator.setDateLabel();
            }
            
        } );
      
    } else {
        this.mainView = mvTabs[0].pane;     
    }
    
    var tbButtonDim = 20;
    // addEventButton
    this.addEventButton = this.createAutoChild("addEventButton", {
        click: function () {
            var cal = this.creator;
            cal.eventDialog.event = null;
            cal.eventDialog.items[0].createFields(false);
  
            var sDate = new Date();
            // if hiding weekends, find next non-weekend day
            if (!this.showWeekends) {
                var wends = Date.getWeekendDays();
                for (var i = 0; i < wends.length; i++) {
                    if (wends.contains(sDate.getDay())) sDate.setDate(sDate.getDate() + 1);
                }
            }
            sDate.setMinutes(0);
            // move event to next day if now is end of day
            if (sDate.getHours() > 22) {
                sDate.setDate(sDate.getDate() + 1);
                sDate.setHours(0);
            } // otherwise move to next hour
            else sDate.setHours(sDate.getHours() + 1);
            cal.eventDialog.setDate(sDate);
            // place the dialog at the left edge of the calendar, right below the button itself
            cal.eventDialog.setPageLeft(cal.getPageLeft());
            cal.eventDialog.setPageTop(this.getPageTop() + this.getVisibleHeight());
           
            cal.eventDialog.show();
        }
    } );
    
    // datePickerButton
    this.datePickerButton = this.createAutoChild("datePickerButton", {
        click: function () {
            var cal = this.creator;
            if (this._datePicker) {
                // redraw the datePicker, positioning is already taken care of   
                this._datePicker.setData(cal.chosenDate);
                this._datePicker.draw();
            } else {
                 this._datePicker = isc.DateChooser.create({
                    calendar: this.creator, autoDraw: false,
                    showCancelButton: true, autoClose: true,
                    disableWeekends: this.creator.disableWeekends,
                    showWeekends: this.creator.showWeekends,
                    // override dateClick to change the selected day
                    dateClick : function (year, month, day) {
                        var nDate = new Date(year, month, day);
                        this.setData(nDate);
                        // change the chosen date via the dateChooser
                        this.calendar.dateChooser.dateClick(year, month, day);
                        this.close();
                    }
                 });
                 this._datePicker.setData(cal.chosenDate);
                 cal.addChild(this._datePicker);
                 
                 this._datePicker.placeNextTo(this, "bottom", true);         
            }
            
            
        }
    } );
    
    this.previousButton = this.createAutoChild("previousButton", {});
    
    this.nextButton = this.createAutoChild("nextButton", {});
    
    var cbMems = [];
    cbMems.add(this.previousButton);
    cbMems.add(this.dateDisplay);
    if (this.showDatePickerButton != false) cbMems.add(this.datePickerButton);
    if (this.canCreateEvents && this.showAddEventButton != false) cbMems.add(this.addEventButton);
    cbMems.add(this.nextButton);
    // set up calendar navigation controls
    this.controlsBar = this.createAutoChild("controlsBar", { 
        members: cbMems
    });
    if (mvTabs.length == 1) this.controlsBar.layoutAlign = "center";
    
    // date chooser
    this.dateChooser = this.createAutoChild("dateChooser", {
            disableWeekends: this.disableWeekends,
            showWeekends: this.showWeekends,
            // override dateClick to change the selected day
            dateClick : function (year, month, day) {
                var nDate = new Date(year, month, day);
                this.setData(nDate);
               
                // recalculate displayed events
                this.creator.setChosenDate(nDate);    
            },
            
            showPrevYear : function () {
                this.year--;
                this.dateClick(this.year, this.month, this.chosenDate.getDate());
            },
        
            showNextYear : function () {
                this.year++;
                this.dateClick(this.year, this.month, this.chosenDate.getDate());
            },
            
            showPrevMonth : function () {
                if (--this.month == -1) {
                    this.month = 11;
                    this.year--;
                }
                this.dateClick(this.year, this.month, 1);
            },
        
            showNextMonth : function () {
                if (++this.month == 12) {
                    this.month = 0;
                    this.year++;
                }
                this.dateClick(this.year, this.month, 1);
            }
    } );
    
    // quick event dialog
    this.eventDialog = this.createAutoChild("eventDialog", {
        
        items: [
            isc.DynamicForm.create({
                autoDraw: false,
                padding:4,
                calendar: this,
                saveOnEnter: true,
                useAllDataSourceFields: true,
                createFields : function (isEvent) {
                    var nameType = isEvent ? "staticText" : "text";
                    // set up default fields
                    var fieldList = [
                        {name: "name", title: "Event Name", type: nameType, width: 250 },
                        {name: "save", title: "Save Event", type: "SubmitItem", endRow: false},
                        {name: "details", title: "Edit Details", type: "button", startRow: false,
                            click : function (form, item) {
                                form.calendar._showEventEditor(form.calendar.eventDialog.event);    
                            }
                        }   
                    ];
                    if (isEvent) fieldList.removeAt(1);
                    // create internal datasource
                    var dialogDS = isc.DataSource.create({
                        addGlobalId: false,
                        fields: fieldList
                    });
                    // set datasource then fields...other way around doesn't work
                    this.setDataSource(dialogDS);
                    this.setFields(isc.clone(this.calendar.eventDialogFields));
             
                },
                
                submit : function () {
                    var cal = this.calendar,
                        evt = cal.eventDialog.event, 
                        sdate = cal.eventDialog.currentStart,
                        edate = cal.eventDialog.currentEnd;
                   
                    if (evt) { // event window clicked, so update 
                        cal.updateEvent(evt, sdate, edate, 
                            this.getItem("name").getValue() ,evt[cal.descriptionField]
                            , true);
                        cal.eventDialog.hide();
                        
                    } else { // create new event
                        cal.addEvent(sdate, edate, this.getItem("name").getValue(),
                            "", true);
                        cal.eventDialog.hide();
                    }
                }
            })
        ],
            
        setDate : function (startDate, endDate) {
            if (!endDate) {
                // handle the case where where the startDate is 11:30 pm...in this case only 
                // do a 1/2 hour long event
                if (startDate.getHours() == 23 && startDate.getMinutes() == 30) {
                    endDate = new Date(startDate.getFullYear(), startDate.getMonth(),
                    startDate.getDate() + 1); 
                } else {
                    endDate = new Date(startDate.getFullYear(), startDate.getMonth(),
                        startDate.getDate(), startDate.getHours() + 1, startDate.getMinutes());
                }
            }
            this.setTitle(this.creator._getEventDialogTitle(startDate, endDate));
            this.currentStart = startDate;
            this.currentEnd = endDate;
            this.items[0].getItem("name").setValue("");
        },
        
        setEvent : function (event) {
            this.event = event;
            this.setDate(event[this.creator.startDateField], 
                event[this.creator.endDateField]);
            
            this.items[0].getItem("name").setValue(event[this.creator.nameField]);
        },
        
        closeClick : function () {
            this.Super('closeClick');
            // clear selections on close of dialog
            this.creator.dayView.clearSelection();
            this.creator.weekView.clearSelection();
           
        },
        
        show : function () {
            if (this.creator.showQuickEventDialog) {
                
                if (!this.isDrawn()) this.draw();
                this.Super('show');
                this.items[0].getItem("name").focusInItem();
            } else {
                this.creator._showEventEditor(this.event);    
            }
        },
        
        hide : function () {
            this.Super('hide');
            this.moveTo(0, 0);
        }
        
    } );
    
    // event editor form
    this.eventEditor = this.createAutoChild("eventEditor", {   
        useAllDataSourceFields: true,
        initWidget : function () {
            // invoke initWidget here rather than at the end of the function, or else we multiple
            // log warnings of form fields being clobbered
            this.invokeSuper(isc.DynamicForm, "initWidget", arguments);
   
            this.timeFormat = this.creator.timeFormat;
            var fieldList = [
                {name: "startHours", title: "From", type: "select", width: 60},
                {name: "startMinutes", showTitle: false, type: "select", width: 60},
                {name: "startAMPM", showTitle: false, type: "select", width: 60},
                {name: "invalidDate", type: "blurb", colSpan: 4, visible: false,
                    defaultValue: this.creator.invalidDateMessage},
                {name: "endHours", title: "To", type: "select", width: 60},
                {name: "endMinutes", showTitle: false, type: "select", width: 60},
                {name: "endAMPM", showTitle: false, type: "select", width: 60},
                {name: "name", title: "Name", type: "text", colSpan: 4},
                {name: "description", title: "Description", type: "textArea", colSpan: 4, height: 50}
            ];
            fieldList[0].valueMap = this.getTimeValues("hours");
            fieldList[1].valueMap = this.getTimeValues("minutes");
            fieldList[2].valueMap = this.getTimeValues();
            fieldList[3].cellStyle = this.errorStyle || "formCellError";
            fieldList[4].valueMap = this.getTimeValues("hours");
            fieldList[5].valueMap = this.getTimeValues("minutes");
            fieldList[6].valueMap = this.getTimeValues();
            // create an internal ds and bind to it so that the default fields can be 
            // overriden. See forms->validation->customized binding in the feature explorer
            var editorDS = isc.DataSource.create({
                addGlobalId: false,
                fields: fieldList
            });
            // only datasource then fields seems to work
            this.setDataSource(editorDS);
            this.setFields(isc.clone(this.creator.eventEditorFields));
        }, 
        getTimeValues : function (type, startTime) {
            if (!startTime) startTime = 0;
            var obj = {};
            if (type == "hours") {
                for (var i = startTime; i < 12; i++) {
                    obj[(i + 1) + ""] = (i + 1);                     
                }
            } else if (type == "minutes") {
                for (var i = 0; i < 60; i++) {
                    // stringify the minutes
                    var stringMin = i < 10 ? "0" + i : "" + i;
                    obj[i + ""] = stringMin;
                }
            } else {
                obj["am"] = "am";
                obj["pm"] = "pm";
            }
            
            return obj;
        }  
    } );
    
    // event editor layout
    this.eventEditorLayout = this.createAutoChild("eventEditorLayout", { 
        items: [
            this.eventEditor,
            isc.HLayout.create({
                membersMargin: 10, 
                layoutMargin: 10,
                autoDraw:false, 
                members: [
                isc.IButton.create({autoDraw: false, title: "Save Event", calendar: this,
                        click : function () {
                            var cal = this.calendar,
                                evt = cal.eventEditorLayout.event,
                                form = cal.eventEditor,
                                sHrs = form.getItem("startHours").getValue(),
                                eHrs = form.getItem("endHours").getValue(),
                                sMins = form.getItem("startMinutes").getValue(), 
                                eMins = form.getItem("endMinutes").getValue()
                            ; 
                            var sAMPM, eAMPM;
                               
                            if (!cal.twentyFourHourTime) {
                                sAMPM = form.getItem("startAMPM").getValue();
                                eAMPM = form.getItem("endAMPM").getValue();
                                sHrs = cal._to24HourNotation(sHrs, sAMPM);
                                eHrs = cal._to24HourNotation(eHrs, eAMPM);
                                // handle the case where end date is 12am, which is valid, as this
                                // is considered the end of the current day
                                if (eHrs == 0) eHrs = 24;
                            }
                            // check for invalid times
                            if (!(sHrs < eHrs || (sHrs == eHrs && sMins < eMins))) {
                                form.showItem("invalidDate");
                                return;
                            }
                            var sdate = cal.eventEditorLayout.currentStart,
                                edate = cal.eventEditorLayout.currentEnd;
                            sdate.setHours(sHrs);
                            sdate.setMinutes(sMins);
                            edate.setHours(eHrs);
                            edate.setMinutes(eMins);
                            if (evt) { // event window clicked, so update 
                                cal.updateEvent(evt, sdate, edate
                                    ,form.getItem("name").getValue() 
                                    ,form.getItem("description").getValue(), true);
                                cal.eventEditorLayout.hide();
                                
                            } else { // create new event
                                cal.addEvent(sdate, edate
                                    ,form.getItem("name").getValue() 
                                    ,form.getItem("description").getValue(), true);
                                cal.eventEditorLayout.hide();
                            }
                        }
                    }),
                    isc.IButton.create({autoDraw: false, title: "Cancel", calendar:this,
                        click: function () {
                            this.calendar.eventEditorLayout.hide();    
                        }
                    })
                ]
            })
        ],
        
        setDate : function (startDate, endDate, eventName) {
            if (!eventName) eventName = "";
            if (!endDate) {
                endDate = new Date(startDate.getFullYear(), startDate.getMonth(),
                    startDate.getDate(), startDate.getHours() + 1, startDate.getMinutes());
            }
            var cal = this.creator;
            this.setTitle(cal._getEventDialogTitle(startDate, endDate));
            this.currentStart = startDate;
            this.currentEnd = endDate;
         
            this.items[0].getItem("startHours").setValue(this.getHours(startDate.getHours())); 
            this.items[0].getItem("endHours").setValue(this.getHours(endDate.getHours()));
            this.items[0].getItem("startMinutes").setValue(startDate.getMinutes());
            this.items[0].getItem("endMinutes").setValue(endDate.getMinutes());
            if (!cal.twentyFourHourTime) {
                this.items[0].getItem("startAMPM").setValue(this.getAMPM(startDate.getHours()));
                this.items[0].getItem("endAMPM").setValue(this.getAMPM(endDate.getHours()));
            }
            this.items[0].getItem("name").setValue(eventName);
            this.items[0].getItem("description").setValue("");
        },
        
        getHours : function (hour) {
            if (this.creator.twentyFourHourTime) return hour;
            else return this.creator._to12HrNotation(hour);
        },
        
        getAMPM : function (hour) {
            if (hour < 12) return "am";
            else return "pm";
        },
    
        setEvent : function (event) {
            this.event = event;
            this.setDate(event[this.creator.startDateField], 
                event[this.creator.endDateField]);
            this.items[0].getItem("name").setValue(event[this.creator.nameField]);
            this.items[0].getItem("description").setValue(
                    event[this.creator.descriptionField]);
            
        },

        hide : function () {
            this.Super('hide');
            // clear any selection that's been made
            this.creator.dayView.clearSelection();
            this.creator.weekView.clearSelection();
            // clear any errors
            this.creator.eventEditor.hideItem("invalidDate");
        },
       
        sizeMe : function () {
            this.setWidth(this.creator.mainView.getVisibleWidth());
            this.setHeight(this.creator.mainView.getVisibleHeight()); 
            this.setLeft(this.creator.mainView.getLeft());
        }
    });
    
    
    
    // layout for date chooser and main calendar view
    if (!this.children) this.children = [];
    var mainMembers = [];
    var subMembers = [];
    //if (this.canCreateEvents) subMembers.add(this.addEventButton);
    subMembers.add(this.dateChooser);
    if (this.showDateChooser) {
        mainMembers.add(isc.VLayout.create({
                        autoDraw:false,
                    width: "20%",
                    membersMargin: 10,
                    layoutTopMargin: 10,
                    members: subMembers
                }));
    }
    
    if (this.mainView.isA("TabSet")) {
        mainMembers.add(this.mainView);        
    } else {
         
        var controlsBarContainer = isc.HLayout.create({
                autoDraw: false,
                height: this.controlsBar.getVisibleHeight(),
                width: "100%"
        });
        
        controlsBarContainer.addMember(isc.LayoutSpacer.create({autoDraw:false, width:"*"}));
        controlsBarContainer.addMember(this.controlsBar);
        controlsBarContainer.addMember(isc.LayoutSpacer.create({autoDraw:false, width:"*"}));
        mainMembers.add(isc.VLayout.create({
                autoDraw:false,
                members: [controlsBarContainer, this.mainView]
            }));
    }
    
    this.children.add(
        isc.HLayout.create({ 
                autoDraw:false,
            width: "100%",
            height: "100%",
            members:mainMembers
           
        })
    );
    
    this.eventEditorLayout.hide();
    
    this.setDateLabel();    
},

// sets the date label of the calendar. Called whenever the chosenDate or selected tab
// changes
setDateLabel : function () {
    if (this.dayViewSelected()) { // day tab
       this.dateDisplay.setContents( 
       "<b>" + this.chosenDate.getShortMonthName() + " " + this.chosenDate.getDate() 
       + ", " + this.chosenDate.getFullYear() + "</b>");        
    } else if (this.weekViewSelected()) { // week tab
        var startDate = new Date(this.year, this.month, this.chosenDate.getDate()
            - this.chosenDate.getDay());
        var endDate = new Date(startDate.getFullYear(), startDate.getMonth(), 
            startDate.getDate() + 6);
        if (startDate.getMonth() != endDate.getMonth()) { // week spans two different months
            this.dateDisplay.setContents(
                "<b>" + startDate.getShortMonthName() + " " + startDate.getDate() 
                + ", " + startDate.getFullYear() + " - " 
                + endDate.getShortMonthName() + " " + endDate.getDate() 
                + ", " + endDate.getFullYear() + "</b>");
        } else {
            this.dateDisplay.setContents(
                "<b>" + startDate.getShortMonthName() + " " + startDate.getDate() + " - " 
                + (startDate.getDate() + 6) + " " + startDate.getFullYear() + "</b>");    
        }
    } else { // month tab
        this.dateDisplay.setContents("<b>" + this.chosenDate.getShortMonthName()
            + " " + this.chosenDate.getFullYear() + "</b>");
    }
    
    
    
},

dayViewSelected : function () {
    if (!this.mainView.isA("TabSet")) return this.mainView.viewName == "day";
    else return this._selectedViewName == "day";  
},

weekViewSelected : function () {
    if (!this.mainView.isA("TabSet")) return this.mainView.viewName == "week";
    else return this._selectedViewName == "week";
},

monthViewSelected : function () {
    if (!this.mainView.isA("TabSet")) return this.mainView.viewName == "month";
    return this._selectedViewName == "month";
},

// Displays the event entry/edit dialog at the given row and column position
_showEventDialog : function (rowNum, colNum, numRows, eventWindow) {
    var grid;
    if (this.dayViewSelected()) grid = this.dayView;
    else if (this.weekViewSelected()) grid = this.weekView;
    else grid = this.monthView;
    
    if (!eventWindow) {
        this.eventDialog.event = null;
        this.eventDialog.items[0].createFields(false);
        var sDate, eDate;
        if (this.monthViewSelected()) { // get date for clicked month day cell
           var sHrs = new Date();
           sHrs = sHrs.getHours();
           // take an hour off so the event stays within the day
           if (sHrs > 22) sHrs -= 1;
           var index = rowNum % 2 == 0 ? rowNum : rowNum - 1;
           var dayNum = this.monthView.data[index]["day" + (this._getDayNum(colNum) + 1)], monthNum;
           // adjust month if need be
           if ((rowNum == 0 || rowNum == 1) && dayNum > 7) {
               monthNum = this.month - 1;
           } else if (rowNum > 7 && dayNum < 8) {
               monthNum = this.month + 1;
           } else {
               monthNum = this.month   
           }
           sDate = new Date(this.year, monthNum, dayNum, sHrs);
        }
        else {
            sDate = this._getDateFromPoint(rowNum, colNum);
        }
        if (numRows && numRows > 1) {
            eDate = this._getDateFromPoint(rowNum + numRows, colNum);
        }
        
        this.eventDialog.setDate(sDate, eDate);
    } else {
        this.eventDialog.eventWindow = eventWindow;
        this.eventDialog.items[0].createFields(true);
        this.eventDialog.setEvent(eventWindow.event);    
    }

    // ensure the dialog is drawn before placing it
    
    this.eventDialog.moveTo(0, -10000);
    this.eventDialog.show(); 
    
    var coords = grid.getCellPageRect(rowNum, colNum);
    this.eventDialog.placeNear(coords[0], coords[1]);
},

_showEventEditor : function (event) {
    
    if (!this.eventEditorLayout.isDrawn()) this.eventEditorLayout.draw();
    this.eventEditorLayout.setWidth(this.mainView.getVisibleWidth());
    this.eventEditorLayout.setHeight(this.mainView.getVisibleHeight());
    // move the eventEditor to cover the mainView only
    
    this.eventEditorLayout.setPageLeft(this.mainView.getPageLeft());
    this.eventEditorLayout.setPageTop(this.getPageTop());
   
    if (event) {
        this.eventEditorLayout.setEvent(event);
    } else {
        
        this.eventEditorLayout.setDate(this.eventDialog.currentStart, 
            this.eventDialog.currentEnd, this.eventDialog.items[0].getItem("name").getValue());
    }
    this.eventDialog.hide();
    
    this.eventEditorLayout.show();
    
},

_getEventDialogTitle : function (startDate, endDate) {
    var dayNames = Date.getShortDayNames();
    var monthNames = Date.getShortMonthNames();
   
    var sHrs = startDate.getHours(), eHrs = endDate.getHours(), 
        sMins = startDate.getMinutes(), eMins = endDate.getMinutes(), sStr, eStr;
    sStr = this._to12HrNotation(sHrs) + (sMins < 10 ? ":0" + sMins : ":" + sMins);
    eStr = this._to12HrNotation(eHrs) + (eMins < 10 ? ":0" + eMins : ":" + eMins)
        + (eHrs > 11 ? "pm" : "am");
    if (!((sHrs < 12 && eHrs < 12) || (sHrs > 11 && eHrs > 11))) sStr += (sHrs > 11 ? "pm" : "am");
    
    var timeStr = sStr + " - " + eStr;
    return dayNames[startDate.getDay()] + ", " + monthNames[startDate.getMonth()]
        + " " + startDate.getDate() + ", " + timeStr ;
}, 

_to12HrNotation : function (hour) {
    if (hour == 0) return 12;
    else if (hour < 13) return hour;
    else return hour - 12;
},

_to24HourNotation : function (hour, ampmString) {
    // make sure we're dealing with an int
    hour = parseInt(hour);
    if (ampmString.toLowerCase() == "am" && hour == 12) { 
        return 0;
    } else if (ampmString.toLowerCase() == "pm" && hour < 12) {
        return hour + 12;    
    } else {
        return hour;    
    }
},

_getDateFromPoint : function (rowNum, colNum) {
    var day = this.weekViewSelected() && this.weekView.isLabelCol(0) ? colNum - 1 : colNum;
    day = this._getDayNum(day);
 
    var retDate = new Date(this.year, this.month, this.chosenDate.getDate());
    if (this.weekViewSelected()) retDate.setDate(retDate.getDate() - this.chosenDate.getDay() + day);
    
    var hour, baseRowNum = rowNum, mins = 0;
    if (rowNum % 2 == 1) {
        baseRowNum = rowNum - 1;
        mins = 30;
    }
    
    retDate.setHours(baseRowNum / 2, mins);
    return retDate;
    
},

// rowHeight == 30 minutes. return the number of pixels that the parameter minutes will occupy
_getMinutePixels : function (minutes, rowHeight) {
    return Math.round((rowHeight / 30) * minutes);        
},

// helper function to consolidate code that accounts for things like hiding weekends, possibly
// other things in the future.
_getDayNum : function (colNum) {
    var cNum = colNum;
    if (!this.showWeekends) {
        var weekends = Date.getWeekendDays();
        for (var i = 0; i < weekends.length; i++) {
            if (weekends[i] <= colNum) cNum++;    
        }
        return cNum;
    } else return colNum;
},

monthViewEventClick : function (rowNum, colNum, eventIndex) {
    var evt = this.monthView.data[rowNum]["event" + (colNum + 1)][eventIndex];
    if (this.eventClick(evt, "month")) this._showEventEditor(evt);   
},

//> @method calendar.getDayBodyHTML()
// Return the HTML to be shown in the body of a day in the month view.
// <P>
// Default is to render a series of links that call +link{eventClick} to provide details
// and/or an editing interface for the events.
// <P>
// <code>getDayBodyHTML()</code> is not called for days outside of the current month if
// +link{showOtherDays} is false.
//
// @param date (Date) JavaScript Date object representing this day
// @param events (Array of CalendarEvent) events that fall on this day
// @param calendar (Calendar) the calendar itself
// @param rowNum (Integer) the row number to which the parameter date belongs
// @param colNum (Integer) the column number to which the parameter date belongs
// 
// @group monthViewFormatting
// @visibility calendar
//<
getDayBodyHTML : function (date, events, calendar, rowNum, colNum) {
    // _getDayNum for not showing weekends
    var day = date.getDay();
    // this.monthView.getRowHeight() doesn't seem to return the correct value, not sure why
    var evtArr = events, lineHeight = 15, rHeight = this.monthView.getRowSize(1);
    var retVal = "";
    for (var i = 0; i < evtArr.length; i++) {
        var eTime = evtArr[i][this.startDateField].getHours();
        eTime = this._to12HrNotation(eTime) + (eTime > 11 ? "P " : " ");
        if (this.canEditEvent(evtArr[i])) {
            // when clicked, call the the editEvent method of this calendar, passing the
            // row, column, and position of the event in this cell's event array
            var template  = "<a href='javascript:" + this.ID + ".monthViewEventClick(" + 
                rowNum + "," + day + "," + i + ");' class='" 
                + this.calMonthEventLinkStyle + "'>";
                
            retVal += template + eTime + evtArr[i][this.nameField] + "</a><br/>";
        } else {
            retVal += eTime + evtArr[i][this.nameField] + "<br/>";      
        }
        if ((i + 3) * lineHeight > rHeight) break; 
    }
    if (i < evtArr.length - 1) {
        retVal += "+ " + (evtArr.length - 1 - i) + " more...";
    }
    return retVal;
},

// @method calendar.getDayHeaderHTML()
// Return the HTML to be shown in the header of a day in the month view.
// <P>
// Default is to render just the day of the month, as a number.
//
// @param date (Date) JavaScript Date object representing this day
// @param events (Array of CalendarEvent) events that fall on this day
// @param calendar (Calendar) the calendar itself
// 
// @group monthViewFormatting
// @visibility calendar
//<
getDayHeaderHTML : function (date, events, calendar, rowNum, colNum) {
    return date.getDate();
},

//> @method calendar.dayBodyClick()
// Called when the body area of a day in the month view is clicked on, outside of any links
// to a particular event.
// <P>
// By default, if the user can add events, shows a dialog for adding a new event for that
// day.  Return false to cancel this action.
// <P>
// Not called if the day falls outside the current month and +link{showOtherDays} is false.
//
// @param date (Date) JavaScript Date object representing this day
// @param events (Array of CalendarEvent) events that fall on this day
// @param calendar (Calendar) the calendar itself
// @param rowNum (Integer) the row number to which the parameter date belongs
// @param colNum (Integer) the column number to which the parameter date belongs
// @return (boolean) false to cancel the default action
//
// @group monthViewEvents
// @visibility calendar
//<
dayBodyClick : function (date, events, calendar, rowNum, colNum) {
   return true;
},

//> @method calendar.dayHeaderClick()
// Called when the header area of a day in the month view is clicked on.
// <P>
// By default, moves to the day tab and shows the clicked days events.
// Return false to cancel this action.
// <P>
// Not called if the day falls outside the current month and +link{showOtherDays} is false.
//
// @param date (Date) JavaScript Date object representing this day
// @param events (Array of CalendarEvent) events that fall on this day
// @param calendar (Calendar) the calendar itself
// @param rowNum (Integer) the row number to which the parameter date belongs
// @param colNum (Integer) the column number to which the parameter date belongs
//
// @group monthViewEvents
// @visibility calendar
//<
dayHeaderClick : function (date, events, calendar, rowNum, colNum) {
    return true;    
},

//> @method calendar.eventChanged()
// Notification fired whenever a user changes an event, whether by dragging the event or by
// editing it in a dialog.
// <P>
// In a calendar with a DataSource, eventChanged() fires <b>after</b> the updated event has
// been successfully saved to the server
//
// @param event (CalendarEvent) the event that changed
// @group monthViewEvents
// @visibility calendar
//<

//> @method calendar.eventClick()
// Called whenever an event is clicked on in the day, week or month views.
// <P>
// By default a dialog appears showing details for the event, and offering the ability to
// edit events which are editable.  Return false to cancel the default action.
//
// @param event (CalendarEvent) event that was clicked on
// @param viewName (String) view where the event was clicked on: "day", "week" or "month"
// @return (boolean) false to cancel the default action
//
// @group monthViewEvents
// @visibility calendar
//<
eventClick : function () {
    return true;
},

//> @method calendar.eventMoved()
// Called when an event is moved via dragging by a user.  Return false to disallow the move.
// @param newDate (Date) new date and time that event is being moved to
// @param event (CalendarEvent)
//
// @group monthViewEvents
// @visibility calendar
//<
eventMoved : function () {
    return true;    
},

//> @method calendar.eventResized()
// Called when an event is resized via dragging by a user.  Return false to disallow the
// resize.
// @param newDate (Date) new end date and time that event is being resized to
// @param event (CalendarEvent)
//
// @group monthViewEvents
// @visibility calendar
//<
eventResized : function () {
    return true;    
},

// helper method, gets a valid date with respect to the eventSnapGap and starting point of 
// referenceDate. Used in eventWindow dragRepositionStop and dragResizeStop to ensure a valid
// date every time.
getValidSnapDate : function (referenceDate, snapDate) {
    // the formula for getting the snapDate is: 
    // round((snapDate as minutes - offset) / snapGap) * snapGap + offset
    // where offset = reference date as minutes mod snapGap
    var snapGap = this.eventSnapGap;
    
    var offset = ((referenceDate.getHours() * 60) + referenceDate.getMinutes()) % snapGap;
    
    var dateMinutes = (snapDate.getHours() * 60) + snapDate.getMinutes();
    var gapsInDate = Math.round((dateMinutes - offset) / snapGap);
    
    var totMins = (gapsInDate * snapGap) + offset;
   
    var hrs = Math.floor(totMins / 60), mins = totMins % 60;
    snapDate.setHours(hrs);
    snapDate.setMinutes(mins);
    return snapDate;    
},

selectTab : function (tabnum) {
    if (this.mainView && this.mainView.isA("TabSet") && this.mainView.tabs.getLength() > tabnum) {
        this.mainView.selectTab(tabnum);
        return true;        
    } else {
        return false;    
    }
},

// override parentResized to resize the eventEditorLayout as well
parentResized : function () {
     this.Super('parentResized', arguments);
     // only resize the eventEditorLayout if its shown
     if (this.eventEditorLayout.isVisible()) this.eventEditorLayout.sizeMe();
},

//> @method calendar.dateChanged()
// Fires whenever the user changes the current date, including picking a specific date or
// navigating to a new week or month.
// @visibility external
//<
dateChanged : function () {
    return true;
}

});

// DaySchedule
// --------------------------------------------------------------------------------------------
isc.ClassFactory.defineClass("DaySchedule", "ListGrid");

isc.DaySchedule.changeDefaults("bodyProperties", {
    childrenSnapToGrid: true,
    snapToCells: true        
});

isc.DaySchedule.addProperties({
    //defaultWidth: 300,
    //defaultHeight: 300,
    autoDraw: false,
    canSort: false,
    canResizeFields: false,
    canReorderFields: false,
    showHeader: false,
    showHeaderContextMenu: false,
    showAllRecords: true,
    fixedRecordHeights: true,
    labelColumnWidth: 40,
    labelColumnAlign: "right",
    showLabelColumn: true,
    labelColumnPosition: "left",
    labelColumnBaseStyle: "labelColumn",
    
    // show cell-level rollover
    showRollOver:true,
    useCellRollOvers:true,
    
    canSelectCells:true,
    
    initWidget : function () {
        this.fields = [];
        var labelCol = {
            width: this.labelColumnWidth,
            name: "label", 
            title: " ",
            cellAlign: "right",
            formatCellValue : function (value, record, rowNum, colNum, grid) {
                var ampm = (rowNum > 23 ? " PM" : " AM"); 
                if (rowNum % 2 == 0) {
                    if (rowNum == 0 || rowNum == 48) return "12 " + ampm;
                    else if (rowNum > 24) return ((rowNum / 2) - 12) + ampm; 
                    else return (rowNum / 2) + ampm;
                }
                else {
                    return "";
                }
            }
        }
        if (this.showLabelColumn && this.labelColumnPosition == "left") {
            this.fields.add(labelCol);
        }

        this.fields.add({name: "day1", align: "center"});
        if (this._isWeek) {
            var numDays = 8; 
            for (var i = 2; i < numDays; i++) {
                this.fields.add({name: "day" + i, align: "center" } );   
            }
            this.showHeader = true;
        }
        // hide weekends 
        if (this._isWeek && !this.creator.showWeekends) {
            var start = this.showLabelColumn && this.labelColumnPosition == "left" ? 1 : 0;
            var weekendDays = Date.getWeekendDays();
            for (var i = 0; i < weekendDays.length; i++) {
                this.fields[((weekendDays[i] + this.creator.firstDayOfWeek) % 7) + start].showIf 
                    = "return false;";      
            }            
        }
        if (this.showLabelColumn && this.labelColumnPosition == "right") {
            this.fields.add(labelCol);
        }
        this.data = isc.DaySchedule._eventScaffolding;
        this.Super("initWidget");
        
    },
    
    draw : function (a, b, c, d) {
        this.invokeSuper(isc.DaySchedule, "draw", a, b, c, d);
         
        this.logDebug('draw', 'calendar');
        // call refreshEvents() whenever we're drawn
        // see commment above dataChanged for the logic behind this
        
        this.refreshEvents();
        
        // set the snapGap after were drawn, so that we can pick up a dynamic row height.
        // this is mostly so that scrollToWorkday code works properly.
        this.setSnapGap();
        
    },
    
    setSnapGap : function () {
        // get percentage of snapGap in relation to 30 minutes, the length in minutes of a row, and 
        // multiply by row height to get pixels
        var snapGap = this.creator.eventSnapGap;
        this.body.snapVGap = Math.round((snapGap / 30) * this.body.getRowSize(0));
    },
    
    // To be used with calendar.scrollToWorkday 
    scrollToWorkdayStart : function () {
        var sDate = isc.Time.parseInput(this.creator.workdayStart);
        var sRow = sDate.getUTCHours() * 2;
        if (sDate.getUTCMinutes() > 0) sRow++;
       
        var sRowTop = this.getRowHeight(null, 0) * sRow;
        //this.scrollRecordIntoView(sRow, false);
        this.body.scrollTo(0, sRowTop);
    },
    
    getRowHeight : function (record, rowNum) {
        // when scrollToWorkday is true, rows should be sized so that the entire workday fits
        // inside of the viewport
        if (this.creator.scrollToWorkday) {
            var workdayLen = isc.Time.parseInput(this.creator.workdayEnd).getUTCHours() 
                - isc.Time.parseInput(this.creator.workdayStart).getUTCHours();
            // if workdayStart > workdayEnd, just return default cellHeight
            if (workdayLen <= 0) return this.cellHeight;
            var rHeight = Math.floor(this.body.getViewportHeight() / (workdayLen * 2));
            return rHeight < this.cellHeight ? this.cellHeight : rHeight;
        } else { 
            return this.cellHeight;
        }
    },
    
    getDayFromCol : function (colNum) {
         var day = colNum
         if (this.isLabelCol(0)) day -= 1;
         if (this.creator.showWeekends) {
            return (day + this.creator.firstDayOfWeek) % 7;    
         } else { 
            return (day + 1 + this.creator.firstDayOfWeek) % 7;
         }
    },
    
    isLabelCol : function (colNum) {
        if (colNum == 0 && this.showLabelColumn && this.labelColumnPosition == "left") {
            return true;
        } else if (colNum == this.fields.length - 1 && this.showLabelColumn && 
            this.labelColumnPosition == "right") {
             return true;
        } else {
            return false;   
        }
    },
    
    // helper function for detecting when a weekend is clicked, and weekends are disabled
    colDisabled : function (colNum) {
        var dayNum = this._isWeek ? this.getDayFromCol(colNum) : this.creator.chosenDate.getDay();
        if (this.creator.disableWeekends 
            && Date.getWeekendDays().contains(dayNum)) {
            return true;        
        } else {
            return false;   
        }
    },
    
    // helper function to refresh dayView cell styles for weekend disabling
    refreshStyle : function () {
        if (!this.body) return;
        for (var i = 0; i < this.data.length; i++) {
            this.body.refreshCellStyle(i, 1);    
        }
    },
    
    // use the chosen week start to figure out the base date, then add the headerFieldNum
    // to that to get the appropriate date. Use dateChooser.dateClick() to simplify code.
    headerClick : function (headerFieldNum, header) {
        if (this.isLabelCol(headerFieldNum)) return true;
        // get the correct day
        headerFieldNum = this.getDayFromCol(headerFieldNum);
        var cal = this.creator;
        var nDate = new Date(cal.chosenWeekStart.getFullYear(), cal.chosenWeekStart.getMonth(),
            cal.chosenWeekStart.getDate());
        //add the day to the chosen week start date to get the clicked date
        nDate.setDate(nDate.getDate() + headerFieldNum);
        cal.dateChooser.dateClick(nDate.getFullYear(), nDate.getMonth(), nDate.getDate());
        cal.selectTab(0);
        return true;
    },
    
    
    getCellAlign : function (record, rowNum, colNum) {
       return this.labelColumnAlign;
    },
    
    cellMouseDown : function (record, rowNum, colNum) {
        if (this.isLabelCol(colNum) || this.colDisabled(colNum)) return true; 
        // don't set up selection tracking if canCreateEvents is disabled
        if (!this.creator.canCreateEvents) return true;
        // first clear any previous selection   
        this.clearSelection();
        this._selectionTracker = {};
        this._selectionTracker.colNum = colNum;
        this._selectionTracker.startRowNum = rowNum;
        this._selectionTracker.endRowNum = rowNum;
        this._mouseDown = true;
        this.refreshCellStyle(rowNum, colNum);
    },
    
    cellOver : function (record, rowNum, colNum) {
        if (this._mouseDown && this._selectionTracker) {
            var refreshRowNum;
            // selecting southbound
            if (this._selectionTracker.startRowNum < this._selectionTracker.endRowNum) {
                // should select this cell
                if (rowNum > this._selectionTracker.endRowNum) {
                    refreshRowNum = rowNum;             
                } else { // should deselect the previous end row number
                    refreshRowNum = this._selectionTracker.endRowNum;
                }
                // trigger cell style update from getCellStyle
                this._selectionTracker.endRowNum = rowNum;
            // selecting northbound
            } else {
                // should select this cell
                if (rowNum < this._selectionTracker.endRowNum) {
                    refreshRowNum = rowNum;    
                } else { // should deselect the previous end row number
                    refreshRowNum = this._selectionTracker.endRowNum;
                }
                this._selectionTracker.endRowNum = rowNum;
            }
            var refreshGap = 6;
            var colNum = this._selectionTracker.colNum;
            for (var i = refreshRowNum - refreshGap; i < refreshRowNum + refreshGap; i++) {
                // 48 1/2 hours in a day, don't refresh non-existent cells
                if (i >= 0 && i <= 47) this.refreshCellStyle(i, colNum);        
            }                 
        }
    },
    
    cellMouseUp : function (record, rowNum, colNum) {
        if (!this._selectionTracker) return true;
        
        this._mouseDown = false;
        var sRow, eRow, diff;
        // cells selected upwards
        if (this._selectionTracker.startRowNum > this._selectionTracker.endRowNum) {
            sRow = this._selectionTracker.endRowNum;
            eRow = this._selectionTracker.startRowNum;
        // cells selected downwards
        } else {
            eRow = this._selectionTracker.endRowNum;
            sRow = this._selectionTracker.startRowNum;
        }
        diff = eRow - sRow + 1;
        this.creator._showEventDialog(sRow, this._selectionTracker.colNum, diff);
    },
    
    getCellStyle : function (record, rowNum, colNum) {
        var bStyle = this.getBaseStyle(record, rowNum, colNum);
        
        if (this.isLabelCol(colNum)) return bStyle;
        if (this.colDisabled(colNum)) return this.baseStyle + "Disabled";
        if (this._selectionTracker && this._selectionTracker.colNum == colNum) {
            var sRow = this._selectionTracker.startRowNum,
                eRow = this._selectionTracker.endRowNum;
            // if rowNum is within start and end of selection, return selected style
            if (rowNum >= sRow && rowNum <= eRow || rowNum >= eRow && rowNum <= sRow) {
                return this.creator.selectedCellStyle;    
            } else {
                return bStyle;
            }
        } else {
            
            return bStyle;
        }
    },
    
    getBaseStyle : function (record, rowNum, colNum) {
        if (this.isLabelCol(colNum)) return this.labelColumnBaseStyle;
        // determine if current row (rowNum) is within the workday by converting the rowNum
        // to an hour, and comparing that to workdayStart and workdayEnd. Date.getTime() is
        // used to perform the comparison in milliseconds...more accurate.
        var dayNum = this._isWeek ? parseInt(this.getField(colNum).name.charAt(3)) - 1 :
                                    this.creator.chosenDate.getDay();
        var wStart = isc.Time.parseInput(this.creator.workdayStart),
            wEnd = isc.Time.parseInput(this.creator.workdayEnd),
            currRowTime = new Date();
        
        currRowTime.setUTCHours(Math.floor(rowNum / 2));
        if (rowNum % 2 == 1) currRowTime.setUTCMinutes(30);
        else currRowTime.setUTCMinutes(0);
        
        currRowTime = currRowTime.getTime();
        if (this.creator.showWorkday && wStart.getTime() <= currRowTime && currRowTime < wEnd.getTime() 
            && !Date.getWeekendDays().contains(dayNum)) {
            
            return this.creator.workdayBaseStyle;        
        } else {
            return this.baseStyle;    
        }
    },
    
    clearSelection : function () {
        if (this._selectionTracker) {
            var sRow, eRow, colNum = this._selectionTracker.colNum;
            // establish order of cell refresh
            if (this._selectionTracker.startRowNum < this._selectionTracker.endRowNum) {
                sRow = this._selectionTracker.startRowNum;
                eRow = this._selectionTracker.endRowNum;
            } else {
                sRow = this._selectionTracker.endRowNum;
                eRow = this._selectionTracker.startRowNum;
            }
            // remove selection tracker so cells get reset to baseStyle
            this._selectionTracker = null;
            for (var i = sRow; i < eRow + 1; i++) {
                this.refreshCellStyle(i, colNum);    
            }
        }
    },
    
    refreshEvents : function () {
        // bail if the grid hasn't been drawn yet, or hasn't gotten data yet
        if (!this.body || !this.creator.hasData()) return;
       
        this.logDebug('refreshEvents:' + this.viewName, "calendar");
        this.clearEvents();
        var startDate, endDate, cal = this.creator;
        if (this._isWeek) {
            startDate = cal.chosenWeekStart;
            endDate = cal.chosenWeekEnd;
        } else {
            startDate = new Date(cal.year, cal.month, cal.chosenDate.getDate(),0, 0);
            endDate = new Date(cal.year, cal.month, cal.chosenDate.getDate(),23, 59);
        }
        
        var events = cal._getEventsInRange(startDate, endDate);
        
        for (var i = 0; i < events.length; i++) {
            
            this.addEvent(events[i]);
        }
        // if scrollToWorkday is set, do that here
        if (cal.scrollToWorkday) this.scrollToWorkdayStart();
        
    },
    
    clearEvents : function () {
        if (!this.body || !this.body.children) return;
        var arr = this.body.children;
        for (var i = arr.length - 1; i >= 0 ; i--) {
            if (isc.isAn.EventWindow(arr[i])) this.body.removeChild(arr[i]);
        }
    },
    
    addEvent : function (event) {
        // clear any cell selection that has been made
        this.clearSelection();
        var win = this.creator._getNewEventWindow(event);
        if (this._isWeek) win._isWeek = true;
        win.sizeToEvent();
        if (this.body) this.body.addChild(win);
    },
    
    removeEvent : function (event) {
        var arr = this.body.children;
        for (var i = 0; i < arr.length ; i++) {
            if (isc.isAn.EventWindow(arr[i]) && arr[i].event === event) {
                var win = arr[i];
                win.parentElement.removeChild(win);
                win.destroy();
                return true;
            }
        }
        return false;
    },
    
    updateEventWindow : function (event) {
        if (!this.body || !this.body.children) return;
        var arr = this.body.children, cal = this.creator;
        if (cal.dataSource) cal._pks = cal.dataSource.getLocalPrimaryKeyFields();
        for (var i = 0; i < arr.length ; i++) {
            if (isc.isAn.EventWindow(arr[i]) && this.areSame(arr[i].event, event)) {
                // reassign event for databound update, because databound update creates
                // a new object
                arr[i].event = event;
                arr[i].sizeToEvent();
                arr[i].setDescriptionText(event[cal.descriptionField]);
                return true;
            }
        }
        return false;
    },
    
    areSame : function (first, second) {
        var cal = this.creator;
        if (cal.dataSource) {
            var pks = cal._pks, areEqual = true;
            for (var pkName in pks) {
                if (first[pkName]!= second[pkName]) {
                    areEqual = false;
                    break;
                }
            }
            return areEqual;
        } else {
            return (first === second);    
        }
    }
   
});

// MonthSchedule
// --------------------------------------------------------------------------------------------
isc.ClassFactory.defineClass("MonthSchedule", "ListGrid");

isc.MonthSchedule.changeDefaults("headerButtonProperties", {
    showRollOver: false, 
    showDown: false, 
    cursor: "default"  
});

isc.MonthSchedule.addProperties({
    autoDraw: false,
    leaveScrollbarGap: false,

    showAllRecords: true,
    fixedRecordHeights: true,

    // show header but disable all header interactivity
    showHeader: true,
    showHeaderContextMenu: false,
    canSort: false,
    canResizeFields: false,
    canReorderFields: false,

    canHover: true,
    showHover: true,
    hoverWrap: false,
    // show cell-level rollover
    showRollOver:true,
    useCellRollOvers:true,

    // set up cell-level drag selection
    //canDrag:true,
    // dragAppearance:"none",
    //canDragSelect:true,
    canSelectCells:true,
    
    firstDayOfWeek: 0,
    dayHeaderHeight: 20,
    mimimumDayHeight: 80,
    
    initWidget : function () {
        // create month UI scaffolding
        if (this.creator.data) this.data = this.getDayArray();
        this.fields = [
            {name: "day1", align: "center"},
            {name: "day2", align: "center"},
            {name: "day3", align: "center"},
            {name: "day4", align: "center"},
            {name: "day5", align: "center"},
            {name: "day6", align: "center"},
            {name: "day7", align: "center"}
        ];
        // set day titles
        this.firstDayOfWeek = this.creator.firstDayOfWeek;
        var sdNames = Date.getShortDayNames();
        for (var i = 0; i < 7; i++) {
            this.fields[i].title = sdNames[(i + this.firstDayOfWeek) % 7];
        }
        // remove weekends
        if (!this.creator.showWeekends) {
            var weekendDays = Date.getWeekendDays();
            for (var i = 0; i < weekendDays.length; i++) {
                this.fields[(weekendDays[i] + this.firstDayOfWeek) % 7].showIf = "return false;";      
            }
            
        }
        this.Super("initWidget");
    },
    
    getDayArray : function () {
        var dayArr = [], eventArr, endDate,
            displayDate = new Date(this.creator.year, this.creator.month, 1);
        // go back to the first day of the week for the start date
        
        displayDate.setDate(displayDate.getDate()
                - displayDate.getDay()
                + this.firstDayOfWeek
                // start date may have a lower "day number" (sun=0 thru sat=6) than firstDayOfWeek,
                // in which case we need to adjust back by a week
                - ((displayDate.getDay() < this.firstDayOfWeek) ? 7 : 0)
        );
        // 40 days from start date seems like a nice round number for getting 
        // all the relevant events in a month, with extra days for adjacent months
        endDate = new Date(this.creator.year, this.creator.month, 
            displayDate.getDate() + 40);
        eventArr = this.creator._getEventsInRange(displayDate, endDate);
        // sort events by date
        eventArr.sortByProperty("name", true, 
            function (item, propertyName, context) {
                return item[context.startDateField].getTime();
            }, this.creator);
        this._eventIndex = 0;
        for (var i=0; i<6; i++) {
            
            if (this.creator.showDayHeaders) dayArr.add(this.getHeaderRowObject(displayDate));
            dayArr.add(this.getEventRowObject(displayDate, eventArr));
            displayDate.setDate(displayDate.getDate() + 7);
            if (displayDate.getMonth() != this.creator.month) break;
        }
        return dayArr;
    },
    
    getHeaderRowObject : function (theDate) {
        var obj = {};
        var nDate = new Date(theDate.getFullYear(), theDate.getMonth(), theDate.getDate());
        for (var i=0; i<7; i++) {
            obj["day" + (i + 1)] = nDate.getDate();
            // store the complete date
            obj["date" + (i + 1)] = new Date(nDate.getFullYear(), nDate.getMonth(), nDate.getDate());
            nDate.setDate(nDate.getDate() + 1);
        }
        return obj;
    },
    
    getEventRowObject : function (theDate, events) {
        var obj = {};
        var nDate = new Date(theDate.getFullYear(), theDate.getMonth(), theDate.getDate());
        for (var i=0; i<7; i++) {
            var evArr = [];
            while (this._eventIndex < events.length) {
                var evnt = events[this._eventIndex];
                if (evnt[this.creator.startDateField].getMonth() != nDate.getMonth() 
                    || evnt[this.creator.startDateField].getDate() != nDate.getDate()) {
                    break;    
                } else {
                    evArr.add(evnt);
                    this._eventIndex += 1;
                }
                
            }
            // store the day number here too
            obj["day" + (i + 1)] = nDate.getDate();
            // store the complete date
            obj["date" + (i + 1)] = new Date(nDate.getFullYear(), nDate.getMonth(), nDate.getDate());
            // store the events
            obj["event" + (i + 1)] = evArr;
            nDate.setDate(nDate.getDate() + 1);
        }
        return obj;
    },
    
     getDayFromCol : function (colNum) {
         var day = colNum;
         if (this.creator.showWeekends) {
            return (day + this.creator.firstDayOfWeek) % 7;    
         } else { 
            return (day + 1 + this.creator.firstDayOfWeek) % 7;
         }
    },
    
    // helper function for detecting when a weekend is clicked, and weekends are disabled
    colDisabled : function (colNum) {
        if (this.creator.disableWeekends 
            && Date.getWeekendDays().contains(this.getDayFromCol(colNum))) {
            return true;        
        } else {
            return false;   
        }
    },
    
    refreshEvents : function () {
        // bail if no data yet
        if (!this.creator.hasData()) return;
        this.logDebug('refreshEvents: month', 'calendar');
        this.setData(this.getDayArray());    
    },
    
    rowIsHeader : function (rowNum) {
        var cal = this.creator;
        if (!cal.showDayHeaders || (cal.showDayHeaders && rowNum % 2 == 1)) return false;
        else return true;
    },
    
    formatCellValue : function (value, record, rowNum, colNum) {
        var cal = this.creator,
            day = cal._getDayNum(colNum),
            evtArr = record["event" + (day + 1)],
            currDate = record["date" + (day + 1)],
            isOtherDay = currDate.getMonth() != cal.chosenDate.getMonth();
       
        if (this.rowIsHeader(rowNum)) {
            if (!cal.showOtherDays && isOtherDay) {
                return "";  
            } else {
                return cal.getDayHeaderHTML(currDate, evtArr, cal, rowNum, colNum); 
            }
        } else {
            if (!cal.showOtherDays && isOtherDay) {
                return "";  
            } else {
                return cal.getDayBodyHTML(currDate, evtArr, cal, rowNum, colNum); 
            }
        }
    },
    
    getRowHeight : function (record, rowNum) {
        var dayHeaders = this.creator.showDayHeaders;
        if (this.rowIsHeader(rowNum)) { // header part
            return this.dayHeaderHeight;
        } else { // event part, should use fixedRecordHeights:false
            var rows = dayHeaders ? this.data.length / 2 : this.data.length,
                viewHeight = dayHeaders ? this.body.getViewportHeight() 
                    - (this.dayHeaderHeight * rows) : this.body.getViewportHeight(),
                minHeight = dayHeaders ? this.mimimumDayHeight - this.dayHeaderHeight : 
                    this.minimumDayHeight;
            
            if (viewHeight / rows <= minHeight) { 
                return minHeight;
            } else {   
                // calculate the remainder and add 1 to the current row height if need be.
                // this eliminates a gap at the bottom of the month view
                var remainder = viewHeight % rows,
                    offset = 0,
                    currRow = dayHeaders ? (rowNum - 1) / 2 : rowNum
                ;
                if (currRow < remainder) offset = 1; 
                return (Math.floor(viewHeight / rows) + offset);   
            } 
        }
    },
    
    getCellAlign : function (record, rowNum, colNum) {
        if (this.rowIsHeader(rowNum)) return "right"
        else return "left";
    },
    
    getCellVAlign : function (record, rowNum, colNum) {
        if (!this.rowIsHeader(rowNum)) return "top";
        else return "center"
        
    },
    
    cellHoverHTML : function (record, rowNum, colNum) {
        // _getDayNum for not showing weekends
        var day = this.creator._getDayNum(colNum);
        if (!this.rowIsHeader(rowNum) && record["event" + (day + 1)] != null) {
            var evtArr = record["event" + (day + 1)];
            var retVal = "";
            for (var i = 0; i < evtArr.length; i++) {
                var eTime = evtArr[i][this.creator.startDateField].getHours();
                eTime = this.creator._to12HrNotation(eTime) + (eTime > 11 ? "P " : " "); 
                retVal += eTime + evtArr[i][this.creator.nameField] + "<br/>";
            }
          
            return retVal;
        }
    },
    
    getBaseStyle : function (record, rowNum, colNum) {
        var cal = this.creator, dayNum = cal._getDayNum(colNum) + 1;
        
        if (this.rowIsHeader(rowNum)) { // header
            if ((rowNum == 0 && record["day" + dayNum] > 7)
                || (rowNum == this.data.length - 2 && record["day" + dayNum] < 7)) {
                if (!cal.showOtherDays) return cal.otherDayBlankStyle;
                else return cal.otherDayHeaderBaseStyle;
            } else return cal.dayHeaderBaseStyle;
        } else { // body
            var dis = this.colDisabled(colNum), 
                startRow = cal.showDayHeaders ? 1 : 0, endRow = this.data.length - 1;
                
            if ((rowNum == startRow && this.data[startRow]["day" + dayNum] > 7)
                || (rowNum == endRow && this.data[endRow]["day" + dayNum] < 7)) {
                if (!cal.showOtherDays) return cal.otherDayBlankStyle;
                else return dis ? cal.otherDayBodyBaseStyle + "Disabled" : cal.otherDayBodyBaseStyle;
            } else return dis ? cal.dayBodyBaseStyle + "Disabled" : cal.dayBodyBaseStyle;      
        }
    },
    
    // monthView cellClick
    // if a header is clicked, go to that day. Otherwise, open the event dialog for that day.    
    cellClick : function (record, rowNum, colNum) {
        var cal = this.creator, year, month, day = cal._getDayNum(colNum) + 1,
            currDate = record["date" + day],
            evtArr = record["event" + day],
            isOtherDay = cal.chosenDate.getMonth() != currDate.getMonth(),
            doDefault = false;
        if (this.rowIsHeader(rowNum)) { // header clicked
            if (!(!this.creator.showOtherDays && isOtherDay)) {
                doDefault = cal.dayHeaderClick(currDate, evtArr, cal, rowNum, colNum);        
            }
            if (doDefault) {
                // previous month day clicked
                if (rowNum == 0 && record["day" + day] > 7) {
                    // check for previous year boundaries
                    if (cal.month == 0) {
                        year = cal.year - 1;
                        month = 11;
                    } else {
                        year = cal.year;
                        month = cal.month - 1;
                    }
                } else if (rowNum == this.data.length - 2 && record["day" + day] < 7) {
                    // check for next year boundaries
                    if (cal.month == 11) {
                        year = cal.year + 1;
                        month = 0;
                    } else {
                        year = cal.year;
                        month = cal.month + 1;
                    }
                } else {
                    year = cal.year;
                    month = cal.month;
                }
                
                cal.dateChooser.dateClick(year, month, record["day" + day]);
                cal.selectTab(0);
            }
        } else { // day body clicked 
            if (!this.colDisabled(colNum) && !(!cal.showOtherDays && isOtherDay)) {   
                 doDefault = cal.dayBodyClick(currDate, evtArr, cal, rowNum, colNum);
                 if (doDefault && cal.canCreateEvents) {
                     cal._showEventDialog(rowNum, colNum);
                 }     
            }
           
        }
    }
    
    
    
    
});

// EventWindow
//---------------------------------------------------------------------------------------------
isc.ClassFactory.defineClass("EventWindow", "Window");

isc.EventWindow.changeDefaults("resizerDefaults", {
    overflow:"hidden", height: 3,
    snapTo: "B", 
    canDragResize:true, getEventEdge:function () {return "B"} 
})

isc.EventWindow.changeDefaults("headerDefaults", {
    layoutMargin:0, layoutLeftMargin:3, layoutRightMargin:3
})

isc.EventWindow.addProperties({
    autoDraw: false,
    minHeight: 5,
    showHover: true, 
    canHover: true,
    hoverWidth: 200,
    showHeaderIcon: false,
    showMinimizeButton: false,
    showMaximimumButton: false,
    canDragResize: true,
    canDragReposition: true,
    resizeFrom: ["B"],
    showShadow: false,
    showEdges: false,
    showHeaderBackground: false,
    useBackMask: false,
    keepInParentRect: true,
    headerProperties: {height:14},
    
    closeButtonProperties: {height: 10, width: 10},
    bodyColor: null,
    
    showFooter: true,
    footerProperties: {overflow:"hidden", defaultLayoutAlign:"center", height: 7},
    bodyConstructor: isc.HTMLFlow,
    
    initWidget : function () {
        this.bodyStyle = this.baseStyle + "Body";
        this.headerStyle = this.baseStyle + "Header";
        this.bodyProperties = {contents: this.descriptionText, valign:"top", 
            overflow: "hidden"};
        this.headerLabelProperties = {styleName: this.className + "Header"};
 
        this.Super("initWidget", arguments);
    },
    
    makeFooter : function () {
        // if not showing a footer, bail
        if (!this.showFooter || this.canDragResize == false) return;
        
        var rsizer = this.createAutoChild("resizer", {
            dragTarget:this,
            styleName: this.baseStyle + "Resizer"
        });
        this.addChild(rsizer);
        
        // needs to be above the statusBar
        if (this.resizer) this.resizer.bringToFront();
    },
    
    setDescriptionText : function (descriptionText) {
        this.descriptionText = descriptionText;
        this.body.setContents(descriptionText);
    },
    
    click : function () {
        if (this._closed) return;
        var cal = this.calendar;
        var doDefault = cal.eventClick(this.event, this._isWeek ? "week" : "day");
        if (doDefault) {
            if (!cal.canEditEvent(this.event)) return;
            // handle the case when a selection is made, then an event is clicked
            if (this._isWeek) cal.weekView.clearSelection();
            else cal.dayView.clearSelection();
            var offset = cal.weekView.isLabelCol(0) ? 1 : 0;
            var col = this._isWeek ? this.event[cal.startDateField].getDay() - 
                cal.firstDayOfWeek + offset : offset;
            // account for no weekends shown
            if (this._isWeek && cal.showWeekends == false) col--;
            var row =  this.event[cal.startDateField].getHours() * 2;
            cal._showEventDialog(row, col, null, this);
        }
    },
   
    mouseDown : function () {
        this.calendar.eventDialog.hide();
        return isc.EH.STOP_BUBBLING;
    },
    
    sizeToEvent : function () {
        var cal = this.calendar, event = this.event;
        // don't resize when we're dragRepositioned
        if (!this._skipResize) {
            var grid = (this._isWeek ? cal.weekView : cal.dayView);
            
            var rowSize = grid.getRowHeight(1),
                colSize = grid.getColumnWidth(grid.isLabelCol(0) ? 1 : 0);
            // catch the case where the end of the event is on 12am, which happens when an
            // event is dragged or resized to the bottom of the screen
            var eHrs = event[cal.endDateField].getHours() == 0 ? 24 
                     : event[cal.endDateField].getHours();
            var eHeight = (eHrs - event[cal.startDateField].getHours()) * (rowSize * 2),
                eWidth = colSize; 
            // for border overlap
            if (cal.weekEventBorderOverlap && this._isWeek) eWidth += 1; 
            if (event[cal.startDateField].getMinutes() > 0) {
                eHeight -= cal._getMinutePixels(event[cal.startDateField].getMinutes(), rowSize);
            }
            if (event[cal.endDateField].getMinutes() > 0) {
                eHeight += cal._getMinutePixels(event[cal.endDateField].getMinutes(), rowSize);
            }
           
            var eTop = event[cal.startDateField].getHours() * (rowSize * 2);
            if (event[cal.startDateField].getMinutes() > 0) {
                eTop += cal._getMinutePixels(event[cal.startDateField].getMinutes(), rowSize);
            }
            // milliseconds in a day
            var oneday = 1000 * 60 * 60 * 24;
            var accountForLabelCol = (grid.showLabelColumn && 
                    grid.labelColumnPosition == "left");
            var weekendOffset = cal.showWeekends ? 0 : oneday;
            
            var eLeft = accountForLabelCol ? grid.labelColumnWidth : 0;
            if (grid._isWeek) {
                eLeft = (Math.floor((event[cal.startDateField].getTime() 
                    - cal.chosenWeekStart.getTime() - weekendOffset) / oneday) * colSize) 
                    + (accountForLabelCol ? grid.labelColumnWidth : 0);                 
            }
            
            this.resizeTo(eWidth, eHeight);
            this.moveTo(eLeft, eTop);
        } else {
            this._skipResize = false;
        }
        var sHrs = event[cal.startDateField].getHours();
        var sMins = event[cal.startDateField].getMinutes();
        var eTitle = cal._to12HrNotation(sHrs) + (sMins < 10 ? ":0" + sMins : ":" + sMins)
            + (sHrs > 11 ? "PM" : "AM") + " " + event[cal.nameField];  
       
        this.setTitle(eTitle);
        
    },
    
    getHoverHTML : function () {
        var cal = this.calendar, event = this.event;
        // start time
        var sHrs = event[cal.startDateField].getHours();
        var sMins = event[cal.startDateField].getMinutes();
        var sTime = cal._to12HrNotation(sHrs) + (sMins < 10 ? ":0" + sMins : ":" + sMins)
            + (sHrs > 11 ? "PM" : "AM");  
        
        // end time
        var eHrs = event[cal.endDateField].getHours();
        var eMins = event[cal.endDateField].getMinutes();
        var eTime = cal._to12HrNotation(eHrs) + (eMins < 10 ? ":0" + eMins : ":" + eMins)
            + (eHrs > 11 ? "PM" : "AM");
            
        return event[cal.startDateField].toShortDate() + " "
            + sTime + " - " + eTime
            + "</br></br>"
            + event[cal.nameField] + "</br></br>" 
            + event[cal.descriptionField];
        
    },
    
    closeClick : function () {
        this.Super('closeClick');
        this.calendar.removeEvent(this.event, true);
        this._closed = true;               
    },
    
    parentResized : function () {
        this.Super('parentResized', arguments);
        this.sizeToEvent();       
    },
    
    // get event length in minutes
    getEventLength : function () {
        var start = this.event[this.calendar.startDateField];
        var end = this.event[this.calendar.endDateField];
        var tot = (end.getHours() - start.getHours()) * 60;
        tot = tot - start.getMinutes() + end.getMinutes();
        return tot;
    },
    
    dragRepositionStart : function () {
        // for drag repositioning, calculate the offset (vsnaporigin) by calculating how much is left
        // over when you divide the events top y coordinate by the snapVGap. This is added 
        // to the y coordinate calculated in GR.getVSnapPosition 
        var snapOrigin = this.getTop() % this.parentElement.snapVGap;
        this.parentElement.VSnapOrigin = snapOrigin;
    },
    
    
    dragRepositionStop : function () {
        
        this.Super('dragRepositionStop', arguments);
        var EH = this.ns.EH,
            colNum = this.parentElement.getEventColumn(),
            dragTop = (EH.dragMoveTarget.getTop() - this.parentElement.getPageTop()) 
                + this.parentElement.getScrollTop(),
            rowHeight = this.parentElement.getRowSize(1),
            
            rowNum = Math.floor(dragTop / rowHeight), //this.parentElement.getEventRow(),
            cal = this.calendar,
            grid = (this._isWeek ? cal.weekView : cal.dayView);
        
        if (grid.isLabelCol(colNum) || grid.colDisabled(colNum)) return false;
        
        var sDate = cal._getDateFromPoint(rowNum, colNum);
        // for cases where the event is dropped between row bounds, get the minutes we need
        // to add to the drop start time. The formula for these minutes:
        // drop position pixels from drop row top * minutes per pixel
        var leftOverMins = Math.floor((dragTop - (rowHeight * rowNum)) * (30 / rowHeight));        
        sDate.setMinutes(sDate.getMinutes() + leftOverMins);
        // bulletproof the startDate by calling getValidSnapDate(), which ensures that the start
        // date will be an exact multiple of the eventSnapGap
        sDate = cal.getValidSnapDate(this.event[cal.startDateField], sDate);
        
        if (!cal.eventMoved(sDate, this.event)) return false;
        
        var eDate = new Date(sDate.getFullYear(), sDate.getMonth(), sDate.getDate(), sDate.getHours(), sDate.getMinutes());
        eDate.setMinutes(eDate.getMinutes() + this.getEventLength());
        
        
        //this._skipResize = true;
        cal.updateEvent(this.event, sDate, eDate, this.event[cal.nameField], 
            this.event[cal.descriptionField], true);
        return true;
           
    },
    
    dragResizeStart : function () {   
        // for drag resizing, calculate the offset (vsnaporigin) by calculating how much is left
        // over when you divide the events bottom y coordinate by the snapVGap. This is added 
        // to the y coordinate calculated in GR.getVSnapPosition
        var snapOrigin = (this.getTop() + this.getVisibleHeight()) % this.parentElement.snapVGap;
        this.parentElement.VSnapOrigin = snapOrigin; 
       
          
    },
    
    dragResizeStop : function () {
        this.Super('dragResizeStop', arguments);
        var EH = this.ns.EH,
            colNum = this.parentElement.getEventColumn(),
            dragBottom = (EH.dragMoveTarget.getTop() - this.parentElement.getPageTop()) 
                + this.parentElement.getScrollTop() + EH.dragMoveTarget.getVisibleHeight(),
            rowHeight = this.parentElement.getRowSize(1),
            rowNum = Math.floor(dragBottom / rowHeight), //this.parentElement.getEventRow(),
            cal = this.calendar;
        
        var eDate = cal._getDateFromPoint(rowNum, colNum);
        
        // for cases where the event is dropped between row bounds, get the minutes we need
        // to add to the drop start time. The formula for these minutes:
        // drop position pixels from drop row top * minutes per pixel
        var leftOverMins = Math.floor((dragBottom - (rowHeight * rowNum)) * (30 / rowHeight));
        eDate.setMinutes(eDate.getMinutes() + leftOverMins);
        // bulletproof the endDate by calling getValidSnapDate(), which ensures that the end
        // date will be an exact multiple of the eventSnapGap
        eDate = cal.getValidSnapDate(this.event[cal.endDateField], eDate);
        // don't allow smaller than rowHeight events
        if (EH.dragMoveTarget.getVisibleHeight() < rowHeight) return false;
        
        if (!cal.eventResized(eDate, this.event)) return false;
        //this._skipResize = true;
        cal.updateEvent(this.event, this.event[cal.startDateField], eDate,
         this.event[cal.nameField], this.event[cal.descriptionField], true);
        // let getVSnapOrigin know that dragResize is over
        this._dragResizing = false;
    }
    
             
});

isc.Calendar.registerStringMethods({
        getDayBodyHTML : "date,events,calendar,rowNum,colNum",
        getDayHeaderHTML : "date,events,calendar,rowNum,colNum",
        dayBodyClick : "date,events,calendar,rowNum,colNum",
        dayHeaderClick : "date,events,calendar,rowNum,colNum",
        eventClick : "event,viewName",
        eventChanged : "event",
        eventMoved : "newDate,event",
        eventResized : "newDate,event"        
});

isc.DaySchedule.addClassProperties({

_eventScaffolding: [
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 5
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 10
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 15
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 20
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, 
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 24
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 5
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 10
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 15
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, // 20
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""}, 
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""},
    {label:"", day1:"", day2:"", day3:"", day4:"", day5:"", day6:"", day7:""} // 24
]

});

