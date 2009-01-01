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


// Class will not work without DynamicForm
if (isc.DynamicForm) {

//> @class PropertySheet
//
// Editor with a minimalist appearance, tuned for editing large numbers of properties in a
// constrained space.
//
// @treeLocation Client Reference/Forms
//
// @visibility external
//<
isc.defineClass("PropertySheet", "DynamicForm").addProperties({

    autoChildItems:true,
    
    // Don't show 'spelling errors' - this is used to edit the properties of form items, etc
    browserSpellCheck:false,

    // for all FormItems
    autoChildDefaults : {
	    cellStyle:"propSheetValue",
    	titleStyle:"propSheetTitle",
        showHint:false
    },

    // borders don't look particular good around GroupItems
    GroupItemDefaults : {
	    cellStyle:null
    },

    ExpressionItemDefaults : {
        width:"*",
    	height:18,
        showActionIcon:true
    },
    ActionMenuItemDefaults : {
        width:"*",
        height:18
    },
    

    SelectItemDefaults : {
        controlStyle:"propSheetSelectControl",
    	pickListProperties:{cellHeight:16, border:"1px solid black"},
    	height:20,
	    width:"*",
        pickerIconHeight:15, pickerIconWidth:15,
        pickerIconSrc:"[SKIN]/DynamicForm/PropSheet_pickbutton.gif",
        showOver:false
    },

    DateItemDefaults : {
        width:"*"
    },

    TextItemDefaults : {
    	width:"*",
	    height:16,
    	textBoxStyle:"propSheetField"
    },

    
    ColorItemDefaults : {
    	width:"*",
	    height:16,
        pickerIconHeight:16, pickerIconWidth:16,
        pickerIconSrc:"[SKIN]/DynamicForm/PropSheet_ColorPicker_icon.png",
    	textBoxStyle:"propSheetField"
    },

    HeaderItemDefaults : {
	    cellStyle:"propSheetHeading"
    },

    TextAreaItemProperties : {width:"*"},

    // place labels on left
    CheckboxItemDefaults : {
        showTitle:true, 
        showLabel:false,
        getTitleHTML : function () { // NOTE: copy of FormItem.getTitle()
            if (this[this.form.titleField] != null) return this[this.form.titleField];
            return this[this.form.fieldIdProperty];
        }
    },
    
    // Apply a different cellStyle to sectionItems - we don't want the 1px border around them
    SectionItemDefaults : {
        cellStyle:"propSheetSectionHeaderCell"
    },

    titleAlign:"left",
	titleWidth:120,
	cellSpacing:0,
	cellPadding:0,
	backgroundColor:"white",
	requiredTitlePrefix:"<span style='color:green'>",
	requiredTitleSuffix:"</span>",
	titleSuffix:"",
    clipItemTitles:true

});

}
