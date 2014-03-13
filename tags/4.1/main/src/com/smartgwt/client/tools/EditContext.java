/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.tools;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An EditContext provides an editing environment for a set of components. <P> An EditContext is typically populated by
 * adding a series of {@link com.smartgwt.client.tools.EditNode EditNodes} created via a {@link
 * com.smartgwt.client.tools.Palette}, either via drag and drop creation, or when loading from a saved version, via {@link
 * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} or  {@link
 * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()}. <P> An EditContext then provides
 * interfaces for further editing of the components represented by EditNodes.
 */
@BeanFactory.FrameworkClass
public interface EditContext {


    // ********************* Properties / Attributes ***********************

    /**
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no defaultPalette is provided, the EditContext uses an automatically created {@link com.smartgwt.client.tools.HiddenPalette}.
     *
     * @param defaultPalette the default Palette. Default value is null
     */
    public void setDefaultPalette(Palette defaultPalette) ;

    /**
     * {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     *
     * @return {@link com.smartgwt.client.tools.Palette} to use when an {@link com.smartgwt.client.tools.EditNode} is being created
     * directly by this EditContext, instead of being created due to a user interaction with a palette (eg dragging from a
     * {@link com.smartgwt.client.tools.TreePalette}, or clicking on {@link com.smartgwt.client.tools.MenuPalette}). <P> If no
     * defaultPalette is provided, the EditContext uses an automatically created {@link
     * com.smartgwt.client.tools.HiddenPalette}.
     */
    public Palette getDefaultPalette()  ;

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @param extraPalettes  Default value is null
     */
    public void setExtraPalettes(Palette... extraPalettes) ;

    /**
     * Additional {@link com.smartgwt.client.tools.Palette Palettes} to consult for metadata when deserializing {@link
     * com.smartgwt.client.tools.EditNode Edit Nodes}. Note that the {@link
     * com.smartgwt.client.tools.EditContext#getDefaultPalette defaultPalette} is always consulted and need not be provided
     * again here.
     *
     * @return Palette...
     */
    public Palette[] getExtraPalettes()  ;

    /**
     * If enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes}.  This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize).
     *
     * @param persistCoordinates  Default value is true
     */
    public void setPersistCoordinates(boolean persistCoordinates) ;

    /**
     * If enabled, changes to a {@link com.smartgwt.client.tools.EditNode#getLiveObject liveObject}'s position and size will be
     * persisted to their {@link com.smartgwt.client.tools.EditNode EditNodes}.  This applies to both programmatic calls and
     * user interaction (drag reposition or drag resize).
     *
     * @return boolean
     */
    public boolean getPersistCoordinates()  ;

    // ********************* Methods ***********************

	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to
     * preserve the relationships.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     */
    public EditNode addFromPaletteNode(PaletteNode paletteNode);

