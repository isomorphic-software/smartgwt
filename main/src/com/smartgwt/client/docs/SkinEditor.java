
package com.smartgwt.client.docs;

/**
 * <h3>Skin Editor</h3>
 * <h3>Rapid skin customization</h3> Isomorphic provides a visual Skin Editor tool which allows
 * for rapid, bulk customization of  skin details like colors, borders and fonts.  With this tool,
 * you can create a new  skin based on an existing one, customize it and then export it to a zip
 * file that you can  drop into any SmartGWT project. <p> Your changes are saved in an
 * intermediate database so the skin can be updated over time.   When you are happy with your
 * skin, export it to a zip file, drop it into your project skins/  directory and load it as you
 * would any other skin.  See below for details on exporting. <P> You can access the Skin Editor
 * in one of two ways: <h4>Online</h4> The Skin Editor is available online as a single-user tool
 * at <a href='https://www.smartclient.com/themes/' target='_blank'>smartclient.com/themes</a>. 
 * This link   runs against the  <a href='https://www.smartclient.com/product/download.jsp'
 * target='_blank'>latest public release</a> and is  available to customers with a  <a
 * href='https://www.smartclient.com/product/' target='_blank'>Pro or better</a> license of that
 * release.  Note that this is a single-user version of Skin Editor and does not support some team
 * features like sharing your design with other users. <p> For Skin Editor team support,
 * registered users can access the tool via  <a href='https://create.reify.com'
 * target='_blank'>Reify</a>, Isomorphic's low-code platform.  The  <a
 * href='https://create.reify.com/themes/' target='_blank'>Skin Editor for Reify</a> allows
 * skin-designs  to be shared among users and changes you make to your skins are reflected right
 * away within <code>Reify</code>.  Note that this version of the tool may be running
 * bleeding-edge code,  more recent then the current public release. <h4>Locally</h4> If you have
 * a <a href='https://www.smartclient.com/product/' target='_blank'>Pro or better</a> license,    
 * inheriting module <code>com.smartgwtee.tools.Tools</code> will make the Skin Editor available
 * in your SmartGWT project.  Only skin resources inherited by your project will be available for
 * editing so you may want to add additional dependencies to your module file.  For example, to
 * make the Obsidian skin available, add: <p> &lt;inherits
 * name="com.smartclient.theme.obsidian.ObsidianResources"/&gt; <p> Always run a GWT compile after
 * any module file change to ensure it's picked up, and then  navigate to
 * <code>{project_name}/tools/skinTools/skinEditor.jsp</code>.  <P> <P> <h3>Prerequisites</h3>
 * Using Skin Editor locally requires the following additional steps: <ul> <li>the builtin
 * DataSource <code>userSkin</code> must be imported to your Database using the  {@link
 * com.smartgwt.client.docs.AdminConsole}.  This DataSource is used to store user skins until
 * export</li> <li>both <a href='http://www.ruby-lang.org/en/downloads/' target='_blank'>Ruby</a>
 * and <a href='http://compass-style.org/install/' target='_blank'>Compass</a> need to be
 * installed on your  computer, and in the PATH.  During saves, Skin Editor uses
 * <code>Compass</code> to recompile  skin-CSS, via an operation on the <code>userSkin</code>
 * DataSource which invokes <i><b>compass compile 'path-to-skin-template-dir'</b></i> on the
 * server.</li> </ul> <p> <h3>Exporting Skins</h3> To export a skin, load it in the Skin Editor
 * and click the "Export" button to download the  skin in a zip file.  To use the skin, extract
 * the zip into your project skins/ directory and load it in your project in the usual way. <P> A
 * skin exported in this way can be further edited locally in your project  Skin Editor, if you
 * have an appropriate license.  Once extracted into the skins/ directory, it will appear in Skin
 * Editor's list of user-skins and can  be edited as normal, with changes being saved to disk
 * rather than database.  You might want  to do this, for example, in order to make non-CSS
 * configuration to the skin, via  <code>load_skin.js</code>.  While future versions of Skin
 * Editor will support non-CSS skin configuration, these features are not yet available. <p>
 * <h4>Base Skins</h4> When you create a new skin in Skin Editor, the first step is to choose a
 * Base skin to use as  a starting-point - by default, these are all builtin Isomorphic skins, but
 * you can add your  own to the list by selecting <i>Export as a Base skin</i> in the Skin Editor.
 * <P> You might want to do this if you create a customized skin and you want to be able to 
 * generate several variations on it - like changing colors, to make the color schemes of 
 * multiple customers that you are creating applications for.
 */
public interface SkinEditor {
}
