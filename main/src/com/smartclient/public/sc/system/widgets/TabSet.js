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

 





//>	@class	TabSet
//
// The TabSet class allows components on several panes to share the same space. The tabs at 
// the top can be selected by the user to show each pane. 
// <P>
// Tabs are configured via the <code>tabs</code> property, each of which has a
// <code>pane</code> property which will be displayed in the main pane when that tab is
// selected.
//
//  @treeLocation Client Reference/Layout
//  @visibility external
//<

isc.ClassFactory.defineClass("TabSet", "Canvas");

isc.TabSet.addProperties({

    // NOTE: Setting both the paneContainer and TabSet to overflow:"visible" results in an
    // auto-expanding TabSet.  This may be appropriate as a top-level page layout when an
    // application is more web-style than desktop-style, eg, allows and utilizes browser-level
    // scrolling.
    overflow:"hidden",

	// TabBar
	// ----------------------------------------------------------------------------------------
    //>	@attr	tabSet.tabs		(Array of Tab : null : IRW)
    //
    // An array of tab objects, specifying the title and pane contents of each tab in the
    // TabSet.  When developing in JavaScript, tabs are specified as an array of object
    // literals, not instances - see +link{Tab}.
    // <p>
    // You can add and remove tabs after creating the TabSet by calling +link{TabSet.addTab}
    // @visibility external
    // @example tabsOrientation
    //<
    
    //> @object Tab
    // Tabs are specified as objects, not class instances.  For example, when
    // developing in JavaScript, a typical initialization block for a TabSet would look like
    // this:
    // <pre>
    // TabSet.create({
    //     tabs: [
    //         {title: "tab1", pane: "pane1"},
    //         {title: "tab2"}
    //     ]
    // });
    // </pre>
    // And in XML:
    // <pre>
    // &lt;TabSet&gt;
    //    &lt;tabs&gt;
    //        &lt;Tab title="tab1" pane="pane1"/&gt;
    //        &lt;Tab title="tab2"/&gt;
    //    &lt;/tabs&gt;
    // &lt;/TabSet&gt;
    // </pre>
    // 
    // @treeLocation Client Reference/Layout/TabSet
    // @visibility external
    //<

    //> @attr tab.title (HTML : null : IRW)
    //
    // Specifies the title of the this tab.  To change the title after the TabSet has been
    // created, call +link{TabSet.setTabTitle}.
    //
    // @see TabSet.setTabTitle
    // @visibility external 
    //<    
    
    //> @attr tab.pickerTitle   (HTML : null : IRW)
    // If +link{tabSet.showTabPicker} is true for this TabSet, if set this property will determine
    // the title of the picker menu item for this tab. If unset, +link{tab.title} will be used
    // instead
    // @see TabSet.showTabPicker
    // @see tab.title
    // @group tabBarControls
    // @visibility external
    //<
    
    //> @attr tab.pane (ID or Canvas: null : IRW)
    //
    // Specifies the pane associated with this tab.  You have two options for the value of
    // the pane attribute:
    // <ul>
    // <li><b>ID</b> - The global ID of an already created Canvas (or subclass).
    // <li><b>Canvas</b> - A live instance of a Canvas (or subclass).
    // </ul>
    // You can change the pane associated with a given tab after the TabSet has been created by
    // calling +link{TabSet.updateTab}.
    // 
    // @see TabSet.updateTab
    // @visibility external
    //<

    //> @attr tab.ID (identifier : null : IRW)
    // Optional ID for the tab, which can later be used to reference the tab.
    // APIs requiring a referenct a tab will accept the tabs ID 
    // [including  +link{tabSet.selectTab()}, +link{tabSet.updateTab()}, +link{tabSet.removeTab()}].<br>
    // The ID will also be passed to the +link{tabSet.tabSelected()} and +link{tabSet.tabDeselected()}
    // handler functions, if specified.
    // <p>
    // Note that if you provide an ID, it must be globally unique.
    //
    // @visibility external
    //< 

    //> @attr tab.width (number : 100 : IRW)
    // You can specify an explicit width for the tab using this property.  Note that tabs
    // automatically size to make room for the full title, but if you want to e.g. specify a
    // uniform width for all tabs in a TabSet, this property enables you to do so.
    //
    // @visibility external
    //< 
    
    //> @attr   tab.disabled    (boolean : null : IRW)
    // If specified, this tab will initially be rendered in a disabled state. To enable or
    // disable tabs on the fly use the +link{tabSet.enableTab()}, and +link{tabSet.disableTab()}
    // methods.
    // @visibility external
    //<

    //> @attr   tab.icon    (SCImgURL : null : IRW)
    // If specified, this tab will show an icon next to the tab title.  Note that as with 
    // +link{Button.icon}, the URL of a tabs icon will be updated to reflect disabled state.<br>
    // If desired a click handler may be assigned to the icon, which will be fired when the user
    // clicks the tab. This method takes a single parameter <code>tab</code>, a pointer to the tab
    // object.
    // 
    // @visibility external
    // @example tabsOrientation
    // @see tabSet.tabIconClick
    //<
    
    //> @attr   tab.canClose    (boolean : null : IRW)
    // Determines whether this tab should show an icon allowing the user to dismiss the tab by
    // clicking on it directly. The URL for this icon's image will be derived from 
    // +link{tabSet.closeTabIcon} by default, but may be overridden by explicitly specifying
    // +link{tab.closeIcon}.<br>
    // If unset, this property is derived from +link{tabSet.canCloseTabs}
    // @visibility external
    // @example closeableTabs
    // @see TabSet.closeClick()
    //<
    
    //> @attr tab.closeIcon (SCImgURL : null : IRW)
    // Custom src for the close icon for this tab to display if it is closeable.
    // See +link{tab.canClose} and +link{tabSet.canCloseTabs}.
    // @visibility external
    //<

    // ---------------------------------------------------------------------------------------
    
    //> @attr tabSet.tabBar (AutoChild : null : R)
    // TabBar for this TabSet, an instance of +link{TabBar}.
    // @visibility external
    //<
    // NOTE: tabBar is actually not created via autoChild system, but supports the same
    // defaults.

    //>	@attr tabSet.tabProperties (Tab Properties : null : IR)
	// Properties to apply to all Tabs created by this TabSet.
    // @visibility external
	//<
    tabProperties:{},

    // Simple Tabs
    // ---------------------------------------------------------------------------------------

    //>	@attr	isc.TabSet.useSimpleTabs    (boolean : false : IRWA)
    //  If set to true, we create tab instances as buttons (styled with 'tabButtonTop' /
    //  'tabButtonBottom' base styles, rather than the more heavy weight imgTab widgets.
    //  (internal for now)
    //<
    //useSimpleTabs:false,
    
    //> @attr   isc.TabSet.simpleTabBaseStyle   (CSSStyleName : "tabButton" : [IRW])
    //  If this.useSimpleTabs is true, simpleTabBaseClass will be the base style used to 
    //  determine the css style to apply to the tabs.<br>
    //  This property will be suffixed with the side on which the tab-bar will appear, followed
    //  by with the tab's state (selected, over, etc), resolving to a className like 
    //  "tabButtonTopOver"
    //<
    simpleTabBaseStyle:"tabButton",
 
    // TabBar placement and sizing   
    // ---------------------------------------------------------------------------------------

    //>	@attr	tabSet.tabBarPosition		(Side : isc.Canvas.TOP : IR)
    // Which side of the TabSet the TabBar should appear on.
    // @group tabBar
    // @visibility external
    // @example tabsOrientation
    //<
	tabBarPosition:isc.Canvas.TOP,
    
    //>	@attr	tabSet.tabBarAlign		(Side : see below : IR)
	// Alignment of the tabBar.
    // <P>
    // If the position of the tabBar is "top" or "bottom", then alignment must be "left" or
    // "right" and defaults to "left".
    // <P>
    // If the position of the tabBar is "left" or "right", then the alignment must be "top" or
    // "bottom" and defaults to "top".
    // 
    // @group tabBar
    // @visibility external
    // @example tabsAlign
	//<

    //>	@attr	tabSet.tabBarThickness		(number : 21 : IRW)
	// Thickness of tabBar, applies to either orientation (specifies height for horizontal,
    // width for vertical orientation).  Note that overriding this value for TabSets that are
    // skinned with images generally means providing new media for the borders.
    // @group tabBar
    // @visibility external
	//<					
	tabBarThickness:21,

    // ---------------------------------------------------------------------------------------

    //>	@attr	tabSet.selectedTab		(number : 0 : IRW)
    // Specifies the index of the initially selected tab.
    // @group tabBar
    // @visibility external
    //<
	selectedTab:0,
    
    // ---------------------------------------------------------------------------------------

    //> @attr tabSet.canCloseTabs (boolean : null : IRW)
    // Should tabs in this tabSet show an icon allowing the user to dismiss the tab by
    // clicking on it directly. May be overridden for individual tabs by setting 
    // +link{tab.canClose}.<br>
    // The URL for this icon's image will be derived from  +link{tabSet.closeTabIcon} by 
    // default, but may be overridden by explicitly specifying +link{tab.closeIcon}.
    // @see TabSet.closeClick()
    // @visibility external
    //<
    
    //> @attr tabSet.closeTabIcon (SCImgURL : [SKIN]/TabSet/close.png : IR)
    // Default src for the close icon for tabs to display if +link{tabSet.canCloseTabs} is true.
    // @visibility external
    //<
    closeTabIcon:"[SKIN]/TabSet/close.png",

    //> @attr tabSet.closeTabIconSize (int : 16 : IR)
    // Size in pixels of the icon for closing tabs, displayed when +link{canCloseTabs} is true.
    // @visibility external
    //<
    closeTabIconSize:16,
    
    // -----------------------------------------------------------
    // Tab bar controls

    //> @attr tabSet.tabBarControls       (Array : ["tabScroller", "tabPicker"] : [IRA])
    // This property determines what controls should show up after the tabBar for this tabSet.
    // Standard controls can be included using the strings <code>"tabScroller"</code> and 
    // <code>"tabPicker"</code>. These show the standard controls to scroll to clipped tabs, 
    // or pick them directly from a menu, and show up only if +link{tabSet.showTabScroller} or
    //  +link{tabSet.showTabPicker} is true and there is not enough space available to show all 
    // the tabs in the tab-bar.
    // <P>
    // Additional controls can be included by adding any widget to this array.  Controls will
    // show up in the order in which they are specified.  For example, the following code would
    // add a button in the tabBar area, while preserving the normal behavior of the tabScroller
    // and tabPicker:
    // <pre>
    // isc.TabSet.create({
    //     width:300,
    //     tabs : [
    //         { title: "Tab one" }
    //     ],
    //     tabBarControls : [
    //         isc.ImgButton.create({
    //             src:"[SKINIMG]/actions/add.png",
    //             width:16, height:16,
    //             layoutAlign:"center"
    //         }),
    //         "tabScroller", "tabPicker"
    //     ]
    // });
    // </pre>
    //
    // @group tabBarControls
    // @visibility external
    //<
    tabBarControls : ["tabScroller", "tabPicker"],
    
    
    //> @attr   tabSet.showTabScroller  (boolean : true : [IR])
    // If there is not enough space to display all the tab-buttons in this tabSet, should 
    // scroller buttons be displayed to allow access to tabs that are clipped?
    // @visibility external
    // @group tabBarControls
    //<
    showTabScroller:true,

    //> @attr   tabSet.showTabPicker    (boolean : true : [IR])
    // If there is not enough space to display all the tab-buttons in this tabSet, should
    // a drop-down "picker" be displayed to allow selection of tabs that are clipped?
    // @visibility external
    // @group tabBarControls
    //<    
    showTabPicker:true,
    
    // tabBarControls will be displayed in a layout. Make this an autoChild for potential
    // customization 
    tabBarControlsConstructor:"Layout",
    tabBarControlsDefaults:{},
    
    //>Animation
    //> @attr   tabSet.animateTabScrolling  (boolean : true : [IR])
    // If +link{tabSet.showTabScroller} is true, should tabs be scrolled into view via an 
    // animation when the user interacts with the scroller buttons?
    // @visibility external
    // @group tabBarControls
    //<
    animateTabScrolling:true,
    //<Animation
    
    //> @attr   tabSet.scrollerButtonSize   (number : 16 : [IR])
    // If +link{tabSet.showTabScroller} is true, this property governs the size of scroller
    // buttons. Applied as the width of buttons if the tabBar is horizontal, or the height
    // if tabBar is vertical. Note that the other dimension is determined by 
    // +link{tabBarThickness,this.tabBarThickness}
    // @group tabBarControls
    // @visibility external
    //<
    scrollerButtonSize:16,
    
    //> @attr   tabSet.pickerButtonSize   (number : 16 : [IR])
    // If +link{tabSet.showTabPicker} is true, this property governs the size of tab-picker
    // button. Applied as the width of buttons if the tabBar is horizontal, or the height
    // if tabBar is vertical. Note that the other dimension is determined by
    // +link{tabBarThickness,this.tabBarThickness}
    // @group tabBarControls
    // @visibility external
    //<
    pickerButtonSize:16,
    
    //> @attr   tabSet.skinImgDir (string : "images/TabSet/" : [IR])
    // @include Canvas.skinImgDir
    //<
	skinImgDir:"images/TabSet/",
    
    //> @attr tabSet.symmetricScroller (boolean : true : [IR])
    // If this TabSet is showing +link{tabSet.showTabScroller,tab scroller buttons}, this property 
    // determines whether the +link{tabSet.scrollerHSrc} and +link{tabSet.scrollerVSrc} media
    // will be used for vertical and horizontal tab-bar scroller buttons, or whether separate
    // media should be used for each possible +link{tabSet.tabBarPosition,tabBarPosition} based
    // on the +link{tabSet.scrollerSrc} property for this tabSet.
    // @group tabBarScrolling
    // @visibility external
    //<
    symmetricScroller:true,
    
    //> @attr   tabSet.scrollerSrc (SCImgURL : "[SKIN]/scroll.gif" : [IR])
    // If this TabSet is showing +link{tabSet.showTabScroller,tab scroller buttons}, and 
    // +link{tabSet.symmetricScroller,symmetricScroller} is false, this property governs the base
    // URL for the tab bar back and forward scroller button images.
    // <P>
    // Note that if +link{tabSet.symmetricScroller,symmetricScroller} is true, 
    // +link{tabSet.scrollerHSrc} and +link{tabSet.scrollerVSrc} will be used instead.
    // <P>
    // To get the path to the image to display, this base URL will be modified as follows:
    // <ul>
    // <li>If appropriate a state suffix of <code>"Down"</code> or <code>"Disabled"</code> will be
    //     appended.</li>
    // <li>The +link{tabSet.tabBarPosition,tabBarPosition} for this tabSet will be appended.</li>
    // <li>A suffix of <code>"forward"</code> or <code>"back"</code> will be appended for the
    //     forward or backward scrolling button.</li>
    // </ul>
    // For example - if the scrollerSrc is set to <code>"[SKIN]scroll.gif"</code>, the image
    // displayed for the back-scroller button on a tabSet with <code>tabBarPosition</code> set to
    // "top" and <code>symmetricScroller</code> set to false would be one of 
    // <code>"[SKIN]scroll_top_back.gif"</code>, <code>"[SKIN]scroll_Down_top_back.gif"</code>,
    // and <code>"[SKIN]scroll_Disabled_top_back.gif"</code>.
    // <P>
    // Note that for best results the media should be sized to match the scroller button sizes, 
    // determined by +link{tabSet.tabBarThickness} and +link{tabSet.scrollerButtonSize}.
    // @see tabSet.symmetricScroller
    // @group tabBarScrolling
    // @visibility external
    //<
    scrollerSrc:"[SKIN]/scroll.gif",
    
    //> @attr   tabSet.scrollerHSrc (SCImgURL :"[SKIN]hscroll.gif" : [IR])
    // If this TabSet is showing +link{tabSet.showTabScroller,tab scroller buttons}, and 
    // +link{tabSet.symmetricScroller,symmetricScroller} is true, this property governs the base
    // URL for the tab bar back and forward scroller button images for horizontal tab bars [IE for
    // tab sets with +link{tabSet.tabBarPosition,tabBarPosition} set to "top" or "bottom"].
    // <P>
    // Note that if +link{tabSet.symmetricScroller,symmetricScroller} is false, 
    // +link{tabSet.scrollerSrc} will be used instead.
    // <P>
    // To get the path to the image to display, this base URL will be modified as follows:
    // <ul>
    // <li>If appropriate a state suffix of <code>"Down"</code> or <code>"Disabled"</code> will be
    //     appended.</li>
    // <li>A suffix of <code>"forward"</code> or <code>"back"</code> will be appended for the
    //     forward or backward scrolling button.</li>
    // </ul>
    // For example - if the scrollerHSrc is set to <code>"[SKIN]hscroll.gif"</code>, the image
    // displayed for the back-scroller button on a tabSet with <code>tabBarPosition</code> set to
    // "top" and <code>symmetricScroller</code> set to true would be one of 
    // <code>"[SKIN]hscroll_back.gif"</code>, <code>"[SKIN]hscroll_Down_back.gif"</code>,
    // and <code>"[SKIN]hscroll_Disabled_back.gif"</code>.
    // <P>
    // Note that for best results the media should be sized to match the scroller button sizes, 
    // determined by +link{tabSet.tabBarThickness} and +link{tabSet.scrollerButtonSize}.
    // @see tabSet.symmetricScroller
    // @group tabBarScrolling
    // @visibility external
    //<
    scrollerHSrc:"[SKIN]hscroll.gif",
    
    //> @attr   tabSet.scrollerVSrc (SCImgURL :"[SKIN]vscroll.gif" : [IR])
    // If this TabSet is showing +link{tabSet.showTabScroller,tab scroller buttons}, and 
    // +link{tabSet.symmetricScroller,symmetricScroller} is true, this property governs the base
    // URL for the tab bar back and forward scroller button images for vertical tab bars [IE for
    // tab sets with +link{tabSet.tabBarPosition,tabBarPosition} set to "left" or "right"].
    // <P>
    // Note that if +link{tabSet.symmetricScroller,symmetricScroller} is false, 
    // +link{tabSet.scrollerSrc} will be used instead.
    // <P>
    // To get the path to the image to display, this base URL will be modified as follows:
    // <ul>
    // <li>If appropriate a state suffix of <code>"Down"</code> or <code>"Disabled"</code> will be
    //     appended.</li>
    // <li>A suffix of <code>"forward"</code> or <code>"back"</code> will be appended for the
    //     forward or backward scrolling button.</li>
    // </ul>
    // For example - if the scrollerVSrc is set to <code>"[SKIN]vscroll.gif"</code>, the image
    // displayed for the back-scroller button on a tabSet with <code>tabBarPosition</code> set to
    // "left" and <code>symmetricScroller</code> set to true would be one of 
    // <code>"[SKIN]vscroll_back.gif"</code>, <code>"[SKIN]vscroll_Down_back.gif"</code>,
    // and <code>"[SKIN]vscroll_Disabled_back.gif"</code>.
    // <P>
    // Note that for best results the media should be sized to match the scroller button sizes, 
    // determined by +link{tabSet.tabBarThickness} and +link{tabSet.scrollerButtonSize}.
    // @see tabSet.symmetricScroller
    // @group tabBarScrolling
    // @visibility external
    //<
    scrollerVSrc:"[SKIN]vscroll.gif",
    
    //> @attr tabSet.showScrollerRollOver (boolean : false : [IR])
    // set this to true to show scroller rollover images when the mouse is over the scroller 
    // buttons
    // @group tabBarScrolling
    //<
    
    //> @attr tabSet.symmetricPickerButton (boolean : true : [IR])
    // If this TabSet is showing a +link{tabSet.showTabPicker,tab picker button}, this
    // property determines whether the +link{tabSet.pickerButtonHSrc} and
    // +link{tabSet.pickerButtonVSrc} media will be used for vertical and horizontal tab-bar
    // picker buttons, or whether separate media should be used for each possible 
    // +link{tabSet.tabBarPosition,tabBarPosition} based on the +link{tabSet.pickerButtonSrc}
    // property  for this tabSet.
    // @group tabBarScrolling
    // @visibility external
    //<
    symmetricPickerButton:true,
    
    //> @attr   tabSet.pickerButtonSrc (SCImgURL : "[SKIN]/picker.gif" : [IR])
    // If +link{tabSet.showTabPicker} is true, this property governs the base URL for the picker
    // button image, when +link{tabSet.symmetricPickerButton} is set to false
    // <P>
    // Note that if <code>symmetricPickerButton</code> is true, the +link{tabSet.pickerButtonHSrc} 
    // and +link{tabSet.pickerButtonVSrc} properties will be used instead.
    // <P>
    // To get the path to the image to display, this base URL will be modified as follows:
    // <ul>
    // <li>If appropriate a state suffix of <code>"Down"</code> or <code>"Disabled"</code> will be
    //     appended.</li>
    // <li>The +link{tabSet.tabBarPosition,tabBarPosition} for this tabSet will be appended.</li>
    // </ul>
    // @see tabSet.symmetricPickerButton    
    // @group tabBarScrolling
    // @visibility external
    //<    
    pickerButtonSrc:"[SKIN]/picker.gif",
    
    //> @attr   tabSet.pickerButtonHSrc (SCImgURL : "[SKIN]hpicker.gif" : [IR])
    // If +link{tabSet.showTabPicker} is true, and +link{tabSet.symmetricPickerButton} is 
    // set to true, this property governs the base URL for the picker
    // button image, when displayed in a horizontal tab-bar [IE +link{tabSet.tabBarPosition} is
    // set to <code>"top"</code> or <code>"bottom"</code>].
    // <P>
    // Note that if <code>symmetricPickerButton</code> is false, the +link{tabSet.pickerButtonSrc}
    // property will be used instead.
    // <P>
    // This base URL will have a suffix of <code>"Down"</code> appended when the user holds the
    // mouse down over the button, and <code>"Disabled"</code> if the tabset as a whole is 
    // disabled.
    // @see tabSet.symmetricPickerButton    
    // @group tabBarScrolling
    // @visibility external
    //<    
    pickerButtonHSrc:"[SKIN]hpicker.gif",
    
    //> @attr   tabSet.pickerButtonVSrc (SCImgURL : "[SKIN]vpicker.gif" : [IR])
    // If +link{tabSet.showTabPicker} is true, and +link{tabSet.symmetricPickerButton} is 
    // set to true, this property governs the base URL for the picker
    // button image, when displayed in a verricaL tab-bar [IE +link{tabSet.tabBarPosition} is
    // set to <code>"LEFT"</code> or <code>"right"</code>].
    // <P>
    // Note that if <code>symmetricPickerButton</code> is false, the +link{tabSet.pickerButtonSrc}
    // property will be used instead.
    // <P>
    // This base URL will have a suffix of <code>"Down"</code> appended when the user holds the
    // mouse down over the button, and <code>"Disabled"</code> if the tabset as a whole is 
    // disabled.
    // @see tabSet.symmetricPickerButton    
    // @group tabBarScrolling
    // @visibility external
    //<    
    pickerButtonVSrc:"[SKIN]vpicker.gif",    
    
	// PaneContainer
	// ----------------------------------------------------------------------------------------

    //> @attr tabSet.paneContainer (AutoChild : null : R)
    // Container where the component specified by +link{tab.pane} is shown.
    // <P>
    // Note: paneContainer and showEdges:true for rounded tabsets: you can enable decorative
    // image-based edges on the paneContainer by setting +link{Canvas.showEdges,showEdges:true}
    // via paneContainerDefaults (to skin all tabsets) or paneContainerProperties (to use
    // edges on one instance).  In this structure, the +link{group:baseLine} should use media
    // that matches the appearance of the decorative edges and fully overlaps the edge of the
    // paneContainer that it is adjacent to.  In the most typical appearance (symmetric edges
    // on all 4 sides), both +link{tabBar.baseLineCapSize} and +link{tabBar.baseLineThickness}
    // match the +link{canvas.edgeSize,edgeSize} set on the paneContainer.  See the
    // load_skin.js file for the "SmartClient" skin for an example of setting all relevant
    // properties.
    // <P>
    // To disable edges for a particular TabSet, which you may want to do for a TabSet that
    // is already within a clearly defined container, configure the paneContainer to show only
    // it's top edge:
    // <pre>
    //      paneContainerProperties : { customEdges:["T"] },
    // </pre>
    // To completely flatten even the top edge of the TabSet:
    // <pre>
    //      paneContainerProperties : { customEdges:["T"] },
	//      tabBarProperties :{ baseLineCapSize:0 },
    // </pre>
    // This "flattens" the baseLine so that only the center image is used.
    //
    // @visibility external
    //<
    // XXX: advice above suboptimal:
    // - in general, the StretchImg baseline is using different media names for the same media.
    //   Could be fixed by passing custom sib.items to the baseline
    // - when we "flatten" as above, the paneContainer is still rendering a top edge and still
    //   using 3 pieces of media, it's just occluded by the baseline.  Ideally, we'd turn the
    //   edges off entirely, but by default this would cause the baseline to actually overlap
    //   widgets show in the paneContainer, so a margin would need to be set in CSS to
    //   compensate - more complicated to explain

	paneContainerConstructor:"PaneContainer",

	//>	@attr	tabSet.paneContainerClassName		(CSSStyleName : null : IRW)
	// CSS style used for the paneContainer.
    // @visibility external
	//<
	paneContainerClassName:"tabSetContainer",

    //>	@attr	tabSet.paneContainerOverflow	(Overflow : isc.Canvas.AUTO : IRWA)
	// Specifies the overflow of the pane container (the component that holds the pane contents
    // for all tabs).  By default this is set to "auto", meaning the pane container will
    // automatically introduce scrolling when the pane contents exceed the TabSet's specified
    // size.
    // <p>
    // For other values and their meaning, see +link{Overflow}
    //
    // @visibility external
	//<
	paneContainerOverflow:isc.Canvas.AUTO,
    
    //> @attr tabSet.symmetricEdges (boolean : true : IR)
    // If this tabSet will +link{tabSet.showPaneContainerEdges,show edges} for the paneContainer,
    // this property determines whether the same edge media will be used regardless of the tab
    // bar position, or whether different media should be used (necessary if the edge appearance is
    // not symmetrical on all sides).
    // <P>
    // If this property is set to false the paneContainer edge image URLs will be prefixed with
    // the tabBarPosition of the tabSet - for example <code>"[SKIN]edge_top_T.gif"</code> rather
    // than just <code>"[SKIN]edge_T.gif"</code>.
    // <P>
    // When <code>symmetricEdges</code> is false, custom edge sizes for the pane container may be
    // specified via +link{tabSet.topEdgeSizes} et al, and custom edge offsets via 
    // +link{tabSet.topEdgeOffsets} et al.
    // @visibility external
    //<
    symmetricEdges:true
    
    //> @type EdgeSizes
    // Object used to specify custom edge sizes or offsets.
    // Specified as an object where <code>defaultSize</code> will map to the default edge size or 
    // offset for the canvsa (+link{canvas.edgeSize}, or +link{canvas.edgeOffset} and
    // <code>top</code>, <code>left</code>, <code>right</code> and
    // <code>bottom</code> will map to the
    // +link{edgedCanvas.edgeTop,edgeTop}/+link{edgedCanvas.edgeOffsetTop,edgeOffsetTop}, 
    // +link{edgedCanvas.edgeLeft,edgeLeft}/+link{edgedCanvas.edgeOffsetLeft,edgeOffsetLeft},
    // +link{edgedCanvas.edgeRight,edgeRight}/+link{edgedCanvas.edgeOffsetRight,edgeOffsetRight},
    // and +link{edgedCanvas.edgeBottom,edgeBottom}/+link{edgedCanvas.edgeOffsetBottom,edgeOffsetBottom}
    // attributes on the paneContainer respectively. Note that not all these properties have to be
    // set - if unset standard edge sizing rules will apply. 
    // @visibility external
    //<
       
    //> @attr tabSet.leftEdgeSizes (EdgeSizes : null : IR)
    // If this tabSet will +link{tabSet.showPaneContainerEdges,show edges} for the paneContainer,
    // and +link{tabSet.symmetricEdges} is set to false, the <code>leftEdgeSizes</code>, 
    // <code>rightEdgeSizes</code>, <code>topEdgeSizes</code> and <code>bottomEdgeSizes</code> 
    // propertes allow the sizes of edges for the paneContainer to be customized depending on
    // the +link{tabSet.tabBarPosition}.
    // <P>
    // The attribute should be specified an +link{type:EdgeSizes,edgeSizes map}, specifying the
    // desired edge sizes where for the appropriate +link{tabSet.tabBarPosition}.
    // @visibility external
    //<
    
    //> @attr tabSet.topEdgeSizes (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeSizes
    // @visibility external
    //<
    
    //> @attr tabSet.bottomEdgeSizes (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeSizes
    // @visibility external
    //<
    
    //> @attr tabSet.rightEdgeSizes (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeSizes
    // @visibility external
    //<
    
    //> @attr tabSet.leftEdgeOffsets (EdgeSizes : null : IR)
    // If this tabSet will +link{tabSet.showPaneContainerEdges,show edges} for the paneContainer,
    // and +link{tabSet.symmetricEdges} is set to false, the <code>leftEdgeOffsets</code>, 
    // <code>rightEdgeOffsets</code>, <code>topEdgeOffsets</code> and <code>bottomEdgeOffsets</code> 
    // propertes allow the offsets of edges for the paneContainer to be customized depending on
    // the +link{tabSet.tabBarPosition}.
    // <P>
    // The attribute should be specified an +link{type:EdgeSizes,edgeSizes map}, specifying the
    // desired edge offsets where for the appropriate +link{tabSet.tabBarPosition}.
    // @visibility external
    //<
    
    //> @attr tabSet.rightEdgeOffsets (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeOffsets
    // @visibility external
    //<
    
    //> @attr tabSet.topEdgeOffsets (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeOffsets
    // @visibility external
    //<
    
    //> @attr tabSet.bottomEdgeOffsets (EdgeSizes : null : IR)
    // @include tabSet.leftEdgeOffsets
    // @visibility external
    //<
    
    //>	@attr	tabSet.showPaneContainerEdges (boolean : null : IRWA)
    // Should the paneContainer for this tabset show +link{Canvas.showEdges,edges}.
    //
    // @visibility external
    //<
    // set to null not false by default so we pick up the value from paneContainerDefaults
    // for backCompat (pre 6.1) 
    
    //>	@attr	tabSet.paneMargin	(number : 0 : IRW)
	//  Space to leave around the panes in our paneContainer
	//<
    //paneMargin:0
});

