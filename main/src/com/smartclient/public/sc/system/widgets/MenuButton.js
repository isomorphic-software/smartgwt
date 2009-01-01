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

 






//>	@class	MenuButton
//
//  Simple subclass of button associated with a menu widget (gets shown below the button).
// @visibility external
// @treeLocation Client Reference/Control
//<


// define us as a subclass of the Button
isc.ClassFactory.defineClass("MenuButton", "Button");


// add contants
isc.MenuButton.addProperties({
    //>	@attr	menuButton.title		(string : "Show Menu" : IRW)
	//			Default title for the button.
    //  @visibility external
    // @group i18nMessages
	//<
    title:"Show Menu",
    
    //>	@attr	menuButton.baseStyle		(CSSStyleName : "menuButtonText" : IRW)
	//			CSS baseStyle for the button
	//<
    baseStyle:"menuButton",        

    //>	@attr	menuButton.height		(Number or String : 22 : IRW)
	//			Default height of the button.
    // @visibility external
	//<
	height:22,

    //>	@attr	menuButton.showMenuButtonImage		(boolean : true : IR)
    //			show menu button image (up / down arrowhead) for this menu button
    // @visibility external
    //<
    showMenuButtonImage:true,
    
    //>	@attr	menuBar.skinImgDir		(URL : "images/Menu/" : IRA)
    //		Where do 'skin' images (those provided with the class) live?
    //		This is local to the Page.skinDir
    //		@group	appearance, images
    //<
	skinImgDir:"images/Menu/",				    
    
    // We use the standard button icon handling to write out the menu button image
    // We need both standard (down) and "up" variations because of the menu showing above 
    // or below the button.
    
    //>	@attr	menuButton.menuButtonImage		(SCImgURL : "[SKIN]menu_button.gif" : IRA)
    // Image for menu button indicating that the button expands a menu.  This image is shown
    // for menus expanding down from the button.   Menu direction is controlled by
    // +link{MenuButton.showMenuBelow}.
    //
    // @see menuButton.menuButtonImageUp
    // @visibility external
    //<
	menuButtonImage:"[SKIN]menu_button.gif",

    //>	@attr	menuButton.menuButtonImageUp		(SCImgURL : "[SKIN]menu_button_up.gif" : IRA)
    // Image for menu button indicating that the button expands a menu.  This image is shown
    // for menus expanding up from the button.   Menu direction is controlled by
    // +link{MenuButton.showMenuBelow}.
    //
    // @see menuButton.menuButtonImage
    // @visibility external
    //<											
	menuButtonImageUp:"[SKIN]menu_button_up.gif",
    
    //> @attr   menuButton.hiliteAccessKey  (boolean : true : IR)
    // If this MenuButton has a specified +link{canvas.accessKey, accessKey}, underline it
    // in the title of the button by default
    // @visibility external
    //<
    hiliteAccessKey:true,
    
    // Default menuButtonImage size is 7px
    iconWidth:7,
    iconHeight:7,
    
    // Show the arrow on the right of the title, aligned with the right edge of the button.
    iconOrientation:"right",
    iconAlign:"right",

    // Align the title to the left of the button (away from the icon) by default.
    align:"left",
    
    //>	@attr	menuButton.showMenuBelow		(boolean : true : IRW)
    //			The menu drops down below the menu button.
    //			Set to false if the menu should appear above the menu button.
    // @visibility external
    //<				
	showMenuBelow:true,
    //>	@attr	menuButton.alignMenuLeft		(boolean : true : IRW)
    //			If true align the menu with the left edge of the menu button. Otherwise align
    //          with the right edge of the menu button
    //<	
    
    alignMenuLeft: true,
    //>	@attr	menuButton.menu		(Menu : null : IRW)
    //			The menu to show.
    // @visibility external
    //<
    menu:null
    
    //>Animation
    //> @attr menuButton.menuAnimationEffect (string : null : IRWA)
    // Allows you to specify an animation effect to apply to the menu when it is being shown.
    // Valid options are "none" (no animation), "fade", "slide" and "wipe".
    // If unspecified falls through to <code>menu.showAnimationEffect</code>
    // @visibility animation
    //<
    //<Animation
});                                    

