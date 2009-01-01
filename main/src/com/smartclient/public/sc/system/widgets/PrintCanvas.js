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
// Print Canavs - used to render a hidden IFrame for printing
isc.defineClass("PrintCanvas", "Canvas").addProperties({

redrawOnResize: false,
overflow: "hidden",

initWidget : function () {
    this.Super("initWidget", arguments);    
},

getInnerHTML : function () {
    return "<iframe height='100%' width='100%' scrolling='auto' id='"
        + this.getIFrameID()+"'"+" frameborder='0'" +" src=\"" +this.getPrintFrameURL(this.title)+"\"></iframe>";
},

getIFrameID : function () {
    return this.getID()+"_frame";
},  

getPrintFrameURL : function (title) {
    return isc.Page.getURL("[HELPERS]printFrame.jsp?id="+this.getID() + "&title=" + (title || ""));
},

getIFrameHandle : function () {
    return document.getElementById(this.getIFrameID());
},

getIFrameWindow : function () {
    return this.getIFrameHandle().contentWindow;
},

iframeLoad : function () {
    this.iframeLoaded = true;
},


setHTML : function (HTML, callback) {
    if (!this.iframeLoaded) {
        this.delayCall("setHTML", [HTML, callback], 100);
        return;
    }

    var frame = this.getIFrameWindow();
    frame.assignHTML(HTML);
    this.fireCallback(callback, ["printPreview","callback"], [this, callback]);
},

setTitle : function (title) {
    this.title = title;
    // if the iframe hasn't been loaded we can bail - when we load it we'll include the
    // title in the HTML passed in.
    if (!this.iframeLoaded) return;
    
    // In IE window.title is essentially read-only - we really need to rewrite the entire HTML of
    // the frame to update it
},

printHTML : function (HTML, title ,debugOnly) {
    var self = this;
    this.setTitle(title);
    this.setHTML(HTML, 
    
                    function () {
                    self.print();
                });
},

print : function () {
    this.getIFrameWindow().doPrint();
    
    
},

// Handler to fire when printing is complete - only fires in IE
printComplete : function () {
  //this.logWarn("print complete!~");
}

});

isc.Canvas.addClassMethods({
//> @classMethod Canvas.printComponents()
// Print an array of components out, without displaying a print preview to the user.
// Components will be formatted for printing.
// @param components (array of Canvas) components to get the print HTML for. May also include
//  raw HTML strings which will be folded into the generated print output
// @param [printProperties] (object) PrintProperties object for customizing the print HTML output
// @visibility printing
//<
    printComponents : function (components, printProperties, title, debugOnly) {
        isc.Canvas.getPrintHTML(
            components, printProperties, 
            {target:this, methodName:"_printComponentHTML", title:title, debugOnly:debugOnly}
        );
    },
    _printComponentHTML : function (printHTML, callback) {
        var title = callback.title,
            debugOnly  = callback.debugOnly;
            
        if (!this._printCanvas) this._printCanvas = isc.PrintCanvas.create({
            // sizing to 100/100 should cause the layout to match as closely as possible...
            width:"100%", height:"100%", autoDraw:false
            ,backgroundColor:"white"
        });
        this._printCanvas.moveTo(null, -isc.Page.getHeight());
        if (!this._printCanvas.isDrawn()) this._printCanvas.draw();
        this._printCanvas.printHTML(printHTML, title, debugOnly);
    },
    
//> @classMethod Canvas.getPrintPreview()
// Returns a Canvas containing the full printHTML for a series of components.
// @param components (array of Canvas) components to get the print HTML for. May also include
//  raw HTML strings which will be folded into the generated print output
// @param [printProperties] (object) PrintProperties object for customizing the print HTML output
// @param [previewProperties] (object) Properties to apply to the generated printPreview canvas.
// @param [callback] (callback) callback to fire when the print preview canvas has been populated
//  with the printable HTML. The generated canvas will be passed to the callback as a single 
//  [code]printPreview[/code] parameter.
// @visibility printing
//< 
// Don't return the canvas until the HTML has been generated

// 2 steps here - both are asynchronous:
// - generate print html from components
// - apply HTML to the print canvas (asynchronous if iframe wasn't yet loaded)
    getPrintPreview : function (components, printProperties, previewProperties, callback) {
        isc.Canvas.getPrintHTML(components, printProperties, 
                                {target:this, methodName:"_createPrintPreview", 
                                    origCallback:callback, previewProperties:previewProperties});
        
    },
    _createPrintPreview : function (HTML, callback) {
        var PC = isc.PrintCanvas.create(callback.previewProperties);
        PC.setHTML(HTML, {target:this, methodName:"_printPreviewGenerated",
                                        origCallback:callback.origCallback});
    },
    _printPreviewGenerated : function (printPreview, callback) {
        if (callback.origCallback) {
            this.fireCallback(callback.origCallback, ["printPreview"], printPreview);
        }
    },

//> @classMethod Canvas.showPrintPreview()
// Show a +link{class:PrintWindow} containing a printable view of the components passed in
// @param components (array of Canvas) components to get the print HTML for. May also include
//  raw HTML strings which will be folded into the generated print output
// @param [printProperties] (object) PrintProperties object for customizing the print HTML output
// @param [previewProperties] (object) Properties to apply to the generated printPreview canvas.
// @param [callback] (callback) callback to fire when the print preview canvas has been populated
//  with the printable HTML. The generated canvas will be passed to the callback as a single 
//  <code>printPreview</code> parameter.
// @param [separator] (HTML) Optional HTML separator to render between each component's printable
//  HTML
// @visibility printing
//<
    showPrintPreview : function (components, printProperties, previewProperties, callback,
                                  separator) 
    {
        if (!isc.PrintWindow) {
            isc.definePrintWindow();
        }
        if (!isc.PrintWindow) return;
        
        // Make the PrintWindow an autoChild
        previewProperties = isc.addProperties({width:"100%", height:"100%", autoDraw:false},
                                                previewProperties);
        
        if (!this._previewWindow) {
            this._previewWindow = isc.PrintWindow.create(previewProperties);
        }
        this._previewWindow.showPrintPreview(components, printProperties, callback, separator);
    }
    
});

