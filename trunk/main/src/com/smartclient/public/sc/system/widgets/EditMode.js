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



// Resize thumbs
// --------------------------------------------------------------------------------------------

isc.Canvas.addClassProperties({
    resizeThumbConstructor:isc.Canvas,
    resizeThumbDefaults:{
        width:8, 
        height:8, 
        overflow:"hidden", 
        styleName:"resizeThumb",
        canDrag:true,
        canDragResize:true,
        // resizeEdge should be the edge of the target, not the thumb
        getEventEdge : function () { return this.edge; },
        autoDraw:false
    }
});

isc.Canvas.addClassMethods({
    // NOTE: Canvas thumbs vs one-piece mask?
    // - since we reuse the same set of thumbs, there's no real performance issue
    // - one-piece mask implementations: 
    //   - if an image with transparent regions, thumbs would scale 
    //   - if a table
    //     - event handling iffy - transparent table areas may or may not intercept
    //     - would have to redraw on resize
    //   - transparent Canvas with absolutely-positioned DIVs as content
    //     - event handling might be iffy
    // - would have bug: when thumbs are showing, should be able to click between them to hit
    //   something behind the currently selected target
    // - when thumbs are not showing, mask still needs to be there, but would need to shrink and not
    //   show thumbs
    _makeResizeThumbs : function () {
        var edgeCursors = isc.Canvas.getInstanceProperty("edgeCursorMap"),
            thumbs = {},
            thumbClass = isc.ClassFactory.getClass(this.resizeThumbConstructor);
        for (var thumbPosition in edgeCursors) {
           // NOTE: can't use standard autoChild creation because we are in static scope -
           // thumbs are globally shared
           thumbs[thumbPosition] = thumbClass.create({
                ID:"isc_resizeThumb_" + thumbPosition,
                edge:thumbPosition
           }, this.resizeThumbDefaults, this.resizeThumbProperties)
        }
        isc.Canvas._resizeThumbs = thumbs;
    },

    showResizeThumbs : function (target) {
        if (!target) return;
        
        if (!isc.Canvas._resizeThumbs) isc.Canvas._makeResizeThumbs();

        var thumbSize = isc.Canvas.resizeThumbDefaults.width,
            thumbs = isc.Canvas._resizeThumbs;
     
        // place the thumbs along the outside of the target
        var rect = target.getPageRect(),
            left = rect[0],
            top = rect[1],
            width = rect[2],
            height = rect[3],
    
            midWidth = Math.floor(left + (width/2) - (thumbSize/2)),
            midHeight = Math.floor(top + (height/2) - (thumbSize/2));

        thumbs.T.moveTo(midWidth, top - thumbSize);
        thumbs.B.moveTo(midWidth, top + height);
        thumbs.L.moveTo(left - thumbSize, midHeight);
        thumbs.R.moveTo(left + width, midHeight);

        thumbs.TL.moveTo(left - thumbSize, top - thumbSize);
        thumbs.TR.moveTo(left + width, top - thumbSize);
        thumbs.BL.moveTo(left - thumbSize, top + height);
        thumbs.BR.moveTo(left + width, top + height);
        
        for (var thumbName in thumbs) {
            var thumb = thumbs[thumbName];
            // set all the thumbs to drag resize the canvas we're masking
            thumb.dragTarget = target;
            // show all the thumbs            
            thumb.show();
        }

        this._thumbTarget = target;
    },
    
    hideResizeThumbs : function () {
        var thumbs = this._resizeThumbs;
        for (var thumbName in thumbs) {
            thumbs[thumbName].hide();
        }
        this._thumbTarget = null;
    }

});

// Edit Mask
// --------------------------------------------------------------------------------------------

// At the Canvas level the Edit Mask provides moving, resizing, and standard context menu items.
// The editMask should be extended on a per-widget basis to add things like drop behaviors or
// additional context menu items.  Any such extensions should be delineated with 
//>EditMode 
//<EditMode
// .. markers so it can be eliminated from normal builds.

isc.Canvas.addProperties({
    editMaskDefaults:{

        // Thumb handling
        // ---------------------------------------------------------------------------------------
        draw : function () {
            this.Super("draw", arguments);

            // stay above the master
            this.observe(this.masterElement, "setZIndex", "observer.moveAbove(observed)");
            // show thumbs on the master as soon as we're draw()n
            isc.Canvas.showResizeThumbs(this);

            // match the master's prompt (native tooltip).  Only actually necessary in Moz since IE
            // considers the eventMask transparent with respect to determining the prompt.
            this.observe(this.masterElement, "setPrompt", "observer.setPrompt(observed.prompt)");

            return this;
        },
        parentVisibilityChanged : function () {
            this.Super("parentVisibilityChanged", arguments);
            if (isc.Canvas._thumbTarget == this) isc.Canvas.hideResizeThumbs();
        },

        // show thumbs when clicked on.  NOTE: since there's only one set of thumbs, this implicitly
        // accomplishes the goal of having only one selected widget
        click : function () {
            isc.Canvas.showResizeThumbs(this);
            return isc.EH.STOP_BUBBLING;
        },

        // Event Bubbling
        // ---------------------------------------------------------------------------------------

        // XXX FIXME: this is here to maintain z-order on dragReposition.  EH.handleDragStop()
        // brings the mask to the front when we stop dragging - which is not what we want, so we
        // suppress it here.
        bringToFront : function () { },
    
        // prevent bubbling to the editor otherwise we'll start a selection while trying to
        // select/move a component
        mouseDown : function () {
            this.Super("mouseDown", arguments);
            return isc.EH.STOP_BUBBLING;
        },

        mouseUp : function () {
            this.Super("mouseUp", arguments);
            return isc.EH.STOP_BUBBLING;
        },

        doubleClick : function () {
            this._maskTarget.bringToFront();
            return this.click();
        },

        // Drag and drop move and resize
        // ---------------------------------------------------------------------------------------
        // D&D: some awkwardness
        // - if we set dragTarget to the masterElement, it will get the setDragTracker(), 
        //   dragRepositionMove() etc events, which it may have overriden, whereas we want just a
        //   basic reposition or resize, so we need to be the dragTarget
        // - to be in the right parental context, and to automatically respond to programmatic
        //   manipulation of the parent's size and position, we want to be a peer, but at the end of
        //   drag interactions we also need to move/resize the master, which would normally cause
        //   the master to move us, so we need to switch off automatic peer behaviors while we move
        //   the master

        // allow the mask to be moved around (only the thumbs allow resize)
        canDrag:true,
        canDragReposition:true,
    
        // don't allow setDragTracker to bubble in case some parent tries to set it innapropriately
        setDragTracker: function () { return isc.EH.STOP_BUBBLING },

        // when we're moved or resized, move/resize the master and update thumb positions
        moved : function () {
            this.Super("moved", arguments);

            var masked = this.masterElement;
            if (masked) {
                // calculate the amount the editMask was moved
                var deltaX = this.getOffsetLeft() - masked.getLeft();
                var deltaY = this.getOffsetTop() - masked.getTop();

                // relocate our master component (avoiding double notifications)
                this._moveWithMaster = false;
                masked.moveTo(this.getOffsetLeft(), this.getOffsetTop());
                this._moveWithMaster = true;
            }

            if (isc.Canvas._thumbTarget == this) isc.Canvas.showResizeThumbs(this);
        },

        resized : function () {
            this.Super("resized", arguments);

            // don't loop if we resize master, master overflows, and we resize to overflow'd size
            if (this._resizingMaster) return;
            this._resizingMaster = true;

            var master = this.masterElement;
            if (master) {

                // resize the widget we're masking (avoiding double notifications)
                this._resizeWithMaster = false;
                master.resizeTo(this.getWidth(), this.getHeight());
                this._resizeWithMaster = true;

                // the widget we're masking may overflow, so redraw if necessary to get new size so,
                // and match its overflow'd size
                master.redrawIfDirty();
                this.resizeTo(master.getVisibleWidth(), master.getVisibleHeight());
            }

            // update thumb positions
            isc.Canvas.showResizeThumbs(this);

            this._resizingMaster = false;
        },

        // Editing Context Menus
        // ---------------------------------------------------------------------------------------
        // standard context menu items plus the ability to add "editMenuItems" on the master
        showContextMenu : function () {
            var edited = this.masterElement,
                menuItems;

            if (this.editContext.selectedComponents.length > 0) { // multi-select
                menuItems = 
                        (edited.editMultiMenuItems || []).concat(this.multiSelectionMenuItems);
            } else {
                menuItems = (edited.editMenuItems || []).concat(this.standardMenuItems);
            }

            if (!this.contextMenu) this.contextMenu = isc.Menu.create({});
            this.contextMenu.setData(menuItems);

            // NOTE: show the menu on our masterElement (the widget we're masking) so that "target"
            // in click methods will be the masterElement and not the mask.
            this.contextMenu.showContextMenu(edited);
            return false;
        },
        standardMenuItems:[
            {title:"Remove", click:"target.destroy()"},
            {title:"Bring to Front", click:"target.bringToFront()"},
            {title:"Send to Back", click:"target.sendToBack()"}
        ],
        multiSelectionMenuItems:[
            {title:"Remove Selected Items", click:"target.editContext.removeSelection(target)"}
        ]
    },

    // Enabling EditMode
    // ---------------------------------------------------------------------------------------

    useEditMask:true,
    setEditMode : function (editingOn, editContext) {
        if (editingOn == null) editingOn = true;
        if (this.editingOn == editingOn) return;
        this.editingOn = editingOn;

        
        if (this.editingOn) {
            this.editContext = editContext;
            // enable editing
            if (this.useEditMask) this.showEditMask();
        } else {
            // disable editing
            this.hideEditMask();
        }
    },
    

    showEditMask : function () {

        var svgID = this.getID() + ":<br>" + this.src;

        // create an edit mask if we've never created one
        if (!this._editMask) {

            // special SVG handling
            // FIXME: move all SVG-specific handling to SVG.js
            var svgProps = { };
            if (isc.SVG && isc.isA.SVG(this) && isc.Browser.isIE) {
                isc.addProperties(svgProps, {
                    backgroundColor : "gray",
                    mouseOut : function () { this._maskTarget.Super("_hideDragMask"); },
                    contents : isc.Canvas.spacerHTML(10000,10000, svgID)
                });
            }
    
            var props = isc.addProperties({}, this.editMaskDefaults, this.editMaskProperties, 
                                          // assume the editContext is the parent if none is
                                          // provided
                                          {editContext:this.editContext || this.parentElement, 
                                           keepInParentRect: this.keepInParentRect},
                                          svgProps);
            this._editMask = isc.EH.makeEventMask(this, props);
        }
        this._editMask.show();

        // SVG-specific
        if (isc.SVG && isc.isA.SVG(this)) {
            if (isc.Browser.isIE) this.showNativeMask();
            else {
                this.setBackgroundColor("gray");
                this.setContents(svgID);
            }
        }
    },
    hideEditMask : function () {
        if (this._editMask) this._editMask.hide();
    }
});

