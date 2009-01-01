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

 




//>	@object	ClassFactory
//
//	Sets up a real inheritance structure for Javascript objects.
//	We separate out class objects from prototypes, so each gets its own inheritance chain.  
//	This allows us to set up superclass calls, maintain class vs. instance variables and more!
//
//	The ClassFactory is a singleton object that holds the miscellaneous pieces of our inheritance
//	mechanism.
//
//	Your main interaction with the ClassFactory is to create new classes:
//		<code>ClassFactory.defineClass("MyClass", "mySuperClass");</code>
//
//	@see class:Class
//
//	@visibility external
// @treeLocation Client Reference/System
//<

//
//	create the ClassFactory singleton object
//
//  
isc.addGlobal("ClassFactory", {});

  //>DEBUG
// give it a class name so that methods added to it get labelled
isc.ClassFactory.Class = "ClassFactory"; 
  //<DEBUG 

// ClassFactory defines the notion of an "Instance", "ClassObject" and an "Interface".  Add methods
// to isA for recognizing these objects.
isc.addMethods(isc.isA, {
	//>	@classMethod	isA.Instance()
	//
	//	Is <code>object</code> an instance of some class?
	//
	//	@param	object	(object)	object to test
	//	@return			(boolean)	true == <code>object</code> is an instance of some class
	//	@visibility external
	//<
	Instance : function (object) {	return (object != null && object._prototype != null)},

	//>	@classMethod	isA.ClassObject()
	//
	//	Is <code>object</code> a class object?
	//
	//	@param	object	(object)	object to test
	//	@return			(boolean)	true == <code>object</code> is a Class Object
	//	@visibility external
	//<
	ClassObject : function (object) {	return (object != null && object._isClassObject == true)},

	//>	@classMethod	isA.Interface()
	//
	//	Is <code>object</code> an interface object?
	//
	//	@param	object	(object)	object to test
	//	@return			(boolean)	true == <code>object</code> is a Interface Object
	//	@visibility external
	//<
	Interface : function (object) {	return (object != null && object._isInterface == true)},

    InstancePrototype : function (object) { 
        return (isc.isAn.Instance(object) && object._prototype == object)
    }
});


