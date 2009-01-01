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

 
 
 
//> @class SectionStack
// A container that manages a list of sections of widgets, each with a header.  Sometimes called
// an "Accordion".
// <P>
// SectionStack can be configured so that only one section is visible at a time (similar to MS Outlook's
// left-hand Nav), or to allow multiple sections to be visible and share the available space.
//
// @treeLocation Client Reference/Layout
// @visibility external
// @example sectionsExpandCollapse
//<
isc.defineClass("SectionStack", "VLayout");

//>!BackCompat 2005.6.15 old name: "ListBar"
isc.addGlobal("ListBar", isc.SectionStack);
//<!BackCompat

isc.SectionStack.addProperties({
    //> @attr sectionStack.overflow (Overflow : "hidden" : IR)
    // Normal +link{type:Overflow} settings can be used on layouts, for example, an
    // overflow:auto Layout will scroll if sections are resized to exceed the specified size,
    // whereas an overflow:visible Layout will grow to accomodate the resized sections.
    // @visibility external
    //<
    overflow:"hidden",

    //> @attr sectionStack.styleName (CSSStyleName : "sectionStack" : IR)
    // Default CSS style for the SectionStack as a whole.
    //<
    styleName:"sectionStack",

    // Section Header Creation
	// ---------------------------------------------------------------------------------------
 
    //> @attr sectionStack.sectionHeaderClass (Classname : "SectionHeader" : IRA)
    // Name of the Canvas subclass to use as a header that labels the section and allows
    // showing and hiding.  The default class be skinned, or trivial subclasses created to
    // allow different appearances for headers in different SectionStacks.
    // <P>
    // Very advanced developers can use the following information to create custom header
    // classes.
    // <P>
    // The SectionStack will instantiate this class, giving the following properties on init:
    // <ul>
    // <li><code>layout</code>: the SectionStack
    // <li><code>expanded</code>: true or false
    // <li><code>hidden</code>: true or false
    // <li><code>title</code>: section title
    // </ul>
    // From then on, when the sectionHeader is clicked on, it should call
    // +link{method:SectionStack.sectionHeaderClick()}.
    // <br>
    // Whenever the section is hidden or shown, sectionHeader.setExpanded(true|false) will be
    // called if implemented.
    //
    // @visibility external
    //<
    sectionHeaderClass:"SectionHeader",
   
    //> @attr sectionStack.headerHeight (Number : 20 : IR)
    // Height of headers for sections.
    // @visibility external
    //<
    headerHeight:20,
    
    // sectionStack header styles for printing
    printHeaderStyleName:"printHeader",
    
    
    // All Sections
	// ---------------------------------------------------------------------------------------
    
    //> @attr SectionStack.sections (Array of SectionStackSection Properties : null : [IR])
    // List of sections of components managed by this SectionStack.
    //
    // @see sectionStack.getSections()
    // @visibility external
    // @example sectionsExpandCollapse
    //<
 
    //> @attr SectionStack.canResizeSections (boolean : true : [IRA])
    // Whether sections can be drag resized by the user dragging the section header.
    // <P>
    // Note that, with <code>canResizeSections:true</code>, not all sections can be resized:
    // sections that contain only +link{Button.autoFit,autofitting} components or that are
    // marked with +link{SectionStackSection.resizeable,section.resizeable:false} will not be
    // resizeable.
    //
    // @visibility external
    //<
    canResizeSections:true,
    
    // whether to allow the user to change the overall size of the SectionStack by resizing
    // sections
    
    canResizeStack:true,
   
    //> @attr SectionStack.canTabToHeaders (boolean : false : [IRA])
    // If true, the headers for the sections (if shown) will be included in the page's tab
    // order for accessibility.
    // @visibility external
    //<

    //> @attr SectionStack.scrollSectionIntoView (boolean : true : [IR])
    // If an expanded or shown section expands past the current viewport and this property is
    // true, then the viewport will auto-scroll to fit as much of the section content into the
    // viewport without scrolling the top of the section out of the viewport.
    //
    // @visibility external
    //<
    scrollSectionIntoView: true,

    // NOTE: vertical:false (horizontal stacks) does work, however the default SectionHeader
    // class has a height of 20 which needs to be wiped to allow vertical stretching.  And, you
    // have to have a strategy for vertical text labels.
    //     isc.defineClass("MyHeader", "SectionHeader").addProperties({height:null});
    //     isc.SectionStack.create({
    //         vertical:false,
    //         sectionHeaderClass:"MyHeader",
    //vertical:true,

    // Section Header Properties
    // ---------------------------------------------------------------------------------------

    //> @object SectionStackSection
    // Section descriptor used by a SectionStack to describe a section of items which are shown
    // or hidden together, and their associated header. 
    //
    // @treeLocation Client Reference/Layout/SectionStack
    // @visibility external
    //<

    //> @attr SectionStackSection.ID (String : null : [IR])
    // Optional ID for the section.  This can be used later in calls to +link{SectionStack} APIs such as
    // +link{sectionStack.expandSection} and +link{sectionStack.collapseSection}.
    // @visibility external
    //<

    //> @attr SectionStackSection.title (String : null : [IR])
    // Title to show for the section
    // @visibility external
    //<

    //> @attr SectionStackSection.items (Array of Canvas : null : [I])
    // List of Canvases that constitute the section.  These Canvases will be shown and hidden
    // together.
    // @visibility external
    //<

    //> @attr SectionStackSection.showHeader (boolean : true : [I])
    // If true, a header will be shown for this section.  If false, no header will be shown.
    // @visibility external
    //<

    //> @attr SectionStackSection.resizeable (boolean : null : [I])
    // If set to false, then the items in this section will not be resized by sectionHeader
    // repositioning.  You may also set this flag directly on any of the items in any section to
    // cause that item to not be resizeable.
    // @visibility external
    // @example resizeSections
    //<

    //> @attr SectionStackSection.expanded (boolean : false : [I])
    // Sections default to the collapsed state unless +link{SectionStackSection.showHeader} is
    // set to <code>false</code> in which case they default to the expanded state.  This
    // attribute allows you to explicitly control the expand/collapse state of the
    // section by overriding the above default behavior.  
    // @visibility external
    //<

    //> @attr SectionStackSection.hidden (boolean : false : [I])
    // Sections default to the visible state.  This
    // attribute allows you to explicitly control the visible/hidden state of the
    // section by overriding the above default behavior.  
    // @visibility external
    //<

    //> @attr SectionStackSection.canCollapse (boolean : true : [I])
    // This attribute controls whether or not the expand/collapse UI control is shown on the
    // header of this section.  Any section can still be expanded/collapsed programmatically,
    // regardless of this setting.
    // @visibility external
    // @example sectionsExpandCollapse
    //<
    
    //>Animation
    // ---------------------------------------------------------------------------------------
    //> @attr sectionStack.animateSections (boolean : null : IRW)
    // If true, sections are animated during expand/collapse and addition/removal of
    // SectionItems is likewise animated.
    // @group animation
    // @visibility animation
    // @example animateSections
    //<

    // change layout default effect for showing/hiding members; "slide" is appropriate for
    // eg Window minimize, but "wipe" is usually the best effect for SectionStacks 
    animateMemberEffect:"wipe",
    //<Animation

    // Visibility of Sections
	// ---------------------------------------------------------------------------------------

    //> @type VisibilityMode
    // Settings for whether multiple sections can be in the expanded state simultaneously.
    //
    // @value "mutex"
    // Only one section can be expanded at a time.
    //
    // @value "multiple"
    // Multiple sections can be expanded at the same time, and will share space.
    //
    // @visibility external
    //<

    //> @attr SectionStack.visibilityMode (VisibilityMode : "mutex" : [IRW])
    // Whether multiple sections can be visible at once
    //
    // @see type:VisibilityMode
    // @visibility external
    // @example sectionsExpandCollapse
    //<
    visibilityMode:"mutex",

    // internal flag: if true, section stack will null out _userHeight on an eligible item when
    // hiding/collapsing sections to maintain the overall height of the SectionStack.  If
    // false, the SectionStack will grow/shrink instead.  This needs to be rolled up to Layout
    // as a policy instead.
    forceFill: true,
    
    //> @attr itemIndent (Number : 0 : [IRW])
    // Size, in pixels, of indentation of all member items. Items will be offset
    // and reduced in width by this amount. Overridden by
    // +link{itemStartIndent} or +link{itemEndIndent}.
    // Setting itemIndent is equivalent to setting itemStartIndent to the same amount
    // and itemEndIndent to 0.
    // @visibility external
    // @group layoutMember
    //<
    itemIndent: 0
    
    //> @attr itemStartIndent (Number : undefined : [IRW])
    // Size, in pixels, of indentation of all member items relative to the start of
    // the alignment axis. For instance, for left-aligned members, 
    // itemStartIndent specifies indentation for every item from the left side of the
    // section stack. Overrides +link{itemIndent}.
    // @visibility external
    // @group layoutMember
    //<

    //> @attr itemEndIndent (Number : undefined : [IRW])
    // Size, in pixels, of indentation of all member items relative to the end of
    // the alignment axis. For instance, for left-aligned members, 
    // itemStartIndent specifies indentation for every item from the right side of the
    // section stack.
    // @visibility external
    // @group layoutMember
    //<
});
                        