// D&D Instantiation
// --------------------------------------------------------------------------------------------
// The Palette knows:
// - how to create the object
// The EditContainer knows:
// - where the object will be placed
// - whether it can accept an object of that type at that position

// AddChildObject
// ---------------------------------------------------------------------------------------
// Generic system for adding subobjects to some object, driven by schema, with naming-patterns
// based auto-discovery of appropriate getter/setter/adder/remover functions.
//
// NOTE: in order to accomodate both live Class instances and simple objects, these should
// always be called staticly.  The instance methods are intended as override points for Classes
// that violate the naming pattern (eg there's no way to guess "addChild" is the right method
// to add a "Canvas" to "Canvas.children") 

isc.Class.addMethods({
    getSchema : function () {
        // NOTE: this.schemaName allows multiple classes to share a single role within editing,
        // eg the various possible implementations of tabs, section headers, etc
        return isc.DS.get(this.schemaName || this.Class);
    },
    getSchemaField : function (fieldName) {
        return this.getSchema().getField(fieldName);
    },
    getObjectField : function (type) {
        // cache lookups, but only on Canvases.  FIXME: we should really cache lookups only for
        // framework DataSources
        var objectFields = this._objectFields;
        if (isc.isA.Canvas(this)) {
            var undef;
            if (objectFields && objectFields[type] !== undef) {
                //this.logWarn("cache hit: " + type);
                return objectFields[type];
            }
        }

        var fieldName = this.getSchema().getObjectField(type);

        if (isc.isA.Canvas(this)) {
            if (!objectFields) this._objectFields = objectFields = {};
            objectFields[type] = fieldName;
        }

        return fieldName;
    },
    addChildObject : function (newChildType, child, index) {
        return this._doVerbToChild("add", newChildType, child, index);
    },
    removeChildObject : function (childType, child) {
        return this._doVerbToChild("remove", childType, child);
    },

    _doVerbToChild : function (verb, childType, child, index) {
        var fieldName = this.getObjectField(childType);
        var field = this.getSchemaField(fieldName);

        // for fields that aren't set to multiple, call setProperties to add the object, which
        // will look up and use the setter if there is one 
        // (eg field "contextMenu", "setContextMenu")
        if (!field.multiple) {
            var props = {};
            props[fieldName] = child;
            this.logInfo(verb + "ChildObject calling setProperties", "editing");
            this.setProperties(props);
            return true;
        }

        var methodName = this.getFieldMethod(childType, fieldName, verb);
        if (methodName != null) {
            this.logInfo("calling " + methodName + "(" + this.echoLeaf(child) + 
                         (index != null ? "," + index + ")" : ")"),
                         "editing");
            this[methodName](child, index);
            return true;
        }

        return false;
    },

    getChildObject : function (type, id) {
        var fieldName = this.getObjectField(type), 
            field = this.getSchemaField(fieldName);

        // if the field is not array-valued, just use getProperty, which will auto-discover
        // getters
        if (!field.multiple) return this.getProperty(fieldName);

        // otherwise, look for a getter method and call it with the id
        var methodName = this.getFieldMethod(type, fieldName, "get");
        if (methodName && this[methodName]) {
            this.logInfo("getChildObject calling: " + methodName + "('"+id+"')", "editing");
            return this[methodName](id);
        } else {    
            // if there's no getter method, search the Array directly for something with
            // matching id
            this.logInfo("getChildObject calling getArrayItem('"+id+"',this." + fieldName + ")",
                         "editing");
            return isc.Class.getArrayItem(id, this[fieldName]);
        }
    },

    // get a method that can perform verb "verb" for an object of type "type" being added to a
    // field named "fieldName", eg, "add" (verb) a "Tab" (type) to field "tabs".
    // Uses naming conventions to auto-discover methods.  Subclasses may need to override for
    // non-discoverable methods, eg, canvas.addChild() is not discoverable from the field name
    // ("children") or type ("Canvas").
    getFieldMethod : function (type, fieldName, verb) {
        // NOTE: number of args checks: whether it's an add, remove or get, we're looking for
        // something takes arguments, and we don't want to be fooled by eg Class.getWindow()

        var funcName = verb+type;
        // look for add[type] method, e.g. addTab
        if (isc.isA.Function(this[funcName]) && 
            isc.Func.getArgs(this[funcName]).length > 0) 
        {
            return funcName;
        }

        // look for add[singular form of field name] method, e.g. addMember
        if (fieldName.endsWith("s")) {
            funcName = verb + fieldName.slice(0,-1).toInitialCaps();
            if (isc.isA.Function(this[funcName]) && 
                isc.Func.getArgs(this[funcName]).length > 0)
            {
                return funcName;
            }
        }
    }
});

isc.DataSource.addClassMethods({

    // Given a parent object and child type, use schema to find out what field children
    // of that type are kept under
    // ---------------------------------------------------------------------------------------
    getSchema : function (object) {
        if (isc.isA.Class(object)) return object.getSchema();
        return isc.DS.get(object.schemaName || object._constructor || object.Class);
    },
    getObjectField : function (object, type) {
        if (object == null) return null;
        if (isc.isA.Class(object)) return object.getObjectField(type);

        var schema = isc.DS.getSchema(object);
        if (schema) return schema.getObjectField(type);
    },
    getSchemaField : function (object, fieldName) {
        var schema = isc.DS.getSchema(object);
        if (schema) return schema.getField(fieldName);
    },

    // Add/remove an object to another object, automatically detecting the appropriate field,
    // and calling add/remove functions if they exist on the parent
    // ---------------------------------------------------------------------------------------
    addChildObject : function (parent, newChildType, child, index) {
        return this._doVerbToChild(parent, "add", newChildType, child, index);
    },
    removeChildObject : function (parent, childType, child) {
        return this._doVerbToChild(parent, "remove", childType, child);
    },
    _doVerbToChild : function (parent, verb, childType, child, index) {
        var fieldName = isc.DS.getObjectField(parent, childType);

        if (fieldName == null) {
            this.logWarn("No field for child of type " + childType);
            return false;
        }

        this.logInfo(verb + " object " + this.echoLeaf(child) + 
                     " in field: " + fieldName +
                     " of parentObject: " + this.echoLeaf(parent), "editing");
        var field = isc.DS.getSchemaField(parent, fieldName);

        // if it's a Class, call doVerbToChild on it, which will look for a method that
        // modifies the field
        if (isc.isA.Class(parent)) {
            // if that worked, we're done
            if (parent._doVerbToChild(verb, childType, child, index)) return true;
        }

        // either it's not a Class, or no appropriate method was found, we'll just directly
        // manipulate the properties

        if (!field.multiple) {
            // simple field: "add" is assignment, "remove" is deletion
            if (verb == "add") parent[fieldName] = child;
            else if (verb == "remove") {
                // NOTE: null check avoids creating null slots on no-op removals
                if (parent[fieldName] != null) delete parent[fieldName];
            } else {
                this.logWarn("unrecognized verb: " + verb);
                return false;
            }
            return true;
        }

        this.logInfo("using direct Array manipulation for field '" + fieldName + "'", "editing");

        // Array field: add or remove at index
        var fieldArray = parent[fieldName];
        if (verb == "add") {
            if (fieldArray != null && !isc.isAn.Array(fieldArray)) {
                this.logWarn("unexpected field value: " + this.echoLeaf(fieldArray) +
                             " in field '" + fieldName + 
                             "' when trying to add child: " + this.echoLeaf(child));
                return false;
            }
            if (fieldArray == null) parent[fieldName] = fieldArray = [];
            if (index != null) fieldArray.addAt(child, index);
            else fieldArray.add(child);
        } else if (verb == "remove") {
            if (!isc.isAn.Array(fieldArray)) return false;
            if (index != null) fieldArray.removeAt(child, index);
            else fieldArray.remove(child);
        } else {
            this.logWarn("unrecognized verb: " + verb);
            return false;
        }

        return true;
    },

    getChildObject : function (parent, type, id) {
        if (isc.isA.Class(parent)) return parent.getChildObject(type, id);

        var fieldName = isc.DS.getObjectField(parent, type), 
            field = isc.DS.getSchemaField(parent, fieldName);


        var value = parent[fieldName];
        //this.logWarn("getting type: " + type + " from field: " + fieldName +
        //             ", value is: " + this.echoLeaf(value));
        if (!field.multiple) return value;

        if (!isc.isAn.Array(value)) return null;
        return isc.Class.getArrayItem(id, value);
    },

    // AutoId: field that should have some kind of automatically assigned ID to make the object
    // referenceable in a builder environment
    // ---------------------------------------------------------------------------------------
    getAutoIdField : function (object) {
        var schema = this.getNearestSchema(object);
        return schema ? schema.getAutoIdField() : "ID";
    },

    getAutoId : function (object) {
        var fieldName = this.getAutoIdField(object);
        return fieldName ? object[fieldName] : null;
    }
});

isc.DataSource.addMethods({
    getAutoIdField : function () {
        return this.getInheritedProperty("autoIdField") || "ID";
    },

    // In the Visual Builder, whether a component should be create()d before being added to
    // it's parent.
    // ---------------------------------------------------------------------------------------
    shouldCreateStandalone : function () {
        if (this.createStandalone != null) return this.createStandalone;
        if (!this.superDS()) return true;
        return this.superDS().shouldCreateStandalone();
    }
});



// EditContext
// --------------------------------------------------------------------------------------------

//> @interface EditContext
// An EditContext provides an editing environment for a set of components.
// <P>
// An EditContext is typically populated by adding a series of EditNodes created via a
// +link{Palette}, either via drag and drop creation, when loading from a saved version,
// from a +link{HiddenPalette}.
// <P>
// An EditContext then provides interfaces for further editing of the components represented
// by EditNodes.  
// 
// @group devTools
// @visibility devTools
//<
isc.ClassFactory.defineInterface("EditContext");

// EditNode
// ---------------------------------------------------------------------------------------

