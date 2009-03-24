/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */


package com.smartgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.util.KeyCallback;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.tile.TileLayout;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.ColorPicker;
import com.smartgwt.client.widgets.form.events.ColorSelectedHandler;
import com.smartgwt.client.widgets.form.events.ColorSelectedEvent;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TileLayoutPolicy;
import com.smartgwt.client.types.Cursor;

public class Test implements EntryPoint {

    public void onModuleLoad() {
        if (!GWT.isScript()) {
            KeyIdentifier debugKey = new KeyIdentifier();
            debugKey.setCtrlKey(true);
            debugKey.setKeyName("D");

            Page.registerKey(debugKey, new KeyCallback() {
                public void execute(String keyName) {
                    SC.showConsole();
                }
            });
        }

        final TileLayout homePanel = new TileLayout();

/*homePanel.setWidth("100%");
homePanel.setHeight("100%");
homePanel.setBackgroundColor("#99FFFF");
homePanel.setExpandMargins(true);
homePanel.setLayoutPolicy(TileLayoutPolicy.FIT);
homePanel.setTileWidth(200);
homePanel.setTileHeight(250);
homePanel.setTileMargin(20);
homePanel.setShowCustomScrollbars(true);
homePanel.setDragRepositionCursor(Cursor.MOVE);
homePanel.setCanAcceptDrop(true);

Label test1 = new Label();
Label test2 = new Label();
Label test3 = new Label();

test1.setBackgroundColor("Red");
test2.setBackgroundColor("Red");
test3.setBackgroundColor("Red");

test1.setCanDragReposition(true);
test2.setCanDragReposition(true);
test3.setCanDragReposition(true);

test1.setCanDrag(true);
test2.setCanDrag(true);
test3.setCanDrag(true);

test1.setContents("dfdsfsd");
test2.setCanDrag(true);
test3.setCanDrag(true);

test1.setContents("1");
test2.setContents("2");
test3.setContents("3");

homePanel.addTile(test1);
homePanel.addTile(test2);                  
homePanel.addTile(test3);

homePanel.draw();*/
        TileLayout tile = new TileLayout();
        tile.setSize("100%", "100%");
        tile.setTileWidth(50);
        tile.setTileHeight(50);
        tile.setLayoutPolicy(TileLayoutPolicy.FLOW);
        tile.setOverflow(Overflow.VISIBLE);
        tile.setAutoWrapLines(true);
        tile.setShowEdges(true);
        tile.setCanDrag(true);
        tile.setCanDragReposition(true);
        tile.setCanAcceptDrop(true);
        for (int i = 0; i < 50; i++) {
            Label label = new Label();
            label.setContents("Tile " + i);
            label.setAutoWidth();
            label.setAutoHeight();
            tile.addTile(label);
        }

       /* tile.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                System.out.println("");
            }
        });*/
        tile.draw();
        tile.layoutTiles();

    }
}