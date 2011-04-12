
package com.smartgwt.client.docs;

/**
 * <h3>Compression</h3>
 * Compression helps reduce the sizes of various data fetched from the server.  Most modern web&#010 browsers can handle
 * compressed responses of certain content types. The time it takes to&#010 decompress these responses on a client system
 * is negligible compared to the time saved&#010 by reducing the number of bits on the wire, especially for slow
 * connections.&#010 <p>&#010 If you're not using the Smart GWT Java back-end, there are several compression solutions&#010
 * available, depending on your server of choice.  Microsoft's IIS has built-in compression&#010 capability, please check
 * the reference manual for details.  If you're using Apache, you can&#010 use <a
 * href='http://sourceforge.net/projects/mod-gzip/'
 * onclick="window.open('http://sourceforge.net/projects/mod-gzip/');return false;">mod_gzip</a> or &#010 use <a
 * href='http://httpd.apache.org/docs/2.0/mod/mod_deflate.html'
 * onclick="window.open('http://httpd.apache.org/docs/2.0/mod/mod_deflate.html');return false;">mod_deflate</a>.  Some&#010
 * servlet containers also natively support dynamic compression.&#010 <p>&#010 The Smart GWT Java back-end supports two
 * types of response compression:&#010 <ul>&#010 <li>Pre-compressed static content served via the ISC FileDownload
 * servlet.&#010 <li>On-the-fly compression of arbitrary content using the CompressionFilter.&#010 </ul>&#010 <u>Serving
 * pre-compressed files</u>&#010 <p>&#010 To serve pre-compressed static content via FileDownload, register the
 * FileDownload servlet&#010 in your web.xml as follows:&#010 <pre>&#010     &lt;servlet&gt;&#010      
 * &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;&#010      
 * &lt;servlet-class&gt;com.isomorphic.servlet.FileDownload&lt;/servlet-class&gt;&#010     &lt;/servlet&gt;&#010
 * </pre>&#010 Then map any resource that you want to serve compressed to the FileDownload servlet in your&#010 web.xml. 
 * Typically, you'll want to serve all Smart GWT modules compressed.  You can do so&#010 by adding the following
 * servlet-mapping directive to your web.xml:&#010 <pre>&#010     &lt;servlet-mapping&gt;&#010      
 * &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;&#010      
 * &lt;url-pattern&gt;/isomorphic/system/modules/*&lt;/url-pattern&gt;&#010     &lt;/servlet-mapping&gt;&#010 </pre>&#010
 * Finally, you'll need to create pre-compressed versions of your files alongside the&#010 uncompressed versions.  If
 * you're using the FileAssembler mechanism, it can create&#010 pre-compressed files for you automatically.  For all other
 * files, you can use any program&#010 that uses the gzip encoding.  The compressed file must have exactly the same
 * filename as the&#010 uncompressed version, with a '.gz' extension.  Note that it's important that both the&#010
 * compressed and uncompressed versions be present alongside each other because there are cases&#010 where serving
 * compressed content is not possible (for example HTTP 1.0 requests) - for those&#010 situations it's important that the
 * uncompressed files be available to be served to the&#010 client.  The FileDownload filter automatically detects whether
 * or not compression is&#010 possible.&#010 <p>&#010 <u>Dynamic Compression</u>&#010 <p>&#010 Dynamic Compression requires
 * the optional Network Performance module.  To use Dynamic&#010 Compression, register the CompressionFilter filter in your
 * web.xml as follows:&#010 <pre>&#010     &lt;filter&gt;&#010        
 * &lt;filter-name&gt;CompressionFilter&lt;/filter-name&gt;&#010        
 * &lt;filter-class&gt;com.isomorphic.servlet.CompressionFilter&lt;/filter-class&gt;&#010     &lt;/filter&gt;&#010
 * </pre>&#010 Then map any resource that you want dynamically compressed to this filter.  Note that the&#010
 * CompressionFilter knows the mime types that are compressible and will automatically ignore&#010 any stream that sets a
 * content-encoding header, and it automatically figures out if the&#010 current request is an include or forward (and
 * doesn't compress in that case), so it's safe&#010 to simply map it to all resources as follows:&#010 <pre>&#010    
 * &lt;filter-mapping&gt;&#010         &lt;filter-name&gt;CompressionFilter&lt;/filter-name&gt;&#010        
 * &lt;url-pattern&gt;/*&lt;/url-pattern&gt;&#010     &lt;/filter-mapping&gt;&#010 </pre>&#010 You can register the
 * CompressionFilter anywhere in your filter chain, but be aware that&#010 if any filters in front wrap and inspect the
 * HttpServletResponse output stream, they will&#010 be inspecting the compressed response.  Filters are typically applied
 * in the order in which&#010 they are listed in web.xml. &#010 <p>&#010 <u>Compressible mime types and
 * compatibility</u>&#010 <p>&#010 The FileDownload servlet and CompressionFilter filter can serve the following
 * mime-types&#010 compressed: text/html, text/xml, application/x-javascript, text/javascript, text/ecmascript,&#010
 * image/svg+xml.  If your files are not being compressed, make sure your servlet container&#010 has a mime type mapping
 * that identifies it as one of the above file types.&#010 <p>&#010 Compression for the mime types listed above is
 * supported on all browsers supported by&#010 Smart GWT.  There is one exception: compression of javascript files for IE
 * versions older&#010 than IE6 Service Pack 2 requires that the CompressionFilter be registered to dynamically&#010
 * compress the page that loads these javascript files.
 */
public interface Compression {
}
