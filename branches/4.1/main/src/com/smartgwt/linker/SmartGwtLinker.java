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
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.LinkerOrder;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@LinkerOrder(LinkerOrder.Order.POST)
public class SmartGwtLinker extends AbstractLinker {

    public String getDescription() {
        return "SmartGwt";
    }

    public ArtifactSet link(TreeLogger logger, LinkerContext context, ArtifactSet artifacts)
            throws UnableToCompleteException {
        // Create a new set of artifacts that we can modify and return.
        ArtifactSet toReturn = new ArtifactSet(artifacts);

        Set<EmittedArtifact> emittedArtifacts = artifacts.find(EmittedArtifact.class);
        for (EmittedArtifact emittedArtifact : emittedArtifacts) {
            String partialPath = emittedArtifact.getPartialPath();
            // If encounter ISC_Core.js or Page.js (when inheriting SmartGwtDebug.gwt.xml),
            // inject the appropriate isomorphicDir var so that users don't need to explicitly
            // specify this in their host html file.
            if (partialPath.endsWith("/ISC_Core.js") || partialPath.endsWith("/Page.js")) {
                String contents = SmartGwtLinkerUtils.getContents(emittedArtifact, logger);
                int isoDirInd = contents.indexOf("/*#ISO_DIR#*/");
                if (isoDirInd >= 0) {
                    StringBuffer sb = new StringBuffer(contents);
                    sb.replace(isoDirInd, isoDirInd + "/*#ISO_DIR#*/".length(), 
                        "if(typeof isomorphicDir == 'undefined'){isomorphicDir = '" +
                               context.getModuleName() + "/sc/';}\n");

                    toReturn.remove(emittedArtifact);
                    toReturn.add(emitString(logger, sb.toString(), partialPath));
                }
            }
        }
        return toReturn;
    }
}
