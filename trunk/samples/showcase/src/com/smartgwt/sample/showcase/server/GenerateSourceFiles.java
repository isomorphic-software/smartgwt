package com.smartgwt.sample.showcase.server;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class GenerateSourceFiles {
    
//--------------------------------------------------------------------------------------------------

private static final String[]           ClassesToSkip          = new String[] {"public static class Factory"};
private static final Pattern            EndOfFieldPattern1     = Pattern.compile(".*; *");
private static final Pattern            EndOfFieldPattern2     = Pattern.compile(".*;.*//.*");
private static final String[]           FieldsToSkip           = new String[] {"private static final String DESCRIPTION"};
private static final String[]           LinesToSkip            = new String[] {"package com.smartgwt",
        "import com.smartgwt.sample.showcase.client.PanelFactory", "import com.smartgwt.sample.showcase.client.ShowcasePanel"
};
private static final String[]           MethodsToSkip          = new String[] {
    "public String getIntro", "public String getSourceUrl"     };
private static final Pattern            ViewPanelReturnPattern = Pattern.compile("[ \t]*return.*");

// The _dataFileMap key is the class or data file name; the value is the path to the file
private static Map<String, String>      _dataFileMap;
// The _dataFilePathsMap key is the class name; the value is the list of data files
private static Map<String, Set<String>> _dataFilePathsMap;
private static int                      _showcaseClientDirLength;
private static String                   _showcaseDir;
private static String                   _sourceOutputDir;

//--------------------------------------------------------------------------------------------------

private enum ESourceFileType {
DataSource("extends DataSource"),
Sample("public Canvas getViewPanel"),
Unknown("");
private String _containsString;
private ESourceFileType(final String containsString) {
  _containsString = containsString;
} // ESourceFileType()
private static ESourceFileType lookup(final String line) {
  ESourceFileType result = ESourceFileType.Unknown;
  for (ESourceFileType sourceFileType : ESourceFileType.values()) {
    if (line.contains(sourceFileType._containsString)) {
      result = sourceFileType;
      break;
    }
  }
  return result;
} // lookup()
} // enum ESourceFileType

//--------------------------------------------------------------------------------------------------

private static void checkForDataFile(final String line, final String className) {
  boolean matchFound = false;
  for (Map.Entry<String, String> dataFileMapEntry : _dataFileMap.entrySet()) {
    matchFound = line.contains(dataFileMapEntry.getKey());
    if (matchFound) {
      Set<String> dataFilePathSet = _dataFilePathsMap.get(className);
      if (dataFilePathSet == null) {
        dataFilePathSet = new TreeSet<String>();
      }
      dataFilePathSet.add(dataFileMapEntry.getValue());
      _dataFilePathsMap.put(className, dataFilePathSet);
      break;
    }
  }
} // checkForDataFile()

//--------------------------------------------------------------------------------------------------

private static int checkSkipEntries(final List<String> sourceLineList, final int lineIndex) {
  int result = lineIndex;
  String line = sourceLineList.get(result);
  boolean matchFound = false;
  for (String methodToSkip : MethodsToSkip) {
    matchFound = line.contains(methodToSkip);
    if (matchFound) {
      result = skipBlock(sourceLineList, lineIndex);
      break;
    }
  }
  for (String classToSkip : ClassesToSkip) {
    matchFound = line.contains(classToSkip);
    if (matchFound) {
      result = skipBlock(sourceLineList, result);
      break;
    }
  }
  if (!matchFound) {
    for (String fieldToSkip : FieldsToSkip) {
      matchFound = line.contains(fieldToSkip);
      if (matchFound) {
        while (!EndOfFieldPattern1.matcher(line).matches() &&
               !EndOfFieldPattern2.matcher(line).matches()) {
          line = sourceLineList.get(++result);
        }
        ++result;
        break;
      }
    }
  }
  if (!matchFound) {
    for (String lineToSkip : LinesToSkip) {
      matchFound = line.contains(lineToSkip);
      if (matchFound) {
        ++result;
        break;
      }
    }
  }
  return result;
} // checkSkipEntries()

//--------------------------------------------------------------------------------------------------

private static PrintWriter createOutputHTMLFile(final String sourceFileDirName,
                                                final String targetSourceFilePath) throws Exception {
  PrintWriter result;
  String targetDir;
  targetDir = targetSourceFilePath.substring(0, targetSourceFilePath.lastIndexOf('/'));
  new File(targetDir).mkdirs();
  result = new PrintWriter(targetSourceFilePath);
  writeStartOfHTMLFile(result, sourceFileDirName);
  return result;
} // createOutputHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void generateDataHTMLFile(final String sourceFilePath,
                                         final String targetFilePath) {
  String targetDir;
  targetDir = targetFilePath.substring(0, targetFilePath.lastIndexOf('/'));
  new File(targetDir).mkdirs();
  try {
    PrintWriter sourceWriter = createOutputHTMLFile(sourceFilePath, targetFilePath);
    writeStartOfDataHTMLFile();
    BufferedReader reader;
    reader = new BufferedReader(new FileReader(sourceFilePath));
    try {
      String line;
      do {
        line = reader.readLine();
        if (line != null) {
          sourceWriter.println(line);
        }
      } while (line != null);
    }
    finally {
      reader.close();
    }
    writeEndOfHTMLFile(sourceWriter);
    sourceWriter.close();
  }
  catch (Exception e) {
    System.err.println("Error creating data HTML file " + targetFilePath + " [" +
                       e.getMessage() + "]");
  }
} // generateDataHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void generateDataURLRecordsClass() {
  try {
    PrintWriter writer = new PrintWriter(_showcaseDir + "/DataURLRecords.java");
    writer.println("package com.smartgwt.sample.showcase.client;");
    writer.println("// This file is automatically generated. Do not modify it manually.");
    writer.println("import java.util.TreeMap;");
    writer.println("class DataURLRecords {");
    writer.println("private static TreeMap<String, String[]> _dataURLsMap;");
    writer.println("private static final DataURLRecord[] _dataURLRecords = new DataURLRecord[] {");
    int dataFilePathsCount = 0;
    for (Map.Entry<String, Set<String>> dataFilePathsEntry : _dataFilePathsMap.entrySet()) {
      if (dataFilePathsCount > 0) writer.println(",");
      writer.print("new DataURLRecord(\"" + dataFilePathsEntry.getKey() + "\",");

      int pathCount = 0;

      Set<String> pathsToAdd = new TreeSet<String>();
      Set<String> pathsPossiblyToAdd = new TreeSet<String>(dataFilePathsEntry.getValue());
      Set<String> tmpAddSet = new TreeSet<String>();
      
      while (!pathsPossiblyToAdd.isEmpty()) {
          Iterator<String> pathWriteIterator=pathsPossiblyToAdd.iterator();
          while (pathWriteIterator.hasNext()) {
              String dataFilePath=pathWriteIterator.next();
              if (!pathsToAdd.contains(dataFilePath)) {
                  pathsToAdd.add(dataFilePath);
                  
                  String className=new String(dataFilePath);
                  className = className.replaceAll("([^/]*/)*", "");
                  className = className.replaceAll("\\.java", "");
                  System.err.println(dataFilePathsEntry.getKey() + ": "+dataFilePath + "-->" + className);
                  
                  Iterator<String> recursivePathIterator=null;
                  if (_dataFilePathsMap.containsKey(className))
                      recursivePathIterator=_dataFilePathsMap.get(className).iterator();
                  if (recursivePathIterator != null) while (recursivePathIterator.hasNext()) {
                      String newPath=recursivePathIterator.next();
                      if (!pathsToAdd.contains(newPath) && !tmpAddSet.contains(newPath))
                          tmpAddSet.add(newPath);
                  }
              }
          }
          pathsPossiblyToAdd.clear();
          pathsPossiblyToAdd.addAll(tmpAddSet);
          tmpAddSet.clear();
      }
      
      Iterator<String> pathWriteIterator=pathsToAdd.iterator();
      while (pathWriteIterator.hasNext()) {
          String dataFilePath=pathWriteIterator.next();
          writer.print(++pathCount == 1 ? "" : ",");
          writer.print('"' + dataFilePath + '"');
      }

      writer.print(")");
      ++dataFilePathsCount;
    }
    writer.println("};");
    writer.println("private static class DataURLRecord {");
    writer.println("private String _className;");
    writer.println("private String[] _urls;");
    writer.println("private DataURLRecord(String className, String... urls) {");
    writer.println("  _className = className;");
    writer.println("  _urls = urls;");
    writer.println("} // DataURLRecord()");
    writer.println("} // class DataURLRecord");
    writer.println("static String[] getDataURLs(final String className) {");
    writer.println("  if (_dataURLsMap == null) {");
    writer.println("    _dataURLsMap = new TreeMap<String, String[]>();");
    writer.println("    for (DataURLRecord dataURLRecord : _dataURLRecords) {");
    writer.println("      _dataURLsMap.put(dataURLRecord._className, dataURLRecord._urls);");
    writer.println("    }");
    writer.println("  }");
    writer.println("  return _dataURLsMap.get(className);");
    writer.println("} // getDataURLs()");
    writer.println("}");
    writer.close();
  }
  catch (Exception e) {
    System.err.println("Error attempting to write data URL file (" + e.getMessage() + ")");
    e.printStackTrace();
  }
} // generateDataURLRecordsClass()

