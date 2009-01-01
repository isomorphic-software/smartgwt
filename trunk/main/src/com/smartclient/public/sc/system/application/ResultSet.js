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

 


//> @type Criteria
// Criteria for selecting only a matching set of records from a DataSource.  Criteria can
// be applied on the client and server.  Unless configured otherwise, criteria will generally
// be applied client-side by +link{ResultSet}s via +link{ResultSet.applyFilter()}.  
// <P>
// Client- and server-side systems built into SmartClient understand two criteria formats by
// default: simple key-value pairs (Criteria) or the +link{AdvancedCriteria} format.
// <P>
// Simple key-value Criteria are represented via a JavaScript Object where each property
// specifies the name and required value for a field.  Multiple legal values for a field can be
// provided as an Array.  For example:
// <pre>
// var criteria = {
//    field1 : "value1",
//    field2 : ["value2", "value3"]
// }
// </pre>
// Would select all records where field1 has value "value1" and where field2 has <i>either</i>
// "value2" or "value3".
// <P>
// When writing custom client and server-side filtering logic, criteria must be a JavaScript
// Object but the properties of that Object can contain whatever data you want.  When sent to
// the SmartClient server, the Java representation of the criteria is described
// +link{rpcRequest.data,here}.  When sent to other servers, the
// +link{type:DSProtocol,operationBinding.dataProtocol} affects the format.
//
// @treeLocation Client Reference/Data Binding
// @see CriteriaPolicy
// @visibility external
//<

//>	@class ResultSet    
// ResultSets are an implementation of the +link{List} interface that automatically fetches 
// DataSource records when items are requested from the List.  ResultSets provide robust,
// customizable, high-performance cache management for ListGrids and other built-in SmartClient
// components, and can be used as cache managers by custom components.
// <P>
// ResultSets manage data paging, that is, loading records in batches as the user navigates
// the data set.  A ResultSet will switch to using client-side sorting and filtering when
// possible to improve responsiveness and reduce server load.  ResultSets also participate in
// automatic cache synchronization, observing operations on DataSources and automatically
// updating their caches.
// <P>
// <b>Creation</b>
// <P>
// A ResultSet can be passed to any component that expects a List, and the List APIs can be
// called directly on the ResultSet as long as the caller is able to deal with asynchronous
// loading; see +link{method:ResultSet.getRange()}.
// <P>
// Generally ResultSets do not need to be created directly, but are created by DataBound
// components as an automatic consequence of calling 
// +link{group:dataBoundComponentMethods,DataBound Component Methods}.  
// For example, the +link{listGrid.fetchData()} causes +link{listGrid.data} to become an
// automatically created <code>ResultSet</code> object.  Automatically created ResultSets
// can be customized via properties on ListGrids such as +link{listGrid.dataPageSize} and
// +link{listGrid.dataProperties}.  All ResultSets for a given DataSource may also be 
// customized via setting +link{dataSource.resultSetClass} to the name of a ResultSet 
// +link{isc.defineClass(),subclass} in which 
// +link{classMethod:class.addProperties,defaults have been changed}.
// <P>
// A ResultSet defaults to using data paging, setting +link{dsRequest.startRow} and
// +link{dsRequest.endRow} in issued dsRequests.  Server code may always return more rows than
// the ResultSet requests and the ResultSet will correctly integrate those rows based on
// +link{dsResponse.startRow}/+link{dsResponse.endRow,endRow}.  
// Hence the server can always avoid paging mode by simply returning all matching rows.
// <P>
// A ResultSet can be created directly with just the ID of a +link{DataSource}:
// <pre>
//     isc.ResultSet.create({
//         dataSource : "<i>dataSourceID</i>"
//     })
// </pre>
// <P>
// Directly created ResultSets are typically used by custom components, or as a means of
// managing datasets that will be used by several components.
// <P>
// When created directly rather than via a dataBoundComponent, a newly created ResultSet will
// not issue it's first "fetch" +link{DSRequest} until data is accessed (for example, via
// +link{resultSet.get,get()}).  
// <P>
// <b>Paging and total dataset length</b>
// <P>
// When using data paging, the server communicates the total number of records that match the
// current search criteria by setting +link{dsResponse.totalRows}.  The ResultSet will then
// return this number from +link{resultSet.getLength,getLength()}, and ListGrids and other
// components will show a scrollbar that allows the user to jump to the end of the dataset
// directly.
// <P>
// However, the ResultSet does not require that the server calculate the true length of the
// dataset, which can be costly for an extremely large, searchable dataset.  Instead, the
// server <i>may</i> simply advertise a <code>totalRows</code> value that is one page larger
// than the last row loaded.  This results in a UI sometimes called "progressive loading",
// where the user may load more rows by scrolling past the end of the currently loaded rows,
// but is not allowed to skip to the end of the dataset.
// <P>
// No client-side settings are required to enable this mode - it is entirely server-driven.
// However, it is usually coupled with +link{listGrid.canSort,disabling sorting}, since
// server-side sorting would also force the server to traverse the entire dataset.
// <P>
// <b>Client-side Sorting and Filtering</b>
// <P>
// If a ResultSet obtains a full cache for the current set of filter criteria, it will 
// automatically switch to client-side sorting, and will also use client-side filtering 
// if the filter criteria are later changed but appear to be <i>more restrictive</i> than the
// criteria in use when the ResultSet obtained a full cache.
// <P>
// The +link{resultSet.useClientSorting,useClientSorting} and 
// +link{resultSet.useClientFiltering,useClientFiltering} flags can be used to disable
// client-side sorting and filtering respectively if these behaviors don't match server-based
// sorting and filtering.  However, because client-side sorting and filtering radically improve
// responsiveness and reduce server load, it is better to customize the ResultSet so that it
// can match server-side sorting and filtering behaviors.
// <P>
// Sorting behavior is primarily customized via the "sort normalizer" passed to
// +link{resultSet.sortByProperty}, either via direct calls on a standalone ResultSet, or via
// +link{listGridField.sortNormalizer} for a ListGrid-managed ResultSet.
// <P>
// By default, client-side filtering interprets the +link{type:Criteria,criteria} passed to
// +link{resultSet.setCriteria,setCriteria()} as a set of field values that records must match
// (similarly to the built-in SQL/Hibernate connectors built into the SmartClient Server).
// Custom client-side filtering logic can be implemented by overriding
// +link{resultSet.applyFilter,applyFilter()}.  Overriding
// +link{resultSet.compareCriteria,compareCriteria()} allows you to control when the ResultSet
// uses client-side vs server-side filtering, and the ResultSet has two default 
// +link{resultSet.criteriaPolicy,criteria policies} built-in.
// <P>
// <b>Updates and Automatic Cache Synchronization</b>
// <P>
// ResultSets observe any successful "update", "add" or "remove" dsRequests against their
// DataSource, regardless of the component that initiated them.  A ResultSet with a full cache
// for the current filter criteria will integrate updates into the cache automatically.
// <P>
// Updated rows that no longer match the current filter criteria will be removed
// automatically.  To prevent this, you can set +link{resultSet.neverDropUpdatedRows}.
// Added rows will similarly be added to the cache only if they match current filter criteria.
// <P>
// Note that the client-side filtering described above is also used to determine whether 
// updated or added rows should be in the cache.  If any aspect of automated cache update is
// ever incorrect, +link{resultSet.dropCacheOnUpdate,dropCacheOnUpdate} can be set for the
// ResultSet or +link{dsResponse.invalidateCache} can be set for an individual dsResponse.
// <P>
// <b>Data Paging with partial cache</b>
// <P>
// When in paging mode with a partial cache, a ResultSet relies on server side sorting, setting 
// +link{dsRequest.sortBy} to the current sort field and direction.  In order for the cache to 
// remain coherant, row numbering must continue to agree between server and client as new
// fetches are issued, otherwise, duplicate rows or missing rows may occur.  
// <P>
// If concurrent modifications by other users are allowed, generally the server should set
// +link{dsResponse.invalidateCache} to clear the cache when concurrent modification is
// detected.
// <P>
// In paging mode with a partial cache, any successful "update" or "add" operation may cause
// client and server row numbering to become out of sync.  This happens because the update
// may affect the sort order, and client and server cannot be guaranteed to match for sets of
// records that have equivalent values for the sort field.
// <P>
// For this reason, after an "add" or "update" operation with a partial cache, the ResultSet
// will automatically mark cache for invalidation the next time a fetch operation is performed.
// Alternatively, if +link{resultSet.updatePartialCache} is set to false, the ResultSet will
// simply invalidate cache immediately in this circumstance.
//
// @see interface:DataBoundComponent
// @see group:dataBoundComponentMethods
// @see DataSource.resultSetClass to customize all ResultSets for a given DataSource
// @see resultSet.getRange() for information on handling asynchronous loading
//
// @implements List
// @treeLocation Client Reference/Data Binding
// @visibility external
//<


isc.ClassFactory.defineClass("ResultSet", null, ["List", "DataModel"]);

isc.ResultSet.addClassProperties({
    // Value returned from resultSet.getLength() if the length of the resultSet is not
    // yet known (because we're still fetching data from the server).  Note that the correct
    // way to check for this is resultSet.lengthIsKnown(), not checking for this constant,
    // which could fail.
    UNKNOWN_LENGTH : 1000
    
    
});

