
package com.smartgwt.client.docs;

/**
 * <h3>Converting GWT Java objects to JavaScript</h3>
 * Converting between native JavaScript objects and GWT Java objects is something the Smart GWT
 * framework needs to do very frequently (see also {@link com.smartgwt.client.docs.JavaScriptToJavaConversion}).
 * It is less common for application code to do such conversions, but the need can arise.  The 
 * {@link com.smartgwt.client.util.JSOHelper} class contains many utility methods for 
 * sophisticated conversion from GWT Java objects to native JS objects.  This article describes 
 * the common rules used when such conversions are run.<ul>
 * <ul>
 * <li>Conversion is recursive; nested Java Maps, Collections and arrays will have their members converted as well</li>
 * <li>Circular references (where an object is referred to by its own children, grandchildren, etc) are <b>not</b>
 *     tolerated.  If you try to convert a Java object that contains circular references, your program will crash</li>
 * <li>null is returned as null</li>
 * <li>Strings are converted to JavaScript Strings</li>
 * <li>Booleans are converted to JavaScript booleans</li>
 * <li>Numeric data types - Integer, Long, Float, Double and all other Number subclasses - are converted to JavaScript
 * <code>Number</code>s.  Note that it is not possible to accurately represent values with an
 * absolute value greater than 9,007,199,254,740,992 in a JavaScript <code>Number</code> (some people find it 
 * easier to remember "15 decimal digits", from the rounded-down value 999,999,999,999,999).  This is
 * not a problem for most Java numeric types, but Java <code>Long</code>s can accurately represent values 
 * larger than this; converting such a large value to a JavaScript <code>Number</code> introduces a loss 
 * of precision in the least significant digits.  For example, the Java value 
 * <code>Long.MAX_VALUE</code> is 9223372036854775807.  This value will be represented as 9223372036854776000 
 * when converted to a JavaScript <code>Number</code></li>
 * <li>{@link com.smartgwt.client.types.ValueEnum}s are converted to the string representation 
 *     obtained by calling their <code>getValue()</code> method</li>
 * <li><code>java.util.Date</code>s (and subclasses) are converted as JavaScript <code>Date</code>s</li>
 * <li>{@link com.smartgwt.client.data.RelativeDate}s are converted to the string representation 
 *     obtained by calling their <code>getValue()</code> method</li>
 * <li>Java arrays are converted to JavaScript arrays, with members recursively converted to the
 * 	   equivalent JavaScript type using the rules described in this article</li>
 * <li>Java Collections (Lists and Sets) and Iterators are converted to JavaScript arrays, with members 
 *     recursively converted to the equivalent JavaScript object using the rules described in this article</li>
 * <li>Java Maps are converted to JavaScript Objects with each key mapped to a property on the object.
 * 		Property values are recursively converted to the equivalent JavaScript object using the rules described 
 *      in this article</li>
 * </ul>
 * Other Java Objects, including POJOs, instances of {@link com.smartgwt.client.data.Record} and its subclasses,
 * and instances of {@link com.smartgwt.client.widgets.Canvas} and {@link com.smartgwt.client.widgets.form.fields.FormItem} 
 * are stored on the underlying data object unconverted. Developers can retrieve such values via 
 * {@link com.smartgwt.client.core.DataClass#getAttributeAsObject(String)}.
*/
public interface JavaToJavaScriptConversion {
}
