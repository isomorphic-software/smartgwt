
package com.smartgwt.client.docs;

/**
 * Properties used to manage to the the overall appearance of the application.&#010 <P>&#010 A "skin" consists of &#010 <ul>&#010 <li><code>skin_styles.css</code>: a .css file defining the set of &#010     classes to apply to SmartGWT components' visual elements</li>&#010 <li><code>images/</code>: a directory of image files used as part of visual &#010     components</li>&#010 <li><code>load_skin.js</code>: a .js file containing overrides for various &#010     SmartGWT component properties that affect the appearance of those components.</li>&#010 </ul>&#010 Skins are loaded via the <code>skin</code> attribute of the loadISCTag or &#010 by including the appropriate <code>load_skin.js</code> source file with a standard script&#010 include tag.&#010 <P>&#010 To create a custom skin, we suggest making a complete copy of an existing skin, then&#010 modifying the media, css class definitions and component property overrides you wish to&#010 change.&#010 <P>&#010 Note that the <code>load_skin.js</code> file contains a {@link com.smartgwt.client.util.Page#setSkinDir} &#010 directive to set up the skin dir (used to ensure media is retrieved from the appropriate&#010 directory), and a {@link com.smartgwt.client.util.Page#loadStyleSheet} directive to load the .css file.&#010 <P>&#010 See the {@link com.smartgwt.client.docs.Skinning 'Skinning Overview'} for more information.
 * @see com.smartgwt.client.util.Page#setSkinDir
 * @see com.smartgwt.client.util.Page#loadStyleSheet
 */
public interface Skins {
}
