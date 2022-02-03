package com.smartgwt.client.data;

import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.types.OperatorValueType;

/**
 * Specification of an operator for use in filtering, for example "equals".
 * Use with {@link com.smartgwt.client.data.DataSource#addSearchOperator DataSource.addSearchOperator()} 
 * to define custom filtering behaviors for client-side filtering.
 */
public class Operator extends RefDataClass {

    /**
     * Unique id for an operator, which appears within {@link com.smartgwt.client.data.AdvancedCriteria AdvancedCriteria}
     * as the {@link com.smartgwt.client.data.Operator Operator} property.
     * <P>
     * A list of built-in identifiers is {@link com.smartgwt.client.types.OperatorId here}.
     *
     * @param id
     */
    public void setID(String id) {
        setAttribute("ID", id);
    }

    /**
     * User-visible title for this operator, such as "doesn't contain".
     *
     * @param title
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    
    /**
     * Indicates the kind of value expected in a {@link com.smartgwt.client.data.Criterion Criterion} that uses this operator.
     * {@link com.smartgwt.client.types.OperatorValueType OperatorValueType} lists possibilities.
     * <P>
     * The default of <code>null</code> is equivalent to "fieldType", indicating that
     * {@link com.smartgwt.client.data.Criterion#getValue Criterion.getValue()} is expected to contain a value 
     * of the same type as the field indicated by 
     * {@link com.smartgwt.client.data.Criterion#getFieldName Criterion.getFieldName()}.
     *
     * @param valueType
     */
    public void setValueType(OperatorValueType valueType) {
        setAttribute("valueType", valueType);
    }
    
    /**
     * For an operator with {@link com.smartgwt.client.types.OperatorValueType#CUSTOM OperatorValueType.CUSTOM}, 
     * indicates what kind of FormItem to use to provide a user interface for creating a valid 
     * {@link com.smartgwt.client.data.Criterion Criterion}. The default of <code>null</code> means an ordinary 
     * TextItem is fine.
     *
     * @param editorType
     */
    public void setEditorType(String editorType) {
        com.smartgwt.client.bean.BeanFactory factory = com.smartgwt.client.bean.BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("editorType", editorType);
    }
    
}
