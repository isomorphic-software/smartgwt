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

 





//>	@class	Img
//
//	The Img widget class implements a simple widget that displays a single image.
//
//  @treeLocation Client Reference/Foundation
//  @visibility external
//  @example img
//<

isc.defineClass("Img", "StatefulCanvas").addClassMethods({
    _buffer : [],
    urlForState : function (baseURL, selected, focused, state, pieceName, customState) {
        if (!baseURL) return baseURL;
        // short circuit to just return baseURL for the simple case
        if (!state && !pieceName && !selected && !focused && !customState) return baseURL;

        // break baseURL up into name and extension
        var period = baseURL.lastIndexOf(isc.dot),
            name = baseURL.substring(0, period),
            extension = baseURL.substring(period + 1),
            buffer = this._buffer;
        
        buffer.length = 1;
        buffer[0] = name;
        // add selected
        if (selected) {
            buffer[1] = isc._underscore;
            buffer[2] = isc.StatefulCanvas.SELECTED;
        }
        if (focused) {
            buffer[3] = isc._underscore;
            buffer[4] = isc.StatefulCanvas.FOCUSED;
        }
        // add state
        if (state) {
            buffer[5] = isc._underscore;
            buffer[6] = state;
        }
        if (customState) {
            buffer[7] = isc._underscore;
            buffer[8] = customState;
        }
        // add pieceName
        if (pieceName) {        
            buffer[9] = isc._underscore;
            buffer[10] = pieceName;
        }
        buffer[11] = isc.dot;
        buffer[12] = extension;
        var result = buffer.join(isc._emptyString);
        return result;
    }
});

// add default properties
isc.Img.addProperties( {
    //> @attr	img.name	(string : "main" : IA)
	// The value of this attribute is specified as the value of the 'name' attribute in the
    // resulting HTML.
    // <p>
    // Note: this attribute is ignored if the imageType is set to "tile"
    // 
    // @visibility external
	//<
	name:"main",

    //>	@attr	img.src		(SCImgURL : "blank.gif" : [IRW])
    // The base filename for the image.
    // <P>
    // If <code>img.state</code> is set, it's value will be appended to the URL before the
    // file extension.  
    // <P>
    // For example, given an <code>src</code> of "findIcon.gif" and a state of
    // "Disabled", the resulting image name would be "findIcon_Disabled.gif".  Compound states
    // such as "Selected", "Focused" and "Over" or "Down" will have an intervening underscore,
    // resulting in, for example, <code>"findIcon_Selected_Down.gif"</code>.
    //
    // @group  appearance
    // @visibility external
    //<
	src:"blank.gif",
   
    //>	@attr	img.activeAreaHTML		(String of HTML AREA tags : null : IRWA)
    //
    // Setting this attribute configures an image map for this image.  The value is expected as a
    // sequence of &lg;AREA&gt tags - e.g:
    // <pre>
    // Img.create({ 
    //     src: "myChart.gif",
    //     activeAreaHTML:
    //         "&lt;AREA shape='rect' coords='10,50,30,200' title='30' href='javascript:alert(\"30 units\")'&gt;" +
    //         "&lt;AREA shape='rect' coords='50,90,80,200' title='22' href='javascript:alert(\"22 units\")'&gt;"
    // });
    // </pre>
    // <u>Implementation notes:</u>
    // <ul>
    // <li>Quotes in the activeAreaHTML must be escaped or alternated appropriately.</li>
    // <li>Image maps do not stretch to fit scaled images. You must ensure that the dimensions of
    // your Img component match the anticipated width and height of your image map (which will typically
    // match the native dimensions of your image). </li>
    // <li>To change the image map of an existing Img component, first set yourImg.activeAreaHTML,
    // then call yourImg.markForRedraw(). Calls to yourImg.setSrc() will not automatically update the
    // image map. </li>
    // <li>activeAreaHTML is not supported on tiled Img components (imageType:"tile").</li> 
    // <li>Native browser support for image map focus/blur, keyboard events, and certain AREA tag
    // attributes (eg NOHREF, DEFAULT...) varies by platform. If your image map HTML uses attributes
    // beyond the basics (shape, coords, href, title), you should test on all supported browsers to
    // ensure that it functions as expected.</li>
    // </ul>
    // 
    // @group  appearance
    // @visibility external
    //<
 
    //>	@attr	img.imageType		(ImageStyle : isc.Img.STRETCH : [IRW])
    //          Indicates whether the image should be tiled/cropped, stretched, or centered when the
    //          size of this widget does not match the size of the image. See ImageStyle for
    //          details
    //      @visibility external
    //      @group  appearance
    //<
	imageType: isc.Img.STRETCH,

    //> @attr img.imageHeight (integer : null : IR)
    // Explicit size for the image, for +link{imageType} settings that would normally use the
    // image's natural size (applies to +link{img.imageType} "center" and "normal" only).
    // @visibility external
    //<

    //> @attr img.imageWidth (integer : null : IR)
    // Explicit size for the image, for +link{imageType} settings that would normally use the
    // image's natural size (applies to +link{img.imageType} "center" and "normal" only).
    // @visibility external
    //<

    //> @attr   img.size            (Number : null : [IR])
    // Convenience for setting height and width to the same value, at init time only
    // @group sizing
    // @visibility external
    //<

    // do set styling on the widget's handle
    suppressClassName:false,
    
    
    mozOutlineOffset:"0px",
    
    //> @attr img.showTitle (boolean : false : [IRWA])
    // @include StatefulCanvas.showTitle
    // @visibility external
    //<
    showTitle:false
    
});

