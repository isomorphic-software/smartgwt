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

 




//>	@class	ToolStrip
// 
// Base class for creating toolstrips like those found in browsers and office applications: a
// mixed set of controls including +link{ImgButton,icon buttons}, 
// +link{button.radioGroup,radio button groups}, +link{MenuButton,menus},
// +link{ComboBoxItem,comboBoxes}, +link{LayoutSpacer,spacers}, +link{Label,status displays} and 
// +link{SelectItem,drop-down selects}.  
// <P>
// All of the above components are placed in the +link{ToolStrip.members,members array} to form
// a ToolStrip.  Note that the +link{FormItem,FormItems} mentioned above (ComboBox and
// drop-down selects) need to be placed within a +link{DynamicForm} as usual.
// <P>
// The special strings "separator" and "resizer" can be placed in the members array to create
// separators and resizers respectively.
// <P>
// Also see the +explorerExample{toolstrip} example in the Feature Explorer.
//
// @treeLocation Client Reference/Layout
// @visibility external
// @example toolstrip
//<

isc.defineClass("ToolStrip", "Layout").addProperties({
	
    //> @attr toolStrip.members (Array of Canvas : null : IR)
    // Array of components that will be contained within this Toolstrip, like
    // +link{Layout.members}, with the following special behaviors:
    // <ul>
    // <li>the String "separator" will cause a separator to be created (instance of 
    // +link{separatorClass})
    // <li>the String "resizer" will cause a resizer to be created (instance of
    // +link{resizeBarClass}).  This is equivalent to setting
    // +link{canvas.showResizeBar,showResizeBar:true} on the preceding member.
    // </ul>
    // 
    // @visibility external
    // @example toolstrip
    //<

    //> @attr toolStrip.height (Number : 20 : IRW)
    // ToolStrips set a default +link{Canvas.height,height} to avoid being stretched by
    // containing layouts.
    // @group sizing
    // @visibility external
    //<
    height: 20,
    
    defaultWidth: 250,

    //> @attr toolStrip.styleName (CSSClassName : "toolStrip" : IRW)
    // @include canvas.styleName
    //<
    styleName: "toolStrip",

	//>	@attr	toolStrip.vertical		(boolean : false : [IRW])
	// Indicates whether the components are drawn horizontally from left to right (false), or
    // vertically from top to bottom (true).
	//		@group	appearance
    //      @visibility external
	//<
	vertical:false,

    //> @attr toolStrip.resizeBarClass (String : "ToolStripResizer" : [IRW])
    // Customized resizeBar with typical appearance for a ToolStrip
    // @visibility external
    //<
    // NOTE: class definition in Splitbar.js
    resizeBarClass: "ToolStripResizer",

	//> @attr toolStrip.resizeBarSize (integer : 14 : IRA)
    // Thickness of the resizeBars in pixels
    // @visibility external
	//<
    resizeBarSize: 14,

    //> @attr toolStrip.separatorClass (String : "ToolStripSeparator" : [IRW])
    // Class to create when the string "separator" appears in +link{toolStrip.members}.
    // @visibility external
    //<
    separatorClass : "ToolStripSeparator",

    //> @attr toolStrip.separatorSize (integer : 8 : IR)
    // Separator thickness in pixels
    // @visibility external
    //<
    separatorSize : 8,
    
    initWidget : function (a,b,c,d,e,f) {
        this.members = this._convertMembers(this.members);
        this.invokeSuper(isc.ToolStrip, this._$initWidget, a,b,c,d,e,f);
    },

    // support special "separator" and "resizer" strings
    _convertMembers : function (members) {
        var separatorClass = isc.ClassFactory.getClass(this.separatorClass);
        if (members == null) return null;
        var newMembers = [];
        for (var i = 0; i < members.length; i++) {
            if (members[i] == "separator") {
                var separator = separatorClass.createRaw();
                separator.autoDraw = false;
                separator.vertical = !this.vertical;
                if (this.vertical) {
                    separator.height = this.separatorSize;
                } else {
                    separator.width = this.separatorSize;
                }
                separator.completeCreation();
                newMembers.add(separator);
            } else if (members[i] == "resizer" && i > 0) {
                members[i-1].showResizeBar = true;
            // handle being passed an explicitly created ToolStripResizer instance.
            // Incorrect usage but plausible.
            } else if (isc.isA.ToolStripResizer(members[i]) && i > 0) {
                members[i-1].showResizeBar = true;
                members[i].destroy();
            } else {
                // handle being passed an explicitly created ToolStripSeparator instance.
                // Incorrect usage but plausible.
                if (isc.isA.ToolStripSeparator(members[i])) {
                    var separator = members[i];
                    separator.vertical = !this.vertical;
                    separator.setSrc(this.vertical ? separator.hSrc : separator.vSrc);
                    if (this.vertical) {
                        separator.setHeight(this.separatorSize);
                    } else {
                        separator.setWidth(this.separatorSize);
                    }
                    separator.markForRedraw();
                }
                newMembers.add(members[i]);
            }
        }
        return newMembers;
    },
    addMembers : function (newMembers, position, dontAnimate,d,e) {
        if (!newMembers) return;
        if (!isc.isAn.Array(newMembers)) newMembers = [newMembers];

        var firstMember = newMembers[0],
            isResizerWidget = isc.isA.ToolStripResizer(firstMember);
        if (firstMember == "resizer" || isResizerWidget) {
            position = position || this.members.length;
            var precedingPosition = Math.min(position, this.members.length) -1;
            if (precedingPosition > 0) {
                var precedingMember = this.getMember(precedingPosition);
                if (precedingMember != null) {
                    precedingMember.showResizeBar = true;
                    this.reflow();
                }
            }
            var resizer = newMembers.shift();
            if (isResizerWidget) resizer.destroy();
        }
            
        newMembers = this._convertMembers(newMembers);
        return this.invokeSuper(isc.ToolStrip, "addMembers", newMembers,position,dontAnimate,d,e);
    }

});

//> @class ToolStripSeparator
// Simple subclass of Img with appearance appropriate for a ToolStrip separator
// @treeLocation Client Reference/Layout/ToolStrip
//
// @visibility external
//<
isc.defineClass("ToolStripSeparator", "Img").addProperties({
    //> @attr toolStripSeparator.skinImgDir (URL : "images/ToolStrip/" : IR)
    // Path to separator image.
    // @visibility external
    //<
    skinImgDir:"images/ToolStrip/",

    //> @attr toolStripSeparator.vSrc (SCImgURL : "[SKIN]separator.png" : IRW)
    // Image for vertically oriented separator (for horizontal toolstrips).
    // @visibility external
    //< 
    vSrc:"[SKIN]separator.png",

    //> @attr toolStripSeparator.hSrc (SCImgURL : "[SKIN]hseparator.png" : IRW)
    // Image for horizontally oriented separator (for vertical toolstrips).
    // @visibility external
    //< 
    hSrc:"[SKIN]hseparator.png",

    // NOTE: we keep the default imageType:"stretch", which looks fine for the default image,
    // which is just two vertical lines.
    
    // prevents misalignment if ToolStrip is stretched vertically by members
    layoutAlign:"center",

    initWidget : function () {
        // vertical switch of hSrc/vSrc is handled by StretchImg, but not by Img
        if (isc.isA.Img(this)) this.src = this.vertical ? this.vSrc : this.hSrc;

        this.Super("initWidget", arguments);
    }

});
