
package com.smartgwt.client.docs;

/**
 * <h3>Customizing Sass-based Skins</h3>
 * <h3>Skin Editor</h3> To create new skins and easily make bulk changes to details like colors
 * and fonts, see our {@link com.smartgwt.client.docs.SkinEditor Skin Editor} tool, which can be
 * accessed online, or locally in your environment if you have a <a
 * href='https://www.smartclient.com/product/' target='_blank'>Pro or better</a>  license. 
 * <h3>Support for templated skins</h3> Some skins have a stylesheet generated from  <a
 * href='https://sass-lang.com/install' target='_blank'>Sass templates</a> and compiled with <a
 * href='http://compass-style.org/' target='_blank'>compass</a>. Each such skin has a "template"
 * subdirectory containing various files, including those used to regenerate the skin's stylesheet
 * (skin_styles.css) using <code>compass</code>.  The files of interest to a custom skin are in
 * the template/sass directory:  <ul> <li> skin_styles.scss - This is the bootstrap SASS file that
 * lists the fragments to compile into your custom skin, and is executed by running 'compile' in
 * the parent folder.  There  shouldn't be any need to alter this file - but you can do so if you
 * want to add further  custom fragments <li> &#95;base.scss - This file contains the
 * variable-defaults and base CSS for the  skin that your custom skin is based on.  Note that
 * @font-face definitions are declared in a separate <code>&#95;fonts.scss</code> file. See below.
 * This file should not be edited. </ul>  <h4>Files you can edit</h4> <ul> <li>&#95;fonts.scss -
 * This file defines the CSS @font-faces to load for this skin and can be  edited.  This content
 * is the only base-skin CSS that isn't in <code>&#95;base.scss</code>, kept separate so custom
 * skins can have different fonts, without leaving orphaned font-loads in 
 * <code>&#95;base.scss</code>. <li>&#95;userSettings.scss - This file is initially empty and can
 * be edited.  It should contain  Sass variables intended to override settings in the builtin skin
 * (see <code>&#95;base.scss</code> below) <li>&#95;userStyles.scss - This file is initially empty
 * and can be edited.  It should contain  CSS styles intended as overrides, to be incorporated
 * after the styles in the builtin skin (see <code>&#95;base.scss</code> below). </ul> <p>
 * <h3>Creating a custom skin</h3> A custom skin is created by copying and extending an existing
 * one. <P> You can start from whichever templated skin is closest to your requirement.  Variable
 * values  largely cascade from one another, allowing simple, high-level changes to affect much of
 * the  skin.  <P> To create a custom skin based on "Tahoe": <ul> <li>Copy the skins/Tahoe
 * directory to skins/MySkin <li>In skins/MySkin/load_skin.js, find and replace instances of
 * "Tahoe" with "MySkin" <li>In skins/MySkin/template/sass/&#95;userSettings.scss, declare
 * $theme_name: 'MySkin' <li>Change to skins/MySkin/template and run 'compile' </ul> <P>
 * <h3>Customizing your skin</h3> <h4>What to edit</h4> <P> As noted at the top of this
 * discussion, the files you can edit are in the template/sass  directory - specifically,
 * <code>&#95;userSettings.scss</code> for customizing supported variable values,
 * <code>&#95;userStyles.scss</code>, for overriding existing styles or adding new ones, and 
 * <code>&#95;fonts.scss</code> for changing the fonts. <P> You can see the CSS classes that can
 * be overridden in <code>&#95;base.scss</code>. <P>  You can also see the list of available
 * variables in that file, grouped and  named according to what effects they have.  You can copy
 * the variables you want to override  into your <code>&#95;userSettings.scss</code> file, change
 * their values and run  'compile' from the parent directory. <P> <h4>By way of example</h4> To
 * create a generally green version of Tahoe, try adding these settings to 
 * <code>&#95;userSettings.scss</code> and running 'compile' from the parent directory <P>
 * $highlight_color: #40BF41;                  // generally green rather than blue<br>
 * $standard_widget_border_color: #006400;     // darkgreen borders for widgets<br>
 * $standard_button_border_radius: 5px;        // give all buttons rounded corners<br> <P>
 * <h4>After editing</h4> When you make changes to <code>&#95;userSettings.scss</code> or
 * <code>&#95;userStyles.scss</code>,  you can compile them into your skin by running 'compile'
 * from the  skins/MySkin/template directory.  This compiles the various fragments from the
 * template/sass  directory (listed in <code>skin_styles.scss</code>) to produce the skin's
 * stylesheet, at skins/MySkin/skin_styles.css. <P> After making changes and running 'compile',
 * clear your browser cache before refreshing your test page, to ensure the old skin_styles.css
 * isn't cached. <P> <h4>Keeping the skin you extended up to date</h4> As noted earlier, some of
 * the files in template/sass should not be edited.  This is because, from time to time, we may
 * make fixes or improvements to our builtin skins - when this happens,  you can keep your custom
 * skins up to date, without clobbering any of your customizations, by  copying
 * <code>&#95;base.scss</code> from the skin you extended to your skin's template/sass  directory,
 * replacing the existing copy.  If you haven't customized your fonts, you can copy 
 * <code>&#95;fonts.scss</code> as well, which will include any internal font changes we make.
 * From there, running 'compile' will incorporate the  latest builtin skin changes into your
 * custom skin, without affecting your existing  customizations. <P> Note - compass will fail to
 * compile if it thinks there are no changes to include, and this can happen for various reasons. 
 * To work around this, the 'compile' batch files in the template directory pass the
 * <code>--force</code> switch to compass, to ensure it always recompiles. Additionally, when
 * compass runs, it creates a hidden directory, called sass-cache,  in the skin's template
 * structure - this can be safely removed, and should always be removed if any compilation issues
 * arise.
 */
public interface CustomSassSkins {
}
