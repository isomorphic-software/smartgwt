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

 





//>	@class	DynamicForm
//
// The DynamicForm manages a collection of FormItems which represent user input controls.  The
// DynamicForm provides layout, value management, validation and databinding for the controls
// it manages.
// <P>
// To create a DynamicForm, set +link{dynamicForm.fields} to an Array of Objects describing the
// FormItems you want to use.  For example:
// <pre>
//    isc.DynamicForm.create({
//        fields:[
//            {name:"userName", type:"text"},  // creates a TextItem
//            {name:"usState", type:"select"}  // creates a SelectItem
//        ]
//    })
// </pre>
// The item <code>name</code> is an identifier for the item that must be unique just within
// this form.  It is used:
// <ul>
// <li> as the property name under which the item's value is stored in the form (the form's
//      current values are accessible as +link{dynamicForm.getValues,form.getValues()}
// <li> when retrieving the FormItem's current value (via
//      +link{dynamicForm.getValue,form.getValue()}) 
// <li> to retrieve the item itself via +link{dynamicForm.getItem(),form.getItem()}
// </ul>
// The item <code>type</code> controls what kind of FormItem is created.  See
// +link{type:FormItemType}.
// <P>
// The +link{formItem.title,title} and +link{formItem.defaultValue,defaultValue} are also
// commonly specified.  All FormItems share a common set of properties for controlling
// +link{group:formLayout,form layout}.  Other properties common to all FormItems are
// documented on the +link{FormItem} class, and properties specific to particular FormItems are
// documented on the respective FormItems.  
// <P>
// NOTE: For very simple forms consisting of exactly one item, you still use a DynamicForm.
// See the "fontSelector" form in the +explorerExample{toolstrip,Toolstrip example}.
//
//  @implements DataBoundComponent    
//  @treeLocation Client Reference/Forms
//  @visibility external
//<

// create the form as a descendant of the Canvas
isc.ClassFactory.defineClass("DynamicForm", "Canvas");

// Synonym for use by ValuesManagers working with distributed 'FormLayouts'
isc.addGlobal("FormLayout", isc.DynamicForm);


//> @groupDef items
// Manipulating the items that belong to a form.
// <BR><br>
// An item manages an atomic value (eg a String, Number, Date, etc) that appears as one of the
// properties in the overall form's values.  Some items exist purely for layout or appearance
// purposes (eg SpacerItem) and do not manage a value.
// @title Form Items
// @visibility external
//<

//> @groupDef tableLayout
// Manipulating the values stored in the form.
// @visibility external
//<

//> @groupDef values
// Manipulating the values stored in the form.
// @visibility external
//<

//> @groupDef valueMap
// A +link{type:ValueMap} defines the set of legal values for a field, and optionally allows you to provide
// a mapping from stored values to values as seen by the end user.
//
// @visibility external
//<

//> @groupDef validation
// Validation
// @visibility external
//<

//> @groupDef formTitles
// Properties that affect form item title placement and styling.
// @title Form Titles
// @visibility external
//<

//> @groupDef errors
// Validation errors and how they are shown
// @visibility external
//<

//> @groupDef submitting
// Direct submission of forms to a target URL
// <P>
// <b>NOTE:</b> directly submitting forms is only done for specialized purposes, such as
// integration with certain legacy systems.  Normal form usage contacts the server via 
// +link{group:dataBoundComponentMethods,DataBound Component Methods}, through the RPCManager system.
// @visibility external
//<

//> @groupDef elements
// Manipulating native form elements
//<


// add constants
isc.DynamicForm.addClassProperties({
    

	//>	@type	FormMethod
	//			Form METHOD parameters - how the form fields are submitted to the server
	GET:"GET",							//	@value	isc.DynamicForm.GET		GET request -- URL encoding (~4K max)
	POST:"POST",						//	@value	isc.DynamicForm.POST	POST request -- separate field encoding (no max)
	//			@visibility external
	//			@group	submitting
	//<

	//>	@type	Encoding
	// Form encodying types - these translate to Form ENCTYPE parameters.
    // @value DynamicForm.NORMAL    normal form encoding ("application/x-www-form-urlencoded")
	NORMAL:	"normal",	     
    // @value DynamicForm.MULTIPART form encoding for forms with INPUT file elements, that is, forms
    //                              that upload files ("multipart/form-data")
	MULTIPART:	"multipart", 
	//			@group	submitting
	//			@visibility external
	//<
    // NOTE: EncodingTypes has the values that we actually write into the form in HTML.

	//>	@type	EncodingTypes
	// Form ENCTYPE parameters - how data is encoded when sent to the server.
    // See:  http://www.w3.org/TR/html4/interact/forms.html#adef-enctype
	//			@group	submitting
    // normal form encoding 
	NORMAL_ENCODING:	"application/x-www-form-urlencoded",
    // multipart encoding for file upload
	MULTIPART_ENCODING:	"multipart/form-data",
	//<
    
    // Attributes written into containers for form items / form item elements
    _containsItem : "_containsItem",
    _itemPart : "_itemPart",
    // Options for the itemPart setting
    _element : "_element",
    _textBoxString : "_textBox",
    _controlTableString : "_controlTable",
    _title : "_title"
    	
});



isc.DynamicForm.addProperties({
 
    // Basic Definition: items and values   
	// --------------------------------------------------------------------------------------------

    //>	@attr	dynamicForm.items		(Array of FormItem Properties : null : [IRW])
    // Synonym for +link{attr:dynamicForm.fields}
    // 
    // @see attr:dynamicForm.fields
    // @group items
    // @setter setItems()
    // @visibility external
    //<
    
    //> @attr dynamicForm.fields (Array of FormItem Properties : null : [IRW])
    // An array of field objects, specifying the order, layout, and types of each field in the
    // DynamicForm.
    // <p>
    // When both <code>dynamicForm.fields</code> and <code>dynamicForm.dataSource</code> are
    // set, <code>dynamicForm.fields</code> acts as a set of overrides as explained in
    // +link{attr:DataBoundComponent.fields}.
    // <P>
    // See +link{group:formLayout,Form Layout} for information about how flags specified on
    // the FormItems control how the form is laid out.
    //
    // @see class:FormItem
    // @setter setFields()
    // @group items
    // @visibility external
    //<

    //>	@attr	dynamicForm.defaultItems    (Array of FormItem Properties : null : [ARW])
    // An array of FormItem objects, defining the default set of elements this form 
    // creates. (Typically set at a class level on the instance prototype).
    // @group items
    //<
    // NOTE: not external; used for making specialized form subclasses

    //>	@attr	dynamicForm.values		(Object : null : [IRW])
    // An Object containing the initial values of the form as properties, where each
    // propertyName is the name of a +link{items,form item} in the form, and each property
    // value is the value held by that form item.
    // <P>
    // The form's values may contain values that are not managed by any FormItem, and these
    // values will be preserved and available when the form values are subsequently retrieved
    // via +link{getValues()}.
    // <P>
    // Providing values on initialization is equivalent to calling +link{setValues()}.
    // <P>
    // As the user manipulates form items to change values, change events fire
    // +link{formitem.change,on the items} and 
    // +link{dynamicForm.itemChange,on the form as a whole}.
    // <P>
    // Note that form values are logical values, for example, the value of a +link{DateItem} is
    // a JavaScript Date object, not a String, even if the user enters the date via a text
    // input.  Likewise the value of a +link{TextItem} or +link{CheckboxItem} that started out
    // null remains null until the user changes it; the value will not be automatically
    // converted to the null string ("") or false respectively, as happens with native HTML
    // elements.
    //
    // @group formValues
    // @visibility external
    //<
    
    // Table Layout
	// --------------------------------------------------------------------------------------------
 
    //> @groupDef formLayout
    // <b>FormItem Placement in Columns and Rows</b>
    // <P>
    // With the default tabular layout mechanism, items are laid out in rows from left to
    // right until the number of columns, specified by +link{dynamicForm.numCols,form.numCols},
    // is filled, then a new row is begun.  Flags on FormItems, including
    // +link{FormItem.startRow,startRow}, +link{FormItem.endRow,endRow},
    // +link{FormItem.colSpan,colSpan} and +link{FormItem.rowSpan,rowSpan}, control row and
    // column placement and spanning.  
    // <P>
    // Note that the most common form items (TextItem, SelectItem, etc) take up <b>two</b>
    // columns by default: one for the form control itself, and one for it's title.  The
    // default setting of +link{dynamicForm.numCols,form.numCols:2} will result in one TextItem
    // or SelectItem per row.
    // <P>
    // Note also that ButtonItems have both startRow:true and endRow:true by default.  You must
    // set startRow and/or endRow to <code>false</code> on a ButtonItem in order to place a
    // button in the same row as any other item.
    // <P>
    // The log category "tablePlacement" can be enabled from the Developer Console to watch
    // items being placed.  You can also set +link{dynamicForm.cellBorder,form.cellBorder:1} to
    // reveal the table structure for layout troubleshooting purposes.
    // <P>
    // <b>Row and Column Sizing</b>
    // <P>
    // +link{DynamicForm.colWidths} controls the widths of form columns.  FormItems that have
    // "*" for +link{formItem.width} will fill the column.  FormItems with a numeric width will
    // have that width in pixels regardless of the column's specified width, which may cause the
    // column to overflow as described under +link{DynamicForm.fixedColWidths}.
    // <P>
    // For row heights, the largest pixel height specified on any item in the row is taken as a
    // minimum size for the row.  Then, any rows that have "*" or "%" height items will share
    // any height not taken up by fixed-sized items.
    // <P>
    // <b>Managing Overflow</b>
    // <P>
    // Forms often contain labels, data values, or instructional text which can vary in
    // size based on the skin, data values, or internationalization settings.  There are a few
    // ways to deal with a form potentially varying in size:
    // <ol>
    // <li> Allow scrolling when necessary, using +link{Canvas.overflow,overflow:auto}, either
    // on the immediate form, or on some parent.
    // <li> Place the form in a Layout along with a component that can render any specified
    // size, such as a +link{ListGrid}.  In this case, the Layout will automatically shrink the
    // grid in order to accomodate the form.
    // <li> Ensure that the form can always render at a designed minimum size by reducing
    // the number of cases of variable-sized text, and testing remaining cases across all
    // supported skins.  For example, move help text into hovers on help icons, or clip 
    // long text values at a maximum length and provide a hover to see the rest.
    // </ol>
    //
    // Several examples of Form Layout are available +explorerExample{formsLayout,here}.
    //
    // @treeLocation Client Reference/Forms
    // @title Form Layout
    // @visibility external
    //<
    

    //> @attr dynamicForm.itemLayout   (FormLayoutType : "table" : IRWA)
    // Layout style to use with this form.  
    // <P>
    // The default of "table" uses a tabular layout similar to HTML tables, but with much more
    // powerful control over sizing, item visibility and reflow, overflow handling, etc.
    // <P>
    // <code>itemLayout:"absolute"</code> allows absolute positioning of every form item.  This
    // provides maximum flexibility in placement, with the following limitations:<ul>
    // <li> titles, which normally take up an adjacent cell, are not shown.  Use
    //      StaticTextItems to show titles
    // <li> no automatic reflow when showing or hiding items.  +link{method:FormItem.setLeft()}
    //      and +link{method:FormItem.setTop()} can be used for manual reflow.
    // <li> only pixel and percent sizes are allowed, no "*".  Percent widths mean percentage
    //      of the overall form size rather than the column size
    // <li> with different font styling or internationalized titles, items may overlap that did
    //      not overlap in the skin used at design time
    // </ul>
    //
	// @group formLayout
    // @visibility absForm
    //<
    //itemLayout:"table",

    //> @attr dynamicForm.flattenItems (boolean : false : IR)
    // If set, the form will set +link{numCols} automatically such that all form items will be
    // laid out in a single row.
    // <P>
    // +link{colWidths} may still be set.  If unset, they will be generated so that all columns
    // showing a title will have +link{titleWidth} and all other columns will have width:"*".
    //
    // @group formLayout
    //<
    flattenItems:false,
   
    //>	@attr	dynamicForm.numCols		(number : 2 : [IRW])
    // The number of columns of titles and items in this form's layout grid. A title and
    // corresponding item each have their own column, so to display two form elements per
    // row (each having a title and item), you would set this property to 4.
    //
    // @group tableLayout
    // @visibility external
    //<
	numCols:2,
    
    //>	@attr	dynamicForm.fixedColWidths	(boolean : false : IRW)
	// If true, we ensure that column widths are at least as large as you specify them.  This
    // means that if any single column overflows (due to, eg, a long unbreakable title),
    // the form as a whole overflows.
    // <P>
	// If false, columns will have their specified sizes as long as no column overflows.  If
    // any column overflows, space will be taken from any other columns that aren't filling the
    // available room, until there is no more free space, in which case the form as a whole
    // overflows.
    // 
	// @group tableLayout
    // @visibility external
	//<
    
	fixedColWidths:false,
    
    // fixedRowHeights - undocumented property that causes heights to be written into cells, 
    // which, like fixedColumnWidths, puts you into a situation where you're more likely to 
    // overflow. 
    fixedRowHeights:false,

    //>	@attr	dynamicForm.colWidths		(Array : null : [IRW])
    // An array of widths for the columns of items in this form's layout grid. 
    // <P>
    // If specified, these widths should sum to the total width of the form (form.width).
    // If not specified, we assume every other column will contain form item titles, and so
    // should have <code>form.titleWidth</code>, and all other columns should share the
    // remaining space.
    // <P>
    // Acceptable values for each element in the array are:<br>
    // <ul>
    // <li>A number (e.g. 100) representing the number of pixel widths to allocate to a
    //     column.
    // <li>A percent (e.g. 20%) representing the percentage of the total form.width to
    //     allocate to a column.
    // <li>"*" (all) to allocate remaining width (form.width minus all specified column
    //     widths). Multiple columns can use "*", in which case remaining width is divided
    //     between all columns marked "*".
    // </ul>
    // @group tableLayout
    // @visibility external
    // @example columnSpanning
    //<
	colWidths:null,
    
    //>	@attr	dynamicForm.minColWidth		(number : 20 : IRW)
	// Minimum width of a form column.
	// @group tableLayout
    // @visibility external
	//<
	minColWidth:20,

    //>	@attr	dynamicForm.cellSpacing		(number : 0 : [IRW])
    // The amount of empty space, in pixels, between form item cells in the layout grid.
    // @group tableLayout
    // @visibility internal
    //<
    
	cellSpacing:0,
    
    //>	@attr	dynamicForm.cellPadding		(number : 2 : [IRW])
    // The amount of empty space, in pixels, surrounding each form item within its cell in
    // the layout grid.
    // @group tableLayout
    // @visibility external
    //<
	cellPadding:2,
    
    //>	@attr	dynamicForm.cellBorder		(number : 0 : [IRW])
    // Width of border for the table that form is drawn in. This is primarily used for debugging
    // form layout.
    // @group tableLayout
    // @visibility external
    //<
	cellBorder:0,

    // default height for a table row where there are no specified sizes at all (pixel, '*', or
    // percent)
    defaultRowHeight:22,

    //> @attr DynamicForm.sectionVisibilityMode (VisibilityMode : "multiple" : [IRW])
    // If the form has sections, [implemented as +link{SectionItem}s], this attribute controls
    // whether multiple sections can be expanded at once.
    //
    // @see type:VisibilityMode
    // @see class:SectionItem
    // @group tableLayout
    // @visibility external
    //<
    sectionVisibilityMode: "multiple",

    // Embedded widgets
    // --------------------------------------------------------------------------------------------
    // Turn on allowContentAndChildren for Canvas Items.
    // NOTE: this has no actual effect unless a CanvasItem is used
    
    allowContentAndChildren : true,
    separateContentInsertion: true,
    _avoidRedrawFlash:true,
    // necessary because the default determination assumes anything with children doesn't have
    // inherent height
    hasInherentHeight : function () {
        if (this.inherentHeight != null) return this.inherentHeight;
        return (this.overflow == isc.Canvas.VISIBLE || this.overflow == isc.Canvas.CLIP_H);
    },

    // DataBinding
	// --------------------------------------------------------------------------------------------
    //>	@attr	dynamicForm.fieldIdProperty		(string : "name" : IRWA)
	// Name of the column in the fields array that holds the name of the item property that holds
    // the value
	//		@group	data
	//<
	fieldIdProperty:"name",		

    //>	@attr	dynamicForm.titleField		(string : "title" : IRWA)
	// Name of the column in the fields array that holds the name of the title property that holds
    // the title
	//		@group	appearance
	//<
	titleField:"title",

    //>	@attr	dynamicForm.showDetailFields (boolean : true : IR)
	// For databound forms, whether to show fields marked as detail fields.
	//<
    showDetailFields: true,

    //>	@attr dynamicForm.longTextEditorThreshold (number : 255 : IRW)
	// When creating form items for fields with text type data, if the specified length of the
    // field exceeds this threshold we will create form item of type 
    // <code>this.longTextEditorType</code> (a TextAreaItem by default), rather than a simple
    // text item.  Overridden by explicitly specifying <code>editorType</code> for the field. 
	// @group appearance
    // @visibility external    
	//<
	longTextEditorThreshold:255,
    //>	@attr dynamicForm.longTextEditorType (string  : "textArea" : IRW)
	// Name of the Form Item class to use for text fields which exceed the 
    // longTextEditorThreshold for this form. 
	// @group appearance
    // @visibility external
	//<
    longTextEditorType:"textArea",
    
    //>ValuesManager
    
    // ValuesManager
    // ----------------------------------------------------------------------------------------
    //>@attr dynamicForm.valuesManager  (ValuesManager instance or global ID : null : [IA])
    // If set at init time, this dynamicForm will be created as a member form for the
    // specified valuesManager.  To update the valuesManager to which a form belongs after init
    // use <code>valuesManager.addMember(form)</code> and 
    // <code>valuesManager.removeMember(form)</code>
    // @see class:ValuesManager
    // @visibility external
    // @group formValuesManager
    //<
    //<ValuesManager
    

    // Title Formatting
	// --------------------------------------------------------------------------------------------

    //> @type  TitleOrientation
    // Orientation of titles relative to the FormItem being labelled.  Can be set a the
    // DynamicForm level as a default, or on individual items.
    // 
    // @value  "left"
    // @value  "top"
    // @value  "right"
    // @group formTitles
    // @see DynamicForm.titleOrientation
    // @see FormItem.titleOrientation
    // @visibility external
    //<

    //>	@attr	dynamicForm.titleOrientation    (TitleOrientation : "left" : [IRW])
    // Default orientation for titles for items in this form.  +link{type:TitleOrientation}
    // lists valid options.
    // <P>
    // Note that titles on the left or right take up a cell in tabular
    // +link{group:formLayout,form layouts}, but titles on top do not.
    // 
    //      @group  formTitles
    //      @visibility external
    // @example formLayoutTitles
    //<
    
    //>	@attr	dynamicForm.titlePrefix		(string : "" : [IRW])
    //          The string prepended to the title of every item in this form.
    //      @group  formTitles
    //      @visibility external
    //<
	titlePrefix:"",
    
    //>	@attr	dynamicForm.rightTitlePrefix (string : ":&nbsp;" : [IRW])
    //          The string prepended to the title of an item in this form if its
    //          titleOrientation property is set to "right".
    //      @group  formTitles
    //      @visibility external
    //<
	rightTitlePrefix:":&nbsp;",

    //>	@attr	dynamicForm.titleSuffix		(string : "&nbsp;:" : [IRW])
    //          The string appended to the title of every item in this form.
    //      @group  formTitles
    //      @visibility external
    //<
	titleSuffix:"&nbsp;:",
    
    //>	@attr	dynamicForm.rightTitleSuffix (string : "" : [IRW])
    //          The string appended to the title of an item in this form if its titleOrientation
    //          property is set to "right".
    //      @group  formTitles
    //      @visibility external
    //<
	rightTitleSuffix:"",

    //>	@attr	dynamicForm.titleWidth		(number or "*": 100 : [IRW])
    //          The width in pixels allocated to the title of every item in this form.  If you
    //          don't specify explicit +link{attr:dynamicForm.colWidths}, you can set this
    //          value to the string "*" to divide the usable space evenly between titles and
    //          fields.
    //      @group  formTitles
    //      @visibility external
    //<
	titleWidth:100,
    
    //>	@attr	dynamicForm.clipItemTitles (boolean : false : [IRW])
    // Should the titles for form items be clipped if they are too large for the available 
    // space?<br>
    // Can be overridden for individual items via <code>formItem.clipTitle</code>
    //<
//    clipItemTitles:false,

    //>	@attr	dynamicForm.wrapItemTitles (boolean : null : [IRW])
    // Whether titles for form items should wrap.  If not specified, titles will wrap by
    // default.  Can be overridden for individual items via +link{formItem.wrapTitle}
    // @visibility external
    // @group formTitles    
    //<
    // NOTE: actual default is based on df.clipItemTitles, but that isn't documented.
//    wrapItemTitles:null,

    //> @attr   dynamicForm.showInlineErrors (boolean : true : [IRW])
    // If true, field errors are written into the form next to the item(s) where the errors
    // occurred.  Errors may appear as text or just an icon (via +link{showErrorText}:false}.
    // <P>
    // If false, errors are written at the top of the form, in the +link{errorItem}.
    // <P>
    // To do some other kind of error display, override +link{showErrors()}.
    //
    // @group validation
    // @visibility external
    //<
    showInlineErrors: true,
    
    // customization of inline errors appearance on items
    
    // showErrorIcons doc contains an overview of error styling to be reused as the docs for
    // showErrorText / showErrorStyle as well
    //> @attr dynamicForm.showErrorIcons (boolean : true : IRW)
    // +link{dynamicForm.showErrorIcons,showErrorIcons}, 
    // +link{dynamicForm.showErrorText,showErrorText}, and
    // +link{dynamicForm.showErrorStyle,showErrorStyle} control how validation errors are
    // displayed next to form items when +link{dynamicForm.showInlineErrors} is true.
    // These properties are boolean values, and can be set on a DynamicForm to control the 
    // behavior form-wide, or set on individual FormItems.
    // <P>
    // The HTML displayed next to a form item with errors is generated by 
    // +link{FormItem.getErrorHTML()}.
    // The default implemenation of that method respects <code>showErrorIcons</code> and
    // <code>showErrorText</code> as follows:
    // <P>
    // <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls
    // whether an error icon should appear next to fields which have validation errors.  The icon's
    // appearance is governed by +link{FormItem.errorIconSrc}, +link{FormItem.errorIconWidth} and
    // +link{FormItem.errorIconHeight}
    // <P>
    // <code>showErrorText</code> determines whether the text of the validation error should be
    // displayed next to fields which have validation errors. The attribute
    // +link{dynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the 
    // form item's title + <code>":"</code> (may be desired if the item has 
    // +link{formItem.showTitle} set to false).
    // <P>
    // +link{dynamicForm.errorOrientation} controls where the error HTML should appear relative 
    // to form items. Therefore the combination of +link{showErrorText}<code>:false</code> and
    // +link{errorOrientation}<code>:"left"</code> creates a compact validation error display
    // consisting of just an icon, to the left of the item with the error message
    // available via a hover (similar appearance to ListGrid validation error display).  
    // <P>
    // In addition to this, <code>showErrorStyle</code> determines whether fields  with validation
    // errors should have special styling applied to them. See +link{type:FormItemBaseStyle} for a 
    // discussion for how error styling is calculated.
    //
    // @group  validation
    // @visibility external
    //<    
    showErrorIcons: true,
    
    //> @attr dynamicForm.showErrorText (boolean : false : IRW)
    // @include dynamicForm.showErrorIcons
    // @group  validation
    // @visibility external
    //< 
    showErrorText:false,
    
    //> @attr dynamicForm.showErrorStyle (boolean : true : IRW)
    // @include dynamicForm.showErrorIcons
    // @group  validation
    // @visibility external
    //<    
    showErrorStyle: true,
    
    //> @attr dynamicForm.errorOrientation (align : "left" : IRW)
    // If +link{dynamicForm.showInlineErrors} is true, where should the error icon and text appear
    // relative to form items?  Valid options are <code>"top"</code>, 
    // <code>"bottom"</code>, <code>"left"</code> or <code>"right"</code>.<br>
    // May be overridden at the item level via +link{formItem.errorOrientation}.
    // @group validation, appearance
    // @visibility external
    //<
    errorOrientation: "left",
    
    // Enable customization of the error item
    errorItemDefaults : {
        type:"blurb",
        wrap:true,
        showIf:function () {
            return !this.form.showInlineErrors && this.form.hasErrors(); 
        },
        defaultDynamicValue : function (item,form,values) {
            return form.getErrorsHTML(form.getErrors());
        }
    },
    //> @attr dynamicForm.errorItemProperties (object : null : [IRA])
    // If +link{dynamicForm.showInlineErrors} is false we show all errors for the form item in 
    // a single item rendered at the top of the form.<br>
    // This attribute contains a properties block for this item.
    // @group validation
    // @visibility external
    //<
    //errorItemProperties : {},
    
    //> @attr dynamicForm.errorItemCellStyle (string  : "formCellError" : [IR])
    // If +link{dynamicForm.showInlineErrors} is false we show all errors for the form item in 
    // a single item rendered at the top of the form.<br>
    // This attribute specifies the cellStyle to apply to this item.
    // @group validation
    // @visibility external
    //<
    errorItemCellStyle:"formCellError",
    
    //> @attr dynamicForm.errorsPreamble (string :"The following errors were found" : [IR])
    // If +link{dynamicForm.showInlineErrors} is false we show all errors for the form item in 
    // a single item rendered at the top of the form.<br>
    // This attribute specifies an introductory string rendered out before the individual error
    // messages.
    // @group validation, i18nMessages
    // @visibility external
    //<
    errorsPreamble:"The following errors were found.",

    //>	@attr	dynamicForm.showTitlesWithErrorMessages     (boolean : false : [IRW])
    //          Indicates whether on validation failure, the error message displayed to the
    //          user should be prepended with the title for the item.
    //      @group  validation
    //      @visibility external
    //<
    // This property is referenced by 'formItem.getErrorHTML()'
//    showTitlesWithErrorMessages : false,

    //>	@attr	dynamicForm.hiliteRequiredFields		(boolean : true : IRW)
    // Indicates whether the titles of required items in this form should use the special
    // prefix and suffix specified by the next two properties, instead of the standard
    // prefix and suffix.
    //      @group  formTitles
    //      @visibility external
    //<
	hiliteRequiredFields:true,
    
    //>	@attr	dynamicForm.requiredTitlePrefix		(string : "<B>" : IRW)
    // The string prepended to the title of every required item in this form if
    // highlightRequiredFields is true.
    //      @group  formTitles
    //      @visibility external
    //<
	requiredTitlePrefix:"<B>",
    
    //>	@attr	dynamicForm.requiredRightTitlePrefix (string : "<B>:&nbsp;" : IRW)
    // The string prepended to the title of every required item in this form if
    // highlightRequiredFields is true and the titleOrientation property is set to "right".
    //      @group  formTitles
    //      @visibility external
    //<
	requiredRightTitlePrefix:"<B>:&nbsp;",

    //>	@attr	dynamicForm.requiredTitleSuffix		(string : " :</B>" : [IRW])
    // The string appended to the title of every required item in this form if
    // highlightRequiredFields is true.                                        
    //      @group  formTitles
    //      @visibility external
    //<
	requiredTitleSuffix:"&nbsp;:</B>",
    
    //>	@attr	dynamicForm.requiredRightTitleSuffix (string : "</B>" : [IRW])
    // The string appended to the title of every required item in this form if
    // highlightRequiredFields is true and the titleOrientation property is set to "right".
    //      @group  formTitles
    //      @visibility external
    //<
	requiredRightTitleSuffix:"</B>",

    // Hovers
    // ---------------------------------------------------------------------------------------
    
    // Turn off standard form item hover handling - we're doing our own custom handing instead.
    canHover:false,
    
    //> @attr dynamicForm.itemHoverDelay (number : 500 : [IRW])
    // If the user rolls over an item, how long a delay before we fire any hover action / show
    // a hover for that item?
    // @see FormItem.hoverDelay
    // @group Hovers
    // @visibility external
    //<
    itemHoverDelay:500,
    
    //> @attr dynamicForm.itemHoverWidth (measure : null : [IRW])
    // A default width for hovers shown for items
    // @see FormItem.hoverWidth
    // @group Hovers
    // @visibility external
    // @example itemHoverHTML
    //<
    
    //> @attr dynamicForm.itemHoverHeight (measure : null : [IRW])
    // A default height for hovers shown for items
    // @see FormItem.hoverHeight
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr dynamicForm.itemHoverAlign (Alignment  : null : [IRW])
    // Text alignment  for hovers shown for items
    // @see FormItem.hoverAlign
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr dynamicForm.itemHoverVAlign (measure : null : [IRW])
    // Vertical text alignment for hovers shown for items
    // @see FormItem.hoverVAlign
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr dynamicForm.itemHoverStyle (CSSStyleName  : "formHover" : [IRW])
    // CSS Style for hovers shown for items
    // @see FormItem.hoverStyle
    // @group Hovers
    // @visibility external
    //<
    itemHoverStyle:"formHover",
    
    //> @attr dynamicForm.itemHoverOpacity (number : null : [IRW])
    // Opacity for hovers shown for items
    // @see FormItem.hoverOpacity
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr dynamicForm.itemHoverRect (object : null : [IRWA])
    // Object of the form <code>{left:[value], top:[value], width:[value], height:[value]}</code>
    // for specifying an explicit position for the item hovers to appear.
    // @see FormItem.hoverRect
    // @group Hovers
    // @visibility internal
    //<
    

    // Sizing
	// --------------------------------------------------------------------------------------------

    // we can't perfectly control the drawn sizes of all form elements, hence by default we
    // show overflow.  Our defaultHeight acts as a minimum.
	overflow:isc.Canvas.VISIBLE,
    defaultHeight:20,
	
    // Validation
	// --------------------------------------------------------------------------------------------
    //>	@attr	dynamicForm.errors		(array : null : [IRW])
    //          A property list of itemName:errorMessage pairs, specifying the set of error messages
    //          displayed with the corresponding form elements. Each errorMessage may be either a
    //          single string or an array of strings.
    // @group validation
    //      @visibility external
    //<

    //>	@attr	dynamicForm.validateOnChange	(boolean : false : IRW)
	//		If true, form fields will be validated when each item's "change" handler is fired
	//		as well as when the entire form is submitted or validated.<br>
    //      Note that this property can also be set at the item level to enable finer granularity
    //      validation in response to user interaction - if true at either level, validation
    //      will occur on change.
    // @group validation
    // @visibility external
    // @see FormItem.validateOnChange
    //<
    
	validateOnChange:false,

    //>	@attr	dynamicForm.unknownErrorMessage	(string : "Invalid value" : [IRW])
    //          The error message for a failed validator that does not specify its own errorMessage.
    //      @group validation, i18nMessages
    //      @visibility external
    //<                                       
	unknownErrorMessage : "Invalid value",

    // Focus
	// --------------------------------------------------------------------------------------------

    //>	@attr	dynamicForm.autoFocus		(boolean : false : IRW)
	// If true, when the form is drawn, focus will automatically be put into the first focusable
    // element in the form.<br>
    // Note that to put focus in a different item you can explicitly call 
    // <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
	// @group focus	
    // @visibility external
    // @see focusInItem()
	//<
	autoFocus:false,						

    //>	@attr	dynamicForm.selectOnFocus	(boolean : false : IRW)
    // If this property is set to true, whenever a text based field in this form 
    // (+link{class:TextItem}, +link{class:TextAreaItem}) is given focus programmatically 
    // (see +link{DynamicForm.focusInItem()}), all text within the item will be selected.<br>
    // May be overridden at the form item level.
	// @group focus	
    // @visibility external
	//<
	selectOnFocus:false,

    //> @attr   dynamicForm.canFocus    (boolean : true : IRWA)
    // DynamicForms are considered to have focus if any of their form items have focus.
    // Note that setting <code>dynamicForm.canFocus</code> to false will have no effect on
    // whether form items within the form may recieve focus. This property will only govern
    // whether the form may recieve focus if the form contains no focusable items.
    // @group focus
    // @visibility external
    //<
    // Focus behaviour for forms is a little different than for other elements.
    // o _canFocus() always returns true if the form contains any focusable items
    //   (required to allow programmatic focus() on the form / proper keyboard event handling)
    // o Set _useNativeTabIndex to false - we don't want the form to ever have native focus (instead
    //   native focus will always go to the form items).
    //   Note - we don't want to set tabIndex to -1, as the form items will default to having their
    //   form's tabIndex as their own tabIndex.
    // o Set _useFocusProxy to false - same reason as setting _useNativeTabIndex to false.
    // o Override focus() to call focusInItem() (below)
    // o Override _focusChanged() to blur the focus item on a blur() call (below)
    // - see also comments on form item tabIndex in formItem.js
    canFocus : true,
    _useNativeTabIndex:false,
    _useFocusProxy:false,
        
    // AutoComplete
	// --------------------------------------------------------------------------------------------
    //>	@attr	dynamicForm.autoComplete   (AutoComplete : null : IRW)
    // Whether to do inline autoComplete in text fields within this form.
    // <p>
    // Can be individually enabled per TextItem, or if enabled for the form as a whole, can
    // be disabled for individual items.
    //
    // @see formItem.autoComplete
    // @group autoComplete
    // @visibility autoComplete
    //<
    //autoComplete:null     null is the same as "none": no-autoComplete
    

    //>	@attr	dynamicForm.uniqueMatch   (boolean : true : IRW)
    // When autoComplete is enabled, whether to offer only unique matches to the user.
    // <p>
    // Can be individually enabled per TextItem, or if set for the form as a whole, can
    // be set differently for individual items.
    //
    // @see formItem.uniqueMatch
    // @group autoComplete
    // @visibility autoComplete
    //<
    uniqueMatch:true,
    
    
    // Spellcheck:
    //>@attr    DynamicForm.browserSpellCheck   (boolean : true : IRW)
    // If this browser has a 'spellCheck' feature for text-based form item elements, should
    // it be used for items in this form? Can be overridden at the item level via 
    // +link{FormItem.browserSpellCheck}
    // @visibility internal
    //<
    // Only supported in Moz
    

    // NOTE:  Property exposed on our publict forum here: 
    //   http://forums.smartclient.com/showthread.php?p=552#post552
    // Comment in that post "not publically documented as not supported cross browser"
    browserSpellCheck:true,
    
    // Direct Submit
    // --------------------------------------------------------------------------------------------
    //>	@attr dynamicForm.validationURL		(URL : null : IRW)
    // validationURL can be set to do server-side validation against a different URL from where
    // the form will ultimately save, as part of an incremental upgrade strategy for Struts and
    // Struts-like applications.  
    // <P>
    // If set, calling +link{method:DynamicForm.submit()} causes an RPC to be sent to this URL to
    // perform server-side validation of the form values.  If the validation fails, the
    // validation errors returned by the server are rendered in the form.  If the validation
    // succeeds, the form is submitted to the URL specified by +link{attr:DynamicForm.action}.
    // <p>
    // The form values are available on the server as request parameters (just like a normal form
    // submit) and also as the values of a DSRequest sent as an RPC alongside the normal
    // submit.
    // <p>
    // The expected response to this request is a DSResponse sent via the RPC mechanism.  If
    // validation is successful, an empty response with the STATUS_SUCCESS status code is
    // sufficient.  If there are validation errors, the DSResponse should have the status set to 
    // STATUS_VALIDATION_ERROR and the errors should be set on the response via the
    // addError()/setErrorReport() API on DSResponse.  See the javadoc for DSResponse for
    // details.
    // <P>
    // See the Struts examples in <code>[webroot]/examples/struts</code> for usage examples.
    //
    // @group validation
    // @visibility external
    // @see DynamicForm.saveData()
    // @see DynamicForm.submit()
    //<

    //>	@attr dynamicForm.disableValidation		(boolean : null : IRW)
    //
    // If set to true, client-side validators will not run on the form when validate() is
    // called.  Server-side validatiors (if any) will still run on attempted save.
    //
    // @group validation
    // @visibility external
    // @see DynamicForm.saveData()
    // @see DynamicForm.submit()
    //<

    //> @attr dynamicForm.cancelParamName (String : "org.apache.struts.taglib.html.CANCEL" : IRW)
    // The name of the special field sent to the server as part of +link{method:DynamicForm.cancel()}
    // @visibility external
    //<
    cancelParamName: "org.apache.struts.taglib.html.CANCEL",


    //> @attr dynamicForm.cancelParamValue (String : "cancel" : IRW)
    // The value of the special field sent to the server as part of +link{method:DynamicForm.cancel()}
    // @visibility external
    //<
    cancelParamValue: "cancel",

    //>	@attr	dynamicForm.action		(string : "#" : IRW)
    // The URL to which the form will submit its values.
    // <p>
    // <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
    // directly to a URL.  Normal server contact is through RPCManager.<br>
    // See +link{DynamicForm.canSubmit} for more on this.
    //
    // @see group:operations
    // @see class:RPCManager
    //
    //      @visibility external
    //      @group  submitting
    //<
    //	XXX SHOULD SUPPORT [APP], [ISOMORPHIC], etc. special directories
    // Note: if this property is modified from the class default, and saveData() is called, 
    // the rpcManager code will perform its request as a direct submission to the action URL 
    // by setting request.directSubmit
    action:"#",

    //>	@attr	dynamicForm.target		(string : null : IRWA)
    // The name of a window or frame that will receive the results returned by the form's
    // action. The default null indicates to use the current frame.
    // <p>
    // <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
    // directly to a URL.  Normal server contact is through
    // +link{group:dataBoundComponentMethods,DataBound Component Methods}.
    //      @group  submitting
    //      @visibility external
    //<
    
    //>	@attr	dynamicForm.method		(FormMethod : isc.DynamicForm.POST : [IRW])
    // The mechanism by which form data is sent to the action URL. See FormMethod type
    // for details.
    // <p>
    // <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
    // directly to a URL.  Normal server contact is through 
    // +link{group:dataBoundComponentMethods,DataBound Component Methods}.
    //      @group  submitting
    //      @visibility external
    //<
	method:isc.DynamicForm.POST,
    
	//>	@attr	dynamicForm.encoding		(Encoding : DynamicForm.NORMAL : IRWA)
	// encoding for the form, use MULTIPART_ENCODING for file upload forms
	// @group submitting
    // @visibility external
	//<
	encoding:isc.DynamicForm.NORMAL_ENCODING,

    //>	@attr	dynamicForm.canSubmit		(boolean : false : IRWA)
    // Governs whether this form will be used to perform a standard HTML form submission.
    // Note that if true, +link{DynamicForm.submit()} will perform a native HTML submission
    // to the specified +link{DynamicForm.action} URL.<br>
    // Wherever possible we strongly recommend using the 
    // +link{group:dataBoundComponentMethods,DataBound Component Methods} to send data to
    // the server as they provide a far more sophisticated interface, with built in 
    // options for server validation, required fields, etc.<br>
    // @group	submitting
    // @visibility external
	//<
    // Defaulted to false, as we usually do not want direct submission behaviour.
    // Note: if true, and saveData() is called, the rpcManager code will perform its request
    // as a direct submission to the action URL by setting request.directSubmit

    // whether to write the <form> tag
    
    writeFormTag:true,

    
    //> @attr   dynamicForm.saveOnEnter (boolean : false :IRW)
    // If <code>true</code>, when the user hits the Enter key while focussed in a text-item in
    // this form, we automatically submit the form to the server using the 
    // +link{dynamicForm.submit()} method.
    // @visibility external
    // @group submitting
    //<
    
    //>	@attr	dynamicForm.autoSendTarget		(boolean : false : IRWA)
	// Should we send the form target name to the server automatically?
	//		@group	submitting
	//<
	// if autoSendTarget is true, we automatically add a hidden field to the form that tells the
    // server the name of the target the form was submitting to.  This is useful for
    // reauthentication purposes.

    //>	@attr	dynamicForm.autoSendTargetFieldName		(string : "__target__" : IRWA)
	// Name of the field in which the form target will be set
	//		@group	submitting
	//<
	autoSendTargetFieldName:"__target__",
    
    // useNativeSelectItems
    // Determines whether items of type "select" or "SelectItem" should be rendered as 
    // our ISC SelectItems or NativeSelectItems
    
    useNativeSelectItems:false,

    
    hideUsingDisplayNone: isc.Browser.isMoz && isc.Browser.isMac,
    
    
    //> @attr dynamicForm.operator (OperationId : "and" : IR)
    // When +link{formItem.operator} has been set for any +link{FormItem} in this form, what
    // logical operator should be applied across the +link{Criterion,criteria} produced by the form
    // items?  Only applicable to forms that have a +link{DataBoundComponent.dataSource,dataSource}.
    //
    // @visibility external
    //<
    operator: "and"


});