isc.ResultSet.addProperties({

	//localData : null, // the cache of rows
	//totalRows : isc.ResultSet.UNKNOWN_LENGTH, // total number of rows in the filtered results
	cachedRows : 0, // numbers of rows we have cached

    // Fetching
	// ----------------------------------------------------------------------------------------

    // whether to fetch rows beyond those requested
	fetchAhead : true,

	//>	@type	FetchMode
    // Mode of fetching records from the server.
    // <P>
    // Generally, "paged" mode should be used unless the maximum number of records is
    // guaranteed to be small.
    //
    // @value "basic" All records that match the current filter are fetched.  Sorting is
    //                performed on the client
    // @value "paged" Only requested ranges of records are fetched, with predictive fetch
    //                ahead.  Sorting is performed on the server.
    // @value "local" All records available from the DataSource are fetched.  Filtering by
    //                search criteria and sorting are both performed on the client
    // @group fetching
	// @visibility external
    //<

    //> @attr resultSet.fetchMode (FetchMode : null : IRA)
    // Mode of fetching records from the server. If unset, will default to <code>"local"</code>
    // if +link{resultSet.allRows} is specified, otherwise <code>"paged"</code>.
    //
    // @see type:FetchMode
    // @group fetching
    // @visibility external
    //<
    //fetchMode : "paged",
    
    //> @attr resultSet.initialData (Array of Record : null : IA)
    // Initial set of data for the ResultSet.
    // <P>
    // This data will be treated exactly as though it were the data returned from the
    // ResultSet's first server fetch.
    // <P>
    // By default, <code>initialData</code> will be considered a complete response
    // (all rows that match the +link{criteria} which the ResultSet was initialized with).
    // <P>
    // Set +link{initialLength} to treat <code>initialData</code> as a partial response,
    // equivalent to receiving a +link{DSResponse} with <code>startRow:0</code>,
    // <code>endRow:initialData.length</code> and <code>totalRows:initialLength</code>.
    // Normal data paging will then occur if data is requested for row indices not filled via 
    // <code>initialData</code>.
    //
    // @group fetching, cacheSync
    // @visibility external
    //<

    //> @attr resultSet.initialLength (integer : null : IA)
    // Initial value of the data set length.
    // <P>
    // To create a ResultSet with it's cache partly filled, see +link{initialData}.
    //
    // @group fetching, cacheSync
    // @visibility external
    //<

    //> @attr   resultSet.allRows   (Array of records : null : IA)
    // If the complete set of records for a resultSet is available when the resultSet is created,
    // it can be made available to the resultSet via this property at initialization time.
    // This data will then be considered cached meaning sorting and filtering can occur on
    // the client (no need for server fetch).
    // This cached data can be dropped via a call to +link{resultSet.invalidateCache()}.
    // @group fetching, cacheSync
    // @visibility external
    //<

    //> @attr resultSet.resultSize (integer : 75 : IRWA)
    // How many rows to retrieve at once.
    // <P>
    // Applicable only with <code>fetchMode: "paged"</code>.  When a paged ResultSet is asked
    // for rows that have not yet been loaded, it will fetch adjacent rows that are likely to
    // be required soon, in batches of this size.
    //
    // @group fetching
    // @visibility external
    //<
	resultSize : 75,

    //> @attr resultSet.fetchDelay (integer : 0 : IRWA)
    // Delay in milliseconds before fetching rows.
    // <P>
    // When a get() or getRange() call asked for rows that haven't been loaded, the
    // ResultSet will wait before actually triggering the request.  If, during the delay, more
    // get() or getRange() calls are made for missing rows, the final fetch to the server will
    // reflect the most recently requested rows.
    // <P>
    // The intent of this delay is to avoid triggering many unnecessary fetches during
    // drag-scrolling and similar user interactions.
    //
    // @group fetching
    // @visibility external
    //<
	fetchDelay : 0,

    // DataModel
	// ---------------------------------------------------------------------------------------
    //> @attr resultSet.dataSource (DataSource or ID : null : IR)
    //  What +link{class:DataSource} is this resultSet associated with?
    // @include dataModel.dataSource
    // @visibility external
    //<

    //> @attr resultSet.fetchOperation (Operation or ID : null : IR)
    // @include dataModel.fetchOperation
    // @visibility external
    //<

    //> @attr resultSet.context (DSRequest Properties : null : IRA)
    // Request properties for all operations performed by this ResultSet
    //<

    //> @type CriteriaPolicy
    // @value "dropOnChange"        Cache is dropped whenever criteria changes.
    // @value "dropOnShortening"    Cache is retained as along as the only changes to criteria
    //                              are lengthening of criteria values for known, String-valued
    //                              DataSource fields, or the addition of fields that weren't
    //                              present before.
    // @visibility external
    //<
    
    //> @attr resultSet.criteria (Criteria : null : IRW)
    // Filter criteria used whenever records are retrieved.
    // <P>
    // Use +link{setCriteriai()} to change the criteria after initialization.
    // @visibility external
    //<
    
    //> @attr resultSet.criteriaPolicy (CriteriaPolicy : null : IRWA)
    // Decides under what conditions the cache should be dropped when the +link{criteria}
    // changes.
    // @see criteria
    // @see dataSource.criteriaPolicy
    // @visibility external
    //<

    // Local Operations
	// ----------------------------------------------------------------------------------------

    //> @attr resultSet.useClientSorting (boolean : true : IRWA)
    // Whether to sort data locally when all records matching the current criteria have been
    // cached.
    // <P>
    // This may need to be disabled if client-side sort order differs from server-side sort
    // order in a way that affects functionality or is surprising.
    // 
    // @visibility external
    //<
    useClientSorting: true,
    shouldUseClientSorting : function () {
        //>Offline
        if (!isc.RPCManager.onLine) return true;
        //<Offline
        return this.useClientSorting;
    },    

    //> @attr resultSet.useClientFiltering (boolean : true : IRWA)
    // Whether to filter data locally when all DataSource records have been loaded (that is,
    // criteria is blank and cache is complete).
    // <P>
    // This may need to be disabled if client-side filtering differs from server-side filtering
    // in a way that affects functionality or is surprising.
    // <P>
    // This setting is distinct from <code>fetchMode:"local"</code>, which explicitly loads all
    // available DataSource records up front.
    // <P>
    // See +link{resultSet.applyFilter()} for default filtering behavior.
    // <P>
    // <b>NOTE:</b> even with useClientFiltering false, client-side filtering will be used
    // during cache sync to determine if an updated or added row matches the current criteria.
    // To avoid relying on client-side filtering in this case, either:<br>
    // - avoid returning update data when the updated row doesn't match the current filter<br>
    // - set dropCacheOnUpdate<br>
    //
    // @visibility external
    //<
    useClientFiltering:true,
    shouldUseClientFiltering : function () {
        //>Offline
        if (!isc.RPCManager.onLine) return true;
        //<Offline
        return this.useClientFiltering;
    },

    // Caching
	// ----------------------------------------------------------------------------------------

    //> @attr resultSet.updateCacheFromRequest (boolean : true : IRA) 
    // When a successful Add, Update or Remove type operation fires on this ResultSet's 
    // dataSource, if +link{dsResponse.data} is unset, should we integrate the submitted
    // data values (from the request) into our data-set?
    //
    // @group cacheSync
    // @visibility external
    //<
    updateCacheFromRequest:true,
    
    //> @attr resultSet.dropCacheOnUpdate (boolean : false : IRA)
    // Whether to discard all cached rows when a modification operation (add, update, remove)
    // occurs on the ResultSet's DataSource.
    // <P>
    // A ResultSet that has a complete cache for the current filter criteria can potentially
    // incorporate a newly created or updated row based on the data that the server returns
    // when a modification operation completes.  However this is not always possible for
    // ResultSets that show some types of joins, or when the server cannot easily return update
    // data.  In this case set <code>dropCacheOnUpdate</code> to cause the cache to be
    // discarded when an update occurs.
    // <P>
    // <code>dropCacheOnUpdate</code> can be set either directly on a ResultSet, or on a
    // DataSource in order to affect all ResultSets on that DataSource.
    //
    // @group cacheSync
    // @visibility external
    //<

    //> @attr resultSet.dropCacheOnLengthChange (boolean : true : IRA)
    // Whether to discard all cached rows when the server reports a change in the number of
    // total rows.
    // @group cacheSync
    // @visibility internal
    //<
    // Not yet implemented:
    // <P>
    // This works as a simple form of cache staleness detection if the server is not capable of
    // supporting the more sophisticated <code>cacheTimestamp</code> mechanism.
    //
    // @see attr dsResponse.cacheTimestamp
    
    //> @attr   resultSet.disableCacheSync (boolean : false : IRA)
    // By default when the data of this ResultSet's dataSource is modified, the ResultSet will
    // be updated to display these changes.
    // Set this flag to true to disable this behavior.
    // @group cacheSync
    // @visibility external
    //<
    // Note: This can be set to false after init, but if already false, setting to true would
    // lead to unpredictable results as we'd be attempting to integrate changes into a possibly
    // out of date cache

    //> @attr   resultSet.neverDropUpdatedRows (boolean : false : IRA)
    // By default when a a row is returned by the server, the current +link{setCriteria,filter
    // criteria} are applied to it, and it may disappear from the cache.
    // <P>
    // Set this flag to true to disable this behavior.
    // @group cacheSync
    // @visibility external
    //<
    shouldNeverDropUpdatedRows : function () {
        //>Offline
        if (!isc.RPCManager.onLine) return true;
        //<Offline
        return this.neverDropUpdatedRows;
    },

    //> @attr   resultSet.updatePartialCache (boolean : true : IRA)
    // If set to true, updated and added rows will be integrated into the client-side cache
    // even if paging is enabled and cache is partial.  If <code>updatePartialCache</code> is
    // false, the cache will be invalidated and new data fetched.
    // <P>
    // If updatePartialCache is enabled and an "add" or "update" operation succeeds with a partial
    // cache:
    // <ul>
    // <li> updated rows will remain in their current position.  No attempt will be made to sort
    // them into a new position even if the sort field was updated.
    // <li> newly added rows will be added at either the end (first preference) or beginning of
    // the dataset if that part of the dataset is cached and was most recently requested.
    // If not, the new row is added at the end of the most recently requested contiguously
    // cached range
    // </ul>
    // The cache will then be dropped the next time rows are fetched, to prevent problems with
    // inconsistent row numbering between the server and client, which could otherwise lead to
    // duplicate rows or rows being skipped entirely.
    //
    // @group cacheSync
    // @visibility external
    //<
    
    updatePartialCache:true,
    shouldUpdatePartialCache : function () {
        //>Offline
        if (!isc.RPCManager.onLine) return true;
        //<Offline
        return this.updatePartialCache;
    }
});

