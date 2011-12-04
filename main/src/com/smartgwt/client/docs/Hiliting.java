
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
 * @see com.smartgwt.client.data.Hilite
 * @see com.smartgwt.client.widgets.cube.CubeGrid#getHilites
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconPosition
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconLeftPadding
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconRightPadding
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getCanHilite
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconPosition
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconWidth
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconHeight
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconLeftPadding
 * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconRightPadding
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIcons
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconPosition
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconSize
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconWidth
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconHeight
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconLeftPadding
 * @see com.smartgwt.client.widgets.grid.ListGrid#getHiliteIconRightPadding
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconLeftPadding
 * @see com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconRightPadding
 * @see com.smartgwt.client.types.HiliteIconPosition
 */
public interface Hiliting {
}
