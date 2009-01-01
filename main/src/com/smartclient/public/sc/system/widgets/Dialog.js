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

 





//>	@class	Dialog
//
// Dialogs are a specialized version of +link{Window} used for small windows such as
// alerts, prompts, and confirmations.  They can be modal or modeless (via the
// +link{Window.isModal,isModal} property) and will contain various children by default
// ("titlebar", "resizer", etc).
// <P>
// NOTE: If you are building a custom component that will add components to the Window via
// +link{window.addItem(),addItem()}, in most cases it makes sense 
//
//
//  @treeLocation Client Reference/Control
//  @visibility external
//<
isc.ClassFactory.defineClass("Dialog", "Window");

// add class properties
isc.Dialog.addClassProperties({
    //>	@classAttr	Dialog._openModalDialogs		(array : [] : IRWA)
	// 			list of open modal Dialogs so we can keep track as we open them
	//		@group	modal
	//		@see	Dialog.show()
	//<
	_openModalDialogs : [],

    //> @classAttr  Dialog.OK_BUTTON_TITLE  (HTML : "OK" : IRW)
    // Title for the <code>"OK"</code> button.
    // @see type:DialogButtons
    // @group i18nMessages
    // @visibility external
    //<
    OK_BUTTON_TITLE:"OK",
    //> @classAttr  Dialog.APPLY_BUTTON_TITLE  (HTML : "Apply" : IRW)
    // Title for the <code>"Apply"</code> button.
    // @see type:DialogButtons
    // @group i18nMessages
    // @visibility external
    //<
    APPLY_BUTTON_TITLE:"Apply",
    //> @classAttr  Dialog.YES_BUTTON_TITLE  (HTML : "Yes" : IRW)
    // Title for the <code>"Yes"</code> button.
    // @see type:DialogButtons
    // @group i18nMessages
    // @visibility external
    //<    
    YES_BUTTON_TITLE:"Yes",
    //> @classAttr  Dialog.NO_BUTTON_TITLE  (HTML : "No" : IRW)
    // Title for the <code>"No"</code> button.
    // @see type:DialogButtons
    // @group i18nMessages
    // @visibility external
    //<    
    NO_BUTTON_TITLE:"No",
    //> @classAttr  Dialog.CANCEL_BUTTON_TITLE  (HTML : "Cancel" : IRW)
    // Title for the <code>"Cancel"</code> button.
    // @see type:DialogButtons
    // @group i18nMessages
    // @visibility external
    //<    
    CANCEL_BUTTON_TITLE:"Cancel",
    
    // Default Titles for the prompt windows themselves
    
    //> @classAttr  Dialog.CONFIRM_TITLE    (HTML : "Confirm" : IRW)
    // Default title for the dialog displayed in response to the +link{isc.confirm()} method.
    // Note that a custom title can be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<
    CONFIRM_TITLE:"Confirm",

    //> @classAttr  Dialog.SAY_TITLE    (HTML : "Note" : IRW)
    // Default title for the dialog displayed in response to the +link{isc.say()} method.
    // Note that a custom title can be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<    
    SAY_TITLE:"Note",

    //> @classAttr  Dialog.WARN_TITLE    (HTML : "Note" : IRW)
    // Default title for the dialog displayed in response to the +link{isc.warn()} method.
    // Note that a custom title can be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<        
    WARN_TITLE:"Note",
    
    //> @classAttr  Dialog.ASK_TITLE    (HTML : "Question" : IRW)
    // Default title for the dialog displayed in response to the +link{isc.ask()} method.
    // Note that a custom title can be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<        
    ASK_TITLE:"Question",

    //> @classAttr  Dialog.ASK_FOR_VALUE_TITLE    (HTML : "Please enter a value" : IRW)
    // Default title for the dialog displayed by +link{isc.askForValue()}.
    // A custom title can alternatively be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<        
    ASK_FOR_VALUE_TITLE:"Please enter a value",

    //> @classAttr  Dialog.LOGIN_TITLE (HTML : "Please log in" : IRW)
    // Default title for the dialog displayed by +link{isc.showLoginDialog()}.
    // A custom title can alternatively be specified as the <code>title</code> attribute of the 
    // <code>properties</code> parameter passed to that method.
    // @group i18nMessages
    // @visibility external
    //<        
    LOGIN_TITLE:"Please log in",

    //> @classAttr  Dialog.USERNAME_TITLE (HTML : "Username" : IRW)
    // Default title for the "username" field in the dialog displayed by 
    // +link{isc.showLoginDialog()}. 
    // @group i18nMessages
    // @visibility external
    //<        
    USERNAME_TITLE:"Username",

    //> @classAttr  Dialog.PASSWORD_TITLE (HTML : "Password" : IRW)
    // Default title for the "password" field in the dialog displayed by 
    // +link{isc.showLoginDialog()}.
    // @group i18nMessages
    // @visibility external
    //<        
    PASSWORD_TITLE:"Password",

    //> @classAttr  Dialog.LOGIN_BUTTON_TITLE (HTML : "Log in" : IRW)
    // Default title for login button in the dialog displayed by 
    // +link{isc.showLoginDialog()}.
    // @group i18nMessages
    // @visibility external
    //<        
    LOGIN_BUTTON_TITLE:"Log in",

    //> @classAttr  Dialog.LOGIN_ERROR_MESSAGE (HTML : "Invalid username or password" : IRW)
    // Default error message displayed on failed login in the dialog shown by 
    // +link{isc.showLoginDialog()}.
    // @group i18nMessages
    // @visibility external
    //<        
    LOGIN_ERROR_MESSAGE:"Invalid username or password",

	//>	@type   DialogButtons
    // Default buttons that you can use in your Dialogs.
	// <P>
    // On click these call canonical methods that you can override in your Dialog.
    // <P>
    // Refer to these buttons via the syntax <code>isc.Dialog.OK</code> when passing them into
    // +link{dialog.toolbarButtons} or into the <code>properties</code> argument of helper
    // methods such as +link{isc.say()}.
    //
    // @value   OK  Button object to fire dialog's "okClick()" method on click.
    //              Title derived from +link{Dialog.OK_BUTTON_TITLE}.
	OK 		: {getTitle:function () {return isc.Dialog.OK_BUTTON_TITLE},
                width:75, click: function () { this.topElement.okClick() } },
    // @value   APPLY Button object to fire dialog's "applyClick()" method on click.
    //              Title derived from +link{Dialog.APPLY_BUTTON_TITLE}.    
	APPLY 	: {getTitle:function () {return isc.Dialog.APPLY_BUTTON_TITLE}, 	
                width:75, click: function () { this.topElement.applyClick() } },
    // @value   YES Button object to fire dialog's "yesClick()" method on click    
    //              Title derived from +link{Dialog.YES_BUTTON_TITLE}.    
	YES 	: {getTitle:function () {return isc.Dialog.YES_BUTTON_TITLE}, 	
                width:75, click: function () { this.topElement.yesClick() } },
    // @value   NO  Button object to fire dialog's "noClick()" method on click.
    //              Title derived from +link{Dialog.NO_BUTTON_TITLE}.
	NO	 	: {getTitle:function () {return isc.Dialog.NO_BUTTON_TITLE}, 		
                width:75, click: function () { this.topElement.noClick() } },
    // @value   CANCEL  Button object to fire dialog's "cancelClick()" method on click.
    //                  Title derived from +link{Dialog.CANCEL_BUTTON_TITLE}.
	CANCEL 	: {getTitle:function () {return isc.Dialog.CANCEL_BUTTON_TITLE}, 	
                width:75, click: function () { this.topElement.cancelClick() } }
    // @visibility external
    //<

    
    
    
});

