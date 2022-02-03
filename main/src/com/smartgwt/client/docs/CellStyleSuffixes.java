
package com.smartgwt.client.docs;

/**
 * As with {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix stateful canvases},
 * grid cells support being  styled to reflect the current state of the cell by generating a css
 * styleName from the specified {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle
 * baseStyle}, plus stateful suffixes. <P>     There are four independent boolean states, which
 * are combined in the order given: <ol> <li>"Disabled" : whether the cell is disabled; enable by
 * setting the "enabled" flag on record     returned by getCellRecord <li>"Selected" : whether
 * cell is selected; enable by passing a Selection object as "selection" <li>"Over" : mouse is
 * over this cell; enable with showRollovers <li>{@link
 * com.smartgwt.client.widgets.grid.GridRenderer#getAlternateRowSuffix Specified
 * alternateRowSuffix} ("Dark" by default) : alternating row  color bands; enable with
 * alternateRowStyles <li>{@link
 * com.smartgwt.client.widgets.grid.GridRenderer#getAlternateColumnSuffix Specified
 * alternateColumnSuffix} ("AltCol" by default) : alternating  column color bands; enable with
 * alternateColumnStyles </ol> This leads to the following set of standard style names: <table
 * border=1> <tr><td><b>CSS Class
 * Applied</b></td><td><b>Description</b></td><td><b>Example</b></td></tr>
 * <tr><td><code><i>baseStyle</i></code></td><td>Default css style for the cell</td>    
 * <td><code>cell</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+<i>alternateRowSuffix</i></code></td>      <td>Suffix for
 * alternating color bands when {@link
 * com.smartgwt.client.widgets.grid.GridRenderer#getAlternateRowStyles alternateRowStyles} is
 * true</td>     <td><code>cellDark</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+<i>alternateColumnSuffix</i></code></td>      <td>Suffix for
 * alternating color bands when {@link
 * com.smartgwt.client.widgets.grid.GridRenderer#getAlternateColumnStyles alternateColumnStyles}
 * is true</td>     <td><code>cellAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Disabled</code></td>      <td>Whether the cell is disabled;
 * enable by setting the "enabled" flag on record     returned by getCellRecord.</td>    
 * <td><code>cellDisabled</code></td></tr>     <tr><td><code><i>baseStyle</i>+Selected</code></td>
 * <td>Whether the cell is {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectedRecord
 * selected}.       Only applies if {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getShowSelectedStyle ListGrid.showSelectedStyle} is
 * true</td>     <td><code>cellSelected</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Over</code></td>      <td>Mouse is over this record. Only
 * applies if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowRollOver
 * ListGrid.showRollOver} is true</td>     <td><code>cellOver</code></td></tr> <tr><td
 * colspan=2><i>Combined styles</i></td></tr>
 * <tr><td><code><i>baseStyle</i>+<i>alternateRowSuffix</i>+<i>alternateColumnSuffix</i></code></td>
 * <td>Disabled style applied to cells in both alternate row and column color bands.</td>    
 * <td><code>cellDarkAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Disabled+<i>alternateRowSuffix</i></code></td>      <td>Disabled
 * style applied to cells in alternate row color bands.</td>    
 * <td><code>cellDisabledDark</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Disabled+<i>alternateColumnSuffix</i></code></td>     
 * <td>Disabled style applied to cells in alternate column color bands.</td>    
 * <td><code>cellDisabledAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Disabled++<i>alternateRowSuffix</i>+<i>alternateColumnSuffix</i></code></td>
 * <td>Disabled style applied to cells in both alternate column and row color bands.</td>    
 * <td><code>cellDisabledDarkAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+Over</code></td>      <td>Style applied to selected
 * cells as the mouse rolls over them.</td>     <td><code>cellSelectedOver</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+<i>alternateRowSuffix</i></code></td>      <td>Selected
 * style applied to cells in alternate row color bands.</td>    
 * <td><code>cellSelectedDark</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+<i>alternateColumnSuffix</i></code></td>     
 * <td>Selected style applied to cells in alternate column color bands.</td>    
 * <td><code>cellSelectedAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+<i>alternateRowSuffix</i>+<i>alternateColumnSuffix</i></code></td>
 * <td>Selected style applied to cells in both alternate row and column color bands.</td>    
 * <td><code>cellSelectedDarkAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Over+<i>alternateRowSuffix</i></code></td>      <td>Style
 * applied to alternate row color band cells as the mouse rolls over them.</td>    
 * <td><code>cellOverDark</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Over+<i>alternateColumnSuffix</i></code></td>      <td>Style
 * applied to alternate column color band cells as the mouse rolls over them.</td>    
 * <td><code>cellOverAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Over+<i>alternateRowSuffix</i>+<i>alternateColumnSuffix</i></code></td>
 * <td>Style applied to cells in both alternate row and column color bands as the mouse rolls over
 * them.</td>     <td><code>cellOverDarkAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+Over+<i>alternateRowSuffix</i></code></td>     
 * <td>Style applied to selected, alternate row color band cells as the mouse rolls over
 * them.</td>     <td><code>cellSelectedOverDark</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+Over+<i>alternateColumnSuffix</i></code></td>     
 * <td>Style applied to selected, alternate column color band cells as the mouse rolls over
 * them.</td>     <td><code>cellSelectedOverAltCol</code></td></tr>
 * <tr><td><code><i>baseStyle</i>+Selected+Over+<i>alternateRowSuffix</i>+<i>alternateColumnSuffix</i></code></td>
 * <td>Style applied to selected, alternate row and column color band cells as the mouse rolls
 * over them.</td>     <td><code>cellSelectedOverDarkAltCol</code></td></tr> </table>
 */
public interface CellStyleSuffixes {
}
