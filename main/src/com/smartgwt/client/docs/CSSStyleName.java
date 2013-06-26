package com.smartgwt.client.docs;


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
 
/**
 * CSS class name to apply to some HTML element on this page. This is a string that should match the css class defined for
 * the page in an external stylesheet or in inline html &lt;STYLE&gt; tags. <P> As a general rule, wherever it is possible
 * to provide a CSS styleName (such as {@link com.smartgwt.client.widgets.Canvas#getStyleName styleName} or {@link
 * com.smartgwt.client.widgets.Button#getBaseStyle baseStyle}, your CSS style can specify border, margins, padding, and any
 * CSS attributes controlling background or text styling.  You should not specify any CSS properties related to
 * positioning, clipping, sizing or visibility (such as "overflow", "position", "display", "visibility" and "float") - use
 * Smart GWT APIs for this kind of control. <P> Because text wrapping cannot be consistently controlled cross-browser from
 * CSS alone, you should use Smart GWT properties such as {@link com.smartgwt.client.widgets.Button#getWrap wrap} instead
 * of the corresponding CSS properties, when provided. <P> Content contained within Smart GWT components can use arbitrary
 * CSS, with the caveat that the content should be tested on all supported browsers, just as content outside of Smart GWT
 * must be. <P> <b>Special note on CSS margins</b>: wherever possible, use CSS padding and border in lieu of CSS margins,
 * or non-CSS approaches such as {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin layoutMargin}, {@link
 * com.smartgwt.client.widgets.Canvas#getSnapTo snapTo}, or absolute positioning (including specifying percentage left/top
 * coordinates).  We recommend this because CSS specifies a very complicated and widely criticized "margin-collapse"
 * behavior which surprising effects when margins exist on both parents and children.  Compounding the problem, margins are
 * implemented very differently on different browsers, especially when it comes to HTML margins.
 */
public interface CSSStyleName  {
}
