package com.smartgwt.client.types;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * Policy controlling how the Layout will manage member sizes on this axis.
 *  <P>
 *  Note that, by default, Layouts do <i>not</i> automatically expand the size of all members
 *  to match a member that overflows the layout on the breadth axis.  This means that a
 *  {@link com.smartgwt.client.widgets.form.DynamicForm} or other component that can't shrink beyond a minimum width will 
 *  "stick out" of the Layout, wider than any other member and wider than automatically
 *  generated components like resizeBars or sectionHeaders (in a {@link com.smartgwt.client.widgets.layout.SectionStack}).
 *  <P>
 *  This is by design: matching the size of overflowing members would cause expensive redraws
 *  of all members in the Layout, and with two or more members potentially overflowing, could
 *  turn minor browser size reporting bugs or minor glitches in custom components into
 *  infinite resizing loops.
 *  <P>
 *  If you run into this situation, you can either:<ul>
 *  <li>set the overflowing member to {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}: "auto", so that it
 *  scrolls if it needs more space
 *  <li>set the Layout as a whole to {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}:"auto", so that the
 *  whole Layout scrolls when the member overflows
 * <li>define a {@link com.smartgwt.client.widgets.Canvas#addResizedHandler resized()} handler to manually update the
 * breadth
 *  of the layout
 * <li>set {@link com.smartgwt.client.widgets.layout.Layout#getMinBreadthMember Layout.minBreadthMember} to ensure that the
 * available breadth used to
 *  expand all (other) members is artificially increased to match the current breadth of the
 *  <code>minBreadthMember</code> member; the layout will still be overflowed in this case
 * and the reported size from {@link com.smartgwt.client.widgets.Canvas#getWidth Canvas.getWidth()} or {@link
 * com.smartgwt.client.widgets.Canvas#getHeight Canvas.getHeight()} won't
 *  change, but all members should fill the visible width or height along the breadth axis
 *  </ul><P>
 *  For the last approach, given the VLayout <code>myLayout</code> and a member <code>
 * myWideMember</code>, then we could define the following {@link com.smartgwt.client.widgets.Canvas#addResizedHandler
 * resized()} handler on <code>myLayout</code>:
 *  
 *  <pre>
 *  myLayout.addResizedHandler(new ResizedHandler() {
 *      &#64;Override
 *      public void onResized(ResizedEvent event) {
 *          int memberWidth = myWideMember.getVisibleWidth();
 *          myLayout.setWidth(Math.max(myLayout.getWidth(), memberWidth + offset));
 *  }</pre>
 *  
 *  where <code>offset</code> reflects the difference in width (due to margins, padding,
 *  etc.) between the layout and its widest member.  In most cases, a fixed offset can
 *  be used, but it can also be computed via the calculation:
 *  <P>
 *  <pre>
 *      myLayout.getWidth() - myLayout.getViewportWidth()
 *  </pre>
 *  by
 *  adding a {@link com.smartgwt.client.widgets.Canvas#addDrawHandler draw handler}
 *  for <code>myLayout</cOde>.  (That calculation is not always valid inside the 
 *  {@link com.smartgwt.client.widgets.Canvas#addResizedHandler resized()} handler itself.)
 *  <P>
 *  Note: the HLayout case is similar- just substitute height where width appears above.
 *  <P>
 *  See also {@link com.smartgwt.client.widgets.layout.Layout#getOverflow Layout.overflow}.
 */
public enum LayoutPolicy implements ValueEnum {
    /**
     * Layout does not try to size members on the axis at all, merely stacking them (length axis) and leaving them at default
     * breadth.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * Layout sizes members so that they fill the specified size of the layout. The rules are: <ul> <li> Any component given an
     * initial pixel size, programmatically resized to a specific pixel size, or drag resized by user action is left at that
     * exact size <li> Any component that {@link com.smartgwt.client.widgets.Button#getAutoFit autofits} is given exactly the
     * space it needs, never forced to take up more. <li> All other components split the remaining space equally, or according
     * to their relative percentages. <li> Any component that declares a {@link com.smartgwt.client.widgets.Canvas#getMinWidth
     * Canvas.minWidth} or {@link com.smartgwt.client.widgets.Canvas#getMinHeight Canvas.minHeight} will never be sized smaller
     * than that size <li> Any component that declares a {@link com.smartgwt.client.widgets.Canvas#getMaxWidth Canvas.maxWidth}
     * or {@link com.smartgwt.client.widgets.Canvas#getMaxHeight Canvas.maxHeight} will never be sized larger than that size
     * </ul> In addition, components may declare that they have  {@link com.smartgwt.client.widgets.Canvas#getCanAdaptWidth
     * adaptive sizing}, and may coordinate with the Layout to render at different sizes according to the amount of available
     * space.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fill".
     */
    FILL("fill");
    private String value;

    LayoutPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
