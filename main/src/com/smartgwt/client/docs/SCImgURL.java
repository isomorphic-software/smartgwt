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
 * Properties that refer to images by URL, such as {@link com.smartgwt.client.widgets.Img#getSrc src} and {@link
 * com.smartgwt.client.widgets.Button#getIcon icon}, are specially interpreted in Smart GWT to allow for simpler and more
 * uniform image URLs, and to allow applications to be restructured more easily. <P> <b>the application image directory</b>
 * <P> When specifying URLs to image files via Smart GWT component properties such as {@link
 * com.smartgwt.client.widgets.StretchImg#getSrc src}, any relative path is assumed to be relative to the "application
 * image directory" (<code>appImgDir</code>).  The application image directory can be set via {@link
 * com.smartgwt.client.util.Page#setAppImgDir Page.setAppImgDir}, and defaults to "images/", representing the typical
 * practice of placing images in a subdirectory relative to the URL at which the application is accessed. <P> For
 * applications that may be launched from multiple URLs, the <code>appImgDir</code> can be  set to the correct relative
 * path to the image directory by calling {@link com.smartgwt.client.util.Page#setAppImgDir Page.setAppImgDir} before any
 * Smart GWT components are created.  This enables applications or components of an application to be launched from
 * multiple locations, or to be relocated, without changing any image URLs supplied to Smart GWT components. <P> <b>the
 * "[SKIN]" URL prefix</b> <P> The special prefix "[SKIN]" can be used to refer to images within the skin folder whenever
 * image URLs are supplied to Smart GWT components. <P> The value of "[SKIN]" is the combination of:  <ul> <li> the "skin
 * directory", established in <code>load_skin.js</code> via {@link com.smartgwt.client.util.Page#setSkinDir
 * Page.setSkinDir}, plus.. <li> the setting for {@link com.smartgwt.client.widgets.Canvas#getSkinImgDir skinImgDir} on the
 * component where you set an image URL property </ul> <code>skinImgDir</code> defaults to "images/", so creating an {@link
 * com.smartgwt.client.widgets.Img} component with {@link com.smartgwt.client.widgets.Img#getSrc src} set to
 * "[SKIN]myButton/button.gif" will expand to <code>Page.getSkinDir() + "/images/myButton/button.gif"</code>. <P> Some
 * components that use a large number of images use <code>skinImgDir</code> to group them together and make it possible to
 * relocate all the media for the component with a single setting. For example, the {@link
 * com.smartgwt.client.widgets.tree.TreeGrid} class sets <code>skinImgDir</code> to "images/TreeGrid/". This allows {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} to be set to just "[SKIN]folder.gif" but refer to
 * <code>Page.getSkinDir() + "/images/TreeGrid/folder.gif"</code>. <P> A custom subclass of TreeGrid can set
 * <code>skinImgDir</code> to a different path, such as  "/images/MyTreeGrid", to source all media from a different
 * location. <P> TIPS: <ul> <li> subcomponents may not share the parent component's setting for skinImgDir.  For example,
 * the {@link com.smartgwt.client.widgets.Window#getMinimizeButton minimizeButton} has the default setting for "skinImgDir"
 * ("images/"), so the {@link com.smartgwt.client.widgets.Img#getSrc src} property used with this component is set to
 * "[SKIN]/Window/minimize.png" (in the "Smart GWT" sample skin). <li> for a particular image, the skinImgDir setting on
 * the component may not be convenient.  The prefix "[SKINIMG]" can be used to refer to <code>Page.getSkinDir() +
 * "/images"</code> regardless of the setting for <code>skinImgDir</code> </ul> <B>Stateful image URLs</B> <P> Many image
 * URLs in Smart GWT are "stateful", meaning that the actual URL used to fetch an image will vary according to the
 * component's state (eg, "Disabled"), generally, by adding a suffix to the image URL.  See the {@link
 * com.smartgwt.client.docs.Skinning Skinning Overview} for more information on statefulness and the {@link
 * com.smartgwt.client.widgets.Img#getSrc src} documentation for information on how stateful image URLs are formed.
 */
public interface SCImgURL  {
}
        
