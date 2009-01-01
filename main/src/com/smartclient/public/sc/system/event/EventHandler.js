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

 

//>	@class	EventHandler
//
// The ISC system provides a predictable cross-browser event-handling mechanism for ISC
// widgets. Events can be handled both at the page level (i.e., globally), and at the level of
// individual widgets.
// <p>
// With the exception of a few page-specific events ('load', 'unload', 'idle' and 'resize'),
// events are processed in the following sequence:
// <p>
// 1. The event is sent to any global (page-level) event handlers. These handlers can cancel
// further propagation of the event by returning false.  You can register to listen for any of the
// events linked in the seeAlso section (below) by calling +link{classMethod:Page.setEvent()}
// method.
// <p>
// 2. If the event occurred on a form element or a link, it is passed on to the browser so that
// the element will perform its default action. No widget receives the event.
// <p>
// 3. If the event occurred on an enabled widget (but not on a form element or link inside
// the widget), it is sent to that widget's event handler, if any. This handler can cancel
// further propagation of the event by returning false.  An "enabled" widget is any widget that
// defines an event handler for one of the supported events.  Interceptable events are defined in
// the +link{class:Canvas#methods#events, "widgetEvents" section of Canvas}.
// <p>
// 4. The event is "bubbled" up to the widget's parent in the containment hierarchy, if any.
// Again, the parent's handler for the event can cancel further propagation by returning
// false. This step is repeated, with the event "bubbling" up through the containment
// hierarchy, until a top-level widget is reached or the event is explicitly canceled.
// In brief, the ISC event model offers the best features of browser event models:
// <ul>
// <li> Page-first event handling allows you to reliably process or cancel any event before it
//      affects the objects on the page.
// <li> Event "bubbling" ensures that parent widgets receive events sent to their children,
//      and allows you to create generalized parent-level handlers rather than duplicating
//      code in each child.
// </ul>
// Note: Canceling propagation of an event may cancel its side effects as well, including the
// generation of other (synthetic) events. For example, if a global mouseDown handler returns
// false, drag-and-drop events will not be generated. Specific effects are discussed in the
// descriptions of the various events in the following sections.
// <p>
// SmartClient libraries will not interfere with native event handling when events occur
// outside of a target widget. You can therefore have HTML that is not ISC-based on the same
// page as widget objects that will react to native events as you would expect.
// <p>
// You can use isc.Event as an alias for isc.EventHandler.
// 
// @see type:PageEvent    
// @see classMethod:Page.setEvent()
// @see classMethod:Page.clearEvent()
// @see class:Canvas#methods#widgetEvents
//
// @treeLocation   Client Reference/System
// @visibility external
//<




// create the isc.EventHandler object
isc.ClassFactory.defineClass("EventHandler");
// nicknames - isc.Event is publicly documented as an alias
isc.EH = isc.Event = isc.EventHandler;
// add class properties and constants
isc.EventHandler.addClassProperties(
{ 	
    //>	@classAttr	isc.EventHandler.lastEvent		(object : {} : IRWA)
	//		Last event that was processed by our event system.  We store the properties
	//		 of the event in a separate object so we can access them uniformly on both
	//		 platforms and so we can remember characteristics of the last event we've
	//		 seen even when we're not in the script context of this event.<br><br>
	//		
	//		To access properties of the last event, use:<ul>
	//			<li>isc.EventHandler.getLastEvent()
	//			<li>isc.EventHandler.getX()
	//			<li>isc.EventHandler.getY()
	//			<li>isc.EventHandler.getScreenX()
	//			<li>isc.EventHandler.getScreenY()
	//			<li>isc.EventHandler.getButtonNum()
	//			<li>isc.EventHandler.leftButtonDown()
	//			<li>isc.EventHandler.rightButtonDown()
	//			<li>isc.EventHandler.getKey()
    //          <li>isc.EventHandler.getKeyEventCharacterValue()
    //          <li>isc.EventHandler.getKeyEventCharacter()
	//			<li>isc.EventHandler.shiftKeyDown()
	//			<li>isc.EventHandler.ctrlKeyDown()
	//			<li>isc.EventHandler.altKeyDown()
	//			<li>isc.EventHandler.metaKeyDown()
    //      </ul>
	//
	//		@group events
	//		@see	isc.EventHandler.getMouseEventProperties()
    //      @see    isc.EventHandler.getKeyEventProperties()
    //  @visibility eventhandler
	//<
	lastEvent : {},						
	
    //>	@classAttr	isc.EventHandler._dropRegistry		(array : [] : IRWA)
	//		Registry of canvases that are interested in receiving drop events.
	//		@group dragdrop
	//		@see	isc.EventHandler.eventHandledNatively()
    //  @visibility internal
	//<
    _dropRegistry : [],			        

	//>	@classAttr	isc.EventHandler._maskRegistry		(array : [] : IA)
	//		Registry of canvases that have their own _eventMask peers to block mouse
	//		events. Implemented so that canvases with contentsURL (iframe contents)
	//		won't swallow events during drag & drop. When a drag operation begins,
	//		we show the masks for all canvases in this registry.
    // @visibility internal
	//<
	_maskRegistry : [],
	
	//>	@classAttr	isc.EventHandler.passThroughEvents		(boolean : true : IRWA)
	//			if true, we pass events to anchors and form elements automatically.
	//			false == trap these events
	//		@see	isc.EventHandler.eventHandledNatively()
    // @visibility internal
	//<
	passThroughEvents:true,

	//>	@classAttr	isc.EventHandler.maskNativeEvents (boolean : true : IRWA)
	//      Whether the clickmask should mask events on non ISC-elements as well.  
    // @visibility internal
	//<
    maskNativeTargets:true,
						
	//=	@const	isc.EventHandler.STILL_DOWN_DELAY	amount of time between mouseStillDown messages (msec)
	STILL_DOWN_DELAY 	: 100,
	//=	@const	isc.EventHandler.DOUBLE_CLICK_DELAY	amount of time between doubleClicks (msec)
    
	DOUBLE_CLICK_DELAY  : 500,
    //=	@const	isc.EventHandler.IDLE_DELAY			amount of time between idle messages (msec)
	IDLE_DELAY 			: 10,

    //=	@const	isc.EventHandler.STOP_BUBBLING		return this from a child event to stop the event propagating to its parent
	STOP_BUBBLING : "***STOP***",		


	//=	@const	isc.EventHandler.ALL_EDGES	default set of edges to resize from (all)
	ALL_EDGES : ["T","L","B","R","TL","TR","BL","BR"],

    eventTypes :	{	
        // Events are documented on Canvas as methods since that's how we expect users to register
        // them on widgets.  Some are also documented here for reference by Page.setEvent()

        //> @type PageEvent
        //
        // Events registerable via +link{classMethod:Page.setEvent()}
        //
        // 
        // @value "idle" 
        //        Fires repeatedly (every 10 ms by default) when the system is idle (i.e.,
        //        not busy running other scripts) after the page is loaded.
        // @value "load" 
        //        Fires when the page has finished loading. It corresponds to the
        //        browser 'load' event normally handled by window.onload.
        // @value "unload" 
        //        Fires when the page is exited or unloaded. It corresponds to the
        //        browser 'unload' event normally handled by window.onunload.
        // @value "resize" 
        //        Fires when the browser window is resized by the user. It corresponds
        //        to the browser 'resize' event normally handled by window.onresize.    
        //
        //
        // @value "mouseDown"
        //        Fires when the left mouse button is pressed on the Page.
        // @value "rightMouseDown"
        //        Fires when the right mouse button is pressed on the Page.
        // @value "mouseMove"
        //        Fires when the mouse moves on the Page.
        // @value "mouseUp"
        //        Fires when the left mouse button released on the Page.
        // @value "cick"
        //        Fires when the user clicks the mouse on the Page.
        // @value "doubleClick"
        //        Fires when the uesr double-clicks on the Page.
        //
        // @value "showContextMenu"
        //        Fires when the right mouse button is clicked on the page.  If your event handler
        //        for this event returns false, the native browser context menu will be suppressed.<br>
        //        Note: On the Macintosh platform, <code>Command+Click</code> may be used instead
        //        of right-button click to trigger a context menu event.<br>
        //        On the Opera browser, <code>Ctrl+Shift+Click</code> should be used instead of
        //        right-button click.
        //
        // @value "keyPress" Fires when a user presses a key on the keyboard. 
        //
        // see classMethod:Page.setEvent()
        // see classMethod:Page.clearEvent()
        // @visibility external
        //<
        
    	MOUSE_DOWN : "mouseDown",
    	RIGHT_MOUSE_DOWN : "rightMouseDown",
    	MOUSE_MOVE : "mouseMove",			
    	MOUSE_UP : "mouseUp",				    
    	SHOW_CONTEXT_MENU : "showContextMenu",	

        CLICK : "click",		
    	DOUBLE_CLICK : "doubleClick",		
    	// the following mouse events are not available on Page 
    	MOUSE_OUT : "mouseOut",				
    	MOUSE_STILL_DOWN : "mouseStillDown",
    	MOUSE_OVER : "mouseOver",


        // XXX classify
    	SET_DRAG_TRACKER : "setDragTracker",
        GET_DRAG_DATA : "getDragData",      
        RELEASE_DRAG_DATA : "releaseDragData", 
        

        DRAG_START:"dragStart",
        DRAG_STOP:"dragStop",  
    	DRAG_MOVE : "dragMove",
    	DRAG_OUT : "dragOut",	
        DRAG_REPOSITION_START : "dragRepositionStart",
        DRAG_REPOSITION_MOVE : "dragRepositionMove",
        DRAG_REPOSITION_STOP : "dragRepositionStop",
        DRAG_RESIZE_START : "dragResizeStart",
        DRAG_RESIZE_MOVE : "dragResizeMove",
        DRAG_RESIZE_STOP : "dragResizeStop",

    	DROP_OVER : "dropOver",
    	DROP_MOVE : "dropMove",
    	DROP_OUT : "dropOut",
    	DROP : "drop",			
    
    	KEY_DOWN : "keyDown",	
    	KEY_UP : "keyUp",		
    	KEY_PRESS : "keyPress",	
        MOUSE_WHEEL : "mouseWheel",
    	
    	SELECT_START : "selectStart",
        SELECTION_CHANGE : "selectionChange",
        FOCUS_IN : "focusIn",
        FOCUS_OUT : "focusOut",

    	IDLE : "idle",				
    	LOAD : "load",						
    	UNLOAD : "unload",					
    	RESIZE : "resize"
    },
    
    // Map used by getMouseEventProperties to convert from native mouse event names to 
    // canonicalized versions (available as constants on the EH class).
    _nativeMouseEventMap : {
        // By default all browsers give lowercase event names for the following events*
        //  *Verified on IE6, Windows; Moz 1.73, Windows; Safari 2, Mac; Moz 1.6, Unix;
        mousemove:"mouseMove",
        mousedown:"mouseDown",
        mouseup:"mouseUp",

        // Proprietary to IE6
        mousewheel:"mouseWheel",
        selectionchange:"selectionChange",
        // Proprietary to Moz
        DOMMouseScroll:"mouseWheel",

        
        // Also handle being passed an already canonicalized version - may happen if the 
        // event passed to getMouseEventProperrties was an ISC event rather than a native event
        mouseMove:"mouseMove",
        mouseDown:"mouseDown",
        mouseUp:"mouseUp",
        mouseWheel:"mouseWheel",
        
        selectionstart:"selectionStart",
        selectionStart:"selectionStart",
        selectionchange:"selectionChange",
        selectionChange:"selectionChange"
        
    },

    //> @const isc.EventHandler._eventHandlerArgString    
    // Argument string for event handler stringMethods
    // @visibility internal
    //<
    _eventHandlerArgString:"event,eventInfo",   

	//>	@type	DragOperation
	// Builtin types of drag and drop interactions
	//		@group	dragdrop
    //	@value	isc.EventHandler.DRAG_RESIZE			Resizing by dragging
	DRAG_RESIZE : "dragResize",			
    //	@value	isc.EventHandler.DRAG_REPOSITION		Repositioning by dragging
	DRAG_REPOSITION : "dragReposition",	
    //	@value	isc.EventHandler.DRAG			General drag (custom implementation)
	DRAG : "drag",
	//<										

    //>	@type	DragAppearance
    // 		Different types of effects for showing dragging behavior.
    //	@group	dragdrop
	//	@visibility external
    //
    //	@value	"none"
    //      No default drag appearance is indicated. Your custom dragging routines should
    //      implement some behavior that indicates that the user is in a dragging situation,
    //      and where the mouse is.
	NONE : "none",
    //	@value	"tracker"
    //      A "drag tracker" object is automatically shown and moved around with the
    //      mouse. This is generally set to an icon that represents what is being dragged. The
    //      default tracker is a 10 pixel black square, but you can customize this icon. This
    //      dragAppearance is not recommended for use with drag resizing or drag moving.
	TRACKER : "tracker",
    //	@value	"target"
    //      The target object is actually moved, resized, etc. in real time. This is
    //      recommended for drag repositioning, but not for drag resizing of complex objects.
	TARGET : "target",
    //	@value	"outline"
    //      An outline the size of the target object is moved, resized, etc. with the
    //      mouse. This is recommended for drag resizing, especially for objects that take a
    //      significant amount of time to draw.
	OUTLINE : "outline",
    //<	

    //>	@type DragIntersectStyle
    // Different styles of determining intersection: with mouse or entire rect of target
    //
    // @value "mouse" Look for drop targets that are under the current mouse cursor position.
	INTERSECT_WITH_MOUSE : "mouse",
    // @value "rect" Look for drop targets by intersection of the entire rect of the drag
    //               target with the droppable target.
	INTERSECT_WITH_RECT : "rect",
    // @group dragdrop
	// @visibility external
    //<

    
    //>	@classAttr  dragTargetShadowDepth   (number : 10 : IRWA);
    //  If we are showing a shadow for some widget on drag, how deep should the shadow be.
    //  @group  dragdrop
    //<
    dragTargetShadowDepth : 10,



	_anchorTags : {
        A : true,
        AREA : true
    },
	_formTags : {
        INPUT : true,
        TEXTAREA : true,
        SELECT : true,
        OPTION : true
    },
    _labelString : "LABEL",

    // native event name to camelCase name
    _nativeKeyEventMap : {
        keydown:"keyDown",
        keyup:"keyUp",
        keypress:"keyPress"
    },

    
    _nonCharacterKeyMap : {
        Backspace:8,
        Tab:9,
        Shift:16,
        Ctrl:17,
        Alt:18,
        Pause_Break:19,
        Caps_Lock:20,
        // Note - escape seems to be a special case - it gives us no character value, but will fire 
        // a keyPress event natively
//        Escape:27,
        Page_Up:33,
        Page_Down:34,
        End:35,
        Home:36,
        Arrow_Left:37,
        Arrow_Up:38,
        Arrow_Right:39,
        Arrow_Down:40,
        Insert:45,
        Delete:46,
        Meta:91,
        //Meta:92,  
        f1:112,
        f2:113,
        f3:114,
        f4:115,
        f5:116,
        f6:117,
        f7:118,
        f8:119,
        f9:120,
        f10:121,
        f11:122,
        f12:123,        
        Num_Lock:144,
        Scroll_Lock:145
    },
    
    

    // Virtual key map
    // virtual key code mappings for every key on the keyboard.
    // Note: While each code maps to a separate key, we're normalizing to a key name - IE
    // we're not going to differentiate between Enter on the keyboard and Enter on the numeric 
    // key pad (we can't in some cases on some browsers anyway, and this functionality would be
    // confusing if you weren't expecting it)
    

    // JSDoc the developer friendly keynames - these are required for accessKeys, registering
    // page level key events, etc.
    //> @type KeyName
    //
    // Strings to identify the various keys on the keyboard.
    // <ul>
    // <li>  For alpha keys, the single (uppercase) character value is used, such as "Q"
    // <li>  For Numeric keys, the number is used as in a single character string, like "1"
    // <li>  Function keys are identified as <code>"f1"</code> - <code>"f12"</code>
    // <li>  Non alpha-numeric character keys (such as the key for "[" / "{") are identified by
    //       their unmodified character value (the value obtained by hitting the key without 
    //       holding shift down), by default - exceptions are listed below.
    // <li>  Additional key names:<br>
    //      - <code>Space</code><br>    
    //      - <code>Tab</code><br>    
    //      - <code>Enter</code><br>
    //      - <code>Escape</code><br>
    //      - <code>Backspace</code><br>
    //      - <code>Insert</code><br>
    //      - <code>Delete</code><br>
    //      - <code>Arrow_Up</code><br>
    //      - <code>Arrow_Down</code><br>
    //      - <code>Arrow_Left</code><br>
    //      - <code>Arrow_Right</code><br>            
    //      - <code>Home</code><br>
    //      - <code>End</code><br>
    //      - <code>Page_Up</code><br>    
    //      - <code>Page_Down</code><br>   
    //      - <code>Shift</code><br>
    //      - <code>Ctrl</code><br>
    //      - <code>Alt</code>
    // </ul>
    // [Note: Some keys may not be available for capture on every platform]
    // @visibility external
    //<
    // Avoid doc'ing keys we may not be able to capture, or which are likely to vary based on 
    // OEM keyboard layout, etc.
    //      - <code>Print_Screen</code><br>
    //      - <code>Scroll_Lock</code><br>
    //      - <code>Caps_Lock</code><br>
    //      - <code>Pause_Break</code><br>
    //      - <code>Num_Lock</code><br>
    //      - <code>Menu</code><br>
    
    // Key Identifiers differ from keyNames in that we include modifier detection as a
    // boolean - used in a few places in the code
    //> @type KeyIdentifier
    // Identifiers for keys pressed by the user used by various methods.<br>
    // Valid <code>keyIdentifier</code>s can be either +link{KeyName} strings, or objects.<br>
    // If a <code>keyIdentifier</code> is specified as an object, it should have the following
    // properties:<br>
    // - <code>keyName</code>: name of the key<br>
    // - <code>ctrlKey</code>: optional boolean - true if ctrl is down.<br>
    // - <code>shiftKey</code>: optional boolean - true if shift is down.<br>
    // - <code>altKey</code>: optional boolean - true if alt is down.
    // @see type:KeyName
    // @visibility external
    //<
    _virtualKeyMap : {
        // Note - have to quote numeric property names for older browsers
        '0':'_undefined',
                        // 1  Left mouse button 
                        // 2  Right mouse button 
                        // 3  Control-break processing 
                        // 4  Middle mouse button (three-button mouse) 
        '8':'Backspace',
        '9':'Tab',
        
                        //  '12':'Clear',   
        '13':'Enter',

        '16':'Shift',
        '17':'Ctrl',
        '18':'Alt',
        '19':'Pause_Break',
        '20':'Caps_Lock',
                        // 21-25  Reserved for Kanji systems 

        '27':'Escape',
                        // 28-31  Reserved for Kanji systems 
        
        
        '32':'Space',
        '33':'Page_Up',
        '34':'Page_Down',
        '35':'End',
        '36':'Home',
        '37':'Arrow_Left',
        '38':'Arrow_Up',
        '39':'Arrow_Right',
        '40':'Arrow_Down',
                        // 41  SELECT key 
                        // 42  [Win32: "Original equipment manufacturer (OEM) specific"] 
                        // 43  EXECUTE key 
        '44':'Print_Screen',    // 44 PRINT SCREEN key for Win 3.0 and later 
        '45':'Insert',
        '46':'Delete',
                        // 47  HELP key 
        // Note: these are above the main keyboard (not on the numeric keypad)                        
        '48':'0', "49":"1", "50":"2", "51":"3", "52":"4", 
        "53":"5", "54":"6", "55":"7", "56":"8", "57":"9",
        
                        // 58-64  Undefined 

        // Standard Char keys                        
        '65':'A', '66':'B', '67':'C', '68':'D', '69':'E', '70':'F', 
        '71':'G', '72':'H', '73':'I', '74':'J', '75':'K', '76':'L', 
        '77':'M', '78':'N', '79':'O', '80':'P', '81':'Q', '82':'R',
        '83':'S', '84':'T', '85':'U', '86':'V', '87':'W', '88':'X',
        '89':'Y', '90':'Z',

        '91':'Meta',    // Meta Left
        '92':'Meta',    // Meta Right

        // 93  Application key [Win32: "Undefined"] 
        //      - from observation, this is returned from the 'context menu' key (next to the right
        //        meta key on windows 2k, IE and Moz, US keyboard) 
        '93':'Menu',
        
        //  94-95 Undefined 

        // keys on the numeric keypad                        
        '96':'0', '97':'1', '98':'2', '99':'3', '100':'4',
        '101':'5', '102':'6', '103':'7', '104':'8', '105':'9',

        '106':'*',  //  The Multiply key 
        '107':'+',  //  Add key  (on the keypad - not "=+")
                        // 108  Separator key 
        '109':'-',  //  Minus key
        '110':'.',  //  Decimal key
        '111':'/',  //  Divide key 

        '112':'f1', '113':'f2', '114':'f3', '115':'f4', '116':'f5', '117':'f6', 
        '118':'f7', '119':'f8', '120':'f9', '121':'f10', '122':'f11', '123':'f12',        
                        // 124-143  Unassigned 

        '144':'Num_Lock',
        '145':'Scroll_Lock',    // OEM specific - true on Windows

                        // 146-159  Unassigned 

        '160':'Shift',  //  Left SHIFT key [Win32: "Unassigned"] 
        '161':'Shift',  //  Right SHIFT key [Win32: "Unassigned"] 
        
        '162':'Ctrl',   //  Left CTRL key [Win32: "Unassigned"] 
        '163':'Ctrl',   //  Right CTRL key [Win32: "Unassigned"] 
        
        '164':'Alt',    //  Left ALT key [Win32: "Unassigned"] 
        '165':'Alt',    //  Right ALT key [Win32: "Unassigned"] 
        
                        //  166-185  Unassigned 
                        //  186-192  OEM specific   * See below

                        //  193-218  Unassigned 
                        //  219-228  OEM specific 
                        //  229  Precedes extended key [Win32: "Unassigned"] 
                        //  230  OEM specific 
                        //  231-232  Unassigned 
                        //  233-245  OEM specific 

        // xxx
        // There is no guarantee for the punctuation keys.  They will vary by locale and 
        // platform.
        // We can't ask for the keyboard mapping, and but let's handle the MS Windows US keyboard 
        // layout by default.
        // NOTE: this is one reason to make use of Ascii keycodes when we have them.
        
        '186':';',      //  VK_OEM_1 0xBA ";:" for US 
        '187':'=',      // '+',  VK_OEM_PLUS 0xBB "+" any country 
        '188':',',      //  VK_OEM_COMMA 0xBC "," any country 
        '189':'-',      //  VK_OEM_MINUS 0xBD "-" any country 
        '190':'.',      //  VK_OEM_PERIOD 0xBE "." any country 
        '191':'/',      //  VK_OEM_2 0xBF "/?" for US 
        '192':'`',      //  VK_OEM_3 0xC0 "`~" for US 
        
        
        '219':'[',      //  VK_OEM_4 0xDB "[{" for US 
        '220':'\\',     //  VK_OEM_5 0xDC "\|" for US 
        '221':']',      //  VK_OEM_6 0xDD "]}" for US 
        '222':"'"       //  VK_OEM_7 0xDE "'"" for US 

                        //  VK_OEM_AX 0xE1 AX key on Japanese AX keyboard 
                        //  VK_OEM_102 0xE2 "<>" or "\|" on RT 102-key keyboard 
                        
    },

 
    
    _charsetValueToKeyNameMap : {

        // Don't worry about any control characters that aren't directly mapped to a key
        // on the keyboard
        '8':'Backspace',
        '9':'Tab',
        '13':'Enter',
        '27':'Escape',

        // Normalize the character to the key name
        // Note: This is occasionaly ambiguous - such as when hitting "*", it could be the
        // * above the 8, or it could be the * on the keypad
        // Note: Choosing somewhat arbitrary names for the keys - just make sure this stays
        // constant.
        '32':'Space',   //' '
        '33':'1',   //'!'
        '34':"'",   //'"'
        '35':'3',   //'#',
        '36':'4',   //'$',
        '37':'5',   //'%',
        '38':'7',   //'&',
        
        '39':"'",
        '40':'9',   //'(',
        '41':'0',   //')',
        
        '42':'8',   //'*',  // May be wrong if on the keypad
        '43':'=',   //'+'   // May be wrong if on the keypad 
        
        '44':',',    '45':'-',     '46':'.',    '47':'/',
    
        '48':'0', '49':'1', '50':'2', '51':'3', '52':'4', 
        '53':'5', '54':'6', '55':'7', '56':'8', '57':'9',
        
        '58':';',    //':',
        '59':';',
    
        '60':',',   //'<',
        '61':'=',
        '62':'.',   //'>',
        '63':'/',   //'?',
    
        '64':'2',   //'@',  // an example of US-Only mapping
    
        '65':'A', '66':'B', '67':'C', '68':'D', '69':'E', '70':'F', '71':'G',
        '72':'H', '73':'I', '74':'J', '75':'K', '76':'L', '77':'M', '78':'N',
        '79':'O', '80':'P', '81':'Q', '82':'R', '83':'S', '84':'T', '85':'U',
        '86':'V', '87':'W', '88':'X', '89':'Y', '90':'Z',
        
        '91':'[',   '92':'\\',   '93':']',
        
        '94':'6',   //'^',
        '95':'-',   //'_',
        '96':'`',
    
        '97':'A',   //'a',
        '98':'B',   //'b',
        '99':'C',   //'c',
        '100':'D',  //'d',
        '101':'E',  //'e',
        '102':'F',  //'f',
        '103':'G',  //'g',
        '104':'H',  //'h',
        '105':'I',  //'i',
        '106':'J',  //'j',
        '107':'K',  //'k',
        '108':'L',  //'l',
        '109':'M',  //'m',
        '110':'N',  //'n',
        '111':'O',  //'o',
        '112':'P',  //'p',
        '113':'Q',  //'q',
        '114':'R',  //'r',
        '115':'S',  //'s',
        '116':'T',  //'t',
        '117':'U',  //'u',
        '118':'V',  //'v',
        '119':'W',  //'w',
        '120':'X',  //'x',
        '121':'Y',  //'y',
        '122':'Z',  //'z',
    
        '123':'[',  //'{',
        '124':'\\',  //'|',
        '125':']',  //'}',
        '126':'`'  //'~'           
        // Beyond this they are a bunch of special characters we should not need to worry about
        
    },

    
    _safariSpecialKeyPressMap : {
        '3':"Enter",
        
        '25':"Tab", // This happens with shift+tab

        '63232':"Arrow_Up",
        '63233':"Arrow_Down",
        '63234':"Arrow_Left",
        '63235':"Arrow_Right",

        // Note f8/f9/f10 don't fire an event - cos they take OS focus from the browser
        '64236':"f1", '64237':"f2", '64238':"f3", '64239':"f4", '64240':"f5", '64241':"f6", 
        '64242':"f7", '64243':"f8", '64244':"f9", '64245':"f10", '64246':"f11", '63247':"f12",

        '63273':"Home",
        '63275':"End",
        '63276':"Page_Up",
        '63277':"Page_Down"
    },
    
    
    // _eventHandlerMap - mapping between normal event names and names for internal handler 
    //  functions, eg "mouseDown" -> "handleMouseDown"
    // - Retrieve using "_getInternalHandlerName(event)"
    // - generated on the fly for any event name
    // (See comments in bubbleEvent())
    _eventHandlerMap : {
    },
    
	
    

    

    //>	@classAttr	isc.EventHandler.dragTrackerDefaults (object literal : _lookup_ : IA)
	//		Default properties for the drag tracker.
    // @visibility internal
	//<
    
	dragTrackerDefaults : { 							
			ID:"isc_dragTracker",
			width: 10,									
			height: 10,
            offsetX: -10,
            offsetY: -10,
            autoDraw: false,
            visibility:"hidden",
			overflow:"visible",
			cursor:"arrow"
	}
}
);// END isc.EventHandler.addClassProperties()

