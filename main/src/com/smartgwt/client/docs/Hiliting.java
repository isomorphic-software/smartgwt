
package com.smartgwt.client.docs;

/**
 * <h3>Hiliting Overview</h3>
 * Hiliting means special visual styling which is applied to specific data values that meet certain criteria. <P> A {@link
 * com.smartgwt.client.data.Hilite} definition contains styling information such as {@link
 * com.smartgwt.client.data.Hilite#getCssText cssText} and {@link com.smartgwt.client.data.Hilite#getHtmlBefore htmlBefore}
 * that define what the hilite looks like, as well as properties defining where the hilite is applied.  If you create
 * hilites manually, they should ideally specify {@link com.smartgwt.client.data.Hilite#getTextColor textColor} and/or 
 * {@link com.smartgwt.client.data.Hilite#getBackgroundColor backgroundColor} in order to be editable in a  HiliteEditor. 
 * If these are not provided, however, note that they will be  manufactured automatically from the {@link
 * com.smartgwt.client.data.Hilite#getCssText cssText} attribute if it is present. <P> A hilite can be applied to data
 * <b>either</b> by defining {@link com.smartgwt.client.data.Hilite#getCriteria criteria} or by explicitly including
 * markers on the data itself.   <P> Hiliting rules such as hiliting different ranges of values with different colors can
 * be accomplished entirely client-side by defining {@link com.smartgwt.client.data.AdvancedCriteria} in hilite definitions
 * that pick out values to be highlighted. <P> Hiliting rules that require server-side calculations can be achieved by
 * assigning a {@link com.smartgwt.client.data.Hilite#getId id} to a hilite definition, and setting the {@link
 * com.smartgwt.client.widgets.DataBoundComponent#getHiliteProperty hiliteProperty} on the records that should show that
 * highlight. This can be used, for example, to hilite the record with the maximum value for a dataset that the application
 * will load incrementally.
 * @see com.smartgwt.client.widgets.cube.CubeGrid#hiliteCell
 * @see com.smartgwt.client.widgets.cube.CubeGrid#hiliteCellList
 * @see com.smartgwt.client.widgets.cube.CubeGrid#hiliteFacetValue
 */
public interface Hiliting {
}
