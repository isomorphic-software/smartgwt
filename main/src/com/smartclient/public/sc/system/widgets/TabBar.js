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

 





//>	@class	TabBar
// Shows a set of Tabs.  TabBars are automatically created by TabSets and shouldn't be used
// directly.  The TabBar is documented for skinning purposes.
// 
// @treeLocation Client Reference/Layout/TabSet
// @visibility external
//<
isc.ClassFactory.defineClass("TabBar", "Toolbar");

isc.TabBar.addProperties({
	//>	@attr	isc.TabBar.tabs		(Array of Tab Properties : null : IR)
	// Tab for this TabBar.
    // @visibility external
	//<

    //>	@attr	isc.TabBar.breadth	(number : 21 : IRW)
	// Breadth of the tabBar (including baseline breadth)
    // @visibility external
	//<
	breadth: 21,

    //>	@attr	isc.TabBar.buttonConstructor	(class: ImgTab : AIRW)
	// SmartClient component used for the tabs of the tabBar. 
    // Must be Button or Button subclass.
    // @visibility external
	//<
    // Note - if this TabBar is part of a TabSet, this constructor can be overridden by setting 
    // 'useSimpleTabs' on the TabSet - will use buttons instead, styled via CSS to look like
    // tabs.
	buttonConstructor:isc.ImgTab,

    // We want to have arrow keys, not tab-keypresses, move between tabs
    tabWithinToolbar:false,

    //>	@attr	isc.TabBar.skinImgDir		(URL : "images/Tab/" : AIRW)
	//			base path for the tab images, if an image-based
	//			tab is being used.
	//		@group skins, files
	//<
	skinImgDir:"images/Tab/",			
										
	// Baseline
	// --------------------------------------------------------------------------------------------
    
    //> @groupDef baseLine
    // The baseLine is StretchImg that is placed along the edge of the TabBar that borders on
    // the pane, occluding the pane's actual border but matching it exactly.  The selected tab
    // is in front of the baseLine, and the rest are behind it.
    // @visibility external
    //<

    //>	@attr isc.TabBar.baseLineThickness (number : 1 : IR)
	// Thickness of the baseLine, in pixels.  This should be set to match the media specified
    // by +link{baseLineSrc}.  The baseLineThickness also determines the degree of overlap with
    // the TabSet's paneContainer when using decorative edges - see +link{TabSet.paneContainer}
    // for details.
    // 
    // @group baseLine 
    // @visibility external
	//<
	baseLineThickness:1,

    //>	@attr isc.TabBar.baseLineSrc	(SCImgURL : "[SKIN]baseline.gif" : IR)
	// Sets +link{stretchImg.src} for the +link{group:baseLine} StretchImg.
    // @group baseLine 
    // @visibility external
	//<
	baseLineSrc:"[SKIN]baseline.gif",

    //>	@attr isc.TabBar.baseLineCapSize	(number : 2 : IR)
	// Set +link{stretchImg.capSize} for the +link{group:baseLine} stretchImg.
    // @group baseLine
    // @visibility external
	//<
	baseLineCapSize:2,

	// Positioning and Alignment
	// --------------------------------------------------------------------------------------------
    //>	@attr	isc.TabBar.tabBarPosition	(Side : isc.Canvas.TOP : IRW)
	// Position of the tabBar in relation to whatever it controls.
	//<
    // Not doc'd, do via TabSet
	tabBarPosition:isc.Canvas.TOP,

	// --------------------------------------------------------------------------------------------
    //>	@attr	isc.TabBar.selectedTab		(number : 0 : IR)
	// Index of the initially selected tab.  Settable at initialization only, afterwards, call
    // +link{selectTab}.
	//<
    // Not doc'd, do via TabSet
	selectedTab:0,

    //>	@attr	isc.TabBar.defaultTabSize		(number : 80 : IR)
	// Default size (length) in pixels for tabs within this tabBar
    // @visibility external
	//<    
    defaultTabSize:80
										
	//>	@attr	TabBar.tabDefaults		(Tab : 0 : AIR)
	//			Defaults applied to tabs on init.
	//			Note that these are overlaid over the superclass property
	//			toolBar.buttonDefaults.
    //<
    // Null by default - we will set this up in initWidget - this avoids multiple tabBars
    // pointing to the same tabDefaults object
	//tabDefaults:{}
});


