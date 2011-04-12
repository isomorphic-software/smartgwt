
package com.smartgwt.client.docs;

/**
 * <h3>Caching</h3>
 * Standard web browsers can cache server responses, associating the locally-cached files with&#010 the URLs (including
 * query parameters) that were used to fetch the files from the&#010 server. Each file may be assigned an explicit
 * expiration time. Requests for the associated&#010 URL will always be served from the local cache, without accessing the
 * server, until the file&#010 expires.&#010 <p>&#010 The recommended approach is to move as much content as possible into
 * cacheable assets&#010 (these can be images, html, css, and js) and tell the browser to cache those for as long as&#010
 * possible (ideally indefinitely).  Clearly, most things can't simply be cached permanently -&#010 new versions of the
 * application will often require changes to these assets.  To allow for&#010 this, the pages that direct the loading of
 * the cached assets should be dynamic and should&#010 create version-specific URLs to these cacheable assets.  This can be
 * done by tacking the&#010 version number as a query parameter or as a path component.  Here's an example of loading
 * a&#010 javascript file versioned with a query parameter:&#010 <pre>&#010 &lt;script
 * src='/foo/bar.js?version=13'&gt;&lt;/script&gt;&#010 </pre>&#010 Generally, the version number wouldn't be hard-coded
 * into the dynamic page, but would&#010 instead pick up the value of a variable, such that you can simply bump up the
 * value in one&#010 configuration file and have all versioned URLs change dynamically.&#010 <p>&#010 Because Smart GWT
 * performs the assembly of image URLs dynamically, versioning of&#010 Smart GWT skins must be done with a path component. 
 * You can do this by changing the base&#010 skinDir using {@link com.smartgwt.client.util.Page#setSkinDir Page.setSkinDir}
 * - e.g:&#010 <pre>&#010 isc.Page.setSkinDir('/version/5.6/isomorphic/skins/Smart GWT/');&#010 </pre>&#010 You can then
 * either deploy the new skins under the versioned directory above or use a URL&#010 rewriting engine such as mod_rewrite
 * for Apache to map all such versions into a single&#010 deploy directory.&#010 <p>&#010 To actually tell the browser to
 * cache images for a longer length of time than the browser&#010 session, you need to set the HTTP 'Expires' header.&#010
 * If you're not using the Smart GWT Java back-end there are several caching solutions&#010 available, depending on your
 * server of choice.  Microsoft's IIS has built-in caching&#010 capability, please check the reference manual for details. 
 * If you're using Apache, you can&#010 use <a href='http://httpd.apache.org/docs/2.0/mod/mod_expires.html'
 * onclick="window.open('http://httpd.apache.org/docs/2.0/mod/mod_expires.html');return false;">mod_expires</a>.  Some
 * servlet&#010 containers also natively support the setting of caching headers.&#010 <p>&#010 The Smart GWT Java back-end
 * supports setting caching headers via the FileDownload service&#010 on a per-mimetype basis.  To use it, first register
 * the FileDownload servlet in your web.xml&#010 as follows:&#010 <pre>&#010     &lt;servlet&gt;&#010      
 * &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;&#010       &lt;init-param&gt;&#010          
 * &lt;param-name&gt;expires&lt;/param-name&gt;&#010          
 * &lt;param-value&gt;text/javascript:3600,image/gif:86400&lt;/param-value&gt;&#010       &lt;/init-param&gt;&#010      
 * &lt;servlet-class&gt;com.isomorphic.servlet.FileDownload&lt;/servlet-class&gt;&#010     &lt;/servlet&gt;&#010
 * </pre>&#010 The expires parameter controls the expiration time in seconds.  In the block above,&#010 javascript files
 * are set to expire in 1 hour and gif images are set to expire in 1 day from&#010 the time they are served to the browser.
 * If you don't set explicit expires mappings, all&#010 images and css files will be set to expire in 1 day and javascript
 * files will expire in 1&#010 hour, by default.&#010 <p>&#010 Next, map any resource that you want to serve with caching
 * headers to the FileDownload&#010 servlet in your web.xml.  Typically, you'll want to serve the Smart GWT modules and
 * all&#010 skin images with caching headers.  You can do so by adding the following servlet-mapping&#010 directives to
 * your web.xml:&#010 <pre>&#010     &lt;servlet-mapping&gt;&#010      
 * &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;&#010      
 * &lt;url-pattern&gt;/isomorphic/system/modules/*&lt;/url-pattern&gt;&#010     &lt;/servlet-mapping&gt;&#010 &#010    
 * &lt;servlet-mapping&gt;&#010       &lt;servlet-name&gt;FileDownload&lt;/servlet-name&gt;&#010      
 * &lt;url-pattern&gt;/isomorphic/skins/*&lt;/url-pattern&gt;&#010     &lt;/servlet-mapping&gt;&#010 </pre>
 */
public interface Caching {
}