// add standard instance properties
isc.Dialog.addProperties({	
    //>	@attr	dialog.styleName	(CSSStyleName: "dialogBackground" : IRW)
	//			Style of the Dialog background
	//		@group	appearance
    //      @visibility external
	//<	
	styleName:"dialogBackground",		

	skinImgDir:"images/Dialog/",

	canDragReposition : false,
	canDragResize:false,

	//>	@attr	dialog.autoCenter		(boolean : autoCenter : IRW)
	//			if true, this dialog will automatically be centered on the page when shown
	//			if false, it will show up wherever you (or the user) last put it
	//		@group	appearance, location
	//		@see	dialog.show()
	//<
	autoCenter : true,
										
	// Body Settings
	// ----------------------------------------------------------------------------------------
    //>	@attr	dialog.bodyStyle	(string : "dialogBody" : IA)
	// Style of the Window body
	//		@group	appearance, header
	//		@see	Window.makeBody()
	//<		
    bodyStyle:"dialogBody",  	

    //>	@attr	dialog.bodyColor		(CSSColor : "#DDDDDD" : IA)
	//			Color of the Window body.
	//			Overrides the background color specified in the style.
	//		@group	appearance, header
	//		@see	Window.makeBody()
    //      @see    Window.flash()
	//<	
    bodyColor:"#DDDDDD",			

    //>	@attr	dialog.hiliteBodyColor		(CSSColor : "#DDDDDD" : IA)
	// Highlight color for the Window body (shown when the body is flashed).
	//		@group	appearance, header
	//		@see	Window.makeBody()
    //      @see    Window.flash()
	//<	
    hiliteBodyColor:"#FFFFFF",          

    // Header
	// ----------------------------------------------------------------------------------------
    //>	@attr	dialog.headerStyle	(string : "DialogHeader" : IA)
	// Style of the Dialog header
	//		@group	appearance, header
	//		@see	Dialog.makeHeader()
	//<
    headerStyle:"dialogHeader",  

    //>	@attr	dialog.windowHeaderHilite	(string : "WindowHeader" : IA)
	//			Highlight style for the Dialog header
	//		@group	appearance, header
	//		@see	Window.makeHeader()
	//<											
    hiliteHeaderStyle:"dialogHeaderHilite",  

    //>	@attr	dialog.headerLabelTextStyle	(string : "dialogHeaderText" : IA)
	//			Style of the Dialog headerLabel text
	//		@group	appearance, headerLabel
	//		@see	Dialog.makeHeaderLabel()
	//<
    headerLabelDefaults : isc.addProperties({},
                                            isc.Window.getInstanceProperty("headerLabelDefaults"),
                                            {styleName:"dialogHeaderText"}),

	// Header Icon
	// ----------------------------------------------------------------------------------------
	//>	@attr	dialog.showHeaderIcon		(boolean : false : IRW)
	//			should we show a headerIcon in the header, 
	//			clicking it dismisses the Dialog
	//		@group	appearance, header
	//		@see	Dialog.makeHeaderIcon()
	//<		
	showHeaderIcon:false,

	// Buttons
	// ----------------------------------------------------------------------------------------
	//>	@attr	Dialog.showMinimizeButton		(boolean : false : IRW)
	// Should we show a minimizeButton in the header, clicking it dismisses the Dialog
	//		@group	appearance, header
	//		@see	Dialog.makeMinimizeButton()
	//<
	showMinimizeButton:false,

    //>	@attr	Dialog.showMaximizeButton		(boolean : false : IRW)
	// Should we show a maximizeButton in the header, clicking it dismisses the Dialog
	//		@group	appearance, header
	//		@see	Dialog.makeMaximizeButton()
	//<								
	showMaximizeButton:false,			
	
	// Footer
	// ----------------------------------------------------------------------------------------
	//>	@attr	Dialog.showFooter		(boolean : false : IRW)
	// Should we show a footer for this Dialog, including resizer, statusBar, etc?
	//		@group	appearance, footer
	//<
	showFooter:false,
	
	// Toolbar
	// ----------------------------------------------------------------------------------------
    //>	@attr	Dialog.showToolbar		(boolean : false : IRW)
	// Whether to show a toolbar of buttons at the bottom of the Dialog.
	//		@group	appearance, toolbar
    // @visibility external
	//<    	
	showToolbar:true,

    //> @attr Dialog.toolbarButtons (Array of Button or Button Properties : null : IR)
    // Array of Buttons to show in the +link{showToolbar,toolbar}, if shown.
    // <P>
    // The set of buttons to use is typically set by calling one of the shortcuts such as
    // +link{isc.say()} or +link{isc.confirm()}.  A custom set of buttons can be passed to
    // these shortcuts methods via the "properties" argument, or to a directly created Dialog.
    // <P>
    // In both cases, a mixture of +link{type:DialogButtons,built-in buttons}, custom buttons,
    // and other components (such as a +link{LayoutSpacer}) can be passed.  Built-in buttons
    // can be referred to as <code>isc.Dialog.OK</code>, for example:
    // <pre>
    // isc.Dialog.create({
    //    toolbarButtons:[
    //       isc.Dialog.OK, 
    //       isc.Dialog.CANCEL, 
    //       isc.LayoutSpacer.create({width:50}), 
    //       { title:"Not now", click:"doSomething()" }
    //    ]
    // })
    // </pre>
    // Built-in buttons will call standard methods on the Dialog itself, such as
    // +link{dialog.cancelClick()}, as explained in the 
    // +link{type:DialogButtons,list of built-in buttons}.
    //
    // @visibility external
    //<

    // Body Icons
    // ---------------------------------------------------------------------------------------
    askIcon:"[SKIN]ask.png",
    sayIcon:"[SKIN]say.png",
    warnIcon:"[SKIN]warn.png",
    confirmIcon:"[SKIN]confirm.png", // XXX misnamed media

    // media exists, but no global helper, you have to call eg showMessage(message, "error")
    notifyIcon:"[SKIN]notify.png", // XXX misnamed media
    errorIcon:"[SKIN]error.png",
    stopIcon:"[SKIN]stop.png"

});	// END	isc.Dialog.addProperties()

