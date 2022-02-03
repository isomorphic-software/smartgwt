/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2021 and beyond, Isomorphic Software, Inc.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Set;

@Shardable
@LinkerOrder(LinkerOrder.Order.POST)
public class SmartGwtMultiWinTypeSync extends AbstractLinker {

    private static Class XSI_LINKER_CLASS = CrossSiteIframeLinker.class;
    private static Class MODULE_DEF_LOADER_CLASS = ModuleDefLoader.class;
    private static String COMPILER_CONTEXT = "com.google.gwt.dev.CompilerContext";

    private static String LINKER_ANNOUNCE = "   Invoking Linker SmartGwtMultiWinTypeSync";

    public String getDescription() {
        return "MultiWindow Type Synchronizer";
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
        String moduleName = context.getModuleName();

        // bail out for permutation phase
        if (permutation) return artifacts;

        System.out.println(LINKER_ANNOUNCE);

        ArtifactSet toReturn = new ArtifactSet(artifacts);

        // script tags are present, and manual load required; emit script loading
        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            if (!partialPath.endsWith(".cache.js")) continue;

            String codeJS = applyTypeMarkerFuncPatch(emittedArtifact, logger);
            if (codeJS != null) {
                toReturn.remove(emittedArtifact);                
                toReturn.add(emitString(logger, codeJS, partialPath, context));
                System.out.println("Successfully patched artifact at " + partialPath);
            } else {
                System.out.println("Unable to patch artifact at " + partialPath);
            }
        }

        return toReturn;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Logic to locate and patch the typeMarkerFn JS function, even if inlined and obfuscated

    public static final String TYPE_MARKER_FUNC = "typeMarkerFn";

    public static final String MULTIWINDOW = "$wnd.isc.MultiWindow";

    public static final String FUNC_BODY_REGEX =
        "\\s*\\([^{]*\\{[^}]*?([A-Za-z0-9_$]+)(\\([^)]*\\))?[\\s);]*\\}";

    public static final String TYPE_CALL_REGEX =
        "\\('\\$\\$\\$ multiWindowTypeFix: '[^;]*?([A-Za-z0-9_$]+)\\([^()]*\\)[^A-Za-z_()]*\\)";

    public static class NextSearchTarget {
        String identifier;
        boolean isFunction;

        public NextSearchTarget(String identifier, boolean isFunction) {
            this.identifier = identifier; this.isFunction = isFunction;
        }
    }

    private String applyTypeMarkerFuncPatch(EmittedArtifact emittedArtifact,
                                            TreeLogger logger)
        throws UnableToCompleteException
    {
        String contents = SmartGwtLinkerUtils.getContents(emittedArtifact, logger);

        // first, locate the special invocation of instanceof JavaScriptObject
        Matcher matcher = Pattern.compile(TYPE_CALL_REGEX).matcher(contents);
        if (!matcher.find(0)) return null;

        // now, attempt to iterate through the function calls to max depth
        NextSearchTarget target;
        for (target = findNextSearchTarget(matcher.group(1), contents);
             target != null && target.isFunction;
             target = findNextSearchTarget(target.identifier, contents));
        if (target == null) return null;

        String targetID = target.identifier;

        // we should now have the ID of the TypeMarkerFn function
        int markerPos = findTypeMarkerFuncByName(targetID, contents);
        if (markerPos < 0) return null;

        return contents.substring(0, markerPos) +
            "\nif (" + MULTIWINDOW + " && !" + MULTIWINDOW + ".isMainWindow()) {\n    " +
            targetID + " = " + MULTIWINDOW + ".baseWindow.isc.gwtWnd." + targetID + ";\n" +
            "}\n" +
            contents.substring(markerPos);        
    }

    private int findTypeMarkerFuncByName(String funcName, String contents) {
        String funcRegEx = "function\\s+" + Pattern.quote(funcName) +
            "\\s*\\(\\)[\\{\\s\n]*\\}";
        Matcher matcher = Pattern.compile(funcRegEx).matcher(contents);
        if (matcher.find(0)) {
            int end = matcher.end();
            if (end < 0.05 * contents.length()) return end;
        }
        return -1;
    }

    private NextSearchTarget findNextSearchTarget(String funcName, String contents) {
        String funcRegEx = "function " + Pattern.quote(funcName) + FUNC_BODY_REGEX;
        Matcher matcher = Pattern.compile(funcRegEx).matcher(contents);
        return !matcher.find(0) ? null :
            new NextSearchTarget(matcher.group(1), matcher.group(2) != null);
    }
    
}