// add default methods
isc.DynamicForm.addMethods({


//---------------------------
//	Data initialization
//---------------------------


//>	@method	dynamicForm.initWidget()	(A)
//			initialize the form object 
//
//			initializes th list of fields
//			sets up the data (if specified)
//			clears the errors array
//
//		@param	[all arguments]	(object)	objects with properties to override from default
//<
initWidget : function () {
    if (isc._traceMarkers) arguments.__this = this;

	// call the superclass function
	this.Super("initWidget",arguments);

	// allow for fields instead of items specification
	if (this.fields && this.items == null) this.items = this.fields;
    
    // If we have a set of 'defaultItems' in an array, and the developer hasn't set the items
    // property, use the defaultItems array instead.
    // Notes:
    // - The 'defaultItems' property would typically be set on the instance prototype this class
    //   (or subclasses).
    // - In each instance we *copy* the defaultItems array into this.items, and avoid manipulating
    //   it directly.  This means specific instances will not write properties out into the 
    //   instance prototype's 'defaultItems' array (which would happen if manipulated directly as 
    //   it is passed by reference to each instance, so all instances point to the same object)
    // When creating a DynamicForm subclass, for which each instance should show a specific set 
    // of items by default, the defaultItems property should be set on the instance prototype.  
    // Settting the items property directly on the instance prototype is a bad idea as each 
    // instance will then point to the same items array.
    // (Used in Editor.js)
    if (this.defaultItems != null && this.items == null) {
        this.items = [];
        for (var i = 0; i < this.defaultItems.length; i++) {
            this.items[i] = isc.addProperties({}, this.defaultItems[i]);
        }
    }
    
    // Default values to an empty list.
    if (this.values == null) this.values = {};
    
	// initialize the list of fields, defaulting to an empty list
    // Note: We set up the items (and set their values / eval defaultDynamicValue) at Form init 
    // time so that a developer can define a form and then work with the items before drawing the 
    // form using the standard form item APIs.
    // This is in contrast to the approach used (for example) in the ListGrid, where the component
    // parts of the LG (header, body, etc.) are not created until draw in order to minimize the
    // cost associated with changing the dataSource / data /etc. while the widget is undrawn.
	this.setItems(this.items ? this.items : [], true);
    
    // If we've been marked as disabled explicitly disable all form items.
    if (this.isDisabled()) {
        this.setDisabled(true);
    }

    //>ValuesManager
    // If we have a 'valuesManager' property, at this point ensure we are properly linked to
    // it.
    
    if (this.valuesManager != null) {
    
        var vM = this.valuesManager;
        // clear out the property - it will be re-added as part of 'addMember()' on the VM
        this.valuesManager = null;
        
        if (isc.isA.ValuesManager(vM)) {
            vM.addMember(this);
        } else if (isc.isA.ValuesManager(window[vM])) {
            window[vM].addMember(this);
            
        // If it's a string, create a new VM with that ID;
        } else if (isc.isA.String(vM)) {
            isc.ValuesManager.create({
                ID:vM,  members:[this]
            });
        } else {
            this.logWarn("Form initialized with invalid 'valuesManager' property:"
                         + isc.Log.echo(vM) + ", clearing this property out");
        }
    }
    //<ValuesManager

	// intialize the form errors, defaulting to an empty list
	this.setErrors(this.errors ? this.errors : {});

	// initialize the form values, via 'setValues()'
	// this automatically remembers the old values for us as well
	this.setValues(this.values, true);
    
},

_destroyItems : function (items) {
    if (!items) return;
    if (!isc.isA.FormItem(items[0])) return;
    items.map("destroy");
},

destroy : function () {
    if (this.valuesManager) this.valuesManager.removeMember(this);
    this._destroyItems(this.items);
    this.Super("destroy", arguments);
},

// Override 'setHandleDisabled' to disable / enable all items
setHandleDisabled : function (disabled) {
    if (this.isDrawn()) {
        if (this.redrawOnDisable) this.markForRedraw("setDisabled");
        this.disableKeyboardEvents(disabled, null, true);
    }
    
    
    var items = this.getItems();
    for (var i = 0; i < items.length; i ++) {
        
        items[i].updateDisabled();
    }
},

disableKeyboardEvents : function (disabled, recursive, disablingForm) {
    this.Super("disableKeyboardEvents", arguments);
    // by default disabling the form will also disable all items within it (no need to explicitly
    // suppress keyboard access to them)
    // If the form is not being disabled but just having keyboard access suppressed (EG for
    // a clickMask), notify the form items individually
    if (!disablingForm) {   
        
        if (disabled) {
            this._enabledTI = this.getTabIndex();
            this._setTabIndex(-1);
        } else {
            this._setTabIndex(this._enabledTI);
        }
    }
},

//>	@method	dynamicForm.applyFieldDefaults()
//		@group	data
//         Selects the appropriate form item type for fields if not specified,
//         based on schema information.
//<
applyFieldDefaults : function (fields) {
	if (fields == null) return;

	for (var i = 0; i < fields.length; i++) {
		var field = fields[i];
        
        // This null check will avoid JS errors if someone defines an array of fields with
        // a trailing comma in IE
        if (field == null) return;
        
	}
},

//>	@method dynamicForm.getEditorType()  ([A])
//
// Returns the form item type (Class Name) to be created for some field.<br>
// By default <code>field.editorType</code> will be used if present - otherwise backs off to
// deriving the appropriate form item type from the data type of the field (see
// +link{type:FormItemType} for details.
//
//  @group  editing
//
//  @param  field   (object)    field definition for which we are deriving form item type.
//  @return         (string)  form item type for the field
//  @visibility external 
//<
getEditorType : function (field) {
    return isc.DynamicForm.getEditorType(field, this);
},

//>	@method	dynamicForm.setItems()
// Synonym for +link{DynamicForm.setFields()}
//
//		@group	elements
//		@param	itemList		(Array of objects)	list of new items to show in the form
// @visibility external
//<
setItems : function (itemList, firstInit) {
    // mark any items which had explicitly defined types, so we don't override them with our logic
    // for picking default types
    if (itemList != null) {
        for (var i = 0; i < itemList.length; i++) { 
            var invalidItem = false;
            if (itemList[i] == null) {
                this.logWarn("Encountered empty entry in items array - removing this entry.")
                invalidItem = true;
            }
            if (isc.isA.Canvas(itemList[i])) {
                this.logWarn("Encountered a Canvas instance:" + itemList[i] + " in the items " +
                             "array - the DynamicForm items array should contain only FormItem " +
                             "definitions. Removing this entry.");
                 invalidItem = true;
            }
            if (invalidItem) {
                itemList.removeAt(i);                
                i -= 1;
            }
        }
    }

    // get field data by binding to a DataSource, if we were provided one.  NOTE we do this first
    // because the returned list of items may be a new list
    itemList = this.bindToDataSource(itemList);
    //this.logWarn("itemList is : " + this.echo(itemList) +
    //             ", this.items is : " + this.echo(this.items) + this.getStackTrace());
    if (!itemList) itemList = [];
    // If the itemList passed in is the same array object as this.items, duplicate it, as 
    // the removeItems call (below) will clear out that array.
    else if (itemList == this.items) itemList = itemList.duplicate();
    
    // remove all existing items (destroy FormItem objects we created)
    if (this.items != null && this.items.length > 0 && !firstInit) this.removeItems(this.items);
	
    this._addItems(itemList, null, true, firstInit);
},

//>	@method	dynamicForm.setFields()
// Set the +link{dynamicForm.fields, items} for this DynamicForm. 
// Takes an array of item definitions, which will be converted to +link{FormItem}s and 
// displayed in the form.<br>
// Note: Do not attempt to create +link{FormItem} instances directly. This method should be
// passed the raw properties for each item only.
//
//		@group	elements
//		@param	itemList		(Array of objects)	list of new items to show in the form
// @visibility external
//<
setFields : function (fieldList) {
	this.setItems(fieldList);
},

//>	@method	dynamicForm.getFields()
// Method to retrieve the +link{dynamicForm.fields, items} for this DynamicForm. 
//
//		@group	elements
// @visibility external
//<
getFields : function () {
	return this.items;
},

//>	@method	dynamicForm.getItems()
// Method to retrieve the +link{dynamicForm.fields, items} for this DynamicForm. 
//
//		@group	elements
// @visibility external
//<
getItems : function () {
	return this.items;
},

// Override visibleAtPoint to return true if we have any items contained in containerWidgets
// which would be visible at the specified point.

visibleAtPoint : function (x, y, withinViewport, ignoreWidgets) {

    if (this.invokeSuper(isc.DynamicForm, "visibleAtPoint", x,y,withinViewport,ignoreWidgets)) 
        return true;
    
    
    var items = this.items || [],
        containerWidgets = {},
        focusItemIndex = items.indexOf(this.getFocusItem());
    
    for (var i = -1; i < items.length; i++) {
        
        var itemIndex = i;
        if (i == -1) {
            itemIndex = focusItemIndex;
        // avoid checking the focus item twice
        } else if (itemIndex == focusItemIndex) continue;
        
        // Catch the case where we had no focusItem;
        if (itemIndex == -1) continue;
        var item = items[itemIndex],
            cw = item.containerWidget;
        if (cw == this || !item.isDrawn() || !item.isVisible()) continue;
        
        
        var cwID = cw.getID();
        if (containerWidgets[cwID] == null) {
            containerWidgets[cwID] = cw.visibleAtPoint(x,y,withinViewport, ignoreWidgets);
        }
        if (!containerWidgets[cwID]) continue;
            
        
        var PL = item.getPageLeft(),
            PT = item.getPageTop();
        if (PL <= x && (PL + item.getVisibleWidth()) >= x && PT <= y && (PT + item.getVisibleHeight()) >= y) {
            return true;
        }
    }

    return false;
},

// addItems - slot new items into the appropriate position in the items in this DynamicForm

addItems : function (newItems, position) {
    if (!isc.isAn.Array(newItems)) newItems = [newItems];
    if (this.dataSource) {
        var ds = isc.DS.get(this.dataSource);
        for (var i = 0; i < newItems.length; i++) {
            newItems[i] = ds.combineFieldData(newItems[i]);

                    
        }
    }
    if (position == null || position > this.items.length) position = this.items.length;

    this._addItems(newItems, position);
},


_$upload : "upload",
_$mutex:"mutex",
_addItems : function (newItems, position, fromSetItems, firstInit) {

    // adding items will almost always change the tab-index-span used by the form
    // If this increases, we need to catch the case where the tabIndex of our items overlaps
    // the next widget on the page
    var drawn = this.isDrawn(),
        oldSpan = drawn ? this.getTabIndexSpan() : null;
    
    //this.logWarn("addItems: " + this.echoAll(newItems));

    // apply type-based field defaults to the items passed in
    // Note: this will not change the type of an already-instantiated form item, so we do this
    // before converting the items init objects to FormItems
    this.applyFieldDefaults(newItems);
    
    var sectionItems = [];
    
	// iterate through all the items, creating FormItems from object literals
    var haveUploadFields = false,
        foundFileItem = false,
        mutexSections = (this.sectionVisibilityMode == this._$mutex);
 
	for (var itemNum = 0; itemNum < newItems.length; itemNum++) {
		var item = newItems[itemNum];

		// remove any empty items from the list
		if (!item) {
			newItems.removeItem(itemNum);
			itemNum--;
			continue;
		}

        var itemType = this.getEditorType(item);
        newItems[itemNum] = item = this.createItem(item, itemType);

        if (itemType == this._$upload) haveUploadFields = true;
        if (isc.FileItem && isc.isA.FileItem(item) && foundFileItem) {
            this.logWarn("Attempting to creating a form with multiple FileItems. This is " +
                         "not currently supported - only the first file type field value will " +
                         "be committed on submission of this form.");
        }

        // add to list of form sections that should start out hidden
        if (isc.isA.SectionItem(item)) {
            sectionItems.add(item);
            // remember the last visible section for mutex operation
            
            if (item.sectionExpanded && mutexSections) 
                this._lastExpandedSection = item;
        }
	}
    
    // Actually store the items in this.items
    
    if (fromSetItems) this.items = newItems
    else this.items.addListAt(newItems, position);
    
    
    if (!firstInit) this.setItemValues(this.getValues(), false, true, newItems);

    // enable multipart encoding if upload fields are included
    // NOTE: imperfect: we aren't detecting all the ways you can include an UploadItem, eg
    // editorType:"UploadItem" isn't caught, neither would any subclasses be.
    if (haveUploadFields) this.encoding = isc.DynamicForm.MULTIPART_ENCODING;
    
    for (var i = 0; i < sectionItems.length; i++) {
        var sectionItem = sectionItems[i],
            isVisible = sectionItem.sectionExpanded;

            
            if (isVisible && (!mutexSections || (this._lastExpandedSection == sectionItem))) {
                // call expandSection on visible items to ensure that sections defined with an
                // inline items array have added their items to the form.
                sectionItem.expandSection();              
            } else {
                // hide form sections for section items that have sectionExpanded property set 
                // to false
                // do this as separate for loop to ensure that all form items to be hidden have 
                // been initialized
                sectionItem.collapseSection();
            }
    }
    
    // set the _itemsChanged flag so we recalculate the layout
	this._itemsChanged = true;

    // If necessary, shift the next widget's tabIndex forward to make room for our new items.
    var tabIndex = this.getTabIndex();
    if (drawn && tabIndex != -1) {
        // we have to explicitly call _assignTabIndices here so that getTabIndexSpan() will
        // return an updated value. Normally the items' tabIndices are assigned when 
        // 'getTabIndex()' is called on them, which wouldn't happen until getInnerHTML() from
        // the delayed redraw (below).
        this._assignTabIndices();
        var span = this.getTabIndexSpan();
        if (span > oldSpan) {    
            var nextWidget = this._getNextTabWidget();
            if (nextWidget) {
                var nextWidgetIndex = nextWidget.getTabIndex();
                if (nextWidgetIndex < (tabIndex+ span)) {
                    nextWidget._shiftTabIndexForward((tabIndex + span) - nextWidgetIndex);
                }
            }
        }
    }
    
	this.markForRedraw("Form items added");
},

_knownProps : ["name", "editorType", "type", 
               "valueMap", "defaultValue", "showTitle",
               "left", "top", "width", "height"],
copyKnownProperties : function (target, props, propNames) {
    var undef;
    for (var i = 0; i < propNames.length; i++) {
        var propName = propNames[i],
            value = props[propName];
        if (value !== undef) {
            target[propName] = value;
            delete props[propName];
        }
    }
},
createItem : function (item, type) {
    // We may want to support having the user specify which form an item belongs to before it
    // is initialized as a FormItem instance.  (The specified form will then handle values 
    // management, etc.)
    // However this is not currently supported - we'll always have form items point back to the
    // form that created them.
    // (Note: We may want a customizable 'formProperty' property, rather than hardcoding the
    // "form" property)
    if (item.form != null && !(item.form == this.getID() || item.form != this)) {
        this.logWarn("Unsupported 'form' property [" + item.form + "] set on item:" +
                      item + ".  Ignoring.");
    }

	// convert from a simple object into a FormItem
	var className = isc.FormItemFactory.getItemClassName(item, type, this),
        classObject = isc.FormItemFactory.getItemClass(className);

    if (!classObject) {
        this.logWarn("Problem initializing item: "+isc.Log.echo(item)
                    +" - derived FormItem class is: "+className
                    +".  Please make sure the relevant module is loaded");
        return;
    }

    var itemConfig = item;

    item = classObject.createRaw();
	// set up a pointer back to this form, and to the containerWidget, which might be a
    // different widget, eg a grid doing inline editing.
    // Note: several FormItem methods assume item.form will be set before init() is called.
    // CanvasItems at least need containerWidget in init as well.
    // set this up as the item's eventParent (for ISC bubbling)
    item.form = item.containerWidget = item.eventParent = this;

    
    if (isc.Browser.isIE && this.canAlterItems) {
        this.copyKnownProperties(item, itemConfig, this._knownProps);
    }

    if (this.autoChildItems) {
        // use the autoChild system to instantiate items with FormItem class-specific defaults
        

        // ensure an auto-ID is not assigned by the autoChild system
        if (item.ID == null) item.ID = null;

        this._completeCreationWithDefaults(classObject.Class, item, itemConfig);
    } else {
        //this.logWarn("item: " + this.echoLeaf(item) + ", item.form is: " + item.form + 
        //             ", itemConfig is: " + this.echo(itemConfig));
        item.completeCreation(itemConfig);
    }

    
    item.form = this;
    if (item.destroyed) item.destroyed = false;
        
    // Log a warning if this item has no name, but is expected to save values
    // See comment in formItem.js next to the 'shouldSaveValue' property declaration.
    // (Note: we could put this check into FormItem.init)
    if (item.shouldSaveValue && 
        (item[this.fieldIdProperty] == null || 
         isc.isAn.emptyString(item[this.fieldIdProperty]))) 
    {

        // 'shouldSaveValue' is a property denoting whether this item should be included
        // in the form's values object.
        // False by default for non-data items.
        this.logWarn(item.getClass() + " form item defined with no '" + 
                     this.fieldIdProperty + "' property - Value will not be saved." +
                     " To explicitly exclude a form item from the set of values to " +
                     "be saved, set 'shouldSaveValue' to false for this item.")

        item.shouldSaveValue = false;                        
    }
    return item;
},

//>	@method	dynamicForm.removeItems()
// Removes some items from this form.
// Marks form to be redrawn.
//
//		@group	elements
//		@param	items   (object[])  list of form items to remove from the form
//<
removeItems : function (items) {
    if (items == null) return;

    if (!isc.isAn.Array(items)) items = [items];

    // If passed this.items, duplicate it - we want to be able to manipulate this.items without
    // changing the array passed in.
    if (items == this.items) items = this.items.duplicate();
    
    items = this.map("getItem", items);
    
    this.items.removeList(items);
 
    // if we've removed any items from this form, destroy() them to 
    for (var i = 0; i < items.length; i++) {
        var item = items[i];

        // bad item name passed in, getItem() failed
        if (item == null) continue;

        // If this has sub-items, slot them in after this item in the items array
        if (item.items != null) {
            items.addList(item.items, i+1);
        }

        // don't leave a pointer to a destroyed focus item.
        if (this._focusItem == item) delete this._focusItem;

        
        if (!this.items.contains(item) && isc.isA.FormItem(item)) item.destroy();
    }
    
    // set the _itemsChanged flag so we recalculate the layout
	this._itemsChanged = true;
    this.markForRedraw("Form items removed")
},

// canvas overrides
addField : function (field, position) { this.addItems(field, position) },
removeField : function (field) { this.removeItems(field); },

// obvious synonyms for single items 
addItem : function (item) { this.addItems(item); },
removeItem : function (item) { this.removeItems(item); },

// Synonymous addFields / removeFields methods for completeness
addFields : function (items, pos) {
    return this.addItems(items, pos);
},
removeFields : function (items) {
    return this.removeItems(items);
},


// tabIndex management
// ---------------------------------------------------------------------------------------

// Widget level _canFocus
// If this method returns false we will not get keyboard events on the form.
// Therefore check for our items' _canFocus() instead.
// Only respect canFocus:false if we have no focusable items
_canFocus : function (a,b,c,d) {
    // shortcut: allow canFocus:true
    if (this.canFocus == true) return true;
    var items = this.getItems();
    for (var i = 0; i < items.length; i++) {
        if (items[i]._canFocus()) return true;
    }
    
    return this.invokeSuper(isc.DynamicForm, "_canFocus", a,b,c,d);
},


// Assign ascending tabIndices to form items with no explicitly assigned tab-index.

_assignTabIndices : function () {
    var items = this.items;
    if (!items || items.length == 0) return;

    // We want to ensure the auto-allocated tabIndices don't collide with the explicitly 
    // specified index of some other form item, so we can't just use items.indexOf(item) for
    // each item.
    var explicitTabIndexArray = [], warnedTIs = {};    
    for (var i = 0; i < items.length; i++) {
        
        var item = items[i], ti = item.tabIndex;
        if (ti != null && ti != -1) {
            // Warn if we have explicit tabIndices that collide
            
            if (explicitTabIndexArray[ti] != null && !warnedTIs[ti]) {
                this.logWarn("More than one item in this form have an explicitly specified tabIndex of '" 
                            + ti + "'. Tab order cannot be guaranteed within this form.");
                // avoid warning over and over for the same tab index.
                warnedTIs[ti] = true;                            
            }
            // Making a sparse array of previously assigned tabIndices. 
            explicitTabIndexArray[ti] = item;
        }
    }
    
    // iterate through a second time actually setting up the local tabIndices
    // We'll do this by setting the local tabIndex to the index in the items array offset by
    // any tab-indices already explicitly populated.
    // (Start with an offset of 1 - we want to use 1-based rather than 0-based tab indices for
    // simplicity)
    var tabIndexOffset = 1;
    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        // Don't increment the next tabIndex if:
        // - this item has not yet been initialized
        // - this item already has an explicit tabIndex
        // - it can't recieve focus
        
        if (!isc.isA.FormItem(item)) {    
            if (this.logIsDebugEnabled()) 
                this.logDebug("_assignTabIndices() fired before all form items have been initialized" 
                             + this.getStackTrace());
                             
            continue;
        }
        if (!item._canFocus() || item.tabIndex != null || item.globalTabIndex != null) {
            continue;
        }
        tabIndexOffset += 1;
        // Avoid colliding with explicitly specified local tab indices
        while (explicitTabIndexArray[tabIndexOffset] != null) {
            tabIndexOffset += 1;
        }
        item._localTabIndex = tabIndexOffset;
    }    
    
},

// Have _slotChildrenIntoTabOrder() no-op - our children come from CanvasItems and we're already
// managing their tab indices
_slotChildrenIntoTabOrder : function () {
    return;
},

// We will take up multiple slots in the page's tab order due to our set of items
// We're not concerned about items with an explicitly specified global tab index - they won't
// take up any slots next to the form itself.
getTabIndexSpan : function () {
    var items = this.items;   
    // Even though we wont really take up a slot if we have no items, never allow 
    // our tabIndexSpan to be 0.
    var slots = 1;
    if (!items) {
        return slots;
    }

    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        
        if (!isc.isA.FormItem(item)) {
            return items.length;
        }
        
        if (!item._canFocus() || item.globalTabIndex != null) {
            continue;
        }
        var tabIndex = item.tabIndex || item._localTabIndex;
        if (tabIndex == null) {
            this._assignTabIndices();
            tabIndex = item._localTabIndex;
        }
        if (tabIndex != null && tabIndex > slots) slots = tabIndex;
    }
    return slots;
},