isc.TabSet.addMethods({
//>	@method	tabSet.initWidget()	(A)
// Initialize the TabSet object 
//<
initWidget : function () {
    
    // disallow 'showEdges:true' on tabSets - this is an effect the user essentially never wants
    // as edges would encompass the tab-bar as well as the (rectangular) pane container.
    
    this.showEdges = false;
    
	// call the superclass function
	this.Super("initWidget",arguments);
    
    if (this.tabs == null) this.tabs = [];
    if (this.tabBarDefaults == null) this.tabBarDefaults = {};
    // NOTE: tabInstanceDefaults is old name
    this.tabProperties = this.tabProperties || this.tabInstanceDefaults || {};

    var pos = this.tabBarPosition;

    // if tabBarAlign is unset, set default based on tabBarPosition 
    if (this.tabBarAlign == null) {
        this.tabBarAlign = ((pos == "left" || pos == "right") ? "top" : "left");
    }
    
    // If this has the 'useSimpleTabs' property set to true, create buttons rather than imgTabs
    // as tabs in the tab bar.  Saves on creating a number of widgets for performance.
    
    if (this.useSimpleTabs) {
        // also update the styling
        this.tabBarDefaults.buttonConstructor = isc.Button;
        // eg base + "Right" (derived from "right")
        this.tabProperties.baseStyle = this.simpleTabBaseStyle + 
                pos.substring(0,1).toUpperCase() + pos.substring(1);
    }    
	
	this.makeTabBar();
    
	this.makePaneContainer();

    this.createPanes();
},


//>	@method	tabSet.makeTabBar()	(A)
//	Instantiates a tabBar for this tabSet, and then adds it as a child of
//	the tabSet. starts with tabBarDefaults and adds additional, tabSet-specific properties
// @visibility internal
//<
makeTabBar : function () {
	if (this.tabs == null) return;
	
    
	var tabBarIsVertical = (this.tabBarPosition == isc.Canvas.LEFT || 
                            this.tabBarPosition == isc.Canvas.RIGHT),
        align = this.tabBarAlign;

    
    var tabs = this.tabs.duplicate(),
        undef;
    for (var i = 0; i < tabs.length; i++) {
        for (var j in this.tabProperties) {
            if (tabs[i][j] === undef) tabs[i][j] = this.tabProperties[j];
        }
    }    
    
	// assemble tabBar properties
	var tabBarProperties = isc.addProperties({
        // selectTabOnContextClick: we suppress this behavior by default - this is an undocumented
        // flag to allow selection of tabs on context click 
        
        selectTabOnContextClick:this.selectTabOnContextClick,
        
        ID:this.getID() + "_tabBar",

        width: (tabBarIsVertical ? this.tabBarThickness : "100%"),
        height: (tabBarIsVertical ? "100%" : this.tabBarThickness),

        // Default the tab bar to having the same accessKey as the tabSet
        accessKey: this.accessKey,
        
        // If the user has specified a tabIndex for the tabSet, apply it to the tabBar as well
        tabIndex: this.tabIndex,

        // Passes in the user-specified tabs array. 
        // This is a simple way for the developer to specify title / size / etc. for each tab
        // Note - we copy the tabs array rather than pointing at the same array.
        // the tabSet should manage the tabs and call the appropriate actions on the tabBar.
		tabs:tabs,

        align:this.tabBarAlign,
				 
		// tabBar is set vertical or not depending on the value of tabBarPosition.
		vertical: tabBarIsVertical ? true : false,
				 
		// the initially selectedTab is passed in.
		selectedTab:this.selectedTab,

        // Override buttonSelected() and buttonDeselected() to fire _tabSelected() and
        // _tabDeselected() on this widget
        // Note: these methods are only fired on actual selection change - repeated clicks on
        // the buttons should not fire these methods.
        buttonDeselected : function (button) {
            // Default implementation will remember which tab was selected, handle moving the
            // deselected tab behind the baseline image, etc.
            this.Super("buttonDeselected", arguments);
            
            if (this.parentElement != null)
                this.parentElement._tabDeselected(button);
        },
        				 
		buttonSelected : function (button) {
            
            this.Super("buttonSelected", arguments);
            
            //call _tabSelected() on this tabSet to trigger any selection actions
            if (this.parentElement != null) {
                this.parentElement._tabSelected(button);
            }
        },
        
        // notify the tabset if a tab resizes
        childResized : function () {
            this.Super("childResized", arguments);
            if (this.parentElement != null) {
                this.parentElement._tabResized();
            }
        },
                 
		// other properties
		tabBarPosition:this.tabBarPosition,
        tabBarAlign:this.tabBarAlign,
		autoDraw:false
        
	}, this.tabBarDefaults, this.tabBarProperties);
	
	// create tabBar and add as child.  NOTE: make available as this.tabBar as well since it's
    // declared as an autoChild
	this.tabBar = this._tabBar = isc.TabBar.create(tabBarProperties);
    this.addChild(this._tabBar);
},

// override setAccessKey and setTabIndex to manage the accessKey / tabIndex of the 
// tab-bar

setTabIndex : function (index) {
    this.Super("setTabIndex", arguments)

    if (this._tabBar != null) this._tabBar.setTabIndex(index);
},

// setAccessKey()
// apply the accessKey to the tabBar, which will in turn apply it to the focus-tab.
setAccessKey : function (accessKey) {
    this.Super("setAccessKey", arguments);
    if (this._tabBar != null) this._tabBar.setAccessKey(accessKey);
},


//>	@method	tabSet.createPanes()
//      converts any tab.pane object literals to canvii
// @visibility internal
//<
createPanes : function () {
    for (var i = 0; i < this.tabs.length; i++) {
	    var tab = this.tabs[i],
			pane = tab.pane
		;
		if (pane == null) continue;
        
        tab.pane = this.createPane(pane);
        
    }
},

//>	@method	tabSet.createPane()
//      (Internal method)
//      Given a pane object, create a canvas from it, and prepare it to be made a pane of this
//      object.
//      Creates canvas from properties object.
//      Ensures canvas is deparented / hidden.
//      Returns canvas.
//  @param  pane (object | canvas) object literal / canvas to be made into a pane
// @visibility internal
//<
createPane : function (pane) {
    if (pane == null) return pane;

    // handle string name, autoChild, props object
    if (!isc.isA.Canvas(pane)) pane = this.createCanvas(pane);

    if (pane == null) return pane;

    // make sure the pane is hidden before we add it to the pane container - otherwise it will
    // draw before the tab is actually selected
    pane.hide();

    // add the pane as a member to the paneContainer right away.
    //
    // Note: previously we did the addMember in updateTab() and _showTab().  Now we also do it
    // here - the reason is that it immediately establishes the parent-child relationship that
    // the ExampleViewer relies on to correctly render a view.  In the ExampleViewer we scan
    // for top-level Canvases and add them to a view Canvas - if this addMember isn't here,
    // we'll mistakenly add panes declared inline in a TabSet constructor block as top-level
    // canvases.
    //
    // We still must do the addMember in updateTab() and _showTab() because tabSelected() may
    // be overridden to provide a new pane.
    this.paneContainer.addMember(pane);

    return pane;
},

makePaneContainer : function () {
    
    var props = {   
            ID: this.getID() + "_paneContainer",
            _generated: false,
            className:this.paneContainerClassName,
            layoutMargin:(this.paneMargin || 0),
            overflow:this.paneContainerOverflow,
            
            _createEdgedCanvas : function () {
                var edgedCanvas = this.Super("_createEdgedCanvas", arguments);
                edgedCanvas.addMethods({
                    _asymmetricEdgePrefixes:{top:"_top",left:"_left",bottom:"_bottom",right:"_right"},
                    getEdgePrefix : function (edgeName) {
                        var pc = this.eventProxy,
                            tabSet = pc ? pc.creator : null;
                        if (tabSet && !tabSet.symmetricEdges) {
                            return this._asymmetricEdgePrefixes[tabSet.tabBarPosition];
                        }
                    }
                });
                return edgedCanvas;
            }
        };
    // NOTE: these dynamic defaults will override any static defaults defined in
    // this.paneContainerDefaults, (but may be overridden by attributes in
    // this.paneContainerProperties)
    // For back-compat, if showPaneContainerEdges / getPaneContainerCustomEdges() don't have
    // an explicit value, don't apply them to this object so we continue to pick up
    // showEdges/customEdges from the paneContainerDefaults block  
    if (this.showPaneContainerEdges != null) props.showEdges = this.showPaneContainerEdges;        
    if (this.getPaneContainerEdges && this.getPaneContainerEdges() != null) {
        props.customEdges = this.getPaneContainerEdges();
    }
    // asymmetricEdges needs support for asymmetric edge sizes and offsets
    
    if (!this.symmetricEdges) {
        var sizes = this[this._asymmetricEdgeSizePropertyMap[this.tabBarPosition]];
        if (sizes && sizes.defaultSize != null) props.edgeSize = sizes.defaultSize;
        if (sizes && sizes.bottom != null) props.edgeBottom = sizes.bottom;
        if (sizes && sizes.top != null) props.edgeTop = sizes.top;
        if (sizes && sizes.left != null) props.edgeLeft = sizes.left;
        if (sizes && sizes.right != null) props.edgeRight = sizes.right;
        
        var offsets = this[this._asymmetricEdgeOffsetPropertyMap[this.tabBarPosition]];
        if (offsets && offsets.defaultSize != null) props.edgeOffset = offsets.defaultSize;
        if (offsets && offsets.bottom != null) props.edgeOffsetBottom = offsets.bottom;
        if (offsets && offsets.top != null) props.edgeOffsetTop = offsets.top;
        if (offsets && offsets.left != null) props.edgeOffsetLeft = offsets.left;
        if (offsets && offsets.right != null) props.edgeOffsetRight = offsets.right;
        
    }
     
    this.addAutoChild("paneContainer", props);
},

// For efficiency avoid assembling asymmetric edge size / offset property names on the fly
_asymmetricEdgeSizePropertyMap : {
    top:"topEdgeSizes", bottom:"bottomEdgeSizes", left:"leftEdgeSizes", right:"rightEdgeSizes"
},
_asymmetricEdgeOffsetPropertyMap : {
    top:"topEdgeOffsets", bottom:"bottomEdgeOffsets", left:"leftEdgeOffsets",
    right:"rightEdgeOffsets"
},

//> @attr tabSet.showPartialEdges (boolean : false : [IRA])
// If the paneContainer for this tab set is showing +link{Canvas.showEdges,edges}, setting this
// attribute to <code>true</code> will set the paneContainer to show
// +link{canvas.customEdges,customEdges} for the three sides opposing the tabBarPosition.
// @visibility external
//<
 
//>	@method tabSet.getPaneContainerEdges() [A]
// If the paneContainer for this tab set is showing +link{Canvas.showEdges,edges}, this 
// method can be used to specify (dynamically) which +link{canvas.customEdges,customEdges} to
// show. Called when the pane creator is created.
// <P>
// Default implementation will return null unless +link{tabSet.showPartialEdges,showPartialEdges}
// is true, in which case it will return the three edges opposite the
// +link{tabSet.tabBarPosition,tabBarPosition}.
// @return (array) array of custom edges to show
// @visibility external
//<
getPaneContainerEdges : function () {
    if (this.showPartialEdges) {
                if (this.tabBarPosition == "bottom") return ["T","L","R"];
                else if (this.tabBarPosition == "left") return ["T","B","R"];
                else if (this.tabBarPosition == "right") return ["T","B","L"];
                else return ["B","L","R"];
    }
    return null;
},

// override draw to make sure we have a tab selected, and to fire 'tabSelected()' on the tab
draw : function (a,b,c,d) {
    if (this.tabs && this.tabs.length > 0) {    
        var selectedTab = this.getSelectedTabNumber();
        // Don't allow a bad selectedTab value to persist.
        if (!isc.isA.Number(selectedTab) || selectedTab < 0) selectedTab = this.selectedTab = 0;
        // Ensure it's selected in the tab-bar - will no op if already selected, otherwise
        // will perform selection and fire our handlers
        this._tabBar.selectTab(selectedTab);
    }
    this.invokeSuper(isc.TabSet, "draw", a,b,c,d);
    this.fixLayout();
},

//>	@method	tabSet.setTabTitle()	(A)
// Changes the title of a tab
// @param	tab      (Tab | number | ID)
// @param	title    (HTML)  new title
// @visibility external
// @example titleChange
//<
setTabTitle : function (tab, title) {
    this.getTabObject(tab).title = title;
    this.getTab(tab).setTitle(title);
    // reset the menu to pick up the new title
    this.resetTabPickerMenu();
},

//>	@method	tabSet.setTabIcon() (A)
// Changes the icon for a tab
// @param tab (Tab | number | ID) tab to update
// @param icon (SCImgURL) new icon
// @visibility external
//<
setTabIcon : function (tab, icon) {
    this.setTabProperties(tab, {icon:icon});
},

//>@method tabSet.enableTab()  
// If the specified tab is disabled, enable it now.
// @param   tab (Tab | number | ID)
// @see tab.disabled
// @visibility external
//<
enableTab : function (tab) {
    this.setTabDisabled(tab, false);
},

//>@method tabSet.disableTab()  
// If the specified tab is enabled, disable it now.
// @param   tab (Tab | number | ID)
// @see tab.disabled
// @visibility external
//<
disableTab : function (tab) {
    this.setTabDisabled(tab, true);
},

//>@method tabSet.setTabProperties() (A)
// Apply properties to an existing tab in a tabSet.
// @param tab (Tab | number | ID) Identifier for the tab to be modified
// @param properties (object) Javascript object containing the set of properties to be applied
//  to the tab.
// @visibility external
//<
setTabProperties : function (tab, properties) {
    if (!properties) return;
    
    if (properties.ID != null) {
        this.logWarn("setTabProperties(): Unable to modify ID for an existing tab - ignoring " +
                    "this property");
        delete properties.ID;
    }
    
    // A couple of properties require special APIs
    if (properties.pane != null) {
        this.updateTab(tab, properties.pane);
        delete properties.pane;
    }
    if (properties.disabled != null) {
        this.setTabDisabled(tab, properties.disabled);
        delete properties.disabled;
    }
    
    var tabObject = this.getTabObject(tab),
        tab = this.getTab(tab);
    if (!tabObject) return;
    isc.addProperties(tabObject, properties);
    
    if (tab) {
        tab.setProperties(properties);
    }
    
    // If we have a pickerMenu, destroy it so it gets rebuilt when next required
    // Ensures we pick up title / icon etc changes
    this.resetTabPickerMenu();
},

// Actually set the disabled property on a tab. Handled by just disabling the button.
setTabDisabled : function (tab, disabled) {
    var tabObject = this.getTabObject(tab);
    if (tabObject) tabObject.disabled = disabled;
    
    var tab = this.getTab(tab);
    if (tab) {
        // disable the tab so you can't access it.
        tab.setDisabled(disabled);
        // Also disable the pane in case it's showing.
        // Alternative approach would be to deselect the tab, if selected. The problem with 
        // this is we may only have one tab in the tabSet.
        var pane = tab.pane;
        if (pane) {
            if (isc.isA.Canvas(pane)) pane.setDisabled(disabled);
            else pane.disabled = disabled;
        }
    }
    // rebuild the picker menu so the item in question shows up disabled
    this.resetTabPickerMenu();
},

//>	@method	tabSet.addTab()	(A)
// Add a tab
// @param	tab      (Tab)   new tab
// @param	[position] (number)  position where tab should be added
// @see TabSet.addTabs
// @visibility external
// @example tabsAddAndRemove
//<
addTab : function (tab, position) {
    return this.addTabs(tab, position);
},

//>	@method	tabSet.addTabs()	(A)
// Add one or more tabs
// @param	tabs      (Tab or Array of Tab)   new tab or tabs
// @param	position (number)  position where tab should be added (or array of positions)
// @see TabSet.addTab
// @visibility external
//<
addTabs : function (newTabs, position) {
    if (!isc.isAn.Array(newTabs)) newTabs = [newTabs];
    var oldSelectedTab = this.getTab(this.getSelectedTabNumber()),
        forceSelection = (this.getSelectedTabNumber() == -1);
    
    if (position == null || position > this.tabs.length) position = this.tabs.length;
    for (var i = 0; i < newTabs.length; i++) {
        // use 'createPane' to turn the pane into a hidden, deparented canvas.
        newTabs[i].pane = this.createPane(newTabs[i].pane);
        
        // apply tabProperties (see comment in makeTabBar)
        var undef;
        for (var propName in this.tabProperties) {
            if (newTabs[i][propName] === undef) {
                newTabs[i][propName] = this.tabProperties[propName];
            }
        }
        
        // Actually add the tab to the config
        this.tabs.addAt(newTabs[i], (position + i))
    }

    this._tabBar.addTabs(newTabs, position);
    
    // If we have a pickerMenu, destroy it so it gets rebuilt when next required
    this.resetTabPickerMenu();
    
    // call fixLayout on a delay
    // Necessary in case the new tabs introduced clipping of the tab-bar
    // Delay required as layout reflow is asynch
    this.delayCall("fixLayout");
    
    if (forceSelection) {
        // If we didn't have a selected tab at the start of this method, ensure we select the
        // first of the new tabs
        this.selectTab(0);
    } else {
        // otherwise, update this.selectedTab (an index) in case tabs were added before the old
        // selected tab
        this.selectedTab = this.getTabNumber(oldSelectedTab);
    }
    
    return position;
},

//> @attr tabSet.destroyPanes (boolean : null : IR)
// Whether +link{canvas.destroy,destroy()} should be called on +link{tab.pane} when it a tab is
// removed via +link{removeTab()}}.  
// <P>
// An application might set this to false in order to re-use panes in different tabs or in
// different parts of the application.
//
// @visibility external
//<

//>	@method	tabSet.removeTab()	(A)
// Remove a tab.
// <P>
// The pane associated with the removed tab is automatically destroyed when you
// call this method.  To avoid this, call +link{updateTab()} with <code>null</code> as the new
// pane immediately before removing the tab.
// 
// @param	tabs      (Tab | ID | number | Array of Tab)  list of tabs, tabIDs, or tab numbers
// 
// @see TabSet.removeTabs
// @visibility external
// @example tabsAddAndRemove
//<
removeTab : function (tab, dontDestroy) {
    return this.removeTabs(tab, dontDestroy);
},

//>	@method	tabSet.removeTabs()	(A)
// Remove one or more tabs.  The pane(s) associated with the removed tab(s) is automatically
// destroyed when you call this method.
//
// @param	tabs      (Tab | ID | number)   list of tabs, tabIDs, or tab numbers
//
// @see TabSet.removeTab
// @visibility external
//<
removeTabs : function (tabs, dontDestroy) {
    if (!isc.isAn.Array(tabs)) tabs = [tabs];
    
    // get the actual tab button object from whatever was passed in.
    // We can pass this to tabBar.removeTabs()
    tabs = this.map("getTab", tabs);
    
    var removedSelected = false,
        selectedTab = this.getSelectedTab();
    
    for (var i = 0; i < tabs.length; i++) {
        
        // remove the tab from the config
        var tab = tabs[i],
            index = this.getTabNumber(tab),
            tabObject = this.tabs[index];

        if (tabObject == selectedTab) removedSelected = true;           

        this.tabs.removeAt(index);

        // remove the pane
        var pane = tabObject.pane;
        if (pane && pane.parentElement == this.paneContainer) {
            this.paneContainer.removeChild(pane);
            if (!dontDestroy && this.destroyPanes !== false) pane.destroy();
        }
        
        // remove the tab button
        this._tabBar.removeTabs(tab);
    }
    
    // if the selected tab was removed, select the first tab if we have any
    if (removedSelected && this.tabs.length > 0) this.selectTab(0);
    // If we have a pickerMenu, destroy it so it gets rebuilt when next required
    this.resetTabPickerMenu();

    // call fixLayout on a delay
    // Necessary in case the removed tabs get rid of clipping of the tab-bar
    // Delay required as layout reflow is asynch
    this.delayCall("fixLayout", 0);

},

//> @method tabSet.canCloseTab()
// Returns true if this tab is closeable. Determined by checking +link{tab.canClose} and
// +link{tabSet.canCloseTabs}.
// @param tab (int | ID | Tab) tab to check
// @return (boolean) true if tab is closeable
//<
canCloseTab : function (tab) {
    if (!isc.isAn.Object(tab)) tab = this.getTabObject(tab);
    if (tab && tab.canClose != null) return tab.canClose;
    return this.canCloseTabs;
},


_tabIconClick : function(tab) { 
    var shouldClose = this.canCloseTab(tab);
    if (shouldClose) {
        this.closeClick(tab);
        return false;
    } else return this.tabIconClick(tab); 
    
},

//> @method tabSet.closeClick()
// When +link{canCloseTabs} is set, method fired when the user clicks the "close" icon for a
// tab.
// <P>
// Default implementation will remove the tab from the tabSet via +link{removeTab()}.
// @param tab (Tab) tab to close
// @visibility external
//<
closeClick : function (tab) {
    this.removeTab(tab);
},

//> @method tabSet.tabIconClick()
// Method fired when the user clicks the icon for a tab, as specified via +link{tab.icon}.
// <P>
// Default behavior will fire <code>icon.click()</code> if specified, with two parameters
// <code>tab</code> (a pointer to the tab object and <code>tabSet</code> a pointer to the tabSet
// instance.
// @param tab (Tab) with click handler being fired
// @visibility external
//<
tabIconClick : function (tab) {
    var icon = tab.icon;
    if (icon && icon.click) return this.fireCallback(icon.click, 'tab,tabSet', [tab,this]);
},

//> @method tabSet.getTabObject()
// Get the tab Object originally passed to +link{tabSet.tabs}, by index or ID.
// If passed a tab Object, just returns it.
//
// @param	tab   (int | ID | Tab)
// @return (Tab) the tab, or null if not found
// @visibility external
//<
// NOTE: this returns the tab configuration object, not the button, since there may not be a
// Button.
getTabObject : function (tab) {
    // passed the tab button - determine it's index (use this below)
    tab = this.getTabNumber(tab);
    return this.tabs[tab];
},

//> @method tabSet.getTab()
// Get the live Canvas representing a tab by index or ID.  
// If passed a tab Canvas, just returns it.
// <P>
// Note that live Tab instances are not available until +link{Canvas.draw,draw()}.
// <P>
// The returned Tab is considered an internal component of the TabSet.  In order to maximize
// forward compatibility, manipulate tabs through APIs such as a +link{setTabTitle()} instead.
// Also note that a super-lightweight TabSet implementation may not use a separate Canvas per
// Tab, and code that accesses an manipulates Tabs as Canvases won't be compatible with that
// implementation.
//
// @param	tab   (int | ID | Canvas)
// @return (Tab) the tab Canvas, or null if not found or TabSet not drawn yet
//
// @visibility external
//<
getTab : function (tab) {
    
    // already the tab button, return it
    if (isc.isAn.Canvas(tab)) return tab;

    if (!this.tabs) return null;

    // if we have a tab-config block, convert it to an index, since the tabBar doesn't see our 
    // 'tabs' array
    if (this.tabs.contains(tab)) tab = this.tabs.indexOf(tab);

    // getButton on the tabBar handles the various possible types of the tab identifier passed in
    tab = this.getTabBar().getButton(tab);
    
    return tab;
},

//> @method tabSet.getTabPane()
// Returns the pane for a given tab.
//
// @param	tab   (object | number | ID | Tab)
// @return (Canvas) the tab pane
// @visibility external
//<
getTabPane : function (tab) {
    return this.getTabObject(tab).pane;
},

//> @method tabSet.findTab()
// Returns a the first tab in the list that matches the user-passed property name/value pair.
//
// @param	propertyName   (String) name of the property to look for
// @param	propertyValue  (Any) value of the property
//<
findTabObject : function (propertyName, propertyValue) {
    return this.tabs.find(propertyName, propertyValue);
},

//> @method tabSet.getTabNumber()
// Get the index of a tab, from the tab or tabID.  If passed a number, just returns it.
// @param	tab   (number | ID | tab)
// @return (number) the index of the tab, or -1 if not found 
// @visibility external
//<
// Note - we don't call this 'getTabIndex', even though it is an index, because of the conflict
// with the 'tabIndex' of the widget as a whole
getTabNumber : function (tab) {
    if (isc.isA.Number(tab)) return tab;
    if (!this.tabs) return null;
    var index = this.tabs.indexOf(tab);
    if (index != -1) return index;
    
    
    if (isc.isA.String(tab)) return this.tabs.findIndex("ID", tab);
    
    // At this point it must be a pointer to the tab button, so fall through to 
    // tabBar.getButtonNumber()
    return this.getTabBar().getButtonNumber(this.getTab(tab));
},

//> @method tabSet.updateTab()
// Set the pane for a tab.
// <P>
// Pass in the index of a tab (or a tab object), and a new pane.
// <P>
// NOTE: the old pane for the tab is not destroy()d
// 
// @param	tab   (number | ID | Tab) tab to update
// @param	pane  (Canvas | ID) new pane for the tab
// @visibility external
//<
updateTab : function (tab, pane) {

    // if we were passed a tab init block, for a new tab, call addTabs instead
    if (isc.isAn.Object(tab) && !isc.isA.Canvas(tab) &&
        this.tabs.indexOf(tab) == -1) 
    {
        if (pane != null) tab.pane = pane;
        return this.addTabs(tab);
    }

    // get the index for the tab (whatever way the "tab" is passed)
    var tabIndex = this.getTabNumber(tab);

    // bad tab specification
    if (tabIndex == -1) {
        this.logWarn("no such tab: " + this.echo(tab));
        return;
    }

    // get rid of the old pane
    var tabObject = this.getTabObject(tabIndex),
        oldPane = tabObject.pane;

    if (tabObject.pane == pane) return; // no-op

    if (oldPane != null) {
        oldPane.hide();
        oldPane.deparent();
    }

    // NOTE: keep tabCanvas.pane and tabObject.pane in sync for EditMode where the Tab needs to
    // be able to respond to getProperty("pane")
    var tabCanvas = this.getTab(tab);

    // if the new pane is null, we're done
    if (pane == null) return tabObject.pane = tabCanvas.pane = null;

    // add the new pane to init block (Using createPane to instantiate as a Canvas if necessary)
    // this makes sure the pane is hidden and not a child of anything except the paneContainer    
    pane = tabObject.pane = this.createPane(pane);

    // tabCanvas won't exist if we're not drawn yet
    if (tabCanvas != null) tabCanvas.pane = pane;

    // if we're drawn and the currently visible tab is being updated, show the new pane
    // (otherwise this happens automatically the next time the tab is selected).
    if (!this.isDrawn()) return;
    if (this.getSelectedTabNumber() == tabIndex) {
        if (!this.paneContainer.hasMember(pane)) this.paneContainer.addMember(pane);
        pane.show();
    }
},

//>	@method	tabSet.fixLayout()	(A)
//			lay out the children of the tabSet. 
//			this method takes into account the position of the tabBar in the tabSet, 
//			and lays out the tabBar and the paneContainer accordingly.
//<
fixLayout : function () {
	// abbreviations
	var tb = this._tabBar,
        // round corners: for layout only, manipulate the edgedCanvas instead of the
        // paneContainer
		pc = this._edgedCanvas || this.paneContainer
	;
	
	// check for nulls, and exit if found.
	// this method requires that both the tabBar and the paneContainer be instantiated before
	// it is called.
	if (tb == null || pc == null) return;

	// make sure paneContainer is below tabBar
    if (pc.getZIndex(true) >= tb.getZIndex(true)) pc.moveBelow(tb);
	
    
    var tbOverlap = this._firstNonNull(this.tabBarOverlap, tb.borderThickness,
                                       tb.baseLineThickness);

	// lay out the tabBar and paneContainer, depending on where the tabBar is.
    var vertical;
    switch (this.tabBarPosition) {
    	case isc.Canvas.TOP :
            vertical = false;
    		pc.setRect(0, 
                       tb.getHeight() - tbOverlap,
                       this.getWidth(),
                       this.getHeight() - tb.getHeight() + tbOverlap
                      );
	        break;
        case isc.Canvas.BOTTOM :
            vertical = false;
            tb.setTop(this.getHeight() - tb.getHeight());
	    	pc.setRect(0,
                       0,
                       this.getWidth(), 
                       this.getHeight() - tb.getHeight() + tbOverlap
                      );
            break;
        case isc.Canvas.LEFT :
            vertical = true;
    		pc.setRect(tb.getWidth() - tbOverlap,
                       0,
                       this.getWidth() - tb.getWidth() + tbOverlap,
                       this.getHeight()
                      );
            break;
        case isc.Canvas.RIGHT :
            vertical = true;
    		tb.setLeft(this.getWidth() - tb.getWidth());
	    	pc.setRect(0,
                       0,
                       this.getWidth() - tb.getWidth() + tbOverlap,
                       this.getHeight()
                      );
            break;
    }

    // showControls will show (or hide) the control layout, and return true if showing.
    var showControls = this.showControls();
    
    // If we're showing the control layout adjust our tab-bar size to take it into account
    if (showControls) {
        // Force clipping so we can scroll the tb as expected
        // Required even if we were already showing the scroller - we may have resized
        if (vertical) tb.setHeight(this.getViewportHeight() - this._controlLayout.getHeight());
        else tb.setWidth(this.getViewportWidth() - this._controlLayout.getWidth());
    } else {
        tb.resizeTo(vertical ? null : "100%", vertical ? "100%" : null);
    }
    // If the tab bar is currently scrolled, but there is enough space to display all its
    // tabs, force a scroll back to zero/zero
    
    var totalTabs = this._getTabSizes();
    if (vertical) {
        if (tb.getScrollTop() > 0 && totalTabs <= tb.getViewportHeight()) tb.scrollTo(null,0);
    } else {
        if (tb.getScrollLeft() > 0 && totalTabs <= tb.getViewportWidth()) tb.scrollTo(0,null);
    }
},

//>@method  tabSet.shouldShowControl()
// Should a specific control as specified in +link{tabSet.tabBarControls} be displayed?
// Default implementation will evaluate the +link{Canvas.showIf()} property for custom controls
// included as canvases. Standard controls for scrolling the tabBar will be included if 
// the relevant +link{tabSet.showTabScroller} or +link{tabSet.showTabPicker} property is not
// false, and there is not enough space in the tab-bar to display all the tabs.
// @parameter (control) control from the +link{tabSet.tabBarControls} array
// @return  (boolean)   true if the control shoudl be displayed
// @group tabBarControls
//<

shouldShowControl : function (control) {
    // The standard controls only show if the tabs are clipped
    if ((control == "tabScroller") || (control == "tabPicker")) {
        if (!this.showTabScroller && control == "tabScroller") return false;
        if (!this.showTabPicker && control == "tabPicker") return false;
        // If the member width exceeds the available space for the tab-bar we need to show
        // scroller buttons 
        var contentSize = this._getTabSizes();
        if (contentSize == 0) return;
        
        
        var otherControlSize=0;
        for (var i = 0; i < this.tabBarControls.length; i++) {
            var otherControl = this.tabBarControls[i];
            if (otherControl == "tabScroller" || otherControl == "tabPicker") continue;
            if (this.shouldShowControl(otherControl)) {
                if (!isc.isA.Canvas(otherControl)) otherControl = this.getControl(otherControl);
                otherControlSize += vertical ? otherControl.getHeight() : otherControl.getWidth();
            }
        }
        
        var vertical = (this._tabBar.orientation == isc.Layout.VERTICAL),
            clipTabs = (contentSize > (vertical ? (this.getViewportHeight() - otherControlSize)
                                                : (this.getViewportWidth() - otherControlSize)));                                       
        return clipTabs;
    }
    
    var control = this.getControl(control);

    if (isc.isA.Canvas(control)) {
        if (control.showIf) return control.fireCallback(control.showIf, [control]);
        else return true;
    }
    
},

_getTabSizes : function () {
    if (!this._tabBar) return 0;
    var contentSize = this._tabBar.getMemberSizes(),
        vertical = this._tabBar.vertical;
    if (contentSize == null || contentSize.length == 0) return 0;
    
    contentSize = contentSize.sum();
        
    
    var sizeAdjustment = (vertical ? (this._tabBar._topMargin || 0) + (this._tabBar._bottomMargin || 0)
                                  : (this._tabBar._leftMargin || 0) + (this._tabBar._rightMargin || 0));
    return contentSize + sizeAdjustment;
},

//>@method  tabSet.getControl()
// Given an entry in the +link{tabSet.tabBarControls} array, this method will return a pointer
// to the actual widget to display in the control layout.<br>
// If passed a canvas, it will be returned intact.<br>
// Will also map the special strings <code>"tabPicker"</code> and <code>"tabScroller"</code> to
// standard tab picker and scroller controls.
// @param control (string or canvas)    Control from +link{tabSet.tabBarControls} array.
// @return (canvas) Control widget to include in the control layout for this tabset
// @group tabBarControls
//<

getControl : function (control) {
    if (isc.isA.Canvas(control)) return control;
    var vertical = (this._tabBar.orientation == isc.Layout.VERTICAL);
    
    if (control == "tabScroller") {
        if (!this.scroller) {
            
            // Make the scroller a stretchImgButton with 2 "buttons"
            var sbsize = this.scrollerButtonSize;
            
            var scrollerSrc;
            if (this.symmetricScroller) {
                scrollerSrc = vertical ? this.scrollerVSrc : this.scrollerHSrc;
            } else {
                scrollerSrc = this.scrollerSrc;
            }                 
            var backName = this.symmetricScroller ? "back" : this.tabBarPosition + "_back",
                forwardName = this.symmetricScroller ? "forward" : 
                                                         this.tabBarPosition +"_forward";
                                                         
            this.scroller = isc.StretchImgButton.create({
                // set noDoubleClicks - this means if the user clicks repeatedly on the
                // scroller we'll move forward 1 tab for each click rather than appearing
                // to swallow every other click
                noDoubleClicks:true,
                tabSet:this,
                vertical:vertical,
                width:vertical ? (this.tabBarThickness - this._tabBar.baseLineThickness) : (2*sbsize),
                height:vertical ? (2*sbsize) : (this.tabBarThickness - this._tabBar.baseLineThickness),
            
                items:[{name:backName, 
                        width:vertical ? null : sbsize,
                        height:vertical ? sbsize : null}, 
                       {name:forwardName,
                        width:vertical ? null : sbsize, 
                       height:vertical ? sbsize : null}],
                skinImgDir:this.skinImgDir,
                
                src:scrollerSrc,
            
                // Disable normal over/down styling as that would style both buttons at once
                showRollOver:false,
                showDown:false,
                backPartName:backName,
                forwardPartName:forwardName,
               
                mouseMove : function () {
                    if (!this.tabSet.showScrollerRollOver) return;
                    var currPart = this.inWhichPart();
                    var otherPart = currPart == this.backPartName ? this.forwardPartName : this.backPartName;
                    this.setState(isc.StatefulCanvas.STATE_UP, otherPart);
                    this.setState(isc.StatefulCanvas.STATE_OVER, currPart);
                },
                mouseOut : function () {
                    if (!this.tabSet.showScrollerRollOver) return;
                    this.setState(isc.StatefulCanvas.STATE_UP, this.forwardPartName);
                    this.setState(isc.StatefulCanvas.STATE_UP, this.backPartName);
                },
                mouseDown : function () {
                    this.clickPart = this.inWhichPart();
                    this.setState(isc.StatefulCanvas.STATE_DOWN, this.clickPart);
                },
                mouseUp : function () {
                    this.setState(isc.StatefulCanvas.STATE_UP, this.clickPart);
                },
                mouseStillDown : function () {
                    this.click();   
                },
                click : function () {
                    var back = this.clickPart == this.backPartName;
                    // figure out which part they clicked in and remember it
                    if (back) this.tabSet.scrollBack();
                    else this.tabSet.scrollForward();
            
                    return false;
                }
            });
        }
            
        return this.scroller;
    
    } else if (control == "tabPicker") {
        var tabPickerSize = this.pickerButtonSize;
        if (!this.tabPicker) {
            var tabSrc;
            
            if (this.symmetricPickerButton) {
                tabSrc = vertical ? this.pickerButtonVSrc : this.pickerButtonHSrc;
            } else {
                tabSrc = this.pickerButtonSrc;
            }
                         
            this.tabPicker = isc.ImgButton.create({
                // use customState to append the tab bar position if necessary
                customState:this.symmetricPickerButton ? null : this.tabBarPosition,
                tabSet:this,
                showRollOver:false,
                skinImgDir:this.skinImgDir,
                src:tabSrc,
                height:(vertical ? tabPickerSize : (this.tabBarThickness - this._tabBar.baseLineThickness)),
                width:(vertical ? (this.tabBarThickness - this._tabBar.baseLineThickness) : tabPickerSize),
                click:"this.tabSet.showTabPickerMenu()"
            });
        }
            
        return this.tabPicker;
    }
    
    // If the control is a string, check for it being a widget's global ID
    if (isc.isA.String(control) && isc.isA.Canvas(window[control])) return window[control];
    
    // At this point we don't recognize the controller - log a warning and bail
    this.logWarn("Unable to resolve specified tabBarControl:" + isc.Log.echo(control) + 
                   " to a valid control. Not displaying.");
    return null;
},

// Method to actually show the controlLayout if required.
// If no controls are to be displaye this method falls through to hideControls()
// Returns true if any controls are displayed, false otherwise
showControls : function () {
    var controlSet = this.tabBarControls,
        controlSize = 0,
        barPos = this.tabBarPosition, 
        vertical = barPos == isc.Canvas.RIGHT || barPos == isc.Canvas.LEFT,
        visibleControlIndex = 0;
    
    for (var i = 0; i< controlSet.length; i++) {
        var control = controlSet[i];
        if (!this.shouldShowControl(control)) continue;
        // Turn the control identifier into a pointer to a Canvas if necessary
        control = this.getControl(control);   
        if (!control) continue;
        
        // At this point the control should be a pointer to a canvas -
        // Ensure the layout is showing, and that the control shows up in the right spot

        // controls should all be housed in a layout
        if (!this._controlLayout) {
            // create the tabBarControls as an autoChild
            this._controlLayout = this.createAutoChild("tabBarControls",
                                    {tabSet:this, styleName:this.tabBar.styleName,
                                     // if a control is resized while visible, ensure the tabSet 
                                     // is notified so it can keep us right-aligned in the tab-bar
                                     childResized:function () {
                                         this.Super("childResized", arguments);
                                         this.tabSet._controlLayoutChildResized();
                                     },
                                     vertical:vertical
                                    });
        }
        
        if (this._controlLayout.getMemberNumber(control) != visibleControlIndex) {
            this._controlLayout.addMember(control, visibleControlIndex);
        }
        visibleControlIndex ++;
        
        // Remember how much space the controls take up
        controlSize += vertical ? control.getVisibleHeight() : control.getVisibleWidth();
    }
    
    if (this._controlLayout && this._controlLayout.members) {
        // remove any members of the controlLayout beyond the end of the current set of visible
        // controls
        var membersToRemove = [];
        for (var i = visibleControlIndex; i < this._controlLayout.members.length; i++) {
            membersToRemove.add(i);
        }
        this._controlLayout.removeMembers(membersToRemove);
        // Note: we're not destroying these members, just deparenting them
    }
    
    // If we are NOT showing any controls, hide the layout and return false
    if (visibleControlIndex == 0) {
        this.hideControls();
        return false;
    }
    
    this.placeControlLayout(controlSize);
    
    // TabBar baseline: We're truncating the tabBar in order to draw the controlLayout after
    // it.
    // The controlLayout is as thick as the tabs, excluding the baseLine (this is appropriate -
    // we want control buttons to appear above the baseLine). However since the baseLine
    // is written into the tabBar rather than being a direct child of the tabSet, it will be
    // truncated along with the tabs, so the space under the control layout will be empty (the
    // baseLine will not extend underneath the controls).
    // Therefore if we are showing the controlLayout, create a new baseLine image to
    // sit below it so the baseLine extends beyond the (truncated) tabs in the tab-bar.
    
    if (!this._tabBarBaseLine) {
        var tb = this._tabBar;
        this._tabBarBaseLine = this._tabBar.createAutoChild("baseLine", {
            
            vertical:(barPos == isc.Canvas.LEFT || 
                      barPos == isc.Canvas.RIGHT),
            _generated:true,
            skinImgDir:tb.skinImgDir,
            src:tb.baseLineSrc,
    		capSize:tb.baseLineCapSize,
            imageType:isc.Img.STRETCH,
            autoDraw:false
        });
        this.addChild(this._tabBarBaseLine);
    }
    
    var tb = this._tabBar,
        tbThickness = (this.tabBarThickness - tb.baseLineThickness);
    
    // Position the tabBarBaseline under the controls. 
    
    if (barPos == isc.Canvas.LEFT) {
        this._tabBarBaseLine.setRect(tbThickness, 0, tb.baseLineThickness, this.getHeight());
    } else if (barPos == isc.Canvas.RIGHT) {
        this._tabBarBaseLine.setRect(this.getWidth() -this.tabBarThickness, 0, 
                                     tb.baseLineThickness, this.getHeight());
    } else if (barPos == isc.Canvas.TOP) {
        this._tabBarBaseLine.setRect(0, tbThickness, this.getWidth(), tb.baseLineThickness);
    } else if (barPos == isc.Canvas.BOTTOM) {
        this._tabBarBaseLine.setRect(0, this.getHeight() - this.tabBarThickness, 
                                        this.getWidth(), tb.baseLineThickness);
    }
    
    if (!this._controlLayout.isVisible()) this._controlLayout.show();    
    // Always position the baseLine behind the tabBar so we only see the edge that protrudes
    // past the end of the tabs.
    this._tabBarBaseLine.moveBelow(tb);
    if (!this._tabBarBaseLine.isVisible()) this._tabBarBaseLine.show();
    
    return true;
},

placeControlLayout : function (controlSize) {
    
    // Now figure out the desired sizing / position of the controlLayout and put it in the right
    // place
    var left,top,width,height,
        // Ensure that we don't cover the baseline
        tb = this._tabBar,
        tbThickness = (this.tabBarThickness - tb.baseLineThickness),
        barPos = this.tabBarPosition;

    if (barPos == isc.Canvas.LEFT) {
        left = 0;
        top = this.getHeight() - controlSize;
        width = tbThickness;
        height = controlSize;
    } else if (barPos == isc.Canvas.RIGHT) {
        left = this.getWidth() - tbThickness;
        top = this.getHeight() - controlSize;
        width = tbThickness;
        height = controlSize;
    } else if (barPos == isc.Canvas.BOTTOM) {
        width = controlSize;
        left = this.getWidth() - controlSize;
        top = this.getHeight() - tbThickness;
        height = tbThickness;
    // Last possibility is TOP
    } else {
        width = controlSize;
        left = this.getWidth() - controlSize;
        top = 0;
        height = tbThickness;
    }

    this._controlLayout.setRect(left, top, width, height);
    if (!this.children.contains(this._controlLayout)) this.addChild(this._controlLayout);

},

_controlLayoutChildResized : function () {
    var layout = this._controlLayout;
    if (!layout || !layout.isDrawn() || !layout.isVisible()) return;
    var controlSize = 0;
    for (var i = 0; i < layout.members.length; i++) {
        if (layout.vertical) controlSize += layout.members[i].getVisibleHeight();
        else controlSize += layout.members[i].getVisibleWidth();
    }
    
    this.placeControlLayout(controlSize);
},

// Hide the controlLayout and special tabBarBaseLine that displayes underneath it.
hideControls : function () {
    if (this._controlLayout && this._controlLayout.isVisible()) this._controlLayout.hide();
    if (this._tabBarBaseLine && this._tabBarBaseLine.isVisible()) this._tabBarBaseLine.hide();
},

//>@method  tabSet.scrollForward()
// If there is not enough space to display all the tabs in this tabSet, this method will 
// scroll the next tab (that first tab that is clipped at the end of the tab-bar) into view.
// @visibility external
//<
scrollForward : function () {
    this._tabBar.scrollForward(this.animateTabScrolling);
},

//>@method  tabSet.scrollBack()
// If there is not enough space to display all the tabs in this tabSet, this method will 
// scroll the previous tab (that first tab that is clipped at the beginning of the tab-bar) 
// into view.
// @visibility external
//<
scrollBack : function () {
    this._tabBar.scrollBack(this.animateTabScrolling);
},

// Called from click on the tabPicker control. Displays a menu with options to select
// a tab from the tabSet
showTabPickerMenu : function () {
    
    if (!this._pickerMenu) {
        var tabs = this.tabs,
            items = [];
        for (var i = 0; i < tabs.length; i++) { 
            items[i] = {index:i,
                        enabled:!this.tabs[i].disabled,
                        checkIf:"this.tabSet.getSelectedTabNumber() == " + i,
                        title:tabs[i].pickerTitle || tabs[i].title, 
                        // Note: We show the tab's icon in the menu, if there is one.
                        // This will show instead of the check-mark which we normally use to 
                        // indicate selection
                        
                        icon:(this.canCloseTab(tabs[i]) ? null : tabs[i].icon),
                        
                        // Calling selectTab will automagically scroll the tab into view if
                        // necessary
                        click:"menu.tabSet.selectTab(item.index)"}
        }
        this._pickerMenu = isc.Menu.create({tabSet:this, data:items})
    }
    
    // Show it under the button
    
    this._pickerMenu._showOffscreen();        
    this._pickerMenu.placeNear(this.tabPicker.getPageLeft(), this.tabPicker.getPageBottom())
    this._pickerMenu.show();
},

// resetTabPickerMenu - helper to destroy the tab picker menu so it will be rebuilt when next shown
// This ensures it picks up new details from the current set of tabs.
resetTabPickerMenu : function () {
    if (this._pickerMenu) {
        this._pickerMenu.destroy();
        delete this._pickerMenu;
    }
}, 

// fix layout on a change of size
layoutChildren : function (reason,b,c,d) {
    this.invokeSuper(isc.TabSet, "layoutChildren", reason,b,c,d);
    this.fixLayout();
},

_tabResized : function () {
    this.fixLayout();
},

// NOTE: this is internal because it only shows a new tab, it does not hide the previous tab.
// The external API is selectTab();
_showTab : function (tab) {

    // Ensure we're working with a tab object rather than a tabButton instance
    // (We're keeping this.tabs up to date rather than working with the buttons directly)
    if (isc.isA.Canvas(tab)) tab = this.getTabObject(tab);
    
	this.paneContainer.scrollTo(0,0);

	if (tab && tab.pane) {
        if (!this.paneContainer.hasMember(tab.pane)) this.paneContainer.addMember(tab.pane);
        tab.pane.show();
    }
	
    
	this.paneContainer.adjustOverflow();
},

//>	@method	tabSet._tabSelected(tab)	(A)
// Perform actions when a tab is selected. 
// This method is "bound" to the tabBar's buttonSelected method, so that is will fire
// whenever a button on the tabBar is seleced. it performs the following functions:
// 			 - show the associated pane
// 			 - scroll to (0,0)
//
//		@see this.tabBar.buttonSelected
//		@param	tab	(tab) tab that has been selected.
//<

_tabSelected : function (tab) {
    // fire handler (fire it first so it has an opportunity to alter the tab, eg add a pane on
    // the fly)
    // No need to check against our currently selected tabNum
    // this method should only fire when the tab-bar button is actually 
    // changing from deselected to selected state
    var tabNum = this._tabBar.getButtonNumber(tab);
    // Remember the selected tabNum - used by this.getSelectedTabNumber() etc.
    this.selectedTab = tabNum;
    // fire the notification functions
    if (this.tabSelected) {
        var tabObject = this.getTabObject(tabNum);
        
        this.tabSelected(tabNum, tabObject.pane, tabObject.ID, tabObject);

        // If this tab is no longer marked as selected, tabSelected() may have shown a 
        // different tab.  In this case don't call _showTab!
        if (this.getSelectedTabNumber() != tabNum) return;
    }

    this._showTab(tab);
    
    // ensure the tab button is scrolled into view
    var tb = this._tabBar;
    // leave the second param as null - tab bar will automatically scroll to appropriate
    // position
    tb.scrollTabIntoView(tabNum, null, this.animateTabScrolling);
},

//>	@method	tabSet._tabDeselected(tab)	(A)
//			perform actions when a tab is deselected. 
//			this method is "bound" to the tabBar's buttonSelected method, so that is will fire
//			whenever the next button on the tabBar is seleced. it hides the pane associated with
//			this tab
//
//		@see this.tabBar.buttonSelected
//		@param	tab	(tab) tab that has been deselected.
//<

_tabDeselected : function (tab) {
    var tabIndex = this._tabBar.getButtonNumber(tab),
        tabObject = this.getTabObject(tabIndex);
    // fire handler
	if (this.tabDeselected) this.tabDeselected(tabIndex, tabObject.pane, tabObject.ID, tabObject);

	if (tabObject && tabObject.pane) tabObject.pane.hide();
},

//>	@method	tabSet.getSelectedTab() ([A])
// Returns the currently selected tab object.  This is the object literal used to configure the
// tab, rather than the tab button widget.
// @return (Tab) the currently selected Tab object
// @visibility external
//<
getSelectedTab : function () {
    return this.tabs[this.selectedTab];
},

//>	@method	tabSet.getSelectedTabNumber() ([A])
// Returns the index of the currently selected tab object.  
// @return (number) the index of the currently selected tab object
// @visibility external
//<
getSelectedTabNumber : function () {
    if (!isc.isA.Number(this.selectedTab)) this.selectedTab = this.getTabNumber(this.selectedTab);
    // If the specifed selectedTabNum doesn't correspond to a tab don't return it.
    if (!this.tabs || !this.tabs[this.selectedTab]) return -1;
    return this.selectedTab;
},



//>	@method	tabSet.selectTab()    ([])
//	Select a tab
// @param	tab   (number | ID | Tab) tab to select
// @visibility external
// @example tabsOrientation
//<
selectTab : function (tab) {
    var tabIndex = this.getTabNumber(tab);
    if (tabIndex != -1) {
        // calling 'selectTab()' on the tab bar will actually select the button.
        // this handles firing our tabSelected() notification functions
        if (this._tabBar && this.isDrawn()) this._tabBar.selectTab(tabIndex);
        // If we're not drawn, record the newly selected tab - we'll actaully select
        // it in the tab-bar on draw
        else this.selectedTab = tabIndex
    }
},


//>	@method	tabSet.getTabBar()
// Returns handle to the TabBar used by this tabset
// @return (TabBar) the tab bar
//<
getTabBar : function () {
    return this._tabBar;
}

});


