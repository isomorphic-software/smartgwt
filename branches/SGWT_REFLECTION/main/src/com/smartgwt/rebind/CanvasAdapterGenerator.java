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

package com.smartgwt.rebind;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.*;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.smartgwt.client.bean.RegisterAllCanvas;
import com.smartgwt.client.widgets.Canvas;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Generator that triggers the generation of property metadata registration of all Canvas subclasses present in the classpath.
 */
public class CanvasAdapterGenerator extends Generator {
    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {
        TypeOracle oracle = context.getTypeOracle();

        //marker interface is Canvas
        JClassType instantiableType = oracle.findType(Canvas.class.getName());

        List<JClassType> clazzes = new ArrayList<JClassType>();

        for (JClassType classType : oracle.getTypes()) {
            if (classType.isAssignableTo(instantiableType)) {
                clazzes.add(classType);
            }
        }

        final String genPackageName = "com.smartgwt.client";
        final String genClassName = "AllCanvasAdapterGenerator";

        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(genPackageName, genClassName);
        composer.addImplementedInterface(RegisterAllCanvas.class.getCanonicalName());

        composer.addImport("com.smartgwt.client.*");
        composer.addImport("com.google.gwt.core.client.GWT");

        PrintWriter printWriter = context.tryCreate(logger, genPackageName, genClassName);

        if (printWriter != null) {
            SourceWriter sourceWriter = composer.createSourceWriter(context, printWriter);
            sourceWriter.println("AllCanvasAdapterGenerator( ) {");
            sourceWriter.println("}");
            printFactoryMethod(clazzes, sourceWriter);
            sourceWriter.commit(logger);
        }
        return composer.getCreatedClassName();
    }

    private void printFactoryMethod(List<JClassType> clazzes, SourceWriter sourceWriter) {
        sourceWriter.println();
        sourceWriter.println("static {");

        for (JClassType classType : clazzes) {
            if (classType.isAbstract())
                continue;

            boolean hasDefaultConstructor = false;

            try {
                JConstructor constructor = classType.getConstructor(new JType[]{});
                hasDefaultConstructor = true;
            } catch (NotFoundException e) {
            }

            if (hasDefaultConstructor) {
                sourceWriter.println();
                sourceWriter.println("GWT.create(" + classType.getQualifiedSourceName() + ".class);");
            }
        }
        sourceWriter.println("}");
        sourceWriter.outdent();
        sourceWriter.println();
    }
}