// separate the definition of the PrintWindow class into a separate function.
// We fire this at the end of Window.js, after the Window class has been defined (but before page
// load so we know the class is available when load_skin.js gets loaded).
isc.definePrintWindow = function () {

if (!isc.Window) {
    isc.logWarn("Attempting to create PrintWindow class with no defined Window class. " + 
                "Ensure the required 'Containers' module is laoded");
    return;
}

//> @class PrintWindow
// Subclass of +link{class:Window} used for displaying a printable view. Includes a "Print" button
// header control to trigger printing of content.
// @visibility printing
//<
isc.defineClass("PrintWindow", "Window");
isc.PrintWindow.addProperties({
    isModal: true,
    headerControls: ["headerIcon", "headerLabel", "printButton", "closeButton"],
    printButtonDefaults : {
        _constructor: "IButton",
        title: "Print",
        height: 20,
        click: "this.creator.printClicked()"
    },
    
    showMinimizeButton: false,
    title: "Print Preview",
    
    showPrintPreview : function (components, printProperties, callback, separator) {
        if (!isc.isAn.Array(components)) components = [components];
        isc.Canvas.getPrintHTML(components, printProperties, 
                                {target:this, methodName:"_applyPreviewHTML", 
                                    origCallback:callback}, separator);
    },
    _applyPreviewHTML : function (HTML, callback) {
        if (!this.previewPane) {
            this.previewPane = this.createPreviewPane();
            this.addItem(this.previewPane);
        }
        // we have to draw the preview pane to set it's HTML
        this.setVisibility("hidden");
        if (!this.isDrawn()) this.draw();
       
        this.previewPane.setHTML(HTML, {target:this, methodName:"_printPreviewGenerated",
                                         origCallback:callback.origCallback});
    },
    _printPreviewGenerated : function (printPreview, callback) {
        if (!this.isVisible()) this.show();
        this.bringToFront();
        if (callback.origCallback) {
            this.fireCallback(callback.origCallback, ["printPreview"], printPreview);
        }
    },
    
    printClicked : function () {
        var pc = this.getPrintCanvas();
        if (!pc) return;
        pc.print();
    },
    
    createPreviewPane : function (callback) {
        var previewPane = isc.PrintCanvas.create({
            width: "100%",
            height: "100%"
        });
        return previewPane;
    },
    
    getPrintCanvas : function () {
        return this.previewPane;
    }
});

}
