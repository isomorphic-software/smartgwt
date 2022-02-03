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
 * The different ways in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} of a
 * {@link com.smartgwt.client.widgets.drawing.DrawItem} can be rotated with the item. <p> <strong>NOTE:</strong> The effect
 * of the  {@link com.smartgwt.client.types.TitleRotationMode#WITH_ITEM_ALWAYS_UP} and {@link
 * com.smartgwt.client.types.TitleRotationMode#WITH_LINE_ALWAYS_UP} settings is not affected by the global rotation, if any
 * (see {@link com.smartgwt.client.widgets.drawing.DrawPane#getRotation DrawPane.rotation}).
 */
public enum TitleRotationMode implements ValueEnum {
    /**
     * the <code>titleLabel</code> is never rotated with the item.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "neverRotate".
     */
    NEVER_ROTATE("neverRotate"),
    /**
     * the <code>titleLabel</code> is rotated exactly to match the item's rotation (see {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getRotation DrawItem.rotation}).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "withItem".
     */
    WITH_ITEM("withItem"),
    /**
     * the <code>titleLabel</code> is rotated exactly to match the item's rotation, except that at certain rotations, the
     * <code>titleLabel</code> is flipped by 180&deg; so that the title text is never upside down.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "withItemAlwaysUp".
     */
    WITH_ITEM_ALWAYS_UP("withItemAlwaysUp"),
    /**
     * (applies only to {@link com.smartgwt.client.widgets.drawing.DrawLine} and {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath}) the <code>titleLabel</code> is rotated to match the line or center
     * segment. <p> If used on a <code>DrawItem</code> that is not a <code>DrawLine</code> or <code>DrawLinePath</code>, then
     * the effect is the same as  {@link com.smartgwt.client.types.TitleRotationMode#WITH_ITEM}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "withLine".
     */
    WITH_LINE("withLine"),
    /**
     * (applies only to {@link com.smartgwt.client.widgets.drawing.DrawLine} and {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath}) the <code>titleLabel</code> is rotated to match the line or center
     * segment, except that at certain rotations, the <code>titleLabel</code> is flipped by 180&deg; so that the title text is
     * never upside down. <p> If used on a <code>DrawItem</code> that is not a <code>DrawLine</code> or
     * <code>DrawLinePath</code>, then the effect is the same as  {@link
     * com.smartgwt.client.types.TitleRotationMode#WITH_ITEM_ALWAYS_UP}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "withLineAlwaysUp".
     */
    WITH_LINE_ALWAYS_UP("withLineAlwaysUp");
    private String value;

    TitleRotationMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
