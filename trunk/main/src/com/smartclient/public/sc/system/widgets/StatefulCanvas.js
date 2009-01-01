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

 






//>	@class	StatefulCanvas
// A component that has a set of possible states, and which presents itself differently according to
// which state it is in.  An example is a button, which can be "up", "down", "over" or "disabled".
// 
// @treeLocation Client Reference/Foundation
// @visibility external
//<
isc.ClassFactory.defineClass("StatefulCanvas", "Canvas");

	//>	@groupDef	state
	// Change of state and it's consequences for presentation.
	//<
isc.StatefulCanvas.addClassProperties({

	//>	@type	State
    // Constants for the standard states for a StatefulCanvas.  
	//			@group	state
	STATE_UP:"",				//	@value	StatefulCanvas.STATE_UP         state when mouse is not acting on this StatefulCanvas
	STATE_DOWN:"Down",			//	@value	StatefulCanvas.STATE_DOWN       state when mouse is down
    STATE_OVER:"Over",			//	@value	StatefulCanvas.STATE_OVER		state when mouse is over
    STATE_DISABLED:"Disabled",	//	@value	StatefulCanvas.STATE_DISABLED	disabled
    // @visibility external
	//<
	
	//>	@type	SelectionType	
    // Controls how an object changes state when clicked
	// @group	state
	// @group	event handling
    //	@value	StatefulCanvas.BUTTON	object moves to "down" state temporarily (normal button) 
    //	@value	StatefulCanvas.CHECKBOX object remains in "down" state until clicked again (checkbox)
    //	@value	StatefulCanvas.RADIO	object moves to "down" state, causing another object to go up (radio)
	BUTTON:"button",	
	CHECKBOX:"checkbox",
	RADIO:"radio",		
    // @visibility external
	//<	
	
	//>	@type	Selected
	//			@group	state
    FOCUSED:"Focused",          //  @value  StatefulCanvas.FOCUSED  StatefulCanvas should show
                                // focused state  
	SELECTED:"Selected",		//	@value	StatefulCanvas.SELECTED		StatefulCanvas is selected
	UNSELECTED:"",				//	@value	StatefulCanvas.UNSELECTED   StatefulCanvas is not selected
	// @visibility external
	//<	
    
    // Internal map of radioGroup ID's to arrays of widgets
    _radioGroups:{}
});


