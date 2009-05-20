package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PartRecord extends ListGridRecord {

    public PartRecord() {
    }

    public PartRecord(String partName, String partSrc, int partNum) {
        setPartName(partName);
        setPartSrc(partSrc);
        setPartNum(partNum);
    }

    public void setPartName(String partName) {
        setAttribute("partName", partName);
    }

    public void setPartSrc(String partSrc) {
        setAttribute("partSrc", partSrc);
    }

    public void setPartNum(int partNum) {
        setAttribute("partNum", partNum);
    }
}
