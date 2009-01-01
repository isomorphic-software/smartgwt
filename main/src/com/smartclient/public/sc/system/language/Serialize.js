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
//	Comm.serialize() methods for the comm package
//

// XXX this package must not be dependant on the Comm package, because serialization is a useful
// feature completely apart from Comm.  Unfortunately, the methods are currently expected to be on
// the Comm class, so if the Comm class doesn't exist we need to define it.
if (!isc.Comm) isc.ClassFactory.defineClass("Comm");

isc.Comm.addClassProperties( {
    //>	@classAttr	Comm._simpleIdentifierRE (regex : /^[\$_a-zA-Z][\$\w]*$/ : IR)
    //			Regular expression to match legal identifier names so we can 
    //			 avoid unnecessary quotes when serializing.
    //		@group	serialization
    //<
	_simpleIdentifierRE : 	/^[\$_a-zA-Z][\$\w]*$/,

    //>	@classAttr	Comm.BACKREF_PREFIX (string : "$$BACKREF$$:" : IR)
	//			Prefix for back-references in serialized object references.
	//		@group	serialization
	//<
	BACKREF_PREFIX : "$$BACKREF$$:",	

    indent : "    ",

    //>	@classAttr	Comm.serializeBackRefs (boolean : true : IR)
    // This setting affects properties that contain a back reference (reference to a value already
    // serialized as part of the object being serialized).
    // <p>
    // If this setting is true, we generate a backref text string that is the path to the target
    // location.  If false, the property whose value is a backref is not serialized at all.
    //
    //		@group	serialization
    //<
    serializeBackRefs: true
});


