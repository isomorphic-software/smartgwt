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

 






  //>DEBUG
// This lets us label methods with a name within addMethods
String.prototype.Class = "String";
  //<DEBUG 

//>	@class String
//	Generic extensions to JavaScript Strings.  You can call these on any String.
// @treeLocation Client Reference/System
// @visibility external
//<

isc._patchLocaleSupport = function () {
    
    var protos = [Array, Number, Date].getProperty("prototype");
    for (var i = 0; i < protos.length; i++) {
        var theProto = protos[i];
        if (theProto.toLocaleString == null) {
            theProto.toLocaleString = theProto.toString;
        }
    }

    // ensure String.toLocaleUpper/LowerCase are there so we can call them blindly
    var strProto = String.prototype;
    if (!strProto.toLocaleUpperCase) {
        strProto.toLocaleUpperCase = strProto.toUpperCase;
        strProto.toLocaleLowerCase = strProto.toLowerCase;
    }

    // Mozilla's String.toLocaleString() actually does the equivalent of Object.toString(),
    // which is to return [object String] instead of the string value, so we patch it to
    // simply return the equivalent of String.toString() since Strings are unicode by nature.
    if (isc.Browser.isMoz) {
        var string = "x",
            localeString = string.toLocaleString();
            if (localeString != string) {
                
                strProto.toBrowserLocaleString = strProto.toLocaleString;
                strProto.toLocaleString = strProto.toString;
            }
        // Patch Boolean as well
        string = true;
        localeString = string.toLocaleString();
        if (localeString != string + "") {
            
            Boolean.prototype.toBrowserLocaleString = Boolean.prototype.toLocaleString;
            Boolean.prototype.toLocaleString = Boolean.prototype.toString;   
        }
    }
}
isc._patchLocaleSupport();

isc.addProperties(String, {
    _singleQuoteRegex : new RegExp("'", "g"),
    _doubleQuoteRegex : new RegExp("\"", "g")
});

