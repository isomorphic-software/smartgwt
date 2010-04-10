package com.smartgwt.client.widgets;

import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.data.*;
import com.google.gwt.core.client.JavaScriptObject;

import java.util.Map;

/**
 * A DataBoundComponent is a widget that can configure itself for viewing or editing objects which&#010 share a certain schema by "binding" to the schema for that object (called a "DataSource").&#010 <P>&#010 A schema (or DataSource) describes an object as consisting of a set of properties (or&#010 "fields").&#010 <P>&#010 DataBoundComponents have a {@link DataBoundComponent#getDataSource dataSource} for&#010 dealing with binding to DataSources, &#010 {@link DataBoundComponent#getFields fields} the schema information&#010 provided by a DataSource, and manipulating objects or sets of object from the DataSource.&#010 <P>&#010 The following visual components currently support databinding:<pre>&#010   {@link com.smartgwt.client.widgets.form.DynamicForm}&#010   {@link com.smartgwt.client.widgets.viewer.DetailViewer}&#010   {@link com.smartgwt.client.widgets.grid.ListGrid}&#010   {@link com.smartgwt.client.widgets.tree.TreeGrid}&#010   {@link com.smartgwt.client.widgets.tile.TileGrid}&#010   {@link com.smartgwt.client.widgets.grid.ColumnTree}&#010   {@link com.smartgwt.client..CubeGrid}&#010 </pre>&#010 The following non-visual components also support databinding:<pre>&#010   {@link com.smartgwt.client.widgets.form.ValuesManager}&#010   {@link com.smartgwt.client.data.ResultSet}&#010   {@link com.smartgwt.client..ResultTree}&#010 </pre>
 */
public interface DataBoundComponent {

    JavaScriptObject getOrCreateJsObj();

    /**
     * How to fetch and manage records retrieve from the server. See {@link FetchMode}.
     * <p>
     * This setting only applies to the {@link ResultSet} automatically created by calling {@link DataBoundComponent#fetchData(com.smartgwt.client.data.Criteria) fetchData}.
     * If a pre-existing ResultSet is passed to setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode() fetchMode}
     * applies.
     *
     * @param fetchMode the fetch mode
     */
    void setDataFetchMode(FetchMode fetchMode);

    /**
     * How to fetch and manage records retrieve from the server. See {@link FetchMode}.
     * <p>
     * This setting only applies to the {@link ResultSet} automatically created by calling {@link DataBoundComponent#fetchData(com.smartgwt.client.data.Criteria) fetchData}.
     * If a pre-existing ResultSet is passed to setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode() fetchMode}
     * applies.
     *
     * @return the fetch mode
     */
    FetchMode getDataFetchMode();

    /**
     * When using data paging, how many records to fetch at a time.  The value of this&#010 attribute is passed on to the auto-constructed {@link com.smartgwt.client.data.ResultSet} object for this&#010 component.  In effect, this gives you control over the {@link com.smartgwt.client.data.ResultSet#getResultSize resultSize}&#010 attribute for this component.&#010 <P>&#010 <b>Note</b> that regardless of the <code>dataPageSize</code> setting, a component will always fetch&#010 all of data that it needs to draw.  Settings such as&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords},&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAllMaxCells drawAllMaxCells} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} can cause more rows than the configured&#010 <code>dataPageSize</code> to be fetched.
     *
     * @param dataPageSize dataPageSize Default value is 75
     */
    void setDataPageSize(int dataPageSize);

    /**
     * When using data paging, how many records to fetch at a time.  The value of this&#010 attribute is passed on to the auto-constructed {@link com.smartgwt.client.data.ResultSet} object for this&#010 component.  In effect, this gives you control over the {@link com.smartgwt.client.data.ResultSet#getResultSize resultSize}&#010 attribute for this component.&#010 <P>&#010 <b>Note</b> that regardless of the <code>dataPageSize</code> setting, a component will always fetch&#010 all of data that it needs to draw.  Settings such as&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords},&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAllMaxCells drawAllMaxCells} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} can cause more rows than the configured&#010 <code>dataPageSize</code> to be fetched.
     *
     * @return int
     */
    int getDataPageSize();

    /**
     * If true, the set of fields given by the "default binding" (see &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields}) is used, with any fields specified in&#010 <code>component.fields</code> acting as overrides that can suppress or modify the&#010 display of individual fields, without having to list the entire set of fields that&#010 should be shown.&#010 <P>&#010 If <code>component.fields</code> contains fields that are not found in the DataSource,&#010 they will be shown after the most recently referred to DataSource field.  If the new&#010 fields appear first, they will be shown first.&#010 <P>&#010 ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component&#010 fields and DataSource fields, and how they interact for validation.
     *
     * @param useAllDataSourceFields useAllDataSourceFields Default value is false
     */
    void setUseAllDataSourceFields(Boolean useAllDataSourceFields);

