package com.smartgwt.client.widgets.form.fields;

public interface ShouldDisableCanvasCustomizer {

    /**
     * Called to determine whether the {@link CanvasItem#getCanvas() canvas} should be
     * {@link com.smartgwt.client.widgets.Canvas#setDisabled(boolean) disabled} when the
     * <code>CanvasItem</code> is disabled or its
     * {@link CanvasItem#addCanEditChangedHandler(com.smartgwt.client.widgets.form.fields.events.CanEditChangedHandler) editability changes}.
     * By default, if the <code>canvas</code> is a {@link com.smartgwt.client.widgets.form.DynamicForm},
     * then it is disabled if and only if the <code>CanvasItem</code> is disabled; otherwise,
     * the <code>canvas</code> is disabled if and only if the <code>CanvasItem</code> is disabled
     * or {@link FormItem#getCanEdit() read-only}.
     * @return <code>true</code> if the <code>canvas</code> should be disabled; <code>false</code> otherwise.
     */
    public boolean shouldDisableCanvas();
}