isc.ResultSet.addMethods({

init : function () {
	// get a global ID so we can be called in the global scope
	isc.ClassFactory.addGlobalID(this);
    //>!BackCompat 2004.7.30
    // custom operation for fetching passed in as just "operation"
    if (this.operation != null) this.fetchOperation = this.operation;
    //<!BackCompat

    // get the fetchOperation since several ResultSet-related settings are legal on it.
    // NOTE: order depedency: if we were passed an operation, getOperation() will return it
    // without looking at this.dataSource, so we can use that operation to automatically derive
    // the dataSource.  Otherwise, if not passed an operation, we require this.dataSource, and
    // getOperation will derive an operation from it.
    var fetchOperation = this.getOperation("fetch");

    // if fetchOperation is an explicitly defined operation, operation.dataSource may be a list
    // of DataSources
    var dsNames = fetchOperation.dataSource;
    if (!isc.isAn.Array(dsNames)) dsNames = [dsNames];
    for (var i = 0; i < dsNames.length; i++) {
        var ds = isc.DS.get(dsNames[i]);
        // observe dataChanged for cache synch
        this.observe(ds, "dataChanged", "observer.dataSourceDataChanged(dsRequest,dsResponse)");

        // keep track of the datasources we've registered with so we can deregister on destroy()
        if (!this._registeredDS) this._registeredDS = [];
        this._registeredDS.add(ds);

        // support automatically deriving the DataSource from the operation (take the first
        // DataSource listed if more than one)
        if (!this.dataSource) this.dataSource = ds;
    }
    
	// context.dataPageSize may be set if specified on a DataBoundComponent that created us
    var context = this.context;
    this.resultSize = (context && context.dataPageSize != null ?
                        context.dataPageSize : this.resultSize);

    // whether to invalidate our cache when an update occurs on one of our datasources.
    // Default is update the current cache in place.
    if (this.dropCacheOnUpdate == null) {
        this.dropCacheOnUpdate = this._firstNonNull(fetchOperation.dropCacheOnUpdate,
                                                    this.getDataSource().dropCacheOnUpdate);
    }
    
	this.context = this.context || {};

    // backcompat for old name for criteria: "filter"
    this.criteria = this.criteria || this.filter || {};
    if (this.criteria) {
        var newCriteria = this.criteria;
        this.criteria = null;
        this.setCriteria(newCriteria);
    }

    // if we're given the set of all rows on construction, derive the current filter set right
    // away, so that this.localData is not null, making us think we have no data
    if (this.fetchMode == null) this.fetchMode = (this.allRows ? "local" : "paged");
    if (this.allRows != null && (this.isLocal() || this.shouldUseClientFiltering()) && 
        this.localData == null) 
    {
        this.filterLocalData();
    }
    
    // support for seeding a ResultSet with data on init
    if (this.initialData) {
        this.fillCacheData(this.initialData);
        this.setFullLength(this.initialLength || this.totalRows || this.initialData.length);
    } else if (this.isPaged()) {
        this.localData = [];
    }

    //>Offline
    this.observe(isc, "goOffline", this.getID()+".goOffline()");
    this.observe(isc.RPCManager, "offlineTransactionPlaybackComplete", this.getID()+".offlinePlaybackComplete()");
    //<Offline
},

//>Offline
goOffline : function () {

},

offlinePlaybackComplete : function () {
    if (this.haveOfflineRecords) {
        this.invalidateCache();
        this.haveOfflineRecords = false;
    }
},
//<Offline

// de-register from related DataSources on destroy() to prevent leaks
destroy : function () {
    
	// remove the window.ID pointer to us.  NOTE: don't destroy the global variable if it no longer
    // points to this instance (this might happen if you create a new instance with the same ID)
    if (window[this.ID] == this) window[this.ID] = null;
    //>Offline
    this.ignore(isc, "goOffline");
    this.ignore(isc.RPCManager, "offlineTransactionPlaybackComplete");
    //<Offline

    if (!this._registeredDS) return;
    for (var i = 0; i < this._registeredDS.length; i++) {
        var ds = this._registeredDS[i];
        if (ds) {
            // clear up observations
            this.ignore(ds, "dataChanged");
        }
    }
},    

isPaged : function () { return this.fetchMode == "paged" },
isLocal : function () { return this.fetchMode == "local" },
//> @method ResultSet.allMatchingRowsCached() [A]
// Do we have a complete client-side cache of records for the current filter criteria?
// <P>
// Returns false if this is a paged data set, and the entire set of records that match
// the current criteria has not been retrieved from the server.
// @visibility external
//<
allMatchingRowsCached : function () {
    // data has been loaded, and if paged, cache is full for current filter
    return (this.localData != null &&
            (!this.isPaged() || 
             
             (this.allRows != null ||(this.cachedRows == this.totalRows))));
},

//> @method ResultSet.allRowsCached() [A]
// Do we have a complete client-side cache of all records for this DataSource?
// <P>
// Becomes true only when the ResultSet obtains a complete cache after a fetch with empty
// criteria.
//
// @visibility external
//<
allRowsCached : function () {
    return (
            // - in fetchMode:"local" (load all data up front), data has been successfully
            //   loaded
            (this.allRows != null && (!this.allRowsCriteria || this._emptyAllRowsCriteria)) 
            || 
            // - in other modes, we've detected emptyCriteria and full cache
            (this.allMatchingRowsCached() && this._emptyCriteria)
        );
},
isEmpty : function () {
    if (this.isPaged()) {
        // If there's a full cache for the current filter criteria, check the length of the data
        if (this.allMatchingRowsCached()) {
            return this.getLength() == 0;
        // For a paged dataSet, the cachedRows attribute indicates we have successfully 
        // fetched rows from the server (so this is non empty)
        } else if (this.cachedRows > 0) return false;
    }
    
    return !this.lengthIsKnown() || this.getLength() <= 0;
},
canSortOnClient : function () { return this.shouldUseClientSorting() && (this.allMatchingRowsCached()||isc.isOffline()) },
canFilterOnClient : function () { return this.shouldUseClientFiltering() && this.allRowsCached() },

//> @method resultSet.getValueMap()
// Get a map of the form <code>{ item[idField] -&gt; item[displayField] }</code>, for all 
// items in the list.  If more than one item has the same <code>idProperty</code>, 
// the value for the later item in the list will clobber the value for the earlier item.
// <P>
// If this method is called when the +link{allMatchingRowsCached(),cache is incomplete}, it
// will trigger fetches, and will return a valueMap reflecting only the currently loaded rows.
//
// @param idField (string)  Property to use as ID (data value) in the valueMap
// @param displayField (string) Property to use a display value in the valueMap
// @return (object) valueMap object
// @see resultSet.allMatchingRowsCached()
// @visibility external
//<
// picked up as part of the list interface


// List API
// --------------------------------------------------------------------------------------------

//> @method resultSet.getLength()
// Return the total number of records that match the current filter criteria.
// <P>
// This length can only be known, even approximately, when the first results are retrieved from
// the server.  Before then, the ResultSet returns a large length in order to encourage viewers
// to ask for rows.  +link{lengthIsKnown(),ResultSet.lengthIsKnown()} can be called to
// determine whether an actual length is known.
//
// @include List.getLength()
// @visibility external
//<

getLength : function () {

    var unknownLength = this.unknownLength || isc.ResultSet.UNKNOWN_LENGTH;
    if (!this.lengthIsKnown()) return unknownLength;
    // NOTE: when paged, if we obtain a full cache with empty criteria, we set allRows to the
    // full cache and go into local filtering mode (if enabled).  From then on, totalRows,
    // normally set based on server responses, is no longer up to date.
    return (this.isPaged() && !this.allRows ? this.totalRows
                                            : this.localData.length);
},

//> @method resultSet.indexOf()
// Return the position in the list of the first instance of the specified object.
// <p>
// If pos is specified, starts looking after that position.
// <p>
// Returns -1 if not found.
// <p>
// <b>NOTE:</b> ResultSet.indexOf() only inspects the current cache of records, so it is only
// appropriate for temporary presentation purposes.  For example, it would not be appropriate
// to hold onto a record and attempt to use indexOf() to determine if it had been deleted.
//
// @include List.indexOf()
//<
indexOf : function (item, pos, endPos) {
    if (this.localData == null) return -1;

    // ignore LOADING rows
    if (Array.isLoading(item)) return -1;

    var index = this.localData.indexOf(item, pos, endPos);
    if (index != -1) return index;

    // if not found, try lookup by primary key.  The caller has an object presumably previously
    // retrieved from this ResultSet, but because we drop cached rows in various circumstances,
    // the row may either have fallen out of cache (eg different sort order) or been replaced
    // by a new row with different object identity. 
    // NOTE: primarily this is called by Selection and selection-related code, because of it's
    // strategy of putting marker properties onto records.
	return this.getDataSource().findByKeys(item, this.localData, pos, endPos);
},


// XXX ignore slideList, which is called on D&D reorder in ListGrids.  
// To support this properly we should either:
// - support unsort(): correctly manage the fact that our order temporarily doesn't reflect
//   current sort
// - support permanent stored orders: if our DS declares that some field represents a permanent
//   stored order, and we are currently sorted by that field, assume the user means to
//   permanently reorder the record, and save changed field numbers
slideList : function (selection, startIndex) { return; },

//>	@method		resultSet.get()
// Returns the record at the specified position.
// <P>
// All List access methods of the ResultSet have the semantics described in <code>getRange()</code>.
// @include list.get()
// @see getRange()
//<
get : function (pos) {
	if (pos < 0) {
		//>DEBUG
		this.logWarn("get: invalid index " + pos); 
		//<DEBUG
		return null;
	}

	// optimization: what getRange(pos, pos+1) would do, only we can do it faster: if the
    // requested row is non-null, it's either cached or loading, so return it
	if (this.localData != null && this.localData[pos] != null) return this.localData[pos];
    // if this request falls within the rows we are already planning to fetch, likewise return
    // the loading marker (we don't actually put the loading marker into this.localData until
    // the fetch request is sent to the server).
    
    if (this.fetchStartRow != null && pos >= this.fetchStartRow && pos <= this.fetchEndRow) {
        return Array.LOADING;
    }

	return this.getRange(pos, pos+1)[0];
},

//>	@method		resultSet.getRange()
// Return the items between position start and end, non-inclusive at the end, possibly 
// containing markers for records that haven't loaded yet.
// <P>
// Calling getRange for records that have not yet loaded will trigger an asynchronous fetch.  The
// returned data will contain the marker value <code>Array.LOADING</code> as a placeholder for
// records being fetched.  If any rows needed to be fetched, <code>dataArrived()</code> will
// fire when they arrive.
//
// @include list.getRange()
// @see classAttr:Array.LOADING
// @see dataArrived()
// @visibility external
//<
getRange : function (start, end, ignoreCache, fetchNow) {
    if (isc._traceMarkers) arguments.__this = this;
    
    // If end is null, assume its start+1 - just fetch the start row.
    if (start == null) {
        this.logWarn("getRange() called with no specified range - ignoring.");
        return;
    }
    if (end == null) end = start+1;
    
    if (this.isPaged()) {
        return this._getRangePaged(start, end, ignoreCache, fetchNow);
    }

	if (this.localData == null) {
		this.localData = [];
        // fetch the entire data-set
        
        var criteria = this.getServerFilter();
		this.setRangeLoading(start, end);
		this.fetchRemoteData(criteria);
	}
	return this.localData.slice(start, end);
},

getAllRows : function () {
    if (!this.lengthIsKnown()) return [];
    return this.getRange(0, this.getLength());
},

getAllLoadedRows : function () {
    if (!this.lengthIsKnown()) return [];
    var rows = [];
    for (var i = 0; i < this.getLength(); i++) {
        if (this.rowIsLoaded(i)) rows.add(this.localData[i]);
    }
    return rows;
},

// called by grids, allows dynamic derivation of values.  Used in order to allow a ResultSet to
// use a set of XML elements as its dataset.
// "field" is the optional field descriptor used in the visual component. 
getFieldValue : function (record, fieldName, field) {
    return this.getDataSource().getFieldValue(record, fieldName, field);
},

// Retrieving rows
// --------------------------------------------------------------------------------------------

//> @method resultSet.lengthIsKnown()
// Whether the ResultSet actually knows how many records are available from the server.
// The ResultSet will not know how many records are available when initially fetching and 
// filtering data. Note that the value returned from +link{resultSet.getLength()} will be 
// an arbitrary, large value if the actual length is not known.
// @return (boolean) whether length is known
// @visibility external
//<
lengthIsKnown : function () {
    // for a paged RS, totalRows remains null until you call setFullLength()
    // for a local or basic RS we never know the total length until fetch() returns
    return this.localData != null && (this.isPaged() ? this.totalRows != null : 
                                                       this._fetchingRequest == null);
},

//> @method resultSet.rowIsLoaded() [A]
// Whether the given row has been loaded.
// <p>
// Unlike get(), will not trigger a server fetch.  
//
// @param   rowNum  (number)   row to check
// @return (boolean) true whether if the given row has been loaded, false if it has not been
//                   loaded or is still in the process of bring loaded
// @visibility external
//<
rowIsLoaded : function (rowNum) {
    if (this.localData != null) {
        var row = this.localData[rowNum];
        if (row != null && !Array.isLoading(row)) return true;
    }
    return false;
},

//> @method resultSet.rangeIsLoaded() [A]
// Whether the given range of rows has been loaded.
//
// Unlike getRange(), will not trigger a server fetch.  
//
// @param   startRow (number)   start position, inclusive
// @param   endRow   (number)   end position, exclusive
// @return (boolean) true if all rows in the given range have been loaded, false if any rows in
//                   the range have not been loaded or are still in the process of being loaded
// @visibility external
//<
rangeIsLoaded : function (startRow, endRow) {
    if (this.localData == null) return false;
    for (var i = startRow; i < endRow; i++) {
        var row = this.localData[i];
        if (row == null || Array.isLoading(row)) return false;
    }
    return true;
},

// get the index of the last cached row after rowNum, or null if rowNum itself is not cached.
// "reverse" parameter searches backwards
findLastCached : function (rowNum, reverse) {
    if (!this.rowIsLoaded(rowNum)) return null;
    
    if (reverse) {
        for (var i = rowNum; i >= 0; i--) {
            var row = this.localData[i];
            if (row == null || Array.isLoading(row)) break;
        }
        return i + 1;
    } else {
        var length = this.getLength();
        for (var i = rowNum; i < length; i++) {
            var row = this.localData[i];
            if (row == null || Array.isLoading(row)) break;
        }
        return i - 1;
    }
},

// get the index of the first and last cached row around rowNum, or null if rowNum itself is
// not cached.
getCachedRange : function (rowNum) {
    // default to the last requested range, or zero
    if (rowNum == null) rowNum = this.lastRangeStart;
    if (rowNum == null) rowNum = 0;
    // no cache around this row
    if (!this.rowIsLoaded(rowNum)) return null;
    var length = this.getLength();
    if (this.allMatchingRowsCached()) return [0, length-1];

    var startIndex = this.findLastCached(rowNum, true),
        endIndex = this.findLastCached(rowNum);

    return [startIndex, endIndex];
},

//>	@method	resultSet.setRangeLoading() 
// Initializes null data in the specified range to Array.LOADING
//		
//		@param	start	(number)	start position
//		@param	end		(number)	end position
// @visibility internal
//<
setRangeLoading : function (start, end) {
	for (var i = start; i < end; i++) {
		if (this.localData[i] == null) this.localData[i] = Array.LOADING;
	}
},

// given an array, set all null values to the "loading" marker and fill out the array to the
// length specified.
fillRangeLoading : function (arr, length) {
    for (var i = 0; i < length; i++) {
        if (arr[i] == null) arr[i] = Array.LOADING;
    }
    return arr;
},

getServerFilter : function () {
    // local mode: no server-side filtering
    if (this.isLocal()) return null;
    return this.criteria;
},

// clear the fetch timer and explicitly pass start and end row to provide a clean entry point
// for the overrideable fetchRemoteData
_fetchRemoteData : function () {
    var startRow = this.fetchStartRow,
        endRow = this.fetchEndRow;

    // this indicates that a timer was set to do a fetch, but then an immediate fetch (no fetch
    // delay) occurred
    if (startRow == null || endRow == null) return;
    
    // now that we're definitely going to fetch the data, insert loading markers into the local
    // cache so that we don't issue fetch requests on any rows we're already fetching.
    this.setRangeLoading(startRow, endRow);
    this.fetchStartRow = null;
    this.fetchEndRow = null;

	//>DEBUG
	this.logInfo("fetching rows " + [startRow, endRow] + " from server"); //<DEBUG

    return this.fetchRemoteData(this.getServerFilter(), startRow, endRow);

},

//>	@method	resultSet.fetchRemoteData() [A]
// Retrieve a range of rows from the server.
// <P>
// Override to provide your own implementation of data retrieval.  Use fillCacheData() and
// setFullLength() to manipulate the cache once rows are retrieved.
// <P>
// Implementer is expected to return <b>all</b> requested rows.  fetchRemoteData() may ask for
// more rows than the current totalRows; if not enough rows are available, setFullLength()
// should be called to trim to the appropriate size.
//		
// @see setFullLength()
// @see fillCacheData()
//
//		@param serverCriteria (Criteria)	criteria to be applied by server
//		@param startRow	      (number)	    startRow position
//		@param endRow	      (number)	    endRow position
// @visibility customResultSet
//<
_requestIndex:0,
fetchRemoteData : function (serverCriteria, startRow, endRow) {
    //>Offline
    if (isc.isOffline()) {
        // save a marker that we have offline records so we can invalidateCache() when
        // we go online
        this.haveOfflineRecords = true;
        return;
    }
    //<Offline

    this._requestIndex += 1;
    var clientContext;

    if (this.context && this.context.clientContext) {
        this.context.clientContext.requestIndex = this._requestIndex;
    } else {
        clientContext = {requestIndex: this._requestIndex};            
    }
    var requestProperties = isc.addProperties({
        operation : this.getOperationId("fetch"),
        startRow : startRow,
        endRow : endRow,
        sortBy : this._serverSortBy,
        resultSet : this,
        clientContext : clientContext,
        // so that we don't get wedged in a loading state
        willHandleError:true
    }, this.context)

    // if cache was partially updated before, invalidate the cache
    if (this.rowOrderInvalid()) {
        this.logInfo("invalidating rows on fetch due to 'add'/'update' operation " +
                     " with updatePartialCache");
        this.invalidateRows();
    }
 
    if (this.logIsDebugEnabled("fetchTrace")) {
        this.logWarn("ResultSet server fetch with server criteria: " +
                     isc.Comm.serialize(serverCriteria, true) + this.getStackTrace());
    }

    this.getDataSource().fetchData(serverCriteria, 
                 {caller:this, methodName:"fetchRemoteDataReply"}, 
                 requestProperties);
    // For local filtering, we fetch every row in the dataSet once (and filter the results)
    // for basic filtering we re-fetch when criteria change.
    // In either case the total number of rows that match the filter criteria will be unknown 
    // until the fetch returns.
    // This differs from paged resultSets where we track total size via the totalLength
    // flag (and a fetch doesn't necessarily mean a complete dataSet refresh).
    // Set a flag so lengthIsKnown() can detect when we're loading rows.
    if (!this.isPaged()) this._fetchingRequest = this._requestIndex;
    

},

fetchRemoteDataReply : function (dsResponse, data, request) {

    
    var index = dsResponse.clientContext.requestIndex;
    if (!this._lastProcessedResponse) this._lastProcessedResponse = 0;
    if (index != (this._lastProcessedResponse+1)) {
        this.logInfo("server returned out-of-sequence response for fetch remote data request " +
                " - delaying processing: last processed:"+ this._lastProcessedResponse + ", returned:"+ index);
        if (!this._outOfSequenceResponses) this._outOfSequenceResponses = [];
        this._outOfSequenceResponses.add({dsResponse:dsResponse, data:data, request:request});
        return;
    }
    // Clear the fetchingRequest flag if we're a non-paged resultSet
    if (!this.isPaged() && this._fetchingRequest == index) delete this._fetchingRequest;
    
    var newData;
    // if the fetch failed, clear our 'loading' marker, and then send over to RPCManager
    // to do normal error handling
    if (dsResponse.status < 0 || dsResponse.offlineResponse) {
        newData = [];
    } else {
        newData = dsResponse.data
    }
    
    var numResults = newData.length;

    
    this.document = dsResponse.document;
    
	//>DEBUG
	this.logInfo("Received " + numResults + " records from server");
	//<DEBUG
  
    // if the server did not specify startRow, assume startRow is what
    // was asked for
    if (dsResponse.startRow == null) dsResponse.startRow = request.startRow;

    // if the server did not specify an endRow, assume endRow is startRow + number of
    // records returned.
    if (dsResponse.endRow == null) dsResponse.endRow = dsResponse.startRow + numResults;

    // if the server did not specify totalRows, but the resulting endRow is less than what we
    // asked for, then we know the server has no more rows, clamp totalRows to endRow
    if (dsResponse.totalRows == null && dsResponse.endRow < request.endRow)
        dsResponse.totalRows = dsResponse.endRow;

    // opportunity to transform data from the server
    if (this.transformData) {
        var result = this.transformData(newData, dsResponse);
        // handle failure to return the untransformed data
        newData = result != null ? result : newData;
        if (newData.length != numResults) {
	        this.logInfo("Transform applied, " + newData.length + 
                         " records resulted, from " + dsResponse.startRow + 
                         " to " + dsResponse.endRow);
            // update endRow
            dsResponse.endRow = dsResponse.startRow + newData.length;
            // totalRows may also need to be adjusted here, but just fall through to the generic
            // clamp below
        }
    }

    if (!isc.isA.List(newData)) {
        this.logWarn("Bad data returned, ignoring: " + this.echo(newData));
        return;
    }

    // If the server returned an endRow past the end of the list, warn and clamp 
    // dsResponse.endRow to the end of the list so dataArrived etc are passed the correct 
    // info on the last loaded row
    
    if (dsResponse.totalRows != null && dsResponse.totalRows < dsResponse.endRow) {
        this.logWarn("fetchData callback: dsResponse.endRow set to:" + dsResponse.endRow + 
                     ". dsResponse.totalRows set to:" + dsResponse.totalRows +
                     ". endRow cannot exceed total dataset size. " +
                     "Clamping endRow to the end of the dataset (" + dsResponse.totalRows + 
                     ").");
        dsResponse.endRow = dsResponse.totalRows;
    }
    
    // NOTE: transformData is allowed to modify results.startRow/endRow/totalRows
    var startRow = dsResponse.startRow,
        endRow = dsResponse.endRow;

    this._startDataArriving();
    // incorporate new data into the cache
    this._handleNewData(newData, dsResponse);
    this._doneDataArriving(startRow, endRow);
    
    
    
    delete this.context.afterFlowCallback;
    
    this._lastProcessedResponse = index;
    if (this._outOfSequenceResponses && this._outOfSequenceResponses.length > 0) {
        for (var i = 0; i < this._outOfSequenceResponses.length; i++) {
            var reply = this._outOfSequenceResponses[i];
            if (reply == null) continue;

            var requestIndex = reply.dsResponse.clientContext.requestIndex;
            if (requestIndex == this._lastProcessedResponse +1) {
                this.logInfo("Delayed out of sequence data response being processed now " + 
                             requestIndex);
                this._outOfSequenceResponses[i] = null;
                this.fetchRemoteDataReply(reply.dsResponse, reply.data, reply.request);
                break;
            }
        }
    }
    
    if (dsResponse.status < 0) {
        isc.RPCManager._handleError(dsResponse, request)
    }
}, 

_handleNewData : function (newData, result) {
    if (this.isLocal()) {
        // when we get the complete dataset from the server we hold onto it as "allRows" and
        // set this.localData to a locally filtered subset        
	    this.allRows = newData;
    	this.filterLocalData();
        return;
    } else if (!this.isPaged()) {
        this._startChangingData();
    	this.localData = newData;
        if (this.canSortOnClient()) {
        	// if client sorting is allowed, sort locally, so that the server does not have to
            // send sorted records and sorting doesn't have to match between client and server
        	this._doSort();
        }
        
        // If our criteria is empty, we have all rows cached - in this case store this.allRows
        // so we can perform a local filter on a call to 'setCriteria'.  NOTE: done within
        // fillCacheData for a paged ResultSet
        if (this.allRowsCached()) {
            this.allRows = this.localData;
        }
        
    	this._doneChangingData();
        return;
    }

    
    // paged mode
	var context = result.context;
    
    this._startChangingData()
    
	// crude staleness detection: change in totalRows
	
	if (this.dropCacheOnLengthChange && this.lengthIsKnown() && 
        this.totalRows != result.totalRows) 
    {
		//>DEBUG
		this.logInfo("totalRows changed from " + this.totalRows + " to " +
					 result.totalRows + ", invalidating cache");
		//<DEBUG
		this._invalidateCache(); // NOTE: doesn't trigger observers yet
	}

    // initialize the cache if we've never loaded rows before
	if (this.localData == null) this.localData = [];

	// trimming length discards any "LOADING" marker rows for rows that don't exist on the
    // server
    this.setFullLength(result.totalRows);

    // add the rows to our cache
    this.fillCacheData(newData, result.startRow);

    // handle server batch size set too small: clear loading markers for the rest of the
    // requested range so that new requests will be fired.  NOTE: the true fix is to make
    // client and server batch size agree, because if multiple concurrent requests are
    // outstanding, there is a bad case where one request comes back and clears loading markers
    // set by another request, causing a third request to be initiated for rows already being
    // fetched.  
    var localData = this.localData;
    for (var i = result.startRow + newData.length; i < this.totalRows; i++) {
        if (Array.isLoading(localData[i])) localData[i] = null;
    }

	//>DEBUG
	this.logInfo("cached " + newData.getLength() + " rows, from " + 
				 result.startRow + " to " + result.endRow +
				 " (" + this.totalRows + " total rows, " + this.cachedRows + " cached)");
	//<DEBUG

    if (this.allMatchingRowsCached()) {
        if (this.allRowsCached()) {
    	    this.logInfo("Cache for entire DataSource complete");
        } else {
    	    this.logInfo("Cache for current criteria complete");
        }
        // sort, because if we just completed a dataset where we had a partial cache before,
        // then the data was previously in a sort order specified by the server
        if (this.canSortOnClient()) this._doSort();
    }

	// call dataChanged in case anyone is observing it
	this._doneChangingData();
},

setContext : function (context) {
    this.context = context;
},

// Criteria
// --------------------------------------------------------------------------------------------

//> @method resultSet.setCriteria()
// Set the filter criteria to use when fetching rows.
// <P>
// Setting new criteria will invalidate the current cache, if any.
// <P>
// Note: any field values in the criteria explicitly specified as null will be
// passed to the server. By default the server then returns only records whose value is null for
// that field. This differs from certain higher level methods such as 
// +link{listGrid.fetchData()} which prune null criteria fields before performing a fetch operation.
//
// @param newCriteria (Criteria)  the filter criteria
// @visibility external
//<
// An overview on the caching system:
// We have 2 kinds of cache
// - the cache of results that matches the current criteria: this.localData
// - the cache of every record we've been handed by the server: this.allRows
//   * When in local filtering mode, this.allRows is always the entire set of records in the
//     data-set, and all sorting and filtering is local (modifying this.localData)
//   * When in basic filtering mode, we also always populate both caches.
//     On the first fetch we fill both caches with the results returned from the server.
//     On subsequent changes to filter criteria, we will either do a client-only filter and 
//     modify the local cache, or perform a new server fetch and update both caches depending
//     on useClientFiltering and whether the new critia are more or less restrictive
//   * In paged mode, when we retrieve data from the server, if it is an incomplete data set, 
//     records will be slotted into the local cache. Once we have retrieved all matching records
//     for a set of criteria, these will be stored as this.allRows, and for subsequent fetches
//     we'll filter on the client and modify the local cache only if possible (similar to 
//     "basic" mode).
// Note: If the user changes textMatchStyle it can become more restrictive 
// (EG from substring to exact match). In this case we can avoid hitting the server, and 
// perform a local filter. Note that if this happens the allRows cache will contain more rows
// than it would for the same "allRowsCriteria" with the new text match style, but we always
// apply a local filter to this data so the developer / user should never see these extra rows.
setCriteria : function (newCriteria) {

    // NOTE: determine this before setting new criteria, otherwise, if we a full cache for the
    // current criteria, and we just changed to empty criteria, we'll believe we have a full
    // cache for empty criteria, hence all rows cached
    var allRowsCached = this.allRowsCached();
    // remember whether criteria are empty
    this._emptyCriteria = (isc.getKeys(newCriteria).length == 0);

    var oldCriteria = this.criteria || {},
        oldTextMatchStyle = this._textMatchStyle;
     
    // clone the criteria passed in - avoids potential issues where a criteria object is passed in
    // and then modified outside the RS
    // Avoid this with advanced criteria - our filter builder already clones the output
    if (newCriteria != null && newCriteria._constructor != "AdvancedCriteria") {
        // use clone to deep copy so we duplicate dates, arrays etc
        newCriteria = isc.clone(newCriteria);
    }
        
    this.criteria = newCriteria;
    this._textMatchStyle = (this.context && this.context.textMatchStyle) ? 
                                this.context.textMatchStyle : null;

    // If the textMatchStyle has changed, we may have to hit the server even if the 
    // new criteria are more restrictive or unchanged.
    var result = this.compareTextMatchStyle(this._textMatchStyle, oldTextMatchStyle);
    
    // If text match style has become less restrictive, it doesn't matter whether the criteria 
    // are more restrictive or unchanged - we are likely to have to hit the server for fresh
    // data
    if (result >= 0) {        
        // if we have switched into local filtering mode after obtaining a full cache (indicated by
        // allRowsCriteria being set), check whether the new criteria are more or less restrictive
        // than the criteria in use when we obtained a full cache.  This determines whether we can
        // continue to do local filtering.
        
        // If one of the criteria objects is an AdvancedCriteria, convert the other one to 
        // enable comparison
        if (newCriteria._constructor == "AdvancedCriteria" && 
            oldCriteria._constructor != "AdvancedCriteria") {
            oldCriteria = this.getDataSource().convertCriteria(oldCriteria, this._textMatchStyle);
        }
        if (newCriteria._constructor != "AdvancedCriteria" && 
            oldCriteria._constructor == "AdvancedCriteria") {
            newCriteria = this.getDataSource().convertCriteria(newCriteria, this._textMatchStyle);
            this.criteria = newCriteria;
        }
        var criteriaResult = this.compareCriteria(newCriteria, 
                                          this.allRowsCriteria ? this.allRowsCriteria : oldCriteria,
                                          this.context);
        // If the criteria changed, respect whether they are more or less strict
        // Otherwise use the result based on whether the text match style changed (becoming more
        // or less strict).
        if (criteriaResult != 0) result = criteriaResult;
    }
	if (result == -1) {      
        // criteria (including textMatchStyle) less restrictive
        // Already tested against allRowCriteria if present.
        // - do local filtering if we have a complete cache only
        if (this.isLocal() || 
            (!this.allRowsCriteria && this.allRows && this.shouldUseClientFiltering())) 
        {            
            // derive localData from the set of all rows
        	if (this.allRows != null) this.filterLocalData();
        } else {   
		    //>DEBUG
    		this.logInfo("setCriteria: filter criteria changed, invalidating cache");
    		//<DEBUG
    		this.invalidateCache();
            this.allRowsCriteria = null;
            delete this._emptyAllRowsCriteria;
        }
	    return true;
	} else if (result == 1) {        
        // criteria more restrictive.  If we are allowed to useClientFiltering and we have a
        // complete cache for the current criteria, use client-side filtering from here on,
        // until the criteria become less restrictive than the allRowsCriteria.
        if (this.allRowsCriteria) {            
            // if allRowsCriteria is set, it indicates we have already started using
            // client-side filtering
            this.filterLocalData();
        } else if (this.shouldUseClientFiltering() && this.allMatchingRowsCached()) {
            // begin using client-side filtering
            this.allRows = this.localData;
            this.allRowsCriteria = oldCriteria;
            this._emptyAllRowsCriteria = (isc.getKeys(oldCriteria).length == 0);
            this.filterLocalData();
        } else {
            // can't use client-side filtering, just invalidateCache
		    //>DEBUG
    		this.logInfo("setCriteria: filter criteria changed, invalidating cache");
    		//<DEBUG
    		this.invalidateCache();
        }
        return true;
    } else {
        // result = 0, identical criteria.
        // When we are using local filtering after obtaining a full cache (allRowsCriteria !=
        // null), this means the new criteria are identical to the criteria at the time we
        // switched into local filtering mode (allRowsCriteria).  We still need to perform
        // local filtering in case we *were* using criteria more restrictive than allRowsCriteria
        // and just switched back to the allRowsCriteria.
        
        if (this.allRowsCriteria && this.compareCriteria(newCriteria, oldCriteria) != 0) {
            this.filterLocalData();
        }
    }
	//>DEBUG
	this.logInfo("setCriteria: filter criteria unchanged");
	//<DEBUG
	return false;
},
//>!BackCompat 2004.7.23
setFilter : function (newCriteria) { return this.setCriteria(newCriteria) },
//<!BackCompat


//> @method resultSet.getCriteria()
// Get the current criteria for this ResultSet.
// @return (Criteria) current criteria
// @visibility external
//<
getCriteria : function () { return this.criteria },

//> @method resultSet.compareCriteria()
// Default behavior is to call +link{dataSource.compareCriteria()} to determine whether new
// criteria is guaranteed more restrictive, equivalent to the old criteria, or not guaranteed
// more restrictive, returning 1, 0 or -1 respectively.
// <P>
// Override this method or +link{dataSource.compareCriteria()} to implement your own client-side
// filtering behavior.
//
// @param   newCriteria     (Criteria)  new filter criteria
// @param   oldCriteria     (Criteria)  old filter criteria
// @param   [requestProperties]     (DSRequest Properties)  dataSource request properties
// @param   [policy]        (string)    overrides +link{criteriaPolicy}
// @return  (Number)    0 if the filters are equivalent, 1 if newFilter is guaranteed more
//                      restrictive, and -1 if newFilter is not guaranteed more restrictive
// @see criteriaPolicy
// @visibility external
//<
compareCriteria : function (newCriteria, oldCriteria, requestProperties, policy) {
    return this.getDataSource().compareCriteria(
                newCriteria, oldCriteria, 
                requestProperties ? requestProperties : this.context, 
                policy ? policy : this.criteriaPolicy);
},

compareTextMatchStyle : function (newStyle, oldStyle) {
    return this.getDataSource().compareTextMatchStyle(newStyle, oldStyle);
},

//> @method resultSet.willFetchData()
// Will changing the criteria for this resultSet require fetching new data from the server, 
// or can the new criteria be satisfied from data already cached on the client?<br>
// Second <code>textMatchStyle</code> parameter determines whether a change of text-match style
// will require a server fetch - for example if filter is being changed between
// an exact match (from e.g: +link{ListGrid.fetchData()}) and a substring match 
// (from e.g: +link{ListGrid.filterData()}).<br>
// This method can be used to determine whether +link{ListGrid.fetchData()} or 
// +link{ListGrid.filterData()} would cause a server side fetch when passed a certain set of 
// criteria.
// @param newCriteria (Criteria) new criteria to test.
// @param [textMatchStyle] (String) New text match style. If not passed assumes 
//      textMatchStyle will not be modified.
// @return (boolean) true if server fetch would be required to satisfy new criteria.
// @visibility external
//<

willFetchData : function (newCriteria, textMatchStyle) {
    
    var undef, result;
    if (textMatchStyle !== undef) {
        result = this.compareTextMatchStyle(textMatchStyle, this._textMatchStyle);
        if (result == -1) return true;
    }
    
    // if allRows is specified we have more cached rows than our current criteria, so
    // compare to allRowsCriteria
    var oldCriteria = this.allRows ? this.allRowsCriteria : this.criteria;
    result = this.compareCriteria(newCriteria, oldCriteria);
    
    // If we have no change in criteria we won't perform a fetch
    
    if (result == 0) return false;
    
    // If we can't filter on the client we always perform a true fetch
    if (!this.shouldUseClientFiltering()) return true;
    
    // If we don't have a full cache of rows matching the current criteria, we perform a true 
    // fetch
    if (!this.allMatchingRowsCached()) return true;
    
    // criteria are less restrictive => fetch
    return (result == -1);
},
    

// Sorting
// --------------------------------------------------------------------------------------------

//> @method resultSet.sortByProperty()
// Sort this ResultSet by a property of each record.
// <P>
// Sorting is performed on the client for a ResultSet that has a full cache for the current
// filter criteria.  Otherwise, sorting is performed by the server, and changing the sort order
// will invalidate the cache.
// <P>
// <b>NOTE:</b> normalizers are not supported by ResultSets in "paged" mode, although valueMaps
// in the DataSource are respected by the SQLDataSource.
//
// @include List.sortByProperty()
// @visibility external
//<
sortByProperty : function (property, sortDirection, normalizer, context) {
    // If we were passed a null normalizer - use the field type as normalizer instead.
    // (May still be null, in which case array sorting will try to derive from actual elements)
    if (normalizer == null) {
        var field = this.getDataSource().getField(property);    
        if (field) normalizer = field.type;
    }
    
    // If we're already sorted as appropriate, no-op.    
    
	if (this._sortProperty == property && this._sortDirection == sortDirection && 
		this._normalizer == normalizer) return;
	
	// remember sort and direction
	this._sortProperty = property;
	this._sortDirection = sortDirection;
	this._normalizer = normalizer;
    this._sortContext = context;

    // set sortBy for any subsequent fetches.
    // - if client sorting has been disabled, the server must sort for us
    // - if we are using paging, the server must sort for us, since server and client sort may
    //   not agree
    //   - XXX we could conditionally turn this off in situations where the cache is going to
    //     be completed when the next set of rows arrives, assuming the cache doesn't get
    //     invalidated
    if (this.isPaged() || !this.shouldUseClientSorting()) {
        this._serverSortBy = (this._sortDirection ? "" : "-") + this._sortProperty;
    }

	this._doSort();
},


//>	@method		resultSet.unsort()	(A)
// Turn sorting off for this result set, indicating that the current sort
// order should be preserved.  Return true if this is supported in this List.
// <P>
// Some implementations may not support this -- they should return false
// to indicate to the caller that sort order must be maintained (eg: in
// the case where sort order is derived from the server, etc).
//
//		@group	sorting
//
//		@return	(boolean)	true == list supports unsorting, false == not supported.
//<
unsort : function () {
    
    if (!this.allMatchingRowsCached()) return false;
    // stop maintaining the sort order
    this._sortProperty = null; 
    // unsort the cache Array or it will continue to apply the last sort order to rows added
    // without a specific index
    if (this.localData) this.localData.unsort();
	return true;
},


// for internal callers - sort by current sort property
_doSort : function () {
    var property = this._sortProperty,
        up = this._sortDirection;

    // if we don't have data yet, wait to be asked for data.
    // if we have no sort property, leave dataset in current order
    if (this.localData == null || property == null) return;

    // we can sort locally if we have the entire result set *for the current filter* cached
    if (this.canSortOnClient()) {

		//>DEBUG
        this.logInfo("sortByProperty(" + property + ", " + up +
                     "): full cache allows local sort");
		//<DEBUG

    	// if we have data, and a sort order, sort it.  Otherwise wait until we have data
        // and/or a sort order.
    	if (property != null) {
		    // XXX NOTE: function-based normalizers are not supported by server sort (and can't
            // be).  valueMap-based normalizers are, but currently are not submitted, so only
            // valueMaps defined on server DataSources work.
    		this.localData.sortByProperty(property, up, this._normalizer, this._sortContext);
            
            // If this is from a cache update, and we're sorting, avoid passing the updated
            // record info to dataChanged()
            delete this._lastUpdateOperation;
            delete this._lastUpdateData;
            delete this._lastOrigRecord;
            delete this._lastUpdateRow;
            
    		if (!this._isChangingData()) this.dataChanged();
    	}
        return;
    }
	//>DEBUG
	this.logInfo("sortByProperty(" + property + ", " + up + "): invalidating cache");
	//<DEBUG

	// paged mode: if sort column/direction changed, clear cache
    
	this.invalidateCache();
},

// Handling Updates
// --------------------------------------------------------------------------------------------

// We have various cases where local data manipulation needs to fire dataChanged() to notify
// components that they need to refresh rows, etc.
// We use _startChangingData() / _doneChangingData() [Array / List APIs] to handle threads where
// these manipulations as a result of new data arriving from the server, etc, to avoid firing
// dataChanged multiple times for a single change.

// dataArrived() is a ResultSet specific notification API for new data being introduced into the 
// cache (typically from a server fetch)
// the _startDataArriving() / _doneWithDataArriving() methods are analagous to
// _startChaningData() / _doneChaningData() for the dataArrived notification
_startDataArriving : function () {
    var undef;
	if (this._dataArriveFlag === undef) this._dataArriveFlag = 0;
	this._dataArriveFlag++;
},

_doneDataArriving : function (startRow,endRow) {
    if (--this._dataArriveFlag == 0) {
        if (this.dataArrived) this.dataArrived(startRow, endRow);
    }
},

_isDataArriving : function () {
    return (this._dataArriveFlag != null && this._dataArriveFlag > 0); 
},



// externally called by DataSource when an update operation succeeds on our datasource
dataSourceDataChanged : function (dsRequest, dsResponse) {
    // Respect the flag to never synch cache
    if (this.disableCacheSync) return;
    
    //>DEBUG
    if (this.logIsDebugEnabled()) this.logDebug("dataSource data changed firing");
    //<DEBUG
    
    // If the server failed to return the updated records, and updateCacheFromRequest is true,
    // integrate the submitted values into the cache if the operation was succesful.
    var updateData = isc.DataSource.getUpdatedData(dsRequest, dsResponse, 
                                                   this.updateCacheFromRequest);
    this.handleUpdate(dsRequest.operationType, updateData, dsResponse.invalidateCache, dsRequest);
},

handleUpdate : function (operationType, updateData, forceCacheInvalidation, dsRequest) {
    if (isc._traceMarkers) arguments.__this = this;
    
    var message = (this.allMatchingRowsCached() ? ", allMatchingRowsCached true"
                            : (", cached rows: " + this.cachedRows + 
                               ", total rows: " + this.totalRows));

    // invalidate the cache if explicitly told to..
    if (this.dropCacheOnUpdate || forceCacheInvalidation || 
        // or if we're unable to safely update the cache in place: 
        // - "add" or "update" operation
        (operationType != "remove" && 
         // - cache is partial
         !this.allMatchingRowsCached() &&
         // - not configured to update a partial cache
         !this.shouldUpdatePartialCache()))
    {
        

        // observers such as a ListGrid will notice this cache invalidation and trigger a fetch
        // for replacement data, as necessary
        this.invalidateCache();
        return;
    }

    this.logInfo("updating cache in place after operationType: " + operationType + message);
    // suppress dataChanged until complete
    this._startChangingData();

    // _lastUpdateData / _lastUpdateOperation are used in the case where we know a single record
    // was modified so can pass info to dataChanged() as params. Only set this up if we're dealing
    // with a single updated record.
    if (!isc.isAn.Array(updateData) || updateData.length == 1) {
        this._lastUpdateOperation = operationType;
        this._lastUpdateData = updateData;
    }
	// otherwise, update our cache in place.  Note our cache is filtered, so we may just
    // discard the update if the new row doesn't pass the filter
	this.updateCache(operationType, updateData, dsRequest);
	this._doneChangingData();
},

// notifyOnUnchangedCache: If a dataSource operation updates this resultSet's underlying data set but
// doesn't effect the cache (EG a record is updated which doesn't match filter criteria), should
// dataChanged be fired.
notifyOnUnchangedCache:false,

// Override doneChangingData to pass updated row info to dataChanged if a single record was
// modified

_doneChangingData : function () {
    
    // If we're dealing with a single row update we can test for the case where the filtered cache
    // wasn't updated at all (and we don't need to fire dataChanged)
    // Note that _lastUpdateData will only be set if a single row was present in the updateData
    
    
    // Specific cases:
    // for delete operations we set the _lastUpdateRow to the original position of the removed
    // record in the cache (if present)
    // if we didn't have the record in the cache (had a partial cache) but it matched filter 
    // criteria (the length was effected) this._lastUpdateData was cleared so we won't hit this
    // check - fire dataChanged with no params.
    // 
    // for add operations we set the _lastUpdateRow flag if we're adding the record to the cache
    // if it's not present.  (but _lastUpdateData is present implying a single record was 
    // returned) we can assert that it didn't match criteria so didn't effect the cache
    //
    // for update operations, if the cache was affected we always set the _lastUpdateRow flag
    // (_lastOrigRecord will only be present if the row was present in the cache before the
    // update)
    
    // so _lastUpdateData being set, and no _lastUpdateRow implies the update didn't effect our
    // cache
    var unmodifiedCache;
    if (!this.notifyOnUnchangedCache && this._lastUpdateData && this._lastUpdateRow == null) {
        unmodifiedCache = true;
    }
    // sanity check we don't want to pass params if we operated on multiple rows
    var operation, record, row;
    if (!unmodifiedCache && this._lastUpdateData) {
        operation = this._lastUpdateOperation;
        record = this._lastOrigRecord;
        row = this._lastUpdateRow;   
            //this.logWarn("single row update - operation:" + operation + 
            //    ", rowNum:"+ row + ", orig record:" + this.echo(record) +
            //    ", updated record:"+ this.echo(this.get(row)));
    }
    // decrement the _dataChangeFlag even if the cache isn't modified so we can track when
    // to actually fire dataChanged
	if (--this._dataChangeFlag == 0 && !unmodifiedCache) {
        this.dataChanged(operation, record, row, this._lastUpdateData);
        // clear all 'single row update' type flags unconditionally once we fire dataChanged
        delete this._lastUpdateOperation;
        delete this._lastOrigRecord;
        delete this._lastUpdateRow;
        delete this._lastUpdateRecord;
        delete this._lastUpdateData
    }
},

// NOTE: when we are updating a full cache for the current filter, this depends on local
// filtering being equivalent to server filtering, otherwise:
// - if the server filter is more constrained (common), the client may retain rows that should
//   disappear (temporary and mostly harmless)
//   - to avoid: set dropCacheOnUpdate OR just ensure server does not return rows that should
//     not appear to user
// - if the server filter is more permissive (rare), the client may drop rows that should appear
//   (alarming: user sees the row he just updated vanish)
//   - to avoid: set dropCacheOnUpdate
// 
// 2 caches to consider:
// this.localData represents the curent data-set that psses our filter criteria
// this.allRows (if set) represents the entire set of data we've been passed by the server.
// In local filtering mode, or if we've performed a fetch with empty criteria this will be
// the entire data set for the dataSource - otherwise will be the results matching the least
// restrictive filter that has been peformed.
// - See setCriteria() for more on this
//
// Therefore every time we need to integrate modified data into the resultSet 
// (removing, adding or updating rows), we need to ensure that if this.allRows is present we
// manipulate that cache, and we also manipulated this.localData.
// We achieve this by:
// - if this.allRows is present, modify that cache of rows, and call filterLocalData() to 
//   re-generate this.localData based on the new set of data in that method. 
//   ** It might be more efficient to explicitly manipulate both arrays rather than regenerating
//      this.localData
// - if this.allRows is not present, modify this.localData directly to integrate the new data 
//   in.
updateCache : function (operationType, updateData, dsRequest) {
    if (updateData == null) return;

    operationType = isc.DS._getStandardOperationType(operationType);
    
	if (!isc.isAn.Array(updateData)) updateData = [updateData];

	//>DEBUG
    if (this.logIsInfoEnabled()) {
        var compStr = (dsRequest.componentId ? " submitted by '" + dsRequest.componentId + "'" :
                        " (no compnentID) ");
        this.logInfo("Updating cache: operationType '" + operationType + "'" + compStr + "," + 
                     updateData.length + " rows update data" +
                     (this.logIsDebugEnabled() ? 
                      ":\n" + this.echoAll(updateData) : ""));
    } //<DEBUG
    
	switch (operationType) {
	case "remove":
        this.removeCacheData(updateData, dsRequest);
		break;
	case "add":
        this.addCacheData(updateData, dsRequest);
		break;
	case "replace":
	case "update":
        this.updateCacheData(updateData, dsRequest);
		break;
	}

    // if we did an "add" or "update" against a partial cache, row numbering may be invalid
    // relative to server-sider order.  Set a one-time flag that causes cache to be invalidated
    // the next time fetchRemoteData is called.
    if (this.shouldUpdatePartialCache() && operationType != "remove" && 
        !this.allMatchingRowsCached()) 
    {
        this.invalidateRowOrder();
    }
    
    var removed = ((operationType == "remove") ||
                    (operationType == "update" && this._lastUpdateRecord == null));
    
    // if the "allRows" cache is present it will have been updated by the above logic, and 
    // this.localData is stale.  We need to re-derive the set of rows that pass the 
    // filter if necessary.  Don't filter if we are configured to neverDropUpdatedRows.
    
    if (this.allRows && !this.shouldNeverDropUpdatedRows()) {
        this.filterLocalData();
    }
    // If we did a local filter, recalculate which row in the cache was effected.
    // Note _lastUpdateRecord comes from the case where a record is newly added to the cache
    var lastUpdateRecord = this._lastUpdateRecord || this._lastOrigRecord;
    if (!removed && lastUpdateRecord != null) {
        var index = this.indexOf(lastUpdateRecord);
        if (index == -1) {
            delete this._lastUpdateRow;
            delete this._lastOrigRecord;
        } else {
            this._lastUpdateRow = index;
        } 
    }
}, 

updateCacheData : function (updateData, dsRequest) {
	if (!isc.isAn.Array(updateData)) updateData = [updateData];

    // NOTE: if allRows is present we are performing a local filter to display a subset of
    // this set of rows.
    // (This may be the entire dataSet for the dataSource - in which case we're in local mode,
    // or just the matching rows for our less restrictive 'allRowsFilter')
    var filteringOnClient = this.allRows != null,
        cache = filteringOnClient ? this.allRows : this.localData,
        updatedRows = 0, removedRows = 0, addedRows = 0;

    var keyColumns = this.getDataSource().getPrimaryKeyFields();
	for (var i = 0; i < updateData.length; i++) {

        var updateRow = updateData[i],
	        keyValues = isc.applyMask(updateRow, keyColumns);

		// find the index of the old row
		var index = this.getDataSource().findByKeys(keyValues, cache),
            origRecord;
        
        // if we didn't find the record in our cache, check for the case where the server
        // returned a changed (bad) primary key value for an update of an existing record.
        // In this case warn, and clear out the original version of the record.
        if (index == -1) {
            var submittedRecord = dsRequest.data;
            if (isc.isAn.Array(submittedRecord)) submittedRecord = submittedRecord[0];

            // pare down to PKs and find in our data-set
	        submittedRecord = isc.applyMask(submittedRecord, keyColumns);
            var oldRecordIndex = this.getDataSource().findByKeys(submittedRecord, cache); 
            if (oldRecordIndex != -1) {
                this.logWarn("Update operation - submitted record with primary key value[s]:" + 
                            this.echo(submittedRecord) + " returned with modified primary key:" + 
                            this.echo(keyValues) + ". This may indicate bad server logic. " + "Updating cache to reflect new primary key.");
                // remove the old record from our dataSet. If it matches filter, we'll re-add below
                removedRows++;
                cache.removeAt(oldRecordIndex);
                // this is a weird case - don't attempt to fire row-specific dataChanged
                delete this._lastUpdateData;
            }
        } else if (updateData.length == 1) {
            origRecord = cache.get(index);
            // catch the case where the orig record is present in the allRows cache but doesn't
            // match filter criteria for local data
            if (filteringOnClient && 
                !this.getDataSource().recordMatchesFilter(origRecord, this.criteria, 
                                                          this.context)) 
            {
                origRecord = null;
            }
            // if the original record was in the (filtered) cache, we'll pass it to
            // dataChanged as a parameter
            this._lastOrigRecord = origRecord;
            // also hang onto the position now. If the record is updated it won't change without
            // a sort, and if it's removed we won't be able to pick it up later
            if (origRecord) this._lastUpdateRow = this.indexOf(origRecord);
        }
        
        var criteria = filteringOnClient ? this.allRowsCriteria : this.criteria,
            // see if the new row matches the filter criteria
            matchesFilter = this.getDataSource().recordMatchesFilter(updateRow, criteria, 
                                                                     this.context),                                                                     
            // don't drop the updated row if neverDropUpdatedRows
            dontDrop = this.shouldNeverDropUpdatedRows();

        if (index == -1 && matchesFilter) {
            // we got an updated row that matches our filter criteria but is not in the cache.
            // This could indicate either:
            // - an "update" operation submitted by a separate grid, form or manual call to
            //   dataSource.updateData(), changing an existing row so that it now matches our
            //   criteria
            // - an "update" operation was submitted based on a record we have cached, but there's
            //   a server bug where the server return the wrong PK, so we couldn't locate the
            //   row. In this second case we've already removed the original record, so it's
            //   appropriate to re-add the "new" record to the cache. 
            this.logInfo("updated row returned by server doesn't match any cached row, " +
                         " adding as new row.  Primary key values: " + this.echo(keyValues) +
                         ", complete row: " + this.echo(updateRow));
            addedRows++;
            cache.add(updateRow);
            
            // in this case we are adding a row to the cache
            // if it's being added to the filtered cache figure out the new rowNum here
            if (updateData.length == 1) {
                // actually store a pointer to the new row. If we just added the record to the
                // allRows cache this can be used to calculate the position within the local cache
                // when the calling method does a local filter.
                this._lastUpdateRecord = updateRow;
                this._lastUpdateRow = cache.length-1;
            }
            
        } else if (index != -1) {

            // found the original row (matching primary keys) in our cache 
            if (matchesFilter || dontDrop) {
                // update the row in place if any of the following is true:
                // - the updated row passes the current filter
                // - we are configured to never drop updated rows
                // - we're actually updating the complete client-side cache, not just the list
                //   of rows that match the filter
                // Note that we use set() instead of just always removing and adding every time
                // because it maintains the record's index when there's no current sort order
                updatedRows++;
    		    cache.set(index, updateRow);
            } else {
                // otherwise, row has been changed so that it does not match filter, 
                // remove the old row
                //>DEBUG
                if (this.logIsDebugEnabled()) {
                    this.logDebug("row dropped:\n" + this.echo(updateRow) +
                                 "\ndidn't match filter: " + this.echo(criteria));
                }
                //<DEBUG

                removedRows++;                         
                cache.removeAt(index);
            }
        } else {
            // this update applies to a row that is not in our cache *and* doesn't match our
            // criteria - just ignore
        }
	}
    
    if (this.logIsDebugEnabled()) {
        this.logDebug("updated cache: "
             + addedRows + " row(s) added, "
             + updatedRows + " row(s) updated, "
             + removedRows + " row(s) removed.");            
    }   
        
    if (!filteringOnClient && this.isPaged()) 
        this.setFullLength(this.totalRows - removedRows + addedRows);

    // reapply current sort to localData if appropriate
    
    if (!filteringOnClient && !this.shouldUpdatePartialCache()) this._doSort();
},

removeCacheData : function (updateData) {
	if (!isc.isAn.Array(updateData)) updateData = [updateData];
    // if we're currently filtering on the client, manipulate this.allRows, and
    // we'll re-derive this.localData later. Otherwise interact directly with this.localData 
    var filteringOnClient = this.allRows != null,
        cache = filteringOnClient ? this.allRows : this.localData,
        ds = this.getDataSource(),
        removedRows = 0;

    // remove any rows that were present in the cache
	for (var i = 0; i < updateData.length; i++) {
		var index = ds.findByKeys(updateData[i], cache);
        if (index != -1) {
            if (updateData.length == 1) {
                // only pass the removed row to dataChanged if it was present in the 
                // local (filtered) cache
                var origRecord = cache[index];

                if (!filteringOnClient || 
                    ds.recordMatchesFilter(origRecord, this.criteria, this.context)) 
                {
                    this._lastOrigRecord = origRecord;
                    // if we're not looking at the allRows cache the filtered index may not equal
                    // the position in the cache so use indexOf
                    this._lastUpdateRow = this.indexOf(this._lastOrigRecord);
                }
            }
    		cache.removeAt(index);
            this.cachedRows -= 1;
            removedRows++;
        } else {
            // removal of a record not in our cache.  Can happen if grid.removeData() is called
            // on a grid with different filter criteria.

            // we have a complete cache for our criteria, nothing to do            
            if (this.allMatchingRowsCached()) continue;

            // If we have a partial cache, use client-side filtering to determine whether this
            // removal has reduced the number of records that match our criteria (which should
            // affect this.totalRows)
            if (ds.applyFilter([updateData[i]], this.criteria, this.context).length > 0) {
                if (this.logIsDebugEnabled()) {
                    this.logDebug("removed record matches filter criteria: " + 
                                  this.echo(updateData[i]));
                }
                // clear the _updateData so we don't attempt to pass params to the 
                // dataChanged method in this case
                // Note that we will still need to fire dataChanged since the length has changed
                if (this._lastOrigRecord == null) delete this._lastUpdateData;
                removedRows++;
            } else {
                // row doesn't match our criteria, ignore it
                if (this.logIsDebugEnabled()) {
                    this.logIsDebugEnabled("cache sync ignoring 'remove' operation, removed " +
                                           " row doesn't match filter criteria: " + 
                                           this.echo(updateData[i]));
                }   
            }
        }
	}
    
    // For paged data-sets (without a complete cache), this.totalRows is used to determine 
    // how many rows exist. Update full length so that we don't advertise rows that don't exist
    // Not required for local/basic rs where we look at localData.length directly
    
    if (!filteringOnClient && this.isPaged()) 
        this.setFullLength(this.totalRows - removedRows);
    
},

// add rows that pass filtering, then sort the cache if we're in client-side sort mode
addCacheData : function (newRows) {
	if (!isc.isAn.Array(newRows)) newRows = [newRows];
    if (newRows == null) return;

    // if we have the entire dataset cached (allRows != null), add the new rows to the cache of
    // the entire dataset regardless.  Subsequent client-side filtering will eliminate them if
    // they don't match the filter criteria.
    // Also do not attempt to filter if client-side filtering is disabled.
    var validRows;
	if (this.allRows == null || !this.shouldUseClientFiltering()) {
        validRows = this.getDataSource().applyFilter(newRows, this.criteria, this.context);
    } else {
        validRows = newRows;
        if (this.allRowsCriteria) {
            validRows = this.getDataSource().applyFilter(validRows, 
                                                        this.allRowsCriteria, this.context);
        }
    }
    var addingSingleRow;
    if (validRows.length != newRows.length) {
        this.logInfo(validRows.length + " of " + newRows.length + 
                     " rows match filter criteria");
    } else if (validRows.length == 1) {
        // flag that we're adding a single row to the cache (so should pass the 
        // rowNum to dataChanged)
        addingSingleRow = true;
    }

    var cache = this.allRows || this.localData;

    if (!this.allMatchingRowsCached() && this.shouldUpdatePartialCache()) {
        var range = this.getCachedRange();
        if (range) {
            // Design:
            // - if we are at the end of the dataset add the new row there.  This works nicely
            //   for inline edit of new rows in a paged dataset, which is always at the end of
            //   the dataset.
            // - otherwise, if there is any cache at beginning of the dataset (rowIsLoaded(0)),
            //   add there.  This works nicely for eg a form adding data to a paged dataset where
            //   the user has not scrolled 
            // - finally, add at the end of the last requested contiguous cached range.  This
            //   works well for link-based paging and other alternative paging interfaces
            if (range[1] == this.getLength()-1 || !this.rowIsLoaded(0)) {
                var index = range[1]+1;
                cache.addListAt(validRows, index);
                // if we re-sort this will be dropped
                // if we perform a local filter this will be updated
                if (addingSingleRow) this._lastUpdateRow = index;
            } else {
                cache.addListAt(validRows, 0);
                if (addingSingleRow) this._lastUpdateRow = 0;
            }
        } else {
            cache.addList(validRows);
            if (addingSingleRow) this._lastUpdateRow = cache.length -1;
        }
    } else {
        // add at the end - they will be sorted into place
        cache.addList(validRows);
        if (addingSingleRow) this._lastUpdateRow = cache.length -1;
    }
    // store a pointer to the record as well as the row. This can be used to calculate the
    // index within the local cache if we just added the record to the allRows cache.
    if (this._lastUpdateRow != null) this._lastUpdateRecord = cache[this._lastUpdateRow];
    this.cachedRows += validRows.length;

    // if we can sort locally, do so now
    if (this.canSortOnClient()) this._doSort();

    // update full length so that the new rows show up
    if (this.isPaged() && !this.allRows) 
        this.setFullLength(this.totalRows + validRows.length);
},



insertCacheData : function (insertData, position) {
	if (!isc.isAn.Array(insertData)) insertData = [insertData];
    
    if (this.allRows && (this.allRows != this.localData)) {
        this.allRows.addListAt(insertData, position);
    }
    var cache = this.localData;
    // insert the rows into the cache
    cache.addListAt(insertData, position);
    // update full length so that we don't advertise rows that don't exist
    if (this.isPaged()) this.setFullLength(this.totalRows + insertData.length);
},

// Paged Mode
// --------------------------------------------------------------------------------------------

// search backward until the first null row is found, and return the row just after it
findFirstCachedRow : function (pos) {
    for (var i = pos; i >= 0; i--) {
        if (this.localData[i] == null) return i+1;
    }
    return 0;
},

// search forward until the first null row is found, and return the row just before it
findLastCachedRow : function (pos) {
    for (var i = pos; i < this.totalRows; i++) {
        if (this.localData[i] == null) return i-1;
    }
    return this.totalRows-1;
},

// It turns out that getRangePanged() can be reentrant.  The call stack is as follows (in an
// LG): fetchRemoteData() -> shows prompt w/clickMask -> clickMask makes a synthetic mouseOut
// call on the GridRenderer of the LG -> GR mouseOut calls this.getCellRecord() which is
// plumbed through to the LG - and that method calls data.get() which leads back to here.
//
// In the reentrant case, we don't want to make a redundant call to the server (which could
// lead to an endless code loop via the reentry case).  So we handle reentry here by simply
// returning the requested rows as a slice of local cache filled with loading markers - exactly
// what getRangePaged() would have returned.
//      
_getRangePaged : function (start, end, ignoreCache, fetchNow) {
    if (this._getRangePagedReentrant) {
        // honor ignoreCache
        var cache = (this.ignoreCache ? [] : this.localData) || [];
        return this.fillRangeLoading(cache.slice(start, end), end-start);
    }    
    this._getRangePagedReentrant = true;
    var result = this.getRangePaged(start, end, ignoreCache, fetchNow);
    delete this._getRangePagedReentrant;
    return result;
},

// NOTE: caller can ask for as many rows as he wants, and we will fetch them all.  It is up to
// the caller to only ask for the rows that are actually really needed
getRangePaged : function (start, end, ignoreCache, fetchNow) {
	if (start < 0 || end < 0) {
		//>DEBUG
		this.logWarn("getRange(" + start + ", " + end + 
					 "): negative indices not supported, clamping start to 0");
		//<DEBUG
		if (start < 0) start = 0;
	}
	if (end <= start) { 
		//>DEBUG
		this.logDebug("getRange(" + start + ", " + end + "): returning empty list");
		//<DEBUG
		return [];
	}

    // if the length is known, ignore or clamp requests for rows beyond the end of the
    // dataset.  Otherwise carelessly issued requests beyond the end of the dataset would cause
    // useless fetches.  Note this implies that if you know that the cache is incomplete
    // because new rows have been inserted, you need to call invalidateCache() to get them.
    if (!ignoreCache && this.lengthIsKnown()) {
        var length = this.getLength();
        if (start > length-1 && start != 0) {
            // start is beyond last valid index
		    //>DEBUG
    		this.logWarn("getRange(" + start + ", " + end + 
                         "): start beyond end of rows, returning empty list");
	    	//<DEBUG
            return [];
        } else if (end > length) {
            // end (which is non-inclusive) is beyond last valid index
            end = length;
        }
    }

    if (this.localData == null) this.localData = [];    

    // if the "ignoreCache" flag is set, ignore the cache temporarily.  If a caller is aware that
	// that the cache may soon be invalidated, they can use "ignoreCache" to trigger fetches.
	if (ignoreCache) {
		this.realCache = this.localData;
		this.localData = [];
	}

    var localData = this.localData;

	// store the last getRange(), so on cache invalidation we have an idea of the most recently
    // used rows
	this.lastRangeStart = start;
	this.lastRangeEnd = end;

	// determine range we don't have
	var firstMissingRow, lastMissingRow, missingRows;
	for (var i = start; i < end; i++) {
		if (localData[i] == null) {
			missingRows = true;
    		// remember the first and last missing row within the range
    		if (firstMissingRow == null) firstMissingRow = i;
    		if (lastMissingRow == null || lastMissingRow < i) lastMissingRow = i;
		}
	}
	// we're done if we have all rows locally
	if (!missingRows) {
		//>DEBUG
		this.logDebug("getRange(" + start + ", " + end + ") satisfied from cache");
		//<DEBUG        
		return localData.slice(start, end);
	}

	// we were missing rows; fetch the rows from the server

	var startRow, endRow;
    if (this.fetchAhead) {
        var fetchAheadRange = this._addFetchAhead(start, end, firstMissingRow, lastMissingRow, 
                                                  ignoreCache);
        startRow = fetchAheadRange[0];
        endRow = fetchAheadRange[1];
    } else { // requested only
		// take the requested range literally, only avoiding refetching of cached rows 
		startRow = firstMissingRow;
		endRow = lastMissingRow+1;
	}

    // store current start/endRow
    this.fetchStartRow = startRow;
    this.fetchEndRow = endRow;
    
    // Depending on whether fetchDelay is set, getRange() may or may not immediately
    // initiate a fetch.  The data returned to the caller always includes LOADING markers for
    // rows that aren't loaded.  When a fetch is actually initiated, we also write LOADING
    // markers into our cache to prevent duplicate fetches for the same rows.
    //
    // If we do not immediately execute a fetch, we don't immediately write LOADING markers
    // into our cache because subsequent getRange() calls may shift the range of rows that will
    // ultimately be requested, and given concurrent outstanding requests, it wouldn't be clear
    // when to clean up the LOADING markers.
    var returnData;
    if (fetchNow || this.fetchDelay == 0) {
        // fetch rows immediately
        this._fetchRemoteData();
        // _fetchRemoteData() writes loading markers into localData, so just slice out a
        // response
        returnData = localData.slice(start, end);
    } else {
	    // set a timer to fetch rows.  When this fetch ultimately fires it will be based on the
        // most recently calculated fetch range (fetchStartRow/fetchEndRow)
        this.fireOnPause("fetchRemoteData", "_fetchRemoteData", this.fetchDelay);
        // return a slice of the cache, with loading markers added for missing rows
        returnData = this.fillRangeLoading(localData.slice(start, end), end-start);        
    }
	
	// restore the real cache
	if (ignoreCache) {
		this.localData = this.realCache;
		this.realCache = null;
	}
	return returnData;
},

// extend the requested range of rows into one full "resultSize" batch
_addFetchAhead : function (requestedStart, requestedEnd, firstMissingRow, lastMissingRow,
                           ignoreCache) 
{
    var localData = ignoreCache ? [] : this.localData,
        length = ignoreCache ? Number.MAX_VALUE : this.getLength(),
        // round out the missing range to one full resultSize
        missingCacheSize = lastMissingRow - firstMissingRow,
        extension = Math.floor((this.resultSize - missingCacheSize)/2),
        cacheCheckStart = Math.max(0, firstMissingRow - extension),
        cacheCheckEnd = Math.min(length, lastMissingRow + extension);
        
    // and look for the first and last missing row within the extended range
    for (var i = cacheCheckStart; i <= firstMissingRow; i++) {
        var row = localData[i];
        if (row == null || Array.isLoading(row)) break;
    }
    firstMissingRow = i;

    for (var i = cacheCheckEnd; i >= lastMissingRow; i--) {
        var row = localData[i];
        if (row == null || Array.isLoading(row)) break;
    }
    lastMissingRow = i;

    //>DEBUG
    this.logDebug("getRange(" + [requestedStart,requestedEnd] +
                 "), cache check: " + [cacheCheckStart, cacheCheckEnd] + 
                 " firstMissingRow: " + firstMissingRow + 
                 " lastMissingRow: " + lastMissingRow); //<DEBUG

    // NOTE throughout:
    // - we don't want to clamp endRow to totalRows because more rows could be
    //   have been added at the server.
    // - make sure we still fetch everything in the requested ranged (when resultSize is
    //   smaller than requested range)
    var startRow, endRow;
    if (firstMissingRow == 0 || 
        (firstMissingRow > cacheCheckStart && lastMissingRow == cacheCheckEnd)) 
    {
        // we have cache at the beginning of the requested range, but none at the end, so
        // we appear to be scrolling forward: fetch a slice stretching forward from the
        // first missing row
		//>DEBUG
		this.logDebug("getRange: guessing forward scrolling");
		//<DEBUG
        startRow = firstMissingRow;
        endRow = startRow + this.resultSize;

        if (endRow < requestedEnd) endRow = requestedEnd;
    } else if (firstMissingRow == cacheCheckStart && lastMissingRow < cacheCheckEnd) {
        // we have cache at the end of the requested range, but none at the beginning, so
        // we appear to be scrolling backward: fetch a slice stretching backward from the
        // last missing row
        //>DEBUG
        this.logDebug("getRange: guessing backward scrolling");
        //<DEBUG
        endRow = lastMissingRow+1; 
        startRow = endRow - this.resultSize;
        if (startRow < 0) startRow = 0;

        if (startRow > requestedStart) startRow = requestedStart;
    } else { 
        // we have no cache in the requested range.  Fetch a slice centered on the middle
        // of the requested range.
        //>DEBUG
        this.logDebug("getRange: no scrolling direction detected");
        //<DEBUG
        startRow = cacheCheckStart;
        endRow = cacheCheckEnd;

        if (startRow > requestedStart) startRow = requestedStart;
        if (endRow < requestedEnd) endRow = requestedEnd;
    }

    // our range to fetch may now stretch outside of the examined part of the cache.
    // Examine the fetchAhead area now to avoid fetching some already cached rows.  This is
    // key, because over-fetching is likely to happen when totalRows is about 2-5x resultSize,
    // or in general when a user is thumb-dragging in a region about 2-5x resultSize. 
    for (var i = startRow; i < cacheCheckStart; i++) {
        var row = localData[i];
        if (row == null || Array.isLoading(row)) break;
    }
    //if (startRow != i) this.logWarn("trimming startRow from: " + startRow + " to " + i);
    startRow = i;

    for (var i = endRow-1; i > cacheCheckEnd; i--) {
        var row = localData[i];
        if (row == null || Array.isLoading(row)) break;
    }
    //if (endRow != i+1) this.logWarn("trimming endRow from: " + endRow + " to " + (i+1));
    endRow = i+1;

	//>DEBUG
	this.logInfo("getRange(" + requestedStart + ", " + requestedEnd + ") will fetch from " + 
				 startRow + " to " + endRow);
	//<DEBUG

    return [startRow, endRow];
},


// Local Mode
// --------------------------------------------------------------------------------------------

//> @method resultSet.filterLocalData() [A]
// Derive the current filtered set of data from the cache of all matching rows.
// <P>
// This method is automatically called by +link{setCriteria()} when criteria have actually
// changed, as well as in various other situations.  You could only need to call this method
// directly if:
// <ul>
// <li> you know that client-side filtering is enabled (+link{useClientFiltering}:true) and
// active +link{allMatchingRowsCached()}.
// <li> you have directly, programmatically modified data within the ResultSet such that it no
// longer matches the filter criteria
// <li> you want your modified records to disappear from the list of visible records (that is,
// those accesible via +link{get()})
// </ul>
// 
// @visibility external
//<
filterLocalData : function () {
    this._startChangingData();
	this.localData = this.applyFilter(this.allRows, this.criteria, 
                                      isc.addProperties({dataSource:this}, this.context));
	//>DEBUG
	this.logInfo("Local filter applied: " + this.localData.length + " of " + this.allRows.length 
                 + " records matched filter:" + isc.Comm.serialize(this.criteria));
	//<DEBUG

    // this.localData has changed,  apply sort if we have all the rows
    if (this.allRows != null && this.shouldUseClientSorting()) this._doSort();

    // NOTE: no need to apply sort, as filtering preserves order.

    // fire the dataArrived notification.  Technically, no new data has come from the server,
    // however the dataset as viewed through all public methods (get, getRange, etc) has
    // completely changed.
    if (!this._isDataArriving() && this.dataArrived) this.dataArrived(0, this.localData.length-1);

	this._doneChangingData();
},

//> @method resultSet.applyFilter() [A]
// The ResultSet will call applyFilter() when it needs to determine whether rows match the
// current filter criteria.
// <P>
// Default behavior is to call +link{dataSource.applyFilter()} to determine which rows match
// that provided criteria.
// <P>
// Override this method or +link{dataSource.applyFilter()} to implement your own client-side
// filtering behavior.
//
// @param   data        (Array)     the list of rows
// @param   criteria    (Criteria)  the filter criteria
// @param   [requestProperties]     (DSRequest Properties)  dataSource request properties
// @return  (Array)     the list of matching rows
// @visibility external
//<
applyFilter : function (data, criteria, requestProperties) {
    return this.getDataSource().applyFilter(data, criteria, requestProperties);
},

// get a list of all values for a given property.  
// ValuesLists are generally used for "Select Other.." widgets where there is field that is a
// pseudo-enum: it can have any value, but it IS an enumerated list of eg categories, and we would
// like to avoid having the same category entered twice with a slightly different name.  So we look
// for existing values among all records.
getValuesList : function (property) {
	//>DEBUG
	this.logInfo("asked for valuesList for property '" + property + "'");
	//<DEBUG

    if (this.isLocal()) {
    	if (!this.allRows) {
    		//>DEBUG
    		this.logWarn("asked for valuesList before data has been loaded");
    		//<DEBUG
    		return [];
    	}
    
	    var valuesList = this.allRows.getProperty(property);
    	if (!valuesList) return [];
    	// NOTE: this can contain exactly one null, which we presume is an interesting value.
        // If you don't want the null, call valuesList.remove(null);
    	return valuesList.getUniqueItems();
    }

    // return all unique values that happen to be cached
    var range = this.getCachedRange(),
        values = [];
    for (var i = range[0]; i <= range[1]; i++) {
        var row = this.get(i);
        if (!values.contains(row[property])) values[values.length] = row[property];
    }
    return values;
},

// Cache Management
// --------------------------------------------------------------------------------------------
// Externally callable only by very advanced callers.  Legitimate use cases include:
// - seeding a paged RS' cache with values loaded separately
// - manual cache invalidation for data dependencies not handled automaticallly
// - implementing your own comm layer

//> @method resultSet.fillCacheData() [A]
// Cache rows in this ResultSet's cache at specific positions
// <P>
// This is used internally by ResultSet, but can also be used to seed a new ResultSet with
// already loaded data.
//
//		@param  newData      (Array of Object)   data to cache
//		@param	[startRow]   (Number)	         optional start index of where new rows should be
//                                               placed in the cache; default 0
// @visibility customResultSet
//<
fillCacheData : function (newData, startRow) {
    if (startRow == null) startRow = 0;

    this.logDebug("integrating " + newData.length + 
                  " rows into cache at position " + startRow);

    if (this.localData == null) this.localData = [];
    this.localData.length = this.getLength();
    
    for (var i = 0; i < newData.length; i++) {
		var rowIndex = startRow + i,
			existingData = this.localData[rowIndex];
		if (existingData == null || Array.isLoading(existingData)) {
			// we cached another row (as opposed to overwriting an existing cached row with
            // fresh data)
			this.cachedRows++;
		}
		this.localData[rowIndex] = newData[i];
    }

    if (this.allRowsCached()) {
        this.allRows = this.localData;
    }
},

//> @method ResultSet.setFullLength() [A]
// Set the total number of rows available from the server that match the current filter 
// criteria for this ResultSet.
// @param length (number) total rows available from the server
// @visibility customResultSet
//<
// NOTE: this is separate from setLength, because ResultSet.setLength() should cause deletion
// of all rows past the length. 

setFullLength : function (length) {
    if (!isc.isA.Number(length)) return;

    this.logDebug("full length set to: " + length);
        
    if (this.isPaged()) this.totalRows = length;
    
	if (this.localData != null) this.localData.length = length;
    if (this.cachedRows > length) this.cachedRows = length;
},

//> @method resultSet.invalidateCache() [A]
// Manually invalidate this ResultSet's cache.
// <P>
// Generally a ResultSet will observe and incorporate updates to the DataSource that provides it's
// records, but when this is not possible, <code>invalidateCache()</code> allows manual cache
// invalidation.
// <P>
// <code>invalidateCache()</code> fires <code>dataChanged()</code>, which may cause components which
// as using this ResultSet to request new data for display, triggering server fetches.
// @visibility external
//<
invalidateCache : function () {
    // If we're updating the cache from a server operation, avoid passing the updated
    // record info to dataChanged()
    delete this._lastUpdateOperation;
    delete this._lastUpdateRecord;
    delete this._lastUpdateData;
    delete this._lastOrigRecord;
    delete this._lastUpdateRow;
    
    this._invalidateCache();
    // dataChanged() is required to force a refresh from the server
	if (!this._isChangingData()) this.dataChanged();
},

// NOTE: does not call dataChanged() automatically and should not be externally observed
_invalidateCache : function () {
    this.invalidateRows();
	this.totalRows = null; // start reporting unknown length again for paged resultSets

	//>DEBUG
	this.logInfo("Invalidating cache");
	//<DEBUG
},

// invalidateCache vs invalidateRows:
// - invalidateCache means we have no idea what the total rows are, eg the search criteria have
//   changed.  In this case it's appropriate to advertise !lengthIsKnown() and observing
//   widgets may choose to show something indicating transition to a new dataset, such as a
//   "fetching new data" message
// - invalidateRows means the row order is changing or is stale, but we are looking at
//   basically the same dataset in a new order.  lengthIsKnown() is true, and observing widgets
//   may choose to retain aspects of the view such as scroll position
invalidateRows : function () {
	this.localData = this.allRows = null;
    this.allRowsCriteria = null;
    
	this.cachedRows = 0;
    // one time flag for invalidating rows on fetch can now be cleared
    this._invalidRowOrder = null; 
},
    
invalidateRowOrder : function () {
    this._invalidRowOrder = true;
},

rowOrderInvalid : function () {
    return this._invalidRowOrder;
},

// Selection
// -----------------------------------------------------------------------------------------

getNewSelection : function (initParams) {
    var selectionClass = this.getDataSource().selectionClass || "Selection";
    return isc.ClassFactory.getClass(selectionClass).create(initParams);
}

});