//--------------------------------------------------------------------------------------------------

private static void generateFile(final String sourceFileDirName, final String className) {
  String sourceFilePath = sourceFileDirName + "/" + className + ".java";
  String targetSourceFilePath = _sourceOutputDir +
                                sourceFileDirName.substring(_showcaseClientDirLength) + "/" +
                                className + ".java.html";
  try {
    List<String> sourceLineList = new ArrayList<String>();
    ESourceFileType sourceFileType;
    sourceFileType = loadFileIntoStringList(sourceFilePath, sourceLineList, className);
    if (sourceFileDirName.endsWith("com/smartgwt/sample/showcase/client/data")) {
      sourceFileType = ESourceFileType.DataSource;
    }
    switch (sourceFileType) {
      case DataSource:
        generateJavaDataHTMLFile(sourceFileDirName, sourceLineList, targetSourceFilePath);
        break;
      case Sample:
        generateSampleHTMLFile(sourceFileDirName, className, sourceLineList, targetSourceFilePath);
        break;
      case Unknown:
        break;
    }
  }
  catch (Exception e) {
    System.err.println("Error attempting to generate HTML for: " + sourceFilePath + " (" +
                       e.getMessage() + ")");
    e.printStackTrace();
  }
} // generateFile()

//--------------------------------------------------------------------------------------------------

