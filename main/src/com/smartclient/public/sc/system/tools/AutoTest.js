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
//> @class AutoTest
// Standalone class providing a general interface for integration with Automated Testing Tools
// @visibility autoTest
//<
// Need to add @treeLocation 
isc.defineClass("AutoTest");


//> @type Locator
// String used by SmartClient to identify an interactive area on the screen without reference
// to specific DOM elements.  Needed since the DOM element that SmartClient uses to render
// the UI can differ across browsers, across versions of SmartClient, and in different skins.
//
// The format of the locator is considered internal to SmartClient.
//<



isc.AutoTest.addClassMethods({
    
    //> @classMethod AutoTest.getLocator()
    // Returns the +link{type:Locator} associated with some DOM element. 
    // @param (DOMElement) DOM element somewhere in the page
    // @return (Locator) abstract Locator String
    // @visibility autoTest 
    //<
    getLocator : function (DOMElement) {
        var canvas;
        if (isc.isA.Canvas(DOMElement)) canvas = DOMElement;
        else {
            canvas = isc.AutoTest.locateCanvasFromDOMElement(DOMElement);            
        }
        
        return canvas ? canvas.getLocator(DOMElement) : "";
    },
    locateCanvasFromDOMElement : function (element) {
        
        return isc.EH.getEventTargetCanvas(null, element);
    },
    
        
    // ------------------------------
    // Retrieving elements from the DOM based on locator string
    //> @classMethod AutoTest.getElement()
    // @param (Locator) Locator String previously returned by +link{AutoTest.getLocator()}
    // @return (DOMElement) DOM element this locator refers to in the running application, or
    // null if not found
    // @visibility autoTest
    //<
    
    getElement : function (locator) {
        if (!locator) return null;
        var locatorArray = locator.split("/"),
            component;
        //this.logWarn("locatorArray" + locatorArray);
        // account for the 2 slashes
        var baseComponentID = locatorArray[2];
        
        // knock off the first 3 slots
        var length = locatorArray.length;
        for (var i = 3; i < length; i++) {
            locatorArray[i-3] = locatorArray[i];
        }
        locatorArray.length = length-3;
        
        if (!baseComponentID) return null;
        
        var baseComponent = this.getComponentFromLocatorSubstring(baseComponentID);

        return baseComponent ? baseComponent.getElementFromSplitLocator(locatorArray) : null;
    },
    
    getComponentFromLocatorSubstring : function (substring) {
        
        var className = substring.match("(.*)\\[")[1],
            ID = substring.match('ID=\\"(.*)\\"')[1];
        //this.logWarn("className/ID:" + [className,ID]);
        
        var baseComponent = window[ID];
        if (!baseComponent) return null;
        if (baseComponent && (!isc.isA[className] || !isc.isA[className](baseComponent))) {
            this.logWarn("AutoTest.getElement(): Component:"+ baseComponent + 
                        " expected to be of class:" + className);
        }
        return baseComponent;
    }
  

});