// When the tabIndex changes, notify form items - since their tab indices are most likely to be
// local
_setTabIndex : function () {
    this.Super("_setTabIndex", arguments);
    if (this.isDrawn() && this.isVisible() && this.items) {
        for (var i = 0; i < this.items.length; i++) {
            this.items[i].updateTabIndex();
        }
    }
},

// Item notifications
// ---------------------------------------------------------------------------------------

// Whenever this DynamicForm is moved, notify all the items that they have been moved.

moved : function (a,b,c,d) {
    this.invokeSuper(isc.DynamicForm, "moved", a,b,c,d);
    this.itemsMoved();
},

parentMoved : function (a,b,c,d) {
    this.invokeSuper(isc.DynamicForm, "parentMoved", a,b,c,d);
    this.itemsMoved();
},

// Also notify the items if the zIndex is modified
zIndexChanged : function (a,b,c,d) {
    this.invokeSuper(isc.DynamicForm, "zIndexChanged", a,b,c,d);
    this.itemsZIndexChanged();
},

parentZIndexChanged : function (a,b,c,d) {
    this.invokeSuper(isc.DynamicForm, "parentZIndexChanged", a,b,c,d);
    this.itemsZIndexChanged();
},


// Since the container widget for form items manages their position / HTML we need to fire
// a notification function to let them know if they have moved.
// itemsMoved is a helper method to fire 'moved()' on each item in this form.
itemsMoved : function () {
    var items = this.getItems();
    if (!items) return;    
    for (var i = 0; i < items.length; i++) {
        if (items[i].isVisible) items[i].moved();
    }
},

// When our visibility changes, notify all our items of the visibility change.

itemsVisibilityChanged : function () {
    var items = this.getItems();
    if (!items) return;    
    for (var i = 0; i < items.length; i++) {
        items[i].visibilityChanged();
    }
},

itemsZIndexChanged : function () {
    var items = this.getItems();
    if (!items) return;
    for (var i = 0; i < items.length; i++) {
        items[i].zIndexChanged();
    }
},

// Override scrollTo to notify our form items that they have moved.
scrollTo : function (left, top) {
    var oldLeft = this.getScrollLeft(),
        oldTop = this.getScrollTop();
        
    this.Super("scrollTo", arguments);

    // If the scroll position changed, notify our form items that they have moved.
    if (oldLeft != this.getScrollLeft() || oldTop != this.getScrollTop()) this.itemsMoved();
},

// EditMode setters
// ---------------------------------------------------------------------------------------

//>EditMode
setTitleOrientation : function (orientation) {
    this.titleOrientation = orientation;
    this._itemsChanged = true;
    this.markForRedraw();
},

setNumCols : function (numCols) {
    this.numCols = numCols;
    this._itemsChanged = true;
    this.markForRedraw();
},
//<EditMode


// AutoComplete
// --------------------------------------------------------------------------------------------

//> @method dynamicForm.setAutoComplete()
// Change the autoCompletion mode for the form as a whole.
//
// @param   newSetting (AutoComplete)  new setting
// @group autoComplete
// @visibility autoComplete
//<
setAutoComplete : function (newSetting) {
    this.autoComplete = newSetting;
    // have items change mode if applicable
	for (var i = 0; i < this.items.length; i++) {
        this.items[i]._handleAutoCompleteChange();
    }
},

/////////
// Form Values handling
// --------------------------------------------------------------------------------------------
//  
// From a developers' point of view:
//  - You can initialize a form with form.values set (an array of field / value pairs).
//    - you can include fields that are not in the items array for the form.
//
//  - You can retrieve the entire set of values via form.getValues();
//    - this is basically this.values, so includes values set via setValues() that don't have
//      an associated form item.
//    - In theory this will always show you the visible value in each form element (value-mapped
//      back to the appropriate raw value if applicable).
//
//  - You can set this.values with a call to setValues()
//    - again you can include fields that are not in the items array for the form.
//    - the form will be redrawn to show the changes in the actual form elements
//
//  - form.resetValues() will reset the values to the last values set programatically via 
//    form.setValues or form.setValue();
//
//  - form.clearValues() will set this.values to {}
//    - for form items with a defaultValue or defaultDynamicValue, this will be respected in this 
//      case.
//
//  - You can set the value for an individual form item via "form.setValue(item, value);" or
//    "form.getItem(itemName).setValue(value)"
//  - You can retrieve the value for an individual form item via form.getValue(item), or 
//    form.getItem(itemName).getValue();
//      - the value retrieved by these getter methods will be determined by looking at the 
//        stored formItem._value (set on every 'change' event) first.  If that is not present, 
//        this method will fall through to form.getSavedItemValue() which will look for the value
//        in the form.values array, and if it's not there return the default value for the item.
//  These four methods do not allow you to set values in the form.values array for fields that
//  are not included as actual form items.
//
//
// Internally:
//  There are several sets of values to consider:
//  - form.values - the values we return to the user from getValues() calls - should always be in
//    synch with the form item element values, but may include fields that are not in the set of
//    form items.
//  - form._oldValues - which is set up via form.rememberValues().  
//    This is used for resetting values on an explicit call to resetValues(), or after a 
//    failed validation attempt.  
//    form.rememberValues() is called every time a form value is set programattically - from 
//    setValues() and setValue() calls.
//  - formItem._value.  This is the FormItem's internal representation of the form item value.
//    it is updated whenever the value is saved, so on programatic 'setValue()', on change (and
//    keypress for some widgets).
//    Only used by code in FormItem.js (the form knows nothing each formItem's _value property).
//    Returned by FormItem.getValue().
//    Note - We store _oldValues on the form rather than on each item because:
//    - Having form._oldValues rather than just formItem._oldValue for each item allows us to store
//      values for non-form item fields
//  - The value displayed in the html element for each form item.  This differs from formItem._value
//    in a couple of ways:
//      - for form elements that have valueMaps, the display value will not match the "data" value
//      - form elements grouped into a container where there are multiple form elements for one 
//        logical value (such as date items).
//      - Anything where 'mapValueToDisplay()' and 'mapDisplayToValue()' is non trivial (allowing
//        checkboxes to represent values other than true and false, for example)
//      Important:
//      - The value displayed in the element can be out of synch with the _value for a form item,
//        for example while typing in a form item with 'changeOnKeypress' set to false (such as the
//        time item).  The form item is responsible for updating it's _value whenever appropriate
//        via the 'updateValue()' method, as the APIs to get directly at the value stored in the
//        element are not public.
//        *One case where it may not be in synch is items which have to validate / or reformat their 
//         element values to , such as time items and date items.
//         If a user is in the process of entering a time into a Time itme, the element may display 
//         "1:", but the _value will not be updated (and saved in the form item values) until the 
//         change handler fires on the element, meaning we won't be interfering with a user's typing 
//         by attempting to verify the time on every keypress.
//         In this case, if a developer was to call 'getValue()' on a time item while focus was 
//         still in that item (and the user theoretically still typing), the stored time value
//         would be returned, rather that attempting to parse the partially typed value.
//
//  - formItem.defaultValue and formItem.defaultDynamicValue.
//    - whenever an item's value is programatically set to null, the appropriate default value will
//      be applied to the form item.
//
//  form.values is updated in the following places:
//      - form.setValues().  
//        - Sets this.values to the object passed in, 
//        - Saves the values in this._oldValues
//        - Calls 'setItemValues()' to take care of updating the values for each form item.
//        - Redraws the form to re-evaluate show-ifs
//        Called by:
//          - init() - call to this.setValues() with this.values or {}.
//          - this.clearValues() - falls through to this.setValues({});
//          - this.resetValues() - falls through to this.setValues(this._oldValues);
//
//      - this.saveItemValue() (Basically used to keep form.values in synch with the values for each
//        form item).
//        - Updates this.values[item] for an item.
//        - Clears the '_valueIsDirty' flag for the form item 
//        Called from:
//          - form.elementChanged() (fired from an item's native change handler)
//          - item.handleKeyPress() (fired from a text / textArea item's keyPress handler)
//          - form.getValues() - if the current focus item is marked as dirty, this.values[...] for
//            the item will be updated to match the element value for the dirty form item.  (Other 
//            form items than the focus item should not be out of synch because of the 
//            elementChanged call to this method above).  Form items are marked as dirty via an
//            '_valueIsDirty' flag, which is set on keyDown in text / textArea type fields only.
//          - item.setValue() - which is called by form.setValue(item, value)
//
//  form._oldValues is updated when form.setValues(), formItem.setValue(), or form.setValue() is 
//  called.
//
//  formItem._value (and form.values[item]) are updated via 'formItem.saveValue(newValue)'.
//  This method is called on formItem.setValue() [programatically updating a form item's value], or
//  formItem.updateValue(), which is called as a result of the native onchange handler for form 
//  items as well as the onclick handler for checkbox / radio items, and the onkeypress handler for
//  text items (where changeOnKeypress is true).
//  When these values are updated as a result of user interaction, the change handler will always
//  fire first (due to 'updateValue()').
//
//  The values displayed in the HTML form elements (and sub-elements) is updated by 
//  form.setItemValues() and formItem.setElementValue().  Every method that can effect the value
//  of a form item should fall through to these, or force a form redraw (which will also update the
//  values displayed).
//
//  Additional methods on the form:
//      - form.valuesHaveChanged - compares this.getValues() (effectively the current values for
//        each item) with this._oldValues (the values as they were last set via setValue() or 
//        setValues()) - used in resetValues() for example.
//
//  Additional methods on the form item:
//      - formItem.resetValue() - this will reset the value of the form item to the value stored in
//        form._oldValues[colName]
//      - formItem.elementChanged() - an internal method fired when the native element changed handler
//        is fired.  This is mentioned above as one of the callers for form.saveItemValue().  It
//        performs some other functions too, such as performing validation on the form item, and
//        setting up errors if necessary.  It has a number of "XXX" type comments and probably 
//        warrants reviewing!
//      - formItem.updateValue() - called on change (and keypress if change on keypress is true)
//        determines value (mapped to data value) from element, called 'handleChange()' and 
//        'saveValue()'
//      - formItem.handleChange() - internal method fired from updateValue() - will fire validators 
//        and change handlers.  If this method returns false, the value in the form item element
//        will not be saved.
//      - formItem.saveValue() - called from 'setValue()' or 'updateValue()', this will save the
//        value passed in as this._value, and update this.form.values[this.name], if the item has
//        been marked as 'shouldSaveValue' true.
//
// Notes:
//  - direct submission of the HTML form drawn out by the dynamicForm widget is supported in a 
//    couple of ways
//      - completely standard HTML submission is supported when canSubmit is true.
//        tripped from SubmitItem click, explicit call to "submit()" or "submitForm()".
//        Direct submission of course requires the values for form items to be present in real
//        HTML form elements - we handle this by writing out hidden elements with the intended
//        values where necessary.
//      - We also support an rpcManager direct submit transaction. This is tripped by
//        the saveData() code path if
//          a) this.canSubmit is true
//          b) this.isMultipart() [required for upload fields]
//          c) this.action has been specified.
//      Note that in rpcManager direct submit, the server pays attention to the _transaction 
//      parameter, which is a structure that contains the intended field values wherever 
//      possible.
//
//////////////////

//>	@method	dynamicForm.setValues()
// Sets the values of the entire form, as an Object containing the values of the form as
// properties, where each propertyName is the name of a +link{items,form item} in the form, and
// each property value is the value held by that form item.
// <P>
// Any +link{FormItem} for which a value is not provided will revert to its
// +link{formItem.defaultValue,defaultValue}.  To cause all FormItems to revert to default
// values, pass null.
// <P>
// This method also calls +link{rememberValues()} so that a subsequent later call to
// +link{resetValues()} will revert to the passed values.
//
// @param [newData] (Object) values for the form, or null to reset all items to default values
//
// @group formValues	
// @visibility external
//<
setValues : function (newData, initTime) {
    if (isc.isAn.Array(newData)) {
        var useFirst = isc.isA.Object(newData[0]);
        this.logWarn("values specified as an array." + 
                    (useFirst ? " Treating the first item in the array as intended values."
                              : " Ignoring specified values (resetting to defaults)."));
        if (useFirst) newData = newData[0];
        else newData= null;
    }
    
    if (newData == null) newData = {};

	// store the new values object
	this._saveValues(newData);
    
    // If any of our items have a specified 'displayField', call the method to create a 
    // special valueMap on that item so the value for that field is displayed rather than
    // the fields own value.
    
    var items = this.items;
    for (var i = 0; i < items.length; i++) {
        if (items[i].shouldSaveValue && this._useDisplayFieldValue(items[i])) {
            items[i]._displayFieldValueFromFormValues();
        }
    }
	
    // and set the values in the form elements 
    
	this.setItemValues(newData, null, initTime);
    
	// remember the values so we can undo things
	this.rememberValues();
    // redraw so that we will re-evaluate showIfs
    this.markForRedraw("setValues");
},

// Helper method to detect the case where we a field should display the value from a 
// different field (field.displayField) in this form's values object
_useDisplayFieldValue : function (field) {
    if (!field || !field.displayField) return false;
    var ods = field.getOptionDataSource();
    return !ods || (ods == isc.DataSource.getDataSource(this.dataSource));
},                                            

//>	@method	dynamicForm.setData()
//			Pass-through to the standard setData interface.
//		@group formValues
//
//		@param	newData		(object)	data to display in the form
//<
setData : function (newData) {
	this.setValues(newData);
},

// clear validation errors on rebind.  NOTE: should probably go to generic DataBinding
// framework when validation becomes a generic databinding behavior such that individual
// widgets just choose validation presentation.
setDataSource : function (dataSource, fields) {
    this.Super("setDataSource", arguments);
    this.clearErrors();
},

//>	@method	dynamicForm.rememberValues()
//			Make a snapshot of the current set of values, so we can reset to them later.
//			Creates a new object, then adds all non-method properties of values
//			to the new object.  Use <code>resetValues()</code> to revert to these values.
//          Note that this method is automatically called when the values for this form are
//          set programmatically via a call to +link{DynamicForm.setValues()}.
//
//      @visibility external
//		@group formValues
//
//		@return	(object)	copy of current form values
//<
rememberValues : function () {

	var values = this.getValues(),
		// create a new object to hold the values, assign it to this._oldValues
		newValues = this._oldValues = {}
	;
    
    this._rememberedDefault = [];
    
	for (var prop in values) {
		if (isc.isA.Function(values[prop])) continue;

        // Special case for dates - duplicate them into _oldValues so we can restore to their
        // previous value
        if (isc.isA.Date(values[prop])) {
            newValues[prop] = new Date();
            newValues[prop].setTime(values[prop].getTime());
        } else {
            newValues[prop] = values[prop];
        }
        
        // Also remember if any of these items have a non-null default.
        // When resetValues is called we'll want to reset to null rather than that default
        // to force the default value to be re-eval'd
        
        var item = this.getItem(prop);
        if (item && item.isSetToDefaultValue()) this._rememberedDefault.add(prop);
	}
	return newValues;
},


//>	@method	dynamicForm.resetValues()   ([])
//
// Same as +link{method:DynamicForm.reset()}.
//
// @group formValues
// @visibility external
//<
resetValues : function () {
    // Note - this method will not effect unnamed items.

	// reset the form errors as well as the values
	this.clearErrors();
    
	// pull the values from form._oldValues into form.values
    var values = {};
	for (var prop in this._oldValues) {
        
        if (this._rememberedDefault.contains(prop)) continue;
        
        // special case for dates - we want to reset the value of the date, but not actually 
        // replace the object
        if (isc.isA.Date(values[prop]) && isc.isA.Date(this._oldValues[prop])) 
            values[prop].setTime(this._oldValues[prop].getTime());
		else 
            values[prop] = this._oldValues[prop];
	}
    this.setValues(values);
    
},

//>	@method	dynamicForm.clearValues()
// Reset to default form values and clear errors
//		@group formValues
// @visibility external
//<
clearValues : function () {
    // call setValues() to clear out all our saved values
    this.setValues();
    
    // also iterate through every unnamed form item, setting its value to null.
    
    var items = this.getItems();
    for (var i = 0; i < items.length; i++) {
        if (items[i].shouldSaveValue == false) items[i].setValue(null);
    }

	// reset the form errors
	this.clearErrors();
    
    // remember the current values for future calls to 'resetValues()'
    this.rememberValues();
    
	// redraw the form
	this.markForRedraw("clearValues");
},

//>	@method	dynamicForm.valuesHaveChanged() ([])
//          Compares the current set of values with the values stored by the call to the
//          <code>rememberValues()</code> method. Returns true if the values have changed, and false
//          otherwise.
//      @visibility external
//		@group formValues
//
//		@return	(boolean)	true if current values do not match remembered values
//<
valuesHaveChanged : function () {
	var values = this.getValues(),
        // form._oldValues is used to store the values in rememberValues()
        oldValues = this._oldValues, 
        changed = false;

    if (!isc.isAn.Object(oldValues)) oldValues = {};
    
    for (var prop in values) {
        // ignore functions
        if (isc.isA.Function(values[prop])) continue;
        
        // Use compareValues to compare old and new values
        // This will catch cases such as Dates where an '==' comparison is
        // not sufficient.
        // Note: If we have a form item use item.compareValues() in case it has been overridden
        var item = this.getItem(prop);
        if (item != null) {
            changed = !item.compareValues(values[prop], oldValues[prop]);
        } else {
            changed = !isc.DynamicForm.compareValues(values[prop], oldValues[prop]);
        }
        // no need to keep going once we've found a difference.
        if (changed) return true;
    }
    
    
    return changed;
},


//>	@method	dynamicForm.getValues() ([])
// An Object containing the values of the form as properties, where each propertyName is
// the name of a +link{items,form item} in the form, and each property value is the value
// held by that form item.
//
// @visibility external
// @group formValues
// @return (Object) values in the form
//<
getValues : function () {

    // Note: this method will not validate each field - to run validators on all the field, a 
    // developer should explicitly call the 'validate()' method on the form (or the item in 
    // question).
    // Call updateFocusItemValue() to ensure that if we have focus our values are up to date.
    // This makes sure that all the active field's value is saved when filtering, saving a
    // form, etc.
    this.updateFocusItemValue();
    
    return this.values;
},

//> @method updateFocusItemValue()
//  If we're currently focused in an item, whos value has been changed since last being
//  saved in this DynamicForm, call item.updateValue().
//<
updateFocusItemValue : function () {
    
    var focusItem = this.getFocusItem();
	if (!this._setValuesPending && focusItem != null && focusItem._itemValueIsDirty()) {
        focusItem.updateValue();
	}
},



//>	@method	dynamicForm.getData()
//			Return the values stored in the form.
//			Pass-through to dynamicForm.getValues();
//		@group	data
//		@return	(object)	values in the form
//<
getData : function () {
	return this.getValues();
},

