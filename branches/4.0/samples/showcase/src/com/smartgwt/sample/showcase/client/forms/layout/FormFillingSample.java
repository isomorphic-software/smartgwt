package com.smartgwt.sample.showcase.client.forms.layout;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormFillingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on the \"Short Message\" and \"Long Message\"" +
                                              " buttons to change the amount of space available" +
                                              " to the form. SmartClient form layouts allow you" +
                                              " to fill available space, even when available" +
                                              " space cannot be known in advance because it is" +
                                              " data-dependant.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormFillingSample panel = new FormFillingSample();
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
      
    public Canvas getViewPanel() {
        VLayout messageLayout = new VLayout();
        messageLayout.setWidth(200);
        messageLayout.setHeight(300);
        messageLayout.setBorder("1px solid #6a6a6a");
        messageLayout.setLayoutMargin(5);
        
        final Canvas textCanvas = new Canvas();
        textCanvas.setPrefix("<b>Message from Rob:</b><BR>"); 
        textCanvas.setPadding(5);
        textCanvas.setHeight(1);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(2);
        form.setHeight("*");
        form.setColWidths(60, "*");
        
        TextItem subjectItem = new TextItem();
        subjectItem.setTitle("Subject");
        subjectItem.setWidth("*");
        subjectItem.setDefaultValue("Re: your message");

        TextAreaItem messageItem = new TextAreaItem();
        messageItem.setShowTitle(false);
        messageItem.setColSpan(2);
        messageItem.setHeight("*");
        messageItem.setWidth("*");
        messageItem.setLength(5000);
        form.setFields(subjectItem, messageItem);
        
        messageLayout.addMember(textCanvas);
        messageLayout.addMember(form);
        
        VLayout buttonLayout = new VLayout(10);        
        
        IButton shortMessageButton = new IButton("Short message");
        shortMessageButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                textCanvas.setContents(textCanvas.getPrefix() + "I'll be in town Saturday.  Give me a call on my cell and" +
                                       " we'll get a bite to eat.");
            }
        });

        IButton longMessageButton = new IButton("Long message");
        longMessageButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                updateContents(textCanvas);
            }
        });
        
        buttonLayout.addMember(shortMessageButton);
        buttonLayout.addMember(longMessageButton);
        
        HLayout layout = new HLayout(15);
        layout.setAutoHeight();
        layout.addMember(messageLayout);
        layout.addMember(buttonLayout);
        
        updateContents(textCanvas);        
        return layout;
    }

    private void updateContents(Canvas textCanvas) {
        textCanvas.setContents(textCanvas.getPrefix() + "I'll be in town Saturday.  Give me a call on my cell and" +
                               " we'll check out the new Thai restaurant on Polk Street." +
                               " Jamie said it's great but too spicy for him, shouldn't" +
                               " be a problem for you :)");
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}