//!>Deferred

isc.Dialog.addMethods({

//>	@method	Dialog.saveData()	(A)
// Method to save this Dialog's data. Called from <code>okClick()</code>, 
// <code>applyClick()</code>.
// No default implementation - override to perform some action if required.
//      
//		@group	buttons
//      @visibility external
//      @see okClick()
//      @see applyClick()
//<
saveData : function () {},

//> @method Dialog.closeClick()
// @include Window.closeClick()
//<

//>	@method	Dialog.cancelClick()
// Handle a click on the 'cancel' button of this Dialog.
// Default implementation is to return null and hide the Dialog.
// Override to do something else.
//		@group	buttons
//      @visibility external
//      @see type:DialogButtons
//<
cancelClick : function () {
    return this.closeClick();
},
// reroute the close button to call cancelClick
// (This way overrides to cancelClick will get fired - still falls through to closeClick())
_closeButtonClick : function () { return this.cancelClick() },

//>	@method	Dialog.okClick()	()
// Handle a click on the 'ok' button of this Dialog.
// Default implementation is to call <code>saveData()</code>, hide the Dialog, then return
// <code>true</code>.  
// Override to do something else.
//		@group	buttons
//      @visibility external
//      @see type:DialogButtons
//<
okClick : function () {
    this.saveData();
    
	this.clear();
	this.returnValue(true);
},


//>	@method	Dialog.applyClick()
// Handle a click on the 'apply' button of this Dialog.  
// Default implementation is to call <code>saveData()</code>, but NOT close the Dialog.
//		@group	buttons
//      @visibility external
//      @see type:DialogButtons
//<
applyClick: function () {
    this.saveData();
},

//>	@method	Dialog.yesClick()
// Handle a click on the 'yes' button of this Dialog.
// Default implementation is to return <code>true</code>.
// Override to do something else
//		@group	buttons
//      @visibility external
//      @see type:DialogButtons
//<
yesClick : function () {
	this.returnValue(true);
},

//>	@method	Dialog.noClick()
// Handle a click on the 'no' button of this Dialog.
// Default implementation is to return <code>false</code>.
// Override to do something else.
//		@group	buttons
//      @visibility external
//      @see type:DialogButtons
//<
noClick : function () {
	this.returnValue(false);
}

});

//!<Deferred

//
//	Default Dialogs that we create
//


