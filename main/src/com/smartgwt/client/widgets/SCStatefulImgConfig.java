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
 * A configuration object containing image URLs for a set of possible
 *  images to display based on the {@link com.smartgwt.client.widgets.StatefulCanvas#getState state} of some components.
 *  See the {@link com.smartgwt.client.docs.StatefulImages stateful images overview} for more information.
 *  <P>
 *  Each attribute in this configuration object maps a state to a target URL.<br>
 *  Each URL may be specified in one of three ways
 *  <ul><li>a standard {@link com.smartgwt.client.docs.SCImgURL} may be used to refer directly to an image file.</li>
 *      <li>the <code>"#state:"</code> prefix may be used to display media from another
 *          specified state.</li>
 *      <li>the <code>"#modifier:"</code> prefix may be used to specify a modifier 
 *          string to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base base image}.<br>
 *          The modifier will be applied to the base file name before the file type suffix.</li>
 *  </ul>
 *  For example, consider a stateful image config with the following properties:
 *  <pre>
 *  {    _base:"button.png",
 *       Over:"bright_button.png",
 *       Focused:"#state:Over",
 *       Selected:"#state:Over",
 *       Disabled:"#modifier:_Disabled",
 *       SelectedDisabled:"#state:Selected"
 *  }
 *  </pre>
 *  In this case
 *  <ul>
 *  <li>the base image URL and the the "Over" state image URL would be determined using
 *      the standard {@link com.smartgwt.client.docs.SCImgURL} rules</li>
 *  <li>the "Focused" and "Selected" state images would re-use the "Over" state image
 *      (<code>"bright_button.png"</code>)</li>
 *  <li>the "Disabled" state image would be the base state image with a
 *       <code>"_Disabled"</code> suffix applied to the file name
 *       (<code>"button_Disabled.png"</code>)</li>
 *  <li>the <code>"SelectedDisabled"</code> entry would be used for the combined 
 *      <code>"Selected"</code> and <code>"Disabled"</code> states, and would
 *      re-use the "Selected" state image (which in turn maps back to
 *      the "Over" state, resolving to <code>"bright_button.png"</code>)</li>
 *  </ul>
 *  <P>
 *  The default set of standard states are explicitly documented, but this object format
 *  is extensible.
 *  A developer may specify additional attributes on a SCStatefulImgConfig beyond the
 *  standard documented states and they may be picked up if a custom state is applied to 
 * a component (via a call to {@link com.smartgwt.client.widgets.StatefulCanvas#setState StatefulCanvas.setState()}, for
 * example).
 *  <P>
 *  <h3>Combined states and missing entries:</h3>
 * The {@link com.smartgwt.client.widgets.Canvas#isFocused focused} and {@link
 * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} 
 * states may be applied to a component in combination with other states. For example an {@link
 * com.smartgwt.client.widgets.ImgButton}
 *  marked both <i>Selected</i> and <i>Disabled</i> will look for media to
 *  represent this combined state. To provide such media in a SCStatefulImgConfig, 
 *  use the combined state names (in this case <code>SelectedDisabled</code>).<br>
 *  If a component is both <i>Selected</i> and <i>Focused</i>,
 *  three-part combined states are also possible (Selected + Focused + Over gives
 *  <code>SelectedFocusedOver</code> for example).
 *  <P>
 *  The SCStatefulImgConfig format may be sparse - developers may skip providing values for
 *  certain states (or combined states) in the SCStatefulImgConfig object. 
 *  In this case the system will back off to using one of the state image entries
 *  that has been explicitly provided, according to the following rules:
 *  <table border=1>
 *  <tr> <td><b>State(s)</b></td>
 *       <td><b>Stateful image attributes to consider (in order of preference)</b></td>
 *  </tr>
 *  <tr><td><code>Focused</code> and <code>Selected</code></td>
 *      <td>If both focused and selected states are applied, the system will use the first
 *          (populated) value from the following attribute list:
 *          <ul><li>"FocusedSelected"</li>
 *              <li>"Focused"</li>
 *              <li>"Selected"</li>
 *       </ul></td>
 *  </tr>
 *  <tr><td><code>Over</code> or <code>Down</code> in combination with <code>Focused</code> 
 *          / <code>Selected</code> </td>
 *      <td>System will check for a combined state attribute with the Focused / Selected state first.<br>
 *           For example for Focused + Selected + Over, consider the following attributes:
 *           <ul><li>"FocusedSelectedOver"</li>
 *               <li>"FocusedOver"</li>
 *               <li>"SelectedOver"</li></ul>
 *           If no combined state entry is specified, back off to considering just the
 *           Focused / Selected state:
 *           <ul><li>"FocusedSelected"</li>
 *               <li>"Focused"</li>
 *               <li>"Selected"</li>
 *           </ul>
 *           If no focused / selected state entry is present in the config object, 
 *           look for an entry for the unmodified state name
 *           <ul><li>"Over"</li></ul>
 *       </td>
 *  </tr>
 *  <tr><td>All other states, including <code>Disabled</code> (in combination with 
 *           <code>Focused</code> / <code>Selected</code>) </td>
 *      <td>Check for a combined state attribute with the Focused / Selected state first.<br>
 *           For example for Focused + Selected + "CustomState", consider the following attributes:
 *           <ul><li>"FocusedSelectedCustomState"</li>
 *               <li>"FocusedCustomState"</li>
 *               <li>"SelectedCustomState"</li></ul>
 *           If no combined state entry is specified, back off to considering just the
 *           unmodified state name
 *           <ul><li>"CustomState"</li></ul>    
 *           If there is no explicit entry for the state name, use the Focused / Selected
 *           state without a state name:
 *           <ul><li>"FocusedSelected"</li>
 *               <li>"Focused"</li>
 *               <li>"Selected"</li>
 *           </ul>
 *       </td>
 *  </tr></table>
 *  <br>
 *  If no entry can be found for the specified state / combined states using the above 
 *  approach, the  <code>"_base"</code> attribute will be used.
 */
@BeanFactory.FrameworkClass
public class SCStatefulImgConfig extends DataClass {

    public static SCStatefulImgConfig getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new SCStatefulImgConfig(jsObj);
    }
        


    public SCStatefulImgConfig(){
        
    }

    public SCStatefulImgConfig(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The base filename for the image. This will be used if no state is applied to the stateful component displaying this
     * image, or if no explicit entry exists for a state that is applied.<br> It will also be used as a base file name for
     * entries specified using the <code>"#modifier:<i>some_value</i>"</code> format. <P> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @param _base New _base value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public SCStatefulImgConfig set_base(String _base) {
        return (SCStatefulImgConfig)setAttribute("_base", _base);
    }

    /**
     * The base filename for the image. This will be used if no state is applied to the stateful component displaying this
     * image, or if no explicit entry exists for a state that is applied.<br> It will also be used as a base file name for
     * entries specified using the <code>"#modifier:<i>some_value</i>"</code> format. <P> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @return Current _base value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String get_base()  {
        return getAttributeAsString("_base");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled}. <P> May be
     * specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference
     * to another entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>   
     * <li>A modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the     
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @param Disabled New Disabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setDisabled(String Disabled) {
        return (SCStatefulImgConfig)setAttribute("Disabled", Disabled);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled}. <P> May be
     * specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference
     * to another entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>   
     * <li>A modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the     
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @return Current Disabled value. Default value is null
     */
    public String getDisabled()  {
        return getAttributeAsString("Disabled");
    }
    

    /**
     * Image to display on {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouseDown}. <P> May be specified as 
     * <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another
     * entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A
     * modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the        
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @param Down New Down value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setDown(String Down) {
        return (SCStatefulImgConfig)setAttribute("Down", Down);
    }

    /**
     * Image to display on {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouseDown}. <P> May be specified as 
     * <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another
     * entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A
     * modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the        
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @return Current Down value. Default value is null
     */
    public String getDown()  {
        return getAttributeAsString("Down");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused}. <P> May be
     * specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference
     * to another entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>   
     * <li>A modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the     
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @param Focused New Focused value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setFocused(String Focused) {
        return (SCStatefulImgConfig)setAttribute("Focused", Focused);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused}. <P> May be
     * specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference
     * to another entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>   
     * <li>A modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the     
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @return Current Focused value. Default value is null
     */
    public String getFocused()  {
        return getAttributeAsString("Focused");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param FocusedDown New FocusedDown value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setFocusedDown(String FocusedDown) {
        return (SCStatefulImgConfig)setAttribute("FocusedDown", FocusedDown);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current FocusedDown value. Default value is null
     */
    public String getFocusedDown()  {
        return getAttributeAsString("FocusedDown");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param FocusedOver New FocusedOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setFocusedOver(String FocusedOver) {
        return (SCStatefulImgConfig)setAttribute("FocusedOver", FocusedOver);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current FocusedOver value. Default value is null
     */
    public String getFocusedOver()  {
        return getAttributeAsString("FocusedOver");
    }
    

    /**
     * Image to display on {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified
     * as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another
     * entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A
     * modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the        
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @param Over New Over value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setOver(String Over) {
        return (SCStatefulImgConfig)setAttribute("Over", Over);
    }

    /**
     * Image to display on {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified
     * as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another
     * entry in this SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A
     * modifier to apply to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the        
     * format <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig overview} for further information.
     *
     * @return Current Over value. Default value is null
     */
    public String getOver()  {
        return getAttributeAsString("Over");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected}. <P> May
     * be specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A
     * reference to another entry in this SCStatefulImgConfig via the format         
     * <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply to the {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param Selected New Selected value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelected(String Selected) {
        return (SCStatefulImgConfig)setAttribute("Selected", Selected);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected}. <P> May
     * be specified as  <ul><li>A {@link com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A
     * reference to another entry in this SCStatefulImgConfig via the format         
     * <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply to the {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current Selected value. Default value is null
     */
    public String getSelected()  {
        return getAttributeAsString("Selected");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedDisabled New SelectedDisabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedDisabled(String SelectedDisabled) {
        return (SCStatefulImgConfig)setAttribute("SelectedDisabled", SelectedDisabled);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#getDisabled disabled}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedDisabled value. Default value is null
     */
    public String getSelectedDisabled()  {
        return getAttributeAsString("SelectedDisabled");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedDown New SelectedDown value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedDown(String SelectedDown) {
        return (SCStatefulImgConfig)setAttribute("SelectedDown", SelectedDown);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedDown value. Default value is null
     */
    public String getSelectedDown()  {
        return getAttributeAsString("SelectedDown");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedFocused New SelectedFocused value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedFocused(String SelectedFocused) {
        return (SCStatefulImgConfig)setAttribute("SelectedFocused", SelectedFocused);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedFocused value. Default value is null
     */
    public String getSelectedFocused()  {
        return getAttributeAsString("SelectedFocused");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedFocusedDown New SelectedFocusedDown value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedFocusedDown(String SelectedFocusedDown) {
        return (SCStatefulImgConfig)setAttribute("SelectedFocusedDown", SelectedFocusedDown);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown mouse down}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedFocusedDown value. Default value is null
     */
    public String getSelectedFocusedDown()  {
        return getAttributeAsString("SelectedFocusedDown");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedFocusedOver New SelectedFocusedOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedFocusedOver(String SelectedFocusedOver) {
        return (SCStatefulImgConfig)setAttribute("SelectedFocusedOver", SelectedFocusedOver);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and
     * {@link com.smartgwt.client.widgets.Canvas#isFocused focused} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedFocusedOver value. Default value is null
     */
    public String getSelectedFocusedOver()  {
        return getAttributeAsString("SelectedFocusedOver");
    }
    

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @param SelectedOver New SelectedOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.SCStatefulImgConfig SCStatefulImgConfig} instance, for chaining setter calls
     */
    public SCStatefulImgConfig setSelectedOver(String SelectedOver) {
        return (SCStatefulImgConfig)setAttribute("SelectedOver", SelectedOver);
    }

    /**
     * Image to display when the component is {@link com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} on {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver roll over}. <P> May be specified as  <ul><li>A {@link
     * com.smartgwt.client.docs.SCImgURL} indicating the media to load</li>     <li>A reference to another entry in this
     * SCStatefulImgConfig via the format          <code>"#state:<i>otherStateName</i>"</code></li>     <li>A modifier to apply
     * to the {@link com.smartgwt.client.widgets.SCStatefulImgConfig#get_base _base} media via the         format
     * <code>"#modifier:<i>modifierString</i>"</code></li> </ul> See {@link com.smartgwt.client.widgets.SCStatefulImgConfig
     * SCStatefulImgConfig overview} for further information.
     *
     * @return Current SelectedOver value. Default value is null
     */
    public String getSelectedOver()  {
        return getAttributeAsString("SelectedOver");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