    /**
     * If true, the set of fields given by the "default binding" (see &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields}) is used, with any fields specified in&#010 <code>component.fields</code> acting as overrides that can suppress or modify the&#010 display of individual fields, without having to list the entire set of fields that&#010 should be shown.&#010 <P>&#010 If <code>component.fields</code> contains fields that are not found in the DataSource,&#010 they will be shown after the most recently referred to DataSource field.  If the new&#010 fields appear first, they will be shown first.&#010 <P>&#010 ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component&#010 fields and DataSource fields, and how they interact for validation.
     *
     * @return Boolean
     */
    Boolean getUseAllDataSourceFields();

    /**
     * Whether to show fields marked <code>hidden:true</code> when a DataBoundComponent is given a&#010 DataSource but no <code>component.fields</code>.&#010 <p>&#010 The <code>hidden</code> property is used on DataSource fields to mark fields that are&#010 never of meaning to an end user.
     *
     * @param showHiddenFields showHiddenFields Default value is false
     */
    void setShowHiddenFields(Boolean showHiddenFields);

    /**
     * Whether to show fields marked <code>hidden:true</code> when a DataBoundComponent is given a&#010 DataSource but no <code>component.fields</code>.&#010 <p>&#010 The <code>hidden</code> property is used on DataSource fields to mark fields that are&#010 never of meaning to an end user.
     *
     * @return Boolean
     */
    Boolean getShowHiddenFields();

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is &#010 given a DataSource but no <code>component.fields</code>.&#010 <p>&#010 The <code>detail</code> property is used on DataSource fields to mark fields that &#010 shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields showDetailFields Default value is false
     */
    void setShowDetailFields(Boolean showDetailFields);

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is &#010 given a DataSource but no <code>component.fields</code>.&#010 <p>&#010 The <code>detail</code> property is used on DataSource fields to mark fields that &#010 shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @return Boolean
     */
    Boolean getShowDetailFields();

    /**
     * Whether to show fields of non-atomic types when a DataBoundComponent is given a&#010 DataSource but no <code>component.fields</code>.&#010 <p>&#010 If true, the component will show fields that declare a complex type, for example, a&#010 field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a&#010 DataSource that declares the fields of a shipping address (city, street name, etc).&#010 <P>&#010 Such fields may need custom formatters or editors in order to create a usable interface,&#010 for example, an Address field in a ListGrid might use a custom formatter to combine the&#010 relevant fields of an address into one column, and might use a pop-up dialog for&#010 editing.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showComplexFields showComplexFields Default value is true
     */
    void setShowComplexFields(Boolean showComplexFields);

    /**
     * Whether to show fields of non-atomic types when a DataBoundComponent is given a&#010 DataSource but no <code>component.fields</code>.&#010 <p>&#010 If true, the component will show fields that declare a complex type, for example, a&#010 field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a&#010 DataSource that declares the fields of a shipping address (city, street name, etc).&#010 <P>&#010 Such fields may need custom formatters or editors in order to create a usable interface,&#010 for example, an Address field in a ListGrid might use a custom formatter to combine the&#010 relevant fields of an address into one column, and might use a pop-up dialog for&#010 editing.
     *
     * @return Boolean
     */
    Boolean getShowComplexFields();

    /**
     * Operation ID this component should use when performing fetch operations.
     *
     * @param fetchOperation fetchOperation Default value is null
     */
    void setFetchOperation(String fetchOperation);

    /**
     * Operation ID this component should use when performing fetch operations.
     *
     * @return String
     */
    String getFetchOperation();

    /**
     * Operation ID this component should use when performing update operations.
     *
     * @param updateOperation updateOperation Default value is null
     */
    void setUpdateOperation(String updateOperation);

    /**
     * Operation ID this component should use when performing update operations.
     *
     * @return String
     */
    String getUpdateOperation();

    /**
     * Operation ID this component should use when performing add operations.
     *
     * @param addOperation addOperation Default value is null
     */
    void setAddOperation(String addOperation);

    /**
     * Operation ID this component should use when performing add operations.
     *
     * @return String
     */
    String getAddOperation();

    /**
     * Operation ID this component should use when performing remove operations.
     *
     * @param removeOperation removeOperation Default value is null
     */
    void setRemoveOperation(String removeOperation);

    /**
     * Operation ID this component should use when performing remove operations.
     *
     * @return String
     */
    String getRemoveOperation();

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is &#010 limited and sorted as per the list.&#010 <P>&#010 If exportFields is not provided, the exported output includes all visible fields &#010 from this component, sorted as they appear.
     *
     * @param exportFields exportFields Default value is null
     */
    void setExportFields(String[] exportFields);

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is &#010 limited and sorted as per the list.&#010 <P>&#010 If exportFields is not provided, the exported output includes all visible fields &#010 from this component, sorted as they appear.
     *
     *
     * @return the list of field-names to export.
     *
     */
    String[] getExportFields();

