
package com.smartgwt.client.docs;

/**
 * <h3>Customizing Sass-based Skins</h3>
 * <h3>Support for templated skins</h3> Some skins have a stylesheet generated from  <a
 * href='https://sass-lang.com/install' target='_blank'>Sass templates</a> and compiled with <a
 * href='http://compass-style.org/' target='_blank'>compass</a>. Each such skin has a "template"
 * subdirectory containing various files, including those used to regenerate the skin's stylesheet
 * (skin_styles.css) using <code>compass</code>.  The files of interest to a custom skin are in
 * the template/sass directory:  <h4>Files you can edit</h4> <ul> <li>&#95;userSettings.scss -
 * This file is initially empty and can be edited.  It should contain  Sass variables and font
 * declarations intended to override settings in the builtin skin   (see
 * <code>&#95;skinSettings.scss</code> and <code>&#95;base.scss</code> below)
 * <li>&#95;userStyles.scss - This file is initially empty and can be edited.  It should contain
 * CSS intended to be incorporated after the styles in the builtin skin (see 
 * <code>&#95;skinStyles.scss</code> and <code>&#95;base.scss</code> below), overriding both </ul>
 * <h4>Files that should not be edited</h4> The other files in template/sass should not be edited
 * and can be largely ignored (see the discussion below on <i>Keeping the skin you extended up to
 * date</i>) -  but their purpose is listed here: <ul> <li> skin_styles.scss - This is the
 * bootstrap file that lists the fragments to load and is executed by running 'compass compile' in
 * the parent folder.  There shouldn't be any need to alter this file - but you can do so if you
 * want to add further custom fragments <li> &#95;base.scss - This file contains all the base CSS
 * and the defaults for the supported  variables in the builtin skin that your custom skin is
 * based on.  This file should not be  edited <li> &#95;skinSettings.scss - This file contains
 * Sass variables and font-declarations for the  builtin skin, intended to override the defaults
 * set up in &#95;base.scss.  This file should not  be edited <li>&#95;skinStyles.scss - This file
 * contains custom CSS for the builtin skin, to be appended after that in &#95;base.scss.  This
 * file should not be edited </ul> <p> <h3>Creating a custom skin</h3> A custom skin is created by
 * copying and extending an existing one. <P> You can start from any templated skin but note that,
 * if you want to make pervasive  color/font alterations, for example, then you should consider
 * starting from the  "Cascade" skin, where variable values often cascade from one another,
 * allowing simple, high-level changes to affect much of the skin.  <P>  In other templated skins,
 * Tahoe, Stratus and Obsidian, where more of the variables are  customized or overridden,
 * changing a base variable value won't affect the parts that have  been overridden. <P> To create
 * a custom skin based on "Cascade": <ul> <li>Copy the skins/Cascade directory to skins/MySkin
 * <li>In skins/MySkin/load_skin.js, find and replace instances of "Cascade" with "MySkin" <li>In
 * skins/MySkin/template/sass/&#95;userSettings.scss, declare $theme_name: 'MySkin' <li>Change to
 * skins/MySkin/template and run 'compass compile' </ul> <P> <h3>Customizing your skin</h3>
 * <h4>What to edit</h4> <P> As noted at the top of this discussion, the files you can edit are in
 * the template/sass  directory - specifically, <code>&#95;userSettings.scss</code> for
 * customizing supported variable values and <code>&#95;userStyles.scss</code>, for overriding
 * existing styles. <P> You can see the CSS classes that can be overridden in
 * <code>&#95;base.scss</code>. <P>  You can see the list of available variables in
 * <code>&#95;skinSettings.scss</code>, grouped and  named according to what effects they have. 
 * You can copy the variables you want to override  into your <code>&#95;userSettings.scss</code>
 * file, change their values and run  'compass compile'. <P> <h4>By way of example</h4> Try adding
 * these settings to <code>&#95;userSettings.scss</code> and running 'compass compile' <P>
 * $primary_hue: 120;                          // generally green rather than blue<br>
 * $standard_widget_border_color: #006400;     // darkgreen borders for widgets<br>
 * $standard_button_border_radius: 5px;        // give all buttons rounded corners<br> <P>
 * <h4>After editing</h4> When you make changes to <code>&#95;userSettings.scss</code> or
 * <code>&#95;userStyles.scss</code>,  you can compile them into your skin by running 'compass
 * compile' from the  skins/MySkin/template directory.  This compiles the various fragments from
 * the template/sass  directory (listed in <code>skin_styles.scss</code>) to produce the skin's
 * stylesheet, at skins/MySkin/skin_styles.css. <P> After making changes and running 'compass
 * compile', clear your browser cache before refreshing your test page, to ensure the old
 * skin_styles.css isn't cached. <P> <h4>Keeping the skin you extended up to date</h4> As noted
 * earlier, some of the files in template/sass should not be edited.  This is because, from time
 * to time, we may make fixes or improvements to our builtin skins - when this happens,  you can
 * keep your custom skins up to date, without clobbering any of your customizations, by  copying
 * <code>&#95;base.scss</code>, <code>&#95;skinSettings.scss</code> and 
 * <code>&#95;skinStyles.scss</code> from the skin you extended to your skin's template/sass
 * folder,  replacing the existing copies.  From there, running 'compass compile' will incorporate
 * the  latest builtin skin changes into your custom skin, without affecting your existing 
 * customizations.
 */
public interface CustomSassSkins {
}
