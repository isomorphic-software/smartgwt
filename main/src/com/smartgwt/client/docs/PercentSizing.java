
package com.smartgwt.client.docs;

/**
 * <h3>Canvas Percentage sizing</h3>
 * Canvas {@link com.smartgwt.client.widgets.Canvas#getWidth width} and {@link
 * com.smartgwt.client.widgets.Canvas#getHeight height} may be set to a percentage value or
 * <code>"*"</code> rather than an explicit pixel value. This indicates to the framework that
 * these widgets should be sized dynamically. <P> Percentage sizes are resolved to pixel values as
 * follows: <UL> <LI>If a canvas has a specified {@link
 * com.smartgwt.client.widgets.Canvas#getPercentSource percentSource}, sizing will be     a
 * percentage of the size of that widget (see also {@link
 * com.smartgwt.client.widgets.Canvas#getPercentBox Canvas.percentBox}).</LI> <LI>Otherwise, if a
 * canvas has a {@link com.smartgwt.client.widgets.Canvas#getMasterCanvas master canvas}, and    
 * {@link com.smartgwt.client.widgets.Canvas#getSnapTo snapTo} is set for the widget, sizing will
 * be a percentage of     the size of that widget (see also {@link
 * com.smartgwt.client.widgets.Canvas#getPercentBox Canvas.percentBox}).</LI> <LI>Otherwise if
 * this is a child of some other canvas, percentages will be based on the     inner size of the
 * {@link com.smartgwt.client.widgets.Canvas#getParentCanvas parent canvas}'s viewport. This is   
 * the available space inside the parent, taking border, scrollbars etc into account.<br>     If
 * the parent has overflow set to "visible", percentage sizes are based on the      inner
 * <i>specified</i> size of the parent rather than the overflowed size.</LI> <LI>Otherwise, for
 * top level widgets, sizing is calculated as a percentage of page size.</LI> </UL> {@link
 * com.smartgwt.client.widgets.layout.Layout Layouts} may specially interpret percentage sizes on
 * their children, and also allow "*" as a size. See the Layout class documentation for more
 * information. <P> <b>Minimums and maximums for dynamic sizing:</b><br> Note that if a {@link
 * com.smartgwt.client.widgets.Canvas#getMaxWidth Canvas.maxWidth} or {@link
 * com.smartgwt.client.widgets.Canvas#getMinWidth Canvas.minWidth} are specified (or {@link
 * com.smartgwt.client.widgets.Canvas#getMaxHeight Canvas.maxHeight} / {@link
 * com.smartgwt.client.widgets.Canvas#getMinHeight Canvas.minHeight} for heights), these
 * properties act as explicit pixel limits on the canvas' size. For example, a canvas with {@link
 * com.smartgwt.client.widgets.Canvas#getMaxWidth Canvas.maxWidth} set to <code>500</code>, and
 * width specified as  "100%" will not render larger than 500 pixels in width even if there is
 * more space available in the parent canvas or percentSource. <P> <b>Percent sizing within
 * <i>overflow:"visible"</i> parents:</b><br> If a canvas is a {@link
 * com.smartgwt.client.widgets.Canvas#getChildren child} of another canvas with {@link
 * com.smartgwt.client.widgets.Canvas#getOverflow Canvas.overflow} set to "visible", percentage
 * sizes are based on the specified size of the parent, not the drawn size. In other words - if
 * the parent's content, or the size and position of some other child cause it to render larger
 * than its specified size, a "100%"-sized child will not expand  to fill the larger, rendered
 * size of the parent. <P> The framework avoids sizing percent sized children to fit the
 * <i>overflowed</i>  size of their parents, as the child itself contributes to the overflowed
 * size of the parent. If  a child both drives and is driven by its parent's overflowed size
 * unintended behaviors become very likely.<br> It becomes much more likely to see runaway sizing
 * and infinite loops with this kind of pattern and, while a parent holding a child sized to its
 * overflowed inner height or width could grow (for example, expanding its overflow to accommodate
 * another, taller child), it would never  dynamically reduce its overflow, as the percent sized
 * child would always completely fill the  drawn area. <P> Note that a developer could explicitly
 * set the {@link com.smartgwt.client.widgets.Canvas#getPercentSource Canvas.percentSource}
 * attribute of some canvas to its parent, but this isn't recommended for the reasons described
 * above. If you are trying to make a canvas fit to the (overflowed) viewport of its parent, it is
 * probably appropriate to instead match the size of the sibling causing it to overflow. This
 * could be achieved by setting <code>percentSource</code> to that sibling and setting an
 * appropriate percentBox value. You could also consider whether a {@link
 * com.smartgwt.client.docs.Containment master/peer relationship} is appropriate. <P> Also note
 * that the {@link com.smartgwt.client.widgets.layout.Layout} class supports expanding all members
 * to  match the drawn size of some {@link
 * com.smartgwt.client.widgets.layout.Layout#getMinBreadthMember minimum breadth member}. <P>
 * Developers wishing to implement some other dynamic sizing paradigm for a component based on the
 * drawn size of other component(s) can also add custom handling to the {@link
 * com.smartgwt.client.widgets.Canvas#addResizedHandler resized notification}.
 */
public interface PercentSizing {
}