//> @object EditNode
// An object representing a component that is currently being edited within an
// +link{EditContext}.
// <P>
// An EditNode is essentially a copy of a +link{PaletteNode}, initially with the same properties
// as the PaletteNode from which it was generated.  However unlike a PaletteNode, an EditNode 
// always has a +link{editNode.liveObject,liveObject} - the object created from the 
// +link{paletteNode.defaults} or other properties defined on a paletteNode.
// <P>
// Like a Palette, an EditContext may use properties such as +link{paletteNode.icon} or 
// +link{paletteNode.title} to display EditNodes.
// <P>
// An EditContext generally offers some means of editing EditNodes and, as edits are made,
// updates +link{editNode.defaults} with the information required to re-create the component.
// 
// @inheritsFrom PaletteNode
// @treeLocation Client Reference/Tools
// @visibility devTools
//<

//> @attr editNode.defaults (Properties : null : IR)
// Properties required to recreate the current +link{editNode.liveObject}.
// @visibility devTools
//<

//> @attr editNode.type (SCClassName : null : IR)
// +link{SCClassName} of the +link{liveObject}, for example, "ListGrid".
// @visibility devTools
//<

//> @attr editNode.liveObject (Object : null : IR)
// Live version of the object created from the +link{editNode.defaults}.  For example, 
// if +link{editNode.type} is "ListGrid", <code>liveObject</code> would be a ListGrid.
// @visibility devTools
//<


//> @attr editNode.editDataSource (DataSource : null : IR)
// DataSource to use when editing the properties of this component.  Defaults to
// +link{editContext.dataSource}, or the DataSource named after the component's type.
//
// @visibility internal
//<





//> @attr EditContext.editDataSource   (DataSource : null : IR)
// Default DataSource to use when editing any component in this context.  Defaults to the
// DataSource named after the component's type.  Can be overriden per-component via
// +link{editedItem.editDataSource}.
//
// @group devTools
//<



isc.EditContext.addInterfaceMethods({
    // wizard handling
    requestLiveObject : function (newNode, callback, palette) {
        var editContext = this;

        // handle deferred nodes (don't load or create their liveObject until they are actually
        // added).  NOTE: arguably the palette should handle this, and makeNewComponent()
        // should be asynchronous in this case.
        if (newNode.loadData && !newNode.isLoaded) {
            newNode.loadData(newNode, function (loadedNode) {
                loadedNode = loadedNode || newNode
                loadedNode.isLoaded = true;
                // preserve the "dropped" flag
                loadedNode.dropped = newNode.dropped;
                editContext.fireCallback(callback, "node", [loadedNode]);
            }, palette);
            return;
        }

        if (newNode.wizardConstructor) {
            this.logWarn("creating wizard");
            var wizard = isc.ClassFactory.newInstance(newNode.wizardConstructor,
                                                      newNode.wizardDefaults);
            wizard.getResults(newNode, function (results) {
                editContext.fireCallback(callback, "node", [results]);
            }, palette);
            return;
        }

        editContext.fireCallback(callback, "node", [newNode]);
    },

    getEditComponents : function () {
        return this.editComponents;
    },
    
    getEditDataSource : function (canvas) {
        return isc.DataSource.getDataSource(canvas.editDataSource || canvas.Class || 
                                            this.editDataSource);
    },

    // fields to edit:
    // - application-specific: two different editing applications may edit the same type of
    //   component (eg a ListViewer) exposing different sets of properties
    //   - the DataSource may not even represent the full set of properties, but regardless,
    //     can act as a default list of fields and reference properties for those fields
    // - on an application-specific basis, should be able to have a base set of fields, plus
    //   additions
    
    // get list of editable fields for a component.  May be a mix of string field names and
    // field objects
    _getEditFields : function (canvas) {
        // combine the baseEditFields and editFields properties
        var fields = [];
        fields.addList(canvas.baseEditFields);
        fields.addList(canvas.editFields);
 
        // HACK: set any explicitly specified fields to be visible, since many fields in the
        // current widget DataSources are set to visible=false to suppress them in editing
        // demos.  If a field is explicitly specified in editFields, we want it to be shown
        // unless they've set "visible" explicitly
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i];
            if (field.visible == null) field.visible = true;
        }

        // if this is an empty list, take all the fields from the DataSource
        if (fields.length == 0) {
            fields = this.getEditDataSource(canvas).getFields();
            fields = isc.getValues(fields);
        }
        return fields;
    },
    
    // get the list of editable fields as an Array of Strings
    getEditFieldsList : function (canvas) {
        var fieldList = [],
            fields = this._getEditFields(canvas);
        // return just the name for any fields specified as objects
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i];
            if (isc.isAn.Object(field)) {
                fieldList.add(field.name);
            } else {
                fieldList.add(field);
            }
        }
        return fieldList;
    },

    // get the edit fields, suitable for passing as "fields" to a dataBinding-aware component
    getEditFields : function (canvas) {
        var fields = this._getEditFields(canvas);
        // make any string fields into objects
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i];
            if (isc.isA.String(field)) field = {name:field};
            // same hack as above to ensure visibility of explicitly specified fields, for
            // fields specified as just Strings
            if (field.visible == null) field.visible = true;
            fields[i] = field;
        }

        return fields;
    },

    // serialize all the components being edited in this editContext
    serializeEditComponents : function () {
        // get all the widgets being edited
        var widgets = this.getEditComponents(),
            output = [];

        if (!widgets) return [];

        for (var i = 0; i < widgets.length; i++) {
            var child = widgets[i].liveObject,
                // get all properties that don't have default value
                props = child.getUniqueProperties(),
                editFields = this.getEditFieldsList(child);

            // add in the Class, which will be needed to recreate the widget, but which could never
            // have non-default value
            props._constructor = child.Class;

            // limit the data to just the fields listed in the DataSource
            props = isc.applyMask(props, editFields);
            
            output.add(props);
        } 
        return output;
    }
});

//> @groupDef devTools
// The SmartClient Tools Framework provides functionality required in layout editors, design
// tools, Integrated Development Environments (IDEs), and similar applications.
//
// @title Tools Framework Overview
// @treeLocation Client Reference/Tools
// @visibility devTools
//<


//> @interface Palette
// An interface that provides the ability to create components from a +link{PaletteNode}.  
//
// @treeLocation Client Reference/Tools
// @group devTools
// @visibility devTools
//<


//> @attr palette.defaultEditContext (EditContext : null : IRW)
// Default EditContext that this palette should use.  Palettes generally create components via
// drag and drop, but may also support creation via double-click or other UI idioms when a
// defaultEditContext is set.
// @visibility external
//<


// providing static methods, but then they couldn't be piece however, making it an inteface
isc.ClassFactory.defineInterface("Palette");

//> @object PaletteNode
// An object representing a component which the user may create dynamically within an
// application.
// <P>
// A PaletteNode expresses visual properties for how the palette will display it (eg
// +link{paletteNode.title,title}, +link{paletteNode.icon,icon}) as well as instructions for
// creating the component the paletteNode represents (+link{paletteNode.type},
// +link{paletteNode.defaults}).
// <P>
// Various types of palettes (+link{ListPalette}, +link{TreePalette}, +link{MenuPalette},
// +link{TilePalette}) render a PaletteNode in different ways, and allow the user to trigger
// creation in different ways (eg drag and drop, or just click).  All share a common pattern
// for how components are created from palettes.
// <P>
// Note that in a TreePalette, a PaletteNode is essentially a +link{TreeNode} and can have
// properties expected for a TreeNode (eg,
// +link{TreeGrid.customIconDropProperty,showDropIcon}.  Likewise
// a PaletteNode in a MenuPalette can have the properties of a +link{MenuItem}, such as
// +link{MenuItem.enableIf}.
// 
// @treeLocation Client Reference/Tools
// @visibility devTools
//<

//> @attr paletteNode.icon (SCImgURL : null : IR)
// Icon for this paletteNode.
//
// @visibility devTools
//<

//> @attr paletteNode.title (String : null : IR)
// Textual title for this paletteNode.
//
// @visibility devTools
//<

//> @attr paletteNode.type (SCClassName : null : IR)
// +link{SCClassName} this paletteNode creates, for example, "ListGrid".
//
// @visibility devTools
//<


//> @attr paletteNode.defaults (Properties : null : IR)
// Defaults for the component to be created from this palette.  
// <P>
// For example, if +link{paletteNode.type} is "ListGrid", properties valid to pass to
// +link{ListGrid.create()}.
//
// @visibility devTools
//<

//> @attr paletteNode.liveObject (Object : null : IR)
// For a paletteNode which should be a "singleton", that is, always provides the exact same
// object (==) rather than a dynamically created copy, provide the singleton object as
// <code>liveObject</code>.
// <P>
// Instead of dynamically creating an object from defaults, the <code>liveObject</code> will
// simply be assigned to +link{editNode.liveObject} for the created editNode.
//
// @visibility devTools
//<

//> @attr paletteNode.wizardConstructor (Object : null : IR)
// A paletteNode that requires user input before component creation can occur 
// may provide a <code>wizardConstructor</code> and +link{wizardDefaults} for the creation of
// a "wizard" component.
// <P>
// Immediately after creation, the wizard will then have the +link{paletteWizard.getResults()}
// method called on it, dynamically produced defaults.
//
// @visibility devTools
//<

//> @attr paletteNode.wizardDefaults (Properties : null : IR)
// Defaults for the wizard created to gather user input before a component is created from
// this PaletteNode.  See +link{wizardConstructor}.
//
// @visibility devTools
//<



// PaletteWizard
// ---------------------------------------------------------------------------------------

//> @interface PaletteWizard
// Interface to be fulfilled by a "wizard" specified on a +link{PaletteNode} via
// +link{paletteNode.wizardConstructor}.
// @visibility devTools
//<

