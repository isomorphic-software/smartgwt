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

package com.smartgwt.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.linker.IFrameLinker;
import com.google.gwt.util.tools.Utility;

import java.io.IOException;

/**
 * Linker that inject domain sync Javascript to bypass same-origin policy restrictions on scripts
 * deployed on different subdomains under the same parent domain (eg. a portal environment)
 */
public class SmartGwtDomainSyncLinker extends IFrameLinker {

    private static final String SCRIPT_FILE = "com/smartgwt/linker/DomainSyncScript.js";

    @Override
    public String getDescription() {
        return "SmartGwtDomainSyncLinker";
    }

    protected String getModulePrefix(TreeLogger logger, LinkerContext context,
                                     String strongName) throws UnableToCompleteException {
        logger.log(TreeLogger.INFO, "Processing SmartGWT Domain Sync");
        String defaultModulePrefix = super.getModulePrefix(logger, context, strongName);
        return appendDomainScyncScript(defaultModulePrefix, logger);
    }

    @Override
    protected String getModulePrefix(TreeLogger logger, LinkerContext context,
                                     String strongName, int numFragments) throws UnableToCompleteException {
        logger.log(TreeLogger.INFO, "Processing SmartGWT Domain Sync");
        String defaultModulePrefix = super.getModulePrefix(logger, context, strongName, numFragments);
        return appendDomainScyncScript(defaultModulePrefix, logger);
    }

    private String appendDomainScyncScript(String defaultModulePrefix, TreeLogger logger) throws UnableToCompleteException {
        String domainSycnScript;
        try {
            domainSycnScript = Utility.getFileFromClassPath(SCRIPT_FILE);
        } catch (IOException e) {
            logger.log(TreeLogger.ERROR, "Unable to read file: " + SCRIPT_FILE, e);
            throw new UnableToCompleteException();
        }
        //append the domain sync code at the very beginning of the script
        return defaultModulePrefix.replaceFirst("<script>", "<script>\n" + domainSycnScript + "\n");
    }
}
