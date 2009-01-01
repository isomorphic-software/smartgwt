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

 



if (!isc.Browser.isSafari) {
    isc._window = window;
    isc._document = window.document;
}


if (window.isc_enableCrossWindowCallbacks && isc.Browser.isIE) {
   isc.enableCrossWindowCallbacks = true;
   Object._window = window;
}



//>	@class	Class
//	
// The Class object is root of the Isomorphic SmartClient inheritance tree -- it includes
// functionality for creating instances, adding methods and properties, getting prototypes,
// etc.<br><br>
//
// To add functionality to ALL classes, add them to Class.<br><br>
//
// To create a Class, call <code>ClassFactory.defineClass("MyClass", "MySuperClass")</code>
// <P>
// <code>defineClass</code> will return the created class, and make it available as
// <code>isc.MyClass</code>, and as the global variable <code>MyClass</code> if not in
// +link{class:isc,portal mode}.
// <P>
// You can then:
// <UL>
//		<LI>add class-level (static) properties and methods to the class:
//				<code>MyClass.addClassProperties()</code>	
//			these methods and properties are accessed through the Class variable itself, eg:
//				<code>MyClass.someStaticMethod()</code> or <code>MyClass.someStaticProperty</code>
//
//		<LI>add default instance properties and methods to the class:
//				<code>MyClass.addProperties()</code>
//			these methods and properties are accessed through a class instance, eg:
//				<code>var myInstance = MyClass.create();</code>
//				<code>myInstance.someInstanceMethod()</code>
//
//		<LI>create new instances of this class:
//				<code>var myInstance = MyClass.create()</code>
// </UL>
// NOTE: as a convention, all class names begin with a capital letter and all instances begin
// with a lower case letter.
//
//  @treeLocation Client Reference/System
//	@visibility external
//<
isc.ClassFactory.defineRootClass('Class');

//
// set Class as the default superclass for classes defined by ClassFactory.defineClass()
//
isc.ClassFactory.defaultSuperClass = isc.Class;

//
//	add static methods to all classes defined with our system
//
//	call on the Class object itself, as:   Class.method()
//

//  First we install the methods that allow us to addMethods to a class as a method call on the
//  class (eg Class.addClassMethods(methods) rather than addMethods(Class, methods);.
isc.addMethods(isc.Class, {

	//>	@classMethod	Class.addClassMethods()
	//
	//	Add static (Class-level) methods to this object.<br><br>
	//
	//	These methods can then be called as MyClass.method().  The value for "this" will be the
    //	class object for the class.
	//
	//	@param	[arguments 0-N] (object)	objects with methods to add (think named parameters).
	//										all the methods of each argument will be applied
	//										as class-level methods.
	//	@visibility internal
	//<
        
	addClassMethods : function () {
		for (var i = 0; i < arguments.length; i++)
			isc.addMethods(this, arguments[i]);
	}
    
});

