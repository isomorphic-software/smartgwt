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

 
 


//> @class SliderItem
// FormItem that uses a +link{class:Slider} component to present an interface for picking
// from either a continuous range or a range with a small number of discrete values.
//
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
// @example sliderItem
//<



isc.ClassFactory.defineClass("SliderItem", "CanvasItem");

isc.SliderItem.addProperties({

    // Passthroughs: certain properties are very likely to be set and so we allow setting them
    // right on the SliderItem
    // ---------------------------------------------------------------------------------------

    //> @attr sliderItem.vertical (boolean : false : IR)
    // @include slider.vertical
    //<
    vertical:false,

    //>	@attr sliderItem.minValue (float : 1 : [IRW])
    // @include slider.minValue
    // @example sliderItem
    //<
    minValue:1,

    //>	@attr sliderItem.maxValue (float : 100 : [IRW])
    // @include slider.maxValue
    // @example sliderItem
    //<
    maxValue:100,

    //>	@attr sliderItem.numValues (integer : null : [IRW])
    // @include slider.numValues
    // @example sliderItem
    //<
    
    //>	@attr sliderItem.defaultValue (integer : 1 : [IRW])
    // Default value for this sliderItems is 1.
    // @visibility external
    //<
    defaultValue:1,
    
    // sliderProperties: use for setting any other Slider property
    // ---------------------------------------------------------------------------------------
    
    //> @attr sliderItem.sliderProperties (Slider properties : null : IR)
    // Properties to add to the automatically created +link{class:Slider} used by this
    // FormItem.  See the +link{class:Slider} class for reference.
    //
    // @visibility external
    //<

    // ---------------------------------------------------------------------------------------

    shouldSaveValue:true,
    
    sliderDefaults : {
        autoDraw:false,
        showTitle:false,
        valueChanged : function () {
            if (this.canvasItem) this.canvasItem.sliderChange();
        }
    },
    autoDestroy:true
});

isc.SliderItem.addMethods({
    init : function () {
        this.Super("init", arguments);
        // used for change detection
        this._currentValue = this.getDefaultValue();
    },
    
    // Override _createCanvas to set up a Slider as this item's canvas, and set up appropriate
    // set of properties.
    _createCanvas : function () {
        // create our slider based on our sliderDefaults, and appropriate instance properties.
        var sliderDefaults = this.sliderDefaults;

        var sliderProperties = isc.addProperties(
                                {},
                                sliderDefaults, 
                                {
                                    vertical:this.vertical,
                                    minValue:this.minValue,
                                    maxValue:this.maxValue,
                                    value:this.defaultValue,
                                    numValues:this.numValues,
                                    tabIndex:this.getGlobalTabIndex()
                                },
                                this.sliderProperties
                               );

        this.canvas = isc.Slider.create(sliderProperties);
        
        this.Super("_createCanvas", arguments);        
    },
    
    // Sliders are editable
    isEditable : function () {
        return true;
    },
            
    // Override setValue to update the value on the slider
    setValue : function (value) {
        this._setValueCalled = true;

        var defaultVal;
        if (value == null) {
            defaultVal = this.getDefaultValue();
            // don't apply the default value if it's not set - this allows for the distinction 
            // between setting the value to 'null' vs 'undefined'
            if (defaultVal != null) value = defaultVal;
        }

        // update the previous value so we don't fire a change handler on 'sliderChanged'
        this._currentValue = value;
        this.canvas.setValue(value, (defaultVal != null));
        // No need to save this value - that should be handled by sliderChange
    },
    
    getValue : function () {
        return this.canvas.getValue();
    },
    
    // Define a sliderChange function to handle value changes
    sliderChange : function() {
        // Note: the slider.valueChanged method doesn't inform us what the old value was, so
        // we need to track this ourselves in order to pass it to any item level change handler.
        var val = this.canvas.getValue();
        if (this._currentValue != val) {
            this._updateValue(val);
        // catch the case where there was an explicit setValue() call, and save out the new
        // value from the slider.
        } else {
            this.saveValue(val);
        }
    }
    


});
