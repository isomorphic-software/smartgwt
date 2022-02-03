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
 */
public enum TourActionType implements ValueEnum {
    /**
     * The {@link com.smartgwt.client.util.tour.TourStep#getTarget target} must be clicked to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "click".
     */
    CLICK("click"),
    /**
     * The target will complete the step on mouseDown
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mouseDown".
     */
    MOUSEDOWN("mouseDown"),
    /**
     * The target must be double-clicked to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "doubleClick".
     */
    DOUBLECLICK("doubleClick"),
    /**
     * The target must be right-clicked to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "rightClick".
     */
    RIGHTCLICK("rightClick"),
    /**
     * The target must be moused-over to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mouseOver".
     */
    MOUSEOVER("mouseOver"),
    /**
     * The target must be dragged to complete step. If {@link com.smartgwt.client.util.tour.TourStep#getDropTarget dropTarget}
     * is also specified, the target component must be dropped onto the <code>dropTarget</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "drag".
     */
    DRAG("drag"),
    /**
     * The target FormItem must change to complete the step. Specify {@link
     * com.smartgwt.client.util.tour.TourStep#getExpectedValue expectedValue} if a specific value must be entered to continue.
     * Depending on the FormItem type this may occur by the user typing or by selecting a value. See {@link
     * com.smartgwt.client.util.tour.TourStep#getInputValidation TourStep.inputValidation} for how validation is performed.
     * <b>Note:</b> for composite formItems such as  {@link com.smartgwt.client.widgets.form.fields.DateItem} or {@link
     * com.smartgwt.client.widgets.form.fields.RadioGroupItem}, you may specify either the item as a whole or a sub item as the
     * target. Either way the tour will look for the expected value on the composite (parent) item.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "change".
     */
    CHANGE("change"),
    /**
     * The target locator should resolve to an item within a Menu that has a sub-menu. The submenu must be opened (by rolling
     * over, or clicking the target) to complete the step.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "menuItemOver".
     */
    MENUITEMOVER("menuItemOver"),
    /**
     * The target locator should resolve to an item within a Menu. The item must be selected (clicked) to complete the step.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "menuItemSelect".
     */
    MENUITEMSELECT("menuItemSelect"),
    /**
     * No interaction is allowed with the target and the user must click the next button to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * Interaction is allowed with the target but the user must click the next button to complete the step
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "any".
     */
    ANY("any");
    private String value;

    TourActionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