private static void generateJavaDataHTMLFile(final String sourceFileDirName,
                                             final List<String> sourceLineList,
                                             final String targetSourceFilePath) throws Exception {
  String targetDir;
  targetDir = targetSourceFilePath.substring(0, targetSourceFilePath.lastIndexOf('/'));
  new File(targetDir).mkdirs();
  PrintWriter sourceWriter = createOutputHTMLFile(sourceFileDirName, targetSourceFilePath);
  writeStartOfDataHTMLFile();
  for (String line : sourceLineList) {
    sourceWriter.println(line);
  }
  writeEndOfHTMLFile(sourceWriter);
  sourceWriter.close();
} // generateJavaDataHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void generateSampleHTMLFile(final String sourceFileDirName, final String className,
                                           final List<String> sourceLineList,
                                           final String targetSourceFilePath) throws Exception {
  String prevLine = "";
  boolean inComment = false;
  PrintWriter sourceWriter = null;
  for (int lineIndex = 0; lineIndex < sourceLineList.size();) {
    String line = sourceLineList.get(lineIndex);
    boolean generateOutput = true;
    if (inComment) {
      inComment = !line.contains("*/");
    } else if (line.contains("/*")) {
      inComment = true;
    }
    else if (line.contains(" extends ShowcasePanel")) {
      line = "public class " + className + " implements EntryPoint {";
    }
    else if (line.contains("public Canvas getViewPanel")) {
      lineIndex = outputGetViewPanel(sourceLineList, lineIndex, sourceWriter);
      generateOutput = false;
    }    
    else {
      int oldLineIndex = lineIndex;
      lineIndex = checkSkipEntries(sourceLineList, lineIndex);
      generateOutput = lineIndex == oldLineIndex;
    }
    if (generateOutput) {
      if (sourceWriter == null) {
        sourceWriter = createOutputHTMLFile(sourceFileDirName, targetSourceFilePath);
        writeStartOfSampleHTMLFile(sourceWriter);
      }
      if (line.length() > 0 || prevLine.length() > 0) {
        sourceWriter.println(line);
        prevLine = line;
      }
      ++lineIndex;
    }
  }
  if (sourceWriter != null) {
    writeEndOfHTMLFile(sourceWriter);
    sourceWriter.close();
  }
} // generateSampleHTMLFile()

