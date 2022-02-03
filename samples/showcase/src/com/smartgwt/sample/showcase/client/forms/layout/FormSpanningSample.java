package com.smartgwt.sample.showcase.client.forms.layout;

import com.smartgwt.client.types.EdgeName;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormSpanningSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag resize the form from the right edge to see" +
                                              " the effect of spanning. Specifying column widths" +
                                              " and column spanning items allows for larger and" +
                                              " smaller input areas.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormSpanningSample panel = new FormSpanningSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    TitleOrientation titleOrientation = TitleOrientation.LEFT;
      
    public Canvas getViewPanel() {
        final DynamicForm form = new DynamicForm();
        form.setGroupTitle("Spanning");
        form.setIsGroup(true);
        form.setWidth(300);
        form.setHeight(180);
        form.setNumCols(2);
        form.setColWidths(60, "*");
        //form.setBorder("1px solid blue");
        form.setPadding(5);
        form.setCanDragResize(true);
        form.setResizeFrom(EdgeName.R);

        TextItem subjectItem = new TextItem();
        subjectItem.setTitle("Subject");
        subjectItem.setWidth("*");

        TextAreaItem messageItem = new TextAreaItem();
        messageItem.setShowTitle(false);
        messageItem.setLength(5000);
        messageItem.setColSpan(2);
        messageItem.setWidth("*");
        messageItem.setHeight("*");

        form.setFields(subjectItem, messageItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}