//>	@method	dynamicForm.getValuesAsCriteria()
// Return search criteria based on the current set of values within this form.
// <p>
// The returned search criteria will be either a simple +link{Criteria} object or an
// +link{AdvancedCriteria} object if +link{formItem.operator} has been set for any item in the
// form (see +link{formItem.operator} for details).  Note that AdvancedCriteria objects will
// only be returned if this form is bound to an appropriate +link{DataSource} (ie, a 
// dataSource which contains the fields you're trying to use as criteria).
// <P>
// The returned criteria object can then be used to filter data via methods such as
// +link{ListGrid.fetchData()}, +link{DataSource.fetchData()}, or, for more advanced usage,
// +link{ResultSet.setCriteria()}.
// <P>
// Note that any form field which the user has left blank is omitted as criteria, that is,
// a blank field is assumed to mean "allow any value for this field" and not "this field must
// be blank".  Examples of empty values include a blank text field or SelectItem with an empty
// selection.
//
// @group formValues
// @return (Criteria or AdvancedCriteria) a +link{Critera} object, or +link{AdvancedCriteria}
//
// @visibility external
//<
getValuesAsCriteria : function () {
    var values = this.getValues();
    var items = this.getFields();
    
    // Should we create a normal criteria object or an AdvancedCriteria?
    var advanced = false;
    for (var i = 0; i < items.length; i++) {
        if (items[i].operator) {
            advanced = true;
            break;
        }
    }

    // filterCriteriaForFormValues will clear out null values, and handle arrays returned
    // by multi-selects.  
    
    if (!advanced || !this.dataSource) {
        return isc.DataSource.filterCriteriaForFormValues(values);
    }
    
    // AdvancedFilter
    var criteria = { 
        _constructor: "AdvancedCriteria",
        operator: this.operator
    }
    
    var subCriteria = [];
    for (i = 0; i < items.length; i++) {
        var field = items[i];
        var fieldName = items[i].criteriaField ? items[i].criteriaField : items[i].name;
        // Ignore this field if it isn't on the dataSource
        if (this.getDataSource().getField(fieldName) == null) continue

        var criterion = field.getCriterion();
        if (criterion) subCriteria.add(criterion);
    }

    criteria.criteria = subCriteria;
    return criteria;
    
},

//>!BackCompat 2005.3.21
getFilterCriteria : function () {
    return this.getValuesAsCriteria();
},
//<!BackCompat

//>	@method	dynamicForm.getItem()
// Retrieve a +link{FormItem} in this form by it's +link{formItem.name,name} or index within
// the +link{dynamicForm.items,items} array.
// <P>
// FormItems that also have a +link{formItem.ID} may be accessed directly as a global variable
// <code>window[itemID]</code> or just <code>itemID</code>
//
// @param itemName (string or int) name of the item you're looking for
//
// @return (FormItem) FormItem object or null if not found
// @see getItem()
// @group items
// @visibility external
//<
getItem : function (itemName) {

    if (isc.isA.FormItem(itemName)) return itemName;

    var item = isc.Class.getArrayItem(itemName, this.items, this.fieldIdProperty);

    if (item != null) return item;

    // If we couldn't find an item with the same name - check that we weren't passed 
    // a quoted index (like the string "0")
    if (isc.isA.Number(itemName - 1)) {
        return this.items[parseInt(itemName)];
    }
    return null;
},

//>	@method	dynamicForm.getField()   ([])
// Synonym for dynamicForm.getItem()
//
// @param itemName (string) name of the item you're looking for
//
// @return (FormItem) FormItem object or null if not found	
// @see getItem()
// @group items
// @visibility external
//<
getField : function (fieldID) {
	return this.getItem(fieldID);
},


//>	@method	dynamicForm.getSubItem()
//			Synonym for getItem()
//		@group	items
//		@param	itemID		(string)	name of the element you're looking for.
//		@return	(object)	form item object, or null if not found	
//      @deprecated As of SmartClient 5.5, use +link{dynamicForm.getItem}.
//<
getSubItem : function (itemID) {
    return this.getItem(itemID);
},

//>	@method	dynamicForm.getItemById()
//    Gets a pointer to a form item from it's global ID.
//    (the form item is also available globally as window[itemID])
//
//		@param	itemID		(string)	ID of the element you're looking for.
//		@return	(object)	form item object or null if not found	
//<
getItemById : function (itemID) {
    var item;

    if (isc.isA.String(itemID)) {
        item = window[itemID];
    } else item = itemID;

	if (isc.isA.FormItem(item)) return item;
    return null;
},


//>	@method	dynamicForm.getValue()  ([])
//  Returns the value stored in the form for some field.
//  Shorthand for dynamicForm.getValues()[fieldName];
//      @visibility external
//		@group formValues
//
//		@param	fieldName (string)    name of the field for which you're retrieving a value
//		@return	(any)	value of the field
//      @example dateItem
//<
getValue : function (fieldName) {
    // This check for item.getValue() should be unnecessary, since this.values is kept in synch 
    // with the values of each form item
	var item = this.getItem(fieldName);
    if (item) return item.getValue();
    return this.getValues()[fieldName]
},

//>	@method	dynamicForm.setValue()  ([])
//   Sets the value for some field
//      @visibility external
//		@group formValues
//
//		@param	fieldName   (string)	Name of the field being updated
//		@param	value		(string)	New value.
//<
setValue : function (fieldName, value) {
	var item = this.getItem(fieldName);
    // setValue on the item will update this.values.
    if (item != null) return item.setValue(value);
    else if (this.values != null) {
        this._saveValue(fieldName, value);
        return value;
    }
},

//> @method dynamicForm.clearValue()
// Clears the value for some field via a call to +link{FormItem.clearValue()} if appropriate.
// If there is no item associated with the field name, the field will just be cleared within
// our stored set of values.
// @param fieldName (string) Name of the field being cleared
// @visibility external
//<
clearValue : function (fieldName) {
    var item = this.getItem(fieldName);
    if (item != null) item.clearValue();
    else if (this.values) delete this.values[fieldName];
},

//>	@method	dynamicForm.showItem()  ([])
// Show a form item via +link{FormItem.show()}
//		@group formValues
//
//		@param	itemName    (string)	Name of the item to show
//      @visibility external
//<
showItem : function (fieldName) {
	var item = this.getItem(fieldName);
    if (item != null) return item.show();
},

//>	@method	dynamicForm.hideItem()  ([])
// Hide a form item via +link{FormItem.hide()}
//		@group formValues
//
//		@param	itemName    (string)	Name of the item to show
//      @visibility external
//<
hideItem : function (fieldName) {
	var item = this.getItem(fieldName);
    if (item != null) return item.hide();
},



//>	@method	dynamicForm.saveItemValue()
// Save the value passed in in the values array associated with the item.
//		@group formValues
//
//		@param	item		(FormItem)	Item to save value for (cannot be a string or number, etc).
//		@param	value		(string)	New value to set.
//<
saveItemValue : function (item, value) {

	// if this is not supposed to be included in our values array, return
	if (item.shouldSaveValue == false) return;
	
	var	itemName = item.getFieldName();
	if (!itemName) return;
    
    this._saveValue(itemName, value);
    
     // If this is an item with a display field, store the display field value as well.
    // This will update any auto-generated valueMap for the field.
    
    if (this._useDisplayFieldValue(item) && item.displayField != itemName) {
        
        var displayValue = item.mapValueToDisplay(value);
        this.setValue(item.displayField, displayValue);
    }
    
    //this.logWarn("saveItemValue: " + itemName + ": " + this.echoLeaf(value));
    // Mark the item as no longer being dirty
    item._markValueAsNotDirty(); 
},

// _saveValue and _saveValues - actually update this.values

_saveValue : function (field, value) {
    this.values[field] = value;
    
    //>ValuesManager    If this form is part of a valuesManager, notify that of the change too.
    if (this.valuesManager != null) this.valuesManager._updateValue(field, value, this);  //<ValuesManager
},

// clearItemValue()
// Internal method to clear the value for some field from the values object for this form.
// Called from item.clearValue()
clearItemValue : function (item) {
    var fieldName = item.getFieldName();
    if (!fieldName) return;
    delete this.values[fieldName];
    
    if (this.valuesManager) this.valuesManager._clearValue(fieldName, this);
    
},

_saveValues : function (values) {
    this.values = values;

    //>ValuesManager    If this form is part of a valuesManager, notify that of each field 
    // affected by the change
    if (this.valuesManager != null) {
        var oldFields = isc.getKeys(this.values);
        for (var i in values) {
            this.valuesManager._updateValue(i, values[i], this);
            oldFields.remove(i);
        }
        // Clear any values in the VM that have been cleared by this
        for (var i = 0; i < oldFields.length; i++) {
            this.valuesManager._clearValue(oldFields[i], this);
        }
    }   //<ValuesManager
},

//>	@method	dynamicForm.getSavedItemValue()
// Save the value passed in in the values array associated with the item.
//		@group formValues
//
//		@param	item		(formItem)	Form item instance to check for the saved item value
//		@return	(any)					Value saved for that item
//<
getSavedItemValue : function (item) {
    // If this is marked as a value we don't want to save, skip it.
	if (item.shouldSaveValue == false) return null;
	
	var	column = item.getFieldName();
    
	return (column && this.values[column] != null ? this.values[column] : item.getDefaultValue());
},


//>	@method	dynamicForm.resetValue()
//		@group formValues
//
//		@param	itemName		(string)	name of the element you're looking for
//<
resetValue : function (itemName) {
	var item = this.getItem(itemName);
	return (item ? item.resetValue() : null);
},



//>	@method	dynamicForm.getValueMap()
//		return the valueMap for a specified item
//		@group formValues
//		@param	itemName		(string)	name of the element you're looking for
//<
getValueMap : function (itemName) {
	var item = this.getItem(itemName);
	return (item ? item.getValueMap() : null);
},

//>	@method	dynamicForm.setValueMap()
//		Set the valueMap for a specified item
//		@group formValues
// @param itemName (string) itemName of the item upon which the valueMap should be set.
// @param valueMap (ValueMap) new valueMap for the field in question.
// @visibility external
//<
setValueMap : function (itemName, valueMap) {
	var item = this.getItem(itemName);
	return (item ? item.setValueMap(valueMap) : null);
},

//>	@method	dynamicForm.getOptions()
//		Get the options for a specified item.  Pass-through to form.getValueMap()
//		@group formValues
//		@param	itemName		(string)	name of the element you're looking for
//<
getOptions : function (itemName) {
	return this.getValueMap(itemName);
},

//>	@method	dynamicForm.setOptions()
//		Set the options for a specified item.  Pass-through to form.setValueMap()
//		@group formValues
//		@param	itemName		(string)			name of the element you're looking for
//		@param	valueMap	(array | object)	new value map to set
//<
setOptions : function (itemName, valueMap) {
	return this.setValueMap(itemName, valueMap);
},

//>	@method	dynamicForm.getForm()
// Return the DOM form object.  Returns null if not found
//
//		@param	[form]		(form | string | number)	identifier for the form or an actual form
//
//		@return	(form)	Form object
//<
getForm : function (form) {
	var args = (form == null ? [this.getFormID()] : arguments);
	return this.Super("getForm", args);
},

//>	@method	dynamicForm.getFormID()	(A)
//		@group	drawing
//			return the ID for this form
//
//		@return	(string)	ID for this form in the DOM
//<
_$form:"form",
getFormID : function () {
    return this._getDOMID(this._$form);
},

getSerializeableFields : function(removeFields, keepFields) {
	// items and fields are the same thing, but items is deprecated and printing both would
	// produce a backref - so remove one of them
	removeFields.addList(["items"]);
		
	return this.Super("getSerializeableFields", arguments);
},

// Form Sections
// --------------------------------------------------------------------------------------------
expandSection : function (sectionID) {
    var section = this.getItem(sectionID);
    if (isc.isA.SectionItem(section)) section.expandSection();
},

collapseSection : function (sectionID) {
    var section = this.getItem(sectionID);
    if (isc.isA.SectionItem(section)) section.collapseSection();
},


// Notification functions fired when a section is about to be expanded or collapsed - allows
// us to handle mutex sections.
_sectionExpanding : function (section) {
    if (this.sectionVisibilityMode == "mutex" && this._lastExpandedSection &&
         this._lastExpandedSection != section) 
    {
        this._lastExpandedSection.collapseSection();
    }
    this._lastExpandedSection = section;
},

_sectionCollapsing : function (section) {
},

// Validation error management
// --------------------------------------------------------------------------------------------

//> @method dynamicForm.getErrors()
// Returns the current set of validation errors for this form.
// @return (object) Errors are returned as an object of the format<br>
// <code>{fieldName:errors, fieldName:errors}</code><br>
// where each <code>errors</code> object will be either an error message string or an array
// of error message strings.
// @group errors
// @visibility external
//<
getErrors : function () {
    return this.errors;
},


//> @method dynamicForm.getFieldErrors()
// Returns the current set of validation errors for some field in this form.
// @return (string | array of strings) Error message string, or if there is more than one error
//      associated with this field, array of error message strings.
// @group errors
// @visibility external
//<
// Note that the fieldName doesn't have to be associated with a form item - this could be
// a validator on a dataSource field too.
getFieldErrors : function (fieldName) {
    if (!this.errors) return null;
    if (isc.isA.FormItem(fieldName)) fieldName = fieldName.getFieldName();
    return this.errors[fieldName];
},


//>	@method	dynamicForm.setErrors() ([A])
// Setter for validation errors on this form. Errors passed in should be a Javascript object
// of the format<br>
// <code>{fieldName1:errors, fieldName2:errors}</code><br>
// Where the <code>errors</code> value may be either a string (single error message) or an
// array of strings (if multiple errors should be applied to the field in question).
// @param	errors		(object)	list of errors as an object with the field names as keys
// @param  showErrors  (boolean)   
//      If true redraw form to display errors now. Otherwise errors can be displayed by calling
//      +link{DynamicForm.showErrors()}<br>
//      Note: When the errors are shown, 
//      +link{dynamicForm.handleHiddenValidationErrors(), handleHiddenValidationErrors()} will
//      be fired for errors on hidden fields, or with no associated formItem.
//		@group	errors
//      @visibility external
//<
setErrors : function (errors, showErrors) {

	this.errors = isc.DynamicForm.formatValidationErrors(errors);
    
    var hasHiddenErrors = false,
        hiddenErrors = {};
        
    for (var fieldName in this.errors) {
        var item = this.getItem(fieldName);
        if (!item || !item.visible) {
            hiddenErrors[fieldName] = this.errors[fieldName];
            hasHiddenErrors = true;
        }
    }
    
    // pass in current set of hidden errors - we know they're up to date so no need to
    // call 'getHiddenErrors()' again
    if (showErrors) this.showErrors(this.errors, hiddenErrors);
    
},

//>	@method	dynamicForm.setError()  ([A])
//          Sets error message(s) for the specified itemName to the error string or array of
//          strings. You must call form.markForRedraw() to display the new error message(s).<br>
//          <b>Note:</b> you can call this multiple times for an individual itemName
//			 which will result in an array of errors being remembered.
//
//		@param	itemName		(string)	name of the item to set
//		@param	errorMessage	(string|array)	error message string or array of strings
//		@group	errors
//      @visibility external
// @deprecated This method has been deprecated as of SmartClient release 5.7.
//  Use +link{DynamicForm.addFieldErrors()} or +link{DynamicForm.setFieldErrors()} instead
//<
setError : function (itemName, errorMessage) {
    var oldError = this.errors[itemName];
	if (!oldError) this.errors[itemName] = errorMessage;
	else {
		if (isc.isA.String(oldError)) this.errors[itemName] = [oldError, errorMessage];
		else this.errors[itemName].add(errorMessage);
	}
},


//>	@method	dynamicForm.addValidationError()	(A)
// Helper method to add a validation error (or array of errors) to a list of existing errors 
// (passed in).
// Avoids duplicating errors.
//		@group	validation
//
//		@param	errors			(object)		current set of errors 	{itemName:"error", itemName:["error 1", "error 2"]}
//		@param	itemName		(string)		name of the item that has the error
//		@param	errorMessage	(string)		actual error message
//
//		@return	(boolean)		returns true so caller knows an error was found
// @visibility internal
//<
// Not intended for public use - this is for directly updating an errors object.
// Developers would call the public addFieldErrors() [or related APIs] instead.
addValidationError : function (errors, itemName, errorMessage) {
    if (isc.isAn.Array(errorMessage)) {
        for (var i = 0; i < errorMessage.length; i++) {
            this.addValidationError(errors, itemName, errorMessage[i]);
        }
        return;
    }
	if (!errors[itemName]) {
		errors[itemName] = errorMessage;
	} else {
        if (!isc.isAn.Array(errors[itemName])) errors[itemName] = [errors[itemName]];
        
        if (!errors[itemName].contains(errorMessage)) errors[itemName].add(errorMessage);
	}
	// return true that an error was found
	return true;
},


//>	@method	dynamicForm.addFieldErrors()
// Adds field validation error[s] to the specified field. Errors passed in will be added
// to any existing errors on the field caused by validation or a previous call to this method.
// <br>
// The errors parameter may be passed in as a string (a single error message), or an array of
// strings.<br>
// The showErrors parameter allows the errors to be displayed immediately. Alternatively, call
// +link{DynamicForm.showFieldErrors()} to display the errors for this field.
// @param fieldName (string) field to apply the new errors to
// @param errors (string | array of strings) errors to apply to the field in question
// @param show (boolean) If true this method will fall through to +link{dynamicForm.showFieldErrors} 
// to update the display
// @group errors
// @visibility external
//<
// Not clear whether this is necessary in addition to 'setFieldErrors()', but this matches
// the previous 'setError()' method implementation, which was public in 5.6.
addFieldErrors : function (fieldName, errors, showErrors) {
    if (!this.errors) this.errors = {};
    
    this.addValidationError(this.errors, fieldName, errors);

    // Don't bother updating hiddenErrors - this will be updated by 
    // showErrors() / showFieldErrors()
    
    if (showErrors) this.showFieldErrors(fieldName);
},


//>	@method	dynamicForm.setFieldErrors()
// Set field validation error[s] for some field.<br>
// The errors parameter may be passed in as a string (a single error message), or an array of
// strings.<br>
// The showErrors parameter allows the errors to be displayed immediately. Alternatively, an
// explicit call to +link{DynamicForm.showFieldErrors()} will display the errors for this field.
// @param fieldName (string) field to apply the new errors to
// @param errors (string | array of strings) errors to apply to the field in question
// @param show (boolean) If true this method will fall through to +link{dynamicForm.showFieldErrors} 
// to update the display
// @group errors
// @visibility external
//<
setFieldErrors : function (fieldName, errors, showErrors) {
    if (this.errors == null) this.errors = {};
    this.errors[fieldName] = errors;
    
    // Don't bother updating hiddenErrors - this will be updated by 
    // showErrors() / showFieldErrors()
    
    if (showErrors) this.showFieldErrors(fieldName);
},


//> @method dynamicForm.clearFieldErrors()
// Clear any validation errors on the field passed in.
// @param fieldName (string) field to clear errors from
// @param show (boolean) If true this method will fall through to +link{dynamicForm.showFieldErrors} 
// to update the display 
// @group errors
// @visibility external
//<
clearFieldErrors : function (fieldName, show) {
    if (this.errors == null) return;
    if (!this.errors[fieldName]) return;
    
    delete this.errors[fieldName];
    if (show) {
        this.showFieldErrors(fieldName);
    }
},

//>	@method	dynamicForm.clearErrors()   ([])
//	Clears all errors for this DynamicForm.
// @param show (boolean) If true, redraw the form to clear any visible error messages.
// @group	errors
// @visibility external
//<
clearErrors : function (show) {
	this.setErrors({}, show);
},


//>	@method	dynamicForm.hasErrors()
// Return whether this form currently has any validation errors.<br>
// Validation errors are set up automatically by validation, or may be explicitly set via
// +link{dynamicForm.setErrors()} or +link{dynamicForm.setFieldErrors()}.
// @return	(boolean)	true == form currently has validation errors.
// @group	errors
// @visibility external
//<
hasErrors : function () {
	var errors = this.errors;
	if (!errors) return false;
    for (var name in errors) {
		if (errors[name] != null) return true;
	}
	return false;
},

//> @method dynamicForm.hasFieldErrors()
// Does this form currently h ave any validation errors on the field passed in?<br>
// Validation errors are set up automatically by validation, or may be explicitly set via
// +link{dynamicForm.setErrors()} or +link{dynamicForm.setFieldErrors()}.
// @param fieldName (string) field to test for validation errors
// @return (boolean) true if the form has outstanding errors for the field in question.
// @group errors
// @visibility external
//<
hasFieldErrors : function (fieldName) {
	var errors = this.errors;
	return (errors && errors[fieldName] != null);
},


// Drawing and redrawing
// --------------------------------------------------------------------------------------------

//>	@method	dynamicForm.draw()	(A)
// Focuses in the first form field on idle
//
//		@group	drawing
//
//		@param	[document]		(DOM document)	document to draw in
//
//		@return	()
//<
_$_delayedSetValues:"_delayedSetValues",
_$_delayedSetValuesFocus:"_delayedSetValuesFocus",
draw : function (a,b,c,d) {
    if (isc._traceMarkers) arguments.__this = this;

	// draw the form as normal
    if (!this.readyToDraw()) return this;
	this.invokeSuper(isc.DynamicForm, this._$draw, a,b,c,d);
    
    // We've now written all our items into the DOM - notify them that they are drawn!
    this._itemsDrawn();

    
    var shouldFocus = this.autoFocus,
        functionName = (!shouldFocus ? this._$_delayedSetValues : this._$_delayedSetValuesFocus);
    this._setValuesPending = true;
	    
    isc.Page.setEvent(isc.EH.IDLE, this, isc.Page.FIRE_ONCE, functionName);

    
    if (this.position == isc.Canvas.RELATIVE) {
        isc.Page.setEvent(isc.EH.LOAD, this, isc.Page.FIRE_ONCE, "_placeCanvasItems");
    }

    return this;    
},

//>Safari

_adjustOverflowForPageLoad : function () {    
    if (isc.Browser.isSafari) {
        var items = this.getItems();
        if (this.isDrawn() && items) {
            for (var i = 0; i < items.length; i++) {
                items[i]._updateHTMLForPageLoad();
                // If the item the form to redraw completely we don't need individual items to
                // sort out their sizes since they'll get wiped out and redrawn anyway.
                if (this.isDirty()) break;
            }
        }
    }
    return this.Super("_adjustOverflowForPageLoad", arguments); 
},
//<Safari
    
// helper methods fired asynchronously after draw 
_delayedSetValues : function () {
    this.setItemValues(null, true);
    this.rememberValues();
    delete this._setValuesPending;
},

_delayedSetValuesFocus : function () {
    this._delayedSetValues();
    this.focus();
},


//>	@method	dynamicForm.redraw()
//		@group	drawing
//<
redraw : function () {

    
    // remember the current focus item, so we can put focus back into it after redraw.
    // (Only do this if the item currently has focus - IE the form itself is the focused widget)
    var focusItem = this.getFocusItem(),
        shouldRefocus = (focusItem ? (focusItem.hasFocus || focusItem._hadFocusBeforeRedraw) : false);        
    // If we're going to re-focus after redraw, remember the text selection, so we can reset it        
    if (shouldRefocus) focusItem.rememberSelection();

	// make sure we're not focused in any element
    if (isc.Browser.isMoz) this._blurFocusItemWithoutHandler();
    
    this._itemsRedrawing();

	// call the superclass method to redraw the form
	this.Super("redraw", arguments);
    
    // notify our items that they've been redrawn in the DOM.
    this._itemsRedrawn();

    
	this.setItemValues(null, true);

    
    var scrollLeft, scrollTop, clipHandle;
    if (isc.Browser.isMoz) {
        clipHandle = this.getClipHandle();
        if (clipHandle) {
            scrollLeft = clipHandle.scrollLeft;
            scrollTop = clipHandle.scrollTop;
        }
    }

    // If necessary, refocus in the current focus item
    if (this.isVisible() && shouldRefocus) {
        
        if (isc.Browser.isIE) {
            isc.Page.setEvent("idle", this.getID()+"._refocusAfterRedraw("
                                      + (focusItem ? focusItem.getID() : "") + ")",
                              isc.Page.FIRE_ONCE);
                              
        } else this._refocusAfterRedraw(focusItem);    
    }
    
    
    if (isc.Browser.isMoz) {
        if (scrollLeft != null && clipHandle.scrollLeft != scrollLeft) 
            clipHandle.scrollLeft = scrollLeft;
        if (scrollTop != null && clipHandle.scrollTop != scrollTop)
            clipHandle.scrollTop = scrollTop;
    }

    // Notify all our items that their positions may have been modified by the redraw.
    // This catches the many possible cases where the HTML written into the DF will have
    // changed, causing layout changes to visible form items.
    
    this.itemsMoved();
},


// When we draw / redraw, we want to notify our items that their HTML is now present in the DOM

_itemsDrawn : function () {
    var items = this.items;
    for (var i = 0; i < items.length; i++) {
        if (items[i] && items[i].visible) items[i].drawn();
    }
},

_itemsRedrawn : function () {
    var items = this.items;
    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        if (!item) continue;
        if (item.visible) {
            item.isDrawn() ? item.redrawn() : item.drawn();
        } else if (item.isDrawn()) {
            item.cleared();
        }
    }
},

_itemsCleared : function () {
    var items = this.items;
    for (var i = 0; i < items.length; i++) {
        if (items[i].isDrawn()) items[i].cleared();
    }
},

// Notify items that are about to be redrawn BEFORE the redraw occurs as well as after

_itemsRedrawing : function () {
    var items = this.items;
    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        if (!item) continue;
        if (item.visible && item.isDrawn()) item.redrawing();
    }
},



modifyContent : function () {
    // NOTE: we have to place Canvas items after the form's table has been redrawn, but before
    // adjustOverflow, so that CanvasItems do not force a shrinking form to stay full size
    this._placeCanvasItems();
},

// _refocusAfterRedraw() - fired after a redraw (on idle in IE) to put focus back into the
// item that currently has focus
_refocusAfterRedraw : function (item) {
    // Shouldn't be called with a null item, but no op if this does happen
    if (item == null) return;
    // Normalize from ID (possibly) to an item
    item = this.getItem(item);

    var currentFocusItem = this.getFocusItem(),
        focusCanvas = isc.EH.getFocusCanvas();

    // This method is called after a redraw. If focus has explicitly moved to a different
    // item in the form, or to another widget, avoid re-focussing.
    if (currentFocusItem != item || (focusCanvas != this && focusCanvas != null)) {
        
    } else {
        // put real focus back into the item
        this._focusInItemWithoutHandler(item);
        // update back to the remembered selection
        item.resetToLastSelection();
    }

    // in some cases we hang a flag on a focus item before redraw to enable us to determine
    // that it is the focus item while getting it's innerHTML.
    // Clear this flag after focussing.
    if (item._hadFocusBeforeRedraw) delete item._hadFocusBeforeRedraw;
},

_placeCanvasItems : function () {
    return this._notifyCanvasItems("placeCanvas");
}, 

// a utlity for making notification calls to all CanvasItems 
_notifyCanvasItems : function (method) {
    // don't JS error if CanvasItem not included
    if (!isc.CanvasItem) return;

    for (var i = 0; i < this.items.length; i++) {
        var item = this.items[i];
        if (item && isc.isA.CanvasItem(item)) item[method]();
    }
},

//> @method	dynamicForm.redrawFormItem()  
// Redraw the form item passed in.  This should handle re-evaluating showIf / visible property
// on the item, and width/height, as well as updating the HTML content of the item.
// Default implementation just marks the form for redraw.
//  @param  item    (FormItem)  Form item to be redrawn.
//<

redrawFormItem : function (item, reason) {

    var items = this.getItems();
    if (!item || !items.contains(item)) return;

    // Set this._itemsChanged so when we redraw we'll re-run the TableResizePolicy before 
    // This is required for showing / hiding items or changing colSpan, etc.
    
    this._itemsChanged = true;
    this.markForRedraw(item.ID + ": " + (reason ? reason : "redrawFormItem"));
},

// for debugging purposes only
getElementValues : function () {
    var values = {};
	for (var i = 0; i < this.items.length; i++) {
		var item = this.items[i],
            value = item.getDataElement() ? item.getDataElement().value : "[no element]";
        
        values[item[this.fieldIdProperty]] = value;
    }
    return values;
},


