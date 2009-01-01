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

 




//>	@class	Element
//
// Helper class containing methods for direct DOM interaction. Note that even if 
// +link{isc, isc_useSimpleNames} is true, this class is not available in the global scope
// as <code>window.Element</code> - to access it developers must always use 
// <code>isc.Element</code>
//
//  @treeLocation Client Reference/Foundation
//  @visibility internal
//<
// Currently has no exposed methods - Developers typically will only need to interact with 
// higher level canvas methods
isc.ClassFactory.defineClass("Element", null, null, true);

isc.Element.addClassMethods({


// --------------------------------------------------------------------------------------------
// DOM Access / Manipulation

//>	@classMethod	Element.get()
//		Like the DOM method document.getElementById(), but works in all supported browsers.
//<
get : function (id, doc) {
    doc = doc || this.getDocument();
    if (isc.Browser.isDOM) return doc.getElementById(id);
},


// _getElementFromSelection()
// Determine which DOM element contains the current selection.
// 'doc' param allows caller to pass in a pointer to the document element - (may be document
// element from some frame/iframe - if not specifed the main page document is used).

_getElementFromSelection : function (doc) {

    

    if (!doc) doc = document;
    
    if (isc.Browser.isIE) {
        var selection = doc.selection,
            type = selection.type.toLowerCase(),
            isText = (type == "text" || type == "none");
            
        if (!selection) return null;
            
        // If it's a text range use the 'parentElement()' method to determine what element
        // contains the text.
        // NOTE: an empty selection will be reported as type "None", but can be used to create
        // a zero char text range, so we treat it like a "Text" selection.
        if (isText) {
            var range = selection.createRange();
            return range ? range.parentElement() : null;

        // If it's a control range, we can get at the elements in the control range
        // by index.    Iterate through the elements and find the common ancester.
        
        } else {  
            // If this is a control range 
            // We're interested in the first common ancestor of the elements
            var range = selection.createRange(),
                commonParent;
            for (var i = 0; i < range.length; i++) {

                if (!commonParent) {
                    commonParent = range(i).parentElement;                

                } else {
                    // To determine whether the element is contained by the common parent, 
                    // we're creating a textRange from both elements and using the inRange
                    // method.
                    while (!commonParent.contains(range(i))) {
                        commonParent = commonParent.parentElement;
                    }
                } 
                
            }
            return commonParent;
        }
    }
},

// Given an element attribute, iterate recursively through child nodes till you find a match.
// May be slow for deep hierarchies
findAttribute : function (element, attribute, value) {
    if (!element) return null;    
    if (element[attribute] == value || 
    (element.getAttribute && element.getAttribute(attribute) == value)) {   
        return element;
    }
    var children = element.childNodes;
    for (var i = 0; i < children.length; i++) {
        var subElement = this.findAttribute(children[i], attribute, value);
        if (subElement) return subElement;
    }
    return null;
    
},


// helpers for createAbsoluteElement
_insertAfterBodyStart : window.isc_insertAfterBodyStart,
_globalInsertionMarker : "isc_global_insertion_marker",
getInsertionMarkerHTML : function () {
    return "<span id='"+this._globalInsertionMarker+"' style='display:none'></span>";
},
getInsertionMarker : function () {
    return document.getElementById(this._globalInsertionMarker);
},
// create a new, absolutely positioned element, after page load
_$afterBegin : "afterBegin",
_$afterEnd : "afterEnd",
_$beforeBegin: "beforeBegin",
_$beforeEnd : "beforeEnd",
createAbsoluteElement : function (html, targetWindow) {
    var wd = targetWindow || this.getWindow(),
         
        body = this.getDocumentBody(true);

    
    
    //>DEBUG
    // if there's no body tag, we bail
    if (body == null && !isc.Element.noBodyTagMessageShown) {
        isc.Element.noBodyTagMessageShown = true;
        var msg ="Error: Attempt to write content into a page outside the BODY tag.  Isomorphic " +
            "SmartClient requires this tag be present and all widgets be written out inside " +
            "it.\r" +
            "Please ensure your file has a BODY tag and any code to draw SmartClient widgets " +
            "is enclosed in this tag."
            ;
        //alert(msg);
        this.logError(msg);
        return;
    }
    //<DEBUG

    

    // safety valve - use a global var to switch back to our previous rendering mode - set
    // window.isc_insertAfterBodyStart to enable this rendering mode.
    if (this._insertAfterBodyStart) {
        return isc.Element.insertAdjacentHTML(body, this._$afterBegin, html, true);
    }

    if (isc.Browser.isIE) {
        if (!this._insertionMarker) {
            if (body.childNodes.length < 2) {
                // empty body or body with just one element, in either case insert afterBegin
                // of the body on the assumption that the one element may not be closed.
                isc.Element.insertAdjacentHTML(body, this._$afterBegin, this.getInsertionMarkerHTML());
            } else {
                // insert right before the last element
                //
                // If the last element is a text node, spin back through the siblings until we
                // find one that isn't a text node because calling
                // textNode.insertAdjacentHTML() results in a "no such method" in IE
                //
                // One natural way in which such text elements get created is by the use of an
                // <INPUT> element with no enclosing <FORM> tag, right at the end of the page.
                var node = body.lastChild;
                while (node && node.nodeType == 3) node = node.previousSibling;
                if (node != null) {
                    isc.Element.insertAdjacentHTML(node, this._$beforeBegin, 
                                                  this.getInsertionMarkerHTML());
                } else {
                    // all nodes of the body are text nodes, insert after body begin
                    isc.Element.insertAdjacentHTML(body, this._$afterBegin, this.getInsertionMarkerHTML());
                }
            }
            this._insertionMarker = this.getInsertionMarker();
        }
        return isc.Element.insertAdjacentHTML(this._insertionMarker, this._$afterEnd, html, true);            
    } else {
        return isc.Element.insertAdjacentHTML(body, this._$beforeEnd, html, true);
    }
},

// emulate IE's insertAdjacentHTML on any fully DOM-compliant browser
insertAdjacentHTML : function (element, where, html, singleElement) {
    // handle string element IDs
    if (isc.isA.String(element)) element = isc.Element.get(element);

    //>DEBUG
    if (!element) this.logWarn("insertAdjacentHTML: element is null for where: '" + where + 
                                "' with html: " + html);
    //<DEBUG

    if (isc.Browser.isIE || isc.Browser.isOpera) {
        // in IE it's supported natively
        element.insertAdjacentHTML(where, html);
        return;
    }

    //this.logWarn("inserting at element: " + this.echoLeaf(element) + 
    //             " at position " + where + ", html: " + this.echoLeaf(html));


    
    var newElement;
    if (singleElement) {
        var wrapper = element.ownerDocument.createElement("DIV");
        wrapper.innerHTML = html;
        newElement = wrapper.firstChild;
    } else {
        // create a document fragment from the HTML
        var range = element.ownerDocument.createRange();
        range.setStartBefore(element);
        newElement = range.createContextualFragment(html);
    }

    // insert it into the given parent
    switch (where){
    case "beforeBegin":
        element.parentNode.insertBefore(newElement, element)
		break;
    case "afterBegin":
		element.insertBefore(newElement, element.firstChild);
		break;
	case "beforeEnd":
		element.appendChild(newElement);
		break;
	case "afterEnd":
		if (element.nextSibling) element.parentNode.insertBefore(newElement, element.nextSibling);
		else element.parentNode.appendChild(newElement);
		break;
	}
    if (singleElement) return newElement;
},

// clear the element passed in (removing it's HTML from the DOM)
clear : function (element) {
    if (element == null) return;
 
    
    if (isc.Page.isLoaded() && isc.Browser.isIE) {
        element.outerHTML = isc.emptyString;
        return;
    }

    if (element.parentNode) {
        element.parentNode.removeChild(element);
    } else {
        
        //>DEBUG
        isc.Log.logWarn("element parentNode null"); //<DEBUG
        element.innerHTML = "";
    }
},	

// ----------------------------------------------------------------------------------------
// Deriving sizing/positioning + margins etc information from HTML elements
// ----------------------------------------------------------------------------------------
// As with Canvii, these methods will work with the size of the HTML element, INCLUDING any
// margins wherever appropriate.
// This means:
// - getOffsetLeft(element) / getOffsetTop(element) return the offset top / left of the element's
//   margin, rather than of the element itself
// - getVisibleWidth(element) / getVisibleHeight(element) return the height / width of the element
//   including top and bottom margins.


// helper: Does this element adhere to the border-box model or the content-box model for sizing?
isBorderBox : function (element) {
    if (!element) return;
    if (!isc.Browser.isMoz) return isc.Browser.isBorderBox;
    
    return (element.style.MozBoxSizing == "border-box");
},

// Return the scrollHeight (scrollable height) for the element.
getScrollHeight : function (element) {

    if (element == null) return 0;

    
    var height = ((element.scrollHeight!= null && element.scrollHeight != "undefined") 
                                                ? element.scrollHeight : element.offsetHeight);

    
    var largestBottom = this._getPositionedChildrenBottom(element);

    return largestBottom > height ? largestBottom : height;
},

// get the largest bottom coordinate for any explicitly positioned DOM children of this element
_getPositionedChildrenBottom : function (element) {
    if (element.childNodes == null) return 0;

    var largest = 0,
        // constants for determining whether a DOM node is an element.  
        
        elementType = document.ELEMENT_NODE || 1,
        debug = this.logIsDebugEnabled("sizing");

    for (var i = 0; i < element.childNodes.length; i++) {
        var child = element.childNodes.item(i);
        
        // ignore anything that isn't an element (only elements report any size information)
        if (child.nodeType != elementType) continue;
        
        var childPosition = isc.Element.getComputedStyleAttribute(child, "position");
        
        // get the top coordinate of the child
        var childTop = 0;
        if (childPosition == isc.Canvas.ABSOLUTE || childPosition == isc.Canvas.RELATIVE) {
            childTop += isc.Element.getOffsetTop(child);
        } else {
            // inline content ("position" property unset).  We don't inspect this because the
            // scrollWidth reported by the element includes inline content
            continue;
        }

        
        var canvas = child.getAttribute("eventProxy"),
            childVisibleHeight;
        if (canvas != null && 
            !isc.isAn.emptyString(canvas) && 
            !window[canvas]._retrievingScrollHeight &&
            isc.isA.Function(window[canvas].getVisibleHeight)) 
        {
            childVisibleHeight = window[canvas].getVisibleHeight();
        } else {
            // For regular DOM elements call isc.Element.getVisibleHeight(element) instead
            childVisibleHeight = isc.Element.getVisibleHeight(child);
        }
        
        var childBottom = childTop + childVisibleHeight;
        // Notes:
        // - the 'visibleHeight' is the height of this child, including any margins.
        //   if this (parent) is scrollable, and the child is absolutely positioned, we 
        //   natively can't scroll to the right/bottom margin, so deduct this from the reported
        //   parent scroll-width.
        // - This child will be drawn over the top of any padding applied to the element, so we
        //   don't need to add that to the childBottom value.  Only inline elements will force
        //   the parents' padding to show up below them.
        if (childPosition == isc.Canvas.ABSOLUTE && 
            (element.style.overflow == isc.Canvas.SCROLL ||
             element.style.overflow == isc.Canvas.AUTO ||
             element.style.overflow == isc.Canvas.HIDDEN))
             childBottom -= isc.Element.getBottomMargin(child);
        
        
        
        if (childBottom > largest) largest = childBottom;

        
    }
    return largest;
},

// isc.Element.getScrollWidth(element) - See comments for getScrollHeight
getScrollWidth : function (element) {
    if (element == null) return 0;
    
    
    var width = ((element.scrollWidth != null && element.scrollWidth != "undefined") ? 
                     element.scrollWidth : element.offsetWidth);
    
    // if we have any position:absolute or position:relative children, find the right-most one
    var largestRight = this._getPositionedChildrenRight(element);

    return largestRight > width ? largestRight : width;
},

// get the largest right coordinate for any explicitly positioned DOM children of this element
_getPositionedChildrenRight : function (element) {
    if (element.childNodes == null) return 0;

    var largest = 0,
        // constants for determining whether a DOM node is an element.  
        
        elementType = document.ELEMENT_NODE || 1,
        debug = this.logIsDebugEnabled("sizing");

    for (var i = 0; i < element.childNodes.length; i++) {
        var child = element.childNodes.item(i);
        
        if (child.nodeType != elementType) continue;
        
        var childStyle = isc.Element.getComputedStyle(child, ["position", "display", "left"]);
        
        var childLeft = 0;
        if (childStyle.position == isc.Canvas.ABSOLUTE || 
            childStyle.position == isc.Canvas.RELATIVE) 
        {
            childLeft = isc.Element.getOffsetLeft(child);
        } else {
            // inline content ("position" property unset).  We don't inspect this because the
            // scrollWidth reported by the element includes inline content
            continue;
        }
 
        
        var canvas = child.getAttribute("eventProxy"),
            childVisibleWidth;
        if (canvas != null && 
            !isc.isAn.emptyString(canvas) && 
            !window[canvas]._retrievingScrollWidth &&
            isc.isA.Function(window[canvas].getVisibleWidth)) 
        {
            childVisibleWidth = window[canvas].getVisibleWidth();
        } else {
            // For regular DOM elements call isc.Element.getVisibleWidth(element) instead
            childVisibleWidth = isc.Element.getVisibleWidth(child);
        }
        
        var childRight = childLeft + childVisibleWidth;
        if (element.style.overflow == isc.Canvas.SCROLL || 
            element.style.overflow == isc.Canvas.HIDDEN ||
            element.style.overflow == isc.Canvas.AUTO) {
                childRight -= isc.Element.getRightMargin(child);
       }
        
        if (childRight > largest) largest = childRight;
 
        //>DEBUG
        if (debug) {
            this.logInfo("getChildNodesRight: child node " + i + " of " + 
                         element.childNodes.length + " (" + this.echoLeaf(child) + ")" +
                         " left:" + childLeft + ", width: " + childVisibleWidth + 
                         ", right:" + childRight, "sizing");
        }
        //<DEBUG
    }
    return largest;
},

getElementRect : function (element) {
    var body = this.getDocumentBody(),
        left = this._getLeftOffsetFromElement(element, body), 
        top = this._getTopOffsetFromElement(element, body);

    var width = 0, height = 0;
    if (element.style && element.style.overflow == "visible") {
        width = this.getScrollWidth(element);
        height = this.getScrollHeight(element);
    }
    
    width = Math.max(element.offsetWidth, element.clientWidth, width);
    height = Math.max(element.offsetHeight, element.clientHeight, height);
    return [ left, top, width, height ];
},

// get the inner width of an arbitrary dom element
// Note: we use this for widgets with htmlElement and matchElement set.
// Implementation doesn't cache results - don't use this in critical path code as it may be
// somewhat slow
getInnerWidth : function (element) {
    // assume content-box sizing (the default)
    // If specified style.width will be the available 'inner' width, excluding padding, 
    // margin, border
    // (ignore element overflow for now)
    var styleWidth = element.style.width;
    if (styleWidth != null && !isc.isAn.emptyString(styleWidth)) {
        styleWidth = parseInt(styleWidth);
        if (isc.isA.Number(styleWidth)) return styleWidth;
    }
    
    // If width is unspecified - measure how large the element rendered out.
    //
    // element.clientWidth will be the width of the element excluding border and margin,
    // but including padding. Delete the padding thickness to get the widget we want.
    var clientWidth = element.clientWidth,
        paddingLeft = parseInt(this.getComputedStyleAttribute("paddingLeft")),
        paddingRight = parseInt(this.getComputedStyleAttribute("paddingRight")),
        padding = paddingLeft + paddingRight;
    if (isc.isA.Number(padding)) clientWidth -= padding;
    return clientWidth;
},
getInnerHeight : function (element) {
    // assume content-box sizing (the default)
    // If specified style.width will be the available 'inner' width, excluding padding, 
    // margin, border
    // (ignore element overflow for now)
    var styleHeight = element.style.height;
    if (styleHeight != null && !isc.isAn.emptyString(styleHeight)) {
        styleHeight = parseInt(styleHeight);
        if (isc.isA.Number(styleHeight)) return styleHeight;
    }
    
    // If height is unspecified - measure how large the element rendered out.
    var clientHeight = element.clientHeight,
        paddingTop = parseInt(this.getComputedStyleAttribute("paddingTop")),
        paddingBottom = parseInt(this.getComputedStyleAttribute("paddingBottom")),
        padding = paddingTop + paddingBottom;
    if (isc.isA.Number(padding)) clientHeight -= padding;
    return clientHeight;
},


getNativeInnerWidth : function (element) {
    if (isc.Browser.isMoz) return this.getInnerWidth(element);
    var width = element.offsetWidth;
    // 0 or null
    if (!width) width = this.getInnerWidth(element);
    return width;
},
getNativeInnerHeight : function (element) {
    if (isc.Browser.isMoz) return this.getInnerHeight(element);
    var height = element.offsetHeight;
    // 0 or null
    if (!height) height = this.getInnerHeight(element);
    return height;
},




// Methods to get the margin sizes for an element

getTopMargin : function (element) {
    if (element != null) {
        var topMargin;
        if (element.style != null) topMargin = parseInt(element.style.marginTop);
        if (isc.isA.Number(topMargin)) return topMargin;
        if (element.className != null) return isc.Element._getTopMargin(element.className);
    }
    return 0;
},
getBottomMargin : function (element) {
    if (element != null) {
        var bottomMargin;
        if (element.style != null) bottomMargin = parseInt(element.style.marginBottom);
        if (isc.isA.Number(bottomMargin)) return bottomMargin;
        if (element.className != null) return isc.Element._getBottomMargin(element.className);
    }
    return 0;
},
getLeftMargin : function (element) {
    if (element != null) {
        var leftMargin;
        if (element.style != null) leftMargin = parseInt(element.style.marginLeft);
        if (isc.isA.Number(leftMargin)) return leftMargin;
        if (element.className != null) return isc.Element._getLeftMargin(element.className);
    }
    return 0;
},
getRightMargin : function (element) {
    if (element != null) {
        var rightMargin;
        if (element.style != null) rightMargin = parseInt(element.style.marginRight);
        if (isc.isA.Number(rightMargin)) return rightMargin;
        if (element.className != null) return isc.Element._getRightMargin(element.className);
    }
    return 0;
},

getHMarginSize : function (element) {
    return isc.Element.getLeftMargin(element) + isc.Element.getRightMargin(element);
},
getVMarginSize : function (element) {
    return isc.Element.getTopMargin(element) + isc.Element.getBottomMargin(element);
},

getTopBorderSize : function (element) {
    if (element == null) return 0;
    if (isc.Browser.isOpera && element.currentStyle.borderTopStyle == this._$none) return 0;
    var borderSize = (isc.Browser.isIE || isc.Browser.isOpera
                        ? parseInt(element.currentStyle.borderTopWidth)
                        : parseInt(isc.Element.getComputedStyleAttribute(element, "borderTopWidth"))
                      );
                      
    return isNaN(borderSize) ? 0 : borderSize;
},

getBottomBorderSize : function (element) {
    if (element == null) return 0;
    if (isc.Browser.isOpera && element.currentStyle.borderBottomStyle == this._$none) return 0;    
    var borderSize = (isc.Browser.isIE || isc.Browser.isOpera
                        ? parseInt(element.currentStyle.borderBottomWidth)
                        : parseInt(isc.Element.getComputedStyleAttribute(element, "borderBottomWidth"))
                     );
    return isNaN(borderSize) ? 0 : borderSize;
},

getLeftBorderSize : function (element) {
    if (element == null) return 0;
    if (isc.Browser.isOpera && element.currentStyle.borderLeftStyle == this._$none) return 0;    
    var borderSize = (isc.Browser.isIE || isc.Browser.isOpera
                        ? parseInt(element.currentStyle.borderLeftWidth)
                        : parseInt(isc.Element.getComputedStyleAttribute(element, "borderLeftWidth"))
                     );
    return isNaN(borderSize) ? 0 : borderSize;
},

getRightBorderSize : function (element) {
    if (element == null) return 0;
    if (isc.Browser.isOpera && element.currentStyle.borderRightStyle == this._$none) return 0;
    var borderSize = (isc.Browser.isIE || isc.Browser.isOpera
                        ? parseInt(element.currentStyle.borderRightWidth)
                        : parseInt(isc.Element.getComputedStyleAttribute(element, "borderRightWidth"))
                      );
    return isNaN(borderSize) ? 0 : borderSize;
},

getVBorderSize : function (element) {
    return isc.Element.getTopBorderSize(element) + isc.Element.getBottomBorderSize(element);
},
getHBorderSize : function (element) {
    return isc.Element.getLeftBorderSize(element) + isc.Element.getRightBorderSize(element);
},

// getVisibleWidth / getVisibleHeight:
// when passed a DOM element, return the drawn size of the element, including any overflow, 
// border, margin or padding.
getVisibleWidth : function (element) {
    if (element == null) return 0;
    
    var overflow = isc.Element.getComputedStyleAttribute(element, "overflow"),
        width;
    if (overflow == isc.Canvas.VISIBLE || !isc.isA.Number(parseInt(element.style.width))) {
        width = isc.Element.getScrollWidth(element) + 
                isc.Element.getHBorderSize(element);

    } else {
        // use the specified width
        width = parseInt(element.style.width);
    }
    return width + isc.Element.getHMarginSize(element);
},

getVisibleHeight : function (element) {
    if (element == null) return 0;

    var overflow = isc.Element.getComputedStyleAttribute(element, "overflow"),
        height;
    if (overflow == isc.Canvas.VISIBLE || !isc.isA.Number(parseInt(element.style.height))) {
        height = isc.Element.getScrollHeight(element) + isc.Element.getVBorderSize(element);
    } else {
        // use the specified height
        height = parseInt(element.style.height);
    }
    return height + isc.Element.getVMarginSize(element);
},


// Element.getOffsetLeft()
//  Takes 'element'
//  element should be a pointer to a DOM element or the ID for a DOM element
//  (To get the offsetLeft for a widget use use widget.getOffsetLeft() instead)
//  Returns the true offsetLeft - the absolute left coordinate with respect to whatever is
//  reported by the DOM as the offsetParent of the element.
getOffsetLeft : function (element) {
 
    // Note: This method is used by the canvas instance 'getOffsetLeft()' method to calculate
    // the offset position.
    // We work with coordinates / sizes relative to the outside of any margins around our 
    // widgets - do the same with this method.
    
    if (element == null) {
        this.logWarn("getOffsetLeft: passed null element");
        return 0;
    }
    
    // IE and Moz both return somewhat unreliable values for element.offsetLeft by default.
    // Paper over these bugs and differences.
    var left = element.offsetLeft;
    // --- caching code:
    // If we've already calculated a value (based on a reported offsetLeft value), and
    // the reported value has not changed, return the previously calculated value.
    // This caching is safe except for cases where an indirect parent's styling changes in a
    // way that would affect this element's true offsetLeft.
    if (element._cachedReportedOffsetLeft == left) {
        return element._cachedCalculatedOffsetLeft;
    } else {
        // debug message for sanity checking coordinate caching
        //this.logWarn(element.getAttribute("eventProxy") + ": new DOM value for offsetLeft");
    }

    // always subtract the left margin (if there is one) to get the position OUTSIDE the
    // margins.
    // Note: for a negative margin, the reported offsetLeft does not need to be adjusted by the
    // specified margin size - it represents the position of the element - and in this case there
    // is no margin outside the element (rather the specified margin shifts the element to the 
    // left / up)
    var leftMargin = parseInt(isc.Element.getComputedStyleAttribute(element, "marginLeft"));
    if (isc.isA.Number(leftMargin) && leftMargin > 0) {
        left -= leftMargin;
    }
    
    
    var documentBody = this.getDocumentBody(),
        parentStyle,
        px = "px",
        // determine whether the element is absolutely / relatively / etc. positioned    
        elementPosition = element.style.position;

    // Workarounds for Moz        
    if (isc.Browser.isMoz) {
        // In moz we get some unexpected results
        
        if (element.offsetParent == null) return left;
        
        if (element.offsetParent != documentBody) {

            parentStyle = 
                this.ns.Element.getComputedStyle(element.offsetParent, ["borderLeftWidth", "overflow"]);       

            // The behavior changes with different releses of Moz / Firefox
            var geckoVersion = isc.Browser.geckoVersion,
            
                
                scrollingAdjustment = (parentStyle.overflow != "visible") &&
                                      (geckoVersion >= 20051111 || 
                                      (elementPosition == isc.Canvas.ABSOLUTE && parentStyle.overflow != "hidden")),
                
                accountForBorderBox = (geckoVersion > 20020826 &&
                                        (element.offsetParent.style.MozBoxSizing == "border-box"));

            
            if (accountForBorderBox != scrollingAdjustment) {

                
                if (accountForBorderBox) {
                    left -= (isc.isA.Number(parseInt(parentStyle.borderLeftWidth)) ?
                                            parseInt(parentStyle.borderLeftWidth) : 0);
                                            
                } 
                
                if (scrollingAdjustment) {
                    left += (isc.isA.Number(parseInt(parentStyle.borderLeftWidth)) ?
                                            parseInt(parentStyle.borderLeftWidth) : 0);
                                            
                }
            }
                  
        }
    }
    
    // Workarounds for IE
     
    if (isc.Browser.isIE && !isc.Browser.isIE8Strict) {
    
        

        var currentParent = element.offsetParent,
            parentStyle;
        if (parentStyle != documentBody) parentStyle = currentParent.currentStyle; 
        
        
        var hasSpecifiedSize = (element.currentStyle.height != isc.Canvas.AUTO ||
                                element.currentStyle.width != isc.Canvas.AUTO);

        
        var continueDeductingBorders = true;                                
        
        // iterate up the offsetParents till we reach the doc. body
        while (currentParent != documentBody) {

            
            
            
            if (parentStyle.position == isc.Canvas.ABSOLUTE) continueDeductingBorders = false;
            
            
            if (parentStyle.width == isc.Canvas.AUTO && 
                parentStyle.height == isc.Canvas.AUTO &&
                parentStyle.position == isc.Canvas.RELATIVE) {
                
                
                if (continueDeductingBorders &&
                    isc.isA.String(parentStyle.borderLeftWidth) && 
                    parentStyle.borderLeftWidth.contains(px)        ) {
                        left -= parseInt(parentStyle.borderLeftWidth);
                }    
                
                
                if (hasSpecifiedSize) {
                
                    if (isc.isA.String(parentStyle.marginLeft) && 
                        parentStyle.marginLeft.contains(px)) 
                    {
                        var parentMarginLeft = parseInt(parentStyle.marginLeft);
                        if (parentMarginLeft > 0) left -= parentMarginLeft;
                    }                           
                
                    
                    if (currentParent.offsetParent != documentBody) {
                        
                        var superPadding = currentParent.offsetParent.currentStyle.padding;
                        if (isc.isA.String(superPadding) && superPadding.contains(px)) {
                            left -= parseInt(superPadding);
                        }
                    } else {    
                        
                        left -= (documentBody.leftMargin ? parseInt(documentBody.leftMargin) : 0);                
                    }
                } 
                
            } // end of if

            
            elementPosition = currentParent.style.position;
            currentParent = currentParent.offsetParent;
            if (currentParent != document.body) {
                parentStyle = currentParent.currentStyle;
            }
            
        }   // End of while loop
        
    }        
    
    // Workarounds for Safari
    if (isc.Browser.isSafari && isc.Browser.safariVersion < 525.271) {
        // In some versions of Safari, if the offsetParent has a border, the offsetLeft / top
        // reported is relative to the outside of that border, rather than the inside, so deduct
        // that value
        // No longer the case in Safari 3.2.1 (525.27.1)
        if (element.offsetParent != null && element.offsetParent != documentBody) {
            var parentBorder = 
                this.ns.Element.getComputedStyle(element.offsetParent, ["borderLeftWidth"]).borderLeftWidth;
            if (parentBorder != null) parentBorder = parseInt(parentBorder);
            if (isc.isA.Number(parentBorder)) left -= parentBorder;
        }
    }
    // --- cacheing code:
    // Cache the calculated and reported value, by saving it as attributes on the DOM element
    element._cachedReportedOffsetLeft = element.offsetLeft;
    element._cachedCalculatedOffsetLeft = left;
    
    return left;
},

// Element.getOffsetTop()
//  Takes 'element' 
//  element should be a pointer to a DOM element or the ID for a DOM element (doesn't 
//  handle getting a widget ID - in that case use widget.getOffsetTop() instead)
//  Returns the true offsetTop - the absolute top coordinate with respect to (the inside of any
//  border of) whatever is reported by the DOM as the offsetParent of the element.

getOffsetTop : function (element) {
    // In theory the value element.offsetTop should be what we want here. However it is
    // unreliable in a number of ways.
    if (element == null) {
        this.logWarn("getOffsetTop: passed null element");
        return 0;
    }
    
    // IE and Moz both return somewhat unreliable values for element.offsetTop by default.
    // Paper over these bugs and differences.
    var top = element.offsetTop;  // This is what we'd return if the browsers worked correctly!
    
    // --- caching code:
    // If we've already calculated a value (based on a reported offsetTop value), and
    // the reported value has not changed, return the previously calculated value.
    if (element._cachedReportedOffsetTop == top) {
        return element._cachedCalculatedOffsetTop;
    } else {
        // debug message for sanity checking coordinate caching
        //this.logWarn(element.getAttribute("eventProxy") + ": new DOM value for offsetTop");
    }

    // The reported offsetTop is the offset from the element, INSIDE of margins to the
    // offsetParent - if we have a top margin we should subtract it to get the position OUTSIDE
    // the margins.
    // Exception: If the margin is negative, we don't need to adjust for it. In this case the
    // reported offset is still to the outside of the element, even though the element is 
    // essentially shifted above where it would normally appear.
    
    var topMargin = parseInt(isc.Element.getComputedStyleAttribute(element, "marginTop"));
    if (isc.isA.Number(topMargin) && topMargin > 0) {
        top -= topMargin;
    }
    
    var documentBody = this.getDocumentBody(),
        parentStyle,
        px = "px",
        elementPosition = element.style.position;

    // Workarounds for Moz        
    if (isc.Browser.isMoz) {
        
        
        
        if (element.offsetParent == null) return top;
        if (element.offsetParent != documentBody) {

            // get the offsetParent's style info
            parentStyle = this.ns.Element.getComputedStyle(element.offsetParent, ["overflow", "borderTopWidth"]);

            var scrollingAdjustment = (parentStyle.overflow != "visible") && 
                                      (isc.Browser.geckoVersion >= 20051111 || 
                                      (elementPosition == isc.Canvas.ABSOLUTE && parentStyle.overflow != "hidden")),
            
                accountForBorderBox = (isc.Browser.geckoVersion > 20020826 && 
                                        element.offsetParent.style.MozBoxSizing == "border-box");

            
            if (accountForBorderBox != scrollingAdjustment) {
                if (accountForBorderBox) {
                    top -= (isc.isA.Number(parseInt(parentStyle.borderTopWidth)) ?
                                            parseInt(parentStyle.borderTopWidth) : 0);

                } 
                if (scrollingAdjustment) {
                    top += (isc.isA.Number(parseInt(parentStyle.borderTopWidth)) ?
                                            parseInt(parentStyle.borderTopWidth) : 0);
                }
            }
        }
    }
    
    // Workarounds for IE
    if (isc.Browser.isIE) {
        
        if (element.offsetParent && element.offsetParent != documentBody) {

            parentStyle = element.offsetParent.currentStyle;  
            
            
            if (    parentStyle.position == isc.Canvas.RELATIVE &&  
                    parentStyle.height == isc.Canvas.AUTO && 
                    parentStyle.width == isc.Canvas.AUTO &&  
                    isc.isA.String(parentStyle.borderTopWidth) && 
                    parentStyle.borderTopWidth.contains(px)         ) {
                        top -= parseInt(parentStyle.borderTopWidth);
            }
        }
    }    
    
    // Workarounds for Safari
    if (isc.Browser.isSafari && isc.Browser.safariVersion < 525.271) {
        // As noted in 'getOffsetLeft()', in Safari the width of the parent's border is included
        // in the offsetLeft/top value reported.
        if (element.offsetParent && element.offsetParent != documentBody) {
            var parentBorder = 
                this.ns.Element.getComputedStyle(element.offsetParent, 
                                                ["borderTopWidth"]).borderTopWidth;
            
            if (parentBorder != null) parentBorder = parseInt(parentBorder);
            if (isc.isA.Number(parentBorder)) top -= parentBorder;
        }
    }    
    
    // --- cacheing code:
    // Cache the calculated and reported value, by saving it as attributes on the DOM element
    element._cachedReportedOffsetTop = element.offsetTop;
    element._cachedCalculatedOffsetTop = top;
   
    return top;

},

// _getLeftOffsetFromElement(element, targetElement, rtl)
//
// DOM Only method to return the absolute (offset) position for some element within some other 
// DOM parent element.  We will return this value from the outside of any border / margin on
// the child to the inside of the ancestor element.
//

_getLeftOffsetFromElement : function (element, targetElement, rtl) {
    return this._getOffsetFromElement(isc.Canvas.LEFT, element, targetElement, rtl);
},

// Return the absolute position of an element within a DOM parent element.
// If no target parent element is passed, we return page level position.
_getTopOffsetFromElement : function (element, targetElement) {
    return this._getOffsetFromElement(isc.Canvas.TOP, element, targetElement);
},


_$borderLeftWidth : isc.Browser.isMoz ? "border-left-width" : "borderLeftWidth",
_$borderTopWidth : isc.Browser.isMoz ? "border-top-width" : "borderTopWidth",
_$marginLeft : isc.Browser.isMoz ? "margin-left" : "marginLeft",
_$marginTop : isc.Browser.isMoz ? "margin-top" : "marginTop",
_$none:"none",
_getOffsetFromElement : function (dir, element, targetElement, rtl) {
    
    //!DONTCOMBINE
    //>DEBUG
    if (targetElement == null || element == null) {
        
        return 0;
    }
    //<DEBUG

    var nextParent = element.offsetParent;

    
    if (isc.Browser.isMoz && nextParent == null) return 0;
    
    
    // To get the offsetLeft / Top with respect to the passed in targetElement,     
    // iterate through the offsetParents, summing 'offsetLeft' until we reach the targetElement.
    // If we reach the targetElement's offsetParent before we hit the targetElement we've jumped
    // over the target - this is Ok - just deduct the offsetLeft of the targetElement to adjust
    // for it.
    // For each iteration adjust for scrolling and border / margin thickness 
    // (see comments in the while loop below).
    var targetParent = targetElement.offsetParent,
        currentNode = element,
        offset = 0,
        isLeft = (dir == isc.Canvas.LEFT),
        borderWidthProp = (isLeft ? this._$borderLeftWidth : this._$borderTopWidth),
        marginProp = (isLeft ? this._$marginLeft : this._$marginTop);
  

    if (!isLeft) rtl = false;
    else if (rtl == null) rtl = (isc.Page.getTextDirection() == isc.Canvas.RTL);

    // iterate up until we reach the targetElement, or the targetElement's offsetParent
    // We could also check for documentBody to avoid crashing in the case where we were 
    // passed bad params.
    var iterations = 0;
    while (nextParent != targetElement && nextParent != targetParent) {    

        // Add the currentNode's offsetLeft - left w.r.t. its offsetParent
        var subOffset = (isLeft ? this.ns.Element.getOffsetLeft(currentNode) :
                            this.ns.Element.getOffsetTop(currentNode));
        offset += subOffset;                            

        // The offsetLeft/top value is relative to the content of the parent's element - so if
        // the parent is scrolled, and we want the floating position of this element within
        // it's parent we have to deduct the scrollLeft of the parent to page coordinate 
        // relative to the parent's element's top/left
        if (!rtl) {
            // deduct the scrollLeft/top
            offset -= ((isLeft ? nextParent.scrollLeft : nextParent.scrollTop) || 0);      
        } else {
            // rtl var is only ever true when calculating left offset.
            if (isc.isA.Number(nextParent.scrollLeft)) {
                
                var maxScrollLeft = (nextParent.scrollWidth - nextParent.clientWidth);
                offset += (maxScrollLeft - nextParent.scrollLeft);
            }
        }


        // add the border / margin thickness, because when we add the parent's offsetLeft
        // this will be the distance from the OUTSIDE of this element's border/margin 
        // to the inside of the next parent's element.
        // Note: Skip this if the margin is negative as in this case the value we have from
        // getOffsetTop() / Left() is actually relative to the outside of the element
        var styleObj, borderWidth, marginWidth;
        if (isc.Browser.isIE || isc.Browser.isOpera) {
            
            styleObj = nextParent.currentStyle;

            // In Opera, currentStyle is available, but border / borderLeftWidth et al are
            // reported as 3 when no border is specified. Therefore look at borderStyle as
            // well in this browser.
            if (isc.Browser.isOpera && 
                (isLeft ? styleObj.borderLeftStyle == this._$none 
                        : styleObj.borderTopStyle == this._$none)) borderWidth = null;
            else borderWidth = parseInt(styleObj[borderWidthProp]);
            
            if (isc.isA.Number(borderWidth)) offset += borderWidth;
            
            marginWidth = parseInt(styleObj[marginProp]);      
            if (isc.isA.Number(marginWidth) && marginWidth > 0) offset += marginWidth;
            
        } else if (isc.Browser.isMoz) {
             
            styleObj = document.defaultView.getComputedStyle(nextParent, null);

            borderWidth = parseInt(styleObj.getPropertyValue(borderWidthProp));
            offset += borderWidth;

            marginWidth = parseInt(styleObj.getPropertyValue(marginProp));
            
            if (marginWidth > 0) offset += marginWidth;

        } else {


            borderWidth = parseInt(this.getComputedStyleAttribute(nextParent, 
                                                                  borderWidthProp));
                                                                              
            if (isc.isA.Number(borderWidth)) offset += borderWidth;

            marginWidth = parseInt(this.getComputedStyleAttribute(nextParent, 
                                                                  marginProp));
            if (isc.isA.Number(marginWidth) && marginWidth > 0) offset += marginWidth;

        }

        // Move up the DOM chain
        currentNode = nextParent;
        nextParent = currentNode.offsetParent;        
        iterations++;
    }    

    // At this point the nextParent is either the target or it's offsetParent.
    // add the offsetLeft between the current node and the nextParent.
    offset += (isLeft ? this.ns.Element.getOffsetLeft(currentNode) :
                        this.ns.Element.getOffsetTop(currentNode));
                       
    // OffsetLeft from the last iteration was relative to the target's offsetParent -
    // deduct the target's offsetLeft to get the offset relative to the target instead.
    if (nextParent == targetParent) {
        // deduct the targetElement's offsetLeft
        // No need to adjust for border / padding in this case
        offset -= (isLeft ? this.ns.Element.getOffsetLeft(targetElement) :
                            this.ns.Element.getOffsetTop(targetElement));                  
    }
    //this.logWarn("iterations: " + iterations);
    return offset;
},

   



// ----------------------------------------------------------------------------------------
// CSS / Styling Lookups
// ----------------------------------------------------------------------------------------
// Retrieval of CSS style declaration and computed styles

// Styling: what we need and why:
// We need to be able to look up border, padding and margin sizes in order to:
// - compensate for errors in reported offsetLeft / offsetTop to have correct page-level
//   coordinates when relatively positioned (needed for arbitrary containing elements not
//   created by ISC)
// - when using the CSS standard box model, be able to write HTML that will render with
//   predictable sizes even when using author-specified CSS styling.  This is critical for grid
//   cell rendering, where correcting sizes after draw is not even close to feasible.
// - get correct scrollHeight when allowing natively positioned children



// cache of CSS style objects
_styleCache:{},
// get the edge widths (border, margin, padding) for a CSS style
getStyleEdges : function (className) {
    
    if (isc.Browser.isSafari && !isc.Element._safariStrictChecked) {
        isc.Browser.isStrict = isc.Element._testForSafariStrictMode();
        isc.Element._safariStrictChecked = true;
    }
    

    if (className == null) return null;

    // check whether cache value is defined, so we can cache failed lookups as nulls
    var undef;
    if (this._styleCache[className] !== undef) return this._styleCache[className];

    //this.logWarn("style lookup: " + className + this.getStackTrace());

    
    var cantDeriveStyles = (isc.Browser.isMoz && isc.Browser.geckoVersion < 20040616),
        styleInfo;
    
    if (cantDeriveStyles) {
        styleInfo = this.getStyleDeclaration(className);
    } else {
        
        var mask = isc.Browser.isIE ? this._styleEdgeMaskArray : this._styleEdgeMask;
        styleInfo = this._deriveStyleProperties(className, mask);
    }

    
    this._styleCache[className] = styleInfo;
    return styleInfo;
},

// In Safari, document.compatMode is not available, so we rely on the fact that 
// table cells render their padding outside their specified height in strict mode but not in
// normal compat mode to determine whether we're currently in strict mode
_testForSafariStrictMode : function () {
    if (document.compatMode != null) {
        
        return document.compatMode == "CSS1Compat";
    }
    
    var tableHTML = "<TABLE cellspacing=0 cellpadding=2 border=0><tr><td height=30>x</td></tr></TABLE>"
    
    var tester = isc.Element.createAbsoluteElement(tableHTML);
    
    var isStrict = tester.offsetHeight > 30;
    isc.Element.clear(tester);
    
    return isStrict;
},
  
// get certain key properties of a style by applying it to an element and inspecting that
// element.  Edge-related properties are reliably derivable this way, cssText is known not
// available, other properties would need testing.

_deriveStyleProperties : function (className, mask) {
    
    var requiresDivTester = (isc.Browser.isIE || isc.Browser.isOpera || isc.Browser.isSafari
                                || (isc.Browser.isMoz && isc.Browser.geckoVersion >=20080205));
    if (!this._cellStyleTester) {
        
        this.createAbsoluteElement(
            "<TABLE CELLPADDING=81 STYLE='position:absolute;left:0px;top:-300px;'><TR><TD " +
            
            //(isc.Browser.isSafari ? "style='position:absolute;left:0px;top:0px;' " : "") +
            (isc.Browser.isIE8Strict ? 
            " ID=isc_cellStyleTester STYLE='border:0px;margin:0px'><DIV ID=isc_cellInnerStyleTester>" +
                isc.Canvas.blankImgHTML(30,30) + "</DIV></TD></TR></TABLE>"                
            :
            " ID=isc_cellStyleTester>&nbsp;</TD></TR></TABLE>") 
        );
        this._cellStyleTester = isc.Element.get("isc_cellStyleTester");
        if (isc.Browser.isIE8Strict) {
            this._cellInnerStyleTester = isc.Element.get("isc_cellInnerStyleTester");
        }
        this._$81px = "81px";                                 
        this._$16384px = "-16384px";       

        if (requiresDivTester) {
            this.createAbsoluteElement(
                "<DIV ID=isc_styleTester STYLE='position:absolute;left:0px;top:-100px;'>&nbsp;</DIV>"
            );
            this._styleTester = isc.Element.get("isc_styleTester");
            this._marginMask = ["marginLeft", "marginTop", "marginRight", "marginBottom"];
            if (isc.Browser.isIE8Strict) {
                this._marginMask.addList(["borderLeftWidth", "borderTopWidth", 
                                          "borderRightWidth", "borderBottomWidth"]);
            }
        }
    }
        
    this._cellStyleTester.className = className;
    var style = this.getComputedStyle(this._cellStyleTester, mask);

    //this.logWarn(className + " style is: " + this.echo(style));

    // test for unset padding 
    var nullIndicator = this._$81px;
    if (style.paddingLeft == nullIndicator) style.paddingLeft = null;
    if (style.paddingTop == nullIndicator) style.paddingTop = null;
    if (style.paddingRight == nullIndicator) style.paddingRight = null;
    if (style.paddingBottom == nullIndicator) style.paddingBottom = null;

    if (isc.Browser.isIE8Strict) {
        var innerTester = this._cellInnerStyleTester,
            offsetLeft = innerTester.offsetLeft,
            offsetTop = innerTester.offsetTop;
        
        if (offsetLeft == 81) style.paddingLeft = null;
        if (offsetTop == 81) style.paddingTop = null;
        if (this._cellStyleTester.offsetWidth - offsetLeft - 30 == 81) {
            style.paddingRight = null;
        }
        if (this._cellStyleTester.offsetHeight - offsetTop - 30 == 81) {
            style.paddingBottom = null;
        }
    }

    if (isc.Browser.isSafari) {
        // older Safari versions report unset padding as "auto" instead of reporting the
        // cellPadding
        if (isc.Browser.safariVersion < 419.3) {
            nullIndicator = isc.Canvas.AUTO;
            if (style.paddingLeft == nullIndicator) style.paddingLeft = null;
            if (style.paddingTop == nullIndicator) style.paddingTop = null;
            if (style.paddingRight == nullIndicator) style.paddingRight = null;
            if (style.paddingBottom == nullIndicator) style.paddingBottom = null;
        }

        // serious bug introduced in Safari 419.3 / 2.0.4, aka Tiger update 10.4.7: unset
        // marginTop/Bottom on cells reported as "-16384px".  Chimp factor 9.89
        nullIndicator = this._$16384px;        
        if (style.marginTop == nullIndicator) style.marginTop = null;
        if (style.marginBottom == nullIndicator) style.marginBottom = null;
    }


    
    if (requiresDivTester) {
        this._styleTester.className = className;
        var results = this.getComputedStyle(this._styleTester, this._marginMask);
        style.marginLeft = results.marginLeft;
        style.marginRight = results.marginRight;
        style.marginTop = results.marginTop;
        style.marginBottom = results.marginBottom;
        if (isc.Browser.isIE8Strict) {
            style.borderLeftWidth = results.borderLeftWidth;
            style.borderRightWidth = results.borderRightWidth;
            style.borderTopWidth = results.borderTopWidth;
            style.borderBottomWidth = results.borderBottomWidth;
        }
    }
    return style;

},

//> @classMethod Element.getComputedStyle()
//  Returns an object containing the current (computed) style for a DOM element.  This object 
//  includes all the attributes set directly on the element's style property, and those inherited
//  from the element's CSS class.
//  @param  ID  (string | object)   element, or ID of the element
//  @param  mask    (array)         list of propertyNames to include in the returned object
//  @return (object)    object containing computed style attributes.
//<
getComputedStyle : function (ID, mask) {
    
    var element, style, styleInfo;
    
    if (isc.isA.String(ID)) {
        element = isc.Element.get(ID);
    } else {
        // Otherwise just assume the DOM element was passed in directly
        element = ID;
    }

    if (element == null || !isc.isAn.Object(element)) {
        //>DEBUG
        this.logWarn("getComputedStyle: Unable to get to DOM element specified by '" + ID + "'." + this.getStackTrace());
        //<DEBUG
        return null;
    }
    
    if (isc.Browser.isIE || isc.Browser.isOpera) {
        
        style = element.currentStyle;
        // NOTE: use Array form of mask, faster with applyMask
        if (mask == null) mask = this._styleFullMaskArray;
        var results = isc.applyMask(style, mask);
        return results;
    } 

    // prepare a mask from camelCaps property to CSS dashed-property-name, because we want to
    // return camelCaps'd values but native getPropertyValue() uses dashed versions
    if (mask == null) { 
        // retrieve all properties
        mask = this._styleFullMask;
    } else if (isc.isAn.Array(mask)) {
        // if we have an explicit list of properties to retrieve, build a mask of camelCaps
        // name to CSS standard name (dash-separated) for just the desired properties.
        var obj = {},
            fullMask = this._styleFullMask;
        for (var i = 0; i < mask.length; i++) {
            obj[mask[i]] = fullMask[mask[i]];
        }
        mask = obj;
    }
    
    
    var safariPre13 = isc.Browser.isSafari && isc.Browser.safariVersion < 312,
        classStyleObject;
    if (safariPre13) {
        style = element.style;
        classStyleObject = this.getStyleDeclaration(element.className);
    } else {
        style = document.defaultView.getComputedStyle(element, null);
    }

    styleInfo = {};
    for (var property in mask) {
        styleInfo[property] = style.getPropertyValue(mask[property]);
            
        if (safariPre13 && styleInfo[property] == null && 
            classStyleObject != null && classStyleObject[property] != null && 
            !isc.isAn.emptyString(classStyleObject[property])) 
        { 
            
            styleInfo[property] = classStyleObject[property];
        }
    }
     
    //this.logWarn("styleInfo for style: " + className + " is: " + this.echo(styleInfo));
    return styleInfo;
    
},

// return an individual attribute from the computed style.  Quicker than getting the full set
// of properties if you need only one.

_$operaBorderStyles:{
    border:"borderStyle", 
    borderWidth:"borderStyle", 
    borderLeft:"borderLeftStyle", 
    borderRight:"borderRightStyle", 
    borderTop:"borderTopStyle", 
    borderBottom:"borderBottomStyle",
    borderLeftWidth:"borderLeftStyle", 
    borderRightWidth:"borderRightStyle", 
    borderBottomWidth:"borderBottomStyle", 
    borderTopWidth:"borderTopStyle"
},
getComputedStyleAttribute : function (element, property) {

    if (element == null || property == null) return null;
    
    // Use currentStyle for IE (easy!)
    if (isc.Browser.isIE || isc.Browser.isOpera) {

        // we've seen element.currentStyle be reported as null (not sure why)
        if (element.currentStyle == null) return null;
        // special opera logic for undefined borders returning 3
        if (isc.Browser.isOpera && this._$operaBorderStyles[property] != null &&
            element.currentStyle[this._$operaBorderStyles[property]] == this._$none) return 0;
        return element.currentStyle[property];
    }

    //>Safari
    if (isc.Browser.isSafari) {
        
        var propertyValue = null;
        if (element.style) propertyValue = element.style[property];
        if ((propertyValue == null || isc.isAn.emptyString(propertyValue)) &&
            element.className)
        {
            var styleDecl = isc.Element.getStyleEdges(element.className);
            if (styleDecl) propertyValue = styleDecl[property];
        }
        if (isc.isAn.emptyString(propertyValue)) return null;
        return propertyValue;            
    } //<Safari
    
    // DOM and not broken (eg Moz).  Convert camelCaps to the CSS property name (only works for
    // a specific list of props)
    var mask = this._styleFullMask;
        
    var docView = this._docView = this._docView || document.defaultView;

    var cssProperty = (mask[property] || property),
        // get the style object for the element
        style = docView.getComputedStyle(element, null);
        
       
    return style.getPropertyValue(cssProperty);
},



// look up a style declaration via document.stylesheets

getStyleDeclaration : function (className, checkMultiples) {

    if (!className) return null;

    
    if (!isc.allowDuplicateStyles) checkMultiples = false;
    
    
    if (isc.Browser.isSafari && isc.Browser.safariVersion >= 312) {
        className = className.toLowerCase();
    }
    
    var selector = "." + className,
        commaSpace = ", ";

    // Check the array of style rules from any styleSheets 
    // - This will include <STYLE> tags in the doc
    // - Start with the most recently loaded
    var styleObj, styleObjs = checkMultiples ? [] : null;
    for (var i = document.styleSheets.length - 1; i >= 0; i--) {
        var rules = this._getCSSRules(document.styleSheets[i]);
            
        
        if (rules == null) continue; // stylesheet inaccessible

        // iterate backward through style declarations, since last wins
        for (var j = rules.length - 1; j >= 0; j--) {
        
            
            

            
            var selectorText = rules[j].selectorText;

            // @import css tags result in entires with no 'selectorText' property.            
            if (selectorText == null) continue;

            if (isc.Browser.isMoz) {
                var selectorTextArray = selectorText.split(commaSpace);
                
                for (var k = 0; k < selectorTextArray.length; k++) {
                    if (selectorTextArray[k] == selector) {
                        styleObj = rules[j].style;
                        if (styleObj != null) {
                            if (checkMultiples) styleObjs[styleObjs.length] = styleObj;
                            else return styleObj;
                        }
                    }
                }
            } else {
            
                if (selectorText == selector) {
                    styleObj = rules[j].style;
                    if (styleObj != null) {
                        if (checkMultiples) styleObjs[styleObjs.length] = styleObj;
                        else return styleObj;
                    }
                }
            }   
        }
    }
    if (checkMultiples && styleObjs.length > 0) return styleObjs;
    return null;
},

// retrieve the css rules property from a stylesheet definition
_getCSSRules : function (styleSheet) {
    
    if (!this._fetchStyle) {

        // "cssRules" in Moz, "rules" in IE.
        // NOTE: use of "_sheet" instead of "sheet" allows private identifier obfuscation
        var functionString = "try{return _sheet.rules||_sheet.cssRules}" + 
                             "catch(e){isc.Page._remoteStyleSheet = true;}";

        this._fetchStyle = new Function("_sheet", functionString);
	
    }
    return this._fetchStyle(styleSheet);
},


                 


//>	@classMethod Element.getStyleText()	([A])
// Gets the raw CSS style text associated with a CSS className. For example, if you have
// defined the following class:<br><br>
// <code>.cellSelected {font-family:Verdana; font-size:10px; background-color:#FFFF99;<br>
// border-top:1px solid #FFFF99;<br>
// border-bottom:1px solid #FFFF99;<br>
// }</code><br><br>
// Then calling getStyleText("cellSelected") will return:<br><br>
// <code>font-family:Verdana; font-size:10px; background-color:#FFFF99;<br>
// border-top:1px solid #FFFF99; border-bottom:1px solid #FFFF99;</code>
//		@group	drawing
//
//      @param  className   (string)       The CSS ClassName for which you wish to get the style
//      @param  [checkMultiples]    (boolean)   If specified this will ensure we check for 
//                                          multiple definitions of the same className and pick
//                                          up cssText from each definition. False by default.
//                                          No effect if isc.allowDuplicateStyles is false.
//      @return (string)       The cssText property of this CSS style rule
//<
_cssTextCache:{},
_$semi:";",
getStyleText : function (className, checkMultiples) {

    
    if (!isc.allowDuplicateStyles) checkMultiples = false;
    

    
    
    // check cache.
    
    var cache = this._cssTextCache,
        cssText = cache[className];
    if (cssText != null) return cssText;

    var style = this.getStyleDeclaration(className, checkMultiples); 
    
    // if we didn't find anything, return the empty string (rather than null)
    if (style == null) {
        
        if (!isc.Browser.isSafari || isc.Page.isLoaded()) 
            this._cssTextCache[className] = isc.emptyString;
        return isc.emptyString;
    }

    // "style" will be an array if we checked multiple styles
    
    
    if (checkMultiples) {
        for (var i = style.length-1; i >-1; i--) {        
            var actualStyle = style[i];
            var currentCssText = actualStyle.cssText;
            if (currentCssText == null) continue;
            if (!currentCssText.endsWith(this._$semi)) currentCssText += this._$semi;
            if (cssText == null) cssText = currentCssText;
            else cssText += currentCssText;
        }
        if (cssText == null) cssText = isc._emptyString;
    } else {
        cssText = (style.cssText || isc._emptyString);
    }
        
    // ensure it ends with a semicolon so it can be appended to
    if (!isc.endsWith(cssText, isc.semi)) cssText += isc.semi;
    // cache it and return it
    
    return (cache[className] = cssText);
},


// wipe out any cached CSS information
// helper for Canvas._clearCSSCaches
_clearCSSCaches : function () {
    //isc.Log.logWarn("styleCache is: " + isc.Comm.serialize(isc.Element._styleCache, true));

    // wipe out the central style definition caches
    isc.Element._styleCache = {};
    isc.Element._cssTextCache = {};

    // wipe out central edge size caches
    isc.Element._borderSizeCache = isc.Element._marginsCache = 
        isc.Element._padSizeCache = null;
},

// Border, Padding and Margin on css classes
// --------------------------------------------------------------------------------------------
// We provide the static Element class methods to handle getting border and padding 
// thicknesses on each side ('getTopBorderSize()', 'getBottomBorderSize()', 'getTopPadding()',
// etc.) for css classes from their classNames.





//>	@classMethod	Element._getTopMargin()
// Get the size of the top margin for the style passed in.
//
//  @param  className   (string)    className to test for margin size
//  @return             (number)    size of top margin in pixels
//<
_getTopMargin : function (className) {
    return this._calculateMargins(className).top;
},

//>	@classMethod	Element._getBottomMargin()
// Get the size of the bottom margin for the style passed in.
//
//  @param  className   (string)    className to test for margin
//  @return             (number)    size of bottom margin in pixels
//<
_getBottomMargin : function (className) {
    return this._calculateMargins(className).bottom;
},

//>	@classMethod	Element._getLeftMargin()
// Get the size of the left margin for the style passed in.
//
//  @param  className   (string)    className to test for margin size
//  @return             (number)    size of left margin in pixels
//<
_getLeftMargin : function (className) {
    return this._calculateMargins(className).left;
},

//>	@classMethod	Element._getRightMargin()
// Get the size of the right margin for the style passed in.
//
//  @param  className   (string)    className to test for margin size
//  @return             (number)    size of right margin in pixels
//<
_getRightMargin : function (className) {
    return this._calculateMargins(className).right;
},

//>	@classMethod	Element._calculateMargins()
// Calculate the sizes of the margins on each side for the css class passed in.
//
//  @param  className   (string)    className to test for margin sizes
//  @return             (object)    Object with 'left', 'right', 'top', 'bottom' defined as the 
//                                  sizes of the margin on each side
//<
_calculateMargins : function (className) {

    if (this._marginsCache == null) this._marginsCache = {};
    else if (this._marginsCache[className] != null) {
        return this._marginsCache[className];
    }        
    var margins = {top:0, bottom:0, left:0, right:0},
        styleObject = isc.Element.getStyleEdges(className);

    if (styleObject == null) return margins;
    
    var topMarginString = styleObject.marginTop,
        bottomMarginString = styleObject.marginBottom,
        leftMarginString = styleObject.marginLeft,
        rightMarginString = styleObject.marginRight,
        pxString = isc.px;
    if (isc.isA.String(topMarginString) && topMarginString.endsWith(pxString)) 
        margins.top = parseInt(topMarginString);

    if (isc.isA.String(bottomMarginString) && bottomMarginString.endsWith(pxString)) 
        margins.bottom = parseInt(bottomMarginString);
        
    if (isc.isA.String(leftMarginString) && leftMarginString.endsWith(pxString)) 
        margins.left = parseInt(leftMarginString);
        
    if (isc.isA.String(rightMarginString) && rightMarginString.endsWith(pxString)) 
        margins.right = parseInt(rightMarginString);
        
    this._marginsCache[className] = margins;        

    return margins;

},

//>	@classMethod	Element._getTopBorderSize()
// Get the size of the top border for the style passed in.
//
//  @param  className   (string)    className to test for border size
//  @return             (number)    size of top border in pixels
//<
_getTopBorderSize : function (className) {
    return this._calculateBorderSize(className).top;
},

//>	@classMethod	Element._getBottomBorderSize()
// Get the size of the bottom border for the style passed in.
//
//  @param  className   (string)    className to test for border size
//  @return             (number)    size of bottom border in pixels
//<
_getBottomBorderSize : function (className) {
    return this._calculateBorderSize(className).bottom;
},

//>	@classMethod	Element._getLeftBorderSize()
// Get the size of the left border for the style passed in.
//
//  @param  className   (string)    className to test for border size
//  @return             (number)    size of left border in pixels
//<
_getLeftBorderSize : function (className) {
    return this._calculateBorderSize(className).left;
},

//>	@classMethod	Element._getRightBorderSize()
// Get the size of the right border for the style passed in.
//
//  @param  className   (string)    className to test for border size
//  @return             (number)    size of right border in pixels
//<
_getRightBorderSize : function (className) {
    return this._calculateBorderSize(className).right;
},

//>	@classMethod	Element._calculateBorderSize()
// Calculate the sizes of the borders on each side for the css class passed in.
//
//  @param  className   (string)    className to test for border sizes
//  @return             (object)    Object with 'left', 'right', 'top', 'bottom' defined as the 
//                                  sizes of the border on each side
//<
_calculateBorderSize : function (className) {

    if (this._borderSizeCache == null) this._borderSizeCache = {};
    else if (this._borderSizeCache[className] != null) {
        return this._borderSizeCache[className];
    }        

    var borderSize = {top:0, bottom:0, left:0, right:0},
        styleObject = isc.Element.getStyleEdges(className);

    if (styleObject == null) return borderSize;
    
    var topBorderString = styleObject.borderTopWidth,
        bottomBorderString = styleObject.borderBottomWidth,
        leftBorderString = styleObject.borderLeftWidth,
        rightBorderString = styleObject.borderRightWidth,
        pxString = isc.px;
        
    if (isc.isA.String(topBorderString) && topBorderString.endsWith(pxString)) 
        borderSize.top = parseInt(topBorderString);

    if (isc.isA.String(bottomBorderString) && bottomBorderString.endsWith(pxString)) 
        borderSize.bottom = parseInt(bottomBorderString);
        
    if (isc.isA.String(leftBorderString) && leftBorderString.endsWith(pxString)) 
        borderSize.left = parseInt(leftBorderString);
        
    if (isc.isA.String(rightBorderString) && rightBorderString.endsWith(pxString)) 
        borderSize.right = parseInt(rightBorderString);
    
    this._borderSizeCache[className] = borderSize;        

    return borderSize;

},

//>	@classMethod	Element._getVBorderSize()
// Get the total vertical border size for the style passed in. (Top border size + bottom border size)
//
//  @param  className   (string)    className to test for padding size
//  @return             (number)    total size of vertical (top and bottom) borders in pixels
//<
_getVBorderSize : function (className) {
    return this._getTopBorderSize(className) + this._getBottomBorderSize(className);
},

//>	@classMethod	Element._getHBorderSize()
// Get the total horizontal border size for the style passed in. 
// (Left border size + Right border size)
//
//  @param  className   (string)    className to test for padding size
//  @return             (number)    total size of horizontal (left and right) borders in pixels
//<
_getHBorderSize : function (className) {
    return this._getLeftBorderSize(className) + this._getRightBorderSize(className);
},

//>	@classMethod	Element._getTopPadding()
// Get the size of the top padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @param  [explicit]  (boolean)   If no passed, when no padding was specified, return null
//                                  rather than true.
//  @return             (number)    size of top padding in pixels
//<
_getTopPadding : function (className, explicit) {
    var padding = this._calculatePadding(className);
    if (explicit && padding.nullTop) return null;
    return padding.top;
},

//>	@classMethod	Element._getBottomPadding()
// Get the size of the bottom padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @param  [explicit]  (boolean)   If passed, when no padding was specified, return null
//                                  rather than true.
//  @return             (number)    size of bottom padding in pixels
//<
_getBottomPadding : function (className, explicit) {
    var padding = this._calculatePadding(className);
    if (explicit && padding.nullBottom) return null;
    return padding.bottom;
},

//>	@classMethod	Element._getLeftPadding()
// Get the size of the left padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @param  [explicit]  (boolean)   If passed, when no padding was specified, return null
//                                  rather than true.
//  @return             (number)    size of left padding in pixels
//<
_getLeftPadding : function (className, explicit) {
    var padding = this._calculatePadding(className);
    if (explicit && padding.nullLeft) return null;
    return padding.left;
},

//>	@classMethod	Element._getRightPadding()
// Get the size of the right padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @param  [explicit]  (boolean)   If passed, when no padding was specified, return null
//                                  rather than true.
//  @return             (number)    size of right padding in pixels
//<
_getRightPadding : function (className, explicit) {
    var padding = this._calculatePadding(className);
    if (explicit && padding.nullRight) return null;
    return padding.right;
},

//>	@classMethod	Element._calculatePadding()
// Calculate the sizes of the padding on each side for the css class passed in.
//
//  @param  className   (string)    className to test for padding sizes
//  @return             (object)    Object with 'left', 'right', 'top', 'bottom' defined as the 
//                                  sizes of the padding on each side
//<
_calculatePadding : function (className) {
    if (this._padSizeCache == null) this._padSizeCache = {};
    else if (this._padSizeCache[className] != null) {
        return this._padSizeCache[className];
    }

    var padSize = {top:0, bottom:0, left:0, right:0},
        styleObject = isc.Element.getStyleEdges(className);
        
    if (styleObject == null) {
        padSize.nullLeft = true; padSize.nullRight = true;
        padSize.nullTop = true; padSize.nullBottom = true;
        return padSize;
    }
    
    var topPadding = styleObject.paddingTop,
        bottomPadding = styleObject.paddingBottom,
        leftPadding = styleObject.paddingLeft,
        rightPadding = styleObject.paddingRight,
        pxString = isc.px;

    // In some cases we will want to know whether a style contains specified padding *at all*,
    // as opposed to explicit zero.
    padSize.nullTop = (topPadding == null || topPadding == isc.emptyString);
    padSize.nullBottom = (bottomPadding == null || bottomPadding == isc.emptyString)
    padSize.nullLeft = (leftPadding == null || leftPadding == isc.emptyString);
    padSize.nullRight = (rightPadding == null || rightPadding == isc.emptyString);
        
    if (isc.isA.String(topPadding) && topPadding.endsWith(pxString)) 
        padSize.top = parseInt(topPadding);

    if (isc.isA.String(bottomPadding) && bottomPadding.endsWith(pxString)) 
        padSize.bottom = parseInt(bottomPadding);
        
    if (isc.isA.String(leftPadding) && leftPadding.endsWith(pxString)) 
        padSize.left = parseInt(leftPadding);
        
    if (isc.isA.String(rightPadding) && rightPadding.endsWith(pxString)) 
        padSize.right = parseInt(rightPadding);

    this._padSizeCache[className] = padSize;

    return padSize;
    
},

//>	@classMethod	Element._getVPadding()
// Get the total size of the vertical padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @return             (number)    size of vertical padding in pixels
//<
_getVPadding : function (className) {
    return this._getTopPadding(className) + this._getBottomPadding(className);
},

//>	@classMethod	Element._getHPadding()
// Get the total size of the horizontal padding for the style passed in.
//
//  @param  className   (string)    className to test for padding size
//  @return             (number)    size of horizontal padding in pixels
//<
_getHPadding : function (className) {
    return this._getLeftPadding(className) + this._getRightPadding(className);
},

//>	@classMethod	Element._getVBorderPad()
// Get the total size of the padding and border for this style, for the vertical axis.
//
//  @param  className   (string)    className to test for VBorderPad
//  @return             (number)    size of VBorderPad in pixels
//<
_getVBorderPad : function (className) {
    return this._getVBorderSize(className) + this._getVPadding(className);
},

//>	@classMethod	Element._getHBorderPad()
// Get the total size of the padding and border for this style, for the horizontal axis.
//
//  @param  className   (string)    className to test for HBorderPad
//  @return             (number)    size of HBorderPad in pixels
//<
_getHBorderPad : function (className) {
    return this._getHBorderSize(className) + this._getHPadding(className);
},


// ----------------------

// getNativeScrollbarSize()
// 
// If the browser is showing native scrollbars, we have no way of knowing their thickness by
// default. This can be set at the OS level (via the Control Panel in windows), and the 
// defaults vary based on which OS is being used.
// This method determines the size of the scrollbars by writing a DIV into the DOM and 
// examining it

getNativeScrollbarSize : function () {
    if (isc.Element._nativeScrollbarSize == null) {
        var elementHTML = "<div id=isc_ScrollbarTest " 
                            + "style='position:absolute;top:-100px;border:0px;padding:0px;margin:0px;height:100px;width:100px;overflow:scroll;'>"
                            + isc.nbsp // XHTML
                            + "</div>";
        this.createAbsoluteElement(elementHTML);
        var sbTest = this.get('isc_ScrollbarTest');
        isc.Element._nativeScrollbarSize = parseInt(sbTest.style.height) - sbTest.clientHeight;

        // At this point we've determined the scrollbar size, and can clear the test div out 
        // from the DOM
        this.clear(sbTest);
    }
    
    return isc.Element._nativeScrollbarSize;
}

});

isc.Element._ElementInit = function () {

    var edgeMask = this._styleEdgeMask = {
            
            borderLeftWidth:"border-left-width", 
            borderRightWidth:"border-right-width", 
            borderTopWidth:"border-top-width", 
            borderBottomWidth:"border-bottom-width",
            marginLeft:"margin-left",
            marginRight:"margin-right",
            marginTop:"margin-top",
            marginBottom:"margin-bottom",

            
            paddingLeft:"padding-left", 
            paddingRight:"padding-right",
            paddingTop:"padding-top", 
            paddingBottom:"padding-bottom"
    }

    var fullMask = this._styleFullMask = isc.addProperties({
            position:"position", 
            overflow:"overflow",
            top:"top",
            left:"left",
            width:"width",
            height:"height",
            
            // display - block vs. inline (etc.)
            display:"display"
    }, edgeMask);

    if (isc.Browser.isIE || isc.Browser.isOpera) {
        this._styleFullMaskArray = isc.getKeys(fullMask);
        this._styleEdgeMaskArray = isc.getKeys(edgeMask);
    }
}
isc.Element._ElementInit();

