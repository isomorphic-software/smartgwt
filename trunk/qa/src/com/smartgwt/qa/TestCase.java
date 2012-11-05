/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.qa;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Arrays;

// A class that wraps isc.TestCase, so that it is possible to write tests in
// Java but have them integrate with the SmartClient QA framework. 
//
// See TestRunner.java for context (and the tests for examples). 
public abstract class TestCase {
    private JavaScriptObject jsObj;
    
    public JavaScriptObject getJsObj () {
        return jsObj;
    }

    public TestCase (String description) {
        jsObj = create(description);
    }

    private native JavaScriptObject create (String description) /*-{
        var self = this;                                                          
        return $wnd.isc.TestCase.create({
            description: description,
            doTest : function (runner, test) {
                try {
                    self.@com.smartgwt.qa.TestCase::doTest()();
                }
                catch (e) {
                    test.setResult(false, e.toString());
                }
            }
        });
    }-*/;

    // Subclasses (likely anonymous) implement this to actually do the test
    public abstract void doTest ();

    // You must call setResult, or the test will time out
    public native void setResult (boolean result, String reason) /*-{
        var jsObj = this.@com.smartgwt.qa.TestCase::jsObj;
        jsObj.setResult(result, reason);
    }-*/;

    public void setResult (boolean result) {
        setResult(result, null);
    }

    // This one is to indicate that we're done, and have succeeded if no
    // assertion has indicated a problem. So, it's a convenience method.
    public native void setResult () /*-{
        var jsObj = this.@com.smartgwt.qa.TestCase::jsObj;
        if (jsObj.result == null) jsObj.setResult(true);
    }-*/;

    public String echo (Object object) {
        if (object == null) {
            return "null";
        } else {
            return object.toString();
        }
    }

    // Various assertions that you can call from doTest.  You can all several
    // assertions independently, since setResult is only called upon failure.
    // Then, you can call setResult() without arguments at the end of the test,
    // which will succeed if no assertion has failed.
    public void assertTrue (boolean assertion, String reason) {
        if (!assertion) this.setResult(false, reason);
    }

    public void assertFalse (boolean assertion, String reason) {
        assertTrue(!assertion, reason);
    }

    public void assertNotNull (Object object, String reason) {
        assertTrue(object != null, reason + " (unexpected null)");
    }

    public void assertNull (Object object, String reason) {
        assertTrue(object == null, reason + " (expected null: got " + echo(object) + ")");
    }

    public void assertEqual (Object object, Object expected, String reason) {
        // Overloading is based on declared compile-time types, so catch run-time type.
        if (object instanceof Object[] && expected instanceof Object[]) {
            assertEqual((Object[]) object, (Object[]) expected, reason);
        } else if (expected == null) {
            assertNull(object, reason);
        } else {
            assertTrue(expected.equals(object), reason + " (expected " + echo(expected) + ": got " + echo(object) + ")");
        }
    }

    public void assertEqual (Object[] array, Object[] expected, String reason) {
        if (expected == null) {
            assertNull(array, reason);
        } else {
            assertEqual(array.length, expected.length, reason + " (arrays should have same length)");
            for (int i = 0; i < array.length; i++) {
                assertEqual(array[i], expected[i], reason + " (array[" + String.valueOf(i) + "] doesn't match)");
            }
        }
    }

    public void assertContains (Object[] array, Object object, String reason) {
        if (array == null) {
            setResult(false, reason + " (unexpected null)");
        } else {
            assertTrue(Arrays.asList(array).contains(object), reason + " (expected " + echo(array) + " to contain " + echo(object) + ")");
        }
    }

    public void assertWithin (float object, float expected, float tolerance, String reason) {
        assertTrue(Math.abs(object - expected) < tolerance, reason + " (expected " + echo(expected) + ": got " + echo(object) + ")");
    }
    
    public void assertWithin (double object, double expected, double tolerance, String reason) {
        assertTrue(Math.abs(object - expected) < tolerance, reason + " (expected " + echo(expected) + ": got " + echo(object) + ")");
    }
}