setItemValues : function (values, onRedraw, initTime, items) {

	// get the item values from the values object if it was not passed in.
    var setToExisting = (values == null);
	if (setToExisting) values = this.getValues();
    if (values == null) values = {};
    items = items || this.items;
	for (var itemNum = 0; itemNum < items.length; itemNum++) {
		var item = items[itemNum],
            fieldName = item.getFieldName(),
            isSetToDefault = item.isSetToDefaultValue(),
            value;            
          
        if (fieldName) value = values[fieldName];
        
        if (onRedraw && isc.CanvasItem && isc.isA.CanvasItem(item) &&
            
            !item._useHiddenDataElement()) 
        {
            continue;
        }

        var undefined,
            
            isUndefined = (!fieldName || value === undefined);
                    
        if (item.shouldSaveValue == false) {           
            if (!isUndefined) {
                // If the item is marked as shouldSaveValue false, but we've been passed a
                // value for it, assume the developer wants the item store a value in the
                // values array, so turn 'shouldSaveValue' back on for that item.
                //>DEBUG
                this.logInfo("DynamicForm.setValues() passed a value for '" + item[this.fieldIdProperty] + "'." +
                             " The corresponding form item was declared with 'shouldSaveValue' set to " +
                             " false to exclude its value from the form's values object." +
                             " Setting 'shouldSaveValue' to true for this item." +
                             "\n[To avoid seeing this message in the future, set 'shouldSaveValue'" +
                             " to true for any form items whose values are to be managed via " +
                             " form.setValues() / form.getValues().]")
                //<DEBUG
                item.shouldSaveValue = true;
            } else {
                
                var oldItemValue = (isSetToDefault ? null : item._value);
                item.setValue(oldItemValue, (isSetToDefault ? false : onRedraw));
                continue;
            }

        }
        // If the value is undefined, we want to use 'item.clearValue()' to reset to the
        // default value.  Note that in order to cause defaultValues to be re-evaluated on a
        // redraw, if an item has it's default value we need to call clearValue() rather than
        // restoring the old default value.
        if (isUndefined || (setToExisting && isSetToDefault)) {
            
            var undef;
            if (!initTime) item.clearValue();
            else if (initTime && isSetToDefault && item._value !== undef) {
                item.saveValue(item._value, true);
            }
        } else {            
            //this.logWarn("setValues() setting item:" + item + " to value:" + value, "formValues");        
            
            item.setValue(value, true);
        }
	}
},

// Drawing
// --------------------------------------------------------------------------------------------

_$absolute:"absolute",
_absPos : function () {
    //!DONTCOMBINE
    return this.itemLayout == this._$absolute;
},


//>	@method	dynamicForm.getInnerHTML()	(A)
//			Output the HTML for this form
//		@group	drawing
//
//		@return	(string)				HTML for the form		
//<
_$showIf:"showIf",
_$showIfArgs:"item,value,form,values",
_$closeForm:"</FORM>",
_$tablePolicy:"tablePolicy",
_$colWidthEquals:"<COL WIDTH=",

_$topRowTag:(isc.Browser.isIE ? "<TR STYLE='position:absolute'>" : "<TR>"),
_$topRowCellStart:[
    "<TD style='",
    isc.Canvas._$noStyleDoublingCSS,
    "height:0px;overflow:hidden;padding:0px;' class='",
    null,            
    "'>",
    (isc.Browser.isSafari ? "<div style='overflow:hidden;height:0px'>" : "")
],
            
_$topRowCellEnd:(isc.Browser.isSafari ? "</div></TD>" : "</TD>"),
_$cellStart:"<TD>",
_$cellEnd:"</TD>",
_$rowStart:"<TR>",
_$rowEnd:"</TR>",
_$br:"<br>",
_$tableFormClose:"</TABLE></FORM>",

getInnerHTML : function () {
    
	// get a StringBuffer to hold the output
	var output = isc.StringBuffer.create();

    
	
	// start the form tag
    if (this.writeFormTag && !this.isPrinting) output.append(this.getFormTagStartHTML());

	// get the values and items
	var values = this.values,
		items = this.items
	;

    // Check Visibility / Disabled State
	// --------------------------------------------------------------------------------------------

	// iterate through the items, marking items as invisible if their .showIf is false
	// keep track if the visibility has changed or not
	var visibilityChanged = false;
    
	for (var itemNum = 0; itemNum < items.length; itemNum++) {
        var item = items[itemNum],
            visible = item.visible;

		// if the item has a showIf method
		//	evaluate that to see whether the item should be visible or not.
		//	We note if the visible states of any items changes so we can know to recalculate
		//		form layout if visibility of any items has changed.
		if (item.showIf) {
			// CALLBACK API:  available variables:  "item,value,form,values"
			// Convert a string callback to a function
            isc.Func.replaceWithMethod(item, this._$showIf, this._$showIfArgs);
			
			var value = item.getValue();
            
            visible = (item.showIf(item,value,this,values) == true);
        }
        if (visible && this.isPrinting) {
            // shouldPrint takes precedence over whether it's a control or not, etc
            
            if (item.shouldPrint != null) {
                visible = item.shouldPrint;
            } else if (visible && this.currentPrintProperties.omitControls) {
                var omitControls = this.currentPrintProperties.omitControls;
                for (var i = 0; i < omitControls.length; i++) {
                    var cName = omitControls[i];
                    if (isc.isA[cName] && isc.isA[cName](item)) {  
                        visible = false;
                    }
                }
            }
        }
        
			
        if (visible != item.visible) {
            item.visible = visible;
            // If the item is marked to take up space even when it's hidden, don't reflow
            // on show/hide
            if (!item.alwaysTakeSpace) visibilityChanged = true;
        }

	}
    
	// if the dynamic visibility for any item(s) has changed, or the _itemsChanged flag has
    // been set, throw away any cached tableResizePolicy for the size of the form elements, etc.
    // We set the _itemsChanged flag when we modify the items array (adding/removing items)
    // or modify other things that invalidate the cache (like changing title orientation, 
    // visibility of items, etc)
	if (visibilityChanged || this._itemsChanged) isc.Canvas.invalidateTableResizePolicy(items);
    this._itemsChanged = false;

	// set the required property of any fields that are conditionally required
	this.setRequiredIf();

    // Layout
	// --------------------------------------------------------------------------------------------

    // if flattenItems is set, summing columns, taking into account showTitle and colSpan
    // settings, as well as title orientation (titleOrientation:"top" means the title
    // doesn't take up a column)

    if (this.flattenItems) {
        var flatCols = null;

    	for (var itemNum = 0; itemNum < items.length; itemNum++) {
            var item = items[itemNum];

            // if this field is not hidden or if it is and takes space
            // increment the total columns
            if (item.visible || item.alwaysTakeSpace) flatCols++;

            // if this field has a displayed title on the left,
            // increment the total columns
            if (item.showTitle && item.titleOrientation != "top")
                flatCols++;

            // if there is a colSpan set, make a copy of it and nullify it
            item._colSpan = item.colSpan || null;
            item.colSpan = null;
        }

        if(flatCols) {
            this.numCols = flatCols;
            this._itemsChanged = true;
            this.markForRedraw();
        }
    }


    if (this._absPos()) {
    
        output.append(this.getAbsPosHTML());

    	// end the form
	    output.append(this._$closeForm);
	
    	return output.release()
    }
    
	// start the table
	output.append(this.getTableStartHTML());

    // generate evenly spaced colWidths if no explicit colWidths have been provided and
    // titleWidth is set to *
    if (this.titleWidth == this._$star && !this.colWidths) {
        this.colWidths = [];
        for (var i = 0; i < this.numCols; i++) this.colWidths[i] = this._$star;
    }

	// set up the colWidths array 
	var colWidths;
    
	// if the form has colWidths defined, use those
	if (this.colWidths) {
		colWidths = this.colWidths;
        if (colWidths.length > this.numCols) {
            this.logWarn("colWidths Array longer than numCols, using only first " + 
                         this.numCols + " column widths");
            colWidths = colWidths.slice(0, this.numCols);
        } else if (colWidths.length < this.numCols) {
            this.logWarn("colWidths Array shorter than numCols, remaining columns get '*' size");
            for (var i = colWidths.length; i < this.numCols; i++) colWidths[i] = isc.star; 
        }
	} else {
	    // otherwise create default column widths, based on the assumption that every other
        // column will be full of labels and so should have DF.titleWidth.
        // NOTE: We'll have a column full of labels by default because each item in the form
        // takes up two columns in the table: one for the label, the other for the native form
        // element itself.  We do it this way so that a series of textboxes will line up.
		colWidths = [];

		var totalWidth = this.getInnerContentWidth();
        
        // Take off cellBorder - this is actually the border of the native HTML <table>
        totalWidth -= (this.cellBorder != null ? this.cellBorder : 0);
		
        // NOTE: items that actually try to fit within the column width take into account
        // cellSpacing and cellPadding via FormItem.getInnerWidth()

        // if an odd number of columns is specified, assume the last column is an element
        // column, as a column of dangling labels is unlikely.  To produce reasonable layout,
        // a form with an odd number of columns will probably need to specify colWidths..
		var	titleCols = Math.floor(this.numCols/2),
            // total width for all label columns
            totalElementColWidth = totalWidth - (titleCols * this.titleWidth),
            // width of each form element column
            elementColWidth = Math.floor(totalElementColWidth / (this.numCols-titleCols));
        // don't let it get too small
        elementColWidth = Math.max(this.minColWidth, elementColWidth);

		for (var i = 0; i < titleCols; i++) {
			// add a column for the label
			colWidths.add(this.titleWidth);
			// add a column for the form element
			colWidths.add(elementColWidth);
		}
        // for an odd number of columns, take on another element column
        if ((this.numCols % 2) != 0) colWidths.add(elementColWidth);
        if (this.logIsInfoEnabled(this._$tablePolicy)) {
            this.logInfo("totalWidth: " + totalWidth + ", generated colWidths: " + colWidths,
                         this._$tablePolicy);
        }
	}
	// run the tableResizePolicy on the list to set up the table of form items
	//	this assigns sizes to dynamic items as well as populating the structure
	//	that maps items to particular rows/cols
    //   Note: This will set up the _size property on the items as a 2 element array, where
    //   the first element represents the desired width, and the the second the height.
    //   For some items getInnerHTML() will make use of this property to specify the elements 
    //   drawn size, though if not available, the standard item.width, item.height will be used 
    //   instead.

    var innerWidth = this.getInnerContentWidth(),
        innerHeight = this.getInnerContentHeight();

    
    if (this.cellSpacing != 0) {
        if (isc.Browser.isMoz) innerHeight -= 2*this.cellSpacing;
        else if (isc.Browser.isSafari) innerHeight -= this.cellSpacing;
    }   

    items._defaultRowHeight = this.defaultRowHeight;    
	isc.Canvas.applyTableResizePolicy(items, innerWidth, innerHeight, 
                                      this.numCols, colWidths);

    
    var overflowed = false;
    if (isc.CanvasItem) {
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            if (isc.isA.CanvasItem(item) && item.checkCanvasOverflow()) {
                if (!overflowed && this.logIsInfoEnabled(this._$tablePolicy)) {
                    this.logInfo("CanvasItem: " + item + " overflowed, rerunning policy",
                                 this._$tablePolicy);
                }
                overflowed = true;
            }
        }
    }

    if (overflowed) {
    	isc.Canvas.applyTableResizePolicy(items, innerWidth, innerHeight,
                                          this.numCols, colWidths, null, true);
    }
	
    colWidths = items._colWidths;
    
	// output <COL> tags to set the sizes of the columns.
    
	for (var colNum = 0; colNum < colWidths.length; colNum++) {
        var colWidth = colWidths[colNum];
        output.append(this._$colWidthEquals, colWidth, this._$rightAngle);
    }

    

    
    
	// if fixedColWidths is set, force column widths to be respected as minimums by writing
    // out a row of cells with spacers.  <COL> tags on their own won't enforce minimums.
    output.append(this._$topRowTag);

    for (var colNum = 0; colNum < colWidths.length; colNum++) {
        var innerWidth = colWidths[colNum];
        // NOTE: correct for spacing, but *do not* correct for padding, because we write out
        // padding:0px on the cells
        innerWidth -= (this.cellSpacing!= null ? (2 * this.cellSpacing) : 0);
        // The top row has theoretically a height of zero px, but can actually be visible in IE
        // if it has a bg-color applied to it.
        // We've seen this occur with a stylesheet that globally sets td background-color.
        // handle this by applying standard form cell style
         
        this._$topRowCellStart[3] = (isc.FormItem ? isc.FormItem.getPrototype().baseStyle : null);
    
        var spacerHeight = isc.Browser.isIE ? 1 : 0,
            cellStart = this._$topRowCellStart.join(isc.emptyString);
        output.append(cellStart, 
                      this.fixedColWidths ? isc.Canvas.spacerHTML(innerWidth,spacerHeight) : null,
                      this._$topRowCellEnd);
    }
    output.append(this._$rowEnd);

	// if this.autoSendTarget is set, add a '__target__' hidden field so that the server knows the
    // name of the frame/window this form is being targetted at.
	if (this.autoSendTarget && this.target) output.append(this._getAutoSendTargetHTML());
    
    // Draw HTML for Items
	// --------------------------------------------------------------------------------------------
    
    
    
    // Handle this by tracking items to include in the next cell in an array, to be updated 
    // in the loop while writing cells out.
    var includeInNextCell = [];
    
	// for each item in the list, get HTML output for it and combine the output
	for (var itemNum = 0, len = items.length; itemNum < len; itemNum++) {
    
        // get a pointer to the item for that field
		var item = items[itemNum];
		// if a null item, skip it
		if (!item) continue;
        
        var visible = item.visible;
		// note that the value of this item can't possibly be dirty anymore
        item._markValueAsNotDirty();
		  
		//>DEBUG
        if (this.logIsDebugEnabled()) this.logDebug("Drawing FormItem: " + item); //<DEBUG
		
		// if the item has been marked as invisble, skip it unless it's marked to take space
        // even when hidden
		if (!item.alwaysTakeSpace && !visible) continue;

        // if this item should not take up a cell, we'll include it in the next cell's HTML
        // (Unless we're the last item, in which case, just take up a cell!)
        if ((item.rowSpan == 0 || item.colSpan == 0) && itemNum < len-1) {
            includeInNextCell.add(item);
            continue;
        }		

		// get the error for this form element
		var column = item.getFieldName(),
			error = item.getErrors(),
			value = item.getValue(),
            titleOrientation = this.getTitleOrientation(item);
		
		// if the error is an empty string, null it out
		if (isc.is.emptyString(error)) error = null;

		// if the item should start its row or passes the name boundary
		// 	output the end and start row tag
        //  Note: _startRow attribute set up via Canvas.applyTableResizePolicy()
		if (item._startRow || itemNum == 0) {
			if (itemNum != 0) output.append(this._$rowEnd);
            if (item._emptyRows > 0) {
                for (var i = 0; i < item._emptyRows; i++) output.append(this._$rowStart, this._$rowEnd);
            }
			output.append(this._$rowStart);
            if (item._emptyCells > 0) {
                for (var i = 0; i < item._emptyCells; i++) output.append(this._$cellStart, this._$cellEnd);
            }
		}

		// place title on the left of the item, in it's own cell 
		if (titleOrientation == isc.Canvas.LEFT) {
			output.append(this.getTitleCellHTML(item, error));
		}
		
		// output the tag start for the item if it has a positive row and colSpan
		output.append(this.getCellStartHTML(item, error));

        // place title on top of the item, with no separate cell
		if (visible && titleOrientation == isc.Canvas.TOP) {
			output.append(this.getTitleSpanHTML(item, error), this._$br);
		}

		// if there is an error associated with the item, output that
        var showErrors = (visible && error && this.showInlineErrors); 
		if (showErrors && item.getErrorOrientation() == isc.Canvas.TOP) {
            output.append(this.getItemErrorHTML(item, error));
        }
        

        // if any items are being 'piggy backed' into this item's cell, write them out now.	    
        if (includeInNextCell.length > 0) {
            for (var m = 0; m < includeInNextCell.length; m++) {
                if (!includeInNextCell[m].visible) continue;
                output.append(includeInNextCell[m].getInnerHTML(includeInNextCell[m].getValue()));
            }
            // drop the old 'includeInNextCell' array for the next item.
            includeInNextCell.length = 0;
        }
        
		// output the innerHTML for the item
        if (visible) {
            // pass in the parameter to write out the hint text and validation errors 
            // along with the form item
            // Note if validation error orientation is top or bottom we write the error out 
            // as part of this method - otherwise we need to write the error out in the form 
            // item HMTL (like the hint)
            output.append(item.getInnerHTML(value, true, true));

        } else output.append(isc.Canvas.spacerHTML(item.width, item.height));
        
        // Top and bottom orientation are handled by writing the error HTML out here -- left
        // and right orientation will be handled as part of formItem.getInnerHTML
        if (showErrors && item.getErrorOrientation() == isc.Canvas.BOTTOM) {
            output.append(this.getItemErrorHTML(item, error));
        }
  	

		// append the tag end for the item
		output.append(this.getCellEndHTML(item, error));

		// place title on right of item, in it's own cell
		if (titleOrientation == isc.Canvas.RIGHT) {
            output.append(this.getTitleCellHTML(item, error));
        }

	}
	
    // end the current row
    if (items.length > 0) output.append(this._$rowEnd);
    
	// end the table and form
    if (this.writeFormTag && !this.isPrinting) output.append(this._$tableFormClose);
    else output.append("</TABLE>");
	
	return output.release();
},

// Any children of the form are likely to be canvasItems' canvii which are written out inline
// via code in CanvasItem.js
getPrintChildren : function () {
    return null;
},

createErrorItem : function () {
    var errorItem = isc.addProperties({cellStyle:this.errorItemCellStyle}, 
                                      this.errorItemDefaults,
                                      this.errorItemProperties);

    this.addItems([errorItem], 0);
    this._errorItem = this.getItem(0);
    
},

//>@method getErrorsHTML()
// If +link{dynamicForm.showInlineErrors} is false, the form will render all errors in a list at
// the top of the form. This method returns the HTML for this list of errors.
// @param errors (object) Map of field names to error messages. Each field may contain a single
//                        error message (string) or an array of errors
// @return (HTML) error HTML.
// @group validation
// @visibility external
//<
getErrorsHTML : function (errors) {
    if (!errors || isc.isAn.emptyObject(errors)) return isc.emptyString;
    var errorString = this.errorsPreamble; 
    errorString += "<UL>";
    for (var field in errors) {
        
        var item = this.getItem(field), message;
        if (item) message = item.getErrorMessage(errors[field])
        // Field with no associated item (ds field?) Just display the error as normal
        else {
            message = errors[field];
            if (isc.isAn.Array(message)) 
                message = "<ul><li>" + message.join("</li><li>") + "</li></ul>";
        }
        errorString += "<LI>" + (item ? item.getTitle() : field) + " : " + message + "</LI>"
        
    }
    errorString += "</UL>";
    
    return errorString;
    
},

//>@method dynamicForm.getItemErrorHTML()
// If +link{dynamicForm.showInlineErrors} is true, this method is called for each item in the form
// and returns the error HTML to be written out next to the item.<br>
// Default implementation falls through to +link{FormItem.getErrorHTML()} on the item in question.
// @param item (FormItem) Form item for which the HTML should be retrieved
// @param error (string | array) Error message to display for the item, or array of error message
//                              strings.
// @group validation
// @visibility external
//<
getItemErrorHTML : function (item, error) {
    return item.getErrorHTML(error);
},

// Helper to generate the input required for the autoSendTarget feature
_$autoSendTargetTemplate:[
      "<INPUT TYPE=HIDDEN NAME='" , 
      , // target field name
      "' VALUE='" , 
      , // target 
      "'>"
],
_getAutoSendTargetHTML : function () {
    this._$autoSendTargetTemplate[1] = this.autoSendTargetFieldName;
    this._$autoSendTargetTemplate[3] = this.target;
    return this._$autoSendTargetTemplate.join(isc.emptyString);
},
 

//>	@method	dynamicForm.getCellStartHTML()	(A)
//			Return the HTML for start tag of this item's cell.
//		@group	drawing
//
//		@param	item	(formItem)	item in question
//		@param	error	(string)	error for this item
//
//		@return	(HTML)	output for the start tag
//<
getCellStartHTML : function (item, error) {
    
	// get the colSpan for the item, which might be a "*"
	var colSpan = item.getColSpan(),
        rowSpan = item.getRowSpan();

    // colSpan / rowSpan of zero is handled by writing the form item out into the next form
    // item's cell.
    // However if the last item in a form has rowSpan / colSpan of zero, we need to put it into its
    // own cell, so we should treat it as having rowSpan / colSpan of 1.
    if (colSpan == 0) colSpan = 1;
    if (rowSpan == 0) rowSpan = 1;
    
	// if the colSpan is a "*", set it appropriately
	if (colSpan == "*") {
		var startCol = (item._tablePlacement ? item._tablePlacement[0] : 0);
		colSpan = (this.numCols - startCol);
	}
    
    var className = item.getCellStyle();
    
    // Use the height calculated by tableResizePolicy rather than the specified size (may be
    // null, "*" or a percentage).
    
    var height = item._size ? item._size[1] : null;
    if (isc.isA.Number(height) && this.cellSpacing != 0) height -= 2*this.cellSpacing;
    
    return this._getCellStartHTML(
        (item.align ? item.align : 
                       ((this.form? this.form.isRTL() : this.isRTL()) ? isc.Canvas.RIGHT : isc.Canvas.LEFT)),

        
        className,
        rowSpan,
        colSpan,
                
        null, 
        
        (this.fixedRowHeights ? height : null),
        
        null,
        item.cssText,
        (this.form ? this.form.getID() : this.getID()),
        item.getItemID(),
        item.getFormCellID()
    );
},

_getCellStartHTML : function (align, className, rowSpan, colSpan, width, height, 
                              extraStuff, cssText, formID, itemID, cellID, nowrap) 
{
	var output = isc.StringBuffer.create(),
        ns = isc._emptyString;

    output.append(
		"<TD ALIGN=", align,
            (className != null ? " CLASS='" + className + "'" : ns),
            " STYLE='", (cssText != null ? cssText : ns), "'",
                      
           (rowSpan > 1 ? " ROWSPAN=" + rowSpan: ns),
           (colSpan > 1 ? " COLSPAN=" + colSpan : ns),
           (width != null ? " WIDTH=" + width : ns),
           (height != null ? " HEIGHT=" + height : ns),
           (extraStuff != null ? extraStuff : ns)
    );

    
    // If this is the containing cell for some item, write in ID and 'containsItem' attribute
    // for the item.
    // This method is used for cells containing things other than the form items, such as icons
    // in which case we'll avoid writing in these attributes.
    if (cellID) {
        output.append(" ID=", cellID, " ");
    }
    if (itemID && formID) {
        
        output.append(isc.DynamicForm._containsItem, "='",itemID,"'");
        
    }
    
    
    output.append(nowrap ? "><NOBR>" : ">");

	return output.release();
    
},

//>	@method	dynamicForm.getCellEndHTML()	(A)
//		@group	drawing
//			Return the HTML for start tag of this item's cell.
//
//		@param	item	(formItem)	item in question
//		@param	error	(string)	error for this item
//
//		@return	(HTML)	output for the start tag
//<
getCellEndHTML : function (item, error) {

	// otherwise return a simple end of cell
	return  this._getCellEndHTML();
},

_getCellEndHTML : function (nowrap) {
    return nowrap ? "</NOBR></TD>" : "</TD>";
},

//>	@method	dynamicForm.getTitleOrientation()	(A)
// Return the orientation of the title for this item.
//<
getTitleOrientation : function (item) {
    if (!item.shouldShowTitle()) return null;
    return item.titleOrientation || this.titleOrientation || isc.Canvas.LEFT;
},

//>	@method	dynamicForm.getTitleAlign()	(A)
// Get the alignment for the title for this item, taking into account RTL vs LTR text direction
// as a default.
//<
getTitleAlign : function (item) {
    var form = this.form || this; // for ContainerItem method-stealing hack
    return (item.titleAlign ? item.titleAlign : 
            this.titleAlign ? this.titleAlign :
            // textDirection: set the direction of the titles according to the text direction
            // if not specified
            this.isRTL() ? isc.Canvas.LEFT : isc.Canvas.RIGHT);
},

// titleHeight / getTitleHeight
// When calculating the size of items for tableResizePolicy, if the title is written into the
// items cell (for titleAlign:top), we need to take the height of the title into account
// so "*" sized items can take up the approprite amount of space.

titleHeight:15,
getTitleHeight : function (item) {
    var form = this.form || this; // for ContainerItem method-stealing hack
    return (item.titleHeight != null ? item.titleHeight : this.titleHeight);
},

//>	@method	dynamicForm.getTitleSpanHTML()	(A)
// Return the HTML for a FormItem's title, wrapping in SPAN rather than a table cell so that it
// doesn't affect the table used for Layout
//
//   @group	drawing
//		@param	item		(FormItem)	Item to show title of.
//		@param	error		(string)	error message for this item
//		@return	(HTML)	HTML output for this element
//<
getTitleSpanHTML : function (item, error) {
	var output = isc.StringBuffer.create();

    output.append("<SPAN ", this._containsItemTitleAttrHTML(item),
                  " CLASS='", item.getTitleStyle(),
                  "' ALIGN=", this.getTitleAlign(item),
                  ">"); 

    // get the actual title from the item
    output.append(this.getTitleHTML(item, error));

	// now end the title span
	output.append("</SPAN>");
	// and return the whole thing
	return output.release();
},

// Should a specific form item's title be clipped?
shouldClipTitle : function (item) {
    if (!item || !item.form == this) return false;
    return (item.clipTitle != null ? item.clipTitle : this.clipItemTitles);
},

//>	@method	dynamicForm.getTitleCellHTML()	(A)
//			Output a title cell for a FormItem.
//		@group	drawing
//
//		@param	item		(FormItem)	Item to show title of.
//		@param	error		(string)	error message for this item
//
//		@return	(HTML)	HTML output for this element
//<

_$heightColon:"height:", _$widthColon:"width:",_$maxWidthColon:"max-width:",
_$maxHeightColon:"max-height:",_$heightColon:"height:",
_$NOBR:"<NOBR>", _$innerTitleTableClose:"</td></tr></TABLE>", _$divClose:"</DIV>", _$tdClose:"</TD>",

_outerTitleCellTemplate:[
    "<TD ", // 0
    , // 1: this._containsItemTitleAttrHTML(item)
    " CLASS='", // 2
    , // 3: className
    "' ALIGN=", // 4
    , // 5: this.getTitleAlign(item)
    , // 6: possible rowspan
      // NOTE: based on the titleOrientation, this may want to output colSpan OR rowSpan based
      // on the original item size. For now we just respect rowspan
    ">" // 7
],

_titleClipDivTemplate:[
    
    "<DIV style='overflow:hidden;text-overflow:ellipsis;",  // 0
    
    , // 1: possible white-space:nowrap
    , // 2: possible width
    , // 3: possible height
    "'>" // 4
],

_titleInnerTableTemplate:[
    "<TABLE height=",   // 0
    , // 1: height
    " border=0 cellspacing=0 cellpadding=0><tr><td class='", // 2
    , // 3: className
    // Override any style attributes that would look wrong double-applied by the className
    "' style='" + isc.Canvas._$noStyleDoublingCSS + "' ALIGN='", // 4
    , // 5: this.getTitleAlign(item)
    "'>",   // 6
    null    // 7: <NOBR>
],

