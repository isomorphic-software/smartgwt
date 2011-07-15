/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package com.smartgwt.client.util.workflow;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.SmartGWTTestCase;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CancelItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Test for UserTask workflow task.
 */
public class UserTaskTestCase extends SmartGWTTestCase {

    /**
     * UserTask: check basic functionality.
     */
    public void testBasic(){
        DataSource clientDS = new DataSource();
        clientDS.setClientOnly(true);
        
        final DynamicForm form = new DynamicForm();
        form.setID("exampleForm");
        form.setWidth(250);
        form.setVisibility(Visibility.HIDDEN);
        form.setNumCols(3);
        form.setPadding(10);
        form.setColWidths(150, 60, 40);
        form.setDataSource(clientDS);
        
        FormItem usernameField = new TextItem("username", "Username");
        usernameField.setRequired(true);
        usernameField.setColSpan(2);
        
        FormItem emailField = new TextItem("email", "Email");
        emailField.setRequired(true);
        emailField.setColSpan(2);
        
        FormItem passwordField = new PasswordItem("password", "Password");
        passwordField.setRequired(true);
        passwordField.setColSpan(2);
        
        FormItem submitButton = new SubmitItem("submitButton");
        submitButton.setStartRow(false);
        submitButton.setEndRow(false);
        submitButton.setColSpan(2);
        submitButton.setAlign(Alignment.RIGHT);
        
        FormItem cancelButton = new CancelItem();
        cancelButton.setStartRow(false);
        cancelButton.setAlign(Alignment.RIGHT);
        form.setFields(usernameField , emailField, passwordField, submitButton, cancelButton);
        
        UserTask task = new UserTask();
        task.setInputField("user");
        task.setOutputField("user");
        task.setTargetView(form);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                Record user = state.getAttributeAsRecord("user");
                assertNotNull(user);
                assertEquals("john", user.getAttribute("username"));
                assertEquals("john@isomorphic.com", user.getAttribute("email"));
                finishTest();
            };
        };
        process.setElements(task);
        Record state = new Record();
        Record user = new Record();
        user.setAttribute("username", "bob");
        user.setAttribute("email", "bob@isomorphic.com");
        state.setAttribute("user", user);
        process.setState(state);
        process.start();
        delayTestFinish(400);
        
        new Timer() {
            @Override
            public void run() {
                form.setValue("username", "john");
                form.setValue("email", "john@isomorphic.com");
                clickButton((ButtonItem) form.getField("submitButton"));
            }
        }.schedule(200);
    }

    /**
     * UserTask: check window-tabset-sectionstack showing functionality.
     */
    public void testShowRecursively(){
        DataSource clientDS = new DataSource();
        clientDS.setClientOnly(true);

        final DynamicForm form = new DynamicForm();
        form.setID("exampleForm2");
        form.setWidth(250);
        form.setVisibility(Visibility.HIDDEN);
        form.setNumCols(3);
        form.setPadding(10);
        form.setColWidths(150, 60, 40);
        form.setDataSource(clientDS);
        
        FormItem usernameField = new TextItem("username", "Username");
        usernameField.setRequired(true);
        usernameField.setColSpan(2);
        
        FormItem emailField = new TextItem("email", "Email");
        emailField.setRequired(true);
        emailField.setColSpan(2);
        
        FormItem passwordField = new PasswordItem("password", "Password");
        passwordField.setRequired(true);
        passwordField.setColSpan(2);
        
        FormItem submitButton = new SubmitItem("submitButton");
        submitButton.setStartRow(false);
        submitButton.setEndRow(false);
        submitButton.setColSpan(2);
        submitButton.setAlign(Alignment.RIGHT);
        
        FormItem cancelButton = new CancelItem();
        cancelButton.setStartRow(false);
        cancelButton.setAlign(Alignment.RIGHT);
        form.setFields(usernameField , emailField, passwordField, submitButton, cancelButton);
        
        SectionStack ss = new SectionStack();
        ss.setID("ss");
        ss.setWidth100();
        ss.setHeight100();
        ss.setVisibility(Visibility.HIDDEN);
        SectionStackSection first = new SectionStackSection("one");
        first.setExpanded(true);
        SectionStackSection second = new SectionStackSection("two");
        second.setExpanded(false);
        SectionStackSection third = new SectionStackSection("three");
        third.setExpanded(false);
        third.setHidden(true);
        third.setItems(form);
        SectionStackSection fourth = new SectionStackSection("four");
        fourth.setExpanded(false);
        ss.setSections(first , second, third, fourth);
        
        TabSet tabSet = new TabSet();
        tabSet.setID("ts");
        tabSet.setWidth100();
        tabSet.setHeight100();
        tabSet.setSelectedTab(0);
        tabSet.setVisibility(Visibility.HIDDEN);
        Tab secondTab = new Tab("second");
        secondTab.setPane(ss);
        tabSet.setTabs(new Tab("first"), secondTab , new Tab("third"));
        
        Window w = new Window();
        w.setWidth(480);
        w.setHeight(320);
        w.setTop(150);
        w.setLeft(100);
        w.setVisibility(Visibility.HIDDEN);
        w.addItem(tabSet);
        
        UserTask task = new UserTask();
        task.setInputField("user");
        task.setOutputField("user");
        task.setTargetView(form);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                Record user = state.getAttributeAsRecord("user");
                assertNotNull(user);
                assertEquals("john", user.getAttribute("username"));
                assertEquals("john@isomorphic.com", user.getAttribute("email"));
                finishTest();
            };
        };
        process.setElements(task);
        Record state = new Record();
        Record user = new Record();
        user.setAttribute("username", "bob");
        user.setAttribute("email", "bob@isomorphic.com");
        state.setAttribute("user", user);
        process.setState(state);
        process.start();
        delayTestFinish(400);
        
        new Timer() {
            @Override
            public void run() {
                form.setValue("username", "john");
                form.setValue("email", "john@isomorphic.com");
                clickButton((ButtonItem) form.getField("submitButton"));
            }
        }.schedule(200);
    }
    
    /**
     * UserTask: check using values manager.
     */
    public void testValuesManager(){
        DataSource clientDS = new DataSource();
        clientDS.setClientOnly(true);
        
        ValuesManager vm = new ValuesManager();
        vm.setDataSource(clientDS);
        
        final DynamicForm vmForm1 = new DynamicForm();
        vmForm1.setID("vmForm1");
        vmForm1.setWidth(250);
        vmForm1.setNumCols(3);
        vmForm1.setPadding(10);
        vmForm1.setColWidths(150, 60, 40);
        vmForm1.setValuesManager(vm);
        
        FormItem usernameField = new TextItem("username", "Username");
        usernameField.setRequired(true);
        usernameField.setColSpan(2);
        
        FormItem emailField = new TextItem("email", "Email");
        emailField.setRequired(true);
        emailField.setColSpan(2);
        
        vmForm1.setFields(usernameField , emailField);
        
        final DynamicForm vmForm2 = new DynamicForm();
        vmForm2.setID("vmForm2");
        vmForm2.setWidth(250);
        vmForm2.setNumCols(3);
        vmForm2.setPadding(10);
        vmForm2.setColWidths(150, 60, 40);
        vmForm2.setValuesManager(vm);
        
        FormItem passwordField = new PasswordItem("password", "Password");
        passwordField.setRequired(true);
        passwordField.setColSpan(2);
        
        FormItem repeatPasswordField = new PasswordItem("repeat_password", "Repeat password");
        repeatPasswordField.setRequired(true);
        repeatPasswordField.setColSpan(2);
        
        FormItem submitButton = new SubmitItem("submitButton");
        submitButton.setStartRow(false);
        submitButton.setEndRow(false);
        submitButton.setColSpan(2);
        submitButton.setAlign(Alignment.RIGHT);
        
        FormItem cancelButton = new CancelItem();
        cancelButton.setStartRow(false);
        cancelButton.setAlign(Alignment.RIGHT);
        vmForm2.setFields(passwordField, repeatPasswordField, submitButton, cancelButton);
        
        HStack container = new HStack();
        container.setMembers(vmForm1, vmForm2);
        container.setTop(200);
        
        UserTask task = new UserTask();
        task.setInputField("user");
        task.setOutputField("user");
        task.setTargetView(container);
        task.setTargetVM(vm);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                Record user = state.getAttributeAsRecord("user");
                assertNotNull(user);
                assertEquals("john", user.getAttribute("username"));
                assertEquals("john@isomorphic.com", user.getAttribute("email"));
                assertEquals("pass", user.getAttribute("password"));
                finishTest();
            };
        };
        process.setElements(task);
        Record state = new Record();
        Record user = new Record();
        user.setAttribute("username", "bob");
        user.setAttribute("email", "bob@isomorphic.com");
        state.setAttribute("user", user);
        process.setState(state);
        process.start();
        delayTestFinish(400);
        
        new Timer() {
            @Override
            public void run() {
                if (vmForm1.isVisible()) {
                    vmForm1.setValue("username", "john");
                    vmForm1.setValue("email", "john@isomorphic.com");
                }
                if (vmForm2.isVisible()) {
                    vmForm2.setValue("password", "pass");
                    clickButton((ButtonItem) vmForm2.getField("submitButton"));
                }
            }
        }.schedule(200);
    }

    /**
     * UserTask: check cancel functionality.
     */
    public void testCancel(){
        DataSource clientDS = new DataSource();
        clientDS.setClientOnly(true);
        
        final DynamicForm form = new DynamicForm();
        form.setID("formToCancel");
        form.setWidth(250);
        form.setNumCols(3);
        form.setPadding(10);
        form.setColWidths(150, 60, 40);
        form.setLeft(250);
        form.setDataSource(clientDS);
        
        FormItem usernameField = new TextItem("username", "Username");
        usernameField.setRequired(true);
        usernameField.setColSpan(2);
        
        FormItem emailField = new TextItem("email", "Email");
        emailField.setRequired(true);
        emailField.setColSpan(2);
        
        FormItem passwordField = new PasswordItem("password", "Password");
        passwordField.setRequired(true);
        passwordField.setColSpan(2);
        
        FormItem submitButton = new SubmitItem("submitButton");
        submitButton.setStartRow(false);
        submitButton.setEndRow(false);
        submitButton.setColSpan(2);
        submitButton.setAlign(Alignment.RIGHT);
        
        FormItem cancelButton = new CancelItem("cancelButton");
        cancelButton.setStartRow(false);
        cancelButton.setAlign(Alignment.RIGHT);
        form.setFields(usernameField , emailField, passwordField, submitButton, cancelButton);
        
        UserTask task = new UserTask();
        task.setInputField("user");
        task.setOutputField("user");
        task.setCancelElement("cancelTask");
        task.setTargetView(form);
        
        ScriptTask cancelTask = new ScriptTask("cancelTask") {
            public Object execute(Object input, Record inputRecord) {
                return "cancelled";
            };
        };
        cancelTask.setOutputField("result");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                Record user = state.getAttributeAsRecord("user");
                assertNotNull(user);
                assertEquals("bob", user.getAttribute("username"));
                assertEquals("bob@isomorphic.com", user.getAttribute("email"));
                assertEquals("cancelled", state.getAttribute("result"));
                finishTest();
            };
        };
        process.setElements(task, cancelTask);
        Record state = new Record();
        Record user = new Record();
        user.setAttribute("username", "bob");
        user.setAttribute("email", "bob@isomorphic.com");
        state.setAttribute("user", user);
        process.setState(state);
        process.start();
        delayTestFinish(400);
        
        new Timer() {
            @Override
            public void run() {
                form.setValue("username", "john");
                form.setValue("email", "john@isomorphic.com");
                clickButton((ButtonItem) form.getField("cancelButton"));
            }
        }.schedule(200);
    }
}
