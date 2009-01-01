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


 



//>	@class RichTextEditor
//  
// RichTextEditing component.  Provides a rich-text editing area along with UI for executing
// rich-text commands on the text.<br>
// The HTML generated from this component may vary by browser, and, as with any HTML 
// value created on the client, we recommend values be sanitized on the server before 
// storing and displaying to other users.<br>
// Note: This component has limited support on the Safari browser.
//
//
// @treeLocation Client Reference/Foundation
// @visibility external
// @example RichTextEditor
//<

isc.ClassFactory.defineClass("RichTextEditor", "VLayout");


isc.RichTextEditor.addProperties({

    // Edit Area config
    editAreaConstructor : "RichTextCanvas",

    //> @attr RichTextEditor.editAreaBackgroundColor (string : "white" : IR)
    // Background color for the edit area.
    //<
    editAreaBackgroundColor : "white",

    //>@attr    RichTextEditor.editAreaBackgroundClassName (string : null : IR)
    // Edit Area can have a custom class applied.
    //<
    editAreaClassName : "normal",
    
    //>@attr    RichTextEditor.value   (string : "" : IRW)
    //  Initial value for the edit area.    Use <code>getValue()</code> and 
    // <code>setValue()</code> to update at runtime.
    // @visibility external
    //<
    value : "",
    
    // General toolbar config
    
    // Toolbar will be an HLayout
    toolbarConstructor : "HLayout",
    
    toolbarHeight : 24, // should be less but figure this out later!
    toolbarBackgroundColor : "#CCCCCC",
    
    toolbarSeparatorSrc : "[SKIN]/RichTextEditor/separator.png",
    
    
    // Default width for control buttons
    controlButtonWidth : 20,
    
    //>@attr RichTextEditor.defaultControlConstructor  (class : isc.Button : [IRA])
    //  By default our 'controls' will be of this specified class. Override for specific 
    //  controls by either implementing a '[controlName]_autoMaker' function which returns the
    //  control, or by specifying '[controlName]Constructor' as a pointer to an appropriate 
    //  isc class.
    //<
    defaultControlConstructor : isc.Button,

    //>@attr RichTextEditor.controlGroups  (array : ["fontControls", "formatControls", "styleControls", "colorControls"] : [IRA])
    //  An array of control group names (strings) specifying which groups of controls should 
    //  be included in the editor toolbar.<br>
    //  For each control group name, this[controlGroupName] should be defined as an array of 
    //  +link{type:ControlName}s, allowing the controlGroup to be customized.
    // 
    // @visibility external
    // @example RichTextEditor
    //<
    controlGroups : [
        "fontControls", "formatControls", "styleControls", "colorControls"
        // ,"editControls"  // Don't show the edit controls by default as they're disabled
                            // on Moz and Safari.
    ],


	//>	@type	ControlName
    //  <code>ControlNames</code> are strings used to specify which UI controls should appear
    //  in the editor toolbar.<br>
    // @value "boldSelection"  A button to make the current selection bold.
    // @value "italicSelection"  A button to make the current selection italic.
    // @value "underlineSelection" A button to make the current selection underlined.
    // @value "fontSelector" A select item allowing the user to change the font of the current
    //                     text selection.
    // @value "fontSizeSelector" A select item allowing the user to change the font 
    //                      size of the current text selection.
    // @value "alignLeft" A button to left-align the selected text.
    // @value "alignRight" A button to right-align the selected text.
    // @value "alignCenter" A button to center the selected text
    // @value "justify" A button to justify the selected line of text.
    // @value "color" A color-picker allowing the user to set the text color
    // @value "backgroundColor" A color picker allowing the user to set the text background 
    // color
    // @visibility external
    //<
    // In addition to the standard ControlNames, custom controls can be added.
    // To add a custom control simply add a new control name (string) to a controlGroup.
    // By default the control will show up as a button with width specified by 
    // <code>richTextCanvas.controlButtonWidth</code>.<br>
    // Properties for each control will be picked up from <code>this.[ControlName]Defaults</code> 
    // and <code>this.[ControlName]Properties</code>.<br>
    // If no click handler is specified in these property blocks, click will call 
    // <code>fireAction()</code> on this editor, passing in the ControlName as an action to fire.<br>
    //    
    //  Note - for custom click-handling purposes, default control buttons are created with
    //  a 'creator' property which points back to the richTextEditor that created them.<br>
    //  For completely custom controls to be included in the toolbar, define a method named
    //  [ControlName]_autoMaker on the RichTextEditor instance. This method should return a
    //  widget instance, which will then be added to the toolbar in the appropriate position.

    // Style Control Config --------------------------------------    
    
    //>@attr    RichTextEditor.styleControls   (array : ["boldSelection", "italicSelection", "underlineSelection"] : [IRA])
    //  Default text styling control group. Consists of an array of 
    //  +link{type:ControlName}s. To display this group of controls for some RichTextEditor,
    //  include <code>"styleControls"</code> in the +link{RichTextEditor.controlGroups} array
    // @visibility external
    //<
    styleControls : [
        "boldSelection", "italicSelection", "underlineSelection"
    ],
    
    // Properties to apply to the style controls.
    // These are picked up based on their name.
    //  NOTE: on a per-instance basis we also pick up this.boldSelectionProperties, etc.
    boldSelectionDefaults : {title:"<b>B</b>", prompt:"Make selection bold"},
    italicSelectionDefaults : {title:"<i>I</i>", prompt:"Make selection italic"},
    underlineSelectionDefaults : {title:"<u>U</u>", prompt:"Make selection underlined"},

    // Font Control Config --------------------------------------
    
    //>@attr    RichTextEditor.fontControls (array : ["fontSelector", "fontSizeSelector"] : [IRA])
    //  Default font control group. Consists of an array of 
    //  +link{type:ControlName}s. To display this group of controls for some RichTextEditor,
    //  include <code>"fontControls"</code> in the +link{RichTextEditor.controlGroups} array
    // @visibility external
    //<    
    
    fontControls : [
        "fontSelector", "fontSizeSelector"
    ],
    
    // Specify the constructor function for the two dynamic form type items
    
    fontSelectorConstructor : isc.DynamicForm,
    fontSizeSelectorConstructor : isc.DynamicForm,
    
    //>@attr    RichTextEditor.fontNames   (object : {} : [IRA])
    //  ValueMap of css fontName properties to font name titles to display in the font selector 
    //  if <code>"fontSelector"</code> is included in +link{RichTextEditor.controlGroups} 
    //  for this editor.
    //  Default value for this attribute:<br>
    // <code> {
    // &nbsp;&nbsp;"arial,helvetica,sans-serif":"Arial",
    // &nbsp;&nbsp;'courier new,courier,monospace':"Courier New",
	// &nbsp;&nbsp;'georgia,times new roman,times,serif':"Georgia",
	// &nbsp;&nbsp;'tahoma,arial,helvetica,sans-serif':"Tahoma",
	// &nbsp;&nbsp;'times new roman,times,serif':"Times New Roman",
    // &nbsp;&nbsp;'verdana,arial,helvetica,sans-serif':"Verdana",
    // &nbsp;&nbsp;"impact":"Impact"}</code>
    // @visibility external
    //<
    //  The default <code>createFontSelector()</code> method will apply this valueMap to the
    //  select item created as the <code>fontSelector</code> control.
    //<
    fontNames:{
		"arial,helvetica,sans-serif":"Arial",
		'courier new,courier,monospace':"Courier New",
		'georgia,times new roman,times,serif':"Georgia",
		'tahoma,arial,helvetica,sans-serif':"Tahoma",
		'times new roman,times,serif':"Times New Roman",
		'verdana,arial,helvetica,sans-serif':"Verdana",
		"impact":"Impact"
	},
    
    //>@attr    RichTextEditor.fontSizes   (object : {} : [IRA])
    //  ValueMap of css font size property values to font size titles to display in the font size
    //  selector if <code>"fontSizeSelector"</code> is included in 
    //  +link{RichTextEditor.controlGroups}.
    //  Default value for this attribute:<br>
    // <code>{
    // &nbsp;&nbsp;"1":"1 (8 pt)",
    // &nbsp;&nbsp;"2":"2 (10 pt)",
    // &nbsp;&nbsp;"3":"3 (12 pt)",
    // &nbsp;&nbsp;"4":"4 (14 pt)",
    // &nbsp;&nbsp;"5":"5 (18 pt)",
    // &nbsp;&nbsp;"6":"6 (24 pt)",
    // &nbsp;&nbsp;"7":"7 (36 pt)"}</code>
    // @visibility external
    //<
    //  The default <code>createFontSizeSelector()</code> method will apply this valueMap to the
    //  select item created as the <code>fontSizeSelector</code> control.
    fontSizes : {
		"1":"1 (8 pt)",
		"2":"2 (10 pt)",
		"3":"3 (12 pt)",
		"4":"4 (14 pt)",
		"5":"5 (18 pt)",
		"6":"6 (24 pt)",
		"7":"7 (36 pt)"
    },
    
    // Edit Control Config --------------------------------------
    // (Note: edit controls are hidden by default, as cut, copy, paste are disabled for 
    //  security reasons in Moz by default, and paste appears to never be supported in Safari).
    
    //>@attr    RichTextEditor.editControls   (array : [...] : [IRA])
    //  Edit control group. Consists of an array of +link{type:ControlName}s.
    //<
    // Leave this @visibility internal until for now.
    editControls : [
        "copySelection", "cutSelection", "pasteSelection"
    ],
    
    // Defaults for the cut/copy/paste buttons
    copySelectionDefaults : { icon:"[SKIN]/RichTextEditor/copy.png", prompt:"Copy Selection" },
    cutSelectionDefaults : { icon:"[SKIN]/RichTextEditor/cut.png", prompt:"Cut Selection"},
    pasteSelectionDefaults : {icon:"[SKIN]/RichTextEditor/paste.png", prompt:"Paste"},
    

    // Format Control Config --------------------------------------

    //>@attr    RichTextEditor.formatControls   (array : ["alignLeft", "alignRight", "alignCenter", "justify"] : [IRA])
    //  Default text formatting control group. Consists of an array of 
    //  +link{type:ControlName}s. To display this group of controls for some RichTextEditor,
    //  include <code>"formatControls"</code> in the +link{RichTextEditor.controlGroups} array
    // @visibility external
    //<
    formatControls : [
        "alignLeft", "alignRight", "alignCenter", "justify"
        // Disable indent/outdent for now, since they're not supported by Safari.
//        ,"indentSelection", "outdentSelection"
    ],
    
    // Note: click is overridden on the various "justify..." controls as they are going to
    // call 'justifySelection(...)' passing in a parameter to specify the desired justification.
    alignLeftDefaults : { icon:"[SKIN]/RichTextEditor/text_align_left.png",
                          prompt:"Left align selection",
                          click:"this.creator.fireAction('justifySelection', 'left');"  
    },
    alignCenterDefaults : { icon:"[SKIN]/RichTextEditor/text_align_center.png",
                            prompt:"Center selection",
                            click:"this.creator.fireAction('justifySelection', 'center');"
    },
    alignRightDefaults : { icon:"[SKIN]/RichTextEditor/text_align_right.png",
                           prompt:"Right align selection",
                           click:"this.creator.fireAction('justifySelection', 'right');"
    },
    justifyDefaults : { icon:"[SKIN]/RichTextEditor/text_align_justified.png",
                        prompt:"Full justify selection",
                        click:"this.creator.fireAction('justifySelection', 'full');"
    },

    // Indent / Outdent - not included by default as not supported on Safari
    indentSelectionDefaults : { icon:"[SKIN]/RichTextEditor/indent.png",  prompt:"Indent selection"},
    outdentSelectionDefaults : { icon:"[SKIN]/RichTextEditor/outdent.png", prompt:"Decrease selection indent"},
    

    // Color Control Config --------------------------------------
    
    //>@attr    RichTextEditor.colorControls (array : ["color", "backgroundColor"] : [IRA])
    //  Control group for modifying text color / background color. 
    //  Consists of an array of +link{type:ControlName}s.
    //  To display this group of controls for some RichTextEditor,
    //  include <code>"formatControls"</code> in the +link{RichTextEditor.controlGroups} array
    // @visibility external
    colorControls : [
        "color", "backgroundColor"
    ],
    
    // color / background color defaults override click handling to prompt the user for a
    // color and apply it to the selection.
    colorDefaults : { icon:"[SKIN]/RichTextEditor/text_color.gif", 
                      prompt:"Set selection color",
                      click:"this.creator.chooseTextColor()"
    },
                    
    backgroundColorDefaults : { icon:"[SKIN]/RichTextEditor/background_color.gif", 
                                prompt:"Set selection background color",
                                click:"this.creator.chooseBackgroundColor()" 
    },
    
    insertControls : [
        "link"
    ],
    
    linkDefaults : {
        icon:"[SKIN]/RichTextEditor/link_new.png",
        prompt:"Edit hyperlink",
        click:"this.creator.createLink()"
    },
    
    // For tabbing / focussing purposes, this editor should pass straight through to the
    // editArea
    canFocus:true,
    _useFocusProxy:false,
    _useNativeTabIndex:false
    
});


