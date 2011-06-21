
package com.smartgwt.client.docs;

/**
 * <h3>File Assembly</h3>
 * File assembly concatenates multiple files into a single response, reducing the number
 *  of HTTP fetches required to load a page. This concatenation also improves the
 *  compressibility of responses, since the compression algorithm may reduce redundancy across a
 *  larger data set.
 *  <p>
 *  The ISC FileAssembly service provides configuration-driven file assembly, with integrated
 *  compression and JavaScript stripping services.  Assemblies are specified in an xml format
 *  and map a URI to a set of files to concatenate together.  There also additional flags to
 *  enable stripping and compression.  
 *  <p>
 *  You can use the FileAssembler to create assemblies of javascript and css.  Since it's
 *  basically a file concatenator with some specialized services for javascript files, you could
 *  use it to assembly anything else, but javascript and css are probably the main things to
 *  consider.
 *  <p>
 *  The FileAssembler has a development mode and a production
 *  packaging mode.  In the development mode, there is a servlet that you can register at
 *  virtual URLs that are assembled on the fly by the FileAssembler based on its configuration.
 *  For production packaging, you can use the same configuration file to generate static,
 *  pre-compressed versions of these files.  The format of the file is as follows:
 *  <pre>
 *  &lt;FileAssembly&gt;
 *      &lt;assemblies&gt;
 *          &lt;FileAssemblyEntry uri="/myAssembly.js"&gt;
 *              &lt;compress&gt;true&lt;/compress&gt;
 *              &lt;components&gt;
 *                  &lt;component&gt;
 *                      &lt;type&gt;file&lt;/type&gt;
 *                      &lt;fileName&gt;copyright.txt&lt;/fileName&gt;
 *                  &lt;/component&gt;
 *                  &lt;component&gt;
 *                      &lt;type&gt;datasource&lt;/type&gt;
 *                      &lt;name&gt;myDatasource1&lt;/name&gt;
 *                  &lt;/component&gt;
 *                  &lt;component&gt;
 *                      &lt;type&gt;ds&lt;/type&gt;
 *                      &lt;name&gt;myDatasource2&lt;/name&gt;
 *                  &lt;/component&gt;
 *                  &lt;component&gt;
 *                      &lt;type&gt;file&lt;/type&gt;
 *                      &lt;fileName&gt;myPublicCode.js&lt;/fileName&gt;
 *                  &lt;/component&gt;
 *                  &lt;component&gt;
 *                      &lt;type&gt;file&lt;/type&gt;
 *                      &lt;fileName&gt;myPrivateCode.js&lt;/fileName&gt;
 *                      &lt;jsStripping&gt;full&lt;/jsStripping&gt;
 *                      &lt;jsObfuscation&gt;1&lt;/jsObfuscation&gt;
 *                  &lt;/component&gt;
 *              &lt;/components&gt;
 *          &lt;/FileAssemblyEntry&gt;
 *      &lt;/assemblies&gt;
 *  &lt;/FileAssembly&gt;
 *  </pre>
 *  You can specify as many FileAssemblyEntry blocks as you want, simply place them alongside
 *  each other under the &lt;assemblies&gt; element.  The above example states that the
 *  /myAssembly.js file should be assembled from the various components listed above. Component
 *  blocks support the following attributes:
 *  <p>
 *  <table border='1' class='normal'>
 *  <tr><td><b>Name</b></td><td><b>Values</b></td><td><b>Description</b></td></tr>
 *  <tr><td>type</td><td>file<br>xmlFile<br>ds|datasource<br>ui</td>
 *      <td>any file<br>XML file<br>ISC DataSource file<br>ISC UI file<br></td></tr>
 *  <tr><td>name</td><td>file identifier</td>
 *      <td>identifier for a ds or ui file</td></tr>
 *  <tr><td>fileName</td><td>file path</td><td>path to a file or xmlFile (relative to webRoot)</td></tr>
 *  <tr><td>jsStripping</td><td>none<br>partial<br>full</td>
 *      <td>level of stripping (whitespace, comment, and delimiter removal) applied to file</td></tr>
 *  </table>
 *  <p>
 *  All component types except file are converted from valid ISC XML format to JavaScript format
 *  by the FileAssembler.  The <code>jsStripping</code> attribute only applies to assembled
 *  javascript files.
 *  <p>
 *  Once you've created the configuration file, you'll probably want to place it somewhere in
 *  webRoot.  Generally, it can be placed anywhere you like, but the development-time
 *  FileAssembly servlet requires the file be placed under webRoot. The default location is
 *  /isomorphicConfig/fileAssembly.xml and can be changed via the <code>configFile</code>
 *  init-param of the FileAssembly servlet.  To enable development mode support for
 *  FileAssembly, you'll need to register the FileAssembly servlet in your web.xml as follows:
 *  <pre>
 *      &lt;servlet&gt;
 *        &lt;servlet-name&gt;FileAssembly&lt;/servlet-name&gt;
 *        &lt;servlet-class&gt;com.isomorphic.servlet.FileAssembly&lt;/servlet-class&gt;
 *      &lt;/servlet&gt;
 *  </pre>
 *  Now, for every FileAssemblyEntry URI you specified in your fileAssembly.xml, you'll need
 *  corresponding mappings in web.xml, to tell the servlet container to send requests for that
 *  file to the FileAssembler.  For example, assuming your fileAssembly.xml contained the
 *  contents shown above, you'd register /myAssembly.js in your web.xml with the FileAssembler as
 *  follows:
 *  <pre>
 *      &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;FileAssembly&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/myAssembly.js&lt;/url-pattern&gt;
 *      &lt;/servlet-mapping&gt;
 *  </pre>
 *  You'll need a similar entry for any other entry in your fileAssembly.xml.  Note that this is
 *  for development only - we'll pregenerate static files for production.  Once you've done the
 *  above, you can load /myAssembly.js into your page via a standard SCRIPT block, like so:
 *  <pre>
 *  &lt;script src="/myAssembly.js"&gt;&lt;/script&gt;
 *  </pre>
 *  Now, whenever requests are made for this file, the FileAssembler will check the timestamps
 *  of all the components of this assembly, rebuild the assembled file if required, and serve it
 *  to the browser as if it was a static file on disk.
 *  <p>
 *  To create static assembled files for production, you can use the fileAssembler command line
 *  tool provided as part of the SDK.  This is a Java-based command line tool located in
 *  smartclientSDK/WEB-INF/bin.  There are three versions of the tool in that directory -
 *  fileAssembler.bat is for Windows platforms, fileAssembler.command is for MacOS platforms, and
 *  fileAssembler.sh is for *nix platforms.  Running this tool with the --help argument will show
 *  you the command line switches available.  Typically, you'll need to specify:
 *  <ul>
 *  <li>--config &lt;file&gt; - location of the fileAssembly.xml configuration file
 *  <li>--webRoot &lt;dir&gt; - location of the webRoot that the fileAssembler uses to access the
 *  component files.
 *  <li>--outputDir &lt;dir&gt; - location of directory where you want output files to go - typically
 *  this is the webRoot of your production build.  These are the files you'll deploy to
 *  production.
 *  </ul>
 *  Finally, since the generated files are likely to be compressed and they're static, you'll
 *  probably want to map the FileDownload servlet to serve them in your production web.xml
 */
public interface FileAssembly {
}
