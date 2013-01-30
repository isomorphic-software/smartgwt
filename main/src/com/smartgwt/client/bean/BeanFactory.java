/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.bean;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import com.smartgwt.client.bean.BeanProperty;
import com.smartgwt.client.bean.BeanValueType;

import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// ==================
// Technical Overview
// ==================
//
// Here is a road-map to the mechanics of the whole bean-factory mechanism.
//
// The BeanFactory class is the main class. There are subclasses for several
// of the core SmartGWT classes, starting with BaseWidgetBeanFactory. There is 
// then one subclass, and one instance, for each BeanClass (which, for now,
// must be a subclass of Canvas). So, each subclass for a BeanClass is a singleton.
//
// The main interface is meant to be the static methods on BeanFactory, but
// you can cache a BeanFactory instance and call the instance methods as well
// (for a slight efficiency gain).
//
// You trigger the generation of the subclasses through mechanisms discussed
// below.
//
// Each generated BeanFactory creates a corresponding SmartClient SGWTFactory
// and stores it in the isc[] space. This allows the SmartClient side to deal
// with SmartGWT classes through many usual SmartClient idioms. 
//
// Each BeanFactory keeps a hash of BeanProperty objects, where each
// BeanProperty represents one property. A property has a name, and may have
// multiple BeanMethod objects (representing getters and setters). Multiple
// setters would be overloaded methods, whereas multiple getters are such
// things as getWidthAsString().
//
// There are two big technical problems that need to be overcome to make this
// all work (and lots of little ones). The first is that you can't normally
// call a GWT function based on a run-time string -- you have to specify
// functions at compile time. So how does BeanMethod actually call the
// function? 
//
// There are several approaches possible. You could iterate through
// possible comparisons, by generating code like this:
//
// if (functionName == "getWidth") {
//    return bean.getWidth();
// } else if (functionName == "getHeight") {
//    return bean.getHeight();
// } ...
//
// However, that would be very inefficient, especially since there are so many
// possible properties.
//
// A second way would be to generate an anonymous subclass for every method type,
// something like this:
//
// new BeanMethod ("width") {
//    public Object getPropertyFromBean (BeanClass bean) {
//       return bean.getWidth();
//    }
// }
//
// This works, but it has a fair bit of overhead in the generated code size,
// because it is literally generating at least one (anonymous) class for every
// property, and each class has some boilerplate overhead. The next approach
// reduces the generated code size by about one-third (in my testing).
//
// The approach actually used is to create a JSNI function for each getter and
// setter. Conceptually, the generated code does something like this:
//
// public native Object callGetter (Object bean, String functionName) /*-{
//    var functions = {
//      width: function (b) {return b.@com.smartgwt.widgets.Canvas::getWidth()();},
//      height: function (b) {return b.@com.smartgwt.widgets.Canvas::getHeight()();}
//      ...
//    };
//    return functions[functionName](bean);
// }-*/;
//
// Though it's not implemented quite like that, because we would want to cache
// the hash of the functions, and there are sometimes multiple methods per
// function name. But you get the general idea -- experimentally, there is
// about one-third less overhead than through the anonymous subclass approach.
//
// The other big technical problem is what to do about the argument types ...
// that is, the types which setters expect, and the types which getters
// provide. Thinking about it from a purely SmartGWT point of view, if the
// property name is now dynamic and can be provided at run-time, it doesn't
// make much sense to require that the caller know exactly what type is needed.
// Of course, the SmartClient XML system can provide typed arguments for
// properties, but even there we would always need to convert between int and
// Integer and other numeric types. Also, where there are multiple overloaded
// setters, we need to use some intelligence in picking the setter, depending
// on what type of argument we've been provided. There are also various
// complexities in transitioning data from SmartClient Javascript to SmartGWT
// Java that need to be ironed out.
//
// That is what the BeanValueType class deals with. Essentially, it is meant to
// be able to do any of the conversions we might need. Some of them are fairly
// obvious, such as the conversion amongst numeric types and to and from Strings.
// But it also handles conversion among array types, which is trickier (and
// necessary, since all arrays provided from JavaScript are untyped as far as
// GWT is concerned). It also deals with SmartGWT-specific conversions, like
// the various ValueEnum types and conversions which are possible when we
// know what the desired type is (for instance, converting a JavaScriptObject
// which we know is a SmartClient Canvas to a SmartGWT Canvas).
//
// The general interface is in com.smartgwt.client.bean.BeanValueType, and the
// various files in com.smartgwt.client.bean.types.* represent subclasses.
// Some subclasses deal with a single type. Others are superclasses where we
// need to generate a subclass for each type. Others can be used to deal with
// more than one type.
//
// So, for setting a property, the basic steps are:
//
// 1. The BeanFactory static method finds the right BeanFactory for the object.
// 2. The BeanFactory instance picks out the correct BeanProperty.
// 3. The BeanProperty looks at its BeanMethods, and if more than one, uses
//    BeanValueType which BeanMethod is best for the value supplied.
// 4. The BeanProperty uses BeanValueType to convert the value to the type
//    that the selected BeanMethod needs.
// 5. The BeanMethod uses JSNI to call the actual setter.

