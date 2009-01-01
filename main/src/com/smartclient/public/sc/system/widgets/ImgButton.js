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

 







//>	@class	ImgButton
// A Img that behaves like a button, going through up/down/over state transitions in response to
// user events.  Supports an optional title, and will auto-size to accomodate the title text if
// <code>overflow</code> is set to "visible".
// <P>
// An examples of use is Window minimize/close buttons.
//
// @treeLocation Client Reference/Control
// @visibility external
//<

// class for Stretchable image buttons
isc.defineClass("ImgButton", "Img").addProperties({

    // Various properties documented on StatefulCanvas that affect all buttons
    // NOTE: This block is included in Button, ImgButton, and StrechlImgButton.
    //       If you make changes here, make sure you duplicate it to the other
    //       classes.
    // 
    // End of this block is marked with: END StatefulCanvas @include block
    // =========================================================================

    // Title
    //------
    //> @attr imgButton.title
    // @include statefulCanvas.title
    // @visibility external
    //<    
    //> @attr imgButton.hiliteAccessKey (boolean : null : IRW)
    // @include statefulCanvas.hiliteAccessKey
    // @visibility external
    //<    

    //>	@method	imgButton.getTitle()	(A)
    // @include statefulCanvas.getTitle
    // @visibility external
    //<
    //>	@method	imgButton.setTitle()
    // @include statefulCanvas.setTitle
    // @visibility external
    //<

    
    // Icon
    //------
    //> @attr imgButton.icon
    // @include statefulCanvas.icon
    // @visibility external
    //<
    //> @attr imgButton.iconSize
    // @include statefulCanvas.iconSize
    // @visibility external
    //<
    //> @attr imgButton.iconWidth
    // @include statefulCanvas.iconWidth
    // @visibility external
    //<
    //> @attr imgButton.iconHeight
    // @include statefulCanvas.iconHeight
    // @visibility external
    //<
    //> @attr imgButton.iconOrientation
    // @include statefulCanvas.iconOrientation
    // @visibility external
    //<
    //> @attr imgButton.iconAlign
    // @include statefulCanvas.iconAlign
    // @visibility external
    //<
    //> @attr imgButton.iconSpacing
    // @include statefulCanvas.icon
    // @visibility external
    //<
    //> @attr imgButton.showDisabledIcon
    // @include statefulCanvas.showDisabledIcon
    // @visibility external
    //<
    //> @attr imgButton.showRollOverIcon
    // @include statefulCanvas.showRollOverIcon
    // @visibility external
    //<
    //> @attr imgButton.showFocusedIcon
    // @include statefulCanvas.showFocusedIcon
    // @visibility external
    //<
    //> @attr imgButton.showDownIcon
    // @include statefulCanvas.showDownIcon
    // @visibility external
    //<
    //> @attr imgButton.showSelectedIcon
    // @include statefulCanvas.showSelectedIcon
    // @visibility external
    //<
    //> @method imgButton.setIconOrientation()
    // @include statefulCanvas.setIconOrientation
    // @visibility external
    //<
    //> @method imgButton.setIcon()
    // @include statefulCanvas.setIcon
    // @visibility external
    //<

    // AutoFit
    //--------
    //> @attr imgButton.autoFit
    // @include statefulCanvas.autoFit
    // @visibility external
    //<    
    //> @method imgButton.setAutoFit()
    // @include statefulCanvas.setAutoFit
    // @visibility external
    //<

    // baseStyle
    //----------
    //> @attr imgButton.baseStyle (CSSStyleName : "imgButton" : IRW)
    // @include statefulCanvas.baseStyle
    // @visibility external
    //<    
	baseStyle:"imgButton",
    //> @method imgButton.setBaseStyle()
    // @include statefulCanvas.setBaseStyle
    // @visibility external
    //<

    // selection
    //----------
    //> @attr imgButton.selected
    // @include statefulCanvas.selected
    // @visibility external
    //<   
    //> @method imgButton.select()
    // @include statefulCanvas.select
    // @visibility external
    //<
    //> @method imgButton.deselect()
    // @include statefulCanvas.select
    // @visibility external
    //<
    //> @method imgButton.isSelected()
    // @include statefulCanvas.isSelected
    // @visibility external
    //<
    //> @method imgButton.setSelected()
    // @include statefulCanvas.select
    // @visibility external
    //<

    // radioGroup
    //-----------
    //> @attr imgButton.radioGroup
    // @include statefulCanvas.radioGroup
    // @visibility external
    // @example buttonRadioToggle
    //<     
    //> @method imgButton.addToRadioGroup()
    // @include statefulCanvas.addToRadioGroup
    // @visibility external
    //<
    //> @method imgButton.removeFromRadioGroup()
    // @include statefulCanvas.removeFromRadioGroup
    // @visibility external
    //<
    //> @attr imgButton.actionType
    // @include statefulCanvas.actionType
    // @visibility external
    // @example buttonRadioToggle
    //<     
    //> @method imgButton.setActionType()
    // @include statefulCanvas.setActionType
    // @visibility external
    //<
    //> @method imgButton.getActionType()
    // @include statefulCanvas.getActionType
    // @visibility external
    //<

    // state
    //------
    //> @attr imgButton.state
    // @include statefulCanvas.state
    // @visibility external
    //<  
    //> @method imgButton.setState()
    // @include statefulCanvas.setState
    // @visibility external
    //<
    //> @method imgButton.setDisabled()
    // @include statefulCanvas.setDisabled
    // @visibility external
    //<
    
    //> @method imgButton.getState()
    // @include statefulCanvas.getState
    // @visibility external
    //<
    //> @attr imgButton.showDisabled
    // @include statefulCanvas.showDisabled
    // @visibility external
    //<  
    //> @attr imgButton.showDown
    // @include statefulCanvas.showDown
    // @visibility external
    //<  
	showDown:true,			
    //> @attr imgButton.showFocus
    // @include statefulCanvas.showFocus
    // @visibility external
    //<      
    //> @attr imgButton.showFocused
    // @include statefulCanvas.showFocused
    // @visibility external
    //<  
	showFocused:true, 
    //> @attr imgButton.showRollOver
    // @include statefulCanvas.showRollOver
    // @visibility external
    //<  
	showRollOver:true,


    // alignment
    //----------
    //> @attr imgButton.align
    // @include statefulCanvas.align
    // @visibility external
    //<          
    //> @attr imgButton.valign
    // @include statefulCanvas.valign
    // @visibility external
    //<      
    
        
    // Button.action
    //> @method ImgButton.action()
    // @include statefulCanvas.action
    // @visibility external
    //<

    // ================= END StatefulCanvas @include block =============== //


    // Label
    // ---------------------------------------------------------------------------------------

   
    //> @attr ImgButton.showTitle (boolean : false : [IRWA])
    // @include StatefulCanvas.showTitle
    // @visibility external
    //<
    showTitle:false,
        
    // Match the standard button's cursor
    cursor:isc.Button._instancePrototype.cursor,

    //>	@attr	ImgButton.labelHPad  (number : null : IRW)
    // Horizontal padding to be applied to this widget's label. If this value is null, 
    // the label will be given a horizontal padding of zero.
    // <p>
    // The specified amount of padding is applied to the left and right edges of the button, so
    // the total amount of padding is 2x the specified value.
    //
    // @visibility external
    //<                                        
    
    //>	@attr	ImgButton.labelVPad  (number : null : IRW)
    // Vertical padding to be applied to this widget's label. If this value is null, 
    // the label will be given a vertial padding of zero.
    // <p>
    // The specified amount of padding is applied to the top and bottom edges of the button, so
    // the total amount of padding is 2x the specified value.
    //
    // @visibility external
    //<               
    // Note: the labelHPad / vPad are inherited from the StatefulCanvas implementation - this will
    // actually check for labelLengthPad / labelBreadthPad and then be either zero or the 
    // specified capSize for the widget. 
    // However labelLengthPad / BreadthPad are not anticipated to be set for this class and
    // the capSize is defaulted to zero in StatefulCanvas.js so we can accurately doc the padding
    // as just defaulting to zero.

    // States
    // ---------------------------------------------------------------------------------------
    //>	@attr	ImgButton.src		(SCImgURL : "[SKIN]/ImgButton/button.png" : IRW)
    // @include Img.src
    // @visibility external
    // @example buttonAppearance
	//<
    src:"[SKIN]/ImgButton/button.png",

    canFocus:true,    

    //>	@attr	isc.ImgButton.overflow      (string : "hidden" : RW)
    // Clip by default, because expanding to the label (if present) is likely to distort image
    //<
    overflow:isc.Canvas.HIDDEN

});
