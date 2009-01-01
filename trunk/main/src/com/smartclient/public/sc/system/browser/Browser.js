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

 

// =================================================================================================
// IMPORTANT :If you update this file, also update FileLoader.js that has a subset of these checks
// =================================================================================================





//>	@object	Browser
// Object containing flags indicating basic attributes of the browser.
// @treeLocation Client Reference/Foundation
// @visibility external
//<
isc.addGlobal("Browser", {
	isSupported:false													
});

//>	@classAttr	Browser.isOpera		(boolean : ? : R)
//		Are we in Opera ?  
//		We don't support it, but need to explicitly reject it since its
//		 spoofs IE and Nav.
//<
isc.Browser.isOpera = (navigator.appName == "Opera" ||
					navigator.userAgent.indexOf("Opera") != -1);

//>	@classAttr	Browser.isNS (boolean : ? : R)
//		Are we in Netscape (including Navigator 4+, NS6 & 7, and Mozilla)
//      Note: Safari also reports itself as Netscape, so isNS is true for Safari.
//<
isc.Browser.isNS = (navigator.appName == "Netscape" && !isc.Browser.isOpera);	

//>	@classAttr	Browser.isIE		(boolean : ? : R)
//		Are we in Internet Explorer?
//<
isc.Browser.isIE = (navigator.appName == "Microsoft Internet Explorer"
					&& !isc.Browser.isOpera);

//>	@classAttr	Browser.isMSN		(boolean : ? : R)
//      Are we in the MSN browser (based on MSIE, so isIE will be true in this case)
//<
isc.Browser.isMSN = (isc.Browser.isIE && navigator.userAgent.indexOf("MSN") != -1);


//>	@classAttr Browser.minorVersion		(number : ? : R)
//		Browser version, with minor revision included (4.7, 5.5, etc).
//<
isc.Browser.minorVersion = parseFloat(isc.Browser.isIE ? 
                                  navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE")+5)
                                  : navigator.appVersion
    );


//>	@classAttr	Browser.version		(number : ? : R)
//		Browser major version number (integer: 4, 5, etc).
//<
isc.Browser.version = parseInt(isc.Browser.minorVersion);

// actually means IE6 or earlier, which requires radically different optimization techniques
isc.Browser.isIE6 = isc.Browser.isIE && isc.Browser.version <= 6;

//>	@classAttr	Browser.isMoz		(boolean : ? : R)
//		Are we in any Mozilla-derived browser, that is, a browser based on Netscape's Gecko 
//      engine? (includes Mozilla and Netscape 6+)
//<
// NOTE: must look for Gecko/ because Safari sends "(like Gecko)"
isc.Browser.isMoz = navigator.userAgent.indexOf("Gecko/") != -1;

//>	@classAttr	Browser.isCamino (boolean : false : R)
//  Are we in Mozilla Camino?
//<
isc.Browser.isCamino = (isc.Browser.isMoz && navigator.userAgent.indexOf("Camino/") != -1);

//>	@classAttr	Browser.caminoVersion (string : ? : R)
//		For Camino-based browsers, the Camino version number.  
//<
if (isc.Browser.isCamino) {
    // Camino Version is the last thing in the userAgent
    isc.Browser.caminoVersion = 
        navigator.userAgent.substring(navigator.userAgent.indexOf("Camino/") +7);
}



//>	@classAttr	Browser.isFirefox (boolean : false : R)
//  Are we in Mozilla Firefox?
//<
isc.Browser.isFirefox = (isc.Browser.isMoz && navigator.userAgent.indexOf("Firefox/") != -1);

if (isc.Browser.isFirefox) {
//>	@classAttr	Browser.firefoxVersion (string : ? : R)
//		For Firefox-based browsers, the Firefox version number.  
//          - 0.10.1    is Firefox PR 1
//      After this the version numbers reported match those in the about dialog
//          - 1.0       is Firefox 1.0
//          - 1.0.2     is Firefox 1.0.2
//          - 1.5.0.3   is Firefox 1.5.0.3
//<
    isc.Browser.firefoxVersion = 
        navigator.userAgent.substring(navigator.userAgent.indexOf("Firefox/")+ 8);
}