//
// add methods to the ClassFactory
//
isc.addMethods(isc.ClassFactory, {
	//>	@classMethod	ClassFactory.defineClass()
	//
	// Create a new class, which can then be used to create instances of this object type.
    // <P>
    // The new Class is returned by <code>defineClass</code>, is available as
    // <code>isc.<i>ClassName</i></code> and is also available in global scope if not in
    // +link{class:isc,portal mode}.
    // <P>
	// Also creates a new function <code>+link{isA,class:isA}.<i>ClassName()</i></code> object
    // for identifying instances of this Class.
    //
	//	@param	className		(string)	Name for the new class.  
	//	@param	[superClass]	(Class)		Optional SuperClass Class object or name
	//	@return					(Class)		Returns the new Class object.
	//
	//	@visibility external
    //<
    // Internal notes:
	//  Every ClassObject has:
	//  {
	//	 Class : [string classname],
	//	 _isClassObject : true,
	//	 _instancePrototype : [instance prototype for class],
	// 
	//	 _superClass : [pointer to superClass ClassObject (if this class is not a root class)]
	// 
	//	 _subClassConstructor : [constructor function that creates subclass ClassObjects]
	//  }
	//
	//  Every InstancePrototype (and Instance) has:
	//  {
	//	 Class : [string classname]
	//	 _instanceConstructor : [constructor function that creates instances]
	//	 _classObject : [ClassObject for this class]
	//	 _prototype : [the instance prototype (this same object)]
	//  }
	defineClass : function (className, superClass, interfaces, suppressSimpleNames) {
		return this._defineNonRootClass(className, superClass, interfaces, null, suppressSimpleNames);
	},

	//>	@classMethod	ClassFactory.defineInterface()
	//
	//	An "Interface" is an API definition plus a skeletal implementation of that API.
	//  
	//  Interfaces are "mixed in" to another class in order to allow the target class to "support"
	//  the interface.  Interfaces typically require the target class to provide one or two core
	//  methods, and then the interface itself provides the many convenience methods and method
	//  variations that can be written in terms of the core methods.
	//
	//  For example, a List interface could require only get(index) and getLength() from the target
	//  class, and could provide getRange(), indexOf() and other standard List operations.  If the
	//  target class has a more efficient way of supporting getRange() than the generic
	//  implementation in the List interface, the target class can directly implement getRange(),
	//  and the target class' version of getRange() takes precedence.
	//
	//  Comparison to other languages:
	//  - in Java, an "interface" is just an API definition, with no implementation.  The SmartClient 
	//	notion of interfaces is closer to an "abstract class", except that in Java you can only 
	//	inherit from one abstract class, whereas in SmartClient you can mixin as many Interfaces
	//	as you want.  Also, in SmartClient an Interface can contain both instance and class (aka
	//	"static") methods.
	//  - in Ruby, a Mix-in module corresponds exactly to the SmartClient Interface concept.
	//
	//  Writing Interfaces:
	//  - If you are writing an interface and want to indicate that a method must be implemented in
	//	  the target class in order for your interface to work, use addMethods to add a method with
	//	  the special value ClassFactory.TARGET_IMPLEMENTS.  If the target class does not
	//	  implement the method and it gets called, an error will be logged.
	//  - you can subclass an interface to create another interface, but you can't use Super to
	//	  call superclass methods within the interface inheritance chain
	//  - interfaces have no constructor ("init"), so they cannot set up initial state other than by
	//	  setting up class or instance properties
	//	- if you declare a method in an interface, and mix the interface into a class, you can't
	//	  call Super() and get the interface method -- the one you place in your instance will
	//	  override the one from the interface.  
	//
	//	  To make this work, you have to create an intermediate class, then subclass that.  Eg:
	//
	//		CF.defineInterface("face1");
	//		face1.addMethods({ foo:function() {} });
	//
	//		CF.defineClass("class1");
	//		CF.mixInInterface("class1", "face1");
	//
	//		class1.addMethods({
	//			foo : function () {
	//				// NOTE: a Super() call here will NOT go to the face1.foo method
	//			}
	//		})
	//
	//		CF.defineClass("class2", "class1");
	//		class2.addMethods({
	//			foo : function () {
	//				// NOTE: a Super() call WOULD go to the face1.foo method
	//				// 			(assuming class1.foo was not present)
	//			}
	//		})
	//
	//<
	defineInterface : function (className, superClass) {
		return this._defineNonRootClass(className, superClass, null, true);
	},
	 
	//>	@classMethod	ClassFactory.defineRootClass()
	//
	// 	Variant of defineClass for creating a root class (a class with no superclass).
	//
	//	@param	className		(string)	Name for the new class
	//<
	defineRootClass : function (className) {
		return this._defineClass(className, null);
	},

	//>	@classMethod	ClassFactory._defineNonRootClass()
	//
	//  Define a class or interface which is assumed not to be a root class, that is, either the
	//  superclass must be valid or there must be a valid ClassFactory.defaultSuperClass.
	//<
	_defineNonRootClass : function (className, superClass, interfaces, asInterface, suppressSimpleNames) {
		// if no superClass was specified, use the default rootClass
		superClass = (superClass || isc.ClassFactory.defaultSuperClass);
		// if we didn't find a superClass, something went wrong -- bail
		if (!superClass) {
			//>DEBUG
			isc.Log.logWarn("isc.ClassFactory.defineClass(" + className + ") called with null"
						+ " superClass and no ClassFactory.defaultRootClass is defined.");
			//<DEBUG
			return null;
		}
		return this._defineClass(className, superClass, interfaces, asInterface, suppressSimpleNames); 
	},

	//>	@classMethod	ClassFactory._defineClass()
	//
	// Internal method to actually create a class or interface.  <code>superclass</code> must
    // already be valid.
	//<
    _$iscPrefix : "isc.",
    _$Window : "Window",
    _$Selection : "Selection",
    _classTimes : {},
	_defineClass : function (className, superClass, interfaces, asInterface, suppressSimpleNames) 
    {
        

        // If we have an ID collision, warn the user and clobber the existing object
        
        var ignoreGlobalOverride = 
            (isc.Browser.isMoz && (className == this._$Window || className == this._$Selection));

        var existingObject, inISCSpace,
            useSimpleNames = (isc._useSimpleNames && !suppressSimpleNames);
        existingObject = isc[className];
        if (existingObject != null) inISCSpace = true
        else if (useSimpleNames && !ignoreGlobalOverride)  {
            existingObject = window[className];
        }

        if (existingObject != null 
            
            && className != "IButton"
            ) 
        {
            var errorString = "New Class ID: '" + className + "' collides with ID of existing " +
                                // NOTE: this check is required in case there is a collision on
                                // window.Class.  At that moment, isc.isA.Class is not a
                                // function, but the String "isA"
                                (isc.isA && isc.isA.Function(isc.isA.Class) && isc.isA.Class(existingObject) ? 
                                    "Class object '" : 
                                    "object with value '") +
                                existingObject + "'.  Existing object will be replaced.";
            if (!inISCSpace) errorString += "\nThis conflict would be avoided by disabling " +
                                             "ISC Simple Names mode.  See documentation for " +
                                             "further information."

            // Note: If the Log class hasn't loaded yet, we don't warn about this collision.
            // This should be ok in almost every case as Log loads early during the smartClient
            // libs, but if this proves to be an issue, we could hang onto the error string and 
            // wait until after Log has loaded to log a warning.
            if (window.isc.Log) isc.Log.logWarn(errorString);
        }
        
		// accept superClasses defined as strings rather than references to the class object
		superClass = this.getClass(superClass);

		// create a new instance of the superClass to use as a prototype for this new class
		//	note: instancePrototype.init() is deliberately not called here
		var instancePrototype = 
			(superClass ? new superClass._instancePrototype._instanceConstructor() : {});

		// create the class object for the new class: an object whose lookup pointer is the
		// superclass' ClassObject.
		var classObject = this._makeSubClass(superClass);

		// a constructor function that creates objects whose lookup pointer will be
		// instancePrototype.  These created objects are instances of "subClass"
		instancePrototype._instanceConstructor = 
				this._getConstructorFunction(instancePrototype);

		// setup the class object
		classObject.Class = className;
		classObject._isClassObject = true;
        // NOTE: important that we always assign _isInterface so that concrete subclasses of
        // interfaces have _isInterface:false
		classObject._isInterface = instancePrototype._isInterface = !!asInterface;
		classObject._superClass = superClass;
		// crosslink the instance prototype and class object
		classObject._instancePrototype = instancePrototype;

		// setup the instance prototype: these properties appear on all instances
		instancePrototype.Class = className;
		// crosslink the instance prototype and class object
		instancePrototype._classObject = classObject;
		// this exists mostly so that instances can reference their prototype
		instancePrototype._prototype = instancePrototype;
        
        // put all Classes in the special "isc" object
        isc[className] = classObject;
        // if we're in simple names mode (eg, not worried about name collisions), make the class
        // available as a global variable
        if (useSimpleNames) window[className] = classObject;

        this.classList[this.classList.length] = className

		// create a function in the isA singleton object to tell if an object is an instance of
        // this Class, eg, isA.ListGrid()
        // Exception - the _customClassIsA object is used to track cases where we isc.isA has
        // already been given a custom method which we don't want to clobber
        if (!(isc.isA._customClassIsA[className] && isc.isA[className])) {
            isc.isA[className] = this.makeIsAFunc(className);
        }
    
		// as a convenience, mix in a list of interfaces as part of the class definition
		if (interfaces != null) {
			if (!isc.isAn.Array(interfaces)) interfaces = [interfaces];
			for (var i = 0; i < interfaces.length; i++) {
				//alert("Mixing " + interfaces[i] + " into " + className);
				this.mixInInterface(className, interfaces[i]);
			}
		}

		return classObject;
	},
    
    
    makeIsAFunc : function (className) {
        if (this.isFirefox2 == null) {
            this.isFirefox2 = (isc.Browser.isFirefox && isc.Browser.geckoVersion >= 20061010);
        }
        
        if (this.isFirefox2) {
            return function (object) {
                        if (object==null || object.isA==null || object.isA == isc.isA) return false;
                        return object.isA(className);
                   }
        } else {
            var template = this._isAFuncTemplate;
            template[1] = className;
        
            return new Function (this._objectString, template.join(isc._emptyString));        
        }
    },

    // variables for creating "isA" functions for each class
    _objectString : "object",
    _isAFuncTemplate : [
        
        "if(object==null||object.isA==null||object.isA==isc.isA)return false;return object.isA(isc.",
        null, // className
        ")"
    ],

    // make a class object for a new subclass of superClass
    _makeSubClass : function (superClass) {
        if (!superClass) return {};

    	// get the superClass' subclass constructor.  The subclass constructor creates objects
        // whose lookup pointer will be superClass.  It is created on the fly the first time a
        // class acquires a subclass (otherwise all leaf classes would have unnecessary
        // subclass constructors)
        var superSuperClass = superClass._superClass,
            subClassConstructor = superClass._subClassConstructor;
        if (!
            // if the superClass already has a subClassConstructor that differs from the
            // super-super class, use it
            (subClassConstructor &&
             (superSuperClass == null ||
              subClassConstructor !== superSuperClass._subClassConstructor))
            ) 
        {
            // otherwise we make it
		    subClassConstructor = superClass._subClassConstructor = 
                    this._getConstructorFunction(superClass);
        }
        return new subClassConstructor();
    },

	//>	@classMethod	ClassFactory.getClass()
	//
	//	Given a class name, return a pointer to the Class object for that class
	//
	//	@param	className	(string)	name of a class
	//	@return				(Class)		Class object, or null if not found
	//	@visibility external
	//<
	getClass : function (className) {
		// if it's a string, assume it's a className
		if (isc.isA.String(className)) {
            // see if isc[className] holds a ClassObject 
            var classObject = isc[className];
            if (classObject && isc.isA.ClassObject(classObject)) {
                return classObject;
            }
		}
		// if it's a class object, just return it
		if (isc.isA.ClassObject(className)) return className;
        // if it's an instance of some class, return the class object for the class
        if (isc.isAn.Instance(className)) return className._classObject;
        //if (isc.Log) {
        //    isc.Log.logWarn("couldn't find class: " + className + 
        //                    ", defined classes are: " + this.classList);
        //}
		return null;
	},
	
	//>	@classMethod	ClassFactory.newInstance
	//
	// Given the name of a class, create an instance of that class.
	//	
	//		@param	className	(string)		Name of a class.
	//							(ClassObject)	Actual class object to use.
	//		@param	[props]		(object)		Properties to apply to the instance.
	//		@param	[props2]	(object)		More properties to apply to the instance.
	//		@param	[props3]	(object)		Yet more properties to apply to the instance.
	//
	//	@return				(class)		Pointer to the new class.
	//	@visibility external
	//<
    // NOTE: ability to pass _constructor not documented until we have a more reasonable name for
    // this property.
	newInstance : function (className, props, props2, props3, props4, props5) {

		var classObject = this.getClass(className);

		// if we didn't get a classObject from getClass above,
		// and the first parameter is an object,
		// see if any of the properties objects passed have a ._constructor property,
        // which we'll treat as the classname
		if (classObject == null && isc.isAn.Object(className)) {

            var cons;
            for (var i = 0; i < arguments.length; i++) {
                var propsObj = arguments[i];
                // Note: ._constructor is used rather than .constructor to resolve a
                // number of JS issues, as constructor is present by default on native
                // JS objects.
                // In the long run we want to rename this to something more elegant, like 'class'
                // and modify the css class-specific code to look for 'style' or 'baseStyle' rather
                // than className (or even getClass()).
                if (propsObj != null && propsObj._constructor != null) 
                {
                    cons = propsObj._constructor;
                }
            }

			// now fix up the props objects to include the first object 
			//	as a set of properties instead of just the class name
			props5 = props4;
			props4 = props3;
			props3 = props2;
			props2 = props;
			props = className;

			className = cons;

            // Safari and Mozilla both JS Error if the 'constructor' property set to a string
            // (typically because a user is trying to specify the className to use. (it's ok in IE)
            // Note: the 'constructor' property exists as a native function on a number of standard
            // JS objects, so we can't just check for constructor == null
            if (isc.isA.String(props.constructor)) {
                // If we don't yet have a constructor className, make use of this property - then
                // log a warning and remove it.
                if (className == null) className = props.constructor;
                isc.Log.logWarn("ClassFactory.newInstance() passed an object with illegal 'constructor' " +
                             "property - removing this property from the final object. " +
                             "To avoid seeing this message in the future, " +
                             "specify the object's class using '_constructor'.", "ClassFactory");
                props.constructor = null;
            }     

			classObject = this.getClass(cons);                
		}
    
		if (classObject == null) {
			//>DEBUG
			isc.Log.logWarn("newInstance(" + className + "): class not found", "ClassFactory");
			//<DEBUG
			return null;
		}
        
		return classObject.newInstance(props, props2, props3, props4, props5);
	},	
	
	//>	@classMethod	ClassFactory._getConstructorFunction
	//
	//	Given a <code>prototype</code> object, create a new constructor function that will
	//	reference this prototype.  This allows us to say <code>new constructor()</code> to
	//	create a new object that is effectively a subclass of the original <code>prototype</code>.
	//
	//	@param	proto	(object)	Object to use as the prototype for new objects.
	//	@return			(function)	Function that can be used to create new objects
	//								based on the prototype.
	//<
	_getConstructorFunction : function (proto) {
        
        var cons = (isc.Browser.isSafari ? function () {} : new Function());
		cons.prototype = proto;
		return cons;
	},
	


	//>	@classMethod	ClassFactory.addGlobalID()
	//
	// Given an <code>object</code>, declare a unique global variable and link it to object so
    // object can be addressed in the global scope.<br><br>
	//
	// Note: If the object already has an 'ID' property, that is used, otherwise one is
    // generated automatically Note that if you pass an object.ID, it's up to you to ensure it
    // is unique in the global scope!
	//
	//	@param	object	(object)	Object to add global ID to.
	//<
    
    _reservedWords:{
        toolbar:true,
        parent:true,
        window:true
    },
	addGlobalID : function (object, ID, dontWarn) {
		// if an ID was passed, use that
		object.ID = ID || object.ID;
        if (object.ID == null) {
            object.ID = this.getNextGlobalID(object);
            object._autoAssignedID = true;
        }

        var wd = this.getWindow();        

        // if the ID is already taken, log a warning
        var isKeyword, checkForKeyword;
        if (wd[object.ID] != null) {
            var instance = isc.isA.Canvas(wd[object.ID]);
        
            if (!dontWarn) {
                isc.Log.logWarn("ClassFactory.addGlobalID: ID:'" + object.ID + 
                                "' for object '" + object +
                                "' collides with ID of existing object '" + wd[object.ID] + "'." +
                                (instance ? " The pre-existing widget will be destroyed." : 
                                            " The global reference to this object will be replaced"));
            }
            if (instance) wd[object.ID].destroy();
            // If the attribute is not a pointer to a widget instance it may be a
            // a reserved browser keyword or native window attribute which may be non overrideable.
            // Catch the cases we know about (stored in an explicit list)
            // Otherwise use a try...catch block when assigning the property to ensure we don't
            // crash
            
            if (!instance) {
                if (this._reservedWords[ID]) isKeyword = true;
                else checkForKeyword = true;
            }
        }
        
		// now assign the object under that ID globally so anyone can call it
        if (!isKeyword) {
            if (checkForKeyword) {
                try {
                    wd[object.ID] = object;
                } catch (e) {
                    isKeyword = true;
                }
                // attempting to override some keywords (for example window.document) will not
                // throw an error but simply fail to pick up the new value - catch this case as
                // well
                if (wd[object.ID] != object) {
                    isKeyword = true;
                }
            } else {
                wd[object.ID] = object;
            }
        }
        // refuse to use keywords and log a warning
        if (isKeyword) {
            var newID = this.getNextGlobalID(object);
            isc.logWarn("ClassFactory.addGlobalID: ID specified as:"+  object.ID + 
                         ". This is a reserved word in Javascript or a native property of the" +
                         " browser window object and can not be used as an ID." +
                         " Setting ID to " + newID + " instead."); 
            object.ID = newID;
            object._autoAssignedID = true;
            wd[object.ID] = object;
        }
    
        // simple mechanism for instrumenting globals capture.  Simply set isc.globalsSnapshot to an
        // array and we'll fill it here.
         
        if (isc.globalsSnapshot) isc.globalsSnapshot.add(object.ID);
        
	},

    _$isc_OID_ : "isc_OID_",
    _$isc_ : "isc_",
    _$underscore : "_",
    _joinBuffer : [],
    getNextGlobalID : function (object) {
        if (object != null && isc.isA.String(object.Class)) {
            var buffer = this._joinBuffer;
            buffer[0] = this._$isc_;
            buffer[1] = object.Class;
            buffer[2] = this._$underscore;
            isc._fillNumber(buffer, this._globalObjectID++, 3, 5);

            var result = buffer.join(isc.emptyString);
            return result;
        }
        return this._$isc_OID_ + this._globalObjectID++;
    },

    _domIDCount:0,
    _$isc_:"isc_",
    _simpleDOMIDTemplate:[null, "_", null],
    getDOMID  : function (ID, suffix) {
        
        // By default we return a unique but uninformative ID like "isc_1A"
        
        if (!isc._longDOMIds || !ID || !suffix) {
            var number = this._domIDCount++;
            return this._convertToBase36(number, this._$isc_);
        }
        
        // In simpleDOMIDMode, create an ID that incorporates the ID / suffix passed to us
        // We're making an assumption that the ID / suffix passed in is already unique
        
        this._simpleDOMIDTemplate[0] = ID;
        this._simpleDOMIDTemplate[2] = suffix;
        return this._simpleDOMIDTemplate.join(isc.emptyString);
    },
    
    _base36Digits:["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K",
                   "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"],
    _base36Arr:[],
    _convertToBase36 : function (number, prefix) {
        var digits = this._base36Digits,
            resultsArr = this._base36Arr;

        resultsArr.length = 0;

        // We use this to prefix with "isc_"
        if (prefix) resultsArr[0] = prefix;
        
        var totalDigits = 3;
        
        if (number > 46655) {
            while (Math.pow(36,totalDigits) <= number) totalDigits += 1;
        }
        
        // convert number to base 36
        while (number >= 36) {
            var remainder = number % 36;
            // always add to the end slot, so we get 100 rather than 001
            resultsArr[totalDigits-(prefix ? 0 : 1)] = digits[remainder];
            totalDigits -=1;
            
            number = Math.floor(number / 36);
        }
        resultsArr[totalDigits-(prefix ? 0 : 1)] = digits[number];
   
        return resultsArr.join(isc.emptyString);
        
    },
    
	//>	@classMethod	ClassFactory.mixInInterface()	(A)
	//
	// Add the methods of a given Interface to a Class so the class implements the methods.
    // If the class has already defined a method with the same name as the one specified
	// in the interface, the class' method will be retained.
	//
	//	@param	className		(String)	Name of the Class to add methods to.
	//	@param	interfaceName	(String)	Name of the Interface to get methods from.
	//<
	mixInInterface : function (className, interfaceName) {
		var theInterface = this.getClass(interfaceName),
			theClass = this.getClass(className)
		;
		if (!theInterface || !theClass) return null;
	
		if (!theInterface._isInterface) {
			//>DEBUG
			isc.Log.logWarn("ClassFactory.mixInInterface asked to mixin a class which was not"
						+ " declared as an Interface: "+interfaceName+ " onto "+className);
			//<DEBUG
            return;
		}

		// mark the class as implementing the interface
		if (!theClass._implements) theClass._implements = [];
        // ensure the interface doesn't apply to a superClass
        else theClass._implements = theClass._implements.duplicate();

        // install all properties and methods added to this interface, and any superInterfaces
        while (theInterface) {
    		// mix in class properties and methods
	    	this._mixInProperties(theInterface, theClass, true);
    		// mix in instance properties and methods
	    	this._mixInProperties(theInterface, theClass);

		    theClass._implements[theClass._implements.length] = interfaceName;

            theInterface = theInterface.getSuperClass();
            if (theInterface && !theInterface._isInterface) break;
        }
	},

	_mixInProperties : function (source, destination, asClassProperties) {
        var props;
		if (asClassProperties) { 
            props = isc._interfaceClassProps[source.Class];
		} else {
            props = isc._interfaceInstanceProps[source.Class];
			source = source.getPrototype(); 
			destination = destination.getPrototype();
        }

        if (props == null) return;

        for (var i = 0; i < props.length; i++) {
            var propName = props[i];

			// skip any properties already defined in the target
			if (destination[propName] != null) continue;
    
            var propValue = source[propName];

			// the interface declared that the target class must implement a method, and it's not
			// there
			if (isc.isA.String(propValue) && propValue == this.TARGET_IMPLEMENTS) {
				//>DEBUG
				var message = (asClassProperties ? "Class" : "Instance") + " method " 
					+ propName + " of Interface " + source.Class + " must be implemented by "
					+ "class " + destination.Class;
                // Don't complain about interface methods not being implemented b/c it's
                // perfectly normal to mix in interfaces before adding properties to the
                // class.  In fact that may be the case most of the time b/c showing the
                // interfaces at class definition is very useful 
                // (e.g: defineClass("Foo", "Bar", "SomeInterface")
				//
				//isc.Log.logWarn(message + ", is not yet implemented"); 

				// but it will be an error if this method is ever called, so install a function
                // that will complain
				destination[propName] = new Function('this.logError("' + message + '")');
				//<DEBUG 
			} else {
                //isc.Log.logWarn("adding property " + propName + 
                //                " from interface " + source.Class);
				destination[propName] = propValue;
            }
        }
	},

	//>	@classMethod	ClassFactory.makePassthroughMethods()	(A)
	//
    // Create methods that call through to a related object stored under property
    // <code>propName</code>.  This enables easy implementation of the Delegate design
    // pattern, where one object implements part of its APIs by having another object respond
    // to them.
    // 
	//	@param	methodNames	(array of strings)	list of methods names
	//	@param	propName    (string)		    Property name where the target object is stored.
	//<
    _$argList : "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p",
    makePassthroughMethods : function (methodNames, propName) {
        if (!propName) propName = "parentElement";

        var funcTemplate = this._funcTemplate;
        if (funcTemplate == null) {
            funcTemplate = this._funcTemplate = ["return this.",,".",,"("+this._$argList+")"];
        }

        var methods = {};

		for (var i = 0; i < methodNames.length; i++) {
			var methodName = methodNames[i];
    
			// create a function that routes a function call to the target object
            funcTemplate[1] = propName;
            funcTemplate[3] = methodName;
			methods[methodName] = 
                new Function(this._$argList, funcTemplate.join(isc.emptyString));
		}
        
        return methods;
    },

	//>	@classMethod	ClassFactory.writePassthroughFunctions()	(A)
    //
    // Install methods in <code>destinationClass</code> which will call the same-named function
    // on a related object stored under the property name <code>memberName</code> on instances
    // of <code>destinationClass</code>.
    //
	//	@example	<code>ClassFactory.writePassthroughFunctions(
	//					ListGrid, "selection", ["select","selectAll",..."]
	//				);</code>
	//
	//				after this, you can call
	//					listGrid.selectRecord()
	//				rather than
	//					listGrid.selection.selectRecord()
    //<
	writePassthroughFunctions : function (destinationClass, memberName, methodNames) {
        var methods = this.makePassthroughMethods(methodNames, memberName);
        destinationClass.addMethods(methods);
    }

});	// END isc.addMethods(isc.ClassFactory)

