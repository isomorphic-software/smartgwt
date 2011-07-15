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

import java.util.LinkedHashMap;

import com.smartgwt.client.SmartGWTTestCase;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.OperatorId;

/**
 * Test for DecisionGateway workflow process element.
 */
public class DecisionGatewayElementTestCase extends SmartGWTTestCase {

    /**
     * DecisionGateway: check basic logic functionality.
     */
    public void testBasic(){
        ScriptTask aTask = new ScriptTask("a") {
            public Object execute(Object input, Record inputRecord) {
                return "a";
            };
        };
        aTask.setOutputField("result");
        
        ScriptTask bTask = new ScriptTask("b") {
            public Object execute(Object input, Record inputRecord) {
                return "b";
            };
        };
        bTask.setOutputField("result");
        
        ScriptTask cTask = new ScriptTask("c") {
            public Object execute(Object input, Record inputRecord) {
                return "c";
            };
        };
        cTask.setOutputField("result");
        
        ScriptTask dTask = new ScriptTask("d") {
            public Object execute(Object input, Record inputRecord) {
                return "d";
            };
        };
        dTask.setOutputField("result");
        
        DecisionGateway decisionElement = new DecisionGateway("decision");
        LinkedHashMap<String, Criteria> decisionMap = new LinkedHashMap<String, Criteria>();
        decisionMap.put("a", new AdvancedCriteria(OperatorId.AND, new Criterion[]{
            new Criterion("population", OperatorId.GREATER_THAN, 1000),
            new Criterion("population", OperatorId.LESS_THAN, 10000000)
        }));
        decisionMap.put("b", new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("population", OperatorId.GREATER_THAN, 10000000),
                new Criterion("population", OperatorId.LESS_THAN, 15000000)
            }));
        decisionMap.put("d", new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("population", OperatorId.GREATER_THAN, 20000000),
                new Criterion("population", OperatorId.LESS_THAN, 25000000)
            }));
        decisionMap.put("defaultDecision", new AdvancedCriteria(OperatorId.AND, 
            new Criterion[]{
                new Criterion("population", OperatorId.GREATER_THAN, 25000000),
                new Criterion("population", OperatorId.LESS_THAN, 30000000)
            }));
        decisionElement.setCriteriaMap(decisionMap);
        decisionElement.setDefaultElement("c");
        
        DecisionGateway defaultDecision = new DecisionGateway("defaultDecision");
        defaultDecision.setDefaultElement("d");
        LinkedHashMap<String, Criteria> defaultDecisionMap = 
            new LinkedHashMap<String, Criteria>();
        defaultDecisionMap.put("a", new Criteria("countryCode", "AA"));
        defaultDecisionMap.put("b", new Criteria("countryCode", "BB"));
        defaultDecisionMap.put("c", new Criteria("countryCode", "CC"));
        decisionElement.setCriteriaMap(defaultDecisionMap);
        
        com.smartgwt.client.util.workflow.Process process = 
            new com.smartgwt.client.util.workflow.Process() {
            public void finished(Record state) {
            };
        };
        process.setStartElement("decision");
        process.setElements(defaultDecision, decisionElement, aTask, bTask, cTask, dTask);
        Record state = new Record();
        state.setAttribute("countryCode", "CA");
        state.setAttribute("population", 28820671);
        process.setState(state);
        process.start();
        assertEquals("d", state.getAttribute("result"));
    }
}