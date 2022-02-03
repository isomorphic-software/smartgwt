/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data;


import java.util.Date;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.dom.client.Element;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.types.CriteriaPolicy;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.util.EnumUtil;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ConfigUtil;


/**
 * ResultSets are an implementation of the {@link com.smartgwt.client.data.List} interface that automatically fetches 
 *  DataSource records when items are requested from the List.  ResultSets provide robust,
 *  customizable, high-performance cache management for ListGrids and other built-in Smart GWT
 *  components, and can be used as cache managers by custom components.
 *  <P>
 *  ResultSets manage data paging, that is, loading records in batches as the user navigates
 *  the data set.  A ResultSet will switch to using client-side sorting and filtering when
 *  possible to improve responsiveness and reduce server load.  ResultSets also participate in
 *  automatic cache synchronization, observing operations on DataSources and automatically
 *  updating their caches.
 *  <P>
 *  <b>Creation</b>
 *  <P>
 *  A ResultSet can be passed to any component that expects a List, and the List APIs can be
 *  called directly on the ResultSet as long as the caller is able to deal with asynchronous
 *  loading; see {@link com.smartgwt.client.data.ResultSet#getRange getRange()}.
 *  <P>
 *  Generally ResultSets do not need to be created directly, but are created by DataBound
 *  components as an automatic consequence of calling 
 *  {@link com.smartgwt.client.docs.DataBoundComponentMethods DataBound Component Methods}.  
 * For example, the {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData()} causes {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getData ListGrid.data} to become an
 *  automatically created <code>ResultSet</code> object.  Automatically created ResultSets
 * can be customized via properties on ListGrids such as {@link com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize
 * ListGrid.dataPageSize} and
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties ListGrid.dataProperties}.  All ResultSets for a given
 * DataSource may also be 
 * customized via setting {@link com.smartgwt.client.data.DataSource#getResultSetClass DataSource.resultSetClass} to the
 * name of a ResultSet 
 *  {@link com.smartgwt.client.util.isc#defineClass subclass} in which 
 *   defaults have been changed.
 *  <P>
 * A ResultSet defaults to using data paging, setting {@link com.smartgwt.client.data.DSRequest#getStartRow
 * DSRequest.startRow} and
 * {@link com.smartgwt.client.data.DSRequest#getEndRow DSRequest.endRow} in issued dsRequests.  Server code may always
 * return more rows than
 *  the ResultSet requests and the ResultSet will correctly integrate those rows based on
 * {@link com.smartgwt.client.data.DSResponse#getStartRow DSResponse.startRow}/{@link
 * com.smartgwt.client.data.DSResponse#getEndRow endRow}.  
 *  Hence the server can always avoid paging mode by simply returning all matching rows.
 *  <P>
 *  A ResultSet can be created directly with just the ID of a {@link com.smartgwt.client.data.DataSource}:
 *  <pre>
 *      ResultSet resultSet = new ResultSet();
 *      resultSet.setDataSource(dataSourceID);
 *  </pre>
 *  <P>
 *  Directly created ResultSets are typically used by custom components, or as a means of
 *  managing datasets that will be used by several components.
 *  <P>
 *  When created directly rather than via a dataBoundComponent, a newly created ResultSet will
 *  not issue it's first "fetch" {@link com.smartgwt.client.data.DSRequest} until data is accessed (for example, via
 *  {@link com.smartgwt.client.data.ResultSet#get get()}).  
 *  <P>
 *  <b>Paging and total dataset length</b>
 *  <P>
 *  When using data paging, the server communicates the total number of records that match the
 * current search criteria by setting {@link com.smartgwt.client.data.DSResponse#getTotalRows DSResponse.totalRows}.  The
 * ResultSet will then
 *  return this number from {@link com.smartgwt.client.data.ResultSet#getLength getLength()}, and ListGrids and other
 *  components will show a scrollbar that allows the user to jump to the end of the dataset
 *  directly.
 *  <P>
 *  However, the ResultSet does not require that the server calculate the true length of the
 *  dataset, which can be costly for an extremely large, searchable dataset.  Instead, the
 *  server <i>may</i> simply advertise a <code>totalRows</code> value that is one page larger
 *  than the last row loaded.  This results in a UI sometimes called "progressive loading",
 *  where the user may load more rows by scrolling past the end of the currently loaded rows,
 *  but is not allowed to skip to the end of the dataset.
 *  <P>
 *  No client-side settings are required to enable this mode - it is entirely server-driven.
 * However, it is usually coupled with {@link com.smartgwt.client.widgets.grid.ListGrid#getCanSort disabling sorting},
 * since
 *  server-side sorting would also force the server to traverse the entire dataset.  Note
 * also the {@link com.smartgwt.client.data.DataSource#getProgressiveLoading progressiveLoading} flag, which can be applied
 *  at a DataSource, operation, request, component or ResultSet level; if you are using the
 *  built-in server-side DataSource implementations with Pro or better, this tells Smart GWT
 *  Server to use its pre-built progressive loading mode for that DataSource, operation, 
 *  request, component or ResultSet.
 *  <P>
 *  <b>Client-side Sorting and Filtering</b>
 *  <P>
 *  If a ResultSet obtains a full cache for the current set of filter criteria, it will 
 *  automatically switch to client-side sorting, and will also use client-side filtering 
 *  if the filter criteria are later changed but appear to be <i>more restrictive</i> than the
 *  criteria in use when the ResultSet obtained a full cache.
 *  <P>
 *  The {@link com.smartgwt.client.data.ResultSet#getUseClientSorting useClientSorting} and 
 *  {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering useClientFiltering} flags can be used to disable
 *  client-side sorting and filtering respectively if these behaviors don't match server-based
 *  sorting and filtering.  However, because client-side sorting and filtering radically improve
 *  responsiveness and reduce server load, it is better to customize the ResultSet so that it
 *  can match server-side sorting and filtering behaviors.
 *  <P>
 *  Sorting behavior is primarily customized via the "sort normalizer" passed to
 * {@link com.smartgwt.client.data.ResultSet#sortByProperty sortByProperty()}, either via direct calls on a standalone
 * ResultSet, or via
 * {@link com.smartgwt.client.widgets.grid.ListGridField#sortNormalizer ListGridField.sortNormalizer()} for a
 * ListGrid-managed ResultSet.
 *  <P>
 *  By default, client-side filtering interprets the {@link com.smartgwt.client.data.Criteria criteria} passed to
 *  {@link com.smartgwt.client.data.ResultSet#setCriteria setCriteria()} as a set of field values that records must match
 *  (similarly to the built-in SQL/Hibernate connectors built into the Smart GWT Server).
 *  Custom client-side filtering logic can be implemented by overriding
 *  {@link com.smartgwt.client.data.ResultSet#applyFilter applyFilter()}.  Overriding
 *  {@link com.smartgwt.client.data.ResultSet#compareCriteria compareCriteria()} allows you to control when the ResultSet
 *  uses client-side vs server-side filtering, and the ResultSet has two default 
 *  {@link com.smartgwt.client.data.ResultSet#getCriteriaPolicy criteria policies} built-in.
 *  <P>
 *  <b>Modifying ResultSets</b>
 *  <P>
 *  Records cannot be directly added or removed from a ResultSet via {@link com.smartgwt.client.data.List}
 *  APIs such as {@link com.smartgwt.client.data.List#removeAt removeAt()}, since this would break the consistency of
 *  server and client row numbering needed for data paging, and also
 *  create some issues with automatic cache synchronization.
 *  <P>
 * Use {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()}/{@link
 * com.smartgwt.client.data.DataSource#removeData removeData()} to add/remove
 *  rows from the {@link com.smartgwt.client.data.DataSource}, and the ResultSet will reflect the changes automatically.
 * Alternatively, the {@link com.smartgwt.client.data.DataSource#updateCaches DataSource.updateCaches()} method may be
 * called to only update
 *  local caches of the DataSource in question, without generating any server traffic.
 *  <P>
 *  To create a locally modifiable cache of Records from a DataSource, you
 * can use {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} to retrieve a List of Records which
 * can
 *  be modified directly, or you can create a client-only {@link com.smartgwt.client.data.DataSource} from
 *  the retrieved data to share a modifiable cache between several
 *  DataBoundComponents.
 *  <P>
 *  <b>Updates and Automatic Cache Synchronization</b>
 *  <P>
 *  Once a ResultSet has retrieved data or has been initialized with data, the ResultSet will observe any
 *  successful "update", "add" or "remove" dsRequests against their DataSource, regardless of the
 *  component that initiated them.  A ResultSet with a full cache for the current filter criteria will
 *  integrate updates into the cache automatically.
 *  <P>
 *  Updated rows that no longer match the current filter criteria will be removed
 * automatically.  To prevent this, you can set {@link com.smartgwt.client.data.ResultSet#getNeverDropUpdatedRows
 * neverDropUpdatedRows}.
 *  Added rows will similarly be added to the cache only if they match current filter criteria.
 *  <P>
 *  Note that the client-side filtering described above is also used to determine whether 
 *  updated or added rows should be in the cache.  If any aspect of automated cache update is
 *  ever incorrect, {@link com.smartgwt.client.data.ResultSet#getDropCacheOnUpdate dropCacheOnUpdate} can be set for the
 * ResultSet or {@link com.smartgwt.client.data.DSResponse#getInvalidateCache DSResponse.invalidateCache} can be set for an
 * individual dsResponse.
 *  <P>
 *  If automatic cache synchronization isn't working, troubleshoot the problem using the steps
 * suggested <a href='http://forums.smartclient.com/showthread.php?t=8159#aGrid'
 * target='_blank'>in the FAQ</a>.
 *  <P>
 *  Regarding {@link com.smartgwt.client.data.OperationBinding#getOperationId operationIds} and how they affect caching,
 *  take into account that cache sync is based on the fetch used - any add or update operation
 *  uses a fetch to retrieve updated data, and the operationId of that fetch can be set via
 *  {@link com.smartgwt.client.data.OperationBinding#getCacheSyncOperation cacheSyncOperation}.
 *  If the operationId of the cache is different from the operationId of the cache update data,
 *  it won't be used to update the cache, since the fields included and other aspects of the
 *  data are allowed to be different across different operationIds. This allows to maintain
 *  distinct caches on a per component basis, so when two components are using separate
 *  operationIds they are assumed to have distinct caches, because updates performed with
 *  one operationId will not affect the cache obtained via another operationId.
 *  Also, take into account that operationId must be unique per DataSource, across all
 *  operationTypes for that DataSource.
 * 
 *  <P>
 *  <b>Data Paging with partial cache</b>
 *  <P>
 *  When in paging mode with a partial cache, a ResultSet relies on server side sorting, setting 
 * {@link com.smartgwt.client.data.DSRequest#getSortBy DSRequest.sortBy} to the current sort field and direction.  In order
 * for the cache to 
 *  remain coherent, row numbering must continue to agree between server and client as new
 *  fetches are issued, otherwise, duplicate rows or missing rows may occur.  
 *  <P>
 *  If concurrent modifications by other users are allowed, generally the server should set
 * {@link com.smartgwt.client.data.DSResponse#getInvalidateCache DSResponse.invalidateCache} to clear the cache when
 * concurrent modification is
 *  detected.
 *  <P>
 *  In paging mode with a partial cache, any successful "update" or "add" operation may cause
 *  client and server row numbering to become out of sync.  This happens because the update
 *  may affect the sort order, and client and server cannot be guaranteed to match for sets of
 *  records that have equivalent values for the sort field.
 *  <P>
 *  For this reason, after an "add" or "update" operation with a partial cache, the ResultSet
 *  will automatically mark cache for invalidation the next time a fetch operation is performed.
 * Alternatively, if {@link com.smartgwt.client.data.ResultSet#getUpdatePartialCache updatePartialCache} is set to false,
 * the ResultSet will
 *  simply invalidate cache immediately in this circumstance.
 * @see com.smartgwt.client.widgets.DataBoundComponent
 * @see com.smartgwt.client.data.DataSource#getResultSetClass
 * @see com.smartgwt.client.data.ResultSet#getRange
 */
