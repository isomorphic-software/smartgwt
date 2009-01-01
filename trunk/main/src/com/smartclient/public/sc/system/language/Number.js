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
Number.prototype.Class = "Number";
  //<DEBUG 


//>	@object	Number
//
//	Extra methods added to the Number object, available on all number variables.
//
//  @visibility external
//  @treeLocation Client Reference/System
//<

//
// add methods to all Numbers
//
isc.addMethods(Number.prototype, {
//>	@method	number.stringify()
//
// Return this number as a string padded out to digits length.
//
// @visibility external
// @example var str = myNumberVar.stringify(2);
// @group	stringProcessing
// @param	[digits]	(number : 2)	Number of digits to pad to.  (Default is 2)
// @return				(string)		Padded string version of the number
//<

stringify : function (totalDigits) {
	// default to 2 digits
	if (!totalDigits) totalDigits = 2;
	
    var numberString = this.toString(),
        zeroes = totalDigits - numberString.length,
        pad = Number._getZeroString(zeroes);

    if (pad == null) return numberString;
    return pad + numberString;
},

//>	@method	number.toCurrencyString()
// Return this number as a currency-formatted string.
//		@group	stringProcessing
//
//		@param	[currencyChar]	(string : "$")	Currency symbol, can be set to an empty string.
//		@param	[decimalChar]	(string : ".")	Decimal separator symbol.
//		@param	[padDecimal]	(boolean : true)	Should decimal portion be padded out to two digits?
//		@param	[currencyCharLast]	(boolean : null)	Should currency symbol come at the end of the string?
//
//		@return				(string)		Currency-formatted string version of the number
//<
toCurrencyString : function(currencyChar, decimalChar, padDecimal, currencyCharLast) {
	var wholeNumber = Math.floor(this),
		decimalNumber = Math.round((this - wholeNumber)*100),
		output = isc.StringBuffer.create();
	
	// default currency/decimal symbols and decimal padding on
	// allow empty string for no currency character
	if (!isc.isA.String(currencyChar)) currencyChar = "$";
	if (!isc.isA.nonemptyString(decimalChar)) decimalChar = ".";
	if (padDecimal == null) padDecimal = true;
	
	// output currency symbol first by default
	if (currencyCharLast != true) output.append(currencyChar);
	
	// output whole number
	output.append(wholeNumber.stringify(1));

	// output decimal symbol and decimal number
	// (unless padding is off and decimal portion is 0)
	if (padDecimal) {
		output.append(decimalChar);
		output.append(decimalNumber.stringify(2));
	} else if (decimalNumber != 0) {
		output.append(decimalChar);
		if (decimalNumber % 10 == 0) output.append(decimalNumber/10);
		else output.append(decimalNumber.stringify(2));
	}
	
	// output currency symbol last if specified
	if (currencyCharLast == true) output.append(currencyChar);

	return output.toString();
}

// NOTE:
// We don't provide 'setFormatter' or 'setStandardFormatter' instance methods for Numbers.
// This is because 
// a) we don't want to confuse the issue of where formatters are stored (we have a pattern here
//    and on Dates of having standard formatters for all instances only)
// b) (at least in IE), numbers are not allocated as "true instances", so having a 
//     number instance (var theVar = 2;) does not mean that you can set up properties on it, 
//     such as theVar.formatter -- when you next refer to 'theVar', you are really given 
//     another '2' instance, so your properties have been wiped out.

});

