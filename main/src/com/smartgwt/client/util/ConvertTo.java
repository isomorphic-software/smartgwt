
package com.smartgwt.client.util;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.core.DataClass;

import com.smartgwt.client.widgets.form.fields.FormItemFactory;

/**
 * This object contains all of the methods for converting from a JavaScriptObject to an array of specific
 *  SmartGWT class types.
 */
public final class ConvertTo {

    /* No need to create instances of this class. */
    private ConvertTo(){}

    public static int[] arrayOfint(JavaScriptObject array) {
        return JSOHelper.convertToJavaIntArray(array);
    }

    public static Integer[] arrayOfInteger(JavaScriptObject array) {
        return JSOHelper.convertToJavaInterArray(array);
    }

    public static String[] arrayOfString(JavaScriptObject array) {
        return JSOHelper.convertToJavaStringArray(array);
    }

    public static Float[] arrayOfFloat(JavaScriptObject array) {
        return JSOHelper.convertToJavaFloatArray(array);
    }

    public static float[] arrayOffloat(JavaScriptObject array) {
        int length = JSOHelper.getArrayLength(array);
        float[] arr = new float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = JSOHelper.getfloatArrayValue(array, i);
        }
        return arr;
    }

    public static Date[] arrayOfDate(JavaScriptObject array) {
        return JSOHelper.convertToJavaDateArray(array);
    }

    public static Object[] arrayOfObject(JavaScriptObject array) {
        return JSOHelper.convertToJavaObjectArray(array);
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LineCap} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LineCap[]
	 */
    public static com.smartgwt.client.types.LineCap[] arrayOfLineCap(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LineCap[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LineCap[] objects = new com.smartgwt.client.types.LineCap[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LineCap obj = EnumUtil.getEnum(com.smartgwt.client.types.LineCap.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ListGridComponent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListGridComponent[]
	 */
    public static com.smartgwt.client.types.ListGridComponent[] arrayOfListGridComponent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListGridComponent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ListGridComponent[] objects = new com.smartgwt.client.types.ListGridComponent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridComponent obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridComponent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PromptStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PromptStyle[]
	 */
    public static com.smartgwt.client.types.PromptStyle[] arrayOfPromptStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PromptStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PromptStyle[] objects = new com.smartgwt.client.types.PromptStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PromptStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.PromptStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.XJSONDataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.XJSONDataSource[]
	 */
    public static com.smartgwt.client.data.XJSONDataSource[] arrayOfXJSONDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.XJSONDataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.XJSONDataSource[] objects = new com.smartgwt.client.data.XJSONDataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.XJSONDataSource obj = new com.smartgwt.client.data.XJSONDataSource(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LabelCollapseMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LabelCollapseMode[]
	 */
    public static com.smartgwt.client.types.LabelCollapseMode[] arrayOfLabelCollapseMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LabelCollapseMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LabelCollapseMode[] objects = new com.smartgwt.client.types.LabelCollapseMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LabelCollapseMode obj = EnumUtil.getEnum(com.smartgwt.client.types.LabelCollapseMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.LinearGradient} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.LinearGradient[]
	 */
    public static com.smartgwt.client.widgets.drawing.LinearGradient[] arrayOfLinearGradient(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.LinearGradient[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.LinearGradient[] ret = new com.smartgwt.client.widgets.drawing.LinearGradient[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.LinearGradient(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.LinearGradient[] objects = new com.smartgwt.client.widgets.drawing.LinearGradient[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.LinearGradient obj = (com.smartgwt.client.widgets.drawing.LinearGradient) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.LinearGradient(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DragDataAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DragDataAction[]
	 */
    public static com.smartgwt.client.types.DragDataAction[] arrayOfDragDataAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DragDataAction[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DragDataAction[] objects = new com.smartgwt.client.types.DragDataAction[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragDataAction obj = EnumUtil.getEnum(com.smartgwt.client.types.DragDataAction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawLabel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawLabel[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawLabel[] arrayOfDrawLabel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawLabel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawLabel[] objects = new com.smartgwt.client.widgets.drawing.DrawLabel[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawLabel obj = new com.smartgwt.client.widgets.drawing.DrawLabel(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.ValuesManager} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.ValuesManager[]
	 */
    public static com.smartgwt.client.widgets.form.ValuesManager[] arrayOfValuesManager(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.ValuesManager[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.ValuesManager[] objects = new com.smartgwt.client.widgets.form.ValuesManager[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.ValuesManager obj = new com.smartgwt.client.widgets.form.ValuesManager(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tab.ImgTab} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tab.ImgTab[]
	 */
    public static com.smartgwt.client.widgets.tab.ImgTab[] arrayOfImgTab(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tab.ImgTab[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tab.ImgTab[] objects = new com.smartgwt.client.widgets.tab.ImgTab[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tab.ImgTab obj = (com.smartgwt.client.widgets.tab.ImgTab) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tab.ImgTab(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.SplitPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.SplitPane[]
	 */
    public static com.smartgwt.client.widgets.layout.SplitPane[] arrayOfSplitPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.SplitPane[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.SplitPane[] objects = new com.smartgwt.client.widgets.layout.SplitPane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.SplitPane obj = (com.smartgwt.client.widgets.layout.SplitPane) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.SplitPane(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.AdvancedCriteria} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.AdvancedCriteria[]
	 */
    public static com.smartgwt.client.data.AdvancedCriteria[] arrayOfAdvancedCriteria(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.AdvancedCriteria[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.AdvancedCriteria[] ret = new com.smartgwt.client.data.AdvancedCriteria[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.AdvancedCriteria(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.AdvancedCriteria[] objects = new com.smartgwt.client.data.AdvancedCriteria[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.AdvancedCriteria obj = (com.smartgwt.client.data.AdvancedCriteria) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.AdvancedCriteria(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DragIntersectStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DragIntersectStyle[]
	 */
    public static com.smartgwt.client.types.DragIntersectStyle[] arrayOfDragIntersectStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DragIntersectStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DragIntersectStyle[] objects = new com.smartgwt.client.types.DragIntersectStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragIntersectStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.DragIntersectStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LogicalOperator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LogicalOperator[]
	 */
    public static com.smartgwt.client.types.LogicalOperator[] arrayOfLogicalOperator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LogicalOperator[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LogicalOperator[] objects = new com.smartgwt.client.types.LogicalOperator[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LogicalOperator obj = EnumUtil.getEnum(com.smartgwt.client.types.LogicalOperator.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DataLineType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DataLineType[]
	 */
    public static com.smartgwt.client.types.DataLineType[] arrayOfDataLineType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DataLineType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DataLineType[] objects = new com.smartgwt.client.types.DataLineType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DataLineType obj = EnumUtil.getEnum(com.smartgwt.client.types.DataLineType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.TextSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.TextSettings[]
	 */
    public static com.smartgwt.client.data.TextSettings[] arrayOfTextSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.TextSettings[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.TextSettings[] objects = new com.smartgwt.client.data.TextSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.TextSettings obj = new com.smartgwt.client.data.TextSettings(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MultiFilePicker} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MultiFilePicker[]
	 */
    public static com.smartgwt.client.widgets.MultiFilePicker[] arrayOfMultiFilePicker(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MultiFilePicker[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MultiFilePicker[] objects = new com.smartgwt.client.widgets.MultiFilePicker[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MultiFilePicker obj = (com.smartgwt.client.widgets.MultiFilePicker) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.MultiFilePicker(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ValidationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ValidationMode[]
	 */
    public static com.smartgwt.client.types.ValidationMode[] arrayOfValidationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ValidationMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ValidationMode[] objects = new com.smartgwt.client.types.ValidationMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValidationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ValidationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Label} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Label[]
	 */
    public static com.smartgwt.client.widgets.Label[] arrayOfLabel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Label[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Label[] objects = new com.smartgwt.client.widgets.Label[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Label obj = (com.smartgwt.client.widgets.Label) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Label(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.BackgroundRepeat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.BackgroundRepeat[]
	 */
    public static com.smartgwt.client.types.BackgroundRepeat[] arrayOfBackgroundRepeat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.BackgroundRepeat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.BackgroundRepeat[] objects = new com.smartgwt.client.types.BackgroundRepeat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.BackgroundRepeat obj = EnumUtil.getEnum(com.smartgwt.client.types.BackgroundRepeat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.Portlet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.Portlet[]
	 */
    public static com.smartgwt.client.widgets.layout.Portlet[] arrayOfPortlet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.Portlet[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.Portlet[] objects = new com.smartgwt.client.widgets.layout.Portlet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.Portlet obj = (com.smartgwt.client.widgets.layout.Portlet) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.Portlet(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.RibbonBar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.RibbonBar[]
	 */
    public static com.smartgwt.client.widgets.toolbar.RibbonBar[] arrayOfRibbonBar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.RibbonBar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.RibbonBar[] objects = new com.smartgwt.client.widgets.toolbar.RibbonBar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.RibbonBar obj = (com.smartgwt.client.widgets.toolbar.RibbonBar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.RibbonBar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoFitWidthApproach} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoFitWidthApproach[]
	 */
    public static com.smartgwt.client.types.AutoFitWidthApproach[] arrayOfAutoFitWidthApproach(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoFitWidthApproach[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AutoFitWidthApproach[] objects = new com.smartgwt.client.types.AutoFitWidthApproach[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitWidthApproach obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitWidthApproach.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.RelativeDate} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.RelativeDate[]
	 */
    public static com.smartgwt.client.data.RelativeDate[] arrayOfRelativeDate(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.RelativeDate[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.RelativeDate[] ret = new com.smartgwt.client.data.RelativeDate[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.RelativeDate(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.RelativeDate[] objects = new com.smartgwt.client.data.RelativeDate[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.RelativeDate obj = (com.smartgwt.client.data.RelativeDate) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.RelativeDate(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.NavigationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.NavigationMode[]
	 */
    public static com.smartgwt.client.types.NavigationMode[] arrayOfNavigationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.NavigationMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.NavigationMode[] objects = new com.smartgwt.client.types.NavigationMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NavigationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.NavigationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.PortalLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.PortalLayout[]
	 */
    public static com.smartgwt.client.widgets.layout.PortalLayout[] arrayOfPortalLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.PortalLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.PortalLayout[] objects = new com.smartgwt.client.widgets.layout.PortalLayout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.PortalLayout obj = (com.smartgwt.client.widgets.layout.PortalLayout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.PortalLayout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.DataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.DataSource[]
	 */
    public static com.smartgwt.client.data.DataSource[] arrayOfDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.DataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.DataSource[] objects = new com.smartgwt.client.data.DataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.DataSource obj = new com.smartgwt.client.data.DataSource(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Splitbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Splitbar[]
	 */
    public static com.smartgwt.client.widgets.Splitbar[] arrayOfSplitbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Splitbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Splitbar[] objects = new com.smartgwt.client.widgets.Splitbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Splitbar obj = (com.smartgwt.client.widgets.Splitbar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Splitbar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ToolbarItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ToolbarItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ToolbarItem[] arrayOfToolbarItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ToolbarItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ToolbarItem[] objects = new com.smartgwt.client.widgets.form.fields.ToolbarItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ToolbarItem obj = (com.smartgwt.client.widgets.form.fields.ToolbarItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.ToolbarItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.DateTimeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.DateTimeItem[] arrayOfDateTimeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.DateTimeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.DateTimeItem[] objects = new com.smartgwt.client.widgets.form.fields.DateTimeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.DateTimeItem obj = (com.smartgwt.client.widgets.form.fields.DateTimeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.DateTimeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.DoubleItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.DoubleItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.DoubleItem[] arrayOfDoubleItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.DoubleItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.DoubleItem[] objects = new com.smartgwt.client.widgets.form.fields.DoubleItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.DoubleItem obj = (com.smartgwt.client.widgets.form.fields.DoubleItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.DoubleItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TopOperatorAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TopOperatorAppearance[]
	 */
    public static com.smartgwt.client.types.TopOperatorAppearance[] arrayOfTopOperatorAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TopOperatorAppearance[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TopOperatorAppearance[] objects = new com.smartgwt.client.types.TopOperatorAppearance[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TopOperatorAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.TopOperatorAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.Process} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.Process[]
	 */
    public static com.smartgwt.client.util.workflow.Process[] arrayOfProcess(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.Process[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.Process[] objects = new com.smartgwt.client.util.workflow.Process[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.Process obj = new com.smartgwt.client.util.workflow.Process(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.EdgedCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.EdgedCanvas[]
	 */
    public static com.smartgwt.client.widgets.EdgedCanvas[] arrayOfEdgedCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.EdgedCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.EdgedCanvas[] objects = new com.smartgwt.client.widgets.EdgedCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.EdgedCanvas obj = (com.smartgwt.client.widgets.EdgedCanvas) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.EdgedCanvas(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DrawPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DrawPosition[]
	 */
    public static com.smartgwt.client.types.DrawPosition[] arrayOfDrawPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DrawPosition[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DrawPosition[] objects = new com.smartgwt.client.types.DrawPosition[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DrawPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.DrawPosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SectionItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SectionItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SectionItem[] arrayOfSectionItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SectionItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SectionItem[] objects = new com.smartgwt.client.widgets.form.fields.SectionItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SectionItem obj = (com.smartgwt.client.widgets.form.fields.SectionItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SectionItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ArrowStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ArrowStyle[]
	 */
    public static com.smartgwt.client.types.ArrowStyle[] arrayOfArrowStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ArrowStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ArrowStyle[] objects = new com.smartgwt.client.types.ArrowStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ArrowStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.ArrowStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ServiceTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ServiceTask[]
	 */
    public static com.smartgwt.client.util.workflow.ServiceTask[] arrayOfServiceTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ServiceTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ServiceTask[] objects = new com.smartgwt.client.util.workflow.ServiceTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ServiceTask obj = new com.smartgwt.client.util.workflow.ServiceTask(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.HiddenItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.HiddenItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.HiddenItem[] arrayOfHiddenItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.HiddenItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.HiddenItem[] objects = new com.smartgwt.client.widgets.form.fields.HiddenItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.HiddenItem obj = (com.smartgwt.client.widgets.form.fields.HiddenItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.HiddenItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.FormItemIcon[]
	 */
    public static com.smartgwt.client.widgets.form.fields.FormItemIcon[] arrayOfFormItemIcon(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.FormItemIcon[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.form.fields.FormItemIcon[] ret = new com.smartgwt.client.widgets.form.fields.FormItemIcon[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.form.fields.FormItemIcon(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.FormItemIcon[] objects = new com.smartgwt.client.widgets.form.fields.FormItemIcon[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.FormItemIcon obj = (com.smartgwt.client.widgets.form.fields.FormItemIcon) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.FormItemIcon(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.ListGrid} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.ListGrid[]
	 */
    public static com.smartgwt.client.widgets.grid.ListGrid[] arrayOfListGrid(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.ListGrid[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.ListGrid[] objects = new com.smartgwt.client.widgets.grid.ListGrid[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.ListGrid obj = (com.smartgwt.client.widgets.grid.ListGrid) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.ListGrid(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.cube.FacetValue} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.cube.FacetValue[]
	 */
    public static com.smartgwt.client.widgets.cube.FacetValue[] arrayOfFacetValue(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.cube.FacetValue[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.cube.FacetValue[] ret = new com.smartgwt.client.widgets.cube.FacetValue[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.cube.FacetValue(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.cube.FacetValue[] objects = new com.smartgwt.client.widgets.cube.FacetValue[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.cube.FacetValue obj = (com.smartgwt.client.widgets.cube.FacetValue) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.cube.FacetValue(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SortArrow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SortArrow[]
	 */
    public static com.smartgwt.client.types.SortArrow[] arrayOfSortArrow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SortArrow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SortArrow[] objects = new com.smartgwt.client.types.SortArrow[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SortArrow obj = EnumUtil.getEnum(com.smartgwt.client.types.SortArrow.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TimeDisplayFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TimeDisplayFormat[]
	 */
    public static com.smartgwt.client.types.TimeDisplayFormat[] arrayOfTimeDisplayFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TimeDisplayFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TimeDisplayFormat[] objects = new com.smartgwt.client.types.TimeDisplayFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TimeDisplayFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.TimeDisplayFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.cube.CubeGrid} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.cube.CubeGrid[]
	 */
    public static com.smartgwt.client.widgets.cube.CubeGrid[] arrayOfCubeGrid(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.cube.CubeGrid[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.cube.CubeGrid[] objects = new com.smartgwt.client.widgets.cube.CubeGrid[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.cube.CubeGrid obj = (com.smartgwt.client.widgets.cube.CubeGrid) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.cube.CubeGrid(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecordLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecordLayout[]
	 */
    public static com.smartgwt.client.types.RecordLayout[] arrayOfRecordLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecordLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RecordLayout[] objects = new com.smartgwt.client.types.RecordLayout[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordLayout obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordLayout.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.TextExportSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.TextExportSettings[]
	 */
    public static com.smartgwt.client.data.TextExportSettings[] arrayOfTextExportSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.TextExportSettings[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.TextExportSettings[] objects = new com.smartgwt.client.data.TextExportSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.TextExportSettings obj = new com.smartgwt.client.data.TextExportSettings(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.cube.FacetValueMap} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.cube.FacetValueMap[]
	 */
    public static com.smartgwt.client.widgets.cube.FacetValueMap[] arrayOfFacetValueMap(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.cube.FacetValueMap[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.cube.FacetValueMap[] ret = new com.smartgwt.client.widgets.cube.FacetValueMap[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.cube.FacetValueMap(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.cube.FacetValueMap[] objects = new com.smartgwt.client.widgets.cube.FacetValueMap[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.cube.FacetValueMap obj = (com.smartgwt.client.widgets.cube.FacetValueMap) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.cube.FacetValueMap(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.NavigationDirection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.NavigationDirection[]
	 */
    public static com.smartgwt.client.types.NavigationDirection[] arrayOfNavigationDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.NavigationDirection[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.NavigationDirection[] objects = new com.smartgwt.client.types.NavigationDirection[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NavigationDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.NavigationDirection.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripResizer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripResizer[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripResizer[] arrayOfToolStripResizer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripResizer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripResizer[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripResizer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripResizer obj = (com.smartgwt.client.widgets.toolbar.ToolStripResizer) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStripResizer(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EditCompletionEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EditCompletionEvent[]
	 */
    public static com.smartgwt.client.types.EditCompletionEvent[] arrayOfEditCompletionEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EditCompletionEvent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EditCompletionEvent[] objects = new com.smartgwt.client.types.EditCompletionEvent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EditCompletionEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.EditCompletionEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Window} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Window[]
	 */
    public static com.smartgwt.client.widgets.Window[] arrayOfWindow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Window[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Window[] objects = new com.smartgwt.client.widgets.Window[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Window obj = (com.smartgwt.client.widgets.Window) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Window(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.BlurbItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.BlurbItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.BlurbItem[] arrayOfBlurbItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.BlurbItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.BlurbItem[] objects = new com.smartgwt.client.widgets.form.fields.BlurbItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.BlurbItem obj = (com.smartgwt.client.widgets.form.fields.BlurbItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.BlurbItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.DecisionGateway} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.DecisionGateway[]
	 */
    public static com.smartgwt.client.util.workflow.DecisionGateway[] arrayOfDecisionGateway(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.DecisionGateway[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.DecisionGateway[] objects = new com.smartgwt.client.util.workflow.DecisionGateway[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.DecisionGateway obj = new com.smartgwt.client.util.workflow.DecisionGateway(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.OperationBinding} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.OperationBinding[]
	 */
    public static com.smartgwt.client.data.OperationBinding[] arrayOfOperationBinding(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.OperationBinding[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.OperationBinding[] ret = new com.smartgwt.client.data.OperationBinding[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.OperationBinding(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.OperationBinding[] objects = new com.smartgwt.client.data.OperationBinding[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.OperationBinding obj = (com.smartgwt.client.data.OperationBinding) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.OperationBinding(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.ColorStop} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.ColorStop[]
	 */
    public static com.smartgwt.client.widgets.drawing.ColorStop[] arrayOfColorStop(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.ColorStop[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.ColorStop[] ret = new com.smartgwt.client.widgets.drawing.ColorStop[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.ColorStop(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.ColorStop[] objects = new com.smartgwt.client.widgets.drawing.ColorStop[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.ColorStop obj = (com.smartgwt.client.widgets.drawing.ColorStop) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.ColorStop(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.RangeSlider} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.RangeSlider[]
	 */
    public static com.smartgwt.client.widgets.RangeSlider[] arrayOfRangeSlider(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.RangeSlider[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.RangeSlider[] objects = new com.smartgwt.client.widgets.RangeSlider[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.RangeSlider obj = (com.smartgwt.client.widgets.RangeSlider) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.RangeSlider(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.StatefulCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.StatefulCanvas[]
	 */
    public static com.smartgwt.client.widgets.StatefulCanvas[] arrayOfStatefulCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.StatefulCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.StatefulCanvas[] objects = new com.smartgwt.client.widgets.StatefulCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.StatefulCanvas obj = (com.smartgwt.client.widgets.StatefulCanvas) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.StatefulCanvas(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DSServerType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DSServerType[]
	 */
    public static com.smartgwt.client.types.DSServerType[] arrayOfDSServerType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DSServerType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DSServerType[] objects = new com.smartgwt.client.types.DSServerType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSServerType obj = EnumUtil.getEnum(com.smartgwt.client.types.DSServerType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LoadState} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LoadState[]
	 */
    public static com.smartgwt.client.types.LoadState[] arrayOfLoadState(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LoadState[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LoadState[] objects = new com.smartgwt.client.types.LoadState[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LoadState obj = EnumUtil.getEnum(com.smartgwt.client.types.LoadState.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.NavigationButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.NavigationButton[]
	 */
    public static com.smartgwt.client.widgets.NavigationButton[] arrayOfNavigationButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.NavigationButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.NavigationButton[] objects = new com.smartgwt.client.widgets.NavigationButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.NavigationButton obj = (com.smartgwt.client.widgets.NavigationButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.NavigationButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.plugins.Applet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.plugins.Applet[]
	 */
    public static com.smartgwt.client.widgets.plugins.Applet[] arrayOfApplet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.plugins.Applet[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.plugins.Applet[] objects = new com.smartgwt.client.widgets.plugins.Applet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.plugins.Applet obj = (com.smartgwt.client.widgets.plugins.Applet) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.plugins.Applet(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.JSONDateFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.JSONDateFormat[]
	 */
    public static com.smartgwt.client.types.JSONDateFormat[] arrayOfJSONDateFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.JSONDateFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.JSONDateFormat[] objects = new com.smartgwt.client.types.JSONDateFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONDateFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONDateFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LocatorStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LocatorStrategy[]
	 */
    public static com.smartgwt.client.types.LocatorStrategy[] arrayOfLocatorStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LocatorStrategy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LocatorStrategy[] objects = new com.smartgwt.client.types.LocatorStrategy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LocatorStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.LocatorStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawGroup} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawGroup[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawGroup[] arrayOfDrawGroup(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawGroup[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawGroup[] objects = new com.smartgwt.client.widgets.drawing.DrawGroup[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawGroup obj = new com.smartgwt.client.widgets.drawing.DrawGroup(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.CriteriaPolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.CriteriaPolicy[]
	 */
    public static com.smartgwt.client.types.CriteriaPolicy[] arrayOfCriteriaPolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.CriteriaPolicy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.CriteriaPolicy[] objects = new com.smartgwt.client.types.CriteriaPolicy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CriteriaPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.CriteriaPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TabTitleEditEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TabTitleEditEvent[]
	 */
    public static com.smartgwt.client.types.TabTitleEditEvent[] arrayOfTabTitleEditEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TabTitleEditEvent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TabTitleEditEvent[] objects = new com.smartgwt.client.types.TabTitleEditEvent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TabTitleEditEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.TabTitleEditEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SendMethod} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SendMethod[]
	 */
    public static com.smartgwt.client.types.SendMethod[] arrayOfSendMethod(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SendMethod[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SendMethod[] objects = new com.smartgwt.client.types.SendMethod[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SendMethod obj = EnumUtil.getEnum(com.smartgwt.client.types.SendMethod.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tableview.TableView} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tableview.TableView[]
	 */
    public static com.smartgwt.client.widgets.tableview.TableView[] arrayOfTableView(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tableview.TableView[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tableview.TableView[] objects = new com.smartgwt.client.widgets.tableview.TableView[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tableview.TableView obj = (com.smartgwt.client.widgets.tableview.TableView) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tableview.TableView(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ProcessSequence} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ProcessSequence[]
	 */
    public static com.smartgwt.client.util.workflow.ProcessSequence[] arrayOfProcessSequence(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ProcessSequence[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ProcessSequence[] objects = new com.smartgwt.client.util.workflow.ProcessSequence[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ProcessSequence obj = new com.smartgwt.client.util.workflow.ProcessSequence(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.IconButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.IconButton[]
	 */
    public static com.smartgwt.client.widgets.IconButton[] arrayOfIconButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.IconButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.IconButton[] objects = new com.smartgwt.client.widgets.IconButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.IconButton obj = (com.smartgwt.client.widgets.IconButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.IconButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.ColorPicker} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.ColorPicker[]
	 */
    public static com.smartgwt.client.widgets.form.ColorPicker[] arrayOfColorPicker(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.ColorPicker[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.ColorPicker[] objects = new com.smartgwt.client.widgets.form.ColorPicker[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.ColorPicker obj = (com.smartgwt.client.widgets.form.ColorPicker) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.ColorPicker(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.HeaderLevel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.HeaderLevel[]
	 */
    public static com.smartgwt.client.widgets.calendar.HeaderLevel[] arrayOfHeaderLevel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.HeaderLevel[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.calendar.HeaderLevel[] ret = new com.smartgwt.client.widgets.calendar.HeaderLevel[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.calendar.HeaderLevel(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.HeaderLevel[] objects = new com.smartgwt.client.widgets.calendar.HeaderLevel[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.HeaderLevel obj = (com.smartgwt.client.widgets.calendar.HeaderLevel) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.HeaderLevel(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DSProtocol} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DSProtocol[]
	 */
    public static com.smartgwt.client.types.DSProtocol[] arrayOfDSProtocol(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DSProtocol[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DSProtocol[] objects = new com.smartgwt.client.types.DSProtocol[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSProtocol obj = EnumUtil.getEnum(com.smartgwt.client.types.DSProtocol.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MultiComboBoxLayoutStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MultiComboBoxLayoutStyle[]
	 */
    public static com.smartgwt.client.types.MultiComboBoxLayoutStyle[] arrayOfMultiComboBoxLayoutStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MultiComboBoxLayoutStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.MultiComboBoxLayoutStyle[] objects = new com.smartgwt.client.types.MultiComboBoxLayoutStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultiComboBoxLayoutStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.MultiComboBoxLayoutStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.PrintWindow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.PrintWindow[]
	 */
    public static com.smartgwt.client.widgets.PrintWindow[] arrayOfPrintWindow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.PrintWindow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.PrintWindow[] objects = new com.smartgwt.client.widgets.PrintWindow[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.PrintWindow obj = (com.smartgwt.client.widgets.PrintWindow) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.PrintWindow(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.PickTreeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.PickTreeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.PickTreeItem[] arrayOfPickTreeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.PickTreeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.PickTreeItem[] objects = new com.smartgwt.client.widgets.form.fields.PickTreeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.PickTreeItem obj = (com.smartgwt.client.widgets.form.fields.PickTreeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.PickTreeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.DateChooser} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.DateChooser[]
	 */
    public static com.smartgwt.client.widgets.DateChooser[] arrayOfDateChooser(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.DateChooser[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.DateChooser[] objects = new com.smartgwt.client.widgets.DateChooser[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.DateChooser obj = (com.smartgwt.client.widgets.DateChooser) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.DateChooser(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.viewer.DetailViewerField} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.viewer.DetailViewerField[]
	 */
    public static com.smartgwt.client.widgets.viewer.DetailViewerField[] arrayOfDetailViewerField(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.viewer.DetailViewerField[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.viewer.DetailViewerField[] ret = new com.smartgwt.client.widgets.viewer.DetailViewerField[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.viewer.DetailViewerField(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.viewer.DetailViewerField[] objects = new com.smartgwt.client.widgets.viewer.DetailViewerField[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.viewer.DetailViewerField obj = (com.smartgwt.client.widgets.viewer.DetailViewerField) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.viewer.DetailViewerField(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.DSRequest} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.DSRequest[]
	 */
    public static com.smartgwt.client.data.DSRequest[] arrayOfDSRequest(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.DSRequest[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.DSRequest[] ret = new com.smartgwt.client.data.DSRequest[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.DSRequest(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.DSRequest[] objects = new com.smartgwt.client.data.DSRequest[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.DSRequest obj = (com.smartgwt.client.data.DSRequest) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.DSRequest(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FireStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FireStyle[]
	 */
    public static com.smartgwt.client.types.FireStyle[] arrayOfFireStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FireStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FireStyle[] objects = new com.smartgwt.client.types.FireStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FireStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.FireStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawOval} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawOval[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawOval[] arrayOfDrawOval(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawOval[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawOval[] objects = new com.smartgwt.client.widgets.drawing.DrawOval[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawOval obj = new com.smartgwt.client.widgets.drawing.DrawOval(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.cube.Facet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.cube.Facet[]
	 */
    public static com.smartgwt.client.widgets.cube.Facet[] arrayOfFacet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.cube.Facet[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.cube.Facet[] ret = new com.smartgwt.client.widgets.cube.Facet[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.cube.Facet(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.cube.Facet[] objects = new com.smartgwt.client.widgets.cube.Facet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.cube.Facet obj = (com.smartgwt.client.widgets.cube.Facet) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.cube.Facet(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.PropertySheet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.PropertySheet[]
	 */
    public static com.smartgwt.client.widgets.form.PropertySheet[] arrayOfPropertySheet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.PropertySheet[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.PropertySheet[] objects = new com.smartgwt.client.widgets.form.PropertySheet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.PropertySheet obj = (com.smartgwt.client.widgets.form.PropertySheet) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.PropertySheet(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LayoutResizeBarPolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LayoutResizeBarPolicy[]
	 */
    public static com.smartgwt.client.types.LayoutResizeBarPolicy[] arrayOfLayoutResizeBarPolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LayoutResizeBarPolicy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LayoutResizeBarPolicy[] objects = new com.smartgwt.client.types.LayoutResizeBarPolicy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LayoutResizeBarPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.LayoutResizeBarPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.State} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.State[]
	 */
    public static com.smartgwt.client.types.State[] arrayOfState(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.State[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.State[] objects = new com.smartgwt.client.types.State[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.State obj = EnumUtil.getEnum(com.smartgwt.client.types.State.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ScriptTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ScriptTask[]
	 */
    public static com.smartgwt.client.util.workflow.ScriptTask[] arrayOfScriptTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ScriptTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ScriptTask[] objects = new com.smartgwt.client.util.workflow.ScriptTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ScriptTask obj = new com.smartgwt.client.util.workflow.ScriptTask(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.TreeMenuButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.TreeMenuButton[]
	 */
    public static com.smartgwt.client.widgets.menu.TreeMenuButton[] arrayOfTreeMenuButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.TreeMenuButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.TreeMenuButton[] objects = new com.smartgwt.client.widgets.menu.TreeMenuButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.TreeMenuButton obj = (com.smartgwt.client.widgets.menu.TreeMenuButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.TreeMenuButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ViewFileItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ViewFileItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ViewFileItem[] arrayOfViewFileItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ViewFileItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ViewFileItem[] objects = new com.smartgwt.client.widgets.form.fields.ViewFileItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ViewFileItem obj = (com.smartgwt.client.widgets.form.fields.ViewFileItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.ViewFileItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.DateGrid} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.DateGrid[]
	 */
    public static com.smartgwt.client.widgets.grid.DateGrid[] arrayOfDateGrid(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.DateGrid[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.DateGrid[] objects = new com.smartgwt.client.widgets.grid.DateGrid[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.DateGrid obj = (com.smartgwt.client.widgets.grid.DateGrid) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.DateGrid(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ImageStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ImageStyle[]
	 */
    public static com.smartgwt.client.types.ImageStyle[] arrayOfImageStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ImageStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ImageStyle[] objects = new com.smartgwt.client.types.ImageStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ImageStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.ImageStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem[] arrayOfAutoFitTextAreaItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem[] objects = new com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem obj = (com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawLinePath} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawLinePath[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawLinePath[] arrayOfDrawLinePath(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawLinePath[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawLinePath[] objects = new com.smartgwt.client.widgets.drawing.DrawLinePath[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawLinePath obj = new com.smartgwt.client.widgets.drawing.DrawLinePath(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ImgButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ImgButton[]
	 */
    public static com.smartgwt.client.widgets.ImgButton[] arrayOfImgButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ImgButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ImgButton[] objects = new com.smartgwt.client.widgets.ImgButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ImgButton obj = (com.smartgwt.client.widgets.ImgButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ImgButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripButton[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripButton[] arrayOfToolStripButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripButton[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripButton obj = (com.smartgwt.client.widgets.toolbar.ToolStripButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStripButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.HiliteRule} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.HiliteRule[]
	 */
    public static com.smartgwt.client.widgets.grid.HiliteRule[] arrayOfHiliteRule(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.HiliteRule[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.HiliteRule[] objects = new com.smartgwt.client.widgets.grid.HiliteRule[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.HiliteRule obj = (com.smartgwt.client.widgets.grid.HiliteRule) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.HiliteRule(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.DateRangeDialog} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.DateRangeDialog[]
	 */
    public static com.smartgwt.client.widgets.DateRangeDialog[] arrayOfDateRangeDialog(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.DateRangeDialog[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.DateRangeDialog[] objects = new com.smartgwt.client.widgets.DateRangeDialog[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.DateRangeDialog obj = (com.smartgwt.client.widgets.DateRangeDialog) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.DateRangeDialog(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.JSONInstanceSerializationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.JSONInstanceSerializationMode[]
	 */
    public static com.smartgwt.client.types.JSONInstanceSerializationMode[] arrayOfJSONInstanceSerializationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.JSONInstanceSerializationMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.JSONInstanceSerializationMode[] objects = new com.smartgwt.client.types.JSONInstanceSerializationMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONInstanceSerializationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONInstanceSerializationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AnimationEffect} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AnimationEffect[]
	 */
    public static com.smartgwt.client.types.AnimationEffect[] arrayOfAnimationEffect(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AnimationEffect[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AnimationEffect[] objects = new com.smartgwt.client.types.AnimationEffect[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AnimationEffect obj = EnumUtil.getEnum(com.smartgwt.client.types.AnimationEffect.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tile.TileRecord} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tile.TileRecord[]
	 */
    public static com.smartgwt.client.widgets.tile.TileRecord[] arrayOfTileRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tile.TileRecord[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.tile.TileRecord[] ret = new com.smartgwt.client.widgets.tile.TileRecord[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.tile.TileRecord(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tile.TileRecord[] objects = new com.smartgwt.client.widgets.tile.TileRecord[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tile.TileRecord obj = (com.smartgwt.client.widgets.tile.TileRecord) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tile.TileRecord(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.FileItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.FileItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.FileItem[] arrayOfFileItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.FileItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.FileItem[] objects = new com.smartgwt.client.widgets.form.fields.FileItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.FileItem obj = (com.smartgwt.client.widgets.form.fields.FileItem) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.FileItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoFitIconFieldType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoFitIconFieldType[]
	 */
    public static com.smartgwt.client.types.AutoFitIconFieldType[] arrayOfAutoFitIconFieldType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoFitIconFieldType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AutoFitIconFieldType[] objects = new com.smartgwt.client.types.AutoFitIconFieldType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitIconFieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitIconFieldType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DSDataFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DSDataFormat[]
	 */
    public static com.smartgwt.client.types.DSDataFormat[] arrayOfDSDataFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DSDataFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DSDataFormat[] objects = new com.smartgwt.client.types.DSDataFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSDataFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DSDataFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.CellSelection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.CellSelection[]
	 */
    public static com.smartgwt.client.widgets.grid.CellSelection[] arrayOfCellSelection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.CellSelection[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.grid.CellSelection[] ret = new com.smartgwt.client.widgets.grid.CellSelection[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.grid.CellSelection(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.CellSelection[] objects = new com.smartgwt.client.widgets.grid.CellSelection[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.CellSelection obj = (com.smartgwt.client.widgets.grid.CellSelection) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.CellSelection(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Canvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Canvas[]
	 */
    public static com.smartgwt.client.widgets.Canvas[] arrayOfCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Canvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Canvas[] objects = new com.smartgwt.client.widgets.Canvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Canvas obj = (com.smartgwt.client.widgets.Canvas) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Canvas(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.plugins.SVG} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.plugins.SVG[]
	 */
    public static com.smartgwt.client.widgets.plugins.SVG[] arrayOfSVG(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.plugins.SVG[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.plugins.SVG[] objects = new com.smartgwt.client.widgets.plugins.SVG[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.plugins.SVG obj = (com.smartgwt.client.widgets.plugins.SVG) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.plugins.SVG(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.Tree} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.Tree[]
	 */
    public static com.smartgwt.client.widgets.tree.Tree[] arrayOfTree(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.Tree[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.Tree[] objects = new com.smartgwt.client.widgets.tree.Tree[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.Tree obj = new com.smartgwt.client.widgets.tree.Tree(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SQLPagingStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SQLPagingStrategy[]
	 */
    public static com.smartgwt.client.types.SQLPagingStrategy[] arrayOfSQLPagingStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SQLPagingStrategy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SQLPagingStrategy[] objects = new com.smartgwt.client.types.SQLPagingStrategy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SQLPagingStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.SQLPagingStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.RowSpacerItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.RowSpacerItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.RowSpacerItem[] arrayOfRowSpacerItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.RowSpacerItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.RowSpacerItem[] objects = new com.smartgwt.client.widgets.form.fields.RowSpacerItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.RowSpacerItem obj = (com.smartgwt.client.widgets.form.fields.RowSpacerItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.RowSpacerItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RowSpanSelectionMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RowSpanSelectionMode[]
	 */
    public static com.smartgwt.client.types.RowSpanSelectionMode[] arrayOfRowSpanSelectionMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RowSpanSelectionMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RowSpanSelectionMode[] objects = new com.smartgwt.client.types.RowSpanSelectionMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowSpanSelectionMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RowSpanSelectionMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.ResultTree} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.ResultTree[]
	 */
    public static com.smartgwt.client.widgets.tree.ResultTree[] arrayOfResultTree(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.ResultTree[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.ResultTree[] objects = new com.smartgwt.client.widgets.tree.ResultTree[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.ResultTree obj = new com.smartgwt.client.widgets.tree.ResultTree(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ImgProperties} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ImgProperties[]
	 */
    public static com.smartgwt.client.widgets.ImgProperties[] arrayOfImgProperties(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ImgProperties[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.ImgProperties[] ret = new com.smartgwt.client.widgets.ImgProperties[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.ImgProperties(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ImgProperties[] objects = new com.smartgwt.client.widgets.ImgProperties[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ImgProperties obj = (com.smartgwt.client.widgets.ImgProperties) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ImgProperties(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.MultiComboBoxItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.MultiComboBoxItem[] arrayOfMultiComboBoxItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.MultiComboBoxItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.MultiComboBoxItem[] objects = new com.smartgwt.client.widgets.form.fields.MultiComboBoxItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.MultiComboBoxItem obj = (com.smartgwt.client.widgets.form.fields.MultiComboBoxItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.MultiComboBoxItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.XORGateway} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.XORGateway[]
	 */
    public static com.smartgwt.client.util.workflow.XORGateway[] arrayOfXORGateway(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.XORGateway[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.XORGateway[] objects = new com.smartgwt.client.util.workflow.XORGateway[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.XORGateway obj = new com.smartgwt.client.util.workflow.XORGateway(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.CanvasItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.CanvasItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.CanvasItem[] arrayOfCanvasItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.CanvasItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.CanvasItem[] objects = new com.smartgwt.client.widgets.form.fields.CanvasItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.CanvasItem obj = (com.smartgwt.client.widgets.form.fields.CanvasItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.CanvasItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.HeaderItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.HeaderItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.HeaderItem[] arrayOfHeaderItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.HeaderItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.HeaderItem[] objects = new com.smartgwt.client.widgets.form.fields.HeaderItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.HeaderItem obj = (com.smartgwt.client.widgets.form.fields.HeaderItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.HeaderItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ExpansionMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ExpansionMode[]
	 */
    public static com.smartgwt.client.types.ExpansionMode[] arrayOfExpansionMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ExpansionMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ExpansionMode[] objects = new com.smartgwt.client.types.ExpansionMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExpansionMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ExpansionMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.ListGridRecord} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.ListGridRecord[]
	 */
    public static com.smartgwt.client.widgets.grid.ListGridRecord[] arrayOfListGridRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.ListGridRecord[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.grid.ListGridRecord[] ret = new com.smartgwt.client.widgets.grid.ListGridRecord[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.grid.ListGridRecord(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.ListGridRecord[] objects = new com.smartgwt.client.widgets.grid.ListGridRecord[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.ListGridRecord obj = (com.smartgwt.client.widgets.grid.ListGridRecord) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.ListGridRecord(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Overflow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Overflow[]
	 */
    public static com.smartgwt.client.types.Overflow[] arrayOfOverflow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Overflow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Overflow[] objects = new com.smartgwt.client.types.Overflow[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Overflow obj = EnumUtil.getEnum(com.smartgwt.client.types.Overflow.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.MenuBar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.MenuBar[]
	 */
    public static com.smartgwt.client.widgets.menu.MenuBar[] arrayOfMenuBar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.MenuBar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.MenuBar[] objects = new com.smartgwt.client.widgets.menu.MenuBar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.MenuBar obj = (com.smartgwt.client.widgets.menu.MenuBar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.MenuBar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Scrollbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Scrollbar[]
	 */
    public static com.smartgwt.client.widgets.Scrollbar[] arrayOfScrollbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Scrollbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Scrollbar[] objects = new com.smartgwt.client.widgets.Scrollbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Scrollbar obj = (com.smartgwt.client.widgets.Scrollbar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Scrollbar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.BatchUploader} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.BatchUploader[]
	 */
    public static com.smartgwt.client.widgets.BatchUploader[] arrayOfBatchUploader(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.BatchUploader[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.BatchUploader[] objects = new com.smartgwt.client.widgets.BatchUploader[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.BatchUploader obj = (com.smartgwt.client.widgets.BatchUploader) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.BatchUploader(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.DateRangeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.DateRangeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.DateRangeItem[] arrayOfDateRangeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.DateRangeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.DateRangeItem[] objects = new com.smartgwt.client.widgets.form.fields.DateRangeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.DateRangeItem obj = (com.smartgwt.client.widgets.form.fields.DateRangeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.DateRangeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.RadialGradient} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.RadialGradient[]
	 */
    public static com.smartgwt.client.widgets.drawing.RadialGradient[] arrayOfRadialGradient(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.RadialGradient[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.RadialGradient[] ret = new com.smartgwt.client.widgets.drawing.RadialGradient[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.RadialGradient(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.RadialGradient[] objects = new com.smartgwt.client.widgets.drawing.RadialGradient[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.RadialGradient obj = (com.smartgwt.client.widgets.drawing.RadialGradient) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.RadialGradient(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.CriteriaCombineOperator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.CriteriaCombineOperator[]
	 */
    public static com.smartgwt.client.types.CriteriaCombineOperator[] arrayOfCriteriaCombineOperator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.CriteriaCombineOperator[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.CriteriaCombineOperator[] objects = new com.smartgwt.client.types.CriteriaCombineOperator[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CriteriaCombineOperator obj = EnumUtil.getEnum(com.smartgwt.client.types.CriteriaCombineOperator.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ListGridEditEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListGridEditEvent[]
	 */
    public static com.smartgwt.client.types.ListGridEditEvent[] arrayOfListGridEditEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListGridEditEvent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ListGridEditEvent[] objects = new com.smartgwt.client.types.ListGridEditEvent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridEditEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridEditEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FieldType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FieldType[]
	 */
    public static com.smartgwt.client.types.FieldType[] arrayOfFieldType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FieldType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FieldType[] objects = new com.smartgwt.client.types.FieldType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ExportImageFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ExportImageFormat[]
	 */
    public static com.smartgwt.client.types.ExportImageFormat[] arrayOfExportImageFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ExportImageFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ExportImageFormat[] objects = new com.smartgwt.client.types.ExportImageFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportImageFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportImageFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DisplayNodeType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DisplayNodeType[]
	 */
    public static com.smartgwt.client.types.DisplayNodeType[] arrayOfDisplayNodeType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DisplayNodeType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DisplayNodeType[] objects = new com.smartgwt.client.types.DisplayNodeType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DisplayNodeType obj = EnumUtil.getEnum(com.smartgwt.client.types.DisplayNodeType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tile.TileLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tile.TileLayout[]
	 */
    public static com.smartgwt.client.widgets.tile.TileLayout[] arrayOfTileLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tile.TileLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tile.TileLayout[] objects = new com.smartgwt.client.widgets.tile.TileLayout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tile.TileLayout obj = (com.smartgwt.client.widgets.tile.TileLayout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tile.TileLayout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.validator.Validator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.validator.Validator[]
	 */
    public static com.smartgwt.client.widgets.form.validator.Validator[] arrayOfValidator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.validator.Validator[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.form.validator.Validator[] ret = new com.smartgwt.client.widgets.form.validator.Validator[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.form.validator.Validator(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.validator.Validator[] objects = new com.smartgwt.client.widgets.form.validator.Validator[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.validator.Validator obj = (com.smartgwt.client.widgets.form.validator.Validator) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.validator.Validator(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FormMethod} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FormMethod[]
	 */
    public static com.smartgwt.client.types.FormMethod[] arrayOfFormMethod(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FormMethod[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FormMethod[] objects = new com.smartgwt.client.types.FormMethod[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FormMethod obj = EnumUtil.getEnum(com.smartgwt.client.types.FormMethod.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Slider} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Slider[]
	 */
    public static com.smartgwt.client.widgets.Slider[] arrayOfSlider(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Slider[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Slider[] objects = new com.smartgwt.client.widgets.Slider[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Slider obj = (com.smartgwt.client.widgets.Slider) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Slider(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FiscalYearMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FiscalYearMode[]
	 */
    public static com.smartgwt.client.types.FiscalYearMode[] arrayOfFiscalYearMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FiscalYearMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FiscalYearMode[] objects = new com.smartgwt.client.types.FiscalYearMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FiscalYearMode obj = EnumUtil.getEnum(com.smartgwt.client.types.FiscalYearMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.Point} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.Point[]
	 */
    public static com.smartgwt.client.widgets.drawing.Point[] arrayOfPoint(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.Point[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.Point[] ret = new com.smartgwt.client.widgets.drawing.Point[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.Point(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.Point[] objects = new com.smartgwt.client.widgets.drawing.Point[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.Point obj = (com.smartgwt.client.widgets.drawing.Point) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.Point(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.Record} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.Record[]
	 */
    public static com.smartgwt.client.data.Record[] arrayOfRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.Record[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.Record[] ret = new com.smartgwt.client.data.Record[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.Record(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.Record[] objects = new com.smartgwt.client.data.Record[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.Record obj = (com.smartgwt.client.data.Record) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.Record(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Progressbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Progressbar[]
	 */
    public static com.smartgwt.client.widgets.Progressbar[] arrayOfProgressbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Progressbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Progressbar[] objects = new com.smartgwt.client.widgets.Progressbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Progressbar obj = (com.smartgwt.client.widgets.Progressbar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Progressbar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.TextItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.TextItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.TextItem[] arrayOfTextItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.TextItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.TextItem[] objects = new com.smartgwt.client.widgets.form.fields.TextItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.TextItem obj = (com.smartgwt.client.widgets.form.fields.TextItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.TextItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TitleOrientation} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TitleOrientation[]
	 */
    public static com.smartgwt.client.types.TitleOrientation[] arrayOfTitleOrientation(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TitleOrientation[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TitleOrientation[] objects = new com.smartgwt.client.types.TitleOrientation[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TitleOrientation obj = EnumUtil.getEnum(com.smartgwt.client.types.TitleOrientation.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Orientation} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Orientation[]
	 */
    public static com.smartgwt.client.types.Orientation[] arrayOfOrientation(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Orientation[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Orientation[] objects = new com.smartgwt.client.types.Orientation[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Orientation obj = EnumUtil.getEnum(com.smartgwt.client.types.Orientation.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.viewer.DetailViewer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.viewer.DetailViewer[]
	 */
    public static com.smartgwt.client.widgets.viewer.DetailViewer[] arrayOfDetailViewer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.viewer.DetailViewer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.viewer.DetailViewer[] objects = new com.smartgwt.client.widgets.viewer.DetailViewer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.viewer.DetailViewer obj = (com.smartgwt.client.widgets.viewer.DetailViewer) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.viewer.DetailViewer(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.FilterClause} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.FilterClause[]
	 */
    public static com.smartgwt.client.widgets.form.FilterClause[] arrayOfFilterClause(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.FilterClause[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.FilterClause[] objects = new com.smartgwt.client.widgets.form.FilterClause[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.FilterClause obj = (com.smartgwt.client.widgets.form.FilterClause) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.FilterClause(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.plugins.Flashlet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.plugins.Flashlet[]
	 */
    public static com.smartgwt.client.widgets.plugins.Flashlet[] arrayOfFlashlet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.plugins.Flashlet[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.plugins.Flashlet[] objects = new com.smartgwt.client.widgets.plugins.Flashlet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.plugins.Flashlet obj = (com.smartgwt.client.widgets.plugins.Flashlet) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.plugins.Flashlet(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.UserFormula} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.UserFormula[]
	 */
    public static com.smartgwt.client.widgets.UserFormula[] arrayOfUserFormula(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.UserFormula[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.UserFormula[] ret = new com.smartgwt.client.widgets.UserFormula[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.UserFormula(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.UserFormula[] objects = new com.smartgwt.client.widgets.UserFormula[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.UserFormula obj = (com.smartgwt.client.widgets.UserFormula) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.UserFormula(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.SectionHeader} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.SectionHeader[]
	 */
    public static com.smartgwt.client.widgets.layout.SectionHeader[] arrayOfSectionHeader(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.SectionHeader[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.SectionHeader[] objects = new com.smartgwt.client.widgets.layout.SectionHeader[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.SectionHeader obj = (com.smartgwt.client.widgets.layout.SectionHeader) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.SectionHeader(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RelativeDateRangePosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RelativeDateRangePosition[]
	 */
    public static com.smartgwt.client.types.RelativeDateRangePosition[] arrayOfRelativeDateRangePosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RelativeDateRangePosition[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RelativeDateRangePosition[] objects = new com.smartgwt.client.types.RelativeDateRangePosition[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RelativeDateRangePosition obj = EnumUtil.getEnum(com.smartgwt.client.types.RelativeDateRangePosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStrip} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStrip[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStrip[] arrayOfToolStrip(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStrip[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStrip[] objects = new com.smartgwt.client.widgets.toolbar.ToolStrip[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStrip obj = (com.smartgwt.client.widgets.toolbar.ToolStrip) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStrip(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.RibbonGroup} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.RibbonGroup[]
	 */
    public static com.smartgwt.client.widgets.toolbar.RibbonGroup[] arrayOfRibbonGroup(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.RibbonGroup[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.RibbonGroup[] objects = new com.smartgwt.client.widgets.toolbar.RibbonGroup[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.RibbonGroup obj = (com.smartgwt.client.widgets.toolbar.RibbonGroup) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.RibbonGroup(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.Task} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.Task[]
	 */
    public static com.smartgwt.client.util.workflow.Task[] arrayOfTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.Task[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.Task[] objects = new com.smartgwt.client.util.workflow.Task[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.Task obj = new com.smartgwt.client.util.workflow.Task(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.Hilite} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.Hilite[]
	 */
    public static com.smartgwt.client.data.Hilite[] arrayOfHilite(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.Hilite[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.Hilite[] ret = new com.smartgwt.client.data.Hilite[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.Hilite(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.Hilite[] objects = new com.smartgwt.client.data.Hilite[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.Hilite obj = (com.smartgwt.client.data.Hilite) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.Hilite(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ViewLoader} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ViewLoader[]
	 */
    public static com.smartgwt.client.widgets.ViewLoader[] arrayOfViewLoader(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ViewLoader[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ViewLoader[] objects = new com.smartgwt.client.widgets.ViewLoader[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ViewLoader obj = (com.smartgwt.client.widgets.ViewLoader) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ViewLoader(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LogPriority} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LogPriority[]
	 */
    public static com.smartgwt.client.types.LogPriority[] arrayOfLogPriority(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LogPriority[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LogPriority[] objects = new com.smartgwt.client.types.LogPriority[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LogPriority obj = EnumUtil.getEnum(com.smartgwt.client.types.LogPriority.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.PasswordItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.PasswordItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.PasswordItem[] arrayOfPasswordItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.PasswordItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.PasswordItem[] objects = new com.smartgwt.client.widgets.form.fields.PasswordItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.PasswordItem obj = (com.smartgwt.client.widgets.form.fields.PasswordItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.PasswordItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.StaticTextItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.StaticTextItem[] arrayOfStaticTextItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.StaticTextItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.StaticTextItem[] objects = new com.smartgwt.client.widgets.form.fields.StaticTextItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.StaticTextItem obj = (com.smartgwt.client.widgets.form.fields.StaticTextItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.StaticTextItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawRect} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawRect[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawRect[] arrayOfDrawRect(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawRect[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawRect[] objects = new com.smartgwt.client.widgets.drawing.DrawRect[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawRect obj = new com.smartgwt.client.widgets.drawing.DrawRect(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.UserTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.UserTask[]
	 */
    public static com.smartgwt.client.util.workflow.UserTask[] arrayOfUserTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.UserTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.UserTask[] objects = new com.smartgwt.client.util.workflow.UserTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.UserTask obj = new com.smartgwt.client.util.workflow.UserTask(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MultiGroupDialog} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MultiGroupDialog[]
	 */
    public static com.smartgwt.client.widgets.MultiGroupDialog[] arrayOfMultiGroupDialog(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MultiGroupDialog[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MultiGroupDialog[] objects = new com.smartgwt.client.widgets.MultiGroupDialog[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MultiGroupDialog obj = (com.smartgwt.client.widgets.MultiGroupDialog) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.MultiGroupDialog(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Visibility} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Visibility[]
	 */
    public static com.smartgwt.client.types.Visibility[] arrayOfVisibility(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Visibility[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Visibility[] objects = new com.smartgwt.client.types.Visibility[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Visibility obj = EnumUtil.getEnum(com.smartgwt.client.types.Visibility.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.FlowLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.FlowLayout[]
	 */
    public static com.smartgwt.client.widgets.layout.FlowLayout[] arrayOfFlowLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.FlowLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.FlowLayout[] objects = new com.smartgwt.client.widgets.layout.FlowLayout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.FlowLayout obj = (com.smartgwt.client.widgets.layout.FlowLayout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.FlowLayout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawPolygon} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawPolygon[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawPolygon[] arrayOfDrawPolygon(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawPolygon[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawPolygon[] objects = new com.smartgwt.client.widgets.drawing.DrawPolygon[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawPolygon obj = new com.smartgwt.client.widgets.drawing.DrawPolygon(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ForceTextApproach} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ForceTextApproach[]
	 */
    public static com.smartgwt.client.types.ForceTextApproach[] arrayOfForceTextApproach(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ForceTextApproach[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ForceTextApproach[] objects = new com.smartgwt.client.types.ForceTextApproach[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ForceTextApproach obj = EnumUtil.getEnum(com.smartgwt.client.types.ForceTextApproach.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.Gauge} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.Gauge[]
	 */
    public static com.smartgwt.client.widgets.drawing.Gauge[] arrayOfGauge(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.Gauge[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.Gauge[] objects = new com.smartgwt.client.widgets.drawing.Gauge[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.Gauge obj = (com.smartgwt.client.widgets.drawing.Gauge) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.Gauge(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.AdvancedHiliteEditor[]
	 */
    public static com.smartgwt.client.widgets.grid.AdvancedHiliteEditor[] arrayOfAdvancedHiliteEditor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.AdvancedHiliteEditor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.AdvancedHiliteEditor[] objects = new com.smartgwt.client.widgets.grid.AdvancedHiliteEditor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.AdvancedHiliteEditor obj = (com.smartgwt.client.widgets.grid.AdvancedHiliteEditor) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.AdvancedHiliteEditor(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.SectionStackSection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.SectionStackSection[]
	 */
    public static com.smartgwt.client.widgets.layout.SectionStackSection[] arrayOfSectionStackSection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.SectionStackSection[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.layout.SectionStackSection[] ret = new com.smartgwt.client.widgets.layout.SectionStackSection[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.layout.SectionStackSection(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.SectionStackSection[] objects = new com.smartgwt.client.widgets.layout.SectionStackSection[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.SectionStackSection obj = (com.smartgwt.client.widgets.layout.SectionStackSection) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.SectionStackSection(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Button} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Button[]
	 */
    public static com.smartgwt.client.widgets.Button[] arrayOfButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Button[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Button[] objects = new com.smartgwt.client.widgets.Button[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Button obj = (com.smartgwt.client.widgets.Button) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Button(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EnumTranslateStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EnumTranslateStrategy[]
	 */
    public static com.smartgwt.client.types.EnumTranslateStrategy[] arrayOfEnumTranslateStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EnumTranslateStrategy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EnumTranslateStrategy[] objects = new com.smartgwt.client.types.EnumTranslateStrategy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EnumTranslateStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.EnumTranslateStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EdgeName} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EdgeName[]
	 */
    public static com.smartgwt.client.types.EdgeName[] arrayOfEdgeName(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EdgeName[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EdgeName[] objects = new com.smartgwt.client.types.EdgeName[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EdgeName obj = EnumUtil.getEnum(com.smartgwt.client.types.EdgeName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.HeaderSpan} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.HeaderSpan[]
	 */
    public static com.smartgwt.client.widgets.grid.HeaderSpan[] arrayOfHeaderSpan(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.HeaderSpan[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.grid.HeaderSpan[] ret = new com.smartgwt.client.widgets.grid.HeaderSpan[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.grid.HeaderSpan(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.HeaderSpan[] objects = new com.smartgwt.client.widgets.grid.HeaderSpan[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.HeaderSpan obj = (com.smartgwt.client.widgets.grid.HeaderSpan) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.HeaderSpan(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TreeFilterMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TreeFilterMode[]
	 */
    public static com.smartgwt.client.types.TreeFilterMode[] arrayOfTreeFilterMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TreeFilterMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TreeFilterMode[] objects = new com.smartgwt.client.types.TreeFilterMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TreeFilterMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TreeFilterMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.Calendar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.Calendar[]
	 */
    public static com.smartgwt.client.widgets.calendar.Calendar[] arrayOfCalendar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.Calendar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.Calendar[] objects = new com.smartgwt.client.widgets.calendar.Calendar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.Calendar obj = (com.smartgwt.client.widgets.calendar.Calendar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.Calendar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.PrintProperties} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.PrintProperties[]
	 */
    public static com.smartgwt.client.util.PrintProperties[] arrayOfPrintProperties(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.PrintProperties[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.util.PrintProperties[] ret = new com.smartgwt.client.util.PrintProperties[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.util.PrintProperties(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.PrintProperties[] objects = new com.smartgwt.client.util.PrintProperties[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.PrintProperties obj = (com.smartgwt.client.util.PrintProperties) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.PrintProperties(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectionType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectionType[]
	 */
    public static com.smartgwt.client.types.SelectionType[] arrayOfSelectionType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectionType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SelectionType[] objects = new com.smartgwt.client.types.SelectionType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionType obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Snapbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Snapbar[]
	 */
    public static com.smartgwt.client.widgets.Snapbar[] arrayOfSnapbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Snapbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Snapbar[] objects = new com.smartgwt.client.widgets.Snapbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Snapbar obj = (com.smartgwt.client.widgets.Snapbar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Snapbar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TileLayoutPolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TileLayoutPolicy[]
	 */
    public static com.smartgwt.client.types.TileLayoutPolicy[] arrayOfTileLayoutPolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TileLayoutPolicy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TileLayoutPolicy[] objects = new com.smartgwt.client.types.TileLayoutPolicy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TileLayoutPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.TileLayoutPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawPane[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawPane[] arrayOfDrawPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawPane[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawPane[] objects = new com.smartgwt.client.widgets.drawing.DrawPane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawPane obj = (com.smartgwt.client.widgets.drawing.DrawPane) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.DrawPane(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EmbeddedPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EmbeddedPosition[]
	 */
    public static com.smartgwt.client.types.EmbeddedPosition[] arrayOfEmbeddedPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EmbeddedPosition[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EmbeddedPosition[] objects = new com.smartgwt.client.types.EmbeddedPosition[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EmbeddedPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.EmbeddedPosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.DSResponse} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.DSResponse[]
	 */
    public static com.smartgwt.client.data.DSResponse[] arrayOfDSResponse(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.DSResponse[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.DSResponse[] ret = new com.smartgwt.client.data.DSResponse[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.DSResponse(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.DSResponse[] objects = new com.smartgwt.client.data.DSResponse[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.DSResponse obj = (com.smartgwt.client.data.DSResponse) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.DSResponse(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.FilterBuilder} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.FilterBuilder[]
	 */
    public static com.smartgwt.client.widgets.form.FilterBuilder[] arrayOfFilterBuilder(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.FilterBuilder[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.FilterBuilder[] objects = new com.smartgwt.client.widgets.form.FilterBuilder[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.FilterBuilder obj = (com.smartgwt.client.widgets.form.FilterBuilder) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.FilterBuilder(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawSector} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawSector[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawSector[] arrayOfDrawSector(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawSector[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawSector[] objects = new com.smartgwt.client.widgets.drawing.DrawSector[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawSector obj = new com.smartgwt.client.widgets.drawing.DrawSector(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Encoding} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Encoding[]
	 */
    public static com.smartgwt.client.types.Encoding[] arrayOfEncoding(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Encoding[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Encoding[] objects = new com.smartgwt.client.types.Encoding[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Encoding obj = EnumUtil.getEnum(com.smartgwt.client.types.Encoding.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.OperatorId} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.OperatorId[]
	 */
    public static com.smartgwt.client.types.OperatorId[] arrayOfOperatorId(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.OperatorId[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.OperatorId[] objects = new com.smartgwt.client.types.OperatorId[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.OperatorId obj = EnumUtil.getEnum(com.smartgwt.client.types.OperatorId.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawPath} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawPath[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawPath[] arrayOfDrawPath(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawPath[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawPath[] objects = new com.smartgwt.client.widgets.drawing.DrawPath[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawPath obj = new com.smartgwt.client.widgets.drawing.DrawPath(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.TreeGridField} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.TreeGridField[]
	 */
    public static com.smartgwt.client.widgets.tree.TreeGridField[] arrayOfTreeGridField(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.TreeGridField[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.tree.TreeGridField[] ret = new com.smartgwt.client.widgets.tree.TreeGridField[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.tree.TreeGridField(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.TreeGridField[] objects = new com.smartgwt.client.widgets.tree.TreeGridField[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.TreeGridField obj = (com.smartgwt.client.widgets.tree.TreeGridField) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.TreeGridField(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.GaugeSector} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.GaugeSector[]
	 */
    public static com.smartgwt.client.widgets.drawing.GaugeSector[] arrayOfGaugeSector(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.GaugeSector[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.GaugeSector[] ret = new com.smartgwt.client.widgets.drawing.GaugeSector[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.GaugeSector(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.GaugeSector[] objects = new com.smartgwt.client.widgets.drawing.GaugeSector[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.GaugeSector obj = (com.smartgwt.client.widgets.drawing.GaugeSector) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.GaugeSector(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ListGridFieldType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListGridFieldType[]
	 */
    public static com.smartgwt.client.types.ListGridFieldType[] arrayOfListGridFieldType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListGridFieldType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ListGridFieldType[] objects = new com.smartgwt.client.types.ListGridFieldType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridFieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridFieldType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.chart.DrawnValue} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.chart.DrawnValue[]
	 */
    public static com.smartgwt.client.widgets.chart.DrawnValue[] arrayOfDrawnValue(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.chart.DrawnValue[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.chart.DrawnValue[] ret = new com.smartgwt.client.widgets.chart.DrawnValue[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.chart.DrawnValue(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.chart.DrawnValue[] objects = new com.smartgwt.client.widgets.chart.DrawnValue[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.chart.DrawnValue obj = (com.smartgwt.client.widgets.chart.DrawnValue) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.chart.DrawnValue(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Autofit} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Autofit[]
	 */
    public static com.smartgwt.client.types.Autofit[] arrayOfAutofit(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Autofit[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Autofit[] objects = new com.smartgwt.client.types.Autofit[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Autofit obj = EnumUtil.getEnum(com.smartgwt.client.types.Autofit.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.chart.MetricSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.chart.MetricSettings[]
	 */
    public static com.smartgwt.client.widgets.chart.MetricSettings[] arrayOfMetricSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.chart.MetricSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.chart.MetricSettings[] ret = new com.smartgwt.client.widgets.chart.MetricSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.chart.MetricSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.chart.MetricSettings[] objects = new com.smartgwt.client.widgets.chart.MetricSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.chart.MetricSettings obj = (com.smartgwt.client.widgets.chart.MetricSettings) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.chart.MetricSettings(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ImgSplitbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ImgSplitbar[]
	 */
    public static com.smartgwt.client.widgets.ImgSplitbar[] arrayOfImgSplitbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ImgSplitbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ImgSplitbar[] objects = new com.smartgwt.client.widgets.ImgSplitbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ImgSplitbar obj = (com.smartgwt.client.widgets.ImgSplitbar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ImgSplitbar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Selected} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Selected[]
	 */
    public static com.smartgwt.client.types.Selected[] arrayOfSelected(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Selected[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Selected[] objects = new com.smartgwt.client.types.Selected[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Selected obj = EnumUtil.getEnum(com.smartgwt.client.types.Selected.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ComboBoxItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ComboBoxItem[] arrayOfComboBoxItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ComboBoxItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ComboBoxItem[] objects = new com.smartgwt.client.widgets.form.fields.ComboBoxItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ComboBoxItem obj = (com.smartgwt.client.widgets.form.fields.ComboBoxItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.ComboBoxItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ControlName} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ControlName[]
	 */
    public static com.smartgwt.client.types.ControlName[] arrayOfControlName(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ControlName[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ControlName[] objects = new com.smartgwt.client.types.ControlName[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ControlName obj = EnumUtil.getEnum(com.smartgwt.client.types.ControlName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.LayoutSpacer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.LayoutSpacer[]
	 */
    public static com.smartgwt.client.widgets.layout.LayoutSpacer[] arrayOfLayoutSpacer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.LayoutSpacer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.LayoutSpacer[] objects = new com.smartgwt.client.widgets.layout.LayoutSpacer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.LayoutSpacer obj = (com.smartgwt.client.widgets.layout.LayoutSpacer) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.LayoutSpacer(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tile.SimpleTile} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tile.SimpleTile[]
	 */
    public static com.smartgwt.client.widgets.tile.SimpleTile[] arrayOfSimpleTile(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tile.SimpleTile[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tile.SimpleTile[] objects = new com.smartgwt.client.widgets.tile.SimpleTile[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tile.SimpleTile obj = (com.smartgwt.client.widgets.tile.SimpleTile) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tile.SimpleTile(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawLine} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawLine[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawLine[] arrayOfDrawLine(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawLine[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawLine[] objects = new com.smartgwt.client.widgets.drawing.DrawLine[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawLine obj = new com.smartgwt.client.widgets.drawing.DrawLine(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawCurve} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawCurve[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawCurve[] arrayOfDrawCurve(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawCurve[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawCurve[] objects = new com.smartgwt.client.widgets.drawing.DrawCurve[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawCurve obj = new com.smartgwt.client.widgets.drawing.DrawCurve(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.HTMLFlow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.HTMLFlow[]
	 */
    public static com.smartgwt.client.widgets.HTMLFlow[] arrayOfHTMLFlow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.HTMLFlow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.HTMLFlow[] objects = new com.smartgwt.client.widgets.HTMLFlow[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.HTMLFlow obj = (com.smartgwt.client.widgets.HTMLFlow) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.HTMLFlow(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RPCTransport} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RPCTransport[]
	 */
    public static com.smartgwt.client.types.RPCTransport[] arrayOfRPCTransport(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RPCTransport[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RPCTransport[] objects = new com.smartgwt.client.types.RPCTransport[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RPCTransport obj = EnumUtil.getEnum(com.smartgwt.client.types.RPCTransport.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.HStack} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.HStack[]
	 */
    public static com.smartgwt.client.widgets.layout.HStack[] arrayOfHStack(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.HStack[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.HStack[] objects = new com.smartgwt.client.widgets.layout.HStack[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.HStack obj = (com.smartgwt.client.widgets.layout.HStack) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.HStack(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ReadOnlyDisplayAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ReadOnlyDisplayAppearance[]
	 */
    public static com.smartgwt.client.types.ReadOnlyDisplayAppearance[] arrayOfReadOnlyDisplayAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ReadOnlyDisplayAppearance[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ReadOnlyDisplayAppearance[] objects = new com.smartgwt.client.types.ReadOnlyDisplayAppearance[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ReadOnlyDisplayAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.ReadOnlyDisplayAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tile.TileGrid} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tile.TileGrid[]
	 */
    public static com.smartgwt.client.widgets.tile.TileGrid[] arrayOfTileGrid(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tile.TileGrid[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tile.TileGrid[] objects = new com.smartgwt.client.widgets.tile.TileGrid[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tile.TileGrid obj = (com.smartgwt.client.widgets.tile.TileGrid) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tile.TileGrid(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.cube.CellRecord} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.cube.CellRecord[]
	 */
    public static com.smartgwt.client.widgets.cube.CellRecord[] arrayOfCellRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.cube.CellRecord[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.cube.CellRecord[] ret = new com.smartgwt.client.widgets.cube.CellRecord[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.cube.CellRecord(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.cube.CellRecord[] objects = new com.smartgwt.client.widgets.cube.CellRecord[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.cube.CellRecord obj = (com.smartgwt.client.widgets.cube.CellRecord) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.cube.CellRecord(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PageEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PageEvent[]
	 */
    public static com.smartgwt.client.types.PageEvent[] arrayOfPageEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PageEvent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PageEvent[] objects = new com.smartgwt.client.types.PageEvent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PageEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.PageEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SortDirection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SortDirection[]
	 */
    public static com.smartgwt.client.types.SortDirection[] arrayOfSortDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SortDirection[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SortDirection[] objects = new com.smartgwt.client.types.SortDirection[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SortDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.SortDirection.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TimeUnit} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TimeUnit[]
	 */
    public static com.smartgwt.client.types.TimeUnit[] arrayOfTimeUnit(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TimeUnit[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TimeUnit[] objects = new com.smartgwt.client.types.TimeUnit[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TimeUnit obj = EnumUtil.getEnum(com.smartgwt.client.types.TimeUnit.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.CalendarEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.CalendarEvent[]
	 */
    public static com.smartgwt.client.widgets.calendar.CalendarEvent[] arrayOfCalendarEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.CalendarEvent[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.calendar.CalendarEvent[] ret = new com.smartgwt.client.widgets.calendar.CalendarEvent[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.calendar.CalendarEvent(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.CalendarEvent[] objects = new com.smartgwt.client.widgets.calendar.CalendarEvent[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.CalendarEvent obj = (com.smartgwt.client.widgets.calendar.CalendarEvent) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.CalendarEvent(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawImage} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawImage[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawImage[] arrayOfDrawImage(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawImage[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawImage[] objects = new com.smartgwt.client.widgets.drawing.DrawImage[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawImage obj = new com.smartgwt.client.widgets.drawing.DrawImage(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SubmitItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SubmitItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SubmitItem[] arrayOfSubmitItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SubmitItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SubmitItem[] objects = new com.smartgwt.client.widgets.form.fields.SubmitItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SubmitItem obj = (com.smartgwt.client.widgets.form.fields.SubmitItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SubmitItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.JSONEncoder} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.JSONEncoder[]
	 */
    public static com.smartgwt.client.util.JSONEncoder[] arrayOfJSONEncoder(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.JSONEncoder[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.util.JSONEncoder[] ret = new com.smartgwt.client.util.JSONEncoder[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.util.JSONEncoder(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.JSONEncoder[] objects = new com.smartgwt.client.util.JSONEncoder[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.JSONEncoder obj = (com.smartgwt.client.util.JSONEncoder) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.JSONEncoder(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SelectItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SelectItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SelectItem[] arrayOfSelectItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SelectItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SelectItem[] objects = new com.smartgwt.client.widgets.form.fields.SelectItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SelectItem obj = (com.smartgwt.client.widgets.form.fields.SelectItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SelectItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.IconMenuButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.IconMenuButton[]
	 */
    public static com.smartgwt.client.widgets.menu.IconMenuButton[] arrayOfIconMenuButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.IconMenuButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.IconMenuButton[] objects = new com.smartgwt.client.widgets.menu.IconMenuButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.IconMenuButton obj = (com.smartgwt.client.widgets.menu.IconMenuButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.IconMenuButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SpacerItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SpacerItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SpacerItem[] arrayOfSpacerItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SpacerItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SpacerItem[] objects = new com.smartgwt.client.widgets.form.fields.SpacerItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SpacerItem obj = (com.smartgwt.client.widgets.form.fields.SpacerItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SpacerItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DateDisplayFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DateDisplayFormat[]
	 */
    public static com.smartgwt.client.types.DateDisplayFormat[] arrayOfDateDisplayFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DateDisplayFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DateDisplayFormat[] objects = new com.smartgwt.client.types.DateDisplayFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateDisplayFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DateDisplayFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectionBoundary} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectionBoundary[]
	 */
    public static com.smartgwt.client.types.SelectionBoundary[] arrayOfSelectionBoundary(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectionBoundary[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SelectionBoundary[] objects = new com.smartgwt.client.types.SelectionBoundary[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionBoundary obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionBoundary.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.RelativeDateItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.RelativeDateItem[] arrayOfRelativeDateItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.RelativeDateItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.RelativeDateItem[] objects = new com.smartgwt.client.widgets.form.fields.RelativeDateItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.RelativeDateItem obj = (com.smartgwt.client.widgets.form.fields.RelativeDateItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.RelativeDateItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Axis} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Axis[]
	 */
    public static com.smartgwt.client.types.Axis[] arrayOfAxis(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Axis[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Axis[] objects = new com.smartgwt.client.types.Axis[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Axis obj = EnumUtil.getEnum(com.smartgwt.client.types.Axis.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.LinkItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.LinkItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.LinkItem[] arrayOfLinkItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.LinkItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.LinkItem[] objects = new com.smartgwt.client.widgets.form.fields.LinkItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.LinkItem obj = (com.smartgwt.client.widgets.form.fields.LinkItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.LinkItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoFitEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoFitEvent[]
	 */
    public static com.smartgwt.client.types.AutoFitEvent[] arrayOfAutoFitEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoFitEvent[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AutoFitEvent[] objects = new com.smartgwt.client.types.AutoFitEvent[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.TimeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.TimeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.TimeItem[] arrayOfTimeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.TimeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.TimeItem[] objects = new com.smartgwt.client.widgets.form.fields.TimeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.TimeItem obj = (com.smartgwt.client.widgets.form.fields.TimeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.TimeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.ColumnTree} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.ColumnTree[]
	 */
    public static com.smartgwt.client.widgets.grid.ColumnTree[] arrayOfColumnTree(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.ColumnTree[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.ColumnTree[] objects = new com.smartgwt.client.widgets.grid.ColumnTree[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.ColumnTree obj = (com.smartgwt.client.widgets.grid.ColumnTree) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.ColumnTree(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DateEditingStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DateEditingStyle[]
	 */
    public static com.smartgwt.client.types.DateEditingStyle[] arrayOfDateEditingStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DateEditingStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DateEditingStyle[] objects = new com.smartgwt.client.types.DateEditingStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateEditingStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.DateEditingStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.plugins.ActiveXControl} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.plugins.ActiveXControl[]
	 */
    public static com.smartgwt.client.widgets.plugins.ActiveXControl[] arrayOfActiveXControl(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.plugins.ActiveXControl[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.plugins.ActiveXControl[] objects = new com.smartgwt.client.widgets.plugins.ActiveXControl[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.plugins.ActiveXControl obj = (com.smartgwt.client.widgets.plugins.ActiveXControl) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.plugins.ActiveXControl(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.NavigationBar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.NavigationBar[]
	 */
    public static com.smartgwt.client.widgets.layout.NavigationBar[] arrayOfNavigationBar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.NavigationBar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.NavigationBar[] objects = new com.smartgwt.client.widgets.layout.NavigationBar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.NavigationBar obj = (com.smartgwt.client.widgets.layout.NavigationBar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.NavigationBar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FetchMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FetchMode[]
	 */
    public static com.smartgwt.client.types.FetchMode[] arrayOfFetchMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FetchMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FetchMode[] objects = new com.smartgwt.client.types.FetchMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FetchMode obj = EnumUtil.getEnum(com.smartgwt.client.types.FetchMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DragTrackerMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DragTrackerMode[]
	 */
    public static com.smartgwt.client.types.DragTrackerMode[] arrayOfDragTrackerMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DragTrackerMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DragTrackerMode[] objects = new com.smartgwt.client.types.DragTrackerMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragTrackerMode obj = EnumUtil.getEnum(com.smartgwt.client.types.DragTrackerMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ZoomStartPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ZoomStartPosition[]
	 */
    public static com.smartgwt.client.types.ZoomStartPosition[] arrayOfZoomStartPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ZoomStartPosition[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ZoomStartPosition[] objects = new com.smartgwt.client.types.ZoomStartPosition[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ZoomStartPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.ZoomStartPosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.HLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.HLayout[]
	 */
    public static com.smartgwt.client.widgets.layout.HLayout[] arrayOfHLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.HLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.HLayout[] objects = new com.smartgwt.client.widgets.layout.HLayout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.HLayout obj = (com.smartgwt.client.widgets.layout.HLayout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.HLayout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.viewer.DetailViewerRecord} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.viewer.DetailViewerRecord[]
	 */
    public static com.smartgwt.client.widgets.viewer.DetailViewerRecord[] arrayOfDetailViewerRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.viewer.DetailViewerRecord[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.viewer.DetailViewerRecord[] ret = new com.smartgwt.client.widgets.viewer.DetailViewerRecord[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.viewer.DetailViewerRecord(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.viewer.DetailViewerRecord[] objects = new com.smartgwt.client.widgets.viewer.DetailViewerRecord[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.viewer.DetailViewerRecord obj = (com.smartgwt.client.widgets.viewer.DetailViewerRecord) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.viewer.DetailViewerRecord(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.SimpleGradient} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.SimpleGradient[]
	 */
    public static com.smartgwt.client.widgets.drawing.SimpleGradient[] arrayOfSimpleGradient(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.SimpleGradient[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.SimpleGradient[] ret = new com.smartgwt.client.widgets.drawing.SimpleGradient[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.SimpleGradient(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.SimpleGradient[] objects = new com.smartgwt.client.widgets.drawing.SimpleGradient[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.SimpleGradient obj = (com.smartgwt.client.widgets.drawing.SimpleGradient) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.SimpleGradient(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectionStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectionStyle[]
	 */
    public static com.smartgwt.client.types.SelectionStyle[] arrayOfSelectionStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectionStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SelectionStyle[] objects = new com.smartgwt.client.types.SelectionStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LabelRotationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LabelRotationMode[]
	 */
    public static com.smartgwt.client.types.LabelRotationMode[] arrayOfLabelRotationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LabelRotationMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LabelRotationMode[] objects = new com.smartgwt.client.types.LabelRotationMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LabelRotationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.LabelRotationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TextMatchStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TextMatchStyle[]
	 */
    public static com.smartgwt.client.types.TextMatchStyle[] arrayOfTextMatchStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TextMatchStyle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TextMatchStyle[] objects = new com.smartgwt.client.types.TextMatchStyle[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TextMatchStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.TextMatchStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PercentBoxModel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PercentBoxModel[]
	 */
    public static com.smartgwt.client.types.PercentBoxModel[] arrayOfPercentBoxModel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PercentBoxModel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PercentBoxModel[] objects = new com.smartgwt.client.types.PercentBoxModel[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PercentBoxModel obj = EnumUtil.getEnum(com.smartgwt.client.types.PercentBoxModel.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.TreeNode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.TreeNode[]
	 */
    public static com.smartgwt.client.widgets.tree.TreeNode[] arrayOfTreeNode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.TreeNode[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.tree.TreeNode[] ret = new com.smartgwt.client.widgets.tree.TreeNode[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.tree.TreeNode(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.TreeNode[] objects = new com.smartgwt.client.widgets.tree.TreeNode[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.TreeNode obj = (com.smartgwt.client.widgets.tree.TreeNode) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.TreeNode(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.chart.FacetChart} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.chart.FacetChart[]
	 */
    public static com.smartgwt.client.widgets.chart.FacetChart[] arrayOfFacetChart(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.chart.FacetChart[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.chart.FacetChart[] objects = new com.smartgwt.client.widgets.chart.FacetChart[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.chart.FacetChart obj = (com.smartgwt.client.widgets.chart.FacetChart) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.chart.FacetChart(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.HoverMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.HoverMode[]
	 */
    public static com.smartgwt.client.types.HoverMode[] arrayOfHoverMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.HoverMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.HoverMode[] objects = new com.smartgwt.client.types.HoverMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HoverMode obj = EnumUtil.getEnum(com.smartgwt.client.types.HoverMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ExportDisplay} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ExportDisplay[]
	 */
    public static com.smartgwt.client.types.ExportDisplay[] arrayOfExportDisplay(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ExportDisplay[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ExportDisplay[] objects = new com.smartgwt.client.types.ExportDisplay[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportDisplay obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportDisplay.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RowSpanEditMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RowSpanEditMode[]
	 */
    public static com.smartgwt.client.types.RowSpanEditMode[] arrayOfRowSpanEditMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RowSpanEditMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RowSpanEditMode[] objects = new com.smartgwt.client.types.RowSpanEditMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowSpanEditMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RowSpanEditMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.VisibilityMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.VisibilityMode[]
	 */
    public static com.smartgwt.client.types.VisibilityMode[] arrayOfVisibilityMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.VisibilityMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.VisibilityMode[] objects = new com.smartgwt.client.types.VisibilityMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.VisibilityMode obj = EnumUtil.getEnum(com.smartgwt.client.types.VisibilityMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PreserveOpenState} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PreserveOpenState[]
	 */
    public static com.smartgwt.client.types.PreserveOpenState[] arrayOfPreserveOpenState(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PreserveOpenState[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PreserveOpenState[] objects = new com.smartgwt.client.types.PreserveOpenState[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PreserveOpenState obj = EnumUtil.getEnum(com.smartgwt.client.types.PreserveOpenState.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Side} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Side[]
	 */
    public static com.smartgwt.client.types.Side[] arrayOfSide(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Side[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Side[] objects = new com.smartgwt.client.types.Side[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Side obj = EnumUtil.getEnum(com.smartgwt.client.types.Side.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.SimpleType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.SimpleType[]
	 */
    public static com.smartgwt.client.data.SimpleType[] arrayOfSimpleType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.SimpleType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.SimpleType[] objects = new com.smartgwt.client.data.SimpleType[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.SimpleType obj = new com.smartgwt.client.data.SimpleType(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripSeparator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripSeparator[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripSeparator[] arrayOfToolStripSeparator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripSeparator[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripSeparator[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripSeparator[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripSeparator obj = (com.smartgwt.client.widgets.toolbar.ToolStripSeparator) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStripSeparator(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.StretchImgButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.StretchImgButton[]
	 */
    public static com.smartgwt.client.widgets.StretchImgButton[] arrayOfStretchImgButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.StretchImgButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.StretchImgButton[] objects = new com.smartgwt.client.widgets.StretchImgButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.StretchImgButton obj = (com.smartgwt.client.widgets.StretchImgButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.StretchImgButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.HashAlgorithm} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.HashAlgorithm[]
	 */
    public static com.smartgwt.client.types.HashAlgorithm[] arrayOfHashAlgorithm(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.HashAlgorithm[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.HashAlgorithm[] objects = new com.smartgwt.client.types.HashAlgorithm[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HashAlgorithm obj = EnumUtil.getEnum(com.smartgwt.client.types.HashAlgorithm.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ClickMaskMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ClickMaskMode[]
	 */
    public static com.smartgwt.client.types.ClickMaskMode[] arrayOfClickMaskMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ClickMaskMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ClickMaskMode[] objects = new com.smartgwt.client.types.ClickMaskMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ClickMaskMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ClickMaskMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LinePattern} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LinePattern[]
	 */
    public static com.smartgwt.client.types.LinePattern[] arrayOfLinePattern(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LinePattern[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LinePattern[] objects = new com.smartgwt.client.types.LinePattern[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LinePattern obj = EnumUtil.getEnum(com.smartgwt.client.types.LinePattern.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.MiniDateRangeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.MiniDateRangeItem[] arrayOfMiniDateRangeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.MiniDateRangeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.MiniDateRangeItem[] objects = new com.smartgwt.client.widgets.form.fields.MiniDateRangeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.MiniDateRangeItem obj = (com.smartgwt.client.widgets.form.fields.MiniDateRangeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.MiniDateRangeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.UploadItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.UploadItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.UploadItem[] arrayOfUploadItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.UploadItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.UploadItem[] objects = new com.smartgwt.client.widgets.form.fields.UploadItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.UploadItem obj = (com.smartgwt.client.widgets.form.fields.UploadItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.UploadItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ViewName} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ViewName[]
	 */
    public static com.smartgwt.client.types.ViewName[] arrayOfViewName(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ViewName[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ViewName[] objects = new com.smartgwt.client.types.ViewName[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ViewName obj = EnumUtil.getEnum(com.smartgwt.client.types.ViewName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecordComponentPoolingMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecordComponentPoolingMode[]
	 */
    public static com.smartgwt.client.types.RecordComponentPoolingMode[] arrayOfRecordComponentPoolingMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecordComponentPoolingMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RecordComponentPoolingMode[] objects = new com.smartgwt.client.types.RecordComponentPoolingMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordComponentPoolingMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordComponentPoolingMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.StateTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.StateTask[]
	 */
    public static com.smartgwt.client.util.workflow.StateTask[] arrayOfStateTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.StateTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.StateTask[] objects = new com.smartgwt.client.util.workflow.StateTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.StateTask obj = new com.smartgwt.client.util.workflow.StateTask(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.Lane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.Lane[]
	 */
    public static com.smartgwt.client.widgets.calendar.Lane[] arrayOfLane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.Lane[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.calendar.Lane[] ret = new com.smartgwt.client.widgets.calendar.Lane[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.calendar.Lane(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.Lane[] objects = new com.smartgwt.client.widgets.calendar.Lane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.Lane obj = (com.smartgwt.client.widgets.calendar.Lane) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.Lane(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecordSummaryFunctionType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecordSummaryFunctionType[]
	 */
    public static com.smartgwt.client.types.RecordSummaryFunctionType[] arrayOfRecordSummaryFunctionType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecordSummaryFunctionType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RecordSummaryFunctionType[] objects = new com.smartgwt.client.types.RecordSummaryFunctionType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordSummaryFunctionType obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordSummaryFunctionType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Positioning} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Positioning[]
	 */
    public static com.smartgwt.client.types.Positioning[] arrayOfPositioning(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Positioning[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Positioning[] objects = new com.smartgwt.client.types.Positioning[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Positioning obj = EnumUtil.getEnum(com.smartgwt.client.types.Positioning.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripGroup[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripGroup[] arrayOfToolStripGroup(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripGroup[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripGroup[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripGroup[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripGroup obj = (com.smartgwt.client.widgets.toolbar.ToolStripGroup) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStripGroup(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.NativeCheckboxItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.NativeCheckboxItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.NativeCheckboxItem[] arrayOfNativeCheckboxItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.NativeCheckboxItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.NativeCheckboxItem[] objects = new com.smartgwt.client.widgets.form.fields.NativeCheckboxItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.NativeCheckboxItem obj = (com.smartgwt.client.widgets.form.fields.NativeCheckboxItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.NativeCheckboxItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.IPickTreeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.IPickTreeItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.IPickTreeItem[] arrayOfIPickTreeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.IPickTreeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.IPickTreeItem[] objects = new com.smartgwt.client.widgets.form.fields.IPickTreeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.IPickTreeItem obj = (com.smartgwt.client.widgets.form.fields.IPickTreeItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.IPickTreeItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SelectOtherItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SelectOtherItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SelectOtherItem[] arrayOfSelectOtherItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SelectOtherItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SelectOtherItem[] objects = new com.smartgwt.client.widgets.form.fields.SelectOtherItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SelectOtherItem obj = (com.smartgwt.client.widgets.form.fields.SelectOtherItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SelectOtherItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RegressionLineType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RegressionLineType[]
	 */
    public static com.smartgwt.client.types.RegressionLineType[] arrayOfRegressionLineType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RegressionLineType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RegressionLineType[] objects = new com.smartgwt.client.types.RegressionLineType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RegressionLineType obj = EnumUtil.getEnum(com.smartgwt.client.types.RegressionLineType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.SortSpecifier} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.SortSpecifier[]
	 */
    public static com.smartgwt.client.data.SortSpecifier[] arrayOfSortSpecifier(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.SortSpecifier[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.SortSpecifier[] ret = new com.smartgwt.client.data.SortSpecifier[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.SortSpecifier(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.SortSpecifier[] objects = new com.smartgwt.client.data.SortSpecifier[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.SortSpecifier obj = (com.smartgwt.client.data.SortSpecifier) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.SortSpecifier(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripMenuButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripMenuButton[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripMenuButton[] arrayOfToolStripMenuButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripMenuButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripMenuButton[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripMenuButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripMenuButton obj = (com.smartgwt.client.widgets.toolbar.ToolStripMenuButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.toolbar.ToolStripMenuButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.WSDataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.WSDataSource[]
	 */
    public static com.smartgwt.client.data.WSDataSource[] arrayOfWSDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.WSDataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.WSDataSource[] objects = new com.smartgwt.client.data.WSDataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.WSDataSource obj = new com.smartgwt.client.data.WSDataSource(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.Gradient} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.Gradient[]
	 */
    public static com.smartgwt.client.widgets.drawing.Gradient[] arrayOfGradient(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.Gradient[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.Gradient[] ret = new com.smartgwt.client.widgets.drawing.Gradient[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.Gradient(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.Gradient[] objects = new com.smartgwt.client.widgets.drawing.Gradient[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.Gradient obj = (com.smartgwt.client.widgets.drawing.Gradient) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.Gradient(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DialogButtons} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DialogButtons[]
	 */
    public static com.smartgwt.client.types.DialogButtons[] arrayOfDialogButtons(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DialogButtons[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DialogButtons[] objects = new com.smartgwt.client.types.DialogButtons[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DialogButtons obj = EnumUtil.getEnum(com.smartgwt.client.types.DialogButtons.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.RichTextEditor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.RichTextEditor[]
	 */
    public static com.smartgwt.client.widgets.RichTextEditor[] arrayOfRichTextEditor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.RichTextEditor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.RichTextEditor[] objects = new com.smartgwt.client.widgets.RichTextEditor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.RichTextEditor obj = (com.smartgwt.client.widgets.RichTextEditor) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.RichTextEditor(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.HiliteIconPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.HiliteIconPosition[]
	 */
    public static com.smartgwt.client.types.HiliteIconPosition[] arrayOfHiliteIconPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.HiliteIconPosition[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.HiliteIconPosition[] objects = new com.smartgwt.client.types.HiliteIconPosition[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HiliteIconPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.HiliteIconPosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tab.Tab} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tab.Tab[]
	 */
    public static com.smartgwt.client.widgets.tab.Tab[] arrayOfTab(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tab.Tab[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.tab.Tab[] ret = new com.smartgwt.client.widgets.tab.Tab[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.tab.Tab(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tab.Tab[] objects = new com.smartgwt.client.widgets.tab.Tab[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tab.Tab obj = (com.smartgwt.client.widgets.tab.Tab) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tab.Tab(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.Criterion} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.Criterion[]
	 */
    public static com.smartgwt.client.data.Criterion[] arrayOfCriterion(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.Criterion[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.Criterion[] ret = new com.smartgwt.client.data.Criterion[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.Criterion(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.Criterion[] objects = new com.smartgwt.client.data.Criterion[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.Criterion obj = (com.smartgwt.client.data.Criterion) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.Criterion(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.OperatorValueType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.OperatorValueType[]
	 */
    public static com.smartgwt.client.types.OperatorValueType[] arrayOfOperatorValueType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.OperatorValueType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.OperatorValueType[] objects = new com.smartgwt.client.types.OperatorValueType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.OperatorValueType obj = EnumUtil.getEnum(com.smartgwt.client.types.OperatorValueType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.MultiFileItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.MultiFileItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.MultiFileItem[] arrayOfMultiFileItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.MultiFileItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.MultiFileItem[] objects = new com.smartgwt.client.widgets.form.fields.MultiFileItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.MultiFileItem obj = (com.smartgwt.client.widgets.form.fields.MultiFileItem) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.MultiFileItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ChartType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ChartType[]
	 */
    public static com.smartgwt.client.types.ChartType[] arrayOfChartType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ChartType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ChartType[] objects = new com.smartgwt.client.types.ChartType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ChartType obj = EnumUtil.getEnum(com.smartgwt.client.types.ChartType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.TreeGrid} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.TreeGrid[]
	 */
    public static com.smartgwt.client.widgets.tree.TreeGrid[] arrayOfTreeGrid(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.TreeGrid[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.TreeGrid[] objects = new com.smartgwt.client.widgets.tree.TreeGrid[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.TreeGrid obj = (com.smartgwt.client.widgets.tree.TreeGrid) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.TreeGrid(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tab.TabSet} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tab.TabSet[]
	 */
    public static com.smartgwt.client.widgets.tab.TabSet[] arrayOfTabSet(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tab.TabSet[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tab.TabSet[] objects = new com.smartgwt.client.widgets.tab.TabSet[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tab.TabSet obj = (com.smartgwt.client.widgets.tab.TabSet) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tab.TabSet(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.DateItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.DateItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.DateItem[] arrayOfDateItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.DateItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.DateItem[] objects = new com.smartgwt.client.widgets.form.fields.DateItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.DateItem obj = (com.smartgwt.client.widgets.form.fields.DateItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.DateItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ValidatorType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ValidatorType[]
	 */
    public static com.smartgwt.client.types.ValidatorType[] arrayOfValidatorType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ValidatorType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ValidatorType[] objects = new com.smartgwt.client.types.ValidatorType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValidatorType obj = EnumUtil.getEnum(com.smartgwt.client.types.ValidatorType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.Shadow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.Shadow[]
	 */
    public static com.smartgwt.client.widgets.drawing.Shadow[] arrayOfShadow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.Shadow[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.Shadow[] ret = new com.smartgwt.client.widgets.drawing.Shadow[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.Shadow(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.Shadow[] objects = new com.smartgwt.client.widgets.drawing.Shadow[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.Shadow obj = (com.smartgwt.client.widgets.drawing.Shadow) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.Shadow(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.EventWindow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.EventWindow[]
	 */
    public static com.smartgwt.client.widgets.calendar.EventWindow[] arrayOfEventWindow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.EventWindow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.EventWindow[] objects = new com.smartgwt.client.widgets.calendar.EventWindow[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.EventWindow obj = (com.smartgwt.client.widgets.calendar.EventWindow) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.EventWindow(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.VLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.VLayout[]
	 */
    public static com.smartgwt.client.widgets.layout.VLayout[] arrayOfVLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.VLayout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.VLayout[] objects = new com.smartgwt.client.widgets.layout.VLayout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.VLayout obj = (com.smartgwt.client.widgets.layout.VLayout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.VLayout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LayoutPolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LayoutPolicy[]
	 */
    public static com.smartgwt.client.types.LayoutPolicy[] arrayOfLayoutPolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LayoutPolicy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LayoutPolicy[] objects = new com.smartgwt.client.types.LayoutPolicy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LayoutPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.LayoutPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DragAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DragAppearance[]
	 */
    public static com.smartgwt.client.types.DragAppearance[] arrayOfDragAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DragAppearance[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DragAppearance[] objects = new com.smartgwt.client.types.DragAppearance[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.DragAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EnterKeyEditAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EnterKeyEditAction[]
	 */
    public static com.smartgwt.client.types.EnterKeyEditAction[] arrayOfEnterKeyEditAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EnterKeyEditAction[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EnterKeyEditAction[] objects = new com.smartgwt.client.types.EnterKeyEditAction[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EnterKeyEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.EnterKeyEditAction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FormItemType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FormItemType[]
	 */
    public static com.smartgwt.client.types.FormItemType[] arrayOfFormItemType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FormItemType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.FormItemType[] objects = new com.smartgwt.client.types.FormItemType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FormItemType obj = EnumUtil.getEnum(com.smartgwt.client.types.FormItemType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.StretchItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.StretchItem[]
	 */
    public static com.smartgwt.client.widgets.StretchItem[] arrayOfStretchItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.StretchItem[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.StretchItem[] ret = new com.smartgwt.client.widgets.StretchItem[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.StretchItem(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.StretchItem[] objects = new com.smartgwt.client.widgets.StretchItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.StretchItem obj = (com.smartgwt.client.widgets.StretchItem) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.StretchItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.GroupStartOpen} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.GroupStartOpen[]
	 */
    public static com.smartgwt.client.types.GroupStartOpen[] arrayOfGroupStartOpen(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.GroupStartOpen[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.GroupStartOpen[] objects = new com.smartgwt.client.types.GroupStartOpen[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.GroupStartOpen obj = EnumUtil.getEnum(com.smartgwt.client.types.GroupStartOpen.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TableMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TableMode[]
	 */
    public static com.smartgwt.client.types.TableMode[] arrayOfTableMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TableMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TableMode[] objects = new com.smartgwt.client.types.TableMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TableMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TableMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SpinnerItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SpinnerItem[] arrayOfSpinnerItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SpinnerItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SpinnerItem[] objects = new com.smartgwt.client.widgets.form.fields.SpinnerItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SpinnerItem obj = (com.smartgwt.client.widgets.form.fields.SpinnerItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SpinnerItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LocatorTypeStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LocatorTypeStrategy[]
	 */
    public static com.smartgwt.client.types.LocatorTypeStrategy[] arrayOfLocatorTypeStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LocatorTypeStrategy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.LocatorTypeStrategy[] objects = new com.smartgwt.client.types.LocatorTypeStrategy[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LocatorTypeStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.LocatorTypeStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.rpc.RPCResponse} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.rpc.RPCResponse[]
	 */
    public static com.smartgwt.client.rpc.RPCResponse[] arrayOfRPCResponse(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.rpc.RPCResponse[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.rpc.RPCResponse[] ret = new com.smartgwt.client.rpc.RPCResponse[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.rpc.RPCResponse(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.rpc.RPCResponse[] objects = new com.smartgwt.client.rpc.RPCResponse[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.rpc.RPCResponse obj = (com.smartgwt.client.rpc.RPCResponse) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.rpc.RPCResponse(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.DynamicForm} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.DynamicForm[]
	 */
    public static com.smartgwt.client.widgets.form.DynamicForm[] arrayOfDynamicForm(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.DynamicForm[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.DynamicForm[] objects = new com.smartgwt.client.widgets.form.DynamicForm[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.DynamicForm obj = (com.smartgwt.client.widgets.form.DynamicForm) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.DynamicForm(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ButtonItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ButtonItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ButtonItem[] arrayOfButtonItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ButtonItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ButtonItem[] objects = new com.smartgwt.client.widgets.form.fields.ButtonItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ButtonItem obj = (com.smartgwt.client.widgets.form.fields.ButtonItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.ButtonItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.Menu} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.Menu[]
	 */
    public static com.smartgwt.client.widgets.menu.Menu[] arrayOfMenu(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.Menu[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.Menu[] objects = new com.smartgwt.client.widgets.menu.Menu[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.Menu obj = (com.smartgwt.client.widgets.menu.Menu) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.Menu(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawItem[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawItem[] arrayOfDrawItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawItem[] objects = new com.smartgwt.client.widgets.drawing.DrawItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawItem obj = new com.smartgwt.client.widgets.drawing.DrawItem(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.MenuButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.MenuButton[]
	 */
    public static com.smartgwt.client.widgets.menu.MenuButton[] arrayOfMenuButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.MenuButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.MenuButton[] objects = new com.smartgwt.client.widgets.menu.MenuButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.MenuButton obj = (com.smartgwt.client.widgets.menu.MenuButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.MenuButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.plugins.BrowserPlugin} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.plugins.BrowserPlugin[]
	 */
    public static com.smartgwt.client.widgets.plugins.BrowserPlugin[] arrayOfBrowserPlugin(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.plugins.BrowserPlugin[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.plugins.BrowserPlugin[] objects = new com.smartgwt.client.widgets.plugins.BrowserPlugin[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.plugins.BrowserPlugin obj = (com.smartgwt.client.widgets.plugins.BrowserPlugin) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.plugins.BrowserPlugin(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.HTMLPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.HTMLPane[]
	 */
    public static com.smartgwt.client.widgets.HTMLPane[] arrayOfHTMLPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.HTMLPane[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.HTMLPane[] objects = new com.smartgwt.client.widgets.HTMLPane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.HTMLPane obj = (com.smartgwt.client.widgets.HTMLPane) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.HTMLPane(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DateItemSelectorFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DateItemSelectorFormat[]
	 */
    public static com.smartgwt.client.types.DateItemSelectorFormat[] arrayOfDateItemSelectorFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DateItemSelectorFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DateItemSelectorFormat[] objects = new com.smartgwt.client.types.DateItemSelectorFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateItemSelectorFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DateItemSelectorFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoSelectionModel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoSelectionModel[]
	 */
    public static com.smartgwt.client.types.AutoSelectionModel[] arrayOfAutoSelectionModel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoSelectionModel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AutoSelectionModel[] objects = new com.smartgwt.client.types.AutoSelectionModel[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoSelectionModel obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoSelectionModel.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Img} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Img[]
	 */
    public static com.smartgwt.client.widgets.Img[] arrayOfImg(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Img[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Img[] objects = new com.smartgwt.client.widgets.Img[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Img obj = (com.smartgwt.client.widgets.Img) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Img(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tab.TabBar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tab.TabBar[]
	 */
    public static com.smartgwt.client.widgets.tab.TabBar[] arrayOfTabBar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tab.TabBar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tab.TabBar[] objects = new com.smartgwt.client.widgets.tab.TabBar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tab.TabBar obj = (com.smartgwt.client.widgets.tab.TabBar) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tab.TabBar(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.CharacterCasing} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.CharacterCasing[]
	 */
    public static com.smartgwt.client.types.CharacterCasing[] arrayOfCharacterCasing(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.CharacterCasing[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.CharacterCasing[] objects = new com.smartgwt.client.types.CharacterCasing[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CharacterCasing obj = EnumUtil.getEnum(com.smartgwt.client.types.CharacterCasing.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.JSONCircularReferenceMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.JSONCircularReferenceMode[]
	 */
    public static com.smartgwt.client.types.JSONCircularReferenceMode[] arrayOfJSONCircularReferenceMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.JSONCircularReferenceMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.JSONCircularReferenceMode[] objects = new com.smartgwt.client.types.JSONCircularReferenceMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONCircularReferenceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONCircularReferenceMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Dialog} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Dialog[]
	 */
    public static com.smartgwt.client.widgets.Dialog[] arrayOfDialog(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Dialog[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Dialog[] objects = new com.smartgwt.client.widgets.Dialog[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Dialog obj = (com.smartgwt.client.widgets.Dialog) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.Dialog(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.FormItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.FormItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.FormItem[] arrayOfFormItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.FormItem[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.form.fields.FormItem[] ret = new com.smartgwt.client.widgets.form.fields.FormItem[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.form.fields.FormItem(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.FormItem[] objects = new com.smartgwt.client.widgets.form.fields.FormItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.FormItem obj = FormItemFactory.getFormItem(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.FormItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.VerticalAlignment} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.VerticalAlignment[]
	 */
    public static com.smartgwt.client.types.VerticalAlignment[] arrayOfVerticalAlignment(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.VerticalAlignment[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.VerticalAlignment[] objects = new com.smartgwt.client.types.VerticalAlignment[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.VerticalAlignment obj = EnumUtil.getEnum(com.smartgwt.client.types.VerticalAlignment.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ResetItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ResetItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ResetItem[] arrayOfResetItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ResetItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ResetItem[] objects = new com.smartgwt.client.widgets.form.fields.ResetItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ResetItem obj = (com.smartgwt.client.widgets.form.fields.ResetItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.ResetItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.KnobType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.KnobType[]
	 */
    public static com.smartgwt.client.types.KnobType[] arrayOfKnobType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.KnobType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.KnobType[] objects = new com.smartgwt.client.types.KnobType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.KnobType obj = EnumUtil.getEnum(com.smartgwt.client.types.KnobType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.RestDataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.RestDataSource[]
	 */
    public static com.smartgwt.client.data.RestDataSource[] arrayOfRestDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.RestDataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.RestDataSource[] objects = new com.smartgwt.client.data.RestDataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.RestDataSource obj = new com.smartgwt.client.data.RestDataSource(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TreeModelType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TreeModelType[]
	 */
    public static com.smartgwt.client.types.TreeModelType[] arrayOfTreeModelType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TreeModelType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TreeModelType[] objects = new com.smartgwt.client.types.TreeModelType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TreeModelType obj = EnumUtil.getEnum(com.smartgwt.client.types.TreeModelType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.Timeline} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.Timeline[]
	 */
    public static com.smartgwt.client.widgets.calendar.Timeline[] arrayOfTimeline(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.Timeline[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.Timeline[] objects = new com.smartgwt.client.widgets.calendar.Timeline[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.Timeline obj = (com.smartgwt.client.widgets.calendar.Timeline) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.calendar.Timeline(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.GroupSummary} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.GroupSummary[]
	 */
    public static com.smartgwt.client.widgets.grid.GroupSummary[] arrayOfGroupSummary(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.GroupSummary[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.grid.GroupSummary[] ret = new com.smartgwt.client.widgets.grid.GroupSummary[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.grid.GroupSummary(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.GroupSummary[] objects = new com.smartgwt.client.widgets.grid.GroupSummary[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.GroupSummary obj = (com.smartgwt.client.widgets.grid.GroupSummary) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.GroupSummary(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawTriangle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawTriangle[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawTriangle[] arrayOfDrawTriangle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawTriangle[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawTriangle[] objects = new com.smartgwt.client.widgets.drawing.DrawTriangle[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawTriangle obj = new com.smartgwt.client.widgets.drawing.DrawTriangle(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.DataSourceField} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.DataSourceField[]
	 */
    public static com.smartgwt.client.data.DataSourceField[] arrayOfDataSourceField(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.DataSourceField[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.DataSourceField[] ret = new com.smartgwt.client.data.DataSourceField[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.DataSourceField(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.DataSourceField[] objects = new com.smartgwt.client.data.DataSourceField[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.DataSourceField obj = (com.smartgwt.client.data.DataSourceField) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.DataSourceField(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Direction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Direction[]
	 */
    public static com.smartgwt.client.types.Direction[] arrayOfDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Direction[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Direction[] objects = new com.smartgwt.client.types.Direction[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Direction obj = EnumUtil.getEnum(com.smartgwt.client.types.Direction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EscapingMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EscapingMode[]
	 */
    public static com.smartgwt.client.types.EscapingMode[] arrayOfEscapingMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EscapingMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EscapingMode[] objects = new com.smartgwt.client.types.EscapingMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EscapingMode obj = EnumUtil.getEnum(com.smartgwt.client.types.EscapingMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ValueItemType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ValueItemType[]
	 */
    public static com.smartgwt.client.types.ValueItemType[] arrayOfValueItemType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ValueItemType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ValueItemType[] objects = new com.smartgwt.client.types.ValueItemType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValueItemType obj = EnumUtil.getEnum(com.smartgwt.client.types.ValueItemType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.TextImportSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.TextImportSettings[]
	 */
    public static com.smartgwt.client.data.TextImportSettings[] arrayOfTextImportSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.TextImportSettings[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.TextImportSettings[] objects = new com.smartgwt.client.data.TextImportSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.TextImportSettings obj = new com.smartgwt.client.data.TextImportSettings(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.CheckboxItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.CheckboxItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.CheckboxItem[] arrayOfCheckboxItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.CheckboxItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.CheckboxItem[] objects = new com.smartgwt.client.widgets.form.fields.CheckboxItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.CheckboxItem obj = (com.smartgwt.client.widgets.form.fields.CheckboxItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.CheckboxItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ExportFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ExportFormat[]
	 */
    public static com.smartgwt.client.types.ExportFormat[] arrayOfExportFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ExportFormat[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.ExportFormat[] objects = new com.smartgwt.client.types.ExportFormat[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.RichTextItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.RichTextItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.RichTextItem[] arrayOfRichTextItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.RichTextItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.RichTextItem[] objects = new com.smartgwt.client.widgets.form.fields.RichTextItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.RichTextItem obj = (com.smartgwt.client.widgets.form.fields.RichTextItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.RichTextItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.PrintCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.PrintCanvas[]
	 */
    public static com.smartgwt.client.widgets.PrintCanvas[] arrayOfPrintCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.PrintCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.PrintCanvas[] objects = new com.smartgwt.client.widgets.PrintCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.PrintCanvas obj = (com.smartgwt.client.widgets.PrintCanvas) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.PrintCanvas(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PageOrientation} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PageOrientation[]
	 */
    public static com.smartgwt.client.types.PageOrientation[] arrayOfPageOrientation(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PageOrientation[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PageOrientation[] objects = new com.smartgwt.client.types.PageOrientation[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PageOrientation obj = EnumUtil.getEnum(com.smartgwt.client.types.PageOrientation.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.Layout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.Layout[]
	 */
    public static com.smartgwt.client.widgets.layout.Layout[] arrayOfLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.Layout[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.Layout[] objects = new com.smartgwt.client.widgets.layout.Layout[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.Layout obj = (com.smartgwt.client.widgets.layout.Layout) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.Layout(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TextAreaWrap} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TextAreaWrap[]
	 */
    public static com.smartgwt.client.types.TextAreaWrap[] arrayOfTextAreaWrap(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TextAreaWrap[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.TextAreaWrap[] objects = new com.smartgwt.client.types.TextAreaWrap[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TextAreaWrap obj = EnumUtil.getEnum(com.smartgwt.client.types.TextAreaWrap.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.SearchForm} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.SearchForm[]
	 */
    public static com.smartgwt.client.widgets.form.SearchForm[] arrayOfSearchForm(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.SearchForm[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.SearchForm[] objects = new com.smartgwt.client.widgets.form.SearchForm[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.SearchForm obj = (com.smartgwt.client.widgets.form.SearchForm) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.SearchForm(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectionAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectionAppearance[]
	 */
    public static com.smartgwt.client.types.SelectionAppearance[] arrayOfSelectionAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectionAppearance[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SelectionAppearance[] objects = new com.smartgwt.client.types.SelectionAppearance[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.rpc.RPCRequest} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.rpc.RPCRequest[]
	 */
    public static com.smartgwt.client.rpc.RPCRequest[] arrayOfRPCRequest(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.rpc.RPCRequest[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.rpc.RPCRequest[] ret = new com.smartgwt.client.rpc.RPCRequest[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.rpc.RPCRequest(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.rpc.RPCRequest[] objects = new com.smartgwt.client.rpc.RPCRequest[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.rpc.RPCRequest obj = (com.smartgwt.client.rpc.RPCRequest) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.rpc.RPCRequest(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.ListGridField} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.ListGridField[]
	 */
    public static com.smartgwt.client.widgets.grid.ListGridField[] arrayOfListGridField(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.ListGridField[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.grid.ListGridField[] ret = new com.smartgwt.client.widgets.grid.ListGridField[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.grid.ListGridField(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.ListGridField[] objects = new com.smartgwt.client.widgets.grid.ListGridField[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.ListGridField obj = (com.smartgwt.client.widgets.grid.ListGridField) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.ListGridField(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DSInheritanceMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DSInheritanceMode[]
	 */
    public static com.smartgwt.client.types.DSInheritanceMode[] arrayOfDSInheritanceMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DSInheritanceMode[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DSInheritanceMode[] objects = new com.smartgwt.client.types.DSInheritanceMode[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSInheritanceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.DSInheritanceMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.MenuItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.MenuItem[]
	 */
    public static com.smartgwt.client.widgets.menu.MenuItem[] arrayOfMenuItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.MenuItem[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.menu.MenuItem[] ret = new com.smartgwt.client.widgets.menu.MenuItem[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.menu.MenuItem(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.MenuItem[] objects = new com.smartgwt.client.widgets.menu.MenuItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.MenuItem obj = (com.smartgwt.client.widgets.menu.MenuItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.MenuItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectionNotificationType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectionNotificationType[]
	 */
    public static com.smartgwt.client.types.SelectionNotificationType[] arrayOfSelectionNotificationType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectionNotificationType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.SelectionNotificationType[] objects = new com.smartgwt.client.types.SelectionNotificationType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionNotificationType obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionNotificationType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DSOperationType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DSOperationType[]
	 */
    public static com.smartgwt.client.types.DSOperationType[] arrayOfDSOperationType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DSOperationType[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.DSOperationType[] objects = new com.smartgwt.client.types.DSOperationType[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSOperationType obj = EnumUtil.getEnum(com.smartgwt.client.types.DSOperationType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AnimationAcceleration} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AnimationAcceleration[]
	 */
    public static com.smartgwt.client.types.AnimationAcceleration[] arrayOfAnimationAcceleration(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AnimationAcceleration[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.AnimationAcceleration[] objects = new com.smartgwt.client.types.AnimationAcceleration[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AnimationAcceleration obj = EnumUtil.getEnum(com.smartgwt.client.types.AnimationAcceleration.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PartialCommitOption} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PartialCommitOption[]
	 */
    public static com.smartgwt.client.types.PartialCommitOption[] arrayOfPartialCommitOption(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PartialCommitOption[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.PartialCommitOption[] objects = new com.smartgwt.client.types.PartialCommitOption[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PartialCommitOption obj = EnumUtil.getEnum(com.smartgwt.client.types.PartialCommitOption.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ProcessElement} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ProcessElement[]
	 */
    public static com.smartgwt.client.util.workflow.ProcessElement[] arrayOfProcessElement(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ProcessElement[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ProcessElement[] objects = new com.smartgwt.client.util.workflow.ProcessElement[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ProcessElement obj = new com.smartgwt.client.util.workflow.ProcessElement(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.VStack} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.VStack[]
	 */
    public static com.smartgwt.client.widgets.layout.VStack[] arrayOfVStack(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.VStack[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.VStack[] objects = new com.smartgwt.client.widgets.layout.VStack[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.VStack obj = (com.smartgwt.client.widgets.layout.VStack) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.VStack(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.HiliteEditor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.HiliteEditor[]
	 */
    public static com.smartgwt.client.widgets.grid.HiliteEditor[] arrayOfHiliteEditor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.HiliteEditor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.HiliteEditor[] objects = new com.smartgwt.client.widgets.grid.HiliteEditor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.HiliteEditor obj = (com.smartgwt.client.widgets.grid.HiliteEditor) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.HiliteEditor(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.FiscalCalendar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.FiscalCalendar[]
	 */
    public static com.smartgwt.client.widgets.FiscalCalendar[] arrayOfFiscalCalendar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.FiscalCalendar[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.FiscalCalendar[] ret = new com.smartgwt.client.widgets.FiscalCalendar[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.FiscalCalendar(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.FiscalCalendar[] objects = new com.smartgwt.client.widgets.FiscalCalendar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.FiscalCalendar obj = (com.smartgwt.client.widgets.FiscalCalendar) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.FiscalCalendar(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.EscapeKeyEditAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.EscapeKeyEditAction[]
	 */
    public static com.smartgwt.client.types.EscapeKeyEditAction[] arrayOfEscapeKeyEditAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.EscapeKeyEditAction[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.EscapeKeyEditAction[] objects = new com.smartgwt.client.types.EscapeKeyEditAction[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EscapeKeyEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.EscapeKeyEditAction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.SliderItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.SliderItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.SliderItem[] arrayOfSliderItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.SliderItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.SliderItem[] objects = new com.smartgwt.client.widgets.form.fields.SliderItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.SliderItem obj = (com.smartgwt.client.widgets.form.fields.SliderItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.SliderItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.UserSummary} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.UserSummary[]
	 */
    public static com.smartgwt.client.widgets.UserSummary[] arrayOfUserSummary(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.UserSummary[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.UserSummary[] ret = new com.smartgwt.client.widgets.UserSummary[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.UserSummary(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.UserSummary[] objects = new com.smartgwt.client.widgets.UserSummary[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.UserSummary obj = (com.smartgwt.client.widgets.UserSummary) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.UserSummary(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.FiscalYear} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.FiscalYear[]
	 */
    public static com.smartgwt.client.widgets.FiscalYear[] arrayOfFiscalYear(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.FiscalYear[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.FiscalYear[] ret = new com.smartgwt.client.widgets.FiscalYear[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.FiscalYear(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.FiscalYear[] objects = new com.smartgwt.client.widgets.FiscalYear[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.FiscalYear obj = (com.smartgwt.client.widgets.FiscalYear) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.FiscalYear(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RowEndEditAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RowEndEditAction[]
	 */
    public static com.smartgwt.client.types.RowEndEditAction[] arrayOfRowEndEditAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RowEndEditAction[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.RowEndEditAction[] objects = new com.smartgwt.client.types.RowEndEditAction[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowEndEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.RowEndEditAction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.StretchImg} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.StretchImg[]
	 */
    public static com.smartgwt.client.widgets.StretchImg[] arrayOfStretchImg(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.StretchImg[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.StretchImg[] objects = new com.smartgwt.client.widgets.StretchImg[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.StretchImg obj = (com.smartgwt.client.widgets.StretchImg) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.StretchImg(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.SectionStack} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.SectionStack[]
	 */
    public static com.smartgwt.client.widgets.layout.SectionStack[] arrayOfSectionStack(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.SectionStack[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.SectionStack[] objects = new com.smartgwt.client.widgets.layout.SectionStack[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.SectionStack obj = (com.smartgwt.client.widgets.layout.SectionStack) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.SectionStack(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawBlockConnector} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawBlockConnector[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawBlockConnector[] arrayOfDrawBlockConnector(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawBlockConnector[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawBlockConnector[] objects = new com.smartgwt.client.widgets.drawing.DrawBlockConnector[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawBlockConnector obj = new com.smartgwt.client.widgets.drawing.DrawBlockConnector(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.FieldPickerWindow} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.FieldPickerWindow[]
	 */
    public static com.smartgwt.client.widgets.FieldPickerWindow[] arrayOfFieldPickerWindow(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.FieldPickerWindow[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.FieldPickerWindow[] objects = new com.smartgwt.client.widgets.FieldPickerWindow[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.FieldPickerWindow obj = (com.smartgwt.client.widgets.FieldPickerWindow) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.FieldPickerWindow(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.ImgSectionHeader} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.ImgSectionHeader[]
	 */
    public static com.smartgwt.client.widgets.layout.ImgSectionHeader[] arrayOfImgSectionHeader(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.ImgSectionHeader[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.ImgSectionHeader[] objects = new com.smartgwt.client.widgets.layout.ImgSectionHeader[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.ImgSectionHeader obj = (com.smartgwt.client.widgets.layout.ImgSectionHeader) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.ImgSectionHeader(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Cursor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Cursor[]
	 */
    public static com.smartgwt.client.types.Cursor[] arrayOfCursor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Cursor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Cursor[] objects = new com.smartgwt.client.types.Cursor[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Cursor obj = EnumUtil.getEnum(com.smartgwt.client.types.Cursor.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.Alignment} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.Alignment[]
	 */
    public static com.smartgwt.client.types.Alignment[] arrayOfAlignment(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.Alignment[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.Alignment[] objects = new com.smartgwt.client.types.Alignment[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Alignment obj = EnumUtil.getEnum(com.smartgwt.client.types.Alignment.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.Criteria} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.Criteria[]
	 */
    public static com.smartgwt.client.data.Criteria[] arrayOfCriteria(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.Criteria[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.Criteria[] ret = new com.smartgwt.client.data.Criteria[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.Criteria(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.Criteria[] objects = new com.smartgwt.client.data.Criteria[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.Criteria obj = (com.smartgwt.client.data.Criteria) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.Criteria(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.RadioGroupItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.RadioGroupItem[] arrayOfRadioGroupItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.RadioGroupItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.RadioGroupItem[] objects = new com.smartgwt.client.widgets.form.fields.RadioGroupItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.RadioGroupItem obj = (com.smartgwt.client.widgets.form.fields.RadioGroupItem) ((DataClass) RefDataClass.getRef(components[i]));

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.RadioGroupItem(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MultipleAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MultipleAppearance[]
	 */
    public static com.smartgwt.client.types.MultipleAppearance[] arrayOfMultipleAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MultipleAppearance[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.types.MultipleAppearance[] objects = new com.smartgwt.client.types.MultipleAppearance[components.length];
        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);

        for (int i = 0; i < components.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultipleAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.MultipleAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.IMenuButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.IMenuButton[]
	 */
    public static com.smartgwt.client.widgets.menu.IMenuButton[] arrayOfIMenuButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.IMenuButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.IMenuButton[] objects = new com.smartgwt.client.widgets.menu.IMenuButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.IMenuButton obj = (com.smartgwt.client.widgets.menu.IMenuButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.menu.IMenuButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.IButton} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.IButton[]
	 */
    public static com.smartgwt.client.widgets.IButton[] arrayOfIButton(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.IButton[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.IButton[] objects = new com.smartgwt.client.widgets.IButton[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.IButton obj = (com.smartgwt.client.widgets.IButton) BaseWidget.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.IButton(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createCanvas(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.TextAreaItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.TextAreaItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.TextAreaItem[] arrayOfTextAreaItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.TextAreaItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.TextAreaItem[] objects = new com.smartgwt.client.widgets.form.fields.TextAreaItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.TextAreaItem obj = (com.smartgwt.client.widgets.form.fields.TextAreaItem) RefDataClass.getRef(components[i]);

            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.fields.TextAreaItem(components[i]));
            }

            if (obj != null && obj.getAttribute("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

}
