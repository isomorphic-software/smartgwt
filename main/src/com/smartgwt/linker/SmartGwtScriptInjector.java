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
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.Artifact;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.ScriptReference;

import com.google.gwt.dev.About;
import com.google.gwt.dev.cfg.ModuleDef;
import com.google.gwt.dev.cfg.ModuleDefLoader;
import com.google.gwt.core.linker.CrossSiteIframeLinker;

import java.lang.reflect.Method;
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
            } else {
                Class compilerContextClass = Class.forName(COMPILER_CONTEXT);
                getModuleDef = MODULE_DEF_LOADER_CLASS.getDeclaredMethod("loadFromClassPath",
                         new Class[] {TreeLogger.class, compilerContextClass, String.class});
                module = (ModuleDef)getModuleDef.invoke(null, logger, null, moduleName);
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

    private static String XSI_LINKER_MODULE_BASE = "__moduleBase";
    private static String LOADED_SCRIPTS = "__gwt_scriptsLoaded";
    private static String SCRIPT_ANNOUNCE = "   Invoking Linker SmartGwtScriptInjector\n" +
        "      Augmenting module.nocache.js to manually load the following script tags:";

    private String getScriptLoadJS(Set<ScriptReference> scriptsToLoad, LinkerContext context) {
        String moduleName = context.getModuleName();
        System.out.println(SCRIPT_ANNOUNCE.replaceFirst("module", moduleName));

        String result = "\nif (!window." + LOADED_SCRIPTS + ") " + 
                               "window." + LOADED_SCRIPTS + " = {};\n";
        for (ScriptReference script : scriptsToLoad) {
            String src = script.getSrc();
            result += "if (!" + LOADED_SCRIPTS + "['" + src + "']) {\n  " +
                                LOADED_SCRIPTS + "['" + src + "'] = true;\n  " +
                "document.write('<script language=\"javascript\" src=\"'+" + 
                moduleName + "." + XSI_LINKER_MODULE_BASE + "+'" + src + "\"></script>');\n" +
                "}\n";
            System.out.println(src);
        }
        result += "\n";

        return context.isOutputCompact() ? result.replaceAll("\n\\s*", "") : result;
    }

    public String getDescription() {
        return "ScriptInjector";
    }

    public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts,
                            boolean permutation) throws UnableToCompleteException 
    {
        Float gwtVersion = Float.parseFloat(About.getGwtVersionNum().
                                            replaceFirst("([0-9]+\\.[0-9]+).*", "$1"));
        String moduleName = context.getModuleName();

        // do nothing if the primary linker already handles script injection automatically
        if (permutation || gwtVersion < 2.5f || !forceScriptLoad(logger, moduleName, gwtVersion))
        {
            return artifacts;
        }

        // if there are no script tags present, then there's nothing to do
        Set<ScriptReference> scripts = artifacts.find(ScriptReference.class);
        if (scripts.size() == 0) return artifacts;

        // script tags are present, and manual load required; emit script loading
        ArtifactSet toReturn = new ArtifactSet(artifacts);

        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            if (!partialPath.endsWith(".nocache.js")) continue;

            toReturn.remove(emittedArtifact);

            // add code at the end of the <moduleName>.nocache.js file to load the scripts
            String contents = SmartGwtLinkerUtils.getContents(emittedArtifact, logger);
            contents += getScriptLoadJS(scripts, context);

            StringBuffer sb = new StringBuffer(contents);
            toReturn.add(emitString(logger, sb.toString(), partialPath));
            break;
        }

        return toReturn;
    }
}