//
// add class-methods to the Number object
//
isc.addMethods(Number, {

//>	@classMethod	Number.setStandardFormatter()
//			Set the standard "toString()" formatter for Number objects.
//			After this call, all  <code>number.toString()</code>  calls will yield a number
//			 in this format.
//
//		@group	stringProcessing
//		@param	functionName	(string)	name of a formatting function on the number object 
//                                          prototype
//<
setStandardFormatter : function (functionName) {
	if (isc.isA.Function(Number.prototype[functionName]))
        Number.prototype.formatter = functionName;
},

//>	@classMethod	Number.setStandardLocaleStringFormatter()
//			Set the standard locale formatter for all Number objects.
//			After this call, all  <code>isc.iscToLocaleString(number)</code> for number instances 
//          calls will yield the string returned by the formatter specified.
//		@group	stringProcessing
//
//		@param	functionName (string)	name of a formatting function (on number instances)
//<
setStandardLocaleStringFormatter : function (functionName) {
	if (isc.isA.Function(Number.prototype[functionName]))
        Number.prototype.localeStringFormatter = functionName;
},
 
_1zero : "0",
_2zero : "00",
_3zero : "000",
_4zero : "0000",

_getZeroString : function (length) {
    if (length <= 0) return;

	var pad;
    // with > 4 zeros (very rare), build up a leading pad 4 0's at a time
    while (length > 4) {
        if (pad == null) pad = this._4zero;
        else pad += this._4zero;
        length -= 4;
    }

    var finalPad;
    switch (length) {
        case 4: finalPad = this._4zero; break; 
        case 3: finalPad = this._3zero; break; 
        case 2: finalPad = this._2zero; break; 
        case 1: finalPad = this._1zero; break; 
    } 

    // no leading pad (less than 4 zeros total)
    if (pad == null) return finalPad;
    return pad + finalPad;
}

});

// set the standard formatter for the date prototype to the native browser string
// so 'toFormattedString()' defaults to returning the standard number format string
if (!Number.prototype.formatter) Number.prototype.formatter = "toString";


if (!Number.prototype.localeStringFormatter) 
    Number.prototype.localeStringFormatter = "toString";



