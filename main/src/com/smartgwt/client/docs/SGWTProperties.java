package com.smartgwt.client.docs;

/**
 * <h3>SGWTProperties</h3>
 * 
 * APIs such as {@link com.smartgwt.client.widgets.grid.ListGrid#setHeaderButtonProperties 
 * ListGrid.setHeaderButtonproperties()} or 
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#setDefaultProperties 
 * FormItem.setDefaultProperties()} are <i> properties APIs</i> - they can be passed a Canvas
 * or FormItem instance as a "properties object": a means of configuring an 
 * {@link AutoChildUsage AutoChild} or establishing new defaults for the class.
 * <P>
 * When calling a properties API:
 * <ul>
 * <li> all settings applied to the properties object are <i>copied</i> when the properties API
 * is called.  Subsequent changes to the properties object are ignored.
 * <li> the properties object is not a real widget; it's essentially just a type-safe API for
 * establishing default properties.  Only calls to simple Java Bean-style setters are generally
 * supported, and in the case of AutoChildren, event registrations 
 * (<code>add<i>Something</i>Handler()</code>).  It's invalid to 
 * {@link com.smartgwt.client.widgets.Canvas#draw()} a properties object, ask it to fetch data,
 * or in any other way treat it like a real widget.
 * <li> similarly you cannot take a live widget and pass it to a properties API.  For example,
 * you cannot take a Button that has already been drawn and pass it a properties API
 * <li> the properties object is not a live link to whatever AutoChild or other component is
 * configured by those properties.  For example, if you use 
 * <code>Window.changeAutoChildDefaults("header", headerProperties)</code> to affect the window
 * "header" AutoChild, you cannot later call 
 * {@link com.smartgwt.client.widgets.Canvas#setBorder Canvas.setBorder()} on the 
 * headerProperties object to affect the header border.  You would call 
 * {@link com.smartgwt.client.widgets.Window#getHeader Window.getHeader()} to get the live 
 * header object instead.
 * <li> it <i>is</i> valid for a Canvas-based properties object to be further modified and
 * passed to a second properties API on some other object, however it is <i>not</i> valid to do
 * this with a FormItem-based properties object or DataClass-based properties object (such as
 * {@link com.smartgwt.client.widgets.grid.ListGridField}).
 * </ul>
 */
public interface SGWTProperties {
}
