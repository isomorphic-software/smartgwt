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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildDebugModule {

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
            for (int i = 0; i < nodes.getLength(); i++) {
                String jsFileName = nodes.item(i).getTextContent();
                if (jsFileName.indexOf("/") != -1)
                    jsFileName = jsFileName.substring(jsFileName.lastIndexOf("/"), jsFileName.length());

                System.out.println("Processing \"" + jsFileName + "\" ...");
                hd.characters("\n     ".toCharArray(), 0, 5);
                hd.characters("\n     ".toCharArray(), 0, 5);
                atts.clear();
                atts.addAttribute("", "", "src", "CDATA", "sc/modules-debug" + jsFileName);
                hd.startElement("", "", "script", atts);
                hd.endElement("", "", "script");
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

    private static void printUsage() {
        System.out.println("Builds GWT module xml with all Smartclient JavaScripts included\n");
        System.out.println("Parameters: {source GWT module} {base path} {output file}\n");
        System.out.println("Example: <path to SmartClientDefault.gwt.xml> <SC_HOME> <path to SmartClientDebug.gwt.xml>\n");
    }

}
