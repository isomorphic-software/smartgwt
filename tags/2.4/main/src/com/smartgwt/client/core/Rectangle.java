package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.JSOHelper;

public class Rectangle {

    private int left;
    private int top;
    private int width;
    private int height;

    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JavaScriptObject getAsJSArray() {
        return JSOHelper.convertToJavaScriptArray(new int[]{left, top, width, height});
    }
}
