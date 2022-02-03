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
 
package com.smartgwt.client.widgets;


public interface AnimationCallback {

    /** 
     * A {@link com.smartgwt.client.docs.Callback} called when the move completes.
     *
     * @param earlyFinish true if the animation was cut short.  To quit an animation                               early, simply call the
     * non-animated version of the same                               API, so for example call {@link
     * com.smartgwt.client.widgets.Canvas#hide Canvas.hide()} to cut short                               an animation from
     * {@link com.smartgwt.client.widgets.Canvas#animateHide Canvas.animateHide()} already in                              
     * progress.
     */
	public void execute(boolean earlyFinish);
} 