isc.addProperties(Number.prototype, {
    
//>	@method		number.iscToLocaleString()
// Customizeable version of the <code>toLocaleString()</code> method for numbers.
// Called by <code>isc.iscToLocaleString()</code>.
// Uses the formatter set by Number.setStandardLocaleStringFormatter(), or at the instance 
// level by number.setLocaleStringFormatter()
//
//		@group	stringProcessing
//
//		@return				(string)	formatted number as a string
//<
iscToLocaleString : function () {
	return this[this.localeStringFormatter]();
},
    
    
//>	@method		number.toFormattedString()
//			Allow use of a custom number formatter - can be passed in as a parameter, or set by
//			Number.setStandardFormatter()
//
//		@group	stringProcessing
//
//		@param	[formatter]	(string)	name of a Number function to use
//
//		@return				(string)	formatted number as a string
//<

toFormattedString : function (formatter) {
	return this[(formatter ? formatter : this.formatter)]();
},


localeProperties : {
    decimalSymbol : ".",
    groupingSymbol : ",",
    negativeSymbol : "-",
    currencySymbol : "$",
    negativeFormat : 1, // 1 = before, 2 = after, 3 = beforeSpace, 4 = afterSpace, 5 = parens
    groupingFormat : 1 // 0 = none; 1 = 123,456,789; 2 = 12,34,56,789
},


_jsDecimalSymbol : ".",

//>	@method toLocalizedString()
//  Format this number for readability, with:
//  <ul>
//      <li>separators between three-digit groups</li>
//      <li>optional fixed decimal precision (so decimal points align on right-aligned numbers)</li>
//      <li>localized decimal, grouping, and negative symbols</li>
//  </ul>
//  Decimal symbol, grouping symbol, and negative symbol will normally come from
//  SmartClient locale settings (which may come from either client OS or application locale
//  settings), but they are also supported as arguments for mixed-format applications
//  (eg normalize all currency to US format, but use the current locale format for other numbers).
//  @param  [decimalPrecision]    (number)
//  @param  [decimalSymbol]    (string)
//  @param  [groupingSymbol]    (string)
//  @param  [negativeSymbol]    (string)
//  @return (string)    formatted number
//  @visibility internal
//<

toLocalizedString : function(decimalPrecision, decimalSymbol, groupingSymbol, negativeSymbol) {
    var absNum = Math.abs(this), // remove sign for now; deal with it at the very end of this method
        wholeNum = Math.floor(absNum), // whole part of the number (no decimal)
        wholeString, // string representation of whole part, before formatting
        decimalString, // string representation of decimal part, after formatting (padding)
        wholeChunks = []; // chunks of the whole number, based on 3-digit groupings
    
    // decimal part - doing this first because this code may round the whole part
    if (decimalPrecision) {
        // decimalPrecision specified and > 0, so
        // round/pad the decimal part to the specified number of digits
        var decimalNum = Math.round( (absNum-wholeNum) * Math.pow(10,decimalPrecision) );
        decimalString = decimalNum.stringify(decimalPrecision); // NOTE: stringify() could use a better name
    } else if (decimalPrecision == 0) {
        // decimalPrecision of 0 explicitly specified, so
        // round the whole number and drop the decimal part entirely
        wholeNum = Math.round(absNum);
    } else {
        // decimalPrecision not specified, so
        // show the decimal part iff there is one
        if (absNum-wholeNum > 0) {
//  PRECISION ERROR - the next line of code introduces noise that makes a very long decimal part,
//  e.g. 1.1 becomes 1.10000000000000009 - what causes this? some int to float conversion?
//            decimalString = (absNum-wholeNum).toString().substring(2); // drops the leading "0."
//  So using this alternate approach - just split the toString() on the decimal point
//  and take the decimal part
            decimalString = absNum.toString().split(this._jsDecimalSymbol)[1];
        }
    }

    // whole part - slice it into chunks to be joined with grouping symbols
    wholeString = wholeNum.toString();
    var wholeLength = wholeString.length;
    var tripletCount = Math.floor(wholeLength/3); // number of complete chunks of 3 digits
    if (wholeLength%3) {
        // start with the incomplete chunk (first 1 or 2 digits) if any
        wholeChunks[0] = wholeString.substr(0, wholeLength%3);
    }
    for (var i=0; i<tripletCount; i++) {
        // then slice out each chunk of 3 digits
        wholeChunks[wholeChunks.length] = wholeString.substr(wholeLength%3 + i*3, 3);
    }
    
    // assembly - join the chunks of the whole part with grouping symbols, and glue together
    // the whole part, decimal symbol, decimal part, and negative sign as appropriate
    var outputString = wholeChunks.join(groupingSymbol || this.localeProperties.groupingSymbol);
    if (decimalString) outputString = outputString + (decimalSymbol || this.localeProperties.decimalSymbol) + decimalString;
    if (this < 0) outputString = (negativeSymbol || this.localeProperties.negativeSymbol) + outputString;
    return outputString;
},



toUSString : function(decimalPrecision) {
    return this.toLocalizedString(decimalPrecision);
},
toUSDollarString : function(decimalPrecision) {
    return this.localeProperties.currencySymbol + this.toLocalizedString(decimalPrecision);
}

}) // end addProperties(Number.prototype) for localizable number formatter

isc.defineClass("Format");

isc.Format.addClassMethods({
    toUSString : function (theNum, decimalPrecision) { 
        if (!isc.isA.Number(theNum)) return theNum;
        return theNum.toUSString(decimalPrecision) 
    },
    toUSDollarString : function (theNum, decimalPrecision) { 
        if (!isc.isA.Number(theNum)) return theNum;
        return theNum.toUSDollarString(decimalPrecision) 
    },
    toCurrencyString : function (theNum, currencyChar, decimalChar, 
                                 padDecimal, currencyCharLast) {
        if (!isc.isA.Number(theNum)) return theNum;
        return theNum.toCurrencyString(currencyChar, decimalChar, 
                                       padDecimal, currencyCharLast);
    }
})