isc.StatefulCanvas.addProperties({

    //>	@attr	statefulCanvas.title		(string : varies : [IRW])
    // The text title to display in this button.
    // @group basics
    // @visibility external
    //<
    
    //>@attr StatefulCanvas.hiliteAccessKey (boolean : null : [IRWA])
    // If set to true, if the +link{statefulCanvas.title, title} of this button contains the
    // specified +link{canvas.accessKey, accessKey}, when the title is displayed to the user
    // it will be modified to include HTML to underline the accessKey.<br>
    // Note that this property may cause titles that include HTML (rather than simple strings)
    // to be inappropriately modified, so should be disabled if your title string includes
    // HTML characters.
    // @visibility internal
    //<
								
    // State-related properties
    // -----------------------------------------------------------------------------------------------

    //>	@attr	statefulCanvas.redrawOnStateChange		(boolean : false : IRWA)
	// Whether this widget needs to redraw to reflect state change
	// @group	state
    // @visibility external
	//<

    //>	@attr	statefulCanvas.selected		(boolean : false : IRW)
	// Whether this component is selected.  For some components, selection affects appearance.
	// @group	state
    // @visibility external
	//<

    //>	@attr	statefulCanvas.state		(State : "" : IRWA)
	// Current "state" of this widget. StatefulCanvases will have a different appearance based
    // on their current state. By default this is handled by changing the css className applied to
    // the StatefulCanvas - see +link{StatefulCanvas.baseStyle} for a description of how this is
    // done.<P>
    // For +link{class:Img} or +link{class:StretchImg} based subclasses of StatefulCanvas, the 
    // appearance may also be updated by changing the src of the rendered image. See
    // +link{Img.src} and +link{StretchImgButton.src} for a description of how the URL 
    // is modified to reflect the state of the widget in this case.
    // 
    // @see type:State
    // @see group:state
	// @group	state
    // @visibility external
	//<
	state:"",

    //>	@attr	statefulCanvas.showRollOver		(boolean : false : IRW)
	// Should we visibly change state when the mouse goes over this object?
	// @group	state
    // @visibility external
	//<	

    //>	@attr	statefulCanvas.showFocus        (boolean : false : IRW)
	// Should we visibly change state when the canvas recieves focus?  Note that by default the
    // <code>over</code> state is used to indicate focus.
	// @group	state
    // @deprecated as of SmartClient version 6.1 in favor of +link{statefulCanvas.showFocused}
    // @visibility external
	//<	

    //>	@attr	statefulCanvas.showFocused        (boolean : false : IRW)
	// Should we visibly change state when the canvas recieves focus?  If
    // +link{statefulCanvas.showFocusedAsOver} is <code>true</code>, the <b><code>"over"</code></b>
    // will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state
    // will be used.
	// @group	state
    // @visibility external
	//<

    //> @attr statefulCanvas.showFocusedAsOver (boolean : true : IRW) 
    // If +link{StatefulCanvas.showFocused,showFocused} is true for this widget, should the 
    // <code>"over"</code> state be used to indicate the widget as focused. If set to false,
    // a separate <code>"focused"</code> state will be used.
    // @group state
    // @visibility external
    //<
    showFocusedAsOver: true,
    
    
    
	//>	@attr	statefulCanvas.showDown		(boolean : false : IRW)
	// Should we visibly change state when the mouse goes down in this object?
	//		@group	state
    // @visibility external
	//<	

	//>	@attr	statefulCanvas.showDisabled  (boolean : true : IRW)
	// Should we visibly change state when disabled?
	//		@group	state
    // @visibility external
	//<	
    showDisabled:true,

	//>	@attr	statefulCanvas.actionType		(SelectionType : "button": IRW)
	// Behavior on state changes -- BUTTON, RADIO or CHECKBOX
	//		@group	state
	//		@group	event handling
    //      @setter setActionType()
    //      @getter getActionType()
    // @visibility external
	//<
    actionType:"button",
    
	//>	@attr	statefulCanvas.radioGroup   (string : null : IRWA)
	// String identifier for this canvas's mutually exclusive selection group.
	//		@group	state
	//		@group	event handling
    // @visibility external
	//<

	//>	@attr	statefulCanvas.baseStyle		(CSSStyleName : null : IRW)
	// Base CSS style.  As the component changes state and/or is selected, suffixes will be
    // added to the base style.
    // <P>
    // When the component changes state (eg becomes disabled), a suffix will be appended to this
    // style name, reflecting the following states: "Over", "Down", or "Disabled".
    // <P>
    // If the widget is selected, the suffixes will be "Selected", "SelectedOver", etc.
    // <P>
    // If the widget has focus and +link{StatefulCanvas.showFocused} is true, and
    // +link{StatefulCanvas.showFocusedAsOver} is false, the suffixes will be "Focused",
    // "FocusedOver", etc, or if the widget is both selected and focused, "SelectedFocused",
    // "SelectedFocusedOver", etc.
    // <P>
    // For example, if <code>baseStyle</code> is set to "button", this component is
    // +link{isSelected,selected} and the mouse cursor is over this component, the style
    // "buttonSelectedOver" will be used. 
    // 
    // @visibility external
	//<							
	
	
	//>	@attr	statefulCanvas.cursor		(Cursor : Canvas.ARROW : IRW)
	//			Specifies the cursor to show when over this canvas.
	//			See Cursor type for different cursors.
	//		@group	cues
	//		@platformNotes	Nav4	Cursor changes are not available in Nav4
	//<
	cursor:isc.Canvas.ARROW,

    //>	@attr	statefulCanvas._savedCursor		(Cursor : null : IRWA)
	//			Any special cursor for this canvas is deactivated when this
	//			canvas is disable()'d. So, we keep that cursor setting here
	//			so that if and when the canvas is enabled() once again, it
	//			will have the proper cursor.
	//		@group	state, event handling
	//<		
	//_savedCursor:null,

    // Image-based subclasses
    // ---------------------------------------------------------------------------------------
    capSize:0,

    //> @attr statefulCanvas.showTitle (boolean : false : [IRWA])
    // Determines whether any specified +link{statefulCanvas.getTitle(), title} will be 
    // displayed for this component.<br>
    // Applies to Image-based components only, where the title will be rendered out in a label
    // floating over the component
    // @visibility internal
    //<
    // Really governs whether a label canvas is created to contain the title.
    // Exposed on img based subclasses only as some statefulCanvas subclasses will support
    // displaying the title without a label canvas
    //showTitle:false,

    //>	@attr	statefulCanvas.align		(Alignment : isc.Canvas.CENTER : [IRW])
    // Horizontal alignment of this component's title.
    // @group appearance
    // @visibility external
    //<
	align:isc.Canvas.CENTER,

    //>	@attr	statefulCanvas.valign		(VerticalAlignment : isc.Canvas.CENTER : [IRW])
    // Vertical alignment of this component's title.
    // @group appearance
    // @visibility external
    //<
	valign:isc.Canvas.CENTER,

    //> @attr StatefulCanvas.autoFit  (boolean : null : IRW)
    // If true, ignore the specified size of this widget and always size just large
    // enough to accomodate the title.  If <code>setWidth()</code> is explicitly called on an
    // autoFit:true button, autoFit will be reset to <code>false</code>.
    // <P>
    // Note that for StretchImgButton instances, autoFit will occur horizontally only, as 
    // unpredictable vertical sizing is likely to distort the media. If you do want vertical 
    // auto-fit, this can be achieved by simply setting a small height, and having 
    // overflow:"visible"
    // @setter StatefulCanvas.setAutoFit()
    // @group sizing
    // @visibility external
    //<
    //autoFit:null
    
    // autoFitDirection: Undocumented property determining whether we should auto-fit
    // horizontally, vertically or in both directions
    // Options are "both", "horizontal", "vertical"
    autoFitDirection:isc.Canvas.BOTH,

    //        
    // Button properties - managed here and @included from Button, ImgButton and
    // StatefulImgBuggon
	// =================================================================================
    
    // Icon (optional)
	// ---------------

    //> @attr statefulCanvas.icon           (SCImgURL : null : [IR])
    // Optional icon to be shown with the button title text.  
    // <P>
    // Specify as the partial URL to an image, relative to the imgDir of this component.
    // @group buttonIcon
    // @visibility external
    //<

    //> @attr statefulCanvas.iconSize       (integer : 16 : [IR])
    // Size in pixels of the icon image.
    // <P>
    // The <code>iconWidth</code> and <code>iconHeight</code> properties can be used to
    // configure width and height separately.
    //
    // @group buttonIcon
    // @visibility external
    //<
    iconSize:16,
    
    //> @attr statefulCanvas.iconWidth      (integer : null : [IR])
    // Width in pixels of the icon image.
    // <P>
    // If unset, defaults to <code>iconSize</code>
    //
    // @group buttonIcon
    // @visibility external
    //<

    //> @attr statefulCanvas.iconHeight     (integer : null : [IR])
    // Height in pixels of the icon image.
    // <P>
    // If unset, defaults to <code>iconSize</code>
    //
    // @group buttonIcon
    // @visibility external
    //<

    //> @attr statefulCanvas.iconOrientation     (string : "left" : [IR])
    // If this button is showing an icon should it appear to the left or right of the title?
    // valid options are <code>"left"</code> and <code>"right"</code>.
    //
    // @group buttonIcon
    // @visibility external
    //<
    iconOrientation:"left",

    //> @attr statefulCanvas.iconAlign     (string : null : [IR])
    // If this button is showing an icon should it be right or left aligned?
    //
    // @group buttonIcon
    // @visibility internal
    //<
    // Behavior is as follows - if iconOrientation and iconAlign are both left or both right we
    // write the icon out at the extreme right or left of the button, and allow the title to 
    // aligned independantly of it. (otherwise the icon and the text will be adjacent, and 
    // aligned together based on the button's "align" property.
    

    //> @attr statefulCanvas.iconSpacing   (integer : 6 : [IR])
    // Pixels between icon and title text.
    //
    // @group buttonIcon
    // @visibility external
    //<
    iconSpacing:6,

    // internal: controls whether we apply any state to the icon at all 
    showIconState: true,

    //> @attr statefulCanvas.showDisabledIcon   (boolean : true : [IR])
    // If using an icon for this button, whether to switch the icon image if the button becomes
    // disabled.
    //
    // @group buttonIcon
    // @visibility external
    //<
    showDisabledIcon:true,

    //> @attr statefulCanvas.showRollOverIcon   (boolean : false : [IR])
    // If using an icon for this button, whether to switch the icon image on mouse rollover.
    //
    // @group buttonIcon
    // @visibility external
    //<
    
    //> @attr statefulCanvas.showDownIcon       (boolean : false : [IR])
    // If using an icon for this button, whether to switch the icon image when the mouse goes
    // down on the button.
    //
    // @group buttonIcon
    // @visibility external
    //<

    //> @attr statefulCanvas.showSelectedIcon   (boolean : false : [IR])
    // If using an icon for this button, whether to switch the icon image when the button
    // becomes selected.
    //
    // @group buttonIcon
    // @visibility external
    //<
    
    //> @attr StatefulCanvas.showFocusedIcon (boolean : false : [IR])
    // If using an icon for this button, whether to switch the icon image when the button
    // recieves focus.
    // <P>
    // If +link{statefulCanvas.showFocusedAsOver} is true, the <code>"Over"</code> icon will be
    // displayed when the canvas has focus, otherwise a seperate <code>"Focused"</code> icon
    // will be displayed
    // @group buttonIcon
    // @visibility external
    //<   
    
    //> @attr statefulCanvas.showOverCanvas (boolean  : false : [IRWA])
    // When this property is set to true, this widget will create and show the
    // +link{StatefulCanvas.overCanvas} on user rollover.
    // @visibility external
    //<
    
    //> @attr statefulCanvas.overCanvas (AutoChild : null : [R])
    // Auto generated child widget to be shown when the user rolls over this canvas if 
    // +link{StatefulCanvas.showOverCanvas} is true. See documentation for +link{type:AutoChild}
    // for information on how to customize this canvas.
    // @visibility external
    //<
    
    //> @attr statefulCanvas.overCanvasConstructor (String : "Canvas" : [IRWA])
    // Constructor class name for this widgets +link{statefulCanvas.overCanvas,overCanvas}
    // @visibility external
    //<
    overCanvasConstructor: "Canvas",
    
    //> @attr statefulCanvas.overCanvasDefaults (Canvas : { ... } : [IRWA])
    // Default properties for this widgets +link{statefulCanvas.overCanvas,overCanvas}. To modify
    // these defaults, use +link{Class.changeDefaults()} 
    // @visibility external
    //<
    overCanvasDefaults: {
        // override mouseOut to hide this canvas if the user rolls off it and out of the
        // parent/constructor
        mouseOut:function () {
            if (isc.EH.getTarget() != this.creator) this.clear();
            return this.Super("mouseOut", arguments);
        }
    }
     

});

