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
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.OperatorId;

/**
 * Test for XORGateway workflow process element.
 */
public class XORElementTestCase extends SmartGWTTestCase {

    /**
     * XORGateway: check basic logic functionality.
     */
    public void testBasic(){
        ScriptTask successTask = new ScriptTask("success") {
            public Object execute(Object input, Record inputRecord) {
                return "success";
            };
        };
        successTask.setOutputField("result");
        
        ScriptTask failTask = new ScriptTask("failure") {
            public Object execute(Object input, Record inputRecord) {
                return "failure";
            };
        };
        failTask.setOutputField("result");
        
        XORGateway firstXor = new XORGateway("xor1", "xor2", "failure");
        firstXor.setCriteria(new Criteria("countryCode", "CA"));
        
        XORGateway secondXor = new XORGateway("xor2", "failure", "success");
        secondXor.setCriteria(new Criteria("countryCode", "AA"));
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setStartElement("xor1");
        process.setElements(failTask, firstXor, secondXor, successTask);
        Record state = new Record();
        state.setAttribute("countryCode", "CA");
        process.setState(state);
        process.start();
        assertEquals("success", state.getAttribute("result"));
    }

    /**
     * XORGateway: check using advanced criteria.
     */
    public void testAdvancedCriteria(){
        ScriptTask successTask = new ScriptTask("success") {
            public Object execute(Object input, Record inputRecord) {
                return "success";
            };
        };
        successTask.setOutputField("result");
        
        ScriptTask failTask = new ScriptTask("failure") {
            public Object execute(Object input, Record inputRecord) {
                return "failure";
            };
        };
        failTask.setOutputField("result");
        
        XORGateway firstXor = new XORGateway("xor1", "xor2", "failure");
        AdvancedCriteria firstCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("population", OperatorId.GREATER_THAN, 20000000),
                new Criterion("population", OperatorId.LESS_THAN, 30000000),
                new Criterion(OperatorId.OR, new Criterion[]{
                        new Criterion("countryName", OperatorId.ICONTAINS, "ca"),
                        new Criterion("countryCode", OperatorId.IS_NULL)        
                })
        });
        firstXor.setCriteria(firstCriteria);
        
        XORGateway secondXor = new XORGateway("xor2", "failure", "success");
        AdvancedCriteria secondCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("population", OperatorId.GREATER_THAN, 10000000),
                new Criterion("population", OperatorId.LESS_THAN, 20000000)
        });
        secondXor.setCriteria(secondCriteria);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setStartElement("xor1");
        process.setElements(failTask, firstXor, secondXor, successTask);
        Record state = new Record();
        state.setAttribute("countryCode", "CA");
        state.setAttribute("countryName", "Canada");
        state.setAttribute("population", 28820671);
        process.setState(state);
        process.start();
        assertEquals("success", state.getAttribute("result"));
    }

    /**
     * XORGateway: check paths support.
     */
    public void testPathSupport(){
        ScriptTask successTask = new ScriptTask("success") {
            public Object execute(Object input, Record inputRecord) {
                return "success";
            };
        };
        successTask.setOutputField("result");
        
        ScriptTask failTask = new ScriptTask("failure") {
            public Object execute(Object input, Record inputRecord) {
                return "failure";
            };
        };
        failTask.setOutputField("result");
        
        XORGateway firstXor = new XORGateway("xor1", "xor2", "failure");
        firstXor.setCriteria(new Criteria("orderUser.login", "bob"));
        
        XORGateway secondXor = new XORGateway("xor2", "failure", "xor3");
        secondXor.setCriteria(new Criteria("orderUser.email", "bob@gmail.com"));
        
        XORGateway thirdXor = new XORGateway("xor3", "xor4", "failure");
        AdvancedCriteria firstCriteria = new AdvancedCriteria(OperatorId.OR, new Criterion[]{
                new Criterion("orderUser.login", OperatorId.STARTS_WITH, "test"),
                new Criterion("orderUser.email", OperatorId.ENDS_WITH, "isomorphic.com")
        });
        thirdXor.setCriteria(firstCriteria);
        
        XORGateway fourthXor = new XORGateway("xor4", "failure", "success");
        AdvancedCriteria secondCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("orderUser.login", OperatorId.STARTS_WITH, "test"),
                new Criterion("orderUser.email", OperatorId.ENDS_WITH, "isomorphic.com")
        });
        fourthXor.setCriteria(secondCriteria);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setStartElement("xor1");
        process.setElements(failTask, firstXor, secondXor, fourthXor, thirdXor, successTask);
        Record state = new Record();
        Record user = new Record();
        user.setAttribute("login", "bob");
        user.setAttribute("email", "bob@isomorphic.com");
        state.setAttribute("orderUser", user);
        state.setAttribute("orderNo", 1);
        process.setState(state);
        process.start();
        assertEquals("success", state.getAttribute("result"));
    }
}