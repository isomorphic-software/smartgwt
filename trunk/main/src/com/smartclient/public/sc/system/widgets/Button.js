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

 





//>	@class	Button
//
// The Button widget class implements interactive, style-based button widgets.
//
// @treeLocation Client Reference/Control
// @visibility external
//<
//	In IE, uses CSS styles to draw the border
//	In Nav, draws the border manually with images and a table

//> @groupDef buttonIcon
// Control over optional icons shown in Buttons, Labels and other contexts
// @title Button Icon
// @visibility external
//<

isc.ClassFactory.defineClass("Button", "StatefulCanvas").addProperties({


    // Various properties documented on StatefulCanvas that affect all buttons
    // NOTE: This block is included in Button, ImgButton, and StrechlImgButton.
    //       If you make changes here, make sure you duplicate it to the other
    //       classes.
    // 
    // End of this block is marked with: END StatefulCanvas @include block
    // ========================================================================

    // Title
    //------
    //> @attr button.title
    // @include statefulCanvas.title
    // @visibility external
    // @group basics
    // @group i18nMessages
    // @example buttonStates
    //<    
	title:"Untitled Button",
    
    //> @attr button.hiliteAccessKey    (boolean : null : IRW)
    // @include statefulCanvas.hiliteAccessKey
    // @visibility external
    //<    

    //>	@method	button.getTitle()	(A)
    // @include statefulCanvas.getTitle
    // @visibility external
    //<
    //>	@method	button.setTitle()
    // @include statefulCanvas.setTitle
    // @visibility external
    //<

		
    // don't set className on the widget's handle, because we apply styling to another element
    suppressClassName:true,
    
    // Icon
    //------
    
    // set useEventParts to true so we can handle an icon click separately from a
    // normal button click if we want
    useEventParts:true,
    
    //> @attr button.icon
    // @include statefulCanvas.icon
    // @visibility external
    // @example buttonIcons
    //<
    //> @attr button.iconSize
    // @include statefulCanvas.iconSize
    // @visibility external
    //<
    //> @attr button.iconWidth
    // @include statefulCanvas.iconWidth
    // @visibility external
    //<
    //> @attr button.iconHeight
    // @include statefulCanvas.iconHeight
    // @visibility external
    //<
    //> @attr button.iconOrientation
    // @include statefulCanvas.iconOrientation
    // @visibility external
    // @example buttonIcons
    //<
    //> @attr button.iconAlign
    // @include statefulCanvas.iconAlign
    // @visibility external
    //<
    //> @attr button.iconSpacing
    // @include statefulCanvas.iconSpacing
    // @visibility external
    //<
    //> @attr button.showDisabledIcon
    // @include statefulCanvas.showDisabledIcon
    // @visibility external
    //<
    //> @attr button.showRollOverIcon
    // @include statefulCanvas.showRollOverIcon
    // @visibility external
    //<
    
    //> @attr button.showFocusedIcon
    // @include statefulCanvas.showFocusedIcon
    // @visibility external
    //<
    //> @attr button.showDownIcon
    // @include statefulCanvas.showDownIcon
    // @visibility external
    // @example buttonIcons
    //<
    //> @attr button.showSelectedIcon
    // @include statefulCanvas.showSelectedIcon
    // @visibility external
    //<
    //> @method button.setIconOrientation()
    // @include statefulCanvas.setIconOrientation
    // @visibility external
    //<
    //> @method button.setIcon()
    // @include statefulCanvas.setIcon
    // @visibility external
    //<

    // AutoFit
    //--------
    //> @attr button.autoFit
    // @include statefulCanvas.autoFit
    // @group sizing
    // @visibility external
    // @example buttonAutoFit
    //<    
    //> @method button.setAutoFit()
    // @include statefulCanvas.setAutoFit
    // @visibility external
    //<

    // baseStyle
    //----------
    //> @attr button.baseStyle (CSSStyleName : "button" : IRW)
    // @include statefulCanvas.baseStyle
    // @visibility external
    //<    
	baseStyle:"button",
    //> @method button.setBaseStyle()
    // @include statefulCanvas.setBaseStyle
    // @visibility external
    //<

    // selection
    //----------
    //> @attr button.selected
    // @include statefulCanvas.selected
    // @visibility external
    //<   
    //> @method button.select()
    // @include statefulCanvas.select
    // @visibility external
    //<
    //> @method button.deselect()
    // @include statefulCanvas.select
    // @visibility external
    //<
    //> @method button.isSelected()
    // @include statefulCanvas.isSelected
    // @visibility external
    //<
    //> @method button.setSelected()
    // @include statefulCanvas.select
    // @visibility external
    //<

    // radioGroup
    //-----------
    //> @attr button.radioGroup
    // @include statefulCanvas.radioGroup
    // @visibility external
    // @example buttonRadioToggle
    //<     
    //> @method button.addToRadioGroup()
    // @include statefulCanvas.addToRadioGroup
    // @visibility external
    //<
    //> @method button.removeFromRadioGroup()
    // @include statefulCanvas.removeFromRadioGroup
    // @visibility external
    //<
    //> @attr button.actionType
    // @include statefulCanvas.actionType
    // @visibility external
    // @example buttonRadioToggle
    //<     
    //> @method button.setActionType()
    // @include statefulCanvas.setActionType
    // @visibility external
    //<
    //> @method button.getActionType()
    // @include statefulCanvas.getActionType
    // @visibility external
    //<

    // state
    //------
    //> @attr button.state
    // @include statefulCanvas.state
    // @visibility external
    //<  
    //> @method button.setState()
    // @include statefulCanvas.setState
    // @visibility external
    //<
    //> @method button.setDisabled()
    // @include statefulCanvas.setDisabled
    // @visibility external
    //<
    //> @method button.getState()
    // @include statefulCanvas.getState
    // @visibility external
    //<
    //> @attr button.showDisabled
    // @include statefulCanvas.showDisabled
    // @visibility external
    // @example buttonStates
    //<  
    //> @attr button.showDown
    // @include statefulCanvas.showDown
    // @visibility external
    // @example buttonStates
    //<  
    //> @attr button.showFocused
    // @include statefulCanvas.showFocused
    // @visibility external
    //<  
	showDown:true,
    
    showFocused:true,
    //> @attr button.showRollOver
    // @include statefulCanvas.showRollOver
    // @visibility external
    // @example buttonStates
    //<  
	showRollOver:true,

    
    mozOutlineOffset: "0px",
        
    // alignment
    //----------
    //> @attr button.align
    // @include statefulCanvas.align
    // @visibility external
    //<          
    //> @attr button.valign
    // @include statefulCanvas.valign
    // @visibility external
    //<      
    
    
    // Button.action
    //> @method button.action()
    // @include statefulCanvas.action
    // @visibility external
    //<
    
    // ================= END StatefulCanvas @include block =============== //

    
    //>	@attr	button.wrap		(boolean : false : [IRW])
    // A boolean indicating whether the button's title should word-wrap, if necessary.
    // @group basics
    //      @visibility external
    //<
	wrap:false,

    // NOTE: by setting "height" rather than "defaultHeight", we make this into an explicit
    // setting which will be respected by a Layout
	height:20,					        
    width:100,
    
	//>	@attr	button.overflow		(attrtype : isc.Canvas.HIDDEN : IRWA)
	// Clip the contents of the button if necessary
	//<
    overflow:isc.Canvas.HIDDEN,				
    
    //>	@attr	button.redrawOnDisable		(boolean : true : IRWA)
	// true == redraw the button when it's enabled/disabled
	//<
	redrawOnDisable:false,				

    //>	@attr	button.redrawOnStateChange		(boolean : true : IRWA)
	// true == redraw the button when it's state changes
	//		@group	state
	//<										
	redrawOnStateChange:false,			

	//>	@attr	button.cursor		(Cursor : isc.Canvas.HAND : IRW)
	// Hand cursor since these items are clickable
	//<
	cursor:isc.Canvas.HAND,

	// Style of the button is set via baseStyle, etc. above
    // NOTE: the button applies its CSS style to a contained cell, not the Canvas itself.
    className:null,						

    // If true, add a space to left or right-aligned titles so that they are not flush with
    // the edge of the widget.
    // NOTE: FIXME: this should really be done via CSS padding, hence not external doc'd
    //padTitle:false,

    //> @attr statefulCanvas.titleStyle        (CSSStyleName : "normal" : [IR])
    // For buttons with icons only, optional style to be applied to title text only.  This
    // style should contain text-related properties only (such as font size); border, padding
    // and background color should be specified in the style used as the "baseStyle".
    //
    // This property applied only to icon buttons rendered with a subtable, and currently only
    // works if redrawOnStateChange is true.  Internal for now.
    //<
    
    //titleStyle:"buttonTitle",

    canFocus:true,

    
    redrawOnResize:
        (isc.Browser.isIE || 
         (isc.Browser.isMoz && !isc.Browser.isStrict && isc.Canvas.getInstanceProperty("_useMozScrollbarsNone")) ? 
          false : null)
    
});

