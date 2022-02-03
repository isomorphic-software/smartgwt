
package com.smartgwt.client.docs;

/**
 * <h3>Tree DataBinding</h3>
 * The Smart GWT {@link com.smartgwt.client.widgets.tree.TreeGrid} component is a visual
 * representation of a tree and requires
 * a {@link com.smartgwt.client.widgets.tree.Tree} or {@link
 * com.smartgwt.client.widgets.tree.ResultTree} datatype passed via the {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getData TreeGrid.data} attribute to
 * initialize the tree view.  The {@link com.smartgwt.client.widgets.tree.Tree} datatype is used
 * when you want to provide all of
 * the tree nodes in one shot at initialization time.  The {@link
 * com.smartgwt.client.widgets.tree.ResultTree} datatype is used
 *  when you want portions of the tree to be loaded on demand from the server.
 *  <p>
 *  <h3>Providing all data to the Tree at creation</h3>
 *  <p>
 *  The simplest mechanism by which to initialize a Tree is to simply provide all the data
 *  up-front when the Tree itself is created.  Depending on the format of your tree data, this
 * can be done by setting {@link com.smartgwt.client.widgets.tree.Tree#getRoot Tree.root} or
 * {@link com.smartgwt.client.widgets.tree.Tree#getData Tree.data}.  This functionality is
 * provided
 *  by the {@link com.smartgwt.client.widgets.tree.Tree} class.
 *  <p>
 *  For examples of this type of databinding, see the following SDK examples:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_children_arrays"
 * target="examples">TreeGrid Initialization Example</a></li>
 *  
 *  </ul>
 *  <p>
 *  <h3>Loading Tree nodes on demand</h3>
 *  <p>
 *  In this mode, tree nodes are loaded on-demand the first time a user expands a folder.  This
 *  approach is necessary for large trees.  This functionality is provided by the
 * {@link com.smartgwt.client.widgets.tree.ResultTree} class, which uses a {@link
 * com.smartgwt.client.data.DataSource} to load data from the server.  Each
 *  DataSource Record becomes a {@link com.smartgwt.client.widgets.tree.TreeNode}.
 *  <p>
 *  When the user expands a folder whose children have not yet been loaded
 *  from the server (or you programmatically call openFolder() on such a node), the client
 * automatically sends a {@link com.smartgwt.client.data.DSRequest} to the server to ask for all
 * immediate children of
 *  that node.  
 *  <P>
 * If you have a dataset that is {@link com.smartgwt.client.types.TreeModelType "parent-linked"},
 * that is, every node has
 * a unique ID (the {@link com.smartgwt.client.widgets.tree.Tree#getIdField Tree.idField}) and
 * also has a property with the unique ID of it's
 * parent node (the {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField
 * Tree.parentIdField}) the tree can load child nodes by simply sending
 * a DSRequest with appropriate {@link com.smartgwt.client.data.Criteria}.  Given a parent node
 * with ID "225" in a tree
 * where the {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField Tree.parentIdField} is
 * called "parentId", the criteria would be:
 *  <pre>
 *     { parentId : 225 }
 *  </pre>
 *  The client is asking the server: "give me all nodes whose parentId is 225", which are the
 *  children of node 225.  
 *  <P>
 * If you have a DataSource that supports simple {@link com.smartgwt.client.data.Criteria} like
 * the above, and your
 *  records have nodes with ids and parentIds, this strategy can be used by just declaring the
 * tree relationship in your DataSource: the first {@link
 * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} field
 *  referring to another field in that same DataSource will be taken as the
 * {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField Tree.parentIdField}, and the
 * field to which it refers, the {@link com.smartgwt.client.widgets.tree.Tree#getIdField
 * Tree.idField}.  You
 * can use the {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey
 * DataSourceField.primaryKey} field as your {@link
 * com.smartgwt.client.widgets.tree.Tree#getIdField Tree.idField}, but it's
 *  only required that it hold unique values.  Note, this only works for DataSources with  a
 *  single primaryKey field; composite keys are not supported for this kind of tree databinding.
 * See {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey DataSourceField.primaryKey}
 * for more details.
 *  <P>
 *  If you have a tree where there is no convenient unique ID, for example, you have mixed types
 *  of nodes (for example, departments and employees), use one of the following approaches:
 *  <ol>
 *  <li> generate a synthetic node ID and return it with every tree node.
 *  <P>
 *  Typically two or more properties can be combined into a String that serves as a unique ID.
 *  For example, if you are loading a mixed tree of "Departments" and "Users", each of which
 *  have unique numeric IDs, you could generate synthetic node IDs like "department:353" and
 *  "user:311".  Your server-side code will then receive these synthetic node IDs when the tree
 *  loads children, and you can parse the IDs, look up the appropriate object and return its
 *  child nodes.
 *  <P>
 *  In the case of filesystems or XML documents, you can use the full path to the file or XML
 *  element as the unique ID.
 *  <P>
 * <li> have all properties of the parentNode {@link
 * com.smartgwt.client.data.DataSource#getSendParentNode sent to the server}
 *  <P>
 *  If having all the properties of the parentNode would allow you to look up children, this
 *  approach may be more convenient than having to generate synthetic node IDs and parse them
 *  when looking up children.
 *  <P>
 *  For example, with a mixed-type tree, your server-side code may be able to quickly identify
 *  the type of the parent node be looking for specific properties, and then call methods to
 *  look up children for that type of node.
 *  <P>
 *  In this case there is no need to declare an idField or parentIdField.
 *  </ol>
 *  <P>
 * {@link com.smartgwt.client.widgets.tree.ResultTree}s are created for you by the {@link
 * com.smartgwt.client.widgets.tree.TreeGrid} when you set
 * {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataSource TreeGrid.dataSource}, but you
 * can pass an initial dataset to a databound TreeGrid by
 *  setting {@link com.smartgwt.client.widgets.tree.TreeGrid#getInitialData TreeGrid.initialData}.
 *  <P>
 * If you do not provide {@link com.smartgwt.client.widgets.tree.TreeGrid#getInitialData
 * TreeGrid.initialData}, the first DSRequest you receive will be a
 *  request for the nodes under root.  The id of the root node of the tree is the value of the
 * <code>rootValue</code> attribute on the {@link
 * com.smartgwt.client.widgets.tree.Tree#getParentIdField Tree.parentIdField} of the Tree
 * DataSource. 
 *  <p>
 *  For examples of this type of databinding, see the following SDK examples:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwt/showcase/#tree_databinding_init_ondemand"
 * target="examples">TreeGrid DataBinding Example</a></li>
 *  
 *  </ul>
 *  <P>
 *  <h4>Folders and load on demand</h4>
 *  <P>
 *  When using load on demand, the Tree cannot simply check whether a node has children to
 *  determine whether it's a folder, and will assume all loaded nodes are folders.  To avoid
 *  this, you can add a boolean field to your DataSource called "isFolder" that indicates
 *  whether a node is a folder or not.  If you already have a boolean field that indicates
 * whether a node is a folder, you can instead set {@link
 * com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty Tree.isFolderProperty} to the name of
 * that field via {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataProperties
 * TreeGrid.dataProperties}.
 *  <P>
 *  <h4>Multi-Level load on demand</h4>
 *  <P>
 *  The ResultTree's DSRequests ask for the immediate children of a node only (by specifying
 *  <code>parentId</code> in the criteria). Any nodes returned whose <code>parentId</code> field
 * value is unset or matches this criterion will be added to the tree as immediate children of the
 *  node. However you are also free to return multiple levels of children.  This can be done by
 *  simply returning a flat list of descendents with valid id's and parentId's, exactly as though 
 * you were initializing a multi-level tree via {@link
 * com.smartgwt.client.widgets.tree.Tree#getData Tree.data}.  
 *  <P>
 *  Note that when receiving multiple levels of children, the ResultTree's assumption is that
 *  if any children are loaded for a parent, then that parent is considered fully loaded.
 *  <P>
 *  When loading children for a given parent node, the ResultTree calls
 * {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} on its DataSource.
 *  For custom code that may need to reference
 *  the parentNode or tree in some way, the parent node whose children are being loaded is
 *  available on the dsRequest instance in the DataSource flow as dsRequest.parentNode, where it
 * can be inspected during {@link com.smartgwt.client.data.DataSource#transformRequest
 * DataSource.transformRequest()}.
 *  <P>
 *  For an example of this feature, see the following SDK example:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#tree_multilevel_load_on_demand"
 * target="examples">Multi-Level Load on Demand Example</a></li>
 *  </ul>
 *  <P>
 *  <h3>Paging large sets of children</h3>
 *  <p>
 *  If some nodes in your tree have a very large number of immediate children, you can enable
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode:"paged"} to load
 * children in batches.  This means that
 *  whenever the children of a folder are loaded, the <code>ResultTree</code> will set
 * {@link com.smartgwt.client.data.DSRequest#getStartRow DSRequest.startRow} and {@link
 * com.smartgwt.client.data.DSRequest#getEndRow endRow} when requesting children from
 *  the DataSource.  This includes the initial fetch of top-level nodes, which are children of
 *  the {@link com.smartgwt.client.widgets.tree.Tree#getShowRoot implicit root node}.
 *  <p>
 *  As with all paged DSRequests, the server is free to ignore startRow/endRow and
 *  simply return all children of the node.  This allows the server to make on-the-fly
 *  folder-by-folder choices as to whether to use paging or just return all children.  However,
 *  whenever the server returns only some children, the server must provide an accurate value for
 * {@link com.smartgwt.client.data.DSResponse#getTotalRows DSResponse.totalRows}.  Note that
 * <code>startRow</code>, <code>endRow</code>, and 
 *  <code>totalRows</code> all refer to the array of siblings that are the direct children of a
 *  particular parent node (specified by the criteria or, implicitly, the root node).
 *  In particular, <code>totalRows</code> is a count of exactly how many nodes match the
 *  criteria; this is the same as how many total sibling children are available at that level.
 *  <p>
 *  If the server does return a partial list of children, the <code>ResultTree</code>. will
 * create a {@link com.smartgwt.client.data.ResultSet} to represent it rather than an array, and
 * automatically request
 *  further children as they are accessed; typically this happens because the user is scrolling
 * around in a {@link com.smartgwt.client.widgets.tree.TreeGrid} which is viewing the
 * <code>ResultTree</code>.  The value of 
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getResultSize ResultTree.resultSize} (which
 * may be overridden via {@link com.smartgwt.client.widgets.grid.ListGrid#getDataPageSize
 * dataPageSize}) will
 *  be passed along to any created <code>ResultSet</code> as well as used directly for the
 *  initial server request for a node's children.
 *  <p>
 *  In this mode, the server may return multiple levels of the tree as described above
 *  ("Multi-Level load on demand"), however, by default the server is not allowed to return
 *  folders that are open, as this creates a potential performance issue: consider the case of a
 *  user scrolling rapidly into an unloaded area of the tree, skipping past many nodes that have
 *  not been loaded.  If the skipped nodes might have been open parents, then the only way to
 *  know what nodes should be visible at the new scroll position is to load all skipped nodes
 *  and discover how many visible children they had.
 *  <p>
 *  If this performance consequence is acceptable, the restriction against returning open
 *  folders from the server may be lifted on a tree-wide basis by setting the
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getCanReturnOpenFolders
 * canReturnOpenFolders} property to <code>true</code>
 *  and/or on a folder-by-folder basis by setting the property named by the
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getCanReturnOpenSubfoldersProperty
 * canReturnOpenSubfoldersProperty} to
 *  <code>true</code>.  In this case, it is recommended to also set
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getProgressiveLoading progressiveLoading} to
 * <code>true</code> to prevent
 *  users from causing a large number of nodes to be loaded by scrolling too far ahead in the
 *  tree.
 *  <p>
 *  <h4>Required Format for Paging</h4>
 *  <P>
 *  <code>DsResponse</code>s from the server for a paging ResultTree should have the format:
 *  <pre><code>{startRow:  &lt;n&gt; // requested start row (index within direct siblings)
 *  endRow:    &lt;m&gt; // requested end row (index within direct siblings)
 *  totalRows: &lt;p&gt; // total rows that match the criteria (all direct siblings)
 *  data: [
 *      // would have m - n entries
 *      // if for any folder, "isOpen" property is true, node must have the format:
 *      {isOpen: true,
 *       children: [
 *           // child nodes - the server decides how many to send based on paging logic
 *       ],
 *       childCount: &lt;q&gt; // for paging; required if more children present than returned
 *      }
 *  ]}
 *  </code></pre>
 *  Both <code>startRow</code> and <code>endRow</code> may differ from the values passed to
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getRange ResultTree.getRange()} (being
 * farther apart) due to paging, and the value of
 *  <code>endRow</code> returned by the server may be less than that requested due to 
 *  <code>totalRows</code> not allowing enough requested rows.  <b>However, you must provide all
 *  requested rows if they're available - you can't return less than the full range requested
 *  just because you feel it might improve performance (or other reasons).</b>
 *  <P>
 *  If any child node is open,
 *  the rules are:<ul>
 *  <li>if a node has children, at least one must be included (we recommend at least a page)
 * via the {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty}, and
 * unless they're all included, the
 * {@link com.smartgwt.client.widgets.tree.ResultTree#getChildCountProperty childCountProperty}
 * must be specified
 * <li>if a node has no children, then either {@link
 * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty} must
 * be specified as the empty array, or {@link
 * com.smartgwt.client.widgets.tree.ResultTree#getChildCountProperty childCountProperty}
 *  provided as 0</ul>
 * The {@link com.smartgwt.client.widgets.tree.ResultTree#getChildCountProperty
 * childCountProperty} may be provided even if not
 * required as long as it's consistent with the {@link
 * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty},
 *  and both may also be optionally specified for closed nodes.  <b>If the rule about providing
 *  children for each open node is violated, a warning will be logged and an immediate fetch
 *  issued for the missing children.</b>  Note that in the above <code>DSResponse</code>, or in
 *  general when paging is active, you can't supply mixed levels of nodes in the data as is
 *  described in the section "Multi-Level Load on Demand" above for simpler modes of 
 *  <code>ResultTree/Tree</code>. 
 *  <P>
 *  Your server logic must choose which nodes to return as open or closed, and intelligently
 *  decide how many children to provide for open nodes, but the server should try to satisfy the
 *  requested <code>startRow</code> and <code>endRow</code> at the top level, and the 
 *  architecture should ensure that the chosen page size is large enough to at least cover the
 * maximum number of visible rows for the <code>TreeGrid</code>.  One reasonable approach might be
 *  to satisfy the top level node count, but also provide the children for all nested, open
 *  nodes, counting down, until the requested node count is also met through nested children.
 *  (Under such an approach, restrictions on the number of open nodes might be needed to avoid
 *  breaking the format rules we mentioned above when the included node count gets high.)
 *  <p>
 *  <h4>Filtering</h4>
 *  Paged ResultTrees may also be filtered like other trees (see
 * {@link com.smartgwt.client.widgets.tree.ResultTree#setCriteria ResultTree.setCriteria()}). 
 * However, if {@link com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter
 * ResultTree.keepParentsOnFilter} is
 *  enabled then server filtering is required.  To illustrate with an example, consider a case
 *  where the ResultTree has 10,000 folders at root level and where criteria applied to their
 *  children would eliminate all but 20, which happen to be at the end of the 10,000.  Purely
 *  client-side logic would have to perform 10,000 fetch operations to check whether each
 *  root-level node had children before arriving at the final set of 20.
 *  <p>
 *  For examples of this feature, see the following SDK example:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#tree_paging_for_children"
 * target="examples">Paging for Children Example</a></li>
 *  </ul>
 *  <p>
 *  <b>NOTE:</b> trees with thousands of visible nodes are very difficult for end users to
 *  navigate.  A <b>majority of the time</b> the best interface for showing a very large tree
 *  is to show a TreeGrid that displays just folders, adjacent to a ListGrid that shows items
 *  within those folders.
 *  <p>
 *  For example, the data in your email account can be thought of as an enormous tree of
 *  folders (Inbox, Sent, Drafts, Trash etc) with thousands of messages in each folder.
 *  However, none of the common email clients display email this way; all of them choose to
 *  show folders and messages separately, as this is clearly more usable.
 *  <p>
 *  Before starting on implementing paging within sets of children, carefully consider whether
 *  an interface like the above, or some entirely different interface, is actually a superior
 *  option.  It is exceedingly rare that paging within sets of children is the best choice.
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getKeepParentsOnFilter
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getDataFetchMode
 * @see com.smartgwt.client.data.DSRequest#getKeepParentsOnFilter
 * @see com.smartgwt.client.widgets.tree.ResultTree#getData
 * @see com.smartgwt.client.widgets.tree.ResultTree#getFetchMode
 * @see com.smartgwt.client.widgets.tree.ResultTree#getResultSize
 * @see com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter
 */
public interface TreeDataBinding {
}
