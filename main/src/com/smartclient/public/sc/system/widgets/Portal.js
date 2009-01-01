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

 
// Portlet
// ---------------------------------------------------------------------------------------

// A Layout that automatically creates Portlets on drop(), using the EditContext interface
isc.defineClass("PortletContainer", "Layout", "EditContext").addProperties({
    defaultResizeBars : "marked",
    getDropComponent : function (dragTarget, dropPosition) {
         // portlet moved
        if (!isc.isA.Palette(dragTarget)) return dragTarget;
    
        // other, drag and drop from palette, create new portlet
        var data = dragTarget.transferDragData(),
            component = (isc.isAn.Array(data) ? data[0] : data);
    
        // create a new portlet
        var newPortlet = isc.Portlet.create({
            autoDraw:false,
            title: component.title,
            items:[ component.liveObject ],
            closeClick: function () {
                isc.confirm("Close portlet?", "if(value)"+this.getID()+".destroy()");
            }
        });
        return newPortlet;
    }

});


// Portlet
// ---------------------------------------------------------------------------------------

// special subclass of Window that can maximimize and minimize within a PortletContainer
isc.defineClass("Portlet", "Window").addProperties({
    showShadow:false,
    
    // enable predefined component animation
    animateMinimize:true,

    // Window is draggable with "outline" appearance by default.
    // "target" is the solid appearance.
    dragAppearance:"outline",
    canDrop:true,
    dragType: "Portlet", 

    // resize from any edge
    resizeFrom: null,

    // customize the appearance and order of the controls in the window header
    // (could do this in load_skin.js instead)
    showMaximizeButton: true,
    headerControls:["headerLabel", "minimizeButton", "maximizeButton", "closeButton"],

    // show either a shadow, or translucency, when dragging a portlet
    // (could do both at the same time, but these are not visually compatible effects)
    //showDragShadow:true,
    dragOpacity:30,
    
    closeClick : function () {
        isc.confirm("Close portlet?", "if(value)"+this.getID()+".hide()");
    },

    maximize : function () {
        var width = this.getVisibleWidth(), 
            height = this.getVisibleHeight(),
            pageLeft = this.getPageLeft(), 
            pageTop = this.getPageTop()
        ;

        this._portletPlaceholder = isc.Canvas.create({
            width: this.getVisibleWidth(),
            height: this.getVisibleHeight()
        });
        this.masterLayout = this.parentElement;
        this.masterLayout.portletMaximizing = true;
        this.masterLayout.replaceMember(this, this._portletPlaceholder, false);
        this.masterLayout.portletMaximizing = false;

        // maximize to the dashboard container, not whole window
        this.setWidth(width);
        this.setHeight(height);

        this.moveTo(pageLeft, pageTop);
        this.bringToFront();
        this.draw();

        this.delayCall("doMaximize");
    },
    

    completeRestore : function () {
        this.Super("completeRestore", arguments);
        this.masterLayout.portletMaximizing = true;            
        this.masterLayout.replaceMember(this._portletPlaceholder, this);
        this.masterLayout.portletMaximizing = false;
        this._portletPlaceholder.destroy();
        delete this._portalPlaceholder;
        delete this.masterLayout;
    },

    doMaximize : function () {
        this.Super("maximize", arguments);
    }
});

// provides a menu for adding a remove columns
isc.defineClass("PortalColumnHeader", "HLayout").addProperties({
    height: 20,
    noResizer: true,

    border:"1px solid #CCCCCC",

    // allow dragging by the header
    canDragReposition: true, 

    initWidget : function () {
        this.Super("initWidget", arguments);

        // header drags the portalColumn
        this.dragTarget = this.portalColumn;

        this.addMember(isc.LayoutSpacer.create());

        this.menu = isc.Menu.create({
            width: 150,
            portalColumn: this.portalColumn,
            data:[
                {title:"Remove Column",
                 click:"menu.portalColumn.destroy()"},
                {title:"Add Column",
                 click:"menu.portalColumn.addNewColumn()"}
            ]
        });

        this.addMember(isc.MenuButton.create({
            title: "Column Properties",
            width: 150,
            menu: this.menu
        }));

        this.addMember(isc.LayoutSpacer.create());
    }
});