// Add each of the event types in isc.EventHandler.eventTypes directly to the event handler object
isc.EventHandler.addClassProperties(isc.EventHandler.eventTypes);

 
isc.EventHandler.addClassMethods({


handleSyntheticEvent : function (event) {

    var target = event.target;
    event._isSynthetic = true;
    //this.logWarn("synthetic event: " + isc.echoAll(event));

    if (target) {
        event.clientX += target.getPageLeft();
        event.clientY += target.getPageTop(); 
    
        
        if(isc.Browser.isIE) {
            /*
            this.logWarn("left margin: " +  target.getLeftMargin()
                         + " border: " + target.getLeftBorderSize()
                         + " padding: " + target.getLeftPadding());
            */
            event.clientX += target.getLeftMargin() + target.getLeftBorderSize()
                             + target.getLeftPadding() + 2;
            event.clientY += target.getTopMargin() + target.getRightBorderSize() 
                             + target.getTopPadding() + 2;
        }
        /*
        this.logWarn("synthetic event on: " + target.getID() 
                     + " ("+event.type+": "+event.clientX+", "+event.clientY+")");
        */

        switch (event.type) {
            case "mouseup": this.handleMouseUp(event); break;
            case "mousedown": this.handleMouseDown(event); break;
            case "mousemove": this.handleMouseMove(event); break;
        }
    }
},

//>	@classMethod	isc.EventHandler.handleEvent()  (A)
// Routine to handle generic events that are not handled specially 
//	 (currently everything but keyPress, mouseDown, mouseUp, mouseStillDown, mouseMove).
//
//		@group	eventHandling
//
//		@param	target		(object)	Canvas or DOM object that received the event
//		@param	eventType	(string) 	name of this event
//		@param	eventInfo	(any)		information passed with a custom event (see e.g. Slider)
//
//		@return			(boolean)	false == cancel further event processing
//									anything else == continue processing
//      @visibility eventhandler
//<

handleEvent : function (target, eventType, eventInfo) {
	
        var EH = isc.EH;
    
	// process the event globally
  	if (isc.Page.handleEvent(target, eventType, eventInfo) == false) return false;

	// if the target is enabled
	// 	bubble the event up the target's chain
	if (EH.targetIsEnabled(target) && EH.bubbleEvent(target, eventType, eventInfo)==false) {
		return false;
	}
	
	return true;
},


// Handler for the page-level load event.  Internal - developers use Page.setEvent() instead
handleLoad : function (DOMevent) {
    
    // ensure that SA_Page onload fires before Page's onload handlers.  The History module in
    // particular registers onload handlers that must fire before the Page onload, but because
    // IE's attachEvent() mechanism doesn't fire events in order of registration, we need to
    // kick SA_Page here.
    if (isc.SA_Page) isc.SA_Page._firePageLoadCallbacks();

    if (!isc.Browser.isMoz) {
        
        if (isc.EH._useEventListenerForUnload() && document && document.body) {
            document.body.addEventListener("unload", isc.EH.handleUnload, false);
        }

    	return (isc.Page.handleEvent(null, isc.EH.LOAD) != false);
    } else {
        try {
    	    return (isc.Page.handleEvent(null, isc.EH.LOAD) != false);
        } catch (e) {
            isc.Log._reportJSError(e);
            throw e;; // extra semi for Safari
        }
    }
},


// Handler for the page-level unload event.  Internal - developers use Page.setEvent() instead
handleUnload : function (DOMevent) {
	
        var EH = isc.EH;

    var result = (isc.Page.handleEvent(null, EH.UNLOAD) != false);
    
	return result;
},





// NOTE: naming: 
// - handleKey*Event: directly called by DOM
// - handleKey*: called on EH object

// called directly by DOM
_$f10:"f10",
_$Escape:"Escape",
_handleNativeKeyDown : function (DOMevent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page finishes loading.
	//	Just skip key event processing if the page hasn't loaded yet.
    //!DONTCOMBINE
	if (!isc.Page.isLoaded()) return false;
 
    
        var EH = isc.EH;

    
    

    var lastEvent = EH.lastEvent;
    
    if (!DOMevent) DOMevent = EH.getWindow().event;
    
    // Get the details of the event (stored in EH.lastEvent)
    EH.getKeyEventProperties(DOMevent);
    
    
    var syntheticKeypressFired = false,
        returnVal = true;
    
    if (EH._keyDownKeyName == lastEvent.keyName) {
        returnVal = EH.handleKeyPress();
        syntheticKeypressFired = true;
        
        
    } else returnVal = EH.handleKeyDown(DOMevent);

    
    EH._keyDownKeyName = lastEvent.keyName;
            
    
    if (returnVal != false && 
        ((isc.Browser.isIE && !syntheticKeypressFired && 
            EH._nonCharacterKeyMap[lastEvent.keyName] != null) ||
         (isc.Browser.isMoz && lastEvent.keyName == this._$f10 && this.shiftKeyDown()))
       ) 
    {
        returnVal = EH.handleKeyPress(DOMevent);
    }    

    return returnVal;
},

// handleKeyDown() fires the keyDown handler on the event target.
// called in response to document.keyDown _handleNativeKeyDown().

_$Tab:"Tab",
handleKeyDown : function (nativeEvent, scEventProperties) {
    var EH = isc.EH,
        lastEvent = EH.lastEvent,
        returnVal;

    // If the event is handled natively, we will avoid doing any of our own processing and
    // return true to allow native processing
    
    var handledNatively = EH.eventHandledNatively(lastEvent.eventType, lastEvent.nativeKeyTarget);
    if (handledNatively) returnVal = EH._handledNativelyReturnVal;

    if (scEventProperties != null) isc.addProperties(lastEvent, scEventProperties);
    
    if (!handledNatively) {    
    
        var eventInfo = [lastEvent, lastEvent.target, lastEvent.keyName];
            
        var target = lastEvent.keyTarget;
        //EH.logWarn("nativeEvent: " + EH.echoDOM(nativeEvent) +
        //           ", nativeTarget: " + EH.echoLeaf(lastEvent.nativeTarget));
    
        if (target == null) target = this.getEventTargetCanvas(nativeEvent,
                                                               lastEvent.nativeKeyTarget);

        if (EH.targetIsEnabled(target))
            returnVal = (EH.bubbleEvent(target, EH.KEY_DOWN, eventInfo) != false);
    }

    
    if (returnVal != false && this.clickMaskUp() && lastEvent.keyName == this._$Tab) {
        var topHardMask,
            registry = this.clickMaskRegistry;
        for (var i = registry.length-1; i >=0; i--) {
            if (this.isHardMask(registry[i])) {
                topHardMask = registry[i];
                break;
            }
        }
        if (topHardMask) returnVal = false;
    }
    
    return returnVal;
},

// called by DOM
_handleNativeKeyUp : function (DOMevent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page finishes loading.
	//	Just skip key event processing if the page hasn't loaded yet.
    //!DONTCOMBINE
	if (!isc.Page.isLoaded()) return false;
    
    var EH = isc.EH,
        lastEvent = EH.lastEvent;
    
    if (!DOMevent) DOMevent = EH.getWindow().event;        
    // get key event properties (stored in EH.lastEvent)
    EH.getKeyEventProperties(DOMevent);
        
    
    if (EH._keyDownKeyName == EH.lastEvent.keyName) {
        if (EH.handleKeyPress(DOMevent) == false) return false;
    }
    
    var returnVal = EH.handleKeyUp(DOMevent)
    
    return returnVal
},

// called on EH
handleKeyUp : function (nativeEvent, scEventProperties) {

    var EH = isc.EH,
        lastEvent = EH.lastEvent,
        eventInfo = [lastEvent,  lastEvent.target, lastEvent.keyName];    
        
    // If the event is handled natively, return true to allow native processing
    if (EH.eventHandledNatively(lastEvent.eventType, lastEvent.nativeKeyTarget)) {
        // Log.logWarn("keyup event handled natively - bailing");
        return EH._handledNativelyReturnVal;
    }
        

    var returnVal = true;

    if (scEventProperties != null) {
        isc.addProperties(lastEvent, scEventProperties);
    }
    
    var target = lastEvent.keyTarget;
    if (target == null) target = this.getEventTargetCanvas(nativeEvent,
                                                           lastEvent.nativeKeyTarget);

    if (EH.targetIsEnabled(target))
        returnVal = (EH.bubbleEvent(target, EH.KEY_UP, eventInfo) != false);

    
    // On Shift+f10 to show a SmartClient context menu, return false to cancel the keyUp event.
    if (!isc.Browser.isMac && lastEvent.keyName == EH._$f10 && EH.shiftKeyDown() && 	
        isc.Menu && isc.Menu._openMenus && isc.Menu._openMenus.length > 0) 
    {
        returnVal = false;
    }
        
    
    // Clear EH.lastEvent's key properties
    EH.clearKeyEventProperties();
    
    // Return true to allow processing to continue unless something explicitly returned false.
    return returnVal;
},

// called by DOM
_handleNativeKeyPress : function (DOMevent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip key event processing if the page hasn't loaded yet.
    //!DONTCOMBINE
	if (!isc.Page.isLoaded()) return false;

    
        var EH = isc.EH;

    // We already got the keyEventProperties stored in EH.lastEvent from the keyDown handler
    // However call to getKeyEventProperties required as keyCodes returned in IE are different
    // on keyDown and keyPress.
    
	var lastEvent = EH.lastEvent,
        eventType = EH.KEY_PRESS;

    if (!DOMevent) DOMevent = EH.getWindow().event;
            
    EH.getKeyEventProperties(DOMevent);
        
    
    lastEvent.eventType = eventType;

    
    if (isc.Browser.isMoz && lastEvent.keyName == this._$f10 && this.shiftKeyDown()) return;
    
    
        
    var returnVal = EH.handleKeyPress(DOMevent);
    return returnVal;

},

// called on EH 
handleKeyPress : function (nativeEvent, scEventProperties) {
    // We already got the keyEventProperties stored in EH.lastEvent from the keyDown handler
    // However call to getKeyEventProperties required as keyCodes returned in IE are different
    // on keyDown and keyPress.
	var EH = isc.EH,
        lastEvent = EH.lastEvent,
        eventType = EH.KEY_PRESS;

    // if passed already-derived event properties, apply them to the EH.lastEvent.
    if (scEventProperties != null) {
        isc.addProperties(lastEvent, scEventProperties);
    } 
    var eventInfo = {keyName:lastEvent.keyName, characterValue:lastEvent.characterValue};
       
    // update the eventType since this may be a synthetically generated keyPress event (from
    // keyUp or repeated keyDown events).
    lastEvent.eventType = eventType;
    
    
    EH._keyDownKeyName = null;

	// call the global keyPress event (Set up via Page.setEvent("keyPress",...) )
	if (isc.Page.handleEvent(lastEvent.keyTarget, eventType) == false) return false;
    
    // If eventHandledNatively returns true don't fire widget level handlers, or allow 
    // registered keys to fire their actions.
	// NOTE: in IE, this will return the key number so we pass that value on
	var it = (EH.eventHandledNatively(eventType, lastEvent.nativeKeyTarget));
    
	if (it !== false) {
        //>DEBUG
        EH.logDebug("keyPress handled natively");
        //<DEBUG
        return EH._handledNativelyReturnVal;
        
    } else {
        //>DEBUG
        EH.logDebug("keyPress not handled natively");
        //<DEBUG
    }
    
    var target = lastEvent.keyTarget;
    if (target == null) target = this.getEventTargetCanvas(nativeEvent,
                                                           lastEvent.nativeKeyTarget);
    // Pass to the appropriate widget, and stop if this returns false.
    if (EH.targetIsEnabled(target)) {
        var handlerReturn = EH.bubbleEvent(target, lastEvent.eventType, eventInfo) 
        if (handlerReturn == false) return false;
    }

    
	if (handlerReturn != EH.STOP_BUBBLING 
        && isc.Page.handleKeyPress() == false) return false;
        

    // If we got a tab or shift-tab keypress, and we're showing a hard mask, explicitly stick
    // focus into the next widget in the page's tab order that isn't masked.
    
    if (this.clickMaskUp() && lastEvent.keyName == this._$Tab) {
        var topHardMask,
            registry = this.clickMaskRegistry;
        for (var i = registry.length-1; i >=0; i--) {
            if (this.isHardMask(registry[i])) {
                topHardMask = registry[i];
                break;
            }
        }
        if (topHardMask != null) {
            var focusCanvas = EH._focusCanvas;
            
            if (focusCanvas != null) {
                //>DEBUG
                this.logInfo("Telling focus canvas:" + focusCanvas + " to shift focus", 
                            "syntheticTabIndex")
                //<DEBUG
                focusCanvas._focusInNextTabElement(!this.shiftKeyDown(), topHardMask);
            } else {
                if (this.shiftKeyDown()) {
                    //>DEBUG
                    this.logInfo("Putting focus into last widget in response to Tab keydown",
                                "syntheticTabIndex")
                    //<DEBUG
                
                    this._focusInLastWidget(topHardMask);
                } else {
                    //>DEBUG
                    this.logInfo("Putting focus into first widget in response to Tab keydown",
                                "syntheticTabIndex")
                    //<DEBUG
                    this._focusInFirstWidget(topHardMask);
                }
            }
            // Always return false natively in this case - we don't want the focus to shift again
            return false;
        }
    }
    

    
    if (isc.Browser.isIE && lastEvent.keyName == isc.EH._$f10 && isc.EH.shiftKeyDown()) {
        var returnVal = this.handleContextMenu(nativeEvent);
        if (returnVal) {
            this._contextMenuShown = true;
        }
        return returnVal;
    }
    
    // In Moz hitting "Escape" during server turnaround (either XMLHttpRequest, or iframe)
    // kills the communication.
    // Avoid this by suppressing native Escape behavior during active comm.
    
    // Note: Opera has the same bug if using hidden frames (though not XMLHttpRequest)
    // but returning false from the Escape keypress doesn't resolve the issue in that browser.
    if (isc.Browser.isMoz &&
        isc.RPCManager && isc.RPCManager._activeTransactions.length > 0
        && lastEvent.keyName == isc.EH._$Escape) 
    {
        return false;
    }
    
	// return true to allow normal event processing unless anything explicitly returned false
	return true;
},
// Helper methods to put focus at the beginning or end of our managed tab-index.
_focusInFirstWidget : function (mask) {
    var widget = this._firstTabWidget;
    if (widget) {
        if ((!mask || !this.targetIsMasked(widget, mask)) && !widget.isDisabled() && 
              widget._canFocus()) 
        {
            // Call 'focusAtEnd()' rather than focus()
            // if the widget manages the tab index of sub elements (EG DynamicForm), we want
            // to notify it to put focus in the first sub element.
            widget.focusAtEnd(true);
        } else {
            widget._focusInNextTabElement(true, mask);
        }
    }
},
_focusInLastWidget : function (mask) {
    var widget = this._lastTabWidget;
    if (widget) {
        if ((!mask || !this.targetIsMasked(widget, mask)) && !widget.isDisabled() && 
             widget._canFocus()) 
        {
            widget.focusAtEnd();
        } else {
            widget._focusInNextTabElement(false, mask);
        }            
    }
},


 
//>	@classMethod	isc.EventHandler.handleMouseDown()
//			Special handler for mouseDown events.
//          Starts a timer to fire mouseStillDown if the target implements it.
//			sets the following variables for use in subsequent events
//				...
//
//		@group	mouseEvents
//		@param	DOMevent	(DOM event) DOM event object (as passed by isc.EventHandler)
//
//		@return				(boolean)	false == cancel native event processing
//										anything else == continue native event processing
//  @visibility internal
//<
handleMouseDown : function (DOMevent, syntheticEvent) {
	
        var EH = isc.EH;

    EH._handlingMouseDown = true;
    var returnValue = EH.doHandleMouseDown(DOMevent, syntheticEvent);
    EH._handlingMouseDown = false;
    
    return returnValue;
},



_$IMG:"IMG",
_$alphaImgFilter:"progid:DXImageTransform.Microsoft.AlphaImageLoader",
doHandleMouseDown : function (DOMevent, syntheticEvent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page finishes loading.
	//	Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;

	var EH = this;

	// note that the mouse is down.  We do this BEFORE getting event properties to work around a bug
	// in Nav where the event.which (property to get the mouse button) is reported as 1 on a
	// mouseMove, even when the mouse is actually not pressed.
	EH._mouseIsDown = true;

	// get the properties of the event
    
	var	event = syntheticEvent || EH.getMouseEventProperties(DOMevent);

    // if we switched event target, get rid of the focus
    
    var focusCanvas = EH._focusCanvas,
        forceBlur = focusCanvas != null &&
                    (focusCanvas != event.target) && !focusCanvas._useNativeTabIndex && 
                    !focusCanvas._useFocusProxy && 
                    !(isc.isA.DynamicForm!=null && isc.isA.DynamicForm(focusCanvas) && focusCanvas.getFocusItem() 
                      && focusCanvas.getFocusItem().hasFocus);
    if (forceBlur) {
        // In IE if we blur() here, the thing we clicked on never gets native focus (not clear 
        // why), so do this on a timeout, if appropriate
        if (isc.Browser.isIE) {
            var ID = EH._focusCanvas.getID();
            
            if (EH._delayedBlurArray == null) 
                EH._delayedBlurArray = ["if (", ID, " && ", ID, ".hasFocus)", ID, ".blur()"]
            else 
                EH._delayedBlurArray[1] = EH._delayedBlurArray[3] = EH._delayedBlurArray[5] = ID;
            isc.Timer.setTimeout(
                EH._delayedBlurArray.join(isc.emptyString),
                0
            );
            
        } else {
            EH._focusCanvas.blur();
        }
    }        

    
	// remember a copy of the event particulars as mouseDownEvent
	EH.mouseDownEvent = isc.addProperties({}, event);
	
	// get the target Canvas
	var target = event.target;

    // handle mouseDown on the virtual click mask, if it's showing.  
    // If this is an hard clickMask, the click action will be cancelled by the
    // mask - since we actually do this on mouseDown, we need to set a flag to also
    // cancel mouseUp when it happens.
    
    
    var targetIsMasked = (EH.clickMaskClick(target) == false);
	if (targetIsMasked) {
        EH.__cancelNextMouseUp = true;
        return false;
    } else {
        // explicitly set the flag to NOT cancel the next mouseUp - this is required to note that 
        // we've fired the clickMaskClick()
        // See comments in handleMouseUp() for more details
        EH.__cancelNextMouseUp = false;
    }

    // NOTE: although we do send a rightMouseDown, we don't send a rightMouseMove or rightMouseUp at
    // the moment.  rightMouseDown is needed to implement a cell or record selection model that
    // matches Windows Explorer and Excel respectively - rightMouseMove and rightMouseUp are more
    // exotic.
    var eventType = EH.rightButtonDown() ? EH.RIGHT_MOUSE_DOWN : EH.MOUSE_DOWN;
	// call the global mouseDown handler
	if (isc.Page.handleEvent(target, eventType) == false) {
        return false;
    }

	// see if we shouldn't pass this event on to DOM object, and return true if we should
	if (EH.eventHandledNatively(eventType, event.nativeTarget)) 
        return EH._handledNativelyReturnVal;

	// if the target is not enabled, we shouldn't continue
    if (!EH.targetIsEnabled(target)) return false;
    
    if (target && !target.hasFocus) {
        // call 'focus' to focus on the widget.
    
        
        if ( ((isc.Browser.isMoz && target.canSelectText) || isc.Browser.isSafari )
             && target._useFocusProxy ) 
        {
            EH.focusInCanvas(target);
            
        
        } else if (!target._useNativeTabIndex) {
            target.focus();
        
        } else if (isc.Browser.isMoz) {
            target.focus();
        
        
        } else if (isc.Browser.isIE) {
            var nativeElement = event.nativeTarget;
            if (nativeElement && nativeElement.tagName == this._$IMG) {
                var style = nativeElement.style,
                    filter = style ? style.filter : null;
                if (filter.contains(this._$alphaImgFilter)) {
                    target.focus();
                }
            }
        }
    } 
    
    // NOTE that we allow right drag, and treat it just like left drag, although you can do
    // something special on right drag by checking EH.rightButtonDown()
    if (target) EH.prepareForDragging(target);
    // bubble the mouseDown event to anyone who wants it
    var handlerReturn = EH.bubbleEvent(target, eventType, null, targetIsMasked);
	if (handlerReturn == false) {
        // a an explicit "false" returned from mouseDown will cancel dragging
        delete EH.dragTarget;
        delete EH.dragTargetLink;
    }

	// if the right button is down, the return value can affect the context menu.
    // In DOM browsers, we receive a native showContextMenu event (see
    // this.handleContextMenu()), and our response to that affects whether the context
    // menu will be shown.
	if (EH.rightButtonDown()) {
        // Bail unless we're in a browser where we never get a separate right-mouse event
        if (!this.useSyntheticRightButtonEvents()) return true;  

        
        if (target && 
            (EH.getBubbledProperty(target, "contextMenu") || 
             EH.getBubbledProperty(target, "showContextMenu") != isc.Canvas.getInstanceProperty("showContextMenu"))) 
        {
        
			// return false to suppress native context menu, since we'll show our own on mouseUp
            //this.logWarn("rightMouseDown: false");
            event.returnValue = false;
			return false;
		}
        // return true to allow the context menu in Nav4.  Note that when we return true here, we
        // never get mouseUp in Nav4.
        //Log.logWarn("rightMouseDown: true");
        return true;
	}

    // if the mouseDown handler didn't return false, set up a timer to send mouseStillDown events
	if (handlerReturn != false) {	
		// if the target or a parent has a mouseStillDown message fire the mouseStillDown event,
		// this will keep firing on a timer until the mouse goes up
		if (EH.hasEventHandler(target, EH.MOUSE_STILL_DOWN)) {
			// call _handleMouseStillDown, which will start the timer automatically
			EH._handleMouseStillDown();
		}
	}

    
    
    var aboutToDrag = EH.dragTarget != null;
    // Return false to cancel native drag mode if we're about to do an ISC drag.
    // Return false in Moz if text selection is diallowed    
    // (type-casting target._allowNativeTextSelection() to a boolean - if this 
    // returns undef we want to  return an explicit false so drag selection is disallowed)
    var returnVal =  (!aboutToDrag && 
                        (!(isc.Browser.isMoz || isc.Browser.isSafari) || 
                         !!target._allowNativeTextSelection(event)));
    return returnVal;
},

//>	@classMethod	isc.EventHandler.stillWithinMouseDownTarget()
//	Is the current event still within the last Canvas where the mouse went down?
//  Note: You need to call this method to get correct cross-platform determination of whether
//        the current event is still within the mouseDown target.
//		@group	mouseEvents
// @visibility internal
//<

stillWithinMouseDownTarget : function () {
    var mouseDownTarget = this.mouseDownTarget();
    if (!mouseDownTarget) return false; // mouse didn't go down in a Canvas

    var lastEvent = this.lastEvent;

    // see if we're within the same Canvas that the mouse went down in
    var stillWithin = (mouseDownTarget == lastEvent.target);
    if (!stillWithin) return false;

    if (lastEvent._stillWithin != null) return lastEvent._stillWithin;

    
    if (!(isc.Browser.isMoz && mouseDownTarget._useMozScrollbarsNone)) 
    {
        return stillWithin;
    }

    var x = lastEvent.x,
        y = lastEvent.y,
        targetAtPoint = mouseDownTarget.visibleAtPoint(x, y, true);

    // check for the case where the mouseDownTarget should be regarded as visible at the point
    // because it is occluded by something that proxies events to it
    if (!targetAtPoint && mouseDownTarget._proxiers != null) {
        for (var i = 0; i < mouseDownTarget._proxiers.length; i++) {
            targetAtPoint = mouseDownTarget._proxiers[i].visibleAtPoint(lastEvent.x, lastEvent.y, true);
            if (targetAtPoint) break;
        }
    }
    lastEvent._stillWithin = targetAtPoint;
    return targetAtPoint;
},

//>	@classMethod	isc.EventHandler.handleMouseMove()
// Starts dragging if the dragTarget is set and the mouse has moved more than [5] pixels
//	
// Sets the dropTarget if we're dragging and are over a droppable target
//
// Generates mouseOver/mouseOut or dragOver/dragOut events on Canvas boundaries.
//
//		@group	mouseEvents
//
//		@param	DOMevent	(DOM event) DOM event object (as passed by isc.EventHandler)
//
//		@return				(boolean)	false == cancel native event processing
//										anything else == continue native event processing
// @visibility internal
//<
// called directly by DOM
handleMouseMove : function (DOMevent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;
    
        var EH = isc.EH;

    
    if (EH._handlingMouseDown || EH._handlingMouseUp) return;

	var event = EH.getMouseEventProperties(DOMevent);

    
    if ((isc.Browser.isMoz || isc.Browser.isIE)
        
    ) {
        //Log.logWarn("postponing mouseMove (last time: " + EH.lastMouseMoveTime + 
        //            " exceeds threshold of " + EH.delayThreshold);
        // set a timer to fire mouseMove later
        if (EH.delayedMouseMoveTimer == null) {
            EH.delayedMouseMoveTimer = 
                 isc.Timer.setTimeout({target:EH, methodName:"_delayedMouseMove",
                                       args:[isc.timeStamp()]}, 0);
        }
        EH._lastMouseMoveTime = 0;
        
        return true;
    }

    var start = isc.timeStamp();
    var result = EH._handleMouseMove(DOMevent, event);
    EH._lastMouseMoveTime = isc.timeStamp() - start;
    //if (EH.lastMouseMoveTime > 100) Log.logWarn("Last mouseMove time: " + EH._lastMouseMoveTime);
    return result;
},

_delayedMouseMove : function (ts) {
    //var now = isc.timestamp();
    //if ((now - ts) > 30) {
    //    this.logWarn("long timer firing delay: " + (now-ts) + "ms");
    //}

    this.delayedMouseMoveTimer = null;

    //var start = isc.timeStamp();
    this._handleMouseMove(null, this.lastEvent);
    //var end = isc.timeStamp();

    //if ((end - start) > 5) {
    //    this.logWarn("long mouse move: " + (now-ts) + "ms");
    //}
},


_handleMouseMove : function (DOMevent, event) {
    this._handlingMouseMove = true;
    var returnVal = this.__handleMouseMove(DOMevent, event);
    this._handlingMouseMove = null;
    return returnVal;
},

__handleMouseMove : function (DOMevent, event) {
    var EH = this;

        
    var missedMouseUp;
    if (isc.Browser.isIE) {
        var mouseIsDown = EH._mouseIsDown, buttonNum = event.buttonNum;
        if (mouseIsDown) {
            
            if (buttonNum == 0) {
                EH._mouseIsDown = false;
                missedMouseUp = true;
            }
        
        } else if (buttonNum == 1 && event.eventType == EH.MOUSE_MOVE) {
            event.eventType = EH.MOUSE_DOWN;
            EH.handleMouseDown(null, event);
            event.eventType = EH.MOUSE_MOVE;
        }
    }

    

 	var target = event.target,
 		isNative = EH.eventHandledNatively(EH.MOUSE_MOVE, event.nativeTarget)
 	;
    
	if (EH._mouseIsDownInScrollbar) {
        
        EH.handleMouseUp(DOMevent, true);
    
    } else if (EH._outOfWindow && missedMouseUp) {
        EH.logInfo("sythesizing mouseUp due to mouseUp outside window, buttonNum: " + 
                   event.buttonNum);
        EH.handleMouseUp(DOMevent, true);
    }
    delete EH._outOfWindow;

    

    // NOTE: we allow right mouse button dragging, and at the EventHandler level we treat it
    // just like normal dragging, however, a specific drag handler can implement special
    // semantics for right dragging.

    
    var mouseDown = EH.mouseIsDown();
    if (isc.Browser.isMoz && mouseDown && event.target && event.target._useMozScrollbarsNone 
        && event.target != EH.mouseDownTarget()) 
    {
        event.nativeTarget = null;
        target = event.target = EH.mouseDownTarget();
    }
    // start dragging if:
    // - the mouse is down
    // - the mouse went down on a Canvas that allows dragging (EH.dragTarget, set up in 
    //   prepareForDragging)
    // - we're not already dragging
    // - the mouse has moved a certain distance, in either direction, from the mouseDown point
	if (mouseDown && EH.dragTarget && ! EH.dragging 
		&& (Math.abs( event.x - EH.mouseDownEvent.x) > EH.dragTarget.dragStartDistance 
		 || Math.abs( event.y - EH.mouseDownEvent.y) > EH.dragTarget.dragStartDistance)) 
    {
        EH.handleDragStart(event);
	}
	
	// if we're dragging, jump over to handleDragMove which does special processing
	if (EH.dragging) return EH.handleDragMove();

	// if the right button is down
	if (EH.rightButtonDown()) {
		// don't send mouseMove.  We could send a 'rightMouseMove' event, but we've decided not
        // to do that now.
        
        
        if (!isc.Browser.isMac || !EH.ctrlKeyDown()) return true;
	}
  
    
	if (mouseDown) {
        target = EH.stillWithinMouseDownTarget() ? EH.mouseDownTarget() : null;
	} else {
		target = event.target;
	}

	// if the target is not the last object that got the move event,
	// send the mouseOut and mouseOver routines to the appropriate objects
	if (target != EH.lastMoveTarget) {
        //>DEBUG
        if (this.logIsDebugEnabled()) {
            this.logDebug((EH.lastMoveTarget ? 
                           "mousing out of " + EH.lastMoveTarget + "  " : "") +
                           (target ? "mousing over " + target : ""));
        }
        //<DEBUG
		// send the mouseOut event to the last mover object
        var lastMoveTarget = EH.lastMoveTarget,
            hoverTarget,
            lastHoverTarget = EH.lastHoverTarget;
            
		if (lastMoveTarget) {
            EH.handleEvent(lastMoveTarget, EH.MOUSE_OUT);
        }
                
        // send the mouseOver event to the target
        if (target) {
            EH.handleEvent(target, EH.MOUSE_OVER);
            // use 'getHoverTarget()' to determine which widget should recieve a hover event.
            hoverTarget = target.getHoverTarget(event);
        }
        
        // Send hover events to the hover target/last hover target.
        // The Canvas level implementation handles actually setting up timers to fire 
        // user-visible hover handlers.    
        if (hoverTarget != lastHoverTarget) {
            if (lastHoverTarget) lastHoverTarget.stopHover();
            if (hoverTarget) hoverTarget.startHover();
            
            EH.lastHoverTarget = hoverTarget;
        }
		
		// remember that we're the last move object
		EH.lastMoveTarget = target;
	}

	// call the global event handler
	if (isc.Page.handleEvent(target, EH.MOUSE_MOVE) == false) return false;

	// see if we shouldn't pass this event on to DOM object, and return true if we should
	if (isNative) return EH._handledNativelyReturnVal;

	// if the target isn't defined or isn't enabled, return false
	if (!EH.targetIsEnabled(target)) return false;

	// bubble the event
	EH.bubbleEvent(target, EH.MOUSE_MOVE);

    // update the cursor
	if (target) target._updateCursor();
    	
    
    return true;
    
},


// handle a native mouseOut event
handleNativeMouseOut : function (DOMevent) {
    // we generally synthesize the mouseOut event during mouseMove.  However, for the special
    // case of mousing out of the browser window via exiting a Canvas which is which is flush
    // with the window border, we'll never get a mouseMove outside of our Canvas, so we have to
    // detect this case specially.

    
    if (isc.Browser == null) return;

	
        var EH = isc.EH;

    
    if (EH._handlingMouseDown || EH._handlingMouseUp) return;

    var event = (DOMevent ? DOMevent : EH.getWindow().event),
		target = (isc.Browser.isDOM ? event.target : event.srcElement),
        leavingWindow = false;

    if (isc.Browser.isIE) {
        
        leavingWindow = (event.toElement == null);
        
    } else {
        
        leavingWindow = (event.relatedTarget == null);
        
    }

    //EH.logWarn("leaving window:" + leavingWindow + ", lastMoveTarget: " + EH.lastMoveTarget);

    // used for detecting mouseUps that happen outside the window, where possible
    if (leavingWindow) EH._outOfWindow = true;   

    if (leavingWindow && EH.lastMoveTarget != null) {
        // Update properties on the lastEvent object before bubbling handlers.
        
        EH._updateMouseOutEventProperties(event);
        EH.handleEvent(EH.lastMoveTarget, EH.MOUSE_OUT);
        EH.lastMoveTarget = null;
        if (EH.lastHoverTarget) {
            EH.lastHoverTarget.stopHover();
            delete EH.lastHoverTarget;
        }
    }
},


// update lastEvent with properties from a native 'mouseOut' event.
_updateMouseOutEventProperties : function (nativeEvent) {
	
        var EH = isc.EH;

    var lastEvent = EH.lastEvent;

    // Store the target we're moving into as the event target (rather than the target we're
    // moving out of!)
    if (isc.Browser.isIE) {
        lastEvent.nativeTarget = nativeEvent.toElement;    
    } else {
        lastEvent.nativeTarget = nativeEvent.relatedTarget;
    }

    if (lastEvent.nativeTarget == null) lastEvent.target = null
    else lastEvent.target = this.getEventTargetCanvas(nativeEvent, lastEvent.nativeTarget);    
},



// Send the mouseDown target a periodic, synthetic "still down" event while the mouse stays
// down
//
// Allows for things like repeated scrolling while the mouse button is held down in
// scrollbar buttons.
//
// NOTE: mouseStillDown is also fired once immediately on mouseDown
_handleMouseStillDown : function (timeStamp) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;

	var EH = this;
	
	// clear the old timeout if necessary
    EH._stillDownTimer = isc.Timer.clear(EH._stillDownTimer);
	
	// if the mouse is already up, or the mouseDownTarget can no longer be found, bail
    
	if (!EH.mouseIsDown() || !EH.mouseDownTarget()) return false;
	
	// send the event up the chain of the target
	if (EH.bubbleEvent(EH.mouseDownTarget(), EH.MOUSE_STILL_DOWN) == false) return false;
    
	// start the timer to call this again after a delay.  
    
    var target = EH.mouseDownTarget(),
        delay = this._handlingMouseDown ? target.mouseStillDownInitialDelay :
                                          target.mouseStillDownDelay;
  	EH._stillDownTimer = this.delayCall("_handleMouseStillDown", [], delay);

    // alternate code that allows checking the actual delay before the timer fired
    //if (!this._handlingMouseDown) {
    //    this.logWarn("mouseStillDown fired after: " + (isc.timeStamp() - timeStamp) + "ms");
    //}
  	//EH._stillDownTimer = 
    //    isc.Timer.setTimeout("isc.EH._handleMouseStillDown(" + isc.timeStamp() + ")", delay);

	return true;
},



//>	@classMethod	isc.EventHandler.handleMouseUp()
//			Special handler for mouse up events.
//
//			fires  showContextMenu, click and doubleClick events as necessary
//
//		@group	mouseEvents
//		@param	DOMevent	(DOM event) DOM event object (as passed by isc.EventHandler)
//
//		@return				(boolean)	false == cancel native event processing
//										anything else == continue native event processing
//  @visibility internal
//<
// called directly from DOM, and by other methods
handleMouseUp : function (DOMevent, fakeEvent) {
    
    
	
        var EH = isc.EH;
    
    
    if (isc.Browser.isIE && !EH._mouseIsDown) {
        var lastEvent = EH.lastEvent;
        lastEvent.eventType = EH.MOUSE_DOWN;
        EH.handleMouseDown(null, EH.lastEvent);
    }
    
    if (!fakeEvent) EH._handlingMouseUp = true;
    var returnValue = EH._handleMouseUp(DOMevent, fakeEvent);
    EH._handlingMouseUp = false;

    
    if (isc.Browser.isSafari) returnValue = true;
    
    
    
    
    return returnValue;
},
_handleMouseUp : function (DOMevent, fakeEvent) {

    // Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;
	var EH = this,
		// get the properties of the event
		event = (!fakeEvent ? EH.getMouseEventProperties(DOMevent) : EH.lastEvent),
		isNative = false;
    
	EH._mouseIsDown = false;
	delete EH.__handleClickReturnValue;
	
	// clear the stillDownTimer
	EH._stillDownTimer = isc.Timer.clear(EH._stillDownTimer);

    // switch focus if the one-time flag has been set
    var focusTarget = EH._delayedFocusTarget;

    if (focusTarget) {
        //EH.logWarn("focusing in delayed target:" + focusTarget);
        focusTarget.focus();
        EH._delayedFocusTarget = null;
    }

    // EH.__cancelNextMouseUp is a one-time flag to cancel mouseUp.  
    // This is used when, on mouseDown, you want to cancel the entire click.
    // We set this flag to true on mouseDown if the target is masked and the clickEvent for the
    // click mask returned false.

    // Remember this flag's value, and clear it
    var cancelMouseUp = EH.__cancelNextMouseUp;
    EH.__cancelNextMouseUp = null;

    
    var targetIsMasked;
    if (cancelMouseUp == null) {
        cancelMouseUp = (EH.clickMaskClick(event.target) == false);
        targetIsMasked = cancelMouseUp;
    }

    // Return if cancelling the mouseUp
    if (cancelMouseUp == true) {
        if (EH.logIsDebugEnabled()) EH.logDebug("mouseUp cancelled by clickMask");
        return false;
    }
    
    var successfulDrag = false;
    // if we're dragging, stop dragging.  NOTE: this applies to right button down as well,
    // which is treated as normal dragging.
    if (EH.dragging) {
        successfulDrag = EH.handleDragStop();
    }

	// right mouse button just came up, it's a right click (handleContextMenu())
	if (EH.rightButtonDown(event)) {
        
		if (this.useSyntheticRightButtonEvents()) {
			EH.handleContextMenu();
		}

		// suppress the click event
		EH.__handleClickReturnValue = false;
	
	} else {
        // only send mouseUp and click if drag was unsuccessful (or never started)
        // NOTE: it's very important to send mouseUp and click if drag wasn't successful, 
        // because among other problems, frequently a D&D interaction will be triggered by a 
        // sloppy click where there is a small distance between mouseDown and mouseUp, and 
        // then the click will appear to have mysteriously failed.

         
        
        if (!successfulDrag) {            
            if (isc.Page.handleEvent(event.target, EH.MOUSE_UP) != false) {                

                var mouseUpReturn = true, 
                    x = this.lastEvent.x, y = this.lastEvent.y,
                    mouseDownTarget = EH.mouseDownTarget();

                isNative = EH.eventHandledNatively(EH.MOUSE_UP, event.nativeTarget);
                if (!isNative && EH.targetIsEnabled(mouseDownTarget)) {
                    if (mouseDownTarget.visibleAtPoint(x, y))
                        mouseUpReturn = EH.bubbleEvent(mouseDownTarget, EH.MOUSE_UP, null, 
                                targetIsMasked);
                    else if (mouseDownTarget.containsPoint(x, y))
                        mouseUpReturn = EH.bubbleEvent(mouseDownTarget, EH.MOUSE_OUT, null, 
                                targetIsMasked);
                }
                // NOTE: call handleClick even if the Canvas target is null or changed between 
                // mouseDown and mouseUp, because we should still fire page-level click in that
                // circumstance.  handleClick will check (redundantly) for same target before
                // firing Canvas-level click.
                if (mouseUpReturn != false) {
                    EH.__handleClickReturnValue = EH.handleClick(event.target);
                }
            }
        }
    }

	// and always clear the redrawnWhileDown property
	delete EH.redrawnWhileDown;
	
	// clear all drag properties set by unscrupulous methods above
	EH.clearDragProperties();
	
    

	// EH._mouseIsDownInScrollbar must be cleared before we return, but *after* mouseUp and
    // click events been handled (and their bubbling averted by EH.eventHandledNatively()
    // immediately returning true) above
	if (EH._mouseIsDownInScrollbar) EH._mouseIsDownInScrollbar = false;

    //isc.Log.logWarn("handleMouseUp returning: " + 
    //                (isNative && EH.__handleClickReturnValue == true) +
    //                ", isNative: " + isNative + 
    //                ", handleClick: " + EH.__handleClickReturnValue);

    // If mouseUp or click returned false, __handleClickReturnValue will be false 
	// return true if the event was handled natively, or if neither of these handlers 
    // returned false.
    
    var target = event.target,
        overForm = isc.isA.DynamicForm!=null && isc.isA.DynamicForm(target);

    if (isNative && (overForm || EH.__handleClickReturnValue == true)) 
        return EH._handledNativelyReturnVal;
    // Return false unless this was over a form with an explicit true return val
    return (overForm && EH.__handleClickReturnValue == true);
},


//>	@classMethod	isc.EventHandler.clearDragProperties()
//			Clear all the miscellaneous isc.EventHandler properties set as a result of dragging.
//		@group	mouseEvents
// @visibility internal
//<
clearDragProperties : function () {
	var EH = this;
	EH.dragging = false;

	delete EH.dragTarget;
	delete EH.dragTargetStartRect;
	delete EH.dragTargetLink;

	delete EH.dragMoveTarget;
	delete EH.dragMoveAction;

	delete EH.dragOperation;
	delete EH.dragAppearance;

	delete EH.dropTarget;
	delete EH.lastDropTarget;
},


//>	@classMethod	isc.EventHandler.handleContextMenu()
//			Special handler for context menu events.
//
//		@group	mouseEvents
//		@param	event		(DOM event) DOM event object (as passed by isc.EventHandler)
//		@return				(boolean)	false == cancel native event processing
//										anything else == continue native event processing
// @visibility internal
//<
handleContextMenu : function (DOMEvent) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;

    
    
        var EH = isc.EH;
    
    EH._handlingMouseUp = true; 

    var returnValue = EH._handleContextMenu(DOMEvent);
    EH._handlingMouseUp = false;
    return returnValue;
},