//>	@groupDef Prompting
//	Objects / methods used for displaying prompts and warnings to the user via (possibly modal)
//  isc Dialog objects.
// @treeLocation Client Reference/Control
//<


//>	@classAttr	Dialog.Prompt   (Dialog Properties : dialog instance properties : A)
//
//  The "Prompt" object on the dialog class is a singleton Dialog instance.
//  The Prompt is used to show text to the user in a modal fashion - it will expand to show 
//  all the text that you put into it.
//  By default this Dialog has no end-user controls and is expected to be programmatically
//  dismissed.<br>
//  Common use-case: During server-interactions, the Prompt will be used to display a suitable 
//  wait message, and suppress user input.<br><br>
//
// Notes:<br>
//  Because this is a singleton object, properties set on the Prompt directly will persist each
//  time it is shown.<br>
//  Developers should use the <code>showPrompt()</code> and <code>clearPrompt()</code> methods
//  to show and hide the prompt rather than manipulating the prompt directly.
//
// @group Prompting
// @visibility external
// @see classMethod:isc.showPrompt()
// @see classMethod:isc.clearPrompt()
//<
isc.Dialog.Prompt = {
	ID:"isc_globalPrompt",
    _generated:true,
	width:400,
    height:90,

    autoDraw:false,
    autoSize:true,
	isModal:true,
	autoCenter:true,
	showHeader:false,
	showFooter:false,
	showToolbar:false,

    dismissOnEscape:false,
    
    bodyStyle:"promptBody", // no border-top, since there is no header
                            // TODO autogenerate border in Window based on header visibility
    
    message:"Loading...",

    blurbDefaults : { width:390, align:isc.Canvas.CENTER, valign:isc.Canvas.CENTER },
    
    layoutMargin:0,
    
	//>	@method	Prompt.showMessage()
	//	Show a message in the Dialog
	//
	//	Dialog will redraw and resize to show the entire message
	//	any properties in attributes will get applied and may be visibily changed
	//
	//	@param	newMessage	(string)	message to display
	//	@param	attributes	(object)	object of name:value pairs to apply to the object
	//									properties are applied before the redraw
	//<
	showMessage : function (newMessage, properties) {
    
		// first add the properties specified
		this.setProperties(properties);
    
        this.message = newMessage;

        // Note: we lazily create children on draw, so verify that the items have been
        // initialized before manipulating the label
        if (!this._isInitialized) this.createChildren();

        // add a label
        this.addAutoChild("blurb", null, isc.Label, this.body);
        this.blurb.setContents(this.message);
		
		this.show();
	},

	// clear the prompt message -- just clear the prompt
    
	clearMessage : function () {
		this.clear();
	},
    
    // If the prompt gets destroyed, remove the pointer to it.
    
    destroy : function () {
        isc.Dialog.Prompt = this._originalProperties;
        return this.Super("destroy", arguments);
    }
};



//>	@classMethod isc.showPrompt()
//
//	Method available on the isc object to show a modal prompt to the user.
//  This method will display the message using the Dialog.Prompt singleton object.<br>
//  Note: if this prompt is to be shown to the user during some slow JavaScript logic, we 
//  advise calling this method, then using +link{Class.delayCall()} or +link{Timer.setTimeout}
//  to kick off the slow logic in a separate thread. This ensures that the prompt is showing
//  before the lengthy execution begins.
//  
//
//	@param	message			(string)	message to display
//	@param	[properties]	(object)	additional properties for the Dialog, applied before
//                                       the Dialog is shown
//
// @visibility external
// @see Dialog.Prompt
// @group Prompting
//<
isc.addGlobal("showPrompt", function (message, properties) {
    var prompt = isc.Dialog.Prompt;
	if (!isc.isA.Dialog(prompt)) {
        var props = prompt;
		prompt = isc.Dialog.Prompt = isc.Dialog.create(prompt);
        // If we destroy() the prompt, this allows us to essentially 'reset' ourselves to a
        // state where calling this method again will create a new prompt from the original
        // set of properties.
        
        prompt._originalProperties = props;
	}
	isc.Dialog.Prompt.showMessage(message, properties);
});

//>	@classMethod	isc.clearPrompt()
//
//	Clear the modal prompt being shown to the user.
//
//  @group Prompting
//  @visibility external
//  @see Dialog.Prompt
//<
isc.addGlobal("clearPrompt", function () {
	if (!isc.isA.Dialog(isc.Dialog.Prompt)) return; // prompt has never been shown
	isc.Dialog.Prompt.clearMessage();
});


////////////////////////////////////////////////////////////////////////////////////////////