getTitleCellHTML : function (item, error) {
	var output = isc.StringBuffer.create(),
        className = item.getTitleStyle(),
        titleAlign = this.getTitleAlign(item);

    // get the item title cell start
    var cellTemplate = this._outerTitleCellTemplate;
    cellTemplate[1] = this._containsItemTitleAttrHTML(item);
    cellTemplate[3] = className;
    cellTemplate[5] = titleAlign;

    if (item.getRowSpan() > 1) cellTemplate[6] = " ROWSPAN=" + item.getRowSpan();
    else cellTemplate[6] = null;
    
    
    
	output.append(cellTemplate.join(isc.emptyString));
    output.append(this.getTitleCellInnerHTML(item, error));
    
	// now end the title cell
	output.append(this._$tdClose);

	// and return the whole thing
	return output.release();
},

// Content of the title cell
getTitleCellInnerHTML : function (item, error) {
        
    // Use the width / height calculated by TableResizePolicy rather than the specified
    // height / titleWidth properties.
    // Note that this is the total available space for the cell rather than the inner
    // space, so we need to adjust for styling.
    
    var output = isc.StringBuffer.create(),
        className = item.getTitleStyle(),
        titleAlign = this.getTitleAlign(item),
        titleWidth = item._titleWidth || null,
        height = item._size ? item._size[1] : null,
    
        clipTitle = this.shouldClipTitle(item),
        // Unless explicitly specified, wrap unclipped titles, but don't wrap clipped titles
        wrapTitle = (item.wrapTitle != null ? item.wrapTitle : 
                    (this.wrapItemTitles != null ? this.wrapItemTitles : !clipTitle));
        
    
    
    // Adjust titleWidth/height for padding applied by this.cellPadding this.cellSpacing, & 
    // the title class name
    if (height) {
        if (this.cellSpacing) height -= 2*this.cellSpacing;   
        
        var tPadding, bPadding;
        if (className) {
            tPadding = isc.Element._getTopPadding(className, true);
            bPadding = isc.Element._getBottomPadding(className, true);
        }
        if (tPadding == null) tPadding = this.cellPadding || 0;
        if (bPadding == null) bPadding = this.cellPadding || 0;
        
        height -= (tPadding + bPadding)
        
        if (className) height -= isc.Element._getVBorderSize(className);
    }

    if (titleWidth) {
        if (this.cellSpacing) titleWidth -= 2*this.cellSpacing;                
        var lPadding, rPadding;
        if (className) {
            lPadding = isc.Element._getLeftPadding(className, true);
            rPadding = isc.Element._getRightPadding(className, true);
        }
        if (lPadding == null) lPadding = this.cellPadding || 0;
        if (rPadding == null) rPadding = this.cellPadding || 0;
        
        titleWidth -= (lPadding + rPadding)
        titleWidth -= isc.Element._getHBorderSize(className);
    }
    
    var heightProperty = isc.Browser.isMoz ? this._$maxHeightColon : this._$heightColon,
        widthProperty = isc.Browser.isMoz ? this._$maxWidthColon : this._$widthColon;

    if (clipTitle) {
        var divTemplate = this._titleClipDivTemplate;
        
        // We're using explicit NOBR tags if we're writing out a nested table so we'll only
        // use white-space:nowrap in Moz when we're not wrapping.
        if (wrapTitle || !isc.Browser.isMoz) divTemplate[1] = null;
        else divTemplate[1] = "white-space:nowrap;";

        if (titleWidth != null) divTemplate[2] = widthProperty + titleWidth + "px;"
        else divTemplate[2] = null;
        
        if (height != null) divTemplate[3] = heightProperty + height + "px;"
        else divTemplate[3] = null;
        
        output.append(divTemplate.join(isc.emptyString));
        
        // If we're not in moz, add a nested table to force centering
        if (!isc.Browser.isMoz) {
            var innerTableTemplate = this._titleInnerTableTemplate;
            innerTableTemplate[1] = height;
            innerTableTemplate[3] = className;
            innerTableTemplate[5] = titleAlign;
            if (!wrapTitle) innerTableTemplate[7] = this._$NOBR
            else innerTableTemplate[7] = null;
            
            output.append(innerTableTemplate.join(isc.emptyString));
        }
        
    // use NOBR to suppress wrapping. (white-space:nowrap inside a TD works in Moz but not IE)
    } else if (!wrapTitle) { 
        output.append(this._$NOBR);
    }
    // get the actual title from the item
    output.append(this.getTitleHTML(item, error));
    
    if (clipTitle) {
        if (!isc.Browser.isMoz) output.append(this._$innerTitleTableClose);
        output.append(this._$divClose);
    }

	// and return the whole thing
	return output.release();
},

// Helper method for item title cell identifiers

_containsItemTitleAttrHTML : function (item) {
    if (!isc.DynamicForm._itemTitleAttrHTML) {
        isc.DynamicForm._itemTitleElementAttrHTML =  [
            " ", isc.DynamicForm._containsItem, "='", 
            null,   // item ID
            "' ",
            isc.DynamicForm._itemPart, "='", isc.DynamicForm._title, "' ",
            // Also apply a unique ID so we can grab a pointer to the cell for re-styling 
            // without redrawing the form as a whole.
            "ID="
             // title cell ID
        ];
    }
    isc.DynamicForm._itemTitleElementAttrHTML[3] = item.getItemID();
    // [Item ID is unique]
    isc.DynamicForm._itemTitleElementAttrHTML[10] = this._getTitleCellID(item);
    return isc.DynamicForm._itemTitleElementAttrHTML.join(isc.emptyString);
},

_getTitleCellID : function (item) {
    return this._getDOMID(item.getID() + "_titleCell");
},

getTitleCell : function (item) {
    if (!this.isDrawn()) return null;
    // Ensure we normalize name etc to an item object.
    item = this.getItem(item);
    if (!item) return null;
    return isc.Element.get(this._getTitleCellID(item));
},

// We support custom state-based styles for item titles. 
// This method will apply the current style for the title item's title cell
updateTitleCellState : function (item) {
    var titleCell = this.getTitleCell(item);
    if (titleCell == null) return;
    item = this.getItem(item);
    
    // Apply the style to the cell, and also redraw the content of the cell.
    // This will handle things like:
    // - applying updated style to inner (clipping) table if necessary
    // - applying / clearing required title prefix / suffix
    // - picking up any custom state-based HTML returned by getTitleHTML()
    titleCell.className = item.getTitleStyle();
    titleCell.innerHTML = this.getTitleCellInnerHTML(item, item.getErrors());
},


//>	@method	dynamicForm.getTitleHTML()	(A)
//	Output the HTML for a title for a FormItem.
//		@group	drawing
//
//		@param	item		(FormItem)	Item to show title of.
//		@param	error		(string)	error message for this item
//
//		@return	(HTML)	HTML output for this element
//<
getTitleHTML : function (item, error) {
    
	var output = isc.StringBuffer.create();

	// get the title to display
    
    var title = item.visible ? item.getTitleHTML() : null;
	if (title) {
		// item is required if its user-setable required property OR its derived _required property is true
		var required = (item.required || item._required),
            orientation = this.getTitleOrientation(item),
            leftPrefix = (orientation == isc.Canvas.LEFT || orientation == isc.Canvas.TOP);
		
		// if the title is defined, output the titlePrefix + title + titleSuffix
		output.append(
			(required && this.hiliteRequiredFields ? 
                (leftPrefix ? this.requiredTitlePrefix : this.requiredRightTitlePrefix) : 
                (leftPrefix ? this.titlePrefix : this.rightTitlePrefix))
			, title
			, (required && this.hiliteRequiredFields ? 
                (leftPrefix ? this.requiredTitleSuffix : this.requiredRightTitleSuffix) : 
                (leftPrefix ? this.titleSuffix : this.rightTitleSuffix))
		);
	} else {
		// otherwise just output a space
		//	this prevents us from putting colons next to an empty title item
		output.append("&nbsp;");
	}
	
	// and return the whole thing
	return output.release();
},


//>	@method	dynamicForm.getFormTagStartHTML()	(A)
//		@group	drawing
//			Return the HTML to start the form object itself.
//		@return	(string)				HTML for the start form tag
//<
_$formTagStartTemplate:[
    "<FORM " ,                              // 0
    "ID",                                   // 1
    "=" ,                                   // 2
    ,                                       // 3: this.getFormID() 
    ,                                       // 4: absolute positioning, or null
    " METHOD=",                             // 5
    ,                                       // 6: this.method
    " ACTION='",                            // 7
    ,                                       // 8: this.action
    "' ENCTYPE=",                           // 9
    ,                                       // 10: multipart or normal encoding
    ,                                       // 11: Target= or null
    ,                                       // 12: target or null
    ,                                       // 13: close target quote or null
    
    " ONSUBMIT='return ",                   // 14
    ,                                       // 15: this.getID()
    "._handleNativeSubmit()' ONRESET='",    // 16
    ,                                       // 17: this.getID()
    
    // Do our proprietary reset rather than a real native reset.
    // There's no benefit to doing a native reset here, and it breaks certain items such
    // as date items.
    
    ".resetValues(); return false;'",       // 18
    
    
    (isc.Browser.isSafari ? " STYLE='display:inline;'" : null),   // 19
    
    
    " STYLE='margin-bottom:0px;'>"           // 20
],
_$absPosStyle:" STYLE='position:absolute;left:0px;top:0px;'",
_$targetEquals:" TARGET='",
getFormTagStartHTML : function () {
    var template = this._$formTagStartTemplate,
        FormID = this.getFormID(),
        ID = this.getID();
    template[3] = FormID;
    // In order to get an absPos item placed at 0,0 in Moz (but not IE), it's necessary
    // to absolutely position the <FORM> element, or Moz generates an extra line box
    // with this simple structure.  (change font size to verify the extra space is due
    // to a line box)
    // <DIV STYLE='position:absolute;LEFT:0px;TOP:0px;WIDTH:500px;HEIGHT:500px;'
    // ><div style="position:relative;"><form><div 
    // style="position: absolute; left: 0px; top: 0px;">foobar</div></form></div>
    if (this._absPos()) template[4] = this._$absPosStyle;
    else template[4] = null;
    
    template[6] = this.method;
    template[8] = this.action;
    
	if (this.isMultipart()) template[10] = isc.DynamicForm.MULTIPART_ENCODING;
    else template[10] = isc.DynamicForm.NORMAL_ENCODING;
    
    if (this.target != null) {
        template[11] = this._$targetEquals;
        template[12] = this.target;
        template[13] = this._$singleQuote;
    } else {
        template[11] = null;
        template[12] = null;
        template[13] = null;
    }
    
    
    template[15] = ID;
    template[17] = ID;
    
    return template.join(isc.emptyString);
},

//>	@method	dynamicForm.getTableStartHTML()	(A)
//		@group	drawing
//			Return the HTML to start the table drawn around this form.
//		@return	(string)				HTML for the start table tag
//<
_$tableStartTemplate:[
    "<TABLE ID='",          // 0
    ,                       // 1:  this._getTableElementID()
    "' ",                   // 2
    
    
	"WIDTH=",               // 3
    ,                       // 4: innerContentWidth / innerWidth
    " CELLSPACING=" ,       // 5
    ,                       // 6: this.cellSpacing
    " CELLPADDING=" ,       // 7
    ,                       // 8: this.cellPadding
    " BORDER=",             // 9
    ,                       // 10: this.cellBorder
    
    
    (isc.Browser.isMoz ? "><TBODY>" : ">") // 11
],
getTableStartHTML : function () {
    // This method is also applied to containerItems
    var template = isc.isA.DynamicForm(this) ? this._$tableStartTemplate : 
                                        isc.DynamicForm.getPrototype()._$tableStartTemplate;
    template[1] = this._getTableElementID();
    template[4] = (this.getInnerContentWidth != null ? this.getInnerContentWidth() 
                                                     : this.getInnerWidth());
    template[6] = this.cellSpacing;
    template[8] = this.cellPadding;
    template[10] = this.cellBorder;
    
    return template.join(isc.emptyString);
},

// Methods to access the table element for this form
_$table:"table",
_getTableElementID : function () {
    return this._getDOMID(this._$table);
},

_getTableElement : function () {
    return isc.Element.get(this._getTableElementID());
},


// Resizing:
// If we're showing any items whos sizes depend on the specified form size, 
// redraw on resize to force them to be recalculated and redrawn
layoutChildren : function (a,b,c,d) {
    this.invokeSuper(isc.DynamicForm, "layoutChildren", a,b,c,d);
    var items = this.getItems();
    if (!items) return;
    for (var i = 0; i< items.length; i++) {
        // redraw for any percent sized / "*" width child
        var width = items[i].width, height = items[i].height;
        if ( 
            (isc.isA.String(width) && (width.contains("%") || width.contains("*"))) ||
             (isc.isA.String(height) && (height.contains("%") || height.contains("*"))) )
        {
            
            this.markForRedraw("size change with dynamic size children");
            break;
        }
    }
},

getAbsPosHTML : function () {
    var output = isc.SB.create();
	// for each item in the list, get HTML output for it and combine the output
	for (var itemNum = 0, len = this.items.length; itemNum < len; itemNum++) {
    
        // get a pointer to the item for that field
		var item = this.items[itemNum];
		// if a null item, skip it
		if (!item) continue;
		// note that the value of this item can't possibly be dirty anymore
        item._markValueAsNotDirty();

		// if the item has been marked as invisble, skip it
		if (!item.visible) continue;

        output.append(item.getStandaloneItemHTML());
    }

    //this.logWarn("absPos HTML: " + output.toString());

    // Allow the SB to be reused
    return output.release()
},



getScrollWidth : function (recalculate) {
    if (this._deferredOverflow) {
        this._deferredOverflow = null;
        this.adjustOverflow("widthCheckWhileDeferred");
    }
    // reimplement caching code
    // Note: important to use the same cache field name because __adjustOverflow() invalidates it.
    if (!recalculate && this._scrollWidth != null) return this._scrollWidth;
    
    var width;
    // call super the fast way if we don't have absolutely positioned items
    if (!isc.Browser.isIE || !this._absPos() || 
        !(this.isDrawn() || this.handleDrawn()) || this.items == null) 
    {
        width = isc.Canvas._instancePrototype.getScrollWidth.call(this, recalculate);
    } else {
        width = 0;
        for (var i = 0; i < this.items.length; i++) {
            var item = this.items[i];
            if (item.visible == false || !item.isDrawn()) continue;
            
            var handle = item.getAbsDiv();
            if (handle) {
                var itemRight = handle.scrollWidth + item._getPercentCoord(item.left);
                if (itemRight > width) width = itemRight;
            }
        }
    }
    this._scrollWidth = width;
    return width;
},

getScrollHeight : function (recalculate) {
    if (this._deferredOverflow) {
        this._deferredOverflow = null;
        this.adjustOverflow("heightCheckWhileDeferred");
    }
    // reimplement caching code
    // Note: important to use the same cache field name because __adjustOverflow() invalidates it.
    if (!recalculate && this._scrollHeight != null) return this._scrollHeight;
    
    var height;
    // call super the fast way if we don't have absolutely positioned items
    if (!isc.Browser.isIE || !this._absPos() || 
        !(this.isDrawn() || this.handleDrawn()) || this.items == null) 
    {
        height = isc.Canvas._instancePrototype.getScrollHeight.call(this, recalculate);
    } else {
        height = 0;
        for (var i = 0; i < this.items.length; i++) {
            var item = this.items[i];
            if (item.visible == false || !item.isDrawn()) continue;
            
            var handle = item.getAbsDiv();
            if (handle) {
                var itemBottom = handle.scrollHeight + item._getPercentCoord(item.top, true);
                if (itemBottom > height) height = itemBottom;
            }
        }        
    }
    this._scrollHeight = height;
    return height;

},

// Submitting
// --------------------------------------------------------------------------------------------

// _formWillSubmit() - will this form perform a direct submission
// If true we need to ensure we write out native elements for each form item 
// (using hidden elements if necessary)
// Note that we need to consider 2 kinds of direct submission:
// - if this.canSubmit is true, and the user hits a submit button (or 'submit()'/ 'submitForm()' 
//   are called, we're performing a completely standard HTML direct submission to the 
//   action URL specified by the developer
// - We also in some cases use direct submission to convey RPC operations. 
//   Cases where this occurs when saveData() is called:
//      - this.canSubmit is true
//      - this.action has been specified (differs from the class prototype value)
//      - isMultipart() is true
// In each of these cases return true to indicate a direct submission will occur
_formWillSubmit : function () {
    return this.canSubmit || this.isMultipart() || 
            (this.action != isc.DynamicForm.getPrototype().action);
},

//>	@method	dynamicForm.submitForm()    ([])
// Submits the form to the URL defined by +link{dynamicForm.action}, 
// identically to how a plain HTML &lt;form&gt; element would submit data,
// as either an HTTP GET or POST as specified by +link{dynamicForm.method}.
// <P>
// <b>Notes:</b>
// <ul>
// <li>this is used only in the very rare case that a form is used to submit data
// directly to a URL.  Normal server contact is through 
// +link{group:dataBoundComponentMethods,DataBound Component Methods}.</li>
// <li>For this method to reliably include values for every field in the grid, 
//      +link{DynamicForm.canSubmit} must be set to <code>true</code></li>
// <li>To submit values for fields that do not have an editor, use +link{HiddenItem} 
// with a +link{formItem.defaultValue} set.  This is analagous to &lt;input type="hidden"&gt;
// in HTML forms.
// </ul>
//      @visibility external
//		@group	submitting
//<
submitForm : function () {
    if (!this._formWillSubmit()) {
        this.logWarn("Attempt to perform direct submission on DynamicForm where this.canSubmit " +
                     "is false. Please set this property to true, or use the standard databinding " +
                     "interfaces to send data to the server.");
    }
    // If we have a FileItem as an item in this form, apply our other field values to it and
    // perform a direct submit
    
    var fileItemForm = this.getFileItemForm();
    if (fileItemForm) {        
        var values = this.getValues();
        delete values[fileItemForm.getItems(0).name];
        for (var fieldName in values) {
            fileItemForm.setValue(fieldName, values[fieldName]);
        }
        fileItemForm.setAction(this.action);
        fileItemForm.target = this.target;
        fileItemForm.submitForm();
        return;
    }
    var form = this.getForm();
    if (!form) return;
    // Update the action laziliy if necessary - required for the case where it has been modified	 
    // after draw	 
    
    if (form.action != this.action) form.action = this.action;
    return form.submit();
},

//> @method DynamicForm.setAction()
// Sets the +link{DynamicForm.action,action} for this form.
// @param action (URL) New action URL
// @visibility external
//<
setAction : function (action) {
    this.action = action;
    var form = this.getForm();
    if (form) form.action = action;
},


// If we have a FileItem in this form, this helper method will return a pointer to its form 
getFileItemForm : function () {
    if (!isc.FileItem) return null;
    var items = this.getItems() || [];
    for (var i = 0; i < items.length; i++) {
        if (isc.isA.FileItem(items[i])) return items[i].canvas;
    }
    return null;
},

// _handleNativeSubmit.
// This method is fired from the onsubmit handler for the HTML form for this DynamicForm widget.
// The onsubmit handler will fire whenever a user action would normally trip a form submission
// These cases are:
// - If there's a submit element on the form and the user clicks it
// - If there's a submit element on the form and the user is focussed in a Text item, and
//   hits enter.
// - If there's a single text element in the form only (even if there is no submit item) and 
//   the user hits enter while focussed in it
// We disallow native submission by returning false from this method in each of these cases
// because:
// - we never write out a native submit element (our submitItem is a buttonItem subclass)
// - we have our own more reliable handling for submitting on Enter keypress, explicitly handled
//   by our keypress handler.
// Note that onsubmit does NOT fire when form.submit() is called programatically, so this has
// no effect except on the user interactions listed above.  
// We can therefore always return false to suppress this event.
_handleNativeSubmit : function () {
    return false;  
},



// Validation
// --------------------------------------------------------------------------------------------


//>	@method	dynamicForm.validate()  ([])
// Validates the form without submitting it, and redraws the form to display error messages
// if there are any validation errors. Returns true if validation succeeds, or false if
// validation fails.<br>
// For databound forms, any Datasource field validators will be run even if there is no 
// associated item in the form.<br>
// Validators will also be run on hidden form items<br>
// In both these cases, validation failure can be handled via 
// +link{DynamicForm.handleHiddenValidationErrors()}
//
// @param validateHiddenFields (boolean) Should validators be processed for non-visible fields
//         such as dataSource fields with no associated item or fields with visibility set to
//         <code>"hidden"</code>?
// @return (boolean) true if validation succeeds, or false if validation fails.
// @visibility external
// @group	validation
// @example validationType
//<


validate : function (validateHiddenFields, ignoreDSFields) {
    if (this.disableValidation) return true;

	var hadErrorsBefore = this.hasErrors(),		// remember if we had errors before
												// so we'll redraw the form if this
												// validation pass finds no errors
		errorsFound = false,
		firstErrorItem = null,
		form = this.getForm(),
        hasChanges = false
	;
    
    // We need to validate:
    // - form items with validators
    // - values that map to DS fields with validators.
    // (we don't need to worry about values with no associated field as there is no way to
    //  specify validators for such fields)
	var errors = {},
        hiddenErrors = {},
	    values = this.getValues(),
        // fields are returned from ds in {fieldName:fieldObject} format
        dsFields = (validateHiddenFields && !ignoreDSFields && this.dataSource) 
                        ? isc.addProperties({}, this.getDataSource().getFields()) 
                        : null;
        
	// now look to each item and handle it's validate list
	//	the validate list is an object or an array of objects, of the form:
	//
	//			{type:"validatorType", errorMessage:"message", optionalParam:"", ...}
	//
	//		where validator is of a set of validation types and errorMessage is to be 
    //      displayed if validation returns false
	//
	//		within that eval, assume that 	- "this" is the Form Canvas, 
	//										- "form" is the form itself,
	//										- "item" is a pointer to the field item record
	//										- "value" is the value of the item as shown in the form
    // Note that when validating ContainerItem (e.g. DateItem) form items, only the
    // ContainerItem itself is validated, and not any of its sub-items.
	for (var itemNum = 0; itemNum < this.items.length; itemNum++) {
		var fieldErrorsFound = false,
        
            // get the field item
            item = this.items[itemNum],
    		// get the name of this column in the values
		    column = item.getFieldName(),
			// get the value of this item
			value = item.getValue(),
            hidden = !item.visible || isc.isA.HiddenItem(item)
		;
        
        if (hidden && !validateHiddenFields) continue;
        
        if (item.validators != null) {
            
    		// normalize item.validators to an array.
    		if (!isc.isAn.Array(item.validators)) {
    			item.validators = [item.validators];
    		}	
    
    		// Get a pointer to the validators.
    		var validators = item.validators;
    			
    		// Process each validator in turn.
            //>DEBUG
            this.logDebug("Applying " + validators.length + " validators to field '" + column + 
                          "' with value '" + value + "'"
                        //+ ", validators are: " + this.echoAll(validators)
                        );
            
            //<DEBUG
    		for (var v = 0; v < validators.length; v++) {
    			var validator = validators[v];
    			if (!validator) continue;
    			// process the validator and, if an error was found, save the error
    			var validatorIsValid = this.processValidator(item, validator, value);
    			if ( validatorIsValid != true) {
    				// remember the error
                    var errorMessage = isc.Validator.getErrorMessage(validator);
                    if (errorMessage == null) errorMessage = this.unknownErrorMessage;
    				fieldErrorsFound = this.addValidationError(errors, column, errorMessage);
                    if (fieldErrorsFound) errorsFound = true;
    			} 
    
    			// if the validator returned a resultingValue, use that as the new value
    			//	whether the validator passed or failed.  This lets us transform data
    			//	(such as with the mask validator).
    			if (validator.resultingValue != null) { 
    				// remember that value in the values list
    				value = values[column] = validator.resultingValue;
                    hasChanges = true;
    			}
    
    			// if the validator wants us to stop if it wasn't passed, break out of the
                // validators loop
    			if (!validatorIsValid && validator.stopIfFalse) break;
    		}
        }
        
        
        // Only check for required fields if other, more specific validation didn't fail 
        // on the field
        if (item.required && !errors[column]) {
			if (value == null || isc.is.emptyString(value)) {
            	fieldErrorsFound = this.addValidationError(errors, column, 
                                                  isc.Validator.requiredField);
                if (fieldErrorsFound) errorsFound = true;
     		}
        }
        
        // If the item is not visible, copy the errors so we can run a method to let the
        // developer handle errors on hidden fields
        // Note that this includes 'hiddenItems' that are not marked as visible:false
        if (hidden) {
            if (fieldErrorsFound) hiddenErrors[column] = errors[column];

        // Remember the first visible error item so we can restore focus to it            
        } else if (firstErrorItem == null && errorsFound) firstErrorItem = item;
        
        // Validators applied to an item are a superset of the validators applied to
        // a dataSource field - therefore no need to run DSField validators for this field
        if (dsFields) delete dsFields[column];
    }
    
    // Explicitly run through datasource field validators
    if (dsFields) {    
        for (var i in dsFields) {
            
           var fieldObject = dsFields[i],
               fieldName = i,
               validators = fieldObject.validators,
               required = fieldObject.required,
               value = values[fieldName];

            if (required && value == null) {
                // handle this type of error
                this.addValidationError(errors, fieldName, isc.Validator.requiredField);
                
            } else if (validators != null) {
                var value = values[fieldName];

                // iterate through the validators again, this time actually checking each one
                for (var i = 0; i < validators.length; i++) {
                    // validators is an array of validator objects, each of which has the form
                    //    {type:"validatorType", errorMessage:"message", optionalParam:"", ...}
                    var validator = validators[i];
                    if (!validator) continue;
                    // Unless we're looking at a 'requiredIf' field, don't try to validate
                    // null values.
                    if (validator.type != "requiredIf" && value == null) {
                        continue;
                    }
                    // pass the dataSource field object into processValidator.
                    // This is required for some validators 
                    // [eg: retrieving the valueMap for isOneOf]
                    if (!this.processValidator(fieldObject, validator, value)) {
                        var errorMessage = validator.errorMessage || this.unknownErrorMessage;
                        this.addValidationError(errors, fieldName, errorMessage);
                    }
                }
            }
            
            if (errors[fieldName] != null) hiddenErrors[fieldName] = errors[fieldName];
        }
    }
	
    //>DEBUG
    if (errorsFound) this.logInfo("Validation errors: " + isc.Log.echoAll(errors));
    //<DEBUG 

	// set the error messages for the form whether any were found or not
	this.setErrors(errors);
    
    // if validation changes values, update the visible values in the form elements, which will
    // automatically update this.values
	if (hasChanges) {
        this.setItemValues(values);
        // directly save values for which there are no form elements
        for (var field in values) {
            if (this.getItem(field) == null) this._saveValue(field, values[field]);
        }
    }
    
    // redraw if we found new errors or if we previously had errors which must be cleared from view
    if (errorsFound || hadErrorsBefore) this.showErrors(errors, hiddenErrors);
    
	return !errorsFound;
},

//> @method DynamicForm.getValidatedValues()
// Call +link{dynamicForm.validate()} to check for validation errors. If no errors are found,
// return the current values for this form, otherwise return null.
// @return (object|null) current values or null if validation failed.
// @group errors
// @visibility external
//<
getValidatedValues : function () {
    // validate the form
    // This will cause the form to redraw automatically if it has new errors 
    // (or it had errors before and doesn't now).
     
    if (!this.validate()) return null;
    return this.getValues();
}, 

