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
 
package com.smartgwt.client.widgets;


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
 * Labels display a small amount of {@link com.smartgwt.client.widgets.Label#getAlign alignable} {@link
 * com.smartgwt.client.widgets.Label#getContents text} with optional {@link com.smartgwt.client.widgets.Label#getIcon icon}
 * and {@link com.smartgwt.client.widgets.Label#getAutoFit autoFit}. <P> For a general-purpose container for HTML content,
 * use {@link com.smartgwt.client.widgets.HTMLFlow} or {@link com.smartgwt.client.widgets.HTMLPane} instead.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Label")
public class Label extends Button {

    public static Label getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Label(jsObj);
        } else {
            assert refInstance instanceof Label;
            return (Label)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Label.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Label.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Label.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Label.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Label(){
        scClassName = "Label";
    }

    public Label(JavaScriptObject jsObj){
        scClassName = "Label";
        setJavaScriptObject(jsObj);
    }


    public Label(String contents) {
        setContents(contents);
                scClassName = "Label";
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
     * Horizontal alignment of label text. See Alignment type for details.
     *
     * @param align New align value. Default value is Canvas.LEFT
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public Label setAlign(Alignment align) {
        return (Label)setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of label text. See Alignment type for details.
     *
     * @return Current align value. Default value is Canvas.LEFT
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * If true, ignore the specified size of this widget and always size just large enough to accommodate the title.  If
     * <code>setWidth()</code> is explicitly called on an autoFit:true button, autoFit will be reset to <code>false</code>. <P>
     * Note that for StretchImgButton instances, autoFit will occur horizontally only, as  unpredictable vertical sizing is
     * likely to distort the media. If you do want vertical  auto-fit, this can be achieved by simply setting a small height,
     * and having  overflow:"visible"
     *
     * @param autoFit New autoFit value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Label setAutoFit(Boolean autoFit) {
        return (Label)setAttribute("autoFit", autoFit, true);
    }

    /**
     * If true, ignore the specified size of this widget and always size just large enough to accommodate the title.  If
     * <code>setWidth()</code> is explicitly called on an autoFit:true button, autoFit will be reset to <code>false</code>. <P>
     * Note that for StretchImgButton instances, autoFit will occur horizontally only, as  unpredictable vertical sizing is
     * likely to distort the media. If you do want vertical  auto-fit, this can be achieved by simply setting a small height,
     * and having  overflow:"visible"
     *
     * @return Current autoFit value. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }
    

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the contents of a widget to newContents, an HTML string. <P> When {@link com.smartgwt.client.widgets.Canvas#getDynamicContents dynamicContents} is set, <code>setContents()</code> can also be called with no arguments to cause contents to be re-evaluated.
     *
     * @param contents an HTML string to be set as the contents of this widget. Default value is "&amp;nbsp;"
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setDynamicContents
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Label setContents(String contents) {
        return (Label)setAttribute("contents", contents, true);
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     * @return Current contents value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.Label#getDynamicContents
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }
    

    /**
     * Dynamic contents allows the contents string to be treated as a simple but powerful template.  When this attribute is set
     * to true, JavaScript expressions may be embedded  within the contents string, using the format:
     * <code>&#36;{<i>[JavaScript to evaluate]</i>}</code>. <P> For example, to include the current date in a templated
     * message,  <code>canvas.contents</code> could be set to:<br> <code>"Today's date is &lt;b&gt;&#36;{new
     * Date().toUSShortDate()}&lt;/b&gt;"</code> <P> Embedded expressions will be evaluated when the canvas is drawn or
     * redrawn, and the result of the evaluated expression will be displayed to the user. If the expression does not evaluate
     * to a String, the <code>toString()</code> representation of the returned object will be displayed automatically <P>
     * Dynamic expressions are evaluated in the scope of the canvas displaying the content,  so the <code>this</code> keyword
     * may be used within your expression to refer to the  canvas. Developers may also explicitly supply values for variables
     * to be used within the evaluation via the {@link com.smartgwt.client.widgets.Canvas#getDynamicContentsVars
     * Canvas.dynamicContentsVars} property. <P> Notes:<ul> <li>Calling markForRedraw() on the canvas will evaluate any
     * embedded expressions.</li> <li>Multiple such expressions may be embedded within the contents string for a
     * component.</li> <li>If an error occurs during evaluation, a warning is logged     to the {@link
     * com.smartgwt.client.docs.Debugging Developer Console} and the error string will be embedded in place      of the
     * expected value in the Canvas. </li> </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dynamicContents New dynamicContents value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setContents
     * @see com.smartgwt.client.widgets.Canvas#setDynamicContentsVars
     * 
     */
    public Label setDynamicContents(Boolean dynamicContents) {
        return (Label)setAttribute("dynamicContents", dynamicContents, true);
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple but powerful template.  When this attribute is set
     * to true, JavaScript expressions may be embedded  within the contents string, using the format:
     * <code>&#36;{<i>[JavaScript to evaluate]</i>}</code>. <P> For example, to include the current date in a templated
     * message,  <code>canvas.contents</code> could be set to:<br> <code>"Today's date is &lt;b&gt;&#36;{new
     * Date().toUSShortDate()}&lt;/b&gt;"</code> <P> Embedded expressions will be evaluated when the canvas is drawn or
     * redrawn, and the result of the evaluated expression will be displayed to the user. If the expression does not evaluate
     * to a String, the <code>toString()</code> representation of the returned object will be displayed automatically <P>
     * Dynamic expressions are evaluated in the scope of the canvas displaying the content,  so the <code>this</code> keyword
     * may be used within your expression to refer to the  canvas. Developers may also explicitly supply values for variables
     * to be used within the evaluation via the {@link com.smartgwt.client.widgets.Canvas#getDynamicContentsVars
     * Canvas.dynamicContentsVars} property. <P> Notes:<ul> <li>Calling markForRedraw() on the canvas will evaluate any
     * embedded expressions.</li> <li>Multiple such expressions may be embedded within the contents string for a
     * component.</li> <li>If an error occurs during evaluation, a warning is logged     to the {@link
     * com.smartgwt.client.docs.Debugging Developer Console} and the error string will be embedded in place      of the
     * expected value in the Canvas. </li> </ul>
     *
     * @return Current dynamicContents value. Default value is false
     * @see com.smartgwt.client.widgets.Label#getContents
     * @see com.smartgwt.client.widgets.Canvas#getDynamicContentsVars
     * 
     */
    public Boolean getDynamicContents()  {
        Boolean result = getAttributeAsBoolean("dynamicContents");
        return result == null ? false : result;
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "LabelEditProxy"
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public Label setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (Label)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "LabelEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Size for this component's vertical dimension.  See {@link com.smartgwt.client.widgets.Canvas#getHeight Canvas.height}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set on non-{@link com.smartgwt.client.widgets.StretchImgButton} instances, this property will be ignored so that the
     * widget is always sized just large enough to accommodate the title.
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.StatefulCanvas#setAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Label setHeight(Integer height) {
        return (Label)setAttribute("height", height, true);
    }

    /**
     * Size for this component's vertical dimension.  See {@link com.smartgwt.client.widgets.Canvas#getHeight Canvas.height}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set on non-{@link com.smartgwt.client.widgets.StretchImgButton} instances, this property will be ignored so that the
     * widget is always sized just large enough to accommodate the title.
     *
     * @return Current height value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#getAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Size for this component's vertical dimension.  See {@link com.smartgwt.client.widgets.Canvas#getHeight Canvas.height}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set on non-{@link com.smartgwt.client.widgets.StretchImgButton} instances, this property will be ignored so that the
     * widget is always sized just large enough to accommodate the title.
     *
     * @param height New height value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#setAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setHeight(String height) {
        setAttribute("height", height, true);
    }

    /**
     * Size for this component's vertical dimension.  See {@link com.smartgwt.client.widgets.Canvas#getHeight Canvas.height}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set on non-{@link com.smartgwt.client.widgets.StretchImgButton} instances, this property will be ignored so that the
     * widget is always sized just large enough to accommodate the title.
     *
     * @return Current height value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#getAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public String getHeightAsString()  {
        return getAttributeAsString("height");
    }
    

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component. A sprited image can be specified using the {@link com.smartgwt.client.docs.SCSpriteConfig}
     * format. <P> Note that the string "blank" is a valid setting for this attribute and will always  result in the system
     * blank image, with no state suffixes applied.  Typically, this  might be used when an iconStyle is also specified and the
     * iconStyle renders the icon via  a stateful background-image or other CSS approach.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the icon being shown next to the title text.
     *
     * @param icon URL of new icon. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIcon(String icon) {
        return (Label)setAttribute("icon", icon, true);
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component. A sprited image can be specified using the {@link com.smartgwt.client.docs.SCSpriteConfig}
     * format. <P> Note that the string "blank" is a valid setting for this attribute and will always  result in the system
     * blank image, with no state suffixes applied.  Typically, this  might be used when an iconStyle is also specified and the
     * iconStyle renders the icon via  a stateful background-image or other CSS approach.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @param iconAlign New iconAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconAlign(String iconAlign)  throws IllegalStateException {
        return (Label)setAttribute("iconAlign", iconAlign, false);
    }

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @return Current iconAlign value. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }
    

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconHeight New iconHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconHeight(Integer iconHeight)  throws IllegalStateException {
        return (Label)setAttribute("iconHeight", iconHeight, false);
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @return Current iconHeight value. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the orientation of the icon relative to the text of the button.
     *
     * @param iconOrientation The new orientation of the icon relative to the text of the button. Default value is "left"
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconOrientation(String iconOrientation)  throws IllegalStateException {
        return (Label)setAttribute("iconOrientation", iconOrientation, false);
    }

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     *
     * @return Current iconOrientation value. Default value is "left"
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }
    

    /**
     * Size in pixels of the icon image. <P> The {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight} properties can be used to configure width
     * and height separately. <P> Note: When configuring the properties of a <code>StatefulCanvas</code> (or derivative) {@link
     * com.smartgwt.client.types.AutoChild AutoChild}, it is best to set the <code>iconWidth</code> and <code>iconHeight</code>
     * to the same value rather than setting an <code>iconSize</code>. This is because certain skins or customizations thereto
     * might set the <code>iconWidth</code> and <code>iconHeight</code>, making the customization of the AutoChild's
     * <code>iconSize</code> ineffective.
     *
     * @param iconSize New iconSize value. Default value is 16
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconSize(int iconSize)  throws IllegalStateException {
        return (Label)setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size in pixels of the icon image. <P> The {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight} properties can be used to configure width
     * and height separately. <P> Note: When configuring the properties of a <code>StatefulCanvas</code> (or derivative) {@link
     * com.smartgwt.client.types.AutoChild AutoChild}, it is best to set the <code>iconWidth</code> and <code>iconHeight</code>
     * to the same value rather than setting an <code>iconSize</code>. This is because certain skins or customizations thereto
     * might set the <code>iconWidth</code> and <code>iconHeight</code>, making the customization of the AutoChild's
     * <code>iconSize</code> ineffective.
     *
     * @return Current iconSize value. Default value is 16
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing New iconSpacing value. Default value is 6
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconSpacing(int iconSpacing)  throws IllegalStateException {
        return (Label)setAttribute("iconSpacing", iconSpacing, false);
    }

    /**
     * Pixels between icon and title text.
     *
     * @return Current iconSpacing value. Default value is 6
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }
    

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconWidth New iconWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setIconWidth(Integer iconWidth)  throws IllegalStateException {
        return (Label)setAttribute("iconWidth", iconWidth, false);
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @return Current iconWidth value. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon New showDisabledIcon value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        return (Label)setAttribute("showDisabledIcon", showDisabledIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @return Current showDisabledIcon value. Default value is true
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDisabledIcon()  {
        Boolean result = getAttributeAsBoolean("showDisabledIcon");
        return result == null ? true : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon New showDownIcon value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        return (Label)setAttribute("showDownIcon", showDownIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @return Current showDownIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDownIcon()  {
        Boolean result = getAttributeAsBoolean("showDownIcon");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @param showFocusedIcon New showFocusedIcon value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setShowFocusedIcon(Boolean showFocusedIcon)  throws IllegalStateException {
        return (Label)setAttribute("showFocusedIcon", showFocusedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @return Current showFocusedIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        Boolean result = getAttributeAsBoolean("showFocusedIcon");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @param showRollOverIcon New showRollOverIcon value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setShowRollOverIcon(Boolean showRollOverIcon)  throws IllegalStateException {
        return (Label)setAttribute("showRollOverIcon", showRollOverIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @return Current showRollOverIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        Boolean result = getAttributeAsBoolean("showRollOverIcon");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon New showSelectedIcon value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Label setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        return (Label)setAttribute("showSelectedIcon", showSelectedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @return Current showSelectedIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowSelectedIcon()  {
        Boolean result = getAttributeAsBoolean("showSelectedIcon");
        return result == null ? false : result;
    }
    

    /**
     * Set the CSS class for this widget.  For a Label, this is equivalent to setting {@link
     * com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Dynamically change the CSS class for this widget.  For a Label, this is equivalent to {@link com.smartgwt.client.widgets.StatefulCanvas#setBaseStyle setBaseStyle()}.
     *
     * @param styleName new CSS style name. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Set the CSS class for this widget.  For a Label, this is equivalent to setting {@link
     * com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle}.
     *
     * @return Current styleName value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Vertical alignment of label text. See VerticalAlignment type for details.
     *
     * @param valign New valign value. Default value is Canvas.CENTER
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public Label setValign(VerticalAlignment valign) {
        return (Label)setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of label text. See VerticalAlignment type for details.
     *
     * @return Current valign value. Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    /**
     * Size for this component's horizontal dimension.  See {@link com.smartgwt.client.widgets.Canvas#getWidth Canvas.width}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set, this property will be ignored so that the widget is always sized just large enough to accommodate the title.
     *
     * @param width New width value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.StatefulCanvas#setAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Label setWidth(Integer width) {
        return (Label)setAttribute("width", width, true);
    }

    /**
     * Size for this component's horizontal dimension.  See {@link com.smartgwt.client.widgets.Canvas#getWidth Canvas.width}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set, this property will be ignored so that the widget is always sized just large enough to accommodate the title.
     *
     * @return Current width value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#getAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
     * Size for this component's horizontal dimension.  See {@link com.smartgwt.client.widgets.Canvas#getWidth Canvas.width}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set, this property will be ignored so that the widget is always sized just large enough to accommodate the title.
     *
     * @param width New width value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#setAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setWidth(String width) {
        setAttribute("width", width, true);
    }

    /**
     * Size for this component's horizontal dimension.  See {@link com.smartgwt.client.widgets.Canvas#getWidth Canvas.width}
     * for more details. <P> Note that if {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit}
     * is set, this property will be ignored so that the widget is always sized just large enough to accommodate the title.
     *
     * @return Current width value. Default value is null
     * @see com.smartgwt.client.widgets.StatefulCanvas#getAutoFit
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public String getWidthAsString()  {
        return getAttributeAsString("width");
    }
    

    /**
     * If false, the label text will not be wrapped to the next line.
     *
     * @param wrap New wrap value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Label Label} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Label setWrap(Boolean wrap) {
        return (Label)setAttribute("wrap", wrap, true);
    }

    /**
     * If false, the label text will not be wrapped to the next line.
     *
     * @return Current wrap value. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getWrap()  {
        Boolean result = getAttributeAsBoolean("wrap");
        return result == null ? true : result;
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
     * @param labelProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Label labelProperties) /*-{
        if (labelProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Label.@java.lang.Object::getClass()(), "setDefaultProperties", labelProperties.@java.lang.Object::getClass()());
        }
        labelProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = labelProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Label.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(LabelLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.align:" + t.getMessage() + "\n";
        }
        try {
            s.autoFit = getAttributeAsString("autoFit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.autoFit:" + t.getMessage() + "\n";
        }
        try {
            s.contents = getAttributeAsString("contents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.contents:" + t.getMessage() + "\n";
        }
        try {
            s.dynamicContents = getAttributeAsString("dynamicContents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.dynamicContents:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.heightAsString = getAttributeAsString("height");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.heightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconAlign = getAttributeAsString("iconAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconAlign:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.iconSpacing = getAttributeAsString("iconSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabledIcon = getAttributeAsString("showDisabledIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.showDisabledIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showDownIcon = getAttributeAsString("showDownIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.showDownIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedIcon = getAttributeAsString("showFocusedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.showFocusedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverIcon = getAttributeAsString("showRollOverIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.showRollOverIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedIcon = getAttributeAsString("showSelectedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.showSelectedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.valign:" + t.getMessage() + "\n";
        }
        try {
            s.widthAsString = getAttributeAsString("width");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.widthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.wrap = getAttributeAsString("wrap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Label.wrap:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        LabelLogicalStructure s = new LabelLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
