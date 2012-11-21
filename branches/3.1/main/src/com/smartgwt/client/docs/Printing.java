	    
package com.smartgwt.client.docs;

/**
 * <h3>Printing</h3>
 * The browser's built-in support for printing will at best print what you see, which in the case
 * of a web application will often be useless, illegible, or partial. <P> Smart GWT has
 * specialized printing support that can take any page built with Smart GWT components and provide
 * a reasonable printed view.  The default printed view: <P> <ul> <li> renders components without
 * clipping or scrolling regions, so that a scrolling grid shows all loaded rows <li> removes
 * certain decorative images, such as image-based backgrounds, which may print poorly in black and
 * white <li> converts editing controls into static representations of the data being edited <li>
 * removes interactive elements such as buttons and menus, which don't work on paper and waste
 * space </ul> The default printed view can be customized with settings and method overrides as
 * necessary, including the ability to created printed representations of custom components you
 * have created.
 * @see com.smartgwt.client.widgets.Canvas#getPrintHTML
 * @see com.smartgwt.client.util.PrintProperties
 * @see com.smartgwt.client.widgets.PrintCanvas
 * @see com.smartgwt.client.widgets.PrintWindow
 * @see com.smartgwt.client.widgets.Canvas#printComponents
 * @see com.smartgwt.client.widgets.Canvas#getPrintPreview
 * @see com.smartgwt.client.widgets.Canvas#showPrintPreview
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getPrintTitleStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getPrintTextBoxStyle
 * @see com.smartgwt.client.widgets.form.fields.TextItem#getPrintFullText
 * @see com.smartgwt.client.widgets.form.fields.TextAreaItem#getPrintFullText
 * @see com.smartgwt.client.widgets.Canvas#getPrintChildrenAbsolutelyPositioned
 * @see com.smartgwt.client.widgets.Canvas#getShouldPrint
 * @see com.smartgwt.client.util.PrintProperties#getOmitControls
 * @see com.smartgwt.client.util.PrintProperties#getIncludeControls
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getPrintCellStyle
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getPrintLabelStyle
 * @see com.smartgwt.client.widgets.viewer.DetailViewer#getPrintHeaderStyle
 * @see com.smartgwt.client.widgets.grid.ListGridField#getShouldPrint
 * @see com.smartgwt.client.widgets.grid.ListGrid#getPrintAutoFit
 * @see com.smartgwt.client.widgets.grid.ListGrid#getPrintWrapCells
 * @see com.smartgwt.client.widgets.grid.ListGrid#getPrintHeaderStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getPrintBaseStyle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getPrintMaxRows
 */
public interface Printing {
}