isc.ApplyAutoTestMethods = function () {

isc.Canvas.addMethods({
    
    //> @method canvas.getLocator()
    // Get an abstract Locator String for an element contained within this Canvas
    // @param (DOMElement) DOM element contained within this Canvas
    // @return (Locator) abstract Locator String
    // @visibility autoTest
    //<
    getLocator : function (element) {
        var baseLocator, parent;
        if (this._generated || this.locatorParent || this.creator || this._autoAssignedID) {
            parent = this.getLocatorParent();
        }
        if (!parent) {
            baseLocator = this.getLocatorRoot();
        } else {
            baseLocator = parent.getLocator() + "/" +
                          parent.getChildLocator(this);
        }        
        if (element) return [baseLocator, this.getInteriorLocator(element)].join("/");
        return baseLocator;
    },
    
    _locatorRootTemplate:[
    "//",
    ,   // classname
    '[ID="',
    ,   // global ID
    '"]'
    ],
    getLocatorRoot : function () {
        if (!this.locatorRoot) {
            this._locatorRootTemplate[1] = this.getClassName();
            this._locatorRootTemplate[3] = this.getID();
            this.locatorRoot = this._locatorRootTemplate.join(isc.emptyString);
        }
        return this.locatorRoot;
    },
    
    containsLocatorChild : function (canvas) {
        return false;
    },
    
    getLocatorParent : function () {
        // locatorParent -- this is a generic entry point allowing special locator parent/child
        // behavior. 
        // To make use of this a widget could set itself as the locatorParent of some other
        // widget, and implement custom 'containsLocatorChild()' / 'getChildLocator()'  
        if (this.locatorParent && this.locatorParent.containsLocatorChild(this)) {
            return this.locatorParent;
        }
        if (this.creator && isc.isA.Canvas(this.creator)) {
            var autoChildName = this.creator.getAutoChildLocator(this);
            if (autoChildName == null) {
                // failed to find the child - most likely created via 'createAutoChild' but
                // never ran through addAutoChild() which would make it detectable in the
                // getAutoChildLocator() method
                this.logWarn("Locator code failed to find relationship between parent:"+
                            this.creator.getID() + " and autoChild:"+ this.getID());                
                return null;
            }
        }
        return this.masterElement || this.parentElement;
    },
    
  
    //> @method canvas.getChildLocator()
    // Get the abstract Locator string for finding a child canvas within its parent element 
    // @param (Canvas)
    // @return (Locator) abstract Locator String for finding this child
    //<
    // Leave this internal - developers would call getLocator() directly
    _childLocatorTemplate:[
        ,   // "child" or "peer"
        "[",
        ,   // index of child/peer
        '][Class="',
        ,   // className of child/peer
        '"]'
    ],
     
    
    getChildLocator : function (canvas) {
        // special case scrollbars
        if (canvas == this.hscrollbar) {
            return "hscrollbar";
        }
        if (canvas == this.vscrollbar) {
            return "vscrollbar";
        }
        
        // More general behavior split into 2 parts for easy overriding - autoChildren are pretty
        // much always respected over other locators such as children / members array
        if (canvas.creator == this) {    
            var autoChildID = this.getAutoChildLocator(canvas);
            if (autoChildID) return autoChildID;
        }
        
        return this.getStandardChildLocator(canvas);
    },
    
    getAutoChildLocator : function (canvas) {
        
        if (this._createdAutoChildren) {
            for (var childName in this._createdAutoChildren) {
                if (canvas == this[childName]) return childName;
            }
        }
        return null
    },
    getStandardChildLocator : function (canvas) {
        var template = this._childLocatorTemplate;
        
        if (canvas.masterElement == this) {
            template[0] = "peer";
            template[2] = this.peers.indexOf(canvas);
        } else if (canvas.parentElement == this) {
            template[0] = "child";
            template[2] = this.children.indexOf(canvas);
        } else {
            // Not clear what would cause this - we already catch the autoChild case, 
            // so this is really a sanity check only
            this.logWarn("unexpected error - failed to find relationship between parent:"+
                        this.getID() + " and child:"+ canvas.getID());
            // return the standard root ID for the canvas - when parsing the strings back
            // we will have to explicitly catch this case?
            return canvas.getLocatorRoot();
        }
        
        template[4] = canvas.getClassName();
        
        return template.join(isc.emptyString);
    },
    
    //> @method canvas.getInteriorLocator()
    // Get a relative Locator for an element contained within this Canvas
    // @param (DOMElement) DOM element contained within this Canvas
    // @return (Locator) abstract Locator String
    //<
    // Overridden to provide standard "meaningful locations" for ListGrids, DynamicForm, etc
    getInteriorLocator : function (element) {
        if (element && this.useEventParts) {
            var partObj = this.getElementPart(element);
            if (partObj != null && partObj.part != null) {
                // This will be of the format "partType_partID"
                return (partObj.partID && partObj.partID != isc.emptyString) ? 
                                        partObj.part + "_" +  partObj.partID : partObj.part;
            }
        }
        return isc.emptyString;
    },
    
    
    // -------------------------
    // Retrieving dom elements from locator strings
    //> @method canvas.getElementFromSplitLocator()
    // Given a locator string split into an array, return a pointer to the appropriate DOM element.
    // @param (DOMElement) DOM element contained within this Canvas
    // @return (Locator Array) array of strings
    // @visibility internal
    //<
    // Internal - the parameter format does not match the Locator format returned by
    // canvas.getLocator -- developers should call AutoTest.getElement() rather than directly 
    // accessing this method
    getElementFromSplitLocator : function (locatorArray) {
        var child = this.getChildFromLocatorSubstring(locatorArray[0]);
        if (child) {
            locatorArray.removeAt(0);
            return child.getElementFromSplitLocator(locatorArray);
        }
        // split finding the element within our handle to a separate method for simpler override
        return this.getInnerElementFromSplitLocator(locatorArray);
    },
    
    getChildFromLocatorSubstring : function (substring) {
        // Expected formats:
        // - vscrollbar/hscrollbar (just a string)
        // - autoChild (just a string)
        // - children[index]
        // - members[index]
        if (isc.isA.Canvas(this[substring])) return this[substring]
        var child;
        for (var childType in this._locatorChildren) {
            child = this._standardChildFromLocatorSubstring(
                        substring, childType, this._locatorChildren[childType]
                    );                         
            if (child) break;
        }
        return child;
    },
    
    _locatorChildren:{
        peer:"peers",
        child:"children"
    },
    _standardChildFromLocatorSubstring : function (substring, childType, childrenType) { 
        if (substring.startsWith(childType + "[")) {
            // first one should be able to be \d+ ?
            var split = substring.match(childType + "\\[(\\d+)\\]\\[Class=\"(.+)\"\\]"),
                index = split ? split[1] : null,
                classID = split ? split[2] : null;
                            
            index = parseInt(index);
            
            if (!isc.isA.Number(index)) {
                this.logWarn("AutoTest.getElement() - didn't understand locator substring:" +
                             substring);
                return null;
            }
            if (!this[childrenType] || !this[childrenType][index]) {
                this.logWarn("AutoTest.getElement(): unable to find " + childType + ":" +
                              substring);
                return null
            }
            if (!isc.isA[classID] || !isc.isA[classID](this[childrenType][index])) {
                this.logWarn("AutoTest.getElement(): locator substring:"+ substring +
                            " gave component of class:"+ this[childrenType][index].getClassName());
            }
            
            return this[childrenType][index];
        }
        return null;
    },
    
    
    getInnerElementFromSplitLocator : function (locatorArray) {
        
        if (locatorArray) {
            // support event-parts in all canvii
            if (locatorArray.length == 1) {
                
                var parts = locatorArray[0].split("_");
                
                var part = {
                        part:parts[0],
                        partID:parts[1]
                    };
                var element = this.getPartElement(part);
                if (element) return element;
            }
            
        }
        return this.getHandle();
    }
    
    

});
          
// -----------------------------------------------------------------
// Override getChildLocator() for special cases

if (isc.Layout) {
    isc.Layout.addProperties({
        getStandardChildLocator : function (canvas) {
            var memberIndex = this.members ? this.members.indexOf(canvas) : -1;
            if (memberIndex != -1) {
                var template = this._childLocatorTemplate;
                template[0] = "member";
                template[2] = memberIndex;
                template[4] = canvas.getClassName();
                
                return template.join(isc.emptyString);
            }
            // calling Super will repeat the check for auto-children - we could 
            return this.invokeSuper(isc.Layout, "getStandardChildLocator", canvas);            
        },
        
        _locatorChildren:{
            member:"members",
            peer:"peers",
            child:"children"
        }
    });
}

if (isc.Window) {
    isc.Window.addProperties({
        // Code in Window.js sets up Windows as the 'locatorParent' of their items
        containsLocatorChild : function (canvas) {
            return (this.items && this.items.contains(canvas));
        },
        getStandardChildLocator : function (canvas) {
        
            if (this.items && this.items.contains(canvas)) {
                var template = this._childLocatorTemplate;
                template[0] = "item";
                template[2] = this.items.indexOf(canvas);
                template[4] = canvas.getClassName();
                
                return template.join(isc.emptyString);
            }
            
            return this.invokeSuper(isc.Window, "getStandardChildLocator", canvas);            
        },
        
        _locatorChildren:{
            item:"items",
            member:"members",
            peer:"peers",
            child:"children"
        }
    });
}
//  - in a Window, for an non-autoChild item, item[itemIndex][Class="className"]

if (isc.SectionStack) {
    _sectionLocatorTemplate:[
        "section[",
        ,   // sectionIndex
        "]/item[",
        ,   // itemIndex
        '][Class="',
        ,   // className
        '"]'
    ],
    isc.SectionStack.addProperties({
        getStandardChildLocator : function (canvas) {
            
            var sectionIndex = this.sections ? this.sections.indexOf(canvas) : -1;
            if (sectionIndex != -1) {
                var template = this._childLocatorTemplate;
                template[0] = "section";
                template[2] = sectionIndex
                template[4] = canvas.getClassName();
                
                return template.join(isc.emptyString);
            }
            
            // If appropriate locate by section
            var sections = this.sections || [];
            for (var i = 0; i < sections.length; i++) {
                var items = sections[i].items,
                    itemIndex = items ? items.indexOf(canvas) : -1;
                if (itemIndex != -1) {
                    var template = this._sectionLocatorTemplate;
                    template[2] = i;
                    template[3] = itemIndex;
                    template[5] = canvas.getClassName();
                    
                    return template.join(isc.emptyString);
                }
            }
            
            return this.invokeSuper(isc.Window, "getStandardChildLocator", canvas);            
        },
        
        _locatorChildren:{
            section:"sections",
            member:"members",
            peer:"peers",
            child:"children"
        },
        getChildFromLocatorSubstring : function (substring) {
            // Handle being passed a section[..]/item[...] type identifier
            
            // support autoChildren / scrollbars first
            if (isc.isA.Canvas(this[substring])) return this[substring]
                
            
            var split = substring.match("section\\[(\\d+)\\]/item\\[(\\d+)\\]\\[Class=\"(.+)\"\\]");
            if (split) {
                var sectionIndex = split[1],
                    itemIndex = split[2],
                    classID = split[3];
                                
                sectionIndex = parseInt(sectionIndex);
                itemIndex = parseInt(itemIndex);
                
                if (!isc.isA.Number(sectionIndex) || !isc.isA.Number(itemIndex)) {
                    this.logWarn("AutoTest.getElement() - didn't understand locator substring:" +
                                 substring);
                    return null;
                }
                if (!this.sections || !this.sections[sectionIndex] ||
                    !this.sections[sectionIndex].items ||
                    !this.sections[sectionIndex].items[itemIndex]) 
                {
                    this.logWarn("AutoTest.getElement(): unable to find section " + sectionIndex + 
                                    ", item:" + itemIndex +  
                                    " requested by locator:" + substring);
                    return null
                }
                var item = this.sections[sectionIndex].items[itemIndex];
                if (!isc.isA[classID] || !isc.isA[classID](item)) {
                    this.logWarn("AutoTest.getElement(): locator substring:"+ substring +
                                " gave component of class:"+ item.getClassName());
                }
                
                return item;
            }
            
            var child;
            for (var childType in this._locatorChildren) {
                child = this._standardChildFromLocatorSubstring(
                            substring, childType, this._locatorChildren[childType]
                        );                         
                if (child) break;
            }
            return child;
        }
        
    });    
}

// --------------------------------------------------
// Interior locators

if (isc.StretchImg) {
isc.StretchImg.addProperties({
    getInteriorLocator : function (element) {
        // We don't use the useEventParts flag in StretchImgs but in some cases we need to tell the
        // difference between events on different items
        // (EG a track-click and a button click)
        var origElement = element,
            handle = this.getHandle(), canvasName = this.getCanvasName();

        while (element && element != handle && element.getAttribute) {
            // check the "name" property for the open-icon 
            var ID = element.getAttribute("name");
            if (ID && ID.startsWith(canvasName)) {
                return ID.substring(canvasName.length);
            }
            element = element.parentNode;
        }
        return this.Super("getInteriorLocator", [origElement]);
    },
    
    getInnerElementFromSplitLocator : function (locatorArray) {
        
        // check for "name" - used for parts
        if (locatorArray && locatorArray.length == 1) {
            var image = this.getImage(locatorArray[0]);
            if (image) return image;
        }
        return this.Super("getInnerElementFromSplitLocator", arguments);
    }
    
    
    
});
}


// label.icon already handled via standard canvas 'eventPart' handling

if (isc.DynamicForm) {
    isc.DynamicForm.addProperties({
        getInteriorLocator : function (element) {
            var itemInfo = isc.DynamicForm._getItemInfoFromElement(element, this);
            // itemInfo format:
            // {item:item, overElement:boolean, overTitle:boolean, overTextBox:boolean,
            //  overControlTable:boolean, overIcon:string}
            if (!itemInfo.item) return this.Super("getInteriorLocator", arguments);
            var item = itemInfo.item,
                locator = ["item[",
                            (item.name ? "name='" + item.name + "'" 
                                       : "index='" + this.items.indexOf(item) + "'"),
                            '][Class="', item.getClassName(), '"]/'];
            if (itemInfo.overElement) locator[locator.length] = "element";
            else if (itemInfo.overTitle) locator[locator.length] = "title";
            else if (itemInfo.overTextBox) locator[locator.length] = "textbox";
            else if (itemInfo.overControlTable) locator[locator.length] = "controltable";
            else if (itemInfo.overIcon) locator[locator.length] = "[icon='" + itemInfo.overIcon + "']"
            
            return locator.join(isc.emptyString);
        },
        
        getChildLocator : function (canvas) {
            if (canvas.canvasItem) {
                var item = canvas.canvasItem;
                return ["item[",
                         (item.name ? "name='" + item.name + "'" 
                                    : "index='" + this.items.indexOf(item) + "'"),
                         '][Class="', item.getClassName(), '"]/',
                         "canvas"].join(isc.emptyString); 
            }
            return this.Super("getChildLocator", arguments);
        },
        
        getInnerElementFromSplitLocator : function (locatorArray) {
            if (!locatorArray || locatorArray.length == 0) {
                return this.getHandle();
            }
            
            var fullItemID = locatorArray[0],
                hasName = fullItemID.contains("name="),
                split = fullItemID.match(
                    "item\\[" + 
                    (hasName ? "name='" : "index='") + 
                    "(.+)'\\]\\[Class=\"(.+)\"\\]");
            
            if (split) {
                var itemID = split[1],
                    className = split[2];
                var item = this.getItem(itemID);
                if (!item) {
                    this.logWarn("AutoTest.getElement(): Unable to find item with identifier" + 
                                     itemID + ", from locator:" + fullItemID);
                    return this.getHandle();
                }
                
                if (!isc.isA[className] || !isc.isA[className](item)) {
                    this.logWarn("AutoTest.getElement(): identifier:"+ fullItemID + 
                                " returned and item of class:"+ item.getClassName());
                }
                
                locatorArray.removeAt(0);
                return item.getInnerElementFromSplitLocator(locatorArray);
            }
            return this.getHandle();
        }
    });
    
    isc.FormItem.addProperties({
        getInnerElementFromSplitLocator : function (locatorArray) {
            if (locatorArray && locatorArray.length > 0) {
                var part = locatorArray[0];
                if (part == "element") return this.getDataElement();
                if (part == "title") return this.form.getTitleCell(this);
                if (part == "textbox") return this._getTextBoxElement();
                if (part == "controltable") return this._getControlTabelElement();
                
                // canvasItems
                if (part == "canvas") {
                    if (this.canvas) {
                        locatorArray.removeAt(0);
                        return this.canvas.getElementFromSplitLocator(locatorArray);
                    }
                }
                
                // If passed an icon, return a pointer to the img element 
                // Event if there is a link element, it'll be above that in the DOM
                var iconSplit = part.match("\\[icon='(.+)'\\]"),
                    iconID = part ? part[1] : null;
                if (iconID) {
                    return this._getIconImgElement(iconID);
                }
            }
        }
    });
}


if (isc.GridRenderer) {
    
    // returns "/row[index]/col[index]"
    
    isc.GridRenderer.addProperties({
        getInteriorLocator : function (element) {     
            var origElement = element,
                handle = this.getHandle(),
                table = this.getTableElement();
            // assertion if we haven't rendered out our tableElement, assume we
            if (!table) return isc.emptyString;
            var rows = table.rows,
                tagName,
                row, cell,
                tr = "tr", TR = "TR",
                td = "td", TD = "TD";
                
            while (element && element != table && element != handle) {
                
                tagName = element.tagName;           
                // document whether it's upper / lower case by default
                if (tagName == td || tagName == TD) {
                    cell = element;
                }
                
                // document whether it's upper / lower case by default
                if (tagName == tr || tagName == TR) {
                    row = element;
                }
                // keep going in case there are nested tables, etc
                element = element.parentNode;
            }
            if (!row || !cell) return this.Super("getInteriorLocator", [origElement]);
            
            var rows = table.rows, rowNum, logicalRowNum;
            for (var i = 0; i < rows.length; i++) {
                if (rows[i] == row) {
                    rowNum = i;
                    break;
                }
            }
            var cells = row.cells, colNum, logicalColNum;
            for (var i = 0; i < cells.length; i++) {
                if (cells[i] == cell) {
                    colNum = i;
                    break;
                }
            }
            logicalRowNum = rowNum + (this._firstDrawnRow || 0)
            logicalColNum = colNum + (this._firstDrawnCol || 0); 
            
            return "row" + logicalRowNum + "/col" + logicalColNum;
        },
        
        getInnerElementFromSplitLocator : function (locatorArray) {
            
            if (!locatorArray || locatorArray.length == 0) return this.getHandle();
            
            // Format should be [row[index], col[index]]
            if (locatorArray.length == 2) {
                //this.logWarn("passed:"+ locatorArray);
                var rowNum = parseInt(locatorArray[0].substring(3)),
                    colNum = parseInt(locatorArray[1].substring(3));
                    
                if (isc.isA.Number(rowNum) && isc.isA.Number(colNum)) {
                    // We suppress all events on row/cols during row animation
                    // in this case suppress the element entirely so auto-test engines
                    // don't attempt to fire events on them.
                    
                    if (this._suppressEventHandling()) return null;
            
                    return this.getTableElement(rowNum, colNum);
                }
            }
            return this.Super("getInnerElementFromSplitLocator", arguments);
        }
    })

}
if (isc.ListGrid) {
      isc.ListGrid.addProperties({
        
        containsLocatorChild : function (canvas) {
            if (canvas == this.body || canvas == this.frozenBody 
                || canvas == this._editRowForm) 
            {
                return true;
            }
            return this.Super("containsLocatorChild", arguments);
        },
        getStandardChildLocator : function (canvas) {
            if (canvas == this.body) return "body";
            if (canvas == this.frozenBody) return "frozenBody";
            if (canvas == this._editRowForm) return "_editRowForm";
            return this.Super("getStandardChildLocator", arguments);            
        }
    });
}
if (isc.TreeGrid) {
    isc.TreeGridBody.addProperties({
        getInteriorLocator : function (element) {
            var origElement = element;
            
            var handle = this.getHandle(),
                tableElement = this.getTableElement();
                
            if (!element || !handle || !tableElement) return isc.emptyString;
            var openAreaPrefix = this.grid.getCanvasName() + this.grid._openIconIDPrefix,
                rowNum, colNum;
   
            // optimization - we could duplicate the logic from GR here and avoid double-iterating
            // through the DOM if we're NOT in the open area of the TG.
            while (element != this.tableElement && element != handle && element.getAttribute) {
                // check the "name" property for the open-icon 
                var ID = element.getAttribute("name");
                if (ID && ID.startsWith(openAreaPrefix)) {
                    rowNum =  ID.substring(openAreaPrefix.length);
                    colNum = this.grid.getTreeFieldNum();
                    return "row" + rowNum + "/col" + colNum + "/open";
                }
                element = element.parentNode;
            }
            
            return this.Super("getInteriorLocator", [origElement]);
        },
        
        
          
        getInnerElementFromSplitLocator : function (locatorArray) {
            
            if (!locatorArray || locatorArray.length == 0) return this.getHandle();
            
            // Additional Format is: [row[index], col[index], open]
            if (locatorArray.length == 3 && locatorArray[2] == "open") {
                // We suppress all events on row/cols during row animation
                // Also suppress toggleFolder event target in this case.
                
                if (this._suppressEventHandling()) return null;
                            
                var rowNum = parseInt(locatorArray[0].substring(3)),
                    colNum = parseInt(locatorArray[1].substring(3));

                // use getImage since we write a name into the opener icon.
                var openerID = this.grid._openIconIDPrefix + rowNum,
                    image = this.grid.getImage(openerID);
                if (image) return image;
                
            }
            return this.Super("getInnerElementFromSplitLocator", arguments);
        }
    })
}

// ----------------------------------------------
// Returning element from interior locator

if (isc.StatefulCanvas) {
    isc.StatefulCanvas.addProperties({
          
        getInnerElementFromSplitLocator : function (locatorArray) {
            // label floats over statefulCanvas - if we have a specified part, assume it occurred
            // in the label since that's where we write out our icon, etc.
            if (locatorArray && this.label) {
                return this.label.getInnerElementFromSplitLocator(locatorArray);
            }
            return this.Super("getInnerElementFromSplitLocator", arguments);    
        }
    });
}
            
}

// Hold off applying the AutoTest interface methods to widget classes until the page is done loading
// This ensures we don't depend on module load order
isc.Page.setEvent("load", "isc.ApplyAutoTestMethods()");


