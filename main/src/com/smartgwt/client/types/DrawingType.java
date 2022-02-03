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
 * The type of drawing back-end used by a {@link com.smartgwt.client.widgets.drawing.DrawPane} to draw its {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getDrawItems draw items} on screen. <h3>SVG and bitmap tradeoffs</h3> <ul
 * style="list-style-type: lower-alpha;"> <li>SVG is best supported in IE9+ and Opera 12.16 and earlier, but may also be
 * used in Chrome, Opera 15+, Firefox 4+, and Safari. <li>SVG tends to be higher quality, especially when it comes to text
 * and drawing on high-DPI displays and mobile devices. <li>{@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex
 * DrawItem.zIndex}, {@link com.smartgwt.client.widgets.drawing.DrawItem#bringToFront DrawItem.bringToFront()}, and {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#sendToBack DrawItem.sendToBack()} are not supported on iOS devices in
 * bitmap drawing mode due to platform limitations. These APIs are supported on iOS in SVG drawing mode. <li>Incremental
 * updates to just a few elements of a drawing are faster in SVG, whereas whole drawing refreshes are faster in bitmap
 * mode. <li>Browsers have limits on the maximum dimensions or area of the &lt;canvas&gt; element used in bitmap drawing.
 * The limits on a &lt;canvas&gt; imposed by the browser translate to the same limits on the dimensions or area of a
 * <code>DrawPane</code> using bitmap drawing. Internet Explorer, for example, limits the width and height of a
 * &lt;canvas&gt; to 8192 pixels: <a href='http://msdn.microsoft.com/en-us/library/ie/ff975062(v=vs.85).aspx'
 * target='_blank'>http://msdn.microsoft.com/en-us/library/ie/ff975062(v=vs.85).aspx</a>; therefore, in IE using bitmap
 * drawing, a <code>DrawPane</code> can be at most 8192&times;8192 in size. To make larger drawings, you can either switch
 * to SVG drawing, use multiple <code>DrawPane</code>s, or enable {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll drag-scrolling}. <li>In bitmap drawing, each pixel uses
 * around 4 to 8 bytes of memory. Large bitmap drawings can therefore use a lot of memory. A 4000&times;2000 bitmap drawing
 * will use around 31 to 61 Megabytes of memory.<br> Note: To minimize memory use when using bitmap drawing for a large
 * drawing, it may be useful to employ <a href='http://en.wikipedia.org/wiki/Slicing_(interface_design)'
 * target='_blank'>slicing</a> if possible. For example, if the drawing is mostly a solid color except for content located
 * at a few small-area places on screen, a {@link com.smartgwt.client.widgets.Canvas} can be created with the solid
 * background color and one <code>DrawPane</code> can be created for each content area. Each <code>DrawPane</code> is
 * {@link com.smartgwt.client.widgets.Canvas#addChild added as a child} to the <code>Canvas</code>. The {@link
 * com.smartgwt.client.widgets.Canvas#getLeft left} and {@link com.smartgwt.client.widgets.Canvas#getTop top} properties of
 * the <code>DrawPane</code>s are used to absolutely-position them within the <code>Canvas</code> parent. </ul>
 */
public enum DrawingType implements ValueEnum {
    /**
     * Use Scalable Vector Graphics (SVG). SVG is a W3C standard supported by IE9+, Chrome, Firefox 4+, Safari, and Opera.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "svg".
     */
    SVG("svg"),
    /**
     * Use an HTML5 &lt;canvas&gt; element. "bitmap" drawing is supported by IE9+, Chrome, Firefox, Safari, and Opera.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "bitmap".
     */
    BITMAP("bitmap"),
    /**
     * Use Vector Markup Language (VML). VML is a deprecated vector graphics technology supported only by Internet Explorer 6
     * through 9. In IE 6, 7, and 8, "vml" drawing is the only supported drawing back-end.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "vml".
     */
    VML("vml");
    private String value;

    DrawingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
