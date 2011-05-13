package com.smartgwt.client.util;

import java.util.HashSet;

public class IDManager {


    // Test for unique IDs:
    // We need to ensure that IDs
    // - are valid JS identifiers (no dots, no spaces)
    // - do not collide with any assigned IDs on the page (EG ID of a live SmartClient component that was
    //   instantiated outside of SmartGWT)
    // - do not collide with any assigned IDs within SmartGWT components, even if these have not yet been
    //   instantiated as live JavaScript objects.
    // We therefore check for window[ID] being already assigned and we track SGWT IDs that haven't yet been
    // assigned to live JS objects in the global scope by maintaining a hashSet of assigned IDs
    private static HashSet<String> assignedIDs = new HashSet<String>();
    public static void isValidID(String id) {
        
        assert id.indexOf(".") == -1 : "Invalid ID. Cannot use \".\" in identifier.";
        assert id.indexOf(" ") == -1 : "Invalid ID. Cannot use spaces in identifier.";
        
        if (assignedIDs.contains(id)) {
            SC.logWarn("Specified ID:" + id + " collides with the ID for an existing SmartGWT component or object.");
            return;
        }
        // If it's an existing JS object it's likely another SmartClient component created outside of Java, but
        // it could be a native JS keyword ("window", "parent" etc) or something else defined in JS scope.
        // The method will provide more detail in a logged warning.
        checkUniqueJavascriptIdentifier(id);
    }
    private static native void checkUniqueJavascriptIdentifier(String id) /*-{
        if ($wnd[id] != null) {
            $wnd.isc.logWarn("Specified ID:" + id + " collides with the ID of an existing object '" + $wnd[id] + "'.");
        }
    }-*/;
    
    public static void registerID(String id) {
        isValidID(id);
        assignedIDs.add(id);
    }
    public static void unregisterID(String id) {
        assignedIDs.remove(id);
    }
}