    /**
     * Setting exportAll to true prevents the component from passing it's list of fields to the &#010 export call.  The result is the export of all visible fields from {@link com.smartgwt.client.data.DataSource#getFields fields}.&#010 <P>&#010 If exportAll is false, an export operation will first consider &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getExportFields exportFields}, if it's set, and fall back on all visible fields from&#010 {@link com.smartgwt.client.data.DataSource#getFields fields} otherwise.
     *
     * @param exportAll exportAll Default value is false
     */
    void setExportAll(Boolean exportAll);

    /**
     * Setting exportAll to true prevents the component from passing it's list of fields to the &#010 export call.  The result is the export of all visible fields from {@link com.smartgwt.client.data.DataSource#getFields fields}.&#010 <P>&#010 If exportAll is false, an export operation will first consider &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getExportFields exportFields}, if it's set, and fall back on all visible fields from&#010 {@link com.smartgwt.client.data.DataSource#getFields fields} otherwise.
     *
     * @return Boolean
     */
    Boolean getExportAll();

    /**
     * If set, detect and prevent duplicate records from being transferred to this component, either via&#010 drag and drop or via {@link com.smartgwt.client.widgets.DataBoundComponent#transferSelectedData}.  When a duplicate transfer is detected,&#010 a dialog will appear showing the {@link com.smartgwt.client.widgets.DataBoundComponent#getDuplicateDragMessage duplicateDragMessage}.&#010 <P>&#010 If the component either does not have a {@link com.smartgwt.client.data.DataSource} or has a DataSource with no&#010 {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} declared, duplicate checking is off by&#010 default.  If duplicate checking is enabled, it looks for an existing record in the dataset&#010 that has <b>all</b> of the properties of the dragged record, and considers that a duplicate.&#010 <P>&#010 For {@link com.smartgwt.client.types.DragDataAction}:"copy" where the target DataSource is related to the source&#010 DataSource by foreignKey, a duplicate means that the target list, as filtered by the current&#010 criteria, already has a record whose value for the foreignKey field matches the&#010 primaryKey of the record being transferred.&#010 <P>&#010 For example, consider dragging "employees" to "teams", where "teams" has a field&#010 "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target&#010 grid has search criteria causing it to show all the members of one team.  A duplicate -&#010 adding an employee to the same team twice - is when the target grid's dataset contains an&#010 record with "employeeId" matching the "id" field of the dropped employee.
     *
     * @param preventDuplicates preventDuplicates Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException;

    /**
     * If set, detect and prevent duplicate records from being transferred to this component, either via&#010 drag and drop or via {@link com.smartgwt.client.widgets.DataBoundComponent#transferSelectedData}.  When a duplicate transfer is detected,&#010 a dialog will appear showing the {@link com.smartgwt.client.widgets.DataBoundComponent#getDuplicateDragMessage duplicateDragMessage}.&#010 <P>&#010 If the component either does not have a {@link com.smartgwt.client.data.DataSource} or has a DataSource with no&#010 {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} declared, duplicate checking is off by&#010 default.  If duplicate checking is enabled, it looks for an existing record in the dataset&#010 that has <b>all</b> of the properties of the dragged record, and considers that a duplicate.&#010 <P>&#010 For {@link com.smartgwt.client.types.DragDataAction}:"copy" where the target DataSource is related to the source&#010 DataSource by foreignKey, a duplicate means that the target list, as filtered by the current&#010 criteria, already has a record whose value for the foreignKey field matches the&#010 primaryKey of the record being transferred.&#010 <P>&#010 For example, consider dragging "employees" to "teams", where "teams" has a field&#010 "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target&#010 grid has search criteria causing it to show all the members of one team.  A duplicate -&#010 adding an employee to the same team twice - is when the target grid's dataset contains an&#010 record with "employeeId" matching the "id" field of the dropped employee.
     *
     * @return Boolean
     */
    Boolean getPreventDuplicates();

    /**
     * Message to show when a user attempts to transfer duplicate records into this component, and&#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getPreventDuplicates preventDuplicates} is enabled.
     *
     * @param duplicateDragMessage duplicateDragMessage Default value is "Duplicates not allowed"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException;

    /**
     * Message to show when a user attempts to transfer duplicate records into this component, and&#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getPreventDuplicates preventDuplicates} is enabled.
     *
     * @return String
     */
    String getDuplicateDragMessage();