// Manages horizontal vs vertical drag and drop such that a drop to the sides is a drop within
// this PortalRow and a drop above or below is a drop within the parent, before or after this
// PortalRow.
// Created whenever a drop occurs in a PortalColumn (even if it's the first drop).
isc.defineClass("PortalRow", "PortletContainer").addProperties({
    vertical : false,

    overflow: "hidden",
    // leave some space between portlets
    layoutMargin: 3,

    // enable drop handling
    canAcceptDrop:true,
    dropTypes: ["Portlet"],
    
    // change appearance of drag placeholder and drop indicator
    dropLineThickness:2,
    dropLineProperties:{backgroundColor:"blue"},

    // number of pixels you have to be within the left or right border of a portlet for us to
    // show a drop to the left or right of this portlet.  If not within this margin, drop is
    // indicated above or below instead.
    hDropOffset: 15,
    isHDrop : function () {
        var dropPosition = this.getDropPosition();
        var dropOverTarget = this.getMember(dropPosition == 0 ? 0 : dropPosition - 1);
        if (!dropOverTarget.containsEvent() && dropPosition < this.members.length) {
            dropOverTarget = this.getMember(dropPosition);
        }

        var targetOffsetX = dropOverTarget.getOffsetX();
        if (targetOffsetX < this.hDropOffset || targetOffsetX > dropOverTarget.getVisibleWidth() - this.hDropOffset) {
            return true;
        } else {
            return false;
        }
    },

    dropMove : function () {
        if (this.isHDrop()) {
            this.Super("dropMove", arguments);        
            this.parentElement.hideDropLine();
            return isc.EH.STOP_BUBBLING;        
        } else {
            this.hideDropLine();
        }
    },
    
    dropOver : function () {
        if (this.isHDrop()) {
            this.Super("dropOver", arguments);        
            this.parentElement.hideDropLine();
            return isc.EH.STOP_BUBBLING;        
        } else {
            this.hideDropLine();
        }
    },

    drop : function () {
        if (this.isHDrop()) {
            this.Super("drop", arguments);
            
            this.parentElement.hideDropLine();
            this.hideDropLine();
            return isc.EH.STOP_BUBBLING;        
        } else {
            this.hideDropLine();
        }        
    },

    membersChanged : function () {
        if (this.members.length == 0 && !this.portletMaximizing) this.destroy();
        else this.invokeSuper(isc.PortalRow, "membersChanged", arguments);
    }

});

// PortalColumn
// ---------------------------------------------------------------------------------------

// Offers Drag and drop creation of Portlets, where a new PortalRow is created to manage the
// portlet.
isc.defineClass("PortalColumn", "PortletContainer").addProperties({
    vertical:true,

    border: "1px solid gray",

    // leave some space between portlets
    layoutMargin: 3, 
    dragAppearance:"outline",

    // enable drop handling
    canAcceptDrop:true,
    canDrop: true,

    dragType: "PortalColumn",
    dropTypes: ["Portlet"],
    
    // change appearance of drag placeholder and drop indicator
    dropLineThickness:2,
    dropLineProperties:{backgroundColor:"blue"},

    initWidget : function () {
        this.Super("initWidget", arguments);
        this.columnHeader = isc.PortalColumnHeader.create({
            title: "Column",
            portalColumn: this
        });
        this.addMember(this.columnHeader);
    },

    addNewColumn : function () {
        this.portalLayout.addColumnAfter(this);
    },

    getDropComponent : function (dragTarget, dropPosition) {
        var portlet = this.Super("getDropComponent", arguments);
        
        var portalRow = isc.PortalRow.create();
        this.addMember(portalRow, this.getDropPosition());
        portalRow.addMember(portlet);
    },
    
    getDropPosition : function () {
        var dropPosition = this.Super("getDropPosition", arguments);

        // do not allow drop above column header
        if (dropPosition == 0) dropPosition = 1;
        return dropPosition;
    }
});



// PortalLayout
// ---------------------------------------------------------------------------------------

// creates and manages a specified number of PortalColumns, providing an API to add a new one
isc.defineClass("PortalLayout", "Layout").addProperties({
    vertical:false,
    numColumns:2,

    canAcceptDrop: true,
    dropTypes: ["PortalColumn"],

    // change appearance of drag placeholder and drop indicator
    dropLineThickness:2,
    dropLineProperties:{backgroundColor:"blue"},

    initWidget : function () {
        this.Super("initWidget", arguments);
        // create multiple PortalColumn components
        for (var i = 0; i < this.numColumns; i++) this.addMember(this.makePortalColumn());
    },

    makePortalColumn : function (props) {
        var portalColumn = isc.PortalColumn.create({
            portalLayout: this
        }, props);

        return portalColumn;
    },

    addColumnAfter : function (portalColumn) {
        var targetIndex = this.getMemberNumber(portalColumn)+1;
        this.addMember(this.makePortalColumn({

        }), targetIndex);
    }
});