/**
 * Utility class for creating objects and setting properties at run-time via
 * reflection-like mechanisms.
 *
 * <p>Subclasses must be generated for each {@link Class} you want to use. To trigger
 * the generation of subclasses, see the documentation on
 * {@link com.smartgwt.client.docs.Reflection registering classes for reflection}.
 *
 * <p>Once the appropriate subclass has been created, you can use the class via
 * the static methods.
 *
 * <p>For the moment, this class only works with subclasses of {@link
 * BaseWidget} or {@link FormItem}.
 */
public abstract class BeanFactory<BeanClass> {
    // --------------------
    // Generator Interfaces
    // --------------------

    /**
    * An interface which you can extend in order to register classes
    * with the <code>BeanFactory</code> reflection mechanism.
    *
    * <p>In order to use a {@link BeanFactory} for a class, you need to
    * register it by generating a <code>BeanFactory</code> subclass for the
    * class. You can use {@link BeanFactory.CanvasMetaFactory} to scan the
    * class path and register every {@link Canvas} subclass (including your
    * custom subclasses), or use {@link BeanFactory.FormItemMetaFactory} to
    * regiser every {@link FormItem} subclass. However, if you know that you
    * only need to register some classes for reflection, then you can use
    * <code>BeanFactory.MetaFactory</code> instead.
    *
    * <p>Usage is most easily explained with an example. First, you define an
    * interface. (Note that it can be an inner interface.)
    *
    * <blockquote><pre>
    * public interface MyMetaFactory extends BeanFactory.MetaFactory {
    *     BeanFactory&lt;ListGrid&gt; getListGridFactory();
    *     BeanFactory&lt;TileGrid&gt; getTileGridBeanFactory();
    * }</pre></blockquote>
    *
    * ... and then you trigger the generation process:
    *
    * <blockquote><pre>
    * GWT.create(MyMetaFactory.class);</pre></blockquote>
    *
    * <p>Each function in the interface you define will result in the creation of
    * one <code>BeanFactory</code> ... so, in this case, we would end up with
    * bean factories for <code>ListGrid</code> and <code>TileGrid</code>. The rules
    * are as follows:
    *
    * <ol>
    * <li>The interface must extend <code>BeanFactory.MetaFactory</code></li>
    * <li>The return type for each function must be <code>BeanFactory</code>,
    * with a generic type that is the class you want the factory for.</li>
    * <li>The function must take no arguments.</li>
    * <li>The name of the function doesn't matter.</li>
    * </ol>
    *
    * <p>If you want, you can keep a reference to the results of the <code>GWT.create()</code>,
    * and call the functions:
    * 
    * <blockquote><pre>
    * MyMetaFactory metaFactory = GWT.create(MyMetaFactory.class);
    * BeanFactory&lt;TileGrid&gt; myTileGridFactory = myMetaFactory.getTileGridBeanFactory();</pre></blockquote>
    *
    * <p>However, you don't have to do that ... you can ignore the results of <code>GWT.create()</code>
    * and just use the <code>BeanFactory</code> static API:
    *
    * <blockquote><pre>
    * GWT.create(MyMetaFactory.class);
    * Object myGrid = BeanFactory.newInstance("TileGrid");
    * BeanFactory.setProperty(myGrid, "width", 207);</pre></blockquote>
    *
    * ... except that "TileGrid" would probably be a variable!
    *
    * <p>You can also use the generated classes in {@link com.smartgwt.client.docs.ComponentXML}, 
    * by specifying the fully-qualified class name as the constructor for objects.
    *
    * <p>Note that the call to <code>GWT.create()</code> must occur at run-time before
    * the factories are used. However, you can modularize by creating some factories
    * first and other factories later, as long as each factory is created before
    * being used.
    */
    public static interface MetaFactory {
        // One understands that a factory to generate factories is in danger of
        // being mocked. However, it really is the right way to do this in
        // GWT.
        //
        // The problem with using GWT.create to create the factory directly (e.g.
        // GWT.create(ListGrid.class)) is that then you have to register a
        // generator for ListGrid.class (or a superclass), and you can only have
        // one generator registered for that class. So, you can't generate anything
        // else for a ListGrid via that mechanism -- it's one shot.
        //
        // Also, the semantics are wrong. We're not generating the ListGrid class
        // -- we're generating a factory. Of course, it's legal to respond to
        // GWT.create(ListGrid.class) by generating something other than a
        // ListGrid class, but it is a bit odd.
        //
        // However, it would be tedious to have to define a separate interface for
        // each factory, so we instead define an interface for a second-level
        // factory -- a factory that can create factories.
        //
        // So, MetaFactory is just a marker -- by defining an interface
        // which extends it, you tell GWT to generate factories. 
        
    }