isc.SectionStack.addMethods({

    initWidget : function () {
        this.Super(this._$initWidget);
 
        
        //>Animation
        if (this.visibilityMode == "mutex") this.animateSections = false;
        if (this.animateSections != null) this.animateMembers = this.animateSections
        //<Animation

        //>!BackCompat 2005.6.15 old name: "ListBar" with "groups"
        if (this.groups != null && this.sections == null) this.sections = this.groups;
        //<!BackCompat

        var initSections = this.sections;
        this.sections = [];
        this.addSections(initSections, null, true);    
    },
    
    //> @method sectionStack.addItem
    // Add a canvas as an item to a section.
    // @param section (String or Number) ID or index of the section to add item to
    // @param item (Canvas) Item to insert into the section
    // @param index (Number) Index into section to insert item
    // @visibility external
    //<
    addItem : function (section, item, index) {
        var sectionHeader = this.getSection(section);
        sectionHeader.items.addAt(item, index);
    },
    
    //> @method sectionStack.removeItem
    // Remove an item from a section.
    // @param section (String or Number) ID or index of the section to remove item from
    // @param item (Canvas) Item to remove
    // @visibility external
    //<
    removeItem : function (section, item) {
        var sectionHeader = this.getSection(section);
        sectionHeader.items.remove(item);
        this.removeMember(item);
    },
    
    // override removeChild to properly remove items / sections
    removeChild : function (child, name) {
        
        isc.Layout._instancePrototype.removeChild.call(this, child, name);
        //this.Super("removeChild", arguments);
        
        var sections = this.sections;
        if (sections) {
            for (var i = 0; i < sections.length; i++) {
                var section = sections[i];
                if (child == section) {
                    this.removeSection(child);
                    break;
                } else if (section.items && section.items.contains(child)) {
                    this.removeItem(section, child);
                    break;
                }
            }
        }
    },

    addSections : function (sections, position, expandOne) {
        if (sections == null) return;
        if (!isc.isAn.Array(sections)) sections = [sections];

        if (position == null || position > this.sections.length) {
            position = this.sections.length;
        }

        for (var i = 0; i < sections.length; i++) {
            var section = sections[i];

            // support sparse arrays
            if (!section) continue;

            if (section.showHeader == null) section.showHeader = true;
            if (section.canHide == null) section.canHide = true;

            // use section.expanded if explicitly set.  Otherwise default to collapsed
            // unless showHeader is false or autoShow is true (backcompat).
            var expanded = section.expanded != null ? section.expanded :
                    // previous logic was
                    // isOpen = section.autoShow || section.showHeader == false;
                    section.autoShow || section.showHeader == false;
            if (section.hidden == null) section.hidden = false;

            // normalize items to Arrays
            if (section.items == null) section.items = [];
            else if (!isc.isA.Array(section.items)) section.items = [section.items];

            // create a header for each section, which will also serve as the section itself.
            // NOTE: if showHeader is false, we still create a header object to represent the
            // section and track it's position in the members array, but it will never be
            // show()n, hence never drawn
            var headerClass = isc.ClassFactory.getClass(this.sectionHeaderClass),
                sectionHeader = headerClass.createRaw();
            sectionHeader.autoDraw = false;
            sectionHeader._generated = true;
            sectionHeader.expanded = expanded;
            sectionHeader.isSectionHeader = true;
            // Suppress double clicks on section headers
            sectionHeader.noDoubleClicks = true;
            
            // if you specify hidden:true and expanded: true, then expanded wins
            sectionHeader.visibility = (section.hidden || section.showHeader == false) ? 
                isc.Canvas.HIDDEN : isc.Canvas.INHERIT;
            // a section header drag is an internal resize, never an external drop (until we
            // implement tear-offs)
            sectionHeader.dragScrollType = "parentsOnly";
            sectionHeader.dragScrollDirection = 
                this.vertical ? isc.Canvas.VERTICAL : isc.Canvas.HORIZONTAL;

            sectionHeader.layout = this;
            if (this.vertical) sectionHeader.height = this.headerHeight;
            else sectionHeader.width = this.headerHeight;

            // if the user has specified an ID, pass that through under a renamed property _ID
            // so as not to incur a global, then restore the ID on the object they passed in so
            // as not to modify the user-passed object (they may reference the ID property on
            // their object later or even reuse the constructor)            
            if (section.ID != null) {
                section._ID = section.ID;
                delete section.ID;
            }
            isc.addProperties(sectionHeader, section);
            if (section._ID != null) {
                section.ID = section._ID;
                delete section._ID;
            }
            sectionHeader.completeCreation();
            section = sectionHeader;

            this.sections.addAt(section, position+i);

            this.addMember(section, this._getSectionPosition(section));
            // expand any non-collapsed sections.  This will add the section's items as members 
            if (expanded && !section.hidden) {
                this.expandSection(section);
                // remember last section to be expanded
                this._lastExpandedSection = section;
            // If it's not expanded - ensure any drawn section items are cleared since they may
            // have been drawn outside the sectionStack's scope
            } else {
                for (var ii = 0; ii < section.items.length; ii++) {
                    var item = section.items[ii];
                    if (item.parentElement && item.parentElement != this) item.deparent();
                    // note: item may not have yet been created
                    if (isc.isA.Canvas(item) && item.isDrawn()) item.clear();
                }
            }

            // apply resizeability flag to items
            if (section.items) {
                if (!this.canResizeSections) section.items.setProperty("resizeable", false);
                else if (section.resizeable != null) {
                    // allow both an explicit true and explicit false value.
                    // - false allows fixed-sized sections
                    // - true forces inherent height members to be resizeable
                    section.items.setProperty("resizeable", section.resizeable);
                }
            }
        }
        
        // if we were asked to make sure one section gets shown, show the first section if none
        // were marked expanded:true
        if (expandOne && this._lastExpandedSection == null) {
            var firstSectionConfig = sections.first();
            // NOTE: avoid forcing open the first section if it's config marked it explicitly
            // not expanded
            if (!(firstSectionConfig.expanded == false)) {
                var firstSection = this.sections.first();
                this.expandSection(firstSection);
                this._lastExpandedSection = firstSection;
            }
        }
    },

    //> @method sectionStack.addSection()
    //
    // Add a section to the SectionStack.
    //
    // @param sections  (SectionStackSection Properties | List of SectionStackSection Properties) Initialization block
    //                  for the section or a list of initialization blocks to add.
    // @param [position]    (number) index for the new section(s) (if not specified, the section
    //                      will be added at the end of the SectionStack).
    //
    // @visibility external
    // @example sectionsAddAndRemove
    //<
    addSection : function (sections, position) {
        this.addSections(sections, position);
    },

    //> @method sectionStack.removeSection()
    //
    // Remove a section or set of sections from the SectionStack.  The removed sections' header
    // and items (if any) are automatically destroyed.
    //
    // @param sections  (position|sectionId|list of sectionIDs) Section(s) to remove.  For this
    //                  parameter, you can pass the position of the section in the
    //                  SectionStack, the ID of the section, or a List of sectionIDs
    //
    // @visibility external
    // @example sectionsAddAndRemove
    //<
    removeSection : function (section) {
        section = this.getSectionHeader(section);
        this.removeMembers(section.items);
        this.sections.remove(section);
        section.destroy();
    },
    
    //> @method sectionStack.getSections()
    //
    // Returns a list of all sectionIDs in the order in which they appear in the SectionStack.
    //
    // @return (List) list of all sectionIDs in the order in which they appear in the SectionStack.
    // @visibility external
    //<
    getSections : function () {
        return this.sections.getProperty("_ID");
    },

    //> @method sectionStack.reorderSection()
    //
    // Reorder the sections by shifting the specified section to a new position
    //
    // @param section  (position|sectionId) Section to move.  You can pass the position 
    //                      of the section in the SectionStack or the ID of the section.    
    // @param position   (number) new position index for the section.
    //
    // @deprecated As of SmartClient version 5.5, use +link{sectionStack.moveSection}.
    //
    // @visibility external
    //<
    reorderSection : function (section, newPosition) {
        this.moveSection(section, newPosition);
    },

    //> @method sectionStack.moveSection()
    //
    // Moves the specified section(s) to a new position in the SectionStack order.  If you pass
    // in multiple sections, then each section will be moved to <code>newPosition</code> in the
    // order specified by the <code>sections</code> argument.
    //
    // @param sections  (position|sectionId|list of sectionIDs) Section(s) to move.  For this
    //                  parameter, you can pass the position of the section in the
    //                  SectionStack, the ID of the section, or a List of sectionIDs
    //
    // @param position    (number) new position index for the section(s).
    //
    // @visibility external
    //<
    moveSection : function (sections, newPosition) {
        if (!isc.isAn.Array(sections)) sections = [sections];
        
        for (var i = 0; i < sections.length; i++) {
            var section = this.getSectionHeader(sections[i]);

            if (section == null || newPosition == null) continue;
        
            // determine the current position of the section
            var position = this.sections.indexOf(section);
        
            // determine the current and new positions for the members
            var start = this.members.indexOf(section),
                end = start+1;
            // If the section is open, its items will be visible members
            // Otherwise when it is opened, they wall automatically be added as members / 
            // repositioned by the 'showSection' call
            if (this.sectionIsExpanded(section) && section.items) 
                end += section.items.length;
                    
            var newMemberPosition = this.members.indexOf(this.sections[newPosition]);
        
            // actually update the arrays
            this.sections.slide(position, newPosition);
            // this will also cause a reflow
            this.reorderMembers(start, end, newMemberPosition);
        }
    },

    //> @method sectionStack.showSection()
    // 
    // Shows a section or sections.  This includes the section header and its items.  If the
    // section is collapsed, only the header is shown.  If the section is expanded, the section
    // header and all items are shown.
    //
    // @param sections (position|sectionId|list of sectionIDs)
    //                      Section(s) to show.  For this parameter, you can pass the position 
    //                      of the section in the SectionStack, the ID of the section, or a
    //                      List of sectionIDs
    // @param [callback] callback to fire when the sections have been expanded.    
    //
    // @see sectionStack.expandSection
    // @see sectionStack.scrollSectionIntoView
    // @visibility external
    // @example sectionsShowAndHide
    //<
    showSection : function (sections, callback) {
        this._showSection(sections, true, false, callback);
    },

    //> @method sectionStack.expandSection()
    // 
    // Expands a section or sections.  This action shows all the items assigned to the section.
    // If the section is currently hidden, it is shown first and then expanded.  Calling this
    // method is equivalent to the user clicking on the SectionHeader of a collapsed section.
    //
    // @param sections (position|sectionId|list of sectionIDs)
    //                      Section(s) to expand.  For this parameter, you can pass the position 
    //                      of the section in the SectionStack, the ID of the section, or a
    //                      List of sectionIDs
    // @param [callback] callback to fire when the section has been expanded. 
    //
    // @see sectionStack.showSection
    // @see sectionStack.scrollSectionIntoView
    // @visibility external
    // @example sectionsExpandCollapse
    //<
    expandSection : function (sections, callback) {
        this._showSection(sections, false, true, callback);  
    },

    _showSection : function (sections, showSection, expandSection, callback) {
        if (!isc.isAn.Array(sections)) sections = [sections];

        var itemsToShow = [];
        for (var i = 0; i < sections.length; i++) {
            var section = this.getSectionHeader(sections[i]);
        
            // bad section specification
            if (section == null) {
                this.logWarn("no such section: " + this.echo(sections[i]));
                continue;
            }

            // header - if we're just expanding, but the section is hidden, show it.
            if (((showSection && section.showHeader) || expandSection) && section.hidden) {
                itemsToShow.add(section);
                section.hidden = false;
            }

            if (expandSection || section.expanded) {
                // Backcompat: setOpen is deprecated, but we still want to call it if
                // there's a backcompat definition. Otoh it's possible that we just have
                // setExpanded, so try that first and then call setOpen
                if (section.setExpanded && !section.setOpen) section.setExpanded(true);
                else if (section.setOpen) section.setOpen(true);
    
                // NOTE: a section with no items doesn't make much sense, but it occurs in tools
                if (section.items) { 
                    // handle string names, uninstantiated objects, etc
                    this.createCanvii(section.items);

                    // ensure the section's members are added, after the section header
                    var sectionPosition = this._getSectionPosition(section) + 1;
                    // NOTE: don't animate on add because we do the animation on showMembers
                    // instead
                    this.addMembers(section.items, sectionPosition, true);
                    itemsToShow.addList(section.items);
                }
            }
        }

        var theStack = this;
        this.showMembers(itemsToShow, 
                         function () { theStack._completeShowOrExpandSection(sections, callback); }
                         );
    },
    
    // fired as a callback to showMembers() from showSection() and expandSection()
    _completeShowOrExpandSection : function (sections, callback) {
        // sections is always an array here because this is an internal method and sections is
        // normalized by the caller
        if (sections.length == 0) return;

        // this method jsut scrolls things into view, but if we haven't been drawn yet, then
        // there's no need to do anything.
        if (this.isDrawn()) {
    
            // scroll the first passed section into view
            var section = this.getSectionHeader(sections[0]);
    
            // bring the section that was just shown into the viewport
            if (this.vscrollOn && this.scrollSectionIntoView) {
                var firstMember = (section.showHeader ? section : section.items.first()),
                    lastMember = section.items.last();
        
                // NOTE: visible height wouldn't be correct until component is drawn
                this.delayCall("scrollIntoView", 
                                [firstMember.getLeft(), firstMember.getTop(),
                                 firstMember.getVisibleWidth(), lastMember.getVisibleHeight(),
                                 "left", "top"], 0);
            }
        }
        
        if (callback != null) this.fireCallback(callback);
    },
    
    //> @method sectionStack.hideSection()
    // 
    // Hides a section or sections.  This includes the section header and its items.  The space
    // vacated by this action is reassigned to the nearest visible section item above this
    // section.  If there are no visible section items above this section, the space is
    // reassigned to the nearest visible section item below this section.
    //
    // @param sections (position|sectionId|list of sectionIDs)
    //                      Section(s) to hide.  For this parameter, you can pass the position 
    //                      of the section in the SectionStack, the ID of the section, or a
    //                      List of sectionIDs
    // @param [callback] callback to fire when the section has been hidden    
    //
    // @see sectionStack.collapseSection
    // @visibility external
    // @example sectionsShowAndHide
    //<
    hideSection : function (sections, callback) {
        this._hideSection(sections, true, false, callback);
    },

    //> @method sectionStack.collapseSection()
    // 
    // Collapse a section or sections.  This action hides all the items assigned to the
    // section.  Calling this method is equivalent to the user clicking on the SectionHeader of
    // an expanded section.
    //
    // @param sections (position|sectionId|list of sectionIDs)
    //                      Section(s) to collapse.  For this parameter, you can pass the position 
    //                      of the section in the SectionStack, the ID of the section, or a
    //                      List of sectionIDs
    //
    // @param [callback] callback to fire when the section has been collapsed    
    // @see sectionStack.hideSection
    // @visibility external
    // @example sectionsExpandCollapse
    //<
    collapseSection : function (sections, callback) {
        this._hideSection(sections, false, true, callback);
    },
    
    _hideSection : function (sections, hideSection, collapseSection, callback) {
        if (!isc.isAn.Array(sections)) sections = [sections];

        var itemsToHide = [];
        for (var i = 0; i < sections.length; i++) {
            var section = this.getSectionHeader(sections[i]);
        
            // bad section specification
            if (section == null) {
                this.logWarn("no such section: " + this.echo(section));
                continue;
            }

            if (hideSection && !section.hidden) {
                section.hidden = true;
                itemsToHide.add(section);
            }
    
            if (collapseSection || section.expanded) {
                // Backcompat: setOpen is deprecated, but we still want to call it if there's a
                // backcompat definition. Otoh it's possible that we just have setExpanded, so try
                // that first and then call setOpen
                if (collapseSection) {
                    if (section.setExpanded && !section.setOpen) section.setExpanded(false);
                    else if (section.setOpen) section.setOpen(false);
                }
                // some items may not have yet been added as members, so don't try to hide()
                // those or we'll crash in Layout
                if (section.items) {
                    for (var j = 0; j < section.items.length; j++) {
                        if (this.members.contains(section.items[j])) itemsToHide.add(section.items[j]);
                    }
                }
            }
        }
        
        // forceFill: override recent user resizes to fill available space.  NOTE: don't
        // forceFill if we're overflowed, as this would shrink us further after a collapse,
        // which is unexpected (this feature should be moved up to Layout as an optional
        // reaction to a hide)
        if (this.forceFill && this.getVisibleHeight() <= this.getHeight()) {
            // we want to make sure that some section(s) expand to fill the space vacated by this
            // hide/collapse.  We scan through the members array to see if one of the items
            // will be resized by the layout automatically.  If not, we pick one to forcibly
            // resize to fill the vacated space.

            // We're going to scan back from the first sectionHeader and then forward to try to
            // find an auto-resizable member and at the same time, we'll flag one that we can
            // forcefully resize if no auto-resizeable members are found.
            var startIndex = this.getMemberNumber(this.getSectionHeader(sections[0]));
            
            var forceResizeTarget;
            var layoutWillReflow = false;
            // scan back
            for (var i = startIndex-1; i >= 0; i--) {
                var member = this.members[i];
                if (itemsToHide.contains(member)) continue;
                if (this.memberIsDragResizeable(member)) {
                    if (this.memberHasAutoResizeableHeight(member)) {
                        layoutWillReflow = true;
                        break;
                    } else if (forceResizeTarget == null) {
                        forceResizeTarget = member;
                    }
                }
            }

            if (!layoutWillReflow) {
                // scan forward            
                for (var i = startIndex+1; i < this.members.length; i++) {
                    var member = this.members[i];
                    if (itemsToHide.contains(member)) continue;
                    if (this.memberIsDragResizeable(member)) {
                        if (this.memberHasAutoResizeableHeight(member)) {
                            layoutWillReflow = true;
                            break;
                        } else if (forceResizeTarget == null) {
                            forceResizeTarget = member;
                        }
                    }
                }
            }

            if (!layoutWillReflow && forceResizeTarget != null) {
//                this.logWarn("layout will not reflow, forceResizing: " + forceResizeTarget.ID);
                forceResizeTarget._userHeight = null;
//            } else {
//                if (layoutWillReflow) this.logWarn("layout will reflow");
//                else this.logWarn("layout will not reflow and no forceResizeTarget");
            }
        }
        
        this.hideMembers(itemsToHide, callback);
    },

    //> @method sectionStack.sectionIsVisible()
    //
    // Returns true if the specified section is visible, false if it is not.  A section is
    // visible if it shows a header and the header is visible or if it has items and the first
    // item is visible.
    //
    // @param section (sectionId|position)
    //                      Section for which you want to obtain visibility information.
    //                      For this parameter, you can pass the position of the section in the
    //                      SectionStack, or the ID of the section.
    //
    // @return (boolean)      true if the section is visible, false if it is not.
    //
    // @visibility external
    //<
    sectionIsVisible : function (section) {
        section = this.getSectionHeader(section);
        
        if (section.showHeader && section.isVisible()) return true;

        // NOTE: have to consider lazy initialization case
        var sectionMember = section.items.first();
        if (sectionMember == null || !isc.isA.Canvas(sectionMember) || 
            !sectionMember.isDrawn() || 
            sectionMember.visibility == isc.Canvas.HIDDEN) return false;
        return true;
    },

    //> @method sectionStack.getVisibleSections()
    //
    // Returns the list of currently visible sections.  The list items are section IDs.
    //
    // @return (List)      list of hidden sections
    //
    // @visibility external
    //<
    getVisibleSections : function() {
        var visibleSections = [];
        for (var i = 0; i < this.sections.length; i++)
            if (this.sectionIsVisible(this.sections[i])) visibleSections.add(this.sections[i].ID);
        return visibleSections;
    },

    //> @method sectionStack.sectionIsExpanded()
    //
    // Returns true if the specified section is expanded, false if it is collapsed.
    //
    // @param section (sectionId|position)
    //                      Section for which you want to obtain information.
    //                      For this parameter, you can pass the position of the section in the
    //                      SectionStack, or the ID of the section.
    //
    // @return (boolean)      true if the section is expanded, false if it is not.
    //
    // @visibility external
    //<
    sectionIsExpanded : function (section) {
        return this.getSectionHeader(section).expanded;
    },

    //> @method sectionStack.getExpandedSections()
    //
    // Returns the list of currently expanded sections.  The list items are section IDs.
    //
    // @return (List)      list of currently expanded sections
    //
    // @visibility external
    //<
    getExpandedSections : function () {
        var expandedSections = this.sections.findAll("expanded", true);
        return expandedSections == null ? [] : expandedSections.getProperty("_ID");
    },

    //> @method sectionStack.setSectionTitle()
    // Changes the title of a SectionHeader.
    //
    // @param section (String or Number) ID or index of the section whose title you want to change
    // @param newTitle (String) new title for the SectionHeader
    // @visibility external
    //<
    setSectionTitle : function (section, newTitle) {
        var sectionHeader = this.getSectionHeader(section);
        if (sectionHeader) sectionHeader.setTitle(newTitle);
    },

    //> @method sectionStack.getSectionHeader()
    // Return the SectionHeader for a section.
    // <P>
    // This will be an instance of the +link{sectionHeaderClass}.  Since different
    // SectionStacks may use different header classes, be careful about what APIs you rely on
    // for the section header unless you have explicitly set the
    // <code>sectionHeaderClass</code>.  In particular, use APIs such as
    // +link{setSectionTitle()} to manipulate header indirectly wherever possible, as high
    // performance SectionStacks designed for very large numbers of sections may cache and
    // re-use headers or use other strategies that would make it invalid to store a pointer to
    // a section header, assumed the header is a layout member, etc.
    //
    // @param section (String or Number) ID or index of the section for which you want the header
    // @return (SectionHeader) the section header indicated
    // @visibility external
    //<
    getSectionHeader : function (section) {
        return isc.Class.getArrayItem(section, this.sections, "_ID");
    },
     
    getSection : function (section) { return this.getSectionHeader(section) },

    //> @method sectionStack.getSectionNumber()
    //
    // Returns the position of the specified section in the SectionStack.  The numbering is
    // zero-based.  
    //
    // @param sectionID     (string) ID of a section for which you want to obtain the position.
    //
    // @return (number)     Position of the section in the SectionStack or -1 if the specified
    //                      section is not a member of this SectionStack.
    //
    // @visibility external
    //<    
    getSectionNumber : function (section) {
        if (isc.isA.String(section)) {
            return this.sections.findIndex("_ID", section);
        // handle being passed a pointer to a section directly
        } else {
            return this.sections.indexOf(section);
        }
    },

    // returns the position in the members array where the first item (header or first item in the
    // section.items array if showHeader = false) in this section should be
    // 
    // for external interfaces we only care about the index of the section in this.sections,
    // because that's what all external methods take as a section identifier (among others) and
    // end users shouldn't be directly modifying the underlying Layout.
    _getSectionPosition : function (section) {
        // if the section header has already been added as a member, it's position is
        // straightforward.
        var headerPosition = this.getMemberNumber(section);
        if (headerPosition != -1) return headerPosition;

        // otherwise look for the position of the last item in the previous section
        var sectionIndex = this.sections.indexOf(section);

        // if we're the first section we start at zero
        if (sectionIndex <= 0) return sectionIndex;

        // otherwise we start after the last item of the preceding section
        var previousSection = this.sections[sectionIndex-1],
            lastMember = previousSection.items ? previousSection.items.last() : null;
        if (this.hasMember(lastMember)) {
            return this.getMemberNumber(lastMember) + 1;
        } else {
            // NOTE: sections without headers always have their items added immediately, since
            // there's no way to hide them
            return this.getMemberNumber(previousSection) + 1;
        }
    },

    //> @method SectionStack.sectionHeaderClick (A)
    // Method intended to be called by the sectionHeader when it is clicked on.
    //
    // @param sectionHeader (Canvas) the sectionHeader clicked on
    // @visibility external
    //<
    sectionHeaderClick : function (section) {    
        // hide the currently visible pane and show the pane for the header that got clicked on
        if (this.visibilityMode == "mutex") {
            if (this.sectionIsExpanded(section)) return false;
            // keep only one section visible: hide the currently visible section
            this.collapseSection(this._lastExpandedSection);
            // show the new section
            this.expandSection(section);
        } else {
            // just toggle expanded/collapsed
            if (!this.sectionIsExpanded(section)) {
                this.expandSection(section);
            } else {
                this.collapseSection(section);
            }
        }
        // remember this as the new last section
        this._lastExpandedSection = section;

        return false; // cancel event bubbling
    },

    // For a given member, return the closest resizeable member _before_ us in the members
    // array.  See memberIsResizeable() for what constitutes a resizeable member.
    getDragResizeTarget : function (member) {
        var myIndex = this.getMemberNumber(member);

        // look for a member preceding us that can be resized
        var resizeTarget;
        this._resizeIgnore = 0;
        for (var i = myIndex-1; i >= 0; i--) {
            var member = this.getMember(i);
            if (this.memberIsDragResizeable(member)) {
                resizeTarget = member;
                break;
            }
            // as we pass non-resizeable members, store up their total height, which we will
            // use as offset when using the coordinate of the dragged section header to resize
            // whatever member actually gets chosen as the resize target.
            // NOTE: if we pass a section header, don't resize if the preceding member is
            // another section header, detected via the isSectionHeader flag rather than
            // isc.isA.SectionHeader since section header implementation is pluggable
            if (member.isSectionHeader || (!member.resizeable && member.isVisible()))
                this._resizeIgnore += member.getVisibleHeight();
        }

        // if there are no preceeding resizeable members, never allow resize (eg, no 
        // resize is possible if you are grabbing the first section header, or a section header
        // after a series of collapsed or fixed-size sections)
        if (!resizeTarget) return null;

        
        // Read as: 
        // - if canResizeStack is true (default), always allow resize if there is a preceeding,
        //   resizeable member, even though this *may* change the overall stack size if there
        //   isn't also a resizeable member after this section header
        // - if canResizeStack is false, only allow a resize if there is *also* a member
        //   after us that can resize, because only then will all available space still be
        //   filled.
        if (this.canResizeStack) return resizeTarget;

        // look for a member after us that can resize
        var numMembers = this.getMembers().length;
        for (var i = myIndex+1; i < numMembers; i++) {
            var member = this.getMember(i);
            // some member after the sectionHeader is resizeable, so go ahead and return the
            // resizeTarget we previously determined
            if (this.memberIsDragResizeable(member)) return resizeTarget;
        }
        
        return null;
    },
    
    
    memberIsDragResizeable : function (member) {
        if (!member.isSectionHeader 
            && member.resizeable !== false 
            && member.isVisible()
            && (!this.memberHasInherentLength(member) || member.resizeable)
            ) return true;
    },

    memberHasAutoResizeableHeight : function (member) {
        var uh = member._userHeight;
        return uh == null || (isc.isA.String(uh) && (uh == "*" || isc.endsWith(uh, "%")));
    },

    getMemberDefaultBreadth : function (member, defaultBreadth) {
        var breadth = defaultBreadth;
        if (!member.isSectionHeader) {
            if (this.itemStartIndent != null || this.itemEndIndent != null)
                breadth -= this.itemStartIndent + this.itemEndIndent;
            else breadth -= this.itemIndent;
        }
        return breadth;
    },
    
    getMemberOffset : function (member, defaultOffset, alignment) {
        var offset = this.itemIndent;

        if (member.isSectionHeader) return defaultOffset;
        if (this.itemStartIndent != null) offset = this.itemStartIndent;
        if (alignment == isc.Canvas.RIGHT || alignment == isc.Canvas.BOTTOM)
            offset *= -1;

        return defaultOffset + offset;
    }
    
});

