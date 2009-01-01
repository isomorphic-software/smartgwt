/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 



//>	@class	CheckboxItem
//
// Checkbox form item, implemented with customizeable checkbox images
// @visibility external
// @example checkboxItem
//<
isc.defineClass("CheckboxItem", "CycleItem");

isc.CheckboxItem.addClassProperties({
    // Checkboxes require a 2 option valueMap - containing a true and false value.
    // This array is applied to checkboxItems as a defaultValueMap.
    // See comments in getValueMap() for how we deal with other specified valueMaps
    valueMap:[true,false]

});

isc.CheckboxItem.addProperties({
    //>	@attr	CheckboxItem.titleStyle    (FormItemBaseStyle : null : IRW)
	//  Base CSS class for this item's title text
    // @deprecated As of Isomorphic SmartClient build 5.5, use textBoxStyle instead
	// @group   appearance
    // @visibility external
	//<

    //>	@attr	CheckboxItem.textBoxStyle    (FormItemBaseStyle : "labelAnchor" : IRW)
	//  Base CSS class for this item's title text
	// @group   appearance
    // @visibility external
	//<
	textBoxStyle:"labelAnchor",
    
    //> @attr   checkboxItem.showLabel    (boolean : true : IRW)
    //  Should we should the label text next to the checkbox item.
    // @visibility external
    //<
    showLabel:true,
    
    // Default the height to 20px so it aligns with other form items on the same row
    height:20,
    
    // Required title:
    // We want to render required checkboxes with their titles in bold.
    // Normally this is done by the form, which writes out the item title, but since the title
    // is written directly into the element, we handle it in this caes.
    // Do this by applying "<b>" / "</b>" prefix and suffix to the title if we're required.
    // Note: we can't use the form requiredTitlePrefix and Suffix as these include a ":" 
    // character which we don't want to render out.
    
    requiredTitlePrefix:"<b>",
    requiredTitleSuffix:"</b>",
    
    
    valueIconLeftPadding:4,
    valueIconRightPadding:3,
    
    
    //> @attr   checkboxItem.labelAsTitle   (boolean : null : IRWA)
    // By default we show a checkbox item title label adjacent to the checkbox itself.
    // Setting this property to true will revert to the standard form item behavior of showing
    // the title in the separate title cell.
    //<
    
    //labelAsTitle:null,
    
       

    //>@attr    CheckboxItem.showValueIconOver (boolean : true : IRWA)
    // Should an "Over" state icon be shown when the user rolls over this checkbox
    // @group valueIcons
    // @visibility internal
    //<
    showValueIconOver:true,

    //>@attr    CheckboxItem.showValueIconFocused (boolean : true : IRWA)
    // Should the icon be modified to reflect 'focused' state.
    // We use the "Over" state image to indicate focus as well as rollOver.
    // @group valueIcons
    // @visibility internal
    //<
    
    showValueIconFocused:true,
    
    //>@attr    CheckboxItem.showValueIconDown (boolean : true : IRWA)
    // Should a "Down" state icon be shown when the mouse goes down over this checkbox
    // @group valueIcons
    // @visibility internal
    //<
    showValueIconDown:true,
    
    //>@attr    CheckboxItem.showValueIconDisabled (boolean : true : IRWA)
    // Should a "Disabled" state icon be shown when the item is disabled
    // @group valueIcons
    // @visibility internal
    //<    
    showValueIconDisabled:true,
    
    
    
    //> @attr   CheckboxItem.checkedImage   (SCImgURL : "[SKIN]/DynamicForm/checked.gif" : IRW)
    // URL for the image to display when this checkbox is selected, or checked.
    // This is the base image name - if <code>showValueIconOver</code> et al are set, the
    // state (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be
    // added to this name as the user intereacts with the checkbox, as well as the 
    // <code>".gif"</code> extension
    // @group appearance
    // @visibility external
    //<
    checkedImage:"[SKINIMG]/DynamicForm/checked.gif",
    
    //> @attr   CheckboxItem.uncheckedImage   (SCImgURL : "[SKIN]/DynamicForm/unchecked.gif" : IRW)
    // URL for the image to display when this checkbox is not selected, or unchecked
    // @group appearance
    // @visibility external
    //<
    uncheckedImage:"[SKINIMG]/DynamicForm/unchecked.gif",
    
    //> @attr   CheckboxItem.unsetImage   (SCImgURL : "[SKIN]/DynamicForm/unchecked.gif" : IRW)
    // URL for the image to display when this checkbox is unset.  Defaults to matching the
    // unchecked image.
    // @group appearance
    // @visibility external
    //<
    unsetImage:"[SKINIMG]/DynamicForm/unchecked.gif",
    
    //> @attr CheckboxItem.valueIconWidth (number : 13 : IRW)
    // Width of the checkbox image.
    // @group valueIcons
    // @visibility external
    //<
    valueIconWidth:13,

    //> @attr CheckboxItem.valueIconHeight (number : 13 : IRW)
    // Height of the checkbox image.
    // @group valueIcons
    // @visibility external
    //<
    valueIconHeight:13
    
    //> @attr CheckboxItem.valueMap (object | Array : null : IRW)
    // Object defining how the checkbox "checked" state will be mapped to the field value.<br>
    // Checkboxes only support 2 states. By default a checked checkbox will have
    // value <code>true</code>, and an unchecked one will have value <code>false</code>
    // (or <code>null</code> if there is no default value and the value has never been set).
    // <p>
    // A valueMap can modify this in 2 ways:<br>
    // - If the desired checked/unchecked values can be resolved to <code>true</code> 
    //   and <code>false</code> directly in JavaScript, the valueMap may be specified as
    //   a 2-element array containing these values. Examples of this woud include<br>
    //   <code>&nbsp;&nbsp;[0,1]</code>: 
    //   In this case an unchecked checkbox would have value <code>0</code> and a checked box
    //   would have value <code>1</code><br>
    //   <code>&nbsp;&nbsp;[null,"Some String"]</code>:
    //   In this case an unchecked checkbox would have value <code>null</code> and a checked 
    //    box would have value <code>"Some String"</code><br>
    // - More arbitrary data values can be resolved to checked / unchecked values via an
    //   object mapping the abitrary data values to display values of <code>true</code> and
    //   <code>false</code>. For example:<br>
    //   <code>&nbsp;&nbsp;{"A":false, "B":true}</code><br>
    //    In this case an unchecked checkbox would have value "A", and a checked box 
    //    would have value "B"
    // <p>
    // Note: ValueMaps in other formats will be ignored by the CheckboxItem class. To update
    // the valueMap at runtime, always use +link{CheckboxItem.setValueMap()}
    // @group valueMap
    // @visibility external
    //<
    
});