_handleContextMenu : function (DOMEvent) {

    
    var fromMouseEvent = isc.Browser.isSafari || (this.lastEvent.eventType == isc.EH.MOUSE_UP);
    
    
    if (this._contextMenuShown) {
        delete this._contextMenuShown;
        return true;
    }
    
    // If this is not a synthetic event, pick up the event properties
	if (DOMEvent) this.getMouseEventProperties(DOMEvent);
    var EH = this,
		event = EH.lastEvent,
        target = event.target;
        
    // If this came from a keyboard event, in IE the coordinates reported will be the
    // mouse coordinates. In order to show the context menu in the right place, specify the
    // event coordinates as matching basically the top/left of the focus canvas
    if (!fromMouseEvent && !isc.Browser.isMoz) {
        event.x = target ? target.getPageLeft() : 0;
        event.y = target ? target.getPageTop() : 0;
    }

    
	if (isc.Browser.isSafari && EH.clickMaskClick(target) == false) {
        return false;
    }
        
	// handle the page-level showContextMenu event
	if (isc.Page.handleEvent(target, EH.SHOW_CONTEXT_MENU) == false) {
        return false;
    }

	// if the target is enabled, send it a showContextMenu event.
    var returnValue = true;
	if (EH.targetIsEnabled(target)) {    
        returnValue = EH.bubbleEvent(target, EH.SHOW_CONTEXT_MENU);
    }

    if (returnValue != false) {
        
        if (EH.lastMoveTarget) EH.handleEvent(EH.lastMoveTarget, EH.MOUSE_OUT);
        delete EH.lastMoveTarget;
    }
    return returnValue;
},


handleNativeClick : function () {
	
    var EH = isc.EH,
		value = (EH.__handleClickReturnValue != false);

	delete EH.__handleClickReturnValue;
    
//	return value;
},

// NOTE: handleClick() is always called by handleMouseUp() during processing of a native
// mouseUp event, because we always synthesize the click event ourselves.  handleNativeClick()
// is what we do when we get a native click event.
handleClick : function (target, eventType) {
	// Some browsers (like Mac IE) have problems dealing with events fired before the page
    // finishes loading.  Just skip mouse event processing if the page hasn't loaded yet.
	if (!isc.Page.isLoaded()) return false;

	var EH = this,
		// get the properties of the event as 'lastEvent'
		event = EH.lastEvent,
        returnVal;

	// get the eventType if it wasn't passed in
    
	if (!eventType) eventType = (EH.isDoubleClick(target) ? EH.DOUBLE_CLICK : EH.CLICK);

    //EH.logWarn("target: " + target + ", mouseDownTarget: " + EH.mouseDownTarget() +
    //             ", stillWithinTarget: " + EH.stillWithinMouseDownTarget() + 
    //             ", native target: " + this.echoLeaf(event.nativeTarget));

	// call the Page-level click handler.  Note we will fire page-level click even if there is
    // no Canvas target
	if (isc.Page.handleEvent(target, eventType) == false) {
        returnVal = false;

	// if the click event was handled natively, bail
	} else if (EH.eventHandledNatively(eventType, event.nativeTarget)) {
		returnVal = EH._handledNativelyReturnVal;

	// if we have an enabled target, bubble the event
	} else if (!EH.targetIsEnabled(target)) {
        returnVal = false;

    // don't fire click if the Canvas target changed between mouseDown and mouseUp
    } else if (!EH.stillWithinMouseDownTarget()) {
        returnVal = false;
        
    // otherwise bubble the event through the target canvas chain
    } else {
    
        var target = EH.mouseDownTarget();
    	returnVal = EH.bubbleEvent(target, eventType);
        
    }
    
    // Record when the event completed. We use this for double-click detection in some cases.
    EH._lastClickCompleteTime = isc.timeStamp();
	
	return returnVal;
},


//>	@classMethod	isc.EventHandler.isDoubleClick()	(A)
// Return true if this click in the target should be considered a double click, 
// false for a single click
//
//		@group	mouseEvents
//		@param	target		(object)	Canvas or DOM object that received the event
//
//		@return				(boolean)	true == real double click
//										false == really a single click
// @visibility internal
//<
isDoubleClick : function (target) {
	var EH = this,
        target = target || EH.lastEvent.nativeTarget;
    
    // If this click event occurred within the double-click delay of the last event, fire the
    // double-click handler rather than the click handler.
    
    var useNativeEventTime = (isc.Browser.isMoz && isc.Browser.isWin),
        time, withinDoubleClickInterval;
        
    if (useNativeEventTime) {
        var domevent = EH.lastEvent.DOMevent
            time = domevent ? domevent.timeStamp : null;
        // Sanity check
        if (time == 0 || !isc.isA.Number(time)) {
            this.logDebug("Unable to derive native 'timeStamp' attribute from DOM event");
            time = isc.timeStamp();
        }
        withinDoubleClickInterval = ((time - EH.lastClickTime) < EH.DOUBLE_CLICK_DELAY);        
        
    } else {
        time = isc.timeStamp();
        withinDoubleClickInterval = 
            // if it took us less than the double click delay to process the first click
            ((EH._lastClickCompleteTime - EH.lastClickTime) < EH.DOUBLE_CLICK_DELAY) ?
                // then check for a second click strictly within the normal interval
                ((time - EH.lastClickTime) < EH.DOUBLE_CLICK_DELAY) :
                // otherwise treat any click that closely follows completion of the first click
                // as a double click
                ((time - EH._lastClickCompleteTime) < 100);        
    }
    

        
	// remember the click time for later
	EH.lastClickTime = time;

	// clear the lastClickTarget if it's already too late
	if (!withinDoubleClickInterval) {
		delete EH.lastClickTarget;
	}
	
    // If the two clicks occurred on the same target this is a doubleClick,
    // unless the special "noDoubleClicks" flag is set on the target, (in which case
    // we fire multiple single clicks).
     
    var isDouble = false; 
    if (target == EH.lastClickTarget) {
        isDouble = !target.noDoubleClicks;
        if (isDouble) {
            var current = target;
            while (current.parentElement) {
                current = current.parentElement;
                if (current.noDoubleClicks) {
                    isDouble = false; 
                    break;
                }
            }
        }
    }

	// if this is a doubleClick, remove the lastClickTarget so we'll go back to clicking next
    // time
	// otherwise note that we were the last thing clicked in case a double-click comes in later
	EH.lastClickTarget = (isDouble ? null : target);
	
	return isDouble;
},


// If the target passed in has a concept of enabled/disabled, determine if it is enabled.
targetIsEnabled : function (target) {

	// if no target specified, return false
	if (!target) return false;
    
    // If the target has been marked as destroyed, don't attempt to fire the handler on it
    if (target.destroyed) return false;

	// if the target has a isDisabled function, return the results of that
	//	for canvases, this is defined to go up the parent chain for us
	if (isc.isA.Function(target.isDisabled)) return !target.isDisabled();

	// otherwise, the target doesn't have the concept of being enabled, so assume it is enabled
	return true;
},

getFocusCanvas : function () {
    return this._focusCanvas;
},

// focusInCanvas and blurFocusCanvas
// Called as a result of an action that will focus in a canvas, such as calling widget.focus(),
// or clicking on the widget.


// helper to log native focus changes
_logFocus : function (target, isFocus) {
    if (!this.logIsDebugEnabled("nativeFocus")) return;

    this.logDebug((isFocus ? "onfocus" : "onblur") + 
                  " fired on: " + target + this._getActiveElementText(),
                  "nativeFocus");
},

_getActiveElementText : function () {
    if (!isc.Browser.isIE) return isc._emptyString;
    var activeElement = this.getActiveElement();
    
    if (activeElement == null) return isc._emptyString;
    return ", activeElement: " + ( 
                                  activeElement.tagName);
},


blurFocusCanvas : function (target, isNative) {
    //>DEBUG isNative indicates this call came from a blur handler on a native element (either
    // the handle or a focusProxy).
    var oldThread = this._thread;
    if (isNative) {
        this._setThread("BLR");
        this._logFocus(target);
        isc.EH._unconfirmedBlur = null;
    } //<DEBUG
    
    this._blurFocusCanvas(target, isNative);
    
    //>DEBUG
    if (isNative) this._thread = oldThread; //<DEBUG
},
_blurFocusCanvas : function (target, isNative) {
    if (this._focusCanvas) {
        var focusCanvas = this._focusCanvas;

        
        if (target != null && focusCanvas != target) return;
        this._focusCanvas = null;
        focusCanvas._focusChanged(false);
        
    }
},

focusInCanvas : function (target, isNative) {

    //>DEBUG isNative indicates this call came from a focus handler on a native element (either
    // the handle or a focusProxy).
    var oldThread = this._thread;
    if (isNative) {
        this._setThread("FCS");
        this._logFocus(target, true);
        isc.EH._unconfirmedFocus = null;
    } //<DEBUG
    
    // In Moz by default focus outline shows up on both mouseDown and focus via tab-keypress
    // we only want it to show up via keypress (like in IE).
    // use setShowFocusOutline to update the css setting to hide the focus outline if this focus
    // came from a mouseDown.
    if (isc.Browser.isMoz) {        
        if (isNative && (this.lastEvent.eventType != this.KEY_DOWN && 
                         this.lastEvent.eventType != this.KEY_PRESS && 
                         this.lastEvent.eventType != this.KEY_UP)) 
        {
            if (target && target.showFocusOutline) target.setShowFocusOutline(false,true);
        } else {
            if (target && target.showFocusOutline) target.setShowFocusOutline(true,true);
        }
    }
    this._focusInCanvas(target, isNative);

    //>DEBUG
    if (isNative) this._thread = oldThread; //<DEBUG
},
_focusInCanvas : function (target, isNative) {
    // if no target, or target doesn't want focus, or target has focus already just bail
    if (!target || target.hasFocus || !target._canFocus() || target.isDisabled() ) return;
    
    // Handle the case of focus going to a masked widget
    this.checkMaskedFocus(target);
   
    
    if (isNative && isc.Browser.isMoz) {
        if (target.parentElement) target.parentElement._handleCSSScroll(null, true);
    }
    
    // blur the previous focus item, and focus in this one
    if (this._focusCanvas) this._focusCanvas._focusChanged(false)
    this._focusCanvas = target;
    target._focusChanged(true);
    
    // If the target is masked, update the topmask's 'maskedFocusCanvas'
    
    if (this.targetIsMasked(target)) {
        var topMask = this.clickMaskRegistry.last();
        this.setMaskedFocusCanvas(target, topMask);
    }

    
},

// Helper to set (or clear) the 'masked focus canvas' for some mask.
setMaskedFocusCanvas : function (target, mask) {
    if (!mask) return;
    mask._maskedFocusCanvas = target;
},

getMaskedFocusCanvas : function (mask) {
    if (mask == null) mask = this.clickMaskRegistry.last();
    else mask = this.getClickMask(mask);
    if (mask) return mask._maskedFocusCanvas;
},

// helper method fired when focus goes onto a widget which may be covered by a clickmask.
// if the mask is soft, it automatically dismisses that clickMask and fires the click
// action.
checkMaskedFocus : function (target) {
    
    if (isc.Browser.isIE) {

        var activeElement = this.getActiveElement();
        var handle = target ? target.getHandle() : null;   
        // no handle - undrawn so bail
        if (!handle) return;
        var focusStillInCanvas;
        
        while (activeElement && activeElement.tagName) {
        
            if (activeElement == handle) {
                focusStillInCanvas = true;
                break;
            }
            // if "eventProxy" is specified look at that and bail early - it either is or isn't
            // the widget that fired the onfocus event.
            if (activeElement.eventProxy) {
                focusStillInCanvas = (activeElement.eventProxy == target.getID());
                break;
            }
            activeElement = activeElement.parentElement;
        }
        if (!focusStillInCanvas) return;
    }
    var masks = this.clickMaskRegistry;
    for (var i = masks.length-1; i >= 0; i--) {
        var mask = masks[i];
        // As soon as we hit a mask we know we're ABOVE we know we're above all remaining
        // masks so we can bail.
        if (!this.targetIsMasked(target, mask)) return;
        else {
            // we should never be able to focus on a widget under an hard 
            // clickmask - just return false if we do hit this case
            if (this.isHardMask(mask)) return false;
            this._clickMaskClick(mask);
        }
    }
},


// prepare for a drag interaction on "target" (a Canvas)
prepareForDragging : function (target) {
	var EH = this;

    
    if (EH.dragging) EH.handleDragStop();

	delete EH.dragMoveAction;
	delete EH.dragTarget;

    // send prepareForDragging event: target is expected to set various dragging-related flag,
    // especially dragTarget, if it wants to be dragged.  See default implementation in Canvas.
    EH.bubbleEvent(target, "prepareForDragging");
    // no one set a drag target
    if (!EH.dragTarget) {
        if (this.logIsDebugEnabled()) this.logDebug("No dragTarget, not dragging");
        return;
    }

    // The target can designate another Canvas as the object that should be dragged (via the
    // dragTarget property).  This is to support situations where some external widget (such as
    // resize nubs) drives drag and drop behavior for another Canvas.
	if (target.dragTarget) {
		// if it's a canvas, use it
		if (isc.isA.Canvas(target.dragTarget)) {
			EH.dragTarget = target.dragTarget;
		// if it's the constant 'top' and the target has a topElement, use that
		} else if (target.dragTarget == "top" && target.topElement) {
			EH.dragTarget = target.topElement;
		// if it's the constant 'parent' and the target has a parentElement, use that
		} else if (target.dragTarget == "parent" && target.parentElement) 	{
			EH.dragTarget = target.parentElement;
        } else if (target.dragTarget == "creator" && target.creator) {
            EH.dragTarget = target.creator;
        } else if (isc.isA.String(target.dragTarget) && 
                    isc.isA.Canvas(window[target.dragTarget])) 
        {
            EH.dragTarget = window[target.dragTarget];
		//>DEBUG
		// otherwise we don't know what to do with it...
		} else {
			this.logWarn('prepareForDragging():  target.dragTarget not understood : ' +
                         target.dragTarget);
		//<DEBUG
		}
	}

    //>DEBUG
    if (this.logIsInfoEnabled("dragDrop"))
        this.logInfo("target is draggable with dragOperation: " + EH.dragOperation + 
                     ", dragTarget is : " + EH.dragTarget + 
                     (EH.dragTarget != target ? " (delegated from: " + target + ")" : ""), 
                     "dragDrop");
    //<DEBUG

	// remember the original rect of the dragTarget in case we need it later
	EH.dragTargetStartRect = EH.dragTarget.getRect();
},

// Handle the artificially generated dragStart event, sent to a draggable object when the mouse
// goes down in the object and then moves the dragStartDistance while still down.
// 
// Fires Canvas.dragStart() on the target (which may cancel the event) and sets up the visual
// appearance of dragging.
handleDragStart : function (){
	var EH = this,
		event = EH.lastEvent;

	if (!EH.mouseIsDown() || !EH.dragTarget) return false;

    
	delete EH.dropTarget;
	delete EH.dragMoveTarget;
	// reset the dragOffsetX and dragOffsetY in case somebody set it before
    // these properties indicate the offset of the last event coordinates (typically this is
    // the position of the mouse) from the drag target
	EH.dragOffsetX = -10;
	EH.dragOffsetY = -10;
	
	// during dragging no Canvii will get mouseOver/mouseOut, so we need to send a final mouse
    // out event to avoid a Canvas getting stuck in the "over" state.  
    EH.handleEvent(EH.lastMoveTarget, EH.MOUSE_OUT);
    // likewise we need to send mouseOut to the mouseDownTarget to avoid it getting stuck in
    // the down state.  
    
    if (EH.lastMoveTarget != EH.mouseDownTarget()) {
        EH.handleEvent(EH.mouseDownTarget(), EH.MOUSE_OUT);
    }
    
    // If we're currently showing a hover, hide it.
    // We're not checking for the lastHoverCanvas matching the drag target etc since dragging could
    // be delegated from one drag target to another and there are no obvious cases where we'd
    // want the hover to be visible during dragging
    if (isc.Hover) isc.Hover.hide();

    // remember the drag offset; this is the distance between the point where the mouse went
    // down to start D&D and the top/left corner of the element being dragged.  We want to
    // maintain that offset during dragging, otherwise, dragRepositioned objects would have
    // their top-left corner snap to the mouse position when dragging began, and dragResized
    // objects would jerk by the dragOffset when dragging starts.
    // NOTE: capture offset before dragStart since dragStart might deparent.
    EH.dragStartOffsetX = EH.mouseDownEvent.x - EH.dragTarget.getPageLeft();
    EH.dragStartOffsetY = EH.mouseDownEvent.y - EH.dragTarget.getPageTop();

	// bubble the appropriate [dragStart, dragRepositionStart, or dragResizeStart] message to
    // the target.  This is an opportunity to set EH.dragAppearance
	var eventType = EH.dragOperation + "Start";
	if (EH.handleEvent(EH.dragTarget, eventType) == false) {
        //>DEBUG
        this.logInfo("drag cancelled by false return from: " + 
                      eventType + " on " + EH.dragTarget,
                      "dragDrop");
        //<DEBUG

		// if it returns false, cancel dragging
		delete EH.dragTarget;
		delete EH.dragTargetLink;

		// send the drag object a mouseOver since we sent it mouse out when dragging began
		EH.handleEvent(EH.dragTarget, EH.MOUSE_OVER);

		return false;
	}

	// clear the lastMoveTarget since we've sent a mouseOut with no mouseOver
	delete EH.lastMoveTarget;

	// if we're dragRepositioning, and the dragAppearance is not the tracker,
	// set the isc.EventHandler.dragOffsetX and .dragOffsetY to the offset from the drag target
	if (EH.dragTarget.dragAppearance != EH.TRACKER)
    {
		EH.dragOffsetX = EH.dragStartOffsetX;
		EH.dragOffsetY = EH.dragStartOffsetY;
	}
	
    // dragAppearance
    // --------------
	// We set the action to be performed on mouseMove events during dragging, based on the
    // dragTarget's dragAppearance.  For all types of dragging, we have:
    // - a "dragMoveTarget", which is a Canvas, and is chosen on the basis of dragAppearance.
    //   It can be the dragTarget itself ("target" dragAppearance) or some other object which
    //   stands in, like an outline or small "tracker".
    // - a "dragMoveAction", which is a function called every mouseMove.  The two built-in
    //   dragOperations, dragResizing and dragRepositioning, work by setting the dragMoveAction
    //   to a function that drag resizes or drag repositions the dragMoveTarget.
    //
    // Note that the dragAppearance is independant of whether you are doing dragResizing,
    // dragRepositioning, or a custom drag.  If you set a dragAppearance and do a generic drag
    // (that is, set canDrag but not canDragReposition or canDragResize), then we default the
    // dragMoveAction to moving the dragMoveTarget around; this is often used to show a
    // tracker.

	EH.dragAppearance = EH.dragTarget.dragAppearance;

	// "tracker" drag appearance
    // - a small Canvas, settable via setDragTracker, "tracks" the mouse cursor at a small offset
	//
	if (EH.dragAppearance == EH.TRACKER) {
		// using the drag tracker
		EH.dragMoveTarget = EH._makeDragTracker();
        // tracker moves to event
		if (!EH.dragMoveAction) EH.dragMoveAction = EH._moveDragMoveTarget;

		// if the target wants it, tell it to set the dragTracker image
		EH.dragTracker.setOverflow(isc.Canvas.VISIBLE);
		EH.bubbleEvent(EH.dragTarget, EH.SET_DRAG_TRACKER);

		// change the offset for the tracker -- default -10,-10 in dragTrackerDefaults, but
        // customizable in setDragTracker()
		EH.dragOffsetX = EH.dragTracker.offsetX;
		EH.dragOffsetY = EH.dragTracker.offsetY;

	// "outline" drag appearance
    //
	} else if (EH.dragAppearance == EH.OUTLINE) {
        EH.dragMoveTarget = EH.getDragOutline(EH.dragTarget);

        // on drag move, we'll move to the mouse
		if (!EH.dragMoveAction) EH.dragMoveAction = EH._moveDragMoveTarget;

	// "target" drag appearance
	//
	} else if (EH.dragAppearance == EH.TARGET) {
		EH.dragMoveTarget = EH.dragTarget;
		if (!EH.dragMoveAction) EH.dragMoveAction = EH._moveDragMoveTarget;
        
        // If the canvas wants to show a shadow on drag, show it now.
        if (EH.dragTarget.showDragShadow) this._showTargetDragShadow();
		
        // If the canvas should change opacity on drag, handle this now.
        if (EH.dragTarget.dragOpacity != null) this._setTargetDragOpacity();
	// custom move style
	//
	} else {
		// nothing special to do here -- your target should set things up manually in its
		// .dragStart() handler.  It can set EH.dragMoveTarget and/or EH.dragMoveAction if
        // desired.
	}

	// if a dragMoveTarget is set, bring it to the front and show it
	if (EH.dragMoveTarget) {
		// make sure dragMoveTarget and dragTarget agree on some basic stuff
		if (EH.dragMoveTarget != EH.dragTarget) {
			EH.dragMoveTarget.dragIntersectStyle = EH.dragTarget.dragIntersectStyle;

		}
        // show and bring to front
        EH.dragMoveTarget.show();
        EH.dragMoveTarget.bringToFront();
	}


    

    
	EH.showEventMasks((EH.dragOperation == EH.DRAG_RESIZE));

	// set the 'dragging' flag to true since we're dragging
	EH.dragging = true;

    //>DEBUG
    this.logInfo("Started dragOperation: " + EH.dragOperation + 
                  " with dragTarget: " + EH.dragTarget +
                  " dragAppearance: " + EH.dragAppearance, "dragDrop");
    //<DEBUG

	return true;
},

