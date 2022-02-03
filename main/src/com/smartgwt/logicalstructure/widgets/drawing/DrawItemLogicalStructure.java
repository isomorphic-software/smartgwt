package com.smartgwt.logicalstructure.widgets.drawing;
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

public class DrawItemLogicalStructure extends BaseWidgetLogicalStructure {
    public String canDrag;
    public String canHover;
    public Menu contextMenu;
    public String cursor;
    public String destroyed;
    public String destroying;
    public String dragStartDistance;
    public DrawGroup drawGroup;
    public DrawPane drawPane;
    public String editProxyConstructor;
    public String endArrow;
    public String eventOpaque;
    public String fillColor;
    public Gradient fillGradientAsGradient;
    public String fillGradientAsString;
    public String hoverDelay;
    public String[] knobs;
    public String lineCap;
    public String lineColor;
    public String linePattern;
    public String lineWidth;
    public String[] moveKnobOffset;
    public String moveKnobPoint;
    public String prompt;
    public String[] proportionalResizeModifiers;
    public String proportionalResizing;
    public String[] resizeKnobPoints;
    public String resizeViaLocalTransformOnly;
    public String[] scale;
    public Shadow shadow;
    public String showHover;
    public String showResizeOutline;
    public String showTitleLabelBackground;
    public String startArrow;
    public String title;
    public String titleAutoFit;
    public String titleAutoFitMargin;
    public String titleAutoFitRotationMode;
    public String titleLabelPadding;
    public String titleRotationMode;
    public String[] translate;
    public String useSimpleTransform;
    public String xShearFactor;
    public String yShearFactor;
    public String zIndex;
}