isc.ResultSet.registerStringMethods({
    //> @method ResultSet.transformData()
    // <code>transformData()</code> provides an opportunity to modify data that has been
    // returned from the server, before it has been integrated into the client-side cache.
    // <P>
    // If data is not immediately suited for client-side use when it is returned from the
    // ultimate data store, this method allows it to be transformed on the client so that such
    // transform operations do not impact server scalability.
    // <P>
    // It is legal for <code>transformData()</code> to modify not only the records, but also
    // their number (by modifying startRow and endRow on the +link{DSResponse} object).
    // <P>
    // See also +link{dataSource.transformResponse()} for an alternative entry point which
    // applies to all DSResponses for a DataSource.
    //
    // @param   newData            (any)  data returned from the server
    // @param   dsResponse         (DSResponse) the DSResponse object returned by the
    //                             server
    // @return (Array of Objects) the modified data, ready to be cached
    // @visibility external
    //<
    transformData : "newData,dsResponse",

    //> @method ResultSet.dataArrived()
    // Notification fired when data has arrived from the server and has been successfully
    // integrated into the cache.
    // <P>
    // When <code>dataArrived()</code> fires, an immediate call to <code>getRange()</code> with
    // the <code>startRow</code> and <code>endRow</code> passed as arguments will return a List
    // with no <code>Array.LOADING</code> markers.
    //
    // @param startRow  (number)   starting index of rows that have just loaded
    // @param endRow    (number)   ending index of rows that have just loaded, non-inclusive
    // @visibility external
    //<
    dataArrived : "startRow,endRow",
    
    //> @method resultSet.dataChanged()
    // Fires when data in the ResultSet has been changed.
    // <P>
    // For a single-row update, that is, a single row that has been updated, added or removed,
    // parameters such as <code>rowNum</code> are available for UI widgets that want to
    // incrementally update the display (for example, show a remove animation for a record being
    // removed).
    // <P>
    // In the single-row update case, the rowNum will indicate:
    // <ul>
    // <li> for a remove, the index where the row was removed
    // <li> for an add, the index where the row has been added
    // <li> for an update, the index of the updated row
    // </ul>
    // Note several cases for "update":
    // <ul>
    // <li> an "update" on a record not in the cache may introduce a new record to the cache.  In
    // this case, <code>originalRecord</code> is null and <code>rowNum</code> is the position of
    // insertion.
    // <li> an "update" may remove a record from cache, in this case, the rowNum indicates it's
    // former position, and this case can be detected by detecting
    // resultSet.get(rowNum) != originalRecord
    // </ul>
    // Note that an "update" on a sorted dataset may cause changes at two indices.  In this case
    // <code>dataChanged()</code> fires without parameters.
    // <P>
    // <code>dataChanged()</code> also fires in a number of situations in which the entire
    // dataset is affected and in this case no parameters are available.  This includes new
    // filter criteria, new sort direction, cache invalidation, new data arrival and manual calls
    // to <code>dataChanged()</code> triggered by customized subclasses of ResultSet.
    // <P>
    // In this case observing code should assume the dataset has been partly or wholly reordered,
    // and may have no records in common with the dataset as it existed before
    // <code>dataChanged()</code> fired.
    //
    // @param [operationType] (DSOperationType) type of operation that took place if a single row
    //                                          update, otherwise, null
    // @param [originalRecord] (Record) record before update took place.  Null for operationType
    //                                  "add".
    // @param [rowNum] (integer) row where the update took place
    // @param [updateData] (Record) +link{group:dataSourceOperations,cache update data} returned
    //                               by the server, or submitted values if no data was returned
    //                               and +link{updateCacheFromRequest} is set.
    // @visibility internal
    //<
    dataChanged : "operationType,originalRecord,rowNum,updateData"
    
});