//> @method paletteWizard.getDefaults()
// Single function invoked on paletteWizard.  Expects defaults to be asynchronously returned,
// after user input is complete, by calling the +link{Callback} provided as a parameter.
// 
// @param callback (Callback) callback to be fired once this wizard completes.  Expects a
//                            single argument: the defaults
// @param paletteNode (PaletteNode) the paletteNode that specified this wizard
// @param palette (Palette) palette where creation is taking place
//
// @visibility devTools
//<
isc.Palette.addInterfaceMethods({
    //> @method palette.makeEditNode()
    // Given a +link{PaletteNode}, make an +link{EditNode} from it by creating a 
    // +link{editNode.liveObject,liveObject} from the +link{paletteNode.defaults}
    // and copying presentation properties (eg +link{paletteNode.title,title}
    // to the editNode.
    // @param paletteNode (PaletteNode) paletteNode to create from
    // @return (EditNode) created EditNode
    //
    // @visibility devTools
    //<
    makeEditNode : function (paletteNode) {
       return this.makeNewComponent(paletteNode);
    },
    makeNewComponent : function (sourceData) {
        if (!sourceData) sourceData = this.getDragData();
        if (isc.isAn.Array(sourceData)) sourceData = sourceData[0];
    
        var type = sourceData.className || sourceData.type;

        var componentNode = {
            type : type,
            _constructor : type, // this is here just to match the initData
            // for display in the target Tree
            title : sourceData.title,
            icon : sourceData.icon,
            iconSize : sourceData.iconSize,
            showDropIcon : sourceData.showDropIcon
        };

        // allow a maker function on the source data
        if (sourceData.makeComponent) {
            componentNode.liveObject = sourceData.makeComponent(componentNode);
            return componentNode;
        }

        // NOTE: IDs
        // - singletons may have an ID on the palette node.  
        // - an ID may appear in defaults because palette-based construction is used to reload
        //   views, and in this case the palette node will be used once ever
        var defaults = sourceData.defaults;
        componentNode.ID = sourceData.ID || 
                (defaults ? isc.DS.getAutoId(defaults) : null);

        if (sourceData.loadData) {
            // deferred load node.  No creation happens for now; whoever receives this node is
            // expected to call the loadData function
            componentNode.loadData = sourceData.loadData;
        } else if (sourceData.wizardConstructor) {
            // wizard-based deferred construction
            componentNode.wizardConstructor = sourceData.wizardConstructor;
            componentNode.wizardDefaults = sourceData.wizardDefaults;
        } else if (sourceData.liveObject) {
            // singleton, or already created component.  This means that rather than a new
            // object being instantiated each time, the same "liveObject" should be reused,
            // because multiple components will be accessing a shared object.
            var liveObject = sourceData.liveObject;
            // handle global IDs
            if (isc.isA.String(liveObject)) liveObject = window[liveObject];
            componentNode.liveObject = liveObject
        } else {
            // create a live object from defaults
            componentNode = this.createLiveObject(sourceData, componentNode);
        }
        return componentNode;
    },
    
    //> @attr palette.generateNames   (boolean : true : IR)
    // Whether created components should have their "ID" or "name" property automatically set
    // to a unique value based on the component's type, eg, "ListGrid0".
    //
    // @group devTools
    // @visibility devTools
    //<
    generateNames : true,

    typeCount : {},
    // get an id for the object we're creating, by type
    getNextAutoId : function (type) {
        if (type == null) type = "Object";
        var autoId;
        this.typeCount[type] = this.typeCount[type] || 0;
        while (window[(autoId = type + this.typeCount[type]++)] != null) {}
        return autoId;
    },

    createLiveObject : function (sourceData, componentNode) {

        // put together an initialization data block
        var type = sourceData.className || sourceData.type,
            classObject = isc.ClassFactory.getClass(type),
            schema = isc.DS.getNearestSchema(type),
            initData = {},
            // assume we should create standalone if there's no schema (won't happen anyway if
            // there's no class)
            createStandalone = (schema ? schema.shouldCreateStandalone() : true);

        // suppress drawing for widgets
        if (classObject && classObject.isA("Canvas")) initData.autoDraw = false;

        if (this.generateNames) {
            // generate an id if one wasn't specified
            var ID = componentNode.ID = componentNode.ID || this.getNextAutoId(type);

            // give the object an autoId in initData
            initData[schema.getAutoIdField()] = ID;
    
            // don't supply a title for contexts where the ID or name will automatically be
            // used as a title (currently just formItems), otherwise, it will be necessary to
            // change both ID/name and title to get rid of the auto-gen'd id 
            if (schema && schema.getField("title") && 
                !isc.isA.FormItem(classObject)) initData.title = ID;
        }

        initData = componentNode.initData = 
                componentNode.defaults = // HACK: alias to defaults; only defaults is doc'd
                isc.addProperties(initData,
                                  this.componentDefaults,
                                  sourceData.defaults);
        initData._constructor = type;

        // create the live object from the init data
        // NOTE: components generated from config by parents (tabs, sectionStack sections,
        // formItems).  These objects:
        // - are created as an ISC Class by adding to a parent, and not before
        //   - in makeNewComponent, don't create if there is no class or if the schema sets
        //     createStandalone=false
        // - destroyed by removal from the parent, then re-created by a re-add
        //   - re-add handled by addComponent by checking for destruction
        // - serialized as sub-objects rather than independent components
        //   - handled by checking for _generated during serialization
        //   - should be a default consequence of not having a class or setting
        //     createStandalone=false
        // The various checks mentioned above are redundant and should be unified and make able
        // to be declared in component schema

        // if there's no class for the item, or schema.createStandalone has been set false,
        // don't auto-create the component - assume the future parent of the component will
        // create it from data.  The explicit flag (createStandalone:false) is needed for
        // FormItems.  In particular, canvasItems require item.containerWidget to be defined
        // during init.
        var liveObject;
        if (classObject && createStandalone) {
            liveObject = isc.ClassFactory.newInstance(initData);
        } else {
            // for the live object, just create a copy (NOTE: necessary because widgets
            // generally assume that it is okay to add properties to pseudo-objects provided as
            // init data)
            componentNode.generatedType = true;
            liveObject = isc.clone(initData);
        }

        // store the new live object
        componentNode.liveObject = liveObject;
        this.logInfo("palette created component, type: " + type +
                     ", ID: " + ID +
                     (this.logIsDebugEnabled("editing") ?
                         ", initData: " + this.echo(initData) : "") + 
                     ", liveObject: " + this.echoLeaf(liveObject), "editing");
        return componentNode;
    }
});

//> @class HiddenPallete
// A Pallete with no visible representation that handles programmatic creation of components.
//
// @group devTools
// @treeLocation Client Reference/Tools
// @visibility devTools
//<
isc.defineClass("HiddenPalette", "Class", "Palette");

//> @attr treePalette.componentDefaults    (Object : null : IR)
// Defaults to apply to all components originating from this palette.
// @group devTools
// @visibility devTools
//<


// ---------------------------------------------------------------------------------------

//> @class TreePalette
// A TreeGrid that implements the Palette behavior, so it can be used as the source for 
// drag and drop instantiation of components when combined with an +link{EditContext} as 
// the drop target.
// <P>
// Each +link{TreeNode} within +link{treeGrid.data} can be a +link{PaletteNode}.
// 
// @group devTools
// @treeLocation Client Reference/Tools
// @visibility devTools
//<

// Class will not work without TreeGrid
if (isc.TreeGrid) {

isc.defineClass("TreePalette", "TreeGrid", "Palette").addMethods({
    canDragRecordsOut:true,
    // add to defaultEditContext (if any) on double click 
    recordDoubleClick : function () {
        var target = this.defaultEditContext;
        if (target) {
            if (isc.isA.String(target)) target = isc.Canvas.getById(target);
            if (isc.isAn.EditContext(target)) {
                target.addNode(this.makeNewComponent(this.getDragData()));
            }
        }
    },
    // NOTE: we can't factor this up to the Palette interface because it wouldn't override the
    // built-in implementation of transferDragData.
    transferDragData : function (targetFolder) {
        return [this.makeNewComponent(this.getDragData())];
    }
});

}

// --------------------------------------------------------------------------------------------
//> @class ListPalette
// A ListGrid that implements the +link{Palette} behavior, so it can be used as the source for 
// drag and drop instantiation of components when combined with an +link{EditContext} as 
// the drop target.
// <P>
// Each +link{ListGridRecord} can be a +link{PaletteNode}.
// 
// @group devTools
// @treeLocation Client Reference/Tools
// @visibility devTools
//<

// Class will not work without ListGrid
if (isc.ListGrid) {

isc.defineClass("ListPalette", "ListGrid", "Palette").addMethods({
    canDragRecordsOut:true,
    // add to defaultEditContext (if any) on double click 
    recordDoubleClick : function () {
        // NOTE: dup'd in TreePalette
        var target = this.defaultEditContext;
        if (target) {
            if (isc.isA.String(target)) target = isc.Canvas.getById(target);
            if (isc.isAn.EditContext(target)) {
                target.addNode(this.makeNewComponent(this.getDragData()));
            }
        }
    },
    // NOTE: we can't factor this up to the Palette interface because it wouldn't override the
    // built-in implementation of transferDragData.
    transferDragData : function () {
        return [this.makeNewComponent(this.getDragData())];
    }
});

}

// --------------------------------------------------------------------------------------------
//> @class MenuPalette
// A Menu that implements the +link{Palette} behavior, so it can be used as the source for 
// drag and drop instantiation of components when combined with an +link{EditContext} as 
// the drop target.
// <P>
// Each +link{MenuItem} can be a +link{PaletteNode}.
// 
// @group devTools
// @treeLocation Client Reference/Tools
// @visibility devTools
//<

// Class will not work without Menu
if (isc.Menu) {

isc.defineClass("MenuPalette", "Menu", "Palette").addMethods({
    canDragRecordsOut:true,
    // needed because the selection is what's dragged, and menus do not normally track a
    // selection
    selectionType: "single",
    // add to defaultEditContext (if any) on click 
    itemClick : function (item) {
        var target = this.defaultEditContext;
        if (target) {
            if (isc.isA.String(target)) target = isc.Canvas.getById(target);
            if (isc.isAn.EditContext(target)) {
                target.addNode(this.makeNewComponent(this.getDragData()));
            }
        }
    },

    // NOTE: we can't factor this up to the Palette interface because it wouldn't override the
    // built-in implementation of transferDragData.
    transferDragData : function () {
        return [this.makeNewComponent(this.getDragData())];
    }
});

}




// ---------------------------------------------------------------------------------------

//> @class EditPane
// A container that allows drag and drop instantiation of visual components from a
// +link{Palette}, and direct manipulation of the position and size of those components.
// <P>
// Any drag onto an EditPane from a Palette will add an EditNode created from the dragged
// PaletteNode.
// <P>
// If an EditNode containing a +link{editNode.liveObject,liveObject} that is a subclass
// of Canvas is added to an EditPane,
//
// @group devTools
// @treeLocation Client Reference/Tools
// @visibility devTools
//<
isc.ClassFactory.defineClass("EditPane", "Canvas", "EditContext");

isc.EditPane.addProperties({
    canAcceptDrop:true,
    contextMenu : {
        autoDraw:false,
        data : [{title:"Clear", click: "target.removeAllChildren()"}]
    },

    editingOn:true,

    // drag selection properties
    canDrag:true,
    dragAppearance:"none",
    overflow:"hidden",
    selectedComponents: []

});

