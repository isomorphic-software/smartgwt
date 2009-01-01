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





//>	@class	TileLayout
// Lays out a series of components, calls "tiles", in a grid with multiple tiles per row.
// 
// @treeLocation Client Reference/Grids
// @visibility external
//<
isc.ClassFactory.defineClass("TileLayout", "Canvas");

isc.TileLayout.addProperties({

//> @attr tileLayout.tiles (Array of Canvas : null : IR)
// List of tiles to lay out.
//
// @visibility external
//<

//> @attr tileLayout.layoutPolicy (TileLayoutPolicy : "" : IR)
// Policy for laying out tiles.  See +link{type:TileLayoutPolicy} for options.
//
// @group layoutPolicy
// @visibility external
//<
layoutPolicy: "fit",

//> @attr tileLayout.tileSize (int : 50 : IR)
// Size of each tile in pixels.  Depending on the +link{layoutPolicy}, <code>tileSize</code>
// may be taken as a maximum, minimum or exact size of tiles, or may be irrelevant.
// <P>
// Width and height may be separately set via +link{tileHeight} and +link{tileWidth}.
//
// @group sizing
// @visibility external
//<
tileSize: 50,

//> @attr tileLayout.tileWidth (int : null : IR)
// Width of each tile in pixels.  See +link{tileSize}.
//
// @group sizing
// @visibility external
//<

//> @attr tileLayout.tileHeight (int : null : IR)
// Height of each tile in pixels.  See +link{tileSize}.
//
// @group sizing
// @visibility external
//<

//> @attr tileLayout.tileMargin (int : 10 : IR)
// Margin in between tiles.  Can be set on a per-axis basis with +link{tileHMargin} and
// +link{tileVMargin}.
//
// @group layoutMargin
// @visibility external
//<
tileMargin: 10,

//> @attr tileLayout.tileHMargin (int : null : IR)
// Horizontal margin in between tiles.  See +link{tileMargin}.
//
// @group layoutMargin
// @visibility external
//<

//> @attr tileLayout.tileVMargin (int : null : IR)
// Vertical margin in between tiles.  See +link{tileMargin}.
//
// @group layoutMargin
// @visibility external
//<

//> @attr tileLayout.layoutMargin (integer : 5 : IR)
// A margin left around the outside of all tiles.
//
// @group layoutMargin
// @visibility external
//<
layoutMargin:5,

//> @attr tileLayout.paddingAsLayoutMargin (boolean : true : IRWA) 
// @include layout.paddingAsLayoutMargin
//
// @group layoutMargin
// @visibility external
//<
paddingAsLayoutMargin:true,

//> @attr tileLayout.orientation (Orientation : "horizontal" : IR)
// Direction of tiling.  See also +link{type:TileLayoutPolicy}.
//
// @group layoutPolicy
// @visibility external
//<
orientation : "horizontal",

//> @attr tileLayout.tilesPerLine (int : null : IR)
// Number of tiles to show in each line.  Auto-derived from +link{tileSize} for some layout
// modes.  See +link{type:TileLayoutPolicy}.
//
// @group layoutPolicy
// @visibility external
//<

//> @attr tileLayout.overflow   (Overflow : "visible" : IR)
// Normal +link{type:Overflow} settings can be used on TileLayouts, for example, an
// overflow:auto TileLayout will scroll if members exceed its specified size, whereas an
// overflow:visible TileLayout will grow to accomodate members.
//
// @group sizing
// @visibility external
//<
overflow: "auto",

//> @attr tileLayout.expandMargins (boolean : true : IR)
// With +link{layoutPolicy}:"fit", should margins be expanded so that tiles fill the
// available space in the TileLayout on the breadth axis?
//
// @group layoutMargin
// @visibility external
//<
expandMargins: true,

//> @attr tileLayout.autoWrapLines (boolean : true : IR)
// When +link{layoutPolicy} is "flow", should we automatically start a new line when there's
// not enough room to fit the next tile on the same line?
// <P>
// If set to false, a new line will only be started if a tile specifies tile.startLine or
// tile.endLine.
//
// @group layoutPolicy
// @visibility external
//<
autoWrapLines: true,

//> @type TileLayoutPolicy
// Policy for laying out tiles. 
// <P>
// Because a TileLayout can be either horizontally or vertically oriented, the general term
// "line" is used to mean either a row or column of tiles. 
// <P>
// <b>NOTE</b>: for typical form layouts (a variety of input fields and buttons in a
// tabular layout with col-spanning and row-spanning support), use a +link{DynamicForm} and
// see the +link{group:formLayout} topic.
//
// @value "fit"
// Each line has the same number of tiles, based on +link{tileLayout.tilesPerLine} if set, otherwise,
// based on fitting as many tiles per line as possible consistent with
// +link{tileLayout.tileSize,tileSize} and +link{tileLayout.tileMargin}. 
// <P>
// Tiles that do not specify a size will be sized to fill available space.
//
// @value "flow"
// Tiles are laid out with varying numbers of tiles per line according to each tile's size,
// the +link{tileLayout.tileMargin,tileMargin}, and the available space.
// <P>
// Tiles are never resized by the TileLayout and +link{tileLayout.tileSize} is ignored.
//
// @visibility external
//<

//> @attr tileLayout.dropIndicator (AutoChild : null : R)
// Canvas used to display a drop indicator when a another canvas is dragged over this widget.
//
// @visibility external
//<
dropIndicatorDefaults: {
    overflow: "hidden",
    styleName: "layoutDropLine"
    
},

initWidget : function () {
    this.invokeSuper(isc.TileLayout, "initWidget");
    if (!this.tiles) this.tiles = [];
    // this makes d & d code work with tileLayout and tileGrid equally well
    this.data = this.tiles; 
    
    
},

draw : function (a, b, c, d) {
    this.invokeSuper(isc.TileLayout, "draw", a, b, c, d);
    this.layoutTiles();
    // set up dropIndicatorDefaults
    if (!this.dropIndicatorDefaults.height)
        this.dropIndicatorDefaults.height = 
            this.orientation == "horizontal" ? (this.tileHeight || this.tileSize || 100) : 2;
    if (!this.dropIndicatorDefaults.width)
        this.dropIndicatorDefaults.width = 
            this.orientation == "horizontal" ? 2 : (this.tileWidth || this.tileSize || 100);
     
},



willScroll : function () {
    var isHoriz = this.orientation == "horizontal";
    var topMargin = this._topMargin;
    var bottomMargin = this._bottomMargin;
    var leftMargin = this._leftMargin;
    var rightMargin = this._rightMargin;
    if (this.layoutPolicy == "flow") {
        if (this.overflow != "auto" && this.overflow != "scroll") return false;
       
        var availBreadth =  isHoriz ? this.getInnerWidth() - rightMargin : this.getInnerHeight() - bottomMargin;
        var availLength = isHoriz ? this.getInnerHeight() - bottomMargin : this.getInnerWidth() - leftMargin;
        
        var currBreadthPos = isHoriz ? leftMargin : topMargin;
        var currLengthPos = isHoriz ? topMargin : leftMargin;
        var currMaxLength = 0;
        // keep track of rows for debugging purposes mainly
        var numRows = 0;
        var tileBreadthMargin = isHoriz ? this.getTileHMargin() : this.getTileVMargin();
        var tileLengthMargin = isHoriz ? this.getTileVMargin() : this.getTileHMargin();
        for (var i = 0; i < this.getLength(); i++) {
            var newTile = this.getTile(i);
             // check for startLine flag 
            if (!this.autoWrapLines && newTile.startLine) currBreadthPos = 0;
            var tileBreadth = isHoriz ? newTile.getVisibleWidth() : newTile.getVisibleHeight();
            
            // check for end of line
            if ((this.autoWrapLines && currBreadthPos + tileBreadth > availBreadth) 
                    || (!this.autoWrapLines && newTile.endLine)) {
                // reset breadth position
                currBreadthPos = isHoriz ? leftMargin : topMargin;;
                // currMaxLength + lengthMargin gives us length position of next line
                currLengthPos += currMaxLength + tileLengthMargin;
                currMaxLength = 0;
                numRows++;
            }    
            var tileLength = isHoriz ? newTile.getVisibleHeight() : newTile.getVisibleWidth();
            // if the children are already passed our length, we will scroll, so return true
            if (currLengthPos + tileLength > availLength) return true;
            // keep track of max length
            if (currMaxLength < tileLength) {
                currMaxLength = tileLength;    
            }
            // move to the next breadth position
            currBreadthPos += tileBreadth + tileBreadthMargin;
            
        }
        // no scrolling, so return false
        return false;
    } else {
        // scrolling will happen if... 
        // this.length / (tileLength + tileMargin) * tiles per line > data length 
        var availLength = isHoriz ? this.getVisibleHeight() - (topMargin + bottomMargin) 
                                    : this.getVisibleWidth() - (rightMargin + leftMargin);
        var tileLength = isHoriz ? this.getTileHeight() : this.getTileWidth();
        var tileLengthMargin = isHoriz ? this.getTileVMargin() : this.getTileHMargin();
        var tpl = this.getTilesPerLine();
        var maxLinesTillScroll = Math.floor(availLength / (tileLength + tileLengthMargin));
        var maxTilesTillScroll = tpl * maxLinesTillScroll;
        return (this.getLength() > maxTilesTillScroll);
    }
},

layoutTiles : function (mode) {
    if (!this.isDrawn() || this.getLength() == 0) return;
    // keep track of visible tiles for animation purposes.
    // Tiles are added here in processTile(). Used in _animateChange() 
    this._visibleTiles = [];
    // keep track of # of tiles processed so extra ones can be hidden
    this._numTilesProcessed = 0;
    // cache our dimensions to determine if a tile is visible in processTile()
    this._viewportRect = [this.getScrollLeft(), this.getScrollTop(), this.getInnerWidth(), this.getInnerHeight()];
    // do margin calculations first so they can be used for both flow and fit layouts
    var tPad, bPad, lPad, rPad;
    if (this.paddingAsLayoutMargin) {
        var padding = this._calculatePadding();
        lPad = padding.left; rPad = padding.right;
        tPad = padding.top; bPad = padding.bottom;    
    }
    // cache margin calculations
    var topMargin = this._topMargin = this._firstNonNull(this.layoutMargin, tPad, 0);
    var bottomMargin = this._bottomMargin = this._firstNonNull(this.layoutMargin, bPad, 0);
    var leftMargin = this._leftMargin = this._firstNonNull(this.layoutMargin, lPad, 0);
    var rightMargin = this._rightMargin = this._firstNonNull(this.layoutMargin, rPad, 0);
    
    // flow layout
    if (this.layoutPolicy == "flow") {
        this.logDebug("starting flow layout", "TileLayout");
        var isHoriz = this.orientation == "horizontal";
        // only subtract right or bottom margin from available breadth, as top/left margin is already
        // accounted for when setting current breadth/length position
        var availBreadth =  isHoriz ? this.getInnerWidth() - rightMargin : 
                                    this.getInnerHeight() - bottomMargin;
        // if scrolling will occur, take the scrollbar into account
        if (this.willScroll()) availBreadth -= this.getScrollbarSize();
  
        var currBreadthPos = isHoriz ? leftMargin : topMargin;
        var currLengthPos = isHoriz ? topMargin : leftMargin;
        var currMaxLength = 0;
        // keep track of rows for debugging purposes mainly
        var numRows = 0;
        var tileBreadthMargin = isHoriz ? this.getTileHMargin() : this.getTileVMargin();
        var tileLengthMargin = isHoriz ? this.getTileVMargin() : this.getTileHMargin();
        for (var i = 0; i < this.getLength(); i++) {     
            var newTile = this.getTile(i);
             // check for startLine flag 
            if (!this.autoWrapLines && newTile.startLine)  currBreadthPos = 0;
            var tileBreadth = isHoriz ? newTile.getVisibleWidth() : newTile.getVisibleHeight();
            // check for end of line
            if ((this.autoWrapLines && currBreadthPos + tileBreadth > availBreadth) 
                || (!this.autoWrapLines && newTile.endLine)) {
                // reset breadth position
                currBreadthPos = isHoriz ? leftMargin : topMargin;;
                // currMaxLength + lengthMargin gives us length position of next line
                // When the first tile is larger than available breadth, don't add a margin
                // to currLengthPos; we just want it to remain the same in this case, which is 0. 
                currLengthPos += currMaxLength + (i == 0 ? 0 : tileLengthMargin);
                currMaxLength = 0;
                numRows++;
            }
            // horizontal : top = length position, left = breadth position
            // vertical : top = breadth position, left = length position
            var nTop = isHoriz ? currLengthPos : currBreadthPos;
            var nLeft = isHoriz ? currBreadthPos : currLengthPos;
           
            this.processTile(i, nTop, nLeft);
            // keep track of max length
            var tileLength = isHoriz ? newTile.getVisibleHeight() : newTile.getVisibleWidth();
            if (currMaxLength < tileLength) {
                currMaxLength = tileLength;    
            }
            // move to the next breadth position
            currBreadthPos += tileBreadth + tileBreadthMargin;
            
        }
    // fit layout  
    } else {
        this.logDebug("starting fit layout", "TileLayout");
        var tPerLine = this.getTilesPerLine();
        var tHeight = this.getTileHeight();
        var tWidth = this.getTileWidth();
        var isHoriz = this.orientation == "horizontal";
        var tHMargin, tVMargin, extraPixels;
       
        var totalTiles, tileNum, numLines, spacerCanvas, startLine, endLine;
        if (this.shouldUseIncrRendering()) {
            var tileRange = this.getVisibleTiles();
            // store visible tile range for subclasses that may want to use it (TileGrid, etc.)
            // these values will be return by getDrawnStartIndex() getDrawnEndIndex(), which subclasses
            // should use to access these values
            this._lastVisibleTiles = tileRange;
            tileNum = tileRange[0];
            totalTiles = this.getLength();
            var lineRange = this.getVisibleLines();
            startLine = lineRange[0];
            endLine = lineRange[0] + lineRange[1];
            
        } else {
            totalTiles = this.getLength();
            tileNum = 0;
            startLine = 0;
            endLine = Math.ceil(totalTiles / tPerLine);
            tHMargin = this.getTileHMargin();
            tVMargin = this.getTileVMargin();
                        
        }
        // set up the spacer canvas for all rendering options so that the layoutMargin can 
        // always be created and show up on the bottom.
        var totNumLines = Math.ceil(this.getLength() / tPerLine);
        var tVMargin = this.getTileVMargin();
        var tHMargin = this.getTileHMargin();
        var tileLength = isHoriz ? tHeight : tWidth;
        var lengthMargin = isHoriz ? tVMargin : tHMargin;
        // total lines length is tile length + margin length times # of lines
        // subtract 1 extra tilemargin length from the end, and add either top + bottom margin 
        // (for horizontal orientation) or left + right margin (for vertical)
        var totLen = ((tileLength + lengthMargin) * totNumLines) - lengthMargin 
            + (isHoriz ? topMargin + bottomMargin : leftMargin + rightMargin);
        spacerCanvas = this._getSpacerCanvas();
        isHoriz ? spacerCanvas.setHeight(totLen) : spacerCanvas.setWidth(totLen);
        spacerCanvas.sendToBack();
        
        // get the extra pixels before begining actual tile layout
        extraPixels = this.getExtraMarginPixels(tPerLine, tHeight, tWidth, tHMargin, tVMargin);
        for (var i = startLine; i < endLine; i++) {
            // keep track of extra pixels to divide among tiles 
            var exPixels = extraPixels;
            for (var j = 0; j < tPerLine; j++) {  
                // for horizontal, top will remain constant and left will vary.
                // for vertical, top will vary and left will remain constant.
                var topPos = isHoriz ? i : j;
                var leftPos = isHoriz ? j : i;

                // top = (current top position * tile height) + (current top position * tile vertical margin) 
                //      + top layout margin
                var nTop = (topPos * tHeight) + (topPos * tVMargin ) + topMargin;
                // if we're vertical and the current vertical position is less than the number of
                // extra pixels, use our vertical position as the number of extra pixels to add to 
                // the current top coordinate to get the proper placement
                if (!isHoriz && j + 1 <= extraPixels) nTop += j + 1;
                // left = same logic as top, but substitute left
                var nLeft = (leftPos * tWidth) + (leftPos * tHMargin) + leftMargin;
                // if we're horizontal and the current horizontal position is less than the number of
                // extra pixels, use our horizontal position as the number of extra pixels to add to 
                // the current left coordinate to get the proper placement
                if (isHoriz && j + 1 <= extraPixels) nLeft += j + 1;
                var newTile = this.processTile(tileNum, nTop, nLeft, this.getTileHeight(), this.getTileWidth());                 
              
                tileNum++;
                // check for the case where more images are returned than will fit
                if (tileNum >= totalTiles) break; 
            }  
            if (tileNum >= totalTiles) break;
        }
    }
},

processTile : function (tileNum, top, left, height , width) {
    if (this._animating) {
        
        var tile = this.getRecordTile(tileNum)
        if (!tile) return;
        // verify that tile was visible before
        if (this._oldVisibleTiles.findIndex("ID", tile.ID) == -1) return;
        //isc.logWarn("tile:" + tile);
        if (!tile) return;
        
        if (height) tile.setHeight(height);
        if (width) tile.setWidth(width);
        // only track the tile for animation if it will actually change position. This helps
        // prevent excess show/hide cycles.
        if (tile.getTop() != top || tile.getLeft() != left) {
            // store the top and left to which this tile should be animated (see _animateChange())
            tile._newTop = top;
            tile._newLeft = left;
            this._tilesToAnimate.add(tile);
        }
        
        var tileRect = [left, top, tile.getVisibleWidth(), tile.getVisibleHeight()];
     
        // make sure tile is actually visible before adding to visibleTiles
        if (isc.Canvas.rectsIntersect(this._viewportRect, tileRect)) {
             this._visibleTiles.add(tile);
        }
    } else {
        var tile = this.getTile(tileNum);
    
        // set height and width here
        if (height) tile.setHeight(height);
        if (width) tile.setWidth(width);
        tile.setTop(top);
        tile.setLeft(left);
        // add tile to children
        this.addChild(tile);
        // must do this because tiles may be hidden from a call to cleanupExtraTiles() from 
        // within dataChanged(). see dataChanged() for more info.
        tile.show();
        // add tile to _visibleTiles for animation purposes. See _animateChange.
        // we keep track of this in TileGrid and not TileLayout, because this pertains more to 
        // TileGrid functionality than to tileLayout, thus keeping the code cleaner.
        // Not true anymore, tileLayout now has animations 11/3/08
        var tileRect = [tile.getLeft(), tile.getTop(), tile.getVisibleWidth(), tile.getVisibleHeight()];
     
        // make sure tile is actually visible before adding to visibleTiles
        if (isc.Canvas.rectsIntersect(this._viewportRect, tileRect)) {
             this._visibleTiles.add(tile);
        }
        // keep track of number of tiles processed so that extra tiles can be hidden if needed
        // in layoutTiles()
        this._numTilesProcessed += 1;
        return tile;
    }
      
},

_getSpacerCanvas : function () {
    if (!this._spacerCanvas) {
        this._spacerCanvas = isc.Canvas.create({autoDraw:false}); 
        // spacer canvas to make the scroll behave appropriately
        this.addChild(this._spacerCanvas);
    }
    return this._spacerCanvas;
},

getDrawnStartIndex : function () {
    // this check should be adequate. We aren't supporting changing incremental rendering on the 
    // fly, so this will always return null if its off..._lastVisibleTiles is only created when
    // incremental rendering is on. (see shouldUseIncrRendering())
    if (this._lastVisibleTiles) return this._lastVisibleTiles[0];
    else return null;
},

getDrawnEndIndex : function () {
    if (this._lastVisibleTiles) return this._lastVisibleTiles[1];
    else return null;
},

shouldUseIncrRendering : function () {
    if (this._animating) {
        return true;
    } else if (!this.showAllRecords && this.layoutPolicy == "fit" 
        && (this.overflow == "auto" || this.overflow == "hidden")) {
        return true;
    } else {
        return false;
    }
},

getLength : function () {
    if (!this.tiles) return 0;
    else return this.tiles.getLength();
},

getTilesPerLine : function () {
    if (this.tilesPerLine) return this.tilesPerLine;
    else {
        // variable names are in terms of horizontal orientation
        var tSize = this.orientation == "horizontal" ? this.getTileWidth() : this.getTileHeight();
        var tMargin = this.orientation == "horizontal" ? (this.tileHMargin || this.tileMargin) : 
                            (this.tileVMargin || this.tileMargin);
        var thisSize = this.orientation == "horizontal" ? this.getInnerWidth() : this.getInnerHeight();
        // first just get the number of tiles, without margin, that will fit
        // NOTE margin between the peripheral tiles and widget boundaries are not counted
        var numTiles = Math.floor(thisSize / tSize);
        
        // now factor in the margins; if the total width is greater than our width, subtract
        // 1 from the the tile count.
        var marginOffset = this.orientation == "horizontal" ? this._leftMargin + this._rightMargin :
                                                              this._topMargin + this._bottomMargin;
        var totLineWidth = tMargin * (numTiles - 1) + (numTiles * tSize) + marginOffset;  
        // total line size may be over the limit by more than 1 tile size
        if (totLineWidth > thisSize) {
            var numTilesOver = Math.ceil((totLineWidth - thisSize) / tSize);
            numTiles -= numTilesOver;
        }
        // at least one tile per line
        if (numTiles < 1) numTiles = 1;
        
        return numTiles;
    }
},

getVisibleLines : function () {
    var horizontal = (this.orientation == "horizontal");
    var scrollPos = horizontal ? this.getScrollTop() : this.getScrollLeft();
    var lineHeight = horizontal ? this.getTileHeight() + this.getTileVMargin() :
                                  this.getTileWidth() + this.getTileHMargin();
    var windowSize = horizontal ? this.getInnerHeight() : this.getInnerWidth();
    
    var numLinesOffScreen = Math.floor(scrollPos / lineHeight);
    // overestimate start line by adding a line to the front
    if (numLinesOffScreen > 0) numLinesOffScreen--;
    
    var numLinesOnScreen = Math.ceil(windowSize / lineHeight) + 2;
    
    return [numLinesOffScreen, numLinesOnScreen];
},

getVisibleTiles : function () {
    var visibleLines = this.getVisibleLines();
    var tilesPerLine = this.getTilesPerLine();
    var start = visibleLines[0] * tilesPerLine;
    var end = (visibleLines[0] + visibleLines[1]) * tilesPerLine;
    
    return [start, end];
},

scrolled : function () {
    if (this.shouldUseIncrRendering()) {
        if (this._layoutEventId) isc.Timer.clear(this._layoutEventId);
        this._layoutEventId = isc.Timer.setTimeout(this.ID + ".layoutAfterScroll()");
          
    }       
},

layoutAfterScroll : function () {
    this.logDebug('layoutAfterScroll', "TileLayout");
    if (this.shouldLayoutTiles()) this.layoutTiles(); 
},

shouldLayoutTiles : function () {
    var currTiles = this.getVisibleTiles();
    if (currTiles[0] == this.getDrawnStartIndex() && currTiles[1] == this.getDrawnEndIndex()) {
        return false;
    } else {
        return true;    
    }
        
},

getTileWidth : function () {
    if (this.tileWidth) return this.tileWidth;
    else return this.tileSize;    
},

getTileHeight : function () {
    if (this.tileHeight) return this.tileHeight;
    else return this.tileSize;
},

// helper function to consolidate code used in various places
getInnerBreadth : function () {
   
    var breadth = this.orientation == "horizontal" ? this.getVisibleWidth() - this.getHBorderPad()
        : this.getVisibleHeight() - this.getVBorderPad();
    if (this.willScroll()) breadth -= this.getScrollbarSize();
    return breadth;
},

getTileHMargin : function () {    
    
    var hMargin;        
    if (this.tileHMargin) {
        hMargin = this.tileHMargin;
    } else {
        hMargin = this.tileMargin;
    }
    if (this.layoutPolicy == "fit" && this.expandMargins && this.orientation == "horizontal") {
        var tpl = this.getTilesPerLine();
        // expanded margin = (viewable width - all tiles in a line width - layoutMargins) / number of margins in a line
        // remainder is calculated later, in getExtraMarginPixels
        var lMargins = this._leftMargin + this._rightMargin;
        var exMargin = Math.floor((this.getInnerBreadth() - (tpl * this.getTileWidth()) - lMargins) / (tpl - 1));
        // don't return less than hMargin
        if (exMargin < hMargin) return hMargin;
        else return exMargin;
    } else {
        return hMargin;
    }
    
   
},

getTileVMargin : function () {
   // if (this.tileVMargin) return this.tileVMargin;
   // else return this.tileMargin;
    
    var vMargin;        
    if (this.tileHMargin) {
        vMargin = this.tileVMargin;
    } else {
        vMargin = this.tileMargin;
    }
    if (this.layoutPolicy == "fit" && this.expandMargins && this.orientation == "vertical") {
        var tpl = this.getTilesPerLine();
        // expanded margin = (viewable height - tilesPerLine height) / marginsPerLine
        // remainder is calculated later, in getExtraMarginPixels
        var lMargins = this._topMargin + this._bottomMargin;
        var exMargin = Math.floor((this.getInnerBreadth() - (tpl * this.getTileHeight()) - lMargins) / (tpl - 1));
        // don't return less than hMargin
        if (exMargin < vMargin) return vMargin;
        else return exMargin;
    } else {
        return vMargin;
    }
},

// this calculates the remainder of pixels after expanded margins are calculated in getTileHMargin 
// and getTileVMargin. These pixels will then be spread out between tiles in layoutTiles() for fit layout mode
getExtraMarginPixels : function (tpl, tHeight, tWidth, tHMargin, tVMargin) {
    if (this.expandMargins && this.orientation == "horizontal") {
        // viewable width - (tilesPerLine width + marginsPerLine width)
        var usedPixels = (tpl * tWidth) + ((tpl - 1) * tHMargin) + (this._leftMargin + this._rightMargin);
        return this.getInnerBreadth() - usedPixels;
    } else if (this.expandMargins && this.orientation == "vertical") {
        // viewable height - (tilesPerLine height + marginsPerLine height)
        var usedPixels = (tpl * tHeight) + ((tpl - 1) * tVMargin) + (this._topMargin + this._bottomMargin);
        return this.getInnerBreadth() - usedPixels;
                                        
    } else {
        return 0;
    }
},

//> @method tileLayout.getTile()
// Retrieve a tile by index.  
// <P>
// The TileLayout consistently uses this method to access tiles, in order to allow subclasses
// to create tiles on demand.
//
// @param index (int) index of the tile
// @return (Canvas) the tile
//
// @visibility external
//<
getTile : function (index) {
    if (!this.tiles) return null;
    else return this.tiles[index];    
},

//> @method tileLayout.addTile()
// Add a tile to the layout, dynamically.
//
// @param tile (Canvas) new tile to add 
// @param [index] (int) position where the tile should be added.  Defaults to adding the tile
// at the end.
// @visibility external
//<
addTile : function (tile, index) {
     if (!this.tiles) return;
     if (!index) index = this.tiles.getLength();
     this.tiles.addAt(tile, index);
     this.layoutTiles();
},

//> @method tileLayout.removeTile()
// Remove a tile from the layout.
//
// @param tileID (Canvas or int or ID) index or String ID of the tile
// @return (boolean) whether a tile was found and removed
// @visibility external
//<
removeTile : function (tile) {
    if (!this.tiles) return;
    var index;
    if (isc.isA.Canvas(tile)) { // canvas passed in, so get index 
        index = this.tiles.findIndex("ID", tile.ID);
    } else { 
        // first assume tile is a canvas ID
        index = this.tiles.findIndex("ID", tile);
        // if not, assume tile is an index into tiles
        if (index == -1) index = tile;    
    }
    this.tiles.removeAt(index);
    this.layoutTiles();
},

getRecordTile : function (recordIndex) {
    return this.tiles.get(recordIndex);    
},
// --------------------------Drag and Drop-----------------------------------------------------


dropOver: function () {
    //isc.logWarn('dropOver:');
    var props = isc.addProperties(this.dropIndicatorDefaults, this.dropIndicatorProperties);
    isc.Event.setDragTracker("", props.width, props.height, null, null, props);
},

dropMove: function () {
    if (isc.isAn.Array(this.data)) {
        var x = this.getOffsetX(), y = this.getOffsetY(), xBase = this.getPageLeft(), yBase = this.getPageTop();
        // get index of tile that mouse is over
        var currIndex = this.findIndexForCoord(x, y);
        if (currIndex == null) return;
        this._lastDropIndex = currIndex;
        var tile = this.getRecordTile(currIndex);
        
        var tracker = this.ns.EH.dragTracker;
        // move tracker to left (horizontal) or top (vertical) edge of tile
        tracker.moveTo(xBase + (tile.getLeft() - this.getScrollLeft()), 
                        yBase + (tile.getTop() - this.getScrollTop()));
        //tracker.setHeight(tile.getVisibleHeight());
        // set width/height to size of tile depending on orientation
        if (this.orientation == "horizontal") tracker.setHeight(tile.getVisibleHeight());
        else tracker.setWidth(tile.getVisibleWidth());
                         
    }
},

// returns the index of the first record whose tile left and top is greater than the passed in 
// left and top coords
findIndexForCoord : function (left, top) {
    // first see if we can use drawnStart/endIndex. This is the case for showAllRecords:false
    var start = this.getDrawnStartIndex(), end = this.getDrawnEndIndex();
    // if not, then just traverse the whole data array
    if (start == null || end == null) {
        start = 0;
        end = this.data.getLength();
    }
    for (var i = start; i < end; i++) {
        var tile = this.getRecordTile(i);
        if (!tile) continue;
        if (tile.getLeft() + tile.getVisibleWidth() > left 
            && tile.getTop() + tile.getVisibleHeight() > top) return i;
    }
    return null;
},

//>	@method	tileLayout.drop()	(A)
//			handle a drop event
//		@return	(boolean)	true if the list can't reorder or dragging did not begin from the list body;
//							false if disabled, no selection, or otherwise
//		@group	events, dragging
//<
drop : function () {
    var index = this._lastDropIndex || 0;
    var source = this.ns.EH.dragTarget;
    
    // don't check willAcceptDrop() this is essentially a parallel mechanism, so the developer 
    // shouldn't have to set that property directly.
    if (index == null) index = this.data.getLength()
    else index = Math.min(index, this.data.getLength());
    
   
    var dropRecords = source;
    var targetRecord = this.data.get(index);
    
    this.transferRecords(dropRecords, targetRecord, index, source);
    // strange results without a timer
    isc.Timer.setTimeout(this.ID + "._animateChange()", 200);
},

// --------------------------Animation-----------------------------------------------------

_animateChange : function () {
    this.logDebug("starting _animateChange()", "TileLayout");
    // tell this.processTile() that we're animating, which will be called from tileGrid.layoutTiles() 
    this._animating = true;
    // keep track of animation ID's so they can be cancelled later if another dataChange event 
    // happens while an animation is going on.
    this._animationIDs = [];
    // hold on to the array of visibleTiles, as this._visibleTiles will get reset when 
    // we run layoutTiles() from here
    var visTiles = this._oldVisibleTiles = this._visibleTiles;
    // 1. calling layoutTiles will build an array of tiles that need to be animated (i.e. that were
    // visible before and are still visible now) by calling processTile(), and 
    // storing these tiles in this._tilesToAnimate
    this._tilesToAnimate = [];
    this.layoutTiles();    
    // 2. hide tiles pointing to data that will no longer be visible
    for (var i = 0; i < visTiles.length; i++) {
        // if the currently visible tiles contain the old visible tiles, hide those tiles.
        // if we just hide them all without the check, there is a visible flash for tiles
        // that stay in the same place.
        if (!this._visibleTiles.contains(visTiles[i]))  {
            visTiles[i].hide();
        }
    }
    
    // 3. animate the tiles that need to be moved
    var numTiles = this._tilesToAnimate.length;
    if (numTiles == 0) {
        this._finishAnimating();    
        return;
    }
    for (var i = 0; i < numTiles; i++) {
        var tile = this._tilesToAnimate[i];
        // see the comment below step 2, we need to show here because the tile may have been
        // hidden from a call to cleanupExtraTiles() within dataChanged().
        tile.show();
        // if last tile, pass a callback
        var animID;
        if (i == numTiles - 1) {
            animID = tile.animateMove(tile._newLeft, tile._newTop, this.getID() + "._finishAnimating()");     
        } else {
            animID = tile.animateMove(tile._newLeft, tile._newTop);    
        }
        // keep track of animations for later cancellation. see _layoutAfterDataChange()
        this._animationIDs.add({ID:animID, tile:tile});
    }
    
},

_finishAnimating : function () {
    // no longer animating
    this._animating = false;
    // clean up internal arrays
    this._oldVisibleTiles = null;
    delete this._oldVisibleTiles;
    this._tilesToAnimate = null;
    delete this._tilesToAnimate;
    // layout tiles 
    this.layoutTiles();    
},

// -----------------------tileLayout-----------------------------------------------------------
//>	@method	tileLayout.setTileSize()	
// sets the height and width of tiles
// @param	(Integer) size	
//
// @group tileLayout
// @visibility external
//<
setTileSize : function (size) {
    this.tileSize = size;
    this.layoutTiles();    
},

//>	@method	tileLayout.setTileWidth()	
// sets the width of tiles
// @param	(Integer) width	
//
// @group tileLayout
// @visibility external
//<
setTileWidth : function (width) {
    this.tileWidth = width;
    this.layoutTiles();
},

//>	@method	tileLayout.setTileHeight()	
// sets the height of tiles
// @param	(Integer) height	
//
// @group tileLayout
// @visibility external
//<
setTileHeight : function (height) {
    this.tileHeight = height;
    this.layoutTiles();
},

//>	@method	tileLayout.setTileMargin()	
// sets the width of tiles
// @param	(Integer) margin	
//
// @group tileLayout
// @visibility external
//<
setTileMargin : function (margin) {
    this.tileMargin = margin;
    this.layoutTiles();
},

//>	@method	tileLayout.setTileHMargin()	
// sets the width of tiles
// @param	(Integer) width	
//
// @group tileLayout
// @visibility external
//<
setTileHMargin : function (margin) {
    this.tileHMargin = margin;
    this.layoutTiles();
},

//>	@method	tileLayout.setTileVMargin()	
// sets the width of tiles
// @param	(Integer) width	
//
// @group tileLayout
// @visibility external
//<
setTileVMargin : function (margin) {
    this.tileVMargin = margin;
    this.layoutTiles();
}
});