// add methods to the class
isc.Img.addMethods({

initWidget : function () {
    // HACK: call Super the direct way   
    isc.StatefulCanvas._instancePrototype.initWidget.call(this);
    //this.Super(this._$initWidget);

    this.redrawOnResize = (this.imageType != isc.Img.STRETCH);
},

//> @method img.setImageType()
// Change the style of image rendering.
//
// @param imageType (ImageStyle) new style of image rendering
//
// @visibility external
//<
setImageType : function (imageType) {
    if (this.imageType == imageType) return;
    this.imageType = imageType;
    this.markForRedraw();
    this.redrawOnResize = (this.imageType != isc.Img.STRETCH);
},

//>	@method	img.getInnerHTML()	(A)
//		@group	drawing
//			write the actual image for the contents
//
//		@return	(HTML)	HTML output for this canvas
//<

_$tableStart : "<TABLE WIDTH=",
_$heightEquals : " HEIGHT=",
_$tableTagClose : " BORDER=0 CELLSPACING=0 CELLPADDING=0><TR>",
_$centerCell : "<TD VALIGN=center ALIGN=center>",
_$tileCell : "<TD BACKGROUND=",
_$tableEnd : "</TD></TR></TABLE>",
getInnerHTML : function () {
    var width = this.getInnerWidth(),
        height = this.getInnerHeight(),
        imageType = this.imageType;
   
    // stretch: just use an <IMG> tag [default]
    if (imageType == isc.Img.STRETCH || imageType == isc.Img.NORMAL) {
        // normal: use an img, but don't size to the Canvas extents.  Size to imageWidth/Height
        // instead, which default to null.
        if (imageType == isc.Img.NORMAL) {
            width = this.imageWidth;
            height = this.imageHeight;
        }

        return this.imgHTML(this.getURL(), width, height, this.name, 
                            this.extraStuff, null, this.activeAreaHTML);
    }

    var output = isc.SB.create();
    // start padless/spaceless table
    output.append(this._$tableStart, width,
				        this._$heightEquals, height, this._$tableTagClose);

	if (imageType == isc.Img.TILE) {
        // tile: set image as background of a cell filled with a spacer
		output.append(this._$tileCell, this.getImgURL(this.getURL()), this._$rightAngle,
				      isc.Canvas.spacerHTML(width, height));
	} else { // (this.imageType == isc.Img.CENTER) 
        // center: place unsized image tag in center of cell
        
        output.append(this._$centerCell,
    				  this.imgHTML(this.getURL(), this.imageWidth, this.imageHeight, this.name, 
                                   this.extraStuff, null, this.activeAreaHTML));
	}

    output.append(this._$tableEnd);
    return output.toString();
},

_handleResized : function (deltaX, deltaY) {
    if (this.redrawOnResize != false || !this.isDrawn()) return;
    // if we're a stretch image, we can resize the image and not redraw it
    // TODO: in fact, we can reflow automatically in the same circumstances as the Button if we
    // draw similar HTML
    var imageStyle = this.getImage(this.name).style;
    this._assignSize(imageStyle, this._$width, this.getWidth());
    this._assignSize(imageStyle, this._$height, this.getHeight());
},

//>	@method	img.setSrc()    ([])
// Changes the URL of this image and redraws it.
// <P>
// Does nothing if the src has not changed - if <code>src</code> has not changed but other
// state has changed such that the image needs updating, call +link{resetSrc()} instead.
//
// @param	URL		(URL)	new URL for the image
// @group	appearance
// @visibility external
// @example loadImages
//<
setSrc : function (URL) {
    if (URL == null || this.src == URL) return;

	this.src = URL;
    this.resetSrc();
},

//> @method img.resetSrc()   (A)
// Refresh the image being shown.  Call this when the +link{src} attribute has not changed, but
// other state that affects the image URL (such as being selected) has changed.
//
// @group	appearance
// @visibility external
//<
resetSrc : function () {
	if (!this.isDrawn()) return;

	// depending on how the image was originally drawn,
	//	we may be able to simply reset the image
	if (this.imageType != isc.Img.TILE) {
		this.setImage(this.name, this.getURL());
	// and we may have to redraw the whole thing
	} else {
		this.markForRedraw("setSrc on tiled image");
	}
},


//>	@method	img.getURL()	(A)
//			get the URL for this image, as modified by the piece name and state.
//			
//			eg if:		.src 		= "foo.gif"
//						pieceName 	= "start"
//						state		= "down"
//
//			url = 		foo_down_start.gif
//
//		@group	appearance
//		@param	[pieceName]	(string : "") 				name for part of the image
//		@param	[state]		(string : this.state)		state of the image ("up", "off", etc.)
//		@param	[selected]	(boolean : this.selected)	whether or not image is also in the
//                                                      "selected" state
//      @param  [focused]   (boolean) 
//          Whether this image should be rendered in the "focused" state. Defaults to true if
//          this Img has focus and +link{StatefulCanvas.showFocused,this.showFocused} is true and
//          +link{StatefulCanvas.showFocusedAsOver,this.showFocusedAsOver} is false.
//
//		@return	(SCImgURL)	URL for the image
//<
getURL : function (pieceName, state, selected, focused) {
    return isc.Img.urlForState(this.src, 
    					   selected != null ? selected : this.selected,
                           focused != null ? focused : this.getFocusedState(),
    					   state != null ? state : this.state, 
    					   pieceName,
                           this.getCustomState());
},

//> @method img.stateChanged() 	 
//		Update the visible state of this image by changing the URL
//
//		@param  newState	(string)	name for the new state	 
//<
stateChanged : function () { 	 
	this.Super("stateChanged");
	
	// call resetSrc() with null to efficiently reset the image 	 
	this.resetSrc(); 	 
}

});