isc.StatefulCanvas.addMethods({

//>	@method	statefulCanvas.init()	(A)
// Initialize this StatefulCanvas. Pass in objects with properties to add or override defaults.
//
//		@param	[all arguments]	(object)	objects with properties to override from default
//<
initWidget : function () {

    
    if (this.src == null) this.src = this.vertical ? this.vSrc : this.hSrc;

    var isEnabled = !this.isDisabled();

	// the enabled property also affects the state of this object
	if (!isEnabled) {
        this._enabledState = this.state;
        this.state = isc.StatefulCanvas.STATE_DISABLED;
    }
	
    // if className has been specified and baseStyle has no default, copy className to
    // baseStyle.  This is needed for the Label where you are expected to set className, not
    // baseStyle.
    // From then on the current className will be derived from the baseStyle setting plus the
    // current state, unless the widget suppresses className, which it may do if it has another
    // element the receives the baseStyle, and it leaves the handle unstyled.
    this.baseStyle = this.baseStyle || this.className;
    this.styleName = (this.suppressClassName ? null : this.getStateName());
    this.className = this.styleName;
    
    // If this button has a radioGroup ID specified, update the array of widgets in the
    // radiogroup to include this one.
    if (this.radioGroup != null) {

        var rg = this.radioGroup;
        // clear out the property to avoid a no-op, then add with the standard setter    
        this.radioGroup = null;
        this.addToRadioGroup(rg);
    }
    
    // Initialize autoFit
    this.setAutoFit(this.autoFit, true);

    if (this.shouldShowLabel()) this.makeLabel();
},

//> @method StatefulCanvas.shouldShowLabel()
// Should this widget create a floating label for textual content - used for image based widgets.
// Default implementation returns this.showTitle
// @return (boolean) true if the floating label should be created
//<
shouldShowLabel : function () {
    return this.showTitle;
    
},

// State
// ------------------------------------------------------------------------------------------------------
// set the state for this object, and whether or not it is selected

_$visualState:"visualState",
stateChanged : function () {
    
    if (this.destroyed) return;

    if (this.logIsDebugEnabled(this._$visualState)) {
        this.logDebug("state changed to: " + this.getStateName(), "visualState");
    }

    if (this.redrawOnStateChange) {
        this.markForRedraw("state change");
    }
    // NOTE: a redraw doesn't update className
    if (!this.suppressClassName) {
        this.setClassName(this.getStateName());
    }

	// set our label to the same state (note it potentially has independant styling)
    var label = this.label;
	if (label != null) {
        label.setState(this.getState());
        label.setSelected(this.isSelected());
        label.setCustomState(this.getCustomState());
    }
},

//>	@method statefulCanvas.setBaseStyle()
// Sets the base CSS style.  As the component changes state and/or is selected, suffixes will be
// added to the base style.
// @visibility external
// @param style (className) new base style
//<		
setBaseStyle : function (style) {
    this.baseStyle = style;
    if (this.label && this.titleStyle == null) this.label.setBaseStyle(style);
    // fall through to stateChanged to actually update the appearance
    this.stateChanged();
},


setTitleStyle : function (style) {
    this.titleStyle = style;
    if (this.label) {
        this.label.setBaseStyle(style || this.baseStyle);
    }
    this.stateChanged();
},

//>	@method	statefulCanvas.setState()	(A)
// Set the 'state' of this object, this changes it's appearance.
//
//		@group	state
//      @group appearance
//
//		@see 	setDisabled() which also affects state values.
//
//		@param	newState		(State)	new state
// @visibility external
//<
setState : function (newState) {
	if (this.state == newState) return;
	this.state = newState;
    this.stateChanged();    // update the appearance - redraw if necessary
},

_updateChildrenTopElement : function () {
    this.Super("_updateChildrenTopElement", arguments);
    this.setHandleDisabled(this.isDisabled());
},

//>	@method	statefulCanvas.getState()	(A)
// Return the state of this StatefulCanvas
//		@group	state
//
// @visibility external
// @return (State)
//<
getState : function () {
	return this.state;
},

//>	@method	statefulCanvas.setSelected()
// Set this object to be selected or deselected.
//		@group	state
//
//		@param	newIsSelected	(boolean)	new boolean value of whether or not the object is
//                                          selected.
// @visibility external
//<
setSelected : function (newIsSelected) {
	if (this.selected == newIsSelected) return;

    // handle mutually exclusive radioGroups
    if (newIsSelected && this.radioGroup != null) {
        var groupArray = isc.StatefulCanvas._radioGroups[this.radioGroup];
        // catch the (likely common) case of this.radioGroup being out of synch - implies
        // a developer has assigned directly to this.radioGroup without calling the setter
        if (groupArray == null) {
            this.logWarn("'radioGroup' property set for this widget, but no corresponding group " +
                         "exists. To set up a new radioGroup containing this widget, or add this " +
                         " widget to an existing radioGroup at runtime, call 'addToRadioGroup(groupID)'");
        } else {
            for (var i = 0; i < groupArray.length; i++) {
                if (groupArray[i]!= this && groupArray[i].isSelected()) 
                    groupArray[i].setSelected(false);
            }
        }
    }

	this.selected = newIsSelected;

    if (this.label) this.label.setSelected(this.isSelected());

    this.stateChanged();
},

//>	@method	statefulCanvas.select()
// Select this object.
//		@group	state
// @visibility external
//<
select : function () {
	this.setSelected(true);
},

//>	@method	statefulCanvas.deselect()
// Deselect this object.
//		@group	state
// @visibility external
//<
deselect : function () {
	this.setSelected(false);
},

//>	@method	statefulCanvas.isSelected()
// Find out if this object is selected
//		@group	state
//		@return (boolean)
// @visibility external
//<
isSelected : function () {
	return this.selected;
},

// actionType - determines whether the button will select / deselect on activation

//>	@method	statefulCanvas.getActionType() (A)
// Return the 'actionType' for this canvas (radio / checkbox / button)
//      @group  state
//      @group event handling
//      @visibility external
//<
getActionType : function () {
    return this.actionType;
},

//>	@method	statefulCanvas.setActionType() (A)
// Update the 'actionType' for this canvas (radio / checkbox / button)
// If the canvas is currently selected, and the passed in actionType is 'button'
// this method will deselect the canvas.
//      @group  state
//      @group event handling
//      @visibility external
//<
setActionType : function (actionType) {
    if (actionType == isc.StatefulCanvas.BUTTON && this.isSelected()) {
        this.setSelected(false);
    }
    this.actionType = actionType;
},

// radioGroups - automatic handling for mutually exclusive selection behavior between buttons

//>	@method	statefulCanvas.addToRadioGroup(groupID) (A)
// Add this widget to the specified mutually exclusive selection group with the ID
// passed in.
// Selecting this widget will then deselect any other StatefulCanvases with the same
// radioGroup ID.
// StatefulCanvases can belong to only one radioGroup, so this method will remove from 
// any other radiogroup of which this button is already a member.
//      @group  state
//      @group event handling
//      @param  groupID (string)    - ID of the radiogroup to which this widget should be added
//      @visibility external
//<
addToRadioGroup : function (groupID) {
    // Bail if groupID is null, or if we already belong to the specified group, so we don't 
    // get duplicated in the array
    if (groupID == null || this.radioGroup == groupID) return;
    
    if (this.radioGroup != null) this.removeFromRadioGroup();

    this.radioGroup = groupID;
    
    // update the widget array for the specified group (stored on the Class object)
    if (isc.StatefulCanvas._radioGroups[this.radioGroup] == null) {
        isc.StatefulCanvas._radioGroups[this.radioGroup] = [this];
    } else {
        isc.StatefulCanvas._radioGroups[this.radioGroup].add(this);
    }
    
},

//>	@method	statefulCanvas.removeFromRadioGroup(groupID) (A)
// Remove this widget from the specified mutually exclusive selection group with the ID
// passed in.
// No-op's if this widget is not a member of the groupID passed in.
// If no groupID is passed in, defaults to removing from whatever radioGroup this widget
// is a member of.
//      @group  state
//      @group event handling
//      @visibility external
//      @param  [groupID]   (string)    - optional radio group ID (to ensure the widget is removed
//                                        from the appropriate group.
//<
removeFromRadioGroup : function (groupID) {
    // if we're passed the ID of a group we're not a member of, just bail
    if (this.radioGroup == null || (groupID != null && groupID != this.radioGroup)) return;
    
    var widgetArray = isc.StatefulCanvas._radioGroups[this.radioGroup];
    
    widgetArray.remove(this);
    
    delete this.radioGroup;
    
},

// Enable/Disable
// ------------------------------------------------------------------------------------------------------
//	to have an object redraw when it's enabled, set:
//		.redrawOnDisable = true

//>	@method	statefulCanvas.setDisabled()	(A)
// Enable or disable this object
//		@group enable, state
//
//	@param	disabled (boolean) true if this widget is to be disabled
// @visibility external
//<
setHandleDisabled : function (disabled,b,c,d) {
	this.invokeSuper(isc.StatefulCanvas, "setHandleDisabled", disabled,b,c,d);

    if (!this.showDisabled) return;

	// clear/restore the cursor and set the StatefulCanvas.STATE_DISABLED/StatefulCanvas.STATE_UP states.
    var handleIsDisabled = (this.state == isc.StatefulCanvas.STATE_DISABLED);
    if (handleIsDisabled == disabled) return;
    
	if (disabled == false) {
		if (this._savedCursor) this.setCursor(this._savedCursor);
        var enabledState = this._enabledState || isc.StatefulCanvas.STATE_UP;
		this.setState(enabledState);
	} else {
		this._savedCursor = this.cursor;
		this.setCursor(isc.StatefulCanvas.ARROW);
        // hang onto the enable state so that when we're next enabled we can reset to it.
        this._enabledState = this.state;
		this.setState(isc.StatefulCanvas.STATE_DISABLED);
	}	
},


// CSS Style methods
// ------------------------------------------------------------------------------------------
// methods that allow style to change according to state.

//>	@method	statefulCanvas.getStateName()	(A)
// Get the CSS styleName that should currently be applied to this component, reflecting
// <code>this.baseStyle</code> and the widget's current state.
// <P>
// NOTE: this can differ from the style currently showing if the component has not yet updated
// it's visual state after a state change.
// 
//		@group	appearance
//		@return	(CSSStyleName)	name of the style to set the StatefulCanvas to
//<
getStateName : function () {
    var modifier = this.getStateSuffix();
    if (modifier) return this.baseStyle + modifier;
    return this.baseStyle;
},

//>	@method	statefulCanvas.getStateSuffix	
// Returns the suffix that will be appended to the +link{StateFulCanvas.baseStyle}  
// as the component changes state and/or is selected.
// <P>
// When the component changes state (eg becomes disabled), a suffix will be appended to this
// style name, reflecting the following states: "Over", "Down", or "Disabled".
// <P>
// If the widget is selected, the suffixes will be "Selected", "SelectedOver", etc.
// <P>
// If the widget has focus and +link{StatefulCanvas.showFocused} is true, and
// +link{StatefulCanvas.showFocusedAsOver} is false, the suffixes will be "Focused",
// "FocusedOver", etc, or if the widget is both selected and focused, "SelectedFocused",
// "SelectedFocusedOver", etc.
// <P>
// For example, if <code>baseStyle</code> is set to "button", this component is
// +link{isSelected,selected} and the mouse cursor is over this component, the style
// "buttonSelectedOver" will be used. 
// 
// @visibility external
//<						
getStateSuffix : function () {
    var state = this.getState(),
        selected = this.isSelected() ? isc.StatefulCanvas.SELECTED : null,
        focused = this.getFocusedState() ? isc.StatefulCanvas.FOCUSED : null,
        customState = this.getCustomState();
    return this._getStateSuffix(state,selected,focused,customState);
},

_getStateSuffix : function (state, selected, focused, customState) {

    var modifier;
    if (selected || focused) {
        modifier = (selected && focused) ? this._$SelectedFocused : 
                                                selected ? selected : focused; 
    }        
    if (!customState) {
        if (modifier) return state ? modifier + state : modifier;
        else return state;
    } else if (modifier) {
        return state ? modifier + state + customState : modifier + customState;
    } else {
        return state ? state + customState : customState;
    }
},
_$SelectedFocused:"SelectedFocused",

setCustomState : function (customState) { 
    if (customState == this.customState) return;
    this.customState = customState;
    if (this.label) this.label.customState = customState;
    this.stateChanged();
},
getCustomState : function () { return this.customState },

// Override getPrintStyleName to pick up the current stateName rather than this.styleName which
// may have been cleared (EG suppressClassName is true)
getPrintStyleName : function () {
    return this.printStyleName || this.getStateName();
},

// Label
// ---------------------------------------------------------------------------------------

labelDefaults : {
    _canFocus: function () { return this.masterElement._canFocus(); },
    focusChanged : function (hasFocus) {
        if (this.hasFocus) this.eventProxy.focus();
    },
            
    getContents : function () { return this.masterElement.getTitleHTML() }, 

    // override adjustOverflow to notify us when this has it's overflow changed
    // (probably due to 'setContents')
    adjustOverflow : function (a,b,c,d) {
        this.invokeSuper(null, "adjustOverflow", a,b,c,d);
        this.masterElement._labelAdjustOverflow();
    }
},
 
_$label : "label",   
makeLabel : function () {
    var labelClass = this.getAutoChildClass(this._$label, null, isc.Label);

    var label = this.label = labelClass.createRaw();

    label.align = this.align;
    label.valign = this.valign;

    label._resizeWithMaster = false;
    label._redrawWithMaster = false;
    label._redrawWithParent = false;
    
    // icon-related
    label.icon = this.icon;
    label.iconWidth = this.iconWidth;
    label.iconHeight = this.iconHeight;
    label.iconSize = this.iconSize;
    label.iconOrientation = this.iconOrientation;
    label.iconAlign = this.iconAlign;
    label.iconSpacing = this.iconSpacing;
    label.showDownIcon = this.showDownIcon;
    label.showSelectedIcon = this.showSelectedIcon;
    label.showRollOverIcon = this.showRollOverIcon;
    label.showFocusedIcon = this.showFocusedIcon;
    label.showDisabledIcon = this.showDisabledIcon;
    if (this.showIconState != null) label.showIconState = this.showIconState;
    
    // If we show 'focused' state, have our label show it too.
    label.getFocusedState = function () {
        var button = this.masterElement;
        if (button && button.getFocusedState) return button.getFocusedState();
    }
    
    // see ScreenReader.js   
    label.waiRole = this.waiRole;
    
    
    label.baseStyle = this.titleStyle || this.baseStyle;
    label.state = this.getState();
    label.customState = this.getCustomState();
    
    // default printStyleName to this.printStyleName
    label.getPrintStyleName = function () {
        return this.masterElement.getPrintStyleName();
    }

    // if we're set to overflow:visible, that means the label should set to overflow:visible
    // and we should match its overflowed size
    label.overflow = this.overflow;

    
	label.width = this._getLabelSpecifiedWidth();
	label.height = this._getLabelSpecifiedHeight();
	label.left = this._getLabelLeft();
	label.top = this._getLabelTop();

    
    // NOTE: vertical always false where inapplicable, eg ImgButton
    label.wrap = this.wrap != null ? this.wrap : this.vertical;
    
    label.eventProxy = this;        
    
    label.isMouseTransparent = true; 
    
    label.zIndex = this.getZIndex(true) + 1;

    label.tabIndex = -1;

    // finish createRaw()/completeCreation() construction style, but allow autoChild defaults
    this._completeCreationWithDefaults(this._$label, label);
    
    this.label.setSelected(this.isSelected());

    
	this.addPeer(this.label, null, null, true);
    
},

// Label Sizing Handling
// ---------------------------------------------------------------------------------------

//> @method statefulCanvas.setIconOrientation
// Changes the orientation of the icon relative to the text of the button.
//
// @param orientation ("left" or "right") The new orientation of the icon relative to the text
// of the button.
//
// @group buttonIcon
// @visibility external
//<
setIconOrientation : function (orientation) {
    this.iconOrientation = orientation;
    if (this.label) {
        this.label.iconOrientation = orientation;
        this.label.markForRedraw();
    } else {
        this.markForRedraw();
    }
},

//>@method statefulCanvas.setAutoFit()
// Setter method for the +link{StatefulCanvas.autoFit} property. Pass in true or false to turn
// autoFit on or off. When autoFit is set to <code>false</code>, canvas will be resized to
// it's previously specified size.
// @param autoFit (boolean) New autoFit setting.
// @visibility external
//<
setAutoFit : function (autoFit, initializing) {

    // setAutoFit is called directly from resizeTo
    // If we're resizing before the autoFit property's initial setup, don't re-set the
    // autoFit property.
    if (initializing) {
        this._autoFitInitialized = true;
        // No need to make any changes if autoFit is false
        if (!autoFit) return;
    }

    // This can happen if 'setWidth()' et-al are called during 'init' for the statefulCanvas,
    // and should not effect the autoFit setting.
    if (!this._autoFitInitialized) return;

    // Typecast autoFit to a boolean
    autoFit = !!autoFit;

    // bail if no change to autoFit, unless this is the special init-time call
    if (!initializing && (!!this.autoFit == autoFit)) return;
    
    this._settingAutoFit = true;
    this.autoFit = autoFit;
    var horizontal = (this.autoFitDirection == isc.Canvas.BOTH) || 
                      (this.autoFitDirection == isc.Canvas.HORIZONTAL),
        vertical = (this.autoFitDirection == isc.Canvas.BOTH) || 
                    (this.autoFitDirection == isc.Canvas.VERTICAL);

    // advertise that we have inherent width/height in whatever directions we are autofitting,
    // iow, a Layout should not expand us along that axis.
    this.inherentWidth = autoFit && horizontal;
    this.inherentHeight = autoFit && vertical;

    if (autoFit) {
        // record original overflow, width and height settings so we can restore them if
        // setAutoFit(false) is called
        this._explicitOverflow = this.overflow;
        this.setOverflow(isc.Canvas.VISIBLE);
                
        if (horizontal) {
            this._explicitWidth = this.width;
            this.setWidth(1);
        }
        
        if (vertical) {
            this._explicitHeight = this.height;
            this.setHeight(1);
        }
        //this.logWarn("just set autoFit to:"+ autoFit + 
        //     ", width/height/overflow:"+ [this.width, this.height, this.overflow]);

    } else {

        // If we had an explicit height before being set to autoFit true, we should reset to
        // that size, otherwise reset to default.
        var width = this._explicitWidth || this.defaultWidth,
            height = this._explicitHeight || this.defaultHeight;
            
        
        if (horizontal) this.setWidth(width);
        if (vertical) this.setHeight(height);

        if (this.parentElement && isc.isA.Layout(this.parentElement)) {
            if (horizontal && !this._explicitWidth) this._userWidth = null;
            if (vertical && !this._explicitHeight) this._userHeight = null;            
        }
        this._explicitWidth = null;
        this._explicitHeight = null;
        if (this._explicitOverflow) this.setOverflow(this._explicitOverflow);
        this._explicitOverflow = null;

    }
    delete this._settingAutoFit;
},


// override 'resizeBy()' / 'setOverflow()' - if these methods are called
// we're essentially clearing out this.autoFit
// Note we override resizeBy() as setWidth / setHeight / resizeTo all fall through to this method.
resizeBy : function (dX, dY, a,b,c,d) {

    if (this.autoFit && this._autoFitInitialized && !this._settingAutoFit) {
        var changeAutoFit = false;
        
        if (dX != null && 
            (this.autoFitDirection == isc.Canvas.BOTH || 
             this.autoFitDirection == isc.Canvas.HORIZONTAL)) 
        {        
            this._explicitWidth = (1 + dX);
            changeAutoFit = true;
        }
        if (dY != null && 
            (this.autoFitDirection == isc.Canvas.BOTH || 
             this.autoFitDirection == isc.Canvas.VERTICAL)) 
        {
            this._explicitHeight = (1 + dY);
            changeAutoFit = true;
        }

        // will call setWidth / height
        if (changeAutoFit) this.setAutoFit(false);
        return;
    }
	return this.invokeSuper(isc.StatefulCanvas, "resizeBy", dX,dY, a,b,c,d);    
},

getLabelHPad : function () {
    if (this.labelHPad != null) return this.labelHPad;
    if (this.vertical) {
        return this.labelBreadthPad != null ? this.labelBreadthPad : 0;
    } else {
        return this.labelLengthPad != null ? this.labelLengthPad : this.capSize;
    }
},

getLabelVPad : function () {
    if (this.labelVPad != null) return this.labelVPad;
    if (!this.vertical) {
        return this.labelBreadthPad != null ? this.labelBreadthPad : 0;
    } else {
        return this.labelLengthPad != null ? this.labelLengthPad : this.capSize;
    }
},

_getLabelLeft : function () {
    var left;
    
    if (this.isDrawn()) {
        left = (this.position == isc.Canvas.RELATIVE && this.parentElement == null ? 
                this.getPageLeft() : this.getOffsetLeft());
    } else {
        left = this.getLeft();
    }

    left += this.getLabelHPad();
    
    return left;
},

_getLabelTop : function () {
    var top;
    if (this.isDrawn()) {
        top = (this.position == isc.Canvas.RELATIVE && this.parentElement == null ? 
               this.getPageTop() : this.getOffsetTop());
    } else {
        top = this.getTop();
    }

    top += this.getLabelVPad();
    return top;
},

_getLabelSpecifiedWidth : function () {
    var width = this.getInnerWidth();
    width -= 2* this.getLabelHPad();
    
    return Math.max(width, 1);
},

_getLabelSpecifiedHeight : function () {
    var height = this.getInnerHeight();
    height -= 2 * this.getLabelVPad();
    return Math.max(height, 1);
},

// if we are overflow:visible, match the drawn size of the label.
// getImgBreadth/getImgLength return the sizes for the non-stretching and stretching axes
// respectively.
// NOTE that stretching on the breadth axis won't look right with most media sets, eg a
// horizontally stretching rounded button is either going to tile its rounded caps vertically
// (totally wrong) or stretch them, which will probably degrade the media.
getImgBreadth : function () {
    if (this.overflow == isc.Canvas.VISIBLE && isc.isA.Canvas(this.label)) 
    {
        return this.vertical ? this._getAutoInnerWidth() : this._getAutoInnerHeight();
    }
    
    //return this.Super("getImgBreadth", arguments);
    // same as the Superclass behavior
    return (this.vertical ? this.getInnerWidth() : this.getInnerHeight());
},

getImgLength : function () {
    if (this.overflow == isc.Canvas.VISIBLE && isc.isA.Canvas(this.label)) 
    {
        return this.vertical ? this._getAutoInnerHeight() : this._getAutoInnerWidth();
    }
    return (this.vertical ? this.getInnerHeight() : this.getInnerWidth());
},

// get the inner breadth or height we should have if we are overflow:visible and want to size
// to the label and the padding we leave around it
_getAutoInnerHeight : function () {
    var innerHeight = this.getInnerHeight();
    // use the normal inner height if we have no label
    if (!isc.isA.Canvas(this.label)) return innerHeight;

    // if the padding for this dimension is set, use that, otherwise assume the capSize as a
    // default padding for the stretch dimension
    var padding = this.getLabelVPad();
    var labelSize = this.label.getVisibleHeight() + 2*padding;
    return Math.max(labelSize, innerHeight);
},

_getAutoInnerWidth : function () {
    var innerWidth = this.getInnerWidth();
    if (!isc.isA.Canvas(this.label)) return innerWidth;

    var padding = this.getLabelHPad();
    var labelSize = this.label.getVisibleWidth() + 2*padding;
    return Math.max(labelSize, innerWidth);
},


// If we are matching the label size, and it changes, resize images and redraw
_$labelOverflowed:"Label overflowed.",
_labelAdjustOverflow : function () {
    if (this.overflow != isc.Canvas.VISIBLE) return;

    //this.logWarn("our innerWidth:" + this.getInnerWidth() + 
    //             ", label visible width: " + this.label.getVisibleWidth() + 
    //             " padding: " + (this.labelHPad * 2) +
    //             " resizing to width: " + this.getImgLength());
    
    // by calling our adjustOveflow, we will re-check the scrollWidth / height which
    // will adjust our size if necessary
    this.adjustOverflow(this._$labelOverflowed);
},

// Override getScrollWidth / Height - if we are overflow:"visible", and have a label we're 
// going to size ourselves according to its drawn dimensions
getScrollWidth : function (calcNewValue,B,C,D) {

    if (this.overflow != isc.Canvas.VISIBLE || !isc.isA.Canvas(this.label)) 
        return this.invokeSuper(isc.StatefulCanvas, "getScrollWidth", calcNewValue,B,C,D);

    if (this._deferredOverflow) {
        this._deferredOverflow = null;
        this.adjustOverflow("widthCheckWhileDeferred");
    }

    if (!calcNewValue && this._scrollWidth != null) return this._scrollWidth;

    // _getAutoInnerWidth() will give us back the greater of our specified size / the
    // label's visible size + our end caps.
    // This is basically our "scroll size" if overflow is visible
    var scrollWidth = this._getAutoInnerWidth()

    return (this._scrollWidth = scrollWidth);
},

getScrollHeight : function (calcNewValue,B,C,D) {

    if (this.overflow != isc.Canvas.VISIBLE || !isc.isA.Canvas(this.label)) 
        return this.invokeSuper(isc.StatefulCanvas, "getScrollHeight", calcNewValue,B,C,D);

    if (this._deferredOverflow) {
        this._deferredOverflow = null;
        this.adjustOverflow("heightCheckWhileDeferred");
    }

    if (!calcNewValue && this._scrollHeight != null) return this._scrollHeight;

    // _getAutoInnerWidth() will give us back the greater of our specified size / the
    // label's visible size + our end caps.
    // This is basically our "scroll size" if overflow is visible
    var scrollHeight = this._getAutoInnerHeight()

    return (this._scrollHeight = scrollHeight);
},

// Update the label's overflow when our overflow gets updated.
setOverflow : function (newOverflow, a, b, c, d) {

    // If we're autoFit:true, and overflow is getting set to hidden revert the autoFit property
    // to false
    if (this.autoFit && this._autoFitInitialized && !this._settingAutoFit &&
        newOverflow != isc.Canvas.VISIBLE) {
        
        this._explicitOverflow = newOverflow;
        this.setAutoFit(false);
        return;
    }    

    this.invokeSuper(isc.StatefulCanvas, "setOverflow", newOverflow, a, b, c, d);
    if (isc.isA.Canvas(this.label)) this.label.setOverflow(newOverflow, a, b, c, d);
    
},

// if the SIB is resized, resize the label
// This covers both:
// - the SIB is resized by application code and the label must grow/shrink
// - the SIB resizes itself as a result of the label changing size, in which case the call to
//   resize the label should no-op, since the sizes already agree
resized : function (deltaX, deltaY, a,b,c) {
    this.invokeSuper(isc.StatefulCanvas, this._$resized, deltaX,deltaY,a,b,c);
    //if (!this.label || this.overflow != isc.Canvas.VISIBLE) return;
    if (this.label) this.label.resizeTo(this._getLabelSpecifiedWidth(), 
                                        this._getLabelSpecifiedHeight());
},


draw : function (a,b,c) {
    if (isc._traceMarkers) arguments.__this = this;

    
    var returnVal = isc.Canvas._instancePrototype.draw.call(this, a,b,c);    
    //var returnVal = this.Super("draw", arguments);
    
    if (this.position != isc.Canvas.ABSOLUTE && isc.isA.Canvas(this.label)) {
        
        if (isc.Page.isLoaded()) this._positionLabel();
        else isc.Page.setEvent("load", this.getID() + "._positionLabel()");
    }
    return returnVal;        
},

_positionLabel : function () {
    if (!this.isDrawn()) return;
    this.label.moveTo(this._getLabelLeft(), this._getLabelTop());
},

// setAlign() / setVAlign() to set content alignment
// JSDoc'd in subclasses
setAlign : function (align) {
    this.align = align;
    if (this.isDrawn()) this.markForRedraw();
},

setVAlign : function (valign) {
    this.valign = valign;
    if (this.isDrawn()) this.markForRedraw();
},


// Printing
// --------------------------------------------------------------------------------------

// If we are showing a label default to printing it's text rather than 
// our standard content (images etc)
getPrintHTML : function () {
    if (this.label && this.label.isDrawn() && this.label.isVisible()) {
        return this.label.getPrintHTML();
    }
    return this.Super("getPrintHTML", arguments);
    
},

// Title handling
// ---------------------------------------------------------------------------------------

//> @method statefulCanvas.shouldHiliteAccessKey()
// Should the accessKey be underlined if present in the title for this button.
// Default implementation returns +link{StatefulCanvas.hiliteAccessKey}
//<
shouldHiliteAccessKey : function () {
    return this.hiliteAccessKey;
},


// If this widget has an accessKey, it will underline the first occurance of the accessKey
// in the title (preferring Uppercase to Lowercase)
getTitleHTML : function () {

    var title = this.getTitle();
    if (!this.shouldHiliteAccessKey() || !isc.isA.String(title) || this.accessKey == null) 
        return title;
    
    return isc.Canvas.hiliteCharacter(title, this.accessKey);
    
},

//>	@method	statefulCanvas.getTitle()	(A)
// Return the title - text/HTML drawn inside the component.
// <p>
// Default is to simply return this.title.
// @return	(string)	HTML for the title
// @visibility external
//<

getTitle : function () {
    return this.title;
},

//>	@method	statefulCanvas.setTitle()
// Set the title.
// @group	appearance
// @param	newTitle	(string)	new title
// @visibility external
//<
setTitle : function (newTitle) {
	// remember the contents
	this.title = newTitle;
    if (this.label) {
	    this.label.setContents(newTitle);
    	this.label.setState(this.getState());
	    this.label.setSelected(this.isSelected());
    // if we didn't have a label before, lazily create it.
    } else if (this.title != null && this.shouldShowLabel()) {
        this.makeLabel()
    }
},

// other Label management
// ---------------------------------------------------------------------------------------

// override setZIndex to ensure that this.label is always visible.
setZIndex : function (index,b,c) {
    
    isc.Canvas._instancePrototype.setZIndex.call(this, index,b,c);    
    //this.Super("setZIndex", arguments);

    if (isc.isA.Canvas(this.label)) this.label.moveAbove(this);
},


// Override _updateCanFocus() update the focusability of the label too
_updateCanFocus : function () {
    this.Super("_updateCanFocus", arguments);
    if (this.label != null) this.label._updateCanFocus();
},

//> @method statefulCanvas.setIcon()
// Change the icon being shown next to the title text.
// @param icon (URL) URL of new icon
// @group buttonIcon
// @visibility external
//<
// NOTE: subclasses that show a Label use the label to show an icon.  Other subclasses (like
// Button) must override setIcon()
setIcon : function (icon) { 
    this.icon = icon;
    if (this.label) this.label.setIcon(icon); 
    // lazily create a label if necessary
    else if (icon && this.shouldShowLabel()) this.makeLabel();
},

// Mouse Event Handlers
// --------------------------------------------------------------------------------------------
// various mouse events will set the state of this object.

//>	@method	statefulCanvas.mouseOver()	(A)
//			mouseMove event handler -- hilite the current button if showRollOver is true
//			may redraw the button
//		@group	events
//<
mouseOver : function () {
	if (this.showDown && this.ns.EH.mouseIsDown()) {
        // XXX we should only show down if the mouse went down on us originally
		this.setState(isc.StatefulCanvas.STATE_DOWN);
    } else {
        if (this.showRollOver) {
            this.setState(isc.StatefulCanvas.STATE_OVER);
        }
        if (this.showOverCanvas) {
            if (!this.overCanvas) {
                this.addAutoChild("overCanvas", {
                    autoDraw:false
                })
            } 
            if (!this.overCanvas.isDrawn()) this.overCanvas.draw();
        }
	}
},

//>	@method	statefulCanvas.mouseOut()	(A)
//			mouseOut event handler -- clear the button hilite, if appropriate
//			may redraw the button
//		@group	events
//<
mouseOut : function () {
	if (this.showRollOver) {
		this.setState(isc.StatefulCanvas.STATE_UP);
	} else if (this.showDown && this.ns.EH.mouseIsDown()) {
        // FIXME we should only pop up if the mouse went down on us originally
		this.setState(isc.StatefulCanvas.STATE_UP);
	}
    
    if (this.showOverCanvas && this.overCanvas && this.overCanvas.isVisible() && 
        (isc.EH.getTarget() != this.overCanvas))
    {
        this.overCanvas.clear();
    }
},

// override the internal _focusChanged() method to set the state of the canvas to "over" on
// focus.  (Note - overriding this rather than the public 'focusChanged()' method so developers
// can still put functionality into that method without worrying about calling 'super').
_focusChanged : function (hasFocus,b,c,d) {

    var returnVal = this.invokeSuper(isc.StatefulCanvas, "_focusChanged", hasFocus,b,c,d);
    // don't show the over state if we don't actually have focus anymore (because onFocus
    // is delayed in IE and focus may be elsewhere by the time it fires) 
    if (!(hasFocus && isc.Browser.isIE && 
         (this.getFocusHandle() != this.getDocument().activeElement)) ) 
    {
        this.updateStateForFocus(hasFocus);
    }
    
    return returnVal;
},

updateStateForFocus : function (hasFocus) {
    
    if (!this.showFocused) return;
    
    if (this.showFocusedAsOver) {     
        // NOTE: don't show the over state if showRollOver is false, because this is typically set
        // because there is no over state media (eg for an ImgButton)
        if (!this.showRollOver) return;
    
        var state = this.getState();
        if (hasFocus && !this.isDisabled()) {
            // on focus, if our state is currently 'up' set state to 'over' to indicate
            // we have focus
            if (state == isc.StatefulCanvas.STATE_UP) this.setState(isc.StatefulCanvas.STATE_OVER);
        } else {
            // on blur - clear out the 'over' state (if appropriate)
            if (state == isc.StatefulCanvas.STATE_OVER) this.setState(isc.StatefulCanvas.STATE_UP);
        }
    } else {
        // just call stateChanged - it will check this.hasFocus
        this.stateChanged();
        // Note: normally label styling etc will be updated by stateChanged() - but in this case
        // the other states are all unchanged so the label would not necessarily refresh to reflect
        // the focused state.
        if (this.label) this.label.stateChanged();
    }
},


// getFocusedState() - returns a boolean value for whether we should show the "Focused" state
getFocusedState : function () {
    if (!this.showFocused || this.showFocusedAsOver || this.isDisabled()) return false;
    return this.hasFocus;
},

//>	@method	statefulCanvas.handleMouseDown()	(A)
// MouseDown event handler -- show the button as down if appropriate
// calls this.mouseDown() if assigned
//	may redraw the button
//		@group	event
//<
handleMouseDown : function (event, eventInfo) {
    if (event.target == this && this.useEventParts) {
        if (this.firePartEvent(event, isc.EH.MOUSE_DOWN) == false) return false;
    }

	if (this.showDown) this.setState(isc.StatefulCanvas.STATE_DOWN);
    
    if (this.mouseDown) return this.mouseDown(event, eventInfo);

    
},


//>	@method	statefulCanvas.handleMouseUp()	(A)
//		@group	event
//			mouseUp event handler -- if showing the button as down, reset to the 'up' state
//          calls this.mouseUp() if assigned
//<
handleMouseUp : function (event, eventInfo) {
    if (event.target == this && this.useEventParts) {
        if (this.firePartEvent(event, isc.EH.MOUSE_UP) == false) return false;
    }

	// set the state of the button to change it's appearance
	if (this.showDown) {
		this.setState(this.showRollOver ? isc.StatefulCanvas.STATE_OVER : 
                      isc.StatefulCanvas.STATE_UP);
	}
    if (this.mouseUp) return this.mouseUp(event, eventInfo);    
},





//>	@method	statefulCanvas.handleActivate() (A)
//      "Activate" this widget - fired from click or Space / Enter keypress.
//      Sets selection state of this widget if appropriate.
//      Calls this.activate stringMethod if defined
//      Otherwise calls this.click stringMethod if defined.
//      @group  event
//<
handleActivate : function (event, eventInfo) {
    var actionType = this.getActionType();
	if (actionType == isc.StatefulCanvas.RADIO) {
		// if a radio button, select this button
		this.select();
		
	} else if (actionType == isc.StatefulCanvas.CHECKBOX) {
		// if a checkbox, toggle the selected state
		this.setSelected(!this.isSelected());
	}

    if (this.activate) return this.activate(event, eventInfo);
    
    if (this.action) return this.action();
    if (this.click) return this.click(event, eventInfo);
},


//>	@method	statefulCanvas.handleClick()	(A)
//			click event handler -- falls through to handleActivate.
//          Note: Does not call 'this.click' directly - this is handled by handleActivate
//		@group	event
//<
handleClick : function (event, eventInfo) {
    // This is required to handle icon clicks on buttons, etc
    if (event.target == this && this.useEventParts) {
        if (this.firePartEvent(event, isc.EH.CLICK) == false) return false;
    }
    return this.handleActivate(event,eventInfo);    
},

//>	@method	statefulCanvas.handleKeyPress()	(A)
//			keyPress event handler.
//          Will call this.keyPress if defined on Space or Enter keypress, falls through 
//          to this.handleActivate().
//		@group	event
//<
handleKeyPress : function (event, eventInfo) {

    if (this.keyPress && (this.keyPress(event, eventInfo) == false)) return false;
    
    if (event.keyName == "Space" || event.keyName == "Enter") {
        if (this.handleActivate(event, eventInfo) == false) return false;
    }
    
    return true;
    
}, 

// ---------------------------------------------------------------------------------------

// override destroy to removeFromRadioGroup - cleans up a class level pointer to this widget.
destroy : function () {
    this.removeFromRadioGroup();
    
    return this.Super("destroy", arguments);
}



});

// Add 'activate' as a stringMethod to statefulCanvii, with the same signature as 'click'
isc.StatefulCanvas.registerStringMethods({
    activate:isc.EH._eventHandlerArgString,  //"event, eventInfo"

    //> @method statefulCanvas.action()
    // This property contains the default 'action' for the Button to fire when activated.
    //<
    // exposed on the Button / ImgButton / StretchImgButton subclasses
    action:""
});
