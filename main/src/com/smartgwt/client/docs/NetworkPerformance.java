
package com.smartgwt.client.docs;

/**
 * <h3>Network Performance</h3>
 * This section describes various methods for optimizing delivery of your Smart GWT-based application to the browser.  The
 * various techniques discussed here should enable you to drastically reduce the time to load your Smart GWT based
 * application and to cut down on bandwidth costs and server-side CPU usage. <P> <i>Note that in addition to these network
 * performance considerations, you should also be aware of the recommended application design practices discussed in {@link
 * com.smartgwt.client.docs.SmartArchitecture}.</i> <P> There are three main ways of improving the performance of your
 * application: <p> <u><b>Compression</b></u> <p> You'll want to deliver as much of your application assets compressed as
 * possible.  For a start, the Smart GWT modules come pre-compressed.  The {@link com.smartgwt.client.docs.Compression}
 * section describes how to make sure that Smart GWT modules and your application logic are delivered compressed and how to
 * enable dynamic compression of your dynamic content. <p> Compression drastically reduces transfer times to the browser. 
 * Compression ratios for css and javascript files can be as high as 8:1. <p> <u><b>Caching</b></u> <p> The {@link
 * com.smartgwt.client.docs.Caching} section deals with delivering as much content as possible with caching headers. 
 * Setting these headers allows the end-user's browser and any intermediary proxies to keep a local copy of the file across
 * browser reloads, ensuring the subsequent visits require almost no fetches from the server.  Eliminating these fetches is
 * also important for the reasons explained under File Assembly below.  <p> <u><b>File Assembly</b></u> <p> Modern browsers
 * limit the number of HTTP connections they use to fetch the assets required to render your pages - typically to just 2
 * connections.  As a result, connection latency can play a much higher role than available bandwidth and the two
 * connection limit effectively drastically limits the user's usable bandwidth.  For this reason, it's important to
 * minimize the number of HTTP requests made to the server.  The File Assembly services make it easy to deliver multiple
 * css and javascript file via one HTTP response.  Assembling files together also helps to increase the compression ratio
 * because the compression engine has more redundant data to work with. <p> <u><b>FileLoader</b></u> <p> The FileLoader is
 * a standalone client-side module that allows you to performing caching or loading of various resources in the background
 * on any page.  The typical usage pattern is to use this module to pre-cache Smart GWT modules, skin images, and
 * application logic while the user is, for example filling in a login form.  See the FileLoader documentation on usage.
 * <p> <u><b>SSL Considerations</b></u> <p> Some quirks to be aware of when optimizing for pages serviced via HTTPS: <ul>
 * <li>If your top-level https page loads an image via http, IE will pop a warning to the user asking if it's ok to serve
 * the "unsecure" content.  Firefox does not pop an alert, bug shows a different lock icon to indicate that not all content
 * is served from a secure server. <li>Firefox will not write images fetched via SSL to disk, even if expires headers are
 * set. But it will cache them in memory for the duration of the browser session.  This makes the use of the FileLoader
 * even more important for SSL applications.  IE will cache SSL content across browser restarts. <li>If your only concern
 * is with actual security and not with perception, it makes a lot of sense to serve the top-level page via plain HTTP and
 * then use the Smart GWT RPC mechanism to fetch sensitive data with no-cache headers via HTTPS.  Unfortunately this almost
 * never practical because most users look for the secure lock icon on the top-level page and may become worried that the
 * application is not secure if they don't see it. </ul> <p> <u><b>Other Tips</b></u> <p> 1.  Modern applications often use
 * a number of cookies to keep track of session state, application state, etc.  If you don't limit the paths these cookies
 * are served for, you can easily end up with these cookies being sent to the server with every HTTP request as part of the
 * HTTP headers.  This can severely limit bandwidth where a large number of requests are made - typically for skin images. 
 * Also note that most technologies used by end-users to connect to the internet such as DSL and Cable are half-duplex,
 * meaning that downstream must pause for upstream traffic to be sent and these connections also are asymmetric, allowing
 * much faster download speeds than upload speeds.  As a result, the limited upstream capability of most connections ends
 * up limiting the download bandwidth by delaying the download of other assets required to render the page. <p> 2. 
 * Whenever possible, don't sent the "Cache-Control" header to "private" - this tells intermediary proxies to not allow
 * caching of the specified content, eliminating that cache as a useful intermediary for other users behind it. <p> 3.  For
 * a good overview of performance considerations, see this post: <a href='http://www.die.net/musings/page_load_time/'
 * onclick="window.open('http://www.die.net/musings/page_load_time/');return
 * false;">http://www.die.net/musings/page_load_time/</a>
 */
public interface NetworkPerformance {
}