//--------------------------------------------------------------------------------------------------

private static Set<String> loadDataDirNames(final String... args) {
  Set<String> result = new HashSet<String>();
  result.add(_showcaseDir + "/../../../../../../war/data");
  result.add(_showcaseDir + "/../../../../../../war/ds");
  result.add(_showcaseDir + "/data");
  for (int argIndex = 2; argIndex < args.length; ++argIndex) {
    String dataDir = args[argIndex].replace("\\\\", "/").replace("\\", "/");
    result.add(dataDir);
  }
  return result;
} // loadDataDirNames()

//--------------------------------------------------------------------------------------------------

private static void loadDataFileOrClassNames(final File fileOrDirectory) throws IOException {
  if (fileOrDirectory.isDirectory()) {
    if (!fileOrDirectory.getName().startsWith(".")) {
      File[] files = fileOrDirectory.listFiles();
      for (File directoryEntry : files) {
        loadDataFileOrClassNames(directoryEntry);
      }
    }
  }
  else {
    String fileName = fileOrDirectory.getName();
    if (!fileName.endsWith(".class")) {
      String fileOrClassName;
      String fileOrClassPath = fileOrDirectory.getPath().replace('\\', '/');
      if (fileName.endsWith(".java")) {
        fileOrClassName = fileName.substring(0, fileName.lastIndexOf('.'));
        fileOrClassPath = fileOrClassPath.substring(_showcaseClientDirLength + 1);
      }
      else {
        fileOrClassName = fileName;
        int publicIndex = fileOrClassPath.indexOf("war");
        fileOrClassPath = "data_files/" + fileOrClassPath.substring(publicIndex + 7);
        generateDataHTMLFile(fileOrDirectory.getPath().replace('\\', '/'),
                             _sourceOutputDir + "/" + fileOrClassPath + ".html");
      }
      _dataFileMap.put(fileOrClassName, fileOrClassPath);
    }
  }
} // loadDataFileOrClassNames()
//--------------------------------------------------------------------------------------------------

private static ESourceFileType loadFileIntoStringList(final String filePath,
                                                      final List<String> sourceLineList,
                                                      final String className) throws IOException {
  ESourceFileType result = ESourceFileType.Unknown;
  BufferedReader reader;
  reader = new BufferedReader(new FileReader(filePath));
  try {
    String line;
    do {
      line = reader.readLine();
      if (line != null) {
        checkForDataFile(line, className);
        sourceLineList.add(line);
        if (result == ESourceFileType.Unknown) {
          result = ESourceFileType.lookup(line);
        }
      }
    } while (line != null);
  }
  finally {
    reader.close();
  }
  return result;
} // loadFileIntoStringList()

//--------------------------------------------------------------------------------------------------