//>	@classAttr	Dialog.Warn (Dialog Properties : dialog instance properties : A)
//
// A singleton Dialog instance that will show text to the user and provide buttons for their
// response.  The Dialog will expand to show all the text that you put into it.<br>
// This can be used in cases where a developer would alternatively make use of the native
// JavaScript <code>alert()</code> and <code>confirm()</code> methods.  The main differences
// between those methods and using the Warn object are:<br>
// - The Warn object can be customized by modifying which buttons are visible, the style 
//   applied to it, etc.<br>
// - The <code>isc.ask()</code> and <code>isc.warn()</code> methods are asynchronous - rather 
//   than returning a value indicating the user's response, a callback method will be fired
//   when the user interacts with the dialog.<br><br>
//
// Notes:<br>
//  Because this is a singleton object, properties set on the Warn object directly will persist 
//  each time it is shown.<br>
//  Developers should use the <code>warn()</code> or <code>ask()</code> methods to show and
//  hide this object rather than manipulating the Dialog directly.
//  @group  Prompting
//  @visibility external
//  @see classMethod:isc.warn()
//  @see classMethod:isc.ask()
//<
isc.Dialog.Warn = {
	ID:"isc_globalWarn",
    _generated:true,
	width:400,
	height:60,	

	isModal:true,
	canDragReposition:true,
    keepInParentRect:true,
    
    autoDraw:false,	
    autoSize:true,
	autoCenter:true,
	
	toolbarButtons:[isc.Dialog.OK],
    message:"Your message here!",
    
    contentLayout:"horizontal",
    autoChildParentMap : isc.addProperties({}, isc.Window.getInstanceProperty("autoChildParentMap"),
    {
        stack : "body",
        iconImg : "body",
        blurb : "stack",
        toolbar : "stack"
    }),

    stackDefaults : {
        height:1
    },
    bodyDefaults: isc.addProperties({}, isc.Window.getInstanceProperty("bodyDefaults"),
    {
        layoutMargin:15,
        membersMargin:10
    }),
    toolbarDefaults : isc.addProperties({}, isc.Window.getInstanceProperty("toolbarDefaults"),
    {
        width:20,
        layoutAlign:"center"
    }),
    iconImgDefaults : { width:32, height:32 },

	createChildren : function () {
        // HACK: prevent toolbar from being created, since we want it placed in "stack", which
        // we can't create until Super.createChildren() creates the "body", which is "stack"'s
        // parent.
        this.showToolbar = false;
        this.Super("createChildren");
        this.addAutoChild("iconImg", null, isc.Img);
        this.addAutoChild("stack", null, isc.VStack);
        this.addAutoChild("blurb", {height:10}, isc.Label);
        this.showToolbar = true;
        this.makeToolbar();

        // can't be done via defaults because policy and direction are dynamically determined
        this.body.hPolicy = "fill";
    },

	//>	@method	Warn.showMessage()
	// Show a message in the Dialog
	//
	// Dialog will redraw and resize to show the entire message
	// any properties in attributes will get applied and may be visibily changed
	//
	//	@param	newMessage	(string)	message to display
	//	@param	attributes	(object)	object of name:value pairs to apply to the object
	//									properties are applied before the redraw
	//<
	showMessage : function (newMessage, properties) {

        this.message = newMessage;
        
        // first add the properties specified (NOTE: this will rebuild buttons, due to the
        // setButtons setter)
		this.setProperties(properties);

		// if no callback was specified, clear the Dialog callback
		if (properties.callback == null) delete this.callback;
        
        // Note: we lazily create children on draw, so verify that the items have been
        // initialized before manipulating the label
        if (!this._isInitialized) this.createChildren();

        // Update the label in the body
        this.blurb.setContents(this.message);

        if (this.icon) {
            this.iconImg.setSrc(this.getImgURL(this.icon));
            this.iconImg.show();
        } else this.iconImg.hide();

        // do immediate relayout so we don't wait for timers before we draw the new buttons,
        // especially because the destroy is immediate but the new draw is delayed, and in the
        // interim things react to the empty toolbar.
        this.toolbar.layoutChildren();
        // since we're going to try to autoCenter on show(), we go ahead and get all relayout
        // done now
        if (this.blurb.isDirty()) this.blurb.redraw();
        if (this.isDrawn()) {
            this.stack.layoutChildren();
            this.body.layoutChildren();
            this.layoutChildren();
        }

		this.show();

        // focus in the first button so you can hit Enter to do the default thing
        if (this.toolbar) {
            var firstButton = this.toolbar.getMember(0);
            /*
            this.logWarn("focusing on first button: " + firstButton + 
                         ", drawn: " + firstButton.isDrawn() +
                         ", disabled: " + firstButton.isDisabled() +
                         ", visible: " + firstButton.isVisible() +
                         ", canFocus: " + firstButton._canFocus());
            */
            firstButton.focus();
        }
	}
};

//> @classMethod isc.showMessage()
// Show a modal dialog with a message, icon, and response buttons.
//<
isc.addGlobal("showMessage", function (message, messageType, callback, properties) {
    
    if ((isc.isA.String(properties) || isc.isA.Function(properties)) ||
        (properties == null && isc.isAn.Object(callback) && callback.methodName == null && 
         callback.action == null && callback.method == null)) 
    {
        // swap arguments
        var realCallback = properties;
        properties = callback;
        callback = realCallback;
    }

	if (!isc.isA.Dialog(isc.Dialog.Warn)) isc.Dialog.Warn = isc.Dialog.create(isc.Dialog.Warn);
	if (!properties) properties = {};
    // messageType is one of
    // "confirm" (confirm dialog)
    // "ask" (ask dialog)
    // "say", "warn" (info / warn dialog)
    if (!properties.buttons) {
        if (messageType == "confirm") {
	        properties.buttons = [isc.Dialog.OK, isc.Dialog.CANCEL];
        } else if (messageType == "ask") {
	        properties.buttons = [isc.Dialog.YES, isc.Dialog.NO];
        } else {
	        properties.buttons = [isc.Dialog.OK];
        }
    }
    
    
    // Title: If specified in properties, respect it, otherwise show the
    // appropriate default title based on the dialog type
    if (!properties.title) {
        if (messageType == "confirm") properties.title = isc.Dialog.CONFIRM_TITLE;
        else if (messageType == "ask") properties.title = isc.Dialog.ASK_TITLE;
        else if (messageType == "warn") properties.title = isc.Dialog.WARN_TITLE;
        else properties.title = isc.Dialog.SAY_TITLE;
    }

    isc._applyDialogHandlers(properties);

    if (!properties.icon) properties.icon = isc.Dialog.getInstanceProperty(messageType+"Icon");
	if (callback) properties.callback = callback;
    
    isc.Dialog.Warn.showMessage(message, properties);
});

