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

 





//>	@class	RowSpacerItem
// Form item that renders as a blank row in the form layout.<br>
// Set +link{rowSpacerItem.startRow} to <code>false</code> to create a rowSpacer that simply
// takes up every remaining column in the current row rather than starting a new row.
// @visibility external
//<
isc.ClassFactory.defineClass("RowSpacerItem", "SpacerItem");
isc.RowSpacerItem.addProperties({
    //>	@attr	rowSpacerItem.showTitle		(boolean : false : IRW)
	//			we never show a separate title cell for separators
	//		@group	appearance
    // @visibility external
	//<	
	showTitle:false,					

    //>	@attr	rowSpacerItem.colSpan				(number : "*" : IRW)
	//			by default, separators span all remaining columns
	//		@group	appearance
    // @visibility external
	//<	
	colSpan:"*",						

    //>	@attr	rowSpacerItem.startRow		(boolean : true : IRW)
	//			these items are in a row by themselves by default
	//		@group	appearance
    // @visibility external
	//<
	startRow:true,
	
    //>	@attr	rowSpacerItem.endRow			(boolean : true : IRW)
	//			these items are in a row by themselves by default
	//		@group	appearance
    // @visibility external
	//<
	endRow:true,

    //>	@attr	rowSpacerItem.width				(number : 20 : IRW)
	//			default width for the separator
	//		@group	appearance
	//<
	width:20,

    //>	@attr	rowSpacerItem.height			(number : 20 : IRW)
	//			default height for the separator
	//		@group	appearance
	//<
	height:20							
});

