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

 

//--------------------------------------------------------------------------------------------------
// partial addProperties support
//--------------------------------------------------------------------------------------------------
// define addProperties(), but don't redefine it if FileLoader was loaded after ISC
// Note: copied partially from Object.js
if (isc.addProperties == null) {
    isc.addGlobal("addProperties", function (destination, source) {
        for (var propName in source)
            destination[propName] = source[propName];
        return destination;
    });
}

isc.addGlobal("defineStandaloneClass", function (className, classObj) { 
    if (isc[className]) return;  // don't redefine

    isc.addGlobal(className, classObj);
    isc.addProperties(classObj, {
        _saClassName: className,

        fireSimpleCallback : function (callback) {
            callback.method.apply(callback.target ? callback.target : window, 
                                  callback.args ? callback.args : []);  
        },

        // Logging - log to a special array that gets dumped into the the DevConsole logs by
        // Log.js.  Timestamps will be accurate.  If you're not loading Core, you can use
        // getLogs() to get the logs.
        logMessage : function (priority, message, category) {
            if (isc.Log) {
                isc.Log.logMessage(priority, message, category);
                return;
            }
            if (!isc._preLog) isc._preLog = [];
            isc._preLog[isc._preLog.length] = {
                priority: priority,
                message: message,
                category: category,
                timestamp: new Date()
            };
        },
        

        // NOTE: log priorities copied from Log.js
        logWarn : function (message) {
            this.logMessage(3, message, this._saClassName);
        },
        logInfo : function (message) {
            this.logMessage(4, message, this._saClassName);
        },
        logDebug : function (message) {
            this.logMessage(5, message, this._saClassName);
        },
        // end logging

        //--------------------------------------------------------------------------------------------------
        // IsA support
        //--------------------------------------------------------------------------------------------------
        // Note: can't provide this as isc.isA because in Core.js we load Object before isA and Object
        // has conditional logic that uses isA
        isA : {
            String : function (object) {
                if (object == null) return false;
                if (object.constructor && object.constructor.__nativeType != null) {
                    return object.constructor.__nativeType == 4;
                }
                return typeof object == "string";
            }
        }

    }); 
    
    // alias
    classObj.isAn = classObj.isA;

    return classObj; 
});
    