// SectionHeader classes
// ---------------------------------------------------------------------------------------

isc._commonMediaProps = {
    icon:"[SKIN]SectionHeader/opener.gif",
    overflow:"hidden",
    baseStyle:"sectionHeader",
 
    // Show the disabled style in both image based headers and label-based headers
    showDisabled:true,

    // expanded/collapsed styling
    // ---------------------------------------------------------------------------------------
    expanded: false,
    setExpanded : function (expanded) {
        this.expanded = expanded;
        this.stateChanged();
    },
    //>!BackCompat 2005.12.22
    setOpen : function (isOpen) { 
        this.setExpanded(isOpen);
    },
    //<!BackCompat
    getCustomState : function () { return this.expanded ? "opened" : "closed"; }
};

isc._commonHeaderProps = {
    overflow:"hidden",
    wrap:false, // actually only needed for the Label-based "SectionHeader" class
    height:20,
    expanded: false,
    canCollapse: true,

    // Collapse behavior
    // ---------------------------------------------------------------------------------------
    getLayout : function () {
        var layout = this.layout;
        return isc.isA.String(layout) ? window[layout] : layout;
    },

    // Snap open/closed on  "space" / "enter" keypress
    // Allow resizing via ctrl+arrow keys
    keyPress : function () {
        var keyName = isc.EH.getKey();
        if (keyName == "Enter" || keyName == "Space") {
            if (this.canCollapse) this.getLayout().sectionHeaderClick(this);
        } else if (keyName == "Arrow_Up" || keyName == "Arrow_Down") {
            var target = this.getLayout().getDragResizeTarget(this);
            // NOTE: don't resize if the preceding member is another section header, detected
            // via marker rather than class since section header is pluggable
            if (target == null) return false;
            var resizeStep = (keyName == "Arrow_Up" ? -5 : 5);
            this.bringToFront(); // so we aren't occluded by what we will resize
            this.resizeTarget(target, true, this.resizeInRealTime, 0, 0,
                                (this.getPageTop() + resizeStep))
            // set a flag so we know to kill the when the user releases the ctrl key
            this._keyResizeTarget = target;
        }
	},
    
    keyUp : function () {
        if (this._keyResizeTarget) {
            var keyName = isc.EH.getKey();
            if (keyName == "Arrow_Up" || keyName == "Arrow_Down") {
                this.finishTargetResize(this._keyResizeTarget, true, this.resizeInRealTime);
                this._keyResizeTarget = null;
            }
        }
    },
    
    _canFocus : function () {
        return this.getLayout().canTabToHeaders == true;
    },

    // Editing
    // ---------------------------------------------------------------------------------------
    //>EditMode
    schemaName : "SectionStackSection", // schema to use when editing and serializing
    addItem : function (item, index) { 
        this.getLayout().addItem(this, item, index);
        // Visual Builder expects addItem to also expand this section
        this.getLayout().expandSection(this);
    },
    removeItem : function (item) {
        this.getLayout().removeItem(this, item);
    },
    //<EditMode

    // Resize interaction
    // ---------------------------------------------------------------------------------------
    canDrag:true,
    dragAppearance:"none",

    isSectionHeader:true,
    dragStart : function () {
        var target = this.getLayout().getDragResizeTarget(this);
        this._sectionDragTarget = target;
        if (target == null) return false;
        this.bringToFront(); // so we aren't occluded by what we will drag resize
    },
	dragMove : function () {
        // resizeIgnore is calculated in getDragResizeTarget(), called from dragStart();
        var resizeIgnore = this.getLayout()._resizeIgnore;
        var offset = 0 - isc.EH.dragOffsetY;
        this.resizeTarget(this._sectionDragTarget, true, this.resizeInRealTime, offset, resizeIgnore);
	},
	dragStop : function () {
        this.finishTargetResize(this._sectionDragTarget, true, this.resizeInRealTime);
	},
    
    // When a section gets destroyed, ensure all items (including those that have never been
    // added as a member to the layout) also get cleared out.
    destroy : function () {
        if (!this.expanded && this.items) {
            var items = this.items;
            for (var i = 0; i< items.length; i++) {
                if (isc.isA.Canvas(items[i]) && items[i].parentElement != this.parentElement) {
                    items[i].destroy();
                }
            }
        }
        return this.Super("destroy", arguments);
    },

    // Custom Controls
    // ---------------------------------------------------------------------------------------

    //> @attr sectionHeader.controls (Array of Canvas : null : IR)
    // Custom controls to be shown on top of this section header.
    // <P>
    // These controls are shown in the +link{controlsLayout}.
    // @example sectionControls
    // @visibility external
    //<

    //> @attr imgSectionHeader.controls (Array of Canvas : null : IR)
    // @include sectionHeader.controls
    //<

    //> @attr sectionHeader.controlsLayout (AutoChild : null : IR)
    // A +link{Layout} containing specified +link{controls} if any.  Sets
    // +link{layout.membersMargin}:5, +link{layout.defaultLayoutAlign}:"center", and
    // RTL-sensitive +link{layout.align} (right by default).
    // @visibility external
    //<

    //> @attr imgSectionHeader.controlsLayout (AutoChild : null : IR)
    // @include sectionHeader.controlsLayout
    //<
    controlsLayoutDefaults : {
        _constructor:isc.HStack,
        defaultLayoutAlign:"center",
        snapTo:"R",
        membersMargin:5,
        layoutEndMargin:5,
        addAsChild:true
    },

    addControls : function () {
        if (!this.controls) return;

        this.addAutoChild("controlsLayout", {
            height:this.getInnerHeight(),
            align:this.isRTL() ? "left" : "right",
            members:this.controls
        });
        this.allowContentAndChildren = true;
    },

    // Printing
    // ------------------------------------------------------------------------------------------
    // When printing, pick up the printStyleName from our sectionStack if it's set
    // Note that SectionHeaders are used in sectionItems as well. In this case the parentElement
    // will be the DynamicForm which may not have printHeaderStyleName set
    getPrintStyleName : function () {        
        var sectionStack = this.parentElement;
        if (sectionStack && sectionStack.printHeaderStyleName != null) {
            this.printStyleName = sectionStack.printHeaderStyleName;
        }
        return this.Super("getPrintStyleName", arguments);
    },
    
    // force section headers to print even though they're controls
    shouldPrint:true
    
    
};

