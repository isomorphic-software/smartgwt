/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

public class OrderItemData {

    private static OrderItem[] records;

    public static OrderItem[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static OrderItem[] getNewRecords() {
        return new OrderItem[]{
                new OrderItem(0, 8805, "Anti Virus Suite", "Software", new Date(110, 2, 5), 2, 50),
                new OrderItem(1, 4833, "USB Ergonomic Keyboard", "Hardware", new Date(109, 10, 13), 1, 99.99f),
                new OrderItem(2, 9551, "Lumbar Support Cushion", "Hardware", new Date(110, 1, 2), 1, 75),
                new OrderItem(3, 954, "USB Keyboard", "Hardware", new Date(109, 10, 20), 12, 34.99f),

                new OrderItem(4, 616, "Consulting Services", "Services", new Date(109, 10, 10), 40, 100),
                new OrderItem(5, 8357, "Office Application Suite", "Software", new Date(110, 2, 5), 14, 30),
                new OrderItem(6, 4582, "Anti Virus Suite", "Software", new Date(110, 1, 20), 22, 50),
                new OrderItem(7, 9373, "On-site Training", "Services", new Date(109, 10, 10), 20, 100),

                new OrderItem(8, 9311, "Software Development Kit", "Software", new Date(110, 1, 20), 8, 249.99f),
                new OrderItem(9, 7806, "15 inch flat panel monitor", "Hardware", new Date(109, 10, 13), 4, 300),
                new OrderItem(10, 8620, "18 inch flat panel monitor", "Hardware", new Date(110, 1, 2), 2, 50),

                new OrderItem(11, 629, "Office Productivity Suite", "Software", new Date(110, 2, 5), 2, 64.99f),
                new OrderItem(12, 1264, "Office Productivity Suite", "Software", new Date(110, 2, 5), 2, 64.99f),
                new OrderItem(13, 7100, "USB Ergonomic Keyboard", "Hardware", new Date(109, 10, 20), 6, 99.99f),
                new OrderItem(14, 9647, "Consulting Services", "Services", new Date(109, 10,10), 10, 100),

                new OrderItem(15, 8468, "USB Optical Mouse", "Hardware", new Date(109, 10, 13), 5, 29.99f),
                new OrderItem(16, 9496, "Off-site Training", "Services", new Date(109, 10, 10), 35, 80),
                new OrderItem(17, 5124, "USB Stereo Headset", "Hardware", new Date(109, 10, 20), 1, 69.99f),
                new OrderItem(18, 1799, "Office Application Suite", "Software", new Date(110, 1, 20), 222, 30),
                new OrderItem(19, 7020, "Consulting Services", "Services", new Date(109, 10, 10), 100, 80)
        };
    }
}