// Methods to show/hide drag shadows for targets.

_showTargetDragShadow : function () {
    var EH = isc.EH;
    var target = EH.dragTarget;

    EH._hideShadowAfterDrag = (!target.showShadow);
    EH._afterDragShadowDepth = target.shadowDepth;
    
    target.shadowDepth = EH.dragTargetShadowDepth;
    target.updateShadow();
    if (!target.showShadow) target.setShowShadow(true);
},

_hideTargetDragShadow : function () {
    var EH = isc.EH;
    var target = EH.dragTarget;

    if (EH._hideShadowAfterDrag) target.setShowShadow(false);
    target.shadowDepth = EH._afterDragShadowDepth;
    target.updateShadow();
    
    delete EH._hideShadowAfterDrag;
    delete EH._afterDragShadowDepth;
},

// Methods to modify the opacity of the drag target
_setTargetDragOpacity : function () {
    var EH = isc.EH;
    var target = EH.dragTarget;
    
    // Remember the old opacity 
    
    EH._dragTargetOpacity = target.opacity;
    
    target.setOpacity(target.dragOpacity);
},

_resetTargetDragOpacity : function () {
    var EH = isc.EH,
        target = EH.dragTarget;
    target.setOpacity(EH._dragTragetOpacity);
},


_showBackMask : function (target) {
    if (target._backMask) {
        if (!target._backMask.isVisible()) target._backMask.show();
    } else {
        target.makeBackMask({_eventHandlerDragMoveMask: true});
    }
},

_hideBackMask : function (target) {
    if(target._backMask && target._backMask._eventHandlerDragMoveMask
       && target._backMask.isVisible()) 
    {
        target._backMask.hide();  
    }
},


_getDragMoveComponents : function () {
    var dmt = this.dragMoveTarget;
    if (!dmt) return;
    var components = [dmt];
    if (dmt._backMask) components.add(dmt._backMask);
    if (dmt._edgedCanvas) components.add(dmt._edgedCanvas);
    if (dmt._shadow) components.add(dmt._shadow);
    return components;
},

// Helper to speed up the 'dragRepositionMove' et al name assembly
_dragMoveEventNames:{},
_getDragMoveEventName : function (dragOperation) {
    var eventNames = this._dragMoveEventNames;
    if (!eventNames[dragOperation]) {
        eventNames[dragOperation] = dragOperation + "Move";
    }
    return eventNames[dragOperation];
},

// Deliver the synthetic dragMove event, also handling the dragAppearance
handleDragMove : function () {

	var EH = this,
		event = EH.lastEvent;

	// get the drop target, if there is one
    isc._useBoxShortcut = true;
	EH.dropTarget = EH.getDropTarget(event);
    isc._useBoxShortcut = false;
    
    

	// if a dragMoveAction has been set, call it now
	if (EH.dragMoveAction) EH.dragMoveAction();

	// send the appropriate [dragMove, dragResizeMove, dragRepositionMove] event to the
    // dragTarget and bail if it returns false.  This is another way for your handler to stop
	// drop processing if you don't like what you're about to be dropped over.
    // NOTE: this cancels drop events being sent to the candidate drop target, not the
    // dragMoveAction, which eg moves the dragTracker with the mouse.
	if (EH.handleEvent(EH.dragTarget, this._getDragMoveEventName(EH.dragOperation)) == false) {
		delete EH.dropTarget;
		return false;
	}
	
	// if the dropTarget is not the last drop target that got a mouse event
	//	send the dropOver and dropOut routines to the targets
	if (EH.dropTarget != EH.lastDropTarget) {

        //>DEBUG
        this.logDebug("New drop target: " + EH.dropTarget, "dragDrop");
        //<DEBUG

		// send the mouseOut event to the last mover object
		if (EH.lastDropTarget) {
			EH.handleEvent(EH.lastDropTarget, EH.DROP_OUT);
		}

		// send the mouseOver event to the target
		if (EH.dropTarget) {
			EH.handleEvent(EH.dropTarget, EH.DROP_OVER);
		}
		
		// remember that we're the last move object
		EH.lastDropTarget = EH.dropTarget;
	}

	// call dropMove on the dropTarget
	if (EH.dropTarget) {
		EH.handleEvent(EH.dropTarget, EH.DROP_MOVE);
	}

    isc._useBoxShortcut = true;
    this._handleDragScroll();
    isc._useBoxShortcut = false;

	return false;
},

// Automatic scroll on drag: if we're dragging near the edge of a scrollable widget, scroll it
// in the appropriate direction.
_handleDragScroll : function () {
    var EH = this,
        dragTarget = EH.dragTarget;
    
    // Determine which widget would be scrolled (assuming we're over the right place)
    
    var scrollCandidates = [];
    var canvasList = dragTarget.dragScrollType == "parentsOnly" ?
                        dragTarget.getParentElements() : isc.Canvas._canvasList;
    ;
    // shortcut - if there are no valid scroll candidates, just bail
    // True for top level widgets with dragScrollType set to parentsOnly
    if (canvasList == null || canvasList.length == 0) return;
    
    for (var i = 0; i < canvasList.length; i++) {
        if (//canvasList[i] != EH.dragTarget &&
            //canvasList[i] != EH.dragMoveTarget &&
            (canvasList[i].hscrollOn || canvasList[i].vscrollOn) &&
             canvasList[i].isDrawn() && canvasList[i].isVisible() && 
            canvasList[i].shouldDragScroll()
        ) {
            scrollCandidates.add(canvasList[i]);
        }
    }
        
    var event = EH.lastEvent,
        eX = event.x, eY = event.y,
        matches = [];

    //this.logWarn("have dragScroll candidates: " + scrollCandidates);

    for (var i = 0; i < scrollCandidates.length; i++) {
        
        if (scrollCandidates[i].visibleAtPoint(eX, eY, false, EH._getDragMoveComponents()))
            matches.add(scrollCandidates[i]);
    }
        
    // If we end up with more than one scroll candidate, one must be an ancestor of the 
    // other [as visibleAtPoint() will not return true for a widget covered by another widget]
    // Check each of these for whether we're over the scroll area of the widget,
    // and remove from the list of candidates if not
        
    if (matches.length > 0) {
        var scrollWidget;
        for (var i = 0; i < matches.length; i++) {
            // dragScrollDirection used to limit dragScrolling of ancesters to either
            // horizontal or vertical
            // This property is set on certain widgets such as the scrollbar thumb where
            // scrolling the parent in response to dragging only makes sense on one axis
            if (matches[i]._overDragThreshold(dragTarget.dragScrollDirection)) {
                if (scrollWidget == null || scrollWidget.contains(matches[i], true)) 
                    scrollWidget = matches[i];
            }
        }
        if (scrollWidget != null) scrollWidget._setupDragScroll(dragTarget.dragScrollDirection);
    }
},


// Deliver the artificially generated 'dragStop' event when the mouse goes up at the end of a
// drag
handleDragStop : function () {

	var EH = this,
		event = EH.lastEvent,
        successfulDrag = false;

	// note that we're no longer dragging
	EH.dragging = false;

    //>DEBUG
    this.logInfo("end of drag interaction", "dragDrop");
    //<DEBUG

    // reset the drag offsets
	EH.dragOffsetX = EH.dragOffsetY = 0;

    var dragTarget = EH.dragTarget,
        dragMoveTarget = EH.dragMoveTarget,
        dragOperation = EH.dragOperation;

	// if the dragMoveTarget is the tracker or outline, hide it
	if (dragMoveTarget && 
        (dragMoveTarget == EH.dragTracker || dragMoveTarget == EH.dragOutline)) 
    {
		dragMoveTarget.hide();
        
	} else {
        // If we're showing a drag-shadow, hide (or shrink) it
        if (dragTarget.showDragShadow) EH._hideTargetDragShadow();
        
        // If the target has a special drag-opacity, revert to orginal opacity
        // If we're showing a drag-shadow, hide (or shrink) it
        if (dragTarget.dragOpacity != null) EH._resetTargetDragOpacity();
        
    }
    
    // if the dragTracker was customized via setDragTracker(), destroy it now and re-create
    // next time we need it.
    if (this.dragTracker && this.dragTracker._isCustomized) {
        this.dragTracker.destroy();
        delete this.dragTracker;
    }

    

	// if there is a dropTarget, 
    var dropTarget = EH.dropTarget;
	if (dropTarget) {
		// send it the 'dropOut' event so it can reset its visible state
		EH.handleEvent(EH.dropTarget, EH.DROP_OUT);
        if (dropTarget.willAcceptDrop()) EH.handleEvent(dropTarget, EH.DROP);
        successfulDrag = true;
    }

    // determine if we were dragging something other than the dragTarget (eg an outline)
    var wasDraggingTarget = (dragTarget == dragMoveTarget);

	// send the dragTarget the [ dragStop | dragRepositionStop | dragResizeStop ] event so it can
    // reset its visual state
	if (EH.handleEvent(dragTarget, dragOperation+"Stop") != false) {

        successfulDrag = true;
        
        if (dragOperation == EH.DRAG_RESIZE) {
 
            if (!wasDraggingTarget) {
				// resize the dragTarget to the size of the dragMoveTarget
                dragTarget.setPageRect(  dragMoveTarget.getPageLeft(),
                                         dragMoveTarget.getPageTop(),
                                         dragMoveTarget.getWidth(),
                                         dragMoveTarget.getHeight(),
                                         true   );
            }
            
            var deltaX = dragTarget.getVisibleWidth() - EH.dragTargetStartRect[2],
                deltaY = dragTarget.getVisibleHeight() - EH.dragTargetStartRect[3];

            // fire 'dragResized()' one-time event to indicate we're done drag-resizing
            
            dragTarget.dragResized(deltaX, deltaY);

        // otherwise if a reposition operation
        } else if (dragOperation == EH.DRAG_REPOSITION) {
            if (!wasDraggingTarget) {
				// move the target if we were moving a different drag-move target.
                dragTarget.setPageRect(  dragMoveTarget.getPageLeft(),
                                         dragMoveTarget.getPageTop()  );
				// and bring it to the front
				dragTarget.bringToFront();
			}
            
            // Fire 'dragRepositioned' to indicate we have drag-moved the widget
            EH.dragTarget.dragRepositioned();
		}

	// drag[Reposition|Resize]Stop returned explicit "false", indicating cancel -
	// if we were moving the dragTarget, put it back the way we found it
	} else {
		if (dragOperation == EH.DRAG_RESIZE) {
			// if we were actually resizing the original target
			if (wasDraggingTarget) {
				// set its rect back to its original rect
				dragTarget.setRect(EH.dragTargetStartRect);
			}
		} else if (EH.dragOperation == EH.DRAG_REPOSITION) {
			// if we were actually moving the original target
			if (wasDraggingTarget) {
				// set its location back to its original location
				dragTarget.moveTo(EH.dragTargetStartRect[0],EH.dragTargetStartRect[1]);
			}			
		}
        // Don't fire the one-time resized() / repositioned() events in this case.
	}
	
	// clear all drag properties (they may have been set by event handlers)
	EH.clearDragProperties();

	// 030801 jmd: hide eventMasks (which avoided swallowing of drag events in iframes)
	EH.hideEventMasks();

	// send the object under the mouse a 'mouseOver' event and make it the lastMoveTarget
    // In DOM browsers and IE4, mouseUp is sent to the object under the mouse, so we can
    // send mouseOver to the event target.
    var overTarget = EH.lastEvent.target;
    if (overTarget) EH.handleEvent(overTarget, EH.MOUSE_OVER);
    EH.lastMoveTarget = overTarget;

	// return whether the drag was successful
	return successfulDrag;
},

// Return the Canvas that is the intended recipient of this event.
//
// This maps events from the physical DOM into our logical Canvas event space,
// allowing us to process events in canvases easily.
//
// If the targeted canvas has an 'eventProxy', that will receive the event instead.
//			
//		@param	DOMevent		(DOM event) 		DOM event object (as passed by isc.EventHandler)
//		@param	target			(DOM element) 		Native DOM element that got the event (default is DOMevent.target|srcElement).
//
//		@return				(Canvas || DOM object)	Canvas or DOM object that is event recipient
_$BODY:"BODY", _$HTML:"HTML",
_$eventProxyAttributeName:"eventProxy",
getEventTargetCanvas : function (DOMevent, target) {
    var EH = this,
        wd = this.getWindow();

    

    if (!target) target = (isc.Browser.isIE ? DOMevent.srcElement : DOMevent.target);
    //this.logWarn("native target:"+ (target ? (target.tagName + ", " + target.id) : " null"));

    
    if (!EH._canAccessNativeTargetProperties(target)) {
        //this.logWarn("TextNode exception: had to return last target " + EH.lastTarget);    
        return EH.lastTarget;
    }

    if (DOMevent && DOMevent._isSynthetic) return DOMevent.target;

    // optimization: if there is no target or the target is the body tag (so there is no
    // canvas target), bail immediately.  This means we don't burn CPU time while the mouse
    // is moving around outside all Canvas's
    if (!target || target.tagName == this._$BODY || target.tagName == this._$HTML) {
        //this.logWarn("event targetted at body");
        return (EH.lastTarget = null);
    }

    if (target && target.tagName && target.tagName == this._$applet) {
        var appletID = isc.Applet ? isc.Applet.idForName(target.name) : null;
        return appletID ? window[appletID] : EH.lastTarget;
    }
   
    
    if (isc.Browser.isIE && target.parentElement == null) {
        //this.logWarn("Defaulting to last target because target: " + Log.echoLeaf(target) + 
        //             " has null parentElement");
        target = EH.lastTarget;
    } else {
        var eventProxyAttributeName = this._$eventProxyAttributeName;

        // follow the DOM parent chain to find the nearest containing Element which has an
        // eventProxy attribute - the eventProxy attribute is the global ID of a Canvas
        // which will handle the event.
        // NOTE: all Canvii write out an eventProxy on the DIV that contains all
        // their content.  This is normal way events are routed, however, you can put an
        // "eventProxy" attribute in any HTML element to have its events handled by a Canvas.
        //var lookupChain = [];
        if (isc.Browser.isIE) {
            // in IE, any attribute written in HTML is available as a property on the
            // HTMLElement object
            while (target != null) {
                //lookupChain.add(target);

                // stop if we've found the eventProxy attribute
                if (target.eventProxy) break;

                // otherwise continue to parent
                target = target.parentElement;
            }
        } else {
            // in DOM browsers, you have to use DOM methods like hasAttribute/getAttribute.
            while (target != null) {
                //lookupChain.add(target);

                // stop if we've found the eventProxy attribute
                if (target.eventProxy != null ||
                    (target.hasAttribute != null && 
                     target.hasAttribute(eventProxyAttributeName))) break;

                // otherwise continue to parent
                target = target.parentNode;
            }
        }

        

        // we followed the parent chain until it ended without finding an eventProxy
        // attribute, so there's no Canvas to handle this event
        if (!target) return (EH.lastTarget = null);

        // "target" is the first DOM element in the parent chain with an eventProxy
        // attribute.  It's eventProxy attribute is a String that is the global ID of a
        // Canvas.  convert target to a Canvas
        target = wd[target.getAttribute(eventProxyAttributeName)];

        // Canvii can use the eventProxy attribute to delegate events to other Canvii
        while (target && target.eventProxy) {
            //if (DOMevent.type != "mousemove") {
            //    this.logWarn("Canvas: " + target + " delegates to: " + target.eventProxy);
            //}
               
            if (isc.isA.String(target.eventProxy)) {
                // if eventProxy is the string ID of a Canvas, convert it to a pointer to the
                // other Canvas, and store the looked-up Canvas.
                target.eventProxy = wd[target.eventProxy];
            }
            target = target.eventProxy;
        }

        // now we have the final target of the event
        if (this.logIsInfoEnabled() && 
            DOMevent.type != "mousemove" && DOMevent.type != "selectstart") 
        {
            if (target != null) {
                this.logInfo("Target Canvas for event '" + DOMevent.type + "': " + target);
            } else {
                this.logDebug("No target Canvas for event '" + DOMevent.type + "'");
            }
        }

        // if the event is in the drag tracker, send it to the last known object instead
        if ( target == EH.dragTracker ) {
           target = EH.lastTarget;
        }

        // remember the object for later, in case we get a weird event where we can't
        // figure out the target
        EH.lastTarget = target;
    }

    // if the target is a canvas, return that
    if (isc.isA.Canvas(target)) return target;

    // return null since no canvas target was found
    return null;
},

_$textObjectString:"[object Text]",
_canAccessNativeTargetProperties : function(target) {
    

    // Optimization - if we're not in Moz, looking at a text node, assume we're ok
    if (!(isc.Browser.isMoz && target == this._$textObjectString)) return true;        

    // Note the try/catch block must be in String form since Nav4 will give a parse error if
    // there's a try/catch block even if its never executed.
    if (!this._nodeTestFunction) {
        this._nodeTestFunction = 
                new Function("_target", 
                             "try{_target.parentNode}catch(e){return false}return true");
    }
    
    // If we caught an exception, return false - we can't access the properties of the target
    return this._nodeTestFunction(target);
},



//>	@classMethod	isc.EventHandler.getDropTarget()	(A)
//	    Return the first object that's registered that it's interested in drops that is under
//	    the mouse.<br>
//      This method does not check the result of the dynamic 'willAcceptDrop()' method, so it's
//      possible that the canvas returned by this method will not actually accept drop from the
//      dragged widget.
//
//		@group	dragDrop
//		@param	event		(SC event)  Event object, as returned from EH.getMouseEventProperties
//
//		@return				(Canvas)	Canvas that should receive the drop, or null if none found
//  @visibility internal
//<
// Note: Not checking willAcceptDrop() is desired behavior - this allows behavior such as showing
// the no-drop indicator (for example no drop indicator on certain rows in a grid)
getDropTarget : function (event) {
	var EH = this;

    

	// if there is no target or the drag target can't be dropped, 
	//	return null because there can't be a drop target!
	if (!EH.dragTarget || !EH.dragTarget.canDrop || 
        EH.dragOperation == EH.DRAG_RESIZE) return null;

	var target = (EH.dragMoveTarget || EH.dragTarget),

	    dropCandidates = EH._dropRegistry,
		matches = [],
		i = 0,
		length = dropCandidates.length,
        
        // we'll always disallow dropping over self if dragAppearance is target
        canDropOnSelf = (target.dragAppearance != isc.EH.TARGET)
	;

	// perform different checks based on how we're supposed to intersect the drop targets
	if (target.dragIntersectStyle == EH.INTERSECT_WITH_MOUSE) {
 
        
        if (event.target != this.mouseDownTarget() ||
            (isc.Browser.isIE || isc.Browser.isSafari || 
            (isc.Browser.isMoz && isc.Browser.geckoVersion > 20040616 &&
             !this.mouseDownTarget()._useMozScrollbarsNone))) 
        {
            var dropTarget = event.target;

            // allow delegating dropTarget for eg dropLine indicators
            while (dropTarget && dropTarget.dropTarget) dropTarget = dropTarget.dropTarget;
            if ((canDropOnSelf || dropTarget != target) &&
                (dropCandidates.contains(dropTarget)))
            {
                //this.logWarn("used quick check, dropTarget: " + dropTarget + 
                //              ", event target: " + event.target);
                return dropTarget;
            }
        }

		// check whether mouse coordinates are within candidate drop target
        // Note - we're using 'visibleAtPoint()' here rather than 'containsPoint()', as we don't
        // want to pick up a drop target that's occluded by another widget.
        // We may still pick up more than one match, as one canAcceptDrop:true widget may be
        // a child of another.
        // We ignore the dragMoveTarget in this check since it is likely to be under the mouse
        // (or near enough that a quick movement may put it under the mouse).
		for (;i<length;i++) {
			var candidate = dropCandidates[i];
            
                
			if (candidate.canAcceptDrop && !candidate.isDisabled() &&
                (
                 candidate.visibleAtPoint(event.x, event.y, false, 
                                          EH._getDragMoveComponents())
			     // candidate.containsPoint(event.x, event.y))
                ) &&
                (canDropOnSelf || candidate != target)
               ) 
            {
				matches.add(candidate);
			}
		}
	} else {
		// check whether dragMoveTarget (tracker, outline, etc) intersects candidate drop target
		for (;i<length;i++) {
			var candidate = dropCandidates[i];
            if (!canDropOnSelf && candidate == target) continue;
            
			if (candidate.intersects(target) && 
                candidate.canAcceptDrop && !candidate.isDisabled()) 
            {
				matches.add(candidate);
                
			}
		}
    }

    //this.logWarn("dropTarget matches" + matches);

	// if there's only one possible drop target, return it
	if (matches.length < 2) return matches[0];

    // For mouse intersection, we may have multiple matches.
    // If some match is the parent of another, the child will always be given preference
    var nearestMatch = matches[0];
    for (var i = 1; i < matches.length; i++) {
        var currentMatch = matches[i];
        // if one is an ancestor of the other, the descendant always wins
        if (nearestMatch.contains(currentMatch, true)) {
            nearestMatch = currentMatch;
        
        // intersectRect check about doesn't handle the case of overlapping widgets occluding
        // each other catch the case of 1 match occluding another.
        } else if (target.dragIntersectStyle == EH.INTERSECT_WITH_RECT) {
         
            // Othewise we want to find a common ancestor of both widgets,
            // and compare the z-indices of their separate ancestors in that common scope
            var commonParent = null,
                nmCommonScopeAncestor = nearestMatch, 
                cmCommonScopeAncestor = currentMatch;
                
            while (commonParent == null) {
                // if we've reached a top-level ancestor widget, the common scope is the document 
                // body, so we'll compare the top-parent of each match widget.
                if (nmCommonScopeAncestor.parentElement == null) {
                    commonParent = true;    // to break out of the while loop
                    cmCommonScopeAncestor = currentMatch.topElement || currentMatch;
    
                // Otherwise check if the ancestor's parentElement is also the ancestor of the 
                // currentMatch
                } else if (nmCommonScopeAncestor.parentElement.contains(currentMatch, true)) {
                        commonParent = nmCommonScopeAncestor.parentElement;
                        // iterate up the currentMatch's parents til we find one in the right scope
                        while (cmCommonScopeAncestor.parentElement != commonParent) {
                            cmCommonScopeAncestor = cmCommonScopeAncestor.parentElement;
                        }
                        
                } else {
                    // look at the ancestor's parent (which we know is not a common ancestor of both
                    // matches)
                    nmCommonScopeAncestor = nmCommonScopeAncestor.parentElement;
                }
            }
            
            // compare the z-indices of the ancestors in the same scope, and adjust nearestMatch if
            // necessary
            if (cmCommonScopeAncestor.getZIndex() > nmCommonScopeAncestor.getZIndex()) {
                nearestMatch = currentMatch;	
            }
        }
    }
    
    return nearestMatch;
},

// Register a canvas passed to receive drop events.
registerDroppableItem : function (item) {
	if (!item._dropRegistered) {
		this._dropRegistry.add(item);
		item._dropRegistered = true;
	}
},

// Un-register a canvas so it will no longer receive drop events
unregisterDroppableItem : function (item) {
	this._dropRegistry.remove(item);
	delete item._dropRegistered;
},


// Register this Canvas as needing to be "masked" during drag interactions, because it contains
// something that will otherwise swallow events.

registerMaskableItem : function (item, makeMask) {
	if (!this._maskRegistry.contains(item)) {
        // keep a list of items that need masking so we can show their masks when a drag begins
		this._maskRegistry.add(item);

        // make an event mask for the item that just passes events through to it.  It won't be
        // show()n yet.
        if (makeMask) this.makeEventMask(item, {eventProxy:item});
	}
},

//>	@classMethod	isc.EventHandler.unregisterMaskableItem()	(A)
//		Remove this canvas from the _maskRegistry and destroy its
//		event mask peer.
//   @visibility internal
//<
unregisterMaskableItem : function (item) {
	this._maskRegistry.remove(item);
    if (item._eventMask) item._eventMask.destroy();
	delete item._eventMask;
},

// Make a transparent mask suitable for capturing events, as a peer of the target Canvas
makeEventMask : function (canvas, properties, rect) {
    if (isc.isA.Function(canvas.makeEventMask)) return canvas.makeEventMask(properties, rect);

    var defaults = this._eventMaskProperties;
    
    // In IE7, the spacerHTML isn't sufficient to mask IFRAMEs properly, but an image works
    // Note: if you update this code, also check and update ScreenSpan.getInnerHTML()
    if (!defaults.contents) defaults.contents = isc.Browser.isIE && isc.Browser.version > 6 ? 
        isc.Canvas.blankImgHTML(1600,1200) : isc.Canvas.spacerHTML(1600,1200);
    var mask = isc.Canvas.create({
			ID:canvas.getID()+"_eventMask",
			cursor:canvas.cursor,
            _maskTarget: canvas
		}, defaults, properties);
    mask.setRect(rect ? rect : canvas.getRect());
    canvas._eventMask = mask;
	canvas.addPeer(mask);
    return mask;
},

//>	@classAttr	EventHandler._eventMaskProperties  (object : {...} : IRWA)
//  @visibility internal
//<
_eventMaskProperties : {
	autoDraw:false,

    // match the size of the Canvas we're masking
    _resizeWithMaster:true,
	_redrawWithMaster:false,

    // NOTE: we can't initialize the contents here because EventHandler loads before Canvas.
    // By setting very large contents with overflow:hidden we never need to redraw on resize.
    //contents:isc.Canvas.spacerHTML(1600, 1200),
    overflow:"hidden",

    // start out hidden, only show if explicitly shown
    visibility:"hidden",
    _showWithMaster:false,

    getTarget : function () {
        return this._maskTarget;
    },
    
    show : function () {
		// when we're show()n (because dragging has begun), move above the master.  NOTE: this
        // doesn't guarantee the eventMask stays above the master in general - only when
        // explicitly show()n
        var master = this.masterElement;
		this.moveAbove(master);
		return this.Super("show", arguments);
	}
},