//> @class SectionHeader
// Simple SectionHeader class based on a Label with an icon, skinnable via CSS.
//
// @treeLocation Client Reference/Layout/SectionStack
// @visibility external
//<
isc.defineClass("SectionHeader", "Label").addMethods(isc._commonHeaderProps, 
                                                     isc._commonMediaProps, 
{
    
    // We use this.title, not this.contents for the section header title
    useContents:false,
    
    //> @attr sectionHeader.icon   (SCImgURL : "[SKIN]SectionHeader/opener.gif" : [IRA])
    // Base filename of the icon that represents open and closed states. The default settings
    // also change the icon for disabled sections, so a total of four images are required
    // (opened, closed, Disabled_opened, Disabled_closed).
    //
    // @visibility external
    //<

    //> @attr sectionHeader.baseStyle    (CSSStyleName : "sectionHeader" : [IRA])
    // CSS class for the section header.
    // @visibility external
    //<

    // call our layout on click
    click : function () {
        if (this.canCollapse) this.getLayout().sectionHeaderClick(this);
    },

    draw : function (a,b,c,d) {    
        if (isc._traceMarkers) arguments.__this = this;
        if (!this.readyToDraw()) return;
    
        
        this.align = this.isRTL() ? "right" : "left";
        if (!this.canCollapse) {
            this.icon = isc.Page.getImgURL("[SKIN]/blank.gif");
            this.showIconState = false;
        }
        
        this.invokeSuper(isc.SectionHeader, "draw", a,b,c,d);

        this.addControls();
        
        
        if (this.headerControls != null) {
            this.headerLayout = isc.HLayout.create({
                autoDraw:false, width:this.getInnerWidth(), height:this.getInnerHeight(),
                members:this.headerControls
            });
            // Has to be a child, not a peer, so it will bubble clicks etc through if appropriate
            this.addChild(this.headerLayout);
            this.allowContentAndChildren = true;
        }
    }
    
});

