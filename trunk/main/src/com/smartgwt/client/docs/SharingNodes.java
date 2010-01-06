
package com.smartgwt.client.docs;

/**
 * <h3>Sharing Nodes</h3>
 * For local Trees, that is, Trees that don't use load on demand, Smart GWT supports setting&#010 up the Tree structure by
 * setting properties such as "childrenProperty", directly on data&#010 nodes.  This allows for simpler, faster structures
 * for many common tree uses, but can create&#010 confusion if nodes need to be shared across Trees.&#010 <P>&#010 <b>using
 * one node in two places in one Tree</b>&#010 <P>&#010 To do this, either clone the shared node like so:<pre>&#010&#010   
 * tree.add(isc.addProperties({}, sharedNode));&#010&#010 </pre> or place the shared data in a shared subobject
 * instead.&#010 <P>&#010 <b>sharing nodes or subtrees across Trees</b>&#010 <P>&#010 Individual nodes within differing
 * tree structures can be shared by two Trees only if&#010 {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty
 * nameProperty}, {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty childrenProperty}, and {@link
 * com.smartgwt.client.widgets.tree.Tree#getOpenProperty openProperty} have&#010 different values in each Tree.&#010
 * <P>&#010 As a special case of this, two Trees can maintain different open state across a single&#010 read-only structure
 * as long as just "openProperty" has a different value in each Tree.
 */
public interface SharingNodes {
}
