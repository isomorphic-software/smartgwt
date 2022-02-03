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
 
package com.smartgwt.client.widgets.layout;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * Section descriptor used by a SectionStack to describe a section of items which are shown or hidden together along with
 * their associated header.  <P> A <code>SectionStackSection</code> can't be modified once it's been added to a {@link
 * com.smartgwt.client.widgets.layout.SectionStack}, which creates its section header (by default a {@link
 * com.smartgwt.client.widgets.layout.SectionHeader}, but see {@link
 * com.smartgwt.client.widgets.layout.SectionStack#getSectionHeaderClass SectionStack.sectionHeaderClass}).  After that,
 * you must call the appropriate <code>SectionStack</code> method to modify a section property, or the section header
 * getter method to get the updated property value.  As a convenience, we route several <code>SectionStackSection</code>
 * setter methods to the {@link com.smartgwt.client.widgets.layout.SectionStack} for you after the
 * <code>SectionStackSection</code> has been added to it, but with the exception of {@link
 * com.smartgwt.client.widgets.layout.SectionStackSection#getItems items}, you'll always get the original property values
 * when calling a getter directly on a <code>SectionStackSection</code>. <P> Additional SectionHeader properties set on the
 * SectionStackSection not explicitly documented, such as "iconAlign" or "prompt", are supported - use
 * <code>setAttribute()</code>.
 */
@BeanFactory.FrameworkClass
public class SectionStackSection extends RefDataClass {

    public static SectionStackSection getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof SectionStackSection) {
            existingObj.setJsObj(jsObj);
            return (SectionStackSection)existingObj;
        } else

        {
            return new SectionStackSection(jsObj);
        }
    }
        


    public SectionStackSection(){
        final String className = SC.getAUTOIDClass(getClass().getName());
                        setAttribute("AUTOIDClass", className);
                        internalSetID(SC.generateID(className), true, stack != null ? stack.getUseGlobalSectionIDs() : false);
                
    }

    public SectionStackSection(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public SectionStackSection(String title) {
        setTitle(title);
                final String className = SC.getAUTOIDClass(getClass().getName());
                        setAttribute("AUTOIDClass", className);
                        internalSetID(SC.generateID(className), true, stack != null ? stack.getUseGlobalSectionIDs() : false);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Is this section closeable? <P> Closeable sections show a {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton SectionStack.closeSectionButton} which will invoke
     * {@link com.smartgwt.client.widgets.layout.SectionStack#closeSection SectionStack.closeSection()} when clicked. <P> This
     * property overrides the default {@link com.smartgwt.client.widgets.layout.SectionStack#getCanCloseSections
     * SectionStack.canCloseSections} setting.
     *
     * @param canClose New canClose value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setCanClose(Boolean canClose) {
        return (SectionStackSection)setAttribute("canClose", canClose);
    }

    /**
     * Is this section closeable? <P> Closeable sections show a {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton SectionStack.closeSectionButton} which will invoke
     * {@link com.smartgwt.client.widgets.layout.SectionStack#closeSection SectionStack.closeSection()} when clicked. <P> This
     * property overrides the default {@link com.smartgwt.client.widgets.layout.SectionStack#getCanCloseSections
     * SectionStack.canCloseSections} setting.
     *
     * @return Current canClose value. Default value is null
     */
    public Boolean getCanClose()  {
        return getAttributeAsBoolean("canClose", true);
    }
    

    /**
     * This attribute controls whether or not the expand/collapse UI control is shown on the header of this section.  Any
     * section can still be expanded/collapsed programmatically, regardless of this setting.
     *
     * @param canCollapse New canCollapse value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_expand_collapse" target="examples">Expand / Collapse Example</a>
     */
    public SectionStackSection setCanCollapse(Boolean canCollapse) {
        return (SectionStackSection)setAttribute("canCollapse", canCollapse);
    }
    

    /**
     * When explicitly set to false, disallows drop before this member in the Layout.
     *
     * @param canDropBefore New canDropBefore value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.Layout
     * @see com.smartgwt.client.docs.LayoutMember LayoutMember overview and related methods
     */
    public SectionStackSection setCanDropBefore(Boolean canDropBefore) {
        return (SectionStackSection)setAttribute("canDropBefore", canDropBefore);
    }
    

    /**
     * If set to false, then this sectionHeader will not be able to be dragged to perform a drag reorder, if {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCanReorderSections SectionStack.canReorderSections} is true. You can
     * also disable dropping other sections before this one by setting  {@link
     * com.smartgwt.client.widgets.Canvas#getCanDropBefore canDropBefore} to false.
     *
     * @param canReorder New canReorder value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setCanReorder(Boolean canReorder) {
        return (SectionStackSection)setAttribute("canReorder", canReorder);
    }
    

    /**
     * If true, the header for this Section will be included in the page's tab order for accessibility. May also be set at the
     * {@link com.smartgwt.client.widgets.layout.SectionStack} level via  {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCanTabToHeaders SectionStack.canTabToHeaders}. <P> See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @param canTabToHeader New canTabToHeader value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setCanTabToHeader(Boolean canTabToHeader) {
        return (SectionStackSection)setAttribute("canTabToHeader", canTabToHeader);
    }

    /**
     * If true, the header for this Section will be included in the page's tab order for accessibility. May also be set at the
     * {@link com.smartgwt.client.widgets.layout.SectionStack} level via  {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCanTabToHeaders SectionStack.canTabToHeaders}. <P> See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @return Current canTabToHeader value. Default value is null
     */
    public Boolean getCanTabToHeader()  {
        return getAttributeAsBoolean("canTabToHeader", true);
    }
    

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @param clipTitle New clipTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setClipTitle(Boolean clipTitle) {
        return (SectionStackSection)setAttribute("clipTitle", clipTitle);
    }

    /**
     * If the title for this section header is too large for the available space, should the title be clipped? <p> This feature
     * is supported only in browsers that support the CSS UI text-overflow property (IE6+, Firefox 7+, Safari, Chrome, Opera
     * 9+).
     *
     * @return Current clipTitle value. Default value is true
     */
    public Boolean getClipTitle()  {
        Boolean result = getAttributeAsBoolean("clipTitle", true);
        return result == null ? true : result;
    }
    

    /**
     * Icon src for the {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton close button} if  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanClose canClose} is true. <P> If specified this takes
     * precedence over {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionIcon
     * SectionStack.closeSectionIcon}.
     *
     * @param closeIcon New closeIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public SectionStackSection setCloseIcon(String closeIcon) {
        return (SectionStackSection)setAttribute("closeIcon", closeIcon);
    }

    /**
     * Icon src for the {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton close button} if  {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanClose canClose} is true. <P> If specified this takes
     * precedence over {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionIcon
     * SectionStack.closeSectionIcon}.
     *
     * @return Current closeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getCloseIcon()  {
        return getAttributeAsString("closeIcon");
    }
    

    /**
     * Pixel width/height for this sections {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCloseIcon
     * closeIcon}.<br> If unset {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionIconSize
     * SectionStack.closeSectionIconSize} will be used.
     *
     * @param closeIconSize New closeIconSize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setCloseIconSize(Integer closeIconSize) {
        return (SectionStackSection)setAttribute("closeIconSize", closeIconSize);
    }

    /**
     * Pixel width/height for this sections {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCloseIcon
     * closeIcon}.<br> If unset {@link com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionIconSize
     * SectionStack.closeSectionIconSize} will be used.
     *
     * @return Current closeIconSize value. Default value is null
     */
    public Integer getCloseIconSize()  {
        return getAttributeAsInt("closeIconSize");
    }
    

    /**
     * Custom controls to be shown on top of this section header. <P> These controls are shown in the {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getControlsLayout SectionHeader.controlsLayout}. <P> Note that this is
     * an init-time property. If you need to dynamically change what  controls are displayed to the user, we would recommend
     * embedding the controls in a Layout or similar container.  This will allow you to show/hide or add/remove members at
     * runtime by manipulating the existing control(s) set up at init time. <P> For {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanClose canClose:true} sections, a {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton close icon} will be added to the section controls
     * automatically.
     *
     * @param controls New controls value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_custom_controls" target="examples">Custom Controls Example</a>
     */
    public SectionStackSection setControls(Canvas... controls) {
        return (SectionStackSection)setAttribute("controls", controls);
    }

    /**
     * Custom controls to be shown on top of this section header. <P> These controls are shown in the {@link
     * com.smartgwt.client.widgets.layout.SectionHeader#getControlsLayout SectionHeader.controlsLayout}. <P> Note that this is
     * an init-time property. If you need to dynamically change what  controls are displayed to the user, we would recommend
     * embedding the controls in a Layout or similar container.  This will allow you to show/hide or add/remove members at
     * runtime by manipulating the existing control(s) set up at init time. <P> For {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getCanClose canClose:true} sections, a {@link
     * com.smartgwt.client.widgets.layout.SectionStack#getCloseSectionButton close icon} will be added to the section controls
     * automatically.
     *
     * @return Current controls value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_custom_controls" target="examples">Custom Controls Example</a>
     */
    public Canvas[] getControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("controls"));
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.SectionStackSection#getItems items} be {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroyed} if this section is {@link
     * com.smartgwt.client.widgets.layout.SectionStack#removeSection removed}?  The section header itself and any controls will
     * always be destroyed.
     *
     * @param destroyOnRemove New destroyOnRemove value. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setDestroyOnRemove(Boolean destroyOnRemove) {
        return (SectionStackSection)setAttribute("destroyOnRemove", destroyOnRemove);
    }
    
    

    /**
     * Allows properties for the header (a {@link com.smartgwt.client.widgets.layout.SectionHeader} or {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} subclass) to be set on the section before it's added to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack}.
     *
     * @param headerProperties New headerProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.SectionStack#setSectionHeaderClass
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public SectionStackSection setHeaderProperties(SectionHeader headerProperties) {
        if (headerProperties != null) {
            if (headerProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(SectionStackSection.class, "setHeaderProperties", "SectionHeader");
            }                                                                       
            headerProperties.setConfigOnly(true);
        }
        JavaScriptObject config = headerProperties == null ? null : headerProperties.getConfig();
        return (SectionStackSection)setAttribute("headerProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Allows properties for the header (a {@link com.smartgwt.client.widgets.layout.SectionHeader} or {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} subclass) to be set on the section before it's added to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack}.
     *
     * @return Current headerProperties value. Default value is null
     * @see com.smartgwt.client.widgets.layout.SectionStack#getSectionHeaderClass
     */
    public SectionHeader getHeaderProperties()  {
        SectionHeader properties = new SectionHeader();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("headerProperties"));
        return properties;
    }

    /**
     * Allows properties for the header (a {@link com.smartgwt.client.widgets.layout.SectionHeader} or {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} subclass) to be set on the section before it's added to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack}.
     *
     * @param headerProperties New headerProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.SectionStack#setSectionHeaderClass
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public SectionStackSection setHeaderProperties(ImgSectionHeader headerProperties) {
        if (headerProperties != null) {
            if (headerProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(SectionStackSection.class, "setHeaderProperties", "ImgSectionHeader");
            }                                                                       
            headerProperties.setConfigOnly(true);
        }
        JavaScriptObject config = headerProperties == null ? null : headerProperties.getConfig();
        return (SectionStackSection)setAttribute("headerProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Allows properties for the header (a {@link com.smartgwt.client.widgets.layout.SectionHeader} or {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader} subclass) to be set on the section before it's added to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack}.
     *
     * @return Current headerProperties value. Default value is null
     * @see com.smartgwt.client.widgets.layout.SectionStack#getSectionHeaderClass
     */
    public ImgSectionHeader getHeaderPropertiesAsImgSectionHeader()  {
        ImgSectionHeader properties = new ImgSectionHeader();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("headerProperties"));
        return properties;
    }
    
    

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     *
     * @param icon New icon value. Default value is "[SKIN]SectionHeader/opener.gif"
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public SectionStackSection setIcon(String icon) {
        return (SectionStackSection)setAttribute("icon", icon);
    }

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     *
     * @return Current icon value. Default value is "[SKIN]SectionHeader/opener.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    
    
    

    /**
     * Identifier for the section.  This can be used later in calls to {@link com.smartgwt.client.widgets.layout.SectionStack}
     * APIs such as {@link com.smartgwt.client.widgets.layout.SectionStack#expandSection SectionStack.expandSection()} and
     * {@link com.smartgwt.client.widgets.layout.SectionStack#collapseSection SectionStack.collapseSection()}. Note that if no
     * name is specified for the section, one will be auto-generated when the section is created. This property should be a
     * string which may be used as a valid JavaScript identifier (should start with a letter and not contain space or special
     * characters such as "*").
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setName(String name) {
        return (SectionStackSection)setAttribute("name", name);
    }

    /**
     * Identifier for the section.  This can be used later in calls to {@link com.smartgwt.client.widgets.layout.SectionStack}
     * APIs such as {@link com.smartgwt.client.widgets.layout.SectionStack#expandSection SectionStack.expandSection()} and
     * {@link com.smartgwt.client.widgets.layout.SectionStack#collapseSection SectionStack.collapseSection()}. Note that if no
     * name is specified for the section, one will be auto-generated when the section is created. This property should be a
     * string which may be used as a valid JavaScript identifier (should start with a letter and not contain space or special
     * characters such as "*").
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * If set to false, then the items in this section will not be resized by sectionHeader repositioning.  You may also set
     * this flag directly on any of the items in any section to cause that item to not be resizeable.
     *
     * @param resizeable New resizeable value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_sections_resize" target="examples">Resize Sections Example</a>
     */
    public SectionStackSection setResizeable(Boolean resizeable) {
        return (SectionStackSection)setAttribute("resizeable", resizeable);
    }
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @param showClippedTitleOnHover New showClippedTitleOnHover value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setShowClippedTitleOnHover(Boolean showClippedTitleOnHover) {
        return (SectionStackSection)setAttribute("showClippedTitleOnHover", showClippedTitleOnHover);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this section header is enabled.
     *
     * @return Current showClippedTitleOnHover value. Default value is true
     */
    public Boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover", true);
        return result == null ? true : result;
    }
    

    /**
     * If true, a header will be shown for this section.  If false, no header will be shown.
     *
     * @param showHeader New showHeader value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.SectionStackSection SectionStackSection} instance, for chaining setter calls
     */
    public SectionStackSection setShowHeader(Boolean showHeader) {
        return (SectionStackSection)setAttribute("showHeader", showHeader);
    }
    
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Title to show for the section
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        if(stack == null || !stack.isCreated()) {
            setAttribute("title", title);
        } else {
            stack.setSectionTitle(getName(), title);
        }
    }

    /**
     * Title to show for the section
     *
     * @return String
     */
    public String getTitle()  {
        if(stack == null || !stack.isCreated()) {
            return getAttributeAsString("title");
        } else {
            return stack.getSection(getName()).getAttribute("title");
        }
    }

    /**
     * Sections default to the collapsed state unless {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getShowHeader showHeader} is set to <code>false</code> in which
     * case they default to the expanded state.  This attribute allows you to explicitly control the expand/collapse state of
     * the section by overriding the above default behavior.
     *
     * @param expanded expanded Default value is false
     */
    public void setExpanded(Boolean expanded) {
        if(stack == null || !stack.isCreated()) {
            setAttribute("expanded", expanded);
        } else {
            if(expanded) {
                stack.expandSection(getName());
            } else {
                stack.collapseSection(getName());
            }
        }
    }

    /**
     * Sections default to the visible state.  This attribute allows you to explicitly control the visible/hidden state of the
     * section by overriding the above default behavior.
     *
     * @param hidden hidden Default value is false
     */
    public void setHidden(Boolean hidden) {
        if(stack == null || !stack.isCreated()) {
            setAttribute("hidden", hidden);
        } else {
            if(hidden) {
                stack.hideSection(getName());
            } else {
                stack.showSection(getName());
            }
        }
    }

    /**
     * Assign a new set of Canvases to this section.  These Canvases will be shown and hidden
     * together.
     * @param items list of Canvases that constitute the section
     */
    public void setItems(Canvas... items) {
        if (stack == null || !stack.isCreated()) {
            for (Canvas item : items) {
                addItem(item);
            }
        } else {
            stack.setItems(getName(), items);
        }
    }

    /**
     * Return the items in this SectionStackSection
     *
     * @return the items in this SectionStackSection
     */
    public native Canvas[] getItems() /*-{
		var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if(!jsObj.items) {
            jsObj.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        return @com.smartgwt.client.util.ConvertTo::arrayOfCanvas(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.items);
    }-*/;

    /**
     * Adds a new Canvas to this section, at the end.
     * @param new Canvas to add as item
     */
    public void addItem(Canvas item) {
        if (stack == null || !stack.isCreated()) {
            addItemJS(item.getOrCreateJsObj());
        } else {
            stack.addItem(getName(), item, getItems().length);
        }
    }

    private native void addItemJS(JavaScriptObject componentJS) /*-{
		var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();

        if(!jsObj.items) {
            jsObj.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        jsObj.items.push(componentJS);
    }-*/;

    /**
     * Once a SectionStackSection has been applied to a SectionStack, this method may be used to return  a pointer to the
     * SectionStack in which this section header is embedded.
     *
     * @return the SectionStack in which this section is embedded
     */
    protected SectionStack stack;
    public SectionStack getSectionStack() {
    	return stack;
    }

    /**
     * Once a SectionStackSection has been applied to a SectionStack, this method may be used to return  a pointer to the
     * SectionHeader for this section
     * @return the SectionHeader for the section
     */
    public native SectionHeader getSectionHeader () /*-{
    	var jsObj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
    	if (jsObj == null) return null;

    	var sectionHeader = jsObj.getSectionHeader != null ? jsObj.getSectionHeader() : null;
	    if (sectionHeader == null) return null;

	    return @com.smartgwt.client.widgets.layout.SectionHeader::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(sectionHeader);
    }-*/;

    /**
     * Optional ID for the section. If {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} is true, this property will be applied to the generated
     * SectionStackHeader widget as a standard widget ID, meaning it should be unique within a
     * page. <P> <b>Backcompat Note</b>: Section stack sections may be uniquely identified
     * within a stack via the {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getName name} attribute
     * (introduced in Jan 2010). Prior to this, the section ID attribute was used in this way
     * (and would not be applied to the section header as a widget ID). For backwards
     * compatibility this is still supported: If <code>section.name</code> is unspecified for a
     * section but <code>section.ID</code> is set, the ID will be used as a default name
     * attribute for the section. For backwards compatibility we also disable the standard
     * behavior of having the <code>section.ID</code> being applied to the generated section
     * header (thereby avoiding the page-level uniqueness requirement) by defaulting {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} to false.
     *
     *
     * @return String
     */
    public String getID()  {
        return this.id;
    }

    /**
     * Optional ID for the section. If {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} is true, this property will be applied to the generated
     * SectionStackHeader widget as a standard widget ID, meaning it should be unique within a
     * page. <P> <b>Backcompat Note</b>: Section stack sections may be uniquely identified
     * within a stack via the {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getName name} attribute
     * (introduced in Jan 2010). Prior to this, the section ID attribute was used in this way
     * (and would not be applied to the section header as a widget ID). For backwards
     * compatibility this is still supported: If <code>section.name</code> is unspecified for a
     * section but <code>section.ID</code> is set, the ID will be used as a default name
     * attribute for the section. For backwards compatibility we also disable the standard
     * behavior of having the <code>section.ID</code> being applied to the generated section
     * header (thereby avoiding the page-level uniqueness requirement) by defaulting {@link
     * com.smartgwt.client.widgets.layout.SectionStackSection#getUseGlobalSectionIDs
     * useGlobalSectionIDs} to false.
     *
     * @param ID ID Default value is null
     */
    public void setID(String ID) {
        internalSetID(ID, false, stack != null ? stack.getUseGlobalSectionIDs(): false);
    }
    
    /**
     * Specify the ariaRole for this SectionStackSection. This role will be applied to the 
     * SectionHeader for the section.
     * See {@link com.smartgwt.client.docs.Accessibility}
     * @param ariaRole
     */
    public void setAriaRole(String ariaRole) {
    	setAttribute("ariaRole", ariaRole);
    }
    
    /**
     * Specify an ariaState for this SectionStackSection. This state will be applied to the 
     * SectionHeader for the section.
     * See {@link com.smartgwt.client.docs.Accessibility}
     * @param stateName
     * @param stateValue
     */
    public void setAriaState(String stateName, Object stateValue) {
    	JavaScriptObject ariaState = this.getAttributeAsJavaScriptObject("ariaState");
    	if (ariaState == null) ariaState = JSOHelper.createObject();
    	JSOHelper.setAttribute(ariaState,  stateName,  stateValue);
    	this.setAttribute("ariaState",  ariaState);
    }

    /**
     * Provide a custom implementation of {@link com.smartgwt.client.widgets.layout.SectionHeader#titleHoverHTML(java.lang.String)}.
     */
    public native void setTitleHoverFormatter(TitleHoverFormatter formatter) /*-{
        // If `formatter' is null, we would normally get the "titleHoverHTML" instance property
        // (for the default titleHoverHTML() implementation), but here we do not know whether
        // the section header class is/will be SectionHeader, ImgSectionHeader, or possibly something
        // else. So, set `self.titleHoverHTML' if `formatter' is not null; otherwise, delete whatever's
        // there.
        var self = this.@com.smartgwt.client.widgets.layout.SectionStackSection::getJsObj()();
        if (formatter == null) delete self.titleHoverHTML;
        else {
            self.titleHoverHTML = $entry(function (defaultHTML) {
                return formatter.@com.smartgwt.client.widgets.TitleHoverFormatter::getHoverHTML(Ljava/lang/String;)(defaultHTML);
            });
        }
    }-*/;

}
