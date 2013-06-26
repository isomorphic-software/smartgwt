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
 
package com.smartgwt.client.rpc;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.rpc.RPCResponse;
import java.util.Map;

public abstract class LoadScreenCallback {

	private Canvas screen;
	private RPCResponse rpcResponse;
	private Map suppressedGlobals;

	/**
	 * @param The last top-level component loaded
	 */
	public void setScreen(Canvas screen){
		this.screen = screen;
	}
	/**
	 * The last top-level component loaded
	 */
	public Canvas getScreen(){
		return this.screen;
	}

	/**
	 * @param 
	 */
	public void setRpcResponse(RPCResponse rpcResponse){
		this.rpcResponse = rpcResponse;
	}
	/**
	 * 
	 */
	public RPCResponse getRpcResponse(){
		return this.rpcResponse;
	}

	/**
	 * @param A collection of suppressed globals.
	 */
	public void setSuppressedGlobals(Map suppressedGlobals){
		this.suppressedGlobals = suppressedGlobals;
	}
	/**
	 * A collection of suppressed globals.
	 */
	public Map getSuppressedGlobals(){
		return this.suppressedGlobals;
	}

    /** 
     * A Callback to evaluate when a screen is loaded via {@link com.smartgwt.client.rpc.RPCManager#loadScreen
     * RPCManager.loadScreen}.
     */
	public abstract void execute();
} 
