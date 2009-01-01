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

 





//>	@class	FormItemFactory
//
//	Singleton class to create FormItems for you from object literals
//
//	TODO: consider making this a static method on FormItem.
//
//<
isc.ClassFactory.defineClass("FormItemFactory");
isc.FormItemFactory.addClassMethods({

    // given a form item instantiation object, return the name of the formItem class to use
    getItemClassName : function (object, className, form, dontChangeObject) {
        if (className == null) className = object.editorType || object.formItemType || 
                                                    object.type;

        // Special case SelectOtherItems and SelectItems - 
        //  look back at the form's useNativeSelectItems property.
        if (isc.isA.String(className)) {
            var lccn = className.toLowerCase();
     
            if (lccn.contains(isc.DynamicForm._$select)) {       
                // make 'selectOther's into 'selects' with the isSelectOther property set to
                // true.

                if (lccn == "selectother" || lccn == "selectotheritem") {
                    lccn = "select";
                    if (!dontChangeObject) object.isSelectOther = true;
                }
            
                if (lccn == "select" || lccn == "selectitem") {
                    form = object.form || form;
                    var useNativeSelect = (!isc.ListGrid || object.multiple || 
                                          (form ? form.useNativeSelectItems : false));
                    if (useNativeSelect) className = "NativeSelectItem"
                    else className = "SelectItem";
                }
            }
            if (lccn == isc.DynamicForm._$multifile) className = "MultiFileItem";
            else if (lccn == isc.DynamicForm._$multiupload) className = "MultiUploadItem";
            else if (lccn == isc.DynamicForm._$base64Binary.toLowerCase()) className = "SOAPUploadItem";
        }
        return className;
    },
    
    // get the form item class that className seems to indicate, or null if there's no match
    _$text : "text",
    _$Item : "Item",
    _$TextareaItem : "TextareaItem",
    _classTable : {},
    getItemClass : function (className) {
    
		var classObject = isc.ClassFactory.getClass(className);

        // if the className was not the literal class name of a FormItem subclass
		if (!classObject || !isc.isA.FormItem(classObject)) {
			if (className == null) className = this._$text;
            var table = this._classTable,
                officialName = table[className];
            if (!officialName) {
                officialName = table[className] =
        			// assume the short name of the type was used (eg text -> TextItem)
		        	className.substring(0,1).toUpperCase() + 
                            className.substring(1) + this._$Item;
            }
            // synonym
			if (officialName == this._$TextareaItem) officialName = "TextAreaItem";
			classObject = isc.ClassFactory.getClass(officialName);
		}
        return classObject; // may still be null
    },

	//>	@method	FormItemFactory.makeItem()	(A)
	//		@group	creation
	//			given an object literal, convert it to an appropriate FormItem type
	//
	//		@param	object		(object)	properties for the new object
	//	XXX we may want to pass other defaults here...
	//		@return	(FormItem)		an appropriate FormItem
	//<
	makeItem : function (object) {

		if (object == null) return null;
		
		if (isc.isA.FormItem(object)) {
			//>DEBUG
			//this.logDebug("Returning formItem " + object);
		   	//<DEBUG
			return object;
		}
		
		var className = this.getItemClassName(object),
            classObject = this.getItemClass(className);

		// if no class was found, use a generic TextItem
		if (!classObject) {
			//>DEBUG
			this.logWarn("makeItem(): type " + object.type + " not recognized, using TextItem");
			//<DEBUG
			classObject = isc.TextItem;
		}

		//>DEBUG
		//this.logDebug("Making item of class " + classObject.Class);
		//<DEBUG
		return isc.ClassFactory.newInstance(classObject, object);
	}
});