isc.MenuButton.addMethods({

    // Choose the appropriate icon depending on whether the menu will be shown above or
    // below this menubutton.
    initWidget : function (a,b,c,d) {
        if (this.showMenuButtonImage)  this._setUpIcon();
        return this.invokeSuper(isc.MenuButton, "initWidget", a,b,c,d);
    },
    
    // setter for showMenuButtonImage and showMenuBelow - required since we need to update the 
    // icon property and trip a redraw
    //>@method MenuButton.setShowMenuButtonImage
    // Setter for the 'showMenuButtonImage' property - shows/hides the menu button image
    // at runtime
    // @param show (boolean) Should the image be shown
    // @visibility external
    //<
    setShowMenuButtonImage : function (show) {
        if (show == this.showMenuButtonImage) return;
        this.showMenuButtonImage = show;
        if (show) this._setUpIcon();
        else this.icon = null;
        if (this.isDrawn()) this.markForRedraw();
    },
    
    //>@method MenuButton.setShowMenuBelow
    // Setter for the 'showMenuButtonBelow' property - determines whether the menu will be
    // shown above or below the menubutton.
    // @param below (boolean) True if the menu should be shown below the menubutton.
    // @visibility external
    //<
    setShowMenuBelow : function (below) {
        if (below != this.showMenuBelow) {
            this.showMenuBelow = below;
            // If we're not showing the icon we don't need to update anything until we show the icon.
            if (this.showMenuButtonImage) {
                this._setUpIcon();
                if (this.isDrawn()) this.markForRedraw();
            }
        }
    },
    
    // helper to convert the menubutton image to an icon
    _setUpIcon : function () {
        var icon = this.showMenuBelow ? this.menuButtonImage : this.menuButtonImageUp;
        
        if (isc.isAn.Object(icon)) {
            if (icon.width) this.iconWidth = icon.width;
            if (icon.height) this.iconHeight = icon.height;
            this.icon = icon.src;
        } else {
            this.icon = icon;
        }
    },
    

    // If this click didn't come from dismissing a menu shown by this button, 
    // show our menu on click
    
    click : function () {   
        if (this._hidingMenuClick) return;
        this.showMenu();
    },
    
    // This method is fired in response to the Page level click event following the
    // dismissing of the menu we were showing.
    // Use it to clear out this._hidingMenuClick
    
    _hidingMenuClickComplete : function () {
        if (this._hidingMenuClick) {
            var theMenu = this;
            isc.Page.setEvent(isc.EH.IDLE, 
                              function () { theMenu._hidingMenuClick = null },
                              isc.Page.FIRE_ONCE);
        }
    },
    
    // override keypress to show the menu on arrow_down keypress
    keyPress : function () {
        if (isc.EventHandler.lastEvent.keyName == "Arrow_Down") {
                this.showMenu();
                return false;
        }
        return this.Super("keyPress", arguments);
    },
    
    // Override _updateCanFocus to redraw the button when canFocus is changed - this will
    // regenerate the titleHTML, with the appropriate focus behavior.
    _updateCanFocus : function () {
        this.Super("_updateCanFocus", arguments);
        this.markForRedraw();
    },
    
    // override showContext menu to show the menu as well
    showContextMenu : function () {
        this.click();
        return false;   // avoid the native context menu from showing
    },
    
    showMenu : function () {
    
        // lazily create the menu if necessary, so we can init with, or set menu to, an object 
        // properties block
        if (isc.isA.String(this.menu)) this.menu = window[this.menu];
        if (!isc.isA.Menu(this.menu)) this._createMenu(this.menu);
        if (!isc.isA.Menu(this.menu)) return;
        
        
        isc.Menu._currentMenuButton = this;
    
        var menu = this.menu;
        // draw offscreen so that we can figure out what size the menu is
        // Note that we use _showOffscreen which handles figuring out the size, and
        // applying scrollbars if necessary.
        menu._showOffscreen();

        // figure out the left coordinate of the drop-down menu
        var left = this.getPageLeft();

        if (!this.alignMenuLeft) {
            left = left - (menu.getVisibleWidth() - this.getVisibleWidth()); 
        }

        var top = this.showMenuBelow ? this.getPageTop()+this.getVisibleHeight()+1 :  
                                       this.getPageTop()-menu.getVisibleHeight()+2;
        // don't allow the menu to show up off-screen
        menu.placeNear(left, top);
        menu.show(this.menuAnimationEffect);
    },
    
    _createMenu : function (menu) {
        menu.autoDraw = false;
        var cons = this.menuConstructor || isc.Menu;
        this.menu = cons.create(menu);
    }

    
});
    

