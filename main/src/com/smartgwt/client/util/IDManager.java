package com.smartgwt.client.util;

import java.util.HashMap;

import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.RefDataClass;

import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.layout.SectionStackSection;

// ID Management -------------------------------------------------------------------------------
//
// The goal of ID Management is to ensure that at most a single SGWT object is assigned the
// same ID, and that if a SC object also uses that ID, it can only be the underlying/wrapped
// SC object for that SGWT object.  The overall system is designed so that:
//
// - When a SGWT object is created with new, so that there is no expected SC object with the
//   same ID, then we verify that and warn of a collision if either a SGWT or SC object already
//   has that ID.  Any collision will cause us to destroy() the old SGWT or SC object before
//   registering the new one.  The ID is auto-generated unless specified in the constructor,
//   and registered against the SGWT object - registration lasts until destroy() is called on
//   that object.
// 
// - A SC API is used to provide the SGWT auto-generated IDs, so SC will not try to use them,
//   but the SC side will have no knowledge of any manually set SGWT IDs before the underlying
//   SC object is created.  In this case, a collision will be detected only when the SC
//   object underlying the SGWT widget is created (say because it's drawn).
//
// - SC objects created by the SC JS Framework that have no SGWT presence will not be registered
//   in the SGWT ID Management table, but will still trigger a collision if an attempt is
//   made to register a SGWT widget with the same ID.
//
// - When a SGWT object is created from a live SC object, there is obviously no need to check
//   the SC side for ID collisions, but we still check for collisions against other SGWT
//   objects.  In this case the ID is provided by the SC object and is not generated or
//   settable.  -
//
// - If setID() is called on a SGWT object, we perform the same collision check as if new
//   had been called for that ID, and change the registered ID for that object.  If setID()
//   is called for a SGWT object that already has an underlying SC JS object, then
//   an exception is thrown as this is illegal.
//
//   When destroy() is called on either the SC or SGWT side, both objects will be destroy()ed
//   if both exist - SC objects can be created outside of SGWT, and SGWT objects may not have
//   created their underlying SC objects at the point when destroy is called.  Destroying a
//   SGWT object unregisters its ID and destroying a SC object removes the window[ID] binding.
//   If the ID is auto-generated, calling destroy() (whether both objects exist or just one on
//   the SC or SGWT side) will return it to the common free pool of auto-generated IDs.

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

    public static void validateID(String id, boolean skipUniqueJSIdentifierCheck) {
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
