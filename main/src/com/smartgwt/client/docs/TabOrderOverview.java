
package com.smartgwt.client.docs;

/**
 * <h3>Tab Order Overview</h3>
 * Smart GWT has logic to automatically assign and manage tab indices for focusable  components
 * and elements within those components (for example Buttons, FormItems, Form Item icons, etc).
 * This system has been designed to provide an intuitive user  interaction experience by default,
 * and to support being customized for alternative  tabbing behaviors by application code (see
 * "Custom Tab Orders", below). <P> The {@link com.smartgwt.client.widgets.TabIndexManager} class
 * is a singleton class responsible for maintaining the tab order for a chain of elements, and
 * parcelling out tab index values. This class is not directly responsible for updating any
 * elements in the DOM - instead it associates a unique ID with a position in a {@link
 * com.smartgwt.client.widgets.tree.Tree hierarchical data structure}, and provides APIs to
 * restructure and reorder entries in the tree, request a numeric tab index value  for each entry,
 * and fire a notification method when an entry's tab index changes due to the tree being
 * restructured. <P> The actual tab indices are lazily generated when requested, and will be
 * slotted within the "auto-generated tab index" range (see Canvas.TAB_INDEX_FLOOR and
 * TAB_INDEX_CEILING). A gap will be left between the assigned tab indices to minimize needing to
 * reshuffle due to slotting elements before already assigned tab-indices, and logic is in place
 * to handle reassigning tab indices to accommodate this if it does become necessary. <P> A
 * notification method will be fired if any calculated tab index becomes obsolete due to the tree
 * structure changing (either a parent is moved or we run out of space between elements and have
 * to reassign indices to later elements). <P> Each Smart GWT Canvas uses its own ID to register
 * with the TabIndexManager at  creation time and has built in logic to update its position in the
 * as the page  structure changes, and, for focusable widgets, ensure the returned tabIndex value
 * is assigned to the widget handle. {@link com.smartgwt.client.widgets.form.fields.FormItem}s and
 * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon}s are similarly registered with
 * TabIndexManager and apply the returned tab index to the appropriate element on the page. <P> By
 * default canvas tab positions are updated as follows: <ul> <li>On draw, top level elements are
 * always moved to the end of the tab-order</li> <li>When children are added to a parent, they
 * will be moved to be a sub-element of the     parent entry, in the position returned by {@link
 * com.smartgwt.client.widgets.Canvas#getChildTabPosition Canvas.getChildTabPosition()}. Note    
 * that this method is overridden for Layouts to have tabbing occur in specified     member
 * order.</li> </ul> Other manipulations may occur for other widgets. See  {@link
 * com.smartgwt.client.widgets.form.DynamicForm#sortItemsIntoTabOrder
 * DynamicForm.sortItemsIntoTabOrder()} and  {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getIconTabPosition
 * FormItem.getIconTabPosition()} for details on how the TabIndexManager is integrated with
 * FormItems and FormItemIcons. <P> Note that for canFocus false widgets, or widgets with tab
 * index explicitly  specified as either -1 or some value below TAB_INDEX_FLOOR will still be
 * present in the TabIndexManager's data tree (we'll just never request a tab-index for them). 
 * This allows us to manage the tab index of their children in a logically consistent manner <P>
 * <b>Custom Tab order</b> Tabbing behavior for canvases may be customized in a number of ways:
 * <ul> <li>An explicit {@link com.smartgwt.client.widgets.Canvas#getTabIndex Canvas.tabIndex} may
 * be specified for any canvas. This is appropriate for very simple customizations only. It will
 * not impact the tab-index of any child, so to build an intuitive user experience using explicit
 * tabIndex values typically requires an explicit tabIndex be specified for every focusable
 * element on the page. </li> <li>The {@link
 * com.smartgwt.client.widgets.Canvas#setRelativeTabPosition Canvas.setRelativeTabPosition()}
 * method may be used to assign a custom     relative, or "local" tab position for a canvas. This
 * is the position within the      canvas's parent widget, or within top level widgets if the
 * canvas has no parent or     {@link
 * com.smartgwt.client.widgets.Canvas#getUpdateTabPositionOnReparent
 * Canvas.updateTabPositionOnReparent} is false. </li>  <li>To actually provide an explicit
 * tab-position for some Canvas, a developer may use the     {@link
 * com.smartgwt.client.widgets.TabIndexManager#moveTarget TabIndexManager.moveTarget()} method and
 * pass in the canvas' ID as the first     parameter.</li> <li>Canvases may also choose not to
 * have their tab position updated on draw     (see {@link
 * com.smartgwt.client.widgets.Canvas#getUpdateTabPositionOnDraw Canvas.updateTabPositionOnDraw}
 * or reparent      (see {@link com.smartgwt.client.widgets.Canvas#getUpdateTabPositionOnReparent
 * Canvas.updateTabPositionOnReparent}).<br>     This is useful for providing tab index management
 * logic that doesn't     match up with top level draw order, or the canvas parent-child
 * hierarchy.</li> </ul> Focusable elements other than Smart GWT components (for example, native
 * HTML elements embedded in some canvas, or third party widgets)  can also participate in the
 * automatically assigned tab order. See {@link com.smartgwt.client.docs.CustomTabElements} for
 * details on how to achieve this.
 */
public interface TabOrderOverview {
}
