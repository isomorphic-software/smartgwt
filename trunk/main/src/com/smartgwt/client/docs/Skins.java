
package com.smartgwt.client.docs;

/**
 * Properties used to manage to the the overall appearance of the application. <P> A "skin" consists of  <ul>
 * <li><code>skin_styles.css</code>: a .css file defining the set of      classes to apply to Smart GWT components' visual
 * elements</li> <li><code>images/</code>: a directory of image files used as part of visual      components</li>
 * <li><code>load_skin.js</code>: a .js file containing overrides for various      Smart GWT component properties that
 * affect the appearance of those components.</li> </ul> Skins are loaded via the <code>skin</code> attribute of the
 * loadISCTag or  by including the appropriate <code>load_skin.js</code> source file with a standard script include tag.
 * <P> To create a custom skin, we suggest making a complete copy of an existing skin, then modifying the media, css class
 * definitions and component property overrides you wish to change. <P> Note that the <code>load_skin.js</code> file
 * contains a {@link com.smartgwt.client.util.Page#setSkinDir Page.setSkinDir}  directive to set up the skin dir (used to
 * ensure media is retrieved from the appropriate directory), and a {@link com.smartgwt.client.util.Page#loadStyleSheet
 * Page.loadStyleSheet} directive to load the .css file. <P> See the {@link com.smartgwt.client.docs.Skinning 'Skinning
 * Overview'} for more information.
 * @see com.smartgwt.client.util.Page#setSkinDir
 * @see com.smartgwt.client.util.Page#loadStyleSheet
 */
public interface Skins {
}