public static void main(final String... args) {
  if (args.length < 2) {
    System.err.println("The first parameter is the showcase client directory");
    System.err.println(" (e.g., c:/Smart GWT/Showcase/com/smartgwt/sample/showcase/client)");
    System.err.println("The second parameter is the source HTML root directory");
    System.err.println(" (e.g., c:/Smart GWT/Showcase/com/smartgwt/sample/showcase/public/source)");
    System.err.println("Subsequent parameters are directories that contain data or data source");
    System.err.println(" files. The following files are automatically included:");
    System.err.println("  .../com/smartgwt/sample/showcase/public/data");
    System.err.println("  .../com/smartgwt/sample/showcase/public/ds");
    System.err.println("  .../com/smartgwt/sample/showcase/client/data");
    System.exit(0);
  }
  _showcaseDir = args[0].replace("\\\\", "/").replace("\\", "/");
  _sourceOutputDir = args[1].replace("\\\\", "/").replace("\\", "/");
  Set<String> dataDirNameSet = loadDataDirNames(args);
  _showcaseClientDirLength = _showcaseDir.length();
  _dataFileMap = new TreeMap<String, String>();
  _dataFilePathsMap = new TreeMap<String, Set<String>>();
  try {
    for (String dataDir : dataDirNameSet) {
      loadDataFileOrClassNames(new File(dataDir));
    }
    processJavaFiles(new File(_showcaseDir));
    generateDataURLRecordsClass();
  }
  catch (IOException ioe) {
    System.err.println("Error processing showcase: " + ioe.getMessage());
  }
} // main()
//--------------------------------------------------------------------------------------------------

private static void processJavaFiles(final File fileOrDirectory) throws IOException {
  if (fileOrDirectory.isDirectory()) {
    File[] files = fileOrDirectory.listFiles();
    for (File directoryEntry : files) {
      processJavaFiles(directoryEntry);
    }
  }
  else if (fileOrDirectory.getName().endsWith(".java")) {
    String filePath = fileOrDirectory.getPath().replace("\\\\", "/").replace("\\", "/");
    int lastSlashIndex = filePath.lastIndexOf('/');
    String directoryName = filePath.substring(0, lastSlashIndex);
    String fileName = fileOrDirectory.getName();
    String className = fileName.substring(0, fileName.lastIndexOf('.'));
    generateFile(directoryName, className);
  }
} // processJavaFiles()

//--------------------------------------------------------------------------------------------------

private static int outputGetViewPanel(final List<String> sourceLineList, final int lineIndex,
                                      final PrintWriter sourceWriter) {
  int result = lineIndex;
  sourceWriter.println("    public void onModuleLoad() {");
  while (sourceLineList.get(result).indexOf('{') < 0) {
    ++result;
  }
  ++result;
  boolean returnFound;
  int openBraceCount = 1;
  String line = sourceLineList.get(result);
  do {
    int openBracesOnLine = 0;
    int braceIndex = 0;
    while (line.indexOf('{', braceIndex) >= 0) {
      ++openBracesOnLine;
      braceIndex = line.indexOf('{', braceIndex) + 1;
    }
    int closeBracesOnLine = 0;
    braceIndex = 0;
    while (line.indexOf('}', braceIndex) >= 0) {
      ++closeBracesOnLine;
      braceIndex = line.indexOf('}', braceIndex) + 1;
    }
    openBraceCount += openBracesOnLine - closeBracesOnLine;
    returnFound = openBraceCount == 1 && ViewPanelReturnPattern.matcher(line).matches();
    if (!returnFound) {
      sourceWriter.println(line);
      line = sourceLineList.get(++result);
    }
  } while (!returnFound);
  sourceWriter.println(line.replace("return ", "").replace(";", ".draw();"));
  ++result;
  return result;
} // outputGetViewPanel()

//--------------------------------------------------------------------------------------------------

private static int skipBlock(final List<String> sourceLineList, final int lineIndex) {
  int result = lineIndex;
  String line = sourceLineList.get(result);
  int openBraceCount = 0;
  while (line.indexOf('{') < 0) {
    line = sourceLineList.get(++result);
  }
  do {
    int openBracesOnLine = 0;
    int braceIndex = 0;
    while (line.indexOf('{', braceIndex) >= 0) {
      ++openBracesOnLine;
      braceIndex = line.indexOf('{', braceIndex) + 1;
    }
    int closeBracesOnLine = 0;
    braceIndex = 0;
    while (line.indexOf('}', braceIndex) >= 0) {
      ++closeBracesOnLine;
      braceIndex = line.indexOf('}', braceIndex) + 1;
    }
    openBraceCount += openBracesOnLine - closeBracesOnLine;
    if (openBraceCount > 0) {
      line = sourceLineList.get(++result);
    }
  } while (openBraceCount > 0);
  ++result;
  return result;
} // skipBlock()