//
// add properties to the ClassFactory object
//
isc.addProperties(isc.ClassFactory, {
	// when defining interfaces, use this constant as a marker value indicating that a method
    // must be implemented by any class your interface is mixed in to
	TARGET_IMPLEMENTS : "TARGET_IMPLEMENTS",

	//>	@attr	ClassFactory.defaultSuperClass  (Class : null : [IA])  
    // Class to use as the default superClass if none is specified
    //<
		
	// Counter which is used to generate unique object IDs
	_globalObjectID : 0,

	// Classes created with ClassFactory.defineClass
	classList : []
});

//> @classMethod isc.defineClass
// Shortcut for <code>isc.ClassFactory.defineClass()</code>.
// @include classMethod:ClassFactory.defineClass
// @see ClassFactory.defineClass()
// @visibility external
//<
isc.defineClass = function (className, superClass, interfaces, suppressSimpleName) {
    return isc.ClassFactory.defineClass(className, superClass, interfaces, suppressSimpleName);
}

//> @type SCClassName
// Name of a SmartClient Class, that is, a Class that has been created via
// +link{isc.defineClass()}, including Classes built into SmartClient, such as "ListGrid".
// 
// @visibility external
//<

isc.defer = function (code) {
    var lastClass = isc.ClassFactory.getClass(isc.ClassFactory.classList.last()),
        existingCode = lastClass._deferredCode;
    isc.Log.logWarn("deferred code being placed on class: " + lastClass);
    // first time
    if (!existingCode) lastClass._deferredCode = [code];
    // more times
    else existingCode.add(code);
}

