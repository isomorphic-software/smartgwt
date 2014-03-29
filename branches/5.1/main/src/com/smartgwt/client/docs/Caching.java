
package com.smartgwt.client.docs;

/**
 * <h3>Caching</h3>
 * Standard web browsers can cache server responses, associating the locally-cached files with
 *  the URLs (including query parameters) that were used to fetch the files from the
 *  server. Each file may be assigned an explicit expiration time. Requests for the associated
 *  URL will always be served from the local cache, without accessing the server, until the file
 *  expires.
 *  <p>
 *  The recommended approach is to move as much content as possible into cacheable assets
 *  (these can be images, html, css, and js) and tell the browser to cache those for as long as
 *  possible (ideally indefinitely).  Clearly, most things can't simply be cached permanently -
 *  new versions of the application will often require changes to these assets.  To allow for
 *  this, the pages that direct the loading of the cached assets should be dynamic and should
 *  create version-specific URLs to these cacheable assets.  This can be done by tacking the
 *  version number as a query parameter or as a path component.  Here's an example of loading a
 *  javascript file versioned with a query parameter:
 *  <pre>
 *  &lt;script src='/foo/bar.js?version=13'&gt;&lt;/script&gt;
 *  </pre>
 *  Generally, the version number wouldn't be hard-coded into the dynamic page, but would
 *  instead pick up the value of a variable, such that you can simply bump up the value in one
 *  configuration file and have all versioned URLs change dynamically.
 *  <p>
 *  Because Smart GWT performs the assembly of image URLs dynamically, versioning of
 *  Smart GWT skins must be done with a path component.  You can do this by changing the base
 *  skinDir using {@link com.smartgwt.client.util.Page#setSkinDir Page.setSkinDir} - e.g:
 *  <pre>
 *  isc.Page.setSkinDir('/version/5.6/isomorphic/skins/Smart GWT/');
 *  </pre>
 *  You can then either deploy the new skins under the versioned directory above or use a URL
 *  rewriting engine such as mod_rewrite for Apache to map all such versions into a single
 *  deploy directory.
 *  <p>
 *  To actually tell the browser to cache images for a longer length of time than the browser
 *  session, you need to set the HTTP 'Expires' header.
 *  If you're not using the Smart GWT Java back-end there are several caching solutions
 *  available, depending on your server of choice.  Microsoft's IIS has built-in caching
 *  capability, please check the reference manual for details.  If you're using Apache, you can
 * use <a href='http://httpd.apache.org/docs/2.0/mod/mod_expires.html'
 * onclick="window.open('http://httpd.apache.org/docs/2.0/mod/mod_expires.html');return false;">mod_expires</a>.  Some
 * servlet
 *  containers also natively support the setting of caching headers.
 *  <p>
 *  The Smart GWT Java back-end supports setting caching headers via the FileDownload service
 *  on a per-mimetype basis.  To use it, first register the FileDownload servlet in your web.xml
 *  as follows:
 *  <pre>
 *      &lt;servlet&gt;
 *        &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;
 *        &lt;init-param&gt;
 *            &lt;param-name&gt;expires&lt;/param-name&gt;
 *            &lt;param-value&gt;text/javascript:3600,image/gif:86400&lt;/param-value&gt;
 *        &lt;/init-param&gt;
 *        &lt;servlet-class&gt;com.isomorphic.servlet.FileDownload&lt;/servlet-class&gt;
 *      &lt;/servlet&gt;
 *  </pre>
 *  The expires parameter controls the expiration time in seconds.  In the block above,
 *  javascript files are set to expire in 1 hour and gif images are set to expire in 1 day from
 *  the time they are served to the browser.  If you don't set explicit expires mappings, all
 *  images and css files will be set to expire in 1 day and javascript files will expire in 1
 *  hour, by default.
 *  <p>
 *  Next, map any resource that you want to serve with caching headers to the FileDownload
 *  servlet in your web.xml.  Typically, you'll want to serve the Smart GWT modules and all
 *  skin images with caching headers.  You can do so by adding the following servlet-mapping
 *  directives to your web.xml:
 *  <pre>
 *      &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/isomorphic/system/modules/*&lt;/url-pattern&gt;
 *      &lt;/servlet-mapping&gt;
 *  
 *      &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/isomorphic/skins/*&lt;/url-pattern&gt;
 *      &lt;/servlet-mapping&gt;
 *  </pre>
 */
public interface Caching {
}
