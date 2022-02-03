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
 * <a href='https://www.w3schools.com/Css/css_image_sprites.asp' target='_blank'>Image sprites</a> are a  technique to
 * minimize server http requests when displaying media to a user. Given a series of small images (icons, say), instead of
 * having a separate image file be loaded for each icon,  the server can provide a single large composite image to the
 * client, and the client can use CSS to display sections of this larger image to the user.<br> See also the "spriting"
 * discussion in the {@link com.smartgwt.client.docs.Skinning skinning overview}  documentation. <P> The Smart GWT
 * framework supports the <code>SCSpriteConfig</code> format for sprited images.<br> spriteConfigs have the following
 * format:<br> <code>"sprite:<i>&lt;image
 * URL&gt;</i>;offset:<i>&lt;Left&gt;,&lt;Top&gt;</i>;size:<i>&lt;Width&gt;,&lt;Height&gt;</i>;cssClass:<i>&lt;className&gt;</i>"</code>
 * <P> This format allows developers to specify the image source and the native size and offset of the sprite within the
 * image. <P> The media to load will be retrieved from the specified image URL. Standard  {@link
 * com.smartgwt.client.docs.SCImgURL} directory prefixes such as "[SKIN]" can be included in this URL.<br> An explicit URL
 * is not required - developers may instead specify a css class which can include an explicit <code>background-image</code>
 * attribute. <P> The <code>offset:</code> property specifies the left and top coordinate to apply to the  composite image
 * element such that the desired sprite is visible. The <code>size:</code>  property indicates the size of the sprite in
 * pixels.<br> For example, a sprite configuration of  <i><code>"sprite:composite.png;offset:0,-20;size:20,20;"</code></i>
 * would load the image file "composite.png", and display a 20 pixel square from it. The origin of the larger image would
 * be offset vertically by -20px, so the sprite actually visible to the user would have its y-origin at 20px within the
 * larger image.<br> As with the image URL, explicit size and offset are not required - a developer may use css properties
 * (<code>width</code>, <code>height</code> and <code>background-offset</code>) from the specified class to specify the
 * specific sprite to display. <P> The <code>cssClass:</code> denotes the css class to apply to the rendered element
 * displaying the sprite. This is optional - a sprite can be specified with an image URL and explicit sizing and offset
 * coordinates, in which case no css class is actually required.<br> (Of course for a valid sprite, it is expected that the
 * image URL and size are specified either explicitly in the string, or within the css class definition. If the offset is
 * omitted, it will be assumed to be zero on both axes). <P> Sprites will scale automatically. If a spriteConfig is used to
 * provide an image for an icon and some other property is used to configure the drawn size of the icon in question ({@link
 * com.smartgwt.client.widgets.Button#getIconSize Button.iconSize},for example), the sprite image will be scaled to render
 * at the appropriate size. <P> <b>Sprited image configuration and "stateful" images</b><br> Many image URLs in Smart GWT
 * are "stateful", meaning that variants of the image should be  displayed to the user depending on the current state of
 * the widget.  (For example a custom button icon may be {@link com.smartgwt.client.widgets.Button#getShowRollOverIcon
 * displayed on roll over}, or a selection checkbox icon in a treeGrid  {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getShowDisabledSelectionCheckbox may appear disabled} for unselectable nodes).
 * <P> There are a couple of approaches to display stateful versions of sprited images. <P> Wherever {@link
 * com.smartgwt.client.widgets.SCStatefulImgConfig} objects are supported, a developer may include  spriteConfig strings as
 * entries for specific states.<br> For example, the following SCStatefulImgConfig definition would display different
 * sprites from <i>"compositeImg.png"</i> for base and "Over" states:<br> <code>&nbsp;&nbsp;{
 * _base:"sprite:compositeImg.png;offset:-100,-100;size:20,20",<br>          
 * &nbsp;&nbsp;&nbsp;&nbsp;Over:"sprite:compositeImg.png;offset:-100,-120;size:20,20" }</code> <P> Alternatively, if a
 * property that behaves as the base URL for a stateful image  (such as {@link com.smartgwt.client.widgets.Button#getIcon
 * Button.icon}) is set to a sprite configuration string,  the framework will use the state name as a suffix to apply to
 * the source URL or the css class specified in the sprite.<br> As with standard {@link
 * com.smartgwt.client.docs.StatefulImages stateful images}, if a URL was specified for the sprite, the stateful suffix
 * will be applied with a preceding "_" character.<br> So if the state "Over" was applied to a sprite configuration of 
 * <code>"sprite:compositeImg.png;offset:100,100;size:20,20"</code>, the generated HTML would attempt to load an image from
 * the URL <code>"compositeImg_Over.png"</code> (and display a sprite from that image with the specified size/offset).<br>
 * If a class name was specified in the sprite, the stateful suffix would be appended with no leading underscore, similar
 * to how {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix state suffixes} are applied to the 
 * <code>baseStyle</code> of a StatefulCanvas.<br> For example a sprite config of <code>"sprite:cssClass:buttonIcon"</code>
 * would display  styling from <code>"buttonIconOver"</code> when the "Over" state was applied.
 */
public interface SCSpriteConfig extends SCImgURL {
}
