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


//> @class SpinnerItem
//
// Item for picking a number. Includes arrow buttons to increase / decrease the value
//
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
// @example spinnerItem
//<
isc.ClassFactory.defineClass("SpinnerItem", "TextItem");

isc.SpinnerItem.addClassProperties({

    //> @const  SpinnerItem.INCREASE_ICON    (FormItemIcon Properties : {...} : IRW)
    // Icon to increase the spinner's value (an up-arrow by default)
    // @visibility external
    //<
    INCREASE_ICON:  {width:16, height:9, src:"[SKIN]/DynamicForm/Spinner_increase_icon.png",
                        showOver:true,  
                        // We don't need to support native focus, and we'll use mouseStillDown
                        // rather than standard icon click to handle activation
                        imgOnly:true,
                        hspace:0
                    },

	//>	@const	SpinnerItem.DECREASE_ICON   (FormItemIconProperties : {...} : IRW)
	// Icon to decrease the spinner's value (a down-arrow by default)
    // @visibility external
    //<
    DECREASE_ICON:  {width:16, height:9, src:"[SKIN]/DynamicForm/Spinner_decrease_icon.png",
                        showOver:true,  
                        imgOnly:true,
                        hspace:0
                    }
});

isc.SpinnerItem.addProperties({

    // Don't fire the change handler on every keypress, as we need the user to be able
    // to enter partial numbers (like the string "-") without us trying to validate it as a 
    // number
    changeOnKeypress:false,
    
    // Don't allow tabbing to the spinner icons - you already have keyboard support via up and
    // down arrows, and we don't support rolling the vals up and down via keypresses on the
    // icons...
    canTabToIcons:false,
    
    // Default to matching the height of the 2 spinners exactly.
    height:18,

    //> @attr   SpinnerItem.step    (number : 1 : IRW)
    //  How much should the value be incremented / decremented when the user hits the icons
    //  to increase / decrease the value?
    // @visibility external
    // @example spinnerItem
    //<
    step:1
    
    //>@attr    SpinnerItem.max (number : null : IRW)
    // Maximum valid value for this item    
    // @visibility external
    // @example spinnerItem
    //<
    
    //>@attr    SpinnerItem.min (number : null : IRW)
    // Minimum valid value for this item    
    // @visibility external
    // @example spinnerItem
    //<


});