isc.TabBar.addMethods({
//>	@method	tabBar.initWidget()	(A)
// Initialize the TabBar object.
// <p>
// Setup special button properties and create the baseLine
//<
initWidget : function () {
	// if the name of the pane property of a tab is specified as a string, check it
	// now, and reassign.
	for (var i = 0; i < this.tabs.length; i++) {
		var pane = this.tabs[i].pane;
		
		if (isc.isA.String(pane) && isc.isA.Canvas(window[pane])) {
			this.tabs[i].pane = window[pane];
		}
        
	}
	
	// copy tabs over to the buttons array, which is what the superclass uses.
	this.buttons = this.tabs;
    
    // Note that the order of the tabs can be reversed by setting the 'reverseOrder' property
    // on this tabBar [can be done in tabBarDefaults] if this is required.
    
    // set up the skinImgDir for the baseline
    this.skinImgDir = this.skinImgDir + this.tabBarPosition + "/";
    
    var tabDefaults = this.tabDefaults;
    if (tabDefaults == null) tabDefaults = this.tabDefaults = {};
    
	// tabs are created as "buttons" by Toolbar superclass code; to have tabDefaults applied to
    // each button, assign to buttonDefaults.
    // NOTE: if we add properties directly to the buttonDefaults object, we'll side effect all
    // Toolbars
	tabDefaults = this.buttonDefaults = isc.addProperties({}, this.buttonDefaults, tabDefaults);

    // tabs are mutually exclusive
    tabDefaults.actionType = isc.StatefulCanvas.RADIO;
    
    // Default tabs to defaultTabWidth
    if (this.vertical) {
        tabDefaults.defaultHeight = this.defaultTabSize;
    } else {
        tabDefaults.defaultWidth = this.defaultTabSize;
    }
    // .. and allow them to expand to fit content
    tabDefaults.overflow = isc.Canvas.VISIBLE;

    // set the 'position' property on tabs to match this.tabBarPosition, so they can style
    // correctly
    tabDefaults.tabBarPosition = this.tabBarPosition;
    
    // have iconClick close the tabs if appropriate
    tabDefaults.iconClick = this._tabIconClickHandler;


    tabDefaults._generated = true;
    
	this.Super(this._$initWidget);

	if (this._baseLine == null) this.makeBaseLine();
},

// _tabIconClickHandler - method applied directly to the tabs
_tabIconClickHandler : function () {
    return this.parentElement.tabIconClick(this);
},

tabIconClick : function (tab) {
    
    var ts = this.parentElement;
    return ts._tabIconClick(tab);
   
},

// override makeButton to show the icon for the button
makeButton : function (properties, a,b,c,d) {
    var canClose = this.parentElement.canCloseTab(properties);
    if (canClose) {
        properties.icon = (properties.closeIcon || this.parentElement.closeTabIcon);
        properties.iconSize = (properties.closeIconSize || this.parentElement.closeTabIconSize);
        // close icon should appear at the end of the tab
        properties.iconOrientation = isc.Page.isRTL() ? "left" : "right";
        properties.iconAlign = properties.iconOrientation;
        
    }                                                
    
    return this.invokeSuper("TabBar", "makeButton", properties, a,b,c,d);
},

addTabs : function (tabs, position) {
    if (!position && this.tabBarPosition == isc.Canvas.LEFT) position = 0;
    this.addButtons(tabs, position);
    // ensure the tabs initially show up behind the baseline
    if (this._baseLine != null) {
        this._baseLine.bringToFront();        
        var selectedTab = this.getButton(this.getSelectedTab());
    	if (selectedTab) selectedTab.bringToFront();
    }
},


removeTabs : function (tabs) {
    // get the list of tab widgets to be removed
    if (tabs == null) return;
    if (!isc.isAn.Array(tabs)) tabs = [tabs];
    var tabWidgets = this.map("getButton", tabs);

    // remove the tabs
    this.removeButtons(tabs);
    
    // destroy each of the buttons we removed; it's appropriate/okay to do this because the buttons
    // were automatically created by this tabBar
    for (var i = 0; i < tabWidgets.length; i++) {
        if (tabWidgets[i] != null) tabWidgets[i].destroy();
    }
},

//>	@method	tabBar.draw()	(A)
// Extended to do layout and handle the selected tab.
//		@group	drawing
//<
draw : function (a,b,c,d) {
    arguments.__this = this;

	this.fixLayout();

	this.invokeSuper(isc.TabBar, "draw", a,b,c,d);
	this.bringToFront();

	var selectedTab = this.getButton(this.selectedTab);  
	// now that the buttons have all drawn, bring the baseline in front of them, then count on
    // the setSelected() behavior to bring the selected tab in front of the baseLine
	if (selectedTab) {
        
        selectedTab.setSelected(true);
    }
},

//>	@method	tabBar.makeBaseLine()	(A)
//  The baseline exists to create the appearance that one of the tabs is part of the pane whereas
//  the other tabs are behind the pane.
//
//	The baseline is an image that runs along the edge of the TabBar that borders on the pane,
//  occluding the pane's actual border but matching it exactly.  The selected tab is in front
//  of the baseline, and the rest are behind it.
//<

makeBaseLine : function () {
	// create the baseline stretchImg and add as child.
	this._baseLine = this.addAutoChild("baseLine", {
        ID:this.getID() + "_baseLine",
        vertical:(this.tabBarPosition == isc.Canvas.LEFT || 
                  this.tabBarPosition == isc.Canvas.RIGHT),
        skinImgDir:this.skinImgDir,
        src:this.baseLineSrc,
		capSize:this.baseLineCapSize,
        imageType:isc.Img.STRETCH,
        addAsChild:true,
        autoDraw:false
    }, isc.StretchImg);
    this.ignoreMemberZIndex(this._baseline);
},

// when scrolling shift the baseLine so it's always inside the viewport.
scrollTo : function (x,y,a,b,c,d) {
    this.invokeSuper(isc.TabBar, "scrollTo", x,y,a,b,c,d);
    if (this._baseLine) this.fixLayout();
},


//>	@method	tabBar.fixLayout()	(A)
//  Places the baseLine on the side of the TabBar adjacent to the tabbedPane, according to which
//  side the tabs are on.
//<
fixLayout : function () {
	var bl = this._baseLine;

    if (bl == null) return;
	
	
	var ts = this.parentElement,
	    //edge = ts ? ts._edgedCanvas : null,
        edgeOffset = 0;
        
    
    
	// Canvas.TOP
	if (this.tabBarPosition == isc.Canvas.TOP) {
		//edgeOffset = edge ? edge._rightMargin : 0; // HACK 040910
		bl.setRect(this.getScrollLeft(), this.getHeight() - this.baseLineThickness, 
    		   this.parentElement.getWidth()-edgeOffset, this.baseLineThickness);
	
	// Canvas.BOTTOM
	} else if (this.tabBarPosition == isc.Canvas.BOTTOM) {
		//edgeOffset = edge ? edge._leftMargin : 0; // HACK 040910
		bl.setRect(this.getScrollLeft(), 0, this.parentElement.getWidth()-edgeOffset, this.baseLineThickness);
	
	// Canvas.LEFT
	} else if (this.tabBarPosition == isc.Canvas.LEFT) {
		//edgeOffset = edge ? edge._bottomMargin : 0; // HACK 040910
		bl.setRect(this.getWidth() - this.baseLineThickness, this.getScrollTop(), 
				   this.baseLineThickness, this.parentElement.getHeight()-edgeOffset);

	// Canvas.RIGHT
	} else if (this.tabBarPosition == isc.Canvas.RIGHT) {
		//edgeOffset = edge ? edge._bottomMargin : 0; // HACK 040910
		bl.setRect(0, this.getScrollTop(), this.baseLineThickness, this.parentElement.getHeight()-edgeOffset);
    }	
}, 

// fix layout on a change of size
layoutChildren : function (a,b,c,d) {
    this.invokeSuper(isc.TabBar, "layoutChildren", a,b,c,d);
    this.fixLayout();
},

//>	@method	tabBar.buttonSelected()	(A)
//		This method overrides the toolBar's buttonSelected method.
//		Differences are as follows:
//		 - assumes tab is of type "radio", as all tabBar tabs are set to be a radiogroup
//		 - handles z-axis reorderings of tabs and baseLine
//		 - overlaps tabs by expanding and contracting them
//		
//		Note: we assume here that buttonSelected is only fired when the button is initially
// 			  set to "selected." Repeated clicks should not fire this method.
//
//		@param	tab		(tab)		tab that has been selected.
//<
buttonSelected : function (tab) {    
    this.ignoreMemberZIndex(tab);
    
	// bring tab and label to front.	
	tab.bringToFront();

	// store the currently selected tab as the lastSelectedButton.
	this.lastSelectedButton = tab;
    
    // Make sure we never tab to an unselected button
    // Note that deselection of the other tabs is handled by built in Toolbar / Radiogroup
    // behavior.
    this._updateFocusButton(this.lastSelectedButton);
        
},

// Override buttonDeselected() to send the tab to the back (behind the baseLine image)
buttonDeselected : function (tab) {
    tab.sendToBack();
    this.stopIgnoringMemberZIndex(tab);
},

//>	@method	tabBar.getSelectedTab()	(A)
//			get the tab object currently selected.
//		@return
//			tab object
//<
getSelectedTab : function () {
	return this.getButtonNumber(this.getSelectedButton());
},

//>	@method	tabBar.selectTab()	
// Select a tab
// @param  tabNum  (number)    index of tab to select
// @visibility external
//<
selectTab : function (tabNum) {    
    this.selectedTab = tabNum;
	this.selectButton(tabNum);
},

// Override setupButtonFocusProperties to ensure that this.selectedTab is the initial
// focusButton (will then be selected by _updateFocusButton())
setupButtonFocusProperties : function () {
    // sync up the focus with the selection
    
    this._updateFocusButton(this.getButton(this.selectedTab));
    return this.Super("setupButtonFocusProperties", arguments);

},

// override the internal _updateFocusButton method to always ensure the focussed tab is selected
_updateFocusButton : function (buttonNum) {
    
    
    // Suppress selection on right-click by default
    
    if (!this.selectTabOnContextClick && isc.EH.rightButtonDown()) {
        if (this._currentFocusButton != null && 
            this.getButton(buttonNum) != this._currentFocusButton) 
        {
            this._currentFocusButton.delayCall("focus");
        }
        return;
    }
    
    // Note: despite the method name - this method may be called directly from button selection
    // which can be triggered programmatically, without a focus change.
    // Ensure this button actually has focus
    
    var button = this.getButton(buttonNum);
    if (button) button.focus();
    
    this.Super("_updateFocusButton", arguments);
    if (this._currentFocusButton != null && !this._currentFocusButton.selected) {
        this.selectTab(this._currentFocusButton);
    }
},

_scrollForward : function (backward, animated) {
  if (this.overflow == isc.Canvas.VISIBLE || !this.members || this.members.length == 0) return;

    var nextTab, nextTabEdge;
    
    // If we're in the process of scrolling to a tab - jump straight to the one after it
    if (this._scrollingToTab != null) {
        nextTab = this.members[this._scrollingToTab + (backward ? -1 : 1)];
        if (nextTab == null) {
            return;
        }
        nextTabEdge = (backward ? (this.vertical ? nextTab.getTop() : nextTab.getLeft())
                                : (this.vertical ? nextTab.getBottom() : nextTab.getRight()));
    } else {
        
        var scrollSize = (this.vertical ? this.getScrollHeight() : this.getScrollWidth());
        if (scrollSize <= (this.vertical ? this.getViewportHeight() : this.getViewportWidth())) 
            return;
    
        var scrollStart = (this.vertical ? this.getScrollTop() : this.getScrollLeft()),
            viewSize = (this.vertical ? this.getViewportHeight() : this.getViewportWidth());
    
        
        var scrollThreshold = 5;        
        for (var i = 0; i < this.members.length; i++) {
            nextTab = (backward ? this.members[this.members.length - (i+1)] : this.members[i]);
            
            nextTabEdge = (backward ? (this.vertical ? nextTab.getTop() : nextTab.getLeft())
                                    : (this.vertical ? nextTab.getBottom() : nextTab.getRight()));
            // Determine which tab is currently clipped
            var clipped = backward ? (nextTabEdge + scrollThreshold < scrollStart) 
                                   : (nextTabEdge - scrollThreshold > (scrollStart + viewSize));
            if (clipped) break;
        }
    }  
    
    if (animated) {
        this._scrollingToTab = this.members.indexOf(nextTab);
        this.scrollTabIntoView(nextTab, backward, true, "this._completeScroll(" + this._scrollingToTab + ")");
    } else this.scrollTabIntoView(nextTab, backward);
},

_completeScroll : function (scrolledToTab) {
    if (this._scrollingToTab == scrolledToTab) delete this._scrollingToTab;
},

//>@method  tabBar.scrollTabIntoView()  
// If a tab is not currently visible for this tab-bar, scroll it into view.
// Can specify where you want the tab to appear.
// edge it was clipped on.
// @param   tab (number or ImgTab)  tab to scroll into view (or index of tab to scroll into view)
// @param   [start] (boolean) Should the tab be scrolled to the start or end of the viewport?
//                          If not specified the tab will be scrolled to whichever end it is
//                          currently clipped by.
// @param [animated] (boolean) If true, do an animated scroll.
// @param [callback] (callback) If specified this will fire when the tab has been scrolled into
//                              view. Will be synchronously fired if this is not an animated
//                              scroll, or if the tab is already in view, so no scrolling occurs.
//<
scrollTabIntoView : function (tab, start, animated, callback) {
    
    var tabNum;
    if (isc.isA.Number(tab)) {
        tabNum = tab;
        tab = this.members[tab];
    } else {
        tabNum = this.members.indexOf(tab);
    }
    if (!tab) return;
    
    var rect = tab.getRect(),
        xPos, yPos;

    // If not pased "start" parameter, we'll scroll the tab to the start of our viewport
    // iff its clipped to the left, otherwise to the end of our viewport.
    var vertical = this.vertical;
    if (start == null) {
        if (tabNum == 0) start = true;
        else if (tabNum == (this.members.getLength() -1)) start = false;
        else {
            if (vertical) {
                if (this.getScrollTop() > rect[1]) start = true;
                else start = false;
            } else {
                if (this.getScrollLeft() > rect[0]) start = true;
                else start = false;
            }
        }
    }
        
    if (vertical) {
        yPos = (start ? "top" : "bottom");
        // don't scroll horizontally - leave at zero
        xPos = "left";
        rect[2] = 0;
    } else {
        xPos = (start ? "left" : "right");
        // Don't scroll vertically
        yPos = "top";
        rect[3] = 0;
    }
    // When scrolling to the first tab, actually scroll to 0,0, rather than the edge of the
    // tab.
    if (tabNum == 0) rect[0] = rect[1] = 0;

    this.scrollIntoView(rect[0], rect[1], rect[2], rect[3], xPos, yPos, animated, callback);
},

scrollForward : function (animated) {
    this._scrollForward(false, animated);
},

scrollBack : function (animated) {
    this._scrollForward(true, animated);
}

});