isc.Comm.addClassMethods({

//>	@classMethod	Comm.serialize()
// Serialize an object of any type into a string, in a form that
// can be simply eval'd to rebuild the original object.
//
//		@group	serialization
//		
//		@param	object		(any)		object to be serialized
//		@param	[indent]	(boolean)	true == output should be indented for reading, false == no indentation
//
//		@return				(string)	serialized form of the object
//<
serialize : function (object, indent) {
	return isc.Comm._serialize(object, indent ? "" : null);
},

//>	@classMethod	Comm._serialize()	(A)
//		Internal routine that actually does the serialization.
//		@group	serialization
//
//		@param	object	(any)		object to serialize
//		@param	prefix	(string)	string to put before each line of serialization output
//		@param	context (object)	context that tracks previously encountered objects and
//                                  settings
//
//		@return	(string)			serialized object as a string
//<
_serialize : function (object, prefix, context) {
	if (!context) {
		context = {};
		context.objRefs = {obj:[],path:[]};
		if (!context.objPath) {
			if (object && object.getID) context.objPath = object.getID();
			else context.objPath = "";
		}
	}
	// handle simple types
	if (object == null) return null;

    // In Safari a cross-frame scripting bug means that the 'asSource' method may not always be
    // available as an instance method.
    // call the static version of the same method if this happens.
	if (isc.isA.String(object)) return (object.asSource != null ? object.asSource() 
                                                                : String.asSource(object));
	if (isc.isA.Function(object)) return null;
	if (isc.isA.Number(object) || isc.isA.SpecialNumber(object)) return object;
	if (isc.isA.Boolean(object)) return object;
	
	// for complex types:
	
	// detect infinite loops by checking if we've seen this object before.
    // To disambiguate between true loops vs the same leaf object being encountered twice
    // (such as a simple Array containing two Strings which appears in two spots).  Only
    // consider this a loop if the preceding occurence of the object was some parent of
    // ours.  
	var prevPath = isc.Comm._serialize_alreadyReferenced(context.objRefs, object);
	if (prevPath != null && context.objPath.contains(prevPath)) {
        // Note: check that the first char after "prevPath" is a path separator char in order
        // to avoid false loop detection with "prop" and "prop2" having the same non-looping
        // object (since "prop2" contains "prop").
        var nextChar = context.objPath.substring(prevPath.length, prevPath.length+1);
        //this.logWarn("backref: prevPath: " + prevPath + ", current: " + context.objPath +
        //             ", char after prevPath: " + nextChar);
        if (nextChar == "." || nextChar == "[" || nextChar == "]") {
            if (this.serializeBackRefs) return "'" + isc.Comm.BACKREF_PREFIX + prevPath + "'";
            return isc.emptyString;
        }
	}

    if (isc.isA.Class(object)) {
        this.logWarn("Attempt to serialize class of type: " + object.getClassName()
                     + " at path: " + context.objPath + " - returning null for this slot.");
        return null;
    }
    if (object == window) {
        this.logWarn("Serializer encountered the window object at path: " + context.objPath
                    +" - returning null for this slot.");
        return null;
    }

	// add the object to the list of objRefs so we can avoid an endless loop
	isc.Comm._serialize_remember(context.objRefs, object, context.objPath);
	
	// if there is a serialize method associated with this object, call that
	if (isc.isA.Function(object._serialize)) return object._serialize(prefix, context.objRefs, context.objPath);

	// handle arrays as a special case
	if (isc.isAn.Array(object))	return isc.Comm._serializeArray(object, context.objPath, context.objRefs, prefix);

    var data;
	// if the object has a getSerializeableFields, use whatever it returns, otherwise just use the object
    if (object.getSerializeableFields) {
        
		data = object.getSerializeableFields([], []);
    } else {
        data = object;
    }
	// and return anything else as a simple object
	return isc.Comm._serializeObject(data, context.objPath, context.objRefs, prefix);
},

//>	@classMethod	Comm._serializeArray()	(A)
//			Internal routine to serialize an array.
//		@group	serialization
//
//		@param	object	(any)		object o serialize
//		@param	prefix	(string)	string to put before each line of serialization output
//		@param	objRefs	(object[])	array of objects that have been serialized already so
//									 we don't get into endless loops		
//		@param	objPath	(string)	global variable path to this object, for serializing object references
//
//		@return	(string)			serialized object as a string
//<
_serializeArray : function (object, objPath, objRefs, prefix) {
	// add the start array marker
	var output = isc.SB.create();
    output.append("[");
	// for each element in the array
	for (var i = 0, len = object.length; i < len; i++) {
		var value = object[i];
		// output that element
        if (prefix != null) output.append("\r", prefix, isc.Comm.indent);

        var context = {objRefs : objRefs, objPath : isc.Comm._serialize_addToPath(objPath, i)};
        var serializedValue =  
            isc.Comm._serialize(value,
                                (prefix != null ? prefix + isc.Comm.indent : null), 
                                context);
        // NOTE: need to concat serializedValue to have null/undef properly handled, normally
        // skipped by StringBuffers
        output.append(serializedValue + ",");
        if (prefix != null) output.append(" ");
	}
	// get rid of the trailing comma, if any
    output = output.toString();
	var commaChar = output.lastIndexOf(",");
	if (commaChar > -1) output = output.substring(0, commaChar);

	// add the end array marker
    if (prefix != null) output += "\r" + prefix;
    output += "]";

	// and return the output
	return output;	
},

//>	@classMethod	Comm._serializeObject()	(A)
//			Internal routine to serialize an object.
//		@group	serialization
//
//		@param	object	(any)		object o serialize
//		@param	prefix	(string)	string to put before each line of serialization output
//		@param	objRefs	(object[])	array of objects that have been serialized already so
//									 we don't get into endless loops		
//		@param	objPath	(string)	global variable path to this object, for serializing object references
//
//		@return	(string)			serialized object as a string
//<
_serializeObject : function (object, objPath, objRefs, prefix) {
	// add the start object marker
	var output = isc.SB.create(),
        undefined;

    object = this._serialize_cleanNode(object);

    output.append("{");
	// for each key in the object
	for (var key in object) {
		// skip null keys
		if (key == null) continue;
		
		var value = object[key];
		// if the value is a function, skip it		
		if (isc.isA.Function(value)) continue;

		// otherwise return the key:value pair

		// convert the key to a string
		var keyStr = key.toString();
		// and if it isn't a simple identifier, quote it
		if (! isc.Comm._simpleIdentifierRE.test(keyStr)) keyStr = '"' + keyStr + '"';
    
        var context = { objRefs : objRefs, 
                        objPath : isc.Comm._serialize_addToPath(objPath, key)};
        var serializedValue = 
            isc.Comm._serialize(value, 
                                (prefix != null ? prefix + isc.Comm.indent : null),
                                context);

        // skip values that resolve to undefined
        if (serializedValue === undefined) continue;

		// now output the key : value pair
        if (prefix != null) output.append("\r", prefix, isc.Comm.indent);

        // NOTE: need to concat serializedValue to have null/undef properly handled, normally
        // skipped by StringBuffers
		output.append(keyStr, ":" + serializedValue, ",");
    
        if (prefix != null) output.append(" ");
	}
	// get rid of the trailing comma, if any
    output = output.toString();
	var commaChar = output.lastIndexOf(",");
	if (commaChar > -1) output = output.substring(0, commaChar);

	// add the end object marker
    if (prefix != null) output += "\r" + prefix;
    output += "}";

	// and return the output
	return output;
},

//>	@classMethod	Comm._serialize_remember()	(A)
//			Remember an object that has just been serialized it, so we don't
//			 attempt to serialize it again (and thus get into an endless loop).
//		@group	serialization
//
//		@param	objRefs	(object[])	array of objects that have been serialized already so
//		@param	object	(any)		object o serialize
//		@param	path	(string)	global variable path to this object, for serializing object references
//<
// helper function to remember that we've already output a particular object in this serialize pass
_serialize_remember : function (objRefs, object, path) {
	objRefs.obj.add(object);
	objRefs.path.add(path);
},

// If this object is a Tree node, automatically clean off properties that the Tree adds to the
// node that should not be saved.

_serialize_cleanNode : function (object) {
    var treeId = object["_isc_tree"];
    if (treeId != null) {
        var theTree = window[treeId];
        if (theTree && theTree.parentProperty && object[theTree.parentProperty]) {
            object = theTree.getCleanNodeData(object);
        }
    }
    return object;
},

//>	@classMethod	Comm._serialize_alreadyReferenced()	(A)
// 			Have we already output a particular object in this serialize pass?  
//			If so, return the path to that object
//			If not, return null
//		@group	serialization
//
//		@param	objRefs	(object[])	array of objects that have been serialized already so
//		@param	object	(any)		object o serialize
//									 we don't get into endless loops		
//
//		@return	(string)			path to the object if already serialized,
//									null if not already serialized
//<
_serialize_alreadyReferenced : function (objRefs, object) {
	var rowNum = objRefs.obj.indexOf(object);
	if (rowNum == -1) return null;
	return objRefs.path[rowNum];
},

//>	@classMethod	Comm._serialize_addToPath()	(A)
//			Add a new identifier to an object path, used to build the
//			 path passed in to _serialize() above.
//		@group	serialization
//
//		@param	objPath			(string)	global variable path to this object, for serializing object references
//		@param	newIdentifier	(string)	new identifier to put on the end of the path
//
//		@return					(string)	global identifier to locate the particular object
//<
// add a new identifier to an object path
_serialize_addToPath : function (objPath, newIdentifier) {
	if (isc.isA.Number(newIdentifier)) {
		return objPath + "[" + newIdentifier + "]";
	} else if (! isc.Comm._simpleIdentifierRE.test(newIdentifier)) {
		return objPath + '["' + newIdentifier + '"]';
	} else {
		return objPath + "." + newIdentifier;
	}
}

});	// END isc.addMethods(isc.Comm, {})