    /**
    * Interface used to trigger the generation and registration of reflection
    * metadata for {@link com.smartgwt.client.widgets.Canvas} and all 
    * its subclasses found in the classpath (including your custom subclasses).
    *
    * <p>Usage is to simply call <code>GWT.create(BeanFactory.CanvasMetaFactory.class);</code>
    * Note that the return value is not useful -- you would then simply use
    * the {@link BeanFactory} API, like so:
    *
    * <blockquote><pre>
    * GWT.create(BeanFactory.CanvasMetaFactory.class);
    *
    * String className = "com.smartgwt.client.widgets.Button"; 
    * Canvas canvas = (Canvas) BeanFactory.newInstance(className);
    *
    * BeanFactory.setProperty(canvas, "title", "Hello World");
    * BeanFactory.setProperty(canvas, "tooltip", "My tooltip");
    * canvas.draw();</pre></blockquote>
    *
    * <p>Furthermore, the className can also be used as a Constructor in
    * {@link com.smartgwt.client.docs.ComponentXML Component XML}. 
    *
    * <p>Alternatively if only specific <code>Canvas</code> types need to be
    * instantiated and configured dynamically, you can generate specific
    * factories by using the {@link BeanFactory.MetaFactory} interface instead.
    * 
    * <p>If there are only a limited number of types which require dynamic
    * configuration, it will save code size to use the
    * <code>BeanFactory.MetaFactory</code> interface for those types. Once the
    * metadata is generated, GWT's opportunities to prune dead code are more
    * limited for those classes, since it cannot know what properties will be
    * set or retrieved at run-time.
    */
    public static interface CanvasMetaFactory {

    }

    /**
    * Interface used to trigger the generation and registration of reflection
    * metadata for {@link com.smartgwt.client.widgets.form.fields.FormItem} and
    * all its subclasses found in the classpath (including your custom subclasses).
    *
    * <p>Usage is to simply call <code>GWT.create(BeanFactory.FormItemMetaFactory.class);</code>
    * Note that the return value is not useful -- you would then simply use
    * the {@link BeanFactory} API, like so:
    *
    * <blockquote><pre>
    * GWT.create(BeanFactory.FormItemMetaFactory.class);
    *
    * String className = "com.smartgwt.client.widgets.form.fields.TextItem"; 
    * Object canvas = BeanFactory.newInstance(className);
    *
    * BeanFactory.setProperty(canvas, "title", "Hello World");
    * BeanFactory.setProperty(canvas, "tooltip", "My tooltip");
    * </pre></blockquote>
    *
    * <p>Furthermore, the className can also be used as a Constructor in
    * {@link com.smartgwt.client.docs.ComponentXML Component XML}. 
    *
    * <p>Alternatively if only specific <code>FormItem</code> types need to be
    * instantiated and configured dynamically, you can generate specific
    * factories by using the {@link BeanFactory.MetaFactory} interface instead.
    * 
    * <p>If there are only a limited number of types which require dynamic
    * configuration, it will save code size to use the
    * <code>BeanFactory.MetaFactory</code> interface for those types. Once the
    * metadata is generated, GWT's opportunities to prune dead code are more
    * limited for those classes, since it cannot know what properties will be
    * set or retrieved at run-time.
    */
    public static interface FormItemMetaFactory {

    }