//> @method DynamicForm.showErrors()
// If this form has any outstanding validation errors, show them now.<br>
// This method is called when the set of errors are changed by +link{dynamicForm.setErrors()} or
// +link{dynamicForm.validate()}.<br>
// Default implementation will redraw the form to display error messages and call
// +link{DynamicForm.handleHiddenValidationErrors(), handleHiddenValidationErrors()} to
// display errors with no visible field.<br>
// Note that this method may be overridden to perform custom display of validation errors.  
// @group errors
// @visibility external
//<
// Additional 'errors' / 'hiddenErrors' parameters
// Used internally when we have just calculated the errors, as well as which fields are visible 
// and which are hidden
// contains an object of fieldName to error mappings for fields that are not visible.
// Not public - if this method is being called by the user, always re-calculate which fields are
// visible /hidden. This is cleaner than tracking the hidden errors in a separate object as we'd
// have to update that each time fields were shown / hidden, etc.
showErrors : function (errors, hiddenErrors) {

    var undef;
    if (hiddenErrors === undef) hiddenErrors = this.getHiddenErrors();
    if (errors === undef) errors = this.getErrors();
    
    // If we have errors and we're not showing them inline, we need to auto-generate a blurb
    // item at the top of the form to display the errors.
    // Do this in showErrors only - this way if showInlineErrors is set to false, and this
    // method is overridden the developer will be suppressing this default approach.
    if (errors && !this.showInlineErrors && (!this._errorItem || this._errorItem.destroyed))
        this.createErrorItem();
    
    // Redraw whether there are outstanding errors or not. This means that this method will 
    // also clear visible errors that have been resolved.
    this.markForRedraw("Validation Errors Changed");
    

    if (errors && !isc.isAn.emptyObject(errors)) {
        for (var fieldName in errors) {
            var item = this.getItem(fieldName);
            // if an error item was found, set the focus to that item
            
            if (item && item.isVisible() && item.isDrawn()) {
                this._focusInItemWithoutHandler(item);
                break;
            }
        }
    }
    // if we're showing the blurb at the top of the form scroll it into view.
    // Do this on a delay to allow IE to asynchronously complete focussing in the first error item 
    if (!this.showInlineErrors) {
        this.delayCall("scrollIntoView", [0,0], 100);
    }
    
    if (hiddenErrors) {    
        this._handleHiddenValidationErrors(hiddenErrors);
    }
},

getHiddenErrors : function () {
    if (!this.errors) return null;
    var hasHiddenErrors = false, hiddenErrors = {};
    
    for (var fieldName in this.errors) {    
        var item = this.getItem(fieldName);
        if (!item || !item.visible) {
            hasHiddenErrors = true;
            hiddenErrors[fieldName] = this.errors[fieldName];
        }
    }    
    return (hasHiddenErrors ? hiddenErrors : null);
},

//> @method DynamicForm.showFieldErrors () 
// If this form has any outstanding validation errors for the field passed in, show them now.
// Called when field errors are set directly via +link{dynamicForm.setFieldErrors()} / 
// +link{dynamicForm.addFieldErrors} / +link{dynamicForm.clearFieldErrors()}.<br>
// Default implementation simply falls through to +link{dynamicForm.showErrors()}.
// @param fieldName (string) field to show errors for
// @group errors
// @visibility external
//<
// This can be called if errors are being updated individually on a per field basis.
// Note that calling handleHiddenVlaidationErrors will actually fire the handler and pass in
// the full set of hidden errors. We could have a more fine grained method 
// like 'handleHiddenFieldValidationErrors()' instead.

showFieldErrors : function (fieldName) {
    return this.showErrors();
},

// _handleHiddenValidationErrors()
// Internal method to display validation errors when we can't show them in a form.
// This is used to handle 
// - errors coming from hidden form items
// - errors coming from a dataSource field for which we have no form item.
_handleHiddenValidationErrors : function (errors) {
    if (errors == null || isc.isAn.emptyObject(errors)) return;

    // If we have an implementation to handle the hidden validation errors, call it now.
    var returnVal;
    if (this.handleHiddenValidationErrors) {
        returnVal = this.handleHiddenValidationErrors(errors);
    }
    
    
    // returning false suppresses the log warn statement
    if (returnVal == false) return;

    var errorString = "Validation errors occurred for the following fields " +
                        "with no visible form items:";
                        
    for (var fieldName in errors) {
        var fieldErrors = errors[fieldName];
        if (!isc.isAn.Array(fieldErrors)) fieldErrors = [fieldErrors];
        if (fieldErrors.length == 0) continue;
            
        errorString += "\n" + fieldName + ":";
        for (var i = 0; i < fieldErrors.length; i++) {
            errorString += (i == 0 ? "- " : "\n - ") + fieldErrors[i];
        }
    }
    
    this.logWarn(errorString, "validation");
},

// process all the validators for an item


//>	@method	dynamicForm.processValidator()	(A)
//		@group	validation
//			process a single validator for a given form item
//
//		@param	item		(object)	form item in question
//		@param	validator	(object)	validation object
//		@param	value		(string)	value for this item
//
//		@return	(boolean)	true == passed validation, false == validation failed
//<
processValidator : function (item, validator, value, type) {
    return isc.Validator.processValidator(item, validator, value, type);
},


//>	@method	dynamicForm.setRequiredIf()	(A)
// Iterate through the items, setting the _required property of any item with a requiredIf
// to correspond to the evaluation that property
//
//			some fields may become required or not required
//		@group	validation
//<

_$requiredIf:"requiredIf",
setRequiredIf : function () {
	var values = this.getValues();

	// if any fields have 'requiredIf' set, set their required property now
	for (var itemNum = 0; itemNum < this.items.length; itemNum++) {
		var item = this.items[itemNum],
			validators = item.validators
		;
		// if item is not visible or it has no validators, skip it
		if (!item.visible || !validators || validators.length == 0) continue;
		
		for (var v = 0; v < validators.length; v++) {
			var validator = validators[v];
			if (!validator) continue;
			if (validator.type == this._$requiredIf) {
				var value = item.getValue();
				// CALLBACK API:  available variables:  "item,validator,value"
				// Convert a string callback to a function
				if (validator.expression != null && !isc.isA.Function(validator.expression)) {
					isc.Func.replaceWithMethod(validator, "expression", 
                                                     "item,validator,value");
				}
				
				// set the hidden value for item._required according to the results of the 
				item._required = validator.expression.apply(this, [item, validator, value]);
			}
		}
	}	
},



//>	@method	dynamicForm.setFocusItem()	(A)
//  Internal method used to track which form item last had focus.
//  The focusItem is updated with this method whenever an item recieves focus.  When focus()
//  is called on the form, the focusItem will then be given focus.
//  Can be retrieved via 'getFocusItem()', and cleared via 'clearFocusItem()'
//  Note that the focusItem may not currently have focus - focus could be on another widget.
//  Check formItem.hasFocus to see if an item currently has focus.
//
//		@group eventHandling, focus
//		@param	item (formItem)	item to focus in
//<
setFocusItem :  function (item) {
	// normalize the item passed in
	item = this.getItem(item);
	this._focusItem = item;
},

//>	@method	dynamicForm.getFocusItem()	(A)
// Return a pointer to the item that currently has the keyboard focus (or if focus has been
// taken from the form, the form item that last had focus).
// <P>
// May be null.
//
// @group eventHandling, focus
//
// @return (item) returns the item that has the focus, or null if no item is currently focused
//<

getFocusItem : function () {
	return this._focusItem;
},

// Override _readyToFocus() -- if this DF is not drawn, it may still be appropriate to give it
// focus as it's items may be written into a container widget.
_readyToSetFocus : function () {

    return !this.isDisabled();
    
    
},

// Override 'setFocus()' to update item focus.
setFocus : function (hasFocus) {
    if (!this._readyToSetFocus()) return;
    var visible = this.isVisible();
    if (hasFocus) {

        // focus back in the last focus item if there is one.
        var item = this.getFocusItem();
        if (item == null) {
            var items = this.getItems();
            for (var i = 0; i < items.length; i++) {
                var testItem = items[i];
                if (testItem._canFocus() && testItem.isDrawn() && 
                    testItem.isVisible() && !testItem.isDisabled()) 
                {
                    item = testItem;
                    break;
                }
            }
        }
        
        // If we got a click on the form item background don't force focus into the current focus
        // item.
        
        var event = isc.EH.lastEvent;
        if (!(event.target == this && event.eventType == isc.EH.MOUSE_DOWN)) {
            // No need to call Super because focussing in the item will trigger the 
            // elementFocus() method which updates this.hasFocus, etc.
            return this.focusInItem(item);
        }
    }
    this.Super("setFocus", arguments);
    // Override 'blur()' to take focus away from the focus item, as well as clear out 
    // this.hasFocus.    
    if (!hasFocus) {
        
        // Note we use the internal _blurItem() method to avoid clearing out this._focusItem.
        // This means a subsequent 'focus()' call on this form will restore focus to the same 
        // item.
        this._blurItem(this.getFocusItem());
        
    }
},

// Override focusInNextTabElement() to put focus in the next form item if possible, before
// moving to the next widget on the page

_focusInNextTabElement : function (forward, mask, skipItems) {
    if (skipItems || !this.items || this.items.length == 0 || 
        (mask && isc.EH.targetIsMasked(this, mask))) 
    {
        return this.Super("_focusInNextTabElement", arguments);
    }

    // Determine the current focus item - if we don't have one, focus in the first item if
    // we're moving forward, or the last item if we're moving backwards
    var items = this.items,
        item = this.getFocusItem();
    if (item == null) {
        this.focusAtEnd(forward);
        return;
    }

    // Allow the focus to be shifted WITHIN an item
    
    while (item.parentItem) {
        if (item._moveFocusWithinItem(forward)) return;
        item = item.parentItem;
    }
    // one more check in case there was no parent item
    if (item._moveFocusWithinItem(forward)) return;
    
    item = this._getNextFocusItem(item, forward);
    
    // either focus in the next item, or shift to the next widget.
    if (item != null) {
        this.focusInItem(item);
    } else {
        
        // In this case we've reached the end of our items.
        // We basically want to call this.Super() to continue to the next widget.
        // Exception: If this form is the only focusable thing on the page, that method will 
        // call 'focus' in this form again (as it's both the first and last focusable widget
        // on the page!)... In this case, default focus behavior would mean focus would stay
        // in the current focus item, but we'd actually like to move back to the start of
        // our items. Explicitly catch and handle this case.
        if (isc.EH._firstTabWidget == this && isc.EH._lastTabWidget == this) {
            this.focusAtEnd(forward);
        } else {
            return this.Super("_focusInNextTabElement", arguments);
        }
    }
},

// _getNextFocusItem()
// Give a current item with focus - determine which item focus will next go to in response
// to Tab / shift+Tab

_getNextFocusItem : function (item, forward) {
    var items = this.items,
        originalItem = item,
        currentTabIndex = item.getGlobalTabIndex(), 
        nextItem, nextTabIndex,
        index = items.indexOf(item);
    for (var i = 0; i < items.length; i++) {
        if (items[i] == item) continue;
        var gti = items[i].getGlobalTabIndex();
        if (gti < 0) {            
            continue;
        }
        if (!this._canFocusInItem(items[i],true)) continue;
        if (forward) {
            // special case -- matching global tab index should go in the order in which 
            // items are defined
            if (gti == currentTabIndex && i > index) {
                nextItem = items[i];
                break;
            }
            if (gti > currentTabIndex &&
                (nextTabIndex == null || nextTabIndex > gti))
            {                
                nextItem = items[i];
                nextTabIndex = gti
            } 
        } else {
            if ((gti < currentTabIndex || (gti == currentTabIndex && index > i)) && 
                (nextTabIndex == null || nextTabIndex <= gti))
            {
                nextItem = items[i];
                nextTabIndex = gti;
            }
        }
    }
    return nextItem;
},

// Set the focus to the first or last focusable item
// start param indicates which end we want to focus in (if true go for the start of the items
// array)
focusAtEnd : function (start) {
    if (!this.items) return;
    var startItem,
        index,
        items = this.items;

    for (var i = 0; i < items.length; i++) {
        var item = items[i],
            gti = item.getGlobalTabIndex();
        if (gti < 0 || !this._canFocusInItem(item,true)) continue;
        if ((index == null) ||
            (start && gti < index) ||
            (!start && gti >= index)) 
        {
            startItem = item;
            index = gti;
        }
    }
    
    if (startItem && this._canFocusInItem(startItem, true)) this.focusInItem(startItem);
    // Handle the case where we have no focusable items - in this case just shift on to the
    // next focusable widget instead.
    else {
        var mask,
            registry = isc.EH.clickMaskRegistry;
        if (registry) {
            for (var i = registry.length -1; i >= 0; i--) {
                if (isc.EH.isHardMask(registry[i])) {
                    mask = registry[i];
                    break;
                }
            }
        }
        this._focusInNextTabElement(start, mask, true);
    }
},




// Helper - can we currently call 'focus' on an item?
_canFocusInItem : function (item, tabStop) {
    if (isc.isA.String(item)) item = this.getItem(item);
    return item && item._canFocus() && item.isDrawn() && item.isVisible() && !item.isDisabled()
            && (!tabStop || item.tabIndex != -1);
},

//>	@method dynamicForm.focusInItem()
// Move the keyboard focus into a particular item.
// @group eventHandling, focus
// @param	itemName 	(number|itemName|formItem)	Item (or reference to) item to focus in.
// @visibility external
//<
focusInItem : function (itemName) {

	// normalize the item in case it's a number or a string
	if (itemName != null) {
		var item = this.getItem(itemName);
	} else {
		var item = this.getFocusItem();
	}
	// if nothing was found to focus in, bail!
	if (!item) {
        this.logWarn("couldn't find focus item: " + itemName);
        return;
    }

    // if the item can accept focus
    if (item._canFocus()) {
        // focus in it 
        item.focusInItem();
        // elementFocus will fire 'setFocusItem()' in any case, but do this here as well to
        // avoid problems with elementFocus being fired asynchronously
        this.setFocusItem(item);
        if (this._setValuesPending) {
            var theForm = this;
		    isc.Page.setEvent("idle", 
                              function () { if (!theForm.destroyed) theForm.focusInItem(); },
                              isc.Page.FIRE_ONCE);
        }
    } else {
        // otherwise complain
        this.logWarn("focusInItem: item cannot accept focus: " + item);
    }
},

// removes the form instance's knowledge of the currently focused element, but does not actually
// blur the element
clearFocusItem : function () {
	delete this._focusItem;
},


//>	@method	dynamicForm.blurFocusItem()	(A)
//  Fires the blurItem() command on the focused item
//  @group eventHandling, focus
//<

blurFocusItem : function () {
    var focusItem = this.getFocusItem();
    if (focusItem != null) {
        this._blurItem(focusItem);
        // clear out the remembered focus item - this is an explicit blur, so we don't want
        // focus to go to that item.
        this.clearFocusItem();
    }
},

// Internal '_blurItem' method fires the blur method on the item passed in, if it has focus.
// This does not update this._focusItem, so can be used to blur the form entirely without
// losing track of which item has focus
_blurItem : function (item) {
    if (item != null) item.blurItem();
},

// _blurFocusItemWithoutHandler
// Internal method to blur the focus item, without triggering its blur handler.
// Will not clear out this._focusItem.

_blurFocusItemWithoutHandler : function () {
      
    var focusItem = this.getFocusItem();
    if (focusItem != null && focusItem.hasFocus) {
        if (this.__suppressBlurHandler == null) this.__suppressBlurHandler = 0;
        else this.__suppressBlurHandler += 1;
        // Call the internal _blurItem rather than the 'blurFocusItem' method as we don't want
        // to clear out this._focusItem
        this._blurItem(focusItem);  
    } else {
        this.logDebug("blur w/o handler: no item to blur");
    }
},

//_focusInItemWithoutHandler
// Internal method to focus in a form item without firing it's focus handler
_focusInItemWithoutHandler : function (item) {
    // If the item is non-focusable, no-op
    if (!item || !this._canFocusInItem(item)) {
        var parentItem;
        if (item && item.parentItem) {
            this._focusInItemWithoutHandler(item.parentItem);
            parentItem = true;
        }
        this.logInfo("_focusInItemWithoutHandler(" + item + 
                     "): not calling focus as item not focusable or item already has focus" + 
                     (parentItem ? ". Putting focus into containerItem instead." : ""),
                     "nativeFocus")
        return;
    }
    
    // If the item already has focus, no op
    // Note: In IE hasFocus is not a reliable check - it only gets updated on the asynchronous
    // onfocus handler - look directly at the document.activeElement to see where focus 
    // currently is instead.
    
    var hasFocus = item.hasFocus;
    if (isc.Browser.isIE) {
        var focusItemInfo = isc.DynamicForm._getItemInfoFromElement(document.activeElement);
        hasFocus = (focusItemInfo && focusItemInfo.item == item);
    }
    if (hasFocus) return;
    
    
    if (this.__suppressFocusHandler == null) this.__suppressFocusHandler = 0;
    else this.__suppressFocusHandler += 1;
    this.__suppressFocusItem = item;
    this.focusInItem(item);
},



setOpacity : function (newOpacity, animating, forceFilter, a,b,c) {
    var oldOp = this.opacity;
    this.invokeSuper(isc.DynamicForm, "setOpacity", newOpacity, animating, forceFilter, a,b,c);
    
    newOpacity = this.opacity;        
    if (isc.Browser.isMoz && this.hasFocus &&
        (newOpacity != oldOp) && 
        (newOpacity == null || newOpacity == 100 || oldOp == null || oldOp == 100) ) 
    {
        var item = this.getFocusItem();
        if (item && item._willHandleInput()) {
            this._blurFocusItemWithoutHandler();
            this._focusInItemWithoutHandler(item);
        }
    }
},

// clearingElement
// When a form item is cleared or redrawn, its element will be removed from the DOM
// this is a notification for this.

clearingElement : function (item) {
    
    if (this.__suppressFocusHandler != null && this.__suppressFocusItem == item) {
        delete this.__suppressFocusHandler;
        delete this.__suppressFocusItem;
    }
    if (this.__suppressBlurHandler != null && (this.getFocusItem() == item)) {
        delete this.__suppressBlurHandler;
    }
},

hide : function () {
    
    if (isc.Browser.isMoz) this._blurItem(this.getFocusItem());
    this.Super("hide", arguments);
},

// Override setVisibility to ensure that 'visibilityChanged' notifications are fired on the
// items in this form.
setVisibility : function (newVisibility,a,b,c) {
    this.invokeSuper(isc.DynamicForm, "setVisibility", newVisibility,a,b,c);
    this.itemsVisibilityChanged();
    // If we are shown and we are auto-focus true, focus now
    if (this.isVisible() && this.autoFocus) this.focus();
},

// override 'clear' to notify the form items that they have been hidden.

clear : function () {
    this.Super("clear", arguments);
    this.itemsVisibilityChanged()
    this._itemsCleared();
},

// If focus is taken from the form as a whole, ensure the focusItem's HTML element is blurred
_focusChanged : function (hasFocus) {
    this.Super("_focusChanged", arguments);
    
    if (!this.hasFocus) this._blurItem(this.getFocusItem());

},


parentVisibilityChanged : function (newVisibility) {
    //this.logWarn("parentVisibilityChanged, visible: " + this.isVisible());
    if (!this.isVisible() && isc.Browser.isMoz) this._blurItem(this.getFocusItem());
    this.Super("parentVisibilityChanged", arguments);
    this.itemsVisibilityChanged();
    
    // If we are shown due to a parent being shown, and we are auto-focus true, focus now.
    if (this.isVisible() && this.autoFocus) this.focus();
},

// Ensure we allow native text selection within form items.
_allowNativeTextSelection : function (event) {
    var itemInfo = this._getEventTargetItemInfo(event);
    // For now always allow text selection of form items' cells.
    if (itemInfo.item) {
        var rv = itemInfo.item._allowNativeTextSelection(event, itemInfo);
        if (rv != null) return rv;
    }
    return this.Super("_allowNativeTextSelection", arguments);
},

// Override prepareForDragging
// If the developer is dragging from inside one of our formItems, just disallow it
// This would be really odd UI - if a user drags across a text based item, you'd expect a 
// selection to occur, taking presidence over this.canDragReposition.
prepareForDragging : function (a,b,c,d) {

    var EH = this.ns.EH;
    // this would indicate that a child has set itself as the dragTarget, and then
    // prepareForDragging bubbled to this Canvas.  By default, we leave this alone.  
    if (EH.dragTarget) return;
    
    // If the event occurred over the text box / element / control-table of one of our items, 
    // return false - We don't want to allow dragging of the form as a whole from within an
    // item - instead we'll support drag selection of the item. We also don't want to allow 
    // 'prepareForDragging' to bubble up and allow dragging of a parent.
    var event = EH.lastEvent,
        itemInfo = this._getEventTargetItemInfo(event);
    if (itemInfo.item && 
        (itemInfo.overElement || itemInfo.overTextBox || itemInfo.overControlTable)) return false;
    
    return this.invokeSuper(isc.DynamicForm, "prepareForDragging", a,b,c,d);
}, 


// -------------------------------------------------------------------------------------------
// Event handling
// For events that get passed to form items, we will fire the event on the item where it 
// occurred, then bubble it up through any parent items. For standard mouse and key evetns, we 
// then allow the event to be fired on the DynamicForm, and bubbled up through the widget
// parent chain.

// -------------------------------------------------------------------------------------------



// Given an event, determine whether it occurred over one of our items.
// Note: we return an object of the following format:   {item:item, overTitle:boolean}   
// - if the event occurred over the item's title rather than the item itself, overTitle will 
// be true.
_getEventTargetItemInfo : function (event) {

    if (!event) event = isc.EH.lastEvent;
    
    
    
    var target = isc.EH.isMouseEvent(event.eventType) ? event.nativeTarget 
                                                      : event.nativeKeyTarget;
    var info = isc.DynamicForm._getItemInfoFromElement(target, this);
    
    // Copy the item info onto the event object itself so handlers can check what part of the
    // item the event ocurred over directly
    event.itemInfo = info;
    return info;
},

// Have handleMouseStillDown send a 'mouseStillDown' event to items, if they have a handler
// for it.

handleMouseStillDown : function (event, eventInfo) {

    var targetInfo = this._getEventTargetItemInfo(event),
        item = (targetInfo.overTitle ? null : targetInfo.item);
        
    if (item != null && item.mouseStillDown) {
        if (item.handleMouseStillDown(event) == false) return false;
    }
    
},
// also send 'mouseDown' to items

handleMouseDown : function (event, eventInfo) {
    var targetInfo = this._getEventTargetItemInfo(event),
        item = (targetInfo.overTitle ? null : targetInfo.item);
    
    if (item != null) {
        item.handleMouseDown(event);

        
        if (isc.Browser.isSafari && targetInfo.overElement && isc.isA.CheckboxItem(item)) {    
            item.focusInItem();
        }
    }        
},

// Form item mouse event APIs:
// - FormItem.mouseOver(), mouseMove(), mouseOut() 
//      Not currently exposed
// - FormItem.titleOver(), titleMove(), titleOut()
//      Not currently exposed - fired if the event occurred over the  title rather than item.
// - FormItem.itemHover(), titleHover() 
//      fired after a delay - return false to cancel showing any Hover canvas for the item
// - FormItem.itemHoverHTML() / titleHoverHTML() 
//      not implemented by default - returns the HTML to show in the Hover canvas for this 
//      item (null will suppress hover canvas). Takes precidence over the equivalent form-level
//      item/titleHoverHTML() methods.
// - Form.itemHoverHTML(item) / titleHoverHTML(item) 
//      returns the HTML to show for the Hover canvas for some item.  Default implementation
//      for both methods returns the 'prompt' for the Item.

 
// _itemMouseEvent - fired in response to mouseMove, mouseOver or mouseOut.
// Fires appropriate handlers on the item.    
_itemMouseEvent : function (itemInfo, eventType) {

    var lastMoveItem = this._lastMoveItem,
        wasOverTitle = this._overItemTitle,
        lastOverIcon = this._lastOverIconID,
        
        item = itemInfo.item,
        overTitle = itemInfo.overTitle,
        overIcon = itemInfo.overIcon;
    
    // Don't fire mouse events on disabled items - set item to null so we fire mouseOut on
    // the previous item
    
    
    
    // Don't attempt to fire events on items that have been destroyed
    
    if (lastMoveItem && lastMoveItem.destroyed) {
        lastMoveItem = null;
        this._lastMoveItem = null;
        this._lastOverIcon = null;
        this._overItemTitle = null;
    }
    if (item && item.destroyed) {
        item = null;
        overTitle = null;
        overIcon = null;
    }
    
    
    // Remember the information for the next mouse event
    this._lastMoveItem = item;
    this._overItemTitle = overTitle;
    this._lastOverIconID = overIcon;
    
    
    if (eventType == isc.EH.MOUSE_OVER) {
        if (item) {
            if (overTitle) item.handleTitleOver();
            else {
                if (overIcon) item._iconMouseOver(overIcon);
                item.handleMouseOver();
            }
        }
    } else if (eventType == isc.EH.MOUSE_OUT) {
        if (lastMoveItem) {
            if (wasOverTitle) lastMoveItem.handleTitleOut();
            else {
                if (lastOverIcon) lastMoveItem._iconMouseOut(lastOverIcon);
                lastMoveItem.handleMouseOut();
            }
        }

    // Mouse-Move case is more complex, as the user may have moved within an item, or be moving
    // between items, etc.
    } else {
        
        var changedItem = (lastMoveItem != item || wasOverTitle != overTitle);
        
        // In this case the user has switched items.  
        // We catch:    - moving between two items' cells (or title cells)
        //              - moving over a new item or title cell
        //              - moving out of an item or title cell
        //              - moving from an item's cell to title (or vice versa)
        if (changedItem) {
            if (lastMoveItem) {
                if (wasOverTitle) lastMoveItem.handleTitleOut();
                else {
                    if (lastOverIcon) lastMoveItem._iconMouseOut(lastOverIcon);
                    lastMoveItem.handleMouseOut();
                }
            }
            if (item) {
                if (overTitle) item.handleTitleOver();
                else {
                    if (overIcon) item._iconMouseOver(overIcon);
                    item.handleMouseOver();
                }
            }
            
        // In this case we know the user has moved within an item's cell or title cell.
        } else {
            if (overTitle) item.handleTitleMove();
            else {
                // we may have moved between icons within the item's cell.
                if (lastOverIcon != overIcon) {
                    if (lastOverIcon) item._iconMouseOut(lastOverIcon);
                    if (overIcon) item._iconMouseOver(overIcon);
                } else if (item) {
                    if (overIcon) item._iconMouseMove(overIcon);
                    item.handleMouseMove();
                }
            }
        }
    }
},


// Override 'handleMouseOver' / 'Out' / 'Move' to fire mouseOver / titleOver et al on 
// form items.
handleMouseOver : function (event, eventInfo) {
    if (this.mouseOver && this.mouseOver(event, eventInfo) == false) return false;
    this._itemMouseEvent(this._getEventTargetItemInfo(event), isc.EH.MOUSE_OVER);
},

handleMouseMove : function (event, eventInfo) {
    // allow a form-level mouseMove handler to completely suppress item level handling.
    if (this.mouseMove && this.mouseMove(event,eventInfo) == false) return false;
    
    var targetInfo = this._getEventTargetItemInfo(event);
    this._itemMouseEvent(targetInfo, isc.EH.MOUSE_MOVE);

},

handleMouseOut : function (event, eventInfo) {
    
    // We know if it's a mouseOut that there's no new item!
    
    this._itemMouseEvent({}, isc.EH.MOUSE_OUT);

    // If there's a form level mouseout handler, ensure we also fire it (and prevent bubbling
    // if appropriate)
    if (this.mouseOut && this.mouseOut(event,eventInfo) == false) return false;
},

