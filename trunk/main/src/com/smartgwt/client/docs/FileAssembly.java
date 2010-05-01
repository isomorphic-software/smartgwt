
package com.smartgwt.client.docs;

/**
 * <h3>File Assembly</h3>
 * File assembly concatenates multiple files into a single response, reducing the number&#010 of HTTP fetches required to
 * load a page. This concatenation also improves the&#010 compressibility of responses, since the compression algorithm may
 * reduce redundancy across a&#010 larger data set.&#010 <p>&#010 The ISC FileAssembly service provides
 * configuration-driven file assembly, with integrated&#010 compression and JavaScript stripping services.  Assemblies are
 * specified in an xml format&#010 and map a URI to a set of files to concatenate together.  There also additional flags
 * to&#010 enable stripping and compression.  &#010 <p>&#010 You can use the FileAssembler to create assemblies of
 * javascript and css.  Since it's&#010 basically a file concatenator with some specialized services for javascript files,
 * you could&#010 use it to assembly anything else, but javascript and css are probably the main things to&#010
 * consider.&#010 <p>&#010 The FileAssembler has a development mode and a production&#010 packaging mode.  In the
 * development mode, there is a servlet that you can register at&#010 virtual URLs that are assembled on the fly by the
 * FileAssembler based on its configuration.&#010 For production packaging, you can use the same configuration file to
 * generate static,&#010 pre-compressed versions of these files.  The format of the file is as follows:&#010 <pre>&#010
 * &lt;FileAssembly&gt;&#010     &lt;assemblies&gt;&#010         &lt;FileAssemblyEntry uri="/myAssembly.js"&gt;&#010       
 * &lt;compress&gt;true&lt;/compress&gt;&#010             &lt;components&gt;&#010                 &lt;component&gt;&#010   
 * &lt;type&gt;file&lt;/type&gt;&#010                     &lt;fileName&gt;copyright.txt&lt;/fileName&gt;&#010              
 * &lt;/component&gt;&#010                 &lt;component&gt;&#010                    
 * &lt;type&gt;datasource&lt;/type&gt;&#010                     &lt;name&gt;myDatasource1&lt;/name&gt;&#010                
 * &lt;/component&gt;&#010                 &lt;component&gt;&#010                     &lt;type&gt;ds&lt;/type&gt;&#010     
 * &lt;name&gt;myDatasource2&lt;/name&gt;&#010                 &lt;/component&gt;&#010                
 * &lt;component&gt;&#010                     &lt;type&gt;file&lt;/type&gt;&#010                    
 * &lt;fileName&gt;myPublicCode.js&lt;/fileName&gt;&#010                 &lt;/component&gt;&#010                
 * &lt;component&gt;&#010                     &lt;type&gt;file&lt;/type&gt;&#010                    
 * &lt;fileName&gt;myPrivateCode.js&lt;/fileName&gt;&#010                    
 * &lt;jsStripping&gt;full&lt;/jsStripping&gt;&#010                     &lt;jsObfuscation&gt;1&lt;/jsObfuscation&gt;&#010  
 * &lt;/component&gt;&#010             &lt;/components&gt;&#010         &lt;/FileAssemblyEntry&gt;&#010    
 * &lt;/assemblies&gt;&#010 &lt;/FileAssembly&gt;&#010 </pre>&#010 You can specify as many FileAssemblyEntry blocks as you
 * want, simply place them alongside&#010 each other under the &lt;assemblies&gt; element.  The above example states that
 * the&#010 /myAssembly.js file should be assembled from the various components listed above. Component&#010 blocks support
 * the following attributes:&#010 <p>&#010 <table border='1' class='normal'>&#010
 * <tr><td><b>Name</b></td><td><b>Values</b></td><td><b>Description</b></td></tr>&#010
 * <tr><td>type</td><td>file<br>xmlFile<br>ds|datasource<br>ui</td>&#010     <td>any file<br>XML file<br>ISC DataSource
 * file<br>ISC UI file<br></td></tr>&#010 <tr><td>name</td><td>file identifier</td>&#010     <td>identifier for a ds or ui
 * file</td></tr>&#010 <tr><td>fileName</td><td>file path</td><td>path to a file or xmlFile (relative to
 * webRoot)</td></tr>&#010 <tr><td>jsStripping</td><td>none<br>partial<br>full</td>&#010     <td>level of stripping
 * (whitespace, comment, and delimiter removal) applied to file</td></tr>&#010 </table>&#010 <p>&#010 All component types
 * except file are converted from valid ISC XML format to JavaScript format&#010 by the FileAssembler.  The
 * <code>jsStripping</code> attribute only applies to assembled&#010 javascript files.&#010 <p>&#010 Once you've created
 * the configuration file, you'll probably want to place it somewhere in&#010 webRoot.  Generally, it can be placed
 * anywhere you like, but the development-time&#010 FileAssembly servlet requires the file be placed under webRoot. The
 * default location is&#010 /isomorphicConfig/fileAssembly.xml and can be changed via the <code>configFile</code>&#010
 * init-param of the FileAssembly servlet.  To enable development mode support for&#010 FileAssembly, you'll need to
 * register the FileAssembly servlet in your web.xml as follows:&#010 <pre>&#010     &lt;servlet&gt;&#010      
 * &lt;servlet-name&gt;FileAssembly&lt;/servlet-name&gt;&#010      
 * &lt;servlet-class&gt;com.isomorphic.servlet.FileAssembly&lt;/servlet-class&gt;&#010     &lt;/servlet&gt;&#010
 * </pre>&#010 Now, for every FileAssemblyEntry URI you specified in your fileAssembly.xml, you'll need&#010 corresponding
 * mappings in web.xml, to tell the servlet container to send requests for that&#010 file to the FileAssembler.  For
 * example, assuming your fileAssembly.xml contained the&#010 contents shown above, you'd register /myAssembly.js in your
 * web.xml with the FileAssembler as&#010 follows:&#010 <pre>&#010     &lt;servlet-mapping&gt;&#010      
 * &lt;servlet-name&gt;FileAssembly&lt;/servlet-name&gt;&#010      
 * &lt;url-pattern&gt;/myAssembly.js&lt;/url-pattern&gt;&#010     &lt;/servlet-mapping&gt;&#010 </pre>&#010 You'll need a
 * similar entry for any other entry in your fileAssembly.xml.  Note that this is&#010 for development only - we'll
 * pregenerate static files for production.  Once you've done the&#010 above, you can load /myAssembly.js into your page
 * via a standard SCRIPT block, like so:&#010 <pre>&#010 &lt;script src="/myAssembly.js"&gt;&lt;/script&gt;&#010
 * </pre>&#010 Now, whenever requests are made for this file, the FileAssembler will check the timestamps&#010 of all the
 * components of this assembly, rebuild the assembled file if required, and serve it&#010 to the browser as if it was a
 * static file on disk.&#010 <p>&#010 To create static assembled files for production, you can use the fileAssembler
 * command line&#010 tool provided as part of the SDK.  This is a Java-based command line tool located in&#010
 * smartclientSDK/WEB-INF/bin.  There are three versions of the tool in that directory -&#010 fileAssembler.bat is for
 * Windows platforms, fileAssembler.command is for MacOS platforms, and&#010 fileAssembler.sh is for *nix platforms. 
 * Running this tool with the --help argument will show&#010 you the command line switches available.  Typically, you'll
 * need to specify:&#010 <ul>&#010 <li>--config &lt;file&gt; - location of the fileAssembly.xml configuration file&#010
 * <li>--webRoot &lt;dir&gt; - location of the webRoot that the fileAssembler uses to access the&#010 component files.&#010
 * <li>--outputDir &lt;dir&gt; - location of directory where you want output files to go - typically&#010 this is the
 * webRoot of your production build.  These are the files you'll deploy to&#010 production.&#010 </ul>&#010 Finally, since
 * the generated files are likely to be compressed and they're static, you'll&#010 probably want to map the FileDownload
 * servlet to serve them in your production web.xml
 */
public interface FileAssembly {
}
