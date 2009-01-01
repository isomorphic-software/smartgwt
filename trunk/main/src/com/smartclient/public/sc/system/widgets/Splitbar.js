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

 


// Splitbar
// --------------------------------------------------------------------------------------------
// A Splitbar points to a "target" and will resize the target according to the target's minHeight
// and maxHeight.  Used as 'resizeBar's in layouts.

//> @class Splitbar
//  Subclass of the +link{class:StretchImg} class. As with the +link{class:ImgSplitbar} class, 
//  widgets of this class can be displayed as a resize-bar for widgets 
//  in Layouts where showResizeBar is set to true. Provides a different appearance from
//  the <code>ImgSplitbar</code> class.<br>
//  To specify the resizeBar class for some layout, use the +link{layout.resizeBarClass}
//  property.
// @see class:Layout
// @see class:ImgSplitbar
// @treeLocation Client Reference/Layout
//  @visibility external
//<





// Shared splitbar properties and methods
// Applied to 'Splitbar' class (stretchImg based) and 'ImgSplitbar' class
isc._SplitbarProperties = {

    //> @attr   Splitbar.target     (Canvas : null : R)
    // When a <code>Splitbar</code> is created by a layout, the <code>target</code> property
    // of the Splitbar will be a pointer to the member for which it is acting as a resizeBar.
    // The Splitbar will be positioned next to its target, and will resize it on drag completion.
    // @visibility external
    //<

    //> @attr   Splitbar.vertical    (boolean : null : R)
    // Is this split bar vertically orientated?<br>
    // When a <code>Splitbar</code> is created by a layout to be the resizeBar for some
    // member of the layout, the <code>vertical</code> property will be set to <code>true</code>
    // if the layout is horizontal, meaning this resizeBar will be taller than it is wide, 
    // and will allow horizontal resizing of the member.
    // @visibility external
    //<
  
    //> @attr   Splitbar.src    (SCImgURL : null : IR)
    // @include StretchImg.src
    // @visibility external
    //<
    
    //> @attr   Splitbar.hSrc   (SCImgURL : null : IR)
    // @include StretchImg.hSrc
    // @visibility external
    //<
    
    //> @attr   Splitbar.vSrc   (SCImgURL : null : IR)
    // @include StretchImg.vSrc
    // @visibility external
    //<
    
    //> @attr   Splitbar.capSize    (integer : null : IR)
    // @include StretchImg.capSize
    // @visibility external
    //<
    
    //> @attr   Splitbar.skinImgDir    (string : null : IR)
    // @include Canvas.skinImgDir
    // @visibility external
    //<

    //> @attr   Splitbar.showGrip    (boolean : null : IRA)
    // @include StretchImg.showGrip
    // @visibility external
    //<

    // -----
        
    
    //> @attr   SplitBar.gripImgSuffix (string : "grip" : IRA)
    // part name for the 'grip' image if +link{SplitBar.showGrip} is true
    // @group grip
    // @visibility external
    //<
    
    
    //> @attr   Splitbar.showDownGrip   (boolean : null : IRA)
    // If +link{SplitBar.showGrip} is true, this property determines whether to show the
    // 'Down' state on the grip image when the user mousedown's on this widget. 
    // Has no effect if +link{statefulCanvas.showDown} is false
    // @visibility external
    // @group grip
    //<

    //> @attr   Splitbar.showRollOverGrip   (boolean : null : IRA)
    // If +link{Splitbar.showGrip} is true, this property determines whether to show the
    // 'Over' state on the grip image when the user rolls over on this widget. 
    // Has no effect if +link{statefulCanvas.showRollOver} is false
    // @visibility external
    // @group grip
    //<
      
    //> @attr   splitbar.showClosedGrip   (boolean : null : IRA)
    // If +link{splitbar.showGrip} is true, this property determines whether the grip image
    // displayed should show the <code>"Closed"</code> state when the +link{Splitbar.target} 
    // is hidden.
    // @visibility external
    // @group grip
    //<

    // on drag, we resize a target widget
    //> @attr   Splitbar.canDrag    (boolean : true : IRW)
    // <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the
    // Splitbar will resize it's +link{Splitbar.target, target}
    // @visibility external
    //<
	canDrag:true,
    
    dragAppearance:"none",
    
	dragStartDistance:1, 
	
    //> @attr   Splitbar.canCollapse    (boolean : true : IRW)
    // If this property is true, a click on the Splitbar will collapse its 
    // +link{Splitbar.target, target}, hiding it and shifting the Splitbar and other members
    // of the layout across to fill the newly available space. If the target is already hidden
    // a click will expand it again (showing it at it's normal size).
    // @visibility external
    //<
    canCollapse:true,   // enables click-to-collapse behavior
    // cursor - default to different cursors based on vertical or horizontal splitbars
    //> @attr   Splitbar.cursor (Cursor : "hand" : IRW)
    // Splitbars' cursors are set at init time based on whether they are to be used for vertical or
    // horizontal resize.  To customize the cursor for this class, modify 
    // +link{Splitbar.vResizeCursor} or +link{Splitbar.hResizeCursor} rather than this property.
    // @visibility external
    // @group cursor
    //<
    cursor:"hand",
    
    //> @attr Splitbar.vResizeCursor    (Cursor : "row-resize" : IR)
    // Cursor to display if this Splitbar is to be used for vertical resize of widgets.
    // @visibility external
    // @group cursor    
    //<
    vResizeCursor:"row-resize",
    //> @attr Splitbar.hResizeCursor    (Cursor : "col-resize" : IR)
    // Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
    // @visibility external
    // @group cursor    
    //<
    hResizeCursor:"col-resize",   

    resizeInRealTime:false,
    _redrawWithMaster:false, 
    _resizeWithMaster:false,
    overflow:"hidden",

    
    isMouseTransparent:true
    
};

