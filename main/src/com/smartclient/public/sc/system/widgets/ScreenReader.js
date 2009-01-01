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


// Reference:
// Examples of tree et al that run in Moz
//   http://developer.mozilla.org/en/docs/Accessible_DHTML
// WAI roles
//   http://www.w3.org/WAI/PF/GUI/roleTaxonomy-20060508.html

// Set isc.screenReader = true after SmartClient loads and before any components are drawn to
// enable screenReader support.  
// NOTE: we install all screenReader functionality regardless, but none of it is active unless
// isc.screenReader is set to true.
isc.screenReader = false;

// General support for WAI roles and states
// ---------------------------------------------------------------------------------------
isc.Canvas.addMethods({
    // called after draw
    addPrimaryRole : function () {  
        if (!isc.Browser.isMoz || isc.Browser.geckoVersion < 20051111) return;

        if (!this.waiRole) return;
        var handle = this.getClipHandle();
        isc.Canvas.setWAIRole(handle, this.waiRole);

        var stateProps = this.waiStateProps;
        if (stateProps) return;
        for (var stateAttr in stateProps) {
            var stateValueProp = stateProps[stateAttr],
                stateValue = this[stateValueProp];

            if (stateValue == null) continue;    

            isc.Canvas.setWAIState(handle, stateAttr, stateValue);
        }
    },
    // call after draw & redraw
    addContentRoles : function () {}
});

isc.Canvas.addClassMethods({
    waiStateNS: "http://www.w3.org/2005/07/aaa", // for IE, use "aaa:"
    xhtml2NS: "http://www.w3.org/TR/xhtml2", // for IE, use "x2"

    setWAIRole : function (element, role) {
        // NOTE: this works to create the attribute in IE, but IE just ignores it when reading
        //if (isc.Browser.isIE) {
        //    element.setAttribute("x2:role", "wairole:" + role);
        //} else {
            element.setAttributeNS(this.xhtml2NS, "role", "wairole:" + role);
        //}
    },
    setWAIState : function (element, stateName, stateValue) {
        //if (isc.Browser.isIE) {
        //    element.setAttribute("aaa:" + stateName, stateValue);
        //} else {
            element.setAttributeNS(this.waiStateNS, stateName, stateValue);
        //}
    },
    setWAIStates : function (element, state) {
        for (var stateName in state) {
            this.setWAIState(element, stateName, state[stateName]);
        }
    }
});

if (isc.DynamicForm) {

// General support for formItems
// ---------------------------------------------------------------------------------------
isc.FormItem.addMethods({
    addContentRoles : function () {
        if (!isc.Browser.isMoz || isc.Browser.geckoVersion < 20051111) return;

        if (!this._canFocus()) return;
        var focusElement = this.getFocusElement();  
        if (focusElement != null) isc.Canvas.setWAIRole(focusElement, this.waiRole);
    }
});

} // end if (isc.DynamicForm) 

