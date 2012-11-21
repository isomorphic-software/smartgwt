	    
package com.smartgwt.client.docs;

/**
 * <h3>Internet Explorer "filter" effects</h3>
 * In order to compensate for various bugs and missing features in Internet Explorer, it's
 * necessary to use Microsoft-proprietary "filter" settings, as follows: <ul> <li> IE6-8: Opacity
 * filter required for opacity to work at all <li> IE6: AlphaImageLoader filter required for PNG
 * transparency to work at all <li> IE7-8: AlphaImageLoader filter required for PNG transparency
 * to work properly with      opacity (eg, translucent rounded windows), otherwise, PNGs will turn
 * entirely black      or show other severe artifacts when opacity is applied </ul> Using these
 * filters has a range of side-effects: <ul> <li> AlphaImageLoader will cause the UI to appear
 * frozen until users have downloaded all      PNG media shown on the page <li> moderate to severe
 * impact on rendering speed (20-60%) <li> font smoothing is disabled </ul> <P> For an application
 * that is frequently used (where images will typically be cached) on recent machines, and where
 * font smoothing is not considered important, no special steps need to be taken. <P> If any of
 * the above side effects are important, our recommendations are: <ul> <li> minimize use of PNG
 * media - use .gif instead <li> for IE7-8, {@link
 * com.smartgwt.client.widgets.Canvas#neverUsePNGWorkaround disable AlphaImageLoader} and     
 * {@link com.smartgwt.client.widgets.Canvas#getUseOpacityFilter disable Opacity} globally since
 * these browsers      can only render PNGs correctly in the absence of opacity settings. 
 * Selectively      enable opacity only in widgets that do not contain PNGs (eg the modalMask
 * shown by      a Window).  Avoid the use of opacity fades as a transition effect for IE unless
 * you      have eliminated all or almost all PNG media and the remaining artifacts are considered
 * acceptable.  Also eliminate all use of filter effects in CSS, and      {@link
 * com.smartgwt.client.widgets.Canvas#allowExternalFilters disable the workaround} that makes this
 * possible. <li> if IE6 performance is critically important, eliminate all PNG media and all use
 * of      opacity and {@link com.smartgwt.client.widgets.Canvas#neverUseFilters disable all
 * filters}. </ul> Note that the .gif format does not support partially transparent pixels, hence
 * can't be used for very high-quality antialiasing effects.  However, certain specific tools can
 * produce high-quality anti-aliased images in the less known PNG8 format, and this particular
 * format has the least artifacts in the above situations.  Details <a
 * href='http://blogs.sitepoint.com/2007/09/18/png8-the-clear-winner/'
 * onclick="window.open('http://blogs.sitepoint.com/2007/09/18/png8-the-clear-winner/');return
 * false;">here</a>.
 * @see com.smartgwt.client.widgets.Canvas#neverUsePNGWorkaround
 * @see com.smartgwt.client.widgets.Canvas#neverUseFilters
 * @see com.smartgwt.client.widgets.Canvas#allowExternalFilters
 * @see com.smartgwt.client.widgets.Canvas#setNeverUseFilters
 * @see com.smartgwt.client.widgets.Canvas#setAllowExternalFilters
 * @see com.smartgwt.client.widgets.Canvas#getUseOpacityFilter
 */
public interface IEFilters {
}