//>	@classAttr	Browser.geckoVersion (integer : ? : R)
//		For Gecko-based browsers, the Gecko version number.  
//      Looks like a datestamp: 
//          - 20011019 is Netscape 6.2
//          - 20020530 is Mozilla 1.0
//          - 20020823 is Netscape 7.0
//          - 20020826 is Mozilla 1.1
//          - 20021126 is Mozilla 1.2
//          - 20030312 is Mozilla 1.3
//          - 20030624 is Mozilla 1.4
//          - 20031007 is Mozilla 1.5
//          - 20031120 is Mozilla 1.5.1 (Mac only release) 
//          - 20040113 is Mozilla 1.6
//          - 20040616 is Mozilla 1.7
//          - 20040910 is Mozilla 1.73
//          - 20041001 is Mozilla Firefox PR1 (-- also see firefox version)
//          - 20041107 is Mozilla Firefox 1.0
//          - 20050915 is Mozilla Firefox 1.0.7
//          - 20051107 is Mozilla Firefox 1.5 RC2   
//          - 20051111 is Mozilla Firefox 1.5 final
//          - 20060426 is Mozilla Firefox 1.5.0.3
//          - 20061010 is Mozilla Firefox 2.0
//          - 20070321 is Netscape 8.1.3 - LIES - really based on Firefox 1.0 codebase
//          - 20071109 is Firefox 3.0 beta 1
//          - 20080529 is Firefox 3.0
//<

if (isc.Browser.isMoz) {
    isc.Browser._geckoVIndex = navigator.userAgent.indexOf("Gecko/") + 6;
    // The 'parseInt' actually means we could just grab everything from the
    // end of "Gecko/" on, as we know that even if the gecko version is followed
    // by something, there will be a space before the next part of the UA string
    // However, we know the length, so just use it
    isc.Browser.geckoVersion = parseInt(
        navigator.userAgent.substring(
            isc.Browser._geckoVIndex, isc.Browser._geckoVIndex+8
        )
    );

    
    
    if (isc.Browser.isFirefox) {
        // clamp 1.0.x series to last known pre 1.5 version (1.0.7)
        if (isc.Browser.firefoxVersion.match(/^1\.0/)) isc.Browser.geckoVersion = 20050915;
        // clamp 2.0.x series to one day before near-final FF3 beta
        else if (isc.Browser.firefoxVersion.match(/^2\.0/)) isc.Browser.geckoVersion = 20071108;
    }
}

// Doctypes
//  Are we in strict standards mode.  This applies to IE6+ and all Moz 1.0+.
//
//  In strict mode, browsers attempt to behave in a more standards-compliant manner.  Of course,
//  standards interpretation varies pretty drastically between browser makers, so this is in effect
//  just another fairly arbitrary set of behaviors which continues to vary across browser makers,
//  and now also across modes within the same browser.
//
// We have essentially 3 cases to consider:
// - BackCompat / Quirks mode. This is the rendering used if docType is not specified, or if
//   specified as 'Transitional' or 'Frameset' / with no URI 
//   (EG: <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">)
//   This is the default mode.
// - Strict. Completely standards complient.
//   Triggered by 
//   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
// - "Almost Strict" (AKA Transitional). 
//   In IE this matches Strict mode completely. 
//   In Moz it matches strict mode except for rendering of images within tables - see
//   http://developer.mozilla.org/en/docs/Images%2C_Tables%2C_and_Mysterious_Gaps
//   Triggered "transitional" doctype with URI
//   Reports document.compatMode as "CSS1Compat" 
// - http://developer.mozilla.org/en/docs/Gecko%27s_%22Almost_Standards%22_Mode
// - http://www.htmlhelp.com/reference/html40/html/doctype.html
// - http://developer.mozilla.org/en/docs/Mozilla%27s_DOCTYPE_sniffing