isc.RichTextEditor.addClassProperties({
    // Whenever the edit area changes we want to be notified too.
    // Avoid recreating the notification function (fired in the scope of the edit area)
    _canvasContentsChanged : function (oldValue, newValue) {
        this.creator._valueChanged(oldValue, newValue);
    }
});

//!>Deferred
isc.RichTextEditor.addProperties({

    
	dragStartDistance:1,


    // On init, create our toolbar / RichTextCanvas contents area.
    initWidget : function () {
        this.Super("initWidget", arguments);
        this.createChildren();
    },
        
    //> @method RichTextEditor.doWarn()
    // Display a warning if Rich Text Editing is not fully supported in this browser.
    // Default behavior logs a warning to the devloper console - Override this if a user-visible
    // warning is required 
    // @visibility external
    //<
    doWarn : function () {
        isc.logWarn("Warning: Not all Rich Text Editing features are supported in this browser.");
    },

    createChildren : function () {
        // call on a delay to avoid this warning dialog being trapped by the FE as a managed
        // component that gets destroyed when the example is unloaded.  Leads to a crash as we
        // try to reuse the destroyed object.
        if (!this.richEditorSupported()) this.delayCall("doWarn");
    
        if (!this.autoChildDefaults) this.autoChildDefaults = {};
    
        // Set up the default width / click handler for control buttons
        
        
        this.autoChildDefaults.width = this.controlButtonWidth;
        this.autoChildDefaults.click = 
            "if (this.isControl && isc.isA.StatefulCanvas(this)) this.creator.fireAction(this.controlName)";
    
        if (this.toolbarHeight > 0) this._createToolbar();
        
        this.addAutoChild("editArea", 
                           {  top:this.toolbarHeight, className:this.editAreaClassName,
                              backgroundColor:this.editAreaBackgroundColor,
                              left:0, width:"100%", height:"*",
                              contents:this.value,
                              // This ensures the tabIndices match when the thing is first
                              // written out
                              getTabIndex:function () {
                                if (this.parentElement) return this.parentElement.getTabIndex()
                                return -1;
                              },
                              changed : isc.RichTextEditor._canvasContentsChanged,
                              
                              getBrowserSpellCheck : function () {
                                return this.parentElement.getBrowserSpellCheck()
                              }   

                           });
    },
    
    //> @method RichTextEditor.richEditorSupported()
    // Does this browser support the full RichTextEditor feature set.
    // Returns false for browsers in which some features are not natively supported
    // - currently Safari and Opera.
    // @return (boolean) false if this browser doesn't fully support RichTextEditing
    // @visibility external 
    //<
    richEditorSupported : function () {
        return !(isc.Browser.isSafari || isc.Browser.isOpera);
    },
    // browserSpellCheck is a boolean property to enable / disable native browser checking of
    // spelling, where supported.
    // This currently only has an effect in Moz
    // By default return this.browserSpellCheck if specified. Overridden for RichTextItems.
    getBrowserSpellCheck : function () {
        return this.browserSpellCheck;
    },
    
    // Toolbar   
    
    _createToolbar : function () {
        // Picks up HLayout constructor from this.toolbarConstructor
        this.addAutoChild("toolbar", {
            top:0, left:0,
            width:"100%", height:this.toolbarHeight,
            // Make the toolbar overflow:"visible" - if it exceeds the availableSpace we'll allow
            // the editor itself to decide whether it should be clipped
            overflow:isc.Canvas.VISIBLE,
            backgroundColor:this.toolbarBackgroundColor
        });
        
        // this.controlGroups is an array of groups to show.
        // each group is an array of controls to create (within the group).
        for (var i = 0; i < this.controlGroups.length; i++) {

            // Add separators between the groups.
            if (i > 0) 
                this.toolbar.addMember(this._createToolbarSeparator());

            var controlNames = this[this.controlGroups[i]];
            if (!controlNames) {
                this.logWarn("Unable to find countrol group '" + this.controlGroups[i] + 
                            "'. This group should be specified as an array of " +
                            "control names, but is not present");
                continue;
            }
            for (var j=0; j < controlNames.length; j++) {
                // use 'addAutoChild' to create the controls and add them to the toolbar as 
                // children.
                
                this.addAutoChild(
                    controlNames[j], 
                    // These properties used by the default click handler for controls
                    {canFocus:false, isControl:true, controlName:controlNames[j], 
                     layoutAlign:isc.Canvas.CENTER}, 

                    this.defaultControlConstructor, 
                    this.toolbar
                );
            }
        }
    },

    // Separator bar to write between control groups    
    _createToolbarSeparator : function () {
        if (!this._separatorProps) this._separatorProps = {
            autoDraw:false,
            width:12,
            height:"100%",
            src:this.toolbarSeparatorSrc
        };
        return isc.Img.create(this._separatorProps);
    },
    
    // For tabbing / focussing purposes, this editor should pass straight through to the
    // editArea
    setFocus : function (newFocus) {
        var editArea = this.editArea;
        if (!editArea) return;
        return editArea.setFocus(newFocus);
    },
    
    
    _setTabIndex : function (tabIndex, auto) {
        this.Super("_setTabIndex", arguments);
        if (this.editArea) this.editArea._setTabIndex(this.getTabIndex(), auto);
    },
    
    // For the font / font-size selector, we want to show a "choose font" type prompt rather 
    // than an empty selector.
     
    _makeFontMap : function(prompt, options) {
        // Add the empty 'select a font size' message and return
        var map = { _prompt:prompt };
        
        return isc.addProperties(map, options);
    },
    
    _makeFontNamesMap : function () {
        return this._makeFontMap("Set Font ...", this.fontNames);
    },
    _makeFontSizesMap : function () {
        return this._makeFontMap("Set Font Size ...", this.fontSizes);    
    },

    
    // Special constructor functions for font / font-size selector controls
    
    fontSelector_autoMaker : function (properties) {
        isc.addProperties(
            properties, 
            {   numCols:1,  cellPadding:1,
                items:[
                    // Disable tabbing into the select items
                    
                    {type:"select", name:"fontname", showTitle:false, tabIndex:-1,
                     
                     pickListProperties : {
                        cellHeight:16,
                        // Override 'getCellValue' to preview the font.
                        getCellValue : function (record, recordNum, fieldNum) {
                            var val = this.Super("getCellValue", arguments),
                                fontName = record ? record.fontname : null;
                            if (fontName && fontName != "_prompt") {
                                val = "<SPAN style='font-family:" + fontName + ";'>" + val + "</SPAN>";
                            }
                            return val;
                        }
                     },
                     
                     defaultValue:"_prompt",
                     valueMap:this._makeFontNamesMap(),
                     
                     pickValue : function(value) {
                        this.Super("pickValue", arguments);                     
                        if (value != "_prompt") {
                            this.form.creator.fireAction('setSelectionFont', value);
                        }
                     }                    
                    }
                ]}
        );
        
        return this.createAutoChild("fontSelector", properties);
    },    
    
    
    fontSizeSelector_autoMaker : function (properties) {
        isc.addProperties(
            properties, 
            {   numCols:1,  cellPadding:1,
                items:[
                    {type:"select", name:"fontsize", showTitle:false, tabIndex:-1,
                    
                     defaultValue:"_prompt",                     
                     valueMap:this._makeFontSizesMap(),
                     // See comments in fontSizeSelector_autoMaker for why we override
                     // pickValue rather than implementing a change handler.
                     pickValue : function(value) {
                        this.Super("pickValue", arguments);
                        if (value != "_prompt") {
                            this.form.creator.fireAction('setSelectionFontSize', value);
                        }
                     }                        
                    }
            ]}
        );
        
        return this.createAutoChild("fontSizeSelector", properties);
    },    
    

    //>@method    RichTextEditor.fireAction  
    // This method takes 2 parameters - an "action" (string) and an optional "param" parameter 
    // (can by anything).
    // It will attempt to call action() on the its editArea, which is a RichTextCanvas instance,
    // passing in the 'param' as a parameter.
    // (No-ops if this.editArea.action is not a method).
    //<
    fireAction : function (action, param) {
        var editArea = this.editArea;
        if (!editArea || !action || !editArea[action] || !isc.isA.Function(editArea[action])) 
            return;
            
        this.editArea[action](param);
    },
    
    // Special handlers for picking colors:
    // Use a colorChooser widget (for both setting text and background colors)
    // ColorChooser has been superseded by ColorPicker
    chooseColor : function (selectingTextColor) {
        this.colorChooser = isc.ColorPicker.getSharedColorPicker({
            creator:this,
            ID:this.getID() + "_colorChooser",
            // Avoid showing the auto / transparent button for picking a null color
            
            showNullValue:false,
            colorSelected : function (color) {
                this.creator._colorSelected(color);
            },
            
            // Override cancel to put focus back into the edit area
            cancel : function () {
                this.Super("cancel", arguments);
                this.creator.editArea.focus();
            }
        })    
        
        this._selectingTextColor = selectingTextColor;
        this.colorChooser.show();
    },
    
    _colorSelected : function (color) {
        var action = this._selectingTextColor ? "setSelectionColor" 
                                              : "setSelectionBackgroundColor";
        delete this._selectingTextColor;
        this.fireAction(action, color);
    },
    
    chooseTextColor : function () {
        this.chooseColor(true);
    },

    chooseBackgroundColor : function () {
        this.chooseColor(false);
    },
    
    // Creating links
    createLink : function () {
        var editor = this;
        isc.askForValue("Hyperlink URL:", function (value) {
            if (value == null) return;
            editor.fireAction("createLink", value);
        }, { defaultValue: "http://", width: 320 });
    },
    
    // Retrieving / updating content:
    
    _valueChanged : function (oldValue, newValue) {
        if (this.valueChanged) this.valueChanged(oldValue, newValue);
    },

    //>@method  RichTextEditor.valueChanged()
    //  StringMethod fired when the user edits the editor's value. Will not be fired in 
    //  response to an explicit <code>setValue</code> call.
    //  @param  oldValue    Value before the edit
    //  @param  newValue    Value now
    //<
    
    
    
    //>@method  RichTextEditor.getValue()
    //  Retrieves the current value of the edit area.
    // @visibility external
    //<
    getValue : function () {
        if (this.editArea) this.value = this.editArea.getContents();
        return this.value;
    },
    
    //>@method  RichTextEditor.setValue()
    //  Updates the current value of the edit area.
    // @visibility external
    //<
    setValue : function (newValue) {
        this.value = newValue;
        if (this.editArea) this.editArea.setContents(this.value);
    }
    
});
//!<Deferred


isc.RichTextEditor.registerStringMethods({
    valueChanged : "oldValue,newValue"
});