isc.Class.addClassMethods({

	//>	@classMethod Class.create()
	//
	// Create an instance of this class.  
    // <P>
    // All arguments passed to this method are passed on to the +link{Class.init()} instance 
    // method.  Unless +link{class.addPropertiesOnCreate} is set to <code>false</code>, all
    // arguments passed to this method must be Objects and all properties on those
    // objects will be copied to the newly created instance before +link{Class.init()} is
    // called.  If there are overlapping properties in the passed arguments, the last wins.
    // <p>
    // Any return value from +link{Class.init()} is thrown away.
	// <p>
    // Note: Generally, you would not override this method.  If you want to specify a
    // constructor for your class, provide an override for +link{Class.init()} for generic
    // classes or +link{canvas.initWidget()} for any subclasses of UI components
    // (i.e. descendants of +link{Canvas}.
	//
	//	@param	[arguments 0-N]	(any)
    //      Any arguments passed will be passed along to the init() routine of the instance.
    //      Unless +link{class.addPropertiesOnCreate} is set to false, any arguments passed to
    //      this method must be of type Object.
	//	@return			 		(object)	
    //      New instance of this class, whose init() routine has already been called
	//
	//	@example	<code>var myInstance = MyClass.create()</code>
    //  @example    create
	//	@visibility external
	//<
    create : function (A,B,C,D,E,F,G,H,I,J,K,L,M) {
        var newInstance = this.createRaw();

        newInstance = newInstance.completeCreation(A,B,C,D,E,F,G,H,I,J,K,L,M);
    
		// return the new instance
		return newInstance
    },

    
    _initializedClasses : {},
    createRaw : function () {
        if (!this.initialized()) this.init();

		// create a new instance based on the class's instanceProtoype
		var newInstance = new this._instancePrototype._instanceConstructor();

        // install the appropriate namespace on the instance
        newInstance.ns = this.ns;
        
        return newInstance;
    },

    // class-level init
    init : function () {
        //this.logWarn("uninitialized class");

        // init superclass chain
        var superClass = this.getSuperClass();
        if (superClass && !superClass.initialized()) superClass.init();

        // execute any deferred class definition
        var deferredCode = this._deferredCode;
        if (deferredCode) {
            //this.logWarn("eval'ing deferred code");
            this._deferredCode = null;
            deferredCode.map(eval);
        }

        

        this._initializedClasses[this.Class] = true;
    },

    // NOTE: we have to use a structure like this instead of just checking a property on the
    // class object (eg this._initialized) because any property would be inherited from
    // superclass class objects.
    initialized : function () { return this._initializedClasses[this.Class] },

	//>	@classMethod Class.getClassName()
	//
	//	Gets the name of this class as a string.
	//
	//	@return (string)	name of the class
	//	@visibility external
	//<
	getClassName : function () { 
		return this.Class;
	},

	//>	@classMethod Class.getSuperClass()
	//	
	//	Gets a pointer to the superClass' Class object.
	//
	//	@return (Class)		Class object for superclass.
	//	@visibility external
	//<
    getSuperClass : function () {
        return this._superClass;
    },

	//>	@classMethod Class.getPrototype
	//
	//	Gets a pointer to the prototype object for this class.
	//
	//	This is the object that you should install methods/properties into
	//	to have them apply to each instance.  Generally, you should use
    //	+link{Class.addProperties()} to do this
	//	rather than affecting the prototype directly
	//
	//	@return	(object)	Prototype for all objects instances.
	//<
    // NOTE: not external because customers shouldn't muck with the prototype directly
	getPrototype : function () {
		return this._instancePrototype;
	},

	//>	@classMethod Class.addMethods()
	//
	//	Add methods to all instances of this class.<br><br>
	//
	//	The added methods can be called as myInstance.method()
	//
	//	@param	[arguments 0-N] (object)	objects with methods to add (think named parameters).
	//										all the methods of each argument will be applied
	//										as instance-level methods.
    //  @return                 (object)    the class after methods have been added to it
	//	@visibility internal
	//<
        
	addMethods : function () {
        if (this._isInterface) {
            this.logWarn("Use addInterfaceMethods() to add methods to interface " + this);
        }
		for (var i = 0; i < arguments.length; i++)
			isc.addMethods(this._instancePrototype, arguments[i]);
        return this._instancePrototype;
	},
    
	addInterfaceMethods : function () { 
		for (var i = 0; i < arguments.length; i++)
			isc.addMethods(this._instancePrototype, arguments[i]);
    },
    addInterfaceProperties : function () {
		isc.addPropertyList(this._instancePrototype, arguments);
    },

    
	//>	@classMethod Class.registerStringMethods()
	//
	//	Register a method, or set of methods, that can be provided to instances of this class as
    //	Strings (containing a JavaScript expression) and will be automatically converted into
    //	functions.
    //  <p>
    //  For example:
    //  <pre>
    //  isc.MyClass.registerStringMethods({
    //      myStringMethod: "arg1, arg2"
    //  });
    //  </pre>
	//
	//	@param	methodName (object)	    If this is a string, name of the property to register
    //                                  If this is an object, assume passing in a set of name/value
    //                                  pairs to register
    //  @param  argumentString (string) named arguments for the property in a comma separated string
    //                                  (not used if methodName is an object)
    // @see group:stringMethods
	//	@visibility external
	//<
	registerStringMethods : function (methodName, argumentString) {
    
        // If we haven't already done so, override the method argument registry
        // from the super class (otherwise we'll affect other classes with our changes)
        var registry = this._stringMethodRegistry;
        if (!this.isOverridden("_stringMethodRegistry")) {
            
            //if (registry._entries != null) {
            //    this.logWarn("Methods being registered on: " + this.Class + 
            //                 " causing copy of superclass " + this._superClass.Class +
            //                 " registry");
            //}
            var registryClone = {},
                entries = registryClone._entries = (registry._entries ?
                                                    registry._entries.duplicate() : []);
            for (var i = 0; i < entries.length; i++) {
                registryClone[entries[i]] = registry[entries[i]];
            }
            this._stringMethodRegistry = registry = registryClone;
        }        

        // If it's an object, rather than a string, assume it's a list of multiple methodName
        // to argument mappings to register at once.
        if (!isc.isA.String(methodName)) {
            var newMethods = methodName;

            // if it's not an object, bail - we don't know how to deal with this
            if (!isc.isAn.Object(newMethods)) {
                this.logWarn("registerStringMethods() called with a bad argument: " +
                             methodName);
                return false;
            }
            
            for (var methodName in newMethods) {
                registry[methodName] = newMethods[methodName]
                registry._entries.add(methodName);
            }
            
        } else {    
            // in the registry, the distinction between null and undefined is important.
            // If the second parameter is currently undefined, set it to null
            // (this allows the second param. to be optional).
            if (argumentString == null) argumentString = null;

            registry[methodName] = argumentString;
            registry._entries.add(methodName);
        }
        
        // return true for success
        return true;
	},

	//>	@classMethod Class.evaluate()
    // Evaluate a string of script and return the result.    
    // <P>
    // This method is a wrapper around the native javascript method <code>eval()</code>. It
    // papers over some native issues to ensure evaluation of script behaves consistently across
    // browsers
    //
	// @param expression (string) the expression to be evaluated
    // @param evalArgs (object) Optional mapping of argument names to values - each key will
    //      be available as a local variable when the script is executed.
    // @return (any) the result of the eval
    // @visibility external
	//<
    
    evaluate : function (expression, evalArgs, globalScope) {
        //!OBFUSCATEOK
        
        // Set a flag so we know an eval is executing
        
        if (!isc._evalRunning) isc._evalRunning = 0;
        isc._evalRunning ++;
        var returnVal;
        
        
        if (evalArgs) {
            with (evalArgs) {
                if (globalScope) returnVal = window.eval(expression)
                else returnVal = eval(expression);
            }
        } else {
            if (globalScope) returnVal = window.eval(expression)
            else returnVal = eval(expression);
        }
        // Decrement / clear the evalRunning flag 
        
        if (isc._evalRunning != null) isc._evalRunning --;        
        if (isc._evalRunning == 0) delete isc._evalRunning;        
        return returnVal;
	},

	
	//>	@classMethod Class.addClassProperties()
	//
	//	Add static (Class-level) properties and methods to this object<br><br>
	//
	//	These properties can then be accessed as MyClass.property, or for functions, called as
    //  MyClass.methodName()
	//
	//	@param	[arguments 0-N] (object)	objects with properties to add (think named parameters).
	//										all the properties of each argument will be applied
	//										as class-level properties.
    //  @return                 (object)    the class after properties have been added to it
	//	@visibility external
	//<
	addClassProperties : function () {
		isc.addPropertyList(this, arguments);
        return this;
	},

	//>	@classMethod Class.addProperties()
	//
	//	Add default properties and methods to all instances of this class.<br><br>
	//
	//	These properties can then be accessed as <code>myInstance.property</code>, 
    //  and methods can be called via <code>myInstance.methodName()</code>
	//
	//	@param	[arguments 0-N] (object)	objects with properties to add (think named parameters).
	//										all the properties of each argument will be applied
	//										as instance-level property defaults.
    //  @return                 (object)    the class after properties have been added to it
	//	@visibility external
	//<
    _deferredDefaults : {},
	addProperties : function () {
        
        if (this._isInterface) {
            this.logWarn("Use addInterfaceProperties() to add methods to interface " + this);
        }
		isc.addPropertyList(this._instancePrototype, arguments);
        return this;
	},
	
	//>	@classMethod Class.addPropertyList()
	//
	//	Add default properties to all instances of this class
	//
	//	@param	list (object[])		array of objects with properties to add
    //  @return      (object)       the class after properties have been added to it
	//
	//	@visibility external
	//<
	addPropertyList : function (list) {
		isc.addPropertyList(this._instancePrototype, list);
        return this;
	},

    //> @classMethod Class.changeDefaults() (A)
    // 
    // Changes a set of defaults defined as a JavaScript Object.  For these kind of properties,
    // simply calling +link{Class.addProperties()} would replace the original Object
    // with yours, wiping out settings required for the basic functionality of the component.
    // This method instead applies your overrides over the existing properties, without
    // destroying non-overridden properties.
    // <p>
    // For example let's say you have a component that's defined as follows
    // <pre>
    // isc.defineClass("MyComponent");
    // isc.MyComponent.addProperties({
    //     simpleProperty: "some value",
    //     propertyBlock : {
    //       foo: "bar",
    //       zoo: "moo"
    //     }
    // }
    // </pre>
    // If you wanted to override simpleProperty, you can just call +link{Class.addProperties()}
    // like this:
    // <pre>
    // isc.MyComponent.addProperties({
    //     simpleProperty: "my override"
    // });
    // </pre>
    // If you want to override the value of <code>propertyBlock.moo</code> above,
    // but you don't want to clobber the value of <code>propertyBlock.zoo</code>.  If you use
    // the above pattern like so:
    // <pre>
    // isc.MyComponent.addProperties({
    //     propertyBlock: {
    //         foo: "new value",
    //         zoo: "moo"
    //     }
    // });
    // </pre>
    // You need to re-specify the value of <code>propertyBlock.zoo</code> which you didn't want
    // to override.  Failing to re-specify it would destroy the value.
    // <p>
    // Instead of re-specifying the value, you can use this method to modify the value of
    // <code>foo</code> - like this:
    // <pre>
    // isc.MyComponent.changeDefaults("propertyBlock", {
    //     foo: "new value"
    // });
    // </pre>
    // <p>
    // See also the +link{AutoChild} system for information about standard sets of defaults
    // that are available for customization.
    //
    // @param defaultsName (String) name of the property to change
    // @param newDefaults (Object) overrides for defaults
    // 
    // @visibility external
    //<
    changeDefaults : function (defaultsName, newDefaults) {
        // get existing defaults
        var defaults = this._getDefaults(defaultsName),
            mustAssign = false;

        // if we have a superclass with the same defaults, copy them so the superclass is not
        // affected
        var mySuper = this.getSuperClass();
        if (mySuper) {
            var superDefaults = mySuper._getDefaults(defaultsName);
            if (superDefaults != null && superDefaults == defaults) {
                //this.logWarn("copying defaults for property: " + defaultsName +
                //             " on class: " + this);
                defaults = isc.addProperties({}, defaults);
                mustAssign = true;
            }
        }
         
        // if defaults don't exist, create an empty object for them
        if (defaults == null) {
            defaults = newDefaults || {};
            mustAssign = true;
        } else {
            // otherwise add the specified defaults to the existing defaults
            isc.addProperties(defaults, newDefaults);
        }

        // if we created a new defaults object (because there were no existing defaults, or we
        // had to duplicate a superclass' defaults) override the slot on this class
        if (mustAssign) {
            //this.logWarn("had to assign when overriding property: " + defaultsName + 
            //             " on class: " + this);
            var props = {};
            props[defaultsName] = defaults;
            this.addProperties(props);
        }
    },
    
    _getDefaults : function (defaultsName) {
        var deferredDefaults = this._deferredDefaults[this.Class],
            defaults = this.getInstanceProperty(defaultsName) || 
                        (deferredDefaults ? deferredDefaults[defaultsName] : null);
        return defaults;
    },
    
    // backcompat: briefly exposed as visibility external in 5.5 beta builds
    replaceDefaults : function (defaultsName, newDefaults) {
        this.changeDefaults(defaultsName, newDefaults);
    },

	//>	@classMethod Class.setProperties()
	//	Apply a set of properties to a class object, calling the appropriate setter class methods if
    //	any are found.
	//
	//	@param	[arguments 0-N] (object)	objects with properties to add (think named parameters).
	//										all the properties of each argument will be applied one after another
	//										so later properties will override
    //	@visibility external
	//<
	setProperties : function () {

        var propertyBlock;

        // If passed multiple arguments, combine them down to a single object.
        // (Step required as setProperties() on this instance prototype doesn't take an array,
        // and we don't know how many arguments we have).
        if (arguments.length == 1) {
            propertyBlock = arguments[0];
        } else {
            propertyBlock = {};
                
            for (var i = 0; i < arguments.length; i++) {
                isc.addProperties(propertyBlock, arguments[i]);
            }
        }        
        
        // set properties on the instance prototype
        this._instancePrototype.setProperties(propertyBlock);
	},

	//>	@classMethod Class.isOverridden()
	//	Determine whether we've overridden a specified class property or method from our superClass
	//
	//	@param	property    (string)	property to check
    //    
    //  @return             (boolean)   true if the property has been overridden
	//<
    isOverridden : function (property) {
        // XXX Note - need another function to check for a class overriding the properties of the 
        // instance prototype
        return (!(this[property] === this._superClass[property]));
    },

    //> @classMethod Class.isA()
    //
    // Returns whether this class object is the provided class or is a subclass of the provided
    // class, or implements the provided interface.
    //
    // @param  className (string)        Class name to test against
    //
    // @return           (boolean)       true == this Class is a subclass of the provided classname
	// @visibility external
    //<
    isA : function (className) {
        if (className == null) return false;

        // handle being passed Class Objects and instances of classes
        if (!isc.isA.String(className)) {
            className = className.Class;
            if (!isc.isA.String(className)) return false;
        }

        if (isc.startsWith(className, isc.ClassFactory._$iscPrefix)) {
            className = className.substring(4);
        }
        // walk the class object inheritance chain
        var superClass = this;
        while (superClass) {
            if (superClass.Class == className) return true;
            superClass = superClass._superClass;
        }

        // walk the interface inheritance chain
        if (this._implements) {
            for (var i = 0; i < this._implements.length; i++) {
                var superInterface = isc.ClassFactory.getClass(this._implements[i]);
                while (superInterface) {
                    if (superInterface.Class == className) return true;
                    superInterface = superInterface._superClass;
                }
            }
        }

        return false;
    },

    _getNextImplementingSuper : function (methodCallingSuper, superClassProto, methodName,
                                          staticSuper) 
    {
        var superClassImpl;
		for (;;) {
            if (superClassProto == null) {
                // no superclass provides a differing implementation - error
                superClassImpl = null;
                break;
            }

            
            var superClassImpl = isc.Class._getOriginalMethod(methodName, superClassProto);

            // function is not defined in any superclass further up the chain - error
            if (superClassImpl == null) break;

            // found a superclass implementation that differs - success!
            if (methodCallingSuper != superClassImpl) {
                //this.logWarn("found differing superClass implementation: " +
                //             this.echoLeaf(superClassImpl) +    
                //             " on prototype: " + superClassProto);
                break; 
            }

			// go up the chain to the prototype of the superClass
            if (staticSuper) {
    			superClassProto = superClassProto._superClass;
            } else {
    			superClassProto = superClassProto._classObject._superClass._instancePrototype;
            }
		}
        if (superClassImpl != null) return superClassProto;
        return null;
    },

	//>	@classMethod Class.Super()
	//
	//	Call the SuperClass implementation of a class method.
	//
	//	@param methodName   (string)	name of the superclass method to call
	//	@param args         (arguments or Array) native "arguments" object, or array of
    //                                           arguments to pass to the Super call
	//	@param [nativeArgs] (arguments) native "arguments" object, required if an Array is
    //                                  passed for the "args" parameter in lieue of the native
    //                                  arguments object
	//
	//	@return					(any)		return value of the superclass call
	//
	// @visibility external
	//<
	//	@param 	[nativeArguments] (Arguments) native "arguments" object.  Required only if
    //                                        calling Super() with a substitute set of
    //                                        arguments
    
	Super : function (methodName, args, nativeArguments) {
        if (isc._traceMarkers) arguments.__this = this;

        // if args is clearly not an Array or Arguments object, make it an Array.  NOTE: you
        // can still fool us by passing an object with a .length property which is neither an
        // Array or Arguments object - to avoid this we'd have to be able to reliably
        // cross-platform tell the difference between an Arguments object and a normal Object.
        // The simplest way to do this would probably be to check the callee property, which is
        // very unlikely to be set to a function on some random object being passed as params.
        if (args != null && (args.length == null || isc.isA.String(args))) args = [args];

        if (args == null) args = isc._emptyArray;

        
        this._nativeArguments = nativeArguments || args;
        //if (nativeArguments == null && nativeArguments != false && args && args.constructor && 
        //    args.constructor.nativeType == 2) 
        //{
        //    this.logWarn("substitute arguments passed, but native arguments object " +
        //                 "not passed as third parameter");
        //}

		// overall plan: look through the inheritance chain for a method that differs from the
        // implementation in this instance, and call that

        // get the prototype for the last method of this name that called Super().  Null for
        // the first call to Super 
        this._lastProto = isc.Class._getLastProto(methodName, this);
        // set flag to tell invokeSuper it's being called by external Super and needs to pick
        // up extra arguments from instance flags
        this._externalSuper = true;
    
        return this.invokeSuper(null, methodName);
    },

    // observation and timers may replace a function with a generated function, storing the
    // original function in another slot.  We need to find the original function because
    // otherwise, when we look up the superclass chain to find a differing implementation, we'd
    // be using the auto-generated function, and so think all superclasses had differing
    // implementations.
    // Note that both observation and timing indirects can be installed on classes as well as
    // instances.
    _getOriginalMethod : function (methodName, theProto) {
        var method = theProto[methodName];

        while (method && method._origMethodSlot) {
            //this.logWarn("indirect installed on: " + theProto + ": " + this.echoLeaf(method));
            method = theProto[method._origMethodSlot];
        }

        return method;
    },

    // high speed implementation of Super used by internal callers, where the class and method
    // of the calling function are directly passed in.  Calls to external Super can be freely
    // mixed with calls to invokeSuper because they store the same state.
    //
    // Extremely critical path code sometimes calls Super like so:
    //    isc.StatefulCanvas._instancePrototype.initWidget.call(this);
    // This is safe only if there are no calls to external Super() in any superclass
    // implementations.  If there are, with the lack of any stored lastProto, inter-recursion
    // will be falsely detected and the leaf implementation will be called.
    invokeSuper : function (clazz, methodName, a,b,c,d,e,f,g,h) {
        // static mode (class methods calling Super)
        var staticSuper = this._isClassObject;

        
        var externalSuper = this._externalSuper;
        this._externalSuper = null;
        var nativeArguments = this._nativeArguments;
        this._nativeArguments = null;

        
        var lastProto;
        if (externalSuper) {
            lastProto = this._lastProto;
            this._lastProto == null;
        } else {
            // for framework code calling invokeSuper, null indicates instance override
            if (clazz != null) {
                // in static mode, protos are class objects
                lastProto = staticSuper ? clazz : clazz._instancePrototype;
            }
        }

        // figure out the method that is calling Super in order to compare the implementation
        // against superclass implementation to find out when a superclass implementation differs
        var methodCallingSuper, nextProto;
        if (lastProto == null) {
            
            methodCallingSuper = isc.Class._getOriginalMethod(methodName, this);

            // in static mode, there's no such thing as an instance override
            nextProto = staticSuper ? this : this.getPrototype();
            //if (methodName == "draw") {
            //    this.logWarn("new Super call, method calling super: " +
            //                 this.echoLeaf(methodCallingSuper));
            //}
        } else {
            
            methodCallingSuper = isc.Class._getOriginalMethod(methodName, lastProto);

            if (staticSuper) {
                // static mode - get superclass classObject 
                nextProto = lastProto._superClass; 
            } else {
                // instance mode - get superclass instancePrototype
                nextProto = lastProto._classObject._superClass._instancePrototype;
            }

            
            if (nativeArguments && nativeArguments.callee != null && 
                nativeArguments.callee != methodCallingSuper) 
            {
                //this.logWarn("recursion detected: to continue current super chain caller" +
                //             " should be: " + this.echoLeaf(methodCallingSuper) + 
                //             " but caller is: " + this.echoLeaf(nativeArguments.callee));
                methodCallingSuper = isc.Class._getOriginalMethod(methodName, this);
                nextProto = staticSuper ? this : this.getPrototype();
            }
        }

        // count all calls to externalSuper
        //if (externalSuper) {
        //    var callCounts = isc._superCallCount = isc._superCallCount || [],
        //        fullName = isc.Func.getName(methodCallingSuper);
        //
        //    var record = callCounts.find("fullName", fullName);
        //    if (record) record.callCount++;
        //    else callCounts.add({fullName:fullName, callCount:1});
        //}

        //this.logWarn("methodCallingSuper: " + this.echoLeaf(methodCallingSuper) +
        //             ", lastProto: " + lastProto +
        //             ", nextProto: " + nextProto);

        // find the next superclass implementation
        nextProto = isc.Class._getNextImplementingSuper(methodCallingSuper, nextProto,
                                                        methodName, staticSuper);

        if (nextProto == null) {
            // failed to find a superclass implementation
            if (isc.Log) isc.Log.logWarn("Call to Super for method: " + methodName + 
                                         " failed on: " + this + 
                                         ": couldn't find a superclass implementation of : " +
                                         (lastProto ? lastProto.Class : this.Class) + 
                                         "." + methodName +
                                         this.getStackTrace());
            return null;
        }

        // we found a superclass implementation
        var superClassImpl = nextProto[methodName];

        //if (methodName == "draw") {
        //    this.logWarn("about to call: " + this.echoLeaf(superClassImpl) +    
        //                 ", call chain: " + superCallChains);
        //}

        
        isc.Class._addProto(methodName, nextProto, this);

        // NOTE: it's normal that we're invoke an indirect (an observation or timer for
        // instance), which will invoke the original method for us - it's just when comparing
        // methods that we have to avoid using the indirects
        //if (superClassImpl._origMethodSlot) {
        //    this.logWarn("invoking indirect: " + this.echoLeaf(superClassImpl) +
        //                 " found on prototype: " + nextProto);
        //}

		// call the superclass implementation on "this"
        var returnVal;
        if (externalSuper) {
            // for external callers, use apply() in order to preserve arguments.length just in
            // case external code contains a function that uses arguments.length and gets
            // called as Super
            if (nativeArguments) {
                returnVal = superClassImpl.apply(this, nativeArguments);
            } else {
                returnVal = superClassImpl.apply(this);
            }
        } else {
            returnVal = superClassImpl.call(this, a,b,c,d,e,f,g,h);
        }

        isc.Class._clearLastProto(methodName, this);

		// and return the value returned from the apply
		return returnVal;
	},

    _getLastProto : function (methodName, obj) {
        var superCalls = obj._superCalls,
            protoList = superCalls == null ? null : superCalls[methodName];

        //this.logWarn("for method: " + methodName + " chain is: " + protoList);

        if (isc.isAn.Array(protoList)) return protoList.last();
        return protoList;
    },

    _clearLastProto : function (methodName, obj) {
        var superCalls = obj._superCalls,
            protoList = superCalls[methodName];
        if (protoList == null) {
            
            return;
        }
        // clear single item
        if (!isc.isAn.Array(protoList)) {
            superCalls[methodName] = null;
        } else {
            // shorten array, then remove if zero length
            protoList.length = Math.max(0, protoList.length-1);
            if (protoList.length == 0) superCalls[methodName] = null;
        }
    },

    _addProto : function (methodName, newProto, obj) {
        var superCalls = obj._superCalls = obj._superCalls || {},
            protoList = superCalls[methodName];
        if (protoList == null) {
            superCalls[methodName] = newProto;
        } else {
            if (isc.isAn.Array(protoList)) protoList.add(newProto);
            else superCalls[methodName] = [protoList, newProto];
        }
    },

	//>	@classMethod Class.map()
	//
    // Call <code>method</code> on each item in <code>argsList</code> and return the Array of results.
    //
	//	@param	methodName (string)	
    //      Name of the method on this instance which should be called on each element of the Array
	//	@param	items      (Array)	
    //      Array of items to call the method on 
    //
	//	@return            (Array) Array of results, one per element in the passed "items" Array
	// @visibility external
    //<
    map : function (methodName, items, arg1, arg2, arg3, arg4, arg5) {
        if (methodName == null) return items;
        var results = [];
        for (var i = 0; i < items.length; i++) {
            results.add(this[methodName](items[i], arg1, arg2, arg3, arg4, arg5));
        }
        return results;
    },
    
	//>	@classMethod Class.getInstanceProperty()
	//
	//	Gets a named property from the instance defaults for this object.
	//
	//	@param property	(string)	name of the property to return
	// @visibility external
	//<
	getInstanceProperty : function (property) {
        var value = this._instancePrototype[property];
        
		return value;
	},

	//>	@classMethod Class.setInstanceProperty()
	//
	//	Sets a named property from the instance defaults for this object.
	//
	//	@param property	(string)	name of the property to return
	//	@param value	(any)		value to set to
	// @visibility external
	//<
	setInstanceProperty : function (property, value) {
		this._instancePrototype[property] = value;
	},

    getArgString : function (methodName) {
        // check for a string method definition
        var argString = this._stringMethodRegistry[methodName];
        var undef;
        if (argString !== undef) return argString || isc.emptyString;

        // get the arguments from the method definition (very very slow!)
        var method = this.getInstanceProperty(methodName);
        //if (method == null || !isc.isA.Function(method)) return "";
        if (method == null) return "";
        return isc.Func.getArgString(method);
    },
    
    // Callbacks and eval()ing
    // ---------------------------------------------------------------------------------------

    //> @type Callback
    // A <code>Callback</code> is an arbitrary action to be fired - usually passed into a 
    // method to be fired asynchronously as a notificaction of some event.<br>
    // The <code>callback</code> can be defined in the following formats:<ul>
    // <li>a function</li>
    // <li>A string containing an expression to evaluate</li>
    // <li>An object with the following properties:<br>
    //     - target: fire in the scope of this target - when the action fires,
    //       the target will be available as <code>this</code>.<br>
    //     - methodName: if specified we'll check for a method on the target object with this 
    //       name.<br>
    //  </li></ul>
    // <code>Callbacks</code> are fired via the +link{classMethod:Class.fireCallback()} method, which allows
    // named parameters to be passed into the callback at runtime. If the Callback was specified
    // as a string of script, these parameters are available as local variables at eval time.<br>
    // For specific SmartClient methods that make use of <code>Callback</code> objects, see
    // local documentation for information on parameters and scope.
    // @visibility external
    //<
    
    
    //>	@classMethod	Class.fireCallback()
	//
    // Fire some arbitrary action specified as a +link{type:Callback}.
    // Returns the value returned by the action.
    // 
	// @param callback (Callback) Action to fire.
    // @param [argNames] (string) Comma separated string of variable names. If the callback
    //                            passed in was a string of script, any arguments passed to the
    //                            callback will be available as local variables with these names.
    // @param [args] (array)    Array of arguments to pass to the mthod. Note that the number 
    //                          of arguments should match the number of argNames.
    // @param [target] (object) If specified the callback will be evaluated in the scope of this
    //                          object - the <code>this</code> keyword will be a pointer to this
    //                          target when the callback is fired.
    // @return (any)   returns the value returned by the callback method passed in.    
    // @visibility external
    //<
        
    fireCallback : function (callback, argNames, args, target, catchErrors) {
        arguments.__this = this;
        if (callback == null) return;
        
        
        var undef;
        if (argNames == null) argNames = undef;
        
        var method = callback;
        if (isc.isA.String(callback)) {
            // callback specified as the name of a method on a known target
            if (target != null && isc.isA.Function(target[callback])) method = target[callback];
            // callback is a String expression
            else method = this._makeCallbackFunction(callback, argNames);

        } else if (isc.isAn.Object(callback) && !isc.isA.Function(callback)) {
            // Object containing (possibly) target, and either methodName or action to fire

            if (callback.caller != null) target = callback.caller;
            else if (callback.target != null) target = callback.target;

            // Pick up arguments from the callback directly, if passed that way.
            if (callback.args) args = callback.args;
            if (callback.argNames) argNames = callback.argNames;
            
            if (callback.method) method = callback.method;

            
            else if (callback.methodName && target != null) method = target[callback.methodName];
            else if (callback.action) 
                method = this._makeCallbackFunction(callback.action, argNames);
        }

        // At this point the target (if one was passed in) is available under 'target', and
        // we've converted the callback to a function, if possible.
        if (!isc.isA.Function(method)) {
            this.logWarn("fireCallback() unable to convert callback: " + this.echo(callback) + 
                         " to a function.");
            return;
        }

        // If no target was specified, fire it in the global scope
        
        if (target == null) target = window;
        // If the target has been destroyed, abort!
        else if (target.destroyed) {    
            // NOTE: this isn't a warning scenario: destruction is normal, and callbacks are
            // commonly timers to do visual refreshes which don't matter if a component is
            // destroyed
            if (this.logIsInfoEnabled("callbacks")) {
                this.logInfo("aborting attempt to fire callback on destroyed target:"+ target + 
                             ". Callback:"+ isc.Log.echo(callback) +
                              ",\n stack:" + this.getStackTrace());
            }
            return;
        }

        // this causes anonymous callback functions to be labelled "callback" in stack traces.
        // Non-anonymous callbacks still show their usual name
        method._isCallback = true;

        if (args == null) args = [];

        
        
        if (isc.enableCrossWindowCallbacks && isc.Browser.isIE) {
            var targetWindow = target.constructor ? target.constructor._window : target;
            if (targetWindow && targetWindow != window && targetWindow.isc) {  
                var newArgs = targetWindow.Array.newInstance();
                for (var i = 0; i < args.length; i++) newArgs[i] = args[i];
                args = newArgs;
            }
        }

        var returnVal;
        
        if (!catchErrors || !isc.Browser.isMoz) {
           returnVal = method.apply(target, args);             
        } else {
        
            try {
                returnVal = method.apply(target, args);
            } catch (e) {
                isc.Log._reportJSError(e);
                
                throw e;;
            }
        }
        
        return returnVal;
    },        

    //> @classMethod Class.delayCall()
    //  This is a helper to delay a call to a method on some target by a specified
    //  amount of time.  Can be used to delay a call to a static method on this class by 
    //  ommiting the <code>target</code> parameter.
    // @param methodName (string) name of the method to call
    // @param [arrayArgs] (array) array of arguments to pass to the method in question
    // @param [time] (number) Number of ms to delay the call by - defaults to zero (so just pulls
    //                        execution of the method out of the current execution thread.
    // @param [target] (object) Target to fire the method on - if unspecified assume this is
    //                          a call to a classMethod on this Class.
    // @return (string) Timer ID for the delayed call - can be passed to 
    //                      +link{Timer.clear()} to cancel the call before it executes
    // @visibility external
    //<
    delayCall : function (methodName, arrayArgs, time, target) {            
        if (target == null) target = this;
        if (time == null) time = 0;

        return isc.Timer.setTimeout({target:target, methodName:methodName, args:arrayArgs}, time);
    },


    _makeCallbackFunction : function (callback, argNames) {
        
         
        //return isc.Func.expressionToFunction(argNames, callback);
        
        if (argNames == null) { 
            var undef;
            argNames = undef;
        }
        var func = isc._makeFunction(argNames, callback);
        func._showBodyInTrace = true;
        return func;
    },
    
 
    //>@classMethod Class.fireOnPause()
    // Given some repeatedly performed event (EG keypress, scroll, etc), set up an action
    // to fire when the events have stopped occurring for some set period.
    // @param id (string) arbitrary identifier for the action
    // @param callback (callback) action to fire on quiescence
    // @param [delay] (number) delay in ms - defaults to 200ms
    // @param [target] (object) if passed, the callback will be fired in this target's scope
    //<
    // additional instanceID parameter passed from instance method to support instance-level IDs
    fireOnPauseDelay:200,
    _$_fireActionsOnPause:"_fireActionsOnPause",
    _actionsOnPause:{},
    _actionOnPauseTimers:{},
    fireOnPause : function (id, callback, delay, target, instanceID) {

        if (!id) return;
        if (!delay) delay = this.fireOnPauseDelay;
        
        // Note: If we have two separate instances calling the fireOnPause instance method with
        // the same ID, both actions need to fire -- the ID is essentially unique within the
        // instance only.
        // We use the instanceID parameter to create separate callbacks for the same ID used
        // on different instances.
        // If unset, default to this.getClassName() [not legal to have any instance with the
        // same ID as a SmartClient class].
        if (instanceID == null) instanceID = this.getClassName();
        
        if (!this._actionsOnPause[id]) {
            this._actionsOnPause[id] = {};
        }

        this._actionsOnPause[id][instanceID] = 
            {fireTime:delay, callback:callback, target:target};
        
        var stamp = isc.timeStamp(),
            elapsed = this._lastFireOnPause ? stamp - this._lastFireOnPause : null;
        this._lastFireOnPause = stamp;
        
        // If we're going to fire queue of actions before the delay passed in, we're done
        if (elapsed && delay >= (this._fireOnPauseDelay - elapsed)) return;
        
        if (this._fireOnPauseTimer) isc.Timer.clearTimeout(this._fireOnPauseTimer);
        this._fireOnPauseTimer = this.delayCall(this._$_fireActionsOnPause,null, delay);
        
        this._fireOnPauseDelay = delay;
    },
    
    _fireActionsOnPause : function () {
        var fireAgainTime;
        // In theory this._fireOnPausedDelay ms have elapsed since the call to fireOnPause
        // (or the last call to this method).
        // In practice it's probably more accurate to check the elapsed time by comparing
        // timestamps
        var elapsed = isc.timeStamp() - this._lastFireOnPause,
            fireAgainTime;
        
        for (var id in this._actionsOnPause) {
            var actions = this._actionsOnPause[id];
            for (var iid in actions) {
                var action = actions[iid];           
                if (action.fireTime <= elapsed) {
                    this.fireCallback(action.callback, null, null, action.target);
                    delete this._actionsOnPause[id][iid];
                } else {
                    action.fireTime -= elapsed;
                    if (fireAgainTime == null) fireAgainTime = action.fireTime;
                    else fireAgainTime = Math.min(fireAgainTime, action.fireTime);
                }
            }
            if (isc.isAn.emptyObject(this._actionsOnPause[id])) delete this._actionsOnPause[id];
        }
        if (fireAgainTime != null) {
            this._fireOnPauseDelay = fireAgainTime;
            this._lastFireOnPause = isc.timeStamp();
            this.delayCall(this._$_fireActionsOnPause, null, fireAgainTime);
        } else {
            this._lastFireOnPause = null;
        }
    },
    
        

    //>	@classMethod	Class.evalWithVars()
	//
    // Evaluates the given string with an arbitrary number of arguments on the specified target.
    // evalVars and target are optional.
    // 
    // @param   evalString  the string to evaluate
    // @param   evalVars    Map of key-value pairs.  The keys are treated as argument names that are
    //                      then made available inside the eval body as variables.  The values of
    //                      these variables are the values assigned to the keys in evalVars.
    // @param   target      the target on which to apply the eval - it will be available as the
    //                      'this' variable inside the eval block.  If not specified, the evalString
    //                      is evaluated in global context.
    // @return  (any)       returns the result of eval(evalString)
    //<
    useFastEvalWithVars : isc.Browser.isMoz && isc.Browser.geckoVersion >= 20061010,
    evalWithVars : function (evalString, evalVars, target) {
        //!OBFUSCATEOK
        // if no target specified, eval in global scope
        if (!target) target = window;
    
        
        if (this.useFastEvalWithVars) {
            return this.evaluate.call(target, evalString, evalVars);
        }

        // create two arrays of the keys and values of the evalVars map
        var argNames = ["evalString"];
        var argValues = [evalString];
        if (evalVars) {
            for (var argName in evalVars) {
                argNames.push(argName);
                argValues.push(evalVars[argName]);
            }
        }
        
        // make a function with argNames as arguments that evals evalString
        
        var theFunc = isc._makeFunction(argNames.join(","), "return eval(evalString)");

        // call the function on the target
        return theFunc.apply(target, argValues);
    },

    // calls evalWithVars(jsSrc, evalVars, target), and returns all globals created via
    // addGlobalID().  All other non-explicit globals are captured by the function body that's
    // created around the jsSrc.
    evalWithCapture : function (jsSrc, evalVars, target) {
        var globals = isc.globalsSnapshot = [];
        //
        // we need to create a function with the jsSrc as the body to avoid creating extraneous
        // globals - conveniently evalWithVars already does this for us.
        this.evalWithVars(jsSrc, evalVars, target);
        isc.globalsSnapshot = null;
        return globals;
    },

    // takes a list of global IDs and destroys them
    destroyGlobals : function (globals) {
        if (!isc.isAn.Array(globals)) globals = [globals];

        for (var i = 0; i < globals.length; i++) {
            var global = globals[i];
    
            // call destroy() on the gloabl if it's defined
            if (window[global] && isc.isA.Function(window[global].destroy)) window[global].destroy();
            else window[global] = null; // otherwise just null out the global ref
        }
    },

    // Provides 'true' global eval - i.e. global vars actually stick to the window object when
    // eval'd in this manner vs a plain eval() which does not do that.  
    //
    // Note: the eval logic here (separate approaches to actually perform the eval per browser)
    // duplicates FileLoader.delayedEval() - if you change this code, be sure to update that 
    // method.
    // reportErrors optional param defaults to true
    globalEvalWithCapture : function (evalString, callback, evalVars, reportErrors) {
        if (reportErrors == null) reportErrors = true;
        //!OBFUSCATEOK 

        // store these on these object - really for Safari's benefit, since it's the only one
        // requiring async execution.  This makes the Safari case below easier.
        this._globalEvalVars = evalVars;
        this._globalEvalCallback = callback;        

        if (isc.Browser.isSafari) {            
            // This is the only mechanism that works for Safari.  This presents an extra
            // challenge for supporting globals capture and evalVars.
            evalString = "isc.Class._globalEvalWithCaptureStart();\n"
                         +evalString+"\nisc.Class._globalEvalWithCaptureEnd();";
            window.setTimeout(evalString,0);
            return;
        }

        this._globalEvalWithCaptureStart(evalVars);

        // If an error occurs during eval, capture it and pass it to the completion block to be
        // provided to the user callback.  
        var error;
        try {
            if (isc.Browser.isIE) {
                // Special IE only function that exports to global scope - can also be used to
                // execute VBScript code - no other mechanism is known to work
                window.execScript(evalString, "javascript");
            } else {          
                // pass in the 'globalScope' parameter so any defined vars get retained in global
                // scope after the eval
                isc.Class.evaluate(evalString, null, true);
            }
        } catch (e) {
            // If we have been asked to report errors, do so - also hang onto the error so
            // the callback can make use of it if necessary
            if (reportErrors) isc.Log._reportJSError(e);
            error = e;
        }

        this._globalEvalWithCaptureEnd(error);
    },

    _globalEvalWithCaptureStart : function () {     
        // evalVars must go onto the window object - make sure we don't overwrite existing
        // values by holding on to any conflicting refs so we can restore later
        var undef, evalVars = this._globalEvalVars;
        this._restoreGlobals = {};
        if (evalVars) {
            for (var evalVar in evalVars) {
                var globalValue = window[evalVar];
                // need to be careful to preserve nulls, zeroes - so check that the value is
                // actually undefined.
                if (globalValue !== undef) this._restoreGlobals[evalVar] = globalValue;
                window[evalVar] = evalVars[evalVar];
            }
        }

        // start globals capture
        isc.globalsSnapshot = [];
    },

    _globalEvalWithCaptureEnd : function (error) {
        // restore any conflicting globals and undefine any evalVars we set on the window object
        var undef, evalVars = this._globalEvalVars;
        if (evalVars) {
            for (var evalVar in evalVars) {
                var globalValue = this._restoreGlobals[evalVar];
                if (globalValue !== undef) window[evalVar] = this._restoreGlobals[evalVar];
                else window[evalVar] = undef; // can't delete window[evalVar] in IE!
            }
        }
        var callback = this._globalEvalCallback;
        var globals = isc.globalsSnapshot;        

        isc.globalsSnapshot = this._globalEvalCallback = this._globalEvalVars =
            this._restoreGlobals = null;
        this.fireCallback(callback, ["globals","error"], [globals, error]);
    },

    // _notifyFunctionComplete
    // Static method called when the notification function for some observed method completes.
    _notifyFunctionComplete : function (object, methodName, queue) {
        // Decrement the 'notifyStack' flag.
        // This flag tracks whether the observed function is currently being run.  We implement
        // this as a number indicating the depth of stacked calls to this method.
        
        queue._notifyStack -=1;
        // if the notifyStack is greater than zero the top level notificationFunction hasn't
        // yet exited, so don't proceed to modify observers.
        if (queue._notifyStack) return;
        
        var rebuildNotifyFunction = false;
        
        for (var i = 0; i < queue.length; i++) {
            // Clear any items that were 'ignored' while the notification function was running
            if (queue[i]._removedWhileNotificationRunning) {
                rebuildNotifyFunction = true;
                queue.removeItem(i);
                i--;
                continue;
            }

            // Clear any temp flags denoting observations set up while the notification function
            // was firing.
            if (queue[i]._addedWhileNotificationRunning) {
                delete queue[i]._addedWhileNotificationRunning;
                rebuildNotifyFunction = true;
            }
        }
        
        // If any observations were set up or cleared while the notify function was running,
        // rebuild the notification function now.
        if (rebuildNotifyFunction) {
        
 		    // If every observer has been cleared, restore the original function.
    		if (queue.length == 0) {
        		var saveMethodName = isc._obsPrefix+methodName;
		    	object[methodName] = object[saveMethodName];
			    // and clear the notification function slot.
    			delete object[saveMethodName];
	    	} else {
		        // Rebuild the notification function to fire the new set of observers
                object[methodName] = object._makeNotifyFunction(methodName, queue);
            }
        } 
    },

    // Arrays of definitions (TabBar tabs, Layout members, SectionStack sections, Wizard pages..)
    // ---------------------------------------------------------------------------------------
    _$ID : "ID",
    getArrayItem : function (id, array, idProperty) {
        if (array == null) return null;

        // String: assume id property of section descriptor object
        if (isc.isA.String(id)) return array.find(idProperty || this._$ID, id);

        // Object: return unchanged
        if (isc.isAn.Object(id)) return id;

        // Number: assume index
        if (isc.isA.Number(id)) return array[id];
    
        // otherwise invalid
        return null;
    },

    getArrayItemIndex : function (id, array, idProperty) {
        if (isc.isA.Number(id)) return id;

        var item = isc.Class.getArrayItem(id, array, idProperty);
        
        return array.indexOf(item);
    },
 
    // Getting DOM objects (going through these APIs makes cross-frame installation possible)   
    // ---------------------------------------------------------------------------------------
    
    getWindow : (
        isc.Browser.isSafari ? function () {
            return window; 
        } : function () {
            return this.ns._window;
        }
    ),
    getDocument : (
        isc.Browser.isSafari ? function () {
            return window.document;
        } : function () {
            return this.ns._document;
        }
    ),
    
    
    getDocumentBody : function (suppressDocElement) { 
        var getDocElement = (!suppressDocElement && isc.Browser.isIE && isc.Browser.isStrict);
        var body = (getDocElement ? this.ns._documentElement : this.ns._documentBody);
        if (body != null) return body;

        var doc = this.getDocument();
        if (getDocElement) {
            this.ns._documentElement = doc.documentElement;
            return this.ns._documentElement;
        }
        
        if (isc.Browser.isIE) {
            body = doc.body;
        } else {
            if (doc.body != null) body = doc.body;
            else {
                // XHTML: body not available via document.body (at least in FF 1.5)
                // Using the documentElement namespace future proofs us against future XHTML
                // versions
                var documentNS = doc.documentElement.namespaceURI;
                body = doc.getElementsByTagNameNS(documentNS, "body")[0];
                if (body == null) {
                    // XHTML: body not available via getElementsByTagNameNS() before page load
                    // in FF 1.5 (possibly others), but is available via DOM navigation
                    body = doc.documentElement.childNodes[1];
                    if (body != null && body.tagName != "body") body = null;
                }
                //this.logWarn("fetching body element: " + body);
                // don't cache failure to retrieve body, it should be available later until the
                // document is completely hosed
                if (!body) return null;
            }
        }
        this.ns._documentBody = body;
        return body;
    },
    getActiveElement : function () {
        
        try {
            return this.getDocument().activeElement;
        } catch (e) {
            this.logWarn("error accessing activeElement: " + e.message);
        }
        return null;
    }
	
});	// END addClassMethods(isc.Class)

