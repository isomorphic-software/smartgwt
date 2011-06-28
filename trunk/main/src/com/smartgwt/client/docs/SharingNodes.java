
package com.smartgwt.client.docs;

/**
 * <h3>Sharing Nodes</h3>
 * For local Trees, that is, Trees that don't use load on demand, Smart GWT supports setting
 *  up the Tree structure by setting properties such as "childrenProperty", directly on data
 *  nodes.  This allows for simpler, faster structures for many common tree uses, but can create
 *  confusion if nodes need to be shared across Trees.
 *  <P>
 *  <b>using one node in two places in one Tree</b>
 *  <P>
 *  To do this, either clone the shared node like so:<pre>
 * 
 *      tree.add(isc.addProperties({}, sharedNode));
 * 
 *  </pre> or place the shared data in a shared subobject instead.
 *  <P>
 *  <b>sharing nodes or subtrees across Trees</b>
 *  <P>
 *  Individual nodes within differing tree structures can be shared by two Trees only if
 * {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}, {@link
 * com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty}, and {@link
 * com.smartgwt.client.widgets.tree.Tree#getOpenProperty openProperty} have
 *  different values in each Tree.
 *  <P>
 *  As a special case of this, two Trees can maintain different open state across a single
 *  read-only structure as long as just "openProperty" has a different value in each Tree.
 */
public interface SharingNodes {
}
