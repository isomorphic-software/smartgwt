
package com.smartgwt.client.docs;

/**
 * <h3>Float vs Double</h3>
 * In GWT code, you should generally use Java Doubles rather than Java Float values. <p> In the
 * current implementation of GWT, Float and Double types are both represented as JavaScript
 * Number, so there is no storage or performance advantage to using Float over Double, and double
 * provides higher precision. <p> In addition, because GWT uses true Java Floats <i>in development
 * mode</i> but uses higher precision JavaScript Number values in compiled mode, math operations
 * on Float can differ between development mode vs compiled mode. <p> The SmartGWT field type
 * "float" is represented as a JavaScript Number, the same storage GWT uses for Doubles, so in any
 * code that accesses or manipulates values stored in a field of type "float", use
 * Record.getAttributeAsDouble(), DoubleItem.getValueAsDouble(), and similar APIs to avoid being
 * tripped up by GWT's different behavior in development mode.
 */
public interface GwtFloatVsDouble {
}