//> @classAttr  Browser.isStrict    (boolean : ? : R)
//  Are we in strict standards mode.
//<
// HACK: Netscape6 does not report document.compatMode, so we can't tell that a DOCTYPE has been
// specified, but Netscape6 IS affected by a DOCTYPE.  So, in Netscape6, assume we're always in
// strict mode.  At the moment (3/30/03) all strict mode workarounds have identical behavior in
// normal mode.

isc.Browser.isStrict = document.compatMode == "CSS1Compat";
if (isc.Browser.isStrict && isc.Browser.isMoz) {

    isc.Browser._docTypePublicID = document.doctype.publicId;
    isc.Browser._docTypeSystemID = document.doctype.systemId;

    // See http://developer.mozilla.org/en/docs/Mozilla%27s_DOCTYPE_sniffing
    isc.Browser.isTransitional = isc.Browser._docTypePublicID.indexOf("Transitional") != -1 ||
                                 isc.Browser._docTypePublicID.indexOf("Frameset") != -1;
}

//> @classAttr Browser.isIE8Strict (boolean : ? : R)
// Are we in IE8 mode.
// <P>
// In IE8 (at least beta2), setting DOCTYPE is not enough to actually trigger IE8 mode, you
// must actually add a meta tag to use IE8 mode:
// 
//    &lt;meta http-equiv="X-UA-Compatible" content="IE=8" /&gt;
//
// If this tag is present, the document is in strict mode even if no DOCTYPE was present.
// The presence of this tag can be detected as document.documentMode being 8 rather than 7.
// document.compatMode still reports "CSS1Compat" as with earlier IE.
// <P>
// Note that IE8 beta2 reports itself as IE7 via the userAgent String and we currently detect
// it as version 7.
//<
isc.Browser.isIE8Strict = isc.Browser.isIE && isc.Browser.isStrict && 
                            document.documentMode > 7;


//> @classAttr  Browser.isBorderBox    (boolean : ? : R)
// Do divs render out with "border-box" sizing by default.
//<
// See comments in Canvas.adjustHandleSize() for a discussion of border-box vs content-box sizing
isc.Browser.isBorderBox = isc.Browser.isIE && !isc.Browser.isStrict;

//> @classAttr  Browser.isAIR    (boolean : ? : R)
// Is this application running in the Adobe AIR environment?
//<
isc.Browser.isAIR = (navigator.userAgent.indexOf("AdobeAIR") != -1);

//> @classAttr  Browser.AIRVersion (string : ? : R)
// If this application running in the Adobe AIR environment, what version of AIR is
// running. Will be a string, like "1.0".
//<
isc.Browser.AIRVersion = (isc.Browser.isAIR ? navigator.userAgent.substring(navigator.userAgent.indexOf("AdobeAir/") + 9) : null);

//>	@classAttr	Browser.isSafari (boolean : ? : R)
// Are we in Apple's "Safari" browser? Note that this property will also be set for other
// WebKit based browsers (such as Google Chrome).
//<
// As far as we know all "true" Safari implementations idenify themselves in the userAgent with
// the string "Safari".
// However the GWT hosted mode browser on OSX is also based on apple webkit and should be treated
// like Safari but is not a Safari browser and doesn't identify itself as such in the useragent
// Reported UserAgent:
//  Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_5; en-us) AppleWebKit/525.18 (KHTML, like Gecko)
isc.Browser.isSafari = isc.Browser.isAIR || navigator.userAgent.indexOf("Safari") != -1 ||
                        navigator.userAgent.indexOf("AppleWebKit") != -1;


//> @classAttr Browser.isChrome (boolean : ? : R)
// Are we in the Google Chrome browser?
//<
// Behaves like Safari in most ways
isc.Browser.isChrome = isc.Browser.isSafari && (navigator.userAgent.indexOf("Chrome/") != -1);