    /**
     * Indicates whether to add "drop values" to items dropped on this component, if both &#010          the source and target widgets are databound, either to the same DataSource or &#010          to different DataSources that are related via a foreign key.  "Drop values" are &#010          properties of the dropped item that you wish to change (and persist) as a &#010          result of the item being dropped on this grid.&#010          <P>&#010          If this value is true and this component is databound, {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} will &#010          be called for every databound item dropped on this grid, and an update performed&#010          on the item
     *
     * @param addDropValues addDropValues Default value is true
     */
    void setAddDropValues(Boolean addDropValues);

    /**
     * Indicates whether to add "drop values" to items dropped on this component, if both &#010          the source and target widgets are databound, either to the same DataSource or &#010          to different DataSources that are related via a foreign key.  "Drop values" are &#010          properties of the dropped item that you wish to change (and persist) as a &#010          result of the item being dropped on this grid.&#010          <P>&#010          If this value is true and this component is databound, {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} will &#010          be called for every databound item dropped on this grid, and an update performed&#010          on the item
     *
     * @return Boolean
     */
    Boolean getAddDropValues();

    /**
     * When an item is dropped on this component, and {@link com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true and both &#010          the source and target widgets are databound, either to the same DataSource or &#010          to different DataSources that are related via a foreign key, this object &#010          provides the "drop values" that SmartGWT will apply to the dropped object &#010          before updating it.&#010          <P>&#010          If this property is not defined, SmartGWT defaults to returning the selection&#010          criteria currently in place for this component.  Thus, any databound items (for example, &#010          rows from other grids bound to the same DataSource) dropped on the grid will,&#010          by default, be subjected to an update that makes them conform to the grid's &#010          current filter criteria.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dropValues dropValues Default value is null
     */
    void setDropValues(Map dropValues);

    /**
     * When an item is dropped on this component, and {@link com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true and both &#010          the source and target widgets are databound, either to the same DataSource or &#010          to different DataSources that are related via a foreign key, this object &#010          provides the "drop values" that SmartGWT will apply to the dropped object &#010          before updating it.&#010          <P>&#010          If this property is not defined, SmartGWT defaults to returning the selection&#010          criteria currently in place for this component.  Thus, any databound items (for example, &#010          rows from other grids bound to the same DataSource) dropped on the grid will,&#010          by default, be subjected to an update that makes them conform to the grid's &#010          current filter criteria.
     *
     *
     * @return Returns the "drop values" to apply to a record dropped on this component prior to update.  Only&#010 applicable to databound components - see {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues dropValues} for more details.  If multiple records &#010 are being dropped, this method is called for each of them in turn.&#010 <P>&#010 This method returns the following:&#010 <UL>&#010 <LI>Nothing, if {@link com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is false</LI>&#010 <LI>dropValues, if that property is set.  If the component's criteria object is applicable (as explained&#010 in the next item), it is merged into dropValues, with properties in dropValues taking precedence.</LI>&#010 <LI>The component's criteria object, if the most recent textMatchStyle for the component was "exact" &#010     and it is simple criteria (ie, not an AdvancedCriteria object)</LI>&#010 <LI>Otherwise nothing</LI>&#010 </UL>&#010 <P>&#010 You can override this method if you need more complex setting of drop values than can be &#010 provided by simply supplying a dropValues object.&#010 &#010
     *
     */
    Map getDropValues();