// Show event masks for all registered canvases, or a single event mask
// spanning the entire screen if simpleMask is true.
showEventMasks : function (simpleMask, unmaskedItems) {
	var EH = this,
		maskedItems = EH._maskRegistry;
	if (simpleMask) {
        // just do a single screen-sized mask
		if (!EH._eventMask) EH._eventMask = isc.ScreenSpan.create({
            ID:"isc_EH_eventMask",
			mouseDown:function () {this.hide()},	// 030801 jmd: insurance against lock-out if stuck
            // if the screenspan gets destroyed() clear up our pointer to it
            pointersToThis:[{object:EH, property:"_eventMask"}]
		});
		EH._eventMask.show();
		EH._eventMask.bringToFront();
        //>BrowserPlugin
        // browser plugin masks typically cannot be replaced by a single screen mask, always
        // show these
        if (isc.BrowserPlugin) {
            maskedItems.intersect(isc.BrowserPlugin.instances).map("_showDragMask");
        }
        //<BrowserPlugin
	} else {
        // show masks for all components that need masking
		for (var i = 0; i < maskedItems.length; i++) {
            var item = maskedItems[i];

            // If we've been passed an explicit set of items to mask, ensure only those
            // items end up masked.
            if (unmaskedItems && unmaskedItems[item.getID()]) {
                item._hideDragMask();
			} else {
                item._showDragMask();
            }
		}
	}
},

// Hide event masks for all registered canvases, or the single event mask
// spanning the entire screen.
hideEventMasks : function () {
	var EH = this,
		maskedItems = EH._maskRegistry;

	if (EH._eventMask && EH._eventMask.isVisible()) {
		EH._eventMask.hide();
        if (isc.BrowserPlugin) {
            maskedItems.intersect(isc.BrowserPlugin.instances).map("_hideDragMask");
        }
	} else {
		for (var i = 0; i < maskedItems.length; i++) {
			maskedItems[i]._hideDragMask();
		}
	}
},


// Return true if the specified event should be handled by the native event mechanism rather
// than by our EventHandler mechanism.  Used to avoid interferance with native form event
// processing and other similar cases.

_handledNativelyReturnVal:isc.Browser.isIE ? isc.undef : true,
eventHandledNatively : function (eventType, nativeTarget) {
    // If passed a native event name (standard behavior), convert the eventType to our ISC 
    // eventType.
    // Note: if we fail to convert it, we will simply work with whatever we were passed as
    // an event type.
    var iscEventType = eventType;
    if (!this.reverseEventTypes[eventType]) {
        if (this._nativeMouseEventMap[eventType]) 
            iscEventType = this._nativeMouseEventMap[eventType];
        else if (this._nativeKeyEventMap[eventType]) 
            iscEventType = this._nativeKeyEventMap[eventType];
    }
    
    var returnValue = this._eventHandledNatively(iscEventType, nativeTarget);
    if (returnValue && this.logIsDebugEnabled() && iscEventType != "mouseMove") {
        this.logDebug(eventType + " event on " + this.lastTarget + " handled natively")
    }
    return returnValue;
}, 

_$handleNativeEvents:"handleNativeEvents",
_$applet: "APPLET",
_eventHandledNatively : function (eventType, nativeTarget) {
    //!DONTCOMBINE

	eventType = (eventType || "");

    
	var EH = this,
		event = EH.lastEvent;

    
    if (!EH._canAccessNativeTargetProperties(nativeTarget)) {
        //EH.logInfo("eventHandledNatively() can't get to event target properties." +
        //           "  Returning true");
        return true;
    }
    if (nativeTarget && nativeTarget.tagName == this._$applet) return true;    


    // if there's no target canvas, the event did not occur over any ISC widgets...
    // don't interfere with event handling if it's a mouse event.  Return true
    
    var isMouseEvent = EH.isMouseEvent(eventType),
        iscTarget = isMouseEvent ? event.target : event.keyTarget;
    
 
    if (isMouseEvent && iscTarget == null) return true;

    //>DEBUG
    if ((this.logIsInfoEnabled() && eventType == EH.KEY_DOWN) ||
        (this.logIsDebugEnabled() && (eventType == EH.KEY_UP || eventType == EH.KEY_PRESS))) 
    {
        this.logInfo(eventType + " event with Canvas target: " + this.lastEvent.keyTarget +
                     ", native target: " + this.echoLeaf(nativeTarget));
    }
    //<DEBUG

	// if it's a form element or an anchor, just return true so the event can be processed
    // automatically
	// NOTE: we may have an image (or something else) that is contained in an anchor, 
	//		 so we have to look through the list of parentElements for an anchor tag, 
	//		 we can't just look at the nativeTarget
    
	if (EH.passThroughEvents && nativeTarget) {
    
    
        //if (eventType.startsWith("key")) {
        //    this.logWarn("nativeTarget: " + this.echoDOM(nativeTarget));
        //}
		// testTarget will change to be successive parentElements of the nativeTarget
		//	until we get to the body tag
		var testTarget = nativeTarget,
            
            // isNative will be true if 
            // - the target has been marked as handling native events, or
            // - we've found either a native form or anchor element, which is not a focusProxy
            handleNativeEvents = (testTarget.handleNativeEvents || 
                                    (testTarget.getAttribute ? 
                                     testTarget.getAttribute(this._$handleNativeEvents) : null)),
            tagName = testTarget.tagName,
            isNative
        ;
        
        if (!EH._falseString) EH._falseString = "false";            
        
        // If the 'handleNativeEvents' flag wasn't explicitly set, check for form items and
        // elements that will want to handle their own events.
        
        if (handleNativeEvents == null) {

            isNative = (!testTarget.focusProxy &&
                            
                           ((testTarget.form != null && tagName != EH._labelString) || 
                            
                            EH._formTags[tagName] != null ||
                            // editable DIVs (Not supported in Mozilla)
                            
                            (testTarget.isContentEditable && !testTarget.eventProxy))
                        );

    		// if we didn't find a form, check if we're inside an anchor tag, because we want to
            // allow native processing (following the link).
            
            if (!isNative && (eventType != EH.MOUSE_WHEEL) && (eventType != EH.MOUSE_MOVE)) {
    			while (testTarget && 
                        testTarget.tagName != EH.BODY_TAG && testTarget.tagName != this._$HTML) 
                {
                    // Don't iterate up past any widget's handle - we don't expect canvii to be
                    // written out inside <A> tags
                    
                    if (testTarget.eventProxy != null ||
                        (testTarget.hasAttribute != null && 
                         testTarget.hasAttribute(this._$eventProxyAttributeName))) break;
                
    				if (EH._anchorTags[testTarget.tagName] != null) {
                        
                        var HNE = (testTarget.handleNativeEvents || 
                                    (testTarget.getAttribute ? 
                                     testTarget.getAttribute(this._$handleNativeEvents) : null));
            
                        if (HNE != null && !isc.isA.emptyString(HNE)) {
                            if (isc.isA.String(HNE)) 
                                HNE = (HNE == isc.EH._falseString ? false : true);
                        }
                        
                        if (HNE != false) {
                            isNative = true;
                            break;
                        }
    				}
    				testTarget = testTarget.parentNode;
    			}
    		}
        } else {
        
            // isNative derived directly from the "handleNativeEvents" property hung on the
            // DOM element.  This will be a string - convert "false" to false, so the check for 
            //  if (isNative) {... 
            // will do the right thing.
            isNative = handleNativeEvents;
            if (isNative == EH._falseString) isNative = false;
        }
        
		// if we found a native form or anchor element, return so we don't process the event
        // ourselves
		if (isNative) {
            return true;
            
        // if we had an explicit 'handleNativeEvents=false' specified on the target, avoid 
        // further checking
        } else if (handleNativeEvents != null) {
            return false;
        }
	}
    
    // At this point we know that the event occurred on a canvas, and not over any of the
    // special elements that need native handling.
    //
	// if the event was a mouse-event in a CSS scrollbar let it be handled natively.
    if (isMouseEvent && this._eventOverCSSScrollbar(iscTarget, eventType, event)) return true;
	// return false so isc event processing continues
	return false;
},

// Is the event passed in a mouse event?
isMouseEvent : function (eventType) {

    // This method is used by eventHandledNatively to determine whether the DOMevent it is 
    // looking at is a mouse event.
    // As such the eventType passed in may be the native event name - which is all lowercase
    // rather than our camelCase event names.  Handle either case.
    
    eventType = eventType || this.lastEvent.eventType;
    
    // list of all mouse events, native and ISC names
    if (this._mouseEvents == null) {
        this._mouseEvents = {
            mouseOver:true, mouseover:true,
            mouseDown:true, mousedown:true, rightMouseDown:true,
            mouseMove:true, mousemove:true,
            mouseOut:true, mouseout:true,
            mouseUp:true, mouseup:true,
            DOMMouseScroll:true, mousewheel:true, mouseWheel:true,
            click:true,
            doubleClick:true, doubleclick:true,
            showContextMenu:true, showcontextmenu:true,
            selectStart:true, selectstart:true
        }
    }

    if (this._mouseEvents[eventType]) return true;
    // otherwise it's not a mouse event.
    return false;
},

// Is the event passed in a key event?
isKeyEvent : function (eventType) {

    // This method is used by eventHandledNatively to determine whether the DOMevent it is 
    // looking at is a key event.
    // As such the eventType passed in may be the native event name - which is all lowercase
    // rather than our camelCase event names.  Handle either case.

    eventType = eventType || this.lastEvent.eventType;
    
    if (this._keyEvents == null) {
        this._keyEvents = {};
        var ke = this._keyEvents;
        
        // ISC names:
        ke[this.KEY_DOWN] =true; ke[this.KEY_PRESS] = true; ke[this.KEY_UP] = true;
        
        // add native event names:
        var nativeMap = this._nativeKeyEventMap;
        for (var name in nativeMap) ke[name] = true;
    }

    if (this._keyEvents[eventType]) return true;
    // otherwise it's not a key event.
    return false;
},

// Did the current mouse event occur over a native CSS scrollbar?
_eventOverCSSScrollbar : function (iscTarget, eventType, event) {
    var EH = this;
    
    		
    // If there's no target or we're not showing native scrollbars, return false
	if (!iscTarget || iscTarget.showCustomScrollbars || 
        !(iscTarget.vscrollOn || iscTarget.hscrollOn)) return false;
        
    
    
    // if right to left, scrollbar on LEFT
    var scrollbarSize = isc.Element.getNativeScrollbarSize();
    if (iscTarget.isRTL()) {
        if ( (iscTarget.vscrollOn && (event.x < iscTarget.getPageLeft() + scrollbarSize) ) ||
             (iscTarget.hscrollOn && (event.y > iscTarget.getPageTop() + 
                                  iscTarget.getHeight() - scrollbarSize) ) 
           )
        {
            if (eventType==EH.MOUSE_DOWN) EH._mouseIsDownInScrollbar = true;
            return true;
        }
    // else if left to right (normal), scrollbar on RIGHT
    } else {
        if ((iscTarget.vscrollOn && (event.x > iscTarget.getPageRight() - scrollbarSize)) ||
            (iscTarget.hscrollOn && (event.y > iscTarget.getPageBottom() - scrollbarSize)) ) 
        {                      
            if (eventType==EH.MOUSE_DOWN) EH._mouseIsDownInScrollbar = true;
            //this.logWarn(eventType + " in scrollbar");
            return true;
        }
    }

    return false;
},


//>	@classMethod	isc.EventHandler.bubbleEvent()	(A)
// Bubble the eventType in question up through the Canvas hierarchiy
//
//		@group	eventBubbling
//		@param	target		(object)	Canvas or DOM object that received the event
//		@param	eventType	(string) 	name of this event
//		@param	eventInfo	(any)		information passed with a custom event (see e.g. Slider)
//      @param  [targetIsMasked] (boolean) If passed we have already tested whether this target 
//                                         is masked, so don't re-check in this method
//
//		@return				(boolean)	false == cancel further event processing
//										anything else == continue processing
//      @visibility internal
//<

_dontLogBubble : {
    mouseMove : true,
    mouseOver : true,
    mouseOut : true
},

bubbleEvent : function (target, eventType, eventInfo, targetIsMasked) {
	var EH = this,
    	event = EH.lastEvent;

    //>DEBUG
	var logBubble = this.logIsDebugEnabled() && !this._dontLogBubble[eventType];
    //<DEBUG

    // if the virtual clickMask is up, prevent all mouse events from going to any Canvii except
    // the ones above the clickMask
    
    var isMouseEvent = this.isMouseEvent(eventType);
    if (isMouseEvent) {
        if (targetIsMasked == null) targetIsMasked = this.targetIsMasked(target);
        if (targetIsMasked) {
            if (logBubble) {
                this.logDebug(eventType + " on " + target + " blocked by clickmask");
            }
            return false;
        }
    }

    // For each event, we check for the existance of the 'internal' handler function - named
    // 'handle' + eventType ("handleMouseDown", etc.).
    // If this is defined on the target, call that otherwise, if the event name itself is
    // defined, call that.
    // - Note: this means 'handleMouseDown' (etc.) as defined on the target widget is
    //   responsible for calling 'mouseDown'.
    var eventHandlerName = this._getInternalHandlerName(eventType),
        method;

    while (target) {
        // never fire an event for a destroyed widget
        if (target.destroyed) break;

		// go up the eventParent or parentElement chain, using an eventProxy if one is defined
        // NOTE: calculate the next target here, because parent hierarchy might change during
        // event handling (eg clear() self when tearing off from a Layout), but the former
        // parent should still receive the event that happened within it.
        
		var nextTarget = (target.eventParent || target.parentElement);
		if (nextTarget && nextTarget.eventProxy) nextTarget = nextTarget.eventProxy;

        if (target[eventHandlerName] != null) {
            method = eventHandlerName;
        } else if (target[eventType] != null && target[eventType] != isc.Class.NO_OP
                                        && !isc.is.emptyString(target[eventType])) {
            method = eventType;                                        
        

			// if the eventType was defined as a string, convert it to a function
			if (isc.isA.String(target[eventType])) {
				target.convertToMethod(eventType);                
			}

            //>DEBUG
            if (logBubble) {
                this.logDebug("Bubbling event '" + eventType + "', target '" + target + 
                              "' has handler: " + this.echoLeaf(target[eventType]));
            }
            //<DEBUG
        }
        
        // if we have either a 'handleEvent' method or a straight 'event' method, fire it
        if (target[method] != null) {
            //this.logWarn(target + "[" + method + "]" + " is:" + target[method]);
    
            var result;
            //try {
                // now call the event handler, and if it returns false or cancels bubbling, bail
                result = target[method](event, eventInfo);
            //} catch (e) {
            //    this.logWarn("error returned invoking event handler: " + 
            //                 target.ID + "." + method + ": " + e.toString() + this.getStackTrace());
            //}

			if (result == false) {
                //>DEBUG
                if (logBubble) {
                    this.logDebug("Bubbling for event '" + eventType + 
                                  "' cancelled via false return value by target: " + target);
                }
                //<DEBUG
                return false;
            }
			if (result == EH.STOP_BUBBLING) {
                //>DEBUG
                if (logBubble) {
                    this.logDebug("Bubbling for event '" + eventType + 
                                  "' cancelled via STOP_BUBBLING return value by target: " + target);
                }
                //<DEBUG
                
                // Note: returning the stop-bubbling code, so callers of this method will see
                // the difference between 
                // - events that returned false (typically return false to the DOM to cancel
                //   native propogation)
                // - events that stopped bubbling but didn't return false (return true to the
                //   DOM - allow native event handling to continue unhindered)
                // - events that made it all the way to the top of the object hierachy (may want
                //   to prevent further event processing / bubbling, but not cancel the event 
                //   natively by returning false)
                
                return EH.STOP_BUBBLING;
            //} else {
            //    this.logDebug("Skipping " + target + ", no handler");
            }
		}

        target = nextTarget;
	}
	// we got to the end and noone failed -- return true to keep propagating the event!
    //>DEBUG
    if (logBubble) this.logDebug("Event '" + eventType + "' bubbled to top");
    //<DEBUG
	return true;
},

//>	@classMethod	isc.EventHandler._getInternalHandlerName()	(A)
// For each event, return the name of the preferred handler function to be called
// by bubble handler.
// This consists of the event name (passed in) prefixed with 'handler', and with
// the first character converted to uppercase.
//          
//		@group	eventBubbling
//		@param	event		(string)	Name of the event
//
//		@return			(string)    Name of preferred handler
//      @visibility internal
//<
_getInternalHandlerName : function (eventName) {
    
    if (!this._eventHandlerMap[eventName]) {
        this._eventHandlerMap[eventName] = 
                        "handle" + eventName.charAt(0).toUpperCase() + eventName.substring(1);
//        isc.Log.logWarn("handler for eventType:" + eventName + " is " + this.eventHandlerMap[eventName]);
    }
    return this._eventHandlerMap[eventName];
},
    

// Determine whether a target canvas (or any of its parents up the event bubbling
// hierachy) have a handler defined for an event.
// Note: This means either having the event property itself defined, or 'handleEvent'
// defined.
hasEventHandler : function (target, event) {
    if (!isc.isAn.Object(target) || !isc.isA.String(event)) {
        isc.Log.logWarn(
            "EventHandler.hasEventHandler() passed bad parameters [" 
                + [target, event] + "]. returning null;", 
            "event"
        );
        return null;
    }
    var handlerName = this._getInternalHandlerName(event);
    if (this.getBubbledProperty(target, event) != null ||
        this.getBubbledProperty(target, handlerName) != null) return true;
    return false;
},

// Return the value of a certain property for the target or, if not defined,
// for the first of the target's parents to define the property.
// This is useful, for example, to determine if a canvas is disabled:
// a canvas is considered disabled if it or any of its parents has disabled == true
getBubbledProperty : function (target, property) {
	while (target) {
		if (target[property]) return target[property];
		target = (target.eventParent || target.parentElement);
		if (target && target.eventProxy) target = target.eventProxy;
	}
	return null;
},


// handle the native "selectStart" event (IE specific) 
// In general, we want to suppress selection of text on web pages as it conflicts
// with drag and drop (and looks bad on pages with absolute positioning stuff).

handleSelectStart : function () {
    
        var EH = isc.EH;

    //isc.Log.logDebug("handleSelectStart() triggered (handler for native onselectstart).");

    // If the user is drag-selecting inside form items, allow selection to occur.
    // Don't allow selection to occur if the user is already performing an ISC recognized drag
    // and passes over a form item.
    
    var wd = EH.getWindow(),
        nativeTarget = wd.event ? wd.event.srcElement : null,
        mouseDownNativeTarget = EH.mouseDownEvent ? EH.mouseDownEvent.nativeTarget : null;

    if (nativeTarget && mouseDownNativeTarget == nativeTarget && nativeTarget.form
         && !EH.dragging) 
    {
        return true;
    }
    
    
    
    // Allow text selection if
    // - theres no target / mouseDownTarget canvas (don't interfere with native selection)
    // - mouseDown target doesn't disallow text selection
    // - mouseMove target doesn't disallow text selection 
    // - we're not performing a smartclient drag operation
    //
    // OnSelectStart is triggered from any type of selection (drag selection, shift+arrow 
    // keys, programmatic selection).
    // If this is a drag-selection, we want to check the lastMouseDown target
    // If the mouse is not down this is not a drag selection - don't bother checking for 
    // the last mouseDownTarget disallowing selection.
    // In this case getEventTargetCanvas(...) will still get us a pointer to the element
    // on which selection occurred from event.srcElement (set even though this may not be a
    // mouse event).
    
    if (isc.EH._allowTextSelection) return true;
    var mouseDownTarget = isc.EH.mouseIsDown() ? EH.mouseDownTarget() : null,
        target = EH.getEventTargetCanvas(wd.event);

    
    var allowSelection = !EH.dragging && !EH.dragTarget && 
                         (mouseDownTarget != null ? 
                            mouseDownTarget._allowNativeTextSelection() : true) &&
                         (target != null ? 
                            target._allowNativeTextSelection() : true);
                       
    if (allowSelection) return true;
    return EH.killEvent();
},



// handle the 'onselectionchange' event.  This is an IE specific event.

_$selectionChange:"selectionChange",
handleSelectionChange : function (event) {

    if (!event) event = window.event;

    
        var EH = isc.EH;

    var lastEvent = EH.lastEvent;
    
     
    var nativeTarget = isc.Element._getElementFromSelection(document);
    if (nativeTarget) {
        // derive the target canvas from the target element 
        
        var targetCanvas = EH.getEventTargetCanvas(event, nativeTarget);

        lastEvent.nativeKeyTarget = nativeTarget
        lastEvent.keyTarget = targetCanvas;
        lastEvent.eventType = this._$selectionChange;
        
        if (targetCanvas) {
            targetCanvas.keyTarget = targetCanvas;
            EH.bubbleEvent(lastEvent.keyTarget, "selectionChange");
        }
    }
    
    // We could return false here to cancel the selection change 
    return true;
},

// native ondragstart (IE only event).
// the ondragstart event happens if you try to drag some selected text or an image - it allows
// you to drop the selected text into any text editor, or save the image to the desktop.  If we
// don't cancel the event, IE takes over the drag, modifies the cursor and stops sending
// mouseMove.

handleNativeDragStart : function () {

    // If an ISC drag is occurring, return false to suppress the native drag so we can
    // continue to get mouse-moves and respond to the drag.
    if (isc.EH.dragTarget) return false;

    
    
    var target = isc.EH.mouseDownTarget();

    // if within a Canvas, allow the drag if you can select text within the Canvas.
    // This will allow the user to drag out a selected chunk of text to a text editor, etc. 
    
    if (target) return !!(target._allowNativeTextSelection());

    // call any native handler that we may have clobbered (manually for speed)
    if (this._documentDragStart) return this._documentDragStart();
    if (this._windowDragStart) return this._windowDragStart();

    
},


// Handle a page-level resize event.
handleResize : function (DOMevent) {
    //Log.logWarn("page-level resize event");
    // delay briefly to avoid getting flooded by page-level resize events during drag resize on
    // Windows IE
    if (isc.EH.resizeTimer == null) {
        isc.EH.resizeTimer = isc.Timer.setTimeout("isc.EH._pageResize()", 0);
    }
    // Always return true. This will allow any 'window.onresize' handlers set up before
    // ISC was loaded to fire.
    
    return true;
},


_pageResizePollMethod : function () { isc.EH._pageResize(true); },
_pageResize : function (polling) {
    isc.EH.resizeTimer = null;
    if (!polling) { 
    
        // This both records the reported width, and ensures that it's up to date.
        this._previousInnerWidth = isc.Page.getWidth(window, true);
        this._previousInnerHeight = isc.Page.getHeight(window, true);
            
        if (this.resizingPollTimer != null) isc.Timer.clearTimeout(this.resizingPollTimer);
        this.resizingPollTimer = isc.Timer.setTimeout(this._pageResizePollMethod, 100);
    } else {
        // We want to force a recalculation of width / height here.
        // If the value has changed, re-run the resized handler to resize children etc.
        var newWidth = isc.Page.getWidth(window, true),
            newHeight = isc.Page.getHeight(window, true),
            unchanged = (newWidth == this._previousInnerWidth && 
                       newHeight == this._previousInnerHeight)

        // If we're polling for content changes that introduce / hide scrollbars, 
        // re-run this method on every idle
        if (isc.Page.pollPageSize) {        
            isc.Page.setEvent(isc.EH.IDLE, this._pageResizePollMethod, isc.Page.FIRE_ONCE);
            this._previousInnerWidth = newWidth;
            this._previousInnerHeight = newHeight;
        }
        // Don't actually fire the handler if there was no resize
        if (unchanged) return;
    }
    isc.Page.handleEvent(null, isc.EH.RESIZE);
},

// handle a native "mousewheel" event, currently only available in IE6 and above, and Mozilla

handleMouseWheel : function (DOMevent) {
    
        var EH = isc.EH;
    if (!DOMevent) DOMevent = EH.getWindow().event;
    var nativeTarget = (DOMevent.srcElement || DOMevent.target);
    if (EH.eventHandledNatively(DOMevent.type, nativeTarget)) return EH._handledNativelyReturnVal;
    
    EH.getMouseEventProperties(DOMevent);
    //this.logWarn("wheelDelta:"+ isc.EH.lastEvent.wheelDelta);    
    
    // Pass to the appropriate widget, and stop if this returns false.
    var target = EH.getEventTargetCanvas(DOMevent);
    if (EH.bubbleEvent(target, EH.eventTypes.MOUSE_WHEEL) == false) {
        
        if (DOMevent.preventDefault) DOMevent.preventDefault();
        return false;
    }
    // Return true to avoid interfering with native events
    return true;
},

// Handle a "DOMMouseScroll" event
// This is the event Mozilla fires when the user spins the mouse scroll wheel.
// Fall through to the standard handleMouseWheel functionality, which will pick up the details
// for the event and cancel native behavior if appropriate

handleDOMMouseScroll : function (e) {
    return isc.EH.handleMouseWheel(e);
},

// Handle a scroll event
handleScroll : function (DOMevent) {
    
	//window.status = 'handleScroll ' + timeStamp();
    //return (EH.handleEvent(EH.getEventTargetCanvas(DOMevent), "_handleCSSScroll") != false);
},



prepareForLinkDrag : function (dragTarget, linkID) {
	this.dragTarget = (isc.isA.String(dragTarget) ? 
                       this.getWindow()[dragTarget] : dragTarget);
	this.dragTargetLink = linkID;
	return false;
},


// Drag Tracker
// ----------------------------------------------------------------------------------------

//>	@classMethod	isc.EventHandler.setDragTracker()
// Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction.
// <P>
// Your canvas can use this routine to set the drag tracker to whatever HTML you want like so:
// <pre>
//    dragStart : function () {
//        isc.EventHandler.setDragTracker('Your contents here');
//    }
// </pre>
//
//		@group	dragDrop, dragTracker
//		@param	html		(string) 	HTML for the tracker
//		@param	[newWidth]	(number)	new width for the tracker
//		@param	[newHeight]	(number) 	new height for the tracker
//		@param	[offsetX]	(number)	x-offset for the tracker
//		@param	[offsetY]	(number) 	y-offset for the tracker
//      @param  [properties] (object)   Opportunity to pass in a free-form set of properties 
//                                      for the dragTracker
//  @visibility external
//<

setDragTracker : function (html, newWidth, newHeight, offsetX, offsetY, properties) {
    var dragTracker = this._makeDragTracker(properties);

	// set size (or reset to small size if it was previously set larger)
    newWidth = newWidth || 10;
    newHeight = newHeight || 10;
    dragTracker.resizeTo(newWidth, newHeight);

    // update contents
	dragTracker.setContents(html);

    // redraw right away for responsiveness
    dragTracker.redrawIfDirty("setDragTracker");

    // apply drag offset if specified
	if (offsetX) dragTracker.offsetX = offsetX;
	if (offsetY) dragTracker.offsetY = offsetY;

    // we don't want these new settings to stick globally - require the user to call
    // setDragTracker() every time they want to deviate from the defaults only.  Otherwise any
    // single instance of deviation from defaults would require a setDragTracker() on all other
    // DnD interactions on the page simply to reset back to defaults.
    dragTracker._isCustomized = true;
},


// Create the 'drag tracker' -- a canvas that follows the mouse to indicate
// that something is being dragged.  See  isc.EventHandler.setDragTracker() for 
// details on how to customize the tracker.
_makeDragTracker : function (overrides) {
    if (!this.dragTracker) {
        var defaults = this.dragTrackerDefaults; 
        // set default contents just to make sure the drag tracker is visible if you enable it
        // but neglect to set contents.  NOTE that it's not expected that anyone would actually
        // use a black square and the contents are never restored to a black square.  NOTE also
        // that we don't want to use a background color which would bleed through transparent
        // images.
        defaults.contents = isc.Canvas.imgHTML("[SKIN]black.gif",10,10);
	    this.dragTracker = isc.Canvas.create(defaults, overrides);
    } else if (overrides != null) this.dragTracker.setProperties(overrides);
    return this.dragTracker;
},

// Get a Canvas that draws an outline, whose initial size and position matches the Canvas
// passed as an argument.
getDragOutline : function (target, outlineSize, outlineColor) {
    
    if (!this.dragOutline) {
        this.dragOutline = isc.Canvas.create({
            autoDraw:false,
            overflow:isc.Canvas.HIDDEN
        })
        
        if (isc.Browser.isIE) this.dragOutline.setContents(isc.Canvas.spacerHTML(1600, 1200));
    }

    var outline = this.dragOutline;
    if (isc.Element.getStyleDeclaration(target.dragOutlineStyle)) {
        outline.setStyleName(target.dragOutlineStyle);
    } else {
        outline.setBorder((outlineSize || 1) + "px solid " + (outlineColor || "black"));
    }

    // size the outline so it matches the object being resized
    outline.setPageRect(target.getPageLeft(), target.getPageTop(),
                        target.getVisibleWidth(), target.getVisibleHeight());

    // if this outline will be used for a resize, the min and max sizes of the outline need to
    // match the object being resized
    outline.minWidth = target.minWidth;
    outline.minHeight = target.minHeight;
    outline.maxWidth = target.maxWidth;
    outline.maxHeight = target.maxHeight;


    // if the target wants to stay within its parent, the outline should stay there too
    if (isc.isAn.Array(target.keepInParentRect)) {
        outline.keepInParentRect = target.keepInParentRect;
    } else if (target.keepInParentRect == true) {
        outline.keepInParentRect = target.getParentPageRect();
    } else {
        outline.keepInParentRect = null;
    }

    return outline;
},

