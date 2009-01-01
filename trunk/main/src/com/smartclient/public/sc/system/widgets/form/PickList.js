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

  
// Class will not work without the ListGrid
if (isc.ListGrid) {



//>	@interface  PickList
// Interface to show a drop-down list of pickable options. Used by the +link{SelectItem} and
// +link{ComboBoxItem} classes.
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
//<

isc.ClassFactory.defineInterface("PickList");

//>	@class PickListMenu
// Subclass of ScrollingMenu to be used by the pickList class
//  @treeLocation Client Reference/Forms/Form Items
// @visibility internal
//<

isc.ClassFactory.defineClass("PickListMenu", "ScrollingMenu");

isc.PickListMenu.addClassProperties({
    // object to hold cached pickListMenu instances for databound pickList items
    _cachedDSPickLists:{},
    // Don't cache more than 50 DS pickListMenus    
    pickListCacheLimit:50
});

isc.PickListMenu.addProperties({            
    // Don't get fields from the DS.
    useAllDataSourceFields:false,
    
    // disallow tabbing to the pickList
    tabIndex:-1,
    
    // Don't allow fields to be resized, if multiple are showing
    
    canResizeFields:false,
    // Since we don't support drag resize of fields, turn canFreezeFields off by default
    canFreezeFields:false,

    styleName:"pickListMenu",
    bodyStyleName:"pickListMenuBody"
    
});

isc.PickListMenu.addMethods({
    // Pick up valueIcons from this form item, if specified
    getValueIcon : function (field, value, record) {
        var formItem = this.formItem;

        // If this is a databound pickList, we have 2 sets of valueIcons to consider - 
        // those specified by the formItem and those specified on the field definition itself.
        // - If the form item specifies any valueIcons, we typically want to show them on the 
        //   column that matches the display-value for the formItem.
        //   - This will be the result of formItem.getDisplayField() or formItem.getValueField()
        // - If the developer specified explicit pickListFields for this item, this field may
        //   not be showing. In this case we allow the developer to explicitly specify a 
        //   field to show the form item valueIcons via the property "formItem.valueIconField".
        //   If this property is set, always respect it.
        // - For all other fields, and if the form item has no custom valueIcons, just fall
        //   through to the standard ListGrid implementation, so we can pick up valueIcons
        //   specified on the datasource fields.
        var hasCustomValueIcons = formItem && !formItem.suppressValueIcons &&
                                  (formItem.valueIcons != null || formItem.getValueIcon !=null);
        
        if (hasCustomValueIcons) {
            var valueField = formItem.getValueFieldName(),
                valueIconField = formItem.valueIconField || 
                                 formItem.getDisplayFieldName() || valueField;
            if (this.getFieldName(field) == valueIconField) {
                // The form item expects the value passed to getValueIcon to be the 'valueField' 
                // value, not the value from whatever field is being displayed in the pickList
                return formItem._getValueIcon(record[valueField]);
            }
        }
        
        return this.Super("getValueIcon", arguments);
    },

    // 'pick' the selected value on click.  Matches Windows ComboBox behavior
    itemClick : function (record) {
        var formItem = this.formItem,
            fieldName = formItem.getValueFieldName(),
            value = record[fieldName];
        formItem.pickValue(value);
    },

    hide : function (a,b,c,d) {         
        this.invokeSuper(isc.PickListMenu, "hide", a,b,c,d);        
        // If we're being hidden as part of a formItem.destroy(), this.formItem will have been 
        // cleared out.
        if (!this.formItem) return;
        
        // put focus back in the item if this was a modal pickList 	 
        if (this.showModal) this.formItem.focusInItem();
                 
        // Clear out the showingPickList flag
        this.formItem._showingPickList = null;                 
        
        // fire a notification for observing / overriding the pick list being hidden
        this.formItem._pickListHidden();
        
        
        delete this.formItem._showOnFilter;
                            
    },

    show : function () {
        // If the pickListis already showing we could arguably bail here, but this isn't
        // how Canvas.show() behaves (still calls 'setVisibility()')...
        // Instead we'll just avoid firing the _pickListShown notification function 
        var alreadyShowing = this.isVisible() && this.isDrawn();
        
        
        this.bringToFront();
        this.Super("show", arguments);
        // fire a notification for observing / overriding the pick list being shown                    
        if (!alreadyShowing) this.formItem._pickListShown();
    },

    // Override showClickMask() - if this is a modal PickList, ensure that when the pickList is
    // hidden focus goes to the form item that spawned the pickList.    
    showClickMask : function () {
        if (!this.clickMaskUp(this.getID())) {
            // Actually cmID will match this.getID() since that's the default ID for a CM
            // associated with a widget.
            var cmID = this.Super("showClickMask", arguments);
            if (this.formItem) {
                var form = this.formItem.form,
                    mask = isc.EH.clickMaskRegistry.find("ID", cmID);
    
                // Suppress the default behavior of putting focus into whatever had focus before
                // this CM was shown. We'll explicitly put focus into the appropraite item when
                // hiding the pickList
                if (mask._maskedFocusCanvas) mask._maskedFocusCanvas = null;
            }
        }
    },
    
    _$_backgroundColor:"background-color:",
    _$_color:"color:",
    getCellCSSText : function (record, rowNum, colNum) {
        
        // if it's selected apply the hilite color, if specified
        // Otherwise we rely on regular css class type styling.
        if (record == this.selection.getSelectedRecord()) {
            var cssText = [];
            if (this.hiliteColor != null) 
                cssText[0] = this._$_backgroundColor
                cssText[1] = this.hiliteColor 
                cssText[2] = isc._semi;
            
            if (this.hiliteTextColor != null) 
                cssText[3] = this._$_color;
                cssText[4] = this.hiliteTextColor;
                cssText[5] = isc.semi;
            return cssText.join(isc.emptyString);
        }
    },
            
    // override keyDown to catch tabs and hide the pickList.
    
    
    keyDown : function () {
        var keyName = isc.EH.lastEvent.keyName;
        if (keyName == "Tab") {
            this.hide();
            return false;
        }
    },
            
    // Override _formatCellValue to call formatPickListValue() if defined (allowing for customized
    // formatting within the pickList).
    
    _formatCellValue : function (value, record, field, rowNum, colNum) {
        if (this.formItem.formatPickListValue) {
            var fieldName = this.getFieldName(colNum);
            value = this.formItem.formatPickListValue(value, fieldName, record);
        }
        return this.Super("_formatCellValue", [value,record,field,rowNum,colNum]);
    },
    
    // override keyPress to allow for navigation to different items by typing
    // the first letter of the option.
    bodyKeyPress : function (event, eventInfo) {
        var keyName = isc.EH.lastEvent.keyName;
        // Catch shift+tab in safari in keyPress rather than keydown
        if (isc.Browser.isSafari) {
            if (keyName == "Tab") {
                this.hide();
                return false;
            }
        }

        var charVal = isc.EH.getKeyEventCharacterValue();
        if (charVal != null) {

            var data = this.formItem.getAllLocalOptions();
                  
            if (isc.isAn.Array(data) && data.length > 1) {
    
                var typedChar = String.fromCharCode(charVal),
                    // Normalize to a lowercase string for comparison.
                    typedChar = typedChar.toLowerCase(),
                    formItem = this.formItem,
                    valueField = formItem.getValueFieldName(),
                    currentIndex = data.indexOf(this.getSelectedRecord()),
                    newIndex = currentIndex < (data.length -1) ? currentIndex + 1 : 0;
                if (currentIndex < 0) currentIndex = 0;
                    
                while (newIndex != currentIndex) {
                    var value = data[newIndex][valueField];
                    value = formItem.mapValueToDisplay(value);
                    if (isc.isA.String(value) && value.length > 0 && 
                        value.charAt(0).toLowerCase() == typedChar) {
                            this.scrollRecordIntoView(newIndex);
                            this._hiliteRecord(newIndex);
                            return;
                    }
                    newIndex += 1;
                    if (newIndex >= data.length) newIndex = 0;
                }
            }
        }

        // If the "Enter" key was pressed, but no record was selected, dismiss the menu
        // (this is really useful for the ComboBox item when showAllRecords is true and
        // the user has entered a value that isn't in the c-box).
        if (this.getFocusRow() == null && keyName == "Enter") {
            this.cancel();
            return false;
        } 
        
        // The superclass implementation will handle cancelling on escape click / selecting
        // on enter click
        return this.Super("bodyKeyPress", arguments);
    },

    
    // Override dataChanged -- avoid redrawing to show temp. loading rows - wait
    // for the rows to come back from the server instead.
    dataChanged : function () {
        var data = this.data;
        if (!data) return;
        var data = this.requestVisibleRows();
        if (data && Array.isLoading(data[0])) {
            //this.logWarn("not redrawing since data still loading");
            return;
        }        
        return this.Super("dataChanged", arguments);
    }
    
});


isc.PickList.addInterfaceProperties({
    
    //> @attr PickList.pickListHeight (number : 300 : IRW)
    // Maximum height to show the pick list before it starts to scroll.
    // Note that by default the pickList will be sized to the height required by its content
    // so it will be taller when more rows are available as selectable options
    // @visibility external
    //<
    pickListHeight:300,
    
    //> @attr PickList.emptyPickListHeight (number : 100 : IRW)
    // Height for an empty pick list (showing the empty message), if the pick list has no
    // records and +link{PickList.hideEmptyPickList} is <code>false</code>.
    // @visibility external
    //<
    emptyPickListHeight:100,
    
    //> @attr PickList.emptyPickListMessage (string : null : IRWA)
    // Empty message to display in the pickList if 
    // +link{PickList.hideEmptyPickList} is <code>false</code>. 
    // @visibility external
    //<
    //emptyPickListMessage:null,
    
    //> @attr PickList.hideEmptyPickList (boolean : null : IRW)
    // If this pickList contains no options, should it be hidden?
    // If unset, default behavior is to allow the empty pickList to show if it is databound.
    // @visibility external
    //<
    //hideEmptyPickList:null,

    //> @attr PickList.pickListWidth (number : null : IRW)
    // Default width to show the pickList.
    // If not specified, the width of this form item's element will be used instead.
    // @visibility external
    // @example listComboBox
    //<
    //pickListWidth : null,

    // Styling.
    // Users must be able to style pickLists
    
    //> @attr    PickList.pickListBaseStyle (string : "pickListCell" : IR)
    // Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected'
    // and 'disabled' appended on changes of state for the cells.
    // @visibility external
    //<
    pickListBaseStyle : "pickListCell",

    //> @attr    PickList.pickListHiliteColor  (string : null : IR)
    // If specified this color will be applied to hilighted rows in the pickList, when the
    // user rolls over them.  This color will be applied on top of the "over" CSS Style 
    // specified by <code>pickListBaseStyle</code>
    //<
    //pickListHiliteColor:null,
    
    //> @attr    PickList.pickListHiliteTextColor  (string : null : IR)
    // If specified this color will be applied to the text of hilighted rows in the pickList, 
    // when the user rolls over them.  This color will be applied on top of the "over" CSS Style 
    // specified by <code>pickListBaseStyle</code>
    //<
    //pickListHiliteTextColor:null,

    // autoSizePickList
    // If true the pick list will expand horizontally to accomodate its widest item.
    // Not supported for databound lists (since the items load incrementally)
    //autoSizePickList : false,
   
    //>Animation 
    //> @attr PickList.animatePickList (boolean : null : IRWA)
    // If true, when the pickList is shown, it will be shown via an animated reveal effect
    // @visibility animation
    //<
    
    //> @attr PickList.animationTime (number : 200 : IRWA)
    // If this.animatePickList is true - this specifies the duration of the animation effect
    // applied when showing the pickList
    // @visibility animation
    //<
    pickListAnimationTime:200,
    //<Animation
    
    //> @attr PickList.fetchDelay (number : 200 : IRWA)
    // Delay in ms between a call to fetch the data for this picklist and kicking the call off
    // to the server.  Only applies to databound pickLists. If multiple fetch calls are made
    // made within this fetch delay, only the most recent fetch will actually be sent to the
    // server
    //<
    fetchDelay:200,
    
    //>@attr PickList.pickListCellHeight (number : 16 : IRW)
    // Cell Height for this item's pickList.
    //<
    pickListCellHeight:16,
    
    // Allow low-level overriding of pickList properties
    //> @attr    PickList.pickListProperties (object : null : IR)
    // If specified this properties block will be applied to the pickList created for this
    // Form Item.
    // @visibility external
    //<
    //pickListProperties : null,
    
    //> @attr PickList.pickListHeaderHeight (number : 22 : IRW) 
    // If this pick list is showing multiple fields, this property determines the height of
    // the column headers for those fields. Set to zero to suppress the headers entirely.
    // @see pickListFields
    // @visibility external
    //<
    pickListHeaderHeight:22

    // --------------------------------------------------------------------------------------
    // Data / databinding
    
    //> @attr    PickList.valueField  (string : null : IRA)
    // @include FormItem.valueField
    //<

    //> @attr   PickList.displayField   (string : null : IRW)
    // @include FormItem.displayField
    //<


    //> @attr    PickList.pickListFields (Array : null : IRA)
    // This property allows the developer to specify which field[s] will be displayed in the 
    // drop down list of options.
    // <P>
    // Only applies to databound pickLists (see +link{PickList.optionDataSource}, or picklists
    // with custom data set up via the advanced +link{pickList.getClientPickListData()} method.
    // <P>
    // If this property is unset, we display the +link{PickList.displayField}, if specified, 
    // otherwise the +link{PickList.valueField}
    // <P>
    // If there are multiple fields, column headers will be shown for each field, the
    // height of which can be customized via the +link{pickList.pickListHeaderHeight} attribute.
    // <P>
    // Each field to display should be specified as a +link{ListGridField} object. Note that
    // unlike in +link{ListGrid,listGrids}, dataSource fields marked as 
    // +link{DataSourceField.display,display:true} will not be hidden by default in pickLists. To
    // override this behavior, ensure that you specify an explicit value for 
    // +link{ListGridField.showIf,showIf}
    // 
    //  @see valueField
    //  @see pickList.pickListHeaderHeight
    //  @visibility external
    //<
    
    //> @attr   PickList.valueIconField (string : null : IRWA) 
    // For Databound formItems, this property determines which column 
    // +link{formItem.valueIcons} should show up in for this formItem's pickList.<br>
    // If unset valueIcons show up in the +link{pickList.displayField} column if specified, 
    // otherwise the +link{pickList.valueField} column.<br>
    // In most cases only the <code>displayField</code> or <code>valueField</code> will be visible.
    // This property is typically only required if custom +link{PickList.pickListFields} 
    // have been specfied for this item. 
    // @see FormItem.valueIcons
    // @see PickList.pickListFields
    // @visibility external
    //<
    
    //> @attr   PickList.pickListCriteria (Criteria : null : IRWA)
    // If this item has a databound pick-list (for example +link{PickList.optionDataSource} is
    // set) this property can be used to provide static filter criteria when retrieving the data
    // for the pickList.
    // @visibility external
    //<
    
    //> @attr PickList.optionDataSource        (DataSource | String : null : IRA)
	// If set, this FormItem will derive data to show in the PickList by fetching records from
    // the specified <code>optionDataSource</code>.  The fetched data will be used as a
    // +link{formItem.valueMap,valueMap} by extracting the
    // +link{formItem.valueField,valueField} and +link{formItem.displayField,displayField} in
    // the loaded records, to derive one valueMap entry per record loaded from the
    // optionDataSource.  Multiple fields from the fetched data may be shown in the pickList by
    // setting +link{pickListFields}.
    // <P>
    // The data will be retrieved via a "fetch" operation on the DataSource, passing the 
    // +link{PickList.pickListCriteria} (if set) as criteria, and passing
    // +link{optionFilterContext} (if set) as DSRequest properties.
    // <P>
    // The fetch will be triggered when the pickList is first shown, or, you can set
    // +link{SelectItem.autoFetchData,autoFetchData:true} to fetch when the FormItem is
    // first drawn.  You can also call +link{PickList.fetchData()} at any time to manually 
    // trigger a fetch.
    // <P>
    // Data paging is automatically enabled if the optionDataSource supports it.  As the
    // pickList is scrolled by the user, requests for additional data will be automatically
    // issued.
    // <P>
    // For a pickList attached to a ComboBoxItem, new fetches are issued as the user types,
    // with criteria set as described under +link{comboBoxItem.getPickListFilterCriteria()}.
    // If your dataSource is not capable of filtering results by search criteria (eg the
    // dataSource is backed by an XML flat file), you can set +link{filterLocally} to have the
    // entire dataset loaded up front and filtering performed in the browser.  This disables
    // data paging.
    // <P>
    // Setting optionDataSource also enables the basic +link{FormItem.optionDataSource}
    // behaviors, eg, fetching individual display values before the pickList is shown.
    // <P>
    // Note that if a normal, static +link{formItem.valueMap,valueMap} is <b>also</b> specified
    // for the field (either directly in the form item or as part of the field definition in
    // the dataSource), it will be preferred to the data derived from the optionDataSource for
    // whatever mappings are present.
    //
    // @visibility external
    //<

    //> @attr PickList.showOptionsFromDataSource  (boolean : null : IRWA)
    // If this item is part of a databound form, and has a specified <code>valueMap</code>
    // by default we show the valueMap options in the pickList for the item.
    // Setting this property to true will ensure that the options displayed in our pickList
    // are derived from the form's <code>dataSource</code>.
    // @group databinding
    // @visibility external
    //<
    
        
    //> @attr PickList.optionFilterContext     (RPCRequest Properties : null : IRA)
    // If this item has a specified <code>optionDataSource</code>, and this property is
    // not null, this will be passed to the datasource as +link{rpcRequest} properties when
    // performing the filter operation on the dataSource to obtain the set of options for the
    // list.
    // @visibility external
    //<
    // This gives the developer the option of specifying (for example) an operation name.
    
    //> @attr   PickList.filterLocally  (boolean : false : IRA) 
    // If <code>filterLocally</code> is set for this item, and this item is showing options 
    // from a dataSource, fetch the entire set of options from the server, and use these values
    // to map the item value to the appropriate display value. Also use <code>"local"</code>
    // type filtering on drop down list of options.<br>
    // This means data will only be fetched once from the server, and then filtered on the
    // client.
    // @see FormItem.filterLocally
    // @visibility external
    //<
    
    //> @attr PickList.filterDisplayValue (boolean : null : IRA)
    // When performing the filter on the data displayed in the pickList, for valueMapped fields,
    // should the filter criteria be compared to the raw data values in the source list, or the
    // values mapped to display.
    // This setting only has an effect on non-databound pick lists
    // @visibility internal
    //<
    
    
});


isc.PickList.addInterfaceMethods({

    // showPickList
    // API to be called by the form item when the pickList is to be shown
    // Note that positioning of the pickList can should be set up by modifying 
    // getPickListPosition().
    // If 'waitForData' is passed, don't show the list until the filter completes.
    
    showPickList : function (waitForData, queueFetches) {
        // Set a flag to note that we've started to show the pickList.
        
        this._showingPickList = true;
        

        

        // Only pass in the param to show when the filter is complete if we're waiting for
        // data - otherwise we'll show the pickList explicitly (below).
        if (!this.pickList) this.makePickList(waitForData);
        // This will ensure the pickList is associated with this form item and set up its
        // data and fields.        
        
        else this.setUpPickList(waitForData, queueFetches);

        // call _showPickList to actually show the pickList.
        
        if (!waitForData && (!this.pickList.isDrawn() || !this.pickList.isVisible())) {
            this._showPickList();
        }
        
                
    },
    
    // Actually show the pick list. on the page.
    _showPickList : function () {
        // don't show the PL if it's got no data
        
        // also don't show if we're not drawn - this can happen if we're showing in response
        // to an asynch event like fetching data.
        var list = this.pickList;
        if (!this.isDrawn() || (this.shouldHideEmptyPickList() && list.getTotalRows() < 1)) {
            return;
        }

        // size and place the picklist
        this.placePickList();
        
        if (!list.isDrawn() || !list.isVisible()) {
            //>Animation
            // Show, or animate-show
            if (this.animatePickList) this.pickList.animateShow("wipe", null, this.pickListAnimationTime);
            else    //<Animation 
                this.pickList.show();
        }
    },
    
    //>@method  PickList.fetchData() 
    // Only applies to databound items (see +link{PickList.optionDataSource}).<br>
    // Performs a fetch type operation on this item's DataSource to retrieve the set of valid
    // options for the item, based on the current +link{PickList.pickListCriteria}.
    // @param callback (callback) Callback to fire when the fetch completes. Callback will 
    //              fire with 2 parameters: <code>item</code> a pointer to the form item and
    //              <code>dsResponse</code> the +link{dsResponse} returned by the server.
    // @param requestProperties (dsRequest properties) properties to apply to the
    //              dsRequest for this fetch.
    // @visibility external
    //<                         
    // @param maintainCache (boolean) By default when this method is called we drop any
    //            cached rows and re-fetch. Pass in this parameter to suppress this behavior.
    //            Note that if the fetch operation does not hit the server (which will occur
    //            if the data is already cached), the callback will not fire
    fetchData : function (callback, requestProperties, maintainCache) {    
        if (this.getOptionDataSource() == null) {
            this.logWarn("fetchData() called for a non-databound pickList. Ignoring");
            return;
        }

        // Store the callback passed in on the request's clientContext object.
        // This will be picked up as part of filterComplete()
        if (callback != null) {
            if (requestProperties == null) requestProperties = {};
            if (requestProperties.clientContext == null) requestProperties.clientContext = {};
            requestProperties.clientContext._callback = callback;
        }
        if (!this.pickList) this.makePickList(false, requestProperties);
        else this.filterDataBoundPickList(requestProperties, !maintainCache);
    },
    
    // Create the pickList for this widget.
    
    makePickList : function (show, request) {
        //>DEBUG
        var startTime = isc.timeStamp();
        //<DEBUG

        // Wherever possible, we reuse picklist menus across multiple items
        // If explicit pickListProperties have been specified for this item, use a uniqe
        // pickList instead - this avoids us having to correctly apply (and then clear) freeform 
        // properties to a shared pickList object
        // If we're databinding we cache picklists on a per-datasource basis.
        // If the datasource, and the specified set of fields match we reuse the list - otherwise
        // create a new one (rather than re-binding)
        var reusePickList = this.reusePickList();
        if (reusePickList) {
            this.pickList = this.getSharedPickList();            
        }
        
        // We have to build a new picklist if the global one doesn't exist, or if we're 
        // not sharing pickLists.
        if (!this.pickList) {
            // The pickList is a pickListMenu - subclass of ScrollingMenu with some 
            // overrides specific to form item pickLists.
            // The pattern we will use is to set the pickList up here, then override the
            // properties to allow us to reuse the list for other 
        
            // Determine desired properties from the various init params.
            var pickListProperties = this.pickListProperties;
            this.pickList = isc.PickListMenu.create(
                                // no need to set up showPickList - this is done with setFields
                                {headerHeight:this.pickListHeaderHeight,
                                 // Put in a 'handleDataArrived' method - this will always notify
                                 // the current form item when the pickList gets data back
                                 handleDataArrived : function (startRow,endRow,item) {
                                     if (this.formItem != null && !this.formItem.destroyed) {
                                         this.formItem.handleDataArrived(startRow,endRow,item);
                                     }
                                 }
                                }, 
                                pickListProperties
                            );

            // apply local fetchMode if 'filterLocally' was explicitly specified.
            var data = this.pickList.dataProperties || {};
            if (this.filterLocally) data.fetchMode = "local";
            // allow ourselves to be notified when data arrives within the pickList
            if (this.dataArrived) {
                data.dataArrived = new Function ("startRow", "endRow", "item",
                                          // if component is destroyed before data returns, we
                                          // would JS error, so in the callback check that the
                                          // component is still around before firing
                                          // dataArrived on it.
                                          "window."+this.pickList.getID()+"&&"+
                                          this.pickList.getID() +
                                          ".handleDataArrived(startRow,endRow,this)");
            }
               
            this.pickList.dataProperties = data;
            
            // If this is a shared pickList, store it in a publically accessible place
            if (reusePickList) this.storeSharedPickList();
        }

        // fire 'setUpPickList' to set up the specific properties relevant to this form item
        this.setUpPickList(show, false, request);
        //>DEBUG
        if (this.logIsInfoEnabled("timing"))
            this.logInfo("Time to initially create pickList:" + (isc.timeStamp() - startTime), "timing");
        //<DEBUG
    },

    // Can this item use a cached pickList menu instance?
    reusePickList : function () {    
        // we can reuse the pickList if the pickListProperties are null
        // For databound pickLists we create a cache of pickLists to reuse based on the
        // datasource ID and pickList fields
        // For client-only pickLists we have a single central reusable pickList.
        // "item.uniquePickList" - unexposed, but non obfuscated way to explicitly suppress pickList
        // caching for some item, if desired.
        return this.pickListProperties == null && !this.uniquePickList;
    },

    // Retrieves the cached pickList menu for an item
    getSharedPickList : function () {
        if (this._getOptionsFromDataSource()) {
            
            // Store pickList menus for databound pickLists on a per DS basis.
            // cache of lists looks like this
            // isc._cachedDSPickLists = {
            //  dataSourceID:[
            //      {_pickList:..., +fields:...}
            //  ]
            // }
            
            var ds = this.getOptionDataSource().getID(),
                cachedLists = isc.PickListMenu._cachedDSPickLists[ds];                
            if (cachedLists) {
                for (var i = 0; i < cachedLists.length;i++) {
                    if (cachedLists[i]._fields == this.pickListFields) {
                        // Note when we last used the pickList so we can
                        // destroy on a leastRecentlyUsed basis
                        cachedLists[i]._lastAccess = isc.timeStamp();
                        return cachedLists[i]._pickList;
                    }
                }
            }
            return null;    
        } else {
            return isc.PickList._pickListInstance;
        }
    }, 
    
    storeSharedPickList : function () {
        if (this._getOptionsFromDataSource()) {
            
            var ds = this.getOptionDataSource().getID(),
                cachedLists = isc.PickListMenu._cachedDSPickLists;
            if (!cachedLists[ds]) cachedLists[ds] = [];

            var newMenu = {_pickList:this.pickList, _fields:this.pickListFields,
                                 _lastAccess:isc.timeStamp()}
            cachedLists[ds].add(newMenu);
             if (isc.PickListMenu._DSPickListCacheSize == null) {
                 isc.PickListMenu._DSPickListCacheSize = 1;
             } else {
                 isc.PickListMenu._DSPickListCacheSize += 1;
                 if (isc.PickListMenu._DSPickListCacheSize > isc.PickListMenu.pickListCacheLimit) {
                     // If we've exceeded our pickListCacheLimit, destroy a pickList to make room
                     // for the new one.
                     // We store last access timestamps on each pickList we create so we
                     // can destroy them in a least-recently-used order.
                      
                     var oldMenu, ts = isc.timeStamp();
                     for (var ds in cachedLists) {
                         var dsLists = cachedLists[ds];
                         for (var i = 0; i < dsLists.length; i++) {
                             var entry = dsLists[i];
                             if (entry._lastAccess <= ts && (entry != newMenu)) {
                                 oldMenu = entry;
                                 ts = entry._lastAccess;
                             }
                         }
                     }
                     if (oldMenu) {
                         isc.PickListMenu._DSPickListCacheSize -= 1;
                         var pickList = oldMenu._pickList;
                         
                         var dsLists = cachedLists[pickList.getDataSource().getID()];
                         dsLists.remove(oldMenu);                         
                         if (pickList._formItems != null) {                             
                             for (var formItem in pickList._formItems) {
                                 if (window[formItem] && window[formItem].pickList == pickList) 
                                     delete window[formItem].pickList
                             }
                         }
                         // destroy on a delay so it doesn't slow this method down
                         oldMenu._pickList.delayCall("destroy");
                         
                     }
                     
                 }
             }
            
        } else {
            isc.PickList._pickListInstance = this.pickList;
        }
    },
    
    getPickListCellHeight : function () {
        var cellHeight = this.pickListCellHeight;
        if (this.valueicons != null || this.getValueIcon != null) {
            var valueIconHeight = this.getValueIconHeight();
            if (valueIconHeight > cellHeight) cellHeight = valueIconHeight;
        }
        return cellHeight;
    },
    
    // Set Up Pick List - apply properties to the pickList to link it to this form item.
    // Called every time the pick-list is shown.
    // For form items that re-use the same pickList this method must set properties connecting
    // the pickList to this form item.
    // Otherwise simply ensure the displayed set of data is up to date.
   setUpPickList : function (show, queueFetches, request) {
        var pickList = this.pickList;
       
        
        var cellHeight = this.pickListCellHeight;
        pickList.setCellHeight(cellHeight);     
        
        // These methods both no-op if the pickList is already applied to this item
        // and already showing the correct set of fields
        this._applyPickListToItem();
        this.setUpPickListFields();
        
        // apply custom empty message if we have one - if not ensure orginal empty
        // message shows up rather than potentially picking up the empty message from
        // another pickList based item.
        if (!pickList.originalEmptyMessage) pickList.originalEmptyMessage = pickList.emptyMessage;
        pickList.emptyMessage = this.emptyPickListMessage || pickList.originalEmptyMessage;
        
        // always refilter
        
        
        this.filterPickList(show, queueFetches, request);
    }, 
    
    _applyPickListToItem : function () {
        var oldFormItem = this.pickList.formItem;    
        if (oldFormItem == this) return;
        
        // Determine desired properties from the various init params.
        var pickListProperties = this.pickListProperties || {};
        isc.addProperties(pickListProperties, {
            // Ensure there's a pointer back to the form item
            formItem:this,
            
            baseStyle:this.pickListBaseStyle,
            
            hiliteColor:this.pickListHiliteColor,
            hiliteTextColor:this.pickListHiliteTextColor,
            
            // Allow components to show the pickList as a modal list
            showModal:this.modalPickList,
            
            // Pass this.dateFormatter through to the pickList.
            // This will ensure that date type fields are displayed the same in the
            // pickList cells as in the text box for this item if a dateFormatter is specified
            dateFormatter:this.dateFormatter
        });

        this.pickList.setProperties(pickListProperties);
        
        // Keep track of every form item for which 'this.pickList' points to this pickList
        // Required for shared pickLists - allows us to clear up these pointers if the cached
        // pickList gets removed to make room for more lists in the cached
        
        if (!this.pickList._formItems) this.pickList._formItems = {};
        this.pickList._formItems[this.getID()] = true;

        // If we're re-using a pickList, clear it's observations on the previous form item
        // it was associated with.
        if (oldFormItem) {
            if (this.pickList.isObserving(oldFormItem.containerWidget, "hide")) {
                this.pickList.ignore(oldFormItem.containerWidget, "hide");
            }
            if (this.pickList.isObserving(oldFormItem.containerWidget, "clear")) {
                this.pickList.ignore(oldFormItem.containerWidget, "clear");
            }
        }


        // Clean up the pickList if the form goes away
        
        if (!this.pickList.isObserving(this.containerWidget, "hide")) {
            this.pickList.observe(this.containerWidget, "hide", "observer.hide();");
        }
        
        if (!this.pickList.isObserving(this.containerWidget, "clear")) {
            this.pickList.observe(this.containerWidget, "clear", 
                                                    "if(observer.isDrawn())observer.clear();");
        }
        
    },
    
    // ------------
    // Data Management
    // ------------
    
    //>@method pickList.getOptionDataSource()
    // Pick-lists can derive their data directly from a valueMap, or retrieve data from a 
    // dataSource to display as options.
    // 
    // This method will return the dataSource used to populate the pickList, or null if 
    // none specified (implies this list will derive its data from the valueMap for the item).
    // Default implementation  will return +link{pickList.optionDataSource} if specified,
    // otherwise if this is a field with a specified <code>foreignKey</code> in a databound
    // form, returns the dataSource for the <code>foreignKey</code>.
    // Otherwise picks up <code>this.form.dataSource</code> if set.
    //
    // @return (DataSource) DataSource to use for fetching options
    // @visibility external
    //<
    
    
    // getPickListFields() 
    getPickListFields : function () {
        // Allow the developer to specify a set of fields 
        // Only really has meaning if the select item is databound, where multiple fields are
        // available.  For databound lists properties such as valueMaps will be picked up from
        // the dataSource.
        if (this.pickListFields) return this.pickListFields;
        
        var displayField = this.getDisplayFieldName(),
            fieldObj;
        if (displayField != null) {
            fieldObj = {width:"*", name:displayField}
            fieldObj.formatCellValue = this._formatDisplayFieldCellValue

        } else {
            fieldObj = {width:"*", name:this.getValueFieldName(), 
                        // apply the same valueMap to this field so the display values show up
                        // correctly
                        
                        valueMap:this.getValueMap()
                       }
            // If an empty cell value is specified, apply it to the field as well so we show
            // empty options with the correct title.
            if (this.emptyDisplayValue != null) fieldObj.emptyCellValue = this.emptyDisplayValue;
        }
        // If we have an explicitly specified dateFormatter for this item, it will be passed to the
        // pickList but only respected for fields of type "date" there.
        // Assume this is what the user intended and default the type to "date" for the pickList
        // field. This'll be unnecessary if the dataSource field is already of type:"date" of
        // course.
        if (this.dateFormatter != null) {
            fieldObj.type = "date"
        }
        return [fieldObj]
    },
    
    // custom formatter for the display field - if the valueField is empty, show the empty
    // cell value (unless there's an explicit display field value for the record in question
    // in which case the "right" behavior is ambiguous)
    _formatDisplayFieldCellValue : function (value,record,rowNum,colNum,grid) {
        if (value != null) return value;
        var item = grid.formItem,
            valueField = item.getValueFieldName()
        if (record[valueField] == null) return item.emptyCellValue;
        return value;
    },
    
    //> @method  PickList.getPickListFilterCriteria()  (A)
    // Returns a set of filter criteria to be applied to the data displayed in the pickList when
    // it is shown.
    // <P>
    // If this is a databound item the criteria will be passed as criteria to
    // +link{dataSource.fetchData()}.  Otherwise an equivalent client-side filter will be
    // performed on the data returned by +link{getClientPickListData()}.
    // <P>
    // By default returns +link{pickList.pickListCriteria} if specified, otherwise an empty 
    // set of criteria so all records will be displayed.
    //
    // @return (Criteria) criteria to be used for databound or local filtering
    // @visibility external
    //<
    getPickListFilterCriteria : function () {
        return this.pickListCriteria || {};
    },

    // This is a helper method to return the set of 'local' options.
    // default implementation returns null for databound pickLists, or the array of values for
    // non databound picklists.
    // Used by logic to navigate around via keyboard
    // Overridden on the Select item to handle databound pickLists with all rows cached
    getAllLocalOptions : function () {
        return this._getOptionsFromDataSource() ? null : this.getClientPickListData();
    },
    
    //> @method PickList.getValueFieldName()
    // @include FormItem.getValueFieldName()
    //<
    
    // Display fields -----------------------------------------------------------------
    
    //> @method   pickList.getDisplayFieldName()
    // @include FormItem.getDisplayFieldName()
    //<
 
    
    // For databound items, an explicitly specified displayField means we'll be displaying
    // values from one field of our dataSource, and returning data values from a different field.
    // (Something like a valueMap using the resultSet from the server as a mapping object)
    // This helper method will perform the conversion between display and data values based
    // on the pickList's data set, if necessary.
    // Retriving the display value directly from the pickList dataSet often avoids us having to 
    // run the fetchMissingValues logic in setValue() whereby we perform a fetch against the
    // dataSource when setValue() is called
    // Note that in contrast if this is a freeform data entry type field (EG a combobox)
    // and the user enters a value that is not present in the data-set, it will be stored as
    // the data value for the item, even though the user is theoretically setting the
    // display value.
    // Form items that use the pickList interface will typically call this method from
    // mapValueToDisplay() and mapDisplayToValue()
    _translateValueFieldValue : function (value, toValueField) {
        // If we were not passed a defaultValue (value to return if no match was found),
        // return 
        // This method is only for use with databound pickLists.
        var ods = this.getOptionDataSource();
        if (ods == null) {
            
            return;
        }
        
        var resultSet = this.pickList && !this.pickList.destroyed ? this.pickList.data : null;
        if (!resultSet || !(resultSet.localData || resultSet.allRows)) return;
        
            
        var toField = (toValueField ? this.getValueFieldName() : this.getDisplayFieldName()),
            fromField = (toValueField ? this.getDisplayFieldName() : this.getValueFieldName());

        if (toField == fromField) return value;
        // If we have a complete cache use it - this enables us to map data values that don't
        // match the current filter criteria.
        var cache = resultSet.allRows || resultSet.localData,
            record = cache.find(fromField, value);
        if (record != null) return record[toField];
    },
    
    _$true:"true",
    setUpPickListFields : function () {
        var fields = this.getPickListFields(),
            currentFields = this.pickList.fields;
        
        // Verify that the fields are not already up to date. If so just bail.
        var fieldsChanged = !currentFields || (currentFields.length != fields.length);
        if (!fieldsChanged) {
            for (var i= 0; i < fields.length; i++) {
                var field = fields[i], plField = currentFields[i];
                for (var prop in field) {
                    if (field[prop] != plField[prop]) {
                        fieldsChanged = true;
                        break;
                    }
                }
                if (fieldsChanged) break;
            }
        }

        if (!fieldsChanged) return;
        
        // Ensure that all fields are visible by default. This avoids the gotcha where detail fields
        // would otherwise fail to show up in pickLists.
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].showIf == null) {
                fields[i].showIf = this._$true;
            }
        }
        
        // For the display field (which will display the valueIcons specified for this item)
        // pick up valueIcon sizing etc from this item unless it was explicitly overridden
        if (this.valueIcons != null || this.getValueIcon != null) {
            for (var i = 0; i < fields.length; i++) {
                var field = fields[i];
                if (field[this.form.fieldIdProperty] == this.getValueFieldName()) {
                    if (field.valueIconHeight == null) 
                        field.valueIconHeight = this.valueIconHeight;
                    if (field.valueIconWidth == null) 
                        field.valueIconWidth = this.valueIconWidth;
                    if (field.valueIconSize == null) 
                        field.valueIconSize = this.valueIconSize;
                    if (field.imageURLPrefix == null) 
                        field.imageURLPrefix = this.imageURLPrefix || this.baseURL || this.imgDir;
                    if (field.imageURLSuffix == null) 
                        field.imageURLSuffix = this.imageURLSuffix;
                }
            }
        }
        
        this.pickList.setFields(fields);

        // Show the header if there are multiple fields.
        if (fields.length > 1) {
            // we are likely to be sharing a pickList across items, each of which may have a
            // different header height, so reset each time the header is shown
            // (No ops if no change anyway)
            this.pickList.setHeaderHeight(this.pickListHeaderHeight);
            this.pickList.setShowHeader(true);
            this.pickList.fixedFieldWidths = true; // can't autoSize with a header
        } else {
            this.pickList.setShowHeader(false);
            // always set fixedFieldWidths in case we're reusing a pickList from another item
            // with different settings
            this.pickList.fixedFieldWidths = !this.autoSizePickList;
        }
    },
    
    // If we have an explicitly specified optionDataSource for the field, we will databind the
    // list to that dataSource.
    // Otherwise, we'll use the valueMap to get a set of client-only options if we have one
    // - or attempt to derive an optionDataSource if not.
    _getOptionsFromDataSource : function () {
        // explicit datasource
        if (this.optionDataSource) return true;
        // derived datasource [For Comboboxes this will be non-null if the field has a foreignKey]
        if ((this.showOptionsFromDataSource || !this.valueMap) && 
            this.getOptionDataSource() != null) return true;
        return false;
    },
    

    
    
    filterPickList : function (show, queueFetches, request) {
        if (!queueFetches) 
            this._filterPickList(show, request);
        else {
            this._showOnDelayedFilter = show;
            this.fireOnPause("fetch", 
                             {target:this, methodName:"_filterPickList", 
                              args:[null, request, true]}, 
                             this.fetchDelay);
        }        
    },
    
    _filterPickList : function (show, request, delayed) {
        if (delayed) show = this._showOnDelayedFilter;
        delete this._showOnDelayedFilter;
        this._showOnFilter = show;
        
        var useDS = this._getOptionsFromDataSource();        
        if (useDS) {
            var ds = this.getOptionDataSource();

            // Pass the (already set up) fields into the 'setDataSource' method.
            if (this.pickList.getDataSource() != ds) {
                this.pickList.setDataSource(ds, this.pickList.fields);
            }

            // Will fall through to filterComplete() when the filter op. returns.        
            this.filterDataBoundPickList(request);
        } else {
            // Ignore any requestProperties passed in for a client-only filter.
            
            var records = this.filterClientPickListData();
            
            if (this.pickList.data != records) this.pickList.setData(records);

            // explicitly fire filterComplete() as we have now filtered the data for the 
            // pickList
            this.filterComplete();
        }
        
        
    },
    
    // _pickListNeedsRefilter()
    // This method determines whether the pickList passed in has been filtered to match
    // this item's criteria.
    //
    // Used by getFirstOptionValue() and to avoid unnecessary refilters when the shared pickList is
    // assigned to different formItems
    // returns a boolean - true if a refilter will be required (pickList not showing data that will
    // match this item's option set).
    
    _pickListNeedsRefilter : function (pickList) {
        // Only applies to databound pickLists
        if (!this._getOptionsFromDataSource() || !pickList) return;

        var ds = this.getOptionDataSource();
        if (pickList.getDataSource() == ds && pickList.data) {
            var context = pickList.data.context,
                crit = pickList.data.criteria;
            if (context.textMatchStyle != this.textMatchStyle) return true;
            if (this.optionFilterContext != null) {
                for (var field in this.optionFilterContext) {
                    if (this.optionFilterContext[field] != context[field]) return true;
                }
            }
            // if criteria match we don't need a refilter
            if (ds.compareCriteria(crit,this.getPickListFilterCriteria(), context) == 0) {
                return false;
            }
        }
        return true;
    },
    
    // getFirstOptionValue - used by SelectItem / ComboBoxItem if defaultToFirstOption is true
    getFirstOptionValue : function () {
        
        var value;
        if (this._getOptionsFromDataSource()) {
            var pickList = this.pickList || 
                            (this.reusePickList() ? this.getSharedPickList() : null);
            if (pickList && !this._pickListNeedsRefilter(pickList)) {
                var record = pickList.data.get(0);
                
                // Don't attempt to default to the loading row marker. Note that handleDataArrived
                // already handles setting to the default value.
                if (record == null || Array.isLoading(record)) {
                    value = null;
                } else {
                    value = record[this.getValueFieldName()];
                }
            } else {
                // In this we don't yet have a pickList showing options that will
                // match this form item, so can't get our first optionValue.
                // Kick off a fetch. When it completes we'llhave a valid first option
                // Pass in the parameter to avoid dropping cache and forcing a server turnaround
                // (We may be able to refilter on the client if it's just a criteria change)
                
                this.fetchData(null,null,true);
            }
            
        } else {
            var map = this.valueMap;
            if (isc.isAn.Array(map)) value = map[0];
            else if (isc.isAn.Object(map)) {
                // use for...in to pick up first defined property on the object
                for (var field in map) {
                    value = field;
                    break;
                }
            }
        }
        return value;
    },
    
    //>@method pickList.getClientPickListData() [A]
    // Returns the set of data to be displayed in this item's PickList.
    // <P>
    // This method will be called for non-databound form items implementing the PickList
    // interface.  The default implementation will derive data from the item's valueMap - 
    // can be overridden to allow a custom set of options to be displayed.
    // <P>
    // Note that for PickLists that filter data based on user input
    // (+link{ComboBoxItem,ComboBox}), this method should return the data <b>before
    // filtering</b>.  To customize the data returned after filtering, override
    // +link{filterClientPickListData()} instead.
    // <P>
    // As an example, for a formItem with +link{valueField} set to "valueFieldName", the
    // default implementation would take a valueMap like the following:
    // <pre>
    //     valueMap: { value1: "display 1", value2: "display 2" }
    // </pre>
    // .. and returning the following set of records: 
    // <pre>
    //     [
    //          { valueFieldName : "value1" },
    //          { valueFieldName : "value2" }
    //     ]
    // </pre>
    // Due to the valueMap, these records will appear as a two row pickList displayed as
    // "display 1" and "display 2".
    //
    // @return (Array of ListGridRecord) Array of record objects to be displayed in the
    //           pickList. Note that when a user picks a record from the list, the value of the
    //           field matching <code>item.valueField</code> will be picked. Also note that the
    //           fields to be displayed can be customized via <code>item.pickListFields</code>
    //                  
    // @visibility external
    //<
    getClientPickListData : function () {
        return isc.PickList.optionsFromValueMap(this);
    },
    
    // Override point to notify the item that the pickList has been shown / hidden
    _pickListHidden : function () {
        if (this.pickListHidden) this.pickListHidden();
    },
    
    _pickListShown : function () {
        if (this.pickListShown) this.pickListShown();
    },

    // selectDefaultItem
    // When the pickList is initally shown / re-filtered update the selection.
    // For select items the current value will be selected.  
    // [Overridden by the comboBox class to always select the first record].
    
    selectDefaultItem : function () {
        // Select the value currently displayed in the form item
        return this.selectItemFromValue(this.getValue());        
    },
    
    selectItemFromValue : function (value) {
        // If the value is already selected we can just return. This is much quicker for most
        // cases since we don't have to iterate through the pickList data array
        var record = this.pickList.getSelectedRecord(),
            valueField = this.getValueFieldName();
        if (record && (record[valueField] == value)) return true;
        
        var data = this.pickList.getData(),
            dataSource = this._getOptionsFromDataSource() ? this.getOptionDataSource() : null;
        if (dataSource != null) {
            
            var cache = data.localData;
            if (cache) record = cache.find(valueField, value);
        } else {
            record = data.find(valueField, value);            
        }

        if (record) {
            this.pickList.selection.selectSingle(record);
            this.pickList.scrollRecordIntoView(data.indexOf(record));
        }
        // Return a boolean to indicate whether we successfully found and selected a record
        return (record != null)
    },

    
    // -- Data bound filtering --
    
    // filterComplete - callback fired when the data to be displayed has been filtered.
    // (Will be called for both databound and non-databound lists)
    filterComplete : function (response, data, request) {
        this._fetchingPickListData = false;
          
        var list = this.pickList;
        
        if (!list || list.destroyed) return;
        var data = list.getData();
		if (data.getLength() == 0 && list.isVisible()) {     
			// no matches, so hide the dropdown, place focus in the form item itself
            if (this.hideEmptyPickList) {
                list.hide();
                if (hasFocus) this.focusInItem();
            } else {
                list.setHeight(this.getPickListHeight());
            }
		} else {
            // if we set the flag to show the list after the filter, show it now!
            var hasFocus = list.hasFocus || (list.body && list.body.hasFocus);
            if (this._showOnFilter) this._showPickList();
            // If the list is already showing, call placePickList to ensure it resizes to
            // accomodate content if required.
            else if (list.isVisible() && list.isDrawn()) this.placePickList();
            
            delete this._showOnFilter;
        }
        
        // Always select the default item at this point since we have the latest data
        this.selectDefaultItem();
        
        // _checkDisplayFieldValueOnFilterComplete
        // This flag is set up by the ComboBox / SelectItem class as part of checkDisplayFieldValue
        // if a pickList filter operation is running while that method is called.
        // In this case we need to recheck now the pickList data has loaded.
        // If the pickList data loaded a display value for this fields value, we're done,
        // otherwise we need to perform another fetch
        if (this._checkDisplayFieldValueOnFilterComplete) {
            delete this._checkDisplayFieldValueOnFilterComplete;
            this._checkForDisplayFieldValue(this._value);
        } 
        
        // helper - if we're currently showing a data value and we just loaded the associated
        // display value, display it.
        this._updateDisplayValueForNewData();
        
        // If a callback was passed in when the filter was intialized, fire it now, passing in
        // the resultSet as a single parameter
        
        var callback = (request && request.clientContext ? request.clientContext._callback : null);
        if (callback) this.fireCallback(callback, "item,dsResponse", [this, response]);
    },
    
    // If this item has a databound pickList, and a 'displayField',
    // If the value has been set to some data value, which doesn't correspond
    // to a row loaded in the pickList, and we haven't mapped to a display value
    // (EG fetchMissingValues is false, etc), if the data does subsequently get loaded in 
    // the pickList, we want to update the element value to show the display value.
    // We do this in response to new data arriving for the pickList (a filter operation completes)
    
    _updateDisplayValueForNewData : function () {
        if (this.isDrawn() && this.getValueFieldName() != null 
            && this._getOptionsFromDataSource()) 
        {
            var currentVal;
            if (!this._itemValueIsDirty()) currentVal = this.getValue();
            else {
                if (this.isA("SelectItem")) currentVal = this._localValue;
                else currentVal = this.mapDisplayToValue(this.getElementValue());
            }
            // only update if we retrieved a record that matches the current value
            // This avoids us dropping a good display value when we lose it from the pickList cache
            var record = this.getSelectedRecord();
            if (record) {
                var displayVal = this.mapValueToDisplay(currentVal);
                
                if (this._displayValue != displayVal) this.setElementValue(displayVal);
            }
        }
    },
    
    // This will only be called on a databound pickList
    filterDataBoundPickList : function (requestProperties, dropCache) {
        var criteria = this.getPickListFilterCriteria(),
            context = {
                

                // NOTE: 2007.3.5 server does not actually support "startsWith" match style,
                // treats it as "substring"
                textMatchStyle:this.textMatchStyle,

                
                showPrompt:false
            };

        // this.optionFilterContext - an entry point to add properties to the operation context, such
        // as the name of a defined operation.
        if (this.optionFilterContext != null) isc.addProperties(context, this.optionFilterContext);

        // Additional properties to be applied to the request can be passed as a parameter.
        // This code path is used for the userVisible 'fetchData()' api
        if (requestProperties != null) {
            isc.addProperties(context, requestProperties);
        }
        
        
        var synchronousFilter = false;
        if (this.pickList.data && isc.ResultSet && isc.isA.ResultSet(this.pickList.data)) {
            if (dropCache) {
                // invalidateCache doesn't have a way to apply a callback.
                // Instead call '_invalidateCache' to drop the cache (without re-fetching)
                // Then continue with filterData() as normal
                this.pickList.data._invalidateCache();
            // Use 'willFetchData' to see if a fetch is required
            } else if (!this.pickList.data.willFetchData(criteria,this.textMatchStyle)) {
                synchronousFilter = true;
            }
            
        }
                    
        this.pickList.filterData(criteria, {target:this, methodName:"filterComplete"}, context);
        
        if (synchronousFilter) this.filterComplete();
        else this._fetchingPickListData = true;
    },

    // defaultToFirstOption: whenever new data arrives for the first row, default to it if 
    // our value is currently unset.
    handleDataArrived : function (startRow,endRow,data) {        
        if (this.defaultToFirstOption && this.getValue() == null && startRow == 0) {
            this.setToDefaultValue();
        }
        if (this.dataArrived) this.dataArrived(startRow,endRow,data);
    },
    //> @method PickList.dataArrived()
    // If this item is showing a dataBound pickList, this notification method will be fired 
    // when new data arrives from the server.
    // @param startRow (number) index of first row returned by the server
    // @param endRow (number) index of last row returned by the server
    // @param data (ResultSet) pointer this pickList's data
    // @visibility external
    //<
    dataArrived : function (startRow, endRow, data) {
    },
    
    // -- Client side filtering --
    
    //> @attr PickList.textMatchStyle (String : "startsWith" : IR)
    // When applying filter criteria to pickList data, what type of matching to use.  Legal
    // values are "substring" (value contains user input) or "startsWith" (value starts with
    // user input.  Both matches are case insensitive.
    // <P>
    // For a databound pickList (+link{optionDataSource} set), <code>textMatchStyle</code> is
    // sent to the server as +link{dsRequest.textMatchStyle}.
    // <P>
    // For a non-databound pickList, <code>textMatchStyle</code> is applied by 
    // +link{filterClientPickListData()}.
    //
    // @visibility external
    //<
    textMatchStyle : "startsWith",

    //>@attr PickList.showAllOptions (boolean : null : IR)
    // If true, even non-matching options will be shown, with configurable 
    // +link{separatorRows,separator rows} in between.  Not valid for
    // +link{optionDataSource,databound pickLists}.
    //
    // @visibility external
    //<

    //>@attr PickList.separatorRows (Array of ListGridRecord : [{isSeparator:true}] : IR)
    // Array of records to show between matching and non-matching rows in the PickList.
    // <P>
    // Not valid for +link{optionDataSource,databound pickLists}.
    //
    // @visibility external
    //<

    //>@method PickList.filterClientPickListData()
    // Returns the data to display in the pick list.
    // <P>
    // The default implementation applies the criteria returned by 
    // +link{PickList.getPickListFilterCriteria()} to the data returned by
    // +link{PickList.getClientPickListData()}.  A record passes the filter if it has a
    // matching value for all fields in the criteria object.  Matching is performed according
    // to +link{textMatchStyle}.
    // <P>
    // If +link{PickList.showAllOptions} is set, all values are shown, with matching values
    // shown below a +link{PickList.separatorRows,separator}.
    //
    // @return (Array of ListGridRecord) array of record objects to display in the pickList
    //
    // @visibility external
    //<
    _$substring : "substring",
    separatorRows : [{ isSeparator:true }],
    filterClientPickListData : function () {
        var data = this.getClientPickListData(),
            criteria = this.getPickListFilterCriteria();
        if (criteria == null || isc.isA.emptyObject(criteria)) return data;
        
        var matches = [],
            nonMatches;

        if (this.showAllOptions) nonMatches = this.separatorRows.duplicate();
        
        var validCriterion = false;
        for (var fieldName in criteria) {
            var searchString = criteria[fieldName];
            if (!searchString || isc.isA.emptyString(searchString)) continue;

            validCriterion = true;
            
            // Do a raw conversion to strings if passed non string values
            
            if (!isc.isA.String(searchString)) searchString += isc.emptyString;
            
            searchString = searchString.toLowerCase();
            
            var dataLength = data.getLength(),
                valueFieldName = this.getValueFieldName();
            for (var i = 0; i < dataLength; i++) {
                var possibleMatch = data[i][fieldName];
                // for the valueField, run the record values through mapValueToDisplay() so
                // they match what the users sees.  XXX running through the valueMap is
                // appropriate here, but a formatter that returns HTML may screw this up
                if (this.filterDisplayValue && fieldName == valueFieldName) {
                    possibleMatch = this.mapValueToDisplay(possibleMatch);
                }
                
                // For now we'll do a stringwise comparison regardless of the data type of
                // the possible match
                if (!isc.isA.String(possibleMatch)) possibleMatch += "";
            
                possibleMatch = possibleMatch.toLowerCase();
                
                // Remove any mismatches from the list of options
                if ((this.textMatchStyle == this._$substring &&
                     !possibleMatch.contains(searchString)) ||
                    (this.textMatchStyle != this._$substring && // assume startsWith
                     !isc.startsWith(possibleMatch, searchString))) 
                {
                    if (this.showAllOptions) nonMatches.add(data[i]);
                } else {
                    matches.add(data[i]);
                }
            }
        }
        
        if (!validCriterion) matches = data.duplicate();
        if (this.showAllOptions && nonMatches.length > 1) matches.addList(nonMatches);
        //this.logWarn("returning: " + this.echoAll(matches));
        return matches;
    },
        
    
    // --------------------------------------------------------------------------------------
    // PickList appearance
    // --------------------------------------------------------------------------------------
    

    // hide empty pickLists?
    shouldHideEmptyPickList : function () {   
        if (this.hideEmptyPickList != null) return this.hideEmptyPickList;
        return !this._getOptionsFromDataSource();
    },    

    // Position / sizing

    // getPickListPosition;
    getPickListPosition : function () {
        return [this.getPageLeft(), this.getPageTop() + this.getHeight()];
    },
    
    // getPickListHeight - returns the desired height of the pickList based on the number of
    // records and the specified pickListHeight
    getPickListHeight : function () {
        var maxHeight = this.pickListHeight,
            pickList = this.pickList,
            numRows = pickList.getTotalRows();
        
        // Have a constant size for the empty message if we're showing it
        if (numRows == 0) return this.emptyPickListHeight;
        
        var cellHeight = pickList.cellHeight,
            headerHeight = (pickList.showHeader ? pickList.headerHeight : 0),
            recordsHeight = numRows * cellHeight,
            bodyBorderPad = (pickList.body ? pickList.body.getVBorderPad() :
                             isc.Element._getVBorderPad(pickList.bodyStyleName)),
            requiredHeight = recordsHeight + headerHeight + pickList.getVBorderPad() +
                                bodyBorderPad;

        
        return Math.min(requiredHeight, maxHeight);
    },
    
    _sizePickList : function (minWidth, height, vscrollOn) {

        var pickList = this.pickList,
            newWidth = minWidth;

        // to determine whether to autoSize, check fixedFieldWidths, since if we're showing a
        // header we never autoSize since headers currently can't automatically size to match
        // column sizes.
        if (pickList.fixedFieldWidths) {
            //this.logWarn("not autoSizing pickList: fieldWidths: " + pickList.fixedFieldWidths +
            //             " body: " + pickList.body);
            pickList.resizeTo(newWidth, height);
            return;
        }

        // Autosize list to fit widest option.
        
    
        

        // if this is called before the pickList has drawn, use the pickList as a whole for
        // scrollbar size rather than the body.  Technically wrong, as they could theoretically
        // have different scrollbar sizes, but self-correcting on any subsequent show().
        var scrollSource = pickList.body || pickList,
            scrollbarSize = (vscrollOn ? scrollSource.getScrollbarSize() : 0);

        if (pickList.body) {
            pickList.body.setOverflow(isc.Canvas.HIDDEN);
        } else {
            pickList.bodyOverflow = isc.Canvas.HIDDEN;
        }

        // avoid space being left for a vscrollbar
        var oldSetting = pickList.leaveScrollbarGap;
        pickList.setProperties({leaveScrollbarGap:false});

        // set minimum size
        
        pickList.resizeTo(minWidth - scrollbarSize, height);

        // draw/redraw and get new size
        if (!pickList.isDrawn()) {
            // ensure we don't show the pickList as a consequence of auto-sizing
            pickList.visibility = isc.Canvas.HIDDEN;
            pickList.draw();
        } else if (pickList.body.isDirty()) {
            pickList.body.redraw("pickList sizing");
        }
        var scrollWidth = pickList.body.getScrollWidth(),
            bodyBorderPad = (pickList.body ? pickList.body.getHBorderPad() :
                             isc.Element._getHBorderPad(pickList.bodyStyleName)),
            drawnWidth = scrollWidth + scrollbarSize +
                         pickList.getHBorderPad() +
                         bodyBorderPad;

        // restore scrolling settings
        pickList.setProperties({leaveScrollbarGap:oldSetting});
         
        if (this.logIsDebugEnabled("sizing")) {
            this.logDebug("pickList auto-sizing: minWidth : " + minWidth + 
                          (vscrollOn ? ", vscrollOn" : "") + 
                          ", width for columns: " + (minWidth - scrollbarSize) + 
                          ", scrollWidth: " + scrollWidth + 
                          ", drawnWidth: " + drawnWidth +
                          ", borderPad: " + pickList.getHBorderPad(),
                          "sizing");
        }
    
        pickList.setWidth(Math.max(drawnWidth, minWidth));
        pickList.body.setOverflow(isc.Canvas.AUTO);
    },

    // placePickList: Called when the pick list is about to be shown. This sets the position
    // in the page scope (Page-level coords)
    placePickList : function () {
    
        var pickList = this.pickList,
            position = this.getPickListPosition(),
            left = position[0], top = position[1],
            height = this.getPickListHeight(),
            // If we're drawing at max height, it indicates we'll be scrolling
            willVScroll = (height == this.pickListHeight);

        // if we won't be vertically scrolling, don't leave a gap for a vertical scrollbar;
        // take all the space
        if (!willVScroll) {
            pickList.setProperties({leaveScrollbarGap:false});
        } else {
            pickList.setProperties({leaveScrollbarGap:true});
        }

        this._sizePickList(this.pickListWidth != null ? this.pickListWidth 
                                                      : this.getElementWidth(), 
                           height, (height == this.pickListHeight)  
                          );
        // Note: using placeNear will keep the pickList onscreen if possible.
        // For selectItems we also specifically override getPickListPosition to try to keep the 
        // pickList onscreen without obscuring the select item body by placing above the item
        // if necessary... for other items using the pickList interface, this placeNear will
        // just position the pickList as close to the specified position as possible.
        pickList.placeNear(left, top);
    },

    //> @method PickList.getSelectedRecord()
    // Returns the entire record object associated with the current value for this item
    // (or null if no matching record exists in the PickList data).<br>
    // Most commonly used for databound pickListItems to retrieve the values of other fields
    // in the record
    //
    // @return (object) record object
    // @visibility external
    //<
    getSelectedRecord : function () {
        if (this.pickList == null || this.pickList.destroyed) this.makePickList(false);
        
        // We can't just say this.pickList.getSelectedRecord(), since the
        // value may not have been picked from a pickListClick -- instead force a selection
        // that matches our item value then retrieve the selected value.
        if (this.selectItemFromValue(this.getValue())) return this.pickList.getSelectedRecord();
        return null;
    },
    
    // pickValue
    // This method is fired when a value is selected from the pick list.
    // Implementation will vary depending on the form item to which it is applied
    pickValue : function (value) {}
    
});

// add some static methods to handle default data-management.
isc.PickList.addClassMethods({

    // optionsFromValueMap()
    // Method to determine set of data to display in the pickList based on the valueMap of
    // a (non databound) pickList item.
    
    optionsFromValueMap : function (item) {
        var valueMap = item.getValueMap(),
            records = [];
            
        if (valueMap == null) valueMap = [];
        
        // We have to turn the valueMap into an array of record type objects.
        var valueField = item.getValueFieldName();
        
        if (isc.isAn.Array(valueMap)) {
            for (var i = 0; i < valueMap.length; i++) {
                records[i] = {}
                records[i][valueField] = valueMap[i];
            }

        } else if (isc.isAn.Object(valueMap)) {
            var i = 0;
            for (var j in valueMap) {
                records[i] = {};
                records[i][valueField] = j;
                i++;
            }
        }

        return records;
    }
});

}