isc.addMethods(String.prototype, {

//>	@method	string.replaceAll()
//			Replace all occurances of 'find' string with 'replacement' string.
//			Uses a native method so is very efficient (and easier to use than grep).
//		@group	stringProcessing
//
//		@param	find		(string)	string to find
//		@param	replacement	(string)	string to replace each occurance of find with
//
//		@return				(string)	new string with replacements made
//<
replaceAll : function (find, replacement) {
    
    return isc.replaceAll(this, find, replacement);
},

//>	@method	string.contains()
//			Returns true if this string contains the specified substring.
//		@group	stringProcessing
//
//		@param	substring	(String)	string to look for
//		@return				(boolean)	true == this string contains the substring
// @visibility external
//<
contains : function (substring) {
    // support eg Numbers.  Note: only available with non-performance-critical version of API
    if (!isc.isA.String(substring)) substring = substring.toString();

    
	return isc.contains(this, substring);
},

//>	@method	string.startsWith()
//			Returns true if this string starts with another string.
//		@group	stringProcessing
//
//		@param	substring	(String)	other string to check
//		@return				(boolean)	true == this string starts with substring
// @visibility external
//<
startsWith : function (substring) {
    // support eg Numbers.  Note: only available with non-performance-critical version of API
    if (!isc.isA.String(substring)) substring = substring.toString();

    
    return isc.startsWith(this, substring);
},


//>	@method	string.endsWith()
//			Returns true if this string ends with another string.
//		@group	stringProcessing
//
//		@param	substring	(String)	other string to check
//		@return				(boolean)	true == this string ends with substring
// @visibility external
//<
endsWith : function (substring) {
    // support eg Numbers.  Note: only available with non-performance-critical version of API
    if (!isc.isA.String(substring)) substring = substring.toString();

    
    return isc.endsWith(this, substring);
},

trim : function (chars) {
    var removeChars = chars || " \t\n\r",
        l = this.length,
        start = 0,
        end = l - 1,
        i = 0;

    // find first character not in the removal list
    while (start < l && removeChars.contains(this.charAt(i++))) start++;

    // find last character not in the removal list
    i = l - 1;
    while (end >= 0 && removeChars.contains(this.charAt(i--))) end--;

    return this.substring(start, end + 1);
},

//>	@method	string.convertTags()	(A)
//			Convert all tag symbols ( &lt;  and &gt; ) into displayable HTML
//			by changing them to   &amp;lt;  and  &amp;gt;   respectively.
//		@group	stringProcessing
//
//		@param	[prefix]	(string)	text to tack onto the beginning of result (eg: "&lt;PRE&gt;")
//		@param	[suffix]	(string)	text to tack onto the end of result (eg: "&lt;/PRE&gt;")
//
//		@return				(string)	prefix + converted text + suffix as a single string
//<
convertTags : function (prefix,suffix){
	// use regular expressions to convert < and > characters
	return (prefix ? prefix : "") +
		this.replace(/</g, "&lt;").replace(/>/g, "&gt;") +
		(suffix ? suffix : "");
},

//>	@method	string.asHTML()
// Convert plain text into into displayable HTML.
// <p>
// This prevents HTML-special characters like &lt; and &gt; from being interpreted as tags, and
// preserves line breaks and extra spacing.
//           <pre>
//				converts		   to
//				--------  		   ---------------------------
//				  &				   &amp;
//				  <				   &lt;
//				  >				   &gt;
//				  \r,\n,\r\n1space <BR>&nbsp;
//				  \r,\n,\r\n	   <BR>
//				  \t			   &nbsp;&nbsp;&nbsp;&nbsp;
//				  2 spaces		   1space&nbsp;
//           </pre>
//		@group	stringProcessing
//
//	@return				(string)	prefix + converted text + suffix as a single string
//<
asHTML : function (noAutoWrap) {
	var s = this.replace(/&/g, "&amp;")
                .replace(/</g, "&lt;")
                .replace(/>/g,"&gt;")
                // if we don't do this, we lose the leading space after a crlf because all
                // browsers except IE in compat (non-standards) mode treat a <BR> followed by a
                // space as just a <BR> (the space is ignored)
                .replace(/(\r\n|\r|\n) /g,"<BR>&nbsp;")
                .replace(/(\r\n|\r|\n)/g,"<BR>")
                .replace(/\t/g,"&nbsp;&nbsp;&nbsp;&nbsp;");
    // in autoWrap mode, replace two spaces with a space and an &nbsp; to preserve wrapping to
    // the maximum extent possible
    return (noAutoWrap ? s.replace(/ /g, "&nbsp;") : s.replace(/  /g, " &nbsp;"));
},

// revereses asHTML()
unescapeHTML : function () {
    // Note: in asHTML() we turn tabs into four &nbsp;, this reversal is lossy in that it turns
    // those into four spaces - but we really have no way of knowing whether there were four
    // spaces there before or a tab.
    return this.replace(/&nbsp;/g, " ")
               .replace(/<BR>/gi, "\n")
               .replace(/&gt;/g, ">")
               .replace(/&lt;/g, "<")
               .replace(/&amp;/g, "&");
},




//>	@method	string.toInitialCaps()
//			Convert A String To Initial Caps
//		@group	stringProcessing
//
//		@return				(string)	converted string
//<
toInitialCaps : function (){
	// lowercase the entire thing, then split by spaces
	var it = this.toLowerCase().split(" ");
	// for each word
	for (var i = 0; i < it.length; i++) {
		// uppercase the first letter, then add the rest (already lower case)
		it[i] = it[i].substring(0,1).toLocaleUpperCase() + it[i].substring(1);
	}
	return it.join(" ");
},


//>	@method	string.evalDynamicString()
//			Look for ${expressions} in a string and evaluate them.  To escape, prepend a 
//		    backslash to the dollar sign.  Note that in the event that you actually want
//          to display \${  you will have to escape the backslash as follows: \\${.  Note
//          also that if you're writing this in a JS string you must escape the backslash
//          again.
//		@group	dynamicString
//
//		@return				(string)	converted string
//<
evalDynamicString : function (target, evalVars) {
    // must toString() - otherwise strange object literal with slots is returned
	if (this.indexOf("${") < 0) return this.toString();
	var str = this, lastStart, start, end, evalBlock;

	// hand-coded for performance	
	var accum = isc.StringBuffer.create();
	while ((start = str.indexOf("${")) != -1) {
			end = str.indexOf("}", start + 1);
			if (end == -1) break;

			// handle escapes
			if (str.charAt(start - 1) == '\\') {
				accum.append(str.slice(0, start - 1), str.slice(start, end + 1));
				str = str.substring(end + 1, str.length);
				continue;
			}
			var evalBlock = str.slice(start + 2, end);
            var evalResult;
            if (evalVars != null && evalVars[evalBlock]) {
                // shortcut to avoid evalWithVars, which creates a Function each time
                evalResult = evalVars[evalBlock];
            } else {
                try {
                    evalResult = isc.Class.evalWithVars(evalBlock, evalVars, target);
                } catch (e) {
                    // if a target has been supplied, use that for the log report
                    var logTarget = target ? target : isc.Log;
                    logTarget.logWarn("dynamicContents eval error - returning empty string for block -->${"
                                      + evalBlock + "}<-- error was: " + isc.Log.echo(e));
                    evalResult = isc.emptyString;                
                }
            }
			accum.append(str.slice(0, start), evalResult);
			str = str.substring(end + 1, str.length);
	}
	accum.append(str);
	str = accum.toString();
	return str;
},


//>	@method	string.asSource()	(A)
// Return a new String that, evaluated as source code, would produce this String's value.
//		@group	stringProcessing
//
//		@return				(string)	new string
//<
asSource : function (singleQuote) {
    return String.asSource(this, singleQuote);
}


});


