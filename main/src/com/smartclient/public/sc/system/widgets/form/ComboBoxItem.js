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

 
 
 




//>	@class	    ComboBoxItem
// The Combobox is a text input field which can show a list of options via a drop-down
// PickList.
// <p>
// The set of options will be filtered based on the current value in the text field, so only
// options that match what has been typed so far will be displayed.
// The set of options can be derived from a ValueMap or dynamically retrieved from a
// dataSource.  See the +link{interface:PickList} interface for further settings.
// <P>
// Note that to select the first option as a default value for the item,
// +link{ComboBoxItem.defaultToFirstOption} may be set.
//
// @see interface:PickList
// @implements PickList
// @treeLocation Client Reference/Forms/Form Items
// @example listComboBox    
// @visibility comboBox
// @example listComboBox
//<
// Example of a Combo-Box type item in Windows applications: The URL bar for most browsers.
// ComboBox is used for:
// - "search": ComboBox is in a search form which is bound to the DataSource being searched
//   - eg: autoCompletion on names in an address book
// - "find-related": ComboBox is in an editing form and is being used to pick related records
//   from other DataSources
//   - eg: when editing an Account, find a User record to use as account.owner
//   - in this case, we want to
//     - default to displaying identifying fields from the related records
//     - store the primary key of the related record, NOTE however:
//       - the fieldName in the record being edited may not be the same as the fieldName
//         of the PK in the related record
//       - we may not actually store the PK if field.foreignKey indicates some other field.
//         Eg, the primaryKey might be a meaningless internal value and we may store instead
//         some other unique value
isc.defineClass("ComboBoxItem", "TextItem", "PickList").addMethods({
    
    //>@attr ComboBoxItem.defaultValue (boolean : null : IRW)
    // Static default value for this ComboBoxItem. To default to the first option use
    // +link{ComboBoxItem.defaultToFirstOption} instead.
    // @visibility external
    //<
    
    //> @method ComboBoxItem.defaultDynamicValue() (A)
    // Expression evaluated to determine the +link{ComboBoxItem.defaultValue} when no value is 
    // provided for this item. To default to the first option use
    // +link{ComboBoxItem.defaultToFirstOption} instead.
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.defaultToFirstOption (boolean : false : IRW) 
    // Select the first option as the default value for this ComboBoxItem. If options are derived
    // from a dataSource, the first value returned by the server will be used, otherwise the first
    // value in the valueMap. If enabled, this setting overrides +link{ComboBoxItem.defaultValue}
    // and +link{ComboBoxItem.defaultDynamicValue}|.
    // @visibility external
    //<
    
    
    // Default to auto-sizing pickList
    // This means the pickList will expand to the size required to accomodate its content.
    // As the user types and filters occur, this means the pickList may resize horizontally but
    // seems to have no obvious performance impact
    autoSizePickList:true,

    // Override drawn() - if this is a databound pickList we want to perform a filter before
    // the pickList itself ever gets shown.
    
    drawn : function (a,b,c,d) {
        this.invokeSuper(isc.ComboBoxItem, "drawn", a,b,c,d);
        if (this.autoFetchData && this._getOptionsFromDataSource()) {
            
            this.filterWithValue = false;        
            this.fetchData(null, null, true);
        }
    },
    
    //>@attr ComboBoxItem.showPickerIcon    (boolean : true : [IRWA])
    // Show the picker icon for the combo box 
    // @visibility external
    //<    
    showPickerIcon:true,
    
    //>@attr ComboBoxItem.pickerIconWidth   (number : 15 : [IRW])
    // Default the picker icon to a fixed with (15px). 
    // @visibility external
    //<
    pickerIconWidth:15,
    
    //>@attr ComboBoxItem.pickerIconHeight   (number : null : [IRW])
    // Don't specify an explicit height for the picker icon - instead have it size to match the
    // height of the combo box item.
    // @visibility external
    //<
    
    //>@attr ComboBoxItem.pickerIconSrc  (SCImgURL : "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif" : [IRWA])
    // Src for the picker icon
    // @visibility external
    //<
    pickerIconSrc:"[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif",

    // Apply some default properties to the picker icon.
    pickerIconProperties:{
        // We don't want it to be imgOnly because we need click handling, but we don't want it
        // in the page's tab order
        tabIndex:-1,
        showOver:true
    },
    
    // override modalPickList - we don't want to take focus from the text item when the
    // pickList is shown.
    modalPickList:false,
    
    //>@attr    ComboBoxItem.showPickListOnKeypress  (boolean : true : IRW)
    // Should the list of options be displayed whenever the user types into the 
    // the combo-box textArea, or only when the user clicks on the pick button or uses the 
    // explicit <code>Alt+Arrow Down</code> key combo?
    // @visibility comboBox
    //<
    showPickListOnKeypress:true,
    
    //>@attr    ComboBoxItem.completeOnTab (boolean : null : IRW)
    // If true, when the pickList is showing, the user can select the current value by hitting
    // the <code>Tab</code> key.
    // @visibility comboBox
    //<
    //completeOnTab:null,

    // Implement pickListShown to set up a page level mousedown handler to hide the pickList.
    
    pickListShown : function () {
        if (this.pickList.isVisible()) {
            // Don't pass in the 'fire once' param - if the user clicks outside we'll clear the
            // click event in response to that click. If the user clicks on the pickList
            // (or it's scrollbar, for example) we want to continue listening for future clicks
            // outside.
            this._pageClickID = 
                this.ns.Page.setEvent("mouseDown", this, null, "_clickOutside");
        }
    },
    
    // If the user clicks on the page while the pickList is up, hide the pickList
    
    _clickOutside : function () {
        var pl = this.pickList;
        if (!pl || !pl.isVisible()) return;
        
        var target = isc.EH.lastEvent.target;
        if (!pl.contains(target, true)) pl.hide();
        
        // What to do on mouseUp?
        // - If the click occurred over the pickerIcon we don't want to re-show in response to 
        //   the click that follows this mouseDown.
        // - If the click occurred over the PickList, (or its scrollbar), in IE native focus will
        //   be taken from the textbox, even though the scrollbar is non-focusable.
        //   Restore focus on mouse up so the user can continue typing / do arrow-key navigation
        //   from the textbox.
        if (!this._dismissOnMouseUp) {
            this._dismissOnMouseUp = 
              this.ns.Page.setEvent("mouseUp", this, isc.Page.FIRE_ONCE, "_dismissPickListClick");
        }
        // Note: if the user is dragging the scrollbar, we'll see a dragStop event, with no
        // mouseUp
        if (!this._refocusOnDragStop) {
            this._refocusOnDragStop = 
              this.ns.Page.setEvent("dragStop", this, isc.Page.FIRE_ONCE, "_refocusFromPLMouseUp");
        }
    },
    _dismissPickListClick : function () {
        // If the click happened over this item, cancel it. this will prevent the 
        // pickList from showing when it was hidden on a mousedown and the user clicks this item.
        if (this.form._getEventTargetItemInfo().item == this) {
            this.ns.Page.clearEvent("dragStop", this._refocusOnDragStop);
            // no need to clear the dismissOnMouseUp event since it's marked as FIRE_ONCE
            delete this._refocusOnDragStop;
            delete this._dismissOnMouseUp;
            return false;
        }
        this._refocusFromPLMouseUp(true);
    },
    
    _refocusFromPLMouseUp : function (fromClick) {
        // Only clear the event we're not responding to since the events are marked as FIRE_ONCE
        
        if (fromClick == true) {
            this.ns.Page.clearEvent("dragStop", this._refocusOnDragStop);
        } else {
            this.ns.Page.clearEvent("mouseUp", this._dismissOnMouseUp);
        }
        delete this._refocusOnDragStop;
        delete this._dismissOnMouseUp;
        
        if (this.pickList && this.pickList.isVisible() && 
            this.pickList.contains(isc.EH.getTarget())) 
        {            
            this.focusInItem();
        }
    },
    
    // Implement pickListHidden to clear the page level click event to hide the pickList, if
    // we haven't already.
    pickListHidden : function () {
        if (this._pageClickID) this.ns.Page.clearEvent("mouseDown", this._pageClickID);
        delete this._pageClickID;
    },
    
    // Override handkeKeyPress - as the user types, we want to re-filter the list.
    // Also proxy Arrow key presses to the PickList to navigate through options.
    // Behavior:
    // - We don't want the list showing if 
    //      - there are no matches
    //      - the textItem is empty
    // - Otherwise we want the list to show.
    _$ArrowUp:"Arrow_Up", _$ArrowDown:"Arrow_Down",
    _$PageUp:"Page_Up", _$PageDown:"Page_Down",
    _$Escape:"Escape", _$Enter:"Enter", _$Tab:"Tab",
    handleKeyPress : function () {
        if (!this.hasFocus) return this.Super("handleKeyPress", arguments);

        var keyName = isc.EH.lastEvent.keyName,
            pickList = this.pickList,
            pickListVisible = (pickList ? (pickList.isDrawn() && pickList.isVisible()) : false);            

        // deliver PageUp/Down to the body to cause scrolling
        if (pickListVisible && (keyName == this._$PageDown || keyName == this._$PageUp)) {
            return pickList.body.handleKeyPress(isc.EH.lastEvent);
        }
        
        var value = this.getValue(),
            isEmpty = (!value || value == isc.emptyString);
        
        if (keyName == this._$ArrowDown && isc.EH.altKeyDown()) {
            // By default we hide the picklist whenever we get a keypress and the value is
            // empty (this is for the case where the user clears out the combobox text value).
            // Set a flag here to avoid hiding the combobox unless the value has subsequently
            // changed.
            if (isEmpty) this._shownOnEmpty = true;
            
            this.filterWithValue = false;
            this.showPickList();
            return false;
        }
        
        if (pickListVisible) {
            // pass navigation keys (arrows) through to the drop-down list
            // so the user can navigate through the selection
            if (keyName == this._$ArrowDown || keyName == this._$ArrowUp ||
                // also pass "Enter" up to the list to trigger 'itemClick' behavior
                // and "Escape" to trigger 'cancel' behavior
                keyName == this._$Enter || keyName == this._$Escape) 
            {
                pickList.bodyKeyPress(isc.EH.lastEvent);
                // kill the native behavior - shifting the cursor in the text field
                return false;
            }

             
            // If completeOnTab is true, pick the currently selected value on tab.
            // Also do so if autoComplete:"smart" is enabled (inline autoCompletion),
            // as tab accepts an inline completion.
            if (pickList && pickList.isVisible() && keyName == this._$Tab && 
                (this.completeOnTab || this._getAutoCompleteSetting() == this._$smart))
            {
                var selection = pickList.getSelectedRecord();
                if (selection != null) pickList.itemClick(selection);
            }
            
        }
        
        return this.Super("handleKeyPress", arguments);
    },

    // Override handleChange to re filter the list on every change (which occurs on every 
    // keypress)
    handleChange : function (newValue, oldValue) {
        var returnVal = this.Super("handleChange", arguments);
        if (returnVal == false) return false;

        // Check for the change handler having modified the value to be saved.
        newValue = this._changeValue;
        
        var isEmpty = (!newValue || newValue == isc.emptyString);        
        
        // clear out the shownOnEmpty string if we're not empty any more
        if (!isEmpty) delete this._shownOnEmpty;

        // if the text field is empty, ensure the list is hidden
        var pickList = this.pickList,
            pickListVisible = (pickList ? pickList.isVisible() : false);
        if (isEmpty && !this._shownOnEmpty) {
            if (pickListVisible) pickList.hide();
        } else if (this.showPickListOnKeypress || pickListVisible) {
            // At this point we know the change is ok, but the new value has not yet been saved
            // Save the value out so our filter will work
            
            this.saveValue(newValue);
        
            // showPickList will set up the pickList initially, or if already set up
            // will re-filter
            // Note - if our value changed in response to the user picking something from the
            // list we don't want to show the pickList again.
            // Note - pass in the second 'queueFetches' parameter - we don't want to kick off
            // multiple server fetches while the user is rapidly typing in the text field
            
            if (!this._valuePicked && this.hasFocus) {
                
                this.filterWithValue = true;
                this.showPickList(true, true);
            }
        } 

    },

    // Override selectDefaultItem to always select the first item in the list.
    // This will happen on every re-filter.
    selectDefaultItem : function () {    
        if (this.pickList == null || this.pickList.destroyed) return;
        
        var selection = this.pickList.selection;
        
        // If there's already something selected, just bail - we only want to select the first
        // item when the filter changes (and the old selection gets dropped).
        if (this.pickList.selection.anySelected()) return;

        var record = this.pickList.getRecord(0);
        // Don't attempt to select null / loading / separator rows
        if (record == null || Array.isLoading(record) || 
            record[this.pickList.isSeparatorProperty]) return;
        
        selection.selectSingle(record);
        // Clear last hilite - required so keyboard navigatioin will pick up the current position
        // from the selection, not the last hilite position.
        this.pickList.clearLastHilite();
        this.pickList.scrollRecordIntoView(0);
    },

    // ------------------------
    // Filtering data
    // ------------------------
    
    // Include useful JSDoc from pickList
    
    //> @attr ComboBoxItem.optionDataSource (DataSource | String : null : IRA)
    // @include PickList.optionDataSource
    //<
    
    //> @attr ComboBoxItem.pickListFields (Array : null : IRA)
    // @include PickList.pickListFields
    //<
    
    //> @method ComboBoxItem.fetchData()
    // @include PickList.fetchData()
    //<
    
    //> @attr ComboBoxItem.optionFilterContext (RPCRequest Properties : null : IRA)
    // @include PickList.optionFilterContext
    //<
    
    
    //> @attr ComboBoxItem.displayField (string : null : IRWA)
    // @include PickList.displayField
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.valueField   (string : null : IRW)
    // @include PickList.valueField
    // @visibility external
    //<
    
    //> @method ComboBoxItem.getDisplayFieldName() ([A])
    // @include PickList.getDisplayFieldName()
    // @visibility external
    //<
        
    //> @method ComboBoxItem.getValueFieldName()
    // @include PickList.getValueFieldName()
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.filterLocally
    // @include PickList.filterLocally
    // @visibility external
    //<    

    //> @method ComboBoxItem.getSelectedRecord()
    // @include PickList.getSelectedRecord()
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.pickListCriteria (Criteria : null : IRWA)
    // @include PickList.pickListCriteria
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.showOptionsFromDataSource    (boolean : null : IRWA)
    // @include PickList.showOptionsFromDataSource
    // @visibility external
    //<
    
    //> @attr   ComboBoxItem.pickListProperties   (object : null : IRA)
    // @include PickList.pickListProperties
    // @visibility external
    //<
    
    // Default pickList interface 'filtering' basically returns every record (this is the
    // desired behavior for select items).
    // For pickLists we want to show only the subset of options that matches the string
    // currently in the combo box text element.

    // Set filterDisplayValues to ensure that if we're working with client side options,
    // the filter criteria are recognized as the display values for the data not the raw values.
    filterDisplayValue:true,
    
    //> @attr ComboBoxItem.autoFetchData   (boolean : false : [IRA])
    // If this combo box retrieves its options from a <code>dataSource</code>, should options
    // be fetched from the server when the item is first written out, or should this fetch be
    // delayed until the user opens the pickList.
    // @visibility external
    // @see PickList.optionDataSource
    //<
    autoFetchData:false,

    //> @attr ComboBoxItem.filterWithValue (boolean : varies : [RA])
    // Read-only property set by the ComboBoxItem to indicate whether we should use the 
    // current typed-in value as part of the filter criteria returned by 
    // +link{ComboBoxItem.getPickListFilterCriteria()}.  You can check this flag in order to
    // mimic the ComboBoxItem's default behavior if you provide a custom implementation of
    // <code>getPickListFilterCriteria()</code>.
    // @visibility external
    //<
    
    //> @attr ComboBoxItem.alwaysFilterWithValue (boolean : false : [RA])
    // If set to true, the default implementation of 
    // +link{comboBoxItem.getPickListFilterCriteria()} will always add the current item's value
    // to the any specified pickListFilterCriteria, regardless of the current value of 
    // +link{ComboBoxItem.filterWithValue}.
    // <P>
    // This was the default behavior for SmartClient version 5.6 and earlier.
    // @visibility internal
    //<
    
    //> @method  ComboBoxItem.getPickListFilterCriteria()    (A)
    // Returns filter criteria for options displayed for this item.  
    // <P>
    // The criteria returned by this method are used to decide which options should appear in
    // the drop-down +link{PickList} shown by this ComboBox.
    // <P>
    // While the user is typing in a value, this method will return the typed-in value as part
    // of the criteria, so that only matching values are shown.  Matching is determined by the
    // +link{comboBoxItem.textMatchStyle,textMatchStyle}.  
    // <P>
    // If the user explicitly shows the down-down pickList, via either clicking on the drop
    // down icon or use the <i>Ctrl+Arrow Down</i> key combo, the typed in value is ignored for
    // filtering.
    // <P>
    // If included in the criteria, the typed in value will be included as a value for the 
    // +link{ComboBoxItem.displayField,displayField} (or for the
    // +link{ComboBoxItem.valueField,valueField} if <code>this.displayField</code> is
    // unspecified).
    // <P>
    // Static criteria, specified via +link{comboBoxItem.pickListCriteria,pickListCriteria},
    // will always be included.
    // <P>
    // If you are implementing your own <code>getPickListFilterCriteria()</code> the
    // <b>read-only</b> property +link{ComboBoxItem.filterWithValue,this.filterWithValue} can
    // be read to determine whether the ComboBox would ordinarily ignore the typed-in value for
    // filtering.  Note that in addition to cases where the user explicitly shows the pickList,
    // <code>filterWithValue</code> will also be <code>true</code> during a call to 
    // +link{ComboBoxItem.fetchData()} on a databound comboBox.
    //    
    // @return (Criteria) criteria to be used for databound or local filtering
    // @visibility external
    //<
    getPickListFilterCriteria : function () {
        var crit = {};
        if (this.alwaysFilterWithValue || this.filterWithValue) {
            
            var value = this.getDisplayValue(),
                fieldName = (this.getDisplayFieldName() || this.getValueFieldName());
                
            crit[fieldName] = value;
        }
        // Assume that if pickListCriteria is specified it's a more fundamental filter that
        // should be applied in addition to filtering by the typed value.
        if (this.pickListCriteria) isc.addProperties(crit, this.pickListCriteria);
        return crit;
    },

    //> @method comboBoxItem.getClientPickListData()
    // @include PickList.getClientPickListData()
    //<

    //> @method comboBoxItem.filterClientPickListData()
    // @include PickList.filterClientPickListData()
    //<

    //> @attr comboBoxItem.textMatchStyle (String : "startsWith" : IR)
    // @include PickList.textMatchStyle
    //<

    //> @attr comboBoxItem.showAllOptions (boolean : null : IR)
    // @include PickList.showAllOptions
    //<
    
    //> @method ComboBoxItem.dataArrived()
    // @include PickList.dataArrived()
    // @visibility external
    //<

    //> @attr comboBoxItem.separatorRows (Array of ListGridRecord : [{isSeparator:true}] : IR)
    // @include PickList.separatorRows
    //<
    
    // When the user blurs from the combo box item we want to ensure we hide the pickList.
    
    elementBlur : function () {
        this.Super("elementBlur", arguments);
        var pickList = this.pickList,
            EH = isc.EH,
            event = EH.lastEvent;
        //this.logWarn("eventType is: " + event.eventType + 
        //             " event.target: " + event.target +
        //             " pickList.isAncestor: " + pickList.contains(event.target,true) +
        //             ", activeElement: " + this.echoLeaf(document.activeElement));

        // don't hide the pickList if ..
        if (    (  pickList && 
                   (
                       // the preceding event was a selectionChange event, which fires right after
                       // mouseDown in the pickList, strangely triggered by some action we take in
                       // Element._getElementFromSelection()
                       // Special case because we can't look at event.target to determine if it was
                       // a click on the pickList                   
                       ( event.eventType == "selectionChange" && 
                         pickList.contains(isc.EH.mouseDownTarget()) )
                       ||
            
                       // it's a mouseDown/click on the pickList or one of it's subcomponents
                       (
                        (event.eventType == EH.MOUSE_DOWN || event.eventType == EH.CLICK) && 
                        pickList.contains(event.target,true) 
                       )
                   )
                ) 
                ||
                // ignore a delayed blur firing in IE when focus is still in the text input element
                (isc.Browser.isIE && this.getActiveElement() == this.getDataElement())
           ) 
        {
                return;
        }

        // ensure we don't show when 
        // - delayed filter is kicked off
        // - asynchronous filter completes
        delete this._showOnFilter;
        delete this._showOnDelayedFilter;

        // bail if the pickList isn't showing 
        if (!pickList || !pickList.isVisible()) return;

        // hide the pickList
        pickList.hide();
    },

    // Override showPicker to ensure we have focus, and show the pick list
    showPicker : function () {
        this.focusInItem();        
        
        this.filterWithValue = false;
        return this.showPickList();
    },    

    // pickValue
    // This method is fired when a value is selected from the pick list.
    // update the value of this item, and fire the change handler.
    pickValue : function (value) {
        this.setElementValue(this.mapValueToDisplay(value));
        
        // Hang a flag on the item so that we don't re-show the pick list
        this._valuePicked = true;
        // this is relying on the standard mapDisplayToValue() to convert from display value
        // back to data value for storage
        this.updateValue();
        delete this._valuePicked;
    },
    
    // override setValue map to update the list and update the displayed value if necessary.
    setValueMap : function () {
        this.Super("setValueMap", arguments);
        if (this.pickList) {
            if (this.pickList.isVisible()) this.pickList.hide();
            // clear out the formItem property - ensures data / fields get re-set up when
            // the pickList is next shown.
            delete this.pickList.formItem
            // dont show the pickList if it's not already visible
            this.setUpPickList(this.pickList.isVisible());
        }
        // The display-version of the value is likely to have changed, so update the element
        // value at this point.
        this.setElementValue(this.mapValueToDisplay(this.getValue()));
    },    
    
    // Override setValue and mapValueToDisplay to ensure that on an explicit setValue() to
    // a value that's not currently loaded in the pickList dataSet, we show the display value
    // rather than the underlying data value.
    setValue : function (newValue, a,b,c,d) {
        this._programmaticSetValue = true;
        this.invokeSuper(isc.ComboBoxItem, "setValue", newValue, a,b,c,d);
        delete this._programmaticSetValue;
    },
    
    // override getDefaultValue to support defaultToFirstOption
    // override getDefaultValue to pick up the first option if defaultToFirstOption is true
    // getDefaultValue should not be able to return a value that is not included
    // in the valueMap for this select.
    getDefaultValue : function () {
        
        var dV = this.Super("getDefaultValue", arguments);
        if (dV == null && this.defaultToFirstOption) {
            dV = this.getFirstOptionValue();
        }
        return dV;
    },
    
    
    // Override checkForDisplayFieldValue()
    // This is the method that, if we have a displayField specified, kicks off a fetch against
    // our optionDataSource to load the appropriate display value from the server.
    // In PickList based items we use the pickList data (if present) to map data to display 
    // values. 
    // Catch the case where checkForDisplayFieldValue is called when we are in the process of
    // fetching our pickList data from the server.
    // In this case we want to wait for the pickList data to be returned rather than kicking off
    // an additional fetch as our data value will usually be present in that pickList data.
    // When the pickList data returns we re-check this method. If the data is present, we're 
    // done, otherwise we need to kick off another fetch as we didn't find our data value in
    // the pickList data array. This can happen if the pickList data is paged, for instance.
    
    _checkForDisplayFieldValue : function (newValue, delayed) {
        var inValueMap = (this._mapKey(newValue, true) != null);
        
        if (inValueMap) return; 
        
        if (this._fetchingPickListData) {
            this._checkDisplayFieldValueOnFilterComplete = true;
            return;
        }        
        this.invokeSuper(isc.ComboBoxItem, "_checkForDisplayFieldValue", newValue);
    },
    
    // Map valueToDisplay and mapDisplayToValue need to pick up
    // the mapping between displayField and valueField, if there is one.
    // We implement this by overriding _mapKey() / mapDisplayToValue() to check for the value in
    // our pickList's dataSet, in addition to checking against any explicitly specified valueMap
    
    
    _mapKey : function (value, dontReturnKey, a,b,c,d) {
        var displayValue = this.invokeSuper(isc.ComboBoxItem, "_mapKey", value, true ,a,b,c,d);

        // _translateFieldValue part of the pickList interface
        if (displayValue == null && this.getDisplayFieldName() != null) 
            displayValue = this._translateValueFieldValue(value, false);
        if (displayValue == null && !dontReturnKey) displayValue = value;            
        return displayValue;
    },

    
    mapDisplayToValue : function (value, a, b, c) {
        if (this.getDisplayFieldName() != null) {
            var displayValue;
            displayValue = this._translateValueFieldValue(value, true);
            if (displayValue != null) value = displayValue;
        }
            
        return this.invokeSuper(isc.ComboBoxItem, "mapDisplayToValue", value, a,b,c);
    }
});


isc.ComboBoxItem.registerStringMethods({
    dataArrived:"startRow,endRow,data"
});
