package com.smartgwt.sample.showcase.client.forms.layout;

import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormTitlesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on \"Swap Titles\" to change title" +
                                              " orientation. Form layout automatically places" +
                                              " titles next to fields. Left-oriented titles take" +
                                              " up a column so that labels line up. Top oriented" +
                                              " titles don't.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormTitlesSample panel = new FormTitlesSample();
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
        HLayout layout = new HLayout(20);
        
        final DynamicForm form = new DynamicForm();
        form.setWidth(250);
        
        TextItem usernameItem = new TextItem();
        usernameItem.setTitle("Username");
        usernameItem.setRequired(true);
        usernameItem.setDefaultValue("bob");

        TextItem emailItem = new TextItem();
        emailItem.setTitle("Email");
        emailItem.setRequired(true);
        emailItem.setDefaultValue("bob@isomorphic.com");

        PasswordItem passwordItem = new PasswordItem();
        passwordItem.setTitle("Password");
        passwordItem.setRequired(true);

        PasswordItem password2Item = new PasswordItem();
        password2Item.setTitle("Password again");
        password2Item.setRequired(true);
        password2Item.setType("password");

        form.setFields(new FormItem[] {usernameItem, emailItem, passwordItem, password2Item});
        
        IButton swapButton = new IButton("Swap titles");
        swapButton.setLeft(300);
        swapButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (form.getTitleOrientation() == TitleOrientation.TOP) {
                    titleOrientation = TitleOrientation.LEFT;
                }
                else {
                    titleOrientation = TitleOrientation.TOP;
                }
                form.setTitleOrientation(titleOrientation);
            }
        });
        
        layout.addMember(form);
        layout.addMember(swapButton);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}