public class ResultSet extends RecordList implements com.smartgwt.client.data.events.HasDataArrivedHandlers {

    private boolean ensuringCreated = false;

    public static ResultSet getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = getRef(jsObj);
        if (obj == null) {
            obj = new ResultSet(jsObj);
        }
        return (ResultSet)obj;
    }

    public ResultSet(){
        scClassName = "ResultSet";
    }

    public ResultSet(DataSource dataSource) {
        setDataSource(dataSource);
        scClassName = "ResultSet";
    }

    public ResultSet(JavaScriptObject jsObj){
        super(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        scClassName = "ResultSet";
        onBind();
    }

    @Override
    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()(),
            rs;
        if (this.@com.smartgwt.client.data.ResultSet::ensuringCreated) {
            var selfJ = this;
            rs = $wnd.isc.ResultSet.create(config, {
                init : $entry(function () {
                    selfJ.@com.smartgwt.client.data.RecordList::jsObj = this;
                    return this.Super("init", arguments);
                })
            });
        } else {
            rs = $wnd.isc.ResultSet.create(config);
        }
        return rs;
    }-*/;

    /**
     * Returns the existing SGWT ResultSet, or creates and returns one if none exist,
     * associated with the supplied {@link com.google.gwt.core.client.JavaScriptObject}.  If
     * the supplied object is not a SmartClient ResultSet, a warning will be logged and null
     * returned; otherwise the SGWT ResultSet will be returned.
     *
     * @param jsObj SmartClient ResultSet whose wrapper is wanted
     *
     * @return wrapping SGWT ResultSet or null
     */
    public static native ResultSet asSGWTComponent(JavaScriptObject jsObj) /*-{
       if ($wnd.isc.isA.ResultSet(jsObj)) {
           return @com.smartgwt.client.data.ResultSet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
       } 
       var className = $wnd.isc.isAn.Instance(jsObj) ? jsObj.getScClassName() : "none";
       @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)("ResultSet.asSGWTComponent(): " +
           "The supplied JS object must be a ResultSet - actual class is " + className + ".");
       return null;
    }-*/;

    /**
     * Ensures that the underlying SmartClient ResultSet object is created for this ResultSet
     * instance. If the SmartClient object has already been created, then calling this method
     * amounts to a no-op. Otherwise, the <code>isc.ResultSet.create()</code> function is
     * executed to create the SmartClient ResultSet object wrapped by this instance.
     * <p>
     * This method is required to be called for standalone usage of a ResultSet. In addition,
     * it can only be called after all initial configuration ({@link #getDataSource() dataSource},
     * {@link #setAllRows(Record[]) allRows} if being used, etc.) has been set.
     * 
     * @throws IllegalStateException if no dataSource has been set
     */
    public void ensureCreated() throws IllegalStateException {
        if (jsObj == null) {
            final JavaScriptObject dataSource = JSOHelper.getAttributeAsJavaScriptObject(getConfig(), "dataSource");
            if (dataSource == null) throw new IllegalStateException("Cannot create the ResultSet without a dataSource.");
        }
        this.ensuringCreated = true;
        getOrCreateJsObj();
        this.ensuringCreated = false;
    }

    /** 
     * This method returns a Map of config properties suitable for use as the "defaults" 
     * attribute of a {@link com.smartgwt.client.tools.PaletteNode}.  Use it when you need to
     * work with PaletteNodes indirectly, such when setting up 
     * {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be used in a 
     * {@link com.smartgwt.client.tools.TilePalette}.  See 
     * {@link com.smartgwt.client.docs.DevTools the dev tools overview} for examples of how to
     * assemble and acquire a suitable defaults object when you are creating a PaletteNode 
     * indirectly
     */
    public Map getPaletteDefaults() {
        if (isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "getPaletteDefaults", (String)null);
        }
        return JSOHelper.convertToMap(JSOHelper.cleanProperties(getConfig(), true));
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Mode of fetching records from the server. If unset, will default to <code>"local"</code> if {@link
     * ResultSet#getAllRows allRows} is specified, otherwise <code>"paged"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchMode fetchMode Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFetchMode(FetchMode fetchMode) throws IllegalStateException {
        setAttribute("fetchMode", fetchMode.getValue(), false);
    }

    /**
     * Mode of fetching records from the server. If unset, will default to <code>"local"</code> if {@link
     * ResultSet#getAllRows allRows} is specified, otherwise <code>"paged"</code>.
     *
     *
     * @return FetchMode
     */
    public FetchMode getFetchMode()  {
        return (FetchMode) EnumUtil.getEnum(FetchMode.values(), getAttribute("fetchMode"));
    }

    /**
     * Initial set of data for the ResultSet. <P> 
     * This data will be treated exactly as though it were the data returned from
     * the ResultSet's first server fetch. <P> By default, <code>initialData</code> will be considered a complete response (all
     * rows that match the {@link Criteria} which the ResultSet was initialized with). <P> Set {@link
     * ResultSet#getInitialLength initialLength} to treat <code>initialData</code> as a partial
     * response, equivalent to receiving a {@link DSResponse} with <code>startRow:0</code>,
     * <code>endRow:initialData.length</code> and <code>totalRows:initialLength</code>. Normal data paging will then occur if
     * data is requested for row indices not filled via  <code>initialData</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param initialData initialData Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInitialData(Record[] initialData) throws IllegalStateException {
        setAttribute("initialData", initialData, false);
    }

    /**
     * Initial value of the data set length. <P> To create a ResultSet with it's cache partly filled, see {@link
     * ResultSet#getInitialData initialData}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param initialLength initialLength Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInitialLength(Integer initialLength) throws IllegalStateException {
        setAttribute("initialLength", initialLength, false);
    }
    
    /**
     * Initial multi property sort specification for this ResultSet's data. If a ResultSet is being
     * explicitly created and seeded with {@link #setInitialData(Record[])}, this method may be used
     * to notify the ResultSet that the data is already sorted such that a call to {@link #setSort(SortSpecifier...)} will
     * not require a new fetch unless additional data beyond the ends of the specified initialData are required.
     * @param sortSpecifiers Initial sort specification
     */
    public void setInitialSort(SortSpecifier... sortSpecifiers){
        JavaScriptObject jsSortArray = JSOHelper.convertToJavaScriptArray(sortSpecifiers);
        setAttribute("sortSpecifiers", jsSortArray, false);
    }

    /**
     * If the complete set of records for a resultSet is available when the resultSet is created, it can be made available to
     * the resultSet via this property at initialization time. This data will then be considered cached meaning sorting and
     * filtering can occur on the client (no need for server fetch). This cached data can be dropped via a call to {@link
     * ResultSet#invalidateCache}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allRows allRows Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAllRows(Record[] allRows) throws IllegalStateException {
        setAttribute("allRows", allRows, false);
    }

    /**
     * How many rows to retrieve at once. <P> Applicable only with <code>fetchMode: "paged"</code>.  When a paged ResultSet is
     * asked for rows that have not yet been loaded, it will fetch adjacent rows that are likely to be required soon, in
     * batches of this size.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resultSize resultSize Default value is 75
     */
    public void setResultSize(int resultSize) {
        setAttribute("resultSize", resultSize, true);
    }

    /**
     * How many rows to retrieve at once. <P> Applicable only with <code>fetchMode: "paged"</code>.  When a paged ResultSet is
     * asked for rows that have not yet been loaded, it will fetch adjacent rows that are likely to be required soon, in
     * batches of this size.
     *
     *
     * @return int
     */
    public int getResultSize()  {
        return getAttributeAsInt("resultSize");
    }

    /**
     * Delay in milliseconds before fetching rows. <P> When a get() or getRange() call asked for rows that haven't been loaded,
     * the ResultSet will wait before actually triggering the request.  If, during the delay, more get() or getRange() calls
     * are made for missing rows, the final fetch to the server will reflect the most recently requested rows. <P> The intent
     * of this delay is to avoid triggering many unnecessary fetches during drag-scrolling and similar user interactions.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchDelay fetchDelay Default value is 0
     */
    public void setFetchDelay(int fetchDelay) {
        setAttribute("fetchDelay", fetchDelay, true);
    }

    /**
     * Delay in milliseconds before fetching rows. <P> When a get() or getRange() call asked for rows that haven't been loaded,
     * the ResultSet will wait before actually triggering the request.  If, during the delay, more get() or getRange() calls
     * are made for missing rows, the final fetch to the server will reflect the most recently requested rows. <P> The intent
     * of this delay is to avoid triggering many unnecessary fetches during drag-scrolling and similar user interactions.
     *
     *
     * @return int
     */
    public int getFetchDelay()  {
        return getAttributeAsInt("fetchDelay");
    }

    /**
     * What {@link DataSource} is this resultSet associated with?
     *
     * @param dataSource dataSource Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataSource(DataSource dataSource) throws IllegalStateException {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), false);
    }

    /**
     * What {@link DataSource} is this resultSet associated with?
     *
     *
     * @return DataSource
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    /**
     * Operation this dataModel should use to fetch sets of objects
     *
     * @param fetchOperation fetchOperation Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, false);
    }

    /**
     * Operation this dataModel should use to fetch sets of objects
     *
     *
     * @return String
     */
    public String getFetchOperation()  {
        return getAttributeAsString("fetchOperation");
    }

    /**
     * Filter criteria used whenever records are retrieved. <P> Use {@link ResultSet#setCriteria} to
     * change the criteria after initialization.
     * Set the filter criteria to use when fetching rows. <P> Setting new criteria will invalidate the current cache, if any. <P> Note: any field values in the criteria explicitly specified as null will be passed to the server. By default the server then returns only records whose value is null for that field. This differs from certain higher level methods such as  {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} which prune null criteria fields before performing a fetch operation.
     *
     * @param criteria the filter criteria. Default value is null
     */
    public void setCriteria(Criteria criteria) {
        setAttribute("criteria", criteria == null ? null : criteria.getJsObj(), true);
    }

    /**
     * Filter criteria used whenever records are retrieved. <P> Use {@link ResultSet#setCriteria} to
     * change the criteria after initialization.
     *
     *
     * @return Get the current criteria for this ResultSet.
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }

    /**
     * Decides under what conditions the cache should be dropped when the {@link Criteria} changes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param criteriaPolicy criteriaPolicy Default value is null
     */
    public void setCriteriaPolicy(CriteriaPolicy criteriaPolicy) {
        setAttribute("criteriaPolicy", criteriaPolicy.getValue(), true);
    }

    /**
     * Decides under what conditions the cache should be dropped when the {@link Criteria} changes.
     *
     *
     * @return CriteriaPolicy
     */
    public CriteriaPolicy getCriteriaPolicy()  {
        return (CriteriaPolicy) EnumUtil.getEnum(CriteriaPolicy.values(), getAttribute("criteriaPolicy"));
    }

    /**
     * Whether to sort data locally when all records matching the current criteria have been cached. <P> This may need to be
     * disabled if client-side sort order differs from server-side sort order in a way that affects functionality or is
     * surprising.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useClientSorting useClientSorting Default value is true
     */
    public void setUseClientSorting(Boolean useClientSorting) {
        setAttribute("useClientSorting", useClientSorting, true);
    }

    /**
     * Whether to sort data locally when all records matching the current criteria have been cached. <P> This may need to be
     * disabled if client-side sort order differs from server-side sort order in a way that affects functionality or is
     * surprising.
     *
     *
     * @return Boolean
     */
    public Boolean getUseClientSorting()  {
        return getAttributeAsBoolean("useClientSorting");
    }

    /**
     * Whether to filter data locally when all DataSource records have been loaded (that is, criteria is blank and cache is
     * complete). <P> This may need to be disabled if client-side filtering differs from server-side filtering in a way that
     * affects functionality or is surprising. <P> This setting is distinct from <code>fetchMode:"local"</code>, which
     * explicitly loads all available DataSource records up front. <P> See {@link
     * ResultSet#applyFilter} for default filtering behavior. <P> <b>NOTE:</b> even with
     * useClientFiltering false, client-side filtering will be used during cache sync to determine if an updated or added row
     * matches the current criteria. To avoid relying on client-side filtering in this case, either:<br> - avoid returning
     * update data when the updated row doesn't match the current filter<br> - set dropCacheOnUpdate<br>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useClientFiltering useClientFiltering Default value is true
     */
    public void setUseClientFiltering(Boolean useClientFiltering) {
        setAttribute("useClientFiltering", useClientFiltering, true);
    }

    /**
     * Whether to filter data locally when all DataSource records have been loaded (that is, criteria is blank and cache is
     * complete). <P> This may need to be disabled if client-side filtering differs from server-side filtering in a way that
     * affects functionality or is surprising. <P> This setting is distinct from <code>fetchMode:"local"</code>, which
     * explicitly loads all available DataSource records up front. <P> See {@link
     * ResultSet#applyFilter} for default filtering behavior. <P> <b>NOTE:</b> even with
     * useClientFiltering false, client-side filtering will be used during cache sync to determine if an updated or added row
     * matches the current criteria. To avoid relying on client-side filtering in this case, either:<br> - avoid returning
     * update data when the updated row doesn't match the current filter<br> - set dropCacheOnUpdate<br>
     *
     *
     * @return Boolean
     */
    public Boolean getUseClientFiltering()  {
        return getAttributeAsBoolean("useClientFiltering");
    }

    /**
     * When a successful Add, Update or Remove type operation fires on this ResultSet's  dataSource, if {@link
     * DSResponse#getData data} is unset, should we integrate the submitted data values (from the
     * request) into our data-set? This attribute will be passed to {@link DataSource#getUpdatedData}
     * as the <code>useDataFromRequest</code> parameter.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updateCacheFromRequest updateCacheFromRequest Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUpdateCacheFromRequest(Boolean updateCacheFromRequest) throws IllegalStateException {
        setAttribute("updateCacheFromRequest", updateCacheFromRequest, false);
    }

    /**
     * When a successful Add, Update or Remove type operation fires on this ResultSet's  dataSource, if {@link
     * DSResponse#getData data} is unset, should we integrate the submitted data values (from the
     * request) into our data-set? This attribute will be passed to {@link DataSource#getUpdatedData}
     * as the <code>useDataFromRequest</code> parameter.
     *
     *
     * @return Boolean
     */
    public Boolean getUpdateCacheFromRequest()  {
        return getAttributeAsBoolean("updateCacheFromRequest");
    }

    /**
     * Whether to discard all cached rows when a modification operation (add, update, remove) occurs on the ResultSet's
     * DataSource. <P> A ResultSet that has a complete cache for the current filter criteria can potentially incorporate a
     * newly created or updated row based on the data that the server returns when a modification operation completes.  However
     * this is not always possible for ResultSets that show some types of joins, or when the server cannot easily return update
     * data.  In this case set <code>dropCacheOnUpdate</code> to cause the cache to be discarded when an update occurs. <P>
     * <code>dropCacheOnUpdate</code> can be set either directly on a ResultSet, or on a DataSource in order to affect all
     * ResultSets on that DataSource.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dropCacheOnUpdate dropCacheOnUpdate Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDropCacheOnUpdate(Boolean dropCacheOnUpdate) throws IllegalStateException {
        setAttribute("dropCacheOnUpdate", dropCacheOnUpdate, false);
    }

    /**
     * Whether to discard all cached rows when a modification operation (add, update, remove) occurs on the ResultSet's
     * DataSource. <P> A ResultSet that has a complete cache for the current filter criteria can potentially incorporate a
     * newly created or updated row based on the data that the server returns when a modification operation completes.  However
     * this is not always possible for ResultSets that show some types of joins, or when the server cannot easily return update
     * data.  In this case set <code>dropCacheOnUpdate</code> to cause the cache to be discarded when an update occurs. <P>
     * <code>dropCacheOnUpdate</code> can be set either directly on a ResultSet, or on a DataSource in order to affect all
     * ResultSets on that DataSource.
     *
     *
     * @return Boolean
     */
    public Boolean getDropCacheOnUpdate()  {
        return getAttributeAsBoolean("dropCacheOnUpdate");
    }

    /**
     * By default when the data of this ResultSet's dataSource is modified, the ResultSet will be updated to display these
     * changes. Set this flag to true to disable this behavior.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disableCacheSync disableCacheSync Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDisableCacheSync(Boolean disableCacheSync) throws IllegalStateException {
        setAttribute("disableCacheSync", disableCacheSync, false);
    }

    /**
     * By default when the data of this ResultSet's dataSource is modified, the ResultSet will be updated to display these
     * changes. Set this flag to true to disable this behavior.
     *
     *
     * @return Boolean
     */
    public Boolean getDisableCacheSync()  {
        return getAttributeAsBoolean("disableCacheSync");
    }

    /**
     * By default when a a row is returned by the server, the current {@link ResultSet#setCriteria}
     * are applied to it, and it may disappear from the cache. <P> Set this flag to true to disable this behavior.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param neverDropUpdatedRows neverDropUpdatedRows Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setNeverDropUpdatedRows(Boolean neverDropUpdatedRows) throws IllegalStateException {
        setAttribute("neverDropUpdatedRows", neverDropUpdatedRows, false);
    }

    /**
     * By default when a a row is returned by the server, the current {@link ResultSet#setCriteria}
     * are applied to it, and it may disappear from the cache. <P> Set this flag to true to disable this behavior.
     *
     *
     * @return Boolean
     */
    public Boolean getNeverDropUpdatedRows()  {
        return getAttributeAsBoolean("neverDropUpdatedRows");
    }

    /**
     * If set to true, updated and added rows will be integrated into the client-side cache even if paging is enabled and cache
     * is partial.  If <code>updatePartialCache</code> is false, the cache will be invalidated and new data fetched. <P> If
     * updatePartialCache is enabled and an "add" or "update" operation succeeds with a partial cache: <ul> <li> updated rows
     * will remain in their current position.  No attempt will be made to sort them into a new position even if the sort field
     * was updated. <li> newly added rows will be added at either the end (first preference) or beginning of the dataset if
     * that part of the dataset is cached and was most recently requested. If not, the new row is added at the end of the most
     * recently requested contiguously cached range </ul> The cache will then be dropped the next time rows are fetched, to
     * prevent problems with inconsistent row numbering between the server and client, which could otherwise lead to duplicate
     * rows or rows being skipped entirely.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updatePartialCache updatePartialCache Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUpdatePartialCache(Boolean updatePartialCache) throws IllegalStateException {
        setAttribute("updatePartialCache", updatePartialCache, false);
    }

    /**
     * If set to true, updated and added rows will be integrated into the client-side cache even if paging is enabled and cache
     * is partial.  If <code>updatePartialCache</code> is false, the cache will be invalidated and new data fetched. <P> If
     * updatePartialCache is enabled and an "add" or "update" operation succeeds with a partial cache: <ul> <li> updated rows
     * will remain in their current position.  No attempt will be made to sort them into a new position even if the sort field
     * was updated. <li> newly added rows will be added at either the end (first preference) or beginning of the dataset if
     * that part of the dataset is cached and was most recently requested. If not, the new row is added at the end of the most
     * recently requested contiguously cached range </ul> The cache will then be dropped the next time rows are fetched, to
     * prevent problems with inconsistent row numbering between the server and client, which could otherwise lead to duplicate
     * rows or rows being skipped entirely.
     *
     *
     * @return Boolean
     */
    public Boolean getUpdatePartialCache()  {
        return getAttributeAsBoolean("updatePartialCache");
    }

    /**
     * If true, records requested only for visible area.
     *
     * @param alwaysRequestVisibleRows alwaysRequestVisibleRows Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAlwaysRequestVisibleRows(Boolean alwaysRequestVisibleRows) throws IllegalStateException {
        setAttribute("alwaysRequestVisibleRows", alwaysRequestVisibleRows, false);
    }

    /**
     * If true, records requested only for visible area.
     *
     * @return Boolean
     */
    public Boolean getAlwaysRequestVisibleRows()  {
        return getAttributeAsBoolean("alwaysRequestVisibleRows");
    }

    // ********************* Methods ***********************

    /**
     * Do we have a complete client-side cache of records for the current filter criteria? <P> Returns false if this is a paged
     * data set, and the entire set of records that match the current criteria has not been retrieved from the server.
     *
     * @return allMatchingRowsCached
     */
    public native boolean allMatchingRowsCached() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.allMatchingRowsCached();
    }-*/;

    /**
     * Do we have a complete client-side cache of all records for this DataSource? <P> Becomes true only when the ResultSet
     * obtains a complete cache after a fetch with empty criteria.
     *
     * @return allRowsCached
     */
    public native boolean allRowsCached() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.allRowsCached();
    }-*/;

    /**
     * Get a map of the form <code>{ item[idField] -&gt; item[displayField] }</code>, for all  items in the list.  If more than
     * one item has the same <code>idProperty</code>,  the value for the later item in the list will clobber the value for the
     * earlier item. <P> If this method is called when the {@link ResultSet#allMatchingRowsCached}, it
     * will trigger fetches, and will return a valueMap reflecting only the currently loaded rows.
     * @param idField Property to use as ID (data value) in the valueMap
     * @param displayField Property to use a display value in the valueMap
     *
     * @return valueMap object
     */
    public native Map getValueMap(String idField, String displayField) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var mapJS = self.getValueMap(idField, displayField);
        return mapJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(mapJS);
    }-*/;

    /**
     * Return the total number of records that match the current filter criteria. <P> This length can only be known, even
     * approximately, when the first results are retrieved from the server.  Before then, the ResultSet returns a large length
     * in order to encourage viewers to ask for rows.  {@link ResultSet#lengthIsKnown} can be called
     * to determine whether an actual length is known.
     *
     * @return number of items in the list
     */
    public native int getLength() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getLength();
    }-*/;

    /**
     * Return the position in the list of the first instance of the specified object. <p> If pos is specified, starts looking
     * after that position. <p> Returns -1 if not found. <p> <b>NOTE:</b> ResultSet.indexOf() only inspects the current cache
     * of records, so it is only appropriate for temporary presentation purposes.  For example, it would not be appropriate to
     * hold onto a record and attempt to use indexOf() to determine if it had been deleted.
     * @param record object to look for
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int indexOf(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.indexOf(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Return the position in the list of the first instance of the specified object. <p> If pos is specified, starts looking
     * after that position. <p> Returns -1 if not found. <p> <b>NOTE:</b> ResultSet.indexOf() only inspects the current cache
     * of records, so it is only appropriate for temporary presentation purposes.  For example, it would not be appropriate to
     * hold onto a record and attempt to use indexOf() to determine if it had been deleted.
     * @param record object to look for
     * @param pos earliest index to consider
     * @param endPos last index to consider
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int indexOf(Record record, int pos, int endPos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.indexOf(record.@com.smartgwt.client.data.Record::getJsObj()(), pos, endPos);
    }-*/;

    /**
     * Returns the record at the specified position. <P> All List access methods of the ResultSet have the semantics described
     * in <code>getRange()</code>.
     * @param pos position of the element to get
     *
     * @return whatever's at that position, null if not found
     */
    public native Record get(int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.get(pos);
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Return the items between position start and end, non-inclusive at the end, possibly  containing markers for records that
     * haven't loaded yet. <P> Calling getRange for records that have not yet loaded will trigger an asynchronous fetch.  The
     * returned data will contain the {@link ResultSet#getLoadingMarker() loading marker} as a placeholder for records being fetched.  If
     * any rows needed to be fetched, <code>dataArrived()</code> will fire when they arrive.
     * @param start start position
     * @param end end position
     *
     * @return subset of the array from start -> end-1
     */
    public native Record[] getRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getRange(start, end);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Return a RecordList with the items between position start and end, non-inclusive at the end.
     * @param start start position
     * @param end end position
     *
     * @return a RecordList containing the items from start -> end-1
     */
    public native RecordList getRangeAsRecordList(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getRange(start, end);
        return (recordsJS == null || recordsJS === undefined) ? null :
                @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Returns a list of the currently visible data, that is, all rows that match the current
     * criteria, with null entries or {@link ResultSet#getLoadingMarker() loading markers} for
     * rows that are not yet loaded or in the process of loading, respectively.
     * <P>
     * This method will not trigger a fetch to load more records.  getAllVisibileRows() will return
     * null if {@link ResultSet#lengthIsKnown()} is false.
     * <P>
     * Records are returned in a new List but the Records within it are the same
     * instances that the ResultSet is holding onto.  Hence it's safe to add or remove records from
     * the List without affecting the ResultSet but modifying the Records themselves is a direct
     * modification of the client-side cache.
     * @return the records in the cache that match the current criteria, possibly null
     */
    public native RecordList getAllVisibleRows() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getAllVisibleRows();
        return (recordsJS == null || recordsJS === undefined) ? null :
                @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Determine whether the ResultSet is showing a filtered, proper subset of the cached rows.
     * This happens if {@link ResultSet#getUseClientFiltering() client filtering} is enabled.  Rows may have been
     * loaded from the server when a more restrictive criteria is applied such that filtering could
     * be performed on the client side.
     * <P>
     * This method returns false if data is not loaded yet.
     * @return true if the ResultSet is showing a filtered subset of the cached rows,
     * false otherwise.
     * @see ResultSet#getAllCachedRows()
     */
    public native Boolean usingFilteredData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal = self.usingFilteredData();
        if (retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Returns a list of all rows that have been cached.  This is potentially a superset of all rows that are
     * available via {@link ResultSet#getAllVisibleRows()} if the ResultSet is using client-side filtering to
     * display a subset of loaded rows (see the {@link ResultSet ResultSet overview}).
     * <P>
     * If {@link ResultSet#usingFilteredData()} returns false, this is the same list as would be returned by
     * {@link ResultSet#getAllVisibleRows()}.
     * <P>
     * This method will not trigger a fetch to load more records.  getAllCachedRows() will return
     * null if {@link ResultSet#lengthIsKnown()} is false.
     * <P>
     * Records are returned in a new List but the Records within it are the same
     * instances that the ResultSet is holding onto.  Hence it's safe to add or remove records from
     * the List without affecting the ResultSet but modifying the Records themselves is a direct
     * modification of the client-side cache.
     * @return the records in the cache, possibly null
     */
    public native RecordList getAllCachedRows() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getAllCachedRows();
        return (recordsJS == null || recordsJS === undefined) ? null :
                @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Whether the ResultSet actually knows how many records are available from the server. The ResultSet will not know how
     * many records are available when initially fetching and  filtering data. Note that the value returned from {@link
     * ResultSet#getLength} will be  an arbitrary, large value if the actual length is not known.
     *
     * @return whether length is known
     */
    public native Boolean lengthIsKnown() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.lengthIsKnown();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Whether the given row has been loaded. <p> Unlike get(), will not trigger a server fetch.
     * @param rowNum row to check
     *
     * @return true whether if the given row has been loaded, false if it has not been                   loaded or is still in the
     * process of bring loaded
     */
    public native Boolean rowIsLoaded(int rowNum) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.rowIsLoaded(rowNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Whether the given range of rows has been loaded. Unlike getRange(), will not trigger a server fetch.
     * @param startRow start position, inclusive
     * @param endRow end position, exclusive
     *
     * @return true if all rows in the given range have been loaded, false if any rows in                   the range have not been
     * loaded or are still in the process of being loaded
     */
    public native Boolean rangeIsLoaded(int startRow, int endRow) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.rangeIsLoaded(startRow, endRow);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Attempt to find the record in the resultSet that has a primary key value that matches the  passed in parameter value.
     * Only the locally cached data will be searched.  Checks only loaded rows and will not trigger a fetch. Returns null if
     * there is no match,  data is not loaded, or there is no {@link ResultSet#getDataSource
     * 'dataSource'}.
     * @param keyValue primary key value to search for
     *
     * @return the record with a matching primary key field, or null if not found
     */
    public native Record findByKey(String keyValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.findByKey(keyValue);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;



    /**
     * Default behavior is to call {@link DataSource#compareCriteria} to determine whether new
     * criteria is guaranteed more restrictive, equivalent to the old criteria, or not guaranteed more restrictive, returning
     * 1, 0 or -1 respectively. <P> Override this method or {@link DataSource#compareCriteria} to
     * implement your own client-side filtering behavior.
     * @param newCriteria new filter criteria
     * @param oldCriteria old filter criteria
     *
     * @return 0 if the filters are equivalent, 1 if newFilter is guaranteed more                      restrictive, and -1 if newFilter
     * is not guaranteed more restrictive
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Default behavior is to call {@link DataSource#compareCriteria} to determine whether new
     * criteria is guaranteed more restrictive, equivalent to the old criteria, or not guaranteed more restrictive, returning
     * 1, 0 or -1 respectively. <P> Override this method or {@link DataSource#compareCriteria} to
     * implement your own client-side filtering behavior.
     * @param newCriteria new filter criteria
     * @param oldCriteria old filter criteria
     * @param requestProperties dataSource request properties
     * @param policy overrides {@link com.smartgwt.client.types.CriteriaPolicy}
     *
     * @return 0 if the filters are equivalent, 1 if newFilter is guaranteed more                      restrictive, and -1 if newFilter
     * is not guaranteed more restrictive
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria, DSRequest requestProperties, String policy) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties.@com.smartgwt.client.data.DSRequest::getJsObj()(), policy);
    }-*/;

    /**
     * Will changing the criteria for this resultSet require fetching new data from the server,  or can the new criteria be
     * satisfied from data already cached on the client?<br> Second <code>textMatchStyle</code> parameter determines whether a
     * change of text-match style will require a server fetch - for example if filter is being changed between an exact match
     * (from e.g: {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}) and a substring match  (from e.g: {@link
     * com.smartgwt.client.widgets.grid.ListGrid#filterData}).<br> This method can be used to determine whether {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData} or  {@link com.smartgwt.client.widgets.grid.ListGrid#filterData}
     * would cause a server side fetch when passed a certain set of  criteria.
     * @param newCriteria new criteria to test.
     *
     * @return true if server fetch would be required to satisfy new criteria.
     */
    public native Boolean willFetchData(Criteria newCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Will changing the criteria for this resultSet require fetching new data from the server,  or can the new criteria be
     * satisfied from data already cached on the client?<br> Second <code>textMatchStyle</code> parameter determines whether a
     * change of text-match style will require a server fetch - for example if filter is being changed between an exact match
     * (from e.g: {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}) and a substring match  (from e.g: {@link
     * com.smartgwt.client.widgets.grid.ListGrid#filterData}).<br> This method can be used to determine whether {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData} or  {@link com.smartgwt.client.widgets.grid.ListGrid#filterData}
     * would cause a server side fetch when passed a certain set of  criteria.
     * @param newCriteria new criteria to test.
     * @param textMatchStyle New text match style. If not passed assumes       textMatchStyle will not be modified.
     *
     * @return true if server fetch would be required to satisfy new criteria.
     */
    public native Boolean willFetchData(Criteria newCriteria, String textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.willFetchData(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), textMatchStyle);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Derive the current filtered set of data from the cache of all matching rows. <P> This method is automatically called by
     * {@link ResultSet#setCriteria} when criteria have actually changed, as well as in various other
     * situations.  You could only need to call this method directly if: <ul> <li> you know that client-side filtering is
     * enabled ({@link ResultSet#getUseClientFiltering useClientFiltering}:true) and active {@link
     * ResultSet#allMatchingRowsCached}. <li> you have directly, programmatically modified data within
     * the ResultSet such that it no longer matches the filter criteria <li> you want your modified records to disappear from
     * the list of visible records (that is, those accesible via {@link ResultSet#get}) </ul>
     */
    public native void filterLocalData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterLocalData();
    }-*/;

    /**
     * Manually invalidate this ResultSet's cache. <P> Generally a ResultSet will observe and incorporate updates to the
     * DataSource that provides it's records, but when this is not possible, <code>invalidateCache()</code> allows manual cache
     * invalidation. <P> <code>invalidateCache()</code> fires <code>dataChanged()</code>, which may cause components which as
     * using this ResultSet to request new data for display, triggering server fetches.
     */
    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;


    /**
     * Notification fired when data has arrived from the server and has been successfully integrated into the cache. <P> When
     * <code>dataArrived()</code> fires, an immediate call to <code>getRange()</code> with the <code>startRow</code> and
     * <code>endRow</code> passed as arguments will return a List with no {@link ResultSet#getLoadingMarker() loading markers}.
     * @param startRow starting index of rows that have just loaded
     * @param endRow ending index of rows that have just loaded, non-inclusive
     */
    public native void dataArrived(int startRow, int endRow) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.dataArrived(startRow, endRow);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     *
     * @param properties set of properties and values to match
     *
     * @return all matching Records or null if none found
     */
    public native Record[] findAll(Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(@com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, String value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, int value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, Long value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, float value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, boolean value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object.
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, Date value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value));
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Checks only loaded rows and will not trigger a fetch.
     * @param properties set of properties and values to match
     *
     * @return first matching object or null if not found
     */
    public native Record find(Map  properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.find(@com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#find}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return first matching object or null if not found
     */
    public native Record find(String propertyName, Object value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.find(propertyName, value);
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param properties set of properties and values to
     * match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(@com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, String value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, int value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, Long value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, float value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, boolean value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param propertyName property to match
     * @param value value to compare against
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, Date value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value));
    }-*/;    
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param properties set of properties and values to match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, String value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, int value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, Long value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, float value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, boolean value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;
    
    /**
     * Like {@link com.smartgwt.client.data.RecordList#findNextIndex}.  Checks only loaded rows and will not trigger a fetch.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, Date value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value), endIndex);
    }-*/;    

     /**
     * Add a dataArrived handler.
     * <p>
     * Notification fired when data has arrived from the server and has been successfully integrated into the cache. <P> When
     * <code>dataArrived()</code> fires, an immediate call to <code>getRange()</code> with the <code>startRow</code> and
     * <code>endRow</code> passed as arguments will return a List with no {@link ResultSet#getLoadingMarker() loading markers}.
     *
     * @param handler the dataArrived handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.data.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.data.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.data.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj,
            selfJ = this;
        if (this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        obj.dataArrived = $entry(function (startRow, endRow) {
            var param = { startRow: startRow, endRow: endRow };
            var event = @com.smartgwt.client.data.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
        });
    }-*/;

    // ********************* Static Methods ***********************

    public static native boolean isResultSet(JavaScriptObject data) /*-{
        return $wnd.isc.isA.ResultSet(data);
    }-*/;

    /**
     * Returns the singleton marker object that is used as a placeholder for records that are being
     * loaded from the server.
     * @return the loading marker
     */
    public static native Record getLoadingMarker() /*-{
        var recordJS = $wnd.isc.ResultSet.getLoadingMarker();
        return @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
}