//>	@method	dynamicForm.bubbleItemHandler()
//		Bubble an event up the nested item hierarchy for a particular item.
//		@group	event handling
//		@param	itemID			(number)			Global identifier for the item on which call the handler.
//		@param	handlerName		(string)			Name of the handler to call.
//		@param	[arg1]			(any)				Optional argument to the call.
//		@param	[arg2]			(any)				Optional argument to the call.
//		@param	[arg3]			(any)				Optional argument to the call.
//		@param	[arg4]			(any)				Optional argument to the call.
//<
bubbleItemHandler : function (itemID, handlerName, arg1, arg2, arg3, arg4) {
    
    var subItem = this.getItemById(itemID),
        result = null;

	for (; subItem != null; subItem = subItem.parentItem) {
		if (subItem[handlerName] != null && !isc.isA.Function(subItem[handlerName])) {
			isc.Func.replaceWithMethod(subItem, handlerName, "arg1,arg2,arg3,arg4");
		}
        
        if (subItem[handlerName] == null) {
            this.logWarn("handler:"+ handlerName + " is not present on itemID " + itemID);
            return false;
        }
        
		result = subItem[handlerName](arg1, arg2, arg3, arg4);
		
		// if result is false, bail from the handler!
		if (result == false) return result;
	}
	
	return result;
},

//>	@method	dynamicForm.elementChanged()
// Handle a change event from an element.
// <p>
// May cause the form to redraw if the item (or sub-item) has redrawOnChange turned on
//
//		@group	event handling
//
//		@param	itemID			(itemID)	Reference to the (possibly nested) item that has changed.
//		@return	(boolean)			true == event should proceed normally, false == halt event
//<
elementChanged : function (itemID) {
	// bubble the elementChanged handler up through the item(s) specified.
	var result = this.bubbleItemHandler(itemID, "elementChanged", itemID);
    return (result != false);
},


// Override handleClick to fire click events on the item clicked.
handleClick : function (event, eventInfo) {
    var itemInfo =  this._getEventTargetItemInfo(event);
    if (itemInfo && itemInfo.item) {
        var item = itemInfo.item;
        if (itemInfo.overTitle) return this.bubbleItemHandler(item, "handleTitleClick", item);
        else {  

            // If we're over the item itself (essentially the element / text box, or picker),
            // fire click      
            var overItem = (itemInfo.overElement || itemInfo.overTextBox || itemInfo.overControlTable);

            
            if (itemInfo.overIcon) {
                if (item._iconClick(itemInfo.overIcon) == false) return false;
                // The picker is written into the main body of the item - other icons are not,
                // so don't fire the standard click handler for them.
                var icon = item._getIcon(itemInfo.overIcon);
                if (icon && icon.writeIntoItem) overItem = true;
            }

            if (overItem && this.bubbleItemHandler(item, "handleClick", item) == false) {
                return false;
            }
                
            // fire cellClick (in addition to click where appropriate unless handleClick() returned
            // false).
            return this.bubbleItemHandler(item, "handleCellClick", item);
        }
    }
},

// Override handleDoubleClick to fire doubleclick events on the item clicked.
handleDoubleClick : function (event, eventInfo) {
    var itemInfo =  this._getEventTargetItemInfo(event);
    if (itemInfo && itemInfo.item) {
        var item = itemInfo.item;
        if (itemInfo.overTitle) { 
            return this.bubbleItemHandler(item, "handleTitleDoubleClick", item);
        } else {  

            // If we're over the item itself (essentially the element / text box, or picker),
            // fire click      
            var overItem = (itemInfo.overElement || itemInfo.overTextBox || itemInfo.overControlTable);

            
            if (itemInfo.overIcon) {
                if (item._iconClick(itemInfo.overIcon) == false) return false;
                // The picker is written into the main body of the item - other icons are not,
                // so don't fire the standard click handler for them.
                var icon = item._getIcon(itemInfo.overIcon);
                if (icon && icon.writeIntoItem) overItem = true;
            }

            if (overItem && this.bubbleItemHandler(item, "handleDoubleClick", item) == false) {
                return false;
            }
                
            // fire cellClick (in addition to click where appropriate unless handleClick() returned
            // false).
            return this.bubbleItemHandler(item, "handleCellDoubleClick", item);
        }
    }
},

//>	@method	dynamicForm.elementFocus()	(A)
// Event fired when the keyboard focus goes to a particular item
// <P>
// Fired from the native focus event on form items.<br>
// This method fires the formItem.elementFocus handler, which will also fire any developer-
// specified focus handler on the appropraite item(s).
//
//		@group eventHandling, focus
//
//		@param	itemID     (itemID)	item that been focused.
//		@return	(boolean)  true == event should proceed normally, false == halt event
//<
elementFocus : function (element, itemID) {

    // Set the ISC focus element to this
    
    if (!this.hasFocus) isc.EventHandler.focusInCanvas(this);

	// call setFocusItem on the inner-most item that was focused
    
    var item = this.getItemById(itemID);	
	this.setFocusItem(item);
    
	// bubble the "elementFocus" event up through the event handler(s) for the element
	var result = true,
        suppressHandler = false;
    
    if (this.__suppressFocusHandler != null) {
        // Catch the case where we get an onfocus handler from a different item to the one
        // on which we are suppressing elementFocus() - this can happen if when focus w/o 
        // handler was fired the item already had focus, so its onfocus handler never fired.
        if (this.__suppressFocusItem != item) {
            
            delete this.__suppressFocusHandler;
            delete this.__suppressFocusItem;                        
        } else {
            suppressHandler = true;
            this.__suppressFocusHandler -=1;
            if (this.__suppressFocusHandler < 0) {
                delete this.__suppressFocusHandler;
                delete this.__suppressFocusItem;
            }
        }
    }
    
    result = this.bubbleItemHandler(itemID, "elementFocus", suppressHandler);

    return (result != false);
},

//>	@method	dynamicForm.elementBlur()	(A)
// Event fired when the keyboard blurs from a particular item
// <P>
// If the item has a "blur" handler, this will be fired automatically
//
// @group eventHandling, focus
//
//		@param	itemID    (itemID)  item that has blurred
//		@return	(boolean)           true == event should proceed normally, false == halt event
//<
elementBlur : function (element, itemID)  {
    if (!isc.isA.FormItem(this.getItemById(itemID))) return;
    
	// bubble the "elementBlur" event up through the event handler(s) for the element
    
	var result = true;
    if (this.__suppressBlurHandler == null) result = this.bubbleItemHandler(itemID, "elementBlur");
    else {
        this.__suppressBlurHandler -=1;
        if (this.__suppressBlurHandler < 0) delete this.__suppressBlurHandler;
    }

	// clear any prompt shown from the item
	this.clearPrompt();

	
	
	return (result != false);
},



// For keys that 'have meaning' to form items, we don't want to bubble them up past the form.
// For example - we don't want to bubble Arrow_Up / Arrow_Down and cause the form's parent
// element to scroll around when you're trying to move around inside a text area.
// return STOP_BUBBLING for those cases - this will prevent parent widgets from reacting to the
// events without cancelling them

_$Enter:"Enter",
handleKeyPress : function (event, eventInfo) {

    // Special case for Enter keypress: If this.saveOnEnter is true, and the enter keypress
    // occurred in a text item, auto-submit the form
    if (event.keyName == this._$Enter) {
        if (this.saveOnEnter) {
            var item = this.getFocusItem();
            // Note that this.submit() will call this.saveData() unless this.canSubmit is true
            if (isc.isA.TextItem(item)) this.submit();
            // we always return STOP_BUBBLING on enter keypress (handled below) which is
            // appropriate.
        }
    }
    
    // All character keys will have impact on the form item (this includes Enter, which is 
    // appropriate)
    if (event.characterValue != null && event.characterValue != 0) {
        return isc.EventHandler.STOP_BUBBLING;
    }

    // The following non-character keys also 'have meaning' - so we don't want to bubble these.
    // cache the possible form item modifying keys to avoid lots of string instantiations
    if (!this._formItemKeys) {
        this._formItemKeys = {
            "Arrow_Up":true,
            "Arrow_Down":true,
            "Arrow_Right":true,
            "Arrow_Left":true,
            "Page_Up":true,
            "Page_Down":true,
            "Home":true,
            "End":true,
            "Backspace":true,
            "Delete":true,
            "Tab":true
        }
    }
    if (this._formItemKeys[event.keyName] && event.keyTarget != this) {
        return isc.EventHandler.STOP_BUBBLING;
    }
    
    return this.Super("handleKeyPress", arguments);
},
 
// Item Hover HTML
// --------------------------------------------------------------------------------------------

//>@method  dynamicForm.itemHoverHTML()     (A)
//  Retrieves the HTML to display in a hover canvas when the user holds the mousepointer over
//  some item.  Return null to suppress the hover canvas altogether.<br>
//  Default implementation returns the prompt for the item if defined.<br>
//  Can be overridden via <code>item.itemHoverHTML()</code>
//
//  @group Hovers
//  @see FormItem.prompt
//  @see FormItem.itemHoverHTML()
//  @param item (FormItem)  Item the user is hovering over.
//  @visibility external
//<
itemHoverHTML : function (item) {
    // Just bail if a native prompt is shown
    if (item.implementsPromptNatively) return null;
    var prompt = item.prompt;
    if (!prompt && item.parentItem) prompt = this.itemHoverHTML(item.parentItem)
    return prompt
},

//>@method  dynamicForm.titleHoverHTML()     (A)
//  Retrieves the HTML to display in a hover canvas when the user holds the mousepointer over
//  some item's title.  Return null to suppress the hover canvas altogether.<br>
//  Default implementation returns the prompt for the item if defined.  If no prompt is defined
//  and the item title is clipped, the item title will be shown in a hover by default.<br>
//  Can be overridden via <code>item.titleHoverHTML()</code>
//
//  @group Hovers
//  @see FormItem.prompt
//  @see FormItem.titleHoverHTML()
//  @param item (FormItem)  Item the user is hovering over.
//  @visibility external
//<
titleHoverHTML : function (item) {
    if (item.prompt) return item.prompt;
    if (this.shouldClipTitle(item)) return item.getTitle();
},

// Method to actually show the Hover - called from the item when the user has hovered over
// the item.
_showItemHover : function (item, HTML) {
    if (HTML && !isc.is.emptyString(HTML)) {
        var properties = this._getHoverProperties(item);
        isc.Hover.show(HTML, properties, (item.hoverRect || this.itemHoverRect));
    } else isc.Hover.clear();
},

// Properties to apply to the hover shown for some item.
_getHoverProperties : function (item) {
    if (!isc.isA.FormItem(item)) item = this.getItem(item);
    
    return {
        width:(item && item.hoverWidth != null ? item.hoverWidth : this.itemHoverWidth),
        height:(item && item.hoverHeight != null ? item.hoverHeight : this.itemHoverHeight),
        align:(item && item.hoverAlign != null ? item.hoverAlign : this.itemHoverVAlign),
        baseStyle:(item && item.hoverStyle != null ? item.hoverStyle : this.itemHoverStyle),
        opacity:(item && item.hoverOpacity != null ? item.hoverOpacity : this.itemHoverOpacity),
        moveWithMouse:this.hoverMoveWithMouse 
    };
},

// Item Prompts
// --------------------------------------------------------------------------------------------



//>	@method	dynamicForm.showPrompt()	(A)
//		@group	prompt
//			Show a prompt (as dictated by an item, say).
//
//		@param	prompt	(string)			Prompt to show.
//<
showPrompt : function (prompt) {
	window.status = prompt;
},

//>	@method	dynamicForm.clearPrompt()	(A)
//		@group	prompt
//			Clear any form prompt currently showing.
//
//<
clearPrompt : function () {
	window.status = "";
},

// Queries on form properties
// --------------------------------------------------------------------------------------------


// returns true if the form encoding is set to multipart, false otherwise
isMultipart : function () {
    // normal is the default setting; if encoding is set to a value other than this, assume
    // multipart encoding is desired
    return !(this.encoding == isc.DynamicForm.NORMAL || 
             this.encoding == isc.DynamicForm.NORMAL_ENCODING);
}


});	// END isc.DynamicForm.addMethods()



// class methods
isc.DynamicForm.addClassMethods({

defaultFieldType:"text",    

// Avoid re-instantiating strings every time this method is run
_$link:"link", _$text:"text", _$select:"select", _$checkbox:"checkbox",
_$staticText:"staticText", _$boolean:"boolean",
_$binary:"binary", _$blob:"blob", _$multifile:"multifile", _$multiupload:"multiupload",
_$upload:"upload", _$file:"file",
_$base64Binary: "base64Binary", _$enum:"enum", _$CycleItem:"CycleItem", _$selectOther:"selectOther",
_$relation:"relation",

getEditorType : function (field, widget) {
    
    // choosing which form item type to use:
    // Each field may consist of either entirely properties that were passed in, a mixture
    // of passed-in overrides and DataSource defaults, or entirely DataSource defaults.
    // - if "editorType" is present (or the legacy name "formItemType" for the same
    //   concept), use it regardless of whether it came from passed-in fields or from the
    //   DataSource defaults
    // - _constructor comes from XML translation.  When a field is specified as 
    //      <TextItem name="foo" .../>
    //   .. _constructor will be "TextItem".  When a field is just specified as
    //      <field name="foo" type="text" .../>
    //   .. _constructor will have the value "FormItem", which we ignore because FormItem
    //   is an abstract base class, so we want to apply automatic item-choosing.
    if (field._constructor == isc.FormItem.Class) field._constructor = null;    
    
    var defaultType = this.defaultFieldType,
        // NOTE: "formItemType" is a legacy synonym of "editorType"    
        type = field.editorType || field.formItemType || field._constructor ||
               field.type || defaultType;
    
    
    if (field.editorType || field.formItemType || field._constructor) return type;  
    
    // .. otherwise, "type" has been specified on its own without the more specific
    // "editorType", and could refer either to a data type or form item type.
    // For certain known data types, pick appropriate editors.
    if (type == this._$link) {
        if (field.canEdit === false) type = this._$link;
        else type = this._$text;
    // Default to using static text items for all canEdit:false fields regardless of data type
    // with the exception of links (which are already non editable)      
    
    } else if (field.canEdit == false) {
        
        type = this._$staticText;
    } else if (type == this._$boolean) {
        var map = field.valueMap;
        // assumption is that if a valueMap is provided, a boolean storage type
        // is being used for a field with two possible values but no obvious true/false 
        // aspect, eg, Sex: Male/Female.  In this case, we should show a SelectItem rather 
        // than eg a checkboxlabelled "Sex"
        if (!isc.isAn.Array(map) && isc.isAn.Object(map)) type = this._$select;
        else type = this._$checkbox;
    } else if (type == this._$binary || type == this._$blob || type == this._$file) {
        if (field.dataSource) type = this._$multifile
        else type = this._$file;
    } else if (type == this._$multiupload) {
        type = this._$multifile;
    } else if (type == this._$base64Binary) {
        type = this._$base64Binary;
    } else if (type == this._$enum) {
        // If we're just showing valueIcons and no type is specified, use a cycle-item rather
        // than a select.
        if (field.showValueIconOnly) type = this._$CycleItem
        else type = this._$select;
    } else {
        // if field.type=="text" or field.type==null or field.type is not directly recognized by
        // getItemClass():
        
        if (!field.type || (field.type == defaultType) ||
            (field.type != this._$selectOther && 
                (isc.FormItemFactory.getItemClass(field.type) == null)) )
        {
            // "text" is both a data type and a form item type.  We take it to mean the data
            // type, and may pick a SelectItem or TextAreaItem instead of a TextItem.  This is
            // the only case in which setting field.type to the short name of a FormItem type
            // ("Item" suffix omitted) will not select that form item.  It can be avoided by
            // setting editorType="text".
            if (field.dataSource) {
                // Use a relationItem for databound form items of unspecified type.
                type = this._$relation;            
            } else if (field.valueMap || field.optionDataSource || field.displayField) {
                // if a field has a valueMap, or an explicit optionDataSource / displayField
                // [which is essentially a server-side valueMap]
                // If we're showing valueIcons only, use CycleItem - otherwise default to "select"
                type = (field.showValueIconOnly ? this._$CycleItem : this._$select);
                
            } else if (widget && 
                       (field.length && field.length > widget.longTextEditorThreshold)) 
            {
                // for very large text fields, show a textArea.
                type = widget.longTextEditorType;
            } else {
                // default anything else to text
                type = defaultType;
            }
        }
    }    
    
    return type;
},


// _getItemInfoFromElement - given some DOM element, determine which (if any) item the
// element is a part of.
// Returns an object of the following format:
//  {item:[formItem object], overTitle:boolean, overElement:boolean }

_getItemInfoFromElement : function (target, form) {

    var handle = form ? form.getClipHandle() : document,
        itemInfo = {},
        
        containsItem = isc.DynamicForm._containsItem,
        
        itemPart = isc.DynamicForm._itemPart,
        
        elementString = isc.DynamicForm._element,
        textBoxString = isc.DynamicForm._textBoxString,
        controlTableString = isc.DynamicForm._controlTableString,
        titleString = isc.DynamicForm._title;

    // We mark form items' HTML elements with a 'containsItem' parameter so we can determine
    // which item we're looking at.
    // Iterate up the DOM from the target checking for this attr
    while (target && target != handle && target != document) {
        
        var itemID = target.getAttribute ? target.getAttribute(containsItem) : null;
        if (itemID != null && !isc.isAn.emptyString(itemID)) {
            var item = window[itemID];
            if (item && !item.destroyed) {
                itemInfo.item = item;
                
                // We also hang an attribute describing which part of the item an element is
                // so we can determine whether we're looking at the item's title, element or
                // one of it's icons.
                // Options are: 
                //  "element" - over a native element like an <input> box
                //  "title" - over the title cell
                //  "textbox" - over the textBox
                //  "controlTable" - control table
                //  Anything else assumed to be an icon ID
                
                var eventItemPart = target.getAttribute(itemPart);
                if (eventItemPart == elementString) itemInfo.overElement = true;
                else if (eventItemPart == titleString) itemInfo.overTitle = true;
                else if (eventItemPart == textBoxString) itemInfo.overTextBox = true;
                else if (eventItemPart == controlTableString) itemInfo.overControlTable = true;
                else if (eventItemPart && !isc.isAn.emptyString(eventItemPart)) 
                    itemInfo.overIcon = eventItemPart;
                
                // quit the loop so we can return the item info.
                break;
            }
        }
        
        target = target.parentNode;
    }
    
    return itemInfo;
},


// Callable either on server-formatted errors or editor component format errors.
formatValidationErrors : function (errors) {
    // If error is in server format, transform the server error report format to the error
    // report expected by an editor component.  Each server error is:
    // { fieldName : errors },
    //   anotherFieldName : errors },
    //   ...
    // }
    // where the errors for each field have the format
    // { errorMessage : msg, resultingValue : value }
    // or 
    // [{ errorMessage : msg, resultingValue : value }, 
    //  { errorMessage : msg, otherProp : value },  ... ]
    //
    // Editor components expect just { fieldName : errorMessage } - we drop
    // the resultingValue and possible other properties
    //
    
    var errorMessages = {};
    // note we support errors for only one row
    if (isc.isAn.Array(errors)) errors = errors[0];

    for (var fieldName in errors) {
        var fieldErrors = errors[fieldName];

        if (isc.isAn.Array(fieldErrors)) {
            errorMessages[fieldName] = [];
            for(var i = 0; i < fieldErrors.length; i++) {
                var error = fieldErrors[i];
                if(isc.isAn.Object(error)) error = error.errorMessage;
                errorMessages[fieldName][i] = error;
            }
        } else {
            errorMessages[fieldName] = isc.isAn.Object(fieldErrors) ? fieldErrors.errorMessage
                                                                    : fieldErrors;
        }
    }
    return errorMessages;
},


// compareValues
// Do 2 field values match? Used wherever we need to compare field values. 
// Handles all expected data types.
// Used to detect changes to values (eg; 'valuesHaveChanged()')

compareValues : function (value1, value2) {
        
    if (value1 == value2) return true;
    
    if (isc.isA.Date(value1) && isc.isA.Date(value2)) 
        return (Date.compareDates(value1, value2) == 0);
    else if (isc.isAn.Array(value1) && isc.isAn.Array(value2)) {
        return value1.equals(value2);
    } else if (isc.isAn.Object(value1) && isc.isAn.Object(value2)) {
        var tempObj = isc.addProperties({}, value2);
        for (var attr in value1) {
            if (value2[attr] != value1[attr]) return false;
            delete tempObj[attr];
        }
        // tempObj should now be empty if they match
        for (var attr in tempObj) {
            return false;
        }
        return true;
    }
    return false;
},


// get filter criteria for a list of filter components (passed as arguments)
getFilterCriteria : function () {
    var criteria = {};
    for (var i = 0; i < arguments.length; i++) {
        var arg = arguments[i];
        if (arg == null) continue;
        isc.addProperties(criteria, arg.getFilterCriteria());
    }
    return criteria;
}
	


});
// InlineForms: embedding SmartClient FormItems into native HTML forms.
// See QA/DynamicForm/inlineForms.jsp
// ---------------------------------------------------------------------------------------

isc.defineClass("InlineFormItem", "DynamicForm").addProperties({
    position:"relative",

    // don't write a form tag, so that form items written out join a surrounding HTML
    // form.  Note if we did not set this flag, IE will JS error if you try to insert a form
    // inside a form.  Firefox doesn't mind and the values show up within the outer form.
    // Safari untested.
    writeFormTag:false,

    // write native form fields to carry values for synthetic items, just as with direct submit
    canSubmit:true,

    // only one item, with no title
    numCols: 1,
    
    // in case the default is switched at the Canvas level
    autoDraw: true

    
    //redraw : function (a,b,c,d) {
    //    this.invokeSuper(isc.InlineFormItem, this._$redraw, a,b,c,d);
    //    this.getItem(0).getDataElement().form.offsetHeight;
    //}
});

isc.InlineFormItem.addClassMethods({
    // This override of create() does create a form, but applies properties to the (singular)
    // FormItem, so that it's possible to use inline items from XML like so:
    //     <InlineItem name="name" type="type">
    //       <valueMap> ... </valueMap>
    //     </InlineItem>
    // NOTE: it's ordinarily not a good idea to override create to return some kind of
    // "wrapper" component, because in order to be used inline in eg a Layout.members array,
    // create() must return the wrapper component, however in other usage (eg subcomponent
    // creation) the expectation is that create will return an instance of whatever was
    // created.
    create : function (A,B,C,D,E,F,G,H,I,J,K,L,M) {

        var itemProps = isc.addProperties({ 
            showTitle:false,
            validate : function () { this.form.validate() },
            destroy : function () { this.form.destroy() } 
        }, A,B,C,D,E,F,G,H,I,J,K,L,M);

        var theForm = this.createRaw().completeCreation({
            fields : [ itemProps ],
            valuesManager : itemProps.valuesManager
        }, itemProps.formProperties );

        return theForm.getItem(0);
    }
});

isc.DynamicForm.addClassMethods({
    //> @classMethod DynamicForm.makeInlineItem()
    // Return a SmartClient form item suitable for embeddeding into a normal HTML form.
    // <P>
    // For example, embedding a +link{ComboBoxItem}:
    // <pre>
    // &lt;form name="contactForm" action="/makeContact.jsp"&gt;
    //    &lt;input type="text" name="name"&gt;
    //    &lt;script&gt;isc.DynamicForm.makeInlineItem("title", "comboBox", 
    //                       { valueMap:["CEO", "CTO", "CIO", "COO"] })&lt;/script&gt;
    // &lt;/form&gt;
    // </pre>
    // The value managed by the SmartClient form item is then available for direct DOM access
    // just like ordinary HTML &lt;INPUT&gt; elements, and will be submitted normally with the
    // form.
    // <P>
    // This is an advanced API for use in incremental upgrade of older applications, or for
    // unusual form layouts that can't be accomodated by any combination of
    // +link{group:formLayout,form layout}, +link{ValuesManager} and +link{Layout,H/VLayouts}.
    //
    // @param name (String) name of the form field
    // @param type (String) type of the form field, same as +link{FormItem.type}
    // @param props (FormItem) other properties for the created FormItem
    //
    // @group inlineFormItems
    // @visibility inlineFormItems
    //<
    makeInlineItem : function (name, type, props, formProps) {
        return isc.InlineFormItem.create({
            name: name, 
            type: type,
            formProperties : formProps
        }, props)
    },

    //> @classMethod DynamicForm.getFormValues()
    // Return the values of a native HTML &lt;form&gt; element as JavaScript object.
    // <P>
    // Each property in the returned object represents a native form element value.  Select
    // multiple items are represented as an Array of the selected values.
    //
    // @param formId (String) DOM ID of the form
    // 
    // @group inlineFormItems
    // @visibility inlineFormItems
    //<
    getFormValues : function (formId) {
        return isc.Canvas.getFormValues(formId);
    }

});	


isc.DynamicForm.registerStringMethods({

    //> @method dynamicForm.itemChanged()
    // Handler fired when there is a changed() event fired on a FormItem within this form.
    // <P>
    // Fires after the change() handler on the FormItem itself, and only if the item did not
    // cancel the change event and chooses to allow it to propagate to the form as a whole. 
    //
    // @param	item	(FormItem)    the FormItem where the change event occurred
    // @param	newValue (any)    new value for the FormItem
    // @visibility external
    //<
    itemChanged : "item,newValue",

    //> @method dynamicForm.itemChange()
    // Handler fired when there is a change() event fired on a FormItem within this form.
    // <P>
    // Fires after the change() handler on the FormItem itself, and only if the item did not
    // cancel the change event and chooses to allow it to propagate to the form as a whole. 
    //
    // @param	item	(FormItem)    the FormItem where the change event occurred
    // @param	newValue (any)    new value for the FormItem
    // @param	oldValue (any)    value the FormItem had previous to this change() event
    // @return (boolean) return false to cancel the change, or true to allow it
    // @visibility external
    //<
    itemChange : "item,newValue,oldValue",

	//>	@method dynamicForm.itemKeyPress()
    // Handler fired when a FormItem within this form receives a keypress event.
    // <P>
    // Fires after the keyPress handler on the FormItem itself, and only if the item did not
    // cancel the event and chooses to allow it to propagate to the form as a whole. 
    // 
    // @param	item	(FormItem)    the FormItem where the change event occurred
    // @param	keyName (string)      name of the key that was pressed (EG: "A", "Space")
    // @param   characterValue  (number)    numeric character value of the pressed key.
    // @visibility external
	//<
    itemKeyPress : "item,keyName,characterValue",
    
	//>	@method dynamicForm.submitValues()
    // Triggered when a SubmitItem is included in the form is submitted and gets pressed.
    // 
    // @param	values    (object)        the form values
    // @param	form      (DynamicForm)   the form being submitted
    // @group submitting
    // @see method:dynamicForm.submit()
    // @visibility external
	//<
    submitValues : "values,form",
    
    //> @method dynamicForm.handleHiddenValidationErrors (A)
    // Method to display validation error messages for fields that are not currently visible 
    // in this form.<br>
    // This will be called when validation fails for<br>
    // - a hidden field in this form<br>
    // - if this form is databound, a datasource field with specified validators, for which we
    //   have no specified form item.<br>
    // Implement this to provide custom validation error handling for these fields.<br>
    // By default hidden validation errors will be logged as warnings in the developerConsole.
    // Return false from this method to suppress that behavior.
    // @param   errors (object) The set of errors returned - this is an object of the form<br>
    //                      &nbsp;&nbsp;<code>{fieldName:errors}</code><br>
    //                      Where the 'errors' object is either a single string or an array
    //                      of strings containing the error messages for the field.
    // @visibility external
    //<
    handleHiddenValidationErrors:"errors"
});