	/**
     * Creates a new EditNode from a PaletteNode, using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  If you have an array of possibly inter-related PaletteNodes, then you should use {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNodes addFromPaletteNodes()} on the array instead, in order to
     * preserve the relationships.
     * @param paletteNode the palette node to use to create the new node
     * @param parentNode optional the parent node if the new node should appear                                under a specific parent
     *
     * @return the EditNode created from the paletteNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNodes
     */
    public EditNode addFromPaletteNode(PaletteNode paletteNode, EditNode parentNode);


	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNode
     */
    public EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes);

	/**
     * Add the supplied {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} to the parentNode, preserving internal
     * references from one supplied PaletteNode to another. This method should be used with an array of possibly inter-related
     * PaletteNodes (for instance, those produced as a result of serialization via {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes serializeAllEditNodes()}, rather than calling {@link
     * com.smartgwt.client.tools.EditContext#addFromPaletteNode addFromPaletteNode()} on each individual PaletteNode.
     * @param paletteNodes array of PaletteNodes
     * @param parentNode parent to add to (defaults to the root)
     *
     * @return an array of the EditNodes added to the parentNode
     * @see com.smartgwt.client.tools.EditContext#addFromPaletteNode
     */
    public EditNode[] addFromPaletteNodes(PaletteNode[] paletteNodes, EditNode parentNode);


	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. <P> The EditContext
     * will interrogate the parent and new nodes to determine what field  within the parent allows a child of this type, and to
     * find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new relationship will then be stored
     * in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as the
     * correct target field via naming conventions, and the method TabSet.addTab() is likewise  discovered as the correct
     * method to add a Tab to a TabSet.
     * @param newNode new node to be added
     *
     * @return newNodenode added
     */
    public EditNode addNode(EditNode newNode);

    /**
     * @see {@link EditContext#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode);

    /**
     * @see {@link EditContext#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index);

    /**
     * @see {@link EditContext#addNode()}
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty);

	/**
     * Add a new {@link com.smartgwt.client.tools.EditNode} to the EditContext, under the specified parent. <P> The EditContext
     * will interrogate the parent and new nodes to determine what field  within the parent allows a child of this type, and to
     * find a method to add the newNode's  liveObject to the parentNode's liveObject.  The new relationship will then be stored
     * in the tree of EditNodes. <P> For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as the
     * correct target field via naming conventions, and the method TabSet.addTab() is likewise  discovered as the correct
     * method to add a Tab to a TabSet.
     * @param newNode new node to be added
     * @param parentNode parent to add the new node under.
     * @param index index within the parent's children array
     * @param parentProperty the property of the liveParent to which the new node should                                  be added, if not
     * auto-discoverable from the schema
     * @param skipParentComponentAdd whether to skip adding the liveObject to the liveParent                                           (default false)
     *
     * @return newNodenode added
     */
    public EditNode addNode(EditNode newNode, EditNode parentNode, Integer index, String parentProperty, Boolean skipParentComponentAdd);


	/**
     * Add {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     */
    public void addPaletteNodesFromJS(String jsCode);

    /**
     * @see {@link EditContext#addPaletteNodesFromJS()}
     */
    public void addPaletteNodesFromJS(String jsCode, EditNode parentNode);

	/**
     * Add {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     */
    public void addPaletteNodesFromJS(String jsCode, EditNode parentNode, String[] globals);


	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON EditContext.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON EditContext.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public void addPaletteNodesFromJSON(String jsonString);

    /**
     * @see {@link EditContext#addPaletteNodesFromJSON()}
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode);

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from a JSON representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON EditContext.serializeAllEditNodesAsJSON} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON EditContext.serializeEditNodesAsJSON}. <P> By default,
     * components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take
     * those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter
     * will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsonString JSON string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodesAsJSON
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodesAsJSON
     */
    public void addPaletteNodesFromJSON(String jsonString, EditNode parentNode, String[] globals);


	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes EditContext.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes EditContext.serializeEditNodes}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public void addPaletteNodesFromXML(String xmlString);

    /**
     * @see {@link EditContext#addPaletteNodesFromXML()}
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode);

	/**
     * Recreate {@link com.smartgwt.client.tools.EditNode EditNodes} from an XML representation of  {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes} (possibly created by calling {@link
     * com.smartgwt.client.tools.EditContext#serializeAllEditNodes EditContext.serializeAllEditNodes} or {@link
     * com.smartgwt.client.tools.EditContext#serializeEditNodes EditContext.serializeEditNodes}. <P> By default, components
     * that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed to take those global
     * IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code> parameter will actually
     * receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param xmlString XML string
     * @param parentNode parent node (defaults to the root)
     * @param globals widgets to allow to take their global IDs
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public void addPaletteNodesFromXML(String xmlString, EditNode parentNode, String[] globals);

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, and calls {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroy()} on the {@link com.smartgwt.client.tools.EditNode#getLiveObject
     * liveObjects}.
     */
    public void destroyAll();


	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By
     * default, components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed
     * to take those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code>
     * parameter will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param callback Callback used to return the PaletteNodes
     */
    public void getPaletteNodesFromJS(String jsCode, PaletteNodeCallback callback);

	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from a JavaScript source representation. <P> By
     * default, components that have {@link com.smartgwt.client.widgets.Canvas#getID global IDs} will not actually be allowed
     * to take those global IDs - instead, only widgets that have one of the global IDs passed as the <code>globals</code>
     * parameter will actually receive their global IDs.  To override this behavior, pass the special value {@link
     * com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS ALL_GLOBALS} for the <code>globals</code> parameter.
     * @param jsCode JavaScript code to eval.
     * @param callback Callback used to return the PaletteNodes
     * @param globals widgets to allow to take their global IDs
     */
    public void getPaletteNodesFromJS(String jsCode, PaletteNodeCallback callback, String[] globals);


	/**
     * Obtain {@link com.smartgwt.client.tools.PaletteNode PaletteNodes} from an XML representation, but do not add them to the
     * EditContext.
     * @param xmlString XML string
     * @param callback Callback used to return the PaletteNodes
     * @see com.smartgwt.client.tools.EditContext#serializeAllEditNodes
     * @see com.smartgwt.client.tools.EditContext#serializeEditNodes
     */
    public void getPaletteNodesFromXML(String xmlString, PaletteNodeCallback callback);


	/**
     * Creates and returns an EditNode using the {@link com.smartgwt.client.tools.EditContext#getDefaultPalette
     * defaultPalette}.  Does not add the newly created EditNode to the EditContext.
     * @param paletteNode the palette node to use to create the new node
     *
     * @return the EditNode created from the paletteNode
     */
    public EditNode makeEditNode(PaletteNode paletteNode);

	/**
     * Removes all {@link com.smartgwt.client.tools.EditNode EditNodes} from the EditContext, but does not destroy  the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObjects}.
     */
    public void removeAll();


	/**
     * Removes the specified properties from an editNode's serializable "defaults". Note that the {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject} is <u>not</u> updated by this method.  To set a property to
     * null (rather than removing it), use {@link com.smartgwt.client.tools.EditContext#setNodeProperties setNodeProperties()}
     * instead.
     * @param editNode the editNode to update
     * @param properties an array of property names to remove
     * @see com.smartgwt.client.tools.EditContext#setNodeProperties
     */
    public void removeNodeProperties(EditNode editNode, String[] properties);

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     */
    public String serializeAllEditNodes();

	/**
     * Serialize the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return an XML representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     */
    public String serializeAllEditNodes(Boolean serverless);

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     */
    public String serializeAllEditNodesAsJSON();

	/**
     * Encode the tree of {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. The result can be supplied to  {@link
     * com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return a JSON representation of PaletteNodes which can be used to                  recreate the tree of EditNodes.
     * @see com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     */
    public String serializeAllEditNodesAsJSON(Boolean serverless);


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     * addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return an XML representtion of the provided EditNodes
     */
    public String serializeEditNodes(EditNode[] nodes);

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to an XML representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML
     * addPaletteNodesFromXML()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return an XML representtion of the provided EditNodes
     */
    public String serializeEditNodes(EditNode[] nodes, Boolean serverless);


	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public String serializeEditNodesAsJSON(EditNode[] nodes);

	/**
     * Serialize the provided {@link com.smartgwt.client.tools.EditNode EditNodes} to a JSON representation of {@link
     * com.smartgwt.client.tools.PaletteNode PaletteNodes}. Note that the EditNodes must have been added to this EditContext.
     * The result can be supplied to {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromJSON
     * addPaletteNodesFromJSON()} to recreate the EditNodes.
     * @param nodes EditNodes to be serialized
     * @param serverless If true, specify DataSources in full rather than                               assuming they can be downloaded from the
     * server.                               Defaults to false.
     *
     * @return a JSON representtion of the provided EditNodes
     */
    public String serializeEditNodesAsJSON(EditNode[] nodes, Boolean serverless);


	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditContext#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public void setNodeProperties(EditNode editNode, Canvas properties);

	/**
     * Update an editNode's serializable "defaults" with the supplied properties. If you wish to remove a property from the
     * defaults (rather than setting it to null), then use {@link com.smartgwt.client.tools.EditContext#removeNodeProperties
     * removeNodeProperties()} instead.
     * @param editNode the editNode to update
     * @param properties the properties to apply
     * @param skipLiveObjectUpdate whether to skip updating the                                         {@link
     * com.smartgwt.client.tools.EditNode#getLiveObject liveObject},                                         e.g. if you have
     * already updated the liveObject
     * @see com.smartgwt.client.tools.EditContext#removeNodeProperties
     */
    public void setNodeProperties(EditNode editNode, Canvas properties, Boolean skipLiveObjectUpdate);


}


