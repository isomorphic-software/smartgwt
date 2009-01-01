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

 
 






//>	@class	RadioGroupItem
// FormItem that shows a set of mutually exclusive options as a group of radio buttons.
// @visibility external
//<
isc.ClassFactory.defineClass("RadioGroupItem", "ContainerItem");
isc.RadioGroupItem.addProperties({

    //>	@attr	radioGroupItem.itemHeight		(number : 20 : IRW)
	//			default height of EACH item
	//		@group	appearance
	//<
	itemHeight:20,

    //>	@attr	radioGroupItem.vertical			(boolean : true : IRW)
	//			True == display options vertically, false == display in a single row
	//		@group	appearance
    // @visibility external
	//<
	vertical:true,
    
    //>	@attr	radioGroupItem.prompt			(string : null : IRW)
	// Don't have a prompt for the entire item -- use itemPrompt to set the prompt of each
    // individual button.
	//		@group	appearance
	//<
	prompt:null						

    //>	@attr	radioGroupItem.itemPrompt			(string : null : IRW)
	// Mouse-over prompt for the label of this item.  Use character <code>"*"</code>
    // to substitute in the item value. For example <code>"Select value *"</code> would 
    // show the prompt <b>"Select value a"</b> when a user hovered over a radio button for
    // the value <code>"a"</code>.
	//		@group	appearance
	//<
	//itemPrompt:null
});

