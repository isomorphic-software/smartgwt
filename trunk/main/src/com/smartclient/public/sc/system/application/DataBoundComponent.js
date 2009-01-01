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

 



//> @interface DataBoundComponent
// A DataBoundComponent is a widget that can configure itself for viewing or editing objects which
// share a certain schema by "binding" to the schema for that object (called a "DataSource").
// <P>
// A schema (or DataSource) describes an object as consisting of a set of properties (or
// "fields").
// <P>
// DataBoundComponents have a +link{dataBoundComponent.dataSource,common set of APIs} for
// dealing with binding to DataSources, 
// +link{dataBoundComponent.fields,overriding or augmenting} the schema information
// provided by a DataSource, and manipulating objects or sets of object from the DataSource.
// <P>
// The following visual components currently support databinding:<pre>
//   +link{class:DynamicForm}
//   +link{class:DetailViewer}
//   +link{class:ListGrid}
//   +link{class:TreeGrid}
//   +link{class:TileGrid}
//   +link{class:ColumnTree}
//   +link{class:CubeGrid}
// </pre>
// The following non-visual components also support databinding:<pre>
//   +link{class:ValuesManager}
//   +link{class:ResultSet}
//   +link{class:ResultTree}
// </pre>
//
// @treeLocation Client Reference/Data Binding
// @visibility external
//<
// Currently the DataBinding APIs are present on all Canvii.
// Documented as a separate, intervening class, to separate functionality (DataBoundComponent) 