// shared with askForValue()
isc._applyDialogHandlers = function (properties) {
    
    var defaultHandlers = this._defaultHandlers = 
        this._defaultHandlers || ["okClick", "yesClick", "noClick", 
                                  "cancelClick", "closeClick", "applyClick"];
    for (var i = 0; i < defaultHandlers.length; i++) {
        var handlerName = defaultHandlers[i];
        if (!properties[handlerName]) {
            properties[handlerName] = isc.Dialog.getInstanceProperty(handlerName);
        }
    }
}

//>	@classMethod	isc.warn()
// Show a modal dialog with a message, icon, and "OK" button.
// <P>
// The callback will receive boolean true for an OK button click, or null if the Dialog is
// dismissed via the close button.
//
//	@param	message			(string)	message to display
//  @param  [callback]      (Callback)  Optional Callback to fire when the user 
//                                      dismisses the dialog. This has the single parameter
//                                      'value', indicating the value returned by the Warn
//                                      dialog from 'okClick()' etc.
//	@param	[properties]	(object)	additional properties for the Dialog.
//                                      To set +link{Dialog.toolbarButtons,custom buttons} for
//                                      the Dialog, set properties.buttons to an array of buttons
//										eg:	{ buttons : [Dialog.OK, Dialog.CANCEL] }
// @group Prompting
// @visibility external
// @see classAttr:Dialog.Warn
// @see classMethod:isc.say()
// @see classMethod:isc.ask()
// @see method:Dialog.okClick()
// @see classAttr:Dialog.WARN_TITLE
//<
isc.addGlobal("warn", function (message, callback, properties) {
    isc.showMessage(message, "warn", callback, properties);
});

//>	@classMethod	isc.say()
// Show a modal dialog with a message, icon, and "OK" button.  Intended for notifications which
// are not really warnings (default icon is less severe).
// <P>
// The callback will receive boolean true for an OK button click, or null if the Dialog is
// dismissed via the close button.
//
//	@param	message			(string)	message to display
//  @param  [callback]      (Callback)  Optional Callback to fire when the user 
//                                      dismisses the dialog. This has the single parameter
//                                      'value', indicating the value returned by the Warn
//                                      dialog from 'okClick()' etc.
//	@param	[properties]	(object)	additional properties for the Dialog.
//                                      To set +link{Dialog.toolbarButtons,custom buttons} for
//                                      the Dialog, set properties.buttons to an array of buttons
//										eg:	{ buttons : [Dialog.OK, Dialog.CANCEL] }
// @group Prompting
// @visibility external
// @see classAttr:Dialog.Warn
// @see classMethod:isc.warn()
// @see classMethod:isc.ask()
// @see method:Dialog.okClick()
// @see classAttr:Dialog.SAY_TITLE
//<
isc.addGlobal("say", function (message, callback, properties) {
    isc.showMessage(message, "say", callback, properties);
});


//>	@classMethod	isc.ask()
// Show a modal dialog with a message, icon, and "Yes" and "No" buttons.
// <P>
// The callback will receive boolean true for an OK button click, boolean false for a No button
// click, or null if the Dialog is dismissed via the close button.
//
//	@param	message			(string)	message to display
//  @param  [callback]      (Callback)  Callback to fire when the 
//                                      user clicks a button to dismiss the dialog.
//                                      This has the single parameter 'value', indicating the 
//                                      value returned by the Warn dialog from 'okClick()' etc.
//	@param	[properties]	(object)	additional properties for the Dialog.
//                                      To set +link{Dialog.toolbarButtons,custom buttons} for
//                                      the Dialog, set properties.buttons to an array of buttons
//										eg:	{ buttons : [Dialog.OK, Dialog.CANCEL] }
//
// @group Prompting
// @visibility external
// @see Dialog.Warn
// @see classMethod:isc.warn()
// @see method:Dialog.yesClick()
// @see method:Dialog.noClick()
// @see classAttr:Dialog.ASK_TITLE
// @example dialogs
//<
isc.addGlobal("ask", function (message, callback, properties) {
    isc.showMessage(message, "ask", callback, properties);
});

//>	@classMethod	isc.confirm()
// Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons.
// <P>
// The callback will receive boolean true for an OK button click, or null for a Cancel click or
// if the Dialog is dismissed via the close button.
// <P>
// Note: this does not override the native window.confirm() method.
//
//	@param	message			(string)	message to display
//  @param  [callback]      (Callback)  Callback to fire when the 
//                                      user clicks a button to dismiss the dialog.
//                                      This has the single parameter 'value', indicating the 
//                                      value returned by the Warn dialog from 'okClick()' etc.
//	@param	[properties]	(object)	additional properties for the Dialog.
//                                      To set +link{Dialog.toolbarButtons,custom buttons} for
//                                      the Dialog, set properties.buttons to an array of buttons
//										eg:	{ buttons : [Dialog.OK, Dialog.CANCEL] }
//
// @group Prompting
// @visibility external
// @see Dialog.Warn
// @see classMethod:isc.warn()
// @see method:Dialog.okClick()
// @see method:Dialog.cancelClick()
// @see classAttr:Dialog.CONFIRM_TITLE
// @example dialogs
//<
isc.confirm = function (message, callback, properties) {
    isc.showMessage(message, "confirm", callback, properties);
}

