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
 * Special {@link com.smartgwt.client.docs.SCImgURL} format for specifying sprited image configuration.
 *  <P>
 *  See also the "spriting" discussion in the  {@link com.smartgwt.client.docs.Skinning skinning overview} 
 *  documentation.
 *  <P>
 *  In order to generate HTML to render a properly scaled image sprite from a composite image
 *  file, this format allows developers to specify the image source, native size and
 *  offset of the sprite within the image, and the desired drawn size for the image.<br>
 *  spriteConfigs have the following format:
 *  <pre>
 *   "sprite:<i>&lt;image URL&gt;</i>;offset:<i>&lt;Left&gt;,&lt;Top&gt;</i>;size:<i>&lt;Width&gt;,&lt;Height&gt;</i>;cssClass:<i>&lt;className&gt;</i>"
 *  </pre>
 *  Where supported, the <code>sprite:</code> prefix is used to identify a specified
 *  {@link com.smartgwt.client.docs.SCImgURL} as a sprited image. <br>
 *  The media to load will be retrieved from the specified image URL. Standard 
 *  {@link com.smartgwt.client.docs.SCImgURL} directory prefixes such as "[SKIN]" can be included in this URL.<br>
 *  An explicit URL is not required - developers may also specify a css class which includes
 *  an explicit <code>background-image</code> attribute.<br>
 *  The <code>size:</code> and <code>offset:</code> properties should specify the pixel size
 *  and position of the sprite within the composite image. Again these are not required
 *  and can be specified directly in the css class using <code>width</code> 
 *  and <code>height</code> and
 *  <code>background-offset</code> properties.<br>
 *  The <code>cssClass:</code> denotes the css class to apply to the sprite. This is also
 *  optional - a sprite can be specified with an image URL and explicit sizing and offset
 *  coordinates, in which case no css class is actually required.<br>
 *  (Of course for a valid sprite, it is expected that the image URL and size are specified
 *  either explicitly in the string, or within the css class definition. If the offset is
 *  omitted, it will be assumed to be zero on both axes).
 *  <P>
 *  <b>Sprited image configuration and "stateful" images</b><br>
 *  Many image URLs in Smart GWT are "stateful", meaning that the actual URL used to fetch an
 *  image will vary according to the component's state (eg, "Disabled"), generally, by adding a
 *  suffix to the image URL.<br>
 *  Component image attributes which support "stateful" suffixes are not guaranteed to 
 *  always support having their value set to a SCSpriteConfig string, as special handling
 *  is required both to ensure the stateful suffix is incorporated into the generated HTML
 *  correctly and that logic to update the images state at runtime handles this HTML being
 *  present in the DOM rather than a simple &lt;img...&gt; element.<br>
 *  Where these are supported they will be documented as such. The handling will in these 
 *  cases is as follows:
 *  <ul>
 *  <li>if the configuration includes an explicit image URL, stateful suffixes are combined
 * and appended using <code>"_"</code> characters as described in {@link com.smartgwt.client.widgets.Img#getSrc
 * Img.src}</li>
 *  <li>if the configuration inclues a cssClass, the stateful suffixes will be combined and
 *   appended to the class name (with no <code>"_"</code> characters), as with standard
 *   {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle StatefulCanvas.baseStyle} stateful suffixes</li>
 *  </ul>
 */
public interface SCSpriteConfig extends SCImgURL {
}
