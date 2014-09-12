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

import com.smartgwt.client.SmartGWTTestCase;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.WorldDS;
import com.smartgwt.client.types.DSOperationType;

/**
 * Test for ServiceTask workflow task.
 */
public class ServiceTaskTestCase extends SmartGWTTestCase {

    /**
     * ServiceTask: check basic fetch functionality.. 
     */
    public void testBasicFetch(){
        ServiceTask sTask = new ServiceTask();
        sTask.setDataSource(WorldDS.getInstance());
        sTask.setInputField("countryCode");
        sTask.setOutputField("countryName");
        
        ServiceTask sTask2 = new ServiceTask();
        sTask2.setDataSource(WorldDS.getInstance());
        sTask2.setInputField("countryName");
        sTask2.setOutputFields("capital", "continent", "population");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                assertEquals("Canada", state.getAttribute("countryName"));
                assertEquals("Ottawa", state.getAttribute("capital"));
                assertEquals("North America", state.getAttribute("continent"));
                assertEquals("33098932", state.getAttribute("population"));
                finishTest();
            };
        };
        process.setSequences(new ProcessSequence(sTask, sTask2));
        Record state = new Record();
        state.setAttribute("countryCode", "CA");
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }
    
    /**
     * ServiceTask: check fetch with criteria functionality.
     */
    public void testFetchWithCriteria(){
        ServiceTask sTask = new ServiceTask();
        sTask.setDataSource(WorldDS.getInstance());
        sTask.setInputField("continent");
        sTask.setOutputField("countryName");
        sTask.setCriteria(new Criteria("capital", "Ottawa"));
        
        ServiceTask sTask2 = new ServiceTask();
        sTask2.setDataSource(WorldDS.getInstance());
        sTask2.setInputField("countryCode");
        sTask2.setOutputFields("capital", "countryName", "population", "continent");
        sTask2.setFixedCriteria(new Criteria("population", "33098932"));
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                assertEquals("Canada", state.getAttribute("countryName"));
                assertEquals("Ottawa", state.getAttribute("capital"));
                assertEquals("North America", state.getAttribute("continent"));
                assertEquals("33098932", state.getAttribute("population"));
                finishTest();
            };
        };
        process.setSequences(new ProcessSequence(sTask, sTask2));
        Record state = new Record();
        state.setAttribute("continent", "North America");
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }

    /**
     * ServiceTask: check fetch with criteria and dynamic expressions.
     */
    public void testFetchWithCriteriaAndDynamicExpressions(){
        ServiceTask sTask = new ServiceTask();
        sTask.setDataSource(WorldDS.getInstance());
        sTask.setInputField("name");
        sTask.setOutputFields("capital", "countryName", "population", "countryCode");
        sTask.setCriteria(new Criteria("countryName", "$input"));
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                assertEquals("Canada", state.getAttribute("countryName"));
                assertEquals("Ottawa", state.getAttribute("capital"));
                assertEquals("North America", state.getAttribute("continent"));
                assertEquals("33098932", state.getAttribute("population"));
                finishTest();
            };
        };
        process.setElements(sTask);
        Record state = new Record();
        state.setAttribute("continent", "North America");
        state.setAttribute("name", "Canada");
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }

    /**
     * ServiceTask: check fetch with fixed criteria and dynamic expression.
     */
    public void testFetchWithFixedCriteriaAndDynamicExpressions(){
        ServiceTask sTask = new ServiceTask();
        sTask.setDataSource(WorldDS.getInstance());
        sTask.setInputField("name");
        sTask.setOutputFields("capital", "countryName", "population", "countryCode");
        sTask.setFixedCriteria(new Criteria("countryName", "$input"));
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                assertNull(state.getAttribute("countryName"));
                assertNull(state.getAttribute("capital"));
                assertNull(state.getAttribute("population"));
                finishTest();
            };
        };
        process.setElements(sTask);
        Record state = new Record();
        state.setAttribute("continent", "North America");
        state.setAttribute("name", "Canada");
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }

    /**
     * ServiceTask: check add and remove operations.
     */
    public void testAddAndRemoveOperations(){
        final boolean[] checks = new boolean[2];
        
        final com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                if (!checks[0]) {
                    fail("Add operation didn't work properly - pk was not generated.");
                }
                if (!checks[1]) {
                    fail("Add operation didn't work properly - data were not added to " +
                            "process state after fetch newly added data.");
                }
                assertNull(state.getAttribute("countryName"));
                assertNull(state.getAttribute("capital"));
                assertNull(state.getAttribute("countryCode"));
                assertNull(state.getAttribute("population"));
                assertNull(state.getAttribute("continent"));
                finishTest();
            };
        };
        
        ServiceTask addTask = new ServiceTask();
        addTask.setDataSource(WorldDS.getInstance());
        addTask.setOperationType(DSOperationType.ADD);
        addTask.setInputFields("pk", "continent", "countryName", "capital", "countryCode", 
                "population");
        addTask.setOutputField("pk");
        
        ScriptTask checkIdTask = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                checks[0] = process.getState().getAttribute("pk") != null;
                // clean state, so we can check fetch
                process.getState().setAttribute("capital", (String) null);
                process.getState().setAttribute("continent", (String) null);
                process.getState().setAttribute("countryName", (String) null);
                process.getState().setAttribute("population", (String) null);
                process.getState().setAttribute("countryCode", (String) null);
                return null;
            };
        };
        
        ServiceTask fetchAfterAddTask = new ServiceTask();
        fetchAfterAddTask.setDataSource(WorldDS.getInstance());
        fetchAfterAddTask.setInputField("pk");
        fetchAfterAddTask.setOutputFields("continent", "capital", "countryName", "population", 
                "countryCode");
        
        ScriptTask checkFetchAfterAddTask = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                Record processState = process.getState();
                checks[1] = "TestCountry".equals(processState.getAttribute("countryName"));
                checks[1] &= "Test".equals(processState.getAttribute("capital"));
                checks[1] &= "Asia".equals(processState.getAttribute("continent"));
                checks[1] &= "TC".equals(processState.getAttribute("countryCode"));
                checks[1] &= "171".equals(processState.getAttribute("population"));
                // clean state, so we can check fetch after remove
                processState.setAttribute("capital", (String) null);
                processState.setAttribute("continent", (String) null);
                processState.setAttribute("countryName", (String) null);
                processState.setAttribute("population", (String) null);
                processState.setAttribute("countryCode", (String) null);
                return null;
            };
        };
        
        ServiceTask removeTask = new ServiceTask();
        removeTask.setDataSource(WorldDS.getInstance());
        removeTask.setOperationType(DSOperationType.REMOVE);
        removeTask.setInputField("pk");
        
        ServiceTask fetchAfterRemoveTask = new ServiceTask();
        fetchAfterRemoveTask.setDataSource(WorldDS.getInstance());
        fetchAfterRemoveTask.setInputField("pk");
        fetchAfterRemoveTask.setOutputFields("capital", "countryName", "population",
                "continent", "countryCode");
        
        process.setSequences(new ProcessSequence(addTask, checkIdTask, fetchAfterAddTask,
                checkFetchAfterAddTask, removeTask, fetchAfterRemoveTask));
        Record state = new Record();
        state.setAttribute("pk", -1);
        state.setAttribute("continent", "Asia");
        state.setAttribute("countryName", "TestCountry");
        state.setAttribute("capital", "Test");
        state.setAttribute("countryCode", "TC");
        state.setAttribute("population", 171);
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }
}
