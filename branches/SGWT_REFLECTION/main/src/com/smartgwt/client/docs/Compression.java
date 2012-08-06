
package com.smartgwt.client.docs;

/**
 * <h3>Compression</h3>
 * Compression helps reduce the sizes of various data fetched from the server.  Most modern web
 *  browsers can handle compressed responses of certain content types. The time it takes to
 *  decompress these responses on a client system is negligible compared to the time saved
 *  by reducing the number of bits on the wire, especially for slow connections.
 *  <p>
 *  If you're not using the Smart GWT Java back-end, there are several compression solutions
 *  available, depending on your server of choice.  Microsoft's IIS has built-in compression
 *  capability, please check the reference manual for details.  If you're using Apache, you can
 * use <a href='http://sourceforge.net/projects/mod-gzip/'
 * onclick="window.open('http://sourceforge.net/projects/mod-gzip/');return false;">mod_gzip</a> or 
 * use <a href='http://httpd.apache.org/docs/2.0/mod/mod_deflate.html'
 * onclick="window.open('http://httpd.apache.org/docs/2.0/mod/mod_deflate.html');return false;">mod_deflate</a>.  Some
 *  servlet containers also natively support dynamic compression.
 *  <p>
 *  The Smart GWT Java back-end supports two types of response compression:
 *  <ul>
 *  <li>Pre-compressed static content served via the ISC FileDownload servlet.
 *  <li>On-the-fly compression of arbitrary content using the CompressionFilter.
 *  </ul>
 *  <u>Serving pre-compressed files</u>
 *  <p>
 *  To serve pre-compressed static content via FileDownload, register the FileDownload servlet
 *  in your web.xml as follows:
 *  <pre>
 *      &lt;servlet&gt;
 *        &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;
 *        &lt;servlet-class&gt;com.isomorphic.servlet.FileDownload&lt;/servlet-class&gt;
 *      &lt;/servlet&gt;
 *  </pre>
 *  Then map any resource that you want to serve compressed to the FileDownload servlet in your
 *  web.xml.  Typically, you'll want to serve all Smart GWT modules compressed.  You can do so
 *  by adding the following servlet-mapping directive to your web.xml:
 *  <pre>
 *      &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/isomorphic/system/modules/*&lt;/url-pattern&gt;
 *      &lt;/servlet-mapping&gt;
 *  </pre>
 *  Finally, you'll need to create pre-compressed versions of your files alongside the
 *  uncompressed versions.  If you're using the FileAssembler mechanism, it can create
 *  pre-compressed files for you automatically.  For all other files, you can use any program
 *  that uses the gzip encoding.  The compressed file must have exactly the same filename as the
 *  uncompressed version, with a '.gz' extension.  Note that it's important that both the
 *  compressed and uncompressed versions be present alongside each other because there are cases
 *  where serving compressed content is not possible (for example HTTP 1.0 requests) - for those
 *  situations it's important that the uncompressed files be available to be served to the
 *  client.  The FileDownload filter automatically detects whether or not compression is
 *  possible.
 *  <p>
 *  <u>Dynamic Compression</u>
 *  <p>
 *  Dynamic Compression requires the optional Network Performance module.  To use Dynamic
 *  Compression, register the CompressionFilter filter in your web.xml as follows:
 *  <pre>
 *      &lt;filter&gt;
 *          &lt;filter-name&gt;CompressionFilter&lt;/filter-name&gt;
 *          &lt;filter-class&gt;com.isomorphic.servlet.CompressionFilter&lt;/filter-class&gt;
 *      &lt;/filter&gt;
 *  </pre>
 *  Then map any resource that you want dynamically compressed to this filter.  Note that the
 *  CompressionFilter knows the mime types that are compressible and will automatically ignore
 *  any stream that sets a content-encoding header, and it automatically figures out if the
 *  current request is an include or forward (and doesn't compress in that case), so it's safe
 *  to simply map it to all resources as follows:
 *  <pre>
 *      &lt;filter-mapping&gt;
 *          &lt;filter-name&gt;CompressionFilter&lt;/filter-name&gt;
 *          &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
 *      &lt;/filter-mapping&gt;
 *  </pre>
 *  You can register the CompressionFilter anywhere in your filter chain, but be aware that
 *  if any filters in front wrap and inspect the HttpServletResponse output stream, they will
 *  be inspecting the compressed response.  Filters are typically applied in the order in which
 *  they are listed in web.xml. 
 *  <p>
 *  <u>Compressible mime types and compatibility</u>
 *  <p>
 *  The FileDownload servlet and CompressionFilter filter can serve the following mime-types
 *  compressed: text/html, text/xml, application/x-javascript, text/javascript, text/ecmascript,
 *  image/svg+xml.  If your files are not being compressed, make sure your servlet container
 *  has a mime type mapping that identifies it as one of the above file types.
 *  <p>
 *  Compression for the mime types listed above is supported on all browsers supported by
 *  Smart GWT.  There is one exception: compression of javascript files for IE versions older
 *  than IE6 Service Pack 2 requires that the CompressionFilter be registered to dynamically
 *  compress the page that loads these javascript files.
 */
public interface Compression {
}