if (isc.GridRenderer) {

// Grids
// ---------------------------------------------------------------------------------------
// Support for row and cell roles and states
isc.GridRenderer.addMethods({
    addContentRoles : function () { 
        if (!isc.Browser.isMoz || isc.Browser.geckoVersion < 20051111) return;
        
        var parent = this.parentElement;
        if (!parent || (!parent.rowRole && !parent.getRowRole)) return;

        for (var i = this._firstDrawnRow; i <= this._lastDrawnRow; i++) {
            var rowNum = i,
                rowElement = this.getTableElement(rowNum),
                role = parent.getRowRole ? parent.getRowRole(rowNum) : parent.rowRole;

            if (role && rowElement) {
                isc.Canvas.setWAIRole(rowElement, role);

                if (parent.getRowWAIState) {
                    var state = parent.getRowWAIState(rowNum);
                    if (state) isc.Canvas.setWAIStates(rowElement, state);
                }
            }

            this.addCellRoles(rowNum);
        }
    },
    addCellRoles : function (rowNum) {
        var parent = this.parentElement;
        if (!parent || (!parent.cellRole && !parent.getCellRole)) return;
        for (var i = this._firstDrawnCol; i <= this._lastDrawnCol; i++) {
            var cell = this.getTableElement(rowNum, i),
                role = parent.getCellRole ? parent.getCellRole(rowNum, i) : parent.cellRole;

            if (role) { 
                isc.Canvas.setWAIRole(cell, role);

                if (parent.getCellWAIState) {
                    var state = parent.getCellWAIState(rowNum, i);
                    if (state) isc.Canvas.setWAIStates(cell, state);
                }
            }
        }
    }
});

isc.ListGrid.addMethods({
    // NOTE: "list" WAI role implies per-list-item focusability, selectability, etc.  "grid" is
    // per cell
    waiRole:"list",
    rowRole:"listitem",
    getRowRole : function (rowNum) {
        var record = this.getCellRecord(rowNum);
        if (record && record.isSeparator) return "separator";
        return this.rowRole;
    },
    getRowWAIState : function (rowNum) {
        var record = this.getRecord(rowNum);
        if (this.selection && this.selection.isSelected(rowNum)) {
            return {selected : true };
        }
    }
});

isc.TreeGrid.addMethods({
    waiRole:"tree",
    rowRole:"treeitem",
    getRowRole : function (rowNum) {
        if (!isc.isA.Tree(this.data)) {
            //this.logWarn("data is not a Tree: " + this.echo(this.data));
            return this.rowRole;
        }
        var node = this.getRecord(rowNum);
        if (this.data.isFolder(node)) return "group";
        // NOTE: treegroup not recognized by FF 1.5
        //if (this.data.isFolder(node)) return "treegroup"; 
        else return this.rowRole;
    },
    // an attempt to use the hasparent attribute to link nodes.  Not respected by FF1.5
    //getRowElementId : function (rowNum) {
    //    return this.getID() + "_row_" + rowNum;
    //},
    getRowWAIState : function (rowNum) {
        var node = this.getRecord(rowNum),
            theTree = this.data,
            selected = !!(this.selection && this.selection.isSelected(node));
    
        if (!selected && !theTree.isFolder(node)) return;
    
        var state = { selected : selected };

        if (theTree.isFolder(node)) state.expanded = !!theTree.isOpen(node);

        // an attempt to use the hasparent attribute to link nodes.  Not respected by FF1.5
        //var parent = theTree.getParent(node);
        //if (parent && parent != theTree.getRoot()) {  
        //    state.hasparent = this.getRowElementId(theTree.indexOf(parent));
        //}

        return state;
    }
});

// NOTE: CubeGrid support in AnalyticsScreenReader.js

// Menus / ListPickers
// ---------------------------------------------------------------------------------------

isc.Menu.addMethods({
    waiRole:"menu",
    getRowRole : function (rowNum) {
        var item = this.getItem(rowNum);
        if (!item || item.isSeparator) return "separator";
        if (item.checked || item.checkIf || item.checkable) return "menuitemcheckable";
        if (item.radio) return "menuitemradio";
        return "menuitem";
    },
    getRowState : function (rowNum) {
        if (this.hasSubmenu(this.getItem(rowNum))) return { haspopup:true };
    }
});

// There is no "menubutton" role.  In the example, a menubutton is basically represented by a
// "menu" with just one "menuitem".
// http://developer.mozilla.org/en/docs/Accessible_DHTML
// http://www.mozilla.org/access/dhtml/spreadsheet
isc.MenuButton.addProperties({
    waiRole:"menu"
});
isc.MenuBar.addProperties({
    waiRole:"menubar"
});

// "menu" role vs "list" role: somewhat ambiguous, as both roles have the notions of
// selectability (via "checked" for menus), but generally menus show actions and sometimes
// choices whereas lists show just choices.
// ListGrid currently advertises itself as a List, it's subclass ScrollingMenu sounds like it
// should advertise itself as a Menu, however it is not used for anything but the PickList
// NOTE: separators already handled by ListGrid superclass
//isc.PickListMenu.addProperties({
//    waiRole:"list",
//    rowRole:"listitem"
//});

} // end if (isc.GridRenderer)

(function () {
    var roleMap = {
        Button : "button",
        StretchImgButton : "button",
        ImgButton : "button",
        Label : "label",
    
        // FormItems
        CheckboxItem : "checkbox",
        Slider : "slider",

        // NOTE: drop-downs handled via settings on PickListMenu
        ComboBoxItem : "combobox", 
        SelectItem : "list", 

        Window : "dialog",
        Toolbar : "toolbar",
        //Layout : "group", // unclear whether this would be helpful or add noise


        // NOTE example shows 'tablist' element surrounding 'tab's but not 'tabpanel's
        // http://www.mozilla.org/access/dhtml/class/tabpanel
        TabBar : "tablist",
        PaneContainer : "tabpanel",
        ImgTab : "tab",
        
        EdgedCanvas : "presentation",
        BackMask : "presentation"
        
    }
    // NOTE: 
    for (var className in roleMap) {
        var theClass = isc.ClassFactory.getClass(className);
        if (theClass) theClass.addProperties({waiRole:roleMap[className]});
    }
})();
