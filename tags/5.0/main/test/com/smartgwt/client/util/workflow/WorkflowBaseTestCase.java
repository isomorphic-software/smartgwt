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
import com.smartgwt.client.data.Record;

/**
 * Test for basic workflow logic.
 */
public class WorkflowBaseTestCase extends SmartGWTTestCase {

    /**
     * Basic workflow logic test. Process based on elements. 
     */
    public void testBasicWorkflowLogicElements(){
        ScriptTask incTask = new ScriptTask("inc", "add2") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 1;
            };
        };
        incTask.setInputField("cnt");
        incTask.setOutputField("cnt2");
        
        ScriptTask add2Task = new ScriptTask("add2") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 2;
            };
        };
        add2Task.setInputField("cnt2");
        add2Task.setOutputField("cnt3");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setElements(incTask, add2Task);
        Record state = new Record();
        state.setAttribute("cnt", 0);
        process.setState(state);
        process.start();
        assertEquals("3", state.getAttribute("cnt3"));
    }
    
    /**
     * Basic workflow logic test. Process based on sequences.
     */
    public void testBasicWorkflowLogicSequences(){
        ScriptTask incTask = new ScriptTask("inc") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 1;
            };
        };
        incTask.setInputField("cnt");
        incTask.setOutputField("cnt2");
        
        ScriptTask add2Task = new ScriptTask("add2") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 2;
            };
        };
        add2Task.setInputField("cnt2");
        add2Task.setOutputField("cnt");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        ProcessSequence innerSequence = new ProcessSequence(incTask, add2Task, incTask);
        ProcessSequence mainSequence = new ProcessSequence(incTask, add2Task, innerSequence);
        process.setSequences(mainSequence);
        Record state = new Record();
        state.setAttribute("cnt", 0);
        process.setState(state);
        process.start();
        assertEquals("7", state.getAttribute("cnt2"));
    }
    
    /**
     * Basic workflow logic test. Test recursive sequences.
     */
    public void testBasicWorkflowLogicRecursiveSequences(){
        ScriptTask incTask = new ScriptTask("inc") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 1;
            };
        };
        incTask.setInputField("cnt");
        incTask.setOutputField("cnt2");
        
        ScriptTask add2Task = new ScriptTask("add2") {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 2;
            };
        };
        add2Task.setInputField("cnt2");
        add2Task.setOutputField("cnt");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        ProcessSequence firstSequence = new ProcessSequence(incTask, add2Task);
        ProcessSequence secondSequence = new ProcessSequence(add2Task, incTask);
        ProcessSequence mainSequence = new ProcessSequence(firstSequence, incTask, 
                secondSequence);
        process.setSequences(mainSequence);
        Record state = new Record();
        state.setAttribute("cnt", 0);
        process.setState(state);
        process.start();
        assertEquals("7", state.getAttribute("cnt2"));
    }

    /**
     * Basic workflow logic test. Combine sequences with elements and using nextElement with
     * next by order. Check inputFields and outpupFields too
     */
    public void testComplexWorkflowLogic(){
        final com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };

        ScriptTask el1Task = new ScriptTask("el1", "el3") {
            public Object execute(Object input, Record inputRecord) {
                Record result = new Record();
                result.setAttribute("cnt", 10);
                result.setAttribute("indx", ((Integer) input) + 1);
                return result;
            };
        };
        el1Task.setInputField("indx");
        el1Task.setOutputFields("cnt", "indx");
        
        ScriptTask el2Task = new ScriptTask("el2", el1Task) {
            public Object execute(Object input, Record inputRecord) {
                // should not affect anything
                inputRecord.setAttribute("cnt", inputRecord.getAttributeAsInt("cnt") + 1);
                return 1 + inputRecord.getAttributeAsInt("indx");
            };
        };
        el2Task.setInputFields("cnt", "indx");
        el2Task.setOutputField("indx");
        
        ScriptTask el4Task = new ScriptTask("el4") {
            public Object execute(Object input, Record inputRecord) {
                if (inputRecord.getAttribute("indx") != null) {
                    return 0;
                }
                return 1 + inputRecord.getAttributeAsInt("cnt");
            };
        };
        el4Task.setInputFields("cnt");
        el4Task.setOutputField("cnt");
        
        ScriptTask el5Task = new ScriptTask("el5") {
            public Object execute(Object input, Record inputRecord) {
                Record result = new Record();
                result.setAttribute("indx", ((Integer) input) + 1);
                return result;
            };
        };
        el5Task.setInputField("indx");
        el5Task.setOutputFields("cnt");
        
        ScriptTask el6Task = new ScriptTask("el6") {
            public Object execute(Object input, Record inputRecord) {
                inputRecord.setAttribute("indx", inputRecord.getAttributeAsInt("indx") * 2);
                inputRecord.setAttribute("cnt", inputRecord.getAttributeAsInt("cnt") * 2);
                return null;
            };
        };
        el6Task.setInputFields("indx", "cnt");
        el6Task.setOutputFields("cnt", "indx");
        
        ScriptTask el3Task = new ScriptTask("el3", "s1") {
            public Object execute(Object input, Record inputRecord) {
                Record result = new Record();
                result.setAttribute("indx", inputRecord.getAttributeAsInt("indx") + 1);
                result.setAttribute("cnt", inputRecord.getAttributeAsInt("cnt") + 1);
                return result;
            };
        };
        el3Task.setInputField("cnt");
        el3Task.setInputFields("indx");
        el3Task.setOutputField("indx");
        el3Task.setOutputFields("cnt");
        
        ProcessSequence firstSequence = new ProcessSequence(el1Task, el2Task);
        ProcessSequence secondSequence = new ProcessSequence("s1", el4Task, el5Task, el6Task);
        ProcessSequence mainSequence = new ProcessSequence(firstSequence, secondSequence);
        process.setSequences(mainSequence);
        process.setElements(el3Task);
        Record state = new Record();
        state.setAttribute("cnt", 0);
        state.setAttribute("indx", 0);
        process.setState(state);
        process.setStartElement(el2Task);
        process.start();
        assertEquals("12", state.getAttribute("cnt"));
        assertEquals("3", state.getAttribute("indx"));
    }
}
