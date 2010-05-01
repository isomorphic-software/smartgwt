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

package com.smartgwt.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;


public class BuildDebugModule {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            printUsage();
            System.exit(1);
        }

        String srcFileName = args[0];
        String basePath = args[1];
        if (!basePath.endsWith(File.separator)) {
            basePath += File.separator;
        }
        String destFileName = args[2];

        try {
            System.out.println("Parsing " + srcFileName + " ...");

            XPath xpath = XPathFactory.newInstance().newXPath();
            InputSource src = new InputSource(srcFileName);
            NodeList nodes = (NodeList) xpath.evaluate("/module/script/@src", src, XPathConstants.NODESET);

            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler hd = tf.newTransformerHandler();
            Transformer serializer = hd.getTransformer();
            serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

            hd.setResult(new StreamResult(new File(destFileName)));
            hd.startDocument();
            AttributesImpl atts = new AttributesImpl();
            hd.startElement("", "", "module", atts);
            for (int i = 0; i < nodes.getLength(); i++) {
                String jsFileName = nodes.item(i).getTextContent();
                System.out.println("Processing \"" + jsFileName + "\" ...");
                String[] includes = getIncludes(basePath, jsFileName);
                hd.characters("\n     ".toCharArray(), 0, 5);
                hd.comment((" " + jsFileName + " ").toCharArray(), 0, jsFileName.length() + 2);
                for (int j = 0; j < includes.length; j++) {
                    hd.characters("\n     ".toCharArray(), 0, 5);
                    atts.clear();
                    atts.addAttribute("", "", "src", "CDATA", includes[j]);
                    hd.startElement("", "", "script", atts);
                    hd.endElement("", "", "script");
                }
            }
            hd.characters("\n".toCharArray(), 0, 1);
            hd.endElement("", "", "module");
            hd.endDocument();
            System.out.println("\nFinished");

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    private static String[] getIncludes(String basePath, String jsFileName) throws Exception {
        System.getProperties().list(System.out);
        // List of files to include
        ArrayList<String> result = new ArrayList<String>();

        // Open file for reading
        FileInputStream fis = new FileInputStream(basePath + jsFileName.replace("/", File.separator));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        int state = 0;
        int newState = 0;

        Pattern pLib = Pattern.compile("^\\s*\"([^\"]+)\".*");

        String line = br.readLine();
        while ((line != null) && (state != 3)) {
            state = newState;
            switch (state) {

                // Looking for "var libs ="
                case 0:
                    if (line.matches("^\\s*var\\s+libs\\s*=\\s*$")) {
                        newState = 1;
                    }
                    break;

                // Looking for "["
                case 1:
                    if (line.matches("^\\s*\\[\\s*$")) {
                        newState = 2;
                    }
                    break;


                // Reading libraries
                case 2:
                    // Stop when we reach "];"
                    if (line.matches("^\\s*\\];\\s*$")) {
                        newState = 3;
                    } else {
                        Matcher matcher = pLib.matcher(line);
                        while (matcher.find()) {
                            System.out.println("  Found \"" + matcher.group(1) + "\"");
                            result.add("sc/client/" + matcher.group(1) + ".js");
                        }
                    }
                    break;
            }
            line = br.readLine();
        }

        // if no libs were found, include the source file itself
        if (result.size() == 0) {
            result.add(jsFileName);
        }

        String arr[] = new String[result.size()];
        result.toArray(arr);
        return arr;
    }

    private static void printUsage() {
        System.out.println("Builds GWT module xml with all Smartclient JavaScripts included\n");
        System.out.println("Parameters: {source GWT module} {base path} {output file}\n");
        System.out.println("Example: SmartClientDebug.gwt.xml C:\\SmartClient\\public SmartClientDebugIE.gwt.xml\n");
    }

}
