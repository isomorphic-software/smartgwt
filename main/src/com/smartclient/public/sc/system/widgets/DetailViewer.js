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

 





//>	@class	DetailViewer
//
//  Displays one or more records "horizontally" with one property per line.
//
//  @implements DataBoundComponent    
//  @treeLocation Client Reference/Grids
//  @visibility external
//<

isc.ClassFactory.defineClass("DetailViewer", "Canvas");

// add default properties
isc.DetailViewer.addProperties({

    // Data
	// --------------------------------------------------------------------------------------------
    
    //>	@attr	detailViewer.data		(Array of DetailViewerRecord : null : IRW)
    // A single record object or an array of them, specifying data. Note that DetailViewers do
    // not observe changes to the data array (in other words they will not automatically
    // re-draw when the data provided via this property is altered).
    //
    // @group basics
    // @visibility external
    //<
    
    //> @object DetailViewerRecord
    // 
    // A DetailViewerRecord is an object literal with properties that define the values for the
    // various fields of a +link{DetailViewer}.
    // <p>
    // For example a DetailViewer that defines the following fields:
    // <pre>
    // fields : [
    //     {name: "field1"},
    //     {name: "field2"}
    // ],
    // </pre>
    // Might have the following data:
    // <pre>
    // data : [
    //     {field1: "foo", field2: "bar"},
    //     {field1: "field1 value", field2: "field2 value"}
    // ]
    // </pre>
    // Each element in the data array above is an instance of DetailViewerRecord - notice that
    // these are specified simply as object literals with properties.
    //
    // @treeLocation Client Reference/Grids/DetailViewer
    // @visibility external
    //<

    // Fields
    // ---------------------------------------------------------------------------------------

    //>	@attr	detailViewer.fields		(List of DetailViewerField : null : IRW)
    // 
    // An array of field objects, specifying the order and type of fields to display in this
    // DetailViewer.  In DetailViewers, the fields specify rows. 
    //
    // @visibility external
    //<

    //> @object DetailViewerField
    //
    // An object literal with a particular set of properties used to configure the display of
    // and interaction with the rows of a +link{DetailViewer}.
    //
    // @treeLocation Client Reference/Grids/DetailViewer
    // @visibility external
    //<
    
    //> @method DetailViewerField.formatCellValue()
    // Optional method to format the value to display for this field's cells. Takes precedence over
    // +link{DetailViewer.formatCellValue()} for cells in this field. 
    // @param value (string) the raw value of the cell
    // @param record (detailViewerRecord) the record being displayed
    // @param field (detailViewerField) the field being displayed
    // @param viewer (detailViewer) the detailViewer containing this field
    // @group i18nMessages
    // @visibility external
    //<

    //>	@attr	detailViewerField.imageSize (number : null : IRW)
    // Size of images shown for fieldTypes image in this field.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // height.  For example, if <code>field.imageSize</code> is "logoSize",
    // <code>record.logoSize</code> will control the size of the image.
    //
    // @see attr:detailViewerField.imageWidth
    // @see attr:detailViewerField.imageHeight
    // 
    // @group imageColumns
    // @visibility external
	//<

  	//>	@attr	detailViewerField.imageWidth (number : null : IRW)
    // Width of images shown for fieldTypes image in this field.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // width.  For example, if <code>field.imageWidth</code> is "logoWidth",
    // <code>record.logoWidth</code> will control the width of the image.
    //
    // @see attr:detailViewerField.imageSize
    // @see attr:detailViewerField.imageHeight
    // 
    // @group imageColumns
    // @visibility external
	//<

  	//>	@attr	detailViewerField.imageHeight (number : null : IRW)
    // Height of image shown for fieldTypes image in this field.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // height.  For example, if <code>field.imageHeight</code> is "logoHeight",
    // <code>record.logoHeight</code> will control the height of the image.
    //
    // @see attr:detailViewerField.imageSize
    // @see attr:detailViewerField.imageWidth
    // 
    // @group imageColumns
    // @visibility external
	//<
    
    //> @attr   detailViewerField.imageURLPrefix (string : null : IRWA)
    // If this field has type set to <code>"image"</code>
    // and the URL for the image displayed is not absolute, the path of the URL will be relative 
    // to this string<br>
    //
    // @group imageColumns
    // @visibility external
    //<
    
    //> @method detailViewerField.showIf
    // 
    // If specified on a field, this method is evaluated at draw time to determine whether or
    // not to show this particular field.
    // <p>
    // This method can be specified either as a function or a string that will be
    // auto-converted to a function.
    //
    // @param viewer (DetailViewer) The DetailViewer
    // @param valueList (List of DetailViewerRecord) 
    //
    // @return (boolean) true to show the field, false to not show it.
    // 
    // @visibility external 
    //<

    //> @attr detailViewerField.type (String : null : IR)
    // 
    // Specifies the type of this DetailViewerField.  By default (value is <code>null</code>)
    // the field shows a field title on the left and the field value on the right.  There are
    // two special values for this attribute:
    // <ul>
    // <li>"header" - If you specify type "header", the field spans both the field name and
    // field value columns and contains text defined in the +link{DetailViewerField.value}
    // attribute with the style specifed by +link{DetailViewer.headerStyle}.  You can use this
    // field type as a titled separator.
    // <li>"separator" - If you specify type "separator", the field spans both the field name
    // and the field value columns with no text, and is styled using the style specified via
    // +link{DetailViewer.separatorStyle}.  The height of the separator field can be controlled
    // via +link{DetailViewerField.height}.
    // <li>"image" For viewing, a thumbnail image is rendered in the field.  The URL of the
    // image is the value of the field, and should be absolute. The size of the image is 
    // controlled by +link{attr:DetailViewerField.imageSize}, 
    // +link{attr:DetailViewerField.imageWidth}, +link{attr:DetailViewerField.imageHeight}
    // </ul>
    // 
    // @visibility external 
    //<

    //> @attr detailViewerField.title (HTML : null : IR)
    // 
    // The title of the field as displayed on the left-hand side.  If left unspecified, the
    // title of the field is derived by looking up the value of
    // +link{DetailViewer.fieldIdProperty} on this field.  So, by default, the title of a field
    // is the value of its "name" property.
    //
    // @see DetailViewer.fieldIdProperty
    // @visibility external 
    //<

    //> @attr detailViewerField.valueMap (object : null : IR)
    //
    // A property list (or an expression that evaluates to a property list)
	// specifying a mapping of internal values to display values for the field (row).
    //
    // @visibility external 
    //<

    // XXX not exposing for now - refactor as formatters a-la ListGrid?
    //> @attr detailViewerField.asHTML (boolean : null : IR)
    //
    // Escapes value via String.asHTML().
    //
    // @visibility internal 
    //<

    //> @attr detailViewerField.value (HTML : "undefined" : IR)
    //
    // When a field specifies its +link{detailViewerField.type} to be "header", the value of
    // this attribute specifies the header text. 
    //
    // @visibility external 
    //<

    
    //> @attr detailViewerField.width (Number : null : IR)
    // 
    // @visibility internal 
    //<

    //> @attr detailViewerField.height (Number : null : IR)
    // 
    // For +link{DetailViewerField.type}: <code>"separator"</code>, this attribute specifies
    // the height of the separator.
    // 
    // @visibility external 
    //<

    //>	@method	detailViewerField.getCellStyle()
    // Optional method to return the CSS class for cells in this field. If specified, this method
    // will be called from +link{detailViewer.getCellStyle()}, and should return a css class name.
    //
    //		@param	value		(string) actual value of this cell 
    //		@param	field      (object)	field object for this cell
    //		@param	record      (object) record object for this cell	
    //      @param  viewer      (DetailViewer) the viewer instance to which this cell belongs
    //
    //		@return	(CSSStyleName)	CSS style for this cell
    // @group	appearance
    // @visibility external
    //<
    
    //>	@attr	detailViewer.fieldIdProperty (string : "name" : IRWA)
	// Name of the field in the DetailViewerRecord which specifies the data property for that record.
    // @visibility external
	//<
	fieldIdProperty:"name",	
	
    // Multi-record display
	// --------------------------------------------------------------------------------------------

    //>	@attr	detailViewer.recordsPerBlock		(number : 1 : [IRW])
    //          The number of records to display in a block. A block is a horizontal row on a page
    //          containing one or more records, as specified by the value of recordsPerBlock. The
    //          height of a block is equal to the height of a single record. The default setting of
    //          1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock
    //          to 2 would cause records to appear side by side in groups of two.
    //          Use a value of "*" to indicate all records.
    // @group appearance
    // @visibility external
    //<
	recordsPerBlock:1,

    //>	@attr	detailViewer.blockSeparator		(string : "<BR><BR>" : [IRW])
    // A string (HTML acceptable) that will be written to a page to separate blocks.
    // @group appearance
    // @visibility external
    //<
	blockSeparator:"<BR><BR>",

    // Empty values
	// --------------------------------------------------------------------------------------------
    
    //>	@attr	detailViewer.showEmptyField		(boolean : true : IRWA)
	// Whether to show the field when the value is null
    // @group appearance
    // @visibility external
	//<
	showEmptyField:true,

    //>	@attr	detailViewer.emptyCellValue		(string : "&nbsp;" : IRWA)
	// Text to show for an empty cell
    // @group appearance
    // @visibility external
	//<
	emptyCellValue:"&nbsp;",			

    // Labels
	// --------------------------------------------------------------------------------------------
    //>	@attr	detailViewer.labelPrefix		(string : "" : IRW)
	// text to put before a label
    // @group labels
    // @visibility external
	//<
	labelPrefix:"",						

    //>	@attr	detailViewer.labelSuffix		(string : ":" : IRW)
	// text to put after a label
    // @group labels
    // @visibility external
	//<
	labelSuffix:":",					

    //> @attr detailViewer.valueAlign 
    // horizontal alignment of values
    // @group values
    //<
    valueAlign:"left",
    
    //>	@attr	detailViewer.wrapLabel		(boolean : false : IRW)
	// Should the label be allowed to wrap, or be fixed to one line no matter how long
    // @group labels
    // @visibility external
	//<

    //> @attr detailViewer.wrapValues (boolean : true : IR)
    // Whether values should be allowed to wrap by default, or should be shown on one line
    // regardless of length.
    //
    // @group labels
    // @visibility external
    //<
    wrapValues: true,
    
    // internal property used by tileGrid to force table size to be width 100%
    useInnerWidth: true,
    // internal property to clip cell values
    clipValues: false,

	// CSS styles
	// --------------------------------------------------------------------------------------------

    //>	@attr detailViewer.styleName (CSSStyleName : "detailViewer" : IRW)
	// CSS style for the component as a whole.
    // @group appearance
    // @visibility external
	//<
	styleName:"detailViewer",		

    //>	@attr detailViewer.blockStyle (CSSStyleName : "detailBlock" : IRW)
	// CSS style for each block (one record's worth of data).
    // @group appearance
    // @visibility external
	//<
	blockStyle:"detailBlock",		

    //>	@attr	detailViewer.labelStyle		(CSSStyleName : "detailLabel" : IRW)
	//			CSS style for a normal detail label
    // @group appearance
    // @visibility external
	//<
	labelStyle:"detailLabel",		

    //>	@attr	detailViewer.cellStyle		(CSSStyleName : "detail" : IRW)
	//			CSS style for a normal value
    // @group appearance
    // @visibility external
	//<
	cellStyle:"detail",				

    //>	@attr	detailViewer.headerStyle		(CSSStyleName : "detailHeader" : IRW)
	//			CSS style for a header
    // @group appearance
    // @visibility external
	//<
	headerStyle:"detailHeader",
    
    //> @attr detailViewer.printCellStyle (CSSStyleName : null : IRW)
    // Optional CSS style for a cell in printable HTML for this component. If unset 
    // +link{detailViewer.cellStyle} will be used for printing as well as normal presentation.
    // @visibility printing
    
    //<
    //> @attr detailViewer.printLabelStyle (CSSStyleName : null : IRW)
    // Optional CSS style for a label cell in printable HTML for this component. If unset 
    // +link{detailViewer.labelStyle} will be used for printing as well as normal presentation.
    // @visibility printing
    //<
    
    //> @attr detailViewer.printHeaderStyle (CSSStyleName : null : IRW)
    // Optional CSS style for a header in printable HTML for this component. If unset 
    // +link{detailViewer.headerStyle} will be used for printing as well as normal presentation.
    // @visibility printing
    //<

    //>	@attr	detailViewer.separatorStyle		(CSSStyleName : "detail" : IRW)
	//			CSS style for a separator
    // @group appearance
    // @visibility external
	//<
	separatorStyle:"detail",			

    //>	@attr	detailViewer.cellPadding		(number : 3 : [IRW])
    //          The amount of empty space, in pixels, surrounding each detailViewer value in its
    //          cell.
    //<
	cellPadding:3,
    
    //> @attr detailViewer.dateFormatter (DateDisplayFormat : null : IR)
	// Display format to use for fields specified as type 'date'.  Default is to use the
    // system-wide default normal date format, configured via
    // +link{Date.setNormalDisplayFormat()}.  Specify any valid +link{type:DateDisplayFormat} to 
    // change the format used by this detailViewer.
    // @visibility external 
    //<
    

	// Empty Message
	// --------------------------------------------------------------------------------------------

	//>	@attr	detailViewer.showEmptyMessage		(boolean : true : IRWA)
	// Show +link{attr:detailViewer.emptyMessage} when there is no data to display?
    // @see emptyMessage
    // @group emptyMessage
    // @visibility external
	//<
	showEmptyMessage:true,

    //>	@attr	detailViewer.emptyMessage		(string : "No items to display." : IRW)
    //          The string to display in the body of a detailViewer with no records.
    // @group emptyMessage
    // @visibility external
    //<
	emptyMessage:"No items to display.",
    
    //>	@attr	detailViewer.emptyMessageStyle		(CSSStyleName : "normal" : IRWA)
    // CSS style to display this message in
    // @group emptyMessage
    // @visibility external
	//<
	emptyMessageStyle:"normal",

    //>	@attr	detailViewer.loadingMessage		(string : "&nbsp;" : IRW)
    //          The string to display in the body of a detailViewer which is loading records.
    // @group emptyMessage
    // @visibility external
    //<
    loadingMessage:"&nbsp;",

    //>	@attr	detailViewer.loadingMessageStyle		(CSSStyleName : "normal" : IRWA)
    // CSS style to use for the +link{loadingMessage}.
    // @group emptyMessage
    // @visibility external
	//<
    loadingMessageStyle:"normal",

    // ---------------------------------------------------------------------------------------
    // About two values worth of data.   Keeps the DV from taking up the 100px default height
    // without being unexpectedly small when it has no data.
    defaultHeight:35 ,
    
    showLabel: true
});


