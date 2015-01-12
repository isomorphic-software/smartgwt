package com.smartgwt.client.util;

//credit Fred Sauer. The original code comes from gwt-log 
public class LogUtil {

    // The SC Framework already installs an onerror() handler for browsers that support
    // the error object in onerror(), and this is sufficient for reporting in both
    // production and development modes of GWT.  So only install a handler here if onerror()
    // is not supported by the framework as the standard means of error reporting.
    public static native void setJSNIErrorHandler() /*-{
        if (!$wnd.isc.Log.supportsOnError && !$wnd.isc.Log.fallThroughToOnError) {
            var oldOnError = $wnd.onerror;
            $wnd.onerror = function(msg, url, line, column) {
                var result, oldResult;
                try {
                    result = @com.smartgwt.client.util.LogUtil::handleOnError(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)(msg, url, line, column);
                } finally {
                    oldResult = oldOnError && oldOnError(msg, url, line, column);
                }
                if (result    != null) return result;
                if (oldResult != null) return oldResult;
            };
        }
        if (window != $wnd && window.onerror == null) {
            window.onerror = $wnd.onerror;
        }
    }-*/;

    // There's No need to attempt to handle an error argument here as this API is only called
    // for those browsers that don't report errors in the SC Framework using onerror(), which
    // are precisely those browsers that don't pass the error argument.
    private static boolean handleOnError(String msg, String url, int line, Integer column) {
        String message = "Uncaught JavaScript exception: " + msg + " in " + url + ", line " + line;
        if (column != null) message += ", column " + column;
        SC.logWarn(message);
        return true;
    }

    public static native void addSGWTLoggerCategories() /*-{

        var defaultCategories = $wnd.isc.DebugTarget.getPrototype().DEFAULT_CATEGORIES;

        var sgwtCategories = new $wnd.Array(
            {name: "configProperties", predecessor: "loadTime",
             description: "Tracks and alerts when config properties are applied incorrectly"}
        );

        for (var i = 0; i < sgwtCategories.length; i = j) {
            var currentCategories = new $wnd.Array(),
                predecessor = sgwtCategories[i].predecessor;
            for (var j = i; j < sgwtCategories.length; j++) {
                if (j > i && sgwtCategories[j].predecessor != predecessor &&
                             sgwtCategories[j].predecessor != null) break;
                currentCategories.add(sgwtCategories[j]);
            }
            var position = defaultCategories.findIndex("name", predecessor);
            if (position >= 0) defaultCategories.addListAt(currentCategories, position + 1);
            else               defaultCategories.addList  (currentCategories);
        }
            
    }-*/;
}