isc.RadioGroupItem.addMethods({	
    

	//>	@method	radioGroupItem.setItems()	(A)
	// Override setItems() to create radio buttons for each item in our valueMap.
	// We store items we've already created in a cache so we don't create them over and
    // over redundantly.
	//
	//		@group	drawing
	//
	//		@param	value	(string)	Value of the element [Unused because it is more reliably set by setValue].
	//		@return	(HTML)	HTML output for this element
	//<
    // Note: If the developer were to specify more than one item in the valueMap with the same
    // title/value, we would get in trouble here, as we'd end up with more than one entry in
    // our items array pointing to the same form item - This is an invalid usage by the
    // developer, but we don't currently catch this case explicitly.
	setItems : function () {
		var valueMap = this.getValueMap();
		if (!this.itemCache) this.itemCache = {};
		
		// create an array to hold the new set of items
		var items = [];
        
		if (isc.isAn.Array(valueMap)) {
			for (var i = 0; i < valueMap.length; i++) {
				var value = valueMap[i];
                
				items.add(this._getRadioItem(value, value));
			}
		} else {
			for (var value in valueMap) {
				var title = valueMap[value];
                
				items.add(this._getRadioItem(title, value));
			}
		}
		// call the superclass method to actually create the items
		return this.Super("setItems", [items]);
	},
    
	//>	@method	radioGroupItem._getRadioItem()	(A)
	//      Internal method to create radio item instances based on the title/value passed in.
	//		@group	drawing
	//
	//		@param	title   (string)    Title to display next to the radio item
    //      @param  value   (any)       value the radio item represents.
	//		@return	(RadioItem)     RadioItem instance to plug into the items array.
	//<
    _getRadioItem : function (title, value) {

        var item = this.itemCache[value+"|"+title];
        // If we're reusing an item, clean off the old properties from when it was last used
        // such as _value / hasFocus
        
        if (item) {
            delete item._value;
            delete item.hasFocus;
            delete item.disabled;
            
        } else {
        
            var prompt;
            if (this.itemPrompt) {
                var starRE = new RegExp("\\*","g");
                prompt = this.itemPrompt.replace(starRE, title);
            }
            var itemObj = {
                    type:"radio", 
                    
                    // ContainerItem stores sub-items under subItem.name.  Give the RadioItems
                    // names that won't collide with other properties, but that we can look up
                    // by value.
                    name:"_radioItem" + value,

                    value:value,
                    // override getElementName - the 'name' written into the HTML element
                    // must be the same for all these elements to create a radiogroup.
                    getElementName : function () {
                        return this.parentItem.getElementName();
                    },
                    
                    title:title, 
                    prompt:prompt, 
                    height:this.itemHeight, 
                    _startRow:this.vertical, 
                    
                    
                    updateValue : function () {
                        // pass in this.value (not this.getValue() which could be null)
                        this.parentItem.updatePreviousSelection(this.value);
                        return this.Super("updateValue", arguments);
                    },
                    
                    shouldSaveValue:false
                }
            ;
      
            item = this.itemCache[value+"|"+title] = isc.FormItemFactory.makeItem(itemObj);
        }       
        return item;
    },

    itemForValue : function (value) {
        return this["_radioItem" + value];
    },

	//>	@method	radioGroupItem.getInnerHTML()	(A)
	//		@group	drawing
	//			output the HTML for this element
	//
	//		@param	value	(string)	Value of the element [Unused because it is more reliably set by setValue].
	//		@return	(HTML)	HTML output for this element
	//<
	getInnerHTML : function (value) {
		// always call setItems() since the valueMap may have changed!
        this.setItems();
		return this.Super("getInnerHTML", arguments);
	},
    
    // Override isEditable to indicate that the user can directly update the radioGroup's value
    isEditable : function () {
        return true;
    },



    //> @method radioGroupItem.setValue()
    //      Set the value of this radiogroup item.
	//
    //      @group formValues
    //      @param  newValue    (any)           value to set the item to
	//<
    setValue : function (newValue) {
        this._setValueCalled = true;
    
        // use the default value if passed null, or a value for which we don't have a sub-item
        if (newValue == null || this.itemForValue(newValue) == null) 
            newValue = this.getDefaultValue();
            
        // "check" the appropriate sub item. 
        // If there is none, uncheck whatever is currently selected.  
        // Notes:
        // - We performed this check above to determine whether we need to apply a default
        //   value.  We still need to check again as we may not have a default value (or our
        //   default value could conceivably not be included in our valueMap).
        // - Clearing out our value if we don't find the value passed in means the user setting 
        //   the value of a radio-group to anything not in the valueMap is an equivalent to
        //   setting the value to null.
        if (this.itemForValue(newValue) != null) {
            this.itemForValue(newValue).setValue(newValue);
            // if the previous value is not null, update its value
            // Note - we assign directly to the _value property rather than calling updateValue
            // to avoid firing the change handler on that sub item
            if (this._value != null && this._value != newValue &&
                this.itemForValue(this._value) != null) 
            {
                this.itemForValue(this._value)._value = null;
            }
        }
        else if (this._value != null && this.itemForValue(this._value) != null) {
            this.itemForValue(this._value).setValue(null);
        }
        // save the new value        
        this.saveValue(newValue);
    },

    // this function is fired as a result of a selection change in the radioGroup
    // Its purpose is to ensure that the item that was previously selected has its internal
    // _value updated to match the fact that it has been deselected.
    // We have to do this because when a radio item gets selected, it fires a change handler
    // for itself, but no change handler is fired for the previous selection which gets 
    // automatically deselected due to native mutex behavior
    // This function updates the deselected item to ensure that a getValue() call for it returns
    // the appropriate value (null)
    updatePreviousSelection : function (newValue) {

        // Bail if 'updateValue' is fired on the currently selected item.
        // This avoids an infinite loop whereby 
        //  "A" is initially selected
        //  User selects "B"
        //  'updateValue' on "B" fires 'updatePreviousSelection' on the group item
        //  updatePreviousSelection on the group item fires 'updateValue' on "A"
        //  'updateValue' on "A" fires 'updatePreviousSelection' on the group item
        // -- we stop the process there
        
        // Note: We support valueMaps as objects or arrays.
        // If the valueMap is an object, the keys are always strings - so this:
        //   valueMap:{true:"Yes", false:"No"}
        // Will map to "true" and "false" rather than true and false.
        // In this case we are likely to see the value of the item being set programmatically
        // to a non string value (such as boolean true), but the "newValue", picked up from
        // updateValue() on the selected item being a string value.
        // Ensure in this case we convert the old value to a string before comparing.
        // (if we skip this we can end up with failure to update or infinite loops in some cases)
        var currentValue = this.getValue();           
        if (isc.isA.String(newValue)) currentValue = currentValue + "";        
        if (currentValue == null || newValue == currentValue || 
            this.itemForValue(currentValue) == null) 
        {
            return;
        }        
        this.itemForValue(currentValue).updateValue();
        
        
    },

    // override updateValue to get the value from the items
    // NOTE: We're currently relying on the fact that 'elementChanged()' will be bubbled and the
    // default implementation of this internal handler will fire updateValue() on a form item.
    // We may want to prevent elementChanged from bubbling, since Form Items should be managing
    // their own elements completely opaquely.  If so we would want to write change handlers
    // onto the sub-items to fire this.parentItem.updateValue().
    updateValue : function () {
        var value;
        // Any non-selected radioItem will return "null" from getValue();
        for (var i = 0; i < this.items.length; i++) {
            value = this.items[i].getValue();
            if (value != null) break;
        }
        
        // bail if the value is unchanged
        if (value == this._value) return;

        // fire the change handler, and bail if the change failed validation, etc.
        // Note: this method will call 'setValue()' to reset to the old value, or any value
        // suggested by the validators
        if (this.handleChange(value, this._value) == false) return;
        // check for updates performed by the change handler.
        value = this._changeValue;
      
        // save the value
        this.saveValue(value);
        
        // fire any specifed 'changed' handler for this item.
        this.handleChanged(value);
        

    },

	//>	@method	radioGroupItem.setValueMap
	//  Override setValueMap to redraw the form with the new set of radio items
	//<
    // A better way to do this would be to replace just the inner HTML for the relevant cell in
    // the dynamicForm, but currently we have no way to do that.
	setValueMap : function (valueMap) {
		this.Super("setValueMap", arguments);
		// unfortunately, there is no way to just update these values
		//  so we have to tell the item to redraw (will redraw the form by default)
		this.redraw();	
	},
	
	//>	@method	radioGroupItem.getHeight()	(A)
	//		@group	sizing
	//			output the height for this element
	//
	//		@return	(number)	height of the form element
	//<
	getHeight : function () {
		var valueMap = this.getValueMap(),
			numItems = 0;
			
		// if valueMap is an array, number of items is just the length of the array
		if (isc.isAn.Array(valueMap)) {
			numItems = valueMap.length;
		} else {
			for (var key in valueMap) {
				numItems++;
			}
		}
		return numItems * this.itemHeight;		
	}
});