//> @classMethod EventHandler.getDragRect()
// During a drag with +link{canvas.dragAppearance,dragAppearance} of either "target" or
// "outline", returns the page-relative coordinates of whatever element is being dragged.
// <P>
// Calling this method allows you to write drag and drop logic that works identically even if
// <code>dragAppearance</code> is subsequently changed.
//
// @return (Rect) global (page-relative) coordinates and size of the dragged element, as a
//                       4-element array [left,top,width,height], or null if not dragging
// @group dragdrop
// @visibility external
//<
getDragRect : function () {
    
    var target = this.dragMoveTarget || this.dragTarget;
    if (!target) return null;
    return target.getPageRect();
},



// move whatever component is intended to be moving during the drag (tracker, outline,
// dragTarget itself) 
_moveDragMoveTarget : function () {
    //!DONTCOMBINE

    var EH = this;

    var target = EH.dragMoveTarget;
    if (!target) return true;

    
    //>Moz1.4
    var stayInParent = (isc.Browser.isMoz && isc.Browser.geckoVersion < 20031007 &&
                        !target.keepInParentRect);

    if (stayInParent &&
        (target.parentElement && 
         !target.parentElement.containsPoint(EH.lastEvent.x,EH.lastEvent.y)))
    {
        return true;
    }
    //<Moz1.4

	// move the dragMoveTarget to the event
    isc._useBoxShortcut = true;
    EH.dragMoveTarget.moveToEvent(EH.dragOffsetX, EH.dragOffsetY);
    isc._useBoxShortcut = false;
        
	return true;
},

// Routine to move the object that's being moved via the dragMove mechanism.
_resizeDragMoveTarget : function () {
    //!DONTCOMBINE
    var EH = this;
	// move the dragMoveTarget to the event
	if (EH.dragMoveTarget) EH.dragMoveTarget.resizeToEvent(EH.resizeEdge);
	return true;
},

// Kill the current native event
killEvent : function () {
    isc.EH.getWindow().event.cancelBubble = true;

    return false;
},

// Return the value that will stop event bubbling

stopBubbling : function () {
	return isc.EH.STOP_BUBBLING;
},

// Start a timer to fire the synthetic 'idle' event after a short delay.  This should never
// need to be called directly - call Page.setEvent('idle', action) instead.
_$handleIdle:"_handleIdle",
startIdleTimer : function () {
    // idle shouldn't fire until after page load, and the idle timer is kicked off at page
    // load, no use setting timers in between
    if (!isc.Page.isLoaded()) return;

    // start the timer if we don't already have one running
    if (!this.idleTimer) {
        this.idleTimer = isc.Timer.setTimeout({target:isc.EH, methodName:this._$handleIdle}, 
                                              this.IDLE_DELAY);
    }
},

// Call registered actions for the idle event.
_handleIdle : function () {
    // allow a new timer to be set (note: code triggered from idle frequently sets further idle
    // events, so this needs to happen first)
	this.idleTimer = null;

	// handle the page-level idle stuff, as normal
	var result = isc.Page.handleEvent(null,this.IDLE);

	// if there are any remaining actions for the idle event, start the timer again
	if (isc.Page.actionsArePendingForEvent(this.IDLE)) this.startIdleTimer();
	return result;
},

_threadCounter : 0,
_setThread : function (threadCode) {
    // use a rotating counter to distinguish things like successive mouseMoves
    this._thread = threadCode + this._threadCounter++;
    if (this._threadCounter > 9) this._threadCounter = 0;
},
_clearThread : function () { 
    if (this._threadExitActions != null) this.runTeas();
    this._thread = null; 
},


_setThreadExitAction : function (action) {
    isc.Timer.setTimeout(action, 0);
    var actions = this._threadExitActions;
    if (actions == null) actions = this._threadExitActions = [];
    actions.add(action);
},


runTeas : function () {
    //!OBFUSCATEOK
    this._thread += "[E]";
    while (this._threadExitActions != null) {
        var actions = this._threadExitActions;
        this._threadExitActions = null;

        if (this.logIsDebugEnabled()) {
            this.logDebug("firing threadExitActions: " + this.echoAll(actions));
        }

        for (var i = 0; i < actions.length; i++) {
            var action = actions[i];
            if (isc.isA.String(action)) isc.eval(action);
            else action();
        }
    }
},

_threadCodes : {
    load : "LOD",
    mousedown : "MDN",
    mouseup : "MUP",
    mousemove : "MMV",
    mouseout : "MOU",
    contextmenu : "CXT",
    keypress : "KPR",
    keydown : "KDN",
    keyup : "KUP",
    resize : "RSZ"
},


_$nativeEvents:"nativeEvents",

dispatch : function (handler, event) {
    
    
    
    if (isc._evalRunning != null) {
        delete isc._evalRunning;
    }
    
    if (isc.Browser.isIE) event = this.getWindow().event;

    
    this._setThread(this._threadCodes[event.type] || event.type); 
    
    

    
    if (!isc.Browser.isMoz) {
        var result = handler.call(this, event);
    } else {
        //var start = isc.timeStamp();
        try {
            var result = handler.call(this, event);
        } catch (e) {
            isc.Log._reportJSError(e);
            
            throw e;;
        }
        //var end = isc.timeStamp();
        //if ((end-start) > 2) {
        //    this.logWarn("dispatch for " + event.type + " took " + (end-start) + "ms");
        //}
    }

    this._clearThread();
    
    if (result != false && this._replacedEvents[event.type]) {
        var baseResult = this._replacedEvents[event.type](event);
        if (baseResult == false) result = false;
    }
    
    return result;
},

// assign the handler
_$event: "event",



_$funcBody : (isc.Browser.isMoz ? "if(event.getPreventDefault&&event.getPreventDefault())return;" : 
              isc.Browser.isSafari ? "if(event.returnValue==false)return;" : "")
    
    + "var returnVal=argu"+"ments.callee._window.isc.EH.dispatch(argu"+"ments.callee._handler,event);"
    + (!isc.Browser.isIE && isc.Browser.isDOM ? 
    "if(returnVal==false)event.preventDefault();else if(returnVal==isc.EH.STOP_BUBBLING)event.stopPropogation();"
       : "")
    + "return returnVal;"
,
_replacedEvents: {},
_nativeEventName_TypeMap:{
    onmousedown:"mousedown",onmouseup:"mouseup",onclick:"click",ondblclick:"dblclick",
        oncontextmenu:"contextmenu",onmousewheel:"mousewheel",
    onmouseover:"mouseover",onmouseout:"mouseout",onmousemove:"mousemove", 
    onresize:"resize", onload:"load",onunload:"unload",
    onselecttext:"selecttext",onselectionchanged:"selectionchanged",
    onkeydown:"keydown",onkeyup:"keyup",onkeypress:"keypress"
},
captureEvent : function (object, nativeEventName, eventName, handler) {

    var wd = this.getWindow(),
        useEventListeners = this._useEventListeners;
    
    //var indirect = new Function(this._$event, this._$funcBody); 
    var indirect = isc._makeFunction(this._$event, this._$funcBody); 
    indirect._window = wd;
    indirect._handler = handler;
    //this.logWarn("indirect created: " + indirect.toString());
    
    if (!useEventListeners) {
        // If there's a handler on the document object already, fire it synthetically from
        // our handler, so we don't clobber functionality from other JS loaded before us.
        
        if (object[nativeEventName] != null) {
            var nativeEventType = this._nativeEventName_TypeMap[nativeEventName] || nativeEventName.substring(2);
            this._replacedEvents[nativeEventType] = object[nativeEventName];
        }
        
        object[nativeEventName] = indirect;

    //    Using addEventListener / attachEvent rather than assigning directly to
    //    document.onXXX:
    // By default we assign handlers directly to document.onXXX [or window.onXXX].
    // This means that we overwrite any previously defined handlers, and if code executed
    // after the framework loads could also clobber us.
    // We overrwrite pre-existant handlers 'politely' - that is we fire our handler, then, if
    // we didn't return false, fire the pre existant handler with the correct parameters and
    // return the appropriate return value.
    // However this doesn't give us any protection against later code overwriting our onXXX
    // handlers.
    // By contrast we could use "eventListeners", created by document.addEventListener() [or
    // proprietary "attachEvent" in IE]. Events can support multiple listeners, and they
    // can't be clobbered by overwriting document.onXXX.
    // We activate this via the isc_useEventListeners flag.
    // ----
    // Problem with attachEvent/addEventListener as an interop strategy: when a handler
    // cancels an event, the other registered handlers fire anyway.
    //
    // IE: If we are using 'attachEvent' the raw 'onXXX'handler will fire before the 
    // eventListener, and we have no way of knowing whether the handler canceled the event, as
    // event.returnVal is always reported as undefined (even if it has been explicitly set to 
    // false).
    // Hence frameworks have no way of signalling to each other that they have completely 
    // handled an event, and problems like doubled context menus might result.
    //
    // Moz: If we are using 'addEventListener', we have the option of firing before or after the 
    // native onXXX handler fires - this is governed by the third parameter passed to 'attachEvent'. 
    // If we fire first we can call preventDefault() to cancel native behavior but this will not 
    // stop a handler assigned to document.onXXX from firing.
    // A method 'getPreventDefault()' exists on the event object which allows the later handler
    // to detect a previous cancellation so we would be relying on some other library checking 
    // the presence of this flag.
    // Alternatively, if we fire after some other framework's handler, we can check for that 
    // handler having cancelled the native event. The only drawback in this case is that since 
    // our logic fires later we're essentially giving precidence to the other library's handler 
    // - if they show a context menu and kill the event we will not show ours, etc.
    //
    // Safari: Behaves like Moz, with the exception that while event.getPreventDefault() is not
    // available on the event object, you CAN check event.returnValue == false for a previous
    // cancellation.
    //
    // - By default we use "Polite clobbering of the direct handler function" - if a direct 
    // handler was defined before our library loads, we retain the handler, then when the
    // event occurs, we fire our logic first, and if we did not cancel the event, fire the 
    // original handler and propogate its return value back to the browser.
    // This generally achieves interop assuming the SmartClient framework is loaded after
    // any other frameworks on the page.
    // - if ISC can't be loaded last, or the direct handler gets clobbered after loading,
    // the developer can flip on 'isc_useEventListeners' for the application and hope for the
    // best in terms of doubled events (most likely only a problem in IE).
    // --
    // Order of firing:
    // - order (tested with oncontextmenu)
    //   - IE (6 and 7): window.onXXX first, then listeners in what appears to be random order
    //                   [tested with 4 "attachEvent()" calls in addition to setting 
    //                    document.onXXX]
    //   - Moz (1.5.0.3): - with 3rd 'useCapture' param passed to attachEvent():
    //                      listeners first registered -> last registered, then window.onXXX 
    //                    - with 'useCapture' false:
    //                      window.onXXX then listeners first registered -> lastRegistered
    //   - Safari (2.0.3): As with Moz 
    //
    // W3c spec for event listeners: http://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-EventListener 
    } else {        
    
        if (isc.Browser.isIE) {
            object.attachEvent(nativeEventName, indirect);
        } else if (isc.Browser.isDOM) {
            var nativeEventType = this._nativeEventName_TypeMap[nativeEventName] || 
                                  nativeEventName.substring(2);    
            object.addEventListener(nativeEventType, indirect, false);
    
        
        } else {
            this.logWarn("Unable to use event listeners in this browser");
            this._useEventListeners = false;
            return this.captureEvent(object, nativeEventName, eventName, handler);
        }
    }
},

// Set the page up to capture events that we care about.  
// Called automatically right below its definition.
captureEvents : function (wd) {
    var EH = this;
	
    // Convert the public flag to use event listeners rather than directly specifying
    // handlers at the docment level to an internal flag
    if (window.isc_useEventListeners != null) EH._useEventListeners = window.isc_useEventListeners;
    
    
    var reverseEventTypes = isc.makeReverseMap(EH.eventTypes);
    isc.addProperties(EH, {reverseEventTypes:reverseEventTypes});

	if (wd == null) wd = this.getWindow();
	var document = wd.document;
    
	// add a 'load' handler to set up the Page.isLoaded parameter
	isc.Page.setEvent(EH.LOAD, isc.Page.finishedLoading);

    // DOM standard addEventListener and IE's proprietary attachEvent are mechanisms for doing
    // "event listening" - getting notified of events without assigning a function directly to a DOM
    // element.
    // We support both approaches in captureEvent() - switchable via the isc_useEventListeners
    // flag. 
    // See comments in EH.captureEvent() for more on this.
    // Since the "load" event can't be cancelled, and since ISC is hosed if it never gets "load"
    // (eg, nothing responds to events, various actions will be indefinitely postponed), we're using
    // event listening for "load" even if the flag is set to false. 
    // Note:
    //   - IE & Moz: only window.onload fires, not document or document.body onload
    //   - Safari: document, body, and window.onload all fire
    if (isc.Browser.isIE) {
        wd.attachEvent("onload", EH.handleLoad);
    // HACK: Opera: addEventListener for load fires load way too early, during ISC module load,
    // not clear why yet.
    } else if (isc.Browser.isDOM && !isc.Browser.isOpera) {
        wd.addEventListener("load", EH.handleLoad, true);
    } else {
        this.captureEvent(wd, "onload", EH.LOAD, EH.handleLoad);
    }

    
    if (!this._useEventListenerForUnload()) {
        this.captureEvent(wd, "onunload", EH.UNLOAD, EH.handleUnload);
    }

    this.captureEvent(wd, "onresize", EH.RESIZE, EH.handleResize);

    // { iscEventName : [DOMObject, nativeName, EHFunction], .. }

    this.captureEvent(document, "onmousedown", EH.MOUSE_DOWN, EH.handleMouseDown);
    this.captureEvent(document, "onmousemove", EH.MOUSE_MOVE, EH.handleMouseMove);
    this.captureEvent(document, "onmouseup", EH.MOUSE_UP, EH.handleMouseUp);

    this.captureEvent(document, "onclick", EH.CLICK, EH.handleNativeClick);
    this.captureEvent(document, "ondblclick", EH.DOUBLE_CLICK, EH.handleNativeClick);

    
    this.captureEvent(document, "onscroll", "scroll", EH.handleScroll);
     
    // In IE6 we can capture the mousewheel event
    this.captureEvent(document, "onmousewheel", EH.MOUSE_WHEEL, EH.handleMouseWheel);
    
    // In Moz we also get events on mouse-wheel, but we have to capture them differently.
    if (isc.Browser.isMoz) {
        wd.addEventListener("DOMMouseScroll", EH.handleDOMMouseScroll, true);
    }
    

	// for all Canvii, we synthesize mouseOver/mouseOut by detecting that the target Canvas
    // changed.  However, we care about native mouseOut events in the case that the mouse
    // leaves the browser entirely.
    //this.captureEvent(document, "onmouseover", EH.MOUSE_OVER, EH.killEvent);
    this.captureEvent(document, "onmouseout", EH.MOUSE_OUT, EH.handleNativeMouseOut);

	// get the contextMenu trigger
    this.captureEvent(document, "oncontextmenu", EH.SHOW_CONTEXT_MENU, EH.handleContextMenu);

	// suppress the onselectstart event in a special way
	//	so we can still operate in form fields
    this.captureEvent(document, "onselectstart", EH.SELECT_START, EH.handleSelectStart);
    this.captureEvent(wd, "onselectstart", EH.SELECT_START, EH.handleSelectStart);

    
    if (isc.Browser.isIE) {

        
        this.captureEvent(document, "onselectionchange", 
                          EH.SELECTION_CHANGE, EH.handleSelectionChange);

                   
    }
    
    if (wd.isc_captureKeyEvents != false) {
        
        this.captureEvent(document, "onkeydown", EH.KEY_DOWN, EH._handleNativeKeyDown);
        this.captureEvent(document, "onkeypress", EH.KEY_PRESS, EH._handleNativeKeyPress);
        this.captureEvent(document, "onkeyup", EH.KEY_UP, EH._handleNativeKeyUp);
	}
	
	// for IE only, capture the 'ondragstart' event
	if (isc.Browser.isIE) {
        this._windowDragStart = wd.ondragstart;
        this._documentDragStart = document.ondragstart;
        document.ondragstart = wd.ondragstart = EH.handleNativeDragStart;
	}
},


_useEventListenerForUnload : function () {
    return (isc.Browser.isSafari && isc.Browser.safariVersion <= 412);
},


////////////////
// Cross-browser event property API
////////////////

//>	@classMethod	isc.EventHandler.getLastEvent()
//			Return the last event that was seen.
//
//		@group	mouseEvents
//		@return	(SCEvent) last event
//  @visibility eventhandler
//<
getLastEvent : function () {
	return this.lastEvent;
},

//>	@classMethod	isc.EventHandler.getEventType()
// Get the type of the event
//
//		@group	mouseEvents
//		@param	[event]	(SC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
//		@return			(number)	event type 
//  @visibility eventhandler
//<
getEventType : function (event) {
	return (event || this.lastEvent).eventType;
},


//>	@classMethod	isc.EventHandler.getTarget()
// Return the canvas that is the target of the mouse event.
// Returns null if no canvas found.
//
// @group mouseEvents
// @return (Canvas)	event target canvas
// @visibility external
//<
//		@param	[event]	(SC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
getTarget : function (event) {
	return (event || this.lastEvent).target;
},


//>	@classMethod	isc.EventHandler.getDragTarget() (A)
//
// Returns the current dragTarget.  This is the component on which the drag and drop
// interaction was initiated.  This only returns something meaningful during a drag and drop
// interaction.
//
// @group	mouseEvents
//
// @return			(Canvas)   The dragTarget.
//
// @see canvas.dragTarget
// @visibility external
//<
getDragTarget : function () {
    return this.dragTarget;
},


//>	@classMethod	isc.EventHandler.getX()
//			Return the page-relative X (horizontal) coordinate of an event.
//
//		@group	mouseEvents
//		@return			(number)	x-coordinate in page coordinate space
//  @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
getX : function (event) {
	return (event || this.lastEvent).x;
},

//>	@classMethod	isc.EventHandler.getY()
//			Return the page-relative Y (vertical) coordinate of an event.
//
//		@group	mouseEvents
//		@return			(number)	y-coordinate in page coordinate space
//  @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
getY : function (event) {
	return (event || this.lastEvent).y;
},


//>	@classMethod	isc.EventHandler.getScreenX()
//			Return the screen-relative X (horizontal) coordinate of an event.
//
//		@group	mouseEvents
//		@param	[event]	(SC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
//		@return			(number)	x-coordinate in screen coordinate space
//  @visibility eventhandler
//<
getScreenX : function (event) {
	return (event || this.lastEvent).screenX;
},

//>	@classMethod	isc.EventHandler.getScreenY()
//			Return the screen-relative Y (vertical) coordinate of an event.
//
//		@group	mouseEvents
//		@param	[event]	(SC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.
//		@return			(number)	y-coordinate in screen coordinate space
//  @visibility eventhandler
//<
getScreenY : function (event) {
	return (event || this.lastEvent).screenY;
},


//>	@classMethod	isc.EventHandler.mouseIsDown()
//		Is the mouse button currently down?
//		@return	(boolean)	true == mouse is currently down
//		@group	mouseEvents
//  @visibility eventhandler
//<
mouseIsDown : function () {
	return (this._mouseIsDown);
},

//>	@classMethod	isc.EventHandler.mouseDownTarget
//		Get the target of the last mouseDown event. May be null if the target has subsequently
//      been destroyed.
//		@return	(Canvas)	Canvas that got the mouseDown event, or null if not on a canvas
//		@group	mouseEvents
//<
mouseDownTarget : function () {
	return (this.mouseDownEvent ? this.mouseDownEvent.target : null);
},


//>	@classMethod	isc.EventHandler.getButtonNum()	(A)
//			Return the number of the button that was pressed:
//				1 == left mouse button (primary)
//				2 == right mouse button (secondary)
//			Tertiary mouse button is not supported as it not commonly found.
//
//		@group	mouseEvents
//		@param	event	(DOM event) DOM event object (as passed by isc.EventHandler)
//		@return			(number)	number of the mouse button	
//  @visibility internal
//<
// which mouse button was pressed?  primary=1, secondary=2	(that's all we support)

getButtonNum : function (event) {
	return (event || this.lastEvent).buttonNum;
},

//>	@classMethod	isc.EventHandler.leftButtonDown()
//			Returns true if the left mouse button is being pressed.
//
//		@platformNotes	Mac:
//		Macintosh platform generally has only one mouse button - ISC considers it to be the "left"
//		mouse button, so this method will return true if the mouse is down on a single-button mouse Mac.
//
//		@group	mouseEvents
//		@return			(boolean)	true == left button is down, false == up	
//      @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  Default is to use isc.EventHandler.lastEvent.
leftButtonDown : function (event) {
	return ((event || this.lastEvent).buttonNum == 1);
},

//>	@classMethod	isc.EventHandler.rightButtonDown()
//			Returns true if the right mouse button is being pressed.
//
//		@platformNotes	Mac:
//		Macintosh platform generally has only one mouse button, and the
//		control key being held down serves the same purpose of the 
//		right mouse button on Windows.  This is taken into account automatically.<br>
//      Opera: 
//      The Opera browser does not pass right mouse button events to JavaScript code by default
//      (the user must explictly enable this bahavior via a menu item). Therefore we 
//      treat <b>Shift+Ctrl+Click</b> as a context click in Opera.
//
//		@group	mouseEvents
//		@return			(boolean)	true == right button is down, false == up	
//      @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                  Default is to use isc.EventHandler.lastEvent.
rightButtonDown : function (event) {
	if (!event) event = this.lastEvent;
	return (event.buttonNum == 2) || 
           (isc.Browser.isMac && event.ctrlKey) || 
           // Notes:
           // We use shift+ctrl+click because
           // - ctrl + click has native meaning - shows a save-as dialog if it occurs over
           //   an image
           // - alt + click has meaning - it puts focus onto the native browser menus
           // we're unable to suppress either of these
           (isc.Browser.isOpera && (event.ctrlKey && event.shiftKey)) || 
           // Note, for Safari, we get no event on ctrl+click nor on right button click
           // so if the altKey is down, we'll assume treat this as a context click
           ((isc.Browser.isSafari && (isc.Browser.safariVersion < 125)) && event.altKey);

},

// In Nav, early Safari, and current Opera, we don't get real context menu events, so we 
// have to synthesize them in response to mouseDown / mouseUp events.
useSyntheticRightButtonEvents : function () {
    return isc.Browser.isOpera || (isc.Browser.isSafari && (isc.Browser.safariVersion < 125));
},

// Which key was pressed (for keyboard events)

//>	@classMethod	isc.EventHandler.getKeyEventCharacterValue()
//          Returns the numeric characterValue reported by the browser.
//          Only available on keyPress events, and only for character (or ascii control) keys
//
//		@group	keyboardEvents
//		@param	[event]	(SC Event)  Event to get character value for.
//                                  Default is to use isc.EventHandler.lastEvent.
//		@return			(number)	ASCII number for the key pressed	
//  @visibility eventhandler
//<
getKeyEventCharacterValue : function (event) {
	return (event || this.lastEvent).characterValue;
},

//>	@classMethod	isc.EventHandler.getKeyEventCharacter()
//			Return the character for the current key being pressed.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@param	[event]	(SC Event)  Event to return character from.
//                                  Default is to use isc.EventHandler.lastEvent.
//		@return			(char)		Key character
//      @visibility eventhandler
//<
getKeyEventCharacter : function (event) {
	return String.fromCharCode(this.getKeyEventCharacterValue(event));
},

//>	@classMethod	isc.EventHandler.getKey()
//			Return the name of the key for the event passed in.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@return			(KeyName)		Key Name
//      @visibility external
//<
//		@param	[event]	(SC Event)  Event to return keyName for
//                                  Default is to use isc.EventHandler.lastEvent.
getKey : function (event) {
    return (event || this.lastEvent).keyName;
},

// Add getKeyName() as a synonym of getKey() since we refer to the property as event.keyName
getKeyName : function (event) {
    return this.getKey(event);
},

//>	@classMethod	isc.EventHandler.shiftKeyDown()
//			Return true if the shift key is being held down.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@return			(boolean)	true == shift key is down	
//      @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                  Default is to use isc.EventHandler.lastEvent.
shiftKeyDown : function (event) {
	return (event || this.lastEvent).shiftKey;
},

//>	@classMethod	isc.EventHandler.ctrlKeyDown()
//			Return true if the control key is being held down.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@return			(boolean)	true == control key is down	
//      @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                  Default is to use isc.EventHandler.lastEvent.
ctrlKeyDown : function (event) {
	return (event || this.lastEvent).ctrlKey;
},

//>	@classMethod	isc.EventHandler.altKeyDown()
//			Return true if the alt (option) key is being held down.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@return			(boolean)	true == alt key is down
//      @visibility external
//<
//		@param	[event]	(ISC Event) Event from a call to getEventProperties().  
//                                  Default is to use isc.EventHandler.lastEvent
altKeyDown : function (event) {
	return (event || this.lastEvent).altKey;
},


//>	@classMethod	isc.EventHandler.metaKeyDown()
//			Return true if the meta (windows or apple) key is being held down.
//			Note that this is not supported in all versions of IE.
//			Note that this is only set reliably for keyboard events.
//
//		@group	keyboardEvents
//		@return			(boolean)	true == meta key is being held down	
//  @visibility internal
//<
//		@param	[event]	(SC Event) Event from a call to getEventProperties().  
//                                 Default is to use isc.EventHandler.lastEvent.

metaKeyDown : function (event) {
	return (event || this.lastEvent).metaKey;
},


