
package com.smartgwt.client.docs;

/**
 * <h3>Registering Classes for Reflection</h3>
 * In order to specify a SmartGWT class as a constructor in
 *  {@link com.smartgwt.client.docs.ComponentXML Component XML} or 
 *  {@link com.smartgwt.client.docs.ComponentSchema Component Schema},
 *  or for other purposes, such as for 
 *  {@link com.smartgwt.client.docs.AutoChildUsage autoChildren} or for 
 *  {@link com.smartgwt.client.data.DataSourceField#setEditorType(Class)}, 
 *  you must first register the class with the 
 *  {@link com.smartgwt.client.bean.BeanFactory} reflection mechanism.
 *  <p>
 *  If you want to register {@link com.smartgwt.client.widgets.Canvas}
 *  and all its subclasses found in the classpath (including your custom subclasses), 
 *  you can use the {@link com.smartgwt.client.bean.BeanFactory.CanvasMetaFactory}
 *  interface to do this automatically:
 *  <blockquote><pre>
 *  GWT.create(BeanFactory.CanvasMetaFactory.class);</pre></blockquote>
 *  <p>
 *  Similarly, to register {@link com.smartgwt.client.widgets.form.fields.FormItem}
 *  and all its subclasses found in the classpath (including your custom subclasses),
 *  you can use the {@link com.smartgwt.client.bean.BeanFactory.FormItemMetaFactory}.
 *  <blockquote><pre>
 *  GWT.create(BeanFactory.FormItemMetaFactory.class);</pre></blockquote>
 *  <p>
 *  Alternatively, if only specific classes need to be instantiated and
 *  configured dynamically, you can register just those classes by annotating
 *  them with the {@link com.smartgwt.client.bean.BeanFactory.Generate}
 *  annotation instead. For instance:
 *  <blockquote><pre>
 *  {@literal @}BeanFactory.Generate
 *  public class MyCanvas extends Canvas {
 *      ...
 *  }</pre></blockquote>
 *  <p>
 *  For framework classes (where you cannot annotate the class directly), you
 *  can supply an array of Class literals to the annotation. For instance:
 *  <blockquote><pre>
 *  {@literal @}BeanFactory.Generate({Canvas.class, TreeGrid.class})
 *  public interface EmptyInterface {
 *      ...
 *  }</pre></blockquote>
 *  <p>
 *  When you supply an array of class literals, the class you annotate
 *  (here <code>EmptyInterface</code>) will <b>not</b> itself have a 
 *  BeanFactory generated for it. Thus, you can use an empty inner
 *  interface for this purpose.
 *  <p>
 *  If there are only a limited number of classes which require dynamic
 *  configuration, it will save code size to use the
 *  {@link com.smartgwt.client.bean.BeanFactory.Generate} annotation to generate
 *  factories for those specific types, rather than using 
 *  {@link com.smartgwt.client.bean.BeanFactory.CanvasMetaFactory} or
 *  {@link com.smartgwt.client.bean.BeanFactory.FormItemMetaFactory}. Once a factory
 *  is generated for a class, GWT's opportunities to prune dead code are more
 *  limited for that class, since it cannot know what properties will be set or
 *  retrieved at run-time.
 */
public interface Reflection {
}