    /**
     * The <code>useFlatFields</code> flag causes all simple type fields anywhere in a nested&#010 set of DataSources to be exposed as a flat list for form binding.  &#010 <P>&#010 <code>useFlatFields</code> is typically used with imported metadata, such as &#010 {@link com.smartgwt.client.data.XMLTools#loadXMLSchema} from a &#010 {@link com.smartgwt.client.data.XMLTools#loadWSDL}, as a means of eliminating levels of XML&#010 nesting that aren't meaningful in a user interface, without the cumbersome and fragile&#010 process of mapping form fields to XML structures.&#010 <P>&#010 For example, having called {@link com.smartgwt.client.data.WebService#getInputDS} to retrieve the input message&#010 schema for a web service operation whose input message looks like this:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 Setting <code>useFlatFields</code> on a {@link com.smartgwt.client.widgets.form.DynamicForm} that is bound to this input&#010 message schema would result in 5 {@link com.smartgwt.client.widgets.form.fields.FormItem} reflecting the 5 simple type&#010 fields in the message.&#010 <P>&#010 For this form, the result of {@link com.smartgwt.client.widgets.form.DynamicForm#getValues} might look&#010 like:&#010 <P>&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 When contacting a {@link com.smartgwt.client.data.WebService}, these values can be automatically&#010 mapped to the structure of the input message for a web service operation by setting&#010 {@link com.smartgwt.client..WSRequest#getUseFlatFields useFlatFields} (for use with {@link com.smartgwt.client.data.WebService#callOperation}) or by setting&#010 {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} (for use with a {@link com.smartgwt.client.data.DataSource} that is&#010 {@link com.smartgwt.client.docs.WsdlBinding 'bound to a WSDL web service'} via&#010 {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}).  &#010 <P>&#010 Using these two facilities in conjunction (component.useFlatFields and&#010 request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user&#010 presentation and when providing the data for XML messages.&#010 <P>&#010 You can also set {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} to automatically enable &#010 "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a&#010 particular operationType.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with structures&#010 where multiple simple type fields exist with the same name, however if used with such a&#010 structure, the first field to use a given name wins.  "first" means the first field&#010 encountered in a depth first search.  "wins" means only the first field will be present as a&#010 field when data binding.
     *
     * @param useFlatFields useFlatFields Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException;

    /**
     * The <code>useFlatFields</code> flag causes all simple type fields anywhere in a nested&#010 set of DataSources to be exposed as a flat list for form binding.  &#010 <P>&#010 <code>useFlatFields</code> is typically used with imported metadata, such as &#010 {@link com.smartgwt.client.data.XMLTools#loadXMLSchema} from a &#010 {@link com.smartgwt.client.data.XMLTools#loadWSDL}, as a means of eliminating levels of XML&#010 nesting that aren't meaningful in a user interface, without the cumbersome and fragile&#010 process of mapping form fields to XML structures.&#010 <P>&#010 For example, having called {@link com.smartgwt.client.data.WebService#getInputDS} to retrieve the input message&#010 schema for a web service operation whose input message looks like this:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 Setting <code>useFlatFields</code> on a {@link com.smartgwt.client.widgets.form.DynamicForm} that is bound to this input&#010 message schema would result in 5 {@link com.smartgwt.client.widgets.form.fields.FormItem} reflecting the 5 simple type&#010 fields in the message.&#010 <P>&#010 For this form, the result of {@link com.smartgwt.client.widgets.form.DynamicForm#getValues} might look&#010 like:&#010 <P>&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 When contacting a {@link com.smartgwt.client.data.WebService}, these values can be automatically&#010 mapped to the structure of the input message for a web service operation by setting&#010 {@link com.smartgwt.client..WSRequest#getUseFlatFields useFlatFields} (for use with {@link com.smartgwt.client.data.WebService#callOperation}) or by setting&#010 {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} (for use with a {@link com.smartgwt.client.data.DataSource} that is&#010 {@link com.smartgwt.client.docs.WsdlBinding 'bound to a WSDL web service'} via&#010 {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}).  &#010 <P>&#010 Using these two facilities in conjunction (component.useFlatFields and&#010 request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user&#010 presentation and when providing the data for XML messages.&#010 <P>&#010 You can also set {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} to automatically enable &#010 "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a&#010 particular operationType.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with structures&#010 where multiple simple type fields exist with the same name, however if used with such a&#010 structure, the first field to use a given name wins.  "first" means the first field&#010 encountered in a depth first search.  "wins" means only the first field will be present as a&#010 field when data binding.
     *
     * @return Boolean
     */
    Boolean getUseFlatFields();

    /**
     * Marker that can be set on a record to flag that record as hilited.  Should be set to a value&#010 that matches {@link com.smartgwt.client..Hilite#getId id} for a hilite defined on this component.
     *
     * @param hiliteProperty hiliteProperty Default value is "_hilite"
     */
    void setHiliteProperty(String hiliteProperty);

    /**
     * Marker that can be set on a record to flag that record as hilited.  Should be set to a value&#010 that matches {@link com.smartgwt.client..Hilite#getId id} for a hilite defined on this component.
     *
     * @return String
     */
    String getHiliteProperty();

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See&#010          DragDataAction type for details.
     *
     * @param dragDataAction dragDataAction Default value is Canvas.MOVE
     */
    void setDragDataAction(DragDataAction dragDataAction);

    /**
     * Indicates what to do with data dragged into another DataBoundComponent. See&#010          DragDataAction type for details.
     *
     * @return DragDataAction
     */
    DragDataAction getDragDataAction();

    /**
     * CSS Style to apply to the drag tracker when dragging occurs on this component.
     *
     * @param dragTrackerStyle dragTrackerStyle Default value is "gridDragTracker"
     */
    void setDragTrackerStyle(String dragTrackerStyle);

    /**
     * CSS Style to apply to the drag tracker when dragging occurs on this component.
     *
     * @return String
     */
    String getDragTrackerStyle();

    /**
     * Adds an item to the header context menu allowing users to launch a dialog to define a new&#010 field based on values present in other fields, using the {@link com.smartgwt.client..FormulaBuilder}.&#010 <P>&#010 User-added formula fields can be persisted via {@link com.smartgwt.client.widgets.grid.ListGrid#getFieldState} and &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState}.
     *
     * @param canAddFormulaFields canAddFormulaFields Default value is false
     */
    void setCanAddFormulaFields(Boolean canAddFormulaFields);

