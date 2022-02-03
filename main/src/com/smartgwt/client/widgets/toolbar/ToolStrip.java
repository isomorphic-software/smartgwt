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
 
package com.smartgwt.client.widgets.toolbar;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Base class for creating toolstrips like those found in browsers and office applications: a mixed set of controls
 * including {@link com.smartgwt.client.widgets.ImgButton icon buttons},  {@link
 * com.smartgwt.client.widgets.Button#getRadioGroup radio button groups}, {@link
 * com.smartgwt.client.widgets.menu.MenuButton menus}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem
 * comboBoxes}, {@link com.smartgwt.client.widgets.layout.LayoutSpacer spacers}, {@link com.smartgwt.client.widgets.Label
 * status displays} and  {@link com.smartgwt.client.widgets.form.fields.SelectItem drop-down selects}.   <P> All of the
 * above components are placed in the {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers members array} to
 * form a ToolStrip.  Note that the {@link com.smartgwt.client.widgets.form.fields.FormItem FormItems} mentioned above
 * (ComboBox and drop-down selects) need to be placed within a {@link com.smartgwt.client.widgets.form.DynamicForm} as
 * usual. <P>   Instances of the following classes can be used to add special behaviors: <ul> <li>the {@link
 * com.smartgwt.client.widgets.toolbar.ToolStripSeparator} class will show a separator. <li>the {@link
 * com.smartgwt.client.widgets.toolbar.ToolStripResizer} class will show a resizer. This is equivalent to setting {@link
 * com.smartgwt.client.widgets.Canvas#getShowResizeBar showResizeBar:true} on the preceding member. <li>the {@link
 * com.smartgwt.client.widgets.toolbar.ToolStripSpacer} class will show a spacer. </ul> See the <a
 * href="http://www.smartclient.com/smartgwt/showcase/#toolstrip" target="examples">ToolStrips Example</a> example.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ToolStrip")
public class ToolStrip extends Layout {