//>	@classMethod	isc.EventHandler.getMouseEventProperties()
//		Record the characteristics of a mouse event in the object passed in.
//
//		Sets the following properties:
//			eventType		type of the event
//			nativeTarget	DOM element that was the target of the event
//			target			Canvas that was the target of the event (may be null)
//			x 				page-level X coordinate
//			y				page-level Y coordinate
//			screenX			X coordinate relative to the top corner of the screen.
//			screenY			Y coordinate relative to the top corner of the screen.
//			buttonNum 		Mouse button pressed.  <code>null</code> == mouse button not pressed.
//
//		Note: we don't try to make element-relative coordinates (offsetX/Y) available, since
//            the HTML element that catches the event may not be the HTML element that
//            represents the Canvas that will handle the event.  For example, the DOM-level
//            target could be a table cell, ultimately contained within a DIV which represents
//            a Canvas.
//
//            Use
//					canvas.getOffsetX(), canvas.getOffsetY()
//            to get the coordinates of the event relative to the Canvas which is regarded as
//            the receiver of the event within ISC.
//
//		@group	events
//		@param	e		(DOM event) DOM event object (as passed by isc.EventHandler)
//      @visibility internal
//<
getMouseEventProperties : (isc.Browser.isIE ?
	function (e) {
		var scEvent = this.lastEvent;
		if (!e) e = this.getWindow().event;
   
		scEvent.DOMevent = e;        
   
		scEvent.eventType = this._nativeMouseEventMap[e.type];

    	scEvent.y = parseInt(e.clientY) + this.ns.Page.getScrollTop();
		scEvent.x = parseInt(e.clientX);
                
        if (!isc.Page.isRTL()) {
		    scEvent.x += this.ns.Page.getScrollLeft();
        } else {
            var scrollLeft = this.ns.Page.getScrollLeft();
            if (scrollLeft > 0) {
                var maxScrollLeft = (this.ns.Page.getScrollWidth() - this.ns.Page.getWidth());
                scEvent.x -= (maxScrollLeft - scrollLeft);
            }
            
            scEvent.x -= 15;
        }

        scEvent.nativeTarget = e.srcElement;

        //this.logWarn(this.echoDOM(scEvent.nativeTarget));
		scEvent.target = this.getEventTargetCanvas(e, scEvent.nativeTarget);
        
        // Hang onto the wheelDelta - only defined for mouseWheel events
        
        var delta = e.wheelDelta;
        if (delta != null) scEvent.wheelDelta = - Math.round(delta / 120);
        else scEvent.wheelDelta = null;
        
        /*
		if (scEvent.eventType != this.MOUSE_MOVE) {
            this.logWarn("event: " + e.type + 
                         ", nativeTarget: " + this.echoLeaf(scEvent.nativeTarget) + 
                         ", ISC target: " + scEvent.target);
        }
        */

		scEvent.screenX = e.screenX;
		scEvent.screenY = e.screenY;
        
		scEvent.buttonNum = e.button;

        /*
        this.logWarn("event: " + this.echo({
            type : e.type,
            button : e.button,
            target : e.srcElement,
            clientX : e.clientX,
            clientY : e.clientY,
            screenX : e.screenX,
            screenY : e.screenY
        }));
        */

        // getKeyEventProperties (fired when a key goes down) should handle updating shiftKey
        // et al 
        // However if a native alert was fired in response to a key down event we don't get
        // the native keyUp, so will never clear these properties out. Avoid this by resetting
        // these properties on mouse events as well as key events.
		scEvent.shiftKey = (e.shiftKey == true);
		scEvent.ctrlKey = (e.ctrlKey == true);
		scEvent.altKey =  (e.altKey == true);
		scEvent.metaKey =  (e.metaKey == true);
		return scEvent;
	}
:   // isc.Browser.isDOM 
    function (e) {
        
        var scEvent = this.lastEvent;
        scEvent.DOMevent = e;
        scEvent.eventType = this._nativeMouseEventMap[e.type];              
        
        if (isc.Browser.isSafari) {
            // From Safari 3.0.3 to 3.0.4, the native event.x and y coordinates became relative
            // to the  top of the browser viewport rather than the page, so adjust for that.
            var adjustForPageScroll = isc.Browser.safariVersion >= 523.12
                
            scEvent.x = parseInt(e.x);
            scEvent.y = parseInt(e.y);
            
            if (adjustForPageScroll) {
                scEvent.x += isc.Page.getScrollLeft();
                scEvent.y += isc.Page.getScrollTop();
            }
            
            
           
            if (scEvent.eventType != this.MOUSE_WHEEL) {
                var adjustForPageScroll = true; 
                scEvent.x = parseInt(e.clientX) + (adjustForPageScroll ? isc.Page.getScrollLeft()
                                                                        : 0);
                scEvent.y = parseInt(e.clientY) + (adjustForPageScroll ? isc.Page.getScrollTop()
                                                                        : 0);
                                                                        
            }
            
        // This is the expected behavior:
        } else {
            
            if (scEvent.eventType != this.MOUSE_WHEEL) {
                var adjustForPageScroll = true; 
                scEvent.x = parseInt(e.clientX) + (adjustForPageScroll ? isc.Page.getScrollLeft()
                                                                        : 0);
                scEvent.y = parseInt(e.clientY) + (adjustForPageScroll ? isc.Page.getScrollTop()
                                                                        : 0);
            }
        }

        scEvent.nativeTarget = e.target;

        scEvent._stillWithin = null; // clear cached result of stillWithinMouseDownTarget

        scEvent.target = this.getEventTargetCanvas(e, scEvent.nativeTarget);
        
        scEvent.screenX = e.screenX;
        scEvent.screenY = e.screenY;
 
        
        if (scEvent.eventType == this.MOUSE_WHEEL) {
            
            var wheelDelta = e.wheelDelta,
                detail = e.detail;
            if (detail == 0 || detail == null && wheelDelta != null) {
                // This matches the logic for IE (above)
                scEvent.wheelDelta = - Math.round(wheelDelta / 120);
                if (!isc.isA.Number(scEvent.wheelDelta)) scEvent.wheelDelta = null;

            } else {
                if (isc.Canvas.useNativeWheelDelta && e.detail == e.SCROLL_PAGE_UP) {
                    scEvent.wheelDelta = -Math.floor(
                        scEvent.target.height/isc.Canvas.scrollWheelDelta);
                } else if (isc.Canvas.useNativeWheelDelta && e.detail == e.SCROLL_PAGE_DOWN) {
                    scEvent.wheelDelta =  Math.floor(
                        scEvent.target.height/isc.Canvas.scrollWheelDelta);
                } else {                
                    // delta is a fraction, so that wheelDelta==1 when e.detail=3, but
                    // wheelDelta=0.333 when e.detail==1. This matches the earlier behavior
                    // for 3-line scrolling.
                    var delta = e.detail/3;
                    if (!isc.isA.Number(delta)) delta = 0;
                    if (delta > 15 || delta < -15) delta = (delta > 0 ? 1 : -1);
                    scEvent.wheelDelta = delta;
                }
            }
        } else {
            scEvent.wheelDelta = null;
        }

        
		if (scEvent.eventType == isc.EH.MOUSE_MOVE) {
			// clear the button if the mouse is not down
			if (!this._mouseIsDown) scEvent.buttonNum = 0;
		} else {
            
			scEvent.buttonNum = ((e.which == 1 || isc.Browser.isSafari && e.which == 65536) 
                                                    ? 1 : 2);
		}
        //this.logWarn("event: " + e.type + " which: " + e.which + " e.button: " + e.button);
        //scEvent.nativeWhich = e.which;

        
		scEvent.shiftKey = (e.shiftKey == true);
		scEvent.ctrlKey = (e.ctrlKey == true);
		scEvent.altKey = (e.altKey == true);
		scEvent.metaKey = (e.metaKey == true);

        /*
        this.logWarn("event: " + this.echo({
            type : e.type,
            button : scEvent.buttonNum,
            target : e.target,
            clientX : e.clientX,
            clientY : e.clientY,
            screenX : e.screenX,
            screenY : e.screenY
        }));
        */

		//this.logWarn("event: " + e.type + "\r\n" + this.echoEvent(e));
        return scEvent;
    }
),

//>	@classMethod	isc.EventHandler.getKeyEventProperties()
//		Record the characteristics of a keyboard event
//
//		Sets the following properties on isc.EventHandler.lastEvent:
//			nativeKeyTarget	DOM element that was the target of the event
//          keyTarget       Target Canvas for the key event - matches the item that currently
//                          has focus
//			keyName			Name of the key pressed. (available on keyDown, keyUp and keyPress)
//          characterValue  Numeric character value reported by the key event.  Only recorded
//                          for keypress events - may be null or zero for non-character keys.
//
//			shiftKey		Shift key is currently down.  
//			ctrlKey			Control key is currently down.
//			altKey			Alt key is currently down.  
//			metaKey 		Meta key is currently down. 
//								Note: meta-key seems to not work on most platforms
//          eventType       Type of the event (keyDown, keyPress, etc.)
//
//		@group	events
//		@param	e		(DOM event) DOM event object (as passed by isc.EventHandler)
//  @visibility internal
//<

getKeyEventProperties : function (e) {

    if (e == null) e = this.getWindow().event;
        
    var scEvent = this.lastEvent;
    
    
    scEvent.nativeKeyTarget = (e.target || e.srcElement);
    scEvent.keyTarget = this._focusCanvas;     
    if (isc.isA && isc.DynamicForm && isc.isA.DynamicForm(this._focusCanvas)) {
        var itemInfo = isc.DynamicForm._getItemInfoFromElement(scEvent.nativeKeyTarget, 
                                                               scEvent.keyTarget);        
        if (itemInfo && itemInfo.item) scEvent.keyTarget = itemInfo.item;
    }

    scEvent.eventType = this.getKeyEventType(e.type);    

    //this.logWarn("getKeyEventProperties() - eventType " + scEvent.eventType +
    //              ", native key event target: " + scEvent.nativeKeyTarget +
    //              ", ISC calculated target: " + scEvent.keyTarget);

    // for keypresses only, record the character code (may be null or zero - assume the
    // developer knows what he's doing with this code)
    if (scEvent.eventType == this.KEY_PRESS) {
        scEvent.characterValue = this._determineKeyEventCharacterValue(e);
    }
    
    var keyName = this.determineEventKeyName(e);
    if (keyName != null) {
        scEvent.keyName = keyName;
    
    } else if (scEvent.eventType != isc.EH.keyPress) delete scEvent.keyName;

    

    
    scEvent.nativeKeyCode = e.keyCode;

    
	scEvent.shiftKey = (e.shiftKey == true || (isc.Browser.isMoz && scEvent.shiftKey));
    scEvent.ctrlKey = (e.ctrlKey == true);
	scEvent.altKey = (e.altKey == true);
	scEvent.metaKey = (e.metaKey == true);
},



getKeyEventType : function (nativeType) {
    if (!nativeType) return;
    return this._nativeKeyEventMap[nativeType];
},



// Return the charset value for the event.
// Note: returns null if we can't get a value, or if the value is zero (meaningless)
_determineKeyEventCharacterValue : function (DOMevent) {
    
     if (isc.Browser.isIE) return (DOMevent.keyCode || null);
     if (isc.Browser.isMoz) {
        return (DOMevent.which || null);
     }
     return (DOMevent.which || DOMevent.keyCode || null);
},

determineEventKeyName : function(DOMevent) {
    if (DOMevent == null) return;
    var keyCode = DOMevent.keyCode,
        which = DOMevent.which,
        EH = isc.EH,
        type = EH.getKeyEventType(DOMevent.type);
        
    //this.logWarn("determineEventKeyName(): key properties to determine event: " +
    //             "keyCode:" + keyCode + 
    //             ", which:" + which + ", type:" + type);

    
    if (isc.Browser.isIE) {
        
        if (type == EH.KEY_DOWN || type == EH.KEY_UP) {
            return EH._virtualKeyMap[keyCode] 
        }
        
        
        if (type == EH.KEY_PRESS) {
            // If we have the keyDown key name, just make use of it        
            if (EH._keyDownKeyName != null) return EH._keyDownKeyName;

            var name = EH._charsetValueToKeyNameMap[keyCode];
            
            if (!name && this.getWindow().event.ctrlKey) {
                name = isc.EH._getKeyNameFromCtrlCharValue(keyCode);
            }
            return name;

        }
        
    
    } else if (isc.Browser.isMoz) {
        
        if (type == EH.KEY_DOWN || type == EH.KEY_UP) {
            return EH._virtualKeyMap[keyCode];

        } else if (type == EH.KEY_PRESS) {
        
            if (which == 0 && keyCode != 0) return EH._virtualKeyMap[keyCode];

            // If we have the keyDown key name, just make use of it        
            if (EH._keyDownKeyName != null) return EH._keyDownKeyName;        
            
            
            if (keyCode == 0) {
                return EH._charsetValueToKeyNameMap[which];

            
            } else {
                return EH._virtualKeyMap[which];
            }

        }

    
    } else if (isc.Browser.isSafari) {
        if (type == EH.KEY_DOWN || type == EH.KEY_UP) {
            return EH._virtualKeyMap[keyCode];
        }
        
        var code = (which != null ? which : keyCode);
        if (code != null && code != 0) {        
            
            if (this.getWindow().event.ctrlKey) {
                return (isc.EH._charsetValueToKeyNameMap[code] || isc.EH._getKeyNameFromCtrlCharValue(code));
            }

            
            var keyName = isc.EH._charsetValueToKeyNameMap[code];
            
            if (keyName == null) keyName = isc.EH._safariSpecialKeyPressMap[code]

            return keyName;            
            
        // Note: we are aware of a bug where keypress events on arrow keys give a keyCode of zero
        // in Safari. Return null here without logging a warning (below) 
        // - we have logic in the calling code to pick up the key name from the key-down 
        // event instead, so this is both known and worked around.
        } else if (type == this.KEY_PRESS) {
            return null;
        }
        
        

    
    } else {

        var code = which;
        
        // If which is null or zero, use keyCode (if it's not null or zero)
        if (code == null || (code == 0 && keyCode)) code = keyCode
        
        if (code != null) return isc.EH._charsetValueToKeyNameMap[code];
    }

    // Should never get here
    isc.Log.logWarn("EventHandler.determineEventKeyName(): Unable to determine key for '" + 
                    DOMevent.type + "' event. Returning null");
    return null;

},


_getKeyNameFromCtrlCharValue : function (ctrlCharValue) {

    if (ctrlCharValue == 30) return "6";
    if (ctrlCharValue == 31) return "-";

    return String.fromCharCode(ctrlCharValue + 64);

},

clearKeyEventProperties : function () {
	var scEvent = this.lastEvent;
    delete scEvent.eventType;
	delete scEvent.nativeKeyTarget;
	delete scEvent.characterValue;
    delete scEvent.keyName;
	delete scEvent.shiftKey;
	delete scEvent.ctrlKey;
	delete scEvent.altKey;
	delete scEvent.metaKey;
    delete this._keyDownKeyName    
},


// Destroyed targets
// We hang onto pointers to canvii in various places. Ensure these get cleared up when a canvas is
// destroyed, so we don't leak memory
// (Note many of these would be cleared on subsequent events in any case)
canvasDestroyed : function (canvas) {
    
    // if any clickMasks are showing, remove canvas from all clickMask "unmasked" lists
    if (this.clickMaskUp()) isc.EH.maskTarget(canvas);
    
    // if canvas was registered to receive the resize event, clear the registration 
    
    if (canvas._resizeID) isc.Page.clearEvent(canvas._$resize, canvas._resizeID);
    
    
    if (this.mouseDownEvent && this.mouseDownEvent.target == canvas)
        this.mouseDownEvent.target = null;
    if (this.lastClickTarget == canvas) this.lastClickTarget = null;
    if (this.lastEvent.target == canvas) this.lastEvent.target = null;
    if (this.lastEvent.keyTarget == canvas) this.lastEvent.keyTarget = null;
    if (this._focusCanvas == canvas) this._focusCanvas = null;
    if (this._delayedFocusTarget == canvas) this._delayedFocusTarget = null;
},

// ClickMask
// ------------------------------------------------------------------------------------------------
//  Basic behavior:
//  - Suppress mouse events such as 'mouseOver' et. al on targets that are not marked as unmasked.
//    This is typically a visual indication to the user that the target is masked.
//  - Fire clickAction on mouseDown on masked target.
//  - mode:    
//      o If "soft", hide the click mask on mouseDown on masked target, and allow the mouseDown
//        event to proceed.  [Use case: dismissing a pop up menu by clicking outside it]
//        * The mouseDown must be allowed to proceed as we don't want the click to be mysteriously
//          dropped in use cases like this one
//      o If "softCancel", dismiss the clickMask on mouseDown (as with a soft mask), but also 
//        cancel the mouseDown event if it occurred over a SmartClient widget.
//        [Use case: we use this in modal editing of ListGrids where stopOnerrors is true.
//         We can't use a true "hard" mask in this case because we wouldn't be able to have
//         the edit form items be unmasked without unmasking the whole grid and all it's 
//         ancestors].
//      o If "hard" prevent the mouseDown from reaching the intended target. (Also leave the click
//        mask in place, so future mouseDown's will fire the click action again).
//        [Use case: clicking outside a modal dialog box].
//       Hard masks: 
//       o Prevent interaction with native HTML written into masked widgets
//       o Disallow focus on masked targets via
//          - tabbing - (we do this by capturing tab keypresses)
//          - accessKey (removed from widget handle)
//          - programmatic - just remember the (attempted) focus target and re-focus when the
//            mask gets hidden
//  
//  Features:
//  - Layering / Stacking of multiple clickMasks.
//      Each call to showClickMask() returns a unique ID for the clickMask.
//      If showClickMask() is called multiple times, we create multiple stacked clickMask objects.
//      A click on a masked target will fire the click action of the topmost clickMask, and 
//      depending on the 'mode' property of the clickMask, fire the click action on the masks
//      underneath.
//      Clickmasks are hidden using hideClickMask(), which, if passed an ID parameter will hide only
//      the specified mask.
//      This nesting behavior is made necessary by use cases like the following:
//      - Date picker widgets are modal and dismissable - they show an soft clickMask which
//        whill hide the date-picker if the user clicks outside it.
//        They contain 'year' and 'month' menus, which are also modal and dismissable.  
//        If the user clicks outside the date-picker while it is showing it's year menu, both the
//        menu and the picker should be dismissed.
//        If the user clicks on the date-picker but outside the year menu (while it is visible),
//        the year menu should be dismissed and the date picker should recieve a click event.
//        Therefore we need intelligent nesting of soft CM's where the masks track their
//        'unmaskedTargets' and click actions independantly.
//      - Modal window widgets can contain any other widget.  If a modal widow is shown containing
//        a data-bound listViewer, when the listViewer performs a server-side fetch, a click mask
//        is shown for the modal window, and another one for the server side fetch.
//        When the server side fetch returns, we should hide only the click-mask shown by the fetch.
//        Therefore we also need intelligent stacking of hard CM's (and the ability to 
//        hide clickMasks shown from specific 'showClickMask()' calls)
//  - unmasked targets:
//      Targets can be marked as unmasked either when the clickMask is instantiated (as an optional
//      third parameter to showClickMask()) or via a call to canvas.unmask() (falls through to
//      EventHandler.addUnmaskedTargets()).
//      Deprecated: The Canvas 'bringToFront()' method automatically adds widgets to the 
//      unmaskedTargets list of the formost clickMask - deprecated as of build 5.5, but 
//      still works. Developers are encouraged to user unmask() instead.
//      Note that when a widget is 'unmasked' wrt a particular clickMask, it is effectively 
//      unmasked wrt any click masks underneath that one as well.
//      o If a "hard" clickMask is showing, we only support it having top-level
//        unmasked targets -- we can't support an unmasked child of a masked parent for
//        "hard" masks. [We DO support this for soft masks].
//        - the only known, cross-browser way to truly intercept all events, including events 
//          that might be received by handlers directly written into native elements, is to 
//          place a physical element ("screenspan") over the whole screen
//       - anything that is to be unmasked therefore has to be ready to have it's top-most 
//         element change zIndex to get above the screenspan, and this is generally not ok to 
//         for eg some widget nested deeply in a series of Layouts, since this might effectively 
//         cause a full-screen Layout to come to the front, occluding things that had been 
//         placed over it
//       - hard-unmasking a non-top-level widget comes about *only* for modal inline editing with
//         waitForSave *and* stopOnErrors set, which is a corner case where it would be acceptable 
//         to place limitations or require special coding to make masking work
//       - alternatives include:
//         o individually masking everything else on the screen (too slow)
//         o creating a top-level mask composed of 4 pieces with a rectangular opening for the
//          unmasked, non-top-level widget: complicated, especially if multiple widgets 
//          non-top-level widgets can become unmasked together, and they may move
//      o We never support an unmasked parent with a masked child widget.
//      o We always mask and unmask all peers (and descendants of peers) of a widget with 
//        the widget. Use cases include scrollbars, edges, shadows.
//
// Future enhancements:
//  - Component level clickMasks:
//      In Windows and other multiple-window desktop systems, a "clickMask" only extends to the
//      current Window.  For example if you open a menu within a window, other windows still respond
//      normally to mouseOver et al. 
//      At some point ISC may need to implement per-widget clickMasks as well.
// ------------------------------------------------------------------------------------------------



//> @type   clickMaskMode
// Passed as a parameter to +link{Canvas.showClickMask} to determine the masks behavior
// when clicked.
// @visibility external
// @group   clickMask
// @value   "hard"   When the mask recieves a click, it will fire its click action, 
//                  and cancel the event, leaving the clickMask up.
HARD:"hard",
// @value   "soft"   When the mask recieves a click, it will fire its click action, 
//                  then dismiss the clickMask and allow the event to proceed to its target.
SOFT:"soft",
//<


//>	@classMethod	EventHandler.showClickMask()	(A)
//
// The clickmask intercepts all mouse events for everything on the screen except a list of 
// "unmasked" targets.  
// It is used in 2 ways:<br>
//  - To allow things such as modal dialogs which prevent interactions with widgets outside 
//    themselves<br>
//  - To allow things such as menus which respond to clicks outside themselves (without preventing
//    the event).<br>
// When a mouseDown occurs anywhere on the screen outside of an unmasked target, the clickMask's 
// "clickAction" fires.  <br>
// If the mask is soft it will disappear at this time. The event will be cancelled in this case
// unless mode is explicitly set to "softCancel" in which case we return false to kill the event.
// If the mask is hard, the event will be cancelled.<br>
// <br>
// This method returns an identifier for this clickMask.  If showClickMask() is called while a
// clickMask is already up, the clickmasks will 'layer', with the most recently shown clickMask 
// recieving click events first, and if  the mask is soft, passing the click event down to the
// previously shown mask.
// The clickMask can be hidden with a call to EventHandler.hideClickMask(), which takes an optional
// clickMaskID parameter. (If this parameter is not passed, all clickMasks will be hidden).
//
// @group   clickMask
// @param   clickAction     (string | method)   action to fire when the clickMask is clicked
// @param   mode    (clickMaskMode)       
//      Should this mask be dismissed and allow events to proceed on outside click.
//      If passed <code>null</code> the mask will be drawn in <code>"hard"</code> mode.
// @param   unmaskedTargets (widget | Array of widgets)
//      Widget(s) to not be occluded by the clickMask. Note that if <code>mode</code> is 
//      <code>"hard"</code> only top level canvases (with no 
//      +link{Canvas.parentElement}) can be unmasked. If a canvas with a parentElement is passed 
//      in, all its ancestors will also be unmasked.<br>
//      Also note that when a widget is unmasked, all its children are also unmasked (for both 
//      <code>"soft"</code> and <code>"hard"</code> masks)
//      
// @return  (string)    Unique identifier for this clickMask.
// @see method:Canvas.showClickMask
//
// @visibility eventhandler
//<
_maskCount : 0,
clickMaskRegistry : [],
showClickMask : function (clickAction, mode, unmaskedTargets, maskID) {

    var autoHide;
    //>!BackCompat 2006.08.31 We used to take 'autoHide' rather than 'mode' as a parameter
    // for whether a clickMask should be hard or soft. 
    // If passed a boolean, just treat 'true' as soft, 'false' as hard.
    if (mode == true) {
        autoHide = true;
        mode = isc.EH.SOFT;
    } else if (mode == false || mode == null) {
        autoHide = false;
        mode = isc.EH.HARD;
    } else {
    //<!BackCompat
        // If mode is "soft" or "softCancel", autoHide is true
        autoHide = (mode != isc.EH.HARD);
    //>!BackCompat 2006.08.31
    }   //<!BackCompat

    if (unmaskedTargets == null) unmaskedTargets = [];
    else if (!isc.isAn.Array(unmaskedTargets)) unmaskedTargets = [unmaskedTargets]
    
    if (this.logIsInfoEnabled("clickMask")) {
        this.logInfo("showing click mask, action: " + clickAction +
                 (autoHide ? ", autoHide true " : ", autoHide false ") + 
                 (maskID ? ", ID: " + maskID : ""),
                 "clickMask");
    }
    var EH = this,
        registry = EH.clickMaskRegistry;

    // send mouse out the to the last mouse over target, so it doesn't get stuck in the "Over"
    // state while the clickMask is up, suppressing mouseMove/Over/Out
    // (Do this before the mask is up, otherwise this event won't be passed through to the 
    // last target!)
    if (EH.lastMoveTarget) EH.handleEvent(EH.lastMoveTarget, EH.MOUSE_OUT);
    delete EH.lastMoveTarget;

    // create a entry for this mask and add it to the registry
    
    var mask = {
        autoHide : autoHide,
        mode:mode,
        ID : (maskID != null ? maskID : "cm_" + EH._maskCount++),
        _unmaskedTargets : {}
        //,stackTrace:this.getStackTrace()
    };

    // Add the unmasked children to the mask object
    
    this._applyUnmaskedTargets(unmaskedTargets, mask);
    // remember what mask was on top before this one was created.
    var topMask = registry.last();
            
    registry.add(mask);
    
    // the click action will fire on mouseDown outside of the unmasked targets
	mask.clickAction = clickAction;
	
    // blur the Canvas that currently has focus and remember which one it was, for possible
    // restoration of focus on clickMask hide
    var focusCanvas = EH.getFocusCanvas();
    if (focusCanvas != null && !unmaskedTargets.contains(focusCanvas)) {
        focusCanvas.blur();
        this.setMaskedFocusCanvas(focusCanvas, mask);
    } else if (topMask != null) {
        this.setMaskedFocusCanvas(topMask._maskedFocusCanvas, mask);
    }
    var isHardMask = this.isHardMask(mask);
    
    // If this is a hard mask, we need to 
    // - pull all masked widgets out of the page level tab order
    // - If we're already showing a screenSpan, push masked top level elements behind it

    if (isHardMask) {
    
        var startTime = isc.timeStamp();
    
        // The canvii which will be hard-masked by this mask are basically all the canvii
        // down to the next visible hard clickMask.
        // If this is the only clickMask showing, or all the other masks are soft, this is
        // just all the canvii on the page other than our unmasked targets.
        
        var entireCanvasList;
        if (registry.length > 1) {
            var hasHardMaskBelow = false,
                otherMasks = [];
            // our position is registry.length-1, so start at registry.length -2
            for (var i = registry.length-2; i >=0; i--) {
                otherMasks.add(registry[i]);
                
                if (this.isHardMask(registry[i])) {
                    hasHardMaskBelow = true;
                    break;
                }
            }
            
            if (hasHardMaskBelow) {
                // the 'otherMasks' will list any masks below this one up to and including the
                // first hard mask - so their unmasked targets all need to get masked.
                for (var i = 0; i < otherMasks.length; i++) {
                    var newlyMasked = otherMasks[i]._unmaskedTargets;
                    if (newlyMasked) {
                        // pass in the flag to indicate that we're passing in an object
                        // rather than an array
                        // Also pass in the flag to indicate this is being called as part of showClickMask
                        this._hardMaskTargets(newlyMasked, unmaskedTargets, true, true);
                    }
                }
            // If no hard mask below, hard mask everything except our unmaskedTargets
            } else {
                entireCanvasList = true;
                this._hardMaskTargets(isc.Canvas._canvasList, unmaskedTargets, false, true);
            }
            
        // If no other mask showing, hard mask everything except our unmaskedTargets
        } else {
            entireCanvasList = true;
            this._hardMaskTargets(isc.Canvas._canvasList, unmaskedTargets, false, true);
        }
        
    }
    
    // If this is the first mask being shown, show the screenSpan if necessary
    
    if (this.maskNativeTargets) {

        if (topMask == null) {
            this.showScreenSpan(mask);

        // catch the case where the screenSpan is already showing and needs to be moved behind 
        // the top level unmasked target.
        } else if (isHardMask) {
            this._adjustSpanZIndex(mask._unmaskedTargets)
        }
    }

    // updateEventMasks()
    // Shows / Clears individual event masks over canvii if necessary
    this.updateEventMasks();
    
    return mask.ID;
},


// Canvas-level event masks and "soft" clickMasks:
// Some widgets contain HTML that will swallow mouse events
// (Flashlets / IFrames etc).
// If we are showing a hard mask ovr these widgets, they will now be covered by a screenSpan
// which will intercept the events before they get swallowed (ok).
// However if these widgets are "under" a soft mask, they would swallow clicks so we'd fail
// to dismiss the soft mask / fire the click mask action when the user clicked on the widget 
// in question.
// Handle this by showing widget level event masks for each registered maskable canvas
// that is covered by a soft mask (but not by a hard mask)
updateEventMasks : function () {
    var registry = this.clickMaskRegistry,
        topMask = registry ? registry[registry.length-1] : null;
    if (topMask && topMask.autoHide) {
        var softMaskedCanvii = {};
        isc.addProperties(softMaskedCanvii, topMask._unmaskedTargets);
        
        this.showEventMasks(false, softMaskedCanvii);
        
    // top mask is hard ==> no need for separate widget-level event masks
    // no masks are showing ==> clear any widget-level event masks
    } else {
        this.hideEventMasks();
    }
},



// Helper method to apply unmasked targets to a mask.
// Will not actually modify the widgets' handle.

_applyUnmaskedTargets : function (unmaskedTargets, mask) {
    
    // call the method to combine ancestors, descendants and peers of the targets into
    // the list.
    unmaskedTargets = this._getFullSetOfTargetsToUnmask(unmaskedTargets, mask);

    for (var i = 0; i < unmaskedTargets.length; i++) {
        if (unmaskedTargets[i] == null) continue;
        mask._unmaskedTargets[unmaskedTargets[i].getID()] = true;
    }
},


// When we unmask canvases wrt a clickMask, we must also unmask:
// - for hard masks, all ancestors of the canvii
// - all peers of the canvii
// - all descendants of the canvii
// Call this method to add these additional canvii into the list to be unmasked
// Directly effects the list passed in (and returns the modified list)
_getFullSetOfTargetsToUnmask : function (unmaskedTargets, mask) {

    
    if (!unmaskedTargets || unmaskedTargets.length == 0 || !mask) return unmaskedTargets;
    
    // If we're passed any IDs, convert to pointers to the widget
    for (var i = 0; i < unmaskedTargets.length; i++) 
        unmaskedTargets[i] = this._getCanvas(unmaskedTargets[i]);

    // If we are creating a hard mask, ensure that we include all ancestors of any unmaskedTargets
    // passed in.
    var alreadyUnmasked = mask._unmaskedTargets;
    if (!mask.autoHide && unmaskedTargets.length > 0) {
        var length = unmaskedTargets.length;
        for (var i = 0; i < length; i++) {
            var target = unmaskedTargets[i];
            if (target.topElement && !alreadyUnmasked[target.topElement.getID()] && 
                                     !unmaskedTargets.contains(target.topElement)) 
            {      
                this.logWarn(
                    "Attempting to unmask target canvas:" +
                     target.getID() + " with respect to a hard click mask. " +
                     "This is not a top level Canvas - all ancestors of "+
                     "this Canvas will also be unmasked.", "clickMask"
                );
                unmaskedTargets.add(target.topElement);
            }
        }
    }

    // also recursively mask any peers of the targets.
    // Use cases: scrollbars, shadows, edge-canvii, etc.
    // - Note this is only necessary for the highest level targets being masked, since
    //   peers are at the same level in widget hierachy, so get masked (along with other 
    //   descendants) when the higher level parent is masked
    this._combineTopPeersIntoList(unmaskedTargets);
    
    // this method will modify the unmaskedTargets to include all descendants recursively.
    this._combineDescendantsIntoList(unmaskedTargets);
    
    return unmaskedTargets;
},


// Helper methods for determining targets to mask/unmask - takes a list of widgets and 
// recursively adds children of each widget to the list
_combineDescendantsIntoList : function (list) {
    var originalLength = list.length;
    for (var i = 0; i < originalLength; i++) {
        if (list[i] == null) continue;
        this._addDescendantsToList(list[i], list);
    }
},

// - Called directly from maskTargets(), addPeersToList, and _combineDescendantsIntoList()
_addDescendantsToList : function (widget, list, recursive) {
    
    // On the first (non-recursive) call we know that the widget is already in the list.
    if (recursive && !list.contains(widget)) list.add(widget);
    if (widget.children) {
        for (var i = 0; i < widget.children.length; i++) {
            this._addDescendantsToList(widget.children[i], list, true);
        }
    }
},