isc.EditPane.addMethods({


    // Component creation
    // ---------------------------------------------------------------------------------------
    
    // on drop from a palette, add a new component 
    drop : function () {
        var source = isc.EH.dragTarget;

        // if the source isn't a Palette, do standard drop interaction
        if (!source.isA("Palette")) return this.Super("drop", arguments);
        
        var data = source.transferDragData(),
        editNode = (isc.isAn.Array(data) ? data[0] : data);
        if (!editNode) return false;

        var editContext = this;
        this.requestLiveObject(editNode, function (editNode) {
            if (editNode) editContext.addComponentAtCursor(editNode);
        }, source)
        
        return isc.EH.STOP_BUBBLING;
    },

    //> @method editPane.addNode()
    // Adds a new +link{editNode} to the pane.
    // @param editNode (EditNode) new editNode to add
    //
    // @visibility devTools
    //<
    addNode : function (editNode) {
        return this.addComponent(editNode);
    },

    addComponent : function (component) {
        this.logInfo("EditPane adding component: " + this.echoLeaf(component), "editing");

        if (this.editComponents == null) this.editComponents = [];
        this.editComponents.add(component);

        // add the component as a child
        var liveObject = component.liveObject;
        this.addChild(liveObject);

        // and flip it into editing mode
        if (liveObject.setEditMode) liveObject.setEditMode(true, this);
    },

    // add a new component at the current mouse position
    addComponentAtCursor : function (component) {
        this.addComponent(component);
        var liveObject = component.liveObject;
        liveObject.moveTo(this.getOffsetX(), this.getOffsetY());                
    },

    // Component removal / destruction
    // ---------------------------------------------------------------------------------------
    
    // if a child is removed that is being edited, remove it from the list of edit components
    removeChild : function (child, name) {
        this.Super("removeChild", arguments);
        if (this.editComponents == null) this.editComponents = [];
        this.editComponents.removeWhere("ID", child.getID());
        this.selectedComponents.remove(child);
    },

    removeAllChildren : function () {
        if (!this.children) return;
        var destroyTargets = [];
        for (var i = 0; i < this.children.length; i++) {
            if (this.children[i]._eventMask) destroyTargets.add(this.children[i]);
        }
        for (var i = 0; i < destroyTargets.length; i++) {
            destroyTargets[i].destroy();
        }
    },

    removeSelection : function (target) {
        if (this.selectedComponents.length > 0) {
            while (this.selectedComponents.length > 0) {
                this.selectedComponents[0].destroy();
            }
        } else {
            target.destroy();
        }
    },

    // Thumbs, drag move and resize
    // ---------------------------------------------------------------------------------------

    click : function () { 
        isc.Canvas.hideResizeThumbs(); 
    },

    // enable editing mode for the entire EditPane: turn editing on for all edit components
    setEditMode : function (editingOn) {
        if (editingOn == null) editingOn = true;
        if (this.editingOn == editingOn) return;
        this.editingOn = editingOn;

        var liveObjects = this.editComponents.getProperty("liveObject");
        liveObjects.map("setEditMode", editingOn, this);
    },

    // save new coordinates to initDate on resize or move
    childResized : function (liveObject) {
        var result = this.Super("childResized", arguments);

        this.saveCoordinates(liveObject);

        return result;
    },

    childMoved : function (liveObject, deltaX, deltaY) {
        var result = this.Super("childMoved", arguments);

        this.saveCoordinates(liveObject);

        // if this component is part of a selection, move the rest of the selected
        // components by the same amount   
        var selection = this.selectedComponents;
        if (selection.length > 0 && selection.contains(liveObject)) {
            for (var i = 0; i < selection.length; i++) {
                if (selection[i] != liveObject) {
                    selection[i].moveBy(deltaX, deltaY);
                }
            }
        }

        return result;
    },
    saveCoordinates : function (liveObject) {
        // eg, no components yet, hoop selector moved
        if (!this.editComponents) return;

        //this.logWarn("saveCoordinates for: " + liveObject + 
        //             ", editComponents are: " + this.echoAll(this.editComponents));
        var component = this.editComponents.find("liveObject", liveObject);

        // can happen if we get a resized or moved notification while a component is being
        // added or removed
        if (!component) return; 

        component.initData = isc.addProperties(component.initData, {
            left:liveObject.getLeft(),
            top:liveObject.getTop(),
            width:liveObject.getWidth(),
            height:liveObject.getHeight()
        })
    },
    
    // Serialization
    // ---------------------------------------------------------------------------------------

    //> @method editPane.getSaveData()
    // Returns an Array of +link{PaletteNode}s representing all current +link{EditNodes} in this
    // pane, suitable for saving and restoring via passing each paletteNode to +link{addNode()}.
    // @return (Array of PaletteNode) paletteNodes suitable for saving for subsequent restoration 
    //
    // @visibility devTools
    //<
    getSaveData : function () {
        // get all the components being edited
        var editComponents = this.getEditComponents(),
            allSaveData = [];
        for (var i = 0; i < editComponents.length; i++) {
            var component = editComponents[i],
                liveObject = component.liveObject;
            // save off just types and initialization data, not the live objects themselves
            var saveData = {
                type : component.type,
                defaults : component.defaults
            };
            // let the object customize it
            if (liveObject.getSaveData) saveData = liveObject.getSaveData(saveData);
            allSaveData.add(saveData);
        }
        return allSaveData;
    },

    // Hoop selection
    // --------------------------------------------------------------------------------------------

    // create selector hoop
    mouseDown : function() {
        if (!this.editingOn) return;
        
        var target = isc.EH.getTarget();
        if (this.selector == null) {
            this.selector = isc.Canvas.create({
                autoDraw:false,
                keepInParentRect: true,
                left: isc.EH.getX(),
                top: isc.EH.getY(),
                redrawOnResize:false,
                overflow: "hidden",
                border: "1px solid blue"
            });
            this.addChild(this.selector);
        }
        this.startX = this.getOffsetX();
        this.startY = this.getOffsetY();

        this.resizeSelector();
        this.selector.show();
        this.updateCurrentSelection();
    },

    // resize hoop on dragMove
    dragMove : function() {
        this.resizeSelector();
    },

    // hide selector hoop on mouseUp or dragStop
    mouseUp : function () {
        if (this.selector) this.selector.hide();
    },
    dragStop : function() {
        this.selector.hide();
    },

    outlineBorderStyle : "2px dashed red",
    // add an outline, indicating selection to a set of components
    setOutline : function (components) {
        if (!components) return;
        if (!isc.isAn.Array(components)) components = [components];
        for (var i = 0; i < components.length; i++) {
            components[i]._eventMask.setBorder(this.outlineBorderStyle);
        }
    },

    // clear outline on a set of components
    clearOutline : function (components) {
        if (!components) return;
        if (!isc.isAn.Array(components)) components = [components];
        for (var i = 0; i < components.length; i++) {
            components[i]._eventMask.setBorder("none");
        }
    },

    // figure out which components intersect the selector hoop, and show the selected outline on
    // those
    updateCurrentSelection : function () {
        if (!this.children) return;
        var oldSelection = this.selectedComponents;

        // make a list of all the children which currently intersect the selection hoop
        this.selectedComponents = [];
        for (var i = 0; i < this.children.length; i++) {
            var child = this.children[i];
            if (this.selector.intersects(child)) {
                child = this.deriveSelectedComponent(child);
                if (child && !this.selectedComponents.contains(child)) {
                    this.selectedComponents.add(child);
                }
            }
        }

        // set outline on components currently within the hoop
        this.setOutline(this.selectedComponents);
    
        // de-select anything that is no longer within the hoop
        oldSelection.removeList(this.selectedComponents);
        this.clearOutline(oldSelection);
    
        // show selection in window.status
        
        var selection = this.selectedComponents.getProperty("ID");
        window.status = selection.length ? "Current Selection: " + selection : "";
    },

    // given a child in the editPane, derive the editComponent if there is one
    deriveSelectedComponent : function (comp) {
        // if the component has a master, it's either an editMask or a peer of some editComponent
        if (comp.masterElement) return this.deriveSelectedComponent(comp.masterElement);
        if (!comp.parentElement || comp.parentElement == this) {
            // if it has an event mask, it's an edit component
            if (comp._eventMask) return comp;
            // otherwise it's a mask
            return null;
        }
        // XXX does this case exist?  how can a direct child have a parent element other than its
        // parent?
        return this.deriveSelectedComponent(comp.parentElement);
    },

    // resize selector to current mouse coordinates
    resizeSelector : function () {
        var x = this.getOffsetX(),
            y = this.getOffsetY();

        if (this.selector.keepInParentRect) {
            if (x < 0) x = 0;
            var parentHeight = this.selector.parentElement.getVisibleHeight();
            if (y > parentHeight) y = parentHeight;
        }
    
        // resize to the distances from the start coordinates
        this.selector.resizeTo(Math.abs(x-this.startX), Math.abs(y-this.startY));

        // if we are above/left of the origin set top/left to current mouse coordinates,
        // otherwise to start coordinates.
        if (x < this.startX) this.selector.setLeft(x);
        else this.selector.setLeft(this.startX);

        if (y < this.startY) this.selector.setTop(y);
        else this.selector.setTop(this.startY);

        // figure out which components are now in the selector hoop
        this.updateCurrentSelection();
    },
    
    // external, safe getter for selected components
    getSelectedComponents : function () {
        return this.selectedComponents.duplicate()
    }

});

//> @class EditTree
// A TreeGrid that allows drag and drop creation and manipulation of a tree of 
// object sdescribed by DataSources.  
// <P>
// Nodes can be added via drag and drop from a +link{Palette} or may be programmatically 
// added via +link{editTree.addComponent()}.  Nodes may be dragged within the tree to reparent 
// them.
// <P>
// Eligibility to be dropped on any given node is determined by inspecting the
// DataSource of the parent node.  Drop is allowed only if the parent schema has
// a field which accepts the type of the dropped node.
// <P>
// On successful drop, the newly created component will be added to the parent node under the
// detected field.  Array fields, declared by setting
// <code>dataSourceField.multiple:true</code>, are supported.  
// <P>
// An EditTree is initialized by setting +link{EditTree.rootComponent}.  EditTree.data (the
// Tree instance) should never be directly set or looked at.
//
// @treeLocation Client Reference/Tools
// @group devTools
// @visibility devTools
//<



