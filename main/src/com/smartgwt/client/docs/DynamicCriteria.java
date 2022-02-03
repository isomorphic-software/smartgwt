
package com.smartgwt.client.docs;

/**
 * If a property indicates it has support for "dynamic criteria" it means that values in the
 * criteria may be dynamically derived from the current {@link
 * com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope} using
 *  {@link com.smartgwt.client.data.Criterion#getValuePath Criterion.valuePath}.
 *  <p>
 *  In other words, it allows criteria to be declared using values from nearby drawn
 *  components, via the {@link com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope}.
 * Values are pulled from the ruleScope via setting {@link
 * com.smartgwt.client.data.Criterion#getValuePath Criterion.valuePath}
 *  When values drawn from the ruleScope change, the component where dynamicCriteria is
 *  declared will be notified and automatically use the new value
 * 
 *  
 * 
 *  
 *  <pre>
 *  public void onModuleLoad() {
 * 
 *       TextItem lifeSpan = new TextItem("lifeSpan");
 *       lifeSpan.setDefaultValue(45);
 * 
 *       final DynamicForm theForm = new DynamicForm();
 *       theForm.setID("theForm");
 *       theForm.setItems(lifeSpan);
 * 
 *       AdvancedCriteria initialCriteria = new AdvancedCriteria("lifeSpan", OperatorId.GREATER_THAN);
 *       initialCriteria.setValuePath("theForm.values.lifeSpan");
 * 
 *       ListGrid lg = new ListGrid();
 *       lg.setAutoFetchData(true);
 *       lg.setDataSource(AnimalXmlDS.getInstance());
 *       lg.setInitialCriteria(initialCriteria);
 *       lg.setWidth(600); lg.setHeight(400); lg.setTop(50);
 * 
 *       VLayout vl = new VLayout();
 *       vl.addMembers(theForm, lg);
 *       vl.draw();
 *  }
 *  </pre>
 * 
 */
public interface DynamicCriteria {
}
