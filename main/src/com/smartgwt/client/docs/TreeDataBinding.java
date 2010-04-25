
package com.smartgwt.client.docs;

/**
 * <h3>Tree DataBinding</h3>
 * The Smart GWT {@link com.smartgwt.client.widgets.tree.TreeGrid} component is a visual representation of a tree and
 * requires a {@link com.smartgwt.client.widgets.tree.Tree} or {@link com.smartgwt.client..ResultTree} datatype passed via
 * the {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} attribute to initialize the tree view.  The {@link
 * com.smartgwt.client.widgets.tree.Tree} datatype is used when you want to provide all of the tree nodes in one shot at
 * initialization time.  The {@link com.smartgwt.client..ResultTree} datatype is used when you want portions of the tree to
 * be loaded on demand from the server. <p> <b><u>Providing all data to the Tree at creation</u></b> <p> The simplest
 * mechanism by which to initialize a Tree is to simply provide all the data up-front when the Tree itself is created. 
 * Depending on the format of your tree data, this can be done by setting {@link
 * com.smartgwt.client.widgets.tree.Tree#getRoot root} or {@link com.smartgwt.client.widgets.tree.Tree#getData data}.  This
 * functionality is provided by the {@link com.smartgwt.client.widgets.tree.Tree} class. <p> For examples of this type of
 * databinding, see the following SDK examples: <ul> <li><a href='/examples/components/treeGrid_init.html'
 * onclick="window.open('/examples/components/treeGrid_init.html');return false;">TreeGrid Initialization Example</a>
 * <li><a href='/examples/server_integration/#jstlTree'
 * onclick="window.open('/examples/server_integration/#jstlTree');return false;">TreeGrid Initialization with JSTL</a>
 * </ul> <p> <b><u>Loading Tree nodes on demand</u></b> <p> In this mode, tree nodes are loaded on-demand the first time a
 * user expands a folder.  This approach is necessary for large trees.  This functionality is provided by the {@link
 * com.smartgwt.client..ResultTree} class. <p> ResultTrees require that every node in the tree have an {@link
 * com.smartgwt.client.widgets.tree.Tree#getIdField 'id'} that is unique tree-wide.  When the user expands a folder whose
 * contents have not yet been loaded from the server (or you programmatically call openFolder() on such a node), the client
 * automatically sends a {@link com.smartgwt.client.data.DSRequest} to the server to ask for all immediate children of that
 * node.  The {@link com.smartgwt.client.data.DSRequest} criteria will specify the id of the node for which children are
 * being requested via the <code>parentId</code> property (see {@link
 * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}). This client is asking the server: "give me all
 * nodes whose parentId is the id of this node". <P> If there are no pre-existing node ids in the dataset you are loading,
 * you must generate node ids (because the client needs some way to identify nodes when talking to the server). Generally a
 * node id should contain whatever information is required to fetch the node and it's children on the server.  One typical
 * approach is to use the path to the node as a node id.  For XML datasets in particular, the path may be a valid XPath, so
 * that server-side lookup of child nodes is just a matter of applying the node id as an XPath to a server-side
 * XMLDocument. <P> {@link com.smartgwt.client..ResultTree}s are created for you by the {@link
 * com.smartgwt.client.widgets.tree.TreeGrid} when you set {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataSource
 * dataSource}, but you can pass an initial dataset to a databound TreeGrid by setting {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getInitialData initialData}.  The {@link
 * com.smartgwt.client.widgets.tree.Tree#getIdField idField} is derived from the dataSource you provide to the TreeGrid -
 * the first field marked as {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey}:true becomes the
 * idField of the ResultTree. The {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} is found by
 * looking for a field that has a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} property
 * pointing to the idField. <P> If you do not provide {@link com.smartgwt.client.widgets.tree.TreeGrid#getInitialData
 * initialData}, the first DSRequest you receive will be a request for the nodes under root.  The id of the root node of
 * the tree is the value of the <code>rootValue</code> attribute on the {@link
 * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField} of the Tree DataSource.  <p> For examples of this
 * type of databinding, see the following SDK examples: <ul> <li><a href='/examples/databinding/tree_databinding.jsp'
 * onclick="window.open('/examples/databinding/tree_databinding.jsp');return false;">TreeGrid DataBinding Example</a>
 * <li><a href='/examples/server_integration/#xml2JSLOD'
 * onclick="window.open('/examples/server_integration/#xml2JSLOD');return false;">TreeGrid XML DataBinding</a> </ul> <P>
 * <b><u>Multi-Level load on demand</u></b> <P> The ResultTree's DSRequests ask for the immediate children of a node only
 * (by specifying <code>parentId</code> in the criteria). Any nodes returned whose <code>parentId</code> field value is
 * unset or matches this criterion will be added to the tree as immediate children of the node. However you are also free
 * to return multiple levels of children.  This can be done by simply returning a flat list of descendents with valid id's
 * and parentId's, exactly as though  you were initializing a multi-level tree via {@link
 * com.smartgwt.client.widgets.tree.Tree#getData data}.   <P> Note that when receiving multiple levels of children, the
 * ResultTree's assumption is that if any children are loaded for a parent, then that parent is considered fully loaded.
 * <P> When loading children for a given parent node, the ResultTree calls {@link
 * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} on its DataSource.  For custom code that may need to
 * reference the parentNode or tree in some way, the parent node whose children are being loaded is available on the
 * dsRequest instance in the DataSource flow as dsRequest.parentNode, where it can be inspected during {@link
 * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest}.
 */
public interface TreeDataBinding {
}