isc.TabSet.registerStringMethods({
    //>	@method	tabSet.tabSelected()
    //  Notification fired when a tab is selected. Note that this will only fire if 
    // this tabSet is drawn. If a tab is selected before <code>TabSet.draw()</code> 
    // is called, the <code>tabSelected()</code> notificaiton will fire on 
    // <code>draw()</code>
    // @param tabNum (number) number of the tab
    // @param tabPane (Canvas) pane for this tab
    // @param ID (id) id of the tab
    // @param tab (tab) the tab object (not tab button instance)
    // @visibility external
    //<
    
	tabSelected:"tabNum,tabPane,ID,tab",

    //>	@method	tabSet.tabDeselected()
    //  Notification fired when a tab is deselected.        
    // @param tabNum (number) number of the tab
    // @param tabPane (Canvas) pane for this tab
    // @param ID (id) id of the tab
    // @param tab (tab) the tab object (not tab button instance)
    // @visibility external
    //<
	tabDeselected:"tabNum,tabPane,ID,tab",
    
    
    // getPaneContainerEdges - documented by default implementation
    getPaneContainerEdges:""
});

isc.defineClass("PaneContainer", "VLayout").addMethods({
    // override handleKeyPress to allow for navigation between tabs when focus'd on the
    // pane container or its children (via bubbled handleKeyPress events)
    // ctrl+tab - move one pane forward (or back to the first pane)
    // ctrl+shift+tab - move one pane back
    // (This is the Windows behaviour - see Windows control panel)
    
    handleKeyPress : function (event, eventInfo) {
        if (event.keyName == "Tab" && event.ctrlKey) {
            var tabSet = this.parentElement,
                lastTabIndex = tabSet.tabs.length-1,
                currentSelection = tabSet.getSelectedTabNumber();

            if (event.shiftKey) {
                if (currentSelection > 0) currentSelection -=1;
                else currentSelection = lastTabIndex;
            } else {
                if (currentSelection < lastTabIndex) currentSelection +=1;
                else currentSelection = 0;
            }

            tabSet.selectTab(currentSelection);
            tabSet.getTabBar().getButton(currentSelection).focus();
            return false;                
        }  
        if (this.convertToMethod("keyPress")) return this.keyPress(event, eventInfo)
    }		        
});