//> @class ImgSectionHeader
// SectionHeader class based on an HLayout with +link{StretchImg} background.
// @treeLocation Client Reference/Layout/SectionStack
// @visibility external
//<
isc.defineClass("ImgSectionHeader", "HLayout").addMethods({
    //> @attr ImgSectionHeader.background (AutoChild : null : R)
    // Background of the section header, based on a StretchImg.
    // @visibility external
    //<
    backgroundDefaults : isc.addProperties({
        titleStyle:"sectionHeaderTitle",
        
        // These images now live in SectionHeader/ in the provided skins, but SectionStack/
        // is left as the default for backcompat with customer skins.
        src:"[SKIN]SectionStack/header.gif",

        
        backgroundColor:"#a0a0a0",
        // call our layout on click.  Note this function is placed on the background element so
        // that clicks on headerControls floating above the background do not trigger
        // expand/collapse
        click : function () {
            if (this.parentElement.canCollapse) {
                this.parentElement.getLayout().sectionHeaderClick(this.parentElement);
            }
        },
        width:"100%", height:"100%", addAsChild:true,
        
        // pick up printStyleName from the header
        getPrintStyleName : function () {
            if (this.parentElement) return this.parentElement.getPrintStyleName();
            return this.Super("getPrintStyleName", arguments);
        }
    }, isc._commonMediaProps),

    setExpanded : function (expanded) {
        this.expanded = expanded;
        if (this.background) this.background.setExpanded(expanded);
    },
    //>!BackCompat 2005.12.22
    setOpen : function (isOpen) {
        this.setExpanded(isOpen);
    },
    //<!BackCompat
    setTitle : function (title) {
        this.title = title;
        if (this.background) this.background.setTitle(title);
    },

    draw : function (a,b,c,d) {    
        if (isc._traceMarkers) arguments.__this = this;
        if (!this.readyToDraw()) return;
        var props = {
            title : this.title,
            expanded: this.expanded,
            // handle focus on the header itself rather than this button.
            canFocus:false
        };
        if (this.icon) props.icon = this.icon;
        if (!this.canCollapse) {
            props.icon = isc.Page.getImgURL("[SKIN]/blank.gif");
            props.showIconState = false;
        }
        props.align = this.isRTL() ? "right" : "left";
        this.addAutoChild("background", props, isc.StretchImgButton);

        this.addControls();

        
        this.addAutoChildren(this.headerControls);

        this.background.sendToBack();

        this.invokeSuper(isc.ImgSectionHeader, "draw", a,b,c,d);
    },
    
    // Override getPrintHTML to just return the title HTML with the appropriate styling
    getPrintHTML : function (props) {
        if (this.background) return this.background.getPrintHTML(props);
        return this.Super("getPrintHTML", arguments);
    }
    
});


isc.ImgSectionHeader.addMethods(isc._commonHeaderProps);





