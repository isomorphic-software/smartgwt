
package com.smartgwt.client.docs;

/**
 * <h3>&lt;isomorphic:loadProject&gt;</h3>
 * <i>produces:</i> JavaScript
 *  <p>
 *  This tag inserts JavaScript to load the screens that are part of the project.
 *  <p>
 *  Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
 *  generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
 *  used in a JSP that is included from your main page in order to create separate
 *  cacheability.  For example:
 *  <pre>
 *  &lt;SCRIPT SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;
 *  </pre>
 *  <p>
 *  <p>
 *  <b><u>Tag Attributes:</u></b>
 *  <p>
 *  <b>name</b><br>
 *  <i>value format</i>: String - name of Project file to load (minus extension)<br>
 *  <i>default value</i>: NONE
 *  <p>
 *  This attribute specifies the name of the project file that specifies the list of
 *  screens that should be loaded into the browser. Project files are located in
 *  <code>[webroot]/shared/ui</code> by default.  This location is
 *  changeable in <code>[webroot]/WEB-INF/classes/server.properties</code> by setting the config
 * parameter <code>project.project</code> to the directory where your Project files are located.  
 * 
 *  We recommend that for prototyping, at least, you use the default directory.
 *  <p>
 *  For example:
 *  <pre>
 *  &lt;isomorphic:loadProject name="test"/&gt;
 *  </pre>
 *  Would create JavaScript that loads the screens listed in the project file
 *  <code>[webroot]/shared/ui/test.proj.xml</code> and output it into the JSP
 *  output stream at the location of the tag.
 *  <p>
 *  <b>currentScreenName</b><br>
 *  <i>value format</i>: String - name of screen to initially draw<br>
 *  <i>default value</i>: the currentScreenName defined in the project file
 *  <p>
 *  This attribute specifies the name of the screen within the project to draw
 *  after loading. Drawing of the screen can be suppressed by including the
 *  "drawFirstScreen" attribute.
 *  <p>
 *  <b>screenNames</b><br>
 *  <i>value format</i>: String - comma-separated list of screen names.<br>
 *  <i>default value</i>: NONE
 *  <p>
 *  This attribute specifies the names of screens within the project that
 *  should be loaded.
 *  <p>
 *  <b>drawFirstScreen</b><br>
 *  <i>value format</i>: boolean - acceptable values: "true" or "false"<br>
 *  <i>default value</i>: "true"
 *  <p>
 *  This attribute determines whether the "currentScreenName" screen is drawn
 *  after the project screens have been loaded.
 *  <p>
 *  <b>locale</b><br>
 *  <i>value format</i>: String - name of locale to load
 *  <i>default value</i>: NONE
 *  <p>
 *  Use this attribute to specify a locale to load.  The default value of null omits locale
 *  loading, which effectively means the framework default "en" locale is used.
 *  <p>
 *  <b>ownerId</b><br>
 *  <i>value format</i>: String - name of project owner
 *  <i>default value</i>: NONE
 *  <p>
 *  Use this attribute to specify a project owner. Only applicable if project source supports
 *  owner identification.
     * @see com.smartgwt.client.docs.LoadUITag
 */
public interface LoadProjectTag {
}
