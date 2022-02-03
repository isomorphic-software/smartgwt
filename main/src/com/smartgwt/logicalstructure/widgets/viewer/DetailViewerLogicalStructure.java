package com.smartgwt.logicalstructure.widgets.viewer;
import com.smartgwt.client.core.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.i18n.*;
import com.smartgwt.client.event.*;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.plugins.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;

public class DetailViewerLogicalStructure extends CanvasLogicalStructure {
    public String blockSeparator;
    public String blockStyle;
    public String canPickFields;
    public String cellStyle;
    public String configureFieldsText;
    public String dataArity;
    public String dataFetchMode;
    public String dateFormatter;
    public String datetimeFormatter;
    public String editProxyConstructor;
    public String emptyCellValue;
    public String emptyMessage;
    public String emptyMessageStyle;
    public String fieldIdProperty;
    public String[] fieldPickerFieldProperties;
    public String headerStyle;
    public String hiliteIconHeight;
    public String hiliteIconLeftPadding;
    public String hiliteIconPosition;
    public String hiliteIconRightPadding;
    public String[] hiliteIcons;
    public String hiliteIconSize;
    public String hiliteIconWidth;
    public String labelAlign;
    public String labelPrefix;
    public String labelStyle;
    public String labelSuffix;
    public String linkTextProperty;
    public String loadingMessage;
    public String loadingMessageStyle;
    public String printCellStyle;
    public String printHeaderStyle;
    public String printLabelStyle;
    public String recordsPerBlock;
    public String rowHeight;
    public String separatorStyle;
    public String showDetailFields;
    public String showEmptyField;
    public String showEmptyMessage;
    public String styleName;
    public String timeFormatter;
    public String valueAlign;
    public String wrapLabel;
    public String wrapValues;
}
