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



//
// This script will load all of the Isomorhic SmartClient Application Framework libraries for you
//
// The idea is that in your app file you can just load the script "Isomorphic_SmartClient.js" which
// in a production situation would be all of the scripts jammed together into a single file.
//
// However, it's easier to work on the scripts as individual files, this file will load all of the
// scripts individually for you (with a speed penalty).
//		
var libs = 
	[
		"widgets/TableResizePolicy",	// code to resize a set of elements in two dimensions
		"widgets/ButtonTable",			// table of cheapie buttons (very low resource use) -- in Nav, they look like links
		"widgets/DateChooser",			// a date picker

        "widgets/Slider",             	// graphical slider widget (uses isc.Img and isc.StretchImg)

        "widgets/ScrollingMenu",        // specialized listViewer with menu type event-handling 
                                        // behaviour, but scrollable and ready for data-binding
        		
		"widgets/form/DynamicForm",		// dynamically redrawable form
		"widgets/form/FormItem",		// abstract sub-item of a form
		"widgets/form/FormItemFactory",	// singleton object that creates FormItems from object literals
		"widgets/form/Validators",		// validators for form fields
		"widgets/form/ContainerItem",	// abstract form item that can contain other formItems
		
		"widgets/form/CanvasItem",		// FormItem that contains a Canvas

		"widgets/form/TextItem",		// single-line text field
		"widgets/form/BlurbItem",		// static text display
		"widgets/form/ButtonItem",		// button form item

        "widgets/form/PickList",        // Pick-List for use in select
		"widgets/form/SelectItem",		// select item -- drop-down list
		"widgets/form/NativeSelectItem",// select item rendered using native select element
        
		"widgets/form/CycleItem",	// item for moving through a valueMap via single clicks
		"widgets/form/CheckboxItem",	// checkbox item
        "widgets/form/NativeCheckboxItem", // checkbox item rendered using native checkbox element

		"widgets/form/HeaderItem",		// section header
		"widgets/form/SectionItem",		// section header for group that shows/hides group
		"widgets/form/HiddenItem",		// hidden field
		"widgets/form/StaticTextItem",	// static text (label)
		"widgets/form/LinkItem",	    // HTML link
		"widgets/form/PasswordItem",	// password-entry field (masked characters)        
		"widgets/form/RadioGroupItem",	// set of radio buttons acting as a group
		"widgets/form/RadioItem",		// single radio button
		"widgets/form/ResetItem",		// reset button

		"widgets/form/DateItem",		// multi-part Date editor
		"widgets/form/SpacerItem",		// spacer
		"widgets/form/RowSpacerItem",	// separator
		"widgets/form/SubmitItem",		// submit button
		"widgets/form/TextAreaItem",	// multi-line text field
        
        "widgets/form/AutoFitTextAreaItem",    // Text area item which expands to fit its content
        
		"widgets/form/TimeItem",		// edit a isc.Time value
		"widgets/form/ToolbarItem",		// collection of form buttons
		"widgets/form/UploadItem",		// file-upload widget

		"widgets/form/ComboBoxItem",	// combobox (text field + button + filtered listViewer)

        "widgets/form/FileItem",        // fileitem based on canvasItem that creates a new form with
                                        // uploadItem                                        
        // INFA		
		"widgets/form/RelationItem",	// canvasItem-based relation item
        
        "widgets/form/MultiFileItem",	// relationItem-based multi-upload widget

        "widgets/form/DialogUploadItem",
        "widgets/form/SOAPUploadItem",
        // INFA

        "widgets/form/SpinnerItem",      // Form item for Number type data - includes icons to
                                         // increase / decrease the values.
        "widgets/form/SliderItem",      // Form item that containing a slider to manage values

        "widgets/form/ColorItem",      // Form item used to modify colors

        

        "widgets/form/PickTreeItem",    // This form item shows a tree-menu so you can pick from a hierachy of choices

		"widgets/form/PopUpTextAreaItem",	// Shows a floating textArea.  Can be used in ListGrid editing.
        "widgets/form/ExpressionItem",  // string methods or functions
        

        //"widgets/Editor",				// deprecated old-style inline editing: Editor
                                        // Interface and a couple of implementations

		"widgets/form/SearchForm",       // simple subclass of dynamicForm to be used in filters and 
                                        // search forms in applications

        //>ValuesManager
        "widgets/form/ValuesManager",   // values manager for values from multiple member forms
        //<ValuesManager

    	
        "widgets/ColorPicker",     // Helper for picking colors - supersedes the old ColorChooser

                
	];

//<STOP PARSING 

// The following code only executes if the script is being dynamically loaded.

// the following statement allows a page that is not in the standard location to take advantage of
// dynamically loaded scripts by explicitly setting the window.isomorphiDir variable itself.
if (! window.isomorphicDir) window.isomorphicDir = "../isomorphic/";

// dynamic loading
function iscLoadLibs() {
	for(var i=0,l=libs.length;i<l;i++) {
		if (!libs[i]) continue;
		if (window.UNSUPPORTED_BROWSER_DETECTED == true) break;
		document.write("<"+"SCRIPT SRC=" + window.isomorphicDir + "system/" + libs[i]+".js><"+"/SCRIPT>");
	}
	window.defaultStatus = "";
}
iscLoadLibs();
