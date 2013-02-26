package com.smartgwt.tools;


import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildDebugModule {

    private static final Set<String> seenSet = new HashSet<String>();

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
        basePath += "smartclientSDK/source/client/modules/";

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
            hd.characters("\n    ".toCharArray(), 0, 5);
            atts.clear();
            atts.addAttribute("", "", "name", "CDATA", "com.smartclient.SmartClientNoScript");
            hd.startElement("", "", "inherits", atts);
            hd.endElement("", "", "inherits");
            for (int i = 0; i < nodes.getLength(); i++) {
                String jsFileName = nodes.item(i).getTextContent();
                if (jsFileName.indexOf("/") != -1)
                    jsFileName = jsFileName.substring(jsFileName.lastIndexOf("/"), jsFileName.length());

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
            hd.characters("\n".toCharArray(), 0, 1);
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
        List<String> result = new ArrayList<String>();

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
                            final String r = "sc/client/" + matcher.group(1) + ".js";
                            if (!seenSet.contains(r)) {
                                seenSet.add(r);
                                result.add(r);
                            }
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
        System.out.println("Example: <path to SmartClientDefault.gwt.xml> <SC_HOME> <path to SmartClientDebug.gwt.xml>\n");
    }

}