//> @classMethod isc.askForValue()
// Show a modal dialog with a text entry box, asking the user to enter a value.
// <P>
// As with other convenience methods that show Dialogs, such as +link{classMethod:isc.warn()},
// the dialog is shown and the function immediately returns.  When the user responds, the
// provided callback is called.
// <P>
// If the user clicks OK, the value typed in is passed to the callback (including the empty
// string ("") if nothing was entered.  If the user clicks cancel, the value passed to the
// callback is null.
// <P>
// A default value for the text field can be passed via <code>properties.defaultValue</code>.
// <P>
// Keyboard focus is automatically placed in the text entry field, and hitting the enter key is
// the equivalent of pressing OK.
//
//	@param	message			(string)	message to display
//  @param  [callback]      (Callback)  Callback to fire when the 
//                                      user clicks a button to dismiss the dialog.
//                                      This has the single parameter 'value', indicating the 
//                                      user entry, or null if cancel was pressed or the window
//                                      closed
//	@param	[properties]	(object)	additional properties for the Dialog.
//                                      To set +link{Dialog.toolbarButtons,custom buttons} for
//                                      the Dialog, set properties.buttons to an array of buttons
//										eg:	{ buttons : [Dialog.OK, Dialog.CANCEL] }
//
// @see method:Dialog.okClick()
// @see method:Dialog.cancelClick()
// @see classAttr:Dialog.ASK_FOR_VALUE_TITLE
// @group Prompting
// @visibility external
//<
isc.askForValue = function (message, callback, properties) {
    properties = properties || isc.emptyObject;

    var askDialog = isc.Dialog.Ask
    if (!askDialog) {
        var askForm = isc.DynamicForm.create({
            numCols:1, 
            padding:3,
            items: [
                { name:"message", type:"blurb" },
                { name:"value", showTitle:false, width:"*" }
            ],  
            // fire okClick on enter
            saveOnEnter:true,
            submit : function () { this.askDialog.okClick(); }
        });
        askDialog = isc.Dialog.Ask = isc.Dialog.create({
            items : [ askForm ],
            askForm: askForm,
            autoCenter:false,
            canDragReposition:true,
            isModal:true,
            // accomplishes vertical autoSizing
            bodyProperties : {overflow:"visible"},
            overflow:"visible"
        });
        askForm.askDialog = askDialog;

        // return the form value to the callback on okClick
        askDialog._okClickFunction = function () {
            this.clear();
            this.returnValue(this.askForm.getValue("value"));
        }
    }

    // copy properties and install defaults
    properties = isc.addProperties({
        callback: callback,
        title: properties.title || isc.Dialog.ASK_FOR_VALUE_TITLE,
        left: properties.left || "10%", 
        top: properties.top || "20%", 
        width: properties.width || "80%", 
        height: properties.height || 20,
        buttons: properties.buttons || [ isc.Dialog.OK, isc.Dialog.CANCEL ],
        okClick : properties.okClick || askDialog._okClickFunction
    }, properties);
    
    // have standard handlers added to properties
    isc._applyDialogHandlers(properties);

    askDialog.setProperties(properties);

    askDialog.askForm.setValues({ 
        message : message || "Please enter a value:", 
        value : properties.defaultValue || "" 
    });
    askDialog.show();
    askDialog.askForm.focusInItem("value");
}

