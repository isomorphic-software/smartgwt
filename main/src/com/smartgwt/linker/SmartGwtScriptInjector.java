/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2014 and beyond, Isomorphic Software, Inc.
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

package com.smartgwt.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ConfigurationProperty;
import com.google.gwt.core.ext.linker.Artifact;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.SyntheticArtifact;
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.ScriptReference;

import com.google.gwt.dev.About;
import com.google.gwt.dev.cfg.ModuleDef;
import com.google.gwt.dev.cfg.ModuleDefLoader;
import com.google.gwt.core.linker.CrossSiteIframeLinker;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

@Shardable
@LinkerOrder(LinkerOrder.Order.POST)
public class SmartGwtScriptInjector extends AbstractLinker {

    private static Class XSI_LINKER_CLASS = CrossSiteIframeLinker.class;
    private static Class MODULE_DEF_LOADER_CLASS = ModuleDefLoader.class;
    private static String COMPILER_CONTEXT = "com.google.gwt.dev.CompilerContext";

    // check whether we need to add a section to manually load the module's script tags
    private boolean forceScriptLoad(TreeLogger logger, String moduleName, Float gwtVersion)
    {
        try {
            ModuleDef module;
            Method getModuleDef;

            // ModuleDefLoader.loadFromClassPath has two possible signatures
            if (gwtVersion < 2.6f) {
                getModuleDef = MODULE_DEF_LOADER_CLASS.getDeclaredMethod("loadFromClassPath",
                                                  new Class[] {TreeLogger.class, String.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, moduleName);
            } else if (gwtVersion < 2.8f) {
                Class compilerContextClass = Class.forName(COMPILER_CONTEXT);
                Object context = compilerContextClass.getDeclaredConstructor().newInstance();

                getModuleDef = MODULE_DEF_LOADER_CLASS.getDeclaredMethod("loadFromClassPath",
                         new Class[] {TreeLogger.class, compilerContextClass, String.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, 
                                                compilerContextClass.cast(context), moduleName);
            } else {
                getModuleDef = MODULE_DEF_LOADER_CLASS.getDeclaredMethod("loadFromClassPath",
                                new Class[] {TreeLogger.class, String.class, boolean.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, moduleName, false);
            }
            
            // now use the module to check whether primary linker ist he CrossSiteIframeLinker
            if (module != null) return XSI_LINKER_CLASS.equals(module.getActivePrimaryLinker());
            logger.log(TreeLogger.WARN, "Can't find module reference - not injecting scripts.");

        } catch (Throwable t) {
            logger.log(TreeLogger.ERROR, "Encountered an exception while trying to " +
                       "resolve the ModuleDef for " + moduleName, t);
        }
        return false;
    }

    private static String SCRIPT_LOADER = "loadScriptTagFiles.js";
    private static String LOADED_SCRIPTS = "__gwt_scriptsLoaded";
    private static String PAGE_RELATIVE_MODULE_PATH = "scriptInjector.pageRelativeModulePath";

    private static String LINKER_ANNOUNCE = "   Invoking Linker SmartGwtScriptInjector";
    private static String LOADER_ANNOUNCE = 
        "      Creating " + SCRIPT_LOADER + " to manually load the following script tags:";

    private String getScriptLoaderJS(String pageRelativeModulePath) {
        return "if (!/loaded|interactive|complete/.test(document.readyState)) {\n" +
               "  document.write('<script src=\"" + pageRelativeModulePath + "/" +
                                             SCRIPT_LOADER + "\"></script>');\n" +
               "}\n";
    }

    private String getScriptLoadJS(Set<ScriptReference> scriptsToLoad, 
                                   String pageRelativeModulePath) 
    {
        String result = "if (!window." + LOADED_SCRIPTS + ") " + 
                             "window." + LOADED_SCRIPTS + " = {};\n";
        for (ScriptReference script : scriptsToLoad) {
            String src = script.getSrc();
            System.out.println(src);

            // prepend pageRelativeModulePath if the path is not absolute
            boolean isAbsolute = src.matches("^([a-z]+://|/).*");
            if (!isAbsolute) src = pageRelativeModulePath + "/" + src;

            result += "if (!" + LOADED_SCRIPTS + "['" + src + "']) {\n  " +
                                LOADED_SCRIPTS + "['" + src + "'] = true;\n  " +
                "document.write('<script src=\"" + src + "\">" +
                "</script>');\n}\n";
        }

        return result;
    }

    // determine relative path to inject for loadScriptTagFiles.js file
    private static String getPageRelativeModulePath(LinkerContext context) {
        String moduleName = context.getModuleName();

        // extract the multi-value config property scriptInjector.pageRelativeModulePath
        List<String> pathBindings = null;
        for (ConfigurationProperty property : context.getConfigurationProperties()) {
            if (PAGE_RELATIVE_MODULE_PATH.equals(property.getName())) {
                pathBindings = property.getValues();
            }
        }
        if (pathBindings == null) return moduleName;

        // locate binding in value set for this module
        for (String binding : pathBindings) {
            String[] parts = binding.split("=");
            // syntax: moduleName=foo/bar where foo/bar is relative path from HTML location
            if (parts.length == 2 && moduleName.equals(parts[0])) {
                System.out.println("      Setting page-relative module path for module '" +
                                   moduleName + "' using gwt.xml config");
                return parts[1];
            }
        }
        
        return moduleName;
    }

    public String getDescription() {
        return "ScriptInjector";
    }

    protected SyntheticArtifact emitString(TreeLogger logger, String what, String partialPath,
                                           LinkerContext context)
        throws UnableToCompleteException
    {
        if (context.isOutputCompact()) what = what.replaceAll("\n\\s*", "");
        return super.emitString(logger, what, partialPath);
    }

    public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts,
                            boolean permutation) throws UnableToCompleteException 
    {
        Float gwtVersion = Float.parseFloat(About.getGwtVersionNum().
                                            replaceFirst("([0-9]+\\.[0-9]+).*", "$1"));
        String moduleName = context.getModuleName();

        // bail out for permutation phase
        if (permutation) return artifacts;

        // script loader is called unconditionally, so create it now
        Artifact scriptLoader = emitString(logger, "", SCRIPT_LOADER);
        ArtifactSet toReturn = new ArtifactSet(artifacts);
        toReturn.add(scriptLoader);        

        // bail out if primary linker already handles script injection automatically
        if (gwtVersion < 2.5f || !forceScriptLoad(logger, moduleName, gwtVersion)) {
            return toReturn;
        }

        // bail out if there are no script tags to insert in script loader
        Set<ScriptReference> scripts = toReturn.find(ScriptReference.class);
        if (scripts.size() == 0) return toReturn;

        // script tags are present, and manual load required; emit script loading
        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            if (!partialPath.endsWith(moduleName + ".nocache.js")) continue;

            System.out.println(LINKER_ANNOUNCE);

            // the path to the module depends upon the specific linker context
            String pageRelativeModulePath = getPageRelativeModulePath(context);

            System.out.println(LOADER_ANNOUNCE);

            // add call to script loader to <moduleName>.nocache.js artifact
            toReturn.remove(emittedArtifact);
            String nocacheJS = SmartGwtLinkerUtils.getContents(emittedArtifact, logger);
            nocacheJS += getScriptLoaderJS(pageRelativeModulePath);
            toReturn.add(emitString(logger, nocacheJS, partialPath, context));

            // write out script loader
            toReturn.remove(scriptLoader);
            String loadTags = getScriptLoadJS(scripts, pageRelativeModulePath);
            toReturn.add(emitString(logger, loadTags, SCRIPT_LOADER, context));

            break;
        }

        return toReturn;
    }
}