isc.CheckboxItem.addMethods({

    
    // checkboxes only support 2 states - true or false
    // We explicitly support 
    // - a 2 element array where one element evaluates to true and one doesn't - such as
    //   [true,false], [0,1], [null,"foo"], etc
    // - an object where the left hand value will be stored on the server (can be anything)
    //   and the right hand value is true or false (or evaluates to true/false) - for example
    //   {"accepted":true, "denied":false}
    // It is likely that we'll also see valueMaps on boolean fields of the form
    // {"true":"Accepted", "false":"Denied"}. In this case the developer is mapping the stored
    // boolean value to a string to display - useful for other form item types such as selects
    // but we will just ignore the display value for checkboxItems.
    // Any other value maps (EG a 3 element array), will be just ignored and we'll 
    // use [true,false]
    _$true:"true", _$false:"false",
    getValueMap : function () {
        // For efficiency cache the 'validated' valueMap - this is the valueMap converted to
        // a 2 element array that we treat as data values.
        if (this._validatedValueMap) return this._validatedValueMap;
        var valueMap = this.Super("getValueMap", arguments);
        if (valueMap != null) {
            var array = false,
                object = isc.isAn.Object(valueMap);
            if (isc.isAn.Array(valueMap)) {
                object = false;
                if (valueMap.length != 2) {                    
                    valueMap = null;
                } else {
                    // special case - remap "true" / "false" to boolean values
                    var falseStringIndex = valueMap.indexOf(this._$false);
                    if (falseStringIndex != -1) valueMap[falseStringIndex] = false;
                    var trueStringIndex = valueMap.indexOf(this._$true);
                    if (trueStringIndex != -1) valueMap[trueStringIndex] = true;
                    
                    // If we're given a 2 element array as a valueMap and it doesn't consist of
                    // a true and false value, map the first element to true and the second to false 
                    
                    if (!((valueMap[0] && !valueMap[1]) || (!valueMap[0] && valueMap[1])) ) {
                        this.logInfo("Checkbox item created with valueMap:"+ valueMap + 
                                        "which has no explicit true/false display values. Mapping the " + "first value to true and the second to false.");
    
                        
                        var mapObject = {};
                        mapObject[valueMap[0]] = true;
                        mapObject[valueMap[1]] = false;
                        this.valueMap = valueMap = mapObject;
                        object = true;
                    } else {
                        array = true;
                    }
                }
            }
            
            if (object) {
                var vals = [],
                    keys = [],
                    notValid;
                for (var key in valueMap) {
                    if (vals.length == 2) {
                        notValid = true;
                        break;
                    }
                    
                    var val = valueMap[key];
                    // Special case - "true" and "false" as a key or value should be treated as 
                    // a boolean
                    if (key == this._$false) key = false;
                    else if (key == this._$true) key = true;
                    if (val == this._$false) {
                        val = valueMap[key] = false;
                    } else if (val == this._$true) {
                        val = valueMap[key] = true;
                    }
                    
                    keys[keys.length] = key;
                    vals[vals.length] = val;
                }
                
                if (vals.length != 2) notValid = true;
                if (!notValid) {
                   
                    
                    // If the 'display' values are true / false, we can just use the valueMap
                    // as specified - we'll display the checkbox correctly and a call to set
                    // or getValue will return the non-boolean data value
                    if ((vals[0] && !vals[1]) || (!vals[0] && vals[1])) {
                        // We don't need to store out the valueMap in this case - it's already
                        // usable
                    } else if ((keys[0] && !keys[1]) || (!keys[0] && keys[1])) {                        
                        valueMap = keys;
                    } else notValid = true;
                }                
                if (notValid) valueMap = null;

            // getValueMap should always return an array or object 
            } else if (!array) {
                valueMap = null;
            }
        }        
        return (this._validatedValueMap = valueMap || isc.CheckboxItem.valueMap);
    },

    //> @method CheckboxItem.setValueMap 
    // Setter method to apply a valueMap to a checkbox item.<br>
    // Note that if this method is overridden, the override must call
    // <code>this.Super("setValueMap", arguments);</code> to maintain functionality in this
    // class.
    // @see CheckboxItem.valueMap
    // @group valueMap
    // @visibility external
    //<
    // Override setValueMap to clear the cached validated version of the valueMap passed in
    setValueMap : function () {
        this._validatedValueMap = null;
        return this.Super("setValueMap", arguments);
    },
    
    init : function (a,b,c,d) {
        // for backcompat, convert explicitly specified titleStyle to textBoxStyle
        
        if (this.titleStyle != null && !this.showTitle) this.textBoxStyle = this.titleStyle;
        
        this.invokeSuper(isc.CheckboxItem, "init", a,b,c,d);
        // for checkboxes we use 'showLabel' to determine whether we show text next to the
        // checkbox image. Implemented by converting to 'showValueIconOnly'.
        if (this.showValueIconOnly == null) this.showValueIconOnly = !this.showLabel;
    },
    
    // We need a setter for showLabel as we basically translate this into the showValueIconOnly
    // property.
    //> @method setShowLabel()
    // Sets +link{checkboxItem.showLabel}
    //<
    setShowLabel : function (showLabel) {
        this.showLabel = showLabel;
        this.showValueIconOnly = !showLabel;
        if (this.isDrawn()) this.redraw();
    },

    // Checkboxes display the title next to the checkbox rather than the value of the
    // item
    mapValueToDisplay : function (value, a,b,c) {
        if (this.labelAsTitle) return isc.emptyString;
        var title = this.invokeSuper(isc.CheckboxItem, "getTitleHTML", value, a,b,c);
        // If this item is displayed in a form that hilights required fields, 
        // hilight our title directly.
        
        var form = this.form;
        if ((this.required || this._required) && form && form.hiliteRequiredFields) {
            title = this.requiredTitlePrefix + title + this.requiredTitleSuffix;
        }
        return title;
    },

    // Use explicit checked and unchecked images as valueIcons
     _$Over:"Over", _$Down:"Down", _$Disabled:"Disabled",
    getValueIcon : function (value) {
        
        
        
        var map = this.getValueMap();
        if (!isc.isAn.Array(map) && isc.isAn.Object(map)) value = map[value];

        // Default behavior uses this.checkedImage and this.uncheckedImage
        if (value) return this.checkedImage;
        else if (value == false) return this.uncheckedImage;
        // If unset return the 'unset' image
        else return this.unsetImage;
    },
    
    // Override getTitleHTML() - we want to show an empty string in the title cell unless
    // labelAsTitle is true
    getTitleHTML : function (a,b,c) {
        if (this.labelAsTitle) return this.invokeSuper(isc.CheckboxItem, "getTitleHTML", a,b,c);
        return isc.emptyString;
    },
    
    
    // Some HTML overrides: 
    // always '_writeOuterTable' - we are typically just showing an image which has height 13
    // -- however we want to be centered regardless of our specified height, which means we'll
    // have to leave the text-box div unsized and instead size the outer table, and ensure the 
    // text box cell is v-align:center'd
    _writeOuterTable : function () {
        return true;
    },
    
    getTextBoxHeight : function () {
        return null;
    },
    
    _$heightSemi:"height:", _$px:"px",
    getTextBoxCellCSS : function () {
        var height = this.invokeSuper(isc.CheckboxItem, "getTextBoxHeight");
        if (height && isc.isA.Number(height)) 
            return this._$heightSemi + height + this._$px;
        
        return null;
    }
    
});