    public static ToolStrip getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ToolStrip(jsObj);
        } else {
            assert refInstance instanceof ToolStrip;
            return (ToolStrip)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ToolStrip.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ToolStrip.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ToolStrip.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ToolStrip.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ToolStrip(){
        scClassName = "ToolStrip";
    }

    public ToolStrip(JavaScriptObject jsObj){
        scClassName = "ToolStrip";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * DynamicForm instance created by {@link com.smartgwt.client.widgets.toolbar.ToolStrip#addFormItem addFormItem()} to
     * contain form items for display in this toolStrip. Each time addFormItem() is run, a new formWrapper autoChild will be
     * created, picking up properties according to the standard {@link com.smartgwt.client.types.AutoChild} pattern.
     *
     * @return null
     */
    public DynamicForm getFormWrapper()  {
        return null;
    }
    
    
    
    

    /**
     * If set, this attribute affects the alignment of the titles in  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup
     * ToolStripGroups}.  You can override this at the  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign
     * individual ToolStripGroup} level.
     *
     * @param groupTitleAlign New groupTitleAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setGroupTitleAlign(Alignment groupTitleAlign)  throws IllegalStateException {
        return (ToolStrip)setAttribute("groupTitleAlign", groupTitleAlign == null ? null : groupTitleAlign.getValue(), false);
    }

    /**
     * If set, this attribute affects the alignment of the titles in  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup
     * ToolStripGroups}.  You can override this at the  {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign
     * individual ToolStripGroup} level.
     *
     * @return Current groupTitleAlign value. Default value is "center"
     */
    public Alignment getGroupTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("groupTitleAlign"));
    }
    

    /**
     * If set, this attribute affects the orientation of the titles in  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups}.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign individual ToolStripGroup} level.
     *
     * @param groupTitleOrientation New groupTitleOrientation value. Default value is "top"
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setGroupTitleOrientation(VerticalAlignment groupTitleOrientation)  throws IllegalStateException {
        return (ToolStrip)setAttribute("groupTitleOrientation", groupTitleOrientation == null ? null : groupTitleOrientation.getValue(), false);
    }

    /**
     * If set, this attribute affects the orientation of the titles in  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups}.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#getTitleAlign individual ToolStripGroup} level.
     *
     * @return Current groupTitleOrientation value. Default value is "top"
     */
    public VerticalAlignment getGroupTitleOrientation()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("groupTitleOrientation"));
    }
    
    
    

    /**
     * Customized resizeBar with typical appearance for a ToolStrip.
     *
     * @param resizeBarClass New resizeBarClass value. Default value is "ToolStripResizer"
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setResizeBarClass(String resizeBarClass)  throws IllegalStateException {
        return (ToolStrip)setAttribute("resizeBarClass", resizeBarClass, false);
    }

    /**
     * Customized resizeBar with typical appearance for a ToolStrip.
     *
     * @return Current resizeBarClass value. Default value is "ToolStripResizer"
     */
    public String getResizeBarClass()  {
        return getAttributeAsString("resizeBarClass");
    }
    

    /**
     * Thickness of the resizeBars in pixels.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resizeBarSize New resizeBarSize value. Default value is 14
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setResizeBarSize(int resizeBarSize)  throws IllegalStateException {
        return (ToolStrip)setAttribute("resizeBarSize", resizeBarSize, false);
    }

    /**
     * Thickness of the resizeBars in pixels.
     *
     * @return Current resizeBarSize value. Default value is 14
     */
    public int getResizeBarSize()  {
        return getAttributeAsInt("resizeBarSize");
    }
    

    /**
     * Class to create when the string "separator" appears in {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers
     * members}.
     *
     * @param separatorClass New separatorClass value. Default value is "ToolStripSeparator"
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setSeparatorClass(String separatorClass)  throws IllegalStateException {
        return (ToolStrip)setAttribute("separatorClass", separatorClass, false);
    }

    /**
     * Class to create when the string "separator" appears in {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getMembers
     * members}.
     *
     * @return Current separatorClass value. Default value is "ToolStripSeparator"
     */
    public String getSeparatorClass()  {
        return getAttributeAsString("separatorClass");
    }
    

    /**
     * Separator thickness in pixels
     *
     * @param separatorSize New separatorSize value. Default value is 8
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setSeparatorSize(int separatorSize)  throws IllegalStateException {
        return (ToolStrip)setAttribute("separatorSize", separatorSize, false);
    }

    /**
     * Separator thickness in pixels
     *
     * @return Current separatorSize value. Default value is 8
     */
    public int getSeparatorSize()  {
        return getAttributeAsInt("separatorSize");
    }
    

    /**
     * If set, this attribute affects whether {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups} in
     * this ToolStrip show their header control.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#setShowTitle individual ToolStripGroup} level.
     *
     * @param showGroupTitle New showGroupTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ToolStrip setShowGroupTitle(Boolean showGroupTitle)  throws IllegalStateException {
        return (ToolStrip)setAttribute("showGroupTitle", showGroupTitle, false);
    }

    /**
     * If set, this attribute affects whether {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup ToolStripGroups} in
     * this ToolStrip show their header control.  You can override this at the  {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripGroup#setShowTitle individual ToolStripGroup} level.
     *
     * @return Current showGroupTitle value. Default value is true
     */
    public Boolean getShowGroupTitle()  {
        Boolean result = getAttributeAsBoolean("showGroupTitle");
        return result == null ? true : result;
    }
    

    /**
     * CSS class applied to this toolstrip. <P> Note that if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical
     * vertical} is true for this toolStrip,  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVerticalStyleName
     * verticalStyleName} will be used instead of this value if it is non-null.
     *
     * @param styleName New styleName value. Default value is "toolStrip"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class applied to this toolstrip. <P> Note that if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical
     * vertical} is true for this toolStrip,  {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVerticalStyleName
     * verticalStyleName} will be used instead of this value if it is non-null.
     *
     * @return Current styleName value. Default value is "toolStrip"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ToolStrip setVertical(Boolean vertical)  throws IllegalStateException {
        return (ToolStrip)setAttribute("vertical", vertical, false);
    }

    /**
     * Indicates whether the components are drawn horizontally from left to right (false), or vertically from top to bottom
     * (true).
     *
     * @return Current vertical value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? false : result;
    }
    

    /**
     * Default stylename to use if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical this.vertical} is true. If
     * unset, the standard {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getStyleName styleName} will be used for both
     * vertical and horizontal toolstrips. <P> Note that this property only applies to the widget at init time. To modify the 
     * styleName after this widget has been initialized, you should simply call {@link
     * com.smartgwt.client.widgets.Canvas#setStyleName setStyleName()} rather than updating this  property.
     *
     * @param verticalStyleName New verticalStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.toolbar.ToolStrip ToolStrip} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ToolStrip setVerticalStyleName(String verticalStyleName)  throws IllegalStateException {
        return (ToolStrip)setAttribute("verticalStyleName", verticalStyleName, false);
    }

    /**
     * Default stylename to use if {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getVertical this.vertical} is true. If
     * unset, the standard {@link com.smartgwt.client.widgets.toolbar.ToolStrip#getStyleName styleName} will be used for both
     * vertical and horizontal toolstrips. <P> Note that this property only applies to the widget at init time. To modify the 
     * styleName after this widget has been initialized, you should simply call {@link
     * com.smartgwt.client.widgets.Canvas#setStyleName setStyleName()} rather than updating this  property.
     *
     * @return Current verticalStyleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getVerticalStyleName()  {
        return getAttributeAsString("verticalStyleName");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param toolStripProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ToolStrip toolStripProperties) /*-{
        if (toolStripProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ToolStrip.@java.lang.Object::getClass()(), "setDefaultProperties", toolStripProperties.@java.lang.Object::getClass()());
        }
        toolStripProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = toolStripProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ToolStrip.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Add a FormItem to the ToolStrip.
     *
     * @param formItem the formItem
     */
    public void addFormItem(FormItem formItem) {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setCellPadding(3);
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);
        applyWidth(dynamicForm.getConfig(), formItem.getJsObj());
        addMember(dynamicForm);
    }

    /**
     * Add a FormItem to the ToolStrip.
     *
     * @param formItem the FormItem
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addFormItem(FormItem formItem, int position) {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setCellPadding(3);
        dynamicForm.setMinWidth(50);
        dynamicForm.setNumCols(1);
        dynamicForm.setFields(formItem);
        applyWidth(dynamicForm.getConfig(), formItem.getJsObj());
        addMember(dynamicForm, position);
    }

    //set the width of the form to match that of the form item. using native method because width can be int or String
    private static native void applyWidth(JavaScriptObject formJS, JavaScriptObject itemJS)/*-{
        formJS.width = itemJS.width;
    }-*/;

    /**
     * Add a button to the ToolStrip.
     *
     * @param button the toolstrip button
     */
    public void addButton(ToolStripButton button) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }

        addMember(button);
    }

    /**
     * Add a button to the ToolStrip.
     *
     * @param button the button
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addButton(ToolStripButton button, int position) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button, position);
    }

    /**
     * Add a menu button to the ToolStrip.
     *
     * @param button the toolstrip menu button
     */
    public void addMenuButton(ToolStripMenuButton button) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button);
    }

    /**
     * Add a menu button to the ToolStrip.
     *
     * @param button the menu button
     * @param position the position in the layout to place newMember (starts with 0); if omitted, it will be added at
     *                  the last position
     */
    public void addMenuButton(ToolStripMenuButton button, int position) {
        if(button.getTitle() == null) {
            button.setIconSpacing(0);
            button.setLabelHPad(3);
        } else if (button.getIcon() == null) {
            button.setLabelHPad(7);
        }
        addMember(button, position);
    }

    /**
     * Add an extra space to the right of the previously added ToolStrip element. This is a shortcut for {@link #addSpacer(ToolStripSpacer)}.
     *
     * @param space space
     */
    public void addSpacer(int space) {
        addSpacer(new ToolStripSpacer(space));
    }
    
    /**
     * Add an extra space to the right of the previously added ToolStrip element.
     *
     * @param toolStripSpacer the toolstip spacer.
     */
    public void addSpacer(ToolStripSpacer toolStripSpacer) {
        LayoutSpacer canvas = new LayoutSpacer();
        if (this.getVertical()) {
        	canvas.setHeight(toolStripSpacer.getSpace());
        } else {
        	canvas.setWidth(toolStripSpacer.getSpace());
        }
        addMember(canvas);
    }

    /**
     * Adds a ToolStripSpacer to the ToolStrip to take up space such like a normal member, without actually drawing anything.
     * This causes the "next" member added to the toolstip to be right / bottom justified depending on the
     * {@link com.smartgwt.client.widgets.toolbar.ToolStrip#setAlign(com.smartgwt.client.types.VerticalAlignment) alignment}
     * of the ToolStrip.
     */
    public void addFill() {
        addMember(new ToolStripSpacer());
    }

    /**
     * Add a {@link com.smartgwt.client.widgets.toolbar.ToolStripSeparator separator}.
     */
    public void addSeparator() {
        addMember(new ToolStripSeparator());
    }

    /**
     * Add a {@link com.smartgwt.client.widgets.toolbar.ToolStripResizer resizer}
     */
    public void addResizer() {
        addMember(new ToolStripResizer());
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ToolStripLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.groupTitleAlign = getAttributeAsString("groupTitleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.groupTitleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.groupTitleOrientation = getAttributeAsString("groupTitleOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.groupTitleOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.resizeBarClass = getAttributeAsString("resizeBarClass");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.resizeBarClass:" + t.getMessage() + "\n";
        }
        try {
            s.resizeBarSize = getAttributeAsString("resizeBarSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.resizeBarSize:" + t.getMessage() + "\n";
        }
        try {
            s.separatorClass = getAttributeAsString("separatorClass");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.separatorClass:" + t.getMessage() + "\n";
        }
        try {
            s.separatorSize = getAttributeAsString("separatorSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.separatorSize:" + t.getMessage() + "\n";
        }
        try {
            s.showGroupTitle = getAttributeAsString("showGroupTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.showGroupTitle:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.verticalStyleName = getAttributeAsString("verticalStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ToolStrip.verticalStyleName:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ToolStripLogicalStructure s = new ToolStripLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
