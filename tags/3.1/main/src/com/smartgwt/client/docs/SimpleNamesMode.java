	    
package com.smartgwt.client.docs;

/**
 * <h3>Simple Names mode</h3>
 * When Smart GWT runs in "simple names" mode (the default), all ISC Classes and several global
 * methods are installed as JavaScript global variables, that is, properties of the browser's
 * "window" object.  When simple names mode is disabled (called "portal mode"), the framework uses
 * only the global variable: "isc" and global variables prefixed with "isc_".   <P> Portal mode is
 * intended for applications which must integrate with fairly arbitrary JavaScript code written by
 * third-party developers, and/or third party JavaScript frameworks, where it is important that
 * each framework stays within it's own namespace. <P>  Portal mode is enabled by setting
 * <code>window.isc_useSimpleNames = false</code> <b>before</b> Smart GWT is loaded, generally
 * inside the &lt;head&gt; element.
 */
public interface SimpleNamesMode {
}
