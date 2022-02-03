package com.smartgwt.sample.showcase.client.data;

public class PartData {

    private static PartRecord[] records;

    public static PartRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static PartRecord[] getNewRecords() {
        return new PartRecord[]{
                new PartRecord("Blue", "cube_blue.png", 1),
                new PartRecord("Yellow", "cube_yellow.png", 2),
                new PartRecord("Green", "cube_green.png", 3),
                new PartRecord("Blue", "cube_blue.png", 4),
                new PartRecord("Yellow", "cube_yellow.png", 5),
                new PartRecord("Green", "cube_green.png", 6),
                new PartRecord("Blue", "cube_blue.png", 7),
                new PartRecord("Yellow", "cube_yellow.png", 8),
                new PartRecord("Green", "cube_green.png", 9),
        };
    }
}