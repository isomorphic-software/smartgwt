
package com.smartgwt.client.docs;

/**
 * <h3>Stateful Images</h3>
 * Images displayed in {@link com.smartgwt.client.widgets.StatefulCanvas stateful components} may
 * display different media depending on the current state of the component. See the {@link
 * com.smartgwt.client.widgets.Img#getSrc Img.src} attribute or {@link
 * com.smartgwt.client.widgets.Button#getIcon Button.icon} attribute for examples of such
 * "stateful images". <P> In general the media to load for each state may be specified in two
 * ways: <P> <H3>Base URL combined with state suffixes</H3> If the property in question is set to
 * a standard {@link com.smartgwt.client.docs.SCImgURL image URL}, this value will be treated as a
 * default, or base URL. When a new {@link com.smartgwt.client.widgets.StatefulCanvas#getState
 * state} is applied, this filename will be combined with the state name to form a combined URL.
 * This in turn changes the media that gets loaded and updates the image to reflect the new
 * state.<br> Note that if the property was defined as a sprite configuration string a css style
 * may be defined instead of, or in addition to a src URL.  See the {@link
 * com.smartgwt.client.docs.SCSpriteConfig sprite configuration documentation} for a discussion of
 * how sprites can be used for stateful images. <P> The following table lists out the standard set
 * of combined URLs that  may be generated. Subclasses may support additional state-derived media
 * of course. Note that the src URL will be split such that the extension is always applied to the
 * end of the combined string. For example in the following table, if <code>src</code> was set to
 * <code>"blank.gif"</code>, the Selected+Focused URL would be 
 * <code>"blank_Selected_Focused.gif"</code>. <table> <tr><td><b>URL for Img
 * source</b></td><td><b>Description</b></td></tr>
 * <tr><td><code><i>src</i>+<i>extension</i></code></td><td>Default URL</td></tr>
 * <tr><td><code><i>src</i>+"_Selected"+<i>extension</i></code></td>      <td>Applied when {@link
 * com.smartgwt.client.widgets.StatefulCanvas#getSelected StatefulCanvas.selected} is set to
 * true</td></tr> <tr><td><code><i>src</i>+"_Focused"+<i>extension</i></code></td>     
 * <td>Applied when the component has keyboard focus, if       {@link
 * com.smartgwt.client.widgets.StatefulCanvas#getShowFocused StatefulCanvas.showFocused} is true,
 * and       {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver
 * StatefulCanvas.showFocusedAsOver} is not true.</td></tr>
 * <tr><td><code><i>src</i>+"_Over"+<i>extension</i></code></td>      <td>Applied when the user
 * rolls over the component if          {@link
 * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is set
 * to true</td></tr> <tr><td><code><i>src</i>+"_Down"+<i>extension</i></code></td>     
 * <td>Applied when the user presses the mouse button over over the component if          {@link
 * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is set to
 * true</td></tr> <tr><td><code><i>src</i>+"_Disabled"+<i>extension</i></code></td>     
 * <td>Applied to {@link com.smartgwt.client.widgets.Canvas#getDisabled Canvas.disabled} component
 * if {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled
 * StatefulCanvas.showDisabled} is true.</td></tr> <tr><td colspan=2><i>Combined
 * states</i></td></tr> <tr><td><code><i>src</i>+"_Selected_Focused"+<i>extension</i></code></td> 
 * <td>Combined Selected and focused state</td></tr>
 * <tr><td><code><i>src</i>+"_Selected_Over"+<i>extension</i></code></td>      <td>Combined
 * Selected and rollOver state</td></tr>
 * <tr><td><code><i>src</i>+"_Focused_Over"+<i>extension</i></code></td>      <td>Combined Focused
 * and rollOver state</td></tr>
 * <tr><td><code><i>src</i>+"_Selected_Focused_Over"+<i>extension</i></code></td>     
 * <td>Combined Selected, Focused and rollOver state</td></tr>
 * <tr><td><code><i>src</i>+"_Selected_Down"+<i>extension</i></code></td>      <td>Combined
 * Selected and mouse-down state</td></tr>
 * <tr><td><code><i>src</i>+"_Focused_Down"+<i>extension</i></code></td>      <td>Combined Focused
 * and mouse-down state</td></tr>
 * <tr><td><code><i>src</i>+"_Selected_Focused_Down"+<i>extension</i></code></td>     
 * <td>Combined Selected, Focused and mouse-down state</td></tr>
 * <tr><td><code><i>src</i>+"_Selected_Disabled"+<i>extension</i></code></td>      <td>Combined
 * Selected and Disabled state</td></tr> </table> <P> <H3>Explicit stateful image
 * configuration</H3> The {@link com.smartgwt.client.widgets.SCStatefulImgConfig} object allows
 * developers to specify a set of explicit  image URLs, one for each state to be displayed, rather
 * than relying on an automatically generated combined URL. This pattern is useful for cases where
 * the filename of the stateful versions of the image doesn't match up with the auto-generated
 * format.
 */
public interface StatefulImages {
}
