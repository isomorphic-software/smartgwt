/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.google.gwt.user.client.ui.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to preload skin images.
 */
public class FileLoader {

    private static String[] defaultImageStates = new String[]{"Down", "Over", "Disabled"};
    private static String[] defaultEdges = new String[]{"TL", "T", "TR", "L", "R", "BL", "B", "BR"};
    private static String[] defaultPieces = new String[]{"start", "stretch", "end"};

    private static String fileExtensionRegExp = "/(.*)\\.(.*)/";

    /**
     * Return the skin dir.
     *
     * @return the skin dir
     */
    public static native String getSkinDir() /*-{
        return $wnd.isc.Page.getSkinDir();
    }-*/;

    /**
     * Cache a list of images
     *
     * @param skinImgDir    the skinImgDir
     * @param baseImageURLs a list of base urls
     */
    public static void cacheImgs(String skinImgDir, Iterable<String> baseImageURLs) {
        String skinDir = getSkinDir();
        for (String img : baseImageURLs) {
            img = img.replace("[SKINIMG]", skinDir + "images/");
            img = img.replace("[SKIN]", skinDir + skinImgDir);
            Image.prefetch(img);
        }
    }

    /**
     * Cache a list of images
     *
     * @param skinImgDir   the skinImgDir
     * @param baseImageURL the base urls
     */
    public static void cacheImg(String skinImgDir, String baseImageURL) {
        String skinDir = getSkinDir();
        baseImageURL = baseImageURL.replace("[SKINIMG]", skinDir + "images/");
        baseImageURL = baseImageURL.replace("[SKIN]", skinDir + skinImgDir);
        Image.prefetch(baseImageURL);
    }

    /**
     * Caches a set of state images derived from a base image. This is useful for caching a set of images for a single component.
     * For example this code:
     * <br>
     * FileLoader.cacheImgStates("TreeGrid/opener.png","closed,opening,opened");
     * <p/>
     * Will cause the following images to be cached:
     * <p/>
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_closed.png
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_opening.png
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_opened.png
     *
     * @param skinImgDir   the skinImgDir
     * @param baseImageURL the base image path
     * @param states       a list of states to load.
     */
    public static void cacheImgStates(String skinImgDir, String baseImageURL, String states) {
        cacheImgStates(skinImgDir, new String[]{baseImageURL}, states.split(","));
    }


    /**
     * Caches a set of state images derived from a base image. This is useful for caching a set of images for a single component.
     * For example this code:
     * <br>
     * FileLoader.cacheImgStates("TreeGrid/opener.png","closed,opening,opened");
     * <p/>
     * Will cause the following images to be cached:
     * <p/>
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_closed.png
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_opening.png
     * /isomorphic/skins/[skin]/images/TreeGrid/opener_opened.png
     *
     * @param skinImgDir    the skinImgDir
     * @param baseImageURLs the base image paths
     * @param states        a list of states to load.
     */
    public static void cacheImgStates(String skinImgDir, String[] baseImageURLs, String[] states) {
        if (states == null) states = defaultImageStates;
        List<String> urls = addURLSuffix(baseImageURLs, states);
        cacheImgs(skinImgDir, urls);
    }

    /**
     * Caches a set of edge images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURL    the base url
     */
    public static void cacheEdgeImages(String skinImgDir, String baseURL) {
        cacheEdgeImages(skinImgDir, new String[]{baseURL}, null);
    }

    /**
     * Caches a set of edge images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURL    the base url
     * @param edges      List of edges to load.
     */
    public static void cacheEdgeImages(String skinImgDir, String baseURL, String edges) {
        cacheEdgeImages(skinImgDir, new String[]{baseURL}, edges.split(","));
    }

    /**
     * Caches a set of edge images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURL    the base url
     * @param edges      List of edges to load.
     */
    public static void cacheEdgeImages(String skinImgDir, String baseURL, String[] edges) {
        cacheEdgeImages(skinImgDir, new String[]{baseURL}, edges);
    }

    /**
     * Caches a set of edge images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURLs   list of base urls
     * @param edges      List of edges to load.
     */
    public static void cacheEdgeImages(String skinImgDir, String[] baseURLs, String[] edges) {
        if (edges == null) edges = defaultEdges;
        List<String> urls = addURLSuffix(baseURLs, edges);
        cacheImgs(skinImgDir, urls);
    }

    /**
     * Caches a set of state stretch images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURL    base image URL from which stateful names are to be derived
     * @param states     List of states to load.
     */
    public static void cacheStretchImgStates(String skinImgDir, String baseURL, String states) {
        cacheStretchImgStates(skinImgDir, new String[]{baseURL}, states.split(","));
    }

    /**
     * Caches a set of state stretch images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURL    base image URL from which stateful names are to be derived
     * @param states     List of states to load.
     */
    public static void cacheStretchImgStates(String skinImgDir, String baseURL, String[] states) {
        cacheStretchImgStates(skinImgDir, new String[]{baseURL}, states);
    }

    /**
     * Caches a set of state stretch images derived from a base image.
     *
     * @param skinImgDir the skinImgDir
     * @param baseURLs   List of base image URLs from which stateful names are to be derived
     * @param states     List of states to load.
     */
    public static void cacheStretchImgStates(String skinImgDir, String[] baseURLs, String[] states) {

        if (states == null) states = defaultImageStates;

        // include stateless version - e.g. button_start.png
        List<String> urls = addURLSuffix(baseURLs, defaultPieces);

        // add user-specified states - e.g. button_Over_start.png
        List<String> stateURLs = addURLSuffix(baseURLs, states);

        String[] stateURLsArr = (String[]) stateURLs.toArray(new String[stateURLs.size()]);
        stateURLs = addURLSuffix(stateURLsArr, defaultPieces);

        urls.addAll(stateURLs);
        cacheImgs(skinImgDir, urls);
    }

    private static List<String> addURLSuffix(String[] baseImageURLs, String[] states) {

        List<String> results = new ArrayList<String>();

        for (String baseURL : baseImageURLs) {
            //strip query parameters inf any
            int queryIndex = baseURL.indexOf("?");
            String queryPart = "";
            if (queryIndex != -1) {
                baseURL = baseURL.substring(0, queryIndex);
                queryPart = baseURL.substring(queryIndex, baseURL.length());
            }

            String[] regexpResult = baseURL.split("\\.");
            if (regexpResult == null) {
                throw new IllegalArgumentException("Couldn't split baseURL '" + baseURL + "' into basePath and extension - file will not be cached.");
            }

            String baseName = regexpResult[0];
            String extension = regexpResult[1];

            for (String state : states) {
                String url = baseName + "_" + state + "." + extension + queryPart;
                results.add(url);
            }
        }
        return results;
    }
}