// Class will not work without TreeGrid
if (isc.TreeGrid) {

isc.ClassFactory.defineClass("EditTree", "TreeGrid", "EditContext");

isc.EditTree.addProperties({
    //> @attr EditTree.rootComponent    (Object : null : IR)
    // Root of data to edit.  Must contain the "_constructor" property, with the name of a
    // valid +link{DataSource,schema} or nothing will be able to be dropped on the this
    // EditTree.
    // <P>
    // Can be retrieved at any time.
    //
    // @group devTools
    // @visibility devTools
    //<

    canDragRecordsOut: false,
	canAcceptDroppedRecords: true,
    canReorderRecords: true,

	fields:[
	    {name:"ID", title:"ID", width:"*"},
	    {name:"type", title:"Type", width:"*"}
	],

	selectionType:isc.Selection.SINGLE,

    // whether to automatically show parents of an added node (if applicable)
    autoShowParents:true
});

isc.EditTree.addMethods({

    initWidget : function () {
        this.Super("initWidget", arguments);
        // NOTE: there really is no reasonable default for rootComponent, since its type
        // determines what can be dropped.  This default will create a tree that won't accept
        // any drops, but won't JS error
        var rootComponent = this.rootComponent || { _constructor: "Object" }, 
            rootType = isc.isA.Class(rootComponent) ? rootComponent.Class :
                                                      rootComponent._constructor,
            rootLiveObject = this.rootLiveObject || rootComponent;
        var rootNode = {
            type: rootType,
            _constructor: rootType,
            initData : rootComponent,
            liveObject: rootLiveObject
        };
        this.setData(isc.Tree.create({
            idField:"ID",
            root : rootNode,
            // HACK: so that all nodes can be targetted for D&D
            isFolder : function () { return true; }
        }));
    },

    // Adding / Removing components in the tree
	// --------------------------------------------------------------------------------------------

    // tests whether the targetNode can accept a newNode of type "type"
    canAddToParent : function (targetNode, type) {
        var liveObject = targetNode.liveObject;
        if (isc.isA.Class(liveObject)) {
            return (liveObject.getObjectField(type) != null);
        }
        // still required for MenuItems, where the live object is not a Class
        return (isc.DS.getObjectField(targetNode, type) != null);
    },

    willAcceptDrop : function () {
        if (!this.Super("willAcceptDrop",arguments)) return false;

	    var recordNum = this.getEventRow(),
		    dropTarget = this.getDropFolder(),
            dragData = this.ns.EH.dragTarget.getDragData()
        ;

        if (dragData == null) return false;
        if (dropTarget == null) dropTarget = this.data.getRoot();

        if (isc.isAn.Array(dragData)) dragData = dragData[0];
        var dragType = dragData.className || dragData.type;

        this.logInfo("checking dragType: " + dragType + 
                     " against dropLiveObject: " + dropTarget.liveObject, "editing");

        return this.canAddToParent(dropTarget, dragType)
    },

    folderDrop : function (nodes, parent, index, sourceWidget) {
        if (sourceWidget != this && !sourceWidget.isA("Palette")) {
            // if the source isn't a Palette, do standard drop interaction
            return this.Super("folderDrop", arguments);
        }

        if (sourceWidget != this) {
            // this causes component creation since the drop is from a Palette
            nodes = sourceWidget.transferDragData();
        }

        var newNode = (isc.isAn.Array(nodes) ? nodes[0] : nodes);

        // flag that this node was dropped by a user
        newNode.dropped = true;

        this.logInfo("sourceWidget is a Palette, dropped node of type: " + newNode.type,
                     " editing");

        var editTree = this;
        this.requestLiveObject(newNode, function (node) {
            if (node == null) return;
            // self-drop: remove component from old location before re-adding
            if (sourceWidget == editTree) editTree.removeComponent(newNode, parent, index);
            editTree.addComponent(node, parent, index);
        }, sourceWidget)
    },

    //> @method editTree.addNode()
    // Add a new +link{EditNode} to the tree, under the specified parent.
    // <P>
    // The EditTree will interrogate the parent and new nodes to determine what field 
    // within the parent allows a child of this type, and to find a method to add the newNode's 
    // liveObject to the parentNode's liveObject.  The new relationship will then be stored
    // in the +link{editNode.defaults} of the parentNode.
    // <P>
    // For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as
    // the correct target field via naming conventions, and the method TabSet.addTab() is likewise 
    // discovered as the correct method to add a Tab to a TabSet.
    //
    // @param newNode (EditNode) new node to be added
    // @param parentNode (EditNode) parent to add the new node under
    // @param index (integer) index within the parent's children array
    // @visibility devTools
    //<
    addNode : function (newNode, parentNode, index) {
        return this.addComponent(newNode, parentNode, index);
    },
    addComponent : function (newNode, parentNode, index) {

        if (parentNode == null) parentNode = this.getDefaultParent(newNode);

        var liveParent = this.getLiveObject(parentNode);
        this.logInfo("addComponent will add newNode of type: " + newNode.type + 
                     " to: " + this.echoLeaf(liveParent), "editing");

        // find what field in the parent can accomodate a child of this type
        var fieldName = isc.DS.getObjectField(liveParent, newNode.type),
            field = isc.DS.getSchemaField(liveParent, fieldName);

        if (!field) {
            this.logWarn("can't addComponent: can't find a field in parent: " + liveParent +
                         " for a new child of type: " + newNode.type + ", newNode is: " +
                         this.echo(newNode));
            return;
        }

        // for a singular field (eg listGrid.dataSource), remove the old node first
        if (!field.multiple) {
            var existingChild = isc.DS.getChildObject(liveParent, newNode.type);
            if (existingChild) {
                var existingChildNode =
                    this.data.getChildren(parentNode).find("ID", isc.DS.getAutoId(existingChild));
                this.logWarn("destroying existing child: " + this.echoLeaf(existingChild) +
                             " in singular field: " + fieldName);
                this.data.remove(existingChildNode);
                if (isc.isA.Class(existingChild) && 
                    !isc.isA.DataSource(existingChild)) existingChild.destroy();
            }
        }

        // NOTE: generated components and remove/add cycles: some widgets convert config
        // objects into live objects (eg formItem properties to live FormItem, tab -> ImgTab,
        // section -> SectionHeader, etc).  When we are doing an add/remove cycle for these
        // kinds of generated objects:
        // - rebuild based on initData, rather than trying to re-add the liveObject, which will
        //   be a generated component that the parent will have destroyed
        // - preserve Canvas children of the generated component, such as tab.pane,
        //   section.items, which have not been added to the initData.  We do this by using
        //   part of the serialization logic (addChildData)
        // - ensure removal of the tab, item, or section does not destroy these Canvas children
        //   (a special flag is passed to at least TabSets to avoid this)

        // Optimization for add/remove cycles: check for methods like "reorderMember" first.
        // Note this doesn't remove the complexity discussed above because a generated
        // component might be moved between two parents.
        var childObject;
        if (newNode.generatedType) {
            // copy to avoid property scribbling that is currently done by TabSets and
            // SectionStacks at least
            childObject = isc.addProperties({}, newNode.initData);
            this.addChildData(childObject, this.data.getChildren(newNode));
        } else {
            childObject = newNode.liveObject;
        }

        var result = isc.DS.addChildObject(liveParent, newNode.type, childObject, index);
        if (!result) {
            this.logWarn("addChildObject failed, returning");
            return;
        }

        // fetch the liveObject back from the parent to handle it's possible conversion from
        // just properties to a live instance.
        // NOTE: fetch object by ID, not index, since on a reorder when a node is dropped after
        // itself the index is one too high
        newNode.liveObject = isc.DS.getChildObject(liveParent, newNode.type, 
                                                   isc.DS.getAutoId(newNode.initData));

        this.logDebug("for new node: " + this.echoLeaf(newNode) + 
                      " liveObject is now: " + this.echoLeaf(newNode.liveObject),
                      "editing");

        if (newNode.liveObject == null) {
            this.logWarn("wasn't able to retrieve live object after adding node of type: " +
                         newNode.type + " to liveParent: " + liveParent + 
                         ", does liveParent have an appropriate getter() method?");
        }

        // add the node representing the component to the project tree
        this.data.add(newNode, parentNode, index);
        // gets rid of the spurious opener icon that appears because all nodes are regarded as
        // folders and dropped node is unloaded, hence might have children
        this.data.openFolder(newNode);

        this.logInfo("added node " + this.echoLeaf(newNode) + 
                     " to EditTree at path: " + this.getData().getPath(newNode) + 
                     " with live object: " + this.echoLeaf(newNode.liveObject), "editing");
        this.selection.selectSingle(newNode);

        if (this.autoShowParents) this.showParents(newNode);

        return newNode;
	},

    // for a node being added without a parent, find a plausible default node to add to.
    // In combination with palette.defaultEditContext, allows double-click (tree, list
    // palettes) as an alternative to drag and drop.
    getDefaultParent : function (newNode) {
        // rules:
        // Start with the selected node. We select on drop / create, so this is typically
        // the last added node, but the user can select something else to take control of
        // where the double-click add goes
        // If this node accepts this type as a child, use that.
        // - handles most layout nesting, DataSource for last form, etc
        // Otherwise, go up hierarchy from this node
        // - handles a series of components that should not nest being placed adjacent instead,
        //   eg ListGrid then DynamicForm
        var type = newNode.className || newNode.type,
            node = this.getSelectedRecord();
        
        while (node && !this.canAddToParent(node, type)) node = this.data.getParent(node);

        return node || this.data.getRoot();
    },
    
    // alternative to just using node.liveObject
    // exists because forms used to rebuild *all* items when any single item is added, hence
    // making the liveObject stale for siblings of an added item
    getLiveObject : function (node) {
        var parentNode = this.data.getParent(node);
        // at root, just use the cached liveObject (a formItem can never be at root)
        if (parentNode == null) return node.liveObject; 

        var liveParent = parentNode.liveObject;
        return node.liveObject = isc.DS.getChildObject(liveParent, node.type, 
                                                       isc.DS.getAutoId(node));
    },

    // remove all components in the tree
    removeAll : function () {
        var rootChildren = this.data.getChildren(this.data.getRoot()).duplicate()
        for (var i = 0; i < rootChildren.length; i++) {
            this.removeComponent(rootChildren[i]);
        }
    },

    // remove a component from the tree
    removeComponent : function (node) {
        // remove the node from the tree
        this.data.remove(node);

        // remove the corresponding component from the object model
        var parentNode = this.data.getParent(node),
            liveParent = this.getLiveObject(parentNode),
            liveChild = this.getLiveObject(node);

        //this.logWarn("removing with initData: " + this.echo(node.initData));

        isc.DS.removeChildObject(liveParent, node.type, liveChild);
    },

    // destroy a component in the tree
    destroyComponent : function (node) {
        this.removeComponent(node);
        var liveObject = this.getLiveObject(node);
        // if it has a destroy function, call it.  Otherwise we assume garbage collection will
        // work
        if (liveObject.destroy) liveObject.destroy();
    },

    // give a newNode, ensure all of it's parents are visible
    showParents : function (newNode) {
        // if something is dropped under a tab, ensure that tab gets selected
        var parents = this.data.getParents(newNode), 
            tabNodes = parents.findAll("type", "Tab");
        //this.logWarn("detected tab parents: " + tabNodes);
        if (tabNodes) {
            for (var i = 0; i < tabNodes.length; i++) {
                var tabNode = tabNodes[i],
                    tabSetNode = this.data.getParent(tabNode),
                    tab = this.getLiveObject(tabNode),
                    tabSet = this.getLiveObject(tabSetNode);
                tabSet.selectTab(tab);
            }
        }
    },

    // Serializing
	// --------------------------------------------------------------------------------------------
 
    // we flatten the Tree of objects into a flat list of top-level items to serialize.
    // Nesting (eg grid within Layout) is accomplished by having the Layout refer to the grid's
    // ID.
    serializeComponents : function (serverless, includeRoot) {
        var output = isc.SB.create();

        this.serverless = serverless;

        var topNodes = includeRoot ? 
                [this.data.root] : this.data.getChildren(this.data.root).duplicate();

        // add autoDraw to all non-hidden top-level components
        for (var i = 0; i < topNodes.length; i++) {
            var topNode = topNodes[i] = isc.addProperties({}, topNodes[i]),
                iscClass = isc.ClassFactory.getClass(topNode.type),
                initData = topNode.initData = isc.addProperties({}, topNode.initData);
    
            //this.logWarn("considering node: " + this.echo(topNode) +
            //             " with initData: " + this.echo(initData));
            if (iscClass && iscClass.isA("Canvas") && initData && 
                initData.visibility != isc.Canvas.HIDDEN) 
            {
                initData.autoDraw = true;
            }
        }

        this.saveNodes = [];
        this.map("getSerializeableTree", topNodes);
        isc.Comm.omitXSI = true;
        for (var i = 0; i < this.saveNodes.length; i++) {
            var node = this.saveNodes[i],
                schema = isc.DS.getNearestSchema(node);
            output.append(schema.xmlSerialize(node), "\n\n");
        }
        isc.Comm.omitXSI = null;

        this.serverless = null;

        return output.toString();
    },

    // arrange the initialization data into a structure suitable for XML serialization
    getSerializeableTree : function (node, dontAddGlobally) {
        var type = node.type,
            // copy initData for possible modification
            initData = isc.addProperties({}, node.initData);   
        // if this node is a DataSource (or subclass of DataSource)
        var classObj = isc.ClassFactory.getClass(type);

        this.logWarn("node: " + this.echoLeaf(node) + " with type: " + type);

        if (classObj && classObj.isA("DataSource")) {
            // check for this same DataSource already being saved out
            if (this.saveNodes) {
                var existingDS = this.saveNodes.find("ID", initData.ID) ||
                                 this.saveNodes.find("loadID", initData.ID);
                if (existingDS && existingDS.$schemaId == "DataSource") return;
            }

            if (!this.serverless) {
                // when serializing a DataSource, just output the loadID tag so that the
                // server outputs the full definition during XML processing on JSP load
                initData = { _constructor:"DataSource", 
                             $schemaId : "DataSource", 
                             loadID : initData.ID };
            } else {
                // if running serverless, we can't rely on the server to fetch the definition
                // as part of XML processing during JSP load, so we have to write out a full
                // definition.  This works only for DataSources that don't require the server
                // to fetch and update data.
                // NOTE: since all DataSources in Visual Builder are always saved to the
                // server, an alternative approach would be to load the DataSource and capture
                // its initData, as we do when we edit an existing DataSource.  However we
                // would still depend on getSerializeableFields() being correct, as we also use
                // it to obtain clean data when we begin editing a dynamically created
                // DataSource obtained from XML Schema (eg SFDataSource)
                var liveDS = node.liveObject;
                initData = liveDS.getSerializeableFields();
                initData._constructor = liveDS.Class;
                initData.$schemaId = "DataSource";
            }
        }
        
        // Actions
        // By default these will be defined as simple objects in JS, but for saving in XML 
        // we need to enclose them in <Action>...</Action> tags
        // (ensures that any specified mappings are rendered out as an array)
        // Catch these cases and store as a StringMethod object rather than the raw action
        // object - this will serialize correctly.
        this.convertActions(node, initData, classObj);
        
        var treeChildren = this.data.getChildren(node);
        if (!treeChildren) {
            if (this.saveNodes) this.saveNodes.add(initData); // add as a top-level node
            return;
        }

        this.addChildData(initData, treeChildren);
            
        // if we're not supposed to be global, return out initData
        if (dontAddGlobally) return initData;
        // otherwise add this node's data globally (we list top-most parents last)
        if (this.saveNodes) this.saveNodes.add(initData);
    },

    addChildData : function (parentData, childNodes) {
        var ds = isc.DS.get(parentData._constructor);
        for (var i = 0; i < childNodes.length; i++) {
            var child = childNodes[i],
                childType = child.initData._constructor,
                // copy initData for possible modification
                childData = isc.addProperties({}, child.initData),
                parentFieldName = ds.getObjectField(childType),
                parentField = ds.getField(parentFieldName);

            this.logInfo("serializing: child of type: " + childType + 
                         " goes in parent field: " + parentFieldName,
                         "editing");

            // all Canvii output individually, and their parents just output the Canvas ID.
            // NOTE: don't do this for _generated components, which include TabSet tabs and
            // SectionStack sections.
            if ((isc.isA.Canvas(child.liveObject) && !child.liveObject._generated) || 
                isc.isA.DataSource(child.liveObject)) 
            {
                childData = childData.ID;
                this.getSerializeableTree(child);
            } else {
                // otherwise, serialize this child without adding it globally
                childData = this.getSerializeableTree(child, true);
            }

            var existingValue = parentData[parentFieldName];
            if (parentField.multiple) {
                // force multiple fields to Arrays
                if (!existingValue) existingValue = parentData[parentFieldName] = [];
                existingValue.add(childData);
            } else {
                parentData[parentFieldName] = childData;
            }
        }
    },
    
    convertActions : function (node, initData, classObj) {
        
        // Convert actions defined as a raw object to StringMethods so they can be
        // serialized correctly.
        
        // This is a bit of a pain to achieve as there's nothing in the component's initData 
        // that makes it clear that this is a StringMethod object rather than some other 
        // simple object and there are no dataSource field definitions for most stringMethods
        // - We could examine the registered stringMethod for the class, but this wouldn't
        //   work for non instance object fields, such as stringMethods on ListGridFields
        // - We could just examine the object - if it's a valid format (has target, name attrs)
        //   we could assume it's an action - but this would catch false positives in some 
        //   cases
        // For now - look at the value on the live-instance and see if it's a function produced
        // from an Action (check for function.iscAction).
        // This will work as long as the live-object has actually been instantiated (may not be
        // a valid test in all cases - EG anything that's lazily created on draw or when called
        // may not yet have converted it to a function).
        
        for (var field in initData) {
            var value = initData[field];
            // if it's not an object or is already a StringMethod no need to convert to one
            if (!isc.isAn.Object(value) || isc.isA.StringMethod(value)) continue;
            
            // If it has a specified field-type, other than StringMethod - we don't need 
            // to convert
            // Note: type Action doesn't need conversion to a StringMethod as when we serialize
            // to XML, the ActionDataSource will do the right thing
            var fieldType;
            if (classObj.getField) fieldType = classObj.getField(field).type;
            if (fieldType && (fieldType != "StringMethod")) continue;
            
            var liveValue = node.liveObject[field],
                liveAction = liveValue ? liveValue.iscAction : null,
                convertToSM
            ;
            if (liveAction) convertToSM = true;
            /*
            // We could add a sanity check that the value will convert to a function successfully
            // in case a function has been added since init or something.
            try {
                isc.Func.expressionToFunction("", initData[field]);
            } catch (e) {
                convertToSM = false;
            }
            */
            if (convertToSM) initData[field] = isc.StringMethod.create({value:value});
        }
        // no need to return anything we've modified the initData object directly.
    }
    

});

//> @groupDef visualBuilder
// The SmartClient Visual Builder tool, accessible from the SDK Explorer as Tools->Visual
// Builder, is intended for:
// <ul>
// <li> business analysts and others doing functional application design, who want to create
// functional prototypes in a codeless, "what you see is what you get" environment
// <li> developers new to SmartClient who want to get a basic familiarity with component
// layout, component properties and SmartClient code structure
// <li> developers building simple applications that can be completed entirely within Visual
// Builder
// </ul>
// <P>
// <h4>Using Visual Builder</h4>
// <P>
// Basic usage instructions are embedded in Visual Builder itself, in the "About Visual
// Builder" pane.  Click on it to open it.
// <P>
// <b>Visual Builder for Functional Design</b>
// <P>
// Visual Builder has several advantages over other tools typically used for functional design:
// <ul>
// <li> Visual Builder allows simple drag and drop manipulation of components, form-based
// editing of component properties, and simple connection of events to actions - all without
// requiring any code to be written.  It is actually simpler to use than
// DreamWeaver or other code-oriented prototyping tools
// <li> because Visual Builder generates clean code, designs will not have to be converted to
// another technology before development can proceed.  This reduces both effort and the
// potential for miscommunication
// <li> developers can add custom skinning, components with custom behaviors, and custom
// DataSources with sample datasets to Visual Builder so that the design environment is an even
// closer match to the final application.  This helps eliminate many types of unimplementable
// designs 
// <li> because Visual Builder is built in SmartClient itself, Visual Builder is simply a 
// web page, and does not require installation.  Visual Builder can be deployed to 
// an internal network to allow teams with a mixture of technical and semi-technical 
// users to collaboratively build and share prototypes of SmartClient-based applications.  
// </ul>
// <P>
// <b>Loading and Saving</b>
// <P>
// The "File" menu within Visual Builder allows screens to be saved and reloaded for further
// editing.  Saved screens <b>can</b> be edited outside of Visual Builder and successfully
// reloaded, however, as with any design tool that provides a drag and drop, dialog-driven
// approach to screen creation, Visual Builder cannot work with entirely free-form code.  In
// particular, when a screen is loaded and then re-saved:
// <ul>
// <li> any indenting or spacing changes are not preserved 
// <li> order of property or method defintions will revert to Visual Builder's default
// <li> while method definitions on components are preserved, any code <b>outside of</b>
//      component definitions will be dropped (in some cases adding such code will cause
//      loading to fail)
// <li> each Canvas-based component will be output separately, in the order these components
//      appear in the project tree, deepest first
// </ul>
// Generally speaking, screen definitions that you edit within Visual Builder should consist of
// purely declarative code.  Rather than appearing in screen definitions, custom components and
// JavaScript libraries should be added to Visual Builder itself via the customization
// facilities described below.
// <P>
// <h4>Customizing Visual Builder</h4>
// <P>
// The rest of this topic focuses on how Visual Builder can be customized and deployed by
// developers to make it more effective as a functional design tool for a particular
// organization.
// <P>
// <b>Adding Custom DataSources to Visual Builder</b>
// <P>
// DataSources placed in the project dataSources directory ([webroot]/shared/ds by default)
// will be detected by Visual Builder whenever it is started, and appear in the DataSource
// listing in the lower right-hand corner automatically.
// <P>
// If you have created a custom subclass of DataSource (eg, as a base class for several
// DataSources that contact the same web service), you can use it with Visual Builder by:
// <ul>
// <li> creating an XML version of the DataSource using the XML tag &lt;DataSource&gt; and the
// <code>constructor</code> property set to the name of your custom DataSource subclass (as
// described +link{group:componentXML} under the heading <i>Custom Components</i>)
// <li> modifying [webroot]/tools/visualBuilder/globalDependencies.xml to load the JavaScript
// code for your custom DataSource class.  See examples in that file.
// </ul>
// <P>
// <b>Adding Custom Components to Visual Builder</b>
// <P>
// The Component Library on the right hand side of Visual Builder loads component definitions
// from two XML files in the [webroot]/tools/visualBuilder directory: customComponents.xml and
// defaultComponents.xml.  customComponents.xml is empty and is intended for developers to add
// their own components.  defaultComponents.xml can also be customized, but the base version
// will change between SmartClient releases.
// <P>
// As can be seen by looking at defaultComponents.xml, components are specified using a tree
// structure similar to that shown in the 
// +explorerExample{treeLoadXML,tree XML loading example}.  The properties that can be set on
// nodes are:
// <ul>
// <li> <code>className</code>: name of the SmartClient Class on which +link{Class.create,create()} will be
// called in order to construct the component.  <code>className</code> can be omitted to create
// a folder that cannot be dropped
// <li> <code>title</code>: title for the node
// <li> <code>defaults</code>: an Object specifying defaults to be passed to
// +link{Class.create,create()}.
// For example, you could add an "EditableGrid" node by using <code>className:"ListGrid"</code>
// and specifying:
// <pre>
// &lt;defaults canEdit="true"/&gt;</pre>
// NOTE: if you set any defaults that are not Canvas properties, you need to provide explicit
// type as documented under <i>Custom Properties</i> for +link{group:componentXML}.
// <li> <code>children</code>: components that should appear as children in the tree under this
// node
// <li> <code>icon</code>: icon to show in the Visual Builder component tree (if desired)
// <li> <code>iconWidth/Height/Size</code>: dimensions of the icon in pixels ("iconSize" sets
// both)
// <li> <code>showDropIcon</code>: for components that allow children, whether to show a
// special drop icon on valid drop (like +link{treeGrid.showDropIcons}).
// </ul>
// <P>
// In order to use custom classes in Visual Builder, you must modify
// <code>[webroot]/tools/visualBuilder/globalDependences.xml</code> to include:
// <ul>
// <li> the JavaScript class definition for the custom class (in other words, the
// +link{isc.defineClass(),defineClass()} call)
// <li> a +link{group:componentSchema,component schema} for the custom component
// </ul>
// See globalDependencies.xml for examples.
// <P>
// <h4>Component Schema and Visual Builder</h4>
// <P>
// When you provide +link{group:componentSchema,custom schema} for a component, Visual Builder
// uses that schema to drive component editing (Component Properties pane) and to drive drag
// and drop screen building functionality.
// <P>
// <b>Component Editing</b>
// <P>
// Newly declared fields will appear in the Component Editor in the "Other" category at the
// bottom by default.  You can create your own category by simply setting field.group to the
// name of a new group and using this on multiple custom fields.
// <P>
// The ComponentEditor will pick a FormItem for a custom field by the
// +link{type:FormItemType,same rules} used for ordinary databinding, including the ability to
// set field.editorType to use a custom FormItem.
// <P>
// When the "Apply" button is clicked, Visual Builder will look for an appropriate "setter
// function" for the custom field, for example, for a field named "myProp", Visual Builder will
// look for "setMyProp".  The target component will also be +link{canvas.redraw,redrawn}.
// <P>
// <b>Event -&gt; Action Bindings</b>
// <P>
// The Component Properties pane contains an Events tab that allows you wire components events
// to actions on any other component currently in the project.
// <P>
// Events are simply +link{group:stringMethods,StringMethods} defined on the component.  In
// order to be considered events, method definitions must have been added to the class via
// +link{Class.registerStringMethods} and either be publicly documented SmartClient methods or,
// for custom classes, have a methods definition in the +link{group:componentSchema,component
// schema}.
// Examples of events are: +link{listGrid.recordClick} and +link{dynamicForm.itemChange}.
// <P>
// Actions are methods on any component that have a method definition in the
// +link{group:componentSchema,component schema} and specify action="true".
// <P>
// All available events (stringMethods) on a component are shown in the Events tab of the
// Component Editor.  Clicking the plus (+) sign next to the event name brings up a menu that
// shows a list of all components currently in the project and their available actions.
// Selecting an action from this submenu binds the action to the selected event.  When an event
// is bound to an action in this manner, automatic type matching is performed to pass arguments
// from the event to the action as follows:
// <ul>
// <li>Only non-optional parameters of the action are bound.
// <li>For each non-optional parameter of the action method, every parameter of the
// event method is inspected in order to either directly match the type (for non-object types)
// or to match an isAssignableFrom type check via a SmartClient schema inheritance check.
// <li>The 'type' of a parameter is determined from the type documented in the SmartClient
// reference for built-in components, or from the <code>type</code> atribute on the method
// param in the +link{group:componentSchema,component schema} definition of a custom component.
// <li>When a matching parameter is found, it is assigned to the current slot of the action and
// not considered for further parameter matching.
// <li>The above pattern is repeated until all non-optional parameters are exhausted, all
// event parameters are exhausted, or until no further type matches can be inferred.
// </ul>
// The "actionBinding" log category can be enabled in the Developer Console to troubleshoot
// issues with automatic binding for custom methods.
// <P>
// <b>Component Drag and Drop</b>
// <P>
// Visual Builder uses component schema to determine whether a given drop is allowed and what
// methods should be called to accomplish the drop.  For example, any Canvas-based component
// can be dropped on a VLayout because VLayout has a "members" field of type "Canvas", and an 
// +link{Layout.addMember,addMember()} function.
// <P>
// Because of these rules, any subclass of Canvas will be automatically eligable to be dropped
// into any container that accepts a Canvas (eg, a Layout or Tab).  Any subclass of a FormItem
// will be, likewise, automatically eligible to be dropped into a DynamicForm.
// <P>
// You can declare custom containment relations, such as a custom class "Wizard" that accepts
// instances of the custom class "Pane" by simply declaring a
// +link{group:componentSchema,component schema} that says that Wizard has a property called
// "panes" of type "Pane".  Then, provide methods that allow components to be added and removed:
// <ul>
// <li> for a +link{dataSourceField.multiple,multiple} field, provide "add" and "remove"
// functions based on the name of the field.  For example, for a field "panes" of type "Pane",
// provide "addPane()" that takes a Pane instance, and "removePane()" that takes a pane
// instance or pane ID 
// <li> for a singular field (such as +link{Canvas.contextMenu} or +link{Tab.pane}), provide a
// setter method named after the field (eg setContextMenu()) that takes either an instance of
// the component or null for removal
// </ul>
// <P>
// The "editing" log category can be enabled in the Developer Console to troubleshoot issues
// with schema-driven drag and drop and automatic lookup of getter/setter and adder/remover
// methods.
// <P>
// <B>NOTE:</B> after modifying component schema, it may be necessary to restart the servlet
// engine and reload Visual Builder
// <P>
// <b>Presenting simplified components</b>
// <P>
// SmartClient components expose many methods and properties.  For some environments, it is
// more appropriate to provide a simplified list of properties, events, and actions on either
// built-in SmartClient components or your custom components.  This can be done by providing a
// custom +link{group:componentSchema,component schema} for an existing component that exposes
// your minimal set.  You also need to provide a trivial subclass of the class you're exposing
// so that it can be instantiated.
// <P>
// For example, let's say you want to make a simplified button called EButton that exposes only
// the 'title' property and the 'click' event of a standard Button.  The following steps will
// accomplish this:
// <p>
// 1. Edit /tools/visualBuilder/customComponents.xml and add a block similar to the following
// to make your custom component appear in the Component Library:
// <pre>
// &lt;PaletteNode&gt;
//     &lt;title&gt;EButton&lt;/title&gt;
//     &lt;className&gt;EButton&lt;/className&gt;
//     &lt;icon&gt;button.gif&lt;/icon&gt;
// &lt;/PaletteNode&gt;
// </pre>
// 2. Next, create a custom schema: /isomorphic/system/schema/EButton.ds.xml as follows:
// <pre>
// &lt;DataSource ID="EButton" inheritsFrom="Button" Constructor="EButton"
//             showLocalFieldsOnly="true" showSuperClassActions="false"
//             showSuperClassEvents="false"&gt;
// 	   &lt;fields&gt;
//         &lt;field name="title"  type="HTML"/&gt;
//     &lt;/fields&gt;
//     &lt;methods&gt;
//         &lt;method name="click"&gt;
//             &lt;description&gt;Fires when this button is clicked.&lt;/description&gt;
//         &lt;/method&gt;
//     &lt;/methods&gt;
// &lt;/DataSource&gt;
// </pre>
// See documentation above and also +link{group:componentSchema,component schema} for what the
// properties above do.
// 3.  Finally, you'll need to define an EButton class as a simple subclass of Button, as
// follows:
// <pre>
// isc.defineClass("EButton", "Button");
// </pre>
// To make sure that the Visual Builder will load the above definition, you'll need to place it
// into a JavaScript file being loaded by the Visual Builder.  If you do not already have
// such a file, you can create one and add it to the list of Visual Builder dependencies by
// adding an entry in /tools/visualBuilder/globalDependencies.xml.  See examples in that file
// for specifics.
// <P>
// <h4>Deploying Visual Builder for Functional Designers</h4>
// <P>
// The normal +link{group:iscInstall} deployment instructions apply to Visual Builder <b>except
// that</b> the "BuiltinRPCs", which are configured via server.properties, must be enabled
// in order for Visual Builder to load and save files to the SmartClient server.  This also
// means that Visual Builder should only be deployed within trusted environments.  
// <P>
// Note that the Visual Builder provides a "live" interface to the provided DataSources.  In
// other words, if a DataSource supports saving and a designer enables inline editing in a grid,
// real saves will be initiated.  The Visual Builder tool should be configured to use the same
// sample data that developers use during development.
//
//
// @treeLocation Concepts
// @title Visual Builder
// @visibility external
//<

} // end if (isc.TreeGrid)
