
package com.smartgwt.client.docs;

/**
 * <h3>Don't Misuse Frames</h3>
 * Loading the Smart GWT framework into multiple frames or iframes within the same browser is not a supported
 * configuration, or more accurately, not a <i>supportable</i> configuration, for the following reasons: <ul> <li> each
 * additional frame multiplies the memory footprint and reduces speed <li> having multiple frames prevents drag and drop
 * between components in different frames <li> modality handling (eg modal dialogs) doesn't automatically take into account
 * multiple frames (consider tabbing order, nested modality and other issues, you'll see it's not realistic to provide
 * automatic cross-frame modality handling) <li> inter-frame communication triggers several browser bugs: memory leaks,
 * performance issues, intermittent crashes in some browsers, inconsistencies in basic JavaScript operators such as
 * "typeof", and problems with form focus handling in IE, among many other bugs </ul> None of these problems are specific
 * to Smart GWT.  They happen with Ajax frameworks in general as well as other RIA technologies.  This is why no successful
 * Ajax application has ever used the approach of double-loading a component framework into multiple frames. <P> The
 * recommended {@link com.smartgwt.client.docs.SmartArchitecture Smart GWT Architecture} involves loading as many Smart
 * GWT-based application views as possible in the first page load, then showing and hiding different views as the user
 * navigates through the application. <P> If, for whatever reason, you cannot follow the Smart GWT Architecture and must
 * load new Smart GWT-based views by contacting the server each time, use the {@link
 * com.smartgwt.client.widgets.ViewLoader} class to load new views, never frames. <P> Note that the use of IFrames is
 * appropriate in certain circumstances, including loading certain types of content within an {@link
 * com.smartgwt.client.widgets.HTMLFlow contentsType,HTMLFlow}.  The only prohibited usage is loading the Smart GWT
 * framework into multiple frames within the same browser.
 */
public interface NoFrames {
}
