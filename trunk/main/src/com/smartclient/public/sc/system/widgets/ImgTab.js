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

 






//>	@class	ImgTab
// Specialized StretchImgButton used by TabSet/TabBar for tabs
//
// @treeLocation Client Reference/Foundation
// @visibility external
//<

// class for Stretchable image buttons
isc.ClassFactory.defineClass("ImgTab", "StretchImgButton");

// add properties to the class
isc.ImgTab.addProperties({
    //>	@attr	isc.ImgTab.capSize		(number : 2 : IRW)
	// How big are the end pieces by default
	// @group appearance
    // @visibility external
	//<
	capSize:2,

    //>	@attr	isc.ImgTab.skinImgDir		(URL : "images/Tab/" : IRW)
	// Base path for the images.   <B>Note</B> that when used within a TabSet, the
    // +link{tabSet.tabBarPosition} is appended as an additional path segment, yielding
    // "images/Tab/top/" et al.
    //
    // @visibility external
	//<
	skinImgDir:"images/Tab/",			

    //> @attr ImgTab.baseStyle (CSSStyleName : "tab" : IR)
    // @visibility external
    //<
    baseStyle:"tab",

    //> @attr ImgTab.titleStyle (CSSStyleName : null : IR)
    // Like +link{StretchImgButton.titleStyle}, can set to provide a separate style for the
    // title text.
    // <P>
    // If set and the ImgTab is +link{StretchImgButton.vertical,vertical}, a "v" will be
    // automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
    //
    // @visibility external
    //<

    //>	@attr	isc.ImgTab.src		(URL : "tab.gif" : IRW)
	// Base URL for tab images
    // @visibility external
	//<
	src:"[SKIN]tab.gif",				

    //>	@attr	isc.ImgTab.showRollOver		(boolean : false : IRW)
	// Should we visibly change state when the mouse goes over this tab
    // @visibility external
	//<
	showRollOver:false,					

    //>	@attr	isc.ImgTab.showFocus    (boolean : true : IRW)
	// Should we visibly change state when the tab recieves keyboard focus?
    // @deprecated as of SmartClient 6.1 in favor of +link{imgTab.showFocused}
    // @visibility external
	//<
    //>	@attr	isc.ImgTab.showFocused    (boolean : true : IRW)
	// Should we visibly change state when the tab recieves keyboard focus?
    // @visibility external
	//<
	showFocused:true,

    //>	@attr	isc.ImgTab.align		(Alignment : isc.Canvas.CENTER : IRW)
	// Alignment of title text
	//		@group	positioning
    // @visibility external
	//<
    // agrees with superclass
	//align:isc.Canvas.CENTER,

	//>	@attr	isc.ImgTab.valign		(VerticalAlignment : isc.Canvas.CENTER : IRW)
	// Vertical alignment of title text.
	//		@group	positioning
	//<
    // agrees with superclass
	//valign:isc.Canvas.CENTER,

    //>	@attr	isc.ImgTab.actionType		(ButtonActionType : isc.Button.BUTTON : IRWA)
	//			button behavior -- BUTTON, RADIO or CHECKBOX
	//<                                        
	actionType:isc.Button.RADIO,
    
    
    mozOutlineOffset:"0px"
});

isc.ImgTab.addProperties({

    //>EditMode 
    // needed so that we can autodiscover this method to update the pane.
    setPane : function (pane) {
        this.parentElement.parentElement.updateTab(this, pane);
    }, 
    // needed to allow a zero-parameter action for selecting a tab
    selectTab : function () {
        this.parentElement.parentElement.selectTab(this);
    },
    //<EditMode
    
    initWidget : function (a,b,c,d,e,f) {    
        // set up skinImgDir and 'vertical' properties based on this.tabBarPosition - where this
        // tab will appear.
	    this.skinImgDir = this.skinImgDir + this.tabBarPosition + "/";
        this.vertical = (this.tabBarPosition == isc.Canvas.LEFT || 
                         this.tabBarPosition == isc.Canvas.RIGHT);

        if (this.vertical && this.titleStyle) this.titleStyle = "v" + this.titleStyle;
        
        return this.invokeSuper(isc.ImgTab, this._$initWidget, a,b,c,d,e,f);
    }
});