// Helper methods for determining targets to mask/unmask - takes a list of widgets and 
// recursively adds peers (and descendents thereof) of the highest level widgets to the list
_combineTopPeersIntoList : function (list) {
    for (var i = 0, length = list.length; i < length; i++) {
        var t = list[i];
        if (t.parentElement && list.contains(t.parentElement)) continue;
        this._addPeersToList(list[i], list);
    }
},

// - Called directly from maskTargets() and _combineTopPeersIntoList()
_addPeersToList : function (widget, list, recursive) {
    if (recursive && !list.contains(widget)) list.add(widget);
    var peers = widget.peers;
    if (peers) {
        for (var i = 0; i < peers.length; i++) {
            this._addPeersToList(peers[i], list, true);
        }
    }
    
    // We also want to pick up descendants of peers.
    // (example might be a button with a floating label title)
    this._addDescendantsToList(widget, list);
},


// Given the ID of a click mask return a pointer to the mask object itself

_$ID:'ID',
getClickMask : function (ID) {
    var registry = this.clickMaskRegistry;
    if (isc.isAn.Object(ID)) {
        return registry.contains(ID) ? ID : null;
    }
    return registry.find(this._$ID, ID);
},

// is a specific click mask "hard" (IE should suppress events from passing through it) or "soft"
// (Should respond to clicks but not mask events).

isHardMask : function (mask) {
    if (!isc.isAn.Object(mask)) mask = this.getClickMask(mask);
    return mask == null ? false : (mask.mode == isc.EH.HARD);
},

getTopHardMask : function () {
    var registry = this.clickMaskRegistry;
    for (var i = registry.length -1; i >= 0; i--) {
        if (this.isHardMask(registry[i])) return registry[i];
    }
    return null;
},

// Given an array of widgets, ensure they are "hard masked".
// This means they are obscured by the screenSpan 
// [If we're in the process of showing a clickMask, this is handled by the calling method]
// Their accessKey is cleared, if necessary.
// no update to tabIndex is necessary
_hardMaskTargets : function (widgets, unmaskedTargets, targetsAsObject, fromShowClickMask) {
    if (!widgets) return;
    
    //this.logWarn("masking widgets: " + widgets + 
    //             ", unmaskedTargets is: " + this.echo(unmaskedTargets));

    // Allows us to pass in an 'unmaskedTargets' object on a mask which is a map like this:
    // {canvasName:true, canvasName:true, ...}
    if (targetsAsObject) {
        for (var canvasName in widgets) {
            var canvas = this._getCanvas(canvasName);

            this._hardMaskTarget(canvas, unmaskedTargets, fromShowClickMask);

        }
    } else {
        for (var i = 0; i < widgets.length; i++) {
            var canvas = this._getCanvas(widgets[i]);
    
            this._hardMaskTarget(canvas, unmaskedTargets, fromShowClickMask);
        }
    }

},

// Actually hard mask a target
_hardMaskTarget : function (canvas, unmaskedTargets, fromShowClickMask) {

    // handle the case where some member of the canvas list is not a valid canvas
    
    if (!isc.isA.Canvas(canvas) || canvas.destroyed) {
        isc.Log.logWarn(
            "showClickMask - attempting to remove invalid object :" +
             isc.Log.echo(canvas) +
            " from tab order",
            "clickMask"
        );
        return;
    }

    
    // Don't actually mask anything that's explicitly unmasked
    if (unmaskedTargets && unmaskedTargets[canvas.getID()]) return;


    
    if (canvas.isDrawn()) {
            
        // we just need to ensure that the top-parent of the masked canvii is behind the span
        // Note: we are guaranteed to have the top-parent in the unmasked canvii already, so skip
        // any non top level widgets
        if (canvas.parentElement == null) {
            // Widgets to show behind the screenspan - 2 possibilities:
            // - the mask is in the process of being shown:
            //  o If this is the only mask up, we haven't yet created the screenSpan, but when 
            //    we do we'll position it over all top level masked widgets 
            //  o If the span is already showing due to another mask below us, we'll adjust the
            //    zIndex at the end of the showClickMask method
            //  [Therefore no action to take in this case]
            // - this mask is already showing and this method was called from maskTarget(), so 
            //   we need to sink this widget explicitly behind the screenSpan.
            if (!fromShowClickMask && this._screenSpan && this._screenSpan.isDrawn() && 
                canvas.getZIndex() >= this._screenSpan.getZIndex()) 
            {
                //>DEBUG
                this.logDebug("lowering zIndex of: " + canvas, "clickMask");
                //<DEBUG

                
                canvas.setZIndex(isc.EH._screenSpan.getZIndex() -1);
            }

            
        }
    }
    
    // clear the accessKey from the canvas - note that we don't have to clear the
    // tabIndex as we explicitly manage tab-keypresses while the mask is up
    if (canvas.accessKey != null && canvas.isDrawn()) {
        canvas._setHandleAccessKey(null);
    }
},

    
//>	@classMethod	EventHandler.hideClickMask()	(A)
//  Hide the click mask.
// @param [ID]  (string)
//      Which clickMask to hide?  If not specified, hide all clickMasks.
// @group clickMask
// @see EventHandler.showClickMask()
// @see method:canvas.hideClickMask
// @visibility eventhandler
//<
hideClickMask : function (ID) {

    

    if (this.logIsInfoEnabled("clickMask")) 
        this.logInfo("hideClickMask called with ID: " + ID, "clickMask");
    
    var registry = this.clickMaskRegistry;
    // Ensure we have at least one CM showing
    if (registry.length == 0) return;

    // if there's no ID, just hide all clickmasks
    if (ID == null) {
    
        // Hide the first CM in the array
        this.hideClickMask(registry[0].ID)

        // call this method with no ID again (will hide the next item in the array, and so on)
        if (registry.length > 0) {
            this.hideClickMask();
        } else {
            this.logInfo("all clickmasks hidden", "clickMask");
        }
        return;
    }

    var mask = this.getClickMask(ID);

    // if we were passed a bad ID just return (the CM in question's probably already hidden!)
    if (mask == null) return;

    //this.logWarn("hiding mask that had unmasked targets: " + this.echo(mask._unmaskedTargets));

    // At this point we're working with a specific mask in the registry.

    // Get all the information we need from the clickMask being destroyed, and remove it from
    // the clickMaskRegistry        
    var index = registry.indexOf(mask),
        isTopMask = (index == (registry.length -1)),
        isHardMask = this.isHardMask(mask),
        nextMaskDown = (index > 0 ? registry[index -1] : null),
        isTopHardMask,
        nextHardMaskDown;
     
    if (this.logIsInfoEnabled("clickMask")) {
        var msg = "hiding clickMask ID: " + ID;
        if (isHardMask) msg += "[autoHide:false]";
        else msg += "[autoHide:true]";
        if (registry.length < 2) {
            msg += ", all masks hidden";
        } else {
            // report index
            msg += " with index: " + index + " of " + (registry.length - 1); 
        }
        this.logInfo(msg, "clickMask");
    } 
        
    // If this is a 'hard' clickMask with no hard mask on top of it, 
    // hard unmask any unmasked newly targets
    if (isHardMask) {
        nextHardMaskDown = this._getNextHardMask(index, false);
        var nextHardMaskUp = this._getNextHardMask(index, true);
        isTopHardMask = (nextHardMaskUp == null);
    }
    
    var focusCanvas = mask._maskedFocusCanvas,
        unmaskedTargets = mask._unmaskedTargets;

    // Actually remove the clickMask from the registry at this point
    
    registry.remove(mask);
              
    // At this point
    // - if we hid the topmost mask we need to restore focus to the previous focus widget
    // - if the mask we hid had another mask under it, we need to notify that mask of this
    //   mask's unmaskedTargets
    // - if we hid the only visible mask we need to hide the screenSpan
    // - if we hid a hard mask
    //    - if there's a hard mask below it, the screenspan should go behind that mask's
    //      unmaskedTargets
    //    - otherwise we need to shift the screenSpan to the back of the visible set of widgets.
    
    // If we have a 'nextMaskDown', update it with the focus canvas, etc.
    if (nextMaskDown != null) {
        
        if (unmaskedTargets != null) {
            if (nextMaskDown._unmaskedTargets == null) nextMaskDown._unmaskedTargets = {};
            isc.addProperties(nextMaskDown._unmaskedTargets, unmaskedTargets);
        }

        // We attempt to focus on the maskedFocusCanvas below... but if it's still masked
        // we can't.
        // Instead record the maskedFocusCanvas on the next mask down
        if (focusCanvas && !nextMaskDown._unmaskedTargets[focusCanvas.getID()]) {
            this.setMaskedFocusCanvas(focusCanvas, nextMaskDown);
        }
    }
    
    if (this._screenSpan) {
        // if this is the only mask showing, hide the screenspan
        // True whether soft or hard
        if (isTopMask && nextMaskDown == null) {   
            
            if (isc.Browser.isIE) {
                isc.Timer.setTimeout({target:this._screenSpan, methodName:"hide"}, 0);
            } else {
                this._screenSpan.hide();                
            }   
        
        // If we're hiding the top-most hard mask we need to reposition the screenspan
        } else if (isTopHardMask) {      
            if (nextHardMaskDown) {
                this._adjustSpanZIndex(nextHardMaskDown._unmaskedTargets);
            } else this._screenSpan.sendToBack();
        }
        
        // If this was a hard mask we need to ensure that all newly revealed targets
        // ("unmaskedTargets" of the mask below if there was one, otherwise all canvii)
        // have their accessKeys cleared
        
        if (isHardMask) {

            var unmasked;
            if (nextHardMaskDown != null) {
                unmasked = [];
                // iterate through each of the masks below us up to (and including) the 
                // hard mask below us, to determine which widgets will be no longer be 
                // hard-masked when this mask is hidden.
                for (var i = index-1; i >= 0; i--) {
                    var lowerMask = registry[i];
                    unmasked.addList(isc.getKeys(lowerMask._unmaskedTargets));
                    if (lowerMask == nextHardMaskDown) break;
                }
            } else {
                // everything is unmasked
                
                unmasked = isc.Canvas._canvasList;
            }

            // Call _hardUnmaskTargets to restore accessKeys.
            this._hardUnmaskTargets(unmasked, true);
        }
         
        // If we have a masked focus canvas, focus on it if it's unmasked
        if (focusCanvas != null && !focusCanvas.destroyed && !this.targetIsMasked(focusCanvas)) {
            if (this.logIsInfoEnabled("clickMask")) {
                this.logInfo("focusing in " + focusCanvas + " on clickMask hide", "clickMask");
            }

                        
            var delayedFocus = (isc.Browser.isIE && this.lastEvent.eventType == this.MOUSE_DOWN)
            
            if (delayedFocus) {     
                this._delayedFocusTarget = focusCanvas;
            } else {
                focusCanvas.focus();
            }
        }
    }

    // updateEventMasks()
    // Shows / Clears individual event masks over canvii if necessary
    this.updateEventMasks();
    
    // If we hid the bottom mask, but other masks are showing on top of it, we currently
    // do nothing.
    // This is appropriate with 'unmaskedTargets', since nothing will be masked below
    // this widget.
    // We passed the 'maskedFocusCanvas' from up to the masks above it when we showed them (when
    // appropriate), so it should not matter that we're dropping the masked focus canvas for the
    // bottom mask.
},

// Given a clickMask in the registry determine the index of the next hard mask above or below
// it.
_getNextHardMask : function (maskIndex, above) {
    
    var registry = this.clickMaskRegistry;
        
    if (above) {
        for (var i = maskIndex+1; i < registry.length; i++) {
            if (this.isHardMask(registry[i])) return registry[i];
        }
    } else {
        for (var i = maskIndex-1; i >=0; i--) {
            if (this.isHardMask(registry[i])) return registry[i];
        }
    }
    // No hard mask was found above (or below) this mask
    return null;
},

// Resolve a canvas ID (or pointer to a canvas) to a canvas.
_getCanvas : function (canvas) {
    if (isc.isA.String(canvas)) return window[canvas];
    return canvas;
},


// Ensure widgets are not "hard masked"
_hardUnmaskTargets : function (widgets, fromHideClickMask) {
    if (!widgets || widgets.length == 0) return;
    
    for (var i = 0; i < widgets.length; i++) {
        // We pass either an array of widgets or an array of widget IDs - so we need to resolve 
        // these to canvii    
        var canvas = this._getCanvas(widgets[i]);
        if (!canvas) continue;
        
        // If we cleared the accessKey, reset it now
        if (canvas.accessKey != null && canvas.isDrawn()) {
            canvas._setHandleAccessKey(canvas.accessKey);
        }

        
        if (!canvas.isDrawn() && isc.isA.DynamicForm && isc.isA.DynamicForm(canvas) && 
            canvas.items && canvas.items.length > 0)
        {
            var item = canvas.items[0];
            
            if (item.containerWidget != canvas) canvas = item.containerWidget;
        }

        // Ensure that the canvas isn't obscured by the screenSpan
        // If the top level targets are behind the screenSpan, move it above it.
        
        if (!fromHideClickMask && canvas.parentElement == null && 
            canvas.getZIndex() <= this._screenSpan.getZIndex() &&
            canvas != this._screenSpan) 
        {
            canvas.setZIndex(this._screenSpan.getZIndex() +1);
            //>DEBUG
            this.logDebug("raised above screenspan: " + canvas, "clickMask");
            //<DEBUG
        }
    }

},

//>	@classMethod	EventHandler.clickMaskUp()	(A)
//  Determine whether a clickMask is currently showing.
//
// @param [ID]  (string)
//      Which clickMask to check?  If not specified, check whether any clickMask is showing.
// @group clickMask
// @return (boolean)    true if the click mask is showing
// @visibility eventhandler
//<
clickMaskUp : function (ID) {
    var registry = this.clickMaskRegistry;
    
    if (ID == null) return (registry.length > 0);
    else return (registry.find("ID", ID) != null);
},


//>	@classMethod	EventHandler.getAllClickMaskIDs()	(A)
//  Get the IDs for every click mask that's currently up.
// @group clickMask
// @return (Array)  Array of clickmask ID strings.
// @visibility internal
//<
getAllClickMaskIDs : function () {
    var registry = this.clickMaskRegistry;
    if (registry.length < 1) return [];
    
    return registry.getProperty("ID");
},

//>	@classMethod	EventHandler.showScreenSpan()	(A)
// @visibility internal
//<
showScreenSpan : function (mask) {
    
	if (!this._screenSpan) {
        this._screenSpan = isc.ScreenSpan.create(
            {ID:"isc_EH_screenSpan", 
             // If the screenspan gets destroyed, have it clear up our pointer to it.
             pointersToThis:[{object:this, property:"_screenSpan"}]
            },
            this.clickMaskProperties
         );
    }
	var span = this._screenSpan;
	span.show();
    
    if (!this.isHardMask(mask)) {
        span.sendToBack();
    } else {
        this._adjustSpanZIndex(mask._unmaskedTargets);
    }
},

// We show the screenSpan for clickMasks to suppress native interactions with DOM element such
// as form elements / links
_adjustSpanZIndex : function (unmaskedTargets) {
    // set a flag so we don't respond to 'bringToFront()' calls on widgets by 'unmasking' them
    
    this._adjustSpanZIndexRunning = true;

    var zIndex;
    for (var ID in unmaskedTargets) {
        var canvas = this._getCanvas(ID);
        // We only need to move the top level unmasked targets above the screenSpan.
        
        
        if (!canvas || canvas.destroyed || canvas.parentElement != null) {
            continue;
        }
        
        // If the canvas is a peer of an unmasked master, assume the masterElement manages
        // the zIndex of the peer, rather than calling bringToFront() here.
        // Avoids, for example, a shadow showing up in front of its target widget.
        
        if (canvas.masterElement && unmaskedTargets[canvas.masterElement.getID()]) continue;
        
        canvas.bringToFront();
        if (zIndex == null) zIndex = canvas.getZIndex(true);
        
        // Remember zIndex is going to be the lowest zIndex of all unmasked canvii so we can 
        // slot the screenSpan underneath it.
        // We know that all peers unmask with their master (and allow the master to 
        // handle assigning the zIndex), so ensure the zIndex of the span is less than 
        // the zIndex of any peers.
        
        if (canvas.peers) {
            for (var i = 0; i < canvas.peers.length; i++) {
                if (!canvas.peers[i].isDrawn()) continue;
                zIndex = Math.min(zIndex, canvas.peers[i].getZIndex(true));
            }
        }
    }
    
    
    if (zIndex != null) this._screenSpan.setZIndex(zIndex -1);
    else this._screenSpan.bringToFront();

    this._adjustSpanZIndexRunning = false;
    
},

//> @classMethod    isc.EventHandler.maskTarget()
//
//      Ensure that a widget (or array of widgets) is below (obscured by) by the clickMask.
//
//      @group  clickMask
//      @param  target      (widget | Array of widgets)
//                  target[s] to unmask
//      @param  [maskID]    (string)
//                  ID of clickmask to move this target below.  If not passed in, will move below
//                  all visible clickMasks
//  @visibility eventhandler
//<

maskTarget : function (target, maskID) {
    // synonym for maskTargets
    return this.maskTargets(target, maskID);
},

//> @classMethod    isc.EventHandler.maskTargets()
//
//      Synonym for +link{classMethod:EventHandler.maskTarget()}
//
//      @group  clickMask
//      @param  target      (widget | Array of widgets)
//                  target[s] to unmask
//      @param  [maskID]    (string)
//                  ID of clickmask to move this target below.  If not passed in, will move below
//                  all visible clickMasks
// @visibility eventhandler
//<
maskTargets : function (targets, maskID, dontMaskChildren) {

    var registry = this.clickMaskRegistry;
    if (targets == null || registry.length == 0) return;

    if (!isc.isAn.Array(targets)) targets = [targets];
    else if (targets.length == 0) return;
    
    var mask =  (maskID == null ? registry[0] : 
                    (isc.isA.String(maskID) ? this.getClickMask(maskID) : maskID)
                );
    
    // If we couldn't get a mask, bail.
    if (mask == null) {
        // log at the info level -- this is likely to happen if the mask was hidden already, so 
        // a logWarn is a little strong
        this.logInfo("maskTargets called with invalid maskID - returning.", "event")
        return;
    }
    
    // At this point we have a valid mask and a set of targets to mask.
    
    // Iterate through targets adding any children or ancestors that need to also get masked
    var originalTargetsLength = targets.length    
    for (var i = 0; i < originalTargetsLength; i++) {
        
        var target = targets[i];
        
        // By default if this method is called we will mask all the widget's children as well as
        // the widget itself. This means if you call (for example) 'mask' on a currently unmasked
        // ListGrid, the body will also get masked.
        if (!dontMaskChildren && target.children != null) {
            this._addDescendantsToList(target, targets);
        }
    
        // We support having a parent be masked but a child be unmasked, but not a child be masked
        // but its parent be unmasked.
        // Therefore we will also iterate up through this widget's ancestor chain, masking all 
        // ancestors -- but not all of their children as this could mask just about everything on
        // the page if one of our targets is a child of a pageLayout, for example.
        // 
        // Also: Always mask / unmask peers with their masters
        // Use cases: Scrollbars, edged canvii, etc
        
        var parent = target.parentElement;
        while (parent != null) {
            if (!targets.contains(parent)) {
                targets.add(parent);
                if (dontMaskChildren) this._addPeersToList(parent, targets);
            }
            parent = parent.parentElement;
        }
        
        // At this point 'parent' is the top-level element, if defined
        if (dontMaskChildren || !parent) {
            this._addPeersToList(target, targets);
        }
        if (parent) this._addPeersToList(parent, targets);
    }
    
    // Now actually mask every target
    // When masking a widget we're essentially moving it down some number of layers in
    // the clickmask stack. (The simplest case of course is moving it from top to bottom).
    
    
    var maskIndex = registry.indexOf(mask);
    
    // Determine where the top hard mask is above / including this mask.
    // This will be used to determine whether the widget(s) being masked need to be hard masked
    var topHardMask;
    for (var i = maskIndex; i < registry.length; i++) {
        currentMask = registry[i];
        if (this.isHardMask(currentMask)) topHardMask = i;   
    }

    var targetsToHardMask;
    if (topHardMask != null) targetsToHardMask = [];
    for (var n = 0; n < targets.length; n++) {
        var target = targets[n];
        // always blur if it has focus.
        if (target.hasFocus) target.blur();
        
        var currentMask,
            topHardMask,
            targetLevel = null;
        
        for (var i = maskIndex; i < registry.length; i++) {
            currentMask = registry[i];
            if (currentMask._unmaskedTargets[target.getID()]) {
                targetLevel = i;
                // Always remove 'masked' targets from the masks' "unmaskedTargets" lists
                delete currentMask._unmaskedTargets[target.getID()];
                
            }
        }

        // If the target was unmasked wrt the top hard mask we need to hard mask it now.
        if (topHardMask != null && targetLevel != null && (topHardMask <= targetLevel)) {
            targetsToHardMask.add(target);
        }
    }
    // HardMaskTargets will handle 
    // - putting the targets behind the screenSpan if necessary
    // - getting rid of accessKey on the handle.
    if (topHardMask != null) this._hardMaskTargets(targetsToHardMask, null, false, false);
},

//> @classMethod    isc.EventHandler.addUnmaskedTarget()
//
//      Ensure that a widget (or array of widgets) is not masked by the clickMask.
//
//      @group  clickMask
//      @param  target      (widget | Array of widgets)
//                  target[s] to unmask
//      @param  [maskID]    (string)
//                  ID of clickmask to move this target above.  If not passed in, will move above
//                  all visible clickMasks
// @visibility eventhandler
//<
addUnmaskedTarget : function (target, maskID) {
    // synonym for addUnmaskedTargets
    return this.addUnmaskedTargets(target, maskID);
},
										
//> @classMethod    isc.EventHandler.addUnmaskedTargets()
//
//      Synonym for addUnmaskedTarget.
//
//      @group  clickMask
//      @param  target      (widget | Array of widgets)
//                  target[s] to unmask
//      @param  [maskID]    (string)
//                  ID of clickmask to move this target above.  If not passed in, will move above
//                  all visible clickMasks
// @visibility eventhandler
//<
// @param [recursive] (boolean) Internal debugging parameter indicating this is a call from 
//      within an addUnmaskedTargets() call, adding children of some target to the unmasked 
//      targets list

addUnmaskedTargets : function (targets, maskID) {

    // avoid unmasking targets in response to adjusting z-index as part of adjustSpanZIndex
    if (isc._unmaskOnBringToFront && this._adjustSpanZIndexRunning) return;

    var registry = this.clickMaskRegistry;
    if (targets == null || registry.length == 0) return;
    // support 'targets' being an array or a single widget
    if (!isc.isAn.Array(targets)) targets = [targets];

    if (targets.length == 0) return;
    var mask;
    
    // if passed no mask ID, completely unmask (so add to TOP mask's list of unmaskedTargets)
    if (maskID == null) {
        mask = registry.last();
    } else {
        if (isc.isA.String(maskID)) mask = this.getClickMask(maskID);
        // support being passed a mask object as well as an ID
        else mask = maskID;
    }
    // If we couldn't get a mask, bail.
    if (mask == null) {
        // log at the info level -- this is likely to happen if the mask was hidden already, so 
        // a logWarn is a little strong
        this.logInfo("addUnmaskedTargets called with invalid maskID - returning.", "clickMask")
        return;
    }

    // If we're "hard unmasking" anything, we need to ensure we hard unmask its ancestors as
    // well as children. We don't support a masked parent with unmasked children for 
    // hard masks.
    var hardMask = mask;
    while (hardMask && !this.isHardMask(hardMask)) {
        hardMask = registry[registry.indexOf(hardMask) -1];
    }
    if (hardMask != null) {
        
        if (isc._unmaskOnBringToFront && targets.length == 1 && targets[0].topElement != null) {
            //this.logWarn("not treating bringToFront as unmask because widget is not top-level: " +
            //             targets[0] + ", topElement: " + targets[0].topElement);
            return;
        }
    }
    
    // Combine ancestors (where appropriate), peers, descendants into the unmaskedTargets list
    targets = this._getFullSetOfTargetsToUnmask(targets, mask);

    //>DEBUG
    if (this.logIsDebugEnabled("clickMask")) {
        this.logDebug("Added unmasked targets:" + targets.getProperty("ID") + 
                      " [+ decendants] to clickMask with ID: " + mask.ID , "clickMask");
    }
    //<DEBUG
    
    var hardMaskAbove = false;
    for (var i = registry.indexOf(mask)+1; i < registry.length; i++) {
        if (this.isHardMask(registry[i])) hardMaskAbove = true;
    }
    
    for (var n = 0; n < targets.length; n++) {
        var target = targets[n];
        
        
        if (mask._unmaskedTargets == null) mask._unmaskedTargets = {};
        mask._unmaskedTargets[target.getID()] = true;
    }
   
    // Each target will be unmasked relative to the mask in question and any masks 
    // underneath it
    // If it was previously masked by a hard mask, and there is no hard mask ABOVE this one
    // we need to shift above the screenSpan / reset accessKey
    
    if (!hardMaskAbove) {
        this._hardUnmaskTargets(targets);
    }
},

//> @classMethod    isc.EventHandler.targetIsMasked() (A)
//
//      return whether this Canvas is masked by the clickMask
//
//      @group  clickMask
//      @param  target  (widget)    target of the mouseDown event.
//      @param  [maskID] (string)   ID of click mask to check against - if not passed in, method
//                                  will determine whether the widget is above the top clickMask.
//      @return         (boolean)   true if masked, false if not masked.
//      @visibility eventhandler
//<
targetIsMasked : function (target, maskID) {
    var registry = this.clickMaskRegistry;
    if (registry.length ==0) return false;
    
    // if we weren't given a target, a clickmask is up and the event occurred over a 
    // native page element rather than a widget - so the target is masked.
    if (target == null) return true;
    
    // If we weren't passed a maskID, just look at the topmost mask
    var mask;
    if (maskID == null) mask = registry.last();
    else if (isc.isA.String(maskID)) mask = registry.find("ID", maskID);
    else mask = maskID;
    if (!isc.isAn.Object(mask)) {
        this.logWarn("EventHandler.targetIsMasked() passed invalid maskID:" + maskID, 
                     "clickMask");
        return false;
    }
    
    var initialIndex = registry.indexOf(mask);
    for (var i =  initialIndex; i < registry.length; i++) {
        // On the first iteration we already have a pointer to the mask
        if (i != initialIndex) mask = registry[i];
        
        if (mask._unmaskedTargets) {
            if (mask._unmaskedTargets[target.getID()]) return false;
            
            // Special case: form items written into an unmasked container item should be treated as
            // unmasked (even if the form itself is masked)
            
            if (isc.isA.DynamicForm!=null && isc.isA.DynamicForm(target)) {
                var itemInfo = target._getEventTargetItemInfo(isc.EH.lastEvent);
                if (itemInfo && itemInfo.item && 
                    itemInfo.item.form == target && itemInfo.item.containerWidget != target &&
                    mask._unmaskedTargets[itemInfo.item.containerWidget.getID()]) return false;
            }
        }
    }
    
    return true;
},

//> @classMethod    isc.EventHandler.clickMaskClick()
//
//      Called when a mouseDown occurred over a widget that may be masked by a clickMask.
//      If the target is masked, fire the appropriate clickMask action.
//      Returns true if the target is not masked, or the clickMask auto-hides (allows the
//      mouseDown event to proceed to it's target)
//      Returns false if the target is masked, and the clickMask is hard or has mode "softCancel" -- 
//      prevents the target from recieving the mouseDown event.
//
//      @group  clickMask
//      @param  target  (widget)    target of the mouseDown event.
//      @return         (boolean)   
//          True to allow the mouseDown event to proceed, false to cancel the event.
//      @visibility internal
//<
clickMaskClick : function (target) {

    // copy the clickMaskRegistry, so we don't get confused if the registry is modified by
    // the click action showing additional masks(for example)
    var maskReg = this.clickMaskRegistry.duplicate(),
        mask = maskReg.last();
     
    while (mask != null && (this.targetIsMasked(target) || target == this._screenSpan)) {
        if (this.logIsInfoEnabled("clickMask")) {
            this.logInfo("mouseDown on masked " + target + 
                          (mask.clickAction != null ? " firing clickAction, " : "") +
                          (mask.autoHide ? 
                            "will hide mask" + 
                                (mask.mode == isc.EH.SOFT_CANCEL ? " and block click" : "") : 
                           "will block click"));
        }
        var cancel = (mask.mode != isc.EH.SOFT);
        this._clickMaskClick(mask)

                
        // If the mask is hard return false to cancel the event -- we're done
        if (cancel) return false;

        // If the mask is soft (and not "softCancel"), fire clickMaskClick on the mask underneath it
        mask = maskReg[maskReg.indexOf(mask) -1];
    }
    
    // if we got here we've hit an unmasked target (possibly after hiding some autoHide true CM's)
    return true;
},

// actually fire the click action and (if appropriate) hide the mask.
_clickMaskClick : function (mask) {

    var autoHide = mask.autoHide,
        clickAction = mask.clickAction;

    if (autoHide == true) this.hideClickMask(mask.ID);

    // Fire the action if there is one.
    // Note: we don't care about the return value from the clickAction.
    if (clickAction != null) this.fireCallback(clickAction);
}

});	// END isc.EventHandler.addClassMethods()

// call captureEvents now to set things up for our event handling.
isc.EventHandler.captureEvents();