// add instance methods
isc.Button.addMethods({

//>	@method	button.initWidget()	(A)
//			Extended initWidget() to allow initialization of the enabled property
//
//		@param	[all arguments]	(object)	objects with properties to override from default
//<
initWidget : function () {
    
    

    if (this.border != null) {
        this._buttonBorder = this.border;
        this.border = null;
    }
    if (this.padding != null) {
        this._buttonPadding = this.padding;
        this.padding = null;
    }
    if (this.backgroundColor != null) {
        this._buttonBGColor = this.backgroundColor;
        this.backgroundColor = null;
    }

    // Call super implementation directly rather than using Super() to avoid a string 
    // allocation.
    return isc.StatefulCanvas._instancePrototype.initWidget.call(this);
},

//>	@method	button.getInnerHTML()	(A)
// Return the HTML for this button
//		@group	drawing
//
//		@return	(string)	HTML output for the button
//<
getInnerHTML : function () {
        

        var button = isc.Button;
        if (!button._buttonHTML) {
            
            button._100Size = " width='100%' height='100%";
            button._100Width = " width='100%";
            button._widthEquals = "width='";
            button._heightEquals = "' height='";            
            button._hiddenOverflow = "' style='table-layout:fixed;overflow:hidden;";
            button._cellStartWrap = "'><tbody><tr><td class='";
            button._cellStartNoWrap = "'><tbody><tr><td nowrap='true' class='";
            var buttonHTML = button._buttonHTML = [];
            // NOTE: for DOM platforms, padding should be achieved by CSS padding and spacing
            // by CSS margins
            buttonHTML[0] = "<table cellspacing='0' cellpadding='0' ";
            // [1] 100% width and height, or width=
            // [2] null or this.getWidth()
            // [3] null or height=
            // [4] null or this.getHeight();
            
            // [5] overflow setting
            // [6] cell start (wrap/nowrap variants)
            // [7] CSS class

            // [8] optional cssText

            buttonHTML[9] = "' align='";
            // [10] align
            // [11] valign
            button._valignCenter = "' valign='center";
            button._valignTop = "' valign='top";
            button._valignBottom = "' valign='bottom";
            
            // [12-14] tabIndex and focus
            
            button._tabIndexStart = "' tabindex='-1' onfocus='";
            button._callFocus = "._cellFocus()'>";
            button._closeQuoteRightAngle = "'>";

            // IE 
            // [15] title

            // Moz
            // [15] Moz start DIV
            // [16] title
            // [17] Moz end DIV

            // end table (see _endTemplate)
        }
        
        var buttonHTML = button._buttonHTML;
        // if we're printing the button, make it fit its parent element
        // If we're not redrawing on resize, use 100% sizing - will reflow on resize of parent
        // element
        if (this.isPrinting || this.redrawOnResize == false) {
            // if we're not going to redraw on resize, write HTML that reflows automatically.  Not
            // yet possible in every browser.
            
            buttonHTML[1] = (this.isPrinting ? button._100Width : button._100Size);
            buttonHTML[2] = null; buttonHTML[3] = null; buttonHTML[4] = null;
        } else {
            buttonHTML[1] = button._widthEquals;
            buttonHTML[2] = this.getInnerWidth(); 
            buttonHTML[3] = button._heightEquals;
            buttonHTML[4] = this.getInnerHeight();
        }
        
        
        if (this.overflow == isc.Canvas.VISIBLE) {
            buttonHTML[5] = null;
        } else {
            buttonHTML[5] = button._hiddenOverflow;
        }
        
        // Inside the cell:
        buttonHTML[6] = (this.wrap ? button._cellStartWrap : button._cellStartNoWrap);

        buttonHTML[7] = this.isPrinting ? this.getPrintStyleName() : this.getStateName();
        
        
        
        var writeStyle = (this.cssText || this._buttonBorder ||
                          this._buttonPadding || this._buttonBGColor || this.margin ||
                          this._writeZeroVPadding());                      
        if (writeStyle) buttonHTML[8] = this._getCellStyleHTML();
        else buttonHTML[8] = null;
        
        // If the iconOrientation and iconAlign are set such that the icon is pinned to the
        // edge of the table rather than showing up next to the title, ensure we center the
        // inner table - alignment of the title will be written directly into its cell.
        buttonHTML[10] = (this._iconAtEdge() ? isc.Canvas.CENTER : this.align);
        buttonHTML[11] = (this.valign == isc.Canvas.TOP ? button._valignTop : 
                            (this.valign == isc.Canvas.BOTTOM ? button._valignBottom
                                                              : button._valignCenter) );

        
        if (this._canFocus() && this._useNativeTabIndex) {
            buttonHTML[12] = button._tabIndexStart;
            buttonHTML[13] = this.getID();
            buttonHTML[14] = button._callFocus;
        } else {
            buttonHTML[12] = button._closeQuoteRightAngle;
            buttonHTML[13] = buttonHTML[14] = null;
        }
        this.fillInCell(buttonHTML, 15)
        return buttonHTML.join(isc.emptyString);
},


// override getPrintTagStart to avoid writing out the printClassName on the outer div
getPrintTagStart : function () {
    var props = this.currentPrintProperties,
        topLevel = props.topLevelCanvas == this, 
        inline = !topLevel && props.inline;
        
    return [(inline ? "<span " : "<div "),
            // could add borders etc here
            ">"].join(isc.emptyString);
},


_$pxSemi:"px;", _$semi:";",
_$borderColon:"border:",
_$zeroVPad:"padding-top:0px;padding-bottom:0px;",
_$paddingColon:"padding:",
_$bgColorColon:"background-color:",
_$zeroMargin:"margin:0px;",
_$cellStyleTemplate:[
    "' style='", // [0]
    ,           // [1] explicit css text applied to the button

    ,           // [2] null or "border:" (button border)
    ,           // [3] null or this._buttonBorder (button border)
    ,           // [4] null or ";" (button border)

    ,           // [5] null or "padding:" (button padding)
    ,           // [6] null or this._buttonPadding (button padding)
    ,           // [7] null or ";"  (button padding)

    ,           // [8] null or backgroundColor (button bg color)
    ,           // [9] null or this._buttonBGColor (button bg color)
    ,           // [10] null or ";" (button bg color)

    ,           // [11] null or "margin:0px" (avoid margin doubling)
    "'"
],


_getCellStyleHTML : function () {
    var template = this._$cellStyleTemplate;

    template[1] = (this.cssText ? this.cssText : null);
    
    if (this._buttonBorder != null) {
        template[2] = this._$borderColon;
        template[3] = this._buttonBorder;
        template[4] = this._$semi;
    } else {
        template[2] = null;
        template[3] = null;
        template[4] = null;
    }
    
    var padding = this._buttonPadding;
    if (padding != null) {
        template[5] = this._$paddingColon;
        template[6] = padding;
        template[7] = this._$semi;
    } else {
        template[5] = null;
        template[6] = null;
        template[7] = null;
    }
    if (this._writeZeroVPadding()) {
        template[7] = (template[7] || isc.emptyString) + this._$zeroVPad;
    }
    
    if (this._buttonBGColor != null) {
        template[8] = this._$bgColorColon;
        template[9] = this._buttonBGColor;
        template[10] = this._$semi;
    } else {
        template[8] = null;
        template[9] = null;
        template[10] = null;
    }
    
    if (this.margin != null) template[11] = this._$zeroMargin;
    else template[11] = null;
    
    return template.join(isc.emptyString);
},       


_writeZeroVPadding : function () {
    return this.overflow == isc.Canvas.HIDDEN && 
           // don't remove padding during animations or text may reflow
           !this.isAnimating() && 
            (isc.Browser.isMoz || isc.Browser.isSafari || isc.Browser.isIE);
},     

 
setBorder : function (border) {
    this._buttonBorder = border;
    this.markForRedraw();
},
setPadding : function (padding) {
    this._buttonPadding = padding;
    this.markForRedraw();
},
setBackgroundColor : function (color) {
    this._buttonBGColor = color;
    this.markForRedraw();
},

_$endTable :"</td></tr></tbody></table>",
_endTemplate : function (template, slot) {
    template[slot] = this._$endTable;
    template.length = slot+1;
    return template;
},

_$innerTableStart : "<table cellspacing='0' cellpadding='0'><tbody><tr><td ",
_$fillInnerTableStart : "<table width='100%' cellspacing='0' cellpadding='0'><tbody><tr><td ",


_$leftIconCellStyleStart : "font-size:1px;padding-right:",
_$rightIconCellStyleStart : "font-size:1px;padding-left:",
_$pxClose : "px'>",
_$newInnerCell : "</td><td ", 

_$classEquals : "class='",



_$tableNoStyleDoubling : "' style='" + isc.Canvas._$noStyleDoublingCSS,

// for IE opacity bug (see Canvas.setOpacity()), prevents text burnthrough in both isc.Buttons
// with gradients and SIB Labels.  Does not help with border burn-through visible in
// isc.Buttons with gradients
//_$tableNoStyleDoubling : "' style='" + isc.Canvas._$noStyleDoublingCSS + 
//    ";filter:Alpha(opacity=100);",

_$closeInnerTag : "'>",
_$closeInnerTagNoWrap : "' nowrap='true'>",    
 
_$innerTableEnd : "</td></tr></tbody></table>",

// used to check alignment for the icon
_$right:"right",

// Helper - is the icon pinned to the left / right edge, rather than floated next to the title?
_iconAtEdge : function () {
    return this.icon != null && this.iconAlign != null && 
                (this.iconAlign == this.iconOrientation) && 
                (this.iconAlign != this.align);
},

fillInCell : function (template, slot) {

    var rtl = this.isRTL();

    var title = this.getTitleHTML();

    if (!this.icon) {
        if (isc.Browser.isMoz) {
            var minHeight = this.reliableMinHeight;
            template[slot] = (minHeight ? "<div>" : null);
            template[slot+1] = title;
            template[slot+2] = (minHeight ? "</div>" : null);
            this._endTemplate(template, slot+3)
        } else {
            template[slot] = title;
            this._endTemplate(template, slot+1)
        }
        return;
    }

    var iconLeft = this.iconOrientation != this._$right,
        iconImg = this._generateIconImgHTML();


    // draw icon and text with spacing w/o a table.
    if (this.noIconSubtable) {
        var spacer = isc.Canvas.spacerHTML(this.iconSpacing,1);
        template[slot] = (iconLeft ? isc.SB.concat(iconImg, spacer, title)
                                   : isc.SB.concat(title, spacer, iconImg));
        this._endTemplate(template, slot+1)
        return;
    } 
    
    // Should we have the icon show up at the edge of the button, rather than being
    // adjacent to the title text?
    
    
    var iconAtEdge = this._iconAtEdge(),
        iconCellSpace;
    if (iconAtEdge) iconCellSpace = (this.iconWidth ? this.iconWidth : this.iconSize) 
                                    + this.iconSpacing;
    
    // if the icon is showing at one edge (and the text is separated from it), draw the
    // table 100% wide
    template[slot] = (iconAtEdge ? this._$fillInnerTableStart : this._$innerTableStart);
    
    var styleName = this.isPrinting ? this.getPrintStyleName() : 
                    (this.titleStyle 
                      ? this.titleStyle + 
                        (this.isDisabled() ? isc.StatefulCanvas.STATE_DISABLED : isc.emptyString)
                      : this.getStateName()
                    );
    
    if (iconLeft) {

        // icon cell
        template[++slot] = this._$classEquals;
        template[++slot] = styleName;
        template[++slot] = this._$tableNoStyleDoubling;

        template[++slot] = !rtl ? this._$leftIconCellStyleStart :
                                  this._$rightIconCellStyleStart;
        
        template[++slot] = this.iconSpacing;
        if (iconAtEdge) {
            template[++slot] = "px;width:";
            template[++slot] = iconCellSpace;
        }
        template[++slot] = this._$pxClose;
        template[++slot] = iconImg;
        // title cell
        template[++slot] = this._$newInnerCell;
        template[++slot] = this._$classEquals;
        
        template[++slot] = styleName;
        template[++slot] = this._$tableNoStyleDoubling;
        
        if (iconAtEdge) {
            template[++slot] = "' align='" 
            template[++slot] = this.align;
        }
        template[++slot] = (this.wrap ? this._$closeInnerTag : this._$closeInnerTagNoWrap)
        template[++slot] = title;
    
    } else {
        // title cell:
        template[++slot] = this._$classEquals;
        template[++slot] = styleName;
        template[++slot] = this._$tableNoStyleDoubling;

        if (iconAtEdge) {
            template[++slot] = "' align='";
            template[++slot] = this.align;
        }
        template[++slot] = (this.wrap ? this._$closeInnerTag : this._$closeInnerTagNoWrap)
        template[++slot] = title;
        
        // icon cell
        template[++slot] = this._$newInnerCell;
        
        template[++slot] = this._$classEquals;
        template[++slot] = styleName;
        template[++slot] = this._$tableNoStyleDoubling;
        
        template[++slot] = !rtl ? this._$rightIconCellStyleStart :
                                  this._$leftIconCellStyleStart;
        template[++slot] = this.iconSpacing;
        if (iconAtEdge) {
            template[++slot] = "px;width:";
            template[++slot] = iconCellSpace;
        }
        template[++slot] = this._$pxClose;
        template[++slot] = iconImg;

    }
    template[++slot] = this._$innerTableEnd; 
    
    this._endTemplate(template, slot)
},





_imgParams : {
    align : "absmiddle", // just prevents default "texttop" from kicking in
    extraStuff : " style='vertical-align:middle' eventpart='icon'"
},
_$iconImgName:[null, "_icon"],
_generateIconImgHTML : function () {
    // NOTE: we reuse a single global imgParams structure, so we must set every field we ever
    // use every time.
    var imgParams = this._imgParams;

    if (this._imgName == null) {
        this._$iconImgName[0] = this.getID();
        this._imgName = this._$iconImgName.join(isc.emptyString);
    }

    imgParams.name = this._imgName;
    imgParams.width = this.iconWidth || this.iconSize;
    imgParams.height = this.iconHeight || this.iconSize;
    imgParams.src = this._getIconURL();

	return this.imgHTML(imgParams);
},
_getIconURL : function () {
    var state = this.state,
        selected = this.selected,
        customState = this.getCustomState(),
        sc = isc.StatefulCanvas;

    // ignore states we don't care about
    if (state == sc.STATE_DISABLED && !this.showDisabledIcon) state = null;
    else if (state == sc.STATE_DOWN && !this.showDownIcon) state = null;
    else if (state == sc.STATE_OVER && !this.showRollOverIcon) state = null;
    
    if (!this.showIconState) {
        state = null;
        customState = null;
    }

    if (selected && !this.showSelectedIcon) selected = false;
    // Note that getFocusedState() will return false if showFocusedAsOver is true, which is
    // appropriate
    var focused = this.showFocusedIcon ? this.getFocusedState() : null; 
    var icon = this.icon;
    if (isc.isAn.Object(icon)) icon = icon.src;
    return isc.Img.urlForState(icon, selected, focused, state, null, customState);
},

getTitleHTML : function (a,b,c,d) {
    // This will call getTitle() so return contents if appropriate, and will hilite accessKeys
    var title = this.invokeSuper(isc.Button, "getTitleHTML", a,b,c,d);

    // FIXME: title padding should be accomplished with CSS
    if (!this.padTitle || this.align == isc.Canvas.CENTER) return title;

    if (this.align == isc.Canvas.RIGHT) return title + isc.nbsp;
    else if (this.align == isc.Canvas.LEFT) return isc.nbsp + title;
},


//> @method Button.setWrap()
// Set whether the title of this button should be allowed to wrap if too long for the button's
// specified width.
//
// @param newWrap (boolean) whether to wrap the title
// @visibility external
//<
setWrap : function (newWrap) {
    if (this.wrap != newWrap) {
        // NOTE: wrap can almost certainly be changed on the fly w/o redraw, at least on modern
        // browsers
        this.wrap = newWrap;
        this.markForRedraw("wrapChanged");
    }
},

// get the cell holding the title text.  DOM only.
getTitleCell : function () {
    if (!this.getHandle()) return null;
    var cell = this.getHandle().firstChild.rows[0].cells[0];
    return cell;
},

// get the minimum height of this button which would not clip the title text as it is currently
// wrapped.  Only available after drawing.  For Moz, must set "reliableMinHeight" for
// this to be reliable.
getButtonMinHeight : function () {
    

    var titleCell = this.getTitleCell();
    // In IE, and probably other DOM browsers, the cell's scrollHeight is reliable
    if (!isc.Browser.isMoz) {
        return titleCell.scrollHeight + isc.Element._getVBorderSize(this.getStateName());
    }

    
    return titleCell.firstChild.offsetHeight + 
        isc.Element._getVBorderSize(this.getStateName());
},

// get the width this button would need to be in order to show all text without wrapping
// XXX move deeper, to Canvas?
getPreferredWidth : function () {

    

    var oldWrap = this.wrap,
        oldOverflow = this.overflow,
        oldWidth = this.width;

    // set overflow visible with no minimum width in order to get the minimum width that won't
    // wrap or clip the title text
    // XXX because wrapping is controlled by a <NOBR> tag in the generated HTML, we can't detect
    // preferred width without a redraw, even if we could resize without a redraw
    this.setWrap(false);
    this.overflow = isc.Canvas.VISIBLE;
    this.setWidth(1);
    this.redrawIfDirty("getPreferredWidth");

    var width = this.getScrollWidth();

    // reset text wrapping and overflow setting
    this.setWrap(oldWrap);
    this.overflow = oldOverflow;
    // NOTE: if this button needs to redraw on resize, this will queue up a redraw, but if you
    // are trying to set the button to it's preferred size you will avoid a redraw if you set
    // the new size right away.
    this.setWidth(oldWidth); 

    return width;
},

getTitle : function () {
    if (this.useContents) return this.getContents();
    return this.title;
},


setTitle : function (newTitle) {
	this.title = newTitle;
	this.markForRedraw("setTitle");
},

//>	@method	button.stateChanged()	(A)
//		@group	appearance
//			overrides the StatefulCanvas implememntation to update the contents TD className
//<
stateChanged : function () {

    

    if (this.redrawOnStateChange || !this.isDrawn()) {
        return this.Super("stateChanged");
    } else {
        var stateName = this.isPrinting ? this.getPrintStyleName() : this.getStateName();
        
        if (!this.suppressClassName) this.setClassName(stateName);
        else this.setTableClassName(stateName);
        
        if (this.icon) {
            // NOTE: the icon may or may not actually change to reflect states or selectedness,
            // but either state or selectedness or both may have just changed, and we may be
            // transitioning from a state we do show to a state we don't, so no-oping is
            // tricky; we don't both for now.
            this.setImage(this._imgName, this._getIconURL());
        }
    }        
},

// Set the css className of the table cell
setTableClassName : function (newClass){
    
    var TD = this.getTitleCell();
    if (!TD) return;
    if (TD.className != newClass) TD.className = newClass;

    if (this.icon && !this.noIconSubtable && !this.titleStyle) { 
        // if we're using a subtable, update the style on the title cell too (it won't
        // cascade).
        
        var titleCell = TD.firstChild.rows[0].cells[(this.iconOrientation == this._$right ? 0 : 1)];
        if (titleCell && titleCell.className != newClass) titleCell.className = newClass;
    }

    
    if (this.overflow == isc.Canvas.VISIBLE) this.adjustOverflow();
},

setTitleStyle : function (newStyle) {
    this.titleStyle = newStyle;
    if (!this.isDrawn() || !this.icon || this.noIconSubtable) return
    var TD = this.getTitleCell();
    if (!TD) return;
    var titleCell = TD.firstChild.rows[0].cells[1];
    if (titleCell && titleCell.className != newStyle) titleCell.className = newStyle;
},

setIcon : function (icon) {
    var hadIcon = this.icon != null;
    this.icon = icon;
    if (hadIcon) this.setImage(this._imgName, this._getIconURL());
    else this.redraw();
},

_cellFocus : function () {
    isc.EH._setThread("cFCS");
    this.focus();
    isc.EH._clearThread();
},

// override _updateCanFocus() to redraw the button.  If the focusability of the button is changed
// and we're making use of native HTML focus / tabIndex behavior, we'll need to regenerate the 
// inner HTML.
_updateCanFocus : function () {
    this.Super("_updateCanFocus", arguments);
    if (this._useNativeTabIndex) this.markForRedraw();
}


//>	@method	button.setAlign()
// Sets the (horizontal) alignment of this buttons content.
//  @group positioning
//  @visibility external
//<
// defined in StatefulCanvas

//>	@method	button.setVAlign()
// Sets the vertical alignment of this buttons content.
//  @group positioning
//  @visibility external
//<
// defined in StatefulCanvas

});	// END	isc.Button.addMethods()

