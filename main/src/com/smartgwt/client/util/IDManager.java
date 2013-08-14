package com.smartgwt.client.util;

import java.util.HashMap;

import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.RefDataClass;

import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class IDManager {

    // Test for unique IDs:
    // We need to ensure that IDs
    // - are valid JS identifiers (no dots, no spaces)
    // - do not collide with any assigned IDs on the page (EG ID of a live SmartClient
    //   component that was instantiated outside of SmartGWT)
    // - do not collide with any assigned IDs within SmartGWT components, even if these have
    //   not yet been instantiated as live JavaScript objects.
    //
    // We therefore check for window[ID] being already assigned and we track SGWT IDs that
    // haven't yet been assigned to live JS objects in the global scope by maintaining a
    // hashSet of assigned IDs

    private static HashMap<String, Object> assignedIDs = new HashMap<String, Object>();

    private static void validateID(String id, boolean skipUniqueJSIdentifierCheck) {
        assert id.matches("[a-zA-Z_$][0-9a-zA-Z_$]*") : "Invalid ID : " + id +
            ". Valid ID's must meet the following pattern [a-zA-Z_$][0-9a-zA-Z_$]*";
        
        Object value = assignedIDs.get(id);
        if (value != null) {
            SC.logWarn("Specified ID: " + id + " collides with the ID for an existing " +
                       "SmartGWT component or object. The existing object will be " +
                       "destroyed and the ID bound to the new object.");

            // The type dispatch could be eliminated by having all three of these
            // classes implement a common interface, but probably not worth it yet.
            if      (value instanceof BaseWidget)     ((BaseWidget) value).destroy();
            else if (value instanceof BaseClass)       ((BaseClass) value).destroy();
            assignedIDs.remove(id);
        }

        if (skipUniqueJSIdentifierCheck) return;

        String collision = checkUniqueJavascriptIdentifier(id);
        if (collision != null) {
            SC.logWarn("Specified ID: " + id + " collides with the ID for an existing " +
                       collision + " The existing object will be destroyed and the ID " +
                       "bound to the new object.");
            destroy(id);
        }
    }

    // If it's an existing JS object it's likely another SmartClient component created outside
    // of Java, but it could be a native JS keyword ("window", "parent" etc) or something else
    // defined in JS scope.
    private static native String checkUniqueJavascriptIdentifier(String id) /*-{
        return $wnd[id] != null ? "object '" + $wnd[id] + "'." : null;
    }-*/;

    // Any SGWT component should have been cleaned up before this routine is called, so it's
    // designed to deal with SmartClient components created outside of Java.  In the case
    // of keywords, SmartClient will generate a proper warning; just avoid doing damage here.
    private static native void destroy(String id) /*-{
        var obj = $wnd[id];
        if (obj != null && obj.destroy) {
            delete obj.__sgwtDestroy;
            obj.destroy();
        } else if (!$wnd.isc.ClassFactory._reservedWords[id]) {
            try { $wnd[id] = null; } catch (e) {}
        }
    }-*/;

    
   public static void registerID(Object object, String id, 
                                  boolean skipUniqueJSIdentifierCheck) 
    {
        validateID(id, skipUniqueJSIdentifierCheck); 
        assignedIDs.put(id, object);
    }

    // For BaseClass and RefDataClass objects, registration is conditional,
    // so to simplify the code, it's not an error to blindly request removal, letting
    // the IDManager logic sort out whether anything has to be done.  For BaseWidget
    // class, registration is mandatory so if it's not found it's a problem.
    public static void unregisterID(BaseWidget widget, String id) {
        Object value = assignedIDs.get(id);
        if (value == widget) assignedIDs.remove(id);
        else {
            SC.logWarn("The SmartGWT component or object with ID: " + id + " can't be " +
                       "unregistered because another object has registered with the same ID!");
        }
    }
    public static void unregisterID(Object object, String id) {
        Object value = assignedIDs.get(id);
        if (value == object) assignedIDs.remove(id);
    }
}