// isc._dataModelToString and isc._dataModelLogMessage are defined in Log.js
isc.ResultSet.getPrototype().toString = isc._dataModelToString;
isc.ResultSet.getPrototype().logMessage = isc._dataModelLogMessage;

//>!BackCompat 2004.7.29  fetchModes as distinct classes
isc.ClassFactory.defineClass("LocalResultSet", isc.ResultSet);
isc.LocalResultSet.addProperties({
    fetchMode : "local"
});

// WRS sets fetchMode : "paged", already the default
isc.ClassFactory.defineClass("WindowedResultSet", isc.ResultSet);
//<!BackCompat


//>	@method resultSet.findAll()
// Like +link{list.findAll()}.  Checks only loaded rows and will not trigger a fetch.
// @include list.findAll
//<

//>	@method resultSet.find()
// Like +link{list.find()}.  Checks only loaded rows and will not trigger a fetch.
// @include list.find
//<

//>	@method resultSet.findIndex()
// Like +link{list.findIndex()}.  Checks only loaded rows and will not trigger a fetch.
// @include list.findIndex
//<

//>	@method resultSet.findNextIndex()
// Like +link{list.findNextIndex()}.  Checks only loaded rows and will not trigger a fetch.
// @include list.findNextIndex
//<

//>	@method resultSet.getProperty()
// Like +link{list.getProperty()}.  Checks only loaded rows and will not trigger a fetch.
// @include list.getProperty
//<

isc.ResultSet.addMethods(isc.ClassFactory.makePassthroughMethods(
    ["find", "findIndex", "findNextIndex", "findAll", "getProperty"], "localData"));