isc.SpinnerItem.addMethods({
    
    // Override init to ensure 'step' is a valid numeric value
    init : function () {
        this.Super("init",arguments);
        var step = this.step;
        if (step != null && !isc.isA.Number(step)) {
            step = parseFloat(step);
            if (!isc.isA.Number(step)) step = 1;
            this.step = step;
        }
    },

    // Override 'setUpIcons' to add the Increase / Decrease icons
    _setUpIcons : function () {
        // Add the pickbutton to the set of icons
        if (this.icons == null) this.icons = [];
        
        var inc = isc.addProperties({}, isc.SpinnerItem.INCREASE_ICON),
            dec = isc.addProperties({}, isc.SpinnerItem.DECREASE_ICON);
            
        this.icons.addListAt([inc,dec], 0);
        
        this.Super("_setUpIcons", arguments);
    },

    // Override getIconsHTML to write the increase / decrease icons out, one above the other
    
    getIconsHTML : function () {
    
        if (!this.showIcons) return "";

        var output = isc.SB.create();

        if (!this._spinnerTableTemplate) {
            
            
            var cellStart = "<TD tabIndex=-1" + (isc.Browser.isIE ? " style='font-size:0px'" : "") + ">",
                
                sampleIcon = {},
                vAlign = this._getIconVAlign(sampleIcon),
                vMargin = this._getIconVMargin(sampleIcon);

            this._spinnerTableTemplate = [
                // The table has to be display:inline otherwise subsequent icons get rendered
                // on a new line.
                
                "<TABLE STYLE='vertical-align:",vAlign,
                    ";margin-top:", vMargin, ";margin-bottom:", vMargin, 
                    ";display:inline;' BORDER=0 CELLPADDING=0 CELLSPACING=0><TR>",
                  cellStart, this.getIconHTML(this.icons[0]),
                "</TD></TR><TR>",
                  cellStart, this.getIconHTML(this.icons[1]),
                "</TD></TR></TABLE>"
            ];
        }
        
        output.append(this._spinnerTableTemplate);
        
        for (var i = 2; i < this.icons.length; i++) {

            var icon = this.icons[i];
            
            // don't write out the icon if it specified a showIf, which returns false
            if (!this._shouldShowIcon(icon) || this._writeIconIntoItem(icon)) continue;
            
            output.append(this.getIconHTML(icon));
        }
        
        
        return output.toString();
    },
    
    // Override getIconVMargin to return zero for the spinners.
    _getIconVMargin : function(icon) {
        if (icon == this.icons[0] || icon == this.icons[1]) return 0;
        return this.Super("_getIconVMargin", arguments);
    },

    // we're writing our 2 spinner icons one above the other
    // Only account for the width of one of them, not both
    getTotalIconsWidth : function () {
        var width = this.Super("getTotalIconsWidth", arguments);
        // A width of zero implies we're not showing any icons
        if (width > 0) {
            var spinWidthExcess = Math.max(this.icons[0].width, this.icons[1].width);
            width -= spinWidthExcess;
        }
        return width;
    },

    // Use 'mouseStillDown' to handle the user holding the mouse over the increase/decrease 
    // icons
    mouseStillDown : function (form, item, event) {
        if (this.isDisabled()) return;

        // increment counter for simple value ramp
        this._mouseStillDownCounter++;
        
        if (this._valueIsDirty) this.updateValue();
        
        var nativeTarget = event.nativeTarget;
        if (nativeTarget == this._getIconImgElement(this.icons[0])) {
            this.increaseValue();
        } else if (nativeTarget == this._getIconImgElement(this.icons[1])) {
            this.decreaseValue();
        }
    },
    
    // reset counter for simple value ramp
    mouseDown : function (form, item, event) {
        if (this.isDisabled()) return;
        // force focus into the item on mouseDown - required to ensure we save out change made via
        // icon click
        if (!this.hasFocus) this.focusInItem();
        this._mouseStillDownCounter = 0;
    },
    
    // Override handleKeyPress to increase / decrease on up / down arrow keys
    handleKeyPress : function (event, eventInfo) {

        if (this.Super("handleKeyPress", arguments) == false) return false;
        var keyName = event.keyName;
        if (keyName == "Arrow_Up") {
            this.increaseValue();
            return false;
        }
        if (keyName == "Arrow_Down") {
            this.decreaseValue();
            return false;
        }
    },
    
    increaseValue : function () {
        this.updateValue();
        var value = this.getValue();
        if (value != null && this.max == value) return;
        var mouseStillDownCounter = this._mouseStillDownCounter;
        // If we get called directly when the mouse is not down, don't crash, just increment by
        // a single step.
        // Otherwise apply a simple value ramp - double the step size every 2 seconds
        var step = this.step * (mouseStillDownCounter != null ? 
                            Math.pow(2, 
                                Math.floor(
                                    this._mouseStillDownCounter/(2000/isc.EH.STILL_DOWN_DELAY)
                                )
                            ) :
                                1);
        return this._increaseValue(value, step);
    },
    
    decreaseValue : function () {
        this.updateValue();    
        var value = this.getValue();
        if (value != null && this.min == value) return;
        var mouseStillDownCounter = this._mouseStillDownCounter,
            step = (0-this.step) * (mouseStillDownCounter != null ? 
                            Math.pow(2, 
                                Math.floor(
                                    this._mouseStillDownCounter/(2000/isc.EH.STILL_DOWN_DELAY)
                                )
                            ) :
                                1);
        
        return this._increaseValue(value, step);
    },
    
    // Actually modify the value    
    
    _increaseValue : function (value, step) {

        var minVal = this.min, maxVal = this.max;

        // If it's not a value to start with, default to zero.
        // If zero is outside our range, default to minVal (or maxVal if min is not defined)
        // instead
        if (!isc.isA.Number(value)) {
            value = 0;
            if ((minVal != null && value < minVal) || (maxVal != null && value > maxVal)) {
                
                value = (minVal != null ? minVal : maxVal);
            }
        // Otherwise increment as requested
        } else {
            
            
            var stepDP,
                valueDP;
            
            if (Math.round(step) == step) {
                stepDP = 0
            } else {
                
                var stepString = step + "";
                stepDP = stepString.length - (stepString.indexOf(".") +1);
            }
            if (Math.round(value) == value) {
                valueDP = 0;
            } else {
                var valueString = value + "";
                valueDP = valueString.length - (valueString.indexOf(".") +1);
            }
            value += step;
            
            var decimalPlaces = Math.max(stepDP, valueDP);
            if (decimalPlaces > 0) {
                
                value = parseFloat(value.toFixed(decimalPlaces));
            }
            
            // Don't go beyond max / min
            if (step > 0 && maxVal != null && value > maxVal) value = maxVal;
            else if (step < 0 && minVal != null && value < minVal) value = minVal;
        }
        this.setElementValue(value);
        this.updateValue();    

    },
    
    // Override mapDisplayToValue to return a numeric value rather than a string.
    mapDisplayToValue : function (value) {
        value = this.Super("mapDisplayToValue", arguments);
        
        if (isc.isA.String(value)) {
            var floatVal = parseFloat(value);
            if (floatVal == value) value = floatVal;
        }
        return value;
    },
    
    // Override updateValue (called when a user modifies the value) to validate the value as 
    // numeric.
    updateValue : function () {

        var value = this.getElementValue();

        // unmap the value if necessary 
        value = this.mapDisplayToValue(value);

        if (value == this._value) return;
        
        // If the user entered an invalid number just refuse to accept it.
        if (value != null && (!isc.isA.Number(value) || (this.max != null && value > this.max) || 
                                (this.min != null && value < this.min)) )
        {
            var oldValue = this.mapValueToDisplay(this._value);
            this.setElementValue(oldValue);
            return;
        }

        // Allow the superclass implementation to actually update the value
        this.Super("updateValue", arguments); 
    },
    
    // Override setValue to disallow setting to a non numeric value programatically
    setValue : function (value, allowNullValue, a,b,c,d) {
        if (value != null && !isc.isA.Number(value)) {
            var numVal = parseFloat(value);
            if (numVal == value) value = numVal;
            else {
                this.logWarn("setValue(): passed '" + value + 
                                "'. This is not a valid number - rejecting this value");
                value = null;
            }
        }
        if (value != null) {
            if (this.max != null && value > this.max) {
                this.logWarn("setValue passed "+ value + 
                                " - exceeds specified maximum. Clamping to this.max.");
                value = this.max;
            }
            if (this.min != null && value < this.min) {
                this.logWarn("setValue passed "+ value + 
                                " - less than specified minimum. Clamping to this.min.");
                value = this.min;
            }
        }
        
        return this.invokeSuper(isc.SpinnerItem, "setValue", value, allowNullValue, a,b,c,d);
    }
	    
});
