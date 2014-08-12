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

package com.smartgwt.client;

import com.google.gwt.regexp.shared.RegExp;

public class SmartGwtExceptionUtil {

    // handle and attach GWT-generated Throwable stack

    private static final String UNKNOWN = "Unknown";

    private static boolean hasStackTrace(String message) {
        RegExp expression = RegExp.compile("stack:\\s+");
        return expression.test(message);
    }

    // handle dumping GWT-specific StackTraceElements
    private static String stackTraceElementToString(StackTraceElement element) {
        String methodName = element.getMethodName();
        if (methodName == null || UNKNOWN.equals(methodName)) return null;

        String frame = "    at ";

        String className = element.getClassName();
        if (className != null && !UNKNOWN.equals(className)) frame += className + ".";

        frame += methodName + "(";

        String fileName = element.getFileName();
        if (fileName != null && !UNKNOWN.equals(fileName)) {
            frame += fileName;
                
            int lineNumber = element.getLineNumber();
            if (lineNumber >= 0) frame += ":" + lineNumber;
        }
        frame += ")";

        return frame;
    }

    private static String getStackTrace(Throwable throwable) {
        String trace = "";

        StackTraceElement[] stack = throwable.getStackTrace();
        for (int i = 0; i < stack.length; i++) {
            if (i > 0) trace += "\n";
            String frame = stackTraceElementToString(stack[i]);
            if (frame != null) trace += frame;
        }
        return trace;
    }

    protected static String toString(String message, Throwable throwable) {
        if (hasStackTrace(message)) {
            // remove duplicate description at end of message
            return message.replaceFirst("\\)[^)\r\n]*$", ")");
        } else {
            return message + "\n" + getStackTrace(throwable);
        }
    }

    protected static String toString(Throwable throwable) {
        return toString(throwable.toString(), throwable);
    }
}
