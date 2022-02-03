
package com.smartgwt.client.docs;

/**
 * <h3>Component Containment and Hierarchy</h3>
 * Canvas hierarchy in the DOM is defined via {@link
 * com.smartgwt.client.widgets.Canvas#getParentCanvas parent} and {@link
 * com.smartgwt.client.widgets.Canvas#getChildren child} relationships. <P> These may be set up
 * explicitly via APIs such as {@link com.smartgwt.client.widgets.Canvas#addChild
 * Canvas.addChild()}, or may be automatically set up by composite components. For example {@link
 * com.smartgwt.client.widgets.tab.TabSet TabSets} will  nest their {@link
 * com.smartgwt.client.widgets.tab.Tab#getPane panes} inside an appropriate sub component.<br>
 * Developers using the {@link autoChildren} subsystem may also use the {@link
 * com.smartgwt.client.widgets.Canvas#getAutoParent autoParent} attribute to specify a target
 * parent. <P> In addition to parent-child relationships, Smart GWT components support  {@link
 * com.smartgwt.client.widgets.Canvas#getMasterCanvas master}-{@link
 * com.smartgwt.client.widgets.Canvas#getPeers peer} relationships. When a canvas is set to be the
 * peer of some other canvas, the master and peer will share the same parent canvas ({@link
 * com.smartgwt.client.widgets.Canvas#addChild reparenting} a master will automatically reparent
 * any peers). Peers will move, resize and redraw with their masters and commonly use {@link
 * com.smartgwt.client.widgets.Canvas#getSnapTo snapTo positioning}
 * @see com.smartgwt.client.widgets.Canvas#addChild
 * @see com.smartgwt.client.widgets.Canvas#removePeer
 * @see com.smartgwt.client.widgets.Canvas#depeer
 * @see com.smartgwt.client.widgets.Canvas#deparent
 * @see com.smartgwt.client.widgets.Canvas#removeChild
 * @see com.smartgwt.client.widgets.Canvas#addPeer
 * @see com.smartgwt.client.widgets.Canvas#getParentCanvas
 * @see com.smartgwt.client.widgets.Canvas#getMasterCanvas
 * @see com.smartgwt.client.widgets.Canvas#getParentElements
 * @see com.smartgwt.client.widgets.Canvas#contains
 * @see com.smartgwt.client.widgets.Canvas#getParentElement
 * @see com.smartgwt.client.widgets.Canvas#getParentCanvas
 * @see com.smartgwt.client.widgets.Canvas#getTopElement
 * @see com.smartgwt.client.widgets.Canvas#getMasterElement
 * @see com.smartgwt.client.widgets.Canvas#getChildren
 * @see com.smartgwt.client.widgets.Canvas#getPeers
 */
public interface Containment {
}