    // ------------------------------------------
    // Static housekeeping properties and methods
    // ------------------------------------------
    
    // The factories, hashed by the fully-qualified class name of the base class.
    private static Map<String, BeanFactory<?>> factoriesByName = new HashMap<String, BeanFactory<?>>();
 
    // The factories, hashed by the base class literal.
    private static Map<Class<?>, BeanFactory<?>> factoriesByClass = new HashMap<Class<?>, BeanFactory<?>>();
    // Note that we need to look up factories by class name and by class
    // literal to deal with two different scenarios. When we are creating a new
    // instance, and all we have is a class name, then we have to be able to
    // look up the class name.  When we have an existing object and we need to
    // manipulate it, then we have to look up the class literal. The reason is
    // that there could be duplicate class names in separately loaded modules.
    // Thus, even if the class name matches, it may be that we should not
    // "claim" the object -- it may have been created in another module, which
    // was loaded separately. Even if the class in that model is compiled from
    // the same source as the class in this module, we may not be able to
    // manipulate it from this module, because it may have obfuscated
    // differently.
    //
    // Note also that the map we maintain here is only for this module -- this
    // class itself may be compiled into other modules loaded separately. The 
    // only panoptic view of the factories is actually in the SmartClient
    // SGWTFactory class.

    // Note that this will only return factories defined in this GWT module ...
    // it is unaware of any other modules.
    public static BeanFactory<?> getFactory (String className) {
        return factoriesByName.get(className);
    }

    // Note that this will only return factories defined in this GWT module ...
    // it is unaware of any other modules.
    public static BeanFactory<?> getFactory (Class<?> klass) {
        return factoriesByClass.get(klass);
    }

    // Registers a factory for a base class.
    protected static void registerFactory (BeanFactory<?> factory) {
        // If this is the first factory, then register this module
        // with SGWTFactory on the SmartClient side.
        if (factoriesByClass.isEmpty()) {
            registerWithSGWTFactory();
        }

        // Bail out if a factory has already been registered for the class name
        final String beanClassName = factory.getBeanClassName();
        if (factoriesByName.containsKey(beanClassName)) {
            SC.logWarn("BeanFactory for class has already been registered: " + beanClassName);    
            return;
        }

        factoriesByName.put(beanClassName, factory);
        factoriesByClass.put(factory.getBeanClass(), factory);
    }
    
    // This one is for exporting at the SGWTFactory class level. SGWTFactory
    // can use it to figure out which factory, among possibly multiple modules,
    // can handle an object.
    private native static void registerWithSGWTFactory () /*-{
        $wnd.isc.SGWTFactory.registerGetSGWTFactoryFunction(
            $entry(@com.smartgwt.client.bean.BeanFactory::getSGWTFactory(Ljava/lang/Class;))
        );
    }-*/;

    // Looks up the SGWTFactory for a class object. This is called from SGWTFactory
    // on the SmartClient side in order to get the factory for an existing object.
    protected static JavaScriptObject getSGWTFactory (Class<?> klass) {
        // Note that we do this at the class level, rather than the object level,
        // because the relevant object could belong to a different module, and
        // might have a different obfuscation for getClass. We can deal with the
        // different obfuscation possibilities on the SGWTFactory side, since
        // the possibilities are stable (getClass$ or gC). (In principle, it could
        // be done in JSNI here also).
        BeanFactory<?> factory = getFactory(klass);
        if (factory == null) {
            return null;
        } else {
            return factory.sgwtFactory;
        }
    }

    // -----------------------------------------
    // Static functions to export to SGWTFactory
    // -----------------------------------------
    
    // We construct these once because SmartGWT's $entry will create a new
    // function, so we may as well cache that, rather than creating one for
    // each factory. We have to actually export this function for each factory, 
    // because not all factories will necessarily come from this SmartGWT module.
    // But, at least this way we can export the same function to each factory,
    // rather than creating one each time.

    private static JavaScriptObject exportableNewInstanceFn = exportNewInstanceFn();
    private static JavaScriptObject exportableSetPropertyFn = exportSetPropertyFn();
    private static JavaScriptObject exportableGetPropertyFn = exportGetPropertyFn();
    private static JavaScriptObject exportableGetPropertyAsStringFn = exportGetPropertyAsStringFn();
    private static JavaScriptObject exportableGetAttributesFn = exportGetAttributesFn();
    private static JavaScriptObject exportableGetOrCreateJsObjFn = exportGetOrCreateJsObjFn();

