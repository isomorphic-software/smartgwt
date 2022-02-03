
package com.smartgwt.client.docs;

/**
 * <h3>Background Download</h3>
 * Because all components of the framework are delivered to the browser as
 * {@link com.smartgwt.client.docs.Caching cacheable} resources, users of your application
 * typically need download
 *  the SmartGWT
 *  runtime only once (until the cache expires or is purged).
 *  <p>
 *  Isomorphic recommends beginning that process as early in the user experience as possible,
 *  in a registration or login page for example, so that the runtime has already been
 *  downloaded by the time they reach your application and there is no perceived wait
 *  while the user loads the rich user interface.
 *  <p>
 *  Alternative implementations of this approach include loading the framework
 *  using &lt;script&gt; tags with the <code>defer</code> attribute, the
 *  {@link loadISCTag loadISC} JSP tag with its <code>cacheOnly</code> attribute,
 *  or the  FileLoader.cache() JavaScript function.
 *  <p>
 *  To use FileLoader, add its script tag to your html and follow it with a request
 *  to cache framework resources.  So from perhaps a login.html, registration.html, and/or
 *  index.html:
 *  <pre>
 *      &lt;script&gt;window.isomorphicDir = "./isomorphic/"; &lt;/script&gt;
 *      &lt;script src="./isomorphic/system/modules/ISC_FileLoader.js"&gt;&lt;/script&gt;
 *      &lt;script&gt;
 *        isc.FileLoader.cache();
 *      &lt;/script&gt;
 *  </pre>
 *  Whenever your application is ready to draw the first component, you can load the
 *  previously cached framework and draw the component in its callback:
 *  <pre>
 *      isc.FileLoader.load(function() {
 *        isc.Label.create({contents: 'Hello World!'});
 *      });
 *  </pre>
 *  You can even cause the component to be drawn in some existing DOM element, as outlined
 * in the {@link com.smartgwt.client.docs.IntegrationIntoExistingApps Integration into Existing
 * Applications}
 *  documentation topic:
 *  <pre>
 *      isc.FileLoader.load(function() {
 *        isc.Label.create({contents: 'Hello World!', htmlElement: 'greeting', matchElement: true});
 *      });
 *  </pre>
 *  <h3>Loading DataSources</h3>
 *  When you're loading the framework in the background, you'll also need to load your
 * DataSources in the background, using the {@link com.smartgwt.client.data.DataSource#load
 * DataSource.load()} function, typically in the
 *  callback:
 *  <pre>
 *      isc.FileLoader.load(function() {
 *          isc.DataSource.load('User', function() {
 *              isc.ListGrid.create({dataSource: 'User'});
 *          });
 *      });
 *  </pre>
 */
public interface BackgroundDownload {
}