    /**
     * Convenience method to display a {@link com.smartgwt.client..SummaryBuilder} to create a new Summary Field.  This &#010 is equivalent to calling {@link DataBoundComponentGen#editSummaryField} with &#010 no paramater.&#010&#010
     */
    void addSummaryField();

    /**
     * Convenience method to display a {@link com.smartgwt.client..FormulaBuilder} to create a new Formula Field.  This &#010 is equivalent to calling {@link DataBoundComponentGen#editFormulaField} with &#010 no paramater.&#010&#010
     */
    void addFormulaField();

    /**
     * Adds an item to the header context menu allowing users to launch a dialog to define a new&#010 field based on values present in other fields, using the {@link com.smartgwt.client..FormulaBuilder}.&#010 <P>&#010 User-added formula fields can be persisted via {@link com.smartgwt.client.widgets.grid.ListGrid#getFieldState} and &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState}.
     *
     * @return Boolean
     */
    Boolean getCanAddFormulaFields();

    /**
     * Text for a menu item allowing users to add a formula field
     *
     * @param addFormulaFieldText addFormulaFieldText Default value is "Add formula column..."
     */
    void setAddFormulaFieldText(String addFormulaFieldText);

    /**
     * Text for a menu item allowing users to add a formula field
     *
     * @return String
     */
    String getAddFormulaFieldText();

    /**
     * Text for a menu item allowing users to edit a formula field
     *
     * @param editFormulaFieldText editFormulaFieldText Default value is "Edit formula..."
     */
    void setEditFormulaFieldText(String editFormulaFieldText);

    /**
     * Text for a menu item allowing users to edit a formula field
     *
     * @return String
     */
    String getEditFormulaFieldText();

    /**
     * Adds an item to the header context menu allowing users to launch a dialog to define a new&#010 text field that can contain both user-defined text and the formatted values present in other &#010 fields, using the {@link com.smartgwt.client..SummaryBuilder}.&#010 <P>&#010 User-added summary fields can be persisted via {@link com.smartgwt.client.widgets.grid.ListGrid#getFieldState} and &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState}.
     *
     * @param canAddSummaryFields canAddSummaryFields Default value is false
     */
    void setCanAddSummaryFields(Boolean canAddSummaryFields);

    /**
     * Adds an item to the header context menu allowing users to launch a dialog to define a new&#010 text field that can contain both user-defined text and the formatted values present in other &#010 fields, using the {@link com.smartgwt.client..SummaryBuilder}.&#010 <P>&#010 User-added summary fields can be persisted via {@link com.smartgwt.client.widgets.grid.ListGrid#getFieldState} and &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState}.
     *
     * @return Boolean
     */
    Boolean getCanAddSummaryFields();

    /**
     * Text for a menu item allowing users to add a formula field
     *
     * @param addSummaryFieldText addSummaryFieldText Default value is "Add summary column..."
     */
    void setAddSummaryFieldText(String addSummaryFieldText);

    /**
     * Text for a menu item allowing users to add a formula field
     *
     * @return String
     */
    String getAddSummaryFieldText();

    /**
     * Text for a menu item allowing users to edit the formatter for a field
     *
     * @param editSummaryFieldText editSummaryFieldText Default value is "Edit summary format..."
     */
    void setEditSummaryFieldText(String editSummaryFieldText);

    /**
     * Text for a menu item allowing users to edit the formatter for a field
     *
     * @return String
     */
    String getEditSummaryFieldText();

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    void selectRecord(Record record);

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record record (or row number) to select
     */
    void selectRecord(int record);

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     */
    void selectRecord(int record, boolean newState);

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     */
    void selectRecord(Record record, boolean newState);

    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    void selectRecords(int[] records);

    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state
     */
    void selectRecords(int[] records, boolean newState);

    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records records (or row numbers) to select
     */
    void selectRecords(Record[] records);

    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state (if null, defaults to true)
     */
    void selectRecords(Record[] records, boolean newState);

    /**
     * Deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    void deselectRecord(Record record);

    /**
     * Deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record record (or row number) to deselect
     */
    void deselectRecord(int record);

    /**
     * Deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    void deselectRecords(int[] records);

    /**
     * Deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    void deselectRecords(Record[] records);

    /**
     * Select all records&#010&#010
     */
    void selectAllRecords();

    /**
     * &#010 Deselect all records&#010&#010
     */
    void deselectAllRecords();

    /**
     * Whether at least one item is selected&#010
     *
     * @return true == at least one item is selected        false == nothing at all is selected
     */
    Boolean anySelected();

