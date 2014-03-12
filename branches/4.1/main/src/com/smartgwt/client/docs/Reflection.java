
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
 *  You can do this in <code>onModuleLoad()</code>, or at some later point
 *  before the constructor is used.
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
 *  configured dynamically, you can register just those classes by using the 
 *  {@link com.smartgwt.client.bean.BeanFactory.MetaFactory} interface instead.
 *  Usage is most easily explained with an example. First, you define an
 *  interface. (Note that it can be an inner interface.)
 *  <blockquote><pre>
 *  public interface MyMetaFactory extends BeanFactory.MetaFactory {
 *      BeanFactory&lt;ListGrid&gt; getListGridFactory();
 *      BeanFactory&lt;TileGrid&gt; getTileGridBeanFactory();
 *  }</pre></blockquote>
 *  ... and then you trigger the generation process:
 *  <blockquote><pre>
 *  GWT.create(MyMetaFactory.class);</pre></blockquote>
 *  <p>
 *  Each function in the interface you define will result in the creation of
 *  one registered <code>BeanFactory</code> ... so, in this case, we would end up with
 *  bean factories for <code>ListGrid</code> and <code>TileGrid</code>. The rules
 *  are as follows:
 *  <ol>
 *  <li>The interface must extend <code>BeanFactory.MetaFactory</code></li>
 *  <li>The return type for each function must be <code>BeanFactory</code>,
 *  with a generic type that is the class you want to register for reflection.</li>
 *  <li>The function must take no arguments.</li>
 *  <li>The name of the function doesn't matter.</li>
 *  </ol>
 *  <p>
 *  If there are only a limited number of classes which require dynamic
 *  configuration, it will save code size to use the
 *  {@link com.smartgwt.client.bean.BeanFactory.MetaFactory} interface to generate
 *  factories for those specific types, rather than using 
 *  {@link com.smartgwt.client.bean.BeanFactory.CanvasMetaFactory} or
 *  {@link com.smartgwt.client.bean.BeanFactory.FormItemMetaFactory}. Once a factory
 *  is generated for a class, GWT's opportunities to prune dead code are more
 *  limited for that class, since it cannot know what properties will be set or
 *  retrieved at run-time.
 */
public interface Reflection {
}