    private native static JavaScriptObject exportNewInstanceFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::newInstance(Ljava/lang/String;));
    }-*/;

    private native static JavaScriptObject exportSetPropertyFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::setProperty(Ljava/lang/Object;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;));
    }-*/;

    private native static JavaScriptObject exportGetPropertyFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::getPropertyAsJavaScriptObject(Ljava/lang/Object;Ljava/lang/String;));
    }-*/;

    private native static JavaScriptObject exportGetPropertyAsStringFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::getPropertyAsString(Ljava/lang/Object;Ljava/lang/String;));
    }-*/;

    private native static JavaScriptObject exportGetAttributesFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::getAttributesAsJavaScriptObject(Ljava/lang/String;));
    }-*/;

    private native static JavaScriptObject exportGetOrCreateJsObjFn () /*-{
        return $entry(@com.smartgwt.client.bean.BeanFactory::getOrCreateJsObj(Ljava/lang/Object;));
    }-*/;

    // -----------------
    // Static Public API
    // -----------------

    // Note that all of these functions only deal with factories defined in a
    // single GWT module at a time. The only way to access factories in other
    // modules is through the SmartClient SGWTFactory side. But even if one did
    // so, all one could get would be opaque references that could only be
    // manipulated through the SGWTFactory, since code in this module would
    // have no idea how code in the other module had been obfuscated. If
    // desirable, it would be possible write a public API here to manipulate
    // such references through SGWTFactory.

    // Convenience functions for exceptions
    protected static IllegalStateException noFactoryException (String name) {
        return new IllegalStateException("No factory has been generated for class: " + name);
    }

    protected static IllegalStateException noFactoryException (Class<?> klass) {
        return noFactoryException(klass.getName());
    }

    /**
     * Create an instance based on the provided class name.
     *
     * @param className the class name
     * @return a new instance of the class
     * @throws IllegalStateException If no factory has been generated for the className
     */
    public static Object newInstance (String className) {
        // Note that we can't use the parameterized BeanClass type in the static method
        BeanFactory<?> factory = BeanFactory.getFactory(className);
        if (factory == null) {
            throw noFactoryException(className);
        } else {
            return factory.newInstance();
        }
    }

    /**
     * Create an instance based on the provided class object.
     *
     * @param klass the class object
     * @return a new instance of the class
     * @throws IllegalStateException If no factory has been generated for the klass
     */
    public static Object newInstance (Class<?> klass) {
        // Note that we can't use the parameterized BeanClass type in the static method
        BeanFactory<?> factory = BeanFactory.getFactory(klass);
        if (factory == null) {
            throw noFactoryException(klass);
        } else {
            return factory.newInstance();
        }
    }

    /**
     * Sets a property of a bean to a value.
     *
     * @param bean The object whose property is to be set
     * @param property The name of the property
     * @param value The value to set
     * @throws IllegalStateException If no factory has been generated for the bean's class
     * @throws IllegalArgumentException If there is no appropriate setter for the value
     */
    public static void setProperty (Object bean, String property, Object value) {
        // Note that we can't use the parameterized BeanClass type in the static method
        if (bean != null) {
            BeanFactory<?> factory = BeanFactory.getFactory(bean.getClass());
            if (factory == null) {
                throw noFactoryException(bean.getClass());
            } else {
                // Need a different name for the instance method, since the signature
                // is the same.
                factory.doSetProperty(bean, property, value);
            }
        }
    }
   
    /**
     * Sets a property of a bean to a JavaScriptObject value, converting the
     * JavaScriptObject to a Java equivalent.
     *
     * @param bean The object whose property is to be set
     * @param property The name of the property
     * @param value The value to set
     * @throws IllegalStateException If no factory has been generated for the bean's class
     * @throws IllegalArgumentException If there is no appropriate setter for the value
     */
    public static void setProperty (Object bean, String property, JavaScriptObject value) {
        // Note that we can't use the parameterized BeanClass type in the static method
        try {
            // This does a generic conversion to a Java value ... the property
            // may do further conversion, depending on the types it can handle
            setProperty(bean, property, BeanValueType.convertToJava(value));
        }
       
        // This is exported to SmartClient, so make sure exceptions are logged before we return
        catch (RuntimeException ex) {
            SC.logWarn(ex.getMessage());
            throw ex;
        }
    }

    /**
     * Gets a property of a bean.
     *
     * @param bean The object whose property to get
     * @param property The name of the property
     * @throws IllegalStateException If no factory has been generated for the bean's class
     */
    public static Object getProperty (Object bean, String property) {
        // Note that we can't use the parameterized BeanClass type in the static method
        if (bean == null) return null;

        BeanFactory<?> factory = BeanFactory.getFactory(bean.getClass());
        if (factory == null) {
            throw noFactoryException(bean.getClass());
        } else {
            return factory.doGetProperty(bean, property);
        }
    }

    /**
     * Gets a property of a bean as a String.
     *
     * In simple cases, this will be equivalent to getProperty().toString().
     * However, if there are multiple getters available, it will prefer getters
     * that actually return strings (e.g. getWidthAsString() would be preferred
     * for "width").
     *
     * @param bean The object whose property to get
     * @param property The name of the property
     * @throws IllegalStateException If no factory has been generated for the bean's class
     */
    public static Object getPropertyAsString (Object bean, String property) {
        // Note that we can't use the parameterized BeanClass type in the static method
        if (bean == null)  return null;

        BeanFactory<?> factory = BeanFactory.getFactory(bean.getClass());
        if (factory == null) {
            throw noFactoryException(bean.getClass());
        } else {
            return factory.doGetPropertyAsString(bean, property);
        }
    }

    // For export to SmartClient
    public static JavaScriptObject getPropertyAsJavaScriptObject (Object bean, String property) {
        try {
            final Object value = getProperty(bean, property);
            return BeanValueType.convertToJavaScriptObject(value);
        }
        
        // This is exported to SmartClient, so make sure we log any exceptions before returning
        catch (RuntimeException ex) {
            SC.logWarn(ex.getMessage());
            throw ex;
        }
    }

    /**
     * Gets an array of the names of the properties of a class.
     *
     * @param className The name of the class
     * @throws IllegalStateException If no factory has been generated for the class
     */
    public static String[] getAttributes (String beanClassName) {
        BeanFactory<?> factory = BeanFactory.getFactory(beanClassName);
        if (factory == null) {
            throw noFactoryException(beanClassName);
        } else {
            return factory.getAttributes();
        }
    }

    /**
     * Gets an array of the names of the properties of a class.
     *
     * @param klass The klass object
     * @throws IllegalStateException If no factory has been generated for the class
     */
    public static String[] getAttributes (Class<?> beanClass) {
        BeanFactory<?> factory = BeanFactory.getFactory(beanClass);
        if (factory == null) {
            throw noFactoryException(beanClass);
        } else {
            return factory.getAttributes();
        }
    }

    // For export to SmartClient
    protected static JavaScriptObject getAttributesAsJavaScriptObject (String beanClassName) {
        try {
            final String[] attributes = getAttributes(beanClassName);
            return BeanValueType.convertToJavaScriptObject(attributes);
        }

        // This is exported to SmartClient, so make sure exceptions are logged before we return
        catch (RuntimeException ex) {
            SC.logWarn(ex.getMessage());
            throw ex;
        }
    }

    public static JavaScriptObject getOrCreateJsObj (Object bean) {
        // Note that we can't use the parameterized BeanClass type in the static method
        if (bean == null) return null;
            
        BeanFactory<?> factory = BeanFactory.getFactory(bean.getClass());
        if (factory == null) {
            throw noFactoryException(bean.getClass());
        } else {
            return factory.doGetOrCreateJsObj(bean);
        }
    }

    // ------------------------------
    // Instance variables and methods
    // ------------------------------

    // We use the superclassFactory to find properties in the superclasses
    // (rather than recording them redundantly).
    protected BeanFactory superclassFactory;

    // The generated subclass must populate the properties.
    protected Map<String, BeanProperty<BeanClass>> properties = new HashMap<String, BeanProperty<BeanClass>>();

    // Our SGWTFactory (the SmartClient interface to the factory)
    protected JavaScriptObject sgwtFactory;

    // A cache for our attribute names, including those defined in superclasses
    private String[] attributeNames;

    /**
     * The constructor is protected because you should not create BeanFactory
     * instances directly. Instead, use {@link BeanFactory.MetaFactory} or
     * {@link BeanFactory.CanvasMetaFactory} to create bean factories, and then
     * use the static methods on BeanFactory.
     *
     * @see BeanFactory.MetaFactory
     * @see BeanFactory.CanvasMetaFactory
     */
    protected BeanFactory () { 
        // Ensure that all the value types we use have been registered.
        registerValueTypes();
        
        // Initialize the JSNI function array for the setters and getters,
        // and then initialilze the properties. 
        for (BeanProperty<BeanClass> property : getProperties(getMethods())) {
            properties.put(property.getName(), property);    
        }

        // Create the SmartClient SGWTFactory equivalent. Note that we need
        // this whether or not we're registering our class name with
        // SGWTFactory, since we need it to deal with any SGWT objects we
        // create.
        sgwtFactory = createSGWTFactory();
        
        // This registers us locally, on the SmartGWT side, for this module
        BeanFactory.registerFactory(this);

        // See if we can get the superclass factory ... we don't want to
        // construct it if we don't have to ...
        Class superclass = getSuperclass();
        if (superclass != null) {
            superclassFactory = getFactory(superclass);
            if (superclassFactory == null) {
                // Note that creating it will also register it, so next time
                // getFactory will find it.
                superclassFactory = createSuperclassFactory();
            }
        }
    }

    // To be implemented by generated subclasses if it is appropriate to check
    // the superclass for properties. Can leave as null if generating for a base
    // class for which no further superclasses are relevant.
    protected Class getSuperclass () {
        return null;
    }

    // To be implemented by subclasses to actually create the superclass
    // factory. This will only be called if the factory is not already cached
    // (for instance, if GWT.create was called to create it, or it has already
    // been created by a different subclass).
    protected BeanFactory<?> createSuperclassFactory () {
        return null;
    }

    // To be implemented by subclasses to register any ValueTypes which they use
    protected abstract void registerValueTypes ();

    // This will be implemented by generated subclasses to set up all the
    // getters and setters for the BeanFactory, as a Javascript array of JSNI
    // functions, The reason we use JSNI functions is that we can then pass the
    // function around as a function pointer -- for instance, we can associate
    // it with a property as data, and call it. 
    //
    // The "standard" GWT way to do that would be an anonymous subclass with a
    // callback function. That works, but it has a lot of overhead, since it
    // creates a class for every method. The size of the generated code ends up
    // approximately one-third larger that way.
    //
    // Ideally, we could simply get the function pointer for the *real* setter
    // or getter itself (rather than constructing a function that calls it).
    // However, that's hard to generate, because GWT will only generate the
    // obfuscated function name in JSNI in the context of calling the function.
    protected abstract JsArray<JavaScriptObject> getMethods ();

    // To be implemented by generated subclasses to return an array of properties.
    // Each property will use one or more methods from the JsArray generated by
    // getMethods().
    protected abstract BeanProperty<BeanClass>[] getProperties (JsArray<JavaScriptObject> methods);

    // Creates the SmartClient SGWTFactory, passing in the callback functions.
    // At the moment, the functions are actually the same for every factory,
    // so in principle one could store them at a "module" level rather than
    // in each SGWTFactory. However, it is just the reference that is redundant ...
    // we're not creating multiple copies of the function.
    private native JavaScriptObject createSGWTFactory () /*-{
        return $wnd.isc.SGWTFactory.create({
            beanClassName: this.@com.smartgwt.client.bean.BeanFactory::getBeanClassName()(),
            newInstanceFn: @com.smartgwt.client.bean.BeanFactory::exportableNewInstanceFn,
            setPropertyFn: @com.smartgwt.client.bean.BeanFactory::exportableSetPropertyFn,
            getPropertyFn: @com.smartgwt.client.bean.BeanFactory::exportableGetPropertyFn,
            getPropertyAsStringFn: @com.smartgwt.client.bean.BeanFactory::exportableGetPropertyAsStringFn,
            getAttributesFn: @com.smartgwt.client.bean.BeanFactory::exportableGetAttributesFn,
            getOrCreateJsObjFn: @com.smartgwt.client.bean.BeanFactory::exportableGetOrCreateJsObjFn
        });
    }-*/;

    // Calls the SGWTFactory function which registers the class name in the isc[] space, so that
    // idioms like isc[className].create will work.
    public native void registerClassNameWithSGWTFactory () /*-{
        this.@com.smartgwt.client.bean.BeanFactory::sgwtFactory.registerClassName();
    }-*/;

    // Gets the base class for which we are the factory. Subclasses must
    // implement.
    public abstract Class<BeanClass> getBeanClass();

    // Gets the name of the base class for which we are the factory.
    public String getBeanClassName () {
        return getBeanClass().getName();
    }

    // Create a new instance of the underlying class. Must be generated for
    // all subclasses.
    public abstract BeanClass newInstance ();

    // Sets a property of the bean to a value
    @SuppressWarnings("unchecked")
    public void doSetProperty (Object bean, String propertyName, Object value) {
        // Note that we don't want to use the parameterized BeanClass type
        // here, because we'd like to be able to call this from the static
        // method.
        
        BeanProperty<BeanClass> property = properties.get(propertyName);
        if (property == null) {
            // If we don't have it, check the superclass
            if (superclassFactory == null) {
                // If there is no superclassFactory, then set the property on
                // the underlying Javascript object directly.
                setJavascriptProperty((BeanClass) bean, propertyName, value);
            } else {
                // If we have a superclass, let it try
                superclassFactory.doSetProperty(bean, propertyName, value);
            }
        } else {
            // The type-cast should be safe, because we only get here once we've
            // picked the correct factory for the bean
            property.setProperty((BeanClass) bean, value);
        }
    }

    // Sets a property on the underlying Javascript property directly. This is done
    // differently depending on the BeanClass, so we put it in a subclass.
    protected abstract void setJavascriptProperty (BeanClass bean, String propertyName, Object value);

    public String[] getAttributes () {
        // We lazily create a cache for the return value. Note that this
        // assumes that the method won't be called too "early" -- that is,
        // before the BeanFactory is finished registering its properties and
        // superclass factories. That happens in the constructor, so it should
        // be a safe assumption.
        if (attributeNames == null) {
            // Construct a new set of strings out of our properties keySet, since
            // the keySet should not be mutated here.
            Set<String> attributes = new HashSet<String>(properties.keySet());
            
            // Add property names from superclass factories
            BeanFactory<?> superclassIterator = superclassFactory;
            while (superclassIterator != null) {
                attributes.addAll(superclassIterator.properties.keySet());
                superclassIterator = superclassIterator.superclassFactory;
            }

            // Supply the parameter to provide the array type
            attributeNames = attributes.toArray(new String[attributes.size()]);
        }

        return attributeNames;
    }

    @SuppressWarnings("unchecked")
    public Object doGetProperty (Object bean, String propertyName) {
        // Note that we don't want to use the parameterized BeanClass type
        // here, because we'd like to be able to call this from the static
        // method.
        BeanProperty<BeanClass> property = properties.get(propertyName);
        if (property == null) {
            // If we don't have the property, try a superclassFactory.
            if (superclassFactory == null) {
                // If there is no superclassFactory, then try to get the
                // property from the Javascript side.
                return getJavascriptProperty((BeanClass) bean, propertyName);
            } else {
                // Otherwise, let the superclass try
                return superclassFactory.doGetProperty(bean, propertyName);
            }
        } else {
            // The type-cast should be safe, since we only get here once we've
            // picked the correct factory.
            return property.getProperty((BeanClass) bean);
        }
    }

    @SuppressWarnings("unchecked")
    public String doGetPropertyAsString (Object bean, String propertyName) {
        // Note that we don't want to use the parameterized BeanClass type
        // here, because we'd like to be able to call this from the static
        // method.
        BeanProperty<BeanClass> property = properties.get(propertyName);
        if (property == null) {
            // If we don't have the property, try a superclassFactory.
            if (superclassFactory == null) {
                // If there is no superclassFactory, then try to get the
                // property from the Javascript side.
                return getJavascriptProperty((BeanClass) bean, propertyName).toString();
            } else {
                // Otherwise, let the superclass try
                return superclassFactory.doGetPropertyAsString(bean, propertyName);
            }
        } else {
            // The type-cast should be safe, since we only get here once we've
            // picked the correct factory.
            return property.getPropertyAsString((BeanClass) bean);
        }
    }

    private Object getJavascriptProperty (BeanClass bean, String propertyName) {
        return BeanValueType.convertToJava(getAttributeAsJavaScriptObject(bean, propertyName));
    }

    protected abstract JavaScriptObject getAttributeAsJavaScriptObject(BeanClass bean, String property);

    public abstract JavaScriptObject doGetOrCreateJsObj (Object bean);
}
