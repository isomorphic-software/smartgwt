package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.ImgProperties;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public final class PartsListGrid extends ListGrid {

    public PartsListGrid() {
        setWidth(150);
        setCellHeight(24);
        setImageSize(16);
        setShowEdges(true);
        setBorder("0px");
        setBodyStyleName("normal");
        setShowHeader(false);
        setLeaveScrollbarGap(false);
        setEmptyMessage("Drag &amp; drop parts here");

        ListGridField partSrcField = new ListGridField("partSrc", 24);
        partSrcField.setType(ListGridFieldType.IMAGE);
        partSrcField.setImageURLPrefix("pieces/16/");

        ListGridField partNameField = new ListGridField("partName");
        ListGridField partNumField = new ListGridField("partNum", 20);

        setFields(partSrcField, partNameField, partNumField);

        setTrackerImage(new ImgProperties("pieces/24/cubes_all.png", 24, 24));
    }
}
