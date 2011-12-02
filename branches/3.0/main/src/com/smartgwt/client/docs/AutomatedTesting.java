
package com.smartgwt.client.docs;

/**
 * <h3>Automated Testing</h3>
 * Smart GWT supports automated testing with a variety of tools. <P> <b>Selenium</b> <P> Smart GWT includes a free, custom
 * Selenium extension for robust record and playback of tests, including the ability to record on one browser and play back
 * on others, support for Selenium Remote Control allowing tests to be written in a variety of programming languages and
 * run as scripts, as well as Smart GWT-specific enhancements to the Selenium IDE. <P> These extensions and a brief user
 * guide can be found in the  <code>selenium/</code> directory in the top level of the SDK.    <P> For load testing with
 * Selenium, take a look at <a href='http://browsermob.com' onclick="window.open('http://browsermob.com');return
 * false;">BrowserMob</a>. <P> <b>SOASTA</b> <P> SOASTA's CloudTest product includes special support for Smart GWT with
 * capabilities similar to our Selenium extensions, with special emphasis on load testing.  Find out more at <a
 * href='http://soasta.com' onclick="window.open('http://soasta.com');return false;">http://soasta.com</a>. <P> <b>Other
 * tools</b> <P> Smart GWT supports a special JavaScript API to allow other test tools to integrate in the same manner as
 * Selenium and SOASTA.  This API allows the test tool to record an abstract "locator" string representing the logical name
 * for an interactive DOM element, and then during test playback, retrieve a DOM element given a locator. <P> This is
 * critical because, like many modern Ajax systems, Smart GWT generates different DOM elements in different browsers, in
 * different skins, and in different versions of Smart GWT.   Testing tools that try to directly record the generated Smart
 * GWT DOM produce extremely brittle tests because they are effectively recording undocumented internals. <P> Using the
 * "locator" API allows you to record or write tests that will run in any browser supported by Smart GWT, in any version of
 * Smart GWT, and in any skin.  It also makes tests more readable and easier to understand and maintain. <P> Different
 * testing tools vary in how easily they can be configured to use the locator API, and in some older tools it can be a
 * large effort.  We highly recommend using our Selenium extensions - it often makes sense to use them even if you have to
 * use them in parallel with another, older testing tool.  If you are forced to use another tool exclusively: <ul>   <li>
 * Refer to the &#83;martClient documentation for the AutoTest class (because it's a JavaScript API).  It can be found <a
 * href='http://www.smartclient.com/product/documentation.jsp'
 * onclick="window.open('http://www.smartclient.com/product/documentation.jsp');return false;">here</a>  <li> Read over the
 * source code of our Selenium extensions to get a clear understanding of how the Selenium integration works, because this
 * will be analogous to the work you'll need to do <li> Search the <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">forums</a> for other developers who are trying to
 * use the same test tool with Smart GWT, and share efforts </ul>
 */
public interface AutomatedTesting {
}