// add methods
isc.DetailViewer.addMethods({


//>	@method	detailViewer.initWidget()	(A)
//			initializes the list of fields
//			sets up the data (if specified)
//
//		@param	[all arguments]	(object)	objects with properties to override from default
//<
initWidget : function () {
	// call the superclass function
	this.Super("initWidget",arguments);

	// include any field data from a specified dataSource.
	this.fields = this.bindToDataSource(this.fields);
},

//>	@method	detailViewer.setData()  ([])
// Sets the data displayed by this detail viewer.
//
//      @visibility external
//		@param	newData		(object or array)	new data to be displayed
//<
setData : function (newData) {
    
    // clear old observation
    if (this.data) this.ignore(this.data, "dataChanged");

	// remember the new data
	this.data = newData;

    if (this.data && this.data.dataChanged) {
        this.observe(this.data, "dataChanged", "observer.dataChanged()");
    }
    
	// and mark the viewer as dirty so it'll be redrawn
	this.markForRedraw("new data");
},

dataChanged : function () {
    this.applyHilites();
    this.markForRedraw();
},

//>	@method	detailViewer.getData()	(A)
//			return the data to be displayed
//
//		@return	(Object)	data for this widget - either Object or Array
//<
getData : function () { return this.data; },


//>	@method	detailViewer.getFields()	(A)
//			return the list of fields to display
//
//		@return	(List of DetailViewerField)	array of objects to display
//<
getFields : function () { return this.fields; },


//>	@method	detailViewer.getInnerHTML()	(A)
//			return the HTML for this widget
//		@return	(string)	HTML to display
//<
getInnerHTML : function () {
	// get the data to display
	var valueList = this.getData();

    // If the data is a result set, poke the ResultSet to fetch data and return the loading
    // message.  FIXME: DV needs to do paging to show large datasets meaningfully
    if (isc.ResultSet != null && isc.isA.ResultSet(valueList) && !valueList.lengthIsKnown()) {
        valueList.getRange(0, 10000);
        return this.loadingMessageHTML();
    }

	if ((valueList == null || (isc.isAn.Array(valueList) && valueList.getLength() == 0)) 
         && this.showEmptyMessage) {
		return this.emptyMessageHTML();		
	}
	
	//>DEBUG
	if (this.fields == null || this.fields.length == 0) {
		return "Note: you must define detailViewer.fields to specify what to display!";
	}
	//<DEBUG
	
	// normalize the data into an array
	if (!isc.isA.List(valueList)) valueList = [valueList];

	// if there's only one item or we're supposed to show all columns together
	if (valueList.getLength() == 1 || this.recordsPerBlock == "*") {
		// call the blockHTML routine with all items
		return this.getBlockHTML(valueList);
	} else {
		// otherwise call it for each item separately
		var output = isc.StringBuffer.newInstance();
		for (var startRow = 0; startRow < valueList.getLength(); startRow += this.recordsPerBlock) {
			output.append(this.getBlockHTML(valueList.getRange(startRow, startRow + this.recordsPerBlock)), this.blockSeparator);
		}
		return output.toString();
	}
},

//>	@method	detailViewer.getBlockHTML()	(A)
// Return the HTML for either a single object or a set of objects where each object gets one
// column.
//		@return	(string)	HTML to display
//<
getBlockHTML : function (valueList) {
	// how many separate value objects are we dealing with ?
	var numValues = valueList.getLength();
	
	// start the table to display the output
	var output = "<TABLE BORDER=0 CELLSPACING=0 CLASS=" + this.blockStyle 
            + " WIDTH=" + (this.useInnerWidth && !this.isPrinting ? this.getInnerWidth() 
                                                                   : "'100%'")
            + " CELLPADDING=" + this.cellPadding + (this.clipValues ? " STYLE='table-layout:fixed'" : "");
   
	output += ">";

	// output the data
	
	// get the list of fields to output
	var fields = this.fields;
	
	// iterate through each of the keys in detailFields and output the info for each field
	for (var fieldNum = 0, fieldLength = fields.length; fieldNum < fieldLength; fieldNum++) {
		var field = fields[fieldNum];
		if (!field) continue;

		// if the field has a showIf property
		if (field.showIf) {
			// CALLBACK API:  available variables:  "viewer,valueList"
			// Convert a string callback to a function

			if (!isc.isA.Function(field.showIf)) {
				isc.Func.replaceWithMethod(field, "showIf", "viewer,valueList");
			}

			// skip this if the showIf returns false
			if (field.showIf(this, valueList) == false) continue;
		}

		// MAE: if we don't want to show fields that have empty/null values
		// check the appropriate values and skip if they are all empty/null
		// This does not apply to headers and separators
		var type = field.type ? field.type : "";
		if (type != "separator" && type != "header" && !this.showEmptyField) {
			var valuesAreEmpty = true;
			for (var i = 0; i < valueList.getLength(); i++) {
				var value = valueList.get(i)[field[this.fieldIdProperty]]
				if (!(value == null || value == "")) {
					valuesAreEmpty = false;
					break;
				}
			}
			// if no values were found, continue to the next field
			if (valuesAreEmpty) continue;
		}

		// if there is a specific output function for this field, call that
		if (field.output) {
			// CALLBACK API:  available variables:  "fieldNum,field,valueList"
			// Convert a string callback to a function
			if (!isc.isA.Function(field.output)) {
				isc.Func.replaceWithMethod(field, "output", "fieldNum,field,valueList");
			}	
			output += field.output(fieldNum, field, valueList);
		} else {
			// output this particular field
			output += this.outputItem(fieldNum, field, valueList);
		}
	}
	// end the table
	output += "</TABLE>"
	// and return the output
	return output;
},


//>	@method	detailViewer.outputItem()	(A)
// Output one row of the data as HTML
//		@param	fieldNum		(number)		number of the field to output
//		@param	field		(object)		pointer to the field to output
//		@param	valueList	(array)			list of values to output
//
//		@return	(string)	HTML output
//<
outputItem : function (fieldNum, field, valueList) {
    
	var type = (field.type ? field.type : "value"),
		// functionName == name of a function to call to ouput this particular type of object
		functionName = "output_"+type,
		output = ""
	;
	// if a function by that name cannot be found, default to output_value
	if (!this[functionName]) functionName = "output_value";
	// start the table row
	output += "<TR" 
			+ (this.rowClass != null ? " CLASS='" + this.rowClass + "'" : "")
			+ ">";

	// output 
	output += this[functionName](fieldNum, field, valueList);
	
	// end the row
	output += "</TR>\r";

	// return the output
	return output;
},


//
//	OUTPUT HTML FOR DIFFERENT TYPES OF OBJECTS
//


//>	@method	detailViewer.output_value()	(A)
//			output a normal value for each field in valueList
//		@param	fieldNum		(number)		number of the field to output
//		@param	field		(object)		pointer to the field to output
//		@param	valueList	(array)			list of values to output
//
//		@return	(string)	HTML output
//<
output_blob : function (fieldNum, field, valueList) {
    return this.output_binary(fieldNum, field, valueList);
},
output_upload : function (fieldNum, field, valueList) {
    return this.output_binary(fieldNum, field, valueList);
},
output_binary : function (fieldNum, field, valueList) {
	// output the label
	var output = "<TD WIDTH=10% CLASS='" + 
            (this.isPrinting ? this.printLabelStyle || this.labelStyle : this.labelStyle) +
            "' ALIGN=RIGHT"
			+ (this.wrapLabel ? ">" : " NOWRAP><NOBR>")
			+ this.labelPrefix + (field.title ? field.title : field[this.fieldIdProperty]) + this.labelSuffix 
			+ "<\/NOBR><\/TD>"
	;

	// iterate for each object in valueList, outputing the object[field[this.fieldIdProperty]]
	for (var i = 0; i < valueList.getLength(); i++) {

        var record = valueList.get(i);
        var index = this.getData().indexOf(record);
        var name = record[field.name+"_filename"];
        var viewIconHTML = isc.Canvas.imgHTML("[SKIN]actions/view.png", 16, 16, null,
                        "style='cursor:"+isc.Canvas.HAND+"' onclick='"+this.getID()+".viewRow("+index+")'");
        var downloadIconHTML = isc.Canvas.imgHTML("[SKIN]actions/download.png", 16, 16, null,
                        "style='cursor:"+isc.Canvas.HAND+"' onclick='"+this.getID()+".downloadRow("+index+")'");

        var value = viewIconHTML + "&nbsp;" + downloadIconHTML + "&nbsp;" + name;

		// output the value as a cell
		output += "<TD CLASS='" + this.getCellStyle(value, field, record, this) + "'>"
                  + value + "<\/TD>";
	}
	return output;

},

viewRow : function (index) {
    isc.DS.get(this.dataSource).viewFile(this.getData().get(index));
},

downloadRow : function (index) {
    isc.DS.get(this.dataSource).downloadFile(this.getData().get(index));
},

// given an Array of records (valueList) output one complete DetailViewer row, which will have
// multiple data columns if recordsPerBlock > 1
output_value : function (fieldNum, field, valueList) {

	// output the label
    var output;
    if (this.showLabel) {
        output = "<TD WIDTH=10% CLASS='" + 
                (this.isPrinting ? this.printLabelStyle || this.labelStyle : this.labelStyle) + "' ALIGN=RIGHT"
            + (this.wrapLabel ? ">" : " NOWRAP><NOBR>")
            + this.labelPrefix + (field.title ? field.title : field[this.fieldIdProperty]) + this.labelSuffix 
            + "<\/NOBR><\/TD>"
        ;
    } else {
        output = "";    
    }
    // resolve field level valueMap reference strings to objects before going into the for loop
    if (field.valueMap && isc.isA.String(field.valueMap)) 
        field.valueMap = this.getGlobalReference(field.valueMap);
	
	// iterate for each object in valueList, outputing the object[field.name]
	for (var i = 0; i < valueList.getLength(); i++) {
        var record = valueList.get(i),
            formattedValue;
        if (field.type == "image") {
            // if any of field.imageWidth/Height/Size are set as strings, assume they are property
            // names on the record
            var width, height, imageWidthProperty, imageHeightProperty, imageSizeProperty;
            if (isc.isA.String(field.imageWidth)) {
                imageWidthProperty = field.imageWidth;
            } else {
                width = field.imageWidth;
            }
            if (isc.isA.String(field.imageHeight)) {
                imageHeightProperty = field.imageHeight;
            } else {
                height = field.imageHeight;
            }
            if (isc.isA.String(field.imageSize)) {
                imageSizeProperty = field.imageSize;
            } else {
                width = width || field.imageSize;
                height = height || field.imageSize;
            }
    
            if (record != null) {
                width = width || record[imageWidthProperty] || record[imageSizeProperty];
                height = height || record[imageHeightProperty] || record[imageSizeProperty];
            }
            var src = this.getCellValue(record, field),
                prefix = field.imageURLPrefix || field.baseURL || field.imgDir
            ;
            formattedValue = this.imgHTML(src, width, height, null, field.extraStuff, 
                                          prefix, field.activeAreaHTML);    
        } else {
            // NOTE: calls formatCellValue() 
            formattedValue = this.getCellValue(record, field);
        }

		// output the value as a cell.
        var rawValue = record[field.name];

        var cellStyle;
        if (field.getCellStyle) cellStyle = field.getCellStyle(rawValue, field, record, this);
        else cellStyle = (this.getCellStyle(rawValue, field, record, this) || this.cellStyle);
        
        var styleStr = " style='";
        if (this.clipValues) styleStr += "overflow:hidden;";
        styleStr += "text-align:" + this.valueAlign;

        if (this.getCellCSSText) {
            var cssText = this.getCellCSSText(rawValue, field, record, this);
            if (cssText != null) styleStr += ";" + cssText;
        }

        styleStr += "'";
		output += "<TD CLASS='" + cellStyle + "'" + styleStr
                + (this.wrapValues ? ">" : " NOWRAP><NOBR>")        
                 + formattedValue + (this.wrapValues ? "<\/NOBR>" : "") + "<\/TD>";
	}
	return output;
},

//>	@method	detailViewer.getCellCSSText()
// Return CSS text for styling this cell, which will be applied in addition to the CSS class
// for the cell, as overrides.
// <p>
// "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS
// stylesheet or in a STYLE attribute of an HTML element.
//
// @param value (any) actual value of this cell 
// @param field (DetailViewerField)	field object for this cell
// @param record (Record) record object for this cell	
// @param viewer (DetailViewer) the viewer instance to which this cell belongs
// @return (CSSText) CSS text to add to this cell
//
// @group apperance
// @visibility external
//<
getCellCSSText : function (value, field, record, viewer) {
    var cssText;
    // support applying a hilite specified on the record
    if (this.hilites && record[this.hiliteProperty] != null) {
        cssText = this.addObjectHilites(record, cssText, field);
    // support hilites specified in the hilites object
    } else if (this.hilites && record[this.hiliteMarker] != null) { 
        cssText = this.addHiliteCSSText(record, this.getFieldNum(field));
    }
   
    return cssText;
},

//>	@method	detailViewer.getCellStyle()
// Return the CSS class for a cell. Default implementation calls
// +link{detailViewerField.getCellStyle(), getCellStyle()} on the field if defined, otherwise
// returns +link{detailViewer.cellStyle,this.cellStyle}
// @param value (any) actual value of this cell 
// @param field (DetailViewerField)	field object for this cell
// @param record (Record) record object for this cell	
// @param viewer (DetailViewer) the viewer instance to which this cell belongs
// @return (CSSStyleName) CSS style for this cell
// @group apperance
// @visibility external
//<
// <P>
// Note: if +link{detailViewer.printCellStyle} is specified this will be used as the default
// styling for cells instead of <code>this.cellStyle</code> when generating printable HTML for 
// this component. 
getCellStyle : function (value, field, record, viewer) {
    if (field && field.getCellStyle) {
        return field.getCellStyle(value,field,record,viewer);
    }
    return (this.isPrinting && this.printCellStyle != null) ? this.printCellStyle 
                                                              : this.cellStyle;
},

//> @method DetailViewer.formatCellValue()
// Optional method to format the value to display for cells in this DetailViewer.
// Note that if +link{detailViewerField.formatCellValue()} is specified this method will not
// be called for cells within that field.
// @param value (string) the raw value of the cell (may be formatted by
//   +link{detailViewerField.formatCellValue()}
// @param record (detailViewerRecord) the record being displayed
// @param field (detailViewerField) the field being displayed
// @group i18nMessages
// @visibility external
//<

// getCellValue - method to actually get the value for a record.
// Called from 'output_value', which handles writing the <TD> tags around the value and
// outputting a whole block of records.
// Can be overridden by a user.
// Also if 'getCellValue()' is specified at a field level, will apply it to this cell.

getCellValue : function (record, field) {

    // get the value of this key for that field
    var value = record[field[this.fieldIdProperty]];
    if (isc.isA.String(field.formatCellValue)) {
        field.formatCellValue = isc.Func.expressionToFunction("value,record,field,viewer",
                                                              field.formatCellValue);
    }
    if (field.getCellValue != null) {
        if (isc.isA.String(field.getCellValue)) {
            field.getCellValue = isc.Func.expressionToFunction("value,record,field,viewer",
                                                                field.getCellValue);
        }
        // note the 'value' passed into field.getCellValue() is the raw value, not valueMapped, etc.
        // This matches the ListGrid's field-level getCellValue behavior.
        value = field.getCellValue(value, record, field, this);
        if (field.formatCellValue) value = field.formatCellValue(value, record, field, this);
    } else {
        
        // if the col has an 'valueMap' parameter, treat the value as a key in the valueMap
        if (field.valueMap != null) value = isc.getValueForKey(value, field.valueMap);    
    
        if (field.formatCellValue) value = field.formatCellValue(value, record, field, this);

        // if no value was specified, output the emptyCellValue
        if (value == null || isc.is.emptyString(value)) value = this.emptyCellValue;
    }

    // Support formatCellValue if specified.
    // - to match ListGrid behavior, don't run both field.formatCellValue and DV.formatCellValue()
    if (field.formatCellValue == null && this.formatCellValue) {
        value = this.formatCellValue(value, record, field);
    } else {
        // _formatDataType ensures that non string values get formatted as strings as appropriately    
        value = this._formatDataType(record, field, value);
        
        // field.asHTML is a boolean - if true, escape HTML chars in the value such as "<".
        if (field.asHTML) value = value.asHTML();
    }
    return value;
},

_$date:"date",
_formatDataType : function (record, field, value) {
    var type = field.type,
        baseType = (type != null ? isc.SimpleType.getBaseType(type) : null),
        formatter;
        
    // If the field has an explicitly specified formatter, use it
    
    if (baseType == this._$date)  
        formatter = (field.dateFormatter || field.formatter || this.dateFormatter);
    
    if (formatter != null) {
        if (isc.isA.Date(value)) value = value.toNormalDate(formatter);
    } else {
        
        if (field._normalDisplayFormatter != null) {
            value = field._simpleType.normalDisplayFormatter(value, field, this, record);
        }
        
        else if (field.type == null && isc.isA.Date(value)) value = value.toNormalDate();
    }
    
    return isc.iscToLocaleString(value);
},


//>	@method	detailViewer.output_header()	(A)
//			output a header field
//		@param	fieldNum		(number)		number of the field to output
//		@param	field		(object)		pointer to the field to output
//		@param	valueList	(array)			list of values to output
//
//		@return	(string)	HTML output
//<
output_header : function (fieldNum, field, valueList) {
	return "<TD COLSPAN=" + (valueList.getLength() + 1) + " CLASS='" + 
    (this.isPrinting && this.printHeaderStyle ? this.printHeaderStyle : this.headerStyle) +
    "'>"+field.value+"</TD>";
},


//>	@method	detailViewer.output_separator()	(A)
//			output a separator field
//		@param	fieldNum		(number)		number of the field to output
//		@param	field		(object)		pointer to the field to output
//		@param	valueList	(array)			list of values to output
//
//		@return	(string)	HTML output
//<
output_separator : function (fieldNum, field, valueList) {
	var width = (field.width == null ? field.defaultSeparatorWidth : field.width),
		height = (field.height == null ? field.defaultSeparatorHeight : field.height)
	;
	return "<TD COLSPAN=" + (valueList.getLength() + 1) + " CLASS='" + this.separatorStyle + "'>"
			+ isc.Canvas.spacerHTML(width, height)
			+ "</TD>";
},


//>	@method	detailViewer.getEmptyMessage()	(A)
//			return the empty message to display when no data was specified
//			this is a function so you can override it in complex cases
//			in simple cases, just returns this.emptyMessage
//
//		@return	(string)	HTML output
//<
getEmptyMessage : function () {
	return this.emptyMessage;
},
getLoadingMessage : function () {
	return this.loadingMessage;
},


//>	@method	detailViewer.emptyMessageHTML()	(A)
//			return the message to show if the list is empty
//
//		@return	(string)	HTML output
//<
emptyMessageHTML : function () {
	return "<TABLE WIDTH=100%>"
			+ "<TR><TD CLASS='" + this.emptyMessageStyle + "' ALIGN=CENTER><BR><BR>"
			+ this.getEmptyMessage()
			+ "<\/TD><\/TR><\/TABLE>";
},

//>	@method	detailViewer.loadingMessageHTML()	(A)
//			return the message to while the data is loading
//
//		@return	(string)	HTML output
//<
loadingMessageHTML : function () {
	return "<TABLE WIDTH=100%>"
			+ "<TR><TD CLASS='" + this.loadingMessageStyle + "' ALIGN=CENTER><BR><BR>"
			+ this.getLoadingMessage()
			+ "<\/TD><\/TR><\/TABLE>";
}



});	// END isc.DetailViewer.addMethods()

// Register stringMethods for this class - instance methods that can be defined as strings using
// specified keywords (replaced by arguments in the function created)
isc.DetailViewer.registerStringMethods({
    
    getCellValue:"record,field",
    getCellStyle:"value,field,record,viewer",
    getCellCSSText:"value,field,record,viewer",
    formatCellValue:"value,record,field,viewer"
});