    /**
     * Enable / disable a {@link com.smartgwt.client.widgets.DataBoundComponent#getHilites hilites}&#010&#010
     *
     * @param hiliteID ID of hilite to enable
     */
    void enableHilite(String hiliteID);

    /**
     * Enable / disable a {@link com.smartgwt.client.widgets.DataBoundComponent#getHilites hilites}&#010&#010
     *
     * @param hiliteID ID of hilite to enable
     * @param enable   new enabled state to apply - if null, defaults to true
     */
    void enableHilite(String hiliteID, boolean enable);

    /**
     * Disable a hilite&#010&#010
     *
     * @param hiliteID ID of hilite to disable
     */
    void disableHilite(String hiliteID);

    /**
     * Enable all hilites.&#010&#010
     */
    void enableHiliting();

    /**
     * Enable all hilites.&#010&#010
     *
     * @param enable new enabled state to apply - if null, defaults to true
     */
    void enableHiliting(boolean enable);

    /**
     * Disable all hilites.&#010&#010
     */
    void disableHiliting();

    /**
     * &#010 During a drag-and-drop interaction, this method returns the set of records being dragged out&#010 of the component.  In the default implementation, this is the list of currently selected&#010 records.<p>&#010 &#010 This method is generally called by {@link com.smartgwt.client.widgets.DataBoundComponent#transferDragData} and is consulted by&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop}.&#010 &#010
     *
     * @return Array of {@link com.smartgwt.client.data.Record}s that are currently selected.
     */
    Record[] getDragData();

    /**
     * Simulates a drag / drop type transfer of the selected records in some other component to this&#010 component, without requiring any user interaction.  This method acts on the dropped records &#010 exactly as if they had been dropped in an actual drag / drop interaction, including any &#010 special databound behavior invoked by calling&#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} for each dropped record.&#010 <P>&#010 To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first.&#010 <P>&#010 See the {@link com.smartgwt.client.docs.Dragging} documentation for an overview of list grid drag/drop data&#010 transfer.&#010 &#010
     *
     * @param source source component from which the records will be tranferred
     */
    void transferSelectedData(DataBoundComponent source);

    /**
     * Simulates a drag / drop type transfer of the selected records in some other component to this&#010 component, without requiring any user interaction.  This method acts on the dropped records &#010 exactly as if they had been dropped in an actual drag / drop interaction, including any &#010 special databound behavior invoked by calling&#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getDropValues} for each dropped record.&#010 <P>&#010 To transfer <b>all</b> data in, for example, a {@link com.smartgwt.client.widgets.grid.ListGrid}, call grid.selection.selectAll() first.&#010 <P>&#010 See the {@link com.smartgwt.client.docs.Dragging} documentation for an overview of list grid drag/drop data&#010 transfer.&#010 &#010
     *
     * @param source source component from which the records will be tranferred
     * @param index  target index (drop position) of the rows within this grid.
     */
    void transferSelectedData(DataBoundComponent source, int index);

    /**
     * Get the index of the provided record.&#010 <P>&#010 Override in subclasses to provide more specific behaviour, for instance, when data holds a&#010 large number of records&#010&#010
     *
     * @param record the record whose index is to be retrieved
     * @return indexindex of the record, or -1 if not found
     */
    int getRecordIndex(Record record);

    /**
     * Get the value of the titleField for the passed record&#010 <P>&#010 Override in subclasses &#010&#010
     *
     * @param record the record whose index is to be retrieved
     * @return valuethe value of the titleField for the passed record
     */
    String getTitleFieldValue(Record record);

    /**
     * Method to return the fieldName which represents the "title" for records in this&#010 Component.<br>&#010 If this.titleField is explicitly specified it will always be used.&#010 Otherwise, default implementation will check {@link com.smartgwt.client.data.DataSource#getTitleField titleField} for databound&#010 compounds.<br>&#010 For non databound components returns the first defined field name of <code>"title"</code>, &#010 <code>"name"</code>, or <code>"id"</code>. If we dont find any field-names that match these&#010 titles, the first field in the component will be used instead.&#010
     *
     * @return fieldName for title field for this component.
     */
    String getTitleField();

    void setTitleField(String titleField);

    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 {@link com.smartgwt.client.data.DSRequest}.&#010 <P>&#010 Can be specified as either a DataSource instance or the String ID of a DataSource.
     * Bind to a new DataSource.&#010 <P>&#010 Like passing the "dataSource" property on creation, binding to a DataSource means that the&#010 component will use the DataSource to provide default data for its fields.&#010 <P>&#010 When binding to a new DataSource, if the component has any existing "fields" or has a dataset,&#010 these will be discarded by default, since it is assumed the new DataSource may represent a&#010 completely unrelated set of objects.  If the old "fields" are still relevant, pass them to&#010 setDataSource().&#010 &#010
     *
     * @param dataSource DataSource to bind to. Default value is null
     */
    void setDataSource(DataSource dataSource);

