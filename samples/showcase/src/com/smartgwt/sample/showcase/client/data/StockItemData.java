package com.smartgwt.sample.showcase.client.data;

public class StockItemData {

    private static StockItemRecord[] records;

    public static StockItemRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static StockItemRecord[] getNewRecords() {
        return new StockItemRecord[]{
            new StockItemRecord(1, "Roll", "Adding Machine Roll 57x57mm Standard", 0.41f, 4530),
            new StockItemRecord(2, "Roll", "Adding Machine Roll 57x64mm Standard", 0.47f, 9060),
            new StockItemRecord(3, "Roll", "Adding Machine Roll 57x76mm Standard", 0.61f, 13590),
            new StockItemRecord(4, "Roll", "Adding Machine Roll 44x76mm Standard", 0.58f, 19000),
            new StockItemRecord(5, "Roll", "Adding Machine Roll 57x57mm Lint Free", 0.52f, 22650),
            new StockItemRecord(6, null, "Glue UHU Clear Gum 250ml", 2.26f, 72480),
            new StockItemRecord(7, null, "Glue UHU Office Paste 250ml", 1.73f, 86070),
            new StockItemRecord(8, "Ea", "Spray Adhesive Multipurpose Can No.76 3M", 12.76f, 95130),
            new StockItemRecord(9, "Ea", "Glue Pentel 30CC Roll On 30ml", 1.83f, 99660)
        };
    }
}