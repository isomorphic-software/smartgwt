
package com.smartgwt.client.docs;

/**
 * <h3>Advanced Filtering</h3>
 * Isomorphic {@link com.smartgwt.client.data.DataSource DataSources} provide an advanced
 * filtering mechanism for searching data, including a wide range of builtin {@link
 * com.smartgwt.client.data.Operator search-operators},  which allow searching via simple
 * comparisons like <code>equals</code> and <code>contains</code>  and more complex checks, like
 * <code>equalsOtherField</code> and <code>regex</code>.  You  can also add entirely custom
 * search-operators, via DataSource method  {@link
 * com.smartgwt.client.data.DataSource#addSearchOperator addSearchOperator()}. <P> For a full list
 * of operators, see {@link com.smartgwt.client.types.OperatorId OperatorId}.
 * @see com.smartgwt.client.types.OperatorValueType
 * @see com.smartgwt.client.types.OperatorId
 * @see com.smartgwt.client.data.DataSource#addSearchOperator
 * @see com.smartgwt.client.data.DataSource#setTypeOperators
 * @see com.smartgwt.client.data.Operator#condition
 * @see com.smartgwt.client.data.Operator#compareCriteria
 * @see com.smartgwt.client.data.DataSource#addSearchOperator
 * @see com.smartgwt.client.data.DataSource#getSearchOperator
 * @see com.smartgwt.client.data.DataSource#getTypeOperators
 * @see com.smartgwt.client.data.DataSource#setTypeOperators
 * @see com.smartgwt.client.data.DataSource#getFieldOperators
 * @see com.smartgwt.client.data.DataSource#getFieldDefaultOperator
 * @see com.smartgwt.client.data.DataSource#getFieldOperatorMap
 * @see com.smartgwt.client.data.DataSource#getTypeOperatorMap
 * @see com.smartgwt.client.data.DataSource#evaluateCriterion
 * @see com.smartgwt.client.data.AdvancedCriteria
 * @see com.smartgwt.client.data.Criterion
 * @see com.smartgwt.client.data.Operator
 * @see com.smartgwt.client.widgets.grid.ListGridField#getAllowFilterExpressions
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAllowFilterExpressions
 * @see com.smartgwt.client.data.AdvancedCriteria#getStrictSQLFiltering
 * @see com.smartgwt.client.data.Criterion#getOperator
 * @see com.smartgwt.client.data.Criterion#getFieldName
 * @see com.smartgwt.client.data.Criterion#getValue
 * @see com.smartgwt.client.data.Criterion#getCriteria
 * @see com.smartgwt.client.data.Criterion#getStart
 * @see com.smartgwt.client.data.Criterion#getEnd
 * @see com.smartgwt.client.data.Operator#getID
 * @see com.smartgwt.client.data.Operator#getTitle
 * @see com.smartgwt.client.data.Operator#getTitleProperty
 * @see com.smartgwt.client.data.Operator#getTextTitle
 * @see com.smartgwt.client.data.Operator#getTextTitleProperty
 * @see com.smartgwt.client.data.Operator#getFieldTypes
 * @see com.smartgwt.client.data.Operator#getRequiresServer
 * @see com.smartgwt.client.data.Operator#getHidden
 * @see com.smartgwt.client.data.Operator#getValueType
 * @see com.smartgwt.client.data.Operator#getEditorType
 * @see com.smartgwt.client.data.Operator#getSymbol
 * @see com.smartgwt.client.data.DataSourceField#getValidOperators
 * @see com.smartgwt.client.data.DataSourceField#getDefaultOperator
 * @see com.smartgwt.client.data.SimpleType#getValidOperators
 * @see com.smartgwt.client.data.SimpleType#getDefaultOperator
 * @see com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getValidOperators
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getDefaultOperator
 */
public interface AdvancedFilter {
}