    /**
     * The DataSource that this component should bind to for default fields and for performing&#010 {@link com.smartgwt.client.data.DSRequest}.&#010 <P>&#010 Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    DataSource getDataSource();

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link #getFetchOperation fetchOperation} and {@link
     * #getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     */
    void fetchData();

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link #getFetchOperation fetchOperation} and {@link
     * #getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    void fetchData(Criteria criteria);

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link #getFetchOperation fetchOperation} and {@link
     * #getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    void fetchData(Criteria criteria, DSCallback callback);

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link #getFetchOperation fetchOperation} and {@link
     * #getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties);

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    void filterData();

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required; see                                          {@link
     *                 #fetchData} for details
     */
    void filterData(Criteria criteria);

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link #fetchData} for details
     */
    void filterData(Criteria criteria, DSCallback callback);

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link #fetchData} for details
     * @param requestProperties for databound components only - optional                            additional
     *                          properties to set on the DSRequest that will be issued
     */
    void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties);

    /**
     * If true, when this component is first drawn, automatically call {@link #fetchData()} or {@link #filterData()} depending on
     * {@link #getAutoFetchAsFilter()} . Criteria for this fetch may be picked up from {@link #getInitialCriteria() initialCriteria}.
     *
     * @param autoFetchData autoFetchData 
     */
    void setAutoFetchData(Boolean autoFetchData);

    /**
     * If true, when this component is first drawn, automatically call {@link #fetchData()} or {@link #filterData()} depending on
     * {@link #getAutoFetchAsFilter()} . Criteria for this fetch may be picked up from {@link #getInitialCriteria() initialCriteria}.
     *
     * @return auto fetch data
     */
    Boolean getAutoFetchData();

    /**
     * If {@link #setAutoFetchData(Boolean)} is true, this attribute determines whether the initial fetch operation should be
     * performed via {@link #fetchData()} or {@link #filterData()}
     *
     * @param autoFetchAsFilter autoFetchAsFilter
     */
    void setAutoFetchAsFilter(Boolean autoFetchAsFilter);

    /**
     * If {@link #setAutoFetchData(Boolean)} is true, this attribute determines whether the initial fetch operation should be
     * performed via {@link #fetchData()} or {@link #filterData()}
     *
     * @return auto fetch as filter
     */
    Boolean getAutoFetchAsFilter();

    /**
     * Criteria to use when {@link #setAutoFetchData(Boolean)} is used.
     *
     * @param initialCriteria the initial criteria
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException;

    /**
     * Criteria to use when {@link #setAutoFetchData(Boolean)} is used.
     *
     * @return the criteria
     */
    Criteria getInitialCriteria();

    /**
     * Invalidate the current data cache for this databound component via a call to&#010 <code>this.data.invalidateCache()</code>. If necessary, this will cause a new fetch to &#010 be performed with the current set of criteria for this component.&#010 <P>&#010 Has no effect if this component is not showing a set of filtered data.&#010 &#010
     */
    void invalidateCache();

    /**
     * Return the underlying data of this DataBoundComponent as a {@link com.smartgwt.client.data.ResultSet}.
     * <p>
     * Note that this method should only be called after initial data has been fetched by this DataBoundComponent.
     *
     * @return ResultSet, or null if the underlying data is not a ResultSet
     * @see #fetchData()
     */
    ResultSet getResultSet();

    /**
     * Return the underlying data of this DataBoundComponent as a {@link com.smartgwt.client.data.RecordList}.
     * <p>
     * Depending on the component configuration, the actual JavaScript instance of the returned
     * RecordList may be one of several types: <ul>
     * <li>If the component is not bound to a {@link com.smartgwt.client.data.DataSource}, 
     *     the instance is generally an Array of {@link com.smartgwt.client.data.Record}.</li>
     * <li>If the component is bound to a DataSource, the instance is a 
     *     {@link com.smartgwt.client.data.ResultSet}.</li>
     * <li>If the component is a grouped ListGrid, the instance is a 
     *     {@link com.smartgwt.client.widgets.tree.Tree}.
     * To access the ungrouped record list regardless of grouping status, use
     * <pre>isGrouped() ? getOriginalRecordList() : getRecordList()</pre></li>
     * <li>If the component is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, 
     *     the instance is a ResultTree.</li>
     * </ul>The underlying type determines the structure of the returned data.
     * An Array or ResultSet represents a list of records, but a Tree or ResultTree represents
     * a list of open rows in the tree, including groups or other nodes which contain no records.
     *
     * @return the RecordList
     */
    RecordList getRecordList();

}
