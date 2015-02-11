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

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.UnableToCompleteException;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;

public class SmartGwtLinkerUtils {
    /**
     * Returns the contents of the artifact as a String.
     * @param emittedArtifact the artifact
     * @param logger the logger
     * @return contents of the artifact
     * @throws UnableToCompleteException
     */
    static String getContents(EmittedArtifact emittedArtifact, TreeLogger logger) throws UnableToCompleteException {
        InputStream in = emittedArtifact.getContents(logger);
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            int result = bis.read();
            while (result != -1) {
                byte b = (byte) result;
                buf.write(b);
                result = bis.read();

            }
        } catch (IOException e) {
            logger.log(TreeLogger.ERROR, "Unable to read resource load_skin.js", e);
            throw new UnableToCompleteException();
        }
        return buf.toString();
    }
}