//> @classMethod isc.showLoginDialog()
// Handle a complete login interaction with a typical login dialog asking for username and
// password credentials.
// <P>
// As with other convenience methods that show Dialogs, such as +link{classMethod:isc.warn()},
// the dialog is shown and the function immediately returns.  When the user responds, the
// provided callback function is called.
// <P>
// If the user clicks the "Log in" button, the credentials entered by the user are passed to
// the provided "loginFunc" as an Object with properties "username" and "password" (NOTE: both
// property names are all lowercase), as the variable "credentials".  For example:
// <pre>{ username: "barney", password: "rUbbL3" }</pre>
// <P>
// The "loginFunc" should then attempt to log in by whatever means is necessary.  The second
// parameter to the loginFunc, "dialogCallback", is a function, which must be called <i>whether
// login succeeds or fails</i> with a true/false value indicating whether login succeeded.
// <P>
// If the login dialog is dismissable (settable as properties.dismissable, default false) and
// the user dismisses it, the loginFunc will be fired with null for the credentials.
// <P>
// The following code shows typical usage.  This code assumes you have created a global
// function sendCredentials() that send credentials to some authentication system and fires a
// callback function with the result:
// <pre>
// isc.showLoginDialog(function (credentials, dialogCallback) {
//     if (credentials == null) return; // dismissed
//
//     // send credentials    
//     sendCredentials(credentials, function (loginSucceeded) {
//         // report success or failure
//         dialogCallback(loginSucceeded);
//     })
// })
// </pre>
// The login dialog has several built-in behaviors:
// <ul>
// <li> keyboard focus is automatically placed in the username field
// <li> hitting enter in the username field proceeds to the password field
// <li> hitting enter in the password field submits (fires the provided callback)
// </ul>
// In addition to normal properties supported by Dialog/Window, the following special
// properties can be passed:
// <ul>
// <li><code>username</code>: initial value for the username field
// <li><code>password</code>: initial value for the password field
// <li><code>usernameTitle</code>: title for the username field
// <li><code>passwordTitle</code>: title for the password field
// <li><code>errorMessage</code>: default error message on login failure
// <li><code>loginButtonTitle</code>: title for the login button
// <li><code>dismissable</code>: whether the dialog can be dismissed, default false
// <li><code>errorStyle</code>: CSS style for the error message, if shown
// </ul>
// See below for links to the default values for these properties.
//
//  @param  loginFunc       (Callback)  Function to call to attempt login.  Recieves parameters
//                                      "credentials" and "dialogCallback", described above
//	@param	[properties]	(Dialog properties)	additional properties for the Dialog
//
// @see classAttr:Dialog.LOGIN_TITLE
// @see classAttr:Dialog.USERNAME_TITLE
// @see classAttr:Dialog.PASSWORD_TITLE
// @see classAttr:Dialog.LOGIN_BUTTON_TITLE
// @see classAttr:Dialog.LOGIN_ERROR_MESSAGE
// @group Prompting
// @visibility external
//<
isc.showLoginDialog = function (loginFunc, properties) {
    properties = properties || isc.emptyObject;

    var loginDialog = isc.Dialog.Login;
    if (!loginDialog) {
        var loginForm = isc.DynamicForm.create({
            numCols: 2,
            padding: 4,
            autoDraw: false,
            fields : [
                { name:"loginFailure", type:"blurb", colSpan: 2, visible:false },
                { name:"username", 
                  keyPress : function (item, form, keyName) {
                    if (keyName == "Enter") {
                        form.focusInItem("password");
                        return false;
                    }
                }},
                { name:"password", type:"password" },
                { type:"button", name:"loginButton", type:"submit" }
            ],
            saveOnEnter:true,
            submit : function () {
                var loginForm = this,
                    params = [{
                        username : this.getValue("username"), 
                        password : this.getValue("password")
                    }];

                params[1] = function (success) {
                    if (success) {
                        loginForm.complete(); // report success
                    } else {
                        // failed login attempt - indicate failure, remain visible
                        loginForm.showItem("loginFailure");
                        loginForm.focusInItem("password");
                    }
                };
            
                this.fireCallback(this.loginFunc, "credentials,dialogCallback", params);
            },
            complete : function (dismissed) {
                this.loginDialog.hide();
                // reset for next time
                this.setValue("username", "");
                this.setValue("password", "");    
                this.hideItem("loginFailure");
                
                // if this was a dismissal, tell the loginFunc
                if (dismissed) {
                    this.fireCallback(this.loginFunc, "credentials,dialogCallback");
                }
            }
        });
        isc.Dialog.Login = loginDialog = isc.Window.create({
            autoDraw:false,
            autoCenter: true,
            autoSize: true,
            isModal: true,
            loginForm : loginForm,
            showMinimizeButton:false,
            items: [ loginForm ],
            cancelClick : function () { this.loginForm.complete(true) }
        });
        loginForm.loginDialog = loginDialog;
    }

    var loginForm = loginDialog.loginForm;

    // handle general dialog-level properties and defaults
    properties = isc.addProperties({
        title : properties.title || isc.Dialog.LOGIN_TITLE
    }, properties);
    // have standard handlers added to properties
    isc._applyDialogHandlers(properties);
    loginDialog.setProperties(properties);


    // handle dismissability
    var dismissable = properties.dismissable != null ? properties.dismissable : false;
    loginDialog.dismissOnEscape = dismissable;
    loginDialog.setShowCloseButton(dismissable);


    // handle initial value
    loginForm.setValue("username", properties.username || "");
    loginForm.setValue("password", properties.password || "");    


    // allow field retitling
    loginForm.getItem("loginFailure").cellStyle = 
            properties.errorStyle || "formCellError";
    loginForm.getItem("username").title = 
            properties.usernameTitle || isc.Dialog.USERNAME_TITLE;
    loginForm.getItem("password").title = 
            properties.passwordTitle || isc.Dialog.PASSWORD_TITLE;
    loginForm.getItem("loginButton").setTitle(
            properties.loginButtonTitle || isc.Dialog.LOGIN_BUTTON_TITLE);
    loginForm.markForRedraw();

    // set up to try login until success or dismissal
    loginForm.loginFunc = loginFunc;
    loginForm.setValue("loginFailure", properties.errorMessage || isc.Dialog.LOGIN_ERROR_MESSAGE);

    // show the dialog with initial focus in username field
    loginDialog.show(); 
    loginForm.focusInItem("username");
}


// NOTE: unfinished dialog to confirm save when closing / exiting an application, or otherwise
// dropping edits.
// Typical Windows buttons: [*Yes*, No, Cancel]
// Typical Mac buttons: [Don't Save, separator, Cancel, *Save*]
/*
isc.confirmSave = function (message, callback, properties) {
    isc.confirm(message || isc.Dialog.saveChangesMessage, {
                    buttons:[isc.Dialog.OK,
                             {title:"Save", width:75,
                              click:"this.hide();this.topElement.returnValue('save');"},
                             isc.Dialog.CANCEL]
                }
                );
}
*/
