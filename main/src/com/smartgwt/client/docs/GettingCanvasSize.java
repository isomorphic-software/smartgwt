
package com.smartgwt.client.docs;

/**
 * <h3>Determining the size of a drawn canvas</h3>
 * A canvas's size is determined by its specified {@link
 * com.smartgwt.client.widgets.Canvas#getWidth width},  {@link
 * com.smartgwt.client.widgets.Canvas#getHeight height} as well as its {@link
 * com.smartgwt.client.widgets.Canvas#getOverflow overflow}. <P> The following methods are
 * available to retrieve the size of a canvas at runtime: <table border=1> <tr><td>{@link
 * com.smartgwt.client.widgets.Canvas#getWidth Canvas.getWidth()}, {@link
 * com.smartgwt.client.widgets.Canvas#getHeight Canvas.getHeight()}</td>     <td><p>Returns the
 * specified size of the component in pixels. If height         or width were specified as a
 * {@link com.smartgwt.client.docs.PercentSizing percentage value},         this method will
 * return the resolved absolute size.</p></td></tr> <tr><td>{@link
 * com.smartgwt.client.widgets.Canvas#getInnerWidth Canvas.getInnerWidth()}, {@link
 * com.smartgwt.client.widgets.Canvas#getInnerHeight Canvas.getInnerHeight()}</td>    
 * <td><p>Returns the amount of space available for absolutely positioned child widget(s) or      
 * absolutely positioned HTML content, without introducing clipping, scrolling or overflow.       
 * </p><p>         This is the space within the viewport of the widget (including padding, but
 * excluding         margins, borders or scrollbars) rendered at its specified size.</p></td></tr>
 * <tr><td>{@link com.smartgwt.client.widgets.Canvas#getInnerContentWidth
 * Canvas.getInnerContentWidth()}, {@link com.smartgwt.client.widgets.Canvas#getInnerContentHeight
 * Canvas.getInnerContentHeight()}</td>     <td><p>Returns the amount of space available for
 * relatively positioned child widget(s) or         inline positioned HTML content, without
 * introducing clipping, scrolling or overflow.         </p><p>         This is the space within
 * the viewport of the widget (<b>not</b> including padding, excluding         margins, borders or
 * scrollbars) rendered at its specified size.</p></td></tr> <tr><td>{@link
 * com.smartgwt.client.widgets.Canvas#getVisibleWidth Canvas.getVisibleWidth()}, {@link
 * com.smartgwt.client.widgets.Canvas#getVisibleHeight Canvas.getVisibleHeight()}</td>    
 * <td><p>Returns the drawn size of the component in pixels, (including border, margin and
 * scrollbars).          If a widget is undrawn or has {@link
 * com.smartgwt.client.widgets.Canvas#getOverflow overflow} set to something other than "visible",
 * this will match the value returned by {@link com.smartgwt.client.widgets.Canvas#getWidth
 * Canvas.getWidth()} or {@link com.smartgwt.client.widgets.Canvas#getHeight Canvas.getHeight()}. 
 * For an <code>overflow:"visible"</code> canvas this value will be greater than         the
 * specified size if the size of children or content exceeds the available space.</p></td></tr>
 * <tr><td>{@link com.smartgwt.client.widgets.Canvas#getViewportWidth Canvas.getViewportWidth()},
 * {@link com.smartgwt.client.widgets.Canvas#getViewportHeight Canvas.getViewportHeight()}</td>   
 * <td><p>Returns the drawn size of the component's viewport in pixels. This is the same value as 
 * {@link com.smartgwt.client.widgets.Canvas#getVisibleWidth Canvas.getVisibleWidth()} / {@link
 * com.smartgwt.client.widgets.Canvas#getVisibleWidth Canvas.getVisibleWidth()}, less any border,
 * margin         or scrollbars</p></td></tr> <tr><td>{@link
 * com.smartgwt.client.widgets.Canvas#getScrollWidth Canvas.getScrollWidth()}, {@link
 * com.smartgwt.client.widgets.Canvas#getScrollHeight Canvas.getScrollHeight()}</td>    
 * <td><p>Returns the scrollable size of the widget's content, including children.         </p><p>
 * For components with {@link com.smartgwt.client.widgets.Canvas#getOverflow Canvas.overflow} set
 * to something other than "visible", this         value may exceed the {@link
 * com.smartgwt.client.widgets.Canvas#getVisibleWidth drawn size} of the canvas. See also        
 * {@link com.smartgwt.client.widgets.Canvas#getScrollLeft Canvas.getScrollLeft()}, {@link
 * com.smartgwt.client.widgets.Canvas#getScrollTop Canvas.getScrollTop()}.</p></td></tr> </table>
 */
public interface GettingCanvasSize {
}
