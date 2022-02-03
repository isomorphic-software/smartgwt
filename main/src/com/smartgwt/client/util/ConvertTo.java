
package com.smartgwt.client.util;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.ObjectFactory;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.core.BaseClass;

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

    public static double[] arrayOfdouble(JavaScriptObject array) {
        int length = JSOHelper.getArrayLength(array);
        double[] arr = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = JSOHelper.getdoubleArrayValue(array, i);
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
	 * {@link com.smartgwt.client.widgets.drawing.DrawShape} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawShape[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawShape[] arrayOfDrawShape(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawShape[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawShape[] objects = new com.smartgwt.client.widgets.drawing.DrawShape[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawShape obj = (com.smartgwt.client.widgets.drawing.DrawShape) com.smartgwt.client.widgets.drawing.DrawShape.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.NavigationMode[] objects = new com.smartgwt.client.types.NavigationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NavigationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.NavigationMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Selected[] objects = new com.smartgwt.client.types.Selected[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Selected obj = EnumUtil.getEnum(com.smartgwt.client.types.Selected.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.ZoneCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.ZoneCanvas[]
	 */
    public static com.smartgwt.client.widgets.calendar.ZoneCanvas[] arrayOfZoneCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.ZoneCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.ZoneCanvas[] objects = new com.smartgwt.client.widgets.calendar.ZoneCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.ZoneCanvas obj = (com.smartgwt.client.widgets.calendar.ZoneCanvas) com.smartgwt.client.widgets.calendar.ZoneCanvas.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ResetPasswordTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ResetPasswordTask[]
	 */
    public static com.smartgwt.client.util.workflow.ResetPasswordTask[] arrayOfResetPasswordTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ResetPasswordTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ResetPasswordTask[] objects = new com.smartgwt.client.util.workflow.ResetPasswordTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ResetPasswordTask obj = (com.smartgwt.client.util.workflow.ResetPasswordTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ResetPasswordTask(components[i]));
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

            com.smartgwt.client.widgets.form.fields.SpacerItem obj = com.smartgwt.client.widgets.form.fields.SpacerItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.SectionStackEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.SectionStackEditProxy[]
	 */
    public static com.smartgwt.client.tools.SectionStackEditProxy[] arrayOfSectionStackEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.SectionStackEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.SectionStackEditProxy[] objects = new com.smartgwt.client.tools.SectionStackEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.SectionStackEditProxy obj = (com.smartgwt.client.tools.SectionStackEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.SectionStackEditProxy(components[i]));
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

            com.smartgwt.client.widgets.form.fields.BlurbItem obj = com.smartgwt.client.widgets.form.fields.BlurbItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.layout.HStack obj = (com.smartgwt.client.widgets.layout.HStack) com.smartgwt.client.widgets.layout.HStack.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.calendar.Timeline obj = (com.smartgwt.client.widgets.calendar.Timeline) com.smartgwt.client.widgets.calendar.Timeline.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.NavItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.NavItem[]
	 */
    public static com.smartgwt.client.widgets.layout.NavItem[] arrayOfNavItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.NavItem[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.layout.NavItem[] ret = new com.smartgwt.client.widgets.layout.NavItem[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.layout.NavItem(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.NavItem[] objects = new com.smartgwt.client.widgets.layout.NavItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.NavItem obj = (com.smartgwt.client.widgets.layout.NavItem) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.NavItem(components[i]));
            }

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

            com.smartgwt.client.data.SimpleType obj = (com.smartgwt.client.data.SimpleType) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.SimpleType(components[i]));
            }

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
	 * {@link com.smartgwt.client.widgets.FieldPicker} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.FieldPicker[]
	 */
    public static com.smartgwt.client.widgets.FieldPicker[] arrayOfFieldPicker(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.FieldPicker[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.FieldPicker[] objects = new com.smartgwt.client.widgets.FieldPicker[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.FieldPicker obj = (com.smartgwt.client.widgets.FieldPicker) com.smartgwt.client.widgets.FieldPicker.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.NativeCheckboxItem obj = com.smartgwt.client.widgets.form.fields.NativeCheckboxItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.toolbar.ToolStripMenuButton obj = (com.smartgwt.client.widgets.toolbar.ToolStripMenuButton) com.smartgwt.client.widgets.toolbar.ToolStripMenuButton.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PreserveOpenState[] objects = new com.smartgwt.client.types.PreserveOpenState[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PreserveOpenState obj = EnumUtil.getEnum(com.smartgwt.client.types.PreserveOpenState.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PropertyIdentifier} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PropertyIdentifier[]
	 */
    public static com.smartgwt.client.types.PropertyIdentifier[] arrayOfPropertyIdentifier(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PropertyIdentifier[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PropertyIdentifier[] objects = new com.smartgwt.client.types.PropertyIdentifier[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PropertyIdentifier obj = EnumUtil.getEnum(com.smartgwt.client.types.PropertyIdentifier.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ValidatorType[] objects = new com.smartgwt.client.types.ValidatorType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValidatorType obj = EnumUtil.getEnum(com.smartgwt.client.types.ValidatorType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TextAreaWrap[] objects = new com.smartgwt.client.types.TextAreaWrap[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TextAreaWrap obj = EnumUtil.getEnum(com.smartgwt.client.types.TextAreaWrap.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ControlName[] objects = new com.smartgwt.client.types.ControlName[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ControlName obj = EnumUtil.getEnum(com.smartgwt.client.types.ControlName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.AnimateShowEffect} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.AnimateShowEffect[]
	 */
    public static com.smartgwt.client.widgets.drawing.AnimateShowEffect[] arrayOfAnimateShowEffect(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.AnimateShowEffect[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.AnimateShowEffect[] ret = new com.smartgwt.client.widgets.drawing.AnimateShowEffect[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.AnimateShowEffect(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.AnimateShowEffect[] objects = new com.smartgwt.client.widgets.drawing.AnimateShowEffect[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.AnimateShowEffect obj = (com.smartgwt.client.widgets.drawing.AnimateShowEffect) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.AnimateShowEffect(components[i]));
            }

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

            com.smartgwt.client.widgets.cube.Facet obj = com.smartgwt.client.widgets.cube.Facet.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.EdgedCanvas obj = (com.smartgwt.client.widgets.EdgedCanvas) com.smartgwt.client.widgets.EdgedCanvas.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ShowMessageType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ShowMessageType[]
	 */
    public static com.smartgwt.client.types.ShowMessageType[] arrayOfShowMessageType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ShowMessageType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ShowMessageType[] objects = new com.smartgwt.client.types.ShowMessageType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ShowMessageType obj = EnumUtil.getEnum(com.smartgwt.client.types.ShowMessageType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RowSpanSelectionMode[] objects = new com.smartgwt.client.types.RowSpanSelectionMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowSpanSelectionMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RowSpanSelectionMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoSelectionModel[] objects = new com.smartgwt.client.types.AutoSelectionModel[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoSelectionModel obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoSelectionModel.values(), value);

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

            com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem obj = com.smartgwt.client.widgets.form.fields.AutoFitTextAreaItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.tab.TabSet obj = (com.smartgwt.client.widgets.tab.TabSet) com.smartgwt.client.widgets.tab.TabSet.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.DSUpdateTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.DSUpdateTask[]
	 */
    public static com.smartgwt.client.util.workflow.DSUpdateTask[] arrayOfDSUpdateTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.DSUpdateTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.DSUpdateTask[] objects = new com.smartgwt.client.util.workflow.DSUpdateTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.DSUpdateTask obj = (com.smartgwt.client.util.workflow.DSUpdateTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.DSUpdateTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LinePattern[] objects = new com.smartgwt.client.types.LinePattern[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LinePattern obj = EnumUtil.getEnum(com.smartgwt.client.types.LinePattern.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawKnob} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawKnob[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawKnob[] arrayOfDrawKnob(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawKnob[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawKnob[] objects = new com.smartgwt.client.widgets.drawing.DrawKnob[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawKnob obj = (com.smartgwt.client.widgets.drawing.DrawKnob) com.smartgwt.client.widgets.drawing.DrawKnob.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DSInheritanceMode[] objects = new com.smartgwt.client.types.DSInheritanceMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSInheritanceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.DSInheritanceMode.values(), value);

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

            com.smartgwt.client.widgets.Label obj = (com.smartgwt.client.widgets.Label) com.smartgwt.client.widgets.Label.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.KnobType[] objects = new com.smartgwt.client.types.KnobType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.KnobType obj = EnumUtil.getEnum(com.smartgwt.client.types.KnobType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.SerializationSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.SerializationSettings[]
	 */
    public static com.smartgwt.client.tools.SerializationSettings[] arrayOfSerializationSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.SerializationSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.tools.SerializationSettings[] ret = new com.smartgwt.client.tools.SerializationSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.tools.SerializationSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.SerializationSettings[] objects = new com.smartgwt.client.tools.SerializationSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.SerializationSettings obj = (com.smartgwt.client.tools.SerializationSettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.SerializationSettings(components[i]));
            }

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

            com.smartgwt.client.widgets.menu.MenuButton obj = (com.smartgwt.client.widgets.menu.MenuButton) com.smartgwt.client.widgets.menu.MenuButton.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.SpinnerItem obj = com.smartgwt.client.widgets.form.fields.SpinnerItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
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

            com.smartgwt.client.widgets.form.fields.IPickTreeItem obj = com.smartgwt.client.widgets.form.fields.IPickTreeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceCompleter} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceCompleter[]
	 */
    public static com.smartgwt.client.widgets.ace.AceCompleter[] arrayOfAceCompleter(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceCompleter[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceCompleter[] objects = new com.smartgwt.client.widgets.ace.AceCompleter[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceCompleter obj = (com.smartgwt.client.widgets.ace.AceCompleter) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceCompleter(components[i]));
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

            com.smartgwt.client.widgets.cube.FacetValue obj = com.smartgwt.client.widgets.cube.FacetValue.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.BaseWidget} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.BaseWidget[]
	 */
    public static com.smartgwt.client.widgets.BaseWidget[] arrayOfBaseWidget(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.BaseWidget[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.BaseWidget[] objects = new com.smartgwt.client.widgets.BaseWidget[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.BaseWidget obj = (com.smartgwt.client.widgets.BaseWidget) com.smartgwt.client.widgets.BaseWidget.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DSOperationType[] objects = new com.smartgwt.client.types.DSOperationType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSOperationType obj = EnumUtil.getEnum(com.smartgwt.client.types.DSOperationType.values(), value);

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

            com.smartgwt.client.widgets.form.fields.SectionItem obj = com.smartgwt.client.widgets.form.fields.SectionItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.form.fields.ResetItem obj = com.smartgwt.client.widgets.form.fields.ResetItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.Window obj = (com.smartgwt.client.widgets.Window) com.smartgwt.client.widgets.Window.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.notify.NotifyAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.notify.NotifyAction[]
	 */
    public static com.smartgwt.client.widgets.notify.NotifyAction[] arrayOfNotifyAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.notify.NotifyAction[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.notify.NotifyAction[] ret = new com.smartgwt.client.widgets.notify.NotifyAction[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.notify.NotifyAction(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.notify.NotifyAction[] objects = new com.smartgwt.client.widgets.notify.NotifyAction[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.notify.NotifyAction obj = (com.smartgwt.client.widgets.notify.NotifyAction) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.notify.NotifyAction(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FormMethod[] objects = new com.smartgwt.client.types.FormMethod[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FormMethod obj = EnumUtil.getEnum(com.smartgwt.client.types.FormMethod.values(), value);

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

            com.smartgwt.client.widgets.FiscalCalendar obj = com.smartgwt.client.widgets.FiscalCalendar.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.IconButton obj = (com.smartgwt.client.widgets.IconButton) com.smartgwt.client.widgets.IconButton.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SQLPagingStrategy[] objects = new com.smartgwt.client.types.SQLPagingStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SQLPagingStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.SQLPagingStrategy.values(), value);

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

            com.smartgwt.client.widgets.layout.SectionHeader obj = (com.smartgwt.client.widgets.layout.SectionHeader) com.smartgwt.client.widgets.layout.SectionHeader.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.rpc.CreateScreenSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.rpc.CreateScreenSettings[]
	 */
    public static com.smartgwt.client.rpc.CreateScreenSettings[] arrayOfCreateScreenSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.rpc.CreateScreenSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.rpc.CreateScreenSettings[] ret = new com.smartgwt.client.rpc.CreateScreenSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.rpc.CreateScreenSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.rpc.CreateScreenSettings[] objects = new com.smartgwt.client.rpc.CreateScreenSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.rpc.CreateScreenSettings obj = (com.smartgwt.client.rpc.CreateScreenSettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.rpc.CreateScreenSettings(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TitleRotationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TitleRotationMode[]
	 */
    public static com.smartgwt.client.types.TitleRotationMode[] arrayOfTitleRotationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TitleRotationMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TitleRotationMode[] objects = new com.smartgwt.client.types.TitleRotationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TitleRotationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TitleRotationMode.values(), value);

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

            com.smartgwt.client.widgets.grid.DateGrid obj = (com.smartgwt.client.widgets.grid.DateGrid) com.smartgwt.client.widgets.grid.DateGrid.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.JoinType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.JoinType[]
	 */
    public static com.smartgwt.client.types.JoinType[] arrayOfJoinType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.JoinType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.JoinType[] objects = new com.smartgwt.client.types.JoinType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JoinType obj = EnumUtil.getEnum(com.smartgwt.client.types.JoinType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EditCompletionEvent[] objects = new com.smartgwt.client.types.EditCompletionEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EditCompletionEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.EditCompletionEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ReorderPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ReorderPosition[]
	 */
    public static com.smartgwt.client.types.ReorderPosition[] arrayOfReorderPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ReorderPosition[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ReorderPosition[] objects = new com.smartgwt.client.types.ReorderPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ReorderPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.ReorderPosition.values(), value);

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
	 * {@link com.smartgwt.client.tools.DrawPaneEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.DrawPaneEditProxy[]
	 */
    public static com.smartgwt.client.tools.DrawPaneEditProxy[] arrayOfDrawPaneEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.DrawPaneEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.DrawPaneEditProxy[] objects = new com.smartgwt.client.tools.DrawPaneEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.DrawPaneEditProxy obj = (com.smartgwt.client.tools.DrawPaneEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.DrawPaneEditProxy(components[i]));
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

            com.smartgwt.client.widgets.StatefulCanvas obj = (com.smartgwt.client.widgets.StatefulCanvas) com.smartgwt.client.widgets.StatefulCanvas.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.LinkItem obj = com.smartgwt.client.widgets.form.fields.LinkItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.form.fields.RichTextItem obj = com.smartgwt.client.widgets.form.fields.RichTextItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.rte.ListProperties} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.rte.ListProperties[]
	 */
    public static com.smartgwt.client.widgets.rte.ListProperties[] arrayOfListProperties(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.rte.ListProperties[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.rte.ListProperties[] ret = new com.smartgwt.client.widgets.rte.ListProperties[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.rte.ListProperties(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.rte.ListProperties[] objects = new com.smartgwt.client.widgets.rte.ListProperties[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.rte.ListProperties obj = (com.smartgwt.client.widgets.rte.ListProperties) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.rte.ListProperties(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectionType[] objects = new com.smartgwt.client.types.SelectionType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionType obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.GridRenderer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.GridRenderer[]
	 */
    public static com.smartgwt.client.widgets.grid.GridRenderer[] arrayOfGridRenderer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.GridRenderer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.GridRenderer[] objects = new com.smartgwt.client.widgets.grid.GridRenderer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.GridRenderer obj = (com.smartgwt.client.widgets.grid.GridRenderer) com.smartgwt.client.widgets.grid.GridRenderer.getByJSObject(components[i]);

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

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.CellSelection[] objects = new com.smartgwt.client.widgets.grid.CellSelection[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.CellSelection obj = (com.smartgwt.client.widgets.grid.CellSelection) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.grid.CellSelection(components[i]));
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

            com.smartgwt.client.widgets.grid.GroupSummary obj = com.smartgwt.client.widgets.grid.GroupSummary.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.DrawItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.DrawItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.DrawItemEditProxy[] arrayOfDrawItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.DrawItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.DrawItemEditProxy[] objects = new com.smartgwt.client.tools.DrawItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.DrawItemEditProxy obj = (com.smartgwt.client.tools.DrawItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.DrawItemEditProxy(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.JSONInstanceSerializationMode[] objects = new com.smartgwt.client.types.JSONInstanceSerializationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONInstanceSerializationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONInstanceSerializationMode.values(), value);

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

            com.smartgwt.client.widgets.drawing.Point obj = com.smartgwt.client.widgets.drawing.Point.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.MenuEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.MenuEditProxy[]
	 */
    public static com.smartgwt.client.tools.MenuEditProxy[] arrayOfMenuEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.MenuEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.MenuEditProxy[] objects = new com.smartgwt.client.tools.MenuEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.MenuEditProxy obj = (com.smartgwt.client.tools.MenuEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.MenuEditProxy(components[i]));
            }

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

            com.smartgwt.client.widgets.drawing.DrawPath obj = (com.smartgwt.client.widgets.drawing.DrawPath) com.smartgwt.client.widgets.drawing.DrawPath.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.HiliteIconPosition[] objects = new com.smartgwt.client.types.HiliteIconPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HiliteIconPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.HiliteIconPosition.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TableMode[] objects = new com.smartgwt.client.types.TableMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TableMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TableMode.values(), value);

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

            com.smartgwt.client.widgets.plugins.BrowserPlugin obj = (com.smartgwt.client.widgets.plugins.BrowserPlugin) com.smartgwt.client.widgets.plugins.BrowserPlugin.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DragDataAction[] objects = new com.smartgwt.client.types.DragDataAction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragDataAction obj = EnumUtil.getEnum(com.smartgwt.client.types.DragDataAction.values(), value);

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

            com.smartgwt.client.widgets.FieldPickerWindow obj = (com.smartgwt.client.widgets.FieldPickerWindow) com.smartgwt.client.widgets.FieldPickerWindow.getByJSObject(components[i]);

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

            com.smartgwt.client.data.DataSource obj = (com.smartgwt.client.data.DataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.DataSource(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.FormItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.FormItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.FormItemEditProxy[] arrayOfFormItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.FormItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.FormItemEditProxy[] objects = new com.smartgwt.client.tools.FormItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.FormItemEditProxy obj = (com.smartgwt.client.tools.FormItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.FormItemEditProxy(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ClickMaskMode[] objects = new com.smartgwt.client.types.ClickMaskMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ClickMaskMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ClickMaskMode.values(), value);

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

            com.smartgwt.client.widgets.menu.MenuBar obj = (com.smartgwt.client.widgets.menu.MenuBar) com.smartgwt.client.widgets.menu.MenuBar.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LoadState[] objects = new com.smartgwt.client.types.LoadState[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LoadState obj = EnumUtil.getEnum(com.smartgwt.client.types.LoadState.values(), value);

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

            com.smartgwt.client.widgets.RangeSlider obj = (com.smartgwt.client.widgets.RangeSlider) com.smartgwt.client.widgets.RangeSlider.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Overflow[] objects = new com.smartgwt.client.types.Overflow[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Overflow obj = EnumUtil.getEnum(com.smartgwt.client.types.Overflow.values(), value);

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
	 * {@link com.smartgwt.client.types.ListGridComponent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListGridComponent[]
	 */
    public static com.smartgwt.client.types.ListGridComponent[] arrayOfListGridComponent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListGridComponent[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ListGridComponent[] objects = new com.smartgwt.client.types.ListGridComponent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridComponent obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridComponent.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DataLineType[] objects = new com.smartgwt.client.types.DataLineType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DataLineType obj = EnumUtil.getEnum(com.smartgwt.client.types.DataLineType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PartialCommitOption[] objects = new com.smartgwt.client.types.PartialCommitOption[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PartialCommitOption obj = EnumUtil.getEnum(com.smartgwt.client.types.PartialCommitOption.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ValidationMode[] objects = new com.smartgwt.client.types.ValidationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValidationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ValidationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.StatefulCanvasEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.StatefulCanvasEditProxy[]
	 */
    public static com.smartgwt.client.tools.StatefulCanvasEditProxy[] arrayOfStatefulCanvasEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.StatefulCanvasEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.StatefulCanvasEditProxy[] objects = new com.smartgwt.client.tools.StatefulCanvasEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.StatefulCanvasEditProxy obj = (com.smartgwt.client.tools.StatefulCanvasEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.StatefulCanvasEditProxy(components[i]));
            }

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

            com.smartgwt.client.widgets.Button obj = (com.smartgwt.client.widgets.Button) com.smartgwt.client.widgets.Button.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.RowSpacerItem obj = com.smartgwt.client.widgets.form.fields.RowSpacerItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.form.fields.TimeItem obj = com.smartgwt.client.widgets.form.fields.TimeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceRenderer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceRenderer[]
	 */
    public static com.smartgwt.client.widgets.ace.AceRenderer[] arrayOfAceRenderer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceRenderer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceRenderer[] objects = new com.smartgwt.client.widgets.ace.AceRenderer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceRenderer obj = (com.smartgwt.client.widgets.ace.AceRenderer) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceRenderer(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoFitEvent[] objects = new com.smartgwt.client.types.AutoFitEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceAnchor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceAnchor[]
	 */
    public static com.smartgwt.client.widgets.ace.AceAnchor[] arrayOfAceAnchor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceAnchor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceAnchor[] objects = new com.smartgwt.client.widgets.ace.AceAnchor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceAnchor obj = (com.smartgwt.client.widgets.ace.AceAnchor) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceAnchor(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PickListItemIconPlacement} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PickListItemIconPlacement[]
	 */
    public static com.smartgwt.client.types.PickListItemIconPlacement[] arrayOfPickListItemIconPlacement(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PickListItemIconPlacement[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PickListItemIconPlacement[] objects = new com.smartgwt.client.types.PickListItemIconPlacement[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PickListItemIconPlacement obj = EnumUtil.getEnum(com.smartgwt.client.types.PickListItemIconPlacement.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ArrowStyle[] objects = new com.smartgwt.client.types.ArrowStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ArrowStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.ArrowStyle.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectionAppearance[] objects = new com.smartgwt.client.types.SelectionAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionAppearance.values(), value);

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

            com.smartgwt.client.widgets.form.fields.CanvasItem obj = com.smartgwt.client.widgets.form.fields.CanvasItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.HashAlgorithm[] objects = new com.smartgwt.client.types.HashAlgorithm[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HashAlgorithm obj = EnumUtil.getEnum(com.smartgwt.client.types.HashAlgorithm.values(), value);

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

            com.smartgwt.client.widgets.layout.Portlet obj = (com.smartgwt.client.widgets.layout.Portlet) com.smartgwt.client.widgets.layout.Portlet.getByJSObject(components[i]);

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

            com.smartgwt.client.data.Hilite obj = com.smartgwt.client.data.Hilite.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ArrowKeyEditAction} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ArrowKeyEditAction[]
	 */
    public static com.smartgwt.client.types.ArrowKeyEditAction[] arrayOfArrowKeyEditAction(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ArrowKeyEditAction[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ArrowKeyEditAction[] objects = new com.smartgwt.client.types.ArrowKeyEditAction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ArrowKeyEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.ArrowKeyEditAction.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.OperatorId[] objects = new com.smartgwt.client.types.OperatorId[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.OperatorId obj = EnumUtil.getEnum(com.smartgwt.client.types.OperatorId.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TitleAlign} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TitleAlign[]
	 */
    public static com.smartgwt.client.types.TitleAlign[] arrayOfTitleAlign(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TitleAlign[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TitleAlign[] objects = new com.smartgwt.client.types.TitleAlign[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TitleAlign obj = EnumUtil.getEnum(com.smartgwt.client.types.TitleAlign.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ViewName[] objects = new com.smartgwt.client.types.ViewName[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ViewName obj = EnumUtil.getEnum(com.smartgwt.client.types.ViewName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DataURLFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DataURLFormat[]
	 */
    public static com.smartgwt.client.types.DataURLFormat[] arrayOfDataURLFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DataURLFormat[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DataURLFormat[] objects = new com.smartgwt.client.types.DataURLFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DataURLFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DataURLFormat.values(), value);

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

            com.smartgwt.client.widgets.Scrollbar obj = (com.smartgwt.client.widgets.Scrollbar) com.smartgwt.client.widgets.Scrollbar.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.drawing.DrawPolygon obj = (com.smartgwt.client.widgets.drawing.DrawPolygon) com.smartgwt.client.widgets.drawing.DrawPolygon.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.StackDirection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.StackDirection[]
	 */
    public static com.smartgwt.client.types.StackDirection[] arrayOfStackDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.StackDirection[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.StackDirection[] objects = new com.smartgwt.client.types.StackDirection[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.StackDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.StackDirection.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.OperatorValueType[] objects = new com.smartgwt.client.types.OperatorValueType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.OperatorValueType obj = EnumUtil.getEnum(com.smartgwt.client.types.OperatorValueType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.CheckboxItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.CheckboxItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.CheckboxItemEditProxy[] arrayOfCheckboxItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.CheckboxItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.CheckboxItemEditProxy[] objects = new com.smartgwt.client.tools.CheckboxItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.CheckboxItemEditProxy obj = (com.smartgwt.client.tools.CheckboxItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.CheckboxItemEditProxy(components[i]));
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

            com.smartgwt.client.widgets.DateRangeDialog obj = (com.smartgwt.client.widgets.DateRangeDialog) com.smartgwt.client.widgets.DateRangeDialog.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DisplayNodeType[] objects = new com.smartgwt.client.types.DisplayNodeType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DisplayNodeType obj = EnumUtil.getEnum(com.smartgwt.client.types.DisplayNodeType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.PortalPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.PortalPosition[]
	 */
    public static com.smartgwt.client.widgets.layout.PortalPosition[] arrayOfPortalPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.PortalPosition[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.layout.PortalPosition[] ret = new com.smartgwt.client.widgets.layout.PortalPosition[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.layout.PortalPosition(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.PortalPosition[] objects = new com.smartgwt.client.widgets.layout.PortalPosition[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.PortalPosition obj = (com.smartgwt.client.widgets.layout.PortalPosition) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.PortalPosition(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask[] arrayOfGridRemoveSelectedDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask[] objects = new com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask obj = (com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridRemoveSelectedDataTask(components[i]));
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

            com.smartgwt.client.widgets.drawing.DrawItem obj = (com.smartgwt.client.widgets.drawing.DrawItem) com.smartgwt.client.widgets.drawing.DrawItem.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ContentsType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ContentsType[]
	 */
    public static com.smartgwt.client.types.ContentsType[] arrayOfContentsType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ContentsType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ContentsType[] objects = new com.smartgwt.client.types.ContentsType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ContentsType obj = EnumUtil.getEnum(com.smartgwt.client.types.ContentsType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PointShape} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PointShape[]
	 */
    public static com.smartgwt.client.types.PointShape[] arrayOfPointShape(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PointShape[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PointShape[] objects = new com.smartgwt.client.types.PointShape[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PointShape obj = EnumUtil.getEnum(com.smartgwt.client.types.PointShape.values(), value);

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

            com.smartgwt.client.widgets.HTMLFlow obj = (com.smartgwt.client.widgets.HTMLFlow) com.smartgwt.client.widgets.HTMLFlow.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.StackPersistence} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.StackPersistence[]
	 */
    public static com.smartgwt.client.types.StackPersistence[] arrayOfStackPersistence(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.StackPersistence[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.StackPersistence[] objects = new com.smartgwt.client.types.StackPersistence[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.StackPersistence obj = EnumUtil.getEnum(com.smartgwt.client.types.StackPersistence.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.CanvasEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.CanvasEditProxy[]
	 */
    public static com.smartgwt.client.tools.CanvasEditProxy[] arrayOfCanvasEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.CanvasEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.CanvasEditProxy[] objects = new com.smartgwt.client.tools.CanvasEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.CanvasEditProxy obj = (com.smartgwt.client.tools.CanvasEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.CanvasEditProxy(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TitleOrientation[] objects = new com.smartgwt.client.types.TitleOrientation[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TitleOrientation obj = EnumUtil.getEnum(com.smartgwt.client.types.TitleOrientation.values(), value);

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

            com.smartgwt.client.widgets.tab.TabBar obj = (com.smartgwt.client.widgets.tab.TabBar) com.smartgwt.client.widgets.tab.TabBar.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.viewer.DetailViewer obj = (com.smartgwt.client.widgets.viewer.DetailViewer) com.smartgwt.client.widgets.viewer.DetailViewer.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceEditSession} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceEditSession[]
	 */
    public static com.smartgwt.client.widgets.ace.AceEditSession[] arrayOfAceEditSession(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceEditSession[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceEditSession[] objects = new com.smartgwt.client.widgets.ace.AceEditSession[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceEditSession obj = (com.smartgwt.client.widgets.ace.AceEditSession) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceEditSession(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DragTrackerMode[] objects = new com.smartgwt.client.types.DragTrackerMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragTrackerMode obj = EnumUtil.getEnum(com.smartgwt.client.types.DragTrackerMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecordSummaryFunctionType[] objects = new com.smartgwt.client.types.RecordSummaryFunctionType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordSummaryFunctionType obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordSummaryFunctionType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ImageStyle[] objects = new com.smartgwt.client.types.ImageStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ImageStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.ImageStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TitleAutoFitRotationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TitleAutoFitRotationMode[]
	 */
    public static com.smartgwt.client.types.TitleAutoFitRotationMode[] arrayOfTitleAutoFitRotationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TitleAutoFitRotationMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TitleAutoFitRotationMode[] objects = new com.smartgwt.client.types.TitleAutoFitRotationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TitleAutoFitRotationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TitleAutoFitRotationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MultiSortDialog} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MultiSortDialog[]
	 */
    public static com.smartgwt.client.widgets.MultiSortDialog[] arrayOfMultiSortDialog(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MultiSortDialog[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MultiSortDialog[] objects = new com.smartgwt.client.widgets.MultiSortDialog[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MultiSortDialog obj = (com.smartgwt.client.widgets.MultiSortDialog) com.smartgwt.client.widgets.MultiSortDialog.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.grid.HiliteRule obj = (com.smartgwt.client.widgets.grid.HiliteRule) com.smartgwt.client.widgets.grid.HiliteRule.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.TextItem obj = com.smartgwt.client.widgets.form.fields.TextItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.data.Record obj = com.smartgwt.client.data.Record.getOrCreateRef(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TileLayoutPolicy[] objects = new com.smartgwt.client.types.TileLayoutPolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TileLayoutPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.TileLayoutPolicy.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EscapingMode[] objects = new com.smartgwt.client.types.EscapingMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EscapingMode obj = EnumUtil.getEnum(com.smartgwt.client.types.EscapingMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DateItemSelectorFormat[] objects = new com.smartgwt.client.types.DateItemSelectorFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateItemSelectorFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DateItemSelectorFormat.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.JSONDateFormat[] objects = new com.smartgwt.client.types.JSONDateFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONDateFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONDateFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.MockDataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.MockDataSource[]
	 */
    public static com.smartgwt.client.data.MockDataSource[] arrayOfMockDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.MockDataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.MockDataSource[] objects = new com.smartgwt.client.data.MockDataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.MockDataSource obj = (com.smartgwt.client.data.MockDataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.MockDataSource(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TimeDisplayFormat[] objects = new com.smartgwt.client.types.TimeDisplayFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TimeDisplayFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.TimeDisplayFormat.values(), value);

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

            com.smartgwt.client.widgets.form.fields.UploadItem obj = com.smartgwt.client.widgets.form.fields.UploadItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SortDirection[] objects = new com.smartgwt.client.types.SortDirection[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SortDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.SortDirection.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LinkDataFetchMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LinkDataFetchMode[]
	 */
    public static com.smartgwt.client.types.LinkDataFetchMode[] arrayOfLinkDataFetchMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LinkDataFetchMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LinkDataFetchMode[] objects = new com.smartgwt.client.types.LinkDataFetchMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LinkDataFetchMode obj = EnumUtil.getEnum(com.smartgwt.client.types.LinkDataFetchMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.AskForValueTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.AskForValueTask[]
	 */
    public static com.smartgwt.client.util.workflow.AskForValueTask[] arrayOfAskForValueTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.AskForValueTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.AskForValueTask[] objects = new com.smartgwt.client.util.workflow.AskForValueTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.AskForValueTask obj = (com.smartgwt.client.util.workflow.AskForValueTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.AskForValueTask(components[i]));
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

            com.smartgwt.client.widgets.calendar.HeaderLevel obj = com.smartgwt.client.widgets.calendar.HeaderLevel.getOrCreateRef(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TextMatchStyle[] objects = new com.smartgwt.client.types.TextMatchStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TextMatchStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.TextMatchStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.HoopSelectionStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.HoopSelectionStyle[]
	 */
    public static com.smartgwt.client.types.HoopSelectionStyle[] arrayOfHoopSelectionStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.HoopSelectionStyle[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.HoopSelectionStyle[] objects = new com.smartgwt.client.types.HoopSelectionStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HoopSelectionStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.HoopSelectionStyle.values(), value);

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

            com.smartgwt.client.widgets.layout.PortalLayout obj = (com.smartgwt.client.widgets.layout.PortalLayout) com.smartgwt.client.widgets.layout.PortalLayout.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.Progressbar obj = (com.smartgwt.client.widgets.Progressbar) com.smartgwt.client.widgets.Progressbar.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DragMaskType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DragMaskType[]
	 */
    public static com.smartgwt.client.types.DragMaskType[] arrayOfDragMaskType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DragMaskType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DragMaskType[] objects = new com.smartgwt.client.types.DragMaskType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragMaskType obj = EnumUtil.getEnum(com.smartgwt.client.types.DragMaskType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ListGridEditEvent[] objects = new com.smartgwt.client.types.ListGridEditEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridEditEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridEditEvent.values(), value);

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

            com.smartgwt.client.widgets.form.fields.ViewFileItem obj = com.smartgwt.client.widgets.form.fields.ViewFileItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.IButton obj = (com.smartgwt.client.widgets.IButton) com.smartgwt.client.widgets.IButton.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.FilterBuilder obj = (com.smartgwt.client.widgets.form.FilterBuilder) com.smartgwt.client.widgets.form.FilterBuilder.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ColorPickerMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ColorPickerMode[]
	 */
    public static com.smartgwt.client.types.ColorPickerMode[] arrayOfColorPickerMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ColorPickerMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ColorPickerMode[] objects = new com.smartgwt.client.types.ColorPickerMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ColorPickerMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ColorPickerMode.values(), value);

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

            com.smartgwt.client.widgets.toolbar.ToolStrip obj = (com.smartgwt.client.widgets.toolbar.ToolStrip) com.smartgwt.client.widgets.toolbar.ToolStrip.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DSDataFormat[] objects = new com.smartgwt.client.types.DSDataFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSDataFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DSDataFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MultiGroupPanel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MultiGroupPanel[]
	 */
    public static com.smartgwt.client.widgets.MultiGroupPanel[] arrayOfMultiGroupPanel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MultiGroupPanel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MultiGroupPanel[] objects = new com.smartgwt.client.widgets.MultiGroupPanel[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MultiGroupPanel obj = (com.smartgwt.client.widgets.MultiGroupPanel) com.smartgwt.client.widgets.MultiGroupPanel.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.NavigateDetailPaneTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.NavigateDetailPaneTask[]
	 */
    public static com.smartgwt.client.util.workflow.NavigateDetailPaneTask[] arrayOfNavigateDetailPaneTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.NavigateDetailPaneTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.NavigateDetailPaneTask[] objects = new com.smartgwt.client.util.workflow.NavigateDetailPaneTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.NavigateDetailPaneTask obj = (com.smartgwt.client.util.workflow.NavigateDetailPaneTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.NavigateDetailPaneTask(components[i]));
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

            com.smartgwt.client.widgets.form.FilterClause obj = (com.smartgwt.client.widgets.form.FilterClause) com.smartgwt.client.widgets.form.FilterClause.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FacetIndentDirection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FacetIndentDirection[]
	 */
    public static com.smartgwt.client.types.FacetIndentDirection[] arrayOfFacetIndentDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FacetIndentDirection[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FacetIndentDirection[] objects = new com.smartgwt.client.types.FacetIndentDirection[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FacetIndentDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.FacetIndentDirection.values(), value);

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

            com.smartgwt.client.widgets.form.fields.DateRangeItem obj = com.smartgwt.client.widgets.form.fields.DateRangeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Positioning[] objects = new com.smartgwt.client.types.Positioning[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Positioning obj = EnumUtil.getEnum(com.smartgwt.client.types.Positioning.values(), value);

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
	 * {@link com.smartgwt.client.types.SummaryFunctionType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SummaryFunctionType[]
	 */
    public static com.smartgwt.client.types.SummaryFunctionType[] arrayOfSummaryFunctionType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SummaryFunctionType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SummaryFunctionType[] objects = new com.smartgwt.client.types.SummaryFunctionType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SummaryFunctionType obj = EnumUtil.getEnum(com.smartgwt.client.types.SummaryFunctionType.values(), value);

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

            com.smartgwt.client.widgets.ImgSplitbar obj = (com.smartgwt.client.widgets.ImgSplitbar) com.smartgwt.client.widgets.ImgSplitbar.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.tree.TreeGrid obj = (com.smartgwt.client.widgets.tree.TreeGrid) com.smartgwt.client.widgets.tree.TreeGrid.getByJSObject(components[i]);

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
	 * {@link com.smartgwt.client.types.MaxStackDismissMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MaxStackDismissMode[]
	 */
    public static com.smartgwt.client.types.MaxStackDismissMode[] arrayOfMaxStackDismissMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MaxStackDismissMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MaxStackDismissMode[] objects = new com.smartgwt.client.types.MaxStackDismissMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MaxStackDismissMode obj = EnumUtil.getEnum(com.smartgwt.client.types.MaxStackDismissMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SkipJSONValidation} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SkipJSONValidation[]
	 */
    public static com.smartgwt.client.types.SkipJSONValidation[] arrayOfSkipJSONValidation(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SkipJSONValidation[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SkipJSONValidation[] objects = new com.smartgwt.client.types.SkipJSONValidation[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SkipJSONValidation obj = EnumUtil.getEnum(com.smartgwt.client.types.SkipJSONValidation.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ReadOnlyDisplayAppearance[] objects = new com.smartgwt.client.types.ReadOnlyDisplayAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ReadOnlyDisplayAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.ReadOnlyDisplayAppearance.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PageOrientation[] objects = new com.smartgwt.client.types.PageOrientation[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PageOrientation obj = EnumUtil.getEnum(com.smartgwt.client.types.PageOrientation.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LabelAlignment} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LabelAlignment[]
	 */
    public static com.smartgwt.client.types.LabelAlignment[] arrayOfLabelAlignment(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LabelAlignment[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LabelAlignment[] objects = new com.smartgwt.client.types.LabelAlignment[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LabelAlignment obj = EnumUtil.getEnum(com.smartgwt.client.types.LabelAlignment.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.DetailViewerEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.DetailViewerEditProxy[]
	 */
    public static com.smartgwt.client.tools.DetailViewerEditProxy[] arrayOfDetailViewerEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.DetailViewerEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.DetailViewerEditProxy[] objects = new com.smartgwt.client.tools.DetailViewerEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.DetailViewerEditProxy obj = (com.smartgwt.client.tools.DetailViewerEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.DetailViewerEditProxy(components[i]));
            }

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

            com.smartgwt.client.util.workflow.UserTask obj = (com.smartgwt.client.util.workflow.UserTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.UserTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.HoverMode[] objects = new com.smartgwt.client.types.HoverMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.HoverMode obj = EnumUtil.getEnum(com.smartgwt.client.types.HoverMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.CriteriaPolicy[] objects = new com.smartgwt.client.types.CriteriaPolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CriteriaPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.CriteriaPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PickerIconName} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PickerIconName[]
	 */
    public static com.smartgwt.client.types.PickerIconName[] arrayOfPickerIconName(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PickerIconName[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PickerIconName[] objects = new com.smartgwt.client.types.PickerIconName[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PickerIconName obj = EnumUtil.getEnum(com.smartgwt.client.types.PickerIconName.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ConnectorOrientation} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ConnectorOrientation[]
	 */
    public static com.smartgwt.client.types.ConnectorOrientation[] arrayOfConnectorOrientation(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ConnectorOrientation[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ConnectorOrientation[] objects = new com.smartgwt.client.types.ConnectorOrientation[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ConnectorOrientation obj = EnumUtil.getEnum(com.smartgwt.client.types.ConnectorOrientation.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Alignment[] objects = new com.smartgwt.client.types.Alignment[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Alignment obj = EnumUtil.getEnum(com.smartgwt.client.types.Alignment.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ProcessValueType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ProcessValueType[]
	 */
    public static com.smartgwt.client.types.ProcessValueType[] arrayOfProcessValueType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ProcessValueType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ProcessValueType[] objects = new com.smartgwt.client.types.ProcessValueType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ProcessValueType obj = EnumUtil.getEnum(com.smartgwt.client.types.ProcessValueType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ExpansionMode[] objects = new com.smartgwt.client.types.ExpansionMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExpansionMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ExpansionMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawShapeCommand} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawShapeCommand[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawShapeCommand[] arrayOfDrawShapeCommand(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawShapeCommand[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.drawing.DrawShapeCommand[] ret = new com.smartgwt.client.widgets.drawing.DrawShapeCommand[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.drawing.DrawShapeCommand(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawShapeCommand[] objects = new com.smartgwt.client.widgets.drawing.DrawShapeCommand[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawShapeCommand obj = (com.smartgwt.client.widgets.drawing.DrawShapeCommand) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.drawing.DrawShapeCommand(components[i]));
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

            com.smartgwt.client.widgets.form.fields.SelectItem obj = com.smartgwt.client.widgets.form.fields.SelectItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.LabelEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.LabelEditProxy[]
	 */
    public static com.smartgwt.client.tools.LabelEditProxy[] arrayOfLabelEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.LabelEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.LabelEditProxy[] objects = new com.smartgwt.client.tools.LabelEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.LabelEditProxy obj = (com.smartgwt.client.tools.LabelEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.LabelEditProxy(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FieldType[] objects = new com.smartgwt.client.types.FieldType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldType.values(), value);

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

            com.smartgwt.client.widgets.Snapbar obj = (com.smartgwt.client.widgets.Snapbar) com.smartgwt.client.widgets.Snapbar.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FieldNamingStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FieldNamingStrategy[]
	 */
    public static com.smartgwt.client.types.FieldNamingStrategy[] arrayOfFieldNamingStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FieldNamingStrategy[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FieldNamingStrategy[] objects = new com.smartgwt.client.types.FieldNamingStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldNamingStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldNamingStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.ListPalette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.ListPalette[]
	 */
    public static com.smartgwt.client.tools.ListPalette[] arrayOfListPalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.ListPalette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.ListPalette[] objects = new com.smartgwt.client.tools.ListPalette[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.ListPalette obj = (com.smartgwt.client.tools.ListPalette) com.smartgwt.client.tools.ListPalette.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.grid.AdvancedHiliteEditor obj = (com.smartgwt.client.widgets.grid.AdvancedHiliteEditor) com.smartgwt.client.widgets.grid.AdvancedHiliteEditor.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PageEvent[] objects = new com.smartgwt.client.types.PageEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PageEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.PageEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.DSLoadSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.DSLoadSettings[]
	 */
    public static com.smartgwt.client.data.DSLoadSettings[] arrayOfDSLoadSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.DSLoadSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.DSLoadSettings[] ret = new com.smartgwt.client.data.DSLoadSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.DSLoadSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.DSLoadSettings[] objects = new com.smartgwt.client.data.DSLoadSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.DSLoadSettings obj = (com.smartgwt.client.data.DSLoadSettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.DSLoadSettings(components[i]));
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

            com.smartgwt.client.util.workflow.Task obj = (com.smartgwt.client.util.workflow.Task) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.Task(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.DiscoverTreeSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.DiscoverTreeSettings[]
	 */
    public static com.smartgwt.client.widgets.tree.DiscoverTreeSettings[] arrayOfDiscoverTreeSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.DiscoverTreeSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.tree.DiscoverTreeSettings[] ret = new com.smartgwt.client.widgets.tree.DiscoverTreeSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.tree.DiscoverTreeSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.DiscoverTreeSettings[] objects = new com.smartgwt.client.widgets.tree.DiscoverTreeSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.DiscoverTreeSettings obj = (com.smartgwt.client.widgets.tree.DiscoverTreeSettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.DiscoverTreeSettings(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LocatorStrategy[] objects = new com.smartgwt.client.types.LocatorStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LocatorStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.LocatorStrategy.values(), value);

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

            com.smartgwt.client.widgets.form.fields.SliderItem obj = com.smartgwt.client.widgets.form.fields.SliderItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Cursor[] objects = new com.smartgwt.client.types.Cursor[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Cursor obj = EnumUtil.getEnum(com.smartgwt.client.types.Cursor.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SequenceMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SequenceMode[]
	 */
    public static com.smartgwt.client.types.SequenceMode[] arrayOfSequenceMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SequenceMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SequenceMode[] objects = new com.smartgwt.client.types.SequenceMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SequenceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.SequenceMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ImportFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ImportFormat[]
	 */
    public static com.smartgwt.client.types.ImportFormat[] arrayOfImportFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ImportFormat[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ImportFormat[] objects = new com.smartgwt.client.types.ImportFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ImportFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.ImportFormat.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FetchMode[] objects = new com.smartgwt.client.types.FetchMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FetchMode obj = EnumUtil.getEnum(com.smartgwt.client.types.FetchMode.values(), value);

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

            com.smartgwt.client.widgets.NavigationButton obj = (com.smartgwt.client.widgets.NavigationButton) com.smartgwt.client.widgets.NavigationButton.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.SetLabelTextTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.SetLabelTextTask[]
	 */
    public static com.smartgwt.client.util.workflow.SetLabelTextTask[] arrayOfSetLabelTextTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.SetLabelTextTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.SetLabelTextTask[] objects = new com.smartgwt.client.util.workflow.SetLabelTextTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.SetLabelTextTask obj = (com.smartgwt.client.util.workflow.SetLabelTextTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.SetLabelTextTask(components[i]));
            }

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

            com.smartgwt.client.widgets.layout.VStack obj = (com.smartgwt.client.widgets.layout.VStack) com.smartgwt.client.widgets.layout.VStack.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RelativeDateRangePosition[] objects = new com.smartgwt.client.types.RelativeDateRangePosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RelativeDateRangePosition obj = EnumUtil.getEnum(com.smartgwt.client.types.RelativeDateRangePosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.SelectItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.SelectItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.SelectItemEditProxy[] arrayOfSelectItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.SelectItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.SelectItemEditProxy[] objects = new com.smartgwt.client.tools.SelectItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.SelectItemEditProxy obj = (com.smartgwt.client.tools.SelectItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.SelectItemEditProxy(components[i]));
            }

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

            com.smartgwt.client.util.workflow.Process obj = (com.smartgwt.client.util.workflow.Process) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.Process(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ExpansionComponentPoolingMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ExpansionComponentPoolingMode[]
	 */
    public static com.smartgwt.client.types.ExpansionComponentPoolingMode[] arrayOfExpansionComponentPoolingMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ExpansionComponentPoolingMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ExpansionComponentPoolingMode[] objects = new com.smartgwt.client.types.ExpansionComponentPoolingMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExpansionComponentPoolingMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ExpansionComponentPoolingMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.SetButtonTitleTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.SetButtonTitleTask[]
	 */
    public static com.smartgwt.client.util.workflow.SetButtonTitleTask[] arrayOfSetButtonTitleTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.SetButtonTitleTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.SetButtonTitleTask[] objects = new com.smartgwt.client.util.workflow.SetButtonTitleTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.SetButtonTitleTask obj = (com.smartgwt.client.util.workflow.SetButtonTitleTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.SetButtonTitleTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EnterKeyEditAction[] objects = new com.smartgwt.client.types.EnterKeyEditAction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EnterKeyEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.EnterKeyEditAction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.GridEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.GridEditProxy[]
	 */
    public static com.smartgwt.client.tools.GridEditProxy[] arrayOfGridEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.GridEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.GridEditProxy[] objects = new com.smartgwt.client.tools.GridEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.GridEditProxy obj = (com.smartgwt.client.tools.GridEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.GridEditProxy(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoFitWidthApproach[] objects = new com.smartgwt.client.types.AutoFitWidthApproach[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitWidthApproach obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitWidthApproach.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.rpc.LoadProjectSettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.rpc.LoadProjectSettings[]
	 */
    public static com.smartgwt.client.rpc.LoadProjectSettings[] arrayOfLoadProjectSettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.rpc.LoadProjectSettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.rpc.LoadProjectSettings[] ret = new com.smartgwt.client.rpc.LoadProjectSettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.rpc.LoadProjectSettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.rpc.LoadProjectSettings[] objects = new com.smartgwt.client.rpc.LoadProjectSettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.rpc.LoadProjectSettings obj = (com.smartgwt.client.rpc.LoadProjectSettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.rpc.LoadProjectSettings(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FormItemElementType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FormItemElementType[]
	 */
    public static com.smartgwt.client.types.FormItemElementType[] arrayOfFormItemElementType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FormItemElementType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FormItemElementType[] objects = new com.smartgwt.client.types.FormItemElementType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FormItemElementType obj = EnumUtil.getEnum(com.smartgwt.client.types.FormItemElementType.values(), value);

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

            com.smartgwt.client.widgets.ViewLoader obj = (com.smartgwt.client.widgets.ViewLoader) com.smartgwt.client.widgets.ViewLoader.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SendMethod[] objects = new com.smartgwt.client.types.SendMethod[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SendMethod obj = EnumUtil.getEnum(com.smartgwt.client.types.SendMethod.values(), value);

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

            com.smartgwt.client.widgets.form.fields.TextAreaItem obj = com.smartgwt.client.widgets.form.fields.TextAreaItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.Slider obj = (com.smartgwt.client.widgets.Slider) com.smartgwt.client.widgets.Slider.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AnimationLayoutMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AnimationLayoutMode[]
	 */
    public static com.smartgwt.client.types.AnimationLayoutMode[] arrayOfAnimationLayoutMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AnimationLayoutMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AnimationLayoutMode[] objects = new com.smartgwt.client.types.AnimationLayoutMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AnimationLayoutMode obj = EnumUtil.getEnum(com.smartgwt.client.types.AnimationLayoutMode.values(), value);

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

            com.smartgwt.client.widgets.form.fields.FileItem obj = com.smartgwt.client.widgets.form.fields.FileItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.form.fields.ComboBoxItem obj = com.smartgwt.client.widgets.form.fields.ComboBoxItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.SyntaxHiliter} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.SyntaxHiliter[]
	 */
    public static com.smartgwt.client.util.SyntaxHiliter[] arrayOfSyntaxHiliter(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.SyntaxHiliter[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.SyntaxHiliter[] objects = new com.smartgwt.client.util.SyntaxHiliter[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.SyntaxHiliter obj = (com.smartgwt.client.util.SyntaxHiliter) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.SyntaxHiliter(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ListGridViewStatePart} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListGridViewStatePart[]
	 */
    public static com.smartgwt.client.types.ListGridViewStatePart[] arrayOfListGridViewStatePart(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListGridViewStatePart[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ListGridViewStatePart[] objects = new com.smartgwt.client.types.ListGridViewStatePart[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridViewStatePart obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridViewStatePart.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.EditNode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.EditNode[]
	 */
    public static com.smartgwt.client.tools.EditNode[] arrayOfEditNode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.EditNode[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.tools.EditNode[] ret = new com.smartgwt.client.tools.EditNode[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.tools.EditNode(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.EditNode[] objects = new com.smartgwt.client.tools.EditNode[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.EditNode obj = (com.smartgwt.client.tools.EditNode) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.EditNode(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.rte.ListPropertiesDialog} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.rte.ListPropertiesDialog[]
	 */
    public static com.smartgwt.client.widgets.rte.ListPropertiesDialog[] arrayOfListPropertiesDialog(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.rte.ListPropertiesDialog[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.rte.ListPropertiesDialog[] objects = new com.smartgwt.client.widgets.rte.ListPropertiesDialog[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.rte.ListPropertiesDialog obj = (com.smartgwt.client.widgets.rte.ListPropertiesDialog) com.smartgwt.client.widgets.rte.ListPropertiesDialog.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormHideFieldTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormHideFieldTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormHideFieldTask[] arrayOfFormHideFieldTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormHideFieldTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormHideFieldTask[] objects = new com.smartgwt.client.util.workflow.FormHideFieldTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormHideFieldTask obj = (com.smartgwt.client.util.workflow.FormHideFieldTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormHideFieldTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TreeFilterMode[] objects = new com.smartgwt.client.types.TreeFilterMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TreeFilterMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TreeFilterMode.values(), value);

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

            com.smartgwt.client.widgets.form.fields.PickTreeItem obj = com.smartgwt.client.widgets.form.fields.PickTreeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.EditContext} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.EditContext[]
	 */
    public static com.smartgwt.client.tools.EditContext[] arrayOfEditContext(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.EditContext[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.EditContext[] objects = new com.smartgwt.client.tools.EditContext[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.EditContext obj = (com.smartgwt.client.tools.EditContext) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.EditContext(components[i]));
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

            com.smartgwt.client.widgets.tree.Tree obj = (com.smartgwt.client.widgets.tree.Tree) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.Tree(components[i]));
            }

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

            com.smartgwt.client.widgets.PrintWindow obj = (com.smartgwt.client.widgets.PrintWindow) com.smartgwt.client.widgets.PrintWindow.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ColorPickerItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ColorPickerItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ColorPickerItem[] arrayOfColorPickerItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ColorPickerItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ColorPickerItem[] objects = new com.smartgwt.client.widgets.form.fields.ColorPickerItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ColorPickerItem obj = com.smartgwt.client.widgets.form.fields.ColorPickerItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DateDisplayFormat[] objects = new com.smartgwt.client.types.DateDisplayFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateDisplayFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.DateDisplayFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ComponentTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ComponentTask[]
	 */
    public static com.smartgwt.client.util.workflow.ComponentTask[] arrayOfComponentTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ComponentTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ComponentTask[] objects = new com.smartgwt.client.util.workflow.ComponentTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ComponentTask obj = (com.smartgwt.client.util.workflow.ComponentTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ComponentTask(components[i]));
            }

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

            com.smartgwt.client.widgets.StretchImg obj = (com.smartgwt.client.widgets.StretchImg) com.smartgwt.client.widgets.StretchImg.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.TilePalette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.TilePalette[]
	 */
    public static com.smartgwt.client.tools.TilePalette[] arrayOfTilePalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.TilePalette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.TilePalette[] objects = new com.smartgwt.client.tools.TilePalette[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.TilePalette obj = (com.smartgwt.client.tools.TilePalette) com.smartgwt.client.tools.TilePalette.getByJSObject(components[i]);

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

            com.smartgwt.client.data.TextSettings obj = (com.smartgwt.client.data.TextSettings) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.TextSettings(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DateFieldLayout} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DateFieldLayout[]
	 */
    public static com.smartgwt.client.types.DateFieldLayout[] arrayOfDateFieldLayout(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DateFieldLayout[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DateFieldLayout[] objects = new com.smartgwt.client.types.DateFieldLayout[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateFieldLayout obj = EnumUtil.getEnum(com.smartgwt.client.types.DateFieldLayout.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Visibility[] objects = new com.smartgwt.client.types.Visibility[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Visibility obj = EnumUtil.getEnum(com.smartgwt.client.types.Visibility.values(), value);

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

            com.smartgwt.client.widgets.MultiFilePicker obj = (com.smartgwt.client.widgets.MultiFilePicker) com.smartgwt.client.widgets.MultiFilePicker.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ShowComponentTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ShowComponentTask[]
	 */
    public static com.smartgwt.client.util.workflow.ShowComponentTask[] arrayOfShowComponentTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ShowComponentTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ShowComponentTask[] objects = new com.smartgwt.client.util.workflow.ShowComponentTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ShowComponentTask obj = (com.smartgwt.client.util.workflow.ShowComponentTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ShowComponentTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RowEndEditAction[] objects = new com.smartgwt.client.types.RowEndEditAction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowEndEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.RowEndEditAction.values(), value);

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

            com.smartgwt.client.widgets.form.PropertySheet obj = (com.smartgwt.client.widgets.form.PropertySheet) com.smartgwt.client.widgets.form.PropertySheet.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.SearchForm obj = (com.smartgwt.client.widgets.form.SearchForm) com.smartgwt.client.widgets.form.SearchForm.getByJSObject(components[i]);

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

            com.smartgwt.client.util.workflow.DecisionGateway obj = (com.smartgwt.client.util.workflow.DecisionGateway) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.DecisionGateway(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DrawShapeCommandType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DrawShapeCommandType[]
	 */
    public static com.smartgwt.client.types.DrawShapeCommandType[] arrayOfDrawShapeCommandType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DrawShapeCommandType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DrawShapeCommandType[] objects = new com.smartgwt.client.types.DrawShapeCommandType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DrawShapeCommandType obj = EnumUtil.getEnum(com.smartgwt.client.types.DrawShapeCommandType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ResizeDirection} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ResizeDirection[]
	 */
    public static com.smartgwt.client.types.ResizeDirection[] arrayOfResizeDirection(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ResizeDirection[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ResizeDirection[] objects = new com.smartgwt.client.types.ResizeDirection[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ResizeDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.ResizeDirection.values(), value);

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
	 * {@link com.smartgwt.client.types.AnimationAcceleration} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AnimationAcceleration[]
	 */
    public static com.smartgwt.client.types.AnimationAcceleration[] arrayOfAnimationAcceleration(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AnimationAcceleration[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AnimationAcceleration[] objects = new com.smartgwt.client.types.AnimationAcceleration[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AnimationAcceleration obj = EnumUtil.getEnum(com.smartgwt.client.types.AnimationAcceleration.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.GroupSpecifier} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.GroupSpecifier[]
	 */
    public static com.smartgwt.client.data.GroupSpecifier[] arrayOfGroupSpecifier(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.GroupSpecifier[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.GroupSpecifier[] ret = new com.smartgwt.client.data.GroupSpecifier[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.GroupSpecifier(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.GroupSpecifier[] objects = new com.smartgwt.client.data.GroupSpecifier[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.GroupSpecifier obj = (com.smartgwt.client.data.GroupSpecifier) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.GroupSpecifier(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MultiComboBoxLayoutStyle[] objects = new com.smartgwt.client.types.MultiComboBoxLayoutStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultiComboBoxLayoutStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.MultiComboBoxLayoutStyle.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.JSONCircularReferenceMode[] objects = new com.smartgwt.client.types.JSONCircularReferenceMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.JSONCircularReferenceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.JSONCircularReferenceMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectItemsMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectItemsMode[]
	 */
    public static com.smartgwt.client.types.SelectItemsMode[] arrayOfSelectItemsMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectItemsMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectItemsMode[] objects = new com.smartgwt.client.types.SelectItemsMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectItemsMode obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectItemsMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.VisibilityMode[] objects = new com.smartgwt.client.types.VisibilityMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.VisibilityMode obj = EnumUtil.getEnum(com.smartgwt.client.types.VisibilityMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Encoding[] objects = new com.smartgwt.client.types.Encoding[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Encoding obj = EnumUtil.getEnum(com.smartgwt.client.types.Encoding.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecategorizeMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecategorizeMode[]
	 */
    public static com.smartgwt.client.types.RecategorizeMode[] arrayOfRecategorizeMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecategorizeMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecategorizeMode[] objects = new com.smartgwt.client.types.RecategorizeMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecategorizeMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RecategorizeMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.PresetDateRangeItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.PresetDateRangeItem[]
	 */
    public static com.smartgwt.client.widgets.form.PresetDateRangeItem[] arrayOfPresetDateRangeItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.PresetDateRangeItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.PresetDateRangeItem[] objects = new com.smartgwt.client.widgets.form.PresetDateRangeItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.PresetDateRangeItem obj = (com.smartgwt.client.widgets.form.PresetDateRangeItem) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.PresetDateRangeItem(components[i]));
            }

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
	 * {@link com.smartgwt.client.util.workflow.HideComponentTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.HideComponentTask[]
	 */
    public static com.smartgwt.client.util.workflow.HideComponentTask[] arrayOfHideComponentTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.HideComponentTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.HideComponentTask[] objects = new com.smartgwt.client.util.workflow.HideComponentTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.HideComponentTask obj = (com.smartgwt.client.util.workflow.HideComponentTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.HideComponentTask(components[i]));
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

            com.smartgwt.client.widgets.cube.CellRecord obj = com.smartgwt.client.widgets.cube.CellRecord.getOrCreateRef(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AnimationEffect[] objects = new com.smartgwt.client.types.AnimationEffect[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AnimationEffect obj = EnumUtil.getEnum(com.smartgwt.client.types.AnimationEffect.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.rte.ListPropertiesPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.rte.ListPropertiesPane[]
	 */
    public static com.smartgwt.client.widgets.rte.ListPropertiesPane[] arrayOfListPropertiesPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.rte.ListPropertiesPane[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.rte.ListPropertiesPane[] objects = new com.smartgwt.client.widgets.rte.ListPropertiesPane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.rte.ListPropertiesPane obj = (com.smartgwt.client.widgets.rte.ListPropertiesPane) com.smartgwt.client.widgets.rte.ListPropertiesPane.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceCompletionResult} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceCompletionResult[]
	 */
    public static com.smartgwt.client.widgets.ace.AceCompletionResult[] arrayOfAceCompletionResult(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceCompletionResult[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.ace.AceCompletionResult[] ret = new com.smartgwt.client.widgets.ace.AceCompletionResult[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.ace.AceCompletionResult(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceCompletionResult[] objects = new com.smartgwt.client.widgets.ace.AceCompletionResult[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceCompletionResult obj = (com.smartgwt.client.widgets.ace.AceCompletionResult) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceCompletionResult(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MultiUpdatePolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MultiUpdatePolicy[]
	 */
    public static com.smartgwt.client.types.MultiUpdatePolicy[] arrayOfMultiUpdatePolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MultiUpdatePolicy[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MultiUpdatePolicy[] objects = new com.smartgwt.client.types.MultiUpdatePolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultiUpdatePolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.MultiUpdatePolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.ToolStripSpacer} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.ToolStripSpacer[]
	 */
    public static com.smartgwt.client.widgets.toolbar.ToolStripSpacer[] arrayOfToolStripSpacer(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.ToolStripSpacer[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.ToolStripSpacer[] objects = new com.smartgwt.client.widgets.toolbar.ToolStripSpacer[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.ToolStripSpacer obj = (com.smartgwt.client.widgets.toolbar.ToolStripSpacer) com.smartgwt.client.widgets.toolbar.ToolStripSpacer.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.EventCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.EventCanvas[]
	 */
    public static com.smartgwt.client.widgets.calendar.EventCanvas[] arrayOfEventCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.EventCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.EventCanvas[] objects = new com.smartgwt.client.widgets.calendar.EventCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.EventCanvas obj = (com.smartgwt.client.widgets.calendar.EventCanvas) com.smartgwt.client.widgets.calendar.EventCanvas.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.layout.SectionStackSection obj = com.smartgwt.client.widgets.layout.SectionStackSection.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LineCap[] objects = new com.smartgwt.client.types.LineCap[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LineCap obj = EnumUtil.getEnum(com.smartgwt.client.types.LineCap.values(), value);

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

            com.smartgwt.client.data.XJSONDataSource obj = (com.smartgwt.client.data.XJSONDataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.XJSONDataSource(components[i]));
            }

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

            com.smartgwt.client.widgets.form.fields.SubmitItem obj = com.smartgwt.client.widgets.form.fields.SubmitItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.PickListMenu} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.PickListMenu[]
	 */
    public static com.smartgwt.client.widgets.form.PickListMenu[] arrayOfPickListMenu(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.PickListMenu[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.PickListMenu[] objects = new com.smartgwt.client.widgets.form.PickListMenu[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.PickListMenu obj = (com.smartgwt.client.widgets.form.PickListMenu) com.smartgwt.client.widgets.form.PickListMenu.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.IconOverTrigger} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.IconOverTrigger[]
	 */
    public static com.smartgwt.client.types.IconOverTrigger[] arrayOfIconOverTrigger(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.IconOverTrigger[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.IconOverTrigger[] objects = new com.smartgwt.client.types.IconOverTrigger[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.IconOverTrigger obj = EnumUtil.getEnum(com.smartgwt.client.types.IconOverTrigger.values(), value);

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

            com.smartgwt.client.widgets.plugins.ActiveXControl obj = (com.smartgwt.client.widgets.plugins.ActiveXControl) com.smartgwt.client.widgets.plugins.ActiveXControl.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.DateChooser obj = (com.smartgwt.client.widgets.DateChooser) com.smartgwt.client.widgets.DateChooser.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.BatchUploader obj = (com.smartgwt.client.widgets.BatchUploader) com.smartgwt.client.widgets.BatchUploader.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.StretchImgButton obj = (com.smartgwt.client.widgets.StretchImgButton) com.smartgwt.client.widgets.StretchImgButton.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.drawing.DrawLine obj = (com.smartgwt.client.widgets.drawing.DrawLine) com.smartgwt.client.widgets.drawing.DrawLine.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.ImgEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.ImgEditProxy[]
	 */
    public static com.smartgwt.client.tools.ImgEditProxy[] arrayOfImgEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.ImgEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.ImgEditProxy[] objects = new com.smartgwt.client.tools.ImgEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.ImgEditProxy obj = (com.smartgwt.client.tools.ImgEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.ImgEditProxy(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PercentBoxModel[] objects = new com.smartgwt.client.types.PercentBoxModel[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PercentBoxModel obj = EnumUtil.getEnum(com.smartgwt.client.types.PercentBoxModel.values(), value);

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

            com.smartgwt.client.widgets.Dialog obj = (com.smartgwt.client.widgets.Dialog) com.smartgwt.client.widgets.Dialog.getByJSObject(components[i]);

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

            com.smartgwt.client.data.WSDataSource obj = (com.smartgwt.client.data.WSDataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.WSDataSource(components[i]));
            }

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

            com.smartgwt.client.widgets.tableview.TableView obj = (com.smartgwt.client.widgets.tableview.TableView) com.smartgwt.client.widgets.tableview.TableView.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.StaticTextItem obj = com.smartgwt.client.widgets.form.fields.StaticTextItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ChartType[] objects = new com.smartgwt.client.types.ChartType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ChartType obj = EnumUtil.getEnum(com.smartgwt.client.types.ChartType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EnumTranslateStrategy[] objects = new com.smartgwt.client.types.EnumTranslateStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EnumTranslateStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.EnumTranslateStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.WindowEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.WindowEditProxy[]
	 */
    public static com.smartgwt.client.tools.WindowEditProxy[] arrayOfWindowEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.WindowEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.WindowEditProxy[] objects = new com.smartgwt.client.tools.WindowEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.WindowEditProxy obj = (com.smartgwt.client.tools.WindowEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.WindowEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.QualityIndicatedLocator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.QualityIndicatedLocator[]
	 */
    public static com.smartgwt.client.util.QualityIndicatedLocator[] arrayOfQualityIndicatedLocator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.QualityIndicatedLocator[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.util.QualityIndicatedLocator[] ret = new com.smartgwt.client.util.QualityIndicatedLocator[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.util.QualityIndicatedLocator(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.QualityIndicatedLocator[] objects = new com.smartgwt.client.util.QualityIndicatedLocator[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.QualityIndicatedLocator obj = (com.smartgwt.client.util.QualityIndicatedLocator) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.QualityIndicatedLocator(components[i]));
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

            com.smartgwt.client.widgets.menu.IconMenuButton obj = (com.smartgwt.client.widgets.menu.IconMenuButton) com.smartgwt.client.widgets.menu.IconMenuButton.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecordDropPosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecordDropPosition[]
	 */
    public static com.smartgwt.client.types.RecordDropPosition[] arrayOfRecordDropPosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecordDropPosition[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecordDropPosition[] objects = new com.smartgwt.client.types.RecordDropPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordDropPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordDropPosition.values(), value);

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
	 * {@link com.smartgwt.client.core.KeyIdentifier} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.core.KeyIdentifier[]
	 */
    public static com.smartgwt.client.core.KeyIdentifier[] arrayOfKeyIdentifier(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.core.KeyIdentifier[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.core.KeyIdentifier[] ret = new com.smartgwt.client.core.KeyIdentifier[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.core.KeyIdentifier(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.core.KeyIdentifier[] objects = new com.smartgwt.client.core.KeyIdentifier[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.core.KeyIdentifier obj = (com.smartgwt.client.core.KeyIdentifier) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.core.KeyIdentifier(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.VisualBuilder} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.VisualBuilder[]
	 */
    public static com.smartgwt.client.tools.VisualBuilder[] arrayOfVisualBuilder(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.VisualBuilder[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.VisualBuilder[] objects = new com.smartgwt.client.tools.VisualBuilder[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.VisualBuilder obj = (com.smartgwt.client.tools.VisualBuilder) com.smartgwt.client.tools.VisualBuilder.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.drawing.DrawDiamond} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.drawing.DrawDiamond[]
	 */
    public static com.smartgwt.client.widgets.drawing.DrawDiamond[] arrayOfDrawDiamond(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.drawing.DrawDiamond[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.drawing.DrawDiamond[] objects = new com.smartgwt.client.widgets.drawing.DrawDiamond[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.drawing.DrawDiamond obj = (com.smartgwt.client.widgets.drawing.DrawDiamond) com.smartgwt.client.widgets.drawing.DrawDiamond.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridSaveAllEditsTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridSaveAllEditsTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridSaveAllEditsTask[] arrayOfGridSaveAllEditsTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridSaveAllEditsTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridSaveAllEditsTask[] objects = new com.smartgwt.client.util.workflow.GridSaveAllEditsTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridSaveAllEditsTask obj = (com.smartgwt.client.util.workflow.GridSaveAllEditsTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridSaveAllEditsTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LayoutResizeBarPolicy[] objects = new com.smartgwt.client.types.LayoutResizeBarPolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LayoutResizeBarPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.LayoutResizeBarPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.Palette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.Palette[]
	 */
    public static com.smartgwt.client.tools.Palette[] arrayOfPalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.Palette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.Palette[] objects = new com.smartgwt.client.tools.Palette[components.length];

        for (int i = 0; i < components.length; i++) {

            // We need to get or create the correct Java type, but we can't call
            // getOrCreateRef on an interface. The best simple thing we can do is
            // take advantage of ObjectFactory.createCanvas and friends to pick the
            // right type. Note that this will work for custom developer classes
            // so long as they descend from a SmartClient implementation of the
            // interface. It won't work for totally custom implementations, but
            // totally custom implementations would be hard to create properly anyway
            // (because they won't get the default methods implemented on the
            // SmartClient interface).
            Object javaObj = null;
            com.smartgwt.client.tools.Palette obj = null;
            if (JSOHelper.isScClassInstance(components[i])) {
                String className = JSOHelper.getClassName(components[i]);
                javaObj = ObjectFactory.createCanvas(className, components[i]);
                
                // If it's not a Canvas, try the others
                if (javaObj == null) {
                    javaObj = ObjectFactory.createInstance(className, components[i]);
                }
            }
            if (javaObj instanceof com.smartgwt.client.tools.Palette) obj = (com.smartgwt.client.tools.Palette) javaObj;  

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DrawPosition[] objects = new com.smartgwt.client.types.DrawPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DrawPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.DrawPosition.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ShowNextToComponentTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ShowNextToComponentTask[]
	 */
    public static com.smartgwt.client.util.workflow.ShowNextToComponentTask[] arrayOfShowNextToComponentTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ShowNextToComponentTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ShowNextToComponentTask[] objects = new com.smartgwt.client.util.workflow.ShowNextToComponentTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ShowNextToComponentTask obj = (com.smartgwt.client.util.workflow.ShowNextToComponentTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ShowNextToComponentTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MiniNavControl} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MiniNavControl[]
	 */
    public static com.smartgwt.client.widgets.MiniNavControl[] arrayOfMiniNavControl(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MiniNavControl[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MiniNavControl[] objects = new com.smartgwt.client.widgets.MiniNavControl[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MiniNavControl obj = (com.smartgwt.client.widgets.MiniNavControl) com.smartgwt.client.widgets.MiniNavControl.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.tile.TileGrid obj = (com.smartgwt.client.widgets.tile.TileGrid) com.smartgwt.client.widgets.tile.TileGrid.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MultipleAppearance[] objects = new com.smartgwt.client.types.MultipleAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultipleAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.MultipleAppearance.values(), value);

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

            com.smartgwt.client.widgets.menu.MenuItem obj = com.smartgwt.client.widgets.menu.MenuItem.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.layout.NavigationBar obj = (com.smartgwt.client.widgets.layout.NavigationBar) com.smartgwt.client.widgets.layout.NavigationBar.getByJSObject(components[i]);

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

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.JSONEncoder[] objects = new com.smartgwt.client.util.JSONEncoder[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.JSONEncoder obj = (com.smartgwt.client.util.JSONEncoder) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.JSONEncoder(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.Sound} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.Sound[]
	 */
    public static com.smartgwt.client.widgets.Sound[] arrayOfSound(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.Sound[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.Sound[] objects = new com.smartgwt.client.widgets.Sound[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.Sound obj = (com.smartgwt.client.widgets.Sound) com.smartgwt.client.widgets.Sound.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.StartTransactionTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.StartTransactionTask[]
	 */
    public static com.smartgwt.client.util.workflow.StartTransactionTask[] arrayOfStartTransactionTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.StartTransactionTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.StartTransactionTask[] objects = new com.smartgwt.client.util.workflow.StartTransactionTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.StartTransactionTask obj = (com.smartgwt.client.util.workflow.StartTransactionTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.StartTransactionTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.FacadeDataSource} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.FacadeDataSource[]
	 */
    public static com.smartgwt.client.data.FacadeDataSource[] arrayOfFacadeDataSource(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.FacadeDataSource[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.FacadeDataSource[] objects = new com.smartgwt.client.data.FacadeDataSource[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.FacadeDataSource obj = (com.smartgwt.client.data.FacadeDataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.FacadeDataSource(components[i]));
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

            com.smartgwt.client.widgets.form.ColorPicker obj = (com.smartgwt.client.widgets.form.ColorPicker) com.smartgwt.client.widgets.form.ColorPicker.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.NavigationDirection[] objects = new com.smartgwt.client.types.NavigationDirection[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NavigationDirection obj = EnumUtil.getEnum(com.smartgwt.client.types.NavigationDirection.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectionNotificationType[] objects = new com.smartgwt.client.types.SelectionNotificationType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionNotificationType obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionNotificationType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.EditPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.EditPane[]
	 */
    public static com.smartgwt.client.tools.EditPane[] arrayOfEditPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.EditPane[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.EditPane[] objects = new com.smartgwt.client.tools.EditPane[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.EditPane obj = (com.smartgwt.client.tools.EditPane) com.smartgwt.client.tools.EditPane.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.PanelPlacement} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.PanelPlacement[]
	 */
    public static com.smartgwt.client.types.PanelPlacement[] arrayOfPanelPlacement(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.PanelPlacement[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PanelPlacement[] objects = new com.smartgwt.client.types.PanelPlacement[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PanelPlacement obj = EnumUtil.getEnum(com.smartgwt.client.types.PanelPlacement.values(), value);

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

            com.smartgwt.client.widgets.form.fields.HiddenItem obj = com.smartgwt.client.widgets.form.fields.HiddenItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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
	 * {@link com.smartgwt.client.widgets.layout.Deck} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.Deck[]
	 */
    public static com.smartgwt.client.widgets.layout.Deck[] arrayOfDeck(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.Deck[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.Deck[] objects = new com.smartgwt.client.widgets.layout.Deck[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.Deck obj = (com.smartgwt.client.widgets.layout.Deck) com.smartgwt.client.widgets.layout.Deck.getByJSObject(components[i]);

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
	 * {@link com.smartgwt.client.tools.HiddenPalette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.HiddenPalette[]
	 */
    public static com.smartgwt.client.tools.HiddenPalette[] arrayOfHiddenPalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.HiddenPalette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.HiddenPalette[] objects = new com.smartgwt.client.tools.HiddenPalette[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.HiddenPalette obj = (com.smartgwt.client.tools.HiddenPalette) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.HiddenPalette(components[i]));
            }

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

            com.smartgwt.client.util.workflow.ProcessElement obj = (com.smartgwt.client.util.workflow.ProcessElement) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ProcessElement(components[i]));
            }

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

            com.smartgwt.client.widgets.calendar.Lane obj = com.smartgwt.client.widgets.calendar.Lane.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.DateItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.DateItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.DateItemEditProxy[] arrayOfDateItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.DateItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.DateItemEditProxy[] objects = new com.smartgwt.client.tools.DateItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.DateItemEditProxy obj = (com.smartgwt.client.tools.DateItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.DateItemEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.TextAreaItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.TextAreaItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.TextAreaItemEditProxy[] arrayOfTextAreaItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.TextAreaItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.TextAreaItemEditProxy[] objects = new com.smartgwt.client.tools.TextAreaItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.TextAreaItemEditProxy obj = (com.smartgwt.client.tools.TextAreaItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.TextAreaItemEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.DrawLabelEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.DrawLabelEditProxy[]
	 */
    public static com.smartgwt.client.tools.DrawLabelEditProxy[] arrayOfDrawLabelEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.DrawLabelEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.DrawLabelEditProxy[] objects = new com.smartgwt.client.tools.DrawLabelEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.DrawLabelEditProxy obj = (com.smartgwt.client.tools.DrawLabelEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.DrawLabelEditProxy(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.GroupStartOpen[] objects = new com.smartgwt.client.types.GroupStartOpen[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.GroupStartOpen obj = EnumUtil.getEnum(com.smartgwt.client.types.GroupStartOpen.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DateEditingStyle[] objects = new com.smartgwt.client.types.DateEditingStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DateEditingStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.DateEditingStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.toolbar.Toolbar} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.toolbar.Toolbar[]
	 */
    public static com.smartgwt.client.widgets.toolbar.Toolbar[] arrayOfToolbar(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.toolbar.Toolbar[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.toolbar.Toolbar[] objects = new com.smartgwt.client.widgets.toolbar.Toolbar[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.toolbar.Toolbar obj = (com.smartgwt.client.widgets.toolbar.Toolbar) com.smartgwt.client.widgets.toolbar.Toolbar.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridExportDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridExportDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridExportDataTask[] arrayOfGridExportDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridExportDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridExportDataTask[] objects = new com.smartgwt.client.util.workflow.GridExportDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridExportDataTask obj = (com.smartgwt.client.util.workflow.GridExportDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridExportDataTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.LayoutEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.LayoutEditProxy[]
	 */
    public static com.smartgwt.client.tools.LayoutEditProxy[] arrayOfLayoutEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.LayoutEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.LayoutEditProxy[] objects = new com.smartgwt.client.tools.LayoutEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.LayoutEditProxy obj = (com.smartgwt.client.tools.LayoutEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.LayoutEditProxy(components[i]));
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

            com.smartgwt.client.widgets.drawing.DrawLinePath obj = (com.smartgwt.client.widgets.drawing.DrawLinePath) com.smartgwt.client.widgets.drawing.DrawLinePath.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.drawing.DrawImage obj = (com.smartgwt.client.widgets.drawing.DrawImage) com.smartgwt.client.widgets.drawing.DrawImage.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.StandardControlGroup} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.StandardControlGroup[]
	 */
    public static com.smartgwt.client.types.StandardControlGroup[] arrayOfStandardControlGroup(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.StandardControlGroup[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.StandardControlGroup[] objects = new com.smartgwt.client.types.StandardControlGroup[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.StandardControlGroup obj = EnumUtil.getEnum(com.smartgwt.client.types.StandardControlGroup.values(), value);

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

            com.smartgwt.client.data.TextExportSettings obj = (com.smartgwt.client.data.TextExportSettings) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.TextExportSettings(components[i]));
            }

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

            com.smartgwt.client.widgets.RichTextEditor obj = (com.smartgwt.client.widgets.RichTextEditor) com.smartgwt.client.widgets.RichTextEditor.getByJSObject(components[i]);

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
	 * {@link com.smartgwt.client.widgets.form.fields.BooleanItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.BooleanItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.BooleanItem[] arrayOfBooleanItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.BooleanItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.BooleanItem[] objects = new com.smartgwt.client.widgets.form.fields.BooleanItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.BooleanItem obj = com.smartgwt.client.widgets.form.fields.BooleanItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.util.workflow.ProcessSequence obj = (com.smartgwt.client.util.workflow.ProcessSequence) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ProcessSequence(components[i]));
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

            com.smartgwt.client.widgets.form.fields.RadioGroupItem obj = com.smartgwt.client.widgets.form.fields.RadioGroupItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.FileItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.FileItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.FileItemEditProxy[] arrayOfFileItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.FileItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.FileItemEditProxy[] objects = new com.smartgwt.client.tools.FileItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.FileItemEditProxy obj = (com.smartgwt.client.tools.FileItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.FileItemEditProxy(components[i]));
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

            com.smartgwt.client.widgets.drawing.DrawBlockConnector obj = (com.smartgwt.client.widgets.drawing.DrawBlockConnector) com.smartgwt.client.widgets.drawing.DrawBlockConnector.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Autofit[] objects = new com.smartgwt.client.types.Autofit[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Autofit obj = EnumUtil.getEnum(com.smartgwt.client.types.Autofit.values(), value);

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

            com.smartgwt.client.widgets.layout.SplitPane obj = (com.smartgwt.client.widgets.layout.SplitPane) com.smartgwt.client.widgets.layout.SplitPane.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectionStyle[] objects = new com.smartgwt.client.types.SelectionStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormSetFieldValueTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormSetFieldValueTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormSetFieldValueTask[] arrayOfFormSetFieldValueTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormSetFieldValueTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormSetFieldValueTask[] objects = new com.smartgwt.client.util.workflow.FormSetFieldValueTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormSetFieldValueTask obj = (com.smartgwt.client.util.workflow.FormSetFieldValueTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormSetFieldValueTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TopOperatorAppearance[] objects = new com.smartgwt.client.types.TopOperatorAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TopOperatorAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.TopOperatorAppearance.values(), value);

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

            com.smartgwt.client.widgets.layout.ImgSectionHeader obj = (com.smartgwt.client.widgets.layout.ImgSectionHeader) com.smartgwt.client.widgets.layout.ImgSectionHeader.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.toolbar.RibbonBar obj = (com.smartgwt.client.widgets.toolbar.RibbonBar) com.smartgwt.client.widgets.toolbar.RibbonBar.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LegendAlign} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LegendAlign[]
	 */
    public static com.smartgwt.client.types.LegendAlign[] arrayOfLegendAlign(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LegendAlign[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LegendAlign[] objects = new com.smartgwt.client.types.LegendAlign[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LegendAlign obj = EnumUtil.getEnum(com.smartgwt.client.types.LegendAlign.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ScanMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ScanMode[]
	 */
    public static com.smartgwt.client.types.ScanMode[] arrayOfScanMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ScanMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ScanMode[] objects = new com.smartgwt.client.types.ScanMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ScanMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ScanMode.values(), value);

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

            com.smartgwt.client.widgets.form.fields.RelativeDateItem obj = com.smartgwt.client.widgets.form.fields.RelativeDateItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.EndProcessTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.EndProcessTask[]
	 */
    public static com.smartgwt.client.util.workflow.EndProcessTask[] arrayOfEndProcessTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.EndProcessTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.EndProcessTask[] objects = new com.smartgwt.client.util.workflow.EndProcessTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.EndProcessTask obj = (com.smartgwt.client.util.workflow.EndProcessTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.EndProcessTask(components[i]));
            }

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

            com.smartgwt.client.widgets.layout.HLayout obj = (com.smartgwt.client.widgets.layout.HLayout) com.smartgwt.client.widgets.layout.HLayout.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.calendar.Calendar obj = (com.smartgwt.client.widgets.calendar.Calendar) com.smartgwt.client.widgets.calendar.Calendar.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TabTitleEditEvent[] objects = new com.smartgwt.client.types.TabTitleEditEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TabTitleEditEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.TabTitleEditEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ContentLayoutPolicy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ContentLayoutPolicy[]
	 */
    public static com.smartgwt.client.types.ContentLayoutPolicy[] arrayOfContentLayoutPolicy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ContentLayoutPolicy[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ContentLayoutPolicy[] objects = new com.smartgwt.client.types.ContentLayoutPolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ContentLayoutPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.ContentLayoutPolicy.values(), value);

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

            com.smartgwt.client.widgets.grid.HiliteEditor obj = (com.smartgwt.client.widgets.grid.HiliteEditor) com.smartgwt.client.widgets.grid.HiliteEditor.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.grid.ListGrid obj = (com.smartgwt.client.widgets.grid.ListGrid) com.smartgwt.client.widgets.grid.ListGrid.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.StartProcessTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.StartProcessTask[]
	 */
    public static com.smartgwt.client.util.workflow.StartProcessTask[] arrayOfStartProcessTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.StartProcessTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.StartProcessTask[] objects = new com.smartgwt.client.util.workflow.StartProcessTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.StartProcessTask obj = (com.smartgwt.client.util.workflow.StartProcessTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.StartProcessTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ExportFormat[] objects = new com.smartgwt.client.types.ExportFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportFormat.values(), value);

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

            com.smartgwt.client.widgets.layout.FlowLayout obj = (com.smartgwt.client.widgets.layout.FlowLayout) com.smartgwt.client.widgets.layout.FlowLayout.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.NavigationBarViewState} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.NavigationBarViewState[]
	 */
    public static com.smartgwt.client.widgets.layout.NavigationBarViewState[] arrayOfNavigationBarViewState(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.NavigationBarViewState[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.layout.NavigationBarViewState[] ret = new com.smartgwt.client.widgets.layout.NavigationBarViewState[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.layout.NavigationBarViewState(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.NavigationBarViewState[] objects = new com.smartgwt.client.widgets.layout.NavigationBarViewState[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.NavigationBarViewState obj = (com.smartgwt.client.widgets.layout.NavigationBarViewState) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.layout.NavigationBarViewState(components[i]));
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

            com.smartgwt.client.widgets.calendar.EventWindow obj = (com.smartgwt.client.widgets.calendar.EventWindow) com.smartgwt.client.widgets.calendar.EventWindow.getByJSObject(components[i]);

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
	 * {@link com.smartgwt.client.types.MultiMessageMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MultiMessageMode[]
	 */
    public static com.smartgwt.client.types.MultiMessageMode[] arrayOfMultiMessageMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MultiMessageMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MultiMessageMode[] objects = new com.smartgwt.client.types.MultiMessageMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultiMessageMode obj = EnumUtil.getEnum(com.smartgwt.client.types.MultiMessageMode.values(), value);

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

            com.smartgwt.client.widgets.form.fields.DateTimeItem obj = com.smartgwt.client.widgets.form.fields.DateTimeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.TextItemEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.TextItemEditProxy[]
	 */
    public static com.smartgwt.client.tools.TextItemEditProxy[] arrayOfTextItemEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.TextItemEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.TextItemEditProxy[] objects = new com.smartgwt.client.tools.TextItemEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.TextItemEditProxy obj = (com.smartgwt.client.tools.TextItemEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.TextItemEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridSetEditValueTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridSetEditValueTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridSetEditValueTask[] arrayOfGridSetEditValueTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridSetEditValueTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridSetEditValueTask[] objects = new com.smartgwt.client.util.workflow.GridSetEditValueTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridSetEditValueTask obj = (com.smartgwt.client.util.workflow.GridSetEditValueTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridSetEditValueTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Orientation[] objects = new com.smartgwt.client.types.Orientation[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Orientation obj = EnumUtil.getEnum(com.smartgwt.client.types.Orientation.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceUndoManager} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceUndoManager[]
	 */
    public static com.smartgwt.client.widgets.ace.AceUndoManager[] arrayOfAceUndoManager(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceUndoManager[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceUndoManager[] objects = new com.smartgwt.client.widgets.ace.AceUndoManager[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceUndoManager obj = (com.smartgwt.client.widgets.ace.AceUndoManager) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceUndoManager(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.DSRemoveTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.DSRemoveTask[]
	 */
    public static com.smartgwt.client.util.workflow.DSRemoveTask[] arrayOfDSRemoveTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.DSRemoveTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.DSRemoveTask[] objects = new com.smartgwt.client.util.workflow.DSRemoveTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.DSRemoveTask obj = (com.smartgwt.client.util.workflow.DSRemoveTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.DSRemoveTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ValueItemType[] objects = new com.smartgwt.client.types.ValueItemType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ValueItemType obj = EnumUtil.getEnum(com.smartgwt.client.types.ValueItemType.values(), value);

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

            com.smartgwt.client.widgets.grid.ListGridRecord obj = com.smartgwt.client.widgets.grid.ListGridRecord.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ApplicationMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ApplicationMode[]
	 */
    public static com.smartgwt.client.types.ApplicationMode[] arrayOfApplicationMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ApplicationMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ApplicationMode[] objects = new com.smartgwt.client.types.ApplicationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ApplicationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ApplicationMode.values(), value);

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

            com.smartgwt.client.widgets.tree.ResultTree obj = (com.smartgwt.client.widgets.tree.ResultTree) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.ResultTree(components[i]));
            }

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

            com.smartgwt.client.data.TextImportSettings obj = (com.smartgwt.client.data.TextImportSettings) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.TextImportSettings(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.AdaptiveMenu} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.AdaptiveMenu[]
	 */
    public static com.smartgwt.client.widgets.menu.AdaptiveMenu[] arrayOfAdaptiveMenu(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.AdaptiveMenu[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.AdaptiveMenu[] objects = new com.smartgwt.client.widgets.menu.AdaptiveMenu[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.AdaptiveMenu obj = (com.smartgwt.client.widgets.menu.AdaptiveMenu) com.smartgwt.client.widgets.menu.AdaptiveMenu.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LabelRotationMode[] objects = new com.smartgwt.client.types.LabelRotationMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LabelRotationMode obj = EnumUtil.getEnum(com.smartgwt.client.types.LabelRotationMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.FloatItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.FloatItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.FloatItem[] arrayOfFloatItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.FloatItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.FloatItem[] objects = new com.smartgwt.client.widgets.form.fields.FloatItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.FloatItem obj = com.smartgwt.client.widgets.form.fields.FloatItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.drawing.ColorStop obj = com.smartgwt.client.widgets.drawing.ColorStop.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.drawing.Gauge obj = (com.smartgwt.client.widgets.drawing.Gauge) com.smartgwt.client.widgets.drawing.Gauge.getByJSObject(components[i]);

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

            com.smartgwt.client.data.RestDataSource obj = (com.smartgwt.client.data.RestDataSource) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.RestDataSource(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormValidateValuesTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormValidateValuesTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormValidateValuesTask[] arrayOfFormValidateValuesTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormValidateValuesTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormValidateValuesTask[] objects = new com.smartgwt.client.util.workflow.FormValidateValuesTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormValidateValuesTask obj = (com.smartgwt.client.util.workflow.FormValidateValuesTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormValidateValuesTask(components[i]));
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
	 * {@link com.smartgwt.client.types.MoveKnobPoint} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MoveKnobPoint[]
	 */
    public static com.smartgwt.client.types.MoveKnobPoint[] arrayOfMoveKnobPoint(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MoveKnobPoint[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MoveKnobPoint[] objects = new com.smartgwt.client.types.MoveKnobPoint[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MoveKnobPoint obj = EnumUtil.getEnum(com.smartgwt.client.types.MoveKnobPoint.values(), value);

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

            com.smartgwt.client.widgets.form.fields.HeaderItem obj = com.smartgwt.client.widgets.form.fields.HeaderItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecordComponentPoolingMode[] objects = new com.smartgwt.client.types.RecordComponentPoolingMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordComponentPoolingMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordComponentPoolingMode.values(), value);

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

            com.smartgwt.client.widgets.drawing.DrawOval obj = (com.smartgwt.client.widgets.drawing.DrawOval) com.smartgwt.client.widgets.drawing.DrawOval.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.ValuesManager obj = (com.smartgwt.client.widgets.form.ValuesManager) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.form.ValuesManager(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ListGridFieldType[] objects = new com.smartgwt.client.types.ListGridFieldType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListGridFieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.ListGridFieldType.values(), value);

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
	 * {@link com.smartgwt.client.util.XMLSyntaxHiliter} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.XMLSyntaxHiliter[]
	 */
    public static com.smartgwt.client.util.XMLSyntaxHiliter[] arrayOfXMLSyntaxHiliter(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.XMLSyntaxHiliter[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.XMLSyntaxHiliter[] objects = new com.smartgwt.client.util.XMLSyntaxHiliter[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.XMLSyntaxHiliter obj = (com.smartgwt.client.util.XMLSyntaxHiliter) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.XMLSyntaxHiliter(components[i]));
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

            com.smartgwt.client.widgets.drawing.DrawTriangle obj = (com.smartgwt.client.widgets.drawing.DrawTriangle) com.smartgwt.client.widgets.drawing.DrawTriangle.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.ImgButton obj = (com.smartgwt.client.widgets.ImgButton) com.smartgwt.client.widgets.ImgButton.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.toolbar.ToolStripGroup obj = (com.smartgwt.client.widgets.toolbar.ToolStripGroup) com.smartgwt.client.widgets.toolbar.ToolStripGroup.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.PrintCanvasTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.PrintCanvasTask[]
	 */
    public static com.smartgwt.client.util.workflow.PrintCanvasTask[] arrayOfPrintCanvasTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.PrintCanvasTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.PrintCanvasTask[] objects = new com.smartgwt.client.util.workflow.PrintCanvasTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.PrintCanvasTask obj = (com.smartgwt.client.util.workflow.PrintCanvasTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.PrintCanvasTask(components[i]));
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

            com.smartgwt.client.widgets.grid.ListGridField obj = com.smartgwt.client.widgets.grid.ListGridField.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.cube.CubeGrid obj = (com.smartgwt.client.widgets.cube.CubeGrid) com.smartgwt.client.widgets.cube.CubeGrid.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.LogOutTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.LogOutTask[]
	 */
    public static com.smartgwt.client.util.workflow.LogOutTask[] arrayOfLogOutTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.LogOutTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.LogOutTask[] objects = new com.smartgwt.client.util.workflow.LogOutTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.LogOutTask obj = (com.smartgwt.client.util.workflow.LogOutTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.LogOutTask(components[i]));
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

            com.smartgwt.client.widgets.plugins.SVG obj = (com.smartgwt.client.widgets.plugins.SVG) com.smartgwt.client.widgets.plugins.SVG.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridExportClientDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridExportClientDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridExportClientDataTask[] arrayOfGridExportClientDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridExportClientDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridExportClientDataTask[] objects = new com.smartgwt.client.util.workflow.GridExportClientDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridExportClientDataTask obj = (com.smartgwt.client.util.workflow.GridExportClientDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridExportClientDataTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.PromptStyle[] objects = new com.smartgwt.client.types.PromptStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.PromptStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.PromptStyle.values(), value);

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

            com.smartgwt.client.widgets.menu.IMenuButton obj = (com.smartgwt.client.widgets.menu.IMenuButton) com.smartgwt.client.widgets.menu.IMenuButton.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.tree.TreeNode obj = com.smartgwt.client.widgets.tree.TreeNode.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ShowMessageTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ShowMessageTask[]
	 */
    public static com.smartgwt.client.util.workflow.ShowMessageTask[] arrayOfShowMessageTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ShowMessageTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ShowMessageTask[] objects = new com.smartgwt.client.util.workflow.ShowMessageTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ShowMessageTask obj = (com.smartgwt.client.util.workflow.ShowMessageTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ShowMessageTask(components[i]));
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

            com.smartgwt.client.widgets.drawing.DrawRect obj = (com.smartgwt.client.widgets.drawing.DrawRect) com.smartgwt.client.widgets.drawing.DrawRect.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.TreePalette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.TreePalette[]
	 */
    public static com.smartgwt.client.tools.TreePalette[] arrayOfTreePalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.TreePalette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.TreePalette[] objects = new com.smartgwt.client.tools.TreePalette[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.TreePalette obj = (com.smartgwt.client.tools.TreePalette) com.smartgwt.client.tools.TreePalette.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.UserConfirmationGateway} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.UserConfirmationGateway[]
	 */
    public static com.smartgwt.client.util.workflow.UserConfirmationGateway[] arrayOfUserConfirmationGateway(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.UserConfirmationGateway[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.UserConfirmationGateway[] objects = new com.smartgwt.client.util.workflow.UserConfirmationGateway[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.UserConfirmationGateway obj = (com.smartgwt.client.util.workflow.UserConfirmationGateway) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.UserConfirmationGateway(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ProportionalResizeMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ProportionalResizeMode[]
	 */
    public static com.smartgwt.client.types.ProportionalResizeMode[] arrayOfProportionalResizeMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ProportionalResizeMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ProportionalResizeMode[] objects = new com.smartgwt.client.types.ProportionalResizeMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ProportionalResizeMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ProportionalResizeMode.values(), value);

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

            com.smartgwt.client.widgets.calendar.CalendarEvent obj = com.smartgwt.client.widgets.calendar.CalendarEvent.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormResetValuesTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormResetValuesTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormResetValuesTask[] arrayOfFormResetValuesTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormResetValuesTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormResetValuesTask[] objects = new com.smartgwt.client.util.workflow.FormResetValuesTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormResetValuesTask obj = (com.smartgwt.client.util.workflow.FormResetValuesTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormResetValuesTask(components[i]));
            }

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

            com.smartgwt.client.widgets.tile.TileLayout obj = (com.smartgwt.client.widgets.tile.TileLayout) com.smartgwt.client.widgets.tile.TileLayout.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.menu.SelectionTreeMenu} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.menu.SelectionTreeMenu[]
	 */
    public static com.smartgwt.client.widgets.menu.SelectionTreeMenu[] arrayOfSelectionTreeMenu(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.menu.SelectionTreeMenu[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.menu.SelectionTreeMenu[] objects = new com.smartgwt.client.widgets.menu.SelectionTreeMenu[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.menu.SelectionTreeMenu obj = (com.smartgwt.client.widgets.menu.SelectionTreeMenu) com.smartgwt.client.widgets.menu.SelectionTreeMenu.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.DynamicForm obj = (com.smartgwt.client.widgets.form.DynamicForm) com.smartgwt.client.widgets.form.DynamicForm.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.PasswordItem obj = com.smartgwt.client.widgets.form.fields.PasswordItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.VerticalAlignment[] objects = new com.smartgwt.client.types.VerticalAlignment[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.VerticalAlignment obj = EnumUtil.getEnum(com.smartgwt.client.types.VerticalAlignment.values(), value);

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

            com.smartgwt.client.widgets.tab.ImgTab obj = (com.smartgwt.client.widgets.tab.ImgTab) com.smartgwt.client.widgets.tab.ImgTab.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.layout.LayoutSpacer obj = (com.smartgwt.client.widgets.layout.LayoutSpacer) com.smartgwt.client.widgets.layout.LayoutSpacer.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TreeModelType[] objects = new com.smartgwt.client.types.TreeModelType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TreeModelType obj = EnumUtil.getEnum(com.smartgwt.client.types.TreeModelType.values(), value);

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

            com.smartgwt.client.widgets.form.fields.ToolbarItem obj = com.smartgwt.client.widgets.form.fields.ToolbarItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.chart.FacetChart obj = (com.smartgwt.client.widgets.chart.FacetChart) com.smartgwt.client.widgets.chart.FacetChart.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.ShowNotificationTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.ShowNotificationTask[]
	 */
    public static com.smartgwt.client.util.workflow.ShowNotificationTask[] arrayOfShowNotificationTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.ShowNotificationTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.ShowNotificationTask[] objects = new com.smartgwt.client.util.workflow.ShowNotificationTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.ShowNotificationTask obj = (com.smartgwt.client.util.workflow.ShowNotificationTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ShowNotificationTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.IntegerItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.IntegerItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.IntegerItem[] arrayOfIntegerItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.IntegerItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.IntegerItem[] objects = new com.smartgwt.client.widgets.form.fields.IntegerItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.IntegerItem obj = com.smartgwt.client.widgets.form.fields.IntegerItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.SCStatefulImgConfig} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.SCStatefulImgConfig[]
	 */
    public static com.smartgwt.client.widgets.SCStatefulImgConfig[] arrayOfSCStatefulImgConfig(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.SCStatefulImgConfig[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.SCStatefulImgConfig[] ret = new com.smartgwt.client.widgets.SCStatefulImgConfig[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.SCStatefulImgConfig(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.SCStatefulImgConfig[] objects = new com.smartgwt.client.widgets.SCStatefulImgConfig[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.SCStatefulImgConfig obj = (com.smartgwt.client.widgets.SCStatefulImgConfig) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.SCStatefulImgConfig(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ConnectorStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ConnectorStyle[]
	 */
    public static com.smartgwt.client.types.ConnectorStyle[] arrayOfConnectorStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ConnectorStyle[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ConnectorStyle[] objects = new com.smartgwt.client.types.ConnectorStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ConnectorStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.ConnectorStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceMarker} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceMarker[]
	 */
    public static com.smartgwt.client.widgets.ace.AceMarker[] arrayOfAceMarker(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceMarker[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceMarker[] objects = new com.smartgwt.client.widgets.ace.AceMarker[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceMarker obj = (com.smartgwt.client.widgets.ace.AceMarker) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceMarker(components[i]));
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

            com.smartgwt.client.widgets.tile.SimpleTile obj = (com.smartgwt.client.widgets.tile.SimpleTile) com.smartgwt.client.widgets.tile.SimpleTile.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.SplitPaneEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.SplitPaneEditProxy[]
	 */
    public static com.smartgwt.client.tools.SplitPaneEditProxy[] arrayOfSplitPaneEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.SplitPaneEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.SplitPaneEditProxy[] objects = new com.smartgwt.client.tools.SplitPaneEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.SplitPaneEditProxy obj = (com.smartgwt.client.tools.SplitPaneEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.SplitPaneEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ListStyleType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ListStyleType[]
	 */
    public static com.smartgwt.client.types.ListStyleType[] arrayOfListStyleType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ListStyleType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ListStyleType[] objects = new com.smartgwt.client.types.ListStyleType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ListStyleType obj = EnumUtil.getEnum(com.smartgwt.client.types.ListStyleType.values(), value);

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

            com.smartgwt.client.widgets.form.fields.DateItem obj = com.smartgwt.client.widgets.form.fields.DateItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TimeUnit[] objects = new com.smartgwt.client.types.TimeUnit[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TimeUnit obj = EnumUtil.getEnum(com.smartgwt.client.types.TimeUnit.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.InlineEditEvent} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.InlineEditEvent[]
	 */
    public static com.smartgwt.client.types.InlineEditEvent[] arrayOfInlineEditEvent(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.InlineEditEvent[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.InlineEditEvent[] objects = new com.smartgwt.client.types.InlineEditEvent[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.InlineEditEvent obj = EnumUtil.getEnum(com.smartgwt.client.types.InlineEditEvent.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridFetchDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridFetchDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridFetchDataTask[] arrayOfGridFetchDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridFetchDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridFetchDataTask[] objects = new com.smartgwt.client.util.workflow.GridFetchDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridFetchDataTask obj = (com.smartgwt.client.util.workflow.GridFetchDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridFetchDataTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.NavigateListPaneTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.NavigateListPaneTask[]
	 */
    public static com.smartgwt.client.util.workflow.NavigateListPaneTask[] arrayOfNavigateListPaneTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.NavigateListPaneTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.NavigateListPaneTask[] objects = new com.smartgwt.client.util.workflow.NavigateListPaneTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.NavigateListPaneTask obj = (com.smartgwt.client.util.workflow.NavigateListPaneTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.NavigateListPaneTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.FormEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.FormEditProxy[]
	 */
    public static com.smartgwt.client.tools.FormEditProxy[] arrayOfFormEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.FormEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.FormEditProxy[] objects = new com.smartgwt.client.tools.FormEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.FormEditProxy obj = (com.smartgwt.client.tools.FormEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.FormEditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.FacetChartEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.FacetChartEditProxy[]
	 */
    public static com.smartgwt.client.tools.FacetChartEditProxy[] arrayOfFacetChartEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.FacetChartEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.FacetChartEditProxy[] objects = new com.smartgwt.client.tools.FacetChartEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.FacetChartEditProxy obj = (com.smartgwt.client.tools.FacetChartEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.FacetChartEditProxy(components[i]));
            }

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

            com.smartgwt.client.util.workflow.StateTask obj = (com.smartgwt.client.util.workflow.StateTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.StateTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.MenuPalette} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.MenuPalette[]
	 */
    public static com.smartgwt.client.tools.MenuPalette[] arrayOfMenuPalette(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.MenuPalette[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.MenuPalette[] objects = new com.smartgwt.client.tools.MenuPalette[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.MenuPalette obj = (com.smartgwt.client.tools.MenuPalette) com.smartgwt.client.tools.MenuPalette.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EscapeKeyEditAction[] objects = new com.smartgwt.client.types.EscapeKeyEditAction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EscapeKeyEditAction obj = EnumUtil.getEnum(com.smartgwt.client.types.EscapeKeyEditAction.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LayoutPolicy[] objects = new com.smartgwt.client.types.LayoutPolicy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LayoutPolicy obj = EnumUtil.getEnum(com.smartgwt.client.types.LayoutPolicy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.EditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.EditProxy[]
	 */
    public static com.smartgwt.client.tools.EditProxy[] arrayOfEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.EditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.EditProxy[] objects = new com.smartgwt.client.tools.EditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.EditProxy obj = (com.smartgwt.client.tools.EditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.EditProxy(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.NotifyTransition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.NotifyTransition[]
	 */
    public static com.smartgwt.client.types.NotifyTransition[] arrayOfNotifyTransition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.NotifyTransition[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.NotifyTransition[] objects = new com.smartgwt.client.types.NotifyTransition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NotifyTransition obj = EnumUtil.getEnum(com.smartgwt.client.types.NotifyTransition.values(), value);

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

            com.smartgwt.client.util.workflow.ScriptTask obj = (com.smartgwt.client.util.workflow.ScriptTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ScriptTask(components[i]));
            }

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

            com.smartgwt.client.widgets.drawing.DrawGroup obj = (com.smartgwt.client.widgets.drawing.DrawGroup) com.smartgwt.client.widgets.drawing.DrawGroup.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.CurrentPane} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.CurrentPane[]
	 */
    public static com.smartgwt.client.types.CurrentPane[] arrayOfCurrentPane(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.CurrentPane[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.CurrentPane[] objects = new com.smartgwt.client.types.CurrentPane[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CurrentPane obj = EnumUtil.getEnum(com.smartgwt.client.types.CurrentPane.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EmbeddedPosition[] objects = new com.smartgwt.client.types.EmbeddedPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EmbeddedPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.EmbeddedPosition.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RegressionLineType[] objects = new com.smartgwt.client.types.RegressionLineType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RegressionLineType obj = EnumUtil.getEnum(com.smartgwt.client.types.RegressionLineType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.notify.NotifySettings} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.notify.NotifySettings[]
	 */
    public static com.smartgwt.client.widgets.notify.NotifySettings[] arrayOfNotifySettings(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.notify.NotifySettings[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.notify.NotifySettings[] ret = new com.smartgwt.client.widgets.notify.NotifySettings[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.notify.NotifySettings(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.notify.NotifySettings[] objects = new com.smartgwt.client.widgets.notify.NotifySettings[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.notify.NotifySettings obj = (com.smartgwt.client.widgets.notify.NotifySettings) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.notify.NotifySettings(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ExportDisplay[] objects = new com.smartgwt.client.types.ExportDisplay[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportDisplay obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportDisplay.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DSProtocol[] objects = new com.smartgwt.client.types.DSProtocol[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSProtocol obj = EnumUtil.getEnum(com.smartgwt.client.types.DSProtocol.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.data.FileSpec} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.data.FileSpec[]
	 */
    public static com.smartgwt.client.data.FileSpec[] arrayOfFileSpec(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.data.FileSpec[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.data.FileSpec[] ret = new com.smartgwt.client.data.FileSpec[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.data.FileSpec(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.data.FileSpec[] objects = new com.smartgwt.client.data.FileSpec[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.data.FileSpec obj = (com.smartgwt.client.data.FileSpec) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.data.FileSpec(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridFetchRelatedDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridFetchRelatedDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridFetchRelatedDataTask[] arrayOfGridFetchRelatedDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridFetchRelatedDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridFetchRelatedDataTask[] objects = new com.smartgwt.client.util.workflow.GridFetchRelatedDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridFetchRelatedDataTask obj = (com.smartgwt.client.util.workflow.GridFetchRelatedDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridFetchRelatedDataTask(components[i]));
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

            com.smartgwt.client.widgets.FiscalYear obj = com.smartgwt.client.widgets.FiscalYear.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AcePosition} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AcePosition[]
	 */
    public static com.smartgwt.client.widgets.ace.AcePosition[] arrayOfAcePosition(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AcePosition[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.widgets.ace.AcePosition[] ret = new com.smartgwt.client.widgets.ace.AcePosition[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.widgets.ace.AcePosition(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AcePosition[] objects = new com.smartgwt.client.widgets.ace.AcePosition[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AcePosition obj = (com.smartgwt.client.widgets.ace.AcePosition) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AcePosition(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.CharacterCasing[] objects = new com.smartgwt.client.types.CharacterCasing[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CharacterCasing obj = EnumUtil.getEnum(com.smartgwt.client.types.CharacterCasing.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.DSAddTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.DSAddTask[]
	 */
    public static com.smartgwt.client.util.workflow.DSAddTask[] arrayOfDSAddTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.DSAddTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.DSAddTask[] objects = new com.smartgwt.client.util.workflow.DSAddTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.DSAddTask obj = (com.smartgwt.client.util.workflow.DSAddTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.DSAddTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.State[] objects = new com.smartgwt.client.types.State[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.State obj = EnumUtil.getEnum(com.smartgwt.client.types.State.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DSServerType[] objects = new com.smartgwt.client.types.DSServerType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DSServerType obj = EnumUtil.getEnum(com.smartgwt.client.types.DSServerType.values(), value);

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

            com.smartgwt.client.widgets.drawing.DrawSector obj = (com.smartgwt.client.widgets.drawing.DrawSector) com.smartgwt.client.widgets.drawing.DrawSector.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.MiniDateRangeItem obj = com.smartgwt.client.widgets.form.fields.MiniDateRangeItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.SetSectionTitleTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.SetSectionTitleTask[]
	 */
    public static com.smartgwt.client.util.workflow.SetSectionTitleTask[] arrayOfSetSectionTitleTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.SetSectionTitleTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.SetSectionTitleTask[] objects = new com.smartgwt.client.util.workflow.SetSectionTitleTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.SetSectionTitleTask obj = (com.smartgwt.client.util.workflow.SetSectionTitleTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.SetSectionTitleTask(components[i]));
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

            com.smartgwt.client.widgets.form.fields.DoubleItem obj = com.smartgwt.client.widgets.form.fields.DoubleItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.SendTransactionTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.SendTransactionTask[]
	 */
    public static com.smartgwt.client.util.workflow.SendTransactionTask[] arrayOfSendTransactionTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.SendTransactionTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.SendTransactionTask[] objects = new com.smartgwt.client.util.workflow.SendTransactionTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.SendTransactionTask obj = (com.smartgwt.client.util.workflow.SendTransactionTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.SendTransactionTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DefaultSampleRecord} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DefaultSampleRecord[]
	 */
    public static com.smartgwt.client.types.DefaultSampleRecord[] arrayOfDefaultSampleRecord(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DefaultSampleRecord[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DefaultSampleRecord[] objects = new com.smartgwt.client.types.DefaultSampleRecord[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DefaultSampleRecord obj = EnumUtil.getEnum(com.smartgwt.client.types.DefaultSampleRecord.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LocatorTypeStrategy[] objects = new com.smartgwt.client.types.LocatorTypeStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LocatorTypeStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.LocatorTypeStrategy.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FieldImportStrategy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FieldImportStrategy[]
	 */
    public static com.smartgwt.client.types.FieldImportStrategy[] arrayOfFieldImportStrategy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FieldImportStrategy[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FieldImportStrategy[] objects = new com.smartgwt.client.types.FieldImportStrategy[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldImportStrategy obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldImportStrategy.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ExportImageFormat[] objects = new com.smartgwt.client.types.ExportImageFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ExportImageFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.ExportImageFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ShowDataValuesMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ShowDataValuesMode[]
	 */
    public static com.smartgwt.client.types.ShowDataValuesMode[] arrayOfShowDataValuesMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ShowDataValuesMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ShowDataValuesMode[] objects = new com.smartgwt.client.types.ShowDataValuesMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ShowDataValuesMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ShowDataValuesMode.values(), value);

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

            com.smartgwt.client.widgets.drawing.DrawPane obj = (com.smartgwt.client.widgets.drawing.DrawPane) com.smartgwt.client.widgets.drawing.DrawPane.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.CheckboxItem obj = com.smartgwt.client.widgets.form.fields.CheckboxItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.SectionStackSectionEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.SectionStackSectionEditProxy[]
	 */
    public static com.smartgwt.client.tools.SectionStackSectionEditProxy[] arrayOfSectionStackSectionEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.SectionStackSectionEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.SectionStackSectionEditProxy[] objects = new com.smartgwt.client.tools.SectionStackSectionEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.SectionStackSectionEditProxy obj = (com.smartgwt.client.tools.SectionStackSectionEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.SectionStackSectionEditProxy(components[i]));
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

            com.smartgwt.client.widgets.menu.Menu obj = (com.smartgwt.client.widgets.menu.Menu) com.smartgwt.client.widgets.menu.Menu.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectionBoundary[] objects = new com.smartgwt.client.types.SelectionBoundary[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectionBoundary obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectionBoundary.values(), value);

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

            com.smartgwt.client.widgets.layout.Layout obj = (com.smartgwt.client.widgets.layout.Layout) com.smartgwt.client.widgets.layout.Layout.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Direction[] objects = new com.smartgwt.client.types.Direction[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Direction obj = EnumUtil.getEnum(com.smartgwt.client.types.Direction.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.MultiSortPanel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.MultiSortPanel[]
	 */
    public static com.smartgwt.client.widgets.MultiSortPanel[] arrayOfMultiSortPanel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.MultiSortPanel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.MultiSortPanel[] objects = new com.smartgwt.client.widgets.MultiSortPanel[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.MultiSortPanel obj = (com.smartgwt.client.widgets.MultiSortPanel) com.smartgwt.client.widgets.MultiSortPanel.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.toolbar.ToolStripResizer obj = (com.smartgwt.client.widgets.toolbar.ToolStripResizer) com.smartgwt.client.widgets.toolbar.ToolStripResizer.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ChildrenPropertyMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ChildrenPropertyMode[]
	 */
    public static com.smartgwt.client.types.ChildrenPropertyMode[] arrayOfChildrenPropertyMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ChildrenPropertyMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ChildrenPropertyMode[] objects = new com.smartgwt.client.types.ChildrenPropertyMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ChildrenPropertyMode obj = EnumUtil.getEnum(com.smartgwt.client.types.ChildrenPropertyMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.CriteriaCombineOperator[] objects = new com.smartgwt.client.types.CriteriaCombineOperator[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.CriteriaCombineOperator obj = EnumUtil.getEnum(com.smartgwt.client.types.CriteriaCombineOperator.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormSaveDataTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormSaveDataTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormSaveDataTask[] arrayOfFormSaveDataTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormSaveDataTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormSaveDataTask[] objects = new com.smartgwt.client.util.workflow.FormSaveDataTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormSaveDataTask obj = (com.smartgwt.client.util.workflow.FormSaveDataTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormSaveDataTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Side[] objects = new com.smartgwt.client.types.Side[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Side obj = EnumUtil.getEnum(com.smartgwt.client.types.Side.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.RecordDropAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.RecordDropAppearance[]
	 */
    public static com.smartgwt.client.types.RecordDropAppearance[] arrayOfRecordDropAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.RecordDropAppearance[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecordDropAppearance[] objects = new com.smartgwt.client.types.RecordDropAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordDropAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordDropAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormEditNewRecordTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormEditNewRecordTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormEditNewRecordTask[] arrayOfFormEditNewRecordTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormEditNewRecordTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormEditNewRecordTask[] objects = new com.smartgwt.client.util.workflow.FormEditNewRecordTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormEditNewRecordTask obj = (com.smartgwt.client.util.workflow.FormEditNewRecordTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormEditNewRecordTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DrawingType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DrawingType[]
	 */
    public static com.smartgwt.client.types.DrawingType[] arrayOfDrawingType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DrawingType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DrawingType[] objects = new com.smartgwt.client.types.DrawingType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DrawingType obj = EnumUtil.getEnum(com.smartgwt.client.types.DrawingType.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RowSpanEditMode[] objects = new com.smartgwt.client.types.RowSpanEditMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RowSpanEditMode obj = EnumUtil.getEnum(com.smartgwt.client.types.RowSpanEditMode.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.DSFetchTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.DSFetchTask[]
	 */
    public static com.smartgwt.client.util.workflow.DSFetchTask[] arrayOfDSFetchTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.DSFetchTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.DSFetchTask[] objects = new com.smartgwt.client.util.workflow.DSFetchTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.DSFetchTask obj = (com.smartgwt.client.util.workflow.DSFetchTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.DSFetchTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FieldAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FieldAppearance[]
	 */
    public static com.smartgwt.client.types.FieldAppearance[] arrayOfFieldAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FieldAppearance[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FieldAppearance[] objects = new com.smartgwt.client.types.FieldAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.TieMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.TieMode[]
	 */
    public static com.smartgwt.client.types.TieMode[] arrayOfTieMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.TieMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.TieMode[] objects = new com.smartgwt.client.types.TieMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.TieMode obj = EnumUtil.getEnum(com.smartgwt.client.types.TieMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LogicalOperator[] objects = new com.smartgwt.client.types.LogicalOperator[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LogicalOperator obj = EnumUtil.getEnum(com.smartgwt.client.types.LogicalOperator.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.BackgroundRepeat[] objects = new com.smartgwt.client.types.BackgroundRepeat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.BackgroundRepeat obj = EnumUtil.getEnum(com.smartgwt.client.types.BackgroundRepeat.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RPCTransport[] objects = new com.smartgwt.client.types.RPCTransport[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RPCTransport obj = EnumUtil.getEnum(com.smartgwt.client.types.RPCTransport.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.NavPanel} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.NavPanel[]
	 */
    public static com.smartgwt.client.widgets.layout.NavPanel[] arrayOfNavPanel(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.NavPanel[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.NavPanel[] objects = new com.smartgwt.client.widgets.layout.NavPanel[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.NavPanel obj = (com.smartgwt.client.widgets.layout.NavPanel) com.smartgwt.client.widgets.layout.NavPanel.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SortArrow[] objects = new com.smartgwt.client.types.SortArrow[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SortArrow obj = EnumUtil.getEnum(com.smartgwt.client.types.SortArrow.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DragAppearance[] objects = new com.smartgwt.client.types.DragAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.DragAppearance.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceRange} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceRange[]
	 */
    public static com.smartgwt.client.widgets.ace.AceRange[] arrayOfAceRange(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceRange[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceRange[] objects = new com.smartgwt.client.widgets.ace.AceRange[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceRange obj = (com.smartgwt.client.widgets.ace.AceRange) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceRange(components[i]));
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

            com.smartgwt.client.widgets.Canvas obj = (com.smartgwt.client.widgets.Canvas) com.smartgwt.client.widgets.Canvas.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MockDataType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MockDataType[]
	 */
    public static com.smartgwt.client.types.MockDataType[] arrayOfMockDataType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MockDataType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MockDataType[] objects = new com.smartgwt.client.types.MockDataType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MockDataType obj = EnumUtil.getEnum(com.smartgwt.client.types.MockDataType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.fields.ColorItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.fields.ColorItem[]
	 */
    public static com.smartgwt.client.widgets.form.fields.ColorItem[] arrayOfColorItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.fields.ColorItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.fields.ColorItem[] objects = new com.smartgwt.client.widgets.form.fields.ColorItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.fields.ColorItem obj = com.smartgwt.client.widgets.form.fields.ColorItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

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

            com.smartgwt.client.widgets.tab.Tab obj = com.smartgwt.client.widgets.tab.Tab.getOrCreateRef(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MockDataFormat} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MockDataFormat[]
	 */
    public static com.smartgwt.client.types.MockDataFormat[] arrayOfMockDataFormat(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MockDataFormat[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MockDataFormat[] objects = new com.smartgwt.client.types.MockDataFormat[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MockDataFormat obj = EnumUtil.getEnum(com.smartgwt.client.types.MockDataFormat.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormEditRecordTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormEditRecordTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormEditRecordTask[] arrayOfFormEditRecordTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormEditRecordTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormEditRecordTask[] objects = new com.smartgwt.client.util.workflow.FormEditRecordTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormEditRecordTask obj = (com.smartgwt.client.util.workflow.FormEditRecordTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormEditRecordTask(components[i]));
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

            com.smartgwt.client.util.workflow.XORGateway obj = (com.smartgwt.client.util.workflow.XORGateway) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.XORGateway(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormClearValuesTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormClearValuesTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormClearValuesTask[] arrayOfFormClearValuesTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormClearValuesTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormClearValuesTask[] objects = new com.smartgwt.client.util.workflow.FormClearValuesTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormClearValuesTask obj = (com.smartgwt.client.util.workflow.FormClearValuesTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormClearValuesTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FiscalYearMode[] objects = new com.smartgwt.client.types.FiscalYearMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FiscalYearMode obj = EnumUtil.getEnum(com.smartgwt.client.types.FiscalYearMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LabelCollapseMode[] objects = new com.smartgwt.client.types.LabelCollapseMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LabelCollapseMode obj = EnumUtil.getEnum(com.smartgwt.client.types.LabelCollapseMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.Axis[] objects = new com.smartgwt.client.types.Axis[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.Axis obj = EnumUtil.getEnum(com.smartgwt.client.types.Axis.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormSetValuesTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormSetValuesTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormSetValuesTask[] arrayOfFormSetValuesTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormSetValuesTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormSetValuesTask[] objects = new com.smartgwt.client.util.workflow.FormSetValuesTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormSetValuesTask obj = (com.smartgwt.client.util.workflow.FormSetValuesTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormSetValuesTask(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ZoomStartPosition[] objects = new com.smartgwt.client.types.ZoomStartPosition[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ZoomStartPosition obj = EnumUtil.getEnum(com.smartgwt.client.types.ZoomStartPosition.values(), value);

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

            com.smartgwt.client.widgets.form.fields.SelectOtherItem obj = com.smartgwt.client.widgets.form.fields.SelectOtherItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.GridStartEditingTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.GridStartEditingTask[]
	 */
    public static com.smartgwt.client.util.workflow.GridStartEditingTask[] arrayOfGridStartEditingTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.GridStartEditingTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.GridStartEditingTask[] objects = new com.smartgwt.client.util.workflow.GridStartEditingTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.GridStartEditingTask obj = (com.smartgwt.client.util.workflow.GridStartEditingTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.GridStartEditingTask(components[i]));
            }

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

            com.smartgwt.client.widgets.MultiGroupDialog obj = (com.smartgwt.client.widgets.MultiGroupDialog) com.smartgwt.client.widgets.MultiGroupDialog.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.toolbar.ToolStripSeparator obj = (com.smartgwt.client.widgets.toolbar.ToolStripSeparator) com.smartgwt.client.widgets.toolbar.ToolStripSeparator.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoScrollDataApproach} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoScrollDataApproach[]
	 */
    public static com.smartgwt.client.types.AutoScrollDataApproach[] arrayOfAutoScrollDataApproach(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoScrollDataApproach[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoScrollDataApproach[] objects = new com.smartgwt.client.types.AutoScrollDataApproach[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoScrollDataApproach obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoScrollDataApproach.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.PaletteNode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.PaletteNode[]
	 */
    public static com.smartgwt.client.tools.PaletteNode[] arrayOfPaletteNode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.PaletteNode[]{};
        }

		if (JSOHelper.isArray(nativeArray)==false && com.smartgwt.client.data.ResultSet.isResultSet(nativeArray)==false) {
			com.smartgwt.client.tools.PaletteNode[] ret = new com.smartgwt.client.tools.PaletteNode[1];
            ret[0] = (nativeArray == null ? null : new com.smartgwt.client.tools.PaletteNode(nativeArray));
	        return ret;
		}

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.PaletteNode[] objects = new com.smartgwt.client.tools.PaletteNode[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.PaletteNode obj = (com.smartgwt.client.tools.PaletteNode) ((DataClass) RefDataClass.getRef(components[i]));
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.PaletteNode(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.ResizeKnobPoint} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.ResizeKnobPoint[]
	 */
    public static com.smartgwt.client.types.ResizeKnobPoint[] arrayOfResizeKnobPoint(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.ResizeKnobPoint[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ResizeKnobPoint[] objects = new com.smartgwt.client.types.ResizeKnobPoint[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ResizeKnobPoint obj = EnumUtil.getEnum(com.smartgwt.client.types.ResizeKnobPoint.values(), value);

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

            com.smartgwt.client.widgets.HTMLPane obj = (com.smartgwt.client.widgets.HTMLPane) com.smartgwt.client.widgets.HTMLPane.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.form.fields.MultiComboBoxItem obj = com.smartgwt.client.widgets.form.fields.MultiComboBoxItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.TabSetEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.TabSetEditProxy[]
	 */
    public static com.smartgwt.client.tools.TabSetEditProxy[] arrayOfTabSetEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.TabSetEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.TabSetEditProxy[] objects = new com.smartgwt.client.tools.TabSetEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.TabSetEditProxy obj = (com.smartgwt.client.tools.TabSetEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.TabSetEditProxy(components[i]));
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

            com.smartgwt.client.widgets.layout.SectionStack obj = (com.smartgwt.client.widgets.layout.SectionStack) com.smartgwt.client.widgets.layout.SectionStack.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceEditor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceEditor[]
	 */
    public static com.smartgwt.client.widgets.ace.AceEditor[] arrayOfAceEditor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceEditor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceEditor[] objects = new com.smartgwt.client.widgets.ace.AceEditor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceEditor obj = (com.smartgwt.client.widgets.ace.AceEditor) com.smartgwt.client.widgets.ace.AceEditor.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.NavigationMethod} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.NavigationMethod[]
	 */
    public static com.smartgwt.client.types.NavigationMethod[] arrayOfNavigationMethod(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.NavigationMethod[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.NavigationMethod[] objects = new com.smartgwt.client.types.NavigationMethod[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.NavigationMethod obj = EnumUtil.getEnum(com.smartgwt.client.types.NavigationMethod.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.layout.DataView} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.layout.DataView[]
	 */
    public static com.smartgwt.client.widgets.layout.DataView[] arrayOfDataView(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.layout.DataView[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.layout.DataView[] objects = new com.smartgwt.client.widgets.layout.DataView[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.layout.DataView obj = (com.smartgwt.client.widgets.layout.DataView) com.smartgwt.client.widgets.layout.DataView.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.drawing.GaugeSector obj = com.smartgwt.client.widgets.drawing.GaugeSector.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.menu.TreeMenuButton obj = (com.smartgwt.client.widgets.menu.TreeMenuButton) com.smartgwt.client.widgets.menu.TreeMenuButton.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SelectedAppearance} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SelectedAppearance[]
	 */
    public static com.smartgwt.client.types.SelectedAppearance[] arrayOfSelectedAppearance(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SelectedAppearance[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SelectedAppearance[] objects = new com.smartgwt.client.types.SelectedAppearance[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SelectedAppearance obj = EnumUtil.getEnum(com.smartgwt.client.types.SelectedAppearance.values(), value);

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

            com.smartgwt.client.widgets.drawing.DrawCurve obj = (com.smartgwt.client.widgets.drawing.DrawCurve) com.smartgwt.client.widgets.drawing.DrawCurve.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.IndicatorCanvas} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.IndicatorCanvas[]
	 */
    public static com.smartgwt.client.widgets.calendar.IndicatorCanvas[] arrayOfIndicatorCanvas(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.IndicatorCanvas[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.IndicatorCanvas[] objects = new com.smartgwt.client.widgets.calendar.IndicatorCanvas[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.IndicatorCanvas obj = (com.smartgwt.client.widgets.calendar.IndicatorCanvas) com.smartgwt.client.widgets.calendar.IndicatorCanvas.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.grid.ColumnTree obj = (com.smartgwt.client.widgets.grid.ColumnTree) com.smartgwt.client.widgets.grid.ColumnTree.getByJSObject(components[i]);

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
	 * {@link com.smartgwt.client.types.AutoFitIconFieldType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoFitIconFieldType[]
	 */
    public static com.smartgwt.client.types.AutoFitIconFieldType[] arrayOfAutoFitIconFieldType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoFitIconFieldType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoFitIconFieldType[] objects = new com.smartgwt.client.types.AutoFitIconFieldType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoFitIconFieldType obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoFitIconFieldType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.ProgressbarEditProxy} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.ProgressbarEditProxy[]
	 */
    public static com.smartgwt.client.tools.ProgressbarEditProxy[] arrayOfProgressbarEditProxy(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.ProgressbarEditProxy[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.ProgressbarEditProxy[] objects = new com.smartgwt.client.tools.ProgressbarEditProxy[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.ProgressbarEditProxy obj = (com.smartgwt.client.tools.ProgressbarEditProxy) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.tools.ProgressbarEditProxy(components[i]));
            }

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FormItemType[] objects = new com.smartgwt.client.types.FormItemType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FormItemType obj = EnumUtil.getEnum(com.smartgwt.client.types.FormItemType.values(), value);

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

            com.smartgwt.client.widgets.tile.TileRecord obj = com.smartgwt.client.widgets.tile.TileRecord.getOrCreateRef(components[i]);

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

            com.smartgwt.client.widgets.PrintCanvas obj = (com.smartgwt.client.widgets.PrintCanvas) com.smartgwt.client.widgets.PrintCanvas.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.tree.NodeLocator} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.tree.NodeLocator[]
	 */
    public static com.smartgwt.client.widgets.tree.NodeLocator[] arrayOfNodeLocator(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.tree.NodeLocator[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.tree.NodeLocator[] objects = new com.smartgwt.client.widgets.tree.NodeLocator[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.tree.NodeLocator obj = (com.smartgwt.client.widgets.tree.NodeLocator) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.tree.NodeLocator(components[i]));
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

            com.smartgwt.client.widgets.toolbar.RibbonGroup obj = (com.smartgwt.client.widgets.toolbar.RibbonGroup) com.smartgwt.client.widgets.toolbar.RibbonGroup.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.layout.VLayout obj = (com.smartgwt.client.widgets.layout.VLayout) com.smartgwt.client.widgets.layout.VLayout.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormDisableFieldTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormDisableFieldTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormDisableFieldTask[] arrayOfFormDisableFieldTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormDisableFieldTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormDisableFieldTask[] objects = new com.smartgwt.client.util.workflow.FormDisableFieldTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormDisableFieldTask obj = (com.smartgwt.client.util.workflow.FormDisableFieldTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormDisableFieldTask(components[i]));
            }

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

            com.smartgwt.client.util.workflow.ServiceTask obj = (com.smartgwt.client.util.workflow.ServiceTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.ServiceTask(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.calendar.CalendarView} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.calendar.CalendarView[]
	 */
    public static com.smartgwt.client.widgets.calendar.CalendarView[] arrayOfCalendarView(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.calendar.CalendarView[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.calendar.CalendarView[] objects = new com.smartgwt.client.widgets.calendar.CalendarView[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.calendar.CalendarView obj = (com.smartgwt.client.widgets.calendar.CalendarView) com.smartgwt.client.widgets.calendar.CalendarView.getByJSObject(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.ForceTextApproach[] objects = new com.smartgwt.client.types.ForceTextApproach[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.ForceTextApproach obj = EnumUtil.getEnum(com.smartgwt.client.types.ForceTextApproach.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.FormEditSelectedTask} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.FormEditSelectedTask[]
	 */
    public static com.smartgwt.client.util.workflow.FormEditSelectedTask[] arrayOfFormEditSelectedTask(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.FormEditSelectedTask[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.FormEditSelectedTask[] objects = new com.smartgwt.client.util.workflow.FormEditSelectedTask[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.FormEditSelectedTask obj = (com.smartgwt.client.util.workflow.FormEditSelectedTask) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.FormEditSelectedTask(components[i]));
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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DragIntersectStyle[] objects = new com.smartgwt.client.types.DragIntersectStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DragIntersectStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.DragIntersectStyle.values(), value);

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

            com.smartgwt.client.widgets.Splitbar obj = (com.smartgwt.client.widgets.Splitbar) com.smartgwt.client.widgets.Splitbar.getByJSObject(components[i]);

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

            com.smartgwt.client.widgets.toolbar.ToolStripButton obj = (com.smartgwt.client.widgets.toolbar.ToolStripButton) com.smartgwt.client.widgets.toolbar.ToolStripButton.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.GroupTreeChangeType} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.GroupTreeChangeType[]
	 */
    public static com.smartgwt.client.types.GroupTreeChangeType[] arrayOfGroupTreeChangeType(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.GroupTreeChangeType[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.GroupTreeChangeType[] objects = new com.smartgwt.client.types.GroupTreeChangeType[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.GroupTreeChangeType obj = EnumUtil.getEnum(com.smartgwt.client.types.GroupTreeChangeType.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.tools.EditTree} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.tools.EditTree[]
	 */
    public static com.smartgwt.client.tools.EditTree[] arrayOfEditTree(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.tools.EditTree[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.tools.EditTree[] objects = new com.smartgwt.client.tools.EditTree[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.tools.EditTree obj = (com.smartgwt.client.tools.EditTree) com.smartgwt.client.tools.EditTree.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.ace.AceDocument} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.ace.AceDocument[]
	 */
    public static com.smartgwt.client.widgets.ace.AceDocument[] arrayOfAceDocument(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.ace.AceDocument[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.ace.AceDocument[] objects = new com.smartgwt.client.widgets.ace.AceDocument[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.ace.AceDocument obj = (com.smartgwt.client.widgets.ace.AceDocument) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.widgets.ace.AceDocument(components[i]));
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
	 * {@link com.smartgwt.client.types.FireStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FireStyle[]
	 */
    public static com.smartgwt.client.types.FireStyle[] arrayOfFireStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FireStyle[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FireStyle[] objects = new com.smartgwt.client.types.FireStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FireStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.FireStyle.values(), value);

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

            com.smartgwt.client.widgets.form.fields.ButtonItem obj = com.smartgwt.client.widgets.form.fields.ButtonItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.FieldAuditMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.FieldAuditMode[]
	 */
    public static com.smartgwt.client.types.FieldAuditMode[] arrayOfFieldAuditMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.FieldAuditMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.FieldAuditMode[] objects = new com.smartgwt.client.types.FieldAuditMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.FieldAuditMode obj = EnumUtil.getEnum(com.smartgwt.client.types.FieldAuditMode.values(), value);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.EdgeName[] objects = new com.smartgwt.client.types.EdgeName[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.EdgeName obj = EnumUtil.getEnum(com.smartgwt.client.types.EdgeName.values(), value);

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

            com.smartgwt.client.widgets.Img obj = (com.smartgwt.client.widgets.Img) com.smartgwt.client.widgets.Img.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.AutoComplete} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.AutoComplete[]
	 */
    public static com.smartgwt.client.types.AutoComplete[] arrayOfAutoComplete(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.AutoComplete[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.AutoComplete[] objects = new com.smartgwt.client.types.AutoComplete[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.AutoComplete obj = EnumUtil.getEnum(com.smartgwt.client.types.AutoComplete.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.LineBreakStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.LineBreakStyle[]
	 */
    public static com.smartgwt.client.types.LineBreakStyle[] arrayOfLineBreakStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.LineBreakStyle[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.LineBreakStyle[] objects = new com.smartgwt.client.types.LineBreakStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.LineBreakStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.LineBreakStyle.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.form.PresetCriteriaItem} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.form.PresetCriteriaItem[]
	 */
    public static com.smartgwt.client.widgets.form.PresetCriteriaItem[] arrayOfPresetCriteriaItem(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.form.PresetCriteriaItem[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.form.PresetCriteriaItem[] objects = new com.smartgwt.client.widgets.form.PresetCriteriaItem[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.form.PresetCriteriaItem obj = com.smartgwt.client.widgets.form.PresetCriteriaItem.getOrCreateRef(components[i]);

            if (obj != null && obj.getAttributeAsJavaScriptObject("__ref") == null) {
                obj = com.smartgwt.client.util.ObjectFactory.createFormItem(obj.getClassName(),components[i]);
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

            com.smartgwt.client.widgets.viewer.DetailViewerRecord obj = com.smartgwt.client.widgets.viewer.DetailViewerRecord.getOrCreateRef(components[i]);

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

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.RecordLayout[] objects = new com.smartgwt.client.types.RecordLayout[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.RecordLayout obj = EnumUtil.getEnum(com.smartgwt.client.types.RecordLayout.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.DeviceMode} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.DeviceMode[]
	 */
    public static com.smartgwt.client.types.DeviceMode[] arrayOfDeviceMode(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.DeviceMode[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.DeviceMode[] objects = new com.smartgwt.client.types.DeviceMode[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.DeviceMode obj = EnumUtil.getEnum(com.smartgwt.client.types.DeviceMode.values(), value);

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

            com.smartgwt.client.widgets.plugins.Flashlet obj = (com.smartgwt.client.widgets.plugins.Flashlet) com.smartgwt.client.widgets.plugins.Flashlet.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.SnapGridStyle} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.SnapGridStyle[]
	 */
    public static com.smartgwt.client.types.SnapGridStyle[] arrayOfSnapGridStyle(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.SnapGridStyle[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.SnapGridStyle[] objects = new com.smartgwt.client.types.SnapGridStyle[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.SnapGridStyle obj = EnumUtil.getEnum(com.smartgwt.client.types.SnapGridStyle.values(), value);

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

            com.smartgwt.client.widgets.drawing.DrawLabel obj = (com.smartgwt.client.widgets.drawing.DrawLabel) com.smartgwt.client.widgets.drawing.DrawLabel.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.JSSyntaxHiliter} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.JSSyntaxHiliter[]
	 */
    public static com.smartgwt.client.util.JSSyntaxHiliter[] arrayOfJSSyntaxHiliter(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.JSSyntaxHiliter[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.JSSyntaxHiliter[] objects = new com.smartgwt.client.util.JSSyntaxHiliter[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.JSSyntaxHiliter obj = (com.smartgwt.client.util.JSSyntaxHiliter) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.JSSyntaxHiliter(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.types.MultipleFieldStorage} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.types.MultipleFieldStorage[]
	 */
    public static com.smartgwt.client.types.MultipleFieldStorage[] arrayOfMultipleFieldStorage(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.types.MultipleFieldStorage[]{};
        }

        String[] values = JSOHelper.convertToJavaStringArray(nativeArray);
        com.smartgwt.client.types.MultipleFieldStorage[] objects = new com.smartgwt.client.types.MultipleFieldStorage[values.length];

        for (int i = 0; i < values.length; i++) {

            String value = values[i];
            com.smartgwt.client.types.MultipleFieldStorage obj = EnumUtil.getEnum(com.smartgwt.client.types.MultipleFieldStorage.values(), value);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.widgets.grid.RecordEditor} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.widgets.grid.RecordEditor[]
	 */
    public static com.smartgwt.client.widgets.grid.RecordEditor[] arrayOfRecordEditor(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.widgets.grid.RecordEditor[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.widgets.grid.RecordEditor[] objects = new com.smartgwt.client.widgets.grid.RecordEditor[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.widgets.grid.RecordEditor obj = (com.smartgwt.client.widgets.grid.RecordEditor) com.smartgwt.client.widgets.grid.RecordEditor.getByJSObject(components[i]);

            objects[i] = obj;
        }
        return objects;
    }

	/**
	 * Given the nativeArray JavaScriptObject, this method will return an array of
	 * {@link com.smartgwt.client.util.workflow.TaskDecision} objects.
	 * @param nativeArray
	 * @return com.smartgwt.client.util.workflow.TaskDecision[]
	 */
    public static com.smartgwt.client.util.workflow.TaskDecision[] arrayOfTaskDecision(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new com.smartgwt.client.util.workflow.TaskDecision[]{};
        }

        JavaScriptObject[] components = JSOHelper.toArray(nativeArray);
        com.smartgwt.client.util.workflow.TaskDecision[] objects = new com.smartgwt.client.util.workflow.TaskDecision[components.length];

        for (int i = 0; i < components.length; i++) {

            com.smartgwt.client.util.workflow.TaskDecision obj = (com.smartgwt.client.util.workflow.TaskDecision) BaseClass.getRef(components[i]);
            if (obj == null) {
                obj = (components[i] == null ? null : new com.smartgwt.client.util.workflow.TaskDecision(components[i]));
            }

            objects[i] = obj;
        }
        return objects;
    }

}
