
package com.smartgwt.client.docs;

/**
 * <h3>Converting JavaScript objects to Java</h3>
 * Converting between native JavaScript objects and GWT Java objects is something the Smart GWT
 * framework needs to do very frequently (see also {@link com.smartgwt.client.docs.JavaToJavaScriptConversion}).
 * It is less common for application code to do such conversions, but the need can arise.  The 
 * {@link com.smartgwt.client.util.JSOHelper} class contains many utility methods for 
 * sophisticated conversion from native JS objects to GWT Java objects.  This article describes 
 * the common rules used when such conversions are run.<ul>
 * <li>Conversion is recursive; nested JavaScript objects and arrays will have their members converted as well</li>
 * <li>Circular references (where an object is referred to by its own children, grandchildren, etc) are <b>not</b>
 *     tolerated.  If you try to convert a JS object that contains circular references, your program will crash</li>
 * <li>This general prohibition of circular references includes native browser objects such as HTML elements 
 *     retrieved by the <code>getElementById()</code> API, amd common objects like <code>window</code> and the JSNI 
 *     <code>$wnd</code> object.  These DOM elements contain references to both parent and children, which are 
 *     inherently circular</li>
 * <li>null values, including <code>undefined</code>, are returned as null</li>
 * <li>JavaScript strings are returned as Java <code>String</code>s</li>
 * <li>JavaScript numbers are returned as<ul>
 *   <li>Java <code>Double</code>s if the number contains a decimal point, else</li>
 *   <li>Java <code>Integer</code>s if the number is in the range of an Integer (between -2147483648 and 2147483647 inclusive), else</li>
 *   <li>Java <code>Long</code>s</li></ul></li>
 * <li>JavaScript dates are returned as <code>java.util.Date</code>s</li>
 * <li>JavaScript arrays are converted by converting each array element according to the other rules described here, and then
 *     converting the results into either a Java <code>Object[]</code> or a <code>java.util.ArrayList</code>, depending on the 
 *     value of the "listAsArray" parameter (an array if that param is true, an <code>ArrayList</code> if it is false)</li>
 * <li>JavaScript objects are converted as follows:<ul>
 *   <li>If the GWT condition "<code>object instanceof JavaScriptObject</code>" is true, the object itself is returned</li>
 *   <li>If the object has a "_constructor" property set to "DateRange" convert to {@link com.smartgwt.client.data.DateRange}</li>
 *   <li>If the object has a "_constructor" property set to "RelativeDate" convert to {@link com.smartgwt.client.data.RelativeDate}</li>
 *   <li>If the object has a "__ref" property, return the value of that property (because this is a reference to the corresponding GWT object)</li>
 *   <li>If the SmartClient call "<code>isc.isA.Canvas(object)</code>" returns true, return the result of calling 
 *       {@link com.smartgwt.client.widgets.Canvas#getById(java.lang.String)}.  This will result in a Smart GWT Java object
 *       equivalent to the SmartClient Canvas - for example a SmartClient <code>ListGrid</code> will be returned as a 
 *       {@link com.smartgwt.client.widgets.grid.ListGrid}</li>
 *   <li>If the object has a "name" property and a "form" property such that <code>isc.isA.DynamicForm(object.form)</code> is true:<ul>
 *     <li>Create a DynamicForm object by passing the object's "form" property as a parameter to 
 *         {@link com.smartgwt.client.widgets.form.DynamicForm#getOrCreateRef(JavaScriptObject)}</li>
 *     <li>Return the result of calling getField() on that form, passing in the object's "name" property</li>
 *     <li>This process means that SmartClient FormItems are returned as equivalent Smart GWT objects (subclasses of 
 *         {@link com.smartgwt.client.widgets.form.fields.FormItem})</ul></li>
 *   <li>If the SmartClient call "<code>isc.isAn.Instance(object)</code>" returns true and the object has a <code>getClassName()</code>
 *       method, returns the result of passing the object as a parameter to 
 *       {@link com.smartgwt.client.util.ObjectFactory#createInstance(JavaScriptObject)}</li>
 *   <li>If none of the above conversions apply, the JavaScript object will be converted to a Java <code>Map</code> by running 
 *       each property of the JavaScript object through the conversion process.  Note, if SmartClient detects that the object 
 *       is the JS form of a {@link com.smartgwt.client.widgets.tree.TreeNode} (which is done by checking for the presence of an 
 *       internal-only property), the SmartClient method <code>isc.Tree.getCleanNodeData()</code> is called on it before conversion 
 *       starts; this obtains a clean version of the node data, free of any additional properties scribbled on by the Tree</li>
 *   </ul></li>
 * </ul>
 */
public interface JavaScriptToJavaConversion {
}
