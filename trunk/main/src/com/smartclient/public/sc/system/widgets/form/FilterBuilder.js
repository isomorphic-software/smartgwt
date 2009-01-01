/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 
// FilterBuilder requires DynamicForm but is loaded in a separate module. 
// Ensure DF is present before attempting to initialize
if (isc.DynamicForm) {



//> @class FilterBuilder
// A form that allows the user to input advanced search criteria, including operators on
// field values such as "less than", and sub-clauses using "AND" and "OR" operators.
// <P>
// A FilterBuilder produces an +link{AdvancedCriteria} object, which the +link{DataSource}
// subsystem can use to filter datasets, including the ability to perform such filtering within
// the browser for datasets that are completely loaded.
// @treeLocation Client Reference/Forms
// @visibility external
//<
isc.defineClass("FilterBuilder", "Layout").addProperties({

// Layout: be a minimum height stack by default
// ---------------------------------------------------------------------------------------
vertical:false,
vPolicy:"none",
height:1,
defaultWidth:400,

// Schema and operators
// ---------------------------------------------------------------------------------------

//> @attr filterBuilder.dataSource (DataSource or ID : null : IR)
// DataSource this filter should use for field definitions and available +link{Operator}s.
// @visibility external
//< 

//> @attr filterBuilder.criteria (AdvancedCriteria : null : IR)
// Initial criteria.
// <P>
// When initialized with criteria, appropriate clauses for editing the provided criteria will
// be automatically generated.
// <P>
// Note that empty or partial criteria are allowed, for example, criteria that specify
// +link{criterion.fieldName} only will generate an expression with the operator not chosen
// yet, and a +link{criterion} with a logical operator ("and" or "or") but not
// +link{criteria.criteria,subcriteria} defined will generate an empty subclause.
// @visibility external
//<

//> @attr filterBuilder.saveOnExit (boolean : null : IR)
// If true, when the user hits the Enter key while focussed in a text-item in this 
// FilterBuilder, we automatically invoke the user-supplied +link{filterBuilder.search()} method.
// @visibility external
//< 

//> @attr filterBuilder.showFieldTitles (boolean : true : IR)
// If true (the default), show field titles in the drop-down box used to select a field for querying.
// If false, show actual field names instead.
// @visibility external
//< 
showFieldTitles: true,

// Add/remove buttons
// ---------------------------------------------------------------------------------------
  
//> @attr filterBuilder.showRemoveButton (boolean : true : IR)
// If set, a button will be shown for each clause allowing it to be removed.
// @visibility external
//<
showRemoveButton:true,

//> @attr filterBuilder.removeButton (AutoChild : null : IR)
// The clause removal ImgButton that appears after each clause if
// +link{showRemoveButton} is set.
// @visibility external
//<
removeButtonDefaults : {
    _constructor:isc.ImgButton,
    width:18, height:18, layoutAlign:"center",
    src:"[SKIN]/actions/remove.png",
    showRollOver:false, showDown:false,
    showDisabled:false, // XXX
    prompt:"Remove",
    click: function () { this.creator.removeButtonClick(this.clause) }
},

//> @attr filterBuilder.showAddButton (boolean : true : IR)
// If set, a button will be shown underneath all current clauses allowing a new clause to be
// added.
// @visibility external
//<
showAddButton:true,

//> @attr filterBuilder.addButton (AutoChild : null : IR)
// An ImgButton that allows new clauses to be added if +link{showAddButton}
// is set.
// @visibility external
//<
addButtonDefaults : {
    _constructor:isc.ImgButton,
    autoParent:"buttonBar",
    width:18, height:18, 
    src:"[SKIN]/actions/add.png",
    showRollOver:false, showDown:false, 
    prompt:"Add",
    click: function () { this.creator.addButtonClick(this.clause) }
},

buttonBarDefaults : {
    _constructor:isc.HStack,
    autoParent:"clauseStack",
    membersMargin:4, 
    defaultLayoutAlign:"center",
    height:1
},

addButtonClick : function () {
    this.addNewClause();
},

removeButtonClick : function (clause) {
    this.removeClause(clause);
},

//> @method filterBuilder.removeClause()
// Remove a clause this is currently showing.
// @param clause (Clause) clause as retrieved from filterBuilder.clauses
// @visibility external
//<
removeClause : function (clause) {
    this.clauses.remove(clause);

    var clauseLayout = clause.clauseLayout;
    this.clauseStack.hideMember(clauseLayout, function () { clauseLayout.destroy(); })

    if (this.firstRemoveButton) this.updateFirstRemoveButton();
},

//> @attr filterBuilder.allowEmpty (boolean : false : IR)
// If set to false, the last clause cannot be removed.
// @visibility external
//<

updateFirstRemoveButton : function () {
    var firstClause = this.clauses[0];
    if (this.clauses.length == 1 && !this.allowEmpty) {
        firstClause.removeButton.disable(); 
        firstClause.removeButton.setOpacity(50); // XXX need media with disabled state
    } else if (this.clauses.length > 1) {
        firstClause.removeButton.enable();
        firstClause.removeButton.setOpacity(100); // XXX need media with disabled state
    }
},
 
// Top-level Operator  
// ---------------------------------------------------------------------------------------

//> @type LogicalOperator
// Operators that can evaluate a set of criteria and produce a combined result.
//
// @value "and" true if all criteria are true
// @value "or" true if any criteria are true
// @value "not" true if all criteria are false
// @visibility external
//< 

//> @attr filterBuilder.topOperator (LogicalOperator : "and" : IRW)
// Default logical operator for all top-level clauses in the FilterBuilder.
// <P>
// May be able to be changed by the user via the UI, according to +link{topOperatorAppearance}.
// @visibility external
//<
topOperator:"and",

//> @attr filterBuilder.radioOptions (Array of OperatorId : ["and", "or", "not"] : IR)
// Logical operators to allow if we have a +link{topOperatorAppearance} of "radio".
//
// @visibility external
//<
radioOptions: ["and", "or", "not"],

//> @method filterBuilder.setTopOperator()
// Programmatically change the +link{topOperator} for this FilterBuilder.
// @param operator (OperatiorId) new top-level operator
// @visibility external
//<
setTopOperator : function (newOp) {
    this.topOperator = newOp;
    var appearance = this.topOperatorAppearance;

    if (appearance == "bracket") {
        this.topOperatorForm.setValue("operator", newOp);
    } else if (appearance == "radio") {
        this.radioOperatorForm.setValue("operator", newOp);
    }
},

// called when the user changes the topOperator via a form
topOperatorChanged : function (newOp) {
    this.topOperator = newOp;
},

//> @type TopOperatorAppearance
// Interface to use for the showing and editing the +link{topOperator,top-level operator} of a
// FilterBuilder.
//
// @value "radio" radio buttons appear at the top of the form
//
// @value "bracket" a SelectItem appears with a "bracket" spanning all top-level clauses,
// exactly the same appearance used for showing
// +link{filterBuilder.showSubClauseButton,subClauses}, if enabled.
//
// @value "none" no interface is shown.  The top-level operator is expected to be shown to
// the user outside the FilterBuilder, and, if editable, +link{filterBuilder.setTopOperator()}
// should be called to update it
// @visibility external
//<

//> @attr filterBuilder.topOperatorAppearance (TopOperatorAppearance : "bracket" : IR)
// How to display and edit the +link{topOperator,top-level operator} for this FilterBuilder.
// <P>
// See +link{type:TopOperatorAppearance} for a list of options.
// @visibility external
//<
topOperatorAppearance:"bracket", 

//> @attr filterBuilder.radioOperatorForm (AutoChild : null : IR)
// With +link{topOperatorAppearance}:"radio", form that appears above the stack of clauses
// and allows picking the +link{LogicalOperator} for the overall FilterBuilder.
// <P>
// By default, consists of a simple RadioGroupItem.
// @visibility external
//<
radioOperatorFormDefaults : {
    _constructor:isc.DynamicForm,
    autoParent:"clauseStack",
    height:1, 
    items : [
        { name:"operator", type:"radioGroup", showTitle:false, vertical:false,
          width: 250,
          changed : function (form, item, value) {
              form.creator.topOperatorChanged(value);
          }
        }
    ]
},

//> @attr filterBuilder.topOperatorForm (AutoChild : null : IR)
// With +link{topOperatorAppearance}:"bracket", form that appears to the left of the stack of
// clauses and allows picking the +link{LogicalOperator} for the overall FilterBuilder.
// <P>
// By default, consists of a simple SelectItem.
// @visibility external
//<
topOperatorFormDefaults : {
    height:1, 
    width:80, numCols:1, colWidths:["*"],
    layoutAlign:"center",
    _constructor:isc.DynamicForm,
    items : [{ 
        name:"operator",
        type: "select",
        showTitle:false,
        width:"*", 
        changed : function (form, item, value) {
            form.creator.topOperatorChanged(value);
        }
    }]
},

//> @attr filterBuilder.defaultSubClauseOperator (LogicalOperator : "or" : IR)
// Default operator for subclauses added via the +link{subClauseButton}.
// @visibility external
//<
defaultSubClauseOperator:"or",

// Init
// ---------------------------------------------------------------------------------------

initWidget : function () {
    this.Super("initWidget", arguments);
    
    var undef;
    if (this.showSubClauseButton == undef) {
        this.showSubClauseButton = (this.topOperatorAppearance != "radio");
    }
    
    this.clauses = [];

    var topOp = this.topOperatorAppearance;
        
    var tempMap = this.getDataSource().getTypeOperatorMap("text", true, "criteria"),
        tempArr = [];
    // We haven't got a lot of room, so we really want to be saying "and" in this 
    // select box, rather than "All subcriteria are true"
    for (var prop in tempMap) {
        tempArr.add(prop);
    }
    if (topOp == "bracket") {
        if (this.showTopRemoveButton) {
            // When the FilterBuilder is being used as a subclause it needs a remove button.
            // Our parent FilterBuilder could tack one on, but only by introducing an extra
            // layer of nesting, so we manage it here.
            var removeButton = this.createAutoChild("removeButton", {
                click : function () { 
                    this.creator.parentClause.removeButtonClick(this.creator)
                }
            });
            this.clauseLayout = this;
            this.addMember(removeButton);
        }
        this.addAutoChild("topOperatorForm");
        this.topOperatorForm.items[0].valueMap = tempArr;
        this.topOperatorForm.items[0].defaultValue = this.topOperator;
            
        this.addAutoChild("bracket");
    } 
    this.addAutoChild("clauseStack");
    if (topOp == "radio") {
        this.addAutoChild("radioOperatorForm");
        var radioMap = {};
        for (var i = 0; i < this.radioOptions.length; i++) {
            radioMap[this.radioOptions[i]] = tempMap[this.radioOptions[i]];
        }
        this.radioOperatorForm.items[0].valueMap = radioMap; 
        this.radioOperatorForm.items[0].defaultValue = this.topOperator;
    }
    this.addAutoChildren(["buttonBar", "addButton", "subClauseButton"]);

    if (this.criteria) {
        this.setCriteria(this.criteria)
    } else if (!this.allowEmpty && !this.dontCreateEmptyChild) {
        this.addNewClause();
    }

    this.setTopOperator(this.topOperator);
},

// Clause creation
// ---------------------------------------------------------------------------------------

filterRow:[
    // list of fields
    {type:"select", name:"fieldName", showTitle:false, width:150, 
     changed : function () { this.form.creator.fieldNameChanged(this.form) }
    },
    // list of operators
    {name:"operator", type:"select", showTitle:false, width:150, 
     addUnknownValues:false, defaultToFirstOption:true,
     changed : function () { this.form.creator.operatorChanged(this.form) }
    }
],

clauseConstructor: isc.DynamicForm,

clauseDefaults: {
    _$Enter:"Enter",
    handleKeyPress : function (event, eventInfo) {
        // We need to suppress normal DynamicForm saveOnEnter behavior; we also need to let
        // the FilterBuilder that will eventually see this event know whether or not the field
        // triggering it was a TextItem
        var item = this.getFocusItem();
        if (isc.isA.TextItem(item)) eventInfo.firedOnTextItem = true;
        
        // But we need normal key handling for everything except Enter!
        if (event.keyName != this._$Enter) {
            return this.Super("handleKeyPress", [event, eventInfo]);
        }
    },
    itemChanged : function (item, newValue, oldValue) {
        if (this.creator.itemChanged) this.creator.itemChanged();
    }
},

//> @attr filterBuilder.clauseStack (AutoChild : null : IR)
// VStack of all clauses that are part of this FilterBuilder
// @visibility external
//<
clauseStackDefaults : {
    _constructor:isc.VStack,
    height:1,
    membersMargin:1, // otherwise brackets on subclauses are flush
    animateMembers: true,
    animateMemberTime: 300
},

// hstack for each clause
clauseLayoutDefaults: {
    _constructor:isc.HStack,
    height:1
},

addNewClause : function (criterion) {
    var items = isc.clone(this.filterRow);

    var allFieldNames = this.getDataSource().getFieldNames(),
        fieldNames = [];
    // skip hidden fields
    for (var i = 0; i < allFieldNames.length; i++) {
        var fieldName = allFieldNames[i];
        if (this.getDataSource().getField(fieldName).hidden) continue;
        fieldNames.add(allFieldNames[i]);
    }
    
    var fieldMap = {};
    for (i = 0; i < fieldNames.length; i++) {
        fieldName = fieldNames[i];
        if (this.showFieldTitles) {
            var fieldTitle = this.getDataSource().getField(fieldName).title;
            fieldTitle = fieldTitle ? fieldTitle : fieldName;
            fieldMap[fieldName] = fieldTitle;
        } else {
            fieldMap[fieldName] = fieldName;
        }
    }
    items[0].valueMap = fieldMap;
    
    if (criterion && criterion.fieldName) {
        if (fieldNames.contains(criterion.fieldName)) {
            items[0].defaultValue = criterion.fieldName;
        } else {
            isc.logWarn("Criterion specified field " + criterion.fieldName + ", which is not" +
                        " in the record. Using the first record field (" + fieldNames[0] + 
                        ") instead");
            items[0].defaultValue = fieldNames[0];
        }
    } else {
        items[0].defaultValue = fieldNames[0];
    }

    var valueMap = this.getDataSource().getFieldOperatorMap(fieldNames[0], false, "criteria", true);
    items[1].valueMap = valueMap;
    if (criterion && criterion.operator) {
        items[1].defaultValue = criterion.operator;
    } else {
        items[1].defaultValue = isc.firstKey(valueMap);
    }

    var operator = this.getDataSource().getSearchOperator(items[1].defaultValue),
        field = this.getDataSource().getField(items[0].defaultValue);

    if (!operator) {
        isc.logWarn("Criterion specified unknown operator " + criterion.operator + 
                    ". Using the first valid operator (" + isc.firstKey(valueMap) + ") instead");
        items[1].defaultValue = isc.firstKey(valueMap);
        operator = this.getDataSource().getSearchOperator(items[1].defaultValue);
    }
        
    var valueItems = this.buildValueItemList(field, operator);
    
    if (criterion) {
        if (criterion.value != null && valueItems.containsProperty("name", "value")) {
            valueItems.find("name", "value").defaultValue = criterion.value;
        }
        if (criterion.start != null && valueItems.containsProperty("name", "start")) {
            valueItems.find("name", "start").defaultValue = criterion.start;
        }
        if (criterion.end != null && valueItems.containsProperty("name", "end")) {
            valueItems.find("name", "end").defaultValue = criterion.end;
        }
    }
    
    items.addList(valueItems);
    
    var clause = this.createAutoChild("clause", {
        flattenItems: true,
        items: items
    });
    this.clauses.add(clause);
    this.updateFields(clause);

    var removeButton = this.createAutoChild("removeButton");
    var members = [removeButton];

    members.add(clause);
    var clauseLayout = this.createAutoChild("clauseLayout", {
        visibility:"hidden",
        members:members
    });
    clause.removeButton = removeButton;
    clause.clauseLayout = clauseLayout;
    removeButton.clause = clause;

    var clauseStack = this.clauseStack;
    var position = Math.max(0, clauseStack.getMemberNumber(this.buttonBar));
    clauseStack.addMember(clauseLayout, position);
    clauseStack.showMember(clauseLayout, function () { clause.focusInItem("fieldName") });

    this.updateFirstRemoveButton();
},

//> @attr filterBuilder.rangeSeparator (String : ">>" : IR)
// For operators that check that a value is within a range, text to show between the start and
// end input fields for specifying the limits of the range.
// @visibility external
//<
rangeSeparator: ">>",

buildValueItemList : function (field, operator) {
    
    var fieldName = field.name,
        valueType = operator.valueType,
        baseFieldType = isc.SimpleType.getType(field.type) || isc.SimpleType.getType("text"),
        items = [];

    // In case this is a user-defined type, derive the built-in base type it 
    // ultimately inherits from, so we know which is the best FormItem to use
    while (baseFieldType.inheritsFrom) {
         baseFieldType = isc.SimpleType.getType(baseFieldType.inheritsFrom);
    }
    
    // We're not interested in the object, just the name
    baseFieldType = baseFieldType.name;
    
    if (valueType == "valueSet") {  
        return;  // XXX - For now, we can't cope with these

    // a value of the same type as the field
    } else if (valueType == "fieldType" || valueType == "custom")  {
        var editorType = null;
        if (valueType == "custom" && operator.editorType) {
            editorType = operator.editorType;
        }
        
        var fieldDef = isc.addProperties({
            type: baseFieldType, name: "value", showTitle: false,
            width: 150, editorType: editorType,    
            changed : function () { this.form.creator.valueChanged(this, this.form) }
        }, this.getValueFieldProperties(field.type, fieldName));
        
        if (field.type == "enum") {
            fieldDef - isc.addProperties(fieldDef, {
                valueMap: field.valueMap
            });
        }
        
        items.add(fieldDef);

    // another field in the same DataSource
    } else if (valueType == "fieldName") {
        var altFieldNames = this.getDataSource().getFieldNames();
        altFieldNames.remove(fieldName);
        items.add(isc.addProperties({
            type: "select", name: "value", showTitle: false,
            width: 150, valueMap: altFieldNames,    
            changed : function () { this.form.creator.valueChanged(this, this.form) }
        }, this.getValueFieldProperties(field.type, fieldName)));

    // two values of the same type as the field
    } else if (valueType == "valueRange") {
        items.addList([isc.addProperties(
                { type: baseFieldType, name: "start", showTitle: false,
                width: 150,
                changed : function () { this.form.creator.valueChanged(this, this.form) }
            }, this.getValueFieldProperties(field.type, fieldName)),
               isc.addProperties({ type: "staticText", name: "rangeSeparator", showTitle: false,
                width: 1, defaultValue: this.rangeSeparator, shouldSaveValue:false,
                changed : function () { this.form.creator.valueChanged(this, this.form) }
           }, this.getValueFieldProperties(field.type, fieldName)),
               isc.addProperties({ type: baseFieldType, name: "end", showTitle: false,
                width: 150,    
                changed : function () { this.form.creator.valueChanged(this, this.form) }
           }, this.getValueFieldProperties(field.type, fieldName))
        ]);
    }
    return items;
},

valueChanged : function (valueField, form) {
},

fieldNameChanged : function (form) {
    this.updateFields(form);
},

removeValueFields : function (form) {

    if (form.getItem("value")) form.removeItem("value");
    if (form.getItem("rangeSeparator")) form.removeItem("rangeSeparator");
    if (form.getItem("start")) form.removeItem("start");    
    if (form.getItem("end")) form.removeItem("end");    
},

operatorChanged : function (form) {

    var fieldName = form.getValue("fieldName");
    if (fieldName == null) return;

    var field = this.getDataSource().getField(fieldName);
    var operator = this.getDataSource().getSearchOperator(form.getValue("operator"));
    
    this.removeValueFields(form);
    var items = this.buildValueItemList(field, operator)

    form.addItems(items);
},

updateFields : function (form) {

    var fieldName = form.getValue("fieldName");
    if (fieldName == null) return;

    var field = this.getDataSource().getField(fieldName);
    var operator = this.getDataSource().getSearchOperator(form.getValue("operator"));

    // note this setValueMap() call means if an operator was already chosen, it will be
    // preserved unless no longer valid for the new field
    form.getItem("operator").setValueMap(
        this.getDataSource().getFieldOperatorMap(field, false, "criteria", true));
    
    // if the field is of the same type, leave the "value" field alone
    if (form.getItem("value") && (field.type || "text") == form.getItem("value").type) return;

    // otherwise rebuild the value fields and clear out the currently entered value.
    // This prevents eg a Date value from appearing when we swap to a text item
    this.removeValueFields(form);

    form.setValue("value", null);
    // likewise for range fields
    if (form.getItem("start")) form.setValue("start", null);
    if (form.getItem("end")) form.setValue("end", null);

    form.addItems(this.buildValueItemList(field, operator));
},

//> @method filterBuilder.getFieldOperators()
// Get the list of +link{Operators} that are valid on this field.  By default, all operators
// returned by +link{dataSource.getFieldOperators()} are used.
// <P>
// Called whenever the fieldName is changed.
// 
// @return (Array of Operator) valid operators for this field
// @visibility external
//<
getFieldOperators : function (fieldName) {
    var field = this.getDataSource().getField(fieldName)
    return this.getDataSource().getFieldOperators(field); 
},

//> @method filterBuilder.getValueFieldProperties()
// Override to return properties for the FormItem used for the "value" field, that is, the
// user-entered value that becomes +link{criterion.value}.
// 
// @param type (FieldType) type of the DataSource field for this filter row
// @param type (String) name of the DataSource field for this filter row
// @visibility external
//<
getValueFieldProperties : function (type, fieldName) {
},

// Subclauses
// ---------------------------------------------------------------------------------------

//> @attr filterBuilder.showSubClauseButton (boolean : See Description : IR)
// Whether to show a button that allows the user to add subclauses.  Defaults to false if 
// the +link{topOperatorAppearance} is "radio", true in all other cases.
// @visibility external
//<

//> @attr filterBuilder.subClauseButton (AutoChild : null : IR)
// Button allowing the user to add subclauses grouped by a +link{type:LogicalOperator}.
// @visibility external
//<
subClauseButtonDefaults : {
    _constructor:"IButton",
    autoParent:"buttonBar",
    title:"+()", // need an icon for this
    autoFit:true,
    prompt:"Add Subclause",
    click : function () { this.creator.addSubClause(this.clause) }
},

//> @attr filterBuilder.bracket (AutoChild : null : IR)
// Widget used as a "bracket" to hint to the user that a subclause groups several
// field-by-field filter criteria under one logical operator.
// <P>
// By default, a simple CSS-style Canvas with borders on three sides.  A vertical StretchImg
// could provide a more elaborate appearance.
// @visibility external
//<
bracketDefaults : {
    styleName:"bracketBorders", 
    width:10
},

childResized : function () {
    this.Super("childResized", arguments);
    if (this.clauseStack && this.bracket) this.bracket.setHeight(this.clauseStack.getVisibleHeight());
},
draw : function () {
    this.Super("draw", arguments);
    if (this.clauseStack && this.bracket) this.bracket.setHeight(this.clauseStack.getVisibleHeight());
},

addSubClause : function (criterion) {
    var operator;
    if (criterion) {
        operator = criterion.operator;
    }
    var clause = this.createAutoChild("subClause", {
        dataSource:this.dataSource,
        parentClause:this, showTopRemoveButton:true,
        topOperatorAppearance:"bracket",
        topOperator: operator || this.defaultSubClauseOperator,
        visibility:"hidden",
        saveOnEnter: this.saveOnEnter,
        // We don't need (or want) to create empty children of new subclauses if we're 
        // building up the UI from a passed-in AdvancedCriteria
        dontCreateEmptyChild: criterion != null
    }, this.Class);

    this.clauses.add(clause);

    this.clauseStack.addMember(clause, this.clauses.length-1);
    this.clauseStack.showMember(clause, function () { 
        clause.topOperatorForm.focusInItem("operator") 
        clause.bracket.setHeight(clause.getVisibleHeight());
    });
    
    return clause;
},


// Deriving AdvancedCriteria
// ---------------------------------------------------------------------------------------

//> @method filterBuilder.getCriteria()
// Get the criteria entered by the user.
// 
// @return (AdvancedCriteria)
// @visibility external
//<
getCriteria : function () {
    var criteria = {
        _constructor:"AdvancedCriteria",
        operator:this.topOperator,
        criteria:[]
    };
    for (var i = 0; i < this.clauses.length; i++) {
        var clause = this.clauses[i],
            criterion,
            skipCriterion = false;
        if (isc.isA.FilterBuilder(clause)) {
            criterion = clause.getCriteria();
        } else {
            criterion = clause.getValues();
			// Flag any dates as logicalDates, so they don't run the risk of timezone conversion
			if (isc.isA.Date(criterion.value)) criterion.value.logicalDate = true;

            // Ignore criteria where no value has been set, unless it is an operator (eg, isNull)
            // that does not require a value, or requires a start/end rather than a value
            var operator = criterion.operator;
            if (isc.isA.String(operator)) operator = this.getDataSource().getSearchOperator(operator);
            if (operator.valueType != "none" && 
                operator.valueType != "valueRange" &&
                (criterion.value == null || criterion.value == ""))
            {
                skipCriterion = true;
            }
        }
        if (!skipCriterion) criteria.criteria.add(criterion);
    }
    // Return a copy - the original contains pointers to the live screen objects
    return isc.clone(criteria);
},

//> @method filterBuilder.setCriteria()
// Set new criteria for editing.  
// <P>
// An interface for editing the provided criteria will be generated identically to what happens
// when initialized with +link{criteria}.
// <P>
// Any existing criteria entered by the user will be discarded.  
// 
// @param criteria (AdvancedCriteria) new criteria.  Pass null or {} to effectively reset the
//                                    filterBuilder to it's initial state when no criteria are
//                                    specified
// @visibility external
//<
setCriteria : function (criteria) {
    
    this.clearCriteria(true);

    if (!criteria) {
        return;
    }
    if (criteria._constructor != "AdvancedCriteria") {
        // The textMatchStyle we pass here is kind of arbitrary...
        criteria = this.getDataSource().convertCriteria(criteria, "substring");
    }

    this.setTopOperator(criteria.operator);
    
    if (!criteria.criteria || criteria.criteria.length == 0) {
        this.logWarn("Found top-level AdvancedCriteria with no sub-criteria. Converting " +
                     "to a top-level 'and' with a single sub-criterion");
        this.setTopOperator("and");
        this.addNewClause(criteria);     
    } else {
        for (var i = 0; i < criteria.criteria.length; i++) {
            this.addCriterion(criteria.criteria[i]);
        }
    }
},

//> @method filterBuilder.clearCriteria()
// Clear all current criteria.
// @visibility external
//<
clearCriteria: function (dontCheckEmpty) {
    while (this.clauses.length > 0) {
        this.removeClause(this.clauses[0]);
    }
    if (!dontCheckEmpty && !this.allowEmpty) this.addNewClause();
},

//> @method filterBuilder.addCriterion()
// Add a new criterion, including recursively adding sub-criteria for a criterion that
// contains other criteria.
// 
// @param criterion (Criterion) new criterion to be added
// @visibility external
//<
addCriterion : function (criterion) {

    if (criterion.criteria) {
        var clause = this.addSubClause(criterion);
        for (var idx = 0; idx < criterion.criteria.length; idx++) {
            clause.addCriterion(criterion.criteria[idx]);
        }
    } else {
        this.addNewClause(criterion)
    }

},

_$Enter:"Enter",
handleKeyPress: function(event, eventInfo){

    // Special case for Enter keypress: If this.saveOnEnter is true, and the enter keypress
    // occurred in a text item, and this is a top-level FilterBuilder with a search() method
    // defined, call the search() method and stop bubbling
    if (event.keyName == this._$Enter) {
        if (this.saveOnEnter) {
            if (eventInfo.firedOnTextItem) {
                if (!this.creator && this.search) {
                    this.search(this.getCriteria());
                    return isc.EH.STOP_BUBBLING;
                }
            }
        }
    }
},

itemChanged : function() {
    if (this.creator && isc.isA.Function(this.creator.itemChanged)) {
        this.creator.itemChanged();
    } else {
        if (!this.creator && isc.isA.Function(this.filterChanged)) {
            this.filterChanged();
        }
    }
}

});

isc.FilterBuilder.registerStringMethods({
    
    //> @method filterBuilder.search()
    // A StringMethod that is automatically invoked if +link{filterBuilder.saveOnExit} is set 
    // and the user presses Enter whilst in a text-item in any clause or subclause.
    //
    // @param criteria (AdvancedCriteria) The criteria represented by the filterBuilder
    // @visibility external
    //< 

    search : "criteria",
    
    //> @method filterBuilder.filterChanged()
    // Handler fired when there is a change() event fired on any FormItem within the 
    // filterBuilder. 
    //
    // @visibility external
    //< 

    filterChanged : ""
});


} // End of if (isc.DynamicForm)
