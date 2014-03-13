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
import com.smartgwt.client.data.Record;

/**
 * Test for ScriptTask workflow task.
 */
public class ScriptTaskTestCase extends SmartGWTTestCase {

    /**
     * ScriptTask: check basic functionality.
     */
    public void testSync(){
        ScriptTask task = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                return inputRecord.getAttributeAsInt("two") + 
                    inputRecord.getAttributeAsInt("one") - (Integer) input;
            };
        };
        task.setInputField("three");
        task.setInputFields("one", "two");
        task.setOutputField("cnt");
        
        ScriptTask task2 = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                return ((Integer) input) + 1;
            };
        };
        task2.setInputField("cnt");
        task2.setOutputField("cnt");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setSequences(new ProcessSequence(task, task2));
        Record state = new Record();
        state.setAttribute("one", 1);
        state.setAttribute("two", 2);
        state.setAttribute("three", 3);
        process.setState(state);
        process.start();
        assertEquals(1, state.getAttributeAsInt("cnt").intValue());
    }
    
    /**
     * ScriptTask: check async functionality.
     */
    public void testAsync(){
        ScriptTask task = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                return inputRecord.getAttributeAsInt("two") + 
                    inputRecord.getAttributeAsInt("one") - (Integer) input;
            };
        };
        task.setInputField("three");
        task.setInputFields("one", "two");
        task.setOutputField("cnt");
        
        ScriptTask task2 = new ScriptTask() {
            public Object execute(final Object input, Record inputRecord) {
                Timer t = new Timer() {
                    @Override
                    public void run() {
                        setOutputData(((Integer) input) + 1);                        
                    }
                };
                t.schedule(100);
                return null;
            };
        };
        task2.setInputField("cnt");
        task2.setOutputField("cnt");
        task2.setIsAsync(true);
        
        ScriptTask task3 = new ScriptTask() {
            public Object execute(Object input, Record inputRecord) {
                return (Integer) input * 2;
            };
        };
        task3.setInputField("cnt");
        task3.setOutputField("cnt");
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
                assertEquals(2, state.getAttributeAsInt("cnt").intValue());
                finishTest();
            };
        };
        process.setSequences(new ProcessSequence(task, task2, task3));
        Record state = new Record();
        state.setAttribute("one", 1);
        state.setAttribute("two", 2);
        state.setAttribute("three", 3);
        process.setState(state);
        process.start();
        delayTestFinish(200);
    }
}