isc.Class.addClassMethods({
    // synonym for backwards compatibility
    newInstance : isc.Class.create
});

// make the isc namespace available on all Class objects
isc.Class.ns = isc;

// retrofit the ClassFactory
isc.addProperties(isc.ClassFactory, {
    ns : isc,
    getWindow : isc.Class.getWindow,
    getDocument : isc.Class.getDocument
});

//
//	add methods to all instances of any Class or subclass
//
isc.Class.addMethods({
	//>	@method	class.init()	(A)
	//	
	// Initialize a new instance of this Class.  This method is called automatically by
    // +link{Class.create()}.  
    // <p>
    // Override this method to provide initialization logic for your class.  If your class is
    // a subclass of a UI component (i.e. descendant of +link{Canvas}), override
    // +link{canvas.initWidget()} instead. 
    //
    // @param	[arguments 0-N] (any)	All arguments initially passed to +link{Class.create()}
	//										
	// @visibility external
	//<
	init : function () {},

    // not generally required, but provided for consistency so that developers can call
    // destroy() without checking for it.
    destroy : function () { },

    //> @attr class.addPropertiesOnCreate (Boolean : undefined : A)
    //
    // Set this instance property to <code>false</code> on your class to prevent
    // +link{Class.create()} from requiring Object arguments and auto-applying all
    // properties from those arguments to the newly created class.
    // <P>
    //
    // <p>
    // Regardless of the setting for addPropertiesOnCreate property, all arguments passed to
    // +link{Class.create()} are still passed on to +link{Class.init()}.
    // <P>
    // Note that it is not valid to set <code>addPropertiesOnCreate</code> to false for any
    // subclass of +link{Canvas} (Canvas relies on this property).
    // <p>
    // Note: You must set this property on the class instance as part of the class definition
    // via +link{Class.addProperties()} so that it takes effect before +link{Class.create()} is
    // called.
    // 
    // @visibility external
    //<


    completeCreation : function (A,B,C,D,E,F,G,H,I,J,K,L,M) {
        if (this.addPropertiesOnCreate != false) {
            //>EditMode capture clean initialization data, and don't construct the actual
            // instance.  This is used to load a set of components for editing.  NOTE:
            // currently only applies to classes that addPropertiesOnCreate (which includes
            // all Canvas subclasses)
            if (isc.captureInitData) {
                var component = {
                    className : this.Class,
                    defaults : isc.addProperties({}, A,B,C,D,E,F,G,H,I,J,K,L,M)
                }
                if (!isc.capturedComponents) isc.capturedComponents = [];
                isc.capturedComponents.add(component);
                if (component.defaults.ID) {
                    isc.ClassFactory.addGlobalID(component, component.defaults.ID);
                    //isc.Log.logWarn("adding global component: " + component.defaults.ID);
                }
                return component;
            }
            //<EditMode

            isc.addProperties(this, A,B,C,D,E,F,G,H,I,J,K,L,M);
        }

		// call the init() routine on the new instance
	    this.init(A,B,C,D,E,F,G,H,I,J,K,L,M);
        return this;
    },

	//>	@method	class.getUniqueProperties
	//
	//	Gets all non-internal properties that are the different between this object and its
    //  prototype and returns a new object with those properties.
	//
	//	NOTE: this will also skip an object ID (object.ID) 
	//		if it starts with our auto-generated ID string ("isc_OID_")
	//
	//	NOTE: if your object points to some complex object, the clone will pick that up... :-(
	//
	//	@param	[returnProperties]	(object)	If passed in, properties will be added to this object.
	//											If not passed, a new object will be created.
	//	@return (Object)	unique properties for this object
	//<
    // NOTE: not external because lots of random state is picked up, and lots of important
    // state is discarded.
	getUniqueProperties : function (returnProperties) {
		if (returnProperties == null) returnProperties = {};
        
		var proto = this.getPrototype();
		
		for (var property in this) {
            // ignore internal properties
			if (property.startsWith("_")) continue;

            // ignore the namespace pointer installed on every instance
			if (property == "ns") continue;

            // ignore ID if it's auto-generated
			if (property == "ID" && this.ID.startsWith("isc_OID_")) continue;
            
            var value = this[property];

            // don't pick up functions (NOTE: we probably don't want to try to serialize
            // functions in general, or at least, that would be a very advanced and separate
            // serialization system.  Also, note that if we don't ignore functions, we'd pick
            // up observations since observations replace the original function)
            if (isc.isA.Function(value)) continue;

            // if the property still has the default value for the class, ignore it
			if (value != proto[property]) {
                /*
                if (proto[property] != null) {
                    this.logWarn("property: " + property + ": value " +
                                 this.echoLeaf(this[property]) + 
                                 " !== proto value " + 
                                 this.echoLeaf(proto[property]));
                }
                */
				returnProperties[property] = this[property];
			}
		}
		return returnProperties;
	},

	//>	@method	class.clone
	//
	// Make a clone of this instance.
	// Gets all non-internal properties that are the different between this object and its
    // prototype and creates a new instance with those properties
	//
	//	NOTE: if your object points to some complex object, the clone will pick that up... :-(
	//
	//	@return (Class)	clone of this class
	//<
    // NOTE: not external because this doesn't work for almost all widgets and has many issues
    // before it could be supported (eg what to do with shared data models?)
	clone : function () {
		return this.getClass().create(this.getUniqueProperties());
	},

    // NOTE: not external.  Need to define what this should do, eg, just a dump of state for
    // debugging vs recreate component in current state / transmit between browsers
	serialize : function (indent) {
		return isc.Comm.serialize(this, indent, null);
	},

	xmlSerialize : function (indent) {
		return isc.Comm.xmlSerialize(this.getClassName(), this, indent);
	},

	// get the fields 
	getSerializeableFields : function (removeFields, keepFields) {
		// see if we can obtain a schema for this class.  If a schema is available,
        // we'll use it to filter the set of fields that are serializeable.
        var schema = isc.DS ? isc.DS.getNearestSchema(this) : null;
		
		var uniqueProperties = this.getUniqueProperties();

		// instead of bailing out limit to simple types only?
		if (schema == null) {
			this.logDebug("No schema available for class" + this.getClassName());
			return uniqueProperties;
		} else {
			this.logDebug("Constraining serializeable fields for class: " + this.getClassName()
						  + " with schema : " + schema.ID);
		}

		// the list of valid fields is the intersection of datasource-declared fields and unique
		// properties.  This ensures that we don't pick up fields that are really internal
		// (e.g. starting with underscore)
		var serializeableFields = isc.applyMask(uniqueProperties, schema.getFields());
	
        // removeFields and keepFields are Arrays of fieldNames that subclasses can modify
        // before calling Super in order to suppress or keep fields
        removeFields = removeFields || [];
        keepFields = keepFields || [];

		// strip removeFields from the set of serializeable fields.
		removeFields.map(function(arg) { delete serializeableFields[arg]; });
		
		// ensure that the fields that specifically requested are in
		for (var i = 0; i < keepFields.length; i++) {
            serializeableFields[keepFields[i]] = this[keepFields[i]];
        }

		return serializeableFields;
	},

	//>	@method	class.getID()
	//			Return the global identifier for this object.
	//
	//		@return	(string)	global identifier for this canvas
	// @visibility external
	//<
	getID : function () {
		return this.ID;
	},

	//>	@method	class.getClass()
	//	
	//	Gets a pointer to the class object for this instance
	//
	//	@return (Class)		Class object that was used to construct this object
	// @visibility external
	//<
	getClass : function () {
		return this._classObject;
	},


	//>	@method	class.getSuperClass()
	//	
	//	Gets a pointer to the class object for this instance's superclass.
	//
	//	@return (Class)		Class object for superclass.
	// @visibility external
	//<
	getSuperClass : function () {
		return this._classObject._superClass;
	},


	//>	@method	class.getClassName()
	//	
	//	Gets the name of this class as a string.
	//
	//	@return	(string)	String name of this instance's Class object.
	// @visibility external
	//<
	getClassName : function () {
		return this.getClass().getClassName();
	},
	
	//>	@method	class.getPrototype()	(A)
	//
	//	Gets a pointer to the prototype of this instance.
	//
	//	@return (object)	prototype object for this instance
	//<
	getPrototype : function () {
		return this._prototype;
	},
	
	
	//>	@method	class.getGlobalReference()	(A)
	//
	//	Evaluate a reference in the global scope.  Within the eval,
	//		"this" will be a pointer to this instance.
	//
    //	@param	reference	(string)	String to get the reference from.  If anything other than
    //									 a string is passed in, simply returns reference.
	//	@return (reference)		reference to evaluate
	//<
	getGlobalReference : function (reference) {
        //!OBFUSCATEOK
		if (typeof reference == "string") return this.evaluate(reference);
		return reference;
	},
	
	//>	@method	class.addMethods()
	//
	//	Add methods to this specific instance.  These can either be completely new methods or can
	//	have the same name as existing methods, in which case the new methods will override the
	//	existing methods.
	//	
	// @param [arguments 0-N] (object)	Object containing name:method pairs to be added to this object
    // @return                (object)  the object after methods have been added to it
	// @visibility internal
	//<
        
	addMethods : function () {
        
		for (var i = 0; i < arguments.length; i++) {
            // call global addMethods()
			return isc.addMethods(this, arguments[i]);
        }
	},

	//>	@method	class.addProperties()
	//	
	// 	Add properties or methods to this specific instance.  
	//	Properties with the same name as existing properties will override.
	//
	//	@param	[arguments 0-N] (object)	Object containing name:value pairs to be added to this object
    //  @return                 (object)    the object after properties have been added to it
	// @visibility external
	//<
	addProperties : function () {
		return isc.addPropertyList(this, arguments);
	},
	
	//>	@method	class.addPropertyList()
	//
	//	Add properties to this instance.
	//
	//	@param	list (object[])		array of objects with properties to add
    //  @return                 (object)    the object after properties have been added to it
	// @visibility external
	//<
	addPropertyList : function (list) {
		return isc.addPropertyList(this, list);
	},

    // Get / Set with automatic getter/setter
    // ---------------------------------------------------------------------------------------
	
	//>	@method	class._getSetter()	(A)
	//
	//	Get the setter for a particular property, if one exists
	//
	//	@param	propertyName (string)	name of the property to find the setter for
	//									eg: if propertyName == "contents", setter == "setContents"
	//
	//	@return	(string)				name of the setter for the property, or null if none found
	//
	//<
	_getSetter : function (propertyName) {
		var functionName = "set" + propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
		return (isc.isA.Function(this[functionName]) ? functionName : null);
	},
	
	//>	@method	class._getGetter()	(A)
	//
	//	Get the getter for a particular property, if one exists
	//
	//	@param	propertyName (string)	name of the property to find the getter for
	//									eg: if propertyName == "contents", getter == "getContents"
	//
	//	@return	(string)				name of the getter for the property, or null if none found
	//
	//<
	_getGetter : function (propertyName) {
		var functionName = "get" + propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
		return (isc.isA.Function(this[functionName]) ? functionName : null);
	},
	
	//>	@method	class.setProperty()
    // Set a property on this object, calling the setter method if it exists.
    // <p>
    // Whenever you set a property on an ISC component, you should call either the specific setter
    // for that property, or <code>setProperty()/setProperties()</code> if it doesn't have one.
    // This future-proofs your code against the later addition of required setters.  
    //
    // @param propertyName (String) name of the property to set
    // @param newValue (any) new value for the property 
    // @see method:class.setProperties()
    // @visibility external
    //<
    setProperty : function (propertyName, newValue) {
        // NOTE: this is inefficient but unlikely to be called very often, and doing it this way
        // means subclasses can override just setProperties()
        var props = {};
        props[propertyName] = newValue;
        this.setProperties(props);
    },

	//>	@method	class.setProperties()
	// Set multiple properties on an object, calling the appropriate setter methods if any are
    // found.
    // <p>
    // Whenever you set a property on an ISC component, you should call either the specific setter
    // for that property, or <code>setProperty()/setProperties()</code> if it doesn't have one.
    // This future-proofs your code against the later addition of required setters.  
    // <p>
    // With <code>setProperties()</code> in particular, some classes may be able to take shortcuts
    // and be more efficient when 2 or more related properties are set at the same time.
    //
	//	@param	[arguments 0-N] (object)	objects with properties to add (think named parameters).
	//										all the properties of each argument will be applied one
    //										after another so later properties will override
    // @see method:class.setProperty()    
    //  @visibility external
	//<
	setProperties : function () {

        var isA = isc.isA,
            propertyBlock,
            additionalProps = {};

        // if not passed any properties arguments, just bail
        if (arguments.length < 1) return;
    
        // Iterate through the (possibly just one) properties, combining them into a single
        // object.  We do this to avoid duplicate calls to setters, although another approach
        // would be to keep a mask of the properties we've set, starting from the last argument
        // to the first.
        if (arguments.length == 1) {
            propertyBlock = arguments[0];
            if (propertyBlock == null) return;
        } else {
            propertyBlock = {};
                
            for (var i = 0; i< arguments.length; i++) {
                isc.addProperties(propertyBlock, arguments[i]);
            }
        }
        
        for (var propertyName in propertyBlock) {
            var value = propertyBlock[propertyName],
                setter = this._getSetter(propertyName);
            if (isc.isA.StringMethod(value)) value = value.getValue();
            //this.logWarn("setting property: " + propertyName + 
            //             " to value: " + this.echoLeaf(value) + 
            //             " via setter: " + this.echoLeaf(setter));
            if (setter) {
                this[setter](value);
                if (this.propertyChanged) this.propertyChanged(propertyName, value);
            } else {
                additionalProps[propertyName] = value;
            }      
        }
        // add any remaining properties via addProperties (will fall through to addMethods if
        // necessary)
        this.addProperties(additionalProps)
        
        // Fire the notification function for any properties that didn't have an explicit 
        // setter
        if (this.propertyChanged) {
            for (var propertyName in additionalProps) {
                this.propertyChanged(propertyName, additionalProps[propertyName]);
            }
        }
        
        // Fire any "doneSettingProperties()" - allows the instance to respond to multiple
        // related properties being set without having to respond to each one.
        if (this.doneSettingProperties) this.doneSettingProperties(propertyBlock);
	},
	
    getProperty : function (propName) {
        var getter = this._getGetter(propName);
        if (getter) return this[getter]();
        return this[propName];
    },

    //> @type Properties
    // When the type for a parameter mentions "properties" as in "ListGrid Properties" or
    // "RPCRequest Properties", it means that the expected value is a JavaScript Object
    // containing any set of properties generally legal when creating an object of that type.
    // <P>
    // For example, the first parameter of +link{RPCManager.sendRequest()} is of type
    // "RPCRequest Properties".  This means it should be called like:
    // <pre>
    //    isc.RPCManager.sendRequest({
    //        actionURL : "/foo.do",
    //        showPrompt:false
    //    });</pre>
    // +link{rpcRequest.actionURL,actionURL} and +link{rpcRequest.showPrompt,showPrompt} are 
    // properties of +link{RPCRequest}.  
    // <P>
    // Note that the notation shown above is an example of a
    // +link{type:ObjectLiteral,JavaScript object literal}.
    //
    // @visibility external
    //<

    //> @type ObjectLiteral
    // An "Object literal" is JavaScript shorthand for defining a JavaScript Object with a set
    // of properties.  For example, code like this:
    // <pre>
    //    var request = {
    //        actionURL : "/foo.do",
    //        showPrompt:false
    //    };</pre>
    // .. is equivalent to ..
    // <pre>
    //    var request = new Object();
    //    request.actionURL = "/foo.do";
    //    request.showPrompt = false;</pre>
    // In situations where a set of +link{type:Properties,properties} may be passed to a
    // method, the Object literal notation is much more compact.  For example:
    // <pre>
    //    isc.RPCManager.sendRequest({
    //        actionURL : "/foo.do",
    //        showPrompt:false
    //    });</pre>
    // <b>NOTE:</b> if you have a 'trailing comma' in an object literal, like so:
    // <pre>
    //    var request = {
    //        actionURL : "/foo.do",
    //        showPrompt:false, // TRAILING COMMA
    //    };</pre>
    // This is considered a syntax error by Internet Explorer, but not by Firefox.  This is by
    // far the #1 cause of Internet Explorer-specific errors that do not occur in other
    // browsers.  Pay special attention to this error, and, if you can, install the
    // JSSyntaxScannerFilter into your development environment (as described in the
    // +link{group:iscInstall,deployment instructions}).
    //
    // @visibility external
    //<

    // ---------------------------------------------------------------------------------------

    // useful for cascading defaults where 0 or "" is allowed so the pattern of 
    // "value1 || value2 || value3" won't work.
    
    _firstNonNull : function (a,b,c,d,e,f) {
        return a != null ? a : 
                (b != null ? b : 
                    (c != null ? c : 
                        (d != null ? d : 
                            (e != null ? e : f)
                        )
                    )
                );
    },   
	
	//>	@method	class.isA()
	//
	//	Returns whether this object is of a particular class by class name, either as a direct
	//	instance of that class or as subclass of that class, or by implementing an interface
    //  that has been mixed into the class.<br><br>
	//
	//	NOTE: this only applies to ISC's class system, eg:  <code>myInstance.isA("Object")</code> will be
    //	false.
	//
	//	@param	className	(string)	Class name to test against
	//
	//	@return				(boolean)	whether this object is of that Class 
    //                                  or a subClass of that Class
	// @visibility external
	//<
    isA : function (className) {
        return this.getClass().isA(className);
    },
    
    

    //> @groupDef stringMethods
    //
    // A method flagged as a String Method can be specified as a String containing a valid
    // JavaScript expression.  This expression will automatically be converted to a function with a
    // return value matching the value of the last statement.  Providing a String is not required -
    // you may use a real function instead.
    // <p>
    // For example - suppose you wanted to override the <code>leafClick()</code> method on
    // the TreeGrid.  Normally you would do so as follows:<br>
    //
    // <pre>
    // TreeGrid.create({
    //     ...
    //     leafClick : function(viewer, leaf, recordNum) { 
    //         if(leaf.name == 'zoo') { 
    //             alert(1); 
    //         } else {
    //             alert(2);
    //         }
    //     }
    // });
    // </pre>
    //
    // Since leafClick is a stringMethod, however, you can shorten this to:<br>
    // <pre>
    // TreeGrid.create({
    //     ...
    //     leafClick : "if(leaf.name == 'zoo') { alert(1); } else { alert(2); }";
    // });
    // </pre>
    //
    // @title String Methods Overview
    // @treeLocation Client Reference/System
    //<
    
    //> @groupDef flags
    //
    // <ul>
    // <li> <b>I</b>: property can be initialized (provided in constructor block)
    // <li> <b>R</b>: property can be read.  If a getter method exists, it must be called.
    // <li> <b>W</b>: property can be written to after initialization.  If a setter method
    // exists, it must be called.  If no setter method exists,
    // +link{Class.setProperty,setProperty()} must be called.
    // </ul>
    //
    // @title Flag Abbreviations
    //<
    


    // Observation
    // ---------------------------------------------------------------------------------------

    //> @groupDef observation
    // Observation is the ability to take an action whenever a method is called.
    // @title Observation
    //<
    
	//>	@method		class.observe()
	// Take an arbitrary action whenever a method is called on an instance.<br><br>
    //
	// When you observe some method of another object, eg:<br>
	//			<code>thisObject.observe(thatObject, "someMethod", "observer.foo()")</code><br><br>
	//
	// When <code>thatObject.someMethod()</code> is called,<br>
	//			<code>thisObject.foo()</code> <br>
	// will be called automatically, after the observed method completes.<br><br>
    //
    // Action is typically a string expression.  Available variables:
    // <ul>
    //    <li> observed: target of the observation, that is, object passed to observe()
    //    <li> observer: object that observes, that is, object that observe() was called on
    //    <li> returnVal: return value of observed function
    // </ul>
	//
	// An unlimited number of observers can observe any message, they will all be notified
	// automatically in the order that the observations were set up.<br><br>
    //
	// NOTES: 
    // - observation also works on JavaScript Array objects
    // - a method may trigger an observation of itself by another object, either through code 
    //   within the method itself or within an observer's action.  In this case the observation
    //   will be set up, but the new observation action will not fire as part of this thread.
    //   When the method is called again in the future the newly added observer will be fired.
    //
	//
	//		@param	object		(object)	object to observe
	//		@param	methodName	(string)	name of the method to observe
	//		@param	[action]	(string)	String for the function to call.
	//										In this string, 
	//											<code>observer</code> is the object that is observing, 
	//											<code>this</code> is the object that is being observed
	//
	//										If <code>action</code> is not specified, 
	//											<code>observer.methodName()</code> will be called.
	//
	//		@return	(boolean)	true == observation set up, false == observation not set up
    //      @see Class.ignore()
	//		@group	observation
	// @visibility external
	//<
    
    
	observe : function (object, methodName, action) {
        // if the object doesn't exist or doesn't implement a method with this name, return false to
		// indicate that the observation isn't going to work
		if (object == null) {
            //>DEBUG
            this.logWarn("Invalid observation: Target is not an object.  target: " + object + 
                         ", methodName: " + methodName + ", action: '" + action + "'");
            //<DEBUG
            return false;
        }
        
        // If this property is not a method, or a methodString, log a warning and return false
        //  Note: we're calling the static isc.Func.convertToMethod(...) as we know this 
        //  function exists and will return false if the object's class, and the object have 
        //   no methodStringRegistry.
        if (!isc.Func.convertToMethod(object, methodName)) {
            //>DEBUG
            this.logWarn("Invalid observation: property: '" + methodName + 
                         "' is not a method on " + object);
            //<DEBUG
            return false;
        }

        //this.logWarn("observing: " + methodName + " on " + object + " with action: " + action);
        
		// If this function has an obfuscated version, observe that also
		var obName = isc.__remap[methodName];
		if (object[obName]) this.observe(object, obName, action)

        // Now we're definitely working with a method
		var oldMethod = object[methodName], argStr;
        if (isc.isAn.Instance(object) && object.getClass().getInstanceProperty(methodName)) {
            argStr = object.getClass().getArgString(methodName);
        // NOTE: currently, there's no such thing as a classMethod that is a stringMethod
        } else {
            // this code path is needed for methods set in autoChildDefaults - handled by
            // the getInstanceProperty check above
            argStr = isc.Func.getArgString(oldMethod);
        }
        var args = argStr.split(",");

		//
		// add the observer and action to the object's observers list
		//
		
		// if there is no observers registry set up, create it.  
		// object._observers is { methodName : 
		//                           [{target:observingObject, action:codeString}]
		//                      }
		if (!object._observers) object._observers = {};

		// if there is not an observer queue for the method, create it
		if (!object._observers[methodName]) {
			var queue = object._observers[methodName] = [];
			if (args.length > 0) {
				// remember the args to the function for later
				queue.argStr = argStr;
			}
		// otherwise
		} else {
			// get the observer queue: the list of existing observers of this method
			var queue = object._observers[methodName];
			// see if this object is already observing this method
			for (var i = 0, len = queue.length; i < len; i++) {
				// if this object is found in the queue, return false since we're already observing
				// this method
				if (queue[i].target == this) {
                    if (queue[i]._removedWhileNotificationRunning) {
                        // special case: this observation was already ignored, but a re-
                        // observation is being done from inside the notified function.
                        // Disable _removedWhileNotificationRunning and update the
                        // action.
                        queue[i]._removedWhileNotificationRunning = false;
                        queue[i].action = action;
                        return true;
                    }
                    //>DEBUG
                    this.logWarn("Observer: " + this + " is already observing method '" + 
                                 methodName + "' on object '" + object + "', ignoring");
                    //<DEBUG
                    return false;
                }
			}
		}

		// if no action was defined, set it to call the method on the target
		if (action == null || isc.is.emptyString(action)) {
            if (!this[methodName] || !this.convertToMethod(methodName)){
                
                //>DEBUG
                this.logWarn("Invalid Observation - no action specified, and observer: " + this + 
                            " has no method '" + methodName + "', ignoring");
                //<DEBUG
                return false;

            }
			action = "it." + methodName + "(" + argStr + ")";
		}
        
        // Note whether we're currently running the notification function.
        
        var notificationRunning = queue._notifyStack;
        
		// add a reference to the observer to the observer queue for the method
		queue.add( { target:this, action:action,
                     // Track whether this method was added while the notification function was
                     // running - this allows us to avoid running this observer action until
                     // after the method has completed.
                     _addedWhileNotificationRunning:notificationRunning});
		
		
		// get the name we're going to hide the original method under.  NOTE: important to name
        // this with a leading underscore, so getUniqueProperties ignores it.
		var saveMethodName = isc._obsPrefix+methodName;
		// if the object already has a method by that name, the same method we're trying to
        // observe is being observed by someone else.  We'll both call the original method by
        // the same name.
		if (!object[saveMethodName]) object[saveMethodName] = oldMethod;

		// replace the observed method with a new function that will call the original method
        // then call all the observers
		if (!notificationRunning) object[methodName] = this._makeNotifyFunction(methodName, queue);
	
		// return true that everything went OK
		return true;
	},

	//>	@method		class._makeNotifyFunction()	(A)
	//		@group	observation
	//			make a hard-coded function to call the original method, then each recipient in turn
	//
	//		@param	methodName	(string)	name of the method to observe
	//		@param	queue		(object[])	list of observers
	//
	//		@return	(function)	new function to call when method is fired
	//<
    _makeNotifyFunction : function (methodName, queue) {
        //!DONTCOMBINE
        var script = isc.StringBuffer.create();
        // call the original function and remember it's return value
		script.append((isc._traceMarkers ? "arguments.__this=this;" : ""),
                      // grab the list of observers                        
                      "var queue=this._observers.", methodName, ";\r",
                      // Set a flag to show that the notification function is running.
                      // This is used by 'ignore' and 'observe' to avoid modifying the
                      // queue from under the notification function while it is firing.
                      // The flag will be cleared as part of Class.notifyFunctionComplete()
                      // Implemented as a number indicating the depth of potentially stacked
                      // notification function calls (caused by recursive calls to the same
                      // function).
                      "queue._notifyStack=queue._notifyStack?queue._notifyStack+1:1;\r",
                      "var returnVal=this.", isc._obsPrefix, methodName, "(",
                      (queue.argStr ? queue.argStr : ""), "),\r",
                      // create the "observed" local variable
                      "observed=this,observer,it;\r");

        // call each observer
		for (var i = 0, len = queue.length; i < len; i++) {
            
            // set up "observer" and "it" as variables that point to the observer
            // HACK: avoid crashing if we end up with an observation installed on an object
            // without the corresponding list of observers.  This can happen when we trace a
            // method on an entire class, in which case we install the observation method on
            // the instance prototype, but when the observation fires, it fires with each
            // individual instance's list of observers.
            script.append("if(!queue)return;\r");
			script.append("observer=it=queue[",i,"].target;\r");
            // fire the registered action
            if (isc.isA.String(queue[i].action)) script.append(queue[i].action,";\r");
            if (isc.isA.Function(queue[i].action)) {
            // if it's a function, call it in the scope of the observer
            script.append("queue[", i, "].action.apply(it, ",
                          (queue.argStr ? "'" + queue.argStr + "'" : "null"), ");\r");
            }    
		}	
        
        // Fire the 'complete' function - this will update any changes to observation made while
        // the notification function was running.
        
        if (isc.Browser.isSafari) {
            script.append("arguments.callee._ns.Class._notifyFunctionComplete(this,'",
                                                                    methodName,"',queue);\r");
        } else {
    		script.append("isc.Class._notifyFunctionComplete(this,'",methodName,"',queue);\r")
        }
        
        // return the value returned by the original function
        script.append("return returnVal;\r");

        var notifyFunc = isc._makeFunction(queue.argStr, script);
        notifyFunc._isObservation = true;
        notifyFunc._fullName = methodName + "Observation";
        notifyFunc._origMethodSlot = isc._obsPrefix + methodName;
        // hang a pointer to the correct isc object onto the function in Safari.
        if (isc.Browser.isSafari) notifyFunc._ns = isc;
        return notifyFunc;
	},

	//>	@method		class.ignore()	(A)
	//		Stop observing a method on some other object.
    //
	//		@param	object		(object)	object to observe
	//		@param	methodName	(string)	name of the method to observe
	//
	//		@return	(boolean)	true == observation stopped, false == no change made
    //      @see Class.observe()
	//		@group	observation
	// @visibility external
	//<
	ignore : function (object, methodName) {
		// also ignore the obfuscated version if present
		var obName = isc.__remap[methodName];
		if (object[obName]) this.ignore(object, obName);
		
		// get the name we would have squirreled the original method under
		var saveMethodName = isc._obsPrefix+methodName;
		// and if we can't find a method with that name, or the object has no observers
		//	return false to indicate that the object isn't currently being observed on this method
		if (!object[saveMethodName] || !object._observers) return false;

		// get a pointer to the message queue for the method
		var queue = object._observers[methodName],

            // Note: if the the observed function is currently being run, we want the observer
            // action to fire as normal in response to this thread, but not for subsequent 
            // calls to the observed method.
            // To achieve this, we flag the observer action, then clear it out of the queue 
            // when the observed method (actually the notification method) completes.
            
            notificationRunning = queue._notifyStack;
            

		// remove the object in the queue that points to this object
		for (var i = 0, len = queue.length; i < len; i++) {
			if (queue[i].target == this) {

                if (notificationRunning) 
                    queue[i]._removedWhileNotificationRunning = true;
                else
    				queue.removeAt(i);

				break;	
			}
		}

		// if we've removed everything from the queue
		// restore the original method
		if (queue.length == 0) {
			// restore the original function to its original name
			object[methodName] = object[saveMethodName];
			// clear the new method slot
			delete object[saveMethodName];
            // remove the observer queue
            delete object._observers[methodName];
		} else {
			// otherwise rebuild the notify method and store it under the original methodName
            // (If the notification function is currently running, avoid rebuilding it here -
            // we'll do this when it completes).
			if (!notificationRunning) {
                object[methodName] = this._makeNotifyFunction(methodName, queue);
            } 
		}
		
		// return true that everything went OK
		return true;
	},
	
	//>	@method		class.getObserversOf()	(A)
	//		@group	observation
	//			Return all targets observing a message of this object
	//
	//		@param	methodName	(string)	name of the method to observed
	//
	//		@return	(object[])	array of observing objects
	//<
	getObserversOf : function (methodName) {
		if (!this._observers || !this._observers[methodName]) return null;
		var queue = this._observers[methodName];
		for (var observers = [], i = 0; i < queue.length; i++) {
			observers[i] = (queue[i] ? queue[i].target : null);
		}
		return observers;
	},
	
	//>	@method		class.isObserving()	(A)
	//		@group	observation
	//		Return true if this object is already observing a method of another object
	//
	//		@param	object		(object)	object we may be observing
	//		@param	methodName	(string)	name of the method to observed
	//
	//		@return	(boolean)	true == already observing that method
	// @visibility external
	//<
	isObserving : function (object, methodName) {
		// if nothing is being observed on the object at all, forget it
		if (!object._observers) return false;
		
		// get the queue of observers of that method, bailing if none found
		var queue = object._observers[methodName];
		if (!queue) return false;
		
		// return true if we are one of the observers
		for (var i = 0; i < queue.length; i++) {
			if (queue[i].target == this) return true;
		}
		// otherwise return false 'cause we're not observing
		return false;
	},
    
	//>	@method	class.convertToMethod()
	//
	//	This takes the name of an instance property as a parameter, and (if legal) attempts to 
    //  convert the property to a function.
    //  If the property's value is a function already, or the property is registered via 
    //  class.registerStringMethods() as being a legitimate target to convert to a function, 
    //  return true.
    //  Otherwise return false
	//
	//	@param	functionName 	(string)	name of the property to convert to a string.
	//
	//	@return					(boolean)   false if this is not a function and cannot be converted
    //                                      to one
	//
	//<
    convertToMethod : function (methodName) {
        // accessor for isc.Func.convertToMethod, rather than duplicating that code
        return isc.Func.convertToMethod(this, methodName);
    },   
    
    //> @method class.evaluate()
    // 
    // Evaluate a string of script in the scope of this instance (so <code>this</code>
    // is available as a pointer to the instance).
    //
    // @param expression (string) the expression to be evaluated
    // @param evalArgs (object) Optional mapping of argument names to values - each key will
    //      be available as a local variable when the script is executed.
    // @return (any) the result of the eval
    // @see classMethod:Class.evaluate
    // @visibility external
    //<
    evaluate : function (expression, evalVars) {
        return isc.Class.evaluate.apply(this, [expression, evalVars]);
    },
    
    
	//>	@method	class.fireCallback()
	//
	//	Method to fire a callback. Callback will be fired in the scope of the object on 
    //  which this method is called.<br>
    //  Falls through to +link{classMethod:Class.fireCallback()}
	//
	//	@param	callback    (Callback) Callback to fire
    //  @param  [argNames]        (string)    comma separated string of variables
    //  @param  [args]            (array)     array of arguments to pass to the method
    //
    //  @return (any)   returns the value returned by the callback method passed in.
    //  @visibility external
	//<
    
    fireCallback : function (callback, argNames, args, catchErrors) {
        return isc.Class.fireCallback(callback, argNames, args, this, catchErrors);
    },
    
    //>@method class.delayCall()
    //  This is a helper to delay a call to some method on this object by some specified
    //  amount of time.
    // @param methodName (string) name of the method to call
    // @param [arrayArgs] (array) array of arguments to pass to the method in question
    // @param [time] (number) Number of ms to delay the call by - defaults to zero (so just pulls
    //                        execution of the method out of the current execution thread.
    // @return (string) Timer ID for the delayed call - can be passed to 
    //                      +link{Timer.clear()} to cancel the call before it executes
    // @visibility external
    //<
    delayCall : function (methodName, arrayArgs, time) {
        return isc.Class.delayCall(methodName, arrayArgs, time, this);
    },

    
    //>@method Class.fireOnPause()
    // Given some repeatedly performed event (EG keypress, scroll, etc), set up an action
    // to fire when the events have stopped occurring for some set period.
    // @param id (string) arbitrary identifier for the action
    // @param callback (callback) action to fire on quiescence
    // @param [delay] (number) delay in ms - defaults to 200ms
    //<
    fireOnPause : function (id, callback, delay) {
        return this.getClass().fireOnPause(id, callback, delay, this, this.getID());
    },
    
    
    //>	@method	class.evalWithVars()
	//
    // Same as the class method evalWithVars, but implicitly assigns the class on which this method
    // is called as the target.
    //
    // @see classMethod:Class.evalWithVars()
    //<
    evalWithVars : function (evalString, evalVars) {
        return isc.Class.evalWithVars(evalString, evalVars, this);
    },

    getWindow : (
        isc.Browser.isSafari ? function () {
            return window; 
        } : function () {
            return this.ns._window;
        }
    ),
    getDocument : (
        isc.Browser.isSafari ? function () {
            return window.document;
        } : function () {
            return this.ns._document;
        }
    ),
    getDocumentBody : function () { return isc.Class.getDocumentBody(); },
    getActiveElement : function () { return isc.Class.getActiveElement(); },
          
    // Auto Generated Named Children
    // ---------------------------------------------------------------------------------------
    // Subsystem for handling automatically creating the standard children of a compound widget
    // like a Window, which must create header, resizer, etc components.
    //  
    // Not fully worked out or mechanisms not documented:
    // - dynamic defaults
    //   - creation via Arrays of String like (window.headerControls) prevents dynamic defaults
    //     from being passed
    //     - could be solved by a registerDynamicDefaults(autoChildName, defaults)
    //   - no way for subclasses to override dynamically provided defaults
    //     - could be solved by a registerDynamicDefaults(autoChildName, defaults, this.Class), 
    //       where addAutoChild would traverse registered defaults in className order?
    //   - passthrough properties that are just renames should be declarative, not dynamic
    //     defaults.  Could have a special syntax, valid only for defaults, like:
    //        blahDefaults : {
    //           dataSource:"$creator.hiliteDS"
    //        }
    //     .. these defaults could be "compiled" to speed this up (cache prop names and
    //     assignment function).
    //   - super high-speed (createRaw()) creation
    //     - needs to be overridable (as with other dynamicDefaults), so not just a method in
    //       autoChildDefaults()
    //     - when overriding, don't want to have call Super
    //     - could use a pattern like [className]_configure_autoChildName(autoChild)?
    //     - _completeCreationWithDefaults() is an imperfect implementation of this.  
    // - tabs and sections
    //   - "autoChild:blah" achieves lazy creation, but not lazy creation of a hierarchy of
    //     components
    //     - NOTE: edge case: when a tabSet sees "autoChild:blah", the use case may be:
    //       - subclassing TabSet and adding autoChildren, in which case the defaults are found
    //         on the TabSet itself OR
    //       - using a TabSet as one of your autoChildren and creating tab.panes as other
    //         autoChildren, in which case the defaults are on the TabSet's creator.
    //       The TabSet tries to "guess" by looking at whichever widget has [autoChild]Defaults
    //   - tabs, fields, items, sections etc out of reach of autoChild-based configuration
    // - plug-ins
    //   - want
    // - requirement of calling changeDefaults() awkward
    //   - class.init would keep changeDefaults() calls from having to be done in global scope
    //   - could have a specially interpreted property like autoChildDefaults
    // - default way of adding children
    //   - we could have a property like "defaultAutoParent" in order to allow eg Window to
    //     specify that autoChildren are added to the body instead.  If so, we'd need
    //     autoParent:"creator" to mean add to creator despite defaultAutoParent.
    // - for high performance creation of many similar objects, need an API that you can call
    //   that collapses properties and then re-uses then, or possibly even dynamically creates
    //   an ISC Class
    // 
    // Internal (for now) usages
    // - providing dynamic properties via an override of
    //   getDynamicDefaults(autoChildName) in order to avoid manual calls to addAutoChild()
    // - widget.autoChildren can be an Array of autoChildren which will be created and added
    //   after initWidget().  This can be handy, but doesn't cleanly allow further subclassing
    //   as is
    //
    // - other best practices:
    //   - when defaults objects get very large consider replacing them with a class definition.
    //     This makes code faster since less properties are added on create(), however, it does
    //     make it less likely that application or patch code that tries to use a different
    //     constructor for that autoChild will succeed.  Splitting skinning-related properties
    //     into a class while retaining behavioral properties (like method overrides) is a good
    //     hedge.
    //
    // - cleanup
    //   - autoChildParentMap is obsoleted by autoParent setting and should be removed
    //   - _autoMaker functionality is probably obsoleted by getDynamicDefaults() and needs to
    //     be removed
    //   - several classes used the autoChild system before it was fully complete, and so have
    //     manual calls to createAutoChild() which are probably unnecessary
    //
    // - notes on design of this system
    //   - considered accepting just simple Strings as autoChild names anywhere Canvii are
    //     normally expected, eg tab.pane and section.items, but:
    //     - this conflicts with allowing globals to be specified as just a String in these
    //       spots.  Specifying strings for globals is actually useful for out-of-order
    //       creation, and when coming from XML, and is a likely newbie error when attempting
    //       to specify a global reference.  If we try to disambiguate via a check for eg
    //       [childName]Defaults and/or whether there is a global Canvas by that name, we still
    //       end up with weird cases where a global might surpress an autoChild or vice versa,
    //       like finding "footer" in window.items 
    //     - the String isn't a complete definition of the autoChild anwyay, as in the case of
    //       section.items, the appropriate creator may be the SectionStack or some yet higher
    //       level parent

    //> @type AutoChild
    // An autoChild is an automatically generated subcomponent that a component creates to
    // handle part of its presentation or functionality.
    // <P>
    // An example is the Window component and its subcomponent the "header".
    // <P>
    // AutoChildren support a standard set of properties that can be used to customize or skin
    // them.  The names of these properties are derived from the name of the autoChild itself.
    // These properties will generally not be separately documented for every autoChild unless
    // there are special usage instructions - the existance of the properties is implied
    // whenever you see an autoChild documented.
    // <P>
    // The properties are:
    // <dl>
    // <dt> <b>"show" + name</b> (eg showHeader)
    // <dd> Controls whether this autoChild should be created and shown at all.  Note that the
    // first letter of the autoChild name is uppercased for this property ("header" -> "Header").
    //
    // <dt> <b>name + "Properties"</b> (eg headerProperties)
    // <dd> Properties to apply to the autoChild created by this particular instance of the
    // parent component.  For example:
    // <pre>
    //        isc.Window.create({
    //            headerProperties: { layoutMargin : 10 }
    //        });
    // </pre>
    // Would apply a +link{layout.layoutMargin,layoutMargin} to the header of the Window,
    // increasing the empty space around the subcomponents of the header (buttons, title label,
    // etc).
    // <P>
    // Generally, *Properties is null.  <b>Do not</b> use the *Properties mechanism for
    // skinning.  See below. 
    //
    // <dt> <b>name + "Defaults"</b> (eg headerDefaults)
    // <dd> Defaults that will be applied to the autoChild in every instance of the parent
    // component.  *Defaults is used for skinning.  This property should never be set when
    // creating an instance of the parent component, as it will generally wipe out defaults
    // required for the component's operation.  Use +link{class.changeDefaults,changeDefaults}
    // to alter defaults instead, generally as part of a custom skin and/or custom component
    // creation - see the 
    // +link{group:autoChildren,overview of AutoChildren for component development} for details
    // and examples.
    // <dt> <b>name + "Constructor"</b> (eg headerConstructor)
    // <dd> SmartClient Class of the component to be created.  An advanced option, this
    // property should generally only be used when there is documentation encouraging you to do
    // so.  For example, the ListGrid offers the ability to use simple CSS-based headers or
    // more complex +link{StretchImg} based headers via
    // +link{listGrid.headerButtonConstructor}.  The constructor can also be specified using
    // the <code>_constructor</code> property in the defaults for the autoChild.
    // </dl>
    // The AutoChild system can be used to create both +link{canvas.children,direct children} 
    // and indirect children (children of children).  For example, the
    // +link{window.minimizeButton,minimizeButton} of the Window is also an autoChild, even
    // though it is actually located within the window header.
    // <P>
    // <h4>Skinning AutoChildren</h4>
    // <P>
    // Skinning autoChildren, done via +link{class.changeDefaults,changeDefaults()}, is done
    // for two purposes:
    // <ul>
    // <li> Changing the default appearance or behavior of a component, for example, making all
    // Window headers shorter
    // <li> Creating a customized variation of an existing component <i>while retaining the
    // base component unchanged</i>.  For example, creating a subclass of Window called
    // "PaletteWindow" with very compact appearance, while leaving the base Window class
    // unchanged so that warning dialogs and other core uses of Windows do not look like
    // PaletteWindows.
    // </ul>
    // The best code examples for skinning are in the load_skin.js file for the "SmartClient"
    // skin, in <code>isomorphic/skins/SmartClient/load_skin.js</code>.
    // <P>
    // <h4>Passthroughs (eg window.headerStyle)</h4>
    // <P>
    // In many cases a component will provide shortcuts to skinning or customizing its
    // autoChildren, such as +link{window.headerStyle}, which becomes header.styleName.  When
    // these shortcuts exist, they must be used instead of the more general autoChild skinning
    // system.
    // <P>
    // <h4>Safe Skinning</h4>
    // <P>
    // Before skinning an autoChild consider the 
    // +link{group:safeSkinning,safe skinning guidelines}.
    // <P>
    // <h4>Accessing AutoChildren Dynamically</h4>
    // <P>
    // For a component "Window" with an autoChild named "header", if you create a Window
    // with ID "myWindow", the header autoChild is available as "myWindow.header".
    // <P>
    // Unless documented otherwise, an autoChild should be considered an internal part of a
    // component.  Always configure autoChildren by APIs on the parent component when they
    // exist.  It makes sense to access an autoChild for troubleshooting purposes or for
    // workarounds, but in general, an autoChild's type, behavior, and internal structure are
    // subject to change without notice in future SmartClient versions.
    // <P>
    // Accessing an autoChild may give you a way to make a dynamic change to a component that
    // is not otherwise supported by the parent component (for example, changing a text label
    // where there is no setter on the parent).  Before using this approach, consider whether
    // simply recreating the parent component from scratch is a viable option - this approach
    // is more than fast enough for most smaller components, and will not create a reliance on
    // unsupported APIs.
    //
    // @group autoChildren
    // @visibility external
    //<
    
    //> @groupDef autoChildren
    // An autoChild is an automatically generated subcomponent that a component creates to
    // handle part of its presentation or functionality.
    // <P>
    // An example is the Window component and its subcomponent the "header".
    // <P>
    // AutoChildren support a standard set of properties that can be used to customize or skin
    // them.
    // <P>
    // This topic explains how to use the autoChild system when creating custom components in
    // order to create maximum flexibility.  To learn how to use the autoChild system with 
    // pre-existing components, +link{type:AutoChild,go here}.  
    // <P>
    // Before reading this topic, be sure you have read the +docTreeLink{QuickStart Guide}
    // material on creating custom components and have reviewed the provided examples.
    // <P>
    // <h3>Basics</h3>
    // <P>
    // The following is an example of creating subcomponents <b>without</b> using the AutoChild
    // pattern.  In this case a fictitious "Portlet" class is being created, which uses an
    // instance of isc.Label to serve as it's header.
    // <pre>
    // isc.defineClass("Portlet", "VLayout").addProperties({
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         this.headerLabel = isc.Label.create({
    //             autoDraw:false,
    //             contents: this.title, 
    //             styleName: this.titleStyleName,
    //             portlet:this,
    //             click : function () { this.portlet.bringToFront() },
    //             wrap:false,  
    //             overflow:"hidden", 
    //             width:"100%"
    //         });
    //         this.addMember(this.headerLabel);
    //         ...
    // </pre>
    // While straightforward, this approach provides limited flexibility to someone using the
    // "Portlet" class.  There is no way to:
    // <ol>
    // <li> avoid creating the headerLabel, for a "headerless" portlet
    // <li> use a different, more advanced class as a header (eg, StretchImgButton or a custom 
    // class)
    // <li> skin the headerLabel, other than CSS (rounded corners, animations, etc, wouldn't be
    // possible)
    // <li> change it's layout behavior (eg enable autoSize)
    // <li> add or override event handlers
    // </ol>
    // Let's imagine we wanted to add some of the above features.  We could change the code
    // like so:
    // <P>
    // <pre>
    // isc.defineClass("Portlet", "VLayout").addProperties({
    //     <b>showHeaderLabel:true,</b>
    //     <b>headerLabelConstructor:isc.Label,</b>
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         <b>if (this.showHeaderLabel) {</b>
    //             this.headerLabel = this.headerLabelConstructor.create({
    //                 autoDraw:false,
    //                 contents: this.title, 
    //                 styleName: this.titleStyleName,
    //                 portlet:this,
    //                 click : function () { this.portlet.bringToFront() },
    //                 wrap:false,  
    //                 overflow:"hidden", 
    //                 width:"100%"
    //             }<b>, this.headerLabelProperties</b>);
    //             this.addMember(this.headerLabel);
    //         <b>}</b>
    //         ...
    // </pre>
    // Our additions solve our initial concerns:
    // <ul>
    // <li> <code>showHeaderLabel:false</code> can be set to suppress the header label
    // <li> <code>headerLabelConstructor</code> allows you to switch to a different class
    // <li> <code>headerLabelProperties</code> give you a means to add arbitrary properties
    // (skinning properties, sizing properties, event handlers, etc)
    // </ul>
    // However, the code is becoming more verbose and repetitive, and we've created a few
    // additional properties that now need documentation and testing.  This extra work is going
    // to be multiplied by every subcomponent we create where we want this kind of flexibility.
    // <P>
    // Enter the AutoChild system: the purpose of the AutoChild system is to define a standard
    // pattern for creating subcomponents with maximum flexibility.  This means:
    // <ul>
    // <li> developers creating custom components write less code, have less to test and less
    // to document
    // <li> developers can more easily understand each other's code for custom components,
    // because it follows a standard pattern
    // <li> developers <b>using</b> custom components have a standard pattern for
    // customization, instead of learning customization APIs for every component separately
    // </ul>
    // The code below uses the autoChild system to create the "headerLabel" subcomponent.  This
    // version of the code would still respect all of the customization properties from earlier
    // examples (<code>headerLabelProperties</code> et al) and offers several additional degrees
    // of flexibility still to be explained, yet it's significantly shorter.  More importantly,
    // this code is less redundant; the "boilerplate" code is gone and what's left is just the
    // actual settings for the headerLabel subcomponent.
    // <pre>
    // isc.defineClass("Portlet", "VLayout").addProperties({
    //     headerLabelDefaults : {
    //         _constructor:isc.Label,
    //         click : function () { this.creator.bringToFront() },
    //         wrap:false,  
    //         overflow:"hidden", 
    //         width:"100%"
    //     },
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         this.addAutoChild("headerLabel", {
    //             contents: this.title, 
    //             styleName: this.titleStyleName
    //         });
    //         ...
    // </pre>
    // <P>
    // The documentation for +link{class.addAutoChild,addAutoChild()} explains why this code
    // will still respect the <code>showHeaderLabel</code> flag and other customization
    // properties even though they aren't mentioned specifically.
    // <P>
    // <h3>Subclassing a component with autoChildren</h3>
    // <P>
    // If you are subclassing a component that has an autoChild and you want to change
    // defaults for that autoChild, the correct way to do so is to use
    // +link{Class.changeDefaults,changeDefaults()}:
    // <pre>
    // isc.defineClass("MyWindow", "Window");
    // isc.MyWindow.changeDefaults("headerDefaults", { layoutMargin:10 });
    // isc.MyWindow.addProperties({ 
    //    ...
    // </pre>
    // <P>
    // <code>changeDefaults()</code> creates a copy of the superclass defaults and applies your
    // changes, which is important because you want to inherit the superclass behavior without
    // affecting the superclass, and yet apply overrides.
    // <P>
    // The following code sample indicates two common 
    // <span style="color:red;font-weight:bold">incorrect</span> patterns for working with
    // defaults, and the consequences of each: 
    // <pre>
    // isc.defineClass("MyWindow", "Window").addProperties({
    //     // NO.  Superclass behavior / settings for autoChild
    //     // won't be inherited.  Use changeDefaults() instead.
    //     headerDefaults : { ... },
    // 
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         // NO.  "headerDefaults" object is shared across the class,
    //         // changing it affects all instances created from here on.
    //         // Pass dynamic defaults to addAutoChild() instead
    //         this.headerDefaults.myProperty = this.newValue;
    //         ...
    // });
    // </pre>
    // <b>defaults vs properties</b>
    // <P>
    // For AutoChildren, defaults and properties both provide similar means of adding
    // properties to an AutoChild, and the distinction between them is primarily one of
    // convention: a class that uses AutoChildren should never define a default value for
    // <i>autoChildName</i>Properties, so that instances can freely specify
    // <i>autoChildName</i>Properties without overriding built-in behavior.
    // <pre>
    // isc.defineClass("MyWindow", "Window").addProperties({
    //     // NO.  Any further use of "headerProperties", in
    //     // instances or in subclasses, would wipe out behavior
    //     headerProperties : { ... },
    // </pre>
    // <P>
    // By consistently using +link{Class.changeDefaults()} whenever you override autoChild
    // defaults in a subclass, you ensure that your classes can in turn be subclassed and
    // extended uniformly.
    // <P>
    // <h3>autoParents and creation order</h3>
    // <P>
    // The AutoChild pattern can create an entire hierarchy of generated subcomponents.  For
    // example, the +link{Window} class included with SmartClient uses several AutoChildren as
    // part of the overall header structure: separate autoChildren for the minimize button,
    // close button, and then the header itself, a Layout-derived class that contains all other
    // header controls. 
    // <P>
    // To facilitate construction of hierarchies of autoChildren, the special
    // <code>autoParent</code> property may appear in either defaults or properties for an
    // autoChild, and indicates the name of another autoChild that should used as a parent.
    // For example, to create a "closeButton" autoChild that will be a member of the "header"
    // autoChild:
    // <P>
    // <pre>
    // isc.defineClass("Portlet", "VLayout").addProperties({
    //     headerDefaults : {
    //         _constructor:isc.HLayout,
    //         ...
    //     },
    //     closeButtonDefaults : {
    //         <b>autoParent:"header",</b>
    //         _constructor:isc.ImgButton,
    //         ...
    //     },
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         this.addAutoChild("header");
    //         this.addAutoChild("closeButton");
    //         ...
    // </pre>
    // <P>
    // In addition to cutting down on code and making inter-autoChild relationships clearer,
    // using <code>autoParent</code> rather than manual calls to addMember() allows a
    // subclass of your component to potentially completely rearrange the autoChildren you have
    // defined, while retaining their behavior.
    // <P>
    // When using <code>autoParent</code> to arrange autoChildren, create parents first, then
    // children.
    // <P>
    // <b>Tip:</b> if you want all of the behaviors of
    // +link{class.addAutoChild(),addAutoChild()} <i>except</i> automatically adding the
    // autoChild to a parent, set <code>autoParent:"none"</code>.
    // <P>
    // <b>special case: TabSets and SectionStacks</b>
    // <p>
    // An autoChild that appears as a +link{tab.pane} or
    // +link{SectionStackSection.items,section item} does not have a clear way to refer to it's
    // tab or section via the <code>autoParent</code> property.  For this special case, the
    // TabSet and SectionStack components allow tab.pane / section.items to contain the special
    // string "autoChild:<i>autoChildName</i>".  This will cause the corresponding autoChild to be
    // automatically created when the tab is selected or section expanded.
    // <P>
    // For example:
    // <pre>
    // isc.defineClass("Portlet", "VLayout").addProperties({
    //     ...
    //     mainTabsDefaults : {
    //         _constructor:isc.TabSet,
    //         tabs : [
    //             { title:"First Pane", pane:"autoChild:firstPane" }
    //         ]
    //     },
    //     firstPaneDefaults : {
    //         ...
    //     },
    //     initWidget : function () {
    //         this.Super("initWidget", arguments);
    //
    //         // this automatically creates firstPane as an autoChild
    //         this.addAutoChild("mainTabs");
    //         ...
    // </pre>
    //
    // @visibility external
    //<

    // break this discussion into safe skinning (visuals only) and safe customization
    // (subclasses and autoChildren)?
    //> @groupDef safeSkinning
    // The skinning mechanism is extremely powerful and gives you the ability to change
    // internal functionality of components.  While this is useful for workarounds, you should
    // think through any properties you override, considering what will happen with future
    // versions of SmartClient, where the defaults may change or be expanded.
    // <P>
    // The following kinds of overrides are generally very safe:
    // <ul>
    // <li> Change +link{canvas.styleName,styleName} or +link{button.baseStyle,baseStyle} to
    // provide a custom CSS style or series of styles
    // <li> Change a media path such as the +link{Img.src,src} of the 
    // +link{Window.minimizeButton}.
    // <li> Change the size of any part of the UI that has a fixed pixel size, such as
    // the height and width of the +link{Window.minimizeButton}, especially when this is done
    // to match the size of media you have created
    // <li> Set properties such as +link{button.showRollOver} that cause a component to
    // visually react to more or fewer UI states (disabled, over, down, etc)
    // </ul>
    // The following should be very carefully considered:
    // <ul>
    // <li> Adding custom behaviors by passing in event handlers such as 
    // (eg +link{canvas.showContextMenu,showContextMenu()}).  If future versions of the
    // component add more functionality, you may prevent new features from functioning, cause
    // them to function only partially, or break.
    // <P>
    // If you want to ensure that you do not break new functionality added in future SmartClient
    // versions, be sure to call +link{class.Super,Super()} for methods you override, and do not
    // prevent events from bubbling.
    // <P>
    // If you want to ensure that <b>only</b> your custom behavior is used if a future version
    // of a SmartClient component adds functionality, override all methods involved in the
    // interaction, even if your methods do nothing.  For example, for a custom drop
    // interaction, override dropOver, dropMove, dropOut and drop, even if you do nothing on
    // dropMove().  Then, do not call Super() if there is no superclass behavior required for
    // the interaction you've implemented.  Also, for any event handlers (such as drop())
    // return false if you consider your code to have completely handled the event (no
    // parent component should react).
    // </ul>
    // The following are not recommended:
    // <ul>
    // <li> Providing a global +link{Canvas.ID,ID} to a subcomponent (only works once).
    // <li> Overriding +link{canvas.backgroundColor}, +link{canvas.border,border},
    // +link{canvas.margin,margin}, +link{canvas.padding,padding}, or in general any single
    // attribute otherwise controlled by CSS.  Future SmartClient versions may change the base
    // CSS style, rendering your single-property customization senseless.  Change the entire
    // CSS style via +link{canvas.styleName,styleName} instead.
    // </ul>
    //
    // @title Safe Skinning
    // @visibility external
    //<

    addAutoChildren : function (children, parent, position) {
        if (children == null) return;
        if (!isc.isAn.Array(children)) children = [children];
        for (var i = 0; i < children.length; i++) {
            var child = children[i];
            if (isc.isA.Canvas(child)) {
                parent = parent || this;
                this._addAutoChildToParent(child, parent, position);
                continue;
            }
            // string name, or block of properties specifying an autoChild
            this.addAutoChild(child, null, null, parent, position);
        }
    },

    //> @method class.addAutoChild()
    // Creates a component according to the "AutoChild" pattern, and adds it to this component.
    // <P>
    // See the +link{group:autoChildren,AutoChild usage overview} to understand the general
    // purpose and usage of this method.
    // <P>
    // <code>addAutoChild()</code> takes the following actions:
    // <ol>
    // <li> checks whether this.<i>autoChildName</i> is already populated, and returns it if so
    // <li> checks when there is a show<i>AutoChildName</i> with the value false, and if so
    // returns without creating a component  
    // <li> calls +link{createAutoChild()} to create the component
    // <li> sets this.<i>autoChildName</i> to the created component
    // <li> adds the component either to this component, or to some other parent, specified
    // by the "autoParent" property in the autoChild's defaults.  The "autoParent" property may
    // be "none" indicating the autoChild should not be automatically added.
    // </ol>
    // <P>
    // When adding an autoChild to a +link{Layout} subclass,
    // +link{layout.addMember,addMember()} will be called instead of the normal
    // +link{Canvas.addChild,addChild()}.  To prevent this behavior,
    // <code>addAsChild:true</code> can be set in the autoChild defaults.  Similarly,
    // <code>addAsPeer:true</code> may be set to add an autoChild as a peer.
    // <P>
    // <b>Tip:</b> because <code>addAutoChild()</code>
    // checks specifically for show<i>AutoChildName</i>:false, you do not have to add
    // show<i>AutoChildName</i>:true in order for an autoChild to be shown by default; leaving
    // the property undefined is sufficient.
    // 
    // @param childName (String) name of the autoChild
    // @param defaults (Properties) dynamic properties for the autoChild
    // @return (Class) created autoChild
    //
    // @group autoChildren
    // @visibility external
    //<
    _$maker:"_autoMaker",
    addAutoChild : function (childName, dynamicProperties, defaultConstructor, parent, position) {
        var childValue = this[childName];
        // already created
        if (isc.isAn.Instance(childValue)) return childValue;
        
        // We want a central list of all our 'autoChildren' so we can easily iterate through them
        if (!this._createdAutoChildren) this._createdAutoChildren = {};
        this._createdAutoChildren[childName] = true;

        // allow a properties object with autoChildName etc
        if (isc.isAn.Object(childName) && childName.autoChildName) {
            dynamicProperties = childName;
            defaultConstructor = dynamicProperties._constructor || defaultConstructor;
            childName = dynamicProperties.autoChildName;
        }

        // check to see if the value of the childName property is a string that is the global
        // ID of an existing instance (like { header : "myPreviouslyCreatedHeader" })
        if (isc.isA.String(childValue) && window[childValue]) {
            this[childName] = window[childValue];
            return this[childName];
        }

        // check flags, and existance of parents, before proceeding to create the child
        // NOTE: null check allows constructor blocks for unnamed autoChildren (automatically
        // created, but not skinnable)
        if (childName != null && !this.shouldCreateChild(childName)) return;

        // create the child
        // XXX autoMaker functionality is considered legacy; getDynamicDefaults() is believed
        // to handle all cases for which autoMaker was intended, and more cleanly
        // If this[childName]_autoMaker() is defined, call that to make the child, rather than 
        // 'createAutoChild()'
        
        var child,
            makerName = childName + this._$maker;
    
        if (childName != null && this[makerName]) child = this[makerName](dynamicProperties);
        else {
            child = this.createAutoChild(childName, dynamicProperties, defaultConstructor, true);
        }
        
        // createAutoChild() may return null if we're not configured to create this child.
        // A custom maker function may return null if it wants to handle adding the child to
        // the appropriate parent itself (and assinging the child to the appropriate property
        // name)
        if (!child) return; 

        this[childName] = child;

        this._addToParent(childName, child, parent, position);

        return child;
    },

    _$creator:"creator",
    _addToParent : function (childName, child, parent, position) {
        // ways of specifying parent, in order of preference
        // - pass into addAutoChild / createAutoChild (becomes parent param here)
        // - as child.autoParent, for any source of properties
        // - define this.autoChildParentMap
        // - finally, "this" assumed
        if (parent == null) {
            parent = child.autoParent || this.getAutoChildParent(childName);
        }
        if (isc.isA.String(parent)) {
            // constant meaning no parent, eg, pop-up dialog
            if (parent == isc.Canvas.NONE) {
                if (this.isDrawn()) child.draw();
                return; 
            }
        
            var canvasParent = this[parent] || window[parent] || parent;
            if (!isc.isA.Canvas(canvasParent)) {
                this.logWarn("no valid parent could be found for String '" + parent + "'");
            } else parent = canvasParent;
        }

        // do nothing if the created child is not a Canvas or derived parent isn't a canvas.
        if (!isc.isA.Canvas(child) || !isc.isA.Canvas(parent)) return;
    
        this._addAutoChildToParent(child, parent, position);
    },

    _addAutoChildToParent : function (child, parent, position) {
        // add to parent, as member or child
		if (child.addAsPeer || child.snapEdge) parent.addPeer(child);
        else if (isc.isA.Layout(parent) && !child.addAsChild && !child.snapTo) parent.addMember(child, position);
        
        else parent.addChild(child);
    },

    // defaults to creating child if this.show[ChildName] isn't explicitly set to false.  If the
    // child is declared to have a named parent, checks that the parent will be created too
    _$show : "show", 
    shouldCreateChild : function (childName) {
        var showProperty = this._$show + childName.charAt(0).toUpperCase() + childName.substring(1);
        if (this[showProperty] != null && this[showProperty] == false) return false;

        // check whether the parent will be created
        var parentName = this._getAutoChildParentName(childName);
        if (parentName == null) return true;
        return (this.shouldCreateChild(parentName));
    },

    _$Constructor: "Constructor",
    // Determine what class the child should be.
    // - If there is an explicit [childName]Constructor property, use that specified class
    // - If the properties include an _constructor attribute, use that class
    // - Otherwise use the defaultConstructor passed in 
    // - (back off to canvas if we failed to find a class)
    getAutoChildClass : function (childName, dynamicProperties, defaultConstructor,
                                  childDefaultsName, childPropertiesName) {
        // use childDefaultsName if passed, so it doesn't have to be recalc'd
        childDefaultsName = childDefaultsName || this._getDefaultsName(childName);
        var childDefaults = this[childDefaultsName];
        
        childPropertiesName = childPropertiesName || this._getPropertiesName(childName);
        var childProperties = this[childPropertiesName];

        return this[childName + this._$Constructor] || 
               (dynamicProperties ? dynamicProperties._constructor : null) || 
               (childProperties ? childProperties._constructor : null) || 
               (childDefaults ? childDefaults._constructor : null) || 
               defaultConstructor || isc.Canvas;
    },

    // get defaults for all auto children
    applyBaseDefaults : function (child, childName, dynamicDefaults) {
        child.autoDraw = false;
        child._generated = true;

        // special "creator" property obviates the need to pass "window:this" et al dynamically
        child.creator = this;
        // ability to rename the "creator" pointer for clarity
        var creatorName = this.creatorName;
        if (creatorName) child[creatorName] = this;

        // generate an ID for the autoChild based on it's name.  NOTE: can be suppressed by
        // passing ID:null in dynamicProperties
        var undef;
        if (dynamicDefaults == null || dynamicDefaults.ID === undef) {
            child.ID = this.getID() + isc._underscore + childName;
            // if the defaultID collides, uniquify it.  This allows createAutoChild() to be
            // called multiple times on the same config block
            if (window[child.ID]) {
                child.ID = child.ID + isc._underscore + isc.ClassFactory.getNextGlobalID();
            }
        }
    },

    getDynamicDefaults : function () {},

    _$Defaults: "Defaults",
    _getDefaultsName : function (childName) {
        var cache = isc.Class._defaultsCache;
        if (!cache) isc.Class._defaultsCache = cache = {};
    
        if (cache[childName]) return cache[childName];
        
        var defaultsName = childName + this._$Defaults;
        if (this[defaultsName]) cache[childName] = defaultsName;
        return defaultsName;
    },

    _$Properties: "Properties",
    _getPropertiesName : function (childName) {
        var cache = isc.Class._propertiesCache;
        if (!cache) isc.Class._propertiesCache = cache = {};
    
        if (cache[childName]) return cache[childName];
        
        var propertiesName = childName + this._$Properties;
        if (this[propertiesName]) cache[childName] = propertiesName;
        return propertiesName;
    },

    //> @method class.createAutoChild()
    // Unconditionally creates and returns a component created according to the "AutoChild"
    // pattern.
    // <P>
    // In addition to applying defaults and properties as described under the
    // +link{type:AutoChild,AutoChild overview}, the created autoChild:
    // <ul>
    // <li> is automatically <code>autoDraw:false</code> 
    // <li> has a <code>creator</code> property that points to this component, for easy
    // authoring of event handlers (eg click:"this.creator.doSomething()")
    // </ul>
    // <P>
    // Unlike +link{addAutoChild()}, <code>createAutoChild()</code> does not create a
    // this.<i>autoChildName</i> reference to the component, check a show<i>AutoChildName</i>
    // flag, or automatically add the autoChild via +link{Canvas.addChild()}.  
    // <P>
    // General you use <code>createAutoChild</code> rather than addAutoChild when:
    // <ul>
    // <li> you are going to create several autoChildren with a common set of defaults (for
    // example the +link{columnTree.column,column} autoChild of the +link{ColumnTree}).
    // <li> children need to be created before their parents (eg, for layout/auto-sizing
    // reasons)
    // </ul>
    //
    // @param childName (String) name of the autoChild
    // @param defaults (Properties) dynamic properties for the autoChild
    // @return (Class) created autoChild
    //
    // @group autoChildren
    // @visibility external
    //<
    createAutoChild : function (childName, passedDynamicDefaults, defaultConstructor,
                                assignToSlot) 
    {
        var dynamicDefaults = this.getDynamicDefaults(childName);

        // NOTE: dynamicDefaults: generally, you will *either* pass dynamic defaults to
        // addAutoChild() *or* implement getDynamicDefaults() for cases where you don't call
        // addAutoChild directly.  It would be weird to do both, so we make sure it works, but
        // it's not as fast.
        if (dynamicDefaults != null && passedDynamicDefaults != null) {
            dynamicDefaults = isc.addProperties({}, dynamicDefaults, passedDynamicDefaults);
        } else {
            dynamicDefaults = passedDynamicDefaults || dynamicDefaults;
        }

        // standard name for defaults (eg bodyDefaults)
        var childDefaultsName = this._getDefaultsName(childName),
            childDefaults = this[childDefaultsName],
            childPropertiesName = this._getPropertiesName(childName),
            childProperties = this[childPropertiesName],
            // pass childDefaultsName so it doesn't have to be recalc'd
            childClassName = this.getAutoChildClass(childName, dynamicDefaults,
                                                    defaultConstructor, childDefaultsName, childPropertiesName),
            childClass = isc.ClassFactory.getClass(childClassName)
        ;
        if (childClass == null) {
            this.logWarn("Unable to create autoChild '"+childName
                         +"' of type '"+childClassName+"' - no such class in runtime.");
            return null;
        }
       
        var child = childClass.createRaw();
        
        // autoPassthroughs: mechanism for declaring that certain properties on an autoParent
        // should be passed-through to the same-named properties on children
        // DO NOT USE, this will probably be renamed
        var passthroughs = this.autoPassthroughs,
            passthroughValues,
            undef;
        if (passthroughs) {
            for (var propName in passthroughs) {                
                var targetChildName = passthroughs[propName];
                if (childName == targetChildName && this[propName] !== undef) {
                    child[propName] = this[propName];
                }
            }
        }

        this.applyBaseDefaults(child, childName, passedDynamicDefaults);

        isc.addProperties(child,
                          this.autoChildDefaults,
                          childDefaults, 
                          passthroughValues,
                          dynamicDefaults);

        // call configure methods if available.  These allow maximum speed dynamicDefaults
        // through direct property assignment on the half-created autoChild.  Different
        // autoChildren can be quickly identified (eg child == this.newButton), and sharing
        // defaults across different autoChildren is easier.  These APIs are very advanced
        // because caller needs to understand the half-initialized "raw" state.
        
        if (assignToSlot) this[childName] = child;
        if (child.autoConfigure) child.autoConfigure(this, childName);
        if (this.configureAutoChild) this.configureAutoChild(child, childName);
        isc.addProperties(child, this[childPropertiesName]);

        child.init();
        return child;
    },

    
    _completeCreationWithDefaults : function (childName, child, dynamicDefaults) {
        this.applyBaseDefaults(child, childName, dynamicDefaults);

        var childDefaultsName = this._getDefaultsName(childName),
            childPropertiesName = this._getPropertiesName(childName)
        ;

        child.completeCreation(
            // defaults for all named children
            this.autoChildDefaults,
            // instance defaults (for skinning) (eg bodyDefaults)
            this[childDefaultsName],
            // dynamic defaults
            dynamicDefaults,
            // user-provided instance properties
            this[childPropertiesName]
        );
    },

    // parents of named children can be declared as a map "autoChildParentMap" from child name
    // to parent name, on the assumption the parent is also a named child.
    _getAutoChildParentName : function (childName) {
        var parentMap = this.autoChildParentMap;
        if (parentMap) return parentMap[childName];
    },

    getAutoChildParent : function (childName) {
        var parentName = this._getAutoChildParentName(childName);
        if (parentName) return this[parentName];
        return this;
    },

    // set a named child: normally, just evaluates or re-evaluates the show flag in order to create
    // or destroy the component.  Can also be used to replace a named child with a specified
    // component.
    setAutoChild : function (childName, dynamicProperties) {
        
        if (!this.shouldCreateChild(childName)) {
            if (this[childName]) this[childName].destroy();
            // clear our pointer to the destroyed child
            delete this[childName];
        } else {
            // If we're passed a widget, apply it directly (unless shouldCreateChild() returns 
            // false in which case we ignore the widget) 
            if (isc.isA.Canvas(dynamicProperties)) {
                var child = dynamicProperties;
                // set the child to a custom-provided widget
                if (this[childName]) this[childName].destroy();
                this[childName] = child;
                this._addToParent(childName, child);
                return;
            }

            return this.addAutoChild(childName, dynamicProperties);
        }
    },

    

	//>	@method	class.map()
	//
    // Call <code>method</code> on each item in <code>argsList</code> and return the Array of results.
    //
	//	@param	methodName (string)	
    //      Name of the method on this instance which should be called on each element of the Array
	//	@param	items      (Array)	
    //      Array of items to call the method on 
    //
	//	@return            (Array) Array of results, one per element in the passed "items" Array
	// @visibility external
    //<
    map : isc.Class.map,
    
	//>	@method	class.Super()
	//
	//	Call the SuperClass implementation of a particular method.  
	//
	//	@param methodName   (string)	name of the superclass method to call
	//	@param args         (arguments or Array) native "arguments" object, or array of
    //                                           arguments to pass to the Super call
	//	@param [nativeArgs] (arguments) native "arguments" object, required if an Array is
    //                                  passed for the "args" parameter in lieue of the native
    //                                  arguments object
    //
	//	@return					(any)		return value of the superclass call
	//
	// @visibility external
	//<
	//	@param 	[nativeArguments] (Arguments) native "arguments" object.  Required only if
    //                                        calling Super() with a substitute set of
    //                                        arguments
    Super : isc.Class.Super,
    invokeSuper : isc.Class.invokeSuper

});

// NOTE: toString functions CANNOT be added by addMethods, because a property named "toString"
// will not be enumerated by for..in.  This is actually part of the ECMAScript standard!

//>	@classMethod	Class.toString()
//
//  The default toString() for a ClassObject reports that you have a ClassObject and what class
//  it is.
// @visibility external
//<
isc.Class.toString = function () {
    return "[Class " + this.Class + "]";
}

//>	@method	class.toString()
//
//  The default toString() for instances reports that you have an instance of a class and prints
//  the instance ID if present.
// @visibility external
//<
isc.Class.getPrototype().toString = function () {
    return "[" + this.Class + " ID:" + this.ID + "]";
}

//
//  Add Class properties (useful static properties to be referenced by other code)
//
isc.Class.addClassProperties({
    

    // make the isc namespace available on all Class objects
    ns : isc,

    //>	@classAttr  Class.NO_OP	(function : {} : IA)
    //      An empty (no-op) function.  Used as a default setting for event 
    //      handlers to allow observation to occur.
    //      Added as a class constant rather than class method, since this will not be directly
    //      called on the Class object (as in "Class.NO_OP()"), so does not need the logic
    //      usually required for methods.
    //      
    // @group	events
    // 
    //<
    NO_OP : function() {},
    
    //>	@classAttr  Class._stringMethodRegistry (object : {} : IA)
    //      This object is a map of method names to strings of arguments.
    //      It serves a dual purpose
    //      1 - Any properties listed in here are instance methods of this class which can legally
    //          be assigned string values to eval.
    //      2 - Allows you to get at the set of parameter names used in the string value (for
    //          converting the string to a function).
    //      
    //<
    _stringMethodRegistry : {}

});     // END isc.Class addClassProperties()

//
// add the observation methods to the ClassFactory as well so we can use 'em there
//
isc.addMethods(isc.ClassFactory, {
	observe : isc.Class.getPrototype().observe, 
	ignore : isc.Class.getPrototype().ignore,
	_makeNotifyFunction : isc.Class.getPrototype()._makeNotifyFunction
});

//> @classMethod isc.eval()
// Evaluate a string of script and return the result. Falls through to
// +link{classMethod:Class.evaluate(),Class.evaluate()}
//
// @param expression (string) Expression to evaluate
// @return (any) Result of evaluating the expression passed in
// @visibility external
//<
// Note: this differs from a straight call to the native eval function in that you lose scope.
// You can workaround this by using the instance method 'evaluate()', and passing in a mapping
// of variable names to values to be available when the string executes.
 
isc.eval = function (expression) {
    return isc.Class.evaluate(expression);
}




