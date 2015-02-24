/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2015 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

// Configuration Safeguards - report if configuration properties are improperly used
public class ConfigUtil {

    public static final String CONFIG_PROPERTIES = "configProperties";

    // java.lang.Class.getSimpleName() is only supported in GWT 2.6+
    public static String getSimpleClassName(Class targetClass) {
        String className = targetClass.getName();
        return className.replaceFirst(".*\\.", "");
    }

    // BaseWidget/BaseClass/FormItem

    public static void warnOfPreConfigInstantiation(Class callerClass, String callerMethodName,
                                                    Class configClass)
    {
        warnOfPreConfigInstantiation(callerClass, callerMethodName, 
                                     getSimpleClassName(configClass));
    }

    public static void warnOfPreConfigInstantiation(Class callerClass, String callerMethodName, 
                                                    String configTypeName) 
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "()";

        String message = callerDesc + ": the " + configTypeName + " passed as configuration " +
            "properties has been initialized and/or drawn.  Calling draw(), fetchData() " +
            "and other key methods will force a component to initialize after which it " +
            "cannot be used as configuration properties.";

        if (useWarnings) SC.logWarn(message, CONFIG_PROPERTIES);
        else throw new IllegalStateException(message);
    }

    public static void warnOfPostConfigInstantiation(Class callerClass, String callerMethodName, 
                                                     String configTypeName) 
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "(" + configTypeName + ")";
        SC.logWarn(callerDesc + ": unable to invoke the method on the " + className +
            " instance because it was previously used as configuration properties.  After " +
            "a component has been used as configuration properties, you may not invoke " + 
            "methods on it that force it to initialize, such as draw(), fetchData(), " + 
            "or similar.", CONFIG_PROPERTIES);
    }

    // DataClass

    public static void warnOfPostConfigHandlerAdd(Class callerClass, String callerMethodName, 
                                                  Class argumentType) 
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "()",
               configTypeName = argumentType.getName();
        SC.logWarn(callerDesc + ": unable to add the " + configTypeName + " handler to the " +
                   className + " instance because the instance was previously used to " +
                   "configure the properties of another Object", CONFIG_PROPERTIES);
    }

    public static void warnOfPostConfigModification(Class callerClass, String callerMethodName, 
                                                    String configTypeName) 
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "()";
        SC.logWarn(callerDesc + ": unable to apply the " + configTypeName + " argument to " +
                   "the " + className + " instance because the instance was previously used " +
                   "to configure the properties of another Object", CONFIG_PROPERTIES);
    }

    public static void warnOfReconfiguration(Class callerClass, String callerMethodName,
                                             String configTypeName)
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "()";
        SC.logWarn(callerDesc + ": the " + configTypeName + " passed has already been " +
                   "applied to an Object; unable to apply it again", CONFIG_PROPERTIES);
    }

    public static void debugInitialConfiguration(Class callerClass, String callerMethodName,
                                                 String configTypeName)
    {
        String className = getSimpleClassName(callerClass),
               callerDesc = className + "." + callerMethodName + "()";
            SC.logDebug(callerDesc + ": the " + configTypeName + " passed will be applied to " +
                        "this " + className + " instance", CONFIG_PROPERTIES);
    }

    private static boolean useWarnings;

    /**
     * When set true, prevents IllegalStateException from being thrown when a configuration
     * properties object is instantiated prior to being passed in to configure another object.
     * A warning will be logged in this case instead of throwing an exception.
     *
     * @param useWarnings whether to report all config errors as warnings rather than exceptions
     */
    public static void setUseWarningsForConfigurationErrors(boolean useWarnings) {
        ConfigUtil.useWarnings = useWarnings;
    }
}