isc._SplitbarMethods = {

	initWidget : function () {
        // vertical switch of hSrc/vSrc is handled by StretchImg, but not by Img
        if (isc.isA.Img(this)) this.src = this.vertical ? this.vSrc : this.hSrc;
        
        if (this.vertical) {
            this.defaultWidth = this.defaultWidth || 10;
	        this.cursor = this.hResizeCursor;
            this.baseStyle = this.vBaseStyle || this.baseStyle;
        } else {
            this.defaultHeight = this.defaultHeight || 10;
	        this.cursor = this.vResizeCursor;
            this.baseStyle = this.hBaseStyle || this.baseStyle;
        }
	
        this.Super("initWidget", arguments);

        
		if (isc.Browser.isMoz) this.bringToFront();
	},
    
    // Override 'makeLabel' to ensure the label, showing any 'grip' image picks up the custom
    // closed state for the grip if appropriate
    
    makeLabel : function () {
        this.Super("makeLabel", arguments);
        this.label.addMethods({
            getCustomState : function () {
                var bar = this.masterElement;
                if (!bar.showClosedGrip) return

                var target = bar.target,
                    isHidden = target.visibility == isc.Canvas.HIDDEN;
                if ((!bar.targetAfter && isHidden) || (bar.targetAfter && !isHidden)) {
                    return "closed";
                }
            }
        })
        
    },

	dragStart : function () {
		if (this.showDown) this.setState("Down"); // note: case sensitive
        this.bringToFront(); // so we aren't occluded by what we will drag resize
	},
	dragMove : function () {
        var offset = this.vertical ? (0 - isc.EH.dragOffsetX) : (0 - isc.EH.dragOffsetY);
        this.resizeTarget(this.target, !this.vertical, this.resizeInRealTime, offset,
                          null, null, this.targetAfter);
	},
	dragStop : function () {
		if (this.showDown) this.setState("");
        this.finishTargetResize(this.target, !this.vertical, this.resizeInRealTime);
	},
    
    click : function () {
        if (this.canCollapse != true) return;
        // toggle target visibility on click
        var target = this.hideTarget || this.target;

        if (!this.target) return;

        // Note: call showMember/hideMember so animation kicks in if configured on the Layout
        if (target.visibility == 'hidden') {
            if (isc.isA.Layout(target.parentElement)) target.parentElement.showMember(target); 
            else target.show();

            this.canDrag = true;
        } else {
            if (isc.isA.Layout(target.parentElement)) target.parentElement.hideMember(target); 
            else target.hide();

            // disallow dragging while target is hidden
            this.canDrag = false;
        }
        // HACK: fixes problem where the bar can remain stuck in "over" state until the next
        // mouse move, because the bar is moved out from under the mouse by the relayout that
        // follows hiding our target.
        this.setState("");
    }
};


