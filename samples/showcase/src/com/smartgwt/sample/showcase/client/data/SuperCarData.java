package com.smartgwt.sample.showcase.client.data;

import java.util.List;
import java.util.ArrayList;

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SuperCarData {

    private static final String carModels[] = {
        "Ultra",
        "Sparrow",
        "Tiger",
        "Jupiter",
        "Walrus",
        "Alpine",
        "Hero",
        "Vertex",
        "Spider"
    };

    private static final String featureNames[] = {
        "turbo",
        "sunroof",
        "rearWing",
        "surroundSound",
        "noiseReduce",
        "driveAssist",
        "gps",
        "runFlat",
        "gullDoors",
        "alloyWheels",
        "allWheelDrive",
        "rearSteering",
        "stealthPaint",
        "smokeScreen",
        "regenerative",
        "solarPanel",
        "selfPark"
    };

    private static final String featureTitles[] = {
        "Turbocharger",
        "Sun Roof",
        "Rear Wing",
        "Surround Sound",
        "Active Noise Control",
        "AI Drive Assistance",
        "GPS Navigation",
        "Run-flat Tires",
        "Gull Wing Doors",
        "Alloy Wheels",
        "All Wheel Drive",
        "Rear Wheel Steering",
        "Radar Absorbing Paint",
        "Smoke Screen",
        "Regenerative Braking",
        "Solar Panel",
        "Self Parking"
    };

    public static ListGridField[] getFields() {
        
        List<ListGridField> fields = new ArrayList<ListGridField>();
        
        ListGridField modelName = new ListGridField("modelName", "Model Name");
        modelName.setWidth(70);
        modelName.setWrap(true);
        modelName.setType(ListGridFieldType.TEXT);
        modelName.setRotateTitle(false);

        fields.add(modelName);

        for (int i = 0; i < featureNames.length; i++) {
            ListGridField field = new ListGridField(featureNames[i], featureTitles[i]);
            field.setType(ListGridFieldType.BOOLEAN);
            fields.add(field);
        }
        
        return fields.toArray(new ListGridField[fields.size()]);
    }

    public static ListGridRecord[] getRecords() {
        List<ListGridRecord> records = new ArrayList<ListGridRecord>();

        for (int i = 0; i < carModels.length; i++) {
            ListGridRecord record = new ListGridRecord();
            record.setAttribute("modelName", carModels[i]);
            for (int j = 0; j < featureNames.length; j++) {
                record.setAttribute(featureNames[j], Math.random() >= 0.5);
            }
            records.add(record);
        }
        return records.toArray(new ListGridRecord[records.size()]);
    }
}
