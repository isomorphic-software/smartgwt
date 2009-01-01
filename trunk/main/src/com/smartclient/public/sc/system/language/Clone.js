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
//
//	clone() methods for the comm package
//

isc.addGlobal("clone", function (object, objPath) { return isc.Comm._clone(object); });

isc.Comm.addClassMethods({

//>	@classMethod	isc.clone()
// Create a deep clone of an object that can be edited without affecting the original
// <br>
// All mutable types, including Objects, Arrays and Dates, are copied.  All immutable types are
// just preserved by reference.
// <br>
// Does not handle looping references (will infinite loop).
//
// @visibility external
//
//		@group	serialization
//		@param	object		(object)	object to clone
//		@return				(object)	cloned object	
//<
clone : isc.clone,

_clone : function (object) {
    

    // preserve undef vs null (eg slot values)
    var undef;
    if (object === undef) return undef;
	if (object == null) return null;

    // just return immutable types
	if (isc.isA.String(object) || isc.isA.Boolean(object) ||
	    isc.isA.Number(object) || isc.isA.Function(object)) return object;

    // copy mutable types
	if (isc.isA.Date(object)) {
		var newDate = new Date(object.getTime());
		newDate.logicalDate = object.logicalDate;
		return newDate;
	}
	
	if (isc.isAn.Array(object)) return isc.Comm._cloneArray(object);
    // allow a clone() function to be implemented
	if (isc.isA.Function(object.clone)) return object.clone();
	return isc.Comm._cloneObject(object);
},

_cloneArray : function (object) {
	var output = [];
	for (var i = 0, len = object.length; i < len; i++) {
		output[i] = isc.Comm._clone(object[i]);
	}
	return output;
},

_cloneObject : function (object) {
	var output = {};
	for (var key in object) {
		var value = object[key];
		output[key] = isc.Comm._clone(value);
	}
	return output;
}

});	// END isc.addMethods(isc.Comm, {})