//>	@classAttr	Browser.safariVersion (number : ? : R)
//		in Safari, what is is the reported version number

if (isc.Browser.isSafari) {

    if (isc.Browser.isAIR) {
        
        isc.Browser.safariVersion = 530;
    } else {
        if (navigator.userAgent.indexOf("Safari/") != -1) {
            isc.Browser.rawSafariVersion = navigator.userAgent.substring(
                        navigator.userAgent.indexOf("Safari/") + 7
            );
        } else if (navigator.userAgent.indexOf("AppleWebKit/") != -1) {
            isc.Browser.rawSafariVersion = navigator.userAgent.substring(
                        navigator.userAgent.indexOf("AppleWebKit/") + 12
            );
          
        } else {
            isc.Browser.rawSafariVersion = "530" 
        }
        
        
        
        isc.Browser.safariVersion = (function () {
            var rawVersion = isc.Browser.rawSafariVersion,
                currentDot = rawVersion.indexOf(".");
            
            if (currentDot == -1) return parseInt(rawVersion);
            var version = rawVersion.substring(0,currentDot+1),
                nextDot;
            while (currentDot != -1) {
                // Check AFTER the dot
                currentDot += 1;
                nextDot = rawVersion.indexOf(".", currentDot);
                version += rawVersion.substring(currentDot, 
                                                (nextDot == -1 ? rawVersion.length: nextDot));
                currentDot = nextDot;
            }
            return parseFloat(version);
        })();
    }    
}

//>	@classAttr	Browser.isWin		(boolean : ? : R)
//		Is this a Windows computer ?
//<
isc.Browser.isWin = navigator.platform.toLowerCase().indexOf("win") > -1;
// NT 5.0 is Win2k, NT5.0.1 is Win2k SP1
isc.Browser.isWin2k = navigator.userAgent.match(/NT 5.01?/) != null;

//>	@classAttr	Browser.isMac		(boolean : ? : R)
//		Is this a Macintosh computer ?
//<
isc.Browser.isMac = navigator.platform.toLowerCase().indexOf("mac") > -1;	

//>	@classAttr	Browser.isUnix		(boolean : ? : R)
//		Is this a Unix computer ?
//<
isc.Browser.isUnix = (!isc.Browser.isMac &&! isc.Browser.isWin);

//>	@classAttr	Browser.lineFeed	(string : ? : RA)
//		Linefeed for this platform
//<
isc.Browser.lineFeed = (isc.Browser.isWin ? "\r\n" : "\r");

//>	@classAttr	Browser._supportsMethodTimeout	(string : ? : RA)
//		setTimeout() requires text string parameter in MacIE or IE 4
//<
isc.Browser._supportsMethodTimeout = false;//!(isc.Browser.isIE && (isc.Browser.isMac || isc.Browser.version == 4));	

//>	@classAttr	Browser.isDOM (string : ? : RA)
//		Whether this is a DOM-compliant browser.  Indicates general compliance with DOM standards,
//      not perfect compliance.
//<
isc.Browser.isDOM = (isc.Browser.isMoz || isc.Browser.isOpera || 
                     isc.Browser.isSafari || (isc.Browser.isIE && isc.Browser.version >= 5));

//> @classAttr Browser.isSupported (boolean : varies by browser : R)
// Whether SmartClient supports the current browser.
// <P>
// Note that this flag will only be available on browsers that at least support basic
// JavaScript.
// 
// @visibility external
//<
isc.Browser.isSupported = (
	// we support all versions of IE 5.5 and greater on Windows only
    (isc.Browser.isIE && isc.Browser.minorVersion >= 5.5 && isc.Browser.isWin) ||
	// Mozilla and Netscape 6, all platforms
    isc.Browser.isMoz ||
    isc.Browser.isOpera ||
    // Safari (only available on Mac)
    isc.Browser.isSafari ||
    isc.Browser.isAIR
);
