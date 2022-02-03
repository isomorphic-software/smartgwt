
package com.smartgwt.client.docs;

/**
 * <h3>Automated Testing</h3>
 * Smart GWT supports automated testing with a variety of tools.
 *  <P>
 *  <h3>Selenium / Selenese</h3>
 *  <P>
 * Smart GWT includes free support for <a href='https://docs.seleniumhq.org/'
 * target='_blank'>Selenium</a>
 *  for robust recording and playback of tests, including the ability to record on one browser
 *  and play back on others, via 
 * <a href='https://www.seleniumhq.org/docs/02_selenium_ide.jsp#selenium-commands-selenese'
 * target='_blank'>Selenese</a>
 *  enhanced with Smart GWT-specific locators and commands that provide a stable means of
 *  locating Smart GWT widgets and ensuring they're ready for interaction.
 *  <P>
 *  To write Selenese, we recommend Selenium IDE 2.9, which is compatible with
 * <a href='https://www.mozilla.org/en-US/firefox/organizations/' target='_blank'>Firefox 52
 * ESR</a>, and
 *  can directly load our user extensions, located in the
 *  
 *  <code>selenium/</code>
 *  directory.  A user guide explaining how to create and interactively run selenese with the IDE
 * can be found {@link com.smartgwt.client.docs.UsingSelenium here}.  Selenium IDE 3, which
 * requires Firefox 
 *  Quantum, has just released support for plugins that should allow the eventual migration of
 *  our user extensions, but for now only Selenium IDE 2.9 can load Smart GWT locator and
 *  command extensions.
 *  <P>
 *  <b>SeleneseRunner</b>
 *  <P>
 *  For automated testing, Smart GWT provides
 * <a href='../../../../../server/javadoc/com/isomorphic/webdriver/SeleneseRunner.html'
 * target='_blank'>SeleneseRunner</a>, a tool that
 *  executes Smart GWT-enhanced Selenese created by Selenium IDE via emulation, since Selenium
 *  3 no longer supports the Selenium RC APIs and thus can't execute Selenese that requires
 *  custom user extensions.  Internally, <code>SeleneseRunner</code> makes use of the APIs in
 *  our WebDriver wrappers to resolve locators properly and execute Smart GWT-enhanced
 *  Selenese.
 *  <P>
 *  <code>SeleneseRunner</code> can be used to:
 *  <ul>
 *  <li> execute Selenese directly from the command line
 *  <li> execute Selenese from inside a Java program (eg, as part of a JUnit test)
 *  <li> convert a Selenese test to Java code (as a JUnit test)
 *  </ul><p>
 *  See the server-side JavaDoc linked above for more information on how to use these features.
 *  <P>
 *  <h3>TestRunner</h3>
 *  <P>
 * {@link com.smartgwt.client.docs.TestRunner TestRunner} is a system for automatically running a
 * suite of Selenium
 * tests, commiting the results to a database, and reporting any regressions (or fixes) via email.
 *  <P>
 *  
 *  <h3>GwtTestCase</h3>
 *  <P>
 *  GWT includes a way to run a GWT application under JUnit, running your GWT application in a
 *  "headless" browser.  This is a very limited testing approach appropriate for certain unit
 *  tests only - it cannot replace events such as clicks, because by default it doesn't run in
 *  actual browser (instead it runs in a simulator called HtmlUnit).
 *  <p>
 *  Note that running tests under HtmlUnit can lead to false failures in a variety of areas,
 *  including network communication and XML processing, where HtmlUnit's behaviors do not
 *  correspond to any real browser.  Note that, if you find that a test fails under HtmlUnit but
 *  would not fail in a real browser, this will not be regarded as a SmartGWT bug.
 *  <p>
 *  If you use GwtTestCase at all, Isomorphic recommends that the majority of your tests are
 *  executed using the
 * <a href='http://www.gwtproject.org/doc/latest/DevGuideTestingRemoteTesting.html'
 * target='_blank'>runStyle option</a>
 *  that allows GwtTestCase to run under a real browser via Selenium.
 *  <P>
 *  Also note, GwtTestCase has a bug where it does not run onModuleLoad() for included GWT
 *  modules.  To make sure SmartGWT's onModuleLoad() runs, add a <code>gwtSetUp()</code>
 *  implementation like so: 
 *  <P>
 *  <pre>
 *    public class SgwtTest extends GWTTestCase {
 *       public void gwtSetUp() {
 *        new SmartGwtEntryPoint().onModuleLoad();  
 *       }
 *       ...
 *  </pre>
 *  <P>
 *  You may need to add similar manual calls for other GWT modules you inherit which expect to
 *  have their <code>onModuleLoad()</code> method called normally.
 *  
 *  <P>
 *  <h3>Selenium WebDriver</h3>
 *  <P>
 *  WebDriver, supported since Selenium 2, uses a different basic architecture in which a driver
 *  is added to each browser to enable Selenium interaction, instead of doing so from JavaScript.
 *  <P>
 *  Support for WebDriver-based testing for Smart GWT is now available with the same custom
 *  locator strategies and custom commands as we provide for Selenese.  <b>However, we continue
 *  to recommend Selenese rather than WebDriver-based Selenium, because Webdriver requires
 *  Java programming skills.</b>  Tests created in Selenium IDE and stored in Selenese can be
 *  executed by a variety of tools without requiring Java skills, including our own
 * {@link com.smartgwt.client.docs.TestRunner}.  Most ways of running WebDriver tests involve Java
 * coding skills or
 *  at least the ability to work with a Java IDE.  This tends to mean that all QA personnel must
 *  either have Java skills or drain the time of Java developers on repetitive tasks.
 *  <P>
 *  Ultimately, our current recommendation is to use Selenium IDE and Selenese exclusively or
 *  at least primarily.  If there are critically important tests that you can only build via
 *  WebDriver, use WebDriver for those tests only, or use manual testing for those tests.
 *  <P>
 *  <b>WebDriver Usage</b>
 *  <P>
 *  When using WebDriver, we recommend using Selenum IDE as a starting point to record and store 
 *  tests.  You can then call <code>SeleneseRunner</code> to convert that Selenese to Java code
 *  that uses Smart GWT locators and invokes the appropriate APIs on our WebDriver wrappers.
 *  <P>
 *  Once you become familiar with what code is generated for common interactions, you may want to
 *  write tests directly without using Selenium IDE.  In this case, you can use the
 * {@link com.smartgwt.client.util.AutoTest} APIs, such as {@link
 * com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()}, which takes a {@link
 * com.smartgwt.client.widgets.Canvas} or
 * DOM element, to get the locators you need from the {@link com.smartgwt.client.docs.Debugging
 * Developer Console}.
 *  <p>
 *  <b>NOTE:</b> Selenium IDE has an option to export tests as WebDriver-compatible code.  <b>Do
 *  not use</b> this feature, it exports useless code that doesn't understand custom commands,
 *  custom locators, or other key features of Selenium IDE.  Use <code>SeleneseRunner</code>
 *  instead.
 *  <p>
 *  <b>WebDriver Classes overview</b>
 *  <p>
 *  Storing and executing Selenese tests recorded in the Selenium IDE is recommended as the
 *  primary approach for using WebDriver.  However, for certain rare tests it can make sense to
 *  use WebDriver Java support directly.
 *  <p>
 *  Smart GWT support for WebDriver is based around 3 different Java classes:
 *  <P>
 *  <ol>
 * <li> <a href='../../../../../server/javadoc/com/isomorphic/webdriver/ByScLocator.html'
 * target='_blank'>ByScLocator</a>:
 *  This implements the ability to find WebElements or WebDriver "By"
 * objects using Smart GWT Locator strings.  See {@link com.smartgwt.client.docs.UsingSelenium}
 * for more
 * background on Locator strings and how to obtain them.  Given a locator String, example usage
 * is:
 *  <pre>
 *  ByScLocator.scLocator("//ListGrid[ID=\"countryList\"]/body/row[countryCode=US||0]/col[fieldName=countryCode||0]")</pre>
 * <li> <a href='../../../../../server/javadoc/com/isomorphic/webdriver/SmartClientWebDriver.html'
 * target='_blank'>SmartClientWebDriver</a>:
 *  This is an abstract class which provides a number of
 *  different methods for interacting with the browser, such as:
 *  <ul>
 *  <li> open a browser at a particular URL
 *  <li> find the element or elements which match a given "By" object (either ByScLocator, or a
 *       standard WebDriver locator)
 *  <li> perform events and operations (click, drag, select etc)
 *  <li> perform custom Smart GWT validations / state checks, such as whether a grid has
 *       loaded data
 *  </ul>
 *  Three concrete implementations of SmartClientWebDriver are provided: SmartClientFireFoxDriver,
 * SmartClientChromeDriver and SmartClientIEDriver. There is also a SmartClientRemoteWebdriver
 * class
 *  which allows the injection of a manually configured RemoteWebDriver instance. This might be
 *  necessary, for example, for use with Selenium Grid.<P>
 * <li> <a href='../../../../../server/javadoc/com/isomorphic/webdriver/ScActions.html'
 * target='_blank'>ScActions</a>:
 *  a Smart GWT-specific version of the standard WebDriver
 *  "Action" class, providing a builder pattern to create a sequence of operations which can
 *  then be perform()ed.
 *  </ol>
 *  <P>
 *  These classes are packaged in the library isomorphic_webdriver.jar, which can be found in
 *  the directory lib-WebDriverSupport (along with several
 *  3rd-party supporting libraries).This directory can be found at the top level of the
 *  downloaded Smart GWT zip package.
 *  <P>
 *  General information regarding WebDriver can be found
 * <a href='http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-webdriver'
 * target='_blank'>here</a>.
 *  Setup for WebDriver is more complex than for classic Selenium.  Drivers can be downloaded for
 *  <a href='https://github.com/mozilla/geckodriver/' target='_blank'>Firefox</a>,
 * <a href='https://sites.google.com/a/chromium.org/chromedriver/' target='_blank'>Google
 * Chrome</a>, 
 *  <a href='https://www.seleniumhq.org/download/' target='_blank'>Internet Explorer</a>, and
 * <a href='https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/'
 * target='_blank'>MS Edge</a>.
 *  <P>
 *  <b>JUnit + WebDriver</b>
 *  <P>
 * Explore {@link com.smartgwt.client.docs.JUnitWebDriver JUnit + Selenium WebDriver}, where we
 * walk through a JUnit test
 *  targeting a Smart GWT Showcase sample.
 *  <P>
 *  <b>File Upload Example Test</b>
 *  <P>
 * As discussed above, one advantage which WebDriver does have over Classic Selenium is the
 * ability
 * to test file upload. It is still limited in that if a click is triggered on the file selection
 * button
 * an OS native file selection dialog will be triggered in which case the test will be suspended
 * until the
 * file is manually selected. To avoid this, the sendKeys() method can be used to enter the file
 * location.
 *  <p>Sample code:<p>
 *  <pre>
 *     &#47;**
 *      * The following test runs against localhost and requires a small (< 5mb) image to be in /tmp/image.jpg
 *      *&#47;
 *     public void fileUploadGWT() throws Exception {
 *         final String basePath = "//VLayout[ID=\"isc_Showcase_1_0\"]/member[Class=HLayout||index=0||length=2|"
 *                                +"|classIndex=0||classLength=1]/member[Class=HLayout||index=0||length=2||classIndex=0|"
 *                                +"|classLength=1]/member[Class=Canvas||index=1||length=2||classIndex=0||classLength=1]"
 *                                +"/child[Class=TabSet||index=0||length=1||classIndex=0||classLength=1]/paneContainer/"
 *                                +"member[Class=VLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                                +"member[Class=VLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                                +"member[Class=HLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                                +"member[Class=HLayout||index=0||length=1||classIndex=0||classLength=1]/";
 *         final String formPath = basePath + "member[Class=DynamicForm||index=0||length=3||classIndex=0||classLength=1]";
 *         final String tilesPath = basePath + "member[Class=VLayout||index=2||length=3||classIndex=0||classLength=1]/"
 *                                           + "member[Class=TileGrid||index=2||length=4||classIndex=0||classLength=1]/tile";
 *         SmartClientWebDriver driver = new SmartClientFirefoxDriver();
 *         driver.setBaseUrl("http://localhost:8888/");
 *         driver.get("index.html#upload_sql", true);
 * 
 *         final int origSize = driver.findElements(ByScLocator.scLocator(tilesPath)).size();
 *         By uploadForm = ByScLocator.scLocator(formPath);
 *         WebElement form = driver.findElement(uploadForm);
 *       
 *         By titleInput = ByScLocator.scLocator(formPath + "/item[name=title||title=Title||index=0||Class=TextItem]/element");
 *         driver.click(titleInput);
 *         driver.sendKeys(titleInput, "test image: " + origSize);
 *         
 *         WebElement findElement = form.findElement(By.xpath("//input[@type='FILE']"));
 *         &#47;*
 *          * The following causes a native dialog to be created which prevents further progress. Do NOT uncomment!
 *          * We just have to sendKeys() to it
 *          *&#47;
 *         //findElement.click(); 
 *         
 *         findElement.sendKeys("/tmp/image.jpg"); // A local file. Please change accordingly
 * 
 *         By saveButton = ByScLocator.scLocator(formPath + "/item[title=Save||index=2||Class=ButtonItem]/button/");
 *         driver.waitForElementClickable(saveButton);
 *         driver.click(saveButton);
 *         &#47;*
 *          * Note the following fails once the grid contains more than 3 rows of data as the index becomes inconsistent
 *          * as tiles scrolled out of site are removed and the indices change
 *          *&#47;
 *         By tile = ByScLocator.scLocator(tilesPath + "[Class=SimpleTile||index="+(origSize)+"||length="+(origSize+1)
 *                                                       + "||classIndex="+(origSize)+"||classLength="+(origSize+1)+"]/");
 *         driver.waitForElementClickable(tile);
 *         WebElement tile1 = driver.findElement(tile);
 *         assertEquals("test image: " + origSize, tile1.getText());
 *         assertEquals(origSize + 1, driver.findElements(ByScLocator.scLocator(tilesPath)).size());
 *         driver.close();
 *         driver.quit();
 *     }
 *  </pre>
 *  <P>
 *  <b>WebDriver Troubleshooting</b>
 *  <P>
 *  There is a known issue that 
 * <a href='https://code.google.com/p/selenium/issues/detail?id=4403' target='_blank'>native
 * events do not work with IE in Windows 8/8.1</a>
 *  that may manifest in WebDriver as clicks having no effect.  One potential workaround is to
 *  disable native events:
 *  <pre>
 *     DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
 *     caps.setCapability("nativeEvents",false);
 *     SmartClientWebDriver driver = new SmartClientIEDriver(caps);</pre>
 *  It's also been reported that changing the second line above to:
 *  <pre>
 *     caps.setCapability("requireWindowFocus", true);</pre>
 *  also resolves the issue, with the side effect that WebDriver then moves the mouse cursor.
 *  <P>
 *  In some versions of Internet Explorer, it's been reported that you must add the URL targeted
 *  by WebDriver to the "Trusted Sites" under Internet Options &gt;&gt; Security in order to
 *  allow the browser to communicate properly with Selenium.  A discussion of the setup needed
 *  to use WebDriver's InternetExplorerDriver can be found
 * <a href='https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver'
 * target='_blank'>here</a>.
 *  <P>
 *  <b>Other tools</b>
 *  <P>
 *  Smart GWT supports a special JavaScript API to allow other test tools to integrate in the
 *  same manner as Selenium and WebDriver.  This API allows the test tool to record an abstract
 *  "locator" string representing the logical name for an interactive DOM element, and then
 *  during test playback, retrieve a DOM element given a locator.
 *  <P>
 *  This is critical because, like many modern Ajax systems, Smart GWT generates different DOM
 *  elements in different browsers, in different skins, and in different versions of Smart GWT.  
 *  Testing tools that try to directly record the generated Smart GWT DOM produce extremely
 *  brittle tests because they are effectively recording undocumented internals.
 *  <P>
 *  Using the "locator" API allows you to record or write tests that will run in any browser
 *  supported by Smart GWT, in any version of Smart GWT, and in any skin.  It also makes
 *  tests more readable and easier to understand and maintain.
 *  <P>
 *  Different testing tools vary in how easily they can be configured to use the locator API,
 *  and in some older tools it can be a large effort.  We highly recommend using our Selenium
 *  extensions - it often makes sense to use them even if you have to use them in parallel with
 *  another, older testing tool.  If you are forced to use another tool exclusively:
 *  <ul>
 *  
 *  
 *  <li> Refer to the &#83;martClient documentation for the AutoTest class (because it's a
 *  JavaScript API).  It can be found
 *  <a href='http://www.smartclient.com/product/documentation.jsp' target='_blank'>here</a>
 *  
 *  <li> Read over the source code of our Selenium extensions to get a clear understanding of
 *  how the Selenium integration works, because this will be analogous to the work you'll need
 *  to do
 * <li> Search the <a href='http://forums.smartclient.com/' target='_blank'>forums</a> for other
 * developers
 *  who are trying to use the same test tool with Smart GWT, and share efforts
 *  </ul>
 */
public interface AutomatedTesting {
}