//--------------------------------------------------------------------------------------------------

private static void writeEndOfHTMLFile(final PrintWriter sourceWriter) {
  sourceWriter.println("</textarea>");
  sourceWriter.println("<script class='javascript'>");
  sourceWriter.println("dp.SyntaxHighlighter.HighlightAll(\"code\");");
  sourceWriter.println("</script>");
  sourceWriter.println("</body>");
  sourceWriter.println("</html>");
} // writeEndOfHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void writeStartOfDataHTMLFile() {
  // nothing to write (currently)
} // writeStartOfDataHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void writeStartOfHTMLFile(final PrintWriter sourceWriter,
                                         final String sourceFileDirName) {
  int depth;
  if (sourceFileDirName.contains("/public/")) {
    depth = sourceFileDirName.substring(sourceFileDirName.indexOf("/public/")).split("/").length - 1;
  }
  else {
    depth = sourceFileDirName.substring(sourceFileDirName.indexOf("/com/")).split("/").length - 5;
  }
  String parentDirs = "";
  for (int i = 0; i < depth; i++) {
    parentDirs += "../";
  }
  sourceWriter.println("<html>");
  sourceWriter.println("<head>");
  sourceWriter.println("<link rel='stylesheet' href='" + parentDirs +
                       "js/sh/SyntaxHighlighter.css' type='text/css' />");
  sourceWriter.println("<script src='" + parentDirs + "js/sh/shCore.js'></script>");
  sourceWriter.println("<script src='" + parentDirs + "js/sh/shBrushJava.js'></script>");
  sourceWriter.println("<style>");
  sourceWriter.println("* {");
  sourceWriter.println("font-family:Courier New,monospace;");
  sourceWriter.println("  padding: 0;");
  sourceWriter.println("  margin: 0;");
  sourceWriter.println("  white-space: nowrap;");
  sourceWriter.println("  font-size: 11px;");
  sourceWriter.println("}");
  sourceWriter.println(".dp-highlighter {");
  sourceWriter.println("  white-space: nowrap;");
  sourceWriter.println("  overflow: visible;");
  sourceWriter.println("  width: 600px;");
  sourceWriter.println("  font-size: 11px;");
  sourceWriter.println("  font-family:Courier New,monospace;");
  sourceWriter.println("}");
  sourceWriter.println("</style>");
  sourceWriter.println("</head>");
  sourceWriter.println("<body>");
  sourceWriter.println("<textarea name='code' class='java:nogutter' rows='15' cols='120'>");
} // writeStartOfHTMLFile()

//--------------------------------------------------------------------------------------------------

private static void writeStartOfSampleHTMLFile(final PrintWriter sourceWriter) {
  sourceWriter.println("/*");
  sourceWriter.println(" * Smart GWT (GWT for SmartClient)");
  sourceWriter.println(" * Copyright 2008 and beyond, Isomorphic Software, Inc.");
  sourceWriter.println(" *");
  sourceWriter.println(" * Smart GWT is free software; you can redistribute it and/or modify it");
  sourceWriter.println(" * under the terms of the GNU Lesser General Public License version 3");
  sourceWriter.println(" * as published by the Free Software Foundation.  Smart GWT is also");
  sourceWriter.println(" * available under typical commercial license terms - see");
  sourceWriter.println(" * http://smartclient.com/license");
  sourceWriter.println(" *");
  sourceWriter.println(" * This software is distributed in the hope that it will be useful,");
  sourceWriter.println(" * but WITHOUT ANY WARRANTY; without even the implied warranty of");
  sourceWriter.println(" * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU");
  sourceWriter.println(" * Lesser General Public License for more details.");
  sourceWriter.println(" */");
  sourceWriter.println();
} // writeStartOfSampleHTMLFile()

//--------------------------------------------------------------------------------------------------

}