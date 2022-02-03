
package com.smartgwt.client.docs;

/**
 * <h3>Reify OnSite: Adding Custom Workflow Tasks</h3>
 * You can define your own custom Workflow tasks and add them to Reify's Workflow Editor.   This
 * allows your designers to cover additional use cases entirely within the visual design  tool,
 * without having to write code. <P> To create a new Workflow task type and add editing support,
 * the steps are: <ol> <li>Create a subclass of {@link
 * com.smartgwt.client.util.workflow.ProcessElement} (or one of ProcessElement's subclasses) 
 * which performs the desired task, and load that class in Reify.</li> <li>Create a {@link
 * com.smartgwt.client.docs.ComponentSchema component schema} for the task inheriting from  the
 * same superclass schema as the task itself.</li> <li>Use standard Smart GWT UI components to
 * create a UI for editing your new workflow task,  called a "task editor", and load this editor
 * in Reify.</li> <li>Register the new task editor with the Workflow Editor so that new and
 * existing tasks  of the new type can be edited.</li> </ol> <b>Do I need a custom Workflow
 * task?</b> <p> Before you start building a custom Workflow task and editor, consider whether
 * other approaches  might work as well or nearly as well: <p> 1. <i>Custom services</i> <p> If
 * you are trying to connect to some kind of enterprise-specific web service, you probably do  not
 * need a custom Workflow task but rather just a custom DataSource; see the 
 * link{group:reifyCustomDataSources, Adding Custom DataSources to Reify} overview instead.   <p>
 * Note that DataSources in Reify can serve as a model for any kind of network service, not  just
 * databases that store records. For example, if you have something like a proprietary  messaging
 * system with inputs similar to an email (recipient, subject, message text),  it may seem like a
 * custom Workflow task is needed, but this could also be modelled as a  DataSource where
 * <i>recipient, subject</i>, etc are simply DataSource fields, and a message is  sent by
 * performing a DataSource "add" operation.  However, it <i>may</i> be worthwhile to add a  custom
 * Workflow task in this case in order to provide a specialized editing interface, or  simply to
 * make it more obvious how to perform the task. <p> 2. <i>Actions on UI components</i> <p> If you
 * have added custom UI components to Reify, you might want to add custom Workflow tasks  for the
 * custom actions that those components support. However, an alternative approach is  to make
 * those actions accessible as a "setter method" and have designers invoke the action  via the
 * built-in <i>Set Properties</i> workflow task. <p> For example, you might have a component with
 * two very different display modes, and APIs  like <code>switchToModeOne()</code> and
 * <code>switchToModeTwo()</code>, and you might  think of creating a custom Workflow class to
 * call these APIs. However, another approach  would be to create a "setter method" like
 * <code>setMode(<i>newMode</i>)</code>, add it to the  Component Schema for the custom component,
 * and have designers change mode via the  <i>Set Properties</i> built-in workflow task. <p>
 * <b>Workflow Task</b> <p> A new workflow task must inherit from {@link
 * com.smartgwt.client.util.workflow.ProcessElement} or one of its subclasses like {@link
 * com.smartgwt.client.util.workflow.ScriptTask} or {@link
 * com.smartgwt.client.util.workflow.ComponentTask}. The implementation of the task must include
 * an override of {@link com.smartgwt.client.util.workflow.ProcessElement#executeElement
 * ProcessElement.executeElement()} or other more specific subclass method like {@link
 * com.smartgwt.client.util.workflow.ScriptTask#execute ScriptTask.execute()}. Be sure to return
 * the correct value to keep the process moving. <p> By adding {@link
 * com.smartgwt.client.util.workflow.ProcessElement#getTypeTitle ProcessElement.typeTitle} and
 * {@link com.smartgwt.client.util.workflow.ProcessElement#getClassDescription
 * ProcessElement.classDescription} property values, the {@link
 * com.smartgwt.client.tools.WorkflowTaskDescriptor#getTitle WorkflowTaskDescriptor.title} and
 * {@link com.smartgwt.client.tools.WorkflowTaskDescriptor#getDescription
 * WorkflowTaskDescriptor.description} properties are not needed when referencing your custom
 * task. <p> The JavaScript implementation of the task can be loaded in Reify by adding a
 * dependency in the <code>globalDependencies.xml</code> file as detailed in {@link
 * com.smartgwt.client.docs.ReifyCustomComponents "Adding Custom Components to Reify"}.
 * Alternately, see {@link com.smartgwt.client.docs.ReifyOnSite "Runtime Customization"} for a
 * different means to load the implementation file. <p> <b>Task Schema</b> <p> A {@link
 * com.smartgwt.client.docs.ComponentSchema component schema} is needed for the new task so that
 * the configuration can be serialized and deserialized correctly. The schema can be declared in
 * XML or in JavaScript code. In either case, the following attributes are required in addition to
 * fields matching each task property: <ul>   <li>{@link com.smartgwt.client.data.DataSource#getID
 * ID} = <em>same name as your task class</em>   <li>{@link
 * com.smartgwt.client.docs.serverds.DataSource#serverType serverType} = "component"   <li>{@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} = <em>class name of your task
 * superclass</em>   <li>instanceConstructor = <em>same name as your task class</em> </ul> <p> As
 * with the new workflow task implementation, the schema needs to be loaded into Reify. See the
 * section above for two means of loading the schema. <p> <b>Workflow Task Editor</b> <p> A task
 * editor is needed for any task that has properties the user can change. If a task doesn't have
 * any properties, like a logout task, there is no need to implement an editor at all. For the
 * {@link com.smartgwt.client.tools.WorkflowTaskDescriptor} created below, don't provide an {@link
 * com.smartgwt.client.tools.WorkflowTaskDescriptor#editTask editTask()} implementation. <p>
 * Otherwise, an editor component is needed to edit the properties for an instance of your new
 * workflow task. Custom code that is used by your  {@link
 * com.smartgwt.client.tools.WorkflowTaskDescriptor#editTask editTask()} method should be included
 * for Reify as detailed in Workflow Task above. <p> To aid in writing custom task editors there
 * are several classes on which to base your editors. You can start with {@link
 * com.smartgwt.client.tools.WorkflowTaskEditor} or, if your workflow task derives from {@link
 * com.smartgwt.client.util.workflow.ComponentTask}, use {@link
 * com.smartgwt.client.tools.WorkflowComponentTaskEditor}. There are also some custom editors that
 * are useful for editing the task properties:  <ul>   <li>WorkflowValuesBindingEditor  
 * <li>{@link com.smartgwt.client.tools.WorkflowCriteriaBuilder}   <li>{@link
 * com.smartgwt.client.tools.WorkflowDynamicValueItem}   <li>{@link
 * com.smartgwt.client.tools.WorkflowTemplatedTextItem} </ul>  <p> <b>Register Task Editor</b> <p>
 * For the {@link com.smartgwt.client.tools.WorkflowEditor Workflow Editor} to show your new task
 * in the Add task choices and to edit existing tasks of your new type, a {@link
 * com.smartgwt.client.tools.WorkflowTaskDescriptor} must be registered with Reify.  easiest way
 * to configure the descriptor is to add it to the default Reify task descriptors found in
 * <code>[webroot]/tools/visualBuilder/workflowTasks.xml</code>. <p> As can be seen by looking at
 * workflowTasks.xml, tasks are specified using a tree structure similar to that shown in the  <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#treeLoadXML" target="examples">tree XML
 * loading example</a>. This tree structure exactly maps into the add task choices menu in the
 * Workflow Editor. The properties that can be set on nodes are documented on {@link
 * com.smartgwt.client.tools.WorkflowTaskDescriptor}. <p> Alternately, a new task descriptor can
 * be added by calling {@link com.smartgwt.client.tools.Reify#registerWorkflowTaskDescriptor
 * Reify.registerWorkflowTaskDescriptor()} which makes it possible to do this with {@link
 * com.smartgwt.client.docs.ReifyOnSite "Runtime Customization"}.
 */
public interface ReifyAddWorkflowTask {
}
