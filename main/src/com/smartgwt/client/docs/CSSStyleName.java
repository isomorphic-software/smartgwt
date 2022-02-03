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
/* sgwtgen */
 
/**
 * CSS class name to apply to some HTML element on this page. This is a string that should match the css class defined for
 * the page in an external stylesheet or in inline html &lt;STYLE&gt; tags. <P> As a general rule, wherever it is possible
 * to provide a CSS styleName (such as {@link com.smartgwt.client.widgets.Canvas#getStyleName Canvas.styleName} or {@link
 * com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle}, your CSS style can specify border, margins, padding,
 * and any CSS attributes controlling background or text styling.  You should not specify any CSS properties related to
 * positioning, clipping, sizing or visibility (such as "overflow", "position", "display", "visibility" and "float") - use
 * Smart GWT APIs for this kind of control. <P> Because text wrapping cannot be consistently controlled cross-browser from
 * CSS alone, you should use Smart GWT properties such as {@link com.smartgwt.client.widgets.Button#getWrap Button.wrap}
 * instead of the corresponding CSS properties, when provided. <P> Content contained within Smart GWT components can use
 * arbitrary CSS, with the caveat that the content should be tested on all supported browsers, just as content outside of
 * Smart GWT must be. <P> <b>Special note on CSS margins</b>: wherever possible, use CSS padding and border in lieu of CSS
 * margins, or non-CSS approaches such as {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin
 * Layout.layoutMargin}, {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}, or absolute positioning
 * (including specifying percentage left/top coordinates).  We recommend this because CSS specifies a very complicated and
 * widely criticized "margin-collapse" behavior which has surprising effects when margins exist on both parents and
 * children.  Compounding the problem, margins are implemented very differently on different browsers, especially when it
 * comes to HTML margins. <p> <b>Note about CSS "box models"</b> <p> The CSS "box model" defines whether the size applied
 * to a DOM element includes padding, borders or margins, or whether such settings effectively <b>increase</b> the size of
 * the component beyond the size specified in CSS. <p> In Smart GWT, the size configured for a component <i>includes</i>
 * border, padding and margins if specified (in CSS terminology, the box model is "margin-box").  This allows CSS borders,
 * margins and padding to be treated as purely visual properties with no effect on sizing or layout.
 */
public interface CSSStyleName  {
}
