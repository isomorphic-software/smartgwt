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
		"language/XMLSerialize",		// serialize an object as an xml string
		"language/Clone",				// make a isc.clone (duplicate) of an object

        "language/XMLTools",

		"application/DataSource",		// representation of a server data source (databse table, etc)
        "application/WebService",       // WebService / WSDL 
		"application/RPCManager",	    // framework for editing/interacting with datasources
		"application/DMI",	            // Direct Method Invocation
		"application/ResultSet",        // data model for Lists loaded incrementally from a server
		"application/ResultTree",       // data model for Trees loaded incrementally from a server
		"application/ActionMethods",      // flow methods for databinding-capable components

        
        
		"widgets/EditMode",             // support for an editing mode and editing container
		"widgets/PropertySheet",        // specialized, compact form

        "widgets/ListEditor",           // combination grid and form for editing a list of
                                        // records

		"widgets/ViewLoader",	    // manages components dynamically loaded from server
		"widgets/HTMLFlow",	        // a block of free-flowing HTML, with dynaload facilities

        "application/WSDataSource", // DataSource that works through ISC Web Service
        "application/RestDataSource", // Generic DataSource for arbitrary web servers (PHP / etc)

        // load schema needed to perform client-side XML to JS just for WSDL/XMLSchema
        // definitions produced by the schemaTranslator
        "schema/DataSource.ds.xml",
        "schema/DataSourceField.ds.xml",
        "schema/Validator.ds.xml",
        "schema/SimpleType.ds.xml",
        "schema/XSComplexType.ds.xml",
        "schema/XSElement.ds.xml",
        "schema/SchemaSet.ds.xml",
        "schema/WSDLMessage.ds.xml",
        "schema/WebService.ds.xml",
        "schema/WebServiceOperation.ds.xml",
        "schema/WSOperationHeader.ds.xml",

        "application/Operators",        // i18n naming object for AdvancedCriteria operators
		"widgets/form/FilterBuilder",	// advanced search form that allows the user to specify
                                        // individual fields and operators

		"widgets/BatchUploader",	    // Upload CSV file to DataSource and display results 
		                                // in LG (with errors flagged) for user confirmation

        //>S3
        //"application/S3",
        //<S3
        
        "widgets/ScreenReader"
        
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
