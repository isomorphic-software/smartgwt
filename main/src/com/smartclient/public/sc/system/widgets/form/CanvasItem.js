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

 




//> @class CanvasItem
// Form item which renders a Canvas inline in a DynamicForm instance.
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
//<
isc.ClassFactory.defineClass("CanvasItem", "FormItem");
isc.CanvasItem.addProperties({
    width:"*", height:null,

    shouldSaveValue:false,

    // ------------------------
    // Methods applied directly to this.canvas (fired in the scope of the canvas, not the
    // canvasItem-  use this.canvasItem to point back to the item).
    
    // set up observation of resizing
    
    _canvas_resized : function (deltaX, deltaY, reason) {
        if (this.Super("resized", arguments) == false) return;
        // CanvasResized will cause a form redraw - only call this if we're not drag
        // resizing to avoid redrawing repeatedly during drag resize interactions.
        if (!this.dragResizing()) {
            this.canvasItem.canvasResized(deltaX, deltaY, reason);
        }
    },
    _canvas_dragResized : function () {
        this.canvasItem.canvasResized(1,1); // HACK: 
        return this.Super("dragResized", arguments);
    },
    
    _canvas_focusInNextTabElement : function (forward, mask) {
        return this.canvasItem.form._focusInNextTabElement(forward, mask);
    }
    
    
  	//> @attr	canvasItem.canvas		(Canvas : null : [IRW])
    //
    // The canvas that will be displayed inside this item.  You can pass an instance you've 
    // already created, or its global ID as a String.  If none is passed, one will be 
    // auto-created using the overrideable defaults: +link{attr:CanvasItem.canvasProperties} and
    // +link{attr:CanvasItem.canvasConstructor}
    //
    //  @visibility external
	//<

  	//> @attr	canvasItem.canvasConstructor		(String : "Canvas" : [IRW])
    //
    // If +link{canvasItem.canvas, this.canvas} is not specified as a canvas instance at init
    // time, a canvas will be created instead. This property denotes the class of that widget
    // (Should be set to the name of a subclass of Canvas).
    //
    //  @visibility external
	//<
    
    
    
    //> @attr	canvasItem.canvasDefaults		(Object : {} : [IRW])
    //
    // Default properties for the canvas if this.canvas is not already a canvas instance.
    //
    //  @visibility external
	//<
    
    //> @attr	canvasItem.canvasProperties		(Object : {} : [IRW])
    //
    // Properties to apply to this canvas on creation if this.canvas is not already a canvas 
    // instance.
    //
    //  @visibility external
	//<
    

    // whether to destroy our Canvas when we are destroyed.  Appropriate for most CanvasItems
    // that auto-create a Canvas.
    //
    
    //autoDestroy: false

    //showTitle:false
});
isc.CanvasItem.addMethods({
    init : function () {
        this.Super("init", arguments);
        this._createCanvas();
    },
    
    // A straight canvasItem is non-editable. Subclasses that allow editing (such as the sliderItem)
    // will override this method to return true
    isEditable : function () {
        return false;
    },
    
    // _createCanvas    Method to ensure that the canvas for this item has been instantiated
    // with appropriate properties, and added to the containerWidget as a child.
    _createCanvas : function () {

        //>DEBUG
        if (!isc.isAn.Object(this.canvas) && !this.canvasProperties) {
            this.logWarn("CanvasItem: " + 
                        (this.getFieldName() ? this.getFieldName() : this.getID()) + 
                        " defined with no canvas property - creating a default " +
                        "canvas for this item.");
        }
        //<DEBUG

        var canvasProps = {
            // don't redraw when the form redraws - if the developer wishes to redraw this canvas
            // they will have to call redraw() on this form item, or on the Canvas directly.
            _redrawWithParent: false,
            // one time flag to suppress automatic drawing on addChild().  Very key, as a form
            // that has setItems() called on it after creation recreates all items with the
            // form already drawn.
            _dontDrawOnAddChild: true,
            
            // Always set initial tabIndex to -1. This will avoid the canvas from ever getting
            // an auto-assigned tab index and having a prev/next tab-widget.
            // Note that as part of 'setElementTabIndex()' we will explicitly assign the
            // desired tabIndex.
            tabIndex:-1,
            
            //hideUsingDisplayNone:true,

            // Hang a pointer on the canvas back to this form item.
            canvasItem: this,
            disabled: this.isDisabled()
        };
        canvasProps.resized = this._canvas_resized;
        canvasProps.dragResized = this._canvas_dragResized;
        
        
        // Override synthetic focus manipulation methods to fall back to the DF, since that
        // already manages moving focus between form items on tab / shift tab keypress when
        // the clickMask is up 
        canvasProps._focusInNextTabElement = this._canvas_focusInNextTabElement;

        // pass our datasource, if any to the CanvasItem
        if (this.dataSource) canvasProps.dataSource = this.dataSource;
        // pass on our prompt (if any) to the CanvasItem
        if (this.prompt) canvasProps.prompt = this.prompt;
        
        // We'll set the tabIndex on the canvas when we write out our innerHTML.
        
        
        // pass on our accessKey if appropriate
        if (this.accessKey != null) canvasProps.accessKey = this.accessKey;
        
        // pass on 'showFocused'
        if (this.showFocused != null) canvasProps.showFocused = this.showFocused;
        if (this.showFocusedAsOver != null) canvasProps.showFocusedAsOver = this.showFocusedAsOver;
        
        if (isc.isA.String(this.canvas) && window[this.canvas]) this.canvas = window[this.canvas];
        
        // if the canvas hasn't been instantiated for us, use the autoChild method to create it
        // otherwise we have to do a bunch of manual patching to achieve the same effect.
        if (!isc.isA.Canvas(this.canvas)) {
            // pick up any properties specified directly on the 'this.canvas' object
            isc.addProperties(canvasProps, this.canvas);        
            if (canvasProps.ID == null) canvasProps.ID = null;
            // since we're auto-creating it's appropriate to autoDestroy
            this.autoDestroy = true;
            
            this.addAutoChild("canvas", canvasProps, isc.Canvas, this.containerWidget);
        } else {
            // apply dynamic properties to existing canvas
            // (Call setter methods wherever necessary).
            this.canvas.setTabIndex(-1);
            this.canvas.setPrompt(this.prompt);
            this.canvas.setAccessKey(this.accessKey);
            
            isc.addProperties(this.canvas, canvasProps);
            if (canvasProps.dataSource) this.canvas.bindToDataSource();
            this.canvas.setDisabled(this.isDisabled());
            this.containerWidget.addChild(this.canvas);
        }
    },
    
    
    /*
    // Ensure redraw on this item redraws the Canvas.
    redraw : function (suppressCanvasRedraw) {
        // redraw the canvas before redrawing our innerHTML - allows us to calculate sizes
        // accurately, if they change.
        if (!suppressCanvasRedraw && this.canvas.isDrawn()) {
            this.canvas.redraw("canvasItem.redraw");
        }
        this.Super("redraw", arguments);
    },
    */

    // clear the pointer on this item's canvas back to this item on destroy()
    destroy : function () {
        if (this.canvas) {
            delete this.canvas.canvasItem;
            if (this.autoDestroy) this.canvas.destroy(true);
            else if (this.canvas.visibility != isc.Canvas.HIDDEN) this.canvas.hide();
        }
        return this.Super("destroy", arguments);
    },
    
    placeCanvas : function (delayed) {
        var canvas = this.canvas;
        // show or hide the Canvas according to whether this item is visible, so that showIfs work
        if (this.visible == false) {
            canvas.hide();
            
            canvas.moveTo(0,0);
            return;
        }
 
        if (this.form && !this.form.isDrawn() && this.form.position == isc.Canvas.RELATIVE) {
            
            //this.logWarn("hiding Canvas during initial relative draw");
            canvas.hide();
            return;
        }

        // place the Canvas over the cell for the item

        // figure out the spacer's coordinates within the form
        var containerHandle = this.containerWidget.getClipHandle(),
            spacerParent = isc.Element.get(this.getID() + "_spacerParent"),
            left = isc.Element._getLeftOffsetFromElement(spacerParent, containerHandle),
            top = isc.Element._getTopOffsetFromElement(spacerParent, containerHandle);

        // this.logWarn("placing Canvas at: " + [left, top]);

        // place the Canvas on top of that cell
        canvas.moveTo(left, top);
        if (canvas.visibility == isc.Canvas.HIDDEN) {
            canvas.show();
        }
        

        
        if (!delayed && isc.Browser.isMac && isc.Browser.isMoz && left == 0 && top == 0) {
            isc.Timer.setTimeout({target:this, methodName:"_delayedPlaceCanvas"}, 0);
        }
    },
    
    _delayedPlaceCanvas : function () {
        this.placeCanvas(true);
    },
    
    cleared : function () {
        // when a canvasItem gets cleared, ensure the canvas is cleared too
        if (this.canvas && this.canvas.isDrawn()) this.canvas.clear();
    },
    
    // ensure the canvas floats in the right place if the item is moved
    moved : function () {
        if (this.isDrawn()) this.placeCanvas();
    },

    // Sizing
    // ---------------------------------------------------------------------------------------
    

    checkCanvasOverflow : function () {
        return this.sizeCanvas(true);
    },

    sizeCanvas : function (firstResizePass) {
        var canvas = this.canvas;

        // if we can't overflow in the height direction, we don't need to do anything on the
        // first sizing pass
        if (firstResizePass && 
            !(canvas.overflow == isc.Canvas.VISIBLE || canvas.overflow == isc.Canvas.CLIP_H))
        {
            this.logDebug("ignoring first pass, can't overflow", "canvasItemSizing");
            return;
        }

        // get the sizes specified by layout policy
        var policyWidth = this.getInnerWidth(),
            policyHeight = this.getInnerHeight(),
            resizeWidth, resizeHeight;

        // we feed the specified height (whether it appears on the Canvas or CanvasItem) to 
        // TableResizePolicy; if we give it a pixel size it will feed that back.  If we give it
        // a variable size (percent or "*"), that size will be incorporated into sizing the row
        // as a whole and we'll get the row height back.
        resizeHeight = policyHeight;

        // TableResizePolicy doesn't consider the specified width of items when determining
        // column widths.  Hence only apply the width if our width is unset or "*"
        var specifiedWidth = canvas._userWidth || this.width;
        resizeWidth = (specifiedWidth == null || specifiedWidth == "*" ? 
                       policyWidth : specifiedWidth);

        // if width is not increasing past the current overflowed size, don't try to reduce the
        // height of an height-overflowed Canvas to less than the overflowed size, because 
        // there's no reason to expect it to shrink (unless it's dirty, in which case we assume
        // it might change size)
        if (!canvas.isDirty() &&
            (resizeWidth == null || resizeWidth <= canvas.getVisibleWidth()) &&
            canvas.getHeight() < canvas.getVisibleHeight() && 
            resizeHeight <= canvas.getVisibleHeight()) 
        {
            this.logDebug("not applying height: " + resizeHeight + 
                          " to overflowed Canvas with height: " + canvas.getVisibleHeight(),
                          "canvasItemSizing");
            resizeHeight = null;
        }

        if (!isc.isA.Number(resizeWidth)) resizeWidth = null;
        if (!isc.isA.Number(resizeHeight)) resizeHeight = null;
        
        // actually call 'resizeTo' on the canvas
        this._setCanvasSize(resizeWidth,resizeHeight);

        this.logDebug("this._size: " + this._size + 
                      ", policy size: " + [policyWidth, policyHeight] +
                      ", specifiedSize: " + [specifiedWidth, canvas._userHeight || this.height] +
                      ", Resized Canvas to: " + [resizeWidth, resizeHeight],
                      "canvasItemSizing");

        // draw or redraw the Canvas so we get an accurate size
        if (!canvas.isDrawn()) {
            // skip the case where the containerWidget is undrawn (for example getting PrintHMTL of
            // an undrawn form)
            var containerDrawnState = this.containerWidget.getDrawnState();
            
            if (containerDrawnState == isc.Canvas.COMPLETE || 
                containerDrawnState == isc.Canvas.HANDLE_DRAWN) {
                    canvas.draw();
            }
            
        } else canvas.redrawIfDirty("CanvasItem getting new size");
            
        var width = canvas.getVisibleWidth(),
            height = canvas.getVisibleHeight();

        this.logDebug("visible size of embedded Canvas: " + [width, height], 
                      "canvasItemSizing");
        
        // if the Canvas overflows in the height direction, set this as a minimum
        
        if (!firstResizePass) this.minHeight = null;
        else this.minHeight = height > canvas.getHeight() ? height : null;

        // policyHeight is the space allocated to the row(s) this Canvas spans.  If we've
        // exceeded the space that table sizing policy allocated to our row(s), the policy will
        // need to be rerun, in order to reallocate space among other items that can flex.
        // Note: doesn't matter if we've exceeded width; our width isn't taken into account by
        // the policy.
        // Note: doesn't matter whether the Canvas has actually overflowed it's own specified
        // size, which might be much smaller; eg a button next to a TextArea doesn't need to be
        // as tall as the TextArea.
        if (height > policyHeight) return true;
    },
    
    _setCanvasSize : function (resizeWidth, resizeHeight) {
        this._resizingCanvas = true;
        this.canvas.resizeTo(resizeWidth, resizeHeight);
        this._resizingCanvas = false;
    },
    
    // Rather than embedding HTML for the canvas into the form, we write out a spacer of the
    // appropriate size, and float the Canvas over it.
    getElementHTML : function (value) {
        var canvas = this.canvas;
        
        // Exception: If we're printing, write the printHTML for our canvasItem directly into
        // the item
        if (canvas && this.containerWidget.isPrinting) {
            
            return canvas.getPrintHTML(this.containerWidget.currentPrintProperties);
        }

        // size the Canvas to the final size determined by the resize policy
        this.sizeCanvas();
        
        // Ensure that the canvas has it's tab index written out as tspecified
        this._setElementTabIndex(this.getGlobalTabIndex());

        
        return "<SPAN style='padding:0px;margin:0px;' ID='" + this.getID() + "_spacerParent'>" 
                + isc.Canvas.spacerHTML(canvas.getVisibleWidth(), canvas.getVisibleHeight()) 
                + "</SPAN>";
    },
    
    
    _applyHandlersToElement : function () {
        this._setUpIconEventHandlers();
    },
        
    
    // return specified widths (which can be %s or *s), whether they appear on the Canvas or
    // CanvasItem, to be fed to the table resize policy.  If there is no specified size, feed
    // the layout policy our default height.
    getHeight : function (reportOverflowedSize) {
        var canvas = this.canvas;
        if (reportOverflowedSize) {
            var visibleHeight = canvas.getVisibleHeight();
            if (visibleHeight > canvas.getHeight()) return visibleHeight;
        }
        return this.canvas._userHeight || this.height || this.canvas.defaultHeight;
    },

    getWidth : function () {
        return this.canvas._userWidth || this.width || this.canvas.defaultWidth;
    },
    
    // if the Canvas is resized by the user or programmatically outside of CanvasItem's layout
    // code, 
    canvasResized : function (deltaX, deltaY, reason) {
        if (this._resizingCanvas) return;
        
        var canvas = this.canvas,
            newWidth = canvas.getWidth(),
            newHeight = canvas.getHeight();

        if (!canvas.isDrawn()) return;

        if (reason != "overflow") {
            if (deltaX != null && deltaX != 0) canvas._userWidth = newWidth;
            if (deltaY != null && deltaY != 0) canvas._userHeight = newHeight;
        }

        this.logDebug("canvas resized: new specified sizes: " + [newWidth, newHeight],
                      "canvasItemSizing");
        // redraw to change size
        this.redraw();
    },
    
    // override 'updateDisabled()' to disable the canvas
    updateDisabled : function () {
        this.Super("updateDisabled", arguments);
        this.canvas.setDisabled(this.isDisabled());
    },
    
    
    // Override _setElementTabIndex() to update the tabindex of the canvas (and avoid redrawing
    // the form)
    _setElementTabIndex : function (index) {
        this._setCanvasTabIndex(index);
    },
    
    _setCanvasTabIndex : function (index) {
        var canvas = this.canvas;
        if (canvas) {
            // clears any pointers to prev/next in auto-tab-order
            canvas._removeFromAutoTabOrder();
            // use the internal method so we don't hit the user-specified tabIndex ceiling
            canvas._setTabIndex(index, false);
        }
    },
    
    // Override focusInItem / blurFocusItem to actually put focus into the canvas
    
    focusInItem : function () {
        if (this.canvas) this.canvas.focus();
        return this.Super("focusInItem", arguments);
    },
    
    blurItem : function () {
        if (this.canvas) this.canvas.blur();
        return this.Super("blurItem", arguments);
    }
    
    

});