isc.Canvas.addProperties({


//>	@attr dataBoundComponent.dataSource		(DataSource or ID : null : IRW)
// The DataSource that this component should bind to for default fields and for performing
// +link{DSRequest,DataSource requests}.
// <P>
// Can be specified as either a DataSource instance or the String ID of a DataSource.
//
// @group databinding
// @visibility external
// @example dataSourceFields
//<										

//> @attr dataBoundComponent.dataPageSize (number : 75 : IRW)
// When using data paging, how many records to fetch at a time.  The value of this
// attribute is passed on to the auto-constructed +link{class:ResultSet} object for this
// component.  In effect, this gives you control over the +link{attr:ResultSet.resultSize}
// attribute for this component.
//
// @group databinding
// @see ResultSet.resultSize
// @visibility external
//< 

//>	@attr dataBoundComponent.fields            (Array of Field : null : IRW)
// A DataBoundComponent manipulates records with one or more fields, and
// <code>component.fields</code> tells the DataBoundComponent which fields to present, in what
// order, and how to present each field.
// <p>
// When both <code>component.fields</code> and 
// <code>+link{dataBoundComponent.dataSource,component.dataSource}</code> are set,
// any fields in <code>component.fields</code> with the same name as a DataSource field
// inherit properties of the DataSource field.  This allows you to centralize data model
// information in the DataSource, but customize presentation of DataSource fields on a
// per-component basic.  For example, in a ListGrid, a shorter title or format for a field
// might be chosen to save space.
// <p>
// By default, only fields specified on the component are shown, in the order specified on
// the component.  The +link{useAllDataSourceFields} flag can be set to show all fields
// from the DataSource, with <code>component.fields</code> acting as field-by-field
// overrides and/or additional fields.
// <p>
// If a DataBoundComponent is given a DataSource, but no <code>component.fields</code>, the
// "default binding" is used: fields are shown in DataSource order, according
// to the properties <code>+link{showHiddenFields}</code> and 
// <code>+link{showDetailFields}</code>.
//
// @group databinding
// @visibility external
// @example mergedFields
// @example validationFieldBinding
//<

//>	@attr dataBoundComponent.useAllDataSourceFields		(boolean : false : IRW)
// If true, the set of fields given by the "default binding" (see 
// +link{attr:DataBoundComponent.fields}) is used, with any fields specified in
// <code>component.fields</code> acting as overrides that can suppress or modify the
// display of individual fields, without having to list the entire set of fields that
// should be shown.
// <P>
// If <code>component.fields</code> contains fields that are not found in the DataSource,
// they will be shown after the most recently referred to DataSource field.  If the new
// fields appear first, they will be shown first.
// <P>
// +explorerExample{validationFieldBinding,This example} shows a mixture of component
// fields and DataSource fields, and how they interact for validation.
//
// @group databinding
// @visibility external
// @example validationFieldBinding
//<

//>	@attr dataBoundComponent.showHiddenFields (boolean : false : IRW)
// Whether to show fields marked <code>hidden:true</code> when a DataBoundComponent is given a
// DataSource but no <code>component.fields</code>.
// <p>
// The <code>hidden</code> property is used on DataSource fields to mark fields that are
// never of meaning to an end user.
//  
// @group databinding
// @visibility external
//<

//>	@attr dataBoundComponent.showDetailFields (boolean : false : IRW)
// Whether to show include marked <code>detail:true</code> when a DataBoundComponent is 
// given a DataSource but no <code>component.fields</code>.
// <p>
// The <code>detail</code> property is used on DataSource fields to mark fields that 
// shouldn't appear by default in a view that tries to show many records in a small space.
// 
// @group databinding
// @visibility external
//<

//>	@attr dataBoundComponent.showComplexFields (boolean : true : IRWA)
// Whether to show fields of of non-atomic type when when a DataBoundComponent is given a
// DataSource but no <code>component.fields</code>.
// <p>
// If true, the component will show fields that declare a complex type, for example, a
// field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
// DataSource that declares the fields of a shipping address (city, street name, etc).
// <P>
// Such fields may need custom formatters or editors in order to create a usable interface,
// for example, an Address field in a ListGrid might use a custom formatter to combine the
// relevant fields of an address into one column, and might use a pop-up dialog for
// editing.
// 
// @group databinding
// @visibility external
//<
showComplexFields:true,

//>	@attr dataBoundComponent.fetchOperation    (String : null : IRW)
// Operation ID this component should use when performing fetch operations.
//
// @see attr:DSRequest.operationId
// @group operations
// @visibility external
//<

//>	@attr dataBoundComponent.updateOperation    (String : null : IRW)
// Operation ID this component should use when performing update operations.
//
// @see attr:DSRequest.operationId
// @group operations
// @visibility external
//<

//>	@attr dataBoundComponent.addOperation    (String : null : IRW)
// Operation ID this component should use when performing add operations.
//
// @see attr:DSRequest.operationId
// @group operations
// @visibility external
//<

//>	@attr dataBoundComponent.removeOperation    (String : null : IRW)
// Operation ID this component should use when performing remove operations.
//
// @see attr:DSRequest.operationId
// @group operations
// @visibility external
//<


ignoreEmptyCriteria: true,


dragRecategorize:true,

//> @attr dataBoundComponent.preventDuplicates (boolean : null : IR)
// If set, detect and prevent duplicate records from being transferred to this component, either via
// drag and drop or via +link{transferSelectedData()}.  When a duplicate transfer is detected,
// a dialog will appear showing the +link{duplicateDragMessage}.
// <P>
// If the component either does not have a +link{DataSource} or has a DataSource with no
// +link{dataSourceField.primaryKey,primaryKey} declared, duplicate checking is off by
// default.  If duplicate checking is enabled, it looks for an existing record in the dataset
// that has <b>all</b> of the properties of the dragged record, and considers that a duplicate.
// <P>
// For +link{dragDataAction}:"copy" where the target DataSource is related to the source
// DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
// criteria, already has a record whose value for the foreignKey field matches the
// primaryKey of the record being transferred.
// <P>
// For example, consider dragging "employees" to "teams", where "teams" has a field
// "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
// grid has search criteria causing it to show all the members of one team.  A duplicate -
// adding an employee to the same team twice - is when the target grid's dataset contains an
// record with "employeeId" matching the "id" field of the dropped employee.
// 
// @visibility external
//<

//> @attr dataBoundComponent.duplicateDragMessage (String : "Duplicates not allowed" : IR)
// Message to show when a user attempts to transfer duplicate records into this component, and
// +link{preventDuplicates} is enabled.
// @visibility external
//<
duplicateDragMessage: "Duplicates not allowed",

//>	@attr	dataBoundComponent.addDropValues		(Boolean : true : IRW)
//          Indicates whether to add "drop values" to items dropped on this component, if both 
//          the source and target widgets are databound, either to the same DataSource or 
//          to different DataSources that are related via a foreign key.  "Drop values" are 
//          properties of the dropped item that you wish to change (and persist) as a 
//          result of the item being dropped on this grid.
//          <P>
//          If this value is true and this component is databound, +link{getDropValues()} will 
//          be called for every databound item dropped on this grid, and an update performed
//          on the item
//
//      @group  dragging
//      @visibility external
//      @example listRecategorize
//<
addDropValues: true,

//>	@attr	dataBoundComponent.dropValues		(Object : null : IRWA)
//          When an item is dropped on this component, and +link{addDropValues} is true and both 
//          the source and target widgets are databound, either to the same DataSource or 
//          to different DataSources that are related via a foreign key, this object 
//          provides the "drop values" that SmartClient will apply to the dropped object 
//          before updating it.
//          <P>
//          If this property is not defined, SmartClient defaults to returning the selection
//          criteria currently in place for this component.  Thus, any databound items (for example, 
//          rows from other grids bound to the same DataSource) dropped on the grid will,
//          by default, be subjected to an update that makes them conform to the grid's 
//          current filter criteria.
//
//      @group  dragging
//      @visibility external
//      @example listRecategorize
//<
   


// Property to be used as field identifier on field objects.
// The ID of the field is also the property in each record which holds the value 
// for that field.
fieldIdProperty:"name",




//>	@method	dataBoundComponent.bindToDataSource()
// Combine component's fields specifications with the fields specifications from the
// datasource the component works with (specified indirectly by component.operation).
// - check if fields property and dataSource property are specified
// - if just dataSource, then use dataSource fields
// - if just fields property, then default behavior
// - if both, then use fields, with each field using defaults of dataSource<br>
//   calls setFields() when finished
//		@group	data
//<
bindToDataSource : function (fields, componentIsDetail) {
	// Most components operate on a datasource, displaying or otherwise manipulating fields from
	// that datasource.  We don't want to duplicate all the information about a field that is
	// specified in the datasource (type, title, etc) in each component that needs to display
	// that field.  So, we allow the component's field specifications to refer to the datasource
	// field by name, and combine the field specification from the component with the field
	// specification from the datasource.

    // pick up the dataSource of our dataset if it has one and we weren't given one
    if (this.dataSource == null && this.data != null) this.dataSource = this.data.dataSource;

	// get the datasource versions of the field specifications.  NOTE: this method may be
    // called in a build that does not include DataSource
	var	ds = this.getDataSource();

    if (ds != null && isc.isA.String(ds)) {
        this.logWarn("unable to look up DataSource: " + ds + ", databinding will not be used");
        return fields;
    }

    // Shorthand - treat fields being null or an empty array as the same case - no (meaningful) 
    // fields were passed in
    var noSpecifiedFields = (fields == null || fields.length == 0),
        dsFields;
    // get fields from the DataSource if we have one
    if (ds) {
        // flatten fields if so configured
        var flatten = this.useFlatFields;
        if (flatten == null) flatten = ds.useFlatFields;
        dsFields = flatten ? ds.getFlattenedFields() : ds.getFields();
    }

	// Case 1: no dataSource specified
	// This widget isn't associated with a datasource - all fields are full specifications
	// intended for the underlying widget.  The fields property is thus left untouched.
	if (ds == null || dsFields == null) {
        if (fields != null && isc.SimpleType) {
            // type defaults are auto-applied to DS fields and combined fields, but we need to
            // do it here for any field that doesn't apear in the DataSource
            for (var i = 0; i < fields.length; i++) {
                isc.SimpleType.addTypeDefaults(fields[i]);
            }
        }
		return fields;
    }

	// Case 2: dataSource specified, but no fields specified
	// The widget will show all DataSource fields, applying reasonable defaults.
	if (ds != null && noSpecifiedFields) {
        // NOTE we generally have to create a copy of the DataSource fields rather than having
        // everyone use the same objects, because widgets tend to scribble things into this.fields,
        // such as widths derived by a sizing policy.
        fields = [];
        for (var fieldName in dsFields) {
            var field = dsFields[fieldName];
            
            if (!this.shouldUseField(field, ds)) continue;

            fields.add(isc.addProperties({}, field));
        }
        return fields;
    }

	// Case 3: dataSource and fields specified
    // fields provided to this instance act as an overlay on DataSource fields
	if (ds != null && !noSpecifiedFields) {
        if (this.useAllDataSourceFields) {
            var canvas = this;
            return ds.combineFieldOrders(
                    dsFields, fields, 
                    function (field, ds) { return canvas.shouldUseField(field, ds) });
        } else {
            // only the fields declared on the component will be shown, in the order specified on
            // the component
            for (var i = 0; i < fields.length; i++) {
                var field = fields[i];
                if (!field) continue;
                var fieldName = field[this.fieldIdProperty];

                // this field isn't a datasource field - it's just intended to be passed through
                // to the underlying widget (like a form spacer)
                //
                // always addTypeDefaults b/c local field spec may override field type
                // addTypeDefaults will bail immediately if it's already been applied
                isc.SimpleType.addTypeDefaults(field);
                if (!ds.getField(fieldName)) continue;

                // combine the component field specification with the datasource field
                // specification - component fields override so that you can eg, retitle a field
                // within a summary
                field = ds.combineFieldData(field);
			}
            // return the original fields array, with properties added to the field objects
            return fields;
		}
	}
},

// return whether this component wants to use the field when binding to a DataSource
shouldUseField : function (field, ds) { 
    // hidden means don't show to an end user
    if (field.hidden && !this.showHiddenFields) return false;
    
    // don't use the field if the field is marked as a detail field and the component is not a
    // detail component 
    
    if (field.detail && !this.showDetailFields) return false;

    if (!this.showComplexFields && ds.fieldIsComplexType(field.name)) return false;

    return true;
},


//>	@method	dataBoundComponent.getField()	
// Return a field by a field index or field name.
//
// @param fieldID (String || Number) field index or field.name
//
// @return (object) Field description
// @visibility external
//<
getField : function (fieldId) {
    if (!this.fields) return null;
    return isc.Class.getArrayItem(fieldId, this.fields, this.fieldIdProperty);
},

getFieldNum : function (fieldId) {
    if (!this.fields) return -1;
    return isc.Class.getArrayItemIndex(fieldId, this.fields, this.fieldIdProperty);
},

//>	@method	dataBoundComponent.setValueMap()	
//		Set the valueMap for a field
//
//		@param	fieldID		(number)	        number of field to update
//      @param  map         (object)            ValueMap for the field
//
//<
setValueMap : function (field, map) {
    
    if (!isc.isAn.Object(field)) field = this.getField(field);
    if (!field) return;

    field.valueMap = map;
},


//> @method dataBoundComponent.setDataSource()
// Bind to a new DataSource.
// <P>
// Like passing the "dataSource" property on creation, binding to a DataSource means that the
// component will use the DataSource to provide default data for its fields.
// <P>
// When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
// these will be discarded by default, since it is assumed the new DataSource may represent a
// completely unrelated set of objects.  If the old "fields" are still relevant, pass them to
// setDataSource().
// 
// @param dataSource  (ID or DataSource)  DataSource to bind to 
// @param fields      (Array of Fields)  optional array of fields to use
// 
// @visibility external
// @example WSDLDataSource
//<
setDataSource : function (dataSource, fields) {
    if (isc._traceMarkers) arguments.__this = this;

	// if passed in value is null then bind() will then work on the declared ds.
	this.dataSource = dataSource || this.dataSource;
	
    // NOTE: actual dataBinding, meaning picking up dataSource field data, is done by
    // "bindToDataSource".  This call *must* be within setFields() because setFields() may be
    // called againt after binding, and must pick up DataSource field data at that time too.
	if (this.setFields) this.setFields(fields);

	// since we've (re)bound this widget, clear any data it may have as it may no longer be
    // valid.
    if (this.dataSource) {
        
        if (this.isA("DynamicForm")) this.setData({});
        else this.setData([]);
    }
    this.markForRedraw("bind");
},
// backCompat
bind : function (dataSource, fields) {
	this.setDataSource(dataSource, fields);
},

getDataSource : function () {
    if (isc.isA.String(this.dataSource)) {
        var ds = isc.DS.get(this.dataSource);
        if (ds != null) return ds;

        // support "dataSource" being specified as the name of a global, and if so, assign
        // that to this.dataSource
        ds = this.getWindow()[this.dataSource];
        if (ds && isc.isA.DataSource(ds)) return (this.dataSource = ds);
    }
    return this.dataSource;
},


//>@method DataBoundComponent.fieldValuesAreEqual()
// Compares two values and returns true if they are equal.  This is used to handle cases
// where edited values are equivalent to saved values, but a simple
// Javascript comparison (a == b) will return false (for example Date fields).
// @param field (object) field to which the values belong
// @param value1 (any) first value to be compared
// @param value2 (any) second value to be compared
// @visibility internal
//<
// Leave visibility internal, but non obfuscated - we may allow developers to override this for
// custom field types

fieldValuesAreEqual : function (field, value1, value2) {
    // no matter what the type if they are '==' always return true;
    if (value1 == value2) return true;
    
    // If we don't have field object for the value passed in - just rely on the "==" comparison
    // This typically occurs when we have editValues in a grid, or values in a DynamicForm
    // that don't have a corresponding field object.
    
    if (field == null) return false;
    
    if (field.type == "date") {
        if (isc.isA.Date(value1) && isc.isA.Date(value2)) {
            return (Date.compareDates(value1, value2) == 0);
        }
    } else if (field.type == "valueMap") {
        if (isc.isAnArray(value1) && isc.isAn.Array(value2)) {
            return value1.equals(value2)
            
        } else if (isc.isAn.Object(value1) && isc.isAn.Object(value2)) {
            for (var i in value1) {
                if (value2[i] != value1[i]) return false;
            }
            
            for (var j in value2) {
                if (value1[j] != value2[j]) return false;
            }
            
            // everything matched
            return true;
        }
    }
    
    // return false
    return false;
},

//> @attr dataBoundComponent.useFlatFields (boolean : null : IR)
// The <code>useFlatFields</code> flag causes all simple type fields anywhere in a nested
// set of DataSources to be exposed as a flat list for form binding.  
// <P>
// <code>useFlatFields</code> is typically used with imported metadata, such as 
// +link{XMLTools.loadXMLSchema,XML Schema} from a 
// +link{XMLTools.loadWSDL,WSDL-described web servce}, as a means of eliminating levels of XML
// nesting that aren't meaningful in a user interface, without the cumbersome and fragile
// process of mapping form fields to XML structures.
// <P>
// For example, having called +link{webService.getInputDS()} to retrieve the input message
// schema for a web service operation whose input message looks like this:
// <pre>
// &lt;FindServices&gt;
//     &lt;searchFor&gt;search text&lt;/searchFor&gt;
//     &lt;Options&gt;
//         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
//     &lt;/Options&gt;
//     &lt;IncludeInSearch&gt;
//         &lt;serviceName&gt;true&lt;/serviceName&gt;
//         &lt;documentation&gt;true&lt;/documentation&gt;
//         &lt;keywords&gt;true&lt;/keywords&gt;
//     &lt;/IncludeInSearch&gt;
// &lt;/FindServices&gt;
// </pre>
// Setting <code>useFlatFields</code> on a +link{DynamicForm} that is bound to this input
// message schema would result in 5 +link{FormItem,FormItems} reflecting the 5 simple type
// fields in the message.
// <P>
// For this form, the result of +link{dynamicForm.getValues(),form.getValues()} might look
// like:
// <P>
// <pre>{
//    searchFor: "search text",
//    caseSensitive: false,
//    serviceName: true,
//    documentation : true,
//    keywords : true
// }</pre>
// When contacting a +link{WebService,WSDL web service}, these values can be automatically
// mapped to the structure of the input message for a web service operation by setting
// +link{wsRequest.useFlatFields} (for use with +link{webService.callOperation()}) or by setting
// +link{dsRequest.useFlatFields} (for use with a +link{DataSource} that is
// +link{group:wsdlBinding,bound to a WSDL web service} via
// +link{operationBinding.wsOperation}).  
// <P>
// Using these two facilities in conjunction (component.useFlatFields and
// request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
// presentation and when providing the data for XML messages.
// <P>
// You can also set +link{operationBinding.useFlatFields} to automatically enable 
// "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
// particular operationType.
// <P>
// Note that <code>useFlatFields</code> is not generally recommended for use with structures
// where multiple simple type fields exist with the same name, however if used with such a
// structure, the first field to use a given name wins.  "first" means the first field
// encountered in a depth first search.  "wins" means only the first field will be present as a
// field when data binding.
// 
// @visibility external
//<

// minimal implementation of setFields()
setFields : function (fields) {
	// combine specified "fields" with reference declarations in the dataSource
	fields = this.bindToDataSource(fields);

	this.fields = fields;
},

getSerializeableFields : function (removeFields, keepFields) {
	// data may actually be valid in some cases - but removing it is a good default.
	removeFields.addList(["zIndex", "data"]);
		
	// don't save ID if it's auto-generated
	if (this.ID && this.ID.startsWith("isc_")) removeFields.add("ID");

	// if this component is bound to a datasource, don't serialize its fields or items
    
	if (this.dataSource) removeFields.addList(["fields", "items"]);

	// we only want to serialize children created explicitly by a developer - not children
    // auto-created by an ISC component (such as the ListGrid header) 
    
	if (this.getClassName() != "Canvas" && this.getClassName() != "Layout") {
        removeFields.add("children");
    }

	return this.Super("getSerializeableFields", arguments);
},

addField : function (field, index) {
    var fields = (this.fields || this.items || isc._emptyArray).duplicate();
    fields.addAt(field, index);
    this.setFields(fields);
},

removeField : function (fieldName) {
    var fields = (this.fields || this.items || isc._emptyArray).duplicate();
    fields.remove(fields.find("name", fieldName));
    this.setFields(fields);
},

// DataBound Component Methods
// --------------------------------------------------------------------------------------------
//> @groupDef dataBoundComponentMethods
// An Action Method initiates an orchestrated client-server flow that stores or retrieves data
// and updates one or more components.
// <P>
// For example, the +link{DynamicForm.saveData(),editor.saveData()} Action Method saves the
// record currently being edited in the form, transparently handling the trip to the server,
// standard error conditions such as validation errors (whether the validation error
// happens on the client or server), and update of client-side caches.
// <P>
// Action Methods are available on DataBoundComponents.
//
// @treeLocation Client Reference/Data Binding
// @see interface:DataBoundComponent
// @title DataBound Component Methods
// @visibility external
//<

// NOTE: the DataBound Component Methods are mostly implemented directly on Canvas, and act
// as a basic framework for building a DataBound widget, however, we document them as existing
// on the specific components where it actually makes sense to call them.

//> @method listGrid.fetchData()
// @include dataBoundComponent.fetchData()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundFetch
//<

//>	@attr listGrid.autoFetchData       (boolean : false : IR)
// @include dataBoundComponent.autoFetchData
// @group databinding
// @visibility external
// @example fetchOperation
//<

//> @attr listGrid.initialCriteria   (Criteria : null :IR)
// @include dataBoundComponent.initialCriteria
// @visibility external
//<

//> @method listGrid.filterData()
// @include dataBoundComponent.filterData()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundFilter
//<

//> @method listGrid.fetchRelatedData()
// @include dataBoundComponent.fetchRelatedData()
// @group dataBoundComponentMethods
// @visibility external
//<

//> @method listGrid.clearCriteria()
// @include dataBoundComponent.clearCriteria()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundFilter
//<

//> @method listGrid.addData()
// @include dataBoundComponent.addData()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundAdd
//<

//> @method listGrid.updateData()
// @include dataBoundComponent.updateData()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundUpdate
//<

//> @method listGrid.removeData()
// @include dataBoundComponent.removeData()
// @group dataBoundComponentMethods
// @visibility external
// @example databoundRemove
//<

//> @method listGrid.removeSelectedData()
// @include dataBoundComponent.removeSelectedData()
// @group dataBoundComponentMethods
// @visibility external
// @example removeOperation
//<

 
//> @method listGrid.getSelection()
// @include dataBoundComponent.getSelection()
//
// @group  selection
// @visibility external
// @example databoundRemove
//<

//> @method listGrid.getSelectedRecord()
// Return the first selected record in this component.<br><br>
// This method is appropriate if <code>+link{attr:listGrid.selectionType}</code> is
// <code>"single"</code>, or if you only care about the first selected record in
// a multiple-record selection. To access all selected records, use
// <code>+link{method:listGrid.getSelection()}</code> instead.
//      @group  selection
//      @return (ListGridRecord) first selected record, or null if nothing selected
// @visibility external
// @example databoundRemove
//<


//> @method treeGrid.fetchData()
// Uses a "fetch" operation on the current +link{DataSource,grid.dataSource} to retrieve data
// that matches the provided criteria, and displays the matching data in this component as a
// tree.
// <P>
// This method will create a +link{ResultTree} to manage tree data, which will
// subsequently be available as <code>treeGrid.data</code>.  DataSource records
// returned by the "fetch" operation are linked into a tree structure according to
// +link{dataSourceField.primaryKey,primaryKey} and
// +link{dataSourceField.foreignKey,foreignKey} declarations on DataSource fields.  See the
// +link{group:treeDataBinding} topic for complete details.
// <P>
// By default, the created ResultTree will use folder-by-folder load on demand, asking the
// server for the children of each folder as the user opens it.
// <P>
// The +link{ResultTree} created by <code>fetchData()</code> can be customized by setting
// +link{listGrid.dataProperties} to an Object containing properties and methods to apply to
// the created ResultTree.  For example, the property that determines whether a node is a
// folder (+link{Tree.isFolderProperty,isFolderProperty}) can be customized, or
// level-by-level loading can be disabled via
// +link{resultTree.loadDataOnDemand,loadDataOnDemand:false}.
// <P>
// The callback passed to <code>fetchData</code> will fire once, the first time that data is
// loaded from the server.  If using folder-by-folder load on demand, use the
// +link{resultTree.dataArrived()} notification to be notified each time new nodes are loaded.
// <P>
// Note that, if criteria are passed to <code>fetchData()</code>, they will be passed every
// time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
// different tree structures from the same DataSource.  However note that the server is expected
// to always respond with an intact tree - returned nodes which do not have parents are dropped
// from the dataset and not displayed.
//
// @include dataBoundComponent.fetchData()
// @group dataBoundComponentMethods
// @visibility external
//<

//> @method treeGrid.filterData()
// Retrieves data that matches the provided criteria and displays the matching data in this
// component.
// <P>
// This method behaves exactly like +link{treeGrid.fetchData()} except that
// +link{dsRequest.textMatchStyle} is automatically set to "substring" so that String-valued
// fields are matched by case-insensitive substring comparison.
//
// @include dataBoundComponent.filterData()
// @group dataBoundComponentMethods
// @visibility external
//<

//>	@attr dynamicForm.autoFetchData       (boolean : false : IR)
// @include dataBoundComponent.autoFetchData
// @group databinding
// @visibility external
//<

//> @attr dynamicForm.initialCriteria   (Criteria : null :IR)
// @include dataBoundComponent.initialCriteria
// @visibility external
//<



// Filtering
// -----------------------------------------------------------------------------



//>	@method dataBoundComponent.filterData()
// Retrieves data that matches the provided criteria and displays the matching data in this
// component.
// <P>
// This method behaves exactly like +link{listGrid.fetchData()} except that
// +link{dsRequest.textMatchStyle} is automatically set to "substring" so that String-valued
// fields are matched by case-insensitive substring comparison.
//
// @param [criteria]          (Criteria)	  Search criteria. 
//                      If a +link{DynamicForm} is passed in as this argument
//                      instead of a raw criteria object, will be derived by calling
//                      +link{DynamicForm.getValuesAsCriteria()}
// @param [callback]          (DSCallback)  callback to invoke when a fetch is complete.  Fires
//                                          only if server contact was required; see
//                                          +link{dataBoundComponent.fetchData,fetchData()} for details
// @param [requestProperties] (DSRequest)   for databound components only - optional 
//                           additional properties to set on the DSRequest that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
filterData : function (criteria, callback, requestProperties) {
    this._filter("filter", criteria, callback, requestProperties);
},

//>	@method dataBoundComponent.fetchData()
// Uses a "fetch" operation on the current +link{DataSource,grid.dataSource} to retrieve data
// that matches the provided criteria, and displays the matching data in this component.
// <P>
// If there are a large number of matching records, paging will automatically be enabled, so
// that initially a smaller number of records will be retrieved and further records will
// be fetched as the user navigates the dataset.
// <P>
// When first called, this method will create a +link{class:ResultSet}, which will be
// configured based on component settings such as +link{attr:dataBoundComponent.fetchOperation}
// and +link{attr:dataBoundComponent.dataPageSize}, as well as the general purpose
// +link{listGrid.dataProperties}.  The ResultSet is then available as
// <code>component.data</code>.
// <P>
// Subsequent calls to fetchData() will simply call +link{resultSet.setCriteria,setCriteria()}
// on the created ResultSet with the passed criteria.
// <P>
// In some cases fetchData() will not need to context the server as the new criteria can be
// satisfied by performing a client-side filter against the currently cached set of data.
// You can determine whether criteria will cause a fetch by calling 
// +link{ResultSet.willFetchData()}.
// <P>
// If you need to force a server fetch, you can call +link{resultSet.invalidateCache()} via
// <code>component.data.invalidateCache()</code> to do so.  
// <P>
// This method takes an optional callback parameter (set to a +link{DSCallback}) to fire when
// the fetch completes. Note that this callback will not fire if no server fetch is performed.
// In this case the data is updated synchronously, so as soon as this method completes you
// can interact with the new data. If necessary we recomment using 
// +link{ResultSet.willFetchData()} before calling this method to determine whether or not
// a server fetch will occur.
// <P>
// In addition to the callback parameter for this method, developers can use 
// +link{ResultSet.dataArrived()} to be notified every time ResultSet data is loaded.  A
// <code>dataArrived</code> method can be installed in the automatically created ResultSet by
// adding it to +link{listGrid.dataProperties,dataProperties}.
//
// @param [criteria]          (Criteria)	  Search criteria. 
//                      If a +link{DynamicForm} is passed in as this argument
//                      instead of a raw criteria object, will be derived by calling
//                      +link{DynamicForm.getValuesAsCriteria()}
// @param [callback]          (DSCallback)  callback to invoke when a fetch is complete.  Fires
//                                          only if server contact was required
// @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
//                                            that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
fetchData : function (criteria, callback, requestProperties) {
    this._filter("fetch", criteria, callback, requestProperties);
},


// setCriteria - sets this component's criteria
// Default implementation calls this.data.setCriteria() 
setCriteria : function (criteria) {
    if (this.data && this.data.setCriteria) this.data.setCriteria(criteria);
},

// getCriteria : retrieve the current criteria for this grid
// Overridden on CubeGrids
getCriteria : function () {
    return this.data && this.data.getCriteria ? this.data.getCriteria() : null;
},

//>	@attr dataBoundComponent.autoFetchData       (boolean : false : IR)
// If true, when this component is first drawn, automatically call <code>this.fetchData()</code>
//
// @group dataBoundComponentMethods
// @visibility internal
// @see fetchData()
//<

//> @attr dataBoundComponent.initialCriteria   (Criteria : null :IR)
// Criteria to be used when +link{autoFetchData} is set.
// @visibility internal
//<

//> @method dataBoundComponent.fetchRelatedData()
// Based on the relationship between the DataSource this component is bound to and the
// DataSource specified as the "schema" argument, call fetchData() to retrieve records in this
// grid that are related to the passed-in record.
// <P>
// Relationships between DataSources are declared via +link{dataSourceField.foreignKey}.
// <P>
// For example, given a DataSource "orders" and another DataSource "orderItems", where
// "orderItems" declared a field "orderId" pointing to the primary key field of the "orders"
// DataSource", there is a set of records from the "orderItems" DataSource related to any given
// record from the "order" DataSource.  If this component were bound to "orderItems" and a
// record from the "orders".
//
// @param record              (ListGridRecord) DataSource record
// @param schema              (Canvas or DataSource or ID) schema of the DataSource record, or
//                            DataBoundComponent already bound to that schema
// @param [callback]          (DSCallback)  callback to invoke on completion
// @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
//                                            that will be issued
//
// @visibility internal
//<
fetchRelatedData : function (record, schema, callback, requestProperties) {
    var otherDS = isc.isA.DataSource(schema) ? schema : 
            isc.isA.String(schema) ? isc.DS.get(schema) :
            isc.isA.Canvas(schema) ? schema.dataSource : null;
    if (!otherDS) {
        this.logWarn("schema not understood: " + this.echoLeaf(schema));
        return;
    }
    var relationship = this.getDataSource().getTreeRelationship(otherDS);

	// form criteria to find related records
    var criteria = {};
    criteria[relationship.parentIdField] = record[relationship.idField];

    this.fetchData(criteria, callback, requestProperties);
},

//>	@method dataBoundComponent.clearCriteria()
// Clear the current criteria used to filter data.
//
// @param [callback]          (DSCallback)  callback to invoke on completion
// @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
//                                            that will be issued
//
// @see listGrid.fetchData()
//
// @group dataBoundComponentMethods
// @visibility internal
//<
clearCriteria : function (callback, requestProperties) {
    this._filter("filter", null, callback, requestProperties);
},

_filter : function (type, criteria, callback, requestProperties) {
    if (isc._traceMarkers) arguments.__this = this;

    //>!BackCompat 2005.3.21 old signature: criteria, context
    if (requestProperties == null && isc.isAn.Object(callback) && 
        callback.methodName == null) 
    {
        // old style call, second param (callback) is really requestParams
        requestProperties = callback;
        callback = null;
    } //<!BackCompat
    requestProperties = this.buildRequest(requestProperties, type, callback);

    // handle being passed a criteria object (map of keys to values), or a filter-component
    if (criteria == null) {
        criteria = {};
    } else if (isc.isA.Class(criteria)) {
        // otherwise assume "filter" is something we can ask for filter criteria
        // (DynamicForm or ValuesManager)
        criteria = isc.DynamicForm.getFilterCriteria(criteria);
    }

    this.filterWithCriteria(criteria, requestProperties.operation, requestProperties);
},

filterWithCriteria : function (criteria, operation, context) {
    context.prompt = (context.prompt || isc.RPCManager.fetchDataPrompt);
    
    // get rid of empty criteria that come from raw form values
    var filterCriteria = criteria;
    if ( this.ignoreEmptyCriteria ) {
       filterCriteria = isc.DataSource.filterCriteriaForFormValues(criteria);
    }
    
    var dataModel = this.getData();
	
    // if not already viewing a result set/tree for this operation, create one for it
    if (this.useExistingDataModel(criteria, operation, context)) {
        this.updateDataModel(filterCriteria, operation, context);
    } else {
        dataModel = this.createDataModel(filterCriteria, operation, context);
    }

    // we will ask the result set for the data we currently need to display,
    // which will cause data to be fetched
    this.setData(dataModel);
        
    
    if (!context._suppressFetch && this.requestVisibleRows != null) {
        var data = this.data,
            fetchDelay = data.fetchDelay;
        
        data.fetchDelay = 0;
        this.requestVisibleRows();
        data.fetchDelay = fetchDelay;
    }
},


useExistingDataModel : function (criteria, operation, context) {
    
   var resultSet = this.getData();
   if (!isc.isA.ResultSet(resultSet)) return false;
   
   var resultSetOperation = resultSet.getOperationId("fetch");
   return resultSetOperation == null || resultSetOperation == operation.ID;
}, 

createDataModel : function (filterCriteria, operation, context) {
    //>DEBUG
    this.logInfo("Creating new isc.ResultSet for operation '" + operation.ID + 
                  "' with filterValues: " + isc.Comm.serialize(filterCriteria));
    //<DEBUG
    var dataSource = this.getDataSource(),
        resultSet = this.dataProperties || {};
    if (this.dataFetchDelay) resultSet.fetchDelay = this.dataFetchDelay;
    
    isc.addProperties(resultSet, { operation:operation, filter:filterCriteria, context:context,
        componentId: this.ID});
    return dataSource.getResultSet(resultSet);
},

updateDataModel : function (filterCriteria, operation, context) {
    
    // tell the ResultSet the filter changed
    //>DEBUG
    this.logDebug("Setting filter to: " + isc.Comm.serialize(filterCriteria));
    //<DEBUG
      
    // update the context - this allows requestProperties like "showPrompt" / textMatchStyle
    // to change
    var resultSet = this.getData();
    resultSet.setContext(context);      
    resultSet.setCriteria(filterCriteria);
},

// add this here so that all dataBoundComponents have data available by default.
requestVisibleRows : function () {
    return this.data.get(0);
},


// Persistence
// -----------------------------------------------------------------------------



//> @method dataBoundComponent.addData()
// Perform a DataSource "add" operation to add new records to this component's DataSource.
//
// @param newRecord (Object)	        new record
// @param [callback] (DSCallback)  method to call on operation completion
// @param  [requestProperties] (DSRequest Properties)   additional properties to set on the DSRequest
//                                          that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
addData : function (newRecord, callback, requestProperties) {
    return this._performDSOperation("add", newRecord, callback, requestProperties);
},

//> @method dataBoundComponent.updateData()
// Perform a DataSource "update" operation to update existing records in this component's
// DataSource.
//
// @param updatedRecord  (Object)	        updated record
// @param [callback]          (DSCallback)  method to call on operation completion
// @param [requestProperties] (DSRequest Properties)   additional properties to set on the DSRequest
//                                          that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
updateData : function (updatedRecord, callback, requestProperties) {
    return this._performDSOperation("update", updatedRecord, callback, requestProperties);
},

//> @method dataBoundComponent.removeData()
// Perform a DataSource "remove" operation to remove records from this component's
// DataSource.
//
// @param data (Object)	        primary key values of record to delete, 
//                                          (or complete record)
// @param [callback] (DSCallback)  method to call on operation completion
// @param [requestProperties] (DSRequest Properties)   additional properties to set on the DSRequest
//                                          that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
removeData : function (recordKeys, callback, requestProperties) {
    return this._performDSOperation("remove", recordKeys, callback, requestProperties);
},

_performDSOperation : function (operationType, data, callback, requestProperties) {
    if (isc._traceMarkers) arguments.__this = this;

    //>!BackCompat 2005.3.21 old signature: data, context
    if (requestProperties == null && isc.isAn.Object(callback) && 
        callback.methodName == null) 
    {
        // old style call, second param (callback) is really requestParams
        requestProperties = callback;
        callback = null;
    } //<!BackCompat

    if (this.saveLocally) {
        if (operationType == "update") {
            // look up record by PK
            var record = this.data.get(this.getDataSource().findByKeys(data, this.data));
            //this.logWarn("record is: " + this.echo(record) + ", data is: " + this.echo(data));
            // update it
            isc.addProperties(record, data);
            // manaully fire dataChanged
            return this.data.dataChanged();
        } else if (operationType == "add") {
            // dataChanged fires automatically
            this.data.add(data);
            return;
        }
    }
    return this.getDataSource().performDSOperation(operationType, data, 
                                                   callback, requestProperties);
},

//>	@method dataBoundComponent.removeSelectedData()
// Remove the currently selected records from this component.
// If this is a databound grid, the records will be removed directly from the DataSource.
// <P>
// If no records are selected, no action is taken. The grid will automatically be
// updated if the record deletion succeeds.
//
// @param [callback] (callback) callback to fire when the data has been removed
// @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
//                                          that will be issued
//
// @group dataBoundComponentMethods
// @visibility internal
//<
removeSelectedData : function (callback, requestProperties) {


    //>!BackCompat 2005.3.21 old signature: criteria, context
    if (requestProperties == null && isc.isAn.Object(callback) && 
        callback.methodName == null) 
    {
        // old style call, first param (callback) is really requestParams
        requestProperties = callback;
        callback = null;
    } //<!BackCompat

    
    var selection = this.getSelection();

    // In an editable ListGrid, you can't select unsaved data.  If we are editing and
    // selectOnEdit is set and this is an unsaved row, call discardEdits() as an equivalent to
    // removeSelectedData()
    if (isc.isA.ListGrid(this) && this.canEdit && this.selectOnEdit && 
        (selection == null || selection.length == 0) &&
        this.getEditRow() != null && this.getRecord(this.getEditRow()) == null)
    {
        this.discardEdits(this.getEditRow());
        return;
    }

    // if this is not a databound grid or we are working with local-only data (an Array)
    if (this.dataSource == null || this.saveLocally) {
        if (this.data) {
            this.data.removeList(this.getSelection());
            if (callback) this.fireCallback(callback);
        }
        return;
    }

    var context = this.buildRequest(requestProperties, "remove", callback),
        dataSource = this.getDataSource();

    if (selection.length > 0) this.deleteRecords(selection, context.operation, context, dataSource);
    // notify that they have to select something to delete first... ???
},

// delete a specific list of records from the server
deleteRecords : function (records, deleteOperation, context, dataSource) {
    
    isc.addProperties(context, {
        prompt:(context.prompt || isc.RPCManager.removeDataPrompt)
    });

    // perform the delete as a multi-op, one per record
    var wasAlreadyQueuing = isc.RPCManager.startQueue();
    if (!isc.isAn.Array(records)) records = [records];
    for (var i = 0; i < records.length; i++) {
        if (records[i]._isGroup) continue;
        dataSource.performDSOperation(deleteOperation.type, records[i], null, context);
    }
    
    // don't kickoff the transaction unless this flow initiated queuing, in case caller
    // wants to include other operations
    if (!wasAlreadyQueuing) isc.RPCManager.sendQueue();
},

// Selection
// ---------------------------------------------------------------------------------------

//> @method dataBoundComponent.createSelectionModel()
// Creates the selection object for this +link{DataBoundComponent}
//
// @return null
// @group  selection
// @visibility internal
//<
createSelectionModel : function () {
    // clean up old selection object before creating new selection, if we have one.
    if (this.selection) this.destroySelectionModel();
    
    if (this.canSelectCells) {
    	
        var data = [];
        if (this.numRows != null) {
            for (var i = 0; i < this.numRows; i++) {
                data[i] = {};
            }
        }
    } else {
        var data = this.data;
    }
		
    var selection,
        params = {ID:this.getID()+"_selection", 
                  data:data,
                  
                  target: this,
                  selectionProperty:this.selectionProperty,
                  simpleDeselect : this.simpleDeselect,
                  dragSelection : this.canDragSelect
                };

    
    if (this.canSelectCells && this.fields != null) params.numCols = this.fields.length;
    
	// if the data object supports a special selection class, use it
	if (this.data.getNewSelection) {
        selection = this.data.getNewSelection(params);
    }
    if (selection == null) {
    	// otherwise use the default Selection or CellSelection class
        if (this.canSelectCells) {
            selection = isc.CellSelection.create(params);
        } else {
            selection = isc.Selection.create(params);
        }
    }
	
    this.selection = selection;
    
},

// destroySelectionModel: Decouple from selection object and destroy it.  
destroySelectionModel : function () {
    if (!this.selection) return;
    if (this.selection.destroy) this.selection.destroy();
    delete this.selection;
}, 

//> @method dataBoundComponent.getSelection()
// Returns all selected records, as an Array.
//
// @return (Array of ListGridRecord) list of records, empty list if nothing selected
// @group  selection
// @visibility internal
// @example databoundRemove
//<
getSelection : function () {
    if (!this.selection) return null;
	if (this.canSelectCells) {
		var selectedCells = this.selection.getSelectedCells();
		if (selectedCells == null) return null;

		
		var cellRecords = [];
		for (var i = 0; i < selectedCells.length; i++) {
			var selectedCell = selectedCells[i],
				cellRecord = this.getCellRecord(selectedCell[0], selectedCell[1])
			;
			if (cellRecord == null) continue; // record for this cell
			cellRecords.add(cellRecord);
		}
		return cellRecords;
	} else {
		return this.selection.getSelection();
	}
},

//> @method dataBoundComponent.getSelectedRecord()
// Return the first selected record in this component
//      @group  selection
//      @return (ListGridRecord) first selected record, or null if nothing selected
// @visibility internal
// @example databoundRemove
//<
getSelectedRecord : function() {
    if (!this.selection) return null;
    return this.selection.getSelectedRecord();
},

//> @method dataBoundComponent.getSelectionObject()
// Return the dataBoundComponent's underlying +link{Selection} object.  Note that this differs
// from +link{dataBoundComponent.getSelection}, which returns an array containing the actual
// selected objects
//      @group  selection
//      @return (Selection) This dataBoundComponent's underlying +link{Selection} object
// @visibility internal
//<
getSelectionObject : function() {
    return this.selection;
},

//> @groupDef selection
// APIs for marking +link{Record}s as selected and retrieving the selected record or records.
// <P>
// Only applicable to a +link{DataBoundComponent} that manages a list of Records, or manages a
// data model that can be viewed as a list (for example, the current list of visible nodes
// on a tree can be treated as a list for selection purposes).
// 
// @title Selection
// @visibility external
//<


// Simple helper methods to avoid having to refer directly to this.selection
// Genericized up from ListGrid, July 2008

//> @method dataBoundComponent.selectRecord()
//
// Select/deselect a +link{Record} passed in explicitly, or by index.
//
// @param record (Record | number) record (or row number) to select
// @param [newState] (boolean) new selection state (if null, defaults to true)
//
// @group selection
// @visibility external
//<
selectRecord : function (record, state, colNum) {
    this.selectRecords(record, state, colNum);
},

//> @method dataBoundComponent.deselectRecord()
//
// Deselect a +link{Record} passed in explicitly, or by index.
// <P>
// Synonym for <code>selectRecord(record, false)</code>
//
// @param record (Record | number) record (or row number) to deselect
//
// @group selection
// @visibility external
//<
deselectRecord : function (record, colNum) {
    this.selectRecord(record, false, colNum);
},

//> @method dataBoundComponent.selectRecords()
//
// Select/deselect a list of +link{Record}s passed in explicitly, or by index.
//
// @param records (Array of Record | numbers) records (or row numbers) to select
// @param [newState]  (boolean) new selection state (if null, defaults to true)
//
// @group selection
// @visibility external
//<
selectRecords : function (records, state, colNum) {
    if (state == null) state = true;
    if (!isc.isAn.Array(records)) records = [records];
    
    for (var i = 0; i < records.length; i++) {
        
        if (records[i] == null) continue;
        // assume any number passed is a row-num
        if (isc.isA.Number(records[i])) records[i] = this.getRecord(records[i], colNum);
    }
    
    var selObj = this.getSelectionObject(colNum);
    if (selObj) selObj.selectList(records, state, colNum);
},

//> @method dataBoundComponent.deselectRecords()
//
// Deselect a list of +link{Record}s passed in explicitly, or by index.
// <P>
// Synonym for <code>selectRecords(records, false)</code>
//
// @param records (Array of Record | numbers) records (or row numbers) to deselect
//
// @group selection
// @visibility external
//<
deselectRecords : function (records, colNum) {
    this.selectRecords(records, false);
},

//> @method dataBoundComponent.selectAllRecords()
// Select all records
//
// @group selection
// @visibility external
//<
selectAllRecords : function () {
    this.selection.selectAll();
},

//> @method dataBoundComponent.deselectAllRecords()
//
// Deselect all records
//
// @group selection
// @visibility external
//<
deselectAllRecords : function () {
    this.selection.deselectAll();
},

//> @method dataBoundComponent.anySelected()
// @include selection.anySelected()
//<
anySelected : function () {
    return this.selection && this.selection.anySelected();
},

getRecord : function (index, column) {
    if (this.data) return this.data.get(index);
    return null;
},

// Hiliting
// ---------------------------------------------------------------------------------------

//> @groupDef hiliting
// Hiliting means special visual styling which is applied to specific data values that meet
// certain criteria.
// <P>
// A +link{Hilite} definition contains styling information such as +link{hilite.cssText} and
// +link{hilite.htmlBefore} that define what the hilite looks like, as well as properties
// defining where the hilite is applied.
// <P>
// A hilite can be applied to data <b>either</b> by defining +link{hilite.criteria,criteria}
// or by explicitly including markers on the data itself.  
// <P>
// Hiliting rules such as hiliting different ranges of values with different colors can be
// accomplished entirely client-side by defining +link{AdvancedCriteria} in hilite definitions
// that pick out values to be highlighted.
// <P>
// Hiliting rules that require server-side calculations can be achieved by assigning a
// +link{hilite.id} to a hilite definition, and setting the
// +link{dataBoundComponent.hiliteProperty} on the records that should show that highlight.
// This can be used, for example, to hilite the record with the maximum value for a dataset
// that the application will load incrementally.
//
// @title Hiliting Overview
// @visibility external
//<

// Hilite Declarations
// ---------------------------------------------------------------------------------------

//> @object Hilite
// Definition of a hilite style.
// <P>
// See +link{group:hiliting} for an overview.
//
// @treeLocation Client Reference/Grids
// @requiresModules Analytics
// @visibility external
//< 

//> @attr hilite.id (String : null : IR)
// Unique id for this hilite definition.  
// <P>
// For hilites that include +link{hilite.criteria} this is not required.
// <P>
// If you are explicitly marking records for hiliting, set
// +link{dataBoundComponent.hiliteProperty} on the record to this id.  
//
// @visibility external
//< 

//> @attr hilite.cssText (CSSText : null : IR)
// CSS text to be applied to cells where this hilite is applied, for example,
// "background-color:#FF0000"
//
// @visibility external
//< 

//> @attr hilite.fieldName (identifier : null : IR)
// Name of the field that hilite should be applied to.  
// <P>
// If unset, hilite is applied to every field of the record.
//
// @visibility external
//< 

//> @attr hilite.criteria (Criteria or AdvancedCriteria : null : IR)
// Criteria defining what records this hilite should apply to.
// 
// @visibility external
//<

//> @attr hilite.htmlBefore (HTML : null : IR)
// HTML to prepend to cell values where this hilite is applied.
//
// @visibility external
//<

//> @attr hilite.htmlAfter (HTML : null : IR)
// HTML to append to the end of cell values where this hilite is applied.
//
// @visibility external
//<

//> @attr hilite.disabled (boolean : false : IRW)
// Whether this hilite is currently disabled.
// <P>
// Hilites can be programmatically enabled and disabled via +link{dataBoundComponent.enableHilite()}.
//
// @visibility external
//<

//> @attr hilite.title (String : false : IRW)
// User-visible title for this hilite.  Used for interfaces such as menus that can enable or
// disable hilites.
//
// @visibility external
//<



 
styleOpposite:"cellHiliteOpposite",

// Hilites
// ---------------------------------------------------------------------------------------

//> @attr dataBoundComponent.hilites (Array of Hilite : null : [IRW])
// Hilites to be applied to the data for this component.  See +link{group:hiliting}.
//
// @visibility external
//<

//> @attr dataBoundComponent.hiliteProperty (string : "_hilite" : [IRW])
// Marker that can be set on a record to flag that record as hilited.  Should be set to a value
// that matches +link{hilite.id} for a hilite defined on this component.
//
// @visibility external
//<
// NOTE: not the same as hiliteMarker, which is an internal property used to track generated
// hilites 
hiliteProperty:"_hilite",

    
// Hilite APIs

// user: 
//   component.hilites && setHilites()
//   record[hiliteProperty] (CubeGrid only)
// component/framework: 
//   note: setup is automatic on first call any of the below, or setHilites()
//   applyHilites() (to data)
//   getHiliteCSSText() / addHiliteCSSText()




getHilites : function () {
    return this.hilites;
},

// property used to store hilite state for generated hilites
hiliteMarker:"_hmarker",
_hiliteCount: 0,
setHilites : function (hilites) {
    this.hilites = hilites;

    if (hilites == null) return; // no hilites

    this._setupHilites(this.hilites);

}, 

// factored so it can also get called lazily the first time getHilite() is called
_setupHilites : function (hilites, dontApply) {
    // auto-assign ids if unset
    for (var i = 0; i < hilites.length; i++) {
        if (hilites[i].id == null) {
            this._lastHiliteId = this._lastHiliteId || 0;
            hilites[i].id = this._lastHiliteId;
        }
    }
    
    // for quick hilite lookups
    this._hiliteIndex = hilites.makeIndex("id");
    
    if (!dontApply) this.applyHilites();
},

applyHilites : function () {
    var hilites = this.hilites,
        data = this.data;

    if (!hilites) return;

    if (hilites && !this._hiliteIndex) this._setupHilites(hilites, true);

    // wipe all existing hilite markers  
    if (isc.isA.ResultSet(data)) data = data.getAllLoadedRows()
    data.setProperty(this.hiliteMarker, null);

    // apply each hilite in order
    for (var i = 0; i < hilites.length; i++) {
        this.applyHilite(hilites[i], data);
    }
    this.redrawHilites();
},

getHilite : function (hiliteId) {
    if (isc.isAn.Object(hiliteId)) return hiliteId;

    if (this.hilites == null) return null;
    
    if (!this._hiliteIndex && this.hilites) {
        this._setupHilites(this.hilites);
    }

    var hilite = this._hiliteIndex[hiliteId];

    // try hiliteId as an array index
    if (hilite == null) hilite = this.hilites[hiliteId];

    return hilite;
},


applyHilite : function (hilite, data, fieldName) {
    hilite = this.getHilite(hilite);

    // hilite may be applied in some other way, eg manual calls
    if (!hilite.criteria) return;

    if (hilite.disabled) return;

    var fieldName = fieldName || hilite.fieldName;

    // hilite all fields if no field is specified
    if (fieldName == null) fieldName = this.fields.getProperty("name");

    var matches = this.getDataSource().applyFilter(data, hilite.criteria);

    var fieldNames = isc.isAn.Array(fieldName) ? fieldName : [fieldName];

    if (this.logIsDebugEnabled("hiliting")) {
        this.logDebug("applying filter: " + isc.Comm.serialize(hilite.criteria) + 
                      ", produced matches: " + isc.echoLeaf(matches) +
                      ", on fields: " + fieldNames, "hiliting");
    }

    for (var j = 0; j < fieldNames.length; j++) {
        var field = this.getField(fieldNames[j]);
        for (var i = 0; i < matches.length; i++) {
            var record = matches[i];

            this.hiliteRecord(record, field, hilite);
        }
    }   
},

// TODO: make external version that checks params
hiliteRecord : function (record, field, hilite) {
    var hiliteCount = record[this.hiliteMarker];
    if (hiliteCount == null) hiliteCount = record[this.hiliteMarker] = this._hiliteCount++;

    var fieldHilites = field._hilites = field._hilites || {}, // XXX wipe these in setFields or
                                                              // similar
        existingHilite = fieldHilites[hiliteCount];

    if (existingHilite == null) fieldHilites[hiliteCount] = hilite.id;
    else fieldHilites[hiliteCount] = [existingHilite, hilite.id];
},

getHiliteCSSText : function (hilite) {
    var hilite = this.getHilite(hilite);
    if (!hilite) return;
    // .style is backcompat for old CubeGrid hilites
    return hilite.cssText || hilite.style;
},

_hiliteIterator : [],
addHiliteCSSText : function (record, colNum, cssText) {
    var hiliteCount = record[this.hiliteMarker],
        field = this.getField(colNum);

    if (!field._hilites) return;

    var hiliteIds = field._hilites[hiliteCount];
    if (hiliteIds == null) return;

    //this.logWarn("add hiliteCSS: hiliteCount: " + hiliteCount + 
    //             " on field:" + field.name + ", hiliteIds: " + hiliteIds);

    // convert to Array
    if (!isc.isAn.Array(hiliteIds)) {
        this._hiliteIterator[0] = hiliteIds;
        hiliteIds = this._hiliteIterator;
    }
     
    // multiple hilites apply to cell
    for (var i = 0; i < hiliteIds.length; i++) {
        var hiliteCSSText = this.getHiliteCSSText(hiliteIds[i]);
        if (hiliteCSSText != null) {
            cssText = cssText ? cssText + isc.semi + hiliteCSSText : hiliteCSSText;
        }
    }

    return cssText;
},

addObjectHilites : function (object, cellCSSText, field) {
    if (!this.hilites) return cellCSSText;
    var objArr;
    if (!isc.isAn.Array(object)) {
        this._hiliteIterator[0] = object;
        objArr = this._hiliteIterator;
    }
    
    for (var i = 0; i < objArr.length; i++) {
        var hiliteID, hilite, hiliteCSSText, currObj = objArr[i];
        if (isc.isA.String(currObj)) hiliteID = currObj;
        else hiliteID = (currObj != null ? currObj[this.hiliteProperty] : null);
        // get the hilite object (ENH: could support arrays of multiple hilite objects)
        hilite = this.getHilite(hiliteID);
        if (hilite != null && !hilite.disabled) { // we have a hilite object
            // NOTE: "style" is backcompat
            hiliteCSSText = hilite.cssText || hilite.style;
            // make sure that hilites that spec a fieldName are respected
            var matchesField = (!hilite.fieldName || !field || hilite.fieldName == field.name);
            if (hiliteCSSText != null && hiliteCSSText != isc.emptyString && matchesField) { 
                // we have a hilite style
                if (cellCSSText == null) cellCSSText = hiliteCSSText;
                // NOTE: add a semicolon, even though it may be redundant
                else cellCSSText += this._semicolon + hiliteCSSText;
            }
        }
    }
	return cellCSSText;    
},

//>	@method dataBoundComponent.enableHilite()
// Enable / disable a +link{dataBoundComponent.hilites,hilite}
//
// @visibility external
// @group  hiliting
//
// @param  hiliteID    (string)    ID of hilite to enable
// @param  [enable]    (boolean)   new enabled state to apply - if null, defaults to true
//<
enableHilite : function (hiliteID, enable) {
    if (enable == null) enable = true;
    var hilite = this.getHilite(hiliteID);
    if (hilite == null) return;
    hilite.disabled = !enable;
    // redraw to show hilite / lack of hilite
    this.redrawHilites();
},

//>	@method dataBoundComponent.disableHilite()
// Disable a hilite
//
// @visibility external
// @group  hiliting
//
// @param  hiliteID    (string)    ID of hilite to disable
//<
disableHilite : function (hiliteID) { this.enableHilite(hiliteID, false); },

//>	@method dataBoundComponent.enableHiliting()
// Enable all hilites.
//
// @visibility external
// @group  hiliting
//
// @param  [enable]    (boolean)   new enabled state to apply - if null, defaults to true
//<
enableHiliting : function (enable) {
    if (enable == null) enable = true;
    if (this.hilites) this.hilites.setProperty("disabled", !enable);
    this.redrawHilites();
},

//>	@method dataBoundComponent.disableHiliting()
// Disable all hilites.
//
// @visibility external
// @group  hiliting
//<
disableHiliting : function () { this.enableHiliting(false) },

redrawHilites : function () {
    this.markForRedraw();
},


editHilites : function () {
    if (this.hiliteWindow) {
        this.hiliteEditor.setHilites(this.getHilites());
        this.hiliteWindow.show();
        return;
    }
    var grid = this,
	    hiliteEditor = this.hiliteEditor = isc.HiliteEditor.create({
            autoDraw:false,
            dataSource:this.getDataSource(),
            hilites:this.getHilites(),
            callback:function (hilites) {
                grid.setHilites(hilites);
                grid.hiliteWindow.hide();
            }
        }),
        theWindow = this.hiliteWindow = isc.Window.create({
            autoDraw:true,
            items : [ hiliteEditor ],
            autoSize:true,
            autoCenter:true, isModal:true, showModalMask:true,
            closeClick : function () {
                this.hide();
            },
            title:"Edit Highlights",
            bodyProperties : { layoutMargin:8, membersMargin:8 }
        });
    return theWindow;
},


//
// Drag & Drop
// -----------------------------------------------------------------------------

// These methods are factored up from ListGrid, to make them available to TileGrid.
// They are only applicable to list-type components (as of Oct 2008, ListGrid, TreeGrid 
// and TileGrid).  Although they are here in DataBoundComponent, they also work in the 
// case of non-databound components (as source, target or both).

//> @method dataBoundComponent.transferRecords()
//
// Transfer a list of +link{Record}s from another component (does not have to be a databound
// component) into this component.  This method is only applicable to list-type components,
// such as +link{ListGrid,listGrid}, +link{TreeGrid,treeGrid} or +link{TileGrid,tileGrid}
// <P>
// This method implements the automatic drag-copy and drag-move behaviors of components like
// +link{ListGrid}.
//
// @param dropRecords (Array of Record) Records to transfer to this component
// @param targetRecord (Record) The target record (eg, of a drop interaction), for context
// @param index (integer) Insert point in this component's data for the transferred records
// @param sourceWidget Canvas The databound or non-databound component from which the records
//                            are to be transferred. 
//
// @group dragdrop
// @visibility external
//<
transferRecords : function (dropRecords, targetRecord, index, sourceWidget) {

	// if reordering records from this list
    if (sourceWidget == this) {
    	// slide them into their new home, if no grouping is applied
        
	     if (index != null && !this.isGrouped) this.data.slideList(dropRecords, index);
	} else { 

        var dataSource = this.getDataSource();
        var sourceDS = sourceWidget.getDataSource();
        
        // If we're bound to the same dataSource as the source widget and doing a move, apply
        // an update to the source nodes - by default, changing them to match the current 
        // filter criteria of this grid
        if (dataSource && dataSource == sourceDS && sourceWidget.dragDataAction == isc.ListGrid.MOVE) {
            for (var i = 0; i < dropRecords.length; i++) {
                var record = dropRecords[i];
                isc.addProperties(record, this.getDropValues(record, sourceDS, 
                                          targetRecord, index, sourceWidget));
                this._updateDataViaDataSource(record, sourceDS);                          
            }
        } else {
    		if (!isc.isAn.Array(dropRecords)) dropRecords = [dropRecords];

    		// select the stuff that's being dropped
    		// (note: if selectionType == SINGLE we only select the first record)
            
            if (this.selectionType == isc.Selection.MULTIPLE || 
                this.selectionType == isc.Selection.SIMPLE) 
            {
                this.selection.deselectAll();
                this.selection.selectList(dropRecords);
            } else if (this.selectionType == isc.Selection.SINGLE) {
                this.selection.selectSingle(dropRecords[0]);
            }

            
            if (dataSource) {
                var wasAlreadyQueuing = isc.rpc.startQueue();
                for (var i = 0; i < dropRecords.length; i++) {
                    // groups contain circular references which will hang at clone - skip
                    if (dropRecords[i]._isGroup) continue;
                    var record = isc.clone(dropRecords[i]);
                    isc.addProperties(record, this.getDropValues(record, sourceDS, 
                                            targetRecord, index, sourceWidget));
                    if (dataSource != sourceDS) {
                        // As per existing functionality in TreeGrid, allow the default recategorize-
                        // via-fk functionality to be switched off via the dragRecategorize flag 
                        // (which is not currently exposed)
                        if (this.dragRecategorize) {
                            
                            // If there is a foreign key relationship from the target DS to the 
                            // source DS, populate the foreignKey field on the record we're 
                            // dropping with the contents of the field the foreignKey points to.
                            var fks = dataSource.getForeignKeysByRelation(record, sourceDS);
                            var cannotRecat = false;
                            var pkFields = [];
                            if (sourceDS) pkFields = sourceDS.getPrimaryKeyFields();
                            
                            // If the detected foreignKeyField is a Primary Key, we can't modify it.
                            // Catch this case and log a warning
                            
                            var undef;
                            for (var pk in pkFields) {
                                if (fks[pk] !== undef) {
                                    this.logWarn("ListGrid dragRecategorize: source has dataSource:" 
                                                + sourceDS.getID() + ". foreignKey relationship with " +
                                                "target dataSource " + dataSource.getID() + 
                                                " is based on primary key which cannot be modified.");
                                    cannotRecat = true;
                                }
                            }
                            
                            if (!cannotRecat) {
                                isc.addProperties(record, fks);
                            }
                        }    

                        // If we have explicitly defined titleFields and the target one is not 
                        // going to be populated, populate it with the value in the source one
                        if (dataSource.titleField && sourceDS && sourceDS.titleField && 
                                dataSource.titleField != sourceDS.titleField) {
                            var undef;
                            if (record[dataSource.titleField] === undef) {
                                record[dataSource.titleField] = record[sourceDS.titleField];
                            }
                        }
                    }
                                            
                    this._addIfNotDuplicate(record, sourceDS, fks, null);
                }
                // send the queue unless we didn't initiate queuing
                if (!wasAlreadyQueuing) isc.rpc.sendQueue();
            } else {
                // handle grouping
                if (this.isGrouped) {
                    // add to tree
                    for (var i = 0; i < dropRecords.length; i++) {
                        if (!this._isDuplicateOnClient(dropRecords[i])) {
                            this._addRecordToGroup(dropRecords[i], true);
                            if (index != null) this.originalData.addAt(dropRecords, index);
                            else this.originalData.add(dropRecords);
                        }
                    }
                    // add to originalData
                    if (index != null) this.originalData.addListAt(dropRecords, index);
                    else this.originalData.addList(dropRecords);
                   
                } else {
                    // If we've been passed an index respect it - this will happen if canReorderRecords
                    // is true
                    
                    for (var i = 0; i < dropRecords.length; i++) {
                        if (index != null) {
                            this._addIfNotDuplicate(dropRecords[i], null, null, index);
                            // Because we're adding one-at-a-time, increment the index - otherwise, the 
                            // effect will be to insert into the grid in reverse order
                            index++;
                        } else {
                            this._addIfNotDuplicate(dropRecords[i]);
                        }
                    }  
                }
        		
            }
        }
	}
	
	// unsort if we were sorted and records were just placed at an explicit position
	if (this.canReorderRecords && this._getSortFieldNum() != null) {
		this.unsort();
	}
},

// Helper to update via the dataSource if there are no duplicates (or dups are allowed)
// This method is called as a result of a drag-move, and as such it should not do a PK
// check.  Rather, it should always do a check on the entire record, to see if it 
// already exists in the target grid.  If it does, that is not an error - we should 
// scroll to and/or flash the existing record, rather than alerting an error.
_updateDataViaDataSource : function(record, ds, updateProperties) {
    
    if (!this.preventDuplicates) {
        ds.updateData(record, null, updateProperties); 
        return;
    }
    
    var criteria = this.getCleanRecordData(record);
    
    if (this.data.find(criteria)) {
        // WXX - position to the duplicate record here
    } else {
        // If we have a full cache, we can go ahead and update now
        if (this.data.allMatchingRowsCached()) {
            ds.updateData(record, null, updateProperties);
            } else { 
            // Cache is incomplete, we'll have to ask the server
            ds.fetchData(criteria, 
                         function (dsResponse, data, dsRequest) {
                            if (data && data.length > 0) {
                                // WXX - position to the duplicate record here - we know it isn't 
                                // in the cache, so it's going to cause us some fun...
                            } else {
                                ds.updateData(record, null, updateProperties);
                            }
                        },
                        {sendNoQueue: true});
        }
    }

},

//> IDocument
// Helper to add a record if it is not a duplicate, or duplicates are allowed.
// There are four distinct different types of dup-checking we need to do:
// 1. Source DS is the same as target DS, and it has a primary key
// 2. Source DS is the same as target DS, and it does not have a primary key
// 3. Source and target DS are different, and there is a foreignKey relationship from the
//    target to the source
// 4. Source and target DS are different with no FK relationship, or one or the other of the 
//    grids is not bound to a DS at all
//
// For case (1), if at least one of the PK fields is a sequence, we can allow the update.  If 
// we have no sequence field in the keys, we need to perform a check on PKs and forbid the
// add if there is a duplicate.  On the face of it, this second check is unnecessary - if we 
// have no sequence field, and we're drag/dropping an existing record, it must be a duplicate.
// However, the application code may have overridden drop() and changed the dropped 
// record so that it has unique keys - eg, popped up a dialog asking for a new product code.
//
// For cases (2) and (4), we compare every field in the record (minus properties that ListGrid 
// might have scribbled on, such as _selection_*).  If we get an exact match on every field, 
// that's a duplicate; otherwise, it's OK.  We may have to visit the server for this check.
//
// For case (3), we check if the target list, filtered as it currently is, already contains a 
// record with the same value(s) in its foreignKey field(s) as the record we're proposing to add.
// We may have to visit the server for this check.
//
// Note that this function will work for both ListGrids and TreeGrids; (or indeed for any component
// whose data model is List, Tree, ResultSet or ResultTree); the "folder" parameter
// is only used if the underlying dataset is a Tree or ResultTree.
//< IDocument
_addIfNotDuplicate : function(record, sourceDS, foreignKeys, index, folder) {
    var ds = this.getDataSource(), 
        pks;
        
    if (ds) pks = ds.getPrimaryKeyFields();

    // If the source and target datasource are the same, and we have a PK, and at least one of
    // the PK fields is a sequence, we don't need to check for duplicates because we can assume 
    // the server arranges for a unique value as part of the create process.  This is the only 
    // circumstance in which we have a dataSource but don't need to check the server.  Note that
    // this special case code is duplicated in _isDuplicateOnClient() because that method is 
    // called from other places.
    //
    // Note that we do this special check even before the simple check on this.preventDuplicates
    // because we need special key handling in this circumstance, even if the duplicate check 
    // was going to pass anyway because we haven't set preventDuplicates.
    if (ds && ds == sourceDS) {
        var proceed;
        if (pks && isc.firstKey(pks) != null) {
            for (var field in pks) {
                if (pks[field].type == "sequence") {
                    proceed = true;
                    break;
                }
            }
        }
        
        if (proceed) {
            // Clear the primary key field(s) before calling to the server, otherwise the add 
            // works but we get sent back the original keys and it confuses the client-side
            var undef;
            for (var field in pks) {
                record[field] = undef;
            }
            ds.addData(record);
            return;
        }
    }
    
    if (!this.preventDuplicates) {
        if (ds) {
            ds.addData(record); 
        } else {
            if (isc.Tree && isc.isA.Tree(this.data)) {
                this.data.add(record, folder, index);
            } else {
                if (index != null) this.data.addAt(record, index);
                else this.data.add(record);
            }
        }
        return;
    }        
 
    if (this._isDuplicateOnClient(record, sourceDS, foreignKeys)) {
        isc.warn(this.duplicateDragMessage);
    } else {
        if (!ds) {
            // Simplest case - no DS and no dup on client-side, so go ahead and add the record to
            // the underlying data model
            if (isc.Tree && isc.isA.Tree(this.data)) {
                this.data.add(record, folder, index);
            } else {
                if (index != null) this.data.addAt(record, index);
                else this.data.add(record);
            }
        } else { 
            if (!isc.ResultSet || !isc.isA.ResultSet(this.data)) {
                // Weird.  We have a DataSource but our data model is not a ResultSet.  Since there's no 
                // server to query, we'll just treat the failed client-side dup-search as if it were 
                // authoritative and allow the add.  This is definitely an edge case...
                ds.addData(record);
                return;
            } else {
                // If we're dropping in a grid bound to a DS different from the source DS
                // and the two are related by foreignKey(s) (ie, the fks object is non-null), this is a 
                // different scenario from a normal copy because it's enough to to know that the dropped 
                // item doesn't exist in the current filtered view of this ListGrid.  So, if we have a 
                // complete cache for the current filter criteria, we don't need to query the server.
                // This is not true for other copying scenarios, where we need a complete, unfiltered
                // cache to avoid the server query.
                if (this.data.allRowsCached() || (foreignKeys && this.data.allMatchingRowsCached())) {
                    ds.addData(record);
                    return;
                }
                // We have a dataSource and client-side search failed to find a duplicate.  We need a 
                // server turnaround to know for sure whether we're proposing to add a duplicate
                if (ds && sourceDS == ds) {
                    if (pks && isc.firstKey(pks) != null) {
                        // Source DS and target DS are the same and we have a primary key
                        var criteria = isc.applyMask(record, pks);
                    } else {
                        // Source DS and target DS are the same and we have no primary key
                        criteria = this.getCleanRecordData(record);
                    }
                } else if (foreignKeys) {
                    // Source DS and target DS are different but related via a foreign key
                    criteria = isc.addProperties({}, this.data.getCriteria());
                    isc.addProperties(criteria, foreignKeys);
                } else {
                    // Source DS and target DS are different and unrelated
                    criteria = this.getCleanRecordData(record);
                }
                var _listGrid = this;
                ds.fetchData(criteria, 
                             function (dsResponse, data, dsRequest) {
                                if (data && data.length > 0) {
// WXX - It is possible to get to this point having done a drag-move to a databound grid, where
// the source widget is either not databound, or bound to a different DS, but nevertheless we 
// have managed to establish that there is a duplicate involved - perhaps the dataSources have 
// the same synthetic key field name, or one grid is based on a simple memory array with the 
// same structure as the DS, or something.  What we should really do is detect this occurence
// and scroll to the duplicate row/node; but for now we'll just report it as an error.
                                    isc.warn(_listGrid.duplicateDragMessage);
                                } else {
                                    ds.addData(record);
                                }
                            },
                        {sendNoQueue: true});
            }
        }
    }
},

// Returns true if the passed-in record is a duplicate - according to the rules described in the 
// discussion above _addIfNotDuplicate() - in the currently-known client data.  Handles both
// dataSource and non-dataSource cases.  Note that this function can return false even if the 
// record is a duplicate - for example, if this.preventDuplicates is false.
_isDuplicateOnClient : function (record, sourceDS, foreignKeys) {
    var ds = this.getDataSource(), 
        pks;
    
    if (!this.preventDuplicates) return false;
        
    if (ds) pks = ds.getPrimaryKeyFields();

    // If the source and target datasource are the same, and we have a PK, and at least one of
    // the PK fields is a sequence, we don't need to check for duplicates because we can assume 
    // the server arranges for a unique value as part of the create process.  Note that
    // this logic is duplicated from _addIfNotDuplicate() because this method is called from 
    // other places.
    if (ds && ds == sourceDS) {
        if (pks && isc.firstKey(pks) != null) {
            for (var field in pks) {
                if (pks[field].type == "sequence") {
                    return false;
                }
            }
        }
    }

    if (!ds) {
        // No DS - a duplicate is one that is identical in every property
        var criteria = this.getCleanRecordData(record);
    } else if (ds && sourceDS == ds) {
        if (pks && isc.firstKey(pks) != null) {
            // Source DS and target DS are the same and we have a primary key - compare PK fields
            criteria = isc.applyMask(record, pks);
        } else {
            // Source DS and target DS are the same and we have no primary key - compare all fields
            criteria = this.getCleanRecordData(record);
        }
    } else if (foreignKeys) {
        // Source DS and target DS are different but related via a foreign key - check for a record
        // that matches for the combination of the foreign key values and current filter criteria
        criteria = {};
        var tempCrit = this.data.getCriteria();
        if (tempCrit && tempCrit._constructor != "AdvancedCriteria") {
            var context = this.data.context;
            if (context && (context.textMatchStyle == null || context.textMatchStyle == "exact")) {
                isc.addProperties(criteria, tempCrit);
            }
        }
        isc.addProperties(criteria, foreignKeys);
    } else {
        // Source DS and target DS are different and unrelated
        criteria = this.getCleanRecordData(record);
    }

    if (this.data.find(criteria)) return true;
    else return false;
},

getCleanRecordData : function (record) {
    if (isc.ResultTree && isc.isA.ResultTree(this.data)) {
        return this.data._getCleanNodeData(record, false);
    }
    var clean = {};
    for (var key in record) {
        // These are just the properties that LG scribbles onto its records. If you have others, it's 
        // safe to exclude them in-place below, or just override this method.
        if (key.startsWith("_selection_")) continue;
        
        clean[key] = record[key];
    }
    
    return clean;
},

//> @method dataBoundComponent.getDropValues()
// Returns the "drop values" to apply to a record dropped on this component prior to update.  Only
// applicable to databound grids - see +{dropValues} for more details.  If multiple records 
// are being dropped, this method is called for each of them in turn.
// <P>
// This method returns the following:
// <UL>
// <LI>Nothing, if +{addDropValues} is false</LI>
// <LI>dropValues, if that property is set.  If the grid's criteria object is applicable (as explained
// in the next item), it is merged into dropValues, with properties in dropValues taking precedence.</LI>
// <LI>The grid's criteria object, if the most recent textMatchStyle for the grid was "exact" 
//     and it is simple criteria (ie, not an AdvancedCriteria object)</LI>
// <LI>Otherwise nothing</LI>
// </UL>
// <P>
// You can override this method if you need more complex setting of drop values than can be 
// provided by simply supplying a dropValues object.
// 
// @param record (ListGridRecord) record being dropped
// @param sourceDS (DataSource) dataSource the record being dropped is bound to
// @param targetRecord (ListGridRecord) record being dropped on
// @param index (int) index of record being dropped on
// @param sourceWidget (Canvas) widget where dragging began
// 
// @visibility external
//<
getDropValues : function (record, sourceDS, targetRecord, index, sourceWidget, droppedRecords) {
    if (!this.addDropValues) return;
    
    var criteria = {},
        recordDS;
    
    // At the moment, only trees can contain records (nodes) that have their own dataSource
    if (this.data && this.data.getNodeDataSource) {
        recordDS = this.data.getNodeDataSource(targetRecord);
        
        // getNodeDataSource returns null if you pass the root node in - this appears to be
        // intentional, so we'll cope with it here rather than risk breaking something
        if (!recordDS) {
            recordDS = this.getDataSource();
        }
    }
    
    // Passing the recordDS parameter is only applicable to trees, but does no harm for lists
    if (this.data && this.data.getCriteria) criteria = this.data.getCriteria(recordDS);
   
    var merged;
    if (criteria && criteria._constructor != "AdvancedCriteria") {
        var context = this.data.context;
        if (context && (context.textMatchStyle == null || context.textMatchStyle == "exact")) {
            merged = isc.addProperties({}, criteria);
            if (this.dropValues) {
                merged = isc.addProperties(merged, this.dropValues);
            }    
            return merged;
        }
    }
    
    return this.dropValues;   
}



});

