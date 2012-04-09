package com.smartgwt.client.bean;

/**
 * Interface used by a generator to trigger the generation and registration of reflection metadata for Canvas and all it's
 * subclasses found in the classpath.
 * <p/>
 * Usage is to simply call GWT.create(RegisterAllCanvas.class);
 * <p/>
 * Once this is called, the introspection / Canvas property helper methods may be used to dynamically instanantiate and configure the
 * canvas types. For example :<code>
 * <pre>
 * GWT.create(RegisterAllCanvas.class);
 *
 * String className = "com.smartgwt.client.widgets.Button";
 * Canvas canvas = (Canvas) CanvasUtil.newInstance(className);
 *
 * String propertiesJSON = "{\"title\" : \"Hello World\", \"tooltip\" : \"My tooltip\"}";
 * CanvasUtil.setProperties(className, canvas, propertiesJSON);
 * canvas.draw();
 * </pre>
 * </code>
 * <p/>
 * Alternatively if only specific Canvas types need to be instantiated and configured dynamically, instead of generating
 * the property metadata for all available canvas types by calling  <code>GWT.create(RegisterAllCanvas.class)</code>, one can
 * specifically generate property metadata for a specific Canvas type. For example <code>GWT.create(com.smartgwt.client.widgets.Button.class);</code>
 */
public interface RegisterAllCanvas {
}