isc.Button.registerStringMethods({
    getTitle:null
});


// AutoFitButton
// --------------------------------------------------------------------------------------------
// Button that automatically sizes to the title text.

//> @class AutoFitButton
//
// A button that automatically sizes to the length of its title.  Implemented via the 
// +link{StatefulCanvas.autoFit} property.
//
// @deprecated As of Isomorphic SmartClient version 5.5, autoFit behavior can be achieved using
// the Button class instead by setting the property +link{Button.autoFit} to true.
//
// @see Button
// @treeLocation Client Reference/Control/Button
// @visibility external
//<

isc.ClassFactory.defineClass("AutoFitButton", "Button");

isc.AutoFitButton.addProperties({
    autoFit:true
});




isc.Button.registerStringMethods({
    //>@method Button.iconClick()
    // If this button is showing an +link{Button.icon, icon}, a separate click handler for the
    // icon may be defined as <code>this.iconClick</code>.
    // Returning false will suppress the standard button click handling code.
    // @group buttonIcon    
    // @visibility external
    //<
    // don't expose the parameters - they're not really useful to the developer
    iconClick:"element,ID,event"
});


// Make "IButton" a synonym of Button by default.

//>	@class	IButton
//
// The IButton widget class is a class that implements the same APIs as the 
// +link{class:Button} class.  Depending on the current skin, <code>IButton</code>s may be
// on the +link{StretchImgButton} component, which renders via images, or may be based on the
// +link{Button} component, which renders via CSS styles.
//
// @treeLocation Client Reference/Control
// @visibility external
//<

isc.addGlobal("IButton", isc.Button);

