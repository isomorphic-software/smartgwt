
package com.smartgwt.client.docs;

/**
 * A DataSource allows you to declare that certain fields are the most important fields to  show
 * to a user in situations where space is limited, and only one or a few fields can be reasonably
 * shown. <P> In the table below these special fields are summarized, along with their meaning,
 * and examples of which field would be most appropriate from several example DataSources. <P>
 * <table cellPadding=2 class="normal" border=1> <tr style="font-weight:bold;">  <td
 * rowSpan="2">Attribute</td>  <td colSpan="3">Example DataSource field</td>  <td
 * rowSpan="2">Meaning</td> </tr><tr style="font-style:italic;"> 
 * <td>employee</td><td>emailMessage</td><td>stockItem</td> </tr><tr> 
 * <td>titleField</td><td>name</td><td>subject</td><td>itemName</td>      <td>primary label for
 * the record as a while</td> </tr><tr> 
 * <td>infoField</td><td>job</td><td>sender</td><td>category</td>      <td>second most pertinent
 * piece of textual information</td> </tr><tr> 
 * <td>dataField</td><td>salary</td><td>date</td><td>price</td>      <td>most pertinent numeric,
 * date or enum (eg status) field</td> </tr><tr> 
 * <td>descriptionField</td><td>bio</td><td>messageBody</td><td>description</td>     
 * <td>descriptive long text field</td> </tr><tr> 
 * <td>iconField</td><td>photo</td><td>statusIcon</td><td>thumbnail</td>      <td> an image or
 * icon to accompany the title field</td> </tr></table> <P> Examples of the use of these fields
 * include the {@link com.smartgwt.client.widgets.tile.TileGrid}'s default choice of fields, and
 * the {@link com.smartgwt.client.util.EventHandler#setDragTracker drag tracker} that follows the
 * mouse cursor when data is being dragged between grids.
 * @see com.smartgwt.client.data.DataSource#getTitleField
 * @see com.smartgwt.client.data.DataSource#getIconField
 * @see com.smartgwt.client.data.DataSource#getInfoField
 * @see com.smartgwt.client.data.DataSource#getDataField
 * @see com.smartgwt.client.data.DataSource#getDescriptionField
 */
public interface DsSpecialFields {
}