// Splitbar (Doc'd at the top of the file)
isc.defineClass("Splitbar","StretchImg").addProperties({
	skinImgDir:"images/Splitbar/",
    imageType:"stretch",
	capSize:3,
    vSrc:"[SKIN]vsplit.gif",
    hSrc:"[SKIN]hsplit.gif"
});
isc.Splitbar.addMethods(isc._SplitbarProperties, isc._SplitbarMethods);


//> @class ImgSplitbar
//  Subclass of the +link{class:Img} class. As with the +link{class:Splitbar} class, 
//  widgets of this class can be displayed as a resize-bar for widgets 
//  in Layouts where showResizeBar is set to true. Provides a different appearance from
//  the <code>Splitbar</code> class.<br>
//  To specify the resizeBar class for some layout, use the +link{layout.resizeBarClass}
//  property.
// @see class:Layout
// @see class:Splitbar
// @treeLocation Client Reference/Layout
//  @visibility external
//<
isc.defineClass("ImgSplitbar","Img").addProperties({


    //> @attr   ImgSplitbar.target     (Canvas : null : R)
    // @include Splitbar.target
    // @visibility external
    //<
  
    //> @attr   ImgSplitbar.vertical    (boolean : null : R)
    // @include Splitbar.vertical
    // @visibility external
    //<
    
    //> @attr   ImgSplitbar.canDrag    (boolean : true : IRW)
    // @include Splitbar.canDrag
    // @visibility external
    //<
    
    //> @attr   ImgSplitbar.canCollapse    (boolean : true : IRW)
    // @include Splitbar.canCollapse
    // @visibility external
    //<
    
    //> @attr   ImgSplitbar.skinImgDir    (SCImgURL : "images/SplitBar/" : IR)
    // @include Canvas.skinImgDir
    // @visibility external
    //<
    skinImgDir:"images/Splitbar/",
    imageType:"center",
    
    //> @attr   ImgSplitbar.src    (string : null : IR)
    // @include Img.src
    // @visibility external
    //<
    
    //> @attr   ImgSplitbar.hSrc   (string : [SKIN]hgrip.png : IR)
    // Default src to display when +link{ImgSplitbar.vertical} is false, 
    // and +link{ImgSplitbar.src} is unset.
    // @see ImgSplitbar.src
    // @visibility external
    //<
    hSrc:"[SKIN]hgrip.png",
    
    //> @attr   ImgSplitbar.vSrc   (SCImgURL : [SKIN]vgrip.png : IR)
    // Default src to display when +link{ImgSplitbar.vertical} is true, 
    // and +link{ImgSplitbar.src} is unset.
    // @see ImgSplitbar.src
    // @visibility external
    //<
    vSrc:"[SKIN]vgrip.png",
    
    styleName:"splitbar",
    showDown:true   // to hilite the entire bar via CSS, instead of dragging just the grip image
});
isc.ImgSplitbar.addMethods(isc._SplitbarProperties, isc._SplitbarMethods);


// StretchImgSplitbar

isc.addGlobal("StretchImgSplitbar", isc.Splitbar);

// LayoutResizeBar - for backcompat only.
// Note that "LayoutResizeBar" was used as the default 'resizeBarClassName' for the Layout class
// for builds up to and including 5.5.1 
isc.addGlobal("LayoutResizeBar", isc.Splitbar);


// VSplitbar / HSplitbar
// --------------------------------------------------------------------------------------------
isc.defineClass("HSplitbar","Splitbar").addProperties({
    vertical:false
});

isc.defineClass("VSplitbar","Splitbar");

// Stretchbar
// --------------------------------------------------------------------------------------------
// This is a splitbar that only shows up on rollover

