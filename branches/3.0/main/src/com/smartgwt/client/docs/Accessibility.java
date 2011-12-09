
package com.smartgwt.client.docs;

/**
 * <h3>Accessibility / Section 508 compliance</h3>
 * Smart GWT is a fully accessible technology which fulfills the Section 508 requirements of U.S. government law and
 * similar international standards.  Specificallly: <ul> <li> components are fully keyboard navigable and the browser's
 * native focus indicator reveals keyboard focus to the user <li> components are themable/brandable, allowing a variety of
 * high contrast and limited color range look and feel options to compensate for visual acuity disabilities <li> the
 * WAI-ARIA standard is supported for adding semantic markup to components to identify them to screen readers such as NVDA
 * or JAWS. </ul> <P> <b>WAI-ARIA support</b> <P> ARIA is a standard from the WAI (Web Accessibility Institute) that allows
 * modern Ajax applications to add semantic markup to the HTML used to create modern Ajax interfaces to enable screen
 * reader support. This semantic markup allows a screen reader to identify the function and state of complex components
 * such as load-on-demand lists and trees even though they are composed of simple elements such a &lt;div&gt;s.   <P> Note
 * that ARIA support is the correct way to evaluate the accessibility of a web <i>application</i>.  Standards which apply
 * to a web <i>site</i>, such as ensuring that all interactive elements are composed of native HTML anchor (&lt;a&gt;) or
 * &lt;form&gt; controls, cannot and should not be applied to a web <i>application</i>.  A web application's accessibility
 * must be evaluated in terms of its ARIA support. <P> By default, Smart GWT components will write out limited ARIA markup
 * sufficient to navigate basic menus and buttons.  Full screen reader mode is not enabled by defaut because it has a small
 * performance impact and subtly changes the management of keyboard focus in a way that is slightly worse for unimpaired
 * users.   <P> The limited ARIA support which is enabled by default is intended to allow a screen reader user to navigate
 * to a menu to enable full screen reader support.  This is analogous to a partially visually impaired user ariving at a
 * site with normal theming and needing to switch to a high-contrast skin. <P> To enable full screenReader mode, call 
 * setScreenReaderMode before any Smart GWT components are created or drawn.  This implies that if an end user dynamically
 * enables full screen reader support, the application page must be reloaded, as an any existing components will not have
 * full ARIA markup. <P> For an overview of ARIA, see <a href='http://www.w3.org/WAI/intro/aria.php'
 * onclick="window.open('http://www.w3.org/WAI/intro/aria.php');return false;">http://www.w3.org/WAI/intro/aria.php</a>.
 * <P> To completely disable ARIA markup, call  isc.setScreenReaderMode(false) before any components are drawn. <P>
 * <b>Recommended Screen Reader Configuration</b> <P> The recommended configuration for screen reader use is the most
 * recent available release of Firefox and either the JAWS or NVDA screen reader. <P> While WAI-ARIA markup is provided for
 * other browsers, support for WAI-ARIA itself is known to be limited in current release versions of IE and other browsers
 * supported by Smart GWT. <P> <b>Application-level concerns</b> <P> While Smart GWT enables accessible web applications to
 * be created, it is always possible for an application to violate accessibility standards.  The following is a brief and
 * not exhaustive list of concerns for application authors: <ul> <li> for any operation that can be triggered via drag and
 * drop, you should offer an equivalent keyboard-only means of performing the same operation.  For common grid to grid
 * drags, this is easily accomplished using {@link com.smartgwt.client.widgets.grid.ListGrid#transferSelectedData
 * ListGrid.transferSelectedData}. <li> if you use a component in a way that is not typical, such as using an ImgButton as
 * a non-interactive stateful display, set its {@link com.smartgwt.client.widgets.Canvas#getAriaRole ariaRole}
 * appropriately.  For a list of ARIA roles, see <a href='http://www.w3.org/WAI/PF/aria/roles#role_definitions'
 * onclick="window.open('http://www.w3.org/WAI/PF/aria/roles#role_definitions');return
 * false;">http://www.w3.org/WAI/PF/aria/roles#role_definitions</a> <li> for plain HTML content that is incorporated into
 * an Ajax interface (such as an embedded help system), embed the HTML into an {@link com.smartgwt.client.widgets.HTMLFlow}
 * (whose default ARIA role is "article") and ensure the HTML itself is accessible (for example, has "alt" attributes on
 * all images which are semantically meaningful) </ul>
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanTabToHeader
 * @see com.smartgwt.client.widgets.Img#getAltText
 */
public interface Accessibility {
}