isc.addMethods(String, {

    //>	@classMethod	String.asSource()
    //			Static method to return a new String that, evaluated as source code, would produce 
    //          the passed in String's value.
    //		@group	dynamicString
    //		@param	string  (string)    string to convert
    //		@return			(string)	converted string
    //<
    
    asSource : function (string, singleQuote) {
        if (!isc.isA.String(string)) string = ""+string;

        var quoteRegex = singleQuote ? String._singleQuoteRegex : String._doubleQuoteRegex,
            outerQuote = singleQuote ? "'" : '"';
        return outerQuote +
                   string.replace(/\\/g, "\\\\")
                         // quote whichever quote we use on the outside
                         .replace(quoteRegex, '\\' + outerQuote)
                         .replace(/\t/g, "\\t")
                         .replace(/\r/g, "\\r")
                         .replace(/\n/g, "\\n") + outerQuote;
    }                     
});






isc.addMethods(isc, {

// isc.replaceAll() [string helper]
//  Replace all occurances of 'find' string with 'replacement' string.
//  Uses a native method so is very efficient (and easier to use than grep).
replaceAll : function (source, find, replacement) {
	return source.split(find).join(replacement);
},

// isc.contains() [string helper]
//  Returns true if this string contains the specified substring.
contains : function (string1, substring) {
    if (string1 == null) return false;

	return string1.indexOf(substring) > -1
},

// isc.startsWith() [string helper]
//  Returns true if this string starts with another string.
startsWith : function (string1, substring) {
    if (string1 == null) return false;

    return (string1.lastIndexOf(substring, 0) == 0);
},


// isc.endsWith() [string helper]
//  Returns true if this string ends with another string.
endsWith : function (string1, substring) {
    if (string1 == null) return false;

    var startPos = string1.length - substring.length;
    if (startPos < 0) return false; // substring longer than main string
    return (string1.indexOf(substring, startPos) == startPos);
},

// escapes special characters in XML values - so called 'unparsed data'
// " -> &quot;
// ' -> &apos;
// & -> &amp;
// < -> &lt;
// > -> &gt;
// \r -> &x000D;
//
// NOTE: in an XHTML document, this is baseline functionality.
// 
// NOTE: leave this function at the end of the file because the quotes within regex's hose the
// obfuscator, causing it to continue to end of file
makeXMLSafe : function (string) {
    if (string == null) return isc.emptyString;
    else if (!isc.isA.String(string)) string = string.toString();

	return string.replace(/&/g, "&amp;").
			replace(/</g, "&lt;").
			replace(/>/g, "&gt;").
			replace(String._doubleQuoteRegex, "&quot;").
			replace(String._singleQuoteRegex, "&apos;").
            replace(/\r/, "&#x000D;")
    ;
},

makeCDATA : function (string) {
    return "<![CDATA["+string.replace(/\]\]>/, "]]<![CDATA[>")+"]]>";
}

});