isc.defineClass("Stretchbar", "Splitbar").addProperties({
    canResize:false,
	skinImgDir:"images/Stretchbar/",
    showRollOver:true
});

// HStretchbar / VStretchbar
// --------------------------------------------------------------------------------------------
isc.defineClass("HStretchbar", "Stretchbar").addProperties({
    vertical:false,
	src:"[SKIN]hsplit.gif",
	defaultHeight:10
});

isc.defineClass("VStretchbar", "Stretchbar").addProperties({
	src:"[SKIN]vsplit.gif",
	defaultWidth:10
});



//> @class Snapbar
// Subclass of the +link{class:Splitbar} class that uses the <code>grip</code> functionality
// to show a stateful open / close indicator.
// @see class:Splitbar
// @see class:Layout
// @treeLocation Client Reference/Layout
//  @visibility external
//<
isc.defineClass("Snapbar", "Splitbar");

isc.Snapbar.addProperties({
    //> @attr   Snapbar.showRollOver    (boolean : true : IRW)
    // Snapbars show rollover styling.
    // @visibility external
    //<
    showRollOver:true,

    //> @attr   Snapbar.showDown (boolean : true : IRW)
    // Snapbars show mouse-down styling.
    // @visibility external
    //<    
    showDown:true,
    
    //> @attr   Snapbar.showGrip    (boolean : true : IRW)
    // @include Splitbar.showGrip
    // @visibility external
    //<
    showGrip:true,
    
    //> @attr   Snapbar.showDownGrip    (boolean : true : IRW)
    // @include Splitbar.showDownGrip
    // @visibility external
    //<
    showDownGrip:true,

    //> @attr   Snapbar.showRollOverGrip   (boolean : true : IRA)
    // @include Splitbar.showRollOverGrip
    // @visibility external
    //<
    showRollOverGrip:true,
    
    //> @attr   Snapbar.showClosedGrip   (boolean : true : IRA)
    // @include splitbar.showClosedGrip
    // @visibility external
    // @group grip
    //<
    showClosedGrip:true,
    
    //> @attr   Snapbar.gripImgSuffix (string : "snap" : IRA)
    // Overridden from +link{Splitbar.gripImgSuffix} to simplify providing custom grip media
    // for this widget.
    // @visibility external
    //<
    gripImgSuffix:"snap"
    
});

//> @class ToolStripResizer
// Simple subclass of ImgSplitbar with appearance appropriate for a ToolStrip resizer.
//
// @treeLocation Client Reference/Layout/ToolStrip
// @visibility external
//<
isc.defineClass("ToolStripResizer", "ImgSplitbar").addProperties({
    //> @attr toolStripResizer.skinImgDir (SCImgURL : "images/ToolStrip/" : IR)
    // Path to resizer image.
    // @visibility external
    //<
    skinImgDir:"images/ToolStrip/",

    //> @attr toolStripResizer.vSrc (SCImgURL : "[SKIN]resizer.png" : IRW)
    // Image for resizer
    // @visibility external
    //< 
    vSrc:"[SKIN]resizer.png",

    //> @attr toolStripResizer.hSrc (SCImgURL : "[SKIN]hresizer.png" : IRW)
    // Image for horizontal resizer for a vertical Toolstrip
    // @visibility external
    //< 
    hSrc:"[SKIN]hresizer.png",

    // prevents misalignment if ToolStrip is stretched vertically by members
    layoutAlign:"center",

    resizeInRealTime:true,
    showDown:false,

    // center the image and set imageHeight/imageWidth to avoid issues with natural sizing of
    // image with IE .pngs.  Alternatively, we could stretch (commented out), which is
    // imperfect (due to arrows in default image), but looks reasonable within the likely
    // possible heights of a ToolStrip (~ 18 - 24)
    imageLength:20, imageBreadth:14, imageType:"center",
    //imageType:"stretch",

    initWidget : function () {
        this.imageWidth = this.vertical ? this.imageBreadth : this.imageLength;
        this.imageHeight = this.vertical ? this.imageLength : this.imageBreadth;
        this.Super("initWidget", arguments);
